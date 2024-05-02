/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderDAO.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.04.29 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.DateTimeConvVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.DelayReasonVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.EffectiveVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * NIS2010 VSKCodeFinderDAO <br>
 * - NIS2010-VSKCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see VSKCodeFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class VSKCodeFinderDBDAO extends DBDAOSupport {

	
	/**
	 * Service Lane 리스트를 조회합니다.
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchSvcLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOMdmVslSvcLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO .class);
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
	 * Service Lane Code를 검증합니다.
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> checkSvcLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOCheckSvcLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO .class);
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
	  * 등록된 LANE CODE, DIRECTION이 있는지 확인합니다.
	  * 
	  * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	  * @return int
	  * @exception DAOException
	  */
	 public int checkSvcLaneDir(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 int laneCnt = 0;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(mdmVslSvcLaneDirVO != null){
				 Map<String, String> mapVO = mdmVslSvcLaneDirVO .getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOCheckSvcLaneDirRSQL(), param, velParam);
			 dbRowset.next();
			 laneCnt = dbRowset.getInt("CNT");
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return laneCnt;
	 }
 
	/**
	 * MDM에서 Port 정보를 조회합니다.
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LocationVO> searchPortList(LocationVO locationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(locationVO != null){
				Map<String, String> mapVO = locationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOPortListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationVO .class);
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
	 * Country 정보를 조회합니다.
	 * 
	 * @param String cntCd
	 * @return List<MdmCountryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCountryVO> searchCountryList(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCountryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntCd != null){
				param.put("cnt_cd", cntCd);
				velParam.put("cnt_cd", cntCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOMdmCountryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCountryVO .class);
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
	 * 지역본부(RHQ) 정보를 조회합니다.
	 * 
	 * @return List<OfficeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OfficeVO> searchRhqList() throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAORhqOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeVO .class);
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
	 * RHQ산하에 있는 Control Office Code 정보를 조회합니다.
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LocationVO> searchControlOfficeList(String rhqCd) throws DAOException {
		 /*
		  * 2009.07.24
		  * MdmLocationVO를 사용해도 될거 같으나 설계자(임창빈수석)의 
		  * 강력한 권유로 LocationVO 사용하기로 함.
		  */
		DBRowSet dbRowset = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rhqCd != null){
//				param.put("vop_port_rhq_cd", rhqCd);
//				velParam.put("vop_port_rhq_cd", rhqCd);
				param.put("vskd_port_rhq_cd", rhqCd);
				velParam.put("vskd_port_rhq_cd", rhqCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchControlOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
//	/**
//	 * VSKCodeFinderDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 * 
//	 * @return DBRowSet
//	 * @exception DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public List<PfLaneTypeVO> searchPfLaneTypeList(PfLaneTypeVO pfLaneTypeVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<PfLaneTypeVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(pfLaneTypeVO != null){
//				Map<String, String> mapVO = pfLaneTypeVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOPfLaneTypeVORSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfLaneTypeVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}
	 
	 /**
	  * Estimate VVD 정보를 조회합니다.
	  * 
	  * @param String vslCd
	  * @return List<VvdPortLaneOtherVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VvdPortLaneOtherVO> searchEstVvdList(String vslCd) throws DAOException{
		 DBRowSet dbRowset = null;
		 List<VvdPortLaneOtherVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 if(vslCd != null){
				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOEstVvdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdPortLaneOtherVO.class);
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
	  * 정시성 VVD 정보를 조회합니다.
	  * 
	  * @param String vslCd
	  * @return List<VvdPortLaneOtherVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VvdPortLaneOtherVO> searchRsltVvdList(String vslCd) throws DAOException{
		 DBRowSet dbRowset = null;
		 List<VvdPortLaneOtherVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
//		 VvdPortLaneOtherVO vo = new VvdPortLaneOtherVO();
//		 vo.setVslCd(vslCd);
		 try{
			 if(vslCd != null){
//				 Map<String, String> mapVO = vo .getColumnValues();
//				 param.putAll( mapVO);
//				 velParam.putAll(mapVO);

				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAORsltVvdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdPortLaneOtherVO.class);
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
		 * Carrier 정보를 조회합니다.
		 * 
		 * @param CarrierVO carrierVO
		 * @return List<CarrierVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<CarrierVO> searchCarrierList(CarrierVO carrierVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CarrierVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(carrierVO != null){
					Map<String, String> mapVO = carrierVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchCarrierListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO .class);
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
	 * Carrier 정보를 검증합니다.
	 * 
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CarrierVO> checkCarrier(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarrierVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOCheckCarrierRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO .class);
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
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfLaneTypeVO pfLaneTypeListVO
	 * @return List<PfLaneTypeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfLaneTypeVO> searchPfLaneTypeList(PfLaneTypeVO pfLaneTypeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfLaneTypeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfLaneTypeListVO != null){
				Map<String, String> mapVO = pfLaneTypeListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOPfLaneTypeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfLaneTypeVO .class);
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
	 * Vessel 리스트 정보를 조회합니다.
	 * 
	 * @param VesselVO vesselVO
	 * @return List<VesselVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselVO> searchVslList(VesselVO vesselVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vesselVO != null){
				Map<String, String> mapVO = vesselVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOVesselVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselVO .class);
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
	 * Port에 대한 Yard 정보를 조회합니다.
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<YardVO> searchYardListByPort(YardVO yardVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(yardVO != null){
				Map<String, String> mapVO = yardVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOYardByPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardVO .class);
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
	 * 국가에 대한 Yard 정보를 조회합니다.
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<YardVO> searchYardListByCountry(YardVO yardVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(yardVO != null){
				Map<String, String> mapVO = yardVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchYardListByCountryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardVO .class);
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
	 * MDM에 등록된 Location Code를 확인하거나 조회합니다.
	 * 
	 * @param locationVO LocationVO
	 * @return List<LocationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LocationVO> searchLocationList(LocationVO locationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(locationVO != null){
				Map<String, String> mapVO = locationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchLocationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationVO .class);
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
	 * 입력한 Service Provider에 대한 정보를 조회합니다.
	 * 
	 * @param VendorVO vendorVO
	 * @return List<VendorVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VendorVO> searchVendorList(VendorVO vendorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vendorVO != null){
				Map<String, String> mapVO = vendorVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchVendorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorVO .class);
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
	  * Phase In/Out 사유 정보를 조회합니다.
	  * 
	  * @return List<PhaseInOutReasonVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<PhaseInOutReasonVO> searchPhsInOutRsnList() throws DAOException {
		DBRowSet dbRowset = null;
	 	List<PhaseInOutReasonVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOPhaseInOutReasonRSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, PhaseInOutReasonVO .class);
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
	  * VVD를 검증합니다.
	  * 
	  * @param VvdVO vvdVo
	  * @return List<VvdVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<VvdVO> checkVvd(VvdVO vvdVo) throws DAOException {
		DBRowSet dbRowset = null;
	 	List<VvdVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
	 		if(vvdVo != null){
				Map<String, String> mapVO = vvdVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOCheckVvdRSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdVO.class);
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
	 * Port Code 가 존재하는지 여부를 조회합니다.
	 * 
	 * @param String locCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkPort(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
//			if(VSKGeneralUtil.isNotNull(locCd)){
//				param.put("loc_cd", locCd);
//				velParam.put("loc_cd", locCd);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOCheckPortRSQL(), param, velParam);
//			if(dbRowset != null){
//				if(dbRowset.next()){
//					rtnFlag = dbRowset.getString("FLAG");
//				}
//			}
			
			//locCd가 NULL이면 param, velParam이 비어 있게 되어 java.lang.IllegalArgumentException: SQL parameters must not be null or 0 sized! 이 발생함. 아래 로직으로 수정.
			if(VSKGeneralUtil.isNotNull(locCd)){
				param.put("loc_cd", locCd);
				velParam.put("loc_cd", locCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOCheckPortRSQL(), param, velParam);
				if(dbRowset != null){
					if(dbRowset.next()){
						rtnFlag = dbRowset.getString("FLAG");
					}
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnFlag;
	}
	
	/**
	  * COA SIMULATION INFORMATION Table를 조회한다.
	  * 
	  * @param RqstSimNoVO rqstSimNoVO
	  * @return List<RqstSimNoVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<RqstSimNoVO> searchSimNoListByPfSkd(RqstSimNoVO rqstSimNoVO) throws DAOException {
		DBRowSet dbRowset = null;
	 	List<RqstSimNoVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
	 		if(rqstSimNoVO != null){
				Map<String, String> mapVO = rqstSimNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchSimNoListByPfSkdRSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, RqstSimNoVO.class);
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
	  * Coastal Schedule Simulation 정보를 조회한다.
	  * 
	  * @param RqstSimNoVO rqstSimNoVO
	  * @return List<RqstSimNoVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<RqstSimNoVO> searchSimNoListByCstSkd(RqstSimNoVO rqstSimNoVO) throws DAOException {
		DBRowSet dbRowset = null;
	 	List<RqstSimNoVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
	 		if(rqstSimNoVO != null){
				Map<String, String> mapVO = rqstSimNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchSimNoListByCstSkdRSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, RqstSimNoVO.class);
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
	  * Coastal Schedule Simulation 정보를 조회한다.
	  * 
	  * @param RqstSimNoVO rqstSimNoVO
	  * @return List<RqstSimNoVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<RqstSimNoVO> searchSimNoListByLrskd(RqstSimNoVO rqstSimNoVO) throws DAOException {
		DBRowSet dbRowset = null;
	 	List<RqstSimNoVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
	 		if(rqstSimNoVO != null){
				Map<String, String> mapVO = rqstSimNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchSimNoListByLrskdRSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, RqstSimNoVO.class);
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
	 * Service Lane Direction 정보를 조회합니다.
	 * 
	 * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneDirVO> searchSvcLaneDirList(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneDirVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmVslSvcLaneDirVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneDirVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchSvcLaneDirListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneDirVO .class);
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
	 * 코드 타입, 코드명에 따른 코드 정보 리스트를 조회합니다.
	 * 
	 * @param  CodeInfoVO codeInfoVO
	 * @return List<CodeInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CodeInfoVO> searchCodeInfoList(CodeInfoVO codeInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodeInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(codeInfoVO != null){
				Map<String, String> mapVO = codeInfoVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOCodeInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeInfoVO.class);
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
	 * Yard Code가 입력되였을 경우로써 Yard Code, Description를 조회한다.
	 * 
	 * @param  YardVO yardVO
	 * @return List<YardVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<YardVO> searchYardList(YardVO yardVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = null;

		try{
			if(yardVO != null){
				Map<String, String> mapVO = yardVO.getColumnValues();
				
				param.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchYardListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardVO.class);
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
     * Vosi의 공통코드를 검색한다.
	 * 
     * @param String comCode
     * @return List<VskComboVO>
     * @exception DAOException
     */
    public List<VskComboVO> searchCombo(String comCode) throws DAOException {
        DBRowSet dbRowset = null;
        List<VskComboVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            param.put("cm_code", comCode);
        
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            VskCodeFinderDBDAOOpfComboRSQL template = new VskCodeFinderDBDAOOpfComboRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            
            list = new ArrayList<VskComboVO>();
            
            while(dbRowset.next()){
            	VskComboVO vo = new VskComboVO();
                vo.setComboCd(dbRowset.getString("intg_cd_id"));
                vo.setVal(dbRowset.getString("intg_cd_val_ctnt"));
                vo.setName(dbRowset.getString("intg_cd_val_dp_desc"));
                vo.setDesc(dbRowset.getString("intg_cd_val_desc"));
                list.add(vo);
            }
        }catch(SQLException se){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	
	    
	/**
     * Lane을 검색한다.
     * 
     * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
     * @return List<MdmVslSvcLaneVO>
     * @exception DAOException
     */
	 @SuppressWarnings("unchecked")
    public List<MdmVslSvcLaneVO> searchLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<MdmVslSvcLaneVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}        	

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			VSKCodeFinderDBDAOMdmVslSvcLaneVORSQL template = new VSKCodeFinderDBDAOMdmVslSvcLaneVORSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO.class);
        }catch(SQLException se){
            //log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	/**
	 * MDM Lane 정보를 검증합니다.
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<VskComboVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	//public List<VskPortGntrCrnVO> searchGCraneList(VskPortGntrCrnVO vskPortGntrCrnVO) throws DAOException {
	public List<VskComboVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<VskComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOExistsLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskComboVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
//	/**
//	 * 입력된 Carrier코드를 검색
//	 * 
//	 * @param VskCarrierVO vskCarrierVO
//	 * @return List<OpfComboVO>
//	 * @exception DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	//public List<VskPortGntrCrnVO> searchGCraneList(VskPortGntrCrnVO vskPortGntrCrnVO) throws DAOException {
//	public List<OpfComboVO> checkCarrierVosi(VskCarrierVO vskCarrierVO) throws DAOException { 
//		DBRowSet dbRowset = null;
//		List<OpfComboVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(vskCarrierVO != null){
//				Map<String, String> mapVO = vskCarrierVO.getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOExistsCarrierVORSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}
	 
	 /**
		 * Delay Reason 을 조회합니다.
		 * 
		 * @return List<DelayReasonVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
	    public List<DelayReasonVO> searchDlayRsnList() throws DAOException {
	    	DBRowSet dbRowset = null;
		 	List<DelayReasonVO> list = null;
		 	//query parameter
		 	Map<String, Object> param = new HashMap<String, Object>();
		 	//velocity parameter
		 	Map<String, Object> velParam = new HashMap<String, Object>();

		 	try{
		 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchDlayRsnListRSQL(), param, velParam);
		 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, DelayReasonVO .class);
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
	 * Vsl Class를 조회한다.
	 * 
	 * @return List<MdmVslCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<MdmVslCntrVO> searchVslClsList() throws DAOException {
    	DBRowSet dbRowset = null;
	 	List<MdmVslCntrVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	//Map<String, Object> velParam = null;

	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchVslClsListRSQL(), param, null);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO .class);
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
	 * VSL_DZND_CAPA를 조회한다.  
	 * 
	 * @return List<MdmVslCntrVO>
	 * @exception DAOException
	 */  
	@SuppressWarnings("unchecked")
    public List<MdmVslCntrVO> searchVslDznCapaList() throws DAOException {
    	DBRowSet dbRowset = null;
	 	List<MdmVslCntrVO> list = null;
	 	//query parameter
	 	//Map<String, Object> param = null;
	 	//velocity parameter
	 	//Map<String, Object> velParam = null;

	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchVslDznCapaListRSQL(), null, null);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO .class);
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
	 * VVD가 지나는 Port 리스트를 조회합니다.
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VskComboVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	//::FOR.NYK.START::by TOP:2014-09-10:://
	public List<VskComboVO> searchPort(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskComboVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	//::FOR.NYK.FINISH::by TOP:2014-09-10:://
	
	 //::FOR.NYK.START::by TOP:2014-19-16:://
	/**
	 * ACTUAL SKD 입력시 GMT 기준으로 이전포트의 ETD와 입력포트 ATA역전관계 체크<br>
	 * 
	 * @param DateTimeConvVO dDateTimeConvVO
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public String searchActPreDateEqual(DateTimeConvVO dDateTimeConvVO) throws DAOException {
		
		DBRowSet 			dbRowset 	= null;
		String actStatus = "";
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		try{
			if(dDateTimeConvVO != null){
				Map<String, String> mapVO = dDateTimeConvVO .getColumnValues();
			
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchActPreDateEqualRSQL(), param, velParam);

			if (dbRowset.next()) {
				actStatus = dbRowset.getString("act_skd_reverse_indicator");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return actStatus;
	}
	//::FOR.NYK.FINISH::by TOP:2014-19-16:://
	
	/**
	 * VVD가 지나는 Port 리스트를 조회합니다.
	 * 
	 * @param VesselVO vslVo
	 * @return List<VesselVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	//::FOR.NYK.START::by TOP:2014-09-10:://
	public List<VesselVO> searchVslCd(VesselVO vslVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslVo != null){
				Map<String, String> mapVO = vslVo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOGetVslCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VesselVO .class);
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
	 * MDM에 등록된 Location Code를 확인하거나 조회합니다.
	 * 
	 * @param locationVO LocationVO
	 * @return GET<LocationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LocationVO> searchLocation(LocationVO locationVO) throws DAOException {
		DBRowSet dbRowset     = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(locationVO != null){
				Map<String, String> mapVO = locationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchLocationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
		//::FOR.NYK.START::by KJH:2014-11-24:://
		/**
		 * 
		 * 
		 * @param VvdVO vvdVO
		 * @return String 
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
	    public String sendRevenueVVD(VvdVO vvdVO) throws DAOException {
			
			DBRowSet 			dbRowset 	= null;
			String result = "";
			//query parameter
			Map<String, Object> param 		= new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam 	= new HashMap<String, Object>();

			try{
				if(vvdVO != null){
					Map<String, String> mapVO = vvdVO.getColumnValues();
				
					param.putAll	(mapVO);
					velParam.putAll	(mapVO);
				}
				dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchActPreDateEqualRSQL(), param, velParam);

				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}

		
	/**
	  * PORT LIST 조회합니다.
	  * 
	  * @param Map<String, String> mapVO
	  * @return List<VvdPortLaneOtherVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<VvdPortLaneOtherVO> searchPortList(Map<String, String> mapVO) throws DAOException{
		 DBRowSet dbRowset = null;
		 List<VvdPortLaneOtherVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 
			 param.putAll( mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchPortListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdPortLaneOtherVO.class);
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
	 * Select proper VVD in candidate
	 * 
	 * @param EffectiveVvdVO effectiveVvdVO
	 * @return List<EffectiveVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EffectiveVvdVO> searchProperVVDinCandidate(EffectiveVvdVO effectiveVvdVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<EffectiveVvdVO>	list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			
			if(effectiveVvdVO != null){
				Map<String, String> mapVO 	= effectiveVvdVO.getColumnValues();
			
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOIdentifyProperVVDinCandidateRSQL(), param, velParam);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, EffectiveVvdVO.class);
			
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
	 * Select proper VVD in candidate
	 * 
	 * @param EffectiveVvdVO effectiveVvdVO
	 * @return List<EffectiveVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EffectiveVvdVO> searchProperVVDinPortCandidate(EffectiveVvdVO effectiveVvdVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<EffectiveVvdVO>	list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			
			if(effectiveVvdVO != null){
				Map<String, String> mapVO 	= effectiveVvdVO.getColumnValues();
			
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOIdentifyProperVVDinPortCandidateRSQL(), param, velParam);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, EffectiveVvdVO.class);
			
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
	 * Select proper VVD in candidate
	 * 
	 * @param EffectiveVvdVO effectiveVvdVO
	 * @return List<EffectiveVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EffectiveVvdVO> searchProperVVDinPolPodCandidate(EffectiveVvdVO effectiveVvdVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<EffectiveVvdVO>	list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			
			if(effectiveVvdVO != null){
				Map<String, String> mapVO 	= effectiveVvdVO.getColumnValues();
			
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOIdentifyProperVVDinPolPodCandidateRSQL(), param, velParam);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, EffectiveVvdVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
}
