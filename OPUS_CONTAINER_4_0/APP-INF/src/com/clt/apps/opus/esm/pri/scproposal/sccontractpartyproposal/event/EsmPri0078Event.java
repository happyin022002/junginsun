/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0022Event.java
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.05 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpCtrtCustTpVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * ESM_PRI_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0022HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtCustTpVO priSpCtrtCustTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpCtrtCustTpVO[] priSpCtrtCustTpVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtPtyVO priSpCtrtPtyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpCtrtPtyVO[] priSpCtrtPtyVOs = null;

	public EsmPri0078Event(){}
	
	public void setPriSpCtrtCustTpVO(PriSpCtrtCustTpVO priSpCtrtCustTpVO){
		this. priSpCtrtCustTpVO = priSpCtrtCustTpVO;
	}

	public void setPriSpCtrtCustTpVOS(PriSpCtrtCustTpVO[] priSpCtrtCustTpVOs){
		if (priSpCtrtCustTpVOs != null) {
			PriSpCtrtCustTpVO[] tmpVOs = new PriSpCtrtCustTpVO[priSpCtrtCustTpVOs.length];
			System.arraycopy(priSpCtrtCustTpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpCtrtCustTpVOs = tmpVOs;
		}
	}

	public void setPriSpCtrtPtyVO(PriSpCtrtPtyVO priSpCtrtPtyVO){
		this. priSpCtrtPtyVO = priSpCtrtPtyVO;
	}

	public void setPriSpCtrtPtyVOS(PriSpCtrtPtyVO[] priSpCtrtPtyVOs){
		if (priSpCtrtPtyVOs != null) {
			PriSpCtrtPtyVO[] tmpVOs = new PriSpCtrtPtyVO[priSpCtrtPtyVOs.length];
			System.arraycopy(priSpCtrtPtyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpCtrtPtyVOs = tmpVOs;
		}
	}

	public PriSpCtrtCustTpVO getPriSpCtrtCustTpVO(){
		return priSpCtrtCustTpVO;
	}

	public PriSpCtrtCustTpVO[] getPriSpCtrtCustTpVOS(){
		PriSpCtrtCustTpVO[] tmpVOs = null;
		if (this.priSpCtrtCustTpVOs != null) {
			tmpVOs = new PriSpCtrtCustTpVO[priSpCtrtCustTpVOs.length];
			System.arraycopy(priSpCtrtCustTpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpCtrtPtyVO getPriSpCtrtPtyVO(){
		return priSpCtrtPtyVO;
	}

	public PriSpCtrtPtyVO[] getPriSpCtrtPtyVOS(){
		PriSpCtrtPtyVO[] tmpVOs = null;
		if (this.priSpCtrtPtyVOs != null) {
			tmpVOs = new PriSpCtrtPtyVO[priSpCtrtPtyVOs.length];
			System.arraycopy(priSpCtrtPtyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}