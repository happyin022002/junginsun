/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0019Event.java
*@FileTitle : VSL SKD Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.05.28 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0019HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVsk0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CstSkdByVvdVO cstSkdByVvdVO = null;
	
	private VvdVO vvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CstSkdByVvdVO[] cstSkdByVvdVOs = null;
	
	private VvdVO[] vvdVOs = null;

	public VopVsk0019Event(){}

	/**
	 * @return the cstSkdByVvdVO
	 */
	public CstSkdByVvdVO getCstSkdByVvdVO() {
		return cstSkdByVvdVO;
	}

	/**
	 * @param cstSkdByVvdVO the cstSkdByVvdVO to set
	 */
	public void setCstSkdByVvdVO(CstSkdByVvdVO cstSkdByVvdVO) {
		this.cstSkdByVvdVO = cstSkdByVvdVO;
	}

	/**
	 * @return the cstSkdByVvdVOs
	 */
	public CstSkdByVvdVO[] getCstSkdByVvdVOs() {
		CstSkdByVvdVO[] rtnVOs =  null;
		if(this.cstSkdByVvdVOs != null){
			rtnVOs = new CstSkdByVvdVO[cstSkdByVvdVOs.length];
			System.arraycopy(cstSkdByVvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return cstSkdByVvdVOs;
	}

	/**
	 * @param cstSkdByVvdVOs the cstSkdByVvdVOs to set
	 */
	public void setCstSkdByVvdVOs(CstSkdByVvdVO[] cstSkdByVvdVOs) {
		if(cstSkdByVvdVOs != null){
			CstSkdByVvdVO[] tmpVOs = new CstSkdByVvdVO[cstSkdByVvdVOs.length];
			System.arraycopy(cstSkdByVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstSkdByVvdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.cstSkdByVvdVOs = cstSkdByVvdVOs;
	}

	/**
	 * @return the vvdVO
	 */
	public VvdVO getVvdVO() {
		return vvdVO;
	}

	/**
	 * @param vvdVO the vvdVO to set
	 */
	public void setVvdVO(VvdVO vvdVO) {
		this.vvdVO = vvdVO;
	}

	/**
	 * @return the vvdVOs
	 */
	public VvdVO[] getVvdVOs() {
		VvdVO[] rtnVOs =  null;
		if(this.vvdVOs != null){
			rtnVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vvdVOs;
	}

	/**
	 * @param vvdVOs the vvdVOs to set
	 */
	public void setVvdVOs(VvdVO[] vvdVOs) {
		if(vvdVOs != null){
			VvdVO[] tmpVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vvdVOs = vvdVOs;
	}
}