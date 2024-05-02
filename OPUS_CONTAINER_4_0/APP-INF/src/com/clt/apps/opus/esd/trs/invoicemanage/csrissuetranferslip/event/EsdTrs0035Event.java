/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_025Event.java
*@FileTitle : Transfer Slip 관리
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

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TES_025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0035Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private String[] invNo; 
	private String[] invVndrSeq;
	private String[] invAmt;
	private String[] vatAmt;
	private String[] totalAmt;
	private String[] trspInvAudStsCd;
	public EsdTrs0035Event(){}

	
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
	
	public void setInv_vndr_seq(String[] invVndrSeq)
	{
		if (invVndrSeq != null) {
			String[] tmpVOs = Arrays.copyOf(invVndrSeq, invVndrSeq.length);
			this.invVndrSeq = tmpVOs;
		} // end if
	}
	public String[] getInv_vndr_seq()
	{
		String[] rtnVOs = null;
		if (this.invVndrSeq != null) {
			rtnVOs = Arrays.copyOf(this.invVndrSeq, this.invVndrSeq.length);
		} // end if
		return rtnVOs;
	}
	 
	public void setInv_amt( String[] invAmt)
	{
		if (invAmt != null) {
			String[] tmpVOs = Arrays.copyOf(invAmt, invAmt.length);
			this.invAmt = tmpVOs;
		} // end if
	}
	public String[] getInv_amt()
	{
		String[] rtnVOs = null;
		if (this.invAmt != null) {
			rtnVOs = Arrays.copyOf(this.invAmt, this.invAmt.length);
		} // end if
		return rtnVOs;
	}
	
	public void setVat_amt(String[] vatAmt)
	{
		if (vatAmt != null) {
			String[] tmpVOs = Arrays.copyOf(vatAmt, vatAmt.length);
			this.vatAmt = tmpVOs;
		} // end if
	}
	
	public String[] getVat_amt()
	{
		String[] rtnVOs = null;
		if (this.vatAmt != null) {
			rtnVOs = Arrays.copyOf(this.vatAmt, this.vatAmt.length);
		} // end if
		return rtnVOs;
	}
	
	public void setTotal_amt(String[] totalAmt)
	{
		if (totalAmt != null) {
			String[] tmpVOs = Arrays.copyOf(totalAmt, totalAmt.length);
			this.totalAmt = tmpVOs;
		} // end if
	}
	
	public String[] getTotal_amt(){
		String[] rtnVOs = null;
		if (this.totalAmt != null) {
			rtnVOs = Arrays.copyOf(this.totalAmt, this.totalAmt.length);
		} // end if
		return rtnVOs;
	}
	
	public void setTrsp_inv_aud_sts_cd(String[] trspInvAudStsCd)
	{
		if (trspInvAudStsCd != null) {
			String[] tmpVOs = Arrays.copyOf(trspInvAudStsCd, trspInvAudStsCd.length);
			this.trspInvAudStsCd = tmpVOs;
		} // end if
	}
	
	public String[] getTrsp_inv_aud_sts_cd()
	{
		String[] rtnVOs = null;
		if (this.trspInvAudStsCd != null) {
			rtnVOs = Arrays.copyOf(this.trspInvAudStsCd, this.trspInvAudStsCd.length);
		} // end if
		return rtnVOs;
	}
	
	public String getEventName() {
		return "EsdTrs0035Event";
	}

	public String toString() {
		return "EsdTrs0035Event";
	}
}