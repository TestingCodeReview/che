/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.api.git.shared;

import java.util.List;
import org.eclipse.che.dto.shared.DTO;

/** @author andrew00x */
@DTO
public interface MergeResult {
  public enum MergeStatus {
    FAST_FORWARD("Fast-forward"),
    ALREADY_UP_TO_DATE("Already up-to-date"),
    FAILED("Failed"),
    MERGED("Merged"),
    CONFLICTING("Conflicting"),
    NOT_SUPPORTED("Not-yet-supported");

    private final String value;

    private MergeStatus(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  /** @return head after the merge */
  String getNewHead();

  void setNewHead(String newHead);

  MergeResult withNewHead(String newHead);

  /** @return status of merge */
  MergeStatus getMergeStatus();

  void setMergeStatus(MergeStatus mergeStatus);

  MergeResult withMergeStatus(MergeStatus mergeStatus);

  /** @return list of merged commits or empty list if no commits where merged. */
  List<String> getMergedCommits();

  void setMergedCommits(List<String> mergedCommits);

  MergeResult withMergedCommits(List<String> mergedCommits);

  /** @return files that have conflicts or empty list if there are no conflicts. */
  List<String> getConflicts();

  void setConflicts(List<String> conflicts);

  MergeResult withConflicts(List<String> conflicts);

  /**
   * @return list of files that failed to merge (not files that have conflicts) or empty list if
   *     there are no failed files.
   */
  List<String> getFailed();

  void setFailed(List<String> failed);

  MergeResult withFailed(List<String> failed);
}
