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
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event;

import com.hanjin.framework.support.layer.event.EventSupport;

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

	private String[] invNo; 
	private String[] invVndrSeq;
	private String[] invAmt;
	private String[] vatAmt;
	private String[] totalAmt;
	private String[] trspInvAudStsCd;
	public EsdTrs0035Event(){}

	
	public void setInv_no(String[] invNo)
	{
		this.invNo = invNo;
	}
	public String[] getInv_no()
	{
		return this.invNo;
	}
	
	public void setInv_vndr_seq(String[] invVndrSeq)
	{
		this.invVndrSeq = invVndrSeq;
	}
	public String[] getInv_vndr_seq()
	{
		return this.invVndrSeq;
	}
	 
	public void setInv_amt( String[] invAmt)
	{
		this.invAmt = invAmt;
	}
	public String[] getInv_amt()
	{
		return this.invAmt;
	}
	
	public void setVat_amt(String[] vatAmt)
	{
		this.vatAmt = vatAmt;
	}
	
	public String[] getVat_amt()
	{
		return this.vatAmt;
	}
	
	public void setTotal_amt(String[] totalAmt)
	{
		this.totalAmt = totalAmt;
	}
	
	public String[] getTotal_amt(){
		return this.totalAmt;
	}
	
	public void setTrsp_inv_aud_sts_cd(String[] trspInvAudStsCd)
	{
		this.trspInvAudStsCd = trspInvAudStsCd;
	}
	
	public String[] getTrsp_inv_aud_sts_cd()
	{
		return this.trspInvAudStsCd;
	}
	
	public String getEventName() {
		return "EsdTrs0035Event";
	}

	public String toString() {
		return "EsdTrs0035Event";
	}
}