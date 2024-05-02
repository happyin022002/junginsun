/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFmsFNS008R003Event.java
*@FileTitle : FNS008-R003 Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.12 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import org.apache.xmlbeans.XmlObject;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS008-R003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Se-Yeong
 * @see
 * @since J2EE 1.4
 */

public class EsmFmsFNS012R002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public XmlObject xmlObject = null;

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
}