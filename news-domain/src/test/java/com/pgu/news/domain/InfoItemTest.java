package com.pgu.news.domain;

import org.junit.Assert;
import org.junit.Test;

public class InfoItemTest {

    @Test
    public void checkEquals() {
        // given
        final NewsItem i1 = new NewsItem(99L, "text");
        final NewsItem i2 = new NewsItem(null, "text...");
        // when
        i2.setId(i1.getId());
        // then
        Assert.assertTrue(i1.equals(i2));

        // when
        i2.setId(null);
        // then
        Assert.assertTrue(!i1.equals(i2));
    }

    @Test
    public void checkHashcode() {
        // given
        final NewsItem i1 = new NewsItem(99L, "text");
        final NewsItem i2 = new NewsItem(null, "text...");

        // when
        i2.setId(i1.getId());
        // then
        Assert.assertEquals(i1.hashCode(), i2.hashCode());

        // when
        i2.setId(null);
        // then
        Assert.assertTrue(i1.hashCode() != i2.hashCode());
    }

}
