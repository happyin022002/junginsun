/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0022Event.java
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.14 변영주
* 1.0 Creation
=========================================================
* History
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section) 및 Loading Agent POA Attach(L/Agent section) 기능 개발요청
*                                    - File Upload Key를 담기 위한 변수 추가
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * ESM_PRI_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0022HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtCustTpVO priSpCtrtCustTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpCtrtCustTpVO[] priSpCtrtCustTpVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtPtyVO priSpCtrtPtyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpCtrtPtyVO[] priSpCtrtPtyVOs = null;

	/** File Upload Key */
	private List<String> keys = null;
	
	public EsmPri0022Event(){}
	
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

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
}