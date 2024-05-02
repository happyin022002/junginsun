/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPEUtils.java
*@FileTitle : Service Provider Evaluation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-23
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.0
* 2007-03-23 Jung-Jae Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.lea.common;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger; 

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * 공통으로 사용되는 로직 <br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class LEAUtils {
	protected transient static Logger log = Logger.getLogger("com.clt.apps.opus.esd.spe.SPEUtils");
	//protected transient static Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * @param req HttpServletRequest HttpRequest
	 * @return HashMap request parameter 정보를 담고있는  HashMap object
	 */
	public static HashMap getParams(HttpServletRequest req)  {
		HashMap params = new HashMap();

		Enumeration e = req.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			params.put(key, JSPUtil.getParameter(req,key));
		}
		return params;
	}
	
	/**
	 * IBSheet 외에 넘겨 받아야할 request parameter들을 객체에 저장.
	 * @param request
	 * @param event
	 * @return
	 */
	public static EventSupport setParams(HttpServletRequest request, EventSupport event)	{
		HashMap params =  getParams(request);
		log.info("=========================="+params);
		event.setEventParams(params);
		
		return event;
	}
}
