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
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event;

import java.util.Arrays;
import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

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
	private static final long serialVersionUID = 1L;
	
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
		if (invNo != null) {
			String[] tmpVOs = Arrays.copyOf(invNo, invNo.length);
			this.invNo = tmpVOs;
		} // end if
	}
	public String[] getInv_no()
	{
		String[] rtnVOs = null;
		if (this.invNo != null) {
			rtnVOs = Arrays.copyOf(this.invNo, this.invNo.length);
		} // end if
		return rtnVOs;
	}
	
	public void setFlag(String[] flag)
	{
		if (flag != null) {
			String[] tmpVOs = Arrays.copyOf(flag, flag.length);
			this.flag = tmpVOs;
		} // end if
	}
	public String[] getFlag()
	{
		String[] rtnVOs = null;
		if (this.flag != null) {
			rtnVOs = Arrays.copyOf(this.flag, this.flag.length);
		} // end if
		return rtnVOs;
	}
	
	public void setInv_vndr_seq(String[] vndrSeq)
	{
		if (vndrSeq != null) {
			String[] tmpVOs = Arrays.copyOf(vndrSeq, vndrSeq.length);
			this.vndrSeq = tmpVOs;
		} // end if
	}
	public String[] getInv_vndr_seq()
	{
		String[] rtnVOs = null;
		if (this.vndrSeq != null) {
			rtnVOs = Arrays.copyOf(this.vndrSeq, this.vndrSeq.length);
		} // end if
		return rtnVOs;
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