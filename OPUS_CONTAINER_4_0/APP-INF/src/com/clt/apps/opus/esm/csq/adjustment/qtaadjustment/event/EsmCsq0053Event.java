/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0053Event.java
*@FileTitle      : Portion Adjustment by RHQ
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.22 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event;

import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqCfmQtaPotnMgmtVO;

/**
 * ESM_CSQ_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqCfmQtaPotnMgmtVO csqCfmQtaPotnMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqCfmQtaPotnMgmtVO[] csqCfmQtaPotnMgmtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchPotnAdjustmentListVO searchPotnAdjustmentListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	String vvd = null;

	public EsmCsq0053Event(){}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public void setCsqCfmQtaPotnMgmtVO(CsqCfmQtaPotnMgmtVO csqCfmQtaPotnMgmtVO){
		this. csqCfmQtaPotnMgmtVO = csqCfmQtaPotnMgmtVO;
	}

	public void setCsqCfmQtaPotnMgmtVOS(CsqCfmQtaPotnMgmtVO[] csqCfmQtaPotnMgmtVOs){
		this. csqCfmQtaPotnMgmtVOs = csqCfmQtaPotnMgmtVOs;
	}

	public CsqCfmQtaPotnMgmtVO getCsqCfmQtaPotnMgmtVO(){
		return csqCfmQtaPotnMgmtVO;
	}

	public CsqCfmQtaPotnMgmtVO[] getCsqCfmQtaPotnMgmtVOS(){
		return csqCfmQtaPotnMgmtVOs;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public void setSearchPotnAdjustmentListVO(SearchPotnAdjustmentListVO searchPotnAdjustmentListVO){
		this. searchPotnAdjustmentListVO = searchPotnAdjustmentListVO;
	}

	public void setSearchPotnAdjustmentListVOS(SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOs){
		this. searchPotnAdjustmentListVOs = searchPotnAdjustmentListVOs;
	}

	public SearchPotnAdjustmentListVO getSearchPotnAdjustmentListVO(){
		return searchPotnAdjustmentListVO;
	}

	public SearchPotnAdjustmentListVO[] getSearchPotnAdjustmentListVOS(){
		return searchPotnAdjustmentListVOs;
	}
}