/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.flavor;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * {@link FlavorActivity} shows a list of Android platform releases.
 * For each release, display the name, version number, and image.
 */
public class FlavorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavor);

        // Create an ArrayList of AndroidFlavor objects
        final ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();
        androidFlavors.add(new AndroidFlavor("Wikipedia", "Encyclopedia", R.drawable.wikipedia));
        androidFlavors.add(new AndroidFlavor("Wikinews", "Open Journalism", R.drawable.wikinews));
        androidFlavors.add(new AndroidFlavor("Wikitionary", "Dictionary", R.drawable.wiktionary));
        androidFlavors.add(new AndroidFlavor("Wikibooks", "Textbooks", R.drawable.wikibooks));
        androidFlavors.add(new AndroidFlavor("Wikiquote", "Quotations", R.drawable.wikiquotes));
        androidFlavors.add(new AndroidFlavor("Wikispecies", "Species Dictionary", R.drawable.wikispecies));
        androidFlavors.add(new AndroidFlavor("Wikiversity", "Learning Tools", R.drawable.wikiversity));
        androidFlavors.add(new AndroidFlavor("Wikivoyage", "Travel Guides", R.drawable.wikivoyage));
        androidFlavors.add(new AndroidFlavor("Wikisource", "Source Texts", R.drawable.wikisource));
        androidFlavors.add(new AndroidFlavor("Wikidata", "Knowledge Base", R.drawable.wikidata));
        androidFlavors.add(new AndroidFlavor("Meta-Wiki", "Coordination", R.drawable.metawiki));
        androidFlavors.add(new AndroidFlavor("Mediawiki", "Wiki Software Development", R.drawable.mediawiki));

        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        AndroidFlavorAdapter flavorAdapter = new AndroidFlavorAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);

        // Check for click
        // From: https://www.includehelp.com/android/List-view-setOnItemClickListener.aspx
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FlavorActivity.this, androidFlavors.get(position).getVersionName()+"", Toast.LENGTH_LONG).show();
            }

        });


    }

}

