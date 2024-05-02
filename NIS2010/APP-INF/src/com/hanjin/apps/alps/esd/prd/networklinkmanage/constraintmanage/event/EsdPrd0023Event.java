/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0023Event.java
 *@FileTitle : Link Constraint Manage
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
 * ESD_PRD_023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0023Event extends EventSupport{

	/**
	 * 
	 */
	public EsdPrd0023Event(){
	}

	/**
	 * EsdPrd0023Event's getEventName
	 * @return
	 */
	@Override
	public String getEventName(){
		return "ESD_PRD_023Event";
	}

	/**
	 * EsdPrd0023Event's toString
	 * @return
	 */
	@Override
	public String toString(){
		return "ESD_PRD_023Event";
	}

	/**
	 * EsdPrd0023Event's getObject
	 * @param key
	 * @return Object
	 */
	public Object getObject(String key){
		return (key == null) ? null : this.getAttribute(key);
	}

	/**
	 * EsdPrd0023Event's getString
	 * @param key
	 * @return String
	 */
	public String getString(String key){
		Object tmp = this.getObject(key);
		return (tmp == null) ? "" : (String) tmp;
	}

	/**
	 * EsdPrd0023Event's getInt
	 * @param key
	 * @return int
	 */
	public int getInt(String key){
		String tmp = this.getString(key);
		return ("".equals(tmp)) ? 0 : Integer.parseInt(tmp);
	}

	/**
	 * EsdPrd0023Event's putValue
	 * @param key
	 * @param value void
	 */
	public void putValue(String key, Object value){
		if(key == null){
			return;
		}
		this.setAttribute(key, value);
	}
}
