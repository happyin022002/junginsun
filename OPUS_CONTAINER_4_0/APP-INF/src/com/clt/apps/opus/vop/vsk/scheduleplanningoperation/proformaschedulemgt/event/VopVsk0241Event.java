/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0241Event.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.04.30 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskPfSkdVO;


/**
 * VOP_VSK_0241 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0241HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0241HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0241Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PfSkdTypeHelpVO pfSkdTypeHelpVO = null;
	private VskPfSkdVO vskPfSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PfSkdTypeHelpVO[] pfSkdTypeHelpVOs = null;
	private VskPfSkdVO[] vskPfSkdVOs = null;

	public VopVsk0241Event(){}
	
	public void setPfSkdTypeHelpVO(PfSkdTypeHelpVO pfSkdTypeHelpVO){
		this. pfSkdTypeHelpVO = pfSkdTypeHelpVO;
	}
	
	public void setVskPfSkdVO(VskPfSkdVO vskPfSkdVO){
		this. vskPfSkdVO = vskPfSkdVO;
	}
	
	public void setPfSkdTypeHelpVOS(PfSkdTypeHelpVO[] pfSkdTypeHelpVOs){
		if (pfSkdTypeHelpVOs != null) {
			PfSkdTypeHelpVO[] tmpVOs = Arrays.copyOf(pfSkdTypeHelpVOs, pfSkdTypeHelpVOs.length);
			this.pfSkdTypeHelpVOs = tmpVOs;
		} // end if
	}
	
	public void setVskPfSkdVOS(VskPfSkdVO[] vskPfSkdVOs){
		if (vskPfSkdVOs != null) {
			VskPfSkdVO[] tmpVOs = Arrays.copyOf(vskPfSkdVOs, vskPfSkdVOs.length);
			this.vskPfSkdVOs = tmpVOs;
		} // end if
	}

	public PfSkdTypeHelpVO getPfSkdTypeHelpVO(){
		return pfSkdTypeHelpVO;
	}
	
	public VskPfSkdVO getVskPfSkdVO(){
		return vskPfSkdVO;
	}

	public PfSkdTypeHelpVO[] getPfSkdTypeHelpVOS(){
		PfSkdTypeHelpVO[] rtnVOs = null;
		if (this.pfSkdTypeHelpVOs != null) {
			rtnVOs = Arrays.copyOf(this.pfSkdTypeHelpVOs, this.pfSkdTypeHelpVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public VskPfSkdVO[] getVskPfSkdVOS(){
		VskPfSkdVO[] rtnVOs = null;
		if (this.vskPfSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskPfSkdVOs, this.vskPfSkdVOs.length);
		} // end if
		return rtnVOs;
	}

}