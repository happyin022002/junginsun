/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EASCommonDBDAO.java
*@FileTitle : EAS_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-05-13 Jong-Ock Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eascommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.eascommon.basic.EASCommonBCImpl;
import com.hanjin.apps.alps.esd.eas.eascommon.vo.EasCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.MdmYardVO;


/**
 * ALPS EASCommonDBDAO <br>
 * - ALPS-EASCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jong-Ock Kim
 * @see EASCommonBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EASCommonDBDAO extends DBDAOSupport {
 
	/**
	 * Yard에 Loc_cd 해당하는 Nod_code 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<EasCommonVO> getYardLocCdNodCdList(EasCommonVO easCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EasCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (easCommonVO != null) {
				Map<String, String> mapVO = easCommonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EASCommonDBDAOYardLocCdNodCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 공통 : Yard에 기항하는 Lane 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<EasCommonVO> getYardByLaneList(EasCommonVO easCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EasCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (easCommonVO != null) {
				Map<String, String> mapVO = easCommonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EASCommonDBDAOYardByLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 공통 : Vessel Class에 기항하는 Vessel 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<EasCommonVO> getVesselClassByVesselList(EasCommonVO easCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EasCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if (easCommonVO != null) {
				String[] capaArr = easCommonVO.getCntrVslClssCapa().split("[|]");
				param.put("from_cntr_vsl_clss_capa", capaArr[0]);
				param.put("to_cntr_vsl_clss_capa", capaArr[1]);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EASCommonDBDAOVesselClassByVesselRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasCommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 공통 : Yard 조회<br>
	 *
	 * @param MdmYardVO mdmYardVO
	 * @return List<MdmYardVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmYardVO> getYardNameList(MdmYardVO mdmYardVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (mdmYardVO != null) {
				Map<String, String> mapVO = mdmYardVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EASCommonDBDAOYardNameRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * 공통 : Yard 조회<br>
	 *
	 * @param MdmVendorVO mdmVendorVO
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVendorVO> getVendorNameList(MdmVendorVO mdmVendorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVendorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (mdmVendorVO != null) {
				Map<String, String> mapVO = mdmVendorVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EASCommonDBDAOVendorNameRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVendorVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}