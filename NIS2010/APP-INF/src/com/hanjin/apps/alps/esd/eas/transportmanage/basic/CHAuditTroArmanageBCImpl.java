/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CHAuditTroArmanageBCImpl.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0004Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0004EventResponse;
import com.hanjin.apps.alps.esd.eas.transportmanage.integration.CHAuditTroArmanageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * CHAuditTroArmanageBCImpl ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class CHAuditTroArmanageBCImpl extends BasicCommandSupport implements CHAuditTroArmanageBC {

    // Database Access Object
    private transient CHAuditTroArmanageDBDAO dbDao=null;

    /**
     * ExceptionManageBCImpl 객체 생성<br>
     * ExceptionManageDBDAO를 생성한다.<br>
     */
    public CHAuditTroArmanageBCImpl(){
        dbDao = new CHAuditTroArmanageDBDAO();
    }
    
	/**
	 * searchChAuditBKGList 기본 조회 기능<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
    public EventResponse searchChAuditList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event  = (EsdEas0004Event)e ;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
       
        try {
        	rowSet = dbDao.searchChAuditList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * searchChAuditBKGList BKG단위 조회 기능<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
    public EventResponse searchChAuditBKGList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event  = (EsdEas0004Event)e ;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
       
        try {
        	rowSet = dbDao.searchChAuditBKGList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }
    
	/**
	 * searchSubOfficeList 하위 Office 조회 기능<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */    
	public EventResponse searchSubOfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event  = (EsdEas0004Event)e ;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchSubOfficeList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
    
}
