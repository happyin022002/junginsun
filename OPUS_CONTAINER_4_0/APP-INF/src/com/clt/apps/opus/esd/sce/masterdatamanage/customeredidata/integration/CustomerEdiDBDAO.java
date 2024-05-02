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
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.basic.CustomerEdiBCImpl;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.CustomerEdiDBDAOOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCsInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchVesselSkdOptionsVO;
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * SCEM에 대한 DB 처리를 담당<br>
 * - SCEM Business Logic을 처리하기 위한 JDBC 작업수행.<br>f
 * 
 * @author yong_cheon_shin
 * @see CustomerEdiBCImpl 참조
 * @since J2EE 1.4
 */
public class CustomerEdiDBDAO  extends DBDAOSupport  {
    
	private static final long serialVersionUID = -5163573712138859660L;
    
    /**
     * EDI Customer Data Search<br>
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchCustomerDataVO>
     * @exception DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchCustomerDataVO> searchCustomerData(CustomerEdiDBDAOOptionsVO cusEdiOpt)throws DAOException{
    	log.debug("SearchCustomerData를 실행합니다.");
    	
    	DBRowSet dbRowset = null;
		List<SearchCustomerDataVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cusEdiOpt != null) {
				Map<String, String> mapVO = cusEdiOpt.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("VO-PARAM1:"+ cusEdiOpt.getCsCd());
				log.debug("SearchCustomerData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchEdiStatusDataVO> searchEdiStatusData(CustomerEdiDBDAOOptionsVO cusEdiOpt)throws DAOException{    
        log.debug("SearchEdiStatusData를 실행합니다.");
        
    	DBRowSet dbRowset = null;
		List<SearchEdiStatusDataVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cusEdiOpt != null) {
				Map<String, String> mapVO = cusEdiOpt.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.debug("VO-PARAM1:"+ cusEdiOpt.getCsCd());
				log.debug("SearchEdiStatusData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
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
    
    /** EDI Customer 정보 Search
     * @param CustomerInqChoiceVO custInq
     * @return List<SearchCustomerInqueryVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchCustomerInqueryVO> searchCustomerInquery(CustomerInqChoiceVO custInq) throws DAOException{
    	DBRowSet dbRowset = null;
		List<SearchCustomerInqueryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (custInq != null) {
				Map<String, String> mapVO = custInq.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			log.debug("param==" + param);
			log.debug("velParam==" + velParam);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CustomerEdiDBDAOSearchCustomerInqueryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerInqueryVO.class);
			
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{        	
        	if (custInq != null) {
				Map<String, String> mapVO = custInq.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				log.debug("param==" + param);
				log.debug("velParam==" + velParam);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CustomerEdiDBDAOSearchCustomerCntRSQL(),param, velParam);
				
				int temp = 0;
				if(dbRowset.next()) {
					temp = dbRowset.getInt(1);
					log.debug("dbRowset.getInt(1)=== " +temp);
					if (temp == 0) {
						updateCustomerInquery(custInq);        // 중복 데이터가 없으면 저장 한다..
					}
					return temp;
	        	}
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
			
			Map<String, String> param = custInq.getColumnValues();
			Map<String, String> velParam = custInq.getColumnValues();
			log.debug("velParam===" + velParam);

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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchCustomTpIdVO> searchCustomTpId(SearchEDIPerformanceOptionsVO schEpOpts)throws DAOException{    
        log.debug("searchCustomTpId is running");
    	DBRowSet dbRowset = null;
		List<SearchCustomTpIdVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("Pram: " + schEpOpts.getTpId());
				log.debug("SearchEDIPerformanceOptionsVO has been set");
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
    	log.debug("###EsdSce0035 - searchEdiSummaryReport is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			/*페이징 처리*/
            log.debug("###EsdSce0035 - Param[i_page] : " + schSROptsVO.getIPage());
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
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				if (velParam.get("bkg_no_") != null & !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null& !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null & !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if
				
				//페이징 세팅
				log.debug("###EsdSce0035 - Paging Parameter" + "START: " + String.valueOf(startPart) + " END:" + String.valueOf(endPart));				
				velParam.put("v_startpart",String.valueOf(startPart));
				velParam.put("v_endpart",String.valueOf(endPart));
				
				log.debug("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
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
    	log.debug("###EsdSce0035 - searchEdiSummaryReportCnt is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				
				if (velParam.get("bkg_no_") != null & !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null & !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null & !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if

				log.debug("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
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
    	log.debug("###EsdSce0035 - searchDetailMvmtReport is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			/*페이징 처리*/
            log.debug("###EsdSce0035 - Param[i_page] : " + schSROptsVO.getIPage());
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
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				if (velParam.get("bkg_no_") != null & !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null & !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null & !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if	
				
				//페이징 세팅
				log.debug("###EsdSce0035 - Paging Parameter" + "START: " + String.valueOf(startPart) + " END:" + String.valueOf(endPart));				
				velParam.put("v_startpart",String.valueOf(startPart));
				velParam.put("v_endpart",String.valueOf(endPart));
				log.debug("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
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
    	log.debug("###EsdSce0035 - searchDetailMvmtReportCnt is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				if (velParam.get("bkg_no_") != null & !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null & !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null & !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if
				
				log.debug("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
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
    	log.debug("###EsdSce0035 - searchDetailOtherReport is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			/*페이징 처리*/
            log.debug("###EsdSce0035 - Param[i_page] : " + schSROptsVO.getIPage());
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
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				if (velParam.get("bkg_no_") != null & !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null & !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null & !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if	
				
				//페이징 세팅
				log.debug("###EsdSce0035 - Paging Parameter" + "START: " + String.valueOf(startPart) + " END:" + String.valueOf(endPart));				
				velParam.put("v_startpart",String.valueOf(startPart));
				velParam.put("v_endpart",String.valueOf(endPart));				
				log.debug("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
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
    	log.debug("###EsdSce0035 - searchDetailOtherReportCnt is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0035  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	

				//bkg_no MULTI 처리
				if (velParam.get("bkg_no_") != null & !((String) velParam.get("bkg_no_")).trim().equals("")) {
					velParam.put("bkg_no_", ((String) velParam.get("bkg_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bkg_no_]  - " + ((String[])velParam.get("bkg_no_")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no_") != null & !((String) velParam.get("bl_no_")).trim().equals("")) {
					velParam.put("bl_no_", ((String) velParam.get("bl_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[bl_no_]  - " + ((String[])velParam.get("bl_no_")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0035  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no_") != null & !((String) velParam.get("cntr_no_")).trim().equals("")) {
					velParam.put("cntr_no_", ((String) velParam.get("cntr_no_")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no_")).length);
				}//if
				
				log.debug("###EsdSce0035 - SearchEdiSummaryReportOptionsVO is just set!");
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchCsInfoVO> searchCsInfo(SearchEdiSummaryReportOptionsVO schSROptsVO) throws DAOException{
    	log.debug("searchCsInfo is running");
    	DBRowSet dbRowset = null;
		List<SearchCsInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schSROptsVO != null) {
				Map<String, String> mapVO = schSROptsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("SearchEdiSummaryReportOptionsVO is just set up");
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
    	log.debug("###EsdSce0072 - searchCsTpIdInfoCnt is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
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
    
    /**
     * Actual Activity Inquiry Data 추출
     * @param SearchEdiActivityInquiryDataOptionsVO schEAIDOpts 
     * @return List<SearchEdiActivityInquiryDataVO>
     * @throws DAOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchEdiActivityInquiryDataVO> searchEdiActivityInquiryData(SearchEdiActivityInquiryDataOptionsVO schEAIDOpts)throws DAOException{    
        log.debug("searchEdiActivityInquiryData is running");
    	DBRowSet dbRowset = null;
		List<SearchEdiActivityInquiryDataVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
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
      	log.debug("###EsdSce0061 - searchCargoTrackingData is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schCtdOpts != null) {
				Map<String, String> mapVO = schCtdOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("###EsdSce0061 - param[bkg_no] :" +  param.get("bkg_no"));
				log.debug("###EsdSce0061 - param[cntr_no] :" +  param.get("cntr_no"));
				log.debug("###EsdSce0061 - SearchCargoTrackingDataOptionsVO is just set!");
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
      	log.debug("###EsdSce0061 - searchEdiStsDesc is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schCtdOpts != null) {
				Map<String, String> mapVO = schCtdOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("###EsdSce0061 - param[edi_grp_cd] :" +  param.get("edi_grp_cd"));
				log.debug("###EsdSce0061 - param[edi_sts] :" +  param.get("edi_sts"));
				log.debug("###EsdSce0061 - SearchCargoTrackingDataOptionsVO is just set!");
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
     * 화주별 EDI standard description을 조회.<br>
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchStsListVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchStsListVO> searchStsList(SearchEDIPerformanceOptionsVO schEpOpts)throws DAOException{
    	log.debug("searchStsList is running");
    	DBRowSet dbRowset = null;
		List<SearchStsListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
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
    	log.debug("###EsdSce0063 - searchVesselSkd is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			if (schVSlVO != null) {
				Map<String, String> mapVO = schVSlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("###EsdSce0063 - SearchVesselSkdOptionsVO is just set!");
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
    	log.debug("###EsdSce0063 - searchTotalVesselSkdCnt is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schVSlVO != null) {
				Map<String, String> mapVO = schVSlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("###EsdSce0063 - SearchTotalVesselSkdListOptionsVO is just set!");
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
    	log.debug("###EsdSce0072 - searchEDIPerformanceReport is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0072  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	
				
				//cust_cd MULTI 처리
				if (velParam.get("cust_cd") != null & !((String) velParam.get("cust_cd")).trim().equals("")) {
					velParam.put("cust_cd", ((String) velParam.get("cust_cd")).toUpperCase().split(","));
				}//if		
				
				//bkg_no MULTI 처리
				if (velParam.get("bkg_no") != null & !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[bkg_no]  - " + ((String[])velParam.get("bkg_no")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no") != null & !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[bl_no]  - " + ((String[])velParam.get("bl_no")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no") != null & !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[cntr_no]  - " + ((String[])velParam.get("cntr_no")).length);
				}//if		
				log.debug("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
			}
			
			log.debug("###EsdSce0072 - EDI_ARRAY:"  + param.get("edi_sts"));
			log.debug("###EsdSce0072 - CUST_ARRAY:" + param.get("cust_cd"));
			log.debug("###EsdSce0072 - cop_status:" + param.get("cop_status"));
			log.debug("###EsdSce0072 - trs_mode_:" + param.get("trs_mode_"));
			log.debug("###EsdSce0072 - POL_DATE1:"  + param.get("poletddate1_hidden"));
			log.debug("###EsdSce0072 - POL_DATE2:"  + param.get("poletddate2_hidden"));
			log.debug("###EsdSce0072 - POd_DATE1:"  + param.get("podetadate1_hidden"));
			log.debug("###EsdSce0072 - POd_DATE2:"  + param.get("podetadate2_hidden"));			
			log.debug("###EsdSce0072 - POL:"  + param.get("pol"));
			
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
    	log.debug("###EsdSce0072 - searchEDITotalPerformance is just running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0072  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[edi_sts]  - " + ((String[])velParam.get("edi_sts")).length);
				}//if	
				
				//cust_cd MULTI 처리
				if (velParam.get("cust_cd") != null & !((String) velParam.get("cust_cd")).trim().equals("")) {
					velParam.put("cust_cd", ((String) velParam.get("cust_cd")).toUpperCase().split(","));
				}//if		
				
				//bkg_no MULTI 처리
				if (velParam.get("bkg_no") != null & !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[bkg_no]  - " + ((String[])velParam.get("bkg_no")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no") != null & !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[bl_no]  - " + ((String[])velParam.get("bl_no")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no") != null & !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams[cntr_no]  - " + ((String[])velParam.get("cntr_no")).length);
				}//if		
				log.debug("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
			}
			
			log.debug("###EsdSce0072 - EDI_ARRAY:"  + param.get("edi_sts"));
			log.debug("###EsdSce0072 - CUST_ARRAY:" + param.get("cust_cd"));
			log.debug("###EsdSce0072 - cop_status:" + param.get("cop_status"));
			log.debug("###EsdSce0072 - trs_mode_:" + param.get("trs_mode_"));
			log.debug("###EsdSce0072 - POL_DATE1:"  + param.get("poletddate1_hidden"));
			log.debug("###EsdSce0072 - POL_DATE2:"  + param.get("poletddate2_hidden"));
			log.debug("###EsdSce0072 - POd_DATE1:"  + param.get("podetadate1_hidden"));
			log.debug("###EsdSce0072 - POd_DATE2:"  + param.get("podetadate2_hidden"));			
			log.debug("###EsdSce0072 - POL:"  + param.get("pol"));
			
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchComboPerformanceVO> searchComboPerformance(SearchEDIPerformanceOptionsVO schEpOpts) throws DAOException{
		log.debug("###EsdSce0072 - searchComboPerformance is just running.");
    	DBRowSet dbRowset = null;
		List<SearchComboPerformanceVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (schEpOpts != null) {
				Map<String, String> mapVO = schEpOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//edi_sts MULTI 처리
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					String[] array1 = ((String) velParam.get("edi_sts")).toUpperCase().split(",");
					log.debug("###EsdSce0072  Prams first - " + velParam.get("edi_sts") + " Size:" + array1.length);
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
					log.debug("###EsdSce0072  Prams second - " + ((String[])velParam.get("edi_sts")).length);
				}//if					
								
				log.debug("###EsdSce0072 - SearchEDIPerformanceOptionsVO is just set!");
			}else{
				log.debug("###EsdSce0072 - SearchEDIPerformanceOptionsVO is null");
			}
			
			log.debug("###EsdSce0072 - EDI_ARRAY:"  + param.get("edi_sts"));
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchCustStsVO> searchCustSts(SearchEDIPerformanceOptionsVO schEPOpts)throws DAOException{
    	log.debug("searchCustSts를 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchCustStsVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schEPOpts != null) {
				Map<String, String> mapVO = schEPOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//MULTI 처리
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
				}				
				
				log.debug("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchPerCsInfoVO> searchPerCsInfo(SearchEDIPerformanceOptionsVO schEPOpts)throws DAOException{
    	log.debug("searchPerCsInfo is running");
    	DBRowSet dbRowset = null;
		List<SearchPerCsInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schEPOpts != null) {
				Map<String, String> mapVO = schEPOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//MULTI 처리
				if (velParam.get("edi_sts") != null & !((String) velParam.get("edi_sts")).trim().equals("")) {
					velParam.put("edi_sts", ((String) velParam.get("edi_sts")).toUpperCase().split(","));
				}				
				
				log.debug("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchPerCsInfoRSQL(),
					param, velParam);
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
    	log.debug("searchPerCsTpIdInfo is running.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try {
			if (custOpts != null) {
				Map<String, String> mapVO = custOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
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
    
    /** 
     * Missing List popup 조회 
     * 
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchMissingListVO> searchMissingList(SearchMissingListVO searchMissingListVo) throws DAOException{ 
    	log.debug("searchMissingsList is running");
    	DBRowSet dbRowset = null;
    	List<SearchMissingListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchMissingListVo != null) {
				searchMissingListVo.unDataFormat();
				Map<String, String> mapVO = searchMissingListVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				log.debug("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
				log.debug("searchMissingListVo:"+searchMissingListVo.toString());	

				//bkg_no MULTI 처리
				if (velParam.get("bkg_no") != null & !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).toUpperCase().split(","));
					log.debug("###EsdSce0074  Prams[bkg_no]  - " + ((String[])velParam.get("bkg_no")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no") != null & !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).toUpperCase().split(","));
					log.debug("###EsdSce0074  Prams[bl_no]  - " + ((String[])velParam.get("bl_no")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0074  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no") != null & !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).toUpperCase().split(","));
					log.debug("###EsdSce0074  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no")).length);
				}//if
				

				log.debug("###EsdSce0074 - SearchEdiSummaryReportOptionsVO is just set!");			
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
    
    /** On-time List  popup 조회
     * 
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchMissingListVO> searchOnTimeList(SearchMissingListVO searchMissingListVo) throws DAOException{ 
    	log.debug("searchMissingsList is running");
    	DBRowSet dbRowset = null;
    	List<SearchMissingListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchMissingListVo != null) {
				searchMissingListVo.unDataFormat();				
				Map<String, String> mapVO = searchMissingListVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				log.debug("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
				log.debug("searchOnTimeList:"+searchMissingListVo.toString());	

				//bkg_no MULTI 처리
				if (velParam.get("bkg_no") != null & !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).toUpperCase().split(","));
					log.debug("###EsdSce0074  Prams[bkg_no]  - " + ((String[])velParam.get("bkg_no")).length);
				}//if
				
				//bl_no MULTI 처리 
				if (velParam.get("bl_no") != null & !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).toUpperCase().split(","));
					log.debug("###EsdSce0074  Prams[bl_no]  - " + ((String[])velParam.get("bl_no")).length);
				}//if					

				//vvd MULTI 처리 
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
					log.debug("###EsdSce0074  Prams[vvd]  - " + ((String[])velParam.get("vvd")).length);
				}//if					
				
				//cntr_no MULTI 처리 
				if (velParam.get("cntr_no") != null & !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).toUpperCase().split(","));
					log.debug("###EsdSce0074  Prams[cntr_no_]  - " + ((String[])velParam.get("cntr_no")).length);
				}//if
				
				log.debug("###EsdSce0074 - SearchEdiSummaryReportOptionsVO is just set!");			
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOSearchOnTimeListRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchMissingListVO.class);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;    
    }
    
    /**  My Performance Report Modify 조회
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchPerRepPupModiVO> searchPerRepPupModi(SearchCustomerInfoVO myCustInfo) throws DAOException{
    	DBRowSet dbRowset = null;
		List<SearchPerRepPupModiVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
        	if (myCustInfo != null) {
				Map<String, String> mapVO = myCustInfo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("param==" + param);
				log.debug("velParam==" + velParam);

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

    /** My Performance Report 대상 갯수 조회
     * @param CustomerInqChoiceVO perMod
     * @return int
     * @throws DAOException
     */
    public int updatePerformanceCnt(CustomerInqChoiceVO perMod) throws DAOException{
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{        	
        	if (perMod != null) {
				Map<String, String> mapVO = perMod.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			log.debug("param==" + param);
			log.debug("velParam==" + velParam);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomerEdiDBDAOUpdatePerformanceCntRSQL(),
					param, velParam);
			
			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				log.debug("dbRowset.getInt(1)=== " +temp);
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
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> param = new HashMap<String, String> ();
			
			param.put("user_id", models[0].getUserId());
			param.put("edi_grp_id", models[0].getEdiGrpId());
			
			Map<String, String> velParam= condition.getColumnValues();
			log.debug("delModels===>"+uptModels.size());
			
			int cnt = sqlExe.executeUpdate(new CustomerEdiDBDAOUpdatePerfomanceDeleteDSQL(), param, velParam);
			
			log.debug("cnt in delete = " + cnt);		
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void updatePerformanceModify(CustomerInqChoiceVO condition, CustomerInqChoiceVO[] models) throws DAOException{
    	Collection<CustomerInqChoiceVO> uptModels = new ArrayList<CustomerInqChoiceVO>();
    	
    	try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		CustomerInqChoiceVO model = null;
    		if(null != models){
	    		int cnt = models.length;
				for(int i=0;i<cnt;i++){
					model = (CustomerInqChoiceVO)models[i];
	
					if (model.getIbflag().length() > 0) {
						if(i > 0) {
							models[i].setUserId(models[0].getUserId());
							models[i].setEdiGrpId(models[0].getEdiGrpId());
						}
						uptModels.add(model);
					}
				}
    		}
			
			int[] uptCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map velParam= condition.getColumnValues();
			log.debug("velParam===>"+velParam);
			log.debug("delModels===>"+uptModels.size());
			
			if(uptModels.size()>0){
				uptCnt = sqlExe.executeBatch(new CustomerEdiDBDAOUpdatePerformanceModifyCSQL(), uptModels, velParam);
				for(int i=0;i<uptCnt.length;i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}			
        } catch (SQLException se) {
			//se.printStackTrace();
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{        	
        	if (condition != null) {
				Map<String, String> mapVO = condition.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	SQLExecuter sqlExe = new SQLExecuter("");
			log.debug("param==" + param);
			log.debug("velParam==" + velParam);

			sqlExe.executeUpdate(new CustomerEdiDBDAOUpdatePerformanceGroupCSQL(), param, null);
			
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void updatePerformance(CustomerInqChoiceVO condition, CustomerInqChoiceVO[] models) throws DAOException{
    	Collection<CustomerInqChoiceVO> uptModels = new ArrayList<CustomerInqChoiceVO>();
    	
    	try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		CustomerInqChoiceVO model = null;
    		if(null != models){
	    		int cnt = models.length;
	    		int iEditStsSeq = 0;
				for(int i=0;i<cnt;i++){
					model = (CustomerInqChoiceVO)models[i];
	
					if (model.getIbflag().length() > 0) {
						if(i > 0) {
							models[i].setUserId(models[0].getUserId());
							models[i].setEdiGrpId(models[0].getEdiGrpId());
							
						}
						model.setEdiStsSeq(String.valueOf(++iEditStsSeq));
						uptModels.add(model);
					}
				}
    		}
			
			int[] uptCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map velParam= condition.getColumnValues();
			log.debug("velParam===>"+velParam);
			log.debug("delModels===>"+uptModels.size());
			
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchMyCustomerVO> searchMyCustomer(String fUserId) throws DAOException{
    	
    	log.debug("searchMyCustomer를 실행합니다.");
    	log.debug("fUserId==========="+fUserId);
    	
    	DBRowSet dbRowset = null;
		List<SearchMyCustomerVO> list = null;
    	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
    		param.put("f_user_id", String.valueOf(fUserId));
    		velParam.put("f_user_id", String.valueOf(fUserId));
    		log.debug("velParam===" +velParam);
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchMyPerformanceVO> searchMyPerformance(String fUserId) throws DAOException{
    	log.debug("searchMyCustomer를 실행합니다.");
    	
    	DBRowSet dbRowset = null;
		List<SearchMyPerformanceVO> list = null;
    	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	param.put("f_user_id", String.valueOf(fUserId));
    		velParam.put("f_user_id", String.valueOf(fUserId));
    		log.debug("velParam===" +velParam);
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void deleteMyCustomer(SearchCustomerInfoVO condition, SearchCustomerInfoVO[] models) throws DAOException{
    	Collection<SearchCustomerInfoVO> delModels = new ArrayList<SearchCustomerInfoVO>();
    	
    	try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		SearchCustomerInfoVO model = null;
    		if(null != models){
	    		int cnt = models.length;
				for(int i=0;i<cnt;i++){
					model = (SearchCustomerInfoVO)models[i];
					if (model.getIbflag().length() > 0) {
							delModels.add(model);
					}
				}
    		}
			
			int[] delCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map velParam= condition.getColumnValues();
			log.debug("velParam===>"+velParam);
			log.debug("delModels===>"+delModels.size());
			
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void deleteMyPerformance(SearchCustomerInfoVO condition, SearchCustomerInfoVO[] models) throws DAOException{ 
    	Collection<SearchCustomerInfoVO> delModels = new ArrayList<SearchCustomerInfoVO>();
    	
    	try{
    		if(models==null){
				log.debug("models is null...");
			}else {
				log.debug("models.length ====> "+models.length);
			}
    		
    		SearchCustomerInfoVO model = null;
    		if(null != models){
	    		int cnt = models.length;
				for(int i=0;i<cnt;i++){
					model = (SearchCustomerInfoVO)models[i];
					if (model.getIbflag().length() > 0) {
						delModels.add(model);
					}
				}
    		}
			
			int[] delCnt = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map velParam= condition.getColumnValues();
			log.debug("velParam===>"+velParam);
			log.debug("delModels===>"+delModels.size());
			
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

    /**
     * My Performance 추출<br>
     * @param SearchEDIPerformanceOptionsVO schEdOpts
     * @return List<GetMyPerformanceSelectVO
     * @exception DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<GetMyPerformanceSelectVO> getMyPerformance(SearchEDIPerformanceOptionsVO schEdOpts)throws DAOException{    
        log.debug("getMyPerformance를 실행합니다.");
    	DBRowSet dbRowset = null;
		List<GetMyPerformanceSelectVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
	       if (schEdOpts != null) {
				Map<String, String> mapVO = schEdOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("SearchEDIPerformanceOptionsVO 를 위한 조회용 VO 파라미터를 정의하였습니다.");
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
    	log.debug("\n ####### searchMdmLocation step1");    	
    	DBRowSet dbRowset = null;
		Set<String> nodCdSet  = new HashSet<String>();
		Map<String, Object> param = new HashMap<String, Object>();
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
			            	nonExistsLocCd = nonExistsLocCd + "," + vo.getEventYard();
			            }else{
			            	nonExistsLocCd = (String)vo.getEventYard();	            	
			            }	            	
		            }        		   
        	   }
       	   
           }

           log.debug("\n ####### searchMdmLocation end   nonExistsLocCd:"+nonExistsLocCd);    	   
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	       return nonExistsLocCd;
	}
    	        
}