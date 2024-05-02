/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0045Event.java
*@FileTitle : (Korea) Samsung Invoice EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.05 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0045Event extends EventSupport {

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
	private String sendStartIdx = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamsungInPutVO samsungInPutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamsungInPutVO[] samsungInPutVOs = null;
	
	private SamsungEDISendVO[] samsungEDISendVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamsungInvoiceEDIVO samsungInvoiceEDIVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamsungInvoiceEDIVO[] samsungInvoiceEDIVOs = null;

	public FnsInv0045Event(){}
	
	public void setSamsungInPutVO(SamsungInPutVO samsungInPutVO){
		this. samsungInPutVO = samsungInPutVO;
	}

	public void setSamsungInPutVOS(SamsungInPutVO[] samsungInPutVOs){
		this. samsungInPutVOs = samsungInPutVOs;
	}

	public SamsungEDISendVO[] getSamsungEDISendVOs() {
		return samsungEDISendVOs;
	}

	public void setSamsungEDISendVOs(SamsungEDISendVO[] samsungEDISendVOs) {
		this.samsungEDISendVOs = samsungEDISendVOs;
	}

	public void setSamsungInvoiceEDIVO(SamsungInvoiceEDIVO samsungInvoiceEDIVO){
		this. samsungInvoiceEDIVO = samsungInvoiceEDIVO;
	}

	public void setSamsungInvoiceEDIVOS(SamsungInvoiceEDIVO[] samsungInvoiceEDIVOs){
		this. samsungInvoiceEDIVOs = samsungInvoiceEDIVOs;
	}

	public SamsungInPutVO getSamsungInPutVO(){
		return samsungInPutVO;
	}

	public SamsungInPutVO[] getSamsungInPutVOS(){
		return samsungInPutVOs;
	}

	public SamsungInvoiceEDIVO getSamsungInvoiceEDIVO(){
		return samsungInvoiceEDIVO;
	}

	public SamsungInvoiceEDIVO[] getSamsungInvoiceEDIVOS(){
		return samsungInvoiceEDIVOs;
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
	public String getSendStartIdx() {
		return sendStartIdx;
	}
	public void setSendStartIdx(String sendStartIdx) {
		this.sendStartIdx = sendStartIdx;
	}
}