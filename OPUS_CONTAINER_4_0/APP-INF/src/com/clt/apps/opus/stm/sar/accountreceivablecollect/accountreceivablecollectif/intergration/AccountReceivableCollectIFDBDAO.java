/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableCollectIFDBDAO.java
 *@FileTitle : AccountReceivableCollectIFDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.vo.SaKuraIFVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * AccountReceivableCollectIFDBDAO <br>
 * - AccountReceivableCollectIFDBDAO system Business Logic.<br>
 * 
 * @author
 * @see AccountReceivableCollectIFBCImpl
 * @since J2EE 1.4
 */
public class AccountReceivableCollectIFDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	private String dataSource = "";

	/**
	 * AccountReceivableReceiptDBDAO object creation<br>
	 * AccountReceivableReceiptDBDAO creation<br>
	 */
	public AccountReceivableCollectIFDBDAO() {
	}

	/**
	 * AccountReceivableReceiptDBDAO object creation<br>
	 * AccountReceivableReceiptDBDAO creation<br>
	 * 
	 * @param String dataSource
	 */
	public AccountReceivableCollectIFDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * search for create sakura if data
	 * 
	 * @author myoungsin park 2014. 9. 29
	 * @param String arOffstNo
	 * @param String Status
	 * @param String grpYn
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraOffsetList(String arOffstNo, String Status, String grpYn) throws DAOException {

		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ar_offst_no", arOffstNo);
			velParam.put("ar_offst_no", arOffstNo);
			param.put("check_status", Status);
			velParam.put("check_status", Status);
			param.put("grp_yn", grpYn);
			velParam.put("grp_yn", grpYn);
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCollectIFDBDAOsearchIFSakuraOffsetListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SaKuraIFVO.class);
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
	 * search for create sakura if data
	 * 
	 * @author myoungsin park 2014. 11. 07
	 * @param String adjNo
	 * @param String Status
	 * @param String grpYn
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraAdjustList(String adjNo, String Status, String grpYn) throws DAOException {

		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("adj_no", adjNo);
			velParam.put("adj_no", adjNo);
			param.put("check_status", Status);
			velParam.put("check_status", Status);
			param.put("grp_yn", grpYn);
			velParam.put("grp_yn", grpYn);
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCollectIFDBDAOsearchIFSakuraAdjustListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SaKuraIFVO.class);
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
	 * search for create sakura if data
	 * 
	 * @author myoungsin park 2014. 11. 07
	 * @param String rctNo
	 * @param String Status
	 * @param String grpYn
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraReceiptList(String rctNo, String Status, String grpYn) throws DAOException {

		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("rct_no", rctNo);
			velParam.put("rct_no", rctNo);
			param.put("check_status", Status);
			velParam.put("check_status", Status);
			param.put("grp_yn", grpYn);
			velParam.put("grp_yn", grpYn);
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCollectIFDBDAOsearchIFSakuraReceiptListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SaKuraIFVO.class);
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
	 * search for create sakura if data
	 * 
	 * @author myoungsin park 2014. 11. 07
	 * @param String asaNo
	 * @param String Status
	 * @param String grpYn
	 * @return List<SaKuraIFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SaKuraIFVO> searchIFSakuraASAList(String asaNo, String Status, String grpYn) throws DAOException {

		DBRowSet dbRowset = null;
		List<SaKuraIFVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("asa_no", asaNo);
			velParam.put("asa_no", asaNo);
			param.put("check_status", Status);
			velParam.put("check_status", Status);
			param.put("grp_yn", grpYn);
			velParam.put("grp_yn", grpYn);
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCollectIFDBDAOsearchIFSakuraASAListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SaKuraIFVO.class);
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
	 * insert sakura interface data
	 * 
	 * @author myoungsin park 2014. 9. 29
	 * @param List<SaKuraIFVO> sarIFVOs
	 * @exception DAOException
	 */
	public void addSarIFData(List<SaKuraIFVO> sarIFVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (sarIFVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableCollectIFDBDAOAddSarIFDataCSQL(), sarIFVOs, null);
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
	 * modify ost_dtrb status
	 * 
	 * @author myoungsin park 2014. 9. 29
	 * @param List<SaKuraIFVO> sarIFVOs
	 * @exception DAOException
	 */
	public void modifyDtrbStatus(List<SaKuraIFVO> sarIFVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (sarIFVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableCollectIFDBDAOmodifyDtrbStatusUSQL(), sarIFVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyCltDtrbStatus No" + i + " SQL");
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
	 * Search InterfaceSeq<br>
	 * 
	 * @author MyoungSin Park
	 * @return String
	 * @throws DAOException
	 */
	public String searchSakuraIFSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String arEmlSeq = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCollectIFDBDAOsearchSakuraIFSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				arEmlSeq = dbRowset.getString("ar_if_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arEmlSeq;
	}

	/**
	 * Search InterfaceSeq<br>
	 * 
	 * @author MyoungSin Park
	 * @return String
	 * @throws DAOException
	 */
	public String searchSakuraArIFToSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String ifSeqNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCollectIFDBDAOsearchSakuraArIFToSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				ifSeqNo = dbRowset.getString("if_seq_no");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ifSeqNo;
	}

	/**
	 * Update Holding Status<br>
	 * 
	 * @author MyoungSin Park
	 * @param String ifSeqNo
	 * @throws DAOException
	 */
	public void modifyHoldingStatus(String ifSeqNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("if_seq_no", ifSeqNo);
			velParam.put("if_seq_no", ifSeqNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableCollectIFDBDAOmodifyHoldingStatusUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Update Holding Status<br>
	 * 
	 * @author MyoungSin Park
	 * @param String ifSeqNo
	 * @throws DAOException
	 */
	public void modifyReCheckHoldingStatus(String ifSeqNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("if_seq_no", ifSeqNo);
			velParam.put("if_seq_no", ifSeqNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableCollectIFDBDAOmodifyReCheckHoldingStatusUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Update Error Flag, Reason, IF Flag<br>
	 * 
	 * @author KIMOKRYE
	 * @param List<SaKuraIFVO> sarIFVOs
	 * @throws DAOException
	 */
	public void modifySakuraIFErrRsn(List<SaKuraIFVO> sarIFVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (sarIFVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableCollectIFDBDAOModifySakuraIFErrRsnUSQL(), sarIFVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyCltDtrbStatus No" + i + " SQL");
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
}