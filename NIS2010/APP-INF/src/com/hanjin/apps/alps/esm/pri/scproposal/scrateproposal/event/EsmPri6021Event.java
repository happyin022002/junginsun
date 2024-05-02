/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6021Event.java
*@FileTitle : SC CM/OP View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.17 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.PriSpScpRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriRateCmViewAllVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;


/**
 * ESM_PRI_6021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRateCmViewAllVO[] rsltPriRateCmViewAllVOs = null;
	
	/** Table Value와 그외 변수를 member로 갖는 VO */
	private PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO = null;

	public EsmPri6021Event(){}
	
	public void setPriSpScpRtCmdtRoutVO(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO){
		this. priSpScpRtCmdtRoutVO = priSpScpRtCmdtRoutVO;
	}

	public void setPriSpScpRtCmdtRoutVOS(PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOs){
		this. priSpScpRtCmdtRoutVOs = priSpScpRtCmdtRoutVOs;
	}
	
	public void setPriSpScpRtCmdtRoutSetVO(PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO){
		this. priSpScpRtCmdtRoutSetVO = priSpScpRtCmdtRoutSetVO;
	}	

	public void setRsltPriRateCmViewAllVO(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO){
		this.rsltPriRateCmViewAllVO = rsltPriRateCmViewAllVO;
	}

	public void setRsltPriRateCmViewAllVOS(RsltPriRateCmViewAllVO[] rsltPriRateCmViewAllVOs){
		this. rsltPriRateCmViewAllVOs = rsltPriRateCmViewAllVOs;
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

	public RsltPriRateCmViewAllVO getRsltPriRateCmViewAllVO(){
		return rsltPriRateCmViewAllVO;
	}

	public RsltPriRateCmViewAllVO[] getRsltPriRateCmViewAllVOS(){
		return rsltPriRateCmViewAllVOs;
	}
}