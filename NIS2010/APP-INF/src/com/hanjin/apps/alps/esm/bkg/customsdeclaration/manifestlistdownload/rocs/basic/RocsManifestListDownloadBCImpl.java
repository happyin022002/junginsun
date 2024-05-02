/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RocsManifestListDownloadBCImpl.java
 *@FileTitle : UI_BKG-0440
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2011.10.19 김보배 [CHM-201113922] [BKG] [ROCS] ADD Lane - 하드코딩 제거, lane 추가 테이블 관리
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.basic;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration.RocsManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlSeqVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsCmdModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsCntrModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsContainerSaveVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsHistoryListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestConfirmationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsRcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsReceiveLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBkgListForNVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBkgNoForYVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBlCountVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCRNForAddVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCRNVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchDiffBkgForYVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchInboundBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchPortListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsTransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsTransmitHistListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocscrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlSeqVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HistoryListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestConfirmationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.RcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.RecieveHistLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.sun.net.ssl.internal.ssl.Debug;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author LIM JAE TAEK
 * @see EventResponse,RocsManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RocsManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient RocsManifestListDownloadDBDAO dbDao = null;

	/**
	 * RocsManifestListDownloadBCImpl 객체 생성<br>
	 * RocsManifestListDownloadBCImpl 생성한다.<br>
	 */
	public RocsManifestListDownloadBCImpl() {
		dbDao = new RocsManifestListDownloadDBDAO();
	}

	/**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN 정보를 조회한다.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> searchCRN(ManifestListCondVO manifestListCondVO) throws EventException {
		RocsManifestListCondVO rocsManifestListCondVO = (RocsManifestListCondVO) manifestListCondVO;

		try {
			return dbDao.searchCRN(rocsManifestListCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN Detail 정보를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> searchCRNInfo(ManifestListCondVO manifestListCondVO) throws EventException {
		RocsManifestListCondVO rocsManifestListCondVO = (RocsManifestListCondVO) manifestListCondVO;

		try {
			return dbDao.searchCRNInfo(rocsManifestListCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN Detail 정보를 조회한다.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> searchCRNInfo(String vslCd, String skdVoyNo, String skdDirCd) throws EventException {

		try {
			return dbDao.searchVvdReg(vslCd, skdVoyNo, skdDirCd);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN 정보를 조회한다.
	 * 
	 * @param String frmCrnNumber
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> searchCRN(String frmCrnNumber, String vslCd, String skdVoyNo, String skdDirCd)
			throws EventException {

		try {
			return dbDao.searchCRN(frmCrnNumber, vslCd, skdVoyNo, skdDirCd);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN 정보를 등록 및 수정한다.
	 * 
	 * @param CrnVO crnVo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */

	public int manageCRN(CrnVO crnVo, SignOnUserAccount account) throws EventException {

		int ret = 0;
		List<RocsSearchCRNForAddVO> rocsSearchCRNForAddVO = null;
		try {
			RocscrnVO rocsCrnVO = new RocscrnVO();
			rocsCrnVO = (RocscrnVO) crnVo;
			rocsCrnVO.setCstmsDeclUserId(account.getUsr_id());
			rocsCrnVO.setuserOfcCd(account.getOfc_cd());

			List<CrnVO> list = dbDao.searchVvdReg(rocsCrnVO.getVslCd(), rocsCrnVO.getSkdVoyNo(), rocsCrnVO
					.getSkdDirCd());
			if (list.size() == 0 && "I".equalsIgnoreCase(rocsCrnVO.getIbflag())) {
				ret = 8;
				return ret;
			}

			rocsSearchCRNForAddVO = dbDao.searchCRNForAdd(rocsCrnVO.getFCrnNumber(), rocsCrnVO.getVslCd(), rocsCrnVO
					.getSkdVoyNo(), rocsCrnVO.getSkdDirCd());
			if (rocsSearchCRNForAddVO.size() > 0 && "I".equalsIgnoreCase(rocsCrnVO.getIbflag())) {
				ret = 9;
				return ret;
			}
			if ("U".equalsIgnoreCase(rocsCrnVO.getIbflag())) { // update

				ret = dbDao.modifyCRN(rocsCrnVO);

				if (ret == 0) {
					rocsCrnVO.setCstmsDeclUserId(account.getUsr_id());
					ret = dbDao.addCRN(rocsCrnVO);
				}
			} else if ("I".equalsIgnoreCase(rocsCrnVO.getIbflag())) { // insert
				rocsCrnVO.setCstmsDeclUserId(account.getUsr_id());
				ret = dbDao.addCRN(rocsCrnVO);
			}
			return ret;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 *ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 한다.
	 * 
	 * @param ManifestConfirmationVO[] manifestConfirmationVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmManifestList(ManifestConfirmationVO[] manifestConfirmationVOs, SignOnUserAccount account)
			throws EventException {

		List<RocscrnVO> rocscrnVO = null;
		List<RocscrnVO> rocscrnVO2 = null;
		// int ret = 0;
		BookingUtil util = new BookingUtil();
		try {

			for (int i = 0; i < manifestConfirmationVOs.length; i++) {
				RocsManifestConfirmationVO rocsManifestConfirmationVO = new RocsManifestConfirmationVO();

				rocsManifestConfirmationVO = (RocsManifestConfirmationVO) manifestConfirmationVOs[i];
				rocsManifestConfirmationVO.setUserId(account.getUsr_id());
				rocscrnVO = dbDao.searchCntrForCfm((RocsManifestConfirmationVO) manifestConfirmationVOs[i]);
				rocscrnVO2 = dbDao.searchCmdForCfm((RocsManifestConfirmationVO) manifestConfirmationVOs[i]);

				if (rocsManifestConfirmationVO.getMtFlag().equalsIgnoreCase("F") && rocscrnVO2.size() == 0) {
					
					rocsManifestConfirmationVO.setBlDatCfmDt(util.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
					dbDao.modifyConfirmIndD(rocsManifestConfirmationVO);
				}
				if (rocscrnVO.size() == 0) {
					rocsManifestConfirmationVO.setBlDatCfmDt(util.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
					dbDao.modifyConfirmIndC(rocsManifestConfirmationVO);
				}

				if (!(rocsManifestConfirmationVO.getMtFlag().equalsIgnoreCase("F") && rocscrnVO2.size() == 0)
						&& !(rocscrnVO.size() == 0)) {
					rocsManifestConfirmationVO.setBlDatCfmDt(util.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
					dbDao.modifyConfirmInd(rocsManifestConfirmationVO);
				}

			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 *ROCS(ROTTERDAM) 세관 Manifest 신고용 B/L 정보를 삭제한다.
	 * 
	 * @param List<BlKeyVO> blKeyVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void removeBl(List<BlKeyVO> blKeyVOs, SignOnUserAccount account) throws EventException {

		List<RocsSearchBkgNoVO> rocsSearchBkgNoVOs = null;
		RocsSearchBkgNoVO rocsSearchBkgNoVO = null;

		try {

			for (int i = 0; i < blKeyVOs.size(); i++) {
				RocsBlKeyVO rocsBlKeyVO = new RocsBlKeyVO();
				rocsBlKeyVO = (RocsBlKeyVO) blKeyVOs.get(i);
				if (rocsBlKeyVO.getBlNo().length() > 9) {
					String blNo = rocsBlKeyVO.getBlNo().substring(0, 12);
					rocsBlKeyVO.setBlNO(blNo);
				} else
					rocsBlKeyVO.setBlNO("");
				rocsSearchBkgNoVOs = dbDao.searchBkgNo(rocsBlKeyVO);

				if (rocsSearchBkgNoVOs.size() > 0) {
					rocsSearchBkgNoVO = (RocsSearchBkgNoVO) rocsSearchBkgNoVOs.get(0);
					RocsBlKeyVO rocsBlKeyVO2 = new RocsBlKeyVO();

					rocsBlKeyVO2.setBkgNO(rocsSearchBkgNoVO.getBkgNo());
					rocsBlKeyVO2.setCrnNumber(rocsBlKeyVO.getCrnNumber());

					dbDao.removeRocsCmd(rocsBlKeyVO2);
					dbDao.removeRocsCntr(rocsBlKeyVO2);
					dbDao.removeRocsBl(rocsBlKeyVO2);
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Rocs를 통과하는 화물에 대한 Manifest List를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		RocsManifestListCondVO rocsManifestListCondVO = (RocsManifestListCondVO) manifestListCondVO;

		RocsSearchVslInfoVO rocsSearchVslInfoVO = null;

		List<RocsSearchPortListVO> rocsSearchPortListVOs = null;
		List<RocsSearchBlCountVO> rocsSearchBlCountVOs = null;
		List<RocsManifestConfirmationVO> rocsManifestConfirmationVOs = null;
		List<CrnVO> crnVOs = null;

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		RocsContainerVO rocsContainerVO = new RocsContainerVO();

		try {
			if (rocsManifestListCondVO.getPgNo().equalsIgnoreCase("esm0351")) {
				List<RocsSearchInboundBlListVO> rocsSearchInboundBlListVOs = dbDao
						.searchInBoundBlList(rocsManifestListCondVO);
				if (rocsSearchInboundBlListVOs.size() > 0) {
					rocsContainerVO.setRocsSearchInboundBlListVOs(rocsSearchInboundBlListVOs);
					manifestListDetailVO.add((ManifestListDetailVO) rocsContainerVO);
				}
			} else {
				List<VesselVO> vesselVOs = dbDao.searchVslInfo(rocsManifestListCondVO);

				if (vesselVOs.size() > 0) {
					rocsSearchVslInfoVO = (RocsSearchVslInfoVO) vesselVOs.get(0);
					rocsContainerVO.setRocsSearchVslInfoVO(rocsSearchVslInfoVO);
					rocsManifestListCondVO.setVslCd(rocsSearchVslInfoVO.getVvdNumber().substring(0, 4));
					rocsManifestListCondVO.setSkdVoyNo(rocsSearchVslInfoVO.getVvdNumber().substring(4, 8));
					rocsManifestListCondVO.setSkdDirCd(rocsSearchVslInfoVO.getVvdNumber().substring(8));
					
					rocsManifestListCondVO.setPodClptIndSeq(rocsSearchVslInfoVO.getPodClptIndSeq()); // Add
					
					rocsSearchPortListVOs = (List<RocsSearchPortListVO>) dbDao.searchPortList(rocsManifestListCondVO);
					rocsContainerVO.setRocsSearchPortListVOs(rocsSearchPortListVOs);
					/*crnVOs = dbDao.searchCRN(rocsManifestListCondVO);
					if ( crnVOs.size() > 0 )
						rocsManifestListCondVO.setCrnNumber(((RocsSearchCRNVO)crnVOs.get(0)).getCrnNumber());					
					*/
					rocsSearchBlCountVOs = dbDao.searchBlCount(rocsManifestListCondVO);
					rocsContainerVO.setRocsSearchBlCountVOs(rocsSearchBlCountVOs);

					rocsManifestConfirmationVOs = dbDao.searchBlList(rocsManifestListCondVO);
					if (rocsManifestConfirmationVOs != null && rocsManifestConfirmationVOs.size() != 0) {
						String blNumber = rocsManifestConfirmationVOs.get(0).getBlNo();
						int seqNumber = 1;
						for (int i = 0; i < rocsManifestConfirmationVOs.size(); i++) {
							if (rocsManifestConfirmationVOs.get(i).getT1DocCd() == null
									|| rocsManifestConfirmationVOs.get(i).getT1DocCd().equals(""))
								rocsManifestConfirmationVOs.get(i).setT1DocCd(" ");
							if (rocsManifestConfirmationVOs.get(i).getBlNo().equals(blNumber)) {
								rocsManifestConfirmationVOs.get(i).setSeq(seqNumber + "");
							} else {
								blNumber = rocsManifestConfirmationVOs.get(i).getBlNo();
								rocsManifestConfirmationVOs.get(i).setSeq(++seqNumber + "");
							}
						}
					}
					rocsContainerVO.setRocsManifestConfirmationVOs(rocsManifestConfirmationVOs);
					manifestListDetailVO.add((ManifestListDetailVO) rocsContainerVO);
				}
			}
			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * ROCS 세관에 적하목록을 신고하기 위해 필요한 아이템을 저장하는 오퍼레이션
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 * @throws DAOException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException {
		RocsContainerSaveVO rocsContainerSaveVO = null;

		RocsSearchCntrListVO[] rocsSearchCntrListVOList = null;
		RocsSearchCargoDetailVO[] rocsSearchCargoDetailVOList = null;
		RocsBlModificationVO rocsBlModificationVO = null;

		RocsSearchCntrListVO rocsSearchCntrListVO = null;
		RocsSearchCargoDetailVO rocsSearchCargoDetailVO = null;
		RocsCntrModificationVO rocsCntrModificationVO = new RocsCntrModificationVO();
		RocsCmdModificationVO rocsCmdModificationVO = new RocsCmdModificationVO();
		try {
			if (manifestModificationVOs.length > 0 && manifestModificationVOs != null) {

				rocsContainerSaveVO = (RocsContainerSaveVO) manifestModificationVOs[0];
				rocsBlModificationVO = rocsContainerSaveVO.getRocsBlModificationVO();
				rocsBlModificationVO.setUserId(account.getUsr_id());
				rocsBlModificationVO.setOfcCd(account.getOfc_cd());
				if (rocsBlModificationVO != null) {
					dbDao.modifyBlInfo(rocsBlModificationVO);
					dbDao.modifyRocsNtfy(rocsBlModificationVO);
				}
				rocsSearchCntrListVOList = rocsContainerSaveVO.getRocsSearchCntrListVOList();
				if (rocsSearchCntrListVOList != null && rocsSearchCntrListVOList.length > 0) {
					for (int j = 0; j < rocsSearchCntrListVOList.length; j++) {
						rocsSearchCntrListVO = (RocsSearchCntrListVO) rocsSearchCntrListVOList[j];
						rocsCntrModificationVO.setCntrSealNo(rocsSearchCntrListVO.getCntrSealNo());
						rocsCntrModificationVO.setCntrTpszCd(rocsSearchCntrListVO.getCntrTpszCd());
						rocsCntrModificationVO.setIsoCntrTpszCd(rocsSearchCntrListVO.getIsoCntrTpszCd());
						rocsCntrModificationVO.setCntrTpszDesc(rocsSearchCntrListVO.getCntrTpszDesc());
						rocsCntrModificationVO.setPckQty(rocsSearchCntrListVO.getPckQty());
						rocsCntrModificationVO.setPckTpCd(rocsSearchCntrListVO.getPckTpCd());
						rocsCntrModificationVO.setPckDesc(rocsSearchCntrListVO.getPckDesc());
						rocsCntrModificationVO.setCntrMfWgt(rocsSearchCntrListVO.getCntrMfWgt());
						rocsCntrModificationVO.setCntrWgtUtCd(rocsSearchCntrListVO.getCntrWgtUtCd());
						rocsCntrModificationVO.setT1DocCd(rocsSearchCntrListVO.getT1DocCd());
						rocsCntrModificationVO.setVslCallRefNo(rocsSearchCntrListVO.getVslCallRefNo());
						rocsCntrModificationVO.setBkgNo(rocsSearchCntrListVO.getBkgNo());
						rocsCntrModificationVO.setBkgNoSplit(rocsSearchCntrListVO.getBkgNoSplit());
						rocsCntrModificationVO.setCntrNo(rocsSearchCntrListVO.getCntrNo());
						rocsCntrModificationVO.setUserId(account.getUsr_id());
						rocsCntrModificationVO.setOfcCd(account.getOfc_cd());
						if (rocsSearchCntrListVO.getIbflag().equalsIgnoreCase("U")) {
							dbDao.modifyCntrInfo((RocsCntrModificationVO) rocsCntrModificationVO);
						}
						if (rocsSearchCntrListVO.getIbflag().equalsIgnoreCase("D")) {
							dbDao.removeCntrInfo((RocsCntrModificationVO) rocsCntrModificationVO);
							dbDao.removeCmdForNoCntr((RocsCntrModificationVO) rocsCntrModificationVO);
						}
						if (rocsSearchCntrListVO.getIbflag().equalsIgnoreCase("I")) {
							dbDao.addCntrInfo((RocsCntrModificationVO) rocsCntrModificationVO);
						}
					}
				}
				rocsSearchCargoDetailVOList = rocsContainerSaveVO.getRocsSearchCargoDetailVOList();
				if (rocsSearchCargoDetailVOList != null && rocsSearchCargoDetailVOList.length > 0) {
					for (int k = 0; k < rocsSearchCargoDetailVOList.length; k++) {
						rocsSearchCargoDetailVO = (RocsSearchCargoDetailVO) rocsSearchCargoDetailVOList[k];
						rocsCmdModificationVO.setPckQty(rocsSearchCargoDetailVO.getPckQty());
						rocsCmdModificationVO.setPckTpCd(rocsSearchCargoDetailVO.getPckTpCd());
						rocsCmdModificationVO.setPckDesc(rocsSearchCargoDetailVO.getPckDesc());
						rocsCmdModificationVO.setCntrMfWgt(rocsSearchCargoDetailVO.getCntrMfWgt());
						rocsCmdModificationVO.setCntrWgtUtCd(rocsSearchCargoDetailVO.getCntrWgtUtCd());
						rocsCmdModificationVO.setCntrMfDesc(rocsSearchCargoDetailVO.getCntrMfDesc2());
						rocsCmdModificationVO.setHamoTrfCd(rocsSearchCargoDetailVO.getHamoTrfCd());
						rocsCmdModificationVO.setVslCallRefNo(rocsSearchCargoDetailVO.getVslCallRefNo());
						rocsCmdModificationVO.setBkgNo(rocsSearchCargoDetailVO.getBkgNo());
						rocsCmdModificationVO.setBkgNoSplit(rocsSearchCargoDetailVO.getBkgNoSplit());
						rocsCmdModificationVO.setCntrNo(rocsSearchCargoDetailVO.getCntrNo());
						rocsCmdModificationVO.setCntrMfSeq(rocsSearchCargoDetailVO.getCntrMfSeq());
						rocsCmdModificationVO.setUserId(account.getUsr_id());
						rocsCmdModificationVO.setOfcCd(account.getOfc_cd());

						if (rocsSearchCargoDetailVO.getIbflag().equalsIgnoreCase("U")) {
							dbDao.modifyCmdInfo((RocsCmdModificationVO) rocsCmdModificationVO);
						}
						if (rocsSearchCargoDetailVO.getIbflag().equalsIgnoreCase("D")) {
							dbDao.removeCmdInfo((RocsCmdModificationVO) rocsCmdModificationVO);
							dbDao.removeCmdForNoCntr((RocsCmdModificationVO) rocsCmdModificationVO);
						}
						if (rocsSearchCargoDetailVO.getIbflag().equalsIgnoreCase("I")) {
							dbDao.addCmdInfo((RocsCmdModificationVO) rocsCmdModificationVO);
						}
					}
				}
				dbDao.modifyBlActWgtByCntr(rocsBlModificationVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 세관 신고 대상 List를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestListForRocsBl(ManifestListCondVO manifestListCondVO)
			throws EventException {
		RocsManifestListCondVO rocsManifestListCondVO = (RocsManifestListCondVO) manifestListCondVO;

		List<RocsSearchBlInfoVO> rocsSearchBlInfoVOs = null;
		RocsSearchBlInfoVO rocsSearchBlInfoVO = null;
		List<RocsSearchCntrListVO> rocsSearchCntrListVOs = null;
		List<RocsSearchCargoDetailVO> rocsSearchCargoDetailVOs = null;

		RocsBlKeyVO rocsBlKeyVO = new RocsBlKeyVO();

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
		RocsContainerVO rocsContainerVO = new RocsContainerVO();

		try {

			rocsBlKeyVO.setCrnNumber(rocsManifestListCondVO.getCrnNumber());
			rocsBlKeyVO.setDifChr(rocsManifestListCondVO.getDifChr());
			rocsBlKeyVO.setBlNO(rocsManifestListCondVO.getBlNo());
			rocsBlKeyVO.setBlTpCd(rocsManifestListCondVO.getBlTpCd());

			rocsSearchBlInfoVOs = dbDao.searchBlInfo((BlKeyVO) rocsBlKeyVO);
			if (rocsSearchBlInfoVOs.size() > 0) {
				rocsSearchBlInfoVO = (RocsSearchBlInfoVO) rocsSearchBlInfoVOs.get(0);
				rocsContainerVO.setRocsSearchBlInfoVO(rocsSearchBlInfoVO);

				rocsBlKeyVO.setBkgNO(rocsSearchBlInfoVO.getBkgNo());
				//rocsBlKeyVO.setBkgNoSplit(rocsSearchBlInfoVO.getBkgNoSplit());

				rocsSearchCntrListVOs = dbDao.searchCntrList((BlKeyVO) rocsBlKeyVO);
				rocsContainerVO.setRocsSearchCntrListVOs(rocsSearchCntrListVOs);

				rocsSearchCargoDetailVOs = dbDao.searchCarcgDetail((BlKeyVO) rocsBlKeyVO);
				rocsContainerVO.setRocsSearchCargoDetailVOs(rocsSearchCargoDetailVOs);
				manifestListDetailVO.add((ManifestListDetailVO) rocsContainerVO);
			}

			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션<br>
	 * 
	 * @param vesselCondVO VesselCondVO
	 * @return List<VesselArrivalVO>
	 * @exception EventException
	 */
	public List<VesselArrivalVO> searchVesselArrival(VesselCondVO vesselCondVO) throws EventException {
		try {
			return dbDao.searchVesselArrival((RocsVesselArrivalCondVO) vesselCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vesselCondVO VesselCondVO
	 * @return List<ManifestListVO>
	 * @exception EventException
	 */
	public List<ManifestListVO> searchManifestList(VesselCondVO vesselCondVO) throws EventException {
		try {
			return dbDao.searchPortList((RocsVesselArrivalCondVO) vesselCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 추가 이벤트 처리<br>
	 * download 후 B/L을 추가 할 수 있다.<br>
	 * 
	 * @param BlVO blVO
	 * @param SignOnUserAccount account
	 * @throws Exception
	 * @throws DAOException
	 */
	public void addBl(BlVO blVO, SignOnUserAccount account) throws EventException {

		RocsBlVO rocsBlVO = new RocsBlVO();
		List<RocsSearchBkgListForNVO> rocsSearchBkgListForNVOs = null;
		RocsSearchBkgListForNVO rocsSearchBkgListForNVO = null;
		List<RocsSearchDiffBkgForYVO> rocsSearchDiffBkgForYVOs = null;
		RocsSearchDiffBkgForYVO rocsSearchDiffBkgForYVO = null;
		List<RocsSearchBkgNoForYVO> rocsSearchBkgNoForYVOs = null;
		RocsBlKeyVO rocsBlKeyVO = new RocsBlKeyVO();
		List<RocsSearchBkgListForNVO> rocsSearchBkgListForCheckVOs = null;
		
		RocsBlVO rocsBlExistVO = new RocsBlVO();
		
		try {
			rocsBlVO = (RocsBlVO) blVO;
			String slanCd = rocsBlVO.getFrmSlanCd();
			if (slanCd.equalsIgnoreCase("New"))
				rocsBlVO.setSlanCd("N");
			if (slanCd.equalsIgnoreCase("Created"))
				rocsBlVO.setSlanCd("Y");
			
			rocsBlExistVO.setCrnNumber(rocsBlVO.getCrnNumber());
			rocsBlExistVO.setVslCd(rocsBlVO.getVslCd());
			rocsBlExistVO.setSkdVoyNo(rocsBlVO.getSkdVoyNo());
			rocsBlExistVO.setSkdDirCd(rocsBlVO.getSkdDirCd());
			
			
			//rocsSearchBkgListForCheckVOs = dbDao.searchBkgListForN(rocsBlVO.getCrnNumber(), null); // 2015.04.20
			rocsSearchBkgListForCheckVOs = dbDao.searchBkgListForN(rocsBlExistVO);
			
			if (rocsSearchBkgListForCheckVOs!=null && rocsSearchBkgListForCheckVOs.size()>0){
				slanCd = "Created";
				rocsBlVO.setSlanCd("Y");
			}
			
			rocsBlVO.setOfcCd(account.getOfc_cd());
			
			String pgNo = rocsBlVO.getPgNo();
			if (pgNo.equalsIgnoreCase("esm0444")) {
				if (slanCd.equalsIgnoreCase("New")) {
					dbDao.addBlForN(rocsBlVO);
					dbDao.modifyT1IndForN(rocsBlVO); // (rocsBlVO.getCrnNumber());
					dbDao.addNtfyForN(rocsBlVO); // (rocsBlVO.getCrnNumber());
					dbDao.addCntrForN(rocsBlVO, account.getOfc_cd(), account.getUsr_id()); //(rocsBlVO.getCrnNumber(), rocsBlVO.getPolCd(), account.getOfc_cd(), account.getUsr_id());
					
					//rocsSearchBkgListForNVOs = dbDao.searchBkgListForN(rocsBlVO.getCrnNumber(), rocsBlVO.getPolCd()); // 2015.04.20
					rocsSearchBkgListForNVOs = dbDao.searchBkgListForN(rocsBlVO);
					if (rocsSearchBkgListForNVOs != null && rocsSearchBkgListForNVOs.size() > 0) {
						for (int k = 0; k < rocsSearchBkgListForNVOs.size(); k++) {
							rocsSearchBkgListForNVO = (RocsSearchBkgListForNVO) rocsSearchBkgListForNVOs.get(k);
							dbDao.addCmdForN(rocsBlVO.getCrnNumber().toString(), account.getOfc_cd(), account
									.getUsr_id(), rocsSearchBkgListForNVO.getBkgNo());
						}
					}

				}
				if (slanCd.equalsIgnoreCase("Created")) {
					rocsSearchDiffBkgForYVOs = dbDao.searchDiffBkgForY(rocsBlVO);
					if (rocsSearchDiffBkgForYVOs != null && rocsSearchDiffBkgForYVOs.size() > 0) {
						for (int k = 0; k < rocsSearchDiffBkgForYVOs.size(); k++) {
							rocsSearchDiffBkgForYVO = (RocsSearchDiffBkgForYVO) rocsSearchDiffBkgForYVOs.get(k);
							dbDao.addBlForY(rocsBlVO, account.getOfc_cd(), account.getUsr_id(),
									rocsSearchDiffBkgForYVO.getBkgNo());
							dbDao.modifyT1IndForY(rocsBlVO.getCrnNumber(), rocsSearchDiffBkgForYVO.getBkgNo());
							dbDao.addNtfyForY(rocsBlVO.getCrnNumber(), rocsSearchDiffBkgForYVO.getBkgNo());
							dbDao.addCntrForY(rocsBlVO.getCrnNumber(), account.getOfc_cd(), account.getUsr_id(),
									rocsSearchDiffBkgForYVO.getBkgNo());
							dbDao.addCmdForY(rocsBlVO.getCrnNumber(), account.getOfc_cd(), account.getUsr_id(),
									rocsSearchDiffBkgForYVO.getBkgNo());
						}
					}
				}
				if (slanCd.equalsIgnoreCase("New") || slanCd.equalsIgnoreCase("Created")) {
					dbDao.modifyCreateInd(rocsBlVO, account.getUsr_id());
				}
			}
			if (pgNo.equalsIgnoreCase("esm1017")) {
				rocsBlKeyVO.setBlNO(rocsBlVO.getBlNo());
				rocsSearchBkgNoForYVOs = dbDao.searchBkgNoForY(rocsBlKeyVO);
				String bkgNo = "";
				if (rocsSearchBkgNoForYVOs != null && rocsSearchBkgNoForYVOs.size() > 0) {
					bkgNo = rocsSearchBkgNoForYVOs.get(0).getBkgNo();
					
					dbDao.addBlForY(rocsBlVO, account.getOfc_cd(), account.getUsr_id(), bkgNo);
					dbDao.modifyT1IndForY(rocsBlVO.getCrnNumber(), bkgNo);
					dbDao.addNtfyForY(rocsBlVO.getCrnNumber(), bkgNo);
					dbDao.addCntrForY(rocsBlVO.getCrnNumber(), account.getOfc_cd(), account.getUsr_id(), bkgNo);
					dbDao.addCmdForY(rocsBlVO.getCrnNumber(), account.getOfc_cd(), account.getUsr_id(), bkgNo);

				}else{
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.
	 * 
	 * @param BlSeqVO[] blSeqVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBlSeq(BlSeqVO[] blSeqVOs, SignOnUserAccount account) throws EventException {

		try {
			if (blSeqVOs != null && blSeqVOs.length > 0) {
				for (int k = 0; k < blSeqVOs.length; k++) {
					RocsBlSeqVO rocsBlSeqVO = new RocsBlSeqVO();
					rocsBlSeqVO = (RocsBlSeqVO) blSeqVOs[k];
					dbDao.modifyBlSeq(rocsBlSeqVO);
				}

			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}
	
	/**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * 
	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @throws EventException
	 */
	public void modifyBlReceivedSts(RocsManifestTransmitVO rocsManifestTransmitVO) throws EventException {

		try {
			dbDao.modifyBlReceivedSts(rocsManifestTransmitVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}	

	/**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * @param List<RocsManifestTransmitVO> rocsManifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBlSndSts(List<RocsManifestTransmitVO> rocsManifestTransmitVOs, SignOnUserAccount account) throws EventException {

		try {
			BookingUtil util = new BookingUtil();
			for ( int i=0 ; i< rocsManifestTransmitVOs.size() ; i++ )
			{
				RocsManifestTransmitVO rocsManifestTransmitVO = rocsManifestTransmitVOs.get(i);
				rocsManifestTransmitVO.setBlDatCfmDt(util.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
				dbDao.modifyBlSndSts(rocsManifestTransmitVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}	
	
	/**
	 * ROCS(ROTTERDAM) 세관 POL CD를 변경
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBlPolCd(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException{

		try {
			List<RocsManifestTransmitVO> rocsManifestTransmitVOs = new ArrayList<RocsManifestTransmitVO>();
			String userId = account.getUsr_id();
			
			for (int i = 0; i < manifestTransmitVOs.length; i++) {
				RocsManifestTransmitVO rocsManifestTransmitVO = new RocsManifestTransmitVO();
				rocsManifestTransmitVO = (RocsManifestTransmitVO) manifestTransmitVOs[i];
				rocsManifestTransmitVO.setUsertId(userId);
				rocsManifestTransmitVOs.add(rocsManifestTransmitVO);
				
			}
			
			dbDao.modifyBlPolCd(rocsManifestTransmitVOs);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String	[] {}).getMessage(), ex);
		}

	}	
	
	/**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * @param String vslCallRefNoOld
	 * @param String vslCallRefNoNew
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCrnNo(String vslCallRefNoOld, String vslCallRefNoNew, SignOnUserAccount account) throws EventException {

		try {
			dbDao.modifyCrnNo(vslCallRefNoOld, vslCallRefNoNew, account.getUsr_id());
//			if ( dbDao.modifyCrnNoForVsl(vslCallRefNoOld, vslCallRefNoNew, account.getUpd_usr_id()) == 0 )
//			{
//				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage());
//			}
//			if ( dbDao.modifyCrnNoForBl(vslCallRefNoOld, vslCallRefNoNew, account.getUpd_usr_id()) == 0 )
//			{
//				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage());
//			}
//			if ( dbDao.modifyCrnNoForCntr(vslCallRefNoOld, vslCallRefNoNew, account.getUpd_usr_id()) == 0 )
//			{
//				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage());
//			}
//			if ( dbDao.modifyCrnNoForCm(vslCallRefNoOld, vslCallRefNoNew, account.getUpd_usr_id()) == 0 )
//			{
//				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage());
//			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}	

	/**
	 * Rotterdam세관에서 받은 edi 현황정보를 가져온다.
	 * 
	 * @param rcvHistCondVO RcvHistCondVO
	 * @return List<RocsSearchRocsReceiveListVO>
	 * @exception EventException
	 */
	public List<ReceiveLogVO> searchReceiveHist(RcvHistCondVO rcvHistCondVO) throws EventException {
		RocsRcvHistCondVO rocsRcvHistCondVO = (RocsRcvHistCondVO) rcvHistCondVO;

		try {
			return dbDao.searchRocsReceiveList(rocsRcvHistCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rotterdam세관에서 받은 Send edi 현황정보를 가져온다.
	 * 
	 * @param transmitHistCondVO
	 * @return
	 * @throws EventException
	 */
	public List<TransmitHistVO> searchTransmitHist(TransmitHistCondVO transmitHistCondVO) throws EventException {
		RocsTransmitHistCondVO rocsTransmitHistCondVO = (RocsTransmitHistCondVO) transmitHistCondVO;

		try {
			return dbDao.searchRocsSendList(rocsTransmitHistCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rotterdam세관에서 받은 edi 현황정보를 가져온다.
	 * 
	 * @param historyListCondVO HistoryListCondVO
	 * @return List<RecieveHistLogVO>
	 * @exception EventException
	 */
	public List<RecieveHistLogVO> searchHistoryList(HistoryListCondVO historyListCondVO) throws EventException {
		RocsHistoryListCondVO rocsHistoryListCondVO = (RocsHistoryListCondVO) historyListCondVO;

		try {
			return dbDao.searchRocsRcvHistByBl(rocsHistoryListCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rotterdam세관에 보낸 edi History 현황정보를 가져온다.
	 * 
	 * @param transmitHistListCondVO
	 * @return
	 * @throws EventException
	 */
	public List<TransmitHistVO> searchTransmitHistList(TransmitHistListCondVO transmitHistListCondVO)
			throws EventException {
		RocsTransmitHistListCondVO rocsTransmitHistListCondVO = (RocsTransmitHistListCondVO) transmitHistListCondVO;

		try {
			return dbDao.searchRocsSendHistByBl(rocsTransmitHistListCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rotterdam세관에서 받은 Sent/Receive 현황정보를 가져온다.
	 * 
	 * @param receiveLogCondVO ReceiveLogCondVO
	 * @return List<ReceiveLogVO>
	 * @exception EventException
	 */
	public List<ReceiveLogVO> searchReceiveLog(ReceiveLogCondVO receiveLogCondVO) throws EventException {
		RocsReceiveLogCondVO rocsReceiveLogCondVO = (RocsReceiveLogCondVO) receiveLogCondVO;

		try {
			return dbDao.searchRocsReceiveLog(rocsReceiveLogCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_1135 : SEARCH <br>
	 * ROCS 의 CRN List 화면에서 Lane 을 조회한다.<br>
	 * 
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchRocsLane() throws EventException {
		try
		{
			return dbDao.searchRocsLane();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_BKG_1135 : MULTI <br>
	 * ROCS 의 CRN List 화면에서 Lane 정보 수정<br>
	 * 
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRocsLane(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs, SignOnUserAccount account) throws EventException {
		try {
			
			BookingUtil command = new BookingUtil();
			for ( int i=0 ; i<bkgHrdCdgCtntVOs.length ; i++ )
			{
				bkgHrdCdgCtntVOs[i].setHrdCdgId("ROCS_CSTMS_SLAN_CD");
				bkgHrdCdgCtntVOs[i].setCreUsrId(account.getUsr_id());
				bkgHrdCdgCtntVOs[i].setUpdUsrId(account.getUsr_id());
				bkgHrdCdgCtntVOs[i].setAttrCtnt2("A");
			}
			command.manageHardCoding(bkgHrdCdgCtntVOs);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 VVD 존재 여부를 확인한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVvdInfo(ManifestListCondVO manifestListCondVO) throws EventException{
		RocsManifestListCondVO rocsManifestListCondVO = (RocsManifestListCondVO) manifestListCondVO;
		
		try {
			return dbDao.searchVvdInfo(rocsManifestListCondVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ROCS(ROTTERDAM) - CRN Creation & Management (POD Calling Seq, Turn VVD 로직 적용) 2015.04.20
	 * @param CrnVO crnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCrnWithCallSeq(CrnVO crnVO, SignOnUserAccount account) throws EventException{
		RocscrnVO rocscrnVO = (RocscrnVO) crnVO;
		
		String resultVal ="";
		
		RocsManifestListCondVO rocsVVDCondVO =  new RocsManifestListCondVO();
		RocsManifestListCondVO rocsTurnCondVO = new RocsManifestListCondVO();
		RocsManifestListCondVO rocsTurnCrnCondVO = new RocsManifestListCondVO();
		RocsManifestListCondVO rocsCrnCondVO = new RocsManifestListCondVO();
		
		List<VesselVO> inVVDVesselVOs = null;
		List<VesselVO> turnExistVesselVOs = null;
		List<VesselVO> crnTurnVesselVOs = null;
		List<VesselVO> inCrnVesselVOs = null;
		
		RocsSearchVslInfoVO rocsSearchVslInfoVO = new RocsSearchVslInfoVO();
		
		String turnSkdVoyNo = "";
		
		try{
			//check 1. Does the VVD have CRN No. in the RTM VSL?
			rocsVVDCondVO.setVslCd(rocscrnVO.getVslCd());
			rocsVVDCondVO.setSkdVoyNo(rocscrnVO.getSkdVoyNo());
			rocsVVDCondVO.setSkdDirCd(rocscrnVO.getSkdDirCd());
			rocsVVDCondVO.setPodClptIndSeq(rocscrnVO.getPodClptIndSeq());
			
			inVVDVesselVOs = dbDao.searchCRNExist(rocsVVDCondVO);
			
			if(inVVDVesselVOs.size() > 0 ){
				// check 1. => Y
				// check 2. Is input CRN No. same as searched CRN No.?
				if(rocscrnVO.getCrnNumber().equals( ((RocsSearchVslInfoVO) inVVDVesselVOs.get(0)).getVslCallRefNo())){
					// update
					dbDao.modifyCrnInfoWithCallSeq(rocscrnVO, account);
					resultVal = "SUCCESS&UPDATE";
					
				}else{
					// error : VVD로 CRN 정보가 이미 존재하고 있습니다 !!
					String val =  ((RocsSearchVslInfoVO) inVVDVesselVOs.get(0)).getVslCallRefNo() ;
					resultVal = "BKG06160" + "&" + val; 
	
				}
				
			}else if(inVVDVesselVOs.size() == 0) {
				// check 1 . RTM VSL 테이블에 데이터가 존재하지 않음
				// check 3. 입력된 CRN에 이미 존재하는 번호인지 확인하기
				rocsCrnCondVO.setCrnNumber(rocscrnVO.getCrnNumber());
				
				inCrnVesselVOs = dbDao.searchCRNExist(rocsCrnCondVO);
				
				// check 4. Turn VVD 존재 여부
				rocsTurnCondVO.setVslCd(rocscrnVO.getVslCd());
				rocsTurnCondVO.setSkdVoyNo(rocscrnVO.getSkdVoyNo());
				rocsTurnCondVO.setSkdDirCd(rocscrnVO.getSkdDirCd());
				rocsTurnCondVO.setPodClptIndSeq(rocscrnVO.getPodClptIndSeq());
				
				turnExistVesselVOs = dbDao.searchTurnVVDInfo(rocsTurnCondVO);
				
				rocsSearchVslInfoVO = (RocsSearchVslInfoVO) turnExistVesselVOs.get(0);
				
				turnSkdVoyNo = rocsSearchVslInfoVO.getTurnSkdVoyNo();
				
				if (!turnSkdVoyNo.equals("") && turnSkdVoyNo != null){
					// check 4. => Turn VVD 존재  = Y
					// check 4-1. Turn VVD 의 CRN 존재 여부 확인하기
					//rocsTurnVslInfoVO = (RocsSearchVslInfoVO) turnExistVesselVOs.get(0);
					
					rocsTurnCrnCondVO.setVslCd(rocsSearchVslInfoVO.getVslCd());
					rocsTurnCrnCondVO.setSkdVoyNo(rocsSearchVslInfoVO.getTurnSkdVoyNo());
					rocsTurnCrnCondVO.setSkdDirCd(rocsSearchVslInfoVO.getTurnSkdDirCd());
					rocsTurnCrnCondVO.setPodClptIndSeq(rocsSearchVslInfoVO.getTurnClptIndSeq());
					
					crnTurnVesselVOs = dbDao.searchCRNExist(rocsTurnCrnCondVO);
					
					if(crnTurnVesselVOs.size() > 0){
						// check 4-1. => Turn VVD 의 CRN 존재  Y
						//  check 5. Turn VVD의 CRN이 입력된 CRN과 동일한가?
						if(rocscrnVO.getCrnNumber().equals( ((RocsSearchVslInfoVO)crnTurnVesselVOs.get(0)).getVslCallRefNo() )){
							//insert
							
							rocscrnVO.setCstmsDeclUserId(account.getUsr_id());
							rocscrnVO.setuserOfcCd(account.getOfc_cd());
							
							dbDao.addCrnWithCallSeq(rocscrnVO); 
							resultVal = "SUCCESS&INSERT" ;
							
						}else{
							// error message : Pleas enter the same CRN no. (Turn VVD와 같은 CRN NO를 입력하시오.)
							String val =  rocsSearchVslInfoVO.getVslCd()
										+ rocsSearchVslInfoVO.getTurnSkdVoyNo()
										+ rocsSearchVslInfoVO.getTurnSkdDirCd();
							
							resultVal = "BKG06161" + "&" + val; 
						}
					}else{
						// check 4-1. => Turn VVD 의 CRN 존재 : N
						// check 6. 해당 CRN으로 rtm vsl테이블에 존재하지 않는가?  
						if(inCrnVesselVOs.size()==0){
							//insert
							rocscrnVO.setCstmsDeclUserId(account.getUsr_id());
							rocscrnVO.setuserOfcCd(account.getOfc_cd());
						
							dbDao.addCrnWithCallSeq(rocscrnVO); 
							resultVal = "SUCCESS&INSERT" ;
						}else{
							// check 3-2. => The same CRN is already exisiting for a different VVD({?msg1}).\nPlease check again.
							RocsSearchVslInfoVO crnSearchVslInfoVO = new RocsSearchVslInfoVO() ;
							crnSearchVslInfoVO = (RocsSearchVslInfoVO) inCrnVesselVOs.get(0);
							
							String val =  crnSearchVslInfoVO.getVslCd()
									+ crnSearchVslInfoVO.getSkdVoyNo()
									+ crnSearchVslInfoVO.getSkdDirCd();
						
							resultVal = "BKG06142" + "&" + val; 
						}
						
					}
				}else{
					// check 4. => Turn VVD 존재 : N
					if(inCrnVesselVOs.size() >0 ){
						// check 3 => already exist CRN No.
						RocsSearchVslInfoVO crnSearchVslInfoVO = new RocsSearchVslInfoVO() ;
						crnSearchVslInfoVO = (RocsSearchVslInfoVO) inCrnVesselVOs.get(0);
						
						String val =  crnSearchVslInfoVO.getVslCd()
								+ crnSearchVslInfoVO.getSkdVoyNo()
								+ crnSearchVslInfoVO.getSkdDirCd();
					
						resultVal = "BKG06142" + "&" + val; 
					}else{
						// check 3 => Turn VVD 의 CRN 존재 : N
						//insert
						rocscrnVO.setCstmsDeclUserId(account.getUsr_id());
						rocscrnVO.setuserOfcCd(account.getOfc_cd());
						
						dbDao.addCrnWithCallSeq(rocscrnVO); 
						resultVal = "SUCCESS&INSERT" ;
					}
				}
				
			}
			
			return resultVal;
			
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
		
	}
	
	
	/**
	 * ROCS(ROTTERDAM) 세관 Manifest의 CRN No.를 update 한다 . ESM_BKG_1094
	 * @param CrnVO crnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifyCrnNoWithCallSeq(CrnVO crnVO, SignOnUserAccount account) throws EventException {
		
		RocsSearchCRNVO rocsSearchCRNVO = (RocsSearchCRNVO) crnVO;
		RocsSearchCRNVO rocsSearchTurnCRNVO = new RocsSearchCRNVO();
		
		String resultVVD = "";
		
		String blExistFlg = ""; 
		String blTurnExistFlg = "";
		String turnVVDCRN = "";
		String turnSkdVoyNo = "";	
		String VvdNewCrn = "";
		
		boolean turnVVDExistFlg = false;
		boolean turnCRNExistFlg = false;
		boolean NewCRNExistFlg = false;
		
		
		try {
			RocsManifestListCondVO rocsVVDCondVO = new RocsManifestListCondVO();
			RocsManifestListCondVO rocsCrnCondVO = new RocsManifestListCondVO();
			
			RocsManifestListCondVO rocsTurnCondVO = new RocsManifestListCondVO();
			RocsManifestListCondVO rocsTurnCrnCondVO = new RocsManifestListCondVO();
						
			List<VesselVO> VvdVesselVOs = null;
			List<VesselVO> CrnVesselVOs = null;
			List<VesselVO> turnVesselVOs = null;
			List<VesselVO> turncrnVesselVOs = null;
						
			RocsSearchVslInfoVO rocsCrnVslInfoVO = new RocsSearchVslInfoVO();
			
			RocsSearchVslInfoVO rocsTurnVslInfoVO = new RocsSearchVslInfoVO();
			RocsSearchVslInfoVO rocsTurnCrnVslInfoVO = new RocsSearchVslInfoVO();
						
			RocsSearchCRNVO rocsTurnCRNVO = new RocsSearchCRNVO();
			
			// New CRN 변수에 저장
			VvdNewCrn = rocsSearchCRNVO.getVslCallRefNoNew();
			
			// 1. Old CRN No.로 CRN 테이블에 존재하는지 확인
			rocsVVDCondVO.setVslCd(rocsSearchCRNVO.getVslCd());
			rocsVVDCondVO.setSkdVoyNo(rocsSearchCRNVO.getSkdVoyNo());
			rocsVVDCondVO.setSkdDirCd(rocsSearchCRNVO.getSkdDirCd());
			rocsVVDCondVO.setPodClptIndSeq(rocsSearchCRNVO.getPodClptIndSeq());
			rocsVVDCondVO.setCrnNumber(rocsSearchCRNVO.getVslCallRefNoOld());
					
			VvdVesselVOs = dbDao.searchCRNExist(rocsVVDCondVO);
			
			if(VvdVesselVOs.size() == 1){
				// 2. New CRN No. 가 이미 존재하고 있는가?
				rocsCrnCondVO.setCrnNumber(rocsSearchCRNVO.getVslCallRefNoNew());
				
				CrnVesselVOs = dbDao.searchCRNExist(rocsCrnCondVO);
				
				/////////////////////////////////////////////////////////////////
				// 3. Turn VVD의 존재여부 확인
				rocsTurnCondVO.setVslCd(rocsSearchCRNVO.getVslCd());
				rocsTurnCondVO.setSkdVoyNo(rocsSearchCRNVO.getSkdVoyNo());
				rocsTurnCondVO.setSkdDirCd(rocsSearchCRNVO.getSkdDirCd());
				rocsTurnCondVO.setPodClptIndSeq(rocsSearchCRNVO.getPodClptIndSeq());
				
				turnVesselVOs = dbDao.searchTurnVVDInfo(rocsTurnCondVO);
				
				if(turnVesselVOs.size() > 0){
					rocsTurnVslInfoVO = (RocsSearchVslInfoVO)turnVesselVOs.get(0);
					
					turnSkdVoyNo = rocsTurnVslInfoVO.getTurnSkdVoyNo();
						
					// turn VVD가 존재한다
					if(!turnSkdVoyNo.equals("") && turnSkdVoyNo != null){
						
						// turn VVD로 setting
						rocsTurnCrnCondVO.setVslCd(rocsTurnVslInfoVO.getVslCd());
						rocsTurnCrnCondVO.setSkdVoyNo(rocsTurnVslInfoVO.getTurnSkdVoyNo());
						rocsTurnCrnCondVO.setSkdDirCd(rocsTurnVslInfoVO.getTurnSkdDirCd());
						rocsTurnCrnCondVO.setPodClptIndSeq(rocsTurnVslInfoVO.getTurnClptIndSeq());
						
						// 4. Turn VVD 에 대한 CRN 존재여부 확인
						turncrnVesselVOs = dbDao.searchCRNExist(rocsTurnCrnCondVO);
						
						if(turncrnVesselVOs.size() > 0){
							turnVVDExistFlg = true;
							turnCRNExistFlg = true;
						}else{
							turnVVDExistFlg = true;
							turnCRNExistFlg = false;
						}
					}else{
						turnVVDExistFlg = false;
						turnCRNExistFlg = false;
					}
				}else{
					turnVVDExistFlg = false;
					turnCRNExistFlg = false;
				}
				////////////////////////////////////////////////////////////////////////////
				
				if (CrnVesselVOs.size() == 0){
					// 2. N => New CRN No.으로 변경
					dbDao.modifyCrnNoWithCallSeq(rocsSearchCRNVO, account.getUsr_id());
					// 입력된 VVD에 대해서 BL 다운로드가 되었는지 check
					blExistFlg = ((RocsSearchVslInfoVO) VvdVesselVOs.get(0)).getVslCallRefStsCd();
					
					// 3. Turn VVD의 존재여부 확인
					if(turnVVDExistFlg){
						
						// 4. Turn VVD의 CRN존재 여부 확인
						if(turnCRNExistFlg){
							rocsTurnCrnVslInfoVO = (RocsSearchVslInfoVO) turncrnVesselVOs.get(0);
							// Turn VVD로 BL이 다룬로드 되었는지 check
							blTurnExistFlg = rocsTurnCrnVslInfoVO.getVslCallRefStsCd();
							turnVVDCRN = rocsTurnCrnVslInfoVO.getVslCallRefNo();
							
							rocsTurnCRNVO.setVslCd(rocsTurnCrnVslInfoVO.getVslCd());
							rocsTurnCRNVO.setSkdVoyNo(rocsTurnCrnVslInfoVO.getSkdVoyNo());
							rocsTurnCRNVO.setSkdDirCd(rocsTurnCrnVslInfoVO.getSkdDirCd());
							rocsTurnCRNVO.setPodClptIndSeq(rocsTurnCrnVslInfoVO.getPodClptIndSeq());
							rocsTurnCRNVO.setVslCallRefNoOld(rocsTurnCrnVslInfoVO.getVslCallRefNo());
							
							rocsTurnCRNVO.setVslCallRefNoNew(rocsSearchCRNVO.getVslCallRefNoNew());
							
							// Turn VVD 의 CRN NO. update
							dbDao.modifyCrnNoWithCallSeq(rocsTurnCRNVO, account.getUsr_id());
							
							resultVVD = "EXIST&" + rocsTurnVslInfoVO.getVslCd() + rocsTurnVslInfoVO.getTurnSkdVoyNo()
									+ rocsTurnVslInfoVO.getTurnSkdDirCd() + "&" + rocsTurnVslInfoVO.getTurnClptIndSeq();
						}else{
							resultVVD = "SUCCESS&NOTURNCRN&";
						}
					}else{
						resultVVD = "SUCCESS&NOTURNVVD&";
					}
					
					// BL이 다운로드 되어 있다면 BL,CNRT, CM 정보의 CRN NO. update
					if(blExistFlg.equals("Y")){
						dbDao.modifyCrnNoForBl(rocsSearchCRNVO, account.getUsr_id());
						dbDao.modifyCrnNoForCntr(rocsSearchCRNVO, account.getUsr_id());
						dbDao.modifyCrnNoForCm(rocsSearchCRNVO, account.getUsr_id());
					}
					
					if(blTurnExistFlg.equals("Y")){
						rocsSearchTurnCRNVO.setVslCallRefNoNew(rocsSearchCRNVO.getVslCallRefNoNew());
						rocsSearchTurnCRNVO.setVslCallRefNoOld(turnVVDCRN);

						dbDao.modifyCrnNoForBl(rocsSearchTurnCRNVO, account.getUsr_id());
						dbDao.modifyCrnNoForCntr(rocsSearchTurnCRNVO, account.getUsr_id());
						dbDao.modifyCrnNoForCm(rocsSearchTurnCRNVO, account.getUsr_id());
					}
					
				}else{
					// 2. Y => New CRN이 이미 존재하고 있다.
					// 3. Turn VVD 존재 여부 확인
					if(turnVVDExistFlg){
						
						if(turnCRNExistFlg){
							
							rocsTurnCrnVslInfoVO = (RocsSearchVslInfoVO) turncrnVesselVOs.get(0);
							
							// turn VVD의 CRN과 New CRN이 동일한가? => update CRN
							if(rocsTurnCrnVslInfoVO.getVslCallRefNo().equals(VvdNewCrn)){
								
								// Update CRN
								dbDao.modifyCrnNoWithCallSeq(rocsSearchCRNVO, account.getUsr_id());
								// 입력된 VVD에 대해서 BL 다운로드가 되었는지 check
								blExistFlg = ((RocsSearchVslInfoVO) VvdVesselVOs.get(0)).getVslCallRefStsCd();
								
								if(blExistFlg.equals("Y") ){
									
									dbDao.modifyCrnNoForBl(rocsSearchCRNVO, account.getUsr_id());
									dbDao.modifyCrnNoForCntr(rocsSearchCRNVO, account.getUsr_id());
									dbDao.modifyCrnNoForCm(rocsSearchCRNVO, account.getUsr_id());
								}
								NewCRNExistFlg = false;
								
							}else{
								NewCRNExistFlg = true;
							}
								
						}else{
							NewCRNExistFlg = true;
						}
					}else{
						NewCRNExistFlg = true;
					}
					
					if(NewCRNExistFlg){
						
						//3. N => Turn VVD 가 존재하지 않는다 & New CRN이 이미 존재하고 있다 =>Error
						rocsCrnVslInfoVO = (RocsSearchVslInfoVO) CrnVesselVOs.get(0);
						
						String errVvd = rocsCrnVslInfoVO.getVslCd()
									+ rocsCrnVslInfoVO.getSkdVoyNo()
									+ rocsCrnVslInfoVO.getSkdDirCd()
									+ rocsCrnVslInfoVO.getPodClptIndSeq();
									
						//The New CRN is already exisiting for a different VVD (?msg1). Please check again.
						resultVVD = "ERROR&BKG06165&"+ errVvd;
					}else{
						resultVVD ="SUCCESS&UPDATE&";
					}
				}
				
				/*if (CrnVesselVOs.size() == 0){
					// 2=> New CRN No.으로 변경 가능하다.
					// 3. 입력된 VVD의 CRN No. update
					dbDao.modifyCrnNoWithCallSeq(rocsSearchCRNVO, account.getUsr_id());
					
					blExistFlg = ((RocsSearchVslInfoVO) VvdVesselVOs.get(0)).getVslCallRefStsCd() ;
					
					// Start Update for Turn VVD
					// 4. Turn VVD의 존재여부 확인
					rocsTurnCondVO.setVslCd(rocsSearchCRNVO.getVslCd());
					rocsTurnCondVO.setSkdVoyNo(rocsSearchCRNVO.getSkdVoyNo());
					rocsTurnCondVO.setSkdDirCd(rocsSearchCRNVO.getSkdDirCd());
					rocsTurnCondVO.setPodClptIndSeq(rocsSearchCRNVO.getPodClptIndSeq());
					
					turnVesselVOs = dbDao.searchTurnVVDInfo(rocsTurnCondVO);
					
					if(turnVesselVOs.size() > 0){
						
						rocsTurnVslInfoVO = (RocsSearchVslInfoVO)turnVesselVOs.get(0);
						// turn VVD로 setting
						rocsTurnCrnCondVO.setVslCd(rocsTurnVslInfoVO.getVslCd());
						rocsTurnCrnCondVO.setSkdVoyNo(rocsTurnVslInfoVO.getTurnSkdVoyNo());
						rocsTurnCrnCondVO.setSkdDirCd(rocsTurnVslInfoVO.getTurnSkdDirCd());
						rocsTurnCrnCondVO.setPodClptIndSeq(rocsTurnVslInfoVO.getTurnClptIndSeq());
						
						// 5. Turn VVD 에 대한 CRN 존재여부 확인
						turncrnVesselVOs = dbDao.searchCRNExist(rocsTurnCrnCondVO);
						
						if(turncrnVesselVOs.size() > 0){
							
							rocsTurnCrnVslInfoVO = (RocsSearchVslInfoVO) turncrnVesselVOs.get(0);
							
							blTurnExistFlg = rocsTurnCrnVslInfoVO.getVslCallRefStsCd();
							
							rocsTurnCRNVO.setVslCd(rocsTurnCrnVslInfoVO.getVslCd());
							rocsTurnCRNVO.setSkdVoyNo(rocsTurnCrnVslInfoVO.getSkdVoyNo());
							rocsTurnCRNVO.setSkdDirCd(rocsTurnCrnVslInfoVO.getSkdDirCd());
							rocsTurnCRNVO.setPodClptIndSeq(rocsTurnCrnVslInfoVO.getPodClptIndSeq());
							
							rocsTurnCRNVO.setVslCallRefNoOld(rocsSearchCRNVO.getVslCallRefNoOld());
							rocsTurnCRNVO.setVslCallRefNoNew(rocsSearchCRNVO.getVslCallRefNoNew());
							
							// Turn VVD 의 CRN NO. update
							dbDao.modifyCrnNoWithCallSeq(rocsTurnCRNVO, account.getUsr_id());
							
							resultVVD = "EXIST&" + rocsTurnVslInfoVO.getVslCd() + rocsTurnVslInfoVO.getTurnSkdVoyNo()
									+ rocsTurnVslInfoVO.getTurnSkdDirCd() + "&" + rocsTurnVslInfoVO.getTurnClptIndSeq();
						}else{
							resultVVD = "NOT&TURNCRN&";
						}
						
					}else{
						resultVVD = "NOT&TURNVVD&";
					}
					
					// End  Update for Turn VVD
					
					
					// BL이 다운로드 되어 있다면 BL,CNRT, CM 정보의 CRN NO. update
					if(blExistFlg.equals("Y") || blTurnExistFlg.equals("Y") ){
						
						dbDao.modifyCrnNoForBl(rocsSearchCRNVO, account.getUsr_id());
						dbDao.modifyCrnNoForCntr(rocsSearchCRNVO, account.getUsr_id());
						dbDao.modifyCrnNoForCm(rocsSearchCRNVO, account.getUsr_id());
					}
					
				}else{
					rocsCrnVslInfoVO = (RocsSearchVslInfoVO) CrnVesselVOs.get(0);
					
					String errVvd = rocsCrnVslInfoVO.getVslCd()
								+ rocsCrnVslInfoVO.getSkdVoyNo()
								+ rocsCrnVslInfoVO.getSkdDirCd();
					
					//The New CRN is already exisiting for a different VVD (?msg1). Please check again.
					resultVVD = "ERROR&BKG06165&"+ errVvd;
				}*/
				
				
			}else{
				// 입력된 VVD와 CRN으로 데이터를 조회 했을 때 결과값이 없을 경우
				// Please, Check CRN No !
				resultVVD = "ERROR&BKG00608"; 
			}
			
			return resultVVD;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}	
	
}
