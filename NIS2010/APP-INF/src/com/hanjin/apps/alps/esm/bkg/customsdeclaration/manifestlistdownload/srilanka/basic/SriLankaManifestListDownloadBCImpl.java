/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SriLankaManifestListDownloadBCImpl.java
 *@FileTitle : UI_BKG-0490
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.04
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration.SriLankaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.BkgCstmsSriVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCaptainNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCntrListTempVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchEtdDtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchEtdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchManifestVpsVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchRegNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchRegistNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchResponseVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselRegistNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselVpsVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVsselNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author LIM JAE TAEK
 * @see EventResponse,SriLankaManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SriLankaManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient SriLankaManifestListDownloadDBDAO dbDao = null;

	/**
	 * SriLankaManifestListDownloadBCImpl 객체 생성<br>
	 * SriLankaManifestListDownloadBCImpl 생성한다.<br>
	 */
	public SriLankaManifestListDownloadBCImpl() {
		dbDao = new SriLankaManifestListDownloadDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 * SriLanka 세관에 신고할 대상 VesselArrival 정보 데이터를 조회한다 VVD, POD, DEL, Last Call Port 로 ManifestVps, Etd Date, Vessel<br>
	 * Name, VrnNo, Response, BL List, Container List 정보를 조회한다.<br>
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
		SriLankaSearchManifestVpsVO sriLankaSearchManifestVpsVO = null;
		SriLankaSearchEtdDtVO sriLankaSearchEtdDtVO = null;
		SriLankaSearchVsselNameVO sriLankaSearchVsselNameVO = null;
		SriLankaSearchRegistNoVO sriLankaSearchRegistNoVO = null;
		SriLankaSearchResponseVO sriLankaSearchResponseVO = null;

		List<SriLankaSearchCntrListTempVO> sriLankaSearchCntrListTempVOs = new ArrayList<SriLankaSearchCntrListTempVO>();

		try {
			String vslCd = sriLankaManifestListCondVO.getVslCd();
			String skdVoyNo = sriLankaManifestListCondVO.getSkdVoyNo();
			String skdDirCd = sriLankaManifestListCondVO.getSkdDirCd();
//			String callPort = sriLankaManifestListCondVO.getCallPort();
			List<SriLankaSearchManifestVpsVO> sriLankaSearchManifestVpsVOs = dbDao.searchManifestVps(sriLankaManifestListCondVO);
			if (sriLankaSearchManifestVpsVOs.size() > 0) {
				sriLankaSearchManifestVpsVO = (SriLankaSearchManifestVpsVO) sriLankaSearchManifestVpsVOs.get(0);
				sriLankaContainerVO.setSriLankaSearchManifestVpsVO(sriLankaSearchManifestVpsVO);
			}
			List<SriLankaSearchEtdDtVO> sriLankaSearchEtdDtVOs = dbDao.searchEtdDt(sriLankaManifestListCondVO);
			if (sriLankaSearchEtdDtVOs.size() > 0) {
				sriLankaSearchEtdDtVO = (SriLankaSearchEtdDtVO) sriLankaSearchEtdDtVOs.get(0);
				sriLankaContainerVO.setSriLankaSearchEtdDtVO(sriLankaSearchEtdDtVO);
			}

			List<SriLankaSearchVsselNameVO> sriLankaSearchVsselNameVOs = dbDao.searchVesselName(vslCd);
			if (sriLankaSearchVsselNameVOs.size() > 0) {
				sriLankaSearchVsselNameVO = (SriLankaSearchVsselNameVO) sriLankaSearchVsselNameVOs.get(0);
				sriLankaContainerVO.setSriLankaSearchVsselNameVO(sriLankaSearchVsselNameVO);
			}
			String vslNm = "";
			if (sriLankaSearchVsselNameVOs != null && sriLankaSearchVsselNameVOs.size() > 0) {
				vslNm = sriLankaSearchVsselNameVOs.get(0).getVslEngNm();
				List<SriLankaSearchRegistNoVO> sriLankaSearchRegistNoVOs = dbDao.searchRegistNo(vslNm, skdVoyNo,skdDirCd);
				if (sriLankaSearchRegistNoVOs.size() > 0) {
					sriLankaSearchRegistNoVO = (SriLankaSearchRegistNoVO) sriLankaSearchRegistNoVOs.get(0);
					sriLankaContainerVO.setSriLankaSearchRegistNoVO(sriLankaSearchRegistNoVO);
				}
			}
			List<SriLankaSearchResponseVO> sriLankaSearchResponseVOs = dbDao.searchResponse(vslNm, skdVoyNo, skdDirCd,"1", "M");
			if (sriLankaSearchResponseVOs != null && sriLankaSearchResponseVOs.size() > 0) {
				if (sriLankaSearchResponseVOs.size() > 0) {
					sriLankaSearchResponseVO = (SriLankaSearchResponseVO) sriLankaSearchResponseVOs.get(0);
					sriLankaContainerVO.setSriLankaSearchResponseVO(sriLankaSearchResponseVO);
				}
			} else {
				if(sriLankaSearchResponseVOs != null){
					sriLankaSearchResponseVOs.removeAll(sriLankaSearchResponseVOs);					
				}
				sriLankaSearchResponseVOs = dbDao.searchResponse(vslNm, skdVoyNo, skdDirCd, "2", "M");
				if (sriLankaSearchResponseVOs.size() > 0) {
					sriLankaSearchResponseVO = (SriLankaSearchResponseVO) sriLankaSearchResponseVOs.get(0);
					sriLankaContainerVO.setSriLankaSearchResponseVO(sriLankaSearchResponseVO);
				}
			}
			List<SriLankaSearchBlListVO> sriLankaSearchBlListVOs = dbDao.searchBlList(sriLankaManifestListCondVO);

			if (sriLankaSearchBlListVOs != null && sriLankaSearchBlListVOs.size() > 0) {
				String blNumber = sriLankaSearchBlListVOs.get(0).getBlNo();
				int seqNumber = 1;
				for (int i = 0; i < sriLankaSearchBlListVOs.size(); i++) {
					if (sriLankaSearchBlListVOs.get(i).getBlNo().equals(blNumber)) {
						sriLankaSearchBlListVOs.get(i).setSeq(seqNumber + "");
					} else {
						blNumber = sriLankaSearchBlListVOs.get(i).getBlNo();
						sriLankaSearchBlListVOs.get(i).setSeq(++seqNumber + "");
					}
				}
			}

			sriLankaContainerVO.setSriLankaSearchBlListVOs(sriLankaSearchBlListVOs);
			int totCntr = 0;
			if (sriLankaSearchBlListVOs != null && sriLankaSearchBlListVOs.size() > 0) {
				SriLankaSearchCntrListTempVO tempvo = null;
				for (int i = 0; i < sriLankaSearchBlListVOs.size(); i++) {

					List<SriLankaSearchCntrListVO> sriLankaSearchCntrListVOs = dbDao
							.searchCntrList(sriLankaSearchBlListVOs.get(i).getBkgNo().toString(),sriLankaSearchBlListVOs.get(i).getPolCd().toString());
					if (sriLankaSearchCntrListVOs != null && sriLankaSearchCntrListVOs.size() > 0) {
						for (int j = 0; j < sriLankaSearchCntrListVOs.size(); j++) {
							tempvo = new SriLankaSearchCntrListTempVO();
							if (j == 0) {
								int cntrCount = Integer.parseInt(sriLankaSearchCntrListVOs.get(j).getBlTotal()
										.toString());
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
							tempvo.setDelCd(sriLankaSearchCntrListVOs.get(j).getDelCd());
							tempvo.setPolCd(sriLankaSearchCntrListVOs.get(j).getPolCd());
							tempvo.setPodCd(sriLankaSearchBlListVOs.get(i).getPodCd());
							tempvo.setVvdPod(sriLankaSearchBlListVOs.get(i).getVvdPod());
							tempvo.setVvdPol(sriLankaSearchBlListVOs.get(i).getVvdPol());
							// tempvo.setBlTotal(sriLankaSearchCntrListVOs.get(j).getBlTotal());
							sriLankaSearchCntrListTempVOs.add(tempvo);
						}
					}
				}
				if (sriLankaSearchCntrListTempVOs != null && sriLankaSearchCntrListTempVOs.size() > 0) {
					sriLankaSearchCntrListTempVOs.get(0).setBlTotal(String.valueOf(totCntr));
				}
			}
			if (sriLankaSearchCntrListTempVOs != null && sriLankaSearchCntrListTempVOs.size() > 0) {
				String blNumber = sriLankaSearchCntrListTempVOs.get(0).getBlNo();
				int seqNumber = 1;
				for (int i = 0; i < sriLankaSearchCntrListTempVOs.size(); i++) {
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
	 * 조회 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 * SriLanka 세관에 신고할 대상 VesselArrival 정보 데이터를 조회한다.<br>
	 * 
	 * @param vesselArrivalCondVO VesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 * @exception EventException
	 */

	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO)
			throws EventException {
		SriLankaVesselArrivalCondVO sriLankaVesselArrivalCondVO = (SriLankaVesselArrivalCondVO) vesselArrivalCondVO;
		List<VesselArrivalDetailVO> vesselArrivalVO = new ArrayList<VesselArrivalDetailVO>();
		SriLankaSearchVsselNameVO sriLankaSearchVsselNameVO = null;
		SriLankaVesselArrivalDetailVO sriLankaVesselArrivalDetailVO = new SriLankaVesselArrivalDetailVO();

		try {
			String vslCd = sriLankaVesselArrivalCondVO.getVslCd();
			String skdVoyNo = sriLankaVesselArrivalCondVO.getSkdVoyNo();
			String skdDirCd = sriLankaVesselArrivalCondVO.getSkdDirCd();
//			String podCd = sriLankaVesselArrivalCondVO.getPodCd();
//			String callPort = sriLankaVesselArrivalCondVO.getCallPort();
			String vslRgstNo = "";
			List<SriLankaSearchRegNoVO> sriLankaSearchRegNoVOs = dbDao.searchRegNo(sriLankaVesselArrivalCondVO);
			if (sriLankaSearchRegNoVOs != null && sriLankaSearchRegNoVOs.size() > 0) {
				for (int i = 0; i < sriLankaSearchRegNoVOs.size(); i++) {
					sriLankaVesselArrivalDetailVO.setVslRgstNo(sriLankaSearchRegNoVOs.get(i).getVslRgstNo());
					vslRgstNo = sriLankaSearchRegNoVOs.get(i).getVslRgstNo();
					sriLankaVesselArrivalCondVO.setVslRgstNo(sriLankaSearchRegNoVOs.get(i).getVslRgstNo());
				}
			} else {
				List<SriLankaSearchVesselRegistNoVO> sriLankaSearchVesselRegistNoVOs = dbDao.searchVesselRegistNo();
				for (int i = 0; i < sriLankaSearchVesselRegistNoVOs.size(); i++) {
					sriLankaVesselArrivalDetailVO.setVslRgstNo(sriLankaSearchVesselRegistNoVOs.get(i)
							.getVesselRegistNo());
				}
			}
			List<SriLankaSearchVesselVpsVO> sriLankaSearchVesselVpsVOs = dbDao.searchVesselVps(sriLankaVesselArrivalCondVO);
			if (sriLankaSearchVesselVpsVOs != null && sriLankaSearchVesselVpsVOs.size() > 0) {
				for (int i = 0; i < sriLankaSearchVesselVpsVOs.size(); i++) {
					sriLankaVesselArrivalDetailVO.setVpsEtaDt(sriLankaSearchVesselVpsVOs.get(i).getVpsEtaDt());
					sriLankaVesselArrivalDetailVO.setVpsEtaDtTime(sriLankaSearchVesselVpsVOs.get(i).getVpsEtaDtTime());
					sriLankaVesselArrivalDetailVO.setArrivalPort(sriLankaSearchVesselVpsVOs.get(i).getArrivalPortCd());
					sriLankaVesselArrivalDetailVO.setDepaturePort(sriLankaSearchVesselVpsVOs.get(i).getDepaturePort());
					sriLankaVesselArrivalDetailVO.setVslNm(sriLankaSearchVesselVpsVOs.get(i).getShippingAgent());
					sriLankaVesselArrivalDetailVO.setVslNm2(sriLankaSearchVesselVpsVOs.get(i).getLocalAgent());
				}
			}
			List<SriLankaSearchEtdVO> sriLankaSearchEtdVOs = dbDao.searchEtd(sriLankaVesselArrivalCondVO);
			if (sriLankaSearchEtdVOs != null && sriLankaSearchEtdVOs.size() > 0) {
				for (int i = 0; i < sriLankaSearchEtdVOs.size(); i++) {
					sriLankaVesselArrivalDetailVO.setVpsEtdDt(sriLankaSearchEtdVOs.get(i).getVpsEtdDt());
					sriLankaVesselArrivalDetailVO.setVpsEtdDtTime(sriLankaSearchEtdVOs.get(i).getVpsEtdDtTime());
				}
			}
			List<SriLankaSearchVsselNameVO> sriLankaSearchVsselNameVOs = dbDao.searchVesselName(vslCd);
			if (sriLankaSearchVsselNameVOs != null && sriLankaSearchVsselNameVOs.size() > 0) {
				for (int i = 0; i < sriLankaSearchVsselNameVOs.size(); i++) {
					sriLankaVesselArrivalDetailVO.setVslEngNm(sriLankaSearchVsselNameVOs.get(i).getVslEngNm());
					sriLankaVesselArrivalDetailVO.setVslRgstCntCd(sriLankaSearchVsselNameVOs.get(i).getVslRgstCntCd());
				}
			}
			String vslNm = "";
			if (sriLankaSearchVsselNameVOs != null && sriLankaSearchVsselNameVOs.size() > 0) {
				sriLankaSearchVsselNameVO = (SriLankaSearchVsselNameVO) sriLankaSearchVsselNameVOs.get(0);
				vslNm = sriLankaSearchVsselNameVO.getVslEngNm();
			}
			List<SriLankaSearchCaptainNameVO> sriLankaSearchCaptainNameVOs = dbDao.searchCaptainName(sriLankaVesselArrivalCondVO);
			if (sriLankaSearchCaptainNameVOs != null && sriLankaSearchCaptainNameVOs.size() > 0) {
				for (int i = 0; i < sriLankaSearchCaptainNameVOs.size(); i++) {
					sriLankaVesselArrivalDetailVO.setCapNm(sriLankaSearchCaptainNameVOs.get(i).getCapNm());
					sriLankaVesselArrivalDetailVO.setCstmsVvdCd(sriLankaSearchCaptainNameVOs.get(i).getCstmsVvdCd());
					sriLankaVesselArrivalDetailVO.setMsgRefNo(sriLankaSearchCaptainNameVOs.get(i).getMsgRefNo());
				}
			}

			List<SriLankaSearchResponseVO> sriLankaSearchResponseVOs = dbDao.searchResponse(vslNm, skdVoyNo, skdDirCd,"1", "V");
			sriLankaVesselArrivalDetailVO.setSrCmtDesc("");
			sriLankaVesselArrivalDetailVO.setRjctDt("");
			sriLankaVesselArrivalDetailVO.setRgstDt("");
			sriLankaVesselArrivalDetailVO.setVslAuthNo("");
			sriLankaVesselArrivalDetailVO.setSrStsCd("");
			sriLankaVesselArrivalDetailVO.setSrStsDesc("");
			sriLankaVesselArrivalDetailVO.setDeclBlQty("");
			if (sriLankaSearchResponseVOs != null && sriLankaSearchResponseVOs.size() > 0) {
				if (sriLankaSearchResponseVOs.size() > 0) {
					for (int i = 0; i < sriLankaSearchResponseVOs.size(); i++) {
						sriLankaVesselArrivalDetailVO.setSrCmtDesc(sriLankaSearchResponseVOs.get(i).getSrCmtDesc());
						sriLankaVesselArrivalDetailVO.setRjctDt(sriLankaSearchResponseVOs.get(i).getRjctDt());
						sriLankaVesselArrivalDetailVO.setRgstDt(sriLankaSearchResponseVOs.get(i).getRgstDt());
						sriLankaVesselArrivalDetailVO.setVslAuthNo(sriLankaSearchResponseVOs.get(i).getVslAuthNo());
						sriLankaVesselArrivalDetailVO.setSrStsCd(sriLankaSearchResponseVOs.get(i).getSrStsCd());
						sriLankaVesselArrivalDetailVO.setSrStsDesc(sriLankaSearchResponseVOs.get(i).getSrStsDesc());
						sriLankaVesselArrivalDetailVO.setDeclBlQty(sriLankaSearchResponseVOs.get(i).getDeclBlQty());
					}
				}
			} else {
				if(sriLankaSearchResponseVOs != null){
					sriLankaSearchResponseVOs.removeAll(sriLankaSearchResponseVOs);
				}				
				sriLankaSearchResponseVOs = dbDao.searchResponse(vslNm, skdVoyNo, skdDirCd, "2", "V");
				if (sriLankaSearchResponseVOs.size() > 0) {
					for (int i = 0; i < sriLankaSearchResponseVOs.size(); i++) {
						sriLankaVesselArrivalDetailVO.setSrCmtDesc(sriLankaSearchResponseVOs.get(i).getSrCmtDesc());
						sriLankaVesselArrivalDetailVO.setRjctDt(sriLankaSearchResponseVOs.get(i).getRjctDt());
						sriLankaVesselArrivalDetailVO.setRgstDt(sriLankaSearchResponseVOs.get(i).getRgstDt());
						sriLankaVesselArrivalDetailVO.setVslAuthNo(sriLankaSearchResponseVOs.get(i).getVslAuthNo());
						sriLankaVesselArrivalDetailVO.setSrStsCd(sriLankaSearchResponseVOs.get(i).getSrStsCd());
						sriLankaVesselArrivalDetailVO.setSrStsDesc(sriLankaSearchResponseVOs.get(i).getSrStsDesc());
						sriLankaVesselArrivalDetailVO.setDeclBlQty(sriLankaSearchResponseVOs.get(i).getDeclBlQty());
					}
				}
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
	 * 스리랑카세관 신고용 Vessel Arrival 정보를 생성 및 수정한다.<br>
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
			bkgCstmsSriVvdVO.setIoBndCd(sriLankaVesselArrivalVO.getIoBndCd());
			bkgCstmsSriVvdVO.setVslRgstNo(sriLankaVesselArrivalVO.getVslRgstNo());
			bkgCstmsSriVvdVO.setVslCd(sriLankaVesselArrivalVO.getVslCd());
			bkgCstmsSriVvdVO.setSkdVoyNo(sriLankaVesselArrivalVO.getSkdVoyNo());
			bkgCstmsSriVvdVO.setSkdDirCd(sriLankaVesselArrivalVO.getSkdDirCd());
//			bkgCstmsSriVvdVO.setPortCd(sriLankaVesselArrivalVO.getArrivalPort());
			bkgCstmsSriVvdVO.setPortCd(sriLankaVesselArrivalVO.getPortCd());
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
			bkgCstmsSriVvdVO.setCstmsVvdCd(sriLankaVesselArrivalVO.getCstmsVvdCd());
			bkgCstmsSriVvdVO.setMsgRefNo(sriLankaVesselArrivalVO.getMsgRefNo());
			bkgCstmsSriVvdVO.setUserId(account.getUsr_id());
			
//			String vslCd = sriLankaVesselArrivalVO.getVslCd();
//			String skdVoyNo = sriLankaVesselArrivalVO.getSkdVoyNo();
//			String skdDirCd = sriLankaVesselArrivalVO.getSkdDirCd();
//			String podCd = sriLankaVesselArrivalVO.getArrivalPort();
//			String vslRgstNo = sriLankaVesselArrivalVO.getVslRgstNo();
//			String ioBndCd = sriLankaVesselArrivalVO.getIoBndCd();
			
			
			List<SriLankaSearchVesselArrivalVO> sriLankaSearchVesselArrivalVOs = dbDao.searchVesselArrival(sriLankaVesselArrivalVO );
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
	 * 스리랑카세관 Vessel Arrival 전송정보를 저장한다.<br>
	 * 
	 * @param VesselArrivalTransmitVO VesselArrivalTransmitVO
	 * @throws EventException
	 * @exception EventException
	 */
	public void modifySendDt(VesselArrivalTransmitVO VesselArrivalTransmitVO) throws EventException {
		SriLankaVesselArrivalTransmitVO sriLankaVesselArrivalTransmitVO = (SriLankaVesselArrivalTransmitVO) VesselArrivalTransmitVO;
		try {
			dbDao.modifySendDt(sriLankaVesselArrivalTransmitVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getUserMessage());
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getUserMessage());
		}
	}	

}
