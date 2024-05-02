/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2072Event.java
 *@FileTitle : RFA Proposal Inquiry - Rate (Commodity Note)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.21 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.GrpNoteConvVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvCommVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRfaNoteConvVO;
import com.clt.syscommon.common.table.PriRpScpRtCnoteVO;

/**
 * UI_PRI_0091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2022HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2072Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRfaNoteConvVO priRfaNoteConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRfaNoteConvVO[] priRfaNoteConvVOs = null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GrpNoteConvVO grpNoteConvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRfaNoteConvCommVO  priRfaNoteConvCommVO = null;

	public EsmPri2072Event() {
	}

	/**
	 * @return the priRpScpRtCnoteVOS
	 */
	public PriRpScpRtCnoteVO[] getPriRpScpRtCnoteVOS() {
		PriRpScpRtCnoteVO[] tmpVOs = null;
		if (this.priRpScpRtCnoteVOS != null) {
			tmpVOs = new PriRpScpRtCnoteVO[priRpScpRtCnoteVOS.length];
			System.arraycopy(priRpScpRtCnoteVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtCnoteVOS the priRpScpRtCnoteVOS to set
	 */
	public void setPriRpScpRtCnoteVOS(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS) {
		if (priRpScpRtCnoteVOS != null) {
			PriRpScpRtCnoteVO[] tmpVOs = new PriRpScpRtCnoteVO[priRpScpRtCnoteVOS.length];
			System.arraycopy(priRpScpRtCnoteVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCnoteVOS = tmpVOs;
		}
	}

	public PriRfaNoteConvVO getPriRfaNoteConvVO() {
		return priRfaNoteConvVO;
	}

	public PriRfaNoteConvVO[] getPriRfaNoteConvVOs() {
		PriRfaNoteConvVO[] tmpVOs = null;
		if (this.priRfaNoteConvVOs != null) {
			tmpVOs = new PriRfaNoteConvVO[priRfaNoteConvVOs.length];
			System.arraycopy(priRfaNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public GrpNoteConvVO getGrpNoteConvVO() {
		return grpNoteConvVO;
	}

	public PriRfaNoteConvCommVO getPriRfaNoteConvCommVO() {
		return priRfaNoteConvCommVO;
	}

	public void setPriRfaNoteConvVO(PriRfaNoteConvVO priRfaNoteConvVO) {
		this.priRfaNoteConvVO = priRfaNoteConvVO;
	}

	public void setPriRfaNoteConvVOs(PriRfaNoteConvVO[] priRfaNoteConvVOs) {
		if (priRfaNoteConvVOs != null) {
			PriRfaNoteConvVO[] tmpVOs = new PriRfaNoteConvVO[priRfaNoteConvVOs.length];
			System.arraycopy(priRfaNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRfaNoteConvVOs = tmpVOs;
		}
	}

	public void setGrpNoteConvVO(GrpNoteConvVO grpNoteConvVO) {
		this.grpNoteConvVO = grpNoteConvVO;
	}

	public void setPriRfaNoteConvCommVO(PriRfaNoteConvCommVO priRfaNoteConvCommVO) {
		this.priRfaNoteConvCommVO = priRfaNoteConvCommVO;
	}

}