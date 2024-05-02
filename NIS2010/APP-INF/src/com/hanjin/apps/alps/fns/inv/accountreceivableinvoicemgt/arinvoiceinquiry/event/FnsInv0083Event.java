/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0083Event.java
*@FileTitle : (Vietnam) Booking Data for Tax 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.09 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0083HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String saDt1 = "";
	private String saDt2 = "";
	private String pol = "";
	private String srcIfDt = "";
	private String srcIfSeq = "";
	
	public FnsInv0083Event(){}

	public String getSaDt1() {
		return saDt1;
	}

	public void setSaDt1(String saDt1) {
		this.saDt1 = saDt1;
	}

	public String getSaDt2() {
		return saDt2;
	}

	public void setSaDt2(String saDt2) {
		this.saDt2 = saDt2;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * @return the srcIfDt
	 */
	public String getSrcIfDt() {
		return srcIfDt;
	}

	/**
	 * @param srcIfDt the srcIfDt to set
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}

	/**
	 * @return the srcIfSeq
	 */
	public String getSrcIfSeq() {
		return srcIfSeq;
	}

	/**
	 * @param srcIfSeq the srcIfSeq to set
	 */
	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
	}    

}