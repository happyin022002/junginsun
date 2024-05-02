/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0053
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.basic.AustrailiaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlCharegeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlChargeTotalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlGeneralForMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlGeneralForPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchContainerDangerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchContainerDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchContainerForMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchContainerForPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchEstimateDtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchMakeHeaderMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchMakeHeaderPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchVesselForMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchVesselForPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AustrailiaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DeclBaseInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DgEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DgSendDtlHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DgSendHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.EqInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.ItemInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

  
/**
 * NIS2010 AusCustomsTransmissionDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LIM JAE TAEK
 * @see AustrailiaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class AusCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 호주세관으로 전송할 Manifest Header 정보를 조회한다.
	 * @return List<AusSearchMakeHeaderMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchMakeHeaderMVO> searchMakerHeaderM() throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchMakeHeaderMVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchMakeHeaderMRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchMakeHeaderMVO.class);
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
	 * 호주항만청으로 전송할 Manifest Header 정보를 조회한다.
	 * @param AustrailiaManifestTransmitVO austrailiaManifestTransmitVO
	 * @return List<AusSearchMakeHeaderPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchMakeHeaderPVO> searchMakerHeaderP( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchMakeHeaderPVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchMakeHeaderPRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchMakeHeaderPVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Vessel VVD 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchVvdVO> searchVvd( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchVvdRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchVvdVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Vessel Estimated Date 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchEstimateDtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchEstimateDtVO> searchEstimateDt( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchEstimateDtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchEstimateDtRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchEstimateDtVO.class);
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
	 * 호주세관으로 전송할 Vessel 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchVesselForMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchVesselForMVO> searchVesselForM( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchVesselForMVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchVesselForMRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchVesselForMVO.class);
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
	 * 호주 항만청으로 전송할 Vessel 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchVesselForPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchVesselForPVO> searchVesselForP( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchVesselForPVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchVesselForPRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchVesselForPVO.class);
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
	 * 호주세관으로 전송할 Manifest B/L General 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchBlGeneralForMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchBlGeneralForMVO> searchBlGeneralForM( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchBlGeneralForMVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlGeneralForMRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchBlGeneralForMVO.class);
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
	 * 호주항만청으로 전송할 Manifest B/L General 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO	 
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchBlGeneralForPVO> searchBlGeneralForP( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchBlGeneralForPVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlGeneralForPRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchBlGeneralForPVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Manifest B/L Charge 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchBlCharegeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchBlCharegeVO> searchBlCharge( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchBlCharegeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlCharegeRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchBlCharegeVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Manifest B/L Charge Total 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchBlChargeTotalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchBlChargeTotalVO> searchBlChargeTotal( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchBlChargeTotalVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlChargeTotalRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchBlChargeTotalVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Manifest B/L Mark Description 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchBlMarkDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchBlMarkDescVO> searchBlMarksDesc( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchBlMarkDescVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlMarkDescRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchBlMarkDescVO.class);
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
	 * 호주세관으로 전송할 Manifest Container 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchContainerForMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchContainerForMVO> searchContainerForM( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchContainerForMVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchContainerForMRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchContainerForMVO.class);
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
	 * 호주항만청으로 전송할 Manifest Container 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchContainerForPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchContainerForPVO> searchContainerForP( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchContainerForPVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchContainerForPRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchContainerForPVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Manifest Container Danger 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchContainerDangerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchContainerDangerVO> searchContainerDanger( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchContainerDangerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchContainerDangerRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchContainerDangerVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Manifest Container Description 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchContainerDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchContainerDescVO> searchContainerDesc( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchContainerDescVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchContainerDescRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchContainerDescVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Manifest B/L Qty 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchBlQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchBlQtyVO> searchBlQty( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchBlQtyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlQtyRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchBlQtyVO.class);
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
	 * 호주세관 및 항만청으로 전송할 Manifest B/L VVD 정보를 조회한다.
	 * @param austrailiaManifestTransmitVO
	 * @return List<AusSearchBlVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AusSearchBlVvdVO> searchBlVvd( 
			AustrailiaManifestTransmitVO austrailiaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AusSearchBlVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (austrailiaManifestTransmitVO != null) {
				Map<String, String> mapVO = austrailiaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlVvdRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AusSearchBlVvdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	
	
	
	
	
	
	/** 1511호주 DG 화면
	 * Flat File - decl 기본정보를 조회한다. <br>
	 * 
	 * @param dgEdiVO
	 * @return DeclBaseInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DeclBaseInfoVO searchDeclBaseInfo(DgEdiVO dgEdiVO) throws DAOException {
		DeclBaseInfoVO declBaseInfoVO = new DeclBaseInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL(), param, velParam);
			
			List<DeclBaseInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,DeclBaseInfoVO.class);
			
			if (list != null && list.size() > 0) {
				declBaseInfoVO = (DeclBaseInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return declBaseInfoVO;
	}
	
	
	
	
	/** 1511호주 DG 화면
	 * Flat File - BL 기본정보를 조회한다. <br>
	 * 
	 * @param DgEdiVO dgEdiVO
	 * @return List<BlInfoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BlInfoVO> searchBlInfo(DgEdiVO dgEdiVO) throws DAOException {
		List<BlInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlInfoRSQL(), param, velParam);
			
			 list = (List) RowSetUtil.rowSetToVOs(dbRowset,BlInfoVO.class);
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	
	
	
	
	/** 1511호주 DG 화면
	 * Flat File - CNTR (EQ) 기본정보를 조회한다. <br>
	 * 
	 * @param DgEdiVO dgEdiVO
	 * @return List<EqInfoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EqInfoVO> searchEqInfo(DgEdiVO dgEdiVO) throws DAOException {
		List<EqInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AusCustomsTransmissionDBDAOsearchEqInfoRSQL(), param, velParam);
			
			 list = (List) RowSetUtil.rowSetToVOs(dbRowset,EqInfoVO.class);
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	
	/** 1511호주 DG 화면
	 * Flat File - Item 기본정보를 조회한다. <br>
	 * 
	 * @param BlInfoVO blInfoVO
	 * @return List<ItemInfoVO> list 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ItemInfoVO> searchItemInfo(BlInfoVO blInfoVO) throws DAOException {
		List<ItemInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (blInfoVO != null)
			{
				Map<String, String> mapVO = blInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AusCustomsTransmissionDBDAOsearchItemInfoRSQL(), param, velParam);
			
			 list = (List) RowSetUtil.rowSetToVOs(dbRowset,ItemInfoVO.class);
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	
	
	
	/**
	 * 송신 log 저장 (송신 마스터 테이블)
	 * 
	 * @param  DgSendHistoryVO dgSendHistoryVO
	 * @throws DAOException
	 */
	public void addSendLog(DgSendHistoryVO dgSendHistoryVO) throws DAOException {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(dgSendHistoryVO != null) {
	            Map<String, String> mapVO = dgSendHistoryVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AusCustomsTransmissionDBDAOaddSendLogCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	
	
	
	
	/**
	 *  * 송신 log 저장 (송신 Detail)<Br>
	 * @param List<DgSendDtlHistoryVO> dgSendDtlHistoryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSendDtlLog(List<DgSendDtlHistoryVO> dgSendDtlHistoryVOs) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        DgSendDtlHistoryVO dgSendDtlHistoryVO = null;
        
        int result = 0;
        
        try {
        	for(int i = 0; i < dgSendDtlHistoryVOs.size(); i++) {
        	
        		dgSendDtlHistoryVO = dgSendDtlHistoryVOs.get(i);
	        	if(dgSendDtlHistoryVO != null) {
		            Map<String, String> mapVO = dgSendDtlHistoryVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate) new AusCustomsTransmissionDBDAOaddSendDtlLogCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
        	} // end for(i)
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	
	
	
//	 /**
//     * 호주 Danger cargo 정보를 컨테이너 단위로 조회한다.
//     * 
//     * @param dgCargoCondVO
//     * @return DgInqModiVO
//     * @throws DAOException
//     */
//    @SuppressWarnings("unchecked")
//    public List<DgInqModiVO> searchDgInfoinquiry(DgCargoCondVO dgCargoCondVO) throws DAOException {
//
//    	//DgInqModiVO dgInqModiVO = new DgInqModiVO();
//    	List<DgInqModiVO> list = null;
//		
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try
//		{
//			if (dgCargoCondVO != null)
//			{
//				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
////			list = (List)new SQLExecuter("").executeQuery(
////					(ISQLTemplate)new SpecialManifestDBDAOsearchDgInfoinquiryRSQL(), param, velParam, DgInqModiVO.class);
//			
//			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new AusCustomsTransmissionDBDAOsearchDgInfoinquiryRSQL(), param, velParam);
//			
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset,DgInqModiVO.class);
//			
////			if (list != null && list.size() > 0) {
////				dgInqModiVO = (DgInqModiVO) list.get(list.size() - 1);
////			}
//			
//			
//		} catch (SQLException se) {
//			log.error("err " + se.toString(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//
//		return list;
//    }   
//    
//	
//    
//    
//    /**
//     * 호주 DG 팝업에서 위험물 상세 정보들을 업데이트&저장한다.
//     * 
//     * @param DgInqModiVO dgInqModiVO
//     * @throws DAOException
//     */
//    public void modifyDgInqBySeq(DgInqModiVO dgInqModiVO) throws DAOException {
//
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        
//        int result = 0;
//        try {
//            Map<String, String> mapVO = dgInqModiVO.getColumnValues();
//            
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//            
//            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AusCustomsTransmissionDBDAOmodifyDgInqBySeqUSQL(), param, velParam);
//            if(result == Statement.EXECUTE_FAILED) {
//           		throw new DAOException("Fail to insert");
//            }
//            
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//
//		
//    }
    
//   // ★★★ ★ ★ ★ ★ ★ 여기서부터 팝업
//    
//    /**
//	 * Forward Code로 Forward Name을 조회한다.<br>
//	 * 
//	 * @param AusDgListCondVO dgListCondVO
//	 * @return String
//	 * @throws DAOException
//	 */
//	public String searchForwarderNameByCd(DgListCondVO dgListCondVO) throws DAOException {
//
//		String retVal = "";
//
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(dgListCondVO != null) {
//				Map<String, String> mapVO = dgListCondVO.getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			
//			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new AusCustomsTransmissionDBDAOsearchForwarderNameByCdRSQL(), param, velParam);
//
//			if(dbRowset.getRowCount() > 0) {
//				
//				if (dbRowset.next()) {
//					retVal = dbRowset.getString(1);
//				}
//				
//			}
//			
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//
//		
//		return retVal;
//    }
//	
//	
//	/**
//	 * UN NO로 NAME을 조회한다.<br>
//	 * 
//	 * @param AusDgListCondVO dgListCondVO
//	 * @return String
//	 * @throws DAOException
//	 */
//	public String searchUnnoNameByCd(DgListCondVO dgListCondVO) throws DAOException {
//
//		String retVal = "";
//
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(dgListCondVO != null) {
//				Map<String, String> mapVO = dgListCondVO.getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//
//			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new AusCustomsTransmissionDBDAOsearchUnnoNameByCdRSQL(), param, velParam);
//
//			if(dbRowset.getRowCount() > 0) {
//				
//				if (dbRowset.next()) {
//					retVal = dbRowset.getString(1);
//				}	
//			}
//			
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//
//		
//		return retVal;
//    }
//	
//	
//	/**
//	 * Feeder Name, Lloyd No를 조회한다.<br>
//	 * 
//	 * @return List<FeederNameVO>
//	 * @throws DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<FeederNameVO> searchDgFeederNameList() throws DAOException {
//
//		List<FeederNameVO> list = null;
//
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new AusCustomsTransmissionDBDAOsearchDgFeederNameListRSQL(), param, velParam, FeederNameVO.class);
//			
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		
//		return list;
//    }
//	
//	
//	/**
//     * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
//     * 
//     * @param dgCargoCondVO
//     * @return List<DgCntrInfoListVO>
//     * @throws DAOException
//     */
//    @SuppressWarnings("unchecked")
//    public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws DAOException {
//		List<DgCntrInfoListVO> list = null;
//		
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try
//		{
//			if (dgCargoCondVO != null)
//			{
//				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			list = (List)new SQLExecuter("").executeQuery(
//					(ISQLTemplate)new AusCustomsTransmissionDBDAOsearchCntrInfoListByBlRSQL(), param, velParam, DgCntrInfoListVO.class);
//			
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//
//		return list;
//    }
//    
//    
//    /**
//     * 해당 컨테이너에에 속한 Cgo Seq 리스트를 조회한다.(셋팅을 위해)<br>
//     * 
//     * @param dgCargoCondVO
//     * @return List<DgCntrInfoListVO>
//     * @throws DAOException
//     */
//    @SuppressWarnings("unchecked")
//    public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws DAOException {
//		List<DgCntrInfoListVO> list = null;
//		
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try
//		{
//			if (dgCargoCondVO != null)
//			{
//				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			list = (List)new SQLExecuter("").executeQuery(
//					(ISQLTemplate)new AusCustomsTransmissionDBDAOsearchCgoSeqListByCntrRSQL(), param, velParam, DgCntrInfoListVO.class);
//			
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//
//		return list;
//    }
//	
	
	 
}
