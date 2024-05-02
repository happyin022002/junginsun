/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : HongKongCustomsTransmissionBCImpl.java
 *@FileTitle : HongKongCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.04.21 임재택
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration.HongKongCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchBkgVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchBlGeneralVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchCntrDangerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchCntrDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchCntrDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchMarksDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchMsgHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchSentBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchSentVslVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchVslGeneralVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lim Jae Taek
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class HongKongCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient HongKongCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public HongKongCustomsTransmissionBCImpl() {
		dbDao = new HongKongCustomsTransmissionDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsTransmission화면에 대한 조회 이벤트 처리<br>
	 * FlatFile 생성작업
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */

	@SuppressWarnings( { "unchecked" })
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException {
		StringBuffer flatFile = new StringBuffer();
		HongKongManifestTransmitVO hongkongManifestTransmitVO = new HongKongManifestTransmitVO();

		List<HongKongSearchMsgHeaderVO> hongKongSearchMsgHeaderVOs = null;
		List<HongKongSearchSentVslVO> hongKongSearchSentVslVOs = null;
		List<HongKongSearchVslGeneralVO> hongKongSearchVslGeneralVOs = null;
		List<HongKongSearchCntrListVO> hongKongSearchCntrListVOs = null;
		List<HongKongSearchBkgQtyVO> hongKongSearchBkgQtyVOs = null;
		List<HongKongSearchSentBlVO> hongKongSearchSentBlVOs = null;
		List<HongKongSearchBlGeneralVO> hongKongSearchBlGeneralVOs = null;
		List<HongKongSearchMarksDescVO> hongKongSearchMarksDescVOs = null;
		List<HongKongSearchCntrDetailVO> hongKongSearchCntrDetailVOs = null;
		List<HongKongSearchCntrDangerVO> hongKongSearchCntrDangerVOs = null;
		List<HongKongSearchCntrDescVO> hongKongSearchCntrDescVOs = null;
		List<HongKongSearchQtyVO> hongKongSearchQtyVOs = null;
		List<HongKongSearchBkgVvdVO> hongKongSearchBkgVvdVOs = null;
		String amendVvd = "";
		String amendBl = "";
		String bkgQty = "";
		BookingUtil command = new BookingUtil();

		try {

			hongKongSearchMsgHeaderVOs = dbDao.searchMsgHeader();
			if (hongKongSearchMsgHeaderVOs != null) {
				HongKongSearchMsgHeaderVO hongKongSearchMsgHeaderVO;
				for (int i = 0; i < hongKongSearchMsgHeaderVOs.size(); i++) {
					hongKongSearchMsgHeaderVO = hongKongSearchMsgHeaderVOs.get(i);
					flatFile.append(hongKongSearchMsgHeaderVO.getMsgHeader()).append("\n");
				}
			}
			if (manifestTransmitVOs != null) {
				// 체크한 전체 BKG_NO
				StringBuffer sbBkgNo = new StringBuffer();
				for (int i = 0; i < manifestTransmitVOs.length; i++) {
					hongkongManifestTransmitVO = (HongKongManifestTransmitVO) manifestTransmitVOs[i];
					sbBkgNo.append("'");
					sbBkgNo.append(hongkongManifestTransmitVO.getBkgNo());
					sbBkgNo.append("'");
					if (i < manifestTransmitVOs.length - 1) {
						sbBkgNo.append(",");
					}
				}
				for (int i = 0; i < manifestTransmitVOs.length; i++) {
					hongkongManifestTransmitVO = (HongKongManifestTransmitVO) manifestTransmitVOs[i];
					hongKongSearchSentVslVOs = dbDao.searchSentVsl(hongkongManifestTransmitVO);
					if (hongKongSearchSentVslVOs != null && hongKongSearchSentVslVOs.size() > 0)
						amendVvd = "Y";
					else
						amendVvd = "N";
					hongkongManifestTransmitVO.setAmendVvd(amendVvd);
					hongkongManifestTransmitVO.setUserId(account.getUsr_id());
					hongkongManifestTransmitVO.setOfcCd(account.getOfc_cd());
					String bl_no = hongkongManifestTransmitVO.getBlNo();
					if (bl_no.length() > 11)
						hongkongManifestTransmitVO.setBlNo(bl_no.substring(0, 12));
					if (i == 0) {
						// 홍콩세관 신고용 Manifest Vessel General 정보를 조회한다.
						hongKongSearchVslGeneralVOs = dbDao.searchVslGeneral(hongkongManifestTransmitVO);
						if (hongKongSearchVslGeneralVOs != null) {
							HongKongSearchVslGeneralVO hongKongSearchVslGeneralVO;
							for (int j = 0; j < hongKongSearchVslGeneralVOs.size(); j++) {
								hongKongSearchVslGeneralVO = hongKongSearchVslGeneralVOs.get(j);
								flatFile.append("VVD:").append(hongKongSearchVslGeneralVO.getVvdNumber()).append("\n");
								flatFile.append("POL:").append(hongKongSearchVslGeneralVO.getPolCd()).append("\n");
								flatFile.append("POD:").append(hongKongSearchVslGeneralVO.getPodCd()).append("\n");
								flatFile.append("VSL_CALLSIGN:").append(hongKongSearchVslGeneralVO.getVslCallsign()).append("\n");
								flatFile.append("VSL_LLOYDCODE:").append(hongKongSearchVslGeneralVO.getVslLloydcode()).append("\n");
								flatFile.append("VSL_FULLNAME:").append(hongKongSearchVslGeneralVO.getVslFullname()).append("\n");
								flatFile.append("ETA:").append(hongKongSearchVslGeneralVO.getEtaDt()).append("\n");
								flatFile.append("ETD:").append(hongKongSearchVslGeneralVO.getEtdDt()).append("\n");
								flatFile.append("ATA:").append(hongKongSearchVslGeneralVO.getAtaDt()).append("\n");
								flatFile.append("DECLARATION:").append(hongKongSearchVslGeneralVO.getDeclaration()).append("\n");
								flatFile.append("AMEND_VVD:").append(hongKongSearchVslGeneralVO.getAmendVvd()).append("\n");
								flatFile.append("NEXTPORT:").append(hongKongSearchVslGeneralVO.getNextport()).append("\n");
								flatFile.append("NEXTPORT_ETA:").append(hongKongSearchVslGeneralVO.getNextportEta()).append("\n");
								flatFile.append("PREVPORT:").append(hongKongSearchVslGeneralVO.getPrevport()).append("\n");
								flatFile.append("PREVPORT_ETD:").append(hongKongSearchVslGeneralVO.getPrevportEtd()).append("\n");
							}
						}
						// 홍콩세관 신고용 Manifest Container List 를 조회한다.
						hongkongManifestTransmitVO.setIbflag(sbBkgNo.toString());
						hongKongSearchCntrListVOs = dbDao.searchCntrList(hongkongManifestTransmitVO);
						if (hongKongSearchCntrListVOs != null) {
							HongKongSearchCntrListVO hongKongSearchCntrListVO;
							for (int j = 0; j < hongKongSearchCntrListVOs.size(); j++) {
								flatFile.append("{CNTR_LIST").append("\n");
								hongKongSearchCntrListVO = hongKongSearchCntrListVOs.get(j);
								flatFile.append("CNTR_NO:").append(hongKongSearchCntrListVO.getCntrNo()).append("\n");
								flatFile.append("SEALNO:").append(hongKongSearchCntrListVO.getCntrSealNo()).append("\n");
								flatFile.append("CNTR_TYPE:").append(hongKongSearchCntrListVO.getCntrTpszCd()).append("\n");
								flatFile.append("BKG_CGO_TP:").append(hongKongSearchCntrListVO.getBkgCgoTpCd()).append("\n");
								flatFile.append("BCNTR_SPE_RF:").append(hongKongSearchCntrListVO.getRcFlg()).append("\n");
								flatFile.append("}CNTR_LIST").append("\n");
							}
						}
					}
					// 홍콩세관 신고용 Manifest Booking Qty 정보를 조회한다.
					hongKongSearchBkgQtyVOs = dbDao.searchBkgQty(hongkongManifestTransmitVO);
					if (hongKongSearchBkgQtyVOs == null)
						bkgQty = "";
					else {
						for (int j = 0; j < hongKongSearchBkgQtyVOs.size(); j++) {
							HongKongSearchBkgQtyVO hongKongSearchBkgQtyVO = hongKongSearchBkgQtyVOs.get(j);
							bkgQty = hongKongSearchBkgQtyVO.getBkgQty();
						}
					}
					// 홍콩세관에 전송한 B/L 정보를 조회한다.
					hongKongSearchSentBlVOs = dbDao.searchSentBl(hongkongManifestTransmitVO);
					if (hongKongSearchSentBlVOs != null && hongKongSearchSentBlVOs.size() > 0)
						amendBl = "Y";
					else
						amendBl = "N";

					hongkongManifestTransmitVO.setAmendBl(amendBl);
					hongkongManifestTransmitVO.setBkgQty(bkgQty);
					// 홍콩세관 신고용 Manifest B/L General 정보를 조회한다.
					hongKongSearchBlGeneralVOs = dbDao.searchBlGeneral(hongkongManifestTransmitVO);
					if (hongKongSearchBlGeneralVOs != null) {
						HongKongSearchBlGeneralVO hongKongSearchBlGeneralVO;
						for (int j = 0; j < hongKongSearchBlGeneralVOs.size(); j++) {
							hongKongSearchBlGeneralVO = hongKongSearchBlGeneralVOs.get(j);
							hongkongManifestTransmitVO.setMfSndDt(command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
							dbDao.addBlSendLog(hongkongManifestTransmitVO);
							flatFile.append("{BL_INFO").append("\n");
							
							flatFile.append("BLNBR:").append(hongKongSearchBlGeneralVO.getBlNo()).append("\n");
							flatFile.append("BLPOL:").append(hongKongSearchBlGeneralVO.getPolCd()).append("\n");
							flatFile.append("BLPOD:").append(hongKongSearchBlGeneralVO.getPodCd()).append("\n");
							flatFile.append("BLPOR:").append(hongKongSearchBlGeneralVO.getPorCd()).append("\n");
							flatFile.append("BLDEL:").append(hongKongSearchBlGeneralVO.getDelCd()).append("\n");
							flatFile.append("BLRLY:").append(hongKongSearchBlGeneralVO.getBlrly()).append("\n");
							flatFile.append("BLPLACE:").append(hongKongSearchBlGeneralVO.getBlplace()).append("\n");
							flatFile.append("BLDATE:").append(hongKongSearchBlGeneralVO.getBldate()).append("\n");
							flatFile.append("SHPR1:").append(hongKongSearchBlGeneralVO.getShpr1()).append("\n");
							flatFile.append("SHPR2:").append(hongKongSearchBlGeneralVO.getShpr2()).append("\n");
							flatFile.append("SHPR3:").append(hongKongSearchBlGeneralVO.getShpr3()).append("\n");
							flatFile.append("SHPR4:").append(hongKongSearchBlGeneralVO.getShpr4()).append("\n");
							flatFile.append("SHPR5:").append(hongKongSearchBlGeneralVO.getShpr5()).append("\n");
							flatFile.append("CNEE1:").append(hongKongSearchBlGeneralVO.getCnee1()).append("\n");
							flatFile.append("CNEE2:").append(hongKongSearchBlGeneralVO.getCnee2()).append("\n");
							flatFile.append("CNEE3:").append(hongKongSearchBlGeneralVO.getCnee3()).append("\n");
							flatFile.append("CNEE4:").append(hongKongSearchBlGeneralVO.getCnee4()).append("\n");
							flatFile.append("CNEE5:").append(hongKongSearchBlGeneralVO.getCnee5()).append("\n");
							flatFile.append("NTFY1:").append(hongKongSearchBlGeneralVO.getNtfy1()).append("\n");
							flatFile.append("NTFY2:").append(hongKongSearchBlGeneralVO.getNtfy2()).append("\n");
							flatFile.append("NTFY3:").append(hongKongSearchBlGeneralVO.getNtfy3()).append("\n");
							flatFile.append("NTFY4:").append(hongKongSearchBlGeneralVO.getNtfy4()).append("\n");
							flatFile.append("NTFY5:").append(hongKongSearchBlGeneralVO.getNtfy5()).append("\n");
							flatFile.append("NTFY21:").append(hongKongSearchBlGeneralVO.getNtfy21()).append("\n");
							flatFile.append("NTFY22:").append(hongKongSearchBlGeneralVO.getNtfy22()).append("\n");
							flatFile.append("NTFY23:").append(hongKongSearchBlGeneralVO.getNtfy23()).append("\n");
							flatFile.append("NTFY24:").append(hongKongSearchBlGeneralVO.getNtfy24()).append("\n");
							flatFile.append("NTFY25:").append(hongKongSearchBlGeneralVO.getNtfy25()).append("\n");
							flatFile.append("FFWD1:").append(hongKongSearchBlGeneralVO.getFfwd1()).append("\n");
							flatFile.append("FFWD2:").append(hongKongSearchBlGeneralVO.getFfwd2()).append("\n");
							flatFile.append("FFWD3:").append(hongKongSearchBlGeneralVO.getFfwd3()).append("\n");
							flatFile.append("FFWD4:").append(hongKongSearchBlGeneralVO.getFfwd4()).append("\n");
							flatFile.append("FFWD5:").append(hongKongSearchBlGeneralVO.getFfwd5()).append("\n");
							flatFile.append("EXPO1:").append(hongKongSearchBlGeneralVO.getExpo1()).append("\n");
							flatFile.append("EXPO2:").append(hongKongSearchBlGeneralVO.getExpo2()).append("\n");
							flatFile.append("EXPO3:").append(hongKongSearchBlGeneralVO.getExpo3()).append("\n");
							flatFile.append("EXPO4:").append(hongKongSearchBlGeneralVO.getExpo4()).append("\n");
							flatFile.append("EXPO5:").append(hongKongSearchBlGeneralVO.getExpo5()).append("\n");
							flatFile.append("BLCOPY:").append(hongKongSearchBlGeneralVO.getBlcopy()).append("\n");
							flatFile.append("BLORG:").append(hongKongSearchBlGeneralVO.getBlorg()).append("\n");
							flatFile.append("BLPKG:").append(hongKongSearchBlGeneralVO.getBlpkg()).append("\n");
							flatFile.append("BLPKGU:").append(hongKongSearchBlGeneralVO.getBlpkgu()).append("\n");
							flatFile.append("BLWGT:").append(hongKongSearchBlGeneralVO.getBlwgt()).append("\n");
							flatFile.append("BLWGTU:").append(hongKongSearchBlGeneralVO.getBlwgtu()).append("\n");
							flatFile.append("BLMEA:").append(hongKongSearchBlGeneralVO.getBlmea()).append("\n");
							flatFile.append("BLMEAU:").append(hongKongSearchBlGeneralVO.getBlmeau()).append("\n");
							flatFile.append("BLQTY:").append(hongKongSearchBlGeneralVO.getBlqty()).append("\n");
							flatFile.append("RDTYPE:").append(hongKongSearchBlGeneralVO.getRdtype()).append("\n");
							flatFile.append("HOT:").append(hongKongSearchBlGeneralVO.getHot()).append("\n");
							flatFile.append("FRT:").append(hongKongSearchBlGeneralVO.getFrt()).append("\n");
							flatFile.append("CARGOTYPE:").append(hongKongSearchBlGeneralVO.getCargotype()).append("\n");
							flatFile.append("COMMODITY:").append(hongKongSearchBlGeneralVO.getCommodity()).append("\n");
							flatFile.append("REMARK:").append(hongKongSearchBlGeneralVO.getRemark()).append("\n");
							flatFile.append("AUS_QUAR:").append(hongKongSearchBlGeneralVO.getAusQuar()).append("\n");
							flatFile.append("BKGNBR:").append(hongKongSearchBlGeneralVO.getBkgnbr()).append("\n");
							flatFile.append("RGN_BKGNBR:").append(hongKongSearchBlGeneralVO.getRgnBkgnbr()).append("\n");
							flatFile.append("TS_IND:").append(hongKongSearchBlGeneralVO.getTsInd()).append("\n");
							flatFile.append("LOH:").append(hongKongSearchBlGeneralVO.getLoh()).append("\n");
							flatFile.append("AMEND_BL:").append("N").append("\n");

							// 홍콩세관에 Manifest 신고한 BL 전송 History를 생성한다.

							hongkongManifestTransmitVO.setBkgcgotp(hongKongSearchBlGeneralVO.getBkgcgotp().toString());
							hongkongManifestTransmitVO.setCmdtdesc(hongKongSearchBlGeneralVO.getCmdtNm().toString());
							hongkongManifestTransmitVO.setBkgsperf(hongKongSearchBlGeneralVO.getBkgsperf().toString());
							hongkongManifestTransmitVO.setBkgspedg(hongKongSearchBlGeneralVO.getBkgspedg().toString());
							hongkongManifestTransmitVO.setBkgspebb(hongKongSearchBlGeneralVO.getBkgspebb().toString());
							hongkongManifestTransmitVO.setBkgspeak(hongKongSearchBlGeneralVO.getBkgspeak().toString());
							hongkongManifestTransmitVO.setCmdtcd(hongKongSearchBlGeneralVO.getCmdtcd().toString());
							hongkongManifestTransmitVO.setBkgsperd(hongKongSearchBlGeneralVO.getBkgsperd().toString());
							// 홍콩세관 신고용 Manifest Marks & Description 정보를 조회한다.
							hongKongSearchMarksDescVOs = dbDao.searchMarkDesc(hongkongManifestTransmitVO);
							if (hongKongSearchMarksDescVOs != null) {
								HongKongSearchMarksDescVO hongKongSearchMarksDescVO;
								for (int k = 0; k < hongKongSearchMarksDescVOs.size(); k++) {
									flatFile.append("{DESC").append("\n");
									hongKongSearchMarksDescVO = hongKongSearchMarksDescVOs.get(k);
									String cmdt_desc = hongKongSearchMarksDescVO.getCmdtDesc();
									cmdt_desc = cmdt_desc.replace("&", "&amp;");
									cmdt_desc = cmdt_desc.replace("<", "&lt;");
									cmdt_desc = cmdt_desc.replace(">", "&gt;");
									cmdt_desc = cmdt_desc.replace("'", "&apos;");
									cmdt_desc = cmdt_desc.replace("\"", "&quot;");
									cmdt_desc = cmdt_desc.replace("\r" + "\n", "\n");
									
									String[] str = cmdt_desc.split("\n");
									for(int idx=0; idx < str.length; idx++) {
										flatFile.append("DESC:").append(str[idx]).append("\n");
									}
																		
									flatFile.append("}DESC").append("\n");
									flatFile.append("{MARK").append("\n");
									String mk_desc = hongKongSearchMarksDescVO.getMkDesc();
									mk_desc = mk_desc.replace("&", "&amp;");
									mk_desc = mk_desc.replace("<", "&lt;");
									mk_desc = mk_desc.replace(">", "&gt;");
									mk_desc = mk_desc.replace("'", "&apos;");
									mk_desc = mk_desc.replace("\"", "&quot;");
									mk_desc = mk_desc.replace("\r" + "\n", "\n");

									String[] str2 = mk_desc.split("\n");
									for(int idx=0; idx < str2.length; idx++) {
										flatFile.append("MARKNO:").append(str2[idx]).append("\n");
									}

									flatFile.append("}MARK").append("\n");
								}
							}
							// ///
							// 홍콩세관 신고용 Manifest Container Detail 정보를 조회한다.
							hongKongSearchCntrDetailVOs = dbDao.searchCntrDetail(hongkongManifestTransmitVO);
							if (hongKongSearchCntrDetailVOs != null) {
								HongKongSearchCntrDetailVO hongKongSearchCntrDetailVO;
								for (int k = 0; k < hongKongSearchCntrDetailVOs.size(); k++) {
									flatFile.append("{CNTR_INFO").append("\n");
									hongKongSearchCntrDetailVO = hongKongSearchCntrDetailVOs.get(k);
									flatFile.append("CNTRNBR:").append(hongKongSearchCntrDetailVO.getCntrnbr()).append("\n");
									flatFile.append("PUNIT:").append(hongKongSearchCntrDetailVO.getPunit()).append("\n");
									flatFile.append("PKG:").append(hongKongSearchCntrDetailVO.getPkg()).append("\n");
									flatFile.append("WUNIT:").append(hongKongSearchCntrDetailVO.getWunit()).append("\n");
									flatFile.append("CNTRWGT:").append(hongKongSearchCntrDetailVO.getCntrwgt()).append("\n");
									flatFile.append("CNTRTYPE:").append(hongKongSearchCntrDetailVO.getCntrtype()).append("\n");
									flatFile.append("SEALNBR:").append(hongKongSearchCntrDetailVO.getSealnbr()).append("\n");
									flatFile.append("FM_IND:").append(hongKongSearchCntrDetailVO.getFmInd()).append("\n");
									flatFile.append("RF_IND:").append(hongKongSearchCntrDetailVO.getRfInd()).append("\n");
									flatFile.append("DG_IND:").append(hongKongSearchCntrDetailVO.getDgInd()).append("\n");
									flatFile.append("AK_IND:").append(hongKongSearchCntrDetailVO.getAkInd()).append("\n");
									flatFile.append("BK_IND:").append(hongKongSearchCntrDetailVO.getBkInd()).append("\n");
									flatFile.append("TEMP:").append(hongKongSearchCntrDetailVO.getTemp()).append("\n");
									flatFile.append("TUNIT:").append(hongKongSearchCntrDetailVO.getTunit()).append("\n");
									flatFile.append("VENT:").append(hongKongSearchCntrDetailVO.getVent()).append("\n");
									flatFile.append("MUNIT:").append(hongKongSearchCntrDetailVO.getMunit()).append("\n");
									flatFile.append("MEASURE:").append(hongKongSearchCntrDetailVO.getMeasure()).append("\n");
									flatFile.append("RDTYPE:").append(hongKongSearchCntrDetailVO.getRdtype()).append("\n");
									flatFile.append("CMDT_DESC:").append(hongKongSearchCntrDetailVO.getCmdtDesc()).append("\n");
									flatFile.append("CMDTCD:").append(hongKongSearchCntrDetailVO.getCmdtcd()).append("\n");
									flatFile.append("RF_REMARK:").append(hongKongSearchCntrDetailVO.getRfRemark()).append("\n");
									flatFile.append("RFDRY_IND:").append(hongKongSearchCntrDetailVO.getRfdryInd()).append("\n");
									flatFile.append("OVF:").append(hongKongSearchCntrDetailVO.getOvf()).append("\n");
									flatFile.append("OVR:").append(hongKongSearchCntrDetailVO.getOvr()).append("\n");
									flatFile.append("OVH:").append(hongKongSearchCntrDetailVO.getOvh()).append("\n");
									flatFile.append("OVLW:").append(hongKongSearchCntrDetailVO.getOvlw()).append("\n");
									flatFile.append("OVRW:").append(hongKongSearchCntrDetailVO.getOvrw()).append("\n");
									flatFile.append("OVWGT:").append(hongKongSearchCntrDetailVO.getOvwgt()).append("\n");
									flatFile.append("VOID_SLOT:").append(hongKongSearchCntrDetailVO.getVoidSlot()).append("\n");
									flatFile.append("STWG_REQ:").append(hongKongSearchCntrDetailVO.getStwgReq()).append("\n");
									flatFile.append("AMEND_CNTR:").append(hongKongSearchCntrDetailVO.getAmendCntr()).append("\n");
									flatFile.append("CUSTOMS_DESC:").append(hongKongSearchCntrDetailVO.getCustomsDesc()).append("\n");
									hongkongManifestTransmitVO.setCntrNo(hongKongSearchCntrDetailVO.getCntrNo());
									// 홍콩세관 신고용 Manifest Container Danger 정보를
									// 조회한다.
									hongKongSearchCntrDangerVOs = dbDao.searchCntrDanger(hongkongManifestTransmitVO);
									if (hongKongSearchCntrDangerVOs != null) {
										HongKongSearchCntrDangerVO hongKongSearchCntrDangerVO;
										for (int l = 0; l < hongKongSearchCntrDangerVOs.size(); l++) {
											flatFile.append("{CNTR_DANGER").append("\n");
											hongKongSearchCntrDangerVO = hongKongSearchCntrDangerVOs.get(l);
											flatFile.append(hongKongSearchCntrDangerVO.getUnnbr()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getImdgClssCd()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getDescnm()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getPhone()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getPage()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getFlshTemp()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getFlshUnit()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getDgRemark()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getEmsno()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getPsacls()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getPkggrp()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getMfag1()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getMfag2()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getMarPoll()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getLabelCd()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getLabelDesc()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getPkg()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getPkgunit()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getNwgt()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getGwgt()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getMea()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getHazCont()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getStwg()).append("\n");
											flatFile.append(hongKongSearchCntrDangerVO.getLabel()).append("\n");
											flatFile.append("}CNTR_DANGER").append("\n");
										}
									}
									// ///
									// 홍콩세관 신고용 Manifest Container Description
									// 정보를 조회한다.
									hongKongSearchCntrDescVOs = dbDao.searchCntrDesc(hongkongManifestTransmitVO);
									if (hongKongSearchCntrDescVOs != null) {
										HongKongSearchCntrDescVO hongKongSearchCntrDescVO;
										for (int l = 0; l < hongKongSearchCntrDescVOs.size(); l++) {
											flatFile.append("{CNTR_DESC").append("\n");
											hongKongSearchCntrDescVO = hongKongSearchCntrDescVOs.get(l);
											flatFile.append(hongKongSearchCntrDescVO.getDCmdt()).append("\n");
											flatFile.append(hongKongSearchCntrDescVO.getDPunit()).append("\n");
											flatFile.append(hongKongSearchCntrDescVO.getDPkg()).append("\n");
											flatFile.append(hongKongSearchCntrDescVO.getDWunit()).append("\n");
											flatFile.append(hongKongSearchCntrDescVO.getDWgt()).append("\n");
											flatFile.append(hongKongSearchCntrDescVO.getDMunit()).append("\n");
											flatFile.append(hongKongSearchCntrDescVO.getDMeas()).append("\n");
											flatFile.append(hongKongSearchCntrDescVO.getDDesc()).append("\n");
											if ( !hongKongSearchCntrDescVO.getCusMark().equals("")
												  && hongKongSearchCntrDescVO.getCusMark() != null )
											{
												flatFile.append("{CUS_MARK").append("\n");
												flatFile.append("D_MARK:");
												StringTokenizer token = new StringTokenizer(hongKongSearchCntrDescVO
														.getCusMark(), "\n");
												ArrayList tmpArray = new ArrayList();
												while (token.hasMoreTokens()) {
													tmpArray.add(token.nextToken());
												}
												for (int mm = 0; mm < tmpArray.size(); mm++) {
													flatFile.append(tmpArray.get(mm).toString());
													// flatFile.append("\n");
												}
												flatFile.append("\n").append("}CUS_MARK").append("\n");
											}
											flatFile.append("}CNTR_DESC").append("\n");
										}
									}
									flatFile.append("}CNTR_INFO").append("\n");
								}
							}
							// ////
							// 홍콩세관 신고용 Manifest Qty 정보를 조회한다.
							hongKongSearchQtyVOs = dbDao.searchQty(hongkongManifestTransmitVO);
							if (hongKongSearchQtyVOs != null) {
								HongKongSearchQtyVO hongKongSearchQtyVO;
								for (int k = 0; k < hongKongSearchQtyVOs.size(); k++) {
									flatFile.append("{QTY").append("\n");
									hongKongSearchQtyVO = hongKongSearchQtyVOs.get(k);
									flatFile.append(hongKongSearchQtyVO.getHantype()).append("\n");
									flatFile.append(hongKongSearchQtyVO.getOpCntrQty()).append("\n");
									flatFile.append("}QTY").append("\n");
								}
							}
							// 홍콩세관 신고용 Manifest Booking VVD 정보를 조회한다.
							hongKongSearchBkgVvdVOs = dbDao.searchBkgVvd(hongkongManifestTransmitVO);
							if (hongKongSearchBkgVvdVOs != null) {
								HongKongSearchBkgVvdVO hongKongSearchBkgVvdVO;
								for (int k = 0; k < hongKongSearchBkgVvdVOs.size(); k++) {
									flatFile.append("{BKGVVD").append("\n");
									hongKongSearchBkgVvdVO = hongKongSearchBkgVvdVOs.get(k);
									flatFile.append(hongKongSearchBkgVvdVO.getVvdNumber()).append("\n");
									flatFile.append(hongKongSearchBkgVvdVO.getBpol()).append("\n");
									flatFile.append(hongKongSearchBkgVvdVO.getBpod()).append("\n");
								}
							}
							flatFile.append("}BL_INFO").append("\n");
						}
					}
				}
			}

			// 홍콩세관에 Manifest 신고한 VSL 전송 History를 생성한다.
			hongkongManifestTransmitVO.setMfSndDt(command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
			dbDao.addVslSendLog(hongkongManifestTransmitVO);
			// ///

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_HKGMF.IBMMQ.QUEUE"));

			
			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param HongKongManifestTransmitVO[] hongKongManifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, HongKongManifestTransmitVO[] hongKongManifestTransmitVOs, String pgmNo)
			throws EventException {
		HongKongCustomsTransmissionBackEndJob backEndJob = new HongKongCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try {
			if (pgmNo.equals("ESM_BKG_0282")) {
				backEndJob.setHongKongManifestTransmitVOs(hongKongManifestTransmitVOs);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Hongkong Transmit.");
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return resultStr;
	}		
}