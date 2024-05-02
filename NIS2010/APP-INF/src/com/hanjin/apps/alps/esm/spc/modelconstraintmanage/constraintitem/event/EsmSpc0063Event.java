/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0063Event.java
*@FileTitle : Loadable Weight Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.10 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItem063LoadableListVO;


/**
 * ESM_SPC_0063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0063HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ConditionVO conditionVO =  null;	
	
	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConstraintItem063LoadableListVO searchConstraintItem063LoadableListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchConstraintItem063LoadableListVO[] searchConstraintItem063LoadableListVOs = null;

	public EsmSpc0063Event(){}
	
	public void setSearchConstraintItem063LoadableListVO(SearchConstraintItem063LoadableListVO searchConstraintItem063LoadableListVO){
		this. searchConstraintItem063LoadableListVO = searchConstraintItem063LoadableListVO;
	}

	public void setSearchConstraintItem063LoadableListVOS(SearchConstraintItem063LoadableListVO[] searchConstraintItem063LoadableListVOs){
		this. searchConstraintItem063LoadableListVOs = searchConstraintItem063LoadableListVOs;
	}

	public SearchConstraintItem063LoadableListVO getSearchConstraintItem063LoadableListVO(){
		return searchConstraintItem063LoadableListVO;
	}

	public SearchConstraintItem063LoadableListVO[] getSearchConstraintItem063LoadableListVOS(){
		return searchConstraintItem063LoadableListVOs;
	}

}