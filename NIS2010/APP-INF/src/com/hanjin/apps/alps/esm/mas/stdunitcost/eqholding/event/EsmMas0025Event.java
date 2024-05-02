/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0025Event.java
*@FileTitle : 실적장비비 표준단가 조회, 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqCntrHldCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Min Seok
 * @see ESM_MAS_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqCntrHldCostVO eqCntrHldCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EqCntrHldCostVO[] eqCntrHldCostVOs = null;
	
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0025Event(){}
	
	public void setEqCntrHldCostVO(EqCntrHldCostVO eqCntrHldCostVO){
		this. eqCntrHldCostVO = eqCntrHldCostVO;
	}

	public void setEqCntrHldCostVOS(EqCntrHldCostVO[] eqCntrHldCostVOs){
		this. eqCntrHldCostVOs = eqCntrHldCostVOs;
	}

	public EqCntrHldCostVO getEqCntrHldCostVO(){
		return eqCntrHldCostVO;
	}

	public EqCntrHldCostVO[] getEqCntrHldCostVOS(){
		return eqCntrHldCostVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}