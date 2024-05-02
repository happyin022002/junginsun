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
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	
	/** Last Approval Flag */
	private String lstAproFlg = null;
	
	/** Cancel Description */
	private String cxlDesc = null;
	
	/** Cancel Flag */
	private String cxlFlg = null;
	
	/** Cancel Description */
	private String interCoCd = null;
	
	/** Cancel Description */
	private String arInterCoCd = null;

	/** Approval Dt */
	private String aproDt = null;	

	/** Approval Requst No */
	private String aproRqstNo = null;	

	/** Approval Requst Seq */
	private String aproRqstSeq = null;	

	/** urg_pay_flg */	
	private String urgPayFlg = null;	
	
	/** slip_apro_flg */	
	private String slipAproFlg = null;		
	
	public String getArInterCoCd() {
		return arInterCoCd;
	}

	public void setArInterCoCd(String arInterCoCd) {
		this.arInterCoCd = arInterCoCd;
	}

	public String getInterCoCd() {
		return interCoCd;
	}

	public void setInterCoCd(String interCoCd) {
		this.interCoCd = interCoCd;
	}

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

	public void setLstAproFlg(String lstAproFlg){
		this.lstAproFlg = lstAproFlg;
	}
	
	public void setCxlDesc(String cxlDesc){
		this.cxlDesc = cxlDesc;
	}
	
	public void setCxlFlg(String cxlFlg){
		this.cxlFlg = cxlFlg;
	}	

	public void setAproDt(String aproDt){
		this.aproDt = aproDt;
	}

	public void setAproRqstNo(String aproRqstNo){
		this.aproRqstNo = aproRqstNo;
	}

	public void setAproRqstSeq(String aproRqstSeq){
		this.aproRqstSeq = aproRqstSeq;
	}

	public void setUrgPayFlg(String urgPayFlg){
		this.urgPayFlg = urgPayFlg;
	}
	
	public void setSlipAproFlg(String slipAproFlg) {
		this.slipAproFlg = slipAproFlg;
	}
		
	public CondSearchSlipApprovalVO getCondSearchSlipApprovalVO(){
		return condSearchSlipApprovalVO;
	}

	public CondSearchSlipApprovalVO[] getCondSearchSlipApprovalVOS(){
		CondSearchSlipApprovalVO[] rtnVOs = null;
		if (this.condSearchSlipApprovalVOs != null) {
			rtnVOs = new CondSearchSlipApprovalVO[condSearchSlipApprovalVOs.length];
			System.arraycopy(condSearchSlipApprovalVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public CustomConsultationVO getCustomConsultationVO(){
		return customConsultationVO;
	}

	public CustomConsultationVO[] getCustomConsultationVOS(){
		CustomConsultationVO[] rtnVOs = null;
		if (this.customConsultationVOs != null) {
			rtnVOs = new CustomConsultationVO[customConsultationVOs.length];
			System.arraycopy(customConsultationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
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
	
	public String getLstAproFlg(){
		return lstAproFlg;
	}	

	public String getCxlDesc(){
		return cxlDesc;
	}

	public String getCxlFlg(){
		return cxlFlg;
	}
	
	public String getAproDt(){
		return aproDt;
	}

	public String getAproRqstNo(){
		return aproRqstNo;
	}

	public String getAproRqstSeq(){
		return aproRqstSeq;
	}

	public String getUrgPayFlg(){
		return urgPayFlg;
	}
	
	public String getSlipAproFlg() {
		return this.slipAproFlg;
	}
		
}