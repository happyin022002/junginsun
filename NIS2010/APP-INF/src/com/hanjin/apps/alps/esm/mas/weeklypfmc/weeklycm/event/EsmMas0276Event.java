/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0276Event.java
*@FileTitle : DEM/DET Cost Report by BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2015-03-24
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-03-24 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostReportbyBKGVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0276 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0276HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0276HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0276Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private DemDetCostReportbyBKGVO demDetCostReportbyBKGVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private DemDetCostReportbyBKGVO[] demDetCostReportbyBKGVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0276Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0276Event";
	}

	public DemDetCostReportbyBKGVO getDemDetCostReportbyBKGVO() {
		return demDetCostReportbyBKGVO;
	}

	public void setDemDetCostReportbyBKGVO(DemDetCostReportbyBKGVO demDetCostReportbyBKGVO) {
		this.demDetCostReportbyBKGVO = demDetCostReportbyBKGVO;
	}

	
	public DemDetCostReportbyBKGVO[] getDemDetCostReportbyBKGVOs() {
		return demDetCostReportbyBKGVOs;
	}

	public void setDemDetCostReportbyBKGVOs(DemDetCostReportbyBKGVO[] demDetCostReportbyBKGVOs) {
		this.demDetCostReportbyBKGVOs = demDetCostReportbyBKGVOs;
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
