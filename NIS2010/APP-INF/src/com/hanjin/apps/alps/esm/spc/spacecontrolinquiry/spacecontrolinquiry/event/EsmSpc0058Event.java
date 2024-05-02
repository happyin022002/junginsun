/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0058Event.java
*@FileTitle : spaceallocationinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.24 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry058QtyListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry058VVDListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;


/**
 * ESM_SPC_0058 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0058HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0058HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0058Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiry058QtyListVO searchSpaceControlInquiry058QtyListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiry058QtyListVO[] searchSpaceControlInquiry058QtyListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiry058VVDListVO searchSpaceControlInquiry058VVDListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiry058VVDListVO[] searchSpaceControlInquiry058VVDListVOs = null;

	private ConditionVO conditionVO = null;
	
	public EsmSpc0058Event(){}
	
	public void setSearchSpaceControlInquiry058QtyListVO(SearchSpaceControlInquiry058QtyListVO searchSpaceControlInquiry058QtyListVO){
		this. searchSpaceControlInquiry058QtyListVO = searchSpaceControlInquiry058QtyListVO;
	}

	public void setSearchSpaceControlInquiry058QtyListVOS(SearchSpaceControlInquiry058QtyListVO[] searchSpaceControlInquiry058QtyListVOs){
		if (searchSpaceControlInquiry058QtyListVOs != null) {
			SearchSpaceControlInquiry058QtyListVO[] tmpVOs = new SearchSpaceControlInquiry058QtyListVO[searchSpaceControlInquiry058QtyListVOs.length];
			System.arraycopy(searchSpaceControlInquiry058QtyListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiry058QtyListVOs = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquiry058VVDListVO(SearchSpaceControlInquiry058VVDListVO searchSpaceControlInquiry058VVDListVO){
		this. searchSpaceControlInquiry058VVDListVO = searchSpaceControlInquiry058VVDListVO;
	}

	public void setSearchSpaceControlInquiry058VVDListVOS(SearchSpaceControlInquiry058VVDListVO[] searchSpaceControlInquiry058VVDListVOs){
		if (searchSpaceControlInquiry058VVDListVOs != null) {
			SearchSpaceControlInquiry058VVDListVO[] tmpVOs = new SearchSpaceControlInquiry058VVDListVO[searchSpaceControlInquiry058VVDListVOs.length];
			System.arraycopy(searchSpaceControlInquiry058VVDListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiry058VVDListVOs = tmpVOs;
		}
	}

	public SearchSpaceControlInquiry058QtyListVO getSearchSpaceControlInquiry058QtyListVO(){
		return searchSpaceControlInquiry058QtyListVO;
	}

	public SearchSpaceControlInquiry058QtyListVO[] getSearchSpaceControlInquiry058QtyListVOS(){
		SearchSpaceControlInquiry058QtyListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiry058QtyListVOs != null) {
			rtnVOs = new SearchSpaceControlInquiry058QtyListVO[searchSpaceControlInquiry058QtyListVOs.length];
			System.arraycopy(searchSpaceControlInquiry058QtyListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiry058VVDListVO getSearchSpaceControlInquiry058VVDListVO(){
		return searchSpaceControlInquiry058VVDListVO;
	}

	public SearchSpaceControlInquiry058VVDListVO[] getSearchSpaceControlInquiry058VVDListVOS(){
		SearchSpaceControlInquiry058VVDListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiry058VVDListVOs != null) {
			rtnVOs = new SearchSpaceControlInquiry058VVDListVO[searchSpaceControlInquiry058VVDListVOs.length];
			System.arraycopy(searchSpaceControlInquiry058VVDListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

}