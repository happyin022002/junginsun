/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce048Event.java
*@FileTitle : Multi Input
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-28 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBKGNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBLNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputCntrVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputVVDVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * EsdSce048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0048Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/*
	 * 생성자
	 */
	public EsdSce0048Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRTRInfoVO searchRTRInfo = null;
	/** Table Value Object Multi Data 처리 */
	private SearchRTRInfoVO[] searchRTRInfos = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMultiInputCntrVO cntrVo = null;
	/** Table Value Object Multi Data 처리 */
	private SearchMultiInputCntrVO[] cntrVos = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMultiInputBKGNoVO bkgVo = null;
	/** Table Value Object Multi Data 처리 */
	private SearchMultiInputBKGNoVO[] bkgVos = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMultiInputBLNoVO blNoVo = null;
	/** Table Value Object Multi Data 처리 */
	private SearchMultiInputBLNoVO[] blNoVos = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMultiInputVVDVO vvdVo = null;
	/** Table Value Object Multi Data 처리 */
	private SearchMultiInputVVDVO[] vvdVos = null;
	
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
	 * getCntrVo
	 * @return SearchMultiInputCntrVO
	 */
	public SearchMultiInputCntrVO getCntrVo() {
		return cntrVo;
	}
	/**
	 * setCntrVo
	 * @param cntrVo
	 */
	public void setCntrVo(SearchMultiInputCntrVO cntrVo) {
		this.cntrVo = cntrVo;
	}
	/**
	 * getCntrVos
	 * @return SearchMultiInputCntrVO[]
	 */
	public SearchMultiInputCntrVO[] getCntrVos() {
		return cntrVos;
	}
	/**
	 * setCntrVos
	 * @param cntrVos
	 */
	public void setCntrVos(SearchMultiInputCntrVO[] cntrVos) {
		this.cntrVos = cntrVos;
	}
	/**
	 * getBkgVo
	 * @return SearchMultiInputBKGNoVO
	 */
	public SearchMultiInputBKGNoVO getBkgVo() {
		return bkgVo;
	}
	/**
	 * setBkgVo
	 * @param bkgVo
	 */
	public void setBkgVo(SearchMultiInputBKGNoVO bkgVo) {
		this.bkgVo = bkgVo;
	}
	/**
	 * getBkgVos
	 * @return SearchMultiInputBKGNoVO[]
	 */
	public SearchMultiInputBKGNoVO[] getBkgVos() {
		return bkgVos;
	}
	/**
	 * setBkgVos
	 * @param bkgVos
	 */
	public void setBkgVos(SearchMultiInputBKGNoVO[] bkgVos) {
		this.bkgVos = bkgVos;
	}
	/**
	 * getBlNoVo
	 * @return SearchMultiInputBLNoVO
	 */
	public SearchMultiInputBLNoVO getBlNoVo() {
		return blNoVo;
	}
	/**
	 * setBlNoVo
	 * @param blNoVo
	 */
	public void setBlNoVo(SearchMultiInputBLNoVO blNoVo) {
		this.blNoVo = blNoVo;
	}
	/**
	 * getBlNoVos
	 * @return SearchMultiInputBLNoVO[]
	 */
	public SearchMultiInputBLNoVO[] getBlNoVos() {
		return blNoVos;
	}
	/**
	 * setBlNoVos
	 * @param blNoVos
	 */
	public void setBlNoVos(SearchMultiInputBLNoVO[] blNoVos) {
		this.blNoVos = blNoVos;
	}
	/**
	 * getVvdVo
	 * @return SearchMultiInputVVDVO
	 */
	public SearchMultiInputVVDVO getVvdVo() {
		return vvdVo;
	}
	/**
	 * setVvdVo
	 * @param vvdVo
	 */
	public void setVvdVo(SearchMultiInputVVDVO vvdVo) {
		this.vvdVo = vvdVo;
	}
	/**
	 * getVvdVos
	 * @return SearchMultiInputVVDVO[]
	 */
	public SearchMultiInputVVDVO[] getVvdVos() {
		return vvdVos;
	}
	/**
	 * setVvdVos
	 * @param vvdVos
	 */
	public void setVvdVos(SearchMultiInputVVDVO[] vvdVos) {
		this.vvdVos = vvdVos;
	}
	
}
