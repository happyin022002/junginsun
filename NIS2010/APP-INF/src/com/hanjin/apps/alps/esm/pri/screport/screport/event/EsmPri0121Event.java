/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri0121Event.java
*@FileTitle : MOT Filing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 강효진
*@LastVersion : 1.0
* 2010.04.21 강효진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCMOTFilingListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;


/**
 * ESM_PRI_0121 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0121HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KANG HYO JIN
 * @see ESM_PRI_0121HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0121Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOs = null;
	
	private RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO = null;

	public EsmPri0121Event(){}
	
	public void setPriSpScpRtCmdtHdrVO(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO){
		this. priSpScpRtCmdtHdrVO = priSpScpRtCmdtHdrVO;
	}

	public void setPriSpScpRtCmdtHdrVOS(PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOs){
		this. priSpScpRtCmdtHdrVOs = priSpScpRtCmdtHdrVOs;
	}

	public PriSpScpRtCmdtHdrVO getPriSpScpRtCmdtHdrVO(){
		return priSpScpRtCmdtHdrVO;
	}

	public PriSpScpRtCmdtHdrVO[] getPriSpScpRtCmdtHdrVOS(){
		return priSpScpRtCmdtHdrVOs;
	}

	/**
	 * @return the rsltSearchSCMOTFilingListVO
	 */
	public RsltSearchSCMOTFilingListVO getRsltSearchSCMOTFilingListVO() {
		return rsltSearchSCMOTFilingListVO;
	}

	/**
	 * @param rsltSearchSCMOTFilingListVO the rsltSearchSCMOTFilingListVO to set
	 */
	public void setRsltSearchSCMOTFilingListVO(
			RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO) {
		this.rsltSearchSCMOTFilingListVO = rsltSearchSCMOTFilingListVO;
	}

}