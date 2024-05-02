/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0497
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlChargeTotalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlChargeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlGeneralVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlMarksDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchContainerDangerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchContainerDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchEstimateDtVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchMsgHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchSubMsgHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchVesselVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS TaiwanCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LIM JAE TAEK
 * @see TaiwanCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class TaiwanCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 대만세관 신고용 Manifest Vessel 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchVesselVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchVesselVO> searchVessel( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchVesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchVesselRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchVesselVO.class);
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
	 * 대만세관 신고용 Manifest Estimated Date 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchEstimateDtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchEstimateDtVO> searchEstimateDt( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchEstimateDtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchEstimateDtRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchEstimateDtVO.class);
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
	 * 대만세관 신고용 Manifest B/L General 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchBlGeneralVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchBlGeneralVO> searchBlGeneral(TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchBlGeneralVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchBlGeneralRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchBlGeneralVO.class);
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
	 * 대만세관 신고용 Manifest B/L Charge 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchBlChargeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchBlChargeVO> searchBlCharge( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchBlChargeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchBlChargeRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchBlChargeVO.class);
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
	 * 대만세관 신고용 Manifest B/L Charge Total 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchBlChargeTotalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchBlChargeTotalVO> searchBlChargeTotal( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchBlChargeTotalVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchBlChargeTotalRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchBlChargeTotalVO.class);
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
	 * 대만세관 신고용 Manifest B/L Marks, Description 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchBlMarksDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchBlMarksDescVO> searchBlMarkDesc( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchBlMarksDescVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchBlMarksDescRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchBlMarksDescVO.class);
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
	 * 대만세관 신고용 Manifest Container 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchContainerVO> searchContainer( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchContainerRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchContainerVO.class);
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
	 * 대만세관 신고용 Manifest Container Danger 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchContainerDangerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchContainerDangerVO> searchContainerDanger( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchContainerDangerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchContainerDangerRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchContainerDangerVO.class);
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
	 * 대만세관 신고용 Manifest Container Description 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchContainerDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchContainerDescVO> searchContainerDesc( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchContainerDescVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchContainerDescVO.class);
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
	 * 대만세관 신고용 Manifest B/L Qty 정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchBlQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchBlQtyVO> searchBlQty( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchBlQtyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchBlQtyRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchBlQtyVO.class);
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
	 * 대만세관 신고용 Manifest B/L VVD정보를 조회한다.
	 * @param taiwanManifestTransmitVO
	 * @return List<TaiwanSearchBlVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchBlVvdVO> searchBlVvd( 
			TaiwanManifestTransmitVO taiwanManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchBlVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (taiwanManifestTransmitVO != null) {
				Map<String, String> mapVO = taiwanManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchBlVvdRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchBlVvdVO.class);
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
	 * 헤더부분 생성
	 * @return List<TaiwanSearchMsgHeaderVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchMsgHeaderVO> searchMsgHeader() throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchMsgHeaderVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchMsgHeaderRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchMsgHeaderVO.class);
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
	 * 서브 헤더부분 생성
	 * @return List<TaiwanSearchSubMsgHeaderVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaiwanSearchSubMsgHeaderVO> searchMsgSubHeader() throws DAOException {
		DBRowSet dbRowset = null;
		List<TaiwanSearchSubMsgHeaderVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new TaiwanCustomsTransmissionDBDAOsearchSubMsgHeaderRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					TaiwanSearchSubMsgHeaderVO.class);
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
