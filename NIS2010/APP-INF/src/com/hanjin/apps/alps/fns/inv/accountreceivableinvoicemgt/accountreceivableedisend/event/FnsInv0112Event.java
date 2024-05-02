/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0112Event.java
*@FileTitle : EDI Submission
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.14 [CHM-201006644] 최도순 NIKE, Invoice EDI 신규 개발 요청
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInvoiceEdiVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0112HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	//기본 조회 조건
	private String actCustCntCd = null;
	private String actCustSeq = null;
	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;
	private String msgId = null;
	private String msgNo = null;
	private String blSrcNo = null;
	private String sentStat = null;
	private String changeType = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NikeInputVO nikeInputVO = null;
	
	private NikeInvoiceEdiVO[] nikeInvoiceEdiVOs = null;

	public FnsInv0112Event(){}
	
	

	/**
	 * @return the sentStat
	 */
	public String getSentStat() {
		return sentStat;
	}



	/**
	 * @param sentStat the sentStat to set
	 */
	public void setSentStat(String sentStat) {
		this.sentStat = sentStat;
	}



	/**
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}



	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}



	/**
	 * @return the nikeInvoiceEdiVOs
	 */
	public NikeInvoiceEdiVO[] getNikeInvoiceEdiVOs() {
		return nikeInvoiceEdiVOs;
	}



	/**
	 * @param nikeInvoiceEdiVOs the nikeInvoiceEdiVOs to set
	 */
	public void setNikeInvoiceEdiVOs(NikeInvoiceEdiVO[] nikeInvoiceEdiVOs) {
		this.nikeInvoiceEdiVOs = nikeInvoiceEdiVOs;
	}



	/**
	 * @return the nikeInputVO
	 */
	public NikeInputVO getNikeInputVO() {
		return nikeInputVO;
	}



	/**
	 * @param nikeInputVO the nikeInputVO to set
	 */
	public void setNikeInputVO(NikeInputVO nikeInputVO) {
		this.nikeInputVO = nikeInputVO;
	}



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

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}

	public String getBlSrcNo() {
		return blSrcNo;
	}

	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

}