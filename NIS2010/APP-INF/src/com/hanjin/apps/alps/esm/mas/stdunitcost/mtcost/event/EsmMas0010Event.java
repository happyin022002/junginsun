/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0010HTMLAction.java
*@FileTitle : ECC별 MT 표준단가&MT Turntime 생성 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : 장영석
*@LastVersion : 1.1
*2006-11-16 IM OKYOUNG
*1.0 최초 생성
*Change history :
*2009.09.14 장영석: New Framework 생성[0010]
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCostListPopUpVO;


/**
 * ESM_MAS_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_MAS_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListPopUpVO searchMTCostListPopUpVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0010Event(){}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchMTCostListPopUpVO(SearchMTCostListPopUpVO searchMTCostListPopUpVO){
		this. searchMTCostListPopUpVO = searchMTCostListPopUpVO;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	public SearchMTCostListPopUpVO getSearchMTCostListPopUpVO(){
		return searchMTCostListPopUpVO;
	}


}