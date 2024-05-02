/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000304Event.java
*@FileTitle : S/C Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.18 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstArbAcceptVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgArbVO;
import com.clt.syscommon.common.table.PriSpScpTrspAddChgVO;


/**
 * ESM_PRI_0003_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0003_04HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000304Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpTrspAddChgVO priSpScpTrspAddChgVO = null;
	private CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO = null;
	private ChkFontStyleVO chkFontStyleVO = null;
	
	private CstArbAcceptVO cstArbAcceptVO = null;
	
	public CstArbAcceptVO getCstArbAcceptVO() {
		return cstArbAcceptVO;
	}

	public void setCstArbAcceptVO(CstArbAcceptVO cstArbAcceptVO) {
		this.cstArbAcceptVO = cstArbAcceptVO;
	}

	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs = null;
	private CstPriSpScpTrspAddChgVO[] cstPriSpScpTrspAddChgVOs = null;
	private RsltArbChgListVO[] rsltArbChgListVOs = null;
	private PriSgArbVO[] priSgArbVOs = null;
	
	
	
	public EsmPri000304Event(){}
	
	public void setPriSpScpTrspAddChgVO(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO){
		this. priSpScpTrspAddChgVO = priSpScpTrspAddChgVO;
	}

	public void setPriSpScpTrspAddChgVOS(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs){
		if (priSpScpTrspAddChgVOs != null) {
			PriSpScpTrspAddChgVO[] tmpVOs = new PriSpScpTrspAddChgVO[priSpScpTrspAddChgVOs.length];
			System.arraycopy(priSpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpTrspAddChgVOs = tmpVOs;
		}
	}
	
	public PriSpScpTrspAddChgVO getPriSpScpTrspAddChgVO(){
		return priSpScpTrspAddChgVO;
	}

	public PriSpScpTrspAddChgVO[] getPriSpScpTrspAddChgVOS(){
		PriSpScpTrspAddChgVO[] tmpVOs = null;
		if (this.priSpScpTrspAddChgVOs != null) {
			tmpVOs = new PriSpScpTrspAddChgVO[priSpScpTrspAddChgVOs.length];
			System.arraycopy(priSpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	
	public void setCstPriSpScpTrspAddChgVO(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO){
		this. cstPriSpScpTrspAddChgVO = cstPriSpScpTrspAddChgVO;
	}

	public void setCstPriSpScpTrspAddChgVOS(CstPriSpScpTrspAddChgVO[] cstPriSpScpTrspAddChgVOs){
		if (cstPriSpScpTrspAddChgVOs != null) {
			CstPriSpScpTrspAddChgVO[] tmpVOs = new CstPriSpScpTrspAddChgVO[cstPriSpScpTrspAddChgVOs.length];
			System.arraycopy(cstPriSpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstPriSpScpTrspAddChgVOs = tmpVOs;
		}
	}
	
	public CstPriSpScpTrspAddChgVO getCstPriSpScpTrspAddChgVO(){
		return cstPriSpScpTrspAddChgVO;
	}

	public CstPriSpScpTrspAddChgVO[] getCstPriSpScpTrspAddChgVOS(){
		CstPriSpScpTrspAddChgVO[] tmpVOs = null;
		if (this.cstPriSpScpTrspAddChgVOs != null) {
			tmpVOs = new CstPriSpScpTrspAddChgVO[cstPriSpScpTrspAddChgVOs.length];
			System.arraycopy(cstPriSpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setRsltArbChgListVOS(RsltArbChgListVO[] rsltArbChgListVOs){
		if (rsltArbChgListVOs != null) {
			RsltArbChgListVO[] tmpVOs = new RsltArbChgListVO[rsltArbChgListVOs.length];
			System.arraycopy(rsltArbChgListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltArbChgListVOs = tmpVOs;
		}
	}
	
	public void setPriSgArbVOS(PriSgArbVO[] priSgArbVOs){
		if (priSgArbVOs != null) {
			PriSgArbVO[] tmpVOs = new PriSgArbVO[priSgArbVOs.length];
			System.arraycopy(priSgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgArbVOs = tmpVOs;
		}
	}

	public RsltArbChgListVO[] getRsltArbChgListVOS(){
		RsltArbChgListVO[] tmpVOs = null;
		if (this.rsltArbChgListVOs != null) {
			tmpVOs = new RsltArbChgListVO[rsltArbChgListVOs.length];
			System.arraycopy(rsltArbChgListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSgArbVO[] getPriSgArbVOS(){
		PriSgArbVO[] tmpVOs = null;
		if (this.priSgArbVOs != null) {
			tmpVOs = new PriSgArbVO[priSgArbVOs.length];
			System.arraycopy(priSgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setChkFontStyleVO(ChkFontStyleVO chkFontStyleVO) {
		this. chkFontStyleVO = chkFontStyleVO;
	}
	
	public ChkFontStyleVO getChkFontStyleVO() {
		return chkFontStyleVO;
	}
}