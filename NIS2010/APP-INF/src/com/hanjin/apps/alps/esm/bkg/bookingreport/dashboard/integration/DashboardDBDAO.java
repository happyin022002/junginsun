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
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1201Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1211Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1212Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportColumnVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportFormVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportSettingVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 DashboardDBDAO <br>
 * - NIS2010-BookingReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Poong-yeon Cho
 * @see DashboardBCImpl 참조
 * @since J2EE 1.6
 */
public class DashboardDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDashboardRptByBkgOfc(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
	        	param.put("s_kind", (String) event.getAttribute("s_kind"));
	            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
	            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
	            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
	            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
	            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
	            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
	            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
	            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
	            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
	            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
	            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));
	            
	            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
	            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
	            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
	            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
	            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
	            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
	            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));

                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDashboardByOfcRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }
	

    /**
     * ESM_BKG_1202 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDashboardRptByCust(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("c_kind", (String) event.getAttribute("c_kind"));
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDashboardByCustRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }
    
    /**
     * 유효한 Batch data의 시작일자를 조회한다.<br>
     * searchBatchStartDate
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchBatchStartDate(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
                param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchBatchStartDateRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }  
    
    
    /**
     * ESM_BKG_1213 조회EVNET 처리<br>
     * 
     * @return List<DashboardReportColumnVO>
     * @exception DAOException
     */
	public List<DashboardReportColumnVO> searchDashboardReportColumn() throws DAOException {
		DBRowSet dbRowset = null;
		List<DashboardReportColumnVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
       

        try {
        	
        		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDashboardReportColumnRSQL(), param, param);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, DashboardReportColumnVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}

	/**
     * ESM_BKG_1212 조회EVNET 처리<br>
     * @param String usr_id
     * @return List<DashboardReportColumnVO>
	 * @exception DAOException 
     */
	public List<DashboardReportFormVO> searchDashboardReportForm(String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<DashboardReportFormVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("usr_id", usr_id);
        try {         
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDashboardReportFormRSQL(), param, param);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, DashboardReportFormVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}
	
	/**
     * BKG OFC SUB정보를 조회합니다.<br>
     * 
     * @param EsmBkg1201Event event
     * @return String
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchBkgSubOffice(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        String output_text="";
        try {

            param.put("bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOsearchBkgSubOfficeRSQL(), param, param);
            if (dbRowset.next()) {
                output_text = dbRowset.getString("B_OFC_CD_SUB");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return output_text;
    }
    
    /**
     * Template Report 의 Item 조회<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDashboardTemplateItem(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            param.put("f_rpt_fom_no", (String) event.getAttribute("f_rpt_fom_no"));

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDashboardTemplateItemRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }
    
    /**
     * Item List 조회<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDashboardItemList(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            param.put("f_rpt_fom_no", (String) event.getAttribute("f_rpt_fom_no"));

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDashboardItemListRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }

    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForAllBkgList(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("s_kind", (String) event.getAttribute("s_kind"));
            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));

            param.put("f_dbd_cre_dt", (String) event.getAttribute("f_dbd_cre_dt"));
            param.put("f_dbd_cre_seq", (String) event.getAttribute("f_dbd_cre_seq"));
            
            param.put("f_dest_cnt_cd", (String) event.getAttribute("f_dest_cnt_cd"));
            param.put("f_irr_tp_cd", (String) event.getAttribute("f_irr_tp_cd"));
            param.put("s_bkg_ofc_cd", (String) event.getAttribute("s_bkg_ofc_cd"));
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDetailForAllBkgListRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForGeneral(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("s_kind", (String) event.getAttribute("s_kind"));
            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));

            param.put("f_dbd_cre_dt", (String) event.getAttribute("f_dbd_cre_dt"));
            param.put("f_dbd_cre_seq", (String) event.getAttribute("f_dbd_cre_seq"));
            
            param.put("f_dest_cnt_cd", (String) event.getAttribute("f_dest_cnt_cd"));
            param.put("f_irr_tp_cd", (String) event.getAttribute("f_irr_tp_cd"));
            param.put("s_bkg_ofc_cd", (String) event.getAttribute("s_bkg_ofc_cd"));
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDetailForGeneralRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForTPB(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("s_kind", (String) event.getAttribute("s_kind"));
            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));

            param.put("f_dbd_cre_dt", (String) event.getAttribute("f_dbd_cre_dt"));
            param.put("f_dbd_cre_seq", (String) event.getAttribute("f_dbd_cre_seq"));
            
            param.put("f_dest_cnt_cd", (String) event.getAttribute("f_dest_cnt_cd"));
            param.put("f_irr_tp_cd", (String) event.getAttribute("f_irr_tp_cd"));
            param.put("s_bkg_ofc_cd", (String) event.getAttribute("s_bkg_ofc_cd"));
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDetailForTPBRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }

    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForNotUpdateCntr(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("s_kind", (String) event.getAttribute("s_kind"));
            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));

            param.put("f_dbd_cre_dt", (String) event.getAttribute("f_dbd_cre_dt"));
            param.put("f_dbd_cre_seq", (String) event.getAttribute("f_dbd_cre_seq"));
            
            param.put("f_dest_cnt_cd", (String) event.getAttribute("f_dest_cnt_cd"));
            param.put("f_irr_tp_cd", (String) event.getAttribute("f_irr_tp_cd"));
            param.put("s_bkg_ofc_cd", (String) event.getAttribute("s_bkg_ofc_cd"));
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDetailForNotUpdateCntrRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForRDN(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("s_kind", (String) event.getAttribute("s_kind"));
            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));

            param.put("f_dbd_cre_dt", (String) event.getAttribute("f_dbd_cre_dt"));
            param.put("f_dbd_cre_seq", (String) event.getAttribute("f_dbd_cre_seq"));
            
            param.put("f_dest_cnt_cd", (String) event.getAttribute("f_dest_cnt_cd"));
            param.put("f_irr_tp_cd", (String) event.getAttribute("f_irr_tp_cd"));
            param.put("s_bkg_ofc_cd", (String) event.getAttribute("s_bkg_ofc_cd"));
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDetailForRDNRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    }   
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForUshold(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("s_kind", (String) event.getAttribute("s_kind"));
            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));

            param.put("f_dbd_cre_dt", (String) event.getAttribute("f_dbd_cre_dt"));
            param.put("f_dbd_cre_seq", (String) event.getAttribute("f_dbd_cre_seq"));
            
            param.put("f_dest_cnt_cd", (String) event.getAttribute("f_dest_cnt_cd"));
            param.put("f_irr_tp_cd", (String) event.getAttribute("f_irr_tp_cd"));
            param.put("s_bkg_ofc_cd", (String) event.getAttribute("s_bkg_ofc_cd"));
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDetailForUsholdRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    } 
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForDemDet(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("s_kind", (String) event.getAttribute("s_kind"));
            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));

            param.put("f_dbd_cre_dt", (String) event.getAttribute("f_dbd_cre_dt"));
            param.put("f_dbd_cre_seq", (String) event.getAttribute("f_dbd_cre_seq"));
            
            param.put("f_dest_cnt_cd", (String) event.getAttribute("f_dest_cnt_cd"));
            param.put("f_irr_tp_cd", (String) event.getAttribute("f_irr_tp_cd"));
            param.put("s_bkg_ofc_cd", (String) event.getAttribute("s_bkg_ofc_cd"));
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDetailForDemDetRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    } 
    
    /**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1201Event event
     * @return DBRowSet
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchDetailForSpclAppr(EsmBkg1201Event event) throws DAOException {
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("combo_cust", (String) event.getAttribute("combo_cust"));
            param.put("f_cust_cd", (String) event.getAttribute("f_cust_cd"));
            param.put("combo_gcust", (String) event.getAttribute("combo_gcust"));
            param.put("f_gcust_cd", (String) event.getAttribute("f_gcust_cd"));
            param.put("combo_ctrt", (String) event.getAttribute("combo_ctrt"));
            param.put("f_ctrt_no", (String) event.getAttribute("f_ctrt_no"));
            
            param.put("s_kind", (String) event.getAttribute("s_kind"));
            param.put("f_rhq_cd", (String) event.getAttribute("f_rhq_cd"));
            param.put("f_bkg_ofc_cd", (String) event.getAttribute("f_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_cd", (String) event.getAttribute("f_sub_bkg_ofc_cd"));
            param.put("f_sub_bkg_ofc_list", (String) event.getAttribute("f_sub_bkg_ofc_list"));
            param.put("f_usr_id", (String) event.getAttribute("f_usr_id"));
            param.put("f_bkg_no", (String) event.getAttribute("f_bkg_no"));
            param.put("f_vvd", (String) event.getAttribute("f_vvd"));
            param.put("f_pol_nod_cd", (String) event.getAttribute("f_pol_nod_cd"));
            param.put("f_pod_nod_cd", (String) event.getAttribute("f_pod_nod_cd"));
            param.put("f_staff_id", (String) event.getAttribute("f_staff_id"));
            param.put("f_rep_id", (String) event.getAttribute("f_rep_id"));

            param.put("f_dbd_cre_dt", (String) event.getAttribute("f_dbd_cre_dt"));
            param.put("f_dbd_cre_seq", (String) event.getAttribute("f_dbd_cre_seq"));
            
            param.put("f_dest_cnt_cd", (String) event.getAttribute("f_dest_cnt_cd"));
            param.put("f_irr_tp_cd", (String) event.getAttribute("f_irr_tp_cd"));
            param.put("s_bkg_ofc_cd", (String) event.getAttribute("s_bkg_ofc_cd"));
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDetailForSpclApprRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
    } 
    
    /**
     * ESM_BKG_1212 조회EVNET 처리<br>
     * @param List<DashboardReportFormVO> insertVoList
	 * @param  String usr_id
     * @return String
     * @exception DAOException
     */
    public String addDashboardReportForm(List<DashboardReportFormVO> insertVoList, String usr_id) throws DAOException {
    	DBRowSet dbRowset = null;
    	String report_num = "";
    	int insCnt[] = new int[insertVoList.size()];
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = new HashMap<String, String>();
			
			log.info("for before");
			
			//  이렇게도 쓸 수 있음 
			for(int k=0; k < insertVoList.size(); k++ ){
				velParam =  ((DashboardReportFormVO)insertVoList.get(k)).getColumnValues();
				velParam.put("usr_id", usr_id);
				
				log.info("\nvelParam:"+velParam);
				log.info("\nISQLTemplate:"+(ISQLTemplate)new DashboardDBDAOAddDashboardReportFormCSQL());
				insCnt[k] = sqlExe.executeUpdate((ISQLTemplate)new DashboardDBDAOAddDashboardReportFormCSQL(), velParam, velParam);
				if(k==0){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDashboardReportFormNumberRSQL(), velParam, velParam);
					if(dbRowset.next()){
						report_num = dbRowset.getString("RPT_FOM_NO");
						
					}
				}
			}
			
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return report_num;
	}

    /**
     * ESM_BKG_1212 조회EVNET 처리<br>
     * @param List<DashboardReportFormVO> deleteVoList
     * @param  String usr_id
     * @exception DAOException
     */
	public void removeDashboardReportForm(List<DashboardReportFormVO> deleteVoList, String usr_id) throws DAOException {
		int insCnt[] = new int[deleteVoList.size()];
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//  이렇게도 쓸 수 있음 
			for(int k=0; k < deleteVoList.size(); k++ ){
				Map<String, String> velParam =  ((DashboardReportFormVO)deleteVoList.get(k)).getColumnValues();
				
				velParam.put("usr_id", usr_id);
				log.info("\nISQLTemplate:"+(ISQLTemplate)new DashboardDBDAORemoveDashboardReportFormDSQL());
				insCnt[k] = sqlExe.executeUpdate((ISQLTemplate)new DashboardDBDAORemoveDashboardReportFormDSQL(), velParam, velParam);
				log.info("\nISQLTemplate:"+(ISQLTemplate)new DashboardDBDAORemoveStoredDashboardReportColumnDSQL());
				sqlExe.executeUpdate((ISQLTemplate)new DashboardDBDAORemoveStoredDashboardReportColumnDSQL(), velParam, velParam);
				
			}
			
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
     * ESM_BKG_1201 조회EVNET 처리<br>
     * 
     * @param EsmBkg1212Event event
     * @param String usr_id
     * @return List<DashboardReportColumnVO>
     * @exception DAOException
     */
	public List<DashboardReportColumnVO> searchStoredDashboardReportColumn(EsmBkg1212Event event, String usr_id)  throws DAOException {
		DBRowSet dbRowset = null;
		List<DashboardReportColumnVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            
            param.put("rpt_fom_nm", (String) event.getAttribute("rpt_fom_nm"));
            param.put("usr_id", usr_id);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchStoredDashboardReportColumnRSQL(), param, param);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DashboardReportColumnVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}

	/**
     * ESM_BKG_1212 삭제 EVNET 처리<br>
     * @param DashboardReportColumnVO[] reportColumnVOs
	 * @param String usr_id
	 * @param String rpt_fom_no
     * @exception DAOException
     */
	public void removeDashboardReportColumn(
			DashboardReportColumnVO[] reportColumnVOs, String usr_id, String rpt_fom_no)  throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam =  new HashMap<String, String>();
			velParam.put("usr_id", usr_id);
			velParam.put("rpt_fom_no", rpt_fom_no);
			log.info("\nISQLTemplate:"+(ISQLTemplate)new DashboardDBDAORemoveStoredDashboardReportColumnDSQL());
			sqlExe.executeUpdate((ISQLTemplate)new DashboardDBDAORemoveStoredDashboardReportColumnDSQL(), velParam, velParam);
			
			
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
     * ESM_BKG_1212 저장 EVNET 처리<br>
     * @param DashboardReportColumnVO[] reportColumnVOs
	 * @param  String usr_id
	 * @param  String rpt_fom_no
     * @exception DAOException
     */
	public void addDashboardReportColumn(
			DashboardReportColumnVO[] reportColumnVOs, String usr_id, String rpt_fom_no)  throws DAOException {
		int insCnt[] = new int[reportColumnVOs.length];
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = new HashMap<String, String>();

			log.info("for before");

			//  이렇게도 쓸 수 있음 
			for(int k=0; k < reportColumnVOs.length; k++ ){
				velParam =  ((DashboardReportColumnVO)reportColumnVOs[k]).getColumnValues();
				velParam.put("usr_id", usr_id);
				velParam.put("rpt_fom_no", rpt_fom_no);
				log.info("\nvelParam:"+velParam);
				log.info("\nISQLTemplate:"+(ISQLTemplate)new DashboardDBDAOAddStoredDashboardReportColumnCSQL());
				insCnt[k] = sqlExe.executeUpdate((ISQLTemplate)new DashboardDBDAOAddStoredDashboardReportColumnCSQL(), velParam, velParam);
			}
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		
	}

	/**
     * ESM_BKG_1211 조회 EVNET 처리<br>
     * @param EsmBkg1211Event event
	 * @return  List<DashboardReportSettingVO>
     * @exception DAOException
     */
	public DBRowSet searchDashboardRptFormByCust(EsmBkg1211Event event)  throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            param.put("usr_id", (String) event.getAttribute("usr_id"));
            param.put("bkg_ofc", (String) event.getAttribute("bkg_ofc"));

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchDashboardReportSettingRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return dbRowset;
	}

	/**
     * ESM_BKG_1211 삭제 EVNET 처리<br>
     * @param  DashboardReportSettingVO[] reportSettingVOs
	 * @param  String usr_id
     * @exception DAOException
     */
	public void removeDashboardReportSetting(DashboardReportSettingVO[] reportSettingVOs, String usr_id) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam =  new HashMap<String, String>();
			velParam =  ((DashboardReportSettingVO)reportSettingVOs[0]).getColumnValues();
			velParam.put("usr_id", usr_id);
			log.info("\nISQLTemplate:"+(ISQLTemplate)new DashboardDBDAORemoveDashboardReportSettingDSQL());
			sqlExe.executeUpdate((ISQLTemplate)new DashboardDBDAORemoveDashboardReportSettingDSQL(), velParam, velParam);

		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
     * ESM_BKG_1211 저장 EVNET 처리<br>
     * @param DashboardReportSettingVO reportSettingVO
	 * @param  String usr_id
     * @exception DAOException
     */
	public void addDashboardReportSetting(DashboardReportSettingVO reportSettingVO, String usr_id)  throws DAOException {
		int insCnt = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = new HashMap<String, String>();		
			velParam.putAll(reportSettingVO.getColumnValues());
			 velParam.put("usr_id", usr_id);
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new DashboardDBDAOAddDashboardReportSettingCSQL(), velParam, velParam);
			
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	   /**
     * ESM_BKG_1211 삭제 EVNET 처리<br>
     * @param  DashboardReportSettingVO reportSettingVO
     * @param  String usr_id
     * @exception DAOException
     */
    public void deleteDashboardReportSetting(DashboardReportSettingVO reportSettingVO, String usr_id) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            Map<String, String> velParam =  new HashMap<String, String>();
            velParam.putAll(reportSettingVO.getColumnValues());
            velParam.put("usr_id", usr_id);
            log.info("\nISQLTemplate:"+(ISQLTemplate)new DashboardDBDAODeleteDashboardReportSettingDSQL());
            sqlExe.executeUpdate((ISQLTemplate)new DashboardDBDAODeleteDashboardReportSettingDSQL(), velParam, velParam);

        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

	/**
     * ESM_BKG_1212 조회 EVNET 처리<br>
     * @param EsmBkg1212Event event
	 * @param String usr_id 
	 * @return  List<DashboardReportFormVO>
     * @exception DAOException
     */
	public List<DashboardReportFormVO> searchBeforeApply(EsmBkg1212Event event, String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<DashboardReportFormVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        try {
            param.put("usr_id", usr_id);
            param.put("rpt_fom_nm", (String) event.getAttribute("rpt_fom_nm"));

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DashboardDBDAOSearchBeforeApplyRSQL(), param, param);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DashboardReportFormVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}  


}