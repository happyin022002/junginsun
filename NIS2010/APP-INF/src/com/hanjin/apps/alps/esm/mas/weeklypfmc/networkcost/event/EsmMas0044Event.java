/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0044Event.java
*@FileTitle : EsmMas0044Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
 *=========================================================
 * History
 * 2011.02.21 김상수 [CHM-201108827-01] - 사용하지 않는 VOs 선언문 제거
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0044HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0044Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	

	/** Constructor */
	public EsmMas0044Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0044Event";
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
