/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BDRSettingDBDAO.java
 *@FileTitle : BDRSettingDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.30
 *@LastModifier : 이일민
 *@LastVersion : 1.0
 * 2009.10.30 이일민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bdrbookinginterface.bdrbookinginterface.vo.BdrBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.bdrbookinginterface.bdrbookinginterface.vo.BdrVvdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 BDRSettingDBDAO <br>
 * - NIS2010-BDRBookingInterface system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ilmin Lee
 * @see BDRBookingInterfaceBCImpl 참조
 * @since J2EE 1.4
 */
public class BDRSettingDBDAO extends DBDAOSupport {

	/**
	 * 전송대상 VVD 목록을 조회한다.
	 * 	
	 * @return List<BdrVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BdrVvdVO> searchBdrVvdList() throws DAOException {
		DBRowSet dbRowset = null;
		List<BdrVvdVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BDRSettingDBDAOsearchBdrVvdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BdrVvdVO.class);
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 전송대상 VVD 목록을 조회한다.(test)
	 * 	
	 * @return List<BdrVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BdrVvdVO> searchBdrVvdListTest() throws DAOException {
		DBRowSet dbRowset = null;
		List<BdrVvdVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BDRSettingDBDAOsearchBdrVvdListTestRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BdrVvdVO.class);
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 전송대상 BKG NO 목록을 조회한다.
	 * 
	 * @param BdrVvdVO bdrVvd
	 * @return List<BdrBkgNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BdrBkgNoVO> searchBdrBkgNoList(BdrVvdVO bdrVvd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BdrBkgNoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=bdrVvd) {
				Map<String,String> mapVO = bdrVvd.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BDRSettingDBDAOsearchBdrBkgNoListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BdrBkgNoVO.class);
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * updateBdrFlg
	 * 
	 * @param BdrVvdVO bdrVvdVO
	 * @throws DAOException
	 */
	public void updateBdrFlg(BdrVvdVO bdrVvdVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bdrVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new BDRSettingDBDAOupdateBdrFlgUSQL(), param, velParam);
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * updateBlDoc
	 * 
	 * @param BdrBkgNoVO bdrBkgNoVO
	 * @throws DAOException
	 */
	public void updateBlDoc(BdrBkgNoVO bdrBkgNoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bdrBkgNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new BDRSettingDBDAOupdateBlDocUSQL(), param, velParam);
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
