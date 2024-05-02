/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : MenuAccessHTMLAction.java
 * @FileTitle : 입력 Parameter 처리
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.12.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 2013.12.17 1.0 Sang-Hyun Kim Creation
 */
package com.hanjin.apps.alps.common.mobile.hansap.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * 입력 Parameter 처리
 * @author Sang-Hyun Kim
 * @since J2EE 1.6
 * @see
 */
public class MenuAccessHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing
	 * HttpRequst의 정보를 MenuAccessEvent로 파싱하여 request에 셋팅
	 * @param request
	 * @return Event
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		return null;
	}
}
