package com.pgu.news.domain;

public class NewsItem {
    private Long id;
    private String text;

    public NewsItem() {
        super();
    }

    public NewsItem(final Long id, final String text) {
        super();
        this.id = id;
        this.text = text;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NewsItem other = (NewsItem) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
