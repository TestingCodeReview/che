/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */

package org.eclipse.che.ide.js.api.dialog;

import jsinterop.annotations.JsType;

import static com.google.common.base.MoreObjects.firstNonNull;

/**
 * Container for the information necessary to create Input dialog
 *
 * @author Roman Nikitenko
 */
@JsType
public class InputDialogData extends ConfirmDialogData {

  private String initialText;
  private Integer selectionStartIndex;
  private Integer selectionLenght;
    
    /** Returns text used to initialize the input. */
  public String getInitialText() {
    return firstNonNull(initialText, "");
  }
    
    /** Sets text to initialize the input. */
  public void setInitialText(String initialText) {
    this.initialText = initialText;
  }
  
    /** Returns the beginning index of the initial text to select, inclusive. */
  public Integer getSelectionStartIndex() {
    return firstNonNull(selectionStartIndex, 0);
  }
    
    /** Sets the beginning index of the initial text to select, inclusive. */
  public void setSelectionStartIndex(Integer selectionStartIndex) {
    this.selectionStartIndex = selectionStartIndex;
  }
  
  /** Returns the number of characters to be selected in the input. */
 public Integer getSelectionLength() {
    return firstNonNull(selectionLenght, 0);
  }
    
    /** Sets the number of characters to be selected in the input. */
  public void setSelectionLength(Integer selectionLenght) {
    this.selectionLenght = selectionLenght;
  }
}
