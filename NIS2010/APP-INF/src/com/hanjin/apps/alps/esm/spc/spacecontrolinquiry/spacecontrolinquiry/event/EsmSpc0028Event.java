/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0028Event.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.12 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeListVO;


/**
 * ESM_SPC_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0028HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryOfficeListVO searchSpaceControlInquiryOfficeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryOfficeListVO[] searchSpaceControlInquiryOfficeListVOs = null;

	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO = null;
	
	public EsmSpc0028Event(){}
	
	public void setSearchSpaceControlInquiryOfficeListVO(SearchSpaceControlInquiryOfficeListVO searchSpaceControlInquiryOfficeListVO){
		this. searchSpaceControlInquiryOfficeListVO = searchSpaceControlInquiryOfficeListVO;
	}

	public void setSearchSpaceControlInquiryOfficeListVOS(SearchSpaceControlInquiryOfficeListVO[] searchSpaceControlInquiryOfficeListVOs){
		if (searchSpaceControlInquiryOfficeListVOs != null) {
			SearchSpaceControlInquiryOfficeListVO[] tmpVOs = new SearchSpaceControlInquiryOfficeListVO[searchSpaceControlInquiryOfficeListVOs.length];
			System.arraycopy(searchSpaceControlInquiryOfficeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiryOfficeListVOs = tmpVOs;
		}
	}

	public SearchSpaceControlInquiryOfficeListVO getSearchSpaceControlInquiryOfficeListVO(){
		return searchSpaceControlInquiryOfficeListVO;
	}

	public SearchSpaceControlInquiryOfficeListVO[] getSearchSpaceControlInquiryOfficeListVOS(){
		SearchSpaceControlInquiryOfficeListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryOfficeListVOs != null) {
			rtnVOs = new SearchSpaceControlInquiryOfficeListVO[searchSpaceControlInquiryOfficeListVOs.length];
			System.arraycopy(searchSpaceControlInquiryOfficeListVOs, 0, rtnVOs, 0, rtnVOs.length);
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