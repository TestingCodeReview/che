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

package org.eclipse.che.ide.js.impl.dialog;

import com.google.gwt.dom.client.Element;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.che.ide.js.api.dialog.ConfirmAction;
import org.eclipse.che.ide.js.api.dialog.ConfirmDialogData;
import org.eclipse.che.ide.js.api.dialog.MessageDialogData;
import org.eclipse.che.ide.js.api.dialog.DialogManager;
import org.eclipse.che.ide.ui.ElementWidget;
import org.eclipse.che.ide.ui.dialogs.DialogFactory;

/** @author Roman Nikitenko */
@Singleton
public class JsDialogManager implements DialogManager {

  private DialogFactory dialogFactory;

  @Inject
  public JsDialogManager(DialogFactory dialogFactory) {
    this.dialogFactory = dialogFactory;
  }

    @Override
    public void displayMessageDialog(MessageDialogData dialogData, ConfirmAction confirmAction) {
        String title = dialogData.getTitle();
        String confirmButtonText = dialogData.getConfirmButtonText();
        Element contentElement = dialogData.getContentElement();

        if (contentElement != null) {
            dialogFactory
                    .createMessageDialog(title, new ElementWidget(dialogData.getContentElement()), confirmAction::performAction, confirmButtonText).show();
        } else {
            dialogFactory
                    .createMessageDialog(title, dialogData.getContent(), confirmAction::performAction, confirmButtonText).show();
        }
    }

    @Override
    public void displayConfirmDialog(ConfirmDialogData dialogData, ConfirmAction confirmAction) {
        String title = dialogData.getTitle();
        String confirmButtonText = dialogData.getConfirmButtonText();
        Element contentElement = dialogData.getContentElement();

        if (contentElement != null) {
            dialogFactory
                    .createMessageDialog(title, new ElementWidget(dialogData.getContentElement()), confirmAction::performAction, confirmButtonText).show();
        } else {
            dialogFactory
                    .createMessageDialog(title, dialogData.getContent(), confirmAction::performAction, confirmButtonText).show();
        }
    }
}
