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

@JsType
public interface DialogManager {
  void displayMessageDialog(MessageDialogData dialogData, ConfirmAction confirmAction);

  void displayConfirmDialog(ConfirmDialogData dialogData, ConfirmAction confirmAction);

//  @JsMethod(name = "displayMessageDialogWithElementContent")
//  void displayMessageDialog(String title, Element content, ConfirmAction confirmAction);

}
