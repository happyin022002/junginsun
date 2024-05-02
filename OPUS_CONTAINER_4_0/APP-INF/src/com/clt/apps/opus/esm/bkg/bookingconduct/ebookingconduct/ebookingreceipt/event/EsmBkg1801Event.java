/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1801Event.java
*@FileTitle : Pegasus XML Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRevMsgVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0228 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0228HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0228HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1801Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgXterRevMsgVO bkgXterRevMsgVO= null;
	private String rcvFromDt= null;
	private String rcvToDt= null;
	private String upldCd= null;
	private String rqstNo= null;
	private String rcvSeq= null;
	private String rcvMsg= null;
	private String msgSeq= null;
	private String msgDesc= null;
	
	public EsmBkg1801Event(){}

	public BkgXterRevMsgVO getBkgXterRevMsgVO() {
		return bkgXterRevMsgVO;
	}

	public void setBkgXterRevMsgVO(BkgXterRevMsgVO bkgXterRevMsgVO) {
		this.bkgXterRevMsgVO = bkgXterRevMsgVO;
	}

	public String getRcvFromDt() {
		return rcvFromDt;
	}

	public void setRcvFromDt(String rcvFromDt) {
		this.rcvFromDt = rcvFromDt;
	}

	public String getRcvToDt() {
		return rcvToDt;
	}

	public void setRcvToDt(String rcvToDt) {
		this.rcvToDt = rcvToDt;
	}

	public String getUpldCd() {
		return upldCd;
	}

	public void setUpldCd(String upldCd) {
		this.upldCd = upldCd;
	}

	public String getRqstNo() {
		return rqstNo;
	}

	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}

	public String getRcvSeq() {
		return rcvSeq;
	}

	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}

	public String getRcvMsg() {
		return rcvMsg;
	}

	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
	}

	public String getMsgSeq() {
		return msgSeq;
	}

	public void setMsgSeq(String msgSeq) {
		this.msgSeq = msgSeq;
	}

	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}




}