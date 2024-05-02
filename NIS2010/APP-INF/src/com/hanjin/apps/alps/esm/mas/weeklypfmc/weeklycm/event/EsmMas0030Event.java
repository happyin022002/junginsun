/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0030Event.java
*@FileTitle : Target VVD0030 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.08.31 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVD0030ListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;


/**
 * ESM_MAS_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchWeeklyTargetVVD0030ListVO searchWeeklyTargetVVD0030ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchWeeklyTargetVVD0030ListVO[] searchWeeklyTargetVVD0030ListVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;
	
	/** 단건처리 */
	private WeeklyCMCommonVO weeklyCMCommonVO = null;
	
	public EsmMas0030Event(){}
	
	public void setSearchWeeklyTargetVVD0030ListVO(SearchWeeklyTargetVVD0030ListVO searchWeeklyTargetVVD0030ListVO){
		this. searchWeeklyTargetVVD0030ListVO = searchWeeklyTargetVVD0030ListVO;
	}

	public void setSearchWeeklyTargetVVD0030ListVOS(SearchWeeklyTargetVVD0030ListVO[] searchWeeklyTargetVVD0030ListVOs){
		this. searchWeeklyTargetVVD0030ListVOs = searchWeeklyTargetVVD0030ListVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public SearchWeeklyTargetVVD0030ListVO getSearchWeeklyTargetVVD0030ListVO(){
		return searchWeeklyTargetVVD0030ListVO;
	}

	public SearchWeeklyTargetVVD0030ListVO[] getSearchWeeklyTargetVVD0030ListVOS(){
		return searchWeeklyTargetVVD0030ListVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	public WeeklyCMCommonVO getWeeklyCMCommonVO() {
		return weeklyCMCommonVO;
	}

	public void setWeeklyCMCommonVO(WeeklyCMCommonVO weeklyCMCommonVO) {
		this.weeklyCMCommonVO = weeklyCMCommonVO;
	}


}