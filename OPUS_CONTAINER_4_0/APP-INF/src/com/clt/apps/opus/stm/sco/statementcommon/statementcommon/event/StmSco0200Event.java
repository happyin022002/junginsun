/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSco0200Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.framework.support.layer.event.EventSupport;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.APCostActivityInfoVO;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0200Event 참조
 * @since J2EE 1.4
 */

public class StmSco0200Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	String srcMdlCd = "";
	String actCostCd = "";
	String delFlg = "";
	private APCostActivityInfoVO aPCostActivityInfoVO = null;
	private APCostActivityInfoVO[] aPCostActivityInfoVOs = null;
	
	
	public String getSrcMdlCd() {
		return srcMdlCd;
	}
	public void setSrcMdlCd(String srcMdlCd) {
		this.srcMdlCd = srcMdlCd;
	}
	public String getActCostCd() {
		return actCostCd;
	}
	public void setActCostCd(String actCostCd) {
		this.actCostCd = actCostCd;
	}
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	public APCostActivityInfoVO getAPCostActivityInfoVO() {
		return aPCostActivityInfoVO;
	}
	public void setAPCostActivityInfoVO(APCostActivityInfoVO aPCostActivityInfoVO) {
		this.aPCostActivityInfoVO = aPCostActivityInfoVO;
	}
	public APCostActivityInfoVO[] getAPCostActivityInfoVOs() {
		APCostActivityInfoVO[] rtnVOs = null;
		if (this.aPCostActivityInfoVOs != null) {
			rtnVOs = new APCostActivityInfoVO[aPCostActivityInfoVOs.length];
			System.arraycopy(aPCostActivityInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setAPCostActivityInfoVOs(
			APCostActivityInfoVO[] aPCostActivityInfoVOs) {
		if (aPCostActivityInfoVOs != null) {
			APCostActivityInfoVO[] tmpVOs = new APCostActivityInfoVO[aPCostActivityInfoVOs.length];
			System.arraycopy(aPCostActivityInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aPCostActivityInfoVOs = tmpVOs;
		}
	}


}