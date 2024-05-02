/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0509Event.java
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.12 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalInfoConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * vop_opf_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_opf_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see vop_opf_0007HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0509Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPortGntrCrnVO vskPortGntrCrnVO = null;

	private VskComboVO vskComboVO = null;
	
	public VskComboVO getVskComboVO() {
		return vskComboVO;
	}

	public void setVskComboVO(VskComboVO vskComboVO) {
		this.vskComboVO = vskComboVO;
	}

	private TerminalInfoConditionVO terminalInfoConditionVO = null;
	
	public VopVsk0509Event(){}
	
	public void setVskPortGntrCrnVO(VskPortGntrCrnVO vskPortGntrCrnVO){
		this. vskPortGntrCrnVO = vskPortGntrCrnVO;
	}


	public VskPortGntrCrnVO getVskPortGntrCrnVO(){
		return vskPortGntrCrnVO;
	}

	public TerminalInfoConditionVO getTerminalInfoConditionVO() {
		return terminalInfoConditionVO;
	}

	public void setTerminalInfoConditionVO(
			TerminalInfoConditionVO terminalInfoConditionVO) {
		this.terminalInfoConditionVO = terminalInfoConditionVO;
	}
}