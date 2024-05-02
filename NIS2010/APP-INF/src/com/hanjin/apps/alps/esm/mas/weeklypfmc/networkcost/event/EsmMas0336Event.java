/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0336Event.java
*@FileTitle : G&A Expense Creation by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-12
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2014-12-12 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.GNAExpCreByOfcVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0336 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0336HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0336HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0336Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private GNAExpCreByOfcVO gnaExpCreByOfcVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private GNAExpCreByOfcVO[] gnaExpCreByOfcVOs = null;
	
	 
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmMas0336Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0336Event";
	}
	
	
	/** ValueObject Getter */
	public GNAExpCreByOfcVO getGNAExpCreByOfcVO() {
		return gnaExpCreByOfcVO;
	}
	
	/** ValueObject Setter */
	public void setGNAExpCreByOfcVO(GNAExpCreByOfcVO gnaExpCreByOfcVO) {
		this.gnaExpCreByOfcVO = gnaExpCreByOfcVO;
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	public GNAExpCreByOfcVO[] getGNAExpCreByOfcVOs() {
		return gnaExpCreByOfcVOs;
	}
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setGNAExpCreByOfcVOs(GNAExpCreByOfcVO[] gnaExpCreByOfcVOs) {
		this.gnaExpCreByOfcVOs = gnaExpCreByOfcVOs;
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
