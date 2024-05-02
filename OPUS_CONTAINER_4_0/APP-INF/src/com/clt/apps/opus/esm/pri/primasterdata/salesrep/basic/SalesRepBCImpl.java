/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRepBCImpl.java
*@FileTitle : Sales Rep Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.salesrep.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.salesrep.integration.SalesRepDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmSlsRepVO;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author 
 * @see ESM_PRI_4022EventResponse,SalesRepBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class SalesRepBCImpl extends BasicCommandSupport implements SalesRepBC {

	// Database Access Object
	private transient SalesRepDBDAO dbDao = null;

	/**
	 * creating SalesRepBCImpl object<br>
	 * creating SalesRepDBDAO.<br>
	 */
	public SalesRepBCImpl() {
		dbDao = new SalesRepDBDAO();
	}
	/**
	 * Retrieving Sales Rep List<br>
	 * 
	 * @param MdmSlsRepVO mdmSlsRepVO
	 * @return List<MdmSlsRepVO>
	 * @exception EventException
	 */
	public List<MdmSlsRepVO> searchSalesRepList(MdmSlsRepVO mdmSlsRepVO) throws EventException {
		try {
			return dbDao.searchSalesRepList(mdmSlsRepVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
}