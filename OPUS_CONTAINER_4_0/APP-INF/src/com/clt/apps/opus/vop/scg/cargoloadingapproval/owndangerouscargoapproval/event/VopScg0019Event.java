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
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.clt.framework.support.layer.event.EventSupport;


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

	public void setOwnApprovalRequestVOS(OwnApprovalRequestVO[] ownApprovalRequestVOs){
		if(ownApprovalRequestVOs != null){
			OwnApprovalRequestVO[] tmpVOs = Arrays.copyOf(ownApprovalRequestVOs, ownApprovalRequestVOs.length);
			this.ownApprovalRequestVOs = tmpVOs;
		}
	}

	public OwnApprovalRequestVO getOwnApprovalRequestVO(){
		return ownApprovalRequestVO;
	}

	public OwnApprovalRequestVO[] getOwnApprovalRequestVOS(){
		OwnApprovalRequestVO[] rtnVOs = null;
		if (this.ownApprovalRequestVOs != null) {
			rtnVOs = Arrays.copyOf(ownApprovalRequestVOs, ownApprovalRequestVOs.length);
		}
		return rtnVOs;
	}

}