/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSpc0119Event.java
*@FileTitle      : EsmSpc0119Event
*Open Issues     :
*Change history  :
*@LastModifyDate : 2015.03.06
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
* 
* History 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustManageVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcMdlCustCtrlVO;

/**
 * ESM_SPC_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Sung Wook
 * @see Esm_Spc_0119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0119Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustManageVO custManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustManageVO[] custManageVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcMdlCustCtrlVO spcMdlCustCtrlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcMdlCustCtrlVO[] spcMdlCustCtrlVOs = null;

	public EsmSpc0119Event(){}

	public CustManageVO getCustManageVO() {
		return custManageVO;
	}
	
	public void setCustManageVO(CustManageVO custManageVO) {
		this.custManageVO = custManageVO;
	}
	
	public CustManageVO[] getCustManageVOs() {
		CustManageVO[] rtnVOs = null;
		if (this.custManageVOs != null) {
			rtnVOs = new CustManageVO[custManageVOs.length];
			System.arraycopy(custManageVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustManageVOs(CustManageVO[] custManageVOs) {
		if (custManageVOs != null) {
			CustManageVO[] tmpVOs = new CustManageVO[custManageVOs.length];
			System.arraycopy(custManageVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.custManageVOs = tmpVOs;
		}
	}
	
	public SpcMdlCustCtrlVO getSpcMdlCustCtrlVO() {
		return spcMdlCustCtrlVO;
	}
	
	public void setSpcMdlCustCtrlVO(SpcMdlCustCtrlVO spcMdlCustCtrlVO) {
		this.spcMdlCustCtrlVO = spcMdlCustCtrlVO;
	}
	
	public SpcMdlCustCtrlVO[] getSpcMdlCustCtrlVOs() {
		SpcMdlCustCtrlVO[] rtnVOs = null;
		if (this.spcMdlCustCtrlVOs != null) {
			rtnVOs = new SpcMdlCustCtrlVO[spcMdlCustCtrlVOs.length];
			System.arraycopy(spcMdlCustCtrlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSpcMdlCustCtrlVOs(SpcMdlCustCtrlVO[] spcMdlCustCtrlVOs) {
		if (spcMdlCustCtrlVOs != null) {
			SpcMdlCustCtrlVO[] tmpVOs = new SpcMdlCustCtrlVO[spcMdlCustCtrlVOs.length];
			System.arraycopy(spcMdlCustCtrlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcMdlCustCtrlVOs = tmpVOs;
		}
	}
	
}