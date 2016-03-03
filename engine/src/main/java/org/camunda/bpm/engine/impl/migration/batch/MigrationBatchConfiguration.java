/* Licensed under the Apache License, Version 2.0 (the "License");
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

package org.camunda.bpm.engine.impl.migration.batch;

import java.util.List;

import org.camunda.bpm.engine.migration.MigrationPlan;

public class MigrationBatchConfiguration {

  protected MigrationPlan migrationPlan;
  protected List<String> processInstanceIds;

  public MigrationPlan getMigrationPlan() {
    return migrationPlan;
  }

  public void setMigrationPlan(MigrationPlan migrationPlan) {
    this.migrationPlan = migrationPlan;
  }

  public List<String> getProcessInstanceIds() {
    return processInstanceIds;
  }

  public void setProcessInstanceIds(List<String> processInstanceIds) {
    this.processInstanceIds = processInstanceIds;
  }


}
