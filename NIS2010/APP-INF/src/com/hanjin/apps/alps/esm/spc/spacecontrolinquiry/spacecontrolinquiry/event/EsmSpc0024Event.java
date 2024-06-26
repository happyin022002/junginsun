/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0024Event.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.19 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;


/**
 * ESM_SPC_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0024HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs = null;

	public EsmSpc0024Event(){}
	
	public void setSearchSpaceControlInquiryConditionVO(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO){
		this. searchSpaceControlInquiryConditionVO = searchSpaceControlInquiryConditionVO;
	}

	public void setSearchSpaceControlInquiryConditionVOS(SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs){
		if (searchSpaceControlInquiryConditionVOs != null) {
			SearchSpaceControlInquiryConditionVO[] tmpVOs = new SearchSpaceControlInquiryConditionVO[searchSpaceControlInquiryConditionVOs.length];
			System.arraycopy(searchSpaceControlInquiryConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiryConditionVOs = tmpVOs;
		}
	}

	public SearchSpaceControlInquiryConditionVO getSearchSpaceControlInquiryConditionVO(){
		return searchSpaceControlInquiryConditionVO;
	}

	public SearchSpaceControlInquiryConditionVO[] getSearchSpaceControlInquiryConditionVOS(){
		SearchSpaceControlInquiryConditionVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryConditionVOs != null) {
			rtnVOs = new SearchSpaceControlInquiryConditionVO[searchSpaceControlInquiryConditionVOs.length];
			System.arraycopy(searchSpaceControlInquiryConditionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}