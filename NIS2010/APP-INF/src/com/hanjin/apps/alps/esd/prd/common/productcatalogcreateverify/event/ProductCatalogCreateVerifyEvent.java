/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ProductCatalogCreateVerifyEvent.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-07-09
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2008-07-09 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jungsunyoung
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ProductCatalogCreateVerifyEvent extends EventSupport{

	/**
	 *  생성자
	 */
	public ProductCatalogCreateVerifyEvent(){
	}

	/**
	 * PrdCommonEvent's getEventName
	 * @return
	 */
	@Override
	public String getEventName(){
		return "ProductCatalogCreateVerifyEvent";
	}

	/**
	 * ProductCatalogCreateVerifyEvent's toString
	 * @return
	 */
	@Override
	public String toString(){
		return "ProductCatalogCreateVerifyEvent";
	}

	/***************************************
	 * 
	 * *************************************/
	//private HashMap map = new HashMap();
	/**
	 * ProductCatalogCreateVerifyEvent's getObject
	 * @param key
	 * @return Object
	 */
	public Object getObject(String key){
		return (key == null) ? null : this.getAttribute(key);
	}

	/**
	 * ProductCatalogCreateVerifyEvent's getString
	 * @param key
	 * @return String
	 */
	public String getString(String key){
		Object tmp = this.getObject(key);
		return (tmp == null) ? "" : (String) tmp;
	}

	/**
	 * ProductCatalogCreateVerifyEvent's getInt
	 * @param key
	 * @return int
	 */
	public int getInt(String key){
		String tmp = this.getString(key);
		return ("".equals(tmp)) ? 0 : Integer.parseInt(tmp);
	}

	/**
	 * ProductCatalogCreateVerifyEvent's putValue
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
