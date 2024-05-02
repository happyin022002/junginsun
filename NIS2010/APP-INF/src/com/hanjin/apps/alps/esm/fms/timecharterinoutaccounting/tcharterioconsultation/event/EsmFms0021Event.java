/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0021Event.java
*@FileTitle : Payments Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.11 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipCorrectionVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* CSR No */
	private String csrNo = "";
	
	/* CSR Desc */
	private String csrDesc = "";
	
	/* Center Code */
	private String ctrCd = "";
	
	/* Bunker Vvd */
	private String bunkerVvd = "";

	private CondSearchSlipCorrectionVO condSearchSlipCorrectionVO = null;
	
	// Payments Slip Master VO
	private CustomPamConsultationVO customPamConsultationVO = null;
	
	/** Payments Slip Master VO - Table Value Object Multi Data 처리 */
	private CustomPamConsultationVO[] customPamConsultationVOs = null;
	
	/** Payments Slip Detail VO - Table Value Object Multi Data 처리 */
	private CustomPamCsulSlpVO[] customPamCsulSlpVOs = null;
	
	// Tax Evidence Master VO
	private CustomTaxVO customTaxVO = null;
	
	// Tax Evidence Master VO
	private CustomTaxVO[] customTaxVOs = null;
	
	/** Tax Evidence Detail VO - Table Value Object Multi Data 처리 */
	private CustomTaxDtlVO[] customTaxDtlVOs = null;
	
	public void setCondSearchSlipCorrectionVO(CondSearchSlipCorrectionVO condSearchSlipCorrectionVO){
		this.condSearchSlipCorrectionVO = condSearchSlipCorrectionVO;
	} 

	public CondSearchSlipCorrectionVO getCondSearchSlipCorrectionVO(){
		return condSearchSlipCorrectionVO;
	}
	
	public void setCustomPamConsultationVO(CustomPamConsultationVO customPamConsultationVO){
		this.customPamConsultationVO = customPamConsultationVO;
	}

	public CustomPamConsultationVO getCustomPamConsultationVO(){
		return customPamConsultationVO;
	}
	
	public void setCustomPamConsultationVOS(CustomPamConsultationVO[] customPamConsultationVOs){
		if (customPamConsultationVOs != null) {
			CustomPamConsultationVO[] tmpVOs = new CustomPamConsultationVO[customPamConsultationVOs.length];
			System.arraycopy(customPamConsultationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customPamConsultationVOs = tmpVOs;
		}
	}
	
	public CustomPamConsultationVO[] getCustomPamConsultationVOS(){
		CustomPamConsultationVO[] rtnVOs = null;
		if (this.customPamConsultationVOs != null) {
			rtnVOs = new CustomPamConsultationVO[customPamConsultationVOs.length];
			System.arraycopy(customPamConsultationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomPamCsulSlpVOS(CustomPamCsulSlpVO[] customPamCsulSlpVOs){
		if (customPamCsulSlpVOs != null) {
			CustomPamCsulSlpVO[] tmpVOs = new CustomPamCsulSlpVO[customPamCsulSlpVOs.length];
			System.arraycopy(customPamCsulSlpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customPamCsulSlpVOs = tmpVOs;
		}
	}
	
	public CustomPamCsulSlpVO[] getCustomPamCsulSlpVOS(){
		CustomPamCsulSlpVO[] rtnVOs = null;
		if (this.customPamCsulSlpVOs != null) {
			rtnVOs = new CustomPamCsulSlpVO[customPamCsulSlpVOs.length];
			System.arraycopy(customPamCsulSlpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomTaxVO(CustomTaxVO customTaxVO){
		this.customTaxVO = customTaxVO;
	}

	public CustomTaxVO getCustomTaxVO(){
		return customTaxVO;
	}
	
	public void setCustomTaxVOS(CustomTaxVO[] customTaxVOs){
			if (customTaxVOs != null) {
			CustomTaxVO[] tmpVOs = new CustomTaxVO[customTaxVOs.length];
			System.arraycopy(customTaxVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customTaxVOs = tmpVOs;
		}
	}
	
	public CustomTaxVO[] getCustomTaxVOS(){
		CustomTaxVO[] rtnVOs = null;
		if (this.customTaxVOs != null) {
			rtnVOs = new CustomTaxVO[customTaxVOs.length];
			System.arraycopy(customTaxVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomTaxDtlVOS(CustomTaxDtlVO[] customTaxDtlVOs){
		if (customTaxDtlVOs != null) {
			CustomTaxDtlVO[] tmpVOs = new CustomTaxDtlVO[customTaxDtlVOs.length];
			System.arraycopy(customTaxDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customTaxDtlVOs = tmpVOs;
		}
	}
	
	public CustomTaxDtlVO[] getCustomTaxDtlVOS(){
		CustomTaxDtlVO[] rtnVOs = null;
		if (this.customTaxDtlVOs != null) {
			rtnVOs = new CustomTaxDtlVO[customTaxDtlVOs.length];
			System.arraycopy(customTaxDtlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	public String getCsrDesc() {
		return csrDesc;
	}

	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	public String getCtrCd() {
		return ctrCd;
	}

	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	public String getBunkerVvd() {
		return bunkerVvd;
	}

	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
	}
}