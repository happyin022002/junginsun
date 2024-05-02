/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonFinderDAO.java
*@FileTitle : CommonFinder
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
* 2010.11.11 김태균 [CHM-201007006-01] [EES-DMT] [DMDT] Invoice Currency 선택 기능 추가
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ARCurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.AttentionVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.BookingNoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CountryCdVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CustomerVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.DayVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.LocationCdVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.RhqOfcCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.SheetOptionByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.SheetSetVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS DMTCommonFinderDAO <br>
 * - OPUS-DMTCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SungHoon, Lee
 * @see DMTCommonFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class CommonFinderDBDAO extends DBDAOSupport {
	
	
	/**
	 * 모든 Region 정보를 조회 합니다. <br>
	 * 
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchRegionList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchRegionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * 국가에 소속된 모든 Region 정보를 조회 합니다. <br>
	 * 
	 * @param String cntCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchRegionListByCountry(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchRegionListByCountryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Country 테이블에 있는 모든 Country 목록을 조회한다.<br>
	 * 
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchCountryList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOCountryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Calculation Type 테이블에 있는 모든 Country 목록을 조회한다.<br>
	 * 
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchDualCountryList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAODualTypeCountryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Country 테이블에 있는 모든 Country 목록을 조회한다.<br>
	 * 
	 * @param String svrId
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchCountryListByRHQ(String svrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("svr_id", svrId);
			velParam.put("svr_id", svrId);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOCountryByRHQRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Continent 테이블에 있는 모든 Country 목록을 조회한다.<br>
	 * 
	 * @param String contiCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchCountryListByContinent(String contiCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("conti_cd", contiCd);
			velParam.put("conti_cd", contiCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOCountryListByContinentRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Calculation Type 테이블에 Country Code 에 해당되는 모든 Region 정보를 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchDualRegionListByCountry(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAODualTypeRegionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Country Code 에 해당되는 모든 State 정보를 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchStateListByCountry(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOStateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Calculation Type 테이블에 Country Code 에 해당되는 모든 State 정보를 조회한다.<br>
	 * 
	 * @param String cntCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchDualStateListByCountry(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAODualTypeStateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Location Code 를 포함하는 Country, Region 정보를 조회한다.<br>
	 * 
	 * @param String locCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchRHQHierarchyByLocation(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAORHQHierarchyByLocationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Yard Code 를 포함하는 Country, Region, Location 정보를 조회한다.<br>
	 * 
	 * @param String ydCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchRHQHierarchyByYard(String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("yd_cd", ydCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAORHQHierarchyByYardRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Location Code 를 포함하는 Country, Region 정보를 조회한다.<br>
	 * 
	 * @param String locCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchContinentHierarchyByLocation(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOContinentHierarchyByLocationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Calculation Type 테이블에 Location Code 를 포함하는 Country, Region 정보를 조회한다.<br>
	 * 
	 * @param String locCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchDualRHQHierarchyByLocation(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAODualTypeRHQHierarchyByLocationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Tariff Type 정보를 조회한다.<br>
	 * 
	 * @return List<TariffNameVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TariffNameVO> searchTariffTypeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffNameVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOTariffNameVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TariffNameVO.class);
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
	 * User별 설정된 Tariff Type 정보를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String searchUserTariffType(String ofcCd, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			param.put("ofc_cd", ofcCd);
			param.put("usr_id", usrId);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOUserTariffTypeRSQL(), param, null);
			
			String result = "";
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DEM/DET OFFICE 정보를 조회한다.<br>
	 * 
	 * @return List<OfficeNameVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfficeNameVO> searchDemDetOfficeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeNameVO> list = null;
		// query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOOfficeNameVORSQL(), null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeNameVO.class);
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
	 * RHQ Office Code에 대한 OFFICE 정보를 조회한다.<br>
	 * 
	 * @param String rhqOfcCd
	 * @return List<OfficeNameVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfficeNameVO> searchOfficeListByRhq(String rhqOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeNameVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			param.put("rhq_ofc_cd", rhqOfcCd);
			velParam.put("rhq_ofc_cd", rhqOfcCd);
			//2011.03.02. 하드코딩 제거작업
			param.put("head_office", ConstantMgr.getHeadOfficeCode());
			velParam.put("head_office", ConstantMgr.getHeadOfficeCode());

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchOfficeListByRhqRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeNameVO.class);
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
	 * @param OfficeNameVO officeNameVO
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchDemDetSubOfficeList(OfficeNameVO officeNameVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<String> list = null;
		// query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(officeNameVO != null){
				String ofcCd = officeNameVO.getOfcCd();
					
				List<String> ofcCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(ofcCd, ",");
				
			    while (st.hasMoreTokens()) {
			    	ofcCdList.add(st.nextToken());
			    }
			    
				velParam.put("prnt_ofc_cd", ofcCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSubOfficeNameVORSQL(), null, velParam);
			
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

	/**
	 * 입력된 Booking No가 유효한 것인지 Check한다.<br>
	 * 
	 * @param BookingNoVO bookingNoVO
	 * @return BookingNoVO
	 * @throws DAOException
	 */
	public BookingNoVO checkBookingNo(BookingNoVO bookingNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		BookingNoVO retBookingNoVO = new BookingNoVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(bookingNoVO != null){
				Map<String, String> mapVO = bookingNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOBookingNoVORSQL(), param,
					velParam);
			
			if(dbRowset.next()) {
				retBookingNoVO.setBkgNo(dbRowset.getString("BKG_NO"));
				retBookingNoVO.setBlNo(dbRowset.getString("BL_NO"));
				retBookingNoVO.setScNo(dbRowset.getString("SC_NO"));
				retBookingNoVO.setRfaNo(dbRowset.getString("RFA_NO"));				
			} else {
				retBookingNoVO.setBkgNo("");
				retBookingNoVO.setBlNo("");
				retBookingNoVO.setScNo("");
				retBookingNoVO.setRfaNo("");		
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retBookingNoVO;
	}
	
	/**
	 * 입력된 Location Code가 유효한 것인지 Check한다.<br>
	 * 
	 * @param LocationCdVO locationCdVO
	 * @return LocationCdVO
	 * @throws DAOException
	 */
	public LocationCdVO checkLocationCd(LocationCdVO locationCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		LocationCdVO retLocationCdVO = new LocationCdVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(locationCdVO != null){
				Map<String, String> mapVO = locationCdVO.getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOLocationCdRSQL(), param, null);
			
			if(dbRowset.next()) {
				retLocationCdVO.setLocCd(dbRowset.getString("loc_cd"));
				retLocationCdVO.setLocRhqCd(dbRowset.getString("loc_rhq_cd"));
			} else {
				retLocationCdVO.setLocCd("");
				retLocationCdVO.setLocRhqCd("");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retLocationCdVO;
	}
	
    /**
     * 입력된 Location Code가 유효한 것인지 Check한다.<br>
     * 
     * @param LocationCdVO locationCdVO
     * @return LocationCdVO
     * @throws DAOException
     */
    public LocationCdVO checkLocationCd2(LocationCdVO locationCdVO) throws DAOException {
        DBRowSet dbRowset = null;
        LocationCdVO retLocationCdVO = new LocationCdVO();
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
    
        try {
            if(locationCdVO != null){
                Map<String, String> mapVO = locationCdVO.getColumnValues();
                param.putAll(mapVO);
                //velParam.putAll(mapVO);
            }
                
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new DMTCommonDBDAOLocationCd2RSQL(), param, null);
            
            if(dbRowset.next()) {
                retLocationCdVO.setLocCd(dbRowset.getString("loc_cd"));
            } else {
                retLocationCdVO.setLocCd("");
            }
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retLocationCdVO;
    }
	
	/**
	 * 해당 Country Code의 유효성을 체크한다.
	 * 
	 * @param CountryCdVO countryCdVO
	 * @return CountryCdVO
	 * @throws DAOException
	 */
	public CountryCdVO checkCountryCd(CountryCdVO countryCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(countryCdVO != null){
				Map<String, String> mapVO = countryCdVO.getColumnValues();
				param.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DMTCommonDBDAOCountryCdVORSQL(), param, null);
			
			String cntCd = "";
			if(dbRowset.next())
				cntCd = dbRowset.getString(1);
			
			if(countryCdVO != null){
				countryCdVO.setCntCd(cntCd);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return countryCdVO;
	}
	
	
	/**
	 * 입력된 Continent의 하위 지역 정보를 조회한다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoverageVO> searchHierarchyByYard(CoverageVO coverageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DMTCommonDBDAOSearchHierarchyByYardRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CoverageVO.class);
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
	 * Currency Code List를 조회한다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CurrencyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CurrencyVO> searchCurrencyList(CoverageVO coverageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CurrencyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOCurrencyVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CurrencyVO.class);
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
	 * 지역본부 조회를 조회한다.<br>
	 * 
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchRHQOfficeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAORHQOfficeNameVORSQL(), param,
					velParam);
			//list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeNameVO.class);
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
	
	/** searchAreaByOffice
	 * 
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchAreaByOffice() throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchAreaByOfficeRSQL(), param,
					velParam);
			//list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeNameVO.class);
			while(dbRowset.next()) {
				list.add(dbRowset.getString(2));
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
	
	/** searchOfficByCountry
	 * 
	 * @param CoverageVO coverageVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchOfficByCountry(CoverageVO coverageVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchOfficByCountryRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("SVR_ID");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
	
	/**
	 * 입력된 Region의 정보로 상위지역인 대륙, 국가를 조회한다.<br>
	 * 
	 * @param String rgnCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoverageVO> searchRHQHierarchyByRegion(String rgnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			param.put("rgn_cd", 	rgnCd);
			velParam.put("rgn_cd", 	rgnCd);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchRHQHierarchyByRegionRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CoverageVO.class);
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
	 * 입력된 State의 정보로 상위지역인 대륙, 국가를 조회한다.<br>
	 * 
	 * @param String steCd
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoverageVO> searchRHQHierarchyByState(String steCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			param.put("ste_cd", 	steCd);
			velParam.put("ste_cd", 	steCd);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchRHQHierarchyByStateRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CoverageVO.class);
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
	 * Continet 테이블에 있는 모든 Continet 목록을 조회한다.<br>
	 * 
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchContinetList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOContinetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * ContainerCargo 테이블에 있는 모든 ContainerCargo 목록을 조회한다.<br>
	 * 
	 * @param String code1
	 * @param String code2
	 * @return List<ContainerCargoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
    public List<ContainerCargoVO> searchContainterCargoList(String code1, String code2) throws DAOException {
		DBRowSet dbRowset = null;
		List<ContainerCargoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("code1", code1);
			param.put("code2", code2);
			velParam.put("code1", code1);
			velParam.put("code2", code2);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOContainerCargoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerCargoVO .class);
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
	 * 입력된 Country 로 Continent 를 조회한다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
    public List<CoverageVO> searchContinentByCountry(CoverageVO coverageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchContinetListByCountryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO.class);
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
	 * 입력된 Region의 정보로 상위지역인 대륙, 국가를 조회한다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
    public List<CoverageVO> searchHierarchyByRegion(CoverageVO coverageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchHierarchyByRegionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * 입력된 Region의 정보로 상위지역인 대륙, 국가를 조회한다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
    public List<CoverageVO> searchHierarchyByState(CoverageVO coverageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchHierarchyByStateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * 입력된 Location의 정보로 Yard정보를 조회한다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
    public List<CoverageVO> searchYardListByLocation(CoverageVO coverageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchYardListByLocationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Common Code ID 로 Code 목록정보를 조회한다.<br>
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return List<CommonCodeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
    public List<CommonCodeVO> searchCommonCode(CommonCodeVO commonCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(commonCodeVO != null){
				Map<String, String> mapVO = commonCodeVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchCommonCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonCodeVO .class);
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
	 * Common Code ID 로 Code 목록정보를 조회한다.<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
    public List<CoverageVO> searchRHQHierarchyByCountry(CoverageVO coverageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(coverageVO != null){
				Map<String, String> mapVO = coverageVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchRHQHierarchyByCountryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Region & State('CA','US') 목록을 조회한다.<br>
	 * 
	 * @return List<CoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoverageVO> searchRegionState() throws DAOException {
		DBRowSet dbRowset = null;
		List<CoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAORegionStateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoverageVO .class);
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
	 * Customer Name 을 조회한다.<br>
	 * 
	 * @param CustomerVO customerVO
	 * @return String
	 * @exception EventException
	 */	 
	public String searchCustomerName(CustomerVO customerVO) throws DAOException {
		DBRowSet dbRowset = null;
		String custNm = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (customerVO != null) {
				Map<String, String> mapVO = customerVO .getColumnValues();

				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DMTCommonDBDAOSearchCustomerNameRSQL(), param, null);
			if (dbRowset.next()) {
				custNm = dbRowset.getString("cust_nm");
			} else {
				custNm = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return custNm;
	}
	
	/**
	 * 해당 RHQ 에 속하는 OFFICE 정보를 조회한다.<br>
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchDemDetOfficeListByRHQ(OfficeNameVO officeNameVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<String> list = null;
		// query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(officeNameVO != null){
				Map<String, String> mapVO = officeNameVO.getColumnValues();
				//param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchDemDetOfficeListByRHQRSQL(), null, velParam);
			
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
	
	
	/**
	 * 해당 RHQ 에 속하는 OFFICE 정보를 조회한다.<br>
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchRHQByOffice(OfficeNameVO officeNameVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(officeNameVO != null){
				Map<String, String> mapVO = officeNameVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchRHQByOfficeRSQL(), param, null);
			
			String rhqCd = "";
			if(dbRowset.next()) {
				rhqCd = dbRowset.getString(1);
			}
			return rhqCd;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * 해당 RHQ 에 속하는 OFFICE 정보를 조회한다.<br>
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @throws DAOException
	 */
	public PayerNameVO searchPayerName(PayerNameParamVO payerNameParamVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		PayerNameVO rePayerNameVO = new PayerNameVO();
	
		try {
			if(payerNameParamVO != null){
				Map<String, String> mapVO = payerNameParamVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DMTCommonDBDAOsearchPayerNameRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				rePayerNameVO.setDeltFlg(dbRowset.getString(1));
				rePayerNameVO.setCustCd(dbRowset.getString(2));
				rePayerNameVO.setCustName(dbRowset.getString(3));
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rePayerNameVO;
	}
	
	/**
	 * 해당 Service Provider에 대한 Vendor를 조회한다.<br>
	 * 
	 * @param String serviceProviderCode
	 * @return VendorNameVO
	 * @throws DAOException
	 */
	public VendorNameVO searchServiceProviderName(String serviceProviderCode) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		VendorNameVO reVendorNameVO = new VendorNameVO();
		String code = "";
		String name = "";
	
		try {
			if(serviceProviderCode != null){
				param.put("vndr_cd", serviceProviderCode);
				velParam.put("vndr_cd", serviceProviderCode);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DMTCommonDBDAOSearchServiceProviderNameRSQL(), param, null);
			
			if(dbRowset.next()) {
				code = StringUtils.defaultString(dbRowset.getString(1));
				name = StringUtils.defaultString(dbRowset.getString(2));
			}
			reVendorNameVO.setVndrCd(code);
			reVendorNameVO.setVndrNm(name);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return reVendorNameVO;
	}	
	
	/**
	 * checkTPBCustomerByVendor <br>
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @throws DAOException
	 */
	public PayerNameVO checkTPBCustomerByVendor(PayerNameParamVO payerNameParamVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		PayerNameVO rePayerNameVO = new PayerNameVO();
		
		try {
			if(payerNameParamVO != null){
				Map<String, String> mapVO = payerNameParamVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DMTCommonDBDAOCheckTPBCustomerByVendorRSQL(), param, null);
			
			if(dbRowset.next()) {
				rePayerNameVO.setCustCd(dbRowset.getString(1));
			} else {
				rePayerNameVO.setCustCd("");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rePayerNameVO;
	}
	
	/**
	 * Attention 정보를 조회 합니다.<br>
	 * 
	 * @param AttentionVO attendtionVO
	 * @return List<AttentionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AttentionVO> searchAttention(AttentionVO attendtionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AttentionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			if(attendtionVO != null){
				Map<String, String> mapVO = attendtionVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchAttentionRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AttentionVO .class);
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
	 * Customer 정보를 조회 합니다.<br>
	 * 
	 * @param AttentionVO attendtionVO
	 * @return List<AttentionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AttentionVO> searchAttentionOfCustomer(AttentionVO attendtionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AttentionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(attendtionVO != null){
				Map<String, String> mapVO = attendtionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchAttentionOfCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AttentionVO .class);
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
	 * USD, AR CURRENCY를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String jspNo
	 * @return List<ARCurrencyVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ARCurrencyVO> searchARCurrencyList(String ofcCd, String jspNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARCurrencyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);
			velParam.put("jsp_no", jspNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOARCurrencyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCurrencyVO .class);
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
	 * OFC_CD별 현재일자를 조회한다.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCurrentDateByOffice(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String curr_day = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchCurrentDateByOfficeRSQL(), param, null);
			if(dbRowset.next()){
				curr_day = dbRowset.getString("curr_day");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return curr_day;
	}
	
	/**
	 * AR OFFICE 정보를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String rhqOfc
	 * @return List<OfficeNameVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfficeNameVO> searchAROfficeList(String ofcCd, String rhqOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeNameVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			param.put("ofc_cd", ofcCd);
			velParam.put("rhq_ofc", rhqOfc);
			//2011.03.02. 하드코딩 제거작업
            param.put("head_office", ConstantMgr.getHeadOfficeCode());
            velParam.put("head_office", ConstantMgr.getHeadOfficeCode());
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchAROfficeListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeNameVO.class);
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
	 * 사용자가 주어진 권한정보를 갖고 있는지 조회 합니다.<br>
	 * 
	 * @param UserRoleVO userRoleVO
	 * @return String
	 * @throws DAOException
	 */	
	public String hasRoleAuth(UserRoleVO userRoleVO) throws DAOException {
		DBRowSet 			dbRowset 	= null;
		String 				role 		= null;
		// query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		try {
			
			Map<String, String> mapVO = userRoleVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			//1.USR_ROLE_CD
			String roleCd = userRoleVO.getUsrRoleCd();
			List<String> roleCdList = new ArrayList<String>();
			String[] roleCdArray = roleCd.split(",");
			for (int i = 0 ; i < roleCdArray.length ; i++) {
				roleCdList.add(roleCdArray[i]);
		    }				
			velParam.put("role_cd_list", roleCdList);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOHasRoleAuthRSQL(), param, velParam);

			if (dbRowset.next()) {
				role = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return role;
	}
	
	/**
	 * SHEET SET 이 존재하는지 조회 합니다.<br>
	 * 
	 * @param SheetSetVO sheetSetVO
	 * @return boolean
	 * @throws DAOException
	 */	
	public boolean hasSheetSet(SheetSetVO sheetSetVO) throws DAOException {
		DBRowSet 			dbRowset 	= null;
		boolean				result 		= false;
		// query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		try {
			
			Map<String, String> mapVO = sheetSetVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOHasSheetSetRSQL(), param, velParam);

			if (dbRowset.next()) {
				result = dbRowset.getInt(1) > 0 ? true : false;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * After Booking 의 Office Code 를 조회 합니다.<br>
	 * 
	 * @param String darNo
	 * @param String bkgNo
	 * @param String tariff
	 * @return List<OfficeNameVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")	
	public List<OfficeNameVO> searchAfterBKGOfficeCd(String darNo, String bkgNo, String tariff) throws DAOException {
		DBRowSet 			dbRowset 	= null;
		List<OfficeNameVO> 	list 		= null;
		// query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		try {
			param.put("aft_expt_dar_no", 	darNo);
			param.put("bkg_no", 			bkgNo);
			param.put("dmdt_trf_cd", 		tariff);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchAfterBKGOfficeCdRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeNameVO.class);
			
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
	 * Office Code 의 하위 Office Code 를 조회 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */	
	public String searchPRNTOfficeCd(String ofcCd) throws DAOException {
		DBRowSet 			dbRowset 	= null;
		String 				prntOfcCd 	= null;
		// query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		try {
			param.put("ofc_cd", 	ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DMTCommonDBDAOSearchPRNTOfficeCdRSQL(), param, null);

			if (dbRowset.next()) {
				prntOfcCd = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return prntOfcCd;
	}	
	
	/**
	 * office별 sheet Option 내용을 조회한다.<br>
	 * 
	 * @param SheetOptionByOfficeVO sheetOptionByOfficeVO
	 * @return SheetOptionByOfficeVO
	 * @throws DAOException
	 */
	public SheetOptionByOfficeVO searchSheetOptionByOffice(SheetOptionByOfficeVO sheetOptionByOfficeVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		SheetOptionByOfficeVO reSheetOptionByOfficeVO = new SheetOptionByOfficeVO();
	
		try {
			if(sheetOptionByOfficeVO != null){
				Map<String, String> mapVO = sheetOptionByOfficeVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DMTCommonDBDAOSearchSheetOptionByOfficeRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				reSheetOptionByOfficeVO.setDcAmtFlg(StringUtils.defaultString(dbRowset.getString("dc_amt_flg")));
				reSheetOptionByOfficeVO.setOfcCd(StringUtils.defaultString(dbRowset.getString("ofc_cd")));
				reSheetOptionByOfficeVO.setBilToLocDivCd(StringUtils.defaultString(dbRowset.getString("bil_to_loc_div_cd")));
				reSheetOptionByOfficeVO.setCustRefPrnFlg(StringUtils.defaultString(dbRowset.getString("cust_ref_prn_flg")));
				reSheetOptionByOfficeVO.setPhnFaxPrnFlg(StringUtils.defaultString(dbRowset.getString("phn_fax_prn_flg")));
				reSheetOptionByOfficeVO.setCustVatPrnFlg(StringUtils.defaultString(dbRowset.getString("cust_vat_prn_flg")));
				reSheetOptionByOfficeVO.setDfltTaxRto(StringUtils.defaultString(dbRowset.getString("dflt_tax_rto")));
				reSheetOptionByOfficeVO.setTaxAmtPrnFlg(StringUtils.defaultString(dbRowset.getString("tax_amt_prn_flg")));
			}else{
				reSheetOptionByOfficeVO.setDcAmtFlg("");
				reSheetOptionByOfficeVO.setOfcCd("");
				reSheetOptionByOfficeVO.setBilToLocDivCd("");
				reSheetOptionByOfficeVO.setCustRefPrnFlg("");
				reSheetOptionByOfficeVO.setPhnFaxPrnFlg("");
				reSheetOptionByOfficeVO.setCustVatPrnFlg("");
				reSheetOptionByOfficeVO.setDfltTaxRto("");
				reSheetOptionByOfficeVO.setTaxAmtPrnFlg("");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return reSheetOptionByOfficeVO;
	}

    /**
     * comodity 정보를 조회한다.
     * 
     * @param String cmdtCd
     * @return String
     * @throws DAOException
     */
    public String searchCommodityName(String cmdtCd) throws DAOException {
        DBRowSet dbRowset = null;
        String commodity = "";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try{
            param.put("cmdt_cd", cmdtCd);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchCommodityInfoRSQL(), param, null);
            if(dbRowset.next()){
                commodity = dbRowset.getString("commodity");
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return commodity;
    }
    
    /**
     * 주어진 코드가 State 코드인지를 조회 합니다.
     * 
     * @param String steCd
     * @return boolean
     * @throws DAOException
     */
    public boolean isStateCode(String steCd) throws DAOException {
    	boolean		isStateCode		= false;
        DBRowSet 	dbRowset 		= null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
            param.put("ste_cd", steCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOIsStateCodeRSQL(), param, null);
            
            if(dbRowset.next()){
            	isStateCode = dbRowset.getInt(1) > 0 ? true : false;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return isStateCode;
    }    
    
	/**
	 * Office코드로 국가코드를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchUserCntCode(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchUserCntCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("CNT_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}    
    
	/**
	 * Office코드로 대표고객코드를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchRepCustSeq(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchRepCustSeqRSQL(), param, param);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("ACT_CUST_CNT_CD") + dbRowset.getString("ACT_CUST_SEQ");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/**
	 * From Date, To Date 사이의 차이 일수를 조회 합니다. <br>
	 *
	 * @param DayVO dayVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDaysBetween(DayVO dayVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int rtnValue = -1;
		try{
			Map<String, String> mapVO = dayVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchDaysBetweenRSQL(), param, null);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return Integer.toString(rtnValue);
	}	
	
	
	/**
	 * From Date, To Date 사이의 차이 일수를 조회 합니다. <br>
	 *
	 * @param RhqOfcCodeVO rhqOfcCodeVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchRhqOfcCdByOfcCd(RhqOfcCodeVO rhqOfcCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = rhqOfcCodeVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchRhqOfcCodeByOfcCodeRSQL(), param, null);
			if (dbRowset.next()) {
				rtnValue = StringUtils.defaultString(dbRowset.getString("RHQ_OFC_CD"), "");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * Office코드로 SYS_AREA_GRP_ID를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchUserSysAreaGrpId(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonDBDAOSearchUserSysAreaGrpIdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("SYS_AREA_GRP_ID");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
}
