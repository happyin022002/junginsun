/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CnlBKGCntrmanageBC.java
*@FileTitle : Cancelled BKG's Cntr Tracing
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 ���� ��
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0004Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0005Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0005EventResponse;
import com.hanjin.apps.alps.esd.eas.transportmanage.integration.CnlBKGCntrmanageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * CnlBKGCntrmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class CnlBKGCntrmanageBCImpl extends BasicCommandSupport implements CnlBKGCntrmanageBC {

    // Database Access Object
    private transient CnlBKGCntrmanageDBDAO dbDao=null;

    /**
     * CnlBKGCntrmanageBCImpl<br>
     * CnlBKGCntrmanageDBDAO<br>
     */
    public CnlBKGCntrmanageBCImpl(){
        dbDao = new CnlBKGCntrmanageDBDAO();
    }
    
    /**
	 * searchCnlBKGCntrList
     * @param e
     * @return
     * @throws EventException
     */
    public EventResponse searchCnlBKGCntrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0005Event event  = (EsdEas0005Event)e ;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null; 

        try {
        	rowSet = dbDao.searchCnlBKGCntrList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }

    /**
	 * searchCnlBKGCntrDtlList
     * @param e
     * @return
     * @throws EventException
     */
   /* public EventResponse searchCnlBKGCntrDtlList(Event e) throws EventException {
    	ESD_EAS_005Event event  = (ESD_EAS_005Event)e ;
    	DBRowSet         rowSet = new DBRowSet();
       
        try {
        		rowSet = dbDao.searchCnlBKGCntrDtlList(event.getDataSet());
        		
            return new ESD_EAS_005EventResponse(rowSet,"SUCCESS");
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }*/

}
