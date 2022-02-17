/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.istic.taa.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import fr.istic.taa.jaxrs.rest.FicheGitResource;
import fr.istic.taa.jaxrs.rest.FicheResource;
import fr.istic.taa.jaxrs.rest.FichebugResource;
import fr.istic.taa.jaxrs.rest.SectionsResource;
import fr.istic.taa.jaxrs.rest.SwaggerResource;
import fr.istic.taa.jaxrs.rest.TableauResource;
import fr.istic.taa.jaxrs.rest.TagsResource;
import fr.istic.taa.jaxrs.rest.Usersresource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(Usersresource.class);
        clazzes.add(OpenApiResource.class);
        clazzes.add(SwaggerResource.class);
        clazzes.add(FicheResource.class);
        clazzes.add(FicheGitResource.class);
        clazzes.add(FichebugResource.class);
        clazzes.add(SectionsResource.class);
        clazzes.add(TableauResource.class);
        clazzes.add(TagsResource.class);

        return clazzes;
    }

}
