/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GrpLocGlineVO.java
*@FileTitle : GrpLocGlineVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.04.16 변영주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo;

import java.io.Serializable;

import com.clt.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpLocVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 변영주
 * @since J2EE 1.5
 */

public class GrpLocPropVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriSpScpGrpLocVO[] prispscpgrplocvos = null;
	private PriSpScpGrpLocDtlVO[] prispscpgrplocdtlvos = null;	
	
	public PriSpScpGrpLocVO[] getPrispscpgrplocvos() {
		return prispscpgrplocvos;
	}
	public void setPriSpScpGrpLocVOs(PriSpScpGrpLocVO[] prispscpgrplocvos) {
		this.prispscpgrplocvos = prispscpgrplocvos;
	}
	public PriSpScpGrpLocDtlVO[] getPrispscpgrplocdtlvos() {
		return prispscpgrplocdtlvos;
	}
	public void setPriSpScpGrpLocDtlVOs(PriSpScpGrpLocDtlVO[] prispscpgrplocdtlvos) {
		this.prispscpgrplocdtlvos = prispscpgrplocdtlvos;
	}

	

	
	
}
