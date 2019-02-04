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
package org.eclipse.che.ide.client.promises;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.che.api.promises.client.Function;
import org.eclipse.che.api.promises.client.Operation;
import org.eclipse.che.api.promises.client.OperationException;
import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.api.promises.client.PromiseError;

/**
 * Mockito mock provider for Che Promise objects.
 *
 * @author David Festal
 */
public class PromiseMocker<T> {
  private final Promise<T> promise;

  public PromiseMocker(Promise<T> promise) {
    this.promise = promise;
  }

  @SuppressWarnings("unchecked")
  public PromiseMocker() {
    this.promise = (Promise<T>) mock(Promise.class);
  }

  public Promise<T> getPromise() {
    return promise;
  }

  public <B> PromiseMocker<T> applyOnThenPromise(T value) {
    when(promise.thenPromise(org.mockito.ArgumentMatchers.<Function<T, Promise<B>>>any()))
        .then(
            new FunctionAnswer<Function<T, Promise<B>>, Promise<B>>(
                function -> {
                  try {
                    return function.apply(value);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                  return null;
                }));
    return this;
  }

  public <B> PromiseMocker<T> applyOnThenFunction(T value) {
    when(promise.then(org.mockito.ArgumentMatchers.<Function<T, B>>any()))
        .then(
            new FunctionAnswer<Function<T, B>, Promise<T>>(
                function -> {
                  try {
                    function.apply(value);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                  return promise;
                }));
    return this;
  }

  public PromiseMocker<T> applyOnThenOperation(T value) {
    when(promise.then(org.mockito.ArgumentMatchers.<Operation<T>>any()))
        .then(
            new FunctionAnswer<Operation<T>, Promise<T>>(
                op -> {
                  try {
                    op.apply(value);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                  return promise;
                }));
    return this;
  }

  public PromiseMocker<T> applyOnCatchErrorOperation(PromiseError error) {
    when(promise.catchError(org.mockito.ArgumentMatchers.<Operation<PromiseError>>any()))
        .then(
            new FunctionAnswer<Operation<PromiseError>, Promise<T>>(
                op -> {
                  try {
                    op.apply(error);
                  } catch (OperationException e) {
                    e.printStackTrace();
                  }
                  return promise;
                }));
    return this;
  }
}
