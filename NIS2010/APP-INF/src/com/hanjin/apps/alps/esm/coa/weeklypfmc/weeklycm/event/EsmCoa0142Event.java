/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0142Event.java
*@FileTitle : VVD Check List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2007.06.18 박은주  최초생성
* 2009.10.15 0142 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.hanjin.syscommon.common.table.CoaMonVvdVO;


/**
 * ESM_COA_0142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0142HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0142HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0142Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVVDCheckListVO searchVVDCheckListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchVVDCheckListVO[] searchVVDCheckListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaMonVvdVO coaMonVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaMonVvdVO[] coaMonVvdVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0142Event(){}
	
	public void setSearchVVDCheckListVO(SearchVVDCheckListVO searchVVDCheckListVO){
		this. searchVVDCheckListVO = searchVVDCheckListVO;
	}

	public void setSearchVVDCheckListVOS(SearchVVDCheckListVO[] searchVVDCheckListVOs){
		this. searchVVDCheckListVOs = searchVVDCheckListVOs;
	}

	public void setCoaMonVvdVO(CoaMonVvdVO coaMonVvdVO){
		this. coaMonVvdVO = coaMonVvdVO;
	}

	public void setCoaMonVvdVOS(CoaMonVvdVO[] coaMonVvdVOs){
		this. coaMonVvdVOs = coaMonVvdVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public SearchVVDCheckListVO getSearchVVDCheckListVO(){
		return searchVVDCheckListVO;
	}

	public SearchVVDCheckListVO[] getSearchVVDCheckListVOS(){
		return searchVVDCheckListVOs;
	}

	public CoaMonVvdVO getCoaMonVvdVO(){
		return coaMonVvdVO;
	}

	public CoaMonVvdVO[] getCoaMonVvdVOS(){
		return coaMonVvdVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}