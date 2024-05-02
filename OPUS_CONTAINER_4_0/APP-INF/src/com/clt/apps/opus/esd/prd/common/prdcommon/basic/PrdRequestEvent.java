/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdRequestEvent.java
 *@FileTitle : PrdRequestEvent
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-03-11
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2008-03-11 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.basic;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * PRD에 대한 request 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 request를 담고 있는 객체 .<br>
 * 
 * @author jungsunyoung
 * @see 참조
 * @since J2EE 1.4
 */
public class PrdRequestEvent extends EventSupport {
	private static final long serialVersionUID = 1L;

	HttpServletRequest request = null;
	ArrayList<String> keyList = new ArrayList<String>();
	HashMap<String, String> valueLengthMap = new HashMap<String, String>();
	int paramCnt = 0;

	public PrdRequestEvent() {
	}

	/**
	 * PrdRequestEvent.java's Construct
	 * 
	 * @param request
	 */
	public PrdRequestEvent(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * PrdRequestEvent's getInstance
	 * 
	 * @param request
	 * @return PrdRequestEvent
	 */
	static public PrdRequestEvent getInstance(HttpServletRequest request) {
		PrdRequestEvent prdRequest = new PrdRequestEvent(request);
		prdRequest.setRequest(request);

		return prdRequest;
	}

	@SuppressWarnings("rawtypes")
	private void setRequest(HttpServletRequest request) {
		Enumeration parameterNames = request.getParameterNames();
		String paramName = null;
		String[] paramValues = null;
		if (parameterNames != null) {
			while (parameterNames.hasMoreElements()) {
				paramName = parameterNames.nextElement().toString();
				paramValues = request.getParameterValues(paramName);
				if (paramValues == null) {
					paramValues = new String[1];
					paramValues[0] = "";
				}

				if (paramValues.length > 1) {
					putValue(paramName, paramValues);
				} else {
					putValue(paramName, paramValues[0]);
				}
			}
		}
	}

	/**
	 * BasicRequestBC's putValue
	 * 
	 * @param key
	 * @param value
	 */
	public void putValue(String key, Object value) {
		String[] arrStr = null;
		String arrChk = "";
		if (CheckUtilities.isInBlank(key))
			return;

		if (value == null) {
			arrStr = new String[1];
			arrStr[0] = "";
			this.setAttribute(key, null);
		} else {
			if (value.getClass().equals(String.class)) {
				arrStr = new String[1];
				arrStr[0] = (String) value;
			} else {
				arrChk = "Y";
				arrStr = (String[]) value;
			}
			this.setAttribute(key, value);
		}

		if (!keyList.contains(key)) {
			this.keyList.add(this.paramCnt++, key);
		}

		if (arrStr != null) {
			int length = arrStr.length;
			if (arrChk.equals("Y") && length == 1) {
				this.valueLengthMap.put(key, String.valueOf(length + 1));
			} else {
				this.valueLengthMap.put(key, String.valueOf(length));
			}
		}
	}

	/**
	 * BasicRequestBC's getObject
	 * 
	 * @param key
	 * @return Object
	 */
	public Object getObject(String key) {
		return (key == null) ? null : this.getAttribute(key);
	}

	/**
	 * PrdRequestEvent's getObjectString
	 * 
	 * @param key
	 * @return String
	 */
	public String getObjectString(String key) {
		StringBuffer sb = new StringBuffer();
		String[] arrStr = null;
		String str = "";
		if (this.valueLengthMap.get(key).equals("1")) {

			str = ((key == null) ? null : (String) this.getAttribute(key));
			sb.append(key + "=" + str + ",");
		} else {
			arrStr = (String[]) ((key == null) ? null : this.getAttribute(key));
			for (int i = 0; i < arrStr.length; i++) {
				sb.append(key + "[" + i + "]=" + arrStr[i] + ",");
			}

		}
		return sb.toString();
	}

	/**
	 * BasicRequestBC's getString
	 * 
	 * @param key
	 * @return String
	 */
	public String getString(String key) {
		Object tmp = this.getObject(key);
		return (tmp == null) ? "" : ((String) tmp);
	}

	/**
	 * PrdRequestEvent's getInPutString
	 * 
	 * @param key
	 * @return String
	 */
	public String getInPutString(String key) {
		Object tmp = this.getObject(key);
		return (tmp == null) ? "" : ((String) tmp);
	}

	/**
	 * BasicRequestBC's getInt
	 * 
	 * @param key
	 * @return int
	 */
	public int getInt(String key) {
		String tmp = this.getString(key);
		return ("".equals(tmp)) ? 0 : Integer.parseInt(tmp);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("\n Request param set =[");
		for (int i = 0; i < keyList.size(); i++) {
			sb.append(getObjectString((String) keyList.get(i)));

		}
		sb.append(" ]");
		return sb.toString();

	}

	/**
	 * PrdRequestEvent's getLog void
	 */
	public void getLog() {
		// log.debug("\n" + this.toString());
	}

	/**
	 * @return Returns the keyList.
	 */
	public ArrayList<String> getKeyList() {
		return keyList;
	}

	/**
	 * @return Returns the valueLengthMap.
	 */
	public HashMap<String, String> getValueLengthMap() {
		return valueLengthMap;
	}
}
