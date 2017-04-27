package org.smv.smvguide.rest.models;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by root on 12/5/16.
 */

@Parcel
public class Content
{
    //public String protected;

    public String rendered;

/*    public String getProtected ()
    {
        return protected;
    }*/

/*    public void setProtected (String protected)
    {
        this.protected = protected;
    }*/

    public String getRendered ()
    {
        return rendered;
    }

    public void setRendered (String rendered)
    {
        this.rendered = rendered;
    }

/*    @Override
    public String toString()
    {
        return "ClassPojo [protected = "+protected+", rendered = "+rendered+"]";
    }*/
    @ParcelConstructor
    public Content(String rendered) {
        this.rendered = rendered;
    }
}