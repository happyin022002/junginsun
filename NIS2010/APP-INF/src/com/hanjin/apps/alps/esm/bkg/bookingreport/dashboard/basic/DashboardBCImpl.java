/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : DashboardBCImpl.java
 *@FileTitle : Dashboard
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.17
 *@LastModifier : Poong-yeon Cho
 *@LastVersion : 1.0
 * 2013.10.17 Poong-yeon Cho
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1201Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1211Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1212Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration.DashboardDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportColumnVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportFormVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportSettingVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-BookingReport Business Logic Basic Command implementation<br>
 * - NIS2010-BookingReport에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Poong-yeon Cho
 * @see ESM_BKG_1201Event,DashboardBC 각 DAO 클래스 참조
 * @since J2EE 1.6    
 */  
public class DashboardBCImpl extends BasicCommandSupport implements DashboardBC {
 
    // Database Access Object
    private transient DashboardDBDAO dbDao = null;
 
    /**
     * PerformanceReportBCImpl 객체 생성<br>
     * PerformanceReportDBDAO를 생성한다.<br>
     */
    public DashboardBCImpl() {
        dbDao = new DashboardDBDAO();
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchDashboardRptByBkgOfc(EsmBkg1201Event event) throws EventException {
        try {
            log.info("aa");
            return dbDao.searchDashboardRptByBkgOfc(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_1202 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchDashboardRptByCust(EsmBkg1201Event event) throws EventException {
        try {
            return dbDao.searchDashboardRptByCust(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 유효한 Batch data의 시작일자를 조회한다.<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchBatchStartDate(EsmBkg1201Event event) throws EventException {
        try {
            return dbDao.searchBatchStartDate(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_1213 조회EVNET 처리<br>
     * @return List<DashboardReportColumnVO>
     * @exception EventException
     */
	@Override
	public List<DashboardReportColumnVO> searchDashboardReportColumn()
			throws EventException {
		try {
            return dbDao.searchDashboardReportColumn();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
	}

	/**
     * ESM_BKG_1212 조회EVNET 처리<br>
     * @param String usr_id
     * @return List<DashboardReportFormVO>
     * @exception EventException
     */
	@Override
	public List<DashboardReportFormVO> searchDashboardReportForm(String usr_id) throws EventException {
		try {
            return dbDao.searchDashboardReportForm(usr_id);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
	}

	
    /**
     * BKG OFC SUB정보를 조회합니다.<br>
     * @param EsmBkg1201Event event
     * @return String
     * @exception EventException
     */
    public String searchBkgSubOffice(EsmBkg1201Event event) throws EventException {
        try {
            return dbDao.searchBkgSubOffice(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * Template Report 의 Item 조회<br>
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchDashboardTemplateItem(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDashboardTemplateItem(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * Item List 조회<br>
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchDashboardItemList(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDashboardItemList(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }    

    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForAllBkgList(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDetailForAllBkgList(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForGeneral(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDetailForGeneral(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForTPB(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDetailForTPB(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForNotUpdateCntr(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDetailForNotUpdateCntr(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForRDN(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDetailForRDN(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForUshold(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDetailForUshold(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForDemDet(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDetailForDemDet(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForSpclAppr(EsmBkg1201Event event) throws EventException{
        try {
            return dbDao.searchDetailForSpclAppr(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    
    /**
     * ESM_BKG_1212 저장EVNET 처리<br>
     * @param DashboardReportFormVO[] reportFormVOs
     * @param String usr_id
     * @return String 
     * @exception EventException
     */
	@Override
	public String manageDashboardReportForm(DashboardReportFormVO[] reportFormVOs,
			String usr_id) throws EventException {
		String report_num = "";
		try {
			
			
			List<DashboardReportFormVO> insertVoList = new ArrayList<DashboardReportFormVO>();
			List<DashboardReportFormVO> deleteVoList = new ArrayList<DashboardReportFormVO>();
			
			for (int i=0; i<reportFormVOs.length; i++) {
				if ( reportFormVOs[i].getIbflag().equals("I")||reportFormVOs[i].getIbflag().equals("U")){
					insertVoList.add(reportFormVOs[i]);
				}else if ( reportFormVOs[i].getIbflag().equals("D")){
					deleteVoList.add(reportFormVOs[i]);
				}
			}
			
			if(insertVoList.size() > 0 ){
				report_num=dbDao.addDashboardReportForm(insertVoList, usr_id);
			}
					
			if(deleteVoList.size() > 0 ){
				dbDao.removeDashboardReportForm(deleteVoList, usr_id);
			}
			
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return report_num;
		
	}
	/**
     * ESM_BKG_1212 조회EVNET 처리<br>
     * 
     * @param EsmBkg1212Event event
     * @param String usr_id
     * @return List<DashboardReportColumnVO> 
     * @exception EventException
     */
	@Override
	public List<DashboardReportColumnVO> searchStoredDashboardReportColumn(EsmBkg1212Event event, String usr_id)  throws EventException{
		try {
            return dbDao.searchStoredDashboardReportColumn(event, usr_id);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	/**
     * ESM_BKG_1212 저장EVNET 처리<br>
     * @param DashboardReportColumnVO[] reportColumnVOs
     * @param String usr_id
     * @param String rpt_fom_no
     * @exception EventException
     */
	@Override
	public void manageDashboardReportColumn(DashboardReportColumnVO[] reportColumnVOs, String usr_id, String rpt_fom_no)
			throws EventException {
try {
			
			
			/*List<DashboardReportColumnVO> insertVoList = new ArrayList<DashboardReportColumnVO>();
			for (int i=0; i<reportColumnVOs.length; i++) {
				insertVoList.add(reportColumnVOs[i]);
			}*/
			
			if(reportColumnVOs.length > 0 ){
				dbDao.removeDashboardReportColumn(reportColumnVOs, usr_id, rpt_fom_no);
				dbDao.addDashboardReportColumn(reportColumnVOs, usr_id, rpt_fom_no);
			}
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
     * ESM_BKG_1211 조회EVNET 처리<br>
     * @param EsmBkg1211Event event
     * @return DBRowSet
     * @exception EventException
     */
	@Override
	public DBRowSet searchDashboardRptFormByCust(EsmBkg1211Event event)
			throws EventException {
		try {
            return dbDao.searchDashboardRptFormByCust(event);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
	}

	/**
     * ESM_BKG_1211 저장EVNET 처리<br>
     * @param DashboardReportSettingVO[] reportSettingVOs
     * @param String usr_id
     * @exception EventException
     */
	@Override
	public void manageDashboardReportSetting(DashboardReportSettingVO[] reportSettingVOs, String usr_id)
			throws EventException {
        String greenToStr = null;
        String yellowFrStr = null;
        String yellowToStr = null;
        String redFrStr = null;
	        
		try {

		    for(int k=0; k < reportSettingVOs.length; k++ ){
		        
		        DashboardReportSettingVO dashboardReportSettingVO = (DashboardReportSettingVO)reportSettingVOs[k];
		        
                greenToStr = dashboardReportSettingVO.getGreenTo();
                yellowFrStr = dashboardReportSettingVO.getYellowFr();
                yellowToStr = dashboardReportSettingVO.getYellowTo();    
                redFrStr = dashboardReportSettingVO.getRedFr();
	            
                dbDao.deleteDashboardReportSetting(dashboardReportSettingVO, usr_id);
                
                if( greenToStr != null && !greenToStr.equals("")
                        && yellowFrStr != null && !yellowFrStr.equals("")
                        && yellowToStr != null && !yellowToStr.equals("")
                        && redFrStr != null && !redFrStr.equals("") ){
                    dbDao.addDashboardReportSetting(dashboardReportSettingVO, usr_id);
                }
		    }
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	   /**
     * ESM_BKG_1211 저장EVNET 처리<br>
     * @param DashboardReportSettingVO[] reportSettingVOs
     * @param String usr_id
     * @exception EventException
     */
    @Override
    public void removeDashboardReportSetting(DashboardReportSettingVO[] reportSettingVOs, String usr_id)
            throws EventException {
        try {
            if(reportSettingVOs.length > 0 ){
                dbDao.removeDashboardReportSetting(reportSettingVOs, usr_id);
            }
            
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	
	/**
     * ESM_BKG_1211 저장EVNET 처리<br>
     * @param EsmBkg1212Event event
     * @param String usr_id
     * @return List<DashboardReportFormVO>
     * @exception EventException
     */
	@Override
	public List<DashboardReportFormVO> searchBeforeApply(EsmBkg1212Event event, String usr_id) throws EventException {
		try {
            return dbDao.searchBeforeApply(event, usr_id);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
}