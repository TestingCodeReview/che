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
 * Container for the information necessary to create Choice dialog
 *
 * @author Roman Nikitenko
 */
@JsType
public class ChoiceDialogData extends DialogData {

  private String firstChoiceButtonText;
  private String secondChoiceButtonText;
  private String thirdChoiceButtonText;
  
  /** Returns the first choice button text. */
  public String getFirstChoiceButtonText() {
    return firstNonNull(firstChoiceButtonText, "");
  }
  
  /** Sets text for displaying by first choice button. */
  public void setFirstChoiceButtonText(String firstChoiceButtonText) {
    this.firstChoiceButtonText = firstChoiceButtonText;
  }

  /** Returns the second choice button text. */  
  public String getSecondChoiceButtonText() {
    return firstNonNull(secondChoiceButtonText, "");
  }
      
  /** Sets text for displaying by second choice button. */
  public void setSecondChoiceButtonText(String secondChoiceButtonText) {
    this.secondChoiceButtonText = secondChoiceButtonText;
  }
  
  /** Returns the third choice button text. */  
  public String getThirdChoiceButtonText() {
    return firstNonNull(thirdChoiceButtonText, "");
  }

  /** Sets text for displaying by third choice button. */
  public void setThirdChoiceButtonText(String thirdChoiceButtonText) {
    this.thirdChoiceButtonText = thirdChoiceButtonText;
  }
}
