/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0120Event.java
 *@FileTitle : EsmPri0120Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.11
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2010.03.11 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event;

import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtListExcelVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgRtCmdtHdrVO;

/**
 * ESM_PRI_0120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_0120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Sungsoo
 * @see ESM_PRI_0120HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0120Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSgRtCmdtHdrVO priSgRtCmdtHdrVO = null;
	private RsltRtListExcelVO[] rsltRtListExcelVOS = null;

	public EsmPri0120Event() {
	}

	/**
	 * @return the priSgRtCmdtHdrVO
	 */
	public PriSgRtCmdtHdrVO getPriSgRtCmdtHdrVO() {
		return priSgRtCmdtHdrVO;
	}

	/**
	 * @param priSgRtCmdtHdrVO the priSgRtCmdtHdrVO to set
	 */
	public void setPriSgRtCmdtHdrVO(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) {
		this.priSgRtCmdtHdrVO = priSgRtCmdtHdrVO;
	}

	/**
	 * @return the rsltRtListExcelVOS
	 */
	public RsltRtListExcelVO[] getRsltRtListExcelVOS() {
		return rsltRtListExcelVOS;
	}

	/**
	 * @param rsltRtListExcelVOS the rsltRtListExcelVOS to set
	 */
	public void setRsltRtListExcelVOS(RsltRtListExcelVO[] rsltRtListExcelVOS) {
		this.rsltRtListExcelVOS = rsltRtListExcelVOS;
	}

}