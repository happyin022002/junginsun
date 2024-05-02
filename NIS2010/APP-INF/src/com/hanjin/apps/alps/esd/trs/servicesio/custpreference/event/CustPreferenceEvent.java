/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustPreferenceEvent.java
*@FileTitle : jms bc 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0 
* 2006-11-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custpreference.event;

import java.util.Collection;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsCustPrfVO;

/**
 * InterfaceTest에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - InterfaceTestHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim, Jung-jae
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CustPreferenceEvent extends EventSupport{
	/** business mode flag Value */
	private String bizModeFlag = ""; 
	/** TrsCustPrfVO Table  Value Object */
	private TrsCustPrfVO trsCustPrfVO = null;
	/** TrsCustPrfVOs Multi Action을 위한 Collection */
	private Collection trsCustPrfVOs = null;
	
	/**
	 * Constructor
	 */
	public CustPreferenceEvent(){
		
	}
	
	/**
	 * @param bizModeFlag String
	 * @param collection Collection Value
	 */
	public CustPreferenceEvent(String bizModeFlag, Collection collection) {
		
		if ( bizModeFlag==null ) bizModeFlag = "";
		this.bizModeFlag = bizModeFlag; 
		
		if ( bizModeFlag.equals("TrsCustPrfVO")){
			this.trsCustPrfVOs = collection;
		}
    }
	
	/**
	 * @return String bizModeFlag
	 */
	public String getBiz_mode_flag(){
		return bizModeFlag;
	}
	
	//=== TES => TPB ===
	/**
	 * @return trsCustPrfVO
	 */
	public TrsCustPrfVO getTrsCustPrfVO(){
		return trsCustPrfVO;
	}
	
	/**
	 * @return Collection
	 */
	public Collection getTrsCustPrfVOS(){
		return trsCustPrfVOs;
	}
	
	/**
	 * @return Collection
	 */
	public String getEventName() {
		return "CustPreferenceEvent";
	}

	/**
	 * @return Collection
	 */
	public String toString() {
		return "CustPreferenceEvent";
	}

	private XmlObject xmlObject = null;
		
	/**
	 * CustPreferenceEvent's getXmlObject
	 * @return XmlObject
	 */
	public XmlObject getXmlObject() {
		return xmlObject;
	}

	/**
	 * CustPreferenceEvent's setXmlObject
	 * @param xmlObject void
	 */
	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}	
}
