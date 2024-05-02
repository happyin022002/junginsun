/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : Jp24ManifestListDownloadDBDAO.java
 *@FileTitle : Jp24ManifestListDownloadDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.06.28
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2013.06.28 김상수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpSendLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BkgBookingVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BkgQuantityVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.DepartureTimeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.EdiAdvJpCommonVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.ErrorReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.FlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.JmsReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.MailContentsParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS Jp24ManifestListDownloadDBDAO <br>
 * - ALPS-Jp24ManifestListDownload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see Jp24ManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class Jp24ManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * [ESM_BKG_1501]
	 * Advance Cargo Information Download & Transmit - Header 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return List<CargoInfoHeaderVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CargoInfoHeaderVO> searchCargoInfoHeader(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchCargoInfoHeaderRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CargoInfoHeaderVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501]
	 * Advance Cargo Information Download & Transmit - Detail B/L Data 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return List<CargoInfoDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CargoInfoDetailVO> searchCargoInfoDetailBLData(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailBLDataRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CargoInfoDetailVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501]
	 * Advance Cargo Information Download & Transmit - Detail Download Data 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return List<CargoInfoDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CargoInfoDetailVO> searchCargoInfoDetailDownload(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailDownloadRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CargoInfoDetailVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501]
	 * VSL_CD로 Call Sing No. 정보 조회<br>
	 *
	 * @param String ofcTmpNo
	 * @return String
	 * @exception DAOException
	 */
	public String getCallSignByVsl(String vslCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("vsl_cd", vslCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOGetCallsignByVslRSQL(), param, null);
			String callSignNo = "";
			if (dbRowset.next()) callSignNo = dbRowset.getString("CALL_SGN_NO");
			return callSignNo;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

///// Data Download (S) ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_VSL_SKD 정보 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return List<CargoInfoHeaderVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CargoInfoHeaderVO> searchAdvJpVslSkd(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchAdvJpVslSkdRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CargoInfoHeaderVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_VSL_SKD 정보 삭제<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @exception DAOException, Exception
	 */
	public void removeAdvJpVslSkd(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Jp24ManifestListDownloadDBDAORemoveAdvJpVslSkdDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_VSL_SKD 정보 신규 저장<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @exception DAOException, Exception
	 */
	public void addAdvJpVslSkd(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Jp24ManifestListDownloadDBDAOAddAdvJpVslSkdCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_BOOKING 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgBookingVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgBookingVO> searchBkgBooking(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchBkgBookingRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_QUANTITY 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgQuantityVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgQuantityVO> searchBkgQuantity(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchBkgQuantityRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CUSTOMER 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<AdvJpCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpCustomerVO> searchBkgCustomer(String bkgNo, String podCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("pod_cd", podCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchBkgCustomerRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, AdvJpCustomerVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_BL_DOC 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String getDescFromBkgDoc(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOGetDescFromBkgDocRSQL(),param, null);
			String cstmsDesc = "";
			if (dbRowset.next()) cstmsDesc = dbRowset.getString("CSTMS_DESC");
			return cstmsDesc;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_BL_MK_DESC 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<AdvJpMarkDescVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpMarkDescVO> searchBkgMark(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchBkgMarkRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, AdvJpMarkDescVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CONTAINER 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<AdvJpContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpContainerVO> searchBkgContainer(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchBkgContainerRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, AdvJpContainerVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_CNTR 정보 삭제<br>
	 *
	 * @param List<AdvJpBlVO> advJpBlVOList
	 * @exception DAOException, Exception
	 */
	public void removeAdvJpContainer(List<AdvJpBlVO> advJpBlVOList) throws DAOException, Exception {
		try {
			if (advJpBlVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAORemoveAdvJpContainerDSQL(), advJpBlVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_MK 정보 삭제<br>
	 *
	 * @param List<AdvJpBlVO> advJpBlVOList
	 * @exception DAOException, Exception
	 */
	public void removeAdvJpMarkDesc(List<AdvJpBlVO> advJpBlVOList) throws DAOException, Exception {
		try {
			if (advJpBlVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAORemoveAdvJpMarkDescDSQL(), advJpBlVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_CUST 정보 삭제<br>
	 *
	 * @param List<AdvJpBlVO> advJpBlVOList
	 * @exception DAOException, Exception
	 */
	public void removeAdvJpCustomer(List<AdvJpBlVO> advJpBlVOList) throws DAOException, Exception {
		try {
			if (advJpBlVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAORemoveAdvJpCustomerDSQL(), advJpBlVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download<br>
	 * BKG_CSTMS_ADV_JP_BL 정보 삭제
	 *
	 * @param List<AdvJpBlVO> advJpBlVOList
	 * @exception DAOException, Exception
	 */
	public void removeAdvJpBl(List<AdvJpBlVO> advJpBlVOList) throws DAOException, Exception {
		try {
			if (advJpBlVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAORemoveAdvJpBlDSQL(), advJpBlVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_BL 정보 신규 저장<br>
	 *
	 * @param List<AdvJpBlVO> advJpBlVOList
	 * @exception DAOException, Exception
	 */
	public void addAdvJpBl(List<AdvJpBlVO> advJpBlVOList) throws DAOException, Exception {
		try {
			if (advJpBlVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOAddAdvJpBlCSQL(), advJpBlVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_CUST 정보 신규 저장<br>
	 *
	 * @param List<AdvJpCustomerVO> advJpCustomerVOList
	 * @exception DAOException, Exception
	 */
	public void addAdvJpCustomer(List<AdvJpCustomerVO> advJpCustomerVOList) throws DAOException, Exception {
		try {
			if (advJpCustomerVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOAddAdvJpCustomerCSQL(), advJpCustomerVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BKG_CSTMS_ADV_JP_MK 목록 신규 저장<br>
	 *
	 * @param List<AdvJpMarkDescVO> advJpMarkDescVOList
	 * @exception DAOException, Exception
	 */
	public void addAdvJpMarkDesc(List<AdvJpMarkDescVO> advJpMarkDescVOList) throws DAOException, Exception {
		try {
			if (advJpMarkDescVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOAddAdvJpMarkDescCSQL(), advJpMarkDescVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501]
	 * [ESM_BKG_1502]
	 * BKG_CSTMS_ADV_JP_CNTR 목록 신규 저장<br>
	 *
	 * @param List<AdvJpContainerVO> advJpContainerVOList
	 * @exception DAOException, Exception
	 */
	public void addAdvJpContainer(List<AdvJpContainerVO> advJpContainerVOList) throws DAOException, Exception {
		try {
			if (advJpContainerVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOAddAdvJpContainerCSQL(), advJpContainerVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
///// Data Download (E) ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///// EDI Transmit (S) ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_VSL_SKD 정보 수정저장<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @exception DAOException, Exception
	 */
	public void modifyAdvJpVslSkd(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifyAdvJpVslSkdUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_BL 정보 조회<br>
	 *
	 * @param String vvd
	 * @param String blNo
	 * @param String polSplitNo
	 * @param String podSplitNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpBl(String vvd, String blNo, String polSplitNo, String podSplitNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			param.put("bl_no", blNo);
			param.put("pol_split_no", polSplitNo);
			param.put("pod_split_no", podSplitNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpBlRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_CUST 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpCustomer(String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_MK 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpMarkDesc(String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpMarkDescRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * BKG_CSTMS_ADV_JP_CNTR 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpContainer(String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpContainerRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * [ESM_BKG_1502] EDI Transmit
	 * [ESM_BKG_1503] EDI Transmit
	 * BKG_BOOKING테이블의 USR_EML 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String getUsrEmlOfBooking(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOGetUsrEmlOfBookingRSQL(), param, null);
			String usrEml = "";
			if (dbRowset.next()) usrEml = dbRowset.getString("USR_EML");
			return usrEml;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * [ESM_BKG_1502] EDI Transmit
	 * [ESM_BKG_1503] EDI Transmit
	 * ADV_JP_BL테이블의 USR_EML 정보 조회<br>
	 *
	 * @param String blNo
	 * @return String
	 * @exception DAOException
	 */
	public String getUsrEmlOfAdvJpBl(String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOGetUsrEmlOfAdvJpBlRSQL(), param, null);
			String usrEml = "";
			if (dbRowset.next()) usrEml = dbRowset.getString("USR_EML");
			return usrEml;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * [ESM_BKG_1502] EDI Transmit
	 * [ESM_BKG_1503] EDI Transmit
	 * BKG_CNTC_PSON테이블의 CNTC_PSON_EML 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String getCntcPsonEml(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOGetCntcPsonEmlRSQL(), param, null);
			String usrEml = "";
			if (dbRowset.next()) usrEml = dbRowset.getString("CNTC_PSON_EML");
			return usrEml;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] EDI Transmit
	 * [ESM_BKG_1502] EDI Transmit
	 * [ESM_BKG_1503] EDI Transmit
	 * BKG_CSTMS_ADV_JP_SND_LOG 정보 신규 저장<br>
	 *
	 * @param AdvJpSendLogVO advJpSendLogVO
	 * @exception DAOException, Exception
	 */
	public void addAdvJpSendLog(AdvJpSendLogVO advJpSendLogVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (advJpSendLogVO != null) {
				Map<String, String> mapVO = advJpSendLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Jp24ManifestListDownloadDBDAOAddAdvJpSendLogCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
///// EDI Transmit (E) ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * [ESM_BKG_1501]
	 * ADV_JP_BL테이블의 USR_EML 수정 저장<br>
	 *
	 * @param CargoInfoDetailVO cargoInfoDetailVO
	 * @exception DAOException, Exception
	 */
	public void modifyUsrEmlOfAdvJpBl(CargoInfoDetailVO cargoInfoDetailVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cargoInfoDetailVO != null) {
				Map<String, String> mapVO = cargoInfoDetailVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifyUsrEmlOfAdvJpBlUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpBlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpBlVO> searchBLInquiry(AdvJpBlVO advJpBlVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (advJpBlVO != null) {
				Map<String, String> mapVO = advJpBlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchBLInquiryRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, AdvJpBlVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR)의 Tab2에 해당하는 Container 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpContainerVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpContainerVO> searchBLInquiryContainer(AdvJpBlVO advJpBlVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (advJpBlVO != null) {
				Map<String, String> mapVO = advJpBlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchBLInquiryContainerRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, AdvJpContainerVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR)의 Tab3에 해당하는 Mark & Desc 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpMarkDescVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpMarkDescVO> searchBLInquiryMarkDesc(AdvJpBlVO advJpBlVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (advJpBlVO != null) {
				Map<String, String> mapVO = advJpBlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchBLInquiryMarkDescRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, AdvJpMarkDescVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * MDM_CUSTOMER 정보 조회<br>
	 *
	 * @param GetMdmCustomerVO getMdmCustomerVO
	 * @return List<GetMdmCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<GetMdmCustomerVO> getMdmCustomer(GetMdmCustomerVO getMdmCustomerVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (getMdmCustomerVO != null) {
				Map<String, String> mapVO = getMdmCustomerVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOGetMdmCustomerRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, GetMdmCustomerVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry의 HTML Oblect Value 수정 저장<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @exception DAOException, Exception
	 */
	public void modifyBLInquiry(AdvJpBlVO advJpBlVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (advJpBlVO != null) {
				Map<String, String> mapVO = advJpBlVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifyBLInquiryUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry의 1번째 Tab의 Customer Information 수정 저장<br>
	 *
	 * @param List<AdvJpCustomerVO> advJpCustomerVOList
	 * @exception DAOException, Exception
	 */
	public void modifyBLInquiryCustomer(List<AdvJpCustomerVO> advJpCustomerVOList) throws DAOException, Exception {
		try {
			if (advJpCustomerVOList.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifyBLInquiryCustomerUSQL(), advJpCustomerVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry의 2번째 Tab의 Container목록 수정 저장<br>
	 *
	 * @param List<AdvJpContainerVO> advJpContainerVOList
	 * @exception DAOException, Exception
	 */
	public void modifyBLInquiryContainer(List<AdvJpContainerVO> advJpContainerVOList) throws DAOException, Exception {
		try {
			if (advJpContainerVOList.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifyBLInquiryContainerUSQL(), advJpContainerVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry의 2번째 Tab의 Container 목록 삭제<br>
	 *
	 * @param List<AdvJpContainerVO> advJpContainerVOList
	 * @exception DAOException, Exception
	 */
	public void removeBLInquiryContainer(List<AdvJpContainerVO> advJpContainerVOList) throws DAOException, Exception {
		try {
			if (advJpContainerVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAORemoveBLInquiryContainerDSQL(), advJpContainerVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry의 3번째 Tab의 Mark & Desc목록 수정 저장<br>
	 *
	 * @param List<AdvJpMarkDescVO> advJpMarkDescVOList
	 * @exception DAOException, Exception
	 */
	public void modifyBLInquiryMarkDesc(List<AdvJpMarkDescVO> advJpMarkDescVOList) throws DAOException, Exception {
		try {
			if (advJpMarkDescVOList.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifyBLInquiryMarkDescUSQL(), advJpMarkDescVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1503]
	 * Departure Time Registration 조회<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @return List<DepartureTimeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DepartureTimeVO> searchDepartureTime(DepartureTimeVO departureTimeVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (departureTimeVO != null) {
				Map<String, String> mapVO = departureTimeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchDepartureTimeRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, DepartureTimeVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1503] EDI Transmit
	 * BKG_CSTMS_ADV_JP_VSL_SKD 정보 조회<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @return List<EdiAdvJpCommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiAdvJpCommonVO> searchEdiAdvJpVslSkd(DepartureTimeVO departureTimeVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (departureTimeVO != null) {
				Map<String, String> mapVO = departureTimeVO.getColumnValues();

				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpVslSkdRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1503] EDI Transmit
	 * BKG_CSTMS_ADV_JP_VSL_SKD의 전송Flag Update<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @exception DAOException, Exception
	 */
	public void modifyTrnsFlagOfAdvJpVslSkd(DepartureTimeVO departureTimeVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (departureTimeVO != null) {
				Map<String, String> mapVO = departureTimeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifyTrnsFlagOfAdvJpVslSkdUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1504]
	 * JMS Report 목록 조회<br>
	 *
	 * @param JmsReportVO jmsReportVO
	 * @return List<JmsReportVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JmsReportVO> searchJmsReport(JmsReportVO jmsReportVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (jmsReportVO != null) {
				Map<String, String> mapVO = jmsReportVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchJmsReportRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, JmsReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI전송 직후 수신측에서 return되는 echo메세지 내용을 수정 저장<br>
	 * @param String jpSndLogId
	 * @param String msgSndNo
	 * @throws DAOException, Exception
	 */
	public void modifySysAckStsForJP24EDI(String jpSndLogId, String msgSndNo) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("jp_snd_log_id", jpSndLogId);
			param.put("msg_snd_no", msgSndNo);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifySysAckStsForJP24EDIUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [UDEV_ALPSBKG_T_JPN24]
	 * Call Sing No.로 VSL_CD 정보 조회<br>
	 *
	 * @param AdvJpReceiveLogVO advJpReceiveLogVO
	 * @return List<AdvJpReceiveLogVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpReceiveLogVO> getAdvJpVslByCallsign(AdvJpReceiveLogVO advJpReceiveLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (advJpReceiveLogVO != null) {
				Map<String, String> mapVO = advJpReceiveLogVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOGetAdvJpVslByCallsignRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, AdvJpReceiveLogVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [UDEV_ALPSBKG_T_JPN24]
	 * BKG_CSTMS_ADV_JP_RCV_LOG 정보 신규 저장<br>
	 *
	 * @param List<AdvJpReceiveLogVO> advJpReceiveLogVOList
	 * @exception DAOException, Exception
	 */
	public void addAdvJpReceiveLog(List<AdvJpReceiveLogVO> advJpReceiveLogVOList) throws DAOException, Exception {
		try {
			if (advJpReceiveLogVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOAddAdvJpReceiveLogCSQL(), advJpReceiveLogVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	public void addAdvJpReceiveLogIns(List<AdvJpReceiveLogVO> advJpReceiveLogVOList) throws DAOException, Exception {
		try {
			if (advJpReceiveLogVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOaddAdvJpReceiveLogInsCSQL(), advJpReceiveLogVOList, null);
																				  
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [UDEV_ALPSBKG_T_JPN24]
	 * BKG_CSTMS_ADV_JP_RCV_LOG 테이블의 JP_BAT_NO 수정 저장<br>
	 *
	 * @param List<AdvJpReceiveLogVO> advJpReceiveLogVOList
	 * @exception DAOException, Exception
	 */
	public void modifyJpBatNoOfAdvJpReceiveLog(List<AdvJpReceiveLogVO> advJpReceiveLogVOList) throws DAOException, Exception {
		try {
			if (advJpReceiveLogVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new Jp24ManifestListDownloadDBDAOModifyJpBatNoOfAdvJpReceiveLogUSQL(), advJpReceiveLogVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회 - SAMR/SCMR<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ErrorReportVO> searchErrorReportForAmrCmr(ErrorReportVO errorReportVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (errorReportVO != null) {
				Map<String, String> mapVO = errorReportVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchErrorReportForAmrCmrRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ErrorReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회 - SAS111<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<FlatFileVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FlatFileVO> searchErrorReportForSas111(ErrorReportVO errorReportVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (errorReportVO != null) {
				Map<String, String> mapVO = errorReportVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchErrorReportForSas111RSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, FlatFileVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회 - SATD/etc.<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ErrorReportVO> searchErrorReport(ErrorReportVO errorReportVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (errorReportVO != null) {
				Map<String, String> mapVO = errorReportVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchErrorReportRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ErrorReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1506]
	 * Send FlatFile 조회<br>
	 *
	 * @param FlatFileVO flatFileVO
	 * @return List<FlatFileVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FlatFileVO> searchSendFlatFile(FlatFileVO flatFileVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (flatFileVO != null) {
				Map<String, String> mapVO = flatFileVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchSendFlatFileRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, FlatFileVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI 송수신시 전송하는 E-mail 내용 생성<br>
	 *
	 * @param MailContentsParamVO mailContentsParamVO
	 * @return List<MailContentsParamVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MailContentsParamVO> searchMailContentsParam(MailContentsParamVO mailContentsParamVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (mailContentsParamVO != null) {
				Map<String, String> mapVO = mailContentsParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchMailContentsParamRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, MailContentsParamVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
		/**
		 * [ESM_BKG_1501] EDI New Transmit
		 * BKG_CSTMS_ADV_JP_BL 정보 조회<br>
		 *
		 * @param String vvd
		 * @param String blNo
		 * @param String polSplitNo
		 * @param String podSplitNo
		 * @return List<EdiAdvJpCommonVO>
		 * @exception DAOException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<EdiAdvJpCommonVO> searchEdiAdvJpBlRenewal2017(String vvd, String blNo, String polSplitNo, String podSplitNo, String delCd, String delReason, String tCmrKind) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{
				param.put("vvd", vvd);
				param.put("bl_no", blNo);
				param.put("pol_split_no", polSplitNo);
				param.put("pod_split_no", podSplitNo);
				param.put("del_cd", delCd);
				param.put("del_reason", delReason);
				param.put("t_cmr_kind", tCmrKind);
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpBlRenewal2017RSQL(), param, null);
				return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
			} catch(SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 * [ESM_BKG_1501] EDI Transmit
		 * BKG_CSTMS_ADV_JP_CUST 정보 조회<br>
		 *
		 * @param String blNo
		 * @return List<EdiAdvJpCommonVO>
		 * @exception DAOException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<EdiAdvJpCommonVO> searchEdiAdvJpCustomerRenewal2017(String blNo) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{
				param.put("bl_no", blNo);
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRenewal2017RSQL(), param, null);
				return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
			} catch(SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}

		/**
		 * [ESM_BKG_1501] EDI Transmit
		 * BKG_CSTMS_ADV_JP_MK 정보 조회<br>
		 *
		 * @param String blNo
		 * @return List<EdiAdvJpCommonVO>
		 * @exception DAOException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<EdiAdvJpCommonVO> searchEdiAdvJpMarkDescRenewal2017(String blNo) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{
				param.put("bl_no", blNo);
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpMarkDescRenewal2017RSQL(), param, null);
				return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
			} catch(SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 * [ESM_BKG_1501] EDI Transmit
		 * BKG_CSTMS_ADV_JP_CNTR 정보 조회<br>
		 *
		 * @param String blNo
		 * @return List<EdiAdvJpCommonVO>
		 * @exception DAOException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<EdiAdvJpCommonVO> searchEdiAdvJpContainerRenewal2017(String blNo) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{
				param.put("bl_no", blNo);
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Jp24ManifestListDownloadDBDAOSearchEdiAdvJpContainerRenewal2017RSQL(), param, null);
				return (List)RowSetUtil.rowSetToVOs(dbRowset, EdiAdvJpCommonVO.class);
			} catch(SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
}
