package org.smv.smvguide.rest.models;

/**
 * Created by root on 12/5/16.
 */
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Results {
/*
    public String[] tags;

    public String featured_media;

    //public Excerpt excerpt;

    public String format;

    public String date;

    public String modified_gmt;

    public String type;

    public String meta;

    public String modified;

    public String id;
*/

    public Acf acf;

    public Acf getAcf() {
        return acf;
    }

    public void setAcf(Acf acf) {
        this.acf = acf;
    }

    public Content content;

    public Content getContent ()
    {
        return content;
    }

    public Title title;

    public Title getTitle ()
    {
        return title;
    }

    @ParcelConstructor
    public Results(Acf acf, Content content, Title title) {
        this.acf = acf;
        this.content = content;
        this.title = title;
    }

    /*public String author;

    public String sticky;

    public String date_gmt;

    public String[] categories;

    public String ping_status;

    public String slug;

    public String[] getTags ()
    {
        return tags;
    }

    public void setTags (String[] tags)
    {
        this.tags = tags;
    }

    public String getFeatured_media ()
    {
        return featured_media;
    }

    public void setFeatured_media (String featured_media)
    {
        this.featured_media = featured_media;
    }

    public String getFormat ()
    {
        return format;
    }

    public void setFormat (String format)
    {
        this.format = format;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getModified_gmt ()
    {
        return modified_gmt;
    }

    public void setModified_gmt (String modified_gmt)
    {
        this.modified_gmt = modified_gmt;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getMeta ()
    {
        return meta;
    }

    public void setMeta (String meta)
    {
        this.meta = meta;
    }

    public String getModified ()
    {
        return modified;
    }

    public void setModified (String modified)
    {
        this.modified = modified;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Content getContent ()
    {
        return content;
    }

    public void setContent (Content content)
    {
        this.content = content;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getSticky ()
    {
        return sticky;
    }

    public void setSticky (String sticky)
    {
        this.sticky = sticky;
    }


    public void setTitle (Title title)
    {
        this.title = title;
    }

    public String getDate_gmt ()
    {
        return date_gmt;
    }

    public void setDate_gmt (String date_gmt)
    {
        this.date_gmt = date_gmt;
    }

    public String[] getCategories ()
    {
        return categories;
    }

    public void setCategories (String[] categories)
    {
        this.categories = categories;
    }

    public String getPing_status ()
    {
        return ping_status;
    }

    public void setPing_status (String ping_status)
    {
        this.ping_status = ping_status;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }*/

/*    @Override
    public String toString()
    {
        return "ClassPojo [tags = "+tags+", featured_media = "+featured_media+", excerpt = "+excerpt+", comment_status = "+comment_status+", link = "+link+", _links = "+_links+", format = "+format+", date = "+date+", modified_gmt = "+modified_gmt+", type = "+type+", meta = "+meta+", modified = "+modified+", id = "+id+", guid = "+guid+", content = "+content+", author = "+author+", sticky = "+sticky+", title = "+title+", date_gmt = "+date_gmt+", categories = "+categories+", ping_status = "+ping_status+", slug = "+slug+"]";
    }*/
}