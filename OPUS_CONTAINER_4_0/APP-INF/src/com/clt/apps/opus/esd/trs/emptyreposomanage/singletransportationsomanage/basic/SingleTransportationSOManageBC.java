/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SingleTransportationSOManageBC.java
 *@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.basic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * An interface to the business logic for emptyreposomanage<br>
 * 
 * @author
 * @see Refer to EsdTrs0012EventResponse
 * @since
 */
public interface SingleTransportationSOManageBC {

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSingleTransportationSOManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse search01SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse search02SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_012 event process<br>
	 * 
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modifySingleTransportationSOManage(String soffice_cd, Event e) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_012 event process<br>
	 * 
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modify01SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_0012 event process<br>
	 * 
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modify02SingleTransportationSOManage(String soffice_cd, Event e) throws EventException;
	
	/**
	 * delete event process<br>
	 * ESD_TRS_012 event process<br>
	 * 
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeSingleTransportationSOManage(String soffice_cd, Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search03SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search04SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search05SingleTransportationSOManage(String soffice_cd, Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e EsdTrs0012Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchMultiSingleTransportationSo(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e EsdTrs0012Event
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap<String, String> searchEmptyRepoCombineSeq(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param chk_param
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchVerifyECC(Map<String, Object> chk_param) throws EventException;

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEmptyRepoSeq() throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_012 multi event process<br>
	 * 
	 * @param insModels Collection<SingleTransportationVO>
	 * @param param Map<String, Object>
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSingleTransportationSOManage5(Collection<SingleTransportationVO> insModels, Map<String, Object> param) throws EventException;

}