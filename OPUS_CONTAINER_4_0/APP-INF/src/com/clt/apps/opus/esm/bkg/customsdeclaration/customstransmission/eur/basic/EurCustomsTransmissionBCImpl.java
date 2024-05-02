/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionBCImpl.java
*@FileTitle : EurCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.23 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import monfox.toolkit.snmp.agent.modules.SnmpV2Mib.SysOREntry;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BkgQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrBlLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrCntrRfAkBrCgoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrDgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrMndDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoTTLVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrVslCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration.EurCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.BkgCstmsBlLodFctrLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.BkgCstmsEurDgEdiRspnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.BkgCstmsEurDgSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.BkgCstmsEurDgSndVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurBkgVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurEtaInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProBkgQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifesDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCmDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCmInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCntrRfAkBrCgoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCntrSealListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCommodityVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProDgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProELNumberInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProENSDownExcelVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProEuMrnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProMsnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProRateAmountTTLVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProRateAmountVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProVslEtcInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitproEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCustListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgDtlVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.net.ftp.FtpManager;
import com.clt.utilitybox.container.BeanContainer;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * Handling business logic about OPUS-CustomsDeclaration.<br>
 * 
 * @author Kyoung Jong Yun
 * @see referencing to the each DAO Class EurCustomsTransmissionBC
 * @since J2EE 1.6
 */
public class EurCustomsTransmissionBCImpl extends BasicCommandSupport implements EurCustomsTransmissionBC {

	// Database Access Object
	private transient EurCustomsTransmissionDBDAO dbDao = null;
	
	// StringBuffer 초기 사이즈
	static final int BUFFERSIZE = 1000000;

	/**
	 * EurCustomsTransmissionBCImpl 객체 생성<br>
	 * EurCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public EurCustomsTransmissionBCImpl() {
		dbDao = new EurCustomsTransmissionDBDAO();
	}

	/**
	 * Voyage 별로 UVI (Unique Vessel Identifier) <br>
	 * 
	 * @param  String vvdCd
	 * @param  String polCd
	 * @param  String podCd
	 * @return String
	 * @throws EventException
	 */
	public String searchUvi(String vvdCd, String polCd, String podCd) throws EventException {
		 
		String retUvi = "";
		
		try {
			retUvi = dbDao.searchUviByVvdPort(vvdCd, polCd, podCd);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return retUvi;

	}
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.(Eur-CTA)<Br>
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		
		EurManifestTransmitVO[] eurManifestTransmitVOs = (EurManifestTransmitVO[])manifestTransmitVOs;
		
		StringBuffer flatFile = new StringBuffer();
		EurBkgVvdInfoVO eurBkgVvdInfoVO = null;
		String vvdCd = "";
		String modeType = "";
		String pOriAmdCd = "";
		String conVvd = "";
		String header = "";
		String searchPodCd = "";
		CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
		
		// SEND LOG
		BkgCstmsEurDgSndVO snd = new BkgCstmsEurDgSndVO();
		List<BkgCstmsEurDgSndLogVO> sndLog = new ArrayList<BkgCstmsEurDgSndLogVO>();
		List<BkgCstmsEurDgEdiRspnVO> rspnList = new ArrayList<BkgCstmsEurDgEdiRspnVO>(); 
		try {

			BookingUtil command = new BookingUtil();
			int iEdiRspnSeq = 1;
			for (int i = 0; i < eurManifestTransmitVOs.length; i++) {

				EurManifestTransmitVO eurManifestTransmitVO = eurManifestTransmitVOs[i];

				if (i == 0) {
					vvdCd = eurManifestTransmitVO.getVvdCd();
					modeType = eurManifestTransmitVO.getModeType();
					pOriAmdCd = eurManifestTransmitVO.getPOriAmdCd();
					header = command.searchCstmsEdiHeaderNew("EU_" + eurManifestTransmitVO.getReceiverId());
					String portCd = eurManifestTransmitVO.getPolCd();
					if ("I".equals(eurManifestTransmitVO.getModeType())) {
						portCd = eurManifestTransmitVO.getPodCd();
					}
					conVvd = comBc.searchConVvd(vvdCd, portCd, modeType);

					// SEND LOG
					String sndKey = dbDao.searchEdiHistoryKey(eurManifestTransmitVO.getReceiverId(), "CTA", "", "", "");
					snd.setEurEdiMsgTpId("CTA");
					snd.setMsgSndNo(sndKey);
					snd.setSndUsrId(account.getUsr_id());
					snd.setAutoSndTpCd("M");
					snd.setEurDgDeclTpCd("");
					snd.setVvdCd(eurManifestTransmitVO.getVvdCd());
					if ("I".equals(eurManifestTransmitVO.getModeType())) {
						snd.setPortCd(eurManifestTransmitVO.getPodCd());
					} else {
						snd.setPortCd(eurManifestTransmitVO.getPolCd());
					}
					snd.setCreUsrId(account.getUsr_id());
					snd.setUpdUsrId(account.getUsr_id());
//					snd.setMsgFuncId(eurManifestTransmitVO.getPOriAmdCd());
					searchPodCd = eurManifestTransmitVO.getSearchPodCd();
				}
				eurManifestTransmitVO.setVvdCd(vvdCd);
				eurManifestTransmitVO.setModeType(modeType);
				eurManifestTransmitVO.setPOriAmdCd(pOriAmdCd);
				eurManifestTransmitVO.setSearchPodCd(searchPodCd);
					 
					
				// VSL/VVD정보 가져오기
				eurBkgVvdInfoVO = dbDao.searchBkgVvdByVvd(eurManifestTransmitVO);
				// 3. BL 일반 정보 및 location 정보를 조회한다.
				BrBlLocInfoVO brBlLocInfoVO = dbDao.searchBlCustomerInfo(eurManifestTransmitVO);

				// VSL/VVD정보 셋팅
				flatFile.append(header).append("\n");
				flatFile.append("VVD:").append(vvdCd).append("\n");
				flatFile.append("CON_VVD:").append(conVvd).append("\n");
				flatFile.append("UPDATE_IND:").append(eurManifestTransmitVO.getPOriAmdCd()).append("\n");

				flatFile.append("TRANSHIP_IND:").append(brBlLocInfoVO.getTranshipInd()).append("\n");// 2014.11.24
				flatFile.append("INOUT_IND:").append(brBlLocInfoVO.getInoutInd()).append("\n");// 2014.11.24
					
				flatFile.append("VSL_CALLSIGN:").append(eurBkgVvdInfoVO.getVslCallsign()).append("\n");
				flatFile.append("VSL_LLOYDCODE:").append(eurBkgVvdInfoVO.getVslLloydcode()).append("\n");
				flatFile.append("VSL_FULLNAME:").append(eurBkgVvdInfoVO.getVslFullname()).append("\n");
				flatFile.append("ETA:").append(eurBkgVvdInfoVO.getEta()).append("\n");
				flatFile.append("ETD:").append(eurBkgVvdInfoVO.getEtd()).append("\n");
					
				flatFile.append("POFE_ETA:").append(brBlLocInfoVO.getPofeEta()).append("\n");

				flatFile.append("UVI:").append(eurManifestTransmitVO.getUvi()).append("\n");
				flatFile.append("VSL_FLAG:").append(eurBkgVvdInfoVO.getVslFlag()).append("\n");

				flatFile.append("BLNBR:").append(brBlLocInfoVO.getBlnbr()).append("\n");
				flatFile.append("PARTLOAD:").append(brBlLocInfoVO.getPartLoad()).append("\n");
				flatFile.append("BLPOL:").append(brBlLocInfoVO.getBlpol()).append("\n");
				flatFile.append("BLPOL_NAME:").append(brBlLocInfoVO.getBlpolName()).append("\n");// 2014.11.24
				flatFile.append("BLPOD:").append(brBlLocInfoVO.getBlpod()).append("\n");
				flatFile.append("BLPOD_NAME:").append(brBlLocInfoVO.getBlpodName()).append("\n");// 2014.11.24
				flatFile.append("BLPOR:").append(brBlLocInfoVO.getBlpor()).append("\n");
				flatFile.append("BLPOR_NAME:").append(brBlLocInfoVO.getBlporName()).append("\n");// 2014.11.24
				flatFile.append("BLDEL:").append(brBlLocInfoVO.getBldel()).append("\n");
				flatFile.append("BLDEL_NAME:").append(brBlLocInfoVO.getBldelName()).append("\n");// 2014.11.24
				flatFile.append("BLRLY:").append(brBlLocInfoVO.getBlrly()).append("\n");
				flatFile.append("BLPOL_NODE:").append(brBlLocInfoVO.getBlpolNode()).append("\n");
				flatFile.append("BLPOD_NODE:").append(brBlLocInfoVO.getBlpodNode()).append("\n");
				flatFile.append("BLPLACE:").append(brBlLocInfoVO.getBlplace()).append("\n");
				flatFile.append("BLDATE:").append(brBlLocInfoVO.getBldate()).append("\n");

				/**
				 * 2011.08.23 김보배 [CHM-201112952] [EUR Inbound Manifest] <br>
				 * Flat File 보완 - 세부 고객정보 추가 (ENS구조참조) 구주 24시 BL 고객 정보 조회
				 */
				List<Eur24BlCustListVO> eur24BlCustListVOs = dbDao.searchBlCust(eurManifestTransmitVO.getBkgNo(), eurManifestTransmitVO.getVvdCd().substring(0, 4), eurManifestTransmitVO.getVvdCd()
						.substring(4, 8), eurManifestTransmitVO.getVvdCd().substring(8, 9), eurBkgVvdInfoVO.getPofe());
				if (eur24BlCustListVOs != null && eur24BlCustListVOs.size() > 0) {
					for (int j = 0; j < eur24BlCustListVOs.size(); j++) {
						Eur24BlCustListVO custVO = eur24BlCustListVOs.get(j);

						flatFile.append("{BL_PARTY_INFO").append("\n");
						flatFile.append("BL_PT_TYPE:").append(custVO.getBlPtType()).append("\n");
						flatFile.append("BL_PT_TIN:").append(custVO.getBlPtTin()).append("\n");
						flatFile.append("BL_PT_EORI:").append(custVO.getBlPtEori()).append("\n");
						flatFile.append("BL_PT_NAME:").append(custVO.getBlPtName()).append("\n");
						flatFile.append("BL_PT_ADDRESS:").append(custVO.getBlPtAddress()).append("\n");
						flatFile.append("BL_PT_STREET:").append(custVO.getBlPtStreet()).append("\n");
						flatFile.append("BL_PT_CITY:").append(custVO.getBlPtCity()).append("\n");
						flatFile.append("BL_PT_POSTAL_CD:").append(custVO.getBlPtPostalCd()).append("\n");
						flatFile.append("BL_PT_CNT_CD:").append(custVO.getBlPtCntCd()).append("\n");
						flatFile.append("BL_PT_AG_ATLAS:").append(custVO.getBlPtAgAtlas()).append("\n");
						flatFile.append("}BL_PARTY_INFO").append("\n");
					}
				} else {
					flatFile.append("{BL_PARTY_INFO").append("\n");
					flatFile.append("BL_PT_TYPE:").append("\n");
					flatFile.append("BL_PT_TIN:").append("\n");
					flatFile.append("BL_PT_EORI:").append("\n");
					flatFile.append("BL_PT_NAME:").append("\n");
					flatFile.append("BL_PT_ADDRESS:").append("\n");
					flatFile.append("BL_PT_STREET:").append("\n");
					flatFile.append("BL_PT_CITY:").append("\n");
					flatFile.append("BL_PT_POSTAL_CD:").append("\n");
					flatFile.append("BL_PT_CNT_CD:").append("\n");
					flatFile.append("BL_PT_AG_ATLAS:").append("\n");
					flatFile.append("}BL_PARTY_INFO").append("\n");
				}

				flatFile.append("SHPR1:").append(brBlLocInfoVO.getShpr1()).append("\n");
				flatFile.append("SHPR2:").append(brBlLocInfoVO.getShpr2()).append("\n");
				flatFile.append("SHPR3:").append(brBlLocInfoVO.getShpr3()).append("\n");
				flatFile.append("SHPR4:").append(brBlLocInfoVO.getShpr4()).append("\n");
				flatFile.append("SHPR5:").append(brBlLocInfoVO.getShpr5()).append("\n");
				flatFile.append("CNEE1:").append(brBlLocInfoVO.getCnee1()).append("\n");
				flatFile.append("CNEE2:").append(brBlLocInfoVO.getCnee2()).append("\n");
				flatFile.append("CNEE3:").append(brBlLocInfoVO.getCnee3()).append("\n");
				flatFile.append("CNEE4:").append(brBlLocInfoVO.getCnee4()).append("\n");
				flatFile.append("CNEE5:").append(brBlLocInfoVO.getCnee5()).append("\n");
				flatFile.append("NTFY1:").append(brBlLocInfoVO.getNtfy1()).append("\n");
				flatFile.append("NTFY2:").append(brBlLocInfoVO.getNtfy2()).append("\n");
				flatFile.append("NTFY3:").append(brBlLocInfoVO.getNtfy3()).append("\n");
				flatFile.append("NTFY4:").append(brBlLocInfoVO.getNtfy4()).append("\n");
				flatFile.append("NTFY5:").append(brBlLocInfoVO.getNtfy5()).append("\n");
				flatFile.append("NTFY21:").append(brBlLocInfoVO.getNtfy21()).append("\n");
				flatFile.append("NTFY22:").append(brBlLocInfoVO.getNtfy22()).append("\n");
				flatFile.append("NTFY23:").append(brBlLocInfoVO.getNtfy23()).append("\n");
				flatFile.append("NTFY24:").append(brBlLocInfoVO.getNtfy24()).append("\n");
				flatFile.append("NTFY25:").append(brBlLocInfoVO.getNtfy25()).append("\n");
				flatFile.append("FFWD1:").append(brBlLocInfoVO.getFfwd1()).append("\n");
				flatFile.append("FFWD2:").append(brBlLocInfoVO.getFfwd2()).append("\n");
				flatFile.append("FFWD3:").append(brBlLocInfoVO.getFfwd3()).append("\n");
				flatFile.append("FFWD4:").append(brBlLocInfoVO.getFfwd4()).append("\n");
				flatFile.append("FFWD5:").append(brBlLocInfoVO.getFfwd5()).append("\n");
				flatFile.append("EXPO1:").append(brBlLocInfoVO.getExpo1()).append("\n");
				flatFile.append("EXPO2:").append(brBlLocInfoVO.getExpo2()).append("\n");
				flatFile.append("EXPO3:").append(brBlLocInfoVO.getExpo3()).append("\n");
				flatFile.append("EXPO4:").append(brBlLocInfoVO.getExpo4()).append("\n");
				flatFile.append("EXPO5:").append(brBlLocInfoVO.getExpo5()).append("\n");
				flatFile.append("BLCOPY:").append(brBlLocInfoVO.getBlcopy()).append("\n");
				flatFile.append("BLORG:").append("1").append("\n");
				flatFile.append("BLPKG:").append(brBlLocInfoVO.getBlpkg()).append("\n");
				flatFile.append("BLPKGU:").append(brBlLocInfoVO.getBlpkgu()).append("\n");
				flatFile.append("BLWGT:").append(brBlLocInfoVO.getBlwgt()).append("\n");
				flatFile.append("BLMEA:").append(brBlLocInfoVO.getBlmea()).append("\n");
				flatFile.append("RDTYPE:").append(brBlLocInfoVO.getRdtype()).append("\n");
				flatFile.append("CARGOTYPE:").append(brBlLocInfoVO.getCargotype()).append("\n");
				flatFile.append("COMMODITY:").append(brBlLocInfoVO.getCommodity()).append("\n");
				flatFile.append("REMARK:").append(brBlLocInfoVO.getRemark()).append("\n");
				flatFile.append("AUS_QUAR:").append("").append("\n");
				flatFile.append("EU_ENTRY_OFC:").append(brBlLocInfoVO.getEuEntryOfc()).append("\n");
				flatFile.append("EU_ENTRY_OFC_NAME:").append(brBlLocInfoVO.getEuEntryOfcName()).append("\n");// 2014.11.24
				flatFile.append("EU_POD_OFC:").append(brBlLocInfoVO.getEuPodOfc()).append("\n");

				// 4. Rate 정보를 조회한다.
				List<BrRateInfoVO> brRateInfoVOList = dbDao.searchRateAmount(eurManifestTransmitVO);
				for (int idx = 0; idx < brRateInfoVOList.size(); idx++) {
					BrRateInfoVO brRateInfoVO = brRateInfoVOList.get(idx);
					flatFile.append("{CHARGE").append("\n");
					flatFile.append("FCTYPE:").append(brRateInfoVO.getFctype()).append("\n");
					flatFile.append("RATE:").append(brRateInfoVO.getRate()).append("\n");
					flatFile.append("REVENUETON:").append(brRateInfoVO.getRevenueton()).append("\n");
					flatFile.append("PPD:").append(brRateInfoVO.getPpd()).append("\n");
					flatFile.append("CCT:").append(brRateInfoVO.getCct()).append("\n");
					flatFile.append("CURRENCYCODE:").append(brRateInfoVO.getCurrencycode()).append("\n");
					flatFile.append("TARIFF:").append(brRateInfoVO.getTariff()).append("\n");
					flatFile.append("PERTYPE:").append(brRateInfoVO.getPertype()).append("\n");
					flatFile.append("}CHARGE").append("\n");
				} // end for(idx)

				// 5. Rate TOTAL 정보를 조회한다.
				List<BrRateInfoTTLVO> brRateInfoTTLVOList = dbDao.searchRateAmountTTL(eurManifestTransmitVO);

				for (int idx = 0; idx < brRateInfoTTLVOList.size(); idx++) {
					BrRateInfoTTLVO brRateInfoTTLVO = brRateInfoTTLVOList.get(idx);
					flatFile.append("{CHARGE_TTL").append("\n");
					flatFile.append("PPD_TOTAL:").append(brRateInfoTTLVO.getPpdTotal()).append("\n");
					flatFile.append("CCT_TOTAL:").append(brRateInfoTTLVO.getCctTotal()).append("\n");
					flatFile.append("TOTAL_CUR:").append(brRateInfoTTLVO.getTotalCur()).append("\n");
					flatFile.append("}CHARGE_TTL").append("\n");
				} // end for(idx)

				// 6. BKG의 Mark/Desc 정보를 조회한다.
				BrMndDescInfoVO brMndDescInfoVO = dbDao.searchMarkDescInfo(eurManifestTransmitVO);

				if (brMndDescInfoVO != null) {
					String cmdtDesc = brMndDescInfoVO.getCmdtDesc();
					String[] str1 = cmdtDesc.split("\n");
					String mkMark = brMndDescInfoVO.getMkMark();
					String[] str2 = mkMark.split("\n");

					flatFile.append("{DESC").append("\n");
					for (int idx = 0; idx < str1.length; idx++) {
						flatFile.append("DESC:").append(str1[idx]).append("\n");
					}
					flatFile.append("}DESC").append("\n");

					flatFile.append("{MARK").append("\n");
					for (int idx = 0; idx < str2.length; idx++) {
						flatFile.append("MARKNO:").append(str2[idx]).append("\n");
					}
					flatFile.append("}MARK").append("\n");
				}

				// 7. Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.
				eurManifestTransmitVO.setBkgCgoTp(brBlLocInfoVO.getInBkgCgoTpCd());
				eurManifestTransmitVO.setBkgSpeRf(brBlLocInfoVO.getInRcFlg());
				eurManifestTransmitVO.setBkgSpeDg(brBlLocInfoVO.getInDcgoFlg());
				eurManifestTransmitVO.setBkgSpeAk(brBlLocInfoVO.getInAwkCgoFlg());
				eurManifestTransmitVO.setBkgSpeBb(brBlLocInfoVO.getInBbCgoFlg());
				eurManifestTransmitVO.setCmdtDesc(brBlLocInfoVO.getInCmdtDesc());
				eurManifestTransmitVO.setCmdtCd(brBlLocInfoVO.getInCmdtCd());
				
				
				List<BrCntrRfAkBrCgoInfoVO> brCntrRfAkBrCgoInfoVOList = dbDao.searchCntrRfAkBrCgo(eurManifestTransmitVO);
				for (int cntrIdx = 0; cntrIdx < brCntrRfAkBrCgoInfoVOList.size(); cntrIdx++) {
					
					BrCntrRfAkBrCgoInfoVO brCntrRfAkBrCgoInfoVO = brCntrRfAkBrCgoInfoVOList.get(cntrIdx);

					eurManifestTransmitVO.setCntrCd(brCntrRfAkBrCgoInfoVO.getCntrnbr());

					flatFile.append("{CNTR_INFO").append("\n");

					flatFile.append("CNTRNBR:").append(brCntrRfAkBrCgoInfoVO.getCntrnbr()).append("\n");
					flatFile.append("PUNIT:").append(brCntrRfAkBrCgoInfoVO.getPunit()).append("\n");
					flatFile.append("PKG:").append(brCntrRfAkBrCgoInfoVO.getPkg()).append("\n");
					flatFile.append("CNTRWGT:").append(brCntrRfAkBrCgoInfoVO.getCntrwgt()).append("\n");
					flatFile.append("CNTRWGT_T:").append(brCntrRfAkBrCgoInfoVO.getCntrtrw()).append("\n");// 2014.11.24
					flatFile.append("CNTRTYPE:").append(brCntrRfAkBrCgoInfoVO.getCntrtype()).append("\n");
					flatFile.append("SEALNBR:").append(brCntrRfAkBrCgoInfoVO.getSealnbr()).append("\n");
					flatFile.append("FM_IND:").append(brCntrRfAkBrCgoInfoVO.getFmInd()).append("\n");
					flatFile.append("RF_IND:").append(brCntrRfAkBrCgoInfoVO.getRfInd()).append("\n");
					flatFile.append("DG_IND:").append(brCntrRfAkBrCgoInfoVO.getDgInd()).append("\n");
					flatFile.append("AK_IND:").append(brCntrRfAkBrCgoInfoVO.getAkInd()).append("\n");
					flatFile.append("BK_IND:").append(brCntrRfAkBrCgoInfoVO.getBkInd()).append("\n");
					flatFile.append("TEMP:").append(brCntrRfAkBrCgoInfoVO.getTemp()).append("\n");
					flatFile.append("TUNIT:").append(brCntrRfAkBrCgoInfoVO.getTunit()).append("\n");
					flatFile.append("VENT:").append(brCntrRfAkBrCgoInfoVO.getVent()).append("\n");
					flatFile.append("MEASURE:").append(brCntrRfAkBrCgoInfoVO.getMeasure()).append("\n");
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
					flatFile.append("VOID_SLOT:").append(brCntrRfAkBrCgoInfoVO.getVoidSlot()).append("\n");
					flatFile.append("STWG_REQ:").append(brCntrRfAkBrCgoInfoVO.getStwgReq()).append("\n");
					flatFile.append("MRN:").append(brCntrRfAkBrCgoInfoVO.getMvmtRefNo()).append("\n");
					flatFile.append("EXS_MRN:").append(brCntrRfAkBrCgoInfoVO.getExsMrn()).append("\n");
					flatFile.append("EXPORT_MRN:").append(brCntrRfAkBrCgoInfoVO.getExportMrn()).append("\n");
					flatFile.append("ATB:").append(brCntrRfAkBrCgoInfoVO.getAtb()).append("\n");// 2014.11.24
					flatFile.append("SUPL_TYPE:").append(brCntrRfAkBrCgoInfoVO.getSuplType()).append("\n");// 2014.11.24

					// SEND LOG의 BL_NO, CNTR_NO
					BkgCstmsEurDgEdiRspnVO blCntr = new BkgCstmsEurDgEdiRspnVO();
					blCntr.setEurEdiMsgTpId("CTA");
					blCntr.setMsgSndNo(snd.getMsgSndNo());
					blCntr.setEdiRspnSeq(String.valueOf(iEdiRspnSeq));
					blCntr.setBlNo(eurManifestTransmitVO.getBlNo());
					blCntr.setCntrNo(brCntrRfAkBrCgoInfoVO.getCntrnbr());
					blCntr.setCntrCgoSeq("");
					blCntr.setDgBlRefNo("");
					blCntr.setDgItmRefNo("");
					blCntr.setCreUsrId(account.getUsr_id());
					blCntr.setUpdUsrId(account.getUsr_id());
					iEdiRspnSeq++;
					rspnList.add(blCntr);
					// 9. 위험물 정보를 조회한다.
					List<BrDgInfoVO> brDgInfoVOList = dbDao.searchDangerCgo(eurManifestTransmitVO);

					for (int dgIdx = 0; dgIdx < brDgInfoVOList.size(); dgIdx++) {
						BrDgInfoVO brDgInfoVO = brDgInfoVOList.get(dgIdx);

						flatFile.append("{CNTR_DANGER").append("\n");
						flatFile.append("UNNBR:").append(brDgInfoVO.getUnnbr()).append("\n");
						flatFile.append("CLASS:").append(brDgInfoVO.getClass1()).append("\n");
						flatFile.append("DESC:").append(brDgInfoVO.getDgDesc()).append("\n");
						flatFile.append("PHONE:").append(brDgInfoVO.getPhone()).append("\n");
						flatFile.append("PAGE:").append(brDgInfoVO.getPage()).append("\n");
						flatFile.append("FLSH_TEMP:").append(brDgInfoVO.getFlshTemp()).append("\n");
						flatFile.append("FLSH_UNIT:").append(brDgInfoVO.getFlshUnit()).append("\n");
						flatFile.append("DG_REMARK:").append(brDgInfoVO.getDgRemark()).append("\n");
						flatFile.append("EMSNO:").append("").append("\n");// 2014.11.24
						flatFile.append("PSACLS:").append("").append("\n");// 2014.11.24
						flatFile.append("PKGGRP:").append(brDgInfoVO.getPkggrp()).append("\n");// 2014.11.24
						flatFile.append("MFAG1:").append("").append("\n");// 2014.11.24
						flatFile.append("MFAG2:").append("").append("\n");// 2014.11.24
						flatFile.append("MAR_POLL:").append("").append("\n");// 2014.11.24
						flatFile.append("LABEL_CD:").append("").append("\n");// 2014.11.24
						flatFile.append("LABEL_DESC:").append("").append("\n");// 2014.11.24
						flatFile.append("PKG:").append("").append("\n");// 2014.11.24
						flatFile.append("PKGUNIT:").append("").append("\n");// 2014.11.24
						flatFile.append("NWGT:").append("").append("\n");// 2014.11.24
						flatFile.append("GWGT:").append("").append("\n");// 2014.11.24
						flatFile.append("MEA:").append("").append("\n");// 2014.11.24
						flatFile.append("HAZ_CONT:").append("").append("\n");// 2014.11.24
						flatFile.append("STWG:").append("").append("\n");// 2014.11.24
						flatFile.append("}CNTR_DANGER").append("\n");
					}

					// 10. CNTR Desc 정보를 조회한다.
					List<EurCmVO> eurCmVOList = dbDao.searchCM(eurManifestTransmitVO);

					for (int cmIdx = 0; cmIdx < eurCmVOList.size(); cmIdx++) {
						EurCmVO eurCmVO = eurCmVOList.get(cmIdx);

						flatFile.append("{CNTR_DESC").append("\n");
						flatFile.append("D_CMDT:").append(eurCmVO.getDCmdt()).append("\n");
						flatFile.append("D_PUNIT:").append(eurCmVO.getDPunit()).append("\n");
						flatFile.append("D_PUNIT_DESC:").append(eurCmVO.getDPunitDesc()).append("\n");
						flatFile.append("D_PKG:").append(eurCmVO.getDPkg()).append("\n");
						flatFile.append("D_WGT:").append(eurCmVO.getDWgt()).append("\n");
						flatFile.append("D_MEAS:").append(eurCmVO.getDMeas()).append("\n");
						flatFile.append("D_DESC:").append(eurCmVO.getDDesc()).append("\n");
						flatFile.append("D_MRN_ITEM:").append(eurCmVO.getMfItmNo()).append("\n");
						flatFile.append("D_HTS_CD:").append(eurCmVO.getDHtsCd()).append("\n");
						flatFile.append("D_HS_CD:").append(eurCmVO.getDHsCd()).append("\n");
						flatFile.append("D_NCM_CD:").append(eurCmVO.getDNcmCd()).append("\n");

						String dMark = eurCmVO.getDMark();
						if (!"".equalsIgnoreCase(dMark)) {
							flatFile.append("{CUS_MARK").append("\n");
							flatFile.append(dMark.equals("") ? "D_MARK:" : dMark).append("\n");
							flatFile.append("}CUS_MARK").append("\n");
						}

						flatFile.append("}CNTR_DESC").append("\n");
					}
					flatFile.append("}CNTR_INFO").append("\n");
				} // end for(cntrIdx)

				// 11. BKG Qty를 조회한다.
				List<BkgQtyVO> bkgQtyVOList = dbDao.searchBkgQty(eurManifestTransmitVO);

				for (int idx = 0; idx < bkgQtyVOList.size(); idx++) {
					BkgQtyVO bkgQtyVO = bkgQtyVOList.get(idx);

					flatFile.append("{QTY").append("\n");
					flatFile.append("HANTYPE:").append(bkgQtyVO.getHantype()).append("\n");
					flatFile.append("COUNT:").append(bkgQtyVO.getCount()).append("\n");
					flatFile.append("}QTY").append("\n");
				}

				// 12. Vessel 정보, Vessel ETA 정보를 조회한다.
				List<EurEtaInfoVO> eurEtaInfoVOList = dbDao.searchVslInfoVsl(eurManifestTransmitVO);

				for (int idx = 0; idx < eurEtaInfoVOList.size(); idx++) {
					EurEtaInfoVO eurEtaInfoVO = eurEtaInfoVOList.get(idx);

					flatFile.append("{BKGVVD").append("\n");
					flatFile.append("BVVD:").append(eurEtaInfoVO.getBvvd()).append("\n");
					flatFile.append("BPOL:").append(eurEtaInfoVO.getBpol()).append("\n");
					flatFile.append("BPOL_NAME:").append(eurEtaInfoVO.getBpolName()).append("\n");
					flatFile.append("BPOD:").append(eurEtaInfoVO.getBpod()).append("\n");
					flatFile.append("BPOD_NAME:").append(eurEtaInfoVO.getBpodName()).append("\n");
					flatFile.append("}BKGVVD").append("\n");
				}
			} // end for
				
//			if (flatFile != null) {

				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EURCUS.IBMMQ.QUEUE"));
				FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E")) {
					throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage());
				}

				/* FlatFile을 4000Byte씩 나눈다 - start*/
				int divisor = 3900;
				int totLength = flatFile.length();
				int quotient = totLength / divisor;
				int remainder = totLength % divisor;

				int loopCnt = 0;
				int start = 0;
				int end = 0;

				if(remainder > 0) {
					loopCnt = quotient + 1;
				} else {
					loopCnt = quotient;
				}

				String[] fFiles = new String[loopCnt];

				for(int i = 0; i < loopCnt; i++) {
					if(i == loopCnt-1) {
						end = remainder;
					} else {
						end = divisor;
					}

					start = i * divisor;

					fFiles[i] = flatFile.substring(start, start+end);

					BkgCstmsEurDgSndLogVO desc = new BkgCstmsEurDgSndLogVO();
					desc.setEurEdiMsgTpId("CTA");
					desc.setMsgSndNo(snd.getMsgSndNo());
					desc.setSndLogSeq(String.valueOf(i + 1));
					desc.setCreUsrId(account.getUsr_id());
					desc.setUpdUsrId(account.getUsr_id());
					desc.setMsgDesc(fFiles[i]);
					sndLog.add(desc);
				}
//			}
			// LOG TABLE 등록
			dbDao.addSndLog(snd, sndLog, rspnList);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return flatFile.toString();		
			
		
	}
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.(SITPRO)
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException {
		
		EurManifestTransmitVO[] eurManifestTransmitVOs = (EurManifestTransmitVO[])manifestTransmitVOs;
		
		StringBuilder flatFile = new StringBuilder(BUFFERSIZE * 20);
		StringBuffer flatFileVvdInfo = new StringBuffer();

		BookingUtil command = null;
		SitproEdiVO sitproEdiVO = new SitproEdiVO();
		//String header = "";
		//String receiverId = ""; 
		String sendId = "";
		
		SitProVslInfoVO sitProVslInfoVO = null;
		
		String mrnNo = "";
		
		SitProCommodityVO		 sitProCommodityVO = null;
		SitProBlInfoVO 			 sitProBlInfoVO = null;
		SitProMsnInfoVO 		 sitProMsnInfoVO = null;
		SitProCmDescInfoVO 		 sitProCmDescInfoVO = null;
		
		
		List<SitProEuMrnInfoVO>  sitProEuMrnInfoVOs  =  null;
		SitProEuMrnInfoVO        sitProEuMrnInfoVO  =  null;
		
		List<SitProRateAmountVO> sitProRateAmountVOs = null;
		List<SitProRateAmountTTLVO> sitProRateAmountTTLVOs = null;
		SitProRateAmountVO sitProRateAmountVO = null;
		SitProRateAmountTTLVO sitProRateAmountTTLVO = null;
		
		BrVslCondVO brVslCondVO = new BrVslCondVO();
		BrMndDescInfoVO brMndDescInfoVO = null;
		
		List<SitProCntrRfAkBrCgoInfoVO> sitProCntrRfAkBrCgoInfoVOs = null;
		SitProCntrRfAkBrCgoInfoVO sitProCntrRfAkBrCgoInfoVO = null;
		
		SitProCntrSealListVO sitProCntrSealListVO = null;
		List<SitProCntrSealListVO> sitProCntrSealListVOs = null;
		int sitProCntrSealListVOsSize = 0;
		
		SitProDgInfoVO sitProDgInfoVO = null;
		List<SitProDgInfoVO> sitProDgInfoVOs = null;
		int sitProDgInfoVOsSize = 0;
		
		SitProCmInfoVO sitProCmInfoVO = null;
		List<SitProCmInfoVO> sitProCmInfoVOList = null;
		
		SitProBkgQtyVO sitProBkgQtyVO = null;
		
		List<SitProVslEtcInfoVO> sitProVslEtcInfoVOs = null;
		SitProVslEtcInfoVO sitProVslEtcInfoVO = null;
		
		SitProELNumberInfoVO sitProELNumberInfoVO = null;
		
		try {
			command = new BookingUtil();
			
				if(eurManifestTransmitVOs != null) {
					
					//bkgNoList = (List<SitProCargoManifesDetailVO>) dbDao.searchSitProList(sitProCargoManifestCondForEdiVO);
					int bkgNoListMaxSize = eurManifestTransmitVOs.length;
					
					for(int i = 0; i < bkgNoListMaxSize; i++) {
						
						sitproEdiVO.setBkgNo(eurManifestTransmitVOs[i].getBkgNo());
						sitproEdiVO.setBlNo(eurManifestTransmitVOs[i].getBlNo());
						
						if(i == 0) { 
							
							sitproEdiVO.setVvdCd(eurManifestTransmitVOs[i].getVvdCd());
							sitproEdiVO.setOfcCd(eurManifestTransmitVOs[i].getOfcCd());
							sitproEdiVO.setPolCd(eurManifestTransmitVOs[i].getPolCd());
							sitproEdiVO.setPodCd(eurManifestTransmitVOs[i].getPodCd());
							sitproEdiVO.setBndCd(eurManifestTransmitVOs[i].getBndCd());
							//receiverId = eurManifestTransmitVOs[i].getBkgOfcCd();
							sitproEdiVO.setCompId("");
							
							// send id 조회
							sendId = dbDao.searchEdiSendId(sitproEdiVO);
							
							if(sendId == null || sendId.equals("")) {
								sendId = ConstantMgr.getCompanyCode();
							}
							
							// FlatFile Header를 생성한다.
							//header = command.searchCstmsEdiHeader(sendId, receiverId, "SITPRO");
							
							
							CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
							// VSL/VVD정보 가져오기
							sitProVslInfoVO = dbDao.searchVslEtaEtd(sitproEdiVO);
							
							if ( sitProVslInfoVO != null) {
								log.debug("(((((((((((((((((((((((((((((((((((((((((((((((((");
								flatFileVvdInfo.append("VVD:")				.append(sitProVslInfoVO.getVvd()).append("\n");
								
								if(!"".equals(sitproEdiVO.getPolCd()) && !"".equals(sitproEdiVO.getPodCd()) ){
									flatFileVvdInfo.append("IB_CON_VVD:")		.append(comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPodCd(), "I")).append("\n");
									flatFileVvdInfo.append("OB_CON_VVD:")		.append(comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPolCd(), "O")).append("\n");
								}else if("".equals(sitproEdiVO.getPolCd()) && !"".equals(sitproEdiVO.getPodCd()) ){
									flatFileVvdInfo.append("IB_CON_VVD:")		.append(comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPodCd(), "I")).append("\n");
								}else if(!"".equals(sitproEdiVO.getPolCd()) && "".equals(sitproEdiVO.getPodCd()) ){
									flatFileVvdInfo.append("OB_CON_VVD:")		.append(comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPolCd(), "O")).append("\n");
								}

								flatFileVvdInfo.append("VSL_CALLSIGN:")		.append(sitProVslInfoVO.getVslCallsign()).append("\n");
								flatFileVvdInfo.append("VSL_LLOYDCODE:")	.append(sitProVslInfoVO.getVslLloydcode()).append("\n");
								flatFileVvdInfo.append("VSL_FULLNAME:")		.append(sitProVslInfoVO.getVslFullname()).append("\n");
								flatFileVvdInfo.append("VSL_FLAG:")			.append(sitProVslInfoVO.getVslRgstCntCd()).append("\n");
								flatFileVvdInfo.append("PORT:")				.append(sitProVslInfoVO.getPort()).append("\n");
								flatFileVvdInfo.append("PORTNAME:")			.append(sitProVslInfoVO.getPortname()).append("\n");
								flatFileVvdInfo.append("ETA:")				.append(sitProVslInfoVO.getEta()).append("\n");
								flatFileVvdInfo.append("ETD:")				.append(sitProVslInfoVO.getEtd()).append("\n");
								flatFileVvdInfo.append("ATA:")				.append(sitProVslInfoVO.getAta()).append("\n");
								flatFileVvdInfo.append("ATD:")				.append(sitProVslInfoVO.getAtd()).append("\n");
								flatFileVvdInfo.append("NEXTPORT:")			.append(sitProVslInfoVO.getNextport()).append("\n");
								flatFileVvdInfo.append("NEXTPORT_ETA:")		.append(sitProVslInfoVO.getNextportEta()).append("\n");
								flatFileVvdInfo.append("PREVPORT:")			.append(sitProVslInfoVO.getPrevport()).append("\n");
								flatFileVvdInfo.append("PREVPORT_ETD:")		.append(sitProVslInfoVO.getPrevportEtd()).append("\n");
								flatFileVvdInfo.append("IO_IND:")			.append(sitProVslInfoVO.getIoInd()).append("\n");
								flatFileVvdInfo.append("COMP_ID:")			.append(sitProVslInfoVO.getCompId()).append("\n");
							} else {
								log.debug(")))))))))))))))))))))))))))))))))))))))))))))))))");
								
								// booking vvd, pol, pod정보로 
								sitproEdiVO.setVvdCd(eurManifestTransmitVOs[i].getTvvdCd());
								sitproEdiVO.setPolCd(eurManifestTransmitVOs[i].getBPolCd());
								sitproEdiVO.setPodCd(eurManifestTransmitVOs[i].getBPodCd());
								sitProVslInfoVO = dbDao.searchBookingVslInfo(sitproEdiVO);
								
								if(sitProVslInfoVO != null) {

									flatFileVvdInfo.append("VVD:")				.append(sitProVslInfoVO.getVvd()).append("\n");
									
									if(!"".equals(sitproEdiVO.getPolCd()) && !"".equals(sitproEdiVO.getPodCd()) ){
										flatFileVvdInfo.append("IB_CON_VVD:")		.append(comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPodCd(), "I")).append("\n");
										flatFileVvdInfo.append("OB_CON_VVD:")		.append(comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPolCd(), "O")).append("\n");
									}else if("".equals(sitproEdiVO.getPolCd()) && !"".equals(sitproEdiVO.getPodCd()) ){
										flatFileVvdInfo.append("IB_CON_VVD:")		.append(comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPodCd(), "I")).append("\n");
									}else if(!"".equals(sitproEdiVO.getPolCd()) && "".equals(sitproEdiVO.getPodCd()) ){
										flatFileVvdInfo.append("OB_CON_VVD:")		.append(comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPolCd(), "O")).append("\n");
									}
									
									flatFileVvdInfo.append("VSL_CALLSIGN:")		.append("").append("\n");
									flatFileVvdInfo.append("VSL_LLOYDCODE:")	.append("").append("\n");
									flatFileVvdInfo.append("VSL_FULLNAME:")		.append(sitProVslInfoVO.getVslFullname()).append("\n");
									flatFileVvdInfo.append("VSL_FLAG:")			.append(sitProVslInfoVO.getVslRgstCntCd()).append("\n");
									flatFileVvdInfo.append("PORT:")				.append(sitProVslInfoVO.getPort()).append("\n");
									flatFileVvdInfo.append("PORTNAME:")			.append(sitProVslInfoVO.getPortname()).append("\n");
									flatFileVvdInfo.append("ETA:")				.append("").append("\n");
									flatFileVvdInfo.append("ETD:")				.append("").append("\n");
									flatFileVvdInfo.append("ATA:")				.append("").append("\n");
									flatFileVvdInfo.append("ATD:")				.append("").append("\n");
									flatFileVvdInfo.append("NEXTPORT:")			.append("").append("\n");
									flatFileVvdInfo.append("NEXTPORT_ETA:")		.append("").append("\n");
									flatFileVvdInfo.append("PREVPORT:")			.append("").append("\n");
									flatFileVvdInfo.append("PREVPORT_ETD:")		.append("").append("\n");
									flatFileVvdInfo.append("IO_IND:")			.append("").append("\n");
									flatFileVvdInfo.append("COMP_ID:")			.append(sitProVslInfoVO.getCompId()).append("\n");
								
								} else {
									
									flatFileVvdInfo.append("VVD:")				.append("").append("\n");
									flatFileVvdInfo.append("VSL_CALLSIGN:")		.append("").append("\n");
									flatFileVvdInfo.append("VSL_LLOYDCODE:")	.append("").append("\n");
									flatFileVvdInfo.append("VSL_FULLNAME:")		.append("").append("\n");
									flatFileVvdInfo.append("VSL_FLAG:")			.append("").append("\n");
									flatFileVvdInfo.append("PORT:")				.append("").append("\n");
									flatFileVvdInfo.append("PORTNAME:")			.append("").append("\n");
									flatFileVvdInfo.append("ETA:")				.append("").append("\n");
									flatFileVvdInfo.append("ETD:")				.append("").append("\n");
									flatFileVvdInfo.append("ATA:")				.append("").append("\n");
									flatFileVvdInfo.append("ATD:")				.append("").append("\n");
									flatFileVvdInfo.append("NEXTPORT:")			.append("").append("\n");
									flatFileVvdInfo.append("NEXTPORT_ETA:")		.append("").append("\n");
									flatFileVvdInfo.append("PREVPORT:")			.append("").append("\n");
									flatFileVvdInfo.append("PREVPORT_ETD:")		.append("").append("\n");
									flatFileVvdInfo.append("IO_IND:")			.append("").append("\n");
									flatFileVvdInfo.append("COMP_ID:")			.append("").append("\n");
								}
							}
								
							// mrn 정보 조회
							mrnNo = dbDao.searchMrnByVvdPort(sitproEdiVO);
							sitproEdiVO.setMrnNo(mrnNo);
								
							// FlatFile Header를 셋팅
							//flatFile.append(header).append("\n");
							
							// VSL/VVD정보 셋팅
							flatFile.append(flatFileVvdInfo.toString());

							// MRN 정보 셋팅
							flatFile.append("MRN:").append(mrnNo).append("\n");
							
						}
							
						// commodity desc정보를 조회한다.
						sitProCommodityVO = dbDao.searchCommodityDescByBkgNo(sitproEdiVO);

						sitproEdiVO.setCmdtNm(sitProCommodityVO.getCmdtNm());
						sitproEdiVO.setRepCmdtNm(sitProCommodityVO.getRepCmdtNm());
						// BL 일반 정보 및 location 정보를 조회한다.
						sitProBlInfoVO = dbDao.searchBlCustomerInfo(sitproEdiVO);
						
						flatFile.append("{BL_INFO")					.append("\n");
						
//						if(sitProBlInfoVO != null) {
							flatFile.append("BLNBR:")			.append(sitProBlInfoVO.getBlnbr()).append("\n");
							flatFile.append("BLPOL:")           .append(sitProBlInfoVO.getBlpol()).append("\n");
							flatFile.append("POL_AMS:")         .append(sitProBlInfoVO.getPolAms()).append("\n");
							flatFile.append("POL_FULLNAME:")    .append(sitProBlInfoVO.getPolFullname()).append("\n");
							flatFile.append("BLPOD:")           .append(sitProBlInfoVO.getBlpod()).append("\n");
							flatFile.append("POD_AMS:")         .append(sitProBlInfoVO.getPodAms()).append("\n");
							flatFile.append("POD_FULLNAME:")    .append(sitProBlInfoVO.getPodFullname()).append("\n");
							flatFile.append("BLPOR:")           .append(sitProBlInfoVO.getBlpor()).append("\n");
							flatFile.append("POR_AMS:")         .append(sitProBlInfoVO.getPorAms()).append("\n");
							flatFile.append("POR_FULLNAME:")    .append(sitProBlInfoVO.getPorFullname()).append("\n");
							flatFile.append("POR_YARD:")        .append(sitProBlInfoVO.getPorYard()).append("\n");
							flatFile.append("BLDEL:")           .append(sitProBlInfoVO.getBldel()).append("\n");
							flatFile.append("DEL_AMS:")         .append(sitProBlInfoVO.getDelAms()).append("\n");
							flatFile.append("DEL_FULLNAME:")    .append(sitProBlInfoVO.getDelFullname()).append("\n");
							flatFile.append("DEL_YARD:")        .append(sitProBlInfoVO.getDelYard()).append("\n");
							flatFile.append("FND_DEST:")        .append(sitProBlInfoVO.getFndDest()).append("\n");
							flatFile.append("SVC_SCP:")         .append(sitProBlInfoVO.getSvcScp()).append("\n");
							flatFile.append("BL_CMPL_STS:")     .append(sitProBlInfoVO.getBlCmplSts()).append("\n");
							flatFile.append("BL_CMPL_TP:")      .append(sitProBlInfoVO.getBlCmplTp()).append("\n");
							flatFile.append("BLRLY:")           .append(sitProBlInfoVO.getBlrly()).append("\n");
							flatFile.append("RLY_AMS:")         .append(sitProBlInfoVO.getRlyAms()).append("\n");
							flatFile.append("RLY_FULLNAME:")    .append(sitProBlInfoVO.getRlyFullname()).append("\n");
							flatFile.append("BLPLACE:")         .append(sitProBlInfoVO.getBlplace()).append("\n");
							flatFile.append("BLDATE:")          .append(sitProBlInfoVO.getBldate()).append("\n");
							flatFile.append("SHPRCN:")          .append(sitProBlInfoVO.getShprcn()).append("\n");
							flatFile.append("SHPRCD:")          .append(sitProBlInfoVO.getShprcd()).append("\n");
							flatFile.append("SHPR1:")           .append(sitProBlInfoVO.getShpr1()).append("\n");
							flatFile.append("SHPR2:")           .append(sitProBlInfoVO.getShpr2()).append("\n");
							flatFile.append("SHPR3:")           .append(sitProBlInfoVO.getShpr3()).append("\n");
							flatFile.append("SHPR4:")           .append(sitProBlInfoVO.getShpr4()).append("\n");
							flatFile.append("SHPR5:")           .append(sitProBlInfoVO.getShpr5()).append("\n");
							//SHPRTXID--추가 ######################### 2011.12.27
							flatFile.append("SHPRTXID:")        .append(sitProBlInfoVO.getShprtxid()).append("\n");
							flatFile.append("CNEECN:")          .append(sitProBlInfoVO.getCneecn()).append("\n");
							flatFile.append("CNEECD:")          .append(sitProBlInfoVO.getCneecd()).append("\n");
							flatFile.append("CNEE1:")           .append(sitProBlInfoVO.getCnee1()).append("\n");
							flatFile.append("CNEE2:")           .append(sitProBlInfoVO.getCnee2()).append("\n");
							flatFile.append("CNEE3:")           .append(sitProBlInfoVO.getCnee3()).append("\n");
							flatFile.append("CNEE4:")           .append(sitProBlInfoVO.getCnee4()).append("\n");
							flatFile.append("CNEE5:")           .append(sitProBlInfoVO.getCnee5()).append("\n");
							//CNEETXID --추가 ######################### 2011.12.27
							flatFile.append("CNEETXID:")        .append(sitProBlInfoVO.getCneetxid()).append("\n");
							flatFile.append("NTFYCN:")          .append(sitProBlInfoVO.getNtfycn()).append("\n");
							flatFile.append("NTFYCD:")          .append(sitProBlInfoVO.getNtfycd()).append("\n");
							flatFile.append("NTFY1:")           .append(sitProBlInfoVO.getNtfy1()).append("\n");
							flatFile.append("NTFY2:")           .append(sitProBlInfoVO.getNtfy2()).append("\n");
							flatFile.append("NTFY3:")           .append(sitProBlInfoVO.getNtfy3()).append("\n");
							flatFile.append("NTFY4:")           .append(sitProBlInfoVO.getNtfy4()).append("\n");
							flatFile.append("NTFY5:")           .append(sitProBlInfoVO.getNtfy5()).append("\n");
							//NTFYTXID --추가 ######################## 2011.12.27
							flatFile.append("NTFYTXID:")        .append(sitProBlInfoVO.getNtfytxid()).append("\n");
							flatFile.append("NTFY2CN:")         .append(sitProBlInfoVO.getNtfy2cn()).append("\n");
							flatFile.append("NTFY2CD:")         .append(sitProBlInfoVO.getNtfy2cd()).append("\n"); 
							flatFile.append("NTFY21:")          .append(sitProBlInfoVO.getNtfy21()).append("\n");
							flatFile.append("NTFY22:")          .append(sitProBlInfoVO.getNtfy22()).append("\n");
							flatFile.append("NTFY23:")          .append(sitProBlInfoVO.getNtfy23()).append("\n");
							flatFile.append("NTFY24:")          .append(sitProBlInfoVO.getNtfy24()).append("\n");
							flatFile.append("NTFY25:")          .append(sitProBlInfoVO.getNtfy25()).append("\n");
							//NTFY2TXID --추가 ######################## 2011.12.27
							flatFile.append("NTFY2TXID:")       .append("").append("\n");
							
							flatFile.append("FFWDCN:")          .append(sitProBlInfoVO.getFfwdcn()).append("\n");
							flatFile.append("FFWDCD:")          .append(sitProBlInfoVO.getFfwdcd()).append("\n");
							flatFile.append("FFWD1:")           .append(sitProBlInfoVO.getFfwd1()).append("\n");
							flatFile.append("FFWD2:")           .append(sitProBlInfoVO.getFfwd2()).append("\n"); 
							flatFile.append("FFWD3:")           .append(sitProBlInfoVO.getFfwd3()).append("\n"); 
							flatFile.append("FFWD4:")           .append(sitProBlInfoVO.getFfwd4()).append("\n"); 
							flatFile.append("FFWD5:")           .append(sitProBlInfoVO.getFfwd5()).append("\n");
							//FFWDTXID --추가 ######################## 2011.12.27
							flatFile.append("FFWDTXID:")       .append("").append("\n");
														
							flatFile.append("EXPOCN:")          .append(sitProBlInfoVO.getExpocn()).append("\n");
							flatFile.append("EXPOCD:")          .append(sitProBlInfoVO.getExpocd()).append("\n");
							flatFile.append("EXPO1:")           .append(sitProBlInfoVO.getExpo1()).append("\n");
							flatFile.append("EXPO2:")           .append(sitProBlInfoVO.getExpo2()).append("\n");
							flatFile.append("EXPO3:")           .append(sitProBlInfoVO.getExpo3()).append("\n");
							flatFile.append("EXPO4:")           .append(sitProBlInfoVO.getExpo4()).append("\n");
							flatFile.append("EXPO5:")           .append(sitProBlInfoVO.getExpo5()).append("\n");
							//EXPOTXID --추가 ######################## 2011.12.27
							flatFile.append("EXPOTXID:")       .append("").append("\n");
							
							flatFile.append("BLCOPY:")          .append(sitProBlInfoVO.getBlcopy()).append("\n");
							flatFile.append("BLORG:")           .append(sitProBlInfoVO.getBlorg()).append("\n");
							flatFile.append("BLPKG:")           .append(sitProBlInfoVO.getBlpkg()).append("\n");
							flatFile.append("BLPKGU:")          .append(sitProBlInfoVO.getBlpkgu()).append("\n");
							flatFile.append("BLWGT:")           .append(sitProBlInfoVO.getBlwgt()).append("\n");
							flatFile.append("BL_WGT_UNIT:")     .append(sitProBlInfoVO.getBlWgtUnit()).append("\n");
							flatFile.append("BLMEA:")           .append(sitProBlInfoVO.getBlmea()).append("\n");
							flatFile.append("BL_MEA_UNIT:")     .append(sitProBlInfoVO.getBlMeaUnit()).append("\n");
							flatFile.append("RDTYPE:")          .append(sitProBlInfoVO.getRdtype()).append("\n");
							flatFile.append("CARGOTYPE:")       .append(sitProBlInfoVO.getCargotype()).append("\n");
							flatFile.append("COMMODITY:")       .append(sitProBlInfoVO.getCommodity()).append("\n");
							flatFile.append("BLCMD:")           .append(sitProBlInfoVO.getBlcmd()).append("\n");
							flatFile.append("BLREPCMDCD:")      .append(sitProBlInfoVO.getBlrepcmdcd()).append("\n");
							flatFile.append("BLREPCMD:")        .append(sitProBlInfoVO.getBlrepcmd()).append("\n");
							flatFile.append("REMARK:")          .append(sitProBlInfoVO.getRemark()).append("\n");
							
							flatFile.append("AUS_QUAR:")        .append(sitProBlInfoVO.getAusQuar()).append("\n");
							
							flatFile.append("SRNBR:")           .append(sitProBlInfoVO.getSrnbr()).append("\n");
							flatFile.append("BKGNBR:")          .append(sitProBlInfoVO.getBkgnbr()).append("\n");
							flatFile.append("RGN_BKGNBR:")      .append(sitProBlInfoVO.getRgnBkgnbr()).append("\n");
							flatFile.append("CVRD_BY:")         .append(sitProBlInfoVO.getCvrdBy()).append("\n");
							flatFile.append("PPDOFC:")          .append(sitProBlInfoVO.getPpdofc()).append("\n");
							flatFile.append("PPD_PAYER:")       .append(sitProBlInfoVO.getPpdPayer()).append("\n");
							flatFile.append("CCTOFC:")          .append(sitProBlInfoVO.getCctofc()).append("\n");
							flatFile.append("CCT_PAYER:")       .append(sitProBlInfoVO.getCctPayer()).append("\n");
							flatFile.append("THDOFC:")          .append(sitProBlInfoVO.getThdofc()).append("\n");
							flatFile.append("SCNO:")            .append(sitProBlInfoVO.getScno()).append("\n");
							flatFile.append("RFANO:")           .append(sitProBlInfoVO.getRfano()).append("\n");
							
							flatFile.append("TW_SO_NO:")        .append(sitProBlInfoVO.getTwnSoNo()).append("\n");
							
							flatFile.append("WAYBILL_IND:")     .append(sitProBlInfoVO.getWaybillInd()).append("\n");
							flatFile.append("CUSTREF_NUM:")     .append(sitProBlInfoVO.getCustrefNum()).append("\n");
							flatFile.append("FINAL_ETA:")       .append(sitProBlInfoVO.getFinalEta()).append("\n");
							flatFile.append("FUNC_CODE:")       .append(sitProBlInfoVO.getFuncCode()).append("\n");
							flatFile.append("ONBOARD:")         .append(sitProBlInfoVO.getOnboard()).append("\n");
							flatFile.append("INV_NO:")          .append(sitProBlInfoVO.getInvNo()).append("\n");
							
							
//						}
						
						// msn정보를 조회한다.
						sitProMsnInfoVO = dbDao.searchMsnByBkg(sitproEdiVO);
						if(sitProMsnInfoVO != null) {
							flatFile.append("BLTS:")            .append( (sitProMsnInfoVO.getBlts() != null) ? sitProMsnInfoVO.getBlts() : ""  ).append("\n");
							flatFile.append("BLTP:")            .append( (sitProMsnInfoVO.getBltp() != null) ? sitProMsnInfoVO.getBltp() : ""  ).append("\n");
							flatFile.append("MSN:")             .append( (sitProMsnInfoVO.getMsnNbr() != null) ? sitProMsnInfoVO.getMsnNbr() : "" ).append("\n");
							flatFile.append("MSNCFM:")          .append( (sitProMsnInfoVO.getMsncfm() != null) ? sitProMsnInfoVO.getMsncfm() : "" ).append("\n");
						}
						
						// CM Desc 정보를 조회한다.
						sitProCmDescInfoVO = dbDao.searchBlCmDesc(sitproEdiVO);
						if(sitProCmDescInfoVO != null) {
							flatFile.append("CMDESC:")          .append(sitProCmDescInfoVO.getCmdesc()).append("\n");
							flatFile.append("LOCAL_IPI:")       .append(sitProCmDescInfoVO.getLocalIpi()).append("\n");
							flatFile.append("EQREL:")           .append(sitProCmDescInfoVO.getEqrel()).append("\n");
							flatFile.append("EQPICKDT:")        .append(sitProCmDescInfoVO.getEqpickdt()).append("\n");
							flatFile.append("EQRTN:")           .append(sitProCmDescInfoVO.getEqrtn()).append("\n");
						}
						
							
							flatFile.append("IND_AGREE:")       .append(sitProBlInfoVO.getIndAgree()).append("\n");
							flatFile.append("VALUE_AGREE:")     .append(sitProBlInfoVO.getValueAgree()).append("\n");
						
						
						
						// EU MRN 정보를 조회한다.
						sitProEuMrnInfoVOs = dbDao.searchEuMrnByBkg(sitproEdiVO);
						int sitProEuMrnInfoVOsMaxSize = sitProEuMrnInfoVOs.size();
						
						if (sitProEuMrnInfoVOsMaxSize > 0){
							
							for(int idx = 0; idx < sitProEuMrnInfoVOsMaxSize; idx++) {
								sitProEuMrnInfoVO = sitProEuMrnInfoVOs.get(idx);
								
								flatFile.append("{EU_MRN")				.append("\n");
								flatFile.append("EU_MRN_SEQ:")          .append((sitProEuMrnInfoVO.getEuMrnNo() != null) ? sitProEuMrnInfoVO.getEuMrnNo() : "").append("\n");
								flatFile.append("EU_MRN_VALUE:")        .append((sitProEuMrnInfoVO.getEuMrnValue() != null) ? sitProEuMrnInfoVO.getEuMrnValue() : "").append("\n");
								flatFile.append("EU_PORT:")             .append((sitProEuMrnInfoVO.getEuPort() != null) ? sitProEuMrnInfoVO.getEuPort() : "").append("\n");									
						        flatFile.append("EU_MRN_DATE:")         .append((sitProEuMrnInfoVO.getEuMrnDate() != null) ? sitProEuMrnInfoVO.getEuMrnDate() : "").append("\n");
						        flatFile.append("EU_MRN_SOURCE:")		.append((sitProEuMrnInfoVO.getEuMrnSource() != null) ? sitProEuMrnInfoVO.getEuMrnSource() : "").append("\n");
								flatFile.append("}EU_MRN")				.append("\n");
								
							} // end for(idx)
						}else{
							flatFile.append("{EU_MRN")				.append("\n");
							flatFile.append("EU_MRN_SEQ:")          .append("").append("\n");
							flatFile.append("EU_MRN_VALUE:")        .append("").append("\n");
							flatFile.append("EU_PORT:")             .append("").append("\n");	
						    flatFile.append("EU_MRN_DATE:")         .append("").append("\n");	
						    flatFile.append("EU_MRN_SOURCE:")		.append("").append("\n");
							flatFile.append("}EU_MRN")				.append("\n");							
						}
							
						
						// Rate 정보를 조회한다.
							sitProRateAmountVOs = dbDao.searchRateAmount(sitproEdiVO);
							if(sitProRateAmountVOs != null) {
								int sitProRateAmountVOsMaxSize = sitProRateAmountVOs.size();
								for(int idx = 0; idx < sitProRateAmountVOsMaxSize; idx++) {
									sitProRateAmountVO = sitProRateAmountVOs.get(idx);
									
									flatFile.append("{CHARGE")					.append("\n");
										flatFile.append("FCTYPE:")          	.append((sitProRateAmountVO.getFctype() != null) ? sitProRateAmountVO.getFctype() : "").append("\n");
										flatFile.append("RATE:")            	.append((sitProRateAmountVO.getRate() != null) ? sitProRateAmountVO.getRate() : "").append("\n");
										flatFile.append("REVENUETON:")          .append((sitProRateAmountVO.getRevenueton() != null) ? sitProRateAmountVO.getRevenueton() : "").append("\n");
										flatFile.append("PPD:")             	.append((sitProRateAmountVO.getPpd() != null) ? sitProRateAmountVO.getPpd() : "").append("\n");
										flatFile.append("CCT:")          		.append((sitProRateAmountVO.getCct() != null) ? sitProRateAmountVO.getCct() : "").append("\n");
										flatFile.append("CURRENCYCODE:")        .append((sitProRateAmountVO.getCurrencycode() != null) ? sitProRateAmountVO.getCurrencycode() : "").append("\n");
										flatFile.append("EXCHRATE:")       		.append((sitProRateAmountVO.getExchrate() != null) ? sitProRateAmountVO.getExchrate() : "").append("\n");
										flatFile.append("TARIFF:")       		.append((sitProRateAmountVO.getTariff() != null) ? sitProRateAmountVO.getTariff() : "").append("\n");
										flatFile.append("PERTYPE:")       		.append((sitProRateAmountVO.getPertype() != null) ? sitProRateAmountVO.getPertype() : "").append("\n");
										flatFile.append("RATEOFC:")       		.append((sitProRateAmountVO.getRateofc() != null) ? sitProRateAmountVO.getRateofc() : "").append("\n");
										flatFile.append("3RD_PAYER:")       	.append((sitProRateAmountVO.getThrPayer() != null) ? sitProRateAmountVO.getThrPayer() : "").append("\n");
									flatFile.append("}CHARGE")					.append("\n");
									
								} // end for(idx)
								
							}

						// Rate TOTAL 정보를 조회한다.
						sitProRateAmountTTLVOs = dbDao.searchRateAmountTTL(sitproEdiVO);
						if(sitProRateAmountTTLVOs != null) {
							int sitProRateAmountTTLVOsMaxSize = sitProRateAmountTTLVOs.size();
							if(sitProRateAmountTTLVOsMaxSize > 0) {
								for(int idx = 0; idx < sitProRateAmountTTLVOsMaxSize; idx++) {
									sitProRateAmountTTLVO = sitProRateAmountTTLVOs.get(idx);

									flatFile.append("{CHARGE_TTL")				.append("\n");
										flatFile.append("PPD_TOTAL:")          	.append(sitProRateAmountTTLVO.getPpdTotal()).append("\n");
										flatFile.append("CCT_TOTAL:")           .append(sitProRateAmountTTLVO.getCctTotal()).append("\n");
										flatFile.append("TOTAL_CUR:")           .append(sitProRateAmountTTLVO.getTotalCur()).append("\n");
									flatFile.append("}CHARGE_TTL")				.append("\n");

								} // end for(idx)
							} else {
								flatFile.append("{CHARGE_TTL")				.append("\n");
									flatFile.append("PPD_TOTAL:")          	.append("").append("\n");
									flatFile.append("CCT_TOTAL:")           .append("").append("\n");
									flatFile.append("TOTAL_CUR:")           .append("").append("\n");
								flatFile.append("}CHARGE_TTL")				.append("\n");
							}
							
							sitProRateAmountTTLVOs = null;
							sitProRateAmountTTLVO = null;
						}
						
						String ppdUsd = dbDao.searchPpdUsd(sitproEdiVO);
						String cctUsd = dbDao.searchCctUsd(sitproEdiVO);
						flatFile.append("PPD_USD:")         	.append(ppdUsd).append("\n");
						flatFile.append("CCT_USD:")         	.append(cctUsd).append("\n");
						
						// BKG의 Mark/Desc 정보를 조회한다. 
						brVslCondVO.setBkgNo(sitproEdiVO.getBkgNo());
						brMndDescInfoVO = dbDao.searchMarkDescInfo(brVslCondVO);
						
						if(brMndDescInfoVO != null) {
							String cmdtDesc = brMndDescInfoVO.getCmdtDesc();
							String[] str1 = cmdtDesc.split("\n");
							String mkMark = brMndDescInfoVO.getMkMark();
							String[] str2 = mkMark.split("\n");
							
							flatFile.append("{DESC")				.append("\n");
							for(int idx=0; idx < str1.length; idx++) {
								//if(str1[idx].length() >= 50) {
									flatFile.append("DESC:")          	.append(str1[idx]).append("\n");
								//}
							}
							flatFile.append("}DESC")				.append("\n");

							flatFile.append("{MARK")				.append("\n");
							for(int idx=0; idx < str2.length; idx++) {
									flatFile.append("MARKNO:")          	.append(str2[idx]).append("\n");
							}
							flatFile.append("}MARK")				.append("\n");
							
							brMndDescInfoVO = null;
						}
						
						// Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.
						sitproEdiVO.setBkgCgoTp(sitProBlInfoVO.getInBkgCgoTpCd());
						sitproEdiVO.setBkgSpeRf(sitProBlInfoVO.getInRcFlg());
						sitproEdiVO.setBkgSpeDg(sitProBlInfoVO.getInDcgoFlg());
						sitproEdiVO.setBkgSpeAk(sitProBlInfoVO.getInAwkCgoFlg());
						sitproEdiVO.setBkgSpeBb(sitProBlInfoVO.getInBbCgoFlg());
						sitproEdiVO.setBkgSpeRd(sitProBlInfoVO.getInRdCgoFlg());
						sitproEdiVO.setCmdtDesc(sitProBlInfoVO.getInCmdtDesc());
						sitproEdiVO.setCmdtCd(sitProBlInfoVO.getInCmdtCd());
						sitProBlInfoVO = null;
						
						sitProCntrRfAkBrCgoInfoVOs= dbDao.searchCntrRfAkCgo(sitproEdiVO);	
						if(sitProCntrRfAkBrCgoInfoVOs != null) {
							
							for(int cntrIdx=0; cntrIdx < sitProCntrRfAkBrCgoInfoVOs.size(); cntrIdx++) {
								sitProCntrRfAkBrCgoInfoVO = sitProCntrRfAkBrCgoInfoVOs.get(cntrIdx);
								
								flatFile.append("{CNTR_INFO")				.append("\n");

									flatFile.append("CNTRNBR:")			       .append(sitProCntrRfAkBrCgoInfoVO.getCntrnbr()).append("\n");							
									flatFile.append("PUNIT:")                  .append(sitProCntrRfAkBrCgoInfoVO.getPunit()).append("\n");
									flatFile.append("PKG:")                    .append(sitProCntrRfAkBrCgoInfoVO.getPkg()).append("\n");
									flatFile.append("CNTRWGT:")                .append(sitProCntrRfAkBrCgoInfoVO.getCntrwgt()).append("\n");
									flatFile.append("CNTRGWGT:")               .append(sitProCntrRfAkBrCgoInfoVO.getCntrgwgt()).append("\n");
									flatFile.append("CNTR_WGT_UNIT:")          .append(sitProCntrRfAkBrCgoInfoVO.getCntrWgtUnit()).append("\n");
									flatFile.append("CNTRTRW:")                .append(sitProCntrRfAkBrCgoInfoVO.getCntrtrw()).append("\n");
									flatFile.append("CNTRTYPE:")               .append(sitProCntrRfAkBrCgoInfoVO.getCntrtype()).append("\n");
									flatFile.append("SEALNBR:")                .append(sitProCntrRfAkBrCgoInfoVO.getSealnbr()).append("\n");
									flatFile.append("FM_IND:")                 .append(sitProCntrRfAkBrCgoInfoVO.getFmInd()).append("\n");
									flatFile.append("RF_IND:")                 .append(sitProCntrRfAkBrCgoInfoVO.getRfInd()).append("\n");
									flatFile.append("DG_IND:")                 .append(sitProCntrRfAkBrCgoInfoVO.getDgInd()).append("\n");
									flatFile.append("AK_IND:")                 .append(sitProCntrRfAkBrCgoInfoVO.getAkInd()).append("\n");
									flatFile.append("BK_IND:")                 .append(sitProCntrRfAkBrCgoInfoVO.getBkInd()).append("\n");
									//PL_IND -- 추가 ############################################################# 2011.12.27
									flatFile.append("PL_IND:")                 .append(sitProCntrRfAkBrCgoInfoVO.getPlInd()).append("\n");

									flatFile.append("TEMP:")                   .append(sitProCntrRfAkBrCgoInfoVO.getTemp()).append("\n");
									flatFile.append("TUNIT:")                  .append(sitProCntrRfAkBrCgoInfoVO.getTunit()).append("\n");
									flatFile.append("VENT:")                   .append(sitProCntrRfAkBrCgoInfoVO.getVent()).append("\n");
									flatFile.append("MEASURE:")                .append(sitProCntrRfAkBrCgoInfoVO.getMeasure()).append("\n");
									flatFile.append("MEASURE_UNIT:")           .append(sitProCntrRfAkBrCgoInfoVO.getMeasureUnit()).append("\n");
									flatFile.append("RDTYPE:")                 .append(sitProCntrRfAkBrCgoInfoVO.getRdtype()).append("\n");
									flatFile.append("CMDT_DESC:")              .append(sitProCntrRfAkBrCgoInfoVO.getCmdtDesc()).append("\n");
									flatFile.append("CMDTCD:")                 .append(sitProCntrRfAkBrCgoInfoVO.getCmdtCd()).append("\n");
									flatFile.append("RF_REMARK:")              .append(sitProCntrRfAkBrCgoInfoVO.getRfRemark()).append("\n");
									flatFile.append("RFDRY_IND:")              .append(sitProCntrRfAkBrCgoInfoVO.getRfdryInd()).append("\n");
									flatFile.append("OVF:")                    .append(sitProCntrRfAkBrCgoInfoVO.getOvf()).append("\n");
									flatFile.append("OVR:")                    .append(sitProCntrRfAkBrCgoInfoVO.getOvr()).append("\n");
									flatFile.append("OVH:")                    .append(sitProCntrRfAkBrCgoInfoVO.getOvh()).append("\n");
									flatFile.append("OVLW:")                   .append(sitProCntrRfAkBrCgoInfoVO.getOvlw()).append("\n");
									flatFile.append("OVRW:")                   .append(sitProCntrRfAkBrCgoInfoVO.getOvrw()).append("\n");
									flatFile.append("OVWGT:")                  .append(sitProCntrRfAkBrCgoInfoVO.getOvwgt()).append("\n");
									flatFile.append("OVWGT_UNIT:")             .append(sitProCntrRfAkBrCgoInfoVO.getOvwgtUnit()).append("\n");
									flatFile.append("VOID_SLOT:")              .append(sitProCntrRfAkBrCgoInfoVO.getVoidSlot()).append("\n");
									flatFile.append("STWG_REQ:")               .append(sitProCntrRfAkBrCgoInfoVO.getStwgReq()).append("\n");
									flatFile.append("SOCIND:")                 .append(sitProCntrRfAkBrCgoInfoVO.getSocind()).append("\n");
									flatFile.append("HAULAGE:")                .append(sitProCntrRfAkBrCgoInfoVO.getHaulage()).append("\n");
									flatFile.append("BKWGT:")                  .append(sitProCntrRfAkBrCgoInfoVO.getBkwgt()).append("\n");
									flatFile.append("BKWGTU:")                 .append(sitProCntrRfAkBrCgoInfoVO.getBkwgtu()).append("\n");
									flatFile.append("BKW:")                    .append(sitProCntrRfAkBrCgoInfoVO.getBkw()).append("\n");
									flatFile.append("BKH:")                    .append(sitProCntrRfAkBrCgoInfoVO.getBkh()).append("\n");
									flatFile.append("BKL:")                    .append(sitProCntrRfAkBrCgoInfoVO.getBkl()).append("\n");
									flatFile.append("CNTROWN:")                .append(sitProCntrRfAkBrCgoInfoVO.getCntrown()).append("\n");
									flatFile.append("CNTRTRM:")                .append(sitProCntrRfAkBrCgoInfoVO.getCntrtrm()).append("\n");
									
									
									flatFile.append("NOD_DEMURRAGE_FREETIME:") .append(sitProCntrRfAkBrCgoInfoVO.getNodDemFt()).append("\n");
									
									// Cntr No 셋팅
									sitproEdiVO.setCntrNo(sitProCntrRfAkBrCgoInfoVO.getCntrNo());

									// Multi Seal No. 보여주도록 로직 추가 ( 기존 Seal No. 단건에 대한 항목은 유지 )
									sitProCntrSealListVOs = dbDao.searchCntrSealNo(sitproEdiVO);
									sitProCntrSealListVOsSize = sitProCntrSealListVOs.size();
									if(sitProCntrSealListVOs != null) {
										for(int sealNoIdx = 0; sealNoIdx < sitProCntrSealListVOsSize; sealNoIdx++) {
											sitProCntrSealListVO = sitProCntrSealListVOs.get(sealNoIdx);
											flatFile.append("{CNTR_SEALS").append("\n");
										    flatFile.append("SEALSEQ:").append(sitProCntrSealListVO.getSealSeq()).append("\n");
										    flatFile.append("SEALNBR:").append(sitProCntrSealListVO.getSealNbr()).append("\n");
										    flatFile.append("SEAL_PRINT_FLAG:").append(sitProCntrSealListVO.getPrnFlg()).append("\n");
										    flatFile.append("}CNTR_SEALS").append("\n");
										}//end for sitProCntrSealListVOs
									}

									//  위험물 정보를 조회한다.
									sitProDgInfoVOs = dbDao.searchDangerCgo(sitproEdiVO);
									sitProDgInfoVOsSize = sitProDgInfoVOs.size();
									if(sitProDgInfoVOs != null) {
										for(int dgIdx=0; dgIdx<sitProDgInfoVOsSize; dgIdx++) {
											sitProDgInfoVO = sitProDgInfoVOs.get(dgIdx);
											
											flatFile.append("{CNTR_DANGER")				.append("\n");
												flatFile.append("UNNBR:")			.append(sitProDgInfoVO.getUnnbr()).append("\n");
												flatFile.append("CLASS:")           .append(sitProDgInfoVO.getClass1()).append("\n");
												flatFile.append("DG_DESC:")         .append(sitProDgInfoVO.getDgDesc()).append("\n");
												flatFile.append("CONTACT_NM:")      .append(sitProDgInfoVO.getContactNm()).append("\n");
												flatFile.append("PHONE:")           .append(sitProDgInfoVO.getPhone()).append("\n");
												flatFile.append("PAGE:")            .append(sitProDgInfoVO.getPage()).append("\n");
												flatFile.append("FLSH_TEMP:")	    .append(sitProDgInfoVO.getFlshTemp()).append("\n");
												flatFile.append("FLSH_UNIT:")	    .append(sitProDgInfoVO.getFlshUnit()).append("\n");
												flatFile.append("DG_REMARK:")	    .append(sitProDgInfoVO.getDgRemark()).append("\n");
												flatFile.append("EMSNO:")			.append(sitProDgInfoVO.getEmsno()).append("\n");
												flatFile.append("PSACLS:")		    .append(sitProDgInfoVO.getPsacls()).append("\n");
												flatFile.append("PKGGRP:")		    .append(sitProDgInfoVO.getPkggrp()).append("\n");
												flatFile.append("MFAG1:")			.append(sitProDgInfoVO.getMfag1()).append("\n");
												flatFile.append("MFAG2:")			.append(sitProDgInfoVO.getMfag2()).append("\n");
												flatFile.append("MAR_POLL:")	    .append(sitProDgInfoVO.getMarPoll()).append("\n");
												flatFile.append("LABEL_CD:")	    .append(sitProDgInfoVO.getLabelCd()).append("\n");
												flatFile.append("LABEL_DESC:")      .append(sitProDgInfoVO.getLabelDesc()).append("\n");
												flatFile.append("D_PKG:")			.append(sitProDgInfoVO.getDPkg()).append("\n");
												flatFile.append("D_PKGUNIT:")	    .append(sitProDgInfoVO.getDPkgunit()).append("\n");
												flatFile.append("NWGT:")			.append(sitProDgInfoVO.getNwgt()).append("\n");
												flatFile.append("NWGT_UNIT:")	    .append(sitProDgInfoVO.getNwgtUnit()).append("\n");
												flatFile.append("GWGT:")			.append(sitProDgInfoVO.getGwgt()).append("\n");
												flatFile.append("GWGT_UNIT:")	    .append(sitProDgInfoVO.getGwgtUnit()).append("\n");
												flatFile.append("MEA:")				.append(sitProDgInfoVO.getMea()).append("\n");
												flatFile.append("MEA_UNIT:")	    .append(sitProDgInfoVO.getMeaUnit()).append("\n");
												flatFile.append("HAZ_CONT:")	    .append(sitProDgInfoVO.getHazCont()).append("\n");
												flatFile.append("STWG:")			.append(sitProDgInfoVO.getStwg()).append("\n");
												flatFile.append("LABEL:")			.append(sitProDgInfoVO.getLabel()).append("\n");
											flatFile.append("}CNTR_DANGER")				.append("\n");
											
										}
										
									}
									
									//  CNTR Desc 정보를 조회한다.
									sitProCmInfoVOList = dbDao.searchCmByCntr(sitproEdiVO);
									
									if(sitProCmInfoVOList != null) {
										int sitProCmInfoVOListSize = sitProCmInfoVOList.size();
										for(int cmIdx=0; cmIdx<sitProCmInfoVOListSize; cmIdx++) {
											sitProCmInfoVO = sitProCmInfoVOList.get(cmIdx);

											flatFile.append("{CNTR_DESC")				.append("\n");
												flatFile.append("D_CMDT:")             	.append(sitProCmInfoVO.getDCmdt()).append("\n");
												flatFile.append("D_PUNIT:")             .append(sitProCmInfoVO.getDPunit()).append("\n");
												flatFile.append("D_PKG:")             	.append(sitProCmInfoVO.getDPkg()).append("\n");
												flatFile.append("D_WGT:")             	.append(sitProCmInfoVO.getDWgt()).append("\n");
												flatFile.append("D_MEAS:")             	.append(sitProCmInfoVO.getDMeas()).append("\n");
												flatFile.append("D_DESC:")             	.append(sitProCmInfoVO.getDDesc()).append("\n");
												flatFile.append("D_CTMS_REF:")          .append(sitProCmInfoVO.getDCtmsRef()).append("\n");
												flatFile.append("D_HTS_CD:")            .append(sitProCmInfoVO.getDHtsCd()).append("\n");
												flatFile.append("D_HS_CD:")             .append(sitProCmInfoVO.getDHsCd()).append("\n");
												flatFile.append("D_NCM_CD:")            .append(sitProCmInfoVO.getDNcmCd()).append("\n");
												
													String dMark = sitProCmInfoVO.getDMark();
													if(!"".equals(dMark)) {
														flatFile.append("{CUS_MARK")				.append("\n");
															flatFile.append(dMark).append("\n");
														flatFile.append("}CUS_MARK")				.append("\n");
													}
											flatFile.append("}CNTR_DESC")				.append("\n");
										}
									}
									
								flatFile.append("}CNTR_INFO")				.append("\n");
								

								
							} // end for(cntrIdx)
							
							// qty 정보를 조회한다.
							sitProBkgQtyVO = dbDao.searchBkgQty(sitproEdiVO);
							if(sitProBkgQtyVO != null) {
								flatFile.append("{QTY")				.append("\n");
									flatFile.append("HANTYPE:")     	.append(sitProBkgQtyVO.getHantype()).append("\n");
									flatFile.append("COUNT:")       	.append(sitProBkgQtyVO.getCount()).append("\n");
								flatFile.append("}QTY")				.append("\n");
								sitProBkgQtyVO = null;
							}

							//  Vessel 정보, Vessel ETA 정보를 조회한다. 
							sitProVslEtcInfoVOs = dbDao.searchVslEtcInfoVsl(sitproEdiVO);
							if(sitProVslEtcInfoVOs != null) {
								boolean isPre = true;
								int prePostIdx = 1;
								
								int sitProVslEtcInfoVOsMaxSize = sitProVslEtcInfoVOs.size();
								for(int idx = 0; idx < sitProVslEtcInfoVOsMaxSize; idx++)  {
								
									sitProVslEtcInfoVO = sitProVslEtcInfoVOs.get(idx);
									flatFile.append("{BKGVVD")				.append("\n");
								
										if(!"T".equals(sitProVslEtcInfoVO.getVslPrePstCd())){
											if(isPre){
												flatFile.append("VVDTYPE:")				.append("PRE" + prePostIdx).append("\n");
												prePostIdx++;
											}else{
												flatFile.append("VVDTYPE:")				.append("POST" + prePostIdx).append("\n");
												prePostIdx++;												
											}
										}else{
											flatFile.append("VVDTYPE:")				.append("TRUNK").append("\n");
											isPre = false;
											prePostIdx = 1;
										}
										//flatFile.append("VVDTYPE:")				.append(sitProVslEtcInfoVO.getVvdtype()).append("\n");
										flatFile.append("LANE_CD:")				.append(sitProVslEtcInfoVO.getLaneCd()).append("\n");
									
										flatFile.append("BVVD1:")				.append(sitProVslEtcInfoVO.getBvvd1()).append("\n");
										flatFile.append("VSL_CALLSIGN1:")     	.append(sitProVslEtcInfoVO.getVslCallsign1()).append("\n");
										flatFile.append("VSL_LLOYDCODE1:")    	.append(sitProVslEtcInfoVO.getVslLloydcode1()).append("\n");
										flatFile.append("VSL_FULLNAME1:")    	.append(sitProVslEtcInfoVO.getVslFullname1()).append("\n");
										flatFile.append("VSL_FLAG1:")    		.append(sitProVslEtcInfoVO.getVslRgstCntCd1()).append("\n");
										flatFile.append("BLPOL1:")            	.append(sitProVslEtcInfoVO.getBlpol1()).append("\n");
										flatFile.append("POL_YD:")            	.append(sitProVslEtcInfoVO.getPolYd()).append("\n");
										flatFile.append("POL_FULLNAME1:")     	.append(sitProVslEtcInfoVO.getPolFullname1()).append("\n");
										flatFile.append("BLPOD1:")            	.append(sitProVslEtcInfoVO.getBlpod1()).append("\n");
										flatFile.append("POD_YD:")            	.append(sitProVslEtcInfoVO.getPodYd()).append("\n");
										flatFile.append("POD_FULLNAME1:")     	.append(sitProVslEtcInfoVO.getPodFullname1()).append("\n");
										flatFile.append("POLETA1:")           	.append(sitProVslEtcInfoVO.getPoleta1()).append("\n");
										flatFile.append("POLETD1:")           	.append(sitProVslEtcInfoVO.getPoletd1()).append("\n");
										flatFile.append("PODETA1:")           	.append(sitProVslEtcInfoVO.getPodeta1()).append("\n");
										flatFile.append("PODETD1:")           	.append(sitProVslEtcInfoVO.getPodetd1()).append("\n");
										flatFile.append("OP_CODE:")           	.append(sitProVslEtcInfoVO.getOpCode()).append("\n");
									flatFile.append("}BKGVVD")				.append("\n");
								} // end for(idx)
								
							}		
							
							// EL Number를 조회한다..
							sitproEdiVO.setBltp(sitProMsnInfoVO.getBltp());
							sitproEdiVO.setBlts(sitProMsnInfoVO.getBlts());
							sitproEdiVO.setMsncfm(sitProMsnInfoVO.getMsncfm());
							sitProELNumberInfoVO = dbDao.searchELNumberByBkg(sitproEdiVO);
							
							if(sitProELNumberInfoVO != null) {
								flatFile.append("{ELNO")				.append("\n");
									flatFile.append("ELNO:")     	.append(sitProELNumberInfoVO.getElno()).append("\n");
									flatFile.append("ELPK:")     	.append(sitProELNumberInfoVO.getElpk()).append("\n");
									flatFile.append("ELPKU:")     	.append(sitProELNumberInfoVO.getElpku()).append("\n");
									flatFile.append("ELWT:")     	.append(sitProELNumberInfoVO.getElwt()).append("\n");
									flatFile.append("ELWTU:")     	.append(sitProELNumberInfoVO.getElwtu()).append("\n");
								flatFile.append("}ELNO")				.append("\n");
							}
							
						} // end if(sitProCntrRfAkBrCgoInfoVOs != null) {

						flatFile.append("}BL_INFO")					.append("\n");
					} // end for(i)
					
				} 
				
				/*
				log.debug("FF***********************************************************");
				log.debug(flatFile.toString());
				log.debug("***********************************************************FF");
				*/
	
				if (!"Y".equals(eurManifestTransmitVOs[0].getEdiPreview())) {
						SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
						sendFlatFileVO.setFlatFile(flatFile.toString());
						sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR.IBMMQ.QUEUE"));
						
						FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
						
						if ( flatFileAckVO.getAckStsCd().equals("E") ) {
							throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage());
						}
				}
 		 
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return flatFile.toString();	
	}	
	
	
	/**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다.<br>
	 * 
	 * @param  String rcvMsg
	 * @param  String userId
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String userId) throws EventException {
	
		log.info("<<<<<<<<<< loadCstmsRcvMsg Start >>>>>>>>>>>>>>>>");
		
		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");

		List<String> tmpArray = new ArrayList<String>();
		String tmpStr = "";
		String keyAndValue[] = null;
		String regex = ":";
		int tmpArrayMaxSize = 0;
		String revKey = "";
		String rcvLogSeq = "";
		
		String key = "";
		String value = "";
		
		String rcvId = "";
		
		String keyType = "CTA";
		String msgTpId = "CTA";

		EurRcvMsgVO eurRcvMsgVO = null;
		EurRcvMsgDtlVO eurRcvMsgDtlVO = null;
		List<EurRcvMsgDtlVO> eurRcvMsgDtlVOs = new ArrayList<EurRcvMsgDtlVO>();
		
		try {
			
			eurRcvMsgVO = new EurRcvMsgVO();
			
			while (token.hasMoreTokens()) {
				tmpArray.add(token.nextToken());
			}

			tmpArrayMaxSize = tmpArray.size();
			
			if(tmpArray != null && tmpArrayMaxSize > 0) {
				
				revKey = dbDao.searchEdiHistoryKey("CTAHAM", keyType, "", "", ""); 		// msg_rcv_no
				
				eurRcvMsgVO.setKeyVal(revKey);
				eurRcvMsgVO.setMsgTpId(msgTpId);
				
				for ( int i=0 ; i<tmpArrayMaxSize ; i++ ){
					
					tmpStr = tmpArray.get(i).toString().trim();
					
					if(tmpStr.equalsIgnoreCase("{ERRORS")) {
						eurRcvMsgDtlVO = new EurRcvMsgDtlVO();
						eurRcvMsgDtlVO.setKeyVal(revKey);
						eurRcvMsgDtlVO.setMsgTpId(msgTpId);						
						
						eurRcvMsgDtlVO.setCreUsrId(rcvId);
						eurRcvMsgDtlVO.setUpdUsrId(rcvId);
						
					}
					
					if(tmpStr.equalsIgnoreCase("}ERRORS")) {
						eurRcvMsgDtlVOs.add(eurRcvMsgDtlVO);
					}
					
					
					if(tmpStr.equalsIgnoreCase("{ERRORS") || tmpStr.equalsIgnoreCase("}ERRORS") ) continue;
					
					keyAndValue = tmpStr.split(regex);
					
					key = keyAndValue[0].trim();
					
					
					if(keyAndValue.length == 1) { 
						value = "";
					} else if(keyAndValue.length >= 2) {
						value = keyAndValue[1].trim();
					}
					
					if(key.equalsIgnoreCase("ORG_MSG_RCV")) {
						
						rcvId = value;
						eurRcvMsgVO.setCreUsrId(rcvId);
						eurRcvMsgVO.setUpdUsrId(rcvId);

					} else if(key.equalsIgnoreCase("ORG_MSG_TP")) {
						eurRcvMsgVO.setOrgMsgTp(value);
					} else if(key.equalsIgnoreCase("ORG_MSG_NM")) {
						eurRcvMsgVO.setOrgMsgNm(value);
					} else if(key.equalsIgnoreCase("MSG_UDT_FLG")) {
						eurRcvMsgVO.setMsgUdtFlg(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_TP")) {
						eurRcvMsgVO.setMsgAckTp(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_RSLT")) {
						eurRcvMsgVO.setMsgAckRslt(value); 
					} else if(key.equalsIgnoreCase("MSG_ACK_DT")) {
						eurRcvMsgVO.setMsgAckDt(value);
					} else if(key.equalsIgnoreCase("MSG_APPROVE_DT")) {
						eurRcvMsgVO.setMsgApproveDt(value);
					} else if(key.equalsIgnoreCase("MSG_PHONE")) {
						eurRcvMsgVO.setMsgPhone(value);
					} else if(key.equalsIgnoreCase("MSG_FAX")) {
						eurRcvMsgVO.setMsgFax(value);
					} else if(key.equalsIgnoreCase("ORG_MSG_CNTR")) {
						eurRcvMsgVO.setOrgMsgCntr(value);
					} else if(key.equalsIgnoreCase("ORG_MSG_BL")) {
						eurRcvMsgVO.setOrgMsgBl(value);
					} else if(key.equalsIgnoreCase("ERR_CODE")) {
						eurRcvMsgDtlVO.setCstmsErrId(value);
					} else if(key.equalsIgnoreCase("ERR_MSG")) {
						eurRcvMsgDtlVO.setCstmsErrMsg(value);
					} else if(key.equalsIgnoreCase("ERR_RFF_1")) {
						eurRcvMsgDtlVO.setCstmsErrRefNo1(value);
					} else if(key.equalsIgnoreCase("ERR_RFF_2")) {
						eurRcvMsgDtlVO.setCstmsErrRefNo2(value);
					} else if(key.equalsIgnoreCase("SEC_FILE_NBR")) {
						eurRcvMsgVO.setSecFileNbr(value);
					} else if(key.equalsIgnoreCase("MSG_ACCEPT_REF")) {
						eurRcvMsgVO.setMsgAcceptRef(value);
					}
					
					
					
					
				} // end for(i)
				
				rcvLogSeq = dbDao.searchRcvLogSeq("CTA", revKey); 	// rcv_log_seq

				// 수신마스터 저장
				eurRcvMsgVO.setRcvLogSeq(rcvLogSeq);
				
				if (StringUtils.isEmpty(eurRcvMsgVO.getCreUsrId()))
				{
					eurRcvMsgVO.setCreUsrId("RCV");
					eurRcvMsgVO.setUpdUsrId("RCV");
				}
				dbDao.addAck(eurRcvMsgVO);
				
				for(int i = 0; i < eurRcvMsgDtlVOs.size(); i++) {
					eurRcvMsgDtlVOs.get(i).setRcvLogSeq(rcvLogSeq);
				}
				
				// 수신 디테일 저장
				dbDao.addAckDtl(eurRcvMsgDtlVOs);
			}
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		log.info("<<<<<<<<<< loadCstmsRcvMsg end >>>>>>>>>>>>>>>>");
		

	}
	
	/**
	 * SIT PRO화면에서 메인 그리드 조회
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @return List<SitProCargoManifesDetailVO>
	 * @throws EventException
	 */
	public List<SitProCargoManifesDetailVO> searchSitProList(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) throws EventException {
		
		try {
			
			return dbDao.searchSitProList(sitProCargoManifestCondForEdiVO);
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * BackEndJob을 실행.(CTA)
	 * 
	 * @param account
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, 
			ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException{

		EurCustomsTransmissionBackEndJob backEndJob = new EurCustomsTransmissionBackEndJob ();
		backEndJob.setPgmNo(pgmNo);
		backEndJob.setAccount(account);
		String resultStr = "";
		
		if(pgmNo.equals("ESM_BKG_0257")) {	// CTA
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "CTA Transmit");
		}
		
		return resultStr;
	}
	
	/**
	 * BackEndJob을 실행.(Sitpro)
	 * 
	 * @param String usrId
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startBackEndJob(String usrId,	ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException{

		EurCustomsTransmissionBackEndJob backEndJob = new EurCustomsTransmissionBackEndJob ();
		backEndJob.setPgmNo(pgmNo);
		backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
		String divStr = "EDI Preview";
		if (pgmNo.equals("ESM_BKG_0484")) {    // Sitpro || EDI Preview
			EurManifestTransmitVO[] eurManifestTransmitVOs = (EurManifestTransmitVO[])manifestTransmitVOs;
			if (!"Y".equals(eurManifestTransmitVOs[0].getEdiPreview())) divStr = "Sitpro Transmit";
		}
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		return backEndJobManager.execute(backEndJob , usrId, divStr);
	}
	
	/**
	 * 대상 BKG_NO 리스트 존재여부를 조회한다.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String searchExistBkgNoList(ManifestTransmitVO manifestTransmitVO) throws EventException {
		
		String retVal = "";
		
		try {
			retVal = dbDao.searchExistBkgNoList((EurManifestTransmitVO)manifestTransmitVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return retVal;

	}
	
	/**
	 * sitpro - vvd와 port 존재여부를 조회한다.<br>
	 * 
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @return String
	 * @throws EventException
	 */
	public String searchExistVvdPort(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) throws EventException {
		
		String retVal = "";
		
		try {
			retVal = dbDao.searchExistVvdPort(sitProCargoManifestCondForEdiVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return retVal;

	}

	/**
	 * 구주 SIT PRO프로그램에서 ENS Download 메서드로 사용함<br>
	 * 
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @param String[] bkgNos
	 * @return List<SitProENSDownExcelVO>
	 * @throws EventException
	 */
	public List<SitProENSDownExcelVO> searchENSDownExcel(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO,String[] bkgNos) throws EventException {
		try {
			return dbDao.searchENSDownExcel(sitProCargoManifestCondForEdiVO,bkgNos);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다.<br>
	 * Customs Reference# I/F from Local System to ALPS (스페인, 포르투갈)<br>
	 * 
	 * @param  String rcvMsg
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadCstmsRcvMsg(String rcvMsg) throws EventException {
	
		log.info("<<<<<<<<<< loadCstmsRcvMsg Start >>>>>>>>>>>>>>>>");
		
		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");

		ArrayList tmpArray = new ArrayList();
		String tmpStr = "";
		String keyAndValue[] = null;
		String regex = ":";
		int tmpArrayMaxSize = 0;
		
		String key = "";
		String value = "";
		
		EurCrnRcvMsgVO eurCrnRcvMsgMasterVO = null;
		EurCrnRcvMsgVO eurCrnRcvMsgDetailVO = null;
		List<EurCrnRcvMsgVO> eurCrnRcvMsgDetailVOs = new ArrayList();
		
		
		try {
			
			eurCrnRcvMsgMasterVO = new EurCrnRcvMsgVO();
			
			while (token.hasMoreTokens()) {
				tmpArray.add(token.nextToken());
			}

			tmpArrayMaxSize = tmpArray.size();
			
			if(tmpArray != null && tmpArrayMaxSize > 0) {

				for ( int i=0 ; i<tmpArrayMaxSize ; i++ ){
					
					tmpStr = tmpArray.get(i).toString().trim();
					
					
					if(tmpStr.equalsIgnoreCase("{CNTR_DETAILS") || tmpStr.equalsIgnoreCase("}CNTR_DETAILS") ) continue;
					
					if(tmpStr.equalsIgnoreCase("{GOODS_ITEM_DETAILS")) {
						eurCrnRcvMsgDetailVO = new EurCrnRcvMsgVO();
						eurCrnRcvMsgDetailVO = (EurCrnRcvMsgVO) eurCrnRcvMsgMasterVO.clone();
					}
					
					if(tmpStr.equalsIgnoreCase("}GOODS_ITEM_DETAILS")) {
						eurCrnRcvMsgDetailVOs.add(eurCrnRcvMsgDetailVO);
					}
					
					
					keyAndValue = tmpStr.split(regex);

					key = keyAndValue[0].trim();

					if(keyAndValue.length == 1) {
						value = "";
					} else if(keyAndValue.length >= 2) {
						value = keyAndValue[1].trim();
					}

					if(key.equalsIgnoreCase("$$$MSGSTART")) {
						
						if(value.startsWith("ES")) {
							eurCrnRcvMsgMasterVO.setCntCd("ES");
						} else {
							eurCrnRcvMsgMasterVO.setCntCd("PT");
						}

					} else if(key.equalsIgnoreCase("INF")) {
						eurCrnRcvMsgMasterVO.setMsgSndOfcCd(value);
					} else if(key.equalsIgnoreCase("POD")) {
						eurCrnRcvMsgMasterVO.setPodCd(value);
					} else if(key.equalsIgnoreCase("SND")) {
						eurCrnRcvMsgMasterVO.setMsgSndDt(value);
					} else if(key.equalsIgnoreCase("REG")) {
						eurCrnRcvMsgMasterVO.setCntrRgstKnt(value);
					} else if(key.equalsIgnoreCase("SENT_STATUS")) {
						eurCrnRcvMsgMasterVO.setMsgFuncId(value);
					} else if(key.equalsIgnoreCase("CUSSUBPLACE")) { // 추가
						eurCrnRcvMsgMasterVO.setPreVslDchgYdNm(value);
					} else if(key.equalsIgnoreCase("MANIFEST_NUMBER")) {
						eurCrnRcvMsgMasterVO.setMfNo(value);
					} else if(key.equalsIgnoreCase("BL_NBR")) {
						if(value.length() > 12) { //Toyota B/L
							eurCrnRcvMsgDetailVO.setBlNo(value.substring(0, 12)); //Toyota B/L
						} 
						else if(value.length() == 11){
							eurCrnRcvMsgDetailVO.setBlNo(value.substring(0, 10)); //Toyota B/L
						}
						else {
							eurCrnRcvMsgDetailVO.setBlNo(value);
						}
					} else if(key.equalsIgnoreCase("GOODS_ITEM_REF")) {
						eurCrnRcvMsgDetailVO.setRefGdsItmNm(value);
					}

				} // end for(i)

				// 수신데이타 저장
				dbDao.addEurCrnAck(eurCrnRcvMsgDetailVOs, eurCrnRcvMsgMasterVO.getMsgFuncId());
				
			}
			
//		} catch (DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		log.info("<<<<<<<<<< loadCstmsRcvMsg end >>>>>>>>>>>>>>>>");
		
	}
	
	
	/**
	 * 2011.11.15 김보배 [CHM-201114279] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
	 * EU 세관 전송을 위한 VVD 와 POD 별 B/L 내역 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchEurManifestList(ManifestListCondVO manifestListCondVO) throws EventException {

		try{
			return dbDao.searchEurManifestList(manifestListCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob을 실행.(Sitpro)
	 * 
	 * @param String usrId
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startLdfDownBackEndJob(String usrId,	ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException{

		EurCustomsTransmissionLdfDownloadBackEndJob backEndJob = new EurCustomsTransmissionLdfDownloadBackEndJob ();
		backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
		backEndJob.setUserId(usrId);
		backEndJob.setPgmNo(pgmNo);
		String divStr = "LDF Download";
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		return backEndJobManager.execute(backEndJob , usrId, divStr);
	}



	/**
	 * 구주 SIT PRO프로그램에서 LDF Download 메서드로 사용함<br>
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String userId
	 * @param String pgmNo
	 * @return List<SitProENSDownExcelVO>
	 * @throws EventException
	 */
	public HashMap<String, Object> searchLDFDownExcel(ManifestTransmitVO[] manifestTransmitVOs, String userId, String pgmNo) throws EventException {
		EurManifestTransmitVO[] eurManifestTransmitVOs = (EurManifestTransmitVO[])manifestTransmitVOs;
		
		SitproEdiVO sitproEdiVO = new SitproEdiVO();
		
		SitProVslInfoVO sitProVslInfoVO = null;
		
		String mrnNo = "";
		
		SitProCommodityVO		 sitProCommodityVO = null;
		SitProBlInfoVO 			 sitProBlInfoVO = null;
		SitProMsnInfoVO 		 sitProMsnInfoVO = null;
		SitProCmDescInfoVO 		 sitProCmDescInfoVO = null;
		
		
		List<SitProEuMrnInfoVO>  sitProEuMrnInfoVOs  =  null;
		SitProEuMrnInfoVO        sitProEuMrnInfoVO  =  null;
		
		List<SitProRateAmountVO> sitProRateAmountVOs = null;
		List<SitProRateAmountTTLVO> sitProRateAmountTTLVOs = null;
		SitProRateAmountVO sitProRateAmountVO = null;
		SitProRateAmountTTLVO sitProRateAmountTTLVO = null;
		
		BrVslCondVO brVslCondVO = new BrVslCondVO();
		BrMndDescInfoVO brMndDescInfoVO = null;
		
		List<SitProCntrRfAkBrCgoInfoVO> sitProCntrRfAkBrCgoInfoVOs = null;
		SitProCntrRfAkBrCgoInfoVO sitProCntrRfAkBrCgoInfoVO = null;
		
		SitProCntrSealListVO sitProCntrSealListVO = null;
		List<SitProCntrSealListVO> sitProCntrSealListVOs = null;
		int sitProCntrSealListVOsSize = 0;
		
		SitProDgInfoVO sitProDgInfoVO = null;
		List<SitProDgInfoVO> sitProDgInfoVOs = null;
		int sitProDgInfoVOsSize = 0;
		
		SitProCmInfoVO sitProCmInfoVO = null;
		List<SitProCmInfoVO> sitProCmInfoVOList = null;
		
		SitProBkgQtyVO sitProBkgQtyVO = null;
		
		List<SitProVslEtcInfoVO> sitProVslEtcInfoVOs = null;
		SitProVslEtcInfoVO sitProVslEtcInfoVO = null;
		
		SitProELNumberInfoVO sitProELNumberInfoVO = null;
		
		HashMap<String, String> mapSitProVslInfo = new HashMap<String, String>();
		HashMap<String, String> mapTemp = null;
		
		List<HashMap<String, String>> listBlRoot = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapBlRoot = new HashMap<String, Object>();

		List<HashMap<String, String>> listBlCntr = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapBlCntr = new HashMap<String, Object>();

		List<HashMap<String, String>> listBlFrt = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapBlFrt = new HashMap<String, Object>();

		List<HashMap<String, String>> listBlRmk = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapBlRmk = new HashMap<String, Object>();

		List<HashMap<String, String>> listCgo = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapCgo = new HashMap<String, Object>();
		
		List<HashMap<String, String>> listCgoPck = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapCgoPck = new HashMap<String, Object>();
		
		List<HashMap<String, String>> listCgoMkNo = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapCgoMkNo = new HashMap<String, Object>();
		
		List<HashMap<String, String>> listBlNtfy = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapBlNtfy = new HashMap<String, Object>();
		
		List<HashMap<String, String>> listBlRout = new ArrayList<HashMap<String, String>>();
		HashMap<String, Object> mapBlRout = new HashMap<String, Object>();
				
		HashMap<String, Object> ldfDownMap = new HashMap<String, Object>();
		
		List<BkgCstmsBlLodFctrLogVO> listLdfLog = new ArrayList<BkgCstmsBlLodFctrLogVO>();

		try {

				if(eurManifestTransmitVOs != null) {

					int bkgNoListMaxSize = eurManifestTransmitVOs.length;
					
					for(int i = 0; i < bkgNoListMaxSize; i++) {
						
						sitproEdiVO.setBkgNo(eurManifestTransmitVOs[i].getBkgNo());
						
						BkgCstmsBlLodFctrLogVO ldfLog = new BkgCstmsBlLodFctrLogVO();
						ldfLog.setBkgNo(eurManifestTransmitVOs[i].getBkgNo());
						if ("BATCH".equals(pgmNo))
						{
							ldfLog.setBatFlg("Y");
						}
						ldfLog.setCreUsrId(userId);
						
						if (eurManifestTransmitVOs[0].getPolCd().startsWith("VN") || eurManifestTransmitVOs[0].getPodCd().startsWith("VN")) {
							listLdfLog.add(ldfLog);
						}
						
						if(i == 0) { 
							
							sitproEdiVO.setVvdCd(eurManifestTransmitVOs[i].getVvdCd());
							sitproEdiVO.setOfcCd(eurManifestTransmitVOs[i].getOfcCd());
							sitproEdiVO.setPolCd(eurManifestTransmitVOs[i].getPolCd());
							sitproEdiVO.setPodCd(eurManifestTransmitVOs[i].getPodCd());
							sitproEdiVO.setBndCd(eurManifestTransmitVOs[i].getBndCd());
							sitproEdiVO.setCompId("");
							
							CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
							
							// VSL/VVD정보 가져오기
							sitProVslInfoVO = dbDao.searchVslEtaEtd(sitproEdiVO);
							
							if ( sitProVslInfoVO != null) {
								log.debug("(((((((((((((((((((((((((((((((((((((((((((((((((");
								mapSitProVslInfo.put("VVD",					sitProVslInfoVO.getVvd());
								
								if(!"".equals(sitproEdiVO.getPolCd()) && !"".equals(sitproEdiVO.getPodCd()) ){
									mapSitProVslInfo.put("IB_CON_VVD",		comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPodCd(), "I"));
									mapSitProVslInfo.put("OB_CON_VVD",		comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPolCd(), "O"));
								}else if("".equals(sitproEdiVO.getPolCd()) && !"".equals(sitproEdiVO.getPodCd()) ){
									mapSitProVslInfo.put("IB_CON_VVD",		comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPodCd(), "I"));
								}else if(!"".equals(sitproEdiVO.getPolCd()) && "".equals(sitproEdiVO.getPodCd()) ){
									mapSitProVslInfo.put("OB_CON_VVD",		comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPolCd(), "O"));
								}
								mapSitProVslInfo.put("VSL_CALLSIGN",		sitProVslInfoVO.getVslCallsign());
								mapSitProVslInfo.put("VSL_LLOYDCODE",		sitProVslInfoVO.getVslLloydcode());
								mapSitProVslInfo.put("VSL_FULLNAME",		sitProVslInfoVO.getVslFullname());
								mapSitProVslInfo.put("VSL_FLAG",			sitProVslInfoVO.getVslRgstCntCd());
								mapSitProVslInfo.put("PORT",				sitProVslInfoVO.getPort());
								mapSitProVslInfo.put("PORTNAME",			sitProVslInfoVO.getPortname());
								mapSitProVslInfo.put("ETA",					sitProVslInfoVO.getEta());
								mapSitProVslInfo.put("ETD",					sitProVslInfoVO.getEtd());
								mapSitProVslInfo.put("ATA",					sitProVslInfoVO.getAta());
								mapSitProVslInfo.put("ATD",					sitProVslInfoVO.getAtd());
								mapSitProVslInfo.put("NEXTPORT",			sitProVslInfoVO.getNextport());
								mapSitProVslInfo.put("NEXTPORT_ETA",		sitProVslInfoVO.getNextportEta());
								mapSitProVslInfo.put("PREVPORT",			sitProVslInfoVO.getPrevport());
								mapSitProVslInfo.put("PREVPORT_ETD",		sitProVslInfoVO.getPrevportEtd());
								mapSitProVslInfo.put("IO_IND",				sitProVslInfoVO.getIoInd());
								mapSitProVslInfo.put("COMP_ID",				sitProVslInfoVO.getCompId());
							} else {
								log.debug(")))))))))))))))))))))))))))))))))))))))))))))))))");
								
								// booking vvd, pol, pod정보로 
								sitproEdiVO.setVvdCd(eurManifestTransmitVOs[i].getTvvdCd());
								sitproEdiVO.setPolCd(eurManifestTransmitVOs[i].getBPolCd());
								sitproEdiVO.setPodCd(eurManifestTransmitVOs[i].getBPodCd());
								sitProVslInfoVO = dbDao.searchBookingVslInfo(sitproEdiVO);
								
								if(sitProVslInfoVO != null) {

									mapSitProVslInfo.put("VVD",					sitProVslInfoVO.getVvd());
									
									if(!"".equals(sitproEdiVO.getPolCd()) && !"".equals(sitproEdiVO.getPodCd()) ){
										mapSitProVslInfo.put("IB_CON_VVD",		comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPodCd(), "I"));
										mapSitProVslInfo.put("OB_CON_VVD",		comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPolCd(), "O"));
									}else if("".equals(sitproEdiVO.getPolCd()) && !"".equals(sitproEdiVO.getPodCd()) ){
										mapSitProVslInfo.put("IB_CON_VVD",		comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPodCd(), "I"));
									}else if(!"".equals(sitproEdiVO.getPolCd()) && "".equals(sitproEdiVO.getPodCd()) ){
										mapSitProVslInfo.put("OB_CON_VVD",		comBc.searchConVvd(sitProVslInfoVO.getVvd(), sitproEdiVO.getPolCd(), "O"));
									}
									
									mapSitProVslInfo.put("VSL_CALLSIGN",		"");
									mapSitProVslInfo.put("VSL_LLOYDCODE",		"");
									mapSitProVslInfo.put("VSL_FULLNAME",		sitProVslInfoVO.getVslFullname());
									mapSitProVslInfo.put("VSL_FLAG",			sitProVslInfoVO.getVslRgstCntCd());
									mapSitProVslInfo.put("PORT",				sitProVslInfoVO.getPort());
									mapSitProVslInfo.put("PORTNAME",			sitProVslInfoVO.getPortname());
									mapSitProVslInfo.put("ETA",					"");
									mapSitProVslInfo.put("ETD",					"");
									mapSitProVslInfo.put("ATA",					"");
									mapSitProVslInfo.put("ATD",					"");
									mapSitProVslInfo.put("NEXTPORT",			"");
									mapSitProVslInfo.put("NEXTPORT_ETA",		"");
									mapSitProVslInfo.put("PREVPORT",			"");
									mapSitProVslInfo.put("PREVPORT_ETD",		"");
									mapSitProVslInfo.put("IO_IND",				"");
									mapSitProVslInfo.put("COMP_ID",				sitProVslInfoVO.getCompId());
								
								} else {
									
									mapSitProVslInfo.put("VVD",					"");
									mapSitProVslInfo.put("VSL_CALLSIGN",		"");
									mapSitProVslInfo.put("VSL_LLOYDCODE",		"");
									mapSitProVslInfo.put("VSL_FULLNAME",		"");
									mapSitProVslInfo.put("VSL_FLAG",			"");
									mapSitProVslInfo.put("PORT",				"");
									mapSitProVslInfo.put("PORTNAME",			"");
									mapSitProVslInfo.put("ETA",					"");
									mapSitProVslInfo.put("ETD",					"");
									mapSitProVslInfo.put("ATA",					"");
									mapSitProVslInfo.put("ATD",					"");
									mapSitProVslInfo.put("NEXTPORT",			"");
									mapSitProVslInfo.put("NEXTPORT_ETA",		"");
									mapSitProVslInfo.put("PREVPORT",			"");
									mapSitProVslInfo.put("PREVPORT_ETD",		"");
									mapSitProVslInfo.put("IO_IND",				"");
									mapSitProVslInfo.put("COMP_ID",				"");
								}
							}
							
							// mrn 정보 조회
							mrnNo = dbDao.searchMrnByVvdPort(sitproEdiVO);
							sitproEdiVO.setMrnNo(mrnNo);
							mapSitProVslInfo.put("MRN",			mrnNo);
				
						}
							
						// commodity desc정보를 조회한다.
						sitProCommodityVO = dbDao.searchCommodityDescByBkgNo(sitproEdiVO);

						sitproEdiVO.setCmdtNm(sitProCommodityVO.getCmdtNm());
						sitproEdiVO.setRepCmdtNm(sitProCommodityVO.getRepCmdtNm());
						// BL 일반 정보 및 location 정보를 조회한다.
						sitProBlInfoVO = dbDao.searchBlCustomerInfo(sitproEdiVO);
						
						// msn정보를 조회한다.
						//sitproEdiVO.setBkgNo("CHI400004400");  //==> test 삭제
						//sitproEdiVO.setMrnNo("14OPUS1001");  //==> test 삭제
						sitProMsnInfoVO = dbDao.searchMsnByBkg(sitproEdiVO);
						
						// CM Desc 정보를 조회한다.
						//sitproEdiVO.setBkgNo("SIN400057200");  //==> test 삭제
						sitProCmDescInfoVO = dbDao.searchBlCmDesc(sitproEdiVO);

						// EU MRN 정보를 조회한다. {EU_MRN
						//sitproEdiVO.setBkgNo("NYC400056100");  //==> test 삭제
						sitProEuMrnInfoVOs = dbDao.searchEuMrnByBkg(sitproEdiVO);

						// Rate 정보를 조회한다. {CHARGE
						//sitproEdiVO.setBkgNo("SIN400002600");  //==> test 삭제
						sitProRateAmountVOs = dbDao.searchRateAmount(sitproEdiVO);

						// Rate TOTAL 정보를 조회한다. {CHARGE_TTL
						sitProRateAmountTTLVOs = dbDao.searchRateAmountTTL(sitproEdiVO);
						
						// BKG의 Mark/Desc 정보를 조회한다.  {DESC  {MARK
						brVslCondVO.setBkgNo(sitproEdiVO.getBkgNo());
						brMndDescInfoVO = dbDao.searchMarkDescInfo(brVslCondVO);

						// Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.
						sitproEdiVO.setBkgCgoTp(sitProBlInfoVO.getInBkgCgoTpCd());
						sitproEdiVO.setBkgSpeRf(sitProBlInfoVO.getInRcFlg());
						sitproEdiVO.setBkgSpeDg(sitProBlInfoVO.getInDcgoFlg());
						sitproEdiVO.setBkgSpeAk(sitProBlInfoVO.getInAwkCgoFlg());
						sitproEdiVO.setBkgSpeBb(sitProBlInfoVO.getInBbCgoFlg());
						sitproEdiVO.setBkgSpeRd(sitProBlInfoVO.getInRdCgoFlg());
						sitproEdiVO.setCmdtDesc(sitProBlInfoVO.getInCmdtDesc());
						sitproEdiVO.setCmdtCd(sitProBlInfoVO.getInCmdtCd());

						// {CNTR_INFO
						sitProCntrRfAkBrCgoInfoVOs= dbDao.searchCntrRfAkCgo(sitproEdiVO);	
							
						// qty 정보를 조회한다. {QTY
						sitProBkgQtyVO = dbDao.searchBkgQty(sitproEdiVO);

						//  Vessel 정보, Vessel ETA 정보를 조회한다.   {BKGVVD\
						sitProVslEtcInfoVOs = dbDao.searchVslEtcInfoVsl(sitproEdiVO);
													
						// EL Number를 조회한다..  {ELNO
						sitproEdiVO.setBltp(sitProMsnInfoVO.getBltp());
						sitproEdiVO.setBlts(sitProMsnInfoVO.getBlts());
						sitproEdiVO.setMsncfm(sitProMsnInfoVO.getMsncfm());
						sitProELNumberInfoVO = dbDao.searchELNumberByBkg(sitproEdiVO);

						
						
						//##################### B/L Root
						int sitProEuMrnInfoVOsMaxSize = sitProEuMrnInfoVOs.size();
						
						if (sitProEuMrnInfoVOsMaxSize > 0){
							
							for(int idx = 0; idx < sitProEuMrnInfoVOsMaxSize; idx++) {
								sitProEuMrnInfoVO = sitProEuMrnInfoVOs.get(idx);
								
								mapTemp = new HashMap<String, String>();
								
								mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));

								if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
									mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
									mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
								} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
									mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
								} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
									mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								}
								
								mapTemp.put("VSL_CALLSIGN",  mapSitProVslInfo.get("VSL_CALLSIGN"));
								mapTemp.put("VSL_LLOYDCODE", mapSitProVslInfo.get("VSL_LLOYDCODE"));
								mapTemp.put("VSL_FULLNAME",	 mapSitProVslInfo.get("VSL_FULLNAME"));
								mapTemp.put("VSL_FLAG",		 mapSitProVslInfo.get("VSL_FLAG"));
								mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
								mapTemp.put("PORTNAME",		 mapSitProVslInfo.get("PORTNAME"));
								mapTemp.put("ETA",			 mapSitProVslInfo.get("ETA"));
								mapTemp.put("ETD",			 mapSitProVslInfo.get("ETD"));
								mapTemp.put("ATA",			 mapSitProVslInfo.get("ATA"));
								mapTemp.put("ATD",			 mapSitProVslInfo.get("ATD"));
								mapTemp.put("NEXTPORT",		 mapSitProVslInfo.get("NEXTPORT"));
								mapTemp.put("NEXTPORT_ETA",	 mapSitProVslInfo.get("NEXTPORT_ETA"));
								mapTemp.put("PREVPORT",		 mapSitProVslInfo.get("PREVPORT"));
								mapTemp.put("PREVPORT_ETD",	 mapSitProVslInfo.get("PREVPORT_ETD"));
								mapTemp.put("IO_IND",		 mapSitProVslInfo.get("IO_IND"));
								mapTemp.put("COMP_ID",		 mapSitProVslInfo.get("COMP_ID"));
								mapTemp.put("MRN",		     mapSitProVslInfo.get("MRN"));
								
								mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
								mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
								mapTemp.put("POL_AMS",       sitProBlInfoVO.getPolAms());
								mapTemp.put("POL_FULLNAME",  sitProBlInfoVO.getPolFullname());
								mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
								mapTemp.put("POD_AMS",       sitProBlInfoVO.getPodAms());
								mapTemp.put("POD_FULLNAME",  sitProBlInfoVO.getPodFullname());
								mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
								mapTemp.put("POR_AMS",       sitProBlInfoVO.getPorAms());
								mapTemp.put("POR_FULLNAME",  sitProBlInfoVO.getPorFullname());
								mapTemp.put("POR_YARD",      sitProBlInfoVO.getPorYard());
								mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
								mapTemp.put("DEL_AMS",       sitProBlInfoVO.getDelAms());
								mapTemp.put("DEL_FULLNAME",  sitProBlInfoVO.getDelFullname());
								mapTemp.put("DEL_YARD",      sitProBlInfoVO.getDelYard());
								mapTemp.put("SVC_SCP",       sitProBlInfoVO.getSvcScp());
								mapTemp.put("BL_CMPL_STS",   sitProBlInfoVO.getBlCmplSts());
								mapTemp.put("BL_CMPL_TP",    sitProBlInfoVO.getBlCmplTp());
								mapTemp.put("BLRLY",         sitProBlInfoVO.getBlrly());
								mapTemp.put("RLY_AMS",       sitProBlInfoVO.getRlyAms());
								mapTemp.put("RLY_FULLNAME",  sitProBlInfoVO.getRlyFullname());
								mapTemp.put("BLPLACE",       sitProBlInfoVO.getBlplace());
								mapTemp.put("BLDATE",        sitProBlInfoVO.getBldate());
								mapTemp.put("BLCOPY",        sitProBlInfoVO.getBlcopy());
								mapTemp.put("BLORG",         sitProBlInfoVO.getBlorg());
								mapTemp.put("BLPKG",         sitProBlInfoVO.getBlpkg());
								mapTemp.put("BLPKGU",        sitProBlInfoVO.getBlpkgu());
								mapTemp.put("BLWGT",         sitProBlInfoVO.getBlwgt());
								mapTemp.put("BL_WGT_UNIT",   sitProBlInfoVO.getBlWgtUnit());
								mapTemp.put("BLMEA",         sitProBlInfoVO.getBlmea());
								mapTemp.put("BL_MEA_UNIT",   sitProBlInfoVO.getBlMeaUnit());
								mapTemp.put("RDTYPE",        sitProBlInfoVO.getRdtype());
								mapTemp.put("CARGOTYPE",     sitProBlInfoVO.getCargotype());
								mapTemp.put("COMMODITY",     sitProBlInfoVO.getCommodity());
								mapTemp.put("BLCMD",         sitProBlInfoVO.getBlcmd());
								mapTemp.put("BLREPCMDCD",    sitProBlInfoVO.getBlrepcmdcd());
								mapTemp.put("BLREPCMD",      sitProBlInfoVO.getBlrepcmd());
								mapTemp.put("REMARK",        sitProBlInfoVO.getRemark());
								mapTemp.put("AUS_QUAR",      sitProBlInfoVO.getAusQuar());
								mapTemp.put("SRNBR",         sitProBlInfoVO.getSrnbr());
								mapTemp.put("BKGNBR",        sitProBlInfoVO.getBkgnbr());
								mapTemp.put("RGN_BKGNBR",    sitProBlInfoVO.getRgnBkgnbr());
								mapTemp.put("CVRD_BY",       sitProBlInfoVO.getCvrdBy());
								mapTemp.put("SCNO",          sitProBlInfoVO.getScno());
								mapTemp.put("RFANO",         sitProBlInfoVO.getRfano());

								mapTemp.put("TW_SO_NO",      sitProBlInfoVO.getTwnSoNo());
								
								mapTemp.put("WAYBILL_IND",   sitProBlInfoVO.getWaybillInd());
								mapTemp.put("CUSTREF_NUM",   sitProBlInfoVO.getCustrefNum());
								mapTemp.put("FINAL_ETA",     sitProBlInfoVO.getFinalEta());
								mapTemp.put("FUNC_CODE",     sitProBlInfoVO.getFuncCode());
								mapTemp.put("ONBOARD",       sitProBlInfoVO.getOnboard());
								mapTemp.put("INV_NO",        sitProBlInfoVO.getInvNo());
								
								mapTemp.put("BLTS",             (sitProMsnInfoVO.getBlts() != null) ? sitProMsnInfoVO.getBlts() : ""  );
								mapTemp.put("BLTP",             (sitProMsnInfoVO.getBltp() != null) ? sitProMsnInfoVO.getBltp() : ""  );
								mapTemp.put("MSN",              (sitProMsnInfoVO.getMsnNbr() != null) ? sitProMsnInfoVO.getMsnNbr() : "" );
								mapTemp.put("MSNCFM",           (sitProMsnInfoVO.getMsncfm() != null) ? sitProMsnInfoVO.getMsncfm() : "" );

								mapTemp.put("IND_AGREE",       sitProBlInfoVO.getIndAgree());
								mapTemp.put("VALUE_AGREE",     sitProBlInfoVO.getValueAgree());	
								
								mapTemp.put("EU_MRN_SEQ",     (sitProEuMrnInfoVO.getEuMrnNo() != null) ? sitProEuMrnInfoVO.getEuMrnNo() : "");
								mapTemp.put("EU_MRN_VALUE",   (sitProEuMrnInfoVO.getEuMrnValue() != null) ? sitProEuMrnInfoVO.getEuMrnValue() : "");
								mapTemp.put("EU_PORT",        (sitProEuMrnInfoVO.getEuPort() != null) ? sitProEuMrnInfoVO.getEuPort() : "");									
								mapTemp.put("EU_MRN_DATE",    (sitProEuMrnInfoVO.getEuMrnDate() != null) ? sitProEuMrnInfoVO.getEuMrnDate() : "");
								mapTemp.put("EU_MRN_SOURCE",  (sitProEuMrnInfoVO.getEuMrnSource() != null) ? sitProEuMrnInfoVO.getEuMrnSource() : "");
								
								mapTemp.put("HANTYPE",     	sitProBkgQtyVO.getHantype());
								mapTemp.put("COUNT",       	sitProBkgQtyVO.getCount());
								
								if(sitProELNumberInfoVO != null) {
									mapTemp.put("ELNO",     	(sitProELNumberInfoVO.getElno() != null) ? sitProELNumberInfoVO.getElno() : "");
									mapTemp.put("ELPK",     	(sitProELNumberInfoVO.getElpk() != null) ? sitProELNumberInfoVO.getElpk() : "");
									mapTemp.put("ELPKU",     	(sitProELNumberInfoVO.getElpku() != null) ? sitProELNumberInfoVO.getElpku() : "");
									mapTemp.put("ELWT",     	(sitProELNumberInfoVO.getElwt() != null) ? sitProELNumberInfoVO.getElwt() : "");
									mapTemp.put("ELWTU",     	(sitProELNumberInfoVO.getElwtu() != null) ? sitProELNumberInfoVO.getElwtu() : "");
								}

								mapTemp.put("FND_DEST",       	sitProBlInfoVO.getFndDest());
								
								listBlRoot.add(mapTemp);
							} // end for(idx)
						}else{
							mapTemp = new HashMap<String, String>();
							
							mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
							
							if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							}
							
							mapTemp.put("VSL_CALLSIGN",  mapSitProVslInfo.get("VSL_CALLSIGN"));
							mapTemp.put("VSL_LLOYDCODE", mapSitProVslInfo.get("VSL_LLOYDCODE"));
							mapTemp.put("VSL_FULLNAME",	 mapSitProVslInfo.get("VSL_FULLNAME"));
							mapTemp.put("VSL_FLAG",		 mapSitProVslInfo.get("VSL_FLAG"));
							mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
							mapTemp.put("PORTNAME",		 mapSitProVslInfo.get("PORTNAME"));
							mapTemp.put("ETA",			 mapSitProVslInfo.get("ETA"));
							mapTemp.put("ETD",			 mapSitProVslInfo.get("ETD"));
							mapTemp.put("ATA",			 mapSitProVslInfo.get("ATA"));
							mapTemp.put("ATD",			 mapSitProVslInfo.get("ATD"));
							mapTemp.put("NEXTPORT",		 mapSitProVslInfo.get("NEXTPORT"));
							mapTemp.put("NEXTPORT_ETA",	 mapSitProVslInfo.get("NEXTPORT_ETA"));
							mapTemp.put("PREVPORT",		 mapSitProVslInfo.get("PREVPORT"));
							mapTemp.put("PREVPORT_ETD",	 mapSitProVslInfo.get("PREVPORT_ETD"));
							mapTemp.put("IO_IND",		 mapSitProVslInfo.get("IO_IND"));
							mapTemp.put("COMP_ID",		 mapSitProVslInfo.get("COMP_ID"));
							mapTemp.put("MRN",		     mapSitProVslInfo.get("MRN"));
							
							mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
							mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
							mapTemp.put("POL_AMS",       sitProBlInfoVO.getPolAms());
							mapTemp.put("POL_FULLNAME",  sitProBlInfoVO.getPolFullname());
							mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
							mapTemp.put("POD_AMS",       sitProBlInfoVO.getPodAms());
							mapTemp.put("POD_FULLNAME",  sitProBlInfoVO.getPodFullname());
							mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
							mapTemp.put("POR_AMS",       sitProBlInfoVO.getPorAms());
							mapTemp.put("POR_FULLNAME",  sitProBlInfoVO.getPorFullname());
							mapTemp.put("POR_YARD",      sitProBlInfoVO.getPorYard());
							mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
							mapTemp.put("DEL_AMS",       sitProBlInfoVO.getDelAms());
							mapTemp.put("DEL_FULLNAME",  sitProBlInfoVO.getDelFullname());
							mapTemp.put("DEL_YARD",      sitProBlInfoVO.getDelYard());
							mapTemp.put("SVC_SCP",       sitProBlInfoVO.getSvcScp());
							mapTemp.put("BL_CMPL_STS",   sitProBlInfoVO.getBlCmplSts());
							mapTemp.put("BL_CMPL_TP",    sitProBlInfoVO.getBlCmplTp());
							mapTemp.put("BLRLY",         sitProBlInfoVO.getBlrly());
							mapTemp.put("RLY_AMS",       sitProBlInfoVO.getRlyAms());
							mapTemp.put("RLY_FULLNAME",  sitProBlInfoVO.getRlyFullname());
							mapTemp.put("BLPLACE",       sitProBlInfoVO.getBlplace());
							mapTemp.put("BLDATE",        sitProBlInfoVO.getBldate());
							mapTemp.put("BLCOPY",        sitProBlInfoVO.getBlcopy());
							mapTemp.put("BLORG",         sitProBlInfoVO.getBlorg());
							mapTemp.put("BLPKG",         sitProBlInfoVO.getBlpkg());
							mapTemp.put("BLPKGU",        sitProBlInfoVO.getBlpkgu());
							mapTemp.put("BLWGT",         sitProBlInfoVO.getBlwgt());
							mapTemp.put("BL_WGT_UNIT",   sitProBlInfoVO.getBlWgtUnit());
							mapTemp.put("BLMEA",         sitProBlInfoVO.getBlmea());
							mapTemp.put("BL_MEA_UNIT",   sitProBlInfoVO.getBlMeaUnit());
							mapTemp.put("RDTYPE",        sitProBlInfoVO.getRdtype());
							mapTemp.put("CARGOTYPE",     sitProBlInfoVO.getCargotype());
							mapTemp.put("COMMODITY",     sitProBlInfoVO.getCommodity());
							mapTemp.put("BLCMD",         sitProBlInfoVO.getBlcmd());
							mapTemp.put("BLREPCMDCD",    sitProBlInfoVO.getBlrepcmdcd());
							mapTemp.put("BLREPCMD",      sitProBlInfoVO.getBlrepcmd());
							mapTemp.put("REMARK",        sitProBlInfoVO.getRemark());
							mapTemp.put("AUS_QUAR",      sitProBlInfoVO.getAusQuar());
							mapTemp.put("SRNBR",         sitProBlInfoVO.getSrnbr());
							mapTemp.put("BKGNBR",        sitProBlInfoVO.getBkgnbr());
							mapTemp.put("RGN_BKGNBR",    sitProBlInfoVO.getRgnBkgnbr());
							mapTemp.put("CVRD_BY",       sitProBlInfoVO.getCvrdBy());
							mapTemp.put("SCNO",          sitProBlInfoVO.getScno());
							mapTemp.put("RFANO",         sitProBlInfoVO.getRfano());
							mapTemp.put("TW_SO_NO",      sitProBlInfoVO.getTwnSoNo());
							mapTemp.put("WAYBILL_IND",   sitProBlInfoVO.getWaybillInd());
							mapTemp.put("CUSTREF_NUM",   sitProBlInfoVO.getCustrefNum());
							mapTemp.put("FINAL_ETA",     sitProBlInfoVO.getFinalEta());
							mapTemp.put("FUNC_CODE",     sitProBlInfoVO.getFuncCode());
							mapTemp.put("ONBOARD",       sitProBlInfoVO.getOnboard());
							mapTemp.put("INV_NO",        sitProBlInfoVO.getInvNo());
							
							mapTemp.put("BLTS",             (sitProMsnInfoVO.getBlts() != null) ? sitProMsnInfoVO.getBlts() : ""  );
							mapTemp.put("BLTP",             (sitProMsnInfoVO.getBltp() != null) ? sitProMsnInfoVO.getBltp() : ""  );
							mapTemp.put("MSN",              (sitProMsnInfoVO.getMsnNbr() != null) ? sitProMsnInfoVO.getMsnNbr() : "" );
							mapTemp.put("MSNCFM",           (sitProMsnInfoVO.getMsncfm() != null) ? sitProMsnInfoVO.getMsncfm() : "" );

							mapTemp.put("IND_AGREE",       sitProBlInfoVO.getIndAgree());
							mapTemp.put("VALUE_AGREE",     sitProBlInfoVO.getValueAgree());	
							
							mapTemp.put("EU_MRN_SEQ",     "");
							mapTemp.put("EU_MRN_VALUE",   "");
							mapTemp.put("EU_PORT",        "");									
							mapTemp.put("EU_MRN_DATE",    "");
							mapTemp.put("EU_MRN_SOURCE",  "");
							
							mapTemp.put("HANTYPE",     	sitProBkgQtyVO.getHantype());
							mapTemp.put("COUNT",       	sitProBkgQtyVO.getCount());
							
							if(sitProELNumberInfoVO != null) {
								mapTemp.put("ELNO",     	(sitProELNumberInfoVO.getElno() != null) ? sitProELNumberInfoVO.getElno() : "");
								mapTemp.put("ELPK",     	(sitProELNumberInfoVO.getElpk() != null) ? sitProELNumberInfoVO.getElpk() : "");
								mapTemp.put("ELPKU",     	(sitProELNumberInfoVO.getElpku() != null) ? sitProELNumberInfoVO.getElpku() : "");
								mapTemp.put("ELWT",     	(sitProELNumberInfoVO.getElwt() != null) ? sitProELNumberInfoVO.getElwt() : "");
								mapTemp.put("ELWTU",     	(sitProELNumberInfoVO.getElwtu() != null) ? sitProELNumberInfoVO.getElwtu() : "");
							}
							
							mapTemp.put("FND_DEST",       	sitProBlInfoVO.getFndDest());
							
							listBlRoot.add(mapTemp);
						}
						
						
						//##################### B/L Container						
						if(sitProCntrRfAkBrCgoInfoVOs.size() > 0) {
							
							for(int cntrIdx=0; cntrIdx < sitProCntrRfAkBrCgoInfoVOs.size(); cntrIdx++) {
								sitProCntrRfAkBrCgoInfoVO = sitProCntrRfAkBrCgoInfoVOs.get(cntrIdx);
								
								sitproEdiVO.setCntrNo(sitProCntrRfAkBrCgoInfoVO.getCntrNo());

								// Multi Seal No. 보여주도록 로직 추가 ( 기존 Seal No. 단건에 대한 항목은 유지 )  {CNTR_SEALS
								sitProCntrSealListVOs = dbDao.searchCntrSealNo(sitproEdiVO);

								sitProCntrSealListVOsSize = sitProCntrSealListVOs.size();
								if(sitProCntrSealListVOsSize >0) {
									for(int sealNoIdx = 0; sealNoIdx < sitProCntrSealListVOsSize; sealNoIdx++) {

										sitProCntrSealListVO = sitProCntrSealListVOs.get(sealNoIdx);
										mapTemp = new HashMap<String, String>();
										
										mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
										if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
											mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
											mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
										} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
											mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
										} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
											mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
										}
										mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
										
										mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
										
										mapTemp.put("CNTRNBR",       		  sitProCntrRfAkBrCgoInfoVO.getCntrnbr());
										mapTemp.put("PUNIT",         		  sitProCntrRfAkBrCgoInfoVO.getPunit());
										mapTemp.put("PKG",                    sitProCntrRfAkBrCgoInfoVO.getPkg());
										mapTemp.put("CNTRWGT",                sitProCntrRfAkBrCgoInfoVO.getCntrwgt());
										mapTemp.put("CNTRGWGT",               sitProCntrRfAkBrCgoInfoVO.getCntrgwgt());
										mapTemp.put("CNTR_WGT_UNIT",          sitProCntrRfAkBrCgoInfoVO.getCntrWgtUnit());
										mapTemp.put("CNTRTRW",                sitProCntrRfAkBrCgoInfoVO.getCntrtrw());
										mapTemp.put("CNTRTYPE",               sitProCntrRfAkBrCgoInfoVO.getCntrtype());
										mapTemp.put("SEALNBR",                sitProCntrRfAkBrCgoInfoVO.getSealnbr());
										mapTemp.put("FM_IND",                 sitProCntrRfAkBrCgoInfoVO.getFmInd());
										mapTemp.put("RF_IND",                 sitProCntrRfAkBrCgoInfoVO.getRfInd());
										mapTemp.put("DG_IND",                 sitProCntrRfAkBrCgoInfoVO.getDgInd());
										mapTemp.put("AK_IND",                 sitProCntrRfAkBrCgoInfoVO.getAkInd());
										mapTemp.put("BK_IND",                 sitProCntrRfAkBrCgoInfoVO.getBkInd());
										mapTemp.put("PL_IND",                 sitProCntrRfAkBrCgoInfoVO.getPlInd());
										mapTemp.put("TEMP",                   sitProCntrRfAkBrCgoInfoVO.getTemp());
										mapTemp.put("TUNIT",                  sitProCntrRfAkBrCgoInfoVO.getTunit());
										mapTemp.put("VENT",                   sitProCntrRfAkBrCgoInfoVO.getVent());
										mapTemp.put("MEASURE",                sitProCntrRfAkBrCgoInfoVO.getMeasure());
										mapTemp.put("MEASURE_UNIT",           sitProCntrRfAkBrCgoInfoVO.getMeasureUnit());
										mapTemp.put("RDTYPE",                 sitProCntrRfAkBrCgoInfoVO.getRdtype());
										mapTemp.put("CMDT_DESC",              sitProCntrRfAkBrCgoInfoVO.getCmdtDesc());
										mapTemp.put("CMDTCD",                 sitProCntrRfAkBrCgoInfoVO.getCmdtCd());
										mapTemp.put("RF_REMARK",              sitProCntrRfAkBrCgoInfoVO.getRfRemark());
										mapTemp.put("RFDRY_IND",              sitProCntrRfAkBrCgoInfoVO.getRfdryInd());
										mapTemp.put("OVF",                    sitProCntrRfAkBrCgoInfoVO.getOvf());
										mapTemp.put("OVR",                    sitProCntrRfAkBrCgoInfoVO.getOvr());
										mapTemp.put("OVH",                    sitProCntrRfAkBrCgoInfoVO.getOvh());
										mapTemp.put("OVLW",                   sitProCntrRfAkBrCgoInfoVO.getOvlw());
										mapTemp.put("OVRW",                   sitProCntrRfAkBrCgoInfoVO.getOvrw());
										mapTemp.put("OVWGT",                  sitProCntrRfAkBrCgoInfoVO.getOvwgt());
										mapTemp.put("OVWGT_UNIT",             sitProCntrRfAkBrCgoInfoVO.getOvwgtUnit());
										mapTemp.put("VOID_SLOT",              sitProCntrRfAkBrCgoInfoVO.getVoidSlot());
										mapTemp.put("STWG_REQ",               sitProCntrRfAkBrCgoInfoVO.getStwgReq());
										mapTemp.put("SOCIND",                 sitProCntrRfAkBrCgoInfoVO.getSocind());
										mapTemp.put("HAULAGE",                sitProCntrRfAkBrCgoInfoVO.getHaulage());
										mapTemp.put("BKWGT",                  sitProCntrRfAkBrCgoInfoVO.getBkwgt());
										mapTemp.put("BKWGTU",                 sitProCntrRfAkBrCgoInfoVO.getBkwgtu());
										mapTemp.put("BKW",                    sitProCntrRfAkBrCgoInfoVO.getBkw());
										mapTemp.put("BKH",                    sitProCntrRfAkBrCgoInfoVO.getBkh());
										mapTemp.put("BKL",                    sitProCntrRfAkBrCgoInfoVO.getBkl());
										mapTemp.put("CNTROWN",                sitProCntrRfAkBrCgoInfoVO.getCntrown());
										mapTemp.put("CNTRTRM",                sitProCntrRfAkBrCgoInfoVO.getCntrtrm());
										mapTemp.put("NOD_DEMURRAGE_FREETIME", sitProCntrRfAkBrCgoInfoVO.getNodDemFt());

										mapTemp.put("SEALSEQ",                sitProCntrSealListVO.getSealSeq());
										mapTemp.put("SEALNBR_CNTR",           sitProCntrSealListVO.getSealNbr()); //CNTR_INFO의 SEALNBR 와 같아서 SEALNBR_CNTR로 수정
										mapTemp.put("PRN_FLG",      		  sitProCntrSealListVO.getPrnFlg()); 
											
										listBlCntr.add(mapTemp);
									}//end for sitProCntrSealListVOs
								} else {
									
									mapTemp = new HashMap<String, String>();
									mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
									if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
										mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
										mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
									} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
										mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
									} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
										mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
									}
									mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
									
									mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
									
									mapTemp.put("CNTRNBR",       		  sitProCntrRfAkBrCgoInfoVO.getCntrnbr());
									mapTemp.put("PUNIT",         		  sitProCntrRfAkBrCgoInfoVO.getPunit());
									mapTemp.put("PKG",                    sitProCntrRfAkBrCgoInfoVO.getPkg());
									mapTemp.put("CNTRWGT",                sitProCntrRfAkBrCgoInfoVO.getCntrwgt());
									mapTemp.put("CNTRGWGT",               sitProCntrRfAkBrCgoInfoVO.getCntrgwgt());
									mapTemp.put("CNTR_WGT_UNIT",          sitProCntrRfAkBrCgoInfoVO.getCntrWgtUnit());
									mapTemp.put("CNTRTRW",                sitProCntrRfAkBrCgoInfoVO.getCntrtrw());
									mapTemp.put("CNTRTYPE",               sitProCntrRfAkBrCgoInfoVO.getCntrtype());
									mapTemp.put("SEALNBR",                sitProCntrRfAkBrCgoInfoVO.getSealnbr());
									mapTemp.put("FM_IND",                 sitProCntrRfAkBrCgoInfoVO.getFmInd());
									mapTemp.put("RF_IND",                 sitProCntrRfAkBrCgoInfoVO.getRfInd());
									mapTemp.put("DG_IND",                 sitProCntrRfAkBrCgoInfoVO.getDgInd());
									mapTemp.put("AK_IND",                 sitProCntrRfAkBrCgoInfoVO.getAkInd());
									mapTemp.put("BK_IND",                 sitProCntrRfAkBrCgoInfoVO.getBkInd());
									mapTemp.put("PL_IND",                 sitProCntrRfAkBrCgoInfoVO.getPlInd());
									mapTemp.put("TEMP",                   sitProCntrRfAkBrCgoInfoVO.getTemp());
									mapTemp.put("TUNIT",                  sitProCntrRfAkBrCgoInfoVO.getTunit());
									mapTemp.put("VENT",                   sitProCntrRfAkBrCgoInfoVO.getVent());
									mapTemp.put("MEASURE",                sitProCntrRfAkBrCgoInfoVO.getMeasure());
									mapTemp.put("MEASURE_UNIT",           sitProCntrRfAkBrCgoInfoVO.getMeasureUnit());
									mapTemp.put("RDTYPE",                 sitProCntrRfAkBrCgoInfoVO.getRdtype());
									mapTemp.put("CMDT_DESC",              sitProCntrRfAkBrCgoInfoVO.getCmdtDesc());
									mapTemp.put("CMDTCD",                 sitProCntrRfAkBrCgoInfoVO.getCmdtCd());
									mapTemp.put("RF_REMARK",              sitProCntrRfAkBrCgoInfoVO.getRfRemark());
									mapTemp.put("RFDRY_IND",              sitProCntrRfAkBrCgoInfoVO.getRfdryInd());
									mapTemp.put("OVF",                    sitProCntrRfAkBrCgoInfoVO.getOvf());
									mapTemp.put("OVR",                    sitProCntrRfAkBrCgoInfoVO.getOvr());
									mapTemp.put("OVH",                    sitProCntrRfAkBrCgoInfoVO.getOvh());
									mapTemp.put("OVLW",                   sitProCntrRfAkBrCgoInfoVO.getOvlw());
									mapTemp.put("OVRW",                   sitProCntrRfAkBrCgoInfoVO.getOvrw());
									mapTemp.put("OVWGT",                  sitProCntrRfAkBrCgoInfoVO.getOvwgt());
									mapTemp.put("OVWGT_UNIT",             sitProCntrRfAkBrCgoInfoVO.getOvwgtUnit());
									mapTemp.put("VOID_SLOT",              sitProCntrRfAkBrCgoInfoVO.getVoidSlot());
									mapTemp.put("STWG_REQ",               sitProCntrRfAkBrCgoInfoVO.getStwgReq());
									mapTemp.put("SOCIND",                 sitProCntrRfAkBrCgoInfoVO.getSocind());
									mapTemp.put("HAULAGE",                sitProCntrRfAkBrCgoInfoVO.getHaulage());
									mapTemp.put("BKWGT",                  sitProCntrRfAkBrCgoInfoVO.getBkwgt());
									mapTemp.put("BKWGTU",                 sitProCntrRfAkBrCgoInfoVO.getBkwgtu());
									mapTemp.put("BKW",                    sitProCntrRfAkBrCgoInfoVO.getBkw());
									mapTemp.put("BKH",                    sitProCntrRfAkBrCgoInfoVO.getBkh());
									mapTemp.put("BKL",                    sitProCntrRfAkBrCgoInfoVO.getBkl());
									mapTemp.put("CNTROWN",                sitProCntrRfAkBrCgoInfoVO.getCntrown());
									mapTemp.put("CNTRTRM",                sitProCntrRfAkBrCgoInfoVO.getCntrtrm());
									mapTemp.put("NOD_DEMURRAGE_FREETIME", sitProCntrRfAkBrCgoInfoVO.getNodDemFt());
									
									mapTemp.put("SEALSEQ",       "");
									mapTemp.put("SEALNBR_CNTR",       "");
									mapTemp.put("SEAL_PRINT_FLAG",        ""); 
									listBlCntr.add(mapTemp);
								}
							}
						}else{
							//추가
							mapTemp = new HashMap<String, String>();
							mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
							if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							}
							mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
							
							mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
							
							mapTemp.put("CNTRNBR",       		  "");
							mapTemp.put("PUNIT",         		  "");
							mapTemp.put("PKG",                    "");
							mapTemp.put("CNTRWGT",                "");
							mapTemp.put("CNTRGWGT",               "");
							mapTemp.put("CNTR_WGT_UNIT",          "");
							mapTemp.put("CNTRTRW",                "");
							mapTemp.put("CNTRTYPE",               "");
							mapTemp.put("SEALNBR",                "");
							mapTemp.put("FM_IND",                 "");
							mapTemp.put("RF_IND",                 "");
							mapTemp.put("DG_IND",                 "");
							mapTemp.put("AK_IND",                 "");
							mapTemp.put("BK_IND",                 "");
							mapTemp.put("PL_IND",                 "");
							mapTemp.put("TEMP",                   "");
							mapTemp.put("TUNIT",                  "");
							mapTemp.put("VENT",                   "");
							mapTemp.put("MEASURE",                "");
							mapTemp.put("MEASURE_UNIT",           "");
							mapTemp.put("RDTYPE",                 "");
							mapTemp.put("CMDT_DESC",              "");
							mapTemp.put("CMDTCD",                 "");
							mapTemp.put("RF_REMARK",              "");
							mapTemp.put("RFDRY_IND",              "");
							mapTemp.put("OVF",                    "");
							mapTemp.put("OVR",                    "");
							mapTemp.put("OVH",                    "");
							mapTemp.put("OVLW",                   "");
							mapTemp.put("OVRW",                   "");
							mapTemp.put("OVWGT",                  "");
							mapTemp.put("OVWGT_UNIT",             "");
							mapTemp.put("VOID_SLOT",              "");
							mapTemp.put("STWG_REQ",               "");
							mapTemp.put("SOCIND",                 "");
							mapTemp.put("HAULAGE",                "");
							mapTemp.put("BKWGT",                  "");
							mapTemp.put("BKWGTU",                 "");
							mapTemp.put("BKW",                    "");
							mapTemp.put("BKH",                    "");
							mapTemp.put("BKL",                    "");
							mapTemp.put("CNTROWN",                "");
							mapTemp.put("CNTRTRM",                "");
							mapTemp.put("NOD_DEMURRAGE_FREETIME", "");

							mapTemp.put("SEALSEQ",       "");
							mapTemp.put("SEALNBR_CNTR",       "");
							listBlCntr.add(mapTemp);
						}
						

						//##################### B/L Freight
						String ppdUsd = dbDao.searchPpdUsd(sitproEdiVO);
						String cctUsd = dbDao.searchCctUsd(sitproEdiVO);
						
						int sitProRateAmountVOsMaxSize = sitProRateAmountVOs.size();
						if(sitProRateAmountVOsMaxSize > 0) {
							for(int idx = 0; idx < sitProRateAmountVOsMaxSize; idx++) {
								sitProRateAmountVO = sitProRateAmountVOs.get(idx);
								
								mapTemp = new HashMap<String, String>();
								
								mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
								if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
									mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
									mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
								} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
									mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
								} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
									mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								}
								mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
								
								mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
								mapTemp.put("PPDOFC",        sitProBlInfoVO.getPpdofc());
								mapTemp.put("PPD_PAYER",     sitProBlInfoVO.getPpdPayer());
								mapTemp.put("CCTOFC",        sitProBlInfoVO.getCctofc());
								mapTemp.put("CCT_PAYER",     sitProBlInfoVO.getCctPayer());
								mapTemp.put("THDOFC",        sitProBlInfoVO.getThdofc());
								mapTemp.put("SCNO",          sitProBlInfoVO.getScno());
								mapTemp.put("RFANO",         sitProBlInfoVO.getRfano());
								
								mapTemp.put("FCTYPE",        (sitProRateAmountVO.getFctype() != null) ? sitProRateAmountVO.getFctype() : "");
								mapTemp.put("RATE",          (sitProRateAmountVO.getRate() != null) ? sitProRateAmountVO.getRate() : "");
								mapTemp.put("REVENUETON",    (sitProRateAmountVO.getRevenueton() != null) ? sitProRateAmountVO.getRevenueton() : "");
								mapTemp.put("PPD",           (sitProRateAmountVO.getPpd() != null) ? sitProRateAmountVO.getPpd() : "");
								mapTemp.put("CCT",           (sitProRateAmountVO.getCct() != null) ? sitProRateAmountVO.getCct() : "");
								mapTemp.put("CURRENCYCODE",  (sitProRateAmountVO.getCurrencycode() != null) ? sitProRateAmountVO.getCurrencycode() : "");
								mapTemp.put("EXCHRATE",      (sitProRateAmountVO.getExchrate() != null) ? sitProRateAmountVO.getExchrate() : "");
								mapTemp.put("TARIFF",        (sitProRateAmountVO.getTariff() != null) ? sitProRateAmountVO.getTariff() : "");
								mapTemp.put("PERTYPE",       (sitProRateAmountVO.getPertype() != null) ? sitProRateAmountVO.getPertype() : "");
								mapTemp.put("RATEOFC",       (sitProRateAmountVO.getRateofc() != null) ? sitProRateAmountVO.getRateofc() : "");
								
								
								int sitProRateAmountTTLVOsMaxSize = sitProRateAmountTTLVOs.size();
								if(sitProRateAmountTTLVOsMaxSize > 0) {
									for(int idx2 = 0; idx2 < sitProRateAmountTTLVOsMaxSize; idx2++) {
										sitProRateAmountTTLVO = sitProRateAmountTTLVOs.get(idx2);
										if(("0".equals(sitProRateAmountVO.getCct()) && "0".equals(sitProRateAmountTTLVO.getCctTotal()) && sitProRateAmountVO.getCurrencycode().equals(sitProRateAmountTTLVO.getTotalCur())) ||
										   ("0".equals(sitProRateAmountVO.getPpd()) && "0".equals(sitProRateAmountTTLVO.getPpdTotal()) && sitProRateAmountVO.getCurrencycode().equals(sitProRateAmountTTLVO.getTotalCur()))){
											mapTemp.put("PPD_TOTAL",       sitProRateAmountTTLVO.getPpdTotal());
											mapTemp.put("CCT_TOTAL",       sitProRateAmountTTLVO.getCctTotal());
											mapTemp.put("TOTAL_CUR",       sitProRateAmountTTLVO.getTotalCur());
										}
									}
								}
								mapTemp.put("PPD_USD",       ppdUsd);
								mapTemp.put("CCT_USD",       cctUsd);
								mapTemp.put("3RD_PAYER",       (sitProRateAmountVO.getThrPayer() != null) ? sitProRateAmountVO.getThrPayer() : "");
								listBlFrt.add(mapTemp);
							}
						} else {
							mapTemp = new HashMap<String, String>();
							
							mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
							if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							}
							mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
							
							mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
							mapTemp.put("PPDOFC",        sitProBlInfoVO.getPpdofc());
							mapTemp.put("PPD_PAYER",     sitProBlInfoVO.getPpdPayer());
							mapTemp.put("CCTOFC",        sitProBlInfoVO.getCctofc());
							mapTemp.put("CCT_PAYER",     sitProBlInfoVO.getCctPayer());
							mapTemp.put("THDOFC",        sitProBlInfoVO.getThdofc());
							mapTemp.put("SCNO",          sitProBlInfoVO.getScno());
							mapTemp.put("RFANO",         sitProBlInfoVO.getRfano());
							
							mapTemp.put("FCTYPE",        "");
							mapTemp.put("RATE",          "");
							mapTemp.put("REVENUETON",    "");
							mapTemp.put("PPD",           "");
							mapTemp.put("CCT",           "");
							mapTemp.put("PPD_USD",       "");
							mapTemp.put("CCT_USD",       "");
							mapTemp.put("CURRENCYCODE",  "");
							mapTemp.put("EXCHRATE",      "");
							mapTemp.put("TARIFF",        "");
							mapTemp.put("PERTYPE",       "");
							mapTemp.put("RATEOFC",       "");
							
							mapTemp.put("PPD_TOTAL",     "");
							mapTemp.put("CCT_TOTAL",     "");
							mapTemp.put("TOTAL_CUR",     "");
							
							mapTemp.put("3RD_PAYER",     "");
							
							listBlFrt.add(mapTemp);
						}
						
						//##################### B/L Remarks
						mapTemp = new HashMap<String, String>();
						
						mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
						if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
							mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
						} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
							mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
						} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
							mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
						}

						mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
						mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
						mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
						mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
						mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
						
						int CmdtDescLength = brMndDescInfoVO.getCmdtDesc().length();
						
						if(CmdtDescLength > 30000){ // M & D 탭에 Description of Goods의 길이가 32767가 넘으면 엑셀 하나의 셀에 들어가는 길이가 초과되어서 다운 도중 에러가 발생함 
							                        // 그것을 방지하기 위한 로직
							mapTemp.put("DESC1",          brMndDescInfoVO.getCmdtDesc().substring(0,30000));
							mapTemp.put("DESC2",          brMndDescInfoVO.getCmdtDesc().substring(30000,CmdtDescLength));
						}else{
							mapTemp.put("DESC1",          brMndDescInfoVO.getCmdtDesc());
							mapTemp.put("DESC2",          "");
						}
						
						mapTemp.put("MARKNO",        brMndDescInfoVO.getMkMark());
						listBlRmk.add(mapTemp);
						
						//###################### Cargo
						
						if(sitProCntrRfAkBrCgoInfoVOs.size() > 0) {
							
							for(int cntrIdx=0; cntrIdx < sitProCntrRfAkBrCgoInfoVOs.size(); cntrIdx++) {
								sitProCntrRfAkBrCgoInfoVO = sitProCntrRfAkBrCgoInfoVOs.get(cntrIdx);
								
								sitproEdiVO.setCntrNo(sitProCntrRfAkBrCgoInfoVO.getCntrNo());
								sitProDgInfoVOs = dbDao.searchDangerCgo(sitproEdiVO);
								
								sitProDgInfoVOsSize = sitProDgInfoVOs.size();
								if(sitProDgInfoVOsSize > 0) {
									for(int dgIdx=0; dgIdx<sitProDgInfoVOsSize; dgIdx++) {
										sitProDgInfoVO = sitProDgInfoVOs.get(dgIdx);
										mapTemp = new HashMap<String, String>();
										
										mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
										if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
											mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
											mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
										} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
											mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
										} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
											mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
										}
										mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
										
										mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
										mapTemp.put("SCNO",          sitProBlInfoVO.getScno());
										mapTemp.put("RFANO",         sitProBlInfoVO.getRfano());
										
										mapTemp.put("CNTRNBR",       sitProCntrRfAkBrCgoInfoVO.getCntrnbr());
										
										mapTemp.put("UNNBR",		 sitProDgInfoVO.getUnnbr());
										mapTemp.put("CLASS",         sitProDgInfoVO.getClass1());
										mapTemp.put("DG_DESC",       sitProDgInfoVO.getDgDesc());
										mapTemp.put("CONTACT_NM",    sitProDgInfoVO.getContactNm());
										mapTemp.put("PHONE",         sitProDgInfoVO.getPhone());
										mapTemp.put("PAGE",          sitProDgInfoVO.getPage());
										mapTemp.put("FLSH_TEMP",	 sitProDgInfoVO.getFlshTemp());
										mapTemp.put("FLSH_UNIT",	 sitProDgInfoVO.getFlshUnit());
										mapTemp.put("DG_REMARK",	 sitProDgInfoVO.getDgRemark());
										mapTemp.put("EMSNO",		 sitProDgInfoVO.getEmsno());
										mapTemp.put("PSACLS",		 sitProDgInfoVO.getPsacls());
										mapTemp.put("PKGGRP",		 sitProDgInfoVO.getPkggrp());
										mapTemp.put("MFAG1",		 sitProDgInfoVO.getMfag1());
										mapTemp.put("MFAG2",		 sitProDgInfoVO.getMfag2());
										mapTemp.put("MAR_POLL",	     sitProDgInfoVO.getMarPoll());
										mapTemp.put("LABEL_CD",	     sitProDgInfoVO.getLabelCd());
										mapTemp.put("LABEL_DESC",    sitProDgInfoVO.getLabelDesc());
										mapTemp.put("D_PKG",		 sitProDgInfoVO.getDPkg());
										mapTemp.put("D_PKGUNIT",	 sitProDgInfoVO.getDPkgunit());
										mapTemp.put("NWGT",			 sitProDgInfoVO.getNwgt());
										mapTemp.put("NWGT_UNIT",	 sitProDgInfoVO.getNwgtUnit());
										mapTemp.put("GWGT",			 sitProDgInfoVO.getGwgt());
										mapTemp.put("GWGT_UNIT",	 sitProDgInfoVO.getGwgtUnit());
										mapTemp.put("MEA",			 sitProDgInfoVO.getMea());
										mapTemp.put("MEA_UNIT",	     sitProDgInfoVO.getMeaUnit());
										mapTemp.put("HAZ_CONT",	     sitProDgInfoVO.getHazCont());
										mapTemp.put("STWG",			 sitProDgInfoVO.getStwg());
										mapTemp.put("LABEL",		 sitProDgInfoVO.getLabel());
										
										listCgo.add(mapTemp);
									}
								} else {
									
									mapTemp = new HashMap<String, String>();
									
									mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
									if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
										mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
										mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
									} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
										mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
									} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
										mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
									}
									mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
									
									mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
									mapTemp.put("SCNO",          sitProBlInfoVO.getScno());
									mapTemp.put("RFANO",         sitProBlInfoVO.getRfano());
									
									mapTemp.put("CNTRNBR",       sitProCntrRfAkBrCgoInfoVO.getCntrnbr());
									
									mapTemp.put("UNNBR",		 "");
									mapTemp.put("CLASS",         "");
									mapTemp.put("DG_DESC",       "");
									mapTemp.put("CONTACT_NM",    "");
									mapTemp.put("PHONE",         "");
									mapTemp.put("PAGE",          "");
									mapTemp.put("FLSH_TEMP",	 "");
									mapTemp.put("FLSH_UNIT",	 "");
									mapTemp.put("DG_REMARK",	 "");
									mapTemp.put("EMSNO",		 "");
									mapTemp.put("PSACLS",		 "");
									mapTemp.put("PKGGRP",		 "");
									mapTemp.put("MFAG1",		 "");
									mapTemp.put("MFAG2",		 "");
									mapTemp.put("MAR_POLL",	     "");
									mapTemp.put("LABEL_CD",	     "");
									mapTemp.put("LABEL_DESC",    "");
									mapTemp.put("D_PKG",		 "");
									mapTemp.put("D_PKGUNIT",	 "");
									mapTemp.put("NWGT",			 "");
									mapTemp.put("NWGT_UNIT",	 "");
									mapTemp.put("GWGT",			 "");
									mapTemp.put("GWGT_UNIT",	 "");
									mapTemp.put("MEA",			 "");
									mapTemp.put("MEA_UNIT",	     "");
									mapTemp.put("HAZ_CONT",	     "");
									mapTemp.put("STWG",			 "");
									mapTemp.put("LABEL",		 "");
									
									listCgo.add(mapTemp);
								}
							}
						}else{
							//추가
							mapTemp = new HashMap<String, String>();
							mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
							if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							}
							mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
							
							mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
							mapTemp.put("SCNO",          sitProBlInfoVO.getScno());
							mapTemp.put("RFANO",         sitProBlInfoVO.getRfano());
							
							mapTemp.put("CNTRNBR",       "");
							
							mapTemp.put("UNNBR",		 "");
							mapTemp.put("CLASS",         "");
							mapTemp.put("DG_DESC",       "");
							mapTemp.put("CONTACT_NM",    "");
							mapTemp.put("PHONE",         "");
							mapTemp.put("PAGE",          "");
							mapTemp.put("FLSH_TEMP",	 "");
							mapTemp.put("FLSH_UNIT",	 "");
							mapTemp.put("DG_REMARK",	 "");
							mapTemp.put("EMSNO",		 "");
							mapTemp.put("PSACLS",		 "");
							mapTemp.put("PKGGRP",		 "");
							mapTemp.put("MFAG1",		 "");
							mapTemp.put("MFAG2",		 "");
							mapTemp.put("MAR_POLL",	     "");
							mapTemp.put("LABEL_CD",	     "");
							mapTemp.put("LABEL_DESC",    "");
							mapTemp.put("D_PKG",		 "");
							mapTemp.put("D_PKGUNIT",	 "");
							mapTemp.put("NWGT",			 "");
							mapTemp.put("NWGT_UNIT",	 "");
							mapTemp.put("GWGT",			 "");
							mapTemp.put("GWGT_UNIT",	 "");
							mapTemp.put("MEA",			 "");
							mapTemp.put("MEA_UNIT",	     "");
							mapTemp.put("HAZ_CONT",	     "");
							mapTemp.put("STWG",			 "");
							mapTemp.put("LABEL",		 "");
							
							listCgo.add(mapTemp);
						}
						
						//###################### Cargo Packaging
						if(sitProCntrRfAkBrCgoInfoVOs.size() > 0) {
							
							for(int cntrIdx=0; cntrIdx < sitProCntrRfAkBrCgoInfoVOs.size(); cntrIdx++) {
								sitProCntrRfAkBrCgoInfoVO = sitProCntrRfAkBrCgoInfoVOs.get(cntrIdx);
								
								sitproEdiVO.setCntrNo(sitProCntrRfAkBrCgoInfoVO.getCntrNo());
								
								sitProCmInfoVOList = dbDao.searchCmByCntr(sitproEdiVO);
								
								int sitProCmInfoVOListSize = sitProCmInfoVOList.size();
								if(sitProCmInfoVOListSize > 0) {
									
									for(int cmIdx=0; cmIdx<sitProCmInfoVOListSize; cmIdx++) {
										sitProCmInfoVO = sitProCmInfoVOList.get(cmIdx);
										
										mapTemp = new HashMap<String, String>();
										
										mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
										if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
											mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
											mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
										} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
											mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
										} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
											mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
										}
										mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
										
										mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
										mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
										mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
										mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
										mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
										
										mapTemp.put("CNTRNBR",       sitProCntrRfAkBrCgoInfoVO.getCntrnbr());
										
										mapTemp.put("D_CMDT",        sitProCmInfoVO.getDCmdt());
										mapTemp.put("D_PUNIT",       sitProCmInfoVO.getDPunit());
										mapTemp.put("D_PKG",         sitProCmInfoVO.getDPkg());
										mapTemp.put("D_WGT",         sitProCmInfoVO.getDWgt());
										mapTemp.put("D_MEAS",        sitProCmInfoVO.getDMeas());
										mapTemp.put("D_DESC",        sitProCmInfoVO.getDDesc());
										mapTemp.put("D_CTMS_REF",    sitProCmInfoVO.getDCtmsRef());
										mapTemp.put("D_HTS_CD",      sitProCmInfoVO.getDHtsCd());
										mapTemp.put("D_HS_CD",       sitProCmInfoVO.getDHsCd());
										mapTemp.put("D_NCM_CD",      sitProCmInfoVO.getDNcmCd());
										
										listCgoPck.add(mapTemp);
									}
								} else {
									
									mapTemp = new HashMap<String, String>();
									
									mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
									if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
										mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
										mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
									} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
										mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
									} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
										mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
									}
									mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
									
									mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
									mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
									mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
									mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
									mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
									
									mapTemp.put("CNTRNBR",       sitProCntrRfAkBrCgoInfoVO.getCntrnbr());
									
									mapTemp.put("D_CMDT",        "");
									mapTemp.put("D_PUNIT",       "");
									mapTemp.put("D_PKG",         "");
									mapTemp.put("D_WGT",         "");
									mapTemp.put("D_MEAS",        "");
									mapTemp.put("D_DESC",        "");
									mapTemp.put("D_CTMS_REF",    "");
									mapTemp.put("D_HTS_CD",      "");
									mapTemp.put("D_HS_CD",       "");
									mapTemp.put("D_NCM_CD",      "");
									
									listCgoPck.add(mapTemp);
								}
							}
						}else{
							//추가
							mapTemp = new HashMap<String, String>();
							mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
							if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							}
							mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
							
							mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
							mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
							mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
							mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
							mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
							
							mapTemp.put("CNTRNBR",       "");
							
							mapTemp.put("D_CMDT",        "");
							mapTemp.put("D_PUNIT",       "");
							mapTemp.put("D_PKG",         "");
							mapTemp.put("D_WGT",         "");
							mapTemp.put("D_MEAS",        "");
							mapTemp.put("D_DESC",        "");
							mapTemp.put("D_CTMS_REF",    "");
							mapTemp.put("D_HTS_CD",      "");
							mapTemp.put("D_HS_CD",       "");
							mapTemp.put("D_NCM_CD",      "");
							
							listCgoPck.add(mapTemp);
						}
						
						//###################### Cargo Marks & Numbers
						if(sitProCntrRfAkBrCgoInfoVOs.size() > 0) {
							
							for(int cntrIdx=0; cntrIdx < sitProCntrRfAkBrCgoInfoVOs.size(); cntrIdx++) {
								sitProCntrRfAkBrCgoInfoVO = sitProCntrRfAkBrCgoInfoVOs.get(cntrIdx);
								
								int sitProCmInfoVOListSize = sitProCmInfoVOList.size();
								if(sitProCmInfoVOListSize > 0) {
									
									for(int cmIdx=0; cmIdx<sitProCmInfoVOListSize; cmIdx++) {
										sitProCmInfoVO = sitProCmInfoVOList.get(cmIdx);
										
										mapTemp = new HashMap<String, String>();
										
										mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
										if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
											mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
											mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
										} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
											mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
										} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
											mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
										}
										
										mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
										mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
										mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
										mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
										mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
										
										if(sitProCmDescInfoVO != null) {
											mapTemp.put("CMDESC",        (sitProCmDescInfoVO.getCmdesc() != null) ? sitProCmDescInfoVO.getCmdesc() : "");
											mapTemp.put("LOCAL_IPI",     (sitProCmDescInfoVO.getLocalIpi() != null) ? sitProCmDescInfoVO.getLocalIpi() : "");
											mapTemp.put("EQREL",         (sitProCmDescInfoVO.getEqrel() != null) ? sitProCmDescInfoVO.getEqrel() : "");
											mapTemp.put("EQPICKDT",      (sitProCmDescInfoVO.getEqpickdt() != null) ? sitProCmDescInfoVO.getEqpickdt() : "");
											mapTemp.put("EQRTN",         (sitProCmDescInfoVO.getEqrtn() != null) ? sitProCmDescInfoVO.getEqrtn() : "");
										}
										mapTemp.put("CNTRNBR",       sitProCntrRfAkBrCgoInfoVO.getCntrnbr());
										
										mapTemp.put("D_MARK",        sitProCmInfoVO.getDMark().replaceAll("D_MARK:", ""));
										
										listCgoMkNo.add(mapTemp);
									}
								} else {
									
									mapTemp = new HashMap<String, String>();
									
									mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
									if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
										mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
										mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
									} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
										mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
									} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
										mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
									}
									
									mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
									mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
									mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
									mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
									mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
									
									if(sitProCmDescInfoVO != null) {
										mapTemp.put("CMDESC",        (sitProCmDescInfoVO.getCmdesc() != null) ? sitProCmDescInfoVO.getCmdesc() : "");
										mapTemp.put("LOCAL_IPI",     (sitProCmDescInfoVO.getLocalIpi() != null) ? sitProCmDescInfoVO.getLocalIpi() : "");
										mapTemp.put("EQREL",         (sitProCmDescInfoVO.getEqrel() != null) ? sitProCmDescInfoVO.getEqrel() : "");
										mapTemp.put("EQPICKDT",      (sitProCmDescInfoVO.getEqpickdt() != null) ? sitProCmDescInfoVO.getEqpickdt() : "");
										mapTemp.put("EQRTN",         (sitProCmDescInfoVO.getEqrtn() != null) ? sitProCmDescInfoVO.getEqrtn() : "");
									}
									
									mapTemp.put("CNTRNBR",       sitProCntrRfAkBrCgoInfoVO.getCntrnbr());
									
									mapTemp.put("D_MARK",        "");
									
									listCgoMkNo.add(mapTemp);
								}
							}
						}else{
							//추가
							mapTemp = new HashMap<String, String>();
							mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
							if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							}
							
							mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
							mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
							mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
							mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
							mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
							
							if(sitProCmDescInfoVO != null) {
								mapTemp.put("CMDESC",        (sitProCmDescInfoVO.getCmdesc() != null) ? sitProCmDescInfoVO.getCmdesc() : "");
								mapTemp.put("LOCAL_IPI",     (sitProCmDescInfoVO.getLocalIpi() != null) ? sitProCmDescInfoVO.getLocalIpi() : "");
								mapTemp.put("EQREL",         (sitProCmDescInfoVO.getEqrel() != null) ? sitProCmDescInfoVO.getEqrel() : "");
								mapTemp.put("EQPICKDT",      (sitProCmDescInfoVO.getEqpickdt() != null) ? sitProCmDescInfoVO.getEqpickdt() : "");
								mapTemp.put("EQRTN",         (sitProCmDescInfoVO.getEqrtn() != null) ? sitProCmDescInfoVO.getEqrtn() : "");
							}
							
							mapTemp.put("CNTRNBR",       "");
							
							mapTemp.put("D_MARK",        "");
							
							listCgoMkNo.add(mapTemp);
						}
						
						//###################### B/L Notify Party
						mapTemp = new HashMap<String, String>();
						
						mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
						if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
							mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
						} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
							mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
						} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
							mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
						}
						mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
						
						mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
						mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
						mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
						mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
						mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
						
						mapTemp.put("SHPRCN",        sitProBlInfoVO.getShprcn());
						mapTemp.put("SHPRCD",        sitProBlInfoVO.getShprcd());
						mapTemp.put("SHPR1",         sitProBlInfoVO.getShpr1());
						mapTemp.put("SHPR2",         sitProBlInfoVO.getShpr2());
						mapTemp.put("SHPR3",         sitProBlInfoVO.getShpr3());
						mapTemp.put("SHPR4",         sitProBlInfoVO.getShpr4());
						mapTemp.put("SHPR5",         sitProBlInfoVO.getShpr5());
						mapTemp.put("SHPRTXID",      sitProBlInfoVO.getShprtxid());
						mapTemp.put("CNEECN",        sitProBlInfoVO.getCneecn());
						mapTemp.put("CNEECD",        sitProBlInfoVO.getCneecd());
						mapTemp.put("CNEE1",         sitProBlInfoVO.getCnee1());
						mapTemp.put("CNEE2",         sitProBlInfoVO.getCnee2());
						mapTemp.put("CNEE3",         sitProBlInfoVO.getCnee3());
						mapTemp.put("CNEE4",         sitProBlInfoVO.getCnee4());
						mapTemp.put("CNEE5",         sitProBlInfoVO.getCnee5());
						mapTemp.put("CNEETXID",      sitProBlInfoVO.getCneetxid());
						mapTemp.put("NTFYCN",        sitProBlInfoVO.getNtfycn());
						mapTemp.put("NTFYCD",        sitProBlInfoVO.getNtfycd());
						mapTemp.put("NTFY1",         sitProBlInfoVO.getNtfy1());
						mapTemp.put("NTFY2",         sitProBlInfoVO.getNtfy2());
						mapTemp.put("NTFY3",         sitProBlInfoVO.getNtfy3());
						mapTemp.put("NTFY4",         sitProBlInfoVO.getNtfy4());
						mapTemp.put("NTFY5",         sitProBlInfoVO.getNtfy5());
						mapTemp.put("NTFYTXID",      sitProBlInfoVO.getNtfytxid());
						mapTemp.put("NTFY2CN",       sitProBlInfoVO.getNtfy2cn());
						mapTemp.put("NTFY2CD",       sitProBlInfoVO.getNtfy2cd()); 
						mapTemp.put("NTFY21",        sitProBlInfoVO.getNtfy21());
						mapTemp.put("NTFY22",        sitProBlInfoVO.getNtfy22());
						mapTemp.put("NTFY23",        sitProBlInfoVO.getNtfy23());
						mapTemp.put("NTFY24",        sitProBlInfoVO.getNtfy24());
						mapTemp.put("NTFY25",        sitProBlInfoVO.getNtfy25());
						mapTemp.put("NTFY2TXID",     "");
						mapTemp.put("FFWDCN",        sitProBlInfoVO.getFfwdcn());
						mapTemp.put("FFWDCD",        sitProBlInfoVO.getFfwdcd());
						mapTemp.put("FFWD1",         sitProBlInfoVO.getFfwd1());
						mapTemp.put("FFWD2",         sitProBlInfoVO.getFfwd2()); 
						mapTemp.put("FFWD3",         sitProBlInfoVO.getFfwd3()); 
						mapTemp.put("FFWD4",         sitProBlInfoVO.getFfwd4()); 
						mapTemp.put("FFWD5",         sitProBlInfoVO.getFfwd5());
						mapTemp.put("FFWDTXID",      "");
						mapTemp.put("EXPOCN",        sitProBlInfoVO.getExpocn());
						mapTemp.put("EXPOCD",        sitProBlInfoVO.getExpocd());
						mapTemp.put("EXPO1",         sitProBlInfoVO.getExpo1());
						mapTemp.put("EXPO2",         sitProBlInfoVO.getExpo2());
						mapTemp.put("EXPO3",         sitProBlInfoVO.getExpo3());
						mapTemp.put("EXPO4",         sitProBlInfoVO.getExpo4());
						mapTemp.put("EXPO5",         sitProBlInfoVO.getExpo5());
						mapTemp.put("EXPOTXID",      "");
						
						listBlNtfy.add(mapTemp);
						
						//###################### B/L Route
						int sitProVslEtcInfoVOsMaxSize = sitProVslEtcInfoVOs.size();
						if(sitProVslEtcInfoVOsMaxSize > 0) {
							
							boolean isPre = true;
							int prePostIdx = 1;
							
							for(int idx = 0; idx < sitProVslEtcInfoVOsMaxSize; idx++)  {
							
								sitProVslEtcInfoVO = sitProVslEtcInfoVOs.get(idx);

								mapTemp = new HashMap<String, String>();
								
								mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
								if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
									mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
									mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
								} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
									mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
								} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
									mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								}
								mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
								mapTemp.put("PORTNAME",		 mapSitProVslInfo.get("PORTNAME"));
								mapTemp.put("ETA",			 mapSitProVslInfo.get("ETA"));
								mapTemp.put("ETD",			 mapSitProVslInfo.get("ETD"));
								mapTemp.put("ATA",			 mapSitProVslInfo.get("ATA"));
								mapTemp.put("ATD",			 mapSitProVslInfo.get("ATD"));
								mapTemp.put("NEXTPORT",		 mapSitProVslInfo.get("NEXTPORT"));
								mapTemp.put("NEXTPORT_ETA",	 mapSitProVslInfo.get("NEXTPORT_ETA"));
								mapTemp.put("PREVPORT",		 mapSitProVslInfo.get("PREVPORT"));
								mapTemp.put("PREVPORT_ETD",	 mapSitProVslInfo.get("PREVPORT_ETD"));

								mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
								mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
								mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
								mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
								mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
								
								if(!"T".equals(sitProVslEtcInfoVO.getVslPrePstCd())){
									if(isPre){
										mapTemp.put("VVDTYPE",		 "PRE" + prePostIdx);
										prePostIdx++;
									}else{
										mapTemp.put("VVDTYPE",		 "POST" + prePostIdx);
										prePostIdx++;												
									}
								}else{
									mapTemp.put("VVDTYPE",		 "TRUNK");
									isPre = false;
									prePostIdx = 1;
								}
								
								//mapTemp.put("VVDTYPE",		 sitProVslEtcInfoVO.getVvdtype());
								mapTemp.put("LANE_CD",		 sitProVslEtcInfoVO.getLaneCd());
								mapTemp.put("BVVD1",		 sitProVslEtcInfoVO.getBvvd1());
								mapTemp.put("VSL_CALLSIGN1", sitProVslEtcInfoVO.getVslCallsign1());
								mapTemp.put("VSL_LLOYDCODE1",sitProVslEtcInfoVO.getVslLloydcode1());
								mapTemp.put("VSL_FULLNAME1", sitProVslEtcInfoVO.getVslFullname1());
								mapTemp.put("VSL_FLAG1",     sitProVslEtcInfoVO.getVslRgstCntCd1());
								mapTemp.put("BLPOL1",        sitProVslEtcInfoVO.getBlpol1());
								mapTemp.put("POL_YD",        sitProVslEtcInfoVO.getPolYd());
								mapTemp.put("POL_FULLNAME1", sitProVslEtcInfoVO.getPolFullname1());
								mapTemp.put("BLPOD1",        sitProVslEtcInfoVO.getBlpod1());
								mapTemp.put("POD_YD",        sitProVslEtcInfoVO.getPodYd());
								mapTemp.put("POD_FULLNAME1", sitProVslEtcInfoVO.getPodFullname1());
								mapTemp.put("POLETA1",       sitProVslEtcInfoVO.getPoleta1());
								mapTemp.put("POLETD1",       sitProVslEtcInfoVO.getPoletd1());
								mapTemp.put("PODETA1",       sitProVslEtcInfoVO.getPodeta1());
								mapTemp.put("PODETD1",       sitProVslEtcInfoVO.getPodetd1());
								mapTemp.put("OP_CODE",       sitProVslEtcInfoVO.getOpCode());

								listBlRout.add(mapTemp);
								
							}
							
						} else {
							mapTemp = new HashMap<String, String>();
							
							mapTemp.put("VVD",           mapSitProVslInfo.get("VVD"));
							if(mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") == null && mapSitProVslInfo.get("OB_CON_VVD") != null ) {
								mapTemp.put("OB_CON_VVD",       mapSitProVslInfo.get("OB_CON_VVD"));
							} else if (mapSitProVslInfo.get("IB_CON_VVD") != null && mapSitProVslInfo.get("OB_CON_VVD") == null ) {
								mapTemp.put("IB_CON_VVD",       mapSitProVslInfo.get("IB_CON_VVD"));
							}
							mapTemp.put("PORT",			 mapSitProVslInfo.get("PORT"));
							mapTemp.put("PORTNAME",		 mapSitProVslInfo.get("PORTNAME"));
							mapTemp.put("ETA",			 mapSitProVslInfo.get("ETA"));
							mapTemp.put("ETD",			 mapSitProVslInfo.get("ETD"));
							mapTemp.put("ATA",			 mapSitProVslInfo.get("ATA"));
							mapTemp.put("ATD",			 mapSitProVslInfo.get("ATD"));
							mapTemp.put("NEXTPORT",		 mapSitProVslInfo.get("NEXTPORT"));
							mapTemp.put("NEXTPORT_ETA",	 mapSitProVslInfo.get("NEXTPORT_ETA"));
							mapTemp.put("PREVPORT",		 mapSitProVslInfo.get("PREVPORT"));
							mapTemp.put("PREVPORT_ETD",	 mapSitProVslInfo.get("PREVPORT_ETD"));

							mapTemp.put("BLNBR",         sitProBlInfoVO.getBlnbr());
							mapTemp.put("BLPOL",         sitProBlInfoVO.getBlpol());
							mapTemp.put("BLPOD",         sitProBlInfoVO.getBlpod());
							mapTemp.put("BLPOR",         sitProBlInfoVO.getBlpor());
							mapTemp.put("BLDEL",         sitProBlInfoVO.getBldel());
							
							mapTemp.put("VVDTYPE",		 "");
							mapTemp.put("LANE_CD",		 "");
							mapTemp.put("BVVD1",		 "");
							mapTemp.put("VSL_CALLSIGN1", "");
							mapTemp.put("VSL_LLOYDCODE1","");
							mapTemp.put("VSL_FULLNAME1", "");
							mapTemp.put("VSL_FLAG1",     "");
							mapTemp.put("BLPOL1",        "");
							mapTemp.put("POL_YD",        "");
							mapTemp.put("POL_FULLNAME1", "");
							mapTemp.put("BLPOD1",        "");
							mapTemp.put("POD_YD",        "");
							mapTemp.put("POD_FULLNAME1", "");
							mapTemp.put("POLETA1",       "");
							mapTemp.put("POLETD1",       "");
							mapTemp.put("PODETA1",       "");
							mapTemp.put("PODETD1",       "");
							mapTemp.put("OP_CODE",       "");
							
							listBlRout.add(mapTemp);
						}
						
					} // end for(i)
				}
				
				mapBlRoot.put("Data", listBlRoot);
				mapBlCntr.put("Data", listBlCntr);
				mapBlFrt.put("Data", listBlFrt);
				mapBlRmk.put("Data", listBlRmk);
				mapCgo.put("Data", listCgo);
				mapCgoPck.put("Data", listCgoPck);
				mapCgoMkNo.put("Data", listCgoMkNo);
				mapBlNtfy.put("Data", listBlNtfy);
				mapBlRout.put("Data", listBlRout);
				
				ldfDownMap.put("listBlRoot", mapBlRoot);
				ldfDownMap.put("listBlCntr", mapBlCntr);
				ldfDownMap.put("listBlFrt", mapBlFrt);
				ldfDownMap.put("listBlRmk", mapBlRmk);
				ldfDownMap.put("listCgo", mapCgo);
				ldfDownMap.put("listCgoPck", mapCgoPck);
				ldfDownMap.put("listCgoMkNo", mapCgoMkNo);
				ldfDownMap.put("listBlNtfy", mapBlNtfy);
				ldfDownMap.put("listBlRout", mapBlRout);
				
				//ldfDownMap.put("sitProVslEtcInfoVOs", sitProVslEtcInfoVOs);
				//ldfDownMap.put("sitProRateAmountTTLVOs", sitProRateAmountTTLVOs);
				//ldfDownMap.put("sitProCntrRfAkBrCgoInfoVOs", sitProCntrRfAkBrCgoInfoVOs);
				
				// BL LDF Download 로그등록
				dbDao.addBkgCstmsBlLodFctrLog(listLdfLog);
				
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return ldfDownMap; // "sss";//flatFile.toString();	
	}	

	/**
	 * BL LDF 다운로드 배치(베트남의 경우만)
	 * @throws EventException
	 */
	public void searchBlLdfBatch() throws EventException {

		try {
			List<EurManifestTransmitVO> list = dbDao.searchBlLdfBatch();
			List<EurManifestTransmitVO> listVvdGrp = new ArrayList<EurManifestTransmitVO>();

			for (int i = 0; i < list.size(); i++) {
				EurManifestTransmitVO vo = list.get(i);
				// VVD별로 다운로드하기 위함
				listVvdGrp.add(vo);

				if (i < list.size() - 1 && list.get(i + 1).getPagerows().equals("1")) {
					EurManifestTransmitVO[] vos = new EurManifestTransmitVO[listVvdGrp.size()];
					vos = listVvdGrp.toArray(vos);
					HashMap<String, Object> ldfDownMap = this.searchLDFDownExcel(vos, "BATCH", "BATCH");
					this.makeFile(ldfDownMap);
					listVvdGrp.clear();
				}
			}
			if (listVvdGrp.size() > 0) {
				EurManifestTransmitVO[] vos = new EurManifestTransmitVO[listVvdGrp.size()];
				vos = listVvdGrp.toArray(vos);
				HashMap<String, Object> ldfDownMap = this.searchLDFDownExcel(vos, "BATCH", "BATCH");
				this.makeFile(ldfDownMap);
				listVvdGrp.clear();
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler().getMessage(), ex);
		}
	}

	/**
	 * 엑셀파일을 만든다.
	 * @param ldfDownMap
	 * @throws Exception
	 */
	private void makeFile(HashMap<String, Object> ldfDownMap) throws Exception {

		CustomsCommonMgtBC commBC = new CustomsCommonMgtBCImpl();
		CstmsCdConvVO vo = new CstmsCdConvVO();
		vo.setChkCntCd("VN");
		vo.setChkCstmsDivId("SITPRO_FTP_INFO");
		List<CstmsCdConvVO> ftpInfo = commBC.searchCstmsCdConvCtntList(vo);
		String hostName = "";
		String userName = "";
		String password = "";
		if (ftpInfo.size() > 0) {
			hostName = ftpInfo.get(0).getAttrCtnt1();
			userName = ftpInfo.get(0).getAttrCtnt2();
			password = ftpInfo.get(0).getAttrCtnt3();
		} else {
			throw new EventException("FTP information does not exist");
		}

		List<HashMap<String, String>> listBlRoot = (List) ((HashMap) ldfDownMap.get("listBlRoot")).get("Data");
		List<HashMap<String, String>> listBlCntr = (List) ((HashMap) ldfDownMap.get("listBlCntr")).get("Data");
		List<HashMap<String, String>> listBlFrt = (List) ((HashMap) ldfDownMap.get("listBlFrt")).get("Data");
		List<HashMap<String, String>> listBlRmk = (List) ((HashMap) ldfDownMap.get("listBlRmk")).get("Data");
		List<HashMap<String, String>> listBlCgo = (List) ((HashMap) ldfDownMap.get("listCgo")).get("Data");
		List<HashMap<String, String>> listBlPck = (List) ((HashMap) ldfDownMap.get("listCgoPck")).get("Data");
		List<HashMap<String, String>> listBlMkNo = (List) ((HashMap) ldfDownMap.get("listCgoMkNo")).get("Data");
		List<HashMap<String, String>> listBlNtfy = (List) ((HashMap) ldfDownMap.get("listBlNtfy")).get("Data");
		List<HashMap<String, String>> listBlRout = (List) ((HashMap) ldfDownMap.get("listBlRout")).get("Data");
		
		String[] title1 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "VSL_CALLSIGN", "VSL_LLOYDCODE", "VSL_FULLNAME", "VSL_FLAG", "PORT", "PORTNAME", "ETA", "ETD", "ATA", "ATD", "NEXTPORT", "NEXTPORT_ETA",
				"PREVPORT", "PREVPORT_ETD", "IO_IND", "COMP_ID", "MRN", "BLNBR", "BLPOL", "POL_AMS", "POL_FULLNAME", "BLPOD", "POD_AMS", "POD_FULLNAME", "BLPOR", "POR_AMS", "POR_FULLNAME",
				"POR_YARD", "BLDEL", "DEL_AMS", "DEL_FULLNAME", "DEL_YARD", "SVC_SCP", "BL_CMPL_STS", "BL_CMPL_TP", "BLRLY", "RLY_AMS", "RLY_FULLNAME", "BLPLACE", "BLDATE", "BLCOPY", "BLORG",
				"BLPKG", "BLPKGU", "BLWGT", "BL_WGT_UNIT", "BLMEA", "BL_MEA_UNIT", "RDTYPE", "CARGOTYPE", "COMMODITY", "BLCMD", "BLREPCMDCD", "BLREPCMD", "REMARK", "AUS_QUAR", "SRNBR", "BKGNBR",
				"RGN_BKGNBR", "CVRD_BY", "SCNO", "RFANO", "TW_SO_NO", "WAYBILL_IND", "CUSTREF_NUM", "FINAL_ETA", "FUNC_CODE", "ONBOARD", "INV_NO", "BLTS", "BLTP", "MSN", "MSNCFM", "IND_AGREE",
				"VALUE_AGREE", "EU_MRN_SEQ", "EU_MRN_VALUE", "EU_PORT", "EU_MRN_DATE", "EU_MRN_SOURCE", "HANTYPE", "COUNT", "ELNO", "ELPK", "ELPKU", "ELWT", "ELWTU" };

		String[] title2 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "PORT", "BLNBR", "CNTRNBR", "PUNIT", "PKG", "CNTRWGT", "CNTRGWGT", "CNTR_WGT_UNIT", "CNTRTRW", "CNTRTYPE", "SEALNBR", "FM_IND",
				"RF_IND", "DG_IND", "AK_IND", "BK_IND", "PL_IND", "TEMP", "TUNIT", "VENT", "MEASURE", "MEASURE_UNIT", "RDTYPE", "CMDT_DESC", "CMDTCD", "RF_REMARK", "RFDRY_IND", "OVF", "OVR", "OVH",
				"OVLW", "OVRW", "OVWGT", "OVWGT_UNIT", "VOID_SLOT", "STWG_REQ", "SOCIND", "HAULAGE", "BKWGT", "BKWGTU", "BKW", "BKH", "BKL", "CNTROWN", "CNTRTRM", "NOD_DEMURRAGE_FREETIME", "SEALSEQ",
				"SEALNBR" };

		String[] title3 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "PORT", "BLNBR", "PPDOFC", "PPD_PAYER", "CCTOFC", "CCT_PAYER", "THDOFC", "SCNO", "RFANO", "FCTYPE", "RATE", "REVENUETON", "PPD", "CCT",
				"CURRENCYCODE", "EXCHRATE", "TARIFF", "PERTYPE", "RATEOFC", "PPD_TOTAL", "CCT_TOTAL", "TOTAL_CUR", "PPD_USD", "CCT_USD", "3RD_PAYER" };

		String[] title4 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "BLNBR", "BLPOL", "BLPOD", "BLPOR", "BLDEL", "DESC", "MARKNO" };

		String[] title5 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "PORT", "BLNBR", "SCNO", "RFANO", "CNTRNBR", "UNNBR", "CLASS", "DG_DESC", "CONTACT_NM", "PHONE", "PAGE", "FLSH_TEMP", "FLSH_UNIT",
				"DG_REMARK", "EMSNO", "PSACLS", "PKGGRP", "MFAG1", "MFAG2", "MAR_POLL", "LABEL_CD", "LABEL_DESC", "D_PKG", "D_PKGUNIT", "NWGT", "NWGT_UNIT", "GWGT", "GWGT_UNIT", "MEA", "MEA_UNIT",
				"HAZ_CONT", "STWG", "LABEL" };

		String[] title6 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "PORT", "BLNBR", "BLPOL", "BLPOD", "BLPOR", "BLDEL", "CNTRNBR", "D_CMDT", "D_PUNIT", "D_PKG", "D_WGT", "D_MEAS", "D_DESC", "D_CTMS_REF",
				"D_HTS_CD", "D_HS_CD", "D_NCM_CD" };

		String[] title7 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "BLNBR", "BLPOL", "BLPOD", "BLPOR", "BLDEL", "CMDESC", "LOCAL_IPI", "EQREL", "EQPICKDT", "EQRTN", "CNTRNBR", "D_MARK" };

		String[] title8 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "PORT", "BLNBR", "BLPOL", "BLPOD", "BLPOR", "BLDEL", "SHPRCN", "SHPRCD", "SHPR1", "SHPR2", "SHPR3", "SHPR4", "SHPR5", "SHPRTXID",
				"CNEECN", "CNEECD", "CNEE1", "CNEE2", "CNEE3", "CNEE4", "CNEE5", "CNEETXID", "NTFYCN", "NTFYCD", "NTFY1", "NTFY2", "NTFY3", "NTFY4", "NTFY5", "NTFYTXID", "NTFY2CN", "NTFY2CD",
				"NTFY21", "NTFY22", "NTFY23", "NTFY24", "NTFY25", "NTFY2TXID", "FFWDCN", "FFWDCD", "FFWD1", "FFWD2", "FFWD3", "FFWD4", "FFWD5", "FFWDTXID", "EXPOCN", "EXPOCD", "EXPO1", "EXPO2",
				"EXPO3", "EXPO4", "EXPO5", "EXPOTXID" };

		String[] title9 = { "VVD", "IB_CON_VVD", "OB_CON_VVD", "PORT", "PORTNAME", "ETA", "ETD", "ATA", "ATD", "NEXTPORT", "NEXTPORT_ETA", "PREVPORT", "PREVPORT_ETD", "BLNBR", "BLPOL", "BLPOD",
				"BLPOR", "BLDEL", "VVDTYPE", "LANE_CD", "BVVD1", "VSL_CALLSIGN1", "VSL_LLOYDCODE1", "VSL_FULLNAME1", "VSL_FLAG1", "BLPOL1", "POL_YD", "POL_FULLNAME1", "BLPOD1", "POD_YD",
				"POD_FULLNAME1", "POLETA1", "POLETD1", "PODETA1", "PODETD1", "OP_CODE" };
		
		List<String[]> listTitle = new ArrayList<String[]>();
		listTitle.add(title1);
		listTitle.add(title2);
		listTitle.add(title3);
		listTitle.add(title4);
		listTitle.add(title5);
		listTitle.add(title6);
		listTitle.add(title7);
		listTitle.add(title8);
		listTitle.add(title9);
		List<List<HashMap<String, String>>> listData = new ArrayList<List<HashMap<String, String>>>();
		listData.add(listBlRoot);
		listData.add(listBlCntr);
		listData.add(listBlFrt);
		listData.add(listBlRmk);
		listData.add(listBlCgo);
		listData.add(listBlPck);
		listData.add(listBlMkNo);
		listData.add(listBlNtfy);
		listData.add(listBlRout);

		String vvd = listBlRoot.get(0).get("VVD");
		String todate = DateTime.getFormatString("yyyyMMddHHmmss");
		String yearMonth = DateTime.getFormatString("yyyyMM");
		
		String fileDir = SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.STRING") + "SITPRO/" + yearMonth + "/";
		File dir = new File(fileDir);
		if (!dir.isDirectory())
			dir.mkdirs();

		String[] fileName = new String[9];
		fileName[0] = vvd + todate + "_ROOT.xlsx";
		fileName[1] = vvd + todate + "_CNTR.xlsx";
		fileName[2] = vvd + todate + "_FRT.xlsx";
		fileName[3] = vvd + todate + "_RMK.xlsx";
		fileName[4] = vvd + todate + "_CGO.xlsx";
		fileName[5] = vvd + todate + "_PCK.xlsx";
		fileName[6] = vvd + todate + "_CM.xlsx";
		fileName[7] = vvd + todate + "_CUST.xlsx";
		fileName[8] = vvd + todate + "_ROUT.xlsx";

		for (int fileIdx = 0; fileIdx < 9; fileIdx++) {

			XSSFWorkbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("sheet1");
			
			CellStyle headerStyle = wb.createCellStyle();
			headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			headerStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
			headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			Font font = wb.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			headerStyle.setFont(font);

			for (int dataRow = -1; dataRow < listData.get(fileIdx).size(); dataRow++) {
				// Header가 있으니깐 1줄 더
				Row row = sheet.createRow(dataRow + 1);

				for (int dataCell = 0; dataCell < listTitle.get(fileIdx).length; dataCell++) {
					Cell cell = row.createCell(dataCell);
					// Header
					if (dataRow == -1) {
						cell.setCellValue(listTitle.get(fileIdx)[dataCell]);
						cell.setCellStyle(headerStyle);
					} else {
						cell.setCellValue(listData.get(fileIdx).get(dataRow).get(listTitle.get(fileIdx)[dataCell]));
					}
				}
			}
			
			FileOutputStream fileOut = new FileOutputStream(fileDir + fileName[fileIdx]);
			wb.write(fileOut);
			fileOut.close();

			// FTP 전송
			this.sendFtp(hostName, userName, password, fileDir + fileName[fileIdx]);
		}
	}

	/**
	 * FTP Send
	 * 
	 * @param hostName
	 * @param userName
	 * @param pwd
	 * @param filePath
	 */
	private void sendFtp(String hostName, String userName, String pwd, String filePath) throws Exception {
		FtpManager ftpManager = BeanContainer.getBean("com.clt.net.ftp.FtpManager");
		ftpManager.setHostName(hostName);
		ftpManager.setFtpUserName(userName);
		ftpManager.setFtpPassword(pwd);
		ftpManager.setUserId("BATCH");
		ftpManager.setFileAbsolutePath(filePath);
		ftpManager.setEncodingUtf8();
		ftpManager.setFileTypeBinary();
		ftpManager.send();
	}
}