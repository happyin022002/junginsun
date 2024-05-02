/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : EsmFms0095Event.java
 *@FileTitle : Owner's Account
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.18
 *@LastModifier : 손진환
 *@LastVersion : 1.0
 * 2016.02.18 손진환
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsConsultationVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_FMS_0095 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_FMS_0095HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Son, Jin-Hwan
 * @see ESM_FMS_0095HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0095Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	FmsConsultationVO fmsConsultationVO = null;

	/** Table Value Object Multi Data 처리 */
	FmsConsultationVO[] fmsConsultationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	FmsCsulSlpVO fmsCsulSlpVO = null;

	/** Table Value Object Multi Data 처리 */
	FmsCsulSlpVO[] fmsCsulSlpVOs = null;

	/** CSR No. */
	private String csrNo = "";

	/** Approval Type */
	private String aproType = "";
	
	/** Search Flag */
	private String sFlg = "";
	
	/** Vendor No */
	private String vndrSeq = "";
	
	/** Invoice No */
	private String toInvNo = "";
	
	/** vvd */	
	private String vvd = "";
	
	/** Location */
	private String oaLocCd = "";
	
	// Tax Evidence Master VO
	private CustomTaxVO customTaxVO = null;
	
	// Tax Evidence Master VO
	private CustomTaxVO[] customTaxVOs = null;
	
	/** Tax Evidence Detail VO - Table Value Object Multi Data 처리 */
	private CustomTaxDtlVO[] customTaxDtlVOs = null;
		
	public EsmFms0095Event() {
	}

	public void setFmsConsultationVO(FmsConsultationVO fmsConsultationVO) {
		this.fmsConsultationVO = fmsConsultationVO;
	}

	public void setFmsConsultationVOS(FmsConsultationVO[] fmsConsultationVOs) {
		if (fmsConsultationVOs != null) {
			FmsConsultationVO[] tmpVOs = Arrays.copyOf(fmsConsultationVOs,
					fmsConsultationVOs.length);
			this.fmsConsultationVOs = tmpVOs;
		}
	}

	public void setFmsCsulSlpVO(FmsCsulSlpVO fmsCsulSlpVO) {
		this.fmsCsulSlpVO = fmsCsulSlpVO;
	}

	public void setFmsCsulSlpVOS(FmsCsulSlpVO[] fmsCsulSlpVOs) {
		if (fmsCsulSlpVOs != null) {
			FmsCsulSlpVO[] tmpVOs = Arrays.copyOf(fmsCsulSlpVOs,
					fmsCsulSlpVOs.length);
			this.fmsCsulSlpVOs = tmpVOs;
		}
	}

	public FmsConsultationVO getFmsConsultationVO() {
		return fmsConsultationVO;
	}

	public FmsConsultationVO[] getFmsConsultationVOS() {
		FmsConsultationVO[] tmpVOs = null;
		if (this.fmsConsultationVOs != null) {
			tmpVOs = Arrays.copyOf(fmsConsultationVOs,
					fmsConsultationVOs.length);
		}
		return tmpVOs;
	}

	public FmsCsulSlpVO getFmsCsulSlpVO() {
		return fmsCsulSlpVO;
	}

	public FmsCsulSlpVO[] getFmsCsulSlpVOS() {
		FmsCsulSlpVO[] tmpVOs = null;
		if (this.fmsCsulSlpVOs != null) {
			tmpVOs = Arrays.copyOf(fmsCsulSlpVOs, fmsCsulSlpVOs.length);
		}
		return tmpVOs;
	}

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

	public String getAproType() {
		return aproType;
	}

	public void setAproType(String aproType) {
		this.aproType = aproType;
	}

	public String getsFlg() {
		return sFlg;
	}

	public void setsFlg(String sFlg) {
		this.sFlg = sFlg;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getToInvNo() {
		return toInvNo;
	}

	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	public String getOaLocCd() {
		return oaLocCd;
	}

	public void setOaLocCd(String oaLocCd) {
		this.oaLocCd = oaLocCd;
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
}