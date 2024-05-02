/*=========================================================
*Copyright(c) CyberLogitec
*@FileName : AustraliaCustomsTransmissionBackEndJobSeacrTransmit
*@FileTitle : AustraliaCustomsTransmissionBackEndJobSeacrTransmit
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration.AusCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarBkgBookingDocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarCstmsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarDgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchVslPortSkdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgCstmsAusSndLogVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;


/**
 * @author KIM Sang-Soo
 * @see ESM_BKG_1501 EventResponse, AustraliaCustomsTransmissionBackEndJobSeacrTransmit 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AustraliaCustomsTransmissionBackEndJobSeacrTransmit extends BackEndCommandSupport {
	private AusSearchCuscarVO inputSearchCuscarVO;
	private AusResultCuscarVO[] inputResultCuscarVOs;
	private SignOnUserAccount account;
	// Database Access Object
	private AusCustomsTransmissionDBDAO dbDao = new AusCustomsTransmissionDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param AusSearchCuscarVO ausSearchCuscarVO
	 */
	public void setAusSearchCuscarVO(AusSearchCuscarVO ausSearchCuscarVO) {
		this.inputSearchCuscarVO = ausSearchCuscarVO;
	}

	/**
	 * 데이터 세팅
	 *
	 * @param AusResultCuscarVO[] ausResultCuscarVOs
	 */
	public void setAusResultCuscarVOs(AusResultCuscarVO[] ausResultCuscarVOs) {
		if (ausResultCuscarVOs != null) {
			AusResultCuscarVO[] tmpVOs = Arrays.copyOf(ausResultCuscarVOs, ausResultCuscarVOs.length);
			this.inputResultCuscarVOs = tmpVOs;
		}
	}

	/**
	 * 데이터 세팅
	 *
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setAccount(SignOnUserAccount signOnUserAccount) {
		this.account = signOnUserAccount;
	}

	/**
	 * Back End Job Result
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		BookingUtil bookingUtil = new BookingUtil();

		// FLATFILE
		String flatFileHeader = "";
		String flatFileRefNo = "";
		StringBuilder flatFile = new StringBuilder();

		// -- Input 정보 -- //////////////////////////////////////////////
		AusSearchCuscarVO ausSearchCuscarVO = this.inputSearchCuscarVO;    // 조회조건
		AusResultCuscarVO[] ausResultCuscarVOs = this.inputResultCuscarVOs;    // Sheet내용
		SignOnUserAccount signOnUserAccount = this.account;
		String ediInd = ausSearchCuscarVO.getEdiInd();    // Function Type

		// -- Output 정보 -- //////////////////////////////////////////////
		String srnNo = "";
		String srnVer = "";
		String vvd = ausSearchCuscarVO.getVvd();
		String blNo = "";
		String bkgNo = "";
		String vvdPodCd = "";
		String cntrNo = "";
		List<AusSearchVslPortSkdVO> ausSearchVslPortSkdVOList = new ArrayList<AusSearchVslPortSkdVO>();
		String cssmVoyNo = "";
		String vpsEtaDt = "";
		String vpsEtdDt = "";
		String fPort= "";
		String fPortNm= "";
		List<MdmVslCntrVO> mdmVslCntrVOList = new ArrayList<MdmVslCntrVO>();
		String vslNm = "";
		String lloydNo = "";
		String callSgnNo = "";
		String vslRgstCntCd = "";
		List<MdmLocationVO> mdmLocationVOList = new ArrayList<MdmLocationVO>();
		String locNm = "";
		List<AusCuscarBkgBookingDocVO> ausCuscarBkgBookingDocVOList = new ArrayList<AusCuscarBkgBookingDocVO>();
		String fpInd = "";
		String totCntr = "";
		String pckQty = "";
		String preFlg = "";
		// Location 정보
		List<AusCuscarLocInfoVO> ausCuscarLocInfoVOList = new ArrayList<AusCuscarLocInfoVO>();
		String bkgPorCd = "";
		// Customer 정보
		List<AusCuscarCstmsInfoVO> ausCuscarCstmsInfoVOList = new ArrayList<AusCuscarCstmsInfoVO>();
		//Container 정보
		List<AusCuscarCntrInfoVO> ausCuscarCntrInfoVOList = new ArrayList<AusCuscarCntrInfoVO>();
		// Container Seal 정보
		List<BkgCntrSealNoVO> bkgCntrSealNoVOList = new ArrayList<BkgCntrSealNoVO>();
		// Goods 정보
		List<BkgCntrMfDescVO> BkgCntrMfDescVOList = new ArrayList<BkgCntrMfDescVO>();
		// Description / Mark 정보
		List<AusCuscarMarkDescVO> ausCuscarMarkDescVOList = new ArrayList<AusCuscarMarkDescVO>();
		// Danger Goods 정보
		List<AusCuscarDgInfoVO> ausCuscarDgInfoVOList = new ArrayList<AusCuscarDgInfoVO>();


		try {
			// Body 생성
			for (AusResultCuscarVO ausResultCuscarVO : ausResultCuscarVOs) {

				blNo = ausResultCuscarVO.getBlNo();
				bkgNo = ausResultCuscarVO.getBkgNo();
				vvdPodCd = ausSearchCuscarVO.getPodCd();


				flatFile = new StringBuilder();


				// Header 생성
				flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("AU_SEACR");
				flatFile.append(flatFileHeader).append("\n");
				flatFileRefNo = flatFileHeader.substring(62).trim();


				flatFile.append("MSG_TYPE:").append("933").append("\n");


				srnNo = "";
				srnVer = "";
				if ("9".equals(ediInd)) {    // Function Type - Orginal
					srnNo = flatFileRefNo;
					srnVer = "1";
				} else {    // Function Type - ETC
					String[] srnInfo = dbDao.searchSrnInfo(blNo);
					if (!"".equals(srnInfo[0])) {
						srnNo = srnInfo[0];
						srnVer = srnInfo[1];
					} else {    // 조회된 SRN No.가 없으면 Orginal의 경우와 같이 flatFileRefNo를 저장
						srnNo = flatFileRefNo;
						srnVer = "1";
					}
				}
				flatFile.append("SRN:").append(srnNo).append("\n");
				flatFile.append("SRN_VER:").append(srnVer).append("\n");


				flatFile.append("STATUS:").append(ediInd).append("\n");
				flatFile.append("VSL_CODE:").append(vvd.substring(0, 4)).append("\n");
				flatFile.append("VOYAGE:").append(vvd.substring(4)).append("\n");


				ausSearchVslPortSkdVOList = dbDao.searchVskVslPortSkd(vvd, vvdPodCd);
				cssmVoyNo = "";
				vpsEtaDt = "";
				vpsEtdDt = "";
				fPort= "";
				fPortNm= "";
				if (ausSearchVslPortSkdVOList.size() > 0) {
					cssmVoyNo = ausSearchVslPortSkdVOList.get(0).getIbCssmVoyNo();
					vpsEtaDt = ausSearchVslPortSkdVOList.get(0).getVpsEtaDt();
					vpsEtdDt = ausSearchVslPortSkdVOList.get(0).getVpsEtdDt();
					fPort= ausSearchVslPortSkdVOList.get(0).getFPort();
					fPortNm= ausSearchVslPortSkdVOList.get(0).getFPortNm();
				}
				flatFile.append("CON_VOYAGE:").append(cssmVoyNo).append("\n");


				mdmVslCntrVOList = dbDao.searchMdmVslCntrByVslCd(vvd.substring(0, 4));
				vslNm = "";
				lloydNo = "";
				callSgnNo = "";
				vslRgstCntCd = "";
				if (mdmVslCntrVOList.size() > 0) {
					vslNm = mdmVslCntrVOList.get(0).getVslEngNm();
					lloydNo = mdmVslCntrVOList.get(0).getLloydNo();
					callSgnNo = mdmVslCntrVOList.get(0).getCallSgnNo();
					vslRgstCntCd = mdmVslCntrVOList.get(0).getVslRgstCntCd();
				}
				flatFile.append("VSL_NAME:").append(vslNm).append("\n");
				flatFile.append("VSL_LLOYD_NO:").append(lloydNo).append("\n");
				flatFile.append("VSL_CALLSIGN:").append(callSgnNo).append("\n");
				flatFile.append("VSL_NATION_CD:").append(vslRgstCntCd).append("\n");


				flatFile.append("PORT:").append(vvdPodCd).append("\n");


				mdmLocationVOList = dbDao.searchMdmLocationByPortCd(vvdPodCd);
				locNm = "";
				if (mdmLocationVOList.size() > 0) locNm = mdmLocationVOList.get(0).getLocNm();
				flatFile.append("PORT_NM:").append(locNm).append("\n");


				flatFile.append("FPORT:").append(fPort).append("\n");
				flatFile.append("FPORT_NM:").append(fPortNm).append("\n");
				flatFile.append("EX_IND:").append("I").append("\n");


				ausCuscarBkgBookingDocVOList = dbDao.searchBkgBookingDocByBkgNo(bkgNo);
				fpInd = "";
				totCntr = "";
				pckQty = "";
				preFlg = "";
				if (ausCuscarBkgBookingDocVOList.size() > 0) {
					fpInd = ausCuscarBkgBookingDocVOList.get(0).getFpInd();
					totCntr = ausCuscarBkgBookingDocVOList.get(0).getTotCntr();
					pckQty = ausCuscarBkgBookingDocVOList.get(0).getPckQty();
					preFlg = ausCuscarBkgBookingDocVOList.get(0).getPreFlg();
				}
				flatFile.append("FP_IND:").append(fpInd).append("\n");


				flatFile.append("ETA:").append(vpsEtaDt).append("\n");
				flatFile.append("ETD:").append(vpsEtdDt).append("\n");
				flatFile.append("REMARKS:").append("\n");


				flatFile.append("TOT_CNTR:").append(totCntr).append("\n");
				flatFile.append("TOT_PKG:").append(pckQty).append("\n");


				// {BL_INFO (S)
				flatFile.append("{BL_INFO").append("\n");
				flatFile.append("LOOP_IND:").append("1").append("\n");
				flatFile.append("BLNBR:").append(blNo).append("\n");
				flatFile.append("BKGNBR:").append(bkgNo).append("\n");
				flatFile.append("TR_IND:").append(ausSearchCuscarVO.getInTransit()).append("\n");
				flatFile.append("PRFLAG:").append(preFlg).append("\n");


					// {LOC_INFO (S)
					ausCuscarLocInfoVOList = dbDao.searchLocInfo(vvd, bkgNo, vvdPodCd);
					for (AusCuscarLocInfoVO ausCuscarLocInfoVO : ausCuscarLocInfoVOList) {
						if ("BKGPOR".equals(ausCuscarLocInfoVO.getLocTp())) bkgPorCd = ausCuscarLocInfoVO.getUnLocCd();
						flatFile.append("{LOC_INFO").append("\n");
						flatFile.append("LOC_TYPE:").append(ausCuscarLocInfoVO.getLocTp()).append("\n");
						flatFile.append("LOC_CD:").append(ausCuscarLocInfoVO.getUnLocCd()).append("\n");
						flatFile.append("LOC_NM:").append(ausCuscarLocInfoVO.getLocNm()).append("\n");
						flatFile.append("}LOC_INFO").append("\n");
					}
					// }LOC_INFO (E)


					// {CUSTOMER_INFO (S)
					ausCuscarCstmsInfoVOList = dbDao.searchCstmsInfo(bkgNo, signOnUserAccount.getUsr_id());
					for (AusCuscarCstmsInfoVO ausCuscarCstmsInfoVO : ausCuscarCstmsInfoVOList) {
						flatFile.append("{CUSTOMER_INFO").append("\n");
						flatFile.append("CUSTOMER_TYPE:").append(ausCuscarCstmsInfoVO.getCustomerType()).append("\n");
						flatFile.append("CUSTOMER_CD:").append(ausCuscarCstmsInfoVO.getCustomerCd()).append("\n");
						flatFile.append("CUSTOMER_NM1:").append(ausCuscarCstmsInfoVO.getCustomerNm1()).append("\n");
						flatFile.append("CUSTOMER_NM2:").append(ausCuscarCstmsInfoVO.getCustomerNm2()).append("\n");
						flatFile.append("CUSTOMER_ADDR1:").append(ausCuscarCstmsInfoVO.getCustomerAddr1()).append("\n");
						flatFile.append("CUSTOMER_ADDR2:").append(ausCuscarCstmsInfoVO.getCustomerAddr2()).append("\n");
						flatFile.append("CUSTOMER_ADDR3:").append(ausCuscarCstmsInfoVO.getCustomerAddr3()).append("\n");
						flatFile.append("}CUSTOMER_INFO").append("\n");
					}
					// }CUSTOMER_INFO (E)


					// {CNTR_INFO (S)
					ausCuscarCntrInfoVOList = dbDao.searchCntrInfo(bkgNo, "");
					for (AusCuscarCntrInfoVO ausCuscarCntrInfoVO : ausCuscarCntrInfoVOList) {
						cntrNo = ausCuscarCntrInfoVO.getCntrNo();
						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTRNBR:").append(cntrNo).append("\n");
						flatFile.append("CNTRSIZE:").append(ausCuscarCntrInfoVO.getCntrSz()).append("\n");
						flatFile.append("CNTRTYPE:").append(ausCuscarCntrInfoVO.getCntrTp()).append("\n");
						flatFile.append("CNTR_SUPL_CD:").append(ausCuscarCntrInfoVO.getCntrSuplCd()).append("\n");
						flatFile.append("CNTR_FM_IND:").append(ausCuscarCntrInfoVO.getCntrFmInd()).append("\n");
						flatFile.append("CNTR_G_WGT:").append(ausCuscarCntrInfoVO.getCntrGWgt()).append("\n");
						flatFile.append("CNTR_G_WGT_UNIT:").append(ausCuscarCntrInfoVO.getCntrGWgtUnit()).append("\n");
						flatFile.append("CNTR_T_WGT:").append(ausCuscarCntrInfoVO.getCntrTWgt()).append("\n");
						flatFile.append("CNTR_T_WGT_UNIT:").append(ausCuscarCntrInfoVO.getCntrTWgtUnit()).append("\n");
						flatFile.append("CNTR_TMP:").append(ausCuscarCntrInfoVO.getCntrTmp()).append("\n");
						flatFile.append("CNTR_TMP_UNIT:").append(ausCuscarCntrInfoVO.getCntrTmpUnit()).append("\n");


						// {CNTR_SEAL_NO (S)
						bkgCntrSealNoVOList = dbDao.searchCntrSealNo(bkgNo, cntrNo);
						for (BkgCntrSealNoVO bkgCntrSealNoVO : bkgCntrSealNoVOList) {
							flatFile.append("{CNTR_SEAL_NO").append("\n");
							flatFile.append("SEALNBR:").append(bkgCntrSealNoVO.getCntrSealNo()).append("\n");
							flatFile.append("}CNTR_SEAL_NO").append("\n");
						}
						// }CNTR_SEAL_NO (E)


						// {GOODS_INFO (S)
						BkgCntrMfDescVOList = dbDao.searchGoodsInfo(bkgNo, cntrNo);
						for (BkgCntrMfDescVO bkgCntrMfDescVO : BkgCntrMfDescVOList) {
							flatFile.append("{GOODS_INFO").append("\n");
							flatFile.append("CMPKG:").append(bkgCntrMfDescVO.getPckQty()).append("\n");
							flatFile.append("CMPKGU:").append(bkgCntrMfDescVO.getPckTpCd()).append("\n");
							flatFile.append("CMWGT:").append(bkgCntrMfDescVO.getCntrMfWgt()).append("\n");
							flatFile.append("CMWGT_UNIT:").append(bkgCntrMfDescVO.getWgtUtCd()).append("\n");
							flatFile.append("CMNET_WGT:").append(bkgCntrMfDescVO.getCntrMfWgt()).append("\n");
							flatFile.append("CMNET_WGT_UNIT:").append(bkgCntrMfDescVO.getWgtUtCd()).append("\n");
							flatFile.append("CMMEA:").append(bkgCntrMfDescVO.getMeasQty()).append("\n");
							flatFile.append("CMMEA_UNIT:").append(bkgCntrMfDescVO.getMeasUtCd()).append("\n");
							flatFile.append("COMMODITY_CD:").append(bkgCntrMfDescVO.getCmdtHsCd()).append("\n");
							flatFile.append("ORG_CNT_CD:").append((bkgPorCd + "  ").substring(0,  2)).append("\n");
							flatFile.append("ORG_LOC_CD:").append(bkgPorCd).append("\n");

/*
							// {DESC (S)
							ausCuscarMarkDescVOList = dbDao.searchCuscarDesc(bkgNo);
							StringBuilder tempDesc = new StringBuilder();
							for (AusCuscarMarkDescVO ausCuscarMarkDescVO : ausCuscarMarkDescVOList) {
								tempDesc.append(ausCuscarMarkDescVO.getDescription()).append(" ");
							}
							String description = tempDesc.toString().trim();
*/
							String description = bkgCntrMfDescVO.getCntrMfGdsDesc().trim();
							int descRowKnt = (int)Math.ceil((float)description.length() / 70);
							for (int k=0; k<descRowKnt; k++) {
								flatFile.append("{DESC").append("\n");
								if (k < descRowKnt-1) {
									flatFile.append("DESC:").append(description.substring(k*70, (k+1)*70)).append("\n");
								} else {
									flatFile.append("DESC:").append(description.substring(k*70)).append("\n");
								}
								flatFile.append("}DESC").append("\n");
							}
							// {DESC (E)


							// {MARK (S)
							ausCuscarMarkDescVOList = dbDao.searchCuscarMark(bkgNo);
							for (AusCuscarMarkDescVO ausCuscarMarkDescVO : ausCuscarMarkDescVOList) {
								flatFile.append("{MARK").append("\n");
								flatFile.append("MARKNO1:").append(ausCuscarMarkDescVO.getMark01()).append("\n");
								flatFile.append("MARKNO2:").append(ausCuscarMarkDescVO.getMark02()).append("\n");
								flatFile.append("MARKNO3:").append(ausCuscarMarkDescVO.getMark03()).append("\n");
								flatFile.append("MARKNO4:").append(ausCuscarMarkDescVO.getMark04()).append("\n");
								flatFile.append("MARKNO5:").append(ausCuscarMarkDescVO.getMark05()).append("\n");
								flatFile.append("MARKNO6:").append(ausCuscarMarkDescVO.getMark06()).append("\n");
								flatFile.append("MARKNO7:").append(ausCuscarMarkDescVO.getMark07()).append("\n");
								flatFile.append("MARKNO8:").append(ausCuscarMarkDescVO.getMark08()).append("\n");
								flatFile.append("MARKNO9:").append(ausCuscarMarkDescVO.getMark09()).append("\n");
								flatFile.append("MARKNO10:").append(ausCuscarMarkDescVO.getMark10()).append("\n");
								flatFile.append("}MARK").append("\n");
							}
							// {MARK (E)


							flatFile.append("}GOODS_INFO").append("\n");
						}
						// }GOODS_INFO (E)


						// {DANGER_GOODS (S)
						ausCuscarDgInfoVOList = dbDao.searchDgInfo(bkgNo);
//						for (AusCuscarDgInfoVO ausCuscarDgInfoVO : ausCuscarDgInfoVOList) {
//							flatFile.append("{DANGER_GOODS").append("\n");
//							flatFile.append("IMO_CLASS_NO:").append(ausCuscarDgInfoVO.getImdgClssCd()).append("\n");
//							flatFile.append("IMO_PAGE_NO:").append(ausCuscarDgInfoVO.getImoPageNo()).append("\n");
//							flatFile.append("HAZARD_CD:").append(ausCuscarDgInfoVO.getHazardCd()).append("\n");
//							flatFile.append("UNDG_NO:").append(ausCuscarDgInfoVO.getImdgUnNo()).append("\n");
//							flatFile.append("FLASH_POINT:").append(ausCuscarDgInfoVO.getFlashPoint()).append("\n");
//							flatFile.append("FLASH_POINT_UNIT:").append(ausCuscarDgInfoVO.getFlashPointUnit()).append("\n");
//							flatFile.append("PACKING_GROUP:").append(ausCuscarDgInfoVO.getImdgPckGrpCd()).append("\n");
//							flatFile.append("}DANGER_GOODS").append("\n");
//						}
						// {DANGER_GOODS (E)


						flatFile.append("}CNTR_INFO").append("\n");
					}
					// }CNTR_INFO (E)


				flatFile.append("}BL_INFO").append("\n");
				// }BL_INFO (E)


				// 전송결과 저장
				BkgCstmsAusSndLogVO bkgCstmsAusSndLogVO = new BkgCstmsAusSndLogVO();
				bkgCstmsAusSndLogVO.setAusSndLogId("SEACR");
				bkgCstmsAusSndLogVO.setSndDt(bookingUtil.searchLocalTime(signOnUserAccount.getCnt_cd() + signOnUserAccount.getOfc_cd().substring(0, 3)));
				bkgCstmsAusSndLogVO.setLogSeq(ediInd);
				bkgCstmsAusSndLogVO.setOfcCd(signOnUserAccount.getOfc_cd());
				bkgCstmsAusSndLogVO.setVslCd(vvd.substring(0, 4));
				bkgCstmsAusSndLogVO.setSkdVoyNo(vvd.substring(4, 8));
				bkgCstmsAusSndLogVO.setSkdDirCd(vvd.substring(8, 9));
				bkgCstmsAusSndLogVO.setPodCd(vvdPodCd);
				bkgCstmsAusSndLogVO.setBlNo(blNo);
				bkgCstmsAusSndLogVO.setEdiRefId(flatFileRefNo);
				bkgCstmsAusSndLogVO.setMrnNo(srnNo);
				bkgCstmsAusSndLogVO.setMrnChkNo(srnVer);
				bkgCstmsAusSndLogVO.setEdiSndMsgCtnt(flatFile.toString());
				bkgCstmsAusSndLogVO.setCreUsrId(signOnUserAccount.getUsr_id());
				bkgCstmsAusSndLogVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				dbDao.addCstmsAusSndLog(bkgCstmsAusSndLogVO);


				// FlatFile 전송
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_AUSMF.IBMMQ.QUEUE"));
				FlatFileAckVO flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
				if ("E".equals(flatFileAckVO.getAckStsCd())) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {} ).getMessage(), ex);
		}
		return flatFile.toString();
	}

}
