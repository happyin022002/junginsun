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
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;
 
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAOSearchBkgBlNoVORSQL;

import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.FlatFileAckVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.SendFlatFileVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.BkgBlNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic.AccountReceivableEDISendBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.APCInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.BLIssueInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ContainerInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.CustomerInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.INVContainerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEDIChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEDICntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEDIHdrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.LocationInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PorDelDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.VesselInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DblEdiCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DblEdiInVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SealInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.CmdtInfoVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;
 
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
	 * Search EDI 310 Invoice<br>
	 * 
	 * @param EDI310InputVO edi310InputVO
	 * @return List<EDI310InvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EDI310InvoiceVO> searchEDI310Invoice( EDI310InputVO edi310InputVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<EDI310InvoiceVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (edi310InputVO != null) {
				
				//SC/RFA No Multi Entry
				String scRfaNo = edi310InputVO.getScRfaNo();
				
				StringTokenizer st = new StringTokenizer(scRfaNo, ",");
				String uScRfaNo = "";
				String strScRfaNo = "";
				while (st.hasMoreTokens()) {
					uScRfaNo = st.nextToken();
					if (uScRfaNo.equals("")) {
						strScRfaNo = "";
					}else{
						strScRfaNo = strScRfaNo+"'," + "'"+uScRfaNo;
					}
				
				}
				if(!strScRfaNo.equals("")){
					strScRfaNo = strScRfaNo + "";
				}
				
				//Customer Multi Entry
				String custCd = edi310InputVO.getCustCd();
				
				StringTokenizer st2 = new StringTokenizer(custCd, ",");
				String uCustCd = "";
				String strCustCd = "";
				while (st2.hasMoreTokens()) {
					uCustCd = st2.nextToken();
					if (uCustCd.equals("")) {
						strCustCd = "";
					}else{
						strCustCd = strCustCd+"'," + "'"+uCustCd.substring(0, 2) + Integer.parseInt(uCustCd.substring(2));
					}
				
				}
				if(!strCustCd.equals("")){
					strCustCd = strCustCd + "";
				}
				
				//Charge Multi Entry
				String chgCd = edi310InputVO.getChgCd();
				
				StringTokenizer st3 = new StringTokenizer(chgCd, ",");
				String uChgCd = "";
				String strChgCd = "";
				while (st3.hasMoreTokens()) {
					uChgCd = st3.nextToken();
					if (uChgCd.equals("")) {
						strChgCd = "";
					}else{
						strChgCd = strChgCd+"'," + "'"+uChgCd;
					}
				
				}
				if(!strChgCd.equals("")){
					strChgCd = strChgCd + "";
				}
				
				Map<String, String> mapVO = edi310InputVO.getColumnValues();

				mapVO.put("sc_rfa_no", strScRfaNo);	
				mapVO.put("cust_cd", strCustCd);
				mapVO.put("chg_cd", strChgCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEDI310InvoiceRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EDI310InvoiceVO.class);
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
	 * Search Invoice EDI Level<br>
	 * 
	 * @param String cntcTpCd
	 * @param String scRfaNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchInvoiceEDILevel( String cntcTpCd, String scRfaNo ) throws DAOException {
		DBRowSet dbRowset = null;
		String invEDILvlCd = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntc_tp_cd", cntcTpCd);
			mapVO.put("sc_rfa_no", scRfaNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchInvoiceEDILevelRSQL(), param, velParam);
			if(dbRowset.next()) {
				invEDILvlCd = dbRowset.getString("inv_edi_lvl_cd");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invEDILvlCd;
	}
	
	/**
	 * Search EDI Header Sequence<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchEDIHeaderSequence() throws DAOException {
		DBRowSet dbRowset = null;
		String ediHdrSeq = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchEDIHeaderSequenceRSQL(), param, velParam);
			if(dbRowset.next()) {
				ediHdrSeq = dbRowset.getString("edi_hdr_seq");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ediHdrSeq;
	}
	
	/**
	 * Insert into INV_EDI_HDR<br>
	 * 
	 * @param InvEDIHdrVO invEDIHdrVO
	 * @exception DAOException
	 */
	public void addInvoiceEDIHeader(InvEDIHdrVO invEDIHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = invEDIHdrVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOAddInvoiceEDIHeaderCSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Insert into INV_EDI_CHG<br>
	 * 
	 * @param InvEDIChgVO invEDIChgVO
	 * @exception DAOException
	 */
	public void addInvoiceEDICharge(InvEDIChgVO invEDIChgVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = invEDIChgVO.getColumnValues();
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOAddInvoiceEDIChargeCSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Insert into INV_EDI_CNTR<br>
	 * 
	 * @param InvEDICntrVO invEDICntrVO
	 * @exception DAOException
	 */
	public void addInvoiceEDIContainer(InvEDICntrVO invEDICntrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = invEDICntrVO.getColumnValues();
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOAddInvoiceEDIContainerCSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Update INV_EDI_HDR<br>
	 * 
	 * @param String ediHdrSeq
	 * @param String ediSndFlg
	 * @param String updUsrId
	 * @param String ediHdrSeqList
	 * @exception DAOException
	 */
	public void modifyInvoiceEDISendFlag(String ediHdrSeq, String ediSndFlg, String updUsrId, String ediHdrSeqList) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("edi_hdr_seq", ediHdrSeq);
			mapVO.put("edi_snd_flg", ediSndFlg);
			mapVO.put("upd_usr_id", updUsrId);
			mapVO.put("edi_hdr_seq_list", ediHdrSeqList);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOModifyInvoiceEDISendFlagUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Update INV_AR_MN<br>
	 * 
	 * @param String arIfNo
	 * @param String updUsrId
	 * @exception DAOException
	 */
	public void modifyInvoiceMainEDISendDate(String arIfNo, String updUsrId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("upd_usr_id", updUsrId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableEDISendDBDAOModifyInvoiceMainEDISendDateUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search Office Name<br>
	 * 
	 * @param String arOfcCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOfficeName( String arOfcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		String ofcNm = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchOfficeNameRSQL(), param, velParam);
			if(dbRowset.next()) {
				ofcNm = dbRowset.getString("ofc_eng_nm");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ofcNm;
	}
	
	/**
	 * Search Location Info<br>
	 * 
	 * @param String locCd
	 * @return LocationInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public LocationInfoVO searchLocationInfo( String locCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationInfoVO> list = null;
		LocationInfoVO locationInfoVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchLocationInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LocationInfoVO.class);
			
			if (list != null && list.size() > 0) {
				locationInfoVO = (LocationInfoVO) list.get(0);
			} 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return locationInfoVO;
	}
	
	/**
	 * Search POR DEL Date<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String actCd
	 * @return PorDelDateVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PorDelDateVO searchPorDelDate( String bkgNo, String cntrNo, String actCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<PorDelDateVO> list = null;
		PorDelDateVO porDelDateVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("act_cd", actCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchPorDelDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PorDelDateVO.class);
			
			if (list != null && list.size() > 0) {
				porDelDateVO = (PorDelDateVO) list.get(0);
			} 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return porDelDateVO;
	}
	
	/**
	 * Search POL POD Estimate Date<br>
	 * 
	 * @param String bkgNo
	 * @param String cngIndivCd
	 * @param String portCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPolPodEstimateDate( String bkgNo, String cngIndivCd, String portCd ) throws DAOException {
		DBRowSet dbRowset = null;
		String estmDate = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cng_indiv_cd", cngIndivCd);
			mapVO.put("port_cd", portCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchPolPodEstimateDateRSQL(), param, velParam);
			if(dbRowset.next()) {
				estmDate = dbRowset.getString("estm_dt");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return estmDate;
	}
	
	/**
	 * Search POL POD Actual Date<br>
	 * 
	 * @param String bkgNo
	 * @param String cngIndivCd
	 * @param String portCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPolPodActualDate( String bkgNo, String cngIndivCd, String portCd ) throws DAOException {
		DBRowSet dbRowset = null;
		String actDate = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cng_indiv_cd", cngIndivCd);
			mapVO.put("port_cd", portCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchPolPodActualDateRSQL(), param, velParam);
			if(dbRowset.next()) {
				actDate = dbRowset.getString("act_dt");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actDate;
	}
	
	/**
	 * Search Container Info<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return ContainerInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ContainerInfoVO searchContainerInfo( String bkgNo, String cntrNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<ContainerInfoVO> list = null;
		ContainerInfoVO containerInfoVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchContainerInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ContainerInfoVO.class);
			
			if (list != null && list.size() > 0) {
				containerInfoVO = (ContainerInfoVO) list.get(0);
			} 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return containerInfoVO;
	}
	
	/**
	 * Search POR Haulage Type<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPorHaulageType( String bkgNo ) throws DAOException {
		DBRowSet dbRowset = null;
		String haulTp = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchPorHaulageTypeRSQL(), param, velParam);
			if(dbRowset.next()) {
				haulTp = dbRowset.getString("por_haulage");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return haulTp;
	}
	
	/**
	 * Search POD Haulage Type<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPodHaulageType( String bkgNo ) throws DAOException {
		DBRowSet dbRowset = null;
		String haulTp = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchPodHaulageTypeRSQL(), param, velParam);
			if(dbRowset.next()) {
				haulTp = dbRowset.getString("pod_haulage");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return haulTp;
	}
	
	/**
	 * Search Vessel Info<br>
	 * 
	 * @param String vvd
	 * @param String ioBndCd
	 * @param String polCd
	 * @param String podCd
	 * @return VesselInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VesselInfoVO searchVesselInfo( String vvd, String ioBndCd, String polCd, String podCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselInfoVO> list = null;
		VesselInfoVO vesselInfoVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("io_bnd_cd", ioBndCd);
			mapVO.put("pol_cd", polCd);
			mapVO.put("pod_cd", podCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchVesselInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VesselInfoVO.class);
			
			if (list != null && list.size() > 0) {
				vesselInfoVO = (VesselInfoVO) list.get(0);
			} 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vesselInfoVO;
	}
	
	/**
	 * Search Customer Info<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String bkgNo
	 * @param String ediHdrSeqList
	 * @return List<CustomerInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerInfoVO> searchCustomerInfo( String custCntCd, String custSeq, String bkgNo, String ediHdrSeqList ) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerInfoVO> list = null;
		//CustomerInfoVO customerInfoVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("edi_hdr_seq_list", ediHdrSeqList);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchCustomerInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerInfoVO.class);
			
			//if (list != null && list.size() > 0) {
			//	customerInfoVO = (CustomerInfoVO) list.get(0);
			//} 
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
	 * searchCustomerInfoForInvoic<br>
	 * 
	 * @param String ediHdrSeqList
	 * @return List<CustomerInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerInfoVO> searchCustomerInfoForInvoic( String ediHdrSeqList ) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerInfoVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("edi_hdr_seq_list", ediHdrSeqList);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchCustomerInfoForInvoicRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerInfoVO.class);

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
	 * Search APCInvoice Info<br>
	 * 
	 * @param APCInvoiceVO aPCInvoiceVO
	 * @return List<APCInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<APCInvoiceVO> searchAPCInvoice(APCInvoiceVO aPCInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<APCInvoiceVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = aPCInvoiceVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchAPCInvoiceRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, APCInvoiceVO.class);
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
	 * search INV ContainerList
	 * @author myoungsin park 2015. 01. 08
	 * @param String arIfNo
	 * @return List<INVContainerListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<INVContainerListVO> searchINVContainerList(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<INVContainerListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ar_if_no", arIfNo);
			velParam.put("ar_if_no", arIfNo);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableEDISendDBDAOSearchINVContainerListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,INVContainerListVO.class);
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
	 * Search Charge RefNo<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchChargeRefNo() throws DAOException {
		DBRowSet dbRowset = null;
		String chgRefNo = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchChargeRefNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				chgRefNo = dbRowset.getString("chg_ref_no");
	    	} 
		} catch (SQLException se) { 
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chgRefNo;
	}
	
	/**
	 * Search Container FMInd<br>
	 * 
	 * @param String ioBndCd
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchContainerFMInd(String ioBndCd,String bkgNo,String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String cntrFmInd  = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("io_bnd_cd", ioBndCd);
			velParam.put("io_bnd_cd", ioBndCd);
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchContainerFMIndRSQL(), param, velParam);
			if(dbRowset.next()) {
				cntrFmInd = dbRowset.getString("cntr_fm_ind");
	    	} 
		} catch (SQLException se) {  
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrFmInd; 
	}
	
	
	/**
	 * search BLIssueInfo
	 * @author myoungsin park 2015. 01. 08
	 * @param String arOfcCd
	 * @param String bkgNo
	 * @return BLIssueInfoVO
	 * @throws DAOException
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BLIssueInfoVO searchBLIssueInfo(String arOfcCd,String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BLIssueInfoVO> list = null; 
		BLIssueInfoVO bLIssueInfoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ar_ofc_cd", arOfcCd);  
			velParam.put("ar_ofc_cd", arOfcCd); 
			param.put("bkg_no", bkgNo);  
			velParam.put("bkg_no", bkgNo);  
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableEDISendDBDAOsearchBLIssueInfoRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BLIssueInfoVO.class);
			if(list.size() > 0) { 
				bLIssueInfoVO = list.get(0);
			} 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bLIssueInfoVO;
	}
	
	/**
	 * Search OriginalRefNo<br>
	 * 
	 * @param String chgSeq
	 * @param String arOfcCd
	 * @param String blNo
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOriginalRefNo(String chgSeq,String arOfcCd,String blNo,String arIfNo) throws DAOException {
		DBRowSet dbRowset = null; 
		String cntrFmInd  = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("chg_seq", chgSeq);
			velParam.put("chg_seq", chgSeq);
			param.put("ar_ofc_cd", arOfcCd);  
			velParam.put("ar_ofc_cd", arOfcCd);
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("ar_if_no", arIfNo);
			velParam.put("ar_if_no", arIfNo); 
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOsearchOriginalRefNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				cntrFmInd = dbRowset.getString("chg_ref_no");
	    	} 
		} catch (SQLException se) {  
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntrFmInd; 
	}
	
	/**
	 * Search Office in RHQ List<br>
	 * 
	 * @param String arIfNo
	 * @return List<InvEDICntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvEDICntrVO> searchCntrListByIfNo(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvEDICntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
		    param.putAll(mapVO);
			velParam.putAll(mapVO); 
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableEDISendDBDAOsearchCntrListByIfNoRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvEDICntrVO .class);
		
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
     * search Edi Sndr 1
     * 
     * @author KimYoungchul
     * @param DblEdiInVO dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchEdiSndr1(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchDblEdiSndr1RSQL template = new AccountReceivableEDISendDBDAOSearchDblEdiSndr1RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Edi Sndr 2
     * 
     * @author KimYoungchul
     * @param DblEdiInVO dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchEdiSndr2(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchDblEdiSndr2RSQL template = new AccountReceivableEDISendDBDAOSearchDblEdiSndr2RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    } 
    
	/**
     * searchInvInfo
     * 
     * @param InvEDIHdrVO invEDIHdrVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvInfo(InvEDIHdrVO invEDIHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchInvoiceBlMainRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceBlMainRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = //"INV_NO:\n"
                       //+ "ORG_INV_NO:\n"
                       //+ "INV_DT:\n"
                       "INV_TP:\n"
                       + "INV_STATUS:\n"
                       + "BL_NO:\n"
                       + "INV_STATUS:\n"
                       + "POR_TRAFFIC_MD:\n"
                       + "POD_TRAFFIC_MD:\n"
                       + "PAY_DUE_DT:\n"
                       + "SAILING_ARR_DT:\n"
                       + "INV_CURR:\n"
                       + "INV_CURR_TTL:\n"
                       + "LOCAL_CURR:\n"
                       + "LOCAL_CURR_TTL:\n"
                       + "INV_EX_RATE:\n"
                       + "INV_PAYTERM_CLUS:\n"
                       + "REMARK:\n"
                       + "APP_DT:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvRefInfo
     * 
     * @param InvEDIHdrVO invEDIHdrVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvRefInfo(InvEDIHdrVO invEDIHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchRefNoRSQL template = new AccountReceivableEDISendDBDAOSearchRefNoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{REF_INFO\n"
                       + "REF_TP_CD:\n"
                       + "REF_NO:\n"
                       + "}REF_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    /**
     * search Dbl Edi Container
     * 
     * @author KimYoungchul
     * @param InvEDIHdrVO invEDIHdrVO
     * @return List<DblEdiCntrVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<DblEdiCntrVO> searchInvoiceEdiCntr(InvEDIHdrVO invEDIHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<DblEdiCntrVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblEdiCntrVO.class);

        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * search Dbl Edi Cntr Seal No.
     * 
     * @param InvEDIHdrVO invEDIHdrVO
     * @param String cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceEdiCntrSeal(InvEDIHdrVO invEDIHdrVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrSealRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrSealRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{SEAL_INFO\n"
                       + "SEAL_PT_CD:\n"
                       + "SEAL_NO:\n"
                       + "}SEAL_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi Cntr Seal No.
     * 
     * @param InvEDIHdrVO invEDIHdrVO
     * @param String cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceEdiCntrChgInfo(InvEDIHdrVO invEDIHdrVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrChgInfoRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrChgInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CNTR_CHARGE_INFO\n"
                       + "CHARGE_CD:\n"
                       + "CHARGE_DESC:\n"
                       + "CHARGE_TP_NM:\n"
                       + "CHARGE_CURR:\n"
                       + "CHARGE_AMT:\n"
                       + "CHARGE_AMT_USD:\n"
                       + "INV_CURR:\n"
                       + "INV_CURR_AMT:\n"
                       + "INV_TAX:\n"
                       + "INV_CURR_TTL_AMT:\n"
                       + "LOCAL_CURR:\n"
                       + "LOCAL_CURR_AMT:\n"
                       + "LOCAL_TAX:\n"
                       + "LOCAL_CURR_TTL_AMT:\n"
                       + "FRT_IND:\n"
                       + "RATED_AS:\n"
                       + "RATE:\n"
                       + "INV_EX_RATE:\n"
                       + "TAX_RATE:\n"
                       + "PERTYPE:\n"
                       + "TARIFF:\n"
                       + "}CNTR_CHARGE_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
                
    /**
     * search Dbl Edi Cntr Mf_desc
     * 
     * @author KimYoungchul
     * @param InvEDIHdrVO invEDIHdrVO
     * @param String cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceEdiCntrMf(InvEDIHdrVO invEDIHdrVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrMfRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrMfRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CM_INFO\n"
                        + "CMD_CD:\n"
	                    + "CMD_DESC:\n"
	                    + "{PKG_INFO\n"
	                    + "CM_PKG_LVL:\n"
	                    + "CM_PKG_QTY:\n"
	                    + "CM_PKG_UNIT:\n"
	                    + "CM_PKG_UNIT_DESC:\n"
	                    + "}PKG_INFO\n"
	                    + "{MEA_INFO\n"
	                    + "CM_MEA_TP_CD:\n"	                    
	                    + "CM_MEA_UNIT:\n"
	                    + "CM_MEA_QTY:\n"
	                    + "}MEA_INFO\n"
	                    + "}CM_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }	
    /**
     * searchInvoiceVslInfo
     * 
     * @param InvEDIHdrVO invEDIHdrVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceVslInfo(InvEDIHdrVO invEDIHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchInvoiceEdiVslInfoRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceEdiVslInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{VSL_INFO\n"
                       + "VSL_NM:\n"
                       + "VSL_CD:\n"
                       + "VSL_VOY_NO:\n"
                       + "EX_VOY_REF:\n"
                       + "VSL_LOYD_CD:\n"
                       + "}VSL_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvoiceLocInfo
     * 
     * @param InvEDIHdrVO invEDIHdrVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceLocInfo(InvEDIHdrVO invEDIHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			AccountReceivableEDISendDBDAOSearchInvoiceEdiLocInfoRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceEdiLocInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{LOC_INFO\n"
                       + "LOC_TP_CD:\n"
                       + "LOC_NM:\n"
                       + "LOC_CD:\n"
                       + "CITY:\n"
                       + "STATE:\n"
                       + "ZIP:\n"
                       + "CNT_CD:\n"
                       + "{LOC_DATE_INFO\n"
                       + "DATE_TP_CD:\n"
                       + "DATE:\n"
                       + "}LOC_DATE_INFO\n"
                       + "}LOC_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvoiceCustInfo
     * 
     * @param InvEDIHdrVO invEDIHdrVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceCustInfo(InvEDIHdrVO invEDIHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchInvoiceEdiCustInfoRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceEdiCustInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CUST_INFO\n"
                       + "CUST_TP_CD:\n"
                       + "CUST_NM:\n"
                       + "CUST_TAX_NO:\n"
                       + "CUST_BK_REMIT:\n"
                       + "CUST_ADDR1:\n"
                       + "CUST_ADDR2:\n"
                       + "CUST_ADDR3:\n"
                       + "CUST_ADDR4:\n"
                       + "CUST_ADDR5:\n"
                       + "CUST_CITY:\n"
                       + "CUST_STATE:\n"
                       + "CUST_ZIP:\n"
                       + "CUST_CNT_CD:\n"
                       + "{CONTACT_INFO\n"
                       + "CONTACT_NM:\n"
                       + "CONTACT_DEPT:\n"
                       + "CONTACT_EMAIL:\n"
                       + "CONTACT_FAX:\n"
                       + "CONTACT_TEL:\n"
                       + "}CONTACT_INFO\n"
                       + "{CUST_CD_INFO\n"
                       + "CUST_CD_TP_CD:\n"
                       + "CUST_CD:\n"
                       + "}CUST_CD_INFO\n"
                       + "{REGULATORY_INFO\n"
                       + "DUNS:\n"
                       + "}REGULATORY_INFO\n"
                       + "}CUST_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvoiceChgInfo
     * 
     * @param InvEDIHdrVO invEDIHdrVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceChgInfo(InvEDIHdrVO invEDIHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invEDIHdrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            AccountReceivableEDISendDBDAOSearchInvoiceEdiChgInfoRSQL template = new AccountReceivableEDISendDBDAOSearchInvoiceEdiChgInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{BL_CHARGE_INFO\n"
                       + "BL_CHARGE_CD:\n"
                       + "BL_CHARGE_DESC:\n"
                       + "BL_CHARGE_TP_NM:\n"
                       + "BL_CHARGE_CURR:\n"
                       + "BL_CHARGE_AMT:\n"
                       + "BL_CHARGE_AMT_USD:\n"
                       + "BL_INV_CURR:\n"
                       + "BL_INV_CURR_AMT:\n"
                       + "BL_INV_TAX:\n"
                       + "BL_INV_CURR_TTL_AMT:\n"
                       + "BL_LOCAL_CURR:\n"
                       + "BL_LOCAL_CURR_AMT:\n"
                       + "BL_LOCAL_TAX:\n"
                       + "BL_LOCAL_CURR_TTL_AMT:\n"
                       + "BL_FRT_IND:\n"
                       + "BL_RATED_AS:\n"
                       + "BL_RATE:\n"
                       + "BL_INV_EX_RATE:\n"
                       + "BL_TAX_RATE:\n"
                       + "BL_PERTYPE:\n"
                       + "BL_TARIFF:\n"
                       + "}BL_CHARGE_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * bkg별 BDR, C/A 상태 조회.<br>
	 * Table - BKG_BL_DOC<br>
	 * 
	 * @param BkgBlNoVO vo
	 * @return BkgBlNoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBlNoVO searchBkgBlNoVO(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		BkgBlNoVO bkgBlNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchBkgBlNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO.class);
			if (list.size() > 0) {
				bkgBlNoVO = (BkgBlNoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgBlNoVO;
	} 
	
	/**
	 * FNS_INV_0112 : receive header String생성
	 * 
	 * @author Lee NamKyung
	 * @param String sndrId
	 * @param String rcvId
	 * @param String msgId
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiHeader(String sndrId, String rcvId, String msgId) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("sndr_id", sndrId);
			param.put("rcv_id", rcvId);
			param.put("msg_id", msgId);

			velParam.put("sndr_id", sndrId);
			velParam.put("rcv_id", rcvId);
			velParam.put("msg_id", msgId);

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchEdiHeaderRSQL(), param, velParam);
			//공통 가이드 변경으로 채번 방식 수정

			String referenceNumber = ReferenceNumberGeneratorBroker.getKey("INV","INV_EDI_SEQ");
			
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("str_flatfile");
				strReturn = strReturn + referenceNumber;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strReturn;
	}  
	
    /**
     *  Manifest Transmit 공통 함수
     * @author 	Kim Seung Min  
     * @param 	SendFlatFileVO sendFlatFileVO
     * @return	FlatFileAckVO
     * @throws Exception
	 * @throws DAOException
     */ 
	
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO ) throws Exception {
		  String reString = "";
		  // "SUBSYSTEM_NAME + "_" + BIZ Name + "_" + Sequesnce + ... ... <<DATE>>
		  String integrationId = "BKG" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		  /* System properties : classpath/properties/subsystem-config.properties */
		  String target = SubSystemConfigFactory.get("BKG.IBMMQ.URL");
		  String transfertype = SubSystemConfigFactory.get("BKG.IBMMQ.TRANSFERTYPE");
		  String channel = SubSystemConfigFactory.get("BKG.IBMMQ.CHANNEL");
		  String factory = SubSystemConfigFactory.get("BKG.IBMMQ.FACTORY");
		  String queue = sendFlatFileVO.getQueueNm();//SubSystemConfigFactory.get("COM.TEST.IBMMQ.SEND.QUEUE");
		  String targetclient = SubSystemConfigFactory.get("BKG.IBMMQ.TARGETCLIENT");
		  
		  TransferEAI eai = new IBMSendQClient(target, this.getClass());

		  eai.setTransferType(transfertype);
		  eai.setChannel(channel);
		  eai.setFactory(factory);
		  eai.setQueue(queue);
		  //eai.setQueue("BKG_T_NACCS_EDI_SEANACCS");
		  eai.setTargetClient(targetclient);
		  //eai.setMessage("hello!!!");
		  eai.setMessage(sendFlatFileVO.getFlatFile());

		  //  eai.setObj(doc);
		  //  eai.setObj(doc);
		  
		  FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		  flatFileAckVO.setSendId(integrationId); 

		  try {
		   reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른

		   log.info("======================================");
		   log.info("reString : " + reString);
		   log.info("======================================");   
		   if ( reString.equals("SUCCESS") )
		    flatFileAckVO.setAckStsCd("A");
		   else
		    flatFileAckVO.setAckStsCd("E");
		        } catch (Exception ea) {
		         eai.rollback(ea);
		   log.error(ea.getMessage(), ea);
		   throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
		        }
		  eai.close();
		  return flatFileAckVO;
	}	
	/**
	 * FNS_INV_0112 : searchEDICustInfo
	 * 
	 * @author Lee NamKyung
	 * @param String cust_cnt_cd
	 * @param String cust_seq
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchEDICustInfo(String cust_cnt_cd, String cust_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String[] strReturn = new String[4];

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", cust_cnt_cd);
			mapVO.put("cust_seq", cust_seq);

			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchEDICustInfoRSQL(), param, velParam);
			
			
			if (dbRowset.next()) {
				strReturn[0] = dbRowset.getString("EDI_GRP_CD");
				strReturn[1] = dbRowset.getString("RECEIVER_ID");
				strReturn[2] = dbRowset.getString("SENDER_ID");
				strReturn[3] = dbRowset.getString("EDI_LVL");
			} else {
				return null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strReturn;
	}
	
	/**
	 * FNS_INV_0112 : searchInvoiceTypeCode
	 * 
	 * @param String ar_if_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvoiceTypeCode(String ar_if_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ar_if_no", ar_if_no);			
			velParam.put("ar_if_no", ar_if_no);			

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchInvoiceTypeCodeRSQL(), param, velParam);			
			
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("INV_TP_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strReturn;
	} 
	
	
	/**
	 * FNS_INV_0112 : searchSealInfo
	 * 
	 * @param String bkg_no
	 * @param String cntr_no
	 * @return List<SealInfoVO>
	 * @exception DAOException
	 */
	public List<SealInfoVO> searchSealInfo(String bkg_no, String cntr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SealInfoVO> list = null;
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkg_no);
			mapVO.put("cntr_no", cntr_no);

			param.putAll(mapVO);
			velParam.putAll(mapVO);			

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchSealInfoRSQL(), param, velParam);			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SealInfoVO.class);
			
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
	 * FNS_INV_0112 : searchCmdtInfo
	 * 
	 * @param String bkg_no
	 * @param String cntr_no
	 * @return List<CmdtInfoVO>
	 * @exception DAOException
	 */
	public List<CmdtInfoVO> searchCmdtInfo(String bkg_no, String cntr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<CmdtInfoVO> list = null;
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkg_no);
			mapVO.put("cntr_no", cntr_no);

			param.putAll(mapVO);
			velParam.putAll(mapVO);			

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchCmdtInfoRSQL(), param, velParam);			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CmdtInfoVO.class);
			
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
	 * Search EDI Header searchBKGCustCode<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchBKGCustCode() throws DAOException {
		DBRowSet dbRowset = null;
		String ediHdrSeq = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchBKGCustCodeRSQL(), param, velParam);
			if(dbRowset.next()) {
				ediHdrSeq = dbRowset.getString("BKG_CUST");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ediHdrSeq;
	}	
	
	/**
	 * FNS_INV_0112 : searchEdiSendTarget
	 * 
	 * @param String edi_hdr_seq_list
	 * @return List<InvEDIHdrVO>
	 * @exception DAOException
	 */
	public List<InvEDIHdrVO> searchEdiSendTarget(String edi_hdr_seq_list) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvEDIHdrVO> list = null;
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("edi_hdr_seq_list", edi_hdr_seq_list);

			param.putAll(mapVO);
			velParam.putAll(mapVO);			

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchEdiSendTargetRSQL(), param, velParam);			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvEDIHdrVO.class);
			
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
	 * FNS_INV_0112 : searchEdiSendHeader
	 * 
	 * @param String edi_hdr_seq_list
	 * @return List<InvEDIHdrVO>
	 * @exception DAOException
	 */
	public List<InvEDIHdrVO> searchEdiSendHeader(String edi_hdr_seq_list) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvEDIHdrVO> list = null;
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("edi_hdr_seq_list", edi_hdr_seq_list);

			param.putAll(mapVO);
			velParam.putAll(mapVO);			

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchEdiSendHeaderRSQL(), param, velParam);			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvEDIHdrVO.class);
			
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
	 * FNS_INV_0112 : searchEdiChgInfo
	 * 
	 * @param String edi_hdr_seq_list
	 * @return List<InvEDIChgVO>
	 * @exception DAOException
	 */
	public List<InvEDIChgVO> searchEdiChgInfo(String edi_hdr_seq_list) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvEDIChgVO> list = null;
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("edi_hdr_seq_list", edi_hdr_seq_list);

			param.putAll(mapVO);
			velParam.putAll(mapVO);			

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchEdiChgInfoRSQL(), param, velParam);			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvEDIChgVO.class);
			
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
	 * Search Original Invoice No<br>
	 * 
	 * @param InvEDIHdrVO invEDIHdrVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchORGInvNo( InvEDIHdrVO invEDIHdrVO ) throws DAOException {
		DBRowSet dbRowset = null;
		String orgInvNo = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invEDIHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchORGInvNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				orgInvNo = dbRowset.getString("org_inv_no");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return orgInvNo;
	}
	
	/**
	 * Search Charge info by Container<br>
	 * 
	 * @param InvEDIHdrVO invEDIHdrVO
	 * @return List<InvEDIChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvEDIChgVO> searchChargeInfoByContainer( InvEDIHdrVO invEDIHdrVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvEDIChgVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = invEDIHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchChargeInfoByContainerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvEDIChgVO.class);
			
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
	 * Search Container ToDate
	 * 
	 * @param String revTpSrcCd
	 * @param String invNo
	 * @param String cntrNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchContainerToDate(String revTpSrcCd, String invNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String toDate = "";
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rev_tp_src_cd", revTpSrcCd);
			mapVO.put("inv_no", invNo);
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);				

			dbRowset = new SQLExecuter().executeQuery(new AccountReceivableEDISendDBDAOSearchContainerToDateRSQL(), param, velParam);			
			
			if (dbRowset.next()) {
				toDate = dbRowset.getString("CNTR_TODATE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return toDate;
	}
	
	/**
	 * Search Container Invoice<br>
	 * 
	 * @param EDI310InputVO edi310InputVO
	 * @return List<EDI310InvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EDI310InvoiceVO> searchContainerInvoice( EDI310InputVO edi310InputVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<EDI310InvoiceVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (edi310InputVO != null) {
				
				//SC/RFA No Multi Entry
				String scRfaNo = edi310InputVO.getScRfaNo();
				
				StringTokenizer st = new StringTokenizer(scRfaNo, ",");
				String uScRfaNo = "";
				String strScRfaNo = "";
				while (st.hasMoreTokens()) {
					uScRfaNo = st.nextToken();
					if (uScRfaNo.equals("")) {
						strScRfaNo = "";
					}else{
						strScRfaNo = strScRfaNo+"'," + "'"+uScRfaNo;
					}
				
				}
				if(!strScRfaNo.equals("")){
					strScRfaNo = strScRfaNo + "";
				}
				
				//Customer Multi Entry
				String custCd = edi310InputVO.getCustCd();
				
				StringTokenizer st2 = new StringTokenizer(custCd, ",");
				String uCustCd = "";
				String strCustCd = "";
				while (st2.hasMoreTokens()) {
					uCustCd = st2.nextToken();
					if (uCustCd.equals("")) {
						strCustCd = "";
					}else{
						strCustCd = strCustCd+"'," + "'"+uCustCd.substring(0, 2) + Integer.parseInt(uCustCd.substring(2));
					}
				
				}
				if(!strCustCd.equals("")){
					strCustCd = strCustCd + "";
				}
				
				//Charge Multi Entry
				String chgCd = edi310InputVO.getChgCd();
				
				StringTokenizer st3 = new StringTokenizer(chgCd, ",");
				String uChgCd = "";
				String strChgCd = "";
				while (st3.hasMoreTokens()) {
					uChgCd = st3.nextToken();
					if (uChgCd.equals("")) {
						strChgCd = "";
					}else{
						strChgCd = strChgCd+"'," + "'"+uChgCd;
					}
				
				}
				if(!strChgCd.equals("")){
					strChgCd = strChgCd + "";
				}
				
				Map<String, String> mapVO = edi310InputVO.getColumnValues();

				mapVO.put("sc_rfa_no", strScRfaNo);	
				mapVO.put("cust_cd", strCustCd);
				mapVO.put("chg_cd", strChgCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableEDISendDBDAOSearchContainerInvoiceRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EDI310InvoiceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}
