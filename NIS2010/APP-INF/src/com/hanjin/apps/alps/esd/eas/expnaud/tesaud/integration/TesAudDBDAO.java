/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TesAudDBDAO.java
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
*  
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.CostCodeListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCoincidenceVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCostCalculationVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailCostCalculationVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesRowDataVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * TesAudDBDAO  PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class TesAudDBDAO extends DBDAOSupport {
	 /**
	  * MR invoice Report
	  * 
	  * @param TesRowDataVO tesRowDataVO
	  * @return List<TesRowDataVO>
	  * @exception DAOException
	  */ 
	 @SuppressWarnings("unchecked")
	 public List<TesRowDataVO> searchTesRowDataList(TesRowDataVO tesRowDataVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TesRowDataVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(tesRowDataVO != null){
//				 Map<String, String> mapVO = tesRowDataVO .getColumnValues();
//				 param.putAll(mapVO);
				 
					List<String> lgsCostDtlCd = new ArrayList();
					lgsCostDtlCd = this.seperationParameter(tesRowDataVO.getLgsCostDtlCd(), ","); 
					
					param.put("inv_date_type", 		tesRowDataVO.getInvDateType());
					param.put("fm_prd_dt", 			tesRowDataVO.getFmPrdDt());
					param.put("to_prd_dt", 			tesRowDataVO.getToPrdDt());
					param.put("yd_cd", 				tesRowDataVO.getYdCd());
					param.put("vndr_seq", 			tesRowDataVO.getVndrSeq());
					param.put("manual_check", 		tesRowDataVO.getManualCheck()     );
					param.put("vvd", 				tesRowDataVO.getVvd()   );
					param.put("cost_ofc_cd", 		tesRowDataVO.getCostOfcCd()  );
					param.put("inv_ofc_cd", 		tesRowDataVO.getInvOfcCd() );
					param.put("tml_inv_sts_cd", 	tesRowDataVO.getTmlInvStsCd()  );
					param.put("lgs_cost_subj_cd", 	tesRowDataVO.getLgsCostSubjCd()   );
					param.put("page_no", 			tesRowDataVO.getPageNo());
					param.put("pagerows", 			tesRowDataVO.getPagerows());
					param.put("lgs_cost_dtl_cd", 	lgsCostDtlCd  );
					
				 dbRowset = new SQLExecuter("DEFAULT").executeQuery(new TesAudDBDAOsearchTesRowDataListRSQL(), param, param);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesRowDataVO.class);
				if (list != null && list.size() > 0) {
					TesRowDataVO vo = list.get(0);
					vo.setMaxRows(Integer.parseInt(vo.getRowCount()));
				}
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	
	 
	 
		/**
		 * 여러개의 parameter를 나누어주는 메소드
		 * Detail Inquity Popup<br>
		 * 
		 * @param String sparameter
		 * @param String sSeperate
		 * @return ArrayList<String>
		 * @throws 
		 */
		public ArrayList seperationParameter(String sparameter, String sSeperate) {
			ArrayList arrlist = null;
			StringTokenizer st  = null;
			int j = 0;
			if( !sparameter.equals("") ) {
				arrlist = new ArrayList();
				st = new StringTokenizer(sparameter, sSeperate);
				while( st.hasMoreTokens() ) {
					arrlist.add(j++, st.nextToken());
				}
			}
			return arrlist;
		}
	 
	 /**
	  * On Dock Rail Data Inquiry - Coincidence
	  * 
	  * @param TesOnDockRailVO tesOnDockRailVO
	  * @return List<TesOnDockRailVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<TesOnDockRailVO> searchOnDockRailDataList(TesOnDockRailVO tesOnDockRailVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TesOnDockRailVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(tesOnDockRailVO != null){
				 Map<String, String> mapVO = tesOnDockRailVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TesAudDBDAOsearchOnDockRailDataListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesOnDockRailVO.class);
				if (list != null && list.size() > 0) {
					TesOnDockRailVO vo = list.get(0);
					vo.setMaxRows(Integer.parseInt(vo.getRowCount()));
				}
				
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	
	 
	 /**
	  * On Dock Rail Data Inquiry - Cost Calculation
	  * 
	  * @param TesOnDockRailCostCalculationVO tesOnDockRailCostCalculationVO
	  * @return List<TesOnDockRailCostCalculationVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<TesOnDockRailCostCalculationVO> searchOnDockRailCostCalculationList(TesOnDockRailCostCalculationVO tesOnDockRailCostCalculationVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TesOnDockRailCostCalculationVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(tesOnDockRailCostCalculationVO != null){
				 Map<String, String> mapVO = tesOnDockRailCostCalculationVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TesAudDBDAOsearchOnDockRailCostCalculationListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesOnDockRailCostCalculationVO.class);
				if (list != null && list.size() > 0) {
					TesOnDockRailCostCalculationVO vo = list.get(0);
					vo.setMaxRows(Integer.parseInt(vo.getRowCount()));
				}
				
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return list;
	 }	
	 
	 /**
	  * Storage Data inquiry -Cost Calculated
	  * 
	  * @param StorageCostCalculationVO storageCostCalculationVO
	  * @return List<StorageCostCalculationVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<StorageCostCalculationVO> searchStorageCostCalculationList(StorageCostCalculationVO storageCostCalculationVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<StorageCostCalculationVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(storageCostCalculationVO != null){
				 Map<String, String> mapVO = storageCostCalculationVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TesAudDBDAOsearchStorageCostCalculationListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, StorageCostCalculationVO.class);
				if (list != null && list.size() > 0) {
					StorageCostCalculationVO vo = list.get(0);
					vo.setMaxRows(Integer.parseInt(vo.getRowCount()));
				}
				
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return list;
	 }	
	 
	 /**
	  *  CostCodeList search
	  * 
	  * @param CostCodeListVO costCodeListVO
	  * @return List<CostCodeListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CostCodeListVO> searchCostCodeList(CostCodeListVO costCodeListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CostCodeListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{

			 if(costCodeListVO != null){
				 Map<String, String> mapVO = costCodeListVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TesAudDBDAOsearchCostCodeListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CostCodeListVO.class);
				
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return list;
	 }	
	 
	 /**
	  * Storage Calculation - Coincidence
	  * 
	  * @param StorageCoincidenceVO storageCoincidenceVO
	  * @return List<StorageCoincidenceVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<StorageCoincidenceVO> searchStorageCoincidenceList(StorageCoincidenceVO storageCoincidenceVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<StorageCoincidenceVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(storageCoincidenceVO != null){
				 Map<String, String> mapVO = storageCoincidenceVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TesAudDBDAOsearchStorageCoincidenceListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, StorageCoincidenceVO.class);
				if (list != null && list.size() > 0) {
					StorageCoincidenceVO vo = list.get(0);
					vo.setMaxRows(Integer.parseInt(vo.getRowCount()));
				}
				
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return list;
	 }	
}
