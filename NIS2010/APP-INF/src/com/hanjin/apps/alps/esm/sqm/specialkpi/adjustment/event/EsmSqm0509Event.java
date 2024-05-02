/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0509Event.java
*@FileTitle      : Reefer/Special Type/Size Master
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.11.13
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2014.11.13 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchReeferSpclTpSzMgmtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0509 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0509HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0509HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0509Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0509Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchReeferSpclTpSzMgmtVO searchReeferSpclTpSzMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchReeferSpclTpSzMgmtVO[] searchReeferSpclTpSzMgmtVOs = null;
	
	public void setSearchReeferSpclTpSzMgmtVO(SearchReeferSpclTpSzMgmtVO searchReeferSpclTpSzMgmtVO){
		this. searchReeferSpclTpSzMgmtVO = searchReeferSpclTpSzMgmtVO;
	}

	public void setSearchReeferSpclTpSzMgmtVOS(SearchReeferSpclTpSzMgmtVO[] searchReeferSpclTpSzMgmtVOs){
		this. searchReeferSpclTpSzMgmtVOs = searchReeferSpclTpSzMgmtVOs;
	}

	public SearchReeferSpclTpSzMgmtVO getSearchReeferSpclTpSzMgmtVO(){
		return searchReeferSpclTpSzMgmtVO;
	}

	public SearchReeferSpclTpSzMgmtVO[] getSearchReeferSpclTpSzMgmtVOS(){
		return searchReeferSpclTpSzMgmtVOs;
	}
	
}