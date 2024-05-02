/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageBC.java
*@FileTitle : Commodity Group Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimjin
 * @see EsdTrs0075EventResponse 참조
 * @since J2EE 1.6
 */
public interface CommodityGroupCodeManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCommodityGroupCodeManageList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMdm_commodity(Event e) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchrep_commodity(Event e) throws EventException;	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_commodity(Event e) throws EventException;		

	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_vndr(Event e) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_vndr_commodity(Event e) throws EventException;	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_sub_commodity(Event e) throws EventException;		
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi_vndr_commodity(Event e) throws EventException;	
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi_delete_commodity(Event e) throws EventException;		
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi_part_commodity(Event e) throws EventException;			

}