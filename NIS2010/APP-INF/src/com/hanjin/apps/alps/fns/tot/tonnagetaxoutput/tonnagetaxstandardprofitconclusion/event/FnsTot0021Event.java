/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0021Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.08.03 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.JbSkdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS_TOT_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String paramStartDate = null;
	private String paramEndDate = null;
	private String runJob = null;
	private String stDate = null;
	private String jobId = null;	
	private String batId = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JbSkdVO jbSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JbSkdVO[] jbSkdVOs = null;
	
	public FnsTot0021Event(){}

	
	public String getRunJob() {
		return runJob;
	}


	public void setRunJob(String runJob) {
		this.runJob = runJob;
	}


	public String getStDate() {
		return stDate;
	}


	public void setStDate(String stDate) {
		this.stDate = stDate;
	}


	public void setParamStartDate(String paramStartDate) {
		this.paramStartDate = paramStartDate;
	}


	public String getParamStartDate() {
		return paramStartDate;
	}
	
	public void setParamEndDate(String paramEndDate) {
		this.paramEndDate = paramEndDate;
	}

	public String getParamEndDate() {
		return paramEndDate;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public String getJobId() {
		return jobId;
	}

	public void setBatId(String batId) {
		this.batId = batId;
	}


	public String getBatId() {
		return batId;
	}
	
	public JbSkdVO getJbSkdVO() {
		return jbSkdVO;
	}

	public void setJbSkdVO(JbSkdVO jbSkdVO) {
		this.jbSkdVO = jbSkdVO;
	}

	public JbSkdVO[] getJbSkdVOs() {
		JbSkdVO[] rtnVOs = null;
		if (this.jbSkdVOs != null) {
			rtnVOs = new JbSkdVO[jbSkdVOs.length];
			System.arraycopy(jbSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setJbSkdVOs(JbSkdVO[] jbSkdVOs) {
		if (jbSkdVOs != null) {
			JbSkdVO[] tmpVOs = new JbSkdVO[jbSkdVOs.length];
			System.arraycopy(jbSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jbSkdVOs = tmpVOs;
		}
	}	
	
}