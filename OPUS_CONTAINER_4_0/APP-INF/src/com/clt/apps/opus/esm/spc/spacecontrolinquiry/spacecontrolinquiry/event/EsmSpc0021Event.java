/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0021Event.java
*@FileTitle      : Daily Forecast Status
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.10
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.08.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


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
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs = null;

	public EsmSpc0021Event(){}
	
	public void setSearchSpaceControlInquiryConditionVO(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO){
		this.searchSpaceControlInquiryConditionVO = searchSpaceControlInquiryConditionVO;
	}

	public void setSearchSpaceControlInquiryConditionVO(SearchSpaceControlInquiryConditionVO[] searchSpaceControlInquiryConditionVOs){
		if(searchSpaceControlInquiryConditionVOs != null){
			SearchSpaceControlInquiryConditionVO[] tmpVOs = Arrays.copyOf(searchSpaceControlInquiryConditionVOs, searchSpaceControlInquiryConditionVOs.length);
			this.searchSpaceControlInquiryConditionVOs  = tmpVOs;
		}
	}

	public SearchSpaceControlInquiryConditionVO getSearchSpaceControlInquiryConditionVO(){
		return searchSpaceControlInquiryConditionVO;
	}

	public SearchSpaceControlInquiryConditionVO[] getSearchSpaceControlInquiryConditionVOS(){
		SearchSpaceControlInquiryConditionVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryConditionVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceControlInquiryConditionVOs, searchSpaceControlInquiryConditionVOs.length);
		}
		return rtnVOs;
	}

}