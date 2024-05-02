/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GeneralARInvoiceMasterDataMgtDBDAO.java
 *@FileTitle : Revenue Lane Inquiry by Order
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.07 최도순 [CHM-201005726] ALPS > Cut Over VVD Creation for New A/R Office 보완 요청
 * 2010.11.23 이석준 [CHM-201006884] FNS_INV_0114 신규 개발(조회,저장 기능 추가)
 * 2011.05.12 김태균 [CHM-201110564-01] AR Invoice - VVD 조회 기능 개발 요청 - 신규
 * 2011.08.04 오요한 [CHM-201112323] ALPS 코드 속성 작업 결과에 따른 기 메뉴 삭제된 ALPS INV 소스 삭제
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic.GeneralARInvoiceMasterDataMgtBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArBankListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArLoclChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.LaneOrderInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.LaneOrderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.MdmOfcInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.MdmOrganizationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PHILSLocationListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PrinterbyUserIdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.ProcessingVvdListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueProcessParamVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueVvdListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvChgDescConvVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ArFincDirConvVO;
import com.hanjin.syscommon.common.table.InvArBankVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdDtlVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdVO;
import com.hanjin.syscommon.common.table.InvRevAcctCdVO;

/**
 * ALPS GeneralARInvoiceMasterDataMgtDBDAO <br>
 * - ALPS-AccountReceivableInvoiceMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see GeneralARInvoiceMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GeneralARInvoiceMasterDataMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * GeneralARInvoiceMasterDataMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param LaneOrderInPutVO lanOrdInputVo
	 * @return List<LaneOrderVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LaneOrderVO> searchRevenueLaneOrderList(LaneOrderInPutVO lanOrdInputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<LaneOrderVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (lanOrdInputVo != null) {
				Map<String, String> mapVO = lanOrdInputVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOLaneOrderInPutVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LaneOrderInPutVO.class);
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
	 * GeneralARInvoiceMasterDataMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ArFincDirConvVO arFincDirConvVO
	 * @return List<ArFincDirConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ArFincDirConvVO> searchRevenueVesselDirectionCodeConversionList(ArFincDirConvVO arFincDirConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ArFincDirConvVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (arFincDirConvVO != null) {
				Map<String, String> mapVO = arFincDirConvVO.getColumnValues();
				log.info(mapVO.toString());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOMdmRevLaneVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ArFincDirConvVO.class);
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
	 * INV_AR_BANK 테이블에서 BANK 정보 SELECT <br>
	 * 
	 * @param String arOfc
	 * @param String saleOfc
	 * @return List<InvArBankListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArBankListVO> searchBankAccountList(String arOfc, String saleOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArBankListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfc);
			mapVO.put("ofc_cd", saleOfc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArBankVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvArBankListVO.class);
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
	 * INV_AR_BANK 테이블에 INSERT <br>
	 * 
	 * @param List<InvArBankVO> bAcctVOs
	 * @exception DAOException
	 */
	public void addBankAccount(List<InvArBankVO> bAcctVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bAcctVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArBankVOCSQL(), bAcctVOs, null);
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
	 * INV_AR_BANK 테이블 UPDATE <br>
	 * 
	 * @param List<InvArBankVO> bAcctVOs
	 * @exception DAOException
	 */
	public void modifyBankAccount(List<InvArBankVO> bAcctVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bAcctVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArBankVOUSQL(), bAcctVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
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
	 * INV_AR_BANK 테이블 DELETE <br>
	 * 
	 * @param List<InvArBankVO> bAcctVOs
	 * @exception DAOException
	 */
	public void removeBankAccount(List<InvArBankVO> bAcctVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (bAcctVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArBankVODSQL(), bAcctVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
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
	 * MDM_ORGANIGATION 테이블에 해당 Office 의 AR Office정보를 구하여 화면상의 AR Office 와 동일한지를 확인한다. <br>
	 * 
	 * @param String arOfc
	 * @param String saleOfc
	 * @return String
	 * @exception DAOException
	 */
	public String searchSalesOffice(String arOfc, String saleOfc) throws DAOException {
		DBRowSet dbRowset = null;
		String ofcCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfc);
			mapVO.put("ofc_cd", saleOfc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArBankVOCHKRSQL(), param, velParam);
			if (dbRowset.next()) {
				ofcCd = dbRowset.getString("ar_ofc_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ofcCd;
	}

	/**
	 * INV_REV_ACCT_CD 테이블에서 SELECT <br>
	 * 
	 * @param String source
	 * @param String revGroup
	 * @param String del
	 * @return List<InvRevAcctCdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvRevAcctCdVO> searchRevenueAccountList(String source, String revGroup, String del) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvRevAcctCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("source", source);
			mapVO.put("rev_group", revGroup);
			mapVO.put("del", del);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvRevAcctCdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvRevAcctCdVO.class);
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
	 * ofc, location조건으로 INV_AR_LOCL_CHG 테이블에서 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @param String locCd
	 * @return List<InvArLoclChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArLoclChgVO> searchLocalChargeList(String ofc, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArLoclChgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofc);
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArLoclChgVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvArLoclChgVO.class);
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
	 * ofc에 따라 loc_cd 를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchLocalChargeLocationList(String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		String strLocCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofc);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArLoclCdVORSQL(), param, velParam);
			while (dbRowset.next()) {
				strLocCd = dbRowset.getString("loc_cd");

				list.add(strLocCd);
			}
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
	 * Local에서 사용하는 Charge code를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String acctCd
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String searchMDMAccount(String acctCd) throws DAOException {
		DBRowSet dbRowset = null;		
		String strAcctCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("acct_cd", acctCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArAcctCdVORSQL(), param, velParam);
			if (dbRowset.next()) {
				strAcctCd = dbRowset.getString("acct_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strAcctCd;
	}

	/**
	 * INV_AR_LOCL_CHG 테이블에 insert 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvArLoclChgVO> lclChgVOs
	 * @exception DAOException
	 */
	public void addLocalChg(List<InvArLoclChgVO> lclChgVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (lclChgVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArLoclChgVOCSQL(), lclChgVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INV_AR_LOCL_CHG 테이블에 update 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvArLoclChgVO> lclChgVOs
	 * @exception DAOException
	 */
	public void modifyLocalChg(List<InvArLoclChgVO> lclChgVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (lclChgVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArLoclChgVOUSQL(), lclChgVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INV_AR_LOCL_CHG 테이블에 delete 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvArLoclChgVO> lclChgVOs
	 * @exception DAOException
	 */
	public void removeLocalChg(List<InvArLoclChgVO> lclChgVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (lclChgVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArLoclChgVODSQL(), lclChgVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * inv_cut_off_lane 테이블에서 old ofc, new ofc 조건으로 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String oldOfc
	 * @param String newOfc
	 * @return List<InvCutOffLaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvCutOffLaneVO> searchCutOffLaneListByAROffice(String oldOfc, String newOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvCutOffLaneVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("old_ar_ofc_cd", oldOfc);
			mapVO.put("new_ar_ofc_cd", newOfc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvCutOffLaneVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvCutOffLaneVO.class);
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
	 * inv_cut_off_lane 테이블에 insert 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCutOffLaneVO> cutLanVOs
	 * @exception DAOException
	 */
	public void addCutOffLaneByAROffice(List<InvCutOffLaneVO> cutLanVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (cutLanVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvCutOffLaneVOCSQL(), cutLanVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * inv_cut_off_lane 테이블에 update 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCutOffLaneVO> cutLanVOs
	 * @exception DAOException
	 */
	public void modifyCutOffLaneByAROffice(List<InvCutOffLaneVO> cutLanVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cutLanVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvCutOffLaneVOUSQL(), cutLanVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * inv_cut_off_lane 테이블에 delete 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCutOffLaneVO> cutLanVOs
	 * @exception DAOException
	 */
	public void removeCutOffLaneByAROffice(List<InvCutOffLaneVO> cutLanVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (cutLanVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvCutOffLaneVODSQL(), cutLanVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * mdm_vsl_svc_lane 테이블에 존재하는 code인지 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String lane
	 * @return String
	 * @exception DAOException
	 */
	public String searchSvcLane(String lane) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String slan_cd = "";

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_slan_cd", lane);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOSvcLaneVORSQL(), param, velParam);
			if (dbRowset.next()) {
				slan_cd = dbRowset.getString("slan_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return slan_cd;
	}

	/**
	 * MDM_LOCATION 테이블에 존재하는 code인지 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String port
	 * @return String
	 * @exception EventException
	 */
	public String searchLocation(String port) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String port_cd = "";

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("port_cd", port);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOMdmLocationVORSQL(), param, velParam);
			if (dbRowset.next()) {
				port_cd = dbRowset.getString("port_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return port_cd;
	}

	/**
	 * vsk_vsl_skd테이블에 존재하는 vvd인지 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchVVD(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String vsl_cd = "";

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOVskVslSkdRSQL(), param, velParam);
			if (dbRowset.next()) {
				vsl_cd = dbRowset.getString("vsl_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vsl_cd;
	}

	/**
	 * INV_AR_STUP_OFC 테이블에 select 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @return InvArStupOfcVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvArStupOfcVO searchIssueStandardByOffice(String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArStupOfcVO> list = null;
		InvArStupOfcVO invArStupOfcVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvArStupOfcVO.class);
			if (list != null && list.size() > 0) {
				invArStupOfcVO =  (InvArStupOfcVO)list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invArStupOfcVO;
	}

	/**
	 * INV_AR_MISC_BLCK_CHG 테이블에 select 조회한다.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String ofc
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchMiscBlckChgList(String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		String strChgCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOArMiscBlckChgVORSQL(), param, velParam);
			while (dbRowset.next()) {
				strChgCd = dbRowset.getString("chg_cd");

				list.add(strChgCd);
			}
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
	 * INV_AR_MISC_BLCK_CHG 테이블에서 해당 Office 내용을 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @exception DAOException
	 */
	public void removeMiscBlckChg(String ofc) throws DAOException, Exception {
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOArMiscBlckChgVODSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INV_AR_MISC_BLCK_CHG 테이블에서 해당 Office 내용을 등록한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @param String chgCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addMiscBlckChg(String ofc, String chgCd, String userId) throws DAOException, Exception {
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofc);
			mapVO.put("chg_cd", chgCd);
			mapVO.put("cre_usr_id", userId);
			mapVO.put("upd_usr_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOArMiscBlckChgVOCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INV_AR_STUP_OFC 테이블에 insert 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvArStupOfcVO issStnVO
	 * @exception DAOException
	 */
	public void addSetupOffice(InvArStupOfcVO issStnVO) throws DAOException, Exception {
		int insCnt = 0;
		// query parameter
		Map<String, Object> paramIns = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParamIns = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = issStnVO.getColumnValues();

			paramIns.putAll(mapVO);
			velParamIns.putAll(mapVO);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVOCSQL(), paramIns, velParamIns);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INV_AR_STUP_OFC 테이블에 update 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvArStupOfcVO issStnVO
	 * @exception DAOException
	 */
	public void modifySetupOffice(InvArStupOfcVO issStnVO) throws DAOException, Exception {
		int insCnt = 0;
		// query parameter
		Map<String, Object> paramIns = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParamIns = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = issStnVO.getColumnValues();

			paramIns.putAll(mapVO);
			velParamIns.putAll(mapVO);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVOUSQL(), paramIns, velParamIns);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INV_REV_ACCT_CD 테이블 전체를 삭제한다. <br>
	 * 
	 * @exception DAOException
	 */
	public void removeRevenueAccountList() throws DAOException,Exception {
		int insCnt = 0;
		//query parameter
		Map<String, Object> paramIns = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParamIns = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOremoveRevenueAccountListDSQL(), paramIns, velParamIns);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * INV_REV_ACCT_CD 테이블을 생성한다. <br>
	 * 
	 * @param List<InvRevAcctCdVO> invRevAcctCdVOs
	 * @exception DAOException
	 */
    public void addRevenueAccountList(List<InvRevAcctCdVO> invRevAcctCdVOs) throws DAOException, Exception {
    	try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invRevAcctCdVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOaddRevenueAccountListCSQL(), invRevAcctCdVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * FNS_INV_0107<br>
	 * Office 정보 조회<br>
	 * 
	 * @param MdmOfcInPutVO mdmOfcInPutVO
	 * @return List<MdmOrganizationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmOrganizationVO> searchMDMOfficeList(MdmOfcInPutVO mdmOfcInPutVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmOfcInPutVO != null){
				Map<String, String> mapVO = mdmOfcInPutVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOMDMOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * FNS_INV_0108<br>
	 * INVOICE Printer Set up정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofc
	 * @param String userId
	 * @return List<PrinterbyUserIdVO>
	 * @exception DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PrinterbyUserIdVO> searchINVPrinterbyUserId(String ofc, String userId) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PrinterbyUserIdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofc);
			param.put("usr_id", userId);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOINVPrinterbyUserIdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrinterbyUserIdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * FNS_INV_0108<br>
	 * INVOICE Printer Set up정보를 수정한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofc
	 * @param String userId
	 * @param String printerNm
	 * @return int
	 * @exception DAOException, Exception
	 */
	public int modifyINVPrinterName(String ofc, String userId, String printerNm) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("ar_ofc_cd", ofc);
			param.put("usr_id", userId);
			param.put("inv_prn_dvc_nm", printerNm);
			param.put("upd_usr_id", userId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOINVPrinterNameUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			
			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0108<br>
	 * INVOICE Printer Set up정보를 입력한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofc
	 * @param String userId
	 * @param String printerNm
	 * @exception DAOException, Exception
	 */
	public void addINVPrinterName(String ofc, String userId, String printerNm) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("ar_ofc_cd", ofc);
			param.put("usr_id", userId);
			param.put("inv_prn_dvc_nm", printerNm);
			param.put("cre_usr_id", userId);
			param.put("upd_usr_id", userId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOINVPrinterNameCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * arOfcCd에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @return List<String>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<String> searchAROfficeList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List list = new ArrayList();
		
		String arOfcCd = "";
		String arOfcCdLogin = "";
		String deltFlg = "";

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOSearchAROfficeListRSQL(), param, velParam);
			
			while (dbRowset.next()) { 
				arOfcCd = dbRowset.getString("ar_ofc_cd");
				arOfcCdLogin = dbRowset.getString("ar_ofc_cd_login");
				deltFlg = dbRowset.getString("delt_flg");
				
				list.add(arOfcCd+"^"+arOfcCdLogin+"^"+deltFlg);
				
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	 
	
	/**
	 * FNS_INV_0114<br>
	 * Glovis EDI Code Conversion 정보를 조회한다..<br>
	 * 
	 * @author 이석준
	 * @param InvEdiIntgCdVO invEdiIntgCdVO
	 * @return List<InvEdiIntgCdDtlVO>
	 * @exception DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<InvEdiIntgCdDtlVO> searchEDIMappingCodeList(InvEdiIntgCdVO invEdiIntgCdVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<InvEdiIntgCdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(invEdiIntgCdVO != null){
				Map<String, String> mapVO = invEdiIntgCdVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOsearchEDIMappingCodeListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvEdiIntgCdDtlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	 

	/**
	 * INV_EDI_INTG_CD_DTL 테이블에 insert 한다.<br>
	 * 
	 * @author 이석준
	 * @param List<InvEdiIntgCdDtlVO> invEdiIntgCdDtlVs
	 * @exception DAOException
	 */
	public void addInvEdiIntgCdDtl(List<InvEdiIntgCdDtlVO> invEdiIntgCdDtlVs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invEdiIntgCdDtlVs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvEdiIntgCdDtlCSQL(), invEdiIntgCdDtlVs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * INV_EDI_INTG_CD_DTL 테이블에 update 한다.<br>
	 * 
	 * @author 이석준
	 * @param List<InvEdiIntgCdDtlVO> invEdiIntgCdDtlVs
	 * @exception DAOException
	 */
	public void modifyInvEdiIntgCdDtl(List<InvEdiIntgCdDtlVO> invEdiIntgCdDtlVs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (invEdiIntgCdDtlVs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvEdiIntgCdDtlUSQL(), invEdiIntgCdDtlVs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	/**
	 * INV_EDI_INTG_CD_DTL 테이블에 delete 한다.<br>
	 * 
	 * @author 이석준
	 * @param List<InvEdiIntgCdDtlVO> invEdiIntgCdDtlVs
	 * @exception DAOException
	 */
	public void removeInvEdiIntgCdDtl(List<InvEdiIntgCdDtlVO> invEdiIntgCdDtlVs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invEdiIntgCdDtlVs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvEdiIntgCdDtlDSQL(), invEdiIntgCdDtlVs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * FNS_INV_0121<br>
	 * Revenue VVD 정보를 조회한다.<br>
	 * 
	 * @author 김태균
	 * @param RevenueProcessParamVO paramVO
	 * @return List<RevenueVvdListVO>
	 * @exception DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RevenueVvdListVO> searchRevenueVvdList(RevenueProcessParamVO paramVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<RevenueVvdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOSearchRevenueVvdListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueVvdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * FNS_INV_0121<br>
	 * Processing VVD 정보를 조회한다.<br>
	 * 
	 * @author 김태균
	 * @param RevenueProcessParamVO paramVO
	 * @return List<ProcessingVvdListVO>
	 * @exception DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessingVvdListVO> searchProcessingVvdList(RevenueProcessParamVO paramVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<ProcessingVvdListVO> list = null;
		StringTokenizer st = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String bcDivCd = (String)paramVO.getSEstmBcDivCd();
                List<String> bcDivCdList = new ArrayList<String>();
                st = new StringTokenizer(bcDivCd, ",");
                while (st.hasMoreTokens()) {
                	bcDivCdList.add(st.nextToken());
                }
                velParam.put("s_estm_bc_div_cd_list", bcDivCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOSearchProcessingVvdListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcessingVvdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	
	
	/**
	 * FNS_INV_0133<br>
	 * Processing VVD 정보를 조회한다.<br>
	 * 
	 * @author 9011620
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PHILSLocationListVO> searchEdiPHILSLocationList() throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<PHILSLocationListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOsearchEdiPHILSLocationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSLocationListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Philips Location Code 를  등록한다. <br>
	 * 
	 * @author 9011620
	 * @param philsLocationListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addEdiPHILSLocationList(List<PHILSLocationListVO> philsLocationListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (philsLocationListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOaddEdiPHILSLocationListCSQL(), philsLocationListVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Philips Location Code 를  수정한다. <br>
	 * 
	 * @author 9011620
	 * @param philsLocationListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyEdiPHILSLocationList(List<PHILSLocationListVO> philsLocationListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (philsLocationListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOmodifyEdiPHILSLocationListUSQL(), philsLocationListVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Philips Location Code 를  삭제한다. <br>
	 * 
	 * @author 9011620
	 * @param philsLocationListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeEdiPHILSLocationList(List<PHILSLocationListVO> philsLocationListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (philsLocationListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOremoveEdiPHILSLocationListDSQL(), philsLocationListVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * FNS_INV_0134<br>
	 * Surcharge Description 을 조회한다.<br>
	 * 
	 * @author 김준호
	 * @param String arHdQtrOfcCd
	 * @param String arOfcCd
	 * @param String chgCd
	 * @return List<InvChgDescConvVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvChgDescConvVO> searchSurchargeDescriptionList(String arHdQtrOfcCd, String arOfcCd, String chgCd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<InvChgDescConvVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			if("ALL".equals(arHdQtrOfcCd)){
				arHdQtrOfcCd = "";
			}
			if("ALL".equals(arOfcCd)){
				arOfcCd = "";
			}
			if("ALL".equals(chgCd)){
				chgCd = "";
			}
					
			mapVO.put("ar_hd_qtr_ofc_cd", arHdQtrOfcCd);
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("chg_cd", chgCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralARInvoiceMasterDataMgtDBDAOsearchSurchargeDescriptionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvChgDescConvVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Surcharge Description 를  등록한다. <br>
	 * 
	 * @author 김준호
	 * @param invChgDescConvVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSurchargeDescriptionList(List<InvChgDescConvVO> invChgDescConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (invChgDescConvVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOaddSurchargeDescriptionListCSQL(), invChgDescConvVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Surcharge Description 를  수정한다. <br>
	 * 
	 * @author 김준호
	 * @param invChgDescConvVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySurchargeDescriptionList(List<InvChgDescConvVO> invChgDescConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (invChgDescConvVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOmodifySurchargeDescriptionListUSQL(), invChgDescConvVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Surcharge Description 를  삭제한다. <br>
	 * 
	 * @author 김준호
	 * @param invChgDescConvVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeSurchargeDescriptionList(List<InvChgDescConvVO> invChgDescConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (invChgDescConvVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOremoveSurchargeDescriptionListDSQL(), invChgDescConvVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * LOCAL Charge 에 등록된 Charge 인지 확인한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String chgCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalChargeExists(String ofcCd, String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String arOfcCd = "";

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("chg_cd", chgCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOSearchLocalChargeExistsRSQL(), param, velParam);
			if (dbRowset.next()) {
				arOfcCd = dbRowset.getString("ar_ofc_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arOfcCd;
	}

}
