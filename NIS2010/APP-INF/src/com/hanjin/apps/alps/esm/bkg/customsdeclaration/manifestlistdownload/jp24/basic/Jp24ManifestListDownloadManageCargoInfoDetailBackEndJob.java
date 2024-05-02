/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob
*@FileTitle : Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob
*Open Issues :
*Change history :
*	2014.07.09 Hannah Lee / CHM-201431023
*	2017.09.07 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2014.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2013.08.20 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BkgBookingVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BkgQuantityVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 

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
		this.cargoInfoDetailVOs = cargoInfoDetailVOs;
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
		List<AdvJpContainerVO> bkgContainerVOList = new ArrayList<AdvJpContainerVO>();    // BKG_CONTAINER 정보 조회

		AdvJpBlVO advJpBlVO = null;
		List<AdvJpCustomerVO> insertAdvJpCustomerVOList = new ArrayList<AdvJpCustomerVO>();    // BKG_CSTMS_ADV_JP_CUST 저장용
		AdvJpMarkDescVO advJpMarkDescVO = null;
		List<AdvJpMarkDescVO> insertAdvJpMarkDescVOList = new ArrayList<AdvJpMarkDescVO>();    // BKG_CSTMS_ADV_JP_MK 저장용
		List<AdvJpContainerVO> insertAdvJpContainerVOList = new ArrayList<AdvJpContainerVO>();    // BKG_CSTMS_ADV_JP_CNTR 저장용

		try {
			// BKG_CSTMS_ADV_JP_VSL_SKD 정보 조회
			List<CargoInfoHeaderVO> tempAdvJpVslSkdVOList = dbDao.searchAdvJpVslSkd(headerVO);
			// BKG_CSTMS_ADV_JP_VSL_SKD 정보 삭제
			dbDao.removeAdvJpVslSkd(headerVO);
			// BKG_CSTMS_ADV_JP_VSL_SKD 정보 신규 저장
			headerVO.setUsrId(account.getUsr_id());
			if (tempAdvJpVslSkdVOList.size() > 0) {
				headerVO.setVpsDt(tempAdvJpVslSkdVOList.get(0).getVpsDt());
				headerVO.setRlxDiv(tempAdvJpVslSkdVOList.get(0).getRlxDiv());
				headerVO.setMfSndFlg(tempAdvJpVslSkdVOList.get(0).getMfSndFlg());
				headerVO.setFnlEdiSndFlg(tempAdvJpVslSkdVOList.get(0).getFnlEdiSndFlg());
			}
			dbDao.addAdvJpVslSkd(headerVO);

			String loclTsFlg = "";    // 추후 로직추가 예정

			for (int i=0; i<detailVOs.length; i++) {
				String bkgNo = detailVOs[i].getBlNo();
				String podCd = detailVOs[i].getPodCd();
				// 직전 bkg_no와 같다면 skip
				if (i > 0 && bkgNo.equals(detailVOs[i - 1].getBlNo())) continue;

				// BKG_BOOKING 정보 조회
				List<BkgBookingVO> bkgBookingVOList = dbDao.searchBkgBooking(bkgNo);
				if (bkgBookingVOList.size() < 1) continue;
				BkgBookingVO bkgBookingVO = bkgBookingVOList.get(0);

				// BKG_CSTMS_ADV_JP_BL 신규 저장정보 생성 [S]
				float measQty = Float.valueOf(bkgBookingVO.getMeasQty());
				if ((int) measQty < 1) {
					List<BkgQuantityVO> bkgQuantityVOList = dbDao.searchBkgQuantity(bkgNo);    // BKG_QUANTITY 정보 조회
					for (BkgQuantityVO bkgQuantityVO : bkgQuantityVOList) {
						if (Integer.parseInt(bkgQuantityVO.getCntrTpszCd()) < 3) {
							measQty += (20 * Float.valueOf(bkgQuantityVO.getOpCntrQty()));
						} else {
							measQty += (40 * Float.valueOf(bkgQuantityVO.getOpCntrQty()));
						}
					}
				}
				
				if(!bkgBookingVO.getPodCd().substring(0, 2).equals("JP")){
					loclTsFlg = "T";
				}

				advJpBlVO = new AdvJpBlVO();
				advJpBlVO.setBlNo(bkgBookingVO.getBlNo());
				advJpBlVO.setBlSplitNo("  ");
				advJpBlVO.setVvd(headerVO.getVvd());
				advJpBlVO.setPolCd(headerVO.getPolCd());
				advJpBlVO.setPodCd(detailVOs[i].getPodCd());
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
				advJpBlVO.setBbCgoFlg(bkgBookingVO.getBbCgoFlg()); // 2014.07.09 CHM-201431023 
				advJpBlVO.setRvisCntrCustTpCd(detailVOs[i].getRvisCntrCustTpCd());
				advJpBlVO.setUsrId(account.getUsr_id());
				deleteAdvJpBlVOList.add(advJpBlVO);
				insertAdvJpBlVOList.add(advJpBlVO);
				// BKG_CSTMS_ADV_JP_BL 신규 저장정보 생성 [E]

				// BKG_CSTMS_ADV_JP_CUST 신규 저장정보 생성 [S]
				bkgCustomerVOList = dbDao.searchBkgCustomer(bkgNo, podCd);
				String cneeNm = "";
				String cneeAddr = "";
				for (AdvJpCustomerVO advJpCustomerVO : bkgCustomerVOList) {
					advJpCustomerVO.setBlNo(bkgBookingVO.getBlNo());
					advJpCustomerVO.setBlSplitNo("  ");
					advJpCustomerVO.setUsrId(account.getUsr_id());
					insertAdvJpCustomerVOList.add(advJpCustomerVO);
				} 
				// BKG_CSTMS_ADV_JP_CUST 신규 저장정보 생성 [E]

				// BKG_CSTMS_ADV_JP_MK 신규 저장정보 생성 [S]
				String cstmsDesc = dbDao.getDescFromBkgDoc(bkgNo).replace("'", "''");    // BKG_BL_DOC 정보 조회
				bkgMarkVOList = dbDao.searchBkgMark(bkgNo);    // BKG_BL_MK_DESC 정보 조회
				advJpMarkDescVO = new AdvJpMarkDescVO();
				advJpMarkDescVO.setBlNo(bkgBookingVO.getBlNo());
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
				advJpMarkDescVO.setBlDesc(cstmsDesc);
				advJpMarkDescVO.setUsrId(account.getUsr_id());
				insertAdvJpMarkDescVOList.add(advJpMarkDescVO);
				// BKG_CSTMS_ADV_JP_MK 신규 저장정보 생성 [E]

				bkgContainerVOList = dbDao.searchBkgContainer(bkgNo);    // BKG_CONTAINER 정보 조회
				if (bkgContainerVOList.size() < 201) {
					// BKG_CSTMS_ADV_JP_CNTR 신규 저장정보 생성 [S]
					for (AdvJpContainerVO advJpContainerVO : bkgContainerVOList) {
						advJpContainerVO.setBlNo(bkgBookingVO.getBlNo());
						advJpContainerVO.setBlSplitNo("  ");
						advJpContainerVO.setFullMtyCd(bkgBookingVO.getBkgCgoTpCd());
						advJpContainerVO.setUsrId(account.getUsr_id());
						insertAdvJpContainerVOList.add(advJpContainerVO);
					}
					// BKG_CSTMS_ADV_JP_CNTR 신규 저장정보 생성 [E]

				} else {
					
					//@ 200건 이하는 위에서 기본적으로 생성되어진다. 
					//@ 200건 이상 BL정보, Customer 정보, M&D 정보를 생성한다.
					////// BKG_CONTAINER 정보가 200건이 넘을 때 [S] {200건이내, 200건~, 400건~, 600건~, 800건~ ....}
					String[] blSplitNo = {" ", "W", "X", "Y", "Z", "WW", "WX", "WY", "WZ", "XW", "XX", "XY", "XZ", "YW", "YX", "YY", "YZ", "ZW", "ZX", "ZY", "ZZ"};
//					int loopCount = (bkgContainerVOList.size() - (bkgContainerVOList.size() % 200)) / 200 + 1);
					// 400 이하일 경우 1회 생성, 401인 경우 2회 생성, .... (Ceil 함수 사용)
					int loopCount = (int)Math.ceil((double)bkgContainerVOList.size()/200);
					for (int k=1; k<loopCount; k++) {
						// BKG_CSTMS_ADV_JP_BL 저장정보 생성:BKG_CONTAINER>200 [S]
						AdvJpBlVO advJpBlVOTemp = new AdvJpBlVO();
						ObjectCloner.build(advJpBlVO, advJpBlVOTemp);
						advJpBlVOTemp.setBlSplitNo(blSplitNo[k]);
						insertAdvJpBlVOList.add(advJpBlVOTemp);
						// BKG_CSTMS_ADV_JP_BL 저장정보 생성:BKG_CONTAINER>200 [E]

						// BKG_CSTMS_ADV_JP_CUST 저장정보 생성:BKG_CONTAINER>200 [S]
						for (AdvJpCustomerVO advJpCustomerVO : bkgCustomerVOList) {
							AdvJpCustomerVO advJpCustomerVOTemp = new AdvJpCustomerVO();
							ObjectCloner.build(advJpCustomerVO, advJpCustomerVOTemp);
							advJpCustomerVOTemp.setBlNo(bkgBookingVO.getBlNo());
							advJpCustomerVOTemp.setBlSplitNo(blSplitNo[k]);
							insertAdvJpCustomerVOList.add(advJpCustomerVOTemp);
						}
						// BKG_CSTMS_ADV_JP_CUST 저장정보 생성:BKG_CONTAINER>200 [E]

						// BKG_CSTMS_ADV_JP_MK 저장정보 생성:BKG_CONTAINER>200 [S]
						AdvJpMarkDescVO advJpMarkDescVOTemp = new AdvJpMarkDescVO();
						ObjectCloner.build(advJpMarkDescVO, advJpMarkDescVOTemp);
						advJpMarkDescVOTemp.setBlSplitNo(blSplitNo[k]);
						insertAdvJpMarkDescVOList.add(advJpMarkDescVOTemp);
						// BKG_CSTMS_ADV_JP_MK 저장정보 생성:BKG_CONTAINER>200 [E]
					}
					
					// BKG_CSTMS_ADV_JP_CNTR 저장정보 생성: 컨테이너는 전체 list를 처리한다.
					int j = 0;
					for (AdvJpContainerVO advJpContainerVO : bkgContainerVOList) {
						advJpContainerVO.setBlNo(bkgBookingVO.getBlNo());
						advJpContainerVO.setBlSplitNo(blSplitNo[(j - (j % 200)) / 200]);
						advJpContainerVO.setFullMtyCd(bkgBookingVO.getBkgCgoTpCd());
						advJpContainerVO.setUsrId(account.getUsr_id());
						insertAdvJpContainerVOList.add(advJpContainerVO);
						j++;
					}
					////// BKG_CONTAINER 정보가 200건이 넘을 때 [E]
				}
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
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return "Success";
	}

}