/*========================================================= 
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : UsaCustomsTransmissionBCImpl.java
 *@FileTitle : UsaCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.05.25 김도완
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import weblogic.wsee.util.StringUtil;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.basic.UsaCustomsReportBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.basic.UsaCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.DispoCdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsBlByKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BaplieAlarmSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BayPlanCntrDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BayPlanCntrListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BlLineInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.CmdMarkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.CntrLineInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.CustLineInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.DgUnnoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.EmlNtfcBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.HoldInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.Isf5InfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.OFMBlLineInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.OFMCntrLineVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.SendDetailLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.SendLogDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiCondListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCstmsManifestAmendmentCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaEDADetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaIsf5CondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaIsf5ResultVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaLocationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaManifestListCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiCountVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiHiHeadFootCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiHiHeaderFooterVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaPartialBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaResultCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTransmitInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTrsmFirstHeadVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.VesselEtaCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.VesselEtaInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.SendingLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsAdvBlVO;
import com.clt.syscommon.common.table.BkgCstmsAdvIbdVO;
import com.clt.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.utilitybox.utility.StringUtilities;


/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0127EventResponse,BrcsCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class UsaCustomsTransmissionBCImpl extends BasicCommandSupport implements UsaCustomsTransmissionBC {
	// Database Access Object
	private transient UsaCustomsTransmissionDBDAO dbDao = null;
	private UsaManifestListDownloadBCImpl downLoadBC = null;
	private BookingHistoryMgtBC bkgHisBC = null;

	// 수신처리 시 Return vo list
	List<CstmsHldVO> cstmsHlds = new ArrayList<CstmsHldVO>();
	List<CstmsClrVO> cstmsClrs = new ArrayList<CstmsClrVO>();
	List<CstmsHldVO> cstmsHldSends = new ArrayList<CstmsHldVO>();
	List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs = new ArrayList<BkgCstmsAdvIbdVO>();
	List<EmlNtfcBlInfoVO> emlNtfcBlInfoVOs = new ArrayList<EmlNtfcBlInfoVO>();

	String cstmsLocDiffFlg = "";

	/**
	 * CndCustomsTransmissionBCImpl 객체 생성<br>
	 * CndCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public UsaCustomsTransmissionBCImpl() throws EventException {
		dbDao = new UsaCustomsTransmissionDBDAO();
		downLoadBC = new UsaManifestListDownloadBCImpl();
		bkgHisBC = new BookingHistoryMgtBCImpl();
	}

	/**
	 * US 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param manifestTransmitVOs ManifestTransmitVO[]
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException {
		if (manifestTransmitVOs == null || manifestTransmitVOs.length <= 0)
		{
			throw new EventException(new ErrorHandler("BKG01051").getMessage());
		}

		String sTrsmMsgTpCd = "";
		String keySetStr = manifestTransmitVOs[0].getColumnValues().keySet().toString();
		if (keySetStr.indexOf("pod_cd") >= 0)
		{
			sTrsmMsgTpCd = "HI"; // 0543, 0514 화면에서 전송하는 루틴.
		}
		else
		{
			sTrsmMsgTpCd = "MI,AI,TI";
		}

		StringBuffer flatFile = new StringBuffer();
		BookingUtil command2 = new BookingUtil();
		SendingLogVO sndLogVo = new SendingLogVO();
		List<SendingLogVO> sndLogVos = new ArrayList<SendingLogVO>();
		UsaMiHiHeaderFooterVO htVo = null;
		try
		{
			if ("MI,AI,TI".equals(sTrsmMsgTpCd))
			{
				UsaManifestSearchDetailVO[] usaManifestTransmitVOs = (UsaManifestSearchDetailVO[]) manifestTransmitVOs;
				List<BlLineInfoVO> listBlNo = new ArrayList<BlLineInfoVO>();
				sTrsmMsgTpCd = usaManifestTransmitVOs[0].getTransmitCd();

				BkgCstmsCdConvCtntVO cstmsCdConvvo = new BkgCstmsCdConvCtntVO();
				cstmsCdConvvo.setCntCd("US");
				cstmsCdConvvo.setCstmsDivId("AMS_IRS_NO");
				cstmsCdConvvo.setCstmsDivIdSeq("1");
				List<BkgCstmsCdConvCtntVO> irslist = command2.searchCstmsCdConv(cstmsCdConvvo);
				String irsNo = irslist.size() > 0 ? irslist.get(0).getAttrCtnt1() : "";
				String sPreBlNo = "";
				for (int i = 0; i < usaManifestTransmitVOs.length; i++)
				{
					UsaManifestSearchDetailVO usaManifestTransmitVO = usaManifestTransmitVOs[i];
					usaManifestTransmitVO.setUsrId(usaManifestTransmitVOs[0].getUsrId());
					// CNTR 수만큼 돌기 때문에 동일한 BL NO이면 스킵한다.
					if (sPreBlNo.equals(usaManifestTransmitVO.getBlNo()))
						continue;

					sPreBlNo = usaManifestTransmitVO.getBlNo();
					BlLineInfoVO blLineInfoVO = dbDao.searchBlInfo(usaManifestTransmitVO.getBlNo(), sTrsmMsgTpCd);

					if (i == 0)
					{
						UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
						checkMiCondVO.setVvd(blLineInfoVO.getVvd());
						checkMiCondVO.setPod(blLineInfoVO.getCstmsPodCd());
						checkMiCondVO.setPol(blLineInfoVO.getCstmsPolCd());
						checkMiCondVO.setTrsmTp("MI");
						checkMiCondVO.setCgoTpCd(blLineInfoVO.getFullMtyCd());	// cgo_tp_cd 컬럼 추가
						int miSndCount = dbDao.checkMiTransCount(checkMiCondVO);

						if ("MI".equals(sTrsmMsgTpCd))
						{
							// Pushkar의 요청으로 Validation 상태에서 유저가 선택 할 수 있도록 함! 2015-07-14
//							if (miSndCount > 0)
//							{
//								// MI File Already transmitted.
//								throw new EventException(new ErrorHandler("BKG01054").getMessage());
//							}
							// 권한체크
							String user_auth_mi_multi = dbDao.searchUserAuthMiMultiYn(usaManifestTransmitVOs[0].getUsrId());
							if (!"Y".equals(user_auth_mi_multi))
							{
								// You have no authority
								throw new EventException(new ErrorHandler("PRI01033").getMessage());
							}
						}
						else if ("AI".equals(sTrsmMsgTpCd))
						{
							if (miSndCount == 0)
							{
								// You must transmit MI file first.
								throw new EventException(new ErrorHandler("BKG01055").getMessage());
							}
						}

						if (blLineInfoVO.getVpsEtaDt() == null || blLineInfoVO.getVpsEtaDt().length() != 6)
						{
							// Please update vessel schedule first before you send MI & AI.
							throw new EventException(new ErrorHandler("BKG01053").getMessage());
						}
						// HEADER
						if ("D".equals(blLineInfoVO.getMfStsCd()) && "AI".equals(sTrsmMsgTpCd))
							flatFile.append(command2.searchCstmsEdiHeaderNew("US_CMANIFEST")).append("\n");
						else if ("AI".equals(sTrsmMsgTpCd) || "MI".equals(sTrsmMsgTpCd))
							flatFile.append(command2.searchCstmsEdiHeaderNew("US_HMANIFEST")).append("\n");
						else if ("TI".equals(sTrsmMsgTpCd))
							flatFile.append(command2.searchCstmsEdiHeaderNew("US_CUSPTT")).append("\n");

						UsaMiHiHeadFootCondVO htCndVo = new UsaMiHiHeadFootCondVO();
						htCndVo.setLocAmsport(blLineInfoVO.getLocAmsPort());
						htCndVo.setTrspMsgTpCd(sTrsmMsgTpCd);
						htCndVo.setVpsEtaDt(blLineInfoVO.getVpsEtaDt());
						htCndVo.setVslEngNm(blLineInfoVO.getVslEngNm());
						htCndVo.setVslFlag(blLineInfoVO.getVslRgstCntCd());
						htCndVo.setVslLloyd(blLineInfoVO.getLloydNo());
						htCndVo.setVvd(blLineInfoVO.getVvd().substring(0, 8) + blLineInfoVO.getActFileSkdDirCd());
						String crrBatNo = ConstantMgr.getScacCode() + blLineInfoVO.getVvd() + blLineInfoVO.getCstmsPodCd() + dbDao.searchCarrierBatchNo();
						htCndVo.setCrrBatNo(crrBatNo);
						htVo = dbDao.searchMiHiHeaderFooter(htCndVo);
						flatFile.append(htVo.getAcr());
						flatFile.append(htVo.getM01());
						flatFile.append(htVo.getM02());
						flatFile.append(htVo.getP01());
						flatFile.append(htVo.getJ01());

						sndLogVo.setVvd(blLineInfoVO.getVvd());
						sndLogVo.setPolCd(blLineInfoVO.getCstmsPolCd());
						sndLogVo.setPodCd(blLineInfoVO.getCstmsPodCd());
						sndLogVo.setEtaDt(blLineInfoVO.getVpsEtaDt());
						sndLogVo.setSndUsrId(usaManifestTransmitVOs[0].getUsrId());
						sndLogVo.setSndUsrOfcCd(usaManifestTransmitVOs[0].getOfcCd());
						sndLogVo.setCreUsrId(usaManifestTransmitVOs[0].getUsrId());
						sndLogVo.setUpdUsrId(usaManifestTransmitVOs[0].getUsrId());
						sndLogVo.setEtaDt(blLineInfoVO.getVpsEtaDt());
						sndLogVo.setActFileSkdDirCd(blLineInfoVO.getActFileSkdDirCd());
						sndLogVo.setCrrBatNo(crrBatNo);
						sndLogVo.setCstmsPortCd(blLineInfoVO.getCstmsPortCd());
						sndLogVo.setCgoTpCd(blLineInfoVO.getFullMtyCd());
					}
					if ("AI".equals(sTrsmMsgTpCd)) {
						flatFile.append(blLineInfoVO.getA01());
					}

					if (!"D".equals(blLineInfoVO.getMfStsCd()) && ("MI".equals(sTrsmMsgTpCd) || "AI".equals(sTrsmMsgTpCd)))
					{
						// HOSTORY BCImpl - mbl, hbl ai flag update
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgDocProcTpCd("AI_SND");
						bkgDocProcSkdVO.setBkgNo(blLineInfoVO.getBlNo()); // updateAIFlagCancelBkgDocProcSkd 에서 HBL 인 경우를 위해 bkg_no 파라미터에 bl_no 를 set 하는게 맞음
						bkgDocProcSkdVO.setUpdUsrId(usaManifestTransmitVOs[0].getUsrId());
						bkgHisBC.manageDocProcAIFlag(blLineInfoVO.getMfNo(), bkgDocProcSkdVO);

						// MI, AI 전송시간 변경(BKG_CSTMS_ADV_BL : MF_SND_DT, AMDT_SND_DT)
						downLoadBC.modifyTransStage(blLineInfoVO.getBlNo(), sTrsmMsgTpCd);

						flatFile.append(blLineInfoVO.getB01());
						flatFile.append(blLineInfoVO.getB02());
						// HOUSE B/L
						if (!"X".equals(blLineInfoVO.getMfNo()))
						{
							flatFile.append(blLineInfoVO.getB04());
						}
						if (!"0".equals(dbDao.searchPreMF(blLineInfoVO.getBlNo())))
						{
							flatFile.append(blLineInfoVO.getB042());
						}

						/****************************************************
						 * Customer Info
						 ****************************************************/
						CustLineInfoVO custLineInfoVO = dbDao.searchCustInfo(usaManifestTransmitVO.getBlNo());
						flatFile.append(custLineInfoVO.getS01());
						flatFile.append(custLineInfoVO.getS02());
						flatFile.append(custLineInfoVO.getS03());
						flatFile.append(custLineInfoVO.getU01());
						flatFile.append(custLineInfoVO.getU02());
						flatFile.append(custLineInfoVO.getU03());
						flatFile.append(custLineInfoVO.getN01());
						flatFile.append(custLineInfoVO.getN02());
						flatFile.append(custLineInfoVO.getN03());

						if ("X".equals(custLineInfoVO.getOrzPty()))
						{
							List<UsaCustomerInfoVO> custLineInfoVO27s = dbDao.searchCstmsPartyInfo(blLineInfoVO.getBlNo());
							for (int m = 0; m < custLineInfoVO27s.size(); m++)
							{
								// N00
								flatFile.append(custLineInfoVO27s.get(m).getBuf27()).append("\n");
							}
						}

						if (sTrsmMsgTpCd.equals("AI") && "I".equals(blLineInfoVO.getItIpiLocal()) && blLineInfoVO.getItItno().indexOf(blLineInfoVO.getItNo()) >= 0 && "X".equals(blLineInfoVO.getMfNo()))
						{
							String fdaInd = dbDao.searchFdaInfo(blLineInfoVO.getBlNo());

							String delAms = "";
							if(!blLineInfoVO.getBookingPodCd().equals(blLineInfoVO.getFpodCd())) {
								if("62".equals(blLineInfoVO.getItIttype()) || "63".equals(blLineInfoVO.getItIttype())) {
									delAms = dbDao.searchAmsCodeByVvd(blLineInfoVO.getVvd(), blLineInfoVO.getBlNo(), blLineInfoVO.getFpodCd());
								}
							} else {
								if("62".equals(blLineInfoVO.getItIttype())) {
									delAms = dbDao.searchAmsCodeByVvd(blLineInfoVO.getVvd(), blLineInfoVO.getBlNo(), blLineInfoVO.getItHub());
								} else if("63".equals(blLineInfoVO.getItIttype())) {
									delAms = dbDao.searchDelAms(blLineInfoVO);
								}
							}

							String locCd = "";
							if ("61".equals(blLineInfoVO.getItIttype())) {
								locCd = blLineInfoVO.getCstmsLocCd();
							} else if ("62".equals(blLineInfoVO.getItIttype())) {
								locCd = blLineInfoVO.getItLstUsa();
							} else if ("63".equals(blLineInfoVO.getItIttype())) {
								locCd = blLineInfoVO.getCstmsPodCd();
							}
							String amsPort = dbDao.searchAmsCodeByVvd(blLineInfoVO.getVvd(), blLineInfoVO.getBlNo(), locCd);

							flatFile.append("I01");
							flatFile.append(blLineInfoVO.getItIttype());
							flatFile.append(fdaInd);                                     //1
							flatFile.append(getDigitBlank("", 10, " ", "R"));            //10
							flatFile.append(ConstantMgr.getScacCode());                  //4
							flatFile.append(getDigitBlank((amsPort + "    ").substring(0, 4), 4, " ", "R"));        //4
							flatFile.append(getDigitBlank((delAms + "     ").substring(0, 5), 5, " ", "R"));        //5
							flatFile.append(blLineInfoVO.getWgtVal());                   //8
							flatFile.append(getDigitBlank(irsNo, 12, " ", "R"));          //12 (BKG_CSTMS_CD_CONV_CTNT, AMS_IRS_NO)
							flatFile.append(getDigitBlank(blLineInfoVO.getItItno(), 11, " ", "R"));  //11
							flatFile.append(getDigitBlank("", 20, " ", "R")).append("\n");

							if("63".equals(blLineInfoVO.getItIttype()))
							{
								flatFile.append("I02");
								flatFile.append("10");
								flatFile.append(getDigitBlank(blLineInfoVO.getNextVslEngNm(), 23, " ", "R"));
								flatFile.append(getDigitBlank("", 52, " ", "R")).append("\n");
							}
						}

						/****************************************************
						 * CNTR INFO
						 ****************************************************/
						List<CntrLineInfoVO> cntrLineInfoVOs = dbDao.searchCntrInfo(usaManifestTransmitVO.getBlNo());
						for (int j = 0; j < cntrLineInfoVOs.size(); j++)
						{
							CntrLineInfoVO cntrLineInfoVO = cntrLineInfoVOs.get(j);
							flatFile.append(cntrLineInfoVO.getC01());

							// CM INFO
							List<UsaCMVO> cntrMfLineInfoVOs = dbDao.searchCMInfo(cntrLineInfoVO.getBlNo(), cntrLineInfoVO.getCntrNo(), cntrLineInfoVO.getCmdtNm());

							// CM정보가 없을때
							if (cntrMfLineInfoVOs == null || cntrMfLineInfoVOs.size() == 0)
							{
								if ("F".equals(blLineInfoVO.getFullMtyCd())) {
									flatFile.append("D01");
									flatFile.append(getDigitBlank(blLineInfoVO.getItPkgQty(), 10, "0", "L"));
									flatFile.append(getDigitBlank(blLineInfoVO.getItPkgAms(), 5, " ", "R"));
									flatFile.append(String.format("%-62s", " ")).append("\n");

									flatFile.append(getDigitBlank("D02NO MARKS", 80, " ", "R")).append("\n");
								} else {
									flatFile.append(getDigitBlank("D010000000001EMPTY CONTAINER", 80, " ", "R")).append("\n");
									flatFile.append(getDigitBlank("D02NO MARKS", 80, " ", "R")).append("\n");
								}
							}

							for (int k = 0; k < cntrMfLineInfoVOs.size(); k++)
							{
								UsaCMVO cntrCm = cntrMfLineInfoVOs.get(k);
								if ("F".equals(blLineInfoVO.getFullMtyCd())) {
									flatFile.append("D00");
									flatFile.append(getDigitBlank(cntrCm.getIcmHtCd(), 10, " ", "R"));
									flatFile.append(" ");
									flatFile.append(getDigitBlank(cntrCm.getIcmWgtVal(), 8, "0", "L"));
									flatFile.append(getDigitBlank(cntrCm.getIcmWgtQty(), 10, "0", "L"));
									flatFile.append(getDigitBlank(cntrCm.getIcmWgtTp(), 2, " ", "R"));
									flatFile.append(getDigitBlank("", 46, " ", "R")).append("\n");
								}

								flatFile.append("D01");
								flatFile.append(getDigitBlank(cntrCm.getIcmPkgQty(), 10, "0", "L"));
								flatFile.append(getDigitBlank(cntrCm.getIcmDesc(), 45, " ", "R"));
								flatFile.append(getDigitBlank("", 22, " ", "R")).append("\n");

								// CM MARK INFO
								CmdMarkVO cmdMarkVO = dbDao.searchCmMark(cntrLineInfoVO.getBlNo(), cntrLineInfoVO.getCntrNo(), cntrCm.getCmdSeq());

//								if (blLineInfoVO.getItDel().indexOf("MX") == 0)
//								{
//									flatFile.append("D02");
//									flatFile.append(getDigitBlank("IN TRANSIT TO MEXICO", 45, " ", "R")).append("\n");
//								}
//								else if (cmdMarkVO != null)
								if (cmdMarkVO != null)
								{
									int mm = 0;
									int totLen = Integer.parseInt(cmdMarkVO.getCmdMarkLen());
									for (int m = 0; m < totLen; m++)
									{
										if (m + 45 < totLen)
											mm = m + 45;
										else
											mm = totLen;
										flatFile.append("D02");
										flatFile.append(getDigitBlank(cmdMarkVO.getMkDesc().substring(m, mm), 45, " ", "R"));
										flatFile.append(getDigitBlank("", 32, " ", "R")).append("\n");
										m = mm;
									}
								}
								else
								{
									flatFile.append(getDigitBlank("D02NO MARKS", 80, " ", "R")).append("\n");
								}
							} // END FOR (CM COUNT)

							// DG INFO
							List<DgUnnoVO> dgUnnoVOs = dbDao.searchDgUnNo(blLineInfoVO.getMblNo(), cntrLineInfoVO.getCntrNo());
							for (int g = 0; g < dgUnnoVOs.size(); g++)
							{
								flatFile.append(dgUnnoVOs.get(g).getV01());
								flatFile.append(dgUnnoVOs.get(g).getV02());
								flatFile.append(dgUnnoVOs.get(g).getV03());
							}
						} // END FOR (CNTR COUNT)
					} // END IF (MI, AI)
					else if ("TI".equals(sTrsmMsgTpCd))
					{
//						UsaTiTrsmContentVO tiContVo = dbDao.searchTiTrsmContentVO(blLineInfoVO.getBlNo(), irsNo);
						if (StringUtil.isEmpty(blLineInfoVO.getPttFrmCd()))
						{
							throw new EventException(new ErrorHandler("BKG00388", new String[]{"Please check Firms Code setup"}).getMessage());
						}
						flatFile.append("T01");
						flatFile.append(getDigitBlank(blLineInfoVO.getBlNo(), 12, " ", "R"));
						flatFile.append(getDigitBlank("", 14, " ", "R"));
						flatFile.append(getDigitBlank(blLineInfoVO.getPttFrmCd(), 4, " ", "R"));
						flatFile.append(getDigitBlank(irsNo, 12, " ", "R"));
						flatFile.append(getDigitBlank("", 35, " ", "R")).append("\n");

						downLoadBC.modifyTiInfo(blLineInfoVO.getBlNo(), usaManifestTransmitVOs[0].getUsrId(), usaManifestTransmitVOs[0].getOfcCd());
					} // END IF (TI)

					boolean bIsf5 = false;
					if (dbDao.searchIsf5(usaManifestTransmitVO.getBlNo()) > 0)
					{
						bIsf5 = true;
					}

					/**********************************************************************
					 * 2009/10/22 김도완. as-is 의 하기 사항 컨버젼.(ams_isf5)
					 * ----------------------------------------------------- 20090915 JHPARK 미세관 10+2 ISF-5 신고 전송 기능
					 * 개발 Importer Security Filing 미세관이 현재 신고항목이외에 추가 정보 전송을 요구함. 수입업자에 대한 10가지 정보를 요구하지만 (ISF-10),
					 * 수입업자가 미주안에 존재하지 않는 FROB, 62(T&E), 63(IE) 에 대해서는 선사가 신고해야 한다.
					 * ----------------------------------------------------- isf5 - B/L단위로 isf5인 경우, amsIsf5()를
					 * 구동시킨다. 따라서, bl loop의 가장 하단에 해당 내용을 적용시킨다. - MI는 항상. - AI는 버튼을 따로 만들어서 판단.(이 부분은 아직 미정) - AI는
					 * isf 판단여부가 파라미터로 받음. -> MI처럼 내부 판단로직을 적용하는지 여부. 만약, 적용대상이 아니면, 리턴. -> 리턴 값을 어떤식으로 던져야 하는지...
					 * com_err_msg에 err_code를 등록?
					 **********************************************************************/

					// ISF5 : MI & AI 전송 시
					if (bIsf5 && ("MI".equals(sTrsmMsgTpCd) || "AI".equals(sTrsmMsgTpCd)))
					{
						this.amsIsf5(usaManifestTransmitVO);
					}
//					if ("AI".equals(sTrsmMsgTpCd) && bIsf5 && dbDao.searchIsf5SndLog(usaManifestTransmitVO.getBlNo()) == 0)
//					{
//						this.amsIsf5(usaManifestTransmitVO);
//					}
					// BKG_CSTMS_ADV_EDI_BL_RSPN
					listBlNo.add(blLineInfoVO);
				} // END FOR (BL COUNT)

				StringTokenizer tokenCnt = new StringTokenizer(flatFile.toString(), "\n");
				int msgCnt = tokenCnt.countTokens(); // Header($$$)가 있고, ZCR이 없으므로 count
				if (htVo != null)
				{
					String sZcr = htVo.getZcr().replaceAll("#####", getDigitBlank(String.valueOf(msgCnt), 5, "0", "L"));
					flatFile.append(sZcr);
				}

				/*******************************
				 * LOG INSERT
				 *******************************/
				String lsDate = dbDao.searchSysdate("ddmmrrhh24miss");
				sndLogVo.setCntCd("US");
				sndLogVo.setIoBndCd("I");
				sndLogVo.setSndDt(lsDate);
				sndLogVo.setHisSeq(dbDao.searchSndLogNextHisSeq("US", "I", lsDate, sTrsmMsgTpCd));
				sndLogVo.setTrsmMsgTpId(sTrsmMsgTpCd);
				sndLogVo.setVslDepRptFlg("N");
				sndLogVo.setAutoVslDepRptFlg("N");
				sndLogVo.setEtaDtFormat("MMDDRR");
				dbDao.addSendLog(sndLogVo);
				StringTokenizer token = new StringTokenizer(flatFile.toString().toUpperCase(), "\n");
				int i = 1;
				while (token.hasMoreTokens())
				{
					sndLogVo.setDtlSeq(i + "");
					sndLogVo.setEdiSndLogCtnt(token.nextToken());
					dbDao.addSendLogDetail(sndLogVo);
					i++;
				}

				for (int j = 0; j < listBlNo.size(); j++)
				{
					SendingLogVO sndLog = new SendingLogVO();
					ObjectCloner.build(sndLogVo, sndLog);
					sndLog.setBlParams(listBlNo.get(j).getBlNo());
					sndLog.setPolCd(listBlNo.get(j).getCstmsPolCd());
					sndLog.setPodCd(listBlNo.get(j).getCstmsPodCd());
					sndLogVos.add(sndLog);
				}
				dbDao.addBkgCstmsAdvEdiBlRspn(sndLogVos);
				if (sTrsmMsgTpCd.equals("MI"))
				{
					dbDao.addVslEta(sndLogVo); //BKG_CSTMS_ADV_VVD_ARR
				}
				/*********************************************
				 * Message Send Start
				 *********************************************/
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZ2COM_AMS.IBMMQ.QUEUE"));
				sendFlatFileVO.setFlatFile(flatFile.toString().toUpperCase());
				FlatFileAckVO flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

			} // END IF (MI, AI, TI)
			else if ("HI".equals(sTrsmMsgTpCd))
			{
				UsaManifestListCondForEdiVO[] usaManifestListCondForEdiVOs = (UsaManifestListCondForEdiVO[]) manifestTransmitVOs;

				boolean edaYn = false;
				boolean vslArr = false;
				for (int mainIdx = 0; mainIdx < usaManifestListCondForEdiVOs.length; mainIdx++) {
					UsaManifestListCondForEdiVO vo = usaManifestListCondForEdiVOs[mainIdx];
					vo.setEta(vo.getEta().replaceAll("-", "").replaceAll(":", "").replaceAll(" ", ""));
					vo.setEtaTime(vo.getEtaTime().replaceAll("-", "").replaceAll(":", "").replaceAll(" ", ""));

					if ("ESM_BKG_0233".equals(vo.getPageNo()))
					{
						edaYn = true;
					}
					else if ("ESM_BKG_0514".equals(vo.getPageNo()))
					{
						vslArr = true;
					}

					// EDA 전송건일 경우, Server Date < EDA on MI - 5 체크.
					if (edaYn)
					{
						if (dbDao.searchMiDiff(vo.getEtaTime()) == 0)
						{
							// [$s][$s] can not pass following condition:\n i. Current U.S. Server Date < EDA on MI - 5
							throw new EventException(new ErrorHandler("BKG06001", new String[] { vo.getVvd(), vo.getPodCd() }).getMessage());
						}
						// EDA의 경우, vpsEtaDt는 yyyy-mm-dd hh24:mi:ss 형식으로 들어온다.
						if (dbDao.searchEtaDiff(vo.getEta()) == 0)
						{
							// [$s][$s] can not pass following condition:\n i. Current U.S. Server Date < EDA on MI - 5
							throw new EventException(new ErrorHandler("BKG06002", new String[] { vo.getVvd(), vo.getPodCd() }).getMessage());
						}
					}

					// Vsl_cd가 등록된 국가코드,영문이름 정보를 조회한다.
					MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(vo.getVvd());
					if (mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null)
					{
						if (!usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_HI") && !usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_IBD_HI")) {
							// Vessel Info. Data Not Found
							throw new EventException(new ErrorHandler("BKG01052").getMessage());
						} else {
							log.error(new ErrorHandler("BKG01052").getMessage());
							continue;
						}
					}
					// podLoc이 "US"가 아니면 CSTMS_PORT_CD로 ams code를 조회한다.
					// 아니면 원래 podLoc으로 ams Code를 조회한다.
					String cstmsPortCd = "";
					String podAmsPortcd = "";
					if (!vo.getPodCd().startsWith("US")) {
						cstmsPortCd = dbDao.searchCstmsPortCd(vo.getVvd(), vo.getPolCd(), vo.getPodCd());
						podAmsPortcd = dbDao.searchAmsCodeByVvd(vo.getVvd(), "", cstmsPortCd);

					} else {
						podAmsPortcd = dbDao.searchAmsCodeByVvd(vo.getVvd(), "",  vo.getPodCd());
						cstmsPortCd = vo.getPodCd();
					}
					String amsTmlCd = dbDao.searchCstmsPortTmlCd(vo.getVvd(), vo.getPolCd(), vo.getPodCd());
					if (amsTmlCd != null && !amsTmlCd.equals("")) {
						podAmsPortcd = amsTmlCd;
					}

					if (podAmsPortcd == null || podAmsPortcd.equals(""))
					{
						if (!usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_HI") && !usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_IBD_HI")) {
							// Location AMS code Data Not Found.
							throw new EventException(new ErrorHandler("BKG01056").getMessage());
						} else {
							log.error(new ErrorHandler("BKG01056").getMessage());
							continue;
						}
					}
					// 없을수가 없다. 헤깔려서 지움
//					if (vo.getEta() == null || vo.getEta().equals(""))
//					{
//						EtaCondAtAdvancedVO etaCondAtAdvancedVO = new EtaCondAtAdvancedVO();
//						etaCondAtAdvancedVO.setVvd(vo.getVvd());
//						etaCondAtAdvancedVO.setPod(vo.getPodCd());
//						EtaDetailAtAdvancedVO etaDetailAtAdvancedVO = dbDao.searchEtaFromAdvanced(etaCondAtAdvancedVO);
//						// MMDDRR
//						vo.setEta(etaDetailAtAdvancedVO.getEta());
//					}
					String vpsEtaDtA = "";
					if (vo.getEta() != null && !vo.getEta().equals("")) {
						if (vo.getVvd().equals("HNCH0036W")) {
							vpsEtaDtA = dbDao.searchVslEta(vo.getVvd(), vo.getPodCd(), "MAX_RRMMDDH");
						} else {
							vpsEtaDtA = dbDao.searchVslEta(vo.getVvd(), vo.getPodCd(), "MIN_RRMMDDH");
						}
					}

					// Vessel Arrival Transmit (HI) 에서 ETA 를 매뉴얼로 변경하여 전송 가능 (화면에서 가져온 값 그대로 사용)
					if ("ESM_BKG_0514".equals(vo.getPageNo())) {
						vpsEtaDtA = vo.getEta().substring(2, 8) + vo.getEtaTime() + "00";
					}

					if (vpsEtaDtA == null || vpsEtaDtA.equals("")) {
						if (!usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_HI") && !usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_IBD_HI")) {
							// Vessel SKD Data Not Found.
							throw new EventException(new ErrorHandler("BKG01057").getMessage());
						} else {
							log.error(new ErrorHandler("BKG01057").getMessage());
							continue;
						}
					}

					// mi전송로그에 있는 act_file_skd_dir_cd글 대상으로 Actual File VVD를 판단한다.
					String actFileSkdDirCd = dbDao.searchActDirCd(vo.getVvd(), vo.getPolCd(), vo.getPodCd(), "MI");
					String actFileVvd = vo.getVvd();
					if ("E".equals(actFileSkdDirCd)) {
						actFileVvd = vo.getVvd().substring(0, 8) + actFileSkdDirCd;
					}
					String vpsEtdDt = "";
					if (vo.getPolCd() != null && vo.getPolCd().length() == 5)
					{
						// vps_call_ind = dbDao.searchSkdMax(vvd, polLoc);
//						vpsEtdDt = dbDao.searchVslEta(vo.getVvd(), vo.getPolCd(), "MAX_ETD_RMDHM");
						vpsEtdDt = dbDao.searchVslEtd(vo.getVvd(), vo.getPolCd(), "MAX_ETD_RMDHM");
					}
					// Arrival or Desparture 's H01 generated.
					// EDA의 경우, H01을 구한 후, H014를 H01Y로 치환시킨다. 또한, vpsEtaDt는 전달받은 파라미터의 DDMMRR 변환값으로 입력한다.
					String h01 = "";
					if (edaYn)
					{
						h01 = dbDao.searchH01(vpsEtdDt, vo.getPolCd(), podAmsPortcd, vo.getEta().substring(2), "H01");
						h01 = h01.replaceAll("H014", "H01Y");
					}
					else
					{
						h01 = dbDao.searchH01(vpsEtdDt, vo.getPolCd(), podAmsPortcd, vpsEtaDtA, "H01");
					}
					String h02 = "";
					if (vo.getPolCd() != null && vo.getPolCd().length() == 5)
					{
						h02 = dbDao.searchH01(vpsEtdDt, vo.getPolCd(), podAmsPortcd, vpsEtaDtA, "H02");
						// mio murakami 요청으로 CAMIR 의 모든 Vessel Name 삭제
//						if (!"".equals(h02))
//							h02 = h02.substring(0, 21) + getDigitBlank(mdmVslCntrVO.getVslEngNm(), 23, " ", "R") + h02.substring(44);
					}
					UsaMiHiHeadFootCondVO htCndVo = new UsaMiHiHeadFootCondVO();
					htCndVo.setVpsEtaDt(vo.getEta().substring(4, 8) + vo.getEta().substring(2,4));
					htCndVo.setLocAmsport(podAmsPortcd);
					htCndVo.setTrspMsgTpCd(sTrsmMsgTpCd);
					htCndVo.setVslEngNm(mdmVslCntrVO.getVslEngNm());
					htCndVo.setVslFlag(mdmVslCntrVO.getVslRgstCntCd());
					htCndVo.setVslLloyd(mdmVslCntrVO.getLloydNo());
					htCndVo.setVvd(actFileVvd);
					String crrBatNo = ConstantMgr.getScacCode() + vo.getVvd() + vo.getPodCd() + dbDao.searchCarrierBatchNo();
					htCndVo.setCrrBatNo(crrBatNo);
					htVo = dbDao.searchMiHiHeaderFooter(htCndVo);			// 추가ACE P01 M01, //추가ACE - J01HJSC 삭제

					// FlatFile Start
					if (edaYn){
						flatFile.append(command2.searchCstmsEdiHeaderNew("US_CUSEDA")).append("\n");
					}else if (vslArr){
						flatFile.append(command2.searchCstmsEdiHeaderNew("US_CUSREP")).append("\n");
					}else{
						flatFile.append(command2.searchCstmsEdiHeaderNew("US_CUSDEP")).append("\n");
					}
					flatFile.append(htVo.getAcr());
					flatFile.append(htVo.getM01());
					flatFile.append(htVo.getM02());
					flatFile.append(htVo.getP01());
					flatFile.append(h01);
					flatFile.append(h02);


					StringTokenizer tokenCnt = new StringTokenizer(flatFile.toString(), "\n");
					int msgCnt = tokenCnt.countTokens(); // Header($$$)가 있고, ZCR이 없으므로 count
					String sZcr = htVo.getZcr().replaceAll("#####", getDigitBlank(String.valueOf(msgCnt), 5, "0", "L"));
					flatFile.append(sZcr);
					// FlatFile End

					/*********************************************
					 * // Message Send Start
					 *********************************************/
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZ2COM_AMS.IBMMQ.QUEUE"));
					sendFlatFileVO.setFlatFile(flatFile.toString().toUpperCase());
					FlatFileAckVO flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E")) {
						if (!usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_HI") && !usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_IBD_HI")) {
							throw new EventException(new ErrorHandler("BKG00205").getMessage());
						} else {
							log.error(new ErrorHandler("BKG00205").getMessage());
							continue;
						}
					}
					/*********************************************
					 * Log Add Start.
					 *********************************************/
					String lsDate = dbDao.searchSysdate("ddmmrrhh24miss");
					sndLogVo.setCntCd("US");
					sndLogVo.setIoBndCd("I");
					sndLogVo.setSndDt(lsDate);
					sndLogVo.setHisSeq(dbDao.searchSndLogNextHisSeq("US", "I", lsDate, sTrsmMsgTpCd));
					sndLogVo.setTrsmMsgTpId("HI");
					sndLogVo.setVvd(vo.getVvd());
					sndLogVo.setCrrBatNo(crrBatNo);
					sndLogVo.setPolCd(vo.getPolCd());
					sndLogVo.setPodCd(vo.getPodCd());
					sndLogVo.setVslDepRptFlg("N");
					if (!usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_HI") && !usaManifestListCondForEdiVOs[0].getUsrId().equals("AUTO_IBD_HI")) {
						sndLogVo.setAutoVslDepRptFlg("N");
					} else {
						sndLogVo.setAutoVslDepRptFlg("Y");
					}
					sndLogVo.setSndUsrId(usaManifestListCondForEdiVOs[0].getUsrId());
					sndLogVo.setSndUsrOfcCd(usaManifestListCondForEdiVOs[0].getOfcCd());
					sndLogVo.setAckTpNo("");
					sndLogVo.setCreUsrId(usaManifestListCondForEdiVOs[0].getUsrId());
					sndLogVo.setUpdUsrId(usaManifestListCondForEdiVOs[0].getUsrId());
					sndLogVo.setActFileSkdDirCd(actFileSkdDirCd);
					sndLogVo.setCstmsPortCd(cstmsPortCd);
					dbDao.addSendLog(sndLogVo);

					// 이전 소스는 전송내용을 한번에 로그테이블에 입력했으나, 라인단위로 입력하는 것으로 수정.
					StringTokenizer token = new StringTokenizer(flatFile.toString().toUpperCase(), "\n");
					int i = 1;
					while (token.hasMoreTokens())
					{
						sndLogVo.setDtlSeq(i + "");
						sndLogVo.setEdiSndLogCtnt(token.nextToken());
						dbDao.addSendLogDetail(sndLogVo);
						i++;
					}
					if (edaYn)
					{
						sndLogVo.setEtaDt(vo.getEta());
						sndLogVo.setEtaDtFormat("YYYYMMDDHH24MI");
						// INSERT result in inbond_trans_vvd (BKG_CSTMS_ADV_VVD_ARR)
						int resultQuery = dbDao.modifyVvdEta(sndLogVo);
						if (resultQuery == 0)
						{
							sndLogVo.setIoBndCd("EDA");
							dbDao.addVslEta(sndLogVo);
						}
					}
					else
					{
						// AUTO HI전송인지 여부에 따라서 해당 MI전송 LOG도 Auto Check Update한다.
						dbDao.modifyHiInfo(sndLogVo);
					}
				} // END FOR (HI COUNT)
			} // END HI
			return flatFile.toString();
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 0543, 0514 화면의 Arrival, Departure 전송을 위한 조회를 실행한다.
	 *
	 * @param ManifestListCondForEdiVO manifestListCondForEdiVO
	 * @return ManifestListForEdiVO
	 * @throws EventException
	 */
	public ManifestListForEdiVO searchManifestListForEdi(ManifestListCondForEdiVO manifestListCondForEdiVO)	throws EventException {
		UsaManifestListCondForEdiVO condVO = (UsaManifestListCondForEdiVO) manifestListCondForEdiVO;
		UsaManifestListCondForEdiVO retVO = new UsaManifestListCondForEdiVO();
		ManifestListForEdiVO vo = new ManifestListForEdiVO();
		try
		{
			// 0223화면에 오지 않은 경우, 즉, 0543, 0514 인 경우의 실행.
			if (!"ESM_BKG_0233".equals(condVO.getPageNo()))
			{
				String pol = condVO.getPolCd();
				MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(condVO.getVvd());
				if (mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null)
				{
					throw new EventException(new ErrorHandler("BKG01059").getMessage());
				}
				String vpsEtaDt = dbDao.searchVslEta(condVO.getVvd(), condVO.getPodCd(), "YMD_VPS_ETA_DT");
				String vpsEtdDt = "";
				UsaTransmitInfoVO miTrans = new UsaTransmitInfoVO();
				if (pol.length() == 5)
				{
					vpsEtdDt = dbDao.searchVslEtd(condVO.getVvd(), pol, "GENERAL_ETD");
					miTrans = dbDao.searchMiTransmitDt(condVO.getVvd(), condVO.getPolCd(), condVO.getPodCd(), "MI");
					if (miTrans == null)
					{
						throw new EventException(new ErrorHandler("BKG01062").getMessage());
					}
				}
				else
				{
					miTrans.setSndDt("");
				}
				UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
				checkMiCondVO.setVvd(condVO.getVvd());
				checkMiCondVO.setPod(condVO.getPodCd());
				checkMiCondVO.setPol(condVO.getPolCd());
				checkMiCondVO.setTrsmTp("HI");
				int hiSndCount = dbDao.checkMiTransCount(checkMiCondVO);
				String hiSndYn = "N";
				if (hiSndCount > 0)
					hiSndYn = "Y";
				UsaTransmitInfoVO hiTrans = dbDao.searchMiTransmitDt(condVO.getVvd(), condVO.getPolCd(), condVO
						.getPodCd(), "HI");
				retVO = condVO;
				retVO.setBlCount(Integer.toString(dbDao.searchBlCount(condVO.getVvd(), condVO.getPolCd(), condVO
						.getPodCd())));
				retVO.setName(mdmVslCntrVO.getVslEngNm());
				retVO.setEta(vpsEtaDt);
				retVO.setAtd(vpsEtdDt);
				retVO.setMiTransmit(miTrans.getSndDt());
				retVO.setHiSndYn(hiSndYn);
				if (hiTrans != null)
				{
					retVO.setHiTransmit(hiTrans.getSndDt());
					retVO.setSndUsrId(hiTrans.getSndUsrId());
				}
				vo.setUsaManifestListCondForEdiVOs(retVO);
			}
			else
			{
				// 0233 화면에서 온 경우의 실행.
				List<UsaEDADetailVO> list = dbDao.searchEDAEta(condVO);
				vo.setUsaEDADetailVOs(list);
			}
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * US 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitOfm(ManifestTransmitVO[] manifestTransmitVO) throws EventException {
		// sTrsmMsgTpCd : MI/AI..
		String sTrsmMsgTpCd = "";
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZ2COM_AMS.IBMMQ.QUEUE"));
		UsaManifestSearchDetailVO usaManifestTransmitVO = null;
		UsaManifestSearchDetailVO[] usaManifestTransmitVOs = null;
		ManifestTransmitVO manifestTransmitVO2 = null;
		int len = manifestTransmitVO.length;
		if (len > 0)
		{
			manifestTransmitVO2 = manifestTransmitVO[0];
		}
		else
		{
			// There is no trans data
			throw new EventException(new ErrorHandler("BKG01051").getMessage());
		}
		String keySetStr = manifestTransmitVO2.getColumnValues().keySet().toString();
		if (keySetStr.indexOf("pod_cd") >= 0)
		{
			sTrsmMsgTpCd = "HI"; // 0543 화면에서 전송하는 루틴.
		}
		else
		{
			sTrsmMsgTpCd = "MI"; // 0613 화면에서 전송하는 루틴.
		}
		OFMBlLineInfoVO blLineInfoVO = null;
		List<OFMCntrLineVO> cntrLineInfoVOs = null;
		OFMCntrLineVO cntrLineInfoVO = null;
		List<UsaCMVO> cntrMfLineInfoVOs = null;
		CmdMarkVO cmdMarkVO = null;
		UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
		StringBuffer flatFile = null;
		StringBuffer hiFile02 = null;
		StringBuffer tmpBuf = null;
		StringBuffer retriveFailedBlNo = new StringBuffer();
		int maxCnt = 0;
		int realSentBlCnt = 0;
		int lineCount = 0;
		String currBlNo = "";
		String vvd = "";
		String pod = "";
		String pol = "";
		String buf1 = "";
		String buf6 = "";
		String buf7 = "";
		String digit4blank = "";
		String cmdtDesc = "";
		String itDel = "";
		String buf21 = "";
		String cntrNo = "";
		String icmWgtTp = "";
		String icmPkgQty = "";
		String icmDesc = "";
		String cmdSeq = "";
		String cmdMarkAll = "";
		String cmdMarkLen = "";
		String cmdMarkNew = "";
		String cmdMark = "";
		String vslFlag = "";
		String vslEngNm = "";
		String vslLloyd = "";
		String vpsEtaDt = "";
		String vpsEtdDt = "";
		String lsDate = "";
		String usrId = "";
		String ofcCd = "";
		String locAmsport = "";
		String amsCode = "";
		int cm_count = 0;
		int idx = 0;
		SendingLogVO sndLogVo = new SendingLogVO();
		String alreadySentBl = "";
		int lineCnt = 0;
		int kk = 0;
		int j = 0;
		try
		{
			digit4blank = "    ";
			if ("MI".equals(sTrsmMsgTpCd) || "AI".equals(sTrsmMsgTpCd))
			{
				usaManifestTransmitVOs = (UsaManifestSearchDetailVO[]) manifestTransmitVO;
				flatFile = new StringBuffer();
				maxCnt = usaManifestTransmitVOs.length;
				// blCntExceptHouse
				for (int i = 0; i < maxCnt; i++)
				{
					usaManifestTransmitVO = usaManifestTransmitVOs[i];
					currBlNo = usaManifestTransmitVO.getBlNo();
					if (i == 0)
					{
						sTrsmMsgTpCd = usaManifestTransmitVO.getTransmitCd();
						vvd = usaManifestTransmitVO.getVvd();
						usrId = usaManifestTransmitVO.getUsrId();
						ofcCd = usaManifestTransmitVO.getOfcCd();
						lsDate = dbDao.searchSysdate("ddmmrrhh24miss");
						// [USACUSKEWB0029EUSTIWNGOBS AUTO_HI 1018020090419040121HI
						UsaTrsmFirstHeadVO firstHeadVO = new UsaTrsmFirstHeadVO();
						firstHeadVO.setVvd(vvd);
						firstHeadVO.setPodCd(pod);
						firstHeadVO.setOfcCd(ofcCd);
						firstHeadVO.setUsrId(usrId);
						firstHeadVO.setLsDate(lsDate);
						firstHeadVO.setFormat("ddmmrrhh24miss");
						firstHeadVO.setTrspMsgTpCd(sTrsmMsgTpCd);
						buf6 = dbDao.searchTrsmFirstHeader(firstHeadVO);
						pod = usaManifestTransmitVO.getPod();
						if (pod != null && pod.equals("CAVAN"))
						{
							pod = dbDao.searchBkgLane(vvd, pod, null);
						}
						pol = usaManifestTransmitVO.getPol();
						locAmsport = dbDao.searchAmsCodeByVvd(vvd, currBlNo, pod);
						if (locAmsport == null || locAmsport.length() == 0)
							locAmsport = digit4blank;
						// Vsl_cd가 등록된 국가코드,영문이름 정보를 조회한다.
						MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(vvd);
						if (mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null)
						{
							// Vessel Info. Data Not Found
							throw new EventException(new ErrorHandler("BKG01052").getMessage());
						}
						vslFlag = mdmVslCntrVO.getVslRgstCntCd();
						vslEngNm = mdmVslCntrVO.getVslEngNm();
						vslLloyd = mdmVslCntrVO.getLloydNo();
						if (vslLloyd == null || vslLloyd.equals("9124524") || vslLloyd.equals("8918945")
								|| vslLloyd.equals("9183489"))
						{
							vslLloyd = "       ";
						}
						vpsEtaDt = dbDao.searchVslEta(vvd, pod, "MAX_MMDDRR");
//						vpsEtdDt = dbDao.searchVslEta(vvd, pol, "MAX_ETD_DDMONRR");
						vpsEtdDt = dbDao.searchVslEtd(vvd, pol, "MAX_ETD_DDMONRR");
						if (vpsEtaDt == null || vpsEtaDt.length() == 0)
							vpsEtaDt = dbDao.searchEtaWhenSkdIsNotExist(vvd, pod);
						if (vpsEtaDt == null || vpsEtaDt.length() != 6)
						{
							// Please update vessel schedule first before you send MI & AI.
							throw new EventException(new ErrorHandler("BKG01053").getMessage());
						}
						checkMiCondVO.setVvd(vvd);
						checkMiCondVO.setPod(pod);
						checkMiCondVO.setPol(pol);
						checkMiCondVO.setTrsmTp("MI");
					}
					// B01 SetUp.
					if (currBlNo != null && alreadySentBl.indexOf(currBlNo) < 0)
					{
						alreadySentBl = alreadySentBl + "," + currBlNo;
						cmdtDesc = "";
						itDel = "";
						amsCode = "";
						blLineInfoVO = dbDao.searchOfmItType(currBlNo);
						if (blLineInfoVO != null)
						{
							if (amsCode == null || amsCode.length() < 4)
							{
								amsCode = digit4blank;
							}
							buf1 = blLineInfoVO.getBuf1();
							flatFile.append(buf1);
							lineCount++;
							if (cmdtDesc == null || cmdtDesc.equals(""))
								cmdtDesc = " ";
							tmpBuf = new StringBuffer(cmdtDesc);
							for (idx = cmdtDesc.length(); idx < 45; idx++)
							{
								tmpBuf.append(" ");
							}
							cmdtDesc = tmpBuf.toString();
							itDel = blLineInfoVO.getItDel();
						}
						buf21 = dbDao.searchOfmCustomer(currBlNo);
						flatFile.append(buf21);
						lineCount = lineCount + 6;
						// Container Info..
						cntrLineInfoVOs = dbDao.searchOfmContainerInfo(currBlNo);
						if (cntrLineInfoVOs != null && cntrLineInfoVOs.size() > 0)
						{
							for (int c = 0; c < cntrLineInfoVOs.size(); c++)
							{
								cntrLineInfoVO = cntrLineInfoVOs.get(c);
								flatFile.append(cntrLineInfoVO.getBuf3());
								lineCount++;
								cntrNo = cntrLineInfoVO.getCntrNo();
								cntrMfLineInfoVOs = dbDao.searchOfmCMInfo(currBlNo, cntrNo, cmdtDesc);
								if (cntrMfLineInfoVOs == null || cntrMfLineInfoVOs.size() == 0)
								{
									cm_count = 0;
								}
								else
								{
									cm_count = cntrMfLineInfoVOs.size();
								}
								for (int k = 0; k < cm_count; k++)
								{
									icmWgtTp = cntrMfLineInfoVOs.get(k).getIcmWgtTp();
									icmPkgQty = cntrMfLineInfoVOs.get(k).getIcmPkgQty();
									icmDesc = cntrMfLineInfoVOs.get(k).getIcmDesc();
									cmdSeq = cntrMfLineInfoVOs.get(k).getCmdSeq();
									if (icmWgtTp == null || icmWgtTp.equals(""))
										icmWgtTp = " ";
									tmpBuf = new StringBuffer(icmWgtTp);
									for (idx = icmWgtTp.length(); idx < 2; idx++)
									{
										tmpBuf.append(" ");
									}
									icmWgtTp = tmpBuf.toString();
									if (icmPkgQty == null || icmPkgQty.equals(""))
										icmPkgQty = "";
									if (icmDesc == null || icmDesc.equals(""))
										icmDesc = "";
									flatFile.append("CM_DESC{\n").append("CM_PKG_QTY | ").append(icmPkgQty)
											.append("\n").append("CM_DESC | ").append(icmDesc).append("\n");
									lineCount++;
									// proC의 if (strncmp(cmdSeq[i].arr,"00",2) != 0) 라인 구현
									if (cmdSeq != null && cmdSeq.indexOf("00") != 0)
									{
										cmdMarkVO = dbDao.searchCmMark(currBlNo, cntrNo, cmdSeq);
										cmdMarkAll = cmdMarkVO.getCmdMarkAll();
										cmdMarkLen = cmdMarkVO.getCmdMarkLen();
										// proC의 if(strncmp(itDel.arr,"MX",2) == 0) { 라인 구현
										if (itDel != null && itDel.indexOf("MX") == 0)
										{
											cmdMarkAll = "IN TRANSIT TO MEXICO";
											cmdMarkLen = Integer.toString((Integer.parseInt(cmdMarkLen) + 20));
										}
										int nrIdx = cmdMarkAll.indexOf("\n");
										cmdMarkNew = "";
										String tmp2 = "";
										String tmp3 = cmdMarkAll;
										for (; nrIdx >= 0;)
										{
											if (nrIdx < 23)
											{
												tmp3 = tmp3.replaceFirst("\n", " ");
												tmp2 = tmp3.substring(0, nrIdx);
												tmpBuf = new StringBuffer(tmp2);
												for (idx = tmpBuf.length(); idx < 23; idx++)
												{
													tmpBuf.append(" ");
												}
												tmp2 = tmpBuf.toString();
												tmp3 = tmp3.substring(nrIdx + 1);
												cmdMarkNew = cmdMarkNew + tmp2;
												nrIdx = tmp3.indexOf("\n");
											}
											else
											{
												tmp2 = tmp3.substring(0, 23);
												tmp3 = tmp3.substring(23);
												cmdMarkNew = cmdMarkNew + tmp2;
												nrIdx = nrIdx - 23;
											}
										}
										if (tmp3.length() > 0)
										{
											tmpBuf = new StringBuffer(tmp3);
											for (idx = tmp3.length(); idx < 23; idx++)
											{
												tmpBuf.append(" ");
											}
											tmp3 = tmpBuf.toString();
											cmdMarkNew = cmdMarkNew + tmp3;
										}
										lineCnt = 0;
										lineCnt = (int) Math.floor((cmdMarkNew.length() + 22) / 23);
										flatFile.append("MARK{\n");
										kk = 0;
										if (lineCnt == 0)
										{
											tmpBuf = new StringBuffer("NO MARKS");
											for (idx = tmpBuf.length(); idx < 23; idx++)
											{
												tmpBuf.append(" ");
											}
											flatFile.append("MARKNO | ").append(tmpBuf.toString()).append("\n");
											lineCount++;
										}
										cmdMark = "";
										for (j = 0; j < lineCnt; j++)
										{
											cmdMark = "";
											cmdMark = cmdMarkNew.substring(kk, kk + 22);
											kk = kk + 23;
											tmpBuf = new StringBuffer(cmdMarkNew);
											if (kk + 22 > cmdMarkNew.length())
											{
												for (idx = cmdMarkNew.length(); idx < kk + 22; idx++)
												{
													tmpBuf.append(" ");
												}
												cmdMarkNew = tmpBuf.toString();
											}
											if ((cmdMark.indexOf("NO MARKS") == 0 && !cmdSeq.equals("1"))
													|| (cmdMark.indexOf("                       ") == 0))
											{
												continue;
											}
											tmpBuf = new StringBuffer(cmdMark);
											for (idx = tmpBuf.length(); idx < 23; idx++)
											{
												tmpBuf.append(" ");
											}
											cmdMark = tmpBuf.toString();
											flatFile.append("MARKNO | ").append(cmdMark).append("\n");
											lineCount++;
										} // for
										flatFile.append("}MARK\n");
									}
								}// for mf.
								flatFile.append("}CNTR_INFO\n");
							}// for - cntrLine
						}// if
						if (blLineInfoVO != null)
						{
							flatFile.append("}BL_INFO\n");
							realSentBlCnt++;
						}
						else
						{
							retriveFailedBlNo.append(currBlNo).append("\n");
						}
					}// currBlNo is not null.
				} // end for(i)
				String pol_name = dbDao.searchLocNm(pol);
				String pod_name = dbDao.searchLocNm(pod);
				UsaMiHiHeadFootCondVO htCndVo = new UsaMiHiHeadFootCondVO();
				htCndVo.setBlCnt(Integer.toString(realSentBlCnt));
				htCndVo.setLocAmsport(locAmsport);
				htCndVo.setTrspMsgTpCd(sTrsmMsgTpCd);
				htCndVo.setVpsEtaDt(vpsEtaDt);
				htCndVo.setVslEngNm(vslEngNm);
				htCndVo.setVslFlag(vslFlag);
				htCndVo.setVslLloyd(vslLloyd);
				htCndVo.setVvd(vvd);
				htCndVo.setPodName(pod_name);
				htCndVo.setPolName(pol_name);
				htCndVo.setVpsEtdDt(vpsEtdDt);
				UsaMiHiHeaderFooterVO htVo = dbDao.searchOfmHeaderFooter(htCndVo);
				buf7 = htVo.getHeader();
				hiFile02 = new StringBuffer();
				hiFile02.append(buf7).append(flatFile.toString());
				flatFile = new StringBuffer(buf6).append(hiFile02.toString());
				/*********************************************
				 * // Flat File Gen End.
				 *********************************************/
				/*******************************************************/
				/* MI 인경우만 MI ETA INSERT 2001.1.29 */
				/*******************************************************/
				sndLogVo.setCntCd("US");
				sndLogVo.setIoBndCd("O");
				sndLogVo.setSndDt(lsDate);
				sndLogVo.setHisSeq(dbDao.searchSndLogNextHisSeq("US", "O", lsDate, sTrsmMsgTpCd));
				sndLogVo.setTrsmMsgTpId(sTrsmMsgTpCd);
				sndLogVo.setVvd(vvd);
				sndLogVo.setPolCd(pol);
				sndLogVo.setPodCd(pod);
				sndLogVo.setVslDepRptFlg("N");
				sndLogVo.setAutoVslDepRptFlg("N");
				sndLogVo.setSndUsrId(usrId);
				sndLogVo.setSndUsrOfcCd(ofcCd);
				sndLogVo.setAckTpNo("");
				sndLogVo.setCreUsrId(usrId);
				sndLogVo.setUpdUsrId(usrId);
				sndLogVo.setEtaDt(vpsEtaDt);
				sndLogVo.setEtaDtFormat("MMDDRR");
				/*********************************************
				 * // Log Add Start.
				 *********************************************/
				// INBOND_SLOGP table에 전송 결과 입력
				dbDao.addSendLog(sndLogVo);
				// INBOND_SLOG_DETAIL table에 전송 결과 입력
				// 이전 소스는 전송내용을 한번에 로그테이블에 입력했으나, 라인단위로 입력하는 것으로 수정.
				StringTokenizer token = new StringTokenizer(hiFile02.toString(), "\n");
				int i = 1;
				String tmpStr = "";
				String logContReal = "";
				StringBuffer logContBuf = new StringBuffer();
				while (token.hasMoreTokens())
				{
					tmpStr = token.nextToken();
					logContBuf.append(tmpStr).append("\n");
					if (logContBuf.length() > 2000)
					{
						sndLogVo.setDtlSeq(i + "");
						sndLogVo.setEdiSndLogCtnt(logContReal);
						logContBuf = new StringBuffer(tmpStr);
						logContReal = "";
						dbDao.addSendLogDetail(sndLogVo);
						i++;
					}
					logContReal = logContBuf.toString();
				}
				if (!logContReal.equals(""))
				{
					sndLogVo.setDtlSeq(i + "");
					sndLogVo.setEdiSndLogCtnt(logContReal);
					dbDao.addSendLogDetail(sndLogVo);
				}
				log.info("##################################################");
				log.info("retriveFailedBlNo : " + retriveFailedBlNo.toString());
				/*********************************************
				 * // Log Add End.
				 *********************************************/
			}
			if (flatFile != null)
				return flatFile.toString();
			else
				return "";
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	 /**
	 * 세관 적하 목록 정정 신고를 위한 적하 정정 목록 조회
	 *
	 * @param CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO
	 * @param String aiDiv
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws EventException
	 */
	public List<CstmsManifestAmendmentVO> searchCstmsManifestAmendment(CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO, String aiDiv) throws EventException {
		List<CstmsManifestAmendmentVO> list = new ArrayList<CstmsManifestAmendmentVO>();
		try {
			if ("GEN".equals(aiDiv)) {
				list = dbDao.searchUsaCstmsManifestAmendment((UsaCstmsManifestAmendmentCondVO) cstmsManifestAmendmentCondVO);
			} else if ("DEL".equals(aiDiv)) {
				list = dbDao.searchDelManifestAmendment((UsaCstmsManifestAmendmentCondVO) cstmsManifestAmendmentCondVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Vessel Stowage Plan Transmit 화면을 조회.
	 *
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchStowageManifestList(StowageManifestCondVO stowageManifestCondVO) throws EventException {
		StiCondListVO condVO = (StiCondListVO) stowageManifestCondVO;
		List<ManifestTransmitVO> rtnList = new ArrayList<ManifestTransmitVO>();
		List<StiDetailVO> list = null;
		String paramVvd = ""; 	// 파라메터로 넘오는 vvd
		String tmpVvd = "";		// 가공한 값을 담을 vvd
		String sLane = "";
		try
		{
			// 조회조건이 유효한 조건일때 로직 실행.
			if (condVO != null)
			{
				paramVvd = tmpVvd = condVO.getVvd();
				sLane = dbDao.searchSvcLane(paramVvd); // service lane값을 조회한다.

				/* 20090602 JHPARK Lane 이 PNS 이거나 CEN 이면 temp_vvd 를 바꿔준다. (입력된 E/B 를 W/B 로) */
				if("PNS".equals(sLane) || "CEN".equals(sLane)) {

					tmpVvd = paramVvd.subSequence(0, 8) + "W";
				}

				/****************************************************************************/
				/* 20090602 JHPARK 아시아 -> 캐나다 -> 미국인 경우에 캐나다에서는 West Bound*/
				/* 로 Upload 한다. (아시아 선적분 포함) PNS, CEN Lane 의 경우에는 User 가 	*/
				/* E/B 로 조회하더라도 W/B 로 Upload 된 데이터를 조회할 수 있어야 한다. 	*/
				/****************************************************************************/
				if("EXCLUDECA".equals(condVO.getExcludeca())) {
					condVO.setVvd(tmpVvd);
				} else {
					// 화면에서 가져온 vvd를 그대로 사용한다.
					condVO.setVvd(paramVvd);
				}

				list = dbDao.searchStiListAtUsa(condVO);
				if (list != null)
				{
					// Vessel Info.를 조회한다.
					MdmVslCntrVO vo = dbDao.searchVslInfo(paramVvd);
					// vos의 결과 수 만큼 루프를 돌며, list를 채워준다.
					StiDetailVO itemVO = null;
					for (int i = 0; i < list.size(); i++)
					{
						itemVO = list.get(i);
						itemVO.setVslEngNm(vo.getVslEngNm());
						itemVO.setVslVoy(paramVvd.substring(4));
						itemVO.setCrrCd(vo.getCrrCd());
						rtnList.add(itemVO);
					}
				}
			}
			return rtnList;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan Transmit을 실행.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitStowageManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException {

		String condVvd = ""; // 조회조건 vvd값
		String searchVvdCd = ""; // 조회시 조회된 vvd 값
		String pod = "";
		String lastpol = "";
		String usrId = "";
		String ofcCd = "";
		try
		{
			BookingUtil command2 = new BookingUtil();
			StringBuffer flatFile = new StringBuffer();
			if (manifestTransmitVOs != null)
			{
				// searchVesselEta 를 위한 파라미터 변수VO
				VesselEtaCondVO vslCondVo = null;
				// StowageManifestDetailVO[] cvos 를 할당받아 형변환된 vo변수.
				StiDetailVO vo = null;
				// searchVesselEta 의 결과를 담을 변수VO
				VesselEtaInfoVO vslVo = null;
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회조건 VO.
				BayPlanCntrListCondVO bayCondVo = null;
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회결과 VO.
				BayPlanCntrDetailVO bayDetailVo = null;
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회결과 VO들의 배열.
				// 두번째 루프에서 다시 컨테이너별 BayPlan을 조회하지 않고, 이 결과배열로 루프를 돌린다.
				BayPlanCntrDetailVO[] bayDetailVos = new BayPlanCntrDetailVO[manifestTransmitVOs.length];
				condVvd = ((StiDetailVO) manifestTransmitVOs[0]).getVvd();
				/*
				 * 조회시 skd_dir_cd가 "E" -> "W"바뀌는 경우가 있습니다.
				 * 로직은 조회 로직 참고 하세요
				 */
				searchVvdCd = ((StiDetailVO) manifestTransmitVOs[0]).getSearchVvdCd();
				pod = ((StiDetailVO) manifestTransmitVOs[0]).getPod();
				lastpol = ((StiDetailVO) manifestTransmitVOs[0]).getLPol();
				usrId = ((StiDetailVO) manifestTransmitVOs[0]).getTmp1();
				ofcCd = ((StiDetailVO) manifestTransmitVOs[0]).getTmp2();

				for (int i = 0; i < manifestTransmitVOs.length; i++)
				{
					if (i == 0)
					{
						vslCondVo = new VesselEtaCondVO();
						vo = (StiDetailVO) manifestTransmitVOs[i];
						vslCondVo.setVvd(condVvd);
						vslCondVo.setLastpol(vo.getLPol());
						// DBDAO 조회 호출.
						vslVo = dbDao.searchVesselEta(vslCondVo);

						if(vslVo == null)
							throw new EventException(new ErrorHandler("BKG00841", new String[] {}).getMessage());

						flatFile.append("MSG_FUNC:").append("O").append("\n");
						flatFile.append("MSG_DATE:").append(vslVo.getCurrdate()).append("\n");
						flatFile.append("VSL_CD:").append(vslVo.getVslCd()).append("\n");
						flatFile.append("VOY:").append(vslVo.getSkdVoyNo()).append("\n");
						flatFile.append("DIR:").append(vslVo.getSkdDirCd()).append("\n");
						flatFile.append("CALLSIGN:").append(vslVo.getCallSgnNo()).append("\n");
						flatFile.append("LLOYD_CD:").append(vslVo.getLloydNo()).append("\n");
						flatFile.append("VSL_NM:").append(vslVo.getVslEngNm()).append("\n");
						flatFile.append("POL:").append(vslVo.getVpsPortCd()).append("\n");
						flatFile.append("PPORT_ATA:").append(vslVo.getVpsEtaDt()).append("\n");
						flatFile.append("PPORT_ETD:").append(vslVo.getVpsEtdDt()).append("\n");
						// ATD정보가 없어서 ETD 값으로 넣음.
						flatFile.append("PPORT_ATD:").append(vslVo.getVpsEtdDt()).append("\n");
						flatFile.append("NPORT:").append(vslVo.getUsPortCd()).append("\n");
						flatFile.append("NPORT_ETA:").append(vslVo.getUsEtaDt()).append("\n");
						flatFile.append("LOAD_VOY:").append("\n");
					}
					vo = (StiDetailVO) manifestTransmitVOs[i];
					bayCondVo = new BayPlanCntrListCondVO();
					bayCondVo.setVvd(searchVvdCd);
					bayCondVo.setLastpol(vo.getLPol());
					bayCondVo.setCntrNo(vo.getCntrNo());
					// 컨테이너별로 BayPlan을 조회하는 DBDAO 호출.
					bayDetailVo = dbDao.searchBayPlanCntrList(bayCondVo);
					if (bayDetailVo != null)
					{
						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTRNBR:").append(bayDetailVo.getCntrNo()).append("\n");
						flatFile.append("CNTRTYPE:").append(bayDetailVo.getCntrtype()).append("\n");
						flatFile.append("FM_IND:").append(bayDetailVo.getFmInd()).append("\n");
						flatFile.append("CNTR_STATUS:").append("\n");
						flatFile.append("EQA_UNIT:").append("\n");
						flatFile.append("EQA_VAL:").append("\n");
						flatFile.append("STW_POS:").append(bayDetailVo.getPos()).append("\n");
						flatFile.append("WGT_UNIT:").append("KGM").append("\n");
						flatFile.append("WGT_VAL:").append(bayDetailVo.getWgt()).append("\n");
						flatFile.append("OVF_IND:").append("\n");
						flatFile.append("OVF_VAL:").append("\n");
						flatFile.append("OVR_IND:").append("\n");
						flatFile.append("OVR_VAL:").append("\n");
						flatFile.append("OVLW_IND:").append("\n");
						flatFile.append("OVLW_VAL:").append("\n");
						flatFile.append("OVRW_IND:").append("\n");
						flatFile.append("OVRW_VAL:").append("\n");
						flatFile.append("OVH_IND:").append("\n");
						flatFile.append("OVH_VAL:").append("\n");
						flatFile.append("TUNIT:").append("\n");
						flatFile.append("TEMP:").append("\n");
						flatFile.append("TEMP_MIN:").append("\n");
						flatFile.append("TEMP_MAX:").append("\n");
						flatFile.append("POR:").append(bayDetailVo.getPor()).append("\n");
						flatFile.append("POL:").append(bayDetailVo.getPol()).append("\n");
						flatFile.append("POD:").append(bayDetailVo.getPod()).append("\n");
						flatFile.append("DEL:").append(bayDetailVo.getDel()).append("\n");
						flatFile.append("REF_NO:").append("\n");
						flatFile.append("IMDG_CD:").append(bayDetailVo.getImdg()).append("\n");
						flatFile.append("PAGE:").append("\n");
						flatFile.append("UNNBR:").append(bayDetailVo.getUnno()).append("\n");
						flatFile.append("FLSH_UNIT:").append("\n");
						flatFile.append("FLSH_TEMP:").append("\n");
						flatFile.append("CLASS:").append("\n");
						flatFile.append("EMS:").append("\n");
						flatFile.append("MFAG:").append("\n");
						flatFile.append("SCAC:").append(bayDetailVo.getScac()).append("\n");
						flatFile.append("}CNTR_INFO").append("\n");
					}
					// 조회결과를 배열에 Set up.
					bayDetailVos[i] = bayDetailVo;
				}
				// BKG_CSTMS_ADV_STWG_SND_LOG 입력을 위한 VO.
				String seq = dbDao.searchDateSeq();
				// Message Header를 위한 seq 변형.
				// -> DB에는 yyyymmddhh24miss#####(시퀀스5자리)로 들어가지면 헤더에 출력할때는 yymmdd#####의 형태로 되어야 한다.
				flatFile.insert(0, command2.searchCstmsEdiHeaderNew("US_BAPLIE")).append("\n");
				String lsDate = dbDao.searchSysdate("yyyymmddhh24miss");
				SendDetailLogVO sendDetailLogVO = new SendDetailLogVO();
				sendDetailLogVO.setSndProcId("STW");
				sendDetailLogVO.setSeq(seq);
				sendDetailLogVO.setVvd(condVvd);
				sendDetailLogVO.setPol(lastpol);
				sendDetailLogVO.setUsrId(usrId);
				sendDetailLogVO.setOfcCd(ofcCd);
				sendDetailLogVO.setCntrCount(Integer.toString(manifestTransmitVOs.length));
				sendDetailLogVO.setSndDt(lsDate);
				// POD는 Row중 첫번째 POD로 지정한다. 이 방법은 추후 확인을 받아야 한다.
				// 조회조건상의 POD를 입력한다. 없으면 안 넣는다.
				sendDetailLogVO.setPod(pod);
				if (vslVo != null)
					sendDetailLogVO.setCstmsPortCd(vslVo.getUsPortCd());	// CSTMS_PORT_CD 칼럼 추가

				// BKG_CSTMS_ADV_STWG_SND_LOG 입력 실행.
				int result = dbDao.addStowageSendLog(sendDetailLogVO);
				if (result > 0)
				{
					StringTokenizer token = new StringTokenizer(flatFile.toString(), "\n");
					int i = 1;
					int j = 0; // 개행문자를 j 가 0보다 큰경우, 구문 앞에 추가한다.
					String tmpStr = "";
					String lineStr = "";
					StringBuffer lineBuf = new StringBuffer();
					while (token.hasMoreTokens())
					{
						tmpStr = token.nextToken();
						if (j > 0)
							tmpStr = "\n" + tmpStr;
						lineStr = lineBuf.toString();
						lineBuf.append(tmpStr);
						// 4000Byte 까지 채운다.
						// tmpStr까지 합친 값이 3900바이트를 넘는다면, 이전까지 취합되었던 lineStr만을
						// 로그에 넣고, 다시 초기화 한다.
						if (lineBuf.length() > 3900)
						{
							sendDetailLogVO.setDtlSeq(i + "");
							sendDetailLogVO.setMsg(lineStr);
							dbDao.addSendDetailLog(sendDetailLogVO);
							i++;
							lineBuf = new StringBuffer(tmpStr);
						}
						j++;
					}
					if (lineBuf.length() > 0)
					{
						sendDetailLogVO.setDtlSeq(i + "");
						sendDetailLogVO.setMsg(lineBuf.toString());
						dbDao.addSendDetailLog(sendDetailLogVO);
					}
				}
				result = 0;
				SendLogDetailVO sendLogDetailVO = new SendLogDetailVO();
				;
				// ams_stowplan Proc파일에서는 전달받은 컨테이너 번호를 다시 한번 루프돌려 조회하는 로직.
				// 그러나, 조회내용이 위에서 조회한 searchBayPlanCntrList 와 동일하므로 이를 생략하고,
				// 위에서 구한 bayDetailVos로 루프를 돌려 이후 로직을 구현한다.
				for (int i = 0; i < bayDetailVos.length; i++)
				{
					bayDetailVo = new BayPlanCntrDetailVO(); // 초기화.
					bayDetailVo = bayDetailVos[i];
					// BKG_CSTMS_ADV_STWG_CNTR 갱신및 입력을 위한 VO.
					sendLogDetailVO.setCntrNo(bayDetailVo.getCntrNo());
					sendLogDetailVO.setDel(bayDetailVo.getDel());
					sendLogDetailVO.setLastpol(lastpol);
					sendLogDetailVO.setOfcCd(ofcCd);
					sendLogDetailVO.setPod(bayDetailVo.getPod());
					sendLogDetailVO.setPol(bayDetailVo.getPol());
					sendLogDetailVO.setPos(bayDetailVo.getPos());
					sendLogDetailVO.setSeq(seq);
					sendLogDetailVO.setUsrId(usrId);
					sendLogDetailVO.setVvd(searchVvdCd);
					// BKG_CSTMS_ADV_STWG_CNTR 갱신 실행.
					result = dbDao.modifySendLogByCntr(sendLogDetailVO);
					if (result == 0)
					{
						result = dbDao.addSendLogByCntr(sendLogDetailVO);
					}
				}
			}
			/*********************************************
			 * // Message Send Start
			 *********************************************/
			FlatFileAckVO flatFileAckVO = null;
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMS.IBMMQ.QUEUE"));
			sendFlatFileVO.setFlatFile(flatFile.toString());
			flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			/*********************************************
			 * // Message Send End.
			 *********************************************/
			log.info(flatFile.toString());
			return flatFile.toString();
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob을 실행.
	 *
	 * @param account SignOnUserAccount
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVO, String pgmNo)
			throws EventException {
		try
		{
			UsaCustomsTransmissionBackEndJob backEndJob = new UsaCustomsTransmissionBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			String resultStr = "";
			if (pgmNo.equals("ESM_BKG_1023"))
			{
				backEndJob.setStiDetailVO((StiDetailVO[]) manifestTransmitVO);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Vessel Stowage Plan Transmit.");
			}
			else if (pgmNo.equals("ESM_BKG_0613"))
			{
				backEndJob.setUsaManifestSearchDetailVO((UsaManifestSearchDetailVO[]) manifestTransmitVO);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "MI Transmit.");
			}
			else if (pgmNo.equals("ESM_BKG_0408"))
			{
				backEndJob.setUsaManifestSearchDetailVO((UsaManifestSearchDetailVO[]) manifestTransmitVO);
				backEndJob.setAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "P/MIB Generate(AI) Transmit.");
			}
			return resultStr;
			// DAO 호출이 없으므로 DAOException을 catch하는 부분은 생략한다.
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EDI 수신으로 받은 문자열을 Parsing 하여 msg_tp값에 따라서 서로 다른 DAO 메소드를 호출한다.
	 *
	 * @param RcvMsgVO rcvMsgVO
	 * @return RcvMsgVO
	 * @throws EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) {
		UsaRcvMsgVO usaRcvMsgVO = (UsaRcvMsgVO) rcvMsgVO;
		String rcvMsg = usaRcvMsgVO.getRcvMsg();
		log.error("\nUS RCV Start===\n" + rcvMsg);

		cstmsHlds = new ArrayList<CstmsHldVO>();
		cstmsClrs = new ArrayList<CstmsClrVO>();
		cstmsHldSends = new ArrayList<CstmsHldVO>();
		bkgCstmsAdvIbdVOs = new ArrayList<BkgCstmsAdvIbdVO>();
		emlNtfcBlInfoVOs = new ArrayList<EmlNtfcBlInfoVO>();

//		rcvMsg = rcvMsg.replaceAll("\r\n", "\n");
//		// 80Byte로 만들어 준다. (alps로직을 고치지 않기 위해)
//		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");
//		String newRcvMsg = "";
//		String header = "";
//		while (token.hasMoreTokens())
//		{
//			String msgline = token.nextToken();
//			if (msgline.indexOf("$$$") == -1)
//			{
//				if ("".equals(newRcvMsg))
//					newRcvMsg = getDigitBlank(msgline, 80, " ", "R");
//				else
//					newRcvMsg = newRcvMsg + "\n" + getDigitBlank(msgline, 80, " ", "R");
//			}
//			else
//			{
//				header = msgline;
//			}
//		}
//		rcvMsg = newRcvMsg;

		try
		{
//			ArrayList<String> msgList = new ArrayList<String>();
//			for (int i = 0; i < rcvMsg.length(); i++)
//			{
//				newRcvMsg = rcvMsg.substring(i);
//				int acrIdx = newRcvMsg.substring(3).indexOf("ACR");
//
//				if (acrIdx != -1)
//				{
//					msgList.add(newRcvMsg.substring(0, acrIdx + 2));
//					i = i + acrIdx + 2;
//				}
//				else
//				{
//					acrIdx = newRcvMsg.indexOf("ACR");
//					if (acrIdx != -1)
//					{
//						msgList.add(newRcvMsg);
//						break;
//					}
//				}
//			}
//
//			for (int i=0; i<msgList.size(); i++)
//			{
//				emlNtfcBlInfoVOs = new ArrayList<EmlNtfcBlInfoVO>();
//				rcvMsg = header + "\n" + msgList.get(i);
//				usaRcvMsgVO = new UsaRcvMsgVO();
//				usaRcvMsgVO.setRcvMsg(rcvMsg);

				// RCV MSG 처리
				this.getAmsRcvMsg(rcvMsg, usaRcvMsgVO);

				// POL, VSL_CD 수정
				 if ("RC,SN".indexOf(usaRcvMsgVO.getIrType()) >= 0) {
					 dbDao.modifyBkgCstmsAdvRcvLog(usaRcvMsgVO, "RC");
				 } else if ("HR".equals(usaRcvMsgVO.getIrType())) {
					 dbDao.modifyBkgCstmsAdvRcvLog(usaRcvMsgVO, "HR");
				 } else {
					 dbDao.modifyBkgCstmsAdvRcvLog(usaRcvMsgVO, "BL");
				 }

				/******************************************************************************/
				/* 20091103, ISF5로 구동한 메시지는 이후 로직을 태우지 않는다. */
				/******************************************************************************/
				if ("".equals(usaRcvMsgVO.getIsfInBl()))
				{
					BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
					if (bkgCstmsAdvBlVO != null)
					{
						if ("".equals(bkgCstmsAdvBlVO.getMfNo()))
						{
							usaRcvMsgVO.setMasterOrHouse("M");
							usaRcvMsgVO.setMblNo(usaRcvMsgVO.getBlNo());
						}
						else
						{
							usaRcvMsgVO.setMasterOrHouse("H");
							usaRcvMsgVO.setMblNo(bkgCstmsAdvBlVO.getMfNo());
							usaRcvMsgVO.setHblNo(usaRcvMsgVO.getBlNo());
							usaRcvMsgVO.setBlNo(bkgCstmsAdvBlVO.getMfNo());
						}

						if (ConstantMgr.getScacCode().equals(usaRcvMsgVO.getInSnp()))
						{
							if ("H".equals(usaRcvMsgVO.getMasterOrHouse()))
							{
								this.getAmsRcvMsgM(rcvMsg, usaRcvMsgVO);
							}
						}
						// 2016-12-06 Pushkar Goel : CPRS항목 추가 요청
						// B/P #22330 NSA - BKG - Incorrect C flag on Inbound C/A USA screen 
						else if ("CNRU".equals(usaRcvMsgVO.getInSnp()) || "CPRS".equals(usaRcvMsgVO.getInSnp()))
						{
							/* cnru_it가 Y이면 INBOND_TRANS에 CNRU B/L있는것이고, N이면 없는것이다... */
							/* 그래서 Y이면 위의 1ST 스테이지 Get_ams_rcv_msg를 제대로 다 수행했을테니 여기서 마치고 */
							/* N이면 Get_ams_rcv_msg_N을 수행한다. */
							if ("N".equals(usaRcvMsgVO.getCnruIt()))
							{
								this.getAmsRcvMsgN(rcvMsg, usaRcvMsgVO);
							}
						}
						else
						{
							// 추가 김민정
							this.getAmsRcvMsgN(rcvMsg, usaRcvMsgVO);
						}
					}
				}
				// 송신로그 테이블 수정(수신일자)
				if (!StringUtil.isEmpty(usaRcvMsgVO.getCrrBatNo()))
				{
					dbDao.modifyAdvSndLog(usaRcvMsgVO);
				}
log.error("\nUS RCV Send Email Start =====");
				this.sendEml(usaRcvMsgVO);
//			}
		}
		catch (Exception ex)
		{
			log.error(new ErrorHandler("BKG00707", new String[] { "US Receive " + "MSG["+rcvMsg+"]" }).getMessage());
			log.error("US Receive Error Message!! ["+ex.getMessage()+"]");
			log.error(StringUtilities.getErrorStackString(ex));
		}

		return usaRcvMsgVO;
	}

	/**
	 * 수신결과에 따른 메일전송 (MR, AR, TR) <br>
	 * BKG_CSTMS_ADV_RSLT의 마지막에 설정된 값을 확인한다. <br>
	 * 1. Rejection : "W01"이 들어온경우 <br>
	 * 2. DNL : CSTMS_CLR_CD = "H" and DSPO_CD = "2Q" <br>
	 * 3. DNL Removal : CSTMS_CLR_CD != "H" and DSPO_CD = "4Q" <br>
	 * 4. Hold : CSTMS_CLR_CD = "H" and 그전이 "H"가 아닌경우 <br>
	 * 5. Hold Removal : CSTMS_CLR_CD != "H" and 그전이 "H"인 경우 <br>
	 * <br>
	 * 수신결과에 따른 메일전송 (HR) <br>
	 * 1. Rejection : "W01"이 들어온경우 <br>
	 *
	 * @param usaRcvMsgVO
	 */
	private void addEmlNtfc(UsaRcvMsgVO usaRcvMsgVO) {
		try {
			String strEmlType = "";

			if (!StringUtil.isEmpty(usaRcvMsgVO.getBlNo())) {
				String dspoTpCd = "";
				if (!StringUtil.isEmpty(usaRcvMsgVO.getIcrCode())) {
					UsaCustomsReportBC report = new UsaCustomsReportBCImpl();
					List<DispoCdDetailVO> dispoList = report.searchDispositionCdList();
					for (int i = 0; i < dispoList.size(); i++) {
						if (dispoList.get(i).getCstmsDspoCd().equals(usaRcvMsgVO.getIcrCode()))
							dspoTpCd = dispoList.get(i).getDspoTpCd();
					}
				}
				if ("2Q".equals(usaRcvMsgVO.getIcrCode()) || "2R".equals(usaRcvMsgVO.getIcrCode())|| "6H".equals(usaRcvMsgVO.getIcrCode()) ) {
					// DNL : dspoTpCd = HL
					strEmlType = "04";
				} else if ("4Q".equals(usaRcvMsgVO.getIcrCode()) || "4R".equals(usaRcvMsgVO.getIcrCode()) || "6I".equals(usaRcvMsgVO.getIcrCode()) ) {
					// DNL Removal
					strEmlType = "05";
				} else if ("HM".equals(dspoTpCd) || "HP".equals(dspoTpCd)) {
					// Hold
					strEmlType = "06";
				} else if ("RL".equals(dspoTpCd) || ("CX".equals(dspoTpCd) && !"4E".equals(usaRcvMsgVO.getIcrCode())) ) {
					// Hold Removal
					strEmlType = "07";
				}
			}

			if (!"".equals(strEmlType)) {
				EmlNtfcBlInfoVO emlNtfcBlInfoVO = dbDao.searchEmlNtfcBlInfo(usaRcvMsgVO);
				emlNtfcBlInfoVO.setEmlType(strEmlType);

				boolean addFlag = true;
				for (int i = 0; i < emlNtfcBlInfoVOs.size(); i++) {
					if (emlNtfcBlInfoVOs.get(i).getBlNo().equals(emlNtfcBlInfoVO.getBlNo()) && emlNtfcBlInfoVOs.get(i).getEmlType().equals(strEmlType)) {
						addFlag = false;
					}
				}
				if (addFlag)
					emlNtfcBlInfoVOs.add(emlNtfcBlInfoVO);
			}
		} catch (Exception e) {
			log.error(new ErrorHandler("BKG00707", new String[] { "US Recieve Mail Send " }).getMessage());
		}
	}

	/**
	 * email notification
	 * @param usaRcvMsgVO
	 */
	private void sendEml(UsaRcvMsgVO usaRcvMsgVO) {

		try {
			for (EmlNtfcBlInfoVO emlInfo : emlNtfcBlInfoVOs) {
				TemplateMail template = new TemplateMail();
				String strSubject = "US24 - ";

				CstmsEmlNtfcVO emlParam = new CstmsEmlNtfcVO();
				emlParam.setCntCd("US");
				emlParam.setEdiMsg("AMS");
				emlParam.setPolCd(emlInfo.getCstmsPolCd());
				emlParam.setPodCd(emlInfo.getCstmsPodCd());

				if ("03".equals(emlInfo.getEmlType())) {
					emlParam.setEdiMsgTpId("Rejection(Error)");

					strSubject = strSubject + "Rejection : " + emlInfo.getCstmsPodCd() + "(POD)-" + emlInfo.getCstmsPolCd() + "(POL)-" + emlInfo.getBlNo();

					this.setTemplateArg(template, usaRcvMsgVO, emlInfo, true, true, false, false, true, true, true, false, true);
				} else if ("04".equals(emlInfo.getEmlType())) {
					emlParam.setEdiMsgTpId("DNL/DNL Removals");

					strSubject = strSubject + "Do Not Load : " + emlInfo.getCstmsPodCd() + "(POD)-" + emlInfo.getCstmsPolCd() + "(POL)-" + emlInfo.getBlNo();

					this.setTemplateArg(template, usaRcvMsgVO, emlInfo, true, true, true, true, true, true, true, true, true);
				} else if ("05".equals(emlInfo.getEmlType())) {
					emlParam.setEdiMsgTpId("DNL/DNL Removals");

					strSubject = strSubject + "Do Not Load Removal : " + emlInfo.getCstmsPodCd() + "(POD)-" + emlInfo.getCstmsPolCd() + "(POL)-" + emlInfo.getBlNo();

					this.setTemplateArg(template, usaRcvMsgVO, emlInfo, true, true, true, true, true, true, true, true, false);
				} else if ("06".equals(emlInfo.getEmlType())) {
					emlParam.setEdiMsgTpId("Hold/Hold Removals");

					strSubject = strSubject + "Hold : " + emlInfo.getCstmsPodCd() + "(POD)-" + emlInfo.getCstmsPolCd() + "(POL)-" + emlInfo.getBlNo();

					this.setTemplateArg(template, usaRcvMsgVO, emlInfo, true, true, true, true, true, true, true, true, true);
				} else if ("07".equals(emlInfo.getEmlType())) {
					emlParam.setEdiMsgTpId("Hold/Hold Removals");

					strSubject = strSubject + "Hold Removal : " + emlInfo.getCstmsPodCd() + "(POD)-" + emlInfo.getCstmsPolCd() + "(POL)-" + emlInfo.getBlNo();

					this.setTemplateArg(template, usaRcvMsgVO, emlInfo, true, true, true, true, true, true, true, true, false);
				} else if ("11".equals(emlInfo.getEmlType())) {
					emlParam.setEdiMsg("AMS VSL Departure");
					emlParam.setEdiMsgTpId("Rejection(Error)");

					strSubject = strSubject + "Vessel departure Rejection : " + emlInfo.getCstmsPolCd() + "(POL)-" + usaRcvMsgVO.getVslCd() + usaRcvMsgVO.getSkdVoyNo() + usaRcvMsgVO.getSkdDirCd()
							+ ">";

					this.setTemplateArg(template, usaRcvMsgVO, emlInfo, true, false, false, false, false, true, false, false, true);
				}

				/***************************************
				 * 수신처 조회
				 ***************************************/
				CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
				CstmsEmlNtfcVO eml = comBc.searchCstmsEmlNtfcInfo(emlParam);

				String toEmlCtnt = eml.getToEmlCtnt() + ";nyktest@cyberlogitec.com";
				if (emlInfo.getUsrEml() != null && !"".equals(emlInfo.getUsrEml()))
				{
					if (eml.getToEmlCtnt().indexOf(emlInfo.getUsrEml()) < 0 && eml.getCcEmlCtnt().indexOf(emlInfo.getUsrEml()) < 0)
					{
						toEmlCtnt = toEmlCtnt + ";" + emlInfo.getUsrEml();
					}
				}
				/***************************************
				 * Mail Template
				 ***************************************/
				template.setHtmlTemplate("ESM_BKG_RCV_EML_US" + emlInfo.getEmlType() + "T.html");
				template.setBatFlg("N");
				template.setFrom("noreply@cyberlogitec.com", "CTM EDI Monitor");
				template.setRecipient(toEmlCtnt);
				template.setCcRcvrEml(eml.getCcEmlCtnt());
				template.setSubject(strSubject);
				template.send();
			}
		} catch (Exception e) {
			log.error("US Recieve Mail Send " + e.getStackTrace());
		}
	}

	/**
	 * Mail Template Argument 설정
	 * @param template
	 * @param vvd
	 */
	private void setTemplateArg(TemplateMail template, UsaRcvMsgVO usaRcvMsgVO, EmlNtfcBlInfoVO emlNtfcBlInfoVO,
			boolean vvd,
			boolean blNo,
			boolean shipper,
			boolean consignee,
			boolean ofcNm,
			boolean pol,
			boolean pod,
			boolean container,
			boolean reason) throws Exception
	{
		if (vvd)
		{
			template.setArg("vvd", usaRcvMsgVO.getVslCd() + usaRcvMsgVO.getSkdVoyNo() + usaRcvMsgVO.getSkdDirCd());
		}
		if (blNo)
		{
			template.setArg("blNo", (emlNtfcBlInfoVO.getBlNo() == null) ? "" : emlNtfcBlInfoVO.getBlNo());
		}
		if (shipper)
		{
			template.setArg("shipper", (emlNtfcBlInfoVO.getShipper() == null) ? "" : emlNtfcBlInfoVO.getShipper());
		}
		if (consignee)
		{
			template.setArg("consignee", (emlNtfcBlInfoVO.getConsignee() == null) ? "" : emlNtfcBlInfoVO.getConsignee());
		}
//		if (ofcNm)
//		{
//			template.setArg("ofcNm", (emlNtfcBlInfoVO.getOfcEngNm() == null) ? "" : emlNtfcBlInfoVO.getOfcEngNm());
//		}
		if (pol)
		{
			template.setArg("pol", (emlNtfcBlInfoVO.getCstmsPolCd() == null) ? "" : emlNtfcBlInfoVO.getCstmsPolCd());
		}
		if (pod)
		{
			template.setArg("pod", (emlNtfcBlInfoVO.getCstmsPodCd() == null) ? "" : emlNtfcBlInfoVO.getCstmsPodCd());
		}
		if (container)
		{
			template.setArg("container", (usaRcvMsgVO.getCntrList() == null) ? "" : usaRcvMsgVO.getCntrList());
		}
		if (reason)
		{
			String strReason = usaRcvMsgVO.getReason();
			if (StringUtil.isEmpty(strReason))
			{
				strReason = emlNtfcBlInfoVO.getReason();
				if (StringUtil.isEmpty(strReason))
				{
					if (usaRcvMsgVO.getIcrRemark1() != null)
						strReason = usaRcvMsgVO.getIcrRemark1().trim() + " ";
					if (usaRcvMsgVO.getRemark2() != null)
						strReason = strReason + usaRcvMsgVO.getRemark2().trim() + " " ;
					if (usaRcvMsgVO.getRemark3() != null)
						strReason = strReason + usaRcvMsgVO.getRemark3().trim();
				}
			}
			template.setArg("reason", strReason);
		}
	}

	/**
	 *
	 * @param strEmlType
	 * @param blNo
	 * @param usaRcvMsgVO
	 */
	private void addEmlNtfcW01 (String blNo, UsaRcvMsgVO usaRcvMsgVO) {
		try {

			List<EmlNtfcBlInfoVO> listEml = dbDao.searchEmlNtfcW01Info(blNo, usaRcvMsgVO.getCrrBatNo());

			for (int i = 0; i < listEml.size(); i++) {
				boolean addFlag = true;
				for (int j=0; j<emlNtfcBlInfoVOs.size(); j++) {
					if (emlNtfcBlInfoVOs.get(j).getBlNo().equals(listEml.get(i).getBlNo()) && emlNtfcBlInfoVOs.get(j).getEmlType().equals(listEml.get(i).getEmlType())) {
						addFlag = false;
						break;
					}
				}
				if (addFlag)
					emlNtfcBlInfoVOs.add(listEml.get(i));
			}

		} catch(Exception e) {
			log.error("US Recieve Mail Send " + e.getStackTrace());
		}
	}

	/**
	 * 메시지를 순서에 따라 처리한다<br>
	 *
	 * @param String msg
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws EventException
	 */
	private int getAmsRcvMsg(String msg, UsaRcvMsgVO usaRcvMsgVO) {
		int r = 0;
		usaRcvMsgVO.setIsfInBl("");
		List<String> isfInRemark = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(msg, "\n");
		String prefix3 = "";
		String prefix4 = "";
		StringBuffer cntrList = new StringBuffer();
		cntrList.setLength(0);

		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			if (str != null && str.length() >= 80)
			{
				prefix3 = str.substring(0, 3);
				prefix4 = str.substring(0, 4);
				if ("ACR".equals(prefix3))
				{
					usaRcvMsgVO.setIrType(str.substring(13, 15));
					usaRcvMsgVO.setIrDate(str.substring(15, 27));
					usaRcvMsgVO.setIrBatchNo(str.substring(27, 32));
				}
				else if ("M01".equals(prefix3))
				{
					usaRcvMsgVO.setInSnp(str.substring(3, 7));
					usaRcvMsgVO.setVslEngNm(str.substring(11, 34));
					// M02가 들어오지 않는 경우(RC, SN 등)
					usaRcvMsgVO.setSkdVoyNo(str.substring(34, 38));
					usaRcvMsgVO.setSkdVoyNoM(str.substring(34, 39));
					usaRcvMsgVO.setSkdDirCd(str.substring(38, 39));
					usaRcvMsgVO.setLloydNo(str.substring(51, 58));

					// NYK의 OSCAR 시스템과 병행할 때 voy no 자리수가 4자리여서 앞의 0을 삭제하고 전송한다.
					// 향후 OSCAR 시스템을 사용하지 않으면 voy no 를 5자리로 하기 때문에 아래 if 문은 필요가 없어진다.
					if ("".equals(usaRcvMsgVO.getSkdDirCd().trim()))
					{
						String voy = usaRcvMsgVO.getSkdVoyNo().substring(3);
						String voy2 = usaRcvMsgVO.getSkdVoyNo().substring(0, 3);
						usaRcvMsgVO.setSkdDirCd(voy);
						usaRcvMsgVO.setSkdVoyNo("0" + voy2);
					}
				}
				else if ("M02".equals(prefix3))
				{
					/******************************************************
					 * 2009/11/10 하동일 수석 : MO2 이후 30자리에 대해 파싱처리한 후<BR>
					 * bkg_cstms_adv_rcv_log.crr_bat_no 에 넣을 수 있도록 추가 요청함.<BR>
					 * as-is 에는 없는 부분임.<BR>
					 * 참고로, 실제 운영되는 메시지 중에는 W02 도 있으나,<BR>
					 * as-is 에도 처리내역이 없기에 하수석과 확인한 후 넘어감.
					 ******************************************************/
					usaRcvMsgVO.setCrrBatNo(str.substring(3, 33));
					usaRcvMsgVO.setVslCd(str.substring(7, 11));
					usaRcvMsgVO.setSkdVoyNo(str.substring(11, 15));
					usaRcvMsgVO.setSkdDirCd(str.substring(15, 16));
					usaRcvMsgVO.setSkdVoyNoM(str.substring(11, 16));
				}
				else if ("P01".equals(prefix3))
				{
					usaRcvMsgVO.setPodAmsport(str.substring(3, 7));
					usaRcvMsgVO.setPodAmsportM(str.substring(3, 7));
					usaRcvMsgVO.setLocAmsPortCd(str.substring(3, 7));
				}
				else if ("R01".equals(prefix3))
				{
					usaRcvMsgVO.setPodAmsport(str.substring(7, 11));
					usaRcvMsgVO.setPodAmsportM(str.substring(7, 11));
					usaRcvMsgVO.setLocAmsPortCd(str.substring(7, 11));
				}
				else if ("R02".equals(prefix3))
				{
					r++;
					if (r % 2 == 0)
					{
						if (str.substring(11, 12).equals(" ") || str.substring(11, 15).equals("0000"))
						{
							usaRcvMsgVO.setCusAmsport(str.substring(3, 7));
						}
						else
						{
							usaRcvMsgVO.setDestLocCd(str.substring(3, 7));
							usaRcvMsgVO.setCusAmsport(str.substring(11, 15));
						}
					} else {
						usaRcvMsgVO.setAcpDate(str.substring(44, 54));
					}
				}
				/*********************************************/
				/* 2011.04.27  'C01 항목으로 리스팅 된 Cntr 에 대해 R03 의 Remark 를 표기' 처리를 위해 추가함. */
				/*********************************************/
				else if ("R03".equals(prefix3))
				{
					usaRcvMsgVO.setCstmsRmk1(str.substring(3,53));
				}
				/*********************************************/
				/* 2011.04.27  'C01 항목으로 리스팅 되지 않은 CNTR 에 대해 해당 VVD의 BAPLIE 전송이력이 있는 CNTR 는 모두 ACK 로 표기' 처리를 위해 추가함. */
				/*********************************************/
				else if ("R06".equals(prefix3))
				{
					if ("INC".equals(str.substring(3, 6)) || "ACC".equals(str.substring(3, 6))){
						usaRcvMsgVO.setIsBaplieRC("Y");
					}
				}
				/*********************************************/
				/* 20091028 JHPARK ISF-5 처리를 위해 추가함. */
				/*********************************************/
				else if ("SF10".equals(prefix4))
				{
					usaRcvMsgVO.setIsfTranNo(str.substring(38, 53));
				}
				else if ("SF15".equals(prefix4))
				{
					usaRcvMsgVO.setIsfInBl(str.substring(10, 22).replaceAll(" ", ""));
				}
				else if ("SF90".equals(prefix4))
				{
					usaRcvMsgVO.setIsfRcvCd(str.substring(4, 6));
					isfInRemark.add(str.substring(9, 49));
				}

			} // if str valid
		}// while msg tokenized
		if (isfInRemark.size() > 0)
		{
			usaRcvMsgVO.setIsfInRemark1(isfInRemark.get(0));
			if (isfInRemark.size() > 1)
			{
				usaRcvMsgVO.setIsfInRemark2(isfInRemark.get(1));
			}
		}
		if ("".equals(usaRcvMsgVO.getIrDate()))
		{
			usaRcvMsgVO.setIrDate(dbDao.searchSysdate("RRMMDDHH24MISS"));
		}
		/***************************************************************************
		 * VSL CD 는 M01의 VSL NAME or Lloyd No 로 찾을 수 있지만 MDM VSL Lloyd No 가 중복되기 때문에 정확하지 않을 수 있다 <br>
		 * RC, SN 의 경우 M02가 수신되지 않기 때문에 BKG_CSTMS_ADV_RSLT 를 넣은 후 <br>
		 * BL_NO 로 VSL CD를 찾고 거기도 없을 경우  Lloyd No 로 찾아 VSL_CD 를 UPDATE 하는 방식으로 로직을 보완한다.<br>
		 * 한진해운은 SN의 경우 'UNKNOWN00' 로 들어가지만 NYK의 경우 BL의 VSL CD 를 넣을 수 있다.<BR>
		 * VSL CD 찾는 부분은 삭제
		 ***************************************************************************/

		String podLoc = "";
		String podLocM = "";
		// podAmsport에 의해 mdm_location에서 pod_cd를 구하는 로직이나,
		// ISF-5등에서는 podAmsport가 ""이므로 실행해도 의미가 없다.
		if (!"".equals(usaRcvMsgVO.getLocAmsPortCd()))
		{
			UsaLocationVO usaLocationVO = dbDao.searchLocCdByAmsPort(usaRcvMsgVO);
			if (usaLocationVO != null)
			{
				podLoc = usaLocationVO.getLocCd();
				podLocM = usaLocationVO.getLocCd();
			}
		}
		usaRcvMsgVO.setPodLoc(podLoc);
		usaRcvMsgVO.setPodLocM(podLocM);
		if (!"".equals(usaRcvMsgVO.getCusAmsport()))
		{
			UsaLocationVO usaLocationVO = dbDao.searchLocCdForCustomsLoc(usaRcvMsgVO);
			if (usaLocationVO != null)
			{
				usaRcvMsgVO.setCusLoc(usaLocationVO.getLocCd());
			}
		}
		usaRcvMsgVO.setIrDateM(usaRcvMsgVO.getIrDate());
		usaRcvMsgVO.setIrSeq(dbDao.searchMaxIrSeq(usaRcvMsgVO));
		// BKG_CSTMS_ADV_RCV_LOG insert
		dbDao.addRcvLogMst(usaRcvMsgVO);
		// BKG_CSTMS_ADV_RCV_LOG_DTL insert
		token = new StringTokenizer(msg, "\n");
		int k = 0;
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			k++;
			usaRcvMsgVO.setRcvMsgDtlSeq(Integer.toString(k));
			usaRcvMsgVO.setMsgDesc(str);
			dbDao.addRcvLogDetail(usaRcvMsgVO);
		}
		log.error("\nUS RCV LOG Detail Insert Success=====");
		/******************************************************************************/
		/* PARSE DETAIL RECORD */
		/******************************************************************************/
		/******************************************************************************/
		/* 02 Filer의 NVOCC H B/L 인 경우를 대비하여, */
		/* 첫번째 R02의 B/L을 NVOCC house B/L로 가지고, */
		/* 두번째 R02의 B/L을 00 master B/L로 가지고 있는다. */
		/******************************************************************************/
		/******************************************************************************/
		/* R05의 CNTR 정보를 가져 온다. (as-is 소스의 R02, R05 를 구하는 로직을 to-be에서는 통합함. */
		/******************************************************************************/
		token = new StringTokenizer(msg, "\n");
		r = 0;
		String inNvobl = "";
		String inHjbl = "";
		String inCntr = "";
		int cntrCnt = 0;
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			if (str != null && str.length() >= 80)
			{
				prefix3 = str.substring(0, 3);
				if ("R02".equals(prefix3) && r == 0)
				{
					inNvobl = str.substring(3, 15).replaceAll(" ", "");
					r++;
				}
				else if ("R02".equals(prefix3) && r == 1)
				{
					inHjbl = str.substring(40, 57).replaceAll(" ", "");
					r++;
				}
				else if ("R05".equals(prefix3))
				{
					inCntr = str.substring(3, 14);
					inCntr = dbDao.searchCntrNo(inCntr);

					if (cntrCnt == 0){
						cntrList.append(inCntr);
					}else{
						cntrList.append(",").append(inCntr);
					}
					cntrCnt ++;
				}
			} // if str valid
		}// while msg tokenized
		usaRcvMsgVO.setCntrList(cntrList.toString());
		usaRcvMsgVO.setInNvobl(inNvobl);
		usaRcvMsgVO.setInHjbl(inHjbl);
		usaRcvMsgVO.setInCntr(inCntr);
		/******************************************************************************/
		/* 20091028 JHPARK ISF-5 별도로 inbond_customs_r table 에 저장한다. */
		/******************************************************************************/
		if (!"".equals(usaRcvMsgVO.getIsfInBl()) && isfInRemark.size() > 0 && !"".equals(isfInRemark.get(0)))
		{
			this.putCustomsRIsf(usaRcvMsgVO);
		}
		/******************************************************************************/
		/* 레코드 ID별로 실제적으로 메시지 처리 하는 부분 시작 */
		/******************************************************************************/
		String zone = "";
		String inCode = "";
		String inCodeb = "";
		String icrResendInd = "";
		String cntrNo = "";
		String chkStrForBlNo = "";
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
		token = new StringTokenizer(msg, "\n");

		String cloneToken[] = msg.split("\n");
		int cloneTokenIdx = 0;

		r = 0;
		int iR03 = 0;

		cstmsLocDiffFlg = "N";

		while (token.hasMoreTokens())
		{
			String str = token.nextToken();

			if (str != null && str.length() >= 80)
			{
				prefix3 = str.substring(0, 3);
				// W01 레코드 처리
				if ("W01".equals(prefix3))
				{
					usaRcvMsgVO.setRejectYn("Y");
					usaRcvMsgVO.setReason(str.substring(39).trim());
					this.putNakMsg(str, usaRcvMsgVO);
					BkgCstmsAdvBlVO blInfo = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
					if (blInfo == null) {
						List<BkgCstmsAdvBlVO> blInfos = dbDao.searchAdvCntr(usaRcvMsgVO);
						if (blInfos.size() == 0) {
							addEmlNtfcW01("", usaRcvMsgVO);
						} else {

							for (int i = 0; i < blInfos.size(); i++) {
								addEmlNtfcW01(blInfos.get(i).getBlNo(), usaRcvMsgVO);
							}
						}
					} else {
						addEmlNtfcW01(blInfo.getBlNo(), usaRcvMsgVO);
					}
				}
				else if ("R02".equals(prefix3))
				{
					zone = str.substring(6, 7);
					inCode = str.substring(15, 17);
					inCodeb = str.substring(7, 8);
					icrResendInd = str.substring(68, 69);
					chkStrForBlNo = str.substring(3, 15).replaceAll(" ", "");
					r++;
					usaRcvMsgVO.setZone(zone);
					usaRcvMsgVO.setInCode(inCode);
					usaRcvMsgVO.setInCodeb(inCodeb);
					usaRcvMsgVO.setIcrResendInd(icrResendInd);
					if (ConstantMgr.getScacCode().equals(usaRcvMsgVO.getInSnp()))
					{
						bkgCstmsAdvBlVO = dbDao.searchAdvBl(chkStrForBlNo, "US");
						/*****************************************************************************
						 * BL번호체계가 변경되므로, 아래 체크 로직을 BL테이블에 조회하여 결과가 있을경우로 수정함.<BR>
						 * by 김도완. 민수석 확인결과 'H'는 빠지는 것이 맞다고 함. <BR>
						 * 따라서, 하우스 BL인 경우는 제외함. <BR>
						 * => HOUSE B/L이더라도 putCustomsR을 태우고,
						 * putCustomsR에서 Cargo Release부분 만 태우지 않는 것으로 수정하기로 함.<BR>
						 * HOUSE B/L일때, 태우지 않으면, bl_no 변수 값을 가져올수가 없는 사유.
						 *****************************************************************************/
						if (bkgCstmsAdvBlVO != null)
						{

							/*
							 * icrCode = '1C', '12' 일 경우 destLocCd 셋팅
							 */
							if("1C".equals(inCode) || "12".equals(inCode)) {

								String r02_2 = cloneToken[cloneTokenIdx+1];
								if("R02".equals(r02_2.substring(0, 3))) {
									usaRcvMsgVO.setDestLocCd(r02_2.substring(3, 7));
								}

							}

							this.putCustomsR(str, usaRcvMsgVO);
							iR03 = 0;
						}
						else
						{
							if (usaRcvMsgVO.getIcrCode() != null && "13,52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
							{
								cntrNo = str.substring(23, 34);
								usaRcvMsgVO.setCntrNo(cntrNo);
								this.setAccpDate(usaRcvMsgVO);
							}
						}
					}
					else if ("CNRU".equals(usaRcvMsgVO.getInSnp()))
					{
						if ("0".indexOf(zone) >= 0)
						{
							this.putCustomsR(str, usaRcvMsgVO);
							iR03 = 0;
						}
					}
					else
					{
						if (!"  ".equals(inCode) && !"00".equals(inCode) && !" ".equals(inCodeb))
						{
							this.putCustomsR(str, usaRcvMsgVO);
							iR03 = 0;
						}
						else
						{
							cntrNo = str.substring(23, 34);
							usaRcvMsgVO.setCntrNo(cntrNo);
						}
					}
				}// R02
				/******************************************************************************/
				/* R03 레코드 처리 */
				/******************************************************************************/
				else if ("R03".equals(prefix3))
				{
					if (ConstantMgr.getScacCode().equals(usaRcvMsgVO.getInSnp()))
					{
						/******************************************************************************/
						/* 첫번째 R03 레코드 처리 */
						/******************************************************************************/
						if (iR03 == 0)
						{
							iR03 = 1;
							usaRcvMsgVO.setIcrRemark1(str.substring(3, 53));
							if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
							{
								usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
							}
							dbDao.modifyCustomsResult(usaRcvMsgVO);
						}// iR03 == 0
						/******************************************************************************/
						/* 두번째 R03 레코드 처리 */
						/******************************************************************************/
						else if (iR03 == 1)
						{
							iR03 = 2;
							this.putCustomsRemark(str, usaRcvMsgVO);
						}
						/******************************************************************************/
						/* 세번째 R03 레코드 처리 */
						/******************************************************************************/
						else if (iR03 == 2)
						{
							usaRcvMsgVO.setRemark3(str.substring(3, 53));
							if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
							{
								usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
							}
							/********************************************/
							/* icr_remark1으로 업데이트하게 되어 있어 */
							/* icr_remark3로 업데이트 하도록 수정 */
							/* 2006/3/21 민동진 수정 */
							/********************************************/
							dbDao.modifyCustomsResultForRemark3(usaRcvMsgVO);
						}
					}
					// 2016-12-06 Pushkar Goel : CPRS항목 추가 요청
					// B/P #22330 NSA - BKG - Incorrect C flag on Inbound C/A USA screen 
					else if ("CNRU".equals(usaRcvMsgVO.getInSnp()) || "CPRS".equals(usaRcvMsgVO.getInSnp()))
					{
						/******************************************************************************/
						/* 첫번째 R03 레코드 처리 */
						/******************************************************************************/
						if (iR03 == 0)
						{
							iR03 = 1;
							usaRcvMsgVO.setIcrRemark1(str.substring(3, 53));
							if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
							{
								usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
							}
							dbDao.modifyCustomsResult(usaRcvMsgVO);
						}// iR03 == 0
						/******************************************************************************/
						/* 두번째 R03 레코드 처리 */
						/******************************************************************************/
						else if (iR03 == 1)
						{
							iR03 = 2;
							this.putCustomsRemarkM(str, usaRcvMsgVO);
						}
						/******************************************************************************/
						/* 세번째 R03 레코드 처리 */
						/******************************************************************************/
						else if (iR03 == 2)
						{
							usaRcvMsgVO.setRemark3(str.substring(3, 53));
							if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
							{
								usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
							}
							/********************************************/
							/* icr_remark1으로 업데이트하게 되어 있어 */
							/* icr_remark3로 업데이트 하도록 수정 */
							/* 2006/3/21 민동진 수정 */
							/********************************************/
							dbDao.modifyCustomsResultForRemark3(usaRcvMsgVO);
						}
					}// inSnp.equals("CNRU")
				}// prefix.equals("R03")
				/*********************************************/
				/* 2011.04.27  C01 항목으로 리스팅 된 Cntr 에 대해 R03 의 Remark 를 표기 상태'R'-Reject */
				/*********************************************/
				else if( JSPUtil.getNull(usaRcvMsgVO.getIsBaplieRC()).equals("Y") && "C01".equals(prefix3))
				{
					usaRcvMsgVO.setCntrNo(str.substring(3, 14));//cntr_no
					dbDao.modifyBaplieRcvByCntr(usaRcvMsgVO);
				}
			} // if str valid

			cloneTokenIdx++;
		}// while msg tokenized

		/*********************************************/
		/* 2011.04.27  'C01 항목으로 리스팅 되지 않은 CNTR 에 대해 해당 VVD의 BAPLIE 전송이력이 있는 CNTR 는 모두 ACK 로 표기' 처리. */
		/*********************************************/
		if( JSPUtil.getNull(usaRcvMsgVO.getIsBaplieRC()).equals("Y"))
		{
			dbDao.modifyBaplieRcvByVvd(usaRcvMsgVO);
		}
		// 레코드 ID별로 실제적으로 메시지 처리 하는 부분 종료(for문)
		return 0;
	}

	/**
	 * Nak Msg를 처리한다.<br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putNakMsg(String str, UsaRcvMsgVO usaRcvMsgVO) {
		String blNo = str.substring(3, 15).replaceAll(" ", "");
		usaRcvMsgVO.setBlNo(blNo);
		usaRcvMsgVO.setIbdRstUpdateFlg("BL");
		try
		{
			downLoadBC.modifyResultCdByBl(usaRcvMsgVO);
			if ("CNRU".equals(usaRcvMsgVO.getInSnp()))
			{
				usaRcvMsgVO.setIbdRstUpdateFlg("HJBL");
				downLoadBC.modifyResultCdByBl(usaRcvMsgVO);
			}
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		return 0;
	}

	/**
	 * Nak Msg M를 처리한다.<br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putNakMsgM(String str, UsaRcvMsgVO usaRcvMsgVO) {
		usaRcvMsgVO.setIbdRstUpdateFlg("BL");
		try
		{
			downLoadBC.modifyResultCdByBl(usaRcvMsgVO);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		return 0;
	}

	/**
	 * Nak Msg N를 처리한다.<br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putNakMsgN(String str, UsaRcvMsgVO usaRcvMsgVO) {
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO2 = dbDao.searchAdvBl(usaRcvMsgVO.getInBl(), "US");
		if (bkgCstmsAdvBlVO2 != null)
		{
			try
			{
				usaRcvMsgVO.setBlNo(bkgCstmsAdvBlVO2.getBlNo());
				usaRcvMsgVO.setIbdRstUpdateFlg("BL");
				downLoadBC.modifyResultCdByBl(usaRcvMsgVO);
			}
			catch(Exception ex)
			{
				log.error(ex.getMessage());
			}
		}
		return 0;
	}

	/**
	 * AS-IS의 Put_Customs_R 를 처리한다.<br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsR(String str, UsaRcvMsgVO usaRcvMsgVO) {
		log.error("\nUS RCV Result Start=====");
		usaRcvMsgVO.setBlNo(str.substring(3, 15).replaceAll(" ", ""));
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
		if (bkgCstmsAdvBlVO == null)
		{
			// NVOCC 또는 CNRU의 경우 BL_NO 파싱에 차이가 있어 00 이후 또는 9525 이후 값으로 세팅시킴
			usaRcvMsgVO.setBlNo(usaRcvMsgVO.getInHjbl().substring(4, 16).replaceAll(" ", ""));
			bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
			if (bkgCstmsAdvBlVO == null)
			{
				usaRcvMsgVO.setBlNo(usaRcvMsgVO.getInHjbl().substring(0, 12).replaceAll(" ", ""));
				bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
			}
		}
		if (bkgCstmsAdvBlVO != null)
		{
			usaRcvMsgVO.setVslCd(bkgCstmsAdvBlVO.getVslCd());
			usaRcvMsgVO.setVslCdM(bkgCstmsAdvBlVO.getVslCd());
			usaRcvMsgVO.setSkdVoyNo(bkgCstmsAdvBlVO.getSkdVoyNo());
			usaRcvMsgVO.setSkdDirCd(bkgCstmsAdvBlVO.getSkdDirCd());
		}
		usaRcvMsgVO.setIcrCode(str.substring(15, 17));
		usaRcvMsgVO.setIcrQty(str.substring(17, 27));
		usaRcvMsgVO.setIcrEtTp(str.substring(27, 29));
		usaRcvMsgVO.setIcrEtNo(str.substring(29, 44));
		usaRcvMsgVO.setIcrDate(str.substring(44, 54));
		int rtn = dbDao.searchCNRUBlAtCanada(usaRcvMsgVO);
		if (rtn > 0)
		{
			try
			{
				rtn = downLoadBC.modifyCNRUInfoAtCanada(usaRcvMsgVO);
				// 2010.04.13
				// CANADA 전송시 없는 CONTAINER가 있어 전송 오류발생
			}
			catch(Exception ex)
			{
				log.error(ex.getMessage());
			}
		}
		String inBl = "";
		String inVvd = "";
		String inPod = "";
		UsaResultCntrVO usaResultCntrVO = new UsaResultCntrVO();
		// 00아닐경우
		if (!ConstantMgr.getScacCode().equals(usaRcvMsgVO.getInSnp()))
		{
			rtn = dbDao.modifyDnvlFile(usaRcvMsgVO);
			if (rtn == 0)
			{
				rtn = dbDao.addDnvoFile(usaRcvMsgVO);
			}
			usaResultCntrVO = dbDao.searchMasterBl(usaRcvMsgVO);
			// Master BL을 찾을 경우.
			if (usaResultCntrVO != null && !"".equals(usaResultCntrVO.getInBl()))
			{
				inBl = usaResultCntrVO.getInBl();
				usaRcvMsgVO.setInBl(inBl);
				// Master BL에 대한 vvd, pod를 찾는다.
				usaResultCntrVO = dbDao.searchVVDPodByBl(usaRcvMsgVO);
				if (usaResultCntrVO != null)
				{
					inVvd = usaResultCntrVO.getInVvd();
					inPod = usaResultCntrVO.getInPod();
					usaRcvMsgVO.setInVvd(inVvd);
					usaRcvMsgVO.setInPod(inPod);
					// BKG_CSTMS_ADV_NVOCC_FILE 갱신.
					rtn = dbDao.modifyVvdPodByBlAtDnvoFile(usaRcvMsgVO);
				}
			}
			else
			{
				usaResultCntrVO = dbDao.searchMBlByVvdCntrNo(usaRcvMsgVO);
				// Master BL을 찾을 경우.
				if (usaResultCntrVO != null && !"".equals(usaResultCntrVO.getInBl()))
				{
					inBl = usaResultCntrVO.getInBl();
					usaRcvMsgVO.setInBl(inBl);
					// Master BL에 대한 vvd, pod를 찾는다.
					usaResultCntrVO = dbDao.searchVVDPodByBl(usaRcvMsgVO);
					if (usaResultCntrVO != null)
					{
						inVvd = usaResultCntrVO.getInVvd();
						inPod = usaResultCntrVO.getInPod();
						usaRcvMsgVO.setInVvd(inVvd);
						usaRcvMsgVO.setInPod(inPod);
						// BKG_CSTMS_ADV_NVOCC_FILE 갱신.
						rtn = dbDao.modifyVvdPodByBlAtDnvoFile(usaRcvMsgVO);
					}
				}
			}
			// [SNP=CNRU] CNRU처리
			// 2016-12-06 Pushkar Goel : CPRS항목 추가 요청
			// B/P #22330 NSA - BKG - Incorrect C flag on Inbound C/A USA screen 
			if ("CNRU".equals(usaRcvMsgVO.getInSnp()) || "CPRS".equals(usaRcvMsgVO.getInSnp()))
			{
				// [] CNRU Flag세팅
				if (dbDao.validateCNRUBl(usaRcvMsgVO) != null)
				{
					usaRcvMsgVO.setCnruIt("Y");
				}
				else
				{
					usaRcvMsgVO.setCnruIt("N");
					return 0;
				}
			}
			else
			{
				return 0;
			}
		}
		// [cus_amsport="4501"] UsaCustomsTransmissionDBDAO::searchItHubByBl1J ( usaRcvMsgVO )
		if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
		{
			usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
		}
		usaResultCntrVO = dbDao.searchMaxSeqAtResult(usaRcvMsgVO);
		usaRcvMsgVO.setIcrSeq(usaResultCntrVO.getIcrSeq());
		if ("".equals(JSPUtil.getNull(usaRcvMsgVO.getCusLoc())))
		{
			usaRcvMsgVO.setCusLoc(dbDao.searchAmsCusLoc(usaRcvMsgVO.getCusAmsport()));
		}
		if(usaRcvMsgVO.getDestLocCd() != null && !"".equals(usaRcvMsgVO.getDestLocCd())){
			int rslt = dbDao.searchCstmsLocByDspoCd(usaRcvMsgVO);
			if (rslt != 0)
			{
				usaRcvMsgVO.setCusAmsport(usaRcvMsgVO.getDestLocCd());
				UsaLocationVO usaLocationVO = dbDao.searchLocCdForCustomsLoc(usaRcvMsgVO);
				if (usaLocationVO != null)
				{
					usaRcvMsgVO.setCusLoc(usaLocationVO.getLocCd());
				}else{
					usaRcvMsgVO.setCusLoc("");
				}
			}
		}
		rtn = dbDao.addCustomsResult(usaRcvMsgVO);
		if (rtn == 1)
		{
			if ("CNRU".equals(usaRcvMsgVO.getInSnp()) || "CPRS".equals(usaRcvMsgVO.getInSnp()))
			{
				log.error("\nUS RCV CNRU or CPRS Start====");
				// Container Result CFlag Setting
				String[] newHoldRemark = this.setCntrRsltCFlag(usaRcvMsgVO);
				usaRcvMsgVO.setNewCntrCFlag(newHoldRemark[0]);
				usaRcvMsgVO.setCntrHoldRemark(newHoldRemark[1]);
				// newHoldRemark[1]	// old C Flag
				rtn = dbDao.addResultCntr(usaRcvMsgVO);

				//2010-10-01 최도순 [CHM-201004946] C-flag update 로직 보완 요청 ======>Start
				//Rail AMS에서 partial shipment의 경우 한개의 B/L에 C값이 들어오면
				//C값의 QTY와 B/L C/M에 PKG의 SUM이 일치할 경우 나머지 B/L에 C값을 Y로 upate한다.

				// 2010-10-26 반영보류로 일단 주석처리

				if(usaRcvMsgVO.getNewCntrCFlag().equals("Y") || ("Y".equals(newHoldRemark[2]) && !"Y".equals(newHoldRemark[0])))
				{
					List<UsaPartialBlVO> usaPartialBlVOs = dbDao.searchPartialBl(usaRcvMsgVO);

					for (int i = 0; i < usaPartialBlVOs.size(); i++)
					{
						UsaRcvMsgVO usaRcvMsgPartialVO = new UsaRcvMsgVO();

						usaRcvMsgPartialVO.setBlNo(usaPartialBlVOs.get(i).getLclBlNbrA());

						UsaResultCntrVO usaRsltCntrVO =  dbDao.searchMaxSeqAtResult(usaRcvMsgPartialVO);
						usaRcvMsgPartialVO.setIcrSeq(usaRsltCntrVO.getIcrSeq());

						usaRcvMsgPartialVO.setCntrHoldRemark("updated with Partial BL C-flag ("+usaRcvMsgVO.getBlNo()+")");
						usaRcvMsgPartialVO.setInCntr(usaRcvMsgVO.getInCntr());
						usaRcvMsgPartialVO.setIrType(usaRcvMsgVO.getIrType());
						usaRcvMsgPartialVO.setIcrCode(usaRcvMsgVO.getIcrCode());
						usaRcvMsgPartialVO.setIcrQty(usaRcvMsgVO.getIcrQty());
						usaRcvMsgPartialVO.setIcrEtTp(usaRcvMsgVO.getIcrEtTp());
						usaRcvMsgPartialVO.setIcrEtNo(usaRcvMsgVO.getIcrEtNo());
						usaRcvMsgPartialVO.setIrDate(usaRcvMsgVO.getIrDate());
						usaRcvMsgPartialVO.setNewCntrCFlag(usaRcvMsgVO.getNewCntrCFlag());
						usaRcvMsgPartialVO.setInSnp(usaRcvMsgVO.getInSnp());
						usaRcvMsgPartialVO.setInNvobl(usaRcvMsgVO.getInNvobl());
						usaRcvMsgPartialVO.setIrBatchNo(usaRcvMsgVO.getIrBatchNo());
						dbDao.addResultCntr(usaRcvMsgPartialVO);

						usaRcvMsgPartialVO.setIrType(usaRcvMsgVO.getIrType());
						usaRcvMsgPartialVO.setIcrCode(usaRcvMsgVO.getIcrCode());
						usaRcvMsgPartialVO.setIsfInBl(usaRcvMsgVO.getIsfInBl());
						usaRcvMsgPartialVO.setIcrQty(usaRcvMsgVO.getIcrQty());
						usaRcvMsgPartialVO.setIcrEtTp(usaRcvMsgVO.getIcrEtTp());
						usaRcvMsgPartialVO.setIcrEtNo(usaRcvMsgVO.getIcrEtNo());
						usaRcvMsgPartialVO.setIrDate(usaRcvMsgVO.getIrDate());
						usaRcvMsgPartialVO.setCusAmsport(usaRcvMsgVO.getCusAmsport());
						usaRcvMsgPartialVO.setCusLoc(usaRcvMsgVO.getCusLoc());
						usaRcvMsgPartialVO.setInSnp(usaRcvMsgVO.getInSnp());
						usaRcvMsgPartialVO.setVslCdM(usaRcvMsgVO.getVslCdM());
						usaRcvMsgPartialVO.setSkdVoyNo(usaRcvMsgVO.getSkdVoyNo());
						usaRcvMsgPartialVO.setSkdDirCd(usaRcvMsgVO.getSkdDirCd());
						usaRcvMsgPartialVO.setIrBatchNo(usaRcvMsgVO.getIrBatchNo());
						usaRcvMsgPartialVO.setIcrDate(usaRcvMsgVO.getIcrDate());
						usaRcvMsgPartialVO.setIcrResendInd(usaRcvMsgVO.getIcrResendInd());
						usaRcvMsgPartialVO.setIsfInRemark1("updated with Partial BL C-flag ("+usaRcvMsgVO.getBlNo()+")");
						usaRcvMsgPartialVO.setIsfInRemark2(usaRcvMsgVO.getIsfInRemark2());
						usaRcvMsgPartialVO.setIsfTranNo(usaRcvMsgVO.getIsfTranNo());
						usaRcvMsgPartialVO.setCrrBatNo(usaRcvMsgVO.getCrrBatNo());
						usaRcvMsgPartialVO.setCstmsClrCd(usaRcvMsgVO.getCstmsClrCd());
						dbDao.addCustomsResult(usaRcvMsgPartialVO);


						log.debug("LYTbl:"+usaPartialBlVOs.get(i).getLclBlNbrA()+ "  , Cflag:+"+usaRcvMsgVO.getNewCntrCFlag()
								+ "  dspo_cd:"+usaRcvMsgVO.getIcrCode()  );

						this.setCstmsClr(usaPartialBlVOs.get(i).getLclBlNbrA(), usaRcvMsgVO.getNewCntrCFlag(), usaRcvMsgVO);
					}
				}
				/**********************************************
				 * Cargo Release Set
				 **********************************************/
				this.setCstmsClr(usaRcvMsgVO.getBlNo(), usaRcvMsgVO.getNewCntrCFlag(), usaRcvMsgVO);

				if (cstmsClrs.size() > 0)
				{
					usaRcvMsgVO.setCstmsClrVOs(cstmsClrs);
				}
				log.error("\nUS RCV CNRU or CPRS Success====");
				return 0 ;
			}
		}

		if ("".equals(bkgCstmsAdvBlVO.getMfNo()))
		{
			usaRcvMsgVO.setMasterOrHouse("M");
		}
		else
		{
			usaRcvMsgVO.setMasterOrHouse("H");
		}
		// 2010.04.16 KMJ ADD
		// 1J : P/MIB Accepted Date
		// 11,12,13 : Arrival Date
		// 50,51,52 : Export Date
		this.setAccpDate(usaRcvMsgVO);

		if ("M".equals(usaRcvMsgVO.getMasterOrHouse()))
		{
			log.error("####################################################");
			log.error("본격적인 C-Flag 로직 시작");
			log.error("bl_no: " + usaRcvMsgVO.getBlNo());
			log.error("####################################################");

			// 현재 C-Flag, OB_NTC_FLG
			UsaPartialBlVO usaPartialBlVO = dbDao.searchOldCstmsClrCd(usaRcvMsgVO);
			String oldCFlag = usaPartialBlVO.getLclCustcIndA();

			// KMJ
			usaRcvMsgVO.setOldCFlag(oldCFlag);

			String newCFlag = "N";

			if (!"H".equals(oldCFlag) && "54".equals(usaRcvMsgVO.getIcrCode())){
				/**********************************************
				 * 54코드가 들어오면 무조건 N으로<br>
				 * 2010.06.23
				 **********************************************/
				newCFlag = "N";
			}
			/**********************************************
			 * 종전 CFlag가 J이고 54, 55 코드가 들어오고 local인 경우 N으로<br>
			 * 2010.04.08
			 **********************************************/
			else if ("54,55".indexOf(usaRcvMsgVO.getIcrCode()) >= 0
					&& ("J".equals(oldCFlag) || "J".equals(usaPartialBlVO.getOldCstmsClrCdJcd()))
					&& "L".equals(usaPartialBlVO.getCstmsClrTpCd()))
			{
				newCFlag = "N";
			}
			else
			{
				newCFlag = this.getCFlag(usaRcvMsgVO, oldCFlag);
			}

			/***************************************************************************
			 * 수신 파일에 1C가 들어와서 최종 C-FLAG 가 "Y"일 경우<br>
			 * 1. BL의 Customs Loc 과 수신 파일의 Customs 이 다르면 C 값을 'N'으로 바꾼다.<br>
			 * 2. 1C와 12코드가 같이 들어와서 1번 로직을 수행 후 12 코드를 받으면 다시 'Y'로 풀리기 때문에 그 경우도 C값을 'N'으로 바꾼다.<br>
			 * 한진해운과 같이 Location 비교는 필요없음 (MDM_LOCATION의 USLGB, USLAX 등의 SCC_CD가 같음)
			 *
			 * Pushkar Goel 의 Blueprint #12697 요청에 따라
			 * Customs Loc 과 수신 메시지 안에 있는 clearance location 이 다른 경우
			 * 최종 C 를 N 으로 유지하는 로직 삭제 - 2016.05.06
			 ***************************************************************************/
			if(!usaRcvMsgVO.getCusLoc().equals( bkgCstmsAdvBlVO.getCstmsLocCd() )
					&& ("1C".equals(usaRcvMsgVO.getIcrCode()) &&  "Y".equals(newCFlag)))
			{
					cstmsLocDiffFlg = "Y";
//                    newCFlag = "N";
			}
			else if("Y".equals(cstmsLocDiffFlg) && "12".equals(usaRcvMsgVO.getIcrCode()) )
			{
//	               newCFlag = "N";
				   cstmsLocDiffFlg = "N";
			}

			// Y or J의 경우 Partial 체크
			if ("Y,J".indexOf(newCFlag) >= 0)
			{
				newCFlag = this.getPartialCFlag(usaRcvMsgVO, newCFlag, cstmsClrs);
			}

			/**********************************************
			 * Cargo Release Set
			 **********************************************/
			this.setCstmsClr(usaRcvMsgVO.getBlNo(), newCFlag, usaRcvMsgVO);

			/**********************************************
			 * Hold Notice Set(PH)
			 **********************************************/
			if ("H".equals(newCFlag))
			{
				CstmsHldVO cstmsHldVO = this.setCstmsHld(usaRcvMsgVO.getBlNo(), usaRcvMsgVO, "PH");
				if (cstmsHldVO != null)
				{
					cstmsHlds.add(cstmsHldVO);
				}
			}
			/**********************************************
			 * Realease Notice Set(CF)
			 **********************************************/
			else if ("H".equals(oldCFlag))
			{
				// InBound 테이블(BKG_HLD_NTC)의 Hold Type이 "CF"중에서 없는 데이타만 Insert한다.
				List<HoldInfoVO> holdInfoVOs = dbDao.searchHoldInfo(usaRcvMsgVO);
				for (int j = 0; j < holdInfoVOs.size(); j++)
				{
					HoldInfoVO remvInfoVO = dbDao.searchRemvInfo(usaRcvMsgVO.getBlNo(), holdInfoVOs.get(j));
					usaRcvMsgVO.setHldCd(holdInfoVOs.get(j).getHldCd());
					usaRcvMsgVO.setHldDt(holdInfoVOs.get(j).getHldDt());
					usaRcvMsgVO.setRlseHldCd(remvInfoVO.getHldCd());
					usaRcvMsgVO.setRlseHldDt(remvInfoVO.getHldDt());
					CstmsHldVO cstmsHldVO = this.setCstmsHld(usaRcvMsgVO.getBlNo(), usaRcvMsgVO, "CF");
					if (cstmsHldVO != null)
					{
						cstmsHlds.add(cstmsHldVO);
					}
				}
			}
			/**********************************************
			 * CFlag가 Y -> N으로 변경시<br>
			 * BKG_CSTMS_ADV_IBD 의 CSTMS_CLR_CNG_FLG = 'Y' 변경
			 **********************************************/
			if ("Y".equals(oldCFlag) && "N".equals(newCFlag))
			{
				BkgCstmsAdvIbdVO ibdVO = new BkgCstmsAdvIbdVO();
				ibdVO.setCntCd("US");
				ibdVO.setBlNo(usaRcvMsgVO.getBlNo());
				ibdVO.setCstmsClrCngFlg("Y");
				bkgCstmsAdvIbdVOs.add(ibdVO);
			}
			/**********************************************
			 * Waring 이벤트 Send
			 **********************************************/
			if ("Y".equals(usaPartialBlVO.getObNtcFlg()))
			{
				CstmsHldVO cstmsHldVO = this.setCstmsHld(usaRcvMsgVO.getBlNo(), usaRcvMsgVO, "");
				if (cstmsHldVO != null)
				{
					cstmsHldSends.add(cstmsHldVO);
				}
			}

			/**********************************************
			 * BKG_CSTMS_ADV_RSLT 의 CSTMS_CLR_CD 변경
			 **********************************************/
			usaRcvMsgVO.setCstmsClrCd(newCFlag);
			usaRcvMsgVO.setCstmsLocDiffFlg(cstmsLocDiffFlg);
			dbDao.modifyCustomsResultForCstmsClrCd(usaRcvMsgVO);

			/**********************************************
			 * BKG_CSTMS_ADV_RSLT 의 RCV_LOC_CD 와 CUSTOMS LOC 이 다르면
			 * CUSTOMS LOC = RCV_LOC_CD 으로 갱신
			 **********************************************/
//			if("Y".equals(cstmsLocDiffFlg)) {
//				downLoadBC.modifyAdvancedBl(usaRcvMsgVO);
//
//        		BkgCstmsIbdHisVO hisInfo = null;
//				try {
//					hisInfo = downLoadBC.addBlHistory( "US" + usaRcvMsgVO.getBlNo(), "SYSTEM", "RCV" );
//					if( hisInfo != null) downLoadBC.addBlDetailHistory( hisInfo, "CLO", bkgCstmsAdvBlVO.getCstmsLocCd(), usaRcvMsgVO.getCusLoc() );
//				} catch (EventException e) {
//					log.error("err " + e.toString(), e);
//				}
//
//			}

		} // if master bl
		/**********************************************
		 * Cargo Release Set
		 **********************************************/
		if (cstmsClrs.size() > 0)
		{
			usaRcvMsgVO.setCstmsClrVOs(cstmsClrs);
		}
		/**********************************************
		 * Hold Notice Set
		 **********************************************/
		if (cstmsHlds.size() > 0)
		{
			usaRcvMsgVO.setCstmsHldVOs(cstmsHlds);
		}
		/**********************************************
		 * Waring 이벤트 Send
		 **********************************************/
		if (cstmsHldSends.size() > 0)
		{
			usaRcvMsgVO.setCstmsHldSendVOs(cstmsHldSends);
		}
		/**********************************************
		 * BKG_CSTMS_ADV_IBD 의 CSTMS_CLR_CNG_FLG = 'Y' 변경
		 **********************************************/
		if (bkgCstmsAdvIbdVOs.size() > 0)
		{
			usaRcvMsgVO.setBkgCstmsAdvIbdVOs(bkgCstmsAdvIbdVOs);
		}

		// 수신결과에 따른 메일전송
		this.addEmlNtfc(usaRcvMsgVO);
		return 0;
	}

	/**
	 * AS-IS의 Put_Customs_R 를 처리한다.<br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRM(String str, UsaRcvMsgVO usaRcvMsgVO) {
		usaRcvMsgVO.setBlNo(str.substring(3, 15).replaceAll(" ", ""));
		usaRcvMsgVO.setIcrCode(str.substring(15, 17));
		usaRcvMsgVO.setIcrQty(str.substring(17, 27));
		usaRcvMsgVO.setIcrEtTp(str.substring(27, 29));
		usaRcvMsgVO.setIcrEtNo(str.substring(29, 44));
		usaRcvMsgVO.setIcrDate(str.substring(44, 54));
		// PutCustomsR과 다른 부분이 아래 hbl_no 부분과 bl_no 구하는 부분이다.
		usaRcvMsgVO.setHblNo(str.substring(3, 15).replaceAll(" ", ""));
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getHblNo(), "US");
		if (bkgCstmsAdvBlVO != null)
		{
			usaRcvMsgVO.setBlNo(bkgCstmsAdvBlVO.getMfNo());
		}
		else
		{
			BkgCstmsAdvBlVO bkgCstmsAdvBlVO2 = dbDao.searchAdvBl(usaRcvMsgVO.getInBl(), "US");
			if (bkgCstmsAdvBlVO2 != null)
			{
				usaRcvMsgVO.setBlNo(bkgCstmsAdvBlVO2.getBlNo());
			}
		}
		if (bkgCstmsAdvBlVO == null || bkgCstmsAdvBlVO.getMfNo().trim().equals("")
				|| !ConstantMgr.getScacCode().equals(usaRcvMsgVO.getInSnp()))
		{
			return 0;
		}
		// [cus_amsport="4501"] UsaCustomsTransmissionDBDAO::searchItHubByBl1J ( usaRcvMsgVO )
		// inbond_customs_r에 cus_loc는 ICR_LOC(as-is):RCV_LOC_CD(to-be)에 입력되는데,
		// 현 위치에서는 하드코딩으로 'HOUSE'가 입력되므로, usaRcvMsgVO.getCusAmsport().equals("4501") 로직은 삭제한다.
		UsaResultCntrVO usaResultCntrVO = dbDao.searchMaxSeqAtResult(usaRcvMsgVO);
		usaRcvMsgVO.setIcrSeq(usaResultCntrVO.getIcrSeq());
		String tmpCusLoc = usaRcvMsgVO.getCusLoc();
		usaRcvMsgVO.setCusLoc("HOUSE");
		dbDao.addCustomsResult(usaRcvMsgVO);
		// 작업이 끝났으므로, cusLoc를 'HOUSE'로 하드코팅한 것에서 원복함.
		usaRcvMsgVO.setCusLoc(tmpCusLoc);
		return 0;
	}

	/**
	 * AS-IS의 Put_Customs_R_N 를 처리한다.<br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRN(String str, UsaRcvMsgVO usaRcvMsgVO) {
		// putNakMsgN 에서 in_bl에 의한 bl_no를 이미 구했으므로 아래 구문은 주석처리한다.
		// usaRcvMsgVO.setBlNo(str.substring(3, 15));
		usaRcvMsgVO.setIcrCode(str.substring(15, 17));
		usaRcvMsgVO.setIcrQty(str.substring(17, 27));
		usaRcvMsgVO.setIcrEtTp(str.substring(27, 29));
		usaRcvMsgVO.setIcrEtNo(str.substring(29, 44));
		usaRcvMsgVO.setIcrDate(str.substring(44, 54));
		// AS-IS 로직상의 in_bl에 의해 bl_no를 구하는 로직은 이미 putNakMsgN 에서 수행하였으므로 아래 로직 부분은 생략.
		// EXEC SQL SELECT BL_NO||BL_NO_TP||BL_NO_CHK
		// INTO :bl_no
		// WHERE BL_NO = SUBSTR(:in_bl,1,10)....
		// [cus_amsport="4501"] UsaCustomsTransmissionDBDAO::searchItHubByBl1J ( usaRcvMsgVO )
		if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
		{
			usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
		}
		UsaResultCntrVO usaResultCntrVO = dbDao.searchMaxSeqAtResult(usaRcvMsgVO);
		usaRcvMsgVO.setIcrSeq(usaResultCntrVO.getIcrSeq());
		usaRcvMsgVO.setCstmsClrCd(usaResultCntrVO.getOldCntrCflag());
		int rtn = dbDao.addCustomsResult(usaRcvMsgVO);
		if (rtn == 1)
		{
			if ("CNRU".equals(usaRcvMsgVO.getInSnp()) || "CPRS".equals(usaRcvMsgVO.getInSnp()))
			{
				// Container Result CFlag Setting
				String[] newHoldRemark = this.setCntrRsltCFlag(usaRcvMsgVO);
				usaRcvMsgVO.setNewCntrCFlag(newHoldRemark[0]);
				usaRcvMsgVO.setCntrHoldRemark(newHoldRemark[1]);
				rtn = dbDao.addResultCntr(usaRcvMsgVO);

				//2010-10-01 최도순 [CHM-201004946] C-flag update 로직 보완 요청 ======>Start
				//Rail AMS에서 partial shipment의 경우 한개의 B/L에 C값이 들어오면
				//C값의 QTY와 B/L C/M에 PKG의 SUM이 일치할 경우 나머지 B/L에 C값을 Y로 upate한다.

				// 2010-10-26 반영보류로 일단 주석처리
				/*
				if(usaRcvMsgVO.getNewCntrCFlag().equals("Y"))
				{
					List<UsaPartialBlVO> usaPartialBlVOs = dbDao.searchPartialBl(usaRcvMsgVO);

					for (int i = 0; i < usaPartialBlVOs.size(); i++)
					{
						UsaRcvMsgVO usaRcvMsgPartialVO = new UsaRcvMsgVO();

						usaRcvMsgPartialVO.setBlNo(usaPartialBlVOs.get(i).getLclBlNbrA());

						UsaResultCntrVO usaRsltCntrVO =  dbDao.searchMaxSeqAtResult(usaRcvMsgPartialVO);
						usaRcvMsgPartialVO.setIcrSeq(usaRsltCntrVO.getIcrSeq());

						usaRcvMsgPartialVO.setCntrHoldRemark("updated with Partial BL C-flag ("+usaRcvMsgVO.getBlNo()+")");
						usaRcvMsgPartialVO.setInCntr(usaRcvMsgVO.getInCntr());
						usaRcvMsgPartialVO.setIrType(usaRcvMsgVO.getIrType());
						usaRcvMsgPartialVO.setIcrCode(usaRcvMsgVO.getIcrCode());
						usaRcvMsgPartialVO.setIcrQty(usaRcvMsgVO.getIcrQty());
						usaRcvMsgPartialVO.setIcrEtTp(usaRcvMsgVO.getIcrEtTp());
						usaRcvMsgPartialVO.setIcrEtNo(usaRcvMsgVO.getIcrEtNo());
						usaRcvMsgPartialVO.setIrDate(usaRcvMsgVO.getIrDate());
						usaRcvMsgPartialVO.setNewCntrCFlag(usaRcvMsgVO.getNewCntrCFlag());
						usaRcvMsgPartialVO.setInSnp(usaRcvMsgVO.getInSnp());
						usaRcvMsgPartialVO.setInNvobl(usaRcvMsgVO.getInNvobl());
						usaRcvMsgPartialVO.setIrBatchNo(usaRcvMsgVO.getIrBatchNo());

						dbDao.addResultCntr(usaRcvMsgPartialVO);

						usaRcvMsgPartialVO.setIrType("");
						usaRcvMsgPartialVO.setIcrCode("");
						usaRcvMsgPartialVO.setIrType("");
						usaRcvMsgPartialVO.setIsfInBl("");
						usaRcvMsgPartialVO.setIcrQty("");
						usaRcvMsgPartialVO.setIcrEtTp("");
						usaRcvMsgPartialVO.setIcrEtNo("");
						usaRcvMsgPartialVO.setIrDate("");
						usaRcvMsgPartialVO.setCusAmsport("");
						usaRcvMsgPartialVO.setCusLoc("");
						usaRcvMsgPartialVO.setInSnp("");
						usaRcvMsgPartialVO.setVslCdM("");
						usaRcvMsgPartialVO.setSkdVoyNo("");
						usaRcvMsgPartialVO.setSkdDirCd("");
						usaRcvMsgPartialVO.setIrBatchNo("");
						usaRcvMsgPartialVO.setIcrDate(usaRcvMsgVO.getIcrDate());
						usaRcvMsgPartialVO.setIcrResendInd("");
						usaRcvMsgPartialVO.setIsfInRemark1("updated with Partial BL C-flag ("+usaRcvMsgVO.getBlNo()+")");
						usaRcvMsgPartialVO.setIsfInRemark2("");
						usaRcvMsgPartialVO.setIsfTranNo("");
						usaRcvMsgPartialVO.setCrrBatNo("");
						usaRcvMsgPartialVO.setCstmsClrCd("");

						 dbDao.addCustomsResult(usaRcvMsgPartialVO);
					}
				}
				*/
				//2010-10-01 최도순 [CHM-201004946] C-flag update 로직 보완 요청 ======>End
			}
		}
		return 0;
	}

	/**
	 * As-is의 Put_Customs_Remark를 구현한다. <br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRemark(String str, UsaRcvMsgVO usaRcvMsgVO) {
//		usaRcvMsgVO.setAcpDate(str.substring(3, 9));
		usaRcvMsgVO.setRemark2(str.substring(3, 53));
		int rtn = dbDao.modifyCustomsResultForRemark(usaRcvMsgVO);
		if (rtn < 0)
		{
			return -1;
		}
//		try
//		{
//			if (usaRcvMsgVO.getIcrCode() != null && "50,51".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
//			{
//				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
//				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
//			}
//			else if (usaRcvMsgVO.getIcrCode() != null && "52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
//			{
//				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
//			}
//		}
//		catch(Exception e)
//		{
//			log.error(e.getMessage());
//		}
		return 0;
	}

	/**
	 * As-is의 Put_Customs_Remark_M를 구현한다. <br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRemarkM(String str, UsaRcvMsgVO usaRcvMsgVO) {
//		usaRcvMsgVO.setAcpDate(str.substring(3, 9));
		usaRcvMsgVO.setRemark2(str.substring(3, 53));
		int rtn = dbDao.modifyCustomsResultForRemarkSnpHJSC(usaRcvMsgVO);
		if (rtn < 0)
		{
			return -1;
		}
//		try
//		{
//			if (usaRcvMsgVO.getIcrCode() != null && "50,51".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
//			{
//				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
//				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
//			}
//			else if (usaRcvMsgVO.getIcrCode() != null && "52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
//			{
//				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
//			}
//		}
//		catch(Exception e)
//		{
//			log.error(e.getMessage());
//		}
		return 0;
	}

	/**
	 * 세관에서 받은 메시지의 SCAC code가 00이면서 House B/L 인 경우, Get_ams_rcv_msg 에서 House B/L을 처리한 후<br>
	 * Get_ams_rcv_msg_M에서 House B/L에 대한 Master B/L을 찾아 Master B/L을 가지고 다시 처리한다<br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int getAmsRcvMsgM(String msg, UsaRcvMsgVO usaRcvMsgVO) {
		int rtn = 0;
		String prefix = "";
		/**************************************************************************
		 * 호출 전에 bl_no, mbl_no, hbl_no가 이미 설정되어 들어온다.
		 **************************************************************************/
		// String tmpCusLoc = usaRcvMsgVO.getCusLoc();\
		// cusLoc가 모두 HOUSE로 하드코딩됨.
		usaRcvMsgVO.setCusLoc("HOUSE");
		StringTokenizer token = new StringTokenizer(msg, "\n");
		/******************************************************************************/
		/* 레코드 ID별로 실제적으로 메시지 처리 하는 부분 시작 */
		/******************************************************************************/
		String zone = "";
		String icrResendInd = "";
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
		int iR03 = 0;
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			if (str != null && str.length() >= 80)
			{
				prefix = str.substring(0, 3);
				// W01 레코드 처리
				if ("W01".equals(prefix))
				{
					// BKG_CSTMS_ADV_IBD : CSTMS_CLR_RSLT_CD = 'R'로 변경
					rtn = this.putNakMsgM(str, usaRcvMsgVO);
				}
				/******************************************************************************/
				/* R02 레코드 처리 */
				/******************************************************************************/
				else if ("R02".equals(prefix))
				{
					zone = str.substring(6, 7);
					icrResendInd = str.substring(68, 69);
					usaRcvMsgVO.setZone(zone);
					usaRcvMsgVO.setIcrResendInd(icrResendInd);
					// 아래 H 체크 로직삭제, getAmsRcvMsgM은 하우스 BL만 구동시키는 메서드이므로 중복 체크임.
					// BL조회후 조회결과가 있는 경우에만 putCustomsRM 을 구동, R02 두번째 라인도 구동되는 것을 방지.
					// 아울러 else 로직에 있었던, icd_code 13, 52 부분도 삭제함. 원본소스 52라인 부분.
					// if("H".indexOf(zone) >= 0 ){
					bkgCstmsAdvBlVO = dbDao.searchAdvBl(str.substring(3, 15).replaceAll(" ", ""), "US");
					if (bkgCstmsAdvBlVO != null)
					{
						rtn = this.putCustomsRM(str, usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
						iR03 = 0;
					}
				}// R02
				/******************************************************************************/
				/* R03 레코드 처리 */
				/******************************************************************************/
				else if ("R03".equals(prefix))
				{
					/******************************************************************************/
					/* 첫번째 R03 레코드 처리 */
					/******************************************************************************/
					if (iR03 == 0)
					{
						iR03 = 1;
						usaRcvMsgVO.setIcrRemark1(str.substring(3, 53));
						rtn = dbDao.modifyCustomsResult(usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}// iR03 == 0
					/******************************************************************************/
					/* 두번째 R03 레코드 처리 */
					/******************************************************************************/
					else if (iR03 == 1)
					{
						iR03 = 2;
						rtn = this.putCustomsRemarkM(str, usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}
					/******************************************************************************/
					/* 세번째 R03 레코드 처리 */
					/******************************************************************************/
					else if (iR03 == 2)
					{
						usaRcvMsgVO.setRemark3(str.substring(3, 53));
						// inbond_customs_r에 cus_loc는 ICR_LOC(as-is):RCV_LOC_CD(to-be)에 입력되는데,
						// 현 위치에서는 하드코딩으로 'HOUSE'가 입력
						/********************************************/
						/* icr_remark1으로 업데이트하게 되어 있어 */
						/* icr_remark3로 업데이트 하도록 수정 */
						/* 2006/3/21 민동진 수정 */
						/********************************************/
						rtn = dbDao.modifyCustomsResultForRemark3(usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}
				}
			}
		}
		// 레코드 ID별로 실제적으로 메시지 처리 하는 부분 종료(for문)
		return 0;
	}

	/**
	 * 세관에서 받은 메시지의 SCAC code가 00아니면. 즉 NVOCC의 House B/L을 SNP로서 받았을 때 <br>
	 * Get_ams_rcv_msg에서 NVOCC의 House B/L에 대한 처리를 하고 NVOCC의 House B/L에 대한 00의 Master B/L을 찾아 <br>
	 * Get_ams_rcv_msg_N에서 다시 처리한다
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int getAmsRcvMsgN(String msg, UsaRcvMsgVO usaRcvMsgVO) {
		int rtn = 0;
		String prefix = "";
		/**************************************************************************
		 * 호출 전에 bl_no, mbl_no, hbl_no가 이미 설정되어 들어온다.
		 **************************************************************************/
		StringTokenizer token = new StringTokenizer(msg, "\n");
		/******************************************************************************/
		/* 레코드 ID별로 실제적으로 메시지 처리 하는 부분 시작 */
		/******************************************************************************/
		String zone = "";
		String inCode = "";
		String inCodeb = "";
		String icrResendInd = "";
		String cntrNo = "";
		int iR03 = 0;
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			if (str != null && str.length() >= 80)
			{
				prefix = str.substring(0, 3);
				// W01 레코드 처리
				if ("W01".equals(prefix))
				{
					rtn = this.putNakMsgN(str, usaRcvMsgVO);
					if (rtn < 0)
					{
						return rtn;
					}
				}
				/******************************************************************************/
				/* R02 레코드 처리 */
				/******************************************************************************/
				else if ("R02".equals(prefix))
				{
					inCode = str.substring(15, 17);
					inCodeb = str.substring(7, 8);
					usaRcvMsgVO.setZone(zone);
					usaRcvMsgVO.setIcrResendInd(icrResendInd);
					if (!"  ".equals(inCode) && !"00".equals(inCode) && !" ".equals(inCodeb))
					{
						rtn = this.putCustomsRN(str, usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
						iR03 = 0;
					}
					else
					{
						if (usaRcvMsgVO.getIcrCode() != null && "13,52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
						{
							cntrNo = str.substring(23, 34);
							usaRcvMsgVO.setCntrNo(cntrNo);
						}
					}
				}// R02
				/******************************************************************************/
				/* R03 레코드 처리 */
				/******************************************************************************/
				else if ("R03".equals(prefix))
				{
					/******************************************************************************/
					/* 첫번째 R03 레코드 처리 */
					/******************************************************************************/
					if (iR03 == 0)
					{
						iR03 = 1;
						usaRcvMsgVO.setIcrRemark1(str.substring(3, 53));
						rtn = dbDao.modifyCustomsResult(usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}// iR03 == 0
					/******************************************************************************/
					/* 두번째 R03 레코드 처리 */
					/******************************************************************************/
					else if (iR03 == 1)
					{
						iR03 = 2;
						rtn = this.putCustomsRemarkM(str, usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}
					/******************************************************************************/
					/* 세번째 R03 레코드 처리 */
					/******************************************************************************/
					else if (iR03 == 2)
					{
						usaRcvMsgVO.setRemark3(str.substring(3, 53));
						/********************************************/
						/* icr_remark1으로 업데이트하게 되어 있어 */
						/* icr_remark3로 업데이트 하도록 수정 */
						/* 2006/3/21 민동진 수정 */
						/********************************************/
						rtn = dbDao.modifyCustomsResultForRemark3(usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}
				}
			}
		}
		// 레코드 ID별로 실제적으로 메시지 처리 하는 부분 종료(for문)
		return 0;
	}

	/**
	 * As-is의 Put_Customs_R_ISF를 구현한다. <br>
	 *
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRIsf(UsaRcvMsgVO usaRcvMsgVO) {
		/******************************************************/
		/* ISF ACCEPT 시에는 ICR_REMARK3 에 ISF_TRAC_NO 삽입 */
		/******************************************************/
		usaRcvMsgVO.setBlNo(usaRcvMsgVO.getIsfInBl());
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
		if (bkgCstmsAdvBlVO != null)
		{
			usaRcvMsgVO.setVslCdM(bkgCstmsAdvBlVO.getVslCd());
			usaRcvMsgVO.setVslCd(bkgCstmsAdvBlVO.getVslCd());
			usaRcvMsgVO.setSkdVoyNo(bkgCstmsAdvBlVO.getSkdVoyNo());
			usaRcvMsgVO.setSkdDirCd(bkgCstmsAdvBlVO.getSkdDirCd());
		}
		usaRcvMsgVO.setIcrCode(usaRcvMsgVO.getIrType()); //SN
		usaRcvMsgVO.setIcrDate(usaRcvMsgVO.getIrDate());
		UsaResultCntrVO usaResultCntrVO = dbDao.searchMaxSeqAtResult(usaRcvMsgVO);
		usaRcvMsgVO.setIcrSeq(usaResultCntrVO.getIcrSeq());
		dbDao.addCustomsResult(usaRcvMsgVO);
		// Update BKG_CSTMS_ADV_STWG_SND_LOG
		dbDao.modifyBkgCstmsAdvStwgSndLog(usaRcvMsgVO);
		return 0;
	}


	/**
	 * Log 정보를 생성한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addSendLog(SendingLogVO sendingLogVO) throws EventException {
		try
		{
			dbDao.addSendLog(sendingLogVO);
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * Log Detail 정보를 생성한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addSendLogDetail(SendingLogVO sendingLogVO) throws EventException {
		try
		{
			dbDao.addSendLogDetail(sendingLogVO);
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * BKG_CSTMS_ADV_EDI_BL_RSPN 테이블에 CRR_BAT_NO 등을 삽입한다.<br>
	 *
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addCarrierBatchNo(SendingLogVO sendingLogVO) throws EventException {
		try
		{
			dbDao.addCarrierBatchNo(sendingLogVO);
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * ISF US 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param manifestTransmitVOs manifestTransmitVO
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifestIsf(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		try
		{
			UsaManifestSearchDetailVO usaManifestTransmitVO = (UsaManifestSearchDetailVO) manifestTransmitVOs[0];
			usaManifestTransmitVO.setUsrId(account.getUsr_id());
			usaManifestTransmitVO.setOfcCd(account.getOfc_cd());
			// 삭제전송의 경우 전송한 이력이 있는지 조회
			if ("D".equals(usaManifestTransmitVO.getSelIsfActCd()))
			{
				if (dbDao.searchIsf5SndLog(usaManifestTransmitVO.getBlNo()) <= 0)
				{
					// There is no data to delete.
					throw new EventException(new ErrorHandler("BKG03054").getMessage());
				}
			}
			else
			{
				// ISF5 대상여부 체크
				if (dbDao.searchIsf5(usaManifestTransmitVO.getBlNo()) <= 0)
				{
					// Data is invalid. ({?msg1} )
					throw new EventException(new ErrorHandler("BKG00388", new String[]{"Invalid ISF5"}).getMessage());
				}
			}
			// MI 전송여부 체크
//			UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
//			checkMiCondVO.setVvd(usaManifestTransmitVO.getVvd());
//			checkMiCondVO.setPod(usaManifestTransmitVO.getPod());
//			checkMiCondVO.setPol(usaManifestTransmitVO.getPol());
//			checkMiCondVO.setTrsmTp("MI");
//			if (dbDao.checkMiTransCount(checkMiCondVO) == 0)
//			{
//				// You must transmit MI file first.
//				throw new EventException(new ErrorHandler("BKG01055").getMessage());
//			}
			// ISF5전송
			this.amsIsf5(usaManifestTransmitVO);
		}
		catch (DAOException de)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception e)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), e);
		}
		return null;
	}


	/**
	 * B/L별로 ISF5에 대해 메시지를 만들고 전송한다.
	 *
	 * @param UsaManifestSearchDetailVO usaManifestTransmitVO
	 */
	public void amsIsf5(UsaManifestSearchDetailVO usaManifestTransmitVO) throws DAOException, EventException {

		log.info("amsIsf5 Start");
		/*****************************************************************
		 * Size가 0이 나올수 없음(일단 오류를 피하기 위해 리턴)<br>
		 * List<Isf5InfoVO>는 BKG_CSTMS_ADV_CNTR_MF개수임.<BR>
		 * BL정보는 모두 같아서 LIST의 0번째로 가져오면 되고<BR>
		 * SF40_ISF5의 HTS CODE(HAMO_CMDT_CD)를 가져오는거때문에 LIST로 함
		 *****************************************************************/
		List<Isf5InfoVO> isf5InfoVOs = dbDao.searchIsf5Info(usaManifestTransmitVO.getBlNo(), usaManifestTransmitVO.getSelIsfActCd());
		if (isf5InfoVOs.size() <= 0)
		{
			return;
		}
		StringBuffer flatFile = new StringBuffer();
		BookingUtil command = new BookingUtil();

		// ISR_NO
		BkgCstmsCdConvCtntVO cstmsCdConvvo = new BkgCstmsCdConvCtntVO();
		cstmsCdConvvo.setCntCd("US");
		cstmsCdConvvo.setCstmsDivId("AMS_IRS_NO");
		cstmsCdConvvo.setCstmsDivIdSeq("1");
		List<BkgCstmsCdConvCtntVO> irslist = command.searchCstmsCdConv(cstmsCdConvvo);
		String irsNo = irslist.size() > 0 ? irslist.get(0).getAttrCtnt1() : "";

		// FlatFile Header
//		flatFile.append(command.searchCstmsEdiHeader(ConstantMgr.getScacCode(), "USCBP", "ISF")).append("\n");
		flatFile.append(command.searchCstmsEdiHeaderNew("US_ISF")).append("\n");
		// F/F Body
		// SF10.
		flatFile.append("{ST").append("\n");
		flatFile.append("{SF10_HEADER").append("\n");
		flatFile.append("ISF_TP:2").append("\n");
		flatFile.append("ISF_SHIP_TP:01").append("\n");
		flatFile.append("ISF_ACT_CD:").append(isf5InfoVOs.get(0).getIsfActCd()).append("\n");
		flatFile.append("ISF_ACT_REASON:CT").append("\n");
		flatFile.append("ISF_IMP_QUAL:EI").append("\n");
		flatFile.append("ISF_IMP_NO:").append(irsNo).append("\n");
		flatFile.append("ISF_IMP_DOB:").append("\n");
		flatFile.append("ISF_TRANS_MODE:11").append("\n");
		flatFile.append("ISF_TRAC_NO:").append(isf5InfoVOs.get(0).getCstmsRmk3()).append("\n");
		flatFile.append("ISF_SCAC:").append(ConstantMgr.getScacCode()).append("\n");
		flatFile.append("ISF_BOND_HOLDER:").append(irsNo).append("\n");
		flatFile.append("ISF_BOND_ACT_CD:02").append("\n");
		flatFile.append("ISF_BOND_TP:8").append("\n");
		flatFile.append("ISF_CNTRY_CD:").append("\n");
		flatFile.append("}SF10_HEADER").append("\n");
		// SF15.
		String blTp = "OB";
		// House B/L case.
		if ("H".equals(isf5InfoVOs.get(0).getMh()))
		{
			blTp = "BM";
		}
		flatFile.append("{SF15_SHIP_REF").append("\n");
		flatFile.append("BL_TP:").append(blTp).append("\n");
		flatFile.append("BL_NO:").append(ConstantMgr.getScacCode()).append(isf5InfoVOs.get(0).getBlNo()).append("\n");
		flatFile.append("}SF15_SHIP_REF").append("\n");
		// SF20.
		flatFile.append("{SF20_SUB_REF").append("\n");
		flatFile.append("REF_CD:FC").append("\n");
		flatFile.append("REF_NO:").append(ConstantMgr.getScacCode()).append("\n");
		flatFile.append("}SF20_SUB_REF").append("\n");
		if ("H".equals(isf5InfoVOs.get(0).getMh()))
		{
			flatFile.append("{SF20_SUB_REF").append("\n");
			flatFile.append("REF_CD:MB").append("\n");
			flatFile.append("REF_NO:").append(isf5InfoVOs.get(0).getMblNo()).append("\n");
			flatFile.append("}SF20_SUB_REF").append("\n");
		}
		// SF30-SF35-SF36 Loop, Booking Party, Ship To Party, Mandatory Data
		// Booking Party
		UsaIsf5CondVO usaIsf5CondVO = new UsaIsf5CondVO();
		usaIsf5CondVO.setBlNo(isf5InfoVOs.get(0).getBlNo());
		UsaIsf5ResultVO pvo = dbDao.searchIsf5BkgParty(usaIsf5CondVO);
		if (pvo != null)
		{
			flatFile.append("{SF30_PARTY").append("\n");
			flatFile.append("ENTT_CD:").append("BKP").append("\n");
			flatFile.append("ENTT_NAME:").append(pvo.getEnttName()).append("\n");
			flatFile.append("ENTT_ID_QUAL:").append("\n");
			flatFile.append("ENTT_ID:").append("\n");
			flatFile.append("CNTRY_N_DOB:").append("\n");
			flatFile.append("{SF35_ADD").append("\n");
			flatFile.append("ADD_QUAL:").append("15").append("\n");
			flatFile.append("ADD_INFO:").append(pvo.getAddInfo()).append("\n");
			flatFile.append("ADD_QUAL_2:").append("15").append("\n");
			flatFile.append("ADD_INFO_2:").append(pvo.getAddInfo2()).append("\n");
			flatFile.append("}SF35_ADD").append("\n");
			flatFile.append("{SF36_ADD2").append("\n");
			flatFile.append("ADD_CT:").append(pvo.getAddCt()).append("\n");
			flatFile.append("ADD_CNTRY_SUB:").append("\n");
			flatFile.append("ADD_ZIP_CD:").append("\n");
			flatFile.append("ADD_CNTRY:").append(pvo.getAddCntry()).append("\n");
			flatFile.append("}SF36_ADD2").append("\n");
			flatFile.append("}SF30_PARTY").append("\n");
		}
		// Ship To Party
		// To Order BL 이면 Notify 정보, 아니면 Consignee 정보
		pvo = dbDao.searchIsf5SF30Party(usaIsf5CondVO);
		if (pvo != null)
		{
			flatFile.append("{SF30_PARTY").append("\n");
			flatFile.append("ENTT_CD:").append("ST").append("\n");
			flatFile.append("ENTT_NAME:").append(pvo.getEnttName()).append("\n");
			flatFile.append("ENTT_ID_QUAL:").append("\n");
			flatFile.append("ENTT_ID:").append("\n");
			flatFile.append("CNTRY_N_DOB:").append("\n");
			flatFile.append("{SF35_ADD").append("\n");
			flatFile.append("ADD_QUAL:").append("15").append("\n");
			flatFile.append("ADD_INFO:").append(pvo.getAddInfo()).append("\n");
			flatFile.append("ADD_QUAL_2:").append("15").append("\n");
			flatFile.append("ADD_INFO_2:").append(pvo.getAddInfo2()).append("\n");
			flatFile.append("}SF35_ADD").append("\n");
			flatFile.append("{SF36_ADD2").append("\n");
			flatFile.append("ADD_CT:").append(pvo.getAddCt()).append("\n");
			flatFile.append("ADD_CNTRY_SUB:").append("\n");
			flatFile.append("ADD_ZIP_CD:").append("\n");
			flatFile.append("ADD_CNTRY:").append(pvo.getAddCntry()).append("\n");
			flatFile.append("}SF36_ADD2").append("\n");
			flatFile.append("}SF30_PARTY").append("\n");
		}
		// 컨테이너 번호별로 CNTR_MD의 hamo_cmdt_cd를 출력한다.
		for (int i = 0; i < isf5InfoVOs.size(); i++)
		{
			flatFile.append("{SF40_ISF5").append("\n");
			flatFile.append("HTS_CD_ISF5:").append(isf5InfoVOs.get(i).getHamoCmdtCd()).append("\n");
			flatFile.append("CNTRY_ORG_ISF5:").append("\n");
			flatFile.append("}SF40_ISF5").append("\n");
		}
		pvo = dbDao.searchIsf5SF50(usaIsf5CondVO);
		if (pvo != null)
		{
			flatFile.append("{SF50_ISF5").append("\n");
			flatFile.append("FPOD_QUAL:").append("K").append("\n");
			flatFile.append("FPOD:").append(pvo.getFpod()).append("\n");
			flatFile.append("DEL_QUAL:").append("UN").append("\n");
			flatFile.append("DEL:").append(pvo.getDel()).append("\n");
			flatFile.append("}SF50_ISF5").append("\n");
		}
		flatFile.append("}SE");
		/**********************************************
		 * FlatFile
		 **********************************************/
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMS.IBMMQ.QUEUE"));
		sendFlatFileVO.setFlatFile(flatFile.toString().toUpperCase());
		FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
		if (flatFileAckVO.getAckStsCd().equals("E"))
			throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
		/**********************************************
		 * BKG_CSTMS_ADV_STWG_SND_LOG
		 **********************************************/
		String seq = dbDao.searchDateSeq();
		String lsDate = dbDao.searchSysdate("yyyymmddhh24miss");
		SendDetailLogVO sendDetailLogVO = new SendDetailLogVO();
		sendDetailLogVO.setSndProcId("ISF");
		sendDetailLogVO.setSeq(seq);
		sendDetailLogVO.setVvd(usaManifestTransmitVO.getVvd());
		sendDetailLogVO.setPol(usaManifestTransmitVO.getPol());
		sendDetailLogVO.setPod(usaManifestTransmitVO.getPod());
		sendDetailLogVO.setUsrId(usaManifestTransmitVO.getUsrId());
		sendDetailLogVO.setOfcCd(usaManifestTransmitVO.getOfcCd());
		sendDetailLogVO.setCntrCount(isf5InfoVOs.get(0).getCntrCnt());
		sendDetailLogVO.setSndDt(lsDate);
		sendDetailLogVO.setBlNo(isf5InfoVOs.get(0).getBlNo());
		sendDetailLogVO.setIsfActCd(isf5InfoVOs.get(0).getIsfActCd());
		sendDetailLogVO.setCstmsPortCd(isf5InfoVOs.get(0).getCstmsPortCd());

		int result = dbDao.addStowageSendLog(sendDetailLogVO);
		if (result > 0)
		{
			StringTokenizer token = new StringTokenizer(flatFile.toString().toUpperCase(), "\n");
			int i = 1;
			String tmpStr = "";
			while (token.hasMoreTokens())
			{
				tmpStr = token.nextToken();
				sendDetailLogVO.setDtlSeq(i + "");
				sendDetailLogVO.setMsg(tmpStr);
				dbDao.addSendDetailLog(sendDetailLogVO);
				i++;
			}
		}
	}

	/**
	 * HOLD INFO SET
	 * @param blNo blNo
	 * @param usaRcvMsgVO usaRcvMsgVO
	 * @param hldType hldType
	 * @return CstmsHldVO
	 */
	private CstmsHldVO setCstmsHld(String blNo, UsaRcvMsgVO usaRcvMsgVO, String hldType) {
		log.info("Start setCstmsHld");
		CstmsHldVO cstmsHld = new CstmsHldVO();
		cstmsHld.setBlNo(blNo);
		// 'PH' : Hold , 'CF' : Release
		cstmsHld.setHldType(hldType);
		// 박미옥수석 요청, 날자타입, yyyy-mm-dd hh24:mi:ss
		String hldDt = usaRcvMsgVO.getIrDate().substring(0, 2) + "-" + usaRcvMsgVO.getIrDate().substring(2, 4) + "-"
				+ usaRcvMsgVO.getIrDate().substring(4, 6);
		if (Integer.parseInt(hldDt.substring(0, 2)) > 70)
			hldDt = "19" + hldDt;
		else
			hldDt = "20" + hldDt;
		hldDt = hldDt + " " + usaRcvMsgVO.getIrDate().substring(6, 8) + ":" + usaRcvMsgVO.getIrDate().substring(8, 10)
				+ ":" + usaRcvMsgVO.getIrDate().substring(10, 12);
		cstmsHld.setCstmsLocCd(JSPUtil.getNull(usaRcvMsgVO.getCusLoc()));
		if ("CF".equals(hldType))
		{
			cstmsHld.setRlseHldCd(usaRcvMsgVO.getRlseHldCd());
			cstmsHld.setRlseHldDt(usaRcvMsgVO.getRlseHldDt());
			cstmsHld.setHldCd(usaRcvMsgVO.getHldCd());
			cstmsHld.setHldDt(usaRcvMsgVO.getHldDt());
		}
		else
		{
			// PH or ""의 경우
			cstmsHld.setHldCd(usaRcvMsgVO.getIcrCode());
			cstmsHld.setHldDt(hldDt);
		}
		if ("".equals(cstmsHld.getBlNo()) || "".equals(cstmsHld.getCstmsLocCd())
				|| "".equals(cstmsHld.getHldCd()) || "".equals(cstmsHld.getHldDt())
				|| ("CF".equals(cstmsHld.getHldType()) && "".equals(cstmsHld.getRlseHldCd()))
				|| ("CF".equals(cstmsHld.getHldType()) && "".equals(cstmsHld.getHldCd())))
		{
			return null;
		}
		// Hold Code : Inbound에서 필요한 코드인지 체크
		if (!"".equals(hldType) && !dbDao.searchHldNtcFlg(cstmsHld.getHldType(), cstmsHld.getHldCd(), cstmsHld.getRlseHldCd()))
		{
			return null;
		}
		String strLogDesc = "[B/L No:" + blNo
				+ "] [LocCd:" + cstmsHld.getCstmsLocCd()
				+ "] [HldCd:" + cstmsHld.getHldCd()
				+ "] [HldDt:" + cstmsHld.getHldDt()
				+ "] [RlseHldCd:" + cstmsHld.getRlseHldCd()
				+ "] [RlseHldDt:" + cstmsHld.getRlseHldDt() + "]";
		dbDao.addEnisLog("BKG_USA_RCV_HOLD", hldType, strLogDesc);
		return cstmsHld;
	}

	/**
	 * 컨테이너 C-Flag
	 *
	 * @param usaRcvMsgVO
	 * @return String
	 * @throws DAOException
	 */
	private String[] setCntrRsltCFlag(UsaRcvMsgVO usaRcvMsgVO) {
		/****************************************************************************/
		/* 20090519 JHPARK 캐나다 Port 를 경유하는 미주 내륙으로 운송되는 화물은 */
		/* 선사 신고대상이 아니라 캐나다에서 미주로 화물을 운송하는 Rail Carrier */
		/* 신고건인데, 이 Rail Company 가 00 를 (Second Notify Party , SNP) 로 */
		/* 지정해서 미세관에 신고하면 한진해운도 데이터를 동시에 수신한다. */
		/* 문제는 Rail Company 가 BL 단위로 신고하는게 아니라 CNTR 단위로 신고하기 */
		/* 때문에 수신한 데이터를 CNTR 별로 저장해 둔다. */
		/****************************************************************************/
		/* INBOND_CUSTOMS_R 에 데이터를 저장한 뒤에 INBOND_RLOG_CNTR 에 필요 데이터 */
		/* 를 저장한다. CNTR 별 C-Flag 를 저장하기 위해서 최종 C-Flag 를 확인한다. */
		/****************************************************************************/
		String oldCntrCFlag = "N";
		String oldHoldRemark = "";
		// CNTR 별 새로운 C-Flag (new_cntr_c_flag)를 결정하기 위한 로직이 들어간다.
		String newCntrCFlag = "";
		String newHoldRemark = "";
		String[] newCFlagHoldRmk = new String[3];		// 3개 생성
		UsaResultCntrVO usaResultCntrVO = dbDao.searchCFlagAtResultCntr(usaRcvMsgVO);
		if (usaResultCntrVO != null)
		{
			oldCntrCFlag = usaResultCntrVO.getOldCntrCflag();
			oldHoldRemark = usaResultCntrVO.getOldHoldRemark();

			// 5H, 1A는 2개로 등록되어 있는데, Hold를 우선시 해야 함, 2010.04.20, hadi
			if ("5H".equals(usaRcvMsgVO.getIcrCode()) || "1A".equals(usaRcvMsgVO.getIcrCode())) {
				// Hold Code의 경우 'H'
				newCntrCFlag = "H";
				newHoldRemark = "HOLD:" + usaRcvMsgVO.getIcrCode();
			}

			if ("H".equals(usaResultCntrVO.getHold())) {
				// Hold Code의 경우 'H'
				newCntrCFlag = "H";
				newHoldRemark = "HOLD:" + usaRcvMsgVO.getIcrCode();
			} else if ("R".equals(usaResultCntrVO.getRemv())) {
				// Release Code
				// 이전 Dspo Cd 별 Enter/Release Qty 합산하여 Cntr_Pck_Qty 와 동일할 경우,
				// C-flag =Y or J. 아니면 N
				if (!dbDao.checkRailHoldPairDspo(usaRcvMsgVO)) {
					newCntrCFlag = "H";
				} else {
					newCntrCFlag = dbDao.searchRailCflagHYJ(usaRcvMsgVO);
				}
				if ("H".equals(newCntrCFlag)) {
					newHoldRemark = oldHoldRemark;
				}
			}
			// 69 를 받았을 때 (Rail Company 에서 Manifest 전송이후 최초로 받는 메시지)
			else if ("69".equals(usaRcvMsgVO.getIcrCode())) {
				newCntrCFlag = "N";
			}
			// 1J 를 받았을 때 (보세운송 허가)
			else if ("1J".equals(usaRcvMsgVO.getIcrCode())) {
				// 2010.04.28 이전 Hold체크 추가
				if ("H".equals(oldCntrCFlag)) {
					// Hold 가 있으면
					newCntrCFlag = oldCntrCFlag;
					newHoldRemark = oldHoldRemark;
				} else {
					newCntrCFlag = "J";
				}
				// 1J Qty 는 항상 CNTR Qty 와 동일하다.
				// newCntrCFlag = "J";
			}
			// 1C 를 받았을 때 (Customs Clear)
			// else if ("1C".equals(usaRcvMsgVO.getIcrCode()) ||
			// "1W".equals(usaRcvMsgVO.getIcrCode()))
			else if ("1C".equals(usaRcvMsgVO.getIcrCode())) {
				// 69의 CNTR QTY -> BKG_CSTMS_ADV_CNTR_MF 의 PCK_QTY로 변경
				int qty69 = dbDao.search69QtyByBl(usaRcvMsgVO);
				// 1C 의 QTY - 4E의 QTY
				int ircQty = dbDao.searchSumQtyByBl(usaRcvMsgVO);
				// 1C 의 QTY - 4E의 QTY + 지금 받은 IC의 Qty
				ircQty = ircQty + Integer.parseInt(usaRcvMsgVO.getIcrQty());
				// 1C Total Qty (irc_qty) 가 CNTR Qty (qty_69) 와 같으면
				if (ircQty == qty69) {
					if ("H".equals(oldCntrCFlag)) {
						// Hold 가 있으면
						newCntrCFlag = oldCntrCFlag;
						newHoldRemark = oldHoldRemark;
					} else {
						newCntrCFlag = "Y";
					}
				} else {
					// 1C Total Qty (irc_qty) 가 CNTR Qty (qty_69) 와 다르면
					newCntrCFlag = oldCntrCFlag;
				}
			} else if ("4E".equals(usaRcvMsgVO.getIcrCode())) {
				// 이전 Dspo Cd 별 Enter/Release Qty 합산하여 Cntr_Pck_Qty 와 동일할 경우,
				// C-flag =Y or J. 아니면 N
				if (!dbDao.checkRailHoldPairDspo(usaRcvMsgVO)) {
					newCntrCFlag = "H";
				} else {
					newCntrCFlag = dbDao.searchRailCflagHYJ(usaRcvMsgVO);
				}
				if ("H".equals(newCntrCFlag)) {
					newHoldRemark = oldHoldRemark;
				}
			} else {
				newCntrCFlag = oldCntrCFlag;
				newHoldRemark = oldHoldRemark;
			}
		}
		newCFlagHoldRmk[0] = newCntrCFlag;			// 새로운 Flag
		newCFlagHoldRmk[1] = newHoldRemark;
		newCFlagHoldRmk[2] = oldCntrCFlag;			// 이전 Flag
		return newCFlagHoldRmk;
	}

	/**
	 * C-Flag 판단로직
	 *
	 * @param usaRcvMsgVO
	 * @param oldCFlag
	 * @return
	 * @throws DAOException
	 */
	private String getCFlag(UsaRcvMsgVO usaRcvMsgVO, String oldCFlag) {
		log.error("\nUS RCV C Flag Start=====");
		String newCFlag = "N";
		/*********************************************************
		 * 2016.06.30
		 * DSPO_CD = '1C' 이고 Old C = 'H' 인데 그 'H' 가 '1X' 에 의한 것이고
		 * '1X'를 제외하고는 'Hold code' 와 'Hold removal code' 가 없다면
		 * C 는 'Y'가 되어야 한다.
		 *********************************************************/
		if ("H".equals(oldCFlag) && "1C".equals(usaRcvMsgVO.getIcrCode()))
		{
			newCFlag = dbDao.searchCFlag1X1C(usaRcvMsgVO.getBlNo());
			if (!"".equals(newCFlag))
			{
				return newCFlag;
			}
		}
		/*********************************************************
		 * 2010-03-22 : DSPO CODE '4A'의 경우<br>
		 * 그전에 1C가 들어온 경우 N<br>
		 * 그전에 1A, 1B가 들어와서 hold가 풀린경우 4A가 다시 들어오면 'H'<BR>
		 * 4A 후 1B OR 4C가 들어오면 HOLD를 풀어준다('Y')
		 *********************************************************/
		else if ("4A".equals(usaRcvMsgVO.getIcrCode()))
		{
			newCFlag = dbDao.searchCFlag4A(usaRcvMsgVO.getBlNo());
			if (!"".equals(newCFlag))
			{
				if ("H".equals(oldCFlag)) return "H";
				return newCFlag;
			}
		}
		else if ("1B,4C".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
		{
			newCFlag = dbDao.searchCFlag1B4C(usaRcvMsgVO.getBlNo());
			if (!"".equals(newCFlag))
			{
				return newCFlag;
			}
		}
		else
		{
			/*****************************************************************
			 * 2010.08.17 KMJ<BR>
			 * 4A가 들어와서 HOLD가 된 경우<BR>
			 * 1B, 4C가 들어와서 REMOVAL 시키지 못했으면 항상 HOLD가 된다.<BR>
			 * 만일, 1C가 들어와 아래 Y로직을 타서 결과가 'Y'가 되면 문제가 되므로<BR>
			 * 현재 상태가 'H'이고 그 'H'가 '4A'에 의한 HOLD인가를 판단해서<BR>
			 * '4A'에 의한 HOLD인 경우 다음 로직을 타지 않게 한다.
			 *****************************************************************/
			if ("H".equals(oldCFlag) && dbDao.check4AHold(usaRcvMsgVO)) {
				return "H";
			}
		}
		// C-Flag 시작
		newCFlag = "N";

		// Hold가 Pair Removal코드로 Qty가 맞는지 조회
		if (!dbDao.checkHoldRemvQty(usaRcvMsgVO))
		{
			newCFlag = "H";
		}
		/*********************************************************
		 * C-Flag 체크순서 : H -> W -> Y -> J,I,V,T,E -> N<br>
		 * H -> W -> Y(P:Partial BL의 경우 Y대신 P로 세팅) 그외 N<br>
		 *********************************************************/
		if ("N".equals(newCFlag))
		{
			newCFlag = dbDao.searchCFlagHWY(usaRcvMsgVO);
		}
		/*********************************************************
		 * I -> J(D) -> V -> T -> E 그외 N<br>
		 * D:Partial BL의 경우 J대신 D로 세팅)<br>
		 * 이해 안가서 완전 재수정했음.2009-12-15<br>
		 * 김도완수석 C-Flag 로직 version 1.85 참고<br>
		 *********************************************************/
		if ("N".equals(newCFlag))
		{
			newCFlag = dbDao.searchCFlagIJVTE(usaRcvMsgVO, oldCFlag);
		}
		/*********************************************************
		 * 2010.01.26추가<br>
		 * 51, 52의 경우 T, E 로직 추가
		 *********************************************************/
		if ("51,52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
		{
			String tmp5152 = dbDao.searchCFlagTE(usaRcvMsgVO);
			if (!"N".equals(tmp5152))
			{
				newCFlag = tmp5152;
			}
		}
		// 그전 flag가 Hold 인데 N으로 풀리면 반영하지 않고
		// 그전 flag가 Hold가 아니고 J,P,Y,W,T,E의 경우 새로운 flag가 N이 되면 그전 flag유지
		if (   !"H".equals(oldCFlag)
			&& "N".equals(newCFlag)
			&& !"4E".equals(usaRcvMsgVO.getIcrCode())
			&& !"J".equals(oldCFlag  )
			)
			newCFlag = oldCFlag;
		log.error("\nUS RCV C Flag Success=====" + newCFlag);
		return newCFlag;
	}

	/**
	 * Partial BL 체크
	 *
	 * @param usaRcvMsgVO
	 * @param newCFlag
	 * @param cstmsClrs
	 * @return
	 */
	private String getPartialCFlag(UsaRcvMsgVO usaRcvMsgVO, String newCFlag, List<CstmsClrVO> cstmsClrs) {
		/**********************************************
		 * Partial B/L 조회<br>
		 * Partial BL의 경우 Y->P, J->D로 세팅
		 *********************************************/
		usaRcvMsgVO.setIbflag("");
		List<UsaPartialBlVO> usaPartialBlVOs = dbDao.searchPartialBl(usaRcvMsgVO);
		int yjCount = 0;
		String oldCFlag = "";
		for (int i = 0; i < usaPartialBlVOs.size(); i++)
		{
			/**********************************************
			 * Partial은 J(D), Y(P) 이면 증가
			 **********************************************/
			oldCFlag = usaPartialBlVOs.get(i).getLclCustcIndA();
			// KMJ
			usaRcvMsgVO.setOldCFlag(oldCFlag);
			if ("Y".equals(newCFlag))
			{
				if ( "Y".equals(oldCFlag) || "P".equals(oldCFlag))
				{
					yjCount++;
				}
			}
			else if ("J".equals(newCFlag))
			{
				if ( "J".equals(oldCFlag) || "D".equals(oldCFlag))
				{
					yjCount++;
				}
			}
		}
		/**********************************************
		 * Partial 갯수와 같으면 CGO_RLSE를 Y or J로 update<br>
		 * 다르면 현재 BL을 Y -> P, J -> D로 변경한다.
		 **********************************************/

		if (usaPartialBlVOs.size() == yjCount  )
		{
			// 59 code 가 Split B/L 별로 모두 들어오면서 퍼포먼스 저하 방지 목적.
			if (!usaRcvMsgVO.getIcrCode().equals("59") ) {
				for (int i = 0; i < usaPartialBlVOs.size(); i++)
				{
					/**********************************************
					 * Cargo Release Set
					 **********************************************/
					this.setCstmsClr(usaPartialBlVOs.get(i).getLclBlNbrA(), newCFlag, usaRcvMsgVO);

					// Log
					String strLogDesc = "[Partial B/L No:" + usaPartialBlVOs.get(i).getLclBlNbrA() + "] [OLD C-Flag:"
							+ usaPartialBlVOs.get(i).getLclCustcIndA() + "] [NEW C-Flag:" + newCFlag + "] [DT:"
							+ usaRcvMsgVO.getIrDate() + "] [BAT NO:" + usaRcvMsgVO.getCrrBatNo() + "]";
					dbDao.addEnisLog("BKG_USA_RCV_PARTIAL", usaRcvMsgVO.getBlNo(), strLogDesc);
				}
			}
		}
		else
		{
			if ("Y".equals(newCFlag))
				newCFlag = "P";
			if ("J".equals(newCFlag))
				newCFlag = "D";
		}
		return newCFlag;
	}

	/**
	 * 1J : IBD.IBD_TRSP_ACPT_DT
	 * 11,13 : IBD.IBD_TRSP_ARR_DT
	 * @param usaRcvMsgVO
	 */
	private void setAccpDate(UsaRcvMsgVO usaRcvMsgVO) {
		try
		{
			if ("1J".equals(usaRcvMsgVO.getIcrCode()))
			{
				usaRcvMsgVO.setIbflag("ACPT");
				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
			}
			else if ("11,12,13".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
			{
				usaRcvMsgVO.setIbflag("ARR");
				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
			}
			else if ("50,51,52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
			{
				usaRcvMsgVO.setIbflag("XPT");
				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
			}
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}

	/**
	 * Transmit 하기 위한 세관 테이블의 Customer, Container 등의 Terminal BL 정보를 조회한다
	 *
	 * @param BlInfoCondVO blInfoCondVO
	 * @return List<BlInfoVO>
	 * @exception EventException
	 */
	public List<BlInfoVO> searchTmlBlByVvd(BlInfoCondVO blInfoCondVO) throws EventException {
		try
		{
			return dbDao.searchUsaTmlBlByVvd(blInfoCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}
	}

	/**
	 * Baplie Alarm List를 조회한다.
	 *
	 * @param BaplieAlarmSetupVO baplieAlarmSetupVO
	 * @return List<BaplieAlarmSetupVO>
	 * @exception EventException
	 */
	public List<BaplieAlarmSetupVO> searchBaplieAlarmSetup(BaplieAlarmSetupVO baplieAlarmSetupVO) throws EventException {
		try{
			return dbDao.searchBaplieAlarmSetup(baplieAlarmSetupVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}
	}

	/**
	 * Baplie Alarm List를 관리한다.
	 *
	 * @param baplieAlarmSetupVOs BaplieAlarmSetupVO[]
	 * @param user_id String
	 * @exception EventException
	 */
	public void manageBaplieAlarmSetup(BaplieAlarmSetupVO[] baplieAlarmSetupVOs, String user_id) throws EventException {
		try {
			List<BaplieAlarmSetupVO> addList = new ArrayList<BaplieAlarmSetupVO>();
			List<BaplieAlarmSetupVO> modList = new ArrayList<BaplieAlarmSetupVO>();
			List<BaplieAlarmSetupVO> delList = new ArrayList<BaplieAlarmSetupVO>();
			BaplieAlarmSetupVO baplieAlarmSetupVO = new BaplieAlarmSetupVO();

			for (int i = 0; i < baplieAlarmSetupVOs.length; i++) {
				baplieAlarmSetupVO.setSlanCd(baplieAlarmSetupVOs[i].getSlanCd());
				baplieAlarmSetupVO.setLstPortCd(baplieAlarmSetupVOs[i].getLstPortCd());
				baplieAlarmSetupVO.setRcvrEml(baplieAlarmSetupVOs[i].getRcvrEml());
				if (baplieAlarmSetupVOs[i].getIbflag().equals("I")) {
					// 중복체크
					if (dbDao.searchBaplieAlarmSetup(baplieAlarmSetupVO).size() > 0) {
						throw new EventException(new ErrorHandler("BKG01126").getMessage());
					}
					addList.add(baplieAlarmSetupVOs[i]);
				} else if (baplieAlarmSetupVOs[i].getIbflag().equals("U")) {
					// 입력한 값과 그전 입력된 값이 다를 경우 중복체크
					if (!baplieAlarmSetupVOs[i].getHiddenLstPortCd().equals(baplieAlarmSetupVOs[i].getLstPortCd())
							|| !baplieAlarmSetupVOs[i].getHiddenRcvrEml().equals(baplieAlarmSetupVOs[i].getRcvrEml())
							|| !baplieAlarmSetupVOs[i].getHiddenSlanCd().equals(baplieAlarmSetupVOs[i].getSlanCd())
					)
					if (dbDao.searchBaplieAlarmSetup(baplieAlarmSetupVO).size() > 0) {
						throw new EventException(new ErrorHandler("BKG01126").getMessage());
					}
					modList.add(baplieAlarmSetupVOs[i]);
				} else if (baplieAlarmSetupVOs[i].getIbflag().equals("D")) {
					delList.add(baplieAlarmSetupVOs[i]);
				}
				// 로그인 아이디
				baplieAlarmSetupVOs[i].setUserId(user_id);
			}
			if (addList.size() > 0)
				dbDao.addBaplieAlarmSetup(addList);
			if (modList.size() > 0)
				dbDao.modifyBaplieAlarmSetup(modList);
			if (delList.size() > 0)
				dbDao.removeBaplieAlarmSetup(delList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EDI 오류
	 * @param msg
	 * @throws Exception
	 */
	public void loadEdiErr(String msg) throws Exception
	{
		String sDiv = "";
		if (msg.indexOf("\r\n") != -1)	sDiv = "\r\n";
		else							sDiv = "\n";

		String[] arrRcvMsg = msg.split(sDiv);
		String orgMsgKey = "";

		for (int i = 0; i < arrRcvMsg.length; i++)
		{
			if (arrRcvMsg[i].startsWith("ORG_MSG_KEY:"))
			{
				orgMsgKey = arrRcvMsg[i].substring(12);
			}
		}
		CstmsEmlNtfcVO eml = null;
		// BL조회
		List<CndCstmsBlByKeyVO> list = dbDao.searchBlForCrrBatNo(orgMsgKey);
		CndCstmsBlByKeyVO bl = null;
		StringBuffer sbBlNo = new StringBuffer();
		CstmsEmlNtfcVO emlParam = new CstmsEmlNtfcVO();

		for (int i = 0; i < list.size(); i++)
		{
			// 수신인 조회
			if (i == 0)
			{
				bl = list.get(0);
				emlParam.setCntCd("US");
				emlParam.setEdiMsg(bl.getIbflag());
				emlParam.setEdiMsgTpId("EDI Technical Failure");
				emlParam.setPolCd(bl.getCstmsPolCd());
				emlParam.setPodCd(bl.getCstmsPodCd());
			}
			else
			{
				sbBlNo.append(", ");
			}
			sbBlNo.append(list.get(i).getBlNo());
		}

		/***************************************
		 * 수신처 조회
		 ***************************************/
		if (bl != null )
		{
			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
			eml = comBc.searchCstmsEmlNtfcInfo(emlParam);

			if (eml != null && eml.getToEmlCtnt() != null)
			{
				TemplateMail template = new TemplateMail();
				if ("AMS".equals(bl.getIbflag()))
				{
					template.setHtmlTemplate("ESM_BKG_RCV_EML_US02T.html");
					template.setSubject("US24 - Technical Failure BL Number : " + bl.getBlNo());

					template.setArg("vvd", bl.getVvd());
					template.setArg("blNo", bl.getBlNo());
					template.setArg("pol", bl.getCstmsPolCd());
					template.setArg("pod", bl.getCstmsPodCd());
				}
				else
				{
					template.setHtmlTemplate("ESM_BKG_RCV_EML_US10T.html");
					template.setSubject("US24 - Vessel Departure Technical Failure : " + bl.getCstmsPolCd() + "(POL)-"+ bl.getVvd());

					template.setArg("vvd", bl.getVvd());
					template.setArg("pol", bl.getCstmsPolCd());
					template.setArg("pod", bl.getCstmsPodCd());
				}

				template.setBatFlg("N");
				template.setFrom("noreply@cyberlogitec.com", "CTM EDI Monitor");
				template.setRecipient(eml.getToEmlCtnt());
				template.setCcRcvrEml(eml.getCcEmlCtnt());
				template.send();
			}
		}
	}

	/**
	 *
	 * @param value
	 * @param digitCnt
	 * @param digit
	 * @param leftRight
	 * @return
	 */
	private String getDigitBlank(String value, int digitCnt, String digit, String leftRight)
	{
		StringBuffer sbBlank = new StringBuffer();
		if (value.length() >= digitCnt)
			return value;

		if ("R".equals(leftRight)) {
			sbBlank.append(value);
		}

		for (int i = 0; i < digitCnt - value.length(); i++) {
			if ("".equals(digit) && "R".equals(leftRight))
				digit = " ";
			if ("".equals(digit) && "L".equals(leftRight))
				digit = "0";
			sbBlank.append(digit);
		}

		if ("L".equals(leftRight)) {
			sbBlank.append(value);
		}
		return sbBlank.toString().substring(0, digitCnt);
	}

	/**
	 * Cargo Release Setup
	 * @param blNo
	 * @param newCFlag
	 * @param usaRcvMsgVO
	 */
	private void setCstmsClr(String blNo, String newCFlag, UsaRcvMsgVO usaRcvMsgVO) {

		/**********************************************
		 * Cargo Release Set
		 **********************************************/
		// 한진해운은 BL 1개당 1건의 MSG가 들어
		for (int i = 0; i < cstmsClrs.size(); i++) {
			if (cstmsClrs.get(i).getBlNo().equals(blNo)) {
				cstmsClrs.remove(i);
			}
		}
		CstmsClrVO cstmsClr = new CstmsClrVO();
		cstmsClr.setBlNo(blNo);
		cstmsClr.setCstmsClrCd(newCFlag);
		cstmsClr.setCstmsDsPoCd(usaRcvMsgVO.getIcrCode());
		cstmsClr.setEvntOfcCd(ConstantMgr.getHeadOfficeCode());
		cstmsClr.setEvntUsrId("AMS");
		if (Integer.parseInt(usaRcvMsgVO.getIrDate().substring(0, 2)) > 70)
			cstmsClr.setEvntDt("19" + usaRcvMsgVO.getIrDate());
		else
			cstmsClr.setEvntDt("20" + usaRcvMsgVO.getIrDate());
		cstmsClr.setCgorTeamCd("A");
		cstmsClr.setCgoEvntNm("AMS_RCV");
		cstmsClr.setCstmsLocCd(usaRcvMsgVO.getCusLoc());
		cstmsClrs.add(cstmsClr);
	}
}