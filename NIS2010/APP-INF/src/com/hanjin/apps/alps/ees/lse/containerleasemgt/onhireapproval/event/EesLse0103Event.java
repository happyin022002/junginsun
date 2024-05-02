/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0130Event.java
*@FileTitle : Requst List Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.06
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.06.09 채창호
* 1.0 Creation
* **********************************************
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchRequestListVO;;

/**
 * EES_LSE_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRequestListVO searchRequestListVO = null;
	public SearchRequestListVO[] searchRequestListVOs =null;
	private String titieNm = null;
		
	public EesLse0103Event(){}

	/**
	 * @return the searchRequestListVO
	 */
	public SearchRequestListVO getSearchRequestListVO() {
		return searchRequestListVO;
	}

	/**
	 * @param searchRequestListVO the searchRequestListVO to set
	 */
	public void setSearchRequestListVO(SearchRequestListVO searchRequestListVO) {
		this.searchRequestListVO = searchRequestListVO;
	}

	/**
	 * @return the searchRequestListVOs
	 */
	public SearchRequestListVO[] getSearchRequestListVOs() {
		return searchRequestListVOs;
	}

	/**
	 * @param searchRequestListVOs the searchRequestListVOs to set
	 */
	public void setSearchRequestListVOs(SearchRequestListVO[] searchRequestListVOs) {
		this.searchRequestListVOs = searchRequestListVOs;
	}

	/**
	 * @return the titieNm
	 */
	public String getTitieNm() {
		return titieNm;
	}

	/**
	 * @param titieNm the titieNm to set
	 */
	public void setTitieNm(String titieNm) {
		this.titieNm = titieNm;
	}
	
	
	
}