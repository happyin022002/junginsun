/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0174Event.java
*@FileTitle : Average U/C(OP fixed/variable cost, SPC CHT Rev/Chraterage)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : Choi In Kyung
*@LastVersion : 1.0
* 2009.11.03 Choi In Kyung
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;

/**
 * ESM_COA_0175 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0175HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi In Kyung
 * @see ESM_COA_0175HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0175Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;		

	/** Constructor */
	public EsmCoa0175Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0175Event";
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
