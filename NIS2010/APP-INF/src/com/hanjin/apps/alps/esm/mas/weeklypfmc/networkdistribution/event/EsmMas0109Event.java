/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0109Event.java
*@FileTitle : EsmMas0109Event
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
* 2015.03.18 Jong-Ock KIM
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ock KIM
 * @see ESM_MAS_0109HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0109Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	

	/** Constructor */
	public EsmMas0109Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0109Event";
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
