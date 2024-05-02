/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg1022Event.java
*@FileTitle : Dangerous CGO Application Details for Partner Lines
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.26 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_SCG_1022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_1022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_1022HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg5001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgPrnrAproRqstVO scgPrnrAproRqstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgPrnrAproRqstVO[] scgPrnrAproRqstVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PartnerApprovalRequestVO partnerApprovalRequestVO = null;
	
	private List<String> keys = null;

	public VopScg5001Event(){}
	
	public void setScgPrnrAproRqstVO(ScgPrnrAproRqstVO scgPrnrAproRqstVO){
		this. scgPrnrAproRqstVO = scgPrnrAproRqstVO;
	}
	
	public void setPartnerApprovalRequestVO(PartnerApprovalRequestVO partnerApprovalRequestVO){
		this. partnerApprovalRequestVO = partnerApprovalRequestVO;
	}
	
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public ScgPrnrAproRqstVO getScgPrnrAproRqstVO(){
		return scgPrnrAproRqstVO;
	}

	public ScgPrnrAproRqstVO[] getScgPrnrAproRqstVOS(){
		ScgPrnrAproRqstVO[] rtnVOs = null;
		if (this.scgPrnrAproRqstVOs != null) {
			rtnVOs = Arrays.copyOf(scgPrnrAproRqstVOs, scgPrnrAproRqstVOs.length);
		}
		return rtnVOs;
	}
	
	public PartnerApprovalRequestVO getPartnerApprovalRequestVO(){
		return partnerApprovalRequestVO;
	}
	
	public List<String> getKeys() {
		return keys;
	}

}