/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0131Event.java
*@FileTitle : BKG Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.09.01 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0130ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0131 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0130HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0130Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0130ConditionVO conditionVO = null;
	private SearchExecutionPlanBkgNoVO searchExecutionPlanBkgNoVO = null;

	public EesEqr0130Event(){}

	public EesEqr0130ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(EesEqr0130ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	public SearchExecutionPlanBkgNoVO getSearchExecutionPlanBkgNoVO() {
		return searchExecutionPlanBkgNoVO;
	}

	public void setSearchExecutionPlanBkgNoVO(
			SearchExecutionPlanBkgNoVO searchExecutionPlanBkgNoVO) {
		this.searchExecutionPlanBkgNoVO = searchExecutionPlanBkgNoVO;
	}
}