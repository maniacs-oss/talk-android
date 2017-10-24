/*
 * Nextcloud Talk application
 *
 * @author Mario Danic
 * Copyright (C) 2017 Mario Danic
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.nextcloud.talk.utils.database.cache;

import com.nextcloud.talk.application.NextcloudTalkApplication;
import com.nextcloud.talk.dagger.modules.DatabaseModule;

import javax.inject.Inject;

import autodagger.AutoInjector;
import dagger.Module;
import dagger.Provides;
import io.requery.Persistable;
import io.requery.reactivex.ReactiveEntityStore;

@Module(includes = DatabaseModule.class)
@AutoInjector(NextcloudTalkApplication.class)
public class CacheModule {

    @Inject
    public CacheModule() {
    }

    @Provides
    public CacheUtils provideCacheUtils(ReactiveEntityStore<Persistable> dataStore) {
        return new CacheUtils(dataStore);
    }

}