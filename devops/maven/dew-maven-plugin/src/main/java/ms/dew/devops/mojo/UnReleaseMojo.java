/*
 * Copyright 2019. the original author or authors.
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

package ms.dew.devops.mojo;

import io.kubernetes.client.ApiException;
import ms.dew.devops.kernel.flow.unrelease.DefaultUnReleaseFlow;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.IOException;

/**
 * Un-release mojo.
 *
 * @author gudaoxuri
 */
@Mojo(name = "unrelease")
public class UnReleaseMojo extends BasicMojo {

    @Override
    protected boolean executeInternal() throws IOException, ApiException {
        return new DefaultUnReleaseFlow().exec(getMojoName());
    }

}