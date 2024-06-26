/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0090Event.java
*@FileTitle : RFA Customer Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.05 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;


/**
 * FNS_INV_0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0090HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0090Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriCustomerListVO priCustomerListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriCustomerListVO[] priCustomerListVOs = null;
	
	private String rfaNo	= null;

	public FnsInv0090Event(){}
	
	public void setPriCustomerListVO(PriCustomerListVO priCustomerListVO){
		this. priCustomerListVO = priCustomerListVO;
	}

	public void setPriCustomerListVOS(PriCustomerListVO[] priCustomerListVOs){
		this. priCustomerListVOs = priCustomerListVOs;
	}

	public PriCustomerListVO getPriCustomerListVO(){
		return priCustomerListVO;
	}

	public PriCustomerListVO[] getPriCustomerListVOS(){
		return priCustomerListVOs;
	}

	/**
	 * @return the rfaNo
	 */
	public String getRfaNo() {
		return rfaNo;
	}

	/**
	 * @param rfaNo the rfaNo to set
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	
	
}