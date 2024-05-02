/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000306Event.java
*@FileTitle : S/C Proposal 및 Amendment시  GOH 생성/수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.26 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgGohChgVO;
import com.clt.syscommon.common.table.PriSpScpGohChgVO;


/**
 * ESM_PRI_0003_06 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_06HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0003_06HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri005708Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpGohChgVO priSpScpGohChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpGohChgVO[] priSpScpGohChgVOs = null;
	private PriSgGohChgVO[] priSgGohChgVOs = null;
	                         
	public EsmPri005708Event(){}
	
	public void setPriSpScpGohChgVO(PriSpScpGohChgVO priSpScpGohChgVO){
		this. priSpScpGohChgVO = priSpScpGohChgVO;
	}

	public void setPriSpScpGohChgVOS(PriSpScpGohChgVO[] priSpScpGohChgVOs){
		if (priSpScpGohChgVOs != null) {
			PriSpScpGohChgVO[] tmpVOs = new PriSpScpGohChgVO[priSpScpGohChgVOs.length];
			System.arraycopy(priSpScpGohChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpGohChgVOs = tmpVOs;
		}
	}
	
	public PriSpScpGohChgVO getPriSpScpGohChgVO(){
		return priSpScpGohChgVO;
	}

	public PriSpScpGohChgVO[] getPriSpScpGohChgVOS(){PriSpScpGohChgVO[] tmpVOs = null;
	if (this.priSpScpGohChgVOs != null) {
		tmpVOs = new PriSpScpGohChgVO[priSpScpGohChgVOs.length];
		System.arraycopy(priSpScpGohChgVOs, 0, tmpVOs, 0, tmpVOs.length);
	}
	return tmpVOs;
}
	
	public void setPriSgGohChgVOS(PriSgGohChgVO[] priSgGohChgVOs){
		if (priSgGohChgVOs != null) {
			PriSgGohChgVO[] tmpVOs = new PriSgGohChgVO[priSgGohChgVOs.length];
			System.arraycopy(priSgGohChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgGohChgVOs = tmpVOs;
		}
	}
	
	public PriSgGohChgVO[] getPriSgGohChgVOS(){
		PriSgGohChgVO[] tmpVOs = null;
		if (this.priSgGohChgVOs != null) {
			tmpVOs = new PriSgGohChgVO[priSgGohChgVOs.length];
			System.arraycopy(priSgGohChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
}