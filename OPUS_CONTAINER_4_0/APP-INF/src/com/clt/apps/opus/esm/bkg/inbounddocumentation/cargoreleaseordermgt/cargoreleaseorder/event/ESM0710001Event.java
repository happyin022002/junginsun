/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiFms0072Event.java
*@FileTitle : Manhour Item Registration & Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import org.apache.xmlbeans.XmlObject;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS056-0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see
 * @since J2EE 1.4
 */

public class ESM0710001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public XmlObject xmlObject = null;

	/**
	 * @param string
	 */
	public ESM0710001Event(String string) {
		// TODO Auto-generated constructor stub
	}

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
}