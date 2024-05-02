package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import com.hanjin.framework.core.layer.integration.DAOException;

public interface ReceiveQueueMdmRejectCustBC {
	public boolean removeMDMTB(Object vo) throws DAOException;
}
