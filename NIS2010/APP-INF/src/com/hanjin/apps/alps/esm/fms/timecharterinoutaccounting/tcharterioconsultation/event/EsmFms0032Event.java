/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0032Event.java
*@FileTitle : Sublet Revenue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.24 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, WooSeok
 * @see ESM_FMS_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomConsultationVO customConsultationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomConsultationVO[] customConsultationVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomCsulSlpVO customCsulSlpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomCsulSlpVO[] customCsulSlpVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomCsulSlpSeqVO customCsulSlpSeqVO = null;
	
	private String fletCtrtNo = "";
	
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
	
	public void setCustomCsulSlpVO(CustomCsulSlpVO customCsulSlpVO){
		this. customCsulSlpVO = customCsulSlpVO;
	}

	public void setCustomCsulSlpVOS(CustomCsulSlpVO[] customCsulSlpVOs){
		if (customCsulSlpVOs != null) {
			CustomCsulSlpVO[] tmpVOs = new CustomCsulSlpVO[customCsulSlpVOs.length];
			System.arraycopy(customCsulSlpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customCsulSlpVOs = tmpVOs;
		}
	}

	public CustomCsulSlpVO getCustomCsulSlpVO(){
		return customCsulSlpVO;
	}

	public CustomCsulSlpVO[] getCustomCsulSlpVOS(){
		CustomCsulSlpVO[] rtnVOs = null;
		if (this.customCsulSlpVOs != null) {
			rtnVOs = new CustomCsulSlpVO[customCsulSlpVOs.length];
			System.arraycopy(customCsulSlpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCustomCsulSlpSeqVO(CustomCsulSlpSeqVO customCsulSlpSeqVO){
		this. customCsulSlpSeqVO = customCsulSlpSeqVO;
	}

	public CustomCsulSlpSeqVO getCustomCsulSlpSeqVO(){
		return customCsulSlpSeqVO;
	}

	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
}