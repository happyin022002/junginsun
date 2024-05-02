/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi006_0001Event.java
*@FileTitle : BKG_EDI_SUB_LNK_MSG 연동
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.10.06 이일민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EDI006_0001(Customer Sales Rep) 에 대한 Event 처리<br>
 * EDI006_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Ilmin Lee
 * @see OutboundBLMgtSCEvent 참조
 * @since J2EE 1.6
 */
public class Edi0060001Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	public String massage = null;
	public String getMessage() { return massage; }
	public void setMessage(String massage) { this.massage = massage; }
}
