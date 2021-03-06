/*
 * (C) Copyright 2006-2010 Nuxeo SAS (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Nicolas Ulrich
 *
 */

// FIXME: plateforme -> platform
package org.nuxeo.ecm.plateform.jbpm.core.adapter;

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.adapter.DocumentAdapterFactory;
import org.nuxeo.ecm.platform.jbpm.TaskListImpl;

/**
 * @author nulrich
 */
public class TaskListAdapterFactory implements DocumentAdapterFactory {

    @Override
    @SuppressWarnings("rawtypes")
    public Object getAdapter(DocumentModel doc, Class clazz) {
        if (checkDocument(doc)) {
            return new TaskListImpl(doc);
        } else {
            // cannot be adapted
            return null;
        }
    }

    public static boolean checkDocument(DocumentModel doc) {
        if (!doc.hasSchema("taskList")) {
            throw new RuntimeException("Document should contain schema taskList");
        }
        return true;
    }

}
