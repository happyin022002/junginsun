/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SampleReportFtpEvent
*@FileTitle : SampleReportFtpEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2012.04.03 김정훈
* 1.0 Creation
=========================================================*/
package com.hanjin.sample.ftp.subsystem.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * 
 * SampleReportFtpEvent.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2012. 4. 4.
 */
public class SampleReportFtpEvent extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8604538394528341579L;

	private ComRptDsgnXptInfoVO comRptDsgnXptInfoVO;

	/**
	 * 
	 * @author Jeong-Hoon, KIM
	 * @param comRptDsgnXptInfoVO void
	 */
	public void setComRptDsgnXptInfoVO(ComRptDsgnXptInfoVO comRptDsgnXptInfoVO) {
		this.comRptDsgnXptInfoVO = comRptDsgnXptInfoVO;
	}

	/**
	 * 
	 * @author Jeong-Hoon, KIM
	 * @return ComRptDsgnXptInfoVO
	 */
	public ComRptDsgnXptInfoVO getComRptDsgnXptInfoVO() {
		return comRptDsgnXptInfoVO;
	}
	
}
