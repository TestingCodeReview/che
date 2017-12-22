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

/**
 * Manager for creating and displaying Message, Confirm, Input and Choice dialogs.
 *
 * @author Roman Nikitenko
 */

@JsType
public interface DialogManager {
  /**
   * Display a Message dialog which contains some text and .
   *
   * @param dialogData data for creating message dialog
   * @param okButtonClickedHandler the handler used when user clicks on confirm button
   */
  void displayMessageDialog(MessageDialogData dialogData, ClickButtonHandler confirmButtonClickedHandler);

  void displayConfirmDialog(ConfirmDialogData dialogData, ClickButtonHandler confirmButtonClickedHandler, ClickButtonHandler cancelButtonClickedHandler);
  
  void displayInputDialog(InputDialogData dialogData, ClickButtonHandler confirmButtonClickedHandler, ClickButtonHandler cancelButtonClickedHandler);
  
  void displayChoiceDialog(ChoiceDialogData dialogData, ClickButtonHandler firstButtonClickedHandler, ClickButtonHandler secondButtonClickedHandler, ClickButtonHandler thirdButtonClickedHandler);
}
