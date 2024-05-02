/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1802Event.java
*@FileTitle : Pegasus XML View
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
 * ESM_BKG_1802 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1802HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_1802HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1802Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgXterRevMsgVO bkgXterRevMsgVO= null;
	private String sndrId= null;
	private String rqstNo= null;
	private String rqstSeq= null;
	private String msgSeq= null;

	public EsmBkg1802Event(){}

	public BkgXterRevMsgVO getBkgXterRevMsgVO() {
		return bkgXterRevMsgVO;
	}

	public void setBkgXterRevMsgVO(BkgXterRevMsgVO bkgXterRevMsgVO) {
		this.bkgXterRevMsgVO = bkgXterRevMsgVO;
	}

	public String getSndrId() {
		return sndrId;
	}

	public void setSndrId(String sndrId) {
		this.sndrId = sndrId;
	}

	public String getRqstNo() {
		return rqstNo;
	}

	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}

	public String getRqstSeq() {
		return rqstSeq;
	}

	public void setRqstSeq(String rqstSeq) {
		this.rqstSeq = rqstSeq;
	}

	public String getMsgSeq() {
		return msgSeq;
	}

	public void setMsgSeq(String msgSeq) {
		this.msgSeq = msgSeq;
	}


	
}