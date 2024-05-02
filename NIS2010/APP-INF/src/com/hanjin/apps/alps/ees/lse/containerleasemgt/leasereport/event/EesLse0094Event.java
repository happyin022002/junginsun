/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0094Event.java
*@FileTitle : Sub Lease Out Container Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.13 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SearchParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0094 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0094HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0094HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0094Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	
	/**
	 * Default Constructor.
	 */
	public EesLse0094Event(){}
	
	/**
	 * 단건처리 DataModel를 설정한다.
	 * @param searchParamVO
	 */
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this.searchParamVO = searchParamVO;
	}
	
	/**
	 * 단건처리 DataModel를 반환한다.
	 * @return PlanSearchVO
	 */
	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

}