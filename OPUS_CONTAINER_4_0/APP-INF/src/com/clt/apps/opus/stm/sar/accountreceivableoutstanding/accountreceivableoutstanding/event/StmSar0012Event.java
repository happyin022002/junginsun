/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar0012Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event;


import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ApplyOutstandingCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.SarOtsRctTmpVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableOutstandingSC로 실행요청<br>
 * - AccountReceivableOutstandingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar0012Event 참조
 * @since J2EE 1.4
 */

public class StmSar0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ApplyOutstandingCondVO applyOutstandingCondVO = null;
	
	private SarOtsRctTmpVO sarOtsRctTmpVO = null;
	
	private SarOtsRctTmpVO[] sarOtsRctTmpVOs = null;
	
	public StmSar0012Event() {}

	
	public ApplyOutstandingCondVO getApplyOutstandingCondVO() {
		return applyOutstandingCondVO;
	}

	public void setApplyOutstandingCondVO(ApplyOutstandingCondVO applyOutstandingCondVO) {
		this.applyOutstandingCondVO = applyOutstandingCondVO;
	}
	
	public SarOtsRctTmpVO getSarOtsRctTmpVO() {
		return sarOtsRctTmpVO;
	}


	public void setSarOtsRctTmpVO(SarOtsRctTmpVO sarOtsRctTmpVO) {
		this.sarOtsRctTmpVO = sarOtsRctTmpVO;
	}


	public SarOtsRctTmpVO[] getSarOtsRctTmpVOs() {
		SarOtsRctTmpVO[] rtnVOs = null;
		if (this.sarOtsRctTmpVOs != null) {
			rtnVOs = new SarOtsRctTmpVO[sarOtsRctTmpVOs.length];
			System.arraycopy(sarOtsRctTmpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setSarOtsRctTmpVOs(SarOtsRctTmpVO[] sarOtsRctTmpVOs){
		if(sarOtsRctTmpVOs != null){
			SarOtsRctTmpVO[] tmpVOs = new SarOtsRctTmpVO[sarOtsRctTmpVOs.length];
			System.arraycopy(sarOtsRctTmpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sarOtsRctTmpVOs = tmpVOs;
		}
	}
}