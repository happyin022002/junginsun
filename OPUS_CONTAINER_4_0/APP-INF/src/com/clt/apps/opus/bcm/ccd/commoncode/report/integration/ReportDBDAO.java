/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : seviceDBDAO.java
*@FileTitle : activity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.report.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.CustomerReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.LocationReportConditionVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.LocationReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.OfficeReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.SearchOfficHierarchyVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.VendorReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.VesselReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.ChargeReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.YardReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.ZoneReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.service.basic.ServiceBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS seviceDBDAO <br>
 * - OPUS-commoncode system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see ServiceBCImpl 참조
 * @since J2EE 1.6
 */
public class ReportDBDAO extends DBDAOSupport {

	
	/**
	 * Zone code report Count 조회 합니다.<br>
	 * 
	 * @param String znCd
	 * @param String znNm
	 * @param String locCd
	 * @param String repYdCd
	 * @param String status
	 * @return String
	 * @throws DAOException
	 */
	public String searchZoneReportCount(String znCd,String znNm,String locCd,String repYdCd,String status) throws DAOException {
		 DBRowSet dbRowset = null;
		 String cnt = null;
//			List<ZoneReportVO> list = new ArrayList<ZoneReportVO>();
			Map<String, Object> param = new HashMap<String, Object>();
			//query parameter
			param.put("zn_cd", znCd);
			param.put("zn_nm", znNm);
			param.put("loc_cd", locCd);
			param.put("rep_yd_cd", repYdCd);
			param.put("status", status);

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOZoneReportCountRSQL(), param, param);
			
			if(dbRowset.next()){
				cnt = dbRowset.getString("CNT");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
	 * Zone code report 상세 정보 조회합니다.<br>
	 * 
	 * @param String znCd
	 * @param String znNm
	 * @param String locCd
	 * @param String repYdCd
	 * @param String status
	 * @return List<ZoneReportVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ZoneReportVO> searchZoneReportCode(String znCd,String znNm,String locCd,String repYdCd,String status) throws DAOException {
		DBRowSet dbRowset = null;
		List<ZoneReportVO> list = new ArrayList<ZoneReportVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		param.put("zn_cd", znCd);
		param.put("zn_nm", znNm);
		param.put("loc_cd", locCd);
		param.put("rep_yd_cd", repYdCd);
		param.put("status", status);

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOZoneReportVORSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ZoneReportVO .class);
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
		 * Yard code report 상세 정보 조회합니다.<br>
		 * 
		 * @param String ydCd
		 * @param String ydNm
		 * @param String locCd
		 * @param String ofcCd
		 * @param String dmdtOfcCd
		 * @param String status
		 * @return List<YardReportVO>
		 * @exception EventException
		 */
		 @SuppressWarnings("unchecked")
		public List<YardReportVO> searchYardReportCode(String ydCd,String ydNm,String locCd,String ofcCd,String dmdtOfcCd,String status) throws DAOException {
			DBRowSet dbRowset = null;
			List<YardReportVO> list = new ArrayList<YardReportVO>();
			Map<String, Object> param = new HashMap<String, Object>();
			//query parameter
			param.put("yd_cd", ydCd);
			param.put("yd_nm", ydNm);
			param.put("loc_cd", locCd);
			param.put("ofc_cd", ofcCd);
			param.put("dmdtOfcCd", dmdtOfcCd);
			param.put("status", status);

			try{

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOYardReportRSQL(), param, param);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardReportVO .class);
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
		 * Yard code report Count 정보 조회합니다.<br>
		 * 
		 * @param String ydCd
		 * @param String ydNm
		 * @param String locCd
		 * @param String ofcCd
		 * @param String dmdtOfcCd
		 * @param String status
		 * @return String
		 * @exception EventException
		 */
		public String searchYardReportCount(String ydCd,String ydNm,String locCd,String ofcCd,String dmdtOfcCd,String status) throws DAOException {
			DBRowSet dbRowset = null;
			String cnt = null;
			Map<String, Object> param = new HashMap<String, Object>();
			//query parameter
			param.put("yd_cd", ydCd);
			param.put("yd_nm", ydNm);
			param.put("loc_cd", locCd);
			param.put("ofc_cd", ofcCd);
			param.put("dmdtOfcCd", dmdtOfcCd);
			param.put("status", status);

			try{

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOYardReportCountRSQL(), param, param);
				
				if(dbRowset.next()){
					cnt = dbRowset.getString("CNT");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return cnt;

		}
			 
		/**
		 * Location Report을 Count 조회 합니다.<br>
		 * 
		 * @param LocationReportConditionVO locationReportConditionVO
		 * @return String
		 * @throws DAOException
		 */
		public String searchLocationReportCount(LocationReportConditionVO locationReportConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			String cnt = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(locationReportConditionVO != null){
					Map<String, String> mapVO = locationReportConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOLocationReportCountRSQL(), param, velParam);
				
				if(dbRowset.next()){
					cnt = dbRowset.getString("CNT");
				}

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return cnt;
		}

			 
		/**
		 * Location Report을 조회 합니다.<br>
		 * 
		 * @param LocationReportConditionVO locationReportConditionVO
		 * @return List<LocationReportVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<LocationReportVO> searchLocationReportList(LocationReportConditionVO locationReportConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<LocationReportVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(locationReportConditionVO != null){
					Map<String, String> mapVO = locationReportConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOLocationReportVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationReportVO .class);
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
			 * Customer Report을 Count 조회 합니다.<br>
			 * 
			 * @param CustomerReportVO customerReportVO
			 * @return String
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public String searchCustomerReportCnt(CustomerReportVO customerReportVO) throws DAOException {
				DBRowSet dbRowset = null;
				String cnt = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(customerReportVO != null){
						Map<String, String> mapVO = customerReportVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchCustomerReportCntRSQL(), param, velParam);
					
					if(dbRowset.next()){
						cnt = dbRowset.getString("ROW_CNT");
					}

				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return cnt;
			}

	 /**
		 * Customer Report을 조회 합니다.<br>
		 * 
		 * @param CustomerReportVO customerReportVO
		 * @return List<CustomerReportVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<CustomerReportVO> searchCustomerReportList(CustomerReportVO customerReportVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustomerReportVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(customerReportVO != null){
					Map<String, String> mapVO = customerReportVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchCustomerReportRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerReportVO .class);
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
			 * Vendor Report을 Count 조회 합니다.<br>
			 * 
			 * @param VendorReportVO vendorReportVO
			 * @return String
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public String searchVendorReportCnt(VendorReportVO vendorReportVO) throws DAOException {
				DBRowSet dbRowset = null;
				String cnt = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(vendorReportVO != null){
						Map<String, String> mapVO = vendorReportVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchVendorReportCntRSQL(), param, velParam);
					
					if(dbRowset.next()){
						cnt = dbRowset.getString("ROW_CNT");
					}

				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return cnt;
			}
			 
	 /**
		 * Vendor Report을 조회 합니다.<br>
		 * 
		 * @param VendorReportVO vendorReportVO
		 * @return List<VendorReportVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<VendorReportVO> searchVendorReportList(VendorReportVO vendorReportVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<VendorReportVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vendorReportVO != null){
					Map<String, String> mapVO = vendorReportVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchVendorReportRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorReportVO .class);
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
	 * Office report Count 조회 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @param String ofcEngNm
	 * @param String locCd
	 * @param String ofcKndCd
	 * @param String status
	 * @return String
	 * @throws DAOException
	 */
	public String searchOfficeReportCount(String ofcCd, String ofcEngNm, String locCd, String ofcKndCd, String status) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		param.put("ofc_cd", ofcCd);
		param.put("ofc_eng_nm", ofcEngNm);
		param.put("loc_cd", locCd);
		param.put("ofc_knd_cd", ofcKndCd);
		param.put("status", status);

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOOfficeReportCountRSQL(), param, param);
			
			if(dbRowset.next()){
				cnt = dbRowset.getString("CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * Office Report 정보를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @param String ofcEngNm
	 * @param String locCd
	 * @param String ofcKndCd
	 * @param String status
	 * @return List<OfficeReportVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<OfficeReportVO> searchOfficeReportList(String ofcCd, String ofcEngNm, String locCd, String ofcKndCd, String status) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeReportVO> list = new ArrayList<OfficeReportVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		param.put("ofc_cd", ofcCd);
		param.put("ofc_eng_nm", ofcEngNm);
		param.put("loc_cd", locCd);
		param.put("ofc_knd_cd", ofcKndCd);
		param.put("status", status);
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOOfficeReportVORSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeReportVO.class);
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
		 * office Herary을 조회 합니다.<br>
		 * 
		 * @param SearchOfficHierarchyVO searchOfficHierarchyVO
		 * @return List<SearchOfficHierarchyVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchOfficHierarchyVO> searchOfficeHierarchyList(SearchOfficHierarchyVO searchOfficHierarchyVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchOfficHierarchyVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchOfficHierarchyVO != null){
					Map<String, String> mapVO = searchOfficHierarchyVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchOfficeHierarchyRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficHierarchyVO .class);
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
	 * Vessel Report 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String vslEngNm
	 * @param String crrCd
	 * @param String fdrDivCd
	 * @param String status
	 * @return List<VesselReportVO>
	 * @exception DAOException
	*/
	public List<VesselReportVO>searchVesselReportList(String vslCd, String vslEngNm, String crrCd, String fdrDivCd, String status) throws DAOException {
				DBRowSet dbRowset = null;
				List<VesselReportVO> list = new ArrayList<VesselReportVO>();
				Map<String, Object> param = new HashMap<String, Object>();
				//query parameter
				param.put("vsl_cd", vslCd);
				param.put("vsl_eng_nm", vslEngNm);
				param.put("crr_cd", crrCd);
				param.put("fdr_div_cd", fdrDivCd);
				param.put("status", status);
				try{

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchVesselReportListRSQL(), param, param);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselReportVO.class);
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
	 * Vessel Report Count를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String vslEngNm
	 * @param String crrCd
	 * @param String fdrDivCd
	 * @param String status
	 * @return String
	 * @exception DAOException
	*/
	public String searchVesselReportCount(String vslCd, String vslEngNm, String crrCd, String fdrDivCd, String status) throws DAOException {
				DBRowSet dbRowset = null;
				 String cnt = null;
				 
//					List<VesselReportVO> list = new ArrayList<VesselReportVO>();
					Map<String, Object> param = new HashMap<String, Object>();
					//query parameter
					param.put("vsl_cd", vslCd);
					param.put("vsl_eng_nm", vslEngNm);
					param.put("crr_cd", crrCd);
					param.put("fdr_div_cd", fdrDivCd);
					param.put("status", status);

				try{
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchVesselReportCntRSQL(), param, param);
					                                               
					
					if(dbRowset.next()){
						cnt = dbRowset.getString("CNT");
					}

				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return cnt;			 

			}
	/**
	 * Charge Report 정보를 조회합니다.<br>
	 * 
	 * @param String chgCd
	 * @param String chgNm
	 * @param String repChgCd
	 * @param String status
	 * @return List<ChargeReportVO>
	 * @exception DAOException
	*/
	public List<ChargeReportVO>searchChargeReportList(String chgCd, String chgNm, String repChgCd, String status) throws DAOException {
				DBRowSet dbRowset = null;
				List<ChargeReportVO> list = new ArrayList<ChargeReportVO>();
				Map<String, Object> param = new HashMap<String, Object>();
				//query parameter
				param.put("chg_cd", chgCd);
				param.put("chg_nm", chgNm);
				param.put("rep_chg_cd", repChgCd);
				param.put("status", status);
				try{

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchChargeReportListRSQL(), param, param);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset,ChargeReportVO.class);
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
	 * Charge Report Count를 조회합니다.<br>
	 * 
	 * @param String chgCd
	 * @param String chgNm
	 * @param String repChgCd
	 * @param String status
	 * @return String
	 * @exception DAOException
	*/
	public String searchChargeReportCount(String chgCd, String chgNm, String repChgCd, String status) throws DAOException {
			DBRowSet dbRowset = null;
			String cnt = null;
				 
			Map<String, Object> param = new HashMap<String, Object>();
			//query parameter
			param.put("chg_cd", chgCd);
			param.put("chg_nm", chgNm);
			param.put("rep_chg_cd", repChgCd);
			param.put("status", status);

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReportDBDAOSearchChargeReportCntRSQL(), param, param);
			
			if(dbRowset.next()){
				cnt = dbRowset.getString("CNT");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;			 
	}	
}