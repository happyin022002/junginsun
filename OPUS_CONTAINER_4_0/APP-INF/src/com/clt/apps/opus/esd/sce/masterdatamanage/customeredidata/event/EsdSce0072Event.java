/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : EsdSce0072Event.java
 *@FileTitle : EsdSce0072
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-17
 *@LastModifier : Jun Byoung Suk
 *@LastVersion : 1.0
 * 2008-05-10 sanghyun-kim
 * 1.0 최초 생성
 * 2009-08-17 Jun Byoung Suk
 * 1.2 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCsTpIdInfoCntVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdSce0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author sanghyun-kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0072Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** 조회를 위한 VO 정의 */
	public EsdSce0072Event() {
	}

	private SearchEDIPerformanceOptionsVO schEpOpts = null;
	private HashMap<String, String> parameterMap = null;

	/**
	 * SearchEDIPerformanceOptionsVO setter 함수
	 * 
	 * @param SearchEDIPerformanceOptionsVO
	 *            schEpOpts
	 * @return
	 * @throws
	 */
	public void setSchEpOpts(SearchEDIPerformanceOptionsVO schEpOpts) {
		this.schEpOpts = schEpOpts;
	}

	/**
	 * SearchEDIPerformanceOptionsVO getter 함수
	 * 
	 * @param
	 * @return SearchEDIPerformanceOptionsVO
	 * @throws
	 */
	public SearchEDIPerformanceOptionsVO getSchEpOpts() {
		return schEpOpts;
	}

	private SearchCustStsVO schCSt = null;

	/**
	 * SearchCustStsVO setter 함수
	 * 
	 * @param SearchCustStsVO
	 *            schCSt
	 * @return
	 * @throws
	 */
	public void setSchCSt(SearchCustStsVO schCSt) {
		this.schCSt = schCSt;
	}

	/**
	 * SearchCustStsVO getter 함수
	 * 
	 * @param
	 * @return SearchCustStsVO
	 * @throws
	 */
	public SearchCustStsVO getSchCSt() {
		return schCSt;
	}

	private GetMyPerformanceSelectVO getMpcomboVO = null;

	/**
	 * GetMyPerformanceSelectVO setter 함수
	 * 
	 * @param getMpcomboVO
	 *            GetMyPerformanceSelectVO
	 * @return
	 * @throws
	 */
	public void setGetMpComboVO(GetMyPerformanceSelectVO getMpcomboVO) {
		this.getMpcomboVO = getMpcomboVO;
	}

	/**
	 * GetMyPerformanceSelectVO getter 함수
	 * 
	 * @param
	 * @return GetMyPerformanceSelectVO
	 * @throws
	 */
	public GetMyPerformanceSelectVO getGetMpComboVO() {
		return getMpcomboVO;
	}

	private SearchComboPerformanceVO schCpVO = null;

	/**
	 * SearchComboPerformanceVO setter 함수
	 * 
	 * @param schCpVO
	 *            SearchComboPerformanceVO
	 * @return
	 * @throws
	 */
	public void setSchCpVO(SearchComboPerformanceVO schCpVO) {
		this.schCpVO = schCpVO;
	}

	/**
	 * SearchComboPerformanceVO getter 함수
	 * 
	 * @param
	 * @return SearchComboPerformanceVO
	 * @throws
	 */
	public SearchComboPerformanceVO getSchCpVO() {
		return schCpVO;
	}

	private SearchPerCsInfoVO schPciVO = null;

	/**
	 * SearchPerCsInfoVO setter 함수
	 * 
	 * @param schPciVO
	 *            SearchPerCsInfoVO
	 * @return
	 * @throws
	 */
	public void setSchPciVO(SearchPerCsInfoVO schPciVO) {
		this.schPciVO = schPciVO;
	}

	/**
	 * SearchPerCsInfoVO getter 함수
	 * 
	 * @param
	 * @return SearchPerCsInfoVO
	 * @throws
	 */
	public SearchPerCsInfoVO getSchPciVO() {
		return schPciVO;
	}

	private SearchCsTpIdInfoCntVO schCsTpInfoVO = null;

	/**
	 * SearchCsTpIdInfoCntVO setter 함수
	 * 
	 * @param schCsTpInfoVO
	 *            SearchCsTpIdInfoCntVO
	 * @return
	 * @throws
	 */
	public void setSchCsTpInfoVO(SearchCsTpIdInfoCntVO schCsTpInfoVO) {
		this.schCsTpInfoVO = schCsTpInfoVO;
	}

	/**
	 * SearchCsTpIdInfoCntVO getter 함수
	 * 
	 * @param
	 * @return SearchCsTpIdInfoCntVO
	 * @throws
	 */
	public SearchCsTpIdInfoCntVO getSchCsTpInfoVO() {
		return schCsTpInfoVO;
	}

	/**
	 * @return Returns the parameterMap.
	 */
	public HashMap<String, String> getParameterMap() {
		return parameterMap;
	}

	/**
	 * @param parameterMap
	 */
	public void setParameterMap(HashMap<String, String> parameterMap) {
		this.parameterMap = parameterMap;
	}

}