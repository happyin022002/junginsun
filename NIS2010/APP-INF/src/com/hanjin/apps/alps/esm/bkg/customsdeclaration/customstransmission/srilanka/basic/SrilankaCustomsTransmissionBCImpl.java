/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SrilankaCustomsTransmissionBCImpl.java
 *@FileTitle : SrilankaCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.10
 *@LastModifier : 임재택   
 *@LastVersion : 1.0
 * 2009.04.21 임재택
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration.SriLankaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.BkgCstmsSriRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaCargoInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchBlGeneralVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchEtaVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchEtdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchFlagVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchMakeHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchMakeHeaderVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchPrePortVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SrilankaSearchBlMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SrilankaSearchContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
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
public class SrilankaCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient SriLankaCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public SrilankaCustomsTransmissionBCImpl() {
		dbDao = new SriLankaCustomsTransmissionDBDAO();
	}

	/**
	 * Flat File 생성 처리<br>
	 * SriLanka 세관에 신고할 Vessel Arrival 데이터를 조회하여 FlatFile을 생성하고, Send Date를 저장한다. -- UI_BKG-0493
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
		SriLankaManifestTransmitVO sriLankaManifestTransmitVO = new SriLankaManifestTransmitVO();
		List<SriLankaSearchMakeHeaderVO> sriLankaSearchMakeHeaderVOs = null;
		List<SriLankaSearchPrePortVO> sriLankaSearchPrePortVOs = null;
		List<SriLankaSearchFlagVO> sriLankaSearchFlagVOs = null;
		List<SriLankaSearchEtaVO> sriLankaSearchEtaVOs = null;
		List<SriLankaSearchEtdVO> sriLankaSearchEtdVOs = null;
		List<SriLankaSearchBkgNoVO> sriLankaSearchBkgNoVOs = null;
		List<SriLankaSearchBlGeneralVO> sriLankaSearchBlGeneralVOs = null;
		List<SrilankaSearchContainerVO> srilankaSearchContainerVOs = null;
		List<SrilankaSearchBlMarkDescVO> srilankaSearchBlMarkDescVOs = null;
		String slpaRefNo = null;

		try {
			if (manifestTransmitVOs != null) {
				sriLankaManifestTransmitVO = (SriLankaManifestTransmitVO)manifestTransmitVOs[0];
				sriLankaSearchMakeHeaderVOs = dbDao.searchMakeHeader(sriLankaManifestTransmitVO.getEdiMtRemoval(), account.getOfc_cd(), "O");
				// 해더 부분 생성작업
				if (sriLankaSearchMakeHeaderVOs != null) {
					SriLankaSearchMakeHeaderVO sriLankaSearchMakeHeaderVO;
					for (int i = 0; i < sriLankaSearchMakeHeaderVOs.size(); i++) {
						sriLankaSearchMakeHeaderVO = sriLankaSearchMakeHeaderVOs.get(i);
						flatFile.append(sriLankaSearchMakeHeaderVO.getMsgHeader()).append("\n");
					}
				}

				for (int i=0; i<manifestTransmitVOs.length; i++) {
					sriLankaManifestTransmitVO = (SriLankaManifestTransmitVO)manifestTransmitVOs[i];
					
					if(sriLankaManifestTransmitVO != null){	
						
						if (i == 0){
							flatFile.append("VVD:").append(sriLankaManifestTransmitVO.getVvdNumber()).append("\n");
							//flatFile.append("VVD:").append(dbDao.searchVvdCstmsInfo(sriLankaManifestTransmitVO)).append("\n");
	
							flatFile.append("VSL_FULLNAME:").append(sriLankaManifestTransmitVO.getVslNm()).append("\n");
							flatFile.append("VSL_AUTH_NO:").append(sriLankaManifestTransmitVO.getAuthNo()).append("\n");
	
							sriLankaSearchFlagVOs = dbDao.searchFlag(sriLankaManifestTransmitVO);
							if (sriLankaSearchFlagVOs != null && sriLankaSearchFlagVOs.size() > 0) {
								flatFile.append("VSL_NTL_CD:").append(sriLankaSearchFlagVOs.get(0).getVslCntCd()).append("\n");
							}
							else {
								flatFile.append("VSL_NTL_CD:").append("\n");
							}
	
							slpaRefNo = dbDao.searchVvdCstmsInfo(sriLankaManifestTransmitVO,"O");
							if (slpaRefNo.length() > 0) {
								flatFile.append("SLPA_REF_NO:").append(slpaRefNo).append("\n");
							} else {
								flatFile.append("SLPA_REF_NO:").append("\n");
							}
	
							flatFile.append("TIN:").append(sriLankaManifestTransmitVO.getCarrierNo()).append("\n");
							flatFile.append("CUSTOMS_OFC:").append(sriLankaManifestTransmitVO.getCustomsOfficeCode()).append("\n");
							flatFile.append("DEL:").append(sriLankaManifestTransmitVO.getDelCd()).append("\n");
	
							sriLankaSearchPrePortVOs = dbDao.searchPrePort(sriLankaManifestTransmitVO);
							if (sriLankaSearchPrePortVOs != null && sriLankaSearchPrePortVOs.size() > 0) {
								flatFile.append("PREVPORT:").append(sriLankaSearchPrePortVOs.get(0).getVpsPortCd()).append("\n");
							} else {
								flatFile.append("PREVPORT:").append("\n");
							}
	
							sriLankaSearchEtaVOs = dbDao.searchEta(sriLankaManifestTransmitVO, "O");
							if (sriLankaSearchEtaVOs != null && sriLankaSearchEtaVOs.size() > 0) {
								flatFile.append("ETA:").append(sriLankaSearchEtaVOs.get(0).getVpsEtaDt()).append("\n");
							} else {
								flatFile.append("ETA:").append("\n");
							}
	
							sriLankaSearchEtdVOs = dbDao.searchEtd(sriLankaManifestTransmitVO);
							if (sriLankaSearchEtdVOs != null && sriLankaSearchEtdVOs.size() > 0) {
								flatFile.append("ETD:").append(sriLankaSearchEtdVOs.get(0).getVpsEtdDt()).append("\n");
							} else {
								flatFile.append("ETD:").append("\n");
							}
							flatFile.append("PORT_REG_NO:").append(sriLankaManifestTransmitVO.getRegNo()).append("\n");
						}
						
						sriLankaSearchBkgNoVOs = dbDao.searchBkgNo(sriLankaManifestTransmitVO);
						if (sriLankaSearchBkgNoVOs != null && sriLankaSearchBkgNoVOs.size() > 0) {
							for (int m = 0; m < sriLankaSearchBkgNoVOs.size(); m++) {
								sriLankaManifestTransmitVO.setBkgNo(sriLankaSearchBkgNoVOs.get(m).getBkgNo());
								sriLankaManifestTransmitVO.setCgoTp(sriLankaSearchBkgNoVOs.get(m).getBkgCgoTpCd());
								
								String arrayCntrNo1[] = sriLankaManifestTransmitVO.getCntrNo().split(",");
								
								int cntrCnt = arrayCntrNo1.length;
							
								sriLankaManifestTransmitVO.setCntrCnt(Integer.toString(cntrCnt));
								
								sriLankaSearchBlGeneralVOs = dbDao.searchBlGeneral(sriLankaManifestTransmitVO, "O");
								if (sriLankaSearchBlGeneralVOs != null && sriLankaSearchBlGeneralVOs.size() > 0) {
									for (int n = 0; n < sriLankaSearchBlGeneralVOs.size(); n++) {
										StringTokenizer token = new StringTokenizer(sriLankaSearchBlGeneralVOs.get(n)
												.getBlDesc(), "\n");
										ArrayList tmpArray = new ArrayList();
										while (token.hasMoreTokens()) {
											tmpArray.add(token.nextToken());
										}
										for (int mm = 0; mm < tmpArray.size(); mm++) {
											flatFile.append(tmpArray.get(mm).toString());
											flatFile.append("\n");
										}
										
                                        String arrayCntrNo[] = sriLankaManifestTransmitVO.getCntrNo().split(",");
                                        
                                        //arrayBlNo,arrayCntrNo 추가하여 쿼리 호출.
                                 

                                        srilankaSearchContainerVOs = dbDao.searchContainer(sriLankaManifestTransmitVO,arrayCntrNo, "O");
										if (srilankaSearchContainerVOs != null && srilankaSearchContainerVOs.size() > 0) {
											for (int p = 0; p < srilankaSearchContainerVOs.size(); p++) {
												token = new StringTokenizer(
														srilankaSearchContainerVOs.get(p).getCntrDesc(), "\n");
												tmpArray = new ArrayList();
												while (token.hasMoreTokens()) {
													tmpArray.add(token.nextToken());
												}
												for (int mm = 0; mm < tmpArray.size(); mm++) {
													flatFile.append(tmpArray.get(mm).toString());
													flatFile.append("\n");
												}
											}
										}
										srilankaSearchBlMarkDescVOs = dbDao.searchBlMarkDesc(sriLankaManifestTransmitVO, "O");
										if (srilankaSearchBlMarkDescVOs != null && srilankaSearchBlMarkDescVOs.size() > 0) {
											for (int q = 0; q < srilankaSearchBlMarkDescVOs.size(); q++) {
												token = new StringTokenizer(srilankaSearchBlMarkDescVOs.get(q)
														.getCmdtDesc(), "\n");
												tmpArray = new ArrayList();
												while (token.hasMoreTokens()) {
													tmpArray.add(token.nextToken());
												}
												for (int mm = 0; mm < tmpArray.size(); mm++) {
													flatFile.append(tmpArray.get(mm).toString());
													flatFile.append("\n");
												}
												token = new StringTokenizer(srilankaSearchBlMarkDescVOs.get(q).getMkDesc(),
														"\n");
												tmpArray = new ArrayList();
												while (token.hasMoreTokens()) {
													tmpArray.add(token.nextToken());
												}
												for (int mm = 0; mm < tmpArray.size(); mm++) {
													flatFile.append(tmpArray.get(mm).toString());
													flatFile.append("\n");
												}
											}
										}
										flatFile.append("}BL_INFO").append("\n");
									}
	
								}
							}
						}
					}
				}
			}
		//	System.out.println("★"+flatFile.toString());
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE")); 

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
	 * Flat File 생성 처리<br>
	 * SriLanka 세관에 신고할 Vessel Arrival 데이터를 조회하여 FlatFile을 생성하고, Send Date를 저장한다. -- UI_BKG-0493
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String transmitManifestCts(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException {
		StringBuffer flatFile = new StringBuffer();
		SriLankaManifestTransmitVO sriLankaManifestTransmitVO = new SriLankaManifestTransmitVO();
		List<SriLankaSearchMakeHeaderVO> sriLankaSearchMakeHeaderVOs = null;
		List<SriLankaSearchFlagVO> sriLankaSearchFlagVOs = null;
		List<SriLankaSearchEtaVO> sriLankaSearchEtaVOs = null;
		List<SriLankaSearchBkgNoVO> sriLankaSearchBkgNoVOs = null;
		List<SriLankaSearchBlGeneralVO> sriLankaSearchBlGeneralVOs = null;
		List<SrilankaSearchContainerVO> srilankaSearchContainerVOs = null;
		List<SrilankaSearchBlMarkDescVO> srilankaSearchBlMarkDescVOs = null;
		List<SriLankaCargoInfoVO> sriLankaCargoInfoVOs = null;
		String shipStayRef = null;
		String mrnRefNo = null;
		String bkg_no = "";

		
		try {
			if (manifestTransmitVOs != null) {
				sriLankaManifestTransmitVO = (SriLankaManifestTransmitVO)manifestTransmitVOs[0];
				sriLankaSearchMakeHeaderVOs = dbDao.searchMakeHeader(sriLankaManifestTransmitVO.getEdiMtRemoval(), account.getOfc_cd(), "N");
				// 해더 부분 생성작업
				if (sriLankaSearchMakeHeaderVOs != null) {
					SriLankaSearchMakeHeaderVO sriLankaSearchMakeHeaderVO;
					for (int i = 0; i < sriLankaSearchMakeHeaderVOs.size(); i++) {
						sriLankaSearchMakeHeaderVO = sriLankaSearchMakeHeaderVOs.get(i);
						flatFile.append(sriLankaSearchMakeHeaderVO.getMsgHeader()).append("\n");
					}
				}

				for (int i=0; i<manifestTransmitVOs.length; i++) {
					sriLankaManifestTransmitVO = (SriLankaManifestTransmitVO)manifestTransmitVOs[i];
					
					if(sriLankaManifestTransmitVO != null){	
						
						if (i == 0){
							if(sriLankaManifestTransmitVO.getIoBndCd().equals("I")){
								flatFile.append("DOC_TP:").append("I").append("\n");//추가
							}else{
								flatFile.append("DOC_TP:").append("E").append("\n");//추가
							}							
							
							mrnRefNo = dbDao.searchMrnRefNo(sriLankaManifestTransmitVO);
							if (mrnRefNo.length() > 0) {
								flatFile.append("MRN:").append(mrnRefNo).append("\n");
							} else {
								flatFile.append("MRN:").append("\n");
							}
							
							if(sriLankaSearchMakeHeaderVOs != null){
								flatFile.append("DOC_DT:").append(sriLankaSearchMakeHeaderVOs.get(0).getDocDt()).append("\n");//추가
							}else{
								flatFile.append("DOC_DT:").append("").append("\n");//추가
							}
							
							
//							flatFile.append("CUSTOMS_OFC:").append(sriLankaManifestTransmitVO.getCustomsOfficeCode()).append("\n"); //기존재 항목(유지)
							flatFile.append("CUSTOMS_OFC:").append("LKCMB").append("\n"); //기존재 항목(유지)
							
							shipStayRef = dbDao.searchVvdCstmsInfo(sriLankaManifestTransmitVO,"N");
							if (shipStayRef.length() > 0) {
								flatFile.append("SHIP_STAY_REF:").append(shipStayRef).append("\n");
							} else {
								flatFile.append("SHIP_STAY_REF:").append("\n");
							}
							
//							flatFile.append("SHIP_STAY_REF:").append(sriLankaManifestTransmitVO.getShipStayRef()).append("\n");//추가
							flatFile.append("SCAC:").append("SMLM").append("\n");//추가
							
							flatFile.append("VVD:").append(sriLankaManifestTransmitVO.getVvdNumber()).append("\n");//기존재 항목(유지)
							
							flatFile.append("IMO_NO:").append(sriLankaManifestTransmitVO.getLloydCd()).append("\n");//추가
							flatFile.append("CARRIER_NM:").append(sriLankaManifestTransmitVO.getCrrNm()).append("\n");//추가
	
							flatFile.append("VSL_FULLNAME:").append(sriLankaManifestTransmitVO.getVslNm()).append("\n");//기존재 항목(유지)
							
							
							sriLankaSearchFlagVOs = dbDao.searchFlag(sriLankaManifestTransmitVO);//기존재 항목(유지)
							if (sriLankaSearchFlagVOs != null && sriLankaSearchFlagVOs.size() > 0) {
								flatFile.append("VSL_NTL_CD:").append(sriLankaSearchFlagVOs.get(0).getVslCntCd()).append("\n");
							}
							else {
								flatFile.append("VSL_NTL_CD:").append("\n");
							}
							
							if(sriLankaManifestTransmitVO.getIoBndCd().equals("I")){
								flatFile.append("POD:").append(sriLankaManifestTransmitVO.getVvdPod()).append("\n");//추가
							}else{
								flatFile.append("POL:").append(sriLankaManifestTransmitVO.getVvdPol()).append("\n");//추가
							}
							
							sriLankaSearchEtaVOs = dbDao.searchEta(sriLankaManifestTransmitVO, "N");//기존재 항목(유지)
							
							if (sriLankaSearchEtaVOs != null && sriLankaSearchEtaVOs.size() > 0) {
								if(sriLankaManifestTransmitVO.getIoBndCd().equals("I")){
									flatFile.append("ETA:").append(sriLankaSearchEtaVOs.get(0).getVpsEtaDt()).append("\n");
								}else{
									flatFile.append("ETD:").append(sriLankaSearchEtaVOs.get(0).getVpsEtaDt()).append("\n");
								}
							} else {
								if(sriLankaManifestTransmitVO.getIoBndCd().equals("I")){
									flatFile.append("ETA:").append("\n");
								}else{
									flatFile.append("ETD:").append("\n");
								}
								
							}
	
//							sriLankaSearchEtdVOs = dbDao.searchEtd(sriLankaManifestTransmitVO);//기존재 항목(유지)
//							if (sriLankaSearchEtdVOs != null && sriLankaSearchEtdVOs.size() > 0) {
//								flatFile.append("ETD:").append(sriLankaSearchEtdVOs.get(0).getVpsEtdDt()).append("\n");
//							} else {
//								flatFile.append("ETD:").append("\n");
//							}
							
							
//							flatFile.append("VSL_AUTH_NO:").append(sriLankaManifestTransmitVO.getAuthNo()).append("\n");//삭제?
	
							
	
//							slpaRefNo = dbDao.searchVvdCstmsInfo(sriLankaManifestTransmitVO);
//							if (slpaRefNo.length() > 0) {
//								flatFile.append("SLPA_REF_NO:").append(slpaRefNo).append("\n");
//							} else {
//								flatFile.append("SLPA_REF_NO:").append("\n");
//							}
	
//							flatFile.append("TIN:").append(sriLankaManifestTransmitVO.getCarrierNo()).append("\n");
//							
//							flatFile.append("DEL:").append(sriLankaManifestTransmitVO.getDelCd()).append("\n");
	
//							sriLankaSearchPrePortVOs = dbDao.searchPrePort(sriLankaManifestTransmitVO);
//							if (sriLankaSearchPrePortVOs != null && sriLankaSearchPrePortVOs.size() > 0) {
//								flatFile.append("PREVPORT:").append(sriLankaSearchPrePortVOs.get(0).getVpsPortCd()).append("\n");
//							} else {
//								flatFile.append("PREVPORT:").append("\n");
//							}		
//							flatFile.append("PORT_REG_NO:").append(sriLankaManifestTransmitVO.getRegNo()).append("\n");
						}
						
						sriLankaSearchBkgNoVOs = dbDao.searchBkgNo(sriLankaManifestTransmitVO);
						if (sriLankaSearchBkgNoVOs != null && sriLankaSearchBkgNoVOs.size() > 0) {
							
							
							for (int m = 0; m < sriLankaSearchBkgNoVOs.size(); m++) {
								sriLankaManifestTransmitVO.setBkgNo(sriLankaSearchBkgNoVOs.get(m).getBkgNo());
								sriLankaManifestTransmitVO.setCgoTp(sriLankaSearchBkgNoVOs.get(m).getBkgCgoTpCd());
								
								String arrayCntrNo1[] = sriLankaManifestTransmitVO.getCntrNo().split(",");
								
								int cntrCnt = arrayCntrNo1.length;
							
								sriLankaManifestTransmitVO.setCntrCnt(Integer.toString(cntrCnt));
								
								sriLankaSearchBlGeneralVOs = dbDao.searchBlGeneral(sriLankaManifestTransmitVO,"N");
								if (sriLankaSearchBlGeneralVOs != null && sriLankaSearchBlGeneralVOs.size() > 0) {
									for (int n = 0; n < sriLankaSearchBlGeneralVOs.size(); n++) {
										StringTokenizer token = new StringTokenizer(sriLankaSearchBlGeneralVOs.get(n)
												.getBlDesc(), "\n");
//										ArrayList tmpBlArray = new ArrayList();
//										while (token.hasMoreTokens()) {
//											tmpBlArray.add(token.nextToken());
//										}
										
										
                                        String arrayCntrNo[] = sriLankaManifestTransmitVO.getCntrNo().split(",");
                                        
                                        //arrayBlNo,arrayCntrNo 추가하여 쿼리 호출.
                                 

                                        srilankaSearchContainerVOs = dbDao.searchContainer(sriLankaManifestTransmitVO,arrayCntrNo, "N");
										if (srilankaSearchContainerVOs != null && srilankaSearchContainerVOs.size() > 0) {
											for (int p = 0; p < srilankaSearchContainerVOs.size(); p++) {
												token = new StringTokenizer(
														srilankaSearchContainerVOs.get(p).getCntrDesc(), "\n");
												ArrayList tmpArray = new ArrayList();
												while (token.hasMoreTokens()) {
													tmpArray.add(token.nextToken());
												}
												
												for (int mm = 0; mm < tmpArray.size(); mm++) {
													flatFile.append(tmpArray.get(mm).toString());
													flatFile.append("\n");
												}
											}
										}
										
//										for (int mm = 0; mm < tmpBlArray.size(); mm++) {
//											flatFile.append(tmpBlArray.get(mm).toString());
//											flatFile.append("\n");
//										}
										
//										srilankaSearchBlMarkDescVOs = dbDao.searchBlMarkDesc(sriLankaManifestTransmitVO);
//										if (srilankaSearchBlMarkDescVOs != null && srilankaSearchBlMarkDescVOs.size() > 0) {
//											for (int q = 0; q < srilankaSearchBlMarkDescVOs.size(); q++) {
//												token = new StringTokenizer(srilankaSearchBlMarkDescVOs.get(q)
//														.getCmdtDesc(), "\n");
//												ArrayList tmpArray = new ArrayList();
//												while (token.hasMoreTokens()) {
//													tmpArray.add(token.nextToken());
//												}
//												for (int mm = 0; mm < tmpArray.size(); mm++) {
//													flatFile.append(tmpArray.get(mm).toString());
//													flatFile.append("\n");
//												}
//												token = new StringTokenizer(srilankaSearchBlMarkDescVOs.get(q).getMkDesc(),
//														"\n");
//												tmpArray = new ArrayList();
//												while (token.hasMoreTokens()) {
//													tmpArray.add(token.nextToken());
//												}
//												for (int mm = 0; mm < tmpArray.size(); mm++) {
//													flatFile.append(tmpArray.get(mm).toString());
//													flatFile.append("\n");
//												}
//											}
//										}
//										flatFile.append("}BL_INFO").append("\n");
									}
	
								}
							}
						}
					}
				}
				
				
				
				/////////////////////////////////////////////////////////////////////////
				for (int i=0; i<manifestTransmitVOs.length; i++) {
					sriLankaManifestTransmitVO = (SriLankaManifestTransmitVO)manifestTransmitVOs[i];
					
					if(sriLankaManifestTransmitVO != null){	
						
						
						
						sriLankaSearchBkgNoVOs = dbDao.searchBkgNo(sriLankaManifestTransmitVO);
						if (sriLankaSearchBkgNoVOs != null && sriLankaSearchBkgNoVOs.size() > 0) {
							for (int m = 0; m < sriLankaSearchBkgNoVOs.size(); m++) {
								sriLankaManifestTransmitVO.setBkgNo(sriLankaSearchBkgNoVOs.get(m).getBkgNo());
								sriLankaManifestTransmitVO.setCgoTp(sriLankaSearchBkgNoVOs.get(m).getBkgCgoTpCd());
								
								String arrayCntrNo1[] = sriLankaManifestTransmitVO.getCntrNo().split(",");
								
								int cntrCnt = arrayCntrNo1.length;
							
								sriLankaManifestTransmitVO.setCntrCnt(Integer.toString(cntrCnt));
								
								sriLankaSearchBlGeneralVOs = dbDao.searchBlGeneral(sriLankaManifestTransmitVO, "N");
								if (sriLankaSearchBlGeneralVOs != null && sriLankaSearchBlGeneralVOs.size() > 0) {
									for (int n = 0; n < sriLankaSearchBlGeneralVOs.size(); n++) {
										StringTokenizer token = new StringTokenizer(sriLankaSearchBlGeneralVOs.get(n)
												.getBlDesc(), "\n");
										ArrayList tmpBlArray = new ArrayList();
										while (token.hasMoreTokens()) {
											tmpBlArray.add(token.nextToken());
										}
										
										
//                                        String arrayCntrNo[] = sriLankaManifestTransmitVO.getCntrNo().split(",");
//                                        
//                                        //arrayBlNo,arrayCntrNo 추가하여 쿼리 호출.
//                                 
//
//                                        srilankaSearchContainerVOs = dbDao.searchContainer(sriLankaManifestTransmitVO,arrayCntrNo);
//										if (srilankaSearchContainerVOs != null && srilankaSearchContainerVOs.size() > 0) {
//											for (int p = 0; p < srilankaSearchContainerVOs.size(); p++) {
//												token = new StringTokenizer(
//														srilankaSearchContainerVOs.get(p).getCntrDesc(), "\n");
//												ArrayList tmpArray = new ArrayList();
//												while (token.hasMoreTokens()) {
//													tmpArray.add(token.nextToken());
//												}
//												for (int mm = 0; mm < tmpArray.size(); mm++) {
//													flatFile.append(tmpArray.get(mm).toString());
//													flatFile.append("\n");
//												}
//											}
//										}
										
										for (int mm = 0; mm < tmpBlArray.size(); mm++) {
											flatFile.append(tmpBlArray.get(mm).toString());
											flatFile.append("\n");
										}
										
										//////CARGO INFO START
										sriLankaCargoInfoVOs = dbDao.searchCargoInfo(sriLankaManifestTransmitVO);
										if (sriLankaCargoInfoVOs != null && sriLankaCargoInfoVOs.size() > 0) {
											for (int q = 0; q < sriLankaCargoInfoVOs.size(); q++) {
												token = new StringTokenizer(sriLankaCargoInfoVOs.get(q).getCargoDesc(), "\n");
												ArrayList tmpArray = new ArrayList();
												while (token.hasMoreTokens()) {
													tmpArray.add(token.nextToken());
												}
												for (int mm = 0; mm < tmpArray.size(); mm++) {
													flatFile.append(tmpArray.get(mm).toString());
													flatFile.append("\n");
												}												
											}
										}										
										//////CARGO INFO END
										
										
										
										/////DG_INFO START
										sriLankaCargoInfoVOs = dbDao.searchDgInfo(sriLankaManifestTransmitVO);
										if (sriLankaCargoInfoVOs != null && sriLankaCargoInfoVOs.size() > 0) {
											for (int q = 0; q < sriLankaCargoInfoVOs.size(); q++) {
												token = new StringTokenizer(sriLankaCargoInfoVOs.get(q).getDgDesc(), "\n");
												ArrayList tmpArray = new ArrayList();
												while (token.hasMoreTokens()) {
													tmpArray.add(token.nextToken());
												}
												for (int mm = 0; mm < tmpArray.size(); mm++) {
													flatFile.append(tmpArray.get(mm).toString());
													flatFile.append("\n");
												}
											}
										}
										/////DG_INFO END
										
										
										
										srilankaSearchBlMarkDescVOs = dbDao.searchBlMarkDesc(sriLankaManifestTransmitVO,"N");
										if (srilankaSearchBlMarkDescVOs != null && srilankaSearchBlMarkDescVOs.size() > 0) {
											for (int q = 0; q < srilankaSearchBlMarkDescVOs.size(); q++) {
//												token = new StringTokenizer(srilankaSearchBlMarkDescVOs.get(q)
//														.getCmdtDesc(), "\n");
//												ArrayList tmpArray = new ArrayList();
//												while (token.hasMoreTokens()) {
//													tmpArray.add(token.nextToken());
//												}
//												for (int mm = 0; mm < tmpArray.size(); mm++) {
//													flatFile.append(tmpArray.get(mm).toString());
//													flatFile.append("\n");
//												}
												token = new StringTokenizer(srilankaSearchBlMarkDescVOs.get(q).getMkDesc(), "\n");
												ArrayList tmpArray = new ArrayList();
												while (token.hasMoreTokens()) {
													tmpArray.add(token.nextToken());
												}
												for (int mm = 0; mm < tmpArray.size(); mm++) {
													flatFile.append(tmpArray.get(mm).toString());
													flatFile.append("\n");
												}
											}
										}
										flatFile.append("}CARGO_INFO").append("\n");
										flatFile.append("}BL_INFO").append("\n");
									}
	
								}
							}
						}
					}
				}
				///////////////////////////////////////////////////////////////////////////////////////////////
			}
			
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE")); 

			BookingUtil command = new BookingUtil();
			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			HistoryLineVO historyLineVO = new HistoryLineVO();
			//System.out.println("○○○○○○○○○○○○" +manifestTransmitVOs.length);
			for (int i=0; i<manifestTransmitVOs.length; i++) {
				sriLankaManifestTransmitVO = (SriLankaManifestTransmitVO)manifestTransmitVOs[i];
				if(sriLankaManifestTransmitVO != null){
					historyLineVO = new HistoryLineVO();
					historyLineVO.setBkgNo(sriLankaManifestTransmitVO.getBkgNo());
					//System.out.println("○" +sriLankaManifestTransmitVO.getBkgNo());
					historyLineVO.setUiId("ESM_BKG_0490");
					historyLineVO.setCrntCtnt("Srilanka Manifest Transmit");
					historyLineVO.setHisCateNm("Srilanka Manifest Transmit"); 
					historyBC.createBkgHistoryLine(historyLineVO, account);
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
	 * SriLanka 세관에 신고할 Vessel Arrival 데이터를 조회하여 FlatFile을 생성하고, Send Date를 저장한다. -- UI_BKG-0493
	 * 
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO) throws EventException {
		StringBuffer flatFile = new StringBuffer();
		SriLankaVesselArrivalTransmitVO sriLankaVesselArrivalTransmitVO = new SriLankaVesselArrivalTransmitVO();
		sriLankaVesselArrivalTransmitVO = (SriLankaVesselArrivalTransmitVO) vesselArrivalTransmitVO;
		List<SriLankaSearchVesselArrivalVO> sriLankaSearchVesselArrivalVOs = null;
		List<SriLankaSearchMakeHeaderVesselVO> sriLankaSearchMakeHeaderVesselVOs = null;
		try {
			sriLankaSearchMakeHeaderVesselVOs = dbDao.searchMakeHeaderVessel();
			// 해더 부분 생성작업
			if (sriLankaSearchMakeHeaderVesselVOs != null) {
				SriLankaSearchMakeHeaderVesselVO sriLankaSearchMakeHeaderVesselVO;
				for (int i = 0; i < sriLankaSearchMakeHeaderVesselVOs.size(); i++) {
					sriLankaSearchMakeHeaderVesselVO = sriLankaSearchMakeHeaderVesselVOs.get(i);
					flatFile.append(sriLankaSearchMakeHeaderVesselVO.getMsgHeader()).append("\n");
				}
			}
			// 스리랑카 세관 신고용 Manifest Vessel Arrival 정보를 조회한다.
			sriLankaSearchVesselArrivalVOs = dbDao.searchVesselArrival(sriLankaVesselArrivalTransmitVO);
			if (sriLankaSearchVesselArrivalVOs != null) {

				for (int i = 0; i < sriLankaSearchVesselArrivalVOs.size(); i++) {
					flatFile.append("FILE_NAME:").append(sriLankaSearchVesselArrivalVOs.get(i).getFileName()).append(
							"\n");
					flatFile.append("VSL_FULLNAME:").append(sriLankaSearchVesselArrivalVOs.get(i).getVslFullname())
							.append("\n");
					flatFile.append("VOYAGE_CODE:").append(sriLankaSearchVesselArrivalVOs.get(i).getVoyageCode())
							.append("\n");
					flatFile.append("ARVL_DT:").append(sriLankaSearchVesselArrivalVOs.get(i).getArvlDt()).append("\n");
					flatFile.append("ARVL_TM:").append(sriLankaSearchVesselArrivalVOs.get(i).getArvlTm()).append("\n");
					flatFile.append("DEPT_DT:").append(sriLankaSearchVesselArrivalVOs.get(i).getDeptDt()).append("\n");
					flatFile.append("DEPT_TM:").append(sriLankaSearchVesselArrivalVOs.get(i).getDeptTm()).append("\n");
					flatFile.append("CAPT_NM:").append(sriLankaSearchVesselArrivalVOs.get(i).getCaptNm()).append("\n");
					flatFile.append("VSLFLG:").append(sriLankaSearchVesselArrivalVOs.get(i).getVslflg()).append("\n");
					flatFile.append("DEPT_PORT:").append(sriLankaSearchVesselArrivalVOs.get(i).getDeptPort()).append(
							"\n");
					flatFile.append("ARVL_PORT:").append(sriLankaSearchVesselArrivalVOs.get(i).getArvlPort()).append(
							"\n");
					flatFile.append("SHP_AGT:").append(sriLankaSearchVesselArrivalVOs.get(i).getShpAgt()).append("\n");
					flatFile.append("SHP_AGT2:").append(sriLankaSearchVesselArrivalVOs.get(i).getShpAgt2());
				}
			}

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_SLKMSG.IBMMQ.QUEUE"));

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
	 * RECEIVE받은 FLAT FILE를 로그테이블에 생성한다.
	 * 
	 * @param String flatFile
	 * @param String userid
	 * @throws EventException
	 */

	@SuppressWarnings("unchecked")
	public void loadCstmsRcvMsg(String flatFile, String userid) throws EventException {
		try {
			SriLankaRcvMsgVO sriLankaRcvMsgVO = new SriLankaRcvMsgVO();

			BkgCstmsSriRcvLogVO bkgCstmsSriRcvLogVO = new BkgCstmsSriRcvLogVO();
			StringTokenizer token = new StringTokenizer(flatFile, "\n");
			ArrayList tmpArray = new ArrayList();

			while (token.hasMoreTokens()) {
				tmpArray.add(token.nextToken());
			}
			for (int j = 0; j < tmpArray.size(); j++) {
				String data1 = tmpArray.get(j).toString();
				bkgCstmsSriRcvLogVO.setRspnDivCd("M");
				if (data1.length() > 11 && data1.substring(0, 12).equalsIgnoreCase("$$$MSGSTART:")) {
					bkgCstmsSriRcvLogVO.setUserId(data1.substring(12, 27).trim());
				}
				if (data1.length() > 9 && data1.substring(0, 10).equalsIgnoreCase("AUTH_NO : ")) {
					bkgCstmsSriRcvLogVO.setVslAuthNo(data1.substring(10).trim());
				}
				if (data1.length() > 8 && data1.substring(0, 9).equalsIgnoreCase("REG_NO : ")) {
					bkgCstmsSriRcvLogVO.setVslRgstNo(data1.substring(9).trim());
					bkgCstmsSriRcvLogVO.setRspnDivCd("V");
					sriLankaRcvMsgVO.setRspnDivCd("V");
				}
				if (data1.length() > 8 && data1.substring(0, 9).equalsIgnoreCase("VSL_NM : ")) {
					bkgCstmsSriRcvLogVO.setVslNm(data1.substring(9).trim());
				}
				if (data1.length() > 8 && data1.substring(0, 9).equalsIgnoreCase("VOY_CD : ")) {
					bkgCstmsSriRcvLogVO.setSkdVoyNo(data1.substring(9, 13).trim());
					bkgCstmsSriRcvLogVO.setSkdDirCd(data1.substring(13).trim());
				}
				if (data1.length() > 9 && data1.substring(0, 10).equalsIgnoreCase("DEPT_DT : ")) {
					bkgCstmsSriRcvLogVO.setDepDt(data1.substring(10).trim());
				}
				if (data1.length() > 8 && data1.substring(0, 9).equalsIgnoreCase("STS_CD : ")) {
					bkgCstmsSriRcvLogVO.setSrStsCd(data1.substring(9).trim());

				}
				if (data1.length() > 7 && data1.substring(0, 8).equalsIgnoreCase("RDATE : ")) {
					bkgCstmsSriRcvLogVO.setRdate(data1.substring(8).trim());
				}
				if (data1.length() > 7 && data1.substring(0, 8).equalsIgnoreCase("RTIME : ")) {
					bkgCstmsSriRcvLogVO.setRtime(data1.substring(8).trim());
				}
				if (data1.length() > 6 && data1.substring(0, 7).equalsIgnoreCase("DESC : ")) {
					bkgCstmsSriRcvLogVO.setSrStsDesc(data1.substring(7).trim());
				}
			}
			dbDao.addSriLankaResponse(bkgCstmsSriRcvLogVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}
}

