/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName : CndExpManifestListDownloadBCImpl.java
 *@FileTitle : CndExpManifestListDownloadBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration.CndExpManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfDtlListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselArrivalInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrSealNoListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ConatinerModificationtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsCndVslVO;


/**
 * CndExpManifestListDownloadBCImpl Business Logic Command implementation<br>
 * CndExpManifestListDownloadBCImpl handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CndExpManifestListDownloadBCImpl extends BasicCommandSupport implements CndExpManifestListDownloadBC {

	// Database Access Object
	private transient CndExpManifestListDownloadDBDAO dbDao = null;

	/**
	 * CndExpManifestListDownloadBCImpl 객체 생성<br>
	 * CndExpManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public CndExpManifestListDownloadBCImpl() {
		dbDao = new CndExpManifestListDownloadDBDAO();
	}

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException {
		List<ManifestListDetailVO> manifestListDetailVOList = null;

		try {
			CndCstmsMfListCondVO condVO = (CndCstmsMfListCondVO) manifestListCondVO;
			if ("sheet0".equals(condVO.getSheetId())) {
				condVO.setUpdUsrId(account.getUpd_usr_id());
				manifestListDetailVOList = dbDao.searchCndCstmsMfList(condVO);
			} else if ("sheet2".equals(condVO.getSheetId())) {
				// 모델상에 상세리스트의 경우 VO객체가 다른걸 사용하므로 그대로 set해준다.
				CndCstmsMfDtlListCondVO dtlCondVO = new CndCstmsMfDtlListCondVO();
				dtlCondVO.setVslCd(condVO.getVslCd());
				dtlCondVO.setSkdVoyNo(condVO.getSkdVoyNo());
				dtlCondVO.setSkdDirCd(condVO.getSkdDirCd());
				dtlCondVO.setPolCd(condVO.getPolCd());
				dtlCondVO.setPodCd(condVO.getPodCd());
				dtlCondVO.setPageNo(condVO.getPageNo());
				dtlCondVO.setPagerows(condVO.getPagerows());
				dtlCondVO.setTotal(condVO.getTotal());
				dtlCondVO.setBkgCgoTpCd(condVO.getBkgCgoTpCd());
				dtlCondVO.setClptSeq(condVO.getClptSeq());
				// CRN check (Export용은 POD가 아닌 POL로 check)
				if (dbDao.checkIfCCNAval(condVO.getVslCd(), condVO.getSkdVoyNo(), condVO.getSkdDirCd(), condVO.getPolCd())) {
					manifestListDetailVOList = dbDao.searchCndCstmsMfDtlList(dtlCondVO);
				} else {
					throw new EventException(new ErrorHandler("BKG00569").getMessage());
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			if (ex.getMessage().indexOf("BKG00569") > -1  ) {
				throw new EventException(new ErrorHandler("BKG00569", new String[] {}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}
		}
		return manifestListDetailVOList;
	}

	/**
	 * BKG_CSTMS_AMER_BL 의 MF_STS_CD = 'D'로 수정
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException {
		String sResult = "";

		try {
			if ("ESM_BKG_N001".equals(manifestListDetailVOs[0].getPgmNo())) {
				CndExpManifestListDownloadBackEndJob cndBackEndJob = new CndExpManifestListDownloadBackEndJob();
				cndBackEndJob.setManifestListDetailVO(manifestListDetailVOs, account, dbDao);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				sResult = backEndJobManager.execute(cndBackEndJob, account.getUsr_id(), "Canada Export Data Download");
				return sResult;
			}else if ("ESM_BKG_N003".equals(manifestListDetailVOs[0].getPgmNo())) {
				/*******************************************************
				 * ## AI의 Download의 경우 BackEndJob을 사용하지 않음.
				 *    단지 같은 로직이기 때문에 manageManifest 메소드 호출
				 * ## Inbound - C/A Report(I/B) 화면에서 다운로드 호출 시
				 *******************************************************/
				CndExpManifestListDownloadBackEndJob cndBackEndJob = new CndExpManifestListDownloadBackEndJob();
				cndBackEndJob.setManifestListDetailVO(manifestListDetailVOs, account, dbDao);
				sResult = cndBackEndJob.doStart();

			} else {
				if ("ESM_BKG_N004".equals(manifestListDetailVOs[0].getPgmNo())) {
					/*******************************************************
					 * 같은 VVD, POL, POD에 전송한 이력이 없으면<br>
					 * MI화면에서 전송을 안한경우 에러로 처리
					 *******************************************************/
					if (!dbDao.checkMiSendLog(((CndManifestModificationVO) manifestListDetailVOs[0]).getBlNo())) {
						throw new EventException(new ErrorHandler("BKG06083").getMessage());
					}
				}
				// 현재시간
				String strToDate = dbDao.searchSysdate();
				// DA, RA의 경우 MF_STS_CD, CST,S_TRS,_STS_CD 등 변경
				List<BkgCstmsAdvBlVO> blVOs = new ArrayList<BkgCstmsAdvBlVO>();
				for (int i=0; i<manifestListDetailVOs.length; i++) {
					// BL 정보 세팅
					CndManifestModificationVO cndVo = (CndManifestModificationVO) manifestListDetailVOs[i];
					BkgCstmsAdvBlVO bl = new BkgCstmsAdvBlVO();
					bl.setCntCd(CountryCode.CA);
					bl.setBlNo(cndVo.getBlNo());
					bl.setMfStsCd(cndVo.getMfStsCd());
					bl.setCstmsMfTpCd(cndVo.getCstmsMfTpCd());
					bl.setCstmsTrsmStsCd(cndVo.getCstmsTrsmStsCd());
					bl.setUpdUsrId(account.getUsr_id());
					bl.setUpdDt(strToDate);
					bl.setIbflag("MF_STS_CD");
					blVOs.add(bl);
					cndVo.setEdiSndDt(strToDate);
				}
				dbDao.modifyBkgCstmsAdvBl(blVOs);
			}
			return sResult;

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 해당 VVD에 존재하는 모든 B/L 정보 삭제
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @throws EventException
	 */
	public String deleteManifest(ManifestListDetailVO[] manifestListDetailVOs) throws EventException {
		try{
			for(int i=0 ; i < manifestListDetailVOs.length ; i++) {
				CndManifestModificationVO cndManifestModificationVO = (CndManifestModificationVO) manifestListDetailVOs[i];
				cndManifestModificationVO.setCntCd("CA");
				dbDao.removeBKGAdvManifestCntrCA(cndManifestModificationVO);
				dbDao.removeBKGAdvManifestCustCA(cndManifestModificationVO);
				dbDao.removeBKGAdvManifestSealNoCA(cndManifestModificationVO);
				dbDao.removeBKGAdvManifestCntrMfCA(cndManifestModificationVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return "Y";
	}

	/**
	 * 해당 VVD에 존재하는 모든 B/L 정보 삭제
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @throws EventException
	 */
	public String deleteManifestBl(ManifestListDetailVO[] manifestListDetailVOs) throws EventException {
		try{
			for(int i=0 ; i < manifestListDetailVOs.length ; i++) {
				CndManifestModificationVO cndManifestModificationVO = (CndManifestModificationVO) manifestListDetailVOs[i];
				cndManifestModificationVO.setCntCd("CA");
				dbDao.removeBKGAdvManifestBlCA(cndManifestModificationVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return "Y";
	}

	/**
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제
	 *
	 * @param CstmsBlVO[] cstmsBlVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException {
		List<BkgCstmsAdvBlVO> blVOs = new ArrayList<BkgCstmsAdvBlVO>();

		try {
			if ("ESM_BKG_N002".equals(cstmsBlVOs[0].getPgmNo())) {
				// BL 정보 세팅
				CndCstmsBlVO cndCstmsBlVO = (CndCstmsBlVO) cstmsBlVOs[0];
				BkgCstmsAdvBlVO bkgCstmsAdvBlVO = new BkgCstmsAdvBlVO();
				bkgCstmsAdvBlVO.setCntCd(CountryCode.CA);
				bkgCstmsAdvBlVO.setBlNo(cndCstmsBlVO.getBlNo());
				bkgCstmsAdvBlVO.setMfStsCd(cndCstmsBlVO.getMfStsCd());
				bkgCstmsAdvBlVO.setIbflag("MF_STS_CD");
				bkgCstmsAdvBlVO.setUpdUsrId(account.getUsr_id());
				blVOs.add(bkgCstmsAdvBlVO);
				dbDao.modifyBkgCstmsAdvBl(blVOs);

			} else {
				CndCstmsBlContainerVO containerVO = (CndCstmsBlContainerVO) cstmsBlVOs[0];
				CndCstmsBlMainVO mainVO = containerVO.getCndCstmsBlMainVO();
				CndCstmsBlCustVO custVO = containerVO.getCndCstmsBlCustVO();
				List<BkgCstmsAdvCustVO> custVOs = new ArrayList<BkgCstmsAdvCustVO>();
				// BL 정보 세팅
				BkgCstmsAdvBlVO bl = new BkgCstmsAdvBlVO();
				bl.setUpdUsrId(account.getUsr_id());
				bl.setBlNo(mainVO.getBlNo());
				bl.setCstmsTrsmStsCd(mainVO.getCstmsTrsmStsCd());
				bl.setDelCd(mainVO.getDelCd());
				bl.setPckQty(mainVO.getPckQty());
				bl.setAmsPckTpCd(mainVO.getAmsPckTpCd());
				bl.setCgoWgt(mainVO.getCgoWgt());
				bl.setWgtUtCd(mainVO.getWgtUtCd());
				bl.setHubLocCd(mainVO.getHubLocCd());
				bl.setIbdLocGdsDesc(mainVO.getIbdLocGdsDesc());
				bl.setInTzYdAddr(mainVO.getInTzYdAddr());
				bl.setInTzYdCd(mainVO.getInTzYdCd1() + mainVO.getInTzYdCd2());
				bl.setInTzYdCntCd(mainVO.getInTzYdCntCd());
				bl.setInTzYdCtyNm(mainVO.getInTzYdCtyNm());
				bl.setInTzYdNm(mainVO.getInTzYdNm());
				bl.setInTzYdSteCd(mainVO.getInTzYdSteCd());
				bl.setInTzYdZipId(mainVO.getInTzYdZipId());
				bl.setDiffRmk(mainVO.getDiffRmk());
				bl.setTrspTpId(mainVO.getTrspTpId());
				// Empty B/L 저장
				if ("1".equals(mainVO.getFullMtyCd())) {
					bl.setFullMtyCd("M");
				} else {
					bl.setFullMtyCd("F");
				}
				if (bl.getBlNo().startsWith("DUMM")) {
					bl.setVslCd(mainVO.getVvdCd().substring(0, 4));
					bl.setSkdVoyNo(mainVO.getVvdCd().substring(4, 8));
					bl.setSkdDirCd(mainVO.getVvdCd().substring(8));
					bl.setPodCd(mainVO.getPodCd());
					bl.setPolCd(mainVO.getPolCd());
					bl.setPorCd(mainVO.getPorCd());
					bl.setCstmsFileTpCd(mainVO.getCstmsFileTpCd());
				}
				if (custVO == null) {
					// Delete 또는 Reactivate의 경우 customer정보는 세팅하지 않고 BL의 Status Code만
					// 세팅한다.
					bl.setMfStsCd(mainVO.getMfStsCd());
				} else {
					// Customer 정보 세팅
					// Shipper
					BkgCstmsAdvCustVO cust = new BkgCstmsAdvCustVO();
					cust.setUpdUsrId(account.getUsr_id());
					cust.setBlNo(mainVO.getBlNo());
					cust.setBkgCustTpCd("S");
					cust.setCustAddr(custVO.getCustAddr1());
					cust.setCustCntCd(custVO.getCustCntCd1());
					cust.setCustCtyNm(custVO.getCustCtyNm1());
					cust.setCustNm(custVO.getCustNm1());
					cust.setCustSeq(custVO.getCustSeq1());
					cust.setCustSteCd(custVO.getCustSteCd1());
					cust.setCustZipId(custVO.getCustZipId1());
					cust.setCstmsDeclCntCd(custVO.getCstmsDeclCntCd1());
					custVOs.add(cust);
					// Consignee
					cust = new BkgCstmsAdvCustVO();
					cust.setUpdUsrId(account.getUsr_id());
					cust.setBlNo(mainVO.getBlNo());
					cust.setBkgCustTpCd("C");
					cust.setCustAddr(custVO.getCustAddr2());
					cust.setCustCntCd(custVO.getCustCntCd2());
					cust.setCustCtyNm(custVO.getCustCtyNm2());
					cust.setCustNm(custVO.getCustNm2());
					cust.setCustSeq(custVO.getCustSeq2());
					cust.setCustSteCd(custVO.getCustSteCd2());
					cust.setCustZipId(custVO.getCustZipId2());
					cust.setCstmsDeclCntCd(custVO.getCstmsDeclCntCd2());
					custVOs.add(cust);
					// Notify
					cust = new BkgCstmsAdvCustVO();
					cust.setUpdUsrId(account.getUsr_id());
					cust.setBlNo(mainVO.getBlNo());
					cust.setBkgCustTpCd("N");
					cust.setCustAddr(custVO.getCustAddr3());
					cust.setCustCntCd(custVO.getCustCntCd3());
					cust.setCustCtyNm(custVO.getCustCtyNm3());
					cust.setCustNm(custVO.getCustNm3());
					cust.setCustSeq(custVO.getCustSeq3());
					cust.setCustSteCd(custVO.getCustSteCd3());
					cust.setCustZipId(custVO.getCustZipId3());
					cust.setCstmsDeclCntCd(custVO.getCstmsDeclCntCd3());
					// 쿼리실행
					custVOs.add(cust);
				}
				// 쿼리실행
				blVOs.add(bl);
				dbDao.modifyBkgCstmsAdvBl(blVOs);
				if (custVOs.size() > 0) {
					dbDao.modifyBkgCstmsAdvCust(custVOs);
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 수정 저장<br>
	 *
	 * @param CstmsManifestAmendmentVO[] CstmsManifestAmendmentVOs
	 * @param SignOnUserAccount account
	 * @param String CntCd
	 * @param String aiDiv
	 * @exception EventException
	 */
	public void manageCstmsAmendManifest(CstmsManifestAmendmentVO[] CstmsManifestAmendmentVOs, SignOnUserAccount account, String CntCd, String aiDiv) throws EventException {
		List<CndCstmsManifestAmendmentVO> updateVOList = new ArrayList<CndCstmsManifestAmendmentVO>();

		try {
			for (CndCstmsManifestAmendmentVO cndCstmsManifestAmendmentVO : (CndCstmsManifestAmendmentVO[]) CstmsManifestAmendmentVOs) {
				cndCstmsManifestAmendmentVO.setCntCd(CntCd);
				if ("U".equals(cndCstmsManifestAmendmentVO.getIbflag())) {
					cndCstmsManifestAmendmentVO.setUsrId(account.getUsr_id());
					updateVOList.add(cndCstmsManifestAmendmentVO);
				}
			}
			if (updateVOList.size() > 0) dbDao.modifyCstmsAmendManifest(updateVOList, aiDiv);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Hub정보취득
	 *
	 * @param podCd
	 * @param delCd
	 * @param podNodCd
	 * @return
	 * @throws EventException
	 */
	public String[] searchHubInfo(String podCd, String delCd, String podNodCd) throws EventException {
		try {
			return dbDao.searchHubInfo(podCd, delCd, podNodCd);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * B/L Inquiry화면에서 세관 신고를 위해 다운로드 받은 B/L을 B/L 단위로 조회<br>
	 *
	 * @param blCondVO 조회조건
	 * @return List<BlDetailVO>
	 * @throws EventException
	 */
	public List<BlDetailVO> inquiryBlData(BlCondVO blCondVO) throws EventException {
		try {
			List<BlDetailVO> list = new ArrayList<BlDetailVO>();
			CndBlDetailVO cndBlDetailVO = new CndBlDetailVO();

			CndCstmsBlCondVO cndCstmsBlCondVO = (CndCstmsBlCondVO) blCondVO;
			if ("1".equals(cndCstmsBlCondVO.getTabNo())) {
				// 첫번째 탭의 경우 BL Main과 Customer정보 조회
				cndBlDetailVO.setCndCstmsBlMainVO(dbDao.searchCndCstmsBlMain(cndCstmsBlCondVO.getBlNo()));
				cndBlDetailVO.setCndCstmsBlCustVO(dbDao.searchCndCstmsBlCust(cndCstmsBlCondVO.getBlNo()));
			} else if ("2".equals(cndCstmsBlCondVO.getTabNo())) {
				// 두번째 탭의 경우 세관 신고 전송 결과 조회
				cndBlDetailVO.setCndCstmsBlCstmsRsltVOs(dbDao.searchCndCstmsBlCstmsRslt(cndCstmsBlCondVO.getBlNo()));
			} else if ("3".equals(cndCstmsBlCondVO.getTabNo())) {
				// 세번째 탭의 경우 House B/L 정보 조회
				cndBlDetailVO.setCndCstmsBlHblListVOs(dbDao.searchCndCstmsBlHblList(cndCstmsBlCondVO.getBlNo()));
			}
			if (cndBlDetailVO != null) list.add(cndBlDetailVO);
			return list;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Container 정보 조회
	 *
	 * @param ContainerListCondVO containerListCondVO
	 * @return List<ContainerListRsltVO>
	 * @exception EventException
	 */
	public List<ContainerListRsltVO> searchContainerList(ContainerListCondVO containerListCondVO) throws EventException {
		try {
			if ("".equals(containerListCondVO.getCntrNo())) {
				String cntCd = containerListCondVO.getCntCd();
				String blNo = containerListCondVO.getBlNo();

				if("sheet3".equals(containerListCondVO.getSheetId())){
					return dbDao.searchContainerSealNoByBl(cntCd, blNo);
				} else {
					return dbDao.searchContainerByBl(cntCd, blNo);
				}
			} else {
				return dbDao.searchCntrTySzCd(containerListCondVO.getCntrNo());
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * Container 정보 저장
	 *
	 * @param ContainerListRsltVO[] cntrListRsltVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageContainerList(ContainerListRsltVO[] cntrListRsltVOs, SignOnUserAccount account) throws EventException {
		try {
			UsaCntrListRsltVO usaCntrListRsltVO = null;
			UsaCntrSealNoListRsltVO usaCntrSealListRsltVO = null;
			UsaContainerManifestListVO cmListVO = null;

			String mode = null;
			String cntCd = null;

			if (cntrListRsltVOs.getClass().equals(UsaCntrListRsltVO[].class)) {
				usaCntrSealListRsltVO = new UsaCntrSealNoListRsltVO();

				for (int i=0; i<cntrListRsltVOs.length; i++) {
					usaCntrListRsltVO = (UsaCntrListRsltVO)cntrListRsltVOs[i];
					mode = usaCntrListRsltVO.getIbflag();
					if(i == 0) {
						cntCd = usaCntrListRsltVO.getCntCd();
					} else {
						usaCntrListRsltVO.setCntCd(cntCd);
					}

					usaCntrSealListRsltVO.setCntCd(cntCd);
					usaCntrSealListRsltVO.setBlNo(usaCntrListRsltVO.getBlNo());
					usaCntrSealListRsltVO.setCntrNo(usaCntrListRsltVO.getCntrNo());

					if ("I".equals(mode)) {
						dbDao.modifyContainer(usaCntrListRsltVO, account);
					} else if("U".equals(mode)) {
						String bakCntrNo = usaCntrListRsltVO.getBakCntrNo();
						String cntrNo = usaCntrListRsltVO.getCntrNo();
						if(!cntrNo.equals(bakCntrNo)){
							usaCntrListRsltVO.setCntrNo(bakCntrNo);
							usaCntrListRsltVO.setIbdCntrStsCd("D");
							dbDao.modifyContainerStatus(usaCntrListRsltVO);
							dbDao.removeContainerSealNo(usaCntrSealListRsltVO);
						}
						usaCntrListRsltVO.setCntrNo(cntrNo);
						usaCntrListRsltVO.setIbdCntrStsCd("A");
						dbDao.modifyContainer(usaCntrListRsltVO, account);
					} else if("D".equals(mode)) {
						usaCntrListRsltVO.setIbdCntrStsCd("D");
						dbDao.modifyContainerStatus(usaCntrListRsltVO);
						dbDao.removeContainerSealNo(usaCntrSealListRsltVO);

						cmListVO = new UsaContainerManifestListVO();
						cmListVO.setCntCd(cntCd);
						cmListVO.setBlNo(usaCntrListRsltVO.getBlNo());
						cmListVO.setCntrNo(usaCntrListRsltVO.getCntrNo());
						dbDao.removeCM(cmListVO);
					}
				}

			} else {
				String preCntrNo = "";
				for (int i=0; i<cntrListRsltVOs.length; i++) {
					usaCntrSealListRsltVO = (UsaCntrSealNoListRsltVO)cntrListRsltVOs[i];
					mode = usaCntrSealListRsltVO.getIbflag();
					if (i==0) {
						cntCd = usaCntrSealListRsltVO.getCntCd();
					} else{
						usaCntrSealListRsltVO.setCntCd(cntCd);
					}

					if (!preCntrNo.equals(usaCntrSealListRsltVO.getCntrNo())) {
						dbDao.removeContainerSealNo(usaCntrSealListRsltVO);
						preCntrNo = usaCntrSealListRsltVO.getCntrNo();
					}
					if (!"D".equals(mode)) {
						dbDao.modifyContainerSealNo(usaCntrSealListRsltVO, account);
					}
				}
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * Container Manifest 정보를 조회한다.
	 *
	 * @param ContainerManifestCondVO containerManifestCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchContainerManifest(ContainerManifestCondVO containerManifestCondVO) throws EventException {
		UsaContainerManifestDetailVO detailVO = new UsaContainerManifestDetailVO();

		try {
			UsaCntrManifestCondVO condVO = (UsaCntrManifestCondVO) containerManifestCondVO;
			detailVO.setUsaContainerListVOs(dbDao.searchContainerList(condVO.getCntCd(), condVO.getBlNo()));
			detailVO.setUsaCntrManifestListVOs(dbDao.searchContainerManifestList(condVO.getCntCd(), condVO.getBlNo(), condVO.getCntrNo()));
			detailVO.setUsaCntrManifestInfoVOs(dbDao.searchContainerManifestInfo(condVO.getCntCd(), condVO.getBlNo()));

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), e);
		}
		return (ManifestListDetailVO)detailVO;
	}

	/**
	 * 전송대상 Container Manifest 데이터를 수정한다.
	 *
	 * @param ConatinerModificationtVO[] containerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyContainerManifest(ConatinerModificationtVO[] containerVOs, SignOnUserAccount account) throws EventException {
		try {
			UsaContainerManifestListVO cmListVO = null;
			String mode = null;
			String bdrFlg = null;
			String cntCd = null;

			for (int i=0; i<containerVOs.length; i++) {
				cmListVO = (UsaContainerManifestListVO)containerVOs[i];
				mode = cmListVO.getIbflag();
				if (i == 0) {
					cntCd = cmListVO.getCntCd();
				} else {
					cmListVO.setCntCd(cntCd);
				}
				bdrFlg = !"".equals(cmListVO.getBdrFlg()) ? cmListVO.getBdrFlg() : bdrFlg;

				if("I".equals(mode) || "U".equals(mode)){
					dbDao.modifyCM(cmListVO, account);
				} else if("D".equals(mode)){
					dbDao.removeCM(cmListVO);
				}
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * 세관 신고용 VVD 정보 조회
	 *
	 * @param cstmsVvdInfoCondVO 조회조건
	 * @return List<CstmsVvdInfoVO>
	 * @throws EventException
	 */
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException {
		try {
			return dbDao.searchCndCstmsVvdInfo((CndCstmsVvdInfoCondVO)cstmsVvdInfoCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 관련 VVD 정보 생성, 수정, 삭제
	 *
	 * @param cstmsVvdInfoVOs VVD 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageCstmsVvdInfo(CstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException {
		try {
			List<BkgCstmsCndVslVO> addVoList = new ArrayList<BkgCstmsCndVslVO>();
			for (int i=0; i<cstmsVvdInfoVOs.length; i++) {
				List<BkgCstmsCndVslVO> chkVoList = new ArrayList<BkgCstmsCndVslVO>();
				BkgCstmsCndVslVO vslVO = new BkgCstmsCndVslVO();
				vslVO.setIbflag("N010");
				vslVO.setVslCd(cstmsVvdInfoVOs[i].getVslCd());
				vslVO.setSkdVoyNo(cstmsVvdInfoVOs[i].getSkdVoyNo());
				vslVO.setSkdDirCd(cstmsVvdInfoVOs[i].getSkdDirCd());
				vslVO.setCvyRefNo(cstmsVvdInfoVOs[i].getCvyRefNo());
				vslVO.setVpsPortCd(cstmsVvdInfoVOs[i].getVpsPortCd());
				vslVO.setUpdUsrId(account.getUsr_id());
				// 중복 CRN체크를 위해 에러메시지 3번 인덱스를 위해 잠시 세팅
				vslVO.setAckDt(cstmsVvdInfoVOs[i].getCrrCd());
				addVoList.add(vslVO);
				chkVoList.add(vslVO);

				// 중복된 VVD조회
				String duplicateVvdCd = dbDao.searchDuplicateVvd(chkVoList);
				if (!"".equals(cstmsVvdInfoVOs[i].getCvyRefNo()) && !"".equals(duplicateVvdCd)) {
					String arr[] = new String[3];
					arr[0] = cstmsVvdInfoVOs[i].getCvyRefNo();
					arr[1] = cstmsVvdInfoVOs[i].getVslCd() + cstmsVvdInfoVOs[i].getSkdVoyNo()
							+ cstmsVvdInfoVOs[i].getSkdDirCd();
					arr[2] = duplicateVvdCd;
					throw new EventException(new ErrorHandler("BKG01027", arr).getMessage());
				}
			}
			// 입력받은 데이타중 중복된 CRN체크
			String vvd_cd = "";
			String crn_no = "";
			String vvd_cd2 = "";
			String crn_no2 = "";
			for (int i=0; i<cstmsVvdInfoVOs.length; i++) {
				vvd_cd = cstmsVvdInfoVOs[i].getVslCd() + cstmsVvdInfoVOs[i].getSkdVoyNo();
						//+ cstmsVvdInfoVOs[i].getSkdDirCd(); SKD_DIR_CD 가 다른 경우 동일한 CRN 입력 허용
				crn_no = cstmsVvdInfoVOs[i].getCvyRefNo();
				for (int j=0; j<cstmsVvdInfoVOs.length; j++) {
					vvd_cd2 = cstmsVvdInfoVOs[j].getVslCd() + cstmsVvdInfoVOs[j].getSkdVoyNo();
							//+ cstmsVvdInfoVOs[j].getSkdDirCd(); SKD_DIR_CD 가 다른 경우 동일한 CRN 입력 허용
					crn_no2 = cstmsVvdInfoVOs[j].getCvyRefNo();
					if (i != j && !crn_no.equals("") && !crn_no2.equals("")) {
						if (!vvd_cd.equals(vvd_cd2) && crn_no.equals(crn_no2)) {
							String arr[] = new String[3];
							arr[0] = cstmsVvdInfoVOs[j].getCvyRefNo();
							arr[1] = cstmsVvdInfoVOs[j].getVslCd() + cstmsVvdInfoVOs[j].getSkdVoyNo()
									+ cstmsVvdInfoVOs[j].getSkdDirCd();
							arr[2] = cstmsVvdInfoVOs[i].getVslCd() + cstmsVvdInfoVOs[i].getSkdVoyNo()
									+ cstmsVvdInfoVOs[i].getSkdDirCd();
							throw new EventException(new ErrorHandler("BKG01027", arr).getMessage());
						}
					}
				}
			}
			// CRN 번호 수정
			dbDao.addBkgCstmsCndVsl(addVoList);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 신고용 VVD별 Max Reference No 조회
	 * Carrier Code와 상관없이 SML의 Carrier Code 918P로 조회한다. 
	 * @param cstmsVvdRefNoCondVO 조건
	 * @return CstmsVvdRefNoVO
	 * @throws EventException
	 */
	public CstmsVvdRefNoVO searchMaxCndCstmsVvdRefNo(CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) throws EventException {
		try
		{
			CstmsVvdRefNoVO cstmsVvdRefNoVO = new CstmsVvdRefNoVO();
			cstmsVvdRefNoVO.setNewCrn(dbDao.searchMaxCndCstmsVvdRefNo(""));
			return cstmsVvdRefNoVO;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG00392", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG00392", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * CRN 정보 조회
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO
	 * @return List<CndCstmsVslCrnNoVO>
	 * @throws EventException
	 */
	public List<CndCstmsVslCrnNoVO> searchBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws EventException{
		try {
			 return dbDao.searchBkgCstmsCndVslCrnNo(cndCstmsVslCrnNoVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CRN 정보를 삭제한다..
	 * 
	 * @param cndCstmsVslCrnNoVO CRN정보
	 * @throws EventException
	 */
	public void removeBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws EventException{
			
		try {			
			// 작업 구분 분할
			
			if(cndCstmsVslCrnNoVO!=null ){
				dbDao.removeBkgCstmsCndVslCrnNo(cndCstmsVslCrnNoVO);						
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 * 
	 * @param vesselArrivalCondVO 조회조건
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO)
			throws EventException {
		try
		{
			return dbDao.searchVesselArrival((CndCstmsVesselArrivalInfoCondVO) vesselArrivalCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 * 
	 * @param vesselArrivalCondVO 조회조건
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselDeparture(VesselArrivalCondVO vesselArrivalCondVO) throws EventException {
		try
		{
			return dbDao.searchVesselDeparture((CndCstmsVesselArrivalInfoCondVO) vesselArrivalCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 신고시 필요한 Vessel Arrival 정보를 수정한다.
	 * 
	 * @param vesselArrivalVO Vessel Arrival 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException {
		try
		{
			List<BkgCstmsCndVslVO> addVoList = new ArrayList<BkgCstmsCndVslVO>();
			CndVesselArrivalVO cndVesselArrivalVO = (CndVesselArrivalVO) vesselArrivalVO;
			BkgCstmsCndVslVO bkgCstmsCndVslVO = new BkgCstmsCndVslVO();
			bkgCstmsCndVslVO.setVslCd(cndVesselArrivalVO.getVslCd());
			bkgCstmsCndVslVO.setVpsPortCd(cndVesselArrivalVO.getVpsPortCd());
			bkgCstmsCndVslVO.setSkdVoyNo(cndVesselArrivalVO.getSkdVoyNo());
			bkgCstmsCndVslVO.setSkdDirCd(cndVesselArrivalVO.getSkdDirCd());
			bkgCstmsCndVslVO.setCapNm(cndVesselArrivalVO.getCapNm());
			if (cndVesselArrivalVO.getVpsEtdDt() != null && !"".equals(cndVesselArrivalVO.getVpsEtdDt()))
			{
				bkgCstmsCndVslVO.setEtdDt(cndVesselArrivalVO.getVpsEtdDt().replaceAll("-", ""));
			}
			else
			{
				bkgCstmsCndVslVO.setEtdDt("");
			}
			
			if (cndVesselArrivalVO.getActDepDt() != null && !"".equals(cndVesselArrivalVO.getActDepDt()))
			{
				bkgCstmsCndVslVO.setActDepDt(cndVesselArrivalVO.getActDepDt().replaceAll("-", "").replaceAll(":", ""));
			}
			else
			{
				bkgCstmsCndVslVO.setActDepDt("");
			}
			
			if(account.getAccess_system() != null && "EsmBkgB908".equals(account.getAccess_system())) {
				// batch 에서 넘어 왔을 경우 
				bkgCstmsCndVslVO.setUpdUsrId("EsmBkgB908");
			} else {
				// 화면에서 넘어 왔을 경우
				bkgCstmsCndVslVO.setUpdUsrId(account.getUsr_id());
			}
			
			bkgCstmsCndVslVO.setVslArrRptSndDt(cndVesselArrivalVO.getVslArrRptSndDt());
			// 현재시간 GMT 전송할때만 사용함
			String strToDate = dbDao.searchSysdate();
//			bkgCstmsCndVslVO.setVslArrRptSndDt(strToDate);
			bkgCstmsCndVslVO.setVslDepRptSndDt(strToDate);
			bkgCstmsCndVslVO.setIbflag(cndVesselArrivalVO.getIbflag());
			addVoList.add(bkgCstmsCndVslVO);
			// SC에서 Send Log 테이블에 넣기 위해 세팅해둠.
			cndVesselArrivalVO.setVslDepRptSndDt(strToDate);
			dbDao.mergeBkgCstmsCndVsl(addVoList);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

}
