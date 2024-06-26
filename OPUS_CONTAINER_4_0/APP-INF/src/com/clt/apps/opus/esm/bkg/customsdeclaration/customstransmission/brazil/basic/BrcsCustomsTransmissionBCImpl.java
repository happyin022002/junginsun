/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrcsCustomsTransmissionBCImpl.java
*@FileTitle : BrcsCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.25 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration.BrcsCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BkgQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrBlLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrCmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrCntrRfAkBrCgoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrDgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrEtaInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrMndDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoTTLVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrSealInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrVslCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrVvdSkdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0127EventResponse,BrcsCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BrcsCustomsTransmissionBCImpl extends BasicCommandSupport implements BrcsCustomsTransmissionBC {
 
	// Database Access Object
	private transient BrcsCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CndCustomsTransmissionBCImpl 객체 생성<br>
	 * CndCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public BrcsCustomsTransmissionBCImpl() {
		dbDao = new BrcsCustomsTransmissionDBDAO();
	}

	/**
	 * 브라질 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {

		BrManifestTransmitVO[] brManifestTransmitVOs = (BrManifestTransmitVO[]) manifestTransmitVOs;

		boolean inFlag = true;
		String preBlNo = "";
		String localSendTime = "";

		BookingUtil command = new BookingUtil();
		BrVslCondVO brVslCondVO = new BrVslCondVO();
		StringBuffer flatFile = new StringBuffer();

		// send log 저장 VO
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();

		try {

			// 0. FlatFile Header를 생성한다.
			// header = command.searchCstmsEdiHeader(ConstantMgr.getCompanyCode(), rcvId, "COPRAR");
			flatFile.append(command.searchCstmsEdiHeaderNew("BR_COPRAR")).append("\n");

			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();

			for (int i = 0; i < manifestTransmitVOs.length; i++) {

				BrManifestTransmitVO brManifestTransmitVO = brManifestTransmitVOs[i];

				brVslCondVO.setVvdCd(brManifestTransmitVO.getVvdCd());
				brVslCondVO.setPodCd(brManifestTransmitVO.getPodCd());
				brVslCondVO.setPolCd(brManifestTransmitVO.getPolCd());
				brVslCondVO.setBlNo(brManifestTransmitVO.getBlNo());
				brVslCondVO.setCompId("USA");
				brVslCondVO.setBkgNo(brManifestTransmitVO.getBkgNo());
				brVslCondVO.setCntrNo(brManifestTransmitVO.getCntrNo());
				brVslCondVO.setHideCheck(brManifestTransmitVO.getHideCheck());
				brVslCondVO.setCntGubun("BR");
				brVslCondVO.setIbflag(brManifestTransmitVO.getIbflag());
				
				if (inFlag) {

					localSendTime = command.searchTimeLocalOfcFnc(account.getOfc_cd());
					localSendTime = localSendTime.replaceAll("-", "");
					localSendTime = localSendTime.replaceAll(":", "");

					// 1.VSL/VVD정보 가져오기
					BrVvdSkdInfoVO brVvdSkdInfoVO = dbDao.searchBkgVvdByVvd(brVslCondVO);

					// VSL/VVD정보 셋팅
					if (brVvdSkdInfoVO != null) {
						flatFile.append("BRAC:").append(brVvdSkdInfoVO.getBrac()).append("\n");
						flatFile.append("VVD:").append(brVvdSkdInfoVO.getVvd()).append("\n");
						String strPortCd = brVslCondVO.getPolCd();
						String strIotype = brManifestTransmitVO.getIbflag();
						if ("I".equals(strIotype))
							strPortCd = brVslCondVO.getPodCd();
						flatFile.append("CON_VVD:").append(comBc.searchConVvd(brVvdSkdInfoVO.getVvd(), strPortCd, strIotype)).append("\n");
						flatFile.append("VSL_CALLSIGN:").append(brVvdSkdInfoVO.getVslCallsign()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(brVvdSkdInfoVO.getVslLloydcode()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(brVvdSkdInfoVO.getVslFullname()).append("\n");

						flatFile.append("LANE_CD:").append(brVvdSkdInfoVO.getLaneCd()).append("\n");
						flatFile.append("VVD_REF_NO:").append(brVvdSkdInfoVO.getVvdRefNo()).append("\n");
						flatFile.append("PORT:").append(brVvdSkdInfoVO.getPort()).append("\n");
						flatFile.append("PORTNAME:").append(brVvdSkdInfoVO.getPortname()).append("\n");
						flatFile.append("ETA:").append(brVvdSkdInfoVO.getEta()).append("\n");

						flatFile.append("ETD:").append(brVvdSkdInfoVO.getEtd()).append("\n");
						flatFile.append("NEXTPORT:").append(brVvdSkdInfoVO.getNextport()).append("\n");
						flatFile.append("NEXTPORT_ETA:").append(brVvdSkdInfoVO.getNextportEta()).append("\n");
						flatFile.append("PREVPORT:").append(brVvdSkdInfoVO.getPrevport()).append("\n");
						flatFile.append("PREVPORT_ETD:").append(brVvdSkdInfoVO.getPrevportEtd()).append("\n");

						flatFile.append("IO_IND:").append(brVvdSkdInfoVO.getIoInd()).append("\n");
						flatFile.append("COMP_ID:").append(brVvdSkdInfoVO.getCompId()).append("\n");
						flatFile.append("MRN:").append(brVvdSkdInfoVO.getMrn()).append("\n");
					}

					inFlag = false;
					
				} // end if(checkBlNo)

				if (!brManifestTransmitVO.getBlNo().equals(preBlNo)) {

					flatFile.append("{BL_INFO").append("\n");

					// 2. EDI 전송 여부를 조회한다.(기전송여부) -> 3번에 포함 : CUSTREF_NUM

					// 3. BL 일반 정보 및 location 정보를 조회한다.
					BrBlLocInfoVO brBlLocInfoVO = dbDao.searchBlLocInfo(brVslCondVO);

					if (brBlLocInfoVO == null)
					{
						throw new EventException(new ErrorHandler("BKG01051").getMessage());
					}

					flatFile.append("BLNBR:").append(brBlLocInfoVO.getBlnbr()).append("\n");
					flatFile.append("BLPOL:").append(brBlLocInfoVO.getBlpol()).append("\n");
					flatFile.append("POL_AMS:").append(brBlLocInfoVO.getPolAms()).append("\n");
					flatFile.append("POL_FULLNAME:").append(brBlLocInfoVO.getPolFullname()).append("\n");
					flatFile.append("BLPOD:").append(brBlLocInfoVO.getBlpod()).append("\n");
					flatFile.append("POD_AMS:").append(brBlLocInfoVO.getPodAms()).append("\n");
					flatFile.append("POD_FULLNAME:").append(brBlLocInfoVO.getPodFullname()).append("\n");
					flatFile.append("BLPOR:").append(brBlLocInfoVO.getBlpor()).append("\n");
					flatFile.append("POR_AMS:").append(brBlLocInfoVO.getPorAms()).append("\n");
					flatFile.append("POR_FULLNAME:").append(brBlLocInfoVO.getPorFullname()).append("\n");
					flatFile.append("BLDEL:").append(brBlLocInfoVO.getBldel()).append("\n");
					flatFile.append("DEL_AMS:").append(brBlLocInfoVO.getDelAms()).append("\n");
					flatFile.append("DEL_FULLNAME:").append(brBlLocInfoVO.getDelFullname()).append("\n");
					flatFile.append("BLRLY:").append(brBlLocInfoVO.getBlrly()).append("\n");
					flatFile.append("RLY_AMS:").append(brBlLocInfoVO.getRlyAms()).append("\n");
					flatFile.append("RLY_FULLNAME:").append(brBlLocInfoVO.getRlyFullname()).append("\n");
					flatFile.append("BLPLACE:").append(brBlLocInfoVO.getBlplace()).append("\n");
					flatFile.append("BLDATE:").append(brBlLocInfoVO.getBldate()).append("\n");
					flatFile.append("SHPRCN:").append(brBlLocInfoVO.getShprcn()).append("\n");
					flatFile.append("SHPRCD:").append(brBlLocInfoVO.getShprcd()).append("\n");
					flatFile.append("SHPR1:").append(brBlLocInfoVO.getShpr1()).append("\n");
					flatFile.append("SHPR2:").append(brBlLocInfoVO.getShpr2()).append("\n");
					flatFile.append("SHPR3:").append(brBlLocInfoVO.getShpr3()).append("\n");
					flatFile.append("SHPR4:").append(brBlLocInfoVO.getShpr4()).append("\n");
					flatFile.append("SHPR5:").append(brBlLocInfoVO.getShpr5()).append("\n");
					flatFile.append("CNEECN:").append(brBlLocInfoVO.getCneecn()).append("\n");
					flatFile.append("CNEECD:").append(brBlLocInfoVO.getCneecd()).append("\n");
					flatFile.append("CNEE1:").append(brBlLocInfoVO.getCnee1()).append("\n");
					flatFile.append("CNEE2:").append(brBlLocInfoVO.getCnee2()).append("\n");
					flatFile.append("CNEE3:").append(brBlLocInfoVO.getCnee3()).append("\n");
					flatFile.append("CNEE4:").append(brBlLocInfoVO.getCnee4()).append("\n");
					flatFile.append("CNEE5:").append(brBlLocInfoVO.getCnee5()).append("\n");
					flatFile.append("NTFYCN:").append(brBlLocInfoVO.getNtfycn()).append("\n");
					flatFile.append("NTFYCD:").append(brBlLocInfoVO.getNtfycd()).append("\n");
					flatFile.append("NTFY1:").append(brBlLocInfoVO.getNtfy1()).append("\n");
					flatFile.append("NTFY2:").append(brBlLocInfoVO.getNtfy2()).append("\n");
					flatFile.append("NTFY3:").append(brBlLocInfoVO.getNtfy3()).append("\n");
					flatFile.append("NTFY4:").append(brBlLocInfoVO.getNtfy4()).append("\n");
					flatFile.append("NTFY5:").append(brBlLocInfoVO.getNtfy5()).append("\n");
					flatFile.append("NTFY2CN:").append(brBlLocInfoVO.getNtfy2cn()).append("\n");
					flatFile.append("NTFY2CD:").append("").append("\n");
					flatFile.append("NTFY21:").append(brBlLocInfoVO.getNtfy21()).append("\n");
					flatFile.append("NTFY22:").append(brBlLocInfoVO.getNtfy22()).append("\n");
					flatFile.append("NTFY23:").append(brBlLocInfoVO.getNtfy23()).append("\n");
					flatFile.append("NTFY24:").append(brBlLocInfoVO.getNtfy24()).append("\n");
					flatFile.append("NTFY25:").append(brBlLocInfoVO.getNtfy25()).append("\n");
					flatFile.append("FFWDCN:").append(brBlLocInfoVO.getFfwdcn()).append("\n");
					flatFile.append("FFWDCD:").append(brBlLocInfoVO.getFfwdcd()).append("\n");
					flatFile.append("FFWD1:").append(brBlLocInfoVO.getFfwd1()).append("\n");
					flatFile.append("FFWD2:").append(brBlLocInfoVO.getFfwd2()).append("\n");
					flatFile.append("FFWD3:").append(brBlLocInfoVO.getFfwd3()).append("\n");
					flatFile.append("FFWD4:").append(brBlLocInfoVO.getFfwd4()).append("\n");
					flatFile.append("FFWD5:").append(brBlLocInfoVO.getFfwd5()).append("\n");
					flatFile.append("EXPOCN:").append(brBlLocInfoVO.getExpocn()).append("\n");
					flatFile.append("EXPOCD:").append(brBlLocInfoVO.getExpocd()).append("\n");
					flatFile.append("EXPO1:").append("").append("\n");
					flatFile.append("EXPO2:").append("").append("\n");
					flatFile.append("EXPO3:").append("").append("\n");
					flatFile.append("EXPO4:").append("").append("\n");
					flatFile.append("EXPO5:").append("").append("\n");
					flatFile.append("BLCOPY:").append(brBlLocInfoVO.getBlcopy()).append("\n");
					flatFile.append("BLORG:").append("").append("\n");
					flatFile.append("BLPKG:").append(brBlLocInfoVO.getBlpkg()).append("\n");
					flatFile.append("BLPKGU:").append(brBlLocInfoVO.getBlpkgu()).append("\n");
					flatFile.append("BLWGT:").append(brBlLocInfoVO.getBlwgt()).append("\n");
					flatFile.append("BL_WGT_UNIT:").append(brBlLocInfoVO.getBlWgtUnit()).append("\n");
					flatFile.append("BLMEA:").append(brBlLocInfoVO.getBlmea()).append("\n");
					flatFile.append("BL_MEA_UNIT:").append(brBlLocInfoVO.getBlMeaUnit()).append("\n");
					flatFile.append("RDTYPE:").append(brBlLocInfoVO.getRdtype()).append("\n");
					flatFile.append("CARGOTYPE:").append(brBlLocInfoVO.getCargotype()).append("\n");
					flatFile.append("COMMODITY:").append("").append("\n");
					flatFile.append("BLCMD:").append("").append("\n");
					flatFile.append("BLREPCMDCD:").append("").append("\n");
					flatFile.append("BLREPCMD:").append("").append("\n");
					flatFile.append("REMARK:").append(brBlLocInfoVO.getRemark()).append("\n");
					flatFile.append("AUS_QUAR:").append("").append("\n");
					flatFile.append("SRNBR:").append("").append("\n");
					flatFile.append("BKGNBR:").append(brBlLocInfoVO.getBkgnbr()).append("\n");
					flatFile.append("RGN_BKGNBR:").append("").append("\n");
					flatFile.append("PPDOFC:").append(brBlLocInfoVO.getPpdofc()).append("\n");
					flatFile.append("CCTOFC:").append(brBlLocInfoVO.getCctofc()).append("\n");
					flatFile.append("THDOFC:").append(brBlLocInfoVO.getThdofc()).append("\n");
					flatFile.append("SCNO:").append(brBlLocInfoVO.getScno()).append("\n");
					flatFile.append("RFANO:").append(brBlLocInfoVO.getRfano()).append("\n");
					flatFile.append("WAYBILL_IND:").append(brBlLocInfoVO.getWaybillInd()).append("\n");
					flatFile.append("CUSTREF_NUM:").append((brBlLocInfoVO.getCustrefNum() == "0") ? "N" : "U").append("\n");
					flatFile.append("FINAL_ETA:").append("").append("\n");
					flatFile.append("FUNC_CODE:").append("").append("\n");
					flatFile.append("ONBOARD:").append(brBlLocInfoVO.getOnboard()).append("\n");
					flatFile.append("INV_NO:").append("").append("\n");
					flatFile.append("BLTS:").append("").append("\n");
					flatFile.append("BLTP:").append("").append("\n");   
					flatFile.append("MSN:").append("").append("\n");
					flatFile.append("MSNCFM:").append("").append("\n");
					flatFile.append("CMDESC:").append("").append("\n");
					flatFile.append("LOCAL_IPI:").append("").append("\n");
					flatFile.append("EQREL:").append(brBlLocInfoVO.getEqrel()).append("\n");
					flatFile.append("EQPICKDT:").append(brBlLocInfoVO.getEqpickdt()).append("\n");
					flatFile.append("EQRTN:").append(brBlLocInfoVO.getEqrtn()).append("\n");
					flatFile.append("TRANS_MODE:").append("").append("\n");
					flatFile.append("UD_CD:").append("").append("\n");
					flatFile.append("BR_DUV:").append(brBlLocInfoVO.getBrDuv()).append("\n");
					flatFile.append("BR_MID:").append(brBlLocInfoVO.getBrMid()).append("\n");
					flatFile.append("TS_IND:").append(brBlLocInfoVO.getTsInd()).append("\n");
					flatFile.append("EX_IND:").append(brBlLocInfoVO.getExInd()).append("\n");

					// 4. Rate 정보를 조회한다.
					List<BrRateInfoVO> brRateInfoVOList = dbDao.searchRateAmount(brVslCondVO);

					for (int idx = 0; idx < brRateInfoVOList.size(); idx++) {
						
						BrRateInfoVO brRateInfoVO = brRateInfoVOList.get(idx);

						flatFile.append("{CHARGE").append("\n");
						flatFile.append("FCTYPE:").append(brRateInfoVO.getFctype()).append("\n");
						flatFile.append("RATE:").append(brRateInfoVO.getRate()).append("\n");
						flatFile.append("REVENUETON:").append(brRateInfoVO.getRevenueton()).append("\n");
						flatFile.append("PPD:").append(brRateInfoVO.getPpd()).append("\n");
						flatFile.append("CCT:").append(brRateInfoVO.getCct()).append("\n");
						flatFile.append("CURRENCYCODE:").append(brRateInfoVO.getCurrencycode()).append("\n");
						flatFile.append("EXCHRATE:").append(brRateInfoVO.getExchrate()).append("\n");
						flatFile.append("TARIFF:").append(brRateInfoVO.getTariff()).append("\n");
						flatFile.append("PERTYPE:").append(brRateInfoVO.getPertype()).append("\n");
						flatFile.append("RATEOFC:").append(brRateInfoVO.getRateofc()).append("\n");
						flatFile.append("}CHARGE").append("\n");

					} // end for(idx)

					// 5. Rate TOTAL 정보를 조회한다.
					List<BrRateInfoTTLVO> brRateInfoTTLVOList = dbDao.searchRateAmountTTL(brVslCondVO);

					for (int idx = 0; idx < brRateInfoTTLVOList.size(); idx++) {

						BrRateInfoTTLVO brRateInfoTTLVO = brRateInfoTTLVOList.get(idx);

						flatFile.append("{CHARGE_TTL").append("\n");
						flatFile.append("PPD_TOTAL:").append(brRateInfoTTLVO.getPpdTotal()).append("\n");
						flatFile.append("CCT_TOTAL:").append(brRateInfoTTLVO.getCctTotal()).append("\n");
						flatFile.append("TOTAL_CUR:").append(brRateInfoTTLVO.getTotalCur()).append("\n");
						flatFile.append("}CHARGE_TTL").append("\n");

					} // end for(idx)

					// 6. BKG의 Mark/Desc 정보를 조회한다.
					BrMndDescInfoVO brMndDescInfoVO = dbDao.searchMarkDescInfo(brVslCondVO);

					if (brMndDescInfoVO != null) {
						String cmdtDesc = brMndDescInfoVO.getCmdtDesc();
						String[] str1 = cmdtDesc.split("\n");
						String mkMark = brMndDescInfoVO.getMkMark();
						String[] str2 = mkMark.split("\n");

						flatFile.append("{DESC").append("\n");
						for (int idx = 0; idx < str1.length; idx++) {
							// if(str1[idx].length() >= 50) {
							flatFile.append("DESC:").append(str1[idx]).append("\n");
							// }
						}
						flatFile.append("}DESC").append("\n");

						flatFile.append("{MARK").append("\n");
						for (int idx = 0; idx < str2.length; idx++) {
							flatFile.append("MARKNO:").append(str2[idx]).append("\n");
						}
						flatFile.append("}MARK").append("\n");

					}

					// 7. Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.
					brVslCondVO.setBkgCgoTp(brBlLocInfoVO.getInBkgCgoTpCd());
					brVslCondVO.setBkgSpeRf(brBlLocInfoVO.getInRcFlg());
					brVslCondVO.setBkgSpeDg(brBlLocInfoVO.getInDcgoFlg());
					brVslCondVO.setBkgSpeAk(brBlLocInfoVO.getInAwkCgoFlg());
					brVslCondVO.setBkgSpeBb(brBlLocInfoVO.getInBbCgoFlg());
					brVslCondVO.setCmdtDesc(brBlLocInfoVO.getInCmdtDesc());
					brVslCondVO.setCmdtCd(brBlLocInfoVO.getInCmdtCd());

					List<BrCntrRfAkBrCgoInfoVO> brCntrRfAkBrCgoInfoVOList = dbDao.searchCntrRfAkBrCgo(brVslCondVO);

					for (int cntrIdx = 0; cntrIdx < brCntrRfAkBrCgoInfoVOList.size(); cntrIdx++) {

						BrCntrRfAkBrCgoInfoVO brCntrRfAkBrCgoInfoVO = brCntrRfAkBrCgoInfoVOList.get(cntrIdx);

						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTRNBR:").append(brCntrRfAkBrCgoInfoVO.getCntrnbr()).append("\n");
						flatFile.append("PUNIT:").append(brCntrRfAkBrCgoInfoVO.getPunit()).append("\n");
						flatFile.append("PKG:").append(brCntrRfAkBrCgoInfoVO.getPkg()).append("\n");
						flatFile.append("CNTRWGT:").append(brCntrRfAkBrCgoInfoVO.getCntrwgt()).append("\n");
						flatFile.append("CNTRGWGT:").append(brCntrRfAkBrCgoInfoVO.getCntrgwgt()).append("\n");
						flatFile.append("CNTR_WGT_UNIT:").append(brCntrRfAkBrCgoInfoVO.getCntrWgtUnit()).append("\n");
						flatFile.append("CNTRTRW:").append(brCntrRfAkBrCgoInfoVO.getCntrtrw()).append("\n");
						flatFile.append("CNTRTYPE:").append(brCntrRfAkBrCgoInfoVO.getCntrtype()).append("\n");

						// 8. Seal 정보를 조회한다.
						brVslCondVO.setCntrNo(brCntrRfAkBrCgoInfoVO.getCntrNo()); // Container Number를 넣어주는 것 처리

						List<BrSealInfoVO> brSealInfoVOList = dbDao.searchSealInfo(brVslCondVO);

						for (int sealIdx = 0; sealIdx < brSealInfoVOList.size(); sealIdx++) {
							BrSealInfoVO brSealInfoVO = brSealInfoVOList.get(sealIdx);

							flatFile.append("{CNTR_SEAL:").append("\n");
							flatFile.append("SEALNBR:").append(brSealInfoVO.getSealnbr()).append("\n");
							flatFile.append("SEAL_PT:").append(brSealInfoVO.getSealPt()).append("\n");
							flatFile.append("}CNTR_SEAL").append("\n");
						}

						flatFile.append("FM_IND:").append(brCntrRfAkBrCgoInfoVO.getFmInd()).append("\n");
						flatFile.append("RF_IND:").append(brCntrRfAkBrCgoInfoVO.getRfInd()).append("\n");
						flatFile.append("DG_IND:").append(brCntrRfAkBrCgoInfoVO.getDgInd()).append("\n");
						flatFile.append("AK_IND:").append(brCntrRfAkBrCgoInfoVO.getAkInd()).append("\n");
						flatFile.append("BK_IND:").append(brCntrRfAkBrCgoInfoVO.getBkInd()).append("\n");
						flatFile.append("TEMP:").append(brCntrRfAkBrCgoInfoVO.getTemp()).append("\n");
						flatFile.append("TUNIT:").append(brCntrRfAkBrCgoInfoVO.getTunit()).append("\n");
						flatFile.append("VENT:").append(brCntrRfAkBrCgoInfoVO.getVent()).append("\n");
						flatFile.append("MEASURE:").append(brCntrRfAkBrCgoInfoVO.getMeasure()).append("\n");
						flatFile.append("MEASURE_UNIT:").append(brCntrRfAkBrCgoInfoVO.getMeasureUnit()).append("\n");
						flatFile.append("RDTYPE:").append(brCntrRfAkBrCgoInfoVO.getRdtype()).append("\n");
						flatFile.append("CMDT_DESC:").append(brCntrRfAkBrCgoInfoVO.getCmdtDesc()).append("\n");
						flatFile.append("CMDTCD:").append(brCntrRfAkBrCgoInfoVO.getCmdtCd()).append("\n");
						flatFile.append("RF_REMARK:").append(brCntrRfAkBrCgoInfoVO.getRfRemark()).append("\n");
						flatFile.append("RFDRY_IND:").append(brCntrRfAkBrCgoInfoVO.getRfdryInd()).append("\n");
						flatFile.append("OVF:").append(brCntrRfAkBrCgoInfoVO.getOvf()).append("\n");
						flatFile.append("OVR:").append(brCntrRfAkBrCgoInfoVO.getOvr()).append("\n");
						flatFile.append("OVH:").append(brCntrRfAkBrCgoInfoVO.getOvh()).append("\n");
						flatFile.append("OVLW:").append(brCntrRfAkBrCgoInfoVO.getOvlw()).append("\n");
						flatFile.append("OVRW:").append(brCntrRfAkBrCgoInfoVO.getOvrw()).append("\n");
						flatFile.append("OVWGT:").append(brCntrRfAkBrCgoInfoVO.getOvwgt()).append("\n");
						flatFile.append("OVWGT_UNIT:").append(brCntrRfAkBrCgoInfoVO.getOvwgtUnit()).append("\n");
						flatFile.append("VOID_SLOT:").append(brCntrRfAkBrCgoInfoVO.getVoidSlot()).append("\n");
						flatFile.append("STWG_REQ:").append(brCntrRfAkBrCgoInfoVO.getStwgReq()).append("\n");
						flatFile.append("SOCIND:").append(brCntrRfAkBrCgoInfoVO.getSocind()).append("\n");
						flatFile.append("HAULAGE:").append(brCntrRfAkBrCgoInfoVO.getHaulage()).append("\n");
						flatFile.append("BKWGT:").append(brCntrRfAkBrCgoInfoVO.getBkwgt()).append("\n");
						flatFile.append("BKWGTU:").append(brCntrRfAkBrCgoInfoVO.getBkwgtu()).append("\n");
						flatFile.append("BKW:").append(brCntrRfAkBrCgoInfoVO.getBkw()).append("\n");
						flatFile.append("BKH:").append(brCntrRfAkBrCgoInfoVO.getBkh()).append("\n");
						flatFile.append("BKL:").append(brCntrRfAkBrCgoInfoVO.getBkl()).append("\n");
						flatFile.append("CNTROWN:").append(brCntrRfAkBrCgoInfoVO.getCntrown()).append("\n");
						flatFile.append("CNTRTRM:").append(brCntrRfAkBrCgoInfoVO.getCntrtrm()).append("\n");

						brVslCondVO.setCntrNo(brCntrRfAkBrCgoInfoVO.getCntrNo());

						// 9. LCL/FCL 여부를 확인한다.
						// String retVal = dbDao.checkLclFcl(brVslCondVO);
						flatFile.append("FCL_LCL:").append(brBlLocInfoVO.getFclLcl()).append("\n");
						flatFile.append("PARTIAL:").append(brCntrRfAkBrCgoInfoVO.getCntrPrtFlg()).append("\n");

						// 10. 위험물 정보를 조회한다.
						List<BrDgInfoVO> brDgInfoVOList = dbDao.searchDangerCgo(brVslCondVO);

						for (int dgIdx = 0; dgIdx < brDgInfoVOList.size(); dgIdx++) {
							BrDgInfoVO brDgInfoVO = brDgInfoVOList.get(dgIdx);

							flatFile.append("{CNTR_DANGER").append("\n");
							flatFile.append("UNNBR:").append(brDgInfoVO.getUnnbr()).append("\n");
							flatFile.append("CLASS:").append(brDgInfoVO.getClass1()).append("\n");
							flatFile.append("DG_DESC:").append(brDgInfoVO.getDgDesc()).append("\n");
							flatFile.append("PHONE:").append(brDgInfoVO.getPhone()).append("\n");
							flatFile.append("PAGE:").append(brDgInfoVO.getPage()).append("\n");
							flatFile.append("FLSH_TEMP:").append(brDgInfoVO.getFlshTemp()).append("\n");
							flatFile.append("FLSH_UNIT:").append(brDgInfoVO.getFlshUnit()).append("\n");
							flatFile.append("DG_REMARK:").append(brDgInfoVO.getDgRemark()).append("\n");
							flatFile.append("EMSNO:").append(brDgInfoVO.getEmsno()).append("\n");
							flatFile.append("PSACLS:").append(brDgInfoVO.getPsacls()).append("\n");
							flatFile.append("PKGGRP:").append(brDgInfoVO.getPkggrp()).append("\n");
							flatFile.append("MFAG1:").append(brDgInfoVO.getMfag1()).append("\n");
							flatFile.append("MFAG2:").append(brDgInfoVO.getMfag2()).append("\n");
							flatFile.append("MAR_POLL:").append(brDgInfoVO.getMarPoll()).append("\n");
							flatFile.append("LABEL_CD:").append(brDgInfoVO.getLabelCd()).append("\n");
							flatFile.append("LABEL_DESC:").append(brDgInfoVO.getLabelDesc()).append("\n");
							flatFile.append("D_PKG:").append(brDgInfoVO.getDPkg()).append("\n");
							flatFile.append("D_PKGUNIT:").append(brDgInfoVO.getDPkgunit()).append("\n");
							flatFile.append("NWGT:").append(brDgInfoVO.getNwgt()).append("\n");
							flatFile.append("NWGT_UNIT:").append(brDgInfoVO.getNwgtUnit()).append("\n");
							flatFile.append("GWGT:").append(brDgInfoVO.getGwgt()).append("\n");
							flatFile.append("GWGT_UNIT:").append(brDgInfoVO.getGwgtUnit()).append("\n");
							flatFile.append("MEA:").append(brDgInfoVO.getMea()).append("\n");
							flatFile.append("MEA_UNIT:").append(brDgInfoVO.getMeaUnit()).append("\n");
							flatFile.append("HAZ_CONT:").append(brDgInfoVO.getHazCont()).append("\n");
							flatFile.append("STWG:").append(brDgInfoVO.getStwg()).append("\n");
							flatFile.append("LABEL:").append(brDgInfoVO.getLabel()).append("\n");
							flatFile.append("}CNTR_DANGER").append("\n");
						}

						// 11. CNTR Desc 정보를 조회한다.
						List<BrCmVO> brCmVOList = dbDao.searchCM(brVslCondVO);

						for (int cmIdx = 0; cmIdx < brCmVOList.size(); cmIdx++) {
							BrCmVO brCmVO = brCmVOList.get(cmIdx);

							flatFile.append("{CNTR_DESC").append("\n");
							flatFile.append("D_CMDT:").append(brCmVO.getDCmdt()).append("\n");
							flatFile.append("D_PUNIT:").append(brCmVO.getDPunit()).append("\n");
							flatFile.append("D_PKG:").append(brCmVO.getDPkg()).append("\n");
							flatFile.append("D_WGT:").append(brCmVO.getDWgt()).append("\n");
							flatFile.append("D_MEAS:").append(brCmVO.getDMeas()).append("\n");
							flatFile.append("D_HS_CD:").append(brCmVO.getHamoTrfCd()).append("\n");
							flatFile.append("D_DESC:").append(brCmVO.getDDesc()).append("\n");

							brVslCondVO.setCntrMfSeq(brCmVOList.get(cmIdx).getCntrMfSeq());
							List<BrCmVO> brCmDtlVOList = dbDao.searchCMdtl(brVslCondVO);

							for (int idx = 0; idx < brCmDtlVOList.size(); idx++) {
								flatFile.append("{NCM_CD").append("\n");
								flatFile.append("D_NCM_CD:").append(brCmDtlVOList.get(idx).getDNcmCd()).append("\n");
								flatFile.append("}NCM_CD").append("\n");
							}

							String dMark = brCmVO.getDMark();
							if (!"".equalsIgnoreCase(dMark)) {
								flatFile.append("{CUS_MARK").append("\n");
								flatFile.append(brCmVO.getDMark()).append("\n");
								flatFile.append("}CUS_MARK").append("\n");
							}
							flatFile.append("}CNTR_DESC").append("\n");
						}
						flatFile.append("}CNTR_INFO").append("\n");

					} // end for(cntrIdx)

					// 12. BKG Qty를 조회한다.
					List<BkgQtyVO> bkgQtyVOList = dbDao.searchBkgQty(brVslCondVO);

					for (int idx = 0; idx < bkgQtyVOList.size(); idx++) {

						BkgQtyVO bkgQtyVO = bkgQtyVOList.get(idx);

						flatFile.append("{QTY").append("\n");
						flatFile.append("HANTYPE:").append(bkgQtyVO.getHantype()).append("\n");
						flatFile.append("COUNT:").append(bkgQtyVO.getCount()).append("\n");
						flatFile.append("}QTY").append("\n");
					}

					// 13. Vessel 정보, Vessel ETA 정보를 조회한다.
					List<BrEtaInfoVO> brEtaInfoVOList = dbDao.searchVslInfoVsl(brVslCondVO);
					for (int idx = 0; idx < brEtaInfoVOList.size(); idx++) {
						BrEtaInfoVO brEtaInfoVO = brEtaInfoVOList.get(idx);

						flatFile.append("{BKGVVD").append("\n");
						flatFile.append("BVVD1:").append(brEtaInfoVO.getBvvd1()).append("\n");
						flatFile.append("BVVD_LANE:").append(brEtaInfoVO.getBvvdLane()).append("\n");
						flatFile.append("VSL_CALLSIGN1:").append(brEtaInfoVO.getVslCallsign1()).append("\n");
						flatFile.append("VSL_LLOYDCODE1:").append(brEtaInfoVO.getVslLloydcode1()).append("\n");
						flatFile.append("VSL_FULLNAME1:").append(brEtaInfoVO.getVslFullname1()).append("\n");
						flatFile.append("VVD_REF_NO1: ").append(brEtaInfoVO.getVvdRefNo1()).append("\n");
						flatFile.append("BLPOL1:").append(brEtaInfoVO.getBlpol1()).append("\n");
						flatFile.append("POL_FULLNAME1:").append(brEtaInfoVO.getPolFullname1()).append("\n");
						flatFile.append("BLPOD1:").append(brEtaInfoVO.getBlpod1()).append("\n");
						flatFile.append("POD_FULLNAME1:").append(brEtaInfoVO.getPodFullname1()).append("\n");
						flatFile.append("POLETA1:").append(brEtaInfoVO.getPoleta1()).append("\n");
						flatFile.append("POLETD1:").append(brEtaInfoVO.getPoletd1()).append("\n");
						flatFile.append("PODETA1:").append(brEtaInfoVO.getPodeta1()).append("\n");
						flatFile.append("PODETD1:").append(brEtaInfoVO.getPodetd1()).append("\n");
						flatFile.append("OP_CODE:").append(brEtaInfoVO.getOpCode()).append("\n");
						flatFile.append("}BKGVVD").append("\n");
					}

					flatFile.append("}BL_INFO").append("\n");

					// 전송로그 데이타 만들기
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(brVslCondVO.getBkgNo());
					bkgNtcHisVO.setNtcViaCd("");
					bkgNtcHisVO.setNtcKndCd("IM");
					bkgNtcHisVO.setEdiId("BRSAO");
					bkgNtcHisVO.setBkgNtcSndRsltCd("A");
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndDt(localSendTime);
					bkgNtcHisVO.setSndGdt(localSendTime);
					bkgNtcHisVO.setSndRqstDt(localSendTime);
					bkgNtcHisVO.setSndRqstGdt(localSendTime);
					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
					bkgNtcHisVOs.add(bkgNtcHisVO);
				}

				// 동일한 BL 에 Container 여러개 이므로
				preBlNo = brManifestTransmitVO.getBlNo();

			} // end for(i)

			/* 전송로그를 저장한다. */
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());

			/* Queue 전송 */
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_BRZ.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

			if (flatFileAckVO.getAckStsCd().equals("E") ) {
				throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage());
			}
			
			return flatFile.toString();
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}	

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVOs, String pgmNo) throws EventException {

		BrcsCustomsTransmissionBackEndJob backEndJob = new BrcsCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";

		if (pgmNo.equals("ESM_BKG_0127")) {
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob, account.getUpd_usr_id(), "Brazil EDI Transmit");
		}
		return resultStr;
	}
}
