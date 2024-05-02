/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar2001Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyListCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptMainVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCollectSC로 실행요청<br>
 * - AccountReceivableCollectSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see StmSar2001Event 참조
 * @since J2EE 1.4
 */

public class StmSar2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String rctOfcCd = null;
	
	private String rctNo = null;
	
	private String agnOfcCd = null;
	
	private String backendjobKey = null; 
	
	private ApplyListCondVO applyListCondVO = null;
	
	private ReceiptMainVO receiptMainVO = null;
	
	private ApplyHeaderVO applyHeaderVO = null;
	
	private ApplyHeaderVO[] applyHeaderVOs = null;
	
	private ApplyDetailVO applyDetailVO = null;
	
	private ApplyDetailVO[] applyDetailVOs = null;
	
	
	public StmSar2001Event() {}

	
	public String getRctOfcCd() {
		return rctOfcCd;
	}

	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
	}
	
	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}
	
	public String getAgnOfcCd() {
		return agnOfcCd;
	}

	public void setAgnOfcCd(String agnOfcCd) {
		this.agnOfcCd = agnOfcCd;
	}
	
	public String getBackendjobKey() {
		return backendjobKey;
	}
	
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
	
	public ApplyListCondVO getApplyListCondVO() {
		return applyListCondVO;
	}

	public void setApplyListCondVO(ApplyListCondVO applyListCondVO) {
		this.applyListCondVO = applyListCondVO;
	}
	
	public ReceiptMainVO getReceiptMainVO() {
		return receiptMainVO;
	}

	public void setReceiptMainVO(ReceiptMainVO receiptMainVO) {
		this.receiptMainVO = receiptMainVO;
	}
	
	public ApplyHeaderVO getApplyHeaderVO() {
		return applyHeaderVO;
	}

	public void setApplyHeaderVO(ApplyHeaderVO applyHeaderVO) {
		this.applyHeaderVO = applyHeaderVO;
	}
	
	public ApplyHeaderVO[] getApplyHeaderVOs() {
		ApplyHeaderVO[] rtnVOs = null;
		if (this.applyHeaderVOs != null) {
			rtnVOs = new ApplyHeaderVO[applyHeaderVOs.length];
			System.arraycopy(applyHeaderVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setApplyHeaderVOs(ApplyHeaderVO[] applyHeaderVOs) {
		if (applyHeaderVOs != null) {
			ApplyHeaderVO[] tmpVOs = new ApplyHeaderVO[applyHeaderVOs.length];
			System.arraycopy(applyHeaderVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.applyHeaderVOs = tmpVOs;
		}
	}
	
	public ApplyDetailVO getApplyDetailVO() {
		return applyDetailVO;
	}

	public void setApplyDetailVO(ApplyDetailVO applyDetailVO) {
		this.applyDetailVO = applyDetailVO;
	}
	
	public ApplyDetailVO[] getApplyDetailVOs() {
		ApplyDetailVO[] rtnVOs = null;
		if (this.applyDetailVOs != null) {
			rtnVOs = new ApplyDetailVO[applyDetailVOs.length];
			System.arraycopy(applyDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setApplyDetailVOs(ApplyDetailVO[] applyDetailVOs) {
		if (applyDetailVOs != null) {
			ApplyDetailVO[] tmpVOs = new ApplyDetailVO[applyDetailVOs.length];
			System.arraycopy(applyDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.applyDetailVOs = tmpVOs;
		}
	}

}