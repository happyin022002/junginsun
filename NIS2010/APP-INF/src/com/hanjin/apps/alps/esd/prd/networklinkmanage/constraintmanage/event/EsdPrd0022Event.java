/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdPrd0022Event.java
*@FileTitle : Node Constraint Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-10-16 kimyoungchul
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_PRD_022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0022Event extends EventSupport {

	/**
	 * EsdPrd0022Event.java's Construct
	 */
	public EsdPrd0022Event(){}

	/**
	 * EsdPrd0022Event's getEventName
	 * @return
	 */
	@Override
	public String getEventName() {
		return "ESD_PRD_022Event";
	}

	/**
	 * EsdPrd0022Event's toString
	 * @return
	 */
	@Override
	public String toString() {
		return "ESD_PRD_022Event";
	}


	/**
	 * EsdPrd0022Event's getObject
	 * @param key
	 * @return Object
	 */
	public Object getObject(String key){
		return (key==null) ? null : this.getAttribute(key);
	}

	/**
	 * EsdPrd0022Event's getString
	 * @param key
	 * @return String
	 */
	public String getString(String key){
		Object tmp = this.getObject(key);
		return (tmp==null) ? "" : (String)tmp;
	}
	
	/**
	 * EsdPrd0022Event's getInt
	 * @param key
	 * @return int
	 */
	public int getInt(String key){
		String tmp = this.getString(key);
		return ("".equals(tmp)) ? 0 : Integer.parseInt(tmp);
	}
	
	/**
	 * EsdPrd0022Event's putValue
	 * @param key
	 * @param value void
	 */
	public void putValue(String key, Object value){
		if(key==null) return;
		this.setAttribute(key, value);
	}
}
