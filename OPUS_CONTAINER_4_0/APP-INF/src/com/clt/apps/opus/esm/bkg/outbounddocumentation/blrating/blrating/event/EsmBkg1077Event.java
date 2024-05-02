/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmBkg1077Event.java
*@FileTitle : Rating Application Date Search
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.12.27 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRatingApplyDateVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM TAE KYOUNG
 * @see ESM_BKG_1077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1077Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	SearchRatingApplyDateVO searchRatingApplyDateVO = null;

	private String bkgNo = "";
	private String caFlg = "";
	
	/** Table Value Object Multi Data 처리 */
	
	private SearchRatingApplyDateVO[] searchRatingApplyDateVOS = null;
	/**
	 * @return the bkg_no
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * @return the caFlg
	 */
	public String getCaFlg() {
		return caFlg;
	}

	/**
	 * @param caFlg the caFlg to set
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}

	
	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the taaInformInVO
	 */
	public SearchRatingApplyDateVO getSearchRatingApplyDateVO() {
		return searchRatingApplyDateVO;
	}

	/**
	 * @param taaInformInVO the taaInformInVO to set
	 */
	public void setSearchRatingApplyDateVO(SearchRatingApplyDateVO searchRatingApplyDateVO) {
		this.searchRatingApplyDateVO = searchRatingApplyDateVO;
	}

	public SearchRatingApplyDateVO[] getSearchRatingApplyDateVOS() {
		SearchRatingApplyDateVO[] rtnVOs = null;
		if (this.searchRatingApplyDateVOS != null) {
			rtnVOs = Arrays.copyOf(searchRatingApplyDateVOS,searchRatingApplyDateVOS.length);
		}
		return rtnVOs;
	}

	public void setSearchRatingApplyDateVOS(
			SearchRatingApplyDateVO[] searchRatingApplyDateVOS) {
		if (searchRatingApplyDateVOS != null) {
			SearchRatingApplyDateVO[] tmpVOs = Arrays.copyOf(searchRatingApplyDateVOS,searchRatingApplyDateVOS.length);
			this.searchRatingApplyDateVOS = tmpVOs;
		}
	}






}