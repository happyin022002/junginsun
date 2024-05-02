/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri6087Event.java
*@FileTitle : RFA Proposal/Amendment Surcharge View All
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.21 송민석
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;


/**
 * ESM_PRI_6087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6087HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri6087Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOs = null;

	public EsmPri6087Event(){}
	
	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO){
		this. priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

	public void setPriRpScpRtCmdtHdrVOS(PriRpScpRtCmdtHdrVO[] priRpScpRtCmdtHdrVOs){
		if(priRpScpRtCmdtHdrVOs != null){
			PriRpScpRtCmdtHdrVO[] tmpVOs = new PriRpScpRtCmdtHdrVO[priRpScpRtCmdtHdrVOs.length];
			System.arraycopy(priRpScpRtCmdtHdrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtHdrVOs = tmpVOs;
		}
	}

	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO(){
		return priRpScpRtCmdtHdrVO;
	}

	public PriRpScpRtCmdtHdrVO[] getPriRpScpRtCmdtHdrVOS(){
		PriRpScpRtCmdtHdrVO[] rtnVOs = null;
		if (this.priRpScpRtCmdtHdrVOs != null) {
			rtnVOs = new PriRpScpRtCmdtHdrVO[priRpScpRtCmdtHdrVOs.length];
			System.arraycopy(priRpScpRtCmdtHdrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}