/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1019Event.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2013.07.30 두기민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.event;

import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019RouteSettingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 두기민
 * @see EesEqr1019Event 참조
 * @since J2EE 1.6
 */

public class EesEqr1019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs = null;

	public EesEqr1019Event(){}
	
	public EesEqr1019RouteSettingVO getEesEqr1019RouteSettingVO() {
		return eesEqr1019RouteSettingVO;
	}

	public void setEesEqr1019RouteSettingVO(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) {
		this.eesEqr1019RouteSettingVO = eesEqr1019RouteSettingVO;
	}

	public EesEqr1019RouteSettingVO[] getEesEqr1019RouteSettingVOs() {
		return eesEqr1019RouteSettingVOs;
	}

	public void setEesEqr1019RouteSettingVOs(EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs) {
		this.eesEqr1019RouteSettingVOs = eesEqr1019RouteSettingVOs;
	}

}