/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ManifestListDownloadBCImpl.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.09.04 변종건 [CHM-201219976-01] Split 01-Canada A/N 수정 요청
 * 2013.06.10 김보배 [CHM-201324023] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration.CndManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfDtlListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselArrivalInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.HusBlInpChkCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.HusBlInpChkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AvcNoteSetUpInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsCndVslVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0016EventResponse,ManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CndManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient CndManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManifestListDownloadBCImpl 객체 생성<br>
	 * ManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public CndManifestListDownloadBCImpl() {
		dbDao = new CndManifestListDownloadDBDAO();
	}
	
	
	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * 
	 * @param manifestListCondVO 조건
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try
		{
			CndCstmsMfListCondVO condVO = (CndCstmsMfListCondVO) manifestListCondVO;
			if ("sheet0".equals(condVO.getSheetId()))
			{
				if (dbDao.checkIfCCNAval(condVO.getVslCd(), condVO.getSkdVoyNo(), condVO.getSkdDirCd()))
				{
					return dbDao.searchCndCstmsMfList(condVO);
				} else {
					throw new EventException(new ErrorHandler("BKG00569").getMessage());
				}
			}
			else if ("sheet2".equals(condVO.getSheetId()))
			{
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
				return dbDao.searchCndCstmsMfDtlList(dtlCondVO);
			}
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			if (ex.getMessage().indexOf("BKG00569") > -1  ) {
				throw new EventException(new ErrorHandler("BKG00569", new String[] {}).getMessage(), ex);
			} else {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}
		}
		return null;
	}

	/**
	 * Bkg_Cstms_Adv_Bl 의 mf_sts_cd = 'D'로 수정
	 * 
	 * @param manifestListDetailVOs ManifestList정보
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account)
			throws EventException {
		String sResult = "";
		try
		{
			if ("ESM_BKG_0210".equals(manifestListDetailVOs[0].getPgmNo()))
			{
				CndManifestListDownloadBackEndJob cndBackEndJob = new CndManifestListDownloadBackEndJob();
				cndBackEndJob.setManifestListDetailVO(manifestListDetailVOs, account, dbDao);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				sResult = backEndJobManager.execute(cndBackEndJob, account.getUsr_id(), "Canada Data Download");
			}
			else if ("ESM_BKG_0028".equals(manifestListDetailVOs[0].getPgmNo()))
			{
				/******************************************************* 
				 * AI의 Download의 경우 BackEndJob을 사용하지 않아도 됨.
				 * 단지 같은 로직이기 때문에 manageManifest 메소드를 사용
				 *******************************************************/
				CndManifestListDownloadBackEndJob cndBackEndJob = new CndManifestListDownloadBackEndJob();
				cndBackEndJob.setManifestListDetailVO(manifestListDetailVOs, account, dbDao);
				return cndBackEndJob.manageManifest();
			}
			else if ("ESM_BKG_0568".equals(manifestListDetailVOs[0].getPgmNo()))
			{
				/******************************************************* 
				 * Inbound - C/A Report(I/B) 화면에서 다운로드 호출 시
				 *******************************************************/
				CndManifestListDownloadBackEndJob cndBackEndJob = new CndManifestListDownloadBackEndJob();
				cndBackEndJob.setManifestListDetailVO(manifestListDetailVOs, account, dbDao);
				return cndBackEndJob.manageManifest();
			}
			else if ("Terminal_Trans".equals(manifestListDetailVOs[0].getPgmNo()))
			{
				// 현재시간
				String strToDate = dbDao.searchSysdate();
				CndManifestModificationVO cndVo = (CndManifestModificationVO) manifestListDetailVOs[0];
				cndVo.setEdiSndDt(strToDate);
			}
			else
			{
				if ("ESM_BKG_0029".equals(manifestListDetailVOs[0].getPgmNo()))
				{
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
				// ESM_BKG_0028, ESM_BKG_0002, ESM_BKG_0029 에서 DA, RA의 경우 MF_STS_CD, CST,S_TRS,_STS_CD 등 변경
				List<BkgCstmsAdvBlVO> blVOs = new ArrayList<BkgCstmsAdvBlVO>();
				for (int i=0; i<manifestListDetailVOs.length; i++)
				{
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
					// 
					cndVo.setEdiSndDt(strToDate);
				}
				dbDao.modifyBkgCstmsAdvBl(blVOs);
			}
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return sResult;
	}

	/**
	 * 세관 신고용 VVD 정보 조회
	 * 
	 * @param cstmsVvdInfoCondVO 조회조건
	 * @return List<CstmsVvdInfoVO>
	 * @throws EventException
	 */
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsVvdInfo((CndCstmsVvdInfoCondVO)cstmsVvdInfoCondVO);
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
	 * 세관 관련 VVD 정보 생성, 수정, 삭제
	 * 
	 * @param cstmsVvdInfoVOs VVD 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageCstmsVvdInfo(CstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException {
		try
		{
			List<BkgCstmsCndVslVO> addVoList = new ArrayList<BkgCstmsCndVslVO>();
			for (int i = 0; i < cstmsVvdInfoVOs.length; i++)
			{
				List<BkgCstmsCndVslVO> chkVoList = new ArrayList<BkgCstmsCndVslVO>();
				BkgCstmsCndVslVO vslVO = new BkgCstmsCndVslVO();
				vslVO.setIbflag("0013");
				vslVO.setVslCd(cstmsVvdInfoVOs[i].getVslCd());
				vslVO.setSkdVoyNo(cstmsVvdInfoVOs[i].getSkdVoyNo());
				vslVO.setSkdDirCd(cstmsVvdInfoVOs[i].getSkdDirCd());
				vslVO.setCvyRefNo(cstmsVvdInfoVOs[i].getCvyRefNo());
				vslVO.setUpdUsrId(account.getUsr_id());
				// 중복 CRN체크를 위해 에러메시지 3번 인덱스를 위해 잠시 세팅
				vslVO.setAckDt(cstmsVvdInfoVOs[i].getCrrCd());
				addVoList.add(vslVO);
				chkVoList.add(vslVO);

				/****************************************************
				 * 2016.02.25 WEST CRN, EAST CRN 각각 입력할 수 있도록 함.
				 * 동일한 CRN허용 : SKD_DIR_CD만 다른경우에서 제외
				 ****************************************************/
				/*vslVO = new BkgCstmsCndVslVO();
				vslVO.setVslCd(cstmsVvdInfoVOs[i].getVslCd());
				vslVO.setSkdVoyNo(cstmsVvdInfoVOs[i].getSkdVoyNo());
				vslVO.setCvyRefNo(cstmsVvdInfoVOs[i].getCvyRefNo());
				vslVO.setUpdUsrId(account.getUsr_id());
				if ("E".equals(cstmsVvdInfoVOs[i].getSkdDirCd()))
				{
					vslVO.setSkdDirCd("W");
				}
				else if ("W".equals(cstmsVvdInfoVOs[i].getSkdDirCd()))
				{
					vslVO.setSkdDirCd("E");
				}
				// 중복 CRN체크를 위해 에러메시지 3번 인덱스를 위해 잠시 세팅
				vslVO.setAckDt(cstmsVvdInfoVOs[i].getCrrCd());
				addVoList.add(vslVO);
				chkVoList.add(vslVO);*/
				
				/****************************************************
				 * 2010.05.20 : ETA의 경우 동일한 CRN허용하는거에서 제외
				 ****************************************************/
				// 동일한 CRN허용
//				vslVO.setEtaDt(cstmsVvdInfoVOs[i].getVpsEtaDt());
				// ETA와 Vessel은 같고 VoyNo는 다른 VVD 조회
//				List<BkgCstmsCndVslVO> vslList = dbDao.searchBkgCstmsCndVsl(vslVO);
//				for (int j = 0; j < vslList.size(); j++)
//				{
//					BkgCstmsCndVslVO vsl2 = (BkgCstmsCndVslVO) vslList.get(j);
//					vsl2.setCvyRefNo(cstmsVvdInfoVOs[i].getCvyRefNo());
//					vsl2.setUpdUsrId(account.getUsr_id());
//					// 중복 CRN체크를 위해 에러메시지 3번 인덱스를 위해 잠시 세팅
//					vslVO.setAckDt(cstmsVvdInfoVOs[i].getCrrCd());
//					addVoList.add(vsl2);
//					chkVoList.add(vsl2);
//				}
				// 중복된 VVD조회
				String duplicateVvdCd = dbDao.searchDuplicateVvd(chkVoList);
				if (!"".equals(cstmsVvdInfoVOs[i].getCvyRefNo()) && !"".equals(duplicateVvdCd))
				{
					String arr[] = new String[3];
					arr[0] = cstmsVvdInfoVOs[i].getCvyRefNo();
					arr[1] = cstmsVvdInfoVOs[i].getVslCd() + cstmsVvdInfoVOs[i].getSkdVoyNo()
							+ cstmsVvdInfoVOs[i].getSkdDirCd();
					arr[2] = duplicateVvdCd;
					throw new EventException(new ErrorHandler("BKG01027", arr).getMessage());
				}
			}
			// 입력받은 데이타중 중복된 CRN체크
			// 2016.03.09 Bound 분리하여 입력할 수 있도록 함
			String vvd_cd = "";
			String crn_no = "";
			String vvd_cd2 = "";
			String crn_no2 = "";
			for (int i = 0; i < cstmsVvdInfoVOs.length; i++)
			{
				vvd_cd = cstmsVvdInfoVOs[i].getVslCd() + cstmsVvdInfoVOs[i].getSkdVoyNo();
						//+ cstmsVvdInfoVOs[i].getSkdDirCd();
				crn_no = cstmsVvdInfoVOs[i].getCvyRefNo();
				for (int j = 0; j < cstmsVvdInfoVOs.length; j++)
				{
					vvd_cd2 = cstmsVvdInfoVOs[j].getVslCd() + cstmsVvdInfoVOs[j].getSkdVoyNo();
							//+ cstmsVvdInfoVOs[j].getSkdDirCd();
					crn_no2 = cstmsVvdInfoVOs[j].getCvyRefNo();
					if (i != j && !crn_no.equals("") && !crn_no2.equals(""))
					{
						if (!vvd_cd.equals(vvd_cd2) && crn_no.equals(crn_no2))
						{
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
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 신고용 VVD별 Reference No 생성
	 * 
	 * @param cstmsVvdRefNoCondVO 조건
	 * @return CstmsVvdRefNoVO
	 * @throws EventException
	 */
	public CstmsVvdRefNoVO createCstmsVvdRefNo(CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) throws EventException {
		try
		{
			CstmsVvdRefNoVO cstmsVvdRefNoVO = new CstmsVvdRefNoVO();
			cstmsVvdRefNoVO.setNewCrn(dbDao.createCndCstmsVvdRefNo(""));
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
	 * 세관 신고용 VVD 정보 조회
	 * 
	 * @param vesselCondVO 조회조건
	 * @return List<VesselVO>
	 * @throws EventException
	 */
	public List<VesselVO> searchVessel(VesselCondVO vesselCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsVesselInfo((CndCstmsVesselInfoCondVO) vesselCondVO);
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
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * 
	 * @param vesselInfoVOs VVD정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageCstmsVesselInfo(VesselInfoVO[] vesselInfoVOs, SignOnUserAccount account) throws EventException {
		try
		{
			List<CndCstmsVesselInfoVO> modVoList = new ArrayList<CndCstmsVesselInfoVO>();
			for (int i = 0; i < vesselInfoVOs.length; i++)
			{
				CndCstmsVesselInfoVO cndVO = (CndCstmsVesselInfoVO) vesselInfoVOs[i];
				cndVO.setUpdUsrId(account.getUsr_id());
				modVoList.add(cndVO);
			}
			dbDao.modifyMdmVslCntr(modVoList);
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

	/**
	 * ETL Data 조회
	 *  
	 * @param cstmsVvdListCondVO 조회조건
	 * @return List<CstmsVvdVO>
	 * @throws EventException
	 */
	public List<CstmsVvdVO> searchCstmsVvdList(CstmsVvdListCondVO cstmsVvdListCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsVvdList(cstmsVvdListCondVO);
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
			bkgCstmsCndVslVO.setSkdVoyNo(cndVesselArrivalVO.getSkdVoyNo());
			bkgCstmsCndVslVO.setSkdDirCd(cndVesselArrivalVO.getSkdDirCd());
			bkgCstmsCndVslVO.setCapNm(cndVesselArrivalVO.getCapNm());
			if (cndVesselArrivalVO.getVpsEtaDt() != null && !"".equals(cndVesselArrivalVO.getVpsEtaDt()))
			{
				bkgCstmsCndVslVO.setEtaDt(cndVesselArrivalVO.getVpsEtaDt().replaceAll("-", ""));
			}
			else
			{
				bkgCstmsCndVslVO.setEtaDt("");
			}
			
			if (cndVesselArrivalVO.getActArrDt() != null && !"".equals(cndVesselArrivalVO.getActArrDt()))
			{
				bkgCstmsCndVslVO.setActArrDt(cndVesselArrivalVO.getActArrDt().replaceAll("-", "").replaceAll(":", ""));
			}
			else
			{
				bkgCstmsCndVslVO.setActArrDt("");
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
			bkgCstmsCndVslVO.setVslArrRptSndDt(strToDate);
			bkgCstmsCndVslVO.setIbflag(cndVesselArrivalVO.getIbflag());
			addVoList.add(bkgCstmsCndVslVO);
			// SC에서 Send Log 테이블에 넣기 위해 세팅해둠.
			cndVesselArrivalVO.setVslArrRptSndDt(strToDate);
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

	/**
	 * B/L Inquiry화면에서 세관 신고를 위해 다운로드 받은 B/L을 B/L 단위로 조회<br>
	 * 
	 * @param blCondVO 조회조건
	 * @return List<BlDetailVO>
	 * @throws EventException
	 */
	public List<BlDetailVO> inquiryBlData(BlCondVO blCondVO) throws EventException {
		try 
		{
			List<BlDetailVO> list = new ArrayList<BlDetailVO>();
			CndBlDetailVO cndBlDetailVO = searchCndCstmsBl((CndCstmsBlCondVO) blCondVO);
			if (cndBlDetailVO != null)
			{
				list.add(cndBlDetailVO);
			}
			return list;
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
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제 한다
	 * 
	 * @param cstmsBlVOs BL정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException {
		try
		{
			if ("ESM_BKG_0002".equals(cstmsBlVOs[0].getPgmNo())) {
				List<BkgCstmsAdvBlVO> blVOs = new ArrayList<BkgCstmsAdvBlVO>();
				// BL 정보 세팅
				CndCstmsBlVO cndCstmsBlVO = (CndCstmsBlVO) cstmsBlVOs[0];
				BkgCstmsAdvBlVO bl = new BkgCstmsAdvBlVO();
				bl.setCntCd(CountryCode.CA);
				bl.setBlNo(cndCstmsBlVO.getBlNo());
				bl.setMfStsCd(cndCstmsBlVO.getMfStsCd());
//				bl.setCstmsTrsmStsCd(cndCstmsBlVO.getCstmsTrsmStsCd());
				bl.setIbflag("MF_STS_CD");
				bl.setUpdUsrId(account.getUsr_id());
				blVOs.add(bl);
				dbDao.modifyBkgCstmsAdvBl(blVOs);
			} else {
				CndCstmsBlContainerVO containerVO = (CndCstmsBlContainerVO) cstmsBlVOs[0];
				CndCstmsBlMainVO mainVO = containerVO.getCndCstmsBlMainVO();
				CndCstmsBlCustVO custVO = containerVO.getCndCstmsBlCustVO();
				List<BkgCstmsAdvBlVO> blVOs = new ArrayList<BkgCstmsAdvBlVO>();
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
				if ("1".equals(mainVO.getFullMtyCd()))
				{
					bl.setFullMtyCd("M");
				}
				else
				{
					bl.setFullMtyCd("F");
				}
				if (bl.getBlNo().startsWith("DUMM"))
				{
					bl.setVslCd(mainVO.getVvdCd().substring(0, 4));
					bl.setSkdVoyNo(mainVO.getVvdCd().substring(4, 8));
					bl.setSkdDirCd(mainVO.getVvdCd().substring(8));
					bl.setPodCd(mainVO.getPodCd());
					bl.setPolCd(mainVO.getPolCd());
					bl.setPorCd(mainVO.getPorCd());
					bl.setCstmsFileTpCd(mainVO.getCstmsFileTpCd());
				}
				if (custVO == null)
				{
					// Delete 또는 Reactivate의 경우 customer정보는 세팅하지 않고 BL의 Status Code만
					// 세팅한다.
					bl.setMfStsCd(mainVO.getMfStsCd());
				}
				else
				{
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
				if (custVOs.size() > 0)
				{
					dbDao.modifyBkgCstmsAdvCust(custVOs);
				}
			}
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
		try
		{
			return dbDao.searchHubInfo(podCd, delCd, podNodCd);
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
	 * AnType 변경
	 * 
	 * @param avcNoteSetUpInfoVOs An Type 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageAvcNoteSetUpInfo(AvcNoteSetUpInfoVO[] avcNoteSetUpInfoVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			List<BkgCstmsAdvBlVO> blModVoList = new ArrayList<BkgCstmsAdvBlVO>();
//			List<BkgCstmsAdvCustVO> custModVoList = new ArrayList<BkgCstmsAdvCustVO>();
			List<BkgCstmsAdvCntrVO> cntrModVoList = new ArrayList<BkgCstmsAdvCntrVO>();
			
			for (int i = 0; i < avcNoteSetUpInfoVOs.length; i++)
			{
				// BL 수정
				BkgCstmsAdvBlVO blVO = new BkgCstmsAdvBlVO();
				blVO.setCntCd(CountryCode.CA);
				blVO.setBlNo(avcNoteSetUpInfoVOs[i].getBlNo());
				blVO.setIbdLocGdsDesc(avcNoteSetUpInfoVOs[i].getIbdLocGdsDesc());
				blVO.setAvcNoteTpId(avcNoteSetUpInfoVOs[i].getAvcNoteTpId());
				blVO.setUpdUsrId(account.getUsr_id());
				// 다른화면에서 BL정보수정하는거와 다르게 하기위해
				blVO.setIbflag("AvcNoteSetUp");
				blModVoList.add(blVO);

				// Customer 수정
//				if (avcNoteSetUpInfoVOs[i].getCustSeq() != null && avcNoteSetUpInfoVOs[i].getCustSeq().length() == 8)
//				{
//					BkgCstmsAdvCustVO custVO = new BkgCstmsAdvCustVO();
//					custVO.setCntCd(CountryCode.CA);
//					custVO.setBlNo(avcNoteSetUpInfoVOs[i].getBlNo());
//					custVO.setBkgCustTpCd(avcNoteSetUpInfoVOs[i].getBkgCustTpCd());
//					custVO.setCustCntCd(avcNoteSetUpInfoVOs[i].getCustSeq().substring(0, 2));
//					custVO.setCustSeq(avcNoteSetUpInfoVOs[i].getCustSeq().substring(2));
//					custVO.setUpdUsrId(account.getUsr_id());
//					custVO.setIbflag("ESM_BKG_0025");
//					custModVoList.add(custVO);
//				}

				// Container 수정
				if (avcNoteSetUpInfoVOs[i].getPMibNo() != null && avcNoteSetUpInfoVOs[i].getPMibNo().length() > 0)
				{
					BkgCstmsAdvCntrVO cntrVO = new BkgCstmsAdvCntrVO();
					cntrVO.setCntCd(CountryCode.CA);
					cntrVO.setBlNo(avcNoteSetUpInfoVOs[i].getBlNo());
					cntrVO.setCntrNo(avcNoteSetUpInfoVOs[i].getCntrNo());
					cntrVO.setUsaIbTrspNo(avcNoteSetUpInfoVOs[i].getPMibNo());
					cntrVO.setUpdUsrId(account.getUsr_id());
					cntrVO.setIbflag("ESM_BKG_0025");
					cntrModVoList.add(cntrVO);
				}
			}
			dbDao.modifyBkgCstmsAdvBl(blModVoList);
//			dbDao.modifyBkgCstmsAdvCust(custModVoList);
//			dbDao.modifyBkgCstmsAdvCntr(cntrModVoList);
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

	/**
	 * 수신메시지 저장
	 *  
	 * @param cstmsRcvLogVO 수신메시지
	 * @return CndCstmsRcvLogVO
	 * @throws EventException
	 */
	public CstmsRcvLogVO loadCstmsRcvMsg(CstmsRcvLogVO cstmsRcvLogVO) throws EventException {

		CndCstmsRcvLogVO cndCstmsRcvLogVO = (CndCstmsRcvLogVO)cstmsRcvLogVO;

		try
		{
			BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs().get(0);
			if (dbDao.searchCndCstmsBlByKey(bkgCstmsAdvRcvLogVO.getCstmsBatNo()))
			{
				List<BkgCstmsAdvBlVO> bkgCstmsAdvBlVOs = new ArrayList<BkgCstmsAdvBlVO>();
				BkgCstmsAdvBlVO bkgCstmsAdvBlVO = new BkgCstmsAdvBlVO();
				bkgCstmsAdvBlVO.setCntCd(CountryCode.CA);
				bkgCstmsAdvBlVO.setCstmsAckKeyNo(bkgCstmsAdvRcvLogVO.getCstmsBatNo());
				bkgCstmsAdvBlVO.setUpdUsrId(bkgCstmsAdvRcvLogVO.getCreUsrId());
				bkgCstmsAdvBlVO.setCstmsAckRcvRsltCd(bkgCstmsAdvRcvLogVO.getCndAckRcvId());
				bkgCstmsAdvBlVO.setCstmsAckProcRsltCd(bkgCstmsAdvRcvLogVO.getCndAckSubCd());
				bkgCstmsAdvBlVO.setCstmsAckRjctCd(bkgCstmsAdvRcvLogVO.getCstmsRjctMsg());
				bkgCstmsAdvBlVO.setCstmsAckRjctMsg(bkgCstmsAdvRcvLogVO.getCndAckErrNoteDesc());
				bkgCstmsAdvBlVO.setCstmsAckRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
				bkgCstmsAdvBlVOs.add(bkgCstmsAdvBlVO);
				dbDao.modifyBkgCstmsAdvBl(bkgCstmsAdvBlVOs);
			}
			else if (dbDao.searchCndCstmsVvdByKey(bkgCstmsAdvRcvLogVO.getCstmsBatNo()))
			{
				List<BkgCstmsCndVslVO> bkgCstmsCndVslVOs = new ArrayList<BkgCstmsCndVslVO>();
				BkgCstmsCndVslVO bkgCstmsCndVslVO = new BkgCstmsCndVslVO();
				bkgCstmsCndVslVO.setCndAckCtrlNo(bkgCstmsAdvRcvLogVO.getCstmsBatNo());
				bkgCstmsCndVslVO.setUpdUsrId(bkgCstmsAdvRcvLogVO.getCreUsrId());
				bkgCstmsCndVslVO.setCndAckRspnCd(bkgCstmsAdvRcvLogVO.getCndAckRcvId());
				bkgCstmsCndVslVO.setCndAckSubCd(bkgCstmsAdvRcvLogVO.getCndAckSubCd());
				bkgCstmsCndVslVO.setRcvErrCtnt(bkgCstmsAdvRcvLogVO.getCndAckErrNoteDesc());
				bkgCstmsCndVslVO.setAckDt(bkgCstmsAdvRcvLogVO.getRcvDt());
				bkgCstmsCndVslVO.setCstmsRjctId(bkgCstmsAdvRcvLogVO.getCstmsRjctMsg());
				bkgCstmsCndVslVOs.add(bkgCstmsCndVslVO);
				dbDao.modifyBkgCstmsCndVsl(bkgCstmsCndVslVOs);
			}

			/**********************************************
			 * Waring 이벤트 Send 
			 * 2015.03.25 Reject 추가
			 **********************************************/
			if("01".equals(bkgCstmsAdvRcvLogVO.getCndAckSubCd()) || "37".equals(bkgCstmsAdvRcvLogVO.getCndAckSubCd()) ||
					"R".equals(bkgCstmsAdvRcvLogVO.getCndAckRcvId()) ){
				List<CstmsHldVO> cstmsHldSendVOs = new ArrayList<CstmsHldVO>();
				bkgCstmsAdvRcvLogVO.setCntCd(CountryCode.CA);
				cstmsHldSendVOs.add(dbDao.searchCstmsAlertFlag(bkgCstmsAdvRcvLogVO));
								
				cndCstmsRcvLogVO.setCstmsHldSendVOs(cstmsHldSendVOs);
			}
		}
		
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		
		return cndCstmsRcvLogVO;
	}

	/**
	 * 선박별 인증서 만료일 (Certificate Expire Date) 업로드
	 * 
	 * @param vesselInfoVO 선박정보
	 * @throws EventException
	 */
	public void loadVslCertiExpDt(VesselInfoVO vesselInfoVO) throws EventException {
		try
		{
			CndCstmsVesselInfoVO cndCstmsVesselInfoVO = (CndCstmsVesselInfoVO)vesselInfoVO;
			
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId(Constants.HrdCdgId.CND_VSL_CERTI_CD);
			bkgHrdCdgCtntListCondVO.setAttrCtnt1(cndCstmsVesselInfoVO.getCertCd());
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = bkgUtil.searchHardCoding(bkgHrdCdgCtntListCondVO);

			if (bkgHrdCdgCtntVOs.size() > 0) {
				if ("SC".equals(bkgHrdCdgCtntVOs.get(0).getAttrCtnt2()))
				{
					// Safety Construction Certification(SC)
					cndCstmsVesselInfoVO.setVslSftCstruCertiExpDt(cndCstmsVesselInfoVO.getExpiryDt());
				}
				else if ("SE".equals(bkgHrdCdgCtntVOs.get(0).getAttrCtnt2()))
				{
					// Safety Equipment Certification(SE)
					cndCstmsVesselInfoVO.setVslSftEqCertiExpDt(cndCstmsVesselInfoVO.getExpiryDt());
				}
				else if ("SR".equals(bkgHrdCdgCtntVOs.get(0).getAttrCtnt2()))
				{
					// Safety Radio Certification(SR)
					cndCstmsVesselInfoVO.setVslSftRdoCertiExpDt(cndCstmsVesselInfoVO.getExpiryDt());
				}
				else if ("IL".equals(bkgHrdCdgCtntVOs.get(0).getAttrCtnt2()))
				{
					// International Load Line Certificate(ILL)
					cndCstmsVesselInfoVO.setVslLodLineCertiExpDt(cndCstmsVesselInfoVO.getExpiryDt());
				}
				else if ("DR".equals(bkgHrdCdgCtntVOs.get(0).getAttrCtnt2()))
				{
					// Sanitary Control(Deratting) Exemption Certificate
					cndCstmsVesselInfoVO.setVslDeratCertiExpDt(cndCstmsVesselInfoVO.getExpiryDt());
				}
			} else {
				throw new EventException(new ErrorHandler("BKG00629", new String[] {"Certificate Expire Date"}).getMessage());
			}
			List<CndCstmsVesselInfoVO> cndCstmsVesselInfoVOs = new ArrayList<CndCstmsVesselInfoVO>();
			cndCstmsVesselInfoVOs.add(cndCstmsVesselInfoVO);
			dbDao.modifyMdmVslCntr(cndCstmsVesselInfoVOs);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

    /**
	 * 세관신고전 House B/L의 Data의 정확성 유무를 조회
	 * 
	 * @param houseBlCondVO 조회조건
	 * @return List<HouseBlDetailVO>
	 * @throws EventException
	 */
	public List<HouseBlDetailVO> checkHouseBlDataList(HouseBlCondVO houseBlCondVO) throws EventException {
		try
		{
			List<HouseBlDetailVO> list = dbDao.searchHusBlInpChkList((HusBlInpChkCondVO) houseBlCondVO);
			if (list.size() > 0)
			{
				String strSeq = null;
				int seq = 0;
				String strBkg = "";
				int cntBkg = 0;
				int cntBl = 0;
				int cntHbl = 0;
				int cntFiler01 = 0;
				int cntFiler02 = 0;
				int cntFiler03 = 0;
				int cntFileNo = 0;
				int cntHblEtc = 0;
				int cntFileNoEtc = 0;

				HusBlInpChkVO vo = null;
				for (int i = 0; i < list.size(); i++)
				{
					vo = (HusBlInpChkVO) list.get(i);
					// Seq 셋팅
					strSeq = vo.getSeq();
					if (strSeq.equals("1"))
					{
						vo.setSeq(Integer.toString(++seq));
					}
					else
					{
						vo.setSeq(Integer.toString(seq));
					}
					// tot_bkg 카운트
					if (!strBkg.equals(vo.getBkgNo()))
					{
						++cntBkg;
						// tot_mbl 카운트
						if ("01".equals(vo.getMblFiler()))
							++cntFiler01;
						else if ("02".equals(vo.getMblFiler()))
							++cntFiler02;
						else if ("03".equals(vo.getMblFiler()))
							++cntFiler03;
					}
					strBkg = vo.getBkgNo();
					// 2010.04.23 변경 US, CA Filer에 따라 카운트 다르게..
					if ("01".equals(vo.getMblFiler()))
					{
						// tot_hbl 카운트
						if (!"".equals(vo.getHblSeq()))
							++cntHbl;
						// tot_fileno 카운트
						if ("Y".equals(vo.getHblFilenoFlg()))
							++cntFileNo;
					}
					else
					{
//						if ("01".equals(vo.getEtcFiler()))
//						{
							// "CA" 가 아닌 tot_hbl 카운트
							if (!"".equals(vo.getHblSeq()))
								++cntHblEtc;
							// "CA" 가 아닌 tot_fileno 카운트
							if ("Y".equals(vo.getHblFilenoFlg()))
								++cntFileNoEtc;
//						}
					}
				}
				vo = new HusBlInpChkVO();
				vo.setTotBkg(Integer.toString(cntBkg));
				vo.setTotMbl01(Integer.toString(cntFiler01));
				vo.setTotMbl02(Integer.toString(cntFiler02));
				vo.setTotMbl03(Integer.toString(cntFiler03));
				vo.setTotMbl(Integer.toString(cntFiler01 + cntFiler02 + cntFiler03));
				vo.setTotHbl(Integer.toString(cntHbl));
				cntBl = Integer.parseInt(vo.getTotMbl()) + Integer.parseInt(vo.getTotHbl());
				vo.setTotBl(Integer.toString(cntBl));
				vo.setTotFileno(Integer.toString(cntFileNo));
				vo.setTotHblEtc(Integer.toString(cntHblEtc));
				vo.setTotFilenoEtc(Integer.toString(cntFileNoEtc));
				list.add(0, vo);
			}
			return list;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * B/L Inquiry화면에서 세관 신고를 위해 다운로드 받은 B/L을 B/L 단위로 조회<br>
	 * 
	 * @param cndCstmsBlCondVO 조회조건
	 * @return CndCstmsBlVO
	 * @throws EventException
	 */
	private CndBlDetailVO searchCndCstmsBl(CndCstmsBlCondVO cndCstmsBlCondVO) throws DAOException {
		CndBlDetailVO blVo = new CndBlDetailVO();
		if ("1".equals(cndCstmsBlCondVO.getTabNo()))
		{
			// 첫번째 탭의 경우 BL Main과 Customer정보 조회
			blVo.setCndCstmsBlMainVO(dbDao.searchCndCstmsBlMain(cndCstmsBlCondVO.getBlNo()));
			blVo.setCndCstmsBlCustVO(dbDao.searchCndCstmsBlCust(cndCstmsBlCondVO.getBlNo()));
		}
		else if ("2".equals(cndCstmsBlCondVO.getTabNo()))
		{
			// 두번째 탭의 경우 세관 신고 전송 결과 조회
			blVo.setCndCstmsBlCstmsRsltVOs(dbDao.searchCndCstmsBlCstmsRslt(cndCstmsBlCondVO.getBlNo()));
		}
		else if ("3".equals(cndCstmsBlCondVO.getTabNo()))
		{
			// 세번째 탭의 경우 House B/L 정보 조회
			blVo.setCndCstmsBlHblListVOs(dbDao.searchCndCstmsBlHblList(cndCstmsBlCondVO.getBlNo()));
		}
		return blVo;
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



	
	
}