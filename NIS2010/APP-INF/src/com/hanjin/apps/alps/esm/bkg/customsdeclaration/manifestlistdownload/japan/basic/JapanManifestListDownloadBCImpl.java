/*=========================================================
 *Copyright(c) 2017 Hi-Plus Card
 *@FileName : JapanManifestListDownloadBCImpl.java
 *@FileTitle : ESM_BKG-0462
 *Open Issues :
 *Change history :
 *	2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러 ( WGT 정수자리수가 7자리 이상인지 체크함. )
 * 	2011.04.13 김영철 [] R4J 메소드 주석 기술부분 보완 ( searchWgtErrBkgNo )
 *	2017.09.07 하대성 2017 Renewal Version Transmit 반영
 *@LastModifyDate : 2017.09.07
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2009.05.18 김승민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanCmfModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetail2VO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBlMdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCmfDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCntrDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListDorListInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListEtcVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListJpcusEtaInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfsDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListVslPortSkdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrCntrModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrCustModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrMndCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrMndContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrMndModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.VpsCallIndInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCntrModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrMndModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsJpBlCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpBlCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpBlMkVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpVslSkdVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpVslVO;

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0462EventResponse,JapanManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {

	// Database Access Object
	private transient JapanManifestListDownloadDBDAO dbDao = null;

	/**
	 * PanamaManifestListDownloadBCImpl 객체 생성<br>
	 * PanamaManifestListDownloadDBDAO 생성한다.<br>
	 */
	public JapanManifestListDownloadBCImpl() {
		dbDao = new JapanManifestListDownloadDBDAO();
	}

	/**
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForDl(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException {
		JapanManifestModificationVO[] japanManifestModificationVOs = (JapanManifestModificationVO[]) manifestModificationVOs;
		List<JapanManifestListBkgInfoVO> japanManifestListBkgInfoVOs = null;
		List<JapanManifestListBkgCorrVO> japanManifestListBkgCorrVOs = null;
		List<JapanManifestListBkgVvdInfoVO> japanManifestListBkgVvdInfoVOs = null;
		List<JapanManifestListBkgQtyVO> japanManifestListBkgQtyVOs = null;
		List<JapanManifestListBkgCustInfoVO> japanManifestListBkgCustInfoVOs = null;
		List<JapanManifestListBlMdVO> japanManifestListBlMdVOs = null;
		List<JapanManifestListBkgCntrInfoVO> japanManifestListBkgCntrInfoVOs = null;
		try {
			for (int i = 0; i < japanManifestModificationVOs.length; i++) {
				String bkgNo = ((JapanManifestModificationVO) japanManifestModificationVOs[i]).getBkgNo();
				String podCd = ((JapanManifestModificationVO) japanManifestModificationVOs[0]).getInPodCd();
				String polCd = ((JapanManifestModificationVO) japanManifestModificationVOs[i]).getPolCd();
				String vvdCd = ((JapanManifestModificationVO) japanManifestModificationVOs[0]).getInVvdCd();
				String loclTsFlg = "";
				String cstmsDesc = "";

				// Booking Main 정보를 조회한다.
				japanManifestListBkgInfoVOs = dbDao.searchBooking(bkgNo);
				if (japanManifestListBkgInfoVOs.get(0).getBdrCngFlg().equals("Y")) {
					// Booking Correction 정보를 조회한다.
					japanManifestListBkgCorrVOs = dbDao.searchBkgCorr2(bkgNo);
				}

				// Booking VVD 정보를 조회한다.
				japanManifestListBkgVvdInfoVOs = dbDao.searchBkgVvd(bkgNo, podCd);
				if (podCd.equals(japanManifestListBkgInfoVOs.get(0).getPodCd())) {
					loclTsFlg = "L";
				} else {
					loclTsFlg = "T";
				}

				float measQty = Float.parseFloat(japanManifestListBkgInfoVOs.get(0).getMeasQty());
				String measQtyString = "";

				if ((measQty + "").indexOf(".") == -1)
					measQtyString = measQty + "";
				else
					measQtyString = (measQty + "").substring(0, (measQty + "").indexOf("."));
				
				if (Integer.parseInt(measQtyString) < 1) {
					// Booking Qty 정보를 조회한다.
					japanManifestListBkgQtyVOs = dbDao.searchBkgQty(bkgNo);
					for (int j = 0; j < japanManifestListBkgQtyVOs.size(); j++) {
						JapanManifestListBkgQtyVO japanManifestListBkgQtyVO = japanManifestListBkgQtyVOs.get(j);
						if (Integer.parseInt(japanManifestListBkgQtyVO.getCntrTpszCd()) < 3) {
							measQty = measQty + (20 * Float.parseFloat(japanManifestListBkgQtyVO.getOpCntrQty()));
						} else {
							measQty = measQty + (40 * Float.parseFloat(japanManifestListBkgQtyVO.getOpCntrQty()));
						}
					}
				}
				String blNo = japanManifestListBkgInfoVOs.get(0).getBlNo();

				// 일본세관 Manifest 신고용 B/L Customer 정보를 삭제한다.
				dbDao.removeJpcusBlCust(blNo);
				// 일본세관 Manifest 신고용 B/L Mask and Description 정보를 삭제한다.
				dbDao.removeJpcusBlMdForDL(blNo);
				// 일본세관 Manifest 신고용 B/L Container 정보를 삭제한다.
				dbDao.removeJpcusBlCntr(blNo);
				// 일본세관 Manifest 신고용 B/L 정보를 삭제한다.
				dbDao.removeJpcusBl(blNo);

				BkgCstmsJpBlVO bkgCstmsJpBlVO = new BkgCstmsJpBlVO();
				bkgCstmsJpBlVO.setBlNo(blNo);
				bkgCstmsJpBlVO.setBlSplitNo("  ");
				bkgCstmsJpBlVO.setVslCd(vvdCd.substring(0, 4));
				bkgCstmsJpBlVO.setSkdVoyNo(vvdCd.substring(4, 8));
				bkgCstmsJpBlVO.setSkdDirCd(vvdCd.substring(8));
				bkgCstmsJpBlVO.setPolCd(polCd);
				bkgCstmsJpBlVO.setPodCd(podCd);
				bkgCstmsJpBlVO.setBkgPorCd(japanManifestListBkgInfoVOs.get(0).getPorCd());
				bkgCstmsJpBlVO.setBkgPolCd(japanManifestListBkgInfoVOs.get(0).getPolCd());
				bkgCstmsJpBlVO.setBkgDelCd(japanManifestListBkgInfoVOs.get(0).getDelCd());
				if (japanManifestListBkgVvdInfoVOs.size() != 0) {
					bkgCstmsJpBlVO.setPstRlyPodCd(japanManifestListBkgVvdInfoVOs.get(0).getPodCd());
					bkgCstmsJpBlVO.setPstVslCd(japanManifestListBkgVvdInfoVOs.get(0).getVvdCd().substring(0, 4));
					bkgCstmsJpBlVO.setPstSkdVoyNo(japanManifestListBkgVvdInfoVOs.get(0).getVvdCd().substring(4, 8));
					bkgCstmsJpBlVO.setPstSkdDirCd(japanManifestListBkgVvdInfoVOs.get(0).getVvdCd().substring(8));
				} //else {
				//	bkgCstmsJpBlVO.setPstRlyPodCd("     ");
				//	bkgCstmsJpBlVO.setPstVslCd("    ");
				//	bkgCstmsJpBlVO.setPstSkdVoyNo("    ");
				//	bkgCstmsJpBlVO.setPstSkdDirCd(" ");
				//}
				bkgCstmsJpBlVO.setPckQty(japanManifestListBkgInfoVOs.get(0).getPckQty());
				bkgCstmsJpBlVO.setPckTpCd(japanManifestListBkgInfoVOs.get(0).getPckTpCd());
				bkgCstmsJpBlVO.setGrsWgt(japanManifestListBkgInfoVOs.get(0).getActWgt());
				bkgCstmsJpBlVO.setWgtUtCd(japanManifestListBkgInfoVOs.get(0).getKgs());
				bkgCstmsJpBlVO.setMeasQty(measQty + "");
				bkgCstmsJpBlVO.setMeasUtCd(japanManifestListBkgInfoVOs.get(0).getCbm());
				bkgCstmsJpBlVO.setRcvTermCd(japanManifestListBkgInfoVOs.get(0).getRcvTermCd());
				bkgCstmsJpBlVO.setDeTermCd(japanManifestListBkgInfoVOs.get(0).getDeTermCd());
				bkgCstmsJpBlVO.setDcgoFlg(japanManifestListBkgInfoVOs.get(0).getDcgoFlg());
				bkgCstmsJpBlVO.setBdrFlg(japanManifestListBkgInfoVOs.get(0).getBdrFlg());
				bkgCstmsJpBlVO.setBdrDt(japanManifestListBkgInfoVOs.get(0).getBrdDt());
				if (japanManifestListBkgCorrVOs != null && japanManifestListBkgCorrVOs.size() != 0) {
					bkgCstmsJpBlVO.setCaDt(japanManifestListBkgCorrVOs.get(0).getCorrDt());
					bkgCstmsJpBlVO.setCaNo(japanManifestListBkgCorrVOs.get(0).getCorrNo());
				}
				// bkgCstmsJpBlVO.setJpBlStsCd("A");
				// bkgCstmsJpBlVO.setIfDt(ifDt);
				bkgCstmsJpBlVO.setLoclTsFlg(loclTsFlg);
				bkgCstmsJpBlVO.setJpCstmsTrnsCd(loclTsFlg);
				bkgCstmsJpBlVO.setFullMtyCd(japanManifestListBkgInfoVOs.get(0).getBkgCgoTpCd());
				bkgCstmsJpBlVO.setCreUsrId(account.getUsr_id());

				// 일본세관 Manifest 신고용 B/L 정보를 생성한다.
				dbDao.addJpcusBl(bkgCstmsJpBlVO);

				

				// Booking Customer 정보를 조회한다.
				japanManifestListBkgCustInfoVOs = dbDao.searchBkgCust(bkgNo);

				for (int j = 0; j < japanManifestListBkgCustInfoVOs.size(); j++) {
					JapanManifestListBkgCustInfoVO japanManifestListBkgCustInfoVO = japanManifestListBkgCustInfoVOs
							.get(j);
					BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
					bkgCstmsJpBlCustVO.setBlNo(japanManifestListBkgCustInfoVO.getBlNo());
					bkgCstmsJpBlCustVO.setBlSplitNo(japanManifestListBkgCustInfoVO.getBlNoSplit());
					bkgCstmsJpBlCustVO.setBkgCustTpCd(japanManifestListBkgCustInfoVO.getBkgCustTpCd());
					bkgCstmsJpBlCustVO.setCustCntCd(japanManifestListBkgCustInfoVO.getCustCntCd());
					bkgCstmsJpBlCustVO.setCustSeq(japanManifestListBkgCustInfoVO.getCustSeq());
					bkgCstmsJpBlCustVO.setCustNm(japanManifestListBkgCustInfoVO.getCustNm().replace("'", "''"));
					bkgCstmsJpBlCustVO.setCustAddr(japanManifestListBkgCustInfoVO.getCustAddr().replace("'", "''"));
					bkgCstmsJpBlCustVO.setPhnNo(japanManifestListBkgCustInfoVO.getPhnNo());
					bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());
					bkgCstmsJpBlCustVO.setPodCd(podCd);
					
					// 일본세관 Manifest 신고용 B/L Customer 정보를 생성한다.
					dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
				}

				// BL CM Descriptin 정보를 조회한다.
				cstmsDesc = dbDao.searchBlCmDesc(bkgNo);
				cstmsDesc = cstmsDesc.replace("'", "''");
				japanManifestListBlMdVOs = dbDao.searchBlMd(bkgNo, cstmsDesc);

				BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO = new BkgCstmsJpBlMkVO();
				if (japanManifestListBlMdVOs.size() == 0) {
					bkgCstmsJpBlMkVO.setBlNo(japanManifestListBkgInfoVOs.get(0).getBlNo());
					bkgCstmsJpBlMkVO.setBlSplitNo("  ");
					bkgCstmsJpBlMkVO.setBlSeq("1");        
					bkgCstmsJpBlMkVO.setDiffRmk("N/M"); 
					bkgCstmsJpBlMkVO.setBlDesc(cstmsDesc.toUpperCase());
					bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id()); 

					// 일본세관 Manifest 신고용 B/L Mark, Description 정보를 생성한다.
					dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);
				} else {
					for (int j = 0; j < japanManifestListBlMdVOs.size(); j++) {
						JapanManifestListBlMdVO japanManifestListBlMdVO = japanManifestListBlMdVOs.get(j);
						bkgCstmsJpBlMkVO.setBlNo(japanManifestListBlMdVO.getBlNo());
						bkgCstmsJpBlMkVO.setBlSplitNo("  ");
						bkgCstmsJpBlMkVO.setBlSeq(japanManifestListBlMdVO.getMkSeq());
						bkgCstmsJpBlMkVO.setDiffRmk(japanManifestListBlMdVO.getMkDesc().replace("'", "''"));
						bkgCstmsJpBlMkVO.setBlDesc(japanManifestListBlMdVO.getCstmsDesc().toUpperCase());
						bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());  

						// 일본세관 Manifest 신고용 B/L Mark, Description 정보를 생성한다.
						dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);
					}
				}

				// Booking Container 정보를 조회한다.
				japanManifestListBkgCntrInfoVOs = dbDao.searchBkgCntr(bkgNo, japanManifestListBkgInfoVOs.get(0)
						.getBkgCgoTpCd());
				
				if (japanManifestListBkgCntrInfoVOs.size() > 200) {
//					int loopCount = (japanManifestListBkgCntrInfoVOs.size() - (japanManifestListBkgCntrInfoVOs.size() % 200)) / 200 + 1;
					int loopCount = (int)Math.ceil((double)japanManifestListBkgCntrInfoVOs.size()/200);
					
					for (int k = 1; k < loopCount; k++) {
						bkgCstmsJpBlVO.setBlNo(blNo);
						bkgCstmsJpBlVO.setBlSplitNo(k + "");
						bkgCstmsJpBlVO.setVslCd(vvdCd.substring(0, 4));
						bkgCstmsJpBlVO.setSkdVoyNo(vvdCd.substring(4, 8));
						bkgCstmsJpBlVO.setSkdDirCd(vvdCd.substring(8));
						bkgCstmsJpBlVO.setPolCd(polCd);
						bkgCstmsJpBlVO.setPodCd(podCd);
						bkgCstmsJpBlVO.setBkgPorCd(japanManifestListBkgInfoVOs.get(0).getPorCd());
						bkgCstmsJpBlVO.setBkgPolCd(japanManifestListBkgInfoVOs.get(0).getPolCd());
						bkgCstmsJpBlVO.setBkgDelCd(japanManifestListBkgInfoVOs.get(0).getDelCd());
						
//						bkgCstmsJpBlVO.setPstRlyPodCd(japanManifestListBkgVvdInfoVOs.get(0).getPodCd());
//						bkgCstmsJpBlVO.setPstVslCd(japanManifestListBkgVvdInfoVOs.get(0).getVvdCd().substring(0, 4));
//						bkgCstmsJpBlVO.setPstSkdVoyNo(japanManifestListBkgVvdInfoVOs.get(0).getVvdCd().substring(4, 8));
//						bkgCstmsJpBlVO.setPstSkdDirCd(japanManifestListBkgVvdInfoVOs.get(0).getVvdCd().substring(8));
						
						bkgCstmsJpBlVO.setPckQty(japanManifestListBkgInfoVOs.get(0).getPckQty());
						bkgCstmsJpBlVO.setPckTpCd(japanManifestListBkgInfoVOs.get(0).getPckTpCd());
						bkgCstmsJpBlVO.setGrsWgt(japanManifestListBkgInfoVOs.get(0).getActWgt());
						bkgCstmsJpBlVO.setWgtUtCd(japanManifestListBkgInfoVOs.get(0).getKgs());
						bkgCstmsJpBlVO.setMeasQty(measQty + "");
						bkgCstmsJpBlVO.setMeasUtCd(japanManifestListBkgInfoVOs.get(0).getCbm());
						bkgCstmsJpBlVO.setRcvTermCd(japanManifestListBkgInfoVOs.get(0).getRcvTermCd());
						bkgCstmsJpBlVO.setDeTermCd(japanManifestListBkgInfoVOs.get(0).getDeTermCd());
						bkgCstmsJpBlVO.setDcgoFlg(japanManifestListBkgInfoVOs.get(0).getDcgoFlg());
						bkgCstmsJpBlVO.setBdrFlg(japanManifestListBkgInfoVOs.get(0).getBdrFlg());
						bkgCstmsJpBlVO.setBdrDt(japanManifestListBkgInfoVOs.get(0).getBrdDt());
						
//						bkgCstmsJpBlVO.setCaDt(japanManifestListBkgCorrVOs.get(0).getCorrDt());
//						bkgCstmsJpBlVO.setCaNo(japanManifestListBkgCorrVOs.get(0).getCorrNo());
						
						// bkgCstmsJpBlVO.setJpBlStsCd("A");
						// bkgCstmsJpBlVO.setIfDt(ifDt);
						bkgCstmsJpBlVO.setLoclTsFlg(loclTsFlg);
						bkgCstmsJpBlVO.setJpCstmsTrnsCd(loclTsFlg);
						bkgCstmsJpBlVO.setFullMtyCd(japanManifestListBkgInfoVOs.get(0).getBkgCgoTpCd());
						bkgCstmsJpBlVO.setCreUsrId(account.getUsr_id());

						// 일본세관 Manifest 신고용 B/L 정보를 생성한다.
						dbDao.addJpcusBl(bkgCstmsJpBlVO);

						for (int j = 0; j < japanManifestListBkgCustInfoVOs.size(); j++) {
							JapanManifestListBkgCustInfoVO japanManifestListBkgCustInfoVO = japanManifestListBkgCustInfoVOs
									.get(j);
							BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
							bkgCstmsJpBlCustVO.setBlNo(japanManifestListBkgCustInfoVO.getBlNo());
							bkgCstmsJpBlCustVO.setBlSplitNo(k + "");
							bkgCstmsJpBlCustVO.setBkgCustTpCd(japanManifestListBkgCustInfoVO.getBkgCustTpCd());
							bkgCstmsJpBlCustVO.setCustCntCd(japanManifestListBkgCustInfoVO.getCustCntCd());
							bkgCstmsJpBlCustVO.setCustSeq(japanManifestListBkgCustInfoVO.getCustSeq());
							bkgCstmsJpBlCustVO.setCustNm(japanManifestListBkgCustInfoVO.getCustNm());
							bkgCstmsJpBlCustVO.setCustAddr(japanManifestListBkgCustInfoVO.getCustAddr());
							bkgCstmsJpBlCustVO.setPhnNo(japanManifestListBkgCustInfoVO.getPhnNo());
							bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());

							// 일본세관 Manifest 신고용 B/L Customer 정보를 생성한다.
							dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
						}

						if (japanManifestListBlMdVOs.size() == 0) {
							bkgCstmsJpBlMkVO.setBlNo(japanManifestListBkgInfoVOs.get(0).getBlNo());
							bkgCstmsJpBlMkVO.setBlSplitNo(k + "");
							bkgCstmsJpBlMkVO.setBlSeq("1");   
							bkgCstmsJpBlMkVO.setDiffRmk("N/M");
							bkgCstmsJpBlMkVO.setBlDesc(cstmsDesc.toUpperCase());
							bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());

							// 일본세관 Manifest 신고용 B/L Mark, Description 정보를 생성한다.
							dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);
						} else {
							for (int j = 0; j < japanManifestListBlMdVOs.size(); j++) {
								JapanManifestListBlMdVO japanManifestListBlMdVO = japanManifestListBlMdVOs.get(j);
								bkgCstmsJpBlMkVO.setBlNo(japanManifestListBlMdVO.getBlNo());
								bkgCstmsJpBlMkVO.setBlSplitNo(k + "");
								bkgCstmsJpBlMkVO.setBlSeq(japanManifestListBlMdVO.getMkSeq());
								bkgCstmsJpBlMkVO.setDiffRmk(japanManifestListBlMdVO.getMkDesc().replace("'", "''"));
								bkgCstmsJpBlMkVO.setBlDesc(japanManifestListBlMdVO.getCstmsDesc());
								bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());

								// 일본세관 Manifest 신고용 B/L Mark, Description 정보를
								// 생성한다.
								dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);
							}
						}
					}

					for (int j = 0; j < japanManifestListBkgCntrInfoVOs.size(); j++) {
						JapanManifestListBkgCntrInfoVO japanManifestListBkgCntrInfoVO = japanManifestListBkgCntrInfoVOs
								.get(j);
						BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO = new BkgCstmsJpBlCntrVO();
						bkgCstmsJpBlCntrVO.setBlNo(japanManifestListBkgCntrInfoVO.getBlNo());
						bkgCstmsJpBlCntrVO.setCntrNo(japanManifestListBkgCntrInfoVO.getCntrNo());
						bkgCstmsJpBlCntrVO.setCntrTpszCd(japanManifestListBkgCntrInfoVO.getCntrTpszCd());
						bkgCstmsJpBlCntrVO.setCntrSealNo(japanManifestListBkgCntrInfoVO.getCntrSealNo());
						bkgCstmsJpBlCntrVO.setCntrSealNo2(japanManifestListBkgCntrInfoVO.getCntrSealNo2());
						bkgCstmsJpBlCntrVO.setCntrSealNo3(japanManifestListBkgCntrInfoVO.getCntrSealNo3());
						bkgCstmsJpBlCntrVO.setCntrSealNo4(japanManifestListBkgCntrInfoVO.getCntrSealNo4());
						bkgCstmsJpBlCntrVO.setCntrSealNo5(japanManifestListBkgCntrInfoVO.getCntrSealNo5());
						bkgCstmsJpBlCntrVO.setCntrSealNo6(japanManifestListBkgCntrInfoVO.getCntrSealNo6());
						
						bkgCstmsJpBlCntrVO.setJpCstmsCntrStsCd("A");
						bkgCstmsJpBlCntrVO.setPrtFlg(japanManifestListBkgCntrInfoVO.getCntrPrtFlg());
						bkgCstmsJpBlCntrVO.setRcvTermCd(japanManifestListBkgCntrInfoVO.getRcvTermCd());
						bkgCstmsJpBlCntrVO.setDeTermCd(japanManifestListBkgCntrInfoVO.getDeTermCd());
						bkgCstmsJpBlCntrVO.setFullMtyCd(japanManifestListBkgInfoVOs.get(0).getBkgCgoTpCd());
						bkgCstmsJpBlCntrVO.setJpCntrOwnrCd(japanManifestListBkgCntrInfoVO.getLstmCd());
						bkgCstmsJpBlCntrVO.setCreUsrId(account.getUsr_id());

						if (j > 199) {
							bkgCstmsJpBlCntrVO.setBlSplitNo(j + "");
						} else {
							bkgCstmsJpBlCntrVO.setBlSplitNo("  ");
						}

						// 일본세관 Manifest 신고용 B/L Container 정보를 생성한다.
						dbDao.addJpcusBlCntr(bkgCstmsJpBlCntrVO);
					}
				} else {
										
					for (int j = 0; j < japanManifestListBkgCntrInfoVOs.size(); j++) {
						JapanManifestListBkgCntrInfoVO japanManifestListBkgCntrInfoVO = japanManifestListBkgCntrInfoVOs
								.get(j);
						BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO = new BkgCstmsJpBlCntrVO();
						bkgCstmsJpBlCntrVO.setBlNo(japanManifestListBkgCntrInfoVO.getBlNo());
						bkgCstmsJpBlCntrVO.setBlSplitNo(japanManifestListBkgCntrInfoVO.getBlSplitNo());
						bkgCstmsJpBlCntrVO.setCntrNo(japanManifestListBkgCntrInfoVO.getCntrNo());
						bkgCstmsJpBlCntrVO.setCntrTpszCd(japanManifestListBkgCntrInfoVO.getCntrTpszCd());
						bkgCstmsJpBlCntrVO.setCntrSealNo(japanManifestListBkgCntrInfoVO.getCntrSealNo());
						bkgCstmsJpBlCntrVO.setCntrSealNo2(japanManifestListBkgCntrInfoVO.getCntrSealNo2());
						bkgCstmsJpBlCntrVO.setCntrSealNo3(japanManifestListBkgCntrInfoVO.getCntrSealNo3());
						bkgCstmsJpBlCntrVO.setCntrSealNo4(japanManifestListBkgCntrInfoVO.getCntrSealNo4());
						bkgCstmsJpBlCntrVO.setCntrSealNo5(japanManifestListBkgCntrInfoVO.getCntrSealNo5());
						bkgCstmsJpBlCntrVO.setCntrSealNo6(japanManifestListBkgCntrInfoVO.getCntrSealNo6());
												
						bkgCstmsJpBlCntrVO.setJpCstmsCntrStsCd("A");
						bkgCstmsJpBlCntrVO.setPrtFlg(japanManifestListBkgCntrInfoVO.getCntrPrtFlg());
						bkgCstmsJpBlCntrVO.setRcvTermCd(japanManifestListBkgCntrInfoVO.getRcvTermCd());
						bkgCstmsJpBlCntrVO.setDeTermCd(japanManifestListBkgCntrInfoVO.getDeTermCd());
						bkgCstmsJpBlCntrVO.setFullMtyCd(japanManifestListBkgCntrInfoVO.getBkgCgoTpCd());
						bkgCstmsJpBlCntrVO.setJpCntrOwnrCd(japanManifestListBkgCntrInfoVO.getLstmCd());
						bkgCstmsJpBlCntrVO.setCreUsrId(account.getUsr_id());

						// 일본세관 Manifest 신고용 B/L Container 정보를 생성한다.
						dbDao.addJpcusBlCntr(bkgCstmsJpBlCntrVO);
						
						log.debug("------------ addJpcusBlCntr -----------------");
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD,Port 등 입력 후 조회한 세관 MFR 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForMfs(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException {
		try {
			BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO = new BkgCstmsJpVslSkdVO();
			JapanManifestModificationVO japanManifestModificationVO = new JapanManifestModificationVO();
			BkgCstmsJpVslVO bkgCstmsJpVslVO = new BkgCstmsJpVslVO();

			if (manifestModificationVOs != null) {
				japanManifestModificationVO.setInVslCd(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInVvdCd().substring(0, 4));
				japanManifestModificationVO.setInSkdVoyNo(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInVvdCd().substring(4, 8));
				japanManifestModificationVO.setInSkdDirCd(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInVvdCd().substring(8));
				japanManifestModificationVO.setInPodCd(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInPodCd());
				japanManifestModificationVO.setInPodSplitCd(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInPodSplitCd());
				japanManifestModificationVO.setInCallSgnNo(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInCallSgnNo());
				japanManifestModificationVO.setInCyOprCd(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInCyOprCd());
				japanManifestModificationVO.setInVpsEtaDt(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInVpsEtaDt());
				japanManifestModificationVO.setInVpsEtaDt(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInVpsEtaDt());
				japanManifestModificationVO.setUpdUsrId(account.getUsr_id());
				japanManifestModificationVO.setInVoyageNo(((JapanManifestModificationVO) manifestModificationVOs[0])
						.getInVoyageNo());

				dbDao.modifyJpcusBl(japanManifestModificationVO);
				
				bkgCstmsJpVslVO.setVslCd(japanManifestModificationVO.getInVslCd());
				bkgCstmsJpVslVO.setSkdVoyNo(japanManifestModificationVO.getInSkdVoyNo());
				bkgCstmsJpVslVO.setSkdDirCd(japanManifestModificationVO.getInSkdDirCd());
				bkgCstmsJpVslVO.setPodCd(japanManifestModificationVO.getInPodCd());
				//bkgCstmsJpVslVO.setLodWgt(japanManifestModificationVO.getLodgWgt());
				bkgCstmsJpVslVO.setCstmsMfCd(japanManifestModificationVO.getInPodSplitCd());
				//bkgCstmsJpVslVO.setMfRmk(japanManifestModificationVO.getMfRmk());
				bkgCstmsJpVslVO.setCreUsrId(account.getUsr_id());
				bkgCstmsJpVslVO.setUpdUsrId(account.getUsr_id());

				if (dbDao.modifyVesselInfo(bkgCstmsJpVslVO) == 0) {
					dbDao.addVesselInfo(bkgCstmsJpVslVO);
				}

				bkgCstmsJpVslSkdVO.setVslCd(japanManifestModificationVO.getInVslCd());
				bkgCstmsJpVslSkdVO.setSkdVoyNo(japanManifestModificationVO.getInSkdVoyNo());
				bkgCstmsJpVslSkdVO.setSkdDirCd(japanManifestModificationVO.getInSkdDirCd());
				bkgCstmsJpVslSkdVO.setPodCd(japanManifestModificationVO.getInPodCd());
				bkgCstmsJpVslSkdVO.setCallSgnNo(japanManifestModificationVO.getInCallSgnNo());
				bkgCstmsJpVslSkdVO.setEtaDt(japanManifestModificationVO.getInVpsEtaDt());
				bkgCstmsJpVslSkdVO.setUpdUsrId(account.getUsr_id());

				if (dbDao.modifyJpcusVslSkd(bkgCstmsJpVslSkdVO) == 0) {
					bkgCstmsJpVslSkdVO.setCreUsrId(account.getUsr_id());
					dbDao.addJpcusVslSkd(bkgCstmsJpVslSkdVO);
				}
				


				for (int i = 0; i < manifestModificationVOs.length; i++) {
					if (((JapanManifestModificationVO) manifestModificationVOs[i]).getIbflag().equals("D")) {
						JapanManifestModificationVO japanManifestModificationVO2 = new JapanManifestModificationVO();
						japanManifestModificationVO2.setBlNo(((JapanManifestModificationVO) manifestModificationVOs[i])
								.getBlNumber().substring(0, 12));
						if (((JapanManifestModificationVO) manifestModificationVOs[i]).getBlNumber().length() > 12)
							japanManifestModificationVO2
									.setBlSplitNo(((JapanManifestModificationVO) manifestModificationVOs[i])
											.getBlNumber().substring(12));
						japanManifestModificationVO2.setUpdUsrId(account.getUsr_id());

						dbDao.removeJpcusBl(japanManifestModificationVO2);
						
								
					}
					
					//[CHM-201008075]2011.01.12
					JapanManifestModificationVO japanManifestModificationVO3 = new JapanManifestModificationVO();
					japanManifestModificationVO3.setBlNo(((JapanManifestModificationVO) manifestModificationVOs[i])
							.getBlNumber().substring(0, 12));
					dbDao.modifyCYOperationCode(japanManifestModificationVO3.getBlNo(),japanManifestModificationVO.getInCyOprCd());		
					
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD,Port 등 입력 후 조회한 세관 CMF 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 * 
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForCmf(ManifestModificationVO manifestModificationVO, SignOnUserAccount account)
			throws EventException {
		JapanCmfModificationVO japanCmfModificationVO = (JapanCmfModificationVO) manifestModificationVO;
		BkgCstmsJpBlVO bkgCstmsJpBlVO = new BkgCstmsJpBlVO();
		try {
			if (japanCmfModificationVO != null) {
				bkgCstmsJpBlVO.setBlNo(japanCmfModificationVO.getBlNo());
				bkgCstmsJpBlVO.setBlSplitNo(japanCmfModificationVO.getBlSplitNo());
				bkgCstmsJpBlVO.setPodCd(japanCmfModificationVO.getPodCd());
				bkgCstmsJpBlVO.setBkgPorCd(japanCmfModificationVO.getBkgPorCd());
				bkgCstmsJpBlVO.setBkgPolCd(japanCmfModificationVO.getBkgPolCd());
				bkgCstmsJpBlVO.setBkgDelCd(japanCmfModificationVO.getBkgDelCd());
				bkgCstmsJpBlVO.setFullMtyCd(japanCmfModificationVO.getFullMtyCd());
				bkgCstmsJpBlVO.setPckQty(japanCmfModificationVO.getPckQty());
				bkgCstmsJpBlVO.setPckTpCd(japanCmfModificationVO.getPckTpCd());
				bkgCstmsJpBlVO.setGrsWgt(japanCmfModificationVO.getGrsWgt());
				bkgCstmsJpBlVO.setWgtUtCd(japanCmfModificationVO.getWgtUtCd());
				bkgCstmsJpBlVO.setMeasQty(japanCmfModificationVO.getMeasQty());
				bkgCstmsJpBlVO.setMeasUtCd(japanCmfModificationVO.getMeasUtCd());
				bkgCstmsJpBlVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyJpcusBl3(bkgCstmsJpBlVO);

				BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
				bkgCstmsJpBlCustVO.setBlNo(japanCmfModificationVO.getBlNo());
				bkgCstmsJpBlCustVO.setBlSplitNo(japanCmfModificationVO.getBlSplitNo());
				bkgCstmsJpBlCustVO.setPodCd(japanCmfModificationVO.getPodCd());

				bkgCstmsJpBlCustVO.setBkgCustTpCd("S");
				bkgCstmsJpBlCustVO.setCustCntCd(japanCmfModificationVO.getCustCntCd());
				bkgCstmsJpBlCustVO.setCustSeq(japanCmfModificationVO.getCustSeq());
				bkgCstmsJpBlCustVO.setCustNm(japanCmfModificationVO.getCustNm().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanCmfModificationVO.getCustAddr().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanCmfModificationVO.getPhnNo());
				bkgCstmsJpBlCustVO.setFaxNo(japanCmfModificationVO.getFaxNo());
				bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());
				bkgCstmsJpBlCustVO.setUpdUsrId(account.getUsr_id());

				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) {
					dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
				}

				bkgCstmsJpBlCustVO.setBkgCustTpCd("C");
				bkgCstmsJpBlCustVO.setCustCntCd(japanCmfModificationVO.getCustCntCd2());
				bkgCstmsJpBlCustVO.setCustSeq(japanCmfModificationVO.getCustSeq2());
				bkgCstmsJpBlCustVO.setCustNm(japanCmfModificationVO.getCustNm2().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanCmfModificationVO.getCustAddr2().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanCmfModificationVO.getPhnNo2());
				bkgCstmsJpBlCustVO.setFaxNo(japanCmfModificationVO.getFaxNo2());

				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) {
					dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
				}

				bkgCstmsJpBlCustVO.setBkgCustTpCd("N");
				bkgCstmsJpBlCustVO.setCustCntCd(japanCmfModificationVO.getCustCntCd3());
				bkgCstmsJpBlCustVO.setCustSeq(japanCmfModificationVO.getCustSeq3());
				bkgCstmsJpBlCustVO.setCustNm(japanCmfModificationVO.getCustNm3().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanCmfModificationVO.getCustAddr3().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanCmfModificationVO.getPhnNo3());
				bkgCstmsJpBlCustVO.setFaxNo(japanCmfModificationVO.getFaxNo3());

				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) {
					dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 신고 대상 Customer 정보를 세관 테이블 내에 생성한다.<br>
	 * 
	 * @param MfrCustModificationVO mfrCustModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrCust(MfrCustModificationVO mfrCustModificationVO, SignOnUserAccount account)
			throws EventException {
		JapanMfrCustModificationVO japanMfrCustModificationVO = (JapanMfrCustModificationVO) mfrCustModificationVO;
		try {
			if (japanMfrCustModificationVO != null) {
				BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
				bkgCstmsJpBlCustVO.setBlNo(japanMfrCustModificationVO.getBlNumber().substring(0, 12));
				bkgCstmsJpBlCustVO.setPodCd(japanMfrCustModificationVO.getPodCd());
				if (japanMfrCustModificationVO.getBlNumber().length() > 12)
					bkgCstmsJpBlCustVO.setBlSplitNo(japanMfrCustModificationVO.getBlNumber().substring(12));
				bkgCstmsJpBlCustVO.setBkgCustTpCd("S");
				bkgCstmsJpBlCustVO.setCustCntCd(japanMfrCustModificationVO.getCustCntCd());
				bkgCstmsJpBlCustVO.setCustSeq(japanMfrCustModificationVO.getCustSeq());
				bkgCstmsJpBlCustVO.setCustNm(japanMfrCustModificationVO.getCustNm().replace("'","''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanMfrCustModificationVO.getCustAddr().replace("'","''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanMfrCustModificationVO.getPhnNo());
				bkgCstmsJpBlCustVO.setFaxNo(japanMfrCustModificationVO.getFaxNo());
				bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());
				bkgCstmsJpBlCustVO.setUpdUsrId(account.getUsr_id());

				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) {
					dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
				}

				bkgCstmsJpBlCustVO.setBkgCustTpCd("C");
				bkgCstmsJpBlCustVO.setCustCntCd(japanMfrCustModificationVO.getCustCntCd2());
				bkgCstmsJpBlCustVO.setCustSeq(japanMfrCustModificationVO.getCustSeq2());
				bkgCstmsJpBlCustVO.setCustNm(japanMfrCustModificationVO.getCustNm2().replace("'","''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanMfrCustModificationVO.getCustAddr2().replace("'","''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanMfrCustModificationVO.getPhnNo2());
				bkgCstmsJpBlCustVO.setFaxNo(japanMfrCustModificationVO.getFaxNo2());

				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) {
					dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
				}

				bkgCstmsJpBlCustVO.setBkgCustTpCd("N");
				bkgCstmsJpBlCustVO.setCustCntCd(japanMfrCustModificationVO.getCustCntCd3());
				bkgCstmsJpBlCustVO.setCustSeq(japanMfrCustModificationVO.getCustSeq3());
				bkgCstmsJpBlCustVO.setCustNm(japanMfrCustModificationVO.getCustNm3().replace("'","''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanMfrCustModificationVO.getCustAddr3().replace("'","''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanMfrCustModificationVO.getPhnNo3());
				bkgCstmsJpBlCustVO.setFaxNo(japanMfrCustModificationVO.getFaxNo3());

				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) {
					dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 신고 대상 Marks & Description 정보를 세관 테이블 내에 생성한다.<br>
	 * 
	 * @param MfrMndModificationVO mfrCustModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrMnd(MfrMndModificationVO mfrCustModificationVO, SignOnUserAccount account)
			throws EventException {
		BkgCstmsJpBlVO bkgCstmsJpBlVO = new BkgCstmsJpBlVO();
		BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO = new BkgCstmsJpBlMkVO();
		try {
			JapanMfrMndContainerVO japanMfrMndContainerVO = (JapanMfrMndContainerVO) mfrCustModificationVO;
			JapanMfrMndCondVO japanMfrMndCondVO = japanMfrMndContainerVO.getJapanMfrMndCondVO();
			JapanMfrMndModificationVO[] japanMfrMndModificationVOs = japanMfrMndContainerVO
					.getJapanMfrMndModificationVOs();

			bkgCstmsJpBlVO.setBlNo(japanMfrMndCondVO.getBlNumber().substring(0, 12));
			bkgCstmsJpBlVO.setBlSplitNo(japanMfrMndCondVO.getBlNumber().substring(12));
			bkgCstmsJpBlVO.setPckQty(japanMfrMndCondVO.getPckQty());
			bkgCstmsJpBlVO.setPckTpCd(japanMfrMndCondVO.getPckTpCd());
			bkgCstmsJpBlVO.setGrsWgt(japanMfrMndCondVO.getGrsWgt());
			bkgCstmsJpBlVO.setWgtUtCd(japanMfrMndCondVO.getWgtUtCd());
			bkgCstmsJpBlVO.setMeasQty(japanMfrMndCondVO.getMeasQty());
			bkgCstmsJpBlVO.setMeasUtCd(japanMfrMndCondVO.getMeasUtCd());
			bkgCstmsJpBlVO.setLoclTsFlg(japanMfrMndCondVO.getLoclTsFlg());
			bkgCstmsJpBlVO.setJpCstmsTrnsCd(japanMfrMndCondVO.getJpCstmsTrnsCd());
			bkgCstmsJpBlVO.setLmtNo(japanMfrMndCondVO.getLmtNo());
			bkgCstmsJpBlVO.setCyOprCd(japanMfrMndCondVO.getCyOprCd());
			bkgCstmsJpBlVO.setUpdUsrId(account.getUsr_id());

			dbDao.modifyJpcusBl2(bkgCstmsJpBlVO);

			bkgCstmsJpBlMkVO.setBlNo(japanMfrMndCondVO.getBlNumber().substring(0, 12));
			bkgCstmsJpBlMkVO.setBlSplitNo(japanMfrMndCondVO.getBlNumber().substring(12));
			bkgCstmsJpBlMkVO.setUpdUsrId(account.getUsr_id());
			bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());
			for (int i = 0; i < japanMfrMndModificationVOs.length; i++) {
				JapanMfrMndModificationVO japanMfrMndModificationVO = japanMfrMndModificationVOs[i];

				bkgCstmsJpBlMkVO.setBlSeq(japanMfrMndModificationVO.getBlSeq());
				bkgCstmsJpBlMkVO.setDiffRmk(japanMfrMndModificationVO.getDiffRmk().replaceAll("\'", " "));
				bkgCstmsJpBlMkVO.setBlDesc(japanMfrMndModificationVO.getBlDesc().replaceAll("\'", " "));

				if (japanMfrMndModificationVOs[i].getIbflag().equals("U")) {
					dbDao.modifyJpcusBlMd(bkgCstmsJpBlMkVO);
				} else if (japanMfrMndModificationVOs[i].getIbflag().equals("I")) {
					dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);
				} else if (japanMfrMndModificationVOs[i].getIbflag().equals("D")) {
					dbDao.removeJpcusBlMd(bkgCstmsJpBlMkVO);

					List<BkgCstmsJpBlMkVO> bkgCstmsJpBlMkVOs = dbDao.searchJpcusBlMd(japanMfrMndCondVO.getBlNumber()
							.substring(0, 12), japanMfrMndCondVO.getBlNumber().substring(12));
					for (int j = 0; j < bkgCstmsJpBlMkVOs.size(); j++) {
						BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO2 = bkgCstmsJpBlMkVOs.get(j);
						dbDao.modifyJpcusBlMdSeq(bkgCstmsJpBlMkVO2.getBlNo(), bkgCstmsJpBlMkVO2.getBlSplitNo(),
								bkgCstmsJpBlMkVO2.getBlSeq(), j + 1 + "");
					}
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Vessel Arrival 정보 데이터를 저장한다.<br>
	 * 
	 * @param VesselArrivalVO vesselArrivalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException {
		JapanVesselArrivalVO japanVesselArrivalVO = (JapanVesselArrivalVO) vesselArrivalVO;
		BkgCstmsJpVslVO bkgCstmsJpVslVO = new BkgCstmsJpVslVO();
		BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO = new BkgCstmsJpVslSkdVO();
		try {
			bkgCstmsJpVslVO.setVslCd(japanVesselArrivalVO.getInVvdCd().substring(0, 4));
			bkgCstmsJpVslVO.setSkdVoyNo(japanVesselArrivalVO.getInVvdCd().substring(4, 8));
			bkgCstmsJpVslVO.setSkdDirCd(japanVesselArrivalVO.getInVvdCd().substring(8));
			bkgCstmsJpVslVO.setPodCd(japanVesselArrivalVO.getInPodCd());
			bkgCstmsJpVslVO.setLodgWgt(japanVesselArrivalVO.getLodgWgt());
			bkgCstmsJpVslVO.setCstmsMfCd(japanVesselArrivalVO.getInPodCdSplit());
			bkgCstmsJpVslVO.setMfRmk(japanVesselArrivalVO.getMfRmk());
			bkgCstmsJpVslVO.setCreUsrId(account.getUsr_id());
			bkgCstmsJpVslVO.setUpdUsrId(account.getUsr_id());

			if (dbDao.modifyVesselInfo(bkgCstmsJpVslVO) == 0) {
				dbDao.addVesselInfo(bkgCstmsJpVslVO);
			}

			bkgCstmsJpVslSkdVO.setVslCd(japanVesselArrivalVO.getInVvdCd().substring(0, 4));
			bkgCstmsJpVslSkdVO.setSkdVoyNo(japanVesselArrivalVO.getInVvdCd().substring(4, 8));
			bkgCstmsJpVslSkdVO.setSkdDirCd(japanVesselArrivalVO.getInVvdCd().substring(8));
			bkgCstmsJpVslSkdVO.setPodCd(japanVesselArrivalVO.getInPodCd());
			bkgCstmsJpVslSkdVO.setEtaDt(japanVesselArrivalVO.getEtaDt1() + japanVesselArrivalVO.getEtaDt2());
			bkgCstmsJpVslSkdVO.setEtbDt(japanVesselArrivalVO.getEtbDt1() + japanVesselArrivalVO.getEtbDt2());
			bkgCstmsJpVslSkdVO.setArrYdCd(japanVesselArrivalVO.getArrYdCd());
			bkgCstmsJpVslSkdVO.setCreUsrId(account.getUsr_id());
			bkgCstmsJpVslSkdVO.setUpdUsrId(account.getUsr_id());

			if (dbDao.modifyJpcusVslSkd2(bkgCstmsJpVslSkdVO) == 0) {
				dbDao.addJpcusVslSkd2(bkgCstmsJpVslSkdVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 신고시 필요한 Manifest B/L 정보를 Active 상태로 업데이트 한다.<br>
	 * 
	 * @param BlKeyVO blKeyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reactivateBl(BlKeyVO blKeyVO, SignOnUserAccount account) throws EventException {
		JapanBlKeyVO japanBlKeyVO = (JapanBlKeyVO) blKeyVO;
		try {

			dbDao.modifyJpcusBlStatus(japanBlKeyVO);

			dbDao.modifyJpcusBlCntrStatus(japanBlKeyVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 신고 대상 Container 정보를 세관 테이블 내에 생성한다.<br>
	 * 
	 * @param MfrCntrModificationVO[] mfrCntrModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrCntr(MfrCntrModificationVO[] mfrCntrModificationVOs, SignOnUserAccount account)
			throws EventException {
		JapanMfrCntrModificationVO[] japanMfrCntrModificationVOs = (JapanMfrCntrModificationVO[]) mfrCntrModificationVOs;
		String blNo = "";
		try {
			for (int i = 0; i < japanMfrCntrModificationVOs.length; i++) {
				JapanMfrCntrModificationVO japanMfrCntrModificationVO = japanMfrCntrModificationVOs[i];
				blNo = japanMfrCntrModificationVOs[0].getBlNo();
				BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO = new BkgCstmsJpBlCntrVO();
				bkgCstmsJpBlCntrVO.setBlNo(blNo.substring(0, 12));
				if (blNo.length() > 12)
					bkgCstmsJpBlCntrVO.setBlSplitNo(blNo.substring(12));
				else
					bkgCstmsJpBlCntrVO.setBlSplitNo("  ");
				bkgCstmsJpBlCntrVO.setCntrNo(japanMfrCntrModificationVO.getCntrNo());
				bkgCstmsJpBlCntrVO.setCntrSealNo(japanMfrCntrModificationVO.getCntrSealNo());
				bkgCstmsJpBlCntrVO.setCntrSealNo2(japanMfrCntrModificationVO.getCntrSealNo2());
				bkgCstmsJpBlCntrVO.setCntrSealNo3(japanMfrCntrModificationVO.getCntrSealNo3());
				bkgCstmsJpBlCntrVO.setCntrSealNo4(japanMfrCntrModificationVO.getCntrSealNo4());
				bkgCstmsJpBlCntrVO.setCntrSealNo5(japanMfrCntrModificationVO.getCntrSealNo5());
				bkgCstmsJpBlCntrVO.setCntrSealNo6(japanMfrCntrModificationVO.getCntrSealNo6());
				
				bkgCstmsJpBlCntrVO.setCntrTpszCd(japanMfrCntrModificationVO.getCntrTpszCd());
				bkgCstmsJpBlCntrVO.setDeTermCd(japanMfrCntrModificationVO.getDeTermCd());
				bkgCstmsJpBlCntrVO.setFullMtyCd(japanMfrCntrModificationVO.getFullMtyCd());
				bkgCstmsJpBlCntrVO.setJpCntrOwnrCd(japanMfrCntrModificationVO.getJpCntrOwnrCd());
				bkgCstmsJpBlCntrVO.setPrtFlg(japanMfrCntrModificationVO.getPrtFlg());
				bkgCstmsJpBlCntrVO.setRcvTermCd(japanMfrCntrModificationVO.getRcvTermCd());

				if (japanMfrCntrModificationVO.getIbflag().equals("I")) {
					bkgCstmsJpBlCntrVO.setJpCstmsCntrStsCd("A");
					bkgCstmsJpBlCntrVO.setCreUsrId(account.getUsr_id());
					bkgCstmsJpBlCntrVO.setUpdUsrId(account.getUsr_id());

					if (dbDao.addJpcusBlCntr(bkgCstmsJpBlCntrVO) == 0)
						dbDao.modifyJpcusBlCntr(bkgCstmsJpBlCntrVO);
				} else if (japanMfrCntrModificationVO.getIbflag().equals("U")) {
					bkgCstmsJpBlCntrVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyJpcusBlCntr(bkgCstmsJpBlCntrVO);
				} else if (japanMfrCntrModificationVO.getIbflag().equals("D")) {
					bkgCstmsJpBlCntrVO.setJpCstmsCntrStsCd("D");
					bkgCstmsJpBlCntrVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyJpcusBlCntr(bkgCstmsJpBlCntrVO);
				}
			}

			if (japanMfrCntrModificationVOs.length > 200) {
//				int loopCount = (japanMfrCntrModificationVOs.length - (japanMfrCntrModificationVOs.length % 200)) / 200;
				int loopCount = (int)Math.ceil((double)japanMfrCntrModificationVOs.length/200);

				for (int i = 0; i < loopCount; i++) {
					blNo = japanMfrCntrModificationVOs[0].getBlNo();

					int blCount = dbDao.searchBkgBlCount(blNo, loopCount + "");
					if (blCount == 0) {
						List<BkgCstmsJpBlVO> bkgCstmsJpBlVOs = dbDao.searchJpcusBl(blNo, "  ");
						String pod_cd = null;
						if (bkgCstmsJpBlVOs.size() > 0) {
							pod_cd = bkgCstmsJpBlVOs.get(0).getPodCd();
							bkgCstmsJpBlVOs.get(0).setBlSplitNo(loopCount + "");
							bkgCstmsJpBlVOs.get(0).setSplitFlg("Y");
							bkgCstmsJpBlVOs.get(0).setCreUsrId(account.getUsr_id());
							dbDao.addJpcusBl(bkgCstmsJpBlVOs.get(0));
						}

						List<BkgCstmsJpBlCustVO> bkgCstmsJpBlCustVOs = dbDao.searchJpcusBlCust(blNo, bkgCstmsJpBlVOs
								.get(0).getBlSplitNo());
						for (int j = 0; j < bkgCstmsJpBlCustVOs.size(); j++) {
							bkgCstmsJpBlCustVOs.get(j).setBlSplitNo(loopCount + "");
							bkgCstmsJpBlCustVOs.get(j).setCreUsrId(account.getUsr_id());
							bkgCstmsJpBlCustVOs.get(j).setPodCd(pod_cd);
							dbDao.addJpcusBlCust(bkgCstmsJpBlCustVOs.get(j));
						}

						List<BkgCstmsJpBlMkVO> bkgCstmsJpBlMkVOs = dbDao.searchJpcusBlMd(blNo, bkgCstmsJpBlVOs.get(0)
								.getBlSplitNo());
						for (int j = 0; j < bkgCstmsJpBlMkVOs.size(); j++) {
							bkgCstmsJpBlMkVOs.get(j).setBlSplitNo(loopCount + "");
							bkgCstmsJpBlCustVOs.get(j).setCreUsrId(account.getUsr_id());
							dbDao.addJpcusBlMd(bkgCstmsJpBlMkVOs.get(j));
						}

						List<BkgCstmsJpBlCntrVO> bkgCstmsJpBlCntrVOs = dbDao.searchJpcusBlCntr(blNo);
						for (int j = 0; j < bkgCstmsJpBlCntrVOs.size(); j++) {
							if (j > 200) {
								bkgCstmsJpBlCntrVOs.get(j).setBlSplitNo(loopCount + "");
								bkgCstmsJpBlCustVOs.get(j).setUpdUsrId(account.getUsr_id());
								dbDao.modifyJpcusBlCntrSplitNo(bkgCstmsJpBlCntrVOs.get(j));
							}
						}
					}
				}
				dbDao.modifyJpcusBlSplitInd(japanMfrCntrModificationVOs[0].getBlNo());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 신고 대상 Customer 정보를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchMfrCust(ManifestListCondVO manifestListCondVO) throws EventException {
		JapanManifestListMfrCondVO japanManifestListMfrCondVO = (JapanManifestListMfrCondVO) manifestListCondVO;
		List<JapanManifestListMfrCustInfoVO> japanManifestListMfrCustInfoVOs = null;
		JapanManifestListMfrCustInfoVO japanManifestListMfrCustInfoVO = new JapanManifestListMfrCustInfoVO();
		try {
			JapanManifestListCondVO japanManifestListCondVO = new JapanManifestListCondVO();
			japanManifestListCondVO.setInVslCd(japanManifestListMfrCondVO.getVvdCd().substring(0, 4));
			japanManifestListCondVO.setInSkdVoyNo(japanManifestListMfrCondVO.getVvdCd().substring(4, 8));
			japanManifestListCondVO.setInSkdDirCd(japanManifestListMfrCondVO.getVvdCd().substring(8));
			japanManifestListCondVO.setInPodCd(japanManifestListMfrCondVO.getPodCd());

			List<VpsCallIndInfoVO> vpsCallIndInfoVOs = dbDao.searchVpsCallInd(japanManifestListCondVO);

			if (vpsCallIndInfoVOs.size() > 0) {
				japanManifestListMfrCondVO.setClptIndSeq(vpsCallIndInfoVOs.get(0).getClptIndSeq());

				japanManifestListMfrCustInfoVOs = dbDao.searchMfrCust(japanManifestListMfrCondVO);

				if (japanManifestListMfrCustInfoVOs.size() > 0)
					japanManifestListMfrCustInfoVO = japanManifestListMfrCustInfoVOs.get(0);
			}

			return (ManifestListDetailVO) japanManifestListMfrCustInfoVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 신고 대상 Marks & Description 정보를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchMfrMnd(ManifestListCondVO manifestListCondVO) throws EventException {
		JapanManifestListMfrCondVO japanManifestListMfrCondVO = (JapanManifestListMfrCondVO) manifestListCondVO;
		List<BkgCstmsJpBlMkVO> bkgCstmsJpBlMkVOs = null;
		List<BkgCstmsJpBlVO> bkgCstmsJpBlVOs = null;

		JapanContainerVO japanContainerVO = new JapanContainerVO();

		String blNumber = "";
		try {
			blNumber = japanManifestListMfrCondVO.getBlNumber();

			bkgCstmsJpBlVOs = dbDao.searchJpcusBl(blNumber.substring(0, 12), blNumber.substring(12));
			bkgCstmsJpBlMkVOs = dbDao.searchJpcusBlMd(blNumber.substring(0, 12), blNumber.substring(12));
			if (bkgCstmsJpBlVOs.size() != 0)
				japanContainerVO.setBkgCstmsJpBlVO(bkgCstmsJpBlVOs.get(0));

			japanContainerVO.setBkgCstmsJpBlMkVOs(bkgCstmsJpBlMkVOs);

			return (ManifestListDetailVO) japanContainerVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 신고 대상 Container 정보를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchMfrCntr(ManifestListCondVO manifestListCondVO) throws EventException {
		JapanManifestListMfrCondVO japanManifestListMfrCondVO = (JapanManifestListMfrCondVO) manifestListCondVO;
		try {
			return (List<ManifestListDetailVO>) (Object) dbDao.searchMfrCntr(japanManifestListMfrCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * download 후 B/L을 추가 할 수 있다.<br>
	 * 
	 * @param BlVO blVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addBl(BlVO blVO, SignOnUserAccount account) throws EventException {
		JapanBlVO japanBlVO = (JapanBlVO) blVO;
		try {
			
			BkgCstmsJpBlVO bkgCstmsJpBlVO = new BkgCstmsJpBlVO();
			bkgCstmsJpBlVO.setBlNo(japanBlVO.getDummyBlNo().substring(0, 12));
			bkgCstmsJpBlVO.setBlSplitNo("  ");
			bkgCstmsJpBlVO.setVslCd(japanBlVO.getVvdCd().substring(0, 4));
			bkgCstmsJpBlVO.setSkdVoyNo(japanBlVO.getVvdCd().substring(4, 8));
			bkgCstmsJpBlVO.setSkdDirCd(japanBlVO.getVvdCd().substring(8));
			bkgCstmsJpBlVO.setPodCd(japanBlVO.getPodCd());
			bkgCstmsJpBlVO.setFullMtyCd(japanBlVO.getStage());
			bkgCstmsJpBlVO.setCreUsrId(account.getUsr_id());

			dbDao.addJpcusBl(bkgCstmsJpBlVO);

			BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
			bkgCstmsJpBlCustVO.setBlNo(japanBlVO.getDummyBlNo().substring(0, 12));
			bkgCstmsJpBlCustVO.setBlSplitNo("  ");
			bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());

			bkgCstmsJpBlCustVO.setBkgCustTpCd("S");

			dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);

			bkgCstmsJpBlCustVO.setBkgCustTpCd("C");

			dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);

			bkgCstmsJpBlCustVO.setBkgCustTpCd("N");

			dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestListForDl(ManifestListCondVO manifestListCondVO)
			throws EventException {
		JapanManifestListCondVO japanManifestListCondVO = (JapanManifestListCondVO) manifestListCondVO;
		List<JapanManifestListVslPortSkdVO> japanManifestListVslPortSkdVOs = null;
		List<JapanManifestListBkgDetailVO> japanManifestListBkgDetailVOs = null;
		List<JapanManifestListBkgDetailVO> japanManifestListBkgDetailVOs2 = new ArrayList<JapanManifestListBkgDetailVO>();
		List<JapanManifestListBkgDetail2VO> japanManifestListBkgDetail2VOs = null;
		List<JapanManifestListCntrDetailVO> japanManifestListCntrDetailVOs2 = new ArrayList<JapanManifestListCntrDetailVO>();
		List<JapanManifestListCntrDetailVO> japanManifestListCntrDetailVOs = null;
		JapanManifestListBkgDetailVO japanManifestListBkgDetailVO = null;
		JapanManifestListCntrDetailVO japanManifestListCntrDetailVO = null;

		JapanContainerVO japanContainerVO = new JapanContainerVO();

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		try {
			japanManifestListCondVO.setInVslCd(japanManifestListCondVO.getInVvdCd().substring(0, 4));
			japanManifestListCondVO.setInSkdVoyNo(japanManifestListCondVO.getInVvdCd().substring(4, 8));
			japanManifestListCondVO.setInSkdDirCd(japanManifestListCondVO.getInVvdCd().substring(8));

			// Vessel Port Schedule Call Indicator를 조회한다.
			List<VpsCallIndInfoVO> vpsCallIndInfoVOs = dbDao.searchVpsCallInd(japanManifestListCondVO);
			if ( vpsCallIndInfoVOs.size() > 0 )
				japanManifestListCondVO.setInCallInd(vpsCallIndInfoVOs.get(0).getClptIndSeq());

			// Vessel Port Schedule 정보를 조회한다.
			japanManifestListVslPortSkdVOs = dbDao.searchVslPortSkd(japanManifestListCondVO);
			
			japanContainerVO.setJapanManifestListVslPortSkdVOs(japanManifestListVslPortSkdVOs);

			// Booking Detail 정보를 조회한다.
			japanManifestListBkgDetailVOs = dbDao.searchBkgDetail(japanManifestListCondVO);
			japanManifestListBkgDetail2VOs = dbDao.searchBkgDetail2(japanManifestListCondVO);

			if (japanManifestListBkgDetailVOs.size() != 0) {
				String blNo = japanManifestListBkgDetailVOs.get(0).getBlNo();
				int seqNumber = 1;
				for (int i = 0; i < japanManifestListBkgDetailVOs.size(); i++) {
					if (japanManifestListBkgDetailVOs.get(i).getBlNo().equals(blNo)) {
						japanManifestListBkgDetailVOs.get(i).setSeq(seqNumber + "");
					} else {
						blNo = japanManifestListBkgDetailVOs.get(i).getBlNo();
						japanManifestListBkgDetailVOs.get(i).setSeq(++seqNumber + "");
					}
				}
			}

			String polCd = "";
			int polCount = 0;
			for (int i = 0; i < japanManifestListBkgDetailVOs.size(); i++) {
				japanManifestListBkgDetailVO = japanManifestListBkgDetailVOs.get(i);
				JapanManifestListBkgDetailVO japanManifestListBkgDetailVO2 = new JapanManifestListBkgDetailVO();

				if (!polCd.equals(japanManifestListBkgDetailVOs.get(i).getPolCd2())) {

					japanManifestListBkgDetailVO2.setBlNo("POL : " + japanManifestListBkgDetailVO.getPolCd2());
					japanManifestListBkgDetailVO2.setBkgNo("ETD : " + japanManifestListBkgDetailVO.getVpsEtdDt());
					
					if (i == 0) {
						japanManifestListBkgDetailVOs2.add(i, japanManifestListBkgDetailVO2);
						polCount++;
						for (int j = i; j < japanManifestListBkgDetailVOs.size(); j++) {
							japanManifestListBkgDetailVOs2.add(j + polCount, japanManifestListBkgDetailVOs.get(j));
						}
					} else {
						japanManifestListBkgDetailVOs2.set(i + polCount, japanManifestListBkgDetailVO2);

						for (int j = i + polCount + 1; j - polCount - 1 < japanManifestListBkgDetailVOs.size(); j++) {
							if (j >= japanManifestListBkgDetailVOs2.size())
								japanManifestListBkgDetailVOs2.add(j, japanManifestListBkgDetailVOs.get(j - polCount
										- 1));
							else
								japanManifestListBkgDetailVOs2.set(j, japanManifestListBkgDetailVOs.get(j - polCount
										- 1));
						}
						polCount++;
					}
					polCd = japanManifestListBkgDetailVO.getPolCd2();
				}
			}

			japanManifestListBkgDetailVOs = japanManifestListBkgDetailVOs2;

			japanContainerVO.setJapanManifestListBkgDetailVOs(japanManifestListBkgDetailVOs);

			if (japanManifestListBkgDetail2VOs.size() != 0) {
				String blNo = japanManifestListBkgDetail2VOs.get(0).getBlNo();
				int seqNumber = 1;
				for (int i = 0; i < japanManifestListBkgDetail2VOs.size(); i++) {
					if (japanManifestListBkgDetail2VOs.get(i).getBlNo().equals(blNo)) {
						japanManifestListBkgDetail2VOs.get(i).setSeq(seqNumber + "");
					} else {
						blNo = japanManifestListBkgDetail2VOs.get(i).getBlNo();
						japanManifestListBkgDetail2VOs.get(i).setSeq(++seqNumber + "");
					}
				}
			}
			japanContainerVO.setJapanManifestListBkgDetail2VOs(japanManifestListBkgDetail2VOs);

			// Container Detail 정보를 조회한다.
			japanManifestListCntrDetailVOs = dbDao.searchCntrDetail(japanManifestListCondVO);

			if (japanManifestListCntrDetailVOs.size() != 0) {
				String blNo = japanManifestListCntrDetailVOs.get(0).getBlNo();
				int seqNumber = 1;
				for (int i = 0; i < japanManifestListCntrDetailVOs.size(); i++) {
					if (japanManifestListCntrDetailVOs.get(i).getBlNo().equals(blNo)) {
						japanManifestListCntrDetailVOs.get(i).setSeq(seqNumber + "");
					} else {
						blNo = japanManifestListCntrDetailVOs.get(i).getBlNo();
						japanManifestListCntrDetailVOs.get(i).setSeq(++seqNumber + "");
					}
				}
			}

			polCount = 0;
			polCd = "";
			for (int i = 0; i < japanManifestListCntrDetailVOs.size(); i++) {
				japanManifestListCntrDetailVO = japanManifestListCntrDetailVOs.get(i);
				JapanManifestListCntrDetailVO japanManifestListCntrDetailVO2 = new JapanManifestListCntrDetailVO();

				if (!polCd.equals(japanManifestListCntrDetailVOs.get(i).getPolCd())) {

					japanManifestListCntrDetailVO2.setBlNo("POL : " + japanManifestListCntrDetailVO.getPolCd()
							+ "      ETD : " + japanManifestListCntrDetailVO.getVpsEtdDt());
					if (i == 0) {
						japanManifestListCntrDetailVOs2.add(i, japanManifestListCntrDetailVO2);
						polCount++;
						for (int j = i; j < japanManifestListCntrDetailVOs.size(); j++) {
							japanManifestListCntrDetailVOs2.add(j + polCount, japanManifestListCntrDetailVOs.get(j));
						}
					} else {
						japanManifestListCntrDetailVOs2.set(i + polCount, japanManifestListCntrDetailVO2);

						for (int j = i + polCount + 1; j - polCount - 1 < japanManifestListCntrDetailVOs.size(); j++) {
							if (j >= japanManifestListCntrDetailVOs2.size())
								japanManifestListCntrDetailVOs2.add(j, japanManifestListCntrDetailVOs.get(j - polCount
										- 1));
							else
								japanManifestListCntrDetailVOs2.set(j, japanManifestListCntrDetailVOs.get(j - polCount
										- 1));
						}
						polCount++;
					}
					polCd = japanManifestListCntrDetailVO.getPolCd();
				}
			}

			japanManifestListCntrDetailVOs = japanManifestListCntrDetailVOs2;

			japanContainerVO.setJapanManifestListCntrDetailVOs(japanManifestListCntrDetailVOs);

			manifestListDetailVO.add((ManifestListDetailVO) japanContainerVO);

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(MFS 데이터) 를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestListForMfs(ManifestListCondVO manifestListCondVO)
			throws EventException {
		String callSgnNo = "";
		JapanManifestListCondVO japanManifestListCondVO = (JapanManifestListCondVO) manifestListCondVO;
		List<JapanManifestListMfsDetailVO> japanManifestListMfsDetailVOs = new ArrayList<JapanManifestListMfsDetailVO>();
		//List<JapanManifestListJpcusEtaInfoVO> japanManifestListJpcusEtaInfoVOs = null;
		JapanManifestListEtcVO japanManifestListEtcVO = new JapanManifestListEtcVO();
		JapanContainerVO japanContainerVO = new JapanContainerVO();
		String etaDt = "";
		String cstmsMfId = "";
		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		try {

			japanManifestListCondVO.setInVslCd(japanManifestListCondVO.getInVvdCd().substring(0, 4));
			japanManifestListCondVO.setInSkdVoyNo(japanManifestListCondVO.getInVvdCd().substring(4, 8));
			japanManifestListCondVO.setInSkdDirCd(japanManifestListCondVO.getInVvdCd().substring(8));

			// Vessel Port Schedule Call Indicator를 조회한다.
			List<JapanManifestListJpcusEtaInfoVO>  japanManifestListJpcusEtaInfoVOs= dbDao.searchJpcusEta(japanManifestListCondVO);
			if ( japanManifestListJpcusEtaInfoVOs.size() > 0 )
			{
				etaDt = japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt();
				cstmsMfId = japanManifestListJpcusEtaInfoVOs.get(0).getCstmsMfId();
				if ( !japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo().equals(""))
					callSgnNo = japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo();
			} else {
				etaDt = dbDao.searchEta(japanManifestListCondVO);
			}
			if ( callSgnNo.equals("") )
				callSgnNo = dbDao.searchVslCallsign(japanManifestListCondVO.getInVslCd());
			if ( etaDt.equals("") )
				throw new EventException(new ErrorHandler("BKG00889", new String[] {}).getMessage());
			else
				japanManifestListEtcVO.setVpsEtaDt(etaDt);
			if ( callSgnNo.equals("") )
				throw new EventException(new ErrorHandler("BKG00889", new String[] {}).getMessage());
			else
				japanManifestListEtcVO.setCallSgnNo(callSgnNo);
			
			japanManifestListEtcVO.setPodSplitCd(cstmsMfId);
				
			/*japanManifestListJpcusEtaInfoVOs = dbDao.searchJpcusEta(japanManifestListCondVO);
			String vpsEtaDt = "";
			if (japanManifestListJpcusEtaInfoVOs.size() > 0) {
				if (japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt() != null
						&& !japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt().equals("")) {
					vpsEtaDt = japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt();
				} else {
					etaDt = dbDao.searchEta(japanManifestListCondVO);
					if (etaDt.length() == 8)
						vpsEtaDt = etaDt.substring(0, 4) + "-" + etaDt.substring(4, 6) + "-" + etaDt.substring(6, 8);
				}
				japanManifestListEtcVO.setVpsEtaDt(vpsEtaDt);

				
				if (japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo() != null
						&& !japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo().equals("")) {
					callSgnNo = japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo();
				} else {
					callSgnNo = dbDao.searchVslCallsign(japanManifestListCondVO.getInVslCd());
				}
				japanManifestListEtcVO.setCallSgnNo(callSgnNo);
			} else {
				japanManifestListEtcVO.setVpsEtaDt("");
				japanManifestListEtcVO.setCallSgnNo("");				
			}*/
			if ( !etaDt.equals("") && !callSgnNo.equals("") ) {
				japanManifestListCondVO.setInCallSgnNo(callSgnNo);
				japanManifestListCondVO.setInEtaDt(etaDt);

				japanManifestListMfsDetailVOs = dbDao.searchMfsDetail(japanManifestListCondVO);
			} /*else {
				japanManifestListCondVO.setInCallSgnNo("");
				japanManifestListCondVO.setInEtaDt("");

				japanManifestListMfsDetailVOs = dbDao.searchMfsDetail(japanManifestListCondVO);
			}*/

			//if (japanManifestListMfsDetailVOs.size() != 0)
			//	japanManifestListEtcVO.setCyOprCd(japanManifestListMfsDetailVOs.get(0).getCyOprCd());
			//else
			//	japanManifestListEtcVO.setCyOprCd("");
			for ( int j=0 ; j<japanManifestListMfsDetailVOs.size() ; j++ )
			{
				if ( !japanManifestListMfsDetailVOs.get(j).getCyOprCd().equals("") )
				{
					japanManifestListEtcVO.setCyOprCd(japanManifestListMfsDetailVOs.get(j).getCyOprCd());
					break;
				}
			}
			
			for ( int j=0 ; j<japanManifestListMfsDetailVOs.size() ; j++ )
			{
				if ( !japanManifestListMfsDetailVOs.get(j).getJpTmlVslNo().equals("") )
				{
					japanManifestListEtcVO.setJpTmlVslNo(japanManifestListMfsDetailVOs.get(j).getJpTmlVslNo());
					break;
				}
			}

			if (japanManifestListMfsDetailVOs.size() != 0) {
				
				japanManifestListEtcVO.setJpTmlVslNo(japanManifestListEtcVO.getJpTmlVslNo().trim());
				japanManifestListEtcVO.setCyOprCd(japanManifestListEtcVO.getCyOprCd().trim());
				
				String blNumber = japanManifestListMfsDetailVOs.get(0).getBlNumber();
				int seqNumber = 1;
				for (int i = 0; i < japanManifestListMfsDetailVOs.size(); i++) {
					if (japanManifestListMfsDetailVOs.get(i).getPstVslCd().equals("         ")) {
						japanManifestListMfsDetailVOs.get(i).setPstVslCd("-");
					}
					if (japanManifestListMfsDetailVOs.get(i).getPstRlyPodCd().equals("     ")) {
						japanManifestListMfsDetailVOs.get(i).setPstRlyPodCd("-");
					}
					if (japanManifestListMfsDetailVOs.get(i).getBlNumber().equals(blNumber)) {
						japanManifestListMfsDetailVOs.get(i).setSeq(seqNumber + "");
					} else {
						blNumber = japanManifestListMfsDetailVOs.get(i).getBlNumber();
						japanManifestListMfsDetailVOs.get(i).setSeq(++seqNumber + "");
					}
				}
			}

			japanContainerVO.setJapanManifestListMfsDetailVOs(japanManifestListMfsDetailVOs);
			japanContainerVO.setJapanManifestListEtcVO(japanManifestListEtcVO);

			manifestListDetailVO.add((ManifestListDetailVO) japanContainerVO);

			return manifestListDetailVO;

		} catch (EventException ex) {
			throw ex;
		}  catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(CMF 데이터) 를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchManifestListForCmf(ManifestListCondVO manifestListCondVO) throws EventException {
		String blNo = "";
		String blSplitNo = "";
		JapanManifestListCondVO japanManifestListCondVO = (JapanManifestListCondVO) manifestListCondVO;
		List<JapanManifestListCmfDetailVO> japanManifestListCmfDetailVOs = null;
		JapanManifestListCmfDetailVO japanManifestListCmfDetailVO = null;
		try {

			blNo = japanManifestListCondVO.getInBlNo();
			blSplitNo = japanManifestListCondVO.getInBlSplitNo();

			List<BkgCstmsJpBlVO> bkgCstmsJpBlVOs = dbDao.searchJpcusBl(blNo, blSplitNo);

			if (bkgCstmsJpBlVOs.size() > 0) {
				japanManifestListCondVO.setInVslCd(bkgCstmsJpBlVOs.get(0).getVslCd());
				japanManifestListCondVO.setInSkdVoyNo(bkgCstmsJpBlVOs.get(0).getSkdVoyNo());
				japanManifestListCondVO.setInSkdDirCd(bkgCstmsJpBlVOs.get(0).getSkdDirCd());
				japanManifestListCondVO.setInPodCd(bkgCstmsJpBlVOs.get(0).getPodCd());
			}

			List<VpsCallIndInfoVO> vpsCallIndInfoVOs = dbDao.searchVpsCallInd(japanManifestListCondVO);
			String podSplitCd = "";
			if ( vpsCallIndInfoVOs.size() > 0 )
			{
				japanManifestListCondVO.setInCallInd(vpsCallIndInfoVOs.get(0).getClptIndSeq());
				podSplitCd = vpsCallIndInfoVOs.get(0).getCstmsMfId();
			}
			japanManifestListCmfDetailVOs = dbDao.searchCmfDetail(japanManifestListCondVO);

			if (japanManifestListCmfDetailVOs.size() > 0)
			{
				japanManifestListCmfDetailVO = japanManifestListCmfDetailVOs.get(0);
				japanManifestListCmfDetailVO.setPodSplitCd(podSplitCd);
			}

			return (ManifestListDetailVO) japanManifestListCmfDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(DOR 데이터) 를 조회한다.<br>
	 * 
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchManifestListForDor() throws EventException {
		List<JapanManifestListDorListInfoVO> japanManifestListDorListInfoVOs = null;
		try {
			japanManifestListDorListInfoVOs = dbDao.searchDorList();

			return (List<ManifestListDetailVO>) (Object) japanManifestListDorListInfoVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Vessel Arrival 정보 데이터를 조회한다.<br>
	 * 
	 * @param VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO)
			throws EventException {
		JapanVesselArrivalCondVO japanVesselArrivalCondVO = (JapanVesselArrivalCondVO) vesselArrivalCondVO;
		List<VesselArrivalDetailVO> vesselArrivalDetailVOs = null;
		List<JapanVesselArrivalDetailVO> japanVesselArrivalDetailVOs = null;
		try {

			japanVesselArrivalDetailVOs = dbDao.searchVslEtaDmfRemark(japanVesselArrivalCondVO);

			vesselArrivalDetailVOs = (List<VesselArrivalDetailVO>) (Object) japanVesselArrivalDetailVOs;
			return vesselArrivalDetailVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 일본세관 전송용 Manifest B/L Status를 Active or Deleted로 업데이트한다.<br>
	 * 
	 * @param List<JapanTransmitBlKeyVO> japanBlKeyVOs
	 * @exception EventException
	 */
	public void modifyMsgStatus(List<JapanTransmitBlKeyVO> japanBlKeyVOs)
			throws EventException {
		try {
			for ( int i=0 ; i<japanBlKeyVOs.size() ; i++ )
			{
				JapanTransmitBlKeyVO japanBlKeyVO = japanBlKeyVOs.get(i);
				dbDao.modifyMsgStatus(japanBlKeyVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * 일본세관 전송용 Manifest B/L Status를 Active or Deleted로 업데이트한다.<br>
	 * 
	 * @param ManifestListCondVO japanManifestListCondVO
	 * @return String
	 * @exception EventException
	 */
//	public String searchWgtErrBkgNo(ManifestListCondVO japanManifestListCondVO) throws EventException {
//		try {
//			return dbDao.searchWgtErrBkgNo(japanManifestListCondVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
//		}
//	}	
}
