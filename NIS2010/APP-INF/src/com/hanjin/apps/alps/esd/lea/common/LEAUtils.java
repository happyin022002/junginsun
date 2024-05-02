/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LEAUtils.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-23
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.0
* 2007-03-23 Jung-Jae Kim
* 1.0 최초 생성
* @History
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
=========================================================*/
package com.hanjin.apps.alps.esd.lea.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * 공통으로 사용되는 로직 <br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class LEAUtils {
	protected transient static Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.lea.LEAUtils");
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
	
	/**
	 * 화면에서 넘긴 request 객체의 데이터를 HashMap에 입력하여 HashMap객체를 리턴한다.
	 * 
	 * key   : 화면의 컨트롤객체 이름
	 * value : 화면의 컨트롤객체 값
	 * 
	 * @param request
	 * @return HashMap
	 */
	public static HashMap requestToHashMap(HttpServletRequest request){
		// requestToHashMap(HttpServletRequest request)
		HashMap hash = new HashMap();
		Map map = request.getParameterMap();
		Iterator it = map.keySet().iterator();
		Object key = null;
		String[] value = null;
		StringBuffer sysOut = new StringBuffer();
		
		while(it.hasNext()){
			key = it.next();
			value = (String[])map.get(key);
			hash.put(key, value);
			//sysOut.append("\n key[" +Utils.fillSpace((String)key, 15, " ", "right")+ "] : [");
			for(int i=0; i<value.length; i++){
				sysOut.append(value[i] );
				if(i != value.length-1)sysOut.append( " : ");
			}
			//sysOut.append("]");
		}
		
		log.debug(sysOut.toString());
		
		return hash;
	}
	
}
