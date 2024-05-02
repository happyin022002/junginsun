/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0507Event.java
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.25 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskPortFltgCrnVO;
import com.clt.syscommon.common.table.VskPortGngStrcVO;


/**
 * vop_opf_0507 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_opf_0507HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see vop_opf_0507HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0507Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPortGntrCrnVO vskPortGntrCrnVO = null;

	
	private TerminalInfoConditionVO terminalInfoConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskPortGntrCrnVO[] vskPortGntrCrnVOs = null;

	private VskPortFltgCrnVO[] vskPortFltgCrnVOs = null;

	private VskPortGngStrcVO[] vskPortGngStrcVOs = null;
	
	private VskPortBrthWdoVO[] vskPortBrthWdoVOs = null;

	public VopVsk0507Event(){}
	
	public void setVskPortGntrCrnVO(VskPortGntrCrnVO vskPortGntrCrnVO){
		this. vskPortGntrCrnVO = vskPortGntrCrnVO;
	}

	public void setVskPortGntrCrnVOS(VskPortGntrCrnVO[] vskPortGntrCrnVOs){
		if(vskPortGntrCrnVOs != null){
			VskPortGntrCrnVO[] tmpVOs = Arrays.copyOf(vskPortGntrCrnVOs, vskPortGntrCrnVOs.length);
			this.vskPortGntrCrnVOs = tmpVOs;
		}
	}

	public VskPortGntrCrnVO getVskPortGntrCrnVO(){
		return vskPortGntrCrnVO;
	}

	public VskPortGntrCrnVO[] getVskPortGntrCrnVOS(){
		VskPortGntrCrnVO[] rtnVOs = null;
		if (this.vskPortGntrCrnVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortGntrCrnVOs, vskPortGntrCrnVOs.length);
		}
		return rtnVOs;
	}

	public TerminalInfoConditionVO getTerminalInfoConditionVO() {
		return terminalInfoConditionVO;
	}

	public void setTerminalInfoConditionVO(
			TerminalInfoConditionVO terminalInfoConditionVO) {
		this.terminalInfoConditionVO = terminalInfoConditionVO;
	}

	public VskPortFltgCrnVO[] getVskPortFltgCrnVOS() {
		VskPortFltgCrnVO[] rtnVOs = null;
		if (this.vskPortFltgCrnVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortFltgCrnVOs, vskPortFltgCrnVOs.length);
		}
		return rtnVOs;
	}

	public void setVskPortFltgCrnVOS(VskPortFltgCrnVO[] vskPortFltgCrnVOs) {
		if(vskPortFltgCrnVOs != null){
			VskPortFltgCrnVO[] tmpVOs = Arrays.copyOf(vskPortFltgCrnVOs, vskPortFltgCrnVOs.length);
			this.vskPortFltgCrnVOs = tmpVOs;
		}
	}
	
	public VskPortGngStrcVO[] getVskPortGngStrcVOS() {
		VskPortGngStrcVO[] rtnVOs = null;
		if (this.vskPortGngStrcVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortGngStrcVOs, vskPortGngStrcVOs.length);
		}
		return rtnVOs;
	}

	public void setVskPortGngStrcVOS(VskPortGngStrcVO[] vskPortGngStrcVOs) {
		if(vskPortGngStrcVOs != null){
			VskPortGngStrcVO[] tmpVOs = Arrays.copyOf(vskPortGngStrcVOs, vskPortGngStrcVOs.length);
			this.vskPortGngStrcVOs = tmpVOs;
		}
	}

	public VskPortBrthWdoVO[] getVskPortBrthWdoVOS() {
		VskPortBrthWdoVO[] rtnVOs = null;
		if (this.vskPortBrthWdoVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortBrthWdoVOs, vskPortBrthWdoVOs.length);
		}
		return rtnVOs;
	}

	public void setVskPortBrthWdoVOS(VskPortBrthWdoVO[] vskPortBrthWdoVOs) {
		if(vskPortBrthWdoVOs != null){
			VskPortBrthWdoVO[] tmpVOs = Arrays.copyOf(vskPortBrthWdoVOs, vskPortBrthWdoVOs.length);
			this.vskPortBrthWdoVOs = tmpVOs;
		}
	}
}