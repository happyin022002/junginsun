/*========================================================
*Copyright(c) 2012 CyberLogitec
*ProcessChain    : BST
*@FileName       : SampleReportFtpBCImpl.java
*@FileTitle      	 : 
*@Author           : Jeong-Hoon, KIM
*Open Issues     :
*Change history  :
*@LastModifyDate : 2012. 4. 3.
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.sample.ftp.subsystem.basic;

import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.sample.ftp.subsystem.integration.SampleReportFtp310EAIDAO;

/**
 * SampleReportFtpBCImpl.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2012. 4. 3.
 */
public class SampleReportFtpBCImpl implements SampleReportFtpBC {
	/**
	 * 
	 * @author Jeong-Hoon, KIM
	 * @param comRptDsgnXptInfoVO void
	 */
	public void sendReportFtp(ComRptDsgnXptInfoVO comRptDsgnXptInfoVO) {
		SampleReportFtp310EAIDAO sampleReportFtpEAIDAO = new SampleReportFtp310EAIDAO();
		sampleReportFtpEAIDAO.sendReportFtp(comRptDsgnXptInfoVO);
	}

}

