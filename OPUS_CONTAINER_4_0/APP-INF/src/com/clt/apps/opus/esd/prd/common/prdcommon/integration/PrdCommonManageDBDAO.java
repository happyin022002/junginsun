/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageDBDAO.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
 * 2009.04.21 권한 설정
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.YardVO;
import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.ZoneVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ContinentVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.SearchComIntgCdDtlVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ValidationVO;
import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jungsunyoung
 * @see PrdCommonManageBCImpl 참조
 * @since J2EE 1.4
 */
public class PrdCommonManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * PrdCommonManageDBDAO's validationPort
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationPort(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationPortRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's validationLoc
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationLocation(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationLocationRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's validationNode
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationNode(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationNodeRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's validationTml
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationTerminal(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationTerminalRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's validationCnt
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationCountry(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationCountryRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's searchCarrierCode
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List searchCarrierCode(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, PickupReturnCYVO.class);
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
	 * PrdCommonManageDBDAO's searchContinentList
	 * 
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List searchContinentList() throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, ContinentVO.class);
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
	 * retrieving Continent List
	 * 
	 * @param ValidationVO vo
	 * @return boolean
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public boolean isFullCargoCutOffInThePast(ValidationVO vo) throws DAOException {
		
		DBRowSet dbRowset 		= null;
		List<ValidationVO> list = null;
		boolean	isInThePast		= false;
		
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			if (vo != null) {
				mapVO.putAll(vo.getColumnValues());
			}
			
			dbRowset	= new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOIsFullCargoCuttOffInThePastRSQL(), mapVO, null);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, ValidationVO.class);
			if(list != null && list.size()>0){
				if("Y".equals(list.get(0).getIsInThePast())){
					isInThePast	= true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isInThePast;
	}

	/**
	 * PrdCommonManageDBDAO's searchSubContinentList
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List searchSubContinent(ContinentVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchSubContinentRSQL(), mapVO, mapVO, ContinentVO.class);
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
	 * PrdCommonManageDBDAO's validationLane
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ValidationVO> validationLane(ValidationVO vo) throws DAOException {
		List<ValidationVO> list = new ArrayList<ValidationVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationLaneRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's validationFdrLane
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationFdrLane(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationFdrLaneRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's validationCallingTmlMtxLane
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationCallingTmlMtxLane(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationCallingTmlMtxLaneRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's validationVendor
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationVendor(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationVendorRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * PrdCommonManageDBDAO's createPrdCtlNoGen
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List createPrdCtlNoGen(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, PickupReturnCYVO.class);
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
	 * PrdCommonManageDBDAO's totalServiceProvider
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List totalServiceProvider(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, PickupReturnCYVO.class);
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
	 * PrdCommonManageDBDAO's searchServiceProviderList
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ServiceProviderVO> searchServiceProviderList(ServiceProviderVO vo) throws DAOException {
		List<ServiceProviderVO> list = new ArrayList<ServiceProviderVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOServiceProviderRSQL(), mapVO, mapVO, ServiceProviderVO.class);
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
	 * PrdCommonManageDBDAO's validationCallingTmlMtxTmlCd
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List validationCallingTmlMtxTmlCd(ValidationVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOvalidationCallingTmlMtxTmlCdRSQL(), mapVO, mapVO, ValidationVO.class);
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
	 * InlandRouteManageDBDAO's isDoorTml
	 * 
	 * @param check_data
	 * @return
	 * @throws DAOException ★2009-08-14 kim kwijin 수정
	 */
	public boolean isDoorTerminal(String check_data) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, String> mapVO = new HashMap<String, String>();
		boolean isDoor = false;
		try {
			mapVO.put("check_data", check_data);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOIsDoorTmlRSQL(), mapVO, null);
			if (dbRowset.next()) {
				if (dbRowset.getString("nod_tp_cd").equals("Z")) {
					isDoor = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isDoor;
	}

	/**
	 * 기존 데이타 유무 확인 ★2009-10-05 kim kwijin수정
	 * 
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean isPrdNode(String pk) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isSuccessful = false;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pk", pk);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOIsPrdNodeRSQL(), param, null);
			if (dbRowset.getRowCount() <= 0)
				isSuccessful = true;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return isSuccessful;
	}

	/**
	 * insert (prd_node table) ★2009-10-05 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int createPrdNode(YardVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCommonManageDBDAOCreatePrdNodeByYardCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * update (prd_node table) ★2009-10-05 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdNode(YardVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCommonManageDBDAOUpdatePrdNodeByYardUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * DELETE PRD_NODE ★2009-10-05 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int removePrdNode(YardVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCommonManageDBDAODeletePrdNodeByYardUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * insert (prd_node table) ★2009-10-05 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int createPrdNode(ZoneVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new PrdCommonManageDBDAOCreatePrdNodeByZoneCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * update (prd_node table) ★2009-10-05 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdNode(ZoneVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new PrdCommonManageDBDAOUpdatePrdNodeByZoneUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * DELETE PRD_NODE ★2009-10-05 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int removePrdNode(ZoneVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new PrdCommonManageDBDAODeletePrdNodeByZoneUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * @param contiCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchCntOfConti(String contiCd) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt_cd[] = null;
		List<String> list = new ArrayList<String>();
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("conti_cd", contiCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchCntOfContiRSQL(), param, null);
			if (dbRowset != null) {
				while (dbRowset.next()) {
					list.add(dbRowset.getString(1));
				}
			}
			cnt_cd = list.toArray(new String[0]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt_cd;
	}

	/**
	 * searchComIntgCdDtl
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List searchComIntgCdDtl(ComIntgCdDtlVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
				list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchComIntgCdDtlRSQL(), mapVO, mapVO, SearchComIntgCdDtlVO.class);
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
