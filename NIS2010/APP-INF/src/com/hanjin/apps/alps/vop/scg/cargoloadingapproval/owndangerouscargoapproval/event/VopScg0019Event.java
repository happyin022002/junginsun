/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0019Event.java
*@FileTitle : Mail Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.08.19 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;


/**
 * VOP_SCG_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Uk
 * @see VOP_SCG_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OwnApprovalRequestVO ownApprovalRequestVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OwnApprovalRequestVO[] ownApprovalRequestVOs = null;

	public VopScg0019Event(){}
	
	public void setOwnApprovalRequestVO(OwnApprovalRequestVO ownApprovalRequestVO){
		this. ownApprovalRequestVO = ownApprovalRequestVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setOwnApprovalRequestVOS(OwnApprovalRequestVO[] ownApprovalRequestVOs){
		if (ownApprovalRequestVOs != null) {
			OwnApprovalRequestVO[] tmpVOs = new OwnApprovalRequestVO[ownApprovalRequestVOs.length];
			System.arraycopy(ownApprovalRequestVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ownApprovalRequestVOs = tmpVOs;
		}
	}

	public OwnApprovalRequestVO getOwnApprovalRequestVO(){
		return ownApprovalRequestVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public OwnApprovalRequestVO[] getOwnApprovalRequestVOS(){
		OwnApprovalRequestVO[] rtnVOs = null;
		if (this.ownApprovalRequestVOs != null) {
			rtnVOs = new OwnApprovalRequestVO[ownApprovalRequestVOs.length];
			System.arraycopy(ownApprovalRequestVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}