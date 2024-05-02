/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0020Event.java
*@FileTitle : Pre-Dispatch Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-13
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0  
* 2006-12-13 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.predispatchstatus.event;

import com.clt.apps.opus.esd.trs.workordermanage.predispatchstatus.vo.SearchPreDispatchStatusVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0020Event extends EventSupport {

	
	private SearchPreDispatchStatusVO searchPreDispatchStatusVo = null;

	public EsdTrs0020Event(){}

	public SearchPreDispatchStatusVO getSearchPreDispatchStatusVo() {
		return searchPreDispatchStatusVo;
	}

	public void setSearchPreDispatchStatusVo(SearchPreDispatchStatusVO searchPreDispatchStatusVo) {
		this.searchPreDispatchStatusVo = searchPreDispatchStatusVo;
	}
	
	public String getEventName() {
		return "EsdTrs0020Event";
	}

	public String toString() {
		return "EsdTrs0020Event";
	}

}
