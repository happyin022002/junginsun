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
 =========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic.GeneralARInvoiceMasterDataMgtBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCprtCdConvVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PrinterbyUserIdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.InvRevAcctCdVO;

/**
 * GeneralARInvoiceMasterDataMgtDBDAO <br>
 * - AccountReceivableInvoiceMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see GeneralARInvoiceMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GeneralARInvoiceMasterDataMgtDBDAO extends DBDAOSupport {
 
	

	
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
	 * INV_REV_ACCT_CD 테이블에 insert 한다.<br>
	 * 
	 * @param List<InvRevAcctCdVO> invRevAcctCdVOs
	 * @exception DAOException
	 */
	public void addRevenueAccount(List<InvRevAcctCdVO> invRevAcctCdVOs) throws DAOException, Exception {
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
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * INV_REV_ACCT_CD 테이블에 update 한다.<br>
	 * 
	 * @param List<InvRevAcctCdVO> invRevAcctCdVOs
	 * @exception DAOException
	 */
	public void modifyRevenueAccount(List<InvRevAcctCdVO> invRevAcctCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (invRevAcctCdVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOModifyRevenueAccountUSQL(), invRevAcctCdVOs, null);
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
	 * INV_REV_ACCT_CD 테이블에 delete 한다.<br>
	 * 
	 * @param List<InvRevAcctCdVO> invRevAcctCdVOs
	 * @exception DAOException
	 */
	public void removeRevenueAccount(List<InvRevAcctCdVO> invRevAcctCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invRevAcctCdVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOremoveRevenueAccountListDSQL(), invRevAcctCdVOs, null);
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
  	 * INV_CPRT_CD_CONV에서 S/C NO나 RFA NO (화면에서 입력하지 않은 Number는 임의로 'X'로 넘겨 준다. )와 code 유형을 조건으로 데이터를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @param String rfaNO
	 * @param String codeTy
	 * @return List<InvCprtCdConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvCprtCdConvVO> searchCodeConversionList(String scNo, String rfaNO, String codeTy) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<InvCprtCdConvVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sc_no", scNo);
			mapVO.put("rfa_no", rfaNO);
			mapVO.put("cprt_conv_tp_cd", codeTy);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvCprtCdConvVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvCprtCdConvVO.class);
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
	 * INV_CPRT_CD_CONV 에 S/C NO나 RFA NO별로( (화면에서 입력하지 않은 Number는 임의로 'X'로 넘겨 준다. ) Conversion code유형에 따라 생성한다..<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCprtCdConvVO> invCprtCdConvVOs
	 * @exception DAOException
	 */
	public void addCodeConversion(List<InvCprtCdConvVO> invCprtCdConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invCprtCdConvVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvCprtCdConvVoCSQL(), invCprtCdConvVOs, null);
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
	 * INV_CPRT_CD_CONV의 데이터를 update 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCprtCdConvVO> invCprtCdConvVOs
	 * @exception DAOException
	 */
	public void modifyCodeConversion(List<InvCprtCdConvVO> invCprtCdConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (invCprtCdConvVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvCprtCdConvVOUSQL(), invCprtCdConvVOs, null);
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
	 * INV_CPRT_CD_CONV의 데이터를 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCprtCdConvVO> invCprtCdConvVOs
	 * @exception DAOException
	 */
	public void removeCodeConversion(List<InvCprtCdConvVO> invCprtCdConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invCprtCdConvVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOInvCprtCdConVODSQL(), invCprtCdConvVOs, null);
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
	 * S/C NO로 PRI의 PRI_SP_HDR에서 .PROP_No를 구하고 PRI_SP_CTRT_PTY에서 PROP_No에대한 Customer를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSCCustomerName(String scNo) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchScNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sc_no", scNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOsearchSCCustomerNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchScNo = dbRowset.getString("cust_lgl_eng_nm");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchScNo;
	}

	/**
	 * RFA NO로 PRI의 PRI_RP_HDR에서 .PROP_No를 구하고 PRI_RP_MN에서 Customer를 구하여 이름을 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String rfaNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchRFACustomerName(String rfaNo) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchRfaNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rfa_no", rfaNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOsearchRFACustomerNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchRfaNo = dbRowset.getString("cust_lgl_eng_nm");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchRfaNo;
	}
	
	/**
	 * MDM_LOCATION의 LOC_CD와 Code 비교 하기위해 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocationCode(String cd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cd", cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOsearchLocationRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchCd = dbRowset.getString("cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCd;
	}

	/**
	 * MDM_CHARGE 의 CHG_CD와 Code 비교하기위해 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchChgCode(String cd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cd", cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOsearchChgCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchCd = dbRowset.getString("cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCd;
	}

	/**
	 * MDM_CNTR_TP_SZ의 CNTR_TPSZ_CD와 Code 비교하기위해 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cd
	 * @return String
	 * @exception EDAOException
	 */
	public String searchCNTRCode(String cd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cd", cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOsearchCNTRCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchCd = dbRowset.getString("cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCd;
	}

	/**
	 * MDM_COMMODITY 의 CMDT_CD와 Code 비교하기위해 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCmdtCode(String cd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cd", cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralARInvoiceMasterDataMgtDBDAOsearchCmdtCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchCd = dbRowset.getString("cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCd;
	}

}
