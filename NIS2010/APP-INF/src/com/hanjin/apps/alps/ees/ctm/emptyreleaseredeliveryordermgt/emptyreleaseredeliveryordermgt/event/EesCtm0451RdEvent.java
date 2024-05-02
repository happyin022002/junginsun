/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EesCtm0451RdEvent.java
*@FileTitle : Release/Re-delivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.23 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0451RD 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0451RDHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang Soo
 * @see EES_CTM_0451HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0451RdEvent extends EventSupport {

	private static final long serialVersionUID = 1L;


	public String stkFaxSndNo = null;

	public EesCtm0451RdEvent(){}

	public void setStkFaxSndNo(String stkFaxSndNo) {
		this.stkFaxSndNo = stkFaxSndNo;
	}

	public String getStkFaxSndNo() {
		return stkFaxSndNo;
	}

}