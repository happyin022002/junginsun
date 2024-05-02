/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0271Event.java
*@FileTitle : DEM/DET Cost Daily Batch Result
*Open Issues :
*Change history :
*@LastModifyDate : 2015-01-15
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-01-15 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostDayBatRstVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0271 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0271HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0271HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0271Event extends EventSupport {
	
	private static final long serialVersionUID = 1L; 
	
	/** 단건처리 */
	private DemDetCostDayBatRstVO demDetCostDayBatRstVO = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmMas0271Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0271Event";
	}
	
	
	/** ValueObject Getter */
	public DemDetCostDayBatRstVO getDemDetCostDayBatRstVO() {
		return demDetCostDayBatRstVO;
	}
	
	/** ValueObject Setter */
	public void setDemDetCostDayBatRstVO(DemDetCostDayBatRstVO demDetCostDayBatRstVO) {
		this.demDetCostDayBatRstVO = demDetCostDayBatRstVO;
	}
	

	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}		
			
}
