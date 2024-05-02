/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BangladeshCustomsTransmissionBCImpl.java
 *@FileTitle : BangladeshCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.10
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.04.21 임재택
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration.BangladeshCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBlGeneralVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchFlagVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchEtaVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchEtdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchMakeHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchPrePortVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBlMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
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
public class BangladeshCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient BangladeshCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public BangladeshCustomsTransmissionBCImpl() {
		dbDao = new BangladeshCustomsTransmissionDBDAO();
	}

	/**
	 * Flat File 생성 처리<br>
	 * Bangladesh 세관에 신고할 Vessel Arrival 데이터를 조회하여 FlatFile을 생성하고, Send Date를 저장한다. -- UI_BKG-0493
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
		BangladeshManifestTransmitVO bangladeshManifestTransmitVO = new BangladeshManifestTransmitVO();
		List<BangladeshSearchMakeHeaderVO> bangladeshSearchMakeHeaderVOs = null;
		List<BangladeshSearchPrePortVO> bangladeshSearchPrePortVOs = null;
		List<BangladeshSearchFlagVO> bangladeshSearchFlagVOs = null;
		List<BangladeshSearchEtaVO> bangladeshSearchEtaVOs = null;
		List<BangladeshSearchEtdVO> bangladeshSearchEtdVOs = null;
		List<BangladeshSearchBkgNoVO> bangladeshSearchBkgNoVOs = null;
		List<BangladeshSearchBlGeneralVO> bangladeshSearchBlGeneralVOs = null;
		List<BangladeshSearchContainerVO> bangladeshSearchContainerVOs = null;
		List<BangladeshSearchBlMarkDescVO> bangladeshSearchBlMarkDescVOs = null;
		String currBkgNo = "";
		String preBkgNo = "";
				

		try {
			BookingUtil bkgUtil = new BookingUtil();
			manifestTransmitVOs = (BangladeshManifestTransmitVO[])bkgUtil.sortArray(manifestTransmitVOs, "blNo");
			
			bangladeshSearchMakeHeaderVOs = dbDao.searchMakeHeader();
			// 해더 부분 생성작업
			if (bangladeshSearchMakeHeaderVOs != null) {
				BangladeshSearchMakeHeaderVO bangladeshSearchMakeHeaderVO;
				for (int i = 0; i < bangladeshSearchMakeHeaderVOs.size(); i++) {
					bangladeshSearchMakeHeaderVO = bangladeshSearchMakeHeaderVOs.get(i);
					flatFile.append(bangladeshSearchMakeHeaderVO.getMsgHeader()).append("\n");
				}
			}
			if (manifestTransmitVOs != null) {
				for (int i = 0; i < manifestTransmitVOs.length; i++) {
					bangladeshManifestTransmitVO = (BangladeshManifestTransmitVO) manifestTransmitVOs[i];

					if (i == 0){
						flatFile.append("VVD:").append(bangladeshManifestTransmitVO.getVvd()).append("\n");
						//flatFile.append("VVD:").append(dbDao.searchVvdCstmsInfo(bangladeshManifestTransmitVO)).append("\n");
						
						flatFile.append("VSL_FULLNAME:").append(bangladeshManifestTransmitVO.getVslNm()).append("\n");
//						flatFile.append("VSL_AUTH_NO:").append(bangladeshManifestTransmitVO.getAuthNo()).append("\n");
						
						bangladeshSearchFlagVOs = dbDao.searchFlag(bangladeshManifestTransmitVO);
						if (bangladeshSearchFlagVOs != null && bangladeshSearchFlagVOs.size() > 0) {
							flatFile.append("VSL_NTL_CD:").append(bangladeshSearchFlagVOs.get(0).getVslCntCd()).append("\n");
							flatFile.append("VSL_REG_CITY:").append(bangladeshSearchFlagVOs.get(0).getCntNm()).append("\n");
							flatFile.append("VSL_IMO_CD:").append(bangladeshSearchFlagVOs.get(0).getVslImoCd()).append("\n");
							flatFile.append("VSL_MASTER_NM: ").append("\n");
						}
						else {
							flatFile.append("VSL_NTL_CD: ").append("\n");
							flatFile.append("VSL_REG_CITY: ").append("\n");
							flatFile.append("VSL_IMO_CD: ").append("\n");
							flatFile.append("VSL_MASTER_NM: ").append("\n");
						}
						
						//스리랑카 Customer VVD 전송로직. 방글라데시세관에는 우선 제외.
//						slpaRefNo = dbDao.searchVvdCstmsInfo(bangladeshManifestTransmitVO);
//						if (slpaRefNo.length() > 0) {
//							flatFile.append("SLPA_REF_NO:").append(slpaRefNo).append("\n");
//						}
//						else {
//							flatFile.append("SLPA_REF_NO:").append("\n");
//						}			
						
//						flatFile.append("TIN:").append(bangladeshManifestTransmitVO.getCarrierNo()).append("\n");
//						flatFile.append("CUSTOMS_OFC:").append(bangladeshManifestTransmitVO.getCustomsOfficeCode()).append("\n");
						flatFile.append("DEL:").append(bangladeshManifestTransmitVO.getPodCd()).append("\n");

						bangladeshSearchPrePortVOs = dbDao.searchPrePort(bangladeshManifestTransmitVO);
						if (bangladeshSearchPrePortVOs != null && bangladeshSearchPrePortVOs.size() > 0) {
							flatFile.append("PREVPORT:").append(bangladeshSearchPrePortVOs.get(0).getVpsPortCd()).append("\n");
							flatFile.append("PRE_ETD:").append(bangladeshSearchPrePortVOs.get(0).getVpsEtdDt()).append("\n");
						}
						else {
							flatFile.append("PREVPORT: ").append("\n");
							flatFile.append("PRE_ETD: ").append("\n");
						}

						bangladeshSearchEtaVOs = dbDao.searchEta(bangladeshManifestTransmitVO);
						if (bangladeshSearchEtaVOs != null && bangladeshSearchEtaVOs.size() > 0) {
							flatFile.append("ETA:").append(bangladeshSearchEtaVOs.get(0).getVpsEtaDt()).append("\n");
							flatFile.append("ETA_TIME:").append(bangladeshSearchEtaVOs.get(0).getVpsEtaTm()).append("\n");
						}
						else {
							flatFile.append("ETA: ").append("\n");
							flatFile.append("ETA_TIME: ").append("\n");
						}

						bangladeshSearchEtdVOs = dbDao.searchEtd(bangladeshManifestTransmitVO);
						if (bangladeshSearchEtdVOs != null && bangladeshSearchEtdVOs.size() > 0) {
							flatFile.append("ETD:").append(bangladeshSearchEtdVOs.get(0).getVpsEtdDt()).append("\n");
						}
						else {
							flatFile.append("ETD: ").append("\n");
						}

						flatFile.append("PORT_REG_NO:").append(bangladeshManifestTransmitVO.getRegNo()).append("\n");
					}					
					
					bangladeshSearchBkgNoVOs = dbDao.searchBkgNo(bangladeshManifestTransmitVO);
					if (bangladeshSearchBkgNoVOs != null && bangladeshSearchBkgNoVOs.size() > 0) {
						for (int m = 0; m < bangladeshSearchBkgNoVOs.size(); m++) {
							
							currBkgNo = bangladeshSearchBkgNoVOs.get(m).getBkgNo();
							//ArrayList alist = new ArrayList();
							
							if(currBkgNo.equals(preBkgNo)) continue;
							
							bangladeshManifestTransmitVO.setBkgNo(bangladeshSearchBkgNoVOs.get(m).getBkgNo());
							bangladeshManifestTransmitVO.setBkgCgoTpCd(bangladeshSearchBkgNoVOs.get(m).getBkgCgoTpCd());
							bangladeshSearchBlGeneralVOs = dbDao.searchBlGeneral(bangladeshManifestTransmitVO);
							if (bangladeshSearchBlGeneralVOs != null && bangladeshSearchBlGeneralVOs.size() > 0) {
								for (int n = 0; n < bangladeshSearchBlGeneralVOs.size(); n++) {
									StringTokenizer token = new StringTokenizer(bangladeshSearchBlGeneralVOs.get(n)
											.getBlDesc(), "\n");
									ArrayList tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									bangladeshSearchContainerVOs = dbDao.searchContainer(bangladeshManifestTransmitVO);
									if (bangladeshSearchContainerVOs != null && bangladeshSearchContainerVOs.size() > 0) {
										for (int p = 0; p < bangladeshSearchContainerVOs.size(); p++) {
											token = new StringTokenizer(
													bangladeshSearchContainerVOs.get(p).getCntrDesc(), "\n");
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
									bangladeshSearchBlMarkDescVOs = dbDao.searchBlMarkDesc(bangladeshManifestTransmitVO);
									if (bangladeshSearchBlMarkDescVOs != null && bangladeshSearchBlMarkDescVOs.size() > 0) {
										for (int q = 0; q < bangladeshSearchBlMarkDescVOs.size(); q++) {
											token = new StringTokenizer(bangladeshSearchBlMarkDescVOs.get(q)
													.getCmdtDesc(), "\n");
											tmpArray = new ArrayList();
											while (token.hasMoreTokens()) {
												tmpArray.add(token.nextToken());
											}
											for (int mm = 0; mm < tmpArray.size(); mm++) {
												flatFile.append(tmpArray.get(mm).toString());
												flatFile.append("\n");
											}
											token = new StringTokenizer(bangladeshSearchBlMarkDescVOs.get(q).getMkDesc(),
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
							
							preBkgNo = currBkgNo;
						}
					}
				}
			}
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
}