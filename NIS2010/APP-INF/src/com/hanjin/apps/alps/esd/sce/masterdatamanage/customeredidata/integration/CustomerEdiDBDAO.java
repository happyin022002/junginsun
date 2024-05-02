/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustomerEdiDBDAO.java
*@FileTitle : EDI와 EAI 연동 관련 데이터 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-26
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* history
* Change history :
* 2012-04-27 채창호 [CHM-201217464-01]:SCEM(Customer EDI) upgrade project 관련 화면 수정 요청(1)
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.basic.CustomerEdiBCImpl;
import com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC;
import com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration.COPSearchDBDAOSearchBookingListRSQL;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerEdiDBDAOOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCsInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEstimationListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchVesselSkdOptionsVO;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-SCEM에 대한 DB 처리를 담당<br>
 * - ENIS-SCEM Business Logic을 처리하기 위한 JDBC 작업수행.<br>f
 * 
 * @author yong_cheon_shin
 * @see CustomerEdiBCImpl 참조
 * @since J2EE 1.4
 */
public class CustomerEdiDBDAO  extends DBDAOSupport  {
    
	private static final long serialVersionUID = -5163573712138859660L;

    /** Call Actual date input modual, EDI Send modual call
     * @param models Collection
     * @param parameterMap HashMap
     * @return String
     * @throws DAOException
     */
//    public String updateCageTrackingSaveSend(HashMap model) throws EventException{
////        Connection con = null;
////        CallableStatement cs = null;
////        String queryStr = "{call sce_act_rcv_mvmt_ol_prc(?,?,?,?,?,?)}";
//        
//        String cntr_no = "";
//        String bkg_no = "";
//        String bkg_no_split = "";
//        String edi_sts = "";
//        
//        String resultCd = "000000";
//
////        try{
//            cntr_no = (String)model.get("cntr_no");
//            bkg_no = (String)model.get("bkg_no");
//            bkg_no_split = (String)model.get("bkg_no_split");
//            edi_sts = (String)model.get("edi_sts");
//
//            
//            log.info("\n cntr_no : " + cntr_no);
//            log.info("\n bkg_no  : " + bkg_no);
//            log.info("\n bkg_no_split  : " + bkg_no_split);
//            log.info("\n edi_sts  : " + edi_sts);
//
////            con = getConnection();
////            
////            cs = con.prepareCall(queryStr);
////            
////            cs.setString(1, cop_no); 
////            cs.setString(2, cop_grp_seq); 
////            cs.setString(3, cop_dtl_seq); 
////            cs.setString(4, act_dt);
////            cs.setString(5, usr_id); 
////            cs.setString(6, ""); 
////            cs.registerOutParameter(6,Types.VARCHAR); 
////            
////            cs.executeUpdate(); 
////
////            resultCd = cs.getString(6); 
////            log.info("resultCd : " + resultCd);
////            if(!"000000".equals(resultCd)){
////            	log.info("resultCd : " + resultCd);
////               //throw new DAOException(new ErrorHandler("SCE00031").getMessage());
////            }
////        } catch (SQLException se) { 
////            log.error(se.getMessage(), se);
////            throw new EventException(new ErrorHandler(se).getMessage());
////        } catch (DAOException de) {
////            log.error(de.getMessage(), de); 
////            throw new EventException(new ErrorHandler(de).getMessage());
////        } finally { 
////            closeStatement(cs); 
////            closeConnection(con); ㄹ//
////        } 
//        
//        return resultCd;
//    }
    
    /** 입력한 Actual을 COP detail에 입려하기 위해서 Procedure 호출 
     * 
     * @param model 
     * @param models Collection
     * @param parameterMap HashMap
     * @return String
     * @throws EventException 
     * @throws DAOException
     */
//    public String actualCopDetail(HashMap model) throws EventException{
//        Connection con = null;
//        CallableStatement cs = null;
//        String queryStr = "{call sce_act_rcv_mvmt_ol_prc(?,?,?,?,?,?,'Y')}";
//        
//        String cop_no = "";
//        String cop_grp_seq = "";
//        String cop_dtl_seq = "";
//        String act_dt = "";
//        String usr_id = "SYS";
//        String resultCd = "";
//        try{
//            cop_no = (String)model.get("cop_no");
//            cop_grp_seq = (String)model.get("group_seq");
//            cop_dtl_seq = (String)model.get("dtl_seq");
//            act_dt = (String)model.get("cnmv_dt_tm");
//            usr_id = "SYS";
//            
//            log.info("\n cop_no : " + cop_no);
//            log.info("\n cop_grp_seq  : " + cop_grp_seq);
//            log.info("\n cop_dtl_seq  : " + cop_dtl_seq);
//            log.info("\n act_dt  : " + act_dt);
//            log.info("\n usr_id  : " + usr_id);
//
//            con = getConnection();
//            
//            cs = con.prepareCall(queryStr);
//            
//            cs.setString(1, cop_no); 
//            cs.setString(2, cop_grp_seq); 
//            cs.setString(3, cop_dtl_seq); 
//            cs.setString(4, act_dt);
//            cs.setString(5, usr_id); 
//            cs.setString(6, ""); 
//            cs.registerOutParameter(6,Types.VARCHAR); 
//            
//            cs.executeUpdate(); 
//
//            resultCd = cs.getString(6); 
//            log.info("resultCd : " + resultCd);
//            if(!"000000".equals(resultCd)){
//            	log.info("resultCd : " + resultCd);
//               //throw new DAOException(new ErrorHandler("SCE00031").getMessage());
//            }
//        } catch (SQLException se) { 
//            log.error(se.getMessage(), se);
//            throw new EventException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//            log.error(de.getMessage(), de); 
//            throw new EventException(new ErrorHandler(de).getMessage());
//        } finally { 
//            closeStatement(cs); 
//            closeConnection(con); 
//
//        } 
//        
//        return resultCd;
//    }
    
    /**
     * EDI Customer Data Search<br>
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchCustomerDataVO>
     * @exception DAOException
     */
    public List<SearchCustomerDataVO> searchCustomerData(CustomerEdiDBDAOOptionsVO cusEdiOpt)throws DAOException{
    	
    	log.info("SearchCustomerData를 실행합니다.");
    	DBRowSet dbRowset = null;
    	CodeUtilBC commUtil = new CodeUtilBCImpl();
		List<SearchCustomerDataVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cusEdiOpt != null) {
				Map<String, String> mapVO = cusEdiOpt.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("convert_group_id", commUtil.convertStr(cusEdiOpt.getCsGrpId()));
				log.info("VO-PARAM1:"+ cusEdiOpt.getCsCd());
				log.info("SearchCustomerData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCustomerDataRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCustomerDataVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
    /**
     * Edi status Data Search<br>
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchEdiStatusDataVO>
     * @exception DAOException
     */
    public List<SearchEdiStatusDataVO> searchEdiStatusData(CustomerEdiDBDAOOptionsVO cusEdiOpt)throws DAOException{    
        log.info("SearchEdiStatusData를 실행합니다.");
    	DBRowSet dbRowset = null;
    	CodeUtilBC commUtil = new CodeUtilBCImpl(); 
		List<SearchEdiStatusDataVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cusEdiOpt != null) {
				Map<String, String> mapVO = cusEdiOpt.getColumnValues();
				param.putAll(mapVO);
				velParam.put("convert_group_id", commUtil.convertStr(cusEdiOpt.getCsGrpId()));
				velParam.putAll(mapVO);
			    log.info("VO-PARAM1:"+ cusEdiOpt.getCsCd());
				log.info("SearchEdiStatusData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchEdiStatusDataRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchEdiStatusDataVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
    
    /**
     * Edi Sending history Data Search<br>
     * 
     * @param parameterMap HashMap
     * @return DBRowSet
     * @exception DAOException
     */
//    public DBRowSet searchEdiSendHistoryData(HashMap parameterMap) throws DAOException{
//        
//        Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        DBRowSet dRs = null;                // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//        String edi_grp_cd = (String)parameterMap.get("edi_grp_cd");
//        String vvd = (String)parameterMap.get("vvd");
//        String bkg_no = (String)parameterMap.get("bkg_no");
//        String bkg_no_split = (String)parameterMap.get("bkg_no_split");
//        String cntr_no = (String)parameterMap.get("cntr_no");
//        StringBuffer queryStr = new StringBuffer();
//        int i = 1;
//        try{
//            queryStr.append(" select  edi_sts_cd,edi_sub_sts_cd, bkg_no, bkg_no_split,                           \n"); 
//            queryStr.append("      bl_no||bl_no_tp||bl_no_chk, ? vvd, nod_cd, to_char(act_dt,'yyyy-mm-dd hh24:mi:ss'),   \n");
//            queryStr.append("      to_char(upd_dt,'yyyy-mm-dd hh24:mi:ss'),decode(edi_snd_tp_cd,'Y','S','N'),edi_snd_rmk              \n");
//            queryStr.append("      from sce_edi_snd_rslt                                             \n");
//            queryStr.append("      where edi_grp_cd  = ?                                              \n");
//            queryStr.append("            and bkg_no = ?                                      \n");
//            queryStr.append("            and bkg_no_split = ?                                \n");
//            queryStr.append("            and cntr_no = ? order by act_dt, cre_dt                                    \n");
//            con = getConnection();
//            
//            /** Loggable Statement 사용에 의해 추가 */ 
//            if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//                ps = new LoggableStatement(con, queryStr.toString());
//            }else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//            
//            ps.setString(i++, vvd);
//            ps.setString(i++,edi_grp_cd);
//            ps.setString(i++, bkg_no);
//            ps.setString(i++,bkg_no_split.equals("")?"  ":bkg_no_split);
//            ps.setString(i++, cntr_no);
//            
//            log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//
//            dRs = new DBRowSet();
//            dRs.populate(rs);
//            return dRs;
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//        }
//    }
    
    /** EDI Customer 정보 Search
     * @param CustomerInqChoiceVO custInq
     * @return List<SearchCustomerInqueryVO>
     * @throws DAOException
     */
    public List<SearchCustomerInqueryVO> searchCustomerInquery(CustomerInqChoiceVO custInq) throws DAOException{
    	DBRowSet dbRowset = null;
		List<SearchCustomerInqueryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (custInq != null) {
				Map<String, String> mapVO = custInq.getColumnValues();

//				log.info( "por_cd ==> " + mapVO.get("por_cd"));
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			log.info("param==" + param);
			log.info("velParam==" + velParam);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCustomerInqueryRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					SearchCustomerInqueryVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
    
    /** Customer Inquiry 에서 해당 데이터의 갯수
     *  1개 이상이면 존제함 없으면 저장~~ 
     * @param CustomerInqChoiceVO custInq
     * @return int
     * @throws DAOException
     */
    public int searchCustomercnt(CustomerInqChoiceVO custInq) throws DAOException{
    	DBRowSet dbRowset = null;
		//List<SearchCustomerCntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{        	
        	if (custInq != null) {
				Map<String, String> mapVO = custInq.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			log.info("param==" + param);
			log.info("velParam==" + velParam);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCustomerCntRSQL(),
					param, velParam);
			
			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				log.info("dbRowset.getInt(1)=== " +temp);
				if (temp == 0) {
					updateCustomerInquery(custInq);        // 중복 데이터가 없으면 저장 한다..
				}
				return temp;
        	}
			return 0;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** Customer Inquiry 에서 겹치는 데이터가 없을때 저장~~
     * @param CustomerInqChoiceVO custInq
     * @throws DAOException
     */
    public void updateCustomerInquery(CustomerInqChoiceVO custInq) throws DAOException{
    	try {
			int insCnt = 0;
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map param = custInq.getColumnValues();
			Map velParam = custInq.getColumnValues();
			log.info("velParam===" + velParam);

			insCnt = sqlExe.executeUpdate(new CustomerEdiDBDAOUpdateCustomerInqueryCSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** customer tp id가 2개 이상이 었을 경우
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchCustomTpIdVO>
     * @throws DAOException
     */
    
    public List<SearchCustomTpIdVO> searchCustomTpId(SearchEDIPerformanceOptionsVO schEpOpts)throws DAOException{    
        log.info("searchCustomTpId is running");
    	DBRowSet dbRowset = null;
		List<SearchCustomTpIdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("Pram: " + schEpOpts.getTpId());
				log.info("SearchEDIPerformanceOptionsVO has been set");
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCustomTpIdRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCustomTpIdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }    
    /** 각각의 EDI STS별 최종 전송 시간을 조회 한다. 
     * 
     * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchEdiSummaryReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws DAOException{
    	log.info("###EsdSce0035 - searchEdiSummaryReport is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			/*페이징 처리*/
            log.info("###EsdSce0035 - Param[i_page] : " + schSROptsVO.getIPage());
            String sIpage  = schSROptsVO.getIPage();
			int iPage = 0;
			if(sIpage == null || sIpage.equals("") || sIpage.equals("0") ){
				iPage = 1;
			}else{
				
				iPage = Integer.parseInt(sIpage);
			}//if

			int currentPage = iPage;
			int startPart   = Constants.PAGE_SIZE_300 * (currentPage - 1) + 1;
			int endPart     = Constants.PAGE_SIZE_300 * currentPage; 
			
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					
					
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no_") != null
						&& !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null
						&& !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null
						&& !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if
				
				//페이징 세팅
				log.info("###EsdSce0035 - Paging Parameter" + "START: " + String.valueOf(startPart) + " END:" + String.valueOf(endPart));				
				velParam.put("v_startpart",String.valueOf(startPart));
				velParam.put("v_endpart",String.valueOf(endPart));
				
				log.info("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
			}//if

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchEdiSummaryReportRSQL(),
					param, velParam);
            return dbRowset;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }    
    /** edi sts 별 summary 조히 count를 구한다(count 변경 가능)
     * 미사용 method
     * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return int
     * @throws DAOException
     */    
    public int searchEdiSummaryReportCnt(SearchEdiSummaryReportOptionsVO schSROptsVO) throws DAOException{
    	log.info("###EsdSce0035 - searchEdiSummaryReportCnt is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					
					
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no_") != null
						&& !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null
						&& !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null
						&& !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if

				log.info("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
			}//if

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchEdiSummaryReportCntRSQL(),
					param, velParam);
		    if(dbRowset.getRowCount()>0){
		    	dbRowset.next();
		    	return dbRowset.getInt(1);
		    }else{
		    	return 0;
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}     	    

    /** Detail Report - 운송 관련 edi 전송 data 조회
     * 
     * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchDetailMvmtReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws DAOException{
    	log.info("###EsdSce0035 - searchDetailMvmtReport is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			/*페이징 처리*/
            log.info("###EsdSce0035 - Param[i_page] : " + schSROptsVO.getIPage());
			String sIpage  = schSROptsVO.getIPage();
			int iPage = 0;
			if(sIpage == null || sIpage.equals("") || sIpage.equals("0") ){
				iPage = 1;
			}else{
				
				iPage = Integer.parseInt(sIpage);
			}//if

			int currentPage = iPage;
			int startPart   = Constants.PAGE_SIZE_300 * (currentPage - 1) + 1;
			int endPart     = Constants.PAGE_SIZE_300 * currentPage; 

			if (schSROptsVO != null) {
				
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(schSROptsVO.getMissingType().equals("Z")){
					velParam.put("missing_type2","Z");
				}
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					
					
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	
				
				//missing_type MULTI 처리
				if (velParam.get("missing_type") != null
						&& !((String) velParam.get("missing_type")).trim().equals("")) {
					
					
					String[] array1 = ((String) velParam.get("missing_type")).toUpperCase().split(",");
					log.info("###EsdSce0035  Prams first - " + velParam.get("missing_type") + " Size:" + array1.length);
					velParam.put("missing_type", ((String) velParam.get("missing_type")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[missing_type]  - " + ((String[])velParam.get("missing_type")).length);
				}//if	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no_") != null
						&& !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null
						&& !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null
						&& !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if	
				
				
				//페이징 세팅
				log.info("###EsdSce0035 - Paging Parameter" + "START: " + String.valueOf(startPart) + " END:" + String.valueOf(endPart));				
				velParam.put("v_startpart",String.valueOf(startPart));
				velParam.put("v_endpart",String.valueOf(endPart));
				log.info("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
			}//if

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchDetailMvmReportRSQL(),
					param, velParam);
            return dbRowset;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }   
    /** Detail Report - 운송 관련 edi 전송 data 조회(count)
     * 
     * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return int
     * @throws DAOException
     */
    public int searchDetailMvmtReportCnt(SearchEdiSummaryReportOptionsVO schSROptsVO) throws DAOException{ 
    	log.info("###EsdSce0035 - searchDetailMvmtReportCnt is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					
					
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no_") != null
						&& !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null
						&& !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null
						&& !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if
				
				log.info("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
			}//if

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchDetailMvmtReportCntRSQL(),
					param, velParam);
		    if(dbRowset.getRowCount()>0){
		    	dbRowset.next();
		    	return dbRowset.getInt(1);
		    }else{
		    	return 0;
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** 
     * Detail Report - 운송외 관련 EDI 전송 Data 조회
     * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * 
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchDetailOtherReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws DAOException{
    	log.info("###EsdSce0035 - searchDetailOtherReport is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			/*페이징 처리*/
            log.info("###EsdSce0035 - Param[i_page] : " + schSROptsVO.getIPage());
			String sIpage  = schSROptsVO.getIPage();
			int iPage = 0;
			if(sIpage == null || sIpage.equals("") || sIpage.equals("0") ){
				iPage = 1;
			}else{
				
				iPage = Integer.parseInt(sIpage);
			}//if

			int currentPage = iPage;
			int startPart   = Constants.PAGE_SIZE_300 * (currentPage - 1) + 1;
			int endPart     = Constants.PAGE_SIZE_300 * currentPage; 
			
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					
					
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no_") != null
						&& !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null
						&& !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null
						&& !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if	
				
				//페이징 세팅
				log.info("###EsdSce0035 - Paging Parameter" + "START: " + String.valueOf(startPart) + " END:" + String.valueOf(endPart));				
				velParam.put("v_startpart",String.valueOf(startPart));
				velParam.put("v_endpart",String.valueOf(endPart));				
				log.info("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
			}//if
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchDetailOtherReportRSQL(),
					param, velParam);
            return dbRowset;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    	
    }        
    /** Detail Report - 운송외관련 EDI 전송 data 조회(Count)
     * 
     * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * 
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return int
     * @throws DAOException
     */
    public int searchDetailOtherReportCnt(SearchEdiSummaryReportOptionsVO schSROptsVO) throws DAOException{
    	log.info("###EsdSce0035 - searchDetailOtherReportCnt is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					
					
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no_") != null
						&& !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null
						&& !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null
						&& !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if
				
				log.info("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
			}//if

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchDetailOtherReportCntRSQL(),
					param, velParam);
		    if(dbRowset.getRowCount()>0){
		    	dbRowset.next();
		    	return dbRowset.getInt(1);
		    }else{
		    	return 0;
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    	
    }  
    
    /** Customer Information 조회(EDI Status)
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return List<SearchCsInfoVO>
     * @throws DAOException
     */
    public List<SearchCsInfoVO> searchCsInfo(SearchEdiSummaryReportOptionsVO schSROptsVO) throws DAOException{
    	log.info("searchCsInfo is running");
    	DBRowSet dbRowset = null;
		List<SearchCsInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("SearchEdiSummaryReportOptionsVO is just set up");
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCsInfoRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCsInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;

    }		

    /** 
     * EDI Customer TP ID Information Count 조회
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return int
     * @throws DAOException
     */
    public int searchCsTpIdInfoCnt(SearchEDIPerformanceOptionsVO schEpOpts)throws DAOException{
    	log.info("###EsdSce0072 - searchCsTpIdInfoCnt is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
			}//if
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCsTpIdInfoCntRSQL(),
					param, velParam);
		    if(dbRowset.getRowCount()>0){
		    	dbRowset.next();
		    	return dbRowset.getInt(1);
		    }else{
		    	return 0;
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}    
    
    /** EDI Customer TP ID Information 조회
     * 
     * @param parameterMap
     * @return
     * @throws DAOException
     */
//    public HashMap searchCsTpIdInfo(SearchEDIPerformanceOptionsVO schEpOpts) throws DAOException{
//    	Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        HashMap map = new HashMap();
//
//        int i = 1;
//        
//    	DBRowSet dbRowset = null;
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//----
//		try {
//			if (schEpOpts != null) {
//				Map<String, String> mapVO = schEpOpts.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//				log.info("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
//			}//if
//			
//			dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new CustomerEdiDBDAOSearchCsTpIdInfoRSQL(),
//					param, velParam);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		/*
//        try{
//        	con = getConnection();            
//
//            
//            ps.setString(i++, tp_id);
//
//            
//            log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//            
//            while(rs.next()){
//            	map.put("cs_grp_id",JSPUtil.getNull(rs.getString("cs_grp_id")));
//            	map.put("tp_id",JSPUtil.getNull(rs.getString("tp_id")));
//            	map.put("cs_desc",JSPUtil.getNull(rs.getString("cs_desc")));
//            	map.put("edi_sts",JSPUtil.getNull(rs.getString("edi_sts")));
//            }
//            
//            return map;
//        	
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//        }*/
//    }
//    
    /**
     * Actual Activity Inquiry Data 추출
     * @param SearchEdiActivityInquiryDataOptionsVO schEAIDOpts 
     * @return List<SearchEdiActivityInquiryDataVO>
     * @throws DAOException 
     */
    public List<SearchEdiActivityInquiryDataVO> searchEdiActivityInquiryData(SearchEdiActivityInquiryDataOptionsVO schEAIDOpts)throws DAOException{    
        log.info("searchEdiActivityInquiryData is running");
    	DBRowSet dbRowset = null;
		List<SearchEdiActivityInquiryDataVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEAIDOpts != null) {
				Map<String, String> mapVO = schEAIDOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchEdiActivityInquiryDataRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchEdiActivityInquiryDataVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
    
    /**Cargo Tracking EDI Save/Send - Individual Data 추출
     * @param SearchCargoTrackingDataOptionsVO schCtdOpts
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchCargoTrackingData(SearchCargoTrackingDataOptionsVO schCtdOpts)throws DAOException{
      	log.info("###EsdSce0061 - searchCargoTrackingData is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schCtdOpts != null) {
				Map<String, String> mapVO = schCtdOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("###EsdSce0061 - param[bkg_no] :" +  param.get("bkg_no"));
				log.info("###EsdSce0061 - param[cntr_no] :" +  param.get("cntr_no"));
				log.info("###EsdSce0061 - SearchCargoTrackingDataOptionsVO is just set!");
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCargoTrackingDataRSQL(),
					param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
    }
    
    /** 화주별 edi setting data 추출
     * @param SearchCargoTrackingDataOptionsVO schCtdOpts
     * @return DBRowSet 
     * @throws DAOException
     */
    public DBRowSet searchEdiStsDesc(SearchCargoTrackingDataOptionsVO schCtdOpts) throws DAOException{
      	log.info("###EsdSce0061 - searchEdiStsDesc is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schCtdOpts != null) {
				Map<String, String> mapVO = schCtdOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("###EsdSce0061 - param[edi_grp_cd] :" +  param.get("edi_grp_cd"));
				log.info("###EsdSce0061 - param[edi_sts] :" +  param.get("edi_sts"));
				log.info("###EsdSce0061 - SearchCargoTrackingDataOptionsVO is just set!");
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchEdiStsDescRSQL(),
					param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
    }
    /**
     * Edi Transport Data Search - old version<br>
     * 
     * @param parameterMap HashMap
     * @return DBRowSet
     * @exception DAOException
     */
//    public DBRowSet searchEdiTransportationData(HashMap parameterMap) throws DAOException{
//        String edi_cs_grp   = JSPUtil.getNull((String)parameterMap.get("cs_grp_id"));
//        String vvd          = JSPUtil.getNull((String)parameterMap.get("vvd"));
//        String bkg_no       = JSPUtil.getNull((String)parameterMap.get("bkg_no_"));
//        String bl_no        = JSPUtil.getNull((String)parameterMap.get("bl_no"));
//        String cntr_no      = JSPUtil.getNull((String)parameterMap.get("cntr_no_"));
//        //if(cntr)
//        //String cntr_no = JSPUtil.getNull((String)parameterMap.get("cntr_no"));
//        String por          = JSPUtil.getNull((String)parameterMap.get("por"));
//        String pol          = JSPUtil.getNull((String)parameterMap.get("pol"));
//        String pod          = JSPUtil.getNull((String)parameterMap.get("pod"));
//        String del          = JSPUtil.getNull((String)parameterMap.get("del"));
//        String vsl_cd       = "";
//        String skd_voy_no   = "";
//        String skd_dir_cd   = "";
//        
//        String bl_no_       = "";        
//        String bl_no_tp_    = "";
//        String bl_no_chk_   = "";
//        
//        
//        if(vvd.length()>8){
//            vsl_cd = vvd.substring(0,4);
//            log.info("\n vsl_cd : " + vsl_cd);
//            skd_voy_no = vvd.substring(4,8);
//            log.info("\n skd_voy_no : " + skd_voy_no);
//            skd_dir_cd = vvd.substring(8,9);
//            log.info("\n skd_dir_cd : " + skd_dir_cd);
//        }
//        Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        DBRowSet dRs = null;                // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//        int i = 1;
//        
//        StringBuffer queryStr = new StringBuffer();
//        
//        queryStr.append(" select    main.vc||main.so||main.sc, main.bkg_no, main.bkg_no_split, main.cntr_no, main.por_cd,                                                      \n"); 
//        queryStr.append("           main.pol_cd, main.pod_cd, main.del_cd,'', main.act_cd, main.EDI_STND_STS_CD, to_char(main.ESTM_DT,'yyyy-mm-dd hh24:mi:ss')                          \n");
//        queryStr.append("           ,to_char(main.EDI_ACT_SND_DT ,'yyyymmdd'), to_char(main.edi_act_snd_dt ,'hh24miss'), act.act_nm act_nm,decode(main.act_dt ,'','Y','N') isact ,'N' ismodify      \n");
//        queryStr.append("           ,decode(main.edi_act_snd_dt ,'','Y','N') isest, main.cop_grp_seq, main.cop_no ,main.nod_cd, main.vc2, main.so2, main.sc2,main.cop_dtl_seq \n");
//        queryStr.append(" from                                                                                                    \n");
//        queryStr.append(" (                                                                                                       \n");
//        queryStr.append("    select distinct sts_a.vc,sts_a.so, sts_a.sc, sts_a.bkg_no                                                                                           \n");
//        queryStr.append("           ,sts_a.bkg_no_split, sts_a.cntr_no, sts_a.por_cd,                                                                                           \n");
//        queryStr.append("           sts_a.pol_cd, sts_a.pod_cd, sts_a.del_cd, sts_a.ESTM_DT, sts_a.act_dt, sts_a.edi_act_snd_dt,                                                                      \n");
//        queryStr.append("           sts_a.act_cd,( case when  sts_b.edi_evnt_cd = '1' and sts_a.n = cop_grp_seq then 'T'                                                        \n");
//        queryStr.append("                                 when  sts_b.edi_evnt_cd = '1' and sts_a.n <> cop_grp_seq then 'F'                                                       \n");
//        queryStr.append("                                                                                                                                                         \n");
//        queryStr.append("                                 when  sts_b.edi_evnt_cd = '2' and sts_a.n <> cop_grp_seq then 'T'                                                       \n");
//        queryStr.append("                                 when  sts_b.edi_evnt_cd = '2' and sts_a.n = cop_grp_seq then 'F'                                                        \n");
//        queryStr.append("                                                                                                                                                         \n");
//        queryStr.append("                                 when  sts_b.edi_evnt_cd = '3' and sts_a.x = cop_grp_seq then 'T'                                                        \n");
//        queryStr.append("                                 when  sts_b.edi_evnt_cd = '3' and sts_a.x <> cop_grp_seq then 'F'                                                       \n");
//        queryStr.append("                                                                                                                                                         \n");
//        queryStr.append("                                 when  sts_b.edi_evnt_cd = '4' and sts_a.x <> cop_grp_seq then 'T'                                                       \n");
//        queryStr.append("                                 when  sts_b.edi_evnt_cd = '4' and sts_a.x = cop_grp_seq then 'F'                                                        \n");
//        queryStr.append("                                                                                                                                                         \n");
//        queryStr.append("                                 when  sts_b.edi_evnt_cd = '5' then 'T'                                                                                  \n");
//        queryStr.append("                         else 'T' end) as istrue,                                                                                                        \n");
//        queryStr.append("           (case when sts_b.EDI_VSL_TP_CD = '1' and CV||CS||CD = ? then 'T'                                     \n");
//        queryStr.append("               when sts_b.EDI_VSL_TP_CD = '1' and CV||CS||CD <> ? then 'F'                                    \n");
//        queryStr.append("               when sts_b.EDI_VSL_TP_CD = '2' and CV||CS||CD <> ? then 'T'                                    \n");
//        queryStr.append("               when sts_b.EDI_VSL_TP_CD = '2' and CV||CS||CD = ? then 'F'                                     \n");
//        queryStr.append("               when sts_b.EDI_VSL_TP_CD = '3' then 'T'                                                     \n");
//        queryStr.append("           else  'T' end ) as istrunck, sts_a.COP_GRP_SEQ , sts_a.EDI_STND_STS_CD , sts_a.cop_no ,sts_a.nod_cd,vc2,so2,sc2 ,sts_a.cop_dtl_seq    \n");
//        queryStr.append("   from (                                                                                            \n");
//        queryStr.append("           select distinct vc, so, sc,d.vsl_cd vc2,d.skd_voy_no so2,d.skd_dir_cd sc2, k.bkg_no, k.bkg_no_split, k.cntr_no                                 \n");
//        queryStr.append("                   , k.por_cd, k.pol_cd, k.pod_cd, k.del_cd                                  \n");
//        queryStr.append("                   , d.ESTM_DT, d.act_dt, d.edi_act_snd_dt, d.VSL_CD cv                                        \n");
//        queryStr.append("                   , d.SKD_VOY_NO cs, d.SKD_DIR_CD cd                                        \n");
//        queryStr.append("                   , d.COP_GRP_SEQ, d.act_cd                          \n");
//        queryStr.append("                   , k.edi_grp_cd, k.x, k.n , k.EDI_STND_STS_CD, d.cop_no ,d.nod_cd, d.cop_dtl_seq      \n");
//        queryStr.append("           from sce_cop_dtl d,                                                         \n");
//        queryStr.append("           (                                                                                 \n");        
//        queryStr.append(getTranspotationBookingQuery(parameterMap).toString()                                    + "   \n");
//        queryStr.append("                                                                                             \n");
//        queryStr.append("           ) k                                                                               \n");
//        queryStr.append("           where k.cop_no = d.cop_no                                                         \n");
//        queryStr.append("            and  ( k.edi_stnd_sts_cd = d.stnd_edi_sts_cd                                     \n");
//        queryStr.append("                   or                                                                        \n");
//        queryStr.append("                   k.edi_stnd_sts_cd = d.act_cd )                                            \n");
//        queryStr.append("                                                                                             \n");
//        queryStr.append("       ) sts_a, EDI_GRP_CGO sts_b                                                            \n");
//        queryStr.append("       where sts_b.edi_grp_cd = ?                                                            \n");
//        queryStr.append("         and sts_a.edi_grp_cd = sts_b.EDI_GRP_CD                                             \n");
//        queryStr.append("         and sts_a.edi_stnd_sts_cd = sts_b.edi_stnd_sts_cd                                   \n");
//        queryStr.append("                                                                                                         \n");
//        queryStr.append(" ) main , mdm_activity act where istrue = 'T' and istrunck = 'T' and act.act_cd(+) = main.act_cd                                                              \n");
//        if(!cntr_no.equals("")){
//        	queryStr.append(" and main.cntr_no = ? \n");
//        }
//        queryStr.append(" order by BKG_NO, BKG_NO_SPLIT, CNTR_NO, COP_GRP_SEQ, cop_dtl_seq                                                     \n");
//        try{
//            con = getConnection();            
//            /** Loggable Statement 사용에 의해 추가 */ 
//            if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//                ps = new LoggableStatement(con, queryStr.toString());
//            }else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//            
//            String bkg_no_split = "  ";
//            
//            log.info("\n getDataToQuery1 :" + queryStr.toString());
//            ps.setString(i++,vsl_cd+skd_voy_no+skd_dir_cd); 
//            ps.setString(i++,vsl_cd+skd_voy_no+skd_dir_cd); 
//            ps.setString(i++,vsl_cd+skd_voy_no+skd_dir_cd); 
//            ps.setString(i++,vsl_cd+skd_voy_no+skd_dir_cd); 
//            
//            if(!cntr_no.equals("")){
//                
//                ps.setString(i++,cntr_no);
//                ps.setString(i++,edi_cs_grp);
//                ps.setString(i++,cntr_no);
//                ps.setString(i++,edi_cs_grp);
//                if(!bkg_no.equals("")){
//                	if(bkg_no.trim().length() == 13){
//                    	bkg_no_split = bkg_no.substring(11);
//                    	bkg_no = bkg_no.substring(0,11);
//                    }
//                	ps.setString(i++,bkg_no);
//                	ps.setString(i++,bkg_no_split);
//                }
//                if(!bl_no.equals("")){
//                	if(bl_no.trim().length() == 12){
//                		bl_no_ = bl_no.substring(0,10);
//                		bl_no_tp_ = bl_no.substring(10,11);
//                		bl_no_chk_ = bl_no.substring(11,12);
//                	}
//                	ps.setString(i++,bl_no_);
//                	ps.setString(i++,bl_no_tp_);
//                	ps.setString(i++,bl_no_chk_);
//                }
//                if(!por.equals("")){
//                    ps.setString(i++,por);
//                }
//                if(!pol.equals("")){
//                    ps.setString(i++,pol);
//                }
//                if(!pod.equals("")){
//                    ps.setString(i++,pod);
//                }
//                if(!del.equals("")){
//                    ps.setString(i++,del);
//                }
//                ps.setString(i++,edi_cs_grp);
//                
//                log.info("\n i count : " + i);
//            }
//            else if(!bkg_no.equals("") || !bl_no.equals("")){
//                
//                
//                if(!bkg_no.equals("")){
//                    if(bkg_no.trim().length() == 13){
//                    	bkg_no_split = bkg_no.substring(11);
//                    	bkg_no = bkg_no.substring(0,11);
//                    }
//                    
//                    ps.setString(i++,bkg_no);
//                    ps.setString(i++,bkg_no_split);
//                    
////                    ps.setString(i++,edi_cs_grp);
//                    if(!bl_no.equals("")){
//                    	if(bl_no.trim().length() == 12){
//                    		bl_no_ = bl_no.substring(0,10);
//                    		bl_no_tp_ = bl_no.substring(10,11);
//                    		bl_no_chk_ = bl_no.substring(11,12);
//                    	}
//                        ps.setString(i++,bl_no_);
//                        ps.setString(i++,bl_no_tp_);
//                        ps.setString(i++,bl_no_chk_);
//                    }
//                    
////                    ps.setString(i++,bkg_no);
////                    ps.setString(i++, bkg_no_split);
////                    ps.setString(i++,edi_cs_grp);
//                    
////                    if(!bl_no.equals("")){
////                    	if(bl_no.trim().length() == 12){
////                    		bl_no_ = bl_no.substring(0,10);
////                    		bl_no_tp_ = bl_no.substring(10,11);
////                    		bl_no_chk_ = bl_no.substring(11,12);
////                    	}
////                        ps.setString(i++,bl_no_);
////                        ps.setString(i++,bl_no_tp_);
////                        ps.setString(i++,bl_no_chk_);
////                    }
//                }
//                
//                else if(!bl_no.equals("")){
//                	if(bl_no.trim().length() == 12){
//                		bl_no_ = bl_no.substring(0,10);
//                		bl_no_tp_ = bl_no.substring(10,11);
//                		bl_no_chk_ = bl_no.substring(11,12);
//                	}
//                    ps.setString(i++,bl_no_);
//                    ps.setString(i++,bl_no_tp_);
//                    ps.setString(i++,bl_no_chk_);
////                    ps.setString(i++,edi_cs_grp);
//                    
////                    ps.setString(i++,bl_no_);
////                    ps.setString(i++,bl_no_tp_);
////                    ps.setString(i++,bl_no_chk_);
////                    ps.setString(i++,edi_cs_grp);
//                    
//                }
//                ps.setString(i++,edi_cs_grp);
//                
//                if(!por.equals("")){
//                    ps.setString(i++,por);
//                }
//                if(!pol.equals("")){
//                    ps.setString(i++,pol);
//                }
//                if(!pod.equals("")){
//                    ps.setString(i++,pod);
//                }
//                if(!del.equals("")){
//                    ps.setString(i++,del);
//                }
//               
//            }else{
//                ps.setString(i++,vsl_cd);    
//                ps.setString(i++,skd_voy_no); 
//                ps.setString(i++,skd_dir_cd);
//                ps.setString(i++,edi_cs_grp);
//                
//                if(!por.equals("")){
//                    ps.setString(i++,por);
//                }
//                if(!pol.equals("")){
//                    ps.setString(i++,pol);
//                }
//                if(!pod.equals("")){
//                    ps.setString(i++,pod); 
//                }
//                if(!del.equals("")){
//                    ps.setString(i++,del);
//                }
//                
//            }
//            
//            ps.setString(i++,edi_cs_grp);
////            ps.setString(i++,edi_cs_grp);
//            
//            if(!cntr_no.equals("")){
//            	ps.setString(i++,cntr_no);
//            }
//            log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//
//            dRs = new DBRowSet();
//            dRs.populate(rs);
//            return dRs;
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//        }
//    }
    /**
     * EDI Document Data Search - old version<br>
     * 
     * @param parameterMap HashMap
     * @return DBRowSet
     * @exception DAOException
     */
//    public DBRowSet searchEdiDocumentationData(HashMap parameterMap) throws DAOException{
//        
//        String edi_cs_grp = JSPUtil.getNull((String)parameterMap.get("cs_grp_id"));
//        String vvd = JSPUtil.getNull((String)parameterMap.get("vvd"));
//        String bkg_no = JSPUtil.getNull((String)parameterMap.get("bkg_no_"));
//        String bl_no = JSPUtil.getNull((String)parameterMap.get("bl_no"));
//        String cntr_no = JSPUtil.getNull((String)parameterMap.get("cntr_no_"));
//        String por = JSPUtil.getNull((String)parameterMap.get("por"));
//        String pol = JSPUtil.getNull((String)parameterMap.get("pol"));
//        String pod = JSPUtil.getNull((String)parameterMap.get("pod"));
//        String del = JSPUtil.getNull((String)parameterMap.get("del"));
//        String vsl_cd = "";
//        String skd_voy_no = "";
//        String skd_dir_cd = "";
//        
//        String bl_no_ = "";        
//        String bl_no_tp_ = "";
//        String bl_no_chk_ = "";
//        
//        log.info("bl_no===================================" + bl_no);
//        if(vvd.length()>8){
//            vsl_cd = vvd.substring(0,4);
//            log.info("\n vsl_cd : " + vsl_cd);
//            skd_voy_no = vvd.substring(4,8);
//            log.info("\n skd_voy_no : " + skd_voy_no);
//            skd_dir_cd = vvd.substring(8,9);
//            log.info("\n skd_dir_cd : " + skd_dir_cd);
//        }
//        
//        Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        DBRowSet dRs = null;                // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//        int i = 1;
//        StringBuffer queryStr = new StringBuffer();
//        try{
//            queryStr.append(" select b.vc|| b.so|| b.sc, b.BKG_NO, b.BKG_NO_SPLIT, b.CNTR_NO, b.por_cd                         \n");
//            queryStr.append("       ,b.pol_cd, b.pod_cd, b.del_cd,'', b.STS_CD, to_char(max(r.ACT_DT),'yyyymmdd')                      \n");
//            queryStr.append("       ,to_char(max(r.ACT_DT),'hh24miss'),r.nod_cd, STS_DESC, decode(max(r.ACT_DT),'','Y','N'),'N' ismodify      \n");
//            queryStr.append("       ,b.vc, b.so, b.sc, b.cop_no , SEQ   \n");
//            queryStr.append("  from SCE_EDI_SND_RSLT R,                                                      \n");
//            queryStr.append("       (                                                                             \n");
//            queryStr.append("           select distinct  l.vc, l.so, l.sc, L.BKG_NO, L.BKG_NO_SPLIT, L.CNTR_NO                \n");
//            queryStr.append("                   , l.por_cd, l.pol_cd, l.pod_cd, l.del_cd, L.sts_cd, l.cop_no, l.edi_grp_cd , STS_DESC ,SEQ \n");
//            queryStr.append("              from                                                 \n");
//            queryStr.append("           (                                                                         \n");
//            queryStr.append(getDocumentationBookingQuery(parameterMap)                                         + " \n");
//            queryStr.append("         ) L                                                                         \n");
//            queryStr.append("     ) B                                                                             \n");
//            queryStr.append(" where r.EDI_GRP_CD(+)      = b.edi_grp_cd                                           \n");
//            queryStr.append(" and   r.bkg_no(+)          = b.bkg_no                                               \n");
//            queryStr.append(" and   r.bkg_no_split(+)    = b.bkg_no_split                                         \n");
//            queryStr.append(" and   r.cntr_no(+)         = b.cntr_no                                              \n");
//            queryStr.append(" and   r.EDI_STS_CD(+)      = b.sts_cd                                               \n");
//            if(!cntr_no.equals("")){
//            	queryStr.append(" and   b.cntr_no      = ?                                               \n");
//            }
//            queryStr.append(" group by b.vc, b.so, b.sc, b.BKG_NO, b.BKG_NO_SPLIT, b.CNTR_NO, b.por_cd            \n");
//            queryStr.append(" , b.pol_cd, b.pod_cd, b.del_cd, b.STS_CD,  b.cop_no ,r.nod_cd, STS_DESC ,SEQ     \n");
//            queryStr.append(" order by BKG_NO, BKG_NO_SPLIT, CNTR_NO, SEQ                                      \n");
//            
//            con = getConnection();
//            String bkg_no_split = "  ";
//            
//            /** Loggable Statement 사용에 의해 추가 */ 
//            if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//                ps = new LoggableStatement(con, queryStr.toString());
//            }else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//            log.info("\n getDataToQuery :" + queryStr.toString()); 
//            if(!cntr_no.equals("")){
//                
//                ps.setString(i++,cntr_no);
//                ps.setString(i++,edi_cs_grp);
//                ps.setString(i++,cntr_no);
//                ps.setString(i++,edi_cs_grp);
//                if(!bkg_no.equals("")){
//                	if(bkg_no.trim().length() == 13){
//                    	bkg_no_split = bkg_no.substring(11);
//                    	bkg_no = bkg_no.substring(0,11);
//                    }
//                	ps.setString(i++,bkg_no);
//                	ps.setString(i++,bkg_no_split);
//                }
//                if(!bl_no.equals("")){
//                	if(bl_no.trim().length() == 12){
//                		bl_no_ = bl_no.substring(0,10);
//                		bl_no_tp_ = bl_no.substring(10,11);
//                		bl_no_chk_ = bl_no.substring(11,12);
//                	}
//                	ps.setString(i++,bl_no_);
//                	ps.setString(i++,bl_no_tp_);
//                	ps.setString(i++,bl_no_chk_);
//                }
//                if(!por.equals("")){
//                    ps.setString(i++,por);
//                }
//                if(!pol.equals("")){
//                    ps.setString(i++,pol);
//                }
//                if(!pod.equals("")){
//                    ps.setString(i++,pod);
//                }
//                if(!del.equals("")){
//                    ps.setString(i++,del);
//                }
//            }
//            else if(!bkg_no.equals("") || !bl_no.equals("")){
//                
//            	if(!bkg_no.equals("")){
//                    if(bkg_no.trim().length() == 13){
//                    	bkg_no_split = bkg_no.substring(11);
//                    	bkg_no = bkg_no.substring(0,11);
//                    }
//                    ps.setString(i++,bkg_no);
//                    ps.setString(i++,bkg_no_split);
////                    ps.setString(i++,edi_cs_grp);
//                    if(!bl_no.equals("")){
//                    	if(bl_no.trim().length() == 12){
//                    		bl_no_ = bl_no.substring(0,10);
//                    		bl_no_tp_ = bl_no.substring(10,11);
//                    		bl_no_chk_ = bl_no.substring(11,12);
//                    	}
//                        ps.setString(i++,bl_no_);
//                        ps.setString(i++,bl_no_tp_);
//                        ps.setString(i++,bl_no_chk_);
//                    }
//                    
////                    ps.setString(i++,bkg_no);
////                    ps.setString(i++, bkg_no_split);
////                    ps.setString(i++,edi_cs_grp);
////                    
////                    if(!bl_no.equals("")){
////                    	if(bl_no.trim().length() == 12){
////                    		bl_no_ = bl_no.substring(0,10);
////                    		bl_no_tp_ = bl_no.substring(10,11);
////                    		bl_no_chk_ = bl_no.substring(11,12);
////                    	}
////                        ps.setString(i++,bl_no_);
////                        ps.setString(i++,bl_no_tp_);
////                        ps.setString(i++,bl_no_chk_);
////                    }
//                }                
//                else if(!bl_no.equals("")){
//                	if(bl_no.trim().length() == 12){
//                		bl_no_ = bl_no.substring(0,10);
//                		bl_no_tp_ = bl_no.substring(10,11);
//                		bl_no_chk_ = bl_no.substring(11,12);
//                	}
//                    ps.setString(i++,bl_no_);
//                    ps.setString(i++,bl_no_tp_);
//                    ps.setString(i++,bl_no_chk_);
//                    ps.setString(i++,edi_cs_grp);
//                    
////                    ps.setString(i++,bl_no_);
////                    ps.setString(i++,bl_no_tp_);
////                    ps.setString(i++,bl_no_chk_);
////                    ps.setString(i++,edi_cs_grp);
//                    
//                }
//            	ps.setString(i++,edi_cs_grp);
//                
//                if(!por.equals("")){
//                    ps.setString(i++,por);
//                }
//                if(!pol.equals("")){
//                    ps.setString(i++,pol);
//                }
//                if(!pod.equals("")){
//                    ps.setString(i++,pod);
//                }
//                if(!del.equals("")){
//                    ps.setString(i++,del);
//                } 
//            }
//            else{
//                                
//                ps.setString(i++,vsl_cd);    
//                ps.setString(i++,skd_voy_no); 
//                ps.setString(i++,skd_dir_cd); 
//                ps.setString(i++,edi_cs_grp);
//                
//                if(!por.equals("")){
//                    ps.setString(i++,por);
//                }
//                if(!pol.equals("")){
//                    ps.setString(i++,pol);
//                }
//                if(!pod.equals("")){
//                    ps.setString(i++,pod); 
//                }               
//                if(!del.equals("")){
//                    ps.setString(i++,del);
//                }
//            }
//            
//            if(!cntr_no.equals("")){
//            	ps.setString(i++,cntr_no);
//            }
//            
//            log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//
//            dRs = new DBRowSet();
//            dRs.populate(rs);
//            return dRs;
//        } catch (SQLException se) {
//            log.error(se.getMessage(), se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//            log.error(de.getMessage(), de);
//            throw de;
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw new DAOException(e.getMessage());
//        } finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//        }
//    }
//    
   
    /**
     * Adding Query Search(Transportion Booking)<br>
     * 
     * 2002701 iskim : sce_cop_hdr --> bkg_bkg_cust 변환 요소가 있으나 
     * SC 에서 미사용 되는 method 에서 호출 되는 건이어서 수정하지 않음
     * @param parameterMap HashMap
     * @return StringBuffer
     */
//    public StringBuffer getTranspotationBookingQuery(HashMap parameterMap){
//        String bkg_no = JSPUtil.getNull((String)parameterMap.get("bkg_no_"));
//        String bl_no = JSPUtil.getNull((String)parameterMap.get("bl_no"));
//        String cntr_no = JSPUtil.getNull((String)parameterMap.get("cntr_no_"));
//        String por = JSPUtil.getNull((String)parameterMap.get("por"));
//        String pol = JSPUtil.getNull((String)parameterMap.get("pol"));
//        String pod = JSPUtil.getNull((String)parameterMap.get("pod"));
//        String del = JSPUtil.getNull((String)parameterMap.get("del"));
//        String vvd = JSPUtil.getNull((String)parameterMap.get("vvd"));
//        String vsl_cd = "";
//        String skd_voy_no = "";
//        String skd_dir_cd = "";
//        if(vvd.length()>8){
//            vsl_cd = vvd.substring(0,4);
//            skd_voy_no = vvd.substring(4,8);
//            skd_dir_cd = vvd.substring(8,9);
//        }
//        
//        log.info("\n vsl_cd : " + vsl_cd);
//        log.info("\n skd_voy_no : " + skd_voy_no);
//        log.info("\n skd_dir_cd : " + skd_dir_cd);
//
//        StringBuffer queryStr = new StringBuffer();
//        //container로 조회
//        if(!cntr_no.equals("")){
//            queryStr.append(" select distinct a.vc, a.so, a.sc, a.bkg_no, a.bkg_no_split, h.cntr_no                         \n");
//            queryStr.append("        , h.por_cd, h.pol_cd, h.pod_cd, h.del_cd                          \n");
////            queryStr.append("        , pol.CONTI_CD l_conti, pod.CONTI_CD d_conti                      \n");
//            queryStr.append("        , h.cop_no, cgo.EDI_STND_STS_CD                \n");
//            queryStr.append("        , a.edi_grp_cd, max(COP_GRP_SEQ) x, min(COP_GRP_SEQ) n            \n");
//            queryStr.append("   from sce_cop_hdr h, sce_cop_dtl d, edi_grp_cgo cgo,          \n"); // bkg_bkg_cust 전환과 무관
////            queryStr.append("        , mdm_location pol, mdm_location pod,                   \n");
//            queryStr.append("        (                                                                         \n");
//            queryStr.append(" 			select /*+ ordered                                                           \n");
//            queryStr.append(" 			      index(b XPKBKG_BOOKING)                                                \n");
//            queryStr.append(" 			      index(c XPKBKG_BKG_CUST)                                               \n");
//            queryStr.append(" 			      index(e XPKEDI_GROUP_CUSTOMER) */                                      \n");
//            queryStr.append(" 			      c.bkg_no bkg_no, c.bkg_no_split bkg_no_split, b.bl_no, b.bl_no_tp, b.bl_no_chk \n");
//            queryStr.append(" 			     ,e.EDI_GRP_CD edi_grp_cd, VSL_CD vc, SKD_VOY_NO so, SKD_DIR_CD sc       \n"); 
//            queryStr.append(" 			from  bkg_booking b, bkg_bkg_cust c , EDI_GRP_CUST e                         \n");         
//            queryStr.append(" 			where (b.bkg_no, b.BKG_NO_SPLIT) in                                          \n");
//            queryStr.append(" 			(                                                                            \n");
//            queryStr.append(" 			   select bkg_no, bkg_no_split                                               \n");
//            queryStr.append(" 			     from sce_cop_hdr                                                        \n"); // bkg_bkg_cust 전환과 무관
//            queryStr.append(" 			    where cntr_no = ?                                                   \n");
//            queryStr.append(" 			)                                                                            \n");
//            queryStr.append(" 			and b.bkg_no = c.bkg_no                                                      \n");
//            queryStr.append(" 			and b.BKG_NO_SPLIT = c.BKG_NO_SPLIT                                          \n");
//            queryStr.append(" 			and c.CUST_CNT_CD = e.CUST_CNT_CD                                            \n");
//            queryStr.append(" 			and c.CUST_SEQ    = e.CUST_SEQ                                               \n");
//            queryStr.append(" 			and e.EDI_GRP_CD = ?                                               \n");
////            queryStr.append(" 			and e.CGO_TRC_SVC_FLG = 'Y'                                                  \n");
//            queryStr.append(" 			and c.CUST_CNT_CD is not null                                                \n");
//            queryStr.append(" 			and c.CUST_SEQ is not null                                                   \n");
//            queryStr.append(" 			                                                                             \n");
//            queryStr.append(" 			union                                                                        \n");
//            queryStr.append(" 			                                                                             \n");
//            queryStr.append(" 			select  /*+ ordered                                                          \n");
//            queryStr.append(" 			       index(b XPKBKG_BOOKING)                                               \n");
//            queryStr.append(" 			       index(c XPKBKG_BKG_RT_HD)                                             \n");
//            queryStr.append(" 			       index(e XPKEDI_GROUP_CUSTOMER) */                                     \n");
//            queryStr.append(" 			       c.bkg_no, c.bkg_no_split bkg_no_split, b.bl_no, b.bl_no_tp, b.bl_no_chk   \n");
//            queryStr.append(" 			       ,e.edi_grp_cd  edi_grp_cd, VSL_CD vc, SKD_VOY_NO so, SKD_DIR_CD sc       \n"); 
//            queryStr.append(" 			from bkg_booking b, BKG_BKG_RT_HD c, EDI_GRP_CUST e                          \n");                
//            queryStr.append(" 			where (b.bkg_no, b.BKG_NO_SPLIT) in                                          \n");
//            queryStr.append(" 			(                                                                            \n");
//            queryStr.append(" 			   select bkg_no, bkg_no_split                                               \n");
//            queryStr.append(" 			     from sce_cop_hdr                                                        \n");// bkg_bkg_cust 전환과 무관
//            queryStr.append(" 			    where cntr_no = ?                                                   \n");
//            queryStr.append(" 			)                                                                            \n");
//            queryStr.append(" 			and b.bkg_no = c.bkg_no                                                      \n");
//            queryStr.append("           and b.BKG_NO_SPLIT = c.BKG_NO_SPLIT                                          \n");
//            queryStr.append("           and e.EDI_GRP_CD = ?                                                \n");
//            queryStr.append("           and c.sc_no = e.sc_no                                                        \n");
//            queryStr.append("           and c.sc_no is not null                                                      \n");
//            queryStr.append("         ) a                                                                       \n");            
//            queryStr.append("   where a.bkg_no          = h.bkg_no                                                 \n");
//            queryStr.append("     and a.bkg_no_split    = h.bkg_no_split                             \n");
//            queryStr.append("     and h.cop_no          = d.cop_no                                         \n");
//            queryStr.append("     and h.cop_sts_cd          in ('C', 'T')                                   \n");
//            queryStr.append("     and (d.stnd_edi_sts_cd = cgo.EDI_STND_STS_CD                 \n");
//            queryStr.append("           OR                                              \n");
//            queryStr.append("          d.act_cd = cgo.EDI_STND_STS_CD)                 \n");
////            queryStr.append("     and h.pol_cd          = pol.loc_cd                                       \n");
////            queryStr.append("     and h.pod_cd          = pod.loc_cd                                       \n");
//            
//            if(!bkg_no.equals("")){
//            	queryStr.append(" and a.bkg_no = ?                                                   \n");
//            	queryStr.append(" and a.bkg_no_split = ?                                              ");
//            }
//            
//            if(!bl_no.equals("")){
//            	queryStr.append(" and a.bl_no = ?                                                   \n");
//            	queryStr.append(" and a.bl_no_tp = ?                                                   \n");
//            	queryStr.append(" and a.bl_no_chk = ?                                                   \n");
//            }
//            
//            if(!por.equals("")){
//                queryStr.append(" and   h.por_cd = ?                                                \n");
//            }
//            
//            if(!pol.equals("")){
//                queryStr.append(" and   h.pol_cd = ?                                                \n");
//            }
//            
//            if(!pod.equals("")){
//                queryStr.append(" and   h.pod_cd = ?                                                \n");
//            }
//            
//            if(!del.equals("")){
//                queryStr.append(" and   h.del_cd = ?                                                \n");
//            }
//           
//            queryStr.append("     and   cgo.EDI_GRP_CD = ?                                  \n");
//            queryStr.append("     group by a.vc, a.so, a.sc, a.bkg_no, a.bkg_no_split, h.cntr_no               \n");
//            queryStr.append("              , h.por_cd, h.pol_cd, h.pod_cd, h.del_cd,     \n");
//            queryStr.append("              h.cop_no, cgo.EDI_STND_STS_CD                       \n");
//            queryStr.append("              , a.edi_grp_cd                    \n");
//            return queryStr;
//            
//        }else if(!bkg_no.equals("") || !bl_no.equals("")){
//            //booking no로 조회
//            queryStr.append("select /*+ ordered use_nl( b h e d cgo) */                                          \n");                                          
//            queryStr.append("   H.TRNK_VSL_CD vc, H.TRNK_SKD_VOY_NO so, H.TRNK_SKD_DIR_CD sc,                \n");                 
//            queryStr.append("   H.BKG_NO, H.BKG_NO_SPLIT, H.CNTR_NO,                                         \n");                 
//            queryStr.append("   H.POR_CD, H.POL_CD, H.POD_CD, H.DEL_CD,                                      \n");                 
//            queryStr.append("   h.cop_no, cgo.EDI_STND_STS_CD, e.edi_grp_cd,                                 \n");                 
//            queryStr.append("   max(COP_GRP_SEQ) x, min(COP_GRP_SEQ) n                                       \n");                 
//            queryStr.append("from bkg_booking b, sce_cop_hdr h, EDI_GRP_CUST e, sce_cop_dtl d, edi_grp_cgo cgo   \n");// bkg_bkg_cust 전환과 무관
//            
//        	if(!bkg_no.equals("")){
//            	queryStr.append(" 		 where b.bkg_no = ?                                               \n");
//            	queryStr.append(" 		   and b.BKG_NO_SPLIT = ?                                                    \n");
//            	if(!bl_no.equals("")){
//            		queryStr.append("	   and b.bl_no = ?                                                    \n");
//            		queryStr.append("	   and b.bl_no_tp = ?                                                 \n");
//            		queryStr.append("	   and b.bl_no_chk = ?                                              \n");
//            	}
//        	}
//            
//        	if(bkg_no.equals("") && !bl_no.equals("")){
//        		queryStr.append("		 where b.bl_no = ?                                                    \n");
//        		queryStr.append("		   and b.bl_no_tp = ?                                                 \n");
//        		queryStr.append("		   and b.bl_no_chk = ?                                              \n");
//        	}
//            
//            queryStr.append("      and h.bkg_no       = b.bkg_no                                             \n");         
//            queryStr.append("      and h.BKG_NO_SPLIT = b.BKG_NO_SPLIT                                       \n");         
//            queryStr.append("      and h.cop_sts_cd       in ('C', 'T')                                   \n");
//            queryStr.append("      AND E.EDI_GRP_CD   = ?                                          \n");         
//            queryStr.append("   and (   e.CUST_CNT_CD = h.SHPR_CNT_CD       and  e.CUST_SEQ    = h.SHPR_SEQ      \n");          
//            queryStr.append("           or                                                                       \n");          
//            queryStr.append("           e.CUST_CNT_CD = h.CNEE_CNT_CD       and  e.CUST_SEQ    = h.CNEE_SEQ      \n");          
//            queryStr.append("           or                                                                       \n");          
//            queryStr.append("           e.CUST_CNT_CD = h.ACT_CUST_CNT_CD   and  e.CUST_SEQ    = h.ACT_CUST_SEQ  \n");          
//            queryStr.append("           or                                                                       \n");          
//            queryStr.append("           e.CUST_CNT_CD = h.NTFY_CNT_CD       and  e.CUST_SEQ    = h.NTFY_SEQ      \n");          
//            queryStr.append("           or                                                                       \n");          
//            queryStr.append("           e.CUST_CNT_CD = h.FRT_FWRD_CNT_CD   and  e.CUST_SEQ    = h.FRT_FWRD_SEQ  \n");          
//            queryStr.append("           or                                                                       \n");          
//            queryStr.append("           e.sc_no = h.sc_no                                                        \n");          
//            queryStr.append("       )                                                                            \n");          
////            queryStr.append("      and e.CGO_TRC_SVC_FLG = 'Y'                                               \n");         
//            queryStr.append("      AND h.cop_no          = d.cop_no                                  \n");         
//            queryStr.append("   and cgo.EDI_GRP_CD = E.EDI_GRP_CD                                                \n");          
//            queryStr.append("   and (                                                                            \n");          
//            queryStr.append("            d.stnd_edi_sts_cd = cgo.EDI_STND_STS_CD                                 \n");          
//            queryStr.append("            OR                                                                      \n");          
//            queryStr.append("            d.act_cd = cgo.EDI_STND_STS_CD                                          \n");          
//            queryStr.append("       )                                                                            \n");   
//            if(!por.equals("")){
//                queryStr.append(" and h.por_cd = ?                                                \n");
//            }
//            if(!pol.equals("")){
//                queryStr.append(" and h.pol_cd = ?                                                \n");
//            }
//            if(!pod.equals("")){
//                queryStr.append(" and h.pod_cd = ?                                                \n");
//            }
//            if(!del.equals("")){
//                queryStr.append(" and h.del_cd = ?                                                \n");
//            }
//            queryStr.append("AND     H.CNTR_NO <> 'SMCU0000000'                                                  \n");
//            queryStr.append("group by H.TRNK_VSL_CD, H.TRNK_SKD_VOY_NO, H.TRNK_SKD_DIR_CD,                   \n");                 
//            queryStr.append("   H.BKG_NO, H.BKG_NO_SPLIT, H.CNTR_NO,                                         \n");                 
//            queryStr.append("   H.POR_CD, H.POL_CD, H.POD_CD, H.DEL_CD,                                      \n");                 
//            queryStr.append("   h.cop_no, cgo.EDI_STND_STS_CD, e.edi_grp_cd                                  \n");
//
//            return queryStr;
//        }else{
//            queryStr.append("select  /*+ ordered use_nl( H D CGO E) */                                             \n");
//            queryStr.append("        H.TRNK_VSL_CD vc, H.TRNK_SKD_VOY_NO so, H.TRNK_SKD_DIR_CD sc,                          \n");
//            queryStr.append("        H.BKG_NO, H.BKG_NO_SPLIT, H.CNTR_NO,                                          \n");
//            queryStr.append("        H.POR_CD, H.POL_CD, H.POD_CD, H.DEL_CD,                                       \n");
//            queryStr.append("        H.COP_NO, CGO.EDI_STND_STS_CD, E.EDI_GRP_CD,                                  \n");
//            queryStr.append("        max(COP_GRP_SEQ) x, min(COP_GRP_SEQ) n                                        \n");
//            queryStr.append("from    sce_cop_hdr h, EDI_GRP_CUST E, sce_cop_dtl d, edi_grp_cgo cgo                 \n");// bkg_bkg_cust 전환과 무관
//            if(!vsl_cd.equals("")){
//                queryStr.append("where   H.TRNK_VSL_CD       = ?                                                  \n");
//            }
//            if(!skd_voy_no.equals("")){
//                queryStr.append("and     H.TRNK_SKD_VOY_NO   = ?                                                  \n");
//            }
//            if(!skd_dir_cd.equals("")){
//                queryStr.append("and     H.TRNK_SKD_DIR_CD   = ?                                                     \n");
//                queryStr.append("AND     E.EDI_GRP_CD        = ?                                              \n");
//            }            
//            queryStr.append("and     (   e.CUST_CNT_CD = h.SHPR_CNT_CD       and  e.CUST_SEQ    = h.SHPR_SEQ       \n");
//            queryStr.append("            or                                                                        \n");
//            queryStr.append("            e.CUST_CNT_CD = h.CNEE_CNT_CD       and  e.CUST_SEQ    = h.CNEE_SEQ       \n");
//            queryStr.append("            or                                                                        \n");
//            queryStr.append("            e.CUST_CNT_CD = h.ACT_CUST_CNT_CD   and  e.CUST_SEQ    = h.ACT_CUST_SEQ   \n");
//            queryStr.append("            or                                                                        \n");
//            queryStr.append("            e.CUST_CNT_CD = h.NTFY_CNT_CD       and  e.CUST_SEQ    = h.NTFY_SEQ       \n");
//            queryStr.append("            or                                                                        \n");
//            queryStr.append("            e.CUST_CNT_CD = h.FRT_FWRD_CNT_CD   and  e.CUST_SEQ    = h.FRT_FWRD_SEQ   \n");
//            queryStr.append("            or                                                                        \n");
//            queryStr.append("            e.sc_no = h.sc_no                                                         \n");
//            queryStr.append("        )                                                                             \n");
////            queryStr.append("and     e.CGO_TRC_SVC_FLG = 'Y'                                                       \n");
//            queryStr.append("AND     h.cop_no          = d.cop_no                                                  \n");
//            queryStr.append("     and h.cop_sts_cd          in ('C', 'T')                                   \n");
//            queryStr.append("and     cgo.EDI_GRP_CD     = e.EDI_GRP_CD                                             \n");
//            queryStr.append("and     (   d.stnd_edi_sts_cd = cgo.EDI_STND_STS_CD                                   \n");
//            queryStr.append("            OR                                                                        \n");
//            queryStr.append("            d.act_cd = cgo.EDI_STND_STS_CD                                            \n");
//            queryStr.append("        )                                                                             \n");
//            if(!por.equals("")){
//                queryStr.append(" and h.por_cd = ?                                                \n");
//            }
//            if(!pol.equals("")){
//                queryStr.append(" and h.pol_cd = ?                                                \n");
//            }
//            if(!pod.equals("")){
//                queryStr.append(" and h.pod_cd = ?                                                \n");
//            }
//            if(!del.equals("")){
//                queryStr.append(" and h.del_cd = ?                                                \n");
//            }
//            queryStr.append("AND     H.CNTR_NO <> 'SMCU0000000'                                                  \n");
//            queryStr.append("group by H.TRNK_VSL_CD, H.TRNK_SKD_VOY_NO, H.TRNK_SKD_DIR_CD,                         \n");
//            queryStr.append("        H.BKG_NO, H.BKG_NO_SPLIT, H.CNTR_NO,                                          \n");
//            queryStr.append("        H.POR_CD, H.POL_CD, H.POD_CD, H.DEL_CD,                                       \n");
//            queryStr.append("        H.COP_NO, CGO.EDI_STND_STS_CD, E.EDI_GRP_CD                                   \n");                     
//
//            return queryStr;
//        }
//    }
    /**
     * Adding Query Search(Document Booking)<br>
     * 
     * 2002701 iskim : sce_cop_hdr --> bkg_bkg_cust 변환 요소가 있으나 
     * SC 에서 미사용 되는 method 에서 호출 되는 건이어서 수정하지 않음
     * @param parameterMap HashMap
     * @return StringBuffer
     */
//    public StringBuffer getDocumentationBookingQuery(HashMap parameterMap){
//        String bkg_no = JSPUtil.getNull((String)parameterMap.get("bkg_no_"));
//        String bl_no = JSPUtil.getNull((String)parameterMap.get("bl_no"));
//        String cntr_no = JSPUtil.getNull((String)parameterMap.get("cntr_no_"));
//        String por = JSPUtil.getNull((String)parameterMap.get("por"));
//        String pol = JSPUtil.getNull((String)parameterMap.get("pol"));
//        String pod = JSPUtil.getNull((String)parameterMap.get("pod"));
//        String del = JSPUtil.getNull((String)parameterMap.get("del"));
//        String vvd = JSPUtil.getNull((String)parameterMap.get("vvd"));
//        String vsl_cd = "";
//        String skd_voy_no = "";
//        String skd_dir_cd = "";
//        log.info("\n bl_no  : " + bl_no);
//        if(vvd.length()>8){
//            vsl_cd = vvd.substring(0,4);
//            skd_voy_no = vvd.substring(4,8);
//            skd_dir_cd = vvd.substring(8,9);
//        }
//        StringBuffer queryStr = new StringBuffer();
//        if(!cntr_no.equals((""))){
//            queryStr.append(" SELECT a.vc, a.so, a.sc , A.BKG_NO, A.BKG_NO_SPLIT, H.CNTR_NO, h.por_cd, h.pol_cd, h.pod_cd, h.del_cd         \n");
//            queryStr.append("   , C.EDI_STND_STS_CD sts_cd, h.cop_no,a.edi_grp_cd, st.EDI_STS_SEQ seq,  st.EDI_STS_DESC  STS_DESC                        \n");
//            queryStr.append("     FROM SCE_COP_HDR H, EDI_GRP_CGO C, EDI_CGO_STND_STS st,                             \n");// bkg_bkg_cust 전환과 무관
//            queryStr.append("         (                                                                                         \n");
//            queryStr.append(" 			select /*+ ordered                                                           \n");                                 
//            queryStr.append(" 			      index(b XPKBKG_BOOKING)                                                \n");
//            queryStr.append(" 			      index(c XPKBKG_BKG_CUST)                                               \n");
//            queryStr.append(" 			      index(e XPKEDI_GROUP_CUSTOMER) */                                      \n");
//            queryStr.append(" 			     c.bkg_no bkg_no, c.bkg_no_split bkg_no_split , b.bl_no, b.bl_no_tp, b.bl_no_chk                           \n");
//            queryStr.append(" 			    , e.EDI_GRP_CD edi_grp_cd, VSL_CD vc, SKD_VOY_NO so, SKD_DIR_CD sc       \n"); 
//            queryStr.append(" 			from  bkg_booking b, bkg_bkg_cust c , EDI_GRP_CUST e                         \n");         
//            queryStr.append(" 			where (b.bkg_no, b.BKG_NO_SPLIT) in                                          \n");
//            queryStr.append(" 			(                                                                            \n");
//            queryStr.append(" 			   select bkg_no, bkg_no_split                                               \n");
//            queryStr.append(" 			     from sce_cop_hdr                                                        \n");// bkg_bkg_cust 전환과 무관
//            queryStr.append(" 			    where cntr_no = ?                                                   \n");
//            queryStr.append(" 			)                                                                            \n");
//            queryStr.append(" 			and b.bkg_no = c.bkg_no                                                      \n");
//            queryStr.append(" 			and b.BKG_NO_SPLIT = c.BKG_NO_SPLIT                                          \n");
//            queryStr.append(" 			and c.CUST_CNT_CD = e.CUST_CNT_CD                                            \n");
//            queryStr.append(" 			and c.CUST_SEQ    = e.CUST_SEQ                                               \n");
//            queryStr.append(" 			and e.EDI_GRP_CD = ?                                                \n");
////            queryStr.append(" 			and e.CGO_TRC_SVC_FLG = 'Y'                                                  \n");
//            queryStr.append(" 			and c.CUST_CNT_CD is not null                                                \n");
//            queryStr.append(" 			and c.CUST_SEQ is not null                                                   \n");
//            queryStr.append(" 			                                                                             \n");
//            queryStr.append(" 			union                                                                        \n");
//            queryStr.append(" 			                                                                             \n");
//            queryStr.append(" 			select  /*+ ordered                                                          \n");
//            queryStr.append(" 			       index(b XPKBKG_BOOKING)                                               \n");
//            queryStr.append(" 			       index(c XPKBKG_BKG_RT_HD)                                             \n");
//            queryStr.append(" 			       index(e XPKEDI_GROUP_CUSTOMER) */                                     \n");
//            queryStr.append(" 			       c.bkg_no, c.bkg_no_split bkg_no_split, b.bl_no, b.bl_no_tp, b.bl_no_chk                                 \n");
//            queryStr.append(" 			   , e.edi_grp_cd  edi_grp_cd, VSL_CD vc, SKD_VOY_NO so, SKD_DIR_CD sc       \n"); 
//            queryStr.append(" 			from bkg_booking b, BKG_BKG_RT_HD c, EDI_GRP_CUST e                          \n");                
//            queryStr.append(" 			where (b.bkg_no, b.BKG_NO_SPLIT) in                                          \n");
//            queryStr.append(" 			(                                                                            \n");
//            queryStr.append(" 			   select bkg_no, bkg_no_split                                               \n");
//            queryStr.append(" 			     from sce_cop_hdr                                                        \n");
//            queryStr.append(" 			    where cntr_no = ?                                                   \n");
//            queryStr.append(" 			)                                                                            \n");
//            queryStr.append(" 			and b.bkg_no = c.bkg_no                                                      \n");
//            
//            queryStr.append("           and b.BKG_NO_SPLIT = c.BKG_NO_SPLIT                                          \n");
//            queryStr.append("           and e.EDI_GRP_CD = ?                                               \n");
//            queryStr.append("           and c.sc_no = e.sc_no                                                        \n");
//            queryStr.append("           and c.sc_no is not null                                                      \n");
//            
//            queryStr.append("            ) A                                                                                    \n");
//            queryStr.append("           WHERE   A.BKG_NO = H.BKG_NO                                                     \n");
//            queryStr.append("           AND     A.BKG_NO_SPLIT = H.BKG_NO_SPLIT                                         \n");
//            queryStr.append("           and     h.cop_sts_cd          in ('C', 'T')                                   \n");
//            queryStr.append("           and     c.edi_grp_cd = a.edi_grp_cd                                                   \n");
//            
//            if(!bkg_no.equals("")){
//            	queryStr.append(" 			and a.bkg_no = ?                                                   \n");
//            	queryStr.append("           and a.bkg_no_split = ?                                              ");
//            	if(!bl_no.equals("")){
//            		queryStr.append("		and   a.bl_no = ?                                                    \n");
//            		queryStr.append("		and   a.bl_no_tp = ?                                                 \n");
//            		queryStr.append("		and   a.bl_no_chk = ?                                              \n");
//            	}
//            }
//            else if(!bl_no.equals("")){
//            	queryStr.append(" 			    and a.bl_no = ?                                                   \n");
//            	queryStr.append(" 			    and a.bl_no_tp = ?                                                   \n");
//            	queryStr.append(" 			    and a.bl_no_chk = ?                                                   \n");
//            }
//            
//            if(!por.equals("")){
//                queryStr.append("                   and   h.por_cd = ?                                                \n");
//            }
//            if(!pol.equals("")){
//                queryStr.append("                   and   h.pol_cd = ?                                                \n");
//            }
//            if(!pod.equals("")){
//                queryStr.append("                   and   h.pod_cd = ?                                                \n");
//            }
//            if(!del.equals("")){
//                queryStr.append("                   and   h.del_cd = ?                                                \n");
//            }
//            queryStr.append("           and     c.EDI_STND_STS_CD not in ('VED', 'VET')                                 \n");
//            queryStr.append("           and     C.EDI_STND_STS_CD = st.EDI_STND_STS_CD                                  \n");
//            queryStr.append("           and     ST.EDI_STS_SEQ IS NOT NULL                                              \n");
//        }else if(!bkg_no.equals("") || !bl_no.equals("")){
//            queryStr.append("SELECT     /*+ ordered use_nl( b H E C ST) */ \n");
//            queryStr.append("        H.TRNK_VSL_CD VC, H.TRNK_SKD_VOY_NO SO, H.TRNK_SKD_DIR_CD SC,                            \n");
//            queryStr.append("   H.BKG_NO, h.BKG_NO_SPLIT, H.CNTR_NO, h.por_cd, h.pol_cd, h.pod_cd, h.del_cd,                     \n");
//            queryStr.append("   C.EDI_STND_STS_CD sts_cd, H.cop_no, e.edi_grp_cd, st.EDI_STS_SEQ seq,  st.EDI_STS_DESC  STS_DESC \n");
//            queryStr.append("FROM   bkg_booking b, SCE_COP_HDR H, EDI_GRP_CUST e, EDI_GRP_CGO C, EDI_CGO_STND_STS st                 \n");// bkg_bkg_cust 전환과 무관
//        	if(!bkg_no.equals("")){
//            	queryStr.append(" 		where b.bkg_no = ?                                               \n");
//            	queryStr.append(" 		and b.BKG_NO_SPLIT = ?                                                    \n");
//            	if(!bl_no.equals("")){
//            		queryStr.append("		and   b.bl_no = ?                                                    \n");
//            		queryStr.append("		and   b.bl_no_tp = ?                                                 \n");
//            		queryStr.append("		and   b.bl_no_chk = ?                                              \n");
//            	}
//        	}
//        	else if(!bl_no.equals("")){
//        		queryStr.append("		where b.bl_no = ?                                                    \n");
//        		queryStr.append("		and   b.bl_no_tp = ?                                                 \n");
//        		queryStr.append("		and   b.bl_no_chk = ?                                              \n");
//        	}
//            queryStr.append("and     b.bkg_no            = h.bkg_no       \n");
//            queryStr.append("and     b.bkg_no_split      = h.bkg_no_split \n");
//            queryStr.append("and     h.cop_sts_cd          in ('C', 'T')                                   \n");
//            queryStr.append("AND     E.EDI_GRP_CD        = ?              \n");
//            queryStr.append("and     (   e.CUST_CNT_CD = h.SHPR_CNT_CD       and  e.CUST_SEQ    = h.SHPR_SEQ                          \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.CUST_CNT_CD = h.CNEE_CNT_CD       and  e.CUST_SEQ    = h.CNEE_SEQ                          \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.CUST_CNT_CD = h.ACT_CUST_CNT_CD   and  e.CUST_SEQ    = h.ACT_CUST_SEQ                      \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.CUST_CNT_CD = h.NTFY_CNT_CD       and  e.CUST_SEQ    = h.NTFY_SEQ                          \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.CUST_CNT_CD = h.FRT_FWRD_CNT_CD   and  e.CUST_SEQ    = h.FRT_FWRD_SEQ                      \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.sc_no = h.sc_no                                                                            \n");
//            queryStr.append("        )  \n");                 
//        	if(!por.equals("")){
//                queryStr.append("                   and   h.por_cd = ?                                                \n");
//            }
//            if(!pol.equals("")){
//                queryStr.append("                   and   h.pol_cd = ?                                                \n");
//            }
//            if(!pod.equals("")){
//                queryStr.append("                   and   h.pod_cd = ?                                                \n");
//            }
//            if(!del.equals("")){
//                queryStr.append("                   and   h.del_cd = ?                                                \n");
//            }
//            queryStr.append("and     c.edi_grp_cd = e.edi_grp_cd                                                      \n");
//            queryStr.append("           and     c.EDI_STND_STS_CD not in ('VED', 'VET')                                 \n");
//            queryStr.append("           and     C.EDI_STND_STS_CD = st.EDI_STND_STS_CD                                  \n");
//            queryStr.append("           and     ST.EDI_STS_SEQ IS NOT NULL                                              \n");
//            queryStr.append("AND     H.CNTR_NO <> 'SMCU0000000'                                                  \n");
//        }else{
//            queryStr.append("SELECT /*+ ordered use_nl( H E C ST) */                                                                  \n");
//            queryStr.append("        H.TRNK_VSL_CD VC, H.TRNK_SKD_VOY_NO SO, H.TRNK_SKD_DIR_CD SC,                                    \n");
//            queryStr.append("        H.BKG_NO, h.BKG_NO_SPLIT, H.CNTR_NO, h.por_cd, h.pol_cd, h.pod_cd, h.del_cd,                     \n");
//            queryStr.append("        C.EDI_STND_STS_CD sts_cd, H.cop_no, e.edi_grp_cd, st.EDI_STS_SEQ seq,  st.EDI_STS_DESC  STS_DESC \n");
//            queryStr.append("FROM SCE_COP_HDR H, EDI_GRP_CUST e, EDI_GRP_CGO C, EDI_CGO_STND_STS st                                   \n");// bkg_bkg_cust 전환과 무관
//            queryStr.append("WHERE   H.TRNK_VSL_CD       = ?                                                                     \n");
//            queryStr.append("and     H.TRNK_SKD_VOY_NO   = ?                                                                     \n");
//            queryStr.append("and     H.TRNK_SKD_DIR_CD   = ?                                                                     \n");
//            queryStr.append("AND     E.EDI_GRP_CD        = ?                                                                     \n");
//            queryStr.append("and     (   e.CUST_CNT_CD = h.SHPR_CNT_CD       and  e.CUST_SEQ    = h.SHPR_SEQ                          \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.CUST_CNT_CD = h.CNEE_CNT_CD       and  e.CUST_SEQ    = h.CNEE_SEQ                          \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.CUST_CNT_CD = h.ACT_CUST_CNT_CD   and  e.CUST_SEQ    = h.ACT_CUST_SEQ                      \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.CUST_CNT_CD = h.NTFY_CNT_CD       and  e.CUST_SEQ    = h.NTFY_SEQ                          \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.CUST_CNT_CD = h.FRT_FWRD_CNT_CD   and  e.CUST_SEQ    = h.FRT_FWRD_SEQ                      \n");
//            queryStr.append("            or                                                                                           \n");
//            queryStr.append("            e.sc_no = h.sc_no                                                                            \n");
//            queryStr.append("        )                                                                                                \n");
//            queryStr.append("and     h.cop_sts_cd          in ('C', 'T')                                   \n");
//            queryStr.append("and     c.edi_grp_cd = e.edi_grp_cd                                                                      \n");
//            queryStr.append("and     c.EDI_STND_STS_CD not in ('VED', 'VET')                                                          \n");
//            queryStr.append("and     C.EDI_STND_STS_CD = st.EDI_STND_STS_CD                                                           \n");
//            queryStr.append("and     ST.EDI_STS_SEQ IS NOT NULL                                                                       \n");
//            queryStr.append("AND     H.CNTR_NO <> 'SMCU0000000'                                                  \n");
//            if(!por.equals("")){
//                queryStr.append("and   h.por_cd = ?                                                \n");
//            }
//            if(!pol.equals("")){
//                queryStr.append("and   h.pol_cd = ?                                                \n");
//            }
//            if(!pod.equals("")){
//                queryStr.append("and   h.pod_cd = ?                                                \n");
//            }
//            if(!del.equals("")){
//                queryStr.append("and   h.del_cd = ?                                                \n");
//            }            
//        }
//        
//        
//        return queryStr;
//    }
    
    /**
     * 화주별 EDI standard description을 조회.<br>
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchStsListVO>
     * @throws DAOException
     */
    public List<SearchStsListVO> searchStsList(SearchEDIPerformanceOptionsVO schEpOpts)throws DAOException{
    	
    	log.info("searchStsList is running");
    	DBRowSet dbRowset = null;
		List<SearchStsListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchStsListRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchStsListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
    
    /**
     * 운항 정보(VSK_VSL_PORT_SKD)를 조회 한다<br>
     * @param SearchVesselSkdOptionsVO schVSlVO
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchVesselSkd(SearchVesselSkdOptionsVO schVSlVO) throws DAOException {
    	log.info("###EsdSce0063 - searchVesselSkd is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			
			if (schVSlVO != null) {
				Map<String, String> mapVO = schVSlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("###EsdSce0063 - SearchVesselSkdOptionsVO is just set!");
			}//if
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchVesselSkdRSQL(),
					param, velParam);
            return dbRowset;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    	
    }

	/**
     * 운항 정보(VSK_VSL_PORT_SKD)를 조회(count)<br>
	 * @param SearchVesselSkdOptionsVO schVSlVO
	 * @return int
	 * @throws DAOException
	 */
    public int searchVesselSkdCnt(SearchVesselSkdOptionsVO schVSlVO) throws DAOException {
    	log.info("###EsdSce0063 - searchTotalVesselSkdCnt is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schVSlVO != null) {
				Map<String, String> mapVO = schVSlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("###EsdSce0063 - SearchTotalVesselSkdListOptionsVO is just set!");
			}//if

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchVesselSkdCntRSQL(),
					param, velParam);
		    if(dbRowset.getRowCount()>0){
		    	dbRowset.next();
		    	return dbRowset.getInt(1);
		    }else{
		    	return 0;
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
	/**
	 * edi Performance Report Missing 조회
	 * bkg_bkg_cust 사용 추가 : 2002701 iskim
	 * 
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchEDIPerformanceReport(SearchEDIPerformanceOptionsVO schEpOpts)throws DAOException{
    	
    	log.info("###EsdSce0072 - searchEDIPerformanceReport is just running.");
    	DBRowSet dbRowset = null;
		//List<SearchEDIPerformanceReportVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					
					
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0072  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	
				
				//cust_cd MULTI 처리
				if (velParam.get("cust_cd") != null
						&& !((String) velParam.get("cust_cd")).trim().equals("")) {
					velParam.put("cust_cd", ((String) velParam.get("cust_cd")).toUpperCase()
							.split(","));
				}//if		
				
				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no") != null
						&& !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[bkg_no]  - " + ((String[])velParam.get("bkg_no")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no") != null
						&& !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[bl_no]  - " + ((String[])velParam.get("bl_no")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no") != null
						&& !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[cntr_no]  - " + ((String[])velParam.get("cntr_no")).length);
				}//if		
				log.info("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
			}
			log.info("###EsdSce0072 - EDI_ARRAY:"  + param.get("edi_sts"));
			log.info("###EsdSce0072 - CUST_ARRAY:" + param.get("cust_cd"));
			log.info("###EsdSce0072 - cop_status:" + param.get("cop_status"));
			log.info("###EsdSce0072 - trs_mode_:" + param.get("trs_mode_"));
			log.info("###EsdSce0072 - POL_DATE1:"  + param.get("poletddate1_hidden"));
			log.info("###EsdSce0072 - POL_DATE2:"  + param.get("poletddate2_hidden"));
			log.info("###EsdSce0072 - POd_DATE1:"  + param.get("podetadate1_hidden"));
			log.info("###EsdSce0072 - POd_DATE2:"  + param.get("podetadate2_hidden"));			
			log.info("###EsdSce0072 - POL:"  + param.get("pol"));
			
			
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchEDIPerformanceReportRSQL(),
					param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**edi Performance Report on-time-performance 조회
	 * 
	 * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchEDITotalPerformance(SearchEDIPerformanceOptionsVO schEpOpts)throws DAOException{
    	log.info("###EsdSce0072 - searchEDITotalPerformance is just running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0072  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	
				
				//cust_cd MULTI 처리
				if (velParam.get("cust_cd") != null
						&& !((String) velParam.get("cust_cd")).trim().equals("")) {
					velParam.put("cust_cd", ((String) velParam.get("cust_cd")).toUpperCase()
							.split(","));
				}//if		
				
				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no") != null
						&& !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[bkg_no]  - " + ((String[])velParam.get("bkg_no")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no") != null
						&& !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[bl_no]  - " + ((String[])velParam.get("bl_no")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no") != null
						&& !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams[cntr_no]  - " + ((String[])velParam.get("cntr_no")).length);
				}//if		
				log.info("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
			}
			log.info("###EsdSce0072 - EDI_ARRAY:"  + param.get("edi_sts"));
			log.info("###EsdSce0072 - CUST_ARRAY:" + param.get("cust_cd"));
			log.info("###EsdSce0072 - cop_status:" + param.get("cop_status"));
			log.info("###EsdSce0072 - trs_mode_:" + param.get("trs_mode_"));
			log.info("###EsdSce0072 - POL_DATE1:"  + param.get("poletddate1_hidden"));
			log.info("###EsdSce0072 - POL_DATE2:"  + param.get("poletddate2_hidden"));
			log.info("###EsdSce0072 - POd_DATE1:"  + param.get("podetadate1_hidden"));
			log.info("###EsdSce0072 - POd_DATE2:"  + param.get("podetadate2_hidden"));			
			log.info("###EsdSce0072 - POL:"  + param.get("pol"));
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchEDITotalPerformanceRSQL(),
					param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
    
	/**edi Performance Report Combo 조회
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchComboPerformanceVO>
     * @throws DAOException
     */
	public List<SearchComboPerformanceVO> searchComboPerformance(SearchEDIPerformanceOptionsVO schEpOpts) throws DAOException{
		log.info("###EsdSce0072 - searchComboPerformance is just running.");
    	DBRowSet dbRowset = null;
		List<SearchComboPerformanceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.info("###EsdSce0072  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
					log.info("###EsdSce0072  Prams second - " + ((String[])velParam.get("edi_sts")).length);
				}//if					
								
				log.info("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
			}else{
				log.info("###EsdSce0072 - SearchEDIPerformanceOptionsVO is null");
			}
			log.info("###EsdSce0072 - EDI_ARRAY:"  + param.get("edi_sts"));
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchComboPerformanceRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchComboPerformanceVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * edi Cust_sts 조회
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchCustStsVO>
     * @throws DAOException
     */
    public List<SearchCustStsVO> searchCustSts(SearchEDIPerformanceOptionsVO schEPOpts)throws DAOException{
    	log.info("searchCustSts를 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchCustStsVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schEPOpts != null) {
				Map<String, String> mapVO = schEPOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
				}				
				
				log.info("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCustStsRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCustStsVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/** Customer Information 조회(EDI Status)
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchPerCsInfoVO>
     * @throws DAOException
     */
    public List<SearchPerCsInfoVO> searchPerCsInfo(SearchEDIPerformanceOptionsVO schEPOpts)throws DAOException{
    	log.info("searchPerCsInfo is running");
    	DBRowSet dbRowset = null;
		List<SearchPerCsInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schEPOpts != null) {
				Map<String, String> mapVO = schEPOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//MULTI 처리
				if (velParam.get("edi_sts") != null
						&& !((String) velParam.get("edi_sts")).trim().equals("")) {
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
							.split(","));
				}				
				log.info(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchPerCsInfoRSQL(),
					param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchPerCsInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;    	
    }
    
    /** EDI Customer TP ID Information 조회
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchPerCsTpIdInfo(SearchEDIPerformanceOptionsVO custOpts)throws DAOException{
    	log.info("searchPerCsTpIdInfo is running.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try {
			if (custOpts != null) {
				Map<String, String> mapVO = custOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}						
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchPerCsTpIdInfoRSQL(),
					param, velParam);  
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;		
    }
    
    /** Missing List popup count 
     * 
     * @param parameterMap
     * @param iPage
     * @return
     * @throws DAOException
     */
//    public int searchMissingCnt(HashMap parameterMap) throws DAOException{
//    	Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        int i = 1;
//        
//        String diff       = JSPUtil.getNull((String)parameterMap.get("diff"));
//        String cs_grp_id   = JSPUtil.getNull((String)parameterMap.get("cs_grp_id"));   //grp_cd
//        String vvd          = JSPUtil.getNull((String)parameterMap.get("vvd"));
//        String por          = JSPUtil.getNull((String)parameterMap.get("por"));
//        String pol          = JSPUtil.getNull((String)parameterMap.get("pol"));
//        String pod          = JSPUtil.getNull((String)parameterMap.get("pod"));
//        String del          = JSPUtil.getNull((String)parameterMap.get("del"));
//        String edi_sts      = JSPUtil.getNull((String)parameterMap.get("edi_sts"));        // edi_sts
//        String cust_sts      = JSPUtil.getNull((String)parameterMap.get("cust_sts"));      // cust_sts
//        String trs_mode     = JSPUtil.getNull((String)parameterMap.get("trs_mode"));
//        String bkg_no       = JSPUtil.getNull((String)parameterMap.get("bkgno"));     // bkg_no
//        String bl_no        = JSPUtil.getNull((String)parameterMap.get("blno"));      // bl_no
//        String cntr_no      = JSPUtil.getNull((String)parameterMap.get("cntrno"));    // cntr_no
//        String cop_status   = JSPUtil.getNull((String)parameterMap.get("cop_status"));
//        
//        String pol_fromdate = JSPUtil.getNull((String)parameterMap.get("poletdDate1")).replaceAll("-","");
//        String pol_todate = JSPUtil.getNull((String)parameterMap.get("poletdDate2")).replaceAll("-","");
//        String pod_fromdate = JSPUtil.getNull((String)parameterMap.get("podetaDate1")).replaceAll("-","");
//        String pod_todate = JSPUtil.getNull((String)parameterMap.get("podetaDate2")).replaceAll("-","");
//        
//        StringBuffer questExp = new StringBuffer();
//        StringBuffer queryStr = new StringBuffer();
//        
//        String [] vvdArray = new String[0];
//        String [] bkgArray  = new String[0];
//        String [] blArray   = new String[0];
//        String [] cntrArray = new String[0];
//        
//        if(!vvd.equals("")){
//        	vvdArray = vvd.split(",");
//        }
//        if(!bkg_no.equals("")){
//        	bkgArray = bkg_no.split(",");
//        }
//        if(!bl_no.equals("")){
//        	blArray = bl_no.split(",");
//        }
//        if(!cntr_no.equals("")){
//        	cntrArray = cntr_no.split(",");
//        }
//        
//        queryStr.append("  select count(L.vvd)									 \n");
//        queryStr.append("  from (     \n");
//        queryStr.append("       select /*+ USE_NL(sts dtl) */  \n");
//        queryStr.append("			  DISTINCT dtl.vvd, dtl.bkg_no, dtl.bkg_no_split, dtl.cntr_no,  dtl.por_cd, dtl.pol_cd,       \n");
//        queryStr.append("    		   dtl.pod_cd,  dtl.del_cd, '' ,  dtl.EDI_STS_CD, dtl.edi_sub_sts_cd,dtl.edi_snd_knt,   \n");
//        queryStr.append("    			dtl.act_dt1, dtl.act_dt2, nod_cd, dtl.cre_dt1, dtl.cre_dt2,'0' , dtl.cop_no,    \n");
//        queryStr.append("    			dtl.bl_no, sts.edi_sts_seq sort_seq, dtl.act_dt1||dtl.act_dt2 sort_dt, max_edi_snd_knt,   \n");
//        queryStr.append("   			dtl.gmt_dt1,  dtl.gmt_dt2, rownum no   \n");
//        queryStr.append("  		from (   \n");
//        queryStr.append("    		select --  /*+ USE_NL(a r) */    \n");
//        queryStr.append("				   --  /*+leading(r) USE_HASH(A,r)*/	\n");
//        queryStr.append("				vvd, a.bkg_no, a.bkg_no_split, a.cntr_no, por_cd,  pol_cd, pod_cd,  del_cd,   '' flg,    \n");
//        queryStr.append("   			a.EDI_STS_CD, r.edi_snd_knt ,to_char(r.act_dt, 'yyyymmdd') act_dt1, to_char(r.act_dt, 'hh24miss') act_dt2,  \n");
//        queryStr.append("   			r.nod_cd , to_char(r.upd_dt, 'yyyymmdd') cre_dt1,to_char(r.upd_dt, 'hh24miss') cre_dt2,     \n");
//        queryStr.append("   			a.cop_no ,  r.bl_no,  r.act_dt, a.edi_sub_sts_cd ,r.max_edi_snd_knt max_edi_snd_knt  \n");
//        queryStr.append("  				,to_char(r.gmt_dt, 'yyyymmdd') gmt_dt1, to_char(r.gmt_dt, 'hh24miss') gmt_dt2 --20071129 LocalTime   \n");
//        queryStr.append("				,a.exp_ind       \n");			
//        queryStr.append("  			from (   \n");
//        
//        queryStr.append("   			select /*+ index(d XAK5SCE_EDI_SND_RSLT) */  \n");
//        queryStr.append("						d.EDI_GRP_CD, d.bkg_no, d.bkg_no_split, d.cntr_no, d.EDI_STS_CD,d.EDI_SUB_STS_CD     \n");
//        queryStr.append("  						,d.act_dt, d.gmt_dt, d.edi_snd_knt EDI_SND_KNt, d.upd_dt, d.nod_cd   \n");
//        queryStr.append("						,BL_NO||BL_NO_TP||BL_NO_CHK bl_no    \n");
//        queryStr.append("  						,MAX(d.EDI_SND_KNT) OVER ( PARTITION BY d.bkg_no, d.bkg_no_split, d.cntr_no, d.EDI_STS_CD, d.EDI_SUB_STS_CD) max_edi_snd_knt   \n");
//        queryStr.append("   			from  SCE_EDI_SND_RSLT d  \n");
//        
//        if((vvd.equals("")) && (bkg_no.equals("")) && (bl_no.equals("")) && (cntr_no.equals(""))){
//	        queryStr.append("  					 , ( 	SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */  VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd   \n");
//	        queryStr.append("        				FROM  VSK_VSL_PORT_SKD    \n");
//	        queryStr.append("      					WHERE NVL(CNG_STS_CD, ' ') <> 'S'        \n");
//	        queryStr.append("         					AND CLPT_IND_SEQ = '1'    \n");
//	        
//	        if((!pol_fromdate.equals("")) || (!pol_todate.equals(""))){
//	        	queryStr.append("   				     AND  VPS_ETD_DT BETWEEN TO_DATE( '"+pol_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pol_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("                        and VPS_PORT_CD LIKE  '"+pol+"%'   \n");
//	        	queryStr.append("                        and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   \n"); 
//	        }
//	        
//	        if((!pod_fromdate.equals("")) || (!pod_todate.equals(""))){
//	        	queryStr.append("   				     AND VPS_ETA_DT BETWEEN TO_DATE( '"+pod_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pod_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("                        and VPS_PORT_CD LIKE  '"+pod+"%'   \n");
//	        	queryStr.append("                        and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  \n");
//	        }
//	        queryStr.append("               ) v          \n");
//	        queryStr.append("        		where d.VSL_CD      = substr(v.vvd, 1, 4)    \n");
//	        queryStr.append("       			  and d.SKD_VOY_NO  = substr(v.vvd, 5, 4)     \n");
//	        queryStr.append("     		   		  and d.SKD_DIR_CD  = substr(v.vvd, 9, 1)    \n");
//	        
//    	} else if(!bkg_no.equals("")){  
//    		if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < bkgArray.length -1 ; j++){
//        		questExp.append(",(?,decode(?,'','  ',?))");
//        	}
//        	queryStr.append("			where (d.bkg_no, d.bkg_no_split) in ((?,decode(?,'','  ',?))	    \n");
//        	queryStr.append("                " + questExp.toString() + "  ) \n");
//    	} else if(!bl_no.equals("")){  
//    		if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < blArray.length -1 ; j++){
//        		questExp.append(",(?,?,?)");
//        	}
//        	queryStr.append("			, (   select bkg_no, bkg_no_split from bkg_booking	\n");
//        	queryStr.append("				where (bl_no,bl_no_tp,bl_no_chk) in ((?,?,?) 		\n");
//        	queryStr.append("                " + questExp.toString() + "   ) \n");
//        	queryStr.append("				) v   			\n");
//        	queryStr.append("			where d.bkg_no_split = v.bkg_no_split		\n");
//        	queryStr.append("				and d.bkg_no = v.bkg_no  	\n");
//    	} else if(!cntr_no.equals("")){  
//    		if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < cntrArray.length -1 ; j++){
//        		questExp.append(",?");
//        	}
//        	queryStr.append("			where d.CNTR_NO in (?	    \n");
//        	queryStr.append("                " + questExp.toString() + " ,''  ) \n");
//    	} else if(!vvd.equals("")){
//    		if ( questExp.length() > 1 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < vvdArray.length -1 ; j++){
//        		questExp.append(",?");
//        		
//        	}
//        	queryStr.append("				 where d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD  in ( ?  ");
//	        queryStr.append("                " + questExp.toString() + ") \n");
//    	}
//        
//        queryStr.append("					  and d.EDI_STS_CD = '"+edi_sts+"'          \n");
//        queryStr.append("					  and d.EDI_SUB_STS_CD = '"+cust_sts+"'          \n");
//        queryStr.append("    				  and d.EDI_GRP_CD  = '"+cs_grp_id+"'    ) r ,                        -- join 1    \n");
//        
//        queryStr.append("        ( SELECT /*+ USE_NL(hb e cgo) */ distinct hb.vvd,hb.bkg_no,hb.bkg_no_split, hb.cntr_no, hb.por_cd ,  hb.pol_cd, hb.pod_cd,   \n");
//        queryStr.append("           	hb.del_cd , cgo.EDI_STND_STS_CD edi_sts_cd , cgo.cust_edi_sts_cd edi_sub_sts_cd --20071114     \n");
//        queryStr.append("          		, e.edi_grp_cd edi_grp_cd, hb.cop_no,   \n");
//        queryStr.append("				case when    \n");	
//        queryStr.append("                 --T/S 가 없는 Shipment          \n");
//        queryStr.append("                         (ts_chk is null  and cgo.EDI_STND_STS_CD in ('VAT','UVT','AET','VDT'))   \n");
//        queryStr.append("                 --O/B 구간 Rail이 아닌 Shipment   \n");
//        queryStr.append("                         or (substr(rail_chk, 1, 1) <> 'I'  and cgo.EDI_STND_STS_CD in ('ALO','RLO','ARO','URO','FOTRDO','FOTRAD'))   \n");
//        queryStr.append("                 --I/B 구간 Rail이 아닌 Shipment   \n");
//        queryStr.append("						   or (substr(rail_chk, 2, 1) <> 'I' and cgo.EDI_STND_STS_CD in ('ALN','RLN','ARN','URN','FITRAD',	'FITRDO','AVN',	'ACN','AFN', 'AON',  'NT'))   \n");
//        queryStr.append("                  --I/B 구간 Rail이 아닌 Shipment    \n");
//        queryStr.append("                         or  (substr(rail_chk, 2, 1) = 'I' and  cgo.EDI_STND_STS_CD in ('AVL','ACL','AFL','AOL'))    \n");
//        queryStr.append("                  --DEL이 ‘US’가 아닌 것       \n");
//        queryStr.append("                         or (substr(del_cd, 1, 2) <> 'US' and  cgo.EDI_STND_STS_CD in ('CT','CC','CU','HR','PA','PQ','AVN','AVL','ACN','ACL'))    \n");
//        queryStr.append("                  --DEL이 ‘CA,MX’가 아닌 것    \n");
//        queryStr.append("                         or (substr(del_cd, 1, 2) <> 'CA' and substr(del_cd, 1, 2) <> 'MX' and cgo.EDI_STND_STS_CD in ('OB','AFN','AFL','AON','AOL')) \n");
//        queryStr.append("                  --DEL이 ‘US,CA,MX’가 아닌 것         \n");
//        queryStr.append("                         or (substr(del_cd, 1, 2) <> 'US' and substr(del_cd, 1, 2) <> 'CA' and substr(del_cd, 1, 2) <> 'MX' and cgo.EDI_STND_STS_CD in ('NFT','FTR'))   \n");
//        queryStr.append("                  then    \n");
//        queryStr.append("                     'EXP'   \n");
//        queryStr.append("                  else 'N/A'    \n");
//        queryStr.append("                  end EXP_IND    \n");
//        queryStr.append("     FROM (        \n");
//        queryStr.append("         SELECT /*+ ordered */   DISTINCT  h.trnk_vsl_cd||h.trnk_skd_voy_no||h.trnk_skd_dir_cd vvd,        \n");
//        queryStr.append("                h.bkg_no, h.bkg_no_split, h.cntr_no,  h.por_cd, h.pol_cd, h.pod_cd, h.del_cd,    h.cop_no,  \n");
//        queryStr.append("           	 h.sc_no, h.shpr_cnt_cd, h.shpr_seq, h.cnee_cnt_cd,     \n");
//        queryStr.append("         		h.cnee_seq, h.act_cust_cnt_cd, h.act_cust_seq, h.ntfy_cnt_cd, h.ntfy_seq, h.frt_fwrd_cnt_cd, h.frt_fwrd_seq     \n");
//        queryStr.append("         		,h.edi_cnt_cd, h.edi_seq, h.COP_RAIL_CHK_CD rail_chk, h.N1ST_TS_PORT_CD ts_chk   	\n");
//        
//        if((vvd.equals("")) && (bkg_no.equals("")) && (bl_no.equals("")) && (cntr_no.equals(""))){
//	        queryStr.append("		from	( SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD)     */        \n");
//	        queryStr.append("				VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd  \n");
//	        queryStr.append("			FROM VSK_VSL_PORT_SKD	\n");
//	        queryStr.append("			where NVL(CNG_STS_CD, ' ') <> 'S'	\n");
//	        queryStr.append("				AND CLPT_IND_SEQ = '1'   \n");
//	        
//	        if((!pol_fromdate.equals("")) || (!pol_todate.equals(""))){
//	        	queryStr.append("   		AND  VPS_ETD_DT BETWEEN TO_DATE( '"+pol_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pol_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("           and VPS_PORT_CD LIKE  '"+pol+"%'   \n");
//	        	queryStr.append("           and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   \n"); 
//	        }
//	        
//	        if((!pod_fromdate.equals("")) || (!pod_todate.equals(""))){
//	        	queryStr.append("   		AND VPS_ETA_DT BETWEEN TO_DATE( '"+pod_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pod_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("           and VPS_PORT_CD LIKE  '"+pod+"%'   \n");
//	        	queryStr.append("           and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  \n");
//	        }
//	        
//	        queryStr.append("			) v	, sce_cop_hdr h	\n"); // 수정 요망
//	        queryStr.append("			where  h.TRNK_VSL_CD = substr(v.vvd, 1, 4) 		\n");
//	        queryStr.append("        and      h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4) 		\n");
//	        queryStr.append("        and      h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1) 		\n");
//        } else if(!bkg_no.equals("")){  
//        	queryStr.append("		  FROM sce_cop_hdr h     \n"); // 수정 요망
//        	if ( questExp.length() > 1 )        questExp.delete(0, questExp.length());
//        	for(int j = 0 ; j < bkgArray.length -1 ; j++){
//        		questExp.append(",(?,decode(?,'','  ',?))");
//        	}
//	        queryStr.append("                where (h.bkg_no, h.bkg_no_split)                             \n");
//	        queryStr.append("                    in ((?,decode(?,'','  ',?)) ");
//	        queryStr.append("                " + questExp.toString() + ") \n");
//    	} else if(!bl_no.equals("")){  
////    		queryStr.append("		  FROM sce_cop_hdr h     \n");
//    		if ( questExp.length() > 1 )        questExp.delete(0, questExp.length());
//        	for(int j = 0 ; j < blArray.length -1 ; j++){
//        		questExp.append(",(?,?,?)");
//        	}
//        	queryStr.append("			from (   select bkg_no, bkg_no_split from bkg_booking	\n");
//        	queryStr.append("				where (bl_no,bl_no_tp,bl_no_chk) in ((?,?,?) 		\n");
//        	queryStr.append("                " + questExp.toString() + "   ) \n");
//        	queryStr.append("				) v ,sce_cop_hdr h       \n");
//        	queryStr.append("			where h.bkg_no_split = v.bkg_no_split		\n");
//        	queryStr.append("				and h.bkg_no = v.bkg_no  	\n");
//    	} else if(!cntr_no.equals("")){  
//    		queryStr.append("		  FROM sce_cop_hdr h     \n");
//    		if ( questExp.length() > 1 )        questExp.delete(0, questExp.length());
//        	for(int j = 0 ; j < cntrArray.length -1 ; j++){
//        		questExp.append(",?");
//        	}
//	        queryStr.append("                where h.cntr_no in ( ?");
//	        queryStr.append("                " + questExp.toString() + ") \n");
//    	} else if(!vvd.equals("")){
//    		queryStr.append("		  FROM sce_cop_hdr h     \n");
//        	if ( questExp.length() > 1 )        questExp.delete(0, questExp.length());
//        	for(int j = 0 ; j < vvdArray.length -1 ; j++){
//        		questExp.append(",?");
//        	}
//	        queryStr.append(" 			      where h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD  in ( ?  ");
//	        queryStr.append("                " + questExp.toString() + " ) \n");
//        }
//        if(cop_status.equals("C")){
//        	queryStr.append("              and      h.cop_sts_cd  = 'F'			            \n");
//        } else if(cop_status.equals("I")){
//        	queryStr.append("              and      h.cop_sts_cd  = 'T'			            \n");
//        } else {
//        	queryStr.append("			and  h.cop_sts_cd  IN ('C', 'T', 'F')  \n");        	
//        }
//        queryStr.append("        	AND      h.cntr_no <> 'SMCU0000000'   		\n");
//        
//        if(!por.equals("")){
//  	        queryStr.append("                AND h.por_cd LIKE '"+por+"%'                                                             \n");
//        }
//        if(!pol.equals("")){
//  	        queryStr.append("                AND h.pol_cd LIKE '"+pol+"%'                                                             \n");
//        }
//        if(!pod.equals("")){
//  	        queryStr.append("                AND h.pod_cd LIKE '"+pod+"%'                                                             \n");
//        }
//        if(!del.equals("")){
//  	        queryStr.append("                AND h.del_cd LIKE '"+del+"%'                                                             \n");
//        }
//        
//        if(!trs_mode.equals("A")){
//        	if(trs_mode.equals("Y")){
//        		queryStr.append("                AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) IN ('OI', 'XI')   \n");
//        	}else{
//        		queryStr.append("                AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) NOT IN ('OI', 'XI')    \n");
//        	}
//        }
//        queryStr.append("     ) hb,    EDI_GRP_CUST e,	edi_grp_cgo cgo, bkg_bkg_cust bkg_cust	\n");
////        queryStr.append("      WHERE ( (hb.shpr_cnt_cd = e.cust_cnt_cd AND hb.shpr_seq = e.cust_seq)  		\n");
////        queryStr.append("          OR (hb.cnee_cnt_cd = e.cust_cnt_cd	AND hb.cnee_seq = e.cust_seq)	\n");
////        queryStr.append("         OR (hb.act_cust_cnt_cd = e.cust_cnt_cd AND hb.act_cust_seq = e.cust_seq)		\n");
////        queryStr.append("         OR (hb.ntfy_cnt_cd = e.cust_cnt_cd AND hb.ntfy_seq = e.cust_seq)		\n");
////        queryStr.append("         OR (hb.frt_fwrd_cnt_cd = e.cust_cnt_cd	AND hb.frt_fwrd_seq = e.cust_seq)	\n");
////        queryStr.append("         OR (hb.edi_cnt_cd = e.cust_cnt_cd	AND hb.edi_seq = e.cust_seq)	\n");
////        queryStr.append("         OR (hb.sc_no = e.sc_no) )		\n");
//        
////      bkg_bkg_cust 사용 추가 : 2002701 iskim
//        queryStr.append("WHERE hb.bkg_no = bkg_cust.bkg_no \n") ;
//        queryStr.append("                  and hb.bkg_no_split = bkg_cust.bkg_no_split \n") ;
//        queryStr.append("                  and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- S \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'S' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- C \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'C' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- A \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'A' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- N \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'N' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- F \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'F' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- E \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'E' ) \n") ;
//        queryStr.append("                      or (hb.sc_no = e.sc_no ) ) \n") ;
//        
//        
//        queryStr.append("     AND E.EDI_GRP_CD = '"+cs_grp_id+"'    		\n");
//        queryStr.append("     AND cgo.EDI_STND_STS_CD in ('"+edi_sts+"')    		\n");
//        queryStr.append("     AND e.edi_grp_cd = cgo.edi_grp_cd     		\n");
//        queryStr.append("	  and E.CGO_TRC_SVC_FLG <> 'N'  \n");
//        queryStr.append("    ) a  -- 조인 2     		\n");
//        queryStr.append("	where a.edi_grp_cd = r.EDI_GRP_CD(+)	\n");
//        queryStr.append("		and a.bkg_no = r.bkg_no(+)	\n");
//        queryStr.append("		and a.bkg_no_split = r.bkg_no_split(+)	\n");
//        queryStr.append("		and a.cntr_no = r.cntr_no(+) 	\n");
//        queryStr.append("		and a.EDI_STS_CD = r.EDI_STS_CD(+)	\n");
//        queryStr.append("		and a.edi_sub_sts_cd = r.edi_sub_sts_cd(+)	\n");
//        queryStr.append("		and r.EDI_SND_KNt(+) = 1 ) dtl , EDI_CGO_STND_STS sts	\n");
//        queryStr.append("	where sts.EDI_STND_STS_CD = dtl.edi_sts_cd	\n");
//        queryStr.append("		and dtl.exp_ind   = 'N/A'   \n");
//        
//        if(diff.equals("1")){    //Missing 일경우에는 주석 처리~~~
//        	queryStr.append("     and dtl.gmt_dt2 is null  	\n");
//        } 
//        queryStr.append("	  and dtl.edi_sts_cd  in ('"+edi_sts+"')   \n");
//    	queryStr.append("		 and dtl.edi_sub_sts_cd = '"+cust_sts+"' 	\n");        
//        queryStr.append("	order by vvd, bkg_no, bkg_no_split, cntr_no, sort_seq, max_edi_snd_knt, dtl.edi_snd_knt ) L    \n");
//        try{
//        	con = getConnection(); 
//        	if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//                ps = new LoggableStatement(con, queryStr.toString());
//            }else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//        	
//        	String bkgTemp1 = "";
//            String bkgSplitTemp1 = "";
//            
//        	if(!bkg_no.equals("")){
//        		for(int j = 0 ; j < bkgArray.length ; j++){
//                	if(bkgArray[j].length() > 11){
//                		bkgTemp1 = bkgArray[j].substring(0,11);
//                		bkgSplitTemp1 = bkgArray[j].substring(11);
//                	}else{
//                		bkgTemp1 = bkgArray[j];
//                	}
//            		ps.setString(i++, bkgTemp1);
//            		ps.setString(i++, bkgSplitTemp1);
//            		ps.setString(i++, bkgSplitTemp1);
//            	}
//        	} else if(!bl_no.equals("")){
//        		String Temp1 = "";
//                String Temp2 = "";
//                String Temp3 = "";
//                for(int j = 0 ; j < blArray.length ; j++){
//                	if(blArray[j].length() > 10){
//                		Temp1 = blArray[j].substring(0,10);
//                		Temp2 = blArray[j].substring(10,11);
//                		if(blArray[j].length() > 11){
//                			Temp3 = blArray[j].substring(11);
//                		}
//                	}else{
//                		Temp1 = blArray[j];
//                	}
//            		ps.setString(i++, Temp1);
//            		ps.setString(i++, Temp2);
//            		ps.setString(i++, Temp3);
//            	}
//        	} else if(!cntr_no.equals("")){
//        		for(int j = 0 ; j < cntrArray.length ; j++){
//	        		ps.setString(i++, cntrArray[j]);
//	        	}
//        	} else if(!vvd.equals("")){
//	            for(int j = 0 ; j < vvdArray.length ; j++){
//	        		ps.setString(i++, vvdArray[j]);
//	        	}
//            }
//        	
//        	String bkgTemp = "";
//            String bkgSplitTemp = "";
//        	if(!bkg_no.equals("")){
//        		for(int j = 0 ; j < bkgArray.length ; j++){
//                	if(bkgArray[j].length() > 11){
//                		bkgTemp = bkgArray[j].substring(0,11);
//                		bkgSplitTemp = bkgArray[j].substring(11);
//                	}else{
//                		bkgTemp = bkgArray[j];
//                	}
//            		ps.setString(i++, bkgTemp);
//            		ps.setString(i++, bkgSplitTemp);
//            		ps.setString(i++, bkgSplitTemp);
//            	}
//        	} else if(!bl_no.equals("")){
//        		String bl_1 = "";
//                String bl_2 = "";
//                String bl_3 = "";
//                for(int j = 0 ; j < blArray.length ; j++){
//                	if(blArray[j].length() > 10){
//                		bl_1 = blArray[j].substring(0,10);
//                		bl_2 = blArray[j].substring(10,11);
//                		if(blArray[j].length() > 11){
//                			bl_3 = blArray[j].substring(11);
//                		}
//                	}else{
//                		bl_1 = blArray[j];
//                	}
//            		ps.setString(i++, bl_1);
//            		ps.setString(i++, bl_2);
//            		ps.setString(i++, bl_3);
//            	} 
//        	} else if(!cntr_no.equals("")){
//        		for(int j = 0 ; j < cntrArray.length ; j++){
//            		ps.setString(i++, cntrArray[j]);
//            	}
//        	} else if(!vvd.equals("")){
//	            for(int j = 0 ; j < vvdArray.length ; j++){
//	        		ps.setString(i++, vvdArray[j]);
//	        	}
//            }
//
//        	log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//        	rs = ps.executeQuery();
//        	
//        	if (rs.next()) {
//				return rs.getInt(1);
//			}
//			return 0;
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//		}
//    }
//    
    
    /** 
     * Missing List popup 조회 
     * 
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws DAOException
     */
    public List<SearchMissingListVO> searchMissingList(SearchMissingListVO searchMissingListVo) throws DAOException{ 
    	
    	log.info("searchMissingsList is running");
    	DBRowSet dbRowset = null;
    	List<SearchMissingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchMissingListVo != null) {
				searchMissingListVo.unDataFormat();
				Map<String, String> mapVO = searchMissingListVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				
				log.info("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
log.info("searchMissingListVo:"+searchMissingListVo.toString());	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no") != null
						&& !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0074  Prams[bkg_no]  - " + ((String[])velParam.get("bkg_no")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no") != null
						&& !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0074  Prams[bl_no]  - " + ((String[])velParam.get("bl_no")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0074  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no") != null
						&& !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0074  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no")).length);
				}//if
				

				log.info("###EsdSce0074 - SearchEdiSummaryReportOptionsVO is just set!");			
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchMissingListRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchMissingListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;    	
    }
//    public DBRowSet searchMissingList(HashMap parameterMap,int iPage) throws DAOException{
//    	Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        DBRowSet dRs = null;                // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//        int i = 1;
//        
//        String diff       = JSPUtil.getNull((String)parameterMap.get("diff"));
//        String cs_grp_id   = JSPUtil.getNull((String)parameterMap.get("cs_grp_id"));   //grp_cd
//        String vvd          = JSPUtil.getNull((String)parameterMap.get("vvd"));
//        String por          = JSPUtil.getNull((String)parameterMap.get("por"));
//        String pol          = JSPUtil.getNull((String)parameterMap.get("pol"));
//        String pod          = JSPUtil.getNull((String)parameterMap.get("pod"));
//        String del          = JSPUtil.getNull((String)parameterMap.get("del"));
//        String edi_sts      = JSPUtil.getNull((String)parameterMap.get("edi_sts"));        // edi_sts
//        String cust_sts      = JSPUtil.getNull((String)parameterMap.get("cust_sts"));      // cust_sts
//        String trs_mode     = JSPUtil.getNull((String)parameterMap.get("trs_mode"));
//        String bkg_no       = JSPUtil.getNull((String)parameterMap.get("bkgno"));     // bkg_no
//        String bl_no        = JSPUtil.getNull((String)parameterMap.get("blno"));      // bl_no
//        String cntr_no      = JSPUtil.getNull((String)parameterMap.get("cntrno"));    // cntr_no
//        String cop_status   = JSPUtil.getNull((String)parameterMap.get("copsts"));
//        
//        String pol_fromdate = JSPUtil.getNull((String)parameterMap.get("poletdDate1")).replaceAll("-","");
//        String pol_todate = JSPUtil.getNull((String)parameterMap.get("poletdDate2")).replaceAll("-","");
//        String pod_fromdate = JSPUtil.getNull((String)parameterMap.get("podetaDate1")).replaceAll("-","");
//        String pod_todate = JSPUtil.getNull((String)parameterMap.get("podetaDate2")).replaceAll("-","");
//        
//        StringBuffer questExp = new StringBuffer();
//        StringBuffer queryStr = new StringBuffer();
//        
//        String [] vvdArray = new String[0];
//        String [] bkgArray  = new String[0];
//        String [] blArray   = new String[0];
//        String [] cntrArray = new String[0];
//        
//        if(!vvd.equals("")){
//        	vvdArray = vvd.split(",");
//        }
//        if(!bkg_no.equals("")){
//        	bkgArray = bkg_no.split(",");
//        }
//        if(!bl_no.equals("")){
//        	blArray = bl_no.split(",");
//        }
//        if(!cntr_no.equals("")){
//        	cntrArray = cntr_no.split(",");
//        }
//        
////      페이징 처리
//        if(iPage == 0) iPage = 1;
//        
//		int currentPage = iPage;
//		int startPart   = Constants.PAGE_SIZE_300 * (currentPage - 1) + 1;
//		int endPart     = Constants.PAGE_SIZE_300 * currentPage;  
//        
//        queryStr.append("  select  L.vvd,  L.bkg_no,  L.bkg_no_split,  L.bl_no,  L.cntr_no, L.por_cd, L.pol_cd, \n");
//        queryStr.append("  		L.pod_cd, L.del_cd, '' , L.EDI_STS_CD, L.edi_sub_sts_cd, L.edi_snd_knt, L.act_dt1,    \n");
//        queryStr.append("    	L.act_dt2,  L.nod_cd, L.cre_dt1, L.cre_dt2, L.gmt_dt1, L.gmt_dt2,   \n");
//        queryStr.append("   	decode(L.edi_snd_knt, null, '', case when L.max_edi_snd_knt= L.edi_snd_knt then '0' else '' end) rbtn,  \n");
//        queryStr.append("    	L.cop_no     \n");
//        queryStr.append("  from (     \n");
//        queryStr.append("       select /*+ USE_NL(sts dtl) */  \n");
//        queryStr.append("			  DISTINCT dtl.vvd, dtl.bkg_no, dtl.bkg_no_split, dtl.cntr_no,  dtl.por_cd, dtl.pol_cd,       \n");
//        queryStr.append("    		   dtl.pod_cd,  dtl.del_cd, '' ,  dtl.EDI_STS_CD, dtl.edi_sub_sts_cd,dtl.edi_snd_knt,   \n");
//        queryStr.append("    			dtl.act_dt1, dtl.act_dt2, nod_cd, dtl.cre_dt1, dtl.cre_dt2,'0' , dtl.cop_no,    \n");
//        queryStr.append("    			dtl.bl_no, sts.edi_sts_seq sort_seq, dtl.act_dt1||dtl.act_dt2 sort_dt, max_edi_snd_knt,   \n");
//        queryStr.append("   			dtl.gmt_dt1,  dtl.gmt_dt2, rownum no   \n");
//        queryStr.append("  		from (   \n");
//        queryStr.append("    		select --  /*+ USE_NL(a r) */    \n");
//        queryStr.append("				   --  /*+leading(r) USE_HASH(A,r)*/	\n");
//        queryStr.append("				vvd, a.bkg_no, a.bkg_no_split, a.cntr_no, por_cd,  pol_cd, pod_cd,  del_cd,   '' flg,    \n");
//        queryStr.append("   			a.EDI_STS_CD, r.edi_snd_knt ,to_char(r.act_dt, 'yyyymmdd') act_dt1, to_char(r.act_dt, 'hh24miss') act_dt2,  \n");
//        queryStr.append("   			r.nod_cd , to_char(r.upd_dt, 'yyyymmdd') cre_dt1,to_char(r.upd_dt, 'hh24miss') cre_dt2,     \n");
//        queryStr.append("   			a.cop_no ,  a.bl_no,  r.act_dt, a.edi_sub_sts_cd ,r.max_edi_snd_knt max_edi_snd_knt  \n");
//        queryStr.append("  				,to_char(r.gmt_dt, 'yyyymmdd') gmt_dt1, to_char(r.gmt_dt, 'hh24miss') gmt_dt2 --20071129 LocalTime   \n");
//        queryStr.append("				,a.exp_ind       \n");			
//        queryStr.append("  			from (   \n");
//        
//        queryStr.append("   			select /*+ index(d XAK5SCE_EDI_SND_RSLT) */  \n");
//        queryStr.append("						d.EDI_GRP_CD, d.bkg_no, d.bkg_no_split, d.cntr_no, d.EDI_STS_CD,d.EDI_SUB_STS_CD     \n");
//        queryStr.append("  						,d.act_dt, d.gmt_dt, d.edi_snd_knt EDI_SND_KNt, d.upd_dt, d.nod_cd   \n");
////        queryStr.append("						,BL_NO||BL_NO_TP||BL_NO_CHK bl_no    \n");
//        queryStr.append("  						,MAX(d.EDI_SND_KNT) OVER ( PARTITION BY d.bkg_no, d.bkg_no_split, d.cntr_no, d.EDI_STS_CD, d.EDI_SUB_STS_CD) max_edi_snd_knt   \n");
//        queryStr.append("   			from  SCE_EDI_SND_RSLT d  \n");
//        
//        if((vvd.equals("")) && (bkg_no.equals("")) && (bl_no.equals("")) && (cntr_no.equals(""))){
//	        queryStr.append("  					 , ( 	SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */  VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd   \n");
//	        queryStr.append("        				FROM  VSK_VSL_PORT_SKD    \n");
//	        queryStr.append("      					WHERE NVL(CNG_STS_CD, ' ') <> 'S'        \n");
//	        queryStr.append("         					AND CLPT_IND_SEQ = '1'    \n");
//	        
//	        if((!pol_fromdate.equals("")) || (!pol_todate.equals(""))){
//	        	queryStr.append("   				     AND  VPS_ETD_DT BETWEEN TO_DATE( '"+pol_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pol_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("                        and VPS_PORT_CD LIKE  '"+pol+"%'   \n");
//	        	queryStr.append("                        and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   \n"); 
//	        }
//	        
//	        if((!pod_fromdate.equals("")) || (!pod_todate.equals(""))){
//	        	queryStr.append("   				     AND VPS_ETA_DT BETWEEN TO_DATE( '"+pod_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pod_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("                        and VPS_PORT_CD LIKE  '"+pod+"%'   \n");
//	        	queryStr.append("                        and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  \n");
//	        }
//	        queryStr.append("               ) v          \n");
//	        queryStr.append("        		where d.VSL_CD      = substr(v.vvd, 1, 4)    \n");
//	        queryStr.append("       			  and d.SKD_VOY_NO  = substr(v.vvd, 5, 4)     \n");
//	        queryStr.append("     		   		  and d.SKD_DIR_CD  = substr(v.vvd, 9, 1)    \n");
//	        
//    	} else if(!bkg_no.equals("")){  
//    		if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < bkgArray.length -1 ; j++){
//        		questExp.append(",(?,decode(?,'','  ',?))");
//        	}
//        	queryStr.append("			where (d.bkg_no, d.bkg_no_split) in ((?,decode(?,'','  ',?))	    \n");
//        	queryStr.append("                " + questExp.toString() + "  ) \n");
//    	} else if(!bl_no.equals("")){  
//    		if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < blArray.length -1 ; j++){
//        		questExp.append(",(?,?,?)");
//        	}
//        	queryStr.append("			, (   select bkg_no, bkg_no_split from bkg_booking	\n");
//        	queryStr.append("				where (bl_no,bl_no_tp,bl_no_chk) in ((?,?,?) 		\n");
//        	queryStr.append("                " + questExp.toString() + "   ) \n");
//        	queryStr.append("				) v   			\n");
//        	queryStr.append("			where d.bkg_no_split = v.bkg_no_split		\n");
//        	queryStr.append("				and d.bkg_no = v.bkg_no  	\n");
//    	} else if(!cntr_no.equals("")){  
//    		if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < cntrArray.length -1 ; j++){
//        		questExp.append(",?");
//        	}
//        	queryStr.append("			where d.CNTR_NO in (?	    \n");
//        	queryStr.append("                " + questExp.toString() + " ,''  ) \n");
//    	} else if(!vvd.equals("")){
//    		if ( questExp.length() > 1 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < vvdArray.length -1 ; j++){
//        		questExp.append(",?");
//        		
//        	}
//        	queryStr.append("				 where d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD  in ( ?  ");
//	        queryStr.append("                " + questExp.toString() + ") \n");
//    	}
//        
//        queryStr.append("					  and d.EDI_STS_CD = '"+edi_sts+"'          \n");
//        queryStr.append("					  and d.EDI_SUB_STS_CD = '"+cust_sts+"'          \n");
//        queryStr.append("    				  and d.EDI_GRP_CD  = '"+cs_grp_id+"'    ) r ,                        -- join 1    \n");
//        
//        queryStr.append("        ( SELECT /*+ USE_NL(hb e cgo) */ distinct hb.vvd,hb.bkg_no,hb.bkg_no_split, hb.cntr_no, hb.por_cd ,  hb.pol_cd, hb.pod_cd,   \n");
//        queryStr.append("           	hb.del_cd , cgo.EDI_STND_STS_CD edi_sts_cd , cgo.cust_edi_sts_cd edi_sub_sts_cd --20071114     \n");
//        queryStr.append("          		, e.edi_grp_cd edi_grp_cd, hb.cop_no, hb.bl_no,  \n");
//        queryStr.append("				case when    \n");	
//        queryStr.append("                 --T/S 가 없는 Shipment          \n");
//        queryStr.append("                         (ts_chk is null  and cgo.EDI_STND_STS_CD in ('VAT','UVT','AET','VDT'))   \n");
//        queryStr.append("                 --O/B 구간 Rail이 아닌 Shipment   \n");
//        queryStr.append("                         or (substr(rail_chk, 1, 1) <> 'I'  and cgo.EDI_STND_STS_CD in ('ALO','RLO','ARO','URO','FOTRDO','FOTRAD'))   \n");
//        queryStr.append("                 --I/B 구간 Rail이 아닌 Shipment   \n");
//        queryStr.append("						   or (substr(rail_chk, 2, 1) <> 'I' and cgo.EDI_STND_STS_CD in ('ALN','RLN','ARN','URN','FITRAD',	'FITRDO','AVN',	'ACN','AFN', 'AON',  'NT'))   \n");
//        queryStr.append("                  --I/B 구간 Rail이 아닌 Shipment    \n");
//        queryStr.append("                         or  (substr(rail_chk, 2, 1) = 'I' and  cgo.EDI_STND_STS_CD in ('AVL','ACL','AFL','AOL'))    \n");
//        queryStr.append("                  --DEL이 ‘US’가 아닌 것       \n");
//        queryStr.append("                         or (substr(del_cd, 1, 2) <> 'US' and  cgo.EDI_STND_STS_CD in ('CT','CC','CU','HR','PA','PQ','AVN','AVL','ACN','ACL'))    \n");
//        queryStr.append("                  --DEL이 ‘CA,MX’가 아닌 것    \n");
//        queryStr.append("                         or (substr(del_cd, 1, 2) <> 'CA' and substr(del_cd, 1, 2) <> 'MX' and cgo.EDI_STND_STS_CD in ('OB','AFN','AFL','AON','AOL')) \n");
//        queryStr.append("                  --DEL이 ‘US,CA,MX’가 아닌 것         \n");
//        queryStr.append("                         or (substr(del_cd, 1, 2) <> 'US' and substr(del_cd, 1, 2) <> 'CA' and substr(del_cd, 1, 2) <> 'MX' and cgo.EDI_STND_STS_CD in ('NFT','FTR'))   \n");
//        queryStr.append("                  then    \n");
//        queryStr.append("                     'EXP'   \n");
//        queryStr.append("                  else 'N/A'    \n");
//        queryStr.append("                  end EXP_IND    \n");
//        queryStr.append("     FROM (        \n");
//        queryStr.append("         SELECT /*+ ordered */   DISTINCT  h.trnk_vsl_cd||h.trnk_skd_voy_no||h.trnk_skd_dir_cd vvd,        \n");
//        queryStr.append("                h.bkg_no, h.bkg_no_split, h.cntr_no,  h.por_cd, h.pol_cd, h.pod_cd, h.del_cd,    h.cop_no,  \n");
//        queryStr.append("           	 h.sc_no, h.shpr_cnt_cd, h.shpr_seq, h.cnee_cnt_cd,     \n");
//        queryStr.append("         		h.cnee_seq, h.act_cust_cnt_cd, h.act_cust_seq, h.ntfy_cnt_cd, h.ntfy_seq, h.frt_fwrd_cnt_cd, h.frt_fwrd_seq     \n");
//        queryStr.append("         		,h.edi_cnt_cd, h.edi_seq, h.COP_RAIL_CHK_CD rail_chk, h.N1ST_TS_PORT_CD ts_chk ,b.bl_no||b.bl_no_tp||b.bl_no_chk bl_no  	\n");
//        
//        if((vvd.equals("")) && (bkg_no.equals("")) && (bl_no.equals("")) && (cntr_no.equals(""))){
//	        queryStr.append("		from	( SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD)     */        \n");
//	        queryStr.append("				VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd  \n");
//	        queryStr.append("			FROM VSK_VSL_PORT_SKD	\n");
//	        queryStr.append("			where NVL(CNG_STS_CD, ' ') <> 'S'	\n");
//	        queryStr.append("				AND CLPT_IND_SEQ = '1'   \n");
//	        
//	        if((!pol_fromdate.equals("")) || (!pol_todate.equals(""))){
//	        	queryStr.append("   		AND  VPS_ETD_DT BETWEEN TO_DATE( '"+pol_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pol_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("           and VPS_PORT_CD LIKE  '"+pol+"%'   \n");
//	        	queryStr.append("           and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   \n"); 
//	        }
//	        
//	        if((!pod_fromdate.equals("")) || (!pod_todate.equals(""))){
//	        	queryStr.append("   		AND VPS_ETA_DT BETWEEN TO_DATE( '"+pod_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pod_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("           and VPS_PORT_CD LIKE  '"+pod+"%'   \n");
//	        	queryStr.append("           and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  \n");
//	        }
//	        
//	        queryStr.append("			) v	, sce_cop_hdr h, bkg_booking b	\n");
//	        queryStr.append("			where  h.TRNK_VSL_CD = substr(v.vvd, 1, 4) 		\n");
//	        queryStr.append("        and      h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4) 		\n");
//	        queryStr.append("        and      h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1) 		\n");
//        } else if(!bkg_no.equals("")){  
//        	queryStr.append("		  FROM sce_cop_hdr h , bkg_booking b    \n");
//        	if ( questExp.length() > 1 )        questExp.delete(0, questExp.length());
//        	for(int j = 0 ; j < bkgArray.length -1 ; j++){
//        		questExp.append(",(?,decode(?,'','  ',?))");
//        	}
//	        queryStr.append("                where (h.bkg_no, h.bkg_no_split)                             \n");
//	        queryStr.append("                    in ((?,decode(?,'','  ',?)) ");
//	        queryStr.append("                " + questExp.toString() + ") \n");
//    	} else if(!bl_no.equals("")){  
////    		queryStr.append("		  FROM sce_cop_hdr h   \n");
//    		if ( questExp.length() > 1 )        questExp.delete(0, questExp.length());
//        	for(int j = 0 ; j < blArray.length -1 ; j++){
//        		questExp.append(",(?,?,?)");
//        	}
//        	queryStr.append("			from (   select bkg_no, bkg_no_split,bl_no,bl_no_tp,bl_no_chk from bkg_booking	\n");
//        	queryStr.append("				where (bl_no,bl_no_tp,bl_no_chk) in ((?,?,?) 		\n");
//        	queryStr.append("                " + questExp.toString() + "   ) \n");
//        	queryStr.append("				) b  , 	sce_cop_hdr h		\n");
//        	queryStr.append("			where 	1 =1		\n");
////        	queryStr.append("			where h.bkg_no_split = v.bkg_no_split		\n");
////        	queryStr.append("				and h.bkg_no = v.bkg_no  	\n");
//    	} else if(!cntr_no.equals("")){  
//    		queryStr.append("		  FROM sce_cop_hdr h , bkg_booking b    \n");
//    		if ( questExp.length() > 1 )        questExp.delete(0, questExp.length());
//        	for(int j = 0 ; j < cntrArray.length -1 ; j++){
//        		questExp.append(",?");
//        	}
//	        queryStr.append("                where h.cntr_no in ( ?");
//	        queryStr.append("                " + questExp.toString() + ") \n");
//    	} else if(!vvd.equals("")){
//    		queryStr.append("		  FROM sce_cop_hdr h , bkg_booking b    \n");
//        	if ( questExp.length() > 1 )        questExp.delete(0, questExp.length());
//        	for(int j = 0 ; j < vvdArray.length -1 ; j++){
//        		questExp.append(",?");
//        	}
//	        queryStr.append(" 			      where h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD  in ( ?  ");
//	        queryStr.append("                " + questExp.toString() + " ) \n");
//        }
//        if(cop_status.equals("C")){
//        	queryStr.append("              and      h.cop_sts_cd  = 'F'			            \n");
//        } else if(cop_status.equals("I")){
//        	queryStr.append("              and      h.cop_sts_cd  = 'T'			            \n");
//        } else {
//        	queryStr.append("			   and  h.cop_sts_cd  IN ('C', 'T', 'F')  			\n");
//        }
//        
//        queryStr.append("        	AND  h.cntr_no <> 'SMCU0000000'   		\n");
//        queryStr.append("			and b.bkg_no = h.bkg_no 						\n");
//        queryStr.append("			AND b.bkg_no_split = h.bkg_no_split				\n");
//        
//        if(!por.equals("")){
//  	        queryStr.append("                AND h.por_cd LIKE '"+por+"%'                                                             \n");
//        }
//        if(!pol.equals("")){
//  	        queryStr.append("                AND h.pol_cd LIKE '"+pol+"%'                                                             \n");
//        }
//        if(!pod.equals("")){
//  	        queryStr.append("                AND h.pod_cd LIKE '"+pod+"%'                                                             \n");
//        }
//        if(!del.equals("")){
//  	        queryStr.append("                AND h.del_cd LIKE '"+del+"%'                                                             \n");
//        }
//        
//        if(!trs_mode.equals("A")){
//        	if(trs_mode.equals("Y")){
//        		queryStr.append("                AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) IN ('OI', 'XI')   \n");
//        	}else{
//        		queryStr.append("                AND decode(H.COP_RAIL_CHK_CD,'','XX',H.COP_RAIL_CHK_CD) NOT IN ('OI', 'XI')    \n");
//        	}
//        }
//        queryStr.append("     ) hb,    EDI_GRP_CUST e,	edi_grp_cgo cgo, bkg_bkg_cust bkg_cust	\n");
////        queryStr.append("      WHERE ( (hb.shpr_cnt_cd = e.cust_cnt_cd AND hb.shpr_seq = e.cust_seq)  		\n");
////        queryStr.append("          OR (hb.cnee_cnt_cd = e.cust_cnt_cd	AND hb.cnee_seq = e.cust_seq)	\n");
////        queryStr.append("         OR (hb.act_cust_cnt_cd = e.cust_cnt_cd AND hb.act_cust_seq = e.cust_seq)		\n");
////        queryStr.append("         OR (hb.ntfy_cnt_cd = e.cust_cnt_cd AND hb.ntfy_seq = e.cust_seq)		\n");
////        queryStr.append("         OR (hb.frt_fwrd_cnt_cd = e.cust_cnt_cd	AND hb.frt_fwrd_seq = e.cust_seq)	\n");
////        queryStr.append("         OR (hb.edi_cnt_cd = e.cust_cnt_cd	AND hb.edi_seq = e.cust_seq)	\n");
////        queryStr.append("         OR (hb.sc_no = e.sc_no) )		\n");
//        
////      bkg_bkg_cust 사용 추가 : 2002701 iskim
//        queryStr.append("WHERE hb.bkg_no = bkg_cust.bkg_no \n") ;
//        queryStr.append("                  and hb.bkg_no_split = bkg_cust.bkg_no_split \n") ;
//        queryStr.append("                  and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- S \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'S' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- C \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'C' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- A \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'A' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- N \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'N' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- F \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'F' ) \n") ;
//        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- E \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
//        queryStr.append("                          and bkg_cust_tp_cd = 'E' ) \n") ;
//        queryStr.append("                      or (hb.sc_no = e.sc_no ) ) \n") ;
//        
//        
//        queryStr.append("     AND E.EDI_GRP_CD = '"+cs_grp_id+"'    		\n");
//        queryStr.append("     AND cgo.EDI_STND_STS_CD in ('"+edi_sts+"')    		\n");
//        queryStr.append("     AND e.edi_grp_cd = cgo.edi_grp_cd     		\n");
//        queryStr.append("	  and E.CGO_TRC_SVC_FLG <> 'N'  \n");
//        queryStr.append("    ) a  -- 조인 2     		\n");
//        queryStr.append("	where a.edi_grp_cd = r.EDI_GRP_CD(+)	\n");
//        queryStr.append("		and a.bkg_no = r.bkg_no(+)	\n");
//        queryStr.append("		and a.bkg_no_split = r.bkg_no_split(+)	\n");
//        queryStr.append("		and a.cntr_no = r.cntr_no(+) 	\n");
//        queryStr.append("		and a.EDI_STS_CD = r.EDI_STS_CD(+)	\n");
//        queryStr.append("		and a.edi_sub_sts_cd = r.edi_sub_sts_cd(+)	\n");
//        queryStr.append("		and r.EDI_SND_KNt(+) = 1 ) dtl , EDI_CGO_STND_STS sts	\n");
//        queryStr.append("	where sts.EDI_STND_STS_CD = dtl.edi_sts_cd	\n");
//        queryStr.append("		and dtl.exp_ind   = 'N/A'   \n");
//        
//        if(diff.equals("1")){    //Missing 일경우에는 주석 처리~~~
//        	queryStr.append("     and dtl.gmt_dt2 is null  	\n");
//        } 
//        queryStr.append("	  and dtl.edi_sts_cd  in ('"+edi_sts+"')   \n");
//    	queryStr.append("		 and dtl.edi_sub_sts_cd = '"+cust_sts+"' 	\n");        
//        queryStr.append("	order by vvd, bkg_no, bkg_no_split, cntr_no, sort_seq, max_edi_snd_knt, dtl.edi_snd_knt ) L    \n");
//        queryStr.append(" 	where l.no between "+startPart+" and "+endPart+"	\n");	
//        
//        try{
//        	con = getConnection(); 
//        	if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//                ps = new LoggableStatement(con, queryStr.toString());
//            }else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//
//            String bkgTemp1 = "";
//            String bkgSplitTemp1 = "";
//            
//        	if(!bkg_no.equals("")){
//        		for(int j = 0 ; j < bkgArray.length ; j++){
//                	if(bkgArray[j].length() > 11){
//                		bkgTemp1 = bkgArray[j].substring(0,11);
//                		bkgSplitTemp1 = bkgArray[j].substring(11);
//                	}else{
//                		bkgTemp1 = bkgArray[j];
//                	}
//            		ps.setString(i++, bkgTemp1);
//            		ps.setString(i++, bkgSplitTemp1);
//            		ps.setString(i++, bkgSplitTemp1);
//            	}
//        	} else if(!bl_no.equals("")){
//        		String Temp1 = "";
//                String Temp2 = "";
//                String Temp3 = "";
//                for(int j = 0 ; j < blArray.length ; j++){
//                	if(blArray[j].length() > 10){
//                		Temp1 = blArray[j].substring(0,10);
//                		Temp2 = blArray[j].substring(10,11);
//                		if(blArray[j].length() > 11){
//                			Temp3 = blArray[j].substring(11);
//                		}
//                	}else{
//                		Temp1 = blArray[j];
//                	}
//            		ps.setString(i++, Temp1);
//            		ps.setString(i++, Temp2);
//            		ps.setString(i++, Temp3);
//            	}
//        	} else if(!cntr_no.equals("")){
//        		for(int j = 0 ; j < cntrArray.length ; j++){
//	        		ps.setString(i++, cntrArray[j]);
//	        	}
//        	} else if(!vvd.equals("")){
//	            for(int j = 0 ; j < vvdArray.length ; j++){
//	        		ps.setString(i++, vvdArray[j]);
//	        	}
//            }
//        	
//        	String bkgTemp = "";
//            String bkgSplitTemp = "";
//        	if(!bkg_no.equals("")){
//        		for(int j = 0 ; j < bkgArray.length ; j++){
//                	if(bkgArray[j].length() > 11){
//                		bkgTemp = bkgArray[j].substring(0,11);
//                		bkgSplitTemp = bkgArray[j].substring(11);
//                	}else{
//                		bkgTemp = bkgArray[j];
//                	}
//            		ps.setString(i++, bkgTemp);
//            		ps.setString(i++, bkgSplitTemp);
//            		ps.setString(i++, bkgSplitTemp);
//            	}
//        	} else if(!bl_no.equals("")){
//        		String bl_1 = "";
//                String bl_2 = "";
//                String bl_3 = "";
//                for(int j = 0 ; j < blArray.length ; j++){
//                	if(blArray[j].length() > 10){
//                		bl_1 = blArray[j].substring(0,10);
//                		bl_2 = blArray[j].substring(10,11);
//                		if(blArray[j].length() > 11){
//                			bl_3 = blArray[j].substring(11);
//                		}
//                	}else{
//                		bl_1 = blArray[j];
//                	}
//            		ps.setString(i++, bl_1);
//            		ps.setString(i++, bl_2);
//            		ps.setString(i++, bl_3);
//            	} 
//        	} else if(!cntr_no.equals("")){
//        		for(int j = 0 ; j < cntrArray.length ; j++){
//            		ps.setString(i++, cntrArray[j]);
//            	}
//        	} else if(!vvd.equals("")){
//	            for(int j = 0 ; j < vvdArray.length ; j++){
//	        		ps.setString(i++, vvdArray[j]);
//	        	}
//            }
//
//        	log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//
//            dRs = new DBRowSet();
//            dRs.populate(rs);
//            return dRs;
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//		}
//    }
//    
    /** On-time List  popup count
     * 
     * @param parameterMap
     * @param iPage
     * @return
     * @throws DAOException
     */
//    public int searchOnTimeCnt(HashMap parameterMap) throws DAOException{
//    	Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        int i = 1;
//        
//        String day   = JSPUtil.getNull((String)parameterMap.get("day"));
//        String cs_grp_id   = JSPUtil.getNull((String)parameterMap.get("cs_grp_id"));   //grp_cd
//        String cust_sts   = JSPUtil.getNull((String)parameterMap.get("cust_sts"));  
//        
//        String vvd          = JSPUtil.getNull((String)parameterMap.get("vvd"));
////        String por          = JSPUtil.getNull((String)parameterMap.get("por"));
//        String pol          = JSPUtil.getNull((String)parameterMap.get("pol"));
//        String pod          = JSPUtil.getNull((String)parameterMap.get("pod"));
////        String del          = JSPUtil.getNull((String)parameterMap.get("del"));
//        String edi_sts      = JSPUtil.getNull((String)parameterMap.get("edi_sts"));
////        String trs_mode     = JSPUtil.getNull((String)parameterMap.get("trs_mode"));
//        String bkg_no       = JSPUtil.getNull((String)parameterMap.get("bkgno"));     // bkg_no
//        String bl_no        = JSPUtil.getNull((String)parameterMap.get("blno"));      // bl_no
//        String cntr_no      = JSPUtil.getNull((String)parameterMap.get("cntrno"));    // cntr_no
//        String cop_status   = JSPUtil.getNull((String)parameterMap.get("copsts"));
//        
//        String pol_fromdate = JSPUtil.getNull((String)parameterMap.get("poletdDate1")).replaceAll("-","");
//        String pol_todate = JSPUtil.getNull((String)parameterMap.get("poletdDate2")).replaceAll("-","");
//        String pod_fromdate = JSPUtil.getNull((String)parameterMap.get("podetaDate1")).replaceAll("-","");
//        String pod_todate = JSPUtil.getNull((String)parameterMap.get("podetaDate2")).replaceAll("-","");
//        
//        StringBuffer questExp = new StringBuffer();
//        StringBuffer queryStr = new StringBuffer();
//        
//        String [] vvdArray  = new String[0];
//        String [] bkgArray  = new String[0];
//        String [] blArray   = new String[0];
//        String [] cntrArray = new String[0];
//        
//        if(!vvd.equals("")){
//        	vvdArray = vvd.split(",");
//        }
//        if(!bkg_no.equals("")){
//        	bkgArray = bkg_no.split(",");
//        }
//        if(!bl_no.equals("")){
//        	blArray = bl_no.split(",");
//        }
//        if(!cntr_no.equals("")){
//        	cntrArray = cntr_no.split(",");
//        }
//        
//        queryStr.append("  select count(L.vvd)						 \n");
//        queryStr.append("	from (   \n");
//        queryStr.append("		select /*+ USE_NL(sts dtl) */   DISTINCT dtl.vvd,dtl.bkg_no,dtl.bkg_no_split, dtl.cntr_no, dtl.por_cd,dtl.pol_cd,	\n");
//        queryStr.append("			dtl.pod_cd, dtl.del_cd,'' , dtl.EDI_STS_CD, dtl.edi_sub_sts_cd, dtl.edi_snd_knt, \n");
//        queryStr.append("			dtl.act_dt1,dtl.act_dt2, nod_cd,dtl.cre_dt1,dtl.cre_dt2, '0' ,dtl.cop_no,dtl.bl_no, \n");
//        queryStr.append("			sts.edi_sts_seq sort_seq, dtl.act_dt1||dtl.act_dt2 sort_dt,max_edi_snd_knt, \n");
//        queryStr.append("			dtl.gmt_dt1, dtl.gmt_dt2, rownum no \n");
//        queryStr.append("		from ( \n");
//        queryStr.append("			select r.vvd,r.bkg_no, r.bkg_no_split,r.cntr_no,por_cd,pol_cd,pod_cd,del_cd,'' flg,r.EDI_STS_CD,  \n");
//        queryStr.append("				r.edi_snd_knt , to_char(r.act_dt, 'yyyymmdd') act_dt1, to_char(r.act_dt, 'hh24miss') act_dt2,  \n");
//        queryStr.append("				r.nod_cd , to_char(r.upd_dt, 'yyyymmdd') cre_dt1, to_char(r.upd_dt, 'hh24miss') cre_dt2, r.cop_no , \n");
//        queryStr.append("				r.bl_no,r.act_dt,r.EDI_SUB_STS_CD , r.max_edi_snd_knt max_edi_snd_knt , \n");
//        queryStr.append("				to_char(r.gmt_dt, 'yyyymmdd') gmt_dt1,to_char(r.gmt_dt, 'hh24miss') gmt_dt2 --20071129 LocalTime \n");
//        queryStr.append("			from (  \n");
//        queryStr.append("				select /*+ index(d XAK5SCE_EDI_SND_RSLT) */  \n");
//        queryStr.append("					d.EDI_GRP_CD,d.bkg_no, d.bkg_no_split, d.cntr_no, d.EDI_STS_CD,  d.EDI_SUB_STS_CD , \n");
//        queryStr.append("					d.act_dt, d.gmt_dt, d.edi_snd_knt EDI_SND_KNt, d.upd_dt,d.nod_cd , \n");
//        queryStr.append("					MAX(d.EDI_SND_KNT) OVER ( PARTITION BY d.bkg_no, d.bkg_no_split, d.cntr_no, d.EDI_STS_CD, d.EDI_SUB_STS_CD) max_edi_snd_knt ,  \n");
//        queryStr.append("					d.bl_no,h.cop_No,h.por_cd,h.pol_cd, h.pod_cd, h.del_cd ,  \n");
//        queryStr.append("					d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD vvd,trunc(abs(nvl(d.GMT_DT - d.act_dt, 0)))  \n");
//        queryStr.append("				from SCE_EDI_SND_RSLT d , sce_cop_hdr h    \n");
//        
//        if((vvd.equals("")) && (bkg_no.equals("")) && (bl_no.equals("")) && (cntr_no.equals(""))){
//	        queryStr.append("				, (	SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */   \n");
//	        queryStr.append("						VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd   \n");
//	        queryStr.append("					FROM VSK_VSL_PORT_SKD     \n");
//	        queryStr.append("         			WHERE  NVL(CNG_STS_CD, ' ') <> 'S'     \n");
//	        queryStr.append("         				AND CLPT_IND_SEQ = '1'    \n");
//	        
//	        if((!pol_fromdate.equals("")) || (!pol_todate.equals(""))){
//	        	queryStr.append("   				     AND VPS_ETD_DT BETWEEN TO_DATE( '"+pol_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pol_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("                        and VPS_PORT_CD LIKE  '"+pol+"%'   \n");
//	        	queryStr.append("                        and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   \n"); 
//	        }
//	        
//	        if((!pod_fromdate.equals("")) || (!pod_todate.equals(""))){
//	        	queryStr.append("   				     AND VPS_ETA_DT BETWEEN TO_DATE( '"+pod_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pod_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("                        and VPS_PORT_CD LIKE  '"+pod+"%'   \n");
//	        	queryStr.append("                        and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  \n"); 
//	        }
//	        queryStr.append("						) v  \n");
//	        queryStr.append("				where d.VSL_CD = substr(v.vvd, 1, 4)  \n");
//	        queryStr.append("					and d.SKD_VOY_NO = substr(v.vvd, 5, 4)	\n");
//	        queryStr.append("					and d.SKD_DIR_CD = substr(v.vvd, 9, 1)	\n");
//        } else if(!bkg_no.equals("")){
//        	if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < bkgArray.length -1 ; j++){
//        		questExp.append(",(?,decode(?,'','  ',?))");
//        	}
//        	queryStr.append("			where (d.bkg_no, d.bkg_no_split) in ((?,decode(?,'','  ',?))	    \n");
//        	queryStr.append("                " + questExp.toString() + "  ) \n");
//        } else if(!bl_no.equals("")){
//        	if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < blArray.length -1 ; j++){
//        		questExp.append(",(?,?,?)");
//        	}
//        	queryStr.append("			, (   select bkg_no, bkg_no_split from bkg_booking	\n");
//        	queryStr.append("				where (bl_no,bl_no_tp,bl_no_chk) in ((?,?,?) 		\n");
//        	queryStr.append("                " + questExp.toString() + "   ) \n");
//        	queryStr.append("				) v   			\n");
//        	queryStr.append("			where d.bkg_no_split = v.bkg_no_split		\n");
//        	queryStr.append("				and d.bkg_no = v.bkg_no  	\n");
//        } else if(!cntr_no.equals("")){
//        	if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < cntrArray.length -1 ; j++){
//        		questExp.append(",?");
//        	}
//        	queryStr.append("			where d.CNTR_NO in (?	    \n");
//        	queryStr.append("                " + questExp.toString() + " ,''  ) \n");
//        } else if(!vvd.equals("")){
//        	if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < vvdArray.length -1 ; j++){
//        		questExp.append(",?");
//        		
//        	}
//        	queryStr.append("                 where  d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD  in ( ?           \n"); 
//            queryStr.append("                " + questExp.toString() + " ,''  ) \n");
//        }
//        if(cop_status.equals("C")){
//        	queryStr.append("              and      h.cop_sts_cd  = 'F'			            \n");
//        } else if(cop_status.equals("I")){
//        	queryStr.append("              and      h.cop_sts_cd  = 'T'			            \n");
//        } else {
//        	queryStr.append("						and h.cop_sts_cd IN ('C', 'T', 'F')			\n");
//        }
//        
//        queryStr.append(" 						AND h.cntr_no <> 'SMCU0000000'      \n");
//        
//        if(!cs_grp_id.equals("")){
//        	queryStr.append("        	    and d.EDI_GRP_CD = '"+cs_grp_id+"'   \n");
//        }
//        
//        if(!edi_sts.equals("")){
//        	queryStr.append("					and d.edi_sts_cd = '"+edi_sts+"'  \n");
//        }
//        
//        queryStr.append("        				and d.EDI_SUB_STS_CD = '"+cust_sts+"'       \n");
//        queryStr.append("					and d.bkg_no = h.bkg_no   \n");
//        queryStr.append("					and d.bkg_no_split = h.bkg_no_split   \n");
//        queryStr.append("					and d.cntr_no = h.cntr_no     \n");
//        queryStr.append("					and h.cop_sts_cd in ('C', 'T', 'F')    \n");
//        queryStr.append("					and d.edi_snd_knt = 1     \n");
//        
//        if(day.equals("2")){
//        	queryStr.append(" 				and (   trunc(abs(nvl(d.GMT_DT  - d.act_dt, 0))) >= '0'        \n");
//        	queryStr.append("   			and	trunc(abs(nvl(d.GMT_DT  - d.act_dt, 0))) <='1' )   \n");
//        } else if(day.equals("4")){
//        	queryStr.append("   			and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) = '2' )   \n");
//        } else if(day.equals("6")){
//        	queryStr.append("   			and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) = '3' )    \n");
//        } else if(day.equals("8")){
//        	queryStr.append("   			and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) >= '4')     \n");
//        }
//        
//        queryStr.append("                   and ACT_DT IS NOT NULL  \n");
//        queryStr.append("				) r  \n");
//        queryStr.append("			) dtl,  EDI_CGO_STND_STS sts    \n");
//        queryStr.append("			where sts.EDI_STND_STS_CD = dtl.edi_sts_cd   \n");
//        
//        if(!edi_sts.equals("")){
//        	queryStr.append("					and dtl.edi_sts_cd = '"+edi_sts+"'  \n");
//        }
//        queryStr.append("					    and dtl.edi_sub_sts_cd = '"+cust_sts+"'  \n");
//        queryStr.append("	order by vvd, bkg_no, bkg_no_split, cntr_no, sort_seq, max_edi_snd_knt, dtl.edi_snd_knt ) L      \n");
//        
//        try{
//        	con = getConnection(); 
//        	if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//        		ps = new LoggableStatement(con, queryStr.toString());
//        	}else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//        	
//        	String bkgTemp1 = "";
//            String bkgSplitTemp1 = "";
//        	if(!bkg_no.equals("")){
//        		for(int j = 0 ; j < bkgArray.length ; j++){
//                	if(bkgArray[j].length() > 11){
//                		bkgTemp1 = bkgArray[j].substring(0,11);
//                		bkgSplitTemp1 = bkgArray[j].substring(11);
//                	}else{
//                		bkgTemp1 = bkgArray[j];
//                	}
//            		ps.setString(i++, bkgTemp1);
//            		ps.setString(i++, bkgSplitTemp1);
//            		ps.setString(i++, bkgSplitTemp1);
//            	}
//        	} else if(!bl_no.equals("")){
//        		String Temp1 = "";
//                String Temp2 = "";
//                String Temp3 = "";
//                for(int j = 0 ; j < blArray.length ; j++){
//                	if(blArray[j].length() > 10){
//                		Temp1 = blArray[j].substring(0,10);
//                		Temp2 = blArray[j].substring(10,11);
//                		if(blArray[j].length() > 11){
//                			Temp3 = blArray[j].substring(11);
//                		}
//                	}else{
//                		Temp1 = blArray[j];
//                	}
//            		ps.setString(i++, Temp1);
//            		ps.setString(i++, Temp2);
//            		ps.setString(i++, Temp3);
//            	}
//        	} else if(!cntr_no.equals("")){
//        		for(int j = 0 ; j < cntrArray.length ; j++){
//	        		ps.setString(i++, cntrArray[j]);
//	        	}
//        	} else if(!vvd.equals("")){
//	            for(int j = 0 ; j < vvdArray.length ; j++){
//	        		ps.setString(i++, vvdArray[j]);
//	        	}
//            } 
//        	
//        	log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//				return rs.getInt(1);
//			}
//			return 0;
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//		}
//    }
//    
    
    
    /** On-time List  popup 조회
     * 
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws DAOException
     */
    public List<SearchMissingListVO> searchOnTimeList(SearchMissingListVO searchMissingListVo) throws DAOException{ 
       	
    	log.info("searchMissingsList is running");
    	DBRowSet dbRowset = null;
    	List<SearchMissingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchMissingListVo != null) {
				searchMissingListVo.unDataFormat();				
				Map<String, String> mapVO = searchMissingListVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				
				log.info("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
				log.info("searchOnTimeList:"+searchMissingListVo.toString());	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no") != null
						&& !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0074  Prams[bkg_no]  - " + ((String[])velParam.get("bkg_no")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no") != null
						&& !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0074  Prams[bl_no]  - " + ((String[])velParam.get("bl_no")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null
						&& !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
							.split(","));
					log.info("###EsdSce0074  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no") != null
						&& !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).toUpperCase()
							.split(","));
					log.info("###EsdSce0074  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no")).length);
				}//if
				

				log.info("###EsdSce0074 - SearchEdiSummaryReportOptionsVO is just set!");			
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchOnTimeListRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchMissingListVO.class);

		//} catch (SQLException se) {
		//	log.error(se.getMessage(), se);
		//	throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;    
    }    
//    public DBRowSet searchOnTimeList(HashMap parameterMap,int iPage) throws DAOException{
//    	Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        DBRowSet dRs = null;                // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//        int i = 1;
//        
//        String day   = JSPUtil.getNull((String)parameterMap.get("day"));
//        String cs_grp_id   = JSPUtil.getNull((String)parameterMap.get("cs_grp_id"));   //grp_cd
//        String cust_sts   = JSPUtil.getNull((String)parameterMap.get("cust_sts"));  
//        
//        String vvd          = JSPUtil.getNull((String)parameterMap.get("vvd"));
////        String por          = JSPUtil.getNull((String)parameterMap.get("por"));
//        String pol          = JSPUtil.getNull((String)parameterMap.get("pol"));
//        String pod          = JSPUtil.getNull((String)parameterMap.get("pod"));
////        String del          = JSPUtil.getNull((String)parameterMap.get("del"));
//        String edi_sts      = JSPUtil.getNull((String)parameterMap.get("edi_sts"));
////        String trs_mode     = JSPUtil.getNull((String)parameterMap.get("trs_mode"));
//        String bkg_no       = JSPUtil.getNull((String)parameterMap.get("bkgno"));     // bkg_no
//        String bl_no        = JSPUtil.getNull((String)parameterMap.get("blno"));      // bl_no
//        String cntr_no      = JSPUtil.getNull((String)parameterMap.get("cntrno"));    // cntr_no
//        String cop_status   = JSPUtil.getNull((String)parameterMap.get("copsts"));
//        
//        String pol_fromdate = JSPUtil.getNull((String)parameterMap.get("poletdDate1")).replaceAll("-","");
//        String pol_todate = JSPUtil.getNull((String)parameterMap.get("poletdDate2")).replaceAll("-","");
//        String pod_fromdate = JSPUtil.getNull((String)parameterMap.get("podetaDate1")).replaceAll("-","");
//        String pod_todate = JSPUtil.getNull((String)parameterMap.get("podetaDate2")).replaceAll("-","");
//        
//        StringBuffer questExp = new StringBuffer();
//        StringBuffer queryStr = new StringBuffer();
//        
//        String [] vvdArray  = new String[0];
//        String [] bkgArray  = new String[0];
//        String [] blArray   = new String[0];
//        String [] cntrArray = new String[0];
//        
//        if(!vvd.equals("")){
//        	vvdArray = vvd.split(",");
//        }
//        if(!bkg_no.equals("")){
//        	bkgArray = bkg_no.split(",");
//        }
//        if(!bl_no.equals("")){
//        	blArray = bl_no.split(",");
//        }
//        if(!cntr_no.equals("")){
//        	cntrArray = cntr_no.split(",");
//        }
//        
////      페이징 처리
//        if(iPage == 0) iPage = 1;
//        
//		int currentPage = iPage;
//		int startPart   = Constants.PAGE_SIZE_300 * (currentPage - 1) + 1;
//		int endPart     = Constants.PAGE_SIZE_300 * currentPage;  
//
//        queryStr.append("  select L.vvd, L.bkg_no, L.bkg_no_split, L.bl_no,  L.cntr_no,  L.por_cd,  \n");
//        queryStr.append("		L.pol_cd, L.pod_cd,  L.del_cd, '' , L.EDI_STS_CD, L.edi_sub_sts_cd, L.edi_snd_knt, \n");
//        queryStr.append("		L.act_dt1, L.act_dt2, L.nod_cd, L.cre_dt1, L.cre_dt2,L.gmt_dt1, L.gmt_dt2,     \n");
//        queryStr.append("		decode(L.edi_snd_knt, null, '', case when L.max_edi_snd_knt= L.edi_snd_knt then '0' else '' end) rbtn, L.cop_no 	\n");
//        queryStr.append("	from (   \n");
//        queryStr.append("		select /*+ USE_NL(sts dtl) */   DISTINCT dtl.vvd,dtl.bkg_no,dtl.bkg_no_split, dtl.cntr_no, dtl.por_cd,dtl.pol_cd,	\n");
//        queryStr.append("			dtl.pod_cd, dtl.del_cd,'' , dtl.EDI_STS_CD, dtl.edi_sub_sts_cd, dtl.edi_snd_knt, \n");
//        queryStr.append("			dtl.act_dt1,dtl.act_dt2, nod_cd,dtl.cre_dt1,dtl.cre_dt2, '0' ,dtl.cop_no,dtl.bl_no, \n");
//        queryStr.append("			sts.edi_sts_seq sort_seq, dtl.act_dt1||dtl.act_dt2 sort_dt,max_edi_snd_knt, \n");
//        queryStr.append("			dtl.gmt_dt1, dtl.gmt_dt2, rownum no \n");
//        queryStr.append("		from ( \n");
//        queryStr.append("			select r.vvd,r.bkg_no, r.bkg_no_split,r.cntr_no,por_cd,pol_cd,pod_cd,del_cd,'' flg,r.EDI_STS_CD,  \n");
//        queryStr.append("				r.edi_snd_knt , to_char(r.act_dt, 'yyyymmdd') act_dt1, to_char(r.act_dt, 'hh24miss') act_dt2,  \n");
//        queryStr.append("				r.nod_cd , to_char(r.upd_dt, 'yyyymmdd') cre_dt1, to_char(r.upd_dt, 'hh24miss') cre_dt2, r.cop_no , \n");
//        queryStr.append("				r.bl_no,r.act_dt,r.EDI_SUB_STS_CD , r.max_edi_snd_knt max_edi_snd_knt , \n");
//        queryStr.append("				to_char(r.gmt_dt, 'yyyymmdd') gmt_dt1,to_char(r.gmt_dt, 'hh24miss') gmt_dt2 --20071129 LocalTime \n");
//        queryStr.append("			from (  \n");
//        
//        if((vvd.equals("")) && (bkg_no.equals("")) && (bl_no.equals("")) && (cntr_no.equals(""))){
//        	queryStr.append("				select /*+ index(d XAK5SCE_EDI_SND_RSLT) */  \n");
//        } else if(!bkg_no.equals("")){
//        	queryStr.append("				select                                		 \n");
//        } else if(!bl_no.equals("")){
//        	queryStr.append("				select                             		    \n");
//        } else if(!cntr_no.equals("")){
//        	queryStr.append("				select                						\n");
//        } else if(!vvd.equals("")){
//        	queryStr.append("				select /*+ index(d XAK5SCE_EDI_SND_RSLT) */  \n");
//        }
//        
//        queryStr.append("					d.EDI_GRP_CD,d.bkg_no, d.bkg_no_split, d.cntr_no, d.EDI_STS_CD,  d.EDI_SUB_STS_CD , \n");
//        queryStr.append("					d.act_dt, d.gmt_dt, d.edi_snd_knt EDI_SND_KNt, d.upd_dt,d.nod_cd , \n");
//        queryStr.append("					MAX(d.EDI_SND_KNT) OVER ( PARTITION BY d.bkg_no, d.bkg_no_split, d.cntr_no, d.EDI_STS_CD, d.EDI_SUB_STS_CD) max_edi_snd_knt ,  \n");
//        queryStr.append("					d.bl_no,h.cop_No,h.por_cd,h.pol_cd, h.pod_cd, h.del_cd ,  \n");
//        queryStr.append("					d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD vvd,trunc(abs(nvl(d.GMT_DT - d.act_dt, 0)))  \n");
//        queryStr.append("				from SCE_EDI_SND_RSLT d , sce_cop_hdr h    \n");
//        
//        if((vvd.equals("")) && (bkg_no.equals("")) && (bl_no.equals("")) && (cntr_no.equals(""))){
//	        queryStr.append("				, (	SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */   \n");
//	        queryStr.append("						VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd   \n");
//	        queryStr.append("					FROM VSK_VSL_PORT_SKD     \n");
//	        queryStr.append("         			WHERE  NVL(CNG_STS_CD, ' ') <> 'S'     \n");
//	        queryStr.append("         				AND CLPT_IND_SEQ = '1'    \n");
//	        
//	        if((!pol_fromdate.equals("")) || (!pol_todate.equals(""))){
//	        	queryStr.append("   				     AND VPS_ETD_DT BETWEEN TO_DATE( '"+pol_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pol_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("                        and VPS_PORT_CD LIKE  '"+pol+"%'   \n");
//	        	queryStr.append("                        and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   \n"); 
//	        }
//	        
//	        if((!pod_fromdate.equals("")) || (!pod_todate.equals(""))){
//	        	queryStr.append("   				     AND VPS_ETA_DT BETWEEN TO_DATE( '"+pod_fromdate+"', 'YYYYMMDD' ) AND TO_DATE( '"+pod_todate+"', 'YYYYMMDD' ) + 0.9999  \n");
//	        	queryStr.append("                        and VPS_PORT_CD LIKE  '"+pod+"%'   \n");
//	        	queryStr.append("                        and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  \n"); 
//	        }
//	        queryStr.append("						) v  \n");
//	        queryStr.append("				where d.VSL_CD = substr(v.vvd, 1, 4)  \n");
//	        queryStr.append("					and d.SKD_VOY_NO = substr(v.vvd, 5, 4)	\n");
//	        queryStr.append("					and d.SKD_DIR_CD = substr(v.vvd, 9, 1)	\n");
//        } else if(!bkg_no.equals("")){
//        	if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < bkgArray.length -1 ; j++){
//        		questExp.append(",(?,decode(?,'','  ',?))");
//        	}
//        	queryStr.append("			where (d.bkg_no, d.bkg_no_split) in ((?,decode(?,'','  ',?))	    \n");
//        	queryStr.append("                " + questExp.toString() + "  ) \n");
//        } else if(!bl_no.equals("")){
//        	if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < blArray.length -1 ; j++){
//        		questExp.append(",(?,?,?)");
//        	}
//        	queryStr.append("			, (   select bkg_no, bkg_no_split from bkg_booking	\n");
//        	queryStr.append("				where (bl_no,bl_no_tp,bl_no_chk) in ((?,?,?) 		\n");
//        	queryStr.append("                " + questExp.toString() + "   ) \n");
//        	queryStr.append("				) v   			\n");
//        	queryStr.append("			where d.bkg_no_split = v.bkg_no_split		\n");
//        	queryStr.append("				and d.bkg_no = v.bkg_no  	\n");
//        } else if(!cntr_no.equals("")){
//        	if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < cntrArray.length -1 ; j++){
//        		questExp.append(",?");
//        	}
//        	queryStr.append("			where d.CNTR_NO in (?	    \n");
//        	queryStr.append("                " + questExp.toString() + " ,''  ) \n");
//        } else if(!vvd.equals("")){
//        	if ( questExp.length() > 0 )        questExp.delete(0, questExp.length()); 
//        	for(int j = 0 ; j < vvdArray.length -1 ; j++){
//        		questExp.append(",?");
//        		
//        	}
//        	queryStr.append("                 where  d.VSL_CD||d.SKD_VOY_NO||d.SKD_DIR_CD  in ( ?           \n"); 
//            queryStr.append("                " + questExp.toString() + " ,''  ) \n");
//        }
//        if(cop_status.equals("C")){
//        	queryStr.append("              and      h.cop_sts_cd  = 'F'			            \n");
//        } else if(cop_status.equals("I")){
//        	queryStr.append("              and      h.cop_sts_cd  = 'T'			            \n");
//        } else {
//        	queryStr.append("						and h.cop_sts_cd IN ('C', 'T', 'F')			\n");        	
//        }
//        
//        queryStr.append(" 						AND h.cntr_no <> 'SMCU0000000'      \n");
//        
//        if(!cs_grp_id.equals("")){
//        	queryStr.append("        	    and d.EDI_GRP_CD = '"+cs_grp_id+"'   \n");
//        }
//        
//        if(!edi_sts.equals("")){
//        	queryStr.append("					and d.edi_sts_cd = '"+edi_sts+"'  \n");
//        }
//        
//        if(!pod.equals("")){
//        	queryStr.append("					and h.pod_cd like '"+pod+"%'	");
//        }
//        
//        queryStr.append("        				and d.EDI_SUB_STS_CD = '"+cust_sts+"'       \n");
//        queryStr.append("					and d.bkg_no = h.bkg_no   \n");
//        queryStr.append("					and d.bkg_no_split = h.bkg_no_split   \n");
//        queryStr.append("					and d.cntr_no = h.cntr_no     \n");
//        queryStr.append("					and h.cop_sts_cd in ('C', 'T', 'F')    \n");
//        queryStr.append("					and d.edi_snd_knt = 1     \n");
//        
//        if(day.equals("2")){
//        	queryStr.append(" 				and (   trunc(abs(nvl(d.GMT_DT  - d.act_dt, 0))) >= '0'        \n");
//        	queryStr.append("   			and	trunc(abs(nvl(d.GMT_DT  - d.act_dt, 0))) <='1' )   \n");
//        } else if(day.equals("4")){
//        	queryStr.append("   			and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) = '2' )   \n");
//        } else if(day.equals("6")){
//        	queryStr.append("   			and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) = '3' )    \n");
//        } else if(day.equals("8")){
//        	queryStr.append("   			and ( trunc(abs(nvl(d.GMT_DT - d.act_dt, 0))) >= '4')     \n");
//        }
//        
//        queryStr.append("                   and ACT_DT IS NOT NULL  \n");
//        queryStr.append("				) r  \n");
//        queryStr.append("			) dtl,  EDI_CGO_STND_STS sts    \n");
//        queryStr.append("			where sts.EDI_STND_STS_CD = dtl.edi_sts_cd   \n");
//        
//        if(!edi_sts.equals("")){
//        	queryStr.append("					and dtl.edi_sts_cd = '"+edi_sts+"'  \n");
//        }
//        queryStr.append("					    and dtl.edi_sub_sts_cd = '"+cust_sts+"'  \n");
//        queryStr.append("	order by vvd, bkg_no, bkg_no_split, cntr_no, sort_seq, max_edi_snd_knt, dtl.edi_snd_knt ) L      \n");
//        queryStr.append(" 			where no between "+startPart+" and "+endPart+"	\n");	
//        
//        try{
//        	con = getConnection(); 
//        	if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//        		ps = new LoggableStatement(con, queryStr.toString());
//        	}else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//        	
//        	String bkgTemp1 = "";
//            String bkgSplitTemp1 = "";
//        	if(!bkg_no.equals("")){
//        		for(int j = 0 ; j < bkgArray.length ; j++){
//                	if(bkgArray[j].length() > 11){
//                		bkgTemp1 = bkgArray[j].substring(0,11);
//                		bkgSplitTemp1 = bkgArray[j].substring(11);
//                	}else{
//                		bkgTemp1 = bkgArray[j];
//                	}
//            		ps.setString(i++, bkgTemp1);
//            		ps.setString(i++, bkgSplitTemp1);
//            		ps.setString(i++, bkgSplitTemp1);
//            	}
//        	} else if(!bl_no.equals("")){
//        		String Temp1 = "";
//                String Temp2 = "";
//                String Temp3 = "";
//                for(int j = 0 ; j < blArray.length ; j++){
//                	if(blArray[j].length() > 10){
//                		Temp1 = blArray[j].substring(0,10);
//                		Temp2 = blArray[j].substring(10,11);
//                		if(blArray[j].length() > 11){
//                			Temp3 = blArray[j].substring(11);
//                		}
//                	}else{
//                		Temp1 = blArray[j];
//                	}
//            		ps.setString(i++, Temp1);
//            		ps.setString(i++, Temp2);
//            		ps.setString(i++, Temp3);
//            	}
//        	} else if(!cntr_no.equals("")){
//        		for(int j = 0 ; j < cntrArray.length ; j++){
//	        		ps.setString(i++, cntrArray[j]);
//	        	}
//        	} else if(!vvd.equals("")){
//	            for(int j = 0 ; j < vvdArray.length ; j++){
//	        		ps.setString(i++, vvdArray[j]);
//	        	}
//            } 
//        	
//        	log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//
//            dRs = new DBRowSet();
//            dRs.populate(rs);
//            return dRs;
//        } catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//		}
//    }
//    
    /**  My Performance Report Modify 조회
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @throws DAOException
     */
    public List<SearchPerRepPupModiVO> searchPerRepPupModi(SearchCustomerInfoVO myCustInfo) throws DAOException{
    	DBRowSet dbRowset = null;
		List<SearchPerRepPupModiVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        
        try{
        	if (myCustInfo != null) {
				Map<String, String> mapVO = myCustInfo.getColumnValues();

//				log.info( "por_cd ==> " + mapVO.get("por_cd"));
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("param==" + param);
				log.info("velParam==" + velParam);

				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CustomerEdiDBDAOSearchPerRepPupModiRSQL(),
						param, velParam);

				list = (List) RowSetUtil.rowSetToVOs(dbRowset,
						SearchPerRepPupModiVO.class);
        	}
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }

    /** Vessel Schedule Accuracy total count
     * 
     * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * @param parameterMap
     * @param iPage
     * @return
     * @throws DAOException
     */
//    public int searchEstimationCnt(HashMap parameterMap) throws DAOException{
//    	Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        int i = 1;
//        
//        String cs_grp_id   = JSPUtil.getNull((String)parameterMap.get("cs_grp_id"));   //grp_cd
//        String eve_Sel     = JSPUtil.getNull((String)parameterMap.get("eve_Sel"));  
//        String eve_loc   = JSPUtil.getNull((String)parameterMap.get("eve_loc"));   
//        String vvd   = JSPUtil.getNull((String)parameterMap.get("vvd"));  
//        String fmd_dt   = JSPUtil.getNull((String)parameterMap.get("fmd_dt")).replaceAll("-","");   
//        String tod_dt   = JSPUtil.getNull((String)parameterMap.get("tod_dt")).replaceAll("-","");   
//        String fma_dt   = JSPUtil.getNull((String)parameterMap.get("fma_dt")).replaceAll("-","");   
//        String toa_dt   = JSPUtil.getNull((String)parameterMap.get("toa_dt")).replaceAll("-","");   
//        
//        StringBuffer questExp = new StringBuffer();
//        String [] arr_vvd = new String[0];
//        
//        if(!vvd.equals("")){
//        	arr_vvd = vvd.split(",");
//        }
//        
//        StringBuffer queryStr = new StringBuffer();
//        
//        queryStr.append("   select count(aa.bkg_no)     \n");
//        queryStr.append("   from sce_cop_dtl d, (     \n");
////        queryStr.append("       SELECT /*+ USE_NL(hb e cgo h) */  \n");
////        queryStr.append("       SELECT /*+ USE_NL (hb bkg_cust e cgo) */  \n");
//        queryStr.append("       SELECT /*+ NO_QUERY_TRANSFORMATION */ \n");
//        queryStr.append("       	DISTINCT vvd, hb.bkg_no, hb.bkg_no_split, cntr_no, por_cd, pol_cd, pod_cd, \n");
//        queryStr.append("        	del_cd, hb.cop_no, cgo.EDI_STND_STS_CD a_edi_sts_cd, cgo.CUST_EDI_STS_CD a_cust_edi_sts_cd,  \n");
//        queryStr.append("       	e.edi_grp_cd aaa, rail_chk, ts_chk \n");
//        queryStr.append("       FROM (     \n");
//        queryStr.append("       	SELECT /*+ USE_NL(v h b) */DISTINCT h.trnk_vsl_cd||h.trnk_skd_voy_no||h.trnk_skd_dir_cd vvd,   \n");
//        queryStr.append("       		h.bkg_no, h.bkg_no_split, h.cntr_no,h.por_cd,h.pol_cd, h.pod_cd, h.del_cd, h.cop_no, \n");
//        queryStr.append("       		h.sc_no,  h.shpr_cnt_cd, h.shpr_seq, h.cnee_cnt_cd, h.cnee_seq, h.act_cust_cnt_cd, \n");
//        queryStr.append("        		h.act_cust_seq, h.ntfy_cnt_cd, h.ntfy_seq, h.frt_fwrd_cnt_cd, h.frt_fwrd_seq , \n");
//        queryStr.append("        		h.edi_cnt_cd, h.edi_seq, h.COP_RAIL_CHK_CD rail_chk, h.N1ST_TS_PORT_CD ts_chk \n");
//        queryStr.append("        	FROM sce_cop_hdr h     \n");
//        
//        if(vvd.equals("")){
//	        queryStr.append("      		,  ( SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */  VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd   \n");
//	        queryStr.append("       	FROM VSK_VSL_PORT_SKD   \n");
//	        queryStr.append("           WHERE NVL(CNG_STS_CD, ' ') <> 'S'   \n");
//	        if(!fmd_dt.equals("")){
//	        	queryStr.append("           and VPS_ETD_DT BETWEEN TO_DATE( '"+fmd_dt+"', 'YYYYMMDD' ) AND TO_DATE( '"+tod_dt+"', 'YYYYMMDD' ) + 0.9999     \n");
//	        	queryStr.append("           and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   \n"); 
//	        }
//	        
//	        if(!fma_dt.equals("")){
//	        	queryStr.append("           and VPS_ETA_DT BETWEEN TO_DATE( '"+fma_dt+"', 'YYYYMMDD' ) AND TO_DATE( '"+toa_dt+"', 'YYYYMMDD' ) + 0.9999     \n");
//	        	queryStr.append("           and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  \n");
//	        }
//	        
//	        if(!eve_loc.equals("")){
//	        	queryStr.append("			AND VPS_PORT_CD LIKE '"+eve_loc+"%' 	\n");
//	        }
//	        
//	        queryStr.append("        		AND CLPT_IND_SEQ = '1'   \n");
//	        queryStr.append("     		) v    \n");
//	        
//        } 
//
//        queryStr.append("      	WHERE  h.cop_sts_cd IN ('C','T','F')   \n");
//        queryStr.append("       	AND h.cntr_no <> 'SMCU0000000'  \n");
//        
//        if(vvd.equals("")){
//	        queryStr.append("       	and h.TRNK_VSL_CD = substr(v.vvd, 1, 4)   \n");
//	        queryStr.append("       	and h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4)   \n");
//	        queryStr.append("       	and h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1) ) hb,   \n");
//        } else {
//        	if(questExp.length() > 0) questExp.delete(0, questExp.length());
//        	for(int j = 0;j < arr_vvd.length - 1;j++){
//        		questExp.append(",?");
//        	}
//        	queryStr.append("			AND h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD in ( ?		\n");
//        	queryStr.append("			"+questExp.toString()+" ,'')     ) hb,                                  \n");
//        }
//        
//
//
////        queryStr.append("       EDI_GRP_CUST e, edi_grp_cgo cgo, bkg_bkg_cust bkg_cust    \n");
////        queryStr.append("       WHERE ( (hb.shpr_cnt_cd = e.cust_cnt_cd AND hb.shpr_seq = e.cust_seq)  \n");
////        queryStr.append("       	OR (hb.cnee_cnt_cd = e.cust_cnt_cd AND hb.cnee_seq = e.cust_seq)  \n");
////        queryStr.append("       	OR (hb.act_cust_cnt_cd = e.cust_cnt_cd AND hb.act_cust_seq = e.cust_seq)  \n");
////        queryStr.append("       	OR (hb.ntfy_cnt_cd = e.cust_cnt_cd AND hb.ntfy_seq = e.cust_seq) \n");
////        queryStr.append("       	OR (hb.frt_fwrd_cnt_cd = e.cust_cnt_cd  AND hb.frt_fwrd_seq = e.cust_seq) \n");
////        queryStr.append("       	OR (hb.edi_cnt_cd = e.cust_cnt_cd AND hb.edi_seq = e.cust_seq) \n");
////        queryStr.append("       	OR (hb.sc_no = e.sc_no) )  \n");
//        
////      bkg_bkg_cust 사용 추가 : 2002701 iskim
////        queryStr.append("				WHERE hb.bkg_no = bkg_cust.bkg_no \n") ;
////        queryStr.append("                  and hb.bkg_no_split = bkg_cust.bkg_no_split \n") ;
////        queryStr.append("                  and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- S \n") ;
////        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
////        queryStr.append("                          and bkg_cust_tp_cd = 'S' ) \n") ;
////        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- C \n") ;
////        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
////        queryStr.append("                          and bkg_cust_tp_cd = 'C' ) \n") ;
////        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- A \n") ;
////        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
////        queryStr.append("                          and bkg_cust_tp_cd = 'A' ) \n") ;
////        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- N \n") ;
////        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
////        queryStr.append("                          and bkg_cust_tp_cd = 'N' ) \n") ;
////        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- F \n") ;
////        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
////        queryStr.append("                          and bkg_cust_tp_cd = 'F' ) \n") ;
////        queryStr.append("                      or (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- E \n") ;
////        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ \n") ;
////        queryStr.append("                          and bkg_cust_tp_cd = 'E' ) \n") ;
////        queryStr.append("                      or (hb.sc_no = e.sc_no ) ) \n") ;
//
//        queryStr.append("       EDI_GRP_CUST e, edi_grp_cgo cgo, bkg_bkg_cust bkg_cust, bkg_bkg_rt_hd bkg_rt    \n");
//        queryStr.append("				WHERE hb.bkg_no = bkg_cust.bkg_no \n") ;
//        queryStr.append("                  and hb.bkg_no_split = bkg_cust.bkg_no_split \n") ;
//        queryStr.append("				   and hb.bkg_no = bkg_rt.bkg_no \n") ;
//        queryStr.append("                  and hb.bkg_no_split = bkg_rt.bkg_no_split \n") ;
//        queryStr.append("                  and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- S \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ) \n") ;
//        queryStr.append("                      or (bkg_rt.sc_no = e.sc_no ) ) \n") ;
//        
//        
//        queryStr.append("       AND E.EDI_GRP_CD = '"+cs_grp_id+"'  \n");
//        queryStr.append("       AND e.edi_grp_cd = cgo.edi_grp_cd  \n");
//        queryStr.append("       AND E.CGO_TRC_SVC_FLG <> 'N'      \n");
//        queryStr.append("       AND cgo.EDI_STND_STS_CD = '"+eve_Sel+"' ) aa  \n");
//        queryStr.append("  where aa.cop_no = d.cop_No       \n");
//        queryStr.append("    	and d.STND_EDI_STS_CD = '"+eve_Sel+"'      \n");
//        
//        if(!eve_loc.equals("")){
//        	queryStr.append("		AND NOD_CD LIKE '"+eve_loc+"%' 	\n");
//        }
//        
//        try{
//        	con = getConnection(); 
//        	if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//        		ps = new LoggableStatement(con, queryStr.toString());
//        	}else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//        	
//        	if(!vvd.equals("")){
//        		for(int j = 0; j < arr_vvd.length ; j++){
//        			ps.setString(i++, arr_vvd[j]);
//        		}
//        	}
//        	
//        	log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//            
//            if (rs.next()) {
//            	return rs.getInt(1);
//            }
//            return 0;
//        } catch(SQLException se){
//        	log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//        }
//    }
//    
    
    /** Vessel Schedule Accuracy 조회
     * 
     * bkg_bkg_cust 사용 추가 : 2002701 iskim
     * 
     * @param parameterMap
     * @param iPage
     * @return
     * @throws DAOException
     */
//    public DBRowSet searchEstimationListddd(HashMap parameterMap,int iPage) throws DAOException{
//    	Connection con = null;              // Connection Interface
//        PreparedStatement ps = null;        // 정적파싱을 지원하는 SQL Statement
//        ResultSet rs = null;                // DB ResultSet
//        DBRowSet dRs = null;                // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//        int i = 1;
//        
//        String cs_grp_id   = JSPUtil.getNull((String)parameterMap.get("cs_grp_id"));   //grp_cd
//        String eve_Sel     = JSPUtil.getNull((String)parameterMap.get("eve_Sel"));  
//        String eve_loc   = JSPUtil.getNull((String)parameterMap.get("eve_loc"));   
//        String vvd   = JSPUtil.getNull((String)parameterMap.get("vvd"));  
//        String fmd_dt   = JSPUtil.getNull((String)parameterMap.get("fmd_dt")).replaceAll("-","");   
//        String tod_dt   = JSPUtil.getNull((String)parameterMap.get("tod_dt")).replaceAll("-","");   
//        String fma_dt   = JSPUtil.getNull((String)parameterMap.get("fma_dt")).replaceAll("-","");   
//        String toa_dt   = JSPUtil.getNull((String)parameterMap.get("toa_dt")).replaceAll("-","");   
//        
//        StringBuffer questExp = new StringBuffer();
//        String [] arr_vvd = new String[0];
//        
//        if(!vvd.equals("")){
//        	arr_vvd = vvd.split(",");
//        }
//        
////      페이징 처리
//        if(iPage == 0) iPage = 1;
//        
//		int currentPage = iPage;
//		int startPart   = Constants.PAGE_SIZE_300 * (currentPage - 1) + 1;
//		int endPart     = Constants.PAGE_SIZE_300 * currentPage;  
//
//        StringBuffer queryStr = new StringBuffer();
//        
//        queryStr.append("	select bkg_no,bkg_no_split,bl_no,cntr_no,edi_sts_cd,cust_sts_cd,nod_cd,vvd,estm_dt	\n"); 
//        queryStr.append("	,act_dt,Delays,dat_rcv_dt from (	\n");
//        queryStr.append("   select aa.bkg_no bkg_no, aa.bkg_no_split bkg_no_split, aa.cntr_no cntr_no, aa.a_edi_sts_cd edi_sts_cd,  aa.bl_no bl_no,   \n");
//        queryStr.append("    	aa.a_cust_edi_sts_cd cust_sts_cd, d.nod_cd nod_cd,  aa.vvd vvd, to_char(d.estm_dt,'YYYY-MM-DD HH24:MI:SS') estm_dt, to_char(d.act_dt,'YYYY-MM-DD HH24:MI:SS') act_dt, \n");
//        queryStr.append("       case when d.act_dt is not null then round((d.act_dt - d.estm_dt)*24) else round((GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS', 1, 5), SYSDATE, SUBSTR(d.nod_cd, 1, 5)) - d.estm_dt)*24) end Delays,  \n");
//        queryStr.append("       to_char(ACT_DAT_RCV_DT,'YYYY-MM-DD HH24:MI:SS') dat_rcv_dt, rownum no     \n");
//        queryStr.append("   from sce_cop_dtl d, (     \n");
////        queryStr.append("       SELECT /*+ USE_NL(hb e cgo h) */  \n");
////        queryStr.append("       SELECT /*+ USE_NL (hb bkg_cust e cgo) */  \n");
//        queryStr.append("       SELECT /*+ NO_QUERY_TRANSFORMATION */  \n");
////        queryStr.append("       SELECT  \n");
//        queryStr.append("       	DISTINCT vvd, hb.bkg_no, hb.bkg_no_split, cntr_no, por_cd, pol_cd, pod_cd, \n");
//        queryStr.append("        	del_cd, hb.cop_no, cgo.EDI_STND_STS_CD a_edi_sts_cd, cgo.CUST_EDI_STS_CD a_cust_edi_sts_cd,  \n");
//        queryStr.append("       	e.edi_grp_cd aaa, rail_chk, ts_chk ,bl_no \n");
//        queryStr.append("       FROM (     \n");
//        queryStr.append("       	SELECT /*+ USE_NL(v h b) */DISTINCT h.trnk_vsl_cd||h.trnk_skd_voy_no||h.trnk_skd_dir_cd vvd,   \n");
//        queryStr.append("       		h.bkg_no, h.bkg_no_split, h.cntr_no,h.por_cd,h.pol_cd, h.pod_cd, h.del_cd, h.cop_no, \n");
//        queryStr.append("       		h.sc_no,  h.shpr_cnt_cd, h.shpr_seq, h.cnee_cnt_cd, h.cnee_seq, h.act_cust_cnt_cd, \n");
//        queryStr.append("        		h.act_cust_seq, h.ntfy_cnt_cd, h.ntfy_seq, h.frt_fwrd_cnt_cd, h.frt_fwrd_seq , \n");
//        queryStr.append("        		h.edi_cnt_cd, h.edi_seq, h.COP_RAIL_CHK_CD rail_chk, h.N1ST_TS_PORT_CD ts_chk ,b.bl_no||b.bl_no_tp||b.bl_no_chk  bl_no    \n");
//        queryStr.append("        	FROM sce_cop_hdr h , bkg_booking b    \n");
//        
//        if(vvd.equals("")){
//	        queryStr.append("      		,  ( SELECT /*+ i ndex (VSK_VSL_PORT_SKD XAK1VSK_VSL_PORT_SKD) */  VSL_CD || SKD_VOY_NO || SKD_DIR_CD vvd   \n");
//	        queryStr.append("       	FROM VSK_VSL_PORT_SKD   \n");
//	        queryStr.append("           WHERE NVL(CNG_STS_CD, ' ') <> 'S'   \n");
//	        if(!fmd_dt.equals("")){
//	        	queryStr.append("           and VPS_ETD_DT BETWEEN TO_DATE( '"+fmd_dt+"', 'YYYYMMDD' ) AND TO_DATE( '"+tod_dt+"', 'YYYYMMDD' ) + 0.9999     \n");
//	        	queryStr.append("           and NVL(TURN_PORT_IND_CD, ' ') NOT IN ('V', 'D', 'F')   \n"); 
//	        }
//	        
//	        if(!fma_dt.equals("")){
//	        	queryStr.append("           and VPS_ETA_DT BETWEEN TO_DATE( '"+fma_dt+"', 'YYYYMMDD' ) AND TO_DATE( '"+toa_dt+"', 'YYYYMMDD' ) + 0.9999     \n");
//	        	queryStr.append("           and NVL(TURN_PORT_IND_CD, ' ') IN ('N', 'V', 'D', 'F')  \n");
//	        }
//	        
//	        if(!eve_loc.equals("")){
//	        	queryStr.append("			AND VPS_PORT_CD LIKE '"+eve_loc+"%' 	\n");
//	        }
//	        
//	        queryStr.append("        		AND CLPT_IND_SEQ = '1'   \n");
//	        queryStr.append("     		) v    \n");
//	        
//        } 
//
//        queryStr.append("      	WHERE  b.bkg_no = h.bkg_no  			\n");
//        queryStr.append("			AND b.bkg_no_split = h.bkg_no_split		\n");
//        queryStr.append("			and h.cop_sts_cd IN ('C','T','F')      \n");	
//        queryStr.append("       	AND h.cntr_no <> 'SMCU0000000'  \n");
//        
//        
//        if(vvd.equals("")){
//	        queryStr.append("       	and h.TRNK_VSL_CD = substr(v.vvd, 1, 4)   \n");
//	        queryStr.append("       	and h.TRNK_SKD_VOY_NO = substr(v.vvd, 5, 4)   \n");
//	        queryStr.append("       	and h.TRNK_SKD_DIR_CD = substr(v.vvd, 9, 1) ) hb,   \n");
//        } else {
//        	if(questExp.length() > 0) questExp.delete(0, questExp.length());
//        	for(int j = 0;j < arr_vvd.length - 1;j++){
//        		questExp.append(",?");
//        	}
//        	queryStr.append("			AND h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD in ( ?		\n");
//        	queryStr.append("			"+questExp.toString()+" ,'')     ) hb,                                  \n");
//        }
//        
//        queryStr.append("       EDI_GRP_CUST e, edi_grp_cgo cgo, bkg_bkg_cust bkg_cust, bkg_bkg_rt_hd bkg_rt    \n");
//        queryStr.append("				WHERE hb.bkg_no = bkg_cust.bkg_no \n") ;
//        queryStr.append("                  and hb.bkg_no_split = bkg_cust.bkg_no_split \n") ;
//        queryStr.append("				   and hb.bkg_no = bkg_rt.bkg_no \n") ;
//        queryStr.append("                  and hb.bkg_no_split = bkg_rt.bkg_no_split \n") ;
//        queryStr.append("                  and ( (e.CUST_CNT_CD = bkg_cust.CUST_CNT_CD -- S \n") ;
//        queryStr.append("                          and e.CUST_SEQ = bkg_cust.CUST_SEQ) \n") ;
//        queryStr.append("                      or (bkg_rt.sc_no = e.sc_no ) ) \n") ;
//        
//        queryStr.append("       AND E.EDI_GRP_CD = '"+cs_grp_id+"'  \n");
//        queryStr.append("       AND e.edi_grp_cd = cgo.edi_grp_cd  \n");
//        queryStr.append("       AND E.CGO_TRC_SVC_FLG <> 'N'      \n");
//        queryStr.append("       AND cgo.EDI_STND_STS_CD = '"+eve_Sel+"' ) aa  \n");
//        queryStr.append("  where aa.cop_no = d.cop_No       \n");
//        queryStr.append("    	and d.STND_EDI_STS_CD = '"+eve_Sel+"'      \n");
//        
//        if(!eve_loc.equals("")){
//        	queryStr.append("		AND NOD_CD LIKE '"+eve_loc+"%' 	\n");
//        }
//        queryStr.append("	)ll	\n");
//        queryStr.append("	where no between "+startPart+" and "+endPart+"	\n");
//        try{
//        	con = getConnection(); 
//        	if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//        		ps = new LoggableStatement(con, queryStr.toString());
//        	}else{
//                ps = con.prepareStatement(queryStr.toString());
//            }
//        	
//        	if(!vvd.equals("")){
//        		for(int j = 0; j < arr_vvd.length ; j++){
//        			ps.setString(i++, arr_vvd[j]);
//        		}
//        	}
//        	
//        	log.info("\n getDataToQuery :" + ((LoggableStatement)ps).getQueryString());
//            rs = ps.executeQuery();
//
//            dRs = new DBRowSet();
//            dRs.populate(rs);
//            return dRs;
//        }catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//            closeResultSet(rs);
//            closeStatement(ps);
//            closeConnection(con);
//		}
//    }

    /** Vessel Estimation Accuracy 조회
     * 
     * @param SearchEstimationListVO searchEstimationListVO
     * @return List<SearchEstimationListVO>
     * @throws DAOException
     */
    	public List<SearchEstimationListVO> searchEstimation(SearchEstimationListVO searchEstimationListVO) throws DAOException {

    		DBRowSet dbRowset = null;
    		List<SearchEstimationListVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (searchEstimationListVO != null) {
    				Map<String, String> mapVO = searchEstimationListVO
    						.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    				// VVD MULTI 처리
    				if (velParam.get("vvd") != null
    						&& !((String) velParam.get("vvd")).trim().equals("")) {
    					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase()
    							.split(","));
    				}
    			}
 
    			dbRowset = new SQLExecuter("")
    					.executeQuery(
    							(ISQLTemplate) new CustomerEdiDBDAOSearchEstimationListRSQL(),
    							param, velParam);

    			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
    					SearchEstimationListVO.class);

    		} catch (SQLException se) {
    			log.error(se.getMessage(), se);
    			throw new DAOException(new ErrorHandler(se).getMessage());
    		} catch (Exception ex) {
    			log.error(ex.getMessage(), ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage());
    		}
    		return list;
    	}    
    	
    /** My Performance Report 대상 갯수 조회
     * @param CustomerInqChoiceVO perMod
     * @return int
     * @throws DAOException
     */
    public int updatePerformanceCnt(CustomerInqChoiceVO perMod) throws DAOException{
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{        	
        	if (perMod != null) {
				Map<String, String> mapVO = perMod.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			log.info("param==" + param);
			log.info("velParam==" + velParam);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOUpdatePerformanceCntRSQL(),
					param, velParam);
			
			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				log.info("dbRowset.getInt(1)=== " +temp);
        	}
			return temp;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** My Performance Report Modify 저장전 삭제
     * @param CustomerInqChoiceVO condition
     * @param CustomerInqChoiceVO[] models
     * @throws DAOException
     */
    public void updatePerformanceDelete(CustomerInqChoiceVO condition, CustomerInqChoiceVO[] models) throws DAOException{
    	
    	Collection<CustomerInqChoiceVO> uptModels = new ArrayList<CustomerInqChoiceVO>();
    	
    	try{
    		if(models==null){
				log.info("models is null...");
			}else {
				log.info("models.length ====> "+models.length);
			}
    		
//    		CustomerInqChoiceVO model = null;
//    		int cnt = models.length;
//			for(int i=0;i<cnt;i++){
//				model = (CustomerInqChoiceVO)models[i];
//				
//				if (model.getIbflag().length() > 0) {
//					//if (model.getIbflag().equals("U")) {
//					if(i > 0) {
//						models[i].setUserId(models[0].getUserId());
//						models[i].setEdiGrpId(models[0].getEdiGrpId());
//					}
//					uptModels.add(model);
//					//}
//				}
//			}
			
//			int[] uptCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> param = new HashMap<String, String> ();
			
			param.put("user_id", models[0].getUserId());
			param.put("edi_grp_id", models[0].getEdiGrpId());
			
			Map velParam= condition.getColumnValues();
//			log.info("velParam===>"+velParam);
			log.info("delModels===>"+uptModels.size());
			
//			if(uptModels.size()>0){
//				uptCnt = sqlExe.executeBatch(new CustomerEdiDBDAOUpdatePerfomanceDeleteDSQL(), uptModels, null);
			
			int cnt = sqlExe.executeUpdate(new CustomerEdiDBDAOUpdatePerfomanceDeleteDSQL(), param, velParam);
			
			log.info("cnt in delete = " + cnt);
//				for(int i=0;i<uptCnt.length;i++){
//					if(uptCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to delete No"+ i + " SQL");
//				}
//			}			
        } catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** My Performance Report Modify 저장
     * @param CustomerInqChoiceVO condition
     * @param CustomerInqChoiceVO[] models
     * @throws DAOException
     */
    public void updatePerformanceModify(CustomerInqChoiceVO condition, CustomerInqChoiceVO[] models) throws DAOException{
    	
    	Collection<CustomerInqChoiceVO> uptModels = new ArrayList<CustomerInqChoiceVO>();
    	
    	try{
    		if(models==null){
				log.info("models is null...");
			}else {
				log.info("models.length ====> "+models.length);
			}
    		
    		CustomerInqChoiceVO model = null;
    		int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (CustomerInqChoiceVO)models[i];

				if (model.getIbflag().length() > 0) {
					//if (model.getIbflag().equals("U")) {
					if(i > 0) {
						models[i].setUserId(models[0].getUserId());
						models[i].setEdiGrpId(models[0].getEdiGrpId());
					}
					uptModels.add(model);
					//}
				}
			}
			
			int[] uptCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map velParam= condition.getColumnValues();
			log.info("velParam===>"+velParam);
			log.info("delModels===>"+uptModels.size());
			
			if(uptModels.size()>0){
				uptCnt = sqlExe.executeBatch(new CustomerEdiDBDAOUpdatePerformanceModifyCSQL(), uptModels,velParam);
				for(int i=0;i<uptCnt.length;i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}			
        } catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** My Performance Report edi_usr_cust table에 저장
     * @param CustomerInqChoiceVO condition
     * @throws DAOException
     */
    public void updatePerformanceGroup(CustomerInqChoiceVO condition) throws DAOException{
    	// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{        	
        	if (condition != null) {
				Map<String, String> mapVO = condition.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	SQLExecuter sqlExe = new SQLExecuter("");
			log.info("param==" + param);
			log.info("velParam==" + velParam);
			int insCnt = 0;
			insCnt = sqlExe.executeUpdate(new CustomerEdiDBDAOUpdatePerformanceGroupCSQL(),
					param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** My Performance Report edi_usr_sts table에 저장
     * @param CustomerInqChoiceVO condition
     * @param CustomerInqChoiceVO[] models
     * @throws DAOException
     */
    public void updatePerformance(CustomerInqChoiceVO condition, CustomerInqChoiceVO[] models) throws DAOException{
    	
    	Collection<CustomerInqChoiceVO> uptModels = new ArrayList<CustomerInqChoiceVO>();
    	
    	try{
    		if(models==null){
				log.info("models is null...");
			}else {
				log.info("models.length ====> "+models.length);
			}
    		
    		CustomerInqChoiceVO model = null;
    		int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (CustomerInqChoiceVO)models[i];

				if (model.getIbflag().length() > 0) {
					//if (model.getIbflag().equals("U")) {
					if(i > 0) {
						models[i].setUserId(models[0].getUserId());
						models[i].setEdiGrpId(models[0].getEdiGrpId());
					}
					uptModels.add(model);
					//}
				}
			}
			
			int[] uptCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map velParam= condition.getColumnValues();
			log.info("velParam===>"+velParam);
			log.info("delModels===>"+uptModels.size());
			
			if(uptModels.size()>0){
				uptCnt = sqlExe.executeBatch(new CustomerEdiDBDAOUpdatePerformanceDataCSQL(), uptModels,velParam);
				for(int i=0;i<uptCnt.length;i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}			
        } catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** My Page - My Customer 조회
     * @param String fUserId
     * @return List<SearchMyCustomerVO>
     * @throws DAOException
     */
    public List<SearchMyCustomerVO> searchMyCustomer(String fUserId) throws DAOException{
    	
    	log.info("searchMyCustomer를 실행합니다.");
    	log.info("fUserId==========="+fUserId);
    	
    	DBRowSet dbRowset = null;
		List<SearchMyCustomerVO> list = null;
    	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
    		param.put("f_user_id", String.valueOf(fUserId));
    		velParam.put("f_user_id", String.valueOf(fUserId));
    		log.info("velParam===" +velParam);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchMyCustomerRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchMyCustomerVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
    
    /** My Page - My Performance 조회
     * @param String fUserId
     * @return List<SearchMyPerformanceVO>
     * @throws DAOException
     */
    public List<SearchMyPerformanceVO> searchMyPerformance(String fUserId) throws DAOException{
    	
    	log.info("searchMyCustomer를 실행합니다.");
    	
    	DBRowSet dbRowset = null;
		List<SearchMyPerformanceVO> list = null;
    	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			/*if (myPerf != null) {
				Map<String, String> mapVO = myPerf.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("VO-PARAM1:"+ myPerf.getEdiGrpCd());
				log.info("searchMyPerformance를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}*/
        	param.put("f_user_id", String.valueOf(fUserId));
    		velParam.put("f_user_id", String.valueOf(fUserId));
    		log.info("velParam===" +velParam);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchMyPerformanceRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchMyPerformanceVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
    
    /** My Page - My Customer 삭제
     * @param SearchCustomerInfoVO condition
     * @param SearchCustomerInfoVO[] models
     * @throws DAOException
     */
    public void deleteMyCustomer(SearchCustomerInfoVO condition, SearchCustomerInfoVO[] models) throws DAOException{
    	
    	Collection<SearchCustomerInfoVO> delModels = new ArrayList<SearchCustomerInfoVO>();
    	
    	try{
    		if(models==null){
				log.info("models is null...");
			}else {
				log.info("models.length ====> "+models.length);
			}
    		
    		SearchCustomerInfoVO model = null;
    		int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (SearchCustomerInfoVO)models[i];
				if (model.getIbflag().length() > 0) {
					//if (model.getIbflag().equals("D")) {
						delModels.add(model);
					//}
				}
			}
			
			int[] delCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map velParam= condition.getColumnValues();
			log.info("velParam===>"+velParam);
			log.info("delModels===>"+delModels.size());
			
			if(delModels.size()>0){
				delCnt = sqlExe.executeBatch(new CustomerEdiDBDAODeleteMyCustomerDSQL(), delModels,velParam);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}			
        } catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** My Page - My Performace 삭제   (edi_usr_cust table 삭제)
     * @param SearchCustomerInfoVO condition
     * @param SearchCustomerInfoVO[] models
     * @throws DAOException
     */
    public void deleteMyPerformance(SearchCustomerInfoVO condition, SearchCustomerInfoVO[] models) throws DAOException{ 

    	Collection<SearchCustomerInfoVO> delModels = new ArrayList<SearchCustomerInfoVO>();
    	
    	try{
    		if(models==null){
				log.info("models is null...");
			}else {
				log.info("models.length ====> "+models.length);
			}
    		
    		SearchCustomerInfoVO model = null;
    		int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (SearchCustomerInfoVO)models[i];
				if (model.getIbflag().length() > 0) {
					//if (model.getIbflag().equals("D")) {
						delModels.add(model);
					//}
				}
			}
			
			int[] delCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map velParam= condition.getColumnValues();
			log.info("velParam===>"+velParam);
			log.info("delModels===>"+delModels.size());
			
			if(delModels.size()>0){
				delCnt = sqlExe.executeBatch(new CustomerEdiDBDAODeleteMyPerformanceDSQL(), delModels,velParam);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}			
        } catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /** My Page - My Performace1 삭제 (edi_usr_sts table 삭제)
     * 
     * @param parameterMap
     * @return
     * @throws DAOException
     */
//    public void deleteMyPerformance1(HashMap parameterMap) throws DAOException{ 
//    	Connection        con    = null;
//        PreparedStatement pstmt  = null;
//        int idx = 1;
//
//        String tp_id   = JSPUtil.getNull((String)parameterMap.get("f_tp_id"));     //  group id
//        int cnt   = Integer.parseInt(JSPUtil.getNull((String)parameterMap.get("f_cnt1")));  
//        String user_id   = JSPUtil.getNull((String)parameterMap.get("f_user_id"));   //   user_id
//        
//        String [] arr_tp_id = tp_id.split(",");
//
//        StringBuffer queryStr = new StringBuffer() ;
//
//        queryStr.append("  delete from edi_usr_sts   			  \n");
//        queryStr.append("  where edi_sts_seq = 2   				  \n");
//        queryStr.append("  		 and cre_usr_id = '"+user_id+"'   \n");
//        queryStr.append("   	 and edi_grp_cd = ?    			  \n");
//        
//       try{
//    	   con = getConnection();
//    	   
//    	   if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//    		   pstmt = new LoggableStatement(con, queryStr.toString());
//           } else {
//        	   pstmt = con.prepareStatement(queryStr.toString());
//           }
//    	   
//    	   for(int i=0 ; i < cnt ; i++){
//    		   idx = 1 ;
//    		   
//    		   pstmt.clearParameters() ;
//	           pstmt.setString(idx++, arr_tp_id[i]);
//       		
//	       	   pstmt.executeUpdate();
//    	   }
//    	   
//       } catch (SQLException se) {
//           log.error(se.getMessage(), se);
//           throw new DAOException(new ErrorHandler(se).getMessage());
//       } catch (DAOException de) {
//           log.error(de.getMessage(), de);
//           throw de;
//       } catch (Exception e) {
//           log.error(e.getMessage(), e);
//           throw new DAOException(e.getMessage());
//       } finally {
//           closeStatement(pstmt);
//           closeConnection(con);
//       }
//    }

    /**
     * My Performance 추출<br>
     * @param SearchEDIPerformanceOptionsVO schEdOpts
     * @return List<GetMyPerformanceSelectVO
     * @exception DAOException
     */
    public List<GetMyPerformanceSelectVO> getMyPerformance(SearchEDIPerformanceOptionsVO schEdOpts)throws DAOException{    
    	DBRowSet dbRowset = null;
		List<GetMyPerformanceSelectVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
	       if (schEdOpts != null) {
				Map<String, String> mapVO = schEdOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOGetMyPerformanceSelectRSQL(),param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,GetMyPerformanceSelectVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }    
    
    /**
     * EDI manual 전송시 입력한 location 유효성 체크 
     * @param List<Edi315SendVO> models
     * @param boolean ibflgChk
     * @return String
     * @throws EventException
     */    
    public String searchMdmLocation(List<Edi315SendVO> models,  boolean ibflgChk) throws DAOException{ 
    	log.info("\n ####### searchMdmLocation step1");    	
    	DBRowSet dbRowset = null;
		Set<String> nodCdSet  = new HashSet<String>();  
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
        String nonExistsLocCd = "";     	        
	    try{
	    	
	    	List<Edi315SendVO> addModels = new ArrayList<Edi315SendVO>();  
	    	if(models != null && models.size() > 0){
	    		for(int i=0; i<models.size(); i++){
	    			Edi315SendVO vo = (Edi315SendVO)models.get(i);
	    			String isSave = vo.getIbflag();
		            if(ibflgChk){
		    			if("I".equals(isSave)){
		                	addModels.add(vo);		    				
							nodCdSet.add("'"+vo.getEventYard().substring(0,5)+"'");		    				
		    			}		            	
		            }else{
	                	addModels.add(vo);		            	
						nodCdSet.add("'"+vo.getEventYard().substring(0,5)+"'");		            	
		            }
	    		}
	    	}
	        param.put("nod_cd", nodCdSet.toArray());
			velParam.put("nod_cd", nodCdSet.toArray());			

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchMdmLocationRSQL(),param,velParam);

				
           String[] list= new String[dbRowset.getRowCount()];
           int index = 0;
           while(dbRowset.next()){
        	   list[index] = dbRowset.getString("loc_cd");
        	   index++;
           }
           
	       //존재하지 않는 location code 걸러내기
	       int existsCount = 0;           
           if(addModels != null && addModels.size() > 0){
        	   for(int i=0; i<addModels.size(); i++){
   	            	boolean existFlag = false;
   	            	Edi315SendVO vo = (Edi315SendVO)addModels.get(i);
   	            	for(int k=0; k<list.length; k++){
   	            		
   	             	   if(list[k].equals(vo.getEventYard().substring(0,5))){
   	            		existFlag = true;
   	            		existsCount++;
   	            		break;            		   
                	   }    	            	   
   	            	}
   	            	
	   	            if(!existFlag){
			            if(existsCount > 0){
			            	//nonExistsLocCd += "," + vo.getEventYard();
			            	nonExistsLocCd = nonExistsLocCd + "," + vo.getEventYard();
			            }else{
			            	nonExistsLocCd = (String)vo.getEventYard();	            	
			            }	            	
		            }        		   
        	   }
       	   
           }

	log.info("\n ####### searchMdmLocation end   nonExistsLocCd:"+nonExistsLocCd);    	   
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	       return nonExistsLocCd;
	}
 
    /** Customer Information 다건 조회(EDI Status제외)
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return String[]
     * @throws DAOException
     */
    public String[] searchCsInfoList(CustomerEdiDBDAOOptionsVO cusEdiOpt) throws DAOException{
    	log.info("searchCsInfo is running");
    	DBRowSet dbRowset = null;
    	String[] csGrpId = new String[4];
    	int j			= 0;
    	CodeUtilBC commUtil = new CodeUtilBCImpl();
    	StringBuffer inStr    = new StringBuffer();
		StringBuffer inStr1	= new StringBuffer();
		StringBuffer inStr2	= new StringBuffer();
		StringBuffer inStr3	= new StringBuffer();
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (cusEdiOpt != null) {
				Map<String, String> mapVO = cusEdiOpt.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("convert_group_id", commUtil.convertStr(cusEdiOpt.getCsGrpId()));
				log.info("SearchEdiSummaryReportOptionsVO is just set up");
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchCsInfoListRSQL(),
					param, velParam);

			while (dbRowset.next()){
        	    //cs_grp_id
        	    inStr.append(((j == 0) ? "" : ",") + dbRowset.getString ("cs_grp_id").trim());
        	    //tp_id 인테 화면에서 보여지기 위해서 변형 
				inStr1.append(((j == 0) ? "" : ",") +" ("+dbRowset.getString ("cs_grp_id").trim()+")" + dbRowset.getString ("cs_desc").trim());
				inStr2.append(((j == 0) ? "" : ",") + dbRowset.getString ("tp_id").trim());
				inStr3.append(((j == 0) ? "" : ",") + dbRowset.getString ("cs_desc").trim());
	      	   j++;
           }
           
           csGrpId[0] = inStr.toString();  //cs_grp_id
           csGrpId[1] = inStr1.toString(); //화면에서 보여주기 위한 포맷변형값 저장 
           csGrpId[2] = inStr2.toString(); //tp_id
           csGrpId[3] = inStr3.toString(); //cs_desc
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return csGrpId;

    }
    
    /**
     * Performance Setting Info 조회 이벤트 처리.<br>
     * @param SearchPerRepPupModiVO searchPerRepPupModiVO
     * @return List<SearchPerRepPupModiVO>
     * @throws DAOException
     */
	    @SuppressWarnings("unchecked")
		public  List<SearchPerRepPupModiVO> searchUsrPerformanceSettingInfo(SearchPerRepPupModiVO searchPerRepPupModiVO) throws DAOException {
			DBRowSet dbRowset = null;		 
			List<SearchPerRepPupModiVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (searchPerRepPupModiVO != null) {
					Map<String, String> mapVO = searchPerRepPupModiVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerEdiDBDAOSearchUsrPerformanceSettingInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerRepPupModiVO .class);				

	        } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (DAOException de) {
				log.error(de.getMessage(), de);
				throw de;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			} 
	        return list;
	    }
	    
	    /**
	     * Performance Setting Info를 이전에 저장했는지 조회 이벤트 처리.<br>
	     * @param SearchCustomerInfoVO myCustInfo
	     * @return int
	     * @throws DAOException
	     */
		    public  int checkUsrPerformanceSettingInfo(SearchCustomerInfoVO myCustInfo) throws DAOException {
				DBRowSet dbRowset = null;		 
				int cnt = 0;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if (myCustInfo != null) {
						Map<String, String> mapVO = myCustInfo.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerEdiDBDAOCheckUsrPerformanceSettingInfoRSQL(), param, velParam);
					if (dbRowset.next()){
						cnt = dbRowset.getInt("CNT");
					}	

		        } catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (DAOException de) {
					log.error(de.getMessage(), de);
					throw de;
				} catch (Exception e) {
					log.error(e.getMessage(), e);
					throw new DAOException(e.getMessage());
				} 
		        return cnt;
		    }
		    
		    /**
		     * My Performance Report Edi Group code 별 EDI Standard Status Code 및 Customer Status Code 정보 조회<br>
		     * @param SearchCustomerInfoVO myCustInfo
		     * @return List<SearchPerRepPupModiVO>
		     * @throws DAOException
		     */
			    @SuppressWarnings("unchecked")
				public  List<SearchPerRepPupModiVO> searchEdiGrpCgoSts(SearchCustomerInfoVO myCustInfo) throws DAOException {
					DBRowSet dbRowset = null;		 
					List<SearchPerRepPupModiVO> list = null;
					// query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					// velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();
					try{
						if (myCustInfo != null) {
							Map<String, String> mapVO = myCustInfo.getColumnValues();
							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						log.info("poong_mycust:"+myCustInfo.getMycust());
						if (velParam.get("edi_sts") != null
								&& !((String) velParam.get("edi_sts")).trim().equals("")) {
							velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase()
									.split(","));
						}
						
						if (velParam.get("bzc_col") != null
								&& !((String) velParam.get("bzc_col")).trim().equals("")) {
							velParam.put("bzc_col", ((String) velParam.get("bzc_col")).toUpperCase()
									.split(","));
						}

						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerEdiDBDAOsearchEdiGrpCgoStsRSQL(), param, velParam);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerRepPupModiVO .class);

			        } catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage());
					} catch (DAOException de) {
						log.error(de.getMessage(), de);
						throw de;
					} catch (Exception e) {
						log.error(e.getMessage(), e);
						throw new DAOException(e.getMessage());
					} 
			        return list;
			    }
			    
			    /**
			     * Performance Basic Form 조회 이벤트 처리.<br>
			     * @param SearchCustomerInfoVO myCustInfo
			     * @return List<SearchPerRepPupModiVO>
			     * @throws DAOException
			     */
				    @SuppressWarnings("unchecked")
					public  List<SearchPerRepPupModiVO> searchUsrPerformanceBasicForm(SearchCustomerInfoVO myCustInfo) throws DAOException {
						DBRowSet dbRowset = null;		 
						List<SearchPerRepPupModiVO> list = null;
						// query parameter
						Map<String, Object> param = new HashMap<String, Object>();
						// velocity parameter
						Map<String, Object> velParam = new HashMap<String, Object>();

						try{
							if (myCustInfo != null) {
								Map<String, String> mapVO = myCustInfo.getColumnValues();
								param.putAll(mapVO);
								velParam.putAll(mapVO);
							}
							dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerEdiDBDAOSearchUsrPerformanceBasicFormRSQL(), param, velParam);
							list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPerRepPupModiVO .class);				

				        } catch (SQLException se) {
							log.error(se.getMessage(), se);
							throw new DAOException(new ErrorHandler(se).getMessage());
						} catch (DAOException de) {
							log.error(de.getMessage(), de);
							throw de;
						} catch (Exception e) {
							log.error(e.getMessage(), e);
							throw new DAOException(e.getMessage());
						} 
				        return list;
				    }
				    
				    /**  삭제 이벤트 처리
				     * My Performance Report EDI Group Code 정보 삭제
				     * @param SearchCustomerInfoVO myCustInfo
				     * @throws DAOException
				     */
				    public void removePerRepPupInfo(SearchCustomerInfoVO myCustInfo) throws DAOException{
				    	try { 
							int insCnt = 0;
							// query parameter
							Map<String, Object> param = new HashMap<String, Object>();
							// velocity parameter
							Map<String, Object> velParam = new HashMap<String, Object>();
							SQLExecuter sqlExe = new SQLExecuter("");
							
							if (myCustInfo != null) {
								Map<String, String> mapVO = myCustInfo.getColumnValues();
								param.putAll(mapVO);
								velParam.putAll(mapVO);
							}
							insCnt = sqlExe.executeUpdate(new CustomerEdiDBDAORemovePerRepPupInfoDSQL(), param, velParam);
							if(insCnt== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
							
						} catch (SQLException se) {
							log.error(se.getMessage(),se);
							throw new DAOException(new ErrorHandler(se).getMessage());
						}catch(Exception ex){
							log.error(ex.getMessage(),ex);
							throw new DAOException(new ErrorHandler(ex).getMessage());
						}
				    }
				    
				    /**  삭제 이벤트 처리
				     * My Performance Report EDI Group Code Detail 정보 삭제
				     * @param SearchCustomerInfoVO myCustInfo
				     * @throws DAOException
				     */
				    public void removePerRepPupDtlInfo(SearchCustomerInfoVO myCustInfo) throws DAOException{
				    	try {
							int insCnt = 0;
							// query parameter
							Map<String, Object> param = new HashMap<String, Object>();
							// velocity parameter
							Map<String, Object> velParam = new HashMap<String, Object>();
							SQLExecuter sqlExe = new SQLExecuter("");
							
							if (myCustInfo != null) {
								Map<String, String> mapVO = myCustInfo.getColumnValues();
								param.putAll(mapVO);
								velParam.putAll(mapVO);
							}
							insCnt = sqlExe.executeUpdate(new CustomerEdiDBDAORemovePerRepPupDtlInfoDSQL(), param, velParam);
							if(insCnt== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
							
						} catch (SQLException se) {
							log.error(se.getMessage(),se);
							throw new DAOException(new ErrorHandler(se).getMessage());
						}catch(Exception ex){
							log.error(ex.getMessage(),ex);
							throw new DAOException(new ErrorHandler(ex).getMessage());
						}
				    }
}
