/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0245Event.java
*@FileTitle : Port Skip Recorder for Statistics
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.05.26 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0245 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0245HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0245HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVsk0245Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CodeInfoVO codeInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CodeInfoVO[] codeInfoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VvdVO vvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VvdVO[] vvdVOs = null;

	public VopVsk0245Event(){}

	/**
	 * @return the codeInfoVO
	 */
	public CodeInfoVO getCodeInfoVO() {
		return codeInfoVO;
	}

	/**
	 * @param codeInfoVO the codeInfoVO to set
	 */
	public void setCodeInfoVO(CodeInfoVO codeInfoVO) {
		this.codeInfoVO = codeInfoVO;
	}

	/**
	 * @return the codeInfoVOs
	 */
	public CodeInfoVO[] getCodeInfoVOS() {
		CodeInfoVO[] rtnVOs =  null;
		if(this.codeInfoVOs != null){
			rtnVOs = new CodeInfoVO[codeInfoVOs.length];
			System.arraycopy(codeInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return codeInfoVOs;
	}

	/**
	 * @param codeInfoVOs the codeInfoVOs to set
	 */
	public void setCodeInfoVOS(CodeInfoVO[] codeInfoVOs) {
		if(codeInfoVOs != null){
			CodeInfoVO[] tmpVOs = new CodeInfoVO[codeInfoVOs.length];
			System.arraycopy(codeInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.codeInfoVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.codeInfoVOs = codeInfoVOs;
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