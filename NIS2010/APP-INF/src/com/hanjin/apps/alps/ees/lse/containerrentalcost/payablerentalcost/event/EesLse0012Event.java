/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0012Event.java
*@FileTitle : Rental payable invoice inquiry and Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.08 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalInvoiceCostVO;


/**
 * EES_LSE_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PayableRentalInvoiceCostVO payableRentalInvoiceCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOs = null;

	public EesLse0012Event(){}
	
	public void setPayableRentalInvoiceCostVO(PayableRentalInvoiceCostVO payableRentalInvoiceCostVO){
		this. payableRentalInvoiceCostVO = payableRentalInvoiceCostVO;
	}

	public void setPayableRentalInvoiceCostVOS(PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOs){
		this. payableRentalInvoiceCostVOs = payableRentalInvoiceCostVOs;
	}

	public PayableRentalInvoiceCostVO getPayableRentalInvoiceCostVO(){
		return payableRentalInvoiceCostVO;
	}

	public PayableRentalInvoiceCostVO[] getPayableRentalInvoiceCostVOS(){
		return payableRentalInvoiceCostVOs;
	}

}