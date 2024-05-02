/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0082Event.java
*@FileTitle : L/F Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : CHOI.Y.S
*@LastVersion : 1.0
* 2010.10.19 CHOI.Y.S
* 1.0 Creation
* 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryDownVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI.Y.S
 * @see ESM_SPC_0082HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0082Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlLFSummaryListVO searchSpaceControlLFSummaryListVO = null;
	private SearchSpaceControlLFSummaryDownVO searchSpaceControlLFSummaryDownVO = null;

	public EsmSpc0082Event(){}

	public void setSearchSpaceControlLFSummaryListVO(SearchSpaceControlLFSummaryListVO searchSpaceControlLFSummaryListVO){
		this. searchSpaceControlLFSummaryListVO = searchSpaceControlLFSummaryListVO;
	}

	public SearchSpaceControlLFSummaryListVO getSSearchSpaceControlLFSummaryListVO(){
		return searchSpaceControlLFSummaryListVO;
	}
	
	public void setSearchSpaceControlLFSummaryDownVO(SearchSpaceControlLFSummaryDownVO searchSpaceControlLFSummaryDownVO){
		this. searchSpaceControlLFSummaryDownVO = searchSpaceControlLFSummaryDownVO;
	}

	public SearchSpaceControlLFSummaryDownVO getSSearchSpaceControlLFSummaryDownVO(){
		return searchSpaceControlLFSummaryDownVO;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}