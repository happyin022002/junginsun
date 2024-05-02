/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0033Event.java
*@FileTitle : Reverse CSR for Sublet
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.03 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, WooSeok
 * @see ESM_FMS_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object Multi Data 처리 */
	private CustomCsulSlpVO[] customCsulSlpVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomConsultationVO customConsultationVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomCsulSlpSeqVO customCsulSlpSeqVO = null;
	
	// Tax Evidence Master VO
	private CustomTaxVO customTaxVO = null;
	
	// Tax Evidence Master VO
	private CustomTaxVO[] customTaxVOs = null;
	
	/** Tax Evidence Detail VO - Table Value Object Multi Data 처리 */
	private CustomTaxDtlVO[] customTaxDtlVOs = null;

	public void setCustomCsulSlpVOS(CustomCsulSlpVO[] customCsulSlpVOs){
		if (customCsulSlpVOs != null) {
			CustomCsulSlpVO[] tmpVOs = new CustomCsulSlpVO[customCsulSlpVOs.length];
			System.arraycopy(customCsulSlpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customCsulSlpVOs = tmpVOs;
		}
	}
	
	public CustomCsulSlpVO[] getCustomCsulSlpVOS(){
		CustomCsulSlpVO[] tmpVOs = null;
		if (this.customCsulSlpVOs != null) {
			tmpVOs = new CustomCsulSlpVO[customCsulSlpVOs.length];
			System.arraycopy(customCsulSlpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setCustomConsultationVO(CustomConsultationVO customConsultationVO){
		this. customConsultationVO = customConsultationVO;
	}

	public CustomConsultationVO getCustomConsultationVO(){
		return customConsultationVO;
	}
	
	public void setCustomCsulSlpSeqVO(CustomCsulSlpSeqVO customCsulSlpSeqVO){
		this. customCsulSlpSeqVO = customCsulSlpSeqVO;
	}

	public CustomCsulSlpSeqVO getCustomCsulSlpSeqVO(){
		return customCsulSlpSeqVO;
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
		CustomTaxVO[] tmpVOs = null;
		if (this.customTaxVOs != null) {
			tmpVOs = new CustomTaxVO[customTaxVOs.length];
			System.arraycopy(customTaxVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setCustomTaxDtlVOS(CustomTaxDtlVO[] customTaxDtlVOs){
		if (customTaxDtlVOs != null) {
			CustomTaxDtlVO[] tmpVOs = new CustomTaxDtlVO[customTaxDtlVOs.length];
			System.arraycopy(customTaxDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customTaxDtlVOs = tmpVOs;
		}
	}
	
	public CustomTaxDtlVO[] getCustomTaxDtlVOS(){
		CustomTaxDtlVO[] tmpVOs = null;
		if (this.customTaxDtlVOs != null) {
			tmpVOs = new CustomTaxDtlVO[customTaxDtlVOs.length];
			System.arraycopy(customTaxDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}