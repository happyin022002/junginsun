/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableAgentBCImpl.java
 *@FileTitle : AccountReceivableAgentBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.04
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration.AccountReceivableAgentDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AGnCltRfndN3rdAmtSumVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AGnCltRfndUsdLclAmtSumVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASACltRfndAdjListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAExpenseDrCrAmtVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInfoByOfcAgnVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInquiryListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAnoListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.BatHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.CheckASAperiodVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.CheckPreASAStausVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ManageAgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.UnreportedOtsReportVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.basic.AccountReceivableAdjustBC;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.basic.AccountReceivableAdjustBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration.AccountReceivableAdjustDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBC;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration.AccountReceivableCommonDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.StmOfcInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration.AccountReceivableOutstandingDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingCheckVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSForApplyAdjustVO;
import com.clt.apps.opus.stm.sar.common.SarUtil;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration.StatementCommonDBDAO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.MDMOfficeInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SarAdjHisVO;
import com.clt.syscommon.common.table.SarAgnCltRfndMstVO;
import com.clt.syscommon.common.table.SarAsaDtlVO;
import com.clt.syscommon.common.table.SarAsaMstVO;
import com.clt.syscommon.common.table.SarAsaNoSeqVO;
import com.clt.syscommon.common.table.SarOtsHisVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * Agent Business Logic Command implementation<br>
 * 
 * @author
 * @see AccountReceivableAgentBC
 * @since J2EE 1.4
 */
public class AccountReceivableAgentBCImpl extends BasicCommandSupport implements AccountReceivableAgentBC {
	// Database Access Object
	private transient AccountReceivableAgentDBDAO dbDao = null;
	private transient StatementCommonDBDAO stmtCommDao = null;
	private transient AccountReceivableCommonDBDAO comDao = null;
	private transient AccountReceivableOutstandingDBDAO otsDao = null;
	private transient AccountReceivableAdjustDBDAO adjDao = null;

	public AccountReceivableAgentBCImpl() {
		dbDao = new AccountReceivableAgentDBDAO();
		stmtCommDao = new StatementCommonDBDAO();
		otsDao = new AccountReceivableOutstandingDBDAO();
		comDao = new AccountReceivableCommonDBDAO();
		adjDao = new AccountReceivableAdjustDBDAO();
	}

	/**
	 * ASA NO Pop up 화면<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_0200
	 * @category searchASAnoList
	 * @param String asa_no
	 * @param String asa_ofc_cd
	 * @param String flag_cd
	 * @return List<ASAnoListVO>
	 * @throws EventException
	 */
	@Override
	public List<ASAnoListVO> searchASAnoList(String asa_no, String asa_ofc_cd, String flag_cd) throws EventException {
		try {
			List<ASAnoListVO> returnList = dbDao.searchASAnoList(asa_no, asa_ofc_cd, flag_cd);

			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}

	/**
	 * Agent Collection Entry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5001
	 * @category searchAgentCollectionList
	 * @param AgentCollectionListVO agentCollectionListVO
	 * @return List<AgentCollectionListVO>
	 * @throws EventException
	 */
	@Override
	public List<AgentCollectionListVO> searchAgentCollectionListInquiry(AgentCollectionListVO agentCollectionListVO) throws EventException {
		try {
			List<AgentCollectionListVO> returnList = dbDao.searchAgentCollectionListInquiry(agentCollectionListVO);

			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}
	
	/**
	 * Agent Collection Entry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5001
	 * @category searchAgentCollectionList
	 * @param AgentCollectionListVO agentCollectionListVO
	 * @return List<AgentCollectionListVO>
	 * @throws EventException
	 */
	@Override
	public List<AgentCollectionListVO> searchAgentCollectionListFOREntry(AgentCollectionListVO agentCollectionListVO) throws EventException {
		try {
			List<AgentCollectionListVO> returnList = dbDao.searchAgentCollectionListFOREntry(agentCollectionListVO);
			
			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}

	/**
	 * Agent Collection Inquiry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5005
	 * @category searchAgentCollectionListInquiry
	 * @param AgentCollectionListVO agentCollectionListVO
	 * @param SignOnUserAccount account
	 * @return List<AgentCollectionListVO>
	 * @throws EventException
	 */
	@Override
	public List<AgentCollectionListVO> searchAgentCollectionList(AgentCollectionListVO agentCollectionListVO,SignOnUserAccount account) throws EventException {
		try {
			agentCollectionListVO.setUsrId(account.getUsr_id()); 
			List<AgentCollectionListVO> returnList = dbDao.searchAgentCollectionList(agentCollectionListVO);
			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}
	
	/**
	 * Agent Collection Entry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5004
	 * @category manageAgentCollectionList
	 * @param ManageAgentCollectionListVO[] manageAgentCollectionListVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageAgentCollectionListBasic(ManageAgentCollectionListVO[] manageAgentCollectionListVOS, SignOnUserAccount account) throws EventException {
		try {
			String GlDt = "";
			String agntToDt = "";
			String agntOfcCd = "";

			AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			// List<AgentCollectionListVO> agentCollectionListVO = new
			// ArrayList<AgentCollectionListVO>();

			List<ManageAgentCollectionListVO> insertVoList = new ArrayList<ManageAgentCollectionListVO>();
			List<ManageAgentCollectionListVO> updateVoList = new ArrayList<ManageAgentCollectionListVO>();
			List<ManageAgentCollectionListVO> deleteVoList = new ArrayList<ManageAgentCollectionListVO>();

			if (manageAgentCollectionListVOS[0].getIbflag().equals("I")) {
				agntToDt = manageAgentCollectionListVOS[0].getGlYrmon().replace("-", "");
				agntOfcCd = manageAgentCollectionListVOS[0].getArOfcCd();

				// check GL Date
				GlDt = arComDao.searchEffectiveDate(agntToDt, agntOfcCd, "26");

				if (GlDt == null || GlDt.equals("")) {
					throw new EventException(new ErrorHandler("SAR00003", new String[] { "period status" }).getMessage());
				}
			}

			for (int i = 0; i < manageAgentCollectionListVOS.length; i++) {
				if (manageAgentCollectionListVOS[i].getIbflag().equals("I")) {

					manageAgentCollectionListVOS[i].setCreUsrId(account.getUsr_id());
					manageAgentCollectionListVOS[i].setUpdUsrId(account.getUsr_id());

					deleteVoList.add(manageAgentCollectionListVOS[i]);
					insertVoList.add(manageAgentCollectionListVOS[i]);

				} else if (manageAgentCollectionListVOS[i].getIbflag().equals("U")) {
					manageAgentCollectionListVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(manageAgentCollectionListVOS[i]);

				} else if (manageAgentCollectionListVOS[i].getIbflag().equals("D")) {
					deleteVoList.add(manageAgentCollectionListVOS[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeAgentCollectionList(deleteVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.addAgentCollectionList(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyAgentCollectionList(updateVoList);
			}
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Unreported OTS Report<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5004
	 * @category searchUnreportedOtsReportList
	 * @param UnreportedOtsReportVO unreportedOtsReportVO
	 * @return List<UnreportedOtsReportVO>
	 * @throws EventException
	 */
	@Override
	public List<UnreportedOtsReportVO> searchUnreportedOtsReportList(UnreportedOtsReportVO unreportedOtsReportVO) throws EventException {
		try {
			List<UnreportedOtsReportVO> returnList = dbDao.searchUnreportedOtsReportList(unreportedOtsReportVO);

			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}

	/**
	 * Agent Statement of Account Inquiry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_5003
	 * @category searchASAInquiryList
	 * @param ASAInquiryListVO aSAInquiryListVO
	 * @return List<ASAInquiryListVO>
	 * @throws EventException
	 */
	@Override
	public List<ASAInquiryListVO> searchASAInquiryList(ASAInquiryListVO aSAInquiryListVO) throws EventException {
		try {
			List<ASAInquiryListVO> returnList = dbDao.searchASAInquiryList(aSAInquiryListVO);

			return returnList;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}

	/**
	 * Search ASA init info
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param ASAInfoByOfcAgnVO paramVO
	 * @param String lOfcCd
	 * @return ASAInfoByOfcAgnVO
	 * @throws EventException
	 */
	@Override
	public ASAInfoByOfcAgnVO searchASAInfoByOfcAgn(ASAInfoByOfcAgnVO paramVO, String lOfcCd) throws EventException {
		try {

			ASAInfoByOfcAgnVO asaInfo = dbDao.searchASAInfoByOfcAgn(paramVO);
			String maxAsaPrdToDt = asaInfo.getMaxAsaPrdToDt();

			if (StringUtils.isEmpty(maxAsaPrdToDt)) {
				AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();
				maxAsaPrdToDt = commonBC.searchLocalTime(lOfcCd);
				asaInfo.setAsaPrdFmDt(maxAsaPrdToDt);
			} else {
				SimpleDateFormat parser = new SimpleDateFormat("yyyyMMdd");
				Date date = parser.parse(maxAsaPrdToDt);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DAY_OF_MONTH, 1);
				Date addDate = cal.getTime();
				asaInfo.setAsaPrdFmDt(parser.format(addDate));
			}

			return asaInfo;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Search ASA Master
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaMstVO paramVO
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	@Override
	public SarAsaMstVO searchASAMst(SarAsaMstVO paramVO) throws EventException {
		try {
			return dbDao.searchASAMst(paramVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Search ASA Detail
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaDtlVO paramVO
	 * @return List<SarAsaDtlVO>
	 * @throws EventException
	 */
	@Override
	public List<SarAsaDtlVO> searchASADtl(SarAsaDtlVO paramVO) throws EventException {
		try {
			return dbDao.searchASADtl(paramVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Search ASA No Sequence
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaNoSeqVO paramVO
	 * @return SarAsaNoSeqVO
	 * @throws EventException
	 */
	@Override
	public SarAsaNoSeqVO searchASASeqNo(SarAsaNoSeqVO paramVO) throws EventException {
		try {
			return dbDao.searchASASeqNo(paramVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Search ASA No Sequence
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaMstVO paramVO
	 * @param String lOfcCd
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	@Override
	public SarAsaMstVO createASA(SarAsaMstVO paramVO, String lOfcCd) throws EventException {
		AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();

		try {

			StmOfcInfoVO ofcInfo = commonBC.searchStmOfcInfo(paramVO.getAgnCd());

			// ------------------------------------------------
			// get ASA info
			// ------------------------------------------------
			ASAInfoByOfcAgnVO asaInfoByOfcAgnVO = new ASAInfoByOfcAgnVO();
			asaInfoByOfcAgnVO.setUserId(paramVO.getCreUsrId());
			asaInfoByOfcAgnVO.setOpenAsaYn("N");
			asaInfoByOfcAgnVO.setOfcCd(paramVO.getOfcCd());
			asaInfoByOfcAgnVO.setAgnCd(paramVO.getAgnCd());
			asaInfoByOfcAgnVO.setCurrCd(paramVO.getCurrCd());
			asaInfoByOfcAgnVO.setAsaPrdFmDt(paramVO.getAsaPrdFmDt());

			ASAInfoByOfcAgnVO asaInfo = searchASAInfoByOfcAgn(asaInfoByOfcAgnVO, lOfcCd);
			// input data
			asaInfo.setAsaPrdToDt(paramVO.getAsaPrdToDt());
			asaInfo.setAsaPrdFmDt(paramVO.getAsaPrdFmDt());

			String lclTime = paramVO.getAsaPrdToDt();
			String lclYear = lclTime.substring(0, 4);
			String yMM = lclTime.substring(3, 6);

			// ------------------------------------------------
			// get ASA NO
			// ------------------------------------------------
			SarAsaNoSeqVO asaNoSeqParamVO = new SarAsaNoSeqVO();
			asaNoSeqParamVO.setOfcCd(paramVO.getOfcCd());
			asaNoSeqParamVO.setAgnCd(paramVO.getAgnCd());
			int asaNoSeq = 1;

			SarAsaNoSeqVO asaNoSeqVO = dbDao.searchASASeqNo(asaNoSeqParamVO);

			SarAsaNoSeqVO sarAsaNoSeqVO = new SarAsaNoSeqVO();
			sarAsaNoSeqVO.setOfcCd(paramVO.getOfcCd()); // OFFICE CODE
			sarAsaNoSeqVO.setAgnCd(paramVO.getAgnCd()); // AGENT CODE
			sarAsaNoSeqVO.setAsaPrdYr(lclYear); // ASA PERIOD Year
			sarAsaNoSeqVO.setAsaSeq(asaNoSeq + ""); // ASA Sequence
			sarAsaNoSeqVO.setCreUsrId(paramVO.getCreUsrId()); // CREATE USER ID
			sarAsaNoSeqVO.setCreDt(""); // CREATE DATE
			sarAsaNoSeqVO.setUpdUsrId(paramVO.getUpdUsrId()); // UPDATE USER ID
			sarAsaNoSeqVO.setUpdDt(""); // UPDATE DATE

			if (asaNoSeqVO != null) {
				asaNoSeq = Integer.parseInt(asaNoSeqVO.getAsaSeq()) + 1;
				// update ASA sequence number
				sarAsaNoSeqVO.setAsaSeq(asaNoSeq + ""); // ASA Sequence
				dbDao.modifyASANoSeq(sarAsaNoSeqVO);
			} else {
				// Insert ASA sequence number
				dbDao.addASANoSeq(sarAsaNoSeqVO);
			}

			// ------------------------------------------------
			// insert ASA Header
			// ------------------------------------------------
			String asaNoCtnt3 = StringUtils.leftPad("" + asaNoSeq, 4, "0");
			String asaNo = ofcInfo.getAgnPfxCd() + yMM + asaNoCtnt3;

			SarAsaMstVO asaMstVO = new SarAsaMstVO();
			asaMstVO.setAsaNo(asaNo); // ASA NUMBER
			asaMstVO.setAgnCd(paramVO.getAgnCd()); // AGENT CODE
			asaMstVO.setAsaPrdFmDt(paramVO.getAsaPrdFmDt()); // ASA PERIOD FROM
																// DATE
			asaMstVO.setAsaPrdToDt(paramVO.getAsaPrdToDt()); // ASA PERIOD TO
																// DATE
			asaMstVO.setCurrCd(paramVO.getCurrCd()); // CURRENCY CODE

			asaMstVO.setActBalAmt("0"); // ACTUAL BALANCE AMOUNT

			asaMstVO.setAsaFshDt(""); // ASA FINISH DATE
			asaMstVO.setAsaFshUsrId(""); // ASA FINISH USER ID
			asaMstVO.setAsaAproUsrId(""); // ASA APPROVAL USER ID
			asaMstVO.setAsaAproDt(""); // ASA APPROVAL DATE
			asaMstVO.setAsaNoCtnt1(ofcInfo.getAgnPfxCd()); // ASA NUMBER
															// CONTENT1
			asaMstVO.setAsaNoCtnt2(yMM); // ASA NUMBER CONTENT2
			asaMstVO.setAsaNoCtnt3(asaNoCtnt3); // ASA NUMBER CONTENT3
			asaMstVO.setAsaStsCd("O"); // ASA STATUS CODE
			asaMstVO.setPreAsaNo(asaInfo.getMaxAsaNo()); // PREVIOUS ASA NUMBER
			asaMstVO.setOfcCd(paramVO.getOfcCd()); // OFFICE CODE
			asaMstVO.setCreUsrId(paramVO.getCreUsrId()); // CREATE USER ID
			asaMstVO.setCreDt(""); // CREATE DATE
			asaMstVO.setUpdUsrId(paramVO.getUpdUsrId()); // UPDATE USER ID
			asaMstVO.setUpdDt(""); // UPDATE DATE
			dbDao.addASAMst(asaMstVO);

			// ------------------------------------------------
			// Create ASA Detail
			// ------------------------------------------------
			List<LookupInfoVO> list = stmtCommDao.searchLookupList("ASA DETAIL LINE");
			// insert ASA Detail
			for (LookupInfoVO codeVO : list) {
				SarAsaDtlVO vo = new SarAsaDtlVO();

				vo.setAsaNo(asaNo); // ASA NUMBER
				vo.setAsaDtlSeq(codeVO.getLuCd()); // ASA DETAIL NUMBER
				vo.setAsaDtlDesc(codeVO.getLuDesc()); // ASA DETAIL DESCRIPTION
				vo.setAsaDrAmt("0"); // DEBIT AMOUNT
				vo.setAsaCrAmt("0"); // CREDIT AMOUNT
				vo.setEffDt(""); // EFFECTIVE DATE
				vo.setAsaDtlTpCd(codeVO.getAttrCtnt1()); // ASA DETAIL TYPE CODE
				vo.setCreUsrId(paramVO.getCreUsrId()); // CREATE USER ID
				vo.setCreDt(""); // CREATE DATE
				vo.setUpdUsrId(paramVO.getUpdUsrId()); // UPDATE USER ID
				vo.setUpdDt(""); // UPDATE DATE
				dbDao.addASADtl(vo);
			}

			// ------------------------------------------------
			// update ASA Detail
			// ------------------------------------------------
			updateASADtl(asaNo, paramVO.getCreUsrId());

			return asaMstVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Create & Update ASA Detail
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @param String userId
	 * @throws EventException
	 */
	@Override
	public void updateASADtl(String asaNo, String userId) throws EventException {

		try {

			// get ASA Master --------------------------------------
			SarAsaMstVO asaMstParamVO = new SarAsaMstVO();
			asaMstParamVO.setAsaNo(asaNo);
			SarAsaMstVO asaMstVO = dbDao.searchASAMst(asaMstParamVO);

			// not open ASA
			if (asaMstVO == null || !"O".equals(asaMstVO.getAsaStsCd())) {
				return;
			}

			SarAsaDtlVO paramVO = new SarAsaDtlVO();
			paramVO.setAsaNo(asaNo);
			paramVO.setCreUsrId(userId);
			paramVO.setUpdUsrId(userId);

			List<SarAsaDtlVO> asaDtlList = dbDao.searchASADtlForUpdate(paramVO);
			// update ASA Detail --------------------------------------
			for (SarAsaDtlVO vo : asaDtlList) {

				String asaDtlSeq = vo.getAsaDtlSeq();
				vo.setUpdUsrId(userId);

				if ("1".equals(asaDtlSeq)) {
					// select Balance Brought Forward BEGIN
					// Previous ASA No.
					paramVO.setAsaNo(asaMstVO.getPreAsaNo());
					paramVO.setAsaDtlSeq("7"); // 7. Balance Carried Forward
					List<SarAsaDtlVO> list = dbDao.searchASADtl(paramVO);

					if (list == null || list.isEmpty()) {
						vo.setAsaDrAmt("0");
						vo.setAsaCrAmt("0");
					} else {
						// update ASA Detail
						SarAsaDtlVO preAsaDtlVO = list.get(0);
						vo.setAsaDrAmt(preAsaDtlVO.getAsaCrAmt());
						vo.setAsaCrAmt(preAsaDtlVO.getAsaDrAmt());
					}
				} else if ("2".equals(asaDtlSeq)) {
					// select Revenue To Be Collected COLLECTION
					BigDecimal ttlAmt = dbDao.searchSarAgnCltRfndSumTtlAmt(asaNo, "C");
					vo.setAsaDrAmt("0");
					vo.setAsaCrAmt(ttlAmt.toPlainString());

				} else if ("3".equals(asaDtlSeq)) {
					// Refund Request REFUND
					BigDecimal ttlAmt = dbDao.searchSarAgnCltRfndSumTtlAmt(asaNo, "R");
					vo.setAsaDrAmt(ttlAmt.negate().toPlainString());
					vo.setAsaCrAmt("0");
				} else if ("4".equals(asaDtlSeq)) {
					// Operation Expense Paid EXPENSE
					ASAExpenseDrCrAmtVO drCrAmt = dbDao.searchASAExpenseDrCrAmt(asaNo, "AEP");
					vo.setAsaDrAmt(drCrAmt.getDebitAmt());
					vo.setAsaCrAmt(drCrAmt.getCreditAmt());
				} else if ("5".equals(asaDtlSeq)) {
					// Agency Commission COMMISSION
					ASAExpenseDrCrAmtVO drCrAmt = dbDao.searchASAExpenseDrCrAmt(asaNo, "ACM");
					vo.setAsaDrAmt(drCrAmt.getDebitAmt());
					vo.setAsaCrAmt(drCrAmt.getCreditAmt());
				} else if ("6".equals(asaDtlSeq)) {   
					// Remittance Made REMITTANCE
					ASAExpenseDrCrAmtVO drCrAmt = dbDao.searchASARemittanceDrCrAmt(asaNo);

					ASAExpenseDrCrAmtVO expDrCrAmt = dbDao.searchASARemittanceExpDrCrAmt(asaNo);

					BigDecimal remiDrAmt = new BigDecimal(drCrAmt.getDebitAmt()).add(new BigDecimal(expDrCrAmt.getDebitAmt()));

					BigDecimal remiCrAmt = new BigDecimal(drCrAmt.getCreditAmt()).add(new BigDecimal(expDrCrAmt.getCreditAmt()));

					vo.setAsaDrAmt(remiDrAmt.toPlainString());
					vo.setAsaCrAmt(remiCrAmt.toPlainString());

				} else if ("7".equals(asaDtlSeq)) {
					// Balance Carried Forward BALANCE
					// Credit amt - debit amt
					BigDecimal balAmt = dbDao.searchASABalanceFowardAmt(asaNo);

					if (balAmt.compareTo(new BigDecimal(0)) > 0) {
						vo.setAsaDrAmt(balAmt.toPlainString());
						vo.setAsaCrAmt("0");
					} else {
						vo.setAsaDrAmt("0");
						vo.setAsaCrAmt(balAmt.negate().toPlainString());
					}
				}

				dbDao.modifyASADtl(vo);

			}

			// ------------------------------------------
			// update ASA Header Actual amount
			// ------------------------------------------
			// actual Amount
			BigDecimal actBalAmt = dbDao.searchASAActualBalAmt(asaNo);

			SarAsaMstVO sarAsaMstVO = new SarAsaMstVO();
			sarAsaMstVO.setAsaNo(asaNo);
			sarAsaMstVO.setActBalAmt(actBalAmt.toPlainString());
			sarAsaMstVO.setUpdUsrId(paramVO.getUpdUsrId());

			dbDao.modifyASAMst(sarAsaMstVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}
	
	/**
	 * Create & Update ASA Detail for interface
	 * 
	 * @author myoungsinpark 2015. 5. 22.
	 * @param String asaNo
	 * @param String userId
	 * @throws EventException
	 */
	public void updateASADtlForCall(String asaNo, String userId) throws EventException { 
		try {
			 List<ASAnoListVO> asaList = dbDao.searchOpenAsa(asaNo);
			 for (int i = 0; i < asaList.size(); i++) {
				 ASAnoListVO aSAnoListVO = asaList.get(i);
				 updateASADtl(aSAnoListVO.getAsaNo(),userId);
			 }
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}

	/**
	 * Finish ASA
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @param String userId
	 * @param String lOfcCd
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	@Override
	public SarAsaMstVO finishASA(String asaNo, String userId, String lOfcCd) throws EventException {

		try {

			AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();

			// get ASA Master --------------------------------------
			SarAsaMstVO asaMstParamVO = new SarAsaMstVO();
			asaMstParamVO.setAsaNo(asaNo);
			SarAsaMstVO asaMstVO = dbDao.searchASAMst(asaMstParamVO);

			// not open ASA
			if (asaMstVO == null || !"O".equals(asaMstVO.getAsaStsCd())) {
				return null;
			}

			// updata ASA Detail(1~7)
			updateASADtl(asaNo, userId);

			// update ASA status
			String lclTime = commonBC.searchLocalTimeYMDHMS(lOfcCd);
			SarAsaMstVO upAsaMstVO = new SarAsaMstVO();
			upAsaMstVO.setAsaNo(asaNo);
			upAsaMstVO.setAsaFshUsrId(userId);
			upAsaMstVO.setUpdUsrId(userId);
			upAsaMstVO.setAsaStsCd("F"); // finish
			upAsaMstVO.setAsaFshDt(lclTime);
			dbDao.modifyASAMst(upAsaMstVO);

			return asaMstVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}

	/**
	 * reopen ASA
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @param String userId
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	@Override
	public SarAsaMstVO reopenASA(String asaNo, String userId) throws EventException {

		try {

			// get ASA Master --------------------------------------
			SarAsaMstVO asaMstParamVO = new SarAsaMstVO();
			asaMstParamVO.setAsaNo(asaNo);
			SarAsaMstVO asaMstVO = dbDao.searchASAMst(asaMstParamVO);

			// not open ASA
			if (asaMstVO == null || !"F".equals(asaMstVO.getAsaStsCd())) {
				return null;
			}

			// update ASA status
			SarAsaMstVO upAsaMstVO = new SarAsaMstVO();
			upAsaMstVO.setAsaNo(asaNo);
			upAsaMstVO.setAsaFshUsrId("null");
			upAsaMstVO.setUpdUsrId(userId);
			upAsaMstVO.setAsaStsCd("O"); // change status finish -> open
			upAsaMstVO.setAsaFshDt("null");
			dbDao.modifyASAMst(upAsaMstVO);

			return asaMstVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}

	/**
	 * approve ASA 대리점 Collect & Refund를 조정후 하나의 ASA No.로 OTS를 생성한다. Collect &
	 * Refund and one representative of the adjusted ASA No. OTS is created.
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @param String userId
	 * @param String lOfcCd
	 * @return SarAsaMstVO
	 * @throws EventException
	 */
	@Override
	public SarAsaMstVO approveASA(String asaNo, String userId, String lOfcCd) throws EventException {

		try {

			AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();
			AccountReceivableAdjustBC adjBC = new AccountReceivableAdjustBCImpl();
			AccountReceivableOutstandingBC otsBC = new AccountReceivableOutstandingBCImpl();

			String lclTime = commonBC.searchLocalTime(lOfcCd);
			String lclTimeYmd = commonBC.searchLocalTimeYMDHMS(lOfcCd);

			// -------------------------------------
			// get ASA Master
			// -------------------------------------
			SarAsaMstVO asaMstParamVO = new SarAsaMstVO();
			asaMstParamVO.setAsaNo(asaNo);
			SarAsaMstVO asaMstVO = dbDao.searchASAMst(asaMstParamVO);

			// not finish ASA
			if (asaMstVO == null || !"F".equals(asaMstVO.getAsaStsCd())) {
				return null;
			}

			// ===========================================
			// search ASA collect & refund and OTS join
			// ===========================================
			List<ASACltRfndAdjListVO> srcList = dbDao.searchASACltRfndAdjList(asaNo);

			// split currency
			List<ASACltRfndAdjListVO> tgList = new ArrayList<ASACltRfndAdjListVO>();

			// --------------------------------------
			// split B/L by currency
			// --------------------------------------
			for (ASACltRfndAdjListVO vo : srcList) {

				// String asaTpCd = vo.getAsaTpCd();

				// Local Currency
				if (!StringUtils.isEmpty(vo.getLoclAmt()) && !"0".equals(vo.getLoclAmt())) {
					ASACltRfndAdjListVO newVO = (ASACltRfndAdjListVO) vo.clone();
					newVO.setBlCurrCd(vo.getLoclCurrCd());
					newVO.setAdjAmt(vo.getLoclAmt());
					tgList.add(newVO);

				}

				// USD Currency
				if (!StringUtils.isEmpty(vo.getUsdAmt()) && !"0".equals(vo.getUsdAmt())) {
					ASACltRfndAdjListVO newVO = (ASACltRfndAdjListVO) vo.clone();
					newVO.setBlCurrCd("USD");
					newVO.setAdjAmt(vo.getUsdAmt());
					tgList.add(newVO);
				}

				// N3RD_CURR_CD1
				if (!StringUtils.isEmpty(vo.getN3rdAmt1()) && !"0".equals(vo.getN3rdAmt1())) {
					ASACltRfndAdjListVO newVO = (ASACltRfndAdjListVO) vo.clone();
					newVO.setBlCurrCd(vo.getN3rdCurrCd1());
					newVO.setAdjAmt(vo.getN3rdAmt1());
					tgList.add(newVO);
				}

				// N3RD_CURR_CD2
				if (!StringUtils.isEmpty(vo.getN3rdAmt2()) && !"0".equals(vo.getN3rdAmt2())) {
					ASACltRfndAdjListVO newVO = (ASACltRfndAdjListVO) vo.clone();
					newVO.setBlCurrCd(vo.getN3rdCurrCd2());
					newVO.setAdjAmt(vo.getN3rdAmt2());
					tgList.add(newVO);
				}
				// N3RD_CURR_CD3
				if (!StringUtils.isEmpty(vo.getN3rdAmt3()) && !"0".equals(vo.getN3rdAmt3())) {
					ASACltRfndAdjListVO newVO = (ASACltRfndAdjListVO) vo.clone();
					newVO.setBlCurrCd(vo.getN3rdCurrCd3());
					newVO.setAdjAmt(vo.getN3rdAmt3());
					tgList.add(newVO);
				}

				// N3RD_CURR_CD4
				if (!StringUtils.isEmpty(vo.getN3rdAmt4()) && !"0".equals(vo.getN3rdAmt4())) {
					ASACltRfndAdjListVO newVO = (ASACltRfndAdjListVO) vo.clone();
					newVO.setBlCurrCd(vo.getN3rdCurrCd4());
					newVO.setAdjAmt(vo.getN3rdAmt4());
					tgList.add(newVO);
				}

				// ===========================================
				// update ASA collect & refund
				// ===========================================
				SarAgnCltRfndMstVO cltRfndVO = new SarAgnCltRfndMstVO();
				cltRfndVO.setAsaNo(vo.getAsaNo());
				cltRfndVO.setBlNo(vo.getBlNo());
				cltRfndVO.setChgTpCd(vo.getChgTpCd());
				cltRfndVO.setInvNo(vo.getInvNo());
				cltRfndVO.setAproFlg("Y");
				cltRfndVO.setUpdUsrId(userId);

				dbDao.modifySarGgnCltRfndMst(cltRfndVO);

			}

			// ===========================================
			// processing adjust OTS
			// ===========================================
			// functional currency
			String funcCurr = comDao.searchFunctionalCurrency("FUNCTIONAL CURRENCY");
			List<CurrencyCodeVO> list = comDao.searchCurrencyCode(funcCurr);
			String dpPrcsKnt = list.get(0).getDpPrcsKnt();

			// ADJUST SEQUENCE
			List<String> adjSeqList = new ArrayList<String>();

			for (ASACltRfndAdjListVO vo : tgList) {

				// adjust Amount - input cltRfnd
				BigDecimal inputAdjAmt = new BigDecimal(vo.getAdjAmt());
				inputAdjAmt = inputAdjAmt.multiply(new BigDecimal(-1));

				// ========================================
				// select Target AR charge , History (SAR_OTS_CHG, SAR_OTS_HIS)
				// ========================================
				AROutstandingCheckVO targetVO = new AROutstandingCheckVO();
				targetVO.setOtsOfcCd(vo.getArOfcCd());
				targetVO.setBlNo(vo.getBlNo());
				targetVO.setInvNo(vo.getInvNo());
				targetVO.setBlCurrCd(vo.getBlCurrCd());
				targetVO.setChgTpCd(vo.getChgTpCd());
				targetVO.setAsaFlg("Y");
				List<OTSForApplyAdjustVO> targetList = otsDao.searchOutstandingForApplyAdjust(targetVO);

				int lastIndex = targetList.size() - 1;

				// -----------------------------------------
				// loop adjust target data
				// -----------------------------------------
				for (int i = 0; i < targetList.size(); i++) {

					OTSForApplyAdjustVO tgVO = targetList.get(i);

					// ----------------------------------------
					// get Adjust amount
					// ----------------------------------------
					BigDecimal chgBalAmt = new BigDecimal(tgVO.getChgBalAmt());

					BigDecimal adjAmt = new BigDecimal(0);

					if (inputAdjAmt.signum() == chgBalAmt.signum()) {
						adjAmt = inputAdjAmt;
						inputAdjAmt = new BigDecimal(0);
					} else {
						if (adjAmt.abs().compareTo(chgBalAmt.abs()) <= 0) {
							adjAmt = inputAdjAmt;
						} else {
							adjAmt = chgBalAmt;
						}

						if (adjAmt.signum() != inputAdjAmt.signum()) {
							adjAmt = adjAmt.negate();
						}
						inputAdjAmt = inputAdjAmt.subtract(adjAmt);
					}

					if (i == lastIndex && inputAdjAmt.compareTo(new BigDecimal(0)) != 0) {
						adjAmt = adjAmt.add(inputAdjAmt);
					}

					// ========================================
					// insert adjust history(SAR_ADJ_HIS)
					// ========================================

					SarAdjHisVO adjHisVO = new SarAdjHisVO();
					// ADJUST SEQUENCE
					String adjHisSeq = comDao.getSequence("SAR_ADJ_HIS_SEQ").toPlainString();
					adjHisVO.setAdjHisSeq(adjHisSeq);

					adjHisVO.setAdjNo(vo.getAsaNo()); // ASA NO.
					adjHisVO.setAdjStsCd("ADJUST"); // ADJUST STATUS CODE
					adjHisVO.setAdjAmt(adjAmt.toPlainString()); // ADJUST AMOUNT
																// (Menus)
					adjHisVO.setAdjAplyDt(lclTime); // ADJUST APPLY DATE
					adjHisVO.setAdjGlDt(vo.getAsaPrdToDt()); // ASA Period To
																// Date
					adjHisVO.setAdjCdCmbSeq("-1"); // ADJUST CODE COMBINATION
													// SEQUENCE
					adjHisVO.setChgTpCd(vo.getChgTpCd()); // CHARGE TYPE CODE

					String loclCurrCd = vo.getLoclCurrCd();

					// local currency equal outstanding BL currency
					if (loclCurrCd.equals(tgVO.getCurrCd())) {
						adjHisVO.setAdjTpCd("AGT"); // ADJUST TYPE CODE
					} else {
						adjHisVO.setAdjTpCd("AGC"); // ADJUST TYPE CODE
					}

					adjHisVO.setAdjRmk(""); // ADJUST REMARK
					adjHisVO.setGlTrnsSeq("-1"); // G/L TRANSFER SEQUENCE
					adjHisVO.setGlTrnsDt(""); // G/L TRANSFER DATE

					String funcCurrRate = adjDao.searchFunctionalCurrencyRate(vo.getBlCurrCd(), funcCurr, vo.getAsaPrdToDt());

					if (funcCurrRate == null || funcCurrRate.equals("")) {
						throw new EventException(new ErrorHandler("SAR00025", new String[] {}).getMessage());
					}

					BigDecimal funcCurrRt = new BigDecimal(funcCurrRate);
					adjHisVO.setAdjAcctAmt(adjAmt.multiply(funcCurrRt).setScale(Integer.parseInt(dpPrcsKnt), BigDecimal.ROUND_HALF_UP).toPlainString()); // ADJUST
																																							// ACCOUNT
																																							// AMOUNT

					adjHisVO.setOrzSeq("-1"); // ORGANIZATION SEQUENCE
					adjHisVO.setAcctgEvntSeq("-1"); // ACCOUNTING EVENT SEQUENCE
					adjHisVO.setCreUsrId(userId); // CREATE USER ID
					adjHisVO.setCreDt(""); // CREATE DATE
					adjHisVO.setUpdUsrId(userId); // UPDATE USER ID
					adjHisVO.setUpdDt(""); // UPDATE DATE
					adjHisVO.setOtsHisSeq(tgVO.getOtsHisSeq()); // OUTSTANDING
																// HISTORY
																// SEQUENCE

					// ACCOUNT MATRIX SEQUENCE
					String adjTpCd = "AGT"; // ARAP Offset
					if (!vo.getLoclCurrCd().equals(tgVO.getCurrCd())) {
						adjTpCd = "AGC"; // ARAP CrossCurrency Offset
					}

					String acctMtxSeq = adjDao.searchAcctMtxSeq(adjTpCd, vo.getAsaPrdToDt());

					if (acctMtxSeq == null || acctMtxSeq.equals("")) {
						throw new EventException(new ErrorHandler("SAR00034", new String[] {}).getMessage());
					}

					adjHisVO.setAcctMtxSeq(acctMtxSeq);

					adjHisVO.setAdjKeyNo(vo.getAsaNo());// ADJUST KEY NUMBER
					adjHisVO.setAdjOfcCd(asaMstVO.getOfcCd());

					// Insert SAR_Adj_HIS
					adjDao.addSarAdjHis(adjHisVO);

					// ------------------------------------
					// INSERT SAR DISTRIBUTION TABLE(SAR_CLT_DTRB)
					// ------------------------------------
					adjBC.manageDistribution(adjHisSeq, adjHisVO.getAdjGlDt(), vo.getBlCurrCd(), funcCurrRate, dpPrcsKnt, acctMtxSeq, adjHisVO.getAdjStsCd());

					// Ad ADJUST SEQUENCE
					adjSeqList.add(adjHisSeq);

					// Complete Adjust Amount
					if (inputAdjAmt.compareTo(new BigDecimal(0)) == 0) {
						break;
					}

				}

			}

			if (tgList == null || tgList.isEmpty()) {

				// ===========================================
				// update ASA Master
				// ===========================================
				// update ASA status
				SarAsaMstVO upAsaMstVO = new SarAsaMstVO();
				upAsaMstVO.setAsaNo(asaNo);
				upAsaMstVO.setAsaAproUsrId(userId);
				upAsaMstVO.setUpdUsrId(userId);
				upAsaMstVO.setAsaStsCd("A"); // Aprove:A
				upAsaMstVO.setAsaAproDt(lclTimeYmd);
				// update
				dbDao.modifyASAMst(upAsaMstVO);
				return asaMstVO;
			}

			// ===============================================
			// Processing OTS Table
			// ===============================================
			List<String> adjNoList = new ArrayList<String>();
			adjNoList.add(asaNo);
			adjBC.modifyOutstandingForAjust(adjNoList, "ADJUST");

			// ===========================================
			// create ASA OTS (Header, Detail, Charge, History)
			// ===========================================
			MDMOfficeInfoVO ofcInfo = stmtCommDao.searchMDMOfficeInfo(asaMstVO.getAgnCd());

			// ---------------------------------------------
			// SAR_OTS_HDR
			// ---------------------------------------------
			AROutstandingHdrVO otsHdrVO = new AROutstandingHdrVO();
			otsHdrVO.setRhqCd(ofcInfo.getArHdQtrOfcCd()); // RHQ CODE
			otsHdrVO.setOtsOfcCd(asaMstVO.getAgnCd()); // OUTSTANDING OFFICE
														// CODE
			otsHdrVO.setBlNo(asaMstVO.getAsaNo()); // B/L NUMBER

			if ("INV".equals(ofcInfo.getOtsSmryCd())) {
				otsHdrVO.setInvNo(asaMstVO.getAsaNo()); // Invoice NUMBER
			} else {
				otsHdrVO.setInvNo("**********"); // Invoice NUMBER
			}

			otsHdrVO.setOfcCurrCd(ofcInfo.getArCurrCd()); // OFFICE CURRENCY
															// CODE
			otsHdrVO.setOtsSrcCd("STM AR"); // OUTSTANDING SOURCE CODE
			otsHdrVO.setBilToCustCntCd(ofcInfo.getRepCustCntCd()); // BILL TO
																	// CUSTOMER
																	// COUNTRY
																	// CODE
			otsHdrVO.setBilToCustSeq(ofcInfo.getRepCustSeq()); // BILL TO
																// CUSTOMER
																// SEQUENCE
			otsHdrVO.setBkgNo(asaMstVO.getAsaNo()); // BOOKING NUMBER
			otsHdrVO.setBkgNoSplit(""); // BOOKING SPLIT NUMBER
			otsHdrVO.setVslCd("CNTC"); // VESSEL CODE
			otsHdrVO.setDirCd("M"); // DIRECTION CODE
			otsHdrVO.setTrnkVvdCd("CNTC" + asaMstVO.getAsaPrdToDt().substring(2, 6) + "M"); // TRUNK
																							// VVD
																							// CODE
			otsHdrVO.setSkdVoyNo(asaMstVO.getAsaPrdToDt().substring(2, 6));
			otsHdrVO.setSvcScpCd("OTH"); // SERVICE SCOPE CODE
			otsHdrVO.setLaneCd("CNT"); // LANE CODE
			otsHdrVO.setSailArrDt(asaMstVO.getAsaPrdToDt()); // SAILING ARRIVAL
																// DATE
			otsHdrVO.setBkgIoBndCd("O"); // BOOKING IN/OUT BOUND CODE
			otsHdrVO.setPorCd(ofcInfo.getLocCd()); // POR CODE
			otsHdrVO.setPolCd(ofcInfo.getLocCd()); // POL CODE
			otsHdrVO.setPodCd(ofcInfo.getLocCd()); // POD CODE
			otsHdrVO.setDelCd(ofcInfo.getLocCd()); // DEL CODE
			otsHdrVO.setCustSrepCd(""); // CUSTOMER SALES REPRESENTATIVE CODE
			if (StringUtils.isEmpty(ofcInfo.getAsaCrTermDys())) {
				otsHdrVO.setDueDt(SarUtil.addDays(asaMstVO.getAsaPrdToDt(), 0)); // DUE
																					// DATE
			} else {
				otsHdrVO.setDueDt(SarUtil.addDays(asaMstVO.getAsaPrdToDt(), Integer.valueOf(ofcInfo.getAsaCrTermDys()))); // DUE
																															// DATE
			}

			otsHdrVO.setStlFlg("N"); // SETTLEMENT FLAG
			otsHdrVO.setBkgRefNo(""); // BOOKING REFERENCE NUMBER
			otsHdrVO.setApArOffstNo(""); // A/P A/R OFFSET NUMBER
			otsHdrVO.setCrMkFlg("N"); // CREDIT MARK FLAG
			otsHdrVO.setXchRtTpCd("A"); // EXCHANGE RATE TYPE CODE
			otsHdrVO.setLstInvNo(""); // LAST INotsHdrVOICE NUMBER
			otsHdrVO.setOtsGrpTpCd(""); // OUTSTANDING GROUP TYPE CODE
			otsHdrVO.setOtsTpCd(""); // OUTSTANDING TYPE CODE
			otsHdrVO.setOtsRmk(""); // OUTSTANDING REMARK
			otsHdrVO.setIfDt(lclTime); // INTERFACE DATE
			otsHdrVO.setInvDt(""); // INotsHdrVOICE DATE
			//otsHdrVO.setCltOfcCd(ofcInfo.getArCtrlOfcCd()); // COLLECTION OFFICE
			// OTS_OFC_CD 랑 값은값 넣게 수정 2015.06.09 심수석님 요청 
			otsHdrVO.setCltOfcCd(asaMstVO.getAgnCd()); 
															// CODE
			otsHdrVO.setOtsRtFlg("Y"); // OUTSTANDING RATE FLAG
			otsHdrVO.setScNo(""); // S/C NUMBER

			// REVENUE SOURCE TYPE CODE
			RevAcctMatrixInfoCondVO acctCondVO = new RevAcctMatrixInfoCondVO();
			acctCondVO.setFAcctCtnt1("REC");
			acctCondVO.setFAcctCtnt2("STM AR");
			// acctCondVO.setFAcctCtnt3("AGENT");

			List<RevAcctMatrixInfoVO> acctVO = comDao.searchRevAcctMatrixInfo(acctCondVO);

			if (acctVO != null && !acctVO.isEmpty()) {
				otsHdrVO.setRevTpSrcCd(acctVO.get(0).getAcctTpCd()); // REVENUE
																		// SOURCE
																		// TYPE
																		// CODE
			} else {
				otsHdrVO.setRevTpSrcCd(""); // REVENUE SOURCE TYPE CODE
			}

			otsHdrVO.setShpToCustCntCd(ofcInfo.getRepCustCntCd()); // SHIP TO
																	// CUSTOMER
																	// COUNTRY
																	// CODE
			otsHdrVO.setShpToCustSeq(ofcInfo.getRepCustSeq()); // SHIP TO
																// CUSTOMER
																// SEQUENCE
			otsHdrVO.setXchRtN3rdTpCd("A"); // EXCHANGE RATE THIRD TYPE CODE
			otsHdrVO.setXchRtDt(asaMstVO.getAsaPrdToDt()); // EXCHANGE RATE DATE
			otsHdrVO.setCreUsrId(userId); // CREATE USER ID
			otsHdrVO.setCreDt(""); // CREATE DATE
			otsHdrVO.setUpdUsrId(userId); // UPDATE USER ID
			otsHdrVO.setUpdDt(""); // UPDATE DATE

			String maxArIfNo = "SAR" + lclTime.substring(2) + StringUtils.leftPad(comDao.getSequence("SAR_OTS_IF_NO_SEQ").toPlainString(), 4, "0");
			otsHdrVO.setMaxArIfNo(maxArIfNo); // MAX A/R INTERFACE NUMBER

			// ---------------------------------------------
			// Insert SAR_OTS_DTL (USD, Local Amount)
			// ---------------------------------------------
			List<AGnCltRfndUsdLclAmtSumVO> usdLclList = dbDao.searchAGnCltRfndUsdLclAmtSum(asaNo);
			List<AGnCltRfndN3rdAmtSumVO> n3rdList = dbDao.searchAGnCltRfndN3rdAmtSum(asaNo);

			if (!usdLclList.isEmpty()) {
				AGnCltRfndUsdLclAmtSumVO vo = usdLclList.get(0);

				// eqvLoclAmt:converted Local Amount(USD->Local)
				String eqvLoclAmt = vo.getEqvLoclAmt();
				if (!StringUtils.isEmpty(eqvLoclAmt) && !"0".equals(eqvLoclAmt)) {
					AGnCltRfndN3rdAmtSumVO n3rdVo = new AGnCltRfndN3rdAmtSumVO();
					n3rdVo.setN3rdCurrCd("USD");
					n3rdVo.setN3rdLoclAmt(eqvLoclAmt);
					n3rdList.add(n3rdVo);
				}

				// chgUsdAmt, lclAmt : local amount
				String chgUsdAmt = vo.getChgUsdAmt();
				if (!StringUtils.isEmpty(chgUsdAmt) && !"0".equals(chgUsdAmt)) {
					AGnCltRfndN3rdAmtSumVO n3rdVo = new AGnCltRfndN3rdAmtSumVO();
					n3rdVo.setN3rdCurrCd(asaMstVO.getCurrCd());
					n3rdVo.setN3rdLoclAmt(chgUsdAmt);
					n3rdList.add(n3rdVo);
				}

			}

			// loop all currency
			for (AGnCltRfndN3rdAmtSumVO n3rdVo : n3rdList) {

				// Get ASA Collect & Refund Sum Amount
				AROutstandingDtlVO otsDtlVO = new AROutstandingDtlVO();
				otsDtlVO.setRhqCd(otsHdrVO.getRhqCd()); // RHQ
				otsDtlVO.setOtsOfcCd(otsHdrVO.getOtsOfcCd()); // OUTSTANDING
																// OFFICE CODE
				otsDtlVO.setBlNo(otsHdrVO.getBlNo()); // B/L NUMBER
				otsDtlVO.setInvNo(otsHdrVO.getInvNo()); // INVOICE NUMBER
				otsDtlVO.setBlCurrCd(asaMstVO.getCurrCd()); // B/L CURRENCY CODE

				// convert amount by ASA currency
				String invAmt = n3rdVo.getN3rdLoclAmt();

				otsDtlVO.setInvAmt(invAmt); // INVOICE AMOUNT
				otsDtlVO.setInvUpdDt(lclTime); // INVOICE UPDATE DATE
				otsDtlVO.setRctAmt("0"); // RECEIPT AMOUNT
				otsDtlVO.setRctUpdDt(""); // RECEIPT UPDATE DATE
				otsDtlVO.setAdjAmt("0"); // ADJUST AMOUNT
				otsDtlVO.setAdjUpdDt(""); // ADJUST UPDATE DATE
				otsDtlVO.setBalAmt(invAmt); // BALANCE AMOUNT
				otsDtlVO.setBalUpdDt(lclTime); // BALANCE UPDATE DATE
				otsDtlVO.setWrtfAmt("0"); // WRITE-OFF AMOUNT
				otsDtlVO.setWrtfUpdDt(""); // WRITE-OFF UPDATE DATE
				otsDtlVO.setOfcCurrCd(otsHdrVO.getOfcCurrCd());// OFFICE
																// CURRENCY CODE

				// convert amount by office local currency
				String lclCurrCd = otsHdrVO.getOfcCurrCd();
				if (lclCurrCd.equals(asaMstVO.getCurrCd())) {
					otsDtlVO.setBalLoclAmt(n3rdVo.getN3rdLoclAmt()); // BALANCE
																		// LOCAL
																		// AMOUNT
					otsDtlVO.setLoclXchRt("1"); // LOCAL EXCHANGE RATE
				} else {
					BigDecimal[] lclXchAmt = getAcctXchAmt(n3rdVo.getN3rdLoclAmt() // from
																					// amount
							, asaMstVO.getCurrCd() // from currency
							, lclCurrCd // to currency
							, otsHdrVO.getXchRtDt() // exchange date
					);

					otsDtlVO.setBalLoclAmt(lclXchAmt[0].toPlainString()); // BALANCE
																			// LOCAL
																			// AMOUNT
					otsDtlVO.setLoclXchRt(lclXchAmt[1].toPlainString()); // LOCAL
																			// EXCHANGE
																			// RATE

				}

				// convert amount by "USD"
				if ("USD".equals(asaMstVO.getCurrCd())) {
					otsDtlVO.setBalUsdAmt(n3rdVo.getN3rdLoclAmt()); // BALANCE
																	// USD
																	// AMOUNT
					otsDtlVO.setUsdXchRt("1"); // USD EXCHANGE RATE
				} else {
					BigDecimal[] usdXchAmt = getAcctXchAmt(n3rdVo.getN3rdLoclAmt() // from
																					// amount
							, asaMstVO.getCurrCd() // from currency
							, "USD" // to currency
							, otsHdrVO.getXchRtDt() // exchange date
					);

					otsDtlVO.setBalUsdAmt(usdXchAmt[0].toPlainString()); // BALANCE
																			// LOCAL
																			// AMOUNT
					otsDtlVO.setUsdXchRt(usdXchAmt[1].toPlainString()); // LOCAL
																		// EXCHANGE
																		// RATE
				}

				otsDtlVO.setCreUsrId(userId); // CREATE USER ID
				otsDtlVO.setCreDt(""); // CREATE DATE
				otsDtlVO.setUpdUsrId(userId); // UPDATE USER ID
				otsDtlVO.setUpdDt(""); // UPDATE DATE

				if (asaMstVO.getCurrCd().equals(n3rdVo.getN3rdCurrCd())) {
					otsDtlVO.setChgTpCd("AGT"); // CHARGE TYPE CODE
				} else {
					otsDtlVO.setChgTpCd("AGC"); // CHARGE TYPE CODE
				}

				// otsDtlVO.setArEmlSeq(""); //A/R EMAIL SEQUENCE
				List<AROutstandingDtlVO> otsDtlList = new ArrayList<AROutstandingDtlVO>();
				otsDtlList.add(otsDtlVO);

				// ---------------------------------------------
				// Insert SAR_OTS_HIS
				// ---------------------------------------------
				SarOtsHisVO otsHisVO = new SarOtsHisVO();

				String otsHisSeq = otsDao.searchOutstandingHistSeq();

				otsHisVO.setOtsHisSeq(otsHisSeq); // OUTSTANDING HISTORY
													// SEQUENCE
				otsHisVO.setIfNo(otsHdrVO.getMaxArIfNo()); // INTERFACE NUMBER
				otsHisVO.setRhqCd(otsHdrVO.getRhqCd()); // RHQ CODE
				otsHisVO.setOtsOfcCd(otsHdrVO.getOtsOfcCd()); // OUTSTANDING
																// OFFICE CODE
				otsHisVO.setBlNo(otsHdrVO.getBlNo()); // B/L NUMBER
				otsHisVO.setInvNo(otsHdrVO.getInvNo()); // INVOICE NUMBER
				otsHisVO.setCurrCd(otsDtlVO.getBlCurrCd()); // CURRENCY CODE
				otsHisVO.setOtsHisTpCd("OTS"); // OUTSTANDING HISTORY TYPE CODE
				otsHisVO.setOtsSrcCd(otsHdrVO.getOtsSrcCd()); // OUTSTANDING
																// SOURCE CODE
				otsHisVO.setIfDt(lclTime); // INTERFACE DATE
				otsHisVO.setGlDt(asaMstVO.getAsaPrdToDt()); // G/L DATE
				otsHisVO.setOtsAmt(otsDtlVO.getBalAmt()); // OUTSTANDING AMOUNT
				otsHisVO.setUsdAmt(otsDtlVO.getBalUsdAmt()); // USD AMOUNT
				otsHisVO.setRefNo(otsHdrVO.getMaxArIfNo()); // REFERENCE NUMBER
				otsHisVO.setInvOfcCd(otsDtlVO.getOtsOfcCd()); // INVOICE OFFICE
																// CODE
				otsHisVO.setOtsRmk(""); // OUTSTANDING REMARK
				otsHisVO.setShpToCustCntCd(otsHdrVO.getShpToCustCntCd()); // SHIP
																			// TO
																			// CUSTOMER
																			// COUNTRY
																			// CODE
				otsHisVO.setShpToCustSeq(otsHdrVO.getShpToCustSeq()); // SHIP TO
																		// CUSTOMER
																		// SEQUENCE
				otsHisVO.setBilToCustCntCd(otsHdrVO.getBilToCustCntCd()); // BILL
																			// TO
																			// CUSTOMER
																			// COUNTRY
																			// CODE
				otsHisVO.setBilToCustSeq(otsHdrVO.getBilToCustSeq()); // BILL TO
																		// CUSTOMER
																		// SEQUENCE
				otsHisVO.setVslCd(otsHdrVO.getVslCd()); // VESSEL CODE
				otsHisVO.setSkdVoyNo(otsHdrVO.getSkdVoyNo()); // SCHEDULE VOYAGE
																// NUMBER
				otsHisVO.setDirCd(otsHdrVO.getDirCd()); // DIRECTION CODE
				//otsHisVO.setSvcScpCd(otsHdrVO.getSvcScpCd()); // SERVICE SCOPE
				otsHisVO.setSvcScpCd("OTH"); // SERVICE SCOPE
																// CODE
				otsHisVO.setXchRtTpCd(otsHdrVO.getXchRtTpCd()); // EXCHANGE RATE
																// TYPE CODE
				otsHisVO.setLoclXchRt(otsDtlVO.getLoclXchRt()); // LOCAL
																// EXCHANGE RATE
				otsHisVO.setUsdXchRt(otsDtlVO.getUsdXchRt()); // USD EXCHANGE
																// RATE
				otsHisVO.setBkgIoBndCd(otsHdrVO.getBkgIoBndCd()); // BOOKING
																	// IN/OUT
																	// BOUND
																	// CODE
				otsHisVO.setXchRtDt(otsHdrVO.getXchRtDt()); // EXCHANGE RATE
															// DATE
				otsHisVO.setPolCd(otsHdrVO.getPolCd()); // POL CODE
				otsHisVO.setPodCd(otsHdrVO.getPodCd()); // POD CODE
				otsHisVO.setCreUsrId(userId); // CREATE USER ID
				otsHisVO.setCreDt(""); // CREATE DATE
				otsHisVO.setUpdUsrId(userId); // UPDATE USER ID
				otsHisVO.setUpdDt(""); // UPDATE DATE

				otsHisVO.setRevTpSrcCd(otsHdrVO.getRevTpSrcCd()); // REVENUE
																	// SOURCE
																	// TYPE CODE

				otsHisVO.setRevVvdCd("CNTC" + asaMstVO.getAsaPrdToDt().substring(2, 6) + "MM"); // REVENUE
																								// VVD
																								// CODE
				// add
				adjDao.addSarOtsHis(otsHisVO);

				// ---------------------------------------------
				// Insert SAR_OTS_CHG
				// ---------------------------------------------
				List<AROutstandingChgVO> otsChgList = new ArrayList<AROutstandingChgVO>();
				AROutstandingChgVO otsChgVO = new AROutstandingChgVO();
				otsChgVO.setRhqCd(otsHdrVO.getRhqCd()); // RHQ CODE
				otsChgVO.setOtsOfcCd(otsHdrVO.getOtsOfcCd()); // OUTSTANDING
																// OFFICE CODE
				otsChgVO.setBlNo(otsHdrVO.getBlNo()); // B/L NUMBER
				otsChgVO.setInvNo(otsHdrVO.getInvNo()); // INVOICE NUMBER
				otsChgVO.setBlCurrCd(otsDtlVO.getBlCurrCd()); // B/L CURRENCY
																// CODE
				otsChgVO.setChgTpCd(otsDtlVO.getChgTpCd()); // CHARGE TYPE CODE
				otsChgVO.setBalAmt(otsDtlVO.getBalAmt()); // BALANCE AMOUNT
				otsChgVO.setCreUsrId(userId); // CREATE USER ID
				otsChgVO.setCreDt(""); // CREATE DATE
				otsChgVO.setUpdUsrId(userId); // UPDATE USER ID
				otsChgVO.setUpdDt(""); // UPDATE DATE
				otsChgVO.setIfNo(otsHisVO.getIfNo()); // INTERFACE NUMBER
				otsChgVO.setInvAmt(otsDtlVO.getInvAmt()); // INVOICE AMOUNT
				otsChgVO.setTjSrcNm("AGENT"); // TRANSACTION SOURCE NAME
				otsChgVO.setGlDt(otsHisVO.getGlDt()); // G/L DATE
				otsChgVO.setOtsHisSeq(otsHisVO.getOtsHisSeq()); // OUTSTANDING
																// HISTORY
																// SEQUENCE
				otsChgVO.setOrgBlCurrCd(n3rdVo.getN3rdCurrCd());
				// add
				otsChgList.add(otsChgVO);
				// insert
				otsDao.addOutstandingCharge(otsChgList);

				// Check duplicate OTS Header
				AROutstandingCheckVO chkOts = new AROutstandingCheckVO();
				chkOts.setRhqCd(otsHdrVO.getRhqCd());
				chkOts.setOtsOfcCd(otsHdrVO.getOtsOfcCd());
				chkOts.setBlNo(otsHdrVO.getBlNo());
				chkOts.setInvNo(otsHdrVO.getInvNo());

				// ---------------------------------
				// add SAR_OTS_DTL
				// ---------------------------------
				// check detail pk
				chkOts.setBlCurrCd(otsDtlVO.getBlCurrCd());
				chkOts.setChgTpCd(otsDtlVO.getChgTpCd());
				if (otsDao.checkOutstandingDetail(chkOts)) {
					otsDao.modifyOutstandingDetail(otsDtlList); // update
				} else {
					otsDao.addOutstandingDetail(otsDtlList); // insert
				}

				// ---------------------------------
				// ADD Header
				// ---------------------------------
				if (otsDao.checkOutstandingHeader(chkOts)) {
					otsDao.modifyOutstandingHeader(otsHdrVO);// update
				} else {
					otsDao.addOutstandingHeader(otsHdrVO);// insert
				}

				// ===========================================
				// INSERT SAR DISTRIBUTION TABLE(SAR_OTS_DTRB)
				// ===========================================
				List<AROutstandingHistVO> otsHisList = new ArrayList<AROutstandingHistVO>();

				AROutstandingHistVO arOtsHisVO = new AROutstandingHistVO();
				SarUtil.copyBeanProperties(otsHisVO, arOtsHisVO);
				// add
				otsHisList.add(arOtsHisVO);
				// insert
				otsBC.createOutstandingAccount(otsHisList, otsChgList);

			}

			// ===========================================
			// update ASA Master
			// ===========================================
			// update ASA status
			SarAsaMstVO upAsaMstVO = new SarAsaMstVO();
			upAsaMstVO.setAsaNo(asaNo);
			upAsaMstVO.setAsaAproUsrId(userId);
			upAsaMstVO.setUpdUsrId(userId);
			upAsaMstVO.setAsaStsCd("A"); // Aprove:A
			upAsaMstVO.setAsaAproDt(lclTimeYmd);
			// update

			dbDao.modifyASAMst(upAsaMstVO);

			return asaMstVO;
		
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}

	/**
	 * get Account exchange rate and amount
	 * 
	 * @param String fromAmt
	 * @param String fromCurrCd
	 * @param String toCurrcd
	 * @param String xchRtDt
	 * @return BigDecimal[]
	 * @throws EventException
	 */
	private BigDecimal[] getAcctXchAmt(String fromAmt, String fromCurrCd, String toCurrcd, String xchRtDt) throws EventException {

		AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();

		// Account Exchange Rate
		ARExrateVO arExrateVO = new ARExrateVO();
		arExrateVO.setRvsFlg("N");
		arExrateVO.setLclCurrCd(toCurrcd);// to
		arExrateVO.setChgCurrCd(fromCurrCd);// from
		arExrateVO.setXchRtDt(xchRtDt);

		String toXchRt = commonBC.searchAccountExrate(arExrateVO);

		if (StringUtils.isEmpty(toXchRt)) {
			toXchRt = "0";
		}

		String dpPrcsKnt = "2";
		List<CurrencyCodeVO> currList = commonBC.searchCurrencyCode(toCurrcd);
		if (currList != null && !currList.isEmpty()) {
			dpPrcsKnt = currList.get(0).getDpPrcsKnt();
		}

		BigDecimal accXchRt = new BigDecimal(toXchRt);
		BigDecimal toAmt = new BigDecimal(fromAmt);
		toAmt = toAmt.multiply(accXchRt).setScale(Integer.parseInt(dpPrcsKnt), BigDecimal.ROUND_HALF_UP);

		return new BigDecimal[] { toAmt, accXchRt };
	}

	/**
	 * true : "total OTS Amount" - "ASA total amount" < office ots limit amount
	 * 
	 * @author jinyoonoh 2014. 5. 12.
	 * @param String asaNo
	 * @return boolean
	 * @throws EventException
	 */
	@Override
	public boolean checkUnreportedAmount(String asaNo) throws EventException {

		try {

			// get ASA Master --------------------------------------
			SarAsaMstVO asaMstParamVO = new SarAsaMstVO();
			asaMstParamVO.setAsaNo(asaNo);
			SarAsaMstVO asaMstVO = dbDao.searchASAMst(asaMstParamVO);

			// not open ASA
			if (asaMstVO == null || !"O".equals(asaMstVO.getAsaStsCd())) {
				return false;
			}
			//Unreported OTS Limit Flag
			if("Y".equals( dbDao.searchUnreportedFlag(asaNo))) {
				return true;
			}

			String asaPrdToDt = asaMstVO.getAsaPrdToDt();
			String ofcCd = asaMstVO.getOfcCd();
			// total OTS Amount
			BigDecimal otsAmtTtl = dbDao.searchAcutalOTSAmtByOffcd(asaNo, asaPrdToDt, ofcCd);
			// ASA total amount
			BigDecimal asaAmtTtl = dbDao.searchAsaUsdTtlAmt(asaNo, asaPrdToDt);

			// office ots limit amount
			AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();

			StmOfcInfoVO ofcInfo = commonBC.searchStmOfcInfo(asaMstVO.getAgnCd());

			String agnOtsLmtAmt = ofcInfo.getAgnOtsLmtAmt();
			BigDecimal otsLmtAmt = null;
			if (StringUtils.isEmpty(agnOtsLmtAmt)) {
				otsLmtAmt = new BigDecimal("0");
			} else {
				otsLmtAmt = new BigDecimal(agnOtsLmtAmt);
			}

			if (otsAmtTtl.subtract(asaAmtTtl).compareTo(otsLmtAmt) <= 0) {
				return true;
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return false;
	}

	/**
	 * STM_SAR_5002 : checkASAperiod Agent Statement of Account Entry check
	 * period<br>
	 * 
	 * @author myoungsin park
	 * @param ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO
	 * @return CheckASAperiodVO
	 * @exception EventException
	 */
	@Override
	public CheckASAperiodVO searchASAperiod(ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO) throws EventException {
		try {
			CheckASAperiodVO checkASAperiodVO = dbDao.searchASAperiod(aSAInfoByOfcAgnVO);

			return checkASAperiodVO;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}

	/**
	 * STM_SAR_5002 : checkASAperiod Agent Statement of Account Entry check pre
	 * asa status<br>
	 * 
	 * @author myoungsin park
	 * @param ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO
	 * @return CheckPreASAStausVO
	 * @exception EventException
	 */
	@Override
	public CheckPreASAStausVO checkPreASAStatus(ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO) throws EventException {
		try {
			CheckPreASAStausVO checkPreASAStausVO = dbDao.searchPreASAStatus(aSAInfoByOfcAgnVO);
			return checkPreASAStausVO;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}

	/**
	 * approve ASA 대리점 Collect & Refund를 조정후 하나의 ASA No.로 OTS를 생성한다. Collect &
	 * Refund and one representative of the adjusted ASA No. OTS is created.
	 * 
	 * @param String batSeq
	 * @return String
	 * @throws EventException
	 */
	@Override
	public String approveASABat(String batSeq) throws EventException {
		try {
			ScheduleUtil su = new ScheduleUtil();
			log.error("ASA Approval Batch Sequence(Before ExecuteJob):"+batSeq+"\n");
			su.directExecuteJob("STM_SAR_B5002", batSeq);
			log.error("ASA Approval Batch Sequence(After ExecuteJob):"+batSeq+"\n");
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213", new String[] { "approve ASA Batch" }).getMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12213", new String[] { "approve ASA Batch" }).getMessage(), e);
		}
		return batSeq;
	}

	/**
	 * check batch status
	 * R: Running
	 * S: Start
	 * 
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public String searchBatStsCd(String pgmNo) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
		boolean isRunningStatus = false;
		
		try {
			isRunningStatus = su.isRunning(pgmNo);			
			log.error("ASA Approval Batch Running:::"+isRunningStatus+"\n");
			
			if(isRunningStatus){
				return "R"; // Running
			}else{
				return "S"; // Start 
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * batch 가 running 상태일 경우, E로 update
	 * 
	 * @param batSeq
	 * @param account
	 * @throws EventException
	 */
	public void manageCancelASABat(String batSeq, SignOnUserAccount account) throws EventException {
		try {
			
			dbDao.manageCancelASABat(batSeq); // 'E'로 update
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SCO_BAT_HIS 테이블에 데이타를 생성한다.
	 * 
	 * @author myoungsin park
	 * @param String asaNo
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	@Override
	public String createApproveASABat(String asaNo, SignOnUserAccount account) throws EventException {
		String batSeq = "";
		try {
			BatHisVO batHisVO = new BatHisVO();
			SarAsaMstVO asaMstParamVO = new SarAsaMstVO();
			asaMstParamVO.setAsaNo(asaNo);
			SarAsaMstVO asaMstVO = dbDao.searchASAMst(asaMstParamVO);
			// not finish ASA
			if (asaMstVO == null || !"F".equals(asaMstVO.getAsaStsCd())) {
				batHisVO.setBatRsltCd("E");
				batHisVO.setBatRsltDesc("not finish ASA");
			} else {
				batHisVO.setBatRsltCd("W");
			}

			batSeq = dbDao.searchBatHisSeqData();
			String params = "";
			params = asaNo + "#" + account.getUsr_id() + "#" + account.getOfc_cd();

			batHisVO.setBatSeq(batSeq);
			batHisVO.setPgmSubSysCd("SAR");
			batHisVO.setBatPgmNo("STM_SAR_B5002");
			batHisVO.setApplPgmNo("STM_SAR_5002");
			batHisVO.setBatParaCtnt(params);
			batHisVO.setCreUsrId(account.getUsr_id());
			batHisVO.setUpdUsrId(account.getUsr_id());
			dbDao.addBatHis(batHisVO);
			if (batHisVO.getBatRsltCd().equals("E")) {
				batSeq = "";
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
		return batSeq;
	}

	/**
	 * STM_SAR_5002 : searchBatHisStatus
	 * 
	 * @author myoungsin park
	 * @param String batSeq
	 * @return BatHisVO
	 * @exception EventException
	 */
	@Override
	public BatHisVO searchBatHisStatus(String batSeq) throws EventException {
		try {
			BatHisVO batHisVO = dbDao.searchBatHisStatus(batSeq);
			return batHisVO;
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage());
		}
	}
	
	/**
	 * [STM_SAR_500] Agent Statement of Account Entry
	 * searchASAApprovalCheck<br> 
	 * @author JBLEE
	 * @param String asaNo
	 * @return String
	 * @exception DAOException
     */ 
    public String searchASAApprovalCheck(String asaNo) throws EventException {
    	try {
    		return dbDao.searchASAApprovalCheck(asaNo);
    	} catch (DAOException e) {
    		log.error("err " + e.toString(), e);
    		throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
    	}
    }

    /**
	 * [STM_SAR_5002]
	 * Search duplicated collection/refund B/L list <br>
	 *
	 * @author SYPARK
	 * @param String asaNo
	 * @return String
	 * @exception EventException
	 */
	public String searchDuplicateColRfnd(String asaNo) throws EventException {
		try {
			return dbDao.searchDuplicateColRfnd(asaNo);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * Agent Collection Temp Insert<br>
	 * 
	 * @author Myoung Sin Park
	 * @category addAgentCollectionTempListBasic
	 * @param List<AgentCollectionListVO> agentCollectionListVOs
	 * @throws EventException
	 */
	public void addAgentCollectionTempListBasic(List<AgentCollectionListVO> agentCollectionListVOs) throws EventException {
		try {
				dbDao.addAgentCollectionTempList(agentCollectionListVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * [STM_SAR_5002] ASA Master Modify<br>
	 * 
	 * @author KIMOKRYE
	 * @category Agent Statement of Account Entry
	 * @param SarAsaMstVO paramVO
	 * @throws EventException
	 */
	public void modifyASAMst (SarAsaMstVO paramVO) throws EventException {
		try {
				dbDao.modifyASAMst(paramVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
}