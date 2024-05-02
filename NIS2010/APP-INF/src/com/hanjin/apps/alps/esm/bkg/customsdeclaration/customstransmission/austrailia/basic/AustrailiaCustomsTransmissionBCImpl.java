/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AustrailiaCustomsTransmissionBCImpl.java
 *@FileTitle : AustrailiaCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.07
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.04.21 임재택
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration.AusCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlCharegeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlChargeTotalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlGeneralForMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlGeneralForPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchBlVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchContainerDangerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchContainerDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchContainerForMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchContainerForPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchEstimateDtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchMakeHeaderMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchMakeHeaderPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchVesselForMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchVesselForPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AusSearchVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AustrailiaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DeclBaseInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DgEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DgSendDtlHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DgSendHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.EqInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.ItemInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusVslInfoVO;
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
public class AustrailiaCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl { 
    
	// Database Access Object
	private transient AusCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public AustrailiaCustomsTransmissionBCImpl() {
		dbDao = new AusCustomsTransmissionDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsTransmission화면에 대한 조회 이벤트 처리<br>
	 * FlatFile 생성
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVO) throws EventException {
		StringBuffer flatFile = new StringBuffer();

		AustrailiaManifestTransmitVO austrailiaManifestTransmitVO = new AustrailiaManifestTransmitVO();
		austrailiaManifestTransmitVO = (AustrailiaManifestTransmitVO) manifestTransmitVO[0];
		List<AusSearchMakeHeaderMVO> ausSearchMakeHeaderMVO = null;
		List<AusSearchMakeHeaderPVO> ausSearchMakeHeaderPVO = null;
		List<AusSearchVvdVO> ausSearchVvdVO = null;
		List<AusSearchVesselForMVO> ausSearchVesselForMVO = null;
		List<AusSearchVesselForPVO> ausSearchVesselForPVO = null;
		List<AusSearchBlGeneralForMVO> ausSearchBlGeneralForMVO = null;
		List<AusSearchBlGeneralForPVO> ausSearchBlGeneralForPVO = null;
		List<AusSearchEstimateDtVO> ausSearchEstimateDtVO = null;
		List<AusSearchBlCharegeVO> ausSearchBlCharegeVO = null;
		List<AusSearchBlChargeTotalVO> ausSearchBlChargeTotalVO = null;
		List<AusSearchBlMarkDescVO> ausSearchBlMarkDescVO = null;
		List<AusSearchContainerForMVO> ausSearchContainerForMVO = null;
		List<AusSearchContainerForPVO> ausSearchContainerForPVO = null;
		List<AusSearchContainerDangerVO> ausSearchContainerDangerVO = null;
		List<AusSearchContainerDescVO> ausSearchContainerDescVO = null;
		List<AusSearchBlQtyVO> ausSearchBlQtyVO = null;
		List<AusSearchBlVvdVO> ausSearchBlVvdVO = null;
		try {

			if (manifestTransmitVO != null) {
				// 호주세관,항만청으로 전송
				if (austrailiaManifestTransmitVO.getTransGubun().equalsIgnoreCase("A")) {
					ausSearchMakeHeaderMVO = dbDao.searchMakerHeaderM();
					flatFile.append(ausSearchMakeHeaderMVO.get(0).getMsgHeader()).append("\n");
					// 호주세관으로 전송할 Vessel 정보를 조회한다.
					ausSearchVesselForMVO = dbDao.searchVesselForM(austrailiaManifestTransmitVO);
					if (ausSearchVesselForMVO != null && ausSearchVesselForMVO.size() > 0) {
						flatFile.append("VVD:").append(ausSearchVesselForMVO.get(0).getVvdNumber()).append("\n");
					}
					// 호주세관 및 항만청으로 전송할 Vessel VVD 정보를 조회한다.
					ausSearchVvdVO = dbDao.searchVvd(austrailiaManifestTransmitVO);
					if (ausSearchVvdVO != null && ausSearchVvdVO.size() > 0) {
						flatFile.append("VSL_CALLSIGN:").append(ausSearchVvdVO.get(0).getVslCallsign()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(ausSearchVvdVO.get(0).getVslLloydcode()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(ausSearchVvdVO.get(0).getVslFullname()).append("\n");
						flatFile.append("MSG_FUNC:").append(ausSearchVvdVO.get(0).getMsgFunc()).append("\n");
					}
					// 호주세관 및 항만청으로 전송할 Vessel Estimated Date 정보를 조회한다.
					ausSearchEstimateDtVO = dbDao.searchEstimateDt(austrailiaManifestTransmitVO);
					if (ausSearchEstimateDtVO != null && ausSearchEstimateDtVO.size() > 0) {
						flatFile.append("ETA:").append(ausSearchEstimateDtVO.get(0).getEta()).append("\n");
						flatFile.append("ETD:").append(ausSearchEstimateDtVO.get(0).getEtd()).append("\n");
					}
					// 호주세관으로 전송할 Manifest B/L General 정보를 조회한다.
					ausSearchBlGeneralForMVO = dbDao.searchBlGeneralForM(austrailiaManifestTransmitVO);
					if (ausSearchBlGeneralForMVO != null && ausSearchBlGeneralForMVO.size() > 0) {

						for (int i = 0; i < ausSearchBlGeneralForMVO.size(); i++) {
							flatFile.append("{BL_INFO").append("\n");
							austrailiaManifestTransmitVO.setBkgCgoTp(ausSearchBlGeneralForMVO.get(i).getBkgCgoTpCd());
							austrailiaManifestTransmitVO.setBkgSpeRf(ausSearchBlGeneralForMVO.get(i).getBkgSpeRf());
							austrailiaManifestTransmitVO.setBkgSpeDg(ausSearchBlGeneralForMVO.get(i).getBkgSpeDg());
							austrailiaManifestTransmitVO.setBkgSpeAk(ausSearchBlGeneralForMVO.get(i).getBkgSpeAk());
							austrailiaManifestTransmitVO.setBkgSpeBb(ausSearchBlGeneralForMVO.get(i).getBkgSpeBb());
							austrailiaManifestTransmitVO.setCmdtDesc(ausSearchBlGeneralForMVO.get(i).getCmdtDesc());
							austrailiaManifestTransmitVO.setCmdtCd(ausSearchBlGeneralForMVO.get(i).getCmdtCd());
							austrailiaManifestTransmitVO.setBkgSpeRd(ausSearchBlGeneralForMVO.get(i).getBkgSpeRd());

							flatFile.append("BLNBR:").append(ausSearchBlGeneralForMVO.get(i).getBlnbr()).append("\n");
							flatFile.append("BKGNBR:").append(ausSearchBlGeneralForMVO.get(i).getBkgnbr()).append("\n");
							flatFile.append("BLPOL:").append(ausSearchBlGeneralForMVO.get(i).getBlpol()).append("\n");
							flatFile.append("BLPOD:").append(ausSearchBlGeneralForMVO.get(i).getBlpod()).append("\n");
							flatFile.append("BLPOR:").append(ausSearchBlGeneralForMVO.get(i).getBlpor()).append("\n");
							flatFile.append("BLDEL:").append(ausSearchBlGeneralForMVO.get(i).getBldel()).append("\n");
							flatFile.append("BLRLY:").append(ausSearchBlGeneralForMVO.get(i).getBlrly()).append("\n");
							flatFile.append("BLPLACE:").append(ausSearchBlGeneralForMVO.get(i).getBlplace()).append(
									"\n");
							flatFile.append("BLDATE:").append(ausSearchBlGeneralForMVO.get(i).getBldate()).append("\n");
							flatFile.append("CUST_CD:").append(ausSearchBlGeneralForMVO.get(i).getCustCd())
									.append("\n");
							flatFile.append("SHPR1:").append(ausSearchBlGeneralForMVO.get(i).getShpr1()).append("\n");
							flatFile.append("SHPR2:").append(ausSearchBlGeneralForMVO.get(i).getShpr2()).append("\n");
							flatFile.append("SHPR3:").append(ausSearchBlGeneralForMVO.get(i).getShpr3()).append("\n");
							flatFile.append("SHPR4:").append(ausSearchBlGeneralForMVO.get(i).getShpr4()).append("\n");
							flatFile.append("SHPR5:").append(ausSearchBlGeneralForMVO.get(i).getShpr5()).append("\n");
							flatFile.append("CNEE1:").append(ausSearchBlGeneralForMVO.get(i).getCnee1()).append("\n");
							flatFile.append("CNEE2:").append(ausSearchBlGeneralForMVO.get(i).getCnee2()).append("\n");
							flatFile.append("CNEE3:").append(ausSearchBlGeneralForMVO.get(i).getCnee3()).append("\n");
							flatFile.append("CNEE4:").append(ausSearchBlGeneralForMVO.get(i).getCnee4()).append("\n");
							flatFile.append("CNEE5:").append(ausSearchBlGeneralForMVO.get(i).getCnee5()).append("\n");
							flatFile.append("NTFY1:").append(ausSearchBlGeneralForMVO.get(i).getNtfy1()).append("\n");
							flatFile.append("NTFY2:").append(ausSearchBlGeneralForMVO.get(i).getNtfy2()).append("\n");
							flatFile.append("NTFY3:").append(ausSearchBlGeneralForMVO.get(i).getNtfy3()).append("\n");
							flatFile.append("NTFY4:").append(ausSearchBlGeneralForMVO.get(i).getNtfy4()).append("\n");
							flatFile.append("NTFY5:").append(ausSearchBlGeneralForMVO.get(i).getNtfy5()).append("\n");
							flatFile.append("NTFY21:").append(ausSearchBlGeneralForMVO.get(i).getNtfy21()).append("\n");
							flatFile.append("NTFY22:").append(ausSearchBlGeneralForMVO.get(i).getNtfy22()).append("\n");
							flatFile.append("NTFY23:").append(ausSearchBlGeneralForMVO.get(i).getNtfy23()).append("\n");
							flatFile.append("NTFY24:").append(ausSearchBlGeneralForMVO.get(i).getNtfy24()).append("\n");
							flatFile.append("NTFY25:").append(ausSearchBlGeneralForMVO.get(i).getNtfy25()).append("\n");
							flatFile.append("FFWD1:").append(ausSearchBlGeneralForMVO.get(i).getFfwd1()).append("\n");
							flatFile.append("FFWD2:").append(ausSearchBlGeneralForMVO.get(i).getFfwd2()).append("\n");
							flatFile.append("FFWD3:").append(ausSearchBlGeneralForMVO.get(i).getFfwd3()).append("\n");
							flatFile.append("FFWD4:").append(ausSearchBlGeneralForMVO.get(i).getFfwd4()).append("\n");
							flatFile.append("FFWD5:").append(ausSearchBlGeneralForMVO.get(i).getFfwd5()).append("\n");
							flatFile.append("EXPO1:").append(ausSearchBlGeneralForMVO.get(i).getExpo1()).append("\n");
							flatFile.append("EXPO2:").append(ausSearchBlGeneralForMVO.get(i).getExpo2()).append("\n");
							flatFile.append("EXPO3:").append(ausSearchBlGeneralForMVO.get(i).getExpo3()).append("\n");
							flatFile.append("EXPO4:").append(ausSearchBlGeneralForMVO.get(i).getExpo4()).append("\n");
							flatFile.append("EXPO5:").append(ausSearchBlGeneralForMVO.get(i).getExpo5()).append("\n");
							flatFile.append("BLCOPY:").append(ausSearchBlGeneralForMVO.get(i).getBlcopy()).append("\n");
							flatFile.append("BLORG:").append(ausSearchBlGeneralForMVO.get(i).getBlorg()).append("\n");
							flatFile.append("BLPKG:").append(ausSearchBlGeneralForMVO.get(i).getBlpkg()).append("\n");
							flatFile.append("BLPKGU:").append(ausSearchBlGeneralForMVO.get(i).getBlpkgu()).append("\n");
							flatFile.append("BLWGT:").append(ausSearchBlGeneralForMVO.get(i).getBlwgt()).append("\n");
							flatFile.append("BLMEA:").append(ausSearchBlGeneralForMVO.get(i).getBlmea()).append("\n");
							flatFile.append("RDTYPE:").append(ausSearchBlGeneralForMVO.get(i).getRdtype()).append("\n");
							flatFile.append("CARGOTYPE:").append(ausSearchBlGeneralForMVO.get(i).getCargotype())
									.append("\n");
							flatFile.append("COMMODITY:").append(ausSearchBlGeneralForMVO.get(i).getCommodity())
									.append("\n");
							flatFile.append("REMARK:").append(ausSearchBlGeneralForMVO.get(i).getXterRmk())
									.append("\n");
							flatFile.append("AUS_QUAR:").append(ausSearchBlGeneralForMVO.get(i).getAusQuar()).append(
									"\n");
							flatFile.append("FRT_IND:").append(ausSearchBlGeneralForMVO.get(i).getFrtInd())
									.append("\n");
							flatFile.append("CUSTOMS_DESC:").append(ausSearchBlGeneralForMVO.get(i).getCstmsDesc())
									.append("\n");
							flatFile.append("E_I_IND:").append(ausSearchBlGeneralForMVO.get(i).getEiInd())
									.append("\n");
							austrailiaManifestTransmitVO.setBkgNo(ausSearchBlGeneralForMVO.get(i).getBkgNo());
							ausSearchBlCharegeVO = dbDao.searchBlCharge(austrailiaManifestTransmitVO);
							// 호주세관 및 항만청으로 전송할 Manifest B/L Charge 정보를 조회한다.
							if (ausSearchBlCharegeVO != null) {
								for (int j = 0; j < ausSearchBlCharegeVO.size(); j++) {
									flatFile.append("{CHARGE").append("\n");
									flatFile.append("FCTYPE:").append(ausSearchBlCharegeVO.get(j).getFctype()).append(
											"\n");
									flatFile.append("RATE:").append(ausSearchBlCharegeVO.get(j).getRate()).append("\n");
									flatFile.append("REVENUETON:").append(ausSearchBlCharegeVO.get(j).getRevenueton())
											.append("\n");
									flatFile.append("PPD:").append(ausSearchBlCharegeVO.get(j).getPpd()).append("\n");
									flatFile.append("CCT:").append(ausSearchBlCharegeVO.get(j).getCct()).append("\n");
									flatFile.append("CURRENCYCODE:").append(
											ausSearchBlCharegeVO.get(j).getCurrencycode()).append("\n");
									flatFile.append("TARIFF:").append(ausSearchBlCharegeVO.get(j).getTariff()).append(
											"\n");
									flatFile.append("PERTYPE:").append(ausSearchBlCharegeVO.get(j).getPertype())
											.append("\n");
									flatFile.append("}CHARGE").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Charge Total 정보를 조회한다.
							ausSearchBlChargeTotalVO = dbDao.searchBlChargeTotal(austrailiaManifestTransmitVO);
							if (ausSearchBlChargeTotalVO != null) {
								for (int j = 0; j < ausSearchBlChargeTotalVO.size(); j++) {
									flatFile.append("{CHARGE_TTL").append("\n");
									flatFile.append("PPD_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getPpdTotal())
											.append("\n");
									flatFile.append("CCT_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getCctTotal())
											.append("\n");
									flatFile.append("TOTAL_CUR:").append(ausSearchBlChargeTotalVO.get(j).getTotalCur())
											.append("\n");
									flatFile.append("}CHARGE_TTL").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Mark Description 정보를 조회한다.
							ausSearchBlMarkDescVO = dbDao.searchBlMarksDesc(austrailiaManifestTransmitVO);
							if (ausSearchBlMarkDescVO != null) {
								for (int j = 0; j < ausSearchBlMarkDescVO.size(); j++) {
									StringTokenizer token = new StringTokenizer(ausSearchBlMarkDescVO.get(j)
											.getCmdtDesc(), "\n");
									ArrayList tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{DESC").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("DESC:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}DESC").append("\n");
									token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getMkDesc(), "\n");
									tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{MARK").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("MARKNO:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}MARK").append("\n");
								}
							}
							// 호주세관으로 전송할 Manifest Container 정보를 조회한다.
							ausSearchContainerForMVO = dbDao.searchContainerForM(austrailiaManifestTransmitVO);
							if (ausSearchContainerForMVO != null) {
								for (int k = 0; k < ausSearchContainerForMVO.size(); k++) {
									flatFile.append("{CNTR_INFO").append("\n");
									austrailiaManifestTransmitVO.setCntrNo(ausSearchContainerForMVO.get(k).getCntrNo());
									flatFile.append("CNTRNBR:").append(ausSearchContainerForMVO.get(k).getCntrnbr())
											.append("\n");
									flatFile.append("PUNIT:").append(ausSearchContainerForMVO.get(k).getPunit())
											.append("\n");
									flatFile.append("PKG:").append(ausSearchContainerForMVO.get(k).getPkg()).append(
											"\n");
									flatFile.append("CNTRWGT:").append(ausSearchContainerForMVO.get(k).getCntrwgt())
											.append("\n");
									flatFile.append("CNTRTYPE:").append(ausSearchContainerForMVO.get(k).getCntrtype())
											.append("\n");
									flatFile.append("SEALNBR:").append(ausSearchContainerForMVO.get(k).getSealnbr())
											.append("\n");
									flatFile.append("SOC_IND:").append(ausSearchContainerForMVO.get(k).getSocInd())
											.append("\n");
									flatFile.append("FM_IND:").append(ausSearchContainerForMVO.get(k).getFmInd())
											.append("\n");
									flatFile.append("RF_IND:").append(ausSearchContainerForMVO.get(k).getRfInd())
											.append("\n");
									flatFile.append("DG_IND:").append(ausSearchContainerForMVO.get(k).getDgInd())
											.append("\n");
									flatFile.append("AK_IND:").append(ausSearchContainerForMVO.get(k).getAkInd())
											.append("\n");
									flatFile.append("BK_IND:").append(ausSearchContainerForMVO.get(k).getBkInd())
											.append("\n");
									flatFile.append("TEMP:").append(ausSearchContainerForMVO.get(k).getTemp()).append(
											"\n");
									flatFile.append("TUNIT:").append(ausSearchContainerForMVO.get(k).getTunit())
											.append("\n");
									flatFile.append("HUMIDITY:").append(ausSearchContainerForMVO.get(k).getHumidity())
											.append("\n");
									flatFile.append("VENT:").append(ausSearchContainerForMVO.get(k).getVent()).append(
											"\n");
									flatFile.append("MEASURE:").append(ausSearchContainerForMVO.get(k).getMeasure())
											.append("\n");
									flatFile.append("RDTYPE:").append(ausSearchContainerForMVO.get(k).getRdtype())
											.append("\n");
									flatFile.append("CMDT_DESC:").append(ausSearchContainerForMVO.get(k).getCmdtDesc())
											.append("\n");
									flatFile.append("CMDTCD:").append(ausSearchContainerForMVO.get(k).getCmdtcd())
											.append("\n");
									flatFile.append("RF_REMARK:").append(ausSearchContainerForMVO.get(k).getRfRemark())
											.append("\n");
									flatFile.append("RFDRY_IND:").append(ausSearchContainerForMVO.get(k).getRfdryInd())
											.append("\n");
									flatFile.append("OVF:").append(ausSearchContainerForMVO.get(k).getOvf()).append(
											"\n");
									flatFile.append("OVR:").append(ausSearchContainerForMVO.get(k).getOvr()).append(
											"\n");
									flatFile.append("OVH:").append(ausSearchContainerForMVO.get(k).getOvh()).append(
											"\n");
									flatFile.append("OVLW:").append(ausSearchContainerForMVO.get(k).getOvlw()).append(
											"\n");
									flatFile.append("OVRW:").append(ausSearchContainerForMVO.get(k).getOvrw()).append(
											"\n");
									flatFile.append("OVWGT:").append(ausSearchContainerForMVO.get(k).getOvwgt())
											.append("\n");
									flatFile.append("VOID_SLOT:").append(ausSearchContainerForMVO.get(k).getVoidSlot())
											.append("\n");
									flatFile.append("STWG_REQ:").append(ausSearchContainerForMVO.get(k).getStwgReq())
											.append("\n");
									flatFile.append("CNTR_E_I_IND:").append(ausSearchBlGeneralForMVO.get(i).getEiInd())
									.append("\n");
									// 호주세관 및 항만청으로 전송할 Manifest Container Danger 정보를 조회한다.
									ausSearchContainerDangerVO = dbDao
											.searchContainerDanger(austrailiaManifestTransmitVO);
									if (ausSearchContainerDangerVO != null) {
										for (int kk = 0; kk < ausSearchContainerDangerVO.size(); kk++) {
											flatFile.append("{CNTR_DANGER").append("\n");
											flatFile.append("UNNBR:").append(
													ausSearchContainerDangerVO.get(kk).getUnnbr()).append("\n");
											flatFile.append("CLASS:").append(
													ausSearchContainerDangerVO.get(kk).getImdgClass()).append("\n");
											flatFile.append("DESC:").append(
													ausSearchContainerDangerVO.get(kk).getShpNm()).append("\n");
											flatFile.append("PHONE:").append(
													ausSearchContainerDangerVO.get(kk).getPhone()).append("\n");
											flatFile.append("PAGE:").append(
													ausSearchContainerDangerVO.get(kk).getPageList()).append("\n");
											flatFile.append("FLSH_TEMP:").append(
													ausSearchContainerDangerVO.get(kk).getFlshTemp()).append("\n");
											flatFile.append("FLSH_UNIT:").append(
													ausSearchContainerDangerVO.get(kk).getFlshUnit()).append("\n");
											flatFile.append("DG_REMARK:").append(
													ausSearchContainerDangerVO.get(kk).getDgRemark()).append("\n");
											flatFile.append("}CNTR_DANGER").append("\n");
										}
									}
									// 호주세관 및 항만청으로 전송할 Manifest Container Description 정보를 조회한다.
									ausSearchContainerDescVO = dbDao.searchContainerDesc(austrailiaManifestTransmitVO);
									if (ausSearchContainerDescVO != null) {
										for (int kk = 0; kk < ausSearchContainerDescVO.size(); kk++) {
											flatFile.append("{CNTR_DESC").append("\n");
											flatFile.append("D_CMDT:").append(
													ausSearchContainerDescVO.get(kk).getDCmdt()).append("\n");
											flatFile.append("D_PUNIT:").append(
													ausSearchContainerDescVO.get(kk).getDPunit()).append("\n");
											flatFile.append("D_PKG:")
													.append(ausSearchContainerDescVO.get(kk).getDPkg()).append("\n");
											flatFile.append("D_WGT:")
													.append(ausSearchContainerDescVO.get(kk).getDWgt()).append("\n");
											flatFile.append("D_MEAS:").append(
													ausSearchContainerDescVO.get(kk).getDMeas()).append("\n");
											flatFile.append("D_DESC:").append(
													ausSearchContainerDescVO.get(kk).getDDesc()).append("\n");
											StringTokenizer token = new StringTokenizer(ausSearchContainerDescVO
													.get(kk).getDMark(), "\n");
											ArrayList tmpArray = new ArrayList();
											while (token.hasMoreTokens()) {
												tmpArray.add(token.nextToken());
											}
											if (tmpArray.size() > 0)
												flatFile.append("{CUS_MARK").append("\n");
											for (int mm = 0; mm < tmpArray.size(); mm++) {
												flatFile.append("D_MARK:").append(tmpArray.get(mm).toString());
												flatFile.append("\n");
											}
											if (tmpArray.size() > 0)
												flatFile.append("}CUS_MARK").append("\n");
											flatFile.append("}CNTR_DESC").append("\n");
										}
									}
									flatFile.append("}CNTR_INFO").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Qty 정보를 조회한다.
							ausSearchBlQtyVO = dbDao.searchBlQty(austrailiaManifestTransmitVO);
							if (ausSearchBlQtyVO != null) {
								for (int m = 0; m < ausSearchBlQtyVO.size(); m++) {
									flatFile.append("{QTY").append("\n");
									flatFile.append("HANTYPE:").append(ausSearchBlQtyVO.get(m).getHantype()).append(
											"\n");
									flatFile.append("COUNT:").append(ausSearchBlQtyVO.get(m).getCntrQty()).append("\n");
									flatFile.append("}QTY").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L VVD 정보를 조회한다.
							ausSearchBlVvdVO = dbDao.searchBlVvd(austrailiaManifestTransmitVO);
							if (ausSearchBlVvdVO != null) {
								for (int m = 0; m < ausSearchBlVvdVO.size(); m++) {
									flatFile.append("{BKGVVD").append("\n");
									flatFile.append("BVVD:").append(ausSearchBlVvdVO.get(m).getBvvd()).append("\n");
									flatFile.append("BPOL:").append(ausSearchBlVvdVO.get(m).getBpol()).append("\n");
									flatFile.append("BPOD:").append(ausSearchBlVvdVO.get(m).getBpod()).append("\n");
									flatFile.append("}BKGVVD").append("\n");
								}
							}
							flatFile.append("}BL_INFO").append("\n");
						}
					}

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_AUSMF.IBMMQ.QUEUE"));

					BookingUtil command = new BookingUtil();
					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00220", new String[] {}).getMessage());

					// 항만청으로 전송
					flatFile = new StringBuffer();
					ausSearchMakeHeaderPVO = dbDao.searchMakerHeaderP(austrailiaManifestTransmitVO);
					flatFile.append(ausSearchMakeHeaderPVO.get(0).getMsgHeader()).append("\n");
					// 호주항만청으로 전송할 Vessel 정보를 조회한다.
					ausSearchVesselForPVO = dbDao.searchVesselForP(austrailiaManifestTransmitVO);
					if (ausSearchVesselForPVO != null && ausSearchVesselForPVO.size() > 0) {
						flatFile.append("VVD:").append(ausSearchVesselForPVO.get(0).getVvdNumber()).append("\n");
					}
					// 호주세관 및 항만청으로 전송할 Vessel VVD 정보를 조회한다.
					ausSearchVvdVO = dbDao.searchVvd(austrailiaManifestTransmitVO);
					if (ausSearchVvdVO != null && ausSearchVvdVO.size() > 0) {
						flatFile.append("VSL_CALLSIGN:").append(ausSearchVvdVO.get(0).getVslCallsign()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(ausSearchVvdVO.get(0).getVslLloydcode()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(ausSearchVvdVO.get(0).getVslFullname()).append("\n");
						flatFile.append("MSG_FUNC:").append(ausSearchVvdVO.get(0).getMsgFunc()).append("\n");
					}
					// 호주세관 및 항만청으로 전송할 Vessel Estimated Date 정보를 조회한다.
					ausSearchEstimateDtVO = dbDao.searchEstimateDt(austrailiaManifestTransmitVO);
					if (ausSearchEstimateDtVO != null && ausSearchEstimateDtVO.size() > 0) {
						flatFile.append("ETA:").append(ausSearchEstimateDtVO.get(0).getEta()).append("\n");
						flatFile.append("ETD:").append(ausSearchEstimateDtVO.get(0).getEtd()).append("\n");
					}
					// 호주항만청으로 전송할 Manifest B/L General 정보를 조회한다.
					ausSearchBlGeneralForPVO = dbDao.searchBlGeneralForP(austrailiaManifestTransmitVO);
					if (ausSearchBlGeneralForPVO != null && ausSearchBlGeneralForPVO.size() > 0) {

						for (int i = 0; i < ausSearchBlGeneralForPVO.size(); i++) {
							flatFile.append("{BL_INFO").append("\n");
							austrailiaManifestTransmitVO.setBkgCgoTp(ausSearchBlGeneralForPVO.get(i).getBkgCgoTpCd());
							austrailiaManifestTransmitVO.setBkgSpeRf(ausSearchBlGeneralForPVO.get(i).getBkgSpeRf());
							austrailiaManifestTransmitVO.setBkgSpeDg(ausSearchBlGeneralForPVO.get(i).getBkgSpeDg());
							austrailiaManifestTransmitVO.setBkgSpeAk(ausSearchBlGeneralForPVO.get(i).getBkgSpeAk());
							austrailiaManifestTransmitVO.setBkgSpeBb(ausSearchBlGeneralForPVO.get(i).getBkgSpeBb());
							austrailiaManifestTransmitVO.setCmdtDesc(ausSearchBlGeneralForPVO.get(i).getCmdtDesc());
							austrailiaManifestTransmitVO.setCmdtCd(ausSearchBlGeneralForPVO.get(i).getCmdtCd());
							austrailiaManifestTransmitVO.setBkgSpeRd(ausSearchBlGeneralForPVO.get(i).getBkgSpeRd());

							flatFile.append("BLNBR:").append(ausSearchBlGeneralForPVO.get(i).getBlnbr()).append("\n");
							// flatFile.append("BKGNBR:").append(ausSearchBlGeneralForPVO.get(i).getBkgnbr()).append("\n");
							flatFile.append("BLPOL:").append(ausSearchBlGeneralForPVO.get(i).getBlpol()).append("\n");
							flatFile.append("BLPOD:").append(ausSearchBlGeneralForPVO.get(i).getBlpod()).append("\n");
							flatFile.append("BLPOR:").append(ausSearchBlGeneralForPVO.get(i).getBlpor()).append("\n");
							flatFile.append("BLDEL:").append(ausSearchBlGeneralForPVO.get(i).getBldel()).append("\n");
							flatFile.append("BLRLY:").append(ausSearchBlGeneralForPVO.get(i).getBlrly()).append("\n");
							flatFile.append("BLPLACE:").append(ausSearchBlGeneralForPVO.get(i).getBlplace()).append(
									"\n");
							flatFile.append("BLDATE:").append(ausSearchBlGeneralForPVO.get(i).getBldate()).append("\n");
							flatFile.append("CUST_CD:").append(ausSearchBlGeneralForPVO.get(i).getCustCd())
									.append("\n");
							flatFile.append("SHPR1:").append(ausSearchBlGeneralForPVO.get(i).getShpr1()).append("\n");
							flatFile.append("SHPR2:").append(ausSearchBlGeneralForPVO.get(i).getShpr2()).append("\n");
							flatFile.append("SHPR3:").append(ausSearchBlGeneralForPVO.get(i).getShpr3()).append("\n");
							flatFile.append("SHPR4:").append(ausSearchBlGeneralForPVO.get(i).getShpr4()).append("\n");
							flatFile.append("SHPR5:").append(ausSearchBlGeneralForPVO.get(i).getShpr5()).append("\n");
							flatFile.append("CNEE1:").append(ausSearchBlGeneralForPVO.get(i).getCnee1()).append("\n");
							flatFile.append("CNEE2:").append(ausSearchBlGeneralForPVO.get(i).getCnee2()).append("\n");
							flatFile.append("CNEE3:").append(ausSearchBlGeneralForPVO.get(i).getCnee3()).append("\n");
							flatFile.append("CNEE4:").append(ausSearchBlGeneralForPVO.get(i).getCnee4()).append("\n");
							flatFile.append("CNEE5:").append(ausSearchBlGeneralForPVO.get(i).getCnee5()).append("\n");
							flatFile.append("NTFY1:").append(ausSearchBlGeneralForPVO.get(i).getNtfy1()).append("\n");
							flatFile.append("NTFY2:").append(ausSearchBlGeneralForPVO.get(i).getNtfy2()).append("\n");
							flatFile.append("NTFY3:").append(ausSearchBlGeneralForPVO.get(i).getNtfy3()).append("\n");
							flatFile.append("NTFY4:").append(ausSearchBlGeneralForPVO.get(i).getNtfy4()).append("\n");
							flatFile.append("NTFY5:").append(ausSearchBlGeneralForPVO.get(i).getNtfy5()).append("\n");
							flatFile.append("NTFY21:").append(ausSearchBlGeneralForPVO.get(i).getNtfy21()).append("\n");
							flatFile.append("NTFY22:").append(ausSearchBlGeneralForPVO.get(i).getNtfy22()).append("\n");
							flatFile.append("NTFY23:").append(ausSearchBlGeneralForPVO.get(i).getNtfy23()).append("\n");
							flatFile.append("NTFY24:").append(ausSearchBlGeneralForPVO.get(i).getNtfy24()).append("\n");
							flatFile.append("NTFY25:").append(ausSearchBlGeneralForPVO.get(i).getNtfy25()).append("\n");
							flatFile.append("FFWD1:").append(ausSearchBlGeneralForPVO.get(i).getFfwd1()).append("\n");
							flatFile.append("FFWD2:").append(ausSearchBlGeneralForPVO.get(i).getFfwd2()).append("\n");
							flatFile.append("FFWD3:").append(ausSearchBlGeneralForPVO.get(i).getFfwd3()).append("\n");
							flatFile.append("FFWD4:").append(ausSearchBlGeneralForPVO.get(i).getFfwd4()).append("\n");
							flatFile.append("FFWD5:").append(ausSearchBlGeneralForPVO.get(i).getFfwd5()).append("\n");
							flatFile.append("EXPO1:").append(ausSearchBlGeneralForPVO.get(i).getExpo1()).append("\n");
							flatFile.append("EXPO2:").append(ausSearchBlGeneralForPVO.get(i).getExpo2()).append("\n");
							flatFile.append("EXPO3:").append(ausSearchBlGeneralForPVO.get(i).getExpo3()).append("\n");
							flatFile.append("EXPO4:").append(ausSearchBlGeneralForPVO.get(i).getExpo4()).append("\n");
							flatFile.append("EXPO5:").append(ausSearchBlGeneralForPVO.get(i).getExpo5()).append("\n");
							flatFile.append("BLCOPY:").append(ausSearchBlGeneralForPVO.get(i).getBlcopy()).append("\n");
							flatFile.append("BLORG:").append(ausSearchBlGeneralForPVO.get(i).getBlorg()).append("\n");
							flatFile.append("BLPKG:").append(ausSearchBlGeneralForPVO.get(i).getBlpkg()).append("\n");
							flatFile.append("BLPKGU:").append(ausSearchBlGeneralForPVO.get(i).getBlpkgu()).append("\n");
							flatFile.append("BLWGT:").append(ausSearchBlGeneralForPVO.get(i).getBlwgt()).append("\n");
							flatFile.append("BLMEA:").append(ausSearchBlGeneralForPVO.get(i).getBlmea()).append("\n");
							flatFile.append("RDTYPE:").append(ausSearchBlGeneralForPVO.get(i).getRdtype()).append("\n");
							flatFile.append("CARGOTYPE:").append(ausSearchBlGeneralForPVO.get(i).getCargotype())
									.append("\n");
							flatFile.append("COMMODITY:").append(ausSearchBlGeneralForPVO.get(i).getCommodity())
									.append("\n");
							flatFile.append("REMARK:").append(ausSearchBlGeneralForPVO.get(i).getXterRmk())
									.append("\n");
							flatFile.append("AUS_QUAR:").append(ausSearchBlGeneralForPVO.get(i).getAusQuar()).append(
									"\n");
							// flatFile.append("FRT_IND:").append(ausSearchBlGeneralForPVO.get(i).getFrtInd()).append("\n");
							// flatFile.append("CUSTOMS_DESC:").append(ausSearchBlGeneralForPVO.get(i).getCmdtDesc()).append("\n");
							flatFile.append("E_I_IND:").append(ausSearchBlGeneralForPVO.get(i).getEiInd()).append("\n");  
							austrailiaManifestTransmitVO.setBkgNo(ausSearchBlGeneralForPVO.get(i).getBkgNo());
							ausSearchBlCharegeVO = dbDao.searchBlCharge(austrailiaManifestTransmitVO);
							// 호주세관 및 항만청으로 전송할 Manifest B/L Charge 정보를 조회한다.
							if (ausSearchBlCharegeVO != null) {
								for (int j = 0; j < ausSearchBlCharegeVO.size(); j++) {
									flatFile.append("{CHARGE").append("\n");
									flatFile.append("FCTYPE:").append(ausSearchBlCharegeVO.get(j).getFctype()).append(
											"\n");
									flatFile.append("RATE:").append(ausSearchBlCharegeVO.get(j).getRate()).append("\n");
									flatFile.append("REVENUETON:").append(ausSearchBlCharegeVO.get(j).getRevenueton())
											.append("\n");
									flatFile.append("PPD:").append(ausSearchBlCharegeVO.get(j).getPpd()).append("\n");
									flatFile.append("CCT:").append(ausSearchBlCharegeVO.get(j).getCct()).append("\n");
									flatFile.append("CURRENCYCODE:").append(
											ausSearchBlCharegeVO.get(j).getCurrencycode()).append("\n");
									flatFile.append("TARIFF:").append(ausSearchBlCharegeVO.get(j).getTariff()).append(
											"\n");
									flatFile.append("PERTYPE:").append(ausSearchBlCharegeVO.get(j).getPertype())
											.append("\n");
									flatFile.append("}CHARGE").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Charge Total 정보를 조회한다.
							ausSearchBlChargeTotalVO = dbDao.searchBlChargeTotal(austrailiaManifestTransmitVO);
							if (ausSearchBlChargeTotalVO != null) {
								for (int j = 0; j < ausSearchBlChargeTotalVO.size(); j++) {
									flatFile.append("{CHARGE_TTL").append("\n");
									flatFile.append("PPD_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getPpdTotal())
											.append("\n");
									flatFile.append("CCT_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getCctTotal())
											.append("\n");
									flatFile.append("TOTAL_CUR:").append(ausSearchBlChargeTotalVO.get(j).getTotalCur())
											.append("\n");
									flatFile.append("}CHARGE_TTL").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Mark Description 정보를 조회한다.
							ausSearchBlMarkDescVO = dbDao.searchBlMarksDesc(austrailiaManifestTransmitVO);
							if (ausSearchBlMarkDescVO != null) {
								for (int j = 0; j < ausSearchBlMarkDescVO.size(); j++) {
									StringTokenizer token = new StringTokenizer(ausSearchBlMarkDescVO.get(j)
											.getCmdtDesc(), "\n");
									ArrayList tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{DESC").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("DESC:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}DESC").append("\n");
									token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getMkDesc(), "\n");
									tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{MARK").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("MARKNO:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}MARK").append("\n");
								}
							}
							// 호주항만청으로 전송할 Manifest Container 정보를 조회한다.
							ausSearchContainerForPVO = dbDao.searchContainerForP(austrailiaManifestTransmitVO);
							if (ausSearchContainerForPVO != null) {
								for (int k = 0; k < ausSearchContainerForPVO.size(); k++) {
									flatFile.append("{CNTR_INFO").append("\n");
									austrailiaManifestTransmitVO.setCntrNo(ausSearchContainerForPVO.get(k).getCntrNo());
									flatFile.append("CNTRNBR:").append(ausSearchContainerForPVO.get(k).getCntrnbr())
											.append("\n");
									flatFile.append("PUNIT:").append(ausSearchContainerForPVO.get(k).getPunit())
											.append("\n");
									flatFile.append("PKG:").append(ausSearchContainerForPVO.get(k).getPkg()).append(
											"\n");
									flatFile.append("CNTRWGT:").append(ausSearchContainerForPVO.get(k).getCntrwgt())
											.append("\n");
									flatFile.append("CNTRTYPE:").append(ausSearchContainerForPVO.get(k).getCntrtype())
											.append("\n");
									flatFile.append("SEALNBR:").append(ausSearchContainerForPVO.get(k).getSealnbr())
											.append("\n");
									// flatFile.append("SOC_IND:").append(ausSearchContainerForPVO.get(k).getSocInd()).append("\n");
									flatFile.append("FM_IND:").append(ausSearchContainerForPVO.get(k).getFmInd())
											.append("\n");
									flatFile.append("RF_IND:").append(ausSearchContainerForPVO.get(k).getRfInd())
											.append("\n");
									flatFile.append("DG_IND:").append(ausSearchContainerForPVO.get(k).getDgInd())
											.append("\n");
									flatFile.append("AK_IND:").append(ausSearchContainerForPVO.get(k).getAkInd())
											.append("\n");
									flatFile.append("BK_IND:").append(ausSearchContainerForPVO.get(k).getBkInd())
											.append("\n");
									flatFile.append("TEMP:").append(ausSearchContainerForPVO.get(k).getTemp()).append(
											"\n");
									flatFile.append("TUNIT:").append(ausSearchContainerForPVO.get(k).getTunit())
											.append("\n");
									// flatFile.append("HUMIDITY:").append(ausSearchContainerForPVO.get(k).getHumidity()).append("\n");
									flatFile.append("VENT:").append(ausSearchContainerForPVO.get(k).getVent()).append(
											"\n");
									flatFile.append("MEASURE:").append(ausSearchContainerForPVO.get(k).getMeasure())
											.append("\n");
									flatFile.append("RDTYPE:").append(ausSearchContainerForPVO.get(k).getRdtype())
											.append("\n");
									flatFile.append("CMDT_DESC:").append(ausSearchContainerForPVO.get(k).getCmdtDesc())
											.append("\n");
									flatFile.append("CMDTCD:").append(ausSearchContainerForPVO.get(k).getCmdtcd())
											.append("\n");
									flatFile.append("RF_REMARK:").append(ausSearchContainerForPVO.get(k).getRfRemark())
											.append("\n");
									flatFile.append("RFDRY_IND:").append(ausSearchContainerForPVO.get(k).getRfdryInd())
											.append("\n");
									flatFile.append("OVF:").append(ausSearchContainerForPVO.get(k).getOvf()).append(
											"\n");
									flatFile.append("OVR:").append(ausSearchContainerForPVO.get(k).getOvr()).append(
											"\n");
									flatFile.append("OVH:").append(ausSearchContainerForPVO.get(k).getOvh()).append(
											"\n");
									flatFile.append("OVLW:").append(ausSearchContainerForPVO.get(k).getOvlw()).append(
											"\n");
									flatFile.append("OVRW:").append(ausSearchContainerForPVO.get(k).getOvrw()).append(
											"\n");
									flatFile.append("OVWGT:").append(ausSearchContainerForPVO.get(k).getOvwgt())
											.append("\n");
									flatFile.append("VOID_SLOT:").append(ausSearchContainerForPVO.get(k).getVoidSlot())
											.append("\n");
									flatFile.append("STWG_REQ:").append(ausSearchContainerForPVO.get(k).getStwgReq())
											.append("\n");
									flatFile.append("CNTR_E_I_IND:").append(ausSearchBlGeneralForPVO.get(i).getEiInd())
											.append("\n");        

									// 호주세관 및 항만청으로 전송할 Manifest Container Danger 정보를 조회한다.
									ausSearchContainerDangerVO = dbDao
											.searchContainerDanger(austrailiaManifestTransmitVO);
									if (ausSearchContainerDangerVO != null) {
										for (int kk = 0; kk < ausSearchContainerDangerVO.size(); kk++) {
											flatFile.append("{CNTR_DANGER").append("\n");
											flatFile.append("UNNBR:").append(
													ausSearchContainerDangerVO.get(kk).getUnnbr()).append("\n");
											flatFile.append("CLASS:").append(
													ausSearchContainerDangerVO.get(kk).getImdgClass()).append("\n");
											flatFile.append("DESC:").append(
													ausSearchContainerDangerVO.get(kk).getShpNm()).append("\n");
											flatFile.append("PHONE:").append(
													ausSearchContainerDangerVO.get(kk).getPhone()).append("\n");
											flatFile.append("PAGE:").append(
													ausSearchContainerDangerVO.get(kk).getPageList()).append("\n");
											flatFile.append("FLSH_TEMP:").append(
													ausSearchContainerDangerVO.get(kk).getFlshTemp()).append("\n");
											flatFile.append("FLSH_UNIT:").append(
													ausSearchContainerDangerVO.get(kk).getFlshUnit()).append("\n");
											flatFile.append("DG_REMARK:").append(
													ausSearchContainerDangerVO.get(kk).getDgRemark()).append("\n");
											flatFile.append("}CNTR_DANGER").append("\n");
										}
									}
									// 호주세관 및 항만청으로 전송할 Manifest Container Description 정보를 조회한다.
									ausSearchContainerDescVO = dbDao.searchContainerDesc(austrailiaManifestTransmitVO);
									if (ausSearchContainerDescVO != null) {
										for (int kk = 0; kk < ausSearchContainerDescVO.size(); kk++) {
											flatFile.append("{CNTR_DESC").append("\n");
											flatFile.append("D_CMDT:").append(
													ausSearchContainerDescVO.get(kk).getDCmdt()).append("\n");
											flatFile.append("D_PUNIT:").append(
													ausSearchContainerDescVO.get(kk).getDPunit()).append("\n");
											flatFile.append("D_PKG:")
													.append(ausSearchContainerDescVO.get(kk).getDPkg()).append("\n");
											flatFile.append("D_WGT:")
													.append(ausSearchContainerDescVO.get(kk).getDWgt()).append("\n");
											flatFile.append("D_MEAS:").append(
													ausSearchContainerDescVO.get(kk).getDMeas()).append("\n");
											flatFile.append("D_DESC:").append(
													ausSearchContainerDescVO.get(kk).getDDesc()).append("\n");
											StringTokenizer token = new StringTokenizer(ausSearchContainerDescVO
													.get(kk).getDMark(), "\n");
											ArrayList tmpArray = new ArrayList();
											while (token.hasMoreTokens()) {
												tmpArray.add(token.nextToken());
											}
											if (tmpArray.size() > 0)
												flatFile.append("{CUS_MARK").append("\n");
											for (int mm = 0; mm < tmpArray.size(); mm++) {
												flatFile.append("D_MARK:").append(tmpArray.get(mm).toString());
												flatFile.append("\n");
											}
											if (tmpArray.size() > 0)
												flatFile.append("}CUS_MARK").append("\n");
											flatFile.append("}CNTR_DESC").append("\n");
										}
									}
									flatFile.append("}CNTR_INFO").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Qty 정보를 조회한다.
							ausSearchBlQtyVO = dbDao.searchBlQty(austrailiaManifestTransmitVO);
							if (ausSearchBlQtyVO != null) {
								for (int m = 0; m < ausSearchBlQtyVO.size(); m++) {
									flatFile.append("{QTY").append("\n");
									flatFile.append("HANTYPE:").append(ausSearchBlQtyVO.get(m).getHantype()).append(
											"\n");
									flatFile.append("COUNT:").append(ausSearchBlQtyVO.get(m).getCntrQty()).append("\n");
									flatFile.append("}QTY").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L VVD 정보를 조회한다.
							ausSearchBlVvdVO = dbDao.searchBlVvd(austrailiaManifestTransmitVO);
							if (ausSearchBlVvdVO != null) {
								for (int m = 0; m < ausSearchBlVvdVO.size(); m++) {
									flatFile.append("{BKGVVD").append("\n");
									flatFile.append("BVVD:").append(ausSearchBlVvdVO.get(m).getBvvd()).append("\n");
									flatFile.append("BPOL:").append(ausSearchBlVvdVO.get(m).getBpol()).append("\n");
									flatFile.append("BPOD:").append(ausSearchBlVvdVO.get(m).getBpod()).append("\n");
									flatFile.append("}BKGVVD").append("\n");
								}
							}
							flatFile.append("}BL_INFO").append("\n");
						}
					}
					sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_AUSMF.IBMMQ.QUEUE"));

					flatFileAckVO = new FlatFileAckVO();
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00220", new String[] {}).getMessage());

				}
				// 호주세관으로 전송
				if (austrailiaManifestTransmitVO.getTransGubun().equalsIgnoreCase("M")) {
					ausSearchMakeHeaderMVO = dbDao.searchMakerHeaderM();
					flatFile.append(ausSearchMakeHeaderMVO.get(0).getMsgHeader()).append("\n");
					// 호주세관으로 전송할 Vessel 정보를 조회한다.
					ausSearchVesselForMVO = dbDao.searchVesselForM(austrailiaManifestTransmitVO);
					if (ausSearchVesselForMVO != null && ausSearchVesselForMVO.size() > 0) {
						flatFile.append("VVD:").append(ausSearchVesselForMVO.get(0).getVvdNumber()).append("\n");
					}
					// 호주세관 및 항만청으로 전송할 Vessel VVD 정보를 조회한다.
					ausSearchVvdVO = dbDao.searchVvd(austrailiaManifestTransmitVO);
					if (ausSearchVvdVO != null && ausSearchVvdVO.size() > 0) {
						flatFile.append("VSL_CALLSIGN:").append(ausSearchVvdVO.get(0).getVslCallsign()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(ausSearchVvdVO.get(0).getVslLloydcode()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(ausSearchVvdVO.get(0).getVslFullname()).append("\n");
						flatFile.append("MSG_FUNC:").append(ausSearchVvdVO.get(0).getMsgFunc()).append("\n");
					}
					// 호주세관 및 항만청으로 전송할 Vessel Estimated Date 정보를 조회한다.
					ausSearchEstimateDtVO = dbDao.searchEstimateDt(austrailiaManifestTransmitVO);
					if (ausSearchEstimateDtVO != null && ausSearchEstimateDtVO.size() > 0) {
						flatFile.append("ETA:").append(ausSearchEstimateDtVO.get(0).getEta()).append("\n");
						flatFile.append("ETD:").append(ausSearchEstimateDtVO.get(0).getEtd()).append("\n");
					}
					// 호주세관으로 전송할 Manifest B/L General 정보를 조회한다.
					ausSearchBlGeneralForMVO = dbDao.searchBlGeneralForM(austrailiaManifestTransmitVO);
					if (ausSearchBlGeneralForMVO != null && ausSearchBlGeneralForMVO.size() > 0) {

						for (int i = 0; i < ausSearchBlGeneralForMVO.size(); i++) {
							flatFile.append("{BL_INFO").append("\n");
							austrailiaManifestTransmitVO.setBkgCgoTp(ausSearchBlGeneralForMVO.get(i).getBkgCgoTpCd());
							austrailiaManifestTransmitVO.setBkgSpeRf(ausSearchBlGeneralForMVO.get(i).getBkgSpeRf());
							austrailiaManifestTransmitVO.setBkgSpeDg(ausSearchBlGeneralForMVO.get(i).getBkgSpeDg());
							austrailiaManifestTransmitVO.setBkgSpeAk(ausSearchBlGeneralForMVO.get(i).getBkgSpeAk());
							austrailiaManifestTransmitVO.setBkgSpeBb(ausSearchBlGeneralForMVO.get(i).getBkgSpeBb());
							austrailiaManifestTransmitVO.setCmdtDesc(ausSearchBlGeneralForMVO.get(i).getCmdtDesc());
							austrailiaManifestTransmitVO.setCmdtCd(ausSearchBlGeneralForMVO.get(i).getCmdtCd());
							austrailiaManifestTransmitVO.setBkgSpeRd(ausSearchBlGeneralForMVO.get(i).getBkgSpeRd());

							flatFile.append("BLNBR:").append(ausSearchBlGeneralForMVO.get(i).getBlnbr()).append("\n");
							flatFile.append("BKGNBR:").append(ausSearchBlGeneralForMVO.get(i).getBkgnbr()).append("\n");
							flatFile.append("BLPOL:").append(ausSearchBlGeneralForMVO.get(i).getBlpol()).append("\n");
							flatFile.append("BLPOD:").append(ausSearchBlGeneralForMVO.get(i).getBlpod()).append("\n");
							flatFile.append("BLPOR:").append(ausSearchBlGeneralForMVO.get(i).getBlpor()).append("\n");
							flatFile.append("BLDEL:").append(ausSearchBlGeneralForMVO.get(i).getBldel()).append("\n");
							flatFile.append("BLRLY:").append(ausSearchBlGeneralForMVO.get(i).getBlrly()).append("\n");
							flatFile.append("BLPLACE:").append(ausSearchBlGeneralForMVO.get(i).getBlplace()).append(
									"\n");
							flatFile.append("BLDATE:").append(ausSearchBlGeneralForMVO.get(i).getBldate()).append("\n");
							flatFile.append("CUST_CD:").append(ausSearchBlGeneralForMVO.get(i).getCustCd())
									.append("\n");
							flatFile.append("SHPR1:").append(ausSearchBlGeneralForMVO.get(i).getShpr1()).append("\n");
							flatFile.append("SHPR2:").append(ausSearchBlGeneralForMVO.get(i).getShpr2()).append("\n");
							flatFile.append("SHPR3:").append(ausSearchBlGeneralForMVO.get(i).getShpr3()).append("\n");
							flatFile.append("SHPR4:").append(ausSearchBlGeneralForMVO.get(i).getShpr4()).append("\n");
							flatFile.append("SHPR5:").append(ausSearchBlGeneralForMVO.get(i).getShpr5()).append("\n");
							flatFile.append("CNEE1:").append(ausSearchBlGeneralForMVO.get(i).getCnee1()).append("\n");
							flatFile.append("CNEE2:").append(ausSearchBlGeneralForMVO.get(i).getCnee2()).append("\n");
							flatFile.append("CNEE3:").append(ausSearchBlGeneralForMVO.get(i).getCnee3()).append("\n");
							flatFile.append("CNEE4:").append(ausSearchBlGeneralForMVO.get(i).getCnee4()).append("\n");
							flatFile.append("CNEE5:").append(ausSearchBlGeneralForMVO.get(i).getCnee5()).append("\n");
							flatFile.append("NTFY1:").append(ausSearchBlGeneralForMVO.get(i).getNtfy1()).append("\n");
							flatFile.append("NTFY2:").append(ausSearchBlGeneralForMVO.get(i).getNtfy2()).append("\n");
							flatFile.append("NTFY3:").append(ausSearchBlGeneralForMVO.get(i).getNtfy3()).append("\n");
							flatFile.append("NTFY4:").append(ausSearchBlGeneralForMVO.get(i).getNtfy4()).append("\n");
							flatFile.append("NTFY5:").append(ausSearchBlGeneralForMVO.get(i).getNtfy5()).append("\n");
							flatFile.append("NTFY21:").append(ausSearchBlGeneralForMVO.get(i).getNtfy21()).append("\n");
							flatFile.append("NTFY22:").append(ausSearchBlGeneralForMVO.get(i).getNtfy22()).append("\n");
							flatFile.append("NTFY23:").append(ausSearchBlGeneralForMVO.get(i).getNtfy23()).append("\n");
							flatFile.append("NTFY24:").append(ausSearchBlGeneralForMVO.get(i).getNtfy24()).append("\n");
							flatFile.append("NTFY25:").append(ausSearchBlGeneralForMVO.get(i).getNtfy25()).append("\n");
							flatFile.append("FFWD1:").append(ausSearchBlGeneralForMVO.get(i).getFfwd1()).append("\n");
							flatFile.append("FFWD2:").append(ausSearchBlGeneralForMVO.get(i).getFfwd2()).append("\n");
							flatFile.append("FFWD3:").append(ausSearchBlGeneralForMVO.get(i).getFfwd3()).append("\n");
							flatFile.append("FFWD4:").append(ausSearchBlGeneralForMVO.get(i).getFfwd4()).append("\n");
							flatFile.append("FFWD5:").append(ausSearchBlGeneralForMVO.get(i).getFfwd5()).append("\n");
							flatFile.append("EXPO1:").append(ausSearchBlGeneralForMVO.get(i).getExpo1()).append("\n");
							flatFile.append("EXPO2:").append(ausSearchBlGeneralForMVO.get(i).getExpo2()).append("\n");
							flatFile.append("EXPO3:").append(ausSearchBlGeneralForMVO.get(i).getExpo3()).append("\n");
							flatFile.append("EXPO4:").append(ausSearchBlGeneralForMVO.get(i).getExpo4()).append("\n");
							flatFile.append("EXPO5:").append(ausSearchBlGeneralForMVO.get(i).getExpo5()).append("\n");
							flatFile.append("BLCOPY:").append(ausSearchBlGeneralForMVO.get(i).getBlcopy()).append("\n");
							flatFile.append("BLORG:").append(ausSearchBlGeneralForMVO.get(i).getBlorg()).append("\n");
							flatFile.append("BLPKG:").append(ausSearchBlGeneralForMVO.get(i).getBlpkg()).append("\n");
							flatFile.append("BLPKGU:").append(ausSearchBlGeneralForMVO.get(i).getBlpkgu()).append("\n");
							flatFile.append("BLWGT:").append(ausSearchBlGeneralForMVO.get(i).getBlwgt()).append("\n");
							flatFile.append("BLMEA:").append(ausSearchBlGeneralForMVO.get(i).getBlmea()).append("\n");
							flatFile.append("RDTYPE:").append(ausSearchBlGeneralForMVO.get(i).getRdtype()).append("\n");
							flatFile.append("CARGOTYPE:").append(ausSearchBlGeneralForMVO.get(i).getCargotype())
									.append("\n");
							flatFile.append("COMMODITY:").append(ausSearchBlGeneralForMVO.get(i).getCommodity())
									.append("\n");
							flatFile.append("REMARK:").append(ausSearchBlGeneralForMVO.get(i).getXterRmk())
									.append("\n");
							flatFile.append("AUS_QUAR:").append(ausSearchBlGeneralForMVO.get(i).getAusQuar()).append(
									"\n");
							flatFile.append("FRT_IND:").append(ausSearchBlGeneralForMVO.get(i).getFrtInd())
									.append("\n");
							flatFile.append("CUSTOMS_DESC:").append(ausSearchBlGeneralForMVO.get(i).getCstmsDesc())
									.append("\n");
							flatFile.append("E_I_IND:").append(ausSearchBlGeneralForMVO.get(i).getEiInd())
									.append("\n");  
							austrailiaManifestTransmitVO.setBkgNo(ausSearchBlGeneralForMVO.get(i).getBkgNo());
							ausSearchBlCharegeVO = dbDao.searchBlCharge(austrailiaManifestTransmitVO);
							// 호주세관 및 항만청으로 전송할 Manifest B/L Charge 정보를 조회한다.
							if (ausSearchBlCharegeVO != null) {
								for (int j = 0; j < ausSearchBlCharegeVO.size(); j++) {
									flatFile.append("{CHARGE").append("\n");
									flatFile.append("FCTYPE:").append(ausSearchBlCharegeVO.get(j).getFctype()).append(
											"\n");
									flatFile.append("RATE:").append(ausSearchBlCharegeVO.get(j).getRate()).append("\n");
									flatFile.append("REVENUETON:").append(ausSearchBlCharegeVO.get(j).getRevenueton())
											.append("\n");
									flatFile.append("PPD:").append(ausSearchBlCharegeVO.get(j).getPpd()).append("\n");
									flatFile.append("CCT:").append(ausSearchBlCharegeVO.get(j).getCct()).append("\n");
									flatFile.append("CURRENCYCODE:").append(
											ausSearchBlCharegeVO.get(j).getCurrencycode()).append("\n");
									flatFile.append("TARIFF:").append(ausSearchBlCharegeVO.get(j).getTariff()).append(
											"\n");
									flatFile.append("PERTYPE:").append(ausSearchBlCharegeVO.get(j).getPertype())
											.append("\n");
									flatFile.append("}CHARGE").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Charge Total 정보를 조회한다.
							ausSearchBlChargeTotalVO = dbDao.searchBlChargeTotal(austrailiaManifestTransmitVO);
							if (ausSearchBlChargeTotalVO != null) {
								for (int j = 0; j < ausSearchBlChargeTotalVO.size(); j++) {
									flatFile.append("{CHARGE_TTL").append("\n");
									flatFile.append("PPD_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getPpdTotal())
											.append("\n");
									flatFile.append("CCT_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getCctTotal())
											.append("\n");
									flatFile.append("TOTAL_CUR:").append(ausSearchBlChargeTotalVO.get(j).getTotalCur())
											.append("\n");
									flatFile.append("}CHARGE_TTL").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Mark Description 정보를 조회한다.
							ausSearchBlMarkDescVO = dbDao.searchBlMarksDesc(austrailiaManifestTransmitVO);
							if (ausSearchBlMarkDescVO != null) {
								for (int j = 0; j < ausSearchBlMarkDescVO.size(); j++) {
									StringTokenizer token = new StringTokenizer(ausSearchBlMarkDescVO.get(j)
											.getCmdtDesc(), "\n");
									ArrayList tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{DESC").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("DESC:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}DESC").append("\n");
									token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getMkDesc(), "\n");
									tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{MARK").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("MARKNO:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}MARK").append("\n");
								}
							}
							// 호주세관으로 전송할 Manifest Container 정보를 조회한다.
							ausSearchContainerForMVO = dbDao.searchContainerForM(austrailiaManifestTransmitVO);
							if (ausSearchContainerForMVO != null) {
								for (int k = 0; k < ausSearchContainerForMVO.size(); k++) {
									flatFile.append("{CNTR_INFO").append("\n");
									austrailiaManifestTransmitVO.setCntrNo(ausSearchContainerForMVO.get(k).getCntrNo());
									flatFile.append("CNTRNBR:").append(ausSearchContainerForMVO.get(k).getCntrnbr())
											.append("\n");
									flatFile.append("PUNIT:").append(ausSearchContainerForMVO.get(k).getPunit())
											.append("\n");
									flatFile.append("PKG:").append(ausSearchContainerForMVO.get(k).getPkg()).append(
											"\n");
									flatFile.append("CNTRWGT:").append(ausSearchContainerForMVO.get(k).getCntrwgt())
											.append("\n");
									flatFile.append("CNTRTYPE:").append(ausSearchContainerForMVO.get(k).getCntrtype())
											.append("\n");
									flatFile.append("SEALNBR:").append(ausSearchContainerForMVO.get(k).getSealnbr())
											.append("\n");
									flatFile.append("SOC_IND:").append(ausSearchContainerForMVO.get(k).getSocInd())
											.append("\n");
									flatFile.append("FM_IND:").append(ausSearchContainerForMVO.get(k).getFmInd())
											.append("\n");
									flatFile.append("RF_IND:").append(ausSearchContainerForMVO.get(k).getRfInd())
											.append("\n");
									flatFile.append("DG_IND:").append(ausSearchContainerForMVO.get(k).getDgInd())
											.append("\n");
									flatFile.append("AK_IND:").append(ausSearchContainerForMVO.get(k).getAkInd())
											.append("\n");
									flatFile.append("BK_IND:").append(ausSearchContainerForMVO.get(k).getBkInd())
											.append("\n");
									flatFile.append("TEMP:").append(ausSearchContainerForMVO.get(k).getTemp()).append(
											"\n");
									flatFile.append("TUNIT:").append(ausSearchContainerForMVO.get(k).getTunit())
											.append("\n");
									flatFile.append("HUMIDITY:").append(ausSearchContainerForMVO.get(k).getHumidity())
											.append("\n");
									flatFile.append("VENT:").append(ausSearchContainerForMVO.get(k).getVent()).append(
											"\n");
									flatFile.append("MEASURE:").append(ausSearchContainerForMVO.get(k).getMeasure())
											.append("\n");
									flatFile.append("RDTYPE:").append(ausSearchContainerForMVO.get(k).getRdtype())
											.append("\n");
									flatFile.append("CMDT_DESC:").append(ausSearchContainerForMVO.get(k).getCmdtDesc())
											.append("\n");
									flatFile.append("CMDTCD:").append(ausSearchContainerForMVO.get(k).getCmdtcd())
											.append("\n");
									flatFile.append("RF_REMARK:").append(ausSearchContainerForMVO.get(k).getRfRemark())
											.append("\n");
									flatFile.append("RFDRY_IND:").append(ausSearchContainerForMVO.get(k).getRfdryInd())
											.append("\n");
									flatFile.append("OVF:").append(ausSearchContainerForMVO.get(k).getOvf()).append(
											"\n");
									flatFile.append("OVR:").append(ausSearchContainerForMVO.get(k).getOvr()).append(
											"\n");
									flatFile.append("OVH:").append(ausSearchContainerForMVO.get(k).getOvh()).append(
											"\n");
									flatFile.append("OVLW:").append(ausSearchContainerForMVO.get(k).getOvlw()).append(
											"\n");
									flatFile.append("OVRW:").append(ausSearchContainerForMVO.get(k).getOvrw()).append(
											"\n");
									flatFile.append("OVWGT:").append(ausSearchContainerForMVO.get(k).getOvwgt())
											.append("\n");
									flatFile.append("VOID_SLOT:").append(ausSearchContainerForMVO.get(k).getVoidSlot())
											.append("\n");
									flatFile.append("STWG_REQ:").append(ausSearchContainerForMVO.get(k).getStwgReq())
											.append("\n");
									flatFile.append("CNTR_E_I_IND:").append(ausSearchBlGeneralForMVO.get(i).getEiInd())
											.append("\n");
									// 호주세관 및 항만청으로 전송할 Manifest Container Danger 정보를 조회한다.
									ausSearchContainerDangerVO = dbDao
											.searchContainerDanger(austrailiaManifestTransmitVO);
									if (ausSearchContainerDangerVO != null) {
										for (int kk = 0; kk < ausSearchContainerDangerVO.size(); kk++) {
											flatFile.append("{CNTR_DANGER").append("\n");
											flatFile.append("UNNBR:").append(
													ausSearchContainerDangerVO.get(kk).getUnnbr()).append("\n");
											flatFile.append("CLASS:").append(
													ausSearchContainerDangerVO.get(kk).getImdgClass()).append("\n");
											flatFile.append("DESC:").append(
													ausSearchContainerDangerVO.get(kk).getShpNm()).append("\n");
											flatFile.append("PHONE:").append(
													ausSearchContainerDangerVO.get(kk).getPhone()).append("\n");
											flatFile.append("PAGE:").append(
													ausSearchContainerDangerVO.get(kk).getPageList()).append("\n");
											flatFile.append("FLSH_TEMP:").append(
													ausSearchContainerDangerVO.get(kk).getFlshTemp()).append("\n");
											flatFile.append("FLSH_UNIT:").append(
													ausSearchContainerDangerVO.get(kk).getFlshUnit()).append("\n");
											flatFile.append("DG_REMARK:").append(
													ausSearchContainerDangerVO.get(kk).getDgRemark()).append("\n");
											flatFile.append("}CNTR_DANGER").append("\n");
										}
									}
									// 호주세관 및 항만청으로 전송할 Manifest Container Description 정보를 조회한다.
									ausSearchContainerDescVO = dbDao.searchContainerDesc(austrailiaManifestTransmitVO);
									if (ausSearchContainerDescVO != null) {
										for (int kk = 0; kk < ausSearchContainerDescVO.size(); kk++) {
											flatFile.append("{CNTR_DESC").append("\n");
											flatFile.append("D_CMDT:").append(
													ausSearchContainerDescVO.get(kk).getDCmdt()).append("\n");
											flatFile.append("D_PUNIT:").append(
													ausSearchContainerDescVO.get(kk).getDPunit()).append("\n");
											flatFile.append("D_PKG:")
													.append(ausSearchContainerDescVO.get(kk).getDPkg()).append("\n");
											flatFile.append("D_WGT:")
													.append(ausSearchContainerDescVO.get(kk).getDWgt()).append("\n");
											flatFile.append("D_MEAS:").append(
													ausSearchContainerDescVO.get(kk).getDMeas()).append("\n");
											flatFile.append("D_DESC:").append(
													ausSearchContainerDescVO.get(kk).getDDesc()).append("\n");
											StringTokenizer token = new StringTokenizer(ausSearchContainerDescVO
													.get(kk).getDMark(), "\n");
											ArrayList tmpArray = new ArrayList();
											while (token.hasMoreTokens()) {
												tmpArray.add(token.nextToken());
											}
											if (tmpArray.size() > 0)
												flatFile.append("{CUS_MARK").append("\n");
											for (int mm = 0; mm < tmpArray.size(); mm++) {
												flatFile.append("D_MARK:").append(tmpArray.get(mm).toString());
												flatFile.append("\n");
											}
											if (tmpArray.size() > 0)
												flatFile.append("}CUS_MARK").append("\n");
											flatFile.append("}CNTR_DESC").append("\n");
										}
									}
									flatFile.append("}CNTR_INFO").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Qty 정보를 조회한다.
							ausSearchBlQtyVO = dbDao.searchBlQty(austrailiaManifestTransmitVO);
							if (ausSearchBlQtyVO != null) {
								for (int m = 0; m < ausSearchBlQtyVO.size(); m++) {
									flatFile.append("{QTY").append("\n");
									flatFile.append("HANTYPE:").append(ausSearchBlQtyVO.get(m).getHantype()).append(
											"\n");
									flatFile.append("COUNT:").append(ausSearchBlQtyVO.get(m).getCntrQty()).append("\n");
									flatFile.append("}QTY").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L VVD 정보를 조회한다.
							ausSearchBlVvdVO = dbDao.searchBlVvd(austrailiaManifestTransmitVO);
							if (ausSearchBlVvdVO != null) {
								for (int m = 0; m < ausSearchBlVvdVO.size(); m++) {
									flatFile.append("{BKGVVD").append("\n");
									flatFile.append("BVVD:").append(ausSearchBlVvdVO.get(m).getBvvd()).append("\n");
									flatFile.append("BPOL:").append(ausSearchBlVvdVO.get(m).getBpol()).append("\n");
									flatFile.append("BPOD:").append(ausSearchBlVvdVO.get(m).getBpod()).append("\n");
									flatFile.append("}BKGVVD").append("\n");
								}
							}
							flatFile.append("}BL_INFO").append("\n");
						}
					}
					if (flatFile.length() == 0)
						flatFile = new StringBuffer();

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_AUSMF.IBMMQ.QUEUE"));

					BookingUtil command = new BookingUtil();
					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00220", new String[] {}).getMessage());
				}
				// 호주항만청으로 전송
				if (austrailiaManifestTransmitVO.getTransGubun().equalsIgnoreCase("P")) {
					ausSearchMakeHeaderPVO = dbDao.searchMakerHeaderP(austrailiaManifestTransmitVO);
					flatFile.append(ausSearchMakeHeaderPVO.get(0).getMsgHeader()).append("\n");
					// 호주항만청으로 전송할 Vessel 정보를 조회한다.
					ausSearchVesselForPVO = dbDao.searchVesselForP(austrailiaManifestTransmitVO);
					if (ausSearchVesselForPVO != null && ausSearchVesselForPVO.size() > 0) {
						flatFile.append("VVD:").append(ausSearchVesselForPVO.get(0).getVvdNumber()).append("\n");
					}
					// 호주세관 및 항만청으로 전송할 Vessel VVD 정보를 조회한다.
					ausSearchVvdVO = dbDao.searchVvd(austrailiaManifestTransmitVO);
					if (ausSearchVvdVO != null && ausSearchVvdVO.size() > 0) {
						flatFile.append("VSL_CALLSIGN:").append(ausSearchVvdVO.get(0).getVslCallsign()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(ausSearchVvdVO.get(0).getVslLloydcode()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(ausSearchVvdVO.get(0).getVslFullname()).append("\n");
						flatFile.append("MSG_FUNC:").append(ausSearchVvdVO.get(0).getMsgFunc()).append("\n");
					}
					// 호주세관 및 항만청으로 전송할 Vessel Estimated Date 정보를 조회한다.
					ausSearchEstimateDtVO = dbDao.searchEstimateDt(austrailiaManifestTransmitVO);
					if (ausSearchEstimateDtVO != null && ausSearchEstimateDtVO.size() > 0) {
						flatFile.append("ETA:").append(ausSearchEstimateDtVO.get(0).getEta()).append("\n");
						flatFile.append("ETD:").append(ausSearchEstimateDtVO.get(0).getEtd()).append("\n");
					}
					// 호주항만청으로 전송할 Manifest B/L General 정보를 조회한다.
					ausSearchBlGeneralForPVO = dbDao.searchBlGeneralForP(austrailiaManifestTransmitVO);
					if (ausSearchBlGeneralForPVO != null && ausSearchBlGeneralForPVO.size() > 0) {

						for (int i = 0; i < ausSearchBlGeneralForPVO.size(); i++) {
							flatFile.append("{BL_INFO").append("\n");
							austrailiaManifestTransmitVO.setBkgCgoTp(ausSearchBlGeneralForPVO.get(i).getBkgCgoTpCd());
							austrailiaManifestTransmitVO.setBkgSpeRf(ausSearchBlGeneralForPVO.get(i).getBkgSpeRf());
							austrailiaManifestTransmitVO.setBkgSpeDg(ausSearchBlGeneralForPVO.get(i).getBkgSpeDg());
							austrailiaManifestTransmitVO.setBkgSpeAk(ausSearchBlGeneralForPVO.get(i).getBkgSpeAk());
							austrailiaManifestTransmitVO.setBkgSpeBb(ausSearchBlGeneralForPVO.get(i).getBkgSpeBb());
							austrailiaManifestTransmitVO.setCmdtDesc(ausSearchBlGeneralForPVO.get(i).getCmdtDesc());
							austrailiaManifestTransmitVO.setCmdtCd(ausSearchBlGeneralForPVO.get(i).getCmdtCd());
							austrailiaManifestTransmitVO.setBkgSpeRd(ausSearchBlGeneralForPVO.get(i).getBkgSpeRd());

							flatFile.append("BLNBR:").append(ausSearchBlGeneralForPVO.get(i).getBlnbr()).append("\n");
							// flatFile.append("BKGNBR:").append(ausSearchBlGeneralForPVO.get(i).getBkgnbr()).append("\n");
							flatFile.append("BLPOL:").append(ausSearchBlGeneralForPVO.get(i).getBlpol()).append("\n");
							flatFile.append("BLPOD:").append(ausSearchBlGeneralForPVO.get(i).getBlpod()).append("\n");
							flatFile.append("BLPOR:").append(ausSearchBlGeneralForPVO.get(i).getBlpor()).append("\n");
							flatFile.append("BLDEL:").append(ausSearchBlGeneralForPVO.get(i).getBldel()).append("\n");
							flatFile.append("BLRLY:").append(ausSearchBlGeneralForPVO.get(i).getBlrly()).append("\n");
							flatFile.append("BLPLACE:").append(ausSearchBlGeneralForPVO.get(i).getBlplace()).append(
									"\n");
							flatFile.append("BLDATE:").append(ausSearchBlGeneralForPVO.get(i).getBldate()).append("\n");
							flatFile.append("CUST_CD:").append(ausSearchBlGeneralForPVO.get(i).getCustCd())
									.append("\n");
							flatFile.append("SHPR1:").append(ausSearchBlGeneralForPVO.get(i).getShpr1()).append("\n");
							flatFile.append("SHPR2:").append(ausSearchBlGeneralForPVO.get(i).getShpr2()).append("\n");
							flatFile.append("SHPR3:").append(ausSearchBlGeneralForPVO.get(i).getShpr3()).append("\n");
							flatFile.append("SHPR4:").append(ausSearchBlGeneralForPVO.get(i).getShpr4()).append("\n");
							flatFile.append("SHPR5:").append(ausSearchBlGeneralForPVO.get(i).getShpr5()).append("\n");
							flatFile.append("CNEE1:").append(ausSearchBlGeneralForPVO.get(i).getCnee1()).append("\n");
							flatFile.append("CNEE2:").append(ausSearchBlGeneralForPVO.get(i).getCnee2()).append("\n");
							flatFile.append("CNEE3:").append(ausSearchBlGeneralForPVO.get(i).getCnee3()).append("\n");
							flatFile.append("CNEE4:").append(ausSearchBlGeneralForPVO.get(i).getCnee4()).append("\n");
							flatFile.append("CNEE5:").append(ausSearchBlGeneralForPVO.get(i).getCnee5()).append("\n");
							flatFile.append("NTFY1:").append(ausSearchBlGeneralForPVO.get(i).getNtfy1()).append("\n");
							flatFile.append("NTFY2:").append(ausSearchBlGeneralForPVO.get(i).getNtfy2()).append("\n");
							flatFile.append("NTFY3:").append(ausSearchBlGeneralForPVO.get(i).getNtfy3()).append("\n");
							flatFile.append("NTFY4:").append(ausSearchBlGeneralForPVO.get(i).getNtfy4()).append("\n");
							flatFile.append("NTFY5:").append(ausSearchBlGeneralForPVO.get(i).getNtfy5()).append("\n");
							flatFile.append("NTFY21:").append(ausSearchBlGeneralForPVO.get(i).getNtfy21()).append("\n");
							flatFile.append("NTFY22:").append(ausSearchBlGeneralForPVO.get(i).getNtfy22()).append("\n");
							flatFile.append("NTFY23:").append(ausSearchBlGeneralForPVO.get(i).getNtfy23()).append("\n");
							flatFile.append("NTFY24:").append(ausSearchBlGeneralForPVO.get(i).getNtfy24()).append("\n");
							flatFile.append("NTFY25:").append(ausSearchBlGeneralForPVO.get(i).getNtfy25()).append("\n");
							flatFile.append("FFWD1:").append(ausSearchBlGeneralForPVO.get(i).getFfwd1()).append("\n");
							flatFile.append("FFWD2:").append(ausSearchBlGeneralForPVO.get(i).getFfwd2()).append("\n");
							flatFile.append("FFWD3:").append(ausSearchBlGeneralForPVO.get(i).getFfwd3()).append("\n");
							flatFile.append("FFWD4:").append(ausSearchBlGeneralForPVO.get(i).getFfwd4()).append("\n");
							flatFile.append("FFWD5:").append(ausSearchBlGeneralForPVO.get(i).getFfwd5()).append("\n");
							flatFile.append("EXPO1:").append(ausSearchBlGeneralForPVO.get(i).getExpo1()).append("\n");
							flatFile.append("EXPO2:").append(ausSearchBlGeneralForPVO.get(i).getExpo2()).append("\n");
							flatFile.append("EXPO3:").append(ausSearchBlGeneralForPVO.get(i).getExpo3()).append("\n");
							flatFile.append("EXPO4:").append(ausSearchBlGeneralForPVO.get(i).getExpo4()).append("\n");
							flatFile.append("EXPO5:").append(ausSearchBlGeneralForPVO.get(i).getExpo5()).append("\n");
							flatFile.append("BLCOPY:").append(ausSearchBlGeneralForPVO.get(i).getBlcopy()).append("\n");
							flatFile.append("BLORG:").append(ausSearchBlGeneralForPVO.get(i).getBlorg()).append("\n");
							flatFile.append("BLPKG:").append(ausSearchBlGeneralForPVO.get(i).getBlpkg()).append("\n");
							flatFile.append("BLPKGU:").append(ausSearchBlGeneralForPVO.get(i).getBlpkgu()).append("\n");
							flatFile.append("BLWGT:").append(ausSearchBlGeneralForPVO.get(i).getBlwgt()).append("\n");
							flatFile.append("BLMEA:").append(ausSearchBlGeneralForPVO.get(i).getBlmea()).append("\n");
							flatFile.append("RDTYPE:").append(ausSearchBlGeneralForPVO.get(i).getRdtype()).append("\n");
							flatFile.append("CARGOTYPE:").append(ausSearchBlGeneralForPVO.get(i).getCargotype())
									.append("\n");
							flatFile.append("COMMODITY:").append(ausSearchBlGeneralForPVO.get(i).getCommodity())
									.append("\n");
							flatFile.append("REMARK:").append(ausSearchBlGeneralForPVO.get(i).getXterRmk())
									.append("\n");
							flatFile.append("AUS_QUAR:").append(ausSearchBlGeneralForPVO.get(i).getAusQuar()).append(
									"\n");
							flatFile.append("E_I_IND:").append(ausSearchBlGeneralForPVO.get(i).getEiInd()).append(
									"\n");
							// flatFile.append("FRT_IND:").append(ausSearchBlGeneralForPVO.get(i).getFrtInd()).append("\n");
							// flatFile.append("CUSTOMS_DESC:").append(ausSearchBlGeneralForPVO.get(i).getCmdtDesc()).append("\n");
							austrailiaManifestTransmitVO.setBkgNo(ausSearchBlGeneralForPVO.get(i).getBkgNo());
							ausSearchBlCharegeVO = dbDao.searchBlCharge(austrailiaManifestTransmitVO);
							// 호주세관 및 항만청으로 전송할 Manifest B/L Charge 정보를 조회한다.
							if (ausSearchBlCharegeVO != null) {
								for (int j = 0; j < ausSearchBlCharegeVO.size(); j++) {
									flatFile.append("{CHARGE").append("\n");
									flatFile.append("FCTYPE:").append(ausSearchBlCharegeVO.get(j).getFctype()).append(
											"\n");
									flatFile.append("RATE:").append(ausSearchBlCharegeVO.get(j).getRate()).append("\n");
									flatFile.append("REVENUETON:").append(ausSearchBlCharegeVO.get(j).getRevenueton())
											.append("\n");
									flatFile.append("PPD:").append(ausSearchBlCharegeVO.get(j).getPpd()).append("\n");
									flatFile.append("CCT:").append(ausSearchBlCharegeVO.get(j).getCct()).append("\n");
									flatFile.append("CURRENCYCODE:").append(
											ausSearchBlCharegeVO.get(j).getCurrencycode()).append("\n");
									flatFile.append("TARIFF:").append(ausSearchBlCharegeVO.get(j).getTariff()).append(
											"\n");
									flatFile.append("PERTYPE:").append(ausSearchBlCharegeVO.get(j).getPertype())
											.append("\n");
									flatFile.append("}CHARGE").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Charge Total 정보를 조회한다.
							ausSearchBlChargeTotalVO = dbDao.searchBlChargeTotal(austrailiaManifestTransmitVO);
							if (ausSearchBlChargeTotalVO != null) {
								for (int j = 0; j < ausSearchBlChargeTotalVO.size(); j++) {
									flatFile.append("{CHARGE_TTL").append("\n");
									flatFile.append("PPD_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getPpdTotal())
											.append("\n");
									flatFile.append("CCT_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getCctTotal())
											.append("\n");
									flatFile.append("TOTAL_CUR:").append(ausSearchBlChargeTotalVO.get(j).getTotalCur())
											.append("\n");
									flatFile.append("}CHARGE_TTL").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Mark Description 정보를 조회한다.
							ausSearchBlMarkDescVO = dbDao.searchBlMarksDesc(austrailiaManifestTransmitVO);
							if (ausSearchBlMarkDescVO != null) {
								for (int j = 0; j < ausSearchBlMarkDescVO.size(); j++) {
									StringTokenizer token = new StringTokenizer(ausSearchBlMarkDescVO.get(j)
											.getCmdtDesc(), "\n");
									ArrayList tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{DESC").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("DESC:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}DESC").append("\n");
									token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getMkDesc(), "\n");
									tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									if (tmpArray.size() > 0)
										flatFile.append("{MARK").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("MARKNO:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0)
										flatFile.append("}MARK").append("\n");
								}
							}
							// 호주항만청으로 전송할 Manifest Container 정보를 조회한다.
							ausSearchContainerForPVO = dbDao.searchContainerForP(austrailiaManifestTransmitVO);
							if (ausSearchContainerForPVO != null) {
								for (int k = 0; k < ausSearchContainerForPVO.size(); k++) {
									flatFile.append("{CNTR_INFO").append("\n");
									austrailiaManifestTransmitVO.setCntrNo(ausSearchContainerForPVO.get(k).getCntrNo());
									flatFile.append("CNTRNBR:").append(ausSearchContainerForPVO.get(k).getCntrnbr())
											.append("\n");
									flatFile.append("PUNIT:").append(ausSearchContainerForPVO.get(k).getPunit())
											.append("\n");
									flatFile.append("PKG:").append(ausSearchContainerForPVO.get(k).getPkg()).append(
											"\n");
									flatFile.append("CNTRWGT:").append(ausSearchContainerForPVO.get(k).getCntrwgt())
											.append("\n");
									flatFile.append("CNTRTYPE:").append(ausSearchContainerForPVO.get(k).getCntrtype())
											.append("\n");
									flatFile.append("SEALNBR:").append(ausSearchContainerForPVO.get(k).getSealnbr())
											.append("\n");
									// flatFile.append("SOC_IND:").append(ausSearchContainerForPVO.get(k).getSocInd()).append("\n");
									flatFile.append("FM_IND:").append(ausSearchContainerForPVO.get(k).getFmInd())
											.append("\n");
									flatFile.append("RF_IND:").append(ausSearchContainerForPVO.get(k).getRfInd())
											.append("\n");
									flatFile.append("DG_IND:").append(ausSearchContainerForPVO.get(k).getDgInd())
											.append("\n");
									flatFile.append("AK_IND:").append(ausSearchContainerForPVO.get(k).getAkInd())
											.append("\n");
									flatFile.append("BK_IND:").append(ausSearchContainerForPVO.get(k).getBkInd())
											.append("\n");
									flatFile.append("TEMP:").append(ausSearchContainerForPVO.get(k).getTemp()).append(
											"\n");
									flatFile.append("TUNIT:").append(ausSearchContainerForPVO.get(k).getTunit())
											.append("\n");
									// flatFile.append("HUMIDITY:").append(ausSearchContainerForPVO.get(k).getHumidity()).append("\n");
									flatFile.append("VENT:").append(ausSearchContainerForPVO.get(k).getVent()).append(
											"\n");
									flatFile.append("MEASURE:").append(ausSearchContainerForPVO.get(k).getMeasure())
											.append("\n");
									flatFile.append("RDTYPE:").append(ausSearchContainerForPVO.get(k).getRdtype())
											.append("\n");
									flatFile.append("CMDT_DESC:").append(ausSearchContainerForPVO.get(k).getCmdtDesc())
											.append("\n");
									flatFile.append("CMDTCD:").append(ausSearchContainerForPVO.get(k).getCmdtcd())
											.append("\n");
									flatFile.append("RF_REMARK:").append(ausSearchContainerForPVO.get(k).getRfRemark())
											.append("\n");
									flatFile.append("RFDRY_IND:").append(ausSearchContainerForPVO.get(k).getRfdryInd())
											.append("\n");
									flatFile.append("OVF:").append(ausSearchContainerForPVO.get(k).getOvf()).append(
											"\n");
									flatFile.append("OVR:").append(ausSearchContainerForPVO.get(k).getOvr()).append(
											"\n");
									flatFile.append("OVH:").append(ausSearchContainerForPVO.get(k).getOvh()).append(
											"\n");
									flatFile.append("OVLW:").append(ausSearchContainerForPVO.get(k).getOvlw()).append(
											"\n");
									flatFile.append("OVRW:").append(ausSearchContainerForPVO.get(k).getOvrw()).append(
											"\n");
									flatFile.append("OVWGT:").append(ausSearchContainerForPVO.get(k).getOvwgt())
											.append("\n");
									flatFile.append("VOID_SLOT:").append(ausSearchContainerForPVO.get(k).getVoidSlot())
											.append("\n");
									flatFile.append("STWG_REQ:").append(ausSearchContainerForPVO.get(k).getStwgReq())
											.append("\n");
									flatFile.append("CNTR_E_I_IND:").append(ausSearchBlGeneralForPVO.get(i).getEiInd())
									.append("\n");
									// 호주세관 및 항만청으로 전송할 Manifest Container Danger 정보를 조회한다.
									ausSearchContainerDangerVO = dbDao
											.searchContainerDanger(austrailiaManifestTransmitVO);
									if (ausSearchContainerDangerVO != null) {
										for (int kk = 0; kk < ausSearchContainerDangerVO.size(); kk++) {
											flatFile.append("{CNTR_DANGER").append("\n");
											flatFile.append("UNNBR:").append(
													ausSearchContainerDangerVO.get(kk).getUnnbr()).append("\n");
											flatFile.append("CLASS:").append(
													ausSearchContainerDangerVO.get(kk).getImdgClass()).append("\n");
											flatFile.append("DESC:").append(
													ausSearchContainerDangerVO.get(kk).getShpNm()).append("\n");
											flatFile.append("PHONE:").append(
													ausSearchContainerDangerVO.get(kk).getPhone()).append("\n");
											flatFile.append("PAGE:").append(
													ausSearchContainerDangerVO.get(kk).getPageList()).append("\n");
											flatFile.append("FLSH_TEMP:").append(
													ausSearchContainerDangerVO.get(kk).getFlshTemp()).append("\n");
											flatFile.append("FLSH_UNIT:").append(
													ausSearchContainerDangerVO.get(kk).getFlshUnit()).append("\n");
											flatFile.append("DG_REMARK:").append(
													ausSearchContainerDangerVO.get(kk).getDgRemark()).append("\n");
											flatFile.append("}CNTR_DANGER").append("\n");
										}
									}
									// 호주세관 및 항만청으로 전송할 Manifest Container Description 정보를 조회한다.
									ausSearchContainerDescVO = dbDao.searchContainerDesc(austrailiaManifestTransmitVO);
									if (ausSearchContainerDescVO != null) {
										for (int kk = 0; kk < ausSearchContainerDescVO.size(); kk++) {
											flatFile.append("{CNTR_DESC").append("\n");
											flatFile.append("D_CMDT:").append(
													ausSearchContainerDescVO.get(kk).getDCmdt()).append("\n");
											flatFile.append("D_PUNIT:").append(
													ausSearchContainerDescVO.get(kk).getDPunit()).append("\n");
											flatFile.append("D_PKG:")
													.append(ausSearchContainerDescVO.get(kk).getDPkg()).append("\n");
											flatFile.append("D_WGT:")
													.append(ausSearchContainerDescVO.get(kk).getDWgt()).append("\n");
											flatFile.append("D_MEAS:").append(
													ausSearchContainerDescVO.get(kk).getDMeas()).append("\n");
											flatFile.append("D_DESC:").append(
													ausSearchContainerDescVO.get(kk).getDDesc()).append("\n");
											StringTokenizer token = new StringTokenizer(ausSearchContainerDescVO
													.get(kk).getDMark(), "\n");
											ArrayList tmpArray = new ArrayList();
											while (token.hasMoreTokens()) {
												tmpArray.add(token.nextToken());
											}
											if (tmpArray.size() > 0)
												flatFile.append("{CUS_MARK").append("\n");
											for (int mm = 0; mm < tmpArray.size(); mm++) {
												flatFile.append("D_MARK:").append(tmpArray.get(mm).toString());
												flatFile.append("\n");
											}
											if (tmpArray.size() > 0)
												flatFile.append("}CUS_MARK").append("\n");
											flatFile.append("}CNTR_DESC").append("\n");
										}
									}
									flatFile.append("}CNTR_INFO").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L Qty 정보를 조회한다.
							ausSearchBlQtyVO = dbDao.searchBlQty(austrailiaManifestTransmitVO);
							if (ausSearchBlQtyVO != null) {
								for (int m = 0; m < ausSearchBlQtyVO.size(); m++) {
									flatFile.append("{QTY").append("\n");
									flatFile.append("HANTYPE:").append(ausSearchBlQtyVO.get(m).getHantype()).append(
											"\n");
									flatFile.append("COUNT:").append(ausSearchBlQtyVO.get(m).getCntrQty()).append("\n");
									flatFile.append("}QTY").append("\n");
								}
							}
							// 호주세관 및 항만청으로 전송할 Manifest B/L VVD 정보를 조회한다.
							ausSearchBlVvdVO = dbDao.searchBlVvd(austrailiaManifestTransmitVO);
							if (ausSearchBlVvdVO != null) {
								for (int m = 0; m < ausSearchBlVvdVO.size(); m++) {
									flatFile.append("{BKGVVD").append("\n");
									flatFile.append("BVVD:").append(ausSearchBlVvdVO.get(m).getBvvd()).append("\n");
									flatFile.append("BPOL:").append(ausSearchBlVvdVO.get(m).getBpol()).append("\n");
									flatFile.append("BPOD:").append(ausSearchBlVvdVO.get(m).getBpod()).append("\n");
									flatFile.append("}BKGVVD").append("\n");
								}
							}
							flatFile.append("}BL_INFO").append("\n");
						}
					}
					if (flatFile.length() == 0)
						flatFile = new StringBuffer();

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_AUSMF.IBMMQ.QUEUE"));

					BookingUtil command = new BookingUtil();
					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00220", new String[] {}).getMessage());
				}
			}

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
	 * @param AustrailiaManifestTransmitVO[] austrailiaManifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, AustrailiaManifestTransmitVO[] austrailiaManifestTransmitVOs, String pgmNo)
			throws EventException {
		AustrailiaCustomsTransmissionBackEndJob backEndJob = new AustrailiaCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try {
			if (pgmNo.equals("ESM_BKG_0053")) {
				backEndJob.setAustrailiaManifestTransmitVOs(austrailiaManifestTransmitVOs);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Austrailia Transmit.");
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return resultStr;
	}		
	
	
	
	
	
	
	
	
	
	
	
	  /**
		 * 구주위험물 세관신고 위해 FlatFile을 생성 및 전송
		 * 
		 * @param  ManifestTransmitVO[] manifestTransmitVOs
		 * @param  SignOnUserAccount account
		 * @return List<String>
		 * @throws EventException
		 */
		@SuppressWarnings("unchecked")
		public List<String> sendDgManifestList(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
				
			
			// ORIGINAL 전송 VO
			List<DgEdiVO> originalDgEdiVO = new ArrayList<DgEdiVO>();
			// UPDATE 전송 VO
			List<DgEdiVO> updateDgEdiVO = new ArrayList<DgEdiVO>();
			// CANCEL 전송 VO
			List<DgEdiVO> cancelDgEdiVO = new ArrayList<DgEdiVO>();
			// UPDATE VO LIST
			List updateDgEdiVOList = new ArrayList();
			// 생성된 FlatFile String 리스트 : 위험물 하단에 임시로 생성된 FlatFile을 보여주기 위해사용
			List<String> retList = new ArrayList<String>();
			
			String originalFlatFile = "";
			String updateFlatFile = "";
			List<String> updateFlatFileList = new ArrayList<String>();
			String cancelFlatFile = "";
			
			DgEdiVO dgEdiVO = null;
			
			// 위험물 대상 총건수
			int dgEdiVOsMaxSize = 0;
			
			// 해당 port
			String comPortCd = "";
			
			/*
			 * 전송 type : 화면에서 눌려진 전송 버튼 구분(EDI Transmit / EDI Cancel)
			 * => 이후 다움과 같이 다시 셋팅함 (O->ORIGIN,U->UPDATE,C->CANCEL,AC->AUTO CANCEL)
			 */
			String transType = "";
			
			try {
		
				dgEdiVOsMaxSize = manifestTransmitVOs.length;

				for(int i = 0; i < dgEdiVOsMaxSize; i++) {
					dgEdiVO = (DgEdiVO)manifestTransmitVOs[i];
					
					if(i != 0) {
						dgEdiVO.setVvdCd(dgEdiVO.getVvdCd());
						dgEdiVO.setPortCd(dgEdiVO.getPortCd());
						dgEdiVO.setDType(dgEdiVO.getDType());
						dgEdiVO.setUiType(dgEdiVO.getUiType());
						dgEdiVO.setKeyType(dgEdiVO.getKeyType());
						dgEdiVO.setTransType(transType);
						
					} else {
						transType = dgEdiVO.getTransType();
						comPortCd = dgEdiVO.getPortCd().substring(2, 5);
					}

					if(transType.equalsIgnoreCase("CANCEL_SEND")) {
						dgEdiVO.setTransType("C");
						cancelDgEdiVO.add(dgEdiVO);
					} else {
					
						if(dgEdiVO.getSendType().equals("")) {
							dgEdiVO.setTransType("O");
							originalDgEdiVO.add(dgEdiVO);
							
						} else if(dgEdiVO.getSendType().equals("C")) {
							
							/*
							 * SEND TYPE이 CANCEL일 경우
							 * 
							 * HAM => UPDATE
							 * RTM, FXT, FOS, ANR => ORGINAL
							 */
							if(comPortCd.equals("HAM")) {
								dgEdiVO.setTransType("U");
								updateDgEdiVO.add(dgEdiVO);
							} else if(comPortCd.equals("RTM") || comPortCd.equals("FXT") || comPortCd.equals("THP") || comPortCd.equals("FOS") || comPortCd.equals("ANR")|| comPortCd.equals("ZEE")) {
								dgEdiVO.setTransType("O");
								originalDgEdiVO.add(dgEdiVO);
							} 
							

							
						} else if(dgEdiVO.getSendType().equals("O") || dgEdiVO.getSendType().equals("U") || dgEdiVO.getSendType().equals("AC")) {
							
							if(!dgEdiVO.getSendType().equals("AC")) {
								dgEdiVO.setTransType("U");
							} else { // Auto Cancel일 경우
								dgEdiVO.setTransType("AC");
							}
							updateDgEdiVO.add(dgEdiVO);
							
						}
					}
				} // end for(i)
				
				
				String preFirstMsnNo = "";
				String currFirstMsnNo = "";
				
				// 업데이트일경우 - First_Ref_No별 업데이트 flatfile 나누기
				int updateDgEdiVOMaxSize = updateDgEdiVO.size();
				List<DgEdiVO> updateTmpDgEdiVO = new ArrayList<DgEdiVO>();
				
				for(int i = 0; i < updateDgEdiVOMaxSize; i++) {
					dgEdiVO = updateDgEdiVO.get(i);
					
					currFirstMsnNo = dgEdiVO.getFirstMsgSndNo();
					
					if(!preFirstMsnNo.equals(currFirstMsnNo)) {
						
						if(!preFirstMsnNo.equals("")) {
							updateDgEdiVOList.add(updateTmpDgEdiVO);
							updateTmpDgEdiVO = new ArrayList<DgEdiVO>();
						}
						
					} 
					
					dgEdiVO.setTransType("U");
					updateTmpDgEdiVO.add(dgEdiVO);
					
					preFirstMsnNo = currFirstMsnNo;
					
					if(i == updateDgEdiVOMaxSize - 1) { // 맨 마지막이면 무조건 list에 add한다.
						updateDgEdiVOList.add(updateTmpDgEdiVO);
					}

				} // end for(i)

				// Update 전송
				List<DgEdiVO> updateVO = null;
				if(updateDgEdiVOList != null && updateDgEdiVOList.size() > 0) {
					
					for(int i =0; i < updateDgEdiVOList.size(); i++) {
						updateVO = (List<DgEdiVO>) updateDgEdiVOList.get(i);
						
						updateFlatFile = this.sendFlatFile(updateVO, account);
						
						updateFlatFileList.add(updateFlatFile);
					}
				}
				
				// Original 전송
				if(originalDgEdiVO != null && originalDgEdiVO.size() > 0) {
					originalFlatFile = this.sendFlatFile(originalDgEdiVO, account);
				}

				// Cancel 전송
				if(cancelDgEdiVO != null && cancelDgEdiVO.size() > 0) {
					cancelFlatFile = this.sendFlatFile(cancelDgEdiVO, account);
				}
				
				retList.add(originalFlatFile);
				
				// 리턴 FF에 구분선 넣어주기
//				updateFlatFile = "";
				StringBuffer updateFlatFileSP = new StringBuffer();
				for(int i =0; i < updateFlatFileList.size(); i++) {
					updateFlatFileSP.append("[").append(i+1).append("]===============================\n");
					updateFlatFileSP.append(updateFlatFileList.get(i));
				}
				
				retList.add(updateFlatFileSP.toString());
				retList.add(cancelFlatFile);
				
			} catch (EventException ex) {
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
	            log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			}

			
			return retList;
		}

		/**
		 * FlatFile을 생성한다.<br>
		 * 
		 * @param dgEdiVOs
		 * @param account
		 * @return
		 * @throws EventException
		 */
		private String sendFlatFile(List<DgEdiVO> dgEdiVOs, SignOnUserAccount account) throws EventException {
//		private String sendFlatFile(DgEdiVO dgEdiVO, SignOnUserAccount account) throws EventException {
			
			StringBuffer flatFile = null;
			String header = "";
			
			String sndId = "SMLM";
			String rcvId = "POMC";
			String msgId = "IFTDGN";
			
			BookingUtil command = null;
			DgEdiVO dgEdiVO = null;
			DeclBaseInfoVO declBaseInfoVO = null;
			BlInfoVO blInfoVO = null;
			List<BlInfoVO> blInfoVOs = null;
			EqInfoVO eqInfoVO = null;
			List<EqInfoVO> eqInfoVOs = null;
			
			ItemInfoVO itemInfoVO = null;
			List<ItemInfoVO> itemInfoVOs = null;
			
			DgSendHistoryVO dgSendHistoryVO = null;
			DgSendDtlHistoryVO dgSendDtlHistoryVO =null;
			List<DgSendDtlHistoryVO> dgSendDtlHistoryVOs = new ArrayList<DgSendDtlHistoryVO>();
			
	
			String  vvdCd = "";
			String  portCd= "";

			try{
				
				flatFile = new StringBuffer();
				command = new BookingUtil();
				
				/*
				 * flat file 생성
				 */
				
				
				if(dgEdiVOs != null && dgEdiVOs.size() > 0) {

					// header
					header = command.searchCstmsEdiHeader(sndId, rcvId, msgId);
					flatFile.append(header).append("\n");

					dgEdiVO = dgEdiVOs.get(0);
					dgEdiVO.setOfcCd(account.getOfc_cd());
					vvdCd = dgEdiVO.getVvdCd();
					portCd = dgEdiVO.getPortCd();
					
							
					// 기본정보
					declBaseInfoVO = dbDao.searchDeclBaseInfo(dgEdiVO);
				
					flatFile.append("DOC_CD:").append(declBaseInfoVO.getDocCd()).append("\n");
					flatFile.append("DOC_NO:").append(declBaseInfoVO.getDocNo()).append("\n");
					
					if(declBaseInfoVO.getSendType().equals("O")){
						flatFile.append("MSG_FUNC:").append("9").append("\n");
					}else{
						flatFile.append("MSG_FUNC:").append("5").append("\n");
					}
					flatFile.append("MSG_DATE:").append(declBaseInfoVO.getMsgDate()).append("\n");
					
					
					if(declBaseInfoVO.getHandling().equals("D")){
						flatFile.append("HANDLING:").append("LDI").append("\n");
					}else if(declBaseInfoVO.getHandling().equals("L")){
						flatFile.append("HANDLING:").append("LLO").append("\n");
					}else{
						flatFile.append("HANDLING:").append("T").append("\n");
					}
					//flatFile.append("HANDLING:").append(declBaseInfoVO.getHandling()).append("\n");
					flatFile.append("REF_NO:").append(declBaseInfoVO.getRefNo()).append("\n");
				
					
					// 배정보 => 반복 no
					flatFile.append("{TRANSPORT").append("\n");
					flatFile.append("TRANS_STAGE:").append(declBaseInfoVO.getTransStage()).append("\n");
					flatFile.append("VOYAGE_NO:").append(declBaseInfoVO.getVoyageNo()).append("\n");
					flatFile.append("TRANS_MODE:").append(declBaseInfoVO.getTransMode()).append("\n");
					flatFile.append("IMO_NO:").append(declBaseInfoVO.getImoNo()).append("\n");
					flatFile.append("VESSEL_NM:").append(declBaseInfoVO.getVesselNm()).append("\n");
					flatFile.append("}TRANSPORT").append("\n");
					
					// 고객 정보 => 반복 yes (화주별 반복)
			
					
					//{MSG_PARTY 부분 
					flatFile.append("{MSG_PARTY").append("\n");
					flatFile.append("PARTY_TYPE:").append(declBaseInfoVO.getPartyType()).append("\n");
					flatFile.append("CARRIER_NM:").append(declBaseInfoVO.getCarrierNm()).append("\n");
					flatFile.append("DEPT_EMPLOY:").append(account.getUsr_nm()).append("\n");
					flatFile.append("COM_NO:").append(account.getUsr_eml()).append("\n");
					flatFile.append("COM_CH:").append(declBaseInfoVO.getComCh()).append("\n");
					flatFile.append("}MSG_PARTY").append("\n");
					
					
					
					/* Send Master log VO 셋팅 */
					dgSendHistoryVO = new DgSendHistoryVO();
					dgSendHistoryVO.setEdiMsgTpId("IFD");
					dgSendHistoryVO.setMsgSndNo(declBaseInfoVO.getDocNo());
					dgSendHistoryVO.setSndUsrId(account.getUsr_id());
					dgSendHistoryVO.setAutoSndTpCd("M");
					dgSendHistoryVO.setDgDeclTpCd(declBaseInfoVO.getHandling());
					dgSendHistoryVO.setVvdCd(vvdCd);
					dgSendHistoryVO.setPortCd(portCd);
					dgSendHistoryVO.setCreUsrId(account.getUsr_id());
					dgSendHistoryVO.setUpdUsrId(account.getUsr_id());	
					dgSendHistoryVO.setMsgFuncId(declBaseInfoVO.getSendType());
				
					
				
					
					
					
					//{EQ_INFO 부분			
					eqInfoVOs = dbDao.searchEqInfo(dgEdiVO);
					if(eqInfoVOs != null ){
					for(int j = 0; j < eqInfoVOs.size(); j ++  ){
						eqInfoVO	= eqInfoVOs.get(j);
						
							flatFile.append("{EQ_INFO").append("\n");
								flatFile.append("EQ_NO:").append(eqInfoVO.getEqNo()).append("\n");
								flatFile.append("EQ_TYPE:").append(eqInfoVO.getEqType()).append("\n");
								flatFile.append("FM_IND:").append(eqInfoVO.getFmInd()).append("\n");
							flatFile.append("}EQ_INFO").append("\n");
						}//end for(j)
					} // END EQ INFO
					
					
						
					blInfoVOs = dbDao.searchBlInfo(dgEdiVO);
					if(blInfoVOs != null ){
					for(int k = 0;k< blInfoVOs.size();k++  ){
						blInfoVO	= blInfoVOs.get(k);
						
							flatFile.append("{BL_INFO").append("\n");
								flatFile.append("CONSOL_NO:").append(k+1).append("\n");
								flatFile.append("SHIPPING_REF:").append(blInfoVO.getBlNo()).append("\n");
								flatFile.append("BLPOL:").append(blInfoVO.getPolCd()).append("\n");
								flatFile.append("BLPOD:").append(blInfoVO.getPodCd()).append("\n");
								
								//---------
								itemInfoVOs = dbDao.searchItemInfo(blInfoVO);
								if(itemInfoVOs != null ){
								for(int m = 0;m< itemInfoVOs.size();m++  ){
									itemInfoVO	= itemInfoVOs.get(m);
								
									flatFile.append("{ITEM_INFO").append("\n");
										flatFile.append("ITEM_NO:").append(m+1).append("\n");
										flatFile.append("OUTPKG_QTY:").append(itemInfoVO.getOutpkgQty()).append("\n");
										flatFile.append("OUTPKG_TP_ID:").append(itemInfoVO.getOutpkgTpId()).append("\n");
										flatFile.append("OUTPKG_TP:").append(itemInfoVO.getOutpkgTp()).append("\n");
										flatFile.append("INPKG_QTY:").append(itemInfoVO.getInpkgQty()).append("\n");
										flatFile.append("INPKG_TP:").append(itemInfoVO.getInpkgTp()).append("\n");
										flatFile.append("STORAGE:").append(itemInfoVO.getStorAge()).append("\n");
										flatFile.append("PARTY1:").append(itemInfoVO.getParty1()).append("\n");
										flatFile.append("PARTY2:").append(itemInfoVO.getParty2()).append("\n");
										flatFile.append("PARTY3:").append(itemInfoVO.getParty3()).append("\n");
										flatFile.append("PARTY4:").append(itemInfoVO.getParty4()).append("\n");
										flatFile.append("PARTY5:").append(itemInfoVO.getParty5()).append("\n");
										flatFile.append("DG_CD:").append(itemInfoVO.getDgCd()).append("\n");
										flatFile.append("IMDG_CLASS:").append(itemInfoVO.getImdgClass()).append("\n");
										flatFile.append("UNDG_NO:").append(itemInfoVO.getUnNo()).append("\n");
										flatFile.append("FLASH:").append(itemInfoVO.getFlash()).append("\n");
										flatFile.append("FLASH_UNIT:").append(itemInfoVO.getFlashUnit()).append("\n");
										flatFile.append("PKG_GRP:").append(itemInfoVO.getPkgGroup()).append("\n");
										flatFile.append("EMS_NO:").append(itemInfoVO.getEmsNo()).append("\n");
										flatFile.append("MFAG:").append(itemInfoVO.getMfag()).append("\n");
										flatFile.append("SHIPPING_NAME:").append(itemInfoVO.getShippingName()).append("\n");
										flatFile.append("NET_UNIT:").append(itemInfoVO.getNetwgtUnit()).append("\n");
										flatFile.append("NET_WGT:").append(itemInfoVO.getNetwgt()).append("\n");
										flatFile.append("GROSS_UNIT:").append(itemInfoVO.getGrosswgtUnit()).append("\n");
										flatFile.append("GROSS_WGT:").append(itemInfoVO.getGrosswgt()).append("\n");
										flatFile.append("NEQ_UNIT:").append(itemInfoVO.getNeqwgtUnit()).append("\n");
										flatFile.append("NEQ:").append(itemInfoVO.getNeqwgt()).append("\n");
										flatFile.append("CNTR_NO:").append(itemInfoVO.getCntrNo()).append("\n");
//										flatFile.append("STOW_LOC:").append(itemInfoVO.getStowLoc()).append("\n");
									flatFile.append("}ITEM_INFO").append("\n");
			
								
									/* send log detail VO 저장 */
									dgSendDtlHistoryVO = new DgSendDtlHistoryVO();
									dgSendDtlHistoryVO.setEdiMsgTpId("IFD");
									dgSendDtlHistoryVO.setMsgSndNo(declBaseInfoVO.getDocNo());
									dgSendDtlHistoryVO.setBlNo(itemInfoVO.getShippingRef());
									dgSendDtlHistoryVO.setCntrNo(itemInfoVO.getCntrNo());
									dgSendDtlHistoryVO.setCntrCgoSeq(Integer.toString(m+1));
									dgSendDtlHistoryVO.setDgBlRefNo("");
									dgSendDtlHistoryVO.setDgItmRefNo("");
									dgSendDtlHistoryVO.setCreUsrId(account.getUsr_id());
									dgSendDtlHistoryVO.setUpdUsrId(account.getUsr_id());

									dgSendDtlHistoryVOs.add(dgSendDtlHistoryVO);
									}
								} // END ITEM INFO
					
								// -----

							flatFile.append("}BL_INFO").append("\n");
			
						}//end for(k)
					
					} // END BL INFO
						
					dgSendHistoryVO.setMsgDesc(flatFile.toString());
						//send 테이블
					if(dgSendHistoryVO != null) {
						dbDao.addSendLog(dgSendHistoryVO);
					}
					// 전송로그를 저장한다. (DETAIL) - Auto Cancel이 아닌 경우만 response 테이블
					if(dgSendDtlHistoryVOs != null && dgSendDtlHistoryVOs.size() > 0) {
						dbDao.addSendDtlLog(dgSendDtlHistoryVOs);
					}
					
	
				
				// MQ로 전송한다.
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_AUSMF.IBMMQ.QUEUE")); 
				
				
				FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
				
				if ( flatFileAckVO.getAckStsCd().equals("E") ) {
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				}
				
			}
		
			} catch (EventException ee) {
	            log.error("err " + ee.toString(), ee);
				throw ee;
			} catch (DAOException ex) {
	            log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			} catch (Exception ex) {
	            log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			}

			
			return flatFile.toString();		
		}
	    
		
		
//	    /**
//	     * 호주 1512팝업 Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
//	     * 
//	     * @param dgCargoCondVO
//	     * @return DgInqModiVO
//	     * @throws EventException
//	     */
//	    public List<DgInqModiVO> searchDgCargoInfo(DgCargoCondVO dgCargoCondVO) throws EventException { 
//			try {
//				return dbDao.searchDgInfoinquiry(dgCargoCondVO);
//			} catch (DAOException ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			} catch (Exception ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			}
//	    }	
//	    
//	    
//	    /**
//		 * 호주 1512팝업 위험물 상세 정보들을 수정+저장한다.<br>
//		 * 
//		 * @param  DgInqModiVO dgInqModiVO
//		 * @param  SignOnUserAccount account
//		 * @throws EventException
//		 */
//	    public void modifyDgInquiry(DgInqModiVO dgInqModiVO, SignOnUserAccount account) throws EventException {
//	    	
//			try {
//
//				if(dgInqModiVO != null) {
//					dgInqModiVO.setCreUsrId(account.getUsr_id());
//					dgInqModiVO.setUpdUsrId(account.getUsr_id());
//					
//					dbDao.modifyDgInqBySeq(dgInqModiVO);
//				}
//				
//				
//			} catch (DAOException ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
//			} catch (Exception ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
//			}
//		
//	    }
//	    
//	    
//	    /**
//	     * 호주 1512팝업 DG: 	Forward Code로 Forward Name을 조회한다.<br>
//	     * 
//	     * @param dgListCondVO
//	     * @return
//	     * @throws EventException
//	     */
//	    public String searchForwarderName(DgListCondVO dgListCondVO) throws EventException { 
//			try {
//				return dbDao.searchForwarderNameByCd(dgListCondVO);
//			} catch (DAOException ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			} catch (Exception ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			}
//	    }	
//	    
//	    
//	    /**
//	     * 호주 1512팝업 DG: UN NO로 NAME을 조회한다.<br>
//	     * 
//	     * @param dgListCondVO
//	     * @return
//	     * @throws EventException
//	     */
//	    public String searchUnnoName(DgListCondVO dgListCondVO) throws EventException { 
//			try {
//				return dbDao.searchUnnoNameByCd(dgListCondVO);
//			} catch (DAOException ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			} catch (Exception ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			}
//	    }
//	    
//	    /**
//		 *호주 1512팝업 DG: Feeder Name, Lloyd No를 조회한다.<br>
//	     * 
//		 * @return List<FeederNameVO>
//	     * @throws EventException
//	     */
//	    public List<FeederNameVO> searchDgFeederNameList() throws EventException { 
//			try {
//				return dbDao.searchDgFeederNameList();
//			} catch (DAOException ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			} catch (Exception ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			}
//	    }
//	    
//	    /**
//	     * 호주 1512팝업 DG: 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
//	     * 
//	     * @param dgCargoCondVO
//	     * @return List<DgCntrInfoListVO>
//	     * @throws EventException
//	     */
//	    public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws EventException { 
//			try {
//				return dbDao.searchCntrInfoListByBl(dgCargoCondVO);
//			} catch (DAOException ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			} catch (Exception ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			}
//	    }
//	    
//	    /**
//	     * 호주 1512팝업 DG: 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
//	     * 
//	     * @param dgCargoCondVO
//	     * @return List<DgCntrInfoListVO>
//	     * @throws EventException
//	     */
//	    public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws EventException { 
//			try {
//				return dbDao.searchCgoSeqListByCntr(dgCargoCondVO);
//			} catch (DAOException ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			} catch (Exception ex) {
//	            log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
//			}
//	    }
	    
	    

	    
	    
	
}