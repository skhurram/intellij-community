/*
 *  Copyright 2000-2007 JetBrains s.r.o.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.jetbrains.plugins.groovy.lang.psi.impl.statements.typedef.members;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.blocks.GrOpenBlock;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.typedef.members.GrMethod;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.params.GrParameter;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.GrConstructorInvocation;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.GrStatement;
import org.jetbrains.plugins.groovy.lang.psi.impl.GroovyPsiElementImpl;
import org.jetbrains.plugins.groovy.lang.psi.impl.statements.params.GrParameterListImpl;
import org.jetbrains.plugins.groovy.lang.psi.impl.statements.blocks.GrConstructorBodyImpl;

/**
 * @author: Dmitry.Krasilschikov
 * @date: 26.03.2007
 */
//todo remove
public class GrConstructorDefinitionImpl extends GrMethodDefinitionImpl implements GrMethod {
  public GrConstructorDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public String toString() {
    return "Constructor";
  }

  public boolean isConstructor() {
    return true;
  }

  @Nullable
  public GrConstructorInvocation getConstructorInvocation() {
    GrOpenBlock body = getBlock();
    assert body != null;

    GrStatement[] grStatements = body.getStatements();

    if (grStatements != null && grStatements.length > 0 && grStatements[0] instanceof GrConstructorInvocation) {
      return (GrConstructorInvocation) grStatements[0];
    }

    return null;
  }
}
