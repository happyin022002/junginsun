/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryDBDAO.java
*@FileTitle : DOD Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-11
*@LastModifier : Hong Seong Pil
*@LastVersion : 1.0
* 2016-05-11 Hong Seong Pil
* 1.0 최초 생성
*  
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerDetailVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.OfficeByRHQVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.OfficeSubVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcDetailVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * CollectionSummaryDBDAO <br>
 * @author Hong Seong Pil
 * @see EventSupport
 * @since J2EE 1.4
 */
public class CollectionSummaryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * EES_DOD_0016 DOD Collection Summary
	 * DOD Collection Summary by Customer 조회
	 * 
	 * @param CollectionSummaryByCustomerVO
	 * @return List<CollectionSummaryByCustomerVO>
	 * @throws DAOException
	 */
	public List<CollectionSummaryByCustomerVO> searchCollectionSummaryByCustomer(CollectionSummaryByCustomerVO collectionSummaryINVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CollectionSummaryByCustomerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = collectionSummaryINVO.getColumnValues();
			
			String scRfaCd = collectionSummaryINVO.getScRfaNo();
			String ofcCd = collectionSummaryINVO.getOffice();
			
			List<String> scRfaCdList = new ArrayList();
			List<String> ofcCdList = new ArrayList();
			
			if(scRfaCd != null && !scRfaCd.equals("")){
				StringTokenizer st = new StringTokenizer(scRfaCd, ",");
				while (st.hasMoreTokens()) {
					scRfaCdList.add(st.nextToken());
				}
				velParam.put("sc_rfa_cd_list", scRfaCdList);
			}
			
			if(ofcCd != null && !ofcCd.equals("")){
				StringTokenizer st2 = new StringTokenizer(ofcCd, ",");
				while (st2.hasMoreTokens()) {
					ofcCdList.add(st2.nextToken());
				}
				velParam.put("ofc_cd_list", ofcCdList);
			}
			
				
			if(collectionSummaryINVO.getCustType().length() > 0) {
				String custType = collectionSummaryINVO.getCustType();
				StringTokenizer st4 = new StringTokenizer(custType, ",");
				String cust = "";
			    while (st4.hasMoreTokens()) {
			    	cust = st4.nextToken();
			    	velParam.put("cust_type_"+cust, cust);
			    	param.put("cust_type_"+cust, cust);
			    }
			}
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CollectionSummaryDBDAOsearchCollectionSummaryByCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CollectionSummaryByCustomerVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * EES_DOD_0017 DOD Collection Summary
	 * DOD Collection Summary by Customer Detail 조회
	 * 
	 * @param CollectionSummaryByCustomerDetailVO
	 * @return List<CollectionSummaryByCustomerDetailVO>
	 * @throws DAOException
	 */
	public List<CollectionSummaryByCustomerDetailVO> searchCollectionSummaryDetailByCustomer(CollectionSummaryByCustomerDetailVO collectionSummaryByCustomerDetailVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CollectionSummaryByCustomerDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			String itemListTemp = collectionSummaryByCustomerDetailVO.getItemList();
			Map<String, String> mapVO = collectionSummaryByCustomerDetailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            List<String> itemList = new ArrayList<String>();
            StringTokenizer st = new StringTokenizer(itemListTemp, ",");
            while (st.hasMoreTokens()) {
                itemList.add("('" + st.nextToken() + "')");
            }
            velParam.put("item_list", itemList);
            
            if(collectionSummaryByCustomerDetailVO.getCustType().length() > 0) {
				String custType = collectionSummaryByCustomerDetailVO.getCustType();
				StringTokenizer st4 = new StringTokenizer(custType, ",");
				String cust = "";
			    while (st4.hasMoreTokens()) {
			    	cust = st4.nextToken();
			    	velParam.put("cust_type_"+cust, cust);
			    	param.put("cust_type_"+cust, cust);
			    }
			}
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CollectionSummaryDBDAOsearchCollectionSummaryByCustomerDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CollectionSummaryByCustomerDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * EES_DOD_0009 DOD Collection Summary by Office
	 * DOD Collection Summary 조회
	 * 
	 * @param SumbyOfcVO sumbyOfcVO 
	 * @return List<SumbyOfcVO>
	 * @throws DAOException
	 */
	public List<SumbyOfcVO> searchSumbyOfc(SumbyOfcVO sumbyOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SumbyOfcVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = sumbyOfcVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			
			// DEM/DET Office가 'Office'일 경우, 다중건 선택되어서 온다.
			if(sumbyOfcVO.getOfcFlg().equals("O")) {
				String ofcCd = sumbyOfcVO.getOfcCd();
				List<String> ofcCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(ofcCd, ",");
			    while (st.hasMoreTokens()) {
			    	ofcCdList.add(st.nextToken());
			    }
				velParam.put("ofc_cd_list", ofcCdList);
				

			}
			
			// CNTR Type Velocity 파라미터 구성 
			String cntrTp = sumbyOfcVO.getDodCntrTpCd();
			
			List<String> cntrTpList = new ArrayList<String>();
			StringTokenizer st3 = new StringTokenizer(cntrTp, ",");
		    while (st3.hasMoreTokens()) {
		    	cntrTpList.add(st3.nextToken());
		    }
			velParam.put("cntr_tp_list", cntrTpList);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CollectionSummaryDBDAOsearchSumbyOfcRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SumbyOfcVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * EES_DOD_0010 DOD Collection Summary Detail
	 * DOD Collection Summary Detail 조회
	 * 
	 * @param SumbyOfcDetailVO
	 * @return List<SumbyOfcDetailVO>
	 * @throws DAOException
	 */
	public List<SumbyOfcDetailVO> searchSumbyOfcDetail(SumbyOfcDetailVO sumbyOfcDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SumbyOfcDetailVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = sumbyOfcDetailVO.getColumnValues();
			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);

			
			//param.put( "session_ofc_cd" , sumbyOfcDetailVO.getItemList() );
              
              //  Concat된 4개의 조건을 받아서 괄호안에 넣는 부분
              String itemListTemp = sumbyOfcDetailVO.getItemList();
              
              String ar_if = sumbyOfcDetailVO.getArIf();
              String cust_cd = sumbyOfcDetailVO.getCustCd();
              
              String temp_from = sumbyOfcDetailVO.getSFrom();
              String temp_to = sumbyOfcDetailVO.getSTo();
              
              String s_from = temp_from.replace("-", "");
              String s_to = temp_to.replace("-", "");
              
              String period = sumbyOfcDetailVO.getPeriod();
              
              //String curr_cd = sumbyOfcDetailVO.getCurrCd();
                           
              List<String> itemList = new ArrayList<String>();
              StringTokenizer st = new StringTokenizer(itemListTemp, ",");
              while (st.hasMoreTokens()) {
                  itemList.add("('" + st.nextToken() + "')");
              }

              velParam.put("item_list", itemList);
              velParam.put("ar_if", ar_if);
              velParam.put("cust_cd", cust_cd);
              velParam.put("period", period);
              //velParam.put("curr_cd", curr_cd);
              
              param.put("s_from", s_from);
              param.put("s_to", s_to);	
              param.put("cust_cd", cust_cd);
              //param.put("curr_cd", curr_cd); 

              log.debug("velParam" + velParam);
              
              log.debug("param" + param);
              
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CollectionSummaryDBDAOsearchSumbyOfcDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SumbyOfcDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * RHQ OFFICE 정보를 조회한다.<br>
	 * 
	 * @param 
	 * @return List<String>
	 * @throws DAOException
	 */
	
	public List<String> searchRHQOfcList() throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CollectionSummaryDBDAOsearchRHQOfcRSQL(), param,
					velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeByRHQVO.class);
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
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
	
	/**
	 * OFFICE 정보를 조회한다.<br>
	 * 
	 * @param 
	 * @return List<String>
	 * @throws DAOException 
	 */
	public List<String> searchOfcList() throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CollectionSummaryDBDAOsearchOfcRSQL(), param,
					velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeByRHQVO.class);
			log.error(dbRowset);
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
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
	
	/**
	 * SUB OFFICE 정보를 조회한다.<br>
	 * 
	 * @param OfficeSubVO officeSubVO
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchSubOfcList(OfficeSubVO officeSubVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<String> list = null;
		// query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(officeSubVO != null){
				String ofcCd = officeSubVO.getOfcCd();
					
				List<String> ofcCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(ofcCd, ",");
				
			    while (st.hasMoreTokens()) {
			    	ofcCdList.add(st.nextToken());
			    }
			    
				velParam.put("prnt_ofc_cd", ofcCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CollectionSummaryDBDAOsearchSubOfcRSQL(), null, velParam);
			
			list = new ArrayList<String>();
			
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
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

}
