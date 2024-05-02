/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0041Event.java
*@FileTitle : Slip Inquiry Master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.03 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CondSearchSlipApprovalVO condSearchSlipApprovalVO = null;
	
	public void setCondSearchSlipApprovalVO(CondSearchSlipApprovalVO condSearchSlipApprovalVO){
		this.condSearchSlipApprovalVO = condSearchSlipApprovalVO;
	}

	public CondSearchSlipApprovalVO getCondSearchSlipApprovalVO(){
		return condSearchSlipApprovalVO;
	}
	
	//AP Cancel VO
	private SearchSlipApprovalListVO searchSlipApprovalListVO = null;

	public SearchSlipApprovalListVO getSearchSlipApprovalListVO() {
		return searchSlipApprovalListVO;
	}

	public void setSearchSlipApprovalListVO(SearchSlipApprovalListVO searchSlipApprovalListVO) {
		this.searchSlipApprovalListVO = searchSlipApprovalListVO;
	}
	
}