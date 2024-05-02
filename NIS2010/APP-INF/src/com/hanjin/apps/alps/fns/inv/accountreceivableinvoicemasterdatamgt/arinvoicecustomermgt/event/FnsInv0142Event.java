/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0142Event.java
*@FileTitle : Actual Payer Inquiry
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
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ActPayerVO;


/**
 * FNS_INV_0142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0142HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0142HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0142Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private String arOfcCd = null;
	private String userOfcCd = null;
	private String actCustCntCd = null;
	private String actCustSeq = null;


	public String getArOfcCd() {
		return arOfcCd;
	}
	
	public String getUserOfcCd() {
		return userOfcCd;
	}

	public String getActCustCntCd() {
		return actCustCntCd;
	}
	
	public String getActCustSeq() {
		return actCustSeq;
	}
	
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}

	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActPayerVO actPayerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActPayerVO[] actPayerVOs = null;

	public FnsInv0142Event(){}
	
	public void setActPayerVO(ActPayerVO actPayerVO){
		this. actPayerVO = actPayerVO;
	}

	public void setActPayerVOS(ActPayerVO[] actPayerVOs){
		if(actPayerVOs != null){
			ActPayerVO[] tmpVOs = new ActPayerVO[actPayerVOs.length];
			System.arraycopy(actPayerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.actPayerVOs = tmpVOs;
		}
	}

	public ActPayerVO getActPayerVO(){
		return actPayerVO;
	}

	public ActPayerVO[] getActPayerVOS(){
		ActPayerVO[] rtnVOs = null;
		if (this.actPayerVOs != null) {
			rtnVOs = new ActPayerVO[actPayerVOs.length];
			System.arraycopy(actPayerVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}