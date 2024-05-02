/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MalaysiaManifestListDownloadDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.07
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.ImpStsSpclCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaAddVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS MalaysiaManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Byeon, Jong-Geon
 * @see BCImpl 참조
 * @since J2EE 1.6
 */
public class MalaysiaManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1141화면, B/L info를 조회한다.
	 *
	 * @param MalaysiaManifestListCondVO malaysiaManifestListCondVO
	 * @return List<MalaysiaManifestListBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MalaysiaManifestListBlInfoVO> searchCustomsBlInfo(MalaysiaManifestListCondVO malaysiaManifestListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MalaysiaManifestListBlInfoVO> list = null;

		try {
			Map<String, String> mapVO = malaysiaManifestListCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOSearchCustomsBlInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestListBlInfoVO.class);

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
	 * 1141화면, Container info를 조회한다.
	 *
	 * @param MalaysiaManifestListCondVO malaysiaManifestListCondVO
	 * @return List<MalaysiaManifestListCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MalaysiaManifestListCntrInfoVO> searchCustomsCNTRInfo(MalaysiaManifestListCondVO malaysiaManifestListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MalaysiaManifestListCntrInfoVO> list = null;

		try {
			Map<String, String> mapVO = malaysiaManifestListCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestListCntrInfoVO.class);

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
	 * Malaysia Import Status Count 조회
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchTpCnt(MalaysiaImpStsVO malaysiaImpStsVO) throws DAOException {
		String cnt = "0";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchTpCntRSQL(), param, velParam);
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
	 * Malaysia Import Status List조회
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @return MalaysiaImpStsVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MalaysiaImpStsVO[] searchImpStsInfoList(MalaysiaImpStsVO malaysiaImpStsVO) throws DAOException {
		List<MalaysiaImpStsVO> list = null;
		MalaysiaImpStsVO[] malaysiaImpStsVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchImpStsInfoListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaImpStsVO.class);
			if (list!=null && list.size() > 0) malaysiaImpStsVOs = list.toArray(new MalaysiaImpStsVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return malaysiaImpStsVOs;
	}

	/**
	 * BKG에서 Add된 CNTR을 조회
	 * @param MalaysiaAddVO malaysiaAddVO
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchAddCNTRList(MalaysiaAddVO malaysiaAddVO) throws DAOException {
		List<String> list = new ArrayList<String>();
		String[] cntrNOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaAddVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchAddCNTRListRSQL(), param, velParam);
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
	 * searchAddCNTRList에서 추가된 정보에 대해서 BKG에서 Malaysia정보를 조회 (리스트)
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @return MalaysiaImpStsVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MalaysiaImpStsVO[] searchImpStsInfoAddList(MalaysiaImpStsVO malaysiaImpStsVO) throws DAOException {
		List<MalaysiaImpStsVO> list = null;
		MalaysiaImpStsVO[] malaysiaImpStsVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchImpStsInfoAddListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaImpStsVO.class);
			if (list!=null && list.size() > 0) malaysiaImpStsVOs = list.toArray(new MalaysiaImpStsVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return malaysiaImpStsVOs;
	}

	/**
	 * Malaysia VSL Name과 Voyage Dir을 조회
	 * @param String vvd
	 * @return MalaysiaVvdVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MalaysiaVvdVO searchVslNameDir(String vvd) throws DAOException {
		MalaysiaVvdVO malaysiaVvdVO = new MalaysiaVvdVO();
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchVslNameDirRSQL(), param, null);
			List<MalaysiaVvdVO> malaysiaVvdVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaVvdVO.class);
			if (malaysiaVvdVOList.size() > 0) malaysiaVvdVO = malaysiaVvdVOList.get(0);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return malaysiaVvdVO;
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", voyNo);
			mapVO.put("skd_dir_cd", voyDir);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchVslCountRSQL(), param, velParam);
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
	 * Malaysia Import Status 신규 Insert
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void addImpStsInfo(MalaysiaImpStsVO malaysiaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOaddImpStsInfoCSQL(), param, velParam);
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
	 * Malaysia Import Status Special Data를 삭제
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void removeImpStsSpclInfo(MalaysiaImpStsVO malaysiaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOremoveImpStsSpclInfoDSQL(), param, velParam);
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
	 * Malaysia Import Status Special Cargo의 정보를 BKG과 Special Cargo 테이블에서 조회
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ImpStsSpclCgoVO searchBKGImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException {
		List<ImpStsSpclCgoVO> list = null;
		ImpStsSpclCgoVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchBKGImpStsSpclCgoRSQL(), param, velParam);
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
	 * Malaysia Import Status Special Cargo정보를 신규로 생성
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @throws DAOException, Exception
	 */
	public void addImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOaddImpStsSpclCgoCSQL(), param, velParam);
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
	 * Malaysia Import Status Update
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void modifyImpStsInfo(MalaysiaImpStsVO malaysiaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOmodifyImpStsInfoUSQL(), param, velParam);
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
	 * Malaysia Import Status Special Cargo의 Stowage ID를 수정
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void modifyStwgIdOfImpStsSpclCgo(MalaysiaImpStsVO malaysiaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOmodifyStwgIdOfImpStsSpclCgoUSQL(), param, velParam);
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
	 * Malaysia Import Status 정보 삭제
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @throws DAOException, Exception
	 */
	public void removeImpStsInfo(MalaysiaImpStsVO malaysiaImpStsVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOremoveImpStsInfoDSQL(), param, velParam);
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
	 * Malaysia Vessel 정보 조회
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return MalaysiaVvdVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MalaysiaVvdVO[] searchVslRegist(MalaysiaVvdVO malaysiaVvdVO) throws DAOException {
		List<MalaysiaVvdVO> list = null;
		MalaysiaVvdVO[] malaysiaVvdVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchVslRegistRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaVvdVO.class);
			if (list!=null && list.size() > 0) malaysiaVvdVOs = list.toArray(new MalaysiaVvdVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return malaysiaVvdVOs;
	}

	/**
	 * Vsl Code 로 Vsl Name 조회
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslName(MalaysiaVvdVO malaysiaVvdVO) throws DAOException {
		String malaysiaVslNm = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchVslNameRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) malaysiaVslNm = dbRowset.getString(1);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return malaysiaVslNm;
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			mapVO.put("vsl_cd", 	vslCd);
			mapVO.put("skd_voy_no", voyNo);
			mapVO.put("skd_dir_cd", dirCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchVslPortSkdValidCheckRSQL(), param, velParam);
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
	 *  Malaysia VVD Validation check
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVVDValidCheck(MalaysiaVvdVO malaysiaVvdVO) throws DAOException {
		String cnt = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchVVDValidCheckRSQL(), param, velParam);
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
	 * Malaysia VVD 정보 추가
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @throws DAOException, Exception
	 */
	public void addVVDInfo(MalaysiaVvdVO malaysiaVvdVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOaddVVDInfoCSQL(), param, velParam);
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
	 * Malaysia VVD 정보 수정
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @throws DAOException, Exception
	 */
	public void modifyVVDInfo(MalaysiaVvdVO malaysiaVvdVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOmodifyVVDInfoUSQL(), param, velParam);
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
	 * Malaysia 기 전송여부 체크
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSendValidCheck(MalaysiaVvdVO malaysiaVvdVO) throws DAOException {
		String cnt = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchSendValidCheckRSQL(), param, velParam);
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
	 * Malaysia VVD Data 삭제
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @throws DAOException, Exception
	 */
	public void removeVVDInfo(MalaysiaVvdVO malaysiaVvdVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOremoveVVDInfoDSQL(), param, velParam);
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
	 * Malaysia Import Status Special Cargo의 정보를 조회
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ImpStsSpclCgoVO searchImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException {
		List<ImpStsSpclCgoVO> list = null;
		ImpStsSpclCgoVO outVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchImpStsSpclCgoRSQL(), param, velParam);
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
	 * CSTMS_Malaysia_IMP_STS_SPCL PK 체크<br>
	 *
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return Integer
	 * @throws DAOException
	 */
	public int getImpStsSpclCgoPK(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException {
		int cnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(impStsSpclCgoVO != null){
				Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOgetImpStsSpclCgoPKRSQL(), param, velParam);
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
	 * Malaysia Import Status Special Cargo정보를 수정
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @throws DAOException, Exception
	 */
	public void modifyImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOmodifyImpStsSpclCgoUSQL(), param, velParam);
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
	 * Malaysia Import Status의 Stowage ID를 수정
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
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOmodifyStwgIdOfImpStsUSQL(), param, velParam);
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
	 * Malaysia Import Status Special Cargo정보를 삭제
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @throws DAOException, Exception
	 */
	public void removeImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOremoveImpStsSpclCgoDSQL(), param, velParam);
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
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return MalaysiaVvdVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MalaysiaVvdVO[] searchVVD(MalaysiaVvdVO malaysiaVvdVO) throws DAOException {
		List<MalaysiaVvdVO> list = null;
		MalaysiaVvdVO[] malaysiaVvdVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = malaysiaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MalaysiaManifestListDownloadDBDAOsearchVVDRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaVvdVO.class);
			if (list!=null && list.size() > 0) malaysiaVvdVOs = list.toArray(new MalaysiaVvdVO[0]);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return malaysiaVvdVOs;
	}

}
