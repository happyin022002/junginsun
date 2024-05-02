/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceLaneBCImpl.java
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.servicelane.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.servicelane.integration.ServiceLaneDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author
 * @see ESM_PRI_4012EventResponse,ServiceLaneBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class ServiceLaneBCImpl extends BasicCommandSupport implements ServiceLaneBC {

	// Database Access Object
	private transient ServiceLaneDBDAO dbDao = null;

	/**
	 * Creating ServiceLaneBCImpl object<br>
	 * Creating ServiceLaneDBDAO.<br>
	 */
	public ServiceLaneBCImpl() {
		dbDao = new ServiceLaneDBDAO();
	}
	/**
	 * Retrieving Lane Code <br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchServiceLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.searchServiceLaneList(mdmVslSvcLaneVO);
		} catch (DAOException ex) {
		    throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
		    throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
}