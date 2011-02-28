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
package jo.intellij.plugin.encoding;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * Actions are registered in this class, not in configuration file <code>plugin.xml</xml>.
 */
public class PluginRegistrationComponent implements ApplicationComponent {
// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface BaseComponent ---------------------

    /**
     * Registration of actions into edit menu.
     */
    @Override
    public void initComponent() {
        ActionManager actionManager = ActionManager.getInstance();
        Base64DecodeAction base64DecodeAction = new Base64DecodeAction();
        actionManager.registerAction(base64DecodeAction.getName(), base64DecodeAction);
        Base64EncodeAction base64EncodeAction = new Base64EncodeAction();
        actionManager.registerAction(base64EncodeAction.getName(), base64EncodeAction);

        DefaultActionGroup actionGroup = new DefaultActionGroup("Encode/Decode", true);
        actionManager.registerAction(actionGroup.toString(), actionGroup);
        actionGroup.add(base64DecodeAction);
        actionGroup.add(base64EncodeAction);

        DefaultActionGroup editMenu = (DefaultActionGroup) actionManager.getAction("EditMenu");
        editMenu.add(actionGroup);
    }

    @Override
    public void disposeComponent() {
    }

// --------------------- Interface NamedComponent ---------------------


    /**
     * Returns the component name.
     *
     * @return Component name
     */
    @Override
    @NotNull
    public String getComponentName() {
        return "Encoding Plugin RegistrationComponent";
    }
}
