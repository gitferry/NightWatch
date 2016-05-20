package com.example.keleger.nightswatch.dummy;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.example.keleger.nightswatch.MyApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add some sample items.
        PackageManager pm = MyApplication.getContext().getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (int index = 0; index < packages.size(); index++)
        {
            ApplicationInfo appinfo = packages.get(index);
            String appName = pm.getApplicationLabel(appinfo).toString();
            addItem(createDummyItem(index, appName, appinfo.packageName));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int id, String appName, String packageName) {
        return new DummyItem(String.valueOf(id), appName, packageName);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String name;
        public final String id;
        public final String packageName;

        public DummyItem(String id, String name, String packageName) {
            this.id = id;
            this.name = name;
            this.packageName = packageName;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
