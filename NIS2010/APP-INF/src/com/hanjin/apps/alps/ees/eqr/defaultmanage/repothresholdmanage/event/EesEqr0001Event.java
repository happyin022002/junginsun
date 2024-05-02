/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_001Event.java
*@FileTitle : Red Light Alert 기준 조회/수정---이송 계획 Input Data
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-20
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-20 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrInpDatRedLgtAltVO;



/**
 * EES_EQR_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chung eun ho
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0001Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	private EqrInpDatRedLgtAltVO eqrInpDatRedLgtAltVO = null;
	public EqrInpDatRedLgtAltVO[] eqrInpDatRedLgtAltVOS = null;
	private int iPage       = 0;


	/**
	 * EesEqr0001Event constructor
	 */
	public EesEqr0001Event(){}


	public EqrInpDatRedLgtAltVO getEqrInpDatRedLgtAltVO() {
		return eqrInpDatRedLgtAltVO;
	}


	public void setEqrInpDatRedLgtAltVO(EqrInpDatRedLgtAltVO eqrInpDatRedLgtAltVO) {
		this.eqrInpDatRedLgtAltVO = eqrInpDatRedLgtAltVO;
	}


	public EqrInpDatRedLgtAltVO[] getEqrInpDatRedLgtAltVOS() {
		return eqrInpDatRedLgtAltVOS;
	}


	public void setEqrInpDatRedLgtAltVOS(
			EqrInpDatRedLgtAltVO[] eqrInpDatRedLgtAltVOS) {
		this.eqrInpDatRedLgtAltVOS = eqrInpDatRedLgtAltVOS;
	}


	public int getIPage() {
		return iPage;
	}


	public void setIPage(int page) {
		iPage = page;
	}
	

}
