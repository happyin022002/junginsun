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
 * 2009.08.03 NohSeungBae alps f/w 로 구조 변경
 * 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ValidationVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * alps-PRD에 대한 DB 처리를 담당<br>
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jungsunyoung
 * @see PrdCommonManageBCImpl 참조
 * @since J2EE 1.4
 */
public class PrdCommonManageDBDAO extends DBDAOSupport{

	/**
	 * PrdCommonManageDBDAO's validationPort
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationPort(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();

			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationPortRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's validationLoc
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationLocation(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationLocationRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's validationNode
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationNode(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationNodeRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's validationTml
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationTerminal(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		// query parameter
		// Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		// Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();

				// param.putAll(mapVO);
				// velParam.putAll(mapVO);
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationTerminalRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's validationCnt
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationCountry(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationCountryRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's searchCarrierCode
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List searchCarrierCode(ValidationVO vo) throws DAOException{
		List<PickupReturnCYVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, PickupReturnCYVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's searchContinentList
	 * @return
	 * @throws DAOException
	 */
	public List searchContinentList() throws DAOException{
		List<ContinentVO> list = null;
		Map mapVO = new HashMap();

		try{
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, ContinentVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's searchSubContinentList
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List searchSubContinent(ContinentVO vo) throws DAOException{
		List<ContinentVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PrdCommonManageDBDAOSearchSubContinentRSQL(), mapVO, mapVO, ContinentVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's validationLane
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<ValidationVO> validationLane(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationLaneRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
	/**
	 * PrdCommonManageDBDAO's searchContinentCode
	 * @param ValidationVO vo
	 * @return List<ValidationVO>
	 * @throws DAOException
	 */
	public List<ValidationVO> searchContinentCode(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOsearchContinentCodeRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's validationFdrLane
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationFdrLane(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationFdrLaneRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's validationCallingTmlMtxLane
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationCallingTmlMtxLane(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationCallingTmlMtxLaneRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's validationVendor
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationVendor(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationVendorRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's createPrdCtlNoGen
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List createPrdCtlNoGen(ValidationVO vo) throws DAOException{
		List<PickupReturnCYVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, PickupReturnCYVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's totalServiceProvider
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List totalServiceProvider(ValidationVO vo) throws DAOException{
		List<PickupReturnCYVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, PickupReturnCYVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's searchServiceProviderList
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<ServiceProviderVO> searchServiceProviderList(ServiceProviderVO vo) throws DAOException{
		List<ServiceProviderVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOServiceProviderRSQL(), mapVO, mapVO, ServiceProviderVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's getRowSetPrdPgmRole
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List getRowSetPrdPgmRole(ValidationVO vo) throws DAOException{
		List<PickupReturnCYVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOSearchContinentRSQL(), mapVO, mapVO, PickupReturnCYVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PrdCommonManageDBDAO's getPrdPgmRole
	 * @param pgmId
	 * @param usrId
	 * @return
	 * @throws DAOException DBRowSet
	 */	
	public String getPrdPgmRole(String pgmId, String usrId) throws DAOException {

 		DBRowSet dbRowset = null;
		String retCrud = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
        try {
			param.put("pgm_no", pgmId);
			param.put("usr_id", usrId);
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PrdCommonManageDBDAOSearchPrdPgmRoleRSQL(), param, null);
			if(dbRowset.next()) {
				retCrud = dbRowset.getString("CRUD");
			}
        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retCrud;
	}

	/**
	 * PrdCommonManageDBDAO's validationCallingTmlMtxTmlCd
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List validationCallingTmlMtxTmlCd(ValidationVO vo) throws DAOException{
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOvalidationCallingTmlMtxTmlCdRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * InlandRouteManageDBDAO's isDoorTml
	 * @param check_data
	 * @return
	 * @throws DAOException
	 * ★2009-08-14 kim kwijin 수정
	 */
	public boolean isDoorTerminal(String check_data) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, String> mapVO = new HashMap();
		boolean isDoor = false;
		try{
			mapVO.put("check_data", check_data);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOIsDoorTmlRSQL(), mapVO, null);
			if(dbRowset.next()){
				if(dbRowset.getString("nod_tp_cd").equals("Z")){
					isDoor = true;
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isDoor;
	}

	/**
	 * @param pgmId
	 * @param usrId
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet getRowSetPrdPgmRole(String pgmId, String usrId) throws DAOException{
 		DBRowSet dbRowset = null;
//		String retCrud = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
        try {
			param.put("pgm_no", pgmId);
			param.put("usr_id", usrId);
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PrdCommonManageDBDAOSearchPrdPgmRoleRSQL(), param, null);

        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return dbRowset;
	}
	
	/**
	 * @param contiCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchCntOfConti(String contiCd) throws DAOException{
 		DBRowSet dbRowset = null;
		String cnt_cd[] = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
        try {
			param.put("conti_cd", contiCd);
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PrdCommonManageDBDAOSearchCntOfContiRSQL(), param, null);

 			if ( dbRowset!=null ){
 				while(dbRowset.next()) {
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
	 * 
	 * @param ValidationVO vo
	 * @return List
	 * @throws DAOException
	 */
	public List validationLaneVvd(ValidationVO vo) throws DAOException {
		List<ValidationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();

			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCommonManageDBDAOValidationLaneVvdRSQL(), mapVO, mapVO, ValidationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
