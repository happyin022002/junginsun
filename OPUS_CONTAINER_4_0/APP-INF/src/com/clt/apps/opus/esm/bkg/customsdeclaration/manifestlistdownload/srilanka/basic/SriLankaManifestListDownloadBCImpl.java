/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SriLankaManifestListDownloadBCImpl.java
 *@FileTitle : UI_BKG-0490
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaVesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration.SriLankaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.BkgCstmsSriVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchBlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCaptainNameVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCntrListTempVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchEtdDtVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchEtdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchManifestVpsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchRegNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchRegistNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchResponseVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselRegistNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselVpsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVsselNameVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-SriLankaManifestListDownload Business Logic Command implementation<br>
 * - OPUS-SriLankaManifestListDownload handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class SriLankaManifestListDownloadBCImpl extends BasicCommandSupport implements SriLankaManifestListDownloadBC {
	// Database Access Object
	private transient SriLankaManifestListDownloadDBDAO dbDao = null;

	/**
	 * SriLankaManifestListDownloadBCImpl objects creation<br>
	 * SriLankaManifestListDownloadBCImpl creation<br>
	 */
	public SriLankaManifestListDownloadBCImpl() {
		dbDao = new SriLankaManifestListDownloadDBDAO();
	}

	/**
	 * Searching the Manifest list for SriLanka Customs<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		SriLankaManifestListCondVO sriLankaManifestListCondVO = (SriLankaManifestListCondVO) manifestListCondVO;
		List<ManifestListDetailVO> manifestListVO = new ArrayList<ManifestListDetailVO>();
		SriLankaContainerVO sriLankaContainerVO = new SriLankaContainerVO();
		String vslNm = "";

		List<SriLankaSearchCntrListTempVO> sriLankaSearchCntrListTempVOs = new ArrayList<SriLankaSearchCntrListTempVO>();

		try {
			String vslCd = sriLankaManifestListCondVO.getVslCd();
			String skdVoyNo = sriLankaManifestListCondVO.getSkdVoyNo();
			String skdDirCd = sriLankaManifestListCondVO.getSkdDirCd();
			String podCd = sriLankaManifestListCondVO.getPodCd();
			String delCd = sriLankaManifestListCondVO.getDelCd();
			String callPort = sriLankaManifestListCondVO.getCallPort();

			List<SriLankaSearchManifestVpsVO> sriLankaSearchManifestVpsVOs = dbDao.searchManifestVps(vslCd, skdVoyNo, skdDirCd);
			if (sriLankaSearchManifestVpsVOs.size() > 0) {
				sriLankaContainerVO.setSriLankaSearchManifestVpsVO(sriLankaSearchManifestVpsVOs.get(0));
			}

			List<SriLankaSearchEtdDtVO> sriLankaSearchEtdDtVOs = dbDao.searchEtdDt(vslCd, skdVoyNo, skdDirCd, callPort);
			if (sriLankaSearchEtdDtVOs.size() > 0) {
				sriLankaContainerVO.setSriLankaSearchEtdDtVO(sriLankaSearchEtdDtVOs.get(0));
			}

			List<SriLankaSearchVsselNameVO> sriLankaSearchVsselNameVOs = dbDao.searchVesselName(vslCd);
			if (sriLankaSearchVsselNameVOs.size() > 0) {
				sriLankaContainerVO.setSriLankaSearchVsselNameVO(sriLankaSearchVsselNameVOs.get(0));
				vslNm = sriLankaSearchVsselNameVOs.get(0).getVslEngNm();
				List<SriLankaSearchRegistNoVO> sriLankaSearchRegistNoVOs = dbDao.searchRegistNo(vslNm, skdVoyNo, skdDirCd);
				if (sriLankaSearchRegistNoVOs.size() > 0) {
					sriLankaContainerVO.setSriLankaSearchRegistNoVO(sriLankaSearchRegistNoVOs.get(0));
				}
			}

			List<SriLankaSearchResponseVO> sriLankaSearchResponseVOs = dbDao.searchResponse(vslNm, skdVoyNo, skdDirCd, "1", "M");
			if (sriLankaSearchResponseVOs.size() > 0) {
				sriLankaSearchResponseVOs = dbDao.searchResponse(vslNm, skdVoyNo, skdDirCd, "2", "M");
			}
			sriLankaContainerVO.setSriLankaSearchResponseVO(sriLankaSearchResponseVOs.get(0));

			List<SriLankaSearchBlListVO> sriLankaSearchBlListVOs = dbDao.searchBlList(vslCd, skdVoyNo, skdDirCd, podCd, delCd);
			if (sriLankaSearchBlListVOs.size() > 0) {
				String blNumber = sriLankaSearchBlListVOs.get(0).getBlNo();
				int seqNumber = 1;
				for (int i=0; i<sriLankaSearchBlListVOs.size(); i++) {
					if (sriLankaSearchBlListVOs.get(i).getBlNo().equals(blNumber)) {
						sriLankaSearchBlListVOs.get(i).setSeq(seqNumber + "");
					} else {
						blNumber = sriLankaSearchBlListVOs.get(i).getBlNo();
						sriLankaSearchBlListVOs.get(i).setSeq(++seqNumber + "");
					}
				}

				sriLankaContainerVO.setSriLankaSearchBlListVOs(sriLankaSearchBlListVOs);

				int totCntr = 0;
				if (sriLankaSearchBlListVOs.size() > 0) {
					SriLankaSearchCntrListTempVO tempvo = new SriLankaSearchCntrListTempVO();
					for (int i=0; i<sriLankaSearchBlListVOs.size(); i++) {
						List<SriLankaSearchCntrListVO> sriLankaSearchCntrListVOs = dbDao.searchCntrList(sriLankaSearchBlListVOs.get(i).getBkgNo().toString());
						if (sriLankaSearchCntrListVOs.size() > 0) {
							for (int j=0; j<sriLankaSearchCntrListVOs.size(); j++) {
								tempvo = new SriLankaSearchCntrListTempVO();
								if (j == 0) {
									int cntrCount = Integer.parseInt(sriLankaSearchCntrListVOs.get(j).getBlTotal().toString());
									totCntr = totCntr + cntrCount;
								}
								tempvo.setCntrNo(sriLankaSearchCntrListVOs.get(j).getCntrNo());
								tempvo.setCntrSealNo(sriLankaSearchCntrListVOs.get(j).getCntrSealNo());
								tempvo.setCntrTpszCd(sriLankaSearchCntrListVOs.get(j).getCntrTpszCd());
								tempvo.setCntrWgt(sriLankaSearchCntrListVOs.get(j).getCntrWgt());
								tempvo.setMeasQty(sriLankaSearchCntrListVOs.get(j).getMeasQty());
								tempvo.setMeasUtCd(sriLankaSearchCntrListVOs.get(j).getMeasUtCd());
								tempvo.setPckQty(sriLankaSearchCntrListVOs.get(j).getPckQty());
								tempvo.setPckTpCd(sriLankaSearchCntrListVOs.get(j).getPckTpCd());
								tempvo.setWgtUtCd(sriLankaSearchCntrListVOs.get(j).getWgtUtCd());
								tempvo.setBlNo(sriLankaSearchCntrListVOs.get(j).getBlNo());
								sriLankaSearchCntrListTempVOs.add(tempvo);
							}
						}
					}
					sriLankaSearchCntrListTempVOs.get(0).setBlTotal(String.valueOf(totCntr));
				}
			}

			if (sriLankaSearchCntrListTempVOs.size() > 0) {
				String blNumber = sriLankaSearchCntrListTempVOs.get(0).getBlNo();
				int seqNumber = 1;
				for (int i=0; i<sriLankaSearchCntrListTempVOs.size(); i++) {
					if (sriLankaSearchCntrListTempVOs.get(i).getBlNo().equals(blNumber)) {
						sriLankaSearchCntrListTempVOs.get(i).setSeq(seqNumber + "");
					} else {
						blNumber = sriLankaSearchCntrListTempVOs.get(i).getBlNo();
						sriLankaSearchCntrListTempVOs.get(i).setSeq(++seqNumber + "");
					}
				}
			}
			sriLankaContainerVO.setSriLankaSearchCntrListTempVOs(sriLankaSearchCntrListTempVOs);
			manifestListVO.add((ManifestListDetailVO) sriLankaContainerVO);

			return manifestListVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getUserMessage());
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getUserMessage());
		}
	}

	/**
	 * Searching the Vessel Arrival Info for SriLanka Customs Manifest<br>
	 *
	 * @param vesselArrivalCondVO VesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 * @exception EventException
	 */

	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO) throws EventException {
		SriLankaVesselArrivalCondVO sriLankaVesselArrivalCondVO = (SriLankaVesselArrivalCondVO) vesselArrivalCondVO;
		List<VesselArrivalDetailVO> vesselArrivalVO = new ArrayList<VesselArrivalDetailVO>();
		SriLankaVesselArrivalDetailVO sriLankaVesselArrivalDetailVO = new SriLankaVesselArrivalDetailVO();

		try {
			String vslCd = sriLankaVesselArrivalCondVO.getVslCd();
			String skdVoyNo = sriLankaVesselArrivalCondVO.getSkdVoyNo();
			String skdDirCd = sriLankaVesselArrivalCondVO.getSkdDirCd();
			String podCd = sriLankaVesselArrivalCondVO.getPodCd();
			String callPort = sriLankaVesselArrivalCondVO.getCallPort();
			String vslRgstNo = "";

			List<SriLankaSearchRegNoVO> sriLankaSearchRegNoVOList = dbDao.searchRegNo(vslCd, skdVoyNo, skdDirCd, podCd);
			if (sriLankaSearchRegNoVOList.size() > 0) {
				for (SriLankaSearchRegNoVO sriLankaSearchRegNoVO : sriLankaSearchRegNoVOList) {
					sriLankaVesselArrivalDetailVO.setVslRgstNo(sriLankaSearchRegNoVO.getVslRgstNo());
					vslRgstNo = sriLankaSearchRegNoVO.getVslRgstNo();
				}
			} else {
				for (SriLankaSearchVesselRegistNoVO sriLankaSearchVesselRegistNoVO : dbDao.searchVesselRegistNo()) {
					sriLankaVesselArrivalDetailVO.setVslRgstNo(sriLankaSearchVesselRegistNoVO.getVesselRegistNo());
				}
			}

			for (SriLankaSearchVesselVpsVO sriLankaSearchVesselVpsVO : dbDao.searchVesselVps(vslCd, skdVoyNo, skdDirCd, podCd)) {
				sriLankaVesselArrivalDetailVO.setVpsEtaDt(sriLankaSearchVesselVpsVO.getVpsEtaDt());
				sriLankaVesselArrivalDetailVO.setVpsEtaDtTime(sriLankaSearchVesselVpsVO.getVpsEtaDtTime());
				sriLankaVesselArrivalDetailVO.setArrivalPort(sriLankaSearchVesselVpsVO.getArrivalPortCd());
				sriLankaVesselArrivalDetailVO.setVslNm(sriLankaSearchVesselVpsVO.getShippingAgent());
				sriLankaVesselArrivalDetailVO.setVslNm2(sriLankaSearchVesselVpsVO.getLocalAgent());
			}

			for (SriLankaSearchEtdVO sriLankaSearchEtdVO : dbDao.searchEtd(vslCd, skdVoyNo, skdDirCd, callPort)) {
				sriLankaVesselArrivalDetailVO.setVpsEtdDt(sriLankaSearchEtdVO.getVpsEtdDt());
				sriLankaVesselArrivalDetailVO.setVpsEtdDtTime(sriLankaSearchEtdVO.getVpsEtdDtTime());
			}

			String vslNm = "";
			List<SriLankaSearchVsselNameVO> sriLankaSearchVsselNameVOs = dbDao.searchVesselName(vslCd);
			if (sriLankaSearchVsselNameVOs.size() > 0) {
				vslNm = sriLankaSearchVsselNameVOs.get(0).getVslEngNm();
				for (int i=0; i<sriLankaSearchVsselNameVOs.size(); i++) {
					sriLankaVesselArrivalDetailVO.setVslEngNm(sriLankaSearchVsselNameVOs.get(i).getVslEngNm());
					sriLankaVesselArrivalDetailVO.setVslRgstCntCd(sriLankaSearchVsselNameVOs.get(i).getVslRgstCntCd());
				}
			}

			for (SriLankaSearchCaptainNameVO sriLankaSearchCaptainNameVO : dbDao.searchCaptainName(vslCd, skdVoyNo, skdDirCd, podCd, vslRgstNo)) {
				sriLankaVesselArrivalDetailVO.setCapNm(sriLankaSearchCaptainNameVO.getCapNm());
			}

			sriLankaVesselArrivalDetailVO.setSrCmtDesc("");
			sriLankaVesselArrivalDetailVO.setRjctDt("");
			sriLankaVesselArrivalDetailVO.setRgstDt("");
			sriLankaVesselArrivalDetailVO.setVslAuthNo("");
			sriLankaVesselArrivalDetailVO.setSrStsCd("");
			sriLankaVesselArrivalDetailVO.setSrStsDesc("");
			sriLankaVesselArrivalDetailVO.setDeclBlQty("");

			List<SriLankaSearchResponseVO> sriLankaSearchResponseVOList = dbDao.searchResponse(vslNm, skdVoyNo, skdDirCd, "1", "V");
			if (sriLankaSearchResponseVOList.size() < 1) sriLankaSearchResponseVOList = dbDao.searchResponse(vslNm, skdVoyNo, skdDirCd, "2", "V");
			for (SriLankaSearchResponseVO sriLankaSearchResponseVO : sriLankaSearchResponseVOList) {
				sriLankaVesselArrivalDetailVO.setSrCmtDesc(sriLankaSearchResponseVO.getSrCmtDesc());
				sriLankaVesselArrivalDetailVO.setRjctDt(sriLankaSearchResponseVO.getRjctDt());
				sriLankaVesselArrivalDetailVO.setRgstDt(sriLankaSearchResponseVO.getRgstDt());
				sriLankaVesselArrivalDetailVO.setVslAuthNo(sriLankaSearchResponseVO.getVslAuthNo());
				sriLankaVesselArrivalDetailVO.setSrStsCd(sriLankaSearchResponseVO.getSrStsCd());
				sriLankaVesselArrivalDetailVO.setSrStsDesc(sriLankaSearchResponseVO.getSrStsDesc());
				sriLankaVesselArrivalDetailVO.setDeclBlQty(sriLankaSearchResponseVO.getDeclBlQty());
			}
			vesselArrivalVO.add((VesselArrivalDetailVO) sriLankaVesselArrivalDetailVO);

			return vesselArrivalVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getUserMessage());
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getUserMessage());
		}
	}

	/**
	 * Managing(create/modify) the SriLanka Vessel Arrival Info<br>
	 *
	 * @param VesselArrivalVO vesselArrivalVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 * @exception EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException {
		SriLankaVesselArrivalVO sriLankaVesselArrivalVO = (SriLankaVesselArrivalVO) vesselArrivalVO;
		BkgCstmsSriVvdVO bkgCstmsSriVvdVO = new BkgCstmsSriVvdVO();
		//int ret = 0;
		try {
			bkgCstmsSriVvdVO.setVslRgstNo(sriLankaVesselArrivalVO.getVslRgstNo());
			bkgCstmsSriVvdVO.setVslCd(sriLankaVesselArrivalVO.getVslCd());
			bkgCstmsSriVvdVO.setSkdVoyNo(sriLankaVesselArrivalVO.getSkdVoyNo());
			bkgCstmsSriVvdVO.setSkdDirCd(sriLankaVesselArrivalVO.getSkdDirCd());
			bkgCstmsSriVvdVO.setPortCd(sriLankaVesselArrivalVO.getArrivalPort());
			bkgCstmsSriVvdVO.setVslNm(sriLankaVesselArrivalVO.getVslEngNm());
			bkgCstmsSriVvdVO.setEtaDt(sriLankaVesselArrivalVO.getVpsEtaDt());
			bkgCstmsSriVvdVO.setEtaTime(sriLankaVesselArrivalVO.getVpsEtaDtTime());
			bkgCstmsSriVvdVO.setEtdDt(sriLankaVesselArrivalVO.getVpsEtdDt());
			bkgCstmsSriVvdVO.setEtdTime(sriLankaVesselArrivalVO.getVpsEtdDtTime());
			bkgCstmsSriVvdVO.setCapNm(sriLankaVesselArrivalVO.getCapNm());
			bkgCstmsSriVvdVO.setVslCntCd(sriLankaVesselArrivalVO.getVslRgstCntCd());
			bkgCstmsSriVvdVO.setSvcPrePortCd(sriLankaVesselArrivalVO.getDepaturePort());
			bkgCstmsSriVvdVO.setShpAgnNm(sriLankaVesselArrivalVO.getVslNm());
			bkgCstmsSriVvdVO.setLoclShpAgnNm(sriLankaVesselArrivalVO.getVslNm2());

			bkgCstmsSriVvdVO.setUserId(account.getUsr_id());
			String vslCd = sriLankaVesselArrivalVO.getVslCd();
			String skdVoyNo = sriLankaVesselArrivalVO.getSkdVoyNo();
			String skdDirCd = sriLankaVesselArrivalVO.getSkdDirCd();
			String podCd = sriLankaVesselArrivalVO.getArrivalPort();
			String vslRgstNo = sriLankaVesselArrivalVO.getVslRgstNo();
			List<SriLankaSearchVesselArrivalVO> sriLankaSearchVesselArrivalVOs = dbDao.searchVesselArrival(vslCd, skdVoyNo, skdDirCd, podCd, vslRgstNo);
			if (sriLankaSearchVesselArrivalVOs != null && sriLankaSearchVesselArrivalVOs.size() > 0)
				dbDao.modifyVesselArrival(bkgCstmsSriVvdVO);
			else
				dbDao.addVesselArrival(bkgCstmsSriVvdVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getUserMessage());
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getUserMessage());
		}
	}

	/**
	 * Saving the transmited SriLanka Vessel Arrival Info<br>
	 *
	 * @param VesselArrivalTransmitVO VesselArrivalTransmitVO
	 * @throws EventException
	 * @exception EventException
	 */
	public void modifySendDt(VesselArrivalTransmitVO VesselArrivalTransmitVO) throws EventException {
		SriLankaVesselArrivalTransmitVO sriLankaVesselArrivalTransmitVO = (SriLankaVesselArrivalTransmitVO) VesselArrivalTransmitVO;
		try {
			dbDao.modifySendDt(sriLankaVesselArrivalTransmitVO.getVslCd(), sriLankaVesselArrivalTransmitVO.getSkdVoyNo(), sriLankaVesselArrivalTransmitVO.getSkdDirCd(), sriLankaVesselArrivalTransmitVO.getPolCd());

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getUserMessage());
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getUserMessage());
		}
	}

}
