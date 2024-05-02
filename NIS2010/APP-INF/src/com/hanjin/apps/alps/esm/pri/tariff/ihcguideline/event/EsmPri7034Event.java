/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7034Event.java
 *@FileTitle : Inland add-on inquiry in local currency (TRO)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.11.19
 *@LastModifier : 서미진
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsTariffInquiryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author CHLOE MIJIN SEO
 * @see ESM_PRI_7034HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmPri7034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private SearchUsTariffInquiryListVO searchUsTariffInquiryListVO;

	public SearchUsTariffInquiryListVO getSearchUsTariffInquiryListVO() {
		return searchUsTariffInquiryListVO;
	}

	public void setSearchUsTariffInquiryListVO(
			SearchUsTariffInquiryListVO searchUsTariffInquiryListVO) {
		this.searchUsTariffInquiryListVO = searchUsTariffInquiryListVO;
	}
}
