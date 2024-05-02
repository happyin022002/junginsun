/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderDAO.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.29 서창열
* 1.0 Creation
* 
* History
* 2011.03.25 진마리아 CHM-201109579-01 Lane Code의 Direction 조회 칼럼 추가 요청
* 2011.06.27 진마리아 CHM-201111838-01 소스품질 결함수정 - 객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
* 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경. 조회 조건 Port및 Terminal, Calling Seq, 입력칼럼을 Select Box로 변경 / ATA,ATB,ATD 별 Remark 칼럼 추가 / Delay Time을 Hrs로 로직 변경
* 2011.10.11 진마리아 CHM-201112822-01 Lane Code inquiry내 trade 및 Sub trade, SKD 로 lane Code 정보를 조회 가능하도록 로직 수정
* 2011.10.11 진마리아 CHM-201112898-01 Port Code Inquiry 조회 조건 추가 - Conti, Sconti, lat, long, period 등
* 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 및 paging처리
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.DelayReasonVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LaneDirVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.SearchDateVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VslSvcLaneforBudgetVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;


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
		 * Service Lane (for BUDGET)리스트를 조회합니다.
		 * 
		 * @param VslSvcLaneforBudgetVO vslSvcLaneforBudgetVO
		 * @return List<VslSvcLaneforBudgetVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<VslSvcLaneforBudgetVO> searchSvcLaneforBudgetList(VslSvcLaneforBudgetVO vslSvcLaneforBudgetVO) throws DAOException {
			 
			DBRowSet 						dbRowset 	= null;
			List<VslSvcLaneforBudgetVO> 	list 		= null;
			//query parameter
			Map<String, Object> 			param 		= new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> 			velParam 	= new HashMap<String, Object>();

			try{
				if(vslSvcLaneforBudgetVO != null){
					Map<String, String> mapVO = vslSvcLaneforBudgetVO .getColumnValues();
				
					param.putAll	(mapVO);
					velParam.putAll	(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSelectVslSlanforBudgetListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSvcLaneforBudgetVO .class);
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
	 
	 /**
		 * RHQ산하에 있는 Control Office Code 정보를 조회합니다.
		 * 
		 * @param String rhqCd
		 * @return List<LocationVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<LocationVO> searchSlsOfficeList(String rhqCd) throws DAOException {
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
//					param.put("vop_port_rhq_cd", rhqCd);
//					velParam.put("vop_port_rhq_cd", rhqCd);
					param.put("vskd_port_rhq_cd", rhqCd);
					velParam.put("vskd_port_rhq_cd", rhqCd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchSlsOfficeListRSQL(), param, velParam);
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
//		Map<String, Object> velParam = null;

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
//	 	Map<String, Object> param = null;
	 	//velocity parameter
//	 	Map<String, Object> velParam = null;

	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchVslClsListRSQL(), null, null);
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
//	 	Map<String, Object> param = null;
	 	//velocity parameter
//	 	Map<String, Object> velParam = null;

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
	 * Service Lane 리스트를 조회합니다.
	 * 
	 * @param LaneDirVO laneDirVO
	 * @return List<LaneDirVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LaneDirVO> searchLaneDirList(LaneDirVO laneDirVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LaneDirVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(laneDirVO != null){
				Map<String, String> mapVO = laneDirVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOsearchLaneDirListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LaneDirVO .class);
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
		 
	 /**
	 * Trade 정보를 조회합니다.
	 * 
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchTradeList() throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrTrd = null;
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchTradeListRSQL(), null, null);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrTrd = new String[dbRowset.getRowCount()];
				}
				arrTrd[i] = dbRowset.getString(1);
				i++;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrTrd;
	}
		 
	 /**
	 * Sub Trade 정보를 조회합니다.
	 * 
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchSubTradeList() throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrSubTrd = null;
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchSubTradeListRSQL(), null, null);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrSubTrd = new String[dbRowset.getRowCount()];
				}
				arrSubTrd[i] = dbRowset.getString(1);
				i++;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrSubTrd;
	}
			 
	 /**
	 * Conti 정보를 조회합니다.
	 * 
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchContiList() throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrConti = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchContiListRSQL(), null, null);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrConti = new String[dbRowset.getRowCount()];
				}
				arrConti[i] = dbRowset.getString(1);
				i++;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrConti;
	}
	 
	 /**
	 * Sconti 정보를 조회합니다.
	 * 
	 * @param String contiCd
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchScontiList(String contiCd) throws DAOException {
		 //query parameter
	     Map<String, Object> param = new HashMap<String, Object>();
	     //velocity parameter
	     Map<String, Object> velParam = new HashMap<String, Object>();
		 DBRowSet dbRowset = null;
		 String[] arrSconti = null;
		
		 try{
			 param.put("conti_cd", contiCd);
			 velParam.put("conti_cd", contiCd);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchScontiListRSQL(), param, velParam);
			 int i = 0;
			 while (dbRowset.next()) {
				 if (i == 0) {
					 arrSconti = new String[dbRowset.getRowCount()];
				 }
				 arrSconti[i] = dbRowset.getString(1);
				 i++;
			 }
		 }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return arrSconti;
	}
	 
	/**
	 * MDM에서 Port Code Inquiry 에서의 Port 정보를 조회합니다.
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LocationVO> searchPortInfoList(LocationVO locationVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchPortInfoListRSQL(), param, velParam);
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
	 * Vessel 리스트 정보를 조회합니다.(0044 vessel code inquiry)
	 * 
	 * @param VesselVO vesselVO
	 * @return List<VesselVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselVO> searchVesselListByCode(VesselVO vesselVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchVesselListByCodeRSQL(), param, velParam);
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
	 * 사용자가 입력한 Month/Week에 해당하는 날짜를 조회합니다.(0021 port sked inquiry)
	 * 
	 * @param SearchDateVO paramVO
	 * @return List<SearchDateVO>
	 * @exception DAOException
	 */
	public List<SearchDateVO> searchDate(SearchDateVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDateVO .class);
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
	 * RHQ산하에 있는 Yard Control Office Code 정보를 조회합니다.
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LocationVO> searchYardCtrlOfficeList(String rhqCd) throws DAOException {

		 DBRowSet dbRowset = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rhqCd != null){
				param.put("vskd_port_rhq_cd", rhqCd);
				velParam.put("vskd_port_rhq_cd", rhqCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchYardCtrlOfficeListRSQL(), param, velParam);
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
		 * 특정 Location Local Time을 변경대상 Location Local time으로 변환된 값을 추출한다.
		 * 
		 * @param String sFmLocCd
		 * @param String sToLocCd
		 * @param String sDateFormat
		 * @return String
		 * @exception DAOException
		 */
		public String getTimeConvFmLocToLoc(String sFmLocCd, String sToLocCd, String sDateFormat) throws DAOException {
			 
			//SELECT  GLOBALDATE_PKG.TIME_CONV_FNC(v_fr_loc_cd => ,v_fr_loc_time => ,v_to_loc_cd => )//

			DBRowSet 	dbRowset 	= null;
			String		sRtnValue	= null;
			//query parameter
			Map<String, Object> param 		= new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam 	= new HashMap<String, Object>();

			try{
				if(sFmLocCd != null && sToLocCd != null && sDateFormat != null){
					param.put	("fm_loc_cd"	, sFmLocCd		);
					param.put	("to_loc_cd"	, sToLocCd		);
					param.put	("date_format"	, sDateFormat	);
					velParam.put("fm_loc_cd"	, sFmLocCd		);
					velParam.put("to_loc_cd"	, sToLocCd		);
					velParam.put("date_format"	, sDateFormat	);					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDAOSearchTimeConvFmLocToLocRSQL(), param, velParam);
				if(dbRowset.next()){
					sRtnValue	=  dbRowset.getString("CONV_TIME");
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return sRtnValue;
		}	 
		 

			/**
			 * 특정 Vessel Service Lane의 Proforma 데이터중 direction+port 조합으로 데이터 추출한다.
			 * 
			 * @param String sVslSlanCd
			 * @return List<VskVslPortSkdVO>
			 * @exception DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<VskVslPortSkdVO> searchSkdDirPortCdforProformaList(String sVslSlanCd) throws DAOException {

				DBRowSet 				dbRowset 	= null;
				List<VskVslPortSkdVO> 	list 		= null;
				//query parameter
				Map<String, Object> 	param 		= new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> 	velParam 	= new HashMap<String, Object>();

				try{
					if(sVslSlanCd != null){
						param.put	("vsl_slan_cd", sVslSlanCd);
						velParam.put("vsl_slan_cd", sVslSlanCd);
					}
					dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchSkdDirPortCdforProformaListRSQL(), param, velParam);
					list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);
					
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
				 * 특정User의 Email Address 추출
				 * 
				 * @param String sUserId
				 * @return String
				 * @exception DAOException
				 */
				public String searchUserEmail(String sUserId) throws DAOException {

					DBRowSet 				dbRowset 	= null;
					String					sRtnValue	= "";
					//query parameter
					Map<String, Object> 	param 		= new HashMap<String, Object>();

					try{
						if(sUserId != null){
							param.put	("usr_id", sUserId);
						}
						dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VSKCodeFinderDBDAOSearchUserEmailRSQL(), param, null);
						if(dbRowset.next()) {
							sRtnValue	= dbRowset.getString("USR_EML") == null ? "" : dbRowset.getString("USR_EML");
						}
						
					}catch(SQLException se){
						log.error(se.getMessage(),se);
						throw new DAOException(new ErrorHandler(se).getMessage());
					}catch(Exception ex){
						log.error(ex.getMessage(),ex);
						throw new DAOException(new ErrorHandler(ex).getMessage());
					}
					return sRtnValue;
				}			 
			 
		 
}
