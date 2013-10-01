/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2013 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.core.component;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.database.model.ResourceModel;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;
import org.sonar.api.resources.Scopes;

public final class ComponentKeys {

  private ComponentKeys() {
    // only static stuff
  }

  public static String createKey(Project project, Resource resource) {
    String key = resource.getKey();
    if (!StringUtils.equals(Scopes.PROJECT, resource.getScope())) {
      // not a project nor a library
      key = new StringBuilder(ResourceModel.KEY_SIZE)
        .append(project.getKey())
        .append(':')
        .append(resource.getKey())
        .toString();
    }
    return key;
  }

}
