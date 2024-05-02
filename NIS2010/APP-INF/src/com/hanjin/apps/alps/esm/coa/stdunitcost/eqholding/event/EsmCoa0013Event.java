/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0013Event.java
*@FileTitle : 실적장비비 표준단가 조회, 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.26 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.vo.EqHoldingCostVO;


/**
 * ESM_COA_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_0013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqHoldingCostVO eqHoldingCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EqHoldingCostVO[] eqHoldingCostVOs = null;
	
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0013Event(){}
	
	public void setEqHoldingCostVO(EqHoldingCostVO eqHoldingCostVO){
		this. eqHoldingCostVO = eqHoldingCostVO;
	}

	public void setEqHoldingCostVOS(EqHoldingCostVO[] eqHoldingCostVOs){
		this. eqHoldingCostVOs = eqHoldingCostVOs;
	}

	public EqHoldingCostVO getEqHoldingCostVO(){
		return eqHoldingCostVO;
	}

	public EqHoldingCostVO[] getEqHoldingCostVOS(){
		return eqHoldingCostVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}