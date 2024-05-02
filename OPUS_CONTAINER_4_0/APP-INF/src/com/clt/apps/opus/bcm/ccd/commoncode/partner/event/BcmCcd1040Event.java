/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BcmCcd1040Event.java
*@FileTitle : VENDOR POPUP
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2012.02.21 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.event;

import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.SearchSimilarVendorNameVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_1040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_1040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ho Kim
 * @see BCM_CCD_1040HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd1040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSimilarVendorNameVO searchSimilarVendorNameVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSimilarVendorNameVO[] searchSimilarVendorNameVOs = null;
	
	private String vndrCntCd = null;

	public BcmCcd1040Event(){}
	
	public void setSearchSimilarVendorNameVO(SearchSimilarVendorNameVO searchSimilarVendorNameVO){
		this.searchSimilarVendorNameVO = searchSimilarVendorNameVO;
	}

	public void setSearchSimilarVendorNameVOS(SearchSimilarVendorNameVO[] searchSimilarVendorNameVOs){
		if(searchSimilarVendorNameVOs != null){
			SearchSimilarVendorNameVO[] tmpVOs = java.util.Arrays.copyOf(searchSimilarVendorNameVOs, searchSimilarVendorNameVOs.length);
			this.searchSimilarVendorNameVOs = tmpVOs;
		}
	}

	public SearchSimilarVendorNameVO getSearchSimilarVendorNameVO(){
		return searchSimilarVendorNameVO;
	}

	public SearchSimilarVendorNameVO[] getSearchSimilarVendorNameVOS(){
		SearchSimilarVendorNameVO[] rtnVOs = null;
		if (this.searchSimilarVendorNameVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(searchSimilarVendorNameVOs, searchSimilarVendorNameVOs.length);
		}
		return rtnVOs;
	}

	public String getVndrCntCd() {
		return vndrCntCd;
	}

	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}

	

}