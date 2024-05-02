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
* ------------------------------------------------------
* History
* 1. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
*    1) EU CTA FlatFile에  BLPOL_NODE, BLPOD_NODE, EU_ENTRY_OFC, MRN, D_MRN_ITEM 항목 추가
*    2) SITPRO FlatFile에 ONBOARD, IND_AGREE, VALUE_AGREE, EU_MRN_SEQ, EU_MRN_VALUE, EU_PORT, NOD_DEMURRAGE_FREETIME, VVDTYPE, LANE_CD 항목 추가
* 2011.01.27 이일민 [CHM-201108294] 구주 EU24 관련 SITPRO 수정 요청 (ENS Download 버튼 추가)
* 2011.08.23 김보배 [CHM-201112952] [EUR Inbound Manifest] Flat File 보완 - 세부 고객정보 추가 (ENS구조참조)
* 2011.10.28 김보배 [CHM-201114181] [BKG] [EUR customs manifest] 쿼리속도 개선
* 2011.11.15 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
* 2011.12.28 김경섭 [ ] [ESM-BKG] SitPro & Firm Booking : ESM_BKG_0484 화면   Flat File 생성시 SHPRTXID,CNEETXID,NTFYTXID,PL_IND 필드 추가
* 2012.04.03 김보배 [CHM-201217042] [BKG] [EUR Customs EDI화면] EXS MRN / Export MRN 추가 - U/I 및 Flat file 업데이트
* 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
* 2013.07.22 김보배 [CHM-201325890] SITPRO 상 cargo sequence 데이터 수정 요청
* 2013.12.16 김보배 [CHM-201327974] Sitpro 항목 추가
* 2015.03.25 이한나 [CHM-201534617] Europe Customs EDI - IMP - BK_IND tag on container level
* 2015.12.03 [CHM-201539183] Add SOC indicator to IFTMCS Flat File - LEH Customs - CELTIC
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Level;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrBlLocInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrCntrRfAkBrCgoInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrMndDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoTTLVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrVslCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration.EurCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurBkgNoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurBkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCmVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurEtaInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifesDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCmDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCmInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCntrRfAkBrCgoInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCntrSealListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCommodityVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProELNumberInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProENSDownExcelVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProEuMrnInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProMsnInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProRateAmountTTLVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProRateAmountVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProVslEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitproEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurBlRouteCntListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCustListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgDtlVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgVO;
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
 * @author Kyoung Jong Yun
 * @see EurCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EurCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

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
	@SuppressWarnings({ "unchecked", "unused" })
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		
		EurManifestTransmitVO[] eurManifestTransmitVOs = (EurManifestTransmitVO[])manifestTransmitVOs;
		EurManifestTransmitVO eurManifestTransmitVO = null;
		
		StringBuffer flatFile = new StringBuffer();
		StringBuffer sbCom1 = new StringBuffer();
		StringBuffer sbCom2 = new StringBuffer();
		StringBuffer sbCom3 = new StringBuffer();
		
		String header = "";
		EurBkgVvdInfoVO eurBkgVvdInfoVO = null;
//		List<EurBkgNoListVO> retBkgNoList = null;
		int retBkgNoListMaxLength = 0;
		String bkgNo = "";
		
		BrBlLocInfoVO brBlLocInfoVO = null;
		
		List<BrRateInfoVO> brRateInfoVOList = null;
		BrRateInfoVO brRateInfoVO = null;
		
		List<BrRateInfoTTLVO> brRateInfoTTLVOList = null;
		BrRateInfoTTLVO brRateInfoTTLVO = null;
		
		BrMndDescInfoVO brMndDescInfoVO = null;
		
		List<BrCntrRfAkBrCgoInfoVO> brCntrRfAkBrCgoInfoVOList = null;
		BrCntrRfAkBrCgoInfoVO brCntrRfAkBrCgoInfoVO = null;
		
		BrDgInfoVO brDgInfoVO = null;
		List<BrDgInfoVO>  brDgInfoVOList= null;
		
		EurCmVO eurCmVO = null;
		List<EurCmVO> eurCmVOList = null;
		
		BkgQtyVO bkgQtyVO = null;
		List<BkgQtyVO> bkgQtyVOList = null;
		
		List<EurEtaInfoVO> eurEtaInfoVOList = null;
		EurEtaInfoVO eurEtaInfoVO = null;
		int eurEtaInfoVOListSize = 0;
		int brCntrRfAkBrCgoInfoVOListSize = 0 ;
		int brDgInfoVOListSize = 0;
		int eurCmVOListSize = 0;
		int bkgQtyVOListSize = 0;
		int brRateInfoVOListSize = 0;
		int brRateInfoTTLVOListSize = 0;
		int str1MaxLen = 0;
		int str2MaxLen = 0;
		
		String msgAckRefNo = "";  // Add. 2015.03.02.
		
		BookingUtil command = null;
		
//		final int div = 100;
//		int processCnt = 0;
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		FlatFileAckVO flatFileAckVO = null;
		
		List<EurBlRouteCntListVO> eurBlRouteCntListVOs = null;
		
//		ArrayList ffList = new ArrayList();
		
		/**
		 * 2011.08.23 김보배 [CHM-201112952] [EUR Inbound Manifest] Flat File 보완 - 세부 고객정보 추가 (ENS구조참조)
		 * 구주 24시 BL 고객 정보 조회
		 */
		List<Eur24BlCustListVO> eur24BlCustListVOs = null;
		Eur24BlCustListVO custVO      = null;
		String tmpVvd = "";
		
		try {
			command = new BookingUtil();

			if(eurManifestTransmitVOs != null) {
				retBkgNoListMaxLength = eurManifestTransmitVOs.length;
				for(int i = 0; i < retBkgNoListMaxLength; i ++) {
					eurManifestTransmitVO = eurManifestTransmitVOs[i];
					bkgNo = eurManifestTransmitVO.getBkgNo();
					
					if(i == 0) {
						
						String snd_tp = "";
						String snd_id = "";
						tmpVvd = eurManifestTransmitVO.getVvdCd();
						// Flat File 생성 로직
						// FlatFile Header를 생성한다.
						if(eurManifestTransmitVO.getReceiverId().equals("IEREVENUE")){
							if(eurManifestTransmitVO.getPOriAmdCd().equals("O")){
								snd_tp = "IERDAT";								
							}else if (eurManifestTransmitVO.getPOriAmdCd().equals("U")){
								snd_tp = "IERAMD";								
								// Add: 2015.03.02. IE Manifest (Amend , Cancel)
								msgAckRefNo = dbDao.searchRcvAck(eurManifestTransmitVO);
								eurManifestTransmitVO.setMsgAckRefNo(msgAckRefNo);
							}else if (eurManifestTransmitVO.getPOriAmdCd().equals("C")){
								snd_tp = "IERCAN";	
								// Add: 2015.03.02. IE Manifest (Amend , Cancel)
								msgAckRefNo = dbDao.searchRcvAck(eurManifestTransmitVO);
								eurManifestTransmitVO.setMsgAckRefNo(msgAckRefNo);
							}
							snd_id = "SMLINE";
						}else{
							snd_tp = "IFTMCS";
							snd_id = "NISBKG";
						}
		
						header = command.searchCstmsEdiHeader(snd_id, eurManifestTransmitVO.getReceiverId(), snd_tp);
	
						// VSL/VVD정보 가져오기
						eurBkgVvdInfoVO = dbDao.searchBkgVvdByVvd(eurManifestTransmitVO);
						
						// FlatFile Header를 셋팅
						sbCom1.append(header).append("\n");
						
						// VSL/VVD정보 셋팅
						sbCom1.append("VVD:")				.append(eurBkgVvdInfoVO.getVvd()).append("\n");
						
						// Add : FR Commercial EDI
						sbCom1.append("USER_AP_REF:")		.append(eurManifestTransmitVO.getApRef()).append("\n");
						
						sbCom1.append("UPDATE_IND:")		.append(eurManifestTransmitVO.getPOriAmdCd()).append("\n");
						
						// Add : 2015.03.02. IE Manifest
						sbCom2.append("USER_REF:")			.append("\n"); // 2015.03.02 항목만 만들어달라는 요청(UAX 요청)
						sbCom2.append("OLD_USER_REF:")		.append("\n"); // 2015.03.02 항목만 만들어달라는 요청(UAX 요청)
						sbCom2.append("CUSTOMS_REF:")		.append(eurManifestTransmitVO.getMsgAckRefNo()).append("\n");
						
						sbCom2.append("VSL_CALLSIGN:")		.append(eurBkgVvdInfoVO.getVslCallsign()).append("\n");
						sbCom2.append("VSL_LLOYDCODE:")		.append(eurBkgVvdInfoVO.getVslLloydcode()).append("\n");
						sbCom2.append("VSL_FULLNAME:")		.append(eurBkgVvdInfoVO.getVslFullname()).append("\n");
						sbCom2.append("ETA:")				.append(eurBkgVvdInfoVO.getEta()).append("\n");
						sbCom2.append("ETD:")				.append(eurBkgVvdInfoVO.getEtd()).append("\n");					
	
						sbCom3.append("UVI:")				.append(eurManifestTransmitVO.getUvi()).append("\n");
						sbCom3.append("VSL_FLAG:")			.append(eurBkgVvdInfoVO.getVslFlag()).append("\n");
					}
					
					
					if ( eurBkgVvdInfoVO != null) {
						
						// 3. BL 일반 정보 및 location 정보를 조회한다.
						eurManifestTransmitVO.setVvdCd(tmpVvd);
						brBlLocInfoVO = (BrBlLocInfoVO) dbDao.searchBlCustomerInfo(eurManifestTransmitVO);
						
						if(brBlLocInfoVO != null) {
							
							// VSL/VVD정보 셋팅
							flatFile.append(sbCom1);
							flatFile.append("TRANSIT_IND:")			.append(brBlLocInfoVO.getTransitInd()).append("\n");
							flatFile.append(sbCom2);
							flatFile.append("POFE_ETA:")			.append(brBlLocInfoVO.getPofeEta()).append("\n");
							flatFile.append(sbCom3);
							
							flatFile.append("BLNBR:")			.append(brBlLocInfoVO.getBlnbr()).append("\n");
							flatFile.append("PARTLOAD:")		.append(brBlLocInfoVO.getPartLoad()).append("\n");
							flatFile.append("BLPOL:")           .append(brBlLocInfoVO.getBlpol()).append("\n");
							flatFile.append("BLPOD:")           .append(brBlLocInfoVO.getBlpod()).append("\n");
							flatFile.append("BLPOR:")           .append(brBlLocInfoVO.getBlpor()).append("\n");
							flatFile.append("BLDEL:")           .append(brBlLocInfoVO.getBldel()).append("\n");
							flatFile.append("BLRLY:")           .append(brBlLocInfoVO.getBlrly()).append("\n");
							
							flatFile.append("BLPOL_NODE:")      .append(brBlLocInfoVO.getBlpolNode()).append("\n");
							flatFile.append("BLPOD_NODE:")      .append(brBlLocInfoVO.getBlpodNode()).append("\n");
							
							flatFile.append("BLPLACE:")         .append(brBlLocInfoVO.getBlplace()).append("\n");
							flatFile.append("BLDATE:")          .append(brBlLocInfoVO.getBldate()).append("\n");

							/**
							 * 2011.08.23 김보배 [CHM-201112952] [EUR Inbound Manifest] Flat File 보완 - 세부 고객정보 추가 (ENS구조참조)
							 * 구주 24시 BL 고객 정보 조회 
							 */
//							tmpVvd = eurBkgVvdInfoVO.getVvd();
							eur24BlCustListVOs = dbDao.searchBlCust(bkgNo
																		, tmpVvd.substring(0, 4)
																		, tmpVvd.substring(4, 8)
																		, tmpVvd.substring(8, 9)
																		, eurBkgVvdInfoVO.getPofe());
							
							int eur24BlCustListVOsSize = eur24BlCustListVOs.size();	
							if(eur24BlCustListVOs != null && eur24BlCustListVOsSize > 0) {
								for (int j = 0; j < eur24BlCustListVOsSize; j++) {
									custVO = eur24BlCustListVOs.get(j);
									
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
									flatFile.append("}BL_PARTY_INFO").append("\n");
								}//end for eur24BlCustListVOs
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
								flatFile.append("}BL_PARTY_INFO").append("\n");
							}
							
							
							flatFile.append("SHPR1:")           .append(brBlLocInfoVO.getShpr1()).append("\n");
							flatFile.append("SHPR2:")           .append(brBlLocInfoVO.getShpr2()).append("\n");
							flatFile.append("SHPR3:")           .append(brBlLocInfoVO.getShpr3()).append("\n");
							flatFile.append("SHPR4:")           .append(brBlLocInfoVO.getShpr4()).append("\n");
							flatFile.append("SHPR5:")           .append(brBlLocInfoVO.getShpr5()).append("\n");
							flatFile.append("CNEE1:")           .append(brBlLocInfoVO.getCnee1()).append("\n");
							flatFile.append("CNEE2:")           .append(brBlLocInfoVO.getCnee2()).append("\n");
							flatFile.append("CNEE3:")           .append(brBlLocInfoVO.getCnee3()).append("\n");
							flatFile.append("CNEE4:")           .append(brBlLocInfoVO.getCnee4()).append("\n");
							flatFile.append("CNEE5:")           .append(brBlLocInfoVO.getCnee5()).append("\n");
							flatFile.append("NTFY1:")           .append(brBlLocInfoVO.getNtfy1()).append("\n");
							flatFile.append("NTFY2:")           .append(brBlLocInfoVO.getNtfy2()).append("\n");
							flatFile.append("NTFY3:")           .append(brBlLocInfoVO.getNtfy3()).append("\n");
							flatFile.append("NTFY4:")           .append(brBlLocInfoVO.getNtfy4()).append("\n");
							flatFile.append("NTFY5:")           .append(brBlLocInfoVO.getNtfy5()).append("\n");
							flatFile.append("NTFY21:")          .append(brBlLocInfoVO.getNtfy21()).append("\n");
							flatFile.append("NTFY22:")          .append(brBlLocInfoVO.getNtfy22()).append("\n");
							flatFile.append("NTFY23:")          .append(brBlLocInfoVO.getNtfy23()).append("\n");
							flatFile.append("NTFY24:")          .append(brBlLocInfoVO.getNtfy24()).append("\n");
							flatFile.append("NTFY25:")          .append(brBlLocInfoVO.getNtfy25()).append("\n");
							flatFile.append("FFWD1:")           .append(brBlLocInfoVO.getFfwd1()).append("\n");
							flatFile.append("FFWD2:")           .append(brBlLocInfoVO.getFfwd2()).append("\n"); 
							flatFile.append("FFWD3:")           .append(brBlLocInfoVO.getFfwd3()).append("\n"); 
							flatFile.append("FFWD4:")           .append(brBlLocInfoVO.getFfwd4()).append("\n"); 
							flatFile.append("FFWD5:")           .append(brBlLocInfoVO.getFfwd5()).append("\n"); 
							flatFile.append("EXPO1:")           .append(brBlLocInfoVO.getExpo1()).append("\n");
							flatFile.append("EXPO2:")           .append(brBlLocInfoVO.getExpo2()).append("\n");
							flatFile.append("EXPO3:")           .append(brBlLocInfoVO.getExpo3()).append("\n");
							flatFile.append("EXPO4:")           .append(brBlLocInfoVO.getExpo4()).append("\n");
							flatFile.append("EXPO5:")           .append(brBlLocInfoVO.getExpo5()).append("\n");
							flatFile.append("BLCOPY:")          .append(brBlLocInfoVO.getBlcopy()).append("\n");
							flatFile.append("BLORG:")           .append("1").append("\n");
							flatFile.append("BLPKG:")           .append(brBlLocInfoVO.getBlpkg()).append("\n");
							flatFile.append("BLPKGU:")          .append(brBlLocInfoVO.getBlpkgu()).append("\n");
							flatFile.append("BLWGT:")           .append(brBlLocInfoVO.getBlwgt()).append("\n");
							flatFile.append("BLMEA:")           .append(brBlLocInfoVO.getBlmea()).append("\n");
							flatFile.append("RDTYPE:")          .append(brBlLocInfoVO.getRdtype()).append("\n");
							flatFile.append("CARGOTYPE:")       .append(brBlLocInfoVO.getCargotype()).append("\n");
							flatFile.append("COMMODITY:")       .append(brBlLocInfoVO.getCommodity()).append("\n");
							flatFile.append("REMARK:")          .append(brBlLocInfoVO.getRemark()).append("\n");
							
							flatFile.append("AUS_QUAR:")        .append("").append("\n");
															
							flatFile.append("EU_ENTRY_OFC:")    .append(brBlLocInfoVO.getEuEntryOfc()).append("\n");
							flatFile.append("EU_POD_OFC:")      .append(brBlLocInfoVO.getEuPodOfc()).append("\n");
							
						}
						
						// 4. Rate 정보를 조회한다.
						brRateInfoVOList = dbDao.searchRateAmount(eurManifestTransmitVO);
						
						if(brRateInfoVOList != null) {
							
							brRateInfoVOListSize = brRateInfoVOList.size();
							for(int idx=0; idx<brRateInfoVOListSize; idx++) {
								brRateInfoVO = brRateInfoVOList.get(idx);
								
								flatFile.append("{CHARGE")					.append("\n");
									flatFile.append("FCTYPE:")          	.append(brRateInfoVO.getFctype()).append("\n");
									flatFile.append("RATE:")            	.append(brRateInfoVO.getRate()).append("\n");
									flatFile.append("REVENUETON:")          .append(brRateInfoVO.getRevenueton()).append("\n");
									flatFile.append("PPD:")             	.append(brRateInfoVO.getPpd()).append("\n");
									flatFile.append("CCT:")          		.append(brRateInfoVO.getCct()).append("\n");
									flatFile.append("CURRENCYCODE:")        .append(brRateInfoVO.getCurrencycode()).append("\n");
									flatFile.append("TARIFF:")       		.append(brRateInfoVO.getTariff()).append("\n");
									flatFile.append("PERTYPE:")       		.append(brRateInfoVO.getPertype()).append("\n");
								flatFile.append("}CHARGE")					.append("\n");
								
							} // end for(idx)
							
						}
						
						
						// 5. Rate TOTAL 정보를 조회한다.
						brRateInfoTTLVOList = dbDao.searchRateAmountTTL(eurManifestTransmitVO);
						
						if(brRateInfoTTLVOList != null) {
							
							brRateInfoTTLVOListSize = brRateInfoTTLVOList.size();
							for(int idx=0; idx<brRateInfoTTLVOListSize; idx++) {
								brRateInfoTTLVO = brRateInfoTTLVOList.get(idx);
								
								flatFile.append("{CHARGE_TTL")				.append("\n");
									flatFile.append("PPD_TOTAL:")          	.append(brRateInfoTTLVO.getPpdTotal()).append("\n");
									flatFile.append("CCT_TOTAL:")           .append(brRateInfoTTLVO.getCctTotal()).append("\n");
									flatFile.append("TOTAL_CUR:")           .append(brRateInfoTTLVO.getTotalCur()).append("\n");
								flatFile.append("}CHARGE_TTL")				.append("\n");
								
							} // end for(idx)
							
						}
						
						// 6. BKG의 Mark/Desc 정보를 조회한다.
						brMndDescInfoVO = dbDao.searchMarkDescInfo(eurManifestTransmitVO);

						if(brMndDescInfoVO != null) {
							String cmdtDesc = brMndDescInfoVO.getCmdtDesc();
							String[] str1 = cmdtDesc.split("\n");
							String mkMark = brMndDescInfoVO.getMkMark();
							String[] str2 = mkMark.split("\n");
							
							str1MaxLen = str1.length;
							str2MaxLen = str2.length;
							flatFile.append("{DESC")				.append("\n");
							for(int idx=0; idx < str1MaxLen; idx++) {
								flatFile.append("DESC:")          	.append(str1[idx]).append("\n");
							}
							flatFile.append("}DESC")				.append("\n");

							flatFile.append("{MARK")				.append("\n");
							for(int idx=0; idx < str2MaxLen; idx++) {
									flatFile.append("MARKNO:")       .append(str2[idx]).append("\n");
							}
							flatFile.append("}MARK")				.append("\n");
							
						}
												
						//bl Route 정보
						eurBlRouteCntListVOs = dbDao.searchBlRouteCountry(brBlLocInfoVO.getBlnbr().substring(0, 12));
						
						for (int j = 0; j < eurBlRouteCntListVOs.size(); j++) {
							flatFile.append("{ROUTE_COUNTRY").append("\n");
							flatFile.append("COUNTRY:").append(eurBlRouteCntListVOs.get(j).getRouteCnt()).append("\n");
							flatFile.append("}ROUTE_COUNTRY").append("\n");						
						}//end for eurBlRouteCntListVOs
						
						
						//7. Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.
						eurManifestTransmitVO.setBkgCgoTp(brBlLocInfoVO.getInBkgCgoTpCd());
						/* [CHM-201534617]Europe Customs EDI - IMP - BK_IND tag on container level, 2015.03.25
						eurManifestTransmitVO.setBkgSpeRf(brBlLocInfoVO.getInRcFlg());
						eurManifestTransmitVO.setBkgSpeDg(brBlLocInfoVO.getInDcgoFlg());
						eurManifestTransmitVO.setBkgSpeAk(brBlLocInfoVO.getInAwkCgoFlg());
						eurManifestTransmitVO.setBkgSpeBb(brBlLocInfoVO.getInBbCgoFlg());
						*/
						eurManifestTransmitVO.setCmdtDesc(brBlLocInfoVO.getInCmdtDesc());
						eurManifestTransmitVO.setCmdtCd(brBlLocInfoVO.getInCmdtCd());
						brCntrRfAkBrCgoInfoVOList = dbDao.searchCntrRfAkBrCgo(eurManifestTransmitVO);
						
						if(brCntrRfAkBrCgoInfoVOList != null) {
							brCntrRfAkBrCgoInfoVOListSize = brCntrRfAkBrCgoInfoVOList.size();
							for(int cntrIdx=0; cntrIdx < brCntrRfAkBrCgoInfoVOListSize; cntrIdx++) {
								brCntrRfAkBrCgoInfoVO = brCntrRfAkBrCgoInfoVOList.get(cntrIdx);
								
								eurManifestTransmitVO.setCntrCd(brCntrRfAkBrCgoInfoVO.getCntrnbr());
								
								flatFile.append("{CNTR_INFO")				.append("\n");
								
									flatFile.append("CNTRNBR:")				.append(brCntrRfAkBrCgoInfoVO.getCntrnbr()).append("\n");							
									flatFile.append("PUNIT:")               .append(brCntrRfAkBrCgoInfoVO.getPunit()).append("\n");
									flatFile.append("PKG:")                 .append(brCntrRfAkBrCgoInfoVO.getPkg()).append("\n");
									flatFile.append("CNTRWGT:")             .append(brCntrRfAkBrCgoInfoVO.getCntrwgt()).append("\n");
									flatFile.append("CNTRTYPE:")            .append(brCntrRfAkBrCgoInfoVO.getCntrtype()).append("\n");
									flatFile.append("SEALNBR:")             .append(brCntrRfAkBrCgoInfoVO.getSealnbr()).append("\n");
									flatFile.append("FM_IND:")              .append(brCntrRfAkBrCgoInfoVO.getFmInd()).append("\n");
									flatFile.append("RF_IND:")              .append(brCntrRfAkBrCgoInfoVO.getRfInd()).append("\n");
									flatFile.append("DG_IND:")              .append(brCntrRfAkBrCgoInfoVO.getDgInd()).append("\n");
									flatFile.append("AK_IND:")              .append(brCntrRfAkBrCgoInfoVO.getAkInd()).append("\n");
									flatFile.append("BK_IND:")              .append(brCntrRfAkBrCgoInfoVO.getBkInd()).append("\n");
									flatFile.append("TEMP:")                .append(brCntrRfAkBrCgoInfoVO.getTemp()).append("\n");
									flatFile.append("TUNIT:")               .append(brCntrRfAkBrCgoInfoVO.getTunit()).append("\n");
									flatFile.append("VENT:")                .append(brCntrRfAkBrCgoInfoVO.getVent()).append("\n");
									flatFile.append("MEASURE:")             .append(brCntrRfAkBrCgoInfoVO.getMeasure()).append("\n");
									flatFile.append("RDTYPE:")              .append(brCntrRfAkBrCgoInfoVO.getRdtype()).append("\n");
									flatFile.append("CMDT_DESC:")           .append(brCntrRfAkBrCgoInfoVO.getCmdtDesc()).append("\n");
									flatFile.append("CMDTCD:")              .append(brCntrRfAkBrCgoInfoVO.getCmdtCd()).append("\n");
									flatFile.append("RF_REMARK:")           .append(brCntrRfAkBrCgoInfoVO.getRfRemark()).append("\n");
									flatFile.append("RFDRY_IND:")           .append(brCntrRfAkBrCgoInfoVO.getRfdryInd()).append("\n");
									flatFile.append("OVF:")                 .append(brCntrRfAkBrCgoInfoVO.getOvf()).append("\n");
									flatFile.append("OVR:")                 .append(brCntrRfAkBrCgoInfoVO.getOvr()).append("\n");
									flatFile.append("OVH:")                 .append(brCntrRfAkBrCgoInfoVO.getOvh()).append("\n");
									flatFile.append("OVLW:")                .append(brCntrRfAkBrCgoInfoVO.getOvlw()).append("\n");
									flatFile.append("OVRW:")                .append(brCntrRfAkBrCgoInfoVO.getOvrw()).append("\n");
									flatFile.append("OVWGT:")               .append(brCntrRfAkBrCgoInfoVO.getOvwgt()).append("\n");
									flatFile.append("VOID_SLOT:")           .append(brCntrRfAkBrCgoInfoVO.getVoidSlot()).append("\n");
									flatFile.append("STWG_REQ:")            .append(brCntrRfAkBrCgoInfoVO.getStwgReq()).append("\n");
									
									flatFile.append("MRN:")                 .append(brCntrRfAkBrCgoInfoVO.getMvmtRefNo()).append("\n");
									flatFile.append("EXS_MRN:")             .append(brCntrRfAkBrCgoInfoVO.getExsMrn()).append("\n");
									flatFile.append("EXPORT_MRN:")          .append(brCntrRfAkBrCgoInfoVO.getExportMrn()).append("\n");
									// Add. 2015.12.03 CHM-201539183
									flatFile.append("SOC_IND:")          	.append(brCntrRfAkBrCgoInfoVO.getSocind()).append("\n");
									
									
									//9. 위험물 정보를 조회한다.
									brDgInfoVOList = dbDao.searchDangerCgo(eurManifestTransmitVO);
									brDgInfoVOListSize = brDgInfoVOList.size();
									if(brDgInfoVOList != null) {
										for(int dgIdx=0; dgIdx<brDgInfoVOListSize; dgIdx++) {
											brDgInfoVO = brDgInfoVOList.get(dgIdx);

											flatFile.append("{CNTR_DANGER")				.append("\n");
												flatFile.append("UNNBR:")			.append(brDgInfoVO.getUnnbr()).append("\n");
												flatFile.append("CLASS:")           .append(brDgInfoVO.getClass1()).append("\n");
												flatFile.append("DESC:")            .append(brDgInfoVO.getDgDesc()).append("\n");
												flatFile.append("PHONE:")           .append(brDgInfoVO.getPhone()).append("\n");
												flatFile.append("PAGE:")            .append(brDgInfoVO.getPage()).append("\n");
												flatFile.append("FLSH_TEMP:")	    .append(brDgInfoVO.getFlshTemp()).append("\n");
												flatFile.append("FLSH_UNIT:")	    .append(brDgInfoVO.getFlshUnit()).append("\n");
												flatFile.append("DG_REMARK:")	    .append(brDgInfoVO.getDgRemark()).append("\n");
											flatFile.append("}CNTR_DANGER")				.append("\n");

											
										}
									}
									
									// 10. CNTR Desc 정보를 조회한다.
									eurCmVOList = dbDao.searchCM(eurManifestTransmitVO);
									if(eurCmVOList != null) {
										eurCmVOListSize = eurCmVOList.size();
										for(int cmIdx=0; cmIdx<eurCmVOListSize; cmIdx++) {
											eurCmVO = eurCmVOList.get(cmIdx);

											flatFile.append("{CNTR_DESC")				.append("\n");
												flatFile.append("D_CMDT:")             	.append(eurCmVO.getDCmdt()).append("\n");
												flatFile.append("D_PUNIT:")             .append(eurCmVO.getDPunit()).append("\n");
												flatFile.append("D_PKG:")             	.append(eurCmVO.getDPkg()).append("\n");
												flatFile.append("D_WGT:")             	.append(eurCmVO.getDWgt()).append("\n");
												flatFile.append("D_MEAS:")             	.append(eurCmVO.getDMeas()).append("\n");
												flatFile.append("D_DESC:")             	.append(eurCmVO.getDDesc()).append("\n");
												flatFile.append("D_MRN_ITEM:")         	.append(eurCmVO.getMfItmNo()).append("\n");
												flatFile.append("D_HTS_CD:")            .append(eurCmVO.getDHtsCd()).append("\n");
												flatFile.append("D_HS_CD:")             .append(eurCmVO.getDHsCd()).append("\n");
												flatFile.append("D_NCM_CD:")            .append(eurCmVO.getDNcmCd()).append("\n");
												
												String dMark = eurCmVO.getDMark();
												if(!"".equalsIgnoreCase(dMark)) {
													flatFile.append("{CUS_MARK")				.append("\n");
														flatFile.append( dMark.equals("") ? "D_MARK:" : dMark).append("\n");
													flatFile.append("}CUS_MARK")				.append("\n");
												}
												
											flatFile.append("}CNTR_DESC")				.append("\n");
										}
									}
									
									
								flatFile.append("}CNTR_INFO")				.append("\n");
								
							} // end for(cntrIdx)
							
							// 11. BKG Qty를 조회한다.
							bkgQtyVOList = dbDao.searchBkgQty(eurManifestTransmitVO);
							if(bkgQtyVOList != null) {
								bkgQtyVOListSize = bkgQtyVOList.size();
								
								for(int idx = 0; idx < bkgQtyVOListSize; idx++) {
									bkgQtyVO = bkgQtyVOList.get(idx);

									flatFile.append("{QTY")				.append("\n");
										flatFile.append("HANTYPE:")     	.append(bkgQtyVO.getHantype()).append("\n");
										flatFile.append("COUNT:")       	.append(bkgQtyVO.getCount()).append("\n");
									flatFile.append("}QTY")				.append("\n");
								}
								
							}
							
							//12. Vessel 정보, Vessel ETA 정보를 조회한다.
							eurEtaInfoVOList = dbDao.searchVslInfoVsl(eurManifestTransmitVO);
							if(eurEtaInfoVOList != null) {
								eurEtaInfoVOListSize = eurEtaInfoVOList.size();
								for(int idx = 0; idx < eurEtaInfoVOListSize; idx++) {
									eurEtaInfoVO = eurEtaInfoVOList.get(idx);
									
									flatFile.append("{BKGVVD")				.append("\n");
										flatFile.append("BVVD:")				.append(eurEtaInfoVO.getBvvd()).append("\n");
										flatFile.append("BPOL:")            	.append(eurEtaInfoVO.getBpol()).append("\n");
										flatFile.append("BPOD:")            	.append(eurEtaInfoVO.getBpod()).append("\n");
									flatFile.append("}BKGVVD")				.append("\n");
								}
							}
						} // end if(checkBlNo)
					
					}

//					processCnt++;
//					
//					if(processCnt == div || i == retBkgNoListMaxLength-1) {
//
//						ffList.add(flatFile);
//						processCnt = 0;
//						flatFile = new StringBuffer();
//					}
					
					
				
				} // end for
				
				if(flatFile != null) {
					/*
					 * 전송
					 */
					sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_EURCUS.IBMMQ.QUEUE"));
					
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					
					if ( flatFileAckVO.getAckStsCd().equals("E") ) {
						throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage());
					}
					
				}
				
			}
			
//			int ffListSize = ffList.size();
//			StringBuffer sbFF = null;
//			for(int i=0; i<ffListSize; i++) {
//				sbFF = (StringBuffer) ffList.get(i);
//				
//				/*
//				 * 전송
//				 */
//				sendFlatFileVO = new SendFlatFileVO();
//				sendFlatFileVO.setFlatFile(sbFF.toString());
//				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_EURCUS.IBMMQ.QUEUE"));
//				
//				flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
//				
//				if ( flatFileAckVO.getAckStsCd().equals("E") ) {
//					throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage());
//				}
//			}
			
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		//2015.04.28 소스 보안으로 수정
		if(flatFile != null){
			return flatFile.toString();
		}else{
			return "";
		}
			
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
		String header = "";
		String receiverId = ""; 
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
						
						if(i == 0) { 
							
							sitproEdiVO.setVvdCd(eurManifestTransmitVOs[i].getVvdCd());
							sitproEdiVO.setOfcCd(eurManifestTransmitVOs[i].getOfcCd());
							sitproEdiVO.setPolCd(eurManifestTransmitVOs[i].getPolCd());
							sitproEdiVO.setPodCd(eurManifestTransmitVOs[i].getPodCd());
							sitproEdiVO.setBndCd(eurManifestTransmitVOs[i].getBndCd());
							receiverId = eurManifestTransmitVOs[i].getBkgOfcCd();
							sitproEdiVO.setCompId("");
							
							// send id 조회
							sendId = dbDao.searchEdiSendId(sitproEdiVO);
							
							if(sendId == null || sendId.equals("")) {
								sendId = "SMLINE";
							}
							
							// FlatFile Header를 생성한다.
							header = command.searchCstmsEdiHeader(sendId, receiverId, "SITPRO");
							

							// VSL/VVD정보 가져오기
							sitProVslInfoVO = dbDao.searchVslEtaEtd(sitproEdiVO);
							
							if ( sitProVslInfoVO != null) {
								log.debug("(((((((((((((((((((((((((((((((((((((((((((((((((");
								flatFileVvdInfo.append("VVD:")				.append(sitProVslInfoVO.getVvd()).append("\n");
								flatFileVvdInfo.append("VSL_CALLSIGN:")		.append(sitProVslInfoVO.getVslCallsign()).append("\n");
								flatFileVvdInfo.append("VSL_LLOYDCODE:")	.append(sitProVslInfoVO.getVslLloydcode()).append("\n");
								flatFileVvdInfo.append("VSL_FULLNAME:")		.append(sitProVslInfoVO.getVslFullname()).append("\n");
								flatFileVvdInfo.append("VSL_FLAG:")			.append(sitProVslInfoVO.getVslRgstCntCd()).append("\n");
								flatFileVvdInfo.append("PORT:")				.append(sitProVslInfoVO.getPort()).append("\n");
								flatFileVvdInfo.append("PORTNAME:")			.append(sitProVslInfoVO.getPortname()).append("\n");
								flatFileVvdInfo.append("ETA:")				.append(sitProVslInfoVO.getEta()).append("\n");
								flatFileVvdInfo.append("ETD:")				.append(sitProVslInfoVO.getEtd()).append("\n");
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
									flatFileVvdInfo.append("VSL_CALLSIGN:")		.append("").append("\n");
									flatFileVvdInfo.append("VSL_LLOYDCODE:")	.append("").append("\n");
									flatFileVvdInfo.append("VSL_FULLNAME:")		.append(sitProVslInfoVO.getVslFullname()).append("\n");
									flatFileVvdInfo.append("VSL_FLAG:")			.append(sitProVslInfoVO.getVslRgstCntCd()).append("\n");
									flatFileVvdInfo.append("PORT:")				.append(sitProVslInfoVO.getPort()).append("\n");
									flatFileVvdInfo.append("PORTNAME:")			.append(sitProVslInfoVO.getPortname()).append("\n");
									flatFileVvdInfo.append("ETA:")				.append("").append("\n");
									flatFileVvdInfo.append("ETD:")				.append("").append("\n");
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
							flatFile.append(header).append("\n");
							
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
						
						if(sitProBlInfoVO != null) {
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
							flatFile.append("BLDEL:")           .append(sitProBlInfoVO.getBldel()).append("\n");
							flatFile.append("DEL_AMS:")         .append(sitProBlInfoVO.getDelAms()).append("\n");
							flatFile.append("DEL_FULLNAME:")    .append(sitProBlInfoVO.getDelFullname()).append("\n");
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
							flatFile.append("BLORG:")           .append("1").append("\n");
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
							flatFile.append("PPDOFC:")          .append(sitProBlInfoVO.getPpdofc()).append("\n");
							flatFile.append("CCTOFC:")          .append(sitProBlInfoVO.getCctofc()).append("\n");
							flatFile.append("THDOFC:")          .append(sitProBlInfoVO.getThdofc()).append("\n");
							flatFile.append("SCNO:")            .append(sitProBlInfoVO.getScno()).append("\n");
							flatFile.append("RFANO:")           .append(sitProBlInfoVO.getRfano()).append("\n");
							flatFile.append("WAYBILL_IND:")     .append(sitProBlInfoVO.getWaybillInd()).append("\n");
							flatFile.append("CUSTREF_NUM:")     .append(sitProBlInfoVO.getCustrefNum()).append("\n");
							flatFile.append("FINAL_ETA:")       .append(sitProBlInfoVO.getFinalEta()).append("\n");
							flatFile.append("FUNC_CODE:")       .append(sitProBlInfoVO.getFuncCode()).append("\n");
							flatFile.append("ONBOARD:")         .append(sitProBlInfoVO.getOnboard()).append("\n");
							flatFile.append("INV_NO:")          .append(sitProBlInfoVO.getInvNo()).append("\n");
							
							
						}
						
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
						
						if(sitProBlInfoVO != null) { // 2015.04.28 소스 보안으로 수정	
							flatFile.append("IND_AGREE:")       .append(sitProBlInfoVO.getIndAgree()).append("\n");
							flatFile.append("VALUE_AGREE:")     .append(sitProBlInfoVO.getValueAgree()).append("\n");
						}
						
						
						
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
						
						if(sitProBlInfoVO != null){ //2015.04.28 소스 보안으로 수정
						// Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.
						sitproEdiVO.setBkgCgoTp(sitProBlInfoVO.getInBkgCgoTpCd());
						sitproEdiVO.setBkgSpeRf(sitProBlInfoVO.getInRcFlg());
						sitproEdiVO.setBkgSpeDg(sitProBlInfoVO.getInDcgoFlg());
						sitproEdiVO.setBkgSpeAk(sitProBlInfoVO.getInAwkCgoFlg());
						sitproEdiVO.setBkgSpeBb(sitProBlInfoVO.getInBbCgoFlg());
						sitproEdiVO.setBkgSpeRd(sitProBlInfoVO.getInRdCgoFlg());
						sitproEdiVO.setCmdtDesc(sitProBlInfoVO.getInCmdtDesc());
						sitproEdiVO.setCmdtCd(sitProBlInfoVO.getInCmdtCd());
						}
						sitProBlInfoVO = null;
						
						
						String cntrWgt = "";
						String cntrTrw = "";
						float cntrGWgt = 0;
						sitProCntrRfAkBrCgoInfoVOs= dbDao.searchCntrRfAkCgo(sitproEdiVO);	
						if(sitProCntrRfAkBrCgoInfoVOs != null) {
							
							for(int cntrIdx=0; cntrIdx < sitProCntrRfAkBrCgoInfoVOs.size(); cntrIdx++) {
								sitProCntrRfAkBrCgoInfoVO = sitProCntrRfAkBrCgoInfoVOs.get(cntrIdx);
								
								cntrWgt = sitProCntrRfAkBrCgoInfoVO.getCntrwgt();
								cntrTrw = sitProCntrRfAkBrCgoInfoVO.getCntrtrw();
								//cntrGWgt = Integer.parseInt(cntrWgt) + Integer.parseInt(cntrTrw) + "";
								
								// Gross Weight
								cntrGWgt = Float.parseFloat(("".equals(cntrWgt)) ? "0" : cntrWgt) + Float.parseFloat(("".equals(cntrTrw)) ? "0" : cntrTrw);
								
								
								flatFile.append("{CNTR_INFO")				.append("\n");

									flatFile.append("CNTRNBR:")			       .append(sitProCntrRfAkBrCgoInfoVO.getCntrnbr()).append("\n");							
									flatFile.append("PUNIT:")                  .append(sitProCntrRfAkBrCgoInfoVO.getPunit()).append("\n");
									flatFile.append("PKG:")                    .append(sitProCntrRfAkBrCgoInfoVO.getPkg()).append("\n");
									flatFile.append("CNTRWGT:")                .append(cntrWgt).append("\n");
									flatFile.append("CNTRGWGT:")               .append(cntrGWgt).append("\n");
									flatFile.append("CNTR_WGT_UNIT:")          .append(sitProCntrRfAkBrCgoInfoVO.getCntrWgtUnit()).append("\n");
									flatFile.append("CNTRTRW:")                .append(cntrTrw).append("\n");
									flatFile.append("CNTRTYPE:")               .append(sitProCntrRfAkBrCgoInfoVO.getCntrtype()).append("\n");
									flatFile.append("VGM_VRF_DATE:").append(sitProCntrRfAkBrCgoInfoVO.getVgmVrfyDt()).append("\n");
									flatFile.append("VGM_WGTQTY:").append(sitProCntrRfAkBrCgoInfoVO.getVgmWgt()).append("\n");
									flatFile.append("VGM_WGTCD:").append(sitProCntrRfAkBrCgoInfoVO.getVgmWgtUtCd()).append("\n");
									flatFile.append("VGM_METHOD:").append(sitProCntrRfAkBrCgoInfoVO.getVgmMzdTpCd()).append("\n");
									flatFile.append("VGM_SIGNATURE:").append(sitProCntrRfAkBrCgoInfoVO.getVgmVrfySigCtnt()).append("\n");
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
								int sitProVslEtcInfoVOsMaxSize = sitProVslEtcInfoVOs.size();
								for(int idx = 0; idx < sitProVslEtcInfoVOsMaxSize; idx++)  {
								
									sitProVslEtcInfoVO = sitProVslEtcInfoVOs.get(idx);
									flatFile.append("{BKGVVD")				.append("\n");
								
									
										flatFile.append("VVDTYPE:")				.append(sitProVslEtcInfoVO.getVvdtype()).append("\n");
										flatFile.append("LANE_CD:")				.append(sitProVslEtcInfoVO.getLaneCd()).append("\n");
									
										flatFile.append("BVVD1:")				.append(sitProVslEtcInfoVO.getBvvd1()).append("\n");
										flatFile.append("VSL_CALLSIGN1:")     	.append(sitProVslEtcInfoVO.getVslCallsign1()).append("\n");
										flatFile.append("VSL_LLOYDCODE1:")    	.append(sitProVslEtcInfoVO.getVslLloydcode1()).append("\n");
										flatFile.append("VSL_FULLNAME1:")    	.append(sitProVslEtcInfoVO.getVslFullname1()).append("\n");
										flatFile.append("VSL_FLAG1:")    		.append(sitProVslEtcInfoVO.getVslRgstCntCd1()).append("\n");
										flatFile.append("BLPOL1:")            	.append(sitProVslEtcInfoVO.getBlpol1()).append("\n");
										flatFile.append("POL_FULLNAME1:")     	.append(sitProVslEtcInfoVO.getPolFullname1()).append("\n");
										flatFile.append("BLPOD1:")            	.append(sitProVslEtcInfoVO.getBlpod1()).append("\n");
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
				
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_VENDOR.IBMMQ.QUEUE"));
			
			FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
			
			if ( flatFileAckVO.getAckStsCd().equals("E") ) {
				throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage());
			}
			
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
	@SuppressWarnings("unchecked")
	public void loadCstmsRcvMsg(String rcvMsg,String userId) throws EventException {
	
		log.info("<<<<<<<<<< loadCstmsRcvMsg Start >>>>>>>>>>>>>>>>");
		
		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");

		ArrayList tmpArray = new ArrayList();
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
		List<EurRcvMsgDtlVO> eurRcvMsgDtlVOs = new ArrayList();
		
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

					} else if(key.equalsIgnoreCase("ORG_MSG_KEY")) { // add. 2014.12.29 [CHM-201432728]
						//org_message
						eurRcvMsgVO.setOrgMsgKey(value);
						
						// vvd
						eurRcvMsgVO.setVvdCd(value.substring(0, 9));
						//port
						eurRcvMsgVO.setPortCd(value.substring(10, 15));
						// inbound , outbound flag
						eurRcvMsgVO.setIoBndCd(value.substring(16, 17));
						
												
					} else if(key.equalsIgnoreCase("ORG_MSG_TP")) {
						eurRcvMsgVO.setOrgMsgTp(value);
					} else if(key.equalsIgnoreCase("MSG_UDT_FLG")) {
						eurRcvMsgVO.setMsgUdtFlg(value);
					} else if(key.equalsIgnoreCase("ORG_MSG_NM")) {
						eurRcvMsgVO.setOrgMsgNm(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_TP")) {
						eurRcvMsgVO.setMsgAckTp(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_RSLT")) {
						eurRcvMsgVO.setMsgAckRslt(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_DT")) {
						eurRcvMsgVO.setMsgAckDt(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_CODE")) { // add. 2014.12.29 [CHM-201432728]
						eurRcvMsgVO.setMsgAckCd(value);
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
					} else if(key.equalsIgnoreCase("MSG_R_ERROR_CODE")) {
						eurRcvMsgDtlVO.setCstmsErrId(value);
					} else if(key.equalsIgnoreCase("MSG_R_ERROR_MSG")) {
						eurRcvMsgDtlVO.setCstmsErrMsg(value);
					} else if(key.equalsIgnoreCase("MSG_R_REF1")) {
						eurRcvMsgDtlVO.setCstmsErrRefNo1(value);
					} else if(key.equalsIgnoreCase("MSG_R_REF2")) {
						eurRcvMsgDtlVO.setCstmsErrRefNo2(value);
					} else if(key.equalsIgnoreCase("SEC_FILE_NBR")) {
						eurRcvMsgVO.setSecFileNbr(value);
					} else if(key.equalsIgnoreCase("MSG_ACCEPT_REF")) {
						eurRcvMsgVO.setMsgAcceptRef(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_REF")) { // Add. 2014.12.29
						eurRcvMsgVO.setMsgAckRefNo(value);
					}
					
				} // end for(i)
				
				rcvLogSeq = dbDao.searchRcvLogSeq("CTA", revKey); 	// rcv_log_seq

				// 수신마스터 저장
				eurRcvMsgVO.setRcvLogSeq(rcvLogSeq);
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
		String resultStr = "";
		
		if(pgmNo.equals("ESM_BKG_0484")) {	// Sitpro
			log.info("manifestTransmitVOs.length : " + manifestTransmitVOs.length);
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , usrId, "Sitpro Transmit");
		}
		
		return resultStr;
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
						if(value.length() > 12) {
							eurCrnRcvMsgDetailVO.setBlNo(value.substring(0, 12));
						} else {
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
	 * 2015.10.05 신영재 [CHM-201537996] [UI_BKG_0257_Europe Customs EDI TS 하는 경우 이전 VVD 의 MRN 가져오도록 수정
	 * EU 세관 전송을 위한 VVD 와 POD 별 B/L 내역 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchEurManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try{
			List<ManifestListDetailVO> manifestListDetailVOs = dbDao.searchEurManifestList(manifestListCondVO); // 2015 10월 이전 기존 로직  
		   //bl_no 와 ts_mrn_no 는 1:1 매칭이기 때문에, 각각 선언해서 for 문 안에서 parameter 로 사용.
			String blNo;  
			EurManifestListVO tsMrnInfo; 
			// frontend 에서 넘어온 parameter 중 공통으로 쓰이는 VVD, POD 추출을 위해 선언하고 받음 
			EurManifestListCondVO eurManifestListCondVO = (EurManifestListCondVO) manifestListCondVO;  
			String vvdCd = eurManifestListCondVO.getVvdCd();
			String podCd = eurManifestListCondVO.getPodCd();
			for (int i = 0 ; i<manifestListDetailVOs.size();i++){
				//VVD POD 로 검색된 리스트 중 MRN 번호가 없는 bl_no 를 찾음
				EurManifestListVO eurManifestListVO = (EurManifestListVO) manifestListDetailVOs.get(i);   
				if(eurManifestListVO.getMrn() == null || eurManifestListVO.getMrn().trim() == ""){
					blNo=eurManifestListVO.getBlNo();
					tsMrnInfo = dbDao.searchEurTsMrnNumber(blNo, vvdCd,podCd); // bl_no, vvd, pod 를 이용해서 이전에 신고한 MRN 이 있는지 조회 후 있는 경우 이 값을 VO 에 set, 이 vvd 를 이용하여 이전 vvd 정보를 찾음
					if (tsMrnInfo != null){    
				
						eurManifestListVO.setMrn(tsMrnInfo.getMrn());
						eurManifestListVO.setPofe(tsMrnInfo.getPofe());
						eurManifestListVO.setPofeEta(tsMrnInfo.getPofeEta());
					}
				}
			}
			return manifestListDetailVOs;
						
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	

	/**
	 * Europe Customs EDI Country Code 를 조회한다.
	 * 
	 * @param String cmCode
	 * @return String
	 * @throws EventException
	 */
	public String searchEurCustCntCode(String cmCode) throws EventException {

		try{
			return dbDao.searchEurCustCntCode(cmCode);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Europe Customs EDI 의 receiver 를 조회한다.
	 * 
	 * @param String cmCode
	 * @param String cntCd
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	public List<BkgComboVO> searchEurCustReceiver(String cmCode, String cntCd) throws EventException {

		try{
			return dbDao.searchEurCustReceiver(cmCode, cntCd);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	
			
}
