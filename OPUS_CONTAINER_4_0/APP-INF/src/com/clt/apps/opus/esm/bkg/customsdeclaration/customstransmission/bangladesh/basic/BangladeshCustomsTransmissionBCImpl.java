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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration.BangladeshCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBkgNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBlGeneralVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBlMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchEtaVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchEtdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchFlagVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchPrePortVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lim Jae Taek
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class BangladeshCustomsTransmissionBCImpl extends BasicCommandSupport implements BangladeshCustomsTransmissionBC {

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
	 * @param BangladeshManifestListCondVO bangladeshManifestListCondVO
	 * @param BangladeshManifestTransmitVO[] bangladeshManifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String transmitManifest(BangladeshManifestListCondVO bangladeshManifestListCondVO, BangladeshManifestTransmitVO[] bangladeshManifestTransmitVOs, SignOnUserAccount account) throws EventException {
		StringBuffer flatFile = new StringBuffer();
		BangladeshManifestTransmitVO bangladeshManifestTransmitVO = new BangladeshManifestTransmitVO();
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
			bangladeshManifestTransmitVOs = (BangladeshManifestTransmitVO[])bkgUtil.sortArray(bangladeshManifestTransmitVOs, "blNo");

			// 해더 부분 생성작업
			flatFile.append(bkgUtil.searchCstmsEdiHeaderNew("BD_CUSCAR")).append("\n");

			if (bangladeshManifestTransmitVOs != null) {
				for (int i = 0; i < bangladeshManifestTransmitVOs.length; i++) {
					bangladeshManifestTransmitVO = (BangladeshManifestTransmitVO) bangladeshManifestTransmitVOs[i];

					if (i == 0){
						flatFile.append("VVD:").append(bangladeshManifestTransmitVO.getVvd()).append("\n");
						flatFile.append("CON_VVD:").append(dbDao.getConsVoy(bangladeshManifestListCondVO)).append("\n");

						flatFile.append("VSL_FULLNAME:").append(bangladeshManifestTransmitVO.getVslNm()).append("\n");
//						flatFile.append("VSL_AUTH_NO:").append(bangladeshManifestTransmitVO.getAuthNo()).append("\n");

						bangladeshSearchFlagVOs = dbDao.searchFlag(bangladeshManifestTransmitVO);
						if (bangladeshSearchFlagVOs != null && bangladeshSearchFlagVOs.size() > 0) {
							flatFile.append("VSL_NTL_CD:").append(bangladeshSearchFlagVOs.get(0).getVslCntCd()).append("\n");
							flatFile.append("VSL_REG_CITY:").append(bangladeshSearchFlagVOs.get(0).getCntNm()).append("\n");
							flatFile.append("VSL_IMO_CD:").append(bangladeshSearchFlagVOs.get(0).getVslImoCd()).append("\n");
							flatFile.append("VSL_MASTER_NM: ").append("\n");
						} else {
							flatFile.append("VSL_NTL_CD: ").append("\n");
							flatFile.append("VSL_REG_CITY: ").append("\n");
							flatFile.append("VSL_IMO_CD: ").append("\n");
							flatFile.append("VSL_MASTER_NM: ").append("\n");
						}

						flatFile.append("DEL:").append(bangladeshManifestTransmitVO.getPodCd()).append("\n");

						bangladeshSearchPrePortVOs = dbDao.searchPrePort(bangladeshManifestTransmitVO);
						if (bangladeshSearchPrePortVOs != null && bangladeshSearchPrePortVOs.size() > 0) {
							flatFile.append("PREVPORT:").append(bangladeshSearchPrePortVOs.get(0).getVpsPortCd()).append("\n");
						}
						else {
							flatFile.append("PREVPORT: ").append("\n");
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

			// flatFile MQ로 전송
			// 추후 수정하고 MQ ID 재등록 할 것
			// sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_SLKMFT.IBMMQ.QUEUE"));
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZNYK_SLKMFT.IBMMQ.QUEUE"));

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