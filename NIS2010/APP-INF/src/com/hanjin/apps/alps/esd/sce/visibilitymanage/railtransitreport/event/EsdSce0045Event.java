/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0045Event.java
*@FileTitle : Rail Transit Report
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-22 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRSmmyDtlVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRSmmyInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRCountVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRListVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * EsdSce0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0045Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/*
	 * 생성자 
	 */
	public EsdSce0045Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRTRCountVO searchRTRCnt = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRTRInfoVO searchRTRInfo = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRTRInfoVO searchRTRSmmyInfo = null;	
	/** Table Value Object Multi Data 처리 */
	private SearchRTRInfoVO[] searchRTRInfos = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRTRListVO searchRTRList = null;
	/** Table Value Object Multi Data 처리 */
	private SearchRTRListVO[] searchRTRLists = null;
	/** Table Value Object Multi Data 처리 */
	private SearchRTRSmmyInfoVO[] searchRTRSmmyInfos = null;
	/** Table Value Object Multi Data 처리 */
	private SearchRTRSmmyDtlVO[] SearchRTRSmmyDtls = null;
	private String fmDate = null;
	private String toDate = null;
	private String dateKind = null;
	private String curPage = null;
	private String chkPeriod = null;
	private String scNo = null;
	private String parentScNo = null;	

	/**
	 * getSearchRTRCnt
	 * @return SearchRTRCountVO
	 */
	public SearchRTRCountVO getSearchRTRCnt() {
		return searchRTRCnt;
	}
	/**
	 * setSearchRTRCnt
	 * @param searchRTRCnt
	 */
	public void setSearchRTRCnt(SearchRTRCountVO searchRTRCnt) {
		this.searchRTRCnt = searchRTRCnt;
	}
	/**
	 * getSearchRTRInfo
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
	 * getSearchRTRInfos
	 * @return SearchRTRInfoVO[]
	 */
	public SearchRTRInfoVO[] getSearchRTRInfos() {
		return searchRTRInfos;
	}
	/**
	 * setSearchRTRInfos
	 * @param searchRTRInfos
	 */
	public void setSearchRTRInfos(SearchRTRInfoVO[] searchRTRInfos) {
		this.searchRTRInfos = searchRTRInfos;
	}
	/**
	 * getSearchRTRList
	 * @return SearchRTRListVO
	 */
	public SearchRTRListVO getSearchRTRList() {
		return searchRTRList;
	}
	/**
	 * setSearchRTRList
	 * @param searchRTRList
	 */
	public void setSearchRTRList(SearchRTRListVO searchRTRList) {
		this.searchRTRList = searchRTRList;
	}
	/**
	 * getSearchRTRLists
	 * @return SearchRTRListVO[]
	 */
	public SearchRTRListVO[] getSearchRTRLists() {
		return searchRTRLists;
	}
	
	/**
	 * setSearchRTRLists
	 * @param SearchRTRListVO[] searchRTRLists
	 */
	public void setSearchRTRLists(SearchRTRListVO[] searchRTRLists) {
		this.searchRTRLists = searchRTRLists;
	}
	
	/**
	 * setSearchRTRSmmyInfo
	 * @param SearchRTRInfoVO searchRTRSmmyInfo
	 */
	public void setSearchRTRSmmyInfo(SearchRTRInfoVO searchRTRSmmyInfo) {
		this.searchRTRSmmyInfo = searchRTRSmmyInfo;
	}
	
	/**
	 * getSearchRTRSmmyInfo
	 * @return SearchRTRInfoVO
	 */
	public SearchRTRInfoVO getSearchRTRSmmyInfo() {
		return searchRTRSmmyInfo;
	}
	
	/**
	 * setSearchRTRSmmyInfos
	 * @param SearchRTRSmmyInfoVO[] searchRTRSmmyInfos
	 */
	public void setSearchRTRSmmyInfos(SearchRTRSmmyInfoVO[] searchRTRSmmyInfos) {
		this.searchRTRSmmyInfos = searchRTRSmmyInfos;
	}
	
	/**
	 * getSearchRTRSmmyInfos
	 * @return SearchRTRSmmyInfoVO[]
	 */
	public SearchRTRSmmyInfoVO[] getSearchRTRSmmyInfos() {
		return searchRTRSmmyInfos;
	}
	/**
	 * setFmDate
	 * @param String fmDate
	 */
	public void setFmDate(String fmDate) {
		this.fmDate = fmDate;
	}
	/**
	 * getFmDate
	 * @return String
	 */
	public String getFmDate() {
		return fmDate;
	}
	/**
	 * setToDate
	 * @param String toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * getToDate
	 * @return String
	 */
	public String getToDate() {
		return toDate;
	}
	/**
	 * setDateKind
	 * @param String dateKind
	 */
	public void setDateKind(String dateKind) {
		this.dateKind = dateKind;
	}
	/**
	 * getDateKind
	 * @return String
	 */
	public String getDateKind() {
		return dateKind;
	}

	/**
	 * setSearchRTRSmmyDtls
	 * @param SearchRTRSmmyDtlVO[] searchRTRSmmyDtls
	 */
	public void setSearchRTRSmmyDtls(SearchRTRSmmyDtlVO[] searchRTRSmmyDtls) {
		SearchRTRSmmyDtls = searchRTRSmmyDtls;
	}
	/**
	 * getSearchRTRSmmyDtls
	 * @return SearchRTRSmmyDtlVO[]
	 */
	public SearchRTRSmmyDtlVO[] getSearchRTRSmmyDtls() {
		return SearchRTRSmmyDtls;
	}
	/**
	 * setCurPage
	 * @param String curPage
	 */
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	/**
	 * getCurPage
	 * @return String
	 */
	public String getCurPage() {
		return curPage;
	}
	/**
	 * setChkPeriod
	 * @param String chkPeriod
	 */
	public void setChkPeriod(String chkPeriod) {
		this.chkPeriod = chkPeriod;
	}
	/**
	 * getChkPeriod
	 * @return String
	 */
	public String getChkPeriod() {
		return chkPeriod;
	}
	
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	public String getScNo() {
		return scNo;
	}
	
	public void setParentScNo(String parentScNo) {
		this.parentScNo = parentScNo;
	}
	
	public String getParentScNo() {
		return parentScNo;
	}	
	
}
