/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Cms0070001Event.java
*@FileTitle : Cms0070001Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.24 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * CMS0070001(Customer Sales Rep) 에 대한 Event 처리<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kang dong yun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class Cms0070001Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	public String massage = null;

	public String getMessage() {
		return massage;
	}

	public void setMessage(String massage) {
		this.massage = massage;
	}
}
