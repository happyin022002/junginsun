/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInquiryDBDAO.java
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.26 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic.TCharterIOInquiryBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountSumListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchRfStatusListVO;

/**
 * NIS2010 TCharterIOInquiryDBDAO <br>
 * - NIS2010-TimeCharterInOutFleetManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Woo-Seok
 * @see TCharterIOInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class TCharterIOInquiryDBDAO extends DBDAOSupport {

	/**
	 * 선박 현황을 조회한다<br>
	 * 
	 * @param condSearchFleetStatusVO CondSearchFleetStatusVO
	 * @return List<SearchFleetStatusListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchFleetStatusListVO> searchFleetStatusList(CondSearchFleetStatusVO condSearchFleetStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFleetStatusListVO> searchFleetStatusListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchFleetStatusVO != null){
				param.put("sch_dt", condSearchFleetStatusVO.getSchDt());
				param.put("sch_dt_to", condSearchFleetStatusVO.getSchDtTo());
				param.put("flet_ctrt_tp_cd", condSearchFleetStatusVO.getContractType());
				param.put("vsl_size1", condSearchFleetStatusVO.getVslSize1());
				param.put("vsl_size2", condSearchFleetStatusVO.getVslSize2());
				param.put("gr_flg", condSearchFleetStatusVO.getGearWith());
				param.put("slan_cd", condSearchFleetStatusVO.getLaneCd());
				param.put("ownr_seq", condSearchFleetStatusVO.getOwnrSeq());
				
				velParam.put("period_flag", condSearchFleetStatusVO.getPeriodFlag());
				velParam.put("flet_ctrt_tp_cd", condSearchFleetStatusVO.getContractType());
				velParam.put("vsl_size_flag", condSearchFleetStatusVO.getVslSizeFlag());
				velParam.put("gr_flg", condSearchFleetStatusVO.getGearWith());
				velParam.put("slan_cd", condSearchFleetStatusVO.getLaneCd());
				velParam.put("ownr_seq", condSearchFleetStatusVO.getOwnrSeq());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOFmsContractRSQL(), param, velParam);
			searchFleetStatusListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFleetStatusListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchFleetStatusListVO;
	}

	/**
	 * 선박 현황을 Currency 별로 Hire 금액을 산출한다<br>
	 * 
	 * @param condSearchFleetStatusSumVO CondSearchFleetStatusSumVO
	 * @return List<SearchFleetStatusSumListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchFleetStatusSumListVO> searchFleetStatusSumList(CondSearchFleetStatusSumVO condSearchFleetStatusSumVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFleetStatusSumListVO> searchFleetStatusSumListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condSearchFleetStatusSumVO != null){
				param.put("sch_dt", condSearchFleetStatusSumVO.getSchDt());
				param.put("sch_dt_to", condSearchFleetStatusSumVO.getSchDtTo());
				param.put("flet_ctrt_tp_cd", condSearchFleetStatusSumVO.getContractType());
				param.put("vsl_size1", condSearchFleetStatusSumVO.getVslSize1());
				param.put("vsl_size2", condSearchFleetStatusSumVO.getVslSize2());
				param.put("gr_flg", condSearchFleetStatusSumVO.getGearWith());
				param.put("slan_cd", condSearchFleetStatusSumVO.getLaneCd());
				param.put("ownr_seq", condSearchFleetStatusSumVO.getOwnrSeq());
				
				velParam.put("period_flag", condSearchFleetStatusSumVO.getPeriodFlag());
				velParam.put("flet_ctrt_tp_cd", condSearchFleetStatusSumVO.getContractType());
				velParam.put("vsl_size_flag", condSearchFleetStatusSumVO.getVslSizeFlag());
				velParam.put("gr_flg", condSearchFleetStatusSumVO.getGearWith());
				velParam.put("slan_cd", condSearchFleetStatusSumVO.getLaneCd());
				velParam.put("ownr_seq", condSearchFleetStatusSumVO.getOwnrSeq());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOFmsContractSumRSQL(), param, velParam);
			searchFleetStatusSumListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFleetStatusSumListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchFleetStatusSumListVO;
	}

	/**
	 * 선박 용/대선 시작 이후 집행된 정산 요건에 대한 전체 정리 및 회차 별 개별 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchStatementOfAccountListVO> searchStatementOfAccountList(String fletCtrtNo, String hirNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStatementOfAccountListVO> searchStatementOfAccountListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("hir_no", hirNo);
			
			velParam.put("hir_no", hirNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOFmsConsultationRSQL(), param, velParam);
			searchStatementOfAccountListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStatementOfAccountListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchStatementOfAccountListVO;
	}
	 
	/**
	 * 선박 용/대선 시작 이후 집행된 정산 요건에 대한 전체 정리 및 회차 별 통화별로 합계 금액을 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountSumListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchStatementOfAccountSumListVO> searchStatementOfAccountSumList(String fletCtrtNo, String hirNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStatementOfAccountSumListVO> searchStatementOfAccountSumListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("hir_no", hirNo);
			
			velParam.put("hir_no", hirNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOFmsConsultationSumRSQL(), param, velParam);
			searchStatementOfAccountSumListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStatementOfAccountSumListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchStatementOfAccountSumListVO;
	}
	
	/**
	 * Capital Budget 자료를 조회한다<br>
	 * 
	 * @param effDt	String
	 * @param expDt	String
	 * @param vslCd	String
	 * @return List<SearchCapitalBudgetListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCapitalBudgetListVO> searchCapitalBudgetList(String effDt, String expDt, String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCapitalBudgetListVO> searchCapitalBudgetListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("eff_dt", effDt);
			param.put("exp_dt", expDt);
			param.put("vsl_cd", vslCd);
			
			velParam.put("vsl_cd", vslCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOSearchCapitalBudgetListRSQL(), param, velParam);
			searchCapitalBudgetListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCapitalBudgetListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return searchCapitalBudgetListVO;
	}
	 
	/**
	 * 선박 용/대선 시작 이후 집행된 정산 요건에 대한 전체 정리 및 회차 별 통화별로 합계 금액을 조회한다<br>
	 * 
	 * @param effDt	String
	 * @param expDt	String
	 * @param vslCd	String
	 * @return List<SearchCapitalBudgetSumListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCapitalBudgetSumListVO> searchCapitalBudgetSumList(String effDt, String expDt, String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCapitalBudgetSumListVO> searchCapitalBudgetSumListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("eff_dt", effDt);
			param.put("exp_dt", expDt);
			param.put("vsl_cd", vslCd);
			
			velParam.put("vsl_cd", vslCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOSearchCapitalBudgetSumListRSQL(), param, velParam);
			searchCapitalBudgetSumListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCapitalBudgetSumListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCapitalBudgetSumListVO;
	}
		 
	 
	/**
	 * VVD로 RF 상태를 요약 조회한다.  <br>
	 * 
	 * @param vvd String
	 * @return List<SearchRfStatusListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")	 
	public List<SearchRfStatusListVO> searchRfStatusInquiryByVvdSummaryList(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfStatusListVO> searchRfStatusListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);			
			velParam.put("vvd", vvd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdSummaryListRSQL(), param, velParam);
			searchRfStatusListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRfStatusListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchRfStatusListVO;
	}	 
	 
	/**
	 * Discharging 조회
	 * 
	 * @param vvd String 
	 * @param pprt String
	 * @param indicator String
	 * @param preplantype String
	 * @return String
	 * @exception DAOException
	 */
	public String searchRfStatusInquiryByVvdSummaryDischarging(String vvd, String port, String indicator, String preplantype) throws DAOException {
		String retVal = "";			
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if (vvd != null && port != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("vvd", vvd);
				mapVO.put("port", port);					
				mapVO.put("indicator", indicator);
				mapVO.put("preplantype", preplantype);				
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdSummaryDischargingRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {					
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}					
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}	 
	 
/**
 * CellToCell 조회
 * 
 * @param vvd String 
 * @param pprt String
 * @param indicator String
 * @param preplantype String 
 * @return String
 * @exception DAOException
 */
public String searchRfStatusInquiryByVvdSummaryCellToCell(String vvd, String port, String indicator, String preplantype) throws DAOException {
	String retVal = "";			
	Map<String, Object> param = new HashMap<String, Object>();
	Map<String, Object> velParam = new HashMap<String, Object>();
	try {
		
		if (vvd != null && port != null) {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("vvd", vvd);
			mapVO.put("port", port);					
			mapVO.put("indicator", indicator);			
			mapVO.put("preplantype", preplantype);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		
		DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdSummaryCellToCellRSQL(), param, velParam);

		if(dbRowset.getRowCount() > 0) {					
			if (dbRowset.next()) {
				retVal = dbRowset.getString(1);
			}					
		}
	} catch (SQLException se) {
		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	} catch (Exception ex) {
		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	}
	return retVal;
}		
	
/**
 *  VVD로 RF 상태를 상세 조회 할 Port를 조회한다.<br>
 *
 * @param String vvd
 * @return String[] portCdList
 * @exception DAOException
 */
public String[] searchRfStatusPortCd(String vvd) throws DAOException {
    DBRowSet dbRowset = null;
    String[] portCdList = null;
    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{
        Map<String, String> mapVO = new HashMap<String, String>();
        mapVO.put("vvd"  , vvd);
        param.putAll(mapVO);        
        velParam.putAll(mapVO);

        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOSearchRfStatusPortCdListRSQL(), param, velParam);

        // Port
        // Indicator
        // Yard
        // Pre Plan Type
        int cnt = dbRowset.getRowCount()*4;
        portCdList = new String[cnt];
        int idx = 0;
        while(dbRowset.next()){
        	
        	log.debug("dbRowset.getString(1) = "+dbRowset.getString(1));        	        	
        	log.debug("idx = "+idx);
        	        	
        	portCdList[idx] = dbRowset.getString(1);        	
            idx++;

        	log.debug("dbRowset.getString(2) = "+dbRowset.getString(2));        	        	
        	log.debug("idx = "+idx);
        	        	
        	portCdList[idx] = dbRowset.getString(2);        	
            idx++;
            
            log.debug("dbRowset.getString(3) = "+dbRowset.getString(3));
        	log.debug("idx = "+idx);
            portCdList[idx] = dbRowset.getString(3);
            idx++;
            
            log.debug("dbRowset.getString(4) = "+dbRowset.getString(4));
        	log.debug("idx = "+idx);
            portCdList[idx] = dbRowset.getString(4);
            idx++;                        
        }
    }catch(SQLException se){
        log.error(se.getMessage(),se);
        throw new DAOException(new ErrorHandler(se).getMessage(), se);
    }catch(Exception ex){
        log.error(ex.getMessage(),ex);
        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    }
    return portCdList;
}


	
	/**
	 * VVD로 RF 상태를 상세 조회한다.(Loading)<br>
	 * 
	 * @param vvd String
	 * @param port String
	 * @return List<SearchRfStatusListVO>
	 * @exception DAOException
	 */	 
	public List<SearchRfStatusListVO> searchRfStatusInquiryByVvdDetailListLoading(String vvd, String port) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfStatusListVO> searchRfStatusListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			param.put("port", port);			
			velParam.put("vvd", vvd);
			velParam.put("port", port);			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailListLoadingRSQL(), param, velParam);			
			searchRfStatusListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRfStatusListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchRfStatusListVO;
	}
	
	/**
	 * VVD로 RF 상태를 상세 조회한다.(Discharging)<br>
	 * 
	 * @param vvd String
	 * @param port String
	 * @param indicator String
	 * @param yard String
	 * @param prePlanType String
	 * @return List<SearchRfStatusListVO>
	 * @exception DAOException
	 */	 
	public List<SearchRfStatusListVO> searchRfStatusInquiryByVvdDetailListDischarging(String vvd, String port, String indicator, String yard, String prePlanType) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfStatusListVO> searchRfStatusListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			param.put("port", port);			
			param.put("indicator", indicator);
			param.put("yard", yard);			
			param.put("prePlanType", prePlanType);			
			velParam.put("vvd", vvd);
			velParam.put("port", port);
			velParam.put("indicator", indicator);
			velParam.put("yard", yard);
			velParam.put("prePlanType", prePlanType);			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailListDischargingRSQL(), param, velParam);			
			searchRfStatusListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRfStatusListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchRfStatusListVO;
	}	
	
	/**
	 * VVD로 RF 상태를 상세 조회한다.(Cell To Cell )<br>
	 * 
	 * @param vvd String
	 * @param port String
	 * @param indicator String
	 * @param yard String 
	 * @param prePlanType String 
	 * @return List<SearchRfStatusListVO>
	 * @exception DAOException
	 */	 
	public List<SearchRfStatusListVO> searchRfStatusInquiryByVvdDetailListKind(String vvd, String port, String indicator, String yard, String prePlanType) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRfStatusListVO> searchRfStatusListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			param.put("port", port);			
			param.put("indicator", indicator);
			param.put("yard", yard);
			param.put("prePlanType", prePlanType);					
			velParam.put("vvd", vvd);
			velParam.put("port", port);
			velParam.put("indicator", indicator);
			velParam.put("yard", yard);
			velParam.put("prePlanType", prePlanType);			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailListKindRSQL(), param, velParam);			
			searchRfStatusListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRfStatusListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchRfStatusListVO;
	}		
}