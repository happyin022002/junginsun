/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TaiwanCustomsTransmissionBCImpl.java
 *@FileTitle : TaiwanCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.04.21 임재택
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration.TaiwanCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlChargeTotalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlChargeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlGeneralVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlMarksDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchBlVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchContainerDangerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchContainerDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchEstimateDtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchMsgHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchSubMsgHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanSearchVesselVO;
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
public class TaiwanCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient TaiwanCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public TaiwanCustomsTransmissionBCImpl() {
		dbDao = new TaiwanCustomsTransmissionDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsTransmission화면에 대한 조회 이벤트 처리<br>
	 * FlatFile 생성
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */

	@SuppressWarnings("unchecked")
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException {
		StringBuffer flatFile = new StringBuffer();

		TaiwanManifestTransmitVO taiwanManifestTransmitVO = new TaiwanManifestTransmitVO();
		List<TaiwanSearchVesselVO> taiwanSearchVesselVOs = null;
		List<TaiwanSearchEstimateDtVO> taiwanSearchEstimateDtVOs = null;
		List<TaiwanSearchBlGeneralVO> taiwanSearchBlGeneralVOs = null;
		List<TaiwanSearchBlChargeVO> taiwanSearchBlChargeVOs = null;
		List<TaiwanSearchBlChargeTotalVO> taiwanSearchBlChargeTotalVOs = null;
		List<TaiwanSearchBlMarksDescVO> taiwanSearchBlMarksDescVOs = null;
		List<TaiwanSearchContainerVO> taiwanSearchContainerVOs = null;
		List<TaiwanSearchContainerDangerVO> taiwanSearchContainerDangerVOs = null;
		List<TaiwanSearchContainerDescVO> taiwanSearchContainerDescVOs = null;
		List<TaiwanSearchBlQtyVO> taiwanSearchBlQtyVOs = null;
		List<TaiwanSearchBlVvdVO> taiwanSearchBlVvdVOs = null;
		List<TaiwanSearchMsgHeaderVO> taiwanSearchMsgHeaderVOs = null;
		List<TaiwanSearchSubMsgHeaderVO> taiwanSearchSubMsgHeaderVOs = null;
		String stParm1 = "";
		String stParm2 = "";
		String subHeader = "";
		try {
			taiwanSearchMsgHeaderVOs = dbDao.searchMsgHeader();
			// main header
			if (taiwanSearchMsgHeaderVOs != null) {
				TaiwanSearchMsgHeaderVO taiwanSearchMsgHeaderVO;
				for (int i = 0; i < taiwanSearchMsgHeaderVOs.size(); i++) {
					taiwanSearchMsgHeaderVO = taiwanSearchMsgHeaderVOs.get(i);
					flatFile.append(taiwanSearchMsgHeaderVO.getMsgHeader()).append("\n");
				}
			}
			// sub header
			taiwanSearchSubMsgHeaderVOs = dbDao.searchMsgSubHeader();
			if (taiwanSearchSubMsgHeaderVOs != null) {
				TaiwanSearchSubMsgHeaderVO taiwanSearchSubMsgHeaderVO;
				for (int i = 0; i < taiwanSearchSubMsgHeaderVOs.size(); i++) {
					taiwanSearchSubMsgHeaderVO = taiwanSearchSubMsgHeaderVOs.get(i);
					subHeader = taiwanSearchSubMsgHeaderVO.getSubMsgHeader();
				}
			}
			if (manifestTransmitVOs != null) {
				for (int i = 0; i < manifestTransmitVOs.length; i++) {
					taiwanManifestTransmitVO = (TaiwanManifestTransmitVO) manifestTransmitVOs[i];

					// 대만세관 신고용 Manifest B/L General 정보를 조회한다.
					taiwanManifestTransmitVO.setSt10(stParm1);
					taiwanManifestTransmitVO.setSt9(stParm2);
					taiwanSearchBlGeneralVOs = dbDao.searchBlGeneral(taiwanManifestTransmitVO);
					if (taiwanSearchBlGeneralVOs != null && taiwanSearchBlGeneralVOs.size() > 0) {
						// flatFile.append(subHeader).append("\n");
						TaiwanSearchBlGeneralVO taiwanSearchBlGeneralVO;

						for (int j = 0; j < taiwanSearchBlGeneralVOs.size(); j++) {
							flatFile.append(subHeader).append("\n");
							taiwanSearchBlGeneralVO = taiwanSearchBlGeneralVOs.get(j);

							flatFile.append("VVD:").append(taiwanSearchBlGeneralVO.getVvdNumber()).append("\n");

							// 대만세관 신고용 Manifest Vessel 정보를 조회한다.
							taiwanSearchVesselVOs = dbDao.searchVessel(taiwanManifestTransmitVO);
							if (taiwanSearchVesselVOs != null) {
								TaiwanSearchVesselVO taiwanSearchVesselVO;
								for (int jj = 0; jj < taiwanSearchVesselVOs.size(); jj++) {
									taiwanSearchVesselVO = taiwanSearchVesselVOs.get(jj);
									flatFile.append("VSL_CALLSIGN:").append(taiwanSearchVesselVO.getVslCallsign())
											.append("\n");
									flatFile.append("VSL_LLOYDCODE:").append(taiwanSearchVesselVO.getVslLloydcode())
											.append("\n");
									flatFile.append("VSL_FULLNAME:").append(taiwanSearchVesselVO.getVslFullname())
											.append("\n");
								}
							}
							// 대만세관 신고용 Manifest Estimated Date 정보를 조회한다.
							taiwanSearchEstimateDtVOs = dbDao.searchEstimateDt(taiwanManifestTransmitVO);
							if (taiwanSearchEstimateDtVOs != null) {
								TaiwanSearchEstimateDtVO taiwanSearchEstimateDtVO;
								for (int jj = 0; jj < taiwanSearchEstimateDtVOs.size(); jj++) {
									taiwanSearchEstimateDtVO = taiwanSearchEstimateDtVOs.get(jj);
									flatFile.append("ETA:").append(taiwanSearchEstimateDtVO.getEtaDt()).append("\n");
									flatFile.append("ETD:").append(taiwanSearchEstimateDtVO.getEtdDt()).append("\n");
								}
							}
							flatFile.append("BLNBR:").append(taiwanSearchBlGeneralVO.getBlnbr()).append("\n");
							flatFile.append("BLPOL:").append(taiwanSearchBlGeneralVO.getBlpol()).append("\n");
							flatFile.append("BLPOD:").append(taiwanSearchBlGeneralVO.getBlpod()).append("\n");
							flatFile.append("BLPOR:").append(taiwanSearchBlGeneralVO.getBlpor()).append("\n");
							flatFile.append("BLDEL:").append(taiwanSearchBlGeneralVO.getBldel()).append("\n");
							flatFile.append("BLRLY:").append(taiwanSearchBlGeneralVO.getBlrly()).append("\n");
							flatFile.append("BLPLACE:").append(taiwanSearchBlGeneralVO.getBlplace()).append("\n");
							flatFile.append("BLDATE:").append(taiwanSearchBlGeneralVO.getBldate()).append("\n");
							flatFile.append("SHPR1:").append(taiwanSearchBlGeneralVO.getShpr1()).append("\n");
							flatFile.append("SHPR2:").append(taiwanSearchBlGeneralVO.getShpr2()).append("\n");
							flatFile.append("SHPR3:").append(taiwanSearchBlGeneralVO.getShpr3()).append("\n");
							flatFile.append("SHPR4:").append(taiwanSearchBlGeneralVO.getShpr4()).append("\n");
							flatFile.append("SHPR5:").append(taiwanSearchBlGeneralVO.getShpr5()).append("\n");
							flatFile.append("CNEE1:").append(taiwanSearchBlGeneralVO.getCnee1()).append("\n");
							flatFile.append("CNEE2:").append(taiwanSearchBlGeneralVO.getCnee2()).append("\n");
							flatFile.append("CNEE3:").append(taiwanSearchBlGeneralVO.getCnee3()).append("\n");
							flatFile.append("CNEE4:").append(taiwanSearchBlGeneralVO.getCnee4()).append("\n");
							flatFile.append("CNEE5:").append(taiwanSearchBlGeneralVO.getCnee5()).append("\n");
							flatFile.append("NTFY1:").append(taiwanSearchBlGeneralVO.getNtfy1()).append("\n");
							flatFile.append("NTFY2:").append(taiwanSearchBlGeneralVO.getNtfy2()).append("\n");
							flatFile.append("NTFY3:").append(taiwanSearchBlGeneralVO.getNtfy3()).append("\n");
							flatFile.append("NTFY4:").append(taiwanSearchBlGeneralVO.getNtfy4()).append("\n");
							flatFile.append("NTFY5:").append(taiwanSearchBlGeneralVO.getNtfy5()).append("\n");
							flatFile.append("NTFY21:").append(taiwanSearchBlGeneralVO.getNtfy21()).append("\n");
							flatFile.append("NTFY22:").append(taiwanSearchBlGeneralVO.getNtfy22()).append("\n");
							flatFile.append("NTFY23:").append(taiwanSearchBlGeneralVO.getNtfy23()).append("\n");
							flatFile.append("NTFY24:").append(taiwanSearchBlGeneralVO.getNtfy24()).append("\n");
							flatFile.append("NTFY25:").append(taiwanSearchBlGeneralVO.getNtfy25()).append("\n");
							flatFile.append("FFWD1:").append(taiwanSearchBlGeneralVO.getFfwd1()).append("\n");
							flatFile.append("FFWD2:").append(taiwanSearchBlGeneralVO.getFfwd2()).append("\n");
							flatFile.append("FFWD3:").append(taiwanSearchBlGeneralVO.getFfwd3()).append("\n");
							flatFile.append("FFWD4:").append(taiwanSearchBlGeneralVO.getFfwd4()).append("\n");
							flatFile.append("FFWD5:").append(taiwanSearchBlGeneralVO.getFfwd5()).append("\n");
							flatFile.append("EXPO1:").append(taiwanSearchBlGeneralVO.getExpo1()).append("\n");
							flatFile.append("EXPO2:").append(taiwanSearchBlGeneralVO.getExpo2()).append("\n");
							flatFile.append("EXPO3:").append(taiwanSearchBlGeneralVO.getExpo3()).append("\n");
							flatFile.append("EXPO4:").append(taiwanSearchBlGeneralVO.getExpo4()).append("\n");
							flatFile.append("EXPO5:").append(taiwanSearchBlGeneralVO.getExpo5()).append("\n");
							flatFile.append("BLCOPY:").append(taiwanSearchBlGeneralVO.getBlcopy()).append("\n");
							flatFile.append("BLORG:").append(taiwanSearchBlGeneralVO.getBlorg()).append("\n");
							flatFile.append("BLPKG:").append(taiwanSearchBlGeneralVO.getBlpkg()).append("\n");
							flatFile.append("BLPKGU:").append(taiwanSearchBlGeneralVO.getBlpkgu()).append("\n");
							flatFile.append("BLWGT:").append(taiwanSearchBlGeneralVO.getBlwgt()).append("\n");
							flatFile.append("BLMEA:").append(taiwanSearchBlGeneralVO.getBlmea()).append("\n");
							flatFile.append("RDTYPE:").append(taiwanSearchBlGeneralVO.getRdtype()).append("\n");
							flatFile.append("CARGOTYPE:").append(taiwanSearchBlGeneralVO.getCargotype()).append("\n");
							flatFile.append("COMMODITY:").append(taiwanSearchBlGeneralVO.getCommodity()).append("\n");
							flatFile.append("REMARK:").append(taiwanSearchBlGeneralVO.getRemark()).append("\n");
							flatFile.append("AUS_QUAR:").append(taiwanSearchBlGeneralVO.getAusquar()).append("\n");

							taiwanManifestTransmitVO.setBkgNo(taiwanSearchBlGeneralVO.getBkgNo());
							// 대만세관 신고용 Manifest B/L Charge 정보를 조회한다.
							taiwanSearchBlChargeVOs = dbDao.searchBlCharge(taiwanManifestTransmitVO);
							if (taiwanSearchBlChargeVOs != null) {
								TaiwanSearchBlChargeVO taiwanSearchBlChargeVO;

								for (int k = 0; k < taiwanSearchBlChargeVOs.size(); k++) {
									flatFile.append("{CHARGE").append("\n");
									taiwanSearchBlChargeVO = taiwanSearchBlChargeVOs.get(k);
									flatFile.append("FCTYPE:").append(taiwanSearchBlChargeVO.getFctype()).append("\n");
									flatFile.append("RATE:").append(taiwanSearchBlChargeVO.getRate()).append("\n");
									flatFile.append("REVENUETON:").append(taiwanSearchBlChargeVO.getRevenueton())
											.append("\n");
									flatFile.append("PPD:").append(taiwanSearchBlChargeVO.getPpd()).append("\n");
									flatFile.append("CCT:").append(taiwanSearchBlChargeVO.getCct()).append("\n");
									flatFile.append("CURRENCYCODE:").append(taiwanSearchBlChargeVO.getCurrencycode())
											.append("\n");
									flatFile.append("TARIFF:").append(taiwanSearchBlChargeVO.getTariff()).append("\n");
									flatFile.append("PERTYPE:").append(taiwanSearchBlChargeVO.getPertype())
											.append("\n");
									flatFile.append("}CHARGE").append("\n");
								}
							}
							// 대만세관 신고용 Manifest B/L Charge Total 정보를 조회한다.
							taiwanSearchBlChargeTotalVOs = dbDao.searchBlChargeTotal(taiwanManifestTransmitVO);
							if (taiwanSearchBlChargeTotalVOs != null) {
								TaiwanSearchBlChargeTotalVO taiwanSearchBlChargeTotalVO;
								for (int k = 0; k < taiwanSearchBlChargeTotalVOs.size(); k++) {
									flatFile.append("{CHARGE_TTL").append("\n");
									taiwanSearchBlChargeTotalVO = taiwanSearchBlChargeTotalVOs.get(k);
									flatFile.append("PPD_TOTAL:").append(taiwanSearchBlChargeTotalVO.getPpdTotal())
											.append("\n");
									flatFile.append("CCT_TOTAL:").append(taiwanSearchBlChargeTotalVO.getCctTotal())
											.append("\n");
									flatFile.append("TOTAL_CUR:").append(taiwanSearchBlChargeTotalVO.getTotalCur())
											.append("\n");
									flatFile.append("}CHARGE_TTL").append("\n");
								}
							}
							// 대만세관 신고용 Manifest B/L Marks, Description 정보를 조회한다.
							taiwanSearchBlMarksDescVOs = dbDao.searchBlMarkDesc(taiwanManifestTransmitVO);
							if (taiwanSearchBlMarksDescVOs != null) {
								TaiwanSearchBlMarksDescVO taiwanSearchBlMarksDescVO;
								for (int k = 0; k < taiwanSearchBlMarksDescVOs.size(); k++) {

									taiwanSearchBlMarksDescVO = taiwanSearchBlMarksDescVOs.get(k);
									String cmdtDesc = taiwanSearchBlMarksDescVO.getTmpstr4();
									cmdtDesc = cmdtDesc.replace("\r" + "\n", "\n" + " ");

									// StringTokenizer token = new
									// StringTokenizer(taiwanSearchBlMarksDescVO.getTmpstr4(), "\n");
									StringTokenizer token = new StringTokenizer(cmdtDesc, "\n");
									ArrayList tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{DESC").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("DESC:").append(tmpArray.get(mm).toString()).append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}DESC").append("\n");

									String mkDesc = taiwanSearchBlMarksDescVO.getTmpstr5();
									mkDesc = mkDesc.replace("\r" + "\n", "\n" + "\n");

									// token = new StringTokenizer(taiwanSearchBlMarksDescVO.getTmpstr5(), "\n");
									token = new StringTokenizer(mkDesc, "\n");
									tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{MARK").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("MARKNO:").append(tmpArray.get(mm).toString()).append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}MARK").append("\n");

								}
							}
							// 대만세관 신고용 Manifest Container 정보를 조회한다.
							taiwanManifestTransmitVO.setBkgcgotp(taiwanSearchBlGeneralVO.getBkgcgotp());
							taiwanManifestTransmitVO.setBkgsperf(taiwanSearchBlGeneralVO.getBkgsperf());
							taiwanManifestTransmitVO.setBkgspedg(taiwanSearchBlGeneralVO.getBkgspedg());
							taiwanManifestTransmitVO.setBkgspeak(taiwanSearchBlGeneralVO.getBkgspeak());
							taiwanManifestTransmitVO.setBkgspebb(taiwanSearchBlGeneralVO.getBkgspebb());
							taiwanManifestTransmitVO.setCmdtdesc(taiwanSearchBlGeneralVO.getCmdtdesc());
							taiwanManifestTransmitVO.setCmdtcd(taiwanSearchBlGeneralVO.getCmdtcd());
							taiwanManifestTransmitVO.setBkgsperd(taiwanSearchBlGeneralVO.getBkgsperd());

							taiwanSearchContainerVOs = dbDao.searchContainer(taiwanManifestTransmitVO);
							if (taiwanSearchContainerVOs != null) {
								TaiwanSearchContainerVO taiwanSearchContainerVO;
								for (int k = 0; k < taiwanSearchContainerVOs.size(); k++) {
									taiwanSearchContainerVO = taiwanSearchContainerVOs.get(k);
									flatFile.append("{CNTR_INFO").append("\n");
									flatFile.append("CNTRNBR:").append(taiwanSearchContainerVO.getCntrnbr()).append(
											"\n");
									flatFile.append("PUNIT:").append(taiwanSearchContainerVO.getPunit()).append("\n");
									flatFile.append("PKG:").append(taiwanSearchContainerVO.getPkg()).append("\n");
									flatFile.append("CNTRWGT:").append(taiwanSearchContainerVO.getCntrwgt()).append(
											"\n");
									flatFile.append("CNTRTYPE:").append(taiwanSearchContainerVO.getCntrtype()).append(
											"\n");
									flatFile.append("SEALNBR:").append(taiwanSearchContainerVO.getSealnbr()).append(
											"\n");
									flatFile.append("FM_IND:").append(taiwanSearchContainerVO.getFmInd()).append("\n");
									flatFile.append("RF_IND:").append(taiwanSearchContainerVO.getRfInd()).append("\n");
									flatFile.append("DG_IND:").append(taiwanSearchContainerVO.getDgInd()).append("\n");
									flatFile.append("AK_IND:").append(taiwanSearchContainerVO.getAkInd()).append("\n");
									flatFile.append("BK_IND:").append(taiwanSearchContainerVO.getBkInd()).append("\n");
									flatFile.append("TEMP:").append(taiwanSearchContainerVO.getTemp()).append("\n");
									flatFile.append("TUNIT:").append(taiwanSearchContainerVO.getTunit()).append("\n");
									flatFile.append("VENT:").append(taiwanSearchContainerVO.getVent()).append("\n");
									flatFile.append("MEASURE:").append(taiwanSearchContainerVO.getMeasure()).append(
											"\n");
									flatFile.append("RDTYPE:").append(taiwanSearchContainerVO.getRdtype()).append("\n");
									flatFile.append("CMDT_DESC:").append(taiwanSearchContainerVO.getCmdtDesc()).append(
											"\n");
									flatFile.append("CMDTCD:").append(taiwanSearchContainerVO.getCmdtcd()).append("\n");
									flatFile.append("RF_REMARK:").append(taiwanSearchContainerVO.getRfRemark()).append(
											"\n");
									flatFile.append("RFDRY_IND:").append(taiwanSearchContainerVO.getRfdryInd()).append(
											"\n");
									flatFile.append("OVF:").append(taiwanSearchContainerVO.getOvf()).append("\n");
									flatFile.append("OVR:").append(taiwanSearchContainerVO.getOvr()).append("\n");
									flatFile.append("OVH:").append(taiwanSearchContainerVO.getOvh()).append("\n");
									flatFile.append("OVLW:").append(taiwanSearchContainerVO.getOvlw()).append("\n");
									flatFile.append("OVRW:").append(taiwanSearchContainerVO.getOvrw()).append("\n");
									flatFile.append("OVWGT:").append(taiwanSearchContainerVO.getOvwgt()).append("\n");
									flatFile.append("VOID_SLOT:").append(taiwanSearchContainerVO.getVoidSlot()).append(
											"\n");
									flatFile.append("STWG_REQ:").append(taiwanSearchContainerVO.getStwgReq()).append(
											"\n");

									taiwanManifestTransmitVO.setCntrNo(taiwanSearchContainerVO.getCntrNo());
									// 대만세관 신고용 Manifest Container Danger 정보를 조회한다.
									taiwanSearchContainerDangerVOs = dbDao
											.searchContainerDanger(taiwanManifestTransmitVO);
									if (taiwanSearchContainerDangerVOs != null) {
										TaiwanSearchContainerDangerVO taiwanSearchContainerDangerVO;
										for (int m = 0; m < taiwanSearchContainerDangerVOs.size(); m++) {
											flatFile.append("{CNTR_DANGER").append("\n");
											taiwanSearchContainerDangerVO = taiwanSearchContainerDangerVOs.get(m);
											flatFile.append("UNNBR:").append(taiwanSearchContainerDangerVO.getUnnbr())
													.append("\n");
											flatFile.append("CLASS:").append(
													taiwanSearchContainerDangerVO.getImdgClass()).append("\n");
											flatFile.append("DESC:").append(
													taiwanSearchContainerDangerVO.getDescRemark()).append("\n");
											flatFile.append("PHONE:").append(taiwanSearchContainerDangerVO.getPhone())
													.append("\n");
											flatFile.append("PAGE:").append(taiwanSearchContainerDangerVO.getDPage())
													.append("\n");
											
											/*
											 * 2010.12.30 경종윤
											 * FLSH_TEMP : 공백 제거 추가
											 * 	- length : 8 
											 *  - 오류 데이타 예 : 32C - 49C (9자리)
											 * 
											 */
											flatFile.append("FLSH_TEMP:").append(
													taiwanSearchContainerDangerVO.getFlshTemp().replaceAll(" ", "")).append("\n");
											flatFile.append("FLSH_UNIT:").append(
													taiwanSearchContainerDangerVO.getFlshUnit()).append("\n");
											flatFile.append("DG_REMARK:").append(
													taiwanSearchContainerDangerVO.getDgRemark()).append("\n");
											flatFile.append("}CNTR_DANGER").append("\n");
										}
									}
									// 대만세관 신고용 Manifest Container Description 정보를 조회한다.
									taiwanSearchContainerDescVOs = dbDao.searchContainerDesc(taiwanManifestTransmitVO);
									if (taiwanSearchContainerDescVOs != null) {
										TaiwanSearchContainerDescVO taiwanSearchContainerDescVO;
										for (int m = 0; m < taiwanSearchContainerDescVOs.size(); m++) {
											taiwanSearchContainerDescVO = taiwanSearchContainerDescVOs.get(m);
											flatFile.append("{CNTR_DESC").append("\n");
											if ( taiwanSearchContainerDescVO.getDCmdt()!=null && !taiwanSearchContainerDescVO.getDCmdt().equals(" ") )
												flatFile.append("D_CMDT:").append(taiwanSearchContainerDescVO.getDCmdt()).append("\n");
											else
												flatFile.append("D_CMDT:").append(taiwanSearchBlGeneralVO.getCommodity()).append("\n");
											flatFile.append("D_PUNIT:").append(taiwanSearchContainerDescVO.getDPunit())
													.append("\n");
											flatFile.append("D_PKG:").append(taiwanSearchContainerDescVO.getDPkg())
													.append("\n");
											flatFile.append("D_WGT:").append(taiwanSearchContainerDescVO.getDWgt())
													.append("\n");
											flatFile.append("D_MEAS:").append(taiwanSearchContainerDescVO.getDMea())
													.append("\n");
											flatFile.append("D_DESC:")
													.append(taiwanSearchContainerDescVO.getCntrDesc()).append("\n");

											StringTokenizer token = new StringTokenizer(taiwanSearchContainerDescVO
													.getSt13(), "\n");
											ArrayList tmpArray = new ArrayList();
											while (token.hasMoreTokens()) {
												tmpArray.add(token.nextToken());
											}
											for (int mm = 0; mm < tmpArray.size(); mm++) {
												flatFile.append(tmpArray.get(mm).toString());
												flatFile.append("\n");
											}
											flatFile.append("}CNTR_DESC").append("\n");

										}
										
									}
									flatFile.append("}CNTR_INFO").append("\n");
								}
							}
							// 대만세관 신고용 Manifest B/L Qty 정보를 조회한다.
							taiwanSearchBlQtyVOs = dbDao.searchBlQty(taiwanManifestTransmitVO);
							if (taiwanSearchBlQtyVOs != null) {

								TaiwanSearchBlQtyVO taiwanSearchBlQtyVO;
								for (int m = 0; m < taiwanSearchBlQtyVOs.size(); m++) {
									flatFile.append("{QTY").append("\n");
									taiwanSearchBlQtyVO = taiwanSearchBlQtyVOs.get(m);
									flatFile.append("HANTYPE:").append(taiwanSearchBlQtyVO.getHantype()).append("\n");
									flatFile.append("COUNT:").append(taiwanSearchBlQtyVO.getCntrQty()).append("\n");
									flatFile.append("}QTY").append("\n");
								}

							}
							// 대만세관 신고용 Manifest B/L VVD정보를 조회한다.
							taiwanSearchBlVvdVOs = dbDao.searchBlVvd(taiwanManifestTransmitVO);
							if (taiwanSearchBlVvdVOs != null) {
								TaiwanSearchBlVvdVO taiwanSearchBlVvdVO;

								for (int m = 0; m < taiwanSearchBlVvdVOs.size(); m++) {
									flatFile.append("{BKGVVD").append("\n");
									taiwanSearchBlVvdVO = taiwanSearchBlVvdVOs.get(m);
									flatFile.append("BVVD:").append(taiwanSearchBlVvdVO.getBvvd()).append("\n");
									flatFile.append("BPOL:").append(taiwanSearchBlVvdVO.getBpol()).append("\n");
									flatFile.append("BPOD:").append(taiwanSearchBlVvdVO.getBpod()).append("\n");
									flatFile.append("}BKGVVD").append("\n");
								}

							}
						}
					} else {
						flatFile = new StringBuffer();
					}

				}
			}

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_TPEMF.IBMMQ.QUEUE"));

			BookingUtil command = new BookingUtil();
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
	 * @param TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs, String pgmNo)
			throws EventException {
		TaiwanCustomsTransmissionBackEndJob backEndJob = new TaiwanCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try {
			if (pgmNo.equals("ESM_BKG_0497")) {
				backEndJob.setTaiwanManifestTransmitVOs(taiwanManifestTransmitVOs);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Taiwan Transmit.");
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return resultStr;
	}	
	
	/**
	 * 타이완 flatfile 대상 bl이 있는지 확인 한다.
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String retVal
	 * @throws EventException
	 */
	public String searchBLGeneralBasic(ManifestTransmitVO[] manifestTransmitVOs) throws EventException {
		List<TaiwanSearchBlGeneralVO> taiwanSearchBlGeneralVOs = null;
		String retVal = "";
		
		try {
			taiwanSearchBlGeneralVOs = dbDao.searchBlGeneral((TaiwanManifestTransmitVO) manifestTransmitVOs[0]);
			
			if(taiwanSearchBlGeneralVOs.size() > 0) {
				retVal = "NOT EMPTY";
			} else {
				retVal = "EMPTY";
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return retVal;
	}

}