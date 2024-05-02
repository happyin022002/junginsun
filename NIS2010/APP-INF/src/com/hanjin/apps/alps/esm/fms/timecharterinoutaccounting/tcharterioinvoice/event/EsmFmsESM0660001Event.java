/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFmsESM0660001Event.java
*@FileTitle : ESM066-0001 Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.25
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.25 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import org.apache.xmlbeans.XmlObject;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM066-0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see
 * @since J2EE 1.4
 */

public class EsmFmsESM0660001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public XmlObject xmlObject = null;

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
}