/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdmSys0020Event.java
*@FileTitle : User Job Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.05.17 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeInquiryVO;


/**
 * ADM_SYS_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ADM_SYS_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ADM_SYS_0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class AdmSys0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JobCodeInquiryVO jobCodeInquiryVO = null;

	public AdmSys0020Event() {}


	public JobCodeInquiryVO getJobCodeInquiryVO() {
		return jobCodeInquiryVO;
	}

	public void setJobCodeInquiryVO(JobCodeInquiryVO jobCodeInquiryVO) {
		this.jobCodeInquiryVO = jobCodeInquiryVO;
	}

}