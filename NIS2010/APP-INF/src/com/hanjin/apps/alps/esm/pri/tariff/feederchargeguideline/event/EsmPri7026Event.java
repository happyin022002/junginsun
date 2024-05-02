/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri7026Event.java
*@FileTitle : Add-On Tariff Amendment History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.07.03 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchFDRAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchFDRAmendmentHistoryMainVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_7026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHLOE MIJIN SEO
 * @see ESM_PRI_7026HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri7026Event extends EventSupport {

	public EsmPri7026Event(){}
	
	private SearchFDRAmendmentHistoryMainVO searchFDRAmendmentHistoryMainVO = null;   
	
	private SearchFDRAmendmentHistoryDetailVO searchFDRAmendmentHistoryDetailVO = null;   
	
	private static final long serialVersionUID = 1L;

	public SearchFDRAmendmentHistoryMainVO getSearchFDRAmendmentHistoryMainVO() {
		return searchFDRAmendmentHistoryMainVO;
	}

	public void setSearchFDRAmendmentHistoryMainVO(
			SearchFDRAmendmentHistoryMainVO searchFDRAmendmentHistoryMainVO) {
		this.searchFDRAmendmentHistoryMainVO = searchFDRAmendmentHistoryMainVO;
	}

	public SearchFDRAmendmentHistoryDetailVO getSearchFDRAmendmentHistoryDetailVO() {
		return searchFDRAmendmentHistoryDetailVO;
	}

	public void setSearchFDRAmendmentHistoryDetailVO(
			SearchFDRAmendmentHistoryDetailVO searchFDRAmendmentHistoryDetailVO) {
		this.searchFDRAmendmentHistoryDetailVO = searchFDRAmendmentHistoryDetailVO;
	}

}