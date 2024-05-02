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
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EES_MNR_0243HTMLAction;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		EstimateUploadVO[] rtnVOs = null;
		if (this.estimateUploadVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(estimateUploadVOs, estimateUploadVOs.length);
		}
		return rtnVOs;
	}

	public void setEstimateUploadVOs(EstimateUploadVO[] estimateUploadVOs){
		if(estimateUploadVOs != null){
			EstimateUploadVO[] tmpVOs = java.util.Arrays.copyOf(estimateUploadVOs, estimateUploadVOs.length);
			this.estimateUploadVOs = tmpVOs;
		}
	}

	/**
	 * @return the customMnrRprRqstTmpHdrVOs
	 */
	public CustomMnrRprRqstTmpHdrVO[] getCustomMnrRprRqstTmpHdrVOs() {
		CustomMnrRprRqstTmpHdrVO[] rtnVOs = null;
		if (this.customMnrRprRqstTmpHdrVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrRprRqstTmpHdrVOs, customMnrRprRqstTmpHdrVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param customMnrRprRqstTmpHdrVOs the customMnrRprRqstTmpHdrVOs to set
	 */
	public void setCustomMnrRprRqstTmpHdrVOs(CustomMnrRprRqstTmpHdrVO[] customMnrRprRqstTmpHdrVOs){
		if(customMnrRprRqstTmpHdrVOs != null){
			CustomMnrRprRqstTmpHdrVO[] tmpVOs = java.util.Arrays.copyOf(customMnrRprRqstTmpHdrVOs, customMnrRprRqstTmpHdrVOs.length);
			this.customMnrRprRqstTmpHdrVOs = tmpVOs;
		}
	}
}