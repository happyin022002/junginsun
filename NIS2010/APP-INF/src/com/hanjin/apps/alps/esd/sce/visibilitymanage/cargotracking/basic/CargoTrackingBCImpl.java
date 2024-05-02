/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CargoTrackingBCImpl.java
*@FileTitle : RailTransit Report BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-18
*@LastModifier : 전병석
*@LastVersion : 1.5
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
* 2009-09-18
* 1.5 버전 커밋
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.basic;

import java.sql.SQLException;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.integraion.CargoTrackingDBDAO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.vo.CargoTrackingOptionsVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SCEM Commission Business Logic Basic Command implementation<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Se-Hoon PARK
 * @see EsdSce022EventResponse,ManageUserBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CargoTrackingBCImpl extends BasicCommandSupport implements CargoTrackingBC {

    // Database Access Object
    private transient CargoTrackingDBDAO dbDao=null;


    /**
     * CargoTrackingBCImpl 객체 생성<br>
     * CargoTrackingDBDAO를 생성한다.<br>
     */
    public CargoTrackingBCImpl(){
        dbDao = new CargoTrackingDBDAO();
    }
    
    
    /**
     * US Cargo Tacking
     * @param  CargoTrackingOptionsVO ctopt
     * @return EventResponse
     * @throws EventException
     */
    
    public EventResponse searchUSCargoTrackingList(CargoTrackingOptionsVO ctopt) throws EventException {
        log.debug("2:searchUSCargoTrackingList 함수 진입");
        DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int cnt = 0;
        try {
        	cnt    = dbDao.searchUSCargoTrackingCount(ctopt);            
        	if(cnt > 0){
        		rowSet = dbDao.searchUSCargoTrackingList(ctopt);
        		rowSet.setMaxRows(cnt);	
        	}
            GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (SQLException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    }    
    /**
     * Customer 이름을 가져온다.<br>
     * @param CargoTrackingOptionsVO ctopt
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse searchCustomerName(CargoTrackingOptionsVO ctopt) throws EventException {
        log.debug("searchCustomerName is running");
        DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        try {
             rowSet = dbDao.searchCustomerName(ctopt);
             GeneralEventResponse eventResponse = new GeneralEventResponse();
// 			 Map<String,String> etcMap = new HashMap();
 			 eventResponse.setRsVo(rowSet);
			 
 			 return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    }
}