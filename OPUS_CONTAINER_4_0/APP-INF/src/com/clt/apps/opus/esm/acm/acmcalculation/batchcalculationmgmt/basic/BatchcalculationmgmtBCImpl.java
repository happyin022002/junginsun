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
package com.clt.apps.opus.esm.acm.acmcalculation.batchcalculationmgmt.basic;

import com.clt.apps.opus.esm.acm.acmcalculation.batchcalculationmgmt.integration.BatchcalculationmgmtDBDAO;
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
public class BatchcalculationmgmtBCImpl extends BasicCommandSupport implements BatchcalculationmgmtBC {

	// Database Access Object
	private transient BatchcalculationmgmtDBDAO dbDao = null;

	/**
	 * CmcostCalculationBCImpl 객체 생성<br>
	 * CmcostCalculationnDBDAO 생성한다.<br>
	 */
	public BatchcalculationmgmtBCImpl() {
		dbDao = new BatchcalculationmgmtDBDAO();
	}


	/**
	 * ACM_COMM_UT_COST_PRC 프로시져 호출한다.<br>
	 *
	 * @param String bkg_no
	 * @param String usr_id
	 * @exception EventException
	 */
	public void manageCalculationBatchList(String bkg_no, String usr_id) throws EventException{
		try {

			if (!bkg_no.equals("") || !usr_id.equals("")) {
				dbDao.addCalculationBatchList(bkg_no, usr_id);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}