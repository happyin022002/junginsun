/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFmsFNS008R003Event.java
*@FileTitle : VSL_PORT_SKD_SYNC Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.10.28 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import org.apache.xmlbeans.XmlObject;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Yoon-Tae
 * @see
 * @since J2EE 1.4
 */

public class EsmFmsVslPortSkdSyncEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public XmlObject xmlObject = null;

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
}