/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0220Event.java
*@FileTitle : Information Input for SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.05.19 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0220 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0220HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0220HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0220Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PfSkdVO pfSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PfSkdVO[] pfSkdVOs = null;

	public VopVsk0220Event(){}

	/**
	 * @return the pfSkdGRPVO
	 */
	public PfSkdVO getPfSkdVO() {
		return pfSkdVO;
	}

	/**
	 * @param pfSkdGRPVO the pfSkdGRPVO to set
	 */
	public void setPfSkdVO(PfSkdVO pfSkdVO) {
		this.pfSkdVO = pfSkdVO;
	}

	/**
	 * @return the pfSkdGRPVOs
	 */
	public PfSkdVO[] getPfSkdVOs() {
		PfSkdVO[] rtnVOs = null;
		if (this.pfSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.pfSkdVOs, this.pfSkdVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param pfSkdGRPVOs the pfSkdGRPVOs to set
	 */
	public void setPfSkdVOs(PfSkdVO[] pfSkdVOs) {
		if (pfSkdVOs != null) {
			PfSkdVO[] tmpVOs = Arrays.copyOf(pfSkdVOs, pfSkdVOs.length);
			this.pfSkdVOs = tmpVOs;
		} // end if
	}



}