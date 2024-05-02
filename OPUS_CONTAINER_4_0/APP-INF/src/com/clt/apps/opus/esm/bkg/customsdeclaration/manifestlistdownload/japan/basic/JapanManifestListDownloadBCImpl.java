/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanManifestListDownloadBCImpl.java
 *@FileTitle : ESM_BKG-0462
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.05.18 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.ApprovalCstmsCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.CstmsJpWhRoutVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.CstmsJpWhVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanCmfModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetail2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBlMdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCmfDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCntrDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListEtcVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfsDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListVslPortSkdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrCntrModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrCustModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrMndCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrMndContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrMndModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.VpsCallIndInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCntrModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrMndModificationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsJpBlCntrVO;
import com.clt.syscommon.common.table.BkgCstmsJpBlCustVO;
import com.clt.syscommon.common.table.BkgCstmsJpBlMkVO;
import com.clt.syscommon.common.table.BkgCstmsJpBlVO;
import com.clt.syscommon.common.table.BkgCstmsJpVslSkdVO;
import com.clt.syscommon.common.table.BkgCstmsJpVslVO;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0462EventResponse, JapanManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanManifestListDownloadBCImpl extends BasicCommandSupport implements JapanManifestListDownloadBC {

	// Database Access Object
	private transient JapanManifestListDownloadDBDAO dbDao = null;

	/**
	 * JapanManifestListDownloadBCImpl 객체 생성<br>
	 * JapanManifestListDownloadDBDAO 생성한다.<br>
	 */
	public JapanManifestListDownloadBCImpl() {
		dbDao = new JapanManifestListDownloadDBDAO();
	}

	/**
	 * VVD, Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 *
	 * @param JapanManifestModificationVO[] japanManifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForDl(JapanManifestModificationVO[] japanManifestModificationVOs, SignOnUserAccount account) throws EventException {
		List<JapanManifestListBkgInfoVO> japanManifestListBkgInfoVOs = new ArrayList<JapanManifestListBkgInfoVO>();;
		List<JapanManifestListBkgCorrVO> japanManifestListBkgCorrVOs = new ArrayList<JapanManifestListBkgCorrVO>();;
		List<JapanManifestListBkgVvdInfoVO> postBkgVvdInfoVOList = new ArrayList<JapanManifestListBkgVvdInfoVO>();
		List<JapanManifestListBkgVvdInfoVO> prevBkgVvdInfoVOList = new ArrayList<JapanManifestListBkgVvdInfoVO>();
		List<JapanManifestListBkgQtyVO> japanManifestListBkgQtyVOs = new ArrayList<JapanManifestListBkgQtyVO>();;
		List<JapanManifestListBkgCustInfoVO> JapanManifestListBkgCustInfoVOList = new ArrayList<JapanManifestListBkgCustInfoVO>();;
		List<JapanManifestListBlMdVO> japanManifestListBlMdVOList = new ArrayList<JapanManifestListBlMdVO>();;
		List<JapanManifestListBkgCntrInfoVO> japanManifestListBkgCntrInfoVOList = new ArrayList<JapanManifestListBkgCntrInfoVO>();;

		try {
			for(int i=0; i<japanManifestModificationVOs.length; i++) {
				String bkgNo = ((JapanManifestModificationVO) japanManifestModificationVOs[i]).getBkgNo();
				String podCd = ((JapanManifestModificationVO) japanManifestModificationVOs[0]).getInPodCd();
				String polCd = ((JapanManifestModificationVO) japanManifestModificationVOs[i]).getVvdPolCd();
				String vvdCd = ((JapanManifestModificationVO) japanManifestModificationVOs[0]).getInVvdCd();
				String loclTsFlg = "";
				String cstmsDesc = "";

				// Booking Main 정보를 조회한다.
				japanManifestListBkgInfoVOs = dbDao.searchBooking(bkgNo);
				if (japanManifestListBkgInfoVOs.get(0).getBdrCngFlg().equals("Y")) {
					// Booking Correction 정보를 조회한다.
					japanManifestListBkgCorrVOs = dbDao.searchBkgCorr2(bkgNo);
				}

				if (podCd.equals(japanManifestListBkgInfoVOs.get(0).getPodCd())) {
					loclTsFlg = "L";
				} else {
					loclTsFlg = "T";
				}

				BigDecimal measQty = BigDecimal.valueOf(Double.valueOf(japanManifestListBkgInfoVOs.get(0).getMeasQty()));
				// 0 > measQty : 1 // 0 == measQty : 0 // 0 < measQty : -1
				if (0 == BigDecimal.valueOf(0L).compareTo(measQty)) {
					japanManifestListBkgQtyVOs = dbDao.searchBkgQty(bkgNo);    // BKG_QUANTITY 정보 조회
					for (JapanManifestListBkgQtyVO japanManifestListBkgQtyVO : japanManifestListBkgQtyVOs) {
						if (Integer.valueOf(japanManifestListBkgQtyVO.getCntrTpszCd()) < 3) {
							// measQty += (20 * japanManifestListBkgQtyVO.getOpCntrQty())
							measQty = measQty.add(BigDecimal.valueOf(Double.valueOf(japanManifestListBkgQtyVO.getOpCntrQty()))).multiply(BigDecimal.valueOf(20L));
						} else {
							// measQty += (40 * japanManifestListBkgQtyVO.getOpCntrQty())
							measQty = measQty.add(BigDecimal.valueOf(Double.valueOf(japanManifestListBkgQtyVO.getOpCntrQty()))).multiply(BigDecimal.valueOf(40L));
						}
					}
					// 1 > measQty : 1 // 1 == measQty : 0 // 1 < measQty : -1
					if (1 == BigDecimal.valueOf(1L).compareTo(measQty)) measQty = BigDecimal.valueOf(1L);
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

				// Post VVD정보
				postBkgVvdInfoVOList = dbDao.searchBkgVvd(bkgNo, podCd, "POST");
				if (postBkgVvdInfoVOList.size() != 0) {
					bkgCstmsJpBlVO.setPstRlyPodCd(postBkgVvdInfoVOList.get(0).getPodCd());
					bkgCstmsJpBlVO.setPstVslCd(postBkgVvdInfoVOList.get(0).getVvdCd().substring(0, 4));
					bkgCstmsJpBlVO.setPstSkdVoyNo(postBkgVvdInfoVOList.get(0).getVvdCd().substring(4, 8));
					bkgCstmsJpBlVO.setPstSkdDirCd(postBkgVvdInfoVOList.get(0).getVvdCd().substring(8));
				}

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
				bkgCstmsJpBlVO.setLoclTsIndCd(loclTsFlg);
				bkgCstmsJpBlVO.setJpCstmsTrnsCd(loclTsFlg);
				bkgCstmsJpBlVO.setFullMtyCd(japanManifestListBkgInfoVOs.get(0).getBkgCgoTpCd());
				bkgCstmsJpBlVO.setCreUsrId(account.getUsr_id());

				// Prev VVD정보 - 2014.10.21 추가
				prevBkgVvdInfoVOList = dbDao.searchBkgVvd(bkgNo, podCd, "PREV");
				if (prevBkgVvdInfoVOList.size() != 0) {
					bkgCstmsJpBlVO.setPreRlyPortCd(prevBkgVvdInfoVOList.get(0).getPodCd());
					bkgCstmsJpBlVO.setPreVslCd(prevBkgVvdInfoVOList.get(0).getVvdCd().substring(0, 4));
					bkgCstmsJpBlVO.setPreSkdVoyNo(prevBkgVvdInfoVOList.get(0).getVvdCd().substring(4, 8));
					bkgCstmsJpBlVO.setPreSkdDirCd(prevBkgVvdInfoVOList.get(0).getVvdCd().substring(8));
				}
				// 일본세관 Manifest 신고용 B/L 정보를 생성한다.
				dbDao.addJpcusBl(bkgCstmsJpBlVO);

				// Booking Customer 정보를 조회한다.
				JapanManifestListBkgCustInfoVOList = dbDao.searchBkgCust(bkgNo);
				BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
				for (JapanManifestListBkgCustInfoVO japanManifestListBkgCustInfoVO : JapanManifestListBkgCustInfoVOList) {
					bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
					bkgCstmsJpBlCustVO.setBlNo(japanManifestListBkgCustInfoVO.getBlNo());
					bkgCstmsJpBlCustVO.setBlSplitNo(japanManifestListBkgCustInfoVO.getBlNoSplit());
					bkgCstmsJpBlCustVO.setBkgCustTpCd(japanManifestListBkgCustInfoVO.getBkgCustTpCd());
					bkgCstmsJpBlCustVO.setCustCntCd(japanManifestListBkgCustInfoVO.getCustCntCd());
					bkgCstmsJpBlCustVO.setCustSeq(japanManifestListBkgCustInfoVO.getCustSeq());
					bkgCstmsJpBlCustVO.setCustNm(japanManifestListBkgCustInfoVO.getCustNm().replace("'", "''"));
					bkgCstmsJpBlCustVO.setCustAddr(japanManifestListBkgCustInfoVO.getCustAddr().replace("'", "''"));
					bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());
					// 일본세관 Manifest 신고용 B/L Customer 정보를 생성한다.
					dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
				}

				// BL CM Descriptin 정보를 조회한다.
				cstmsDesc = dbDao.searchBlCmDesc(bkgNo).replace("'", "''");
				japanManifestListBlMdVOList = dbDao.searchBlMd(bkgNo);

				BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO = new BkgCstmsJpBlMkVO();
				if (japanManifestListBlMdVOList.size() < 1) {
					bkgCstmsJpBlMkVO.setBlNo(japanManifestListBkgInfoVOs.get(0).getBlNo());
					bkgCstmsJpBlMkVO.setBlSplitNo("  ");
					bkgCstmsJpBlMkVO.setBlSeq("1");
					bkgCstmsJpBlMkVO.setDiffRmk("N/M");
					bkgCstmsJpBlMkVO.setBlDesc(cstmsDesc);
					bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());
					// 일본세관 Manifest 신고용 B/L Mark, Description 정보를 생성한다.
					dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);

				} else {
					for(JapanManifestListBlMdVO japanManifestListBlMdVO: japanManifestListBlMdVOList) {
						bkgCstmsJpBlMkVO.setBlNo(japanManifestListBlMdVO.getBlNo());
						bkgCstmsJpBlMkVO.setBlSplitNo("  ");
						bkgCstmsJpBlMkVO.setBlSeq(japanManifestListBlMdVO.getMkSeq());
						bkgCstmsJpBlMkVO.setDiffRmk(japanManifestListBlMdVO.getMkDesc().replace("'", "''"));
						bkgCstmsJpBlMkVO.setBlDesc(cstmsDesc);
						bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());
						// 일본세관 Manifest 신고용 B/L Mark, Description 정보를 생성한다.
						dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);
					}
				}

				// Booking Container 정보를 조회한다.
				japanManifestListBkgCntrInfoVOList = dbDao.searchBkgCntr(bkgNo, japanManifestListBkgInfoVOs.get(0).getBkgCgoTpCd());
				if (japanManifestListBkgCntrInfoVOList.size() > 100) {
					int loopCount = (japanManifestListBkgCntrInfoVOList.size() - (japanManifestListBkgCntrInfoVOList.size() % 100)) / 100 + 1;
					for(int k=1; k<loopCount; k++) {
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

						// Post VVD정보
						if (postBkgVvdInfoVOList.size() != 0) {
							bkgCstmsJpBlVO.setPstRlyPodCd(postBkgVvdInfoVOList.get(0).getPodCd());
							bkgCstmsJpBlVO.setPstVslCd(postBkgVvdInfoVOList.get(0).getVvdCd().substring(0, 4));
							bkgCstmsJpBlVO.setPstSkdVoyNo(postBkgVvdInfoVOList.get(0).getVvdCd().substring(4, 8));
							bkgCstmsJpBlVO.setPstSkdDirCd(postBkgVvdInfoVOList.get(0).getVvdCd().substring(8));
						}

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
						bkgCstmsJpBlVO.setLoclTsIndCd(loclTsFlg);
						bkgCstmsJpBlVO.setJpCstmsTrnsCd(loclTsFlg);
						bkgCstmsJpBlVO.setFullMtyCd(japanManifestListBkgInfoVOs.get(0).getBkgCgoTpCd());
						bkgCstmsJpBlVO.setCreUsrId(account.getUsr_id());

						// Prev VVD정보 - 2014.10.21 추가
						if (prevBkgVvdInfoVOList.size() != 0) {
							bkgCstmsJpBlVO.setPreRlyPortCd(prevBkgVvdInfoVOList.get(0).getPodCd());
							bkgCstmsJpBlVO.setPreVslCd(prevBkgVvdInfoVOList.get(0).getVvdCd().substring(0, 4));
							bkgCstmsJpBlVO.setPreSkdVoyNo(prevBkgVvdInfoVOList.get(0).getVvdCd().substring(4, 8));
							bkgCstmsJpBlVO.setPreSkdDirCd(prevBkgVvdInfoVOList.get(0).getVvdCd().substring(8));
						}
						// 일본세관 Manifest 신고용 B/L 정보를 생성한다.
						dbDao.addJpcusBl(bkgCstmsJpBlVO);

						for(JapanManifestListBkgCustInfoVO japanManifestListBkgCustInfoVO : JapanManifestListBkgCustInfoVOList) {
							bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
							bkgCstmsJpBlCustVO.setBlNo(japanManifestListBkgCustInfoVO.getBlNo());
							bkgCstmsJpBlCustVO.setBlSplitNo(k + "");
							bkgCstmsJpBlCustVO.setBkgCustTpCd(japanManifestListBkgCustInfoVO.getBkgCustTpCd());
							bkgCstmsJpBlCustVO.setCustCntCd(japanManifestListBkgCustInfoVO.getCustCntCd());
							bkgCstmsJpBlCustVO.setCustSeq(japanManifestListBkgCustInfoVO.getCustSeq());
							bkgCstmsJpBlCustVO.setCustNm(japanManifestListBkgCustInfoVO.getCustNm());
							bkgCstmsJpBlCustVO.setCustAddr(japanManifestListBkgCustInfoVO.getCustAddr());
							bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());
							// 일본세관 Manifest 신고용 B/L Customer 정보를 생성한다.
							dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
						}

						if (japanManifestListBlMdVOList.size() == 0) {
							bkgCstmsJpBlMkVO.setBlNo(japanManifestListBkgInfoVOs.get(0).getBlNo());
							bkgCstmsJpBlMkVO.setBlSplitNo(k + "");
							bkgCstmsJpBlMkVO.setBlSeq("1");
							bkgCstmsJpBlMkVO.setDiffRmk("N/M");
							bkgCstmsJpBlMkVO.setBlDesc(cstmsDesc.toUpperCase());
							bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());
							// 일본세관 Manifest 신고용 B/L Mark, Description 정보를 생성한다.
							dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);

						} else {
							for(JapanManifestListBlMdVO japanManifestListBlMdVO : japanManifestListBlMdVOList) {
								bkgCstmsJpBlMkVO.setBlNo(japanManifestListBlMdVO.getBlNo());
								bkgCstmsJpBlMkVO.setBlSplitNo(k + "");
								bkgCstmsJpBlMkVO.setBlSeq(japanManifestListBlMdVO.getMkSeq());
								bkgCstmsJpBlMkVO.setDiffRmk(japanManifestListBlMdVO.getMkDesc().replace("'", "''"));
								bkgCstmsJpBlMkVO.setBlDesc(japanManifestListBlMdVO.getCstmsDesc());
								bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());
								// 일본세관 Manifest 신고용 B/L Mark, Description 정보를 생성한다.
								dbDao.addJpcusBlMd(bkgCstmsJpBlMkVO);
							}
						}
					}

					BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO = new BkgCstmsJpBlCntrVO();
					int j = 0;
					for(JapanManifestListBkgCntrInfoVO japanManifestListBkgCntrInfoVO : japanManifestListBkgCntrInfoVOList) {
						bkgCstmsJpBlCntrVO = new BkgCstmsJpBlCntrVO();
						j++;
						bkgCstmsJpBlCntrVO.setBlNo(japanManifestListBkgCntrInfoVO.getBlNo());
						if (j > 100) {
							bkgCstmsJpBlCntrVO.setBlSplitNo(j + "");
						} else {
							bkgCstmsJpBlCntrVO.setBlSplitNo("  ");
						}
						bkgCstmsJpBlCntrVO.setCntrNo(japanManifestListBkgCntrInfoVO.getCntrNo());
						bkgCstmsJpBlCntrVO.setCntrTpszCd(japanManifestListBkgCntrInfoVO.getCntrTpszCd());
						bkgCstmsJpBlCntrVO.setCntrSealNo(japanManifestListBkgCntrInfoVO.getCntrSealNo());
						bkgCstmsJpBlCntrVO.setJpCstmsCntrStsCd("A");
						bkgCstmsJpBlCntrVO.setPrtFlg(japanManifestListBkgCntrInfoVO.getCntrPrtFlg());
						bkgCstmsJpBlCntrVO.setRcvTermCd(japanManifestListBkgCntrInfoVO.getRcvTermCd());
						bkgCstmsJpBlCntrVO.setDeTermCd(japanManifestListBkgCntrInfoVO.getDeTermCd());
						bkgCstmsJpBlCntrVO.setFullMtyCd(japanManifestListBkgInfoVOs.get(0).getBkgCgoTpCd());
						bkgCstmsJpBlCntrVO.setJpCntrOwnrCd(japanManifestListBkgCntrInfoVO.getLstmCd());
						bkgCstmsJpBlCntrVO.setCreUsrId(account.getUsr_id());
						// 일본세관 Manifest 신고용 B/L Container 정보를 생성한다.
						dbDao.addJpcusBlCntr(bkgCstmsJpBlCntrVO);
					}

				} else {
					BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO = new BkgCstmsJpBlCntrVO();
					for(JapanManifestListBkgCntrInfoVO japanManifestListBkgCntrInfoVO : japanManifestListBkgCntrInfoVOList) {
						bkgCstmsJpBlCntrVO = new BkgCstmsJpBlCntrVO();
						bkgCstmsJpBlCntrVO.setBlNo(japanManifestListBkgCntrInfoVO.getBlNo());
						bkgCstmsJpBlCntrVO.setBlSplitNo(japanManifestListBkgCntrInfoVO.getBlSplitNo());
						bkgCstmsJpBlCntrVO.setCntrNo(japanManifestListBkgCntrInfoVO.getCntrNo());
						bkgCstmsJpBlCntrVO.setCntrTpszCd(japanManifestListBkgCntrInfoVO.getCntrTpszCd());
						bkgCstmsJpBlCntrVO.setCntrSealNo(japanManifestListBkgCntrInfoVO.getCntrSealNo());
						bkgCstmsJpBlCntrVO.setJpCstmsCntrStsCd("A");
						bkgCstmsJpBlCntrVO.setPrtFlg(japanManifestListBkgCntrInfoVO.getCntrPrtFlg());
						bkgCstmsJpBlCntrVO.setRcvTermCd(japanManifestListBkgCntrInfoVO.getRcvTermCd());
						bkgCstmsJpBlCntrVO.setDeTermCd(japanManifestListBkgCntrInfoVO.getDeTermCd());
						bkgCstmsJpBlCntrVO.setFullMtyCd(japanManifestListBkgCntrInfoVO.getBkgCgoTpCd());
						bkgCstmsJpBlCntrVO.setJpCntrOwnrCd(japanManifestListBkgCntrInfoVO.getLstmCd());
						bkgCstmsJpBlCntrVO.setCreUsrId(account.getUsr_id());
						// 일본세관 Manifest 신고용 B/L Container 정보를 생성한다.
						dbDao.addJpcusBlCntr(bkgCstmsJpBlCntrVO);
					}
				}
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD, Port 등 입력 후 조회한 세관 MFR 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 *
	 * @param JapanManifestModificationVO[] japanManifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForMfs(JapanManifestModificationVO[] japanManifestModificationVOs, SignOnUserAccount account) throws EventException {
		try {
			BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO = new BkgCstmsJpVslSkdVO();
			JapanManifestModificationVO japanManifestModificationVO = new JapanManifestModificationVO();
			BkgCstmsJpVslVO bkgCstmsJpVslVO = new BkgCstmsJpVslVO();

			if (japanManifestModificationVOs.length > 0) {
				japanManifestModificationVO = japanManifestModificationVOs[0];
				japanManifestModificationVO.setInVslCd(japanManifestModificationVOs[0].getInVvdCd().substring(0, 4));
				japanManifestModificationVO.setInSkdVoyNo(japanManifestModificationVOs[0].getInVvdCd().substring(4, 8));
				japanManifestModificationVO.setInSkdDirCd(japanManifestModificationVOs[0].getInVvdCd().substring(8));
				japanManifestModificationVO.setUpdUsrId(account.getUsr_id());
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
				if (dbDao.modifyVesselInfo(bkgCstmsJpVslVO) == 0) dbDao.addVesselInfo(bkgCstmsJpVslVO);

				bkgCstmsJpVslSkdVO.setVslCd(japanManifestModificationVO.getInVslCd());
				bkgCstmsJpVslSkdVO.setSkdVoyNo(japanManifestModificationVO.getInSkdVoyNo());
				bkgCstmsJpVslSkdVO.setSkdDirCd(japanManifestModificationVO.getInSkdDirCd());
				bkgCstmsJpVslSkdVO.setPodCd(japanManifestModificationVO.getInPodCd());
				bkgCstmsJpVslSkdVO.setCallSgnNo(japanManifestModificationVO.getInCallSgnNo());
				bkgCstmsJpVslSkdVO.setEtaDt(japanManifestModificationVO.getInVpsEtaDt());
				bkgCstmsJpVslSkdVO.setIbCssmVoyNo(japanManifestModificationVO.getInVoyageNo());
				bkgCstmsJpVslSkdVO.setCreUsrId(account.getUsr_id());
				bkgCstmsJpVslSkdVO.setUpdUsrId(account.getUsr_id());
				if (dbDao.modifyJpcusVslSkd(bkgCstmsJpVslSkdVO) == 0) dbDao.addJpcusVslSkd(bkgCstmsJpVslSkdVO);

				JapanManifestModificationVO japanManifestModificationVO2 = new JapanManifestModificationVO();
				for (JapanManifestModificationVO manifestModificationVO : japanManifestModificationVOs) {
					String blNo = manifestModificationVO.getBlNumber();
					if ("D".equals(manifestModificationVO.getIbflag())) {
						japanManifestModificationVO2 = new JapanManifestModificationVO();
						japanManifestModificationVO2.setBlNo(blNo);
						japanManifestModificationVO2.setUpdUsrId(account.getUsr_id());
						dbDao.removeJpcusBl(japanManifestModificationVO2);
					}

					//[CHM-201008075]2011.01.12
					dbDao.modifyCYOperationCode(blNo, japanManifestModificationVO.getInCyOprCd());

					if (!"".equals(manifestModificationVO.getAproNo()) && "Y".equals(manifestModificationVO.getBdTr())) {
						ApprovalCstmsCdVO approvalCstmsCdVO = new ApprovalCstmsCdVO();
						approvalCstmsCdVO.setBlNo(blNo);
						approvalCstmsCdVO.setAproNo(manifestModificationVO.getAproNo());
						approvalCstmsCdVO.setTrspModCd(manifestModificationVO.getTrspModCd());
						approvalCstmsCdVO.setCstmsCd(manifestModificationVO.getDelBnd());
						approvalCstmsCdVO.setDeltFlg("");
						approvalCstmsCdVO.setUsrId(account.getUsr_id());
						dbDao.modifyApprovalCstmsCd(approvalCstmsCdVO);
					}
				}
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD, Port 등 입력 후 조회한 세관 CMF 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 *
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForCmf(ManifestModificationVO manifestModificationVO, SignOnUserAccount account) throws EventException {
		JapanCmfModificationVO japanCmfModificationVO =(JapanCmfModificationVO) manifestModificationVO;
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

				bkgCstmsJpBlCustVO.setBkgCustTpCd("S");
				bkgCstmsJpBlCustVO.setCustCntCd(japanCmfModificationVO.getCustCntCd());
				bkgCstmsJpBlCustVO.setCustSeq(japanCmfModificationVO.getCustSeq());
				bkgCstmsJpBlCustVO.setCustNm(japanCmfModificationVO.getCustNm().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanCmfModificationVO.getCustAddr().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanCmfModificationVO.getPhnNo().replaceAll("-", "").replaceAll(" ", ""));
				bkgCstmsJpBlCustVO.setFaxNo(japanCmfModificationVO.getFaxNo().replaceAll("-", "").replaceAll(" ", ""));
				bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());
				bkgCstmsJpBlCustVO.setUpdUsrId(account.getUsr_id());
				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);

				bkgCstmsJpBlCustVO.setBkgCustTpCd("C");
				bkgCstmsJpBlCustVO.setCustCntCd(japanCmfModificationVO.getCustCntCd2());
				bkgCstmsJpBlCustVO.setCustSeq(japanCmfModificationVO.getCustSeq2());
				bkgCstmsJpBlCustVO.setCustNm(japanCmfModificationVO.getCustNm2().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanCmfModificationVO.getCustAddr2().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanCmfModificationVO.getPhnNo2().replaceAll("-", "").replaceAll(" ", ""));
				bkgCstmsJpBlCustVO.setFaxNo(japanCmfModificationVO.getFaxNo2().replaceAll("-", "").replaceAll(" ", ""));
				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);

				bkgCstmsJpBlCustVO.setBkgCustTpCd("N");
				bkgCstmsJpBlCustVO.setCustCntCd(japanCmfModificationVO.getCustCntCd3());
				bkgCstmsJpBlCustVO.setCustSeq(japanCmfModificationVO.getCustSeq3());
				bkgCstmsJpBlCustVO.setCustNm(japanCmfModificationVO.getCustNm3().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanCmfModificationVO.getCustAddr3().replaceAll("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanCmfModificationVO.getPhnNo3().replaceAll("-", "").replaceAll(" ", ""));
				bkgCstmsJpBlCustVO.setFaxNo(japanCmfModificationVO.getFaxNo3().replaceAll("-", "").replaceAll(" ", ""));
				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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
	public void manageMfrCust(MfrCustModificationVO mfrCustModificationVO, SignOnUserAccount account) throws EventException {
		JapanMfrCustModificationVO japanMfrCustModificationVO =(JapanMfrCustModificationVO) mfrCustModificationVO;

		try {
			if (japanMfrCustModificationVO != null) {
				BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
				bkgCstmsJpBlCustVO.setBlNo(japanMfrCustModificationVO.getBlNumber());
				bkgCstmsJpBlCustVO.setBkgCustTpCd("S");
				bkgCstmsJpBlCustVO.setCustCntCd(japanMfrCustModificationVO.getCustCntCd());
				bkgCstmsJpBlCustVO.setCustSeq(japanMfrCustModificationVO.getCustSeq());
				bkgCstmsJpBlCustVO.setCustNm(japanMfrCustModificationVO.getCustNm().replace("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanMfrCustModificationVO.getCustAddr().replace("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanMfrCustModificationVO.getPhnNo().replaceAll("-", "").replaceAll(" ", ""));
				bkgCstmsJpBlCustVO.setFaxNo(japanMfrCustModificationVO.getFaxNo().replaceAll("-", "").replaceAll(" ", ""));
				bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());
				bkgCstmsJpBlCustVO.setUpdUsrId(account.getUsr_id());
				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);

				bkgCstmsJpBlCustVO.setBkgCustTpCd("C");
				bkgCstmsJpBlCustVO.setCustCntCd(japanMfrCustModificationVO.getCustCntCd2());
				bkgCstmsJpBlCustVO.setCustSeq(japanMfrCustModificationVO.getCustSeq2());
				bkgCstmsJpBlCustVO.setCustNm(japanMfrCustModificationVO.getCustNm2().replace("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanMfrCustModificationVO.getCustAddr2().replace("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanMfrCustModificationVO.getPhnNo2().replaceAll("-", "").replaceAll(" ", ""));
				bkgCstmsJpBlCustVO.setFaxNo(japanMfrCustModificationVO.getFaxNo2().replaceAll("-", "").replaceAll(" ", ""));
				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);

				bkgCstmsJpBlCustVO.setBkgCustTpCd("N");
				bkgCstmsJpBlCustVO.setCustCntCd(japanMfrCustModificationVO.getCustCntCd3());
				bkgCstmsJpBlCustVO.setCustSeq(japanMfrCustModificationVO.getCustSeq3());
				bkgCstmsJpBlCustVO.setCustNm(japanMfrCustModificationVO.getCustNm3().replace("'", "''"));
				bkgCstmsJpBlCustVO.setCustAddr(japanMfrCustModificationVO.getCustAddr3().replace("'", "''"));
				bkgCstmsJpBlCustVO.setPhnNo(japanMfrCustModificationVO.getPhnNo3().replaceAll("-", "").replaceAll(" ", ""));
				bkgCstmsJpBlCustVO.setFaxNo(japanMfrCustModificationVO.getFaxNo3().replaceAll("-", "").replaceAll(" ", ""));
				if (dbDao.modifyJpcusBlCust(bkgCstmsJpBlCustVO) == 0) dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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
	public void manageMfrMnd(MfrMndModificationVO mfrCustModificationVO, SignOnUserAccount account) throws EventException {
		BkgCstmsJpBlVO bkgCstmsJpBlVO = new BkgCstmsJpBlVO();
		BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO = new BkgCstmsJpBlMkVO();

		try {
			JapanMfrMndContainerVO japanMfrMndContainerVO =(JapanMfrMndContainerVO) mfrCustModificationVO;
			JapanMfrMndCondVO japanMfrMndCondVO = japanMfrMndContainerVO.getJapanMfrMndCondVO();
			JapanMfrMndModificationVO[] japanMfrMndModificationVOs = japanMfrMndContainerVO.getJapanMfrMndModificationVOs();

			bkgCstmsJpBlVO.setBlNo(japanMfrMndCondVO.getBlNumber());
			bkgCstmsJpBlVO.setBlSplitNo(japanMfrMndCondVO.getBlSplitNo());
			bkgCstmsJpBlVO.setPckQty(japanMfrMndCondVO.getPckQty());
			bkgCstmsJpBlVO.setPckTpCd(japanMfrMndCondVO.getPckTpCd());
			bkgCstmsJpBlVO.setGrsWgt(japanMfrMndCondVO.getGrsWgt());
			bkgCstmsJpBlVO.setWgtUtCd(japanMfrMndCondVO.getWgtUtCd());
			bkgCstmsJpBlVO.setMeasQty(japanMfrMndCondVO.getMeasQty());
			bkgCstmsJpBlVO.setMeasUtCd(japanMfrMndCondVO.getMeasUtCd());
			bkgCstmsJpBlVO.setLoclTsIndCd(japanMfrMndCondVO.getLoclTsFlg());
			bkgCstmsJpBlVO.setJpCstmsTrnsCd(japanMfrMndCondVO.getJpCstmsTrnsCd());
			bkgCstmsJpBlVO.setLmtNo(japanMfrMndCondVO.getLmtNo());
			bkgCstmsJpBlVO.setCyOprId(japanMfrMndCondVO.getCyOprCd());
			bkgCstmsJpBlVO.setUpdUsrId(account.getUsr_id());

			dbDao.modifyJpcusBl2(bkgCstmsJpBlVO);

			bkgCstmsJpBlMkVO.setBlNo(japanMfrMndCondVO.getBlNumber());
			bkgCstmsJpBlMkVO.setBlSplitNo(japanMfrMndCondVO.getBlSplitNo());
			bkgCstmsJpBlMkVO.setUpdUsrId(account.getUsr_id());
			bkgCstmsJpBlMkVO.setCreUsrId(account.getUsr_id());
			for(int i = 0; i < japanMfrMndModificationVOs.length; i++) {
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

					List<BkgCstmsJpBlMkVO> bkgCstmsJpBlMkVOs = dbDao.searchJpcusBlMd(japanMfrMndCondVO.getBlNumber(), "");
					for(int j = 0; j < bkgCstmsJpBlMkVOs.size(); j++) {
						BkgCstmsJpBlMkVO bkgCstmsJpBlMkVO2 = bkgCstmsJpBlMkVOs.get(j);
						dbDao.modifyJpcusBlMdSeq(bkgCstmsJpBlMkVO2.getBlNo(), bkgCstmsJpBlMkVO2.getBlSplitNo(), bkgCstmsJpBlMkVO2.getBlSeq(), j + 1 + "");
					}
				}
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Vessel Arrival 정보 데이터를 저장한다.<br>
	 *
	 * @param JapanVesselArrivalVO japanVesselArrivalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVesselArrival(JapanVesselArrivalVO japanVesselArrivalVO, SignOnUserAccount account) throws EventException {
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
			if (dbDao.modifyVesselInfo(bkgCstmsJpVslVO) == 0) dbDao.addVesselInfo(bkgCstmsJpVslVO);

			bkgCstmsJpVslSkdVO.setVslCd(japanVesselArrivalVO.getInVvdCd().substring(0, 4));
			bkgCstmsJpVslSkdVO.setSkdVoyNo(japanVesselArrivalVO.getInVvdCd().substring(4, 8));
			bkgCstmsJpVslSkdVO.setSkdDirCd(japanVesselArrivalVO.getInVvdCd().substring(8));
			bkgCstmsJpVslSkdVO.setPodCd(japanVesselArrivalVO.getInPodCd());
			bkgCstmsJpVslSkdVO.setEtaDt(japanVesselArrivalVO.getEtaDt1() + " " + japanVesselArrivalVO.getEtaDt2());
			bkgCstmsJpVslSkdVO.setArrYdId(japanVesselArrivalVO.getArrYdId());
			bkgCstmsJpVslSkdVO.setIbCssmVoyNo(japanVesselArrivalVO.getIbCssmVoyNo());
			bkgCstmsJpVslSkdVO.setCreUsrId(account.getUsr_id());
			bkgCstmsJpVslSkdVO.setUpdUsrId(account.getUsr_id());
			if (dbDao.modifyJpcusVslSkd2(bkgCstmsJpVslSkdVO) == 0) dbDao.addJpcusVslSkd2(bkgCstmsJpVslSkdVO);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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
		JapanBlKeyVO japanBlKeyVO =(JapanBlKeyVO) blKeyVO;

		try {
			dbDao.modifyJpcusBlStatus(japanBlKeyVO);
			dbDao.modifyJpcusBlCntrStatus(japanBlKeyVO);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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
	public void manageMfrCntr(MfrCntrModificationVO[] mfrCntrModificationVOs, SignOnUserAccount account) throws EventException {
		JapanMfrCntrModificationVO[] japanMfrCntrModificationVOs =(JapanMfrCntrModificationVO[]) mfrCntrModificationVOs;
		String blNo = "";

		try {
			for(int i = 0; i < japanMfrCntrModificationVOs.length; i++) {
				JapanMfrCntrModificationVO japanMfrCntrModificationVO = japanMfrCntrModificationVOs[i];
				blNo = japanMfrCntrModificationVOs[0].getBlNo();
				BkgCstmsJpBlCntrVO bkgCstmsJpBlCntrVO = new BkgCstmsJpBlCntrVO();
				bkgCstmsJpBlCntrVO.setBlNo(blNo);
				bkgCstmsJpBlCntrVO.setBlSplitNo("  ");
				bkgCstmsJpBlCntrVO.setCntrNo(japanMfrCntrModificationVO.getCntrNo());
				bkgCstmsJpBlCntrVO.setCntrSealNo(japanMfrCntrModificationVO.getCntrSealNo());
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

			if (japanMfrCntrModificationVOs.length > 100) {
				int loopCount =(japanMfrCntrModificationVOs.length -(japanMfrCntrModificationVOs.length % 100)) / 100;
				for(int i = 0; i < loopCount; i++) {
					blNo = japanMfrCntrModificationVOs[0].getBlNo();

					int blCount = dbDao.searchBkgBlCount(blNo, loopCount + "");
					if (blCount == 0) {
						List<BkgCstmsJpBlVO> bkgCstmsJpBlVOs = dbDao.searchJpcusBl(blNo, "  ");
						if (bkgCstmsJpBlVOs.size() > 0) {
							bkgCstmsJpBlVOs.get(0).setBlSplitNo(loopCount + "");
							bkgCstmsJpBlVOs.get(0).setSplitFlg("Y");
							bkgCstmsJpBlVOs.get(0).setCreUsrId(account.getUsr_id());
							dbDao.addJpcusBl(bkgCstmsJpBlVOs.get(0));
						}

						List<BkgCstmsJpBlCustVO> bkgCstmsJpBlCustVOs = dbDao.searchJpcusBlCust(blNo, bkgCstmsJpBlVOs.get(0).getBlSplitNo());
						for(int j = 0; j < bkgCstmsJpBlCustVOs.size(); j++) {
							bkgCstmsJpBlCustVOs.get(j).setBlSplitNo(loopCount + "");
							bkgCstmsJpBlCustVOs.get(j).setCreUsrId(account.getUsr_id());
							dbDao.addJpcusBlCust(bkgCstmsJpBlCustVOs.get(j));
						}

						List<BkgCstmsJpBlMkVO> bkgCstmsJpBlMkVOs = dbDao.searchJpcusBlMd(blNo, bkgCstmsJpBlVOs.get(0).getBlSplitNo());
						for(int j = 0; j < bkgCstmsJpBlMkVOs.size(); j++) {
							bkgCstmsJpBlMkVOs.get(j).setBlSplitNo(loopCount + "");
							bkgCstmsJpBlCustVOs.get(j).setCreUsrId(account.getUsr_id());
							dbDao.addJpcusBlMd(bkgCstmsJpBlMkVOs.get(j));
						}

						List<BkgCstmsJpBlCntrVO> bkgCstmsJpBlCntrVOs = dbDao.searchJpcusBlCntr(blNo);
						for(int j = 0; j < bkgCstmsJpBlCntrVOs.size(); j++) {
							if (j > 100) {
								bkgCstmsJpBlCntrVOs.get(j).setBlSplitNo(loopCount + "");
								bkgCstmsJpBlCustVOs.get(j).setUpdUsrId(account.getUsr_id());
								dbDao.modifyJpcusBlCntrSplitNo(bkgCstmsJpBlCntrVOs.get(j));
							}
						}
					}
				}
				dbDao.modifyJpcusBlSplitInd(japanMfrCntrModificationVOs[0].getBlNo());
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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
		JapanManifestListMfrCondVO japanManifestListMfrCondVO =(JapanManifestListMfrCondVO) manifestListCondVO;
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

			return(ManifestListDetailVO) japanManifestListMfrCustInfoVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 신고 대상 Marks & Description 정보를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return JapanContainerVO
	 * @exception EventException
	 */
	public JapanContainerVO searchMfrMnd(ManifestListCondVO manifestListCondVO) throws EventException {
		JapanManifestListMfrCondVO japanManifestListMfrCondVO =(JapanManifestListMfrCondVO) manifestListCondVO;
		List<BkgCstmsJpBlMkVO> bkgCstmsJpBlMkVOs = null;
		List<BkgCstmsJpBlVO> bkgCstmsJpBlVOs = null;
		JapanContainerVO japanContainerVO = new JapanContainerVO();

		String blNumber = "";

		try {
			blNumber = japanManifestListMfrCondVO.getBlNumber();

			bkgCstmsJpBlVOs = dbDao.searchJpcusBl(blNumber, "");
			bkgCstmsJpBlMkVOs = dbDao.searchJpcusBlMd(blNumber, "");
			if (bkgCstmsJpBlVOs.size() != 0)
				japanContainerVO.setBkgCstmsJpBlVO(bkgCstmsJpBlVOs.get(0));

			japanContainerVO.setBkgCstmsJpBlMkVOs(bkgCstmsJpBlMkVOs);

			return japanContainerVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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
		JapanManifestListMfrCondVO japanManifestListMfrCondVO =(JapanManifestListMfrCondVO) manifestListCondVO;

		try {
			return(List<ManifestListDetailVO>) (Object) dbDao.searchMfrCntr(japanManifestListMfrCondVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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
		JapanBlVO japanBlVO =(JapanBlVO) blVO;

		try {
			BkgCstmsJpBlVO bkgCstmsJpBlVO = new BkgCstmsJpBlVO();
			bkgCstmsJpBlVO.setBlNo(japanBlVO.getDummyBlNo());
			bkgCstmsJpBlVO.setBlSplitNo("  ");
			bkgCstmsJpBlVO.setVslCd(japanBlVO.getVvdCd().substring(0, 4));
			bkgCstmsJpBlVO.setSkdVoyNo(japanBlVO.getVvdCd().substring(4, 8));
			bkgCstmsJpBlVO.setSkdDirCd(japanBlVO.getVvdCd().substring(8));
			bkgCstmsJpBlVO.setPodCd(japanBlVO.getPodCd());
			bkgCstmsJpBlVO.setFullMtyCd(japanBlVO.getStage());
			bkgCstmsJpBlVO.setCreUsrId(account.getUsr_id());
			dbDao.addJpcusBl(bkgCstmsJpBlVO);

			BkgCstmsJpBlCustVO bkgCstmsJpBlCustVO = new BkgCstmsJpBlCustVO();
			bkgCstmsJpBlCustVO.setBlNo(japanBlVO.getDummyBlNo());
			bkgCstmsJpBlCustVO.setBlSplitNo("  ");
			bkgCstmsJpBlCustVO.setCreUsrId(account.getUsr_id());
			bkgCstmsJpBlCustVO.setBkgCustTpCd("S");
			dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
			bkgCstmsJpBlCustVO.setBkgCustTpCd("C");
			dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);
			bkgCstmsJpBlCustVO.setBkgCustTpCd("N");
			dbDao.addJpcusBlCust(bkgCstmsJpBlCustVO);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return JapanContainerVO
	 * @exception EventException
	 */
	public JapanContainerVO searchManifestListForDl(ManifestListCondVO manifestListCondVO) throws EventException {
		JapanManifestListCondVO japanManifestListCondVO =(JapanManifestListCondVO) manifestListCondVO;
		List<JapanManifestListVslPortSkdVO> japanManifestListVslPortSkdVOs = new ArrayList<JapanManifestListVslPortSkdVO>();;
		List<JapanManifestListBkgDetailVO> japanManifestListBkgDetailVOs = new ArrayList<JapanManifestListBkgDetailVO>();;
		List<JapanManifestListBkgDetailVO> japanManifestListBkgDetailVOs2 = new ArrayList<JapanManifestListBkgDetailVO>();
		List<JapanManifestListBkgDetail2VO> japanManifestListBkgDetail2VOs = new ArrayList<JapanManifestListBkgDetail2VO>();;
		List<JapanManifestListCntrDetailVO> japanManifestListCntrDetailVOs2 = new ArrayList<JapanManifestListCntrDetailVO>();
		List<JapanManifestListCntrDetailVO> japanManifestListCntrDetailVOs = new ArrayList<JapanManifestListCntrDetailVO>();;
		JapanManifestListBkgDetailVO japanManifestListBkgDetailVO = new JapanManifestListBkgDetailVO();
		JapanManifestListCntrDetailVO japanManifestListCntrDetailVO = new JapanManifestListCntrDetailVO();
		JapanContainerVO japanContainerVO = new JapanContainerVO();

		try {
			japanManifestListCondVO.setInVslCd(japanManifestListCondVO.getInVvdCd().substring(0, 4));
			japanManifestListCondVO.setInSkdVoyNo(japanManifestListCondVO.getInVvdCd().substring(4, 8));
			japanManifestListCondVO.setInSkdDirCd(japanManifestListCondVO.getInVvdCd().substring(8));

			// Vessel Port Schedule Call Indicator를 조회한다.
			List<VpsCallIndInfoVO> vpsCallIndInfoVOs = dbDao.searchVpsCallInd(japanManifestListCondVO);
			if ( vpsCallIndInfoVOs.size() > 0)
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
				for(int i = 0; i < japanManifestListBkgDetailVOs.size(); i++) {
					if (japanManifestListBkgDetailVOs.get(i).getBlNo().equals(blNo)) {
						japanManifestListBkgDetailVOs.get(i).setSeq(seqNumber + "");
					} else {
						blNo = japanManifestListBkgDetailVOs.get(i).getBlNo();
						japanManifestListBkgDetailVOs.get(i).setSeq(++seqNumber + "");
					}
				}
			}

			String vvdPolCd = "";
			int polCount = 0;
			for(int i = 0; i < japanManifestListBkgDetailVOs.size(); i++) {
				japanManifestListBkgDetailVO = japanManifestListBkgDetailVOs.get(i);
				JapanManifestListBkgDetailVO japanManifestListBkgDetailVO2 = new JapanManifestListBkgDetailVO();

				if (!vvdPolCd.equals(japanManifestListBkgDetailVOs.get(i).getVvdPolCd())) {

					japanManifestListBkgDetailVO2.setBlNo("POL : " + japanManifestListBkgDetailVO.getVvdPolCd());
					japanManifestListBkgDetailVO2.setBkgNo("ETD : " + japanManifestListBkgDetailVO.getVpsEtdDt());

					if (i == 0) {
						japanManifestListBkgDetailVOs2.add(i, japanManifestListBkgDetailVO2);
						polCount++;
						for(int j = i; j < japanManifestListBkgDetailVOs.size(); j++) {
							japanManifestListBkgDetailVOs2.add(j + polCount, japanManifestListBkgDetailVOs.get(j));
						}
					} else {
						japanManifestListBkgDetailVOs2.set(i + polCount, japanManifestListBkgDetailVO2);
						for(int j = i + polCount + 1; j - polCount - 1 < japanManifestListBkgDetailVOs.size(); j++) {
							if (j >= japanManifestListBkgDetailVOs2.size())
								japanManifestListBkgDetailVOs2.add(j, japanManifestListBkgDetailVOs.get(j - polCount - 1));
							else
								japanManifestListBkgDetailVOs2.set(j, japanManifestListBkgDetailVOs.get(j - polCount - 1));
						}
						polCount++;
					}
					vvdPolCd = japanManifestListBkgDetailVO.getVvdPolCd();
				}
			}

			japanManifestListBkgDetailVOs = japanManifestListBkgDetailVOs2;
			japanContainerVO.setJapanManifestListBkgDetailVOs(japanManifestListBkgDetailVOs);

			if (japanManifestListBkgDetail2VOs.size() != 0) {
				String blNo = japanManifestListBkgDetail2VOs.get(0).getBlNo();
				int seqNumber = 1;
				for(int i = 0; i < japanManifestListBkgDetail2VOs.size(); i++) {
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
				for(int i = 0; i < japanManifestListCntrDetailVOs.size(); i++) {
					if (japanManifestListCntrDetailVOs.get(i).getBlNo().equals(blNo)) {
						japanManifestListCntrDetailVOs.get(i).setSeq(seqNumber + "");
					} else {
						blNo = japanManifestListCntrDetailVOs.get(i).getBlNo();
						japanManifestListCntrDetailVOs.get(i).setSeq(++seqNumber + "");
					}
				}
			}

			polCount = 0;
			vvdPolCd = "";
			for(int i = 0; i < japanManifestListCntrDetailVOs.size(); i++) {
				japanManifestListCntrDetailVO = japanManifestListCntrDetailVOs.get(i);
				JapanManifestListCntrDetailVO japanManifestListCntrDetailVO2 = new JapanManifestListCntrDetailVO();

				if (!vvdPolCd.equals(japanManifestListCntrDetailVOs.get(i).getPolCd())) {
					japanManifestListCntrDetailVO2.setBlNo("POL : " + japanManifestListCntrDetailVO.getPolCd() + "      ETD : " + japanManifestListCntrDetailVO.getVpsEtdDt());
					if (i == 0) {
						japanManifestListCntrDetailVOs2.add(i, japanManifestListCntrDetailVO2);
						polCount++;
						for(int j=i; j<japanManifestListCntrDetailVOs.size(); j++) {
							japanManifestListCntrDetailVOs2.add(j + polCount, japanManifestListCntrDetailVOs.get(j));
						}

					} else {
						japanManifestListCntrDetailVOs2.set(i + polCount, japanManifestListCntrDetailVO2);
						for(int j=i+polCount+1; j-polCount-1<japanManifestListCntrDetailVOs.size(); j++) {
							if (j >= japanManifestListCntrDetailVOs2.size()) {
								japanManifestListCntrDetailVOs2.add(j, japanManifestListCntrDetailVOs.get(j-polCount-1));
							} else {
								japanManifestListCntrDetailVOs2.set(j, japanManifestListCntrDetailVOs.get(j-polCount-1));
							}
						}
						polCount++;
					}
					vvdPolCd = japanManifestListCntrDetailVO.getPolCd();
				}
			}

			japanManifestListCntrDetailVOs = japanManifestListCntrDetailVOs2;
			japanContainerVO.setJapanManifestListCntrDetailVOs(japanManifestListCntrDetailVOs);

			return japanContainerVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(MFS 데이터) 를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return JapanContainerVO
	 * @exception EventException
	 */
	public JapanContainerVO searchManifestListForMfs(ManifestListCondVO manifestListCondVO) throws EventException {
		JapanManifestListCondVO japanManifestListCondVO =(JapanManifestListCondVO) manifestListCondVO;
		List<JapanManifestListMfsDetailVO> japanManifestListMfsDetailVOs = null;
		JapanManifestListEtcVO japanManifestListEtcVO = new JapanManifestListEtcVO();
		JapanContainerVO japanContainerVO = new JapanContainerVO();
		String callSgnNo = "";
		String etaDt = "";
		String cstmsMfId = "";
		String ibCssmVoyNo = "";
		String downloadYn = "";

		try {
			japanManifestListCondVO.setInVslCd(japanManifestListCondVO.getInVvdCd().substring(0, 4));
			japanManifestListCondVO.setInSkdVoyNo(japanManifestListCondVO.getInVvdCd().substring(4, 8));
			japanManifestListCondVO.setInSkdDirCd(japanManifestListCondVO.getInVvdCd().substring(8));

			// Vessel Port Schedule Call Indicator를 조회한다.
			List<JapanManifestListEtcVO> japanManifestListEtcVOList = dbDao.searchJpcusEta(japanManifestListCondVO);
			if (japanManifestListEtcVOList.size() > 0) {
				etaDt = japanManifestListEtcVOList.get(0).getEtaDt();
				cstmsMfId = japanManifestListEtcVOList.get(0).getCstmsMfId();
				ibCssmVoyNo = japanManifestListEtcVOList.get(0).getIbCssmVoyNo();
				downloadYn = "Y";
				if (!japanManifestListEtcVOList.get(0).getCallSgnNo().equals("")) {
					callSgnNo = japanManifestListEtcVOList.get(0).getCallSgnNo();
				}
			} else {
				String[] rtnVal = dbDao.searchEta(japanManifestListCondVO);
				etaDt = rtnVal[0];
				ibCssmVoyNo = rtnVal[1];
			}
			if (etaDt.equals("")) {
				throw new EventException(new ErrorHandler("BKG00889", new String[] {}).getMessage());
			} else {
				japanManifestListEtcVO.setEtaDt(etaDt);
			}

			if (callSgnNo.equals("")) callSgnNo = dbDao.searchVslCallsign(japanManifestListCondVO.getInVslCd());
			if (callSgnNo.equals("")) {
				throw new EventException(new ErrorHandler("BKG00889", new String[] {}).getMessage());
			} else {
				japanManifestListEtcVO.setCallSgnNo(callSgnNo);
			}

			japanManifestListEtcVO.setCstmsMfId(cstmsMfId);
			japanManifestListEtcVO.setIbCssmVoyNo(ibCssmVoyNo);
			japanManifestListEtcVO.setDownloadYn(downloadYn);

			if (!etaDt.equals("") && !callSgnNo.equals("")) {
				japanManifestListCondVO.setInCallSgnNo(callSgnNo);
				japanManifestListCondVO.setInEtaDt(etaDt);
			}
			japanManifestListMfsDetailVOs = dbDao.searchMfsDetail(japanManifestListCondVO);
			for (JapanManifestListMfsDetailVO japanManifestListMfsDetailVO : japanManifestListMfsDetailVOs) {
				if (!"".equals(japanManifestListMfsDetailVO.getCyOprCd())) {
					japanManifestListEtcVO.setCyOprId(japanManifestListMfsDetailVO.getCyOprCd());
					break;
				}
			}
			if (japanManifestListMfsDetailVOs.size() != 0) {
				japanManifestListEtcVO.setIbCssmVoyNo(japanManifestListEtcVO.getIbCssmVoyNo().trim());
				japanManifestListEtcVO.setCyOprId(japanManifestListEtcVO.getCyOprId().trim());

				String blNumber = japanManifestListMfsDetailVOs.get(0).getBlNumber();
				int seqNumber = 1;
				for (int i=0; i<japanManifestListMfsDetailVOs.size(); i++) {
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

			return japanContainerVO;

		} catch(EventException ex) {
			throw ex;
		}  catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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
		JapanManifestListCondVO japanManifestListCondVO =(JapanManifestListCondVO) manifestListCondVO;
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

			String podSplitCd = "";
			List<VpsCallIndInfoVO> vpsCallIndInfoVOs = dbDao.searchVpsCallInd(japanManifestListCondVO);
			if ( vpsCallIndInfoVOs.size() > 0) {
				japanManifestListCondVO.setInCallInd(vpsCallIndInfoVOs.get(0).getClptIndSeq());
				podSplitCd = vpsCallIndInfoVOs.get(0).getCstmsMfId();
			}
			japanManifestListCmfDetailVOs = dbDao.searchCmfDetail(japanManifestListCondVO);
			if (japanManifestListCmfDetailVOs.size() > 0) {
				japanManifestListCmfDetailVO = japanManifestListCmfDetailVOs.get(0);
				japanManifestListCmfDetailVO.setPodSplitCd(podSplitCd);
			}

			return(ManifestListDetailVO) japanManifestListCmfDetailVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
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

		try {
			return (List<ManifestListDetailVO>) (Object)dbDao.searchDorList();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본 세관에 신고할 대상 Vessel Arrival 정보 데이터를 조회한다.<br>
	 *
	 * @param JapanVesselArrivalVO japanVesselArrivalVO
	 * @return List<JapanVesselArrivalVO>
	 * @exception EventException
	 */
	public List<JapanVesselArrivalVO> searchVesselArrival(JapanVesselArrivalVO japanVesselArrivalVO) throws EventException {

		try {
			return dbDao.searchVslEtaDmfRemark(japanVesselArrivalVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 전송용 Manifest B/L Status를 Active or Deleted로 업데이트한다.<br>
	 *
	 * @param List<JapanTransmitBlKeyVO> japanBlKeyVOs
	 * @exception EventException
	 */
	public void modifyMsgStatus(List<JapanTransmitBlKeyVO> japanBlKeyVOs) throws EventException {

		try {
			for( int i=0; i<japanBlKeyVOs.size(); i++) {
				JapanTransmitBlKeyVO japanBlKeyVO = japanBlKeyVOs.get(i);
				dbDao.modifyMsgStatus(japanBlKeyVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival (from BKG_CSTMS_JP_BL) 조회<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @return List<ApprovalCstmsCdVO>
	 * @exception EventException
	 */
	public List<ApprovalCstmsCdVO> searchAproNoFromJpBl(ApprovalCstmsCdVO approvalCstmsCdVO) throws EventException {
		try {
			return dbDao.searchAproNoFromJpBl(approvalCstmsCdVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival (from BKG_CSTMS_JP_WH_ROUT) 조회<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @return List<ApprovalCstmsCdVO>
	 * @exception EventException
	 */
	public List<ApprovalCstmsCdVO> searchAproNoFromWhRout(ApprovalCstmsCdVO approvalCstmsCdVO) throws EventException {
		try {
			return dbDao.searchAproNoFromWhRout(approvalCstmsCdVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival 목록 저장<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApprovalCstmsCd(ApprovalCstmsCdVO approvalCstmsCdVO, SignOnUserAccount account) throws EventException {
		try {
			if (approvalCstmsCdVO != null) {
				approvalCstmsCdVO.setUsrId(account.getUsr_id());
				dbDao.modifyApprovalCstmsCd(approvalCstmsCdVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1511]
	 * Bonded Place Code 목록 조회<br>
	 *
	 * @param CstmsJpWhVO cstmsJpWhVO
	 * @return List<CstmsJpWhVO>
	 * @exception EventException
	 */
	public List<CstmsJpWhVO> searchCstmsJpWh(CstmsJpWhVO cstmsJpWhVO) throws EventException {
		try {
			return dbDao.searchCstmsJpWh(cstmsJpWhVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1511]
	 * Bonded Place Code 목록 저장<br>
	 *
	 * @param CstmsJpWhVO[] cstmsJpWhVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsJpWh(CstmsJpWhVO[] cstmsJpWhVOs, SignOnUserAccount account) throws EventException {
		List<CstmsJpWhVO> insertCstmsJpWhVOList = new ArrayList<CstmsJpWhVO>();
		List<CstmsJpWhVO> updateCstmsJpWhVOList = new ArrayList<CstmsJpWhVO>();
		List<CstmsJpWhVO> deleteCstmsJpWhVOList = new ArrayList<CstmsJpWhVO>();

		try {
			if (cstmsJpWhVOs != null) {
				for(CstmsJpWhVO cstmsJpWhVO : cstmsJpWhVOs) {
					if ("I".equals(cstmsJpWhVO.getIbflag())) {
						cstmsJpWhVO.setUsrId(account.getUsr_id());
						insertCstmsJpWhVOList.add(cstmsJpWhVO);
					} else if ("U".equals(cstmsJpWhVO.getIbflag())) {
						cstmsJpWhVO.setUsrId(account.getUsr_id());
						updateCstmsJpWhVOList.add(cstmsJpWhVO);
					} else if ("D".equals(cstmsJpWhVO.getIbflag())) {
						deleteCstmsJpWhVOList.add(cstmsJpWhVO);
					}
				}
				if (insertCstmsJpWhVOList.size() > 0) dbDao.addCstmsJpWh(insertCstmsJpWhVOList);
				if (updateCstmsJpWhVOList.size() > 0) dbDao.modifyCstmsJpWh(updateCstmsJpWhVOList);
				if (deleteCstmsJpWhVOList.size() > 0) dbDao.removeCstmsJpWh(deleteCstmsJpWhVOList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1512]
	 * CSTMS_CD Combo Item 목록 조회<br>
	 *
	 * @param CstmsJpWhRoutVO cstmsJpWhRoutVO
	 * @return List<CstmsJpWhRoutVO>
	 * @exception EventException
	 */
	public List<CstmsJpWhRoutVO> getComboCstmsCd(CstmsJpWhRoutVO cstmsJpWhRoutVO) throws EventException {
		try {
			return dbDao.getComboCstmsCd(cstmsJpWhRoutVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1512]
	 * Approval Number and Place of Arrival 목록 조회<br>
	 *
	 * @param CstmsJpWhRoutVO cstmsJpWhRoutVO
	 * @return List<CstmsJpWhRoutVO>
	 * @exception EventException
	 */
	public List<CstmsJpWhRoutVO> searchCstmsJpWhRout(CstmsJpWhRoutVO cstmsJpWhRoutVO) throws EventException {
		try {
			return dbDao.searchCstmsJpWhRout(cstmsJpWhRoutVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1512]
	 * Approval Number and Place of Arrival 목록 저장<br>
	 *
	 * @param CstmsJpWhRoutVO[] cstmsJpWhRoutVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsJpWhRout(CstmsJpWhRoutVO[] cstmsJpWhRoutVOs, SignOnUserAccount account) throws EventException {
		List<CstmsJpWhRoutVO> insertCstmsJpWhRoutVOList = new ArrayList<CstmsJpWhRoutVO>();
		List<CstmsJpWhRoutVO> updateCstmsJpWhRoutVOList = new ArrayList<CstmsJpWhRoutVO>();
		List<CstmsJpWhRoutVO> deleteCstmsJpWhRoutVOList = new ArrayList<CstmsJpWhRoutVO>();

		try {
			if (cstmsJpWhRoutVOs != null) {
				for(CstmsJpWhRoutVO cstmsJpWhRoutVO : cstmsJpWhRoutVOs) {
					if ("I".equals(cstmsJpWhRoutVO.getIbflag())) {
						cstmsJpWhRoutVO.setUsrId(account.getUsr_id());
						insertCstmsJpWhRoutVOList.add(cstmsJpWhRoutVO);
					} else if ("U".equals(cstmsJpWhRoutVO.getIbflag())) {
						cstmsJpWhRoutVO.setUsrId(account.getUsr_id());
						updateCstmsJpWhRoutVOList.add(cstmsJpWhRoutVO);
					} else if ("D".equals(cstmsJpWhRoutVO.getIbflag())) {
						deleteCstmsJpWhRoutVOList.add(cstmsJpWhRoutVO);
					}
				}
				if (insertCstmsJpWhRoutVOList.size() > 0) dbDao.addCstmsJpWhRout(insertCstmsJpWhRoutVOList);
				if (updateCstmsJpWhRoutVOList.size() > 0) dbDao.modifyCstmsJpWhRout(updateCstmsJpWhRoutVOList);
				if (deleteCstmsJpWhRoutVOList.size() > 0) dbDao.removeCstmsJpWhRout(deleteCstmsJpWhRoutVOList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


}

