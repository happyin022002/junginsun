/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri703201Event.java
*@FileTitle : Inland add-on amendment history - Dry Tab
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.16
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.11.16 SEO MI JIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryMainVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_703201 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7032_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_7032_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri703201Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri703201Event(){}
	
	private SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO = null;
	
	private SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO  = null;
	
	

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

}