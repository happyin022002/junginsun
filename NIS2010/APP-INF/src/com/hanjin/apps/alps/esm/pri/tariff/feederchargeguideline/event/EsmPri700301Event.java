/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri700301Event.java
*@FileTitle : Feeder/IHC Tariff Inquiry - Dry Tab
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.06
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.07 SEO MI JIN
* 1.0 Creation
* 2013.07.31 [CHM-201326002] 전윤주 DG Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
*                             DG Cargo Flag 조회 Event 추가
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchTariffInquiryVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.TariffInquiryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_700301 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7003_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_7003_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri700301Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri700301Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTariffInquiryVO searchTariffInquiryVO = null;

	public SearchTariffInquiryVO getSearchTariffInquiryVO() {
		return searchTariffInquiryVO;
	}

	public void setSearchTariffInquiryVO(SearchTariffInquiryVO searchTariffInquiryVO) {
		this.searchTariffInquiryVO = searchTariffInquiryVO;
	}
	
	/** DG Cargo Flag 조회   */
	private TariffInquiryListVO tariffInquiryListVO = null;

	public TariffInquiryListVO getTariffInquiryListVO() {
		return tariffInquiryListVO;
	}

	public void setTariffInquiryListVO(TariffInquiryListVO tariffInquiryListVO) {
		this.tariffInquiryListVO = tariffInquiryListVO;
	}

}