/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0223Event.java
*@FileTitle : Oneway Container Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2015-03-05
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-03-05 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.OnewayCntrUploadVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0223 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0223HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0223HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0223Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private OnewayCntrUploadVO onewayCntrUploadVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private OnewayCntrUploadVO[] onewayCntrUploadVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0223Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0223Event";
	}

	public OnewayCntrUploadVO getOnewayCntrUploadVO() {
		return onewayCntrUploadVO;
	}

	public void setOnewayCntrUploadVO(OnewayCntrUploadVO onewayCntrUploadVO) {
		this.onewayCntrUploadVO = onewayCntrUploadVO;
	}

	
	public OnewayCntrUploadVO[] getOnewayCntrUploadVOs() {
		return onewayCntrUploadVOs;
	}

	public void setOnewayCntrUploadVOs(OnewayCntrUploadVO[] onewayCntrUploadVOs) {
		this.onewayCntrUploadVOs = onewayCntrUploadVOs;
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
