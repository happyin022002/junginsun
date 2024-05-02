/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultipleInquiryBC.java
*@FileTitle : Multiple Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-13 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.multipleinquiry.basic;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see EsdTrs0906EventResponse 참조
 * @since J2EE 1.4
 */
public interface MultipleInquiryBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * MultipleInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response ESD_TRS_906EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMultipleInquiryList() throws EventException;




}