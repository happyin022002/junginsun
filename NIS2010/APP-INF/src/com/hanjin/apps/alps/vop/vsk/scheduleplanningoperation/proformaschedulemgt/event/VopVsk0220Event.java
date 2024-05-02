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
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
		PfSkdVO[] rtnVOs =  null;
		if(this.pfSkdVOs != null){
			rtnVOs = new PfSkdVO[pfSkdVOs.length];
			System.arraycopy(pfSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return pfSkdVOs;
	}

	/**
	 * @param pfSkdGRPVOs the pfSkdGRPVOs to set
	 */
	public void setPfSkdVOs(PfSkdVO[] pfSkdVOs) {
		if(pfSkdVOs != null){
			PfSkdVO[] tmpVOs = new PfSkdVO[pfSkdVOs.length];
			System.arraycopy(pfSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfSkdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.pfSkdVOs = pfSkdVOs;
	}



}