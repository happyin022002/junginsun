/*=========================================================
 *Copyright(c) 2013 CyberLogitec 
 *@FileName : Jp24ManifestListDownloadDBDAO.java
 *@FileTitle : Jp24ManifestListDownloadDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.06.28
 *@LastModifier :
 *@LastVersion : 1.0
 * 2013.06.28
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic.Jp24ManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpCustomerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BkgBookingVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BkgQuantityVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BllSprtCmbnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS Jp24ManifestListDownloadDBDAO <br>
 * - OPUS-Jp24ManifestListDownload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchCargoInfoHeaderRSQL(), param, velParam, CargoInfoHeaderVO.class);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailBLDataRSQL(), param, velParam, CargoInfoDetailVO.class);
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchCargoInfoDetailDownloadRSQL(), param, velParam, CargoInfoDetailVO.class);
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
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] getCallSignByVsl(CargoInfoHeaderVO cargoInfoHeaderVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOGetCallsignByVslRSQL(), param, null);
			return (dbRowset.next() ? new String[]{dbRowset.getString("CSTMS_DESC"), dbRowset.getString("IB_CSSM_VOY_NO")} : new String[]{"", ""});
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

///// Data Download(S) ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchAdvJpVslSkdRSQL(), param, velParam, CargoInfoHeaderVO.class);
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
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24ManifestListDownloadDBDAORemoveAdvJpVslSkdDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
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
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cargoInfoHeaderVO != null) {
				Map<String, String> mapVO = cargoInfoHeaderVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24ManifestListDownloadDBDAOAddAdvJpVslSkdCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1501] Data Download
	 * BL_NO로 BKG_BOOKING 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<BkgBookingVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgBookingVO> searchBkgBooking(String blNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchBkgBookingRSQL(), param, null, BkgBookingVO.class);
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
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchBkgQuantityRSQL(), param, null, BkgQuantityVO.class);
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
	public List<AdvJpCustomerVO> searchBkgCustomer(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchBkgCustomerRSQL(), param, null, AdvJpCustomerVO.class);
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
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOGetDescFromBkgDocRSQL(), param, null);
			return (dbRowset.next() ? dbRowset.getString("CSTMS_DESC") : "");
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
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchBkgMarkRSQL(), param, null, AdvJpMarkDescVO.class);
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
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchBkgContainerRSQL(), param, null, AdvJpContainerVO.class);
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
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAORemoveAdvJpContainerDSQL(), advJpBlVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
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
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAORemoveAdvJpMarkDescDSQL(), advJpBlVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
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
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAORemoveAdvJpCustomerDSQL(), advJpBlVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
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
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAORemoveAdvJpBlDSQL(), advJpBlVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
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
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAOAddAdvJpBlCSQL(), advJpBlVOList, null);
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
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAOAddAdvJpCustomerCSQL(), advJpCustomerVOList, null);
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
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAOAddAdvJpMarkDescCSQL(), advJpMarkDescVOList, null);
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
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAOAddAdvJpContainerCSQL(), advJpContainerVOList, null);
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
///// Data Download(E) ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (advJpBlVO != null) {
				Map<String, String> mapVO = advJpBlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchBLInquiryRSQL(), param, velParam, AdvJpBlVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 의 Tab2에 해당하는 Container 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpContainerVO> searchBLInquiryContainer(AdvJpBlVO advJpBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (advJpBlVO != null) {
				Map<String, String> mapVO = advJpBlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchBLInquiryContainerRSQL(), param, velParam, AdvJpContainerVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 의 Tab3에 해당하는 Mark & Desc 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpMarkDescVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdvJpMarkDescVO> searchBLInquiryMarkDesc(AdvJpBlVO advJpBlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (advJpBlVO != null) {
				Map<String, String> mapVO = advJpBlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchBLInquiryMarkDescRSQL(), param, velParam, AdvJpMarkDescVO.class);
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
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (getMdmCustomerVO != null) {
				Map<String, String> mapVO = getMdmCustomerVO.getColumnValues();
				param.putAll(mapVO);
			}
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOGetMdmCustomerRSQL(), param, null, GetMdmCustomerVO.class);
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
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (advJpBlVO != null) {
				Map<String, String> mapVO = advJpBlVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24ManifestListDownloadDBDAOModifyBLInquiryUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
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
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAOModifyBLInquiryCustomerUSQL(), advJpCustomerVOList, null);
				for(int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
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
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAOModifyBLInquiryContainerUSQL(), advJpContainerVOList, null);
				for(int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
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
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAORemoveBLInquiryContainerDSQL(), advJpContainerVOList, null);
				for(int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
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
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAOModifyBLInquiryMarkDescUSQL(), advJpMarkDescVOList, null);
				for(int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - Original B/L 조회
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BllSprtCmbnVO> searchOrgBlForBll(BllSprtCmbnVO bllSprtCmbnVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bllSprtCmbnVO != null) {
				Map<String, String> mapVO = bllSprtCmbnVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchOrgBlForBllRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BllSprtCmbnVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L (Non Sent) 목록 조회
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BllSprtCmbnVO> searchNewBlForBllByNonSent(BllSprtCmbnVO bllSprtCmbnVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bllSprtCmbnVO != null) {
				Map<String, String> mapVO = bllSprtCmbnVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchNewBlForBllByNonSentRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BllSprtCmbnVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L (Sent) 목록 조회
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BllSprtCmbnVO> searchNewBlForBllBySent(BllSprtCmbnVO bllSprtCmbnVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bllSprtCmbnVO != null) {
				Map<String, String> mapVO = bllSprtCmbnVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOSearchNewBlForBllBySentRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BllSprtCmbnVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 단건 조회
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BllSprtCmbnVO> searchNewBlForBllRowSearch(BllSprtCmbnVO bllSprtCmbnVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bllSprtCmbnVO != null) {
				Map<String, String> mapVO = bllSprtCmbnVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Jp24ManifestListDownloadDBDAOsearchNewBlForBllRowSearchRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BllSprtCmbnVO.class);
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 목록 삭제<br>
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @exception DAOException, Exception
	 */
	public void removeAdvJpBlRlt(BllSprtCmbnVO bllSprtCmbnVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bllSprtCmbnVO != null) {
				Map<String, String> mapVO = bllSprtCmbnVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Jp24ManifestListDownloadDBDAORemoveAdvJpBlRltDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 목록 신규 저장<br>
	 *
	 * @param List<BllSprtCmbnVO> bllSprtCmbnVOList
	 * @exception DAOException, Exception
	 */
	public void addAdvJpBlRlt(List<BllSprtCmbnVO> bllSprtCmbnVOList) throws DAOException, Exception {
		try {
			if (bllSprtCmbnVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new Jp24ManifestListDownloadDBDAOAddAdvJpBlRltCSQL(), bllSprtCmbnVOList, null);
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
