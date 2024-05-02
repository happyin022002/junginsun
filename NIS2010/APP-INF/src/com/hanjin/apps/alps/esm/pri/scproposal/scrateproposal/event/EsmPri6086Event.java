/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri6086Event.java
*@FileTitle : SC Proposal/Amendment Surcharge View All
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;


/**
 * ESM_PRI_6086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6086HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6086Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOs = null;

	public EsmPri6086Event(){}
	
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

}