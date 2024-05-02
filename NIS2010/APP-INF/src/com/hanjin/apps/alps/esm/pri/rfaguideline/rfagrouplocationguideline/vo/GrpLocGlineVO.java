/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GrpLocGlineVO.java
 *@FileTitle : GrpLocGlineVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.04.16 최성민 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagrouplocationguideline.vo;

import java.io.Serializable;
import java.util.List;

import com.hanjin.syscommon.common.table.PriRgGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRgGrpLocVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 최성민
 * @since J2EE 1.5
 */

public class GrpLocGlineVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriRgGrpLocVO[] prisggrplocvos = null;
	private PriRgGrpLocDtlVO[] prisggrplocdtlvos = null;
	private List<RsltPriRgGrpLocVO> rsltprisggrplocvos = null;
	private List<RsltPriRgGrpLocDtlVO> rsltprisggrplocdtlvos = null;

	public PriRgGrpLocVO[] getPriRgGrpLocVOS() {
		return prisggrplocvos;
	}

	public void setPriRgGrpLocVOS(PriRgGrpLocVO[] prisggrplocvos) {
		this.prisggrplocvos = prisggrplocvos;
	}

	public PriRgGrpLocDtlVO[] getPriRgGrpLocDtlVOS() {
		return prisggrplocdtlvos;
	}

	public void setPriRgGrpLocDtlVOS(PriRgGrpLocDtlVO[] prisggrplocdtlvos) {
		this.prisggrplocdtlvos = prisggrplocdtlvos;
	}

	public List<RsltPriRgGrpLocVO> getRsltPriRgGrpLocVOS() {
		return rsltprisggrplocvos;
	}

	public void setRsltPriRgGrpLocVOS(List<RsltPriRgGrpLocVO> rsltprisggrplocvos) {
		this.rsltprisggrplocvos = rsltprisggrplocvos;
	}

	public List<RsltPriRgGrpLocDtlVO> getRsltPriRgGrpLocDtlVOS() {
		return rsltprisggrplocdtlvos;
	}

	public void setRsltPriRgGrpLocDtlVOS(List<RsltPriRgGrpLocDtlVO> rsltprisggrplocdtlvos) {
		this.rsltprisggrplocdtlvos = rsltprisggrplocdtlvos;
	}

}
