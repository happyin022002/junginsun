/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0119Event.java
*@FileTitle : PerformanceInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchClosingTPBListVO;
import com.clt.framework.support.layer.event.EventSupport;

 
/**
 * ESD_TPB_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0119Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchClosingTPBListVO searchClosingTPBListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchClosingTPBListVO[] searchClosingTPBListVOs = null;
	
	public EsdTpb0119Event(){}

	public SearchClosingTPBListVO getSearchClosingTPBListVO() {
		return searchClosingTPBListVO;
	}

	public void setSearchClosingTPBListVO(
			SearchClosingTPBListVO searchClosingTPBListVO) {
		this.searchClosingTPBListVO = searchClosingTPBListVO;
	}

	public SearchClosingTPBListVO[] getSearchClosingTPBListVOs() {
		SearchClosingTPBListVO[] rtnVOs = null;
		if (this.searchClosingTPBListVOs != null) {
			rtnVOs = Arrays.copyOf(searchClosingTPBListVOs, searchClosingTPBListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchClosingTPBListVOs(SearchClosingTPBListVO[] searchClosingTPBListVOs){
		if(searchClosingTPBListVOs != null){
			SearchClosingTPBListVO[] tmpVOs = Arrays.copyOf(searchClosingTPBListVOs, searchClosingTPBListVOs.length);
			this.searchClosingTPBListVOs = tmpVOs;
		}
	}


}