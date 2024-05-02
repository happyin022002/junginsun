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
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;



import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRqRtCmdtHdrVO;


/**
 * ESM_PRI_6057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6057HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = null;
	private RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOS = null;

	public EsmPri6057Event() {
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