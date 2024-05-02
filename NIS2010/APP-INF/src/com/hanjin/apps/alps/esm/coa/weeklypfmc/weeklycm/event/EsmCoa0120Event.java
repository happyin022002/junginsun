/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0117Event.java
*@FileTitle : SMU Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.12.07 김종범 최초 생성
* 2009.09.11 0115 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostListVO;
import com.hanjin.syscommon.common.table.CoaSsnlSltMgmtUtVO;


/**
 * ESM_COA_0120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHKIM
 * @see ESM_COA_0120HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0120Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSeasonalSMUCostListVO searchSeasonalSMUCostListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSeasonalSMUCostListVO[] searchSeasonalSMUCostListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaSsnlSltMgmtUtVO coaSsnlSltMgmtUtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaSsnlSltMgmtUtVO[] coaSsnlSltMgmtUtVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0120Event(){}
	
	public void setSearchSeasonalSMUCostListVO(SearchSeasonalSMUCostListVO searchSeasonalSMUCostListVO){
		this. searchSeasonalSMUCostListVO = searchSeasonalSMUCostListVO;
	}

	public void setSearchSeasonalSMUCostListVOS(SearchSeasonalSMUCostListVO[] searchSeasonalSMUCostListVOs){
		this. searchSeasonalSMUCostListVOs = searchSeasonalSMUCostListVOs;
	}

	public void setCoaSsnlSltMgmtUtVO(CoaSsnlSltMgmtUtVO coaSsnlSltMgmtUtVO){
		this. coaSsnlSltMgmtUtVO = coaSsnlSltMgmtUtVO;
	}

	public void setCoaSsnlSltMgmtUtVOS(CoaSsnlSltMgmtUtVO[] coaSsnlSltMgmtUtVOs){
		this. coaSsnlSltMgmtUtVOs = coaSsnlSltMgmtUtVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}	

	public SearchSeasonalSMUCostListVO getSearchSeasonalSMUCostListVO(){
		return searchSeasonalSMUCostListVO;
	}

	public SearchSeasonalSMUCostListVO[] getSearchSeasonalSMUCostListVOS(){
		return searchSeasonalSMUCostListVOs;
	}

	public CoaSsnlSltMgmtUtVO getCoaSltMgmtUtVO(){
		return coaSsnlSltMgmtUtVO;
	}

	public CoaSsnlSltMgmtUtVO[] getCoaSsnlSltMgmtUtVOS(){
		return coaSsnlSltMgmtUtVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}