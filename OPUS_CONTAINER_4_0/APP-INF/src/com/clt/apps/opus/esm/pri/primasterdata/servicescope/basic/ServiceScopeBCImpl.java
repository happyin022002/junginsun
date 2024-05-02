/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceScopeBCImpl.java
*@FileTitle : Service Scope Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.servicescope.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.servicescope.integration.ServiceScopeDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.CstSvcScpVO;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLaneVO;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLmtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmSvcScpVO;

/**
 * PRIMasterData Business Logic Command Interface<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author 
 * @see Esm_pri_4017EventResponse
 * @since J2EE 1.6
 */
public class ServiceScopeBCImpl extends BasicCommandSupport implements ServiceScopeBC {

	// Database Access Object
	private transient ServiceScopeDBDAO dbDao = null;

	/**
	 * Creating ServiceScopeBCImpl Object <br>
	 * Creating ServiceScopeDBDAO.<br>
	 */
	public ServiceScopeBCImpl() {
		dbDao = new ServiceScopeDBDAO();
	}
	
	/**
	 * Retrieving Service Spope List<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<MdmSvcScpVO>
	 * @exception EventException
	 */
	public List<MdmSvcScpVO> searchServiceScopeList(CstSvcScpVO cstSvcScpVO) throws EventException {
		try {
			return dbDao.searchServiceScopeList(cstSvcScpVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Retrieving Service Spope Lane List<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<RsltMdmSvcScpLaneVO>
	 * @exception EventException
	 */
	public List<RsltMdmSvcScpLaneVO> searchServiceScopeLaneList(CstSvcScpVO cstSvcScpVO) throws EventException {
		try {
			return dbDao.searchServiceScopeLaneList(cstSvcScpVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Retrieving Service Spope Origin Destination List<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<RsltMdmSvcScpLmtVO>
	 * @exception EventException
	 */
	public List<RsltMdmSvcScpLmtVO> searchServiceScopeOriginDestinationList(CstSvcScpVO cstSvcScpVO) throws EventException {
		try {
			return dbDao.searchServiceScopeOriginDestinationList(cstSvcScpVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Retrieving Service Spope Code List<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return String
	 * @exception EventException
	 */
	public String checkCodeValue(CstSvcScpVO cstSvcScpVO) throws EventException {
		try {
			return dbDao.checkCodeValue(cstSvcScpVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		
	}
}