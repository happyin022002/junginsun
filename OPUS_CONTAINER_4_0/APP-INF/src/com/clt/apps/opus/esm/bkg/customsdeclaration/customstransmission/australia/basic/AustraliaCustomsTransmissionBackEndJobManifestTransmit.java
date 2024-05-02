/*=========================================================
*Copyright(c) CyberLogitec
*@FileName : AustraliaCustomsTransmissionBackEndJob.java
*@FileTitle :
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
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration.AusCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlCharegeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlChargeTotalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlGeneralForMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlGeneralForPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchBlVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchContainerDangerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchContainerDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchContainerForMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchContainerForPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchMakeHeaderMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchMakeHeaderPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchVesselForMVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchVesselForPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchVslPortSkdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AustraliaManifestTransmitVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.syscommon.common.table.MdmVslCntrVO;


/**
 * OPUS-Terminaldocumentation Business Logic Command Interface<br>
 * - OPUS-Terminaldocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seung Min
 * @see Esm_bkg_0930EventResponse 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AustraliaCustomsTransmissionBackEndJobManifestTransmit extends BackEndCommandSupport{
	private AustraliaManifestTransmitVO[] inputManifestTransmitVOs;
	// Database Access Object
	private AusCustomsTransmissionDBDAO dbDao = new AusCustomsTransmissionDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param AustraliaManifestTransmitVO[] australiaManifestTransmitVOs
	 */
	public void setAustraliaManifestTransmitVOs(AustraliaManifestTransmitVO[] australiaManifestTransmitVOs) {
		if (australiaManifestTransmitVOs != null) {
			AustraliaManifestTransmitVO[] tmpVOs = Arrays.copyOf(australiaManifestTransmitVOs, australiaManifestTransmitVOs.length);
			this.inputManifestTransmitVOs = tmpVOs;
		}
	}

	/**
	 * Back End Job Result
	 * 
	 * @return String
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public String doStart() throws Exception {
		AustraliaManifestTransmitVO[] australiaManifestTransmitVOs = this.inputManifestTransmitVOs;

		BookingUtil command = new BookingUtil();
		StringBuilder flatFile = new StringBuilder();

		AustraliaManifestTransmitVO australiaManifestTransmitVO = australiaManifestTransmitVOs[0];
		List<AusSearchMakeHeaderMVO> ausSearchMakeHeaderMVOList = new ArrayList<AusSearchMakeHeaderMVO>();
		List<AusSearchMakeHeaderPVO> ausSearchMakeHeaderPVOList = new ArrayList<AusSearchMakeHeaderPVO>();
		List<MdmVslCntrVO> mdmVslCntrVOList = new ArrayList<MdmVslCntrVO>();
		List<AusSearchVslPortSkdVO> ausSearchVslPortSkdVOList = new ArrayList<AusSearchVslPortSkdVO>();
		List<AusSearchVesselForMVO> ausSearchVesselForMVO = new ArrayList<AusSearchVesselForMVO>();
		List<AusSearchVesselForPVO> ausSearchVesselForPVO = new ArrayList<AusSearchVesselForPVO>();
		List<AusSearchBlGeneralForMVO> ausSearchBlGeneralForMVO = new ArrayList<AusSearchBlGeneralForMVO>();
		List<AusSearchBlGeneralForPVO> ausSearchBlGeneralForPVO = new ArrayList<AusSearchBlGeneralForPVO>();

		List<AusSearchBlCharegeVO> ausSearchBlCharegeVO = new ArrayList<AusSearchBlCharegeVO>();
		List<AusSearchBlChargeTotalVO> ausSearchBlChargeTotalVO = new ArrayList<AusSearchBlChargeTotalVO>();
		List<AusSearchBlMarkDescVO> ausSearchBlMarkDescVO = new ArrayList<AusSearchBlMarkDescVO>();
		List<AusSearchContainerForMVO> ausSearchContainerForMVO = new ArrayList<AusSearchContainerForMVO>();
		List<AusSearchContainerForPVO> ausSearchContainerForPVO = new ArrayList<AusSearchContainerForPVO>();
		List<AusSearchContainerDangerVO> ausSearchContainerDangerVO = new ArrayList<AusSearchContainerDangerVO>();
		List<AusSearchContainerDescVO> ausSearchContainerDescVO = new ArrayList<AusSearchContainerDescVO>();
		List<AusSearchBlQtyVO> ausSearchBlQtyVO = new ArrayList<AusSearchBlQtyVO>();
		List<AusSearchBlVvdVO> ausSearchBlVvdVO = new ArrayList<AusSearchBlVvdVO>();

		try {
			if (australiaManifestTransmitVO != null) {

				String vvd = (australiaManifestTransmitVO.getVslCd() + australiaManifestTransmitVO.getSkdVoyNo() + australiaManifestTransmitVO.getSkdDirCd());

				if (australiaManifestTransmitVO.getTransGubun().equalsIgnoreCase("A")) {
					// Manifest B/L General
					ausSearchBlGeneralForMVO = dbDao.searchBlGeneralForM(australiaManifestTransmitVO);
					if (ausSearchBlGeneralForMVO == null || ausSearchBlGeneralForMVO.size() < 1) {
						// [BKG08232] - There is no data to transmit!
						throw new EventException(new ErrorHandler("BKG08232").getMessage());
					}

					ausSearchMakeHeaderMVOList = dbDao.searchMakerHeaderM();
					flatFile.append(ausSearchMakeHeaderMVOList.get(0).getMsgHeader()).append("\n");
					// Vessel Info
					ausSearchVesselForMVO = dbDao.searchVesselForM(australiaManifestTransmitVO);
					if (ausSearchVesselForMVO != null && ausSearchVesselForMVO.size() > 0) {
						flatFile.append("VVD:").append(ausSearchVesselForMVO.get(0).getVvdNumber()).append("\n");
					}
					// Vessel VVD Info
					mdmVslCntrVOList = dbDao.searchMdmVslCntrByVslCd(australiaManifestTransmitVO.getVslCd());
					if (mdmVslCntrVOList != null && mdmVslCntrVOList.size() > 0) {
						flatFile.append("VSL_CALLSIGN:").append(mdmVslCntrVOList.get(0).getCallSgnNo()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(mdmVslCntrVOList.get(0).getLloydNo()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(mdmVslCntrVOList.get(0).getVslEngNm()).append("\n");
						flatFile.append("MSG_FUNC:").append(australiaManifestTransmitVO.getEdiInd()).append("\n");
					}
					// Vessel Estimated Date
					ausSearchVslPortSkdVOList = dbDao.searchVskVslPortSkd(vvd, australiaManifestTransmitVO.getPortCd());
					if (ausSearchVslPortSkdVOList != null && ausSearchVslPortSkdVOList.size() > 0) {
						flatFile.append("ETA:").append(ausSearchVslPortSkdVOList.get(0).getVpsEtaDt()).append("\n");
						flatFile.append("ETD:").append(ausSearchVslPortSkdVOList.get(0).getVpsEtdDt()).append("\n");
					}
					// Manifest B/L General
					for (int i=0; i<ausSearchBlGeneralForMVO.size(); i++) {
						flatFile.append("{BL_INFO").append("\n");
						australiaManifestTransmitVO.setBkgCgoTp(ausSearchBlGeneralForMVO.get(i).getBkgCgoTpCd());
						australiaManifestTransmitVO.setBkgSpeRf(ausSearchBlGeneralForMVO.get(i).getBkgSpeRf());
						australiaManifestTransmitVO.setBkgSpeDg(ausSearchBlGeneralForMVO.get(i).getBkgSpeDg());
						australiaManifestTransmitVO.setBkgSpeAk(ausSearchBlGeneralForMVO.get(i).getBkgSpeAk());
						australiaManifestTransmitVO.setBkgSpeBb(ausSearchBlGeneralForMVO.get(i).getBkgSpeBb());
						australiaManifestTransmitVO.setCmdtDesc(ausSearchBlGeneralForMVO.get(i).getCmdtDesc());
						australiaManifestTransmitVO.setCmdtCd(ausSearchBlGeneralForMVO.get(i).getCmdtCd());
						australiaManifestTransmitVO.setBkgSpeRd(ausSearchBlGeneralForMVO.get(i).getBkgSpeRd());

						flatFile.append("BLNBR:").append(ausSearchBlGeneralForMVO.get(i).getBlnbr()).append("\n");
						flatFile.append("BKGNBR:").append(ausSearchBlGeneralForMVO.get(i).getBkgnbr()).append("\n");
						flatFile.append("BLPOL:").append(ausSearchBlGeneralForMVO.get(i).getBlpol()).append("\n");
						flatFile.append("BLPOD:").append(ausSearchBlGeneralForMVO.get(i).getBlpod()).append("\n");
						flatFile.append("BLPOR:").append(ausSearchBlGeneralForMVO.get(i).getBlpor()).append("\n");
						flatFile.append("BLDEL:").append(ausSearchBlGeneralForMVO.get(i).getBldel()).append("\n");
						flatFile.append("BLRLY:").append(ausSearchBlGeneralForMVO.get(i).getBlrly()).append("\n");
						flatFile.append("BLPLACE:").append(ausSearchBlGeneralForMVO.get(i).getBlplace()).append("\n");
						flatFile.append("BLDATE:").append(ausSearchBlGeneralForMVO.get(i).getBldate()).append("\n");
						flatFile.append("CUST_CD:").append(ausSearchBlGeneralForMVO.get(i).getCustCd()).append("\n");
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
						flatFile.append("CARGOTYPE:").append(ausSearchBlGeneralForMVO.get(i).getCargotype()).append("\n");
						flatFile.append("COMMODITY:").append(ausSearchBlGeneralForMVO.get(i).getCommodity()).append("\n");
						flatFile.append("REMARK:").append(ausSearchBlGeneralForMVO.get(i).getXterRmk()).append("\n");
						flatFile.append("AUS_QUAR:").append(ausSearchBlGeneralForMVO.get(i).getAusQuar()).append("\n");
						flatFile.append("FRT_IND:").append(ausSearchBlGeneralForMVO.get(i).getFrtInd()).append("\n");
						flatFile.append("CUSTOMS_DESC:").append(ausSearchBlGeneralForMVO.get(i).getCstmsDesc()).append("\n");
						australiaManifestTransmitVO.setBkgNo(ausSearchBlGeneralForMVO.get(i).getBkgNo());
						ausSearchBlCharegeVO = dbDao.searchBlCharge(australiaManifestTransmitVO);
						// Manifest B/L Charge
						if (ausSearchBlCharegeVO != null) {
							for (int j = 0; j < ausSearchBlCharegeVO.size(); j++) {
								flatFile.append("{CHARGE").append("\n");
								flatFile.append("FCTYPE:").append(ausSearchBlCharegeVO.get(j).getFctype()).append("\n");
								flatFile.append("RATE:").append(ausSearchBlCharegeVO.get(j).getRate()).append("\n");
								flatFile.append("REVENUETON:").append(ausSearchBlCharegeVO.get(j).getRevenueton()).append("\n");
								flatFile.append("PPD:").append(ausSearchBlCharegeVO.get(j).getPpd()).append("\n");
								flatFile.append("CCT:").append(ausSearchBlCharegeVO.get(j).getCct()).append("\n");
								flatFile.append("CURRENCYCODE:").append(ausSearchBlCharegeVO.get(j).getCurrencycode()).append("\n");
								flatFile.append("TARIFF:").append(ausSearchBlCharegeVO.get(j).getTariff()).append("\n");
								flatFile.append("PERTYPE:").append(ausSearchBlCharegeVO.get(j).getPertype()).append("\n");
								flatFile.append("}CHARGE").append("\n");
							}
						}
						// Manifest B/L Charge Total
						ausSearchBlChargeTotalVO = dbDao.searchBlChargeTotal(australiaManifestTransmitVO);
						if (ausSearchBlChargeTotalVO != null) {
							for (int j = 0; j < ausSearchBlChargeTotalVO.size(); j++) {
								flatFile.append("{CHARGE_TTL").append("\n");
								flatFile.append("PPD_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getPpdTotal()).append("\n");
								flatFile.append("CCT_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getCctTotal()).append("\n");
								flatFile.append("TOTAL_CUR:").append(ausSearchBlChargeTotalVO.get(j).getTotalCur()).append("\n");
								flatFile.append("}CHARGE_TTL").append("\n");
							}
						}
						// Manifest B/L Mark Description
						ausSearchBlMarkDescVO = dbDao.searchBlMarksDesc(australiaManifestTransmitVO);
						if (ausSearchBlMarkDescVO != null) {
							for (int j = 0; j < ausSearchBlMarkDescVO.size(); j++) {
								StringTokenizer token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getCmdtDesc(), "\n");
								ArrayList tmpArray = new ArrayList();
								while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
								if (tmpArray.size() > 0) flatFile.append("{DESC").append("\n");
								for (int mm = 0; mm < tmpArray.size(); mm++) {
									flatFile.append("DESC:").append(tmpArray.get(mm).toString());
									flatFile.append("\n");
								}
								if (tmpArray.size() > 0) flatFile.append("}DESC").append("\n");
								token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getMkDesc(), "\n");
								tmpArray = new ArrayList();
								while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
								if (tmpArray.size() > 0) flatFile.append("{MARK").append("\n");
								for (int mm = 0; mm < tmpArray.size(); mm++) {
									flatFile.append("MARKNO:").append(tmpArray.get(mm).toString());
									flatFile.append("\n");
								}
								if (tmpArray.size() > 0) flatFile.append("}MARK").append("\n");
							}
						}
						// Manifest Container
						ausSearchContainerForMVO = dbDao.searchContainerForM(australiaManifestTransmitVO);
						if (ausSearchContainerForMVO != null) {
							for (int k = 0; k < ausSearchContainerForMVO.size(); k++) {
								flatFile.append("{CNTR_INFO").append("\n");
								australiaManifestTransmitVO.setCntrNo(ausSearchContainerForMVO.get(k).getCntrNo());
								flatFile.append("CNTRNBR:").append(ausSearchContainerForMVO.get(k).getCntrnbr()).append("\n");
								flatFile.append("PUNIT:").append(ausSearchContainerForMVO.get(k).getPunit()).append("\n");
								flatFile.append("PKG:").append(ausSearchContainerForMVO.get(k).getPkg()).append("\n");
								flatFile.append("CNTRWGT:").append(ausSearchContainerForMVO.get(k).getCntrwgt()).append("\n");
								flatFile.append("CNTRTYPE:").append(ausSearchContainerForMVO.get(k).getCntrtype()).append("\n");
								flatFile.append("SEALNBR:").append(ausSearchContainerForMVO.get(k).getSealnbr()).append("\n");
								flatFile.append("SOC_IND:").append(ausSearchContainerForMVO.get(k).getSocInd()).append("\n");
								flatFile.append("FM_IND:").append(ausSearchContainerForMVO.get(k).getFmInd()).append("\n");
								flatFile.append("RF_IND:").append(ausSearchContainerForMVO.get(k).getRfInd()).append("\n");
								flatFile.append("DG_IND:").append(ausSearchContainerForMVO.get(k).getDgInd()).append("\n");
								flatFile.append("AK_IND:").append(ausSearchContainerForMVO.get(k).getAkInd()).append("\n");
								flatFile.append("BK_IND:").append(ausSearchContainerForMVO.get(k).getBkInd()).append("\n");
								flatFile.append("TEMP:").append(ausSearchContainerForMVO.get(k).getTemp()).append("\n");
								flatFile.append("TUNIT:").append(ausSearchContainerForMVO.get(k).getTunit()).append("\n");
								flatFile.append("HUMIDITY:").append(ausSearchContainerForMVO.get(k).getHumidity()).append("\n");
								flatFile.append("VENT:").append(ausSearchContainerForMVO.get(k).getVent()).append("\n");
								flatFile.append("MEASURE:").append(ausSearchContainerForMVO.get(k).getMeasure()).append("\n");
								flatFile.append("RDTYPE:").append(ausSearchContainerForMVO.get(k).getRdtype()).append("\n");
								flatFile.append("CMDT_DESC:").append(ausSearchContainerForMVO.get(k).getCmdtDesc()).append("\n");
								flatFile.append("CMDTCD:").append(ausSearchContainerForMVO.get(k).getCmdtcd());
								flatFile.append("RF_REMARK:").append(ausSearchContainerForMVO.get(k).getRfRemark()).append("\n");
								flatFile.append("RFDRY_IND:").append(ausSearchContainerForMVO.get(k).getRfdryInd()).append("\n");
								flatFile.append("OVF:").append(ausSearchContainerForMVO.get(k).getOvf()).append("\n");
								flatFile.append("OVR:").append(ausSearchContainerForMVO.get(k).getOvr()).append("\n");
								flatFile.append("OVH:").append(ausSearchContainerForMVO.get(k).getOvh()).append("\n");
								flatFile.append("OVLW:").append(ausSearchContainerForMVO.get(k).getOvlw()).append("\n");
								flatFile.append("OVRW:").append(ausSearchContainerForMVO.get(k).getOvrw()).append("\n");
								flatFile.append("OVWGT:").append(ausSearchContainerForMVO.get(k).getOvwgt()).append("\n");
								flatFile.append("VOID_SLOT:").append(ausSearchContainerForMVO.get(k).getVoidSlot()).append("\n");
								flatFile.append("STWG_REQ:").append(ausSearchContainerForMVO.get(k).getStwgReq()).append("\n");
								// Manifest Container Danger
								ausSearchContainerDangerVO = dbDao.searchContainerDanger(australiaManifestTransmitVO);
								if (ausSearchContainerDangerVO != null) {
									for (int kk=0; kk<ausSearchContainerDangerVO.size(); kk++) {
										flatFile.append("{CNTR_DANGER").append("\n");
										flatFile.append("UNNBR:").append(ausSearchContainerDangerVO.get(kk).getUnnbr()).append("\n");
										flatFile.append("CLASS:").append(ausSearchContainerDangerVO.get(kk).getImdgClass()).append("\n");
										flatFile.append("DESC:").append(ausSearchContainerDangerVO.get(kk).getShpNm()).append("\n");
										flatFile.append("PHONE:").append(ausSearchContainerDangerVO.get(kk).getPhone()).append("\n");
										flatFile.append("PAGE:").append(ausSearchContainerDangerVO.get(kk).getPageList()).append("\n");
										flatFile.append("FLSH_TEMP:").append(ausSearchContainerDangerVO.get(kk).getFlshTemp()).append("\n");
										flatFile.append("FLSH_UNIT:").append(ausSearchContainerDangerVO.get(kk).getFlshUnit()).append("\n");
										flatFile.append("DG_REMARK:").append(ausSearchContainerDangerVO.get(kk).getDgRemark()).append("\n");
										flatFile.append("}CNTR_DANGER").append("\n");
									}
								}
								// Manifest Container Description
								ausSearchContainerDescVO = dbDao.searchContainerDesc(australiaManifestTransmitVO);
								if (ausSearchContainerDescVO != null) {
									for (int kk=0; kk<ausSearchContainerDescVO.size(); kk++) {
										flatFile.append("{CNTR_DESC").append("\n");
										flatFile.append("D_CMDT:").append(ausSearchContainerDescVO.get(kk).getDCmdt()).append("\n");
										flatFile.append("D_PUNIT:").append(ausSearchContainerDescVO.get(kk).getDPunit()).append("\n");
										flatFile.append("D_PKG:").append(ausSearchContainerDescVO.get(kk).getDPkg()).append("\n");
										flatFile.append("D_WGT:").append(ausSearchContainerDescVO.get(kk).getDWgt()).append("\n");
										flatFile.append("D_MEAS:").append(ausSearchContainerDescVO.get(kk).getDMeas()).append("\n");
										flatFile.append("D_DESC:").append(ausSearchContainerDescVO.get(kk).getDDesc()).append("\n");
										StringTokenizer token = new StringTokenizer(ausSearchContainerDescVO.get(kk).getDMark(), "\n");
										ArrayList tmpArray = new ArrayList();
										while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
										if (tmpArray.size() > 0) flatFile.append("{CUS_MARK").append("\n");
										for (int mm=0; mm<tmpArray.size(); mm++) {
											flatFile.append("D_MARK:").append(tmpArray.get(mm).toString());
											flatFile.append("\n");
										}
										if (tmpArray.size() > 0) flatFile.append("}CUS_MARK").append("\n");
										flatFile.append("}CNTR_DESC").append("\n");
									}
								}
								flatFile.append("}CNTR_INFO").append("\n");
							}
						}
						// Manifest B/L Qty
						ausSearchBlQtyVO = dbDao.searchBlQty(australiaManifestTransmitVO);
						if (ausSearchBlQtyVO != null) {
							for (int m=0; m<ausSearchBlQtyVO.size(); m++) {
								flatFile.append("{QTY").append("\n");
								flatFile.append("HANTYPE:").append(ausSearchBlQtyVO.get(m).getHantype()).append("\n");
								flatFile.append("COUNT:").append(ausSearchBlQtyVO.get(m).getCntrQty()).append("\n");
								flatFile.append("}QTY").append("\n");
							}
						}
						// Manifest B/L VVD
						ausSearchBlVvdVO = dbDao.searchBlVvd(australiaManifestTransmitVO);
						if (ausSearchBlVvdVO != null) {
							for (int m=0; m<ausSearchBlVvdVO.size(); m++) {
								flatFile.append("{BKGVVD").append("\n");
								flatFile.append("BVVD:").append(ausSearchBlVvdVO.get(m).getBvvd()).append("\n");
								flatFile.append("BPOL:").append(ausSearchBlVvdVO.get(m).getBpol()).append("\n");
								flatFile.append("BPOD:").append(ausSearchBlVvdVO.get(m).getBpod()).append("\n");
								flatFile.append("}BKGVVD").append("\n");
							}
						}
						flatFile.append("}BL_INFO").append("\n");
					}

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_AUSMF.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00220", new String[] {}).getMessage());

					flatFile = new StringBuilder();
					ausSearchMakeHeaderPVOList = dbDao.searchMakerHeaderP(australiaManifestTransmitVO);
					flatFile.append(ausSearchMakeHeaderPVOList.get(0).getMsgHeader()).append("\n");
					// Vessel Info
					ausSearchVesselForPVO = dbDao.searchVesselForP(australiaManifestTransmitVO);
					if (ausSearchVesselForPVO != null && ausSearchVesselForPVO.size() > 0) {
						flatFile.append("VVD:").append(ausSearchVesselForPVO.get(0).getVvdNumber()).append("\n");
					}
					// Vessel VVD Info
					mdmVslCntrVOList = dbDao.searchMdmVslCntrByVslCd(australiaManifestTransmitVO.getVslCd());
					if (mdmVslCntrVOList != null && mdmVslCntrVOList.size() > 0) {
						flatFile.append("VSL_CALLSIGN:").append(mdmVslCntrVOList.get(0).getCallSgnNo()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(mdmVslCntrVOList.get(0).getLloydNo()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(mdmVslCntrVOList.get(0).getVslEngNm()).append("\n");
						flatFile.append("MSG_FUNC:").append(australiaManifestTransmitVO.getEdiInd()).append("\n");
					}
					// Vessel Estimated Date
					ausSearchVslPortSkdVOList = dbDao.searchVskVslPortSkd(vvd, australiaManifestTransmitVO.getPortCd());
					if (ausSearchVslPortSkdVOList != null && ausSearchVslPortSkdVOList.size() > 0) {
						flatFile.append("ETA:").append(ausSearchVslPortSkdVOList.get(0).getVpsEtaDt()).append("\n");
						flatFile.append("ETD:").append(ausSearchVslPortSkdVOList.get(0).getVpsEtdDt()).append("\n");
					}
					// Manifest B/L General
					ausSearchBlGeneralForPVO = dbDao.searchBlGeneralForP(australiaManifestTransmitVO);
					if (ausSearchBlGeneralForPVO != null && ausSearchBlGeneralForPVO.size() > 0) {
						for (int i = 0; i < ausSearchBlGeneralForPVO.size(); i++) {
							flatFile.append("{BL_INFO").append("\n");
							australiaManifestTransmitVO.setBkgCgoTp(ausSearchBlGeneralForPVO.get(i).getBkgCgoTpCd());
							australiaManifestTransmitVO.setBkgSpeRf(ausSearchBlGeneralForPVO.get(i).getBkgSpeRf());
							australiaManifestTransmitVO.setBkgSpeDg(ausSearchBlGeneralForPVO.get(i).getBkgSpeDg());
							australiaManifestTransmitVO.setBkgSpeAk(ausSearchBlGeneralForPVO.get(i).getBkgSpeAk());
							australiaManifestTransmitVO.setBkgSpeBb(ausSearchBlGeneralForPVO.get(i).getBkgSpeBb());
							australiaManifestTransmitVO.setCmdtDesc(ausSearchBlGeneralForPVO.get(i).getCmdtDesc());
							australiaManifestTransmitVO.setCmdtCd(ausSearchBlGeneralForPVO.get(i).getCmdtCd());
							australiaManifestTransmitVO.setBkgSpeRd(ausSearchBlGeneralForPVO.get(i).getBkgSpeRd());

							flatFile.append("BLNBR:").append(ausSearchBlGeneralForPVO.get(i).getBlnbr()).append("\n");
							flatFile.append("BLPOL:").append(ausSearchBlGeneralForPVO.get(i).getBlpol()).append("\n");
							flatFile.append("BLPOD:").append(ausSearchBlGeneralForPVO.get(i).getBlpod()).append("\n");
							flatFile.append("BLPOR:").append(ausSearchBlGeneralForPVO.get(i).getBlpor()).append("\n");
							flatFile.append("BLDEL:").append(ausSearchBlGeneralForPVO.get(i).getBldel()).append("\n");
							flatFile.append("BLRLY:").append(ausSearchBlGeneralForPVO.get(i).getBlrly()).append("\n");
							flatFile.append("BLPLACE:").append(ausSearchBlGeneralForPVO.get(i).getBlplace()).append("\n");
							flatFile.append("BLDATE:").append(ausSearchBlGeneralForPVO.get(i).getBldate()).append("\n");
							flatFile.append("CUST_CD:").append(ausSearchBlGeneralForPVO.get(i).getCustCd()).append("\n");
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
							flatFile.append("CARGOTYPE:").append(ausSearchBlGeneralForPVO.get(i).getCargotype()).append("\n");
							flatFile.append("COMMODITY:").append(ausSearchBlGeneralForPVO.get(i).getCommodity()).append("\n");
							flatFile.append("REMARK:").append(ausSearchBlGeneralForPVO.get(i).getXterRmk()).append("\n");
							flatFile.append("AUS_QUAR:").append(ausSearchBlGeneralForPVO.get(i).getAusQuar()).append("\n");
							australiaManifestTransmitVO.setBkgNo(ausSearchBlGeneralForPVO.get(i).getBkgNo());
							ausSearchBlCharegeVO = dbDao.searchBlCharge(australiaManifestTransmitVO);
							// Manifest B/L Charge
							if (ausSearchBlCharegeVO != null) {
								for (int j = 0; j < ausSearchBlCharegeVO.size(); j++) {
									flatFile.append("{CHARGE").append("\n");
									flatFile.append("FCTYPE:").append(ausSearchBlCharegeVO.get(j).getFctype()).append("\n");
									flatFile.append("RATE:").append(ausSearchBlCharegeVO.get(j).getRate()).append("\n");
									flatFile.append("REVENUETON:").append(ausSearchBlCharegeVO.get(j).getRevenueton()).append("\n");
									flatFile.append("PPD:").append(ausSearchBlCharegeVO.get(j).getPpd()).append("\n");
									flatFile.append("CCT:").append(ausSearchBlCharegeVO.get(j).getCct()).append("\n");
									flatFile.append("CURRENCYCODE:").append(ausSearchBlCharegeVO.get(j).getCurrencycode()).append("\n");
									flatFile.append("TARIFF:").append(ausSearchBlCharegeVO.get(j).getTariff()).append("\n");
									flatFile.append("PERTYPE:").append(ausSearchBlCharegeVO.get(j).getPertype()).append("\n");
									flatFile.append("}CHARGE").append("\n");
								}
							}
							// Manifest B/L Charge Total
							ausSearchBlChargeTotalVO = dbDao.searchBlChargeTotal(australiaManifestTransmitVO);
							if (ausSearchBlChargeTotalVO != null) {
								for (int j=0; j<ausSearchBlChargeTotalVO.size(); j++) {
									flatFile.append("{CHARGE_TTL").append("\n");
									flatFile.append("PPD_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getPpdTotal()).append("\n");
									flatFile.append("CCT_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getCctTotal()).append("\n");
									flatFile.append("TOTAL_CUR:").append(ausSearchBlChargeTotalVO.get(j).getTotalCur()).append("\n");
									flatFile.append("}CHARGE_TTL").append("\n");
								}
							}
							// Manifest B/L Mark Description
							ausSearchBlMarkDescVO = dbDao.searchBlMarksDesc(australiaManifestTransmitVO);
							if (ausSearchBlMarkDescVO != null) {
								for (int j = 0; j < ausSearchBlMarkDescVO.size(); j++) {
									StringTokenizer token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getCmdtDesc(), "\n");
									ArrayList tmpArray = new ArrayList();
									while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
									if (tmpArray.size() > 0) flatFile.append("{DESC").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("DESC:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0) flatFile.append("}DESC").append("\n");
									token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getMkDesc(), "\n");
									tmpArray = new ArrayList();
									while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
									if (tmpArray.size() > 0) flatFile.append("{MARK").append("\n");
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append("MARKNO:").append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									if (tmpArray.size() > 0) flatFile.append("}MARK").append("\n");
								}
							}
							// Manifest Container
							ausSearchContainerForPVO = dbDao.searchContainerForP(australiaManifestTransmitVO);
							if (ausSearchContainerForPVO != null) {
								for (int k = 0; k < ausSearchContainerForPVO.size(); k++) {
									flatFile.append("{CNTR_INFO").append("\n");
									australiaManifestTransmitVO.setCntrNo(ausSearchContainerForPVO.get(k).getCntrNo());
									flatFile.append("CNTRNBR:").append(ausSearchContainerForPVO.get(k).getCntrnbr()).append("\n");
									flatFile.append("PUNIT:").append(ausSearchContainerForPVO.get(k).getPunit()).append("\n");
									flatFile.append("PKG:").append(ausSearchContainerForPVO.get(k).getPkg()).append("\n");
									flatFile.append("CNTRWGT:").append(ausSearchContainerForPVO.get(k).getCntrwgt()).append("\n");
									flatFile.append("CNTRTYPE:").append(ausSearchContainerForPVO.get(k).getCntrtype()).append("\n");
									flatFile.append("SEALNBR:").append(ausSearchContainerForPVO.get(k).getSealnbr()).append("\n");
									flatFile.append("FM_IND:").append(ausSearchContainerForPVO.get(k).getFmInd()).append("\n");
									flatFile.append("RF_IND:").append(ausSearchContainerForPVO.get(k).getRfInd()).append("\n");
									flatFile.append("DG_IND:").append(ausSearchContainerForPVO.get(k).getDgInd()).append("\n");
									flatFile.append("AK_IND:").append(ausSearchContainerForPVO.get(k).getAkInd()).append("\n");
									flatFile.append("BK_IND:").append(ausSearchContainerForPVO.get(k).getBkInd()).append("\n");
									flatFile.append("TEMP:").append(ausSearchContainerForPVO.get(k).getTemp()).append("\n");
									flatFile.append("TUNIT:").append(ausSearchContainerForPVO.get(k).getTunit()).append("\n");
									flatFile.append("VENT:").append(ausSearchContainerForPVO.get(k).getVent()).append("\n");
									flatFile.append("MEASURE:").append(ausSearchContainerForPVO.get(k).getMeasure()).append("\n");
									flatFile.append("RDTYPE:").append(ausSearchContainerForPVO.get(k).getRdtype()).append("\n");
									flatFile.append("CMDT_DESC:").append(ausSearchContainerForPVO.get(k).getCmdtDesc()).append("\n");
									flatFile.append("CMDTCD:").append(ausSearchContainerForPVO.get(k).getCmdtcd()).append("\n");
									flatFile.append("RF_REMARK:").append(ausSearchContainerForPVO.get(k).getRfRemark()).append("\n");
									flatFile.append("RFDRY_IND:").append(ausSearchContainerForPVO.get(k).getRfdryInd()).append("\n");
									flatFile.append("OVF:").append(ausSearchContainerForPVO.get(k).getOvf()).append("\n");
									flatFile.append("OVR:").append(ausSearchContainerForPVO.get(k).getOvr()).append("\n");
									flatFile.append("OVH:").append(ausSearchContainerForPVO.get(k).getOvh()).append("\n");
									flatFile.append("OVLW:").append(ausSearchContainerForPVO.get(k).getOvlw()).append("\n");
									flatFile.append("OVRW:").append(ausSearchContainerForPVO.get(k).getOvrw()).append("\n");
									flatFile.append("OVWGT:").append(ausSearchContainerForPVO.get(k).getOvwgt()).append("\n");
									flatFile.append("VOID_SLOT:").append(ausSearchContainerForPVO.get(k).getVoidSlot()).append("\n");
									flatFile.append("STWG_REQ:").append(ausSearchContainerForPVO.get(k).getStwgReq()).append("\n");
									// Manifest Container Danger
									ausSearchContainerDangerVO = dbDao.searchContainerDanger(australiaManifestTransmitVO);
									if (ausSearchContainerDangerVO != null) {
										for (int kk = 0; kk < ausSearchContainerDangerVO.size(); kk++) {
											flatFile.append("{CNTR_DANGER").append("\n");
											flatFile.append("UNNBR:").append(ausSearchContainerDangerVO.get(kk).getUnnbr()).append("\n");
											flatFile.append("CLASS:").append(ausSearchContainerDangerVO.get(kk).getImdgClass()).append("\n");
											flatFile.append("DESC:").append(ausSearchContainerDangerVO.get(kk).getShpNm()).append("\n");
											flatFile.append("PHONE:").append(ausSearchContainerDangerVO.get(kk).getPhone()).append("\n");
											flatFile.append("PAGE:").append(ausSearchContainerDangerVO.get(kk).getPageList()).append("\n");
											flatFile.append("FLSH_TEMP:").append(ausSearchContainerDangerVO.get(kk).getFlshTemp()).append("\n");
											flatFile.append("FLSH_UNIT:").append(ausSearchContainerDangerVO.get(kk).getFlshUnit()).append("\n");
											flatFile.append("DG_REMARK:").append(ausSearchContainerDangerVO.get(kk).getDgRemark()).append("\n");
											flatFile.append("}CNTR_DANGER").append("\n");
										}
									}
									// Manifest Container Description
									ausSearchContainerDescVO = dbDao.searchContainerDesc(australiaManifestTransmitVO);
									if (ausSearchContainerDescVO != null) {
										for (int kk = 0; kk < ausSearchContainerDescVO.size(); kk++) {
											flatFile.append("{CNTR_DESC").append("\n");
											flatFile.append("D_CMDT:").append(ausSearchContainerDescVO.get(kk).getDCmdt()).append("\n");
											flatFile.append("D_PUNIT:").append(ausSearchContainerDescVO.get(kk).getDPunit()).append("\n");
											flatFile.append("D_PKG:").append(ausSearchContainerDescVO.get(kk).getDPkg()).append("\n");
											flatFile.append("D_WGT:").append(ausSearchContainerDescVO.get(kk).getDWgt()).append("\n");
											flatFile.append("D_MEAS:").append(ausSearchContainerDescVO.get(kk).getDMeas()).append("\n");
											flatFile.append("D_DESC:").append(ausSearchContainerDescVO.get(kk).getDDesc()).append("\n");
											StringTokenizer token = new StringTokenizer(ausSearchContainerDescVO.get(kk).getDMark(), "\n");
											ArrayList tmpArray = new ArrayList();
											while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
											if (tmpArray.size() > 0) flatFile.append("{CUS_MARK").append("\n");
											for (int mm = 0; mm < tmpArray.size(); mm++) {
												flatFile.append("D_MARK:").append(tmpArray.get(mm).toString());
												flatFile.append("\n");
											}
											if (tmpArray.size() > 0) flatFile.append("}CUS_MARK").append("\n");
											flatFile.append("}CNTR_DESC").append("\n");
										}
									}
									flatFile.append("}CNTR_INFO").append("\n");
								}
							}
							// Manifest B/L Qty
							ausSearchBlQtyVO = dbDao.searchBlQty(australiaManifestTransmitVO);
							if (ausSearchBlQtyVO != null) {
								for (int m = 0; m < ausSearchBlQtyVO.size(); m++) {
									flatFile.append("{QTY").append("\n");
									flatFile.append("HANTYPE:").append(ausSearchBlQtyVO.get(m).getHantype()).append("\n");
									flatFile.append("COUNT:").append(ausSearchBlQtyVO.get(m).getCntrQty()).append("\n");
									flatFile.append("}QTY").append("\n");
								}
							}
							// Manifest B/L VVD
							ausSearchBlVvdVO = dbDao.searchBlVvd(australiaManifestTransmitVO);
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
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_AUSMF.IBMMQ.QUEUE"));

					flatFileAckVO = new FlatFileAckVO();
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00220", new String[] {}).getMessage());


				} else if (australiaManifestTransmitVO.getTransGubun().equalsIgnoreCase("M")) {
					// Manifest B/L General
					ausSearchBlGeneralForMVO = dbDao.searchBlGeneralForM(australiaManifestTransmitVO);
					if (ausSearchBlGeneralForMVO == null || ausSearchBlGeneralForMVO.size() < 1) {
						// [BKG08232] - There is no data to transmit!
						throw new EventException(new ErrorHandler("BKG08232").getMessage());
					}

					ausSearchMakeHeaderMVOList = dbDao.searchMakerHeaderM();
					flatFile.append(ausSearchMakeHeaderMVOList.get(0).getMsgHeader()).append("\n");
					// Vessel Info
					ausSearchVesselForMVO = dbDao.searchVesselForM(australiaManifestTransmitVO);
					if (ausSearchVesselForMVO != null && ausSearchVesselForMVO.size() > 0) {
						flatFile.append("VVD:").append(ausSearchVesselForMVO.get(0).getVvdNumber()).append("\n");
					}
					// Vessel VVD
					mdmVslCntrVOList = dbDao.searchMdmVslCntrByVslCd(australiaManifestTransmitVO.getVslCd());
					if (mdmVslCntrVOList != null && mdmVslCntrVOList.size() > 0) {
						flatFile.append("VSL_CALLSIGN:").append(mdmVslCntrVOList.get(0).getCallSgnNo()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(mdmVslCntrVOList.get(0).getLloydNo()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(mdmVslCntrVOList.get(0).getVslEngNm()).append("\n");
						flatFile.append("MSG_FUNC:").append(australiaManifestTransmitVO.getEdiInd()).append("\n");
					}
					// Vessel Estimated Date
					ausSearchVslPortSkdVOList = dbDao.searchVskVslPortSkd(vvd, australiaManifestTransmitVO.getPortCd());
					if (ausSearchVslPortSkdVOList != null && ausSearchVslPortSkdVOList.size() > 0) {
						flatFile.append("ETA:").append(ausSearchVslPortSkdVOList.get(0).getVpsEtaDt()).append("\n");
						flatFile.append("ETD:").append(ausSearchVslPortSkdVOList.get(0).getVpsEtdDt()).append("\n");
					}
					// Manifest B/L General
					for (int i=0; i<ausSearchBlGeneralForMVO.size(); i++) {
						flatFile.append("{BL_INFO").append("\n");
						australiaManifestTransmitVO.setBkgCgoTp(ausSearchBlGeneralForMVO.get(i).getBkgCgoTpCd());
						australiaManifestTransmitVO.setBkgSpeRf(ausSearchBlGeneralForMVO.get(i).getBkgSpeRf());
						australiaManifestTransmitVO.setBkgSpeDg(ausSearchBlGeneralForMVO.get(i).getBkgSpeDg());
						australiaManifestTransmitVO.setBkgSpeAk(ausSearchBlGeneralForMVO.get(i).getBkgSpeAk());
						australiaManifestTransmitVO.setBkgSpeBb(ausSearchBlGeneralForMVO.get(i).getBkgSpeBb());
						australiaManifestTransmitVO.setCmdtDesc(ausSearchBlGeneralForMVO.get(i).getCmdtDesc());
						australiaManifestTransmitVO.setCmdtCd(ausSearchBlGeneralForMVO.get(i).getCmdtCd());
						australiaManifestTransmitVO.setBkgSpeRd(ausSearchBlGeneralForMVO.get(i).getBkgSpeRd());

						flatFile.append("BLNBR:").append(ausSearchBlGeneralForMVO.get(i).getBlnbr()).append("\n");
						flatFile.append("BKGNBR:").append(ausSearchBlGeneralForMVO.get(i).getBkgnbr()).append("\n");
						flatFile.append("BLPOL:").append(ausSearchBlGeneralForMVO.get(i).getBlpol()).append("\n");
						flatFile.append("BLPOD:").append(ausSearchBlGeneralForMVO.get(i).getBlpod()).append("\n");
						flatFile.append("BLPOR:").append(ausSearchBlGeneralForMVO.get(i).getBlpor()).append("\n");
						flatFile.append("BLDEL:").append(ausSearchBlGeneralForMVO.get(i).getBldel()).append("\n");
						flatFile.append("BLRLY:").append(ausSearchBlGeneralForMVO.get(i).getBlrly()).append("\n");
						flatFile.append("BLPLACE:").append(ausSearchBlGeneralForMVO.get(i).getBlplace()).append("\n");
						flatFile.append("BLDATE:").append(ausSearchBlGeneralForMVO.get(i).getBldate()).append("\n");
						flatFile.append("CUST_CD:").append(ausSearchBlGeneralForMVO.get(i).getCustCd()).append("\n");
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
						flatFile.append("CARGOTYPE:").append(ausSearchBlGeneralForMVO.get(i).getCargotype()).append("\n");
						flatFile.append("COMMODITY:").append(ausSearchBlGeneralForMVO.get(i).getCommodity()).append("\n");
						flatFile.append("REMARK:").append(ausSearchBlGeneralForMVO.get(i).getXterRmk()).append("\n");
						flatFile.append("AUS_QUAR:").append(ausSearchBlGeneralForMVO.get(i).getAusQuar()).append("\n");
						flatFile.append("FRT_IND:").append(ausSearchBlGeneralForMVO.get(i).getFrtInd()).append("\n");
						flatFile.append("CUSTOMS_DESC:").append(ausSearchBlGeneralForMVO.get(i).getCstmsDesc()).append("\n");
						australiaManifestTransmitVO.setBkgNo(ausSearchBlGeneralForMVO.get(i).getBkgNo());
						ausSearchBlCharegeVO = dbDao.searchBlCharge(australiaManifestTransmitVO);
						// Manifest B/L Charge
						if (ausSearchBlCharegeVO != null) {
							for (int j = 0; j < ausSearchBlCharegeVO.size(); j++) {
								flatFile.append("{CHARGE").append("\n");
								flatFile.append("FCTYPE:").append(ausSearchBlCharegeVO.get(j).getFctype()).append("\n");
								flatFile.append("RATE:").append(ausSearchBlCharegeVO.get(j).getRate()).append("\n");
								flatFile.append("REVENUETON:").append(ausSearchBlCharegeVO.get(j).getRevenueton()).append("\n");
								flatFile.append("PPD:").append(ausSearchBlCharegeVO.get(j).getPpd()).append("\n");
								flatFile.append("CCT:").append(ausSearchBlCharegeVO.get(j).getCct()).append("\n");
								flatFile.append("CURRENCYCODE:").append(ausSearchBlCharegeVO.get(j).getCurrencycode()).append("\n");
								flatFile.append("TARIFF:").append(ausSearchBlCharegeVO.get(j).getTariff()).append("\n");
								flatFile.append("PERTYPE:").append(ausSearchBlCharegeVO.get(j).getPertype()).append("\n");
								flatFile.append("}CHARGE").append("\n");
							}
						}
						// Manifest B/L Charge Total
						ausSearchBlChargeTotalVO = dbDao.searchBlChargeTotal(australiaManifestTransmitVO);
						if (ausSearchBlChargeTotalVO != null) {
							for (int j = 0; j < ausSearchBlChargeTotalVO.size(); j++) {
								flatFile.append("{CHARGE_TTL").append("\n");
								flatFile.append("PPD_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getPpdTotal()).append("\n");
								flatFile.append("CCT_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getCctTotal()).append("\n");
								flatFile.append("TOTAL_CUR:").append(ausSearchBlChargeTotalVO.get(j).getTotalCur()).append("\n");
								flatFile.append("}CHARGE_TTL").append("\n");
							}
						}
						// Manifest B/L Mark Description
						ausSearchBlMarkDescVO = dbDao.searchBlMarksDesc(australiaManifestTransmitVO);
						if (ausSearchBlMarkDescVO != null) {
							for (int j = 0; j < ausSearchBlMarkDescVO.size(); j++) {
								StringTokenizer token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getCmdtDesc(), "\n");
								ArrayList tmpArray = new ArrayList();
								while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
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
								while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
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
						// Manifest Container
						ausSearchContainerForMVO = dbDao.searchContainerForM(australiaManifestTransmitVO);
						if (ausSearchContainerForMVO != null) {
							for (int k = 0; k < ausSearchContainerForMVO.size(); k++) {
								flatFile.append("{CNTR_INFO").append("\n");
								australiaManifestTransmitVO.setCntrNo(ausSearchContainerForMVO.get(k).getCntrNo());
								flatFile.append("CNTRNBR:").append(ausSearchContainerForMVO.get(k).getCntrnbr()).append("\n");
								flatFile.append("PUNIT:").append(ausSearchContainerForMVO.get(k).getPunit()).append("\n");
								flatFile.append("PKG:").append(ausSearchContainerForMVO.get(k).getPkg()).append("\n");
								flatFile.append("CNTRWGT:").append(ausSearchContainerForMVO.get(k).getCntrwgt()).append("\n");
								flatFile.append("CNTRTYPE:").append(ausSearchContainerForMVO.get(k).getCntrtype()).append("\n");
								flatFile.append("SEALNBR:").append(ausSearchContainerForMVO.get(k).getSealnbr()).append("\n");
								flatFile.append("SOC_IND:").append(ausSearchContainerForMVO.get(k).getSocInd()).append("\n");
								flatFile.append("FM_IND:").append(ausSearchContainerForMVO.get(k).getFmInd()).append("\n");
								flatFile.append("RF_IND:").append(ausSearchContainerForMVO.get(k).getRfInd()).append("\n");
								flatFile.append("DG_IND:").append(ausSearchContainerForMVO.get(k).getDgInd()).append("\n");
								flatFile.append("AK_IND:").append(ausSearchContainerForMVO.get(k).getAkInd()).append("\n");
								flatFile.append("BK_IND:").append(ausSearchContainerForMVO.get(k).getBkInd()).append("\n");
								flatFile.append("TEMP:").append(ausSearchContainerForMVO.get(k).getTemp()).append("\n");
								flatFile.append("TUNIT:").append(ausSearchContainerForMVO.get(k).getTunit()).append("\n");
								flatFile.append("HUMIDITY:").append(ausSearchContainerForMVO.get(k).getHumidity()).append("\n");
								flatFile.append("VENT:").append(ausSearchContainerForMVO.get(k).getVent()).append("\n");
								flatFile.append("MEASURE:").append(ausSearchContainerForMVO.get(k).getMeasure()).append("\n");
								flatFile.append("RDTYPE:").append(ausSearchContainerForMVO.get(k).getRdtype()).append("\n");
								flatFile.append("CMDT_DESC:").append(ausSearchContainerForMVO.get(k).getCmdtDesc()).append("\n");
								flatFile.append("CMDTCD:").append(ausSearchContainerForMVO.get(k).getCmdtcd()).append("\n");
								flatFile.append("RF_REMARK:").append(ausSearchContainerForMVO.get(k).getRfRemark()).append("\n");
								flatFile.append("RFDRY_IND:").append(ausSearchContainerForMVO.get(k).getRfdryInd()).append("\n");
								flatFile.append("OVF:").append(ausSearchContainerForMVO.get(k).getOvf()).append("\n");
								flatFile.append("OVR:").append(ausSearchContainerForMVO.get(k).getOvr()).append("\n");
								flatFile.append("OVH:").append(ausSearchContainerForMVO.get(k).getOvh()).append("\n");
								flatFile.append("OVLW:").append(ausSearchContainerForMVO.get(k).getOvlw()).append("\n");
								flatFile.append("OVRW:").append(ausSearchContainerForMVO.get(k).getOvrw()).append("\n");
								flatFile.append("OVWGT:").append(ausSearchContainerForMVO.get(k).getOvwgt()).append("\n");
								flatFile.append("VOID_SLOT:").append(ausSearchContainerForMVO.get(k).getVoidSlot()).append("\n");
								flatFile.append("STWG_REQ:").append(ausSearchContainerForMVO.get(k).getStwgReq()).append("\n");
								// Manifest Container Danger
								ausSearchContainerDangerVO = dbDao.searchContainerDanger(australiaManifestTransmitVO);
								if (ausSearchContainerDangerVO != null) {
									for (int kk = 0; kk < ausSearchContainerDangerVO.size(); kk++) {
										flatFile.append("{CNTR_DANGER").append("\n");
										flatFile.append("UNNBR:").append(ausSearchContainerDangerVO.get(kk).getUnnbr()).append("\n");
										flatFile.append("CLASS:").append(ausSearchContainerDangerVO.get(kk).getImdgClass()).append("\n");
										flatFile.append("DESC:").append(ausSearchContainerDangerVO.get(kk).getShpNm()).append("\n");
										flatFile.append("PHONE:").append(ausSearchContainerDangerVO.get(kk).getPhone()).append("\n");
										flatFile.append("PAGE:").append(ausSearchContainerDangerVO.get(kk).getPageList()).append("\n");
										flatFile.append("FLSH_TEMP:").append(ausSearchContainerDangerVO.get(kk).getFlshTemp()).append("\n");
										flatFile.append("FLSH_UNIT:").append(ausSearchContainerDangerVO.get(kk).getFlshUnit()).append("\n");
										flatFile.append("DG_REMARK:").append(ausSearchContainerDangerVO.get(kk).getDgRemark()).append("\n");
										flatFile.append("}CNTR_DANGER").append("\n");
									}
								}
								// Manifest Container Description
								ausSearchContainerDescVO = dbDao.searchContainerDesc(australiaManifestTransmitVO);
								if (ausSearchContainerDescVO != null) {
									for (int kk = 0; kk < ausSearchContainerDescVO.size(); kk++) {
										flatFile.append("{CNTR_DESC").append("\n");
										flatFile.append("D_CMDT:").append(ausSearchContainerDescVO.get(kk).getDCmdt()).append("\n");
										flatFile.append("D_PUNIT:").append(ausSearchContainerDescVO.get(kk).getDPunit()).append("\n");
										flatFile.append("D_PKG:").append(ausSearchContainerDescVO.get(kk).getDPkg()).append("\n");
										flatFile.append("D_WGT:").append(ausSearchContainerDescVO.get(kk).getDWgt()).append("\n");
										flatFile.append("D_MEAS:").append(ausSearchContainerDescVO.get(kk).getDMeas()).append("\n");
										flatFile.append("D_DESC:").append(ausSearchContainerDescVO.get(kk).getDDesc()).append("\n");
										StringTokenizer token = new StringTokenizer(ausSearchContainerDescVO.get(kk).getDMark(), "\n");
										ArrayList tmpArray = new ArrayList();
										while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
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
						// Manifest B/L Qty
						ausSearchBlQtyVO = dbDao.searchBlQty(australiaManifestTransmitVO);
						if (ausSearchBlQtyVO != null) {
							for (int m = 0; m < ausSearchBlQtyVO.size(); m++) {
								flatFile.append("{QTY").append("\n");
								flatFile.append("HANTYPE:").append(ausSearchBlQtyVO.get(m).getHantype()).append("\n");
								flatFile.append("COUNT:").append(ausSearchBlQtyVO.get(m).getCntrQty()).append("\n");
								flatFile.append("}QTY").append("\n");
							}
						}
						// Manifest B/L VVD
						ausSearchBlVvdVO = dbDao.searchBlVvd(australiaManifestTransmitVO);
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

					if (flatFile.length() == 0) flatFile = new StringBuilder();
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_AUSMF.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00220", new String[] {}).getMessage());


				} else if (australiaManifestTransmitVO.getTransGubun().equalsIgnoreCase("P")) {
					// Manifest B/L General
					ausSearchBlGeneralForPVO = dbDao.searchBlGeneralForP(australiaManifestTransmitVO);
					if (ausSearchBlGeneralForPVO == null || ausSearchBlGeneralForPVO.size() < 1) {
						// [BKG08232] - There is no data to transmit!
						throw new EventException(new ErrorHandler("BKG08232").getMessage());
					}

					String portCd = australiaManifestTransmitVO.getPortCd();
					String postFix = "";
					if ("AUBNE".equals(portCd)) {
						postFix = "BPC";
					} else if ("AUMEL".equals(portCd)) {
						postFix = "MPC";
					} else if ("AUSYD".equals(portCd)) {
						postFix = "SPC";
					} else if ("AUGEX".equals(portCd)) {
						postFix = "GPC";
					} else if ("AUFET".equals(portCd) || "AUJFM".equals(portCd) || "AUFRE".equals(portCd)) {
						postFix = "FPC";
					} else if ("AUADL".equals(portCd) || "AUPAE".equals(portCd)) {
						postFix = "APC";
					} else {
						postFix = "ETC";
					}
					flatFile.append(command.searchCstmsEdiHeaderNew("AU_IFCSUM_" + postFix)).append("\n");

					// Vessel Info
					ausSearchVesselForPVO = dbDao.searchVesselForP(australiaManifestTransmitVO);
					if (ausSearchVesselForPVO != null && ausSearchVesselForPVO.size() > 0) {
						flatFile.append("VVD:").append(ausSearchVesselForPVO.get(0).getVvdNumber()).append("\n");
					}
					// Vessel Estimated Date
					ausSearchVslPortSkdVOList = dbDao.searchVskVslPortSkd(vvd, australiaManifestTransmitVO.getPortCd());
					if (ausSearchVslPortSkdVOList != null && ausSearchVslPortSkdVOList.size() > 0) {
						if ( !"".equals(australiaManifestTransmitVO.getPodCd()) && "".equals(australiaManifestTransmitVO.getPolCd())) {
							// In-Bound
							flatFile.append("CON_VVD:").append(ausSearchVslPortSkdVOList.get(0).getIbCssmVoyNo()).append("\n");
						} else {
							// Out-Bound
							flatFile.append("CON_VVD:").append(ausSearchVslPortSkdVOList.get(0).getObCssmVoyNo()).append("\n");
						}
					}
					// Vessel VVD
					mdmVslCntrVOList = dbDao.searchMdmVslCntrByVslCd(australiaManifestTransmitVO.getVslCd());
					if (mdmVslCntrVOList != null && mdmVslCntrVOList.size() > 0) {
						flatFile.append("VSL_CALLSIGN:").append(mdmVslCntrVOList.get(0).getCallSgnNo()).append("\n");
						flatFile.append("VSL_LLOYDCODE:").append(mdmVslCntrVOList.get(0).getLloydNo()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(mdmVslCntrVOList.get(0).getVslEngNm()).append("\n");
						flatFile.append("MSG_FUNC:").append(australiaManifestTransmitVO.getEdiInd()).append("\n");
					}
					// Vessel Estimated Date
					ausSearchVslPortSkdVOList = dbDao.searchVskVslPortSkd(vvd, australiaManifestTransmitVO.getPortCd());
					if (ausSearchVslPortSkdVOList != null && ausSearchVslPortSkdVOList.size() > 0) {
						flatFile.append("ETA:").append(ausSearchVslPortSkdVOList.get(0).getVpsEtaDt()).append("\n");
						flatFile.append("ETD:").append(ausSearchVslPortSkdVOList.get(0).getVpsEtdDt()).append("\n");
					}
					// Manifest B/L General
					for (int i=0; i<ausSearchBlGeneralForPVO.size(); i++) {
						flatFile.append("{BL_INFO").append("\n");
						australiaManifestTransmitVO.setBkgCgoTp(ausSearchBlGeneralForPVO.get(i).getBkgCgoTpCd());
						australiaManifestTransmitVO.setBkgSpeRf(ausSearchBlGeneralForPVO.get(i).getBkgSpeRf());
						australiaManifestTransmitVO.setBkgSpeDg(ausSearchBlGeneralForPVO.get(i).getBkgSpeDg());
						australiaManifestTransmitVO.setBkgSpeAk(ausSearchBlGeneralForPVO.get(i).getBkgSpeAk());
						australiaManifestTransmitVO.setBkgSpeBb(ausSearchBlGeneralForPVO.get(i).getBkgSpeBb());
						australiaManifestTransmitVO.setCmdtDesc(ausSearchBlGeneralForPVO.get(i).getCmdtDesc());
						australiaManifestTransmitVO.setCmdtCd(ausSearchBlGeneralForPVO.get(i).getCmdtCd());
						australiaManifestTransmitVO.setBkgSpeRd(ausSearchBlGeneralForPVO.get(i).getBkgSpeRd());

						flatFile.append("BLNBR:").append(ausSearchBlGeneralForPVO.get(i).getBlnbr()).append("\n");
						flatFile.append("BLPOL:").append(ausSearchBlGeneralForPVO.get(i).getBlpol()).append("\n");
						flatFile.append("BLPOD:").append(ausSearchBlGeneralForPVO.get(i).getBlpod()).append("\n");
						flatFile.append("BLPOR:").append(ausSearchBlGeneralForPVO.get(i).getBlpor()).append("\n");
						flatFile.append("BLDEL:").append(ausSearchBlGeneralForPVO.get(i).getBldel()).append("\n");
						flatFile.append("BLRLY:").append(ausSearchBlGeneralForPVO.get(i).getBlrly()).append("\n");
						flatFile.append("BLPLACE:").append(ausSearchBlGeneralForPVO.get(i).getBlplace()).append("\n");
						flatFile.append("BLDATE:").append(ausSearchBlGeneralForPVO.get(i).getBldate()).append("\n");
						flatFile.append("CUST_CD:").append(ausSearchBlGeneralForPVO.get(i).getCustCd()).append("\n");
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
						flatFile.append("CARGOTYPE:").append(ausSearchBlGeneralForPVO.get(i).getCargotype()).append("\n");
						flatFile.append("COMMODITY:").append(ausSearchBlGeneralForPVO.get(i).getCommodity()).append("\n");
						flatFile.append("REMARK:").append(ausSearchBlGeneralForPVO.get(i).getXterRmk()).append("\n");
						flatFile.append("AUS_QUAR:").append(ausSearchBlGeneralForPVO.get(i).getAusQuar()).append("\n");
						australiaManifestTransmitVO.setBkgNo(ausSearchBlGeneralForPVO.get(i).getBkgNo());
						ausSearchBlCharegeVO = dbDao.searchBlCharge(australiaManifestTransmitVO);
						// Manifest B/L Charge
						if (ausSearchBlCharegeVO != null) {
							for (int j=0; j<ausSearchBlCharegeVO.size(); j++) {
								flatFile.append("{CHARGE").append("\n");
								flatFile.append("FCTYPE:").append(ausSearchBlCharegeVO.get(j).getFctype()).append("\n");
								flatFile.append("RATE:").append(ausSearchBlCharegeVO.get(j).getRate()).append("\n");
								flatFile.append("REVENUETON:").append(ausSearchBlCharegeVO.get(j).getRevenueton()).append("\n");
								flatFile.append("PPD:").append(ausSearchBlCharegeVO.get(j).getPpd()).append("\n");
								flatFile.append("CCT:").append(ausSearchBlCharegeVO.get(j).getCct()).append("\n");
								flatFile.append("CURRENCYCODE:").append(ausSearchBlCharegeVO.get(j).getCurrencycode()).append("\n");
								flatFile.append("TARIFF:").append(ausSearchBlCharegeVO.get(j).getTariff()).append("\n");
								flatFile.append("PERTYPE:").append(ausSearchBlCharegeVO.get(j).getPertype()).append("\n");
								flatFile.append("}CHARGE").append("\n");
							}
						}
						// Manifest B/L Charge Total
						ausSearchBlChargeTotalVO = dbDao.searchBlChargeTotal(australiaManifestTransmitVO);
						if (ausSearchBlChargeTotalVO != null) {
							for (int j = 0; j < ausSearchBlChargeTotalVO.size(); j++) {
								flatFile.append("{CHARGE_TTL").append("\n");
								flatFile.append("PPD_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getPpdTotal()).append("\n");
								flatFile.append("CCT_TOTAL:").append(ausSearchBlChargeTotalVO.get(j).getCctTotal()).append("\n");
								flatFile.append("TOTAL_CUR:").append(ausSearchBlChargeTotalVO.get(j).getTotalCur()).append("\n");
								flatFile.append("}CHARGE_TTL").append("\n");
							}
						}
						// Manifest B/L Mark Description
						ausSearchBlMarkDescVO = dbDao.searchBlMarksDesc(australiaManifestTransmitVO);
						if (ausSearchBlMarkDescVO != null) {
							for (int j = 0; j < ausSearchBlMarkDescVO.size(); j++) {
								StringTokenizer token = new StringTokenizer(ausSearchBlMarkDescVO.get(j).getCmdtDesc(), "\n");
								ArrayList tmpArray = new ArrayList();
								while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
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
								while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
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
						// Manifest Container
						ausSearchContainerForPVO = dbDao.searchContainerForP(australiaManifestTransmitVO);
						if (ausSearchContainerForPVO != null) {
							for (int k = 0; k < ausSearchContainerForPVO.size(); k++) {
								flatFile.append("{CNTR_INFO").append("\n");
								australiaManifestTransmitVO.setCntrNo(ausSearchContainerForPVO.get(k).getCntrNo());
								flatFile.append("CNTRNBR:").append(ausSearchContainerForPVO.get(k).getCntrnbr()).append("\n");
								flatFile.append("PUNIT:").append(ausSearchContainerForPVO.get(k).getPunit()).append("\n");
								flatFile.append("PKG:").append(ausSearchContainerForPVO.get(k).getPkg()).append("\n");
								flatFile.append("CNTRWGT:").append(ausSearchContainerForPVO.get(k).getCntrwgt()).append("\n");
								flatFile.append("CNTRTYPE:").append(ausSearchContainerForPVO.get(k).getCntrtype()).append("\n");
								flatFile.append("SEALNBR:").append(ausSearchContainerForPVO.get(k).getSealnbr()).append("\n");
								flatFile.append("FM_IND:").append(ausSearchContainerForPVO.get(k).getFmInd()).append("\n");
								flatFile.append("RF_IND:").append(ausSearchContainerForPVO.get(k).getRfInd()).append("\n");
								flatFile.append("DG_IND:").append(ausSearchContainerForPVO.get(k).getDgInd()).append("\n");
								flatFile.append("AK_IND:").append(ausSearchContainerForPVO.get(k).getAkInd()).append("\n");
								flatFile.append("BK_IND:").append(ausSearchContainerForPVO.get(k).getBkInd()).append("\n");
								flatFile.append("TEMP:").append(ausSearchContainerForPVO.get(k).getTemp()).append("\n");
								flatFile.append("TUNIT:").append(ausSearchContainerForPVO.get(k).getTunit()).append("\n");
								flatFile.append("VENT:").append(ausSearchContainerForPVO.get(k).getVent()).append("\n");
								flatFile.append("MEASURE:").append(ausSearchContainerForPVO.get(k).getMeasure()).append("\n");
								flatFile.append("RDTYPE:").append(ausSearchContainerForPVO.get(k).getRdtype()).append("\n");
								flatFile.append("CMDT_DESC:").append(ausSearchContainerForPVO.get(k).getCmdtDesc()).append("\n");
								flatFile.append("CMDTCD:").append(ausSearchContainerForPVO.get(k).getCmdtcd()).append("\n");
								flatFile.append("RF_REMARK:").append(ausSearchContainerForPVO.get(k).getRfRemark()).append("\n");
								flatFile.append("RFDRY_IND:").append(ausSearchContainerForPVO.get(k).getRfdryInd()).append("\n");
								flatFile.append("OVF:").append(ausSearchContainerForPVO.get(k).getOvf()).append("\n");
								flatFile.append("OVR:").append(ausSearchContainerForPVO.get(k).getOvr()).append("\n");
								flatFile.append("OVH:").append(ausSearchContainerForPVO.get(k).getOvh()).append("\n");
								flatFile.append("OVLW:").append(ausSearchContainerForPVO.get(k).getOvlw()).append("\n");
								flatFile.append("OVRW:").append(ausSearchContainerForPVO.get(k).getOvrw()).append("\n");
								flatFile.append("OVWGT:").append(ausSearchContainerForPVO.get(k).getOvwgt()).append("\n");
								flatFile.append("VOID_SLOT:").append(ausSearchContainerForPVO.get(k).getVoidSlot()).append("\n");
								flatFile.append("STWG_REQ:").append(ausSearchContainerForPVO.get(k).getStwgReq()).append("\n");
								// Manifest Container Danger
								ausSearchContainerDangerVO = dbDao
										.searchContainerDanger(australiaManifestTransmitVO);
								if (ausSearchContainerDangerVO != null) {
									for (int kk = 0; kk < ausSearchContainerDangerVO.size(); kk++) {
										flatFile.append("{CNTR_DANGER").append("\n");
										flatFile.append("UNNBR:").append(ausSearchContainerDangerVO.get(kk).getUnnbr()).append("\n");
										flatFile.append("CLASS:").append(ausSearchContainerDangerVO.get(kk).getImdgClass()).append("\n");
										flatFile.append("DESC:").append(ausSearchContainerDangerVO.get(kk).getShpNm()).append("\n");
										flatFile.append("PHONE:").append(ausSearchContainerDangerVO.get(kk).getPhone()).append("\n");
										flatFile.append("PAGE:").append(ausSearchContainerDangerVO.get(kk).getPageList()).append("\n");
										flatFile.append("FLSH_TEMP:").append(ausSearchContainerDangerVO.get(kk).getFlshTemp()).append("\n");
										flatFile.append("FLSH_UNIT:").append(ausSearchContainerDangerVO.get(kk).getFlshUnit()).append("\n");
										flatFile.append("DG_REMARK:").append(ausSearchContainerDangerVO.get(kk).getDgRemark()).append("\n");
										flatFile.append("}CNTR_DANGER").append("\n");
									}
								}
								// Manifest Container Description
								ausSearchContainerDescVO = dbDao.searchContainerDesc(australiaManifestTransmitVO);
								if (ausSearchContainerDescVO != null) {
									for (int kk = 0; kk < ausSearchContainerDescVO.size(); kk++) {
										flatFile.append("{CNTR_DESC").append("\n");
										flatFile.append("D_CMDT:").append(ausSearchContainerDescVO.get(kk).getDCmdt()).append("\n");
										flatFile.append("D_PUNIT:").append(ausSearchContainerDescVO.get(kk).getDPunit()).append("\n");
										flatFile.append("D_PKG:").append(ausSearchContainerDescVO.get(kk).getDPkg()).append("\n");
										flatFile.append("D_WGT:").append(ausSearchContainerDescVO.get(kk).getDWgt()).append("\n");
										flatFile.append("D_MEAS:").append(ausSearchContainerDescVO.get(kk).getDMeas()).append("\n");
										flatFile.append("D_DESC:").append(ausSearchContainerDescVO.get(kk).getDDesc()).append("\n");
										StringTokenizer token = new StringTokenizer(ausSearchContainerDescVO.get(kk).getDMark(), "\n");
										ArrayList tmpArray = new ArrayList();
										while (token.hasMoreTokens()) tmpArray.add(token.nextToken());
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
						// Manifest B/L Qty
						ausSearchBlQtyVO = dbDao.searchBlQty(australiaManifestTransmitVO);
						if (ausSearchBlQtyVO != null) {
							for (int m = 0; m < ausSearchBlQtyVO.size(); m++) {
								flatFile.append("{QTY").append("\n");
								flatFile.append("HANTYPE:").append(ausSearchBlQtyVO.get(m).getHantype()).append("\n");
								flatFile.append("COUNT:").append(ausSearchBlQtyVO.get(m).getCntrQty()).append("\n");
								flatFile.append("}QTY").append("\n");
							}
						}
						// Manifest B/L VVD
						ausSearchBlVvdVO = dbDao.searchBlVvd(australiaManifestTransmitVO);
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
					if (flatFile.length() == 0) flatFile = new StringBuilder();

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_AUSMF.IBMMQ.QUEUE"));

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
}
