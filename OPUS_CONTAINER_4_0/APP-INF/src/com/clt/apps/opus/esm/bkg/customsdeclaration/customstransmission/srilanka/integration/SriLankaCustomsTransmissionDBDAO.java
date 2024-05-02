/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0490
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.BkgCstmsSriRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchBkgNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchBlGeneralVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchEtaVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchEtdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchMakeHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchMakeHeaderVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchPrePortVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SrilankaSearchBlMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SrilankaSearchContainerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS SriLankaCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author LIM JAE TAEK
 * @see SriLankaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class SriLankaCustomsTransmissionDBDAO extends DBDAOSupport {


	/**
	 * 스리랑카 세관 신고용 Manifest Pre Port 정보를 조회한다.
	 * @param sriLankaManifestTransmitVO
	 * @return List<SriLankaSearchPrePortVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchPrePortVO> searchPrePort(
			SriLankaManifestTransmitVO sriLankaManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchPrePortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (sriLankaManifestTransmitVO != null) {
				Map<String, String> mapVO = sriLankaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchPrePortRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchPrePortVO.class);
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
	 *  스리랑카 세관 신고용 Manifest Estimated Date 정보를 조회한다.
	 * @param sriLankaManifestTransmitVO
	 * @return List<SriLankaSearchEtaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchEtaVO> searchEta(
			SriLankaManifestTransmitVO sriLankaManifestTransmitVO	) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchEtaVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (sriLankaManifestTransmitVO != null) {
				Map<String, String> mapVO = sriLankaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchEtaRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchEtaVO.class);
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
	 * 스리랑카 세관 신고용 Manifest Estimated Date 정보를 조회한다.
	 * @param sriLankaManifestTransmitVO
	 * @return List<SriLankaSearchEtdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchEtdVO> searchEtd(
			SriLankaManifestTransmitVO sriLankaManifestTransmitVO	) throws DAOException {
			DBRowSet dbRowset = null;
			List<SriLankaSearchEtdVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				if (sriLankaManifestTransmitVO != null) {
					Map<String, String> mapVO = sriLankaManifestTransmitVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchEtdRSQL(),param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchEtdVO.class);
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
	 * 스리랑카 세관 신고용 B/L의 Booking Number 및 Cargo Type Code 를 조회한다.
	 * @param sriLankaManifestTransmitVO
	 * @return List<SriLankaSearchBkgNoVO>
	 * @throws DAOException
	 */
		@SuppressWarnings("unchecked")
		public List<SriLankaSearchBkgNoVO> searchBkgNo(
				SriLankaManifestTransmitVO sriLankaManifestTransmitVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SriLankaSearchBkgNoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				if (sriLankaManifestTransmitVO != null) {
					Map<String, String> mapVO = sriLankaManifestTransmitVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchBkgNoRSQL(),param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchBkgNoVO.class);
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
		 * 스리랑카 세관 신고용 Manifest B/L General 정보를 조회한다.
		 * @param sriLankaManifestTransmitVO
		 * @return List<SriLankaSearchBlGeneralVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SriLankaSearchBlGeneralVO> searchBlGeneral(
				SriLankaManifestTransmitVO sriLankaManifestTransmitVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<SriLankaSearchBlGeneralVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if (sriLankaManifestTransmitVO != null) {
						Map<String, String> mapVO = sriLankaManifestTransmitVO.getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchBlGeneralRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchBlGeneralVO.class);
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
		 * 스리랑카 세관 신고용 Manifest Container 정보를 조회한다.
		 * @param sriLankaManifestTransmitVO
		 * @return List<SrilankaSearchContainerVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SrilankaSearchContainerVO> searchContainer(
				SriLankaManifestTransmitVO sriLankaManifestTransmitVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<SrilankaSearchContainerVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if (sriLankaManifestTransmitVO != null) {
						Map<String, String> mapVO = sriLankaManifestTransmitVO.getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchContainerRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, SrilankaSearchContainerVO.class);
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
		 * 스리랑카 세관 신고용 Manifest B/L Marks Description 정보를 조회한다.
		 * @param sriLankaManifestTransmitVO
		 * @return List<SrilankaSearchBlMarkDescVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SrilankaSearchBlMarkDescVO> searchBlMarkDesc(
				SriLankaManifestTransmitVO sriLankaManifestTransmitVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<SrilankaSearchBlMarkDescVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if (sriLankaManifestTransmitVO != null) {
						Map<String, String> mapVO = sriLankaManifestTransmitVO.getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchBlMarkDescRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, SrilankaSearchBlMarkDescVO.class);
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
		 * 스리랑카 세관 신고용 Manifest Vessel Arrival 정보를 조회한다.
		 * @param vslCd
		 * @param skdVoyNo
		 * @param skdDirCd
		 * @param podCd
		 * @return List<SriLankaSearchVesselArrivalVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SriLankaSearchVesselArrivalVO> searchVesselArrival(
				String vslCd,String skdVoyNo,String skdDirCd,String podCd) throws DAOException {
				DBRowSet dbRowset = null;
				List<SriLankaSearchVesselArrivalVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					param.put("vsl_cd", vslCd);
					velParam.put("vsl_cd", vslCd);

					param.put("skd_voy_no", skdVoyNo);
					velParam.put("skd_voy_no", skdVoyNo);

					param.put("skd_dir_cd", skdDirCd);
					velParam.put("skd_dir_cd", skdDirCd);

					param.put("pod_cd", podCd);
					velParam.put("pod_cd", podCd);

					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchVesselArrivalRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchVesselArrivalVO.class);
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
		 * FlatFile 만들기위하여 header부분 생성작업
		 * @return List<SriLankaSearchMakeHeaderVesselVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SriLankaSearchMakeHeaderVesselVO> searchMakeHeaderVessel() throws DAOException {
			DBRowSet dbRowset = null;
			List<SriLankaSearchMakeHeaderVesselVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {


				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchMakeHeaderVesselRSQL(),param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchMakeHeaderVesselVO.class);
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
		 * FlatFile 만들기위하여 header부분 생성작업
		 * @return List<SriLankaSearchMakeHeaderVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SriLankaSearchMakeHeaderVO> searchMakeHeader() throws DAOException {
				DBRowSet dbRowset = null;
				List<SriLankaSearchMakeHeaderVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {


					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaCustomsTransmissionDBDAOsearchMakeHeaderRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchMakeHeaderVO.class);
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
		 * SriLanka 세관으로부터 수신된 응답 메시지를 저장한다.
		 * @param bkgCstmsSriRcvLogVO
		 * @return int
		 * @throws DAOException
		 * @throws Exception
		 */
		 public int addSriLankaResponse(BkgCstmsSriRcvLogVO bkgCstmsSriRcvLogVO)
			throws DAOException,Exception {

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();


				int result = 0;
				try {
					Map<String, String> mapVO = bkgCstmsSriRcvLogVO.getColumnValues();


					param.putAll(mapVO);
					velParam.putAll(mapVO);

					result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SriLankaCustomsTransmissionDBDAOaddSriLankaResponseCSQL(), param, velParam);

					if(result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to Update SQL");
					}

				} catch (SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return result;
			}



}

