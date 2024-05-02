/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000301Event.java
*@FileTitle : S/C Proposal Org/Dst Location Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.21 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpRoutPntVO;


/**
 * ESM_PRI_0003_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0003_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri000301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltRoutPntLocListVO rsltRoutPntLocListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltRoutPntLocListVO[] rsltRoutPntLocListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRoutPntVO priSpScpRoutPntVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpRoutPntVO[] priSpScpRoutPntVOs = null;

	public EsmPri000301Event(){}
	
	public void setRsltRoutPntLocListVO(RsltRoutPntLocListVO rsltRoutPntLocListVO){
		this. rsltRoutPntLocListVO = rsltRoutPntLocListVO;
	}

	public void setRsltRoutPntLocListVOS(RsltRoutPntLocListVO[] rsltRoutPntLocListVOs){
		if (rsltRoutPntLocListVOs != null) {
			RsltRoutPntLocListVO[] tmpVOs = new RsltRoutPntLocListVO[rsltRoutPntLocListVOs.length];
			System.arraycopy(rsltRoutPntLocListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRoutPntLocListVOs = tmpVOs;
		}
	}

	public void setPriSpScpRoutPntVO(PriSpScpRoutPntVO priSpScpRoutPntVO){
		this. priSpScpRoutPntVO = priSpScpRoutPntVO;
	}

	public void setPriSpScpRoutPntVOS(PriSpScpRoutPntVO[] priSpScpRoutPntVOs){
		if (priSpScpRoutPntVOs != null) {
			PriSpScpRoutPntVO[] tmpVOs = new PriSpScpRoutPntVO[priSpScpRoutPntVOs.length];
			System.arraycopy(priSpScpRoutPntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpRoutPntVOs = tmpVOs;
		}
	}

	public RsltRoutPntLocListVO getRsltRoutPntLocListVO(){
		return rsltRoutPntLocListVO;
	}

	public RsltRoutPntLocListVO[] getRsltRoutPntLocListVOS(){
		RsltRoutPntLocListVO[] tmpVOs = null;
		if (this.rsltRoutPntLocListVOs != null) {
			tmpVOs = new RsltRoutPntLocListVO[rsltRoutPntLocListVOs.length];
			System.arraycopy(rsltRoutPntLocListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpRoutPntVO getPriSpScpRoutPntVO(){
		return priSpScpRoutPntVO;
	}

	public PriSpScpRoutPntVO[] getPriSpScpRoutPntVOS(){
		PriSpScpRoutPntVO[] tmpVOs = null;
		if (this.priSpScpRoutPntVOs != null) {
			tmpVOs = new PriSpScpRoutPntVO[priSpScpRoutPntVOs.length];
			System.arraycopy(priSpScpRoutPntVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}