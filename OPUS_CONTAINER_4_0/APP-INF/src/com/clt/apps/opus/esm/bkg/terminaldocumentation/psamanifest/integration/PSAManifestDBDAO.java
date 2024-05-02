/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : PSAManifestDBDAO.java
*@FileTitle : PSAManifestDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier :
*@LastVersion : 1.0
* 2009. 9. 4.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.BkgCstmsPsaCntrChkVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.BkgDataVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.BkgVvdInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.BkgXterVgmVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.CntrNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.CntrSpeCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.ImpStsSpclCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.NameEtdVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaAddVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaAwkCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrFlatVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrNewVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgForYardVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgIfVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgQtyVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdCntrTpszVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVslVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgvvdInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrCntVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrForYardVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaHeadVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaIbManifestVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestCmInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestCntrInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestCntrSealNoInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestDgGoodsInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestMarkInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestVslInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaMaxSubSrlNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaNextVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRfCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsForYardVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdCntrQtyVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdQtyVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdSerNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdSubSerNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRoCntrQtyVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSerNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaShprVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSndDtVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSrlNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSubSrlNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBKGVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBkgCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchCNTRVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchPsaCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsSgpSndLogVO;

/**
 * PSA Manifest 업무의 Business Logic 처리를 위한 JDBC 작업 수행
 *
 * @author
 * @see PSAManifestBCImpl 참조
 * @since J2EE 1.6
 *
 */
public class PSAManifestDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 5184706835600062011L;

	/**
	 * PSA Vessel 정보 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return List<PsaVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaVvdVO> searchPSAVslRegist(PsaVvdVO psaVvdVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVslRegistRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaVvdVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Vsl Code 로 Vsl Name 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPSAVslName(PsaVvdVO psaVvdVO) throws DAOException {
		String psaVslNm = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVslNameRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) psaVslNm = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaVslNm;
	}

	/**
	 * VESSEL PORT SCHEDULE VALIDATION CHECK
	 * @param String vslCd
	 * @param String voyNo
	 * @param String dirCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslPortSkdValidCheck(String vslCd, String voyNo, String dirCd) throws DAOException {
		String cnt = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("vsl_cd", 	vslCd);
			mapVO.put("skd_voy_no", voyNo);
			mapVO.put("skd_dir_cd", dirCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchVslPortSkdValidCheckRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
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
	 *  PSA VVD Validation check
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPSAVVDValidCheck(PsaVvdVO psaVvdVO) throws DAOException {
		String cnt = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVVDValidCheckRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
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
	 * PSA VVD 정보 추가
	 * @param PsaVvdVO psaVvdVO
	 * @throws DAOException, Exception
	 */
	public void addPSAVVDInfo(PsaVvdVO psaVvdVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPSAVVDInfoCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA VVD 정보 수정
	 * @param PsaVvdVO psaVvdVO
	 * @throws DAOException, Exception
	 */
	public void modifyPSAVVDInfo(PsaVvdVO psaVvdVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPSAVVDInfoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA 기 전송여부 체크
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPSASendValidCheck(PsaVvdVO psaVvdVO) throws DAOException {
		String cnt = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSASendValidCheckRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
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
	 * PSA VVD Data 삭제
	 * @param PsaVvdVO psaVvdVO
	 * @throws DAOException, Exception
	 */
	public void removePSAVVDInfo(PsaVvdVO psaVvdVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremovePSAVVDInfoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Target Port에 일정기간내 접안 예정 스케줄의 VVD를 조회한다.
	 * @param PsaVvdVO psaVvdVO
	 * @return List<PsaVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaVvdVO> searchPSAVVD(PsaVvdVO psaVvdVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVVDRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaVvdVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Container Booking I/F History 조회
	 * @param PsaBkgVO psaBkgVO
	 * @return PsaBkgVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgVO[] searchPSACNTRBKGHist(PsaBkgVO psaBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaVvdVO> list = null;
		PsaBkgVO[] psaBkgVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaBkgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSACNTRBKGHistRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgVO.class);
			if (list!=null && list.size() > 0) psaBkgVOs = list.toArray(new PsaBkgVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaBkgVOs;
	}

	/**
	 * PSA Container Booking I/F Status Log 조회
	 * @param String bkgNo
	 * @param String psaSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchPSAStatusLog(String bkgNo, String psaSeq) throws DAOException {
		String statusLog = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", psaSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAStatusLogRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) statusLog = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return statusLog;
	}

	/**
	 * EDI전송을 위해 Yard Code를 PSA Port로 Coversion을 위해 PSA Port조회
	 * @param String portCd
	 * @return PsaPortVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaPortVO[] searchPSAPortList(String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaPortVO> list = null;
		PsaPortVO[] psaPortVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", portCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAPortListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaPortVO.class);
			if (list!=null && list.size() > 0) psaPortVOs = list.toArray(new PsaPortVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaPortVOs;
	}

	/**
	 * PSA Import Status Count 조회
	 * @param PsaImpStsVO psaImpStsVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPSATpCnt(PsaImpStsVO psaImpStsVO) throws DAOException {
		String cnt = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSATpCntRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
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
	 * PSA VSL Name과 Voyage Dir을 조회
	 * @param String vvd
	 * @return PsaVvdVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaVvdVO searchPSAVslNameDir(String vvd) throws DAOException {
		PsaVvdVO psaVvdVO = new PsaVvdVO();
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVslNameDirRSQL(), param, null);
			List<PsaVvdVO> psaVvdVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaVvdVO.class);
			if (psaVvdVOList.size() > 0) psaVvdVO = psaVvdVOList.get(0);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaVvdVO;
	}

	/**
	 * PSA Import Status List조회
	 * @param PsaImpStsVO psaImpStsVO
	 * @return PsaImpStsVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaImpStsVO[] searchPSAImpStsInfoList(PsaImpStsVO psaImpStsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaImpStsVO> list = null;
		PsaImpStsVO[] psaImpStsVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAImpStsInfoListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaImpStsVO.class);
			if (list!=null && list.size() > 0) psaImpStsVOs = list.toArray(new PsaImpStsVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaImpStsVOs;
	}

	/**
	 * BKG에서 Add된 CNTR을 조회
	 * @param PsaAddVO psaAddVO
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchPSAAddCNTRList(PsaAddVO psaAddVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		String[] cntrNOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaAddVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAAddCNTRListRSQL(), param, velParam);
			while(dbRowset.next()) list.add(dbRowset.getString(1));
			cntrNOs = list.toArray(new String[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrNOs;
	}

	/**
	 * searchAddCNTRList에서 추가된 정보에 대해서 BKG에서 PSA정보를 조회 (리스트)
	 * @param PsaImpStsVO psaImpStsVO
	 * @return PsaImpStsVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaImpStsVO[] searchPSAImpStsInfoAddList(PsaImpStsVO psaImpStsVO) throws DAOException {
		List<PsaImpStsVO> list = null;
		PsaImpStsVO[] psaImpStsVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL(), param, velParam);
			if (dbRowset != null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaImpStsVO.class);
			if (list != null && list.size() > 0) psaImpStsVOs = list.toArray(new PsaImpStsVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaImpStsVOs;
	}

	/**
	 * Container Validation Check
	 * @param String vslCd
	 * @param String voyNo
	 * @param String voyDir
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCNTRCount(String vslCd, String voyNo, String voyDir, String cntrNo) throws DAOException {
		String cnt = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", voyNo);
			mapVO.put("skd_dir_cd", voyDir);
			mapVO.put("cntr_no", cntrNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchCNTRCountRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
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
	 * Vessel Count Validation Check
	 * @param String vslCd
	 * @param String voyNo
	 * @param String voyDir
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslCount(String vslCd, String voyNo, String voyDir) throws DAOException {
		String cnt = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", voyNo);
			mapVO.put("skd_dir_cd", voyDir);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchVslCountRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
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
	 * PSA Import Status 신규 Insert
	 * @param PsaImpStsVO psaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void addPSAImpStsInfo(PsaImpStsVO psaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPSAImpStsInfoCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status Update
	 * @param PsaImpStsVO psaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void modifyPSAImpStsInfo(PsaImpStsVO psaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPSAImpStsInfoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status Special Cargo의 Stowage ID를 수정
	 * @param PsaImpStsVO psaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void modifyStwgIdOfImpStsSpclCgo(PsaImpStsVO psaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyStwgIdOfImpStsSpclCgoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status 정보 삭제
	 * @param PsaImpStsVO psaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void removePSAImpStsInfo(PsaImpStsVO psaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremovePSAImpStsInfoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status Special Cargo 정보를 삭제
	 * @param PsaImpStsVO psaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void removePSAImpStsSpclInfo(PsaImpStsVO psaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremovePSAImpStsSpclInfoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status Special Cargo의 정보를 조회
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ImpStsSpclCgoVO searchPSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ImpStsSpclCgoVO> list = null;
		ImpStsSpclCgoVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAImpStsSpclCgoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImpStsSpclCgoVO.class);
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
	 * PSA Import Status Special Cargo의 정보를 BKG과 Special Cargo 테이블에서 조회
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ImpStsSpclCgoVO searchBKGImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ImpStsSpclCgoVO> list = null;
		ImpStsSpclCgoVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImpStsSpclCgoVO.class);
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
	 * PSA Import Status Special Cargo정보를 신규로 생성
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @throws DAOException, Exception
	 */
	public void addPSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPSAImpStsSpclCgoCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status Special Cargo정보를 수정
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @throws DAOException, Exception
	 */
	public void modifyPSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPSAImpStsSpclCgoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status의 Stowage ID를 수정
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @throws DAOException, Exception
	 */
	public void modifyStwgIdOfImpSts(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyStwgIdOfImpStsUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status Special Cargo정보를 삭제
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @throws DAOException, Exception
	 */
	public void removePSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremovePSAImpStsSpclCgoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Data로 Flat File Header를 조회
	 * @param PsaImpStsVO psaImpStsVO
	 * @return PsaHeadVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaHeadVO searchPSAHeadFlatFile(PsaImpStsVO psaImpStsVO) throws DAOException {
		List<PsaHeadVO> list = null;
		PsaHeadVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAHeadFlatFileRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaHeadVO.class);
			if (list != null && list.size() > 0) outVO = list.get(0);
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
	 * PSA CNTR Information을 조회
	 * @param PsaImpStsVO psaImpStsVO
	 * @return List<PsaCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaCntrVO> searchPSACNTRInfoFlatFile(PsaImpStsVO psaImpStsVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSACNTRInfoFlatFileRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaCntrVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_XTER_VGM Information을 조회
	 * @param PsaCntrVO psaCntrVO
	 * @return List<BkgXterVgmVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgXterVgmVO> searchBkgXterVgmInfo(PsaCntrVO psaCntrVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgXterVgmInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterVgmVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status Send date를 기록한다.
	 * @param PsaImpStsVO psaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void modifyPSAImpStsSndInfo(PsaImpStsVO psaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPSAImpStsSndInfoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA PORT에 데이터가 기 존재하는지 여부 check
	 * @param String locCd
	 * @param String tmlCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchPSAPortExistChk(String locCd, String tmlCd) throws DAOException {
		String chk = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("loc_cd", locCd);
			mapVO.put("tml_cd", tmlCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAPortExistChkRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) chk = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chk;
	}

	/**
	 * PSA Port에 대한 신규추가
	 * @param PsaPortVO psaPortVO
	 * @throws DAOException, Exception
	 */
	public void addPSAPortList(PsaPortVO psaPortVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaPortVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPSAPortListCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Port  Update한다. Grid상에서 Row가 신규추가가 아니면서 화면상의 변경이 일어날 경우 modify한다.
	 * @param PsaPortVO psaPortVO
	 * @throws DAOException, Exception
	 */
	public void modifyPSAPortList(PsaPortVO psaPortVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaPortVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPSAPortListUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Port Data 삭제처리
	 * @param PsaPortVO psaPortVO
	 * @throws DAOException, Exception
	 */
	public void removePSAPortList(PsaPortVO psaPortVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaPortVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremovePSAPortListDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ETD Date에  Relay Port를 경유하는 VVD조회
	 *
	 * @param String portCd
	 * @param String etdDt
	 * @param String transTp
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchPSATsVVDList(String portCd, String etdDt, String transTp) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		String[] vvds = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rly_port", portCd);
			mapVO.put("etd_dt", etdDt);
			mapVO.put("trans_tp_cd", transTp);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSATsVVDListRSQL(), param, velParam);
			while(dbRowset.next()) list.add(dbRowset.getString(1));
			vvds = list.toArray(new String[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvds;
	}

	/**
	 * VSL Name과 ETD를 구한다.
	 * @param String vslCd
	 * @param String voyCd
	 * @param String dirCd
	 * @param String portCd
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public NameEtdVO searchPSAVslNameEtd(String vslCd, String voyCd, String dirCd, String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<NameEtdVO> list = null;
		NameEtdVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vslCd + voyCd + dirCd);
			mapVO.put("port_cd", portCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVslNameEtdRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, NameEtdVO.class);
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
	 * OPUS와 PSA가 Unmatch되는 CNTR List를 조회
	 * @param PsaUnmatchCNTRVO psaUnmatchCNTRVO
	 * @return CntrNoVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CntrNoVO[] searchUnmatchCNTRList(PsaUnmatchCNTRVO psaUnmatchCNTRVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrNoVO> list = null;
		CntrNoVO[] cntrNoVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaUnmatchCNTRVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchCNTRListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrNoVO.class);
			if (list!=null && list.size() > 0) cntrNoVOs = list.toArray(new CntrNoVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrNoVOs;
	}

	/**
	 * searchUnmatchCNTRList에서 조회된 CNTR No를 인자값으로 하여 Unmatch된 BKG List를 조회
	 * @param PsaUnmatchBKGVO psaUnmatchBKGVO
	 * @return PsaUnmatchBKGVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaUnmatchBKGVO searchUnmatchBKGList(PsaUnmatchBKGVO psaUnmatchBKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaUnmatchBKGVO> list = null;
		PsaUnmatchBKGVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaUnmatchBKGVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchBKGListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaUnmatchBKGVO.class);
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
	 * searchUnmatchBKGList에서 special Dg Cargo 가 있을 경우(=> spe_dg_ind = '1') 상세정보 조회
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchPSADGDetailInfo(String bkgNo, String cntrNo) throws DAOException {
		StringBuilder dgDetail = new StringBuilder();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo );
			mapVO.put("cntr_no", cntrNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSADGDetailInfoRSQL(), param, velParam);
			if (dbRowset!=null) {
				while(dbRowset.next()) {
					if (dgDetail.toString().length() > 0) dgDetail.append(", ");
					dgDetail.append(dbRowset.getString(1));
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dgDetail.toString();
	}

	/**
	 * searchUnmatchCNTRList에서 조회된 CNTR No를 인자값으로 하여 Unmatch PSA List를 조회
	 * @param BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO
	 * @return BkgCstmsPsaCntrChkVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgCstmsPsaCntrChkVO searchUnmatchPSAList(BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsPsaCntrChkVO> list = null;
		BkgCstmsPsaCntrChkVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsPsaCntrChkVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchPSAListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsPsaCntrChkVO.class);
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
	 * Unmatch하는 BKG CNTR정보를 조회한다. (OPUS 탭 Grid)
	 * @param PsaUnmatchBkgCntrVO psaUnmatchBkgCntrVO
	 * @return PsaUnmatchBkgCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaUnmatchBkgCntrVO[] searchUnmatchBkgCntrList(PsaUnmatchBkgCntrVO psaUnmatchBkgCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaUnmatchBkgCntrVO> list = null;
		PsaUnmatchBkgCntrVO[] psaUnmatchBkgCntrVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaUnmatchBkgCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchBkgCntrListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaUnmatchBkgCntrVO.class);
			if (list!=null && list.size() > 0) psaUnmatchBkgCntrVOs = list.toArray(new PsaUnmatchBkgCntrVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaUnmatchBkgCntrVOs;
	}

	/**
	 * Unmatch하는 PSA CNTR List를 조회한다. (PSA 탭 Grid)
	 * @param PsaUnmatchPsaCntrVO psaUnmatchPsaCntrVO
	 * @return PsaUnmatchPsaCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaUnmatchPsaCntrVO[] searchUnmatchPSACntrList(PsaUnmatchPsaCntrVO psaUnmatchPsaCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaUnmatchPsaCntrVO> list = null;
		PsaUnmatchPsaCntrVO[] psaUnmatchPsaCntrVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaUnmatchPsaCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchPSACntrListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaUnmatchPsaCntrVO.class);
			if (list!=null && list.size() > 0) psaUnmatchPsaCntrVOs = list.toArray(new PsaUnmatchPsaCntrVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaUnmatchPsaCntrVOs;
	}

	/**
	 * Vessel SKD에 등록되어있는지 여부 확인
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslSkdValid(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String valid = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchVslSkdValidRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) {
				valid = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return valid;
	}

	/**
	 * VVD + Relay Port에 해당하는 Data Delete
	 * @param BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO
	 * @throws DAOException, Exception
	 */
	public void removeUnmatchPSAList(BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsPsaCntrChkVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremoveUnmatchPSAListDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Un Code로 들어오는 Location은 OPUS Code로 Coversion 하기 위한 체크
	 * @param String locCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCodeConvLoc(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		String valid = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("port_cd", locCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchCodeConvLocRSQL(), param, velParam);
			if (dbRowset!=null &&	dbRowset.next()) valid = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return valid;
	}

	/**
	 * Un Code로 들어오는 Location은 OPUS Code로 Coversion
	 * @param String unLocCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCodeConvUNLoc(String unLocCd) throws DAOException {
		DBRowSet dbRowset = null;
		String locCd = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("port_cd", unLocCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchCodeConvUNLocRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) locCd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return locCd;
	}

	/**
	 * PSA List 추가
	 * @param BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO
	 * @throws DAOException, Exception
	 */
	public void addUnmatchPsaList(BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsPsaCntrChkVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddUnmatchPsaListCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 사용자 이름 조회
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String searchComUser(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		String usrNm = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_id", usrId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchComUserRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) usrNm = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return usrNm;
	}

	/**
	 * PSA Interface 정보 조회
	 * @param String bkgNo
	 * @return PsaBkgIfVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaBkgIfVO> searchPSAIFInfo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAIFInfoRSQL(), param, velParam, PsaBkgIfVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Interface 최종 정보 조회
	 * @param String bkgNo
	 * @return List<PsaBkgIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaBkgIfVO> searchPSAIFInfoLast(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchPSAIFInfoLastRSQL(), param, velParam, PsaBkgIfVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSAIFInfo 에서 조회값이 없을 경우 PSA Interface 재조회
	 * @param String bkgNo
	 * @return List<PsaBkgIfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaBkgIfVO> searchPSABKGIFInfo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSABKGIFInfoRSQL(), param, velParam, PsaBkgIfVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG VVD 에서 POL이 SSN 인 Vessel 정보 조회
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgNewVvd(String bkgNo) throws DAOException {
		String newVvd = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgNewVvdRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) newVvd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return newVvd;
	}

	/**
	 * PSA BKG 테이블의 SEQ+1 값 조회
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgMaxSeqPls(String bkgNo) throws DAOException {
		String pbSeq = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgMaxSeqPlsRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) pbSeq = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return pbSeq;
	}

	/**
	 * PSA BKG OLD VVD 조회
	 *
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgOldVvd(String bkgNo, String pbSeq) throws DAOException {
		String oldVvd = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("pb_seq", pbSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgOldVvdRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) oldVvd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return oldVvd;
	}

	/**
	 * PSA I/F BKG Code 를 D로 변경
	 *
	 * @param String bkgNo
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgIFCdD(String bkgNo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		//map VO
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgIFCdDUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA I/F Container Code 를 D로 변경
	 *
	 * @param String bkgNo
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgCntrIFCdD(String bkgNo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		//map VO
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgCntrIFCdDUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  PSA I/F RlseOrd Code 를 D로 변경
	 *
	 * @param String bkgNo
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgRlseOrdIFCd(String bkgNo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		//map VO
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgRlseOrdIFCdUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * OPUS 데이터로 PSA 데이터 생성
	 *
	 * @param String bkgNo
	 * @return BkgDataVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgDataVO searchBkgDataForPsaBkg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgDataVO> list = null;
		BkgDataVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDataVO.class);
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
	 * BLock Stowage Code 조회
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBlckStwgCd(String bkgNo) throws DAOException {
		String blckStwgCd = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBlckStwgCdRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) blckStwgCd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blckStwgCd;
	}

	/**
	 * BKG VVD 에서 Vessel 정보 조회
	 *
	 * @param String bkgNo
	 * @param String polCd
	 * @return BkgVvdInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgVvdInfoVO searchBkgVvdInfo(String bkgNo, String polCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdInfoVO> list = null;
		BkgVvdInfoVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("pol_cd", polCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgVvdInfoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdInfoVO.class);
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
	 * POD 정보 조회
	 *
	 * @param String bkgNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBkgVvdPodCd(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		String[] pods = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgVvdPodCdRSQL(), param, velParam);
			while(dbRowset.next()) list.add(dbRowset.getString(1));
			pods = list.toArray(new String[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return pods;
	}

	/**
	 * Shipper name 조회
	 *
	 * @param String bkgNo
	 * @return PsaShprVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaShprVO searchShprName(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaShprVO> list = null;
		PsaShprVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchShprNameRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaShprVO.class);
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
	 * BKG_STS_CD가 'X'가 아닐 경우 해당 파라미터에 'U'를 조회
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchUpdatePsaIFCd(String bkgNo) throws DAOException {
		String updateCd = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUpdatePsaIFCdRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) updateCd = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updateCd;
	}

	/**
	 * PSA BKG 테이블에 데이터 추가
	 *
	 * @param PsaBkgInfoVO psaBkgInfoVO
	 * @throws DAOException, Exception
	 */
	public void addPsaBkgInfo(PsaBkgInfoVO psaBkgInfoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaBkgInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPsaBkgInfoCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG Quantity 정보 조회
	 *
	 * @param String bkgNo
	 * @return List<PsaBkgQtyVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaBkgQtyVO> searchBkgQtyInfo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgQtyInfoRSQL(), param, velParam, PsaBkgQtyVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Reefer Cargo 정보 조회
	 *
	 * @param PsaRfCgoVO psaRfCgoVO
	 * @return List<PsaRfCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaRfCgoVO> searchRfCgoInfo(PsaRfCgoVO psaRfCgoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (psaRfCgoVO != null) {
				Map<String, String> mapVO = psaRfCgoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchRfCgoInfoRSQL(), param, velParam, PsaRfCgoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Awkward Cargo Info 조회
	 *
	 * @param PsaAwkCgoVO psaAwkCgoVO
	 * @return List<PsaAwkCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaAwkCgoVO> searchAwkCgoInfo(PsaAwkCgoVO psaAwkCgoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (psaAwkCgoVO != null) {
				Map<String, String> mapVO = psaAwkCgoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchAwkCgoInfoRSQL(), param, velParam, PsaAwkCgoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Serial No 조회
	 *
	 * @param PsaSrlNoVO psaSrlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaSerialNo(PsaSrlNoVO psaSrlNoVO) throws DAOException {
		String serialNo = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// Map VO
			Map<String, String> mapVO = psaSrlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaSerialNoRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) serialNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return serialNo;
	}

	/**
	 * PSA BKG CNTR 테이블에 CNTR Count정보를 update
	 *
	 * @param PsaCntrCntVO psaCntrCntVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgCntrCnt(PsaCntrCntVO psaCntrCntVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaCntrCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgCntrCntUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA BKG CNTR 테이블의 Serial No에 +1을 한 값을 조회
	 *
	 * @param String bkgNo
	 * @param String seq
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgCntrMaxSerialNoPls(String bkgNo, String seq) throws DAOException {
		String serialNo = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", seq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrMaxSerialNoPlsRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) serialNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return serialNo;
	}

	/**
	 * PSA BKG CNTR 테이블에 데이터 INSERT
	 *
	 * @param PsaBkgCntrInfoVO PsaBkgCntrInfoVO
	 * @throws DAOException, Exception
	 */
	public void addPsaBkgCntrInfo(PsaBkgCntrInfoVO PsaBkgCntrInfoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = PsaBkgCntrInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPsaBkgCntrInfoCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA RELEASE ORDER Table의 SUB PSA SERIAL NUMBER 를 조회
	 *
	 * @param PsaSubSrlNoVO PsaSubSrlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSubPsaSerialNo(PsaSubSrlNoVO PsaSubSrlNoVO) throws DAOException {
		String serialNo = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// Map VO
			Map<String, String> mapVO = PsaSubSrlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchSubPsaSerialNoRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) serialNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return serialNo;
	}

	/**
	 * PSA_RLSE_ORD 테이블의 CONTAINER QUANTITY에 +1을 update
	 *
	 * @param PsaRoCntrQtyVO psaRoCntrQtyVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgRoCntrQty(PsaRoCntrQtyVO psaRoCntrQtyVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaRoCntrQtyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgRoCntrQtyUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA RELEASE ORDER Table의 MAX SUB PSA SERIAL NUMBER +1 를 조회
	 *
	 * @param PsaMaxSubSrlNoVO psaMaxSubSrlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSubPsaMaxSerialNo(PsaMaxSubSrlNoVO psaMaxSubSrlNoVO) throws DAOException {
		String serialNo = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// Map VO
			Map<String, String> mapVO = psaMaxSubSrlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchSubPsaMaxSerialNoRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) serialNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return serialNo;
	}

	/**
	 * PSA RELEASE ORDER 테이블에 Insert
	 *
	 * @param PsaBkgRlsOrdVO psaBkgRlsOrdVO
	 * @throws DAOException, Exception
	 */
	public void addPsaBkgRlsOrd(PsaBkgRlsOrdVO psaBkgRlsOrdVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaBkgRlsOrdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPsaBkgRlsOrdCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA BKG CNTR의 CNTR Count를 조회
	 *
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String psaSerNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgCntrCnt(String bkgNo, String bkgSeq, String psaSerNo) throws DAOException {
		String cnt = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("psa_ser_no", psaSerNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrCntRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
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
	 * PSA CNTR CNT 가 6 이상인 경우 UPDATE 처리
	 *
	 * @param PsaCntrCntVO psaCntrCntVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgCntrCntOverSix(PsaCntrCntVO psaCntrCntVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaCntrCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgCntrCntOverSixUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ADD SEQ 값을 더해 SERIAL UPDATE
	 *
	 * @param PsaSerNoVO psaSerNoVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgCntrSerialNo(PsaSerNoVO psaSerNoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaSerNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgCntrSerialNoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Release Order 에 ADD SEQ 값을 더해 SERIAL UPDATE
	 *
	 * @param PsaRlsOrdSerNoVO psaRlsOrdSerNoVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgRlsOrdSerialNo(PsaRlsOrdSerNoVO psaRlsOrdSerNoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaRlsOrdSerNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgRlsOrdSerialNoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA BKG CNTR의 NEW Count 를 ADD
	 *
	 * @param PsaBkgCntrNewVO psaBkgCntrNewVO
	 * @throws DAOException, Exception
	 */
	public void addPsaBkgCntrNewCnt(PsaBkgCntrNewVO psaBkgCntrNewVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaBkgCntrNewVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPsaBkgCntrNewCntCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA BKG Release Order에서 CNTR Qty값 조회
	 *
	 * @param PsaRlsOrdQtyVO psaRlsOrdQtyVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgRlsOrdQty(PsaRlsOrdQtyVO psaRlsOrdQtyVO) throws DAOException {
		String cnt = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// Map VO
			Map<String, String> mapVO = psaRlsOrdQtyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgRlsOrdQtyRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
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
	 * PSA Release Order의 CNTR Qty를 update
	 * @param PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgRlsOrdCntrQty(PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaRlsOrdCntrQtyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgRlsOrdCntrQtyUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * pbr_qty > pbr_qty_rest 일 경우 PSA Release Order테이블에 새로 Insert
	 *
	 * @param PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO
	 * @throws DAOException, Exception
	 */
	public void addPsaBkgRlsOrdCntrQty(PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaRlsOrdCntrQtyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPsaBkgRlsOrdCntrQtyCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Release Order테이블의 Sub serial No칼럼을 update
	 *
	 * @param PsaRlsOrdSubSerNoVO psaRlsOrdSubSerNoVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgRlsOrdSubSerialNo(PsaRlsOrdSubSerNoVO psaRlsOrdSubSerNoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaRlsOrdSubSerNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgRlsOrdSubSerialNoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG Quantity 테이블에서 CNTR TPSZ와 QTY 조회
	 * @param String bkgNo
	 * @return List<PsaBkgQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaBkgQtyVO> searchBkgQtyCntrTpSzQty(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgQtyCntrTpSzQtyRSQL(), param, velParam, PsaBkgQtyVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA BKG Release Order와 CNTR에서 정보를 조회
	 *
	 * @param String bkgNo
	 * @param String pbSeq
	 * @param String cntrTpSz
	 * @return PsaBkgRlsOrdCntrVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgRlsOrdCntrVO[] searchPsaBkgRlsOrdCntrInfo(String bkgNo, String pbSeq, String cntrTpSz) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaBkgRlsOrdCntrVO> list = null;
		PsaBkgRlsOrdCntrVO[] psaBkgRlsOrdCntrVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			mapVO.put("cntr_tpsz_cd", cntrTpSz);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgRlsOrdCntrInfoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgRlsOrdCntrVO.class);
			if (list!=null && list.size() > 0) psaBkgRlsOrdCntrVOs = list.toArray(new PsaBkgRlsOrdCntrVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaBkgRlsOrdCntrVOs;
	}

	/**
	 * CNTR 및 Special cargo정보를 조회
	 *
	 * @param String bkgNo
	 * @param String cntrTpsz
	 * @return CntrSpeCgoVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CntrSpeCgoVO[] searchCntrSpeCgoInfo(String bkgNo, String cntrTpsz) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrSpeCgoVO> list = null;
		CntrSpeCgoVO[] cntrSpeCgoVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_tpsz_cd", cntrTpsz);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchCntrSpeCgoInfoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSpeCgoVO.class);
			if (list!=null && list.size() > 0) cntrSpeCgoVOs = list.toArray(new CntrSpeCgoVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrSpeCgoVOs;
	}

	/**
	 * PSA BKG CNTR NO 6개 조회
	 *
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String psaSerNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchPsaBkgCntrNo(String bkgNo, String bkgSeq, String psaSerNo) throws DAOException {
		String[] cntrNos = new String[6];
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("psa_ser_no", psaSerNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrNoRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) {
				for (int i=0; i < 6; i++) cntrNos[i] = dbRowset.getString(i+1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrNos;
	}

	/**
	 * PSA BKG CNTR_NO 정보 UPDATE
	 *
	 * @param PsaCntrNoVO psaCntrNoVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgCntrNo(PsaCntrNoVO psaCntrNoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaCntrNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgCntrNoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA BKG VSL Info 조회
	 *
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return PsaBkgVslVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgVslVO searchPsaBkgVslInfo(String bkgNo, String pbSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaBkgVslVO> list = null;
		PsaBkgVslVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgVslInfoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgVslVO.class);
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
	 * [vvd_unchanged용]PSA BKG VSL Info를 조회하여 flat file로 만든다.
	 *
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return PsaBkgVslVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgVslVO searchPsaBkgVslInfoForUnchg(String bkgNo, String pbSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaBkgVslVO> list = null;
		PsaBkgVslVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgVslVO.class);
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
	 * PSA BKG CNTR로 flat file을 만들기 위해 조회
	 *
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return PsaBkgCntrFlatVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgCntrFlatVO[] searchPsaBkgCntrInfo(String bkgNo, String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaBkgCntrFlatVO> list = null;
		PsaBkgCntrFlatVO[] psaBkgCntrFlatVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrInfoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgCntrFlatVO.class);
			if (list!=null && list.size() > 0) psaBkgCntrFlatVOs = list.toArray(new PsaBkgCntrFlatVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaBkgCntrFlatVOs;
	}

	/**
	 * [vvd_unchanged용]PSA BKG CNTR로 flat file을 만들기 위해 조회
	 *
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return PsaBkgCntrFlatVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgCntrFlatVO[] searchPsaBkgCntrInfoForUnchg(String bkgNo, String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaBkgCntrFlatVO> list = null;
		PsaBkgCntrFlatVO[] psaBkgCntrFlatVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrInfoForUnchgRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgCntrFlatVO.class);
			if (list!=null && list.size() > 0) psaBkgCntrFlatVOs = list.toArray(new PsaBkgCntrFlatVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaBkgCntrFlatVOs;
	}

	/**
	 * PSA BKG Release Order의 CNTR Type size조회
	 *
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return PsaBkgRlsOrdCntrTpszVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgRlsOrdCntrTpszVO[] searchPsaBkgRlsOrdCntrTpsz(String bkgNo, String pbSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaBkgRlsOrdCntrTpszVO> list = null;
		PsaBkgRlsOrdCntrTpszVO[] psaBkgRlsOrdCntrTpszVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgRlsOrdCntrTpszRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgRlsOrdCntrTpszVO.class);
			if (list!=null && list.size() > 0) psaBkgRlsOrdCntrTpszVOs = list.toArray(new PsaBkgRlsOrdCntrTpszVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaBkgRlsOrdCntrTpszVOs;
	}

	/**
	 * [vvd_unchanged용]PSA BKG Release Order의 CNTR Type size조회
	 *
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return PsaBkgRlsOrdCntrTpszVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgRlsOrdCntrTpszVO[] searchPsaBkgRlsOrdCntrTpszForUnchg(String bkgNo, String pbSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaBkgRlsOrdCntrTpszVO> list = null;
		PsaBkgRlsOrdCntrTpszVO[] psaBkgRlsOrdCntrTpszVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgRlsOrdCntrTpszForUnchgRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgRlsOrdCntrTpszVO.class);
			if (list!=null && list.size() > 0) psaBkgRlsOrdCntrTpszVOs = list.toArray(new PsaBkgRlsOrdCntrTpszVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return psaBkgRlsOrdCntrTpszVOs;
	}

	/**
	 * PSA BKG에 Send Date와 ACK RECEIVE STATUS CODE를 update
	 *
	 * @param PsaSndDtVO psaSndDtVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgSndDt(PsaSndDtVO psaSndDtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaSndDtVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgSndDtUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [vvd_unchanged용]PSA BKG CNTR 테이블에 CNTR Count정보를 update
	 *
	 * @param PsaCntrCntVO psaCntrCntVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaBkgCntrCntForUnchg(PsaCntrCntVO psaCntrCntVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaCntrCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaBkgCntrCntForUnchgUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Yard Assign By CNTR Booking 데이터 INSERT
	 *
	 * @param PsaBkgForYardVO psaBkgForYardVO
	 * @throws DAOException, Exception
	 */
	public void addPsaBkgForYardCd(PsaBkgForYardVO psaBkgForYardVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaBkgForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPsaBkgForYardCdCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Yard Assign By CNTR Container 데이터 INSERT
	 *
	 * @param PsaCntrForYardVO psaCntrForYardVO
	 * @throws DAOException, Exception
	 */
	public void addPsaCntrForYardCd(PsaCntrForYardVO psaCntrForYardVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaCntrForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPsaCntrForYardCdCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Yard Assign By CNTR Release Order 데이터 INSERT
	 *
	 * @param PsaRlsForYardVO psaRlsForYardVO
	 * @throws DAOException, Exception
	 */
	public void addPsaRlsOrdForYardCd(PsaRlsForYardVO psaRlsForYardVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaRlsForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOaddPsaRlsOrdForYardCdCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Yard Assign By CNTR화면에서 Grid의 P/UP CY를 수정
	 *
	 * @param PsaRlsForYardVO psaRlsForYardVO
	 * @throws DAOException, Exception
	 */
	public void modifyPsaRlsOrdForYardCd(PsaRlsForYardVO psaRlsForYardVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaRlsForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOmodifyPsaRlsOrdForYardCdUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Yard Container 삭제
	 *
	 * @param PsaCntrForYardVO psaCntrForYardVO
	 * @throws DAOException, Exception
	 */
	public void removePsaCntrForYardCd(PsaCntrForYardVO psaCntrForYardVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaCntrForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremovePsaCntrForYardCdDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Yard Relase Order 삭제
	 *
	 * @param PsaRlsForYardVO psaRlsForYardVO
	 * @throws DAOException, Exception
	 */
	public void removePsaRlsOrdForYardCd(PsaRlsForYardVO psaRlsForYardVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaRlsForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremovePsaRlsOrdForYardCdDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Yard Booking 정보 삭제
	 *
	 * @param PsaBkgForYardVO psaBkgForYardVO
	 * @throws DAOException, Exception
	 */
	public void removePsaBkgForYardCd(PsaBkgForYardVO psaBkgForYardVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = psaBkgForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSAManifestDBDAOremovePsaBkgForYardCdDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Max bkg_seq를 구해서 add할때 Max+1한 값을 BKG_SEQ에 넣어준다.
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaMaxBkgSeq(String bkgNo) throws DAOException {
		String maxSeq = "0";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaMaxBkgSeqRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) maxSeq = dbRowset.getString(1);
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
	 * Booking VVD Info 조회
	 *
	 * @param String bkgNo
	 * @return PsaBkgvvdInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaBkgvvdInfoVO searchBkgVvdInfoForPsa(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaBkgvvdInfoVO> list = null;
		PsaBkgvvdInfoVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgVvdInfoForPsaRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgvvdInfoVO.class);
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
	 * Import선택시 Next POD, Next VVD를 조회
	 *
	 * @param String vvdCd
	 * @param String bkgNo
	 * @return PsaNextVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PsaNextVO searchNextPodVvdForImport(String vvdCd, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsaNextVO> list = null;
		PsaNextVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("vvd", vvdCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchNextPodVvdForImportRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaNextVO.class);
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
	 * Import의 경우 NextPod, Next VVD조회를 위해 BKG No를 조회
	 * @param String vvdCd
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgNoForNextPodVvd(String vvdCd, String cntrNo) throws DAOException {
		String bkgNo = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("vvdCd", 	vvdCd);
			mapVO.put("cntrNo", cntrNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgNoForNextPodVvdRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) bkgNo = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgNo;
	}

	/**
	 * BKG CNTR Type Size 와 Qty 정보 조회
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgCntrTpSzQty(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bkgQty = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgCntrTpSzQtyRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) bkgQty = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgQty;
	}

	/**
	 * CSTMS_PSA_IMP_STS_SPCL PK 체크<br>
	 *
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return Integer
	 * @throws DAOException
	 */
	public int searchPKPSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(impStsSpclCgoVO != null){
				Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPKPSAImpStsSpclCgoRSQL(), param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getInt(1);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * FLAT FILE생성을 위한 BL_NO 조회<br>
	 *
	 * @param PsaCntrVO psaCntrVO
	 * @return String
	 * @throws DAOException
	 */
	public String getBlNoForFlatFile(PsaCntrVO psaCntrVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (psaCntrVO != null) {
				Map<String, String> mapVO = psaCntrVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOgetBlNoForFlatFileRSQL(), param, null);
			String rtnVal = "";
			if (dbRowset.next()) {
				rtnVal = dbRowset.getString("BL_NO");
			} else {
				rtnVal = "";
			}
			return rtnVal;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PSA VVD정보로 flat file을 만들기 위해 조회
	 *
	 * @param String vvd
	 * @param PsaIbManifestVO[] psaIbManifestVOs
	 * @return List<PsaManifestListBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaManifestListBlInfoVO> searchPsaBlInfo(String vvd, PsaIbManifestVO[] psaIbManifestVOs) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			List<String> arrString = new ArrayList();  //BKG_NO
			for (PsaIbManifestVO psaIbManifestVO : psaIbManifestVOs) arrString.add(psaIbManifestVO.getBkgNo());
			velParam.put("bkg_no", arrString);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBlInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaManifestListBlInfoVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1519, EDI Transmit Vsl 정보를 조회한다.
	 *
	 * @param PsaManifestListBlInfoVO inputVO
	 * @return PsaManifestVslInfoVO
	 * @throws DAOException
	 */
	public PsaManifestVslInfoVO searchVslInfo(PsaManifestListBlInfoVO inputVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		PsaManifestVslInfoVO psaManifestVslInfoVO = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchVslInfoRSQL(), param, velParam);
			List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, PsaManifestVslInfoVO.class);
			if (list != null && list.size() > 0) psaManifestVslInfoVO = (PsaManifestVslInfoVO) list.get(0);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return psaManifestVslInfoVO;
	}

	/**
	 * Container Count 정보 조회
	 *
	 * @param  String bkgNo
	 * @return String cnt
	 * @throws DAOException
	 */
	public String searchCntrCnt(String bkgNo) throws DAOException {
		String cnt = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("");
			PSAManifestDBDAOSearchCntrCntRSQL template = new PSAManifestDBDAOSearchCntrCntRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getString("CNTR_CNT");
			} else {
				cnt = "";
			}
		} catch(SQLException ex) {
			// log.error(se.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			// log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * ESM_BKG_1519, EDI Transmit Customer 정보를 조회한다.
	 *
	 * @param String bkgNo
	 * @return List<PsaManifestCustomerInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaManifestCustomerInfoVO> searchCustomerInfo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchCustomerInfoRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaManifestCustomerInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_BKG_1519, CM 정보를 조회한다.
	 *
	 * @param String bkgNo
	 * @return List<PsaManifestCmInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaManifestCmInfoVO> searchCmInfo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchCmInfoRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaManifestCmInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_BKG_1519, Container 정보를 조회한다.
	 *
	 * @param String bkgNo
	 * @return List<PsaManifestCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaManifestCntrInfoVO> searchCntrInfo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchCntrInfoRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaManifestCntrInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1519, EDI Transmit DG Goods 정보를 조회한다.
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return List<PsaManifestDgGoodsInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaManifestDgGoodsInfoVO> searchDgGoodsInfo(String bkgNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchDgGoodsInfoRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaManifestDgGoodsInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_BKG_1519, EDI Transmit Mark 정보를 조회한다.
	 *
	 * @param String bkgNo
	 * @return List<PsaManifestMarkInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaManifestMarkInfoVO> searchMarkInfo(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchMarkInfoRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaManifestMarkInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_BKG_1519, EDI Transmit Container Seal 정보를 조회한다.
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return List<PsaManifestCntrSealNoInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaManifestCntrSealNoInfoVO> searchCntrSealNoInfo(String bkgNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchCntrSealNoInfoRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaManifestCntrSealNoInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_BKG_1519 : PSA Inbound Manifest 목록 조회
	 *
	 * @param String vvd
	 * @return List<PsaIbManifestVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsaIbManifestVO> searchPSAIbManifest(String vvd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAIbManifestRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PsaIbManifestVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_SGP_SND_LOG 정보 신규 저장<br>
	 *
	 * @param List<BkgCstmsSgpSndLogVO> bkgCstmsSgpSndLogVOList
	 * @exception DAOException, Exception
	 */
	public void addCstmsSgpSndLog(List<BkgCstmsSgpSndLogVO> bkgCstmsSgpSndLogVOList) throws DAOException, Exception {
		try {
			if (bkgCstmsSgpSndLogVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new PSAManifestDBDAOaddCstmsSgpSndLogCSQL(), bkgCstmsSgpSndLogVOList, null);
				for(int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


}