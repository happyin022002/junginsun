/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostAccrualBCImpl.java
*@FileTitle : CostAccrualBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sac.costaccrual.costaccrual.basic;


import com.clt.apps.opus.stm.sac.costaccrual.costaccrual.integration.CostAccrualDBDAO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.APManualInvoiceAccuralCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * CostAccrualBCImpl <br>
 * - CostAccrual Business Logic implementation
 * 
 * @author 
 * @see CostAccrualSC 참조
 * @since J2EE 1.4
 */

public class CostAccrualBCImpl extends BasicCommandSupport implements CostAccrualBC {	

	// Database Access Object
	private transient CostAccrualDBDAO dbDao = null;

	/**
	 * StatementCommonBCImpl object creation<br>
	 * StatementCommonDBDAO creation<br>
	 */
	public CostAccrualBCImpl() {
		dbDao = new CostAccrualDBDAO();
	}
	
	//manageInvoiceApprovalInfo
	//managePaymentInvSkd
	/**
	 * [STM_SAP_0150]
	 * manageInvoiceAccrualInfo(AccrualInterface) <br>
	 *
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception EventException
	 */
	public void manageInvoiceAccrualSacInfo(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws EventException {

		try {
			
			String gl_yymm = "";
			String estmseqno = "";
			
			if (aPManualInvoiceAccuralCondVO != null ) {
				gl_yymm = aPManualInvoiceAccuralCondVO.getGlYymm();
				
				estmseqno = dbDao.searchInvoiceAccrualNumberCheck(gl_yymm);
				aPManualInvoiceAccuralCondVO.setEstmSeqNo(estmseqno);
				
				dbDao.addAPManulInvoiceAccrual(aPManualInvoiceAccuralCondVO);
			}
			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * [STM_SAP_0150]
	 * removeInvoiceAccrualSacInfo(AccrualInterface) <br>
	 *
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception EventException
	 */
	public void removeInvoiceAccrualSacInfo(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws EventException {

		try {
			
			dbDao.removeAPManulInvoiceAccrual(aPManualInvoiceAccuralCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

}
