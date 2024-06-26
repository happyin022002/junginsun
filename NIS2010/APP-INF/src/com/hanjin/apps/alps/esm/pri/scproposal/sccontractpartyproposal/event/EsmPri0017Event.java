/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0017Event.java
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;


/**
 * ESM_PRI_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0017HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	//PriSpMnVO
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	public PriSpMnVO getPriSpMnVO() {
		return priSpMnVO;
	}

	public void setPriSpMnVO(PriSpMnVO priSpMnVO) {
		this.priSpMnVO = priSpMnVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtCustTpVO priSpCtrtCustTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpCtrtCustTpVO[] priSpCtrtCustTpVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtPtyVO priSpCtrtPtyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpCtrtPtyVO[] priSpCtrtPtyVOs = null;

	public EsmPri0017Event(){}
	
	public void setPriSpCtrtCustTpVO(PriSpCtrtCustTpVO priSpCtrtCustTpVO){
		this. priSpCtrtCustTpVO = priSpCtrtCustTpVO;
	}

	public void setPriSpCtrtCustTpVOS(PriSpCtrtCustTpVO[] priSpCtrtCustTpVOs){
		this. priSpCtrtCustTpVOs = priSpCtrtCustTpVOs;
	}

	public void setPriSpCtrtPtyVO(PriSpCtrtPtyVO priSpCtrtPtyVO){
		this. priSpCtrtPtyVO = priSpCtrtPtyVO;
	}

	public void setPriSpCtrtPtyVOS(PriSpCtrtPtyVO[] priSpCtrtPtyVOs){
		this. priSpCtrtPtyVOs = priSpCtrtPtyVOs;
	}

	public PriSpCtrtCustTpVO getPriSpCtrtCustTpVO(){
		return priSpCtrtCustTpVO;
	}

	public PriSpCtrtCustTpVO[] getPriSpCtrtCustTpVOS(){
		return priSpCtrtCustTpVOs;
	}

	public PriSpCtrtPtyVO getPriSpCtrtPtyVO(){
		return priSpCtrtPtyVO;
	}

	public PriSpCtrtPtyVO[] getPriSpCtrtPtyVOS(){
		return priSpCtrtPtyVOs;
	}

}