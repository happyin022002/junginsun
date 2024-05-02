/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0040Event.java
*@FileTitle : Off Hire Result-Average using Day
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.28 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SearchParamVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0040Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	
	/**
	 * Default Constructor.
	 */
	public EesLse0040Event(){}
	
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