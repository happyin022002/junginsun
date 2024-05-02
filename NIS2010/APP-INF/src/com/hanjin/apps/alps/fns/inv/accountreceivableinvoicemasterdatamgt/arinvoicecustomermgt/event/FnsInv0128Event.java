/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0128Event.java
*@FileTitle : Bad Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ARInvoiceBadCustomerHistoryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0128 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0128HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9011620
 * @see FNS_INV_0128HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0128Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ARInvoiceBadCustomerHistoryVO arInvoiceBadCustomerHistoryVO = null;
	
	public FnsInv0128Event(){}


	/**
	 * @return
	 */
	public ARInvoiceBadCustomerHistoryVO getArInvoiceBadCustomerHistoryVO() {
		return arInvoiceBadCustomerHistoryVO;
	}


	/**
	 * @param arInvoiceBadCustomerHistoryVO
	 */
	public void setArInvoiceBadCustomerHistoryVO(
			ARInvoiceBadCustomerHistoryVO arInvoiceBadCustomerHistoryVO) {
		this.arInvoiceBadCustomerHistoryVO = arInvoiceBadCustomerHistoryVO;
	}
}