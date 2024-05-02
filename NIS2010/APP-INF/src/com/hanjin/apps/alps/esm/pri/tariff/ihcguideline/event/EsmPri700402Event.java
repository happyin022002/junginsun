/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri700402Event.java
 *@FileTitle : IHC inquiry in local currency (TRO) - Reefer Tab 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.11.05
 *@LastModifier : SEO MI JIN
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIhcTariffInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7004_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7004_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author SEO MI JIN
 * @see ESM_PRI_7004_02HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmPri700402Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private SearchIhcTariffInquiryVO searchIhcTariffInquiryVO;

	public SearchIhcTariffInquiryVO getSearchIhcTariffInquiryVO() {
		return searchIhcTariffInquiryVO;
	}

	public void setSearchIhcTariffInquiryVO(SearchIhcTariffInquiryVO searchIhcTariffInquiryVO) {
		this.searchIhcTariffInquiryVO = searchIhcTariffInquiryVO;
	}
}
