/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0006Event.java
*@FileTitle : Office Role Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2015-03-12
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-03-12 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.OfcRoleSetupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0006HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0006Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private OfcRoleSetupVO ofcRoleSetupVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private OfcRoleSetupVO[] ofcRoleSetupVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0006Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0006Event";
	}

	public OfcRoleSetupVO getOfcRoleSetupVO() {
		return ofcRoleSetupVO;
	}

	public void setOfcRoleSetupVO(OfcRoleSetupVO ofcRoleSetupVO) {
		this.ofcRoleSetupVO = ofcRoleSetupVO;
	}

	
	public OfcRoleSetupVO[] getOfcRoleSetupVOs() {
		return ofcRoleSetupVOs;
	}

	public void setOfcRoleSetupVOs(OfcRoleSetupVO[] ofcRoleSetupVOs) {
		this.ofcRoleSetupVOs = ofcRoleSetupVOs;
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
