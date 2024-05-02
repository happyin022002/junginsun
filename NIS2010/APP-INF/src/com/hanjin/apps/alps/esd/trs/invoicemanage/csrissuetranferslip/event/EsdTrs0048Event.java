/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_048Event.java
*@FileTitle : Invoice List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0 
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event;

import java.util.HashMap;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0048Event extends EventSupport {

	// searchInvoiceListInquiry와 동일한 dao 메소드 사용하여 to be version으로 일부 수정됨. 추가 수정 필요!! 20090817 kys 
	private HashMap hashParam = new HashMap();
	private String invNo[] ;
	private String flag[] ;
	private String vndrSeq[];
	private String csrNo = "";
	private String usrId = "";
	private String costOfcCd = "";
	
	public String getUsrId() {
		return usrId;
	}


	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}


	public String getCostOfcCd() {
		return costOfcCd;
	}


	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}


	public EsdTrs0048Event(){}

	
	public HashMap getHashParam(){
		return this.hashParam;
	}
	
	public void setInv_no(String[] invNo)
	{
		this.invNo = invNo;
	}
	public String[] getInv_no()
	{
		return this.invNo;
	}
	
	public void setFlag(String[] flag)
	{
		this.flag = flag;
	}
	public String[] getFlag()
	{
		return this.flag;
	}
	
	public void setInv_vndr_seq(String[] vndrSeq)
	{
		this.vndrSeq = vndrSeq;
	}
	public String[] getInv_vndr_seq()
	{
		return this.vndrSeq;
	}
	
	/**
	 * @return the csrNo
	 */
	public String getCsrNo() {
		return csrNo;
	}

	/**
	 * @param csrNo the csrNo to set
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	
	public String getEventName() {
		return "EsdTrs0048Event";
	}

	public String toString() {
		return "EsdTrs0048Event";
	}
}