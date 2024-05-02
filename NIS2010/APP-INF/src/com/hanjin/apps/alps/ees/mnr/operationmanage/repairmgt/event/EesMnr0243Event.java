/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0243Event.java
*@FileTitle : EDI & Excel Estimate Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.19
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.19 장준우
* 1.0 Creation
--------------------------------------------------------
* History
* 2012.06.15 신혜정 [CHM-201218436] [Calculation] 버튼 기능 추가  
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EES_MNR_0243HTMLAction;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0243 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0243HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_MNR_0243HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0243Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor.
	 */
	public EesMnr0243Event(){}
	
	//호출 화면을 구분하기 위한 
	private String reqUi = null;
	
	public String getReqUi() {
		return reqUi;
	}

	public void setReqUi(String reqUi) {
		this.reqUi = reqUi;
	}

	/** Table Value Object Multi Data 처리 */
	private EstimateUploadVO[] estimateUploadVOs = null;

	private CustomMnrRprRqstTmpHdrVO[] customMnrRprRqstTmpHdrVOs = null;

	public EstimateUploadVO[] getEstimateUploadVOs() {
		return estimateUploadVOs;
	}

	public void setEstimateUploadVOs(EstimateUploadVO[] estimateUploadVOs) {
		this.estimateUploadVOs = estimateUploadVOs;
	}

	/**
	 * @return the customMnrRprRqstTmpHdrVOs
	 */
	public CustomMnrRprRqstTmpHdrVO[] getCustomMnrRprRqstTmpHdrVOs() {
		return customMnrRprRqstTmpHdrVOs;
	}

	/**
	 * @param customMnrRprRqstTmpHdrVOs the customMnrRprRqstTmpHdrVOs to set
	 */
	public void setCustomMnrRprRqstTmpHdrVOs(
			CustomMnrRprRqstTmpHdrVO[] customMnrRprRqstTmpHdrVOs) {
		this.customMnrRprRqstTmpHdrVOs = customMnrRprRqstTmpHdrVOs;
	}
	
	private EstimateGRPVO estimateGRPVO = null;

	public EstimateGRPVO getEstimateGRPVO() {
		return estimateGRPVO; 
	}

	public void setEstimateGRPVO(EstimateGRPVO estimateGRPVO) {
		this.estimateGRPVO = estimateGRPVO;
	} 
	
}