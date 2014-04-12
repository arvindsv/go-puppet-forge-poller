/**
 * Go Forge Poller
 * Copyright (C) 2014 drrb
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Go Forge Poller. If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.drrb;

import com.thoughtworks.go.plugin.api.material.packagerepository.Property;
import com.thoughtworks.go.plugin.api.material.packagerepository.RepositoryConfiguration;
import io.github.drrb.forge.Forge;
import org.junit.Before;
import org.junit.Test;

import static io.github.drrb.ForgePollerPluginConfig.FORGE_URL;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ForgeFactoryTest {

    private ForgeFactory forgeFactory;

    @Before
    public void setUp() throws Exception {
        forgeFactory = new ForgeFactory();
    }

    @Test
    public void shouldBuildForge() throws Exception {
        RepositoryConfiguration repoConfig = new RepositoryConfiguration();
        repoConfig.add(new Property(FORGE_URL, "http://forge.example.com"));
        Forge forge = forgeFactory.build(repoConfig);
        assertThat(forge.getUrl(), is("http://forge.example.com"));
    }
}
