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
package com.hanjin.sample.ftp.send.basic;

import com.hanjin.sample.ftp.send.integration.SendFileEAIDAO;
import com.hanjin.framework.component.ftp.FtpException;
import com.hanjin.framework.table.ComFtpSndInfoVO;

/** It's SendFileBCImpl.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Sep 4, 2009
 */
public class SendFileBCImpl implements SendFileBC {

	/* (non-Javadoc)
	 * @see com.hanjin.sample.ftp.send.basic.SendFileBC#sendFile(com.hanjin.syscommon.common.table.ComFtpSndInfoVO)
	 */
	@Override
	public String sendFile(ComFtpSndInfoVO comFtpSndInfoVO) throws FtpException {
		SendFileEAIDAO eaiDao = new SendFileEAIDAO();
		return eaiDao.sendFile(comFtpSndInfoVO);
	}

}
