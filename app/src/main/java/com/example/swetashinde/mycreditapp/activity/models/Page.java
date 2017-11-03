package com.example.swetashinde.mycreditapp.activity.models;

/**
 * Created by swetashinde on 11/3/17.
 */

public class Page {

    private int pageNumber;
    private int skipToPage;
    private boolean isSkippable;
    private Class fragmentClass; // this will hold the class to be instantiated
    private boolean fragmentPrevInfo;

    // should be skipped ??? logic be involved here ??

    public Page(int pageNumber, int skipToPage, boolean isSkippable, Class fragmentClass) {
        this.pageNumber = pageNumber;
        this.skipToPage = skipToPage;
        this.isSkippable = isSkippable;
        this.fragmentClass = fragmentClass;
    }

    public Page(int pageNumber, int skipToPage, boolean isSkippable, Class fragmentClass,boolean fragmentPrevInfo) {
        this.pageNumber = pageNumber;
        this.skipToPage = skipToPage;
        this.isSkippable = isSkippable;
        this.fragmentClass = fragmentClass;
        this.fragmentPrevInfo = fragmentPrevInfo;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getSkipToPage() {
        return skipToPage;
    }

    public void setSkipToPage(int skipToPage) {
        this.skipToPage = skipToPage;
    }

    public boolean isSkippable() {
        return isSkippable;
    }

    public void setSkippable(boolean skippable) {
        isSkippable = skippable;
    }

    public Class getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class fragmentClass) {
        this.fragmentClass = fragmentClass;
    }
}
