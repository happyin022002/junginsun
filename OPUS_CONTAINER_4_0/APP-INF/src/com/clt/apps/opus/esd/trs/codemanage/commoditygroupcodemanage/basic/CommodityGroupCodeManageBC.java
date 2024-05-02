/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageBC.java
*@FileTitle : Commodity Group Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author 
 * @see EsdTrs0075EventResponse 
 * @since J2EE 1.6
 */
@SuppressWarnings("unused")
public interface CommodityGroupCodeManageBC  {

	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCommodityGroupCodeManageList(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMdm_commodity(Event e) throws EventException;
	
	
	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchrep_commodity(Event e) throws EventException;	
	
	
	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_commodity(Event e) throws EventException;		

	
	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_vndr(Event e) throws EventException;
	
	
	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_vndr_commodity(Event e) throws EventException;	
	
	
	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_sub_commodity(Event e) throws EventException;		
	
	/**
	 * Multi-event processing<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi_vndr_commodity(Event e) throws EventException;	
	
	
	/**
	 * Multi-event processing<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi_delete_commodity(Event e) throws EventException;		
	
	
	/**
	 * Multi-event processing<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi_part_commodity(Event e) throws EventException;			

}