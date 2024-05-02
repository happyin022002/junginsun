/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0272Event.java
*@FileTitle : Full Storage Daily Calc
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-23
*@LastModifier : Jong-Ock KIM
*@LastVersion : 
*  2015-02-23 Jong-Ock KIM
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.FullStorageDailyCalcVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0272 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0272HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ock KIM
 * @see ESM_MAS_0272HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0272Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private FullStorageDailyCalcVO fullStorageDailyCalcVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private FullStorageDailyCalcVO[] fullStorageDailyCalcVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0272Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0272Event";
	}

	public FullStorageDailyCalcVO getFullStorageDailyCalcVO() {
		return fullStorageDailyCalcVO;
	}

	public void setFullStorageDailyCalcVO(FullStorageDailyCalcVO fullStorageDailyCalcVO) {
		this.fullStorageDailyCalcVO = fullStorageDailyCalcVO;
	}

	
	public FullStorageDailyCalcVO[] getFullStorageDailyCalcVOs() {
		return fullStorageDailyCalcVOs;
	}

	public void setFullStorageDailyCalcVOs(FullStorageDailyCalcVO[] fullStorageDailyCalcVOs) {
		this.fullStorageDailyCalcVOs = fullStorageDailyCalcVOs;
	}
		
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}		
			
}
