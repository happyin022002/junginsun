/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndiaManifestListDownloadBCImpl.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration.IndiaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaBondListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaContainerSaveVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaIgmCntrModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaIgmModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-IndiaManifestListDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public class IndiaManifestListDownloadBCImpl extends BasicCommandSupport implements IndiaManifestListDownloadBC {

	// Database Access Object
	private transient IndiaManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManifestListDownloadBCImpl objects creation<br>
	 * ManifestListDownloadDBDAO creation<br>
	 */
	public IndiaManifestListDownloadBCImpl() {
		dbDao = new IndiaManifestListDownloadDBDAO();
	}

	/**
	 * Searching the Vessel Details Info<br>
	 *
	 * @param VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO) throws EventException {

		List<VesselArrivalDetailVO> list = null;

		try {

			// India table
			list = dbDao.searchIgmVesselDetailsByVvdPod((InVesselArrivalCondVO) vesselArrivalCondVO);

			if (list != null && list.size() == 0) {
				// VVD table
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
	 * Managing(Insert/Update/Delete) the Vessel Details Info<br>
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
	 * Searching the Manifest list for INDIA Customs<br>
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

			// 1.VVD
			list1 = dbDao.searchIGMVsl((IndiaManifestListCondVO) manifestListCondVO);

			if (list1 != null && list1.size() > 0) {
				// 2. BL List
				list2 = dbDao.searchIndiaManifestListByVvdPort((IndiaManifestListCondVO) manifestListCondVO);

				// 3. Container
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
	 * Managing(Save) the list for INDIA Customs Manifest<br>
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
	 * Searching whether the Office code exist<br>
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
	 * Searching the Info for setting the print-form of INDIA Customs<br>
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
	 * Managing(save) the Info for setting the print-form of INDIA Customs<Br>
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
	 * Searching the Bond(warehouse) Info<Br>
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