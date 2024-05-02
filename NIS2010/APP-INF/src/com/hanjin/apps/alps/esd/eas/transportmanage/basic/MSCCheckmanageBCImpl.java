/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MSCCheckmanageBCImpl.java
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

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0006Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.integration.MSCCheckmanageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * MSCCheckmanageBCImpl ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class MSCCheckmanageBCImpl extends BasicCommandSupport implements MSCCheckmanageBC {

    // Database Access Object
    private transient MSCCheckmanageDBDAO dbDao=null;

    /**
     * MSCCheckmanageBCImpl 객체 생성<br>
     * MSCCheckmanageDBDAO를 생성한다.<br>
     */
    public MSCCheckmanageBCImpl(){
        dbDao = new MSCCheckmanageDBDAO();
    }
    
	/**
	 * MSC Check Search List.
	 * @param e
	 * @return
	 * @throws EventException
	 */
    public EventResponse searchMSCList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
    	EsdEas0006Event event  = (EsdEas0006Event)e ;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
       
		try {
        	rowSet = dbDao.searchMSCList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * 유럽지역의 TRO Office를 찾아오는 메소드. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSubOfcList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
    	EsdEas0006Event event  = (EsdEas0006Event)e ;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchSubOfcList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
    
}
