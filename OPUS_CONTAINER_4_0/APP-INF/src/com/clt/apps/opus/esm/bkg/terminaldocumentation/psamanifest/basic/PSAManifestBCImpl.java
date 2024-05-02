/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestBCImpl.java
*@FileTitle : PSAManifestBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier :
*@LastVersion : 1.0
* 2009. 9. 4.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration.PSAManifestDBDAO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.BkgCstmsPsaCntrChkVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.BkgDataVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.BkgVvdInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.BkgXterVgmVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.CntrNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.CntrSpeCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.ImpStsSpclCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.NameEtdVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaAddVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaAwkCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrFlatVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgForYardVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgIfVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgQtyTmpVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgQtyVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdCntrTpszVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVslVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgvvdInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrCntVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrForYardVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaHeadVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaIbManifestVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImportVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaJurongIfVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestCmInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestCntrInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestCntrSealNoInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestDgGoodsInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestMarkInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaManifestVslInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaMaxSubSrlNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaNextVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRfCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsForYardVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRoCntrQtyVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaShprVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSndDtVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSrlNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSubSrlNoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBKGVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBkgCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchCNTRVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchPsaCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaYardCdVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.file.FileMetaDataManager;
import com.clt.framework.component.util.file.ModuleMetaData;
import com.clt.framework.component.util.io.FileUtils;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsSgpSndLogVO;

/**
 * PSA Manifest 에 대한 Business 로직을 처리한다.
 *
 * @author
 * @see
 * @since J2EE 1.6
 *
 */
public class PSAManifestBCImpl extends BasicCommandSupport implements PSAManifestBC {

	private static final int DESC_CNT_LIMIT  =  175;
	private static final int DESC_CNT_LOOP_CNT  =  99;

	// Database Access Object
	private transient PSAManifestDBDAO dbDao = null;

	public PSAManifestBCImpl() {
		dbDao = new PSAManifestDBDAO();
	}

	/**
	 * BackEndJob공통 - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용) <br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException {
		String result = "";
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(backEndJobKey).getDbRowset();
			while (rowSet.next()) result = rowSet.getObject("jb_sts_flg").toString();
			return result;
		} catch(BackEndJobException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Vessel 정보 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return List<PsaVvdVO>
	 * @exception EventException
	 */
	public List<PsaVvdVO> searchPSAVslRegist(PsaVvdVO psaVvdVO) throws EventException {
		try {
			return dbDao.searchPSAVslRegist(psaVvdVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PSA Vessel Name 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPSAVslName(PsaVvdVO psaVvdVO) throws EventException {
		try {
			return dbDao.searchPSAVslName(psaVvdVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PSA Vessel 정보 수정
	 * @param PsaVvdVO[] psaVvdVOs
	 * @exception EventException
	 */
	public void managePSAVVDInfo(PsaVvdVO[] psaVvdVOs) throws EventException {
		// Grid 에서 넘어오는 객체
		PsaVvdVO psaVvdVO = null;
		// ValidCheck1
		String validCheck1 = null;
		// ValidCheck2
		String validCheck2 = null;
		// ValidCheck3
		String validCheck3 = null;

		try {

			// LOOP
			for (int i=0; i < psaVvdVOs.length; i++) {

				psaVvdVO = psaVvdVOs[i];

				// VALID CHECK
				validCheck1 = dbDao.searchVslPortSkdValidCheck(psaVvdVO.getVslCd(), psaVvdVO.getSkdVoyNo(), psaVvdVO.getSkdDirCd());
				if (validCheck1==null || validCheck1.equals("0"))
					// "INVALID VESSEL PORT SCHEDULE" 오류 처리
					throw new EventException(new ErrorHandler("BKG01120", new String[] {}).getMessage());

				// Validation Check 후 MODE 를 변경함에 따라 Else if 문을 쓰지 않고 if 문으로 처리함

				// ADD
				if (psaVvdVO.getIbflag().equals("I")) {
					// Validation Check2
					validCheck2 = dbDao.searchPSAVVDValidCheck(psaVvdVO);

					// 결과가 0이면 진행, 0보다 크면 UPDATE 로 처리
					if (validCheck2==null || validCheck2.equals("0")) {
						// INSERT
						dbDao.addPSAVVDInfo(psaVvdVO);
					} else {
						// 데이터가 존재하면 Modify 할수 있도록 mode 변경 처리
						psaVvdVO.setIbflag("U");
					}
				}

				// MODIFY
				if (psaVvdVO.getIbflag().equals("U")) {
					dbDao.modifyPSAVVDInfo(psaVvdVO);
				}

				// DELETE
				if (psaVvdVO.getIbflag().equals("D")) {
					// Send Check 후 데이터가 존재하지 않는 경우만 삭제 처리
					validCheck3 = dbDao.searchPSASendValidCheck(psaVvdVO);
					if (validCheck3==null || validCheck3.equals("0")) dbDao.removePSAVVDInfo(psaVvdVO);
				}

			}
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PSA Vessel Import Schedule 조회
	 * @param String portCd
	 * @param String etbDt1
	 * @param String etbDt2
	 * @return List<PsaVvdVO>
	 * @exception EventException
	 */
	public List<PsaVvdVO> searchPSAVVD(String portCd, String etbDt1, String etbDt2) throws EventException {
		// 조회용 객체
		PsaVvdVO condVO = new PsaVvdVO();

		try {
			condVO.setPortCd(portCd);
			condVO.setEtbDt1(etbDt1);
			condVO.setEtbDt2(etbDt2);
			return dbDao.searchPSAVVD(condVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PSA Container Booking I/F History 조회
	 * @param PsaBkgVO psaBkgVO
	 * @return PsaBkgVO[]
	 * @exception EventException
	 */
	public PsaBkgVO[] searchPSACNTRBKGHist(PsaBkgVO psaBkgVO) throws EventException {
		// 조회 결과
		PsaBkgVO[] psaBkgVOs = null;

		try {
			psaBkgVOs = dbDao.searchPSACNTRBKGHist(psaBkgVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return psaBkgVOs;
	}

	/**
	 * PSA Container Booking I/F History Log 조회
	 * @param String bkgNo
	 * @param String psaSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchPSAStatusLog(String bkgNo, String psaSeq) throws EventException {
		String statusLog = null;
		try {
			statusLog = dbDao.searchPSAStatusLog(bkgNo, psaSeq);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return statusLog;
	}

	/**
	 * EDI전송을 위해 Yard Code를 PSA Port로 Coversion을 위해 PSA Port조회
	 * @param String portCd
	 * @return PsaPortVO[]
	 * @exception EventException
	 */
	public PsaPortVO[] searchPSAPortList(String portCd) throws EventException {

		PsaPortVO[] psaPortVOs = null;

		try {
			psaPortVOs = dbDao.searchPSAPortList(portCd);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return psaPortVOs;
	}

	/**
	 * PSA Import Status I/F 조회
	 * @param PsaImpStsVO psaImpStsVO
	 * @return PsaImpStsVO
	 * @exception EventException
	 */
	public PsaImpStsVO searchPSAImpSts(PsaImpStsVO psaImpStsVO) throws EventException {
		// 처리결과를 넘길 객체
		PsaImpStsVO outVO = new PsaImpStsVO();
		// TP Count 조회
		String cnt = "0";
		// VSL Name, Dir 조회
		PsaVvdVO psaVvdVO = new PsaVvdVO();
		// List 조회
		PsaImpStsVO[] psaImpStsVOs = null;
		PsaAddVO psaAddVO = new PsaAddVO();
		// Add Container 조회 결과
		PsaImpStsVO[] addContainerVOs = null;
		// 조회결과를 담을 List
		List<PsaImpStsVO> listPsaImpStsVO = new ArrayList<PsaImpStsVO>();

		try {
			// Count 조회
			cnt = dbDao.searchPSATpCnt(psaImpStsVO);
			if (cnt == null) cnt = "0";

			// List 조회
			psaImpStsVOs = dbDao.searchPSAImpStsInfoList(psaImpStsVO);
			if (psaImpStsVOs != null) listPsaImpStsVO.addAll((List<PsaImpStsVO>)Arrays.asList(psaImpStsVOs));

			// 조회 결과 0 건이고, TP Count 가 0보다 크면 예외처리
			if ((psaImpStsVOs == null || psaImpStsVOs.length < 1) && !cnt.equals("0")) {
				outVO = new PsaImpStsVO();
			} else {
				psaAddVO.setVslCd(psaImpStsVO.getVslCd());
				psaAddVO.setSkdVoyNo(psaImpStsVO.getSkdVoyNo());
				psaAddVO.setSkdDirCd(psaImpStsVO.getSkdDirCd());
				psaAddVO.setPodCd(psaImpStsVO.getPodCd());

				// 조회 결과 건수가 0 보다 크면
				if (psaImpStsVOs != null && psaImpStsVOs.length > 0) {
					// 컨테이너 번호 목록 조회 : Container No 만큼 반복
					List<PsaImpStsVO> psaImpStsVOList = new ArrayList<PsaImpStsVO>();
/*					
					for (String cntrNO : dbDao.searchPSAAddCNTRList(psaAddVO)) {
						psaImpStsAddVO = new PsaImpStsAddVO();
						ObjectCloner.build(psaAddVO, psaImpStsAddVO);
						psaImpStsAddVO.setCntrNo(cntrNO);
						PsaImpStsVO[] tempVOs = dbDao.searchPSAImpStsInfoAddList(psaImpStsAddVO);
						if (tempVOs != null && tempVOs.length > 0) psaImpStsVOList.add(tempVOs[0]);
					}
*/
					addContainerVOs = psaImpStsVOList.toArray(new PsaImpStsVO[0]);

				} else {
					// 조회 결과 건수가 0건인 경우
					psaImpStsVO.setCntrNo(null);
					addContainerVOs = dbDao.searchPSAImpStsInfoAddList(psaImpStsVO);
					if (addContainerVOs != null && addContainerVOs.length > 0) {
						List<PsaImpStsVO> psaImpStsVOList = new ArrayList<PsaImpStsVO>();
						for (int i=0; i<addContainerVOs.length; i++) {
							if (i > 0) {
								if (addContainerVOs[i].getCntrNo().equals(addContainerVOs[i-1].getCntrNo())) continue;
							}
							psaImpStsVOList.add(addContainerVOs[i]);
						}
						addContainerVOs = psaImpStsVOList.toArray(new PsaImpStsVO[0]);
					}
				}

				// TS 판단 후 LIST에 추가
				if (addContainerVOs != null) {
					for (PsaImpStsVO PsaImpStsVO : addContainerVOs) {
						if (PsaImpStsVO == null) continue;
						// Next VVD가 비어있거나, VVD와 같으면
						if (("".equals(PsaImpStsVO.getNextVslCd()) &&
							 "".equals(PsaImpStsVO.getNextSkdVoyNo()) &&
							 "".equals(PsaImpStsVO.getNextSkdDirCd())) ||
							 (PsaImpStsVO.getVslCd().equals(PsaImpStsVO.getNextVslCd()) &&
							 PsaImpStsVO.getSkdVoyNo().equals(PsaImpStsVO.getNextSkdVoyNo()) &&
							 PsaImpStsVO.getSkdDirCd().equals(PsaImpStsVO.getNextSkdDirCd()))) {

							PsaImpStsVO.setTsTpCd("L");
						}
					}
				}
				if (addContainerVOs != null && addContainerVOs.length > 0) listPsaImpStsVO.addAll(Arrays.asList(addContainerVOs));
				// 결과 객체에 담기
				outVO.setListPsaImpStsVO(listPsaImpStsVO);
			}

			// VVD Name Dir 조회
			psaVvdVO = dbDao.searchPSAVslNameDir(psaImpStsVO.getVslCd() + psaImpStsVO.getSkdVoyNo() + psaImpStsVO.getSkdDirCd());
			outVO.setPsaVvdVO(psaVvdVO);

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return outVO;
	}

	/**
	 * ESM_BKG_0420 : Save - Back End Job 시작<br>
	 * PSA Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param PsaImpStsVO[] psaImpStsVOs
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobManagePSAImpSts(PsaImpStsVO[] psaImpStsVOs, SignOnUserAccount account, String pgmNo) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		PSAManifestBackEndJob backEndJob = new PSAManifestBackEndJob();
		try {
			backEndJob.setPsaImpStsVOs(psaImpStsVOs);
			backEndJob.setSignOnUserAccount(account);
			backEndJob.setPgmNo(pgmNo);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), pgmNo);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status I/F 추가/수정/삭제 처리
	 * @param PsaImpStsVO[] psaImpStsVOs
	 * @exception EventException
	 */
	public void managePSAImpSts(PsaImpStsVO[] psaImpStsVOs) throws EventException {
		try {
			// Vessel validation Check
			String vslCnt = dbDao.searchVslCount(psaImpStsVOs[0].getVslCd(), psaImpStsVOs[0].getSkdVoyNo(), psaImpStsVOs[0].getSkdDirCd());
			// 결과 건수가 1건 이하인 경우 예외처리
			if (vslCnt == null || vslCnt.compareTo("1") < 0) {
				throw new EventException(new ErrorHandler("BKG01122", new String[] { psaImpStsVOs[0].getVslCd()+psaImpStsVOs[0].getSkdVoyNo()+psaImpStsVOs[0].getSkdDirCd() }).getMessage());
			}

			// GRID LOOP
			for (PsaImpStsVO psaImpStsVO : psaImpStsVOs) {
				// 작업 구분에 따른 처리(I:추가 , U:수정, D:삭제)
				if (psaImpStsVO.getIbflag().equals("I")) {
					// INSERT
					dbDao.addPSAImpStsInfo(psaImpStsVO);
					dbDao.removePSAImpStsSpclInfo(psaImpStsVO);

//					if ("1".equals(psaImpStsVO.getSpc())) {    // Special일때만 저장
						// 2015-12-08 무조건 저장되도록 변경
						ImpStsSpclCgoVO searchImpStsSpclCgoVO = new ImpStsSpclCgoVO();
						ObjectCloner.build(psaImpStsVO, searchImpStsSpclCgoVO);
						ImpStsSpclCgoVO resultImpStsSpclCgoVO = dbDao.searchBKGImpStsSpclCgo(searchImpStsSpclCgoVO);
						resultImpStsSpclCgoVO.setDcgoFlg(psaImpStsVO.getDcgoFlg());
						resultImpStsSpclCgoVO.setRcFlg(psaImpStsVO.getRcFlg());
						resultImpStsSpclCgoVO.setAwkCgoFlg(psaImpStsVO.getAwkCgoFlg());
						resultImpStsSpclCgoVO.setBbCgoFlg(psaImpStsVO.getBbCgoFlg());
						resultImpStsSpclCgoVO.setRdCgoFlg(psaImpStsVO.getRdCgoFlg());
						resultImpStsSpclCgoVO.setUserId(psaImpStsVO.getUserId());
						dbDao.addPSAImpStsSpclCgo(resultImpStsSpclCgoVO);
//					}

				} else if (psaImpStsVO.getIbflag().equals("U")) {
					// UPDATE
					dbDao.modifyPSAImpStsInfo(psaImpStsVO);

					ImpStsSpclCgoVO searchImpStsSpclCgoVO = new ImpStsSpclCgoVO();
					ObjectCloner.build(psaImpStsVO, searchImpStsSpclCgoVO);
					ImpStsSpclCgoVO resultImpStsSpclCgoVO = dbDao.searchPSAImpStsSpclCgo(searchImpStsSpclCgoVO);
					if (resultImpStsSpclCgoVO != null && !"".equals(resultImpStsSpclCgoVO.getLdIns())) {
						dbDao.modifyStwgIdOfImpStsSpclCgo(psaImpStsVO);
					}

				} else if (psaImpStsVO.getIbflag().equals("D")) {
					// DELETE
					dbDao.removePSAImpStsInfo(psaImpStsVO);
					dbDao.removePSAImpStsSpclInfo(psaImpStsVO);
				}
			}// END GRID LOOP

		} catch(EventException evx) {
			throw evx;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0420 : Save - Back End Job 결과<br>
	 * PSA Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobManagePSAImpSts(String backEndJobKey) throws EventException {
		try {
			return(String) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PSA Import Status Special Cargo의 정보를 조회
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @exception EventException
	 */
	public ImpStsSpclCgoVO searchPSAImpoStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws EventException {
		// 조회 결과 객체
		ImpStsSpclCgoVO outVO = null;
		try {
			// PSA 에서 조회
			outVO = dbDao.searchPSAImpStsSpclCgo(impStsSpclCgoVO);
			// 조회 결과가 NULL 이면 BKG 에서 조회
			if (outVO == null) outVO = dbDao.searchBKGImpStsSpclCgo(impStsSpclCgoVO);
			if (outVO == null) {
				throw new EventException(new ErrorHandler("BKG00889").getMessage());
			}
		} catch(EventException evx) {
			throw evx;
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return outVO;
	}

	/**
	 * PSA Import Status Special Cargo 정보 추가/수정/삭제 처리
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @exception EventException
	 */
	public void managePSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws EventException {
		try {
			// INSERT
			if (impStsSpclCgoVO.getTypeCd().equals("I")) {
				if (dbDao.searchPKPSAImpStsSpclCgo(impStsSpclCgoVO) < 1) {
					dbDao.addPSAImpStsSpclCgo(impStsSpclCgoVO);

				} else {
					// UPDATE
					dbDao.modifyPSAImpStsSpclCgo(impStsSpclCgoVO);
					dbDao.modifyStwgIdOfImpSts(impStsSpclCgoVO);
				}

			} else if (impStsSpclCgoVO.getTypeCd().equals("D")) {
				// DELETE
				dbDao.removePSAImpStsSpclCgo(impStsSpclCgoVO);
			}
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0420 : Transmit - Back End Job 시작<br>
	 * PSA Import Status EDI 전송
	 *
	 * @param PsaImpStsVO psaImpStsVO
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobTransmitPSAImpSts(PsaImpStsVO psaImpStsVO, SignOnUserAccount account, String pgmNo) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		PSAManifestBackEndJob backEndJob = new PSAManifestBackEndJob();
		try {
			backEndJob.setPsaImpStsVO(psaImpStsVO);
			backEndJob.setSignOnUserAccount(account);
			backEndJob.setPgmNo(pgmNo);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), pgmNo);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status EDI 전송
	 * @param PsaImpStsVO psaImpStsVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitPSAImpStsInfo(PsaImpStsVO psaImpStsVO) throws EventException {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		// BOOKING UTIL
		BookingUtil bookingUtil = new BookingUtil();
		// EDI 전송용 객체
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		FlatFileAckVO flatFileAckVO = null;

		try {
			// EDI Header 조회
			String ediHeader = bookingUtil.searchCstmsEdiHeaderNew("SG_TLIIMP");
			flatFile.append(ediHeader).append("\n");

			// FlatFile Header 조회
			PsaHeadVO psaHeadVO = dbDao.searchPSAHeadFlatFile(psaImpStsVO);

			// Header 만들기
			flatFile.append("TMNL_VSL_NM:").append(psaHeadVO.getPsaVslNm()).append("\n");
			flatFile.append("TMNL_VSL_VOY_DIR:").append(psaHeadVO.getPsaVoyDirCd()).append("\n");
			flatFile.append("VSL_NM:").append(psaHeadVO.getVslEngNm()).append("\n");
			flatFile.append("VSL_VVD:").append(psaHeadVO.getVslCd() + psaHeadVO.getSkdVoyNo() + psaHeadVO.getSkdDirCd()).append("\n");

			// Container FlatFile 만들기
			for (PsaCntrVO psaCntrVO : dbDao.searchPSACNTRInfoFlatFile(psaImpStsVO)) {
				// flatFile 만들기
				flatFile.append("{CNTR_INFO").append("\n");
				flatFile.append("INS_TP:").append(psaCntrVO.getTsTpCd()).append("\n");
				flatFile.append("SND_DT:").append(psaCntrVO.getSndDt()).append("\n");
				flatFile.append("CNTR_NO:").append(psaCntrVO.getCntrNo()).append("\n");
				flatFile.append("CNTR_TPSZ:").append(psaCntrVO.getCntrTpsz()).append("\n");
				flatFile.append("BKG_NO:").append(psaCntrVO.getBkgNo()).append("\n");
				flatFile.append("BL_NO:").append(dbDao.getBlNoForFlatFile(psaCntrVO)).append("\n");
				flatFile.append("CNTR_STS:").append(psaCntrVO.getFullMtyCd()).append("\n");

				if ("V".equals(psaCntrVO.getPsaCreTpCd())) {
					List<BkgXterVgmVO> bkgXterVgmVOList = dbDao.searchBkgXterVgmInfo(psaCntrVO);
					if (bkgXterVgmVOList.size() > 0) {
						flatFile.append("DOC_ID:").append(bkgXterVgmVOList.get(0).getDocId()).append("\n");
						flatFile.append("MEAS_TP:").append(bkgXterVgmVOList.get(0).getMeasTp()).append("\n");
						flatFile.append("MEAS_DT:").append(bkgXterVgmVOList.get(0).getVgmHndlDt()).append("\n");
						//flatFile.append("WGT:").append(bkgXterVgmVOList.get(0).getXterVgmWgt().replaceAll(",","")).append("\n");
						flatFile.append("WGT:").append(psaCntrVO.getCntrWgt().replaceAll(",","")).append("\n");
						flatFile.append("DOC_TP:").append(bkgXterVgmVOList.get(0).getVgmDocTp()).append("\n");
						flatFile.append("CUST_CNTC_TP:").append(bkgXterVgmVOList.get(0).getCustCntcTp()).append("\n");
						flatFile.append("CUST_CNTC_NM:").append(bkgXterVgmVOList.get(0).getCustCntcNm()).append("\n");
					} else {
						flatFile.append("DOC_ID:").append("\n");
						flatFile.append("MEAS_TP:").append("V").append("\n");
						flatFile.append("MEAS_DT:").append("\n");
						flatFile.append("WGT:").append(psaCntrVO.getCntrWgt().replaceAll(",","")).append("\n");
						flatFile.append("DOC_TP:").append("SM2").append("\n");
						flatFile.append("CUST_CNTC_TP:").append("\n");
						flatFile.append("CUST_CNTC_NM:").append("\n");
					}
				} else {
					flatFile.append("DOC_ID:").append("\n");
					flatFile.append("MEAS_TP:").append("V").append("\n");
					flatFile.append("MEAS_DT:").append("\n");
					flatFile.append("WGT:").append(psaCntrVO.getCntrWgt().replaceAll(",","")).append("\n");
					flatFile.append("DOC_TP:").append("SM2").append("\n");
					flatFile.append("CUST_CNTC_TP:").append("\n");
					flatFile.append("CUST_CNTC_NM:").append("\n");
				}

				flatFile.append("SOC_IND:").append(psaCntrVO.getSocInd()).append("\n");
				flatFile.append("CNTR_OPR:").append(psaCntrVO.getCntrOprCd()).append("\n");
				flatFile.append("IWRD_OPR:").append(psaCntrVO.getIbSltOprCd()).append("\n");
				flatFile.append("RF_TEMP:").append(psaCntrVO.getRcTemp()).append("\n");
				flatFile.append("VENT_CMH:").append(psaCntrVO.getCbmPerHrQty()).append("\n");
				flatFile.append("DG_IND:").append(psaCntrVO.getDcgoFlg()).append("\n");
				flatFile.append("OVH:").append(psaCntrVO.getOvrDimHgt().replaceAll(",", "")).append("\n");
				flatFile.append("OVF:").append(psaCntrVO.getOvrFntDimLen().replaceAll(",", "")).append("\n");
				flatFile.append("OVB:").append(psaCntrVO.getOvrBakDimLen().replaceAll(",", "")).append("\n");
				flatFile.append("OVLW:").append(psaCntrVO.getOvrLfDimWdt().replaceAll(",", "")).append("\n");
				flatFile.append("OVRW:").append(psaCntrVO.getOvrRtDimWdt().replaceAll(",", "")).append("\n");
				flatFile.append("UMH:").append(psaCntrVO.getDimHgt().replaceAll(",","")).append("\n");
				flatFile.append("UMW:").append(psaCntrVO.getDimWdt().replaceAll(",","")).append("\n");
				flatFile.append("UML:").append(psaCntrVO.getDimLen().replaceAll(",","")).append("\n");
				flatFile.append("CGO_DESC:").append(psaCntrVO.getCgoDesc()).append("\n");
				flatFile.append("HS_CD:").append(psaCntrVO.getCmdtHsCd()).append("\n");
				flatFile.append("RS_IND:").append("\n");
				flatFile.append("CFS_TP:").append(psaCntrVO.getCfsTpCd()).append("\n");
				flatFile.append("DEPOT_SVC:").append(psaCntrVO.getDptSvcTpCd()).append("\n");
				flatFile.append("PTI_TP:").append(psaCntrVO.getRfCntrPreTrdInspTpCd()).append("\n");
				flatFile.append("SPCL_INS:").append(psaCntrVO.getStwgTpCd()).append("\n");
				flatFile.append("OWRD_OPR:").append(psaCntrVO.getObSltOprCd()).append("\n");
				flatFile.append("BATCH_NBR:").append(psaCntrVO.getPsaBatNo()).append("\n");
				if (psaCntrVO.getCneeNm().toUpperCase().indexOf("ORDER ") > -1) {
					flatFile.append("CNEE:").append(psaCntrVO.getNtfyNm()).append("\n");
				} else {
					flatFile.append("CNEE:").append(psaCntrVO.getCneeNm()).append("\n");
				}
				flatFile.append("BL_POR:").append(psaCntrVO.getPorCd()).append("\n");
				//flatFile.append("BL_POD:").append(psaCntrVO.getPodCd()).append("\n");
				flatFile.append("BL_POD:").append(psaCntrVO.getN2ndPodCd()).append("\n");
				flatFile.append("BL_DEL:").append(psaCntrVO.getDelCd()).append("\n");
				flatFile.append("BL_POL:").append(psaCntrVO.getPolCd()).append("\n");
				flatFile.append("POD1:").append(psaCntrVO.getN1stPodCd()).append("\n");
				flatFile.append("POD2:").append("\n");
				flatFile.append("POD3:").append("\n");
				flatFile.append("DSCH_OVS:").append(psaCntrVO.getDchgOvrSzFlg()).append("\n");
				flatFile.append("DEL_DIR:").append(psaCntrVO.getDirDeFlg()).append("\n");

				String blckStwgCd = "";
				String slanCd = "";
				if (!"".equals(psaCntrVO.getBlckStwgCd())) {
					blckStwgCd = psaCntrVO.getBlckStwgCd();
					slanCd = psaCntrVO.getSlanCd();
				}
				flatFile.append("BLK_STG:").append(blckStwgCd).append("\n");
				flatFile.append("SVC_LANE:").append(slanCd).append("\n");

				flatFile.append("SEAL:").append(psaCntrVO.getCntrSealNo()).append("\n");
				flatFile.append("CLASS:").append(psaCntrVO.getCntrClass()).append("\n");
				flatFile.append("2ND_VSL:").append(psaCntrVO.getPsaVslNm()).append("\n");
				flatFile.append("2ND_VOY_DIR:").append(psaCntrVO.getPsaVoyDirCd()).append("\n");
				flatFile.append("2ND_INS_TP:").append(psaCntrVO.getTsTpCd()).append("\n");
				flatFile.append("}CNTR_INFO").append("\n");
			}

			// EDI 전송
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR.IBMMQ.QUEUE"));
			flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

			// 전송결과 UPDATE
			dbDao.modifyPSAImpStsSndInfo(psaImpStsVO);

		} catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * ESM_BKG_0420 : Transmit - Back End Job 결과<br>
	 * PSA Import Status EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitPSAImpSts(String backEndJobKey) throws EventException {
		try {
			return(String) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PSA Port 정보 수정
	 * @param PsaPortVO[] psaPortVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void managePSAPortList(PsaPortVO[] psaPortVOs, String userId) throws EventException {
		// Grid 에서 넘어오는 객체
		PsaPortVO psaPortVO = null;
		// ValidCheck1
		String validCheck1 = null;

		try {

			// LOOP
			for (int i=0; i < psaPortVOs.length; i++) {

				psaPortVO = psaPortVOs[i];
				psaPortVO.setUserId(userId);

					// ADD
				if (psaPortVO.getIbflag().equals("I")) {
					// Validation Check1
					validCheck1 = dbDao.searchPSAPortExistChk(psaPortVO.getLocCd(),psaPortVO.getTmlCd());

					// 결과가 Null이면 진행
					if (validCheck1==null) {
						// INSERT
						dbDao.addPSAPortList(psaPortVO);
					}
				}

				// MODIFY
				if (psaPortVO.getIbflag().equals("U")) {
					dbDao.modifyPSAPortList(psaPortVO);
				}

				// DELETE
				if (psaPortVO.getIbflag().equals("D")) {
					dbDao.removePSAPortList(psaPortVO);
				}

			}

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PSA TS VVD 목록 조회
	 *
	 * @param String portCd
	 * @param String etdDt
	 * @param String transTp
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPSATsVVDList(String portCd, String etdDt, String transTp) throws EventException {
		String[] vvds = null;

		try {

			vvds = dbDao.searchPSATsVVDList(portCd, etdDt.replaceAll("-", ""), transTp);

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return vvds;
	}

	/**
	 * PSA와 BKG 데이터(구 OPUS 데이터) 간의 Unmatch List를 조회
	 *
	 * @param PsaUnmatchListVO psaUnmatchListVO
	 * @return PsaUnmatchListVO
	 * @exception EventException
	 */
	public PsaUnmatchListVO searchUnmatchList(PsaUnmatchListVO psaUnmatchListVO) throws EventException {

		// 최종 리턴할 객체
		PsaUnmatchListVO outVO = new PsaUnmatchListVO();
		// 파라메터 객체
		PsaUnmatchListVO condVO = psaUnmatchListVO;
		// 파라메터 정의
		String vvd = condVO.getVvd();
		String vslCd = vvd.substring(0, 4);
		String voyCd = vvd.substring(4, 8);
		String dirCd = vvd.substring(8);
		String rlyPort = condVO.getRlyPort();
		String transTpCd = condVO.getTransTpCd();
		String cntrNo = "";
		String dgDetail = "";
		String bkgNo = "";
		// Unmatch 조회결과 객체
		PsaImportVO unmatchVO = null;
		List<PsaImportVO> unmatchList = new ArrayList<PsaImportVO>();
		// Unmatch 조회를 위한 임시 객체들
		CntrNoVO[] cntrList = null;
		PsaUnmatchCNTRVO psaUnmatchCNTRVO = new PsaUnmatchCNTRVO();
		PsaUnmatchBKGVO psaUnmatchBKGVO = null;
		BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO = null;

		// OPUS 조회결과 객체
		PsaUnmatchBkgCntrVO[] opusList = null;
		PsaUnmatchBkgCntrVO psaUnmatchBkgCntrVO = new PsaUnmatchBkgCntrVO();
		PsaNextVO psaNextVO = new PsaNextVO();
		// PSA 조회결과 객체
		PsaUnmatchPsaCntrVO[] psaList = null;
		PsaUnmatchPsaCntrVO psaUnmatchPsaCntrVO = new PsaUnmatchPsaCntrVO();

		try {

			// PSA VSL NAME ETD 조회
			NameEtdVO nameEtdVO = dbDao.searchPSAVslNameEtd(vslCd, voyCd, dirCd, rlyPort);

			// Unmatch 정보 조회
			// 1. 컨테이너 리스트 조회
			psaUnmatchCNTRVO.setVvd(vvd);
			psaUnmatchCNTRVO.setRlyPort(rlyPort);
			psaUnmatchCNTRVO.setTransTpCd(transTpCd);
			cntrList = dbDao.searchUnmatchCNTRList(psaUnmatchCNTRVO);
			// LOOP
			if (cntrList!=null) {
				for (int i=0; i < cntrList.length; i++) {
					// 컨테이너 번호
					cntrNo = cntrList[i].getCntrNo();
					// DG DETAIL 초기화
					dgDetail = "";
					// BkgNo
					bkgNo = "";

					// 2. OPUS Unmatch 조회
					psaUnmatchBKGVO = new PsaUnmatchBKGVO();
					psaUnmatchBKGVO.setVvd(vvd);
					psaUnmatchBKGVO.setRlyPort(rlyPort);
					psaUnmatchBKGVO.setTransTpCd(transTpCd);
					psaUnmatchBKGVO.setCntrNo(cntrNo);
					psaUnmatchBKGVO = dbDao.searchUnmatchBKGList(psaUnmatchBKGVO);
					if (psaUnmatchBKGVO!=null) {
						bkgNo = psaUnmatchBKGVO.getBkgNo();
					}

					// Import 인 경우 NEXT POD 조회
					if (transTpCd.equals("I")) psaNextVO = dbDao.searchNextPodVvdForImport(vvd, bkgNo);

					// 3. Special DG 가 있을 경우
					if (psaUnmatchBKGVO!=null && psaUnmatchBKGVO.getImdgClssCd().trim().equals("1")) {
						dgDetail = dbDao.searchPSADGDetailInfo(bkgNo, cntrNo);
					}


					// 4. PSA Unmatch 조회
					bkgCstmsPsaCntrChkVO = new BkgCstmsPsaCntrChkVO();
					bkgCstmsPsaCntrChkVO.setVvd(vvd);
					bkgCstmsPsaCntrChkVO.setRlyPort(rlyPort);
					bkgCstmsPsaCntrChkVO.setTransTpCd(transTpCd);
					bkgCstmsPsaCntrChkVO.setCntrNo(cntrNo);
					bkgCstmsPsaCntrChkVO = dbDao.searchUnmatchPSAList(bkgCstmsPsaCntrChkVO);

					// 5. 최종 결과 리스트에 셋팅
					unmatchVO = new PsaImportVO();
					unmatchVO.setBkgNo(bkgNo);
					unmatchVO.setCntrNo(cntrNo);
					if (psaUnmatchBKGVO!=null) {
						unmatchVO.setOpusCntrTpCd(psaUnmatchBKGVO.getCntrTpCd());
						unmatchVO.setOpusCntrSzCd(psaUnmatchBKGVO.getCntrSzCd());
						unmatchVO.setOpusPortCd(psaUnmatchBKGVO.getPortCd());
						unmatchVO.setOpusSpecial(psaUnmatchBKGVO.getSpecial() + dgDetail);
						unmatchVO.setOpusLoad(psaUnmatchBKGVO.getStwgCd());
					}
					if (bkgCstmsPsaCntrChkVO!=null) {
						unmatchVO.setPsaCntrTpCd(bkgCstmsPsaCntrChkVO.getCntrTpCd());
						unmatchVO.setPsaCntrSzCd(bkgCstmsPsaCntrChkVO.getCntrSzCd());
						unmatchVO.setPsaPortCd(bkgCstmsPsaCntrChkVO.getPortCd());
						unmatchVO.setPsaSpecial(bkgCstmsPsaCntrChkVO.getSpecial());
						unmatchVO.setPsaLoad(bkgCstmsPsaCntrChkVO.getUndDeckTpId());
					}
					// 조회 결과 셋팅
					if (psaNextVO != null) {
						unmatchVO.setNextPod(psaNextVO.getNextPod());
						unmatchVO.setNextVvd(psaNextVO.getNextVvd());
					}
					unmatchVO.setVslNm(nameEtdVO.getVslNm());
					unmatchVO.setEtdDt(nameEtdVO.getVpsEtdDt());
					unmatchVO.setEtaDt(nameEtdVO.getVpsEtaDt());

					// List 객체에 추가
					unmatchList.add(unmatchVO);
				}
			}


			// OPUS 조회
			psaUnmatchBkgCntrVO.setVvd(vvd);
			psaUnmatchBkgCntrVO.setRlyPort(rlyPort);
			psaUnmatchBkgCntrVO.setTransTpCd(transTpCd);
			opusList = dbDao.searchUnmatchBkgCntrList(psaUnmatchBkgCntrVO);
			if (opusList != null) {
				for (int i=0; i < opusList.length; i++) {
					// Import 인 경우 NEXT POD 조회
					psaNextVO = null;
					if (transTpCd.equals("I")) {
						// BKG NO 재조회
						String newBkgNo = dbDao.searchBkgNoForNextPodVvd(vvd, opusList[i].getCntrNo());
						if ("".equals(newBkgNo)) opusList[i].setBkgNo(newBkgNo);
						psaNextVO = dbDao.searchNextPodVvdForImport(vvd, newBkgNo);
					}
					if (psaNextVO != null) {
						opusList[i].setNextPod(psaNextVO.getNextPod());
						opusList[i].setNextVvd(psaNextVO.getNextVvd());
					}
				}
			}

			// PSA 조회
			psaUnmatchPsaCntrVO.setVvd(vvd);
			psaUnmatchPsaCntrVO.setRlyPort(rlyPort);
			psaUnmatchPsaCntrVO.setTransTpCd(transTpCd);
			psaList = dbDao.searchUnmatchPSACntrList(psaUnmatchPsaCntrVO);

			// 결과 객체에 담기
			outVO.setPsaImportVOs(unmatchList.toArray(new PsaImportVO[0]));
			outVO.setPsaUnmatchBkgCntrVOs(opusList);
			outVO.setPsaUnmatchPsaCntrVOs(psaList);

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * Jurong I/F 파일 Parsing 처리
	 * @param String jurongIf
	 * @return PsaJurongIfVO[]
	 * @exception EventException
	 */
	public PsaJurongIfVO[] parseJurongIF(String jurongIf) throws EventException {

		List<PsaJurongIfVO> list = new ArrayList<PsaJurongIfVO>();
		PsaJurongIfVO psaJurongIfVO = null;

		try {

			ModuleMetaData metaData = FileMetaDataManager.getInstance().getFileMetaData("BKG");
			String[] contents = FileUtils.fileReader(metaData.getWork_dir(), jurongIf).split("\n");
			String firstVslNm = null;
			String special = null;

			for (int i=0; i < contents.length; i++) {

				if (contents[i].indexOf("First Carrier") > 10) {
					firstVslNm = contents[i].substring(contents[i].indexOf(":") + 2, contents[i].indexOf("/"));
				}

				if (contents[i].length() < 143
					|| contents[i].startsWith("---")
					|| contents[i].startsWith("Container_No")) continue;

				psaJurongIfVO = new PsaJurongIfVO();

				psaJurongIfVO.setVvdNm(firstVslNm);
				psaJurongIfVO.setCntrNo(contents[i].substring(0, 12).replaceAll(" ", ""));
				psaJurongIfVO.setPortCd(contents[i].substring(19, 24));
				psaJurongIfVO.setCntrTpCd(contents[i].substring(65, 67));
				psaJurongIfVO.setCntrSzCd(contents[i].substring(62, 64));
				psaJurongIfVO.setUndDeckTpId(contents[i].substring(83, 95));

				special = contents[i].substring(96, 126).trim();

				if ("UD".equals(special) || "UDBW".equals(special)
					|| "UDAB".equals(special) || "UDTS".equals(special)
					|| "UDHG".equals(special) || "OD".equals(special)
					|| "ODTS".equals(special) || "ODET".equals(special)) {
					psaJurongIfVO.setUndDeckTpId(special);
				} else {
					psaJurongIfVO.setSpecial(special);
				}

				list.add(psaJurongIfVO);
			}

		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list.toArray(new PsaJurongIfVO[0]);
	}

	/**
	 * PSA Import 데이터 추가
	 * @param PsaImportVO psaImportVO
	 * @exception EventException
	 */
	public void manageUnmatchList(PsaImportVO psaImportVO) throws EventException {

		// 화면에서 넘어온 데이터들
		PsaJurongIfVO[] psaJurongIfVOs = psaImportVO.getPsaJurongIfVOs();
		// 데이터 저장용 객체
		BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO = new BkgCstmsPsaCntrChkVO();

		// vslSkdValid Check
		String vslSkdValid = null;
		// Loc Cd
		String locCdCheck = null;
		String unlocCd = null;

		PsaVvdVO psaVvdVO = null;
		int psaVvdCnt = 0;

		try {

			// Vessel Skd Check
			vslSkdValid = dbDao.searchVslSkdValid(psaImportVO.getVvd());
			if (vslSkdValid==null) {
				throw new EventException(new ErrorHandler("BKG01060", new String[] {}).getMessage());
			}

			// DATA 삭제 처리
			bkgCstmsPsaCntrChkVO.setVvd(psaImportVO.getVvd());
			bkgCstmsPsaCntrChkVO.setRlyPort(psaImportVO.getRlyPort());
			bkgCstmsPsaCntrChkVO.setTransTpCd(psaImportVO.getTransTpCd());
			bkgCstmsPsaCntrChkVO.setUserId(psaImportVO.getUserId());
			dbDao.removeUnmatchPSAList(bkgCstmsPsaCntrChkVO);

			// IMPORT 처리 LOOP
			for (int i=0; i < psaJurongIfVOs.length; i++) {
				// CodeConvLoc 조회
				locCdCheck = dbDao.searchCodeConvLoc(psaJurongIfVOs[i].getPortCd());
				// 조회결과가 없을경우
				if (locCdCheck==null) {
					// UnLocCd 조회
					unlocCd = dbDao.searchCodeConvUNLoc(psaJurongIfVOs[i].getPortCd());
					// 조회후 결과가 있을경우 PORT_CD 교체
					if (unlocCd!=null) psaJurongIfVOs[i].setPortCd(unlocCd);
				}

				//pk check 로직
				psaVvdVO = new PsaVvdVO();
				psaVvdVO.setVslCd(bkgCstmsPsaCntrChkVO.getVvd().substring(0, 4));
				psaVvdVO.setSkdVoyNo(bkgCstmsPsaCntrChkVO.getVvd().substring(4, 8));
				psaVvdVO.setSkdDirCd(bkgCstmsPsaCntrChkVO.getVvd().substring(8, 9));
				psaVvdCnt = Integer.parseInt(dbDao.searchPSAVVDValidCheck(psaVvdVO));
				if(psaVvdCnt==0){
					throw new EventException(new ErrorHandler("BKG01122", new String[] {bkgCstmsPsaCntrChkVO.getVvd()}).getMessage());//PSA VVD DOES NOT EXIST! (Plz, Register a PSA VVD)
				}

				// Unmatch PSA DB INSERT
				bkgCstmsPsaCntrChkVO.setCntrNo(psaJurongIfVOs[i].getCntrNo());
				bkgCstmsPsaCntrChkVO.setVvdNm(psaJurongIfVOs[i].getVvdNm());
				bkgCstmsPsaCntrChkVO.setPortCd(psaJurongIfVOs[i].getPortCd());
				bkgCstmsPsaCntrChkVO.setCntrTpCd(psaJurongIfVOs[i].getCntrTpCd());
				bkgCstmsPsaCntrChkVO.setCntrSzCd(psaJurongIfVOs[i].getCntrSzCd());
				bkgCstmsPsaCntrChkVO.setUndDeckTpId(psaJurongIfVOs[i].getUndDeckTpId());
				bkgCstmsPsaCntrChkVO.setSpecial(psaJurongIfVOs[i].getSpecial());
				if (bkgCstmsPsaCntrChkVO.getCntrTpCd().length() < 2) bkgCstmsPsaCntrChkVO.setCntrTpCd("  ");
				dbDao.addUnmatchPsaList(bkgCstmsPsaCntrChkVO);
			}
		} catch(EventException evx) {
			throw evx;
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PSA EDI I/F 정보 조회
	 * @param PsaBkgIfVO psaBkgIfVO
	 * @return PsaBkgIfVO[]
	 * @throws EventException
	 */
	public PsaBkgIfVO[] searchPSAIFInfo(PsaBkgIfVO psaBkgIfVO) throws EventException {
		// 최종 결과 리턴 객체
		PsaBkgIfVO[] outBkgIfVOs = new PsaBkgIfVO[0];
		// 사용자 이름
		String usrNm = "";
		// 메인 BKG QTY
		String mainBkgQty = "";

		try {
			usrNm = dbDao.searchComUser(psaBkgIfVO.getUsrId());
			mainBkgQty = dbDao.searchBkgCntrTpSzQty(psaBkgIfVO.getBkgNo());
			List<PsaBkgIfVO> PsaBkgIfVOList = dbDao.searchPSAIFInfoLast(psaBkgIfVO.getBkgNo());
			// 조회 결과가 없으면 BKG 조회
			if (PsaBkgIfVOList.size() < 1) PsaBkgIfVOList = dbDao.searchPSABKGIFInfo(psaBkgIfVO.getBkgNo());

			if (PsaBkgIfVOList.size() > 0) {
				outBkgIfVOs = new PsaBkgIfVO[PsaBkgIfVOList.size()];
				// USER NAME 셋팅
				for (int i=0; i<PsaBkgIfVOList.size(); i++) {
					psaBkgIfVO.setUsrNm(usrNm);
					psaBkgIfVO.setMainBkgQty(mainBkgQty);
					outBkgIfVOs[i] = psaBkgIfVO;
				}
			}
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return outBkgIfVOs;
	}

	/**
	 * PSA BKG EDI I/F 전송
	 *
	 * @param PsaBkgVO[] psaBkgVOs
	 * @throws EventException
	 */
	public void managePSABKG(PsaBkgVO[] psaBkgVOs) throws EventException {

		// NEW BKG VVD
		String newVvd = null;
		// OLD BKG VVD
		String oldVvd = null;
		// PSA BKG 의 SEQ
		String pbSeq = null;
		// VVD 변경 여부(Y / N)
		String vvdChgInd = null;
		// 임시 변수
		String bkgNo = null;

		try {

			// 화면에서 넘어온 건수 LOOP START
			for (int i=0; i < psaBkgVOs.length; i++) {

				bkgNo = psaBkgVOs[i].getBkgNo();

				// BKG VVD 조회
				newVvd = dbDao.searchBkgNewVvd(bkgNo);

				// MAX SEQ 조회
				pbSeq = dbDao.searchPsaBkgMaxSeqPls(bkgNo);

				// MAX SEQ 가 1 이상인 경우
				if (pbSeq!=null && pbSeq.compareTo("1") > 0) {
					// OLD BKG VVD 조회
					oldVvd = dbDao.searchPsaBkgOldVvd(bkgNo, pbSeq);

					// OLD VVD 와 NEW VVD 가 같은 경우
					if (newVvd.equalsIgnoreCase(oldVvd)) {
						vvdChgInd = "N";
						vvd_chg_or_unchg(psaBkgVOs[i], vvdChgInd, false);
					} else {
						// VVD 가 변경된 경우
						vvdChgInd = "Y";
						vvd_chg_or_unchg(psaBkgVOs[i], vvdChgInd, true);

						// PSA I/F BKG 코드를 D로 변경
						dbDao.modifyPsaBkgIFCdD(bkgNo);
						// PSA I/F Cntr 코드를 D로 변경
						dbDao.modifyPsaBkgCntrIFCdD(bkgNo);
						// PSA I/F RlseOrd 코드를 D로 변경
						dbDao.modifyPsaBkgRlseOrdIFCd(bkgNo);
					}

				} else {
					// MAX SEQ 가 1 이하인 경우
					vvdChgInd = "N";
					vvd_chg_or_unchg(psaBkgVOs[i], vvdChgInd, false);
				}

			} // END MAIN FOR
		}catch(EventException ee) {
			throw ee;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * VVD가 변경 혹인 미견경된 경우 전송 처리
	 *
	 * @param PsaBkgVO psaBkgVO
	 * @param String vvdChgInd
	 * @param boolean changeType
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private void vvd_chg_or_unchg(PsaBkgVO psaBkgVO, String vvdChgInd, boolean changeType) throws Exception {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		String ediHeader = null;
		// BOOKING UTIL
		BookingUtil bookingUtil = new BookingUtil();
		// EDI 전송용 객체
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		FlatFileAckVO flatFileAckVO = null;

		// 임시변수들
		String pbSndInd = null;

		List<PsaBkgIfVO> psaBkgIfVOList = new ArrayList<PsaBkgIfVO>();
		// PSA INFO 조회
		if ("Y".equals(psaBkgVO.getQtyModifyFlag())) {
			// Booking Qty Data 값
			psaBkgIfVOList = dbDao.searchPSABKGIFInfo(psaBkgVO.getBkgNo());
		} else {
			// PSA Data 값
			psaBkgIfVOList = dbDao.searchPSAIFInfo(psaBkgVO.getBkgNo());
			if (psaBkgIfVOList.size() < 1) psaBkgIfVOList = dbDao.searchPSABKGIFInfo(psaBkgVO.getBkgNo());
		}

		// PSA BKG 데이터 조회
		BkgDataVO bkgDataVO = dbDao.searchBkgDataForPsaBkg(psaBkgVO.getBkgNo());

		// POL_CD 가 다르면 오류 처리
		if (!"SGSIN".equalsIgnoreCase(bkgDataVO.getPolCd()))
			throw new EventException(new ErrorHandler("BKG95025", new String[] {bkgDataVO.getPolCd()}).getMessage());

		// Block Stowage Code 조회
		String blkStwgCd = dbDao.searchBlckStwgCd(psaBkgVO.getBkgNo());

		// BKG VVD 에서 Vessel 정보 조회
		BkgVvdInfoVO bkgVvdInfoVO = dbDao.searchBkgVvdInfo(psaBkgVO.getBkgNo(), bkgDataVO.getPolCd());

		// POD 정보 조회
		String[] pods = dbDao.searchBkgVvdPodCd(psaBkgVO.getBkgNo());
		// 조회 결과가 3건 이상인 경우 오류 처리
		if (pods != null && pods.length > 3)
			throw new EventException(new ErrorHandler("BKG95026", new String[] { String.valueOf(pods.length) }).getMessage());

		// Shipper Name 조회
		PsaShprVO psaShprVO = dbDao.searchShprName(psaBkgVO.getBkgNo());

		// SEQ 조회
		String maxSeq = dbDao.searchPsaBkgMaxSeqPls(psaBkgVO.getBkgNo());

		// BKG_STS_CD 가 X 인경우 처리
		if ("X".equalsIgnoreCase(bkgDataVO.getBkgStsCd())) {
			pbSndInd = "D";
		} else {
			String psaUpdate = dbDao.searchUpdatePsaIFCd(psaBkgVO.getBkgNo());
			if (psaUpdate==null) pbSndInd = "N"; else pbSndInd = psaUpdate;
			// VVD 가 변경된 경우
			if (vvdChgInd!=null && vvdChgInd.equalsIgnoreCase("Y")) pbSndInd = "N";
		}

		// BKG INFO 저장
		PsaBkgInfoVO psaBkgInfoVO = new PsaBkgInfoVO();
		psaBkgInfoVO.setBkgNo(psaBkgVO.getBkgNo());
		psaBkgInfoVO.setBkgSeq(maxSeq);
		psaBkgInfoVO.setVslCd(bkgVvdInfoVO.getVslCd());
		psaBkgInfoVO.setSkdVoyNo(bkgVvdInfoVO.getSkdVoyNo());
		psaBkgInfoVO.setSkdDirCd(bkgVvdInfoVO.getSkdDirCd());
		psaBkgInfoVO.setPsaIfCd(pbSndInd);
		psaBkgInfoVO.setN1stShprNm(psaShprVO.getShprNm1());
		psaBkgInfoVO.setN2ndShprNm(psaShprVO.getShprNm2());
		psaBkgInfoVO.setPodCd(bkgDataVO.getPodCd());
		if (pods != null ) {
			if (pods.length > 0) psaBkgInfoVO.setN1stPodCd(pods[0]);
			if (pods.length > 1) psaBkgInfoVO.setN2ndPodCd(pods[1]);
			if (pods.length > 2) psaBkgInfoVO.setN3rdPodCd(pods[2]);
		}
		psaBkgInfoVO.setSndUsrId(psaBkgVO.getSndUsrId());
		dbDao.addPsaBkgInfo(psaBkgInfoVO);

		// VSL INFO 조회
		PsaBkgVslVO psaBkgVslVO = new PsaBkgVslVO();;
//		if (changeType) {
//			psaBkgVslVO = dao.searchPsaBkgVslInfo(psaBkgVO.getBkgNo(), maxSeq);
//		} else {
			psaBkgVslVO = dbDao.searchPsaBkgVslInfoForUnchg(psaBkgVO.getBkgNo(), maxSeq);
//		}

		// 조회값이 없을 경우
		if (psaBkgVslVO == null || psaBkgVslVO.getPvVslNm() == null || psaBkgVslVO.getPvVslNm().length() < 1) {
			throw new EventException(new ErrorHandler("BKG95027", new String[] {}).getMessage());
		}


		int lastInd = -1;
		// Reefer Cargo 조회용 객체
		PsaRfCgoVO paramRfCgoVO = new PsaRfCgoVO();
		List<PsaRfCgoVO> psaRfCgoVOList = new ArrayList<PsaRfCgoVO>();
		// Awkward Cargo 조회용 객체
		PsaAwkCgoVO paramAwkCgoVO = new PsaAwkCgoVO();
		List<PsaAwkCgoVO> psaAwkCgoVOList = new ArrayList<PsaAwkCgoVO>();;
		// 임시 저장용 리스트
		List<PsaBkgQtyTmpVO> psaList = new ArrayList<PsaBkgQtyTmpVO>();
		// 임시 저장용 객체
		PsaBkgQtyTmpVO psaBkgQtyTmpVO = new PsaBkgQtyTmpVO();

		// Quantity 조회
		for (PsaBkgQtyVO psaBkgQtyVO : dbDao.searchBkgQtyInfo(psaBkgVO.getBkgNo())) {

			if (psaBkgQtyVO.getCntrtsCd().substring(0, 1).equalsIgnoreCase("R")) {
				// RF CGO INFO 조회
				paramRfCgoVO.setBkgNo(psaBkgVO.getBkgNo());
				paramRfCgoVO.setCntrTpszCd(psaBkgQtyVO.getCntrtsCd());
				psaRfCgoVOList = dbDao.searchRfCgoInfo(paramRfCgoVO);
			}

			// Awkward Cargo 조회
			paramAwkCgoVO.setBkgNo(psaBkgVO.getBkgNo());
			paramAwkCgoVO.setCntrTpszCd(psaBkgQtyVO.getCntrtsCd());
			psaAwkCgoVOList = dbDao.searchAwkCgoInfo(paramAwkCgoVO);

			for (int j=0; j < Math.round(Double.parseDouble(psaBkgQtyVO.getQty())); j++) {
				lastInd++;
				psaBkgQtyTmpVO = new PsaBkgQtyTmpVO();
				psaBkgQtyTmpVO.setCntrSz(psaBkgQtyVO.getCntrSz());
				psaBkgQtyTmpVO.setCntrHeight(psaBkgQtyVO.getCntrHeight());

				if (psaBkgQtyVO.getCntrtsCd().substring(0, 1).equalsIgnoreCase("R")) {
					psaBkgQtyTmpVO.setSpeRf("Y");
					if (j < Math.round(Double.parseDouble(psaBkgQtyVO.getRfQty()))) {
						psaBkgQtyTmpVO.setSpeRd("N");
						for (PsaRfCgoVO psaRfCgoVO : psaRfCgoVOList) {
							if (Double.parseDouble(psaRfCgoVO.getRfQty()) > 0) {
								psaBkgQtyTmpVO.setRfTemp(psaRfCgoVO.getRfTempC());
								psaRfCgoVO.setRfQty(String.valueOf(Double.parseDouble(psaRfCgoVO.getRfQty())-1));
								// RF_HUMID 컬럼 추가
								psaBkgQtyTmpVO.setHumidNo(psaRfCgoVO.getHumidNo());
								break;
							}
						}
					} else {
						psaBkgQtyTmpVO.setSpeRd("Y");
					}
				} else {
					psaBkgQtyTmpVO.setSpeRf("N");
					psaBkgQtyTmpVO.setSpeRd("N");
				}

				psaBkgQtyTmpVO.setOhInd("N");
				psaBkgQtyTmpVO.setOwInd("N");
				psaBkgQtyTmpVO.setOlInd("N");

				if (j < Math.round(Double.parseDouble(psaBkgQtyVO.getAkQty()))) {
					for (PsaAwkCgoVO psaAwkCgoVO : psaAwkCgoVOList) {
						if (Double.parseDouble(psaAwkCgoVO.getAkQty()) > 0) {
							psaBkgQtyTmpVO.setOhInd(psaAwkCgoVO.getAkOh());
							psaBkgQtyTmpVO.setOwInd(psaAwkCgoVO.getAkOw());
							psaBkgQtyTmpVO.setOlInd(psaAwkCgoVO.getAkOl());
							psaAwkCgoVO.setAkQty(String.valueOf(Double.parseDouble(psaAwkCgoVO.getAkQty())-1));
							break;
						}
					}
				}

				if (Double.compare(new Double(j), Double.parseDouble(psaBkgQtyVO.getDgQty())) < 0) {
					psaBkgQtyTmpVO.setSpeDg("Y");
				} else {
					psaBkgQtyTmpVO.setSpeDg("N");
				}

				for (PsaBkgIfVO psaBkgIfVO : psaBkgIfVOList) {
					if (psaBkgQtyVO.getCntrtsCd().equalsIgnoreCase(psaBkgIfVO.getCntrTpszCd()) && Double.parseDouble(psaBkgIfVO.getCntrQty())>0) {
						psaBkgQtyTmpVO.setCntrtsCd(psaBkgIfVO.getCntrTpszCd());
						psaBkgQtyTmpVO.setYdCd(psaBkgIfVO.getYdCd());
						psaBkgIfVO.setCntrQty(String.valueOf(Double.parseDouble(psaBkgIfVO.getCntrQty())-1));
						break;
					}
				}

				psaList.add(psaBkgQtyTmpVO);
			}
		}

		// PSA Serial 조회용 객체
		PsaSrlNoVO psaSrlNoVO = new PsaSrlNoVO();
		String psaSerialNo = "";
		String psaSubSerial = "";
		// PSA BKG 업데이트용 객체
		PsaCntrCntVO psaCntrCntVO = new PsaCntrCntVO();
		PsaBkgCntrInfoVO psaBkgCntrInfoVO = new PsaBkgCntrInfoVO();
		PsaSubSrlNoVO psaSubSrlNoVO = new PsaSubSrlNoVO();
		PsaRoCntrQtyVO psaRoCntrQtyVO = new PsaRoCntrQtyVO();
		PsaMaxSubSrlNoVO psaMaxSubSrlNoVO = new PsaMaxSubSrlNoVO();
		PsaBkgRlsOrdVO psaBkgRlsOrdVO = new PsaBkgRlsOrdVO();

		for (int i=0; i<psaList.size(); i++) {
			psaSerialNo = "";
			psaSubSerial = "";
			psaBkgQtyTmpVO = psaList.get(i);

			// PSA Serial 조회
			psaSrlNoVO.setBkgNo(psaBkgVO.getBkgNo());
			psaSrlNoVO.setBkgSeq(maxSeq);
			psaSrlNoVO.setCntrTpszCd(psaBkgQtyTmpVO.getCntrSz());
			psaSrlNoVO.setDcgoFlg(psaBkgQtyTmpVO.getSpeDg());
			psaSrlNoVO.setRcFlg(psaBkgQtyTmpVO.getSpeRf());
			psaSrlNoVO.setRdCgoFlg(psaBkgQtyTmpVO.getSpeRd());
			psaSrlNoVO.setOvrHgtFlg(psaBkgQtyTmpVO.getOhInd());
			psaSrlNoVO.setOvrWdtFlg(psaBkgQtyTmpVO.getOwInd());
			psaSrlNoVO.setOvrLenFlg(psaBkgQtyTmpVO.getOlInd());
			psaSrlNoVO.setRcTemp(psaBkgQtyTmpVO.getRfTemp());
			psaSrlNoVO.setPbcCntrHeight(psaBkgQtyTmpVO.getCntrHeight());
			psaSrlNoVO.setPbcCntrTp(psaBkgQtyTmpVO.getCntrtsCd());
			psaSrlNoVO.setYdCd(psaBkgQtyTmpVO.getYdCd());
			psaSerialNo = dbDao.searchPsaSerialNo(psaSrlNoVO);

			// SERIAL이 조회 된 경우
			if (psaSerialNo != null) {
				// MODIFY BKG CNTR Count
				psaCntrCntVO.setBkgNo(psaBkgVO.getBkgNo());
				psaCntrCntVO.setBkgSeq(maxSeq);
				psaCntrCntVO.setPsaSerNo(psaSerialNo);
				psaCntrCntVO.setPsaCntrTpszCd(psaBkgQtyTmpVO.getCntrtsCd());
				if (changeType) {
					dbDao.modifyPsaBkgCntrCnt(psaCntrCntVO);
				} else {
					dbDao.modifyPsaBkgCntrCntForUnchg(psaCntrCntVO);
				}
			} else {
				// SERIAL 조회 실패시 재조회
				psaSerialNo = dbDao.searchPsaBkgCntrMaxSerialNoPls(psaBkgVO.getBkgNo(), maxSeq);
				// ADD CNTR INFO
				psaBkgCntrInfoVO.setBkgNo(psaBkgVO.getBkgNo());
				psaBkgCntrInfoVO.setBkgSeq(maxSeq);
				psaBkgCntrInfoVO.setPsaSerNo(psaSerialNo);
				psaBkgCntrInfoVO.setPsaIfCd(pbSndInd);
				psaBkgCntrInfoVO.setCntrTpszCd(psaBkgQtyTmpVO.getCntrSz());
				psaBkgCntrInfoVO.setFullMtyCd(bkgDataVO.getBkgCgoTpCd());
				psaBkgCntrInfoVO.setDcgoFlg(psaBkgQtyTmpVO.getSpeDg());
				psaBkgCntrInfoVO.setRcFlg(psaBkgQtyTmpVO.getSpeRf());
				psaBkgCntrInfoVO.setRdCgoFlg(psaBkgQtyTmpVO.getSpeRd());
				psaBkgCntrInfoVO.setOvrHgtFlg(psaBkgQtyTmpVO.getOhInd());
				psaBkgCntrInfoVO.setOvrWdtFlg(psaBkgQtyTmpVO.getOwInd());
				psaBkgCntrInfoVO.setOvrLenFlg(psaBkgQtyTmpVO.getOlInd());
				psaBkgCntrInfoVO.setRcTemp(psaBkgQtyTmpVO.getRfTemp());
				psaBkgCntrInfoVO.setHumidNo(psaBkgQtyTmpVO.getHumidNo());
				psaBkgCntrInfoVO.setSpclCgoDtlFlg(bkgDataVO.getSpclHideFlg());
				psaBkgCntrInfoVO.setPbcCntrHeight(psaBkgQtyTmpVO.getCntrHeight());
				psaBkgCntrInfoVO.setPbcCntrTp(psaBkgQtyTmpVO.getCntrtsCd());
				psaBkgCntrInfoVO.setUsrId(psaBkgVO.getSndUsrId());
				dbDao.addPsaBkgCntrInfo(psaBkgCntrInfoVO);
			}

			// SUB Serial 조회
			psaSubSrlNoVO.setBkgNo(psaBkgVO.getBkgNo());
			psaSubSrlNoVO.setBkgSeq(maxSeq);
			psaSubSrlNoVO.setPsaSerNo(psaSerialNo);
			psaSubSrlNoVO.setYdCd(psaBkgQtyTmpVO.getYdCd());
			psaSubSrlNoVO.setCntrTpszCd(psaBkgQtyTmpVO.getCntrtsCd());
			psaSubSerial = dbDao.searchSubPsaSerialNo(psaSubSrlNoVO);

			// Sub Serial 이 조회된 경우
			if (!"".equals(psaSubSerial)) {
				// Modify Qty
				psaRoCntrQtyVO.setBkgNo(psaBkgVO.getBkgNo());
				psaRoCntrQtyVO.setBkgSeq(maxSeq);
				psaRoCntrQtyVO.setPsaSerNo(psaSerialNo);
				psaRoCntrQtyVO.setSubPsaSerNo(psaSubSerial);
				dbDao.modifyPsaBkgRoCntrQty(psaRoCntrQtyVO);
			} else {
				// 재조회
				psaMaxSubSrlNoVO.setBkgNo(psaBkgVO.getBkgNo());
				psaMaxSubSrlNoVO.setBkgSeq(maxSeq);
				psaMaxSubSrlNoVO.setPsaSerNo(psaSerialNo);
				// ADD RlsOrd
				psaBkgRlsOrdVO.setBkgNo(psaBkgVO.getBkgNo());
				psaBkgRlsOrdVO.setBkgSeq(maxSeq);
				psaBkgRlsOrdVO.setPsaSerNo(psaSerialNo);
				psaBkgRlsOrdVO.setSubPsaSerNo(dbDao.searchSubPsaMaxSerialNo(psaMaxSubSrlNoVO));
				psaBkgRlsOrdVO.setPsaIfCd(pbSndInd);
				psaBkgRlsOrdVO.setYdCd(psaBkgQtyTmpVO.getYdCd());
				psaBkgRlsOrdVO.setCntrTpszCd(psaBkgQtyTmpVO.getCntrtsCd());
				psaBkgRlsOrdVO.setUsrId(psaBkgVO.getSndUsrId());
				dbDao.addPsaBkgRlsOrd(psaBkgRlsOrdVO);
			}
		}

		// Release Order CNTR 정보
		PsaBkgRlsOrdCntrVO[] psaBkgRlsOrdCntrVOs = null;
		int roLoop = 0;
		// Special Cargo 정보
		CntrSpeCgoVO[] cntrSpeCgoVOs = null;
		int cntrLoop = 0;
		int k=0, l=0;
		long rest = 0;
		// Container No 6개
		String[] cntrNos = null;
		PsaCntrNoVO psaCntrNoVO = new PsaCntrNoVO();

		// BKG TPSZ QTY 조회
		for (PsaBkgQtyVO psaBkgQtyVO : dbDao.searchBkgQtyCntrTpSzQty(psaBkgVO.getBkgNo())) {
			// RlsOrd Cntr 조회
			psaBkgRlsOrdCntrVOs = dbDao.searchPsaBkgRlsOrdCntrInfo(psaBkgVO.getBkgNo(), maxSeq, psaBkgQtyVO.getCntrtsCd());
			// 조회결과가 없으면 오류리턴
			if (psaBkgRlsOrdCntrVOs == null) throw new EventException(new ErrorHandler("BKG04021", new String[] {}).getMessage());

			roLoop = psaBkgRlsOrdCntrVOs.length;

			// Special Cgo 조회
			cntrSpeCgoVOs = dbDao.searchCntrSpeCgoInfo(psaBkgVO.getBkgNo(), psaBkgQtyVO.getCntrtsCd());
			if (cntrSpeCgoVOs!=null) {
				cntrLoop = cntrSpeCgoVOs.length;
			} else {
				cntrLoop = 0;
			}

			if (cntrLoop > Integer.parseInt(psaBkgQtyVO.getQty())) cntrLoop = Integer.parseInt(psaBkgQtyVO.getQty());
			int[] aCntrCnt = new int[roLoop+1];
			String[][] aCntrNo = new String[roLoop + 1][ roLoop * cntrLoop + 1];

			for (int j=0; j<cntrLoop; j++) {
				for (k=0; k<roLoop; k++) {
					// 루프 탈출 조건 판단
					if (cntrSpeCgoVOs[j].getSpeDg().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getDcgoFlg()) &&
						cntrSpeCgoVOs[j].getSpeRf().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getRcFlg()) &&
						cntrSpeCgoVOs[j].getSpeRd().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getRdCgoFlg()) &&
						cntrSpeCgoVOs[j].getSpeAk().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getAkFlg()) &&
							(cntrSpeCgoVOs[j].getAkExist().equals("N") ||(cntrSpeCgoVOs[j].getOhInd().equals(psaBkgRlsOrdCntrVOs[k].getOvrHgtFlg()) &&
							 cntrSpeCgoVOs[j].getOwInd().equals(psaBkgRlsOrdCntrVOs[k].getOvrWdtFlg()) &&
							 cntrSpeCgoVOs[j].getOlInd().equals(psaBkgRlsOrdCntrVOs[k].getOvrLenFlg())) &&
								(cntrSpeCgoVOs[j].getRfExist().equals("N") || cntrSpeCgoVOs[j].getRfTemp().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getRcTemp())) &&
							 Double.compare(new Double(aCntrCnt[k]), Double.parseDouble(psaBkgRlsOrdCntrVOs[k].getCntrQty())) < 0)) break;
				} // END FOR K

				if (k < roLoop) {
					aCntrCnt[k]++;
					aCntrNo[k][aCntrCnt[k]-1] = cntrSpeCgoVOs[j].getCntrNo();
				} else {
					aCntrCnt[roLoop]++;
					aCntrNo[roLoop][aCntrCnt[roLoop]-1] = cntrSpeCgoVOs[j].getCntrNo();
				}

			} // END FOR J

			for (k=0; k<roLoop; k++) {
				rest = Math.round(Double.parseDouble(psaBkgRlsOrdCntrVOs[k].getCntrQty())) - aCntrCnt[k];
				for (l=0; l < rest; l++) {
					if (aCntrCnt[roLoop] > 0) {
						aCntrCnt[k]++;
						aCntrNo[k][aCntrCnt[k]-1] = aCntrNo[roLoop][aCntrCnt[roLoop]-1];
						aCntrNo[roLoop][aCntrCnt[roLoop]-1] = null;
						aCntrCnt[roLoop]--;
					} else {
						break;
					}

				} // END FOR L

				if (aCntrCnt[roLoop] < 1) break;

			} // END FOR K


			for (k=0; k<roLoop; k++) {
				if (aCntrCnt[k] < 1) continue;
				// CNTR_NO 조회
				cntrNos = dbDao.searchPsaBkgCntrNo(psaBkgVO.getBkgNo(), maxSeq, psaBkgRlsOrdCntrVOs[k].getPsaSerNo());
				for (l=0; l < 6; l++) {
					if (cntrNos[l]==null || cntrNos[l].length()==0) {
						cntrNos[l] = aCntrNo[k][aCntrCnt[k] -1];
						aCntrCnt[k]--;
						if (aCntrCnt[k] < 1) break;
					}
				} // END FOR L

				// MODIFY CNTR NO
				psaCntrNoVO.setN1stCntrNo(cntrNos[0]);
				psaCntrNoVO.setN2ndCntrNo(cntrNos[1]);
				psaCntrNoVO.setN3rdCntrNo(cntrNos[2]);
				psaCntrNoVO.setN4thCntrNo(cntrNos[3]);
				psaCntrNoVO.setN5thCntrNo(cntrNos[4]);
				psaCntrNoVO.setN6thCntrNo(cntrNos[5]);
				psaCntrNoVO.setBkgNo(psaBkgVO.getBkgNo());
				psaCntrNoVO.setBkgSeq(maxSeq);
				psaCntrNoVO.setPsaSerNo(psaBkgRlsOrdCntrVOs[k].getPsaSerNo());
				dbDao.modifyPsaBkgCntrNo(psaCntrNoVO);

			} // END FOR K

		} // END FOR I

		// VSL INFO 조회
//		PsaBkgVslVO psaBkgVslVO = null;
		psaBkgVslVO = null;
//		if (changeType) {
//			psaBkgVslVO = dao.searchPsaBkgVslInfo(psaBkgVO.getBkgNo(), maxSeq);
//		} else {
			psaBkgVslVO = dbDao.searchPsaBkgVslInfoForUnchg(psaBkgVO.getBkgNo(), maxSeq);
//		}


		// 조회값이 없을 경우
		if (psaBkgVslVO == null || psaBkgVslVO.getPvVslNm() == null || psaBkgVslVO.getPvVslNm().length() < 1) {
			throw new EventException(new ErrorHandler("BKG95027", new String[] {}).getMessage());
		}

		// EDI Header 조회
		ediHeader = bookingUtil.searchCstmsEdiHeaderNew("SG_PSAEXP");
		flatFile.append(ediHeader).append("\n");

		// FLATFILE 조립
		flatFile.append("PV_VSL_NM:").append(psaBkgVslVO.getPvVslNm()).append("\n");
		flatFile.append("PV_VOY_DIR:").append(psaBkgVslVO.getPvVoyDir()).append("\n");
		flatFile.append("PV_CON_VOY_DIR:").append(psaBkgVslVO.getPvConVoyDir()).append("\n");
		flatFile.append("BKG_FI:").append(psaBkgVslVO.getBkgFi()).append("\n");
		flatFile.append("UCR_NO:").append(psaBkgVslVO.getUcrNo()).append("\n");
		flatFile.append("SHPR_NM1:").append(psaBkgVslVO.getShprNm1()).append("\n");
		flatFile.append("SHPR_NM2:").append(psaBkgVslVO.getShprNm2()).append("\n");
		flatFile.append("OP_CD:").append(psaBkgVslVO.getOpCd()).append("\n");
		flatFile.append("SO_CD:").append(psaBkgVslVO.getSoCd()).append("\n");
		flatFile.append("BKG_POD:").append(psaBkgVslVO.getBkgPod()).append("\n");
		flatFile.append("POD_LOC1:").append(psaBkgVslVO.getPodLoc1()).append("\n");
		flatFile.append("POD_LOC2:").append(psaBkgVslVO.getPodLoc2()).append("\n");
		flatFile.append("POD_LOC3:").append(psaBkgVslVO.getPodLoc3()).append("\n");
		flatFile.append("BKG_DEL:").append(bkgDataVO.getDelCd()).append("\n");
		flatFile.append("BLK_STWG:").append(blkStwgCd).append("\n");
		flatFile.append("BKG_LANE:").append(bkgDataVO.getSlanCd()).append("\n");
		flatFile.append("BKG_RMK:").append(bkgDataVO.getInterRmk()).append("\n");

		// Container Info 조회
		PsaBkgCntrFlatVO[] psaBkgCntrFlatVOs = null;
		// RlsOrd 조회
		PsaBkgRlsOrdCntrTpszVO[] psaBkgRlsOrdCntrTpszVOs = null;
		if (changeType) {
			psaBkgCntrFlatVOs = dbDao.searchPsaBkgCntrInfo(psaBkgVO.getBkgNo(), maxSeq);
			psaBkgRlsOrdCntrTpszVOs = dbDao.searchPsaBkgRlsOrdCntrTpsz(psaBkgVO.getBkgNo(), maxSeq);
		} else {
			psaBkgCntrFlatVOs = dbDao.searchPsaBkgCntrInfoForUnchg(psaBkgVO.getBkgNo(), maxSeq);
			psaBkgRlsOrdCntrTpszVOs = dbDao.searchPsaBkgRlsOrdCntrTpszForUnchg(psaBkgVO.getBkgNo(), maxSeq);
		}

		if (psaBkgRlsOrdCntrTpszVOs != null) {
			roLoop = psaBkgRlsOrdCntrTpszVOs.length;
		} else {
			roLoop = 0;
		}

		// FLATFILE 조립
		if (psaBkgCntrFlatVOs != null) {
			cntrLoop = psaBkgCntrFlatVOs.length;
			for (int i=0; i<roLoop; i++) {
				flatFile.append("{CNTR_INFO").append("\n");
				flatFile.append("CNTR_FI:").append(psaBkgCntrFlatVOs[i].getCntrFi()).append("\n");
				flatFile.append("SEQ_CNTR:").append(psaBkgCntrFlatVOs[i].getSeqCntr()).append("\n");
				flatFile.append("CNTR_SZ:").append(psaBkgCntrFlatVOs[i].getCntrSz()).append("\n");
				flatFile.append("CNTR_TP:").append(psaBkgRlsOrdCntrTpszVOs[i].getCntrTp()).append("\n");
				flatFile.append("CNTR_HEIGHT:").append(psaBkgCntrFlatVOs[i].getCntrHeight().replaceAll(",", "")).append("\n");
				flatFile.append("CNTR_ST:").append(psaBkgCntrFlatVOs[i].getCntrSt()).append("\n");
				flatFile.append("DG_IND:").append(psaBkgCntrFlatVOs[i].getDgInd()).append("\n");
				flatFile.append("RF_IND:").append(psaBkgCntrFlatVOs[i].getRfInd()).append("\n");
				flatFile.append("OH_IND:").append(psaBkgCntrFlatVOs[i].getOhInd()).append("\n");
				flatFile.append("OW_IND:").append(psaBkgCntrFlatVOs[i].getOwInd()).append("\n");
				flatFile.append("OL_IND:").append(psaBkgCntrFlatVOs[i].getOlInd()).append("\n");
				flatFile.append("NO_CNTR:").append(psaBkgCntrFlatVOs[i].getNoCntr()).append("\n");
				flatFile.append("RF_TMP:").append(psaBkgCntrFlatVOs[i].getRfTemp()).append("\n");
				// Reefer Humidity 추가  -수석님 요청(2010.08.18)
				flatFile.append("RF_HUMID:").append(psaBkgCntrFlatVOs[i].getHumidNo()).append("\n");
				flatFile.append("SP_DTL:").append(psaBkgCntrFlatVOs[i].getSpDtl()).append("\n");
				flatFile.append("CNTR_NO1:").append(psaBkgCntrFlatVOs[i].getCntrNo1()).append("\n");
				flatFile.append("CNTR_NO2:").append(psaBkgCntrFlatVOs[i].getCntrNo2()).append("\n");
				flatFile.append("CNTR_NO3:").append(psaBkgCntrFlatVOs[i].getCntrNo3()).append("\n");
				flatFile.append("CNTR_NO4:").append(psaBkgCntrFlatVOs[i].getCntrNo4()).append("\n");
				flatFile.append("CNTR_NO5:").append(psaBkgCntrFlatVOs[i].getCntrNo5()).append("\n");
				flatFile.append("CNTR_NO6:").append(psaBkgCntrFlatVOs[i].getCntrNo6()).append("\n");
				flatFile.append("{RO_INFO").append("\n");
				flatFile.append("RO_FI:").append(psaBkgRlsOrdCntrTpszVOs[i].getRoFi()).append("\n");
				flatFile.append("RO_SEQ:").append(psaBkgRlsOrdCntrTpszVOs[i].getRoSeq()).append("\n");
				flatFile.append("RO_DO:").append(psaBkgRlsOrdCntrTpszVOs[i].getRoDo()).append("\n");
				flatFile.append("RO_CNTR_TP:").append(psaBkgRlsOrdCntrTpszVOs[i].getRoCntrTp()).append("\n");
				flatFile.append("RO_NO_CNTR:").append(psaBkgRlsOrdCntrTpszVOs[i].getRoNoCntr()).append("\n");
				flatFile.append("}RO_INFO").append("\n");
				flatFile.append("}CNTR_INFO").append("\n");
			}
		}

		// MODIFY SEND DATE
		PsaSndDtVO psaSndDtVO = new PsaSndDtVO();
		psaSndDtVO.setBkgNo(psaBkgVO.getBkgNo());
		psaSndDtVO.setBkgSeq(maxSeq);
		dbDao.modifyPsaBkgSndDt(psaSndDtVO);

		// EDI 전송
		sendFlatFileVO.setFlatFile(flatFile.toString());
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE"));
		flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
		if (flatFileAckVO.getAckStsCd().equals("E"))
			throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
	}

	/**
	 * PSA BKG Yard Code 추가 / 수정 / 삭제 처리
	 *
	 * @param PsaYardCdVO[] psaYardCdVOs
	 * @throws EventException
	 */
	public void managePsaYardCode(PsaYardCdVO[] psaYardCdVOs) throws EventException {

		// 최종 결과 리턴 객체
		List<PsaBkgIfVO> psaBkgIfVOList = new ArrayList<PsaBkgIfVO>();
		// Validation 사용
		List<PsaYardCdVO> list = new ArrayList<PsaYardCdVO>();
		// Booking
		PsaBkgForYardVO psaBkgForYardVO = new PsaBkgForYardVO();
		// Container
		PsaCntrForYardVO psaCntrForYardVO = new PsaCntrForYardVO();
		// Relase Order
		PsaRlsForYardVO psaRlsForYardVO = new PsaRlsForYardVO();
		// Max Seq
		String maxSeq = null;
		// Booking VVD
		PsaBkgvvdInfoVO psaBkgvvdInfoVO = null;
		// Booking Qty Flag
		String bkgQtyFlag = null;

		try {
			if (psaYardCdVOs.length > 0) {
				psaBkgIfVOList = dbDao.searchPSAIFInfoLast(psaYardCdVOs[0].getBkgNo());
				// BKG Qty 조회
				psaBkgIfVOList = dbDao.searchPSABKGIFInfo(psaYardCdVOs[0].getBkgNo());

				String cntrTpszFlg = "N";
				for (int i=0; i < psaYardCdVOs.length; i++) {
					if (!psaYardCdVOs[i].getIbflag().equals("D")) {
						cntrTpszFlg = "N";
						PsaYardCdVO psaVO = new PsaYardCdVO();
						if (list.size() == 0) {
							psaVO.setCntrTpszCd(psaYardCdVOs[i].getCntrTpszCd());
							psaVO.setCntrQty(psaYardCdVOs[i].getCntrQty());
							list.add(psaVO);
						} else {
							for (int j=0; j<list.size(); j++) {
									if (psaYardCdVOs[i].getCntrTpszCd().equals(list.get(j).getCntrTpszCd())) {
										list.get(j).setCntrQty(String.valueOf(Integer.parseInt(list.get(j).getCntrQty())+ Integer.parseInt(psaYardCdVOs[i].getCntrQty())));
										cntrTpszFlg = "Y";
										break;
									}
							}
							if ("N".equals(cntrTpszFlg)) {
								psaVO.setCntrTpszCd(psaYardCdVOs[i].getCntrTpszCd());
								psaVO.setCntrQty(psaYardCdVOs[i].getCntrQty());
								list.add(psaVO);
							}
						}
					}
				}

				for (PsaBkgIfVO psaBkgIfVO : psaBkgIfVOList) {
					bkgQtyFlag = "N";
					for (int i=0; i<list.size(); i++) {
						if (list.get(i).getCntrTpszCd().equals(psaBkgIfVO.getCntrTpszCd())) {
							if (0 == Double.compare(Double.parseDouble(list.get(i).getCntrQty()), Double.parseDouble(psaBkgIfVO.getCntrQty()))) {
								bkgQtyFlag = "Y";
								break;
							}
						}
					}
					if ("N".equals(bkgQtyFlag)) {
						throw new EventException(new ErrorHandler("BKG06123").getMessage());
					}
				}

			}

			for (int i=0; i<psaYardCdVOs.length; i++) {
				bkgQtyFlag = "N";
				if (psaYardCdVOs[i].getIbflag().equals("I")) {
					for (PsaBkgIfVO psaBkgIfVO : psaBkgIfVOList) {
						if (psaYardCdVOs[i].getCntrTpszCd().equals(psaBkgIfVO.getCntrTpszCd())) {
							bkgQtyFlag = "Y";
							break;
						}
					}
					if ("N".equals(bkgQtyFlag)) {
						throw new EventException(new ErrorHandler("BKG06123").getMessage());
					}

					// INSERT 처리
					maxSeq = dbDao.searchPsaMaxBkgSeq(psaYardCdVOs[i].getBkgNo());

					// VVD 조회
					psaBkgvvdInfoVO = dbDao.searchBkgVvdInfoForPsa(psaYardCdVOs[i].getBkgNo());

					// BKG INSERT
					psaBkgForYardVO.setUsrId(psaYardCdVOs[i].getUsrId());
					psaBkgForYardVO.setBkgNo(psaYardCdVOs[i].getBkgNo());
					psaBkgForYardVO.setBkgSeq(maxSeq);
					if (psaBkgvvdInfoVO!=null) {
						psaBkgForYardVO.setVslCd(psaBkgvvdInfoVO.getVslCd());
						psaBkgForYardVO.setSkdVoyNo(psaBkgvvdInfoVO.getSkdVoyNo());
						psaBkgForYardVO.setSkdDirCd(psaBkgvvdInfoVO.getSkdDirCd());
					}
					dbDao.addPsaBkgForYardCd(psaBkgForYardVO);

					// CNTR INSERT
					psaCntrForYardVO.setUsrId(psaYardCdVOs[i].getUsrId());
					psaCntrForYardVO.setBkgNo(psaYardCdVOs[i].getBkgNo());
					psaCntrForYardVO.setBkgSeq(maxSeq);
					dbDao.addPsaCntrForYardCd(psaCntrForYardVO);

					// RLSORD INSERT
					ObjectCloner.build(psaYardCdVOs[i], psaRlsForYardVO);
					psaRlsForYardVO.setBkgSeq(maxSeq);
					dbDao.addPsaRlsOrdForYardCd(psaRlsForYardVO);

				} else if (psaYardCdVOs[i].getIbflag().equals("U")) {

					for (PsaBkgIfVO psaBkgIfVO : psaBkgIfVOList) {
						if (psaYardCdVOs[i].getCntrTpszCd().equals(psaBkgIfVO.getCntrTpszCd())) {
							bkgQtyFlag = "Y";
							break;
						}
					}
					if ("N".equals(bkgQtyFlag)) {
						throw new EventException(new ErrorHandler("BKG06123").getMessage());
					}

					// UPDATE 처리
					ObjectCloner.build(psaYardCdVOs[i], psaRlsForYardVO);
					dbDao.modifyPsaRlsOrdForYardCd(psaRlsForYardVO);

				} else if (psaYardCdVOs[i].getIbflag().equals("D")) {

					// DELETE 처리
					ObjectCloner.build(psaYardCdVOs[i], psaCntrForYardVO);
					ObjectCloner.build(psaYardCdVOs[i], psaRlsForYardVO);
					ObjectCloner.build(psaYardCdVOs[i], psaBkgForYardVO);
					dbDao.removePsaCntrForYardCd(psaCntrForYardVO);
					dbDao.removePsaRlsOrdForYardCd(psaRlsForYardVO);
//					dao.removePsaBkgForYardCd(psaBkgForYardVO);
				} // END IF

			} // END FOR I

		} catch(EventException evx) {
			throw evx;
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PSA Inbound Manifest EDI 전송
	 *
	 * @param String vvd
	 * @param PsaIbManifestVO[] psaIbManifestVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(String vvd, PsaIbManifestVO[] psaIbManifestVOs, SignOnUserAccount account)throws EventException {
		BookingUtil bookingUtil = new BookingUtil();

		//B/L Input 정보
		List<PsaManifestListBlInfoVO> PsaManifestListBlInfoVOList = new ArrayList<PsaManifestListBlInfoVO>();

		// -- Output 정보 -- //
		// VSL 정보
		PsaManifestVslInfoVO psaVslInfoVO = new PsaManifestVslInfoVO();
		// Container Count 정보
		String psaCntrCnt = "";
		// BKG_CSTMS_SGP_SND_LOG 저장
		List<BkgCstmsSgpSndLogVO> bkgCstmsSgpSndLogVOList = new ArrayList<BkgCstmsSgpSndLogVO>();

		String blNo = "";
		String bkgNo = "";

		//-- For문 Index --//
		int cmDescLoopCnt = 0;
		int descLoopCnt = 0;
		int markLoopCnt = 0;

		// FLATFILE
		String flatFileHeader = "";
		StringBuilder flatFileBodyTop = new StringBuilder();
		StringBuilder flatFileContents = new StringBuilder();;    // BL단위로 생성 - 저장시 사용
		StringBuilder CompleteFlatFile = new StringBuilder();    // 전체 FlatFile - 전송시 사용

		try {
			// BL정보
			PsaManifestListBlInfoVOList = dbDao.searchPsaBlInfo(vvd, psaIbManifestVOs);

			// Body 생성
			if (PsaManifestListBlInfoVOList.size() > 0) {
				// Header 생성
				flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("SG_PSAIMP");

				//(1)VSL 정보
				psaVslInfoVO = dbDao.searchVslInfo(PsaManifestListBlInfoVOList.get(0));
				if (psaVslInfoVO == null) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				flatFileBodyTop.append("STATUS:").append(psaVslInfoVO.getStatus()).append("\n");
				flatFileBodyTop.append("VVD:").append(vvd).append("\n");
				flatFileBodyTop.append("CON_VVD:").append(psaVslInfoVO.getConVvd()).append("\n");
				flatFileBodyTop.append("VSL_FULLNAME:").append(psaVslInfoVO.getVslFullname()).append("\n");
				flatFileBodyTop.append("VSL_NATION_CD:").append(psaVslInfoVO.getVslNationCd()).append("\n");
				flatFileBodyTop.append("ETA:").append(psaVslInfoVO.getEta()).append("\n");
				flatFileBodyTop.append("ETD:").append(psaVslInfoVO.getEtd()).append("\n");
				CompleteFlatFile.append(flatFileBodyTop);


				for (PsaManifestListBlInfoVO psaManifestListBlInfoVO : PsaManifestListBlInfoVOList) {
					//-- For문 Index --//
					cmDescLoopCnt = 0;
					descLoopCnt = 0;
					markLoopCnt = 0;

					blNo = psaManifestListBlInfoVO.getBlNo();
					bkgNo = psaManifestListBlInfoVO.getBkgNo();
					flatFileContents = new StringBuilder();

					//(2)B/L 정보
					flatFileContents.append("{BL_INFO").append("\n");
					flatFileContents.append("BLNBR:").append(blNo).append("\n");
					flatFileContents.append("BKGNBR:").append(bkgNo).append("\n");
					flatFileContents.append("BLPKG:").append(psaManifestListBlInfoVO.getPckQty()).append("\n");
					flatFileContents.append("BLPKGU:").append(psaManifestListBlInfoVO.getCstmsPckTpCd()).append("\n");
					flatFileContents.append("BLWGT:").append(psaManifestListBlInfoVO.getActWgt()).append("\n");
					flatFileContents.append("BLWGT_UNIT:").append(psaManifestListBlInfoVO.getWgtUtCd()).append("\n");
					flatFileContents.append("BLMEA:").append(psaManifestListBlInfoVO.getMeasQty()).append("\n");
					flatFileContents.append("BLMEA_UNIT:").append(psaManifestListBlInfoVO.getMeasUtCd()).append("\n");

					//(3)Container Count 정보
					psaCntrCnt = dbDao.searchCntrCnt(bkgNo);
					flatFileContents.append("CNTR_CNT:").append(psaCntrCnt).append("\n");
					flatFileContents.append("BLPOL:").append(psaManifestListBlInfoVO.getPolCd()).append("\n");
					flatFileContents.append("BLPOD:").append(psaManifestListBlInfoVO.getPodCd()).append("\n");
					flatFileContents.append("BLDEL:").append(psaManifestListBlInfoVO.getDelCd()).append("\n");
					flatFileContents.append("TS_IND:").append(psaManifestListBlInfoVO.getTsInd()).append("\n");

					//(7)Description 정보
					String[] cstmsDescArr = psaManifestListBlInfoVO.getCstmsDesc().split("\\r\\n|\\n\\r|\\n|\\r");
					for (int idx=0; idx < cstmsDescArr.length; idx++) {
						while(cstmsDescArr[idx].length() > DESC_CNT_LIMIT) {
							flatFileContents.append("{DESC").append("\n");
							flatFileContents.append("DESC:").append(cstmsDescArr[idx].substring(0, DESC_CNT_LIMIT)).append("\n");
							flatFileContents.append("}DESC").append("\n");
							cstmsDescArr[idx] = cstmsDescArr[idx].substring(DESC_CNT_LIMIT);
							descLoopCnt++;
							if (descLoopCnt >= DESC_CNT_LOOP_CNT) {
								break;
							}
						}
						if (descLoopCnt >= DESC_CNT_LOOP_CNT) {
							break;
						}
						flatFileContents.append("{DESC").append("\n");
						flatFileContents.append("DESC:").append(cstmsDescArr[idx]).append("\n");
						flatFileContents.append("}DESC").append("\n");
						descLoopCnt++;
					}

					//(8)Mark 정보
					for (PsaManifestMarkInfoVO PsaManifestMarkInfoVO : dbDao.searchMarkInfo(bkgNo)) {
						String[] mark1Arr = PsaManifestMarkInfoVO.getMark1().split("\\r\\n|\\n\\r|\\n|\\r");
						for (int idx=0; idx < mark1Arr.length; idx++) {
							while (mark1Arr[idx].length() > DESC_CNT_LIMIT) {
								flatFileContents.append("{MARK").append("\n");
								flatFileContents.append("MARKNO:").append(mark1Arr[idx].substring(0, DESC_CNT_LIMIT)).append("\n");
								flatFileContents.append("}MARK").append("\n");
								mark1Arr[idx] = mark1Arr[idx].substring(DESC_CNT_LIMIT);
								markLoopCnt++;
								if (markLoopCnt >= DESC_CNT_LOOP_CNT) {
									break;
								}
							}
							if (markLoopCnt >= DESC_CNT_LOOP_CNT) {
								break;
							}
							flatFileContents.append("{MARK").append("\n");
							flatFileContents.append("MARKNO:").append(mark1Arr[idx]).append("\n");
							flatFileContents.append("}MARK").append("\n");
							markLoopCnt++;
						}
					}

					//(5)Customer 정보
					psaManifestListBlInfoVO.setUsrId(account.getUsr_id());
					for (PsaManifestCustomerInfoVO psaManifestCustomerInfoVO : dbDao.searchCustomerInfo(bkgNo)) {
						flatFileContents.append("{CUSTOMER_INFO").append("\n");
						flatFileContents.append("CUSTOMER_TYPE:").append(psaManifestCustomerInfoVO.getCustomerType()).append("\n");
						flatFileContents.append("CUSTOMER_CD:").append(psaManifestCustomerInfoVO.getCustomerCd()).append("\n");
						flatFileContents.append("CUSTOMER_NM1:").append(psaManifestCustomerInfoVO.getCustomerNm1()).append("\n");
						flatFileContents.append("CUSTOMER_NM2:").append(psaManifestCustomerInfoVO.getCustomerNm2()).append("\n");
						flatFileContents.append("CUSTOMER_ADDR1:").append(psaManifestCustomerInfoVO.getCustomerAddr1()).append("\n");
						flatFileContents.append("CUSTOMER_ADDR2:").append(psaManifestCustomerInfoVO.getCustomerAddr2()).append("\n");
						flatFileContents.append("CUSTOMER_ADDR3:").append(psaManifestCustomerInfoVO.getCustomerAddr3()).append("\n");
						flatFileContents.append("}CUSTOMER_INFO").append("\n");
					}

					//(6-0)CM Info 정보
					for (PsaManifestCmInfoVO psaManifestCmInfoVO : dbDao.searchCmInfo(bkgNo)) {
						flatFileContents.append("{CM_INFO").append("\n");
						flatFileContents.append("CM_SEQ:").append(psaManifestCmInfoVO.getCntrMfSeq()).append("\n");
						flatFileContents.append("CM_PKG:").append(psaManifestCmInfoVO.getPckQty()).append("\n");
						flatFileContents.append("CM_PKG_UNIT:").append(psaManifestCmInfoVO.getCstmsPckTpCd()).append("\n");
						flatFileContents.append("CM_WGT:").append(psaManifestCmInfoVO.getCntrMfWgt()).append("\n");
						flatFileContents.append("CM_MEA:").append(psaManifestCmInfoVO.getMeasQty()).append("\n");
						flatFileContents.append("HS_CODE:").append(psaManifestCmInfoVO.getCmdtHsCd()).append("\n");
						flatFileContents.append("COMMODITY_CD:").append(psaManifestCmInfoVO.getCommodityCd()).append("\n");
						flatFileContents.append("CM_CNTRNBR:").append(psaManifestCmInfoVO.getCntrNo()).append("\n");

						//(6-2)CM Description 정보
						if (!"".equals(psaManifestCmInfoVO.getCntrMfMkDesc())) {
							String[] cntrMfMkDescArr = psaManifestCmInfoVO.getCntrMfMkDesc().split("\\r\\n|\\n\\r|\\n|\\r");
							for (int idx=0; idx < cntrMfMkDescArr.length; idx++) {
								while(cntrMfMkDescArr[idx].length() > DESC_CNT_LIMIT) {
									flatFileContents.append("{CM_DESC").append("\n");
									flatFileContents.append("CM_DESC:").append(cntrMfMkDescArr[idx].substring(0, DESC_CNT_LIMIT)).append("\n");
									flatFileContents.append("}CM_DESC").append("\n");
									cntrMfMkDescArr[idx] = cntrMfMkDescArr[idx].substring(DESC_CNT_LIMIT);
									cmDescLoopCnt++;
									if (cmDescLoopCnt >= DESC_CNT_LOOP_CNT) break;
								}
								if (cmDescLoopCnt >= DESC_CNT_LOOP_CNT) break;
								flatFileContents.append("{CM_DESC").append("\n");
								flatFileContents.append("CM_DESC:").append(cntrMfMkDescArr[idx]).append("\n");
								flatFileContents.append("}CM_DESC").append("\n");
								cmDescLoopCnt++;
							}
						}
						flatFileContents.append("}CM_INFO").append("\n");
					}

					//(9)Container 정보
					for (PsaManifestCntrInfoVO psaManifestCntrInfoVO : dbDao.searchCntrInfo(bkgNo)) {
						String cntrNo = psaManifestCntrInfoVO.getCntrNo();
						flatFileContents.append("{CNTR_INFO").append("\n");
						flatFileContents.append("CNTRNBR:").append(cntrNo).append("\n");
						flatFileContents.append("CNTRTYPE:").append(psaManifestCntrInfoVO.getCntrTpszCd()).append("\n");
						flatFileContents.append("CNTR_FM_IND:").append(psaManifestCntrInfoVO.getCgoCd()).append("\n");
						flatFileContents.append("CNTR_PKG:").append(psaManifestCntrInfoVO.getPckQty()).append("\n");
						flatFileContents.append("CNTRWGT:").append(psaManifestCntrInfoVO.getCntrWgt()).append("\n");
						flatFileContents.append("CNTRWGT_UNIT:").append(psaManifestCntrInfoVO.getWgtUtCd()).append("\n");
						flatFileContents.append("CNTRMEA:").append(psaManifestCntrInfoVO.getMeasQty()).append("\n");
						flatFileContents.append("CNTRMEA_UNIT:").append(psaManifestCntrInfoVO.getMeasUtCd()).append("\n");

						//(6-1)Danger Goods 정보
						for (PsaManifestDgGoodsInfoVO psaManifestDgGoodsInfoVO : dbDao.searchDgGoodsInfo(bkgNo, cntrNo)) {
							flatFileContents.append("{DANGER").append("\n");
							flatFileContents.append("HAZARD_CD:").append(psaManifestDgGoodsInfoVO.getHazardCd()).append("\n");
							flatFileContents.append("UNDG_NO:").append(psaManifestDgGoodsInfoVO.getUndgNo()).append("\n");
							flatFileContents.append("FLASH_POINT:").append(psaManifestDgGoodsInfoVO.getFlashPoint()).append("\n");
							flatFileContents.append("}DANGER").append("\n");
						}

						//(10)Container Seal 정보
						for (PsaManifestCntrSealNoInfoVO psaManifestCntrSealNoInfoVO : dbDao.searchCntrSealNoInfo(bkgNo, cntrNo)) {
							flatFileContents.append("{CNTR_SEAL_NO").append("\n");
							flatFileContents.append("SEALNBR:").append(psaManifestCntrSealNoInfoVO.getSealnbr()).append("\n");
							flatFileContents.append("}CNTR_SEAL_NO").append("\n");
						}

						flatFileContents.append("}CNTR_INFO").append("\n");
					}
					flatFileContents.append("}BL_INFO").append("\n");


					// 전송할 FlatFile 수집
					CompleteFlatFile.append(flatFileContents);


					// 전송결과 저장
					BkgCstmsSgpSndLogVO bkgCstmsSgpSndLogVO = new BkgCstmsSgpSndLogVO();
					bkgCstmsSgpSndLogVO.setSgpSndLogId("PSAIMP");
					bkgCstmsSgpSndLogVO.setSndDt(bookingUtil.searchLocalTime(account.getCnt_cd() + account.getOfc_cd().substring(0, 3)));
					bkgCstmsSgpSndLogVO.setLogSeq(psaVslInfoVO.getStatus());
					bkgCstmsSgpSndLogVO.setOfcCd(account.getOfc_cd());
					bkgCstmsSgpSndLogVO.setVslCd(vvd.substring(0, 4));
					bkgCstmsSgpSndLogVO.setSkdVoyNo(vvd.substring(4, 8));
					bkgCstmsSgpSndLogVO.setSkdDirCd(vvd.substring(8, 9));
					bkgCstmsSgpSndLogVO.setPodCd(psaManifestListBlInfoVO.getPodCd());
					bkgCstmsSgpSndLogVO.setBlNo(blNo);
					bkgCstmsSgpSndLogVO.setEdiSndMsgCtnt(flatFileBodyTop.toString() + flatFileContents.toString());
					bkgCstmsSgpSndLogVO.setEdiRefId(flatFileHeader.substring(62).trim());
					bkgCstmsSgpSndLogVO.setCreUsrId(account.getUsr_id());
					bkgCstmsSgpSndLogVO.setUpdUsrId(account.getUsr_id());
					bkgCstmsSgpSndLogVOList.add(bkgCstmsSgpSndLogVO);

				} // end for (BL)


				// EDI 전송
				ediSendMessage(flatFileHeader + "\n" + CompleteFlatFile.toString(), "BKG.OPUSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE");
				// 전송 Log 저장
				if (bkgCstmsSgpSndLogVOList.size() > 0) dbDao.addCstmsSgpSndLog(bkgCstmsSgpSndLogVOList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFileContents.toString();
	}

	/**
	 * EDI 전송 처리부
	 *
	 * @param String flatFile
	 * @param String queueName
	 * @exception EventException
	 */
	private void ediSendMessage(String flatFile, String queueName)throws EventException {
		try {
			// FlatFile 이 빈 경우 SKIP 처리
			if (flatFile!=null && flatFile.trim().length()> 1) {
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile);
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
				BookingUtil utilCommand = new BookingUtil();
				FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1519 : PSA Inbound Manifest 목록 조회
	 *
	 * @param String vvd
	 * @return List<PsaIbManifestVO>
	 * @exception EventException
	 */
	public List<PsaIbManifestVO> searchPSAIbManifest(String vvd) throws EventException {
		try {
			return dbDao.searchPSAIbManifest(vvd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * VVD Name / Dir 조회
	 *
	 * @param String vvd
	 * @return PsaVvdVO
	 * @exception EventException
	 */
	public PsaVvdVO searchPSAVslNameDir(String vvd) throws EventException {
		try {
			return dbDao.searchPSAVslNameDir(vvd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1519 : Transmit - Back End Job 시작<br>
	 * PSA Inbound Manifest EDI 전송
	 *
	 * @param String vvd
	 * @param PsaIbManifestVO[] psaIbManifestVOs
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobTransmitByVvd(String vvd, PsaIbManifestVO[] psaIbManifestVOs, SignOnUserAccount account, String pgmNo) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		PSAManifestBackEndJob backEndJob = new PSAManifestBackEndJob();
		try {
			backEndJob.setVvd(vvd);
			backEndJob.setPsaIbManifestVOs(psaIbManifestVOs);
			backEndJob.setSignOnUserAccount(account);
			backEndJob.setPgmNo(pgmNo);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), pgmNo);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1519 : Transmit - Back End Job 결과<br>
	 * PSA Inbound Manifest EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitByVvd(String backEndJobKey) throws EventException {
		try {
			return(String) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}

