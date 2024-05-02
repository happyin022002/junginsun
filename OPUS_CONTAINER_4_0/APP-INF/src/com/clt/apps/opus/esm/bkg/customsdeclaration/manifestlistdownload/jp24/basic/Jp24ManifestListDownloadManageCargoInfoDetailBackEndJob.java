/*========================================================= 
*Copyright(c) 2013 CyberLogitec
*@FileName : Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob
*@FileTitle : Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.20
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpCustomerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BkgBookingVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BkgQuantityVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * @author KIM Sang-Soo
 * @see ESM_BKG_1501 EventResponse, Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	private CargoInfoHeaderVO cargoInfoHeaderVO;
	private CargoInfoDetailVO[] cargoInfoDetailVOs;
	private SignOnUserAccount signOnUserAccount;
	// Database Access Object
	private Jp24ManifestListDownloadDBDAO dbDao = new Jp24ManifestListDownloadDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 */
	public void setCargoInfoHeaderVO(CargoInfoHeaderVO cargoInfoHeaderVO) {
		this.cargoInfoHeaderVO = cargoInfoHeaderVO;
	}

	/**
	 * 데이터 세팅
	 *
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 */
	public void setCargoInfoDetailVOs(CargoInfoDetailVO[] cargoInfoDetailVOs) {
		if (cargoInfoDetailVOs != null) {
			CargoInfoDetailVO[] tmpVOs = Arrays.copyOf(cargoInfoDetailVOs, cargoInfoDetailVOs.length);
			this.cargoInfoDetailVOs = tmpVOs;
		}
	}

	/**
	 * 데이터 세팅
	 *
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}

	/**
	 * Back End Job Result
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		CargoInfoHeaderVO headerVO = this.cargoInfoHeaderVO;    // 조회조건
		CargoInfoDetailVO[] detailVOs = this.cargoInfoDetailVOs;    // Sheet내용
		SignOnUserAccount account = this.signOnUserAccount;

		List<AdvJpBlVO> deleteAdvJpBlVOList = new ArrayList<AdvJpBlVO>();    // 저장전 삭제용
		List<AdvJpBlVO> insertAdvJpBlVOList = new ArrayList<AdvJpBlVO>();    // BKG_CSTMS_ADV_JP_BL 저장용

		List<AdvJpCustomerVO> bkgCustomerVOList = new ArrayList<AdvJpCustomerVO>();    // BKG_CUSTOMER 저장용
		List<AdvJpMarkDescVO> bkgMarkVOList = new ArrayList<AdvJpMarkDescVO>();    // BKG_BL_MK_DESC 조회
		List<AdvJpContainerVO> bkgContainerVOList = new ArrayList<AdvJpContainerVO>();    // BKG_CONTAINER 조회용

		BkgBookingVO bkgBookingVO = new BkgBookingVO();
		AdvJpBlVO advJpBlVO = new AdvJpBlVO();
		List<AdvJpCustomerVO> insertAdvJpCustomerVOList = new ArrayList<AdvJpCustomerVO>();    // BKG_CSTMS_ADV_JP_CUST 저장용
		AdvJpMarkDescVO advJpMarkDescVO = null;
		List<AdvJpMarkDescVO> insertAdvJpMarkDescVOList = new ArrayList<AdvJpMarkDescVO>();    // BKG_CSTMS_ADV_JP_MK 저장용
		List<AdvJpContainerVO> insertAdvJpContainerVOList = new ArrayList<AdvJpContainerVO>();    // BKG_CSTMS_ADV_JP_CNTR 저장용

		try {
			// BKG_CSTMS_ADV_JP_VSL_SKD 정보 조회
			List<CargoInfoHeaderVO> tempAdvJpVslSkdVOList = dbDao.searchAdvJpVslSkd(headerVO);
			// BKG_CSTMS_ADV_JP_VSL_SKD 정보 삭제
			dbDao.removeAdvJpVslSkd(headerVO);
			// BKG_CSTMS_ADV_JP_VSL_SKD 정보 다시 insert
			headerVO.setUsrId(account.getUsr_id());
			if (tempAdvJpVslSkdVOList.size() > 0) {
				headerVO.setVpsDt(tempAdvJpVslSkdVOList.get(0).getVpsDt());
				headerVO.setRlxDiv(tempAdvJpVslSkdVOList.get(0).getRlxDiv());
				headerVO.setMfSndFlg(tempAdvJpVslSkdVOList.get(0).getMfSndFlg());
				headerVO.setFnlEdiSndFlg(tempAdvJpVslSkdVOList.get(0).getFnlEdiSndFlg());
			}
			dbDao.addAdvJpVslSkd(headerVO);

			String prvBlNo = "";
			String blNo = "";
			String bkgNo = "";
			String loclTsFlg = "";

			for (CargoInfoDetailVO cargoInfoDetailVO : detailVOs) {
				// 직전 bl_no와 같다면 skip
				if (prvBlNo.equals(cargoInfoDetailVO.getBlNo())) continue;

				blNo = cargoInfoDetailVO.getBlNo();

				// BKG_BOOKING 정보 조회
				bkgNo = "";
				bkgBookingVO = new BkgBookingVO();
				List<BkgBookingVO> bkgBookingVOList = dbDao.searchBkgBooking(blNo);
				if (bkgBookingVOList.size() < 1) continue;
				bkgBookingVO = bkgBookingVOList.get(0);
				bkgNo = bkgBookingVO.getBkgNo();

				// BKG_CSTMS_ADV_JP_BL 신규 저장정보 생성 [S]

				BigDecimal measQty = BigDecimal.valueOf(Double.valueOf(bkgBookingVO.getMeasQty()));
				// 0 > measQty : 1 // 0 == measQty : 0 // 0 < measQty : -1
				if (0 == BigDecimal.valueOf(0L).compareTo(measQty)) {
					List<BkgQuantityVO> bkgQuantityVOList = dbDao.searchBkgQuantity(bkgNo);    // BKG_QUANTITY 정보 조회
					for (BkgQuantityVO bkgQuantityVO : bkgQuantityVOList) {
						if (Integer.valueOf(bkgQuantityVO.getCntrTpszCd()) < 3) {
							// measQty += (20 * bkgQuantityVO.getOpCntrQty())
							measQty = measQty.add(BigDecimal.valueOf(Double.valueOf(bkgQuantityVO.getOpCntrQty()))).multiply(BigDecimal.valueOf(20L));
						} else {
							measQty = measQty.add(BigDecimal.valueOf(Double.valueOf(bkgQuantityVO.getOpCntrQty()))).multiply(BigDecimal.valueOf(40L));
						}
					}
					// 1 > measQty : 1 // 1 == measQty : 0 // 1 < measQty : -1
					if (1 == BigDecimal.valueOf(1L).compareTo(measQty)) measQty = BigDecimal.valueOf(1L);
				}

				loclTsFlg = "";
				if (!cargoInfoDetailVO.getVvdPodCd().equals(cargoInfoDetailVO.getBkgPodCd())) loclTsFlg = "T";
				advJpBlVO = new AdvJpBlVO();
				advJpBlVO.setBlNo(blNo);
				advJpBlVO.setBlSplitNo("  ");
				advJpBlVO.setVvd(headerVO.getVvd());
				advJpBlVO.setPolCd(headerVO.getPolCd());
				advJpBlVO.setPodCd(cargoInfoDetailVO.getVvdPodCd());
				advJpBlVO.setBkgPorCd(bkgBookingVO.getPorCd());
				advJpBlVO.setBkgPolCd(bkgBookingVO.getPolCd());
				advJpBlVO.setBkgDelCd(bkgBookingVO.getDelCd());
				advJpBlVO.setPckQty(bkgBookingVO.getPckQty());
				advJpBlVO.setPckTpCd(bkgBookingVO.getPckTpCd());
				advJpBlVO.setGrsWgt(bkgBookingVO.getActWgt());
				advJpBlVO.setWgtUtCd(bkgBookingVO.getKgs());
				advJpBlVO.setMeasQty(String.valueOf(measQty));
				advJpBlVO.setMeasUtCd(bkgBookingVO.getCbm());
				advJpBlVO.setRcvTermCd(bkgBookingVO.getRcvTermCd());
				advJpBlVO.setDeTermCd(bkgBookingVO.getDeTermCd());
				advJpBlVO.setDcgoFlg(bkgBookingVO.getDcgoFlg());
				advJpBlVO.setBdrFlg(bkgBookingVO.getBdrFlg());
				advJpBlVO.setBdrDt(bkgBookingVO.getBrdDt());
				advJpBlVO.setLoclTsFlg(loclTsFlg);
				advJpBlVO.setJpCstmsTrnsCd(loclTsFlg);
				advJpBlVO.setFullMtyCd(bkgBookingVO.getBkgCgoTpCd());
				advJpBlVO.setCmdtCd(bkgBookingVO.getCmdtCd());
				advJpBlVO.setImdgUnNo(bkgBookingVO.getUnNo());
				advJpBlVO.setImdgClssCd(bkgBookingVO.getClssCd());
				advJpBlVO.setRvisCntrCustTpCd(cargoInfoDetailVO.getRvisCntrCustTpCd());
				advJpBlVO.setUsrId(account.getUsr_id());
				deleteAdvJpBlVOList.add(advJpBlVO);
				insertAdvJpBlVOList.add(advJpBlVO);
				// BKG_CSTMS_ADV_JP_BL 신규 저장정보 생성 [E]

				// BKG_CSTMS_ADV_JP_CUST 신규 저장정보 생성 [S]
				String cneeSeq = "";
				String cneeNm = "";
				String cneeAddr = "";
				String cneeZipId = "";
				String cneeFaxNo = "";
				String ntfyCntCd = "";
				String ntfyZipId = "";
				String ntfyPhnNo = "";
				for (AdvJpCustomerVO advJpCustomerVO : dbDao.searchBkgCustomer(bkgNo)) {
					advJpCustomerVO.setBlNo(blNo);
					advJpCustomerVO.setBlSplitNo("  ");
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
					if ("NEW".equals(headerVO.getPgmDiv())) {
						advJpCustomerVO.setPhnNo(advJpCustomerVO.getPhnNo().replaceAll("-", "").replaceAll(" ", ""));
						advJpCustomerVO.setFaxNo(advJpCustomerVO.getFaxNo().replaceAll("-", "").replaceAll(" ", ""));
					}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
					if ("C".equals(advJpCustomerVO.getBkgCustTpCd())) {
						// Consignee의 Name에 "ORDER"라는 단어가 있을때 Address에도 복사
						cneeSeq = advJpCustomerVO.getCustSeq();
						cneeNm = advJpCustomerVO.getCustNm().replace("'", "''");
						cneeAddr = advJpCustomerVO.getCustAddr().replace("'", "''");
						cneeZipId = advJpCustomerVO.getCustZipId();
						cneeFaxNo = advJpCustomerVO.getFaxNo();

						if (cneeNm.toUpperCase().indexOf("ORDER ") > -1 || cneeNm.toUpperCase().indexOf("TO ORDER") > -1) {
							cneeAddr = "TO ORDER";
						}
						advJpCustomerVO.setCustNm(cneeNm);
						advJpCustomerVO.setCustAddr(cneeAddr);

					} else if ("N".equals(advJpCustomerVO.getBkgCustTpCd())) {
						if (advJpCustomerVO.getCustNm().toUpperCase().indexOf("SAME ") > -1 && !"".equals(cneeNm) && !"".equals(cneeAddr)) {
							// Notifyd의 Name에 "SAME"이라는 단어가 있을때 Consignee의 정보를 복사
							advJpCustomerVO.setCustNm(cneeNm);
							advJpCustomerVO.setCustAddr(cneeAddr);
						}

						ntfyCntCd = advJpCustomerVO.getCustCntCd();
						ntfyZipId = advJpCustomerVO.getCustZipId();
						ntfyPhnNo = advJpCustomerVO.getPhnNo();

					} else if ("S".equals(advJpCustomerVO.getBkgCustTpCd())) {
						if ("".equals(cneeSeq) && "".equals(cneeNm) && "".equals(cneeAddr) && "".equals(cneeZipId) && "".equals(cneeFaxNo)) {
							advJpCustomerVO.setCustCntCd(ntfyCntCd);
							advJpCustomerVO.setCustNm(advJpCustomerVO.getCustNm().replace("'", "''"));
							advJpCustomerVO.setCustAddr(advJpCustomerVO.getCustAddr().replace("'", "''"));
							advJpCustomerVO.setCustZipId(ntfyZipId);
							advJpCustomerVO.setPhnNo(ntfyPhnNo);
						} else {
							advJpCustomerVO.setCustNm(advJpCustomerVO.getCustNm().replace("'", "''"));
							advJpCustomerVO.setCustAddr(advJpCustomerVO.getCustAddr().replace("'", "''"));
						}
					}
					advJpCustomerVO.setUsrId(account.getUsr_id());
					insertAdvJpCustomerVOList.add(advJpCustomerVO);
				}
				// BKG_CSTMS_ADV_JP_CUST 신규 저장정보 생성 [E]

				// BKG_CSTMS_ADV_JP_MK 신규 저장정보 생성 [S]
				bkgMarkVOList = dbDao.searchBkgMark(bkgNo);    // BKG_BL_MK_DESC 정보 조회
				advJpMarkDescVO = new AdvJpMarkDescVO();
				advJpMarkDescVO.setBlNo(blNo);
				advJpMarkDescVO.setBlSplitNo("  ");
				if (bkgMarkVOList.size() < 1) {
					advJpMarkDescVO.setBlSeq("1");
					advJpMarkDescVO.setDiffRmk("N/M");
					advJpMarkDescVO.setCmdtHsCd("");
				} else {
					advJpMarkDescVO.setBlSeq(bkgMarkVOList.get(0).getBlSeq());
					advJpMarkDescVO.setDiffRmk(bkgMarkVOList.get(0).getDiffRmk().replace("'", "''"));
					advJpMarkDescVO.setCmdtHsCd(bkgMarkVOList.get(0).getCmdtHsCd());
				}
				advJpMarkDescVO.setBlDesc(dbDao.getDescFromBkgDoc(bkgNo).replace("'", "''"));    // BKG_BL_DOC 정보 조회
				advJpMarkDescVO.setUsrId(account.getUsr_id());
				insertAdvJpMarkDescVOList.add(advJpMarkDescVO);
				// BKG_CSTMS_ADV_JP_MK 신규 저장정보 생성 [E]

				bkgContainerVOList = dbDao.searchBkgContainer(bkgNo);    // BKG_CONTAINER 정보 조회
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
				int maxCntr = 101; 
				if ("NEW".equals(headerVO.getPgmDiv())) maxCntr = 201;
				if (bkgContainerVOList.size() < maxCntr) {
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
					// BKG_CSTMS_ADV_JP_CNTR 신규 저장정보 생성 [S]
					for (AdvJpContainerVO advJpContainerVO : bkgContainerVOList) {
						advJpContainerVO.setBlNo(blNo);
						advJpContainerVO.setBlSplitNo("  ");
						advJpContainerVO.setFullMtyCd(bkgBookingVO.getBkgCgoTpCd());
						advJpContainerVO.setUsrId(account.getUsr_id());
						insertAdvJpContainerVOList.add(advJpContainerVO);
					}
					// BKG_CSTMS_ADV_JP_CNTR 신규 저장정보 생성 [E]

				} else {
					////// BKG_CONTAINER 정보가 100건이 넘을 때 [S] {100건이내, 100건~, 200건~, 300건~, 400건~ ....}
					String[] blSplitNo = {" ", "W", "X", "Y", "Z", "WW", "WX", "WY", "WZ", "XW", "XX", "XY", "XZ", "YW", "YX", "YY", "YZ", "ZW", "ZX", "ZY", "ZZ"};
					int loopCount = ((bkgContainerVOList.size() - (bkgContainerVOList.size() % 100)) / 100 + 1);
					for (int k=1; k<loopCount; k++) {
						// BKG_CSTMS_ADV_JP_BL 저장정보 생성:BKG_CONTAINER>100 [S]
						advJpBlVO.setBlSplitNo(blSplitNo[k]);
						insertAdvJpBlVOList.add(advJpBlVO);
						// BKG_CSTMS_ADV_JP_BL 저장정보 생성:BKG_CONTAINER>100 [E]

						// BKG_CSTMS_ADV_JP_CUST 저장정보 생성:BKG_CONTAINER>100 [S]
						cneeNm = "";
						cneeAddr = "";
						for (AdvJpCustomerVO advJpCustomerVO : bkgCustomerVOList) {
							advJpCustomerVO.setBlNo(blNo);
							advJpCustomerVO.setBlSplitNo(blSplitNo[k]);
							if ("C".equals(advJpCustomerVO.getBkgCustTpCd())) {
								// Consignee의 Name에 "ORDER"라는 단어가 있을때 Address에도 복사
								cneeNm = advJpCustomerVO.getCustNm().replace("'", "''");
								cneeAddr = advJpCustomerVO.getCustAddr().replace("'", "''");
								if (cneeNm.toUpperCase().indexOf("ORDER ") > -1 || cneeNm.toUpperCase().indexOf("TO ORDER") > -1) {
									cneeAddr = advJpCustomerVO.getCustNm().replace("'", "''");
								}
								advJpCustomerVO.setCustNm(cneeNm);
								advJpCustomerVO.setCustAddr(cneeAddr);
							} else if ("N".equals(advJpCustomerVO.getBkgCustTpCd()) && advJpCustomerVO.getCustNm().toUpperCase().indexOf("SAME ") > -1 && !"".equals(cneeNm) && !"".equals(cneeAddr)) {
								// Notifyd의 Name에 "SAME"이라는 단어가 있을때 Consignee의 정보를 복사
								advJpCustomerVO.setCustNm(cneeNm);
								advJpCustomerVO.setCustAddr(cneeAddr);
							} else {
								advJpCustomerVO.setCustNm(advJpCustomerVO.getCustNm().replace("'", "''"));
								advJpCustomerVO.setCustAddr(advJpCustomerVO.getCustAddr().replace("'", "''"));
							}
							advJpCustomerVO.setUsrId(account.getUsr_id());
							insertAdvJpCustomerVOList.add(advJpCustomerVO);
						}
						// BKG_CSTMS_ADV_JP_CUST 저장정보 생성:BKG_CONTAINER>100 [E]

						// BKG_CSTMS_ADV_JP_MK 저장정보 생성:BKG_CONTAINER>100 [S]
						advJpMarkDescVO.setBlSplitNo(blSplitNo[k]);
						insertAdvJpMarkDescVOList.add(advJpMarkDescVO);
						// BKG_CSTMS_ADV_JP_MK 저장정보 생성:BKG_CONTAINER>100 [E]

						// BKG_CSTMS_ADV_JP_CNTR 저장정보 생성:BKG_CONTAINER>100 [S]
						int j = 0;
						for (AdvJpContainerVO advJpContainerVO : bkgContainerVOList) {
							advJpContainerVO.setBlNo(blNo);
							advJpContainerVO.setBlSplitNo(blSplitNo[(j - (j % 100)) / 100]);
							advJpContainerVO.setFullMtyCd(bkgBookingVO.getBkgCgoTpCd());
							advJpContainerVO.setUsrId(account.getUsr_id());
							insertAdvJpContainerVOList.add(advJpContainerVO);
							j++;
						}
						// BKG_CSTMS_ADV_JP_CNTR 저장정보 생성:BKG_CONTAINER>100 [E]
					}
					////// BKG_CONTAINER 정보가 100건이 넘을 때 [E]
				}

				prvBlNo = blNo;
			}

			// BKG_CSTMS_ADV_JP_CNTR 정보 삭제
			dbDao.removeAdvJpContainer(deleteAdvJpBlVOList);
			// BKG_CSTMS_ADV_JP_MK 정보 삭제
			dbDao.removeAdvJpMarkDesc(deleteAdvJpBlVOList);
			// BKG_CSTMS_ADV_JP_CUST 정보 삭제
			dbDao.removeAdvJpCustomer(deleteAdvJpBlVOList);
			// BKG_CSTMS_ADV_JP_BL 정보 삭제
			dbDao.removeAdvJpBl(deleteAdvJpBlVOList);

			// BKG_CSTMS_ADV_JP_BL 정보 신규 저장
			dbDao.addAdvJpBl(insertAdvJpBlVOList);
			// BKG_CUSTOMER 정보 신규 저장
			dbDao.addAdvJpCustomer(insertAdvJpCustomerVOList);
			// BKG_CSTMS_ADV_JP_MK 목록 신규 저장
			dbDao.addAdvJpMarkDesc(insertAdvJpMarkDescVOList);
			// BKG_CSTMS_ADV_JP_CNTR 목록 신규 저장
			dbDao.addAdvJpContainer(insertAdvJpContainerVOList);

		} catch (DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return "Success";
	}

}