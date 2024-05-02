/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DeliveryLocationDBDAO.java
*@FileTitle : Delivery Location Briefly Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.06 노정용
* 1.0 Creation
* 2015-07-08 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.dlvrloc.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmEqOrzChtVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmYardVO;

/**
 * ALPS DeliveryLocationDBDAO <br>
 * - ALPS-Delivery Location 조회를 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Nho Jung Yong
 * @see DeliveryLocationBCImpl 참조
 * @since J2EE 1.4
 */
public class DeliveryLocationDBDAO extends DBDAOSupport {

	/**
	 * Delivery Location 코드목록을 조회합니다.<br>
	 *
	 * @param String locCd
	 * @return List<MdmLocationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmLocationVO> searchDeliveryLocationBrieflyData(String locCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DeliveryLocationDBDAODeliveryLocationBrieflyRSQL(), param, param);
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
	 * 유형별 Delivery Location 코드목록을 조회합니다.<br>
	 *
	 * @param String locCd
	 * @param String locTp
	 * @return List<MdmEqOrzChtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmEqOrzChtVO> searchLocationBrieflyData(String locCd, String locTp) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmEqOrzChtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
    	try{
			if ( locTp.equals("SCC") ) {
				param.put("scc_cd", locCd);
				velParam.put("scc_cd", locCd);
			} else if ( locTp.equals("LCC") ) {
				param.put("lcc_cd", locCd);
				velParam.put("lcc_cd", locCd);
			} else if ( locTp.equals("RCC") ) {
				param.put("rcc_cd", locCd);
				velParam.put("rcc_cd", locCd);
			} else if ( locTp.equals("ECC") ) {
				param.put("ecc_cd", locCd);
				velParam.put("ecc_cd", locCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DeliveryLocationDBDAOLocationRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmEqOrzChtVO.class);
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
	 * Delivery Location - RCC 코드목록을 조회합니다.<br>
	 *
	 * @return List<MdmEqOrzChtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmEqOrzChtVO> searchDeliveryLocationRCCListData() throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmEqOrzChtVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DeliveryLocationDBDAOLocationRccListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmEqOrzChtVO.class);
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
	 * Delivery Location - Country 코드목록을 조회합니다.<br>
	 *
	 * @param String locCd
	 * @return List<MdmLocationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmLocationVO> searchDeliveryLocationCountryData(String locCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DeliveryLocationDBDAOSearchCountryRSQL(), param, param);
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
	 * Delivery Location - Off-Hire Yard 코드목록을 조회합니다.<br>
	 *
	 * @param String ydCd
	 * @return List<MdmYardVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmYardVO> searchOffHireYardListData(String ydCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmYardVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DeliveryLocationDBDAOOffHireYardRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardVO.class);
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