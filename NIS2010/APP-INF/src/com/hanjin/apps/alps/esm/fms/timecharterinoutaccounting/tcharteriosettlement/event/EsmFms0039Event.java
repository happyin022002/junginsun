/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0039Event.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.25 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondOwnerAccountExpenseVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondOwnerAccountExpenseVO condOwnerAccountExpenseVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondOwnerAccountExpenseVO[] condOwnerAccountExpenseVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomConsultationVO customConsultationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomConsultationVO[] customConsultationVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomCsulSlpVO[] customCsulSlpVOs = null;
	
	/** Effective Date */
	private String effDt = "";
	
	/** Contract No. */
	private String fletCtrtNo = "";

	public EsmFms0039Event(){}
	
	public void setCondOwnerAccountExpenseVO(CondOwnerAccountExpenseVO condOwnerAccountExpenseVO){
		this. condOwnerAccountExpenseVO = condOwnerAccountExpenseVO;
	}

	public void setCondOwnerAccountExpenseVOS(CondOwnerAccountExpenseVO[] condOwnerAccountExpenseVOs){
		if (condOwnerAccountExpenseVOs != null) {
			CondOwnerAccountExpenseVO[] tmpVOs = Arrays.copyOf(condOwnerAccountExpenseVOs, condOwnerAccountExpenseVOs.length);
			this.condOwnerAccountExpenseVOs = tmpVOs;
		}
	}

	public void setCustomConsultationVO(CustomConsultationVO customConsultationVO){
		this. customConsultationVO = customConsultationVO;
	}

	public void setCustomConsultationVOS(CustomConsultationVO[] customConsultationVOs){
		if (customConsultationVOs != null) {
			CustomConsultationVO[] tmpVOs = Arrays.copyOf(customConsultationVOs, customConsultationVOs.length);
			this.customConsultationVOs = tmpVOs;
		}
	}

	public void setCustomCsulSlpVOS(CustomCsulSlpVO[] customCsulSlpVOs){
		if (customCsulSlpVOs != null) {
			CustomCsulSlpVO[] tmpVOs = Arrays.copyOf(customCsulSlpVOs, customCsulSlpVOs.length);
			this.customCsulSlpVOs = tmpVOs;
		}
	}

	public CondOwnerAccountExpenseVO getCondOwnerAccountExpenseVO(){
		return condOwnerAccountExpenseVO;
	}

	public CondOwnerAccountExpenseVO[] getCondOwnerAccountExpenseVOS(){
		CondOwnerAccountExpenseVO[] rtnVOs = null;
		if (this.condOwnerAccountExpenseVOs != null) {
			rtnVOs = Arrays.copyOf(condOwnerAccountExpenseVOs, condOwnerAccountExpenseVOs.length);
		}
		return rtnVOs;
	}

	public CustomConsultationVO getCustomConsultationVO(){
		return customConsultationVO;
	}

	public CustomConsultationVO[] getCustomConsultationVOS(){
		CustomConsultationVO[] rtnVOs = null;
		if (this.customConsultationVOs != null) {
			rtnVOs = Arrays.copyOf(customConsultationVOs, customConsultationVOs.length);
		}
		return rtnVOs;
	}

	public CustomCsulSlpVO[] getCustomCsulSlpVOS(){
		CustomCsulSlpVO[] rtnVOs = null;
		if (this.customCsulSlpVOs != null) {
			rtnVOs = Arrays.copyOf(customCsulSlpVOs, customCsulSlpVOs.length);
		}
		return rtnVOs;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	public String getEffDt() {
		return effDt;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

}