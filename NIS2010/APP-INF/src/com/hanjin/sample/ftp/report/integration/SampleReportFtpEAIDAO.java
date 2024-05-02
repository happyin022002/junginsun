/*========================================================
*Copyright(c) 2012 CyberLogitec
*ProcessChain    : BST
*@FileName       : SampleReportFtpEAIDAO.java
*@FileTitle      	 : 
*@Author           : Jeong-Hoon, KIM
*Open Issues     :
*Change history  :
*@LastModifyDate : 2012. 4. 3.
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.sample.ftp.report.integration;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.ftp.Ftp;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * SampleReportFtpEAIDAO.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2012. 4. 3.
 */
public class SampleReportFtpEAIDAO {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	/**
	 * 
	 * @author Jeong-Hoon, KIM
	 * @param comRptDsgnXptInfoVO void
	 */
	public void sendReportFtp(ComRptDsgnXptInfoVO comRptDsgnXptInfoVO) {
		Ftp ftp = new Ftp();
		ftp.setRdApplCd(comRptDsgnXptInfoVO.getRdApplCd());
		ftp.setRdParaCtnt(comRptDsgnXptInfoVO.getRdParaCtnt());
		ftp.setSubSysCd("COM");
		ftp.setUserId("TestReportFax");
		ftp.setXptFileNm(comRptDsgnXptInfoVO.getXptFileNm());
		try {
			ftp.sendEsvcReportFile("ESVC");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}

