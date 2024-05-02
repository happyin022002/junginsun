/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2073Event.java
 *@FileTitle : RFA Proposal Inquiry - Rate (Route Note)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.21 박성수
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.GrpNoteConvVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvCommVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;

/**
 * UI_PRI_0097 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0097HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2073HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2073Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOS = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRfaNoteConvVO priRfaNoteConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRfaNoteConvVO[] priRfaNoteConvVOs = null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GrpNoteConvVO grpNoteConvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRfaNoteConvCommVO  priRfaNoteConvCommVO = null;

	public EsmPri2073Event() {
	}

	/**
	 * @return the priRpScpRtCmdtRnoteVOS
	 */
	public PriRpScpRtCmdtRnoteVO[] getPriRpScpRtCmdtRnoteVOS() {
		PriRpScpRtCmdtRnoteVO[] rtnVOs = null;
		if (this.priRpScpRtCmdtRnoteVOS != null) {
			rtnVOs = new PriRpScpRtCmdtRnoteVO[priRpScpRtCmdtRnoteVOS.length];
			System.arraycopy(priRpScpRtCmdtRnoteVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtCmdtRnoteVOS the priRpScpRtCmdtRnoteVOS to set
	 */
	public void setPriRpScpRtCmdtRnoteVOS(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOS){
		if(priRpScpRtCmdtRnoteVOS != null){
			PriRpScpRtCmdtRnoteVO[] tmpVOs = new PriRpScpRtCmdtRnoteVO[priRpScpRtCmdtRnoteVOS.length];
			System.arraycopy(priRpScpRtCmdtRnoteVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtRnoteVOS = tmpVOs;
		}
	}

	public PriRfaNoteConvVO getPriRfaNoteConvVO() {
		return priRfaNoteConvVO;
	}

	public PriRfaNoteConvVO[] getPriRfaNoteConvVOs() {
		PriRfaNoteConvVO[] rtnVOs = null;
		if (this.priRfaNoteConvVOs != null) {
			rtnVOs = new PriRfaNoteConvVO[priRfaNoteConvVOs.length];
			System.arraycopy(priRfaNoteConvVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
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

	public void setPriRfaNoteConvVOs(PriRfaNoteConvVO[] priRfaNoteConvVOs){
		if(priRfaNoteConvVOs != null){
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