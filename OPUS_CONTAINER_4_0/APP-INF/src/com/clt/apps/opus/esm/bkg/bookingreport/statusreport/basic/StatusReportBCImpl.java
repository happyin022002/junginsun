/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : StatusReportBCImpl.java
 *@FileTitle : StatusReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration.StatusReportDBDAO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration.StatusReportEAIDAO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByBLVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListinVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListinVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListoutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgClearanceCrossCheckListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListByBLVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListinVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlCntrInfoReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlStsReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BokCntrListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BokCntrListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CllCdlVslSumForRDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CmBkgRptVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CustVipReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CustVipReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.LoadingConfirmationinVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsTPSZSumListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsYardSumListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.SearchTradeListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportSpecialCargoOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportSummaryOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmDashboardVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmEdiSupVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmHistoryVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * -BookingReport Business Logic Basic Command implementation<br>
 * - BookingReport business logic handling<br>
 * 
 * @author
 * @see StatusReportEventResponse,StatusReportBC each DAO Class reference
 * @since J2EE 1.6
 */
public class StatusReportBCImpl extends BasicCommandSupport implements StatusReportBC {

	// Database Access Object
	private transient StatusReportDBDAO dbDao = null;

	/**
	 * StatusReportBCImpl object creation<br>
	 * StatusReportDBDAO creation<br>
	 */
	public StatusReportBCImpl() {
		dbDao = new StatusReportDBDAO();
	}

	/**
	 * BDR Status Inquiry information retrieve
	 * @param SearchBDRBookingStatusListVO searchBDRBookingStatusListVO
	 * @return List<SearchBDRBookingStatusListVO>
	 * @exception EventException
	 */
	public List<SearchBDRBookingStatusListVO> searchBDRBookingStatusList(SearchBDRBookingStatusListVO searchBDRBookingStatusListVO) throws EventException {
		try {
			return dbDao.searchBDRBookingStatusList(searchBDRBookingStatusListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * getting retrieve time
	 * @param BDRBookingStatusListVO vo
	 * @return List<SearchInternetUserAuthVO>
	 * @exception EventException
	 */
	public List<SearchBDRBookingStatusListVO> getRuntime() throws EventException {
		try {
			return dbDao.getRuntime();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * B/L Data insert end confirm report function
	 * @param BkgClearanceCrossCheckListInVO bkgClearanceCrossCheckListInVO
	 * @return List<BkgClearanceCrossCheckListInVO>
	 * @exception EventException
	 */
	public List<BkgClearanceCrossCheckListInVO> bkgClearanceCrossCheckList(BkgClearanceCrossCheckListInVO bkgClearanceCrossCheckListInVO) throws EventException {
		try {
			return dbDao.bkgClearanceCrossCheckList(bkgClearanceCrossCheckListInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Container List on Stowage & B/L<BR>
	 * ESM_BKG_0162<BR>
	 * showing result of Cross check at Bay-Plan and Booking Data
	 * @param CntrStowageintVO vo
	 * @return List<CntrStowageintVO>
	 * @exception EventException
	 */
	public List<CntrStowageintVO> searchContainerStowageList(CntrStowageintVO vo) throws EventException {
		try {
			return dbDao.searchContainerStowageList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	
	/**
	 * Outbound Container Movement Status<br>
	 * Outbound Container Movement Status by Yard Report(ESM_BKG_0619)<BR>
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsYardSumListOutVO>
	 * @throws EventException
	 */
	public List<OutBdMovementStsYardSumListOutVO> searchOutBdMovementByYardSum(OutBdMovementStsListInVO vo) throws EventException {
		try {
			return dbDao.searchOutBdMovementByYardSum(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Outbound Container Movement Status(ESM_BKG_0619)<br>
	 * Outbound Container Movement Status by Type/Size Report(ESM_BKG_0619)<br>
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsTPSZSumListOutVO>
	 * @throws EventException
	 */
	public List<OutBdMovementStsTPSZSumListOutVO> searchOutBdMovementByTPSZSum(OutBdMovementStsListInVO vo) throws EventException {
		try {
			return dbDao.searchOutBdMovementByTPSZSum(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * sending Container Loading Confirmation mail to customer
	 * @param LoadingConfirmationinVO vo
	 * @param LoadingConfirmationinVO[] vos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendEmailByBkgNoList(LoadingConfirmationinVO vo, LoadingConfirmationinVO[] vos, SignOnUserAccount account) throws EventException {
		StatusReportEAIDAO eaiDao = new StatusReportEAIDAO();
		String sendId = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		
		String subTitle = "";
		String rdParam = "";
		ComUserVO comUserVO = null;
		try {

			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = "";
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();

			/* Email transmission */
			for (int k = 0; k < vos.length; k++) {
				List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				if (vos[k].getRcheck().equals("1")){
				Mail mail = new Mail();
//				mail.setFrom(account.getUsr_eml(),account.getUsr_nm());
				mail.setFrom(sUsrEml,account.getUsr_nm());
				
				subTitle = "Loading Confirmation : " + vos[k].getBkgNo() + " / " + vos[k].getVvdCd();
				
				mail.setSubject(subTitle); 
				mail.setRecipient(vos[k].getCntcPsonEml());
				mail.setTextContent("");
				mail.setRdSubSysCd("BKG");
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
				comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setRdTmpltNm("ESM_BKG_0806.mrd");
				comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				comRptDsgnXptInfoVO.setXptFileNm("@Loading Confirmation_"+vos[k].getBkgNo()+"+"+vos[k].getVvdCd()+".pdf");
				
				rdParam = "/rp [('" + vos[k].getBkgNo() + "')]" + "[('" + vos[k].getCntrNo() + "')]" + "[('" + vos[k].getBkgCustTpCd() + "')]" + "['" + vo.getLanguage() + "']" + "['"
					+ vo.getMphnNo() + "']" + "['" + vo.getFaxNo() + "']" + "['" + vo.getSndDt() + "']" + "['" + account.getUsr_id() + "']" + "['" + account.getOfc_cd() + "']" + "['" + vos[k].getCnmvStsCd() + "']";
				comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				// Send Mail
				sendId = eaiDao.sendRDEmail(mail);
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(vos[k].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); // F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("LC"); // PN : US PICKUP NOTICE
				bkgNtcHisVO.setCntrNo(vos[k].getCntrNo());
				// bkgNtcHisVO.setAgnCd("");
				bkgNtcHisVO.setNtcFomCd("");
				bkgNtcHisVO.setNtcSeq(String.valueOf(k));
				bkgNtcHisVO.setCustCntcTpCd(vos[k].getBkgCustTpCd());
				bkgNtcHisVO.setNtcFaxNo(vos[k].getCntcPsonFaxNo());
				bkgNtcHisVO.setNtcEml(vos[k].getCntcPsonEml());
				// bkgNtcHisVO.setEdiId("");
				// bkgNtcHisVO.setEsvcGrpCd("");
				// bkgNtcHisVO.setBkgNtcSndRsltCd("");
				// bkgNtcHisVO.setTmlNtcSndStsCd("");
				// bkgNtcHisVO.setCgorRcvrTpCd("");
				// bkgNtcHisVO.setCgorStsCd("");
				// bkgNtcHisVO.setFrtHdnFlg("");
				// bkgNtcHisVO.setFrtAllFlg("");
				// bkgNtcHisVO.setFrtCltFlg("");
				// bkgNtcHisVO.setFrtPpdFlg("");
				// bkgNtcHisVO.setFrtChgFlg("");
				// bkgNtcHisVO.setFrtArrFlg("");
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt(format.format(now));
				bkgNtcHisVO.setDiffRmk("");
				// bkgNtcHisVO.setCustCntcAmdFlg("");
				// bkgNtcHisVO.setDpHdnFlg("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());

				
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVOs.add(bkgNtcHisVO);

				/***********************************************************************/
				/*
				 * if (bkgNtcHisVOs.size() == 0 || checkDupRecever(bkgNtcHisVOs,mailInfo.getReceiverEmail())== false){
				 * 
				 * // Send Mail sendId = eaiDao.sendRDEmail(mailInfo); bkgNtcHisVOs.add(bkgNtcHisVO); }
				 */
				/***********************************************************************/
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return bkgNtcHisVOs;
	}

	/**
	 * sending Container Loading Confirmation fax to customer
	 * @param LoadingConfirmationinVO vo
	 * @param LoadingConfirmationinVO[] vos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendFaxByBkgNoList(LoadingConfirmationinVO vo, LoadingConfirmationinVO[] vos, SignOnUserAccount account) throws EventException {
		FaxMetaInfo faxInfo = null;
		StatusReportEAIDAO eaiDao = new StatusReportEAIDAO();
		String sendId = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		try {

			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String subTitle = "";
			String rdParam = "";
			String rcvInfoCtnt = "";
			/* FAX transmission */
			for (int k = 0; k < vos.length; k++) {
				if (vos[k].getRcheck().equals("1")){
				faxInfo = new FaxMetaInfo();
				faxInfo.setRdSubSysCd("BKG");
				faxInfo.setTmplMrd("ESM_BKG_0806.mrd");
				faxInfo.setBatFlg("N");

				
				subTitle = "Loading Confirmation : " + vo.getBkgNo() + " / " + vo.getVvdCd();
				faxInfo.setEmlTitNm(subTitle);
				rdParam = "/rp [('" + vos[k].getBkgNo() + "')]" + "[('" + vos[k].getCntrNo() + "')]" + "[('" + vos[k].getBkgCustTpCd() + "')]" + "['" + vo.getLanguage() + "']" + "['"
						+ vo.getMphnNo() + "']" + "['" + vo.getFaxNo() + "']" + "['" + vo.getSndDt() + "']" + "['" + account.getUsr_id() + "']" + "['" + account.getOfc_cd() + "']" + "['" + vos[k].getCnmvStsCd() + "']";

				faxInfo.setParaInfoCtnt(rdParam);

				// faxInfo.setParaInfoCtnt(vo.getRdParam());
				rcvInfoCtnt = vos[k].getBkgCPerson() + ";" + vos[k].getCntcPsonFaxNo();
				faxInfo.setRcvrInfoCtnt(rcvInfoCtnt);
				faxInfo.setOfcCd(vos[k].getBkgOfcCd());
				faxInfo.setCreUsrId(account.getUsr_id());

				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(vos[k].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("F"); // F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("LC"); // PN : 미주 PICKUP NOTICE
				bkgNtcHisVO.setCntrNo(vos[k].getCntrNo());
				// bkgNtcHisVO.setAgnCd("");
				bkgNtcHisVO.setNtcFomCd("");
				bkgNtcHisVO.setNtcSeq("");
				bkgNtcHisVO.setCustCntcTpCd(vos[k].getBkgCustTpCd());
				bkgNtcHisVO.setNtcFaxNo(vos[k].getCntcPsonFaxNo());
				bkgNtcHisVO.setNtcEml(vos[k].getCntcPsonEml());
				
				// bkgNtcHisVO.setEdiId("");
				// bkgNtcHisVO.setEsvcGrpCd("");
				// bkgNtcHisVO.setBkgNtcSndRsltCd("");
				// bkgNtcHisVO.setTmlNtcSndStsCd("");
				// bkgNtcHisVO.setCgorRcvrTpCd("");
				// bkgNtcHisVO.setCgorStsCd("");
				// bkgNtcHisVO.setFrtHdnFlg("");
				// bkgNtcHisVO.setFrtAllFlg("");
				// bkgNtcHisVO.setFrtCltFlg("");
				// bkgNtcHisVO.setFrtPpdFlg("");
				// bkgNtcHisVO.setFrtChgFlg("");
				// bkgNtcHisVO.setFrtArrFlg("");
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt(format.format(now));
				bkgNtcHisVO.setDiffRmk("");
				// bkgNtcHisVO.setCustCntcAmdFlg("");
				// bkgNtcHisVO.setDpHdnFlg("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());

				bkgNtcHisVO.setNtcSeq("0");
				// Send FAX
				sendId = eaiDao.sendFax(faxInfo);
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVOs.add(bkgNtcHisVO);

				/***********************************************************************/
				/*
				 * if (bkgNtcHisVOs.size() == 0 || checkDupRecever(bkgNtcHisVOs,faxInfo.getRcvrInfoCtnt())== false){ // Send FAX sendId = eaiDao.sendFax(faxInfo);
				 * 
				 * bkgNtcHisVOs.add(bkgNtcHisVO); }
				 */
				/***********************************************************************/
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return bkgNtcHisVOs;
	}

	/**
	 * checking validation in case of sending Container Loading Confirmation mail and fax to customer
	 * @param List<BkgNtcHisVO> bkgNtcHisVOs
	 * @param String key
	 * @return boolean
	 * @throws Exception
	 */
	public boolean checkDupReceiver(List<BkgNtcHisVO> bkgNtcHisVOs, String key) throws Exception {
		BkgNtcHisVO bkgNtcHisVO = null;

		for (int i = 0; i < bkgNtcHisVOs.size(); i++) {
			bkgNtcHisVO = bkgNtcHisVOs.get(i);

			if (bkgNtcHisVO.getNtcViaCd().equals("M")) {
				if (bkgNtcHisVO.getNtcEml().equals(key)) {
					return true;
				}
			} else if (bkgNtcHisVO.getNtcViaCd().equals("F")) {
				if ((bkgNtcHisVO.getNtcEml()).equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 0103 Booking Status Report information retrieve<br>
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportOutVO>
	 * @throws EventException
	 */
	public List<StatusReportOutVO> searchBLStatusList(StatusReportInVO statusReportInVO) throws EventException {
		try {
			return dbDao.searchBLStatusList(statusReportInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieve BKG OFC SUB information for Booking Status Report information
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportOutVO>
	 * @throws EventException
	 */
	public String searchBLStatusList2(StatusReportInVO statusReportInVO)  throws EventException {
		try {
			return dbDao.searchBLStatusList2(statusReportInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 0103 Booking Status Report SpecialCargo information retrieve<br>
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportSpecialCargoOutVO>
	 * @throws EventException
	 */
	public List<StatusReportSpecialCargoOutVO> searchBLStatusListSpecialCargo(StatusReportInVO statusReportInVO)  throws EventException {
		try {
			return dbDao.searchBLStatusListSpecialCargo(statusReportInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0103 Booking Status Report Summary information retrieve<br>
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportSummaryOutVO>
	 * @throws EventException
	 */
	public List<StatusReportSummaryOutVO> searchBLStatusListSummary(StatusReportInVO statusReportInVO)   throws EventException {
		try {
			return dbDao.searchBLStatusListSummary(statusReportInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * BDR Booking No Status - Inquiry(ESM_BKG_0727)<BR>
	 * @param BdrBookingNoListVO vo
	 * @return List<BdrBookingNoListVO>
	 * @throws EventException
	 */
	public List<BdrBookingNoListVO> searchBDRBookingNoList(BdrBookingNoListVO vo) throws EventException {
		try {
			return dbDao.searchBDRBookingNoList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}

	/**
	 * C/M Data Cross-Check List (Master BL/Houser BL) retrieve.<br>
	 * @param BkgCMCroChkListinVO vo
	 * @return List<BkgCMCroChkListByBLVO>
	 * @throws EventException
	 */
	public List<BkgCMCroChkListByBLVO> searchCMCrossCheckList(BkgCMCroChkListinVO vo) throws EventException {

		try {
			return dbDao.searchCMCrossCheckList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * C/M Print by VVD (CM,FAX) retrieve<br>
	 * @param BkgCMPrintListinVO vo
	 * @return List<BkgCMPrintListoutVO>
	 * @throws EventException
	 */
	public List<BkgCMPrintListoutVO> searchCMPrintList(BkgCMPrintListinVO vo) throws EventException {

		try {

			if (vo.getTabTp().equals("0")) {

				return dbDao.searchCMPrintList(vo);
			} else {

				return dbDao.searchFaxPrintList(vo);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * B/L Status Report(0647) information retrieve<br>
	 * @param BlStsReportInVO blStsReportInVO
	 * @return List<BlStsReportOutVO>
	 * @throws EventException
	 */
	public List<BlStsReportOutVO> searchBLStsReportList(BlStsReportInVO blStsReportInVO) throws EventException {
		try {
			return dbDao.searchBLStsReportList(blStsReportInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 1006 Queue Detail Amend Reason Detail retrieve
	 * @param String bkgNo
	 * @param String srNo
	 * @return List<DocsAmendReasonCDVO>
	 * @throws EventException
	 */
	public List<DocsAmendReasonCDVO> searchAmendDetail(String bkgNo, String srNo) throws EventException {
		try {
			return dbDao.searchAmendDetail(bkgNo, srNo);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 1007 Queue Detail Return Reason retrieve
	 * @param String srKndCd
	 * @param String bkgNo
	 * @param String srNo
	 * @return List<DocsQueueDetailVO>
	 * @throws EventException
	 */
	public List<DocsQueueDetailVO> searchQueueDetail(String srKndCd, String bkgNo, String srNo) throws EventException {
		try {
			return dbDao.searchQueueDetail(srKndCd, bkgNo, srNo);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	
	/**
	 * 0953 O/B & T/S Loading Report by Location information retrieve.<br>
	 * @param tsLoadingRptByLocListInVO TsLoadingRptByLocListInVO
	 * @return List<TsLoadingRptByLocListOutVO>
	 * @exception EventException
	 */
	public List<TsLoadingRptByLocListOutVO> searchTsLoadingReportByLocation(TsLoadingRptByLocListInVO tsLoadingRptByLocListInVO) throws EventException {

		try {
			return dbDao.searchTsLoadingReportByLocation(tsLoadingRptByLocListInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Outbound Container Movement Status(ESM_BKG_0619)<BR>
	 * 1.Outbound Container Movement Status<BR>
	 * 
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsListInVO>
	 * @exception EventException
	 */
	public List<OutBdMovementStsListInVO> searchOutBdMovementStsList(OutBdMovementStsListInVO vo) throws EventException {
		try {
			return dbDao.searchOutBdMovementStsList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Trade,Sub Trade를 조회합니다.<br>
	 * @param div
	 * @param inputVO
	 * @return List<SearchTradeListVO>
	 * @throws EventException
	 */
	public List<SearchTradeListVO> searchTradeList(String div, OutBdMovementStsListInVO inputVO) throws EventException {
		try {
			return dbDao.searchTradeList(div, inputVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * VIP Customer Report(0625) 정보를 조회합니다.<br>
	 * 
	 * @param CustVipReportInVO custVipReportInVO
	 * @return List<CustVipReportOutVO>
	 * @throws EventException
	 */
	public List<CustVipReportOutVO> searchCustVipReport(CustVipReportInVO custVipReportInVO) throws EventException {
		try {
			return dbDao.searchCustVipReport(custVipReportInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Outbound Container Movement Status(ESM_BKG_1110)<BR>
	 * 1.Outbound Container Movement Status<BR>
	 * 
	 * @param OutBdEirMovementStatusListVO vo
	 * @return List<OutBdEirMovementStatusListVO>
	 * @exception EventException
	 */
	public List<OutBdEirMovementStatusListVO> searchOutBdEirMovementStatusList(OutBdEirMovementStatusListVO vo) throws EventException {
		try {
			return dbDao.searchOutBdEirMovementStatusList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	 * 
	 * @param BkgCroChkListinVO vo
	 * @return List<BkgCroChkListByBLVO>
	 * @throws EventException
	 */
	public List<BkgCroChkListByBLVO> searchCrossCheckList(BkgCroChkListinVO vo) throws EventException {

		try {
			return dbDao.searchCrossCheckList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	/**
	 * 1701 Booking Container Report information retrieve<br>
	 * @param BokCntrListInVO bokCntrListInVO
	 * @return List<BokCntrListOutVO>
	 * @throws EventException
	 */
	public List<BokCntrListOutVO> searchBokCntrList(BokCntrListInVO bokCntrListInVO) throws EventException {
		try {
			return dbDao.searchBokCntrList(bokCntrListInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 1702 BL Container Information Report retrieve<br>
	 * @param CmBkgRptVO cmBkgRptVO
	 * @return List<BlCntrInfoReportOutVO>
	 * @throws EventException
	 * @author SJH.20150113.ADD
	 */
	public List<BlCntrInfoReportOutVO> searchBLCntrInfoList(CmBkgRptVO cmBkgRptVO) throws EventException {
		try {			
			return dbDao.searchBLCntrInfoList(cmBkgRptVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * 1701 Booking Container Report information retrieve (Down Excel)<br>
	 * @param BokCntrListInVO bokCntrListInVO
	 * @return List<Object>
	 * @throws EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<Object> searchBokCntrDownExcel(BokCntrListInVO bokCntrListInVO) throws EventException{
		DBRowSet rowSet = null;
		@SuppressWarnings("rawtypes")
		List<Object> sList = new ArrayList();
		
		int colCnt = 0;
		String[] sTitle = null;
		String[] sColum = null;
//		String[] sColSeq = null;														//20150309.ADD
		
		try {
			//p_bkg_rpt_knd_cd
			//p_report_type
			String[] selectCol=dbDao.searchSelectColumn(bokCntrListInVO.getRptId(), bokCntrListInVO.getPBkgRptKndCd());
			rowSet = dbDao.searchBokCntrDownExcel(bokCntrListInVO, selectCol[0]);		//20150309.MOD		
			sList.add( rowSet );
			
			//excell Header
			rowSet.next();
			colCnt = rowSet.getMetaData().getColumnCount();
			sTitle = new String[colCnt];
			sColum = new String[colCnt];
//			sColSeq = selectCol[1].split(",");											//20150309.ADD
							
			for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
				sTitle[k-1] = JSPUtil.getNull(rowSet.getString(k));
//				sTitle[k-1] = JSPUtil.getNull(sColSeq[k-1]);							//20150309.ADD
				sColum[k-1] = rowSet.getMetaData().getColumnLabel(k);
			}
			sList.add( sTitle );
			sList.add( sColum );
			
			return sList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}	
	 
	 /**
	 * 1703 Booking Loading Report information retrieve (Down Excel)<br>
	 * @param CmBkgRptVO cmBkgRptVO
	 * @param String rptId
	 * @return List<Object>
	 * @throws EventException
	 * @author SJH.20150130.ADD
	 */
	 @SuppressWarnings("rawtypes")
	public List<Object> searchCmBkgRptDownExcel(CmBkgRptVO cmBkgRptVO, String rptId) throws EventException{
		DBRowSet rowSet = null;
		@SuppressWarnings("unchecked")
		List<Object> sList = new ArrayList();
		
		int colCnt = 0;
		String[] sTitle = null;
		String[] sColum = null;
//		String[] sColSeq = null;														//20150309.ADD
		
		try {
			String[] selectCol=dbDao.searchSelectColumn(cmBkgRptVO.getRptId(), cmBkgRptVO.getPBkgRptKndCd());
			rowSet = dbDao.searchCmBkgRptDownExcel(cmBkgRptVO, selectCol[0], rptId);	//20150309.MOD
			sList.add( rowSet );
			
			//excell Header
			rowSet.next();
			colCnt = rowSet.getMetaData().getColumnCount();
			sTitle = new String[colCnt];
			sColum = new String[colCnt];
//			sColSeq = selectCol[1].split(",");											//20150309.ADD
							
			for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
				sTitle[k-1] = JSPUtil.getNull(rowSet.getString(k));
//				sTitle[k-1] = JSPUtil.getNull(sColSeq[k-1]);							//20150309.ADD
				sColum[k-1] = rowSet.getMetaData().getColumnLabel(k);
			}
			sList.add( sTitle );
			sList.add( sColum );
			
			return sList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}	 
	 /**
		 * VGM Dashboard
		 * @param VgmDashboardVO vgmDashboardVO
		 * @return List<VgmDashboardVO>
		 * @exception EventException
		 */
		public List<VgmDashboardVO> searchVgmDashboardList(VgmDashboardVO vgmDashboardVO) throws EventException {
			try {
				return dbDao.searchVgmDashboardList(vgmDashboardVO);
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
			}
		}
		 /**
		 * VGM Dashboard
		 * @param VgmDashboardVO[] vgmDashboardVOs
		 * @exception EventException
		 */
		public void manageVgmDashboard(VgmDashboardVO[] vgmDashboardVOs) throws EventException{
			try {			
				if(vgmDashboardVOs!=null && vgmDashboardVOs.length>0){
					for(int i=0; i<vgmDashboardVOs.length; i++) {
						if (vgmDashboardVOs[i].getIbflag().equals("U")) {
							dbDao.updateVgmWgt(vgmDashboardVOs[i]);
						}
					}
				}
			} catch (DAOException de) {
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
			}
		}
		 /**
			 * VGM Dashboard
			 * @param VgmDashboardVO vgmDashboardVO
			 * @return List<CllCdlVslSumForRDVO>
			 * @exception EventException
			 */
			public List<CllCdlVslSumForRDVO> searchCllCdlRdParam(VgmDashboardVO vgmDashboardVO) throws EventException{
				try {
					return dbDao.searchCllCdlRdParam(vgmDashboardVO);
				} catch(DAOException ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
			}
			
			 /**
			 * VGM History
			 * @param VgmHistoryVO vgmHistoryVO
			 * @return List<VgmHistoryVO>
			 * @exception EventException
			 */
			public List<VgmHistoryVO> searchVgmHistory(VgmHistoryVO vgmHistoryVO) throws EventException{
				try {
					return dbDao.searchVgmHistory(vgmHistoryVO);
				} catch(DAOException ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
			}
			 /**
			 * VGM Close
			 * @param VgmDashboardVO vgmDashboardVO
			 * @param String saveFlg
			 * @exception EventException
			 */
			public void manageVgmClz(VgmDashboardVO vgmDashboardVO, String saveFlg) throws EventException{
				try {			
						dbDao.manageVgmClz(vgmDashboardVO, saveFlg);
				} catch (DAOException de) {
					throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
				}
			}
			
			 /**
			 * Search VGM EDI SUP
			 * @param VgmEdiSupVO vgmEdiSupVO
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmEdiSup(VgmEdiSupVO vgmEdiSupVO) throws EventException{
				try {
					List<VgmEdiSupVO> list = dbDao.searchVgmEdiSup(vgmEdiSupVO);
					return list;
				} catch(DAOException ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
			}
			/**
			 * Search VGM EDI SUP
			 * @param String bkgNo
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmAuto301EdiSup(String bkgNo) throws EventException{
				try {
					List<VgmEdiSupVO> list = dbDao.searchVgmAuto301EdiSup(bkgNo);
					return list;
				} catch(DAOException ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
			}
			
			/**
			 * Search VGM EDI SUP
			 * @param String bkgNo
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmAutoVermasEdiSup(String bkgNo) throws EventException{
				try {
					List<VgmEdiSupVO> list = dbDao.searchVgmAutoVermasEdiSup(bkgNo);
					return list;
				} catch(DAOException ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
			}
			
			/**
			 * Check BKG for VGM CLZ
			 * @param String bkgNo
			 * @return String vgmClzYn
			 * @exception EventException
			 */
			public String checkBkgForVgmClz(String bkgNo) throws EventException{
				try {
					String vgmClzYn = dbDao.checkBkgForVgmClz(bkgNo);
					return vgmClzYn;
				} catch(DAOException ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
			}
			
			 /**
			 * Search VGM EDI SUP
			 * @param VgmEdiSupVO vgmEdiSupVO
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmEdiSupMlt(VgmEdiSupVO vgmEdiSupVO) throws EventException{
				try {
					List<VgmEdiSupVO> list = dbDao.searchVgmEdiSupMlt(vgmEdiSupVO);
					return list;
				} catch(DAOException ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
			}
			
			 /**
			 * Search VGM EDI MULTI List
			 * @param VgmEdiSupVO vgmEdiSupVO
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmEdiMltList(VgmEdiSupVO vgmEdiSupVO) throws EventException{
				try {
					List<VgmEdiSupVO> list = dbDao.searchVgmEdiMltList(vgmEdiSupVO);
					return list;
				} catch(DAOException ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
			}
}
