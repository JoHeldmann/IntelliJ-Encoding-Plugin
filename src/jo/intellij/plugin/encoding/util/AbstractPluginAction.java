/*
 * Copyright 2011 Joachim Heldmann
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
package jo.intellij.plugin.encoding.util;

import com.intellij.openapi.actionSystem.AnAction;

import javax.swing.*;

/**
 * Abstract class for plugin actions with {@linkplain #name} and
 * {@linkplain #description} properties.
 */
public abstract class AbstractPluginAction extends AnAction {
// ------------------------------ FIELDS ------------------------------

    private String name;
    private String description;

// --------------------------- CONSTRUCTORS ---------------------------

    /**
     * Constructor.
     *
     * @param name        Name
     * @param description Description
     * @param icon        Icon (if available)
     */
    protected AbstractPluginAction(String name, String description, Icon icon) {
        super(name, description, icon);
        this.name = name;
        this.description = description;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    /**
     * Returns the description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}
