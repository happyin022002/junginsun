/*========================================================
*Copyright(c) 2012 CyberLogitec
*ProcessChain    : BST
*@FileName       : SampleReportFtpBC.java
*@FileTitle      	 : 
*@Author           : Jeong-Hoon, KIM
*Open Issues     :
*Change history  :
*@LastModifyDate : 2012. 4. 3.
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.sample.ftp.report.basic;

import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * SampleReportFtpBC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2012. 4. 3.
 */
public interface SampleReportFtpBC {

	void sendReportFtp(ComRptDsgnXptInfoVO comRptDsgnXptInfoVO);

}

