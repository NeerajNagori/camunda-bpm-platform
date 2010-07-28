/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.activiti.cycle;

import java.util.Map;
import java.util.logging.Logger;

/**
 * The file action defines an action you can execute upon a file / artifact
 * normally depending on the {@link ArtifactType}.
 * 
 * An action can have a GUI representation (e.g. a showing a picture may result
 * in an own web site being opened, showing it in the default panel or doing
 * nothing). THIS IS CURRENTLY UNDER CONSTRUCTION.
 * 
 * And it can have come functionality to do something with the file. Idea: Could
 * this be maybe implemented as some kind of pipeline, where the file can be
 * transformed in multiple steps and somewhere ends in a last action which cares
 * about the GUI representation?
 * 
 * @author bernd.ruecker@camunda.com
 */
public abstract class ArtifactAction {

  private RepositoryArtifact file;
  private String status;

  protected static Logger log = Logger.getLogger(ArtifactAction.class.getName());
  
  /**
   * The list of options (still under development): *
   * <tr>
   * <td>DEFAULT_PANE: Something is shown in the default panel in the GUI (e.g.
   * a PNG)</td>
   * <td>OWN_WINDOW: Something is opened in a own Browser window (e.g. Signavio
   * Modeler)</td>
   * <td>NONE: The action doesn't need any GUI (e.g. writing something to SVN)</td>
   * <td>MODAL_PANEL: The action does need additional parameters from the user</td>
   * </tr>
   */
  public abstract String getGuiRepresentation();

  /**
   * execute this action on the file.
   */
  public abstract void execute();

  /**
   * execute this action on the file with an additional fileInfo object.
   */
  public abstract void execute(RepositoryNode itemInfo);

  /**
   * execute this action on the file with an additional fileInfo object and a
   * parameter list
   */
  public abstract void execute(RepositoryNode itemInfo, Map<String, Object> param);

  // /**
  // * returns a {@link List} of {@link FileType}s for which this action can be
  // executed.
  // *
  // * TODO: Think of maybe moving this to a Annotation?
  // */
  // public abstract List<FileType> getApplicableFileTypes();

  public abstract String getName();

  /**
   * empty method in superclass, overwrite if you need to return text content /
   * strings etc.
   * 
   * Will be escaped in GUI.
   */
  public String getGuiRepresentationContent() {
    return null;
  }

  /**
   * empty method in superclass, overwrite if you need to return HTML content
   * for the main panel.
   * 
   * Will be treated as HTML and will NOT be escaped.
   */
  public String getGuiRepresentationHtmlSnippet() {
    return null;
  }

  /**
   * empty method in superclass, overwrite if you need to return a URL you want
   * to be opened in a new window.
   */
  public String getGuiRepresentationUrl() {
    return null;
  }

  public RepositoryArtifact getFile() {
    return file;
  }

  public void setFile(RepositoryArtifact file) {
    this.file = file;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
