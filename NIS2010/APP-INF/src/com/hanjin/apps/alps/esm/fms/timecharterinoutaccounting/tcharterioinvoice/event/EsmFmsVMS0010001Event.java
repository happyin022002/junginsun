/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFmsVMS0010001Event.java
*@FileTitle : VMS001-0001 Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.09 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import org.apache.xmlbeans.XmlObject;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VMS001-0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see
 * @since J2EE 1.4
 */

public class EsmFmsVMS0010001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public XmlObject xmlObject = null;

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
}