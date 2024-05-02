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
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSMUPfmcListVO;
import com.hanjin.syscommon.common.table.CoaSltMgmtUtVO;


/**
 * ESM_COA_0117 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0117HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0117HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0117Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSMUPfmcListVO searchSMUPfmcListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSMUPfmcListVO[] searchSMUPfmcListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaSltMgmtUtVO coaSltMgmtUtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaSltMgmtUtVO[] coaSltMgmtUtVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0117Event(){}
	
	public void setSearchSMUPfmcListVO(SearchSMUPfmcListVO searchSMUPfmcListVO){
		this. searchSMUPfmcListVO = searchSMUPfmcListVO;
	}

	public void setSearchSMUPfmcListVOS(SearchSMUPfmcListVO[] searchSMUPfmcListVOs){
		this. searchSMUPfmcListVOs = searchSMUPfmcListVOs;
	}

	public void setCoaSltMgmtUtVO(CoaSltMgmtUtVO coaSltMgmtUtVO){
		this. coaSltMgmtUtVO = coaSltMgmtUtVO;
	}

	public void setCoaSltMgmtUtVOS(CoaSltMgmtUtVO[] coaSltMgmtUtVOs){
		this. coaSltMgmtUtVOs = coaSltMgmtUtVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}	

	public SearchSMUPfmcListVO getSearchSMUPfmcListVO(){
		return searchSMUPfmcListVO;
	}

	public SearchSMUPfmcListVO[] getSearchSMUPfmcListVOS(){
		return searchSMUPfmcListVOs;
	}

	public CoaSltMgmtUtVO getCoaSltMgmtUtVO(){
		return coaSltMgmtUtVO;
	}

	public CoaSltMgmtUtVO[] getCoaSltMgmtUtVOS(){
		return coaSltMgmtUtVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}