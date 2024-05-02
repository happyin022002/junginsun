/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonDBDAO.java
*@FileTitle : ETC LesCommon Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
* 2014-02-19 채창호 [CHM-201428698-01] Split 01-계약 종료 Notice건 개발
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.basic.LseCommonBCImpl;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration.MSTCommonDBDAOSearchLessorCodeDataRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * ALPS LseCommonDBDAO <br>
 * - ALPS-LseCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jang Jun-Woo
 * @see LseCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class LseCommonDBDAO extends DBDAOSupport {

	/**
	 * Location - Port 코드목록을 조회합니다.<br>
	 *
	 * @param  String locCd
	 * @return List<MdmLocationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmLocationVO> searchLocationPortData(String locCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchLocationPortRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO.class);
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
	 * Vessel SKD 목록을 조회합니다.<br>
	 *
	 * @param  String vvdCd
	 * @return List<VskVslPortSkdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchVesselSkdData(String vvdCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("vvd_cd", vvdCd);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchVesselSkdRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);
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
	 * 컨테이너 정보 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return List<MstContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MstContainerVO> searchContainerInfoBrieflyData(String cntrNo) throws DAOException {

		DBRowSet dbRowset = null;
		List<MstContainerVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchContainerInfoRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstContainerVO.class);
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
	 * Office 코드목록을 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmOrganizationVO> searchOfficeCodeData(String ofcCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchOfficeCodeRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO.class);
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
	 * Vessel SVC Lane 목록을 조회합니다.<br>
	 *
	 * @param  String slanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchServiceLaneData(String slanCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("slan_cd", slanCd);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchServiceLaneRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO.class);
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
	 * Agreement No 존재하는 체크를 합니다 (Notice 에서 사용).<br>
	 * 
	 * @param String agmtNo
	 * @return String
	 * @throws DAOException
	 */
 	public String searchLessorCodeCtrtNtcInfo(String agmtNo) throws DAOException {
		DBRowSet dbRowset = null;
		String agmt_nm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{			
			if (agmtNo != null) {
				param.put("agmt_no", agmtNo);
			    velParam.put("agmt_no", agmtNo);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LseCommonDBDAOSearchLessorCodeCtrtNtcInfoRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		agmt_nm = dbRowset.getString("AGMT_NO");
	    	}			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return agmt_nm;
 	}
}