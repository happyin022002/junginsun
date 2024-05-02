/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2047Event.java
*@FileTitle : RFA Proposal Creation – Rate – Specification
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.27 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.CstPriRpScpRtCgoSpecVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpScpRtCgoSpecVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRatUtVO;
import com.clt.syscommon.common.table.PriRpScpRtCgoSpecVO;


/**
 * ESM_PRI_2047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_2047HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRpScpRtCgoSpecVO rsltPriRpScpRtCgoSpecVO = null;
	private CstPriRpScpRtCgoSpecVO cstPriRpScpRtCgoSpecVO = null;
	private PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRpScpRtCgoSpecVO[] rsltPriRpScpRtCgoSpecVOs = null;
	private PriRpScpRtCgoSpecVO[] priRpScpRtCgoSpecVOs = null;
	
	public EsmPri2047Event(){}
	
	public void setRsltPriRpScpRtCgoSpecVO(RsltPriRpScpRtCgoSpecVO rsltPriRpScpRtCgoSpecVO){
		this. rsltPriRpScpRtCgoSpecVO = rsltPriRpScpRtCgoSpecVO;
	}

	public void setRsltPriRpScpRtCgoSpecVOS(RsltPriRpScpRtCgoSpecVO[] rsltPriRpScpRtCgoSpecVOs){
		if (rsltPriRpScpRtCgoSpecVOs != null) {
			RsltPriRpScpRtCgoSpecVO[] tmpVOs = new RsltPriRpScpRtCgoSpecVO[rsltPriRpScpRtCgoSpecVOs.length];
			System.arraycopy(rsltPriRpScpRtCgoSpecVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriRpScpRtCgoSpecVOs = tmpVOs;
		}
	}

	public RsltPriRpScpRtCgoSpecVO getRsltPriRpScpRtCgoSpecVO(){
		return rsltPriRpScpRtCgoSpecVO;
	}

	public RsltPriRpScpRtCgoSpecVO[] getRsltPriRpScpRtCgoSpecVOS(){
		RsltPriRpScpRtCgoSpecVO[] tmpVOs = null;
		if (this.rsltPriRpScpRtCgoSpecVOs != null) {
			tmpVOs = new RsltPriRpScpRtCgoSpecVO[rsltPriRpScpRtCgoSpecVOs.length];
			System.arraycopy(rsltPriRpScpRtCgoSpecVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setCstPriRpScpRtCgoSpecVO(CstPriRpScpRtCgoSpecVO cstPriRpScpRtCgoSpecVO){
		this. cstPriRpScpRtCgoSpecVO = cstPriRpScpRtCgoSpecVO;
	}
	
	public CstPriRpScpRtCgoSpecVO getCstPriRpScpRtCgoSpecVO(){
		return cstPriRpScpRtCgoSpecVO;
	}
	
	public void setPriRpScpRtCgoSpecVO(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO){
		this. priRpScpRtCgoSpecVO = priRpScpRtCgoSpecVO;
	}

	public void setPriRpScpRtCgoSpecVOS(PriRpScpRtCgoSpecVO[] priRpScpRtCgoSpecVOs){
		if (priRpScpRtCgoSpecVOs != null) {
			PriRpScpRtCgoSpecVO[] tmpVOs = new PriRpScpRtCgoSpecVO[priRpScpRtCgoSpecVOs.length];
			System.arraycopy(priRpScpRtCgoSpecVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCgoSpecVOs = tmpVOs;
		}
	}

	public PriRpScpRtCgoSpecVO getPriRpScpRtCgoSpecVO(){
		return priRpScpRtCgoSpecVO;
	}

	public PriRpScpRtCgoSpecVO[] getPriRpScpRtCgoSpecVOS(){
		PriRpScpRtCgoSpecVO[] tmpVOs = null;
		if (this.priRpScpRtCgoSpecVOs != null) {
			tmpVOs = new PriRpScpRtCgoSpecVO[priRpScpRtCgoSpecVOs.length];
			System.arraycopy(priRpScpRtCgoSpecVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}