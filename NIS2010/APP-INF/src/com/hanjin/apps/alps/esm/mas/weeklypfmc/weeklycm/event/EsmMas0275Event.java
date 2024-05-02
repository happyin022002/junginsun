/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0275Event.java
*@FileTitle : Chassis Per Diem Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-06
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-02-06 Je Ryang Yoo
*  1.0 최초 생성 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostRepbyBKGVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0275 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0275HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0275HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0275Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private DemDetCostRepbyBKGVO demDetCostRepbyBKGVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private DemDetCostRepbyBKGVO[] demDetCostRepbyBKGVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0275Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0275Event";
	}

	public DemDetCostRepbyBKGVO getDemDetCostRepbyBKGVO() {
		return demDetCostRepbyBKGVO;
	}

	public void setDemDetCostRepbyBKGVO(DemDetCostRepbyBKGVO demDetCostRepbyBKGVO) {
		this.demDetCostRepbyBKGVO = demDetCostRepbyBKGVO;
	}

	
	public DemDetCostRepbyBKGVO[] getDemDetCostRepbyBKGVOs() {
		return demDetCostRepbyBKGVOs;
	}

	public void setDemDetCostRepbyBKGVOs(DemDetCostRepbyBKGVO[] demDetCostRepbyBKGVOs) {
		this.demDetCostRepbyBKGVOs = demDetCostRepbyBKGVOs;
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
