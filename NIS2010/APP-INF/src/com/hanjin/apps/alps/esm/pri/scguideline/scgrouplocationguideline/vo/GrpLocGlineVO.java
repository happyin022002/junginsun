/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GrpLocGlineVO.java
 *@FileTitle : GrpLocGlineVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo;

import java.io.Serializable;
import java.util.List;

import com.hanjin.syscommon.common.table.PriSgGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSgGrpLocVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class GrpLocGlineVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriSgGrpLocVO[] prisggrplocvos = null;
	private PriSgGrpLocDtlVO[] prisggrplocdtlvos = null;
	private List<RsltPriSgGrpLocVO> rsltprisggrplocvos = null;
	private List<RsltPriSgGrpLocDtlVO> rsltprisggrplocdtlvos = null;

	public PriSgGrpLocVO[] getPriSgGrpLocVOS() {
		return prisggrplocvos;
	}

	public void setPriSgGrpLocVOS(PriSgGrpLocVO[] prisggrplocvos) {
		this.prisggrplocvos = prisggrplocvos;
	}

	public PriSgGrpLocDtlVO[] getPriSgGrpLocDtlVOS() {
		return prisggrplocdtlvos;
	}

	public void setPriSgGrpLocDtlVOS(PriSgGrpLocDtlVO[] prisggrplocdtlvos) {
		this.prisggrplocdtlvos = prisggrplocdtlvos;
	}

	public List<RsltPriSgGrpLocVO> getRsltPriSgGrpLocVOS() {
		return rsltprisggrplocvos;
	}

	public void setRsltPriSgGrpLocVOS(List<RsltPriSgGrpLocVO> rsltprisggrplocvos) {
		this.rsltprisggrplocvos = rsltprisggrplocvos;
	}

	public List<RsltPriSgGrpLocDtlVO> getRsltPriSgGrpLocDtlVOS() {
		return rsltprisggrplocdtlvos;
	}

	public void setRsltPriSgGrpLocDtlVOS(List<RsltPriSgGrpLocDtlVO> rsltprisggrplocdtlvos) {
		this.rsltprisggrplocdtlvos = rsltprisggrplocdtlvos;
	}

}
