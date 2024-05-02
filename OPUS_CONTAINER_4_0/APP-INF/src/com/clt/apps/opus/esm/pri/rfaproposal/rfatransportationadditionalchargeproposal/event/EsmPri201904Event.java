/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri201904Event.java
*@FileTitle : RFA Proposal Origin/Destination Arbitrary Charge Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.19 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.CstPriRpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgArbVO;
import com.clt.syscommon.common.table.PriRpScpTrspAddChgVO;


/**
 * ESM_PRI_2019_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2019_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_2019_04HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri201904Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpTrspAddChgVO priRpScpTrspAddChgVO = null;
	private CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO = null;
	private ChkFontStyleVO chkFontStyleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs = null;
	private CstPriRpScpTrspAddChgVO[] cstPriRpScpTrspAddChgVOs = null;
	private RsltArbChgListVO[] rsltArbChgListVOs = null;
	private PriRgArbVO[] priRgArbVOs = null;
	
	public EsmPri201904Event(){}
	
	public void setPriRpScpTrspAddChgVO(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO){
		this. priRpScpTrspAddChgVO = priRpScpTrspAddChgVO;
	}

	public void setPriRpScpTrspAddChgVOS(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs){
		if (priRpScpTrspAddChgVOs != null) {
			PriRpScpTrspAddChgVO[] tmpVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOs.length];
			System.arraycopy(priRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpTrspAddChgVOs = tmpVOs;
		}
	}
	
	public void setRsltArbChgListVOS(RsltArbChgListVO[] rsltArbChgListVOs){
		if (rsltArbChgListVOs != null) {
			RsltArbChgListVO[] tmpVOs = new RsltArbChgListVO[rsltArbChgListVOs.length];
			System.arraycopy(rsltArbChgListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltArbChgListVOs = tmpVOs;
		}
	}
	
	public void setPriRgArbVOS(PriRgArbVO[] priRgArbVOs){
		if (priRgArbVOs != null) {
			PriRgArbVO[] tmpVOs = new PriRgArbVO[priRgArbVOs.length];
			System.arraycopy(priRgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgArbVOs = tmpVOs;
		}
	}
	
	public void setCstPriRpScpTrspAddChgVO(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO){
		this. cstPriRpScpTrspAddChgVO = cstPriRpScpTrspAddChgVO;
	}

	public void setCstPriRpScpTrspAddChgVOS(CstPriRpScpTrspAddChgVO[] cstPriRpScpTrspAddChgVOs){
		if (cstPriRpScpTrspAddChgVOs != null) {
			CstPriRpScpTrspAddChgVO[] tmpVOs = new CstPriRpScpTrspAddChgVO[cstPriRpScpTrspAddChgVOs.length];
			System.arraycopy(cstPriRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstPriRpScpTrspAddChgVOs = tmpVOs;
		}
	}
	
	public CstPriRpScpTrspAddChgVO getCstPriRpScpTrspAddChgVO(){
		return cstPriRpScpTrspAddChgVO;
	}

	public CstPriRpScpTrspAddChgVO[] getCstPriRpScpTrspAddChgVOS(){
		CstPriRpScpTrspAddChgVO[] tmpVOs = null;
		if (this.cstPriRpScpTrspAddChgVOs != null) {
			tmpVOs = new CstPriRpScpTrspAddChgVO[cstPriRpScpTrspAddChgVOs.length];
			System.arraycopy(cstPriRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriRpScpTrspAddChgVO getPriRpScpTrspAddChgVO(){
		return priRpScpTrspAddChgVO;
	}

	public PriRpScpTrspAddChgVO[] getPriRpScpTrspAddChgVOS(){
		PriRpScpTrspAddChgVO[] tmpVOs = null;
		if (this.priRpScpTrspAddChgVOs != null) {
			tmpVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOs.length];
			System.arraycopy(priRpScpTrspAddChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public RsltArbChgListVO[] getRsltArbChgListVOS(){
		RsltArbChgListVO[] tmpVOs = null;
		if (this.rsltArbChgListVOs != null) {
			tmpVOs = new RsltArbChgListVO[rsltArbChgListVOs.length];
			System.arraycopy(rsltArbChgListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriRgArbVO[] getPriRgArbVOS(){
		PriRgArbVO[] tmpVOs = null;
		if (this.priRgArbVOs != null) {
			tmpVOs = new PriRgArbVO[priRgArbVOs.length];
			System.arraycopy(priRgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
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