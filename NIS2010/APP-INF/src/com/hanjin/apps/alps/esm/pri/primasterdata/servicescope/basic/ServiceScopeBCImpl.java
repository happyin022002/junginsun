/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceScopeBCImpl.java
*@FileTitle : Service Scope Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.07 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.integration.ServiceScopeDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.CstSvcScpVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLaneVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;

/**
 * ALPS-PRIMasterData Business Logic Command Interface<br>
 * - ALPS-PRIMasterData에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4017EventResponse 참조
 * @since J2EE 1.6
 */
public class ServiceScopeBCImpl extends BasicCommandSupport implements ServiceScopeBC {

	// Database Access Object
	private transient ServiceScopeDBDAO dbDao = null;

	/**
	 * ServiceScopeBCImpl 객체 생성<br>
	 * ServiceScopeDBDAO를 생성한다.<br>
	 */
	public ServiceScopeBCImpl() {
		dbDao = new ServiceScopeDBDAO();
	}
	
	/**
	 * Service Spope List를 조회합니다.<br>
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
	 * Service Spope Lane List를 조회합니다.<br>
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
	 * Service Spope Origin Destination List를 조회합니다.<br>
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
	 * Service Spope Code List를 조회합니다.<br>
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