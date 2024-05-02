/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000305Event.java
*@FileTitle : S/C Proposal Origin/Destination IHC Charge-Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.22 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltIhcChgListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpTrspAddChgVO;


/**
 * ESM_PRI_0003_05 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_05HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0003_05HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri005715Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpTrspAddChgVO priSpScpTrspAddChgVO = null;
	private CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO = null;
	private ChkFontStyleVO chkFontStyleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs = null;
	private RsltIhcChgListVO[] rsltIhcChgListVOs = null;
	
	public EsmPri005715Event(){}
	
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
	
	public void setRsltIhcChgListVOS(RsltIhcChgListVO[] rsltIhcChgListVOs){
		if (rsltIhcChgListVOs != null) {
			RsltIhcChgListVO[] tmpVOs = new RsltIhcChgListVO[rsltIhcChgListVOs.length];
			System.arraycopy(rsltIhcChgListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltIhcChgListVOs = tmpVOs;
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
	
	public RsltIhcChgListVO[] getRsltIhcChgListVOS(){
		RsltIhcChgListVO[] tmpVOs = null;
		if (this.rsltIhcChgListVOs != null) {
			tmpVOs = new RsltIhcChgListVO[rsltIhcChgListVOs.length];
			System.arraycopy(rsltIhcChgListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setCstPriSpScpTrspAddChgVO(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO){
		this. cstPriSpScpTrspAddChgVO = cstPriSpScpTrspAddChgVO;
	}
	
	public CstPriSpScpTrspAddChgVO getCstPriSpScpTrspAddChgVO(){
		return cstPriSpScpTrspAddChgVO;
	}
	
	public void setChkFontStyleVO(ChkFontStyleVO chkFontStyleVO) {
		this. chkFontStyleVO = chkFontStyleVO;
	}
	
	public ChkFontStyleVO getChkFontStyleVO() {
		return chkFontStyleVO;
	}
}