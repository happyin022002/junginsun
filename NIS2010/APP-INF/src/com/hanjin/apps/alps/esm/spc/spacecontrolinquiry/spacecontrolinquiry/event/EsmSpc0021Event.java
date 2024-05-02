/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0021Event.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.10 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
//import com.hanjin.syscommon.common.table.SPC_ALOC_CTRL_OPT;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021SusrLaneViewListVO;

/**
 * ESM_SPC_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO = null;
	
	private SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO = null; // 2012.01.18 SHKIM
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs = null;
	
	private SearchSpaceControlInquiry021SusrLaneViewListVO[] search021SusrLaneViewListVOs = null; // 2012.01.18 SHKIM

	public EsmSpc0021Event(){}
	
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
	
	// [S] 2012.01.19 SHKIM 
	public void setSearchSpaceControlInquiry021SusrLaneViewListVO(SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO){
		this. search021SusrLaneViewListVO = search021SusrLaneViewListVO;
	}
	public void setSearchSpaceControlInquiry021SusrLaneViewListVO(SearchSpaceControlInquiry021SusrLaneViewListVO[] search021SusrLaneViewListVOs){
		if (search021SusrLaneViewListVOs != null) {
			SearchSpaceControlInquiry021SusrLaneViewListVO[] tmpVOs = new SearchSpaceControlInquiry021SusrLaneViewListVO[search021SusrLaneViewListVOs.length];
			System.arraycopy(search021SusrLaneViewListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.search021SusrLaneViewListVOs = tmpVOs;
		}
	}
	public SearchSpaceControlInquiry021SusrLaneViewListVO getSearchSpaceControlInquiry021SusrLaneViewListVO(){
		return search021SusrLaneViewListVO;
	}
	public SearchSpaceControlInquiry021SusrLaneViewListVO[] getSearchSpaceControlInquiry021SusrLaneViewListVOS(){
		SearchSpaceControlInquiry021SusrLaneViewListVO[] rtnVOs = null;
		if (this.search021SusrLaneViewListVOs != null) {
			rtnVOs = new SearchSpaceControlInquiry021SusrLaneViewListVO[search021SusrLaneViewListVOs.length];
			System.arraycopy(search021SusrLaneViewListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}	
	// [S] 2012.01.19 SHKIM
}