/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0080Event.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.20
*@LastModifier : CHOI.Y.S
*@LastVersion : 1.0
* 2010.08.20 CHOI.Y.S
* 1.0 Creation
* 2010.08.20 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 2010년 시스템 개발 계획
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryDownVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI.Y.S
 * @see ESM_SPC_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlRDRSummaryListVO searchSpaceControlRDRSummaryListVO = null;
	private SearchSpaceControlRDRSummaryDownVO searchSpaceControlRDRSummaryDownVO = null;

	public EsmSpc0080Event(){}

	public void setSearchSpaceControlRDRSummaryListVO(SearchSpaceControlRDRSummaryListVO searchSpaceControlRDRSummaryListVO){
		this. searchSpaceControlRDRSummaryListVO = searchSpaceControlRDRSummaryListVO;
	}

	public SearchSpaceControlRDRSummaryListVO getSSearchSpaceControlRDRSummaryListVO(){
		return searchSpaceControlRDRSummaryListVO;
	}
	
	public void setSearchSpaceControlRDRSummaryDownVO(SearchSpaceControlRDRSummaryDownVO searchSpaceControlRDRSummaryDownVO){
		this. searchSpaceControlRDRSummaryDownVO = searchSpaceControlRDRSummaryDownVO;
	}

	public SearchSpaceControlRDRSummaryDownVO getSSearchSpaceControlRDRSummaryDownVO(){
		return searchSpaceControlRDRSummaryDownVO;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}