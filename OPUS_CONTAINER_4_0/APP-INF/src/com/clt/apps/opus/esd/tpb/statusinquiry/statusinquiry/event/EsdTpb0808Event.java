/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0808Event.java
*@FileTitle : StatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchInformationOnPendingTPBVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0808 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0808HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0808HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0808Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInformationOnPendingTPBVO[] searchInformationOnPendingTPBVOs = null;

	public EsdTpb0808Event(){}
	
	public void setSearchInformationOnPendingTPBVO(SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO){
		this. searchInformationOnPendingTPBVO = searchInformationOnPendingTPBVO;
	}

	public void setSearchInformationOnPendingTPBVOS(SearchInformationOnPendingTPBVO[] searchInformationOnPendingTPBVOs){
		if(searchInformationOnPendingTPBVOs != null){
			SearchInformationOnPendingTPBVO[] tmpVOs = Arrays.copyOf(searchInformationOnPendingTPBVOs, searchInformationOnPendingTPBVOs.length);
			this.searchInformationOnPendingTPBVOs = tmpVOs;
		}
	}

	public SearchInformationOnPendingTPBVO getSearchInformationOnPendingTPBVO(){
		return searchInformationOnPendingTPBVO;
	}

	public SearchInformationOnPendingTPBVO[] getSearchInformationOnPendingTPBVOS(){
		SearchInformationOnPendingTPBVO[] rtnVOs = null;
		if (this.searchInformationOnPendingTPBVOs != null) {
			rtnVOs = Arrays.copyOf(searchInformationOnPendingTPBVOs, searchInformationOnPendingTPBVOs.length);
		}
		return rtnVOs;
	}

}