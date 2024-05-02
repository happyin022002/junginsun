/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQAvailabilityFinderDAO.java
*@FileTitle : EQ Availability
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic.EQAvailabilityFinderBCImpl;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailDetailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailRepoListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS EQAvailabilityFinderDAO <br>
 * - ALPS-ContainerSupplyDemandForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kim jong jun
 * @see EQAvailabilityFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class EQAvailabilityFinderDBDAO extends DBDAOSupport {

	
	/**
	 * EQ Availability 조회<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return List<AvailListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AvailListVO> searchAvailList(AvailOptionVO availOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(availOptionVO != null){
				Map<String, String> mapVO = availOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQAvailabilityFinderDBDAOsearchAvailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailListVO.class);
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
	 * MTY Reposition for EQ Availability 조회<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return List<AvailRepoListVO>
	 * @exception DAOException
	 */
	public AvailRepoListVO[] searchAvailRepoList(AvailOptionVO availOptionVO) throws DAOException {
	 	AvailRepoListVO[] availRepoListVOs = null;
		try {
			StringTokenizer  st = new StringTokenizer(availOptionVO.getHeadCntrTpszCd(),"|");
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd1  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd2  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd3  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd4  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd5  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd6  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd7  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd8  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd9  (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd10 (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd11 (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd12 (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd13 (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd14 (st.nextToken());
			if ( st.hasMoreTokens() ) availOptionVO.setCntrTpszCd15 (st.nextToken());
			availOptionVO.setHeadCntrTpszCd(availOptionVO.getHeadCntrTpszCd().replace("|", ","));
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new EQAvailabilityFinderDBDAOsearchAvailRepoListRSQL(), availOptionVO.getColumnValues(), availOptionVO.getColumnValues(),AvailRepoListVO.class);
			availRepoListVOs = (AvailRepoListVO[])voList.toArray(new AvailRepoListVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return availRepoListVOs;		 
 	 }
	
	/**
	 *예정 MTY Pick-up 일자가 지난 BR(Booking 정보)를 조회한다.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception DAOException
	 */
	public AvailDetailListVO[] searchAvailPastBRList(AvailOptionVO availOptionVO) throws DAOException {
		AvailDetailListVO[] availDetailListVOs = null;
		try {
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new EQAvailabilityFinderDBDAOsearchAvailPastBRListRSQL(), availOptionVO.getColumnValues(), availOptionVO.getColumnValues(),AvailDetailListVO.class);
			availDetailListVOs = (AvailDetailListVO[])voList.toArray(new AvailDetailListVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return availDetailListVOs;		 
	 
	 }

	/**
	 *BR(Booking Reserved)의 Detail한 BKG 정보를 조회한다.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception DAOException
	 */
	public AvailDetailListVO[] searchAvailBRList(AvailOptionVO availOptionVO) throws DAOException {
		AvailDetailListVO[] availDetailListVOs = null;
		try {
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new EQAvailabilityFinderDBDAOsearchAvailBRListRSQL(), availOptionVO.getColumnValues(), availOptionVO.getColumnValues(),AvailDetailListVO.class);
			availDetailListVOs = (AvailDetailListVO[])voList.toArray(new AvailDetailListVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return availDetailListVOs;		 
	 
	 }
	
	/**
	 *금일 Pick-up된(PUP, Picked Up) 컨테이너 수량을 조회한다.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception DAOException
	 */
	public AvailDetailListVO[] searchAvailPickUpList(AvailOptionVO availOptionVO) throws DAOException {
		AvailDetailListVO[] availDetailListVOs = null;
		try {
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new EQAvailabilityFinderDBDAOsearchAvailPickUpListRSQL(), availOptionVO.getColumnValues(), availOptionVO.getColumnValues(),AvailDetailListVO.class);
			availDetailListVOs = (AvailDetailListVO[])voList.toArray(new AvailDetailListVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return availDetailListVOs;		 
	 
	 }	

	/**
	 *IG(I/B MTY Generation) 예측수량을 Detail하게 조회.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception DAOException
	 */
	public AvailDetailListVO[] searchAvailIGList(AvailOptionVO availOptionVO) throws DAOException {
		AvailDetailListVO[] availDetailListVOs = null;
		try {
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new EQAvailabilityFinderDBDAOsearchAvailIGListRSQL(), availOptionVO.getColumnValues(), availOptionVO.getColumnValues(),AvailDetailListVO.class);
			availDetailListVOs = (AvailDetailListVO[])voList.toArray(new AvailDetailListVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return availDetailListVOs;		 
	 
	 }
	
	/**
	 *금일 MTY Returned 컨테이너 수량을 확인하는 화면.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception DAOException
	 */
	public AvailDetailListVO[] searchAvailRTNList(AvailOptionVO availOptionVO) throws DAOException {
		AvailDetailListVO[] availDetailListVOs = null;
		try {
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new EQAvailabilityFinderDBDAOsearchAvailRTNListRSQL(), availOptionVO.getColumnValues(), availOptionVO.getColumnValues(),AvailDetailListVO.class);
			availDetailListVOs = (AvailDetailListVO[])voList.toArray(new AvailDetailListVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return availDetailListVOs;		 
	 }
	
	/**
	 *Off-hire 계획 및 실적(조회당일)의 Detail 정보를 확인.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception DAOException
	 */
	public AvailDetailListVO[] searchAvailOFFList(AvailOptionVO availOptionVO) throws DAOException {
		AvailDetailListVO[] availDetailListVOs = null;
		try {
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new EQAvailabilityFinderDBDAOsearchAvailOFFListRSQL(), availOptionVO.getColumnValues(), availOptionVO.getColumnValues(),AvailDetailListVO.class);
			availDetailListVOs = (AvailDetailListVO[])voList.toArray(new AvailDetailListVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return availDetailListVOs;		 
	 
	 }	
	
	
	/**
	 *On-hire 계획 및 실적(조회당일)의 Detail 정보를 확인.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception DAOException
	 */
	public AvailDetailListVO[] searchAvailONList(AvailOptionVO availOptionVO) throws DAOException {
		AvailDetailListVO[] availDetailListVOs = null;
		try {
			List<AbstractValueObject> voList = new SQLExecuter("").executeQuery(new EQAvailabilityFinderDBDAOsearchAvailONListRSQL(), availOptionVO.getColumnValues(), availOptionVO.getColumnValues(),AvailDetailListVO.class);
			availDetailListVOs = (AvailDetailListVO[])voList.toArray(new AvailDetailListVO[voList.size()]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return availDetailListVOs;		 
	 
	 }		
}
