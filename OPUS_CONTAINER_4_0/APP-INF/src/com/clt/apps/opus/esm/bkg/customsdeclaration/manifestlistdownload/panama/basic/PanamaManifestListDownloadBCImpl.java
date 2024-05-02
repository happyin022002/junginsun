/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PanamaManifestListDownloadBCImpl.java
 *@FileTitle : UI_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.integration.PanamaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListEmptyCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListGeneralCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListHazardousCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaVesselCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0017EventResponse,PanamaManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class PanamaManifestListDownloadBCImpl extends BasicCommandSupport implements PanamaManifestListDownloadBC {

	// Database Access Object
	private transient PanamaManifestListDownloadDBDAO dbDao = null;

	/**
	 * PanamaManifestListDownloadBCImpl 객체 생성<br>
	 * PanamaManifestListDownloadDBDAO 생성한다.<br>
	 */
	public PanamaManifestListDownloadBCImpl() {
		dbDao = new PanamaManifestListDownloadDBDAO();
	}

	/**
	 * Panama를 통과하는 화물에 대한 Manifest List를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		String callSeq = "";
		PanamaManifestListCondVO panamaManifestListCondVO = (PanamaManifestListCondVO) manifestListCondVO;
		List<PanamaManifestListGeneralCargoDetailVO> panamaManifestListGeneralCargoDetailVOs = null;
		List<PanamaManifestListEmptyCargoDetailVO> panamaManifestListEmptyCargoDetailVOs = null;
		List<PanamaManifestListHazardousCargoDetailVO> panamaManifestListHazardousCargoDetailVOs = null;
		PanamaVesselVO panamaVesselVO = null;

		PanamaContainerVO panamaContainerVO = new PanamaContainerVO();

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		try {
			List<VesselVO> vesselVOs = dbDao.searchVslInfo(panamaManifestListCondVO);
			if (vesselVOs.size() > 0) {
				panamaVesselVO = (PanamaVesselVO) vesselVOs.get(0);
				panamaContainerVO.setPanamaVesselVO(panamaVesselVO);

				callSeq = dbDao.searchCallSeq(panamaManifestListCondVO);
				panamaManifestListCondVO.setClptSeq(callSeq);

				panamaManifestListGeneralCargoDetailVOs = dbDao.searchGeneralCargoDetail(panamaManifestListCondVO);
				panamaContainerVO.setPanamaManifestListGeneralCargoDetailVOs(panamaManifestListGeneralCargoDetailVOs);

				panamaManifestListEmptyCargoDetailVOs = dbDao.searchEmptyCargoDetail(panamaManifestListCondVO);
				panamaContainerVO.setPanamaManifestListEmptyCargoDetailVOs(panamaManifestListEmptyCargoDetailVOs);

				panamaManifestListHazardousCargoDetailVOs = dbDao.searchHazardousCargoDetail(panamaManifestListCondVO);
				panamaContainerVO.setPanamaManifestListHazardCargoDetailVOs(panamaManifestListHazardousCargoDetailVOs);

				manifestListDetailVO.add((ManifestListDetailVO) panamaContainerVO);
			}
			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 등록했던 Vessel 정보를 조회한다.<br>
	 * 
	 * @param vesselCondVO VesselCondVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVessel(VesselCondVO vesselCondVO) throws EventException {
		try {
			return dbDao.searchVesselList((PanamaVesselCondVO) vesselCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 사전 VVD INFORMATION을 입력한다.<br>
	 * 
	 * @param VesselVO[] vesselVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVessel(VesselVO[] vesselVOs, SignOnUserAccount account) throws EventException {
		try {
			// List<BkgCstmsPnmVvdVO> list = null;
			boolean isNew = false;
			for (int i = 0; i < vesselVOs.length; i++) {
				isNew = (((PanamaVesselVO) vesselVOs[i]).getVslCdTemp().equals("") || ((PanamaVesselVO) vesselVOs[i])
						.getVslCdTemp() == null) ? true : false;
				((PanamaVesselVO) vesselVOs[i]).setVslCd(((PanamaVesselVO) vesselVOs[i]).getVvdCd().substring(0, 4));
				((PanamaVesselVO) vesselVOs[i]).setSkdVoyNo(((PanamaVesselVO) vesselVOs[i]).getVvdCd().substring(4, 8));
				((PanamaVesselVO) vesselVOs[i]).setSkdDirCd(((PanamaVesselVO) vesselVOs[i]).getVvdCd().substring(8));
				if (isNew) {
					((PanamaVesselVO) vesselVOs[i]).setCreUsrId(account.getUsr_id());
					dbDao.addVessel((PanamaVesselVO) vesselVOs[i]);
				} else {
					((PanamaVesselVO) vesselVOs[i]).setUpdUsrId(account.getUsr_id());
					dbDao.modifyVessel((PanamaVesselVO) vesselVOs[i]);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 수정된 Vessel 정보를 BKG CUSTOMS PANAMA VVD에 저장한다.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySendHist(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException {
		try {
			PanamaManifestTransmitVO panamaManifestTransmitVO = (PanamaManifestTransmitVO)manifestTransmitVO;
			if (account == null)
				panamaManifestTransmitVO.setUpdUsrId("AUTO SEND");
			else
				panamaManifestTransmitVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifySendHist(panamaManifestTransmitVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

}