/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6022Event.java
*@FileTitle : PRS- S/C Amendment CM/OP View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.22 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.PriSpScpRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriAmdCmViewAllVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;



/**
 * ESM_PRI_6022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6022HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6022Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriAmdCmViewAllVO[] rsltPriAmdCmViewAllVOs = null;
	
	/** Table Value와 그외 변수를 member로 갖는 VO */
	private PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO = null;

	public EsmPri6022Event(){}
	
	public void setPriSpScpRtCmdtRoutVO(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO){
		this. priSpScpRtCmdtRoutVO = priSpScpRtCmdtRoutVO;
	}

	public void setPriSpScpRtCmdtRoutVOS(PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOs){
		this. priSpScpRtCmdtRoutVOs = priSpScpRtCmdtRoutVOs;
	}
	
	public void setPriSpScpRtCmdtRoutSetVO(PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO){
		this. priSpScpRtCmdtRoutSetVO = priSpScpRtCmdtRoutSetVO;
	}	

	public void setRsltPriAmdCmViewAllVO(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO){
		this.rsltPriAmdCmViewAllVO = rsltPriAmdCmViewAllVO;
	}

	public void setRsltPriAmdCmViewAllVOS(RsltPriAmdCmViewAllVO[] rsltPriAmdCmViewAllVOs){
		this. rsltPriAmdCmViewAllVOs = rsltPriAmdCmViewAllVOs;
	}

	public PriSpScpRtCmdtRoutVO getPriSpScpRtCmdtRoutVO(){
		return priSpScpRtCmdtRoutVO;
	}

	public PriSpScpRtCmdtRoutVO[] getPriSpScpRtCmdtRoutVOS(){
		return priSpScpRtCmdtRoutVOs;
	}
	public PriSpScpRtCmdtRoutSetVO getPriSpScpRtCmdtRoutSetVO(){
		return priSpScpRtCmdtRoutSetVO;
	}	

	public RsltPriAmdCmViewAllVO getRsltPriAmdCmViewAllVO(){
		return rsltPriAmdCmViewAllVO;
	}

	public RsltPriAmdCmViewAllVO[] getRsltPriAmdCmViewAllVOS(){
		return rsltPriAmdCmViewAllVOs;
	}

}