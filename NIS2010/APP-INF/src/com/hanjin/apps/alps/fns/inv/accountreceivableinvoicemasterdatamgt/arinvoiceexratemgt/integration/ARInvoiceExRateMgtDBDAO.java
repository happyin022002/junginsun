/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceExRateMgtDBDAO.java
 *@FileTitle : Ex. Rate Entry by Date
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CheckReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.GLMonExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS ARInvoiceExRateMgtDBDAO <br>
 * - ALPS-AccountReceivableInvoiceMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see ARInvoiceExRateMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ARInvoiceExRateMgtDBDAO extends DBDAOSupport {

	/**
	 * INV_VVD_XCH_RT 테이블에 조건에 해당하는 환율을 조회한다.<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return List<VVDExrateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VVDExrateVO> searchVVDExchangeRateList(SearchVVDExRateVO searchVVDexRateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VVDExrateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchVVDexRateVO != null) {
				Map<String, String> mapVO = searchVVDexRateVO.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = searchVVDexRateVO.getVvdCd();
				if (vvd.length()>8) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOsearchVVDExchangeRateListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VVDExrateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * INV_CUST_AND_DLY_XCH_RT 테이블에서 조회조건으로 select 한다.<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustDailyExRateVO> searchDailyExchangeRateList(SearchExRateVO searchExRateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustDailyExRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchExRateVO != null) {
				Map<String, String> mapVO = searchExRateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchExRateVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustDailyExRateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 입력된 Customer, Daily환율이 Key 중복은 물론 From ~ To date 기간의 중첩 여부를 Check하여 중복되는 데이터가 있을시 해당 정보를 다시 Return 함.<br>
	 * 중복되는 데이터가 있는 경우는 이전 전체를 RollBack한다.<br>
	 * 
	 * @param List<CustDailyExRateVO> custDailyExrateVOs
	 * @return CheckReturnVO
	 * @exception DAOException
	 */
	public CheckReturnVO searchCustomerDailyExchangeRate(List<CustDailyExRateVO> custDailyExrateVOs) throws DAOException {
		DBRowSet dbRowset = null;
		CheckReturnVO info = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (custDailyExrateVOs.size() > 0) {
				for (int i = 0; i < custDailyExrateVOs.size(); i++) {
					Map<String, String> mapVO = custDailyExrateVOs.get(i).getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchExRateDuplicateVORSQL(), param, velParam);
					if (dbRowset.next()) {
						info = new CheckReturnVO();
						info.setFmDt(dbRowset.getString("fm_dt"));
						info.setToDt(dbRowset.getString("to_dt"));
					}
					/*
					if (info != null) {
						throw new Exception("Duplicate Date[From Date:" + info.getFmDt() + ",To Date:" + info.getToDt() + "]");
					}
					*/
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return info;
	}

	/**
	 * INV_CUST_AND_DLY_XCH_RT 테이블에 insert<br>
	 * Daily 환율의 경우는 Customer를 XX-000000으로 대체하여 저장한다.<br>
	 * Customer 환율의 여러 Customer 일괄 반영의 경우는 insert 시 중복발생하면 update를 해주도록 한다.<br>
	 * 
	 * @param List<CustDailyExRateVO> custDailyExrateVOs
	 * @exception DAOException
	 */
	public void addCustomerDailyExchangeRate(List<CustDailyExRateVO> custDailyExrateVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (custDailyExrateVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchExRateVOCSQL(), custDailyExrateVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_CUST_AND_DLY_XCH_RT테이블에 update<br>
	 * 
	 * @param List<CustDailyExRateVO> custDailyExrateVOs
	 * @exception DAOException
	 */
	public void modifyCustomerDailyExchangeRate(List<CustDailyExRateVO> custDailyExrateVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (custDailyExrateVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchExRateVOUSQL(), custDailyExrateVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_CUST_AND_DLY_XCH_RT 테이블에 delete<br>
	 * 
	 * @param List<CustDailyExRateVO> custDailyExrateVOs
	 * @exception DAOException
	 */
	public void removeCustomerDailyExchangeRate(List<CustDailyExRateVO> custDailyExrateVOs ) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (custDailyExrateVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchExRateVODSQL(), custDailyExrateVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_CUST_AND_DLY_XCH_RT 테이블에서 조회조건으로 select 한다.<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustDailyExRateVO> searchCustomerExchangeRateList(SearchExRateVO searchExRateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustDailyExRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchExRateVO != null) {
				Map<String, String> mapVO = searchExRateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchCustomerExchangeRateListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustDailyExRateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 해당 Customer로 해당월에 환율이 존재하는지를 확인한다.<br>
	 * 
	 * @param String cust_cnt_cd
	 * @param String cust_seq
	 * @param String mon
	 * @return int
	 * @exception DAOException
	 */
	public int searchCustomerMonExRate(String cust_cnt_cd, String cust_seq, String mon) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int cnt = 0;
		try {
			param.put("cust_cnt_cd", cust_cnt_cd);
			param.put("cust_seq", cust_seq);
			param.put("mon", mon);

			velParam.put("cust_cnt_cd", cust_cnt_cd);
			velParam.put("cust_seq", cust_seq);
			velParam.put("mon", mon);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchCustomerMonExRateVORSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * [in]환율과 기간 중첩 및 중복되는 환율데이터를 조회하여 Return한다. <br>
	 * 
	 * @param CustDailyExRateVO custDailyExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustDailyExRateVO> searchMultiCustomerExRate(CustDailyExRateVO custDailyExRateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustDailyExRateVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (custDailyExRateVO != null) {
				Map<String, String> mapVO = custDailyExRateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchMultiCustomerExRateVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustDailyExRateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * LOCATION 테이블에서 Office 의 contry code에 해당하는 PORT를 조회하여 해당 List에 Setting한다.<br>
	 * Office 의 contry code에 해당하는 PORT를 조회<br>
	 * 
	 * @param String svrId
	 * @param String ofc
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchPortList(String svrId, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		String locCd = "";

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("svr_id", svrId);
			param.put("ofc_cd", ofc);

			velParam.put("svr_id", svrId);
			velParam.put("ofc_cd", ofc);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOsearchPortListVORSQL(), param, velParam);
			while (dbRowset.next()) {
				locCd = dbRowset.getString("loc_cd");

				list.add(locCd);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * I/B, O/B 조건으로 운항정보에서 대상 VVD, PORT list를 조회한다.<br>
	 * 
	 * @param SearchVVDPortVO searchByBndVo
	 * @return List<VVDandPortListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VVDandPortListVO> searchPortListByBnd(SearchVVDPortVO searchByBndVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VVDandPortListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchByBndVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchPortListByBndVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VVDandPortListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * triagle 조건으로 운항정보에서 대상 VVD, PORT list를 조회한다.<br>
	 * 
	 * @param SearchVVDPortVO searchByBndVO
	 * @return List<VVDandPortListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VVDandPortListVO> searchPortListByTri(SearchVVDPortVO searchByBndVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VVDandPortListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchByBndVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOsearchPortListByTriVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VVDandPortListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EUR일때 운항정보에서 대상 VVD, PORT list를 조회한다.<br>
	 * 
	 * @param SearchVVDPortVO searchByBndVO
	 * @return List<VVDandPortListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VVDandPortListVO> searchEURPortList(SearchVVDPortVO searchByBndVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VVDandPortListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchByBndVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchEURPortListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VVDandPortListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EUR일때 운항정보에서 Create 대상 VVD, PORT list를 조회한다.<br>
	 * 
	 * @param String vvd_cd
	 * @return List<VVDandPortListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VVDandPortListVO> searchEURVVDList(String vvd_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<VVDandPortListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("vvd_cd", vvd_cd);

			velParam.put("vvd_cd", vvd_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchEURVVDListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VVDandPortListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * INV_VVD_XCH_RT 테이블에서 이미 등록된 해당 환율이 존재 하는지 조회한다.<br>
	 * 
	 * @param VVDExrateVO vvdExrateVos
	 * @return int
	 * @exception DAOException
	 */
	public int searchVVDExchangeRate(VVDExrateVO vvdExrateVOs) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int cnt = 0;
		try {
			Map<String, String> mapVO = vvdExrateVOs.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOsearchVVDExchangeRateVORSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * INV_VVD_XCH_RT 테이블에 update.<br>
	 * 
	 * @author saeil
	 * @param List<VVDExrateVO> vvdExrateVos
	 * @exception DAOException
	 */
	public void modifyVVDExchangeRate(List<VVDExrateVO> vvdExrateVos) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (vvdExrateVos.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceExRateMgtDBDAOmodifyVVDExchangeRateVOUSQL(), vvdExrateVos, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_VVD_XCH_RT 테이블에 insert.<br>
	 * 
	 * @param List<VVDExrateVO> vvdExrateVos
	 * @exception DAOException
	 */
	public void addVVDExchangeRate(List<VVDExrateVO> vvdExrateVos) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (vvdExrateVos.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceExRateMgtDBDAOaddVVDExchangeRateVOCSQL(), vvdExrateVos, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV AR CHARGE 테이블에서 해당 환율이 반영된 데이터가 존재하는지 CHECK.<br>
	 * 
	 * @param ExchangeRateVO exRateVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchARInvoiceExist(ExchangeRateVO exRateVO ) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String cnt = "";
		try {
			Map<String, String> mapVO = exRateVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOsearchARInvoiceExistVORSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getString("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * INV_VVD_XCH_RT 테이블에 delete<br>
	 * 
	 * @param List<VVDExrateVO> vvdExrateVOs
	 * @exception DAOException
	 */
	public void removeVVDExchangeRate(List<VVDExrateVO> vvdExrateVOs ) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (vvdExrateVOs .size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceExRateMgtDBDAORemoveVVDExchangeRateVODSQL(), vvdExrateVOs , null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * GL_MON_XCH_RT 테이블에서 조회조건으로 select 한다.<br>
	 * 
	 * @param String fromMon
	 * @param String toMon
	 * @param String lclCur
	 * @return List<GLMonExrateVO>
	 */
	@SuppressWarnings("unchecked")
	public List<GLMonExrateVO> searchGLMonExRateList(String fromMon, String toMon, String lclCur) throws DAOException {
		DBRowSet dbRowset = null;
		List<GLMonExrateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (fromMon != null && toMon != null && lclCur != null) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("from_yrmon", fromMon);
				mapVO.put("to_yrmon", toMon);
				mapVO.put("curr_cd", lclCur);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchGLMonExRateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GLMonExrateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * INV_CUST_AND_DLY_XCH_RT 테이블에서 조회조건으로 select 한다.<br>
	 * Customer 환율('I'), Daily('D'), China  Daily('C')<br>
	 * Daily('D'), China  Daily('C') 인 경우는 CUST_CNT_CD='XX' and CUST_SEQ=0으로 한다.
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustDailyExRateVO> searchCustomerDailyExchangeRateList(SearchExRateVO searchExRateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustDailyExRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchExRateVO != null) {
				Map<String, String> mapVO = searchExRateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchCustomerDailyExchangeRateListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustDailyExRateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * INV_VVD_XCH_RT 테이블에 조건에 해당하는 환율을 조회한다.<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return List<VVDExrateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VVDExrateVO> searchVVDExchangeRateInquiryList(SearchVVDExRateVO searchVVDexRateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VVDExrateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchVVDexRateVO != null) {
				Map<String, String> mapVO = searchVVDexRateVO.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = searchVVDexRateVO.getVvdCd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchVVDExchangeRateInquiryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VVDExrateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * MDM_ORGANIZATION 테이블에서 해당 Currency 가 AR Currency로 존재하는지 체크.<br>
	 * 
	 * @param String ofc
	 * @param String currCd
	 * @return int
	 * @exception DAOException
	 */
	public int searchARCurrCd( String ofc, String currCd ) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int cnt = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("curr_cd", currCd);
			mapVO.put("ofc", ofc);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceExRateMgtDBDAOSearchARCurrCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}
}
