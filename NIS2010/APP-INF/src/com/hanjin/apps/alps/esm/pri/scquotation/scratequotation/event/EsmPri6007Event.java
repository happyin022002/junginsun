/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri600503Event.java
*@FileTitle : S/C Quotation Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.12 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;


import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSqRtCmdtHdrVO;


/**
 * ESM_PRI_6007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSqRtCmdtHdrVO priSqRtCmdtHdrVO = null;
	private RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOS = null;

	public EsmPri6007Event() {
	}

	/**
	 * @return the priSqRtCmdtHdrVO
	 */
	public PriSqRtCmdtHdrVO getPriSqRtCmdtHdrVO() {
		return priSqRtCmdtHdrVO;
	}

	/**
	 * @param priSqRtCmdtHdrVO the priSqRtCmdtHdrVO to set
	 */
	public void setPriSqRtCmdtHdrVO(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) {
		this.priSqRtCmdtHdrVO = priSqRtCmdtHdrVO;
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
	public void setRsltRtListVerticalExcelVOS(
			RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOS) {
		this.rsltRtListVerticalExcelVOS = rsltRtListVerticalExcelVOS;
	}

	
}