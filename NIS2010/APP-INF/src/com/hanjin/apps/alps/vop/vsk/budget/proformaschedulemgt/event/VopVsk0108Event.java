/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0108Event.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskPfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;


/**
 * VOP_VSK_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see VOP_VSK_0108HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0108Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PfSkdTypeHelpVO pfSkdTypeHelpVO = null;
	private VskPfSkdVO vskPfSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PfSkdTypeHelpVO[] pfSkdTypeHelpVOs = null;
	private VskPfSkdVO[] vskPfSkdVOs = null;

	public VopVsk0108Event(){}
	
	public void setPfSkdTypeHelpVO(PfSkdTypeHelpVO pfSkdTypeHelpVO){
		this. pfSkdTypeHelpVO = pfSkdTypeHelpVO;
	}
	
	public void setVskPfSkdVO(VskPfSkdVO vskPfSkdVO){
		this. vskPfSkdVO = vskPfSkdVO;
	}
	
	public void setPfSkdTypeHelpVOS(PfSkdTypeHelpVO[] pfSkdTypeHelpVOs){
		if(pfSkdTypeHelpVOs != null){
			PfSkdTypeHelpVO[] tmpVOs = new PfSkdTypeHelpVO[pfSkdTypeHelpVOs.length];
			System.arraycopy(pfSkdTypeHelpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfSkdTypeHelpVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this. pfSkdTypeHelpVOs = pfSkdTypeHelpVOs;
	}
	
	public void setVskPfSkdVOS(VskPfSkdVO[] vskPfSkdVOs){
		if(vskPfSkdVOs != null){
			VskPfSkdVO[] tmpVOs = new VskPfSkdVO[vskPfSkdVOs.length];
			System.arraycopy(vskPfSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPfSkdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this. vskPfSkdVOs = vskPfSkdVOs;
	}

	public PfSkdTypeHelpVO getPfSkdTypeHelpVO(){
		return pfSkdTypeHelpVO;
	}
	
	public VskPfSkdVO getVskPfSkdVO(){
		return vskPfSkdVO;
	}

	public PfSkdTypeHelpVO[] getPfSkdTypeHelpVOS(){
		PfSkdTypeHelpVO[] rtnVOs =  null;
		if(this.pfSkdTypeHelpVOs != null){
			rtnVOs = new PfSkdTypeHelpVO[pfSkdTypeHelpVOs.length];
			System.arraycopy(pfSkdTypeHelpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return pfSkdTypeHelpVOs;
	}
	
	public VskPfSkdVO[] getVskPfSkdVOS(){
		VskPfSkdVO[] rtnVOs =  null;
		if(this.vskPfSkdVOs != null){
			rtnVOs = new VskPfSkdVO[vskPfSkdVOs.length];
			System.arraycopy(vskPfSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vskPfSkdVOs;
	}

}