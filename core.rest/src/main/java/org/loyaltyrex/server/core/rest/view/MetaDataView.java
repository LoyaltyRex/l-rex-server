package org.loyaltyrex.server.core.rest.view;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nullable;

import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * Represents meta data that should be present on all API responses
 * 
 * @author nickavv
 * @since 0.1.0
 */
public final class MetaDataView {

    @JsonProperty(value = "href", required = false)
    private final String href;

    @JsonProperty(value = "allowed", required = true)
    private final List<HttpMethod> allowed;

    @JsonProperty(value = "links", required = true)
    private final List<LinkView> links;

    /**
     * @param href
     *            A reference to the resource associated with this metadata
     * @param allowed
     *            A list of HTTP methods that the current user is allowed to perform on this resource
     * @param links
     *            A list of links to related or relevant resources
     */
    public MetaDataView(String href, List<HttpMethod> allowed, List<LinkView> links) {
        this.href = href;
        this.allowed = Objects.requireNonNull(allowed);
        this.links = Objects.requireNonNull(links);
    }

    /**
     * @return The reference to the resource associated with this metadata
     * @since 0.1.0
     */
    @Nullable
    public String getHref() {
        return href;
    }

    /**
     * @return The list of HTTP methods that the current user is allowed to perform on this resource
     * @since 0.1.0
     */
    public List<HttpMethod> getAllowed() {
        return allowed;
    }

    /**
     * @return The list of links to related or relevant resources
     * @since 0.1.0
     */
    public List<LinkView> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("href", href)
                .add("allowed", allowed)
                .add("links", links)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, allowed, links);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof MetaDataView) {
            MetaDataView compare = (MetaDataView) obj;

            result = Objects.equals(compare.getHref(), getHref())
                    && Objects.equals(compare.getAllowed(), getAllowed())
                    && Objects.equals(compare.getLinks(), getLinks());
        }

        return result;
    }

}
