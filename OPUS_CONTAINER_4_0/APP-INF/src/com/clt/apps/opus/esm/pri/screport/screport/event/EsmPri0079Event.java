/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0079Event.java
*@FileTitle : S_C Print View
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.08.10 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpMnVO;


/**
 * ESM_PRI_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0079HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0079Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpMnVO[] priSpMnVOs = null;

	public EsmPri0079Event(){}
	
	public void setPriSpMnVO(PriSpMnVO priSpMnVO){
		this. priSpMnVO = priSpMnVO;
	}

	public void setPriSpMnVOS(PriSpMnVO[] priSpMnVOs){
		if (priSpMnVOs != null) {
			PriSpMnVO[] tmpVOs = new PriSpMnVO[priSpMnVOs.length];
			System.arraycopy(priSpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpMnVOs = tmpVOs;
		}
	}

	public PriSpMnVO getPriSpMnVO(){
		return priSpMnVO;
	}

	public PriSpMnVO[] getPriSpMnVOS(){
		PriSpMnVO[] tmpVOs = null;
		if (this.priSpMnVOs != null) {
			tmpVOs = new PriSpMnVO[priSpMnVOs.length];
			System.arraycopy(priSpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}