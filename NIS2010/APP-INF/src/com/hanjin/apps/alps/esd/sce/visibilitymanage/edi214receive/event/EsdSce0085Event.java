/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsdSce0085Event.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : Y
*@LastVersion : 1.0
* 2008-08-01 Y
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.event;

import org.apache.xmlbeans.XmlObject;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EDI_214_MSG를 위한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yjlee
 * @see EsdSce0085EventResponse 참조
 * @since J2EE 1.4
 */
public class EsdSce0085Event extends EventSupport{
	
	private static final long serialVersionUID = 1L;
	public XmlObject xmlObject = null;
	public String str = null;

	public EsdSce0085Event(){}
	
	public String getEventName(){
		return "EsdSce0085Event";
	}
	public String toString(){
		return "EsdSce0085Event";
	}	
	public String getString(){
		return str;
	}	
	public void setString(String str){
		this.str = str;
	}

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}	
	
}

