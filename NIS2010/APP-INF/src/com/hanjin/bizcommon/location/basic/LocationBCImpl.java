/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LocationBCImpl.java
*@FileTitle : Location조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-03
*@LastModifier : HyungChoonRoh
*@LastVersion : 1.0
* 2006-08-03 HyungChoonRoh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.location.basic;

import java.util.List;

import com.hanjin.bizcommon.location.integration.LocationDBDAO;
import com.hanjin.bizcommon.location.vo.SearchLocationDetailVO;
import com.hanjin.bizcommon.location.vo.SearchLocationListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ENIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author HyungChoonRoh
 * @see COM_ENS_051EventResponse,LocationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class LocationBCImpl   extends BasicCommandSupport implements LocationBC {

    // Database Access Object
    private transient LocationDBDAO dbDao=null;

    /**
     * LocationBCImpl 객체 생성<br>
     * LocationDBDAO를 생성한다.<br>
     */
    public LocationBCImpl(){
        dbDao = new LocationDBDAO();
    }

    /**
     * 조회 이벤트 처리<br>
     * Location화면에 대한 조회 이벤트 처리<br>
     * @param String locCd
     * @param String locNm
     * @param String unLocIndCd
     * @param String cntCd
     * @param String locEqOfc
     * @param String select
     * @param String rccCd
     * @param String lccCd
     * @param String locState
     * @param int iPage
     * @return List<SearchLocationListVO>
     * @throws DAOException
     */
    public List<SearchLocationListVO> searchLocationList(String locCd, String locNm, String unLocIndCd, String cntCd, String locEqOfc, String select, String rccCd, String lccCd, String locState, int iPage) throws EventException {
        try {
			return dbDao.searchLocationList(locCd, locNm, unLocIndCd, cntCd, locEqOfc, select, rccCd, lccCd, locState, iPage);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * Location화면에 대한 조회 이벤트 처리<br>
     * 
     * @param locCd
     * @return List<SearchLocationDetailVO>
     * @exception EventException
     */
    public List<SearchLocationDetailVO> searchLocationDetail(String locCd) throws EventException {
        try {
			return dbDao.searchLocationDetail(locCd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    }
    
}