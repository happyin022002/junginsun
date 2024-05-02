/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_084Event.java
*@FileTitle : UsaRailYardManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-11
*@LastModifier : Jun Yong Park
*@LastVersion : 1.0
* 2009-05-11 Jun Yong Park
* 1.0 최초 생성
* N200905150040 2009-05-20 [TRS]USA RAIL YARD 정보 저장 화면 개발
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.vo.UsaRailYardManageVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0084 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0084HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong yeon cho
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0084Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	private UsaRailYardManageVO usaRailYardManageVO = null;
	private UsaRailYardManageVO[] usaRailYardManageVOs = null;
    private String yard="";
    private String railYard="";
    private String userId="";
    
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getYard() {
		return yard;
	}


	public void setYard(String yard) {
		this.yard = yard;
	}


	public String getRailYard() {
		return railYard;
	}


	public void setRailYard(String railYard) {
		this.railYard = railYard;
	}


	public String getEventName() {
		return "EsdTrs0084Event";
	}

	public String toString() {
		return "EsdTrs0084Event";
	}


	public UsaRailYardManageVO getUsaRailYardManageVO() {
		return usaRailYardManageVO;
	}


	public void setUsaRailYardManageVO(UsaRailYardManageVO usaRailYardManageVO) {
		this.usaRailYardManageVO = usaRailYardManageVO;
	}


	public UsaRailYardManageVO[] getUsaRailYardManageVOs() {
		UsaRailYardManageVO[] rtnVOs = null;
		if (this.usaRailYardManageVOs != null) {
			rtnVOs = Arrays.copyOf(usaRailYardManageVOs, usaRailYardManageVOs.length);
		} // end if
		return rtnVOs;
	}


	public void setUsaRailYardManageVOs(UsaRailYardManageVO[] usaRailYardManageVOs) {
		if (usaRailYardManageVOs != null) {
			UsaRailYardManageVO[] tmpVOs = Arrays.copyOf(usaRailYardManageVOs, usaRailYardManageVOs.length);
			this.usaRailYardManageVOs = tmpVOs;
		} // end if
	}
	
}
