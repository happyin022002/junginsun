/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri700302Event.java
*@FileTitle : Feeder/IHC Tariff Inquiry - Reefer Tab
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.06
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.07 SEO MI JIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchTariffInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_700302 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7003_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_7003_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri700302Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri700302Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTariffInquiryVO searchTariffInquiryVO = null;

	public SearchTariffInquiryVO getSearchTariffInquiryVO() {
		return searchTariffInquiryVO;
	}

	public void setSearchTariffInquiryVO(SearchTariffInquiryVO searchTariffInquiryVO) {
		this.searchTariffInquiryVO = searchTariffInquiryVO;
	}
}