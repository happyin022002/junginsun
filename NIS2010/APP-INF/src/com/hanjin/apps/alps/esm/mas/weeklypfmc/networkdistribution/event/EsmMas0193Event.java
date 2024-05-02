/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0193Event.java
*@FileTitle : Cost Inquiry by PFMC Type
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.05.21 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.CostInquirybyPFMCTypeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0193 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0193HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 유제량
 * @see ESM_MAS_0193HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0193Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private CostInquirybyPFMCTypeVO costInquirybyPFMCTypeVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CostInquirybyPFMCTypeVO[] costInquirybyPFMCTypeVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmMas0193Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0193Event";
	}

	/** ValueObject Setter */
	public void setCostInquirybyPFMCTypeVO(CostInquirybyPFMCTypeVO costInquirybyPFMCTypeVO){
		this.costInquirybyPFMCTypeVO = costInquirybyPFMCTypeVO;
	}
	/** ValueObject Getter */
	public CostInquirybyPFMCTypeVO getCostInquirybyPFMCTypeVO(){
		return costInquirybyPFMCTypeVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCostInquirybyPFMCTypeVOs(CostInquirybyPFMCTypeVO[] costInquirybyPFMCTypeVOs){
		this.costInquirybyPFMCTypeVOs = costInquirybyPFMCTypeVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CostInquirybyPFMCTypeVO[] getCostInquirybyPFMCTypeVOs(){
		return costInquirybyPFMCTypeVOs;
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
