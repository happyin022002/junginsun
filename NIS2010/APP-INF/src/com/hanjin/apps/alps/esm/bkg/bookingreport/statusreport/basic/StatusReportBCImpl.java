/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : StatusReportBCImpl.java
 *@FileTitle : StatusReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.28
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.28 김경섭
 * 1.0 Creation
 * 1.46 2010.09.27 이재위 [CHM-201005253-01] [BKG/DOC] EIR Exchange & Customs Release Check Report 신규개발(ESM_BKG_1110)[SZPBB]
 * 2010.12.06 전성진 [CHM-201007381] BKG/DOC Email 전송시 User Information에 Email이 누락된 경우 IAM 메일주소로 처리
 * 2011.05.31 이일민 [CHM-201110804] URGENT // Loading Confirmation by Booking i/o by Container\
 * 2011.06.03 이일민 [CHM-201111164] Loading Confimation by Shipper기능 - VVD조회조건 FEEDER포함
 * 2013.01.10 조정민 [CHM-201222115][BL Issue&Print기능] (1) BL Status Report-GSO추가 (2) BL Issue&Onboard Date Update-FWDR정보 추가
 * 2013.04.08 김진주 [CHM-201323813] 미반입 관리 관련 sms 전송 기능 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration.StatusReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration.StatusReportEAIDAO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListoutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgClearanceCrossCheckListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListByBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BlStsReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CustVipReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CustVipReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.LoadingConfirmationinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsTPSZSumListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsYardSumListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchRollOverInformationVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchTradeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportSpecialCargoOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportSummaryOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListSumVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SurchageSummaryInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByExportBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.VgmStatusReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportOutVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.ComUserVO;

/**
 * NIS2010-BookingReport Business Logic Basic Command implementation<br>
 * - NIS2010-BookingReport에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see StatusReportEventResponse,StatusReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class StatusReportBCImpl extends BasicCommandSupport implements StatusReportBC {

	// Database Access Object
	private transient StatusReportDBDAO dbDao = null;
	private transient StatusReportEAIDAO eaiDao = null;

	/**
	 * StatusReportBCImpl 객체 생성<br>
	 * StatusReportDBDAO를 생성한다.<br>
	 */
	public StatusReportBCImpl() {
		dbDao = new StatusReportDBDAO();
		eaiDao = new StatusReportEAIDAO();
	}

	/**
	 * BDR Status Inquiry 정보를 조회합니다.
	 * 
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
	 * Roll Over Information Inquiry 정보를 조회합니다.
	 * 
	 * @param SearchRollOverInformationVO searchRollOverInformationVO
	 * @return List<SearchRollOverInformationVO>
	 * @exception EventException
	 */
	public List<SearchRollOverInformationVO> searchRollOverInformationList(SearchRollOverInformationVO searchRollOverInformationVO) throws EventException {
		try {
			return dbDao.searchRollOverInformationList(searchRollOverInformationVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조회시간을 가져온다.
	 * 
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
	 * B/L Data 입력 완료 확인 리포트 기능
	 * 
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
	 * 화면 - ESM_BKG_0162<BR>
	 * Bay-Plan과 NIS Booking Data를 Cross Check한 결과를 보여주는 화면
	 * 
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
	 * Loading Confirmation by Shipper (Fax / E-Mail)<BR>
	 * 화면 - ESM_BKG_0618<BR>
	 * 고객에게 Container Loading Confirmation을 발송하는 기능
	 * 
	 * @param LoadingConfirmationinVO vo
	 * @return List<LoadingConfirmationinVO>
	 * @exception EventException
	 */
	public List<LoadingConfirmationinVO> searchBookingListForLoadingConfirmation(LoadingConfirmationinVO vo) throws EventException {
		try {
			return dbDao.searchBookingListForLoadingConfirmation(vo);
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
	 * Outbound Container Movement Status<br>
	 * 2.Outbound Container Movement Status by Yard Report(ESM_BKG_0619)<BR>
	 * 
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
	 * 3.Outbound Container Movement Status by Type/Size Report(ESM_BKG_0619)<br>
	 * 
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
	 * 고객에게 Container Loading Confirmation 메일을 발송하는 기능
	 * 
	 * @param LoadingConfirmationinVO vo
	 * @param LoadingConfirmationinVO[] vos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendEmailByBkgNoList(LoadingConfirmationinVO vo, LoadingConfirmationinVO[] vos, SignOnUserAccount account) throws EventException {
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
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();

			/* Email 전송 */
			StringBuilder cntrNos = new StringBuilder();
			List<String> cntrNoList = new ArrayList<String>();
			for (int k = 0; k < vos.length; k++) {
				cntrNoList.add(vos[k].getCntrNo());
				cntrNos.append("'").append(vos[k].getCntrNo()).append("'").append(",");
				if (k==vos.length-1 ||
                    !vos[k].getBkgNo().equalsIgnoreCase(vos[k+1].getBkgNo()) ||
                    !vos[k].getCntcPsonEml().equalsIgnoreCase(vos[k+1].getCntcPsonEml())) {
					cntrNos.delete(cntrNos.length()-1, cntrNos.length());
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
						
						rdParam = "/rv "
							    + "bkg_no[('" + vos[k].getBkgNo() + "')]"
						        + "cntr_no[(" + cntrNos + ")]"
		                        + "bkg_cust_tp_cd[('" + vos[k].getBkgCustTpCd() + "')]"
		                        + "language['" + vo.getLanguage() + "']"
		                        + "mphn_no['" + vo.getMphnNo() + "']"
		                        + "fax_no['" + vo.getFaxNo() + "']"
		                        + "snd_dt['" + vo.getSndDt() + "']"
		                        + "strUsr_id['" + account.getUsr_id() + "']"
		                        + "strOffice_cd['" + account.getOfc_cd() + "']"
		                        + "cnmv_sts_cd['" + vos[k].getCnmvStsCd() + "']"
		                        + "vvd_cd['" + vos[k].getVvdCd() + "']";
log.debug(rdParam);	
						comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
						comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
						mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
						// Send Mail
						sendId = eaiDao.sendRDEmail(mail);
						/*******************************************************
						 * Booking의 Notice 관련 생성/변경에 대해 History DATA를 구성
						 * ******************************************************/
						for (String cntrNo : cntrNoList) {
							bkgNtcHisVO = new BkgNtcHisVO();
							bkgNtcHisVO.setBkgNo(vos[k].getBkgNo());
							bkgNtcHisVO.setNtcViaCd("M"); // F:Fax,M:Email
							bkgNtcHisVO.setNtcKndCd("LC"); // PN : 미주 PICKUP NOTICE
							bkgNtcHisVO.setCntrNo(cntrNo);
							// bkgNtcHisVO.setAgnCd("");
							bkgNtcHisVO.setNtcFomCd("");
							bkgNtcHisVO.setNtcSeq(String.valueOf(k));
							
							bkgNtcHisVO.setBkgCustTpCd(vos[k].getBkgCustTpCd());
						    //bkgNtcHisVO.setCustCntcTpCd(vos[k].getBkgCustTpCd());
							
							bkgNtcHisVO.setNtcFaxNo(vos[k].getCntcPsonFaxNo());
							bkgNtcHisVO.setNtcEml(vos[k].getCntcPsonEml());
		
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
						}
						/***********************************************************************/
						/*
						 * if (bkgNtcHisVOs.size() == 0 || checkDupRecever(bkgNtcHisVOs,mailInfo.getReceiverEmail())== false){
						 * 
						 * // Send Mail sendId = eaiDao.sendRDEmail(mailInfo); bkgNtcHisVOs.add(bkgNtcHisVO); }
						 */
						/***********************************************************************/
					}
					cntrNoList = new ArrayList<String>();
					cntrNos = new StringBuilder();
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
	 * 고객에게 Container Loading Confirmation 팩스를 발송하는 기능
	 * 
	 * @param LoadingConfirmationinVO vo
	 * @param LoadingConfirmationinVO[] vos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendFaxByBkgNoList(LoadingConfirmationinVO vo, LoadingConfirmationinVO[] vos, SignOnUserAccount account) throws EventException {
		FaxMetaInfo faxInfo = null;
		String sendId = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		try {

			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String subTitle = "";
			String rdParam = "";
			String rcvInfoCtnt = "";
			/* FAX 전송 */
			StringBuilder cntrNos = new StringBuilder();
			List<String> cntrNoList = new ArrayList<String>();
			for (int k = 0; k < vos.length; k++) {
				cntrNoList.add(vos[k].getCntrNo());
				cntrNos.append("'").append(vos[k].getCntrNo()).append("'").append(",");
				if (k==vos.length-1 ||
                    !vos[k].getBkgNo().equalsIgnoreCase(vos[k+1].getBkgNo()) ||
                    !vos[k].getCntcPsonEml().equalsIgnoreCase(vos[k+1].getCntcPsonEml())) {
					cntrNos.delete(cntrNos.length()-1, cntrNos.length());
					if (vos[k].getRcheck().equals("1")){
						faxInfo = new FaxMetaInfo();
						faxInfo.setRdSubSysCd("BKG");
						faxInfo.setTmplMrd("ESM_BKG_0806.mrd");
						faxInfo.setBatFlg("N");
						subTitle = "Loading Confirmation : " + vo.getBkgNo() + " / " + vo.getVvdCd();
						faxInfo.setEmlTitNm(subTitle);
						rdParam = "/rv "
							    + "bkg_no[('" + vos[k].getBkgNo() + "')]"
		                        + "cntr_no[('" + cntrNos + "')]"
		                        + "bkg_cust_tp_cd[('" + vos[k].getBkgCustTpCd() + "')]"
		                        + "language['" + vo.getLanguage() + "']"
		                        + "mphn_no['" + vo.getMphnNo() + "']"
		                        + "fax_no['" + vo.getFaxNo() + "']"
		                        + "snd_dt['" + vo.getSndDt() + "']"
		                        + "strUsr_id['" + account.getUsr_id() + "']"
		                        + "strOffice_cd['" + account.getOfc_cd() + "']"
		                        + "cnmv_sts_cd['" + vos[k].getCnmvStsCd() + "']"
		                        + "vvd_cd['" + vos[k].getVvdCd() + "']";
		
						faxInfo.setParaInfoCtnt(rdParam);
		
						// faxInfo.setParaInfoCtnt(vo.getRdParam());
						rcvInfoCtnt = vos[k].getBkgCPerson() + ";" + vos[k].getCntcPsonFaxNo();
						faxInfo.setRcvrInfoCtnt(rcvInfoCtnt);
						faxInfo.setOfcCd(vos[k].getBkgOfcCd());
						faxInfo.setCreUsrId(account.getUsr_id());
		
						/*******************************************************
						 * Booking의 Notice 관련 생성/변경에 대해 History DATA를 구성
						 * ******************************************************/
						for (String cntrNo : cntrNoList) {
							bkgNtcHisVO = new BkgNtcHisVO();
							bkgNtcHisVO.setBkgNo(vos[k].getBkgNo());
							bkgNtcHisVO.setNtcViaCd("F"); // F:Fax,M:Email
							bkgNtcHisVO.setNtcKndCd("LC"); // PN : 미주 PICKUP NOTICE
							bkgNtcHisVO.setCntrNo(cntrNo);
							// bkgNtcHisVO.setAgnCd("");
							bkgNtcHisVO.setNtcFomCd("");
							bkgNtcHisVO.setNtcSeq("");
							bkgNtcHisVO.setBkgCustTpCd(vos[k].getBkgCustTpCd());
							
							
							bkgNtcHisVO.setNtcFaxNo(vos[k].getCntcPsonFaxNo());
							bkgNtcHisVO.setNtcEml(vos[k].getCntcPsonEml());
					
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
						}
						/***********************************************************************/
						/*
						 * if (bkgNtcHisVOs.size() == 0 || checkDupRecever(bkgNtcHisVOs,faxInfo.getRcvrInfoCtnt())== false){ // Send FAX sendId = eaiDao.sendFax(faxInfo);
						 * 
						 * bkgNtcHisVOs.add(bkgNtcHisVO); }
						 */
						/***********************************************************************/
					}
					cntrNoList = new ArrayList<String>();
					cntrNos = new StringBuilder();
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
	 * 고객에게 Container Loading Confirmation 메일,팩스를 발송시 중복 체크
	 * 
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
	 * 0103 Booking Status Report 정보를 조회합니다.<br>
	 * 
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
	 * 0103 Booking Status Report 정보를 위한 BKG OFC SUB정보를조회합니다.<br>
	 * 
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
	 * 0103 Booking Status Report SpecialCargo 정보를 조회합니다.<br>
	 * 
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
	 * 0103 Booking Status Report Summary 정보를 조회합니다.<br>
	 * 
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
	 * 
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
	 * C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	 * 
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
	 * Export C/M Data Cross-Check List를 조회합니다.<br>
	 * 
	 * @param BkgCMCroChkListByExportBLVO vo
	 * @return List<BkgCMCroChkListByExportBLVO>
	 * @throws EventException
	 */
	public List<BkgCMCroChkListByExportBLVO> searchCMCrossExportCheckList(BkgCMCroChkListByExportBLVO vo) throws EventException {

		try {
			return dbDao.searchCMCrossExportCheckList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * C/M Print by VVD (CM,FAX)를 조회합니다.<br>
	 * 
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
	 * B/L Status Report(0647) 정보를 조회합니다.<br>
	 * 
	 * @param BlStsReportInVO blStsReportInVO
	 * @return List<BlStsReportOutVO>
	 * @throws EventException
	 */
	public List<BlStsReportOutVO> searchBLStsReportList(BlStsReportInVO blStsReportInVO) throws EventException {
		try {
			if(blStsReportInVO.getBOfcCd()!=null && blStsReportInVO.getBOfcCd().length() > 0){
				blStsReportInVO.setBkgOfcCd("'"+blStsReportInVO.getBOfcCd().replaceAll(",","','")+"'");
			}
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
	 * 1006 Queue Detail Amend Reason Detail을 조회합니다.
	 * 
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
	 * 1007 Queue Detail Return Reason을 조회합니다.
	 * 
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
	 * 0953 O/B & T/S Loading Report by Location 정보를 조회합니다.<br>
	 * 
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
	 * GSO에 속한 Sub Office 를 조회
	 * @param String gso
	 * @return List<BlStsReportOutVO>
	 * @throws EventException
	 */
	public List<BlStsReportOutVO> searchGsoOfcList(String gso) throws EventException {
		try {
			
			return dbDao.searchGsoOfcList(gso);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	 /**
	 * Outbound Container Movement Status (E-MAIL,SMS) (ESM_BKG_0622)<BR>
	 * @param OutBdMvntStsNtcListInVO vo
	 * @return List<OutBdMvntStsNtcListInVO>
	 * @throws EventException
	 */
	public List<OutBdMvntStsNtcListInVO> searchOutBdMovementStsNtcList(OutBdMvntStsNtcListInVO vo) throws EventException {
		try {
			return dbDao.searchOutBdMovementStsNtcList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	 /**
	 * Outbound Container Movement Status Summary(E-MAIL,SMS) (ESM_BKG_0622)<BR>
	 * @param OutBdMvntStsNtcListSumVO vo
	 * @return List<OutBdMvntStsNtcListSumVO>
	 * @throws EventException
	 */
	public List<OutBdMvntStsNtcListSumVO> searchOutBdMovementStsNtcListSum(OutBdMvntStsNtcListSumVO vo) throws  EventException {
		try {
			return dbDao.searchOutBdMovementStsNtcListSum(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0622 : multi <br>
	 * 미반입 안내메일 send
	 * @param OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public BkgNtcHisVO sendCntrListByEmail(OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO, SignOnUserAccount account) throws EventException {
		try { 
			
			return eaiDao.sendCntrListByEmail(outBdMvntStsNtcListInVO, account);					

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),ex);
		}    
	}
	
	
	/**
	 * ESM_BKG_0622 : multi <br>
	 * 미반입 안내메일 send
	 * @param OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public BkgNtcHisVO sendShprCntrListBySms(OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO, SignOnUserAccount account) throws EventException {
		Map<String,Object> mailSmsInfo = new HashMap<String,Object>();
		BkgNtcHisVO bkgNtcHisVO = null;
		String sndId = null;
		String sndMsg = null;
		String recipient = null;
		Integer smsCnt = 0;
		try { 
			if("Y".equals(outBdMvntStsNtcListInVO.getMblSndFlg())){
				
				sndMsg = "<SML> CNTR 미반입건 반입지연시 [선적취소]될 수 있으니 확인 즉시 회신바랍니다.";
				
				mailSmsInfo.put("TEXT", sndMsg);				
				
				if("Y".equals(outBdMvntStsNtcListInVO.getShprNtcFlg()) && !"".equals(outBdMvntStsNtcListInVO.getShprMphnNo())){
					smsCnt++;
					mailSmsInfo.put("TO_SMS", JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getShprMphnNo(), "-"));
					sndId = eaiDao.sendSms(mailSmsInfo);
					recipient = JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getShprMphnNo(), "-");
				}
				

				if(smsCnt++ > 0){
					bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(outBdMvntStsNtcListInVO.getBkgNo());
					bkgNtcHisVO.setNtcViaCd("S");
					bkgNtcHisVO.setNtcKndCd("DS");
					bkgNtcHisVO.setPhnNo(recipient);
					bkgNtcHisVO.setSndId(sndId);
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				}
			}
			return bkgNtcHisVO;					

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),ex);
		}    
	}
	
	/**
	 * ESM_BKG_0622 : multi <br>
	 * 미반입 안내메일 send
	 * @param OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public BkgNtcHisVO sendCntrListBySms(OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO, SignOnUserAccount account) throws EventException {
		Map<String,Object> mailSmsInfo = new HashMap<String,Object>();
		BkgNtcHisVO bkgNtcHisVO = null;
		String sndId = null;
		String sndMsg = null;
		String recipient = null;
		Integer smsCnt = 0;
		try { 
			if("Y".equals(outBdMvntStsNtcListInVO.getMblSndFlg())){
				if(!"0".equals(outBdMvntStsNtcListInVO.getCntrCnt())){
					sndMsg = "[SML] "+ outBdMvntStsNtcListInVO.getVvd() +", " + outBdMvntStsNtcListInVO.getBkgNo() + ", " 
							+ outBdMvntStsNtcListInVO.getCntrNo() +"외"+ outBdMvntStsNtcListInVO.getCntrCnt()+"대 미반입, " 
							+ outBdMvntStsNtcListInVO.getDelCd() +" ☎"+outBdMvntStsNtcListInVO.getCntcMphnNo();
				}else{
					sndMsg = "[SML] "+ outBdMvntStsNtcListInVO.getVvd() +", "+ outBdMvntStsNtcListInVO.getBkgNo() + ", " 
							+ outBdMvntStsNtcListInVO.getCntrNo() +"미반입, "
							+ outBdMvntStsNtcListInVO.getDelCd() +" ☎"+outBdMvntStsNtcListInVO.getCntcMphnNo();
				}
				mailSmsInfo.put("TEXT", sndMsg);
				
				if("Y".equals(outBdMvntStsNtcListInVO.getObPicNtcFlg()) && !"".equals(outBdMvntStsNtcListInVO.getCntcMphnNo())){
					smsCnt++;
					mailSmsInfo.put("TO_SMS", JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getCntcMphnNo(), "-"));
					sndId = eaiDao.sendSms(mailSmsInfo);
					recipient = JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getCntcMphnNo(), "-");
				}
				
				if("Y".equals(outBdMvntStsNtcListInVO.getBkgPicNtcFlg()) && !"".equals(outBdMvntStsNtcListInVO.getBkgMphnNo())){
					smsCnt++;
					mailSmsInfo.put("TO_SMS", JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getBkgMphnNo(), "-"));
					sndId = eaiDao.sendSms(mailSmsInfo);
					recipient = recipient + ";"+ JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getBkgMphnNo(), "-");
				}
				
				if("Y".equals(outBdMvntStsNtcListInVO.getSrepNtcFlg()) && !"".equals(outBdMvntStsNtcListInVO.getSrepMphnNo())){
					smsCnt++;
					mailSmsInfo.put("TO_SMS", JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getSrepMphnNo(), "-"));
					sndId = eaiDao.sendSms(mailSmsInfo);
					recipient = recipient + ";"+ JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getSrepMphnNo(), "-");
				}
				
				if("Y".equals(outBdMvntStsNtcListInVO.getShprNtcFlg()) && !"".equals(outBdMvntStsNtcListInVO.getShprMphnNo())){
					smsCnt++;
					mailSmsInfo.put("TO_SMS", JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getShprMphnNo(), "-"));
					sndId = eaiDao.sendSms(mailSmsInfo);
					recipient = recipient + ";"+ JSPUtil.removeCharacter(outBdMvntStsNtcListInVO.getShprMphnNo(), "-");
				}
				

				if(smsCnt++ > 0){
					bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(outBdMvntStsNtcListInVO.getBkgNo());
					bkgNtcHisVO.setNtcViaCd("S");
					bkgNtcHisVO.setNtcKndCd("DS");
					bkgNtcHisVO.setPhnNo(recipient);
					bkgNtcHisVO.setSndId(sndId);
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				}
			}
			return bkgNtcHisVO;					

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),ex);
		}    
	}

	/**
	 * 
	 * 화물 CCT 경과 미반입시 sms 전송.<br>
	 *  
	 * @param List<BkgUserSmsListVO> smsList
	 * @param String bkgNo
	 * @param String sndMsg
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendSms(List<BkgUserSmsListVO> smsList, String bkgNo, String sndMsg, SignOnUserAccount account) throws EventException {
		Map<String,Object> mailSmsInfo = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		String sndId = null;
		try {
			
			for (int i = 0; i < smsList.size(); i++) {
				log.debug("\n\nphone:"+JSPUtil.removeCharacter(smsList.get(i).getPhnNo(), "-"));
				mailSmsInfo = new HashMap<String,Object>();
				mailSmsInfo.put("TO_EMAIL", smsList.get(i).getRcvrEml());
				mailSmsInfo.put("TO_SMS", JSPUtil.removeCharacter(smsList.get(i).getPhnNo(), "-"));
				mailSmsInfo.put("EML_SUBJ_CTNT", sndMsg);
				mailSmsInfo.put("FROM_EMAIL", "norelpy@smlines.com");
				mailSmsInfo.put("TEXT", sndMsg);
								
				//SMS 전송
				sndId = eaiDao.sendSms(mailSmsInfo);
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgNo);
				bkgNtcHisVO.setNtcViaCd("S");
				bkgNtcHisVO.setNtcKndCd("DS"); // 
				bkgNtcHisVO.setNtcEml(smsList.get(i).getRcvrEml());
				bkgNtcHisVO.setPhnNo(JSPUtil.removeCharacter(smsList.get(i).getPhnNo(), "-"));
				bkgNtcHisVO.setSndId(sndId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				bkgNtcHisVOs.add(bkgNtcHisVO);
				
			}
		} catch(EventException e){
//			rollback();
			throw e;
		}catch(Exception ex){
//			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return bkgNtcHisVOs;
	}
	
	/**
	 * Surcharge Summary Report를 조회합니다.<br>
	 * 
	 * @param SurchageSummaryInVO vo
	 * @return List<SurchageSummaryInVO>
	 * @throws EventException
	 */
	public List<SurchageSummaryInVO> searchSurchageSummary(SurchageSummaryInVO vo) throws EventException {

		try {
			return dbDao.searchSurchageSummary(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	/**
	 * Surcharge Detail Report를 조회합니다.<br>
	 * 
	 * @param SurchageSummaryInVO vo
	 * @return List<SurchageSummaryInVO>
	 * @throws EventException
	 */
	public List<SurchageSummaryInVO> searchSurchageDetail(SurchageSummaryInVO vo) throws EventException {

		try {
			return dbDao.searchSurchageDetail(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Report를 조회합니다.<br>
	 * 
	 * @param WarningReportInVO warningReportInVO
	 * @return List<WarningReportOutVO>
	 * @throws EventException
	 */
	public List<WarningReportOutVO> searchWarningReportList( WarningReportInVO warningReportInVO) throws EventException {
		try {
			return dbDao.searchWarningReportList(warningReportInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}		
	
	/**
	 * Report를 조회합니다.<br>
	 * 
	 * @param VgmStatusReportVO vgmStatusReportVO
	 * @return List<VgmStatusReportVO>
	 * @throws EventException
	 */
	public List<VgmStatusReportVO> searchVgmCrossCheckList(VgmStatusReportVO vgmStatusReportVO) throws EventException {
		try {
			return dbDao.searchVgmCrossCheckList(vgmStatusReportVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}			
	
}
