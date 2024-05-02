/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0056Event.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.13 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlTsVolumnListVO;


/**
 * ESM_SPC_0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0056HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlTsVolumnListVO searchSpaceControlTsVolumnListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlTsVolumnListVO[] searchSpaceControlTsVolumnListVOs = null;

	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO = null;
	
	public EsmSpc0056Event(){}
	
	public void setSearchSpaceControlTsVolumnListVO(SearchSpaceControlTsVolumnListVO searchSpaceControlTsVolumnListVO){
		this. searchSpaceControlTsVolumnListVO = searchSpaceControlTsVolumnListVO;
	}

	public void setSearchSpaceControlTsVolumnListVOS(SearchSpaceControlTsVolumnListVO[] searchSpaceControlTsVolumnListVOs){
		if (searchSpaceControlTsVolumnListVOs != null) {
			SearchSpaceControlTsVolumnListVO[] tmpVOs = new SearchSpaceControlTsVolumnListVO[searchSpaceControlTsVolumnListVOs.length];
			System.arraycopy(searchSpaceControlTsVolumnListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlTsVolumnListVOs = tmpVOs;
		}
	}

	public SearchSpaceControlTsVolumnListVO getSearchSpaceControlTsVolumnListVO(){
		return searchSpaceControlTsVolumnListVO;
	}

	public SearchSpaceControlTsVolumnListVO[] getSearchSpaceControlTsVolumnListVOS(){
		SearchSpaceControlTsVolumnListVO[] rtnVOs = null;
		if (this.searchSpaceControlTsVolumnListVOs != null) {
			rtnVOs = new SearchSpaceControlTsVolumnListVO[searchSpaceControlTsVolumnListVOs.length];
			System.arraycopy(searchSpaceControlTsVolumnListVOs, 0, rtnVOs, 0, rtnVOs.length);
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