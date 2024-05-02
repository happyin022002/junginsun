/*=========================================================
*Copyright(c) 2006~2010 CyberLogitec
*@FileName : CommonCodeEvent.java
*@FileTitle : 3자구상 유형등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-19
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2006-10-09 Youngchang_Kim 1.0 최초 생성
* 2009-11-19 Sun, CHOI      1.1 Renewal Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EsdTpb001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdTpb001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Youngchang_Kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CommonCodeEvent extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public CommonCodeEvent(){}

	/**
	 * 
	 */
	public String getEventName() {
		return "TPBCommonCodeEvent";
	}

	/**
	 * 
	 */
	public String toString() {
		return "TPBCommonCodeEvent";
	}

}
