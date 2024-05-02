/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6056Event.java
*@FileTitle : RFA Quotation Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.19 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;


import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRqRtCmdtHdrVO;


/**
 * ESM_PRI_6056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eun-Sup, Lee
 * @see ESM_PRI_6056HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = null;
	private RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS = null;

	public EsmPri6056Event() {
	}

	/**
	 * @return the priRqRtCmdtHdrVO
	 */
	public PriRqRtCmdtHdrVO getPriRqRtCmdtHdrVO() {
		return priRqRtCmdtHdrVO;
	}

	/**
	 * @param priRqRtCmdtHdrVO the priRqRtCmdtHdrVO to set
	 */
	public void setPriRqRtCmdtHdrVO(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) {
		this.priRqRtCmdtHdrVO = priRqRtCmdtHdrVO;
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
	public void setRsltRtListHorizontalExcelVOS(
			RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS) {
		this.rsltRtListHorizontalExcelVOS = rsltRtListHorizontalExcelVOS;
	}

	
	
}