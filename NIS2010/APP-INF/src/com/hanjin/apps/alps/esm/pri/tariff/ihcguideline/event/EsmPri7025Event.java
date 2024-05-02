/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri7025Event.java
*@FileTitle : IHC Tariff Amendment History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.07.03 CHLOE MIJIN SEO
* 1.0 Creation
* 2013.08.01 전윤주 [CHM-201326002] DG Overweight Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCTariffInquiryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_7025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHLOE MIJIN SEO
 * @see ESM_PRI_7025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri7025Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri7025Event(){}
	
	private SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO = null;
	
	private SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO  = null;
	
	private IHCTariffInquiryListVO iHCTariffInquiryListVO  = null;
	

	
	
	public SearchIHCAmendmentHistoryMainVO getSearchIHCAmendmentHistoryMainVO() {
		return searchIHCAmendmentHistoryMainVO;
	}

	public void setSearchIHCAmendmentHistoryMainVO(
			SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) {
		this.searchIHCAmendmentHistoryMainVO = searchIHCAmendmentHistoryMainVO;
	}

	public SearchIHCAmendmentHistoryDetailVO getSearchIHCAmendmentHistoryDetailVO() {
		return searchIHCAmendmentHistoryDetailVO;
	}

	public void setSearchIHCAmendmentHistoryDetailVO(
			SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO) {
		this.searchIHCAmendmentHistoryDetailVO = searchIHCAmendmentHistoryDetailVO;
	}
	
	public IHCTariffInquiryListVO getIHCTariffInquiryListVO() {
		return iHCTariffInquiryListVO;
	}

	public void setIHCTariffInquiryListVO(
			IHCTariffInquiryListVO iHCTariffInquiryListVO) {
		this.iHCTariffInquiryListVO = iHCTariffInquiryListVO;
	}
	
}