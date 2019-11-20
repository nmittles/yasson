/*
 * Copyright (c) 2016, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

package org.eclipse.yasson.internal.serializer;

import javax.json.bind.serializer.JsonbSerializer;

import org.eclipse.yasson.internal.model.JsonbPropertyInfo;

/**
 * Object serializer provider.
 */
public class ObjectSerializerProvider implements ContainerSerializerProvider {

    @Override
    public JsonbSerializer<?> provideSerializer(JsonbPropertyInfo propertyInfo) {
        return new ObjectSerializer<>(propertyInfo.getWrapper(), propertyInfo.getRuntimeType(), propertyInfo.getClassModel());
    }
}