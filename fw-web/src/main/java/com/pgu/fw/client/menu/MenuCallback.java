package com.pgu.fw.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.pgu.fw.client.util.JSONHelper;
import com.pgu.fw.client.util.StringHelper;

public class MenuCallback implements RequestCallback {

    private final MenuBuilder menuBuilder;
    private final String baseUrl;
    private final EventBus eventBus;

    public MenuCallback(final String baseUrl, final MenuBuilder menuBuilder, final EventBus eventBus) {
        this.menuBuilder = menuBuilder;
        this.baseUrl = baseUrl;
        this.eventBus = eventBus;
    }

    @Override
    public void onResponseReceived(final Request request, final Response response) {

        if (Response.SC_OK == response.getStatusCode()) {
            menuBuilder.incResponseReceived();
            GWT.log(response.getText());

            final JSONArray menus = getMenusFromResponse(response);

            for (int i = 0, n = menus.size(); i < n; i++) {
                final JSONObject menu = getMenu(i, menus);

                // the menu must have a rank
                final int rank = JSONHelper.toInt(menu.get("rank"));

                // then get its entries
                final Widget stackHeader = getStackHeader(menu);
                final Tree stackBody = new Tree();
                setEntries(menu, null, stackBody);

                // stock the menu in the builder for future aggregation with the others
                menuBuilder.put(rank, stackHeader, stackBody);
            }

        } else {
            menuBuilder.incResponseReceived();
            GWT.log("Something's wrong: response status: " + response.getStatusCode());
        }
    }

    @Override
    public void onError(final Request request, final Throwable exception) {
        menuBuilder.incResponseReceived();
        GWT.log("onError of callback..." + exception.getMessage());
    }

    private static JSONObject getMenu(final int idx, final JSONArray menus) {
        final JSONObject menu = JSONHelper.toObject(menus.get(idx));
        if (!menu.containsKey("entries")) {
            throw new IllegalArgumentException("There must be at least one entry!");
        }
        return menu;
    }

    private Widget getStackHeader(final JSONObject menu) {
        final String headerTitle = JSONHelper.toString(menu.get("title"));
        final String headerImg = JSONHelper.toString(menu.get("img"));
        return new SimplePanel(createEntryPanel(headerTitle, headerImg));
    }

    private static JSONArray getMenusFromResponse(final Response response) {
        final JSONValue t = JSONParser.parseStrict(response.getText());
        //
        // checks if this is an array of stack entries or only one entry
        JSONArray menus = t.isArray();
        if (null == menus) {
            menus = new JSONArray();
            final JSONObject menu = t.isObject();
            if (null == menu) {
                throw new IllegalArgumentException("The menu is not valid! " + t.toString());
            }
            menus.set(0, menu);
        }
        return menus;
    }

    private void setEntries(final JSONObject currLvlJSON, final TreeItem currLvlTree, final Tree mainTree) {

        if (currLvlJSON.containsKey("entries")) {
            final JSONArray entries = JSONHelper.toArray(currLvlJSON.get("entries"));

            for (int j = 0, n = entries.size(); j < n; j++) {
                final JSONObject entry = JSONHelper.toObject(entries.get(j));

                final String title = JSONHelper.toString(entry.get("title"));
                final String img = JSONHelper.toString(entry.get("img"));
                final MenuEntry entryPanel = createEntryPanel(title, img);

                if (!entry.containsKey("entries")) { // leaf case
                    final String contentUrl = JSONHelper.toString(entry.get("url"));
                    if (StringHelper.isBlank(contentUrl)) {
                        throw new IllegalArgumentException("A leaf must contain a url!" + entry);
                    }
                    entryPanel.setContentUrl(baseUrl + contentUrl);
                }

                TreeItem tmp = null;
                if (null == currLvlTree) {
                    tmp = mainTree.addItem(entryPanel);
                } else {
                    tmp = currLvlTree.addItem(entryPanel);
                }
                tmp.setState(true);
                setEntries(entry, tmp, mainTree);
            }
        }
    }

    private MenuEntry createEntryPanel(final String html, final String imageUrl) {
        return new MenuEntry(html, baseUrl + imageUrl, eventBus);
    }
}
