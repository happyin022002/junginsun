/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0057Event.java
*@FileTitle : Space Utilization Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceUtilizationListVO;

/**
 * ESM_SPC_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0057HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceUtilizationListVO searchSpaceUtilizationListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceUtilizationListVO[] searchSpaceUtilizationListVOs = null;

	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO = null;
	
	public EsmSpc0057Event(){}
	
	public void setSearchSpaceUtilizationListVO(SearchSpaceUtilizationListVO searchSpaceUtilizationListVO){
		this. searchSpaceUtilizationListVO = searchSpaceUtilizationListVO;
	}

	public void setSearchSpaceUtilizationListVOS(SearchSpaceUtilizationListVO[] searchSpaceUtilizationListVOs){
		if (searchSpaceUtilizationListVOs != null) {
			SearchSpaceUtilizationListVO[] tmpVOs = new SearchSpaceUtilizationListVO[searchSpaceUtilizationListVOs.length];
			System.arraycopy(searchSpaceUtilizationListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceUtilizationListVOs = tmpVOs;
		}
	}

	public SearchSpaceUtilizationListVO getSearchSpaceUtilizationListVO(){
		return searchSpaceUtilizationListVO;
	}

	public SearchSpaceUtilizationListVO[] getSearchSpaceUtilizationListVOS(){
		SearchSpaceUtilizationListVO[] rtnVOs = null;
		if (this.searchSpaceUtilizationListVOs != null) {
			rtnVOs = new SearchSpaceUtilizationListVO[searchSpaceUtilizationListVOs.length];
			System.arraycopy(searchSpaceUtilizationListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiryConditionVO getSearchSpaceControlInquiryConditionVO() {
		return searchSpaceControlInquiryConditionVO;
	}

	public void setSearchSpaceControlInquiryConditionVO(
			SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) {
		this.searchSpaceControlInquiryConditionVO = searchSpaceControlInquiryConditionVO;
	}

}