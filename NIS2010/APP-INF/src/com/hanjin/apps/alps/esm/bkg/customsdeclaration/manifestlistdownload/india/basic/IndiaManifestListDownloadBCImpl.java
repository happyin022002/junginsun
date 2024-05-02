/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndiaManifestListDownloadBCImpl.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.06
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.06 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration.IndiaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaContainerSaveVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaBondListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaIgmCntrModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaIgmModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
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
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0304EventResponse,ManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class IndiaManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {

	// Database Access Object
	private transient IndiaManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManifestListDownloadBCImpl 객체 생성<br>
	 * ManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public IndiaManifestListDownloadBCImpl() {
		dbDao = new IndiaManifestListDownloadDBDAO();
	}

	/**
	 * INDIA 에서 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션<br>
	 * 
	 * @param VesselArrivalCondVO
	 *            vesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO) throws EventException {

		List<VesselArrivalDetailVO> list = null;

		try {

			// 인도세관쪽 테이블 조회
			list = dbDao.searchIgmVesselDetailsByVvdPod((InVesselArrivalCondVO) vesselArrivalCondVO);

			if (list != null && list.size() == 0) {
				// 운항 테이블 조회
				list = dbDao.searchVesselDetailAtVsl((InVesselArrivalCondVO) vesselArrivalCondVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * INDIA 에서 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 입력,제거하는 오퍼레이션<br>
	 * 
	 * @param vesselArrivalVO
	 * @param account
	 * @throws EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException {

		int ret = 0;

		InVesselArrivalVO inVesselArrivalVO = (InVesselArrivalVO) vesselArrivalVO;

		try {

			if ("U".equalsIgnoreCase(inVesselArrivalVO.getIbflag())) { // update

				inVesselArrivalVO.setUpdUsrId(account.getUsr_id());
				ret = dbDao.modifyIgmVessel(inVesselArrivalVO);

				if (ret == 0) {
					inVesselArrivalVO.setCreUsrId(account.getUsr_id());
					ret = dbDao.addIgmVessel(inVesselArrivalVO);
				}

			} else if ("I".equalsIgnoreCase(inVesselArrivalVO.getIbflag())) { // insert

				inVesselArrivalVO.setCreUsrId(account.getUsr_id());
				inVesselArrivalVO.setUpdUsrId(account.getUsr_id());

				ret = dbDao.addIgmVessel((InVesselArrivalVO) vesselArrivalVO);

			} else if ("D".equalsIgnoreCase(inVesselArrivalVO.getIbflag())) { // delete

				ret = dbDao.removeIgmVessel((InVesselArrivalVO) vesselArrivalVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * INDIA 세관에 적하목록을 신고하기 위해 대상 조회하는 오퍼레이션 <br>
	 * 
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {

		List<IndiaManifestListDetailVO> list1 = null;
		List<IndiaManifestListDetailVO> list2 = null;
		List<IndiaManifestListDetailVO> list3 = null;

		IndiaContainerVO containerVO = new IndiaContainerVO();
		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		try {

			// 1.배정보 조회
			list1 = dbDao.searchIGMVsl((IndiaManifestListCondVO) manifestListCondVO);

			if (list1 != null && list1.size() > 0) {
				// 2. BL List 정보 조회
				list2 = dbDao.searchIndiaManifestListByVvdPort((IndiaManifestListCondVO) manifestListCondVO);

				// 3. Container 정보 조회
				list3 = dbDao.searchIndiaCntrManifestListByVvdPort((IndiaManifestListCondVO) manifestListCondVO);
			}

			containerVO.setIndiaManifestListVslInfoVOList(list1);
			containerVO.setIndiaManifestListDetailVOList(list2);
			containerVO.setIndiaCntrMfDetailVOList(list3);

			manifestListDetailVO.add(containerVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return manifestListDetailVO;

	}

	/**
	 * INDIA 세관에 적하목록을 신고하기 위해 필요한 아이템을 저장하는 오퍼레이션<br>
	 * 
	 * @param manifestModificationVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account) throws EventException {
		try {

			IndiaContainerSaveVO containerSaveVO = null;

			IndiaIgmModiVO[] indiaIgmModiVOList = null;
			IndiaIgmCntrModiVO[] indiaIgmCntrModiVOList = null;

			List<IndiaIgmModiVO> insertBLVO = new ArrayList<IndiaIgmModiVO>();
			List<IndiaIgmModiVO> updateBlVO = new ArrayList<IndiaIgmModiVO>();
			List<IndiaIgmCntrModiVO> insertContainerVO = new ArrayList<IndiaIgmCntrModiVO>();
			List<IndiaIgmCntrModiVO> updateContainerVO = new ArrayList<IndiaIgmCntrModiVO>();

			IndiaIgmModiVO indiaIgmModiVO = null;
			IndiaIgmCntrModiVO indiaIgmCntrModiVO = null;

			if (manifestModificationVOs != null && manifestModificationVOs.length > 0) {
				containerSaveVO = (IndiaContainerSaveVO) manifestModificationVOs[0];

				indiaIgmModiVOList = containerSaveVO.getIndiaIgmModiVOList();
				indiaIgmCntrModiVOList = containerSaveVO.getIndiaIgmCntrModiVOList();

				if (indiaIgmModiVOList != null && indiaIgmModiVOList.length > 0) {

					for (int i = 0; i < indiaIgmModiVOList.length; i++) {
						indiaIgmModiVO = (IndiaIgmModiVO) indiaIgmModiVOList[i];
						indiaIgmModiVO.setCreUsrId(account.getUsr_id());
						indiaIgmModiVO.setUpdUsrId(account.getUsr_id());

						if (indiaIgmModiVO.getDownCheck().equals("N")) { 
							insertBLVO.add(indiaIgmModiVO);
						} else {
							updateBlVO.add(indiaIgmModiVO);
						}

					}
				}

				if (indiaIgmCntrModiVOList != null && indiaIgmCntrModiVOList.length > 0) {

					for (int i = 0; i < indiaIgmCntrModiVOList.length; i++) {
						indiaIgmCntrModiVO = (IndiaIgmCntrModiVO) indiaIgmCntrModiVOList[i];
						indiaIgmCntrModiVO.setCreUsrId(account.getUsr_id());
						indiaIgmCntrModiVO.setUpdUsrId(account.getUsr_id());

						 //세관쪽테이블 등록유무로 체크
						if (indiaIgmCntrModiVO.getDownCheck().equals("N")) { 
							insertContainerVO.add(indiaIgmCntrModiVO);
						} else {
							updateContainerVO.add(indiaIgmCntrModiVO);
						}

					}

				}

			} // end if()

			if (insertBLVO.size() > 0) {
				dbDao.addIGM(insertBLVO);
			}
			if (updateBlVO.size() > 0) {
				dbDao.modifyIGM(updateBlVO);
			}
			if (insertContainerVO.size() > 0) {
				dbDao.addIGMCntr(insertContainerVO);
			}
			if (updateContainerVO.size() > 0) {
				dbDao.modifyIGMCntr(updateContainerVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Office 코드 등록 유무 조회<br>
	 * 
	 * @param ofcCd
	 * @return int
	 * @throws EventException
	 */
	public int searchExistOrganization(String ofcCd) throws EventException {

		int retVal = 0;

		try {

			retVal = dbDao.searchExistOrganization(ofcCd);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * INDIA 세관에 프린트폼 세팅하기위해 폼정보 조회하는 오퍼레이션<br>
	 * 
	 * @param cstmsNtfyAddrCondVO
	 * @return List<CstmsNtfyAddrVO>
	 * @throws EventException
	 */
	public List<CstmsNtfyAddrVO> searchCstmsNtfyAddr(CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO) throws EventException {

		List<CstmsNtfyAddrVO> list = null;

		try {

			list = dbDao.searchFormSettingByOfcCd((InPrintFormCondVO) cstmsNtfyAddrCondVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * INDIA 세관에 프린트폼 세팅하기위해 폼정보 저장하는 오퍼레이션<Br>
	 * 
	 * @param cstmsNtfyAddrVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageCstmsNtfyAddr(CstmsNtfyAddrVO[] cstmsNtfyAddrVOs, SignOnUserAccount account) throws EventException {
		try {

			InPrintFormModiVO inPrintFormModiVO = null;
			List<InPrintFormModiVO> manageList = new ArrayList<InPrintFormModiVO>();
			int retUpdate = 0;

			if (cstmsNtfyAddrVOs != null && cstmsNtfyAddrVOs.length > 0) {
				inPrintFormModiVO = (InPrintFormModiVO) cstmsNtfyAddrVOs[0];

				for (int i = 0; i < cstmsNtfyAddrVOs.length; i++) {
					inPrintFormModiVO = (InPrintFormModiVO) cstmsNtfyAddrVOs[i];
					inPrintFormModiVO.setCreUsrId(account.getUsr_id());
					inPrintFormModiVO.setUpdUsrId(account.getUsr_id());

					manageList.add(inPrintFormModiVO);
				}

				if ("U".equalsIgnoreCase(inPrintFormModiVO.getIbflag())) { // update
					retUpdate = dbDao.modifyFormSetting(manageList);

					if (retUpdate == 0) {
						dbDao.addFormSetting(manageList);
					}

				} else if ("I".equalsIgnoreCase(inPrintFormModiVO.getIbflag())) { // insert
					dbDao.addFormSetting(manageList);
				}

			} // end if()

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * INDIA 세관에 적하목록을 신고하기 위해 Bond (warehouse) 정보를 조회하는 오퍼레이션<Br>
	 * 
	 * @param bondCondVO
	 * @return List<BondDetailListVO>
	 * @throws EventException
	 */
	public List<BondDetailListVO> searchBondList(BondCondVO bondCondVO) throws EventException {

		List<BondDetailListVO> list = null;

		try {
			list = dbDao.searchBondListByCdNm((IndiaBondListCondVO) bondCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

		return list;

	}

}