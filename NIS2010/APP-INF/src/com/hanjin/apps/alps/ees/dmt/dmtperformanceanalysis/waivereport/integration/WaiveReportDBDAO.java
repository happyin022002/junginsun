/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WaiveReportDBDAO.java
*@FileTitle : WAIVE REPORT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.20 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.AfterBookingFileLetterVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS WaiveReportDBDAO <br>
 * - ALPS-DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang HyoKeun
 * @see WaiveReportBCImpl 참조
 * @since J2EE 1.6
 */

public class WaiveReportDBDAO extends DBDAOSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5930898704605847358L;

	/**
    * [WAIVE REPORT] 정보를 [SEARCH] 합니다.<br>
    * 
    * @param WaiveReportParmVO waiveReportParmVO
    * @return List<WaiveReportSummaryVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<WaiveReportSummaryVO> searchWaiveReportByOfficeList ( WaiveReportParmVO waiveReportParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<WaiveReportSummaryVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

            if ( waiveReportParmVO != null ) {

                Map<String, String> mapVO = waiveReportParmVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
/*----------------------------------------------------------------------------------------*/                
                
                String tempDMTTRF = (String)waiveReportParmVO.getDmdtTrfCd();
                List<String> tempDMTTRFList = new ArrayList<String>();
                
                StringTokenizer st = new StringTokenizer(tempDMTTRF, ",");
                while (st.hasMoreTokens()) {
                    tempDMTTRFList.add(st.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempWaiveOFF = (String)waiveReportParmVO.getOfcCd2();
                List<String> tempWaiveOFFList = new ArrayList<String>();
                
                StringTokenizer st2 = new StringTokenizer(tempWaiveOFF, ",");
                while (st2.hasMoreTokens()) {
                    tempWaiveOFFList.add(st2.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempDEMDETOFF = (String)waiveReportParmVO.getOfcCd();
                List<String> tempDEMDETOFFList = new ArrayList<String>();
                
                StringTokenizer st3 = new StringTokenizer(tempDEMDETOFF, ",");
                while (st3.hasMoreTokens()) {
                    tempDEMDETOFFList.add(st3.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/

                velParam.put("tempDMTTRFList", tempDMTTRFList);
                velParam.put("tempWaiveOFFList", tempWaiveOFFList);
                velParam.put("tempDEMDETOFFList", tempDEMDETOFFList);

            }

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new WaiveReportDBDAOSearchWaveReportByOfficeListRSQL(), param, velParam, true);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, WaiveReportSummaryVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
    * [WAIVE REPORT] 정보를 [SEARCH] 합니다.<br>
    * 
    * @param WaiveReportParmVO waiveReportParmVO
    * @return List<WaiveReportDetailVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<WaiveReportDetailVO> searchWaiveReportByOfficeDetailList ( WaiveReportParmVO waiveReportParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<WaiveReportDetailVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

            if ( waiveReportParmVO != null ) {

                Map<String, String> mapVO = waiveReportParmVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);

/*----------------------------------------------------------------------------------------*/
                
                String tempSCNO = (String)waiveReportParmVO.getSlctscno();
                List<String> tempSCNOList = new ArrayList<String>();
                
                StringTokenizer st = new StringTokenizer(tempSCNO, ",");
                while (st.hasMoreTokens()) {
                    tempSCNOList.add(st.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempRFANO = (String)waiveReportParmVO.getSlctrfano();
                List<String> tempRFANOList = new ArrayList<String>();
                
                StringTokenizer st2 = new StringTokenizer(tempRFANO, ",");
                while (st2.hasMoreTokens()) {
                    tempRFANOList.add(st2.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempTRFCD = (String)waiveReportParmVO.getSlcttrfcd();
                List<String> tempTRFCDList = new ArrayList<String>();
                
                StringTokenizer st3 = new StringTokenizer(tempTRFCD, ",");
                while (st3.hasMoreTokens()) {
                    String tTkn = st3.nextToken();
//                    if ( tempTRFCD.indexOf(tTkn) == -1 ) {
                        tempTRFCDList.add(tTkn);                        
//                    }
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempWaiveOFF = (String)waiveReportParmVO.getOfcCd2();
                List<String> tempWaiveOFFList = new ArrayList<String>();
                
                StringTokenizer st4 = new StringTokenizer(tempWaiveOFF, ",");
                while (st4.hasMoreTokens()) {
                    tempWaiveOFFList.add(st4.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                velParam.put("tempSCNOList" , tempSCNOList);
                velParam.put("tempRFANOList", tempRFANOList);
                velParam.put("tempTRFCDList", tempTRFCDList);
                velParam.put("tempWaiveOFFList", tempWaiveOFFList);

            }

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new WaiveReportDBDAOSearchWaveReportByOfficeDetailListRSQL(), param, velParam, true);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, WaiveReportDetailVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    

	/**
    * [After Booking Guarantee Letter REPORT] 정보를 [SEARCH] 합니다.<br>
    * 
    * @param AfterBookingFileLetterVO afterBookingFileLetterVO
    * @return List<AfterBookingFileLetterVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
	public List<AfterBookingFileLetterVO> searchAfterBookingFileLetterList ( AfterBookingFileLetterVO afterBookingFileLetterVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<AfterBookingFileLetterVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

            if ( afterBookingFileLetterVO != null ) {

                Map<String, String> mapVO = afterBookingFileLetterVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
/*----------------------------------------------------------------------------------------*/                
                
                String tempDarNo = (String)afterBookingFileLetterVO.getDarNo();
                List<String> tempDarNoList = new ArrayList<String>();
                
                StringTokenizer st = new StringTokenizer(tempDarNo, ",");
                while (st.hasMoreTokens()) {
                	tempDarNoList.add(st.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/

                velParam.put("tempDarNoList", tempDarNoList);

            }

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new WaiveReportDBDAOSearchAfterBookingFileLetterRSQL(), param, velParam, true);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterBookingFileLetterVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
}
