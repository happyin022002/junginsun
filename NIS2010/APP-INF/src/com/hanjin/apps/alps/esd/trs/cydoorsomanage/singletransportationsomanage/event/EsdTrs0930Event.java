/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_930Event.java
*@FileTitle : Office Transfer Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0 
* 2006-10-16 z_kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_930 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_930HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author z_kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0930Event extends EventSupport {
	private String newTrnsRqstOfcCd = null;
	private String newTrnsRqstRsn = null;
	
	public String getNew_trns_rqst_ofc_cd() {
		return newTrnsRqstOfcCd;
	}

	public void setNew_trns_rqst_ofc_cd(String newTrnsRqstOfcCd) {
		this.newTrnsRqstOfcCd = newTrnsRqstOfcCd;
	}

	public String getNew_trns_rqst_rsn() {
		return newTrnsRqstRsn;
	}

	public void setNew_trns_rqst_rsn(String newTrnsRqstRsn) {
		this.newTrnsRqstRsn = newTrnsRqstRsn;
	}

	private SingleTransportationVO singleTransportationVO = null;
	private SingleTransportationVO[] singleTransportationVOs = null;

	public SingleTransportationVO getSingleTransportationVO() {
		return singleTransportationVO;
	}

	public void setSingleTransportationVO(
			SingleTransportationVO singleTransportationVO) {
		this.singleTransportationVO = singleTransportationVO;
	}

	public SingleTransportationVO[] getSingleTransportationVOs() {
		return singleTransportationVOs;
	}

	public void setSingleTransportationVOs(
			SingleTransportationVO[] singleTransportationVOs) {
		this.singleTransportationVOs = singleTransportationVOs;
	}

	public String getEventName() {
		return "EsdTrs0930Event";
	}

	public String toString() {
		return "EsdTrs0930Event";
	}

}
