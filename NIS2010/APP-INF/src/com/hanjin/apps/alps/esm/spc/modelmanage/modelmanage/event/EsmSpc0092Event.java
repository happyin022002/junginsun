/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSpc0092Event.java
*@FileTitle      : Amend
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.03.06
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
* 
* History
* 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - Amend 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustManageVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcMdlCustCtrlVO;

/**
 * ESM_SPC_0092 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0092HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @see ESM_SPC_0092HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0092Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustManageVO custManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustManageVO[] custManageVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcMdlCustCtrlVO spcMdlCustCtrlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcMdlCustCtrlVO[] spcMdlCustCtrlVOs = null;

	public EsmSpc0092Event(){}

	public CustManageVO getCustManageVO() {
		return custManageVO;
	}
	
	public void setCustManageVO(CustManageVO custManageVO) {
		this.custManageVO = custManageVO;
	}
	
	public CustManageVO[] getCustManageVOs() {
		return custManageVOs;
	}
	
	public void setCustManageVOs(CustManageVO[] custManageVOs) {
		this.custManageVOs = custManageVOs;
	}
	
	public SpcMdlCustCtrlVO getSpcMdlCustCtrlVO() {
		return spcMdlCustCtrlVO;
	}
	
	public void setSpcMdlCustCtrlVO(SpcMdlCustCtrlVO spcMdlCustCtrlVO) {
		this.spcMdlCustCtrlVO = spcMdlCustCtrlVO;
	}
	
	public SpcMdlCustCtrlVO[] getSpcMdlCustCtrlVOs() {
		return spcMdlCustCtrlVOs;
	}
	
	public void setSpcMdlCustCtrlVOs(SpcMdlCustCtrlVO[] spcMdlCustCtrlVOs) {
		this.spcMdlCustCtrlVOs = spcMdlCustCtrlVOs;
	}
	
}