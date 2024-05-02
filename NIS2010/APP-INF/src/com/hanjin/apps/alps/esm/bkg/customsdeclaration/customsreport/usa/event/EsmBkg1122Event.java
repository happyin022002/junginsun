/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg1122Event.java
*@FileTitle : US AMS : BAPLIE Monitoring Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.06.20 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1122HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Bong Gyoon
 * @see ESM_BKG_1122HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1122Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BaplieMonitorCondVO baplieMonitorCondVO = null;
	private String customsGb = null;

	public EsmBkg1122Event(){}

	/**
	 * @return the transmitHistListCondVO
	 */
	public BaplieMonitorCondVO getBaplieMonitorCondVO() {
		return baplieMonitorCondVO;
	}

	/**
	 * @param transmitHistListCondVO the transmitHistListCondVO to set
	 */
	public void setBaplieMonitorCondVO(BaplieMonitorCondVO baplieMonitorCondVO) {
		this.baplieMonitorCondVO = baplieMonitorCondVO;
	}

	public String getCustomsGb() {
		return customsGb;
	}
	
	public void setCustomsGb(String customsGb) {
		this.customsGb = customsGb;
	}

}