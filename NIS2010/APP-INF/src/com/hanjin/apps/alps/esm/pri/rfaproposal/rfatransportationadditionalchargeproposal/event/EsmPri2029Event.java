/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri2029Event.java
 *@FileTitle : Guideline Route Search Pop-Up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.21
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.05.21 이은섭
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.SearchGuidelineRouteInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_2029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_2029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun-Sup Lee
 * @see ESM_PRI_2029HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri2029Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private SearchGuidelineRouteInquiryVO searchGuidelineRouteInquiryVO;

	public SearchGuidelineRouteInquiryVO getSearchGuidelineRouteInquiryVO() {
		return searchGuidelineRouteInquiryVO;
	}

	public void setSearchGuidelineRouteInquiryVO(SearchGuidelineRouteInquiryVO searchGuidelineRouteInquiryVO) {
		this.searchGuidelineRouteInquiryVO = searchGuidelineRouteInquiryVO;
	}

}
