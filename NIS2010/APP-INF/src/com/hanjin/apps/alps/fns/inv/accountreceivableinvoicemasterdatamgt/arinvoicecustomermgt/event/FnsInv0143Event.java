/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0143Event.java
*@FileTitle : Auto Invoice Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.19 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AutoInvCustomerVO;


/**
 * FNS_INV_0143 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0143HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0143HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0143Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	  
	private String arOfcCd = null;
	private String ioBndCd = null;
	private String userOfcCd = null;
	private String actCustCntCd = null;
	private String actCustSeq = null;
		


	public String getActCustCntCd() {
		return actCustCntCd;
	}

	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}

	public String getActCustSeq() {
		return actCustSeq;
	}

	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	public String getIoBndCd() {
		return ioBndCd;
	}

	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	public String getUserOfcCd() {
		return userOfcCd;
	}

	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AutoInvCustomerVO autoInvCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AutoInvCustomerVO[] autoInvCustomerVOs = null;

	public FnsInv0143Event(){}
	
	public void setAutoInvCustomerVO(AutoInvCustomerVO autoInvCustomerVO){
		this. autoInvCustomerVO = autoInvCustomerVO;
	}

	public void setAutoInvCustomerVOS(AutoInvCustomerVO[] autoInvCustomerVOs){
		if(autoInvCustomerVOs != null){
			AutoInvCustomerVO[] tmpVOs = new AutoInvCustomerVO[autoInvCustomerVOs.length];
			System.arraycopy(autoInvCustomerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.autoInvCustomerVOs = tmpVOs;
		}
	}

	public AutoInvCustomerVO getAutoInvCustomerVO(){
		return autoInvCustomerVO;
	}

	public AutoInvCustomerVO[] getAutoInvCustomerVOS(){
		AutoInvCustomerVO[] rtnVOs = null;
		if (this.autoInvCustomerVOs != null) {
			rtnVOs = new AutoInvCustomerVO[autoInvCustomerVOs.length];
			System.arraycopy(autoInvCustomerVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}