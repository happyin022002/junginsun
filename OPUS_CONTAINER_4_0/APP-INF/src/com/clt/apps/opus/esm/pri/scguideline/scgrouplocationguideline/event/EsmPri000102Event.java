/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0001Event.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.event;

import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.GrpLocGlineVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSgGrpLocVO;

/**
 * UI_PRI_0001_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0001_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_0001_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000102Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSgGrpLocVO prisggrplocvo = null;

	/** Table Value Object Multi Data 처리 */
	private PriSgGrpLocVO[] prisggrplocvos = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSgGrpLocDtlVO prisggrplocdtlvo = null;

	/** Table Value Object Multi Data 처리 */
	private PriSgGrpLocDtlVO[] prisggrplocdtlvos = null;

	private GrpLocGlineVO grplocglinevo = null;

	public EsmPri000102Event() {
	}

	public PriSgGrpLocVO getPriSgGrpLocVO() {
		return prisggrplocvo;
	}

	public void setPriSgGrpLocVO(PriSgGrpLocVO prisggrplocvo) {
		this.prisggrplocvo = prisggrplocvo;
	}

	public PriSgGrpLocVO[] getPriSgGrpLocVOS() {
		PriSgGrpLocVO[] tmpVOs = null;
		if (this.prisggrplocvos != null) {
			tmpVOs = new PriSgGrpLocVO[prisggrplocvos.length];
			System.arraycopy(prisggrplocvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSgGrpLocVOS(PriSgGrpLocVO[] prisggrplocvos) {
		if (prisggrplocvos != null) {
			PriSgGrpLocVO[] tmpVOs = new PriSgGrpLocVO[prisggrplocvos.length];
			System.arraycopy(prisggrplocvos, 0, tmpVOs, 0, tmpVOs.length);
			this.prisggrplocvos = tmpVOs;
		}
	}

	public PriSgGrpLocDtlVO getPriSgGrpLocDtlVO() {
		return prisggrplocdtlvo;
	}

	public void setPriSgGrpLocDtlVO(PriSgGrpLocDtlVO prisggrplocdtlvo) {
		this.prisggrplocdtlvo = prisggrplocdtlvo;
	}

	public PriSgGrpLocDtlVO[] getPriSgGrpLocDtlVOS() {
		PriSgGrpLocDtlVO[] tmpVOs = null;
		if (this.prisggrplocdtlvos != null) {
			tmpVOs = new PriSgGrpLocDtlVO[prisggrplocdtlvos.length];
			System.arraycopy(prisggrplocdtlvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSgGrpLocDtlVOS(PriSgGrpLocDtlVO[] prisggrplocdtlvos) {
		if (prisggrplocdtlvos != null) {
			PriSgGrpLocDtlVO[] tmpVOs = new PriSgGrpLocDtlVO[prisggrplocdtlvos.length];
			System.arraycopy(prisggrplocdtlvos, 0, tmpVOs, 0, tmpVOs.length);
			this.prisggrplocdtlvos = tmpVOs;
		}
	}

	public GrpLocGlineVO getGrpLocGlineVO() {
		return grplocglinevo;
	}

	public void setGrpLocGlineVO(GrpLocGlineVO grplocglinevo) {
		this.grplocglinevo = grplocglinevo;
	}

}