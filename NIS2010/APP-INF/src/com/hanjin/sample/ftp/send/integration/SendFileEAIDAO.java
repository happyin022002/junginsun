/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : SendFileEAIDAO.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Sep 4, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
/**
 * 
 */
package com.hanjin.sample.ftp.send.integration;

import com.hanjin.framework.component.ftp.FtpException;
import com.hanjin.framework.component.ftp.FtpUtility;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComFtpSndInfoVO;

/** It's SendFileEAIDAO.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Sep 4, 2009
 */
public class SendFileEAIDAO extends EAIDAOSupport {

	/**This method 
	 * @author Jeong-Hoon, KIM
	 * @param comFtpSndInfoVO
	 * @throws FtpException 
	 */
	public String sendFile(ComFtpSndInfoVO comFtpSndInfoVO) throws FtpException {
		return FtpUtility.send(comFtpSndInfoVO);
	}

}
