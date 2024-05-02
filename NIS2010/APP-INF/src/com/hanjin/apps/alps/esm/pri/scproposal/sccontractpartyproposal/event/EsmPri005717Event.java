/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0017Event.java
*@FileTitle : Amendment History Inquiry - Customer Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.17 박성수
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * ESM_PRI_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0017HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri005717Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtCustTpVO priSpCtrtCustTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpCtrtCustTpVO[] priSpCtrtCustTpVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtPtyVO priSpCtrtPtyVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private PriSpCtrtPtyVO[] priSpCtrtPtyVOs = null;

	private PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = null;
	
	public EsmPri005717Event(){}
	
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

	public PriSpHistoryInquiryParamVO getPriSpHistoryInquiryParamVO() {
		return priSpHistoryInquiryParamVO;
	}

	public void setPriSpHistoryInquiryParamVO(
			PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) {
		this.priSpHistoryInquiryParamVO = priSpHistoryInquiryParamVO;
	}

}