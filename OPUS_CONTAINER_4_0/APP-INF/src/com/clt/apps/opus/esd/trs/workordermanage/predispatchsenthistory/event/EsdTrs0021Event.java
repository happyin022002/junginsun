/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0021Event.java
*@FileTitle : Pre-Dispatch Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-19
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-12-19 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.event;

import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.vo.SearchPreDispatchSentHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0021Event extends EventSupport {

	private SearchPreDispatchSentHistoryVO searchPreDispatchSentHistoryVO = null;

	public EsdTrs0021Event(){}

	public SearchPreDispatchSentHistoryVO getSearchPreDispatchSentHistoryVO() {
		return searchPreDispatchSentHistoryVO;
	}

	public void setSearchPreDispatchSentHistoryVO(SearchPreDispatchSentHistoryVO searchPreDispatchSentHistoryVO) {
		this.searchPreDispatchSentHistoryVO = searchPreDispatchSentHistoryVO;
	}

	public String getEventName() {
		return "EsdTrs0021Event";
	}

	public String toString() {
		return "EsdTrs0021Event";
	}

}
