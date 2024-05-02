/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0029Event.java
 *@FileTitle : EsmPri0029Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.24
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.07.24 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;

/**
 * UI_PRI_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0029HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO = null;
	private RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOS = null;

	public EsmPri0029Event() {
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

	/**
	 * @return the priSpScpRtCmdtHdrVO
	 */
	public PriSpScpRtCmdtHdrVO getPriSpScpRtCmdtHdrVO() {
		return priSpScpRtCmdtHdrVO;
	}

	/**
	 * @param priSpScpRtCmdtHdrVO the priSpScpRtCmdtHdrVO to set
	 */
	public void setPriSpScpRtCmdtHdrVO(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) {
		this.priSpScpRtCmdtHdrVO = priSpScpRtCmdtHdrVO;
	}

}