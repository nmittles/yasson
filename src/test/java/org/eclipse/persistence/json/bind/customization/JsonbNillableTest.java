/*******************************************************************************
 * Copyright (c) 2016 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * Roman Grigoriadi
 ******************************************************************************/

package org.eclipse.persistence.json.bind.customization;

import org.eclipse.persistence.json.bind.customization.model.JsonbNillableClassSecondLevel;
import org.eclipse.persistence.json.bind.customization.model.JsonbNillableOverriddenWithJsonbProperty;
import org.eclipse.persistence.json.bind.customization.model.JsonbNillableOverridesClass;
import org.eclipse.persistence.json.bind.customization.model.JsonbNillableOverridesInterface;
import org.eclipse.persistence.json.bind.customization.model.JsonbNillableValue;
import org.eclipse.persistence.json.bind.customization.model.packagelevelannotations.JsonbNillablePackageLevel;
import org.eclipse.persistence.json.bind.customization.model.packagelevelannotations.PackageLevelOverridenWithClassLevel;
import org.junit.Before;
import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import static org.junit.Assert.assertEquals;

/**
 * Tests a {@link javax.json.bind.annotation.JsonbNillable} annotation.
 * @author Roman Grigoriadi
 */
public class JsonbNillableTest {

    private Jsonb jsonb;

    @Before
    public void setUp() throws Exception {
        jsonb = JsonbBuilder.create();
    }

    @Test
    public void testJsonbNillable() {
        JsonbNillableValue pojo = new JsonbNillableValue();
        assertEquals("{\"nillableField\":null}", jsonb.toJson(pojo));
    }

    @Test
    public void testJsonbNillableOverridenWithJsonbProperty() {
        JsonbNillableOverriddenWithJsonbProperty pojo = new JsonbNillableOverriddenWithJsonbProperty();
        assertEquals("{}", jsonb.toJson(pojo));
    }

    @Test
    public void testPackageLevelNillable() {
        JsonbNillablePackageLevel pojo = new JsonbNillablePackageLevel();
        assertEquals("{\"packageLevelNillableField\":null}", jsonb.toJson(pojo));
    }

    @Test
    public void testPackageLevelOverridenWithClassLevel() {
        PackageLevelOverridenWithClassLevel pojo = new PackageLevelOverridenWithClassLevel();
        assertEquals("{}", jsonb.toJson(pojo));
    }

    /**
     * Tests inheritance of annotations from interfaces.
     * @throws Exception
     */
    @Test
    public void testNillableInheritFromInterface() throws Exception {
        JsonbNillableClassSecondLevel pojo = new JsonbNillableClassSecondLevel();
        assertEquals("{\"classNillable\":null}", jsonb.toJson(pojo));
    }

    @Test
    public void testInheritanceOverride() throws Exception {
        JsonbNillableOverridesInterface overridesInterface = new JsonbNillableOverridesInterface();
        assertEquals("{}", jsonb.toJson(overridesInterface));

        JsonbNillableOverridesClass overridesClass = new JsonbNillableOverridesClass();
        assertEquals("{\"overridesNillableInParent\":null}", jsonb.toJson(overridesClass));
    }

}
