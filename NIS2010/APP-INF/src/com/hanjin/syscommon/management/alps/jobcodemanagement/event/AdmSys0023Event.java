/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_011Event.java
*@FileTitle : 프로그램별 역할매핑 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : Kildong_hong
*@LastVersion : 1.0
* 2006-11-10 Kildong_hong
* 1.0 최초 생성 
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;


/**
 * UI_COM_SYS_011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_COM_SYS_011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kildong_hong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class AdmSys0023Event extends EventSupport {

	/** com_pgm_role Table  Value Object */
	private JobCodeManagementVO jobCodeManagementVO = null;

	/** comPgmRoles Multi Action을 위한 Collection */
	private JobCodeManagementVO[] jobCodeManagementVOs = null;

	/**
	 * @return the jobCodeManagementVO
	 */
	public JobCodeManagementVO getJobCodeManagementVO() {
		return jobCodeManagementVO;
	}

	/**
	 * @param jobCodeManagementVO the jobCodeManagementVO to set
	 */
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
			JobCodeManagementVO[] tempVOs = Arrays.copyOf(jobCodeManagementVOs, jobCodeManagementVOs.length);
			this.jobCodeManagementVOs = tempVOs;
		}
	}	
}
