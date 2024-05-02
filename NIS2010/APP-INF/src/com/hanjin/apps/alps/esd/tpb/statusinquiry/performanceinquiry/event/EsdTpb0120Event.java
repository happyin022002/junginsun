/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0120Event.java
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

import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchNonTPBListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 

/**
 * ESD_TPB_0120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0120HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0120Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNonTPBListVO searchNonTPBListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchNonTPBListVO[] searchNonTPBListVOs = null;

	public EsdTpb0120Event(){}

	public SearchNonTPBListVO getSearchNonTPBListVO() {
		return searchNonTPBListVO;
	}

	public void setSearchNonTPBListVO(SearchNonTPBListVO searchNonTPBListVO) {
		this.searchNonTPBListVO = searchNonTPBListVO;
	}

	public SearchNonTPBListVO[] getSearchNonTPBListVOs() {
		return searchNonTPBListVOs;
	}

	public void setSearchNonTPBListVOs(SearchNonTPBListVO[] searchNonTPBListVOs) {
		this.searchNonTPBListVOs = searchNonTPBListVOs;
	}
	

}