/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SOInquiryBC.java
 *@FileTitle : SO Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.soinquiry.soinquiry.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * 
 * @author
 * @see EsdTrs0019EventResponse
 * @since J2EE 1.4
 */
public interface SOInquiryBC {

	/**
	 * Inquiry event process<br>
	 * SOInquiry - Inquiry event process<br>
	 * 
	 * @param e
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSOInquiry(Event e, String soffice_cd) throws EventException;

	/**
	 * Inquiry event process<br>
	 * SOInquiry - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_office(Event e) throws EventException;

	/**
	 * 
	 * USA404EDIStatusInquiry - Down Excel<br>
	 * 
	 * @param e
	 * @return String[]
	 * @exception
	 */
	public String[] getTitle(Event e);

	/**
	 * 
	 * USA404EDIStatusInquiry - Down Excel <br>
	 * 
	 * @param e
	 * @return String[]
	 * @exception
	 */
	public String[] getColumns(Event e);
}