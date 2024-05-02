/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0117Event.java
*@FileTitle : StatusInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0117 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0117HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0117HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0117Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBStatusSummaryVO searchTPBStatusSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBStatusSummaryVO[] searchTPBStatusSummaryVOs = null;

	public EsdTpb0117Event(){}

	public SearchTPBStatusSummaryVO getSearchTPBStatusSummaryVO() {
		return searchTPBStatusSummaryVO;
	}

	public void setSearchTPBStatusSummaryVO(
			SearchTPBStatusSummaryVO searchTPBStatusSummaryVO) {
		this.searchTPBStatusSummaryVO = searchTPBStatusSummaryVO;
	}

	public SearchTPBStatusSummaryVO[] getSearchTPBStatusSummaryVOs() {
		return searchTPBStatusSummaryVOs;
	}

	public void setSearchTPBStatusSummaryVOs(
			SearchTPBStatusSummaryVO[] searchTPBStatusSummaryVOs) {
		this.searchTPBStatusSummaryVOs = searchTPBStatusSummaryVOs;
	}
	


}