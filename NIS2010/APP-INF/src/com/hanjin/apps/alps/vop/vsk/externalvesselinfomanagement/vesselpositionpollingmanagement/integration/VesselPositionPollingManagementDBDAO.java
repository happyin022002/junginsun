/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementDBDAO.java
*@FileTitle : Position Polling Management
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.18
*@LastModifier : LIM YE JI
*@LastVersion : 1.0
* 2014.05.18 LIM YE JI
* 1.0 Creation
* 
* History
* 
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.vo.PositionPollingDetailVO;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.vo.PositionPollingHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * VesselPositionPollingManagementDBDAO Business Logic BasicCommand
 * @author LIM YE-JI
 * @see VesselPositionPollingManagementDBDAO
 * @since J2EE 1.6
 */
public class VesselPositionPollingManagementDBDAO extends DBDAOSupport {
		
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * Position Polling Header 데이터 insert<br>
	 * @param PositionPollingHeaderVO	positionPollingHeaderVOs
	 * @exception DAOException
	 */
	public void createPositionPollingHeader(PositionPollingHeaderVO	positionPollingHeaderVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			if(positionPollingHeaderVOs != null){
				Map<String, String> mapVO = positionPollingHeaderVOs.getColumnValues();

				param.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselPositionPollingManagementDBDAOCreatePositionPollingHeaderCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	
	
	/**
	 * Position Polling Detail 데이터 insert<br>
	 * @param PositionPollingDetailVO	positionPollingDetailVO
	 * @return void
	 * @exception DAOException
	 */
	public void createPositionPollingDetailList(PositionPollingDetailVO	positionPollingDetailVO) throws DAOException {
		SQLExecuter sqlExe	= new SQLExecuter("");
		try {
			Map<String, String> param = new HashMap<String, String>();
			
			if(positionPollingDetailVO != null){
				Map<String, String> mapVO = positionPollingDetailVO.getColumnValues();

				param.putAll(mapVO);
				
				sqlExe.executeUpdate((ISQLTemplate)new VesselPositionPollingManagementDBDAOCreatePositionPollingDetailCSQL(), param, null);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Position Polling Receive date 추출<br>
	 * @return String
	 * @exception DAOException
	 */
	public String createRcvDt() throws DAOException {
		
		SQLExecuter sqlExe 		= new SQLExecuter("");
		DBRowSet	dbRowset	= new DBRowSet();
		String		sRcvDt		= null;
		
		try {
			dbRowset	= sqlExe.executeQuery((ISQLTemplate)new VesselPositionPollingManagementDBDAOCreateRcvDtRSQL(), null, null);

			if(dbRowset.next())		sRcvDt	= dbRowset.getString(1);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return sRcvDt;
	}	
	
	/**
	 * Position Polling Daily Receive sequence 추출<br>
	 * @param String sRcvDt
	 * @return String
	 * @exception DAOException
	 */
	public String createDlyRcvSeq(String sRcvDt) throws DAOException {
		
		SQLExecuter sqlExe 		= new SQLExecuter("");
		DBRowSet	dbRowset	= new DBRowSet();
		String		sDlyRcvSeq		= null;
		
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rcv_dt", sRcvDt);
			dbRowset	= sqlExe.executeQuery((ISQLTemplate)new VesselPositionPollingManagementDBDAOCreateDlyRcvSeqRSQL(), mapVO, null);

			if(dbRowset.next()){
				sDlyRcvSeq	= dbRowset.getString(1);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return sDlyRcvSeq;
	}	
	
	/**
	 * Position Polling Detail List 추출<br>
	 * @param PositionPollingHeaderVO positionPollingHeaderVO
	 * @return List<PositionPollingDetailVO>
	 * @exception DAOException
	 */
	public List<PositionPollingDetailVO>  selectPositionPollingDetailList(PositionPollingHeaderVO positionPollingHeaderVO) throws DAOException {
		SQLExecuter sqlExe	= new SQLExecuter("");
		DBRowSet	rs	= new DBRowSet();
		List<PositionPollingDetailVO> rtnDtlVOs = new ArrayList<PositionPollingDetailVO>();
		try {
			Map<String, String> param = new HashMap<String, String>();
			
			if(positionPollingHeaderVO != null){
				Map<String, String> mapVO = positionPollingHeaderVO.getColumnValues();

				param.putAll(mapVO);
				
				rs = sqlExe.executeQuery((ISQLTemplate)new VesselPositionPollingManagementDBDAOSearchPositionPollingDetailListRSQL(), param, null);
			}
			rtnDtlVOs = (List)RowSetUtil.rowSetToVOs(rs, PositionPollingDetailVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	return rtnDtlVOs;
	}
	
	/**
	 * Position Polling Detail Previous VVD data 추출<br>
	 * @param PositionPollingDetailVO positionPollingDetailVO
	 * @return PositionPollingDetailVO
	 * @exception DAOException
	 */
	public PositionPollingDetailVO  selectPositionPollingDetailVvd(PositionPollingDetailVO positionPollingDetailVO) throws DAOException {
		SQLExecuter sqlExe	= new SQLExecuter("");
		DBRowSet	rs	= new DBRowSet();
		PositionPollingDetailVO rtnDtlVO = new PositionPollingDetailVO();
		try {
			Map<String, String> param = new HashMap<String, String>();
			
			if(positionPollingDetailVO != null){
				Map<String, String> mapVO = positionPollingDetailVO.getColumnValues();

				param.putAll(mapVO);
				
				rs = sqlExe.executeQuery((ISQLTemplate)new VesselPositionPollingManagementDBDAOSearchPositionPollingDetailVvdRSQL(), param, null);
			}
			
			if(rs.next()){
				rtnDtlVO.setSkdVoyNo(rs.getString("SKD_VOY_NO"));
				rtnDtlVO.setSkdDirCd(rs.getString("SKD_DIR_CD"));
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	return rtnDtlVO;
	}
	
	/**
	 * Position Polling Daily Receive previous Position Polling data 추출<br>
	 * @param PositionPollingDetailVO positionPollingDetailVO
	 * @return PositionPollingDetailVO
	 * @exception DAOException
	 */
	public PositionPollingDetailVO  selectPositionPollingDetailPre(PositionPollingDetailVO positionPollingDetailVO) throws DAOException {
		SQLExecuter sqlExe	= new SQLExecuter("");
		DBRowSet	rs	= new DBRowSet();
		PositionPollingDetailVO rtnDtlVO = new PositionPollingDetailVO();
		try {
			Map<String, String> param = new HashMap<String, String>();
			
			if(positionPollingDetailVO != null){
				Map<String, String> mapVO = positionPollingDetailVO.getColumnValues();

				param.putAll(mapVO);
				
				rs = sqlExe.executeQuery((ISQLTemplate)new VesselPositionPollingManagementDBDAOSearchPositionPollingDetailPreRSQL(), param, null);
			}
			if(rs.next()){
				rtnDtlVO.setVslPreLat(rs.getString("VSL_PRE_LAT"));
				rtnDtlVO.setVslPreLon(rs.getString("VSL_PRE_LON"));
				rtnDtlVO.setVslPreSpd(rs.getString("VSL_PRE_SPD"));
				rtnDtlVO.setVslPreProgDirCtnt(rs.getString("VSL_PRE_PROG_DIR_CTNT"));
				rtnDtlVO.setPlngGenDiffHrs(rs.getString("PLNG_GEN_DIFF_HRS"));
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	return rtnDtlVO;
	}
	
	/**
	 * Position Polling Detail list Update 추출<br>
	 * @param PositionPollingDetailVO positionPollingDetailVO
	 * @return String
	 * @exception DAOException
	 */
	public void  updatePositionPollingDetailList(PositionPollingDetailVO positionPollingDetailVO) throws DAOException {
		SQLExecuter sqlExe	= new SQLExecuter("");
		try {
			Map<String, String> param = new HashMap<String, String>();
			
			if(positionPollingDetailVO != null){
				Map<String, String> mapVO = positionPollingDetailVO.getColumnValues();

				param.putAll(mapVO);
				
				sqlExe.executeUpdate((ISQLTemplate)new VesselPositionPollingManagementDBDAOUpdatePositionPollingDetailListUSQL(), param, null);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}
	

	/**
	 * Position Polling Header에 트랜잭셩 종료시 UPD_DT Update<br>
	 * @param PositionPollingHeaderVO	positionPollingHeaderVO
	 * @return void
	 * @exception DAOException
	 */
	public void updatePositionPollingUpateDate(PositionPollingHeaderVO	positionPollingHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			if(positionPollingHeaderVO != null){
				Map<String, String> mapVO = positionPollingHeaderVO.getColumnValues();

				param.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselPositionPollingManagementDBDAOUpdatePositionPollingUpdDtUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	
	
	/**
	 * Position Polling Daily File Duplication 조회<br>
	 * @param PositionPollingHeaderVO positionPollingHeaderVO
	 * @return PositionPollingHeaderVO
	 * @exception DAOException
	 */
	public PositionPollingHeaderVO  selectPositionPollingHeaderDupInfo(PositionPollingHeaderVO positionPollingHeaderVO) throws DAOException {
		SQLExecuter sqlExe	= new SQLExecuter("");
		DBRowSet	rs	= new DBRowSet();
		PositionPollingHeaderVO rtnDtlVO = new PositionPollingHeaderVO();
		try {
			Map<String, String> param = new HashMap<String, String>();
			
			if(positionPollingHeaderVO != null){
				Map<String, String> mapVO = positionPollingHeaderVO.getColumnValues();

				param.putAll(mapVO);
				
				rs = sqlExe.executeQuery((ISQLTemplate)new VesselPositionPollingManagementDBDAOSelectPositionPollingHeaderRSQL(), param, null);
			}
			
			//RCV_CTNT에 DUPLICATED로 Update
			if(rs.next()){
				rtnDtlVO.setRcvCtnt(rs.getString("RCV_CTNT"));
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	return rtnDtlVO;
	}
	
	
	
}