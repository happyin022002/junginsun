/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000404Event.java
*@FileTitle : S/C Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.18 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgArbVO;
import com.hanjin.syscommon.common.table.PriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltArbChgListVO;


/**
 * ESM_PRI_0004_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0004_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0004_04HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000404Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpTrspAddChgVO priSpScpTrspAddChgVO = null;
	private CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO = null;
	private ChkFontStyleVO chkFontStyleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs = null;
	private CstPriSpScpTrspAddChgVO[] cstPriSpScpTrspAddChgVOs = null;
	private RsltArbChgListVO[] rsltArbChgListVOs = null;
	private PriSgArbVO[] priSgArbVOs = null;
	
	public EsmPri000404Event(){}
	
	public void setPriSpScpTrspAddChgVO(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO){
		this. priSpScpTrspAddChgVO = priSpScpTrspAddChgVO;
	}

	public void setPriSpScpTrspAddChgVOS(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs){
		this. priSpScpTrspAddChgVOs = priSpScpTrspAddChgVOs;
	}
	
	public PriSpScpTrspAddChgVO getPriSpScpTrspAddChgVO(){
		return priSpScpTrspAddChgVO;
	}

	public PriSpScpTrspAddChgVO[] getPriSpScpTrspAddChgVOS(){
		return priSpScpTrspAddChgVOs;
	}
	
	public void setCstPriSpScpTrspAddChgVO(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO){
		this. cstPriSpScpTrspAddChgVO = cstPriSpScpTrspAddChgVO;
	}

	public void setCstPriSpScpTrspAddChgVOS(CstPriSpScpTrspAddChgVO[] cstPriSpScpTrspAddChgVOs){
		this. cstPriSpScpTrspAddChgVOs = cstPriSpScpTrspAddChgVOs;
	}
	
	public CstPriSpScpTrspAddChgVO getCstPriSpScpTrspAddChgVO(){
		return cstPriSpScpTrspAddChgVO;
	}

	public CstPriSpScpTrspAddChgVO[] getCstPriSpScpTrspAddChgVOS(){
		return cstPriSpScpTrspAddChgVOs;
	}
	
	public void setRsltArbChgListVOS(RsltArbChgListVO[] rsltArbChgListVOs){
		this. rsltArbChgListVOs = rsltArbChgListVOs;
	}
	
	public void setPriSgArbVOS(PriSgArbVO[] priSgArbVOs){
		this. priSgArbVOs = priSgArbVOs;
	}

	public RsltArbChgListVO[] getRsltArbChgListVOS(){
		return rsltArbChgListVOs;
	}
	
	public PriSgArbVO[] getPriSgArbVOS(){
		return priSgArbVOs;
	}
	
	public void setChkFontStyleVO(ChkFontStyleVO chkFontStyleVO) {
		this. chkFontStyleVO = chkFontStyleVO;
	}
	
	public ChkFontStyleVO getChkFontStyleVO() {
		return chkFontStyleVO;
	}
}