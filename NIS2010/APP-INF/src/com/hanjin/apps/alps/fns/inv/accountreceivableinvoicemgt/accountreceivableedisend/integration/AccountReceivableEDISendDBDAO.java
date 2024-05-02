/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableEDISendDBDAO.java
 *@FileTitle : (China) Pantos Inquiry/Re-send
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.10 최도순 [CHM-201005801] AR Inovice module내 EDI Submission기능 추가 개발(2차)
 * 2010.11.25 이석준 [CHM-201006884] Glovis EDI 전송관련 조회 신규 개발
 * 2010.12.22 최도순 [CHM-201006644] 최도순 NIKE, Invoice EDI 신규 개발 요청
 * 2011.03.03 최도순 [CHM-201109000][ALPS INV] NIKE EDI기능 수정 요청
 * 2012.04.27 김상현 [CHM-201216976] DHL EDI 개발 요청
 * 2012.05.21 김상현 [CHM-201216580] Honey Well EDI 작업
 * 2012.06.20 김상현 [CHM-201218417] 삼성전자 EDI TIME OUT 방지 logic 보완 요청
 * 2012.07.11 김상현 [CHM-201218835] (Korea) Samsung Invoice EDI > Invoice No. Numbering 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic.AccountReceivableEDISendBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiCurrTotalVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiCustInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiSeqNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiTotalVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiUserVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiCurrTotalVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiSeqNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiTotalVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiUserVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisEdiMsgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLEdiChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLEdiCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLEdiMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLEdiBkgCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPEDISendVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInvoiceEDIChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInvoiceEDIHeaderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInvoiceEDIVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEdiNikeChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEdiNikeHdrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiBkgBlDocVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiBkgCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiBkgCustTpVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiVvdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiBkgVvdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDIBLChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendBLVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIBLVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIHeaderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungMSGVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.InvEdiGlovisChgVO;
import com.hanjin.syscommon.common.table.InvEdiGlovisHdrVO;
 
/**
 * ALPS AccountReceivableEDISendDBDAO <br>
 * - ALPS-AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see AccountReceivableEDISendBCImpl 참조
 * @since J2EE 1.4
 */
public class AccountReceivableEDISendDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;

	/** 
	 * VVD와 Customer로 기 생성된 EDI 문서번호(message no) list를 조회한다.<br>
	 * 
	 * @param SamsungInPutVO samInPutVo
	 * @return List<SamsungMSGVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SamsungMSGVO> searchSamsungEDIMSGNoList(SamsungInPutVO samInPutVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamsungMSGVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (samInPutVo != null) {
				Map<String, String> mapVO = samInPutVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamsungEDIMSGNoListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamsungMSGVO.class);
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
	 * 조회조건 VVD 및 Customer에 해당하는 SHAAS(AR_HD_QTR_OFC_CD) 인 EDI 전송가능한 대상 main 정보를 조회한다.<br>
	 * INV_AR_MN 및 MDM_CUSTOMER 테이블에서 조회조건으로 조회함.<br>
	 * 
	 * @param SamsungInPutVO samInPutVo
	 * @return SamsungInvoiceEDIHeaderVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SamsungInvoiceEDIHeaderVO searchSamsungARInvoiceMain(SamsungInPutVO samInPutVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamsungInvoiceEDIHeaderVO> list = null;
		SamsungInvoiceEDIHeaderVO samsungInvoiceEDIHeaderVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (samInPutVo != null) {
				Map<String, String> mapVO = samInPutVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamsungARInvoiceMainRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamsungInvoiceEDIHeaderVO.class);

			if (list != null && list.size() > 0) {
				samsungInvoiceEDIHeaderVO = (SamsungInvoiceEDIHeaderVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return samsungInvoiceEDIHeaderVO;
	}

	/**
	 * EDI 전송가능한 대상 list를 조회한다.<br>
	 * AR Invoice main/ charge , BKG Rate테이블에서 조회조건으로 조회함.<br>
	 * 
	 * @param SamsungInPutVO samInPutVo
	 * @return List<SamsungEDIBLChargeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SamsungEDIBLChargeVO> searchSamsungARInvoiceList(SamsungInPutVO samInPutVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamsungEDIBLChargeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (samInPutVo != null) {
				Map<String, String> mapVO = samInPutVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamsungARInvoiceListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamsungEDIBLChargeVO.class);
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
	 * 조회조건 VVD 및 Customer에 해당하는 SHAAS(AR_HD_QTR_OFC_CD) 인 EDI 전송가능한 대상 main 정보를 조회한다.<br>
	 * INV_AR_MN 및 MDM_CUSTOMER 테이블에서 조회조건으로 조회함.<br>
	 * 
	 * @param String msgId
	 * @param String msgNo
	 * @return SamsungInvoiceEDIHeaderVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SamsungInvoiceEDIHeaderVO searchSamsungAREDIMain(String msgId, String msgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamsungInvoiceEDIHeaderVO> list = null;
		SamsungInvoiceEDIHeaderVO samsungInvoiceEDIHeaderVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (msgId != null && msgNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("msg_id", msgId);
				mapVO.put("msg_no", msgNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamsungAREDIMainRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamsungInvoiceEDIHeaderVO.class);

			if (list != null && list.size() > 0) {
				samsungInvoiceEDIHeaderVO = (SamsungInvoiceEDIHeaderVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return samsungInvoiceEDIHeaderVO;
	}

	/**
	 * message no로 삼성전자의 EDI 전송할 Account Receivable 정보를 조회한다.<br>
	 * 
	 * @param String msgId
	 * @param String msgNo
	 * @return List<SamsungEDIBLChargeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SamsungEDIBLChargeVO> searchSamsungAREDIList(String msgId, String msgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamsungEDIBLChargeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (msgId != null && msgNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("msg_id", msgId);
				mapVO.put("msg_no", msgNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamsungAREDIListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamsungEDIBLChargeVO.class);
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
	 * 새로운 문서번호를 구함. <br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchSamSungNextMsgNo() throws DAOException {
		DBRowSet dbRowset = null;
		String msgNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamSungNextMsgNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				msgNo = dbRowset.getString("msg_no");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return msgNo;
	}

	/**
	 * GERP HEADER 테이블에 insert.<br>
	 * 
	 * @param SamsungInvoiceEDIHeaderVO samheadVo
	 * @exception DAOException
	 */
	public void addSamsungEDIHeader(SamsungInvoiceEDIHeaderVO samheadVo) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = samheadVo.getColumnValues();
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOAddSamsungEDIHeaderCSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * GERP BL 테이블에 insert.<br>
	 * 
	 * @author JungJin Park
	 * @param List<SamsungInvoiceEDIBLVO> samBLVos
	 * @exception DAOException,Exception
	 */
	public void addSamsungEDIBL(List<SamsungInvoiceEDIBLVO> samBLVos) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if (samBLVos.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AccountReceivableEDISendDBDAOAddSamsungEDIBLCSQL(), samBLVos, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED) {
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
	 * GERP CHARGE 테이블에 insert.<br>
	 * 
	 * @author JungJin Park
	 * @param List<SamsungInvoiceEDIChargeVO> samChgVos
	 * @exception DAOException,Exception
	 */
	public void addSamsungEDIChg(List<SamsungInvoiceEDIChargeVO> samChgVos) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if (samChgVos.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AccountReceivableEDISendDBDAOAddSamsungEDIChgCSQL(), samChgVos, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED) {
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
	 * 해당 문서번호의 내용에 Delete Flag='Y'를 update 한다.<br>
	 * GERP HEADER 테이블에 update.<br>
	 * 
	 * @param String msgId
	 * @param String msgNo
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifySamsungDeleteFlag(String msgId, String msgNo, String userId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (msgId != null && msgNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("msg_id", msgId);
				mapVO.put("msg_no", msgNo);
				mapVO.put("upd_usr_id", userId);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOModifySamsungDeleteFlagUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flate file작성시 사용할 실제 전송할 데이터 조회<br>
	 * 
	 * @param SamsungEDISendVO sendSamVO
	 * @return SamsungEDISendBLVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SamsungEDISendBLVO searchSamsungSendBL(SamsungEDISendVO sendSamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamsungEDISendBLVO> list = null;
		SamsungEDISendBLVO samsungEDISendBLVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sendSamVO != null) {
				Map<String, String> mapVO = sendSamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchSamsungSendBLRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamsungEDISendBLVO.class);

			if (list != null && list.size() > 0) {
				samsungEDISendBLVO = (SamsungEDISendBLVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return samsungEDISendBLVO;
	}

	/**
	 * Flate file작성시 사용할 실제 전송할 데이터 charge 조회<br>
	 * 
	 * @param SamsungEDISendVO sendSamVO
	 * @return List<SamsungEDISendChargeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SamsungEDISendChargeVO> searchSamsungSendChgByBL(SamsungEDISendVO sendSamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamsungEDISendChargeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sendSamVO != null) {
				Map<String, String> mapVO = sendSamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamsungSendChgByBLRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamsungEDISendChargeVO.class);
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
	 * 해당 문서번호의 내용에 send Flag='Y'를 update한다.<br>
	 * GERP HEADER 테이블에 update.<br>
	 * 
	 * @param String msgId
	 * @param String msgNo
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifySamSungHeader(String msgId, String msgNo, String userId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (msgId != null && msgNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("msg_id", msgId);
				mapVO.put("msg_no", msgNo);
				mapVO.put("upd_usr_id", userId);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOModifySamSungHeaderUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 해당 문서번호 및 전송 BL의 내용에 send Flag='Y' 및 OBRD_DT를 update한다.<br>
	 * GERP BL 테이블에 update.<br>
	 * 
	 * @param SamsungEDISendVO sendSamVO
	 * @exception DAOException
	 */
	public void modifySamsungBL(SamsungEDISendVO sendSamVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (sendSamVO != null) {
				SamsungEDISendBLVO sendBlNo = sendSamVO.getSamsungEDISendBL();
				
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("msg_id", sendSamVO.getMsgId());
				mapVO.put("msg_no", sendSamVO.getMsgNo());
				mapVO.put("bl_src_no", sendSamVO.getBlSrcNo());
				mapVO.put("upd_usr_id", sendSamVO.getUpdUsrId());
				mapVO.put("obrd_dt", sendBlNo.getActualDate());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOModifySamsungBLUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * EDI 전송가능한 대상을 입력된 BL NO로 조회한다.<br>
	 * 삼성전자의 EDI 전송할 Account Receivable 정보에 추가로 입력할 내용으로 입력된 BL NO에 대한 정보를 조회한다.<br>
	 * 
	 * @param SamsungInPutVO samInPutVo
	 * @param String blNo
	 * @return SamsungEDIBLChargeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SamsungEDIBLChargeVO searchSamsungEDIByBL(SamsungInPutVO samInPutVo, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamsungEDIBLChargeVO> list = null;
		SamsungEDIBLChargeVO samsungEDIBLChargeVO = new SamsungEDIBLChargeVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (samInPutVo != null) {
				Map<String, String> mapVO = samInPutVo.getColumnValues();
				mapVO.put("bl_src_no", blNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamsungEDIByBLRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamsungEDIBLChargeVO.class);
			if (list != null && list.size() > 0) {
				samsungEDIBLChargeVO = (SamsungEDIBLChargeVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return samsungEDIBLChargeVO;
	}
	
	/**
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param HPInputVO hpInputVO
	 * @return List<HPInvoiceEDIVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HPInvoiceEDIVO> searchHPInvoiceEDIList( HPInputVO hpInputVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<HPInvoiceEDIVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hpInputVO != null) {
				Map<String, String> mapVO = hpInputVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchHPInvoiceEDIListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HPInvoiceEDIVO.class);
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
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param HPInvoiceEDIVO hpInvoiceEDIVO
	 * @return HPInvoiceEDIVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public HPEDISendVO searchHPEDIMakefile( HPInvoiceEDIVO hpInvoiceEDIVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<HPEDISendVO> list = null;
		HPEDISendVO hpEDISendVO = new HPEDISendVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hpInvoiceEDIVO != null) {
				Map<String, String> mapVO = hpInvoiceEDIVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchHPEDIMakefileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HPEDISendVO.class);
			
			if (list != null && list.size() > 0) {
				hpEDISendVO = (HPEDISendVO) list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return hpEDISendVO;
	}
	
	/**
	 * bkgNo, maxArIfNo 로 EDI 전송대상(Customer)을 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String maxIfNo
	 * @return  List<HPEDISendVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HPEDISendVO> searchHPEDIMakefileCustomer( String bkgNo, String maxIfNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<HPEDISendVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("max_if_no", maxIfNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchHPEDIMakefileCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HPEDISendVO.class);
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
	 * bkgNo로 EDI 전송대상(Location)을 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return  List<HPEDISendVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HPEDISendVO> searchHPEDIMakefileLocation( String bkgNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<HPEDISendVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchHPEDIMakefileLocationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HPEDISendVO.class);
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
	 * bkgNo로 EDI 전송대상(Container Info)을 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return  List<HPEDISendVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HPEDISendVO> searchHPEDIMakefileCntrInfo( String bkgNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<HPEDISendVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchHPEDIMakefileCntrInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HPEDISendVO.class);
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
	 * InvNo로 EDI 전송대상(Charge)을 조회한다.<br>
	 * 
	 * @param String invNo
	 * @return  List<HPEDISendVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HPEDISendVO> searchHPEDIMakefileCharge( String invNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<HPEDISendVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_no", invNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchHPEDIMakefileChargeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HPEDISendVO.class);
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
	 * bkgNo로 EDI 전송대상(Container Info)을 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return  List<HPEDISendVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HPEDISendVO> searchHPEDIMakefileBkgVvd ( String bkgNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<HPEDISendVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchHPEDIMakefileBkgVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HPEDISendVO.class);
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
	 * INV_HP_EDI_HDR 테이블에 insert.<br>
	 * 
	 * @param HPInvoiceEDIHeaderVO hpInvoiceEDIHeaderVO
	 * @return String
	 * @exception DAOException
	 */
	public String addHPEDIHeader(HPInvoiceEDIHeaderVO hpInvoiceEDIHeaderVO) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> paramMap = hpInvoiceEDIHeaderVO.getColumnValues();
		
		DBRowSet dbRowset = null;
		String maxInvSeq = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new AccountReceivableEDISendDBDAOSearchHPInvoiceEDIMaxInvSeqRSQL(), paramMap, velParam);
			if(dbRowset.next()) {						
				maxInvSeq = dbRowset.getString("max_inv_seq");
	    	}	
			
			paramMap.put("inv_seq", maxInvSeq);
			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOAddHPEDIHeaderCSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return maxInvSeq;
	}
	
	/**
	 * INV_HP_EDI_CHG 테이블에 insert.<br>
	 * 
	 * @param HPInvoiceEDIChargeVO hpInvoiceEDIChargeVO
	 * @exception DAOException
	 */
	public void addHPEDIChg(HPInvoiceEDIChargeVO hpInvoiceEDIChargeVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = hpInvoiceEDIChargeVO.getColumnValues();
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOAddHPEDIChgCSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 문서번호의 내용에 send Flag='Y'를 update한다.<br>
	 * GERP HEADER 테이블에 update.<br>
	 * 
	 * @param String hpInvTpCd
	 * @param String hpInvNo
	 * @param String invSeq 
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyHPEDIHeader(String hpInvTpCd, String hpInvNo, String invSeq, String userId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("hp_inv_tp_cd", hpInvTpCd);
			mapVO.put("hp_inv_no", hpInvNo);
			mapVO.put("inv_seq", invSeq);
			mapVO.put("upd_usr_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOModifyHPEDIHeaderUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * VVD와 Customer로 기 생성된 EDI 문서번호(message no) list를 조회한다.<br>
	 * 
	 * @param GlovisInputVO glovisInputVO
	 * @return List<CustomGlovisEDISearchVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GlovisInvoiceEdiVO> searchEdiGlovisList(GlovisInputVO glovisInputVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		List<GlovisInvoiceEdiVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (glovisInputVO != null) {
				Map<String, String> mapVO = glovisInputVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiGlovisListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GlovisInvoiceEdiVO.class)	;		
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
	 * Glovis 전송시 보낼 EDI message를 만들기 위해서 header table에 데이터를 저장한다.
	 * 
	 * @param InvEdiGlovisHdrVO invEdiGlovisHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addInvEdiGlovisHdr (InvEdiGlovisHdrVO invEdiGlovisHdrVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = invEdiGlovisHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			cnt = sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrCSQL(), param, velParam);
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
	 * Glovis 전송시 보낼 EDI message를 만들기 위해서 header table에 데이터를 저장한다.
	 * 
	 * @param InvEdiGlovisHdrVO invEdiGlovisHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addInvEdiGlovisHdrByArIfNo(InvEdiGlovisHdrVO invEdiGlovisHdrVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = invEdiGlovisHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			cnt = sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOaddInvGlovisHdrByArIfNoCSQL(), param, velParam);
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
	 * Glovis 전송시 보낼 EDI message를 만들기 위해서 header table에 데이터를 저장한다.
	 * 
	 * @param InvEdiGlovisHdrVO invEdiGlovisHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addInvEdiGlovisHdrByBlSrcNo (InvEdiGlovisHdrVO invEdiGlovisHdrVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = invEdiGlovisHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			cnt = sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrByBlSrcNoCSQL(), param, velParam);
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
	 * Glovis 전송시 보낼 EDI message를 만들기 위해서 charge table에 데이터를 저장한다.
	 * 
	 * @param InvEdiGlovisChgVO invEdiGlovisChgVO
	 * @param String ind 
	 * @param String eurGubun 
	 * @exception DAOException
	 */
	public void addInvEdiGlovisChg (InvEdiGlovisChgVO invEdiGlovisChgVO,String ind, String eurGubun) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = invEdiGlovisChgVO.getColumnValues();
			mapVO.put("ind",ind);			
			mapVO.put("eur_gubun",eurGubun);			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOaddInvEdiGlovisChgCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
    /**
	 * Glovis 전송 대상 조회
	 * 
	 * @param GlovisInvoiceEdiVO glovisInvoiceEdiVO
	 * @param String ind
	 * @return InvEdiGlovisHdrVO
	 * @exception DAOException
	 */
	public InvEdiGlovisHdrVO searchEdiGlovisIfSeq (GlovisInvoiceEdiVO glovisInvoiceEdiVO,String ind) throws DAOException {
		DBRowSet dbRowset = null;
		InvEdiGlovisHdrVO invEdiGlovisHdrVO = new InvEdiGlovisHdrVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (glovisInvoiceEdiVO != null) {
				
				Map<String, String> mapVO = glovisInvoiceEdiVO.getColumnValues();
				mapVO.put("ind", ind);				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiGlovisIfSeqRSQL(), param, velParam);

			while (dbRowset.next()) {			
				invEdiGlovisHdrVO.setArIfNo(dbRowset.getString("AR_IF_NO"));
				invEdiGlovisHdrVO.setIfSeq(dbRowset.getString("IF_SEQ"));
				invEdiGlovisHdrVO.setCxlFlg(dbRowset.getString("CXL_FLG"));
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invEdiGlovisHdrVO;
	}
	
    /**
	 * Glovis 전송시 보낼 Interface 채번 
	 * 
	 * @param GlovisInvoiceEdiVO glovisInvoiceEdiVO
	 * @return List<GlovisEdiMsgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GlovisEdiMsgVO> searchEdiGlovisMsg(GlovisInvoiceEdiVO glovisInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GlovisEdiMsgVO> list = new ArrayList<GlovisEdiMsgVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (glovisInvoiceEdiVO != null) {
				Map<String, String> mapVO = glovisInvoiceEdiVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiGlovisMsgRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GlovisEdiMsgVO.class);
			
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
	 * Glovis EDI 전송 현황 Update
	 * 
	 * @param InvEdiGlovisHdrVO invEdiGlovisHdrVO
	 * @exception DAOException
	 */
	public void modifyInvEdiGlovisHdr (InvEdiGlovisHdrVO invEdiGlovisHdrVO ) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = invEdiGlovisHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOmodifyInvEdiGlovisHdrUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
    /**
	 * Glovis 전송시 청구 승인이 난 B/L인지 확인하는 Query
	 * 
	 * @param String blSrcNo
	 * @return List<InvEdiGlovisHdrVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvEdiGlovisHdrVO> searchEdiGlovisLastSendData(String blSrcNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvEdiGlovisHdrVO> list = new ArrayList<InvEdiGlovisHdrVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (blSrcNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bl_src_no", blSrcNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiGlovisLastSendDataRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvEdiGlovisHdrVO.class);			
			
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
	 * Glovis 전송시 보낼 EDI message를 만들기 위해서 청구 상태일때 header table에 데이터를 저장한다.
	 * 
	 * @param InvEdiGlovisHdrVO invEdiGlovisHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addInvEdiGlovisHdrForApproval(InvEdiGlovisHdrVO invEdiGlovisHdrVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = invEdiGlovisHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			cnt = sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrForApprovalCSQL(), param, velParam);
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
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param NikeInputVO nikeInputVO
	 * @return List<NikeInvoiceEdiVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NikeInvoiceEdiVO> searchEdiNikeList( NikeInputVO nikeInputVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<NikeInvoiceEdiVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (nikeInputVO != null) {
				Map<String, String> mapVO = nikeInputVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiNikeChargeMappingRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, NikeInvoiceEdiVO.class);
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
	 * INV_EDI_NIKE_HDR 테이블에 insert.<br>
	 * 
	 * @param InvEdiNikeHdrVO invEdiNikeHdrVO
	 * @exception DAOException
	 */
	public void addInvEdiNikeHdr(InvEdiNikeHdrVO invEdiNikeHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = invEdiNikeHdrVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOAddInvEdiNikeHdrCSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * INV_EDI_NIKE_CHG 테이블에 insert.<br>
	 * 
	 * @param InvEdiNikeChgVO invEdiNikeChgVO
	 * @exception DAOException
	 */
	public void addInvEdiNikeChg(InvEdiNikeChgVO invEdiNikeChgVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = invEdiNikeChgVO.getColumnValues();
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOAddInvEdiNikeChgCSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param NikeInvoiceEdiVO nikeInvoiceEdiVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiNikeMakefile( NikeInvoiceEdiVO nikeInvoiceEdiVO ) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (nikeInvoiceEdiVO != null) {
				Map<String, String> mapVO = nikeInvoiceEdiVO.getColumnValues();

				param.putAll(mapVO); 
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiNikeMakefileRSQL(), param, velParam);
			while (dbRowset.next()) {			
				flatFile = dbRowset.getString("RSLT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}
	
	/**
	 * 해당 문서번호의 내용에 send Flag='Y'를 update한다.<br>
	 * GERP HEADER 테이블에 update.<br>
	 * 
	 * @param String invNo
	 * @param String invSeq 
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvEdiNikeHeader(String invNo, String invSeq, String userId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_no", invNo);
			mapVO.put("inv_seq", invSeq);
			mapVO.put("upd_usr_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOModifyInvEdiNikeHeaderUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Glovis 전송시 보낼 EDI message를 청구 승인 상태일때 만들기 위해서 charge table에 데이터를 저장한다.
	 * 
	 * @param GlovisInvoiceEdiVO glovisInvoiceEdiVO
	 * @exception DAOException
	 */
	public void addInvEdiGlovisChgForApproval(GlovisInvoiceEdiVO glovisInvoiceEdiVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = glovisInvoiceEdiVO.getColumnValues();	
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOaddInvEdiGlovisChgForApprovalCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * INV_EDI_NIKE_HDR 테이블에 delete.<br>
	 * 
	 * @param InvEdiNikeHdrVO invEdiNikeHdrVO
	 * @exception DAOException
	 */
	public void removeInvEdiNikeHdr(InvEdiNikeHdrVO invEdiNikeHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = invEdiNikeHdrVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAORemoveInvEdiNikeHdrDSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * INV_EDI_NIKE_CHG 테이블에 delete.<br>
	 * 
	 * @param InvEdiNikeHdrVO invEdiNikeHdrVO
	 * @exception DAOException
	 */
	public void removeInvEdiNikeChg(InvEdiNikeHdrVO invEdiNikeHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = invEdiNikeHdrVO.getColumnValues();
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAORemoveInvEdiNikeChgDSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Retrieve DHL EDI list.
	 * 
	 * @param inputVO
	 * @return List<DHLInvoiceEdiVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DHLInvoiceEdiVO> searchEdiDHLList(DHLInputVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DHLInvoiceEdiVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inputVO != null) {
				Map<String, String> mapVO = inputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiDHLListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DHLInvoiceEdiVO.class);
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
	 * Add DHL EDI.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @throws DAOException
	 */
	public void addEdiDHL(DHLInvoiceEdiVO dhlInvoiceEdiVO) throws DAOException {
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExecuter = new SQLExecuter("");
			Map<String, String> mapVO = dhlInvoiceEdiVO.getColumnValues();
			
			mapVO.put("inv_edi_knd_cd", "D");
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			sqlExecuter.executeUpdate((ISQLTemplate)new AccountReceivableEDISendDBDAOAddEdiDHLCSQL(), param, velParam);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
	}

	/**
	 * Searching EDI sequence number.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @return DHLEdiSeqNoVO
	 * @throws DAOException
	 */
	public DHLEdiSeqNoVO searchEdiDHLSeqNo(DHLInvoiceEdiVO dhlInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		DHLEdiSeqNoVO dhlSendEdiVO = new DHLEdiSeqNoVO();

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dhlInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchDHLEdiSeqNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				dhlSendEdiVO.setRefNo(dbRowset.getString("REF_NO"));
				dhlSendEdiVO.setCreationDate(dbRowset.getString("CREATION_DATE"));
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return dhlSendEdiVO;
	}

	/**
	 * Get data for flat file.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @return DHLEdiMainVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DHLEdiMainVO searchEdiDHLMain(DHLInvoiceEdiVO dhlInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		DHLEdiMainVO dhlEdiMainVO = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dhlInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiDHLMainRSQL(), param, velParam);
			List<DHLEdiMainVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, DHLEdiMainVO.class);
			dhlEdiMainVO = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return dhlEdiMainVO;
	}

	/**
	 * Get data for flat file.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @return DHLEdiTotalVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DHLEdiTotalVO searchEdiDHLTotal(DHLInvoiceEdiVO dhlInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		DHLEdiTotalVO dhlEdiTotalVO = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dhlInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiDHLTotalRSQL(), param, velParam);
			List<DHLEdiTotalVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, DHLEdiTotalVO.class);
			dhlEdiTotalVO = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return dhlEdiTotalVO;
	}

	/**
	 * Get data for flat file.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @return List<DHLEdiCurrTotalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DHLEdiCurrTotalVO> searchEdiDHLCurrTotal(DHLInvoiceEdiVO dhlInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DHLEdiCurrTotalVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dhlInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiDHLCurrTotalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DHLEdiCurrTotalVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}

	/**
	 * Get data for flat file.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @return List<DHLEdiChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DHLEdiChgVO> searchDHLEdiChg(DHLInvoiceEdiVO dhlInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DHLEdiChgVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dhlInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiDHLChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DHLEdiChgVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}

	/**
	 * Get data for flat file.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @return List<DHLEdiCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DHLEdiCntrVO> searchDHLEdiCntr(DHLInvoiceEdiVO dhlInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DHLEdiCntrVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dhlInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiDHLCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DHLEdiCntrVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}

	/**
	 * Get data for flat file.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @return DHLEdiUserVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DHLEdiUserVO searchDHLEdiUser(DHLInvoiceEdiVO dhlInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		DHLEdiUserVO dhlEdiUserVO = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dhlInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiDHLUserRSQL(), param, velParam);
			List<DHLEdiUserVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, DHLEdiUserVO.class);
			dhlEdiUserVO = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return dhlEdiUserVO;
	}

	/**
	 * Retrieve Honey Well EDI list.
	 * 
	 * @param inputVo
	 * @return List<HNWLInvoiceEdiVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HNWLInvoiceEdiVO> searchEdiHNWLList(DHLInputVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<HNWLInvoiceEdiVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = inputVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HNWLInvoiceEdiVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}

	/**
	 * Add Honey Well EDI.
	 * 
	 * @param invoiceEdiVO
	 * @throws DAOException
	 */
	public void addEdiHNWL(HNWLInvoiceEdiVO invoiceEdiVO) throws DAOException {
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExecuter = new SQLExecuter("");
			Map<String, String> mapVO = invoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			sqlExecuter.executeUpdate((ISQLTemplate)new AccountReceivableEDISendDBDAOAddEdiHNWLCSQL(), param, velParam);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
	}

	/**
	 * Port location 정보를 조회.
	 * 
	 * @param locCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiHNWLLocation(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		String locNm = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLLocationRSQL(), param, velParam);
			if (dbRowset.next()) {
				locNm = dbRowset.getString("LOC_NM");
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return locNm;
	}

	/**
	 * RD Type 정보를 조회.
	 * 
	 * @param invoiceEdiVo
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiHNWLRDType(HNWLInvoiceEdiVO invoiceEdiVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rdType = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLRDTypeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rdType = dbRowset.getString("BL_RDTYPE");
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return rdType;
	}

	/**
	 * Charge 정보 조회.
	 * 
	 * @param invoiceEdiVo
	 * @param actCustCntCd
	 * @param actCustSeq
	 * @return List<HNWLEdiChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HNWLEdiChgVO> searchEdiHNWLChgList(HNWLInvoiceEdiVO invoiceEdiVo, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<HNWLEdiChgVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("act_cust_cnt_cd", actCustCntCd);
			param.put("act_cust_seq", actCustSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLChgListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HNWLEdiChgVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}

	/**
	 * Charge 합계를 조회.
	 * 
	 * @param invoiceEdiVo
	 * @param actCustCntCd
	 * @param actCustSeq
	 * @return List<HNWLEdiChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HNWLEdiChgVO> searchEdiHNWLChgTotal(HNWLInvoiceEdiVO invoiceEdiVo, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<HNWLEdiChgVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("act_cust_cnt_cd", actCustCntCd);
			param.put("act_cust_seq", actCustSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLChgTotalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HNWLEdiChgVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}

	/**
	 * Container 정보를 조회.
	 * 
	 * @param invoiceEdiVo
	 * @param actCustCntCd
	 * @param actCustSeq
	 * @return List<HNWLEdiCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HNWLEdiCntrVO> searchEdiHNWLCntrList(HNWLInvoiceEdiVO invoiceEdiVo, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<HNWLEdiCntrVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("act_cust_cnt_cd", actCustCntCd);
			param.put("act_cust_seq", actCustSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HNWLEdiCntrVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}

	/**
	 * Honey Well 메인 정보를 조회.
	 * 
	 * @param invoiceEdiVo
	 * @param actCustCntCd
	 * @param actCustSeq
	 * @return HNWLEdiMainVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HNWLEdiMainVO searchEdiHNWLMain(HNWLInvoiceEdiVO invoiceEdiVo, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		HNWLEdiMainVO mainVo = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("act_cust_cnt_cd", actCustCntCd);
			param.put("act_cust_seq", actCustSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLMainRSQL(), param, velParam);
			List<HNWLEdiMainVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, HNWLEdiMainVO.class);
			mainVo = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return mainVo;
	}

	/**
	 * Honey Well EDI 전송 정보 조회.
	 * 
	 * @param invoiceEdiVo
	 * @return HNWLInvoiceEdiVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HNWLInvoiceEdiVO searchEdiHNWLInfo(HNWLInvoiceEdiVO invoiceEdiVo) throws DAOException {
		DBRowSet dbRowset = null;
		HNWLInvoiceEdiVO ediVo = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLInfoRSQL(), param, velParam);
			List<HNWLInvoiceEdiVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, HNWLInvoiceEdiVO.class);
			ediVo = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return ediVo;
	}

	/**
	 * 중복되는 SR_INV_NO가 있는지 체크하기 위한 조회.
	 * 
	 * @param samsungEdiBlChargeVo
	 * @return int
	 * @throws DAOException
	 */
	public int searchSamsungInvNoDuplicate(SamsungEDIBLChargeVO samsungEdiBlChargeVo) throws DAOException {
		DBRowSet dbRowset = null;
		int rowCount = 0;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = samsungEdiBlChargeVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchSamsungInvNoDuplicateRSQL(), param, velParam);
			if (dbRowset.next()) {
				rowCount = dbRowset.getInt("ROW_COUNT");
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return rowCount;
	}
	
	
	
	/**
	 * Retrieve PHILIPS EDI list.
	 * 
	 * @param inputVo
	 * @return List<PHILSInvoiceEdiVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PHILSInvoiceEdiVO> searchEdiPHILSList(DHLInputVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PHILSInvoiceEdiVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = inputVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiPHILSListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSInvoiceEdiVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}
	
	/**
	 * Add PHILIPS EDI.
	 * 
	 * @param philsInvoiceEdiVO
	 * @throws DAOException
	 */
	public void addEdiPHILS(PHILSInvoiceEdiVO philsInvoiceEdiVO) throws DAOException {
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExecuter = new SQLExecuter("");
			Map<String, String> mapVO = philsInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			sqlExecuter.executeUpdate((ISQLTemplate)new AccountReceivableEDISendDBDAOAddEdiPHILIPSCSQL(), param, velParam);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
	}
	
	/**
	 * RD Type 정보를 조회.
	 * 
	 * @param bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiPHILSRDType(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rdType = null;
		
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			param.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiHNWLRDTypeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rdType = dbRowset.getString("BL_RDTYPE");
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		
		return rdType;
	}
	
	
	/**
	 * PHILIPS 메인 정보를 조회.
	 * 
	 * @param invoiceEdiVo
	 * @param actCustCntCd
	 * @param actCustSeq
	 * @return PHILSInvoiceEdiVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PHILSInvoiceEdiVO searchEdiPHILSMain(PHILSInvoiceEdiVO invoiceEdiVo, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		PHILSInvoiceEdiVO mainVo = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("act_cust_cnt_cd", actCustCntCd);
			param.put("act_cust_seq", actCustSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSMainRSQL(), param, velParam);
			List<PHILSInvoiceEdiVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSInvoiceEdiVO.class);
			mainVo = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return mainVo;
	}

	/**
	 * PHILIPS EDI 전송 정보 조회.
	 * 
	 * @param invoiceEdiVo
	 * @return PHILSInvoiceEdiVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PHILSInvoiceEdiVO searchEdiPHILSInfo(PHILSInvoiceEdiVO invoiceEdiVo) throws DAOException {
		DBRowSet dbRowset = null;
		PHILSInvoiceEdiVO ediVo = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSInfoRSQL(), param, velParam);
			List<PHILSInvoiceEdiVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSInvoiceEdiVO.class);
			ediVo = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return ediVo;
	}
	
	
	/**
	 * PHILIPS EDI VVD 전송 정보 조회.
	 * 
	 * @param invoiceEdiVo
	 * @return PHILSEdiVvdVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PHILSEdiVvdVO searchEdiPHILSVvd(PHILSInvoiceEdiVO invoiceEdiVo) throws DAOException {
		DBRowSet dbRowset = null;
		PHILSEdiVvdVO ediVo = null;
		
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSVvdRSQL(), param, velParam);
			List<PHILSEdiVvdVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSEdiVvdVO.class);
			ediVo = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		
		return ediVo;
	}
	
	
	
	
	/**
	 * Searching EDI sequence number.
	 * 
	 * @param ofdCd
	 * @return PHILSInvoiceEdiVO
	 * @throws DAOException
	 */
	public PHILSInvoiceEdiVO searchEdiPHILSSeqNo(String ofdCd) throws DAOException {
		DBRowSet dbRowset = null;
		PHILSInvoiceEdiVO philsSendEdiVO = new PHILSInvoiceEdiVO();

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofdCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchDHLEdiSeqNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				philsSendEdiVO.setRefNo(dbRowset.getString("REF_NO"));
				philsSendEdiVO.setCreationDate(dbRowset.getString("CREATION_DATE"));
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return philsSendEdiVO;
	}
	
	
	/**
	 * Searching PHILIHS EDI BKGDoc.
	 * 
	 * @param bkgNo
	 * @return PHILSEdiBkgBlDocVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PHILSEdiBkgBlDocVO searchEdiPHILSBkgBlDoc(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		PHILSEdiBkgBlDocVO docVo = new PHILSEdiBkgBlDocVO();
		
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", bkgNo);
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiPHILSBkgBlDocRSQL(), param, velParam);
		
			List<PHILSEdiBkgBlDocVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSEdiBkgBlDocVO.class);
			docVo = list.get(0);
			
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		
		return docVo;
	}
	
	/**
	 * Searching PHILIHS EDI Customer.
	 * 
	 * @param bkgNo
	 * @return PHILSEdiBkgCustVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PHILSEdiBkgCustVO searchEdiPHILSBkgCust(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		PHILSEdiBkgCustVO docVo = new PHILSEdiBkgCustVO();
		
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", bkgNo);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiPHILSBkgCustomerRSQL(), param, velParam);
	
			List<PHILSEdiBkgCustVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSEdiBkgCustVO.class);
			docVo = list.get(0);	
			
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		
		return docVo;
	}
	
	
	
	
	
	/**
	 * Charge 정보 조회.
	 * 
	 * @param invoiceEdiVo
	 * @param actCustCntCd
	 * @param actCustSeq
	 * @return List<PHILSEdiChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PHILSEdiChgVO> searchEdiPHILSChgList(PHILSInvoiceEdiVO invoiceEdiVo, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PHILSEdiChgVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("act_cust_cnt_cd", actCustCntCd);
			param.put("act_cust_seq", actCustSeq);


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSChgListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSEdiChgVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}
	
	
	
	
	

	/**
	 * Charge 합계를 조회.
	 * 
	 * @param invoiceEdiVo
	 * @param actCustCntCd
	 * @param actCustSeq
	 * @return List<PHILSEdiChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PHILSEdiChgVO> searchEdiPHILSChgTotal(PHILSInvoiceEdiVO invoiceEdiVo, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PHILSEdiChgVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("act_cust_cnt_cd", actCustCntCd);
			param.put("act_cust_seq", actCustSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSChgTotalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSEdiChgVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}




	/**
	 * Container 정보를 조회.
	 * 
	 * @param invoiceEdiVo
	 * @param actCustCntCd
	 * @param actCustSeq
	 * @return List<PHILSEdiCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PHILSEdiCntrVO> searchEdiPHILSCntrList(PHILSInvoiceEdiVO invoiceEdiVo, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PHILSEdiCntrVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invoiceEdiVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("act_cust_cnt_cd", actCustCntCd);
			param.put("act_cust_seq", actCustSeq);


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSEdiCntrVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}
	
	
	/**
	 * Searching HoneyWell EDI Customer.
	 * 
	 * @param bkgNo
	 * @return HNWLEdiBkgCustVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HNWLEdiBkgCustVO searchEdiHNWLBkgCust(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		HNWLEdiBkgCustVO docVo = new HNWLEdiBkgCustVO();
		
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", bkgNo);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiHNWLBkgCustomerRSQL(), param, velParam);
	
			List<HNWLEdiBkgCustVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, HNWLEdiBkgCustVO.class);
			docVo = list.get(0);	
			
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		
		return docVo;
	}
	
	
	/**
	 * BKG VVD 정보를 조회.
	 * 
	 * @param bkgNo
	 * @return List<PHILSEdiBkgVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PHILSEdiBkgVvdVO> searchEdiPHILSBkgVvdList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PHILSEdiBkgVvdVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSBkgVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSEdiBkgVvdVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}

	/**
	 * BL Description 정보를 조회.
	 * 
	 * @param bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiPHILSBlDesc(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String blDesc = null;
		
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			param.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSBlDescRSQL(), param, velParam);
			if (dbRowset.next()) {
				blDesc = dbRowset.getString("BL_DESC");
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		
		return blDesc;
	}
	
	/**
	 * Philips EDI BKG Cust 정보를 조회.
	 * 
	 * @param bkgNo
	 * @param invCustCntCd
	 * @param invCustSeq
	 * @return List<PHILSEdiBkgCustTpVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PHILSEdiBkgCustTpVO> searchEdiPHILSBkgCustTp(String bkgNo, String invCustCntCd, String invCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PHILSEdiBkgCustTpVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("inv_cust_cnt_cd", invCustCntCd);
			param.put("inv_cust_seq", invCustSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiPHILSBkgCustTpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PHILSEdiBkgCustTpVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}
	
	
	/**
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param MGBInputVO mgbInputVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchEdiMGBofficeYN( MGBInputVO mgbInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mgbInputVO != null) {
				Map<String, String> mapVO = mgbInputVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiMGBofficeYNRSQL(), param, velParam);
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
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param MGBInputVO mgbInputVO
	 * @return List<MGBInvoiceEdiVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MGBInvoiceEdiVO> searchEdiMGBList( MGBInputVO mgbInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGBInvoiceEdiVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mgbInputVO != null) {
				Map<String, String> mapVO = mgbInputVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiMGBListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGBInvoiceEdiVO.class);
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
	 * ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param MGBInvoiceEdiVO mgbInvoiceEdiVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiMGBMakefile( MGBInvoiceEdiVO mgbInvoiceEdiVO ) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mgbInvoiceEdiVO != null) {
				Map<String, String> mapVO = mgbInvoiceEdiVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiMGBMakefileRSQL(), param, velParam);
			while (dbRowset.next()) {			
				flatFile = dbRowset.getString("RSLT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatFile;
	}
	
	
	/**
	 * Retrieve ADIDAS EDI list.
	 * 
	 * @param ADIDASInputVO adidasInputVO
	 * @return List<ADIDASInvoiceEdiVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ADIDASInvoiceEdiVO> searchEdiADIDASList(ADIDASInputVO adidasInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ADIDASInvoiceEdiVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (adidasInputVO != null) {
				Map<String, String> mapVO = adidasInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiADIDASListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ADIDASInvoiceEdiVO.class);
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
	 * Searching EDI sequence number.
	 * 
	 * @param adidasInvoiceEdiVO
	 * @return ADIDASEdiSeqNoVO
	 * @throws DAOException
	 */
	public ADIDASEdiSeqNoVO searchEdiADIDASSeqNo(ADIDASInvoiceEdiVO adidasInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
 		ADIDASEdiSeqNoVO adidasSendEdiVO = new ADIDASEdiSeqNoVO();
		
 
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchADIDASEdiSeqNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				adidasSendEdiVO.setRefNo(dbRowset.getString("REF_NO"));
				adidasSendEdiVO.setCreationDate(dbRowset.getString("CREATION_DATE"));
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return adidasSendEdiVO;
	}
	
	
	/**
	 * Get data for flat file.
	 * 
	 * @param ADIDASInvoiceEdiVO adidasInvoiceEdiVO
	 * @return ADIDASEdiMainVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ADIDASEdiMainVO searchEdiADIDASMain(ADIDASInvoiceEdiVO adidasInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		ADIDASEdiMainVO adidasEdiMainVO = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiADIDASMainRSQL(), param, velParam);
			List<ADIDASEdiMainVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ADIDASEdiMainVO.class);
			adidasEdiMainVO = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return adidasEdiMainVO;
	}
	
	
	/**
	 * Get data for flat file.
	 * 
	 * @param adidasInvoiceEdiVO
	 * @return ADIDASEdiTotalVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ADIDASEdiTotalVO searchEdiADIDASTotal(ADIDASInvoiceEdiVO adidasInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		ADIDASEdiTotalVO adidasEdiTotalVO = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiADIDASTotalRSQL(), param, velParam);
			List<ADIDASEdiTotalVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ADIDASEdiTotalVO.class);
			adidasEdiTotalVO = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return adidasEdiTotalVO;
	}
	
	
	/**
	 * Get data for flat file.
	 * 
	 * @param adidasInvoiceEdiVO
	 * @return List<ADIDASEdiCurrTotalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ADIDASEdiCurrTotalVO> searchEdiADIDASCurrTotal(ADIDASInvoiceEdiVO adidasInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ADIDASEdiCurrTotalVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiADIDASCurrTotalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ADIDASEdiCurrTotalVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}
	
	/**
	 * Get data for flat file.
	 * 
	 * @param adidasInvoiceEdiVO
	 * @return ADIDASEdiUserVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ADIDASEdiUserVO searchADIDASEdiUser(ADIDASInvoiceEdiVO  adidasInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		ADIDASEdiUserVO adidasEdiUserVO = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEdiADIDASUserRSQL(), param, velParam);
			List<ADIDASEdiUserVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ADIDASEdiUserVO.class);
			adidasEdiUserVO = list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return adidasEdiUserVO;
	}

	
	/**
	 * Get data for flat file.
	 * 
	 * @param adidasInvoiceEdiVO
	 * @return List<ADIDASEdiCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ADIDASEdiCntrVO> searchADIDASEdiCntr(ADIDASInvoiceEdiVO  adidasInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ADIDASEdiCntrVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchADIDASEdiCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ADIDASEdiCntrVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}
	
	/**
	 * Get data for flat file.
	 * 
	 * @param adidasInvoiceEdiVO
	 * @return List<ADIDASEdiChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ADIDASEdiChgVO> searchADIDASEdiChg(ADIDASInvoiceEdiVO  adidasInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ADIDASEdiChgVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchADIDASEdiChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ADIDASEdiChgVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}
	
	/**
	 * Add ADIDAS EDI.
	 * 
	 * @param dhlInvoiceEdiVO
	 * @throws DAOException
	 */
	public void addEdiADIDAS(ADIDASInvoiceEdiVO  adidasInvoiceEdiVO) throws DAOException {
		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExecuter = new SQLExecuter("");
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
		
			mapVO.put("inv_edi_knd_cd", "A");

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			sqlExecuter.executeUpdate((ISQLTemplate)new AccountReceivableEDISendDBDAOAddEdiDHLCSQL(), param, velParam);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
	}
 
	/**
	 * Get data for flat file.
	 * 
	 * @param adidasInvoiceEdiVO
	 * @return List<ADIDASEdiCustInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ADIDASEdiCustInfoVO> searchEdiADIDASCustInfo(ADIDASInvoiceEdiVO adidasInvoiceEdiVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ADIDASEdiCustInfoVO> list = null;

		// query parameter.
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adidasInvoiceEdiVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchEdiADIDASCustInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ADIDASEdiCustInfoVO.class);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}

		return list;
	}
}
