/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SrilankaCustomsTransmissionBCImpl.java
 *@FileTitle : SrilankaCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.integration.SriLankaCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.BkgCstmsSriRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchBkgNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchBlGeneralVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchEtaVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchEtdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchMakeHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchMakeHeaderVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchPrePortVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaSearchVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaVesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SrilankaSearchBlMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SrilankaSearchContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-SrilankaCustomsTransmission Business Logic Command implementation<br>
 * - OPUS-SrilankaCustomsTransmission handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class SrilankaCustomsTransmissionBCImpl extends BasicCommandSupport implements SrilankaCustomsTransmissionBC {

	// Database Access Object
	private transient SriLankaCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl object creation<br>
	 * CustomsTransmissionDBDAO creation<br>
	 */
	public SrilankaCustomsTransmissionBCImpl() {
		dbDao = new SriLankaCustomsTransmissionDBDAO();
	}

	/**
	 * Flat File creation handling<br>
	 * save Send Date and create FlatFile after retrieve Vessel Arrival data for report SriLanka Customs -- UI_BKG-0493
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
		List<SriLankaSearchEtaVO> sriLankaSearchEtaVOs = null;
		List<SriLankaSearchEtdVO> sriLankaSearchEtdVOs = null;
		List<SriLankaSearchBkgNoVO> sriLankaSearchBkgNoVOs = null;
		List<SriLankaSearchBlGeneralVO> sriLankaSearchBlGeneralVOs = null;
		List<SrilankaSearchContainerVO> srilankaSearchContainerVOs = null;
		List<SrilankaSearchBlMarkDescVO> srilankaSearchBlMarkDescVOs = null;

		try {
			sriLankaSearchMakeHeaderVOs = dbDao.searchMakeHeader();
			if (sriLankaSearchMakeHeaderVOs != null) {
				SriLankaSearchMakeHeaderVO sriLankaSearchMakeHeaderVO;
				for (int i = 0; i < sriLankaSearchMakeHeaderVOs.size(); i++) {
					sriLankaSearchMakeHeaderVO = sriLankaSearchMakeHeaderVOs.get(i);
					flatFile.append(sriLankaSearchMakeHeaderVO.getMsgHeader()).append("\n");
				}
			}
			if (manifestTransmitVOs != null) {
				for (int i = 0; i < manifestTransmitVOs.length; i++) {
					sriLankaManifestTransmitVO = (SriLankaManifestTransmitVO) manifestTransmitVOs[i];

					if (i == 0){
						flatFile.append("VVD:").append(sriLankaManifestTransmitVO.getVvdNumber()).append("\n");
						flatFile.append("VSL_FULLNAME:").append(sriLankaManifestTransmitVO.getVslNm()).append("\n");
						flatFile.append("VSL_AUTH_NO:").append(sriLankaManifestTransmitVO.getAuthNo()).append("\n");
						flatFile.append("TIN:").append(sriLankaManifestTransmitVO.getCarrierNo()).append("\n");
						flatFile.append("CUSTOMS_OFC:").append(sriLankaManifestTransmitVO.getCustomsOfficeCode()).append("\n");
						flatFile.append("DEL:").append(sriLankaManifestTransmitVO.getDelCd()).append("\n");

						sriLankaSearchPrePortVOs = dbDao.searchPrePort(sriLankaManifestTransmitVO);
						if (sriLankaSearchPrePortVOs != null && sriLankaSearchPrePortVOs.size() > 0) {
							flatFile.append("PREVPORT:").append(sriLankaSearchPrePortVOs.get(0).getVpsPortCd()).append("\n");
						}
						else {
							flatFile.append("PREVPORT:").append("\n");
						}

						sriLankaSearchEtaVOs = dbDao.searchEta(sriLankaManifestTransmitVO);
						if (sriLankaSearchEtaVOs != null && sriLankaSearchEtaVOs.size() > 0) {
							flatFile.append("ETA:").append(sriLankaSearchEtaVOs.get(0).getVpsEtaDt()).append("\n");
						}
						else {
							flatFile.append("ETA:").append("\n");
						}

						sriLankaSearchEtdVOs = dbDao.searchEtd(sriLankaManifestTransmitVO);
						if (sriLankaSearchEtdVOs != null && sriLankaSearchEtdVOs.size() > 0) {
							flatFile.append("ETD:").append(sriLankaSearchEtdVOs.get(0).getVpsEtdDt()).append("\n");
						}
						else {
							flatFile.append("ETD:").append("\n");
						}
						flatFile.append("PORT_REG_NO:").append(sriLankaManifestTransmitVO.getRegNo()).append("\n");
					}

					sriLankaSearchBkgNoVOs = dbDao.searchBkgNo(sriLankaManifestTransmitVO);
					if (sriLankaSearchBkgNoVOs != null && sriLankaSearchBkgNoVOs.size() > 0) {
						for (int m = 0; m < sriLankaSearchBkgNoVOs.size(); m++) {
							sriLankaManifestTransmitVO.setBkgNo(sriLankaSearchBkgNoVOs.get(m).getBkgNo());
							sriLankaManifestTransmitVO.setCgoTp(sriLankaSearchBkgNoVOs.get(m).getBkgCgoTpCd());
							sriLankaSearchBlGeneralVOs = dbDao.searchBlGeneral(sriLankaManifestTransmitVO);
							if (sriLankaSearchBlGeneralVOs != null && sriLankaSearchBlGeneralVOs.size() > 0) {
								for (int n = 0; n < sriLankaSearchBlGeneralVOs.size(); n++) {
									StringTokenizer token = new StringTokenizer(sriLankaSearchBlGeneralVOs.get(n).getBlDesc(), "\n");
									ArrayList tmpArray = new ArrayList();
									while (token.hasMoreTokens()) {
										tmpArray.add(token.nextToken());
									}
									for (int mm = 0; mm < tmpArray.size(); mm++) {
										flatFile.append(tmpArray.get(mm).toString());
										flatFile.append("\n");
									}
									srilankaSearchContainerVOs = dbDao.searchContainer(sriLankaManifestTransmitVO);
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
									srilankaSearchBlMarkDescVOs = dbDao.searchBlMarkDesc(sriLankaManifestTransmitVO);
									if (srilankaSearchBlMarkDescVOs != null && srilankaSearchBlMarkDescVOs.size() > 0) {
										for (int q = 0; q < srilankaSearchBlMarkDescVOs.size(); q++) {
											token = new StringTokenizer(srilankaSearchBlMarkDescVOs.get(q).getCmdtDesc(), "\n");
											tmpArray = new ArrayList();
											while (token.hasMoreTokens()) {
												tmpArray.add(token.nextToken());
											}
											for (int mm = 0; mm < tmpArray.size(); mm++) {
												flatFile.append(tmpArray.get(mm).toString());
												flatFile.append("\n");
											}
											token = new StringTokenizer(srilankaSearchBlMarkDescVOs.get(q).getMkDesc(), "\n");
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
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_SLKMFT.IBMMQ.QUEUE"));

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
	 * save Send Date and create FlatFile after retrieve Vessel Arrival data for report SriLanka Customs -- UI_BKG-0493
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
			if (sriLankaSearchMakeHeaderVesselVOs != null) {
				SriLankaSearchMakeHeaderVesselVO sriLankaSearchMakeHeaderVesselVO;
				for (int i = 0; i < sriLankaSearchMakeHeaderVesselVOs.size(); i++) {
					sriLankaSearchMakeHeaderVesselVO = sriLankaSearchMakeHeaderVesselVOs.get(i);
					flatFile.append(sriLankaSearchMakeHeaderVesselVO.getMsgHeader()).append("\n");
				}
			}
			sriLankaSearchVesselArrivalVOs = dbDao.searchVesselArrival(sriLankaVesselArrivalTransmitVO.getVslCd(), sriLankaVesselArrivalTransmitVO.getSkdVoyNo(), sriLankaVesselArrivalTransmitVO.getSkdDirCd(), sriLankaVesselArrivalTransmitVO.getPolCd());
			if (sriLankaSearchVesselArrivalVOs != null) {

				for (int i = 0; i < sriLankaSearchVesselArrivalVOs.size(); i++) {
					flatFile.append("FILE_NAME:").append(sriLankaSearchVesselArrivalVOs.get(i).getFileName()).append(
							"\n");
					flatFile.append("VSL_FULLNAME:").append(sriLankaSearchVesselArrivalVOs.get(i).getVslFullname()).append("\n");
					flatFile.append("VOYAGE_CODE:").append(sriLankaSearchVesselArrivalVOs.get(i).getVoyageCode()).append("\n");
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
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_SLKMSG.IBMMQ.QUEUE"));

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
	 * RECEIVE FLAT FILE creates at Log Table
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