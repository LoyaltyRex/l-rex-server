package org.loyaltyrex.server.core.rest.view;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * Represents a link, with a descriptive tag
 * 
 * @author nickavv
 * @since 0.1.0
 */
public final class LinkView {

    @JsonProperty(value = "rel", required = true)
    private final String rel;

    @JsonProperty(value = "href", required = true)
    private final String href;

    public LinkView(String rel, String href) {
        this.rel = Objects.requireNonNull(rel);
        this.href = Objects.requireNonNull(href);
    }

    /**
     * @return The relational link name, a description of what it is a link to
     * @since 0.1.0
     */
    public String getRel() {
        return rel;
    }

    /**
     * @return The href of the link
     * @since 0.1.0
     */
    public String getHref() {
        return href;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("rel", rel)
                .add("href", href)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(rel, href);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof LinkView) {
            LinkView compare = (LinkView) obj;

            result = Objects.equals(compare.getRel(), getRel())
                    && Objects.equals(compare.getHref(), getHref());
        }

        return result;
    }

}
