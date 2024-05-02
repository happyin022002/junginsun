/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerBCImpl.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.04.29 김재연
* 1.0 Creation
* =========================================================
* History
* 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.customer.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.customer.integration.CustomerDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.customer.vo.MdmCustVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4014EventResponse,CustomerBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CustomerBCImpl extends BasicCommandSupport implements CustomerBC {

	// Database Access Object
	private transient CustomerDBDAO dbDao = null;

	/**
	 * CustomerBCImpl 객체 생성<br>
	 * CustomerDBDAO를 생성한다.<br>
	 */
	public CustomerBCImpl() {
		dbDao = new CustomerDBDAO();
	}
	/**
	 *  Customer List를 조회합니다. <br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception EventException
	 */
	public List<MdmCustVO> searchCustomerList(MdmCustVO mdmCustVO) throws EventException {
		try {
			return dbDao.searchCustomerList(mdmCustVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  Group Customer List를 조회합니다. <br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception EventException
	 */
	public List<MdmCustVO> searchGroupCustomerList(MdmCustVO mdmCustVO) throws EventException {
		try {
			return dbDao.searchGroupCustomerList(mdmCustVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}