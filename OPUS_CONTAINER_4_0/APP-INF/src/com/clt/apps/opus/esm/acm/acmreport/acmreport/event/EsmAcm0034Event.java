/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0034Event.java
*@FileTitle : CSR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.17
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.17 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmreport.acmreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.CSRInquiryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Bong-Gyoon
 * @see ESM_ACM_0034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CSRInquiryVO csrInquiryVO = null;

	/** Table Value Object Multi Data 처리 */
	private CSRInquiryVO[] csrInquiryVOs = null;

	public EsmAcm0034Event() {}

	public CSRInquiryVO getCSRInquiryVO() {
		return csrInquiryVO;
	}

	public void setCSRInquiryVO(CSRInquiryVO csrInquiryVO) {
		this.csrInquiryVO = csrInquiryVO;
	}

	public CSRInquiryVO[] getCSRInquiryVOs() {
		CSRInquiryVO[] rtnVOs = null;
		if (this.csrInquiryVOs != null) {
			rtnVOs = Arrays.copyOf(csrInquiryVOs, csrInquiryVOs.length);
		}
		return rtnVOs;
	}

	public void setCSRInquiryVOs(CSRInquiryVO[] csrInquiryVOs) {
		if(csrInquiryVOs != null){
			CSRInquiryVO[] tmpVOs = Arrays.copyOf(csrInquiryVOs, csrInquiryVOs.length);
			this.csrInquiryVOs  = tmpVOs;
		}
	}


}