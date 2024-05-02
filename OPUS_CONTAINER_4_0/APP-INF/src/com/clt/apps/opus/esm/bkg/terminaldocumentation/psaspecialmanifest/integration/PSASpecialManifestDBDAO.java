/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : psaspecialmanifestDBDAO.java
*@FileTitle : Forwarder Code, Name Setup(ANRBS)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.basic.PSASpecialManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSACntrBaseInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSACntrCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADeclBaseInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgEdiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgSendDtlHistoryVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgSendHistoryVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSAMainMeansVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSAMainPartiesVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PsaDGRcvMsgVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS PSASpecialManifestDBDAO <br>
 * - OPUS-PSASpecialManifestBC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kyoung Jong Yun
 * @see PSASpecialManifestBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class PSASpecialManifestDBDAO extends DBDAOSupport {
	/**
	 * PSA VSL Name 조회
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchPSAVslName(String vvd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSASpecialManifestDBDAOsearchPSAVslNameRSQL(), param, null);
			String psaVslNm = "";
			if (dbRowset.next()) psaVslNm = dbRowset.getString("PSA_VSL_NM");
			return psaVslNm;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 *
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return List<PSADgListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<PSADgListDetailVO> searchPsaDgInfoAtBkgDg(PSADgListCondVO psaDgListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(psaDgListCondVO != null) {
				Map<String, String> mapVO = psaDgListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List)new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchDgInfoAtBkgDgRSQL(), param, velParam, PSADgListDetailVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Lloyd, vessel name등 Vessel 정보를 조회해옴-(Booking 쪽 data),<br>
	 * 도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함- (Booking 쪽 data) <br>
	 *
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return List<PSADgListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<PSADgListDetailVO> serachPsaVslAtCommon(PSADgListCondVO psaDgListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(psaDgListCondVO != null) {
				Map<String, String> mapVO = psaDgListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List)new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSerachVslAtCommonRSQL(), param, velParam, PSADgListDetailVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Sent결과를 조회해 온다.<br>
	 *
	 * @param PSASendHistoryCondVO psaSendHistoryCondVO
	 * @return List<PSASendHistoryDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<PSASendHistoryDetailVO> searchPsaSendHistoryByCntrNo(PSASendHistoryCondVO psaSendHistoryCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (psaSendHistoryCondVO != null) {
				Map<String, String> mapVO = psaSendHistoryCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchSendHistoryByCntrNoRSQL(), param, velParam, PSASendHistoryDetailVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File - decl 기본정보를 조회한다. <br>
	 *
	 * @param PSADgEdiVO psaDgEdiVO
	 * @return PSADeclBaseInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public PSADeclBaseInfoVO searchPsaDeclBaseInfo(PSADgEdiVO psaDgEdiVO) throws DAOException {
		PSADeclBaseInfoVO declBaseInfoVO = new PSADeclBaseInfoVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (psaDgEdiVO != null) {
				Map<String, String> mapVO = psaDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			List<PSADeclBaseInfoVO> list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchDeclBaseInfoRSQL(), param, velParam, PSADeclBaseInfoVO.class);
			if (list != null && list.size() > 0) {
				declBaseInfoVO = (PSADeclBaseInfoVO) list.get(list.size() - 1);
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
	 * @param PSADgEdiVO psaDgEdiVO
	 * @return List<PSAMainPartiesVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<PSAMainPartiesVO> searchPsaMainParties(PSADgEdiVO psaDgEdiVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (psaDgEdiVO != null) {
				Map<String, String> mapVO = psaDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchMainPartiesRSQL(), param, velParam, PSAMainPartiesVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File - MAIN MEANS 정보를 조회한다.  <br>
	 *
	 * @param PSADgEdiVO psaDgEdiVO
	 * @return PSAMainMeansVO
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public PSAMainMeansVO searchPsaMainMeans(PSADgEdiVO psaDgEdiVO) throws DAOException {
		PSAMainMeansVO mainMeansVO = new PSAMainMeansVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (psaDgEdiVO != null) {
				Map<String, String> mapVO = psaDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			List<PSAMainMeansVO> list = (List) new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchMainMeansRSQL(), param, velParam, PSAMainMeansVO.class);
			if (list != null && list.size() > 0) {
				mainMeansVO = (PSAMainMeansVO) list.get(list.size() - 1);
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
	 * @param PSADgEdiVO psaDgEdiVO
	 * @return List<PSACntrBaseInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<PSACntrBaseInfoVO> searchPsaCntrBaseInfo(PSADgEdiVO psaDgEdiVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (psaDgEdiVO != null) {
				Map<String, String> mapVO = psaDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchCntrBaseInfoRSQL(), param, velParam, PSACntrBaseInfoVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File - 컨테이터에 해당하는 아이템 정보 조회 <br>
	 *
	 * @param PSACntrBaseInfoVO psaCntrBaseInfoVO
	 * @return List<PSACntrCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<PSACntrCgoVO> searchPsaCntrCgoByCntrBase(PSACntrBaseInfoVO psaCntrBaseInfoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (psaCntrBaseInfoVO != null) {
				Map<String, String> mapVO = psaCntrBaseInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchCntrCgoByCntrBaseRSQL(), param, velParam, PSACntrCgoVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 송신 log 저장 (송신 마스터 테이블)
	 *
	 * @param  PSADgSendHistoryVO psaDgSendHistoryVO
	 * @throws DAOException
	 */
	public void addPsaSendLog(PSADgSendHistoryVO psaDgSendHistoryVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			if(psaDgSendHistoryVO != null) {
				Map<String, String> mapVO = psaDgSendHistoryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddPsaSendLogCSQL(), param, velParam);
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
	 * @param List<PSADgSendDtlHistoryVO> psaDgSendDtlHistoryVOList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsaSendDtlLog(List<PSADgSendDtlHistoryVO> psaDgSendDtlHistoryVOList) throws DAOException, Exception {
		try {
			if (psaDgSendDtlHistoryVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new PSASpecialManifestDBDAOaddPsaSendDtlLogCSQL(), psaDgSendDtlHistoryVOList, null);
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
	 * @param List<PSADgSendHistoryVO> psaDgSendFlatFileHistoryVOList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsaSendFlatFileLog(List<PSADgSendHistoryVO> psaDgSendFlatFileHistoryVOList) throws DAOException, Exception {
		try {
			if (psaDgSendFlatFileHistoryVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new PSASpecialManifestDBDAOaddPsaSendFlatFileLogCSQL(), psaDgSendFlatFileHistoryVOList, null);
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
	public String searchPsaEdiHistoryKey(String msgTpId, String keyType, String vvdCd, String portCd, String dType) throws DAOException {
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
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchEdiHistoryKeyRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) if (dbRowset.next()) retVal = dbRowset.getString(1);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}

	/**
	 * 수신정보 키값(RCV_LOG_SEQ) 조회<br>
	 *
	 * @param String msgTpId
	 * @param String msgRevNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchRcvLogSeq(String msgTpId, String msgRevNo) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("msg_tp_id", msgTpId);
			mapVO.put("msg_rcv_no", msgRevNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSASpecialManifestDBDAOsearchRcvLogSeqRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) if (dbRowset.next()) retVal = dbRowset.getString(1);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}

	/**
	 *  수신데이타 저장<Br>
	 *
	 * @param PsaDGRcvMsgVO psaDGRcvMsgVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAck(PsaDGRcvMsgVO psaDGRcvMsgVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			if(psaDGRcvMsgVO != null) {
				Map<String, String> mapVO = psaDGRcvMsgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddAckCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG06087",new String[] {} ).getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  수신데이타 저장<Br>
	 *
	 * @param PsaDGRcvMsgVO psaDGRcvMsgVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAckKnt(PsaDGRcvMsgVO psaDGRcvMsgVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			if(psaDGRcvMsgVO != null) {
				Map<String, String> mapVO = psaDGRcvMsgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddAckKntCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("BKG06087",new String[] {} ).getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 수신정보 키값(Msg_Rcv_No) 조회<br>
	 *
	 * @param String msgTpId
	 * @return String
	 * @throws DAOException
	 */
	public String searchMsgRcvNo(String msgTpId) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("msg_tp_id", msgTpId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSASpecialManifestDBDAOsearchMsgRcvNoRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) if (dbRowset.next()) retVal = dbRowset.getString(1);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}

	/**
	 * 수신 결과를 조회해 온다.<br>
	 *
	 * @param PSASendHistoryCondVO psaSendHistoryCondVO
	 * @return List<PSASendHistoryDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PSASendHistoryDetailVO> searchPsaReceiveHistory(PSASendHistoryCondVO psaSendHistoryCondVO) throws DAOException {
		List<PSASendHistoryDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (psaSendHistoryCondVO != null)
			{
				Map<String, String> mapVO = psaSendHistoryCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchReceiveHistoryRSQL(), param, velParam, PSASendHistoryDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}


}
