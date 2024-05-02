/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2065Event.java
 *@FileTitle : RFA Proposal Creation - Rate [Load Excel] (V Type)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.21 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * UI_PRI_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2065HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2065Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	private RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOS = null;

	public EsmPri2065Event() {
	}

	/**
	 * @return the priRpScpRtCmdtHdrVO
	 */
	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO() {
		return priRpScpRtCmdtHdrVO;
	}

	/**
	 * @param priRpScpRtCmdtHdrVO the priRpScpRtCmdtHdrVO to set
	 */
	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

	/**
	 * @return the rsltRtListVerticalExcelVOS
	 */
	public RsltRtListVerticalExcelVO[] getRsltRtListVerticalExcelVOS() {
		RsltRtListVerticalExcelVO[] tmpVOs = null;
		if (this.rsltRtListVerticalExcelVOS != null) {
			tmpVOs = new RsltRtListVerticalExcelVO[rsltRtListVerticalExcelVOS.length];
			System.arraycopy(rsltRtListVerticalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param rsltRtListVerticalExcelVOS the rsltRtListVerticalExcelVOS to set
	 */
	public void setRsltRtListVerticalExcelVOS(RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOS) {
		if (rsltRtListVerticalExcelVOS != null) {
			RsltRtListVerticalExcelVO[] tmpVOs = new RsltRtListVerticalExcelVO[rsltRtListVerticalExcelVOS.length];
			System.arraycopy(rsltRtListVerticalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListVerticalExcelVOS = tmpVOs;
		}
	}

}