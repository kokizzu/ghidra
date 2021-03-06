/* ###
 * IP: GHIDRA
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
package ghidra.app.plugin.core.codebrowser.hover;

import ghidra.app.CorePluginPackage;
import ghidra.app.plugin.PluginCategoryNames;
import ghidra.framework.plugintool.*;
import ghidra.framework.plugintool.util.PluginStatus;

/**
 * A plugin to show tool tip text for a function signature
 */
//@formatter:off
@PluginInfo(
	status = PluginStatus.RELEASED,
	packageName = CorePluginPackage.NAME,
	category = PluginCategoryNames.CODE_VIEWER,
	shortDescription = "Shows formatted tool tip text over function signatures",
	description = "This plugin extends the functionality of the code browser by adding a "
			+ "\tooltip\" over function signaturefields in Listing.",
	servicesProvided = { ListingHoverService.class }
)
//@formatter:on
public class FunctionSignatureListingHoverPlugin extends Plugin {

	private FunctionSignatureListingHover functionSignatureHover;

	public FunctionSignatureListingHoverPlugin(PluginTool tool) {
		super(tool);
		functionSignatureHover = new FunctionSignatureListingHover(tool);
		registerServiceProvided(ListingHoverService.class, functionSignatureHover);
	}

	@Override
	protected void dispose() {
		functionSignatureHover.dispose();
	}
}
