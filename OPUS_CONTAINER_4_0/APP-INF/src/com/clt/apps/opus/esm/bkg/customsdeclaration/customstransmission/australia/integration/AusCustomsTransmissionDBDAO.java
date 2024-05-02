/*=========================================================
*Copyright(c) CyberLogitec
*@FileName : AusCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0053
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.basic.AustraliaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCntrBaseInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCntrCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarBkgBookingDocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarCstmsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarDgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusDeclBaseInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusDgSendDtlHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusDgSendHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusMainMeansVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusMainPartiesVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlCharegeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlChargeTotalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlGeneralForMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlGeneralForPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchContainerDangerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchContainerDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchContainerForMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchContainerForPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchMakeHeaderMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchMakeHeaderPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchVesselForMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchVesselForPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchVslPortSkdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AustraliaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgEdiVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgCstmsAusSndLogVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;


/**
 * OPUS AusCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author LIM JAE TAEK
 * @see AustraliaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class AusCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 호주세관으로 전송할 Manifest Header 정보를 조회한다.
	 * @return List<AusSearchMakeHeaderMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchMakeHeaderMVO> searchMakerHeaderM() throws DAOException {
		try {
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchMakeHeaderMRSQL(), null, null, AusSearchMakeHeaderMVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주항만청으로 전송할 Manifest Header 정보를 조회한다.
	 * @param AustraliaManifestTransmitVO australiaManifestTransmitVO
	 * @return List<AusSearchMakeHeaderPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchMakeHeaderPVO> searchMakerHeaderP(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchMakeHeaderPRSQL(), param, null, AusSearchMakeHeaderPVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관으로 전송할 Vessel 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchVesselForMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchVesselForMVO> searchVesselForM(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchVesselForMRSQL(),param, velParam, AusSearchVesselForMVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주 항만청으로 전송할 Vessel 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchVesselForPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchVesselForPVO> searchVesselForP(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchVesselForPRSQL(),param, velParam, AusSearchVesselForPVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관으로 전송할 Manifest B/L General 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchBlGeneralForMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchBlGeneralForMVO> searchBlGeneralForM(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlGeneralForMRSQL(),param, velParam, AusSearchBlGeneralForMVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주항만청으로 전송할 Manifest B/L General 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchBlGeneralForPVO> searchBlGeneralForP(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlGeneralForPRSQL(),param, velParam, AusSearchBlGeneralForPVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관 및 항만청으로 전송할 Manifest B/L Charge 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchBlCharegeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchBlCharegeVO> searchBlCharge(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlCharegeRSQL(),param, velParam, AusSearchBlCharegeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관 및 항만청으로 전송할 Manifest B/L Charge Total 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchBlChargeTotalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchBlChargeTotalVO> searchBlChargeTotal(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlChargeTotalRSQL(),param, velParam, AusSearchBlChargeTotalVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관 및 항만청으로 전송할 Manifest B/L Mark Description 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchBlMarkDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchBlMarkDescVO> searchBlMarksDesc(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlMarkDescRSQL(),param, velParam, AusSearchBlMarkDescVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관으로 전송할 Manifest Container 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchContainerForMVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchContainerForMVO> searchContainerForM(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchContainerForMRSQL(),param, velParam, AusSearchContainerForMVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주항만청으로 전송할 Manifest Container 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchContainerForPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchContainerForPVO> searchContainerForP(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchContainerForPRSQL(),param, velParam, AusSearchContainerForPVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관 및 항만청으로 전송할 Manifest Container Danger 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchContainerDangerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchContainerDangerVO> searchContainerDanger(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchContainerDangerRSQL(),param, velParam, AusSearchContainerDangerVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관 및 항만청으로 전송할 Manifest Container Description 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchContainerDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchContainerDescVO> searchContainerDesc(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchContainerDescRSQL(),param, velParam, AusSearchContainerDescVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관 및 항만청으로 전송할 Manifest B/L Qty 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchBlQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchBlQtyVO> searchBlQty(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlQtyRSQL(),param, velParam, AusSearchBlQtyVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 호주세관 및 항만청으로 전송할 Manifest B/L VVD 정보를 조회한다.
	 * @param australiaManifestTransmitVO
	 * @return List<AusSearchBlVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchBlVvdVO> searchBlVvd(AustraliaManifestTransmitVO australiaManifestTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (australiaManifestTransmitVO != null) {
				Map<String, String> mapVO = australiaManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBlVvdRSQL(),param, velParam, AusSearchBlVvdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VSL_CD로 MDM_VSL_CNTR 조회
	 *
	 * @param String vvd
	 * @return List<MdmVslCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmVslCntrVO> searchMdmVslCntrByVslCd(String vvd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("vvd", vvd);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchMdmVslCntrByVslCdRSQL(), param, null, MdmVslCntrVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *
	 * BKG_NO로 SRN No.와 SRN Ver. 정보 조회<br>
	 *
	 * @param String blNo
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchSrnInfo(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchSrnInfo(), param, null);
			String[] rtnVal = new String[2];
			if (dbRowset.next()) {
				rtnVal[0] = dbRowset.getString("SRN_NO");
				rtnVal[1] = dbRowset.getString("SRN_VER");
			} else {
				rtnVal[0] = "";
				rtnVal[1] = "";
			}
			return rtnVal;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VVD, POD로 VSK_VSL_PORT_SKD 정보 조회<br>
	 *
	 * @param String vvd
	 * @param String portCd
	 * @return List<AusSearchVslPortSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusSearchVslPortSkdVO> searchVskVslPortSkd(String vvd, String portCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("vvd", vvd);
			param.put("port_cd", portCd);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchVskVslPortSkdRSQL(), param, null, AusSearchVslPortSkdVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * VSL_CD로 MDM_VSL_CNTR 조회
	 *
	 * @param String portCd
	 * @return List<MdmLocationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmLocationVO> searchMdmLocationByPortCd(String portCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("port_cd", portCd);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchMdmLocationByPortCdRSQL(), param, null, MdmLocationVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_NO로 BKG_BOOKING, BKG_BL_DOC 조회
	 *
	 * @param String bkgNo
	 * @return List<AusCuscarBkgBookingDocVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusCuscarBkgBookingDocVO> searchBkgBookingDocByBkgNo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchBkgBookingDocByBkgNoRSQL(), param, null, AusCuscarBkgBookingDocVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * {LOC_INFO ~ } 정보 조회<br>
	 *
	 * @param String vvd
	 * @param String bkgNo
	 * @param String portCd
	 * @return List<AusCuscarLocInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusCuscarLocInfoVO> searchLocInfo(String vvd, String bkgNo, String portCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("vvd", vvd);
			param.put("bkg_no", bkgNo);
			param.put("port_cd", portCd);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchLocInfoRSQL(), param, null, AusCuscarLocInfoVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * {CUSTOMER_INFO ~ } 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @param String usrId
	 * @return List<AusCuscarCstmsInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusCuscarCstmsInfoVO> searchCstmsInfo(String bkgNo, String usrId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("usr_id", usrId);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchCstmsInfoRSQL(), param, null, AusCuscarCstmsInfoVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * {CNTR_INFO ~ } 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return List<AusCuscarCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusCuscarCntrInfoVO> searchCntrInfo(String bkgNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchCntrInfoRSQL(), param, velParam, AusCuscarCntrInfoVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Container Seal No. 조회<br>
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return List<BkgCntrSealNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCntrSealNoVO> searchCntrSealNo(String bkgNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchCntrSealNoRSQL(), param, null, BkgCntrSealNoVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * {GOODS_INFO ~ } 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return List<BkgCntrMfDescVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgCntrMfDescVO> searchGoodsInfo(String bkgNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchGoodsInfoRSQL(), param, null, BkgCntrMfDescVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Description 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<AusCuscarMarkDescVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusCuscarMarkDescVO> searchCuscarDesc(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchCuscarDescRSQL(), param, null, AusCuscarMarkDescVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Remark 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<AusCuscarDgInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusCuscarMarkDescVO> searchCuscarMark(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchCuscarMarkRSQL(), param, null, AusCuscarMarkDescVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * {DANGER_GOODS ~ } 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<AusCuscarDgInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AusCuscarDgInfoVO> searchDgInfo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchDgInfoRSQL(), param, null, AusCuscarDgInfoVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_AUS_SND_LOG 정보 신규 저장<br>
	 *
	 * @param BkgCstmsAusSndLogVO bkgCstmsAusSndLogVO
	 * @exception DAOException, Exception
	 */
	public void addCstmsAusSndLog(BkgCstmsAusSndLogVO bkgCstmsAusSndLogVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsAusSndLogVO != null) {
				Map<String, String> mapVO = bkgCstmsAusSndLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new AusCustomsTransmissionDBDAOaddCstmsAusSndLogCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_CSTMS_AUS_SND_LOG 정보 수정 저장<br>
	 *
	 * @param BkgCstmsAusSndLogVO bkgCstmsAusSndLogVO
	 * @exception DAOException, Exception
	 */
	public void modifyCstmsAusSndLog(BkgCstmsAusSndLogVO bkgCstmsAusSndLogVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bkgCstmsAusSndLogVO != null) {
				Map<String, String> mapVO = bkgCstmsAusSndLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new AusCustomsTransmissionDBDAOmodifyCstmsAusSndLogUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Flat File - decl 기본정보를 조회한다. <br>
	 *
	 * @param AusDgEdiVO ausDgEdiVO
	 * @return AusDeclBaseInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public AusDeclBaseInfoVO searchAusDeclBaseInfo(AusDgEdiVO ausDgEdiVO) throws DAOException {
		AusDeclBaseInfoVO declBaseInfoVO = new AusDeclBaseInfoVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ausDgEdiVO != null) {
				Map<String, String> mapVO = ausDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			List<AusDeclBaseInfoVO> list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL(), param, velParam, AusDeclBaseInfoVO.class);
			if (list != null && list.size() > 0) {
				declBaseInfoVO = (AusDeclBaseInfoVO) list.get(list.size() - 1);
			}
			return declBaseInfoVO;
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File - MAIN PARTIES 정보를 조회한다. <br>
	 *
	 * @param AusDgEdiVO ausDgEdiVO
	 * @return List<AusMainPartiesVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<AusMainPartiesVO> searchAusMainParties(AusDgEdiVO ausDgEdiVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ausDgEdiVO != null) {
				Map<String, String> mapVO = ausDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate)new AusCustomsTransmissionDBDAOsearchAusMainPartiesRSQL(), param, velParam, AusMainPartiesVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File - MAIN MEANS 정보를 조회한다.  <br>
	 *
	 * @param AusDgEdiVO ausDgEdiVO
	 * @return AusMainMeansVO
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public AusMainMeansVO searchAusMainMeans(AusDgEdiVO ausDgEdiVO) throws DAOException {
		AusMainMeansVO mainMeansVO = new AusMainMeansVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ausDgEdiVO != null) {
				Map<String, String> mapVO = ausDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			List<AusMainMeansVO> list = (List) new SQLExecuter("").executeQuery((ISQLTemplate)new AusCustomsTransmissionDBDAOsearchMainMeansRSQL(), param, velParam, AusMainMeansVO.class);
			if (list != null && list.size() > 0) {
				mainMeansVO = (AusMainMeansVO) list.get(list.size() - 1);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mainMeansVO;
	}

	/**
	 * Flat File - 컨테이터 기본정보를 조회한다.   <br>
	 *
	 * @param AusDgEdiVO ausDgEdiVO
	 * @return List<AusCntrBaseInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<AusCntrBaseInfoVO> searchAusCntrBaseInfo(AusDgEdiVO ausDgEdiVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ausDgEdiVO != null) {
				Map<String, String> mapVO = ausDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchCntrBaseInfoRSQL(), param, velParam, AusCntrBaseInfoVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File - 컨테이터 SUB_PARTIES 정보를 조회한다.   <br>
	 *
	 * @param AusCntrBaseInfoVO cntrBaseInfoVO
	 * @return List<AusCntrBaseInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<AusCntrBaseInfoVO> searchSubPartyInfo(AusCntrBaseInfoVO cntrBaseInfoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cntrBaseInfoVO != null) {
				Map<String, String> mapVO = cntrBaseInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchSubPartyInfoRSQL(), param, velParam, AusCntrBaseInfoVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File - 컨테이터에 해당하는 아이템 정보 조회 <br>
	 *
	 * @param AusCntrBaseInfoVO ausCntrBaseInfoVO
	 * @return List<AusCntrCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<AusCntrCgoVO> searchAusCntrCgoByCntrBase(AusCntrBaseInfoVO ausCntrBaseInfoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ausCntrBaseInfoVO != null) {
				Map<String, String> mapVO = ausCntrBaseInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchCntrCgoByCntrBaseRSQL(), param, velParam, AusCntrCgoVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 송신 log 저장 (송신 마스터 테이블)
	 *
	 * @param  AusDgSendHistoryVO ausDgSendHistoryVO
	 * @throws DAOException
	 */
	public void addAusSendLog(AusDgSendHistoryVO ausDgSendHistoryVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			if(ausDgSendHistoryVO != null) {
				Map<String, String> mapVO = ausDgSendHistoryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AusCustomsTransmissionDBDAOaddAusSendLogCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG06087",new String[] {} ).getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 송신 log 저장 (송신 Detail)<Br>
	 *
	 * @param List<AusDgSendDtlHistoryVO> ausDgSendDtlHistoryVOList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAusSendDtlLog(List<AusDgSendDtlHistoryVO> ausDgSendDtlHistoryVOList) throws DAOException, Exception {
		try {
			if (ausDgSendDtlHistoryVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new AusCustomsTransmissionDBDAOaddAusSendDtlLogCSQL(), ausDgSendDtlHistoryVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * bkg_cstms_eur_snd_log 테이블에 FlatFile을 통으로 저장한다.<Br>
	 *
	 * @param  List<AusDgSendHistoryVO> ausDgSendFlatFileHistoryVOList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAusSendFlatFileLog(List<AusDgSendHistoryVO> ausDgSendFlatFileHistoryVOList) throws DAOException, Exception {
		try {
			if (ausDgSendFlatFileHistoryVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new AusCustomsTransmissionDBDAOaddAusSendFlatFileLogCSQL(), ausDgSendFlatFileHistoryVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 수신정보 키값(MSG_SND_NO) 조회<br>
	 *
	 * @param String msgTpId
	 * @param String keyType
	 * @param String vvdCd
	 * @param String portCd
	 * @param String dType
	 * @return String
	 * @throws DAOException
	 */
	public String searchAusEdiHistoryKey(String msgTpId, String keyType, String vvdCd, String portCd, String dType) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (msgTpId != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("msgTpId", msgTpId);
				mapVO.put("keyType", keyType);
				mapVO.put("vvdCd", vvdCd);
				mapVO.put("portCd", portCd);
				mapVO.put("dType", dType);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AusCustomsTransmissionDBDAOsearchAusEdiHistoryKeyRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) if (dbRowset.next()) retVal = dbRowset.getString(1);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}


}
