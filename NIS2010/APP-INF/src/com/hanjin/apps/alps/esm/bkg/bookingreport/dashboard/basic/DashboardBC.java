/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : DashboardBC.java
 *@FileTitle : Dashboard
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.17
 *@LastModifier : Poong-yeon Cho
 *@LastVersion : 1.0
 * 2009.06.01 Poong-yeon Cho
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.basic;

import java.util.List;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1201Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1211Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1212Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportColumnVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportFormVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportSettingVO;

/**
 * NIS2010-Bookingreport Business Logic Command Interface<br>
 * - NIS2010-Bookingreport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Poong-yeon Cho
 * @see Esm_bkg_1201EventResponse 참조
 * @since J2EE 1.6
 */
 
public interface DashboardBC {

    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchDashboardRptByBkgOfc(EsmBkg1201Event event) throws EventException;
    
    /**
     * ESM_BKG_1202 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchDashboardRptByCust(EsmBkg1201Event event) throws EventException;
    
    /**
     * 유효한 Batch data의 시작일자를 조회한다.<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchBatchStartDate(EsmBkg1201Event event) throws EventException;
    
    
    /**
     * ESM_BKG_1213 조회EVNET 처리<br>
     * @return List<DashboardReportColumnVO>
     * @exception EventException
     */
    public List<DashboardReportColumnVO> searchDashboardReportColumn() throws EventException;

    /**
     * ESM_BKG_1212 조회EVNET 처리<br>
     * @param String usr_id
     * @return List<DashboardReportFormVO>
     * @exception EventException
     */
	public List<DashboardReportFormVO> searchDashboardReportForm(String usr_id) throws EventException;
    
    /**
     * BKG OFC SUB정보를 조회합니다.<br>
     * @param EsmBkg1201Event event
     * @return String
     * @exception EventException
     */
    public String searchBkgSubOffice(EsmBkg1201Event event) throws EventException;
    
    /**
     * Template Report 의 Item 조회<br>
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchDashboardTemplateItem(EsmBkg1201Event event) throws EventException;
    
    /**
     * Item List 조회<br>
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchDashboardItemList(EsmBkg1201Event event) throws EventException;

    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForAllBkgList(EsmBkg1201Event event) throws EventException;
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForGeneral(EsmBkg1201Event event) throws EventException;
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForTPB(EsmBkg1201Event event) throws EventException;

    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForNotUpdateCntr(EsmBkg1201Event event) throws EventException;
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForRDN(EsmBkg1201Event event) throws EventException;

    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForUshold(EsmBkg1201Event event) throws EventException;
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForDemDet(EsmBkg1201Event event) throws EventException;
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForSpclAppr(EsmBkg1201Event event) throws EventException;
    
    /**
     * Template Report 의 Item 저장<br>
     * @param DashboardReportFormVO[] reportFormVOs
     * @param String usr_id
     * @return String 
     * @exception EventException
     */
	public String manageDashboardReportForm(DashboardReportFormVO[] reportFormVOs, String usr_id) throws EventException;

	/**
     * ESM_BKG_1212 조회EVNET 처리<br>
     * @param EsmBkg1212Event event
     * @param String usr_id
     * @return List<DashboardReportColumnVO>
     * @exception EventException
     */
	public List<DashboardReportColumnVO> searchStoredDashboardReportColumn(EsmBkg1212Event event, String usr_id) throws EventException;

	/**
     * Template Report column 의 Item 저장<br>
     * @param DashboardReportColumnVO[] reportColumnVOs
     * @param  String usr_id
     * @param  String rpt_fom_no
     * @exception EventException
     */
	public void manageDashboardReportColumn(DashboardReportColumnVO[] reportColumnVOs, String usr_id, String rpt_fom_no) throws EventException;

	/**
     * ESM_BKG_1211 조회EVNET 처리<br>
     * @param EsmBkg1211Event event
     * @return DBRowSet
     * @exception EventException
     */
	public DBRowSet searchDashboardRptFormByCust(EsmBkg1211Event event) throws EventException;
	/**
     * ESM_BKG_1211 저장 EVNET 처리<br>
     * @param DashboardReportSettingVO[] reportSettingVOs
     * @param String usr_id
     * @exception EventException
     */
	public void manageDashboardReportSetting(
			DashboardReportSettingVO[] reportSettingVOs, String usr_id) throws EventException;
    /**
     * ESM_BKG_1211 저장 EVNET 처리<br>
     * @param DashboardReportSettingVO[] reportSettingVOs
     * @param String usr_id
     * @exception EventException
     */
    public void removeDashboardReportSetting(
            DashboardReportSettingVO[] reportSettingVOs, String usr_id) throws EventException;
	/**
     * ESM_BKG_1212 조회 EVNET 처리<br>
     * @param EsmBkg1212Event event
	 * @param String usr_id 
     * @return List<DashboardReportFormVO>
     * @exception EventException
     */
	public List<DashboardReportFormVO> searchBeforeApply(EsmBkg1212Event event, String usr_id) throws EventException;

}