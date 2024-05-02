/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SampleReportFtpHTMLAction
*@FileTitle : SampleReportFtpHTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2012.04.03 김정훈
* 1.0 Creation
=========================================================*/
package com.hanjin.sample.ftp.report.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * 
 * SampleReportFtpHTMLAction.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2012. 4. 4.
 */
public class SampleReportFtpHTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8470654005098887813L;

	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		SampleReportFtpEvent  event = new SampleReportFtpEvent();
		event.setComRptDsgnXptInfoVO((ComRptDsgnXptInfoVO)getVO(request, ComRptDsgnXptInfoVO.class));
		return event;
	}

}
