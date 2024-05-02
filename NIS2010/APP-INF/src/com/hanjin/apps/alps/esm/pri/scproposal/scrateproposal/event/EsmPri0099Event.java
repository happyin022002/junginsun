/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0099Event.java
 *@FileTitle : EsmPri0099Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.07.30 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;

/**
 * UI_PRI_0099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0099HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0029HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0099Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO = null;
	private RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS = null;

	public EsmPri0099Event() {
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

	/**
	 * @return the rsltRtListHorizontalExcelVOS
	 */
	public RsltRtListHorizontalExcelVO[] getRsltRtListHorizontalExcelVOS() {
		return rsltRtListHorizontalExcelVOS;
	}

	/**
	 * @param rsltRtListHorizontalExcelVOS the rsltRtListHorizontalExcelVOS to set
	 */
	public void setRsltRtListHorizontalExcelVOS(RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS) {
		this.rsltRtListHorizontalExcelVOS = rsltRtListHorizontalExcelVOS;
	}

}