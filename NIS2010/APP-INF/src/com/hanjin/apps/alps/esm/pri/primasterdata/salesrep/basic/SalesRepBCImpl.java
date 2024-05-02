/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRepBCImpl.java
*@FileTitle : Sales Rep Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.integration.SalesRepDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;

/**
 * ALPS-PRIMasterData Business Logic Basic Command implementation<br>
 * - ALPS-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4022EventResponse,SalesRepBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SalesRepBCImpl extends BasicCommandSupport implements SalesRepBC {

	// Database Access Object
	private transient SalesRepDBDAO dbDao = null;

	/**
	 * SalesRepBCImpl 객체 생성<br>
	 * SalesRepDBDAO를 생성한다.<br>
	 */
	public SalesRepBCImpl() {
		dbDao = new SalesRepDBDAO();
	}
	/**
	 * Sales Rep List를 조회합니다. <br>
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