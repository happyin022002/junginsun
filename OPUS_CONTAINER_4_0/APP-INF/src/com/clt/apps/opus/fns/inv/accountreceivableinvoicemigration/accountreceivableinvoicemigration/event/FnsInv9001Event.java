/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv9001Event.java
*@FileTitle : Migration Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 박성용
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_9001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_9001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sung Yong Park
 * @see FNS_INV_9001HTMLAction 참조
 * @since J2EE 1.6
 */
  
public class FnsInv9001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String fmCtrtOfcCd = null;
	
	private String toCtrtOfcCd = null;
	
	private String bkgNo = null;
	
	private String ofcCd = null;
	
	private String srcIfDt = null;
	
	private String fmSrcIfSeq = null;
	
	private String toSrcIfSeq = null;
	
	private String arOfcCd = null;
	
	private String vvdCd = null;
	
	
	public String getFmCtrtOfcCd() {
		return fmCtrtOfcCd;
	}

	public void setFmCtrtOfcCd(String fmCtrtOfcCd) {
		this.fmCtrtOfcCd = fmCtrtOfcCd;
	}
	
	public String getToCtrtOfcCd() {
		return toCtrtOfcCd;
	}

	public void setToCtrtOfcCd(String toCtrtOfcCd) {
		this.toCtrtOfcCd = toCtrtOfcCd;
	}
	
	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	public String getSrcIfDt() {
		return srcIfDt;
	}

	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}
	
	public String getFmSrcIfSeq() {
		return fmSrcIfSeq;
	}

	public void setFmSrcIfSeq(String fmSrcIfSeq) {
		this.fmSrcIfSeq = fmSrcIfSeq;
	}
	
	public String getToSrcIfSeq() {
		return toSrcIfSeq;
	}

	public void setToSrcIfSeq(String toSrcIfSeq) {
		this.toSrcIfSeq = toSrcIfSeq;
	}
	
	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	public String getVvdCd() {
		return vvdCd;
	}

	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
}