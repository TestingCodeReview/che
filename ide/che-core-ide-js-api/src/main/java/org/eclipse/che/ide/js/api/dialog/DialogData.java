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

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsType;

import static com.google.common.base.MoreObjects.firstNonNull;

/**
 * Container for the information necessary to create dialog
 *
 * @author Roman Nikitenko
 */
@JsType
public class DialogData {

  private String title;
  private String content;
  private Element contentElement;

  public String getTitle() {
    return firstNonNull(title, "");
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return firstNonNull(content, "");
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Element getContentElement() {
    return contentElement;
  }

  public void setContentElement(Element contentElement) {
    this.contentElement = contentElement;
  }
}
