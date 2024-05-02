/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : SendFileBCImpl.java
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
package com.clt.sample.ftp.send.basic;

import com.clt.framework.component.ftp.FtpException;
import com.clt.framework.component.ftp.FtpMetaInfo;
import com.clt.framework.table.ComFtpSndInfoVO;
import com.clt.sample.ftp.send.integration.SendFileEAIDAO;

/** It's SendFileBCImpl.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Sep 4, 2009
 */
public class SendFileBCImpl implements SendFileBC {

	/**
	 * 
	 * sendFile
	 * @author Jeong-Hoon, KIM
	 * @param comFtpSndInfoVO
	 * @return
	 * @throws FtpException String
	 */
	public String sendFile(ComFtpSndInfoVO comFtpSndInfoVO) throws FtpException {
		SendFileEAIDAO eaiDao = new SendFileEAIDAO();
		return eaiDao.sendFile(comFtpSndInfoVO);
	}

	/**
	 * 
	 * sendFileRpt
	 * @author Jeong-Hoon, KIM
	 * @param ftpMetaInfo
	 * @return
	 * @throws FtpException String
	 */
	public String sendFileRpt(FtpMetaInfo ftpMetaInfo) throws FtpException {
		SendFileEAIDAO eaiDao = new SendFileEAIDAO();
		return eaiDao.sendFileRpt(ftpMetaInfo);
	}

}
