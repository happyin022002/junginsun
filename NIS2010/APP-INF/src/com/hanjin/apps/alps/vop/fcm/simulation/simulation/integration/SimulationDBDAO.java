/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineDBDAO.java
*@FileTitle : TrendLineDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
* 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발
* 2014.09.25 Lee Byoung Hoon [CHM-201431761] PF SKED simulation 기능과 연동으로 Bunker 소모량 산출 기능
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.BnkReqSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfDtlSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.SmlPfSkdVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.StandardFocVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.TrndLineSimulationVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration.ProformaScheduleMgtDBDAOPfSkdVORSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.FcmVslPortStndFuelOilVO;

/**
 * ALPS TrendLineDBDAO<br>
 * ALPS TEMP1 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see TrendLineBCImpl 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;
	
	 /**
	 * 등록된 Proforma SKD 정보를 조회한다.<br>
	 * 
	 * @param SmlPfSkdVO smlPfSkdVO
	 * @return List<PfSkdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SmlPfSkdVO> searchPfSkd(SmlPfSkdVO smlPfSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SmlPfSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(smlPfSkdVO != null){
				Map<String, String> mapVO = smlPfSkdVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProformaScheduleMgtDBDAOPfSkdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SmlPfSkdVO .class);
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
	 * 등록된 Proforma SKD Simulation 정보를 조회한다.<br>
	 * Add By 2014.09.25 Lee Byoung Hoon
	 * 
	 * @param SmlPfSkdVO smlPfSkdVO
	 * @return List<PfSkdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SmlPfSkdVO> searchPfSkdSim(SmlPfSkdVO smlPfSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SmlPfSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(smlPfSkdVO != null){
				Map<String, String> mapVO = smlPfSkdVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOFcmBnkCsmPfSimVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SmlPfSkdVO .class);
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
	 * Bunker Consumption Simulation 결과의 detail을 생성한다.<br>
	 * 
	 * @param FcmBnkCsmPfDtlSimVO fcmBnkCsmPfDtlSimVO
	 * @exception DAOException
	 */
	public void addFcmBnkCsmPfDtlSim(FcmBnkCsmPfDtlSimVO fcmBnkCsmPfDtlSimVO) throws DAOException {
		    SQLExecuter sqlExe = new SQLExecuter("");
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = fcmBnkCsmPfDtlSimVO.getColumnValues();
			param.putAll(paramMap);
			velParam.putAll(paramMap);
			sqlExe.executeUpdate((ISQLTemplate) new SimulationDBDAOFcmBnkCsmPfDtlSimVOCSQL(), param, velParam);     
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
		 
		 /**
		 * Bunker Consumption Simulation 결과의 detail을 변경한다.<br>
		 * 
		 * @param FcmBnkCsmPfDtlSimVO fcmBnkCsmPfDtlSimVO
		 * @exception DAOException
		 */
		public void modifyFcmBnkCsmPfDtlSim(FcmBnkCsmPfDtlSimVO fcmBnkCsmPfDtlSimVO) throws DAOException {
			    SQLExecuter sqlExe = new SQLExecuter("");
			try{
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();			
				Map<String , String> paramMap = fcmBnkCsmPfDtlSimVO.getColumnValues();
				param.putAll(paramMap);
				velParam.putAll(paramMap);
				sqlExe.executeUpdate((ISQLTemplate) new SimulationDBDAOFcmBnkCsmPfDtlSimVOUSQL(), param, velParam);     
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

		}
		 
		 /**
		 * simulation no의 max 값을 조회한다.<br>
		 * 
		 * @return String
		 * @exception DAOException
		 */
		public String  searchMaxSimno() throws DAOException {
			String  simno="0";
            DBRowSet dbRowset = null;
			try{
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOMaxSimnoRSQL(), null, null);
				if(dbRowset.next()){
					simno = dbRowset.getString("simno");
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return simno;
		} 
			 
		 /**
		 * Bunker Consumption Simulation 결과를 생성한다.<br>
		 * 
		 * @param FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO
		 * @return int
		 * @exception DAOException
		 */
		public int addFcmBnkCsmPfSim(FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO) throws DAOException {
			int addCnt = 0;
			SQLExecuter sqlExe = new SQLExecuter("");
			try{
				Map<String, Object> velParam = new HashMap<String, Object>();			
				Map<String , String> paramMap = fcmBnkCsmPfSimVO.getColumnValues();			
				addCnt = sqlExe.executeUpdate((ISQLTemplate)new SimulationDBDAOFcmBnkCsmPfSimVOCSQL(), paramMap, velParam); 
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return addCnt;
		}
			 
	/**
	 * 지정된 VVD에 대해 Bunker Request Simulation을 한다. <br>
	 * 
	 * @param SmlPfSkdVO smlPfSkdVO
	 * @param String vsl_clss_cd
	 * @return List<FcmBnkCsmPfDtlSimVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FcmBnkCsmPfDtlSimVO> searchFcmBnkCsmPfDtlSimSmlPfSkd(SmlPfSkdVO smlPfSkdVO,String vsl_clss_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmBnkCsmPfDtlSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(smlPfSkdVO != null){
				Map<String, String> mapVO = smlPfSkdVO .getColumnValues();

				param.putAll(mapVO);
				param.put("vsl_clss_cd", vsl_clss_cd);
				velParam.putAll(mapVO);
				velParam.put("vsl_clss_cd", vsl_clss_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOFcmBnkCsmPfDtlSimVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmBnkCsmPfDtlSimVO .class);
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
	 * Simulation에 필요한 Vessel Registration 정보를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return FcmVslCntrRgstVO
	 * @exception DAOException
	 */
	public FcmVslCntrRgstVO searchVslRgstInfo(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOVslRgstInfoRSQL(), param, velParam);
			FcmVslCntrRgstVO fcmVslCntrRgstVO = new FcmVslCntrRgstVO();
			if(dbRowset.next()){
				fcmVslCntrRgstVO.setOpMinSpd(dbRowset.getString("op_min_spd"));
				fcmVslCntrRgstVO.setOpMaxSpd(dbRowset.getString("op_max_spd"));
				fcmVslCntrRgstVO.setOpGnrSpd(dbRowset.getString("op_gnr_spd"));
				fcmVslCntrRgstVO.setMnvrCsmWgt(dbRowset.getString("mnvr_csm_wgt"));
				fcmVslCntrRgstVO.setGnrCsmWgt(dbRowset.getString("gnr_csm_wgt"));
			}
			
			return fcmVslCntrRgstVO;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	 /**
	  * 해당 Vessel으로 생성된 Trnd Line이 존재하는지 check<br>
	  * 
	  * @param String vslCd
	  * @return String
	  * @exception DAOException
	  */
	 public String checkVslCdOfTrndLine(String vslCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String isOk = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(vslCd != null){
				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOCheckVslCdOfTrndLineRSQL(), param, velParam);
			 if(dbRowset.next()){
				 isOk = dbRowset.getString("is_ok");
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return isOk;
	 }	 

	 /**
	 * 조건에 맞는 Trnd Line(1,3,6)을 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmTrndLineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmTrndLineVO> searchTrndLineForFOC(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmTrndLineVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchTrndLineForFOCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmTrndLineVO .class);
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
	 * Trnd Line이 생성되어 있는 vsl의 direction을 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchTrndLineDirCd(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrDirCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchTrndLineDirCdRSQL(), param, velParam);
			int i=0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrDirCd = new String[dbRowset.getRowCount()];
				}
				arrDirCd[i] = dbRowset.getString(1);
				i++;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrDirCd;
	}
	
	/**
	 * Trnd Line이 생성되어 있는 Capa를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchCapaOfTrndLine(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrCapa = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchCapaOfTrndLineRSQL(), param, velParam);
			int i=0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrCapa = new String[dbRowset.getRowCount()];
				}
				arrCapa[i] = dbRowset.getString(1);
				i++;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrCapa;
	}
	
	/**
	 * Trnd Line이 생성되어 있는 Class Sub Code를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchSubClassOfTrndLine(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrSubClass = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchSubClassOfTrndLineRSQL(), param, velParam);
			int i=0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrSubClass = new String[dbRowset.getRowCount()];
				}
				arrSubClass[i] = dbRowset.getString(1);
				i++;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrSubClass;
	}
	
	/**
	 * Trnd Line이 생성되어 있는 Lane Code를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchLaneCdOfTrndLine(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrLane = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchLaneCdOfTrndLineRSQL(), param, velParam);
			int i=0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrLane = new String[dbRowset.getRowCount()];
				}
				arrLane[i] = dbRowset.getString(1);
				i++;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrLane;
	}
	
	/**
	 * Bunker Request Simulation에 필요한 VVD 정보를 조회한다.
	 * 
	 * @param BnkReqSimVO bnkReqSimVO
	 * @return List<BnkReqSimVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BnkReqSimVO> searchVvd(BnkReqSimVO bnkReqSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BnkReqSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bnkReqSimVO != null){
				Map<String, String> mapVO = bnkReqSimVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("vvd_seq", new Integer(bnkReqSimVO.getVvdSeq()));
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOBnkReqSimVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BnkReqSimVO.class);
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
	 * Search Average Consumption Weight between port pairs using FCM Departure Report.
	 * 
	 * @param String vslCd
	 * @param String depPortCd
	 * @param String nxtPortCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAvgCsmWgtPortPair(String vslCd, String depPortCd, String nxtPortCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BnkReqSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String avgCsmWgt = null;

		try{
			param.put("vsl_cd", vslCd);
			param.put("dep_port_cd", depPortCd);
			param.put("nxt_port_cd", nxtPortCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchAvgCsmWgtPortPairRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BnkReqSimVO.class);
			avgCsmWgt = list.get(0).getAvgCsmWgt();
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return avgCsmWgt;
	}
//	/**
//	 * Bunker Request Simulation에 필요한 VVD 정보를 체크한다.
//	 * 
//	 * @param BnkReqSimVO bnkReqSimVO
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int checkVvd(BnkReqSimVO bnkReqSimVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		int check = -1;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(bnkReqSimVO != null){
//				Map<String, String> mapVO = bnkReqSimVO.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOCheckBnkReqSimVvdRSQL(), param, velParam);
//			if(dbRowset.next()){
//				check = dbRowset.getInt(1);
//			}
//			return check;
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
//	/**
//	 * Bunker Request Simulation에 필요한 Last Departure Port를 조회한다.
//	 * 
//	 * @param BnkReqSimVO bnkReqSimVO
//	 * @return FcmDepRptVO
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public FcmDepRptVO searchLastDepPort(BnkReqSimVO bnkReqSimVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<FcmDepRptVO> list = null;
//		FcmDepRptVO fcmDepRptVO = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(bnkReqSimVO != null){
//				Map<String, String> mapVO = bnkReqSimVO.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOLastDepPortRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmDepRptVO.class);
//			if(list!=null && list.size()>0){
//				fcmDepRptVO = list.get(0);
//			}
//			return fcmDepRptVO;
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	/**
	 * Search trend line to simulate bunker request.
	 * 
	 * @param BnkReqSimVO bnkReqSimVO
	 * @return FcmTrndLineVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public FcmTrndLineVO searchTrendLineForBnkReqSim(BnkReqSimVO bnkReqSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		FcmTrndLineVO fcmTrndLineVO = null;
		List<FcmTrndLineVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bnkReqSimVO != null){
				Map<String, String> mapVO = bnkReqSimVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchTrendLineForBnkReqSimRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FcmTrndLineVO.class);
			if(list!=null && list.size()>0){
				fcmTrndLineVO = list.get(0);
			}
			return fcmTrndLineVO;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 이미 선택된 조건들로 target 정보를 조회한다.
	 * 
	 * @param TrndLineSimulationVO trndLineSimulationVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchTrndLineItmList(TrndLineSimulationVO trndLineSimulationVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rslt = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(trndLineSimulationVO != null){
				Map<String, String> mapVO = trndLineSimulationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchTrndLineItmListRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					rslt = new String[dbRowset.getRowCount()];
				}
				rslt[i] = dbRowset.getString(1);
				i++;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rslt;
	}
	
	/**
	 * Standard FOC 화면을 조회한다.
	 * 
	 * @param StandardFocVO standardFocVO
	 * @return List<StandardFocVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StandardFocVO> searchStandardFoc(StandardFocVO standardFocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StandardFocVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(standardFocVO != null){
				Map<String, String> mapVO = standardFocVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("vvd_seq", new Integer(standardFocVO.getVvdSeq()));
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SimulationDBDAOSearchStandardFocRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StandardFocVO.class);
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
	 * Standard FOC 정보를 저장한다.<br>
	 * 
	 * @param List<FcmVslPortStndFuelOilVO> mergeModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] mergeMultiFcmVslPortStndFuelOilS(List<FcmVslPortStndFuelOilVO> mergeModels) throws DAOException,Exception {
		int mergeCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(mergeModels.size() > 0){
				mergeCnt = sqlExe.executeBatch((ISQLTemplate)new SimulationDBDAOFcmVslPortStndFuelOilCSQL(), mergeModels, null);
				
				for(int i = 0; i < mergeCnt.length; i++){
					if(mergeCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Merge No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mergeCnt;
	}
}
