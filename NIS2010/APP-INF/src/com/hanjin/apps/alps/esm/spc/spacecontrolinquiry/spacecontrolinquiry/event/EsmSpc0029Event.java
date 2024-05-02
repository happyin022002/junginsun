/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0029Event.java
*@FileTitle : Send Mail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.06.03 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;


/**
 * ESM_SPC_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see ESM_SPC_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs = null;

	public EsmSpc0029Event(){}
	
	public void setSearchSpaceControlInquiryConditionVO(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO){
		this. searchSpaceControlInquiryConditionVO = searchSpaceControlInquiryConditionVO;
	}

	public void setSearchSpaceControlInquiryConditionVO(SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs){
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