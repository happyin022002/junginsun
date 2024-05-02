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
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalInfoConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskPortFltgCrnVO;
import com.hanjin.syscommon.common.table.VskPortGngStrcVO;


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
			VskPortGntrCrnVO[] tmpVOs = new VskPortGntrCrnVO[vskPortGntrCrnVOs.length];
			System.arraycopy(vskPortGntrCrnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortGntrCrnVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vskPortGntrCrnVOs = vskPortGntrCrnVOs;
	}

	public VskPortGntrCrnVO getVskPortGntrCrnVO(){
		return vskPortGntrCrnVO;
	}

	public VskPortGntrCrnVO[] getVskPortGntrCrnVOS(){
		VskPortGntrCrnVO[] rtnVOs =  null;
		if(this.vskPortGntrCrnVOs != null){
			rtnVOs = new VskPortGntrCrnVO[vskPortGntrCrnVOs.length];
			System.arraycopy(vskPortGntrCrnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortGntrCrnVOs;
	}

	public TerminalInfoConditionVO getTerminalInfoConditionVO() {
		return terminalInfoConditionVO;
	}

	public void setTerminalInfoConditionVO(
			TerminalInfoConditionVO terminalInfoConditionVO) {
		this.terminalInfoConditionVO = terminalInfoConditionVO;
	}

	public VskPortFltgCrnVO[] getVskPortFltgCrnVOS() {
		VskPortFltgCrnVO[] rtnVOs =  null;
		if(this.vskPortFltgCrnVOs != null){
			rtnVOs = new VskPortFltgCrnVO[vskPortFltgCrnVOs.length];
			System.arraycopy(vskPortFltgCrnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortFltgCrnVOs;
	}

	public void setVskPortFltgCrnVOS(VskPortFltgCrnVO[] vskPortFltgCrnVOs) {
		if(vskPortFltgCrnVOs != null){
			VskPortFltgCrnVO[] tmpVOs = new VskPortFltgCrnVO[vskPortFltgCrnVOs.length];
			System.arraycopy(vskPortFltgCrnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortFltgCrnVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vskPortFltgCrnVOs = vskPortFltgCrnVOs;
	}
	
	public VskPortGngStrcVO[] getVskPortGngStrcVOS() {
		VskPortGngStrcVO[] rtnVOs =  null;
		if(this.vskPortGngStrcVOs != null){
			rtnVOs = new VskPortGngStrcVO[vskPortGngStrcVOs.length];
			System.arraycopy(vskPortGngStrcVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortGngStrcVOs;
	}

	public void setVskPortGngStrcVOS(VskPortGngStrcVO[] vskPortGngStrcVOs) {
		if(vskPortGngStrcVOs != null){
			VskPortGngStrcVO[] tmpVOs = new VskPortGngStrcVO[vskPortGngStrcVOs.length];
			System.arraycopy(vskPortGngStrcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortGngStrcVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vskPortGngStrcVOs = vskPortGngStrcVOs;
	}

	public VskPortBrthWdoVO[] getVskPortBrthWdoVOS() {
		VskPortBrthWdoVO[] rtnVOs =  null;
		if(this.vskPortBrthWdoVOs != null){
			rtnVOs = new VskPortBrthWdoVO[vskPortBrthWdoVOs.length];
			System.arraycopy(vskPortBrthWdoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortBrthWdoVOs;
	}

	public void setVskPortBrthWdoVOS(VskPortBrthWdoVO[] vskPortBrthWdoVOs) {
		if(vskPortBrthWdoVOs != null){
			VskPortBrthWdoVO[] tmpVOs = new VskPortBrthWdoVO[vskPortBrthWdoVOs.length];
			System.arraycopy(vskPortBrthWdoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortBrthWdoVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vskPortBrthWdoVOs = vskPortBrthWdoVOs;
	}
}