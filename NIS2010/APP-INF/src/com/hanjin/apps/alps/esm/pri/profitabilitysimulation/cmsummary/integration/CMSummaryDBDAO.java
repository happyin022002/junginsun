/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMSummaryDBDAO.java
*@FileTitle : Revenue Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.29 이승준
* 1.0 Creation
=========================================================
* History
* 2011.06.29 김민아 [CHM-201111837] Split 20-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 : DUAL Table을 부적절하게 사용한 DBDAO의 SQL을 .Query로 이동
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic.CMSummaryBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryDownExcelVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalSummarySimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InRevenueLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltCoaWkPrdVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriAuthorizationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriCMSummaryCustomerListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriMdmSlsRepVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentCmSummarySimulationDateParamVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentSummaryChartTargetListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsCheckRegionCodeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsCmSummaryHistoryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalSummaryChartTargetListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriPrsCmSmrySimTmpVO;


/**
 * NIS2010 CMSummaryDBDAO <br>
 * - NIS2010-ProfitabilitySimulation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung-Jun,Lee
 * @see CMSummaryBCImpl 참조
 * @since J2EE 1.6
 */
public class CMSummaryDBDAO extends DBDAOSupport {

	/**
	 * REV_LANE 의 코드, destription list를 조회한다.<br>
	 * 
	 * @param InRevenueLaneVO inRevenueLaneVO
	 * @return List<InRevenueLaneVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InRevenueLaneVO> searchRevenueLaneList(InRevenueLaneVO inRevenueLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InRevenueLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inRevenueLaneVO != null){
				Map<String, String> mapVO = inRevenueLaneVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAOInRevenueLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InRevenueLaneVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return list;
	}
	 
	 
	 
		/**
		 * CCM/OP Summary & Simulation , Contract Proposal의 CM 데이터를 조회 합니다
		 * 
		 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchProposalCmSummaryList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(inPrsProposalCmSummaryVO != null){
					Map<String, String> mapVO = inPrsProposalCmSummaryVO .getColumnValues();
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsProposalCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsProposalCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					
					String slaneList = inPrsProposalCmSummaryVO.getFrmSlaneCd();
					if( slaneList != null &&  slaneList.length() != 0 ){
						List<String> slaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(slaneList,";");
						while(st.hasMoreTokens()){
							slaneListArr.add(st.nextToken());
						}
						velParam.put("slane_list", slaneListArr);
					}
					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					velParam.put("crg_tp_str", sbCargo.toString());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsProposalCmSummaryVORSQL(), param, velParam);
				//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPrsProposalCmSummaryVO .class);
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return dbRowset;
		}	 
		 
		 

		 
		/**
		 * CM/OP Summary & Simulation , Contract Approval  값을 조회처리.<br>
		 * 
		 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
		 * @param RsltPrsAmendmentCmSummarySimulationDateParamVO rsltPrsAmendmentCmSummarySimulationDateParamVO
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchAmendmentCmSummaryList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO,RsltPrsAmendmentCmSummarySimulationDateParamVO rsltPrsAmendmentCmSummarySimulationDateParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO2 = rsltPrsAmendmentCmSummarySimulationDateParamVO.getColumnValues();

			try{
				if(inPrsAmendmentCmSummaryVO != null){
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO .getColumnValues();
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsAmendmentCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					
					String rlaneList = inPrsAmendmentCmSummaryVO.getFrmRlaneCd();
					if( rlaneList != null &&  rlaneList.length() != 0 ){
						List<String> rlaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(rlaneList,";");
						while(st.hasMoreTokens()){
							rlaneListArr.add(st.nextToken());
						}
						velParam.put("rlane_list", rlaneListArr);
					}
					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.putAll(mapVO2);
					velParam.putAll(mapVO2);
					
					velParam.put("crg_tp_str", sbCargo.toString());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsAmendmentCmSummaryVORSQL(), param, velParam);
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return dbRowset;
		}	
		 
		 
		 
		/**
		 * CM/OP Summary & Simulation , Contract Approval  Excel List 값을 조회처리.<br>
		 * 
		 * @param InPrsAmendmentCmSummaryDownExcelVO inPrsAmendmentCmSummaryDownExcelVO
		 * @param RsltPrsAmendmentCmSummarySimulationDateParamVO rsltPrsAmendmentCmSummarySimulationDateParamVO
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchAmendmentCmSummaryExcelList(InPrsAmendmentCmSummaryDownExcelVO inPrsAmendmentCmSummaryDownExcelVO,RsltPrsAmendmentCmSummarySimulationDateParamVO rsltPrsAmendmentCmSummarySimulationDateParamVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO2 = rsltPrsAmendmentCmSummarySimulationDateParamVO.getColumnValues();

			try{
				if(inPrsAmendmentCmSummaryDownExcelVO != null){
					Map<String, String> mapVO = inPrsAmendmentCmSummaryDownExcelVO .getColumnValues();
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpAk() != null 
							&& inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpBb() != null 
							&& inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpDg() != null 
							&& inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpDry() != null 
							&& inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpRf() != null 
							&& inPrsAmendmentCmSummaryDownExcelVO.getSearchedCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsAmendmentCmSummaryDownExcelVO.getSearchedCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					String rlaneList = inPrsAmendmentCmSummaryDownExcelVO.getSearchedRlaneCd();
					if( rlaneList != null &&  rlaneList.length() != 0 ){
						List<String> rlaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(rlaneList,";");
						while(st.hasMoreTokens()){
							rlaneListArr.add(st.nextToken());
						}
						velParam.put("rlane_list", rlaneListArr);
					}
					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.putAll(mapVO2);
					velParam.putAll(mapVO2);					
					velParam.put("crg_tp_str", sbCargo.toString());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsAmendmentCmSummaryDownExcelVORSQL(), param, velParam);
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return dbRowset;
		}	
			 		 
			 

		/**
		 * COA 주차 정보를 조회 합니다..<br>
		 * 
		 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
		 * @return List<RsltCoaWkPrdVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltCoaWkPrdVO> searchCoaWkPrdList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltCoaWkPrdVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				 
				if(inPrsAmendmentCmSummaryVO != null){
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
  
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltCoaWkPrdVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCoaWkPrdVO .class);
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return list;
		}			 
		 
		/**
		 * CM/OP Summary & Simulation Multi Customer 데이타 모델에 해당되는 값을 불러온다.<br>
		 * 
		 * @param RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO
		 * @return List<RsltPriCMSummaryCustomerListVO> 
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltPriCMSummaryCustomerListVO> searchCustomerList(RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPriCMSummaryCustomerListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				String custList = rsltPriCMSummaryCustomerListVO.getCustList();
				if(rsltPriCMSummaryCustomerListVO != null){
					Map<String, String> mapVO = rsltPriCMSummaryCustomerListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					List<String> custListArr = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(custList,";");
					while(st.hasMoreTokens()){
						custListArr.add(st.nextToken());
					}
					velParam.put("cust_list", custListArr);
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPriCMSummaryCustomerListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCMSummaryCustomerListVO .class);
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return list;
		}
		

		 
		/**
		 * CM/OP Summary & Simulation Multi Customer에서 하나의 customer 선택시 그 group에 포함된 데이터 를 조회 합니다.<br>
		 * 
		 * @param RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO
		 * @return List<RsltPriCMSummaryCustomerListVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltPriCMSummaryCustomerListVO> searchCustomerSelectedList(RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPriCMSummaryCustomerListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				
				String custList = rsltPriCMSummaryCustomerListVO.getCustList();
				if( custList != null &&  custList.length() != 0 ){
	 
					if(rsltPriCMSummaryCustomerListVO != null){
						Map<String, String> mapVO = rsltPriCMSummaryCustomerListVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						
						
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
						
						
						
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPriCMSummaryCustomerSelectedListVORSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCMSummaryCustomerListVO .class);
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return list;
		}
		
		 
		/**
		 * 화면에서 입력받은 조건으로 CM 값을 Simulation해서 결과를 조회한다.<br>
		 * 
		 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO  
		 * @param InPrsProposalSummarySimulationSetVO  inPrsProposalSummarySimulationSetVO  
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchProposalSummarySimulationList (InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO , InPrsProposalSummarySimulationSetVO inPrsProposalSummarySimulationSetVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			String strCustTpCd;
			String strChgCd;
			InPrsProposalSummarySimulationVO[] inPrsProposalSummarySimulationVOs = null;
			 
			try{
				
				if (inPrsProposalCmSummaryVO != null) {
					Map<String, String> mapVO = inPrsProposalCmSummaryVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				
				for(int i=0 ; i < inPrsProposalSummarySimulationSetVO.getSize() ; i++){
					log.debug("sheetName="+inPrsProposalSummarySimulationSetVO.getSheetName(i));
					log.debug("length="+inPrsProposalSummarySimulationSetVO.getInPrsProposalSummarySimulationVOs(i).length);
					
					inPrsProposalSummarySimulationVOs = inPrsProposalSummarySimulationSetVO.getInPrsProposalSummarySimulationVOs(i);
					for(int i2=0 ; i2 < inPrsProposalSummarySimulationVOs.length; i2++){
						
						if( "B".equals(inPrsProposalSummarySimulationVOs[i2].getCustTpCd() ) ){
							strCustTpCd = "IAO";
						}else if ("N".equals(inPrsProposalSummarySimulationVOs[i2].getCustTpCd() ) ){
							 strCustTpCd = "N";
						}else{
							 strCustTpCd = "IAON";
						}
						 
						if( "BUC".equals(inPrsProposalSummarySimulationVOs[i2].getChgCd() ) 
								|| "BAF".equals(inPrsProposalSummarySimulationVOs[i2].getChgCd() )
								|| "FRC".equals(inPrsProposalSummarySimulationVOs[i2].getChgCd() )){
							 strChgCd = "BUC,BAF,FRC";
						}else if ("IFC".equals(inPrsProposalSummarySimulationVOs[i2].getCustTpCd() ) 
								|| "IFM".equals(inPrsProposalSummarySimulationVOs[i2].getCustTpCd() ) 
								|| "IFR".equals(inPrsProposalSummarySimulationVOs[i2].getCustTpCd() ) ){
							 strChgCd = "IFC,IFM,IFR";
						}else if ("PSC".equals(inPrsProposalSummarySimulationVOs[i2].getCustTpCd() ) 
								|| "PSS".equals(inPrsProposalSummarySimulationVOs[i2].getCustTpCd() )){
							 strChgCd = "PSC,PSS";
						}else{
							 strChgCd = "BUC,BAF,FRC,IFC,IFM,IFR,PSC,PSS";
						}
						
						inPrsProposalSummarySimulationVOs[i2].setCustTpCd(strCustTpCd);
						inPrsProposalSummarySimulationVOs[i2].setChgCd(strChgCd);
					}
					velParam.put("list_obj_"+inPrsProposalSummarySimulationSetVO.getSheetName(i), inPrsProposalSummarySimulationVOs);
				}
				
				String slaneList = inPrsProposalCmSummaryVO.getFrmSlaneCd();
				if( slaneList != null &&  slaneList.length() != 0 ){
					List<String> slaneListArr = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(slaneList,";");
					while(st.hasMoreTokens()){
						slaneListArr.add(st.nextToken());
					}
					velParam.put("slane_list", slaneListArr);
				}

				List<String> propNoListArr = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(inPrsProposalCmSummaryVO.getFrmPropNoList(),"|");
				while(st.hasMoreTokens()){
					propNoListArr.add(st.nextToken());
				}
				velParam.put("prop_no_list", propNoListArr);
				
				List<String> rfaPropNoArr = new ArrayList<String>();
				st = new StringTokenizer(inPrsProposalCmSummaryVO.getFrmRfaPropNoList(),"|");
				while(st.hasMoreTokens()){
					rfaPropNoArr.add(st.nextToken());
				}
				velParam.put("rfa_prop_no_list", rfaPropNoArr);
				
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsProposalSummarySimulationListVORSQL(), param, velParam);
				//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPrsProposalSummarySimulationListVO .class);
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return dbRowset;
		}	 
		  
		/**
		 * PRI_PRS_CM_SMRY_SIM_TMP 데이터 일괄 등록한다.<br>
		 * 
		 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] addPriPrsCmSmrySimTmp(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO)
				throws DAOException, Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if ( inPrsProposalCmSummaryVO != null ) {
					PriPrsCmSmrySimTmpVO  priPrsCmSmrySimTmpVO = null;
					List<PriPrsCmSmrySimTmpVO> priPrsCmSmrySimTmpVOs = new ArrayList<PriPrsCmSmrySimTmpVO>();
					StringTokenizer st = new StringTokenizer(inPrsProposalCmSummaryVO.getFrmPropNoList(),"|");
					while(st.hasMoreTokens()){
						priPrsCmSmrySimTmpVO = new PriPrsCmSmrySimTmpVO();
						priPrsCmSmrySimTmpVO.setPropNo( st.nextToken());
						priPrsCmSmrySimTmpVO.setPrcCtrtTpCd("S");
						priPrsCmSmrySimTmpVOs.add(priPrsCmSmrySimTmpVO);
					}
					
					st = new StringTokenizer(inPrsProposalCmSummaryVO.getFrmRfaPropNoList(),"|");
					while(st.hasMoreTokens()){
						priPrsCmSmrySimTmpVO = new PriPrsCmSmrySimTmpVO();
						priPrsCmSmrySimTmpVO.setPropNo( st.nextToken());
						priPrsCmSmrySimTmpVO.setPrcCtrtTpCd("R");
						priPrsCmSmrySimTmpVOs.add(priPrsCmSmrySimTmpVO);
					}
					 
					
					insCnt = sqlExe
							.executeBatch(
									(ISQLTemplate) new CMSummaryDBDAOPriPrsCmSmrySimTmpVOCSQL(),
									priPrsCmSmrySimTmpVOs, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return insCnt;
		}
			 
		  
		/**
		 * PRI_PRS_CM_SMRY_SIM_TMP 데이터 일괄 등록한다.<br>
		 * 
		 * @param List<RsltPrsProposalSummaryChartTargetListVO> rsltPrsProposalSummaryChartTargetList
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] addPriPrsCmSmrySimTmpTargetList(List<RsltPrsProposalSummaryChartTargetListVO> rsltPrsProposalSummaryChartTargetList)
				throws DAOException, Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if ( rsltPrsProposalSummaryChartTargetList != null ) {
					PriPrsCmSmrySimTmpVO  priPrsCmSmrySimTmpVO = null;
					List<PriPrsCmSmrySimTmpVO> priPrsCmSmrySimTmpVOs = new ArrayList<PriPrsCmSmrySimTmpVO>();
					for(int i = 0 ; i < rsltPrsProposalSummaryChartTargetList.size();i++){
						priPrsCmSmrySimTmpVO = new PriPrsCmSmrySimTmpVO();
						priPrsCmSmrySimTmpVO.setPrcCtrtNo( rsltPrsProposalSummaryChartTargetList.get(i).getTargetCode() );
						if(  "S".equals(rsltPrsProposalSummaryChartTargetList.get(i).getTargetTp()) ){
							priPrsCmSmrySimTmpVO.setPrcCtrtTpCd( "A");
						}else{
							priPrsCmSmrySimTmpVO.setPrcCtrtTpCd( "B");							
						}
						priPrsCmSmrySimTmpVOs.add(priPrsCmSmrySimTmpVO);
							 
					}
					 
					
					insCnt = sqlExe
							.executeBatch(
									(ISQLTemplate) new CMSummaryDBDAOPriPrsCmSmrySimTmpVOCSQL(),
									priPrsCmSmrySimTmpVOs, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return insCnt;
		}
		/**
		 * PRI_PRS_CM_SMRY_SIM_TMP 데이터 일괄 등록한다.<br>
		 * 
		 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] addPriPrsCmSmrySimTmpAmdt(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO)
				throws DAOException, Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if ( inPrsAmendmentCmSummaryVO != null ) {
					PriPrsCmSmrySimTmpVO  priPrsCmSmrySimTmpVO = null;
					List<PriPrsCmSmrySimTmpVO> priPrsCmSmrySimTmpVOs = new ArrayList<PriPrsCmSmrySimTmpVO>();
					StringTokenizer st = new StringTokenizer(inPrsAmendmentCmSummaryVO.getFrmPropNoList(),"|");
					while(st.hasMoreTokens()){
						priPrsCmSmrySimTmpVO = new PriPrsCmSmrySimTmpVO();
						priPrsCmSmrySimTmpVO.setPrcCtrtNo( st.nextToken());
						priPrsCmSmrySimTmpVO.setPrcCtrtTpCd("S");
						priPrsCmSmrySimTmpVOs.add(priPrsCmSmrySimTmpVO);
					}
					
					st = new StringTokenizer(inPrsAmendmentCmSummaryVO.getFrmRfaPropNoList(),"|");
					while(st.hasMoreTokens()){
						priPrsCmSmrySimTmpVO = new PriPrsCmSmrySimTmpVO();
						priPrsCmSmrySimTmpVO.setPrcCtrtNo( st.nextToken());
						priPrsCmSmrySimTmpVO.setPrcCtrtTpCd("R");
						priPrsCmSmrySimTmpVOs.add(priPrsCmSmrySimTmpVO);
					}
					 
					
					insCnt = sqlExe
							.executeBatch(
									(ISQLTemplate) new CMSummaryDBDAOPriPrsCmSmrySimTmpVOCSQL(),
									priPrsCmSmrySimTmpVOs, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return insCnt;
		}
			 
 
		/**    
		 * SIMULATION한 결과를 TEMP TABLE에서 조회한다.<br>
		 * BACKEND JOB에서 이용하기 때문에 DBRowSet을 RETURN한다.
		 * 
		 * @param inPrsAmendmentCmSummaryVO InPrsAmendmentCmSummaryVO 데이타 모델
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchAmendmentSummarySimulation1StTypeList (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
 
			 
			try{
				
				if (inPrsAmendmentCmSummaryVO != null) {
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				     
 
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation1StTypeVORSQL(), param, velParam);
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return dbRowset;
		}	 	

		 
		 
			/**    
			 * SIMULATION한 결과를 TEMP TABLE(Surchage)에서 조회한다.<br>
			 * BACKEND JOB에서 이용하기 때문에 DBRowSet을 RETURN한다.
			 * 
			 * @param inPrsAmendmentCmSummaryVO InPrsAmendmentCmSummaryVO 데이타 모델
			 * @return DBRowSet
			 * @throws DAOException
			 */
			public DBRowSet searchAmendmentSummarySimulation2NdTypeList (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws DAOException {
				DBRowSet dbRowset = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
	 
				 
				try{
					
					if (inPrsAmendmentCmSummaryVO != null) {
						Map<String, String> mapVO = inPrsAmendmentCmSummaryVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						
					}
					     
	 
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsAmendmentCmSummarySimulation2NdTypeVORSQL(), param, velParam);
				} catch (SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage(),se);
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
				}

				return dbRowset;
			}	 	

			
			
		/**
		 * Cost Detail Temp Table에 Simulation을 위한 Temp 데이터를 생성한다.
		 * 
		 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO  데이타 모델
		 * @param RsltPrsAmendmentCmSummarySimulationDateParamVO rsltPrsAmendmentCmSummarySimulationDateParamVO
		 * @return int
		 * @throws DAOException
		 */
		public int addSimulationDataForAmendmentSummary(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO ,RsltPrsAmendmentCmSummarySimulationDateParamVO rsltPrsAmendmentCmSummarySimulationDateParamVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int insCnt=0;
			 
			try{
				
				if (inPrsAmendmentCmSummaryVO != null) {
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO.getColumnValues();
					Map<String, String> mapVO2 = rsltPrsAmendmentCmSummarySimulationDateParamVO.getColumnValues();
					
					String custList = inPrsAmendmentCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					String rlaneList = inPrsAmendmentCmSummaryVO.getFrmRlaneCd();
					if( rlaneList != null &&  rlaneList.length() != 0 ){
						List<String> rlaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(rlaneList,";");
						while(st.hasMoreTokens()){
							rlaneListArr.add(st.nextToken());
						}
						velParam.put("rlane_list", rlaneListArr);
					}

					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.putAll(mapVO2);
					velParam.putAll(mapVO2);
				}
				
				
				insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CMSummaryDBDAOPriPrsCtrtSmryCostTmpVOCSQL(), param,velParam);
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return insCnt;
		}	 
		 
		 
		
		/**
		 * Cost Detail Temp Table에 Simulation을 위한 Surcharge Temp 데이터를 생성한다.
		 * 
		 * @param inPrsAmendmentCmSummaryVO InPrsAmendmentCmSummaryVO  데이타 모델
		 * @param dateVO RsltPrsAmendmentCmSummarySimulationDateParamVO
		 * @return int
		 * @throws DAOException
		 */
		public int addSimulationDataForAmendmentSummarySurcharge(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO ,RsltPrsAmendmentCmSummarySimulationDateParamVO dateVO ) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			Map<String, String> mapVO2 = dateVO.getColumnValues();
			
			
			int insCnt=0;
			 
			try{
				
				if (inPrsAmendmentCmSummaryVO != null) {
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO.getColumnValues();
					
					
					String custList = inPrsAmendmentCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					String rlaneList = inPrsAmendmentCmSummaryVO.getFrmRlaneCd();
					if( rlaneList != null &&  rlaneList.length() != 0 ){
						List<String> rlaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(rlaneList,";");
						while(st.hasMoreTokens()){
							rlaneListArr.add(st.nextToken());
						}
						velParam.put("rlane_list", rlaneListArr);
					}
					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.putAll(mapVO2);
					velParam.putAll(mapVO2);
					
				}
				
				
				insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new CMSummaryDBDAOPriPrsCtrtSmryScgTmpVOCSQL(), param,velParam);
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return insCnt;
		}	 
		 		 
		 
		 
		 
		/**
		 * Cost Detail Temp Table에 생성된 Simulation데이터에 simulation값을 update한다.
		 * 
		 * @param inPrsAmendmentCmSummaryVO InPrsAmendmentCmSummaryVO  데이타 모델
		 * @param inPrsAmendmentSummarySimulationSetVO InPrsAmendmentSummarySimulationSetVO  데이타 모델
		 * @return int
		 * @throws DAOException
		 */
		public int modifySimulationCostDetailDataForAmendmentSummary(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO , InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			String strCustTpCd;
			String strChgCd="NULL";
			InPrsAmendmentSummarySimulationVO[] inPrsAmendmentSummarySimulationVOs = null;
			int insCnt=0;
			 
			try{
				
				if (inPrsAmendmentCmSummaryVO != null) {
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				
				for(int i=0 ; i < inPrsAmendmentSummarySimulationSetVO.getSize() ; i++){
					log.debug("sheetName="+inPrsAmendmentSummarySimulationSetVO.getSheetName(i));
					log.debug("length="+inPrsAmendmentSummarySimulationSetVO.getInPrsAmendmentSummarySimulationVOs(i).length);
					
					inPrsAmendmentSummarySimulationVOs = inPrsAmendmentSummarySimulationSetVO.getInPrsAmendmentSummarySimulationVOs(i);
					for(int i2=0 ; i2 < inPrsAmendmentSummarySimulationVOs.length; i2++){
						
						if( "B".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() ) ){
							strCustTpCd = "IAO";
						}else if ("N".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() ) ){
							 strCustTpCd = "N";
						}else{
							 strCustTpCd = "IAON";
						}
						
						inPrsAmendmentSummarySimulationVOs[i2].setCustTpCd(strCustTpCd);
						inPrsAmendmentSummarySimulationVOs[i2].setChgCd(strChgCd);
						
					}
					
					velParam.put("list_obj", inPrsAmendmentSummarySimulationVOs);
					if("sheet1".equals(inPrsAmendmentSummarySimulationSetVO.getSheetName(i))){
						velParam.put("virtual_query_tp_cd","REV");
						insCnt = insCnt+ new SQLExecuter("").executeUpdate((ISQLTemplate) new CMSummaryDBDAOPriPrsCtrtSmryCostTmpVOUSQL(), param,velParam);
					} else if("sheet4".equals(inPrsAmendmentSummarySimulationSetVO.getSheetName(i))){
						velParam.put("virtual_query_tp_cd","COST");
						insCnt = insCnt+ new SQLExecuter("").executeUpdate((ISQLTemplate) new CMSummaryDBDAOPriPrsCtrtSmryCostTmpVOUSQL(), param,velParam);
					} else if("sheet5".equals(inPrsAmendmentSummarySimulationSetVO.getSheetName(i))){
						velParam.put("virtual_query_tp_cd","LOAD");
						insCnt = insCnt+ new SQLExecuter("").executeUpdate((ISQLTemplate) new CMSummaryDBDAOPriPrsCtrtSmryCostTmpVOUSQL(), param,velParam);
					}
					
				}
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return insCnt;
		}	 					 

		 
		 
		/**
		 * Cost Detail Temp Table에 생성된 Simulation데이터에 Surchage simulation값을 update한다.
		 * 
		 * @param inPrsAmendmentCmSummaryVO InPrsAmendmentCmSummaryVO  데이타 모델
		 * @param inPrsAmendmentSummarySimulationSetVO InPrsAmendmentSummarySimulationSetVO  데이타 모델
		 * @return int
		 * @throws DAOException
		 */
		public int modifySimulationCostSurchargeDataForAmendmentSummary(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO , InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			String strCustTpCd;
			String strChgCd;
			InPrsAmendmentSummarySimulationVO[] inPrsAmendmentSummarySimulationVOs = null;
			int insCnt=0;
			 
			try{
				
				if (inPrsAmendmentCmSummaryVO != null) {
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				
				
				for(int i=0 ; i < inPrsAmendmentSummarySimulationSetVO.getSize() ; i++){
					log.debug("sheetName="+inPrsAmendmentSummarySimulationSetVO.getSheetName(i));
					log.debug("length="+inPrsAmendmentSummarySimulationSetVO.getInPrsAmendmentSummarySimulationVOs(i).length);
					
					inPrsAmendmentSummarySimulationVOs = inPrsAmendmentSummarySimulationSetVO.getInPrsAmendmentSummarySimulationVOs(i);
					for(int i2=0 ; i2 < inPrsAmendmentSummarySimulationVOs.length; i2++){
						
						if( "B".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() ) ){
							strCustTpCd = "IAO";
						}else if ("N".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() ) ){
							 strCustTpCd = "N";
						}else{
							 strCustTpCd = "IAON";
						}
						 
						if( "BUC".equals(inPrsAmendmentSummarySimulationVOs[i2].getChgCd() ) 
								|| "BAF".equals(inPrsAmendmentSummarySimulationVOs[i2].getChgCd() )
								|| "FRC".equals(inPrsAmendmentSummarySimulationVOs[i2].getChgCd() )){
							 strChgCd = "BUC,BAF,FRC";
						}else if ("IFC".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() ) 
								|| "IFM".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() ) 
								|| "IFR".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() ) ){
							 strChgCd = "IFC,IFM,IFR";
						}else if ("PSC".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() ) 
								|| "PSS".equals(inPrsAmendmentSummarySimulationVOs[i2].getCustTpCd() )){
							 strChgCd = "PSC,PSS";
						}else{
							 strChgCd = "NULL";
						}				
						
						inPrsAmendmentSummarySimulationVOs[i2].setCustTpCd(strCustTpCd);
						inPrsAmendmentSummarySimulationVOs[i2].setChgCd(strChgCd);
						
					}
					
					velParam.put("list_obj", inPrsAmendmentSummarySimulationVOs);
					if("sheet2".equals(inPrsAmendmentSummarySimulationSetVO.getSheetName(i))){
						velParam.put("virtual_query_tp_cd","RATE");
						insCnt = insCnt+ new SQLExecuter("").executeUpdate((ISQLTemplate) new CMSummaryDBDAOPriPrsCtrtSmryCostSurchageTmpVOUSQL(), param,velParam);
					} else if("sheet3".equals(inPrsAmendmentSummarySimulationSetVO.getSheetName(i))){
						velParam.put("virtual_query_tp_cd","SURCHAGE");
						insCnt = insCnt+ new SQLExecuter("").executeUpdate((ISQLTemplate) new CMSummaryDBDAOPriPrsCtrtSmryCostSurchageTmpVOUSQL(), param,velParam);
					}
				}
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return insCnt;
		}	 					 
		 
		 		
		 
		/**
		 * M/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
		 * 
		 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchProposalRevenueDetailList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(inPrsProposalCmSummaryVO != null){
					Map<String, String> mapVO = inPrsProposalCmSummaryVO .getColumnValues();
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsProposalCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsProposalCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					String slaneList = inPrsProposalCmSummaryVO.getFrmSlaneCd();
					if( slaneList != null &&  slaneList.length() != 0 ){
						List<String> slaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(slaneList,";");
						while(st.hasMoreTokens()){
							slaneListArr.add(st.nextToken());
						}
						velParam.put("slane_list", slaneListArr);
					}
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					velParam.put("crg_tp_str", sbCargo.toString());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsProposalSummaryRevenueDetailVORSQL(), param, velParam);
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return dbRowset;
		}
		
		
		/**
		 * CM/OP Summary & Simulation의 Chart 정보 를 조회 합니다.<br>
		 * 
		 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
		 * @param  List<RsltPrsProposalSummaryChartTargetListVO> rsltPrsProposalSummaryChartTargetListVO
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchProposalChartList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO,List<RsltPrsProposalSummaryChartTargetListVO> rsltPrsProposalSummaryChartTargetListVO) throws DAOException {
			DBRowSet dbRowset = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(inPrsProposalCmSummaryVO != null){
					Map<String, String> mapVO = inPrsProposalCmSummaryVO .getColumnValues();
 
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsProposalCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsProposalCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					
					String slaneList = inPrsProposalCmSummaryVO.getFrmSlaneCd();
					if( slaneList != null &&  slaneList.length() != 0 ){
						List<String> slaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(slaneList,";");
						while(st.hasMoreTokens()){
							slaneListArr.add(st.nextToken());
						}
						velParam.put("slane_list", slaneListArr);
					}
					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					velParam.put("crg_tp_str", sbCargo.toString());
					if( rsltPrsProposalSummaryChartTargetListVO != null && rsltPrsProposalSummaryChartTargetListVO.size() != 0 ){
						velParam.put("code_tp_cd",rsltPrsProposalSummaryChartTargetListVO.get(0).getCodeTpCd());
					}


				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsProposalSummaryChartListRSQL(), param, velParam);
				 
			}catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return dbRowset;
		}
		
		/**
		 * CM/OP Summary & Simulation Chart List를 위한 Target List를 조회 데이타 모델에 해당되는 값을 불러온다.<br>
		 * 
		 * @param  InPrsProposalCmSummaryVO  inPrsProposalCmSummaryVO
		 * @return List<RsltPrsProposalCmSummaryVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltPrsProposalSummaryChartTargetListVO> searchProposalChartTargetList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPrsProposalSummaryChartTargetListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(inPrsProposalCmSummaryVO != null){
					Map<String, String> mapVO = inPrsProposalCmSummaryVO .getColumnValues();
				

					StringBuilder sbCargo = new StringBuilder();
					if( inPrsProposalCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					String slaneList = inPrsProposalCmSummaryVO.getFrmSlaneCd();
					if( slaneList != null &&  slaneList.length() != 0 ){
						List<String> slaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(slaneList,";");
						while(st.hasMoreTokens()){
							slaneListArr.add(st.nextToken());
						}
						velParam.put("slane_list", slaneListArr);
					}
					
					String custList = inPrsProposalCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					velParam.put("crg_tp_str", sbCargo.toString());
					 
 
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsProposalSummaryChartTargetListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPrsProposalSummaryChartTargetListVO .class);
			}catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		
		
		
		/**
		 * CM/OP Summary & Simulation Chart 데이타 모델에 해당되는 값을 불러온다.<br>
		 * 
		 * @param  InPrsAmendmentCmSummaryVO  inPrsAmendmentCmSummaryVO
		 * @param  List<RsltPrsAmendmentSummaryChartTargetListVO> rsltPrsAmendmentSummaryChartTargetListVO
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchAmendmentChartList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO,List<RsltPrsAmendmentSummaryChartTargetListVO> rsltPrsAmendmentSummaryChartTargetListVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				
				if(inPrsAmendmentCmSummaryVO != null){
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO .getColumnValues();
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsAmendmentCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					String rlaneList = inPrsAmendmentCmSummaryVO.getFrmRlaneCd();
					if( rlaneList != null &&  rlaneList.length() != 0 ){
						List<String> rlaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(rlaneList,";");
						while(st.hasMoreTokens()){
							rlaneListArr.add(st.nextToken());
						}
						velParam.put("rlane_list", rlaneListArr);
					}
					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					velParam.put("crg_tp_str", sbCargo.toString());
					List<String> targetArr = new ArrayList<String>();
					if( rsltPrsAmendmentSummaryChartTargetListVO != null && rsltPrsAmendmentSummaryChartTargetListVO.size() != 0){
						velParam.put("code_tp_cd",rsltPrsAmendmentSummaryChartTargetListVO.get(0).getCodeTpCd());						
						for(int i = 0 ; i < rsltPrsAmendmentSummaryChartTargetListVO.size();i++){
							targetArr.add(rsltPrsAmendmentSummaryChartTargetListVO.get(i).getTargetCode());
						}
					}else{
						velParam.put("code_tp_cd", null);
						targetArr.add("");
						
					}
					
					velParam.put("target_list", targetArr);
				}
				 
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsAmendmentSummaryChartListRSQL(), param, velParam);
				 
			}catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return dbRowset;
		}
		
		/**
		 * CM/OP Summary & Simulation Chart List를 위한 Target List를 조회 데이타 모델에 해당되는 값을 불러온다.<br>
		 * 
		 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO 
		 * @return List<RsltPrsAmendmentCmSummaryVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltPrsAmendmentSummaryChartTargetListVO> searchAmendmentChartTargetList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPrsAmendmentSummaryChartTargetListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(inPrsAmendmentCmSummaryVO != null){
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO .getColumnValues();
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsAmendmentCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					
					String rlaneList = inPrsAmendmentCmSummaryVO.getFrmRlaneCd();
					if( rlaneList != null &&  rlaneList.length() != 0 ){
						List<String> rlaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(rlaneList,";");
						while(st.hasMoreTokens()){
							rlaneListArr.add(st.nextToken());
						}
						velParam.put("rlane_list", rlaneListArr);
					}
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					velParam.put("crg_tp_str", sbCargo.toString());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsAmendmentSummaryChartTargetListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPrsAmendmentSummaryChartTargetListVO .class);
			}catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		
		
		
		
		/**
		 * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
		 * 
		 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO 
		 * @param RsltPrsAmendmentCmSummarySimulationDateParamVO dateVO
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchAmendmentRevenueDetailList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO,RsltPrsAmendmentCmSummarySimulationDateParamVO dateVO) throws DAOException {
			DBRowSet dbRowset = null;
	
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			Map<String, String> mapVO2 = dateVO.getColumnValues();

			try{
				if(inPrsAmendmentCmSummaryVO != null){
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO .getColumnValues();
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsAmendmentCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsAmendmentCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsAmendmentCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					String rlaneList = inPrsAmendmentCmSummaryVO.getFrmRlaneCd();
					if( rlaneList != null &&  rlaneList.length() != 0 ){
						List<String> rlaneListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(rlaneList,";");
						while(st.hasMoreTokens()){
							rlaneListArr.add(st.nextToken());
						}
						velParam.put("rlane_list", rlaneListArr);
					}
					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.putAll(mapVO2);
					velParam.putAll(mapVO2);
					
					velParam.put("crg_tp_str", sbCargo.toString());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsAmendmentSummaryRevenueDetailVORSQL(), param, velParam);
				 
			}catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return dbRowset;
		}
		

		/**
		 * 로그인 사용자의 SELECT 권한 정보와 REQUEST OFFICE를 조회합니다.<br>
		 * 
		 * @param String userId  
		 * @return List<RsltPrsProposalSummaryRevenueDetailVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltPriAuthorizationVO> searchPriAuthorization(String userId) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPriAuthorizationVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	 
			try{
 
				param.put("usr_id", userId);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPriAuthorizationVORSQL(), param,null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriAuthorizationVO .class);
			}catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
				 

		/**
		 * MDM Sales Rep 정보를 조회합니다.<br>
		 * 
		 * @param String srepCd  
		 * @return List<RsltPriMdmSlsRepVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltPriMdmSlsRepVO> searchMdmSlsRep(String srepCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPriMdmSlsRepVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	 
			try{
 
				param.put("srep_cd", srepCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPriMdmSlsRepRSQL(), param,null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriMdmSlsRepVO .class);
			}catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		
		
		

		/**
		 * CM/OP Summary & Simulation 의 Quotation, Proposal, Amendment의 CM값 History 를 조회 합니다..<br>
		 * 
		 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
		 * @return List<RsltPrsCmSummaryHistoryVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltPrsCmSummaryHistoryVO> searchCmSummaryHistoryList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPrsCmSummaryHistoryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(inPrsProposalCmSummaryVO != null){
					Map<String, String> mapVO = inPrsProposalCmSummaryVO .getColumnValues();
					StringBuilder sbCargo = new StringBuilder();
					if( inPrsProposalCmSummaryVO.getFrmCrgTpAk() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpAk().length() != 0){
						sbCargo.append("'AK'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpBb() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpBb().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'BB'");
					}
					
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDg() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDg().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DG'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpDry() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpDry().length() != 0){
						if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'DR'");
					}
					if( inPrsProposalCmSummaryVO.getFrmCrgTpRf() != null 
							&& inPrsProposalCmSummaryVO.getFrmCrgTpRf().length() != 0){
					    if( sbCargo.length() != 0){
							sbCargo.append(",");
						}
						sbCargo.append("'RF'");
					}	
					
					String custList = inPrsProposalCmSummaryVO.getFrmCustList();
					if( custList != null &&  custList.length() != 0 ){
						List<String> custListArr = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(custList,";");
						while(st.hasMoreTokens()){
							custListArr.add(st.nextToken());
						}
						velParam.put("cust_list", custListArr);
					}
					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					velParam.put("crg_tp_str", sbCargo.toString());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsCmSummaryHistoryVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPrsCmSummaryHistoryVO .class);
			}catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}	 		
		 
		 
		/**
		 * CM/OP Summary & Simulation Multi Customer에서 하나의 customer 선택시 그 group에 포함된 데이터 를 조회 합니다.<br>
		 * 
		 * @param InPrsAmendmentCmSummaryVO  inPrsAmendmentCmSummaryVO
		 * @return List<RsltPrsAmendmentCmSummarySimulationDateParamVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltPrsAmendmentCmSummarySimulationDateParamVO> searchSimulationParamDate(InPrsAmendmentCmSummaryVO  inPrsAmendmentCmSummaryVO ) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPrsAmendmentCmSummarySimulationDateParamVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				
 
				if(inPrsAmendmentCmSummaryVO != null){
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsAmendmentCmSummarySimulationDateParamVORSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPrsAmendmentCmSummarySimulationDateParamVO .class);
 
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return list;
		}
		

		 
		/**
		 * sheet의 route값이 변경 됐을때 정확한 값인지 체크 한다 <br>
		 * 
		 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
		 * @return List<RsltPrsCheckRegionCodeVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
        public List<RsltPrsCheckRegionCodeVO> searchSummaryResionCode(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPrsCheckRegionCodeVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(inPrsAmendmentCmSummaryVO != null){
					Map<String, String> mapVO = inPrsAmendmentCmSummaryVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					 
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CMSummaryDBDAORsltPrsCheckRegionCodeVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPrsCheckRegionCodeVO .class);
 
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}

			return list;
		}
		
		 		
				 
}