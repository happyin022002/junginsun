/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0015Event.java
*@FileTitle : Customer Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.21 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerListVO;


/**
 * FNS_INV-0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV-0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV-0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0015Event extends EventSupport {
	
	public String getCustFlag() {
		return custFlag;
	}

	public void setCustFlag(String custFlag) {
		this.custFlag = custFlag;
	}

	public String getCustRlseCtrlFlg() {
		return custRlseCtrlFlg;
	}

	public void setCustRlseCtrlFlg(String custRlseCtrlFlg) {
		this.custRlseCtrlFlg = custRlseCtrlFlg;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getUsrOfcCd() {
		return usrOfcCd;
	}

	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}

	private String custFlag = null;
	private String custRlseCtrlFlg = null;
	private String ofcCd = null;
	private String usrOfcCd = null;	
	
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerListVO customerListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerListVO[] customerListVOs = null;

	public FnsInv0015Event(){}
	
	public void setCustomerListVO(CustomerListVO customerListVO){
		this. customerListVO = customerListVO;
	}

	public void setCustomerListVOS(CustomerListVO[] customerListVOs){
		this. customerListVOs = customerListVOs;
	}

	public CustomerListVO getCustomerListVO(){
		return customerListVO;
	}

	public CustomerListVO[] getCustomerListVOS(){
		return customerListVOs;
	}

}