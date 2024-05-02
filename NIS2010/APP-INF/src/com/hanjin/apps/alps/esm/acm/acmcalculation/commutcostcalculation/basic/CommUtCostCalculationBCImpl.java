/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationBCImpl.java
*@FileTitle : FACCommCalculationBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.05
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.05 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.commutcostcalculation.basic;

import com.hanjin.apps.alps.esm.acm.acmcalculation.commutcostcalculation.integration.CommUtCostCalculationDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-FACCalculation Business Logic Command Interface<br>
 * - ALPS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Young-Oh
 * @see Esm_Acm_0012EventResponse 참조
 * @since J2EE 1.6
 */
public class CommUtCostCalculationBCImpl extends BasicCommandSupport implements CommUtCostCalculationBC {

	// Database Access Object
	private transient CommUtCostCalculationDBDAO dbDao = null;

	/**
	 * CmcostCalculationBCImpl 객체 생성<br>
	 * CmcostCalculationnDBDAO 생성한다.<br>
	 */
	public CommUtCostCalculationBCImpl() { 
		dbDao = new CommUtCostCalculationDBDAO();
	}
	
	
	/**
	 * ACM_COMM_UT_COST_PRC 프로시져 호출한다.<br>
	 * 
	 * @param String pctl_no
	 * @param String usr_id
	 * @return int
	 * @exception EventException
	 */
	public int createCommUtCostCalculation(String pctl_no, String usr_id) throws EventException{
		String returnStr = "";
		int returnNo = 0;
		try {
			if (!pctl_no.equals("") || !usr_id.equals("")) {
				returnStr = dbDao.createCommUtCostCalculation(pctl_no, usr_id);
			}
				if (returnStr == null || returnStr.equals("")) {
					returnNo = 0;
				} else {
					returnNo = Integer.parseInt(returnStr);
				}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnNo;
	}
}