/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri200101Event.java
 *@FileTitle : Guideline Creation - Location Group
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.27
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.07.27 최성민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.GrpLocGlineVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocDtlVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriRgGrpLocVO;

/**
 * ESM_PRI_2001_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_2001_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_2001_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri200101Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRgGrpLocVO prisggrplocvo = null;

	/** Table Value Object Multi Data 처리 */
	private PriRgGrpLocVO[] prisggrplocvos = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriRgGrpLocDtlVO prisggrplocdtlvo = null;

	/** Table Value Object Multi Data 처리 */
	private PriRgGrpLocDtlVO[] prisggrplocdtlvos = null;

	private GrpLocGlineVO grplocglinevo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltCdListVO rsltCdListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRgGrpLocDtlVO[] rsltPriRgGrpLocDtlVOs = null;

	public EsmPri200101Event() {
	}

	public PriRgGrpLocVO getPriRgGrpLocVO() {
		return prisggrplocvo;
	}

	public void setPriRgGrpLocVO(PriRgGrpLocVO prisggrplocvo) {
		this.prisggrplocvo = prisggrplocvo;
	}

	public PriRgGrpLocVO[] getPriRgGrpLocVOS() {
		PriRgGrpLocVO[] tmpVOs = null;
		if (this.prisggrplocvos != null) {
			tmpVOs = new PriRgGrpLocVO[prisggrplocvos.length];
			System.arraycopy(prisggrplocvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriRgGrpLocVOS(PriRgGrpLocVO[] prisggrplocvos) {
		if (prisggrplocvos != null) {
			PriRgGrpLocVO[] tmpVOs = new PriRgGrpLocVO[prisggrplocvos.length];
			System.arraycopy(prisggrplocvos, 0, tmpVOs, 0, tmpVOs.length);
			this.prisggrplocvos = tmpVOs;
		}
	}

	public PriRgGrpLocDtlVO getPriRgGrpLocDtlVO() {
		return prisggrplocdtlvo;
	}

	public void setPriRgGrpLocDtlVO(PriRgGrpLocDtlVO prisggrplocdtlvo) {
		this.prisggrplocdtlvo = prisggrplocdtlvo;
	}

	public PriRgGrpLocDtlVO[] getPriRgGrpLocDtlVOS() {
		PriRgGrpLocDtlVO[] tmpVOs = null;
		if (this.prisggrplocdtlvos != null) {
			tmpVOs = new PriRgGrpLocDtlVO[prisggrplocdtlvos.length];
			System.arraycopy(prisggrplocdtlvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriRgGrpLocDtlVOS(PriRgGrpLocDtlVO[] prisggrplocdtlvos) {
		if (prisggrplocdtlvos != null) {
			PriRgGrpLocDtlVO[] tmpVOs = new PriRgGrpLocDtlVO[prisggrplocdtlvos.length];
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

	public RsltCdListVO getRsltCdListVO() {
		return rsltCdListVO;
	}

	public void setRsltCdListVO(RsltCdListVO rsltCdListVO) {
		this.rsltCdListVO = rsltCdListVO;
	}

	public RsltPriRgGrpLocDtlVO[] getRsltPriRgGrpLocDtlVOs() {
		RsltPriRgGrpLocDtlVO[] tmpVOs = null;
		if (this.rsltPriRgGrpLocDtlVOs != null) {
			tmpVOs = new RsltPriRgGrpLocDtlVO[rsltPriRgGrpLocDtlVOs.length];
			System.arraycopy(rsltPriRgGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltPriRgGrpLocDtlVOs(RsltPriRgGrpLocDtlVO[] rsltPriRgGrpLocDtlVOs) {
		if (rsltPriRgGrpLocDtlVOs != null) {
			RsltPriRgGrpLocDtlVO[] tmpVOs = new RsltPriRgGrpLocDtlVO[rsltPriRgGrpLocDtlVOs.length];
			System.arraycopy(rsltPriRgGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriRgGrpLocDtlVOs = tmpVOs;
		}
	}
	
	

}