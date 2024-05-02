/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0277Event.java
*@FileTitle : DEM/DET Cost Report by Customer
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
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostReportbyCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0277 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0277HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0277HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0277Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private DemDetCostReportbyCustomerVO demDetCostReportbyCustomerVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private DemDetCostReportbyCustomerVO[] demDetCostReportbyCustomerVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0277Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0277Event";
	}

	public DemDetCostReportbyCustomerVO getDemDetCostReportbyCustomerVO() {
		return demDetCostReportbyCustomerVO;
	}

	public void setDemDetCostReportbyCustomerVO(DemDetCostReportbyCustomerVO demDetCostReportbyCustomerVO) {
		this.demDetCostReportbyCustomerVO = demDetCostReportbyCustomerVO;
	}

	
	public DemDetCostReportbyCustomerVO[] getDemDetCostReportbyCustomerVOs() {
		return demDetCostReportbyCustomerVOs;
	}

	public void setDemDetCostReportbyCustomerVOs(DemDetCostReportbyCustomerVO[] demDetCostReportbyCustomerVOs) {
		this.demDetCostReportbyCustomerVOs = demDetCostReportbyCustomerVOs;
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
