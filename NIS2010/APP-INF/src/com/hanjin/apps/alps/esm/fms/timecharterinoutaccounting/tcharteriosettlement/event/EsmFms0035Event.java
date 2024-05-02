/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0035Event.java
*@FileTitle : Prepayments Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.22 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceByPaymentSlipVO searchInvoiceByPaymentSlipVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceByPaymentSlipVO[] searchInvoiceByPaymentSlipVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomConsultationVO customConsultationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomConsultationVO[] customConsultationVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomCsulSlpVO[] customCsulSlpVOs = null;
	
	/** Contract No. */
	private String fletCtrtNo = "";

	public EsmFms0035Event(){}
	
	public void setSearchInvoiceByPaymentSlipVO(SearchInvoiceByPaymentSlipVO searchInvoiceByPaymentSlipVO){
		this. searchInvoiceByPaymentSlipVO = searchInvoiceByPaymentSlipVO;
	}

	public void setSearchInvoiceByPaymentSlipVOS(SearchInvoiceByPaymentSlipVO[] searchInvoiceByPaymentSlipVOs){
		if (searchInvoiceByPaymentSlipVOs != null) {
			SearchInvoiceByPaymentSlipVO[] tmpVOs = Arrays.copyOf(searchInvoiceByPaymentSlipVOs, searchInvoiceByPaymentSlipVOs.length);
			this.searchInvoiceByPaymentSlipVOs = tmpVOs;
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

	public SearchInvoiceByPaymentSlipVO getSearchInvoiceByPaymentSlipVO(){
		return searchInvoiceByPaymentSlipVO;
	}

	public SearchInvoiceByPaymentSlipVO[] getSearchInvoiceByPaymentSlipVOS(){
		SearchInvoiceByPaymentSlipVO[] rtnVOs = null;
		if (this.searchInvoiceByPaymentSlipVOs != null) {
			rtnVOs = Arrays.copyOf(searchInvoiceByPaymentSlipVOs, searchInvoiceByPaymentSlipVOs.length);
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

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

}