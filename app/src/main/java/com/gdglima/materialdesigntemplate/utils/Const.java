package com.gdglima.materialdesigntemplate.utils;

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

        options.add(new OptionEntity("RecyclerView - Linear", "L", R.color.bg_green_2));
        options.add(new OptionEntity("RecyclerView - Staggered", "S", R.color.bg_sky_blue));
        options.add(new OptionEntity("RecyclerView - Grid", "G", R.color.indigo));
        options.add(new OptionEntity("Collapsing Toolbars", "C", R.color.green));
        options.add(new OptionEntity("Navigation View", "N", R.color.ambar));
        options.add(new OptionEntity("Tabs", "T", R.color.orange));
        options.add(new OptionEntity("Floating Action Button", "F", R.color.indigo));
        options.add(new OptionEntity("Floating labels for editing text", "E", R.color.green));
        options.add(new OptionEntity("Explode Animation", "A", R.color.deep_purple));
        options.add(new OptionEntity("Snack", "S", R.color.bg_orange));

        return options;
    }

}
