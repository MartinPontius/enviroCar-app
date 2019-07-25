/**
 * Copyright (C) 2013 - 2019 the enviroCar community
 *
 * This file is part of the enviroCar app.
 *
 * The enviroCar app is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The enviroCar app is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with the enviroCar app. If not, see http://www.gnu.org/licenses/.
 */
package org.envirocar.app.main;


import android.app.Activity;
import android.content.Context;

import com.mapbox.mapboxsdk.Mapbox;

import org.envirocar.app.views.OthersFragment;
import org.envirocar.app.views.dashboard.DashBoardFragment;
import org.envirocar.app.views.tracklist.TrackListPagerFragment;
import org.envirocar.core.injection.InjectActivityScope;
import org.envirocar.core.injection.InjectApplicationScope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * TODO JavaDoc
 *
 * @author dewall
 */
@Module
public class MainActivityModule {

    private Activity mActivity;

    /**
     * Constructor
     *
     * @param activity the activity of this scope.
     */
    public MainActivityModule(Activity activity) {
        this.mActivity = activity;
    }


    @Provides
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @InjectActivityScope
    public Context provideContext() {
        return mActivity;
    }

    @Provides
    public DashBoardFragment provideDashBoardFragment(){
        return new DashBoardFragment();
    }

    @Provides
    public TrackListPagerFragment provideTrackListPagerFragment(){
        return new TrackListPagerFragment();
    }

    @Provides
    public OthersFragment provideOthersFragment(){
        return new OthersFragment();
    }

    @Provides
    public Mapbox provideMapBox() {
        return Mapbox.getInstance(mActivity, "");
    }

}
