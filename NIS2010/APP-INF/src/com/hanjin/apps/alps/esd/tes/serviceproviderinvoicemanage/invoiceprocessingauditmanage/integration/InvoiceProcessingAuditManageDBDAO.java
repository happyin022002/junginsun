/***************************************************************************************
 * =========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : InvoiceProcessingAuditManageDBDAO.java
 * @FileTitle : Invoice Processing Audit Inquiry View
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2014-06-19
 * @LastModifier : yOng hO lEE
 * @LastVersion : 1.0
 * 2014-06-19 yOng hO lEE
 * 1.0 최초 생성
 * =========================================================
 ***************************************************************************************/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.basic.InvoiceProcessingAuditManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.event.EsdTes0015Event;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see InvoiceProcessingAuditManageBCImpl 참조
 * @since J2EE 1.6 
 */
public class InvoiceProcessingAuditManageDBDAO extends DBDAOSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @param vrfyResult
	 * @param iPage
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditTerminalInvoiceContainerList(EsdTes0015Event event, String vrfyResult, int iPage) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditTerminalInvoiceContainerList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		ArrayList<String> tempArrL = new ArrayList<String>();

		// 페이징 처리
		int currentPage	= iPage;
		int startPart		= Constants.PAGE_SIZE_10000 * (currentPage - 1) + 1;
		int endPart		= Constants.PAGE_SIZE_10000 * currentPage;  

		try {
			if (event != null) {
			
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				
				param.put("vrfy_rslt_ind_cd", vrfyResult);
				velParam.put("vrfyResult", vrfyResult);
				
				velParam.put("ipage", currentPage);
		        param.put("startpart", startPart);
		        param.put("endpart", endPart);
		        
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}
		        
		        
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditTerminalInvoiceContainerListCntRSQL(), param, velParam);

			int total = 0;
	        if (dbRowset.next()) {
				total = dbRowset.getInt(1);
			}

	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditTerminalInvoiceContainerListRSQL(), param, velParam);

			dbRowset.setMaxRows(total);
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	
	/**
	 * MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditTerminalInvoiceCalculationList(EsdTes0015Event event) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditTerminalInvoiceCalculationList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		ArrayList<String> tempArrL = new ArrayList<String>();

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditTerminalInvoiceCalculationListRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	

	/**
	 * On-dock Rail Charge InvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @param vrfyResult
	 * @param iPage
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditOndockRailChargeContainerList(EsdTes0015Event event, String vrfyResult, int iPage) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditOndockRailChargeContainerList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList<String> tempArrL = new ArrayList<String>();

		// 페이징 처리
		int currentPage	= iPage;
		int startPart		= Constants.PAGE_SIZE_10000 * (currentPage - 1) + 1;
		int endPart		= Constants.PAGE_SIZE_10000 * currentPage;  

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				

				param.put("vrfy_rslt_ind_cd", vrfyResult);
				velParam.put("vrfyResult", vrfyResult);

				velParam.put("ipage", currentPage);
		        param.put("startpart", startPart);
		        param.put("endpart", endPart);
		        
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditOndockRailChargeContainerListCntRSQL(), param, velParam);

			int total = 0;
	        if (dbRowset.next()) {
				total = dbRowset.getInt(1);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditOndockRailChargeContainerListRSQL(), param, velParam);
			
			dbRowset.setMaxRows(total);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}

	/**
	 * On-dock Rail Charge InvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditOndockCostCalculationList(EsdTes0015Event event) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditOndockCostCalculationList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList<String> tempArrL = new ArrayList<String>();

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditOndockCostCalculationListRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	
	
	/**
	 * Off-dock CY InvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @param vrfyResult
	 * @param iPage
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditOffdockCYContainerList(EsdTes0015Event event, String vrfyResult, int iPage) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditOffdockCYContainerList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList<String> tempArrL = new ArrayList<String>();

		// 페이징 처리
		int currentPage	= iPage;
		int startPart		= Constants.PAGE_SIZE_10000 * (currentPage - 1) + 1;
		int endPart		= Constants.PAGE_SIZE_10000 * currentPage;  

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}

				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("vrfy_rslt_ind_cd", vrfyResult);
				velParam.put("vrfyResult", vrfyResult);
				
				velParam.put("ipage", currentPage);
		        param.put("startpart", startPart);
		        param.put("endpart", endPart);
		        
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditOffdockCYContainerListCntRSQL(), param, velParam);

			int total = 0;
	        if (dbRowset.next()) {
				total = dbRowset.getInt(1);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditOffdockCYContainerListRSQL(), param, velParam);
			
			dbRowset.setMaxRows(total);			
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	
	/**
	 * Off-dock CY InvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditOffdockCYCalcCostTMNLList(EsdTes0015Event event) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditOffdockCYCalcCostTMNLList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList<String> tempArrL = new ArrayList<String>();

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}
			}
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditOffdockCYCalcCostTMNLListRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	
	
	/**
	 * Off-dock CY InvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditOffdockCYCalcCostByDayList(EsdTes0015Event event) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditOffdockCYCalcCostByDayList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList<String> tempArrL = new ArrayList<String>();

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}
			}
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditOffdockCYCalcCostByDayListRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	
	
	/**
	 * Off-dock CY InvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditOffdockCYCalcCostByPoolList(EsdTes0015Event event) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditOffdockCYCalcCostByPoolList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList<String> tempArrL = new ArrayList<String>();

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}

			}
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditOffdockCYCalcCostByPoolListRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	
	
	/**
	 * Marine Terminal Strorage InvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @param vrfyResult
	 * @param iPage
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditStorageContainerList(EsdTes0015Event event, String vrfyResult, int iPage) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditStorageContainerList Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList<String> tempArrL = new ArrayList<String>();

		// 페이징 처리
		int currentPage	= iPage;
		int startPart		= Constants.PAGE_SIZE_10000 * (currentPage - 1) + 1;
		int endPart		= Constants.PAGE_SIZE_10000 * currentPage;  

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				

				param.put("vrfy_rslt_ind_cd", vrfyResult);
				velParam.put("vrfyResult", vrfyResult);

				velParam.put("ipage", currentPage);
		        param.put("startpart", startPart);
		        param.put("endpart", endPart);
		        
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditStorageContainerListCntRSQL(), param, velParam);

			int total = 0;
	        if (dbRowset.next()) {
				total = dbRowset.getInt(1);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditStorageContainerListRSQL(), param, velParam);
			
			dbRowset.setMaxRows(total);
			
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	
	/**
	 * Marine Terminal Strorage InvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @param calcCostGrpCd
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuditStorageInvoiceCalculationList(EsdTes0015Event event, String calcCostGrpCd) throws DAOException {
		log.debug("\n=============== InvoiceProcessingAuditManageDBDAO  searchAuditStorageInvoiceCalculationList  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList<String> tempArrL = new ArrayList<String>();

		try {
			if (event != null) {
				
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("calc_cost_grp_cd", calcCostGrpCd);
				velParam.put("calcCostGrpCd", calcCostGrpCd);

				// COST TYPE
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCostCode().length() / 2; j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j * 2, (j + 1) * 2));
				}

				if (tempArrL.size() > 0) { 
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}

				// cntr_sty_cd (full/empty) 넣는 부분
				tempArrL = new ArrayList<String>();
				for (int j = 0; j < event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++) {
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j + 1)));					
				}
				if (tempArrL.size() > 0) {
					velParam.put("cntr_sty_cd", tempArrL);						
				}
				
		        //cost  sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd1() != null && event.getTesCommonVo().getSubOfcCd1() != "" ){
					String subOfcCd1 = event.getTesCommonVo().getSubOfcCd1();
					List<String> subOfcList1 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd1, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList1.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd1", subOfcList1);
				}	
				
				//inv sub office list 포함
				if( event.getTesCommonVo().getSubOfcCd2() != null && event.getTesCommonVo().getSubOfcCd2() != "" ){
					String subOfcCd2 = event.getTesCommonVo().getSubOfcCd2();
					List<String> subOfcList2 = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(subOfcCd2, ",");
				
					while (st.hasMoreTokens()) {
						subOfcList2.add(st.nextToken().trim());
				    }
				    velParam.put("sub_ofc_cd2", subOfcList2);
				}

			}
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceProcessingAuditManageDBDAOSearchAuditStorageInvoiceCalculationListRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}
	
}