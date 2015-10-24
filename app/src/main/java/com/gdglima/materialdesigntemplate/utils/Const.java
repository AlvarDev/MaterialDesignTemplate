package com.gdglima.materialdesigntemplate.utils;

import android.content.Context;

import com.gdglima.materialdesigntemplate.R;
import com.gdglima.materialdesigntemplate.entities.OptionEntity;

import java.util.ArrayList;
import java.util.List;

public class Const {

    public static final int RV_LINEAR = 0;
    public static final int RV_STAGGERED = 1;
    public static final int RV_GRID = 2;
    public static final int COLLAPSING_TOOLBAR = 3;
    public static final int NAV_VIEW = 4;
    public static final int TABS = 5;
    public static final int F_ACTION_BUTON = 6;
    public static final int F_EDIT_TEXT = 7;
    public static final int EXPLODE_ANIMATION = 8;
    public static final int SNACK = 9;

    public static List<OptionEntity> getOptionsDashboard(){
        List<OptionEntity> options = new ArrayList<OptionEntity>();

        options.add(new OptionEntity("RecyclerView - Linear", R.drawable.ioe1));
        options.add(new OptionEntity("RecyclerView - Staggered", R.drawable.ioe2));
        options.add(new OptionEntity("RecyclerView - Grid", R.drawable.ioe3));
        options.add(new OptionEntity("Collapsing Toolbars", R.drawable.ioe4));
        options.add(new OptionEntity("Navigation View", R.drawable.ioe5));
        options.add(new OptionEntity("Tabs", R.drawable.ioe6));
        options.add(new OptionEntity("Floating Action Button", R.drawable.ioe7));
        options.add(new OptionEntity("Floating labels", R.drawable.ioe8));
        options.add(new OptionEntity("Explode Animation", R.drawable.ioe9));
        options.add(new OptionEntity("Snack", R.drawable.ioe10));

        return options;
    }

}
