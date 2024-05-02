/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7003Event.java
 *@FileTitle : Add-on/IHC Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchTariffInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LEE EUN SUP
 * @see ESM_PRI_7003HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri7003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTariffInquiryVO searchTariffInquiryVO = null;

	public SearchTariffInquiryVO getSearchTariffInquiryVO() {
		return searchTariffInquiryVO;
	}

	public void setSearchTariffInquiryVO(SearchTariffInquiryVO searchTariffInquiryVO) {
		this.searchTariffInquiryVO = searchTariffInquiryVO;
	}

}
