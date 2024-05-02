/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesLse0111Event.java
*@FileTitle : EQ interchange Pick-up/Off-hire Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 이유목
*@LastVersion : 1.0
* 2015.06.09 이유목
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE You-Mok
 * @see EES_LSE_0111HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0111Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	private EqInterchangeSummaryVO eqInterchangeSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqInterchangeSummaryVO[] eqInterchangeSummaryVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;

	
	/**
	 * Default Constructor.
	 */
	public EesLse0111Event(){}
	
	public void setEqInterchangeSummaryVO(EqInterchangeSummaryVO eqInterchangeSummaryVO){
		this. eqInterchangeSummaryVO = eqInterchangeSummaryVO;
	}

	public void setEqInterchangeSummaryVOS(EqInterchangeSummaryVO[] eqInterchangeSummaryVOs){
		this. eqInterchangeSummaryVOs = eqInterchangeSummaryVOs;
	}

	public EqInterchangeSummaryVO getEqInterchangeSummaryVO(){
		return eqInterchangeSummaryVO;
	}

	public EqInterchangeSummaryVO[] getEqInterchangeSummaryVOS(){
		return eqInterchangeSummaryVOs;
	}
	
	/**
	 * 단건처리 DataModel를 설정한다.
	 * @param searchParamVO
	 */
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this.searchParamVO = searchParamVO;
	}
	
	/**
	 * 단건처리 DataModel를 반환한다.
	 * @return searchParamVO
	 */
	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}
}