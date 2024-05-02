/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce044Event.java
*@FileTitle : Car Location Message(Pop)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-12-06 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.event;

import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMCountPopVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListPopVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * EsdSce044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0044Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/*
	 * 생성자
	 */
	public EsdSce0044Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRTRInfoVO searchRTRInfo = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCLMCountPopVO searchPopCnt = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCLMListPopVO searchPopList = null;
	/**
	 * getSearchRTRInfo()
	 * @return SearchRTRInfoVO
	 */
	public SearchRTRInfoVO getSearchRTRInfo() {
		return searchRTRInfo;
	}
	/**
	 * setSearchRTRInfo
	 * @param searchRTRInfo
	 */
	public void setSearchRTRInfo(SearchRTRInfoVO searchRTRInfo) {
		this.searchRTRInfo = searchRTRInfo;
	}
	/**
	 * getSearchPopCnt
	 * @return SearchCLMCountPopVO
	 */
	public SearchCLMCountPopVO getSearchPopCnt() {
		return searchPopCnt;
	}
	/**
	 * setSearchPopCnt
	 * @param searchPopCnt
	 */
	public void setSearchPopCnt(SearchCLMCountPopVO searchPopCnt) {
		this.searchPopCnt = searchPopCnt;
	}
	/**
	 * getSearchPopList
	 * @return SearchCLMListPopVO
	 */
	public SearchCLMListPopVO getSearchPopList() {
		return searchPopList;
	}
	/**
	 * setSearchPopList
	 * @param searchPopList
	 */
	public void setSearchPopList(SearchCLMListPopVO searchPopList) {
		this.searchPopList = searchPopList;
	}
	
}
