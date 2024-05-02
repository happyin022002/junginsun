/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ManualARCreationDAO.java
 *@FileTitle : Other Revenue Invoice Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.04.27 김세일
 * 1.0 Creation
* --------------------------------------------------------
* History
* 2011.02.08 최도순 [CHM-201108232] DEM/DET 에서 INV로 INTERFACE 시 I/F NO 누락 방지를 위한 로직 변경
* 2011.11.14 오요한 [CHM-201113617] SVAT Reg. No for CMBSC
* 2011.11.23 권 민 [CHM-201114430-01] MRI 생성 관련 CREDIT TERM 로직 보완 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGQtyVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGRefNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGTvvdPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGVVDSaDtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.CustomerDueDtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.RevenueAcctVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.VvdVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS ManualARCreationDAO <br>
 * - ALPS-AccountReceivableInvoiceCreation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see ManualARCreationBCImpl 참조
 * @since J2EE 1.4
 */
public class ManualARCreationDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	
	/**
	 * ManualARCreationDBDAO 객체 생성<br>
	 * ManualARCreationDBDAO 를 생성한다.<br>
	 */
	public ManualARCreationDBDAO() { }
	
	/**
	 * ManualARCreationDBDAO 객체 생성<br>
	 * ManualARCreationDBDAO 를 생성한다.<br>
	 * @param String dataSource
	 */
	public ManualARCreationDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOfficeRevenueSourceList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String tmlInvIssFlg = "N";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchRevTypeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		tmlInvIssFlg = dbRowset.getString(1);
	    	}
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return tmlInvIssFlg;
	}

	/**
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGInvoiceVO> searchRHQGoodInvMaxInterface(String blNo, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGInvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchRHQGoodInvMaxInterfaceKorRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGInvoiceVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGContainerVO> searchRHQGoodCntrMaxInterface(String blNo, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchRHQGoodCntrMaxInterfaceKorRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGInvoiceVO> searchRHQNoGoodInvMaxInterface(String blNo, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGInvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchRHQNoGoodInvMaxInterfaceKorRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGInvoiceVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGContainerVO> searchRHQNoGoodCntrMaxInterface(String blNo, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchRHQNoGoodCntrMaxInterfaceKorRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<BKGInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGInvoiceVO> searchOFCGoodInvMaxInterface(String ofcCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGInvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchOFCGoodInvMaxInterfaceRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGInvoiceVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<BKGContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGContainerVO> searchOFCGoodCntrMaxInterface(String ofcCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchOFCGoodCntrMaxInterfaceRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<BKGInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGInvoiceVO> searchOFCNoGoodInvMaxInterface(String ofcCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGInvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchOFCNoGoodInvMaxInterfaceRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGInvoiceVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<BKGContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGContainerVO> searchOFCNoGoodCntrMaxInterface(String ofcCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchOFCNoGoodCntrMaxInterfaceRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String blNo
	 * @param String bkgNo
	 * @return List<BKGMainVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGMainVO> searchBKGMain(String blNo, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBKGMainRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGMainVO.class);
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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo
	 * @param String bnd
	 * @return String
	 * @exception DAOException
	 */
	public String searchBKGPortCd(String bkgNo, String bnd) throws DAOException {
		DBRowSet dbRowset = null;
		String port = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bnd", bnd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBKGPortCdRSQL(), param, velParam);
			while (dbRowset.next()) {
				port = dbRowset.getString("port");
			}
			// list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return port;
	}

	/**
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo
	 * @param String bnd
	 * @param String portCd
	 * @return List<BKGVVDSaDtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGVVDSaDtVO> searchBKGVVDSaDt(String bkgNo, String bnd, String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGVVDSaDtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bnd", bnd);
			mapVO.put("port_cd", portCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBKGVVDSaDtRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGVVDSaDtVO.class);

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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo
	 * @param String bnd
	 * @return List<BKGTvvdPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGTvvdPortVO> searchBKGTvvdPortCd(String bkgNo, String bnd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGTvvdPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bnd", bnd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBKGTvvdPortCdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGTvvdPortVO.class);

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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String vvdCd
	 * @param String bnd
	 * @param String portCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchBKGSaDtForTvvd(String vvdCd, String bnd, String portCd) throws DAOException {
		log.info("########## searchBKGSaDtForTvvd");
		DBRowSet dbRowset = null;
		String sailArrDt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("vvl_cd", vvdCd);
			mapVO.put("bnd", bnd);
			mapVO.put("port_cd", portCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBKGSaDtForTvvdRSQL(), param, velParam);
			while (dbRowset.next()) {
				sailArrDt = dbRowset.getString("sail_arr_dt");
			}
			// list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sailArrDt;
	}

	/**
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo
	 * @return List<BKGQtyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGQtyVO> searchBKGQuantity(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGQtyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBKGQuantityRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGQtyVO.class);

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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo
	 * @return List<BKGRefNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGRefNoVO> searchBKGRefNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGRefNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBKGRefNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGRefNoVO.class);

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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @param String bnd
	 * @param String sailArrDt
	 * @return List<CustomerDueDtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerDueDtVO> searchCustomerDueDt(String ofcCd, String bnd, String sailArrDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerDueDtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("bnd", bnd);
			mapVO.put("sail_arr_dt", sailArrDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchCustomerDueDtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerDueDtVO.class);

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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo
	 * @return List<BKGContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGContainerVO> searchBKGContainerList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBKGContainerListRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO.class);

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
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String chgCd
	 * @param String ofcCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchLocalChargeExist(String chgCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean existYn = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("chg_cd", chgCd);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchLocalChargeExistRSQL(), param, velParam);
			while (dbRowset.next()) {
				if (dbRowset.getInt("cnt") > 0) {
					existYn = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return existYn;
	}

	/**
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String vsl
	 * @param String voy
	 * @param String dep
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchVesselSKD(String vsl, String voy, String dep) throws DAOException {
		DBRowSet dbRowset = null;
		boolean existYn = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("vsl", vsl);
			mapVO.put("voy", voy);
			mapVO.put("dep", dep);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchVesselSKDRSQL(), param, velParam);
			while (dbRowset.next()) {
				if (dbRowset.getInt("cnt") > 0) {
					existYn = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return existYn;
	}

	/**
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String scp
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchServiceScope(String scp) throws DAOException {
		DBRowSet dbRowset = null;
		boolean existYn = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("scp", scp);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchServiceScopeRSQL(), param, velParam);
			while (dbRowset.next()) {
				if (dbRowset.getInt("cnt") > 0) {
					existYn = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return existYn;
	}

	/**
	 * ManualARCreationDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String vsl
	 * @param String voy
	 * @param String dep
	 * @param String port
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchVesselPortSKD(String vsl, String voy, String dep, String port) throws DAOException {
		DBRowSet dbRowset = null;
		boolean existYn = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("vsl", vsl);
			mapVO.put("voy", voy);
			mapVO.put("dep", dep);
			mapVO.put("port", port);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchVesselPortSKDRSQL(), param, velParam);
			while (dbRowset.next()) {
				if (dbRowset.getInt("cnt") > 0) {
					existYn = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return existYn;
	}

	/**
	 * INV_AR_MRI_IF_NO table 에서 MRI_MAX_SEQ 조회. <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMRIInterfaceNo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String mriMaxSeq = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchMRIInterfaceNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				mriMaxSeq = dbRowset.getString("mri_max_seq");
			}
			// list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO .class);
			// log.info("########## mri_max_seq : "+mri_max_seq);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mriMaxSeq;
	}

	/**
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ insert <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addMRIInterfaceNo(String ofcCd, String userId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt = 0;

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("user_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			// insCnt = sqlExe.executeBatch((ISQLTemplate)new ManualARCreationDBDAOaddMRIInterfaceNoCSQL(), insertVoList,null);
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new ManualARCreationDBDAOaddMRIInterfaceNoCSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ update <br>
	 * 
	 * @param String ofcCd
	 * @param String mriMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyMRIInterfaceNo(String ofcCd, String mriMaxSeq, String userId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt = 0;

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("mri_max_seq", mriMaxSeq);
			mapVO.put("user_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			// insCnt = sqlExe.executeBatch((ISQLTemplate)new ManualARCreationDBDAOaddMRIInterfaceNoCSQL(), insertVoList,null);
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new ManualARCreationDBDAOmodifyMRIInterfaceNoUSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Revenue Account 테이블을 Select<br>
	 * @param String ofcCd
	 * @param String rhqOfcCd
	 * @return List<RevenueAcctVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RevenueAcctVO> searchRevenueAcctCdList(String ofcCd, String rhqOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RevenueAcctVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

//			if(ofcCd.equals("SELADG")){ 두바이, 발렌시아
//				mapVO.put("acct_cd", "954117");
//			}
 
			mapVO.put("rhq_cd", rhqOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAORevenueAcctVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO.class);
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
	 * Closing Status 테이블을 select<br>
	 * 
	 * @param String ofc
	 * @param String effDt
	 * @param String pgmGubn
	 * @return String
	 * @exception DAOException
	 */
	public String searchClosingStatus(String ofc, String effDt, String pgmGubn) throws DAOException {
		DBRowSet dbRowset = null;
		String clzStsCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("eff_dt", effDt);
			mapVO.put("ofc", ofc);
			mapVO.put("pgm_gubn", pgmGubn);			

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchClosingStatusRSQL(), param, velParam);
			while (dbRowset.next()) {
				clzStsCd = dbRowset.getString("clz_sts_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return clzStsCd;
	}

	/**
	 * Closing Status 테이블을 select<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAutoBLNo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String blMaxNo = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = sqlExe.executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchAutoBLNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				blMaxNo = dbRowset.getString("bl_max_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blMaxNo;
	}

	/**
	 * Auto B/L No 등록한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String blMaxNo
	 * @param String userId
	 * @exception DAOException
	 */
	public void addNewBLNo(String ofcCd, String blMaxNo, String userId) throws DAOException {
		String blCreDt = "";
		int insCnt = 0;

		// query parameter
		Map<String, Object> paramIns = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParamIns = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);

			blCreDt = blMaxNo.substring(3, 9);

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_pfx_cd", ofcCd.substring(0, 3));
			mapVO.put("bl_cre_dt", blCreDt);
			mapVO.put("cre_usr_id", userId);
			mapVO.put("upd_usr_id", userId);
			mapVO.put("ofc_cd", ofcCd);			

			paramIns.putAll(mapVO);
			velParamIns.putAll(mapVO);
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new ManualARCreationDBDAOAddAutoBLNoCSQL(), paramIns, velParamIns);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L No seq를 업데이트한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String blMaxNo
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyNewBLNo(String ofcCd, String blMaxNo, String userId) throws DAOException {
		String blMaxSeq = "";
		String blCreDt = "";
		int insCnt = 0;

		Map<String, Object> paramIns = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParamIns = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);

			blMaxSeq = blMaxNo.substring(9, 12);
			blCreDt = blMaxNo.substring(3, 9);

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_pfx_cd", ofcCd.substring(0, 3));
			mapVO.put("bl_max_seq", String.valueOf(Integer.parseInt(blMaxSeq) - 1));
			mapVO.put("bl_cre_dt", blCreDt);
			mapVO.put("upd_usr_id", userId);
			mapVO.put("ofc_cd", ofcCd);

			paramIns.putAll(mapVO);
			velParamIns.putAll(mapVO);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new ManualARCreationDBDAOModifyBLNoUSQL(), paramIns, velParamIns);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Invoice Main, Invoice Charge, Security 테이블을 Select<br>
	 * 
	 * @param NonShippingInputVO mthVo
	 * @return List<NonShippingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NonShippingListVO> searchNonShippingARList(NonShippingInputVO mthVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<NonShippingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mthVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchNonShippingARListRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, NonShippingListVO.class);
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
	 * Sequence 객체 사용<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSlipNo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String slipNo = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofcCd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = sqlExe.executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchSlipNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				slipNo = dbRowset.getString("seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return slipNo;
	}

	/**
	 * Invoice Main, Customer, Account 테이블을 Select<br>
	 * 
	 * @param String ifNo
	 * @return NonShippingMainVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public NonShippingMainVO searchNonShippingARMain(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<NonShippingMainVO> list = null;
		NonShippingMainVO nonShippingMainVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ifNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ar_if_no", ifNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchNonShippingARMainRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, NonShippingMainVO.class);

			if (list != null && list.size() > 0) {
				nonShippingMainVO = (NonShippingMainVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return nonShippingMainVO;
	}

	/**
	 * Invoice Charge 테이블에서 Select<br>
	 * 
	 * @param String ifNo
	 * @return List<NonShippingChargeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NonShippingChargeVO> searchNonShippingARCharge(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<NonShippingChargeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ifNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ar_if_no", ifNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchNonShippingARChargeRSQL(), param, velParam);

				list = (List) RowSetUtil.rowSetToVOs(dbRowset, NonShippingChargeVO.class);
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
	 * 해당 BL_SRC NO, AR_OFC_CD의 MAX(AR_IF_NO)의 ACT_CUST_CNT_CD, ACT_CUST_SEQ 관련 정보를 가져온다.<br>
	 * 테이블 : INV_AR_MN, MDM_CR_CUST, MDM_ORGANIZATION<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<ARCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARCustomerVO> searchBLCustomer(String ofcCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARCustomerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("bl_src_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchBLCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARCustomerVO.class);
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
	 * Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String arIfNo
	 * @return InvArMnVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvArMnVO searchMiscellaneousARByIFNo(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArMnVO> list = null;
		InvArMnVO invArMnVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchMiscellaneousARByIFNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvArMnVO.class);

			if (list != null && list.size() > 0) {
				invArMnVO = (InvArMnVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invArMnVO;
	}

	/**
	 * Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String arIfNo
	 * @return List<InvArChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArChgVO> searchMiscellaneousARChg(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArChgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchMiscellaneousARChgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvArChgVO.class);
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
	 * Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String arIfNo
	 * @return List<InvArCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArCntrVO> searchMiscellaneousARCntr(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArCntrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchMiscellaneousARCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvArCntrVO.class);
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
	 * Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String arIfNo
	 * @return List<ARInvoiceChargeSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeSumVO> searchMiscellaneousARChgSum(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeSumVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchMiscellaneousARChgSumRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeSumVO.class);
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
	 * INV_AR_MN, MDM_ORGANIZATION, BKG_REFERENCE 테이블에서 SELECT. <br>
	 * 
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGInvoiceVO> searchRHQInvMaxInterfacebyMRI(String blNo, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGInvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchRHQInvMaxInterfacebyMRIRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGInvoiceVO.class);
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
	 * INV_AR_MN, MDM_ORGANIZATION, INV_AR_CNTR 테이블에서 SELECT. <br>
	 * 
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGContainerVO> searchRHQCntrMaxInterfacebyMRI(String blNo, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchRHQCntrMaxInterfacebyMRIRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO.class);
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
	 * INV_AR_MN, BKG_REFERENCE 테이블에서 REV_TP_CD = 'M' 으로 SELECT.<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<BKGInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGInvoiceVO> searchOFCInvMaxInterfacebyMRI(String ofcCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGInvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchOFCInvMaxInterfacebyMRIRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGInvoiceVO.class);
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
	 * INV_AR_MN, INV_AR_CNTR 테이블에서 REV_TP_CD = 'M' 으로 SELECT.<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<BKGContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGContainerVO> searchOFCCntrMaxInterfacebyMRI(String ofcCd, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchOFCCntrMaxInterfacebyMRIRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO.class);
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
	 * office 별 Local Time 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalTime(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String localTime = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new ManualARCreationDBDAOsearchLocalTimeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		localTime = dbRowset.getString(1);
	    	}
	    	//log.info("\n########## localTime : "+localTime);
	    	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return localTime;
	}	
	
	/**
	 * office 별 block charge 조회 <br>
	 * 
	 * @param String chgCd
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchBlckChg(String chgCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String blckChg = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("chg_cd", chgCd);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchBlckChgRSQL(), param, velParam);
			while (dbRowset.next()) {
				blckChg = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blckChg;
	}
	
	/**
	 * Location 테이블에서 select<br>
	 * 
	 * @param String port
	 * @return int
	 * @exception DAOException
	 */
	public int checkPort ( String port )throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", port);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new ManualARCreationDBDAOCheckPortVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}

	/**
	 * VLCSC, MIC 일 경우 입력된 MIV 의 IVA 요율을 가져온다.<br>
	 * 
	 * @param String mstIfNo
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchIvaRateMstIFNo (String mstIfNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String ivaRate = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mst_if_no", mstIfNo);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchIvaRateMstIFNoRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		ivaRate = dbRowset.getString("iva_rate");
	    	}
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ivaRate;
	}
	
	/**
	 * CMBSC일 경우 입력된 CustCd로 INV_AR_SPND_VAT_RGST_NO테이블에서 SPND_VAT_RGST_NO값을 가져온다. <br>
	 * 
	 * @param String cntryCd
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSpndVatRgstNo(String cntryCd, String custCd) throws DAOException {
		DBRowSet dbRowset = null;
		String invArSpndVatRgstNo = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", cntryCd);
			mapVO.put("cust_seq", custCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchSpndVatRgstNoRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		invArSpndVatRgstNo = dbRowset.getString("SPND_VAT_RGST_NO");
	    	}
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invArSpndVatRgstNo;
	}
	
	/**
	 * SA Date 에 따른 Due Date 값을 계산하여 가져온다. <br>
	 * 
	 * @param String bnd
	 * @param String saDate
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchDueDate(String bnd, String saDate, String custCntCd, String custSeq, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		String dueDate = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bnd", bnd);
			mapVO.put("sa_dt", saDate);
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchDueDateRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		dueDate = dbRowset.getString("DUE_DT");
	    	}
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dueDate;
	}
	
	
	/**
	 * VVD변경여부를 판별하기위해 BKG으로부터 VVD정보를 가져온다.<br>
	 * 
	 * @param String blNo
	 * @return VvdVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public VvdVO searchVvdByBkgNo(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdVO> list = null;
		VvdVO vvdVo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOsearchVvdByBkgNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VvdVO.class);

			if (list != null && list.size() > 0) {
				vvdVo = (VvdVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvdVo;
	}
	
	/**
	 * POL_CD, POD_CD 를 이용하여 EU여부를 체크한다. <br>
	 * 
	 * @param String cntryCd
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String searchEuCheck(String polCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		String euCehck = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("pol_cd", polCd);
			mapVO.put("pod_cd", podCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new ManualARCreationDBDAOSearchEuCheckRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		euCehck = dbRowset.getString("EU_CHECK");
	    	}
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return euCehck;
	}
	
}
