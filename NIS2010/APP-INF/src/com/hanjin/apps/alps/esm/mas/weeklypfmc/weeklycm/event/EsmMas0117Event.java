/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0117Event.java
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
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchSMUPfmcListVO;
import com.hanjin.syscommon.common.table.MasSltMgmtUtVO;


/**
 * ESM_MAS_0117 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0117HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0117HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0117Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSMUPfmcListVO searchSMUPfmcListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSMUPfmcListVO[] searchSMUPfmcListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasSltMgmtUtVO masSltMgmtUtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasSltMgmtUtVO[] masSltMgmtUtVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0117Event(){}
	
	public void setSearchSMUPfmcListVO(SearchSMUPfmcListVO searchSMUPfmcListVO){
		this. searchSMUPfmcListVO = searchSMUPfmcListVO;
	}

	public void setSearchSMUPfmcListVOS(SearchSMUPfmcListVO[] searchSMUPfmcListVOs){
		this. searchSMUPfmcListVOs = searchSMUPfmcListVOs;
	}

	public void setMasSltMgmtUtVO(MasSltMgmtUtVO masSltMgmtUtVO){
		this. masSltMgmtUtVO = masSltMgmtUtVO;
	}

	public void setMasSltMgmtUtVOS(MasSltMgmtUtVO[] masSltMgmtUtVOs){
		this. masSltMgmtUtVOs = masSltMgmtUtVOs;
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

	public MasSltMgmtUtVO getMasSltMgmtUtVO(){
		return masSltMgmtUtVO;
	}

	public MasSltMgmtUtVO[] getMasSltMgmtUtVOS(){
		return masSltMgmtUtVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}