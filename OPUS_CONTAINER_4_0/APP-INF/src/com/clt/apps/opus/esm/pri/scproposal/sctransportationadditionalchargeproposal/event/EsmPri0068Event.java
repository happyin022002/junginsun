/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0068Event.java
*@FileTitle : S/C Proposal Origin/Destination IHC – Excel import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.09 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpTrspAddChgVO;



/**
 * ESM_PRI_0068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0068HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0068Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpTrspAddChgVO priSpScpTrspAddChgVO = null;
	private CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs = null;

	public EsmPri0068Event(){}
	
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
	
	public CstPriSpScpTrspAddChgVO getCstPriSpScpTrspAddChgVO(){
		return cstPriSpScpTrspAddChgVO;
	}
}