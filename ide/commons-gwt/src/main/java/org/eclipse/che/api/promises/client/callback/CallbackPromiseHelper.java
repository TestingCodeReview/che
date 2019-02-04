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
package org.eclipse.che.api.promises.client.callback;

import com.google.gwt.core.client.Callback;
import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.api.promises.client.js.Executor;
import org.eclipse.che.api.promises.client.js.JsPromiseError;
import org.eclipse.che.api.promises.client.js.Promises;
import org.eclipse.che.api.promises.client.js.RejectFunction;
import org.eclipse.che.api.promises.client.js.ResolveFunction;

/**
 * Helps to create a {@link Promise} from a {@link Callback}.
 *
 * @author Mickaël Leduque
 * @author Artem Zatsarynnyi
 */
public final class CallbackPromiseHelper {

  private CallbackPromiseHelper() {}

  public static <T> Promise<T> createFromCallback(final Call<T, Throwable> call) {
    final Executor.ExecutorBody<T> body =
        new Executor.ExecutorBody<T>() {
          @Override
          public void apply(final ResolveFunction<T> resolve, final RejectFunction reject) {
            call.makeCall(new LocalCallback<T>(resolve, reject));
          }
        };
    final Executor<T> executor = Executor.create(body);
    return Promises.create(executor);
  }

  public interface Call<T, F> {
    void makeCall(Callback<T, F> callback);
  }

  private static class LocalCallback<T> implements Callback<T, Throwable> {

    private ResolveFunction<T> resolve;
    private RejectFunction reject;

    private LocalCallback(final ResolveFunction<T> resolve, final RejectFunction reject) {
      this.resolve = resolve;
      this.reject = reject;
    }

    @Override
    public void onSuccess(final T result) {
      this.resolve.apply(result);
    }

    @Override
    public void onFailure(final Throwable reason) {
      this.reject.apply(JsPromiseError.create(reason));
    }
  }
}
