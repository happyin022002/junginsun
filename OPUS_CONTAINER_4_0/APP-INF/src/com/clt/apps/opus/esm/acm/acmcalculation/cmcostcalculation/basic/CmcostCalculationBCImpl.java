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
package com.clt.apps.opus.esm.acm.acmcalculation.cmcostcalculation.basic;

import com.clt.apps.opus.esm.acm.acmcalculation.cmcostcalculation.integration.CmcostCalculationDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * OPUS-FACCalculation Business Logic Command Interface<br>
 * - OPUS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Young-Oh
 * @see Esm_Acm_0012EventResponse 참조
 * @since J2EE 1.6
 */
public class CmcostCalculationBCImpl extends BasicCommandSupport implements CmcostCalculationBC {

	// Database Access Object
	private transient CmcostCalculationDBDAO dbDao = null;

	/**
	 * CmcostCalculationBCImpl 객체 생성<br>
	 * CmcostCalculationnDBDAO 생성한다.<br>
	 */
	public CmcostCalculationBCImpl() {
		dbDao = new CmcostCalculationDBDAO();
	}


	/**
	 * ACM_COMM_UT_COST_PRC 프로시져 호출한다.<br>
	 *
	 * @param String pctl_no
	 * @param String usr_id
	 * @return int
	 * @exception EventException
	 */
	public int createCmcostCalculationnInfo(String pctl_no, String usr_id) throws EventException{
		String returnStr = "";
		int returnNo = 0;
		try {
			if (!pctl_no.equals("") || !usr_id.equals("")) {
				returnStr = dbDao.createCmcostCalculationnInfo(pctl_no, usr_id);
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