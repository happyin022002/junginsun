/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FnsInv0137Event.java
*@FileTitle : Customer Inquiry by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2013.09.24 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CustomerListByBLVO;


/**
 * FNS_INV_0137 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0137HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Okyoung Im
 * @see FNS_INV_0137HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0137Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/* Column Info */
	private String blNos = null;	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerListByBLVO customerListByBLVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerListByBLVO[] customerListByBLVOs = null;

	public FnsInv0137Event(){}
	
	public void setCustomerListByBLVO(CustomerListByBLVO customerListByBLVO){
		this. customerListByBLVO = customerListByBLVO;
	}

	public void setCustomerListByBLVOS(CustomerListByBLVO[] customerListByBLVOs){
		this. customerListByBLVOs = customerListByBLVOs;
	}

	public CustomerListByBLVO getCustomerListByBLVO(){
		return customerListByBLVO;
	}

	public CustomerListByBLVO[] getCustomerListByBLVOS(){
		return customerListByBLVOs;
	}
	
	public String getBlNos() {
		return blNos;
	}

	public void setBlNos(String blNos) {
		this.blNos = blNos;
	}

}