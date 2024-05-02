/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostAccrualBC.java
*@FileTitle : CostAccrualBC
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sac.costaccrual.costaccrual.basic;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.APManualInvoiceAccuralCondVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * CostAccrualBC <br>
 * - CostAccrual Business Logic implementation
 * 
 * @author 
 * @see CostAccrualSC 참조
 * @since J2EE 1.4
 */
	
public interface CostAccrualBC {
	
	/**
	 * [STM_SAP_0150]
	 * manageInvoiceAccrualInfo(AccrualInterface) <br>
	 *
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception EventException
	 */
	public void manageInvoiceAccrualSacInfo(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws EventException;
	
	/**
	 * [STM_SAP_0150]
	 * removeInvoiceAccrualSacInfo(AccrualInterface) <br>
	 *
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception EventException
	 */
	public void removeInvoiceAccrualSacInfo(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws EventException;
	
}
