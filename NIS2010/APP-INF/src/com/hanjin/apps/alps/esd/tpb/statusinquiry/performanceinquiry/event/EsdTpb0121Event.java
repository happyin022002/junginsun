/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0121Event.java
*@FileTitle : PerformanceInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.event;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchEACIssuanceListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

 
/**
 * ESD_TPB_0121 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0121HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0121HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0121Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEACIssuanceListVO searchEACIssuanceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEACIssuanceListVO[] searchEACIssuanceListVOs = null;

	public EsdTpb0121Event(){}

	public SearchEACIssuanceListVO getSearchEACIssuanceListVO() {
		return searchEACIssuanceListVO;
	}

	public void setSearchEACIssuanceListVO(
			SearchEACIssuanceListVO searchEACIssuanceListVO) {
		this.searchEACIssuanceListVO = searchEACIssuanceListVO;
	}

	public SearchEACIssuanceListVO[] getSearchEACIssuanceListVOs() {
		return searchEACIssuanceListVOs;
	}

	public void setSearchEACIssuanceListVOs(
			SearchEACIssuanceListVO[] searchEACIssuanceListVOs) {
		this.searchEACIssuanceListVOs = searchEACIssuanceListVOs;
	}
	


}