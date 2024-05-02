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
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;

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
		return rsltRtListVerticalExcelVOS;
	}

	/**
	 * @param rsltRtListVerticalExcelVOS the rsltRtListVerticalExcelVOS to set
	 */
	public void setRsltRtListVerticalExcelVOS(RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOS) {
		this.rsltRtListVerticalExcelVOS = rsltRtListVerticalExcelVOS;
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