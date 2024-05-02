/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0144Event.java
*@FileTitle : MGB EDI Submission
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.21
*@LastModifier : 백승일
*@LastVersion : 1.0
* 2015.12.21  백승일MGB Invoice EDI 신규 개발 요청
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInvoiceEdiVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0145 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0145HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Baek Seung IL
 * @see FNS_INV_0145HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0145Event extends EventSupport {

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
	private ADIDASInputVO adidasInputVO = null;
	
	private ADIDASInvoiceEdiVO[] adidasInvoiceEdiVOs = null;

	public FnsInv0145Event(){}
	
	

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
	 * @return the adidasInvoiceEdiVOs
	 */
	public ADIDASInvoiceEdiVO[] getADIDASInvoiceEdiVOs() {
		ADIDASInvoiceEdiVO[] rtnVOs = null;
		if (this.adidasInvoiceEdiVOs != null) {
			rtnVOs = new ADIDASInvoiceEdiVO[adidasInvoiceEdiVOs.length];
			System.arraycopy(adidasInvoiceEdiVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param adidasInvoiceEdiVOs the adidasInvoiceEdiVOs to set
	 */
	public void setADIDASInvoiceEdiVOs(ADIDASInvoiceEdiVO[] adidasInvoiceEdiVOs){
		if(adidasInvoiceEdiVOs != null){
			ADIDASInvoiceEdiVO[] tmpVOs = new ADIDASInvoiceEdiVO[adidasInvoiceEdiVOs.length];
			System.arraycopy(adidasInvoiceEdiVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.adidasInvoiceEdiVOs = tmpVOs;
		}
	}



	/**
	 * @return the adidasInputVO
	 */
	public ADIDASInputVO getADIDASInputVO() {
		return adidasInputVO;
	}



	/**
	 * @param adidasInputVO the adidasInputVO to set
	 */
	public void setADIDASInputVO(ADIDASInputVO adidasInputVO) {
		this.adidasInputVO = adidasInputVO;
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