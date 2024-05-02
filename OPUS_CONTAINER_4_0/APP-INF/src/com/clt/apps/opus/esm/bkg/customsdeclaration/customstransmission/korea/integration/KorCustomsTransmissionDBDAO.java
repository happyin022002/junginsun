/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsTransmissionDAO.java
*@FileTitle : CustomsTransmissionDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.20 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrVvdSmryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAckMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdTransVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAutoMacSndVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrCntVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrNoKorVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusdmrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusmanVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusmodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusrepVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustChkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgCgoVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgmCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgmVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDiscFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorElnoInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpImfmodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpMacamdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorIbManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorImfmodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMFTVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMacamdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMakeFlatFileBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMakeFlatFileCNTRVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMakeFlatFileExportNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMakeFlatFileMACAMDVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMakeFlatFileMasterInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMakeSubNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorSndChkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCancellCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorUNLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorVslCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorVslVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS CustomsTransmissionDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author charves
 * @see KoreaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class KorCustomsTransmissionDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -6816308847573890143L;

	/**
	 * 전송 일시(현재일시) 조회
	 * @return String
	 * @exception DAOException
	 */
	public String searchSysDate() throws DAOException {
		String sysDate = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOSearchSysDateRSQL(), param, velParam);
			if(dbRowset.next()) sysDate = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sysDate;
	}

	/**
	 * OUTBOUND 의 POL에 대한 UNLOCODE 검색
	 * @param String polCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOBUNLocCd(String polCd) throws DAOException {
		String unPolCd = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("pol_cd", polCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchOBUNLocCdRSQL(), param, velParam);
			if (dbRowset.next()) unPolCd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return unPolCd;
	}

	/**
	 * INBOUND 의 POD에 대한 UNLOCODE 검색
	 * @param String podCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchIBUNLocCd(String podCd) throws DAOException {
		String unPodCd = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("pod_cd", podCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchIBUNLocCdRSQL(), param, velParam);
			if (dbRowset.next()) unPodCd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return unPodCd;
	}

	/**
	 * CUSREP 전송 로그 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addCUSREPSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddCUSREPSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 일괄정정, 일괄삭제(MACAMD) Master LOG Table로 전송일, VVD, B/L Info. 저장
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addMACAMDModiDelSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddMACAMDModiDelSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 하선신고서의 전송결과에 대한 Log를 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addDiscSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddDiscSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File 처리후 결과 리턴
	 * @return String
	 * @exception DAOException
	 */
	public String makeFlatFileEnd()throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String flatData = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOMakeFlatFileEndRSQL(), param, velParam);
			if (dbRowset.next()) {
				flatData = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatData;
	}

	/**
	 * MasterInfo FlatFile
	 * @param korMakeFlatFileMasterInfoVO
	 * @return FlatData
	 * @exception DAOException
	 */
	public String makeFlatFileMasterInfo(KorMakeFlatFileMasterInfoVO korMakeFlatFileMasterInfoVO)throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String flatData = null;
		try {
			Map<String, String> mapVO = korMakeFlatFileMasterInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOMakeFlatFileMasterInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				flatData = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatData;
	}

	/**
	 * MasterInfo FlatFile
	 * @param KorMakeFlatFileBlInfoVO korMakeFlatFileBlInfoVO
	 * @return List<KorMakeFlatFileBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorMakeFlatFileBlInfoVO> makeFlatFileBlInfo(KorMakeFlatFileBlInfoVO korMakeFlatFileBlInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <KorMakeFlatFileBlInfoVO> list = null;
		try {
			Map<String, String> mapVO = korMakeFlatFileBlInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOMakeFlatFileBlInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMakeFlatFileBlInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * MasterInfo FlatFile
	 * @param KorMakeFlatFileExportNoVO korMakeFlatFileExportNoVO
	 * @return List<KorMakeFlatFileExportNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorMakeFlatFileExportNoVO> makeFlatFileExportNo(KorMakeFlatFileExportNoVO korMakeFlatFileExportNoVO)throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <KorMakeFlatFileExportNoVO> list = null;
		try {
			Map<String, String> mapVO = korMakeFlatFileExportNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOMakeFlatFileExportNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMakeFlatFileExportNoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * MasterInfo FlatFile
	 * @param KorMakeFlatFileCNTRVO korMakeFlatFileCNTRVO
	 * @return List<KorMakeFlatFileCNTRVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorMakeFlatFileCNTRVO> makeFlatFileCNTR(KorMakeFlatFileCNTRVO korMakeFlatFileCNTRVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <KorMakeFlatFileCNTRVO> list = null;
		try {
			Map<String, String> mapVO = korMakeFlatFileCNTRVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOMakeFlatFileExportNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMakeFlatFileCNTRVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * UNLOC 코드 조회
	 * @param String polCd
	 * @param String podCd
	 * @return KorUNLocVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorUNLocVO searchUNLocCd(String polCd, String podCd)throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<KorUNLocVO> list = null;
		KorUNLocVO returnVal = null;
		try {
			param.put("pol_cd", polCd);
			param.put("pod_cd", podCd);
			velParam.put("pol_cd", polCd);
			velParam.put("pod_cd", podCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOSearchUNLocCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorUNLocVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * MakeFlatFileMACAMD
	 * @param KorMakeFlatFileMACAMDVO korMakeFlatFileMACAMDVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeFlatFileMACAMD(KorMakeFlatFileMACAMDVO korMakeFlatFileMACAMDVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String returnVal = null;
		try {
			Map<String, String> mapVO = korMakeFlatFileMACAMDVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOMakeFlatFileMACAMDRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * MRN CREATE를 위한 조회
	 *
	 * @param KorMrnCreateInfoCondVO korMrnCreateInfoCondVO
	 * @return List<KorMrnCreateInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorMrnCreateInfoVO> searchMrnCreateInfo(KorMrnCreateInfoCondVO korMrnCreateInfoCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMrnCreateInfoCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnCreateInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MRN_NO 가 존재하는지 체크
	 * @param KorMrnCreateInfoVO korMrnCreateInfoVO
	 * @return  String
	 * @exception DAOException
	 */
	public String searchMrnInfoByVVD(KorMrnCreateInfoVO korMrnCreateInfoVO) throws DAOException {
		String mrnNo=null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMrnCreateInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMrnInfoByVVDRSQL(), param, velParam);
			if(dbRowset.next()) mrnNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mrnNo;
	}

	/**
	 * MRN_NO 가 존재하는지 체크
	 * @param KorMrnCreateInfoVO korMrnCreateInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMrnChk(KorMrnCreateInfoVO korMrnCreateInfoVO) throws DAOException {
		String mrnChk = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMrnCreateInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMrnCheckRSQL(), param, velParam);
			if(dbRowset.next()) mrnChk = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mrnChk;
	}

	/**
	 * MRN NO 로 VVD CHECK
	 * @param KorMrnCreateInfoVO korMrnCreateInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMrnInfoByMrn(KorMrnCreateInfoVO korMrnCreateInfoVO) throws DAOException {
		String vvd=null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMrnCreateInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMrnInfoByMRNRSQL(), param, velParam);
			if(dbRowset.next()) vvd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvd;
	}

	/**
	 * Vessel Port Skd 정보 조회
	 * @param KorMrnCreateInfoVO korMrnCreateInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchVslSkdInfo(KorMrnCreateInfoVO korMrnCreateInfoVO) throws DAOException {
		String vvd=null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMrnCreateInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchVslSkdInfoRSQL(), param, velParam);
			if(dbRowset.next()) vvd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvd;
	}

	/**
	 * B/L Info 추가Data 가져오기 위해 Vessel정보를 추가로 조회
	 * @param KorVslCondVO korVslCondVO
	 * @return KorVslVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorVslVO searchVSLInfoInBKG(KorVslCondVO korVslCondVO) throws DAOException {
		KorVslVO korVslVO = null;
		List<KorVslVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korVslCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchVSLInfoInBKGRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorVslVO.class);
			if (list!=null && list.size() > 0) korVslVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korVslVO;
	}

	/**
	 * 한국세관의 VVD Table로 Download된 상태를 조회한다.
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return BkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrVvdSmryVO searchMrnNoKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException {
		BkgCstmsKrVvdSmryVO outVO = null;
		List<BkgCstmsKrVvdSmryVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMrnNoKorRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrVvdSmryVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return outVO;
	}

	/**
	 * BL 정보를 조회
	 * @param KorAmdBlInfoVO korAmdBlInfoVO
	 * @return KorAmdBlInfoVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorAmdBlInfoVO[] searchAmdBlInfoKor(KorAmdBlInfoVO korAmdBlInfoVO) throws DAOException {
		KorAmdBlInfoVO[] korAmdBlInfoVOs = null;
		List<KorAmdBlInfoVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = korAmdBlInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchAmdBlInfoKorRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorAmdBlInfoVO.class);
			if (list.size() < 1) return null;
			korAmdBlInfoVOs = list.toArray(new KorAmdBlInfoVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korAmdBlInfoVOs;
	}

	/**
	 * Customer Information을 조회
	 * @param KorCustInfoCondVO custInfoCondVO
	 * @return KorCustInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCustInfoVO searchCustInfoKor(KorCustInfoCondVO custInfoCondVO) throws DAOException {
		KorCustInfoVO korCustInfoVO = null;
		List<KorCustInfoVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custInfoCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchCustInfoKorRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorCustInfoVO.class);
			if (list!=null && list.size() > 0) korCustInfoVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korCustInfoVO;
	}

	/**
	 * 송화인주소값 없을때 쓰던 '.'도 'N'으로 처리하기 위한 체크
	 * @param KorCustChkVO custChkVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCustInfoCheck(KorCustChkVO custChkVO) throws DAOException {
		String chkVal = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = custChkVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchCustInfoCheckRSQL(), param, velParam);
			if(dbRowset.next()) chkVal = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chkVal;
	}

	/**
	 * 한국세관 BKG No별 CNTR Total Count를 조회
	 * @param KorCntrInfoCondVO cntrInfoCondVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCNTRTtlCntKor(KorCntrInfoCondVO cntrInfoCondVO) throws DAOException {
		String cnt = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrInfoCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchCNTRTtlCntKorRSQL(), param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * O/B Local (= 'E')이면서 Simple B/L일 경우 한국세관 Elno Table에서 Data조회(Trans='E' & B/L Type = Simple)
	 * @param KorElnoInfoCondVO elnoInfoCondVO
	 * @return KorElnoInfoCondVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorElnoInfoCondVO searchExportCntKor(KorElnoInfoCondVO elnoInfoCondVO) throws DAOException {
		KorElnoInfoCondVO korElnoInfoCondVO = null;
		List<KorElnoInfoCondVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = elnoInfoCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchExportCntKorRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorElnoInfoCondVO.class);
			if (list!=null && list.size() > 0) korElnoInfoCondVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korElnoInfoCondVO;
	}

	/**
	 * FLATFILE 헤더 생성
	 * @param KorDiscFlatFileVO discFlatFileVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeDiscHeadFlatFile(KorDiscFlatFileVO discFlatFileVO) throws DAOException {
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = discFlatFileVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeDiscHeadFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}

	/**
	 * Transmit시 BL FlatFile 의 BODY 부분 추출
	 * @param KorDiscFlatFileVO discFlatFileVO
	 * @return KorDiscFlatFileVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDiscFlatFileVO[] makeDiscBodyFlatFile(KorDiscFlatFileVO discFlatFileVO) throws DAOException {
		KorDiscFlatFileVO[] korDiscFlatFileVOs = null;
		List<KorDiscFlatFileVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = discFlatFileVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeDiscBodyFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDiscFlatFileVO.class);
			if (list.size() < 1) return null;
			korDiscFlatFileVOs = list.toArray(new KorDiscFlatFileVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korDiscFlatFileVOs;

	}

	/**
	 * Container FlatFile 생성
	 * @param KorDiscFlatFileVO discFlatFileVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] makeDiscCntrFlatFile(KorDiscFlatFileVO discFlatFileVO) throws DAOException {
		String[] cntrDatas = null;
		List<String> list = new ArrayList<String>();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = discFlatFileVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeDiscCntrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			cntrDatas = list.toArray(new String[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrDatas;
	}

	/**
	 * BKG_CSTMS_KR_SND_LOG 테이블에 CNTR의 Type Size count정보를 남기기위해서 조회
	 * @param KorCntrCntVO cntrCntVO
	 * @return KorCntrCntVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntrCntVO searchTeuFeuCnt(KorCntrCntVO cntrCntVO) throws DAOException {
		KorCntrCntVO korCntrCntVO = null;
		List<KorCntrCntVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cntrCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchTeuFeuCntRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntrCntVO.class);
			if (list!=null && list.size() > 0) korCntrCntVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korCntrCntVO;
	}

	/**
	 * FLAT FILE의 마지막 END 부분 생성
	 * @return
	 * @exception DAOException
	 */
	public String makeDiscEndFlatFile() throws DAOException {
		String endData = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeDiscEndFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) endData = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return endData;
	}

	/**
	 *  TEU, FEU CNTR Type Size Count를 Update
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void modifyDiscSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOmodifyDiscSndLogUSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CUSREP Flat File Header를 만든다.
	 * @param KorCusrepVO cusrepVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSREPFlatFile(KorCusrepVO cusrepVO) throws DAOException {
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cusrepVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeCUSREPFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}

//↓↓↓↓↓↓↓↓↓↓/////////////////////////// (3G용 임시)
	/**
	 * CUSREP Flat File Header를 만든다.
	 * @param KorCusrepVO cusrepVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSREPFlatFile3G(KorCusrepVO cusrepVO) throws DAOException {
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cusrepVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeCUSREPFlatFile3GRSQL(), param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}

	/**
	 * 공동 VVD 용 CUSREP Flat File Header를 만든다.
	 * @param KorCusrepVO cusrepVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSREPNoneBLVVDFlatFile3G(KorCusrepVO cusrepVO) throws DAOException {
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cusrepVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeCUSREPNoneBlVVDFlatFile3GRSQL(), param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}
//↑↑↑↑↑↑↑↑↑↑/////////////////////////// (3G용 임시)

	/**
	 * 공동 VVD 용 CUSREP Flat File Header를 만든다.
	 * @param KorCusrepVO cusrepVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSREPNoneBLVVDFlatFile(KorCusrepVO cusrepVO) throws DAOException {
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cusrepVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeCUSREPNoneBlVVDFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}

	/**
	 * CUSMAN 의 BL Info Flat File을 만든다.
	 * @param KorCusmanVO cusmanVO
	 * @return KorCusmanVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCusmanVO[] makeCUSMANBlFlatFile(KorCusmanVO cusmanVO) throws DAOException {
		KorCusmanVO[] korCusmanVOs = null;
		List<KorDiscFlatFileVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusmanVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCUSMANBlFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCusmanVO.class);
			if (list.size() < 1) return null;
			korCusmanVOs = list.toArray(new KorCusmanVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korCusmanVOs;
	}

	/**
	 * Export License Flat File 생성
	 * @param KorCusmanVO cusmanVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] makeCUSMANExpFlatFile(KorCusmanVO cusmanVO) throws DAOException {
		String[] elDatas = null;
		List<String> list = new ArrayList<String>();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusmanVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			elDatas = list.toArray(new String[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return elDatas;
	}

	/**
	 * CUSMAN의 CNTR정보에 대한 Flat file을 만든다.
	 * @param KorCusmanVO cusmanVO
	 * @return String
	 * @exception DAOException
	 */
	public String[] makeCUSMANCntrFlatFile(KorCusmanVO cusmanVO) throws DAOException {
		String[] cntrDatas = null;
		List<String> list = new ArrayList<String>();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusmanVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCUSMANCntrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			cntrDatas = list.toArray(new String[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrDatas;
	}

	/**
	 * TEU, FEU CNTR Type Size Count를 Update한다.
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void modifyCUSREPSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOmodifyCUSREPSndLogUSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MACAMD Flatfile을 만든다. (HEADER)
	 * @param KorMacamdVO macamdVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeMACAMDFlatFile(KorMacamdVO macamdVO) throws DAOException {
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = macamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeMACAMDFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}

	/**
	 * 정정부호 전송내역 FlatFile 생성
	 * @param KorCorrVO corrVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCorrFlatFile(KorCorrVO corrVO) throws DAOException {
		String corrData = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = corrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCorrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next())  corrData = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return corrData;
	}

	/**
	 * 전송 되었던 정정신고인지 다시 확인
	 * @param String subNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchTransmitChk(String subNo) throws DAOException {
		String transChk = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchTransmitChkRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) transChk = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return transChk;
	}

	/**
	 * 329 화면에서 삭제 전송시 SEND 여부 확인
	 *
	 * @param KorSndChkVO sndChkVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSndChk(KorSndChkVO sndChkVO) throws DAOException {
		String sndChk = "N";
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = sndChkVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchSndChkRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) sndChk = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sndChk;
	}

	/**
	 * 사용자 ID로 사용자 이름 조회
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	public String searchComUser(String userId) throws DAOException {
		String userName = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchComUserRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) userName = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return userName;
	}

	/**
	 * CUSMOD FlatFile 생성
	 * @param KorCusmodVO cusmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSMODBlFlatFile(KorCusmodVO cusmodVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCUSMODBlFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * CUSMOD 전송 로그 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addCUSMODSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddCUSMODSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CUSMOD Export Lic FlatFile 생성
	 * @param KorCusmodVO cusmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSMODExpFlatFile(KorCusmodVO cusmodVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCUSMODExpFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * CUSMOD Container FlatFile 생성
	 * @param KorCusmodVO cusmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSMODCntrFlatFile(KorCusmodVO cusmodVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCUSMODCntrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * CUSMOD BL Info Crrection FlatFile 생성
	 * @param KorCusmodVO cusmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSMODBlCorrFlatFile(KorCusmodVO cusmodVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCUSMODBlCorrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * 전송여부 CHECK
	 * @param String bkgNo
	 * @param String ktPort
	 * @param String kcdTp
	 * @return String
	 * @exception DAOException
	 */
	public String searchTransndChk(String bkgNo, String ktPort, String kcdTp) throws DAOException {
		String transChk = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", 			bkgNo);
			mapVO.put("port_cd", 			ktPort);
			mapVO.put("cstms_decl_tp_cd", 	kcdTp);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchTransndChkRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) transChk = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return transChk;
	}

	/**
	 * IMFMOD BL Flat File 생성
	 * @param KorImfmodVO imfmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeIMFMODBlFlatFile(KorImfmodVO imfmodVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = imfmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeIMFMODBlFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * IMFMOD 전송 로그 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addIMFMODSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddIMFMODSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * IMFMOD CNTR Flat File 생성
	 * @param KorImfmodVO imfmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeIMFMODCntrFlatFile(KorImfmodVO imfmodVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = imfmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeIMFMODCntrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * IMFMOD Correction Flat File 생성
	 * @param KorImfmodVO imfmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeIMFMODCorrFlatFile(KorImfmodVO imfmodVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = imfmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeIMFMODCorrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * MACAMD Flatfile 생성
	 * @param KorMacamdVO macamdVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeMACAMDAmdFlatFile(KorMacamdVO macamdVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = macamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			log.debug(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeMACAMDAmdFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * MACAMD Send Log를 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addMACAMDSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddMACAMDSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MACAMD CNTR Flat File 생성
	 * @param KorMacamdVO macamdVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeMACAMDAmdCntrFlatFile(KorMacamdVO macamdVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = macamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeMACAMDAmdCntrFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * MACAMD CORR Flat File 생성
	 * @param KorMacamdVO macamdVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeMACAMDAmdCorrFlatFile(KorMacamdVO macamdVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = macamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeMACAMDAmdCorrFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * 위험화물반입신고(CARDGN) Flat File 전송을 위한 조회
	 * @param KorDgCgoVvdVO dgCgoVvdVO
	 * @return KorDgCgoVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDgCgoVvdVO makeCARDGNFlatFile(KorDgCgoVvdVO dgCgoVvdVO) throws DAOException {
		KorDgCgoVvdVO korDgCgoVvdVO = null;
		List<KorDgCgoVvdVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dgCgoVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeCARDGNFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorDgCgoVvdVO.class);
			if (list!=null && list.size() > 0) korDgCgoVvdVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korDgCgoVvdVO;
	}

	/**
	 * CARDGN전송내역을 Log에 남긴다.
	 * @param KorDgCgoVvdVO dgCgoVvdVO
	 * @exception DAOException
	 */
	public void addCARDGNSndLog(KorDgCgoVvdVO dgCgoVvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dgCgoVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddCARDGNSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * DGMNFT Flat file 생성
	 * @param KorDgmVvdVO dgmVvdVO
	 * @return KorDgCgoVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDgCgoVvdVO makeDGMNFTFlatFile(KorDgmVvdVO dgmVvdVO) throws DAOException {
		KorDgCgoVvdVO korDgCgoVvdVO = null;
		List<KorDgCgoVvdVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dgmVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeDGMNFTFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorDgCgoVvdVO.class);
			if (list!=null && list.size() > 0) korDgCgoVvdVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korDgCgoVvdVO;

	}

	/**
	 * DGMNFT Send log를 남긴다.
	 * @param KorDgmVvdVO dgmVvdVO
	 * @exception DAOException
	 */
	public void addDGMNFTSndLog(KorDgmVvdVO dgmVvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dgmVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddDGMNFTSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 컨테이너별 Cargo Seq + 1 조회
	 * @param BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchDgCgoSeq(BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO) throws DAOException {
		String dgCgoSeq = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsKrDgCgoVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchDgCgoSeqRSQL(), param, velParam);
			if(dbRowset.next()) dgCgoSeq = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dgCgoSeq;
	}

	/**
	 * DGMNFT Cntr flat file 생성
	 * @param KorDgmCntrVO dgmCntrVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] makeDGMNFTCNTRInfo(KorDgmCntrVO dgmCntrVO) throws DAOException {
		String[] flatFiles = null;
		List<String> list = new ArrayList<String>();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dgmCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeDGMNFTCNTRInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			flatFiles = list.toArray(new String[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFiles;
	}

	/**
	 * MRN Create EDI 전송용 헤더 생성
	 * @param KorMFTVO korMFTVO
	 * @return KorMFTVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMFTVO makeKorMFTHeader(KorMFTVO korMFTVO) throws DAOException {
		KorMFTVO outVO = null;
		List<KorMFTVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korMFTVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeKorMFTHeaderRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorMFTVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return outVO;
	}

	/**
	 * Local Manifest Data로 EDI전송을 위한 Main Flat File을 생성 (BODY 부분)
	 * @param KorIbManifestVO ibManifestVO
	 * @return KorIbManifestVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorIbManifestVO[] makeKorMFTBodyFile(KorIbManifestVO ibManifestVO) throws DAOException {
		KorIbManifestVO[] korIbManifestVOs = null;
		List<KorIbManifestVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ibManifestVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeKorMFTBodyFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorIbManifestVO.class);
			if (list.size() < 1) return null;
			korIbManifestVOs = list.toArray(new KorIbManifestVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korIbManifestVOs;
	}

	/**
	 * Amendment Submit No 조회
	 * @param KorAmdNoVO amdNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSmtAmdNo(KorAmdNoVO amdNoVO) throws DAOException {
		String smtAmdNo = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = amdNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchSmtAmdNoRSQL(), param, velParam);
			if(dbRowset.next()) smtAmdNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return smtAmdNo;
	}

	/**
	 * Amendment Transmission to Korean Customs 정정 내용 출력 화면을 위한 조회
	 * @param KorAmdTransVO amdTransVO
	 * @return KorAmdTransVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorAmdTransVO[] searchAmdTransmitDataList(KorAmdTransVO amdTransVO) throws DAOException {
		KorAmdTransVO[] korAmdTransVOs = null;
		List<KorAmdTransVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = amdTransVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchAmdTransmitDataListRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorAmdTransVO.class);
			if (list.size() < 1) return null;
			korAmdTransVOs = list.toArray(new KorAmdTransVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korAmdTransVOs;
	}

	/**
	 * 응답메시지 수신에 앞서서 Seq값의 Max + 1 값을 조회
	 * @param String flatNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchCstmMaxAckSeq(String flatNo) throws DAOException {
		String maxRcvSeq = "1";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("flt_file_ref_no", flatNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchCstmMaxAckSeqRSQL(), param, velParam);
			if(dbRowset.next()) maxRcvSeq = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return maxRcvSeq;
	}

	/**
	 * 세관 응답메시지 INSERT
	 * @param KorAckMsgVO ackMsgVO
	 * @exception DAOException
	 */
	public void addCstmAckMsg(KorAckMsgVO ackMsgVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ackMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddCstmAckMsgCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 컨테이너 번호 목록 조회
	 *
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return KorCntrNoKorVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntrNoKorVO[] searchCntrNoKorList(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException {
		KorCntrNoKorVO[] korCntrNoKorVOs = null;
		List<KorCntrNoKorVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOsearchCntrNoKorListRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntrNoKorVO.class);
			if (list.size() < 1) return null;
			korCntrNoKorVOs = list.toArray(new KorCntrNoKorVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korCntrNoKorVOs;
	}

	/**
	 * Empty B/L Type 정정에 대한 IMFMOD Flat File 생성
	 * @param KorEmpImfmodVO empImfModVO
	 * @return KorEmpImfmodVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorEmpImfmodVO makeAutoIMFMODFlatFile(KorEmpImfmodVO empImfModVO) throws DAOException {
		KorEmpImfmodVO korEmpImfmodVO = null;
		List<KorEmpImfmodVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = empImfModVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeAutoIMFMODFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorEmpImfmodVO.class);
			if (list!=null && list.size() > 0) korEmpImfmodVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korEmpImfmodVO;
	}

	/**
	 * Send Log 의 Max Seq+1 조회
	 *
	 * @param String logDate
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxImfSndLogSeq(String logDate, String ofcCd) throws DAOException {
		String maxSeq = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("log_date", logDate);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMaxImfSndLogSeqRSQL(), param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return maxSeq;
	}

	/**
	 * 단일항목 정정 FlatFile 생성
	 * @return String
	 * @throws DAOException
	 */
	public String makeAutoIMFMODCorrFlatFile() throws DAOException {
		String corrData = "";
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeAutoIMFMODCorrFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) corrData = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return corrData;
	}

	/**
	 * Empty B/L Type 정정에 대한 MACAMD Flat File 생성
	 *
	 * @param KorEmpMacamdVO empMacamdVO
	 * @return KorEmpMacamdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorEmpMacamdVO makeAutoMACAMDFlatFile(KorEmpMacamdVO empMacamdVO) throws DAOException {
		KorEmpMacamdVO korEmpMacamdVO = null;
		List<KorEmpMacamdVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = empMacamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeAutoMACAMDFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, KorEmpMacamdVO.class);
			if (list!=null && list.size() > 0) korEmpMacamdVO = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korEmpMacamdVO;
	}

	/**
	 * MAC Send Log 의 Max Seq+1 조회
	 *
	 * @param String sndDt
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxMacSndLogSeq(String sndDt, String ofcCd) throws DAOException {
		String maxSeq = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("snd_dt", sndDt);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMaxMacSndLogSeqRSQL(), param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return maxSeq;
	}

	/**
	 * Master LOG Table로 전송일, VVD, B/L Info. 저장
	 *
	 * @param KorAutoMacSndVO autoMacSndVO
	 * @throws DAOException
	 */
	public void addAutoMACAMDSndLog(KorAutoMacSndVO autoMacSndVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		try {
			mapVO = autoMacSndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddAutoMACAMDSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 단일항목 정정 FlatFile 생성
	 * @return String
	 * @throws DAOException
	 */
	public String makeAutoMACAMDCorrFlatFile() throws DAOException {
		String corrData = "";
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeAutoMACAMDCorrFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) corrData = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return corrData;
	}

	/**
	 * CUSMAN FlatFile 의 MULTI Seal Number 조회
	 *
	 * @param KorCusmanVO cusmanVO
	 * @return String
	 * @throws DAOException
	 */
	public String makeCUSMANSealFlatFile(KorCusmanVO cusmanVO) throws DAOException {
		String sealNumbers = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusmanVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustomsTransmissionDBDAOmakeCUSMANSealFlatFileRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) sealNumbers = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sealNumbers;
	}

	/**
	 * 하선신고 정정 및 추가 신고 (CUSDMR) FlatFile 생성
	 * @param KorCusdmrVO cusdmrVO
	 * @return String
	 * @throws DAOException
	 */
	public String makeCUSDMRFlatFile(KorCusdmrVO cusdmrVO) throws DAOException {
		String flatFile = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cusdmrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeCUSDMRFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) flatFile = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}

	/**
	 * CUSDMR 전송 로그 기록
	 *
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @throws DAOException
	 */
	public void addCUSDMRSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddCUSDMRSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Submit No 생성
	 * @param KorMakeSubNoVO makeSubNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMakeSubNo(KorMakeSubNoVO makeSubNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String subNo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = makeSubNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMakeSubNoRSQL(), param, velParam);
			if (dbRowset.next()) subNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return subNo;
	}

	/**
	 *Transit Cross-Check 정보를 조회한다.<br>
	 *
	 * @param  KorTransCrossChkCondVO korTransCrossChkCondVO
	 * @return List<KorTransCrossChkDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorTransCrossChkDtlVO> searchTransCrossChk(KorTransCrossChkCondVO korTransCrossChkCondVO) throws DAOException {
		List<KorTransCrossChkDtlVO> list = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korTransCrossChkCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchTransCrossChkRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,KorTransCrossChkDtlVO.class);
		} catch (SQLException se) {
			log.error(se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * CUSREP Flat File Header를 만든다.
	 * @param KorTransCancellCustVO korTransCancellCustVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeKRTransCancelFlatFile(KorTransCancellCustVO korTransCancellCustVO) throws DAOException {
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = korTransCancellCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOmakeKRTransCancellFlatFileRSQL(), param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}

	/**
	 * PORTAL 전송 로그 기록
	 *
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @throws DAOException
	 */
	public void addPORTALSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new KorCustomsTransmissionDBDAOaddPORTALSndLogCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PORTAL 전송 Seq값의 Max + 1 값을 조회
	 *
	 * @param String sndDt
	 * @param String ofcCd
	 * @return maxSeq
	 * @throws DAOException
	 */
	public String searchMaxPortalSndSeq(String sndDt, String ofcCd) throws DAOException {
		String maxSeq = "";
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("snd_dt", sndDt);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KorCustomsTransmissionDBDAOsearchMaxPortalSndLogSeqRSQL(), param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return maxSeq;
	}

	   /**
	 * DEL_CD 가져오는 쿼리 .
	 *
	 *
	 * @param String vvdCd
	 * @param String polCd
	 * @return String flg
	 * @exception DAOException
	 */
	public String searchDelCd(String vvdCd, String polCd) throws DAOException {
		// input_text
		String flg = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd_cd", vvdCd);
			velParam.put("vvd_cd", vvdCd);
			param.put("pol_cd", polCd);
			velParam.put("pol_cd", polCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			KorCustomsTransmissionDBDAOsearchDelCdRSQL template = new KorCustomsTransmissionDBDAOsearchDelCdRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);


			if (dbRowset.next()) {
				flg = dbRowset.getString("del_cd");
			} else {
				flg = "";
			}


		} catch(SQLException ex) {
			// log.error(se.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			// log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flg;
	}


}