/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : WebDoLinkEvent.java
 *@FileTitle : WebDoLinkEvent
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-10-07
 *@LastModifier : Choi jonghyek
 *@LastVersion : 1.0
 * 2011-10-07 Choi jonghyek
 * 1.0 최초 생성
 * 2011.12.09 김종호 [CHM-201113793] [TRS] HJS Homepage Renewal - ALPS 외부 I/F 개발(Webservice)
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.event;

import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvBodyVo;
import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.JoEdiRcvHdrVo;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * Work Order Receiver 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - TRSInterfaceEAIProxy 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see 참조
 * @since J2EE 1.6
 */
public class WorkOrderRcvEvent extends EventSupport {

	private static final long serialVersionUID = -4695704452659526689L;

	public WorkOrderRcvEvent() {
	}

	public String eaiRcvContents = null;

	private JoEdiRcvHdrVo joEdiRcvHdrVo;
	private JoEdiRcvBodyVo joEdiRcvBodyVo;

	public JoEdiRcvHdrVo getJoEdiRcvHdrVo() {
		return joEdiRcvHdrVo;
	}

	public void setJoEdiRcvHdrVo(JoEdiRcvHdrVo joEdiRcvHdrVo) {
		this.joEdiRcvHdrVo = joEdiRcvHdrVo;
	}

	public String getEaiRcvContents() {
		return eaiRcvContents;
	}

	public void setEaiRcvContents(String eaiRcvContents) {
		this.eaiRcvContents = eaiRcvContents;
	}

	public JoEdiRcvBodyVo getJoEdiRcvBodyVo() {
		return joEdiRcvBodyVo;
	}

	public void setJoEdiRcvBodyVo(JoEdiRcvBodyVo joEdiRcvBodyVo) {
		this.joEdiRcvBodyVo = joEdiRcvBodyVo;
	}
}
