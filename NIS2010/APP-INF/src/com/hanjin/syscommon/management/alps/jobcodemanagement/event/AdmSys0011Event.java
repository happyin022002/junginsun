/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdmSys0011Event.java
*@FileTitle : Commission Agreement Creation_Master
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.04.17 최덕우
* 1.0 Creation 
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;


/**
 * ADM_SYS_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ADM_SYS_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ADM_SYS_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class AdmSys0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JobCodeManagementVO jobCodeManagementVO = null;

	/** Table Value Object Multi Data 처리  */
	private JobCodeManagementVO[] jobCodeManagementVOs = null;

	public AdmSys0011Event() {}


	public JobCodeManagementVO getJobCodeManagementVO() {
		return jobCodeManagementVO;
	}

	public void setJobCodeManagementVO(JobCodeManagementVO jobCodeManagementVO) {
		this.jobCodeManagementVO = jobCodeManagementVO;
	}


	/**
	 * @return the jobCodeManagementVOs
	 */
	public JobCodeManagementVO[] getJobCodeManagementVOs() {
		JobCodeManagementVO[] rtnVOs = null;
		if(this.jobCodeManagementVOs != null){
			rtnVOs = Arrays.copyOf(this.jobCodeManagementVOs, this.jobCodeManagementVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param jobCodeManagementVOs the jobCodeManagementVOs to set
	 */
	public void setJobCodeManagementVOs(JobCodeManagementVO[] jobCodeManagementVOs) {
		if(jobCodeManagementVOs != null){
			JobCodeManagementVO[] tempVOs = Arrays.copyOf(jobCodeManagementVOs,jobCodeManagementVOs.length);
			this.jobCodeManagementVOs = tempVOs;
		}
	}

}