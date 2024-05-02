/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0035Event.java
*@FileTitle : Red Light Alert 기준 조회/수정---컨테이너 수급 예측
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-09-20		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.22		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.22
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrObFcastRedLgtAltVO;


/**
 * EES_EQR_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	public EqrObFcastRedLgtAltVO[] eqrObFcastRedLgtAltVOS = null;
	
	private String tpsz = null;

	public EesEqr0035Event(){}

	/**
	 * @return the tpsz
	 */
	public String getTpsz() {
		return tpsz;
	}

	/**
	 * @param tpsz the tpsz to set
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}

	/**
	 * @return the eqrObFcastRedLgtAltVOS
	 */
	public EqrObFcastRedLgtAltVO[] getEqrObFcastRedLgtAltVOS() {
		return eqrObFcastRedLgtAltVOS;
	}

	/**
	 * @param eqrObFcastRedLgtAltVOS the eqrObFcastRedLgtAltVOS to set
	 */
	public void setEqrObFcastRedLgtAltVOS(
			EqrObFcastRedLgtAltVO[] eqrObFcastRedLgtAltVOS) {
		this.eqrObFcastRedLgtAltVOS = eqrObFcastRedLgtAltVOS;
	}

}