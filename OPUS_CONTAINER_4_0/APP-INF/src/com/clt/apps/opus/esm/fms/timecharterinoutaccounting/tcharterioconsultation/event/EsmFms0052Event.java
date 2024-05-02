/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0052Event.java
*@FileTitle : Slip Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.17 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0052HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchSlipApprovalVO condSearchSlipApprovalVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchSlipApprovalVO[] condSearchSlipApprovalVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomConsultationVO customConsultationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomConsultationVO[] customConsultationVOs = null;

	/** Slip Type */
	private String slipType = null;

	/** Flet Contract Type Code */
	private String fletCtrtTpCd = null;

	/** CSR No */
	private String csrNo = null;

	/** Approval Flag */
	private String aproFlg = null;

	/** Cancel Description */
	private String cxlDesc = null;

	public EsmFms0052Event(){}
	
	public void setCondSearchSlipApprovalVO(CondSearchSlipApprovalVO condSearchSlipApprovalVO){
		this. condSearchSlipApprovalVO = condSearchSlipApprovalVO;
	}

	public void setCondSearchSlipApprovalVOS(CondSearchSlipApprovalVO[] condSearchSlipApprovalVOs){
		if (condSearchSlipApprovalVOs != null) {
			CondSearchSlipApprovalVO[] tmpVOs = new CondSearchSlipApprovalVO[condSearchSlipApprovalVOs.length];
			System.arraycopy(condSearchSlipApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.condSearchSlipApprovalVOs = tmpVOs;
		}
	}

	public void setCustomConsultationVO(CustomConsultationVO customConsultationVO){
		this. customConsultationVO = customConsultationVO;
	}

	public void setCustomConsultationVOS(CustomConsultationVO[] customConsultationVOs){
		if (customConsultationVOs != null) {
			CustomConsultationVO[] tmpVOs = new CustomConsultationVO[customConsultationVOs.length];
			System.arraycopy(customConsultationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customConsultationVOs = tmpVOs;
		}
	}

	public void setSlipType(String slipType){
		this.slipType = slipType;
	}

	public void setFletCtrtTpCd(String fletCtrtTpCd){
		this.fletCtrtTpCd = fletCtrtTpCd;
	}

	public void setCsrNo(String csrNo){
		this.csrNo = csrNo;
	}

	public void setAproFlg(String aproFlg){
		this.aproFlg = aproFlg;
	}

	public void setCxlDesc(String cxlDesc){
		this.cxlDesc = cxlDesc;
	}

	public CondSearchSlipApprovalVO getCondSearchSlipApprovalVO(){
		return condSearchSlipApprovalVO;
	}

	public CondSearchSlipApprovalVO[] getCondSearchSlipApprovalVOS(){
		CondSearchSlipApprovalVO[] tmpVOs = null;
		if (this.condSearchSlipApprovalVOs != null) {
			tmpVOs = new CondSearchSlipApprovalVO[condSearchSlipApprovalVOs.length];
			System.arraycopy(condSearchSlipApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CustomConsultationVO getCustomConsultationVO(){
		return customConsultationVO;
	}

	public CustomConsultationVO[] getCustomConsultationVOS(){
		CustomConsultationVO[] tmpVOs = null;
		if (this.customConsultationVOs != null) {
			tmpVOs = new CustomConsultationVO[customConsultationVOs.length];
			System.arraycopy(customConsultationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public String getSlipType(){
		return slipType;
	}

	public String getFletCtrtTpCd(){
		return fletCtrtTpCd;
	}

	public String getCsrNo(){
		return csrNo;
	}

	public String getAproFlg(){
		return aproFlg;
	}

	public String getCxlDesc(){
		return cxlDesc;
	}

}