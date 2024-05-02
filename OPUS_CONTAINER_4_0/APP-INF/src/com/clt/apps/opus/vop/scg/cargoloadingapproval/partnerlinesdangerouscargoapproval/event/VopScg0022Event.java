/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0022Event.java
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.24 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_0022HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PartnerApprovalRequestVO partnerApprovalRequestVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PartnerApprovalRequestVO[] partnerApprovalRequestVOs = null;
	
	private List<String> keys = null;

	public VopScg0022Event(){}
	
	public void setPartnerApprovalRequestVO(PartnerApprovalRequestVO partnerApprovalRequestVO){
		this. partnerApprovalRequestVO = partnerApprovalRequestVO;
	}

	public void setPartnerApprovalRequestVOS(PartnerApprovalRequestVO[] partnerApprovalRequestVOs){
		if(partnerApprovalRequestVOs != null){
			PartnerApprovalRequestVO[] tmpVOs = Arrays.copyOf(partnerApprovalRequestVOs, partnerApprovalRequestVOs.length);
			this.partnerApprovalRequestVOs = tmpVOs;
		}
	}
	
	public List<String> getKeys() {
		return keys;
	}

	public PartnerApprovalRequestVO getPartnerApprovalRequestVO(){
		return partnerApprovalRequestVO;
	}
	
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public PartnerApprovalRequestVO[] getPartnerApprovalRequestVOS(){
		PartnerApprovalRequestVO[] rtnVOs = null;
		if (this.partnerApprovalRequestVOs != null) {
			rtnVOs = Arrays.copyOf(partnerApprovalRequestVOs, partnerApprovalRequestVOs.length);
		}
		return rtnVOs;
	}

}