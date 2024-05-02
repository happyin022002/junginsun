/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0142Event.java
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
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.hanjin.syscommon.common.table.MasMonVvdVO;


/**
 * ESM_MAS_0142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0142HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0142HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0142Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVVDCheckListVO searchVVDCheckListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchVVDCheckListVO[] searchVVDCheckListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasMonVvdVO masMonVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasMonVvdVO[] masMonVvdVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0142Event(){}
	
	public void setSearchVVDCheckListVO(SearchVVDCheckListVO searchVVDCheckListVO){
		this. searchVVDCheckListVO = searchVVDCheckListVO;
	}

	public void setSearchVVDCheckListVOS(SearchVVDCheckListVO[] searchVVDCheckListVOs){
		this. searchVVDCheckListVOs = searchVVDCheckListVOs;
	}

	public void setMasMonVvdVO(MasMonVvdVO masMonVvdVO){
		this. masMonVvdVO = masMonVvdVO;
	}

	public void setMasMonVvdVOS(MasMonVvdVO[] masMonVvdVOs){
		this. masMonVvdVOs = masMonVvdVOs;
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

	public MasMonVvdVO getMasMonVvdVO(){
		return masMonVvdVO;
	}

	public MasMonVvdVO[] getMasMonVvdVOS(){
		return masMonVvdVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}