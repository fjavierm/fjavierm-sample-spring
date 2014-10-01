/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ua.jtech.clienteDailymotion.modelo;

/**
 *
 * @author especialista
 */
public class Video {
    private String id;
    private String title;
    private String[] tags;
    private String url;
    private String thumbnail_medium_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getThumbnail_medium_url() {
        return thumbnail_medium_url;
    }

    public void setThumbnail_medium_url(String thumbnail_medium_url) {
        this.thumbnail_medium_url = thumbnail_medium_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
