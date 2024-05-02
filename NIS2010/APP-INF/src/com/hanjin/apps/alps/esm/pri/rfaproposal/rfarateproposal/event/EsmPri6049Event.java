/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6049Event.java
*@FileTitle : PRS- S/C Amendment CM/OP View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.22 송민석
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.PriRpScpRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmViewAllVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;



/**
 * ESM_PRI_6049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6049HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri6049Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriAmdCmViewAllVO[] rsltPriAmdCmViewAllVOs = null;
	
	/** Table Value와 그외 변수를 member로 갖는 VO */
	private PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO = null;

	public EsmPri6049Event(){}
	
	public void setPriRpScpRtCmdtRoutVO(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO){
		this. priRpScpRtCmdtRoutVO = priRpScpRtCmdtRoutVO;
	}

	public void setPriRpScpRtCmdtRoutVOS(PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVOs){
		if(priRpScpRtCmdtRoutVOs != null){
			PriRpScpRtCmdtRoutVO[] tmpVOs = new PriRpScpRtCmdtRoutVO[priRpScpRtCmdtRoutVOs.length];
			System.arraycopy(priRpScpRtCmdtRoutVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtRoutVOs = tmpVOs;
		}
	}
	
	public void setPriRpScpRtCmdtRoutSetVO(PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO){
		this. priRpScpRtCmdtRoutSetVO = priRpScpRtCmdtRoutSetVO;
	}	

	public void setRsltPriAmdCmViewAllVO(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO){
		this.rsltPriAmdCmViewAllVO = rsltPriAmdCmViewAllVO;
	}

	public void setRsltPriAmdCmViewAllVOS(RsltPriAmdCmViewAllVO[] rsltPriAmdCmViewAllVOs){
		if(rsltPriAmdCmViewAllVOs != null){
			RsltPriAmdCmViewAllVO[] tmpVOs = new RsltPriAmdCmViewAllVO[rsltPriAmdCmViewAllVOs.length];
			System.arraycopy(rsltPriAmdCmViewAllVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriAmdCmViewAllVOs = tmpVOs;
		}
	}

	public PriRpScpRtCmdtRoutVO getPriRpScpRtCmdtRoutVO(){
		return priRpScpRtCmdtRoutVO;
	}

	public PriRpScpRtCmdtRoutVO[] getPriRpScpRtCmdtRoutVOS(){
		PriRpScpRtCmdtRoutVO[] rtnVOs = null;
		if (this.priRpScpRtCmdtRoutVOs != null) {
			rtnVOs = new PriRpScpRtCmdtRoutVO[priRpScpRtCmdtRoutVOs.length];
			System.arraycopy(priRpScpRtCmdtRoutVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public PriRpScpRtCmdtRoutSetVO getPriRpScpRtCmdtRoutSetVO(){
		return priRpScpRtCmdtRoutSetVO;
	}	

	public RsltPriAmdCmViewAllVO getRsltPriAmdCmViewAllVO(){
		return rsltPriAmdCmViewAllVO;
	}

	public RsltPriAmdCmViewAllVO[] getRsltPriAmdCmViewAllVOS(){
		RsltPriAmdCmViewAllVO[] rtnVOs = null;
		if (this.rsltPriAmdCmViewAllVOs != null) {
			rtnVOs = new RsltPriAmdCmViewAllVO[rsltPriAmdCmViewAllVOs.length];
			System.arraycopy(rsltPriAmdCmViewAllVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}