/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestBCImpl.java
*@FileTitle : PSAManifestBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
* -----------------------------------------------------------
* History 
* 2010.09.07 김영철 [CHM-201005693-01] Booking Fax/EDI - Yard Assign by CNTR 수정 요청 (PSA EDI 관련)
* 									 Booking Copy, Cancel 시에 자동전송되도록 수정요청.
* 2010.09.14 김영철 [ ] PSA 관련 수정 - PSA 전송시에 CNTR Count 값을 Max 6개 까지 였으나, 그것을 무시하고 무조건 전송하도록 함.
*                                 - VVD가 변경되면 전 VVD가 PSA에 등록되어있는지 확인하고 전송하도록 하였으나, 
*                                  현재 VVD가 PSA에 저장이 되어있는지 확인하도록 함.
* 2010.10.07 김영철 [ ] PSA 관련 수정 - PSA Yard 를 삭제할때 CNTR, RLS 관련 테이블을 삭제하도록 수정함.
* 2011.06.16 민정호 [CHM-201111127] Split 03-Split 08-ALPS Error 처리 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration.PSAManifestDBDAO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.BkgCstmsPsaCntrChkVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.BkgDataVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.BkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.CntrNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.CntrSpeCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.ImpStsSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.NameEtdVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaAddVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrFlatVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrNewVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgForYardVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgIfVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgQtyTmpVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdCntrTpszVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVslVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgvvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrCntVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrForYardVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaHeadVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsAddVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImportVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaJurongIfVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaMaxSubSrlNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaNextVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsForYardVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdCntrQtyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdQtyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdSerNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdSubSerNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRoCntrQtyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSerNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaShprVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSndDtVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSrlNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSubSrlNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaTpVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBKGVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBkgCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchCNTRVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchPsaCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaYardCdVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.file.FileMetaDataManager;
import com.hanjin.framework.component.util.file.ModuleMetaData;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * PSA Manifest 에 대한 Business 로직을 처리한다.
 * 
 * @author 박상훈
 * @see
 * @since J2EE 1.6
 *
 */
public class PSAManifestBCImpl extends BasicCommandSupport implements PSAManifestBC {

	
	private static final long serialVersionUID = -7874944175129888604L;
	// Database Access Object
    private transient PSAManifestDBDAO dao = null;
    
	public PSAManifestBCImpl() {
		dao = new PSAManifestDBDAO();
	}

	/**
	 * PSA Vessel 정보 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return PsaVvdVO[]
	 * @exception EventException
	 */
	public PsaVvdVO[] searchPSAVslRegist(PsaVvdVO psaVvdVO) throws EventException {

		// 조회 결과 리턴 객체 
		PsaVvdVO[] psaVvdVOs = null;
		
		try {
			psaVvdVOs = dao.searchPSAVslRegist(psaVvdVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return psaVvdVOs;
	}

	/**
	 * PSA Vessel Name 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPSAVslName(PsaVvdVO psaVvdVO) throws EventException {
		
		String psaVslNm = null;
		
		try {
			psaVslNm = dao.searchPSAVslName(psaVvdVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return psaVslNm;
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
			for(int i=0; i < psaVvdVOs.length; i++) {
				
				psaVvdVO = psaVvdVOs[i];
				
				// VALID CHECK
				validCheck1 = dao.searchVslPortSkdValidCheck(psaVvdVO.getVslCd(), psaVvdVO.getSkdVoyNo(), psaVvdVO.getSkdDirCd());
				if (validCheck1==null || validCheck1.equals("0")) 
					// "INVALID VESSEL PORT SCHEDULE" 오류 처리
					throw new EventException(new ErrorHandler("BKG01120", new String[] {}).getMessage());
				
				// Validation Check 후 MODE 를 변경함에 따라 Else if 문을 쓰지 않고 if 문으로 처리함
				
				// ADD
				if (psaVvdVO.getIbflag().equals("I")) {
					// Validation Check2
					validCheck2 = dao.searchPSAVVDValidCheck(psaVvdVO);
					
					// 결과가 0이면 진행, 0보다 크면 UPDATE 로 처리
					if (validCheck2==null || validCheck2.equals("0")) {
						// INSERT
						dao.addPSAVVDInfo(psaVvdVO);
					}else {
						// 데이터가 존재하면 Modify 할수 있도록 mode 변경 처리
						psaVvdVO.setIbflag("U");
					}
				}
				
				// MODIFY
				if (psaVvdVO.getIbflag().equals("U")) {
					dao.modifyPSAVVDInfo(psaVvdVO);
				}

				// DELETE
				if (psaVvdVO.getIbflag().equals("D")) {
					// Send Check 후 데이터가 존재하지 않는 경우만 삭제 처리
					validCheck3 = dao.searchPSASendValidCheck(psaVvdVO);
					if (validCheck3==null || validCheck3.equals("0")) dao.removePSAVVDInfo(psaVvdVO);
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
	 * @return PsaVvdVO[]
	 * @exception EventException
	 */
	public PsaVvdVO[] searchPSAVVD(String portCd, String etbDt1, String etbDt2) throws EventException {
		// 조회용 객체
		PsaVvdVO condVO = new PsaVvdVO();
		// 조회 결과
		PsaVvdVO[] psaVvdVOs = null;
		
		try {
			condVO.setPortCd(portCd);
			condVO.setEtbDt1(etbDt1);
			condVO.setEtbDt2(etbDt2);
			
			psaVvdVOs = dao.searchPSAVVD(condVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return psaVvdVOs;
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
			psaBkgVOs = dao.searchPSACNTRBKGHist(psaBkgVO);
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
			statusLog = dao.searchPSAStatusLog(bkgNo, psaSeq);
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
			psaPortVOs = dao.searchPSAPortList(portCd);
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
		PsaTpVO psaTpVO = new PsaTpVO();
		// VSL Name, Dir 조회
		PsaVvdVO psaVvdVO = new PsaVvdVO();
		// List 조회
		PsaImpStsVO[] psaImpStsVOs = null;
		// Container No 조회
		String[] cntrNOs = null;
		PsaAddVO psaAddVO = new PsaAddVO();
		// Add Container 조회
		PsaImpStsAddVO psaImpStsAddVO = null;
		// Add Container 조회 결과
		PsaImpStsVO[] addContainerVOs = null;
		// 조회결과를 담을 List
		List<PsaImpStsVO> listPsaImpStsVO = new ArrayList<PsaImpStsVO>();
		
		try {
		
			// Count 조회
			ObjectCloner.build(psaImpStsVO, psaTpVO);
			cnt = dao.searchPSATpCnt(psaTpVO);
			if (cnt==null) cnt = "0";
			
			// VVD Name Dir 조회
			ObjectCloner.build(psaImpStsVO, psaVvdVO);
			psaVvdVO = dao.searchPSAVslNameDir(psaVvdVO);
			outVO.setPsaVvdVO(psaVvdVO);
			
			// List 조회
			psaImpStsVOs = dao.searchPSAImpStsInfoList(psaImpStsVO);
			if (psaImpStsVOs!=null) listPsaImpStsVO.addAll((List<PsaImpStsVO>)Arrays.asList(psaImpStsVOs));
			
			// 조회 결과 0 건이고, TP Count 가 0보다 크면 예외처리
			if ((psaImpStsVOs==null || psaImpStsVOs.length < 1) && !cnt.equals("0")) {
				outVO = new PsaImpStsVO();
			}else {
				psaAddVO.setVslCd	(psaImpStsVO.getVslCd()		);
				psaAddVO.setSkdVoyNo(psaImpStsVO.getSkdVoyNo()	);
				psaAddVO.setSkdDirCd(psaImpStsVO.getSkdDirCd()	);
				psaAddVO.setPodCd	(psaImpStsVO.getPodCd()		);
				
				// 조회 결과 건수가 0 보다 크면
				if (psaImpStsVOs!=null && psaImpStsVOs.length > 0) {
					// 컨테이너 번호 목록 조회					
					cntrNOs = dao.searchPSAAddCNTRList(psaAddVO);
					
					// Container No 만큼 반복
					if (cntrNOs!=null) {
						List<PsaImpStsVO> psaImpStsVOList = new ArrayList<PsaImpStsVO>(); 
						for(int i=0; i < cntrNOs.length; i++) {
							psaImpStsAddVO = new PsaImpStsAddVO();
							ObjectCloner.build(psaAddVO, psaImpStsAddVO);
							psaImpStsAddVO.setCntrNo(cntrNOs[i]);
							PsaImpStsVO[] tempVOs = dao.searchPSAImpStsInfoAddList(psaImpStsAddVO);
							if (tempVOs!=null && tempVOs.length > 0) psaImpStsVOList.add(tempVOs[0]);							
						}
						addContainerVOs = psaImpStsVOList.toArray(new PsaImpStsVO[0]);
					}
				}else {
					// 조회 결과 건수가 0건인 경우
					psaImpStsAddVO = new PsaImpStsAddVO();
					ObjectCloner.build(psaAddVO, psaImpStsAddVO);
					psaImpStsAddVO.setCntrNo(null);
					addContainerVOs = dao.searchPSAImpStsInfoAddList(psaImpStsAddVO);
					if (addContainerVOs!=null) {
						List<PsaImpStsVO> psaImpStsVOList = new ArrayList<PsaImpStsVO>();
						for(int i=0; i < addContainerVOs.length; i++) {
//							if (i > 0) {
//								if (addContainerVOs[i].getCntrNo().equals(addContainerVOs[i-1].getCntrNo())) {
//									continue;
//								}	
//							}
							psaImpStsVOList.add(addContainerVOs[i]);
						}
						
						addContainerVOs = psaImpStsVOList.toArray(new PsaImpStsVO[0]);
					}
				}
				
				// TS 판단 후 LIST에 추가 
				if (addContainerVOs!=null) {
					for(int i=0; i < addContainerVOs.length; i++) {
						if (addContainerVOs[i]==null) continue;
						if (addContainerVOs[i].getVslCd().equals(addContainerVOs[i].getNextVslCd()) && 
							addContainerVOs[i].getSkdVoyNo().equals(addContainerVOs[i].getNextSkdVoyNo()) &&
							addContainerVOs[i].getSkdDirCd().equals(addContainerVOs[i].getNextSkdDirCd())) {
							addContainerVOs[i].setTsTpCd("L");
						}
					}
				}
				if (addContainerVOs!=null && addContainerVOs.length > 0)	listPsaImpStsVO.addAll(Arrays.asList(addContainerVOs));
				
				// 결과 객체에 담기
				outVO.setListPsaImpStsVO(listPsaImpStsVO);
			}
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return outVO;
	}

	/**
	 * PSA Import Status I/F 추가/수정/삭제 처리
	 * @param psaImpStsVOs
	 * @exception EventException
	 */
	public void managePSAImpSts(PsaImpStsVO[] psaImpStsVOs) throws EventException {
		
		// Container Validation Check Count
		String cntrCnt = "0";
		// Vessel validation Check Count
		String vslCnt  = "0";
		
		try {

			// SEARCH VSL COUNT
			vslCnt = dao.searchVslCount(psaImpStsVOs[0].getVslCd(), psaImpStsVOs[0].getSkdVoyNo(), psaImpStsVOs[0].getSkdDirCd());
			// 결과 건수가 1건 이하인 경우 예외처리
			if (vslCnt==null || vslCnt.compareTo("1") < 0 ) {
				throw new EventException(new ErrorHandler("BKG01122", new String[] { psaImpStsVOs[0].getVslCd()+psaImpStsVOs[0].getSkdVoyNo()+psaImpStsVOs[0].getSkdDirCd() } ).getMessage());
			}
//Thread.sleep(30000);
			// GRID LOOP
			for(int i=0; i < psaImpStsVOs.length; i++) {
				
				// SEARCH CONTAINER COUNT
				cntrCnt = dao.searchCNTRCount(psaImpStsVOs[i].getVslCd(), psaImpStsVOs[i].getSkdVoyNo(), psaImpStsVOs[i].getSkdDirCd(), psaImpStsVOs[i].getCntrNo());
				// 결과 건수가 1건 이하인 경우 예외처리
				if (cntrCnt==null || cntrCnt.compareTo("1") < 0) {
					throw new EventException(new ErrorHandler("BKG01121", new String[] { psaImpStsVOs[i].getCntrNo() } ).getMessage());						
				}
				
				// 작업 구분에 따른 처리 (I:추가 , U:수정, D:삭제)
				if (psaImpStsVOs[i].getIbflag().equals("I")) {
					// INSERT
					dao.addPSAImpStsInfo(psaImpStsVOs[i]);
				}else if (psaImpStsVOs[i].getIbflag().equals("U")) {
					// UPDATE
					dao.modifyPSAImpStsInfo(psaImpStsVOs[i]);
				}else if (psaImpStsVOs[i].getIbflag().equals("D")) {
					// DELETE					
					dao.removePSAImpStsInfo(psaImpStsVOs[i]);
					dao.removePSAImpStsSpclInfo(psaImpStsVOs[i]);
				}
				
			}// END GRID LOOP
			
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
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
			outVO = dao.searchPSAImpStsSpclCgo(impStsSpclCgoVO);
			// 조회 결과가 NULL 이면 BKG 에서 조회
			if (outVO==null) outVO = dao.searchBKGImpStsSpclCgo(impStsSpclCgoVO);
			
			if (outVO==null) {
				throw new EventException(new ErrorHandler("BKG00889").getMessage());
			}
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
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
				if(dao.searchPKPSAImpStsSpclCgo(impStsSpclCgoVO)==0){
					dao.addPSAImpStsSpclCgo(impStsSpclCgoVO);
				}
			}else if (impStsSpclCgoVO.getTypeCd().equals("U")) {
				// UPDATE
				dao.modifyPSAImpStsSpclCgo(impStsSpclCgoVO);
			}else if (impStsSpclCgoVO.getTypeCd().equals("D")) {
				// DELETE
				dao.removePSAImpStsSpclCgo(impStsSpclCgoVO);
			}
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
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
		String ediHeader = null;
		// BOOKING UTIL
		BookingUtil bookingUtil = new BookingUtil();
		// EDI 전송용 객체
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		FlatFileAckVO flatFileAckVO = null;
		
		// Head 조회용 객체
		PsaHeadVO psaHeadVO = new PsaHeadVO();
		// Container 조회용 객체
		PsaCntrVO[] psaCntrVOs = null;
		PsaCntrVO psaCntrVO = new PsaCntrVO();

		try {

			// EDI Header 조회
			ediHeader = bookingUtil.searchCstmsEdiHeader("SMLM", psaImpStsVO.getReceiverId(), "TLIIMP");
			flatFile.append(ediHeader).append("\n");
			
			// FlatFile Header 조회
			ObjectCloner.build(psaImpStsVO, psaHeadVO);
			psaHeadVO = dao.searchPSAHeadFlatFile(psaHeadVO);
			if (psaHeadVO==null) {
				throw new EventException(new ErrorHandler("BKG00889").getMessage());
			}
			// Header 만들기
			flatFile.append("PV.PV_VSL_NM:").append(psaHeadVO.getPsaVslNm()).append("\n");
			flatFile.append("PV.SKD_VOYAGE_NO:").append(psaHeadVO.getSkdVoyNo()).append("\n");
			flatFile.append("PV.SKD_DIR_CD:").append(psaHeadVO.getSkdDirCd()).append("\n");
			flatFile.append("PV.PV_VOY_DIR:").append(psaHeadVO.getPsaVoyDirCd()).append("\n");
			flatFile.append("VSL.VSL_ENG_NM:").append(psaHeadVO.getVslEngNm()).append("\n");
			flatFile.append("VPS.SKD_VOYAGE_NO:").append(psaHeadVO.getSkdVoyNo()).append("\n");
			flatFile.append("VPS.SKD_DIR_CD:").append(psaHeadVO.getSkdDirCd()).append("\n");
			
			// Container FlatFile 만들기
			ObjectCloner.build(psaImpStsVO, psaCntrVO);
			psaCntrVOs = dao.searchPSACNTRInfoFlatFile(psaCntrVO);
			// LOOP
			for(int i=0; i < psaCntrVOs.length; i++) {
				// flatFile 만들기
				flatFile.append("{CNTR_INFO").append("\n");
				flatFile.append("PS.PIS_INS_TP:").append(psaCntrVOs[i].getTsTpCd()).append("\n");
				flatFile.append("PS.PIS_SND_DT:").append(psaCntrVOs[i].getSndDt()).append("\n");
				flatFile.append("PS.CNTR_NO:").append(psaCntrVOs[i].getCntrNo()).append("\n");
				flatFile.append("PS.BKG_NO:").append(psaCntrVOs[i].getBkgNo()).append("\n");
				flatFile.append("PS.PIS_CNTR_ST:").append(psaCntrVOs[i].getFullMtyCd()).append("\n");
				flatFile.append("PS.PIS_WGT:").append(psaCntrVOs[i].getCntrWgt().replaceAll(",", "")).append("\n");
				flatFile.append("PS.PIS_COP:").append(psaCntrVOs[i].getCntrOprCd()).append("\n");
				flatFile.append("PS.PIS_IOP:").append(psaCntrVOs[i].getIbSltOprCd()).append("\n");
				flatFile.append("PC.PISS_RF_TEMP:").append(psaCntrVOs[i].getRcTemp()).append("\n");
				flatFile.append("PS.PIS_DG:").append(psaCntrVOs[i].getDcgoFlg()).append("\n");
				flatFile.append("PC.PISS_OD_HGT:").append(psaCntrVOs[i].getOvrDimHgt().replaceAll(",", "")).append("\n");
				flatFile.append("PC.PISS_OD_LEN_F:").append(psaCntrVOs[i].getOvrFntDimLen().replaceAll(",", "")).append("\n");
				flatFile.append("PC.PISS_OD_LEN_B:").append(psaCntrVOs[i].getOvrBakDimLen().replaceAll(",", "")).append("\n");
				flatFile.append("PC.PISS_OD_WDT_L:").append(psaCntrVOs[i].getOvrLfDimWdt().replaceAll(",", "")).append("\n");
				flatFile.append("PC.PISS_OD_WDT_R:").append(psaCntrVOs[i].getOvrRtDimWdt().replaceAll(",", "")).append("\n");
				flatFile.append("PC.PISS_HGT:").append(psaCntrVOs[i].getDimHgt().replaceAll(",","")).append("\n");
				flatFile.append("PC.PISS_WDT:").append(psaCntrVOs[i].getDimWdt().replaceAll(",","")).append("\n");
				flatFile.append("PC.PISS_LEN:").append(psaCntrVOs[i].getDimLen().replaceAll(",","")).append("\n");
				flatFile.append("PC.PISS_CGO_DESC:").append(psaCntrVOs[i].getCgoDesc()).append("\n");
				flatFile.append("PC.PISS_RS_IND:").append("\n");
				flatFile.append("PC.PISS_CFS_TP:").append(psaCntrVOs[i].getCfsTpCd()).append("\n");
				flatFile.append("PC.PISS_DEPOT_SVC:").append(psaCntrVOs[i].getDptSvcTpCd()).append("\n");
				flatFile.append("PC.PISS_VGM_IND:").append(psaCntrVOs[i].getVgmInd()).append("\n");//추가
				flatFile.append("PC.PISS_VGM_METHOD:").append(psaCntrVOs[i].getVgmMzdTpCd()).append("\n");//추가
				flatFile.append("PC.PISS_VGM_PERSON:").append(psaCntrVOs[i].getVgmVrfySigCtnt()).append("\n");//추가
				flatFile.append("PC.PISS_VGM_REF_NO:").append(psaCntrVOs[i].getVgmRefNo()).append("\n");//추가
				flatFile.append("PC.PISS_VGM_ACQ_TIME:").append(psaCntrVOs[i].getVgmVrfyDt()).append("\n");//추가
				flatFile.append("PC.PISS_PTI_TP:").append(psaCntrVOs[i].getRfCntrPreTrdInspTpCd()).append("\n");
				flatFile.append("PC.PISS_LOAD_INS:").append(psaCntrVOs[i].getStwgTpCd()).append("\n");
				flatFile.append("PS.PIS_OOP:").append(psaCntrVOs[i].getObSltOprCd()).append("\n");
				flatFile.append("PS.PIS_BATCH_NO:").append(psaCntrVOs[i].getPsaBatNo()).append("\n");
				flatFile.append("PS.PIS_PORT:").append(psaCntrVOs[i].getN1stPodCd()).append("\n");
				flatFile.append("PS.POD_LOC:").append(psaCntrVOs[i].getPodCd()).append("\n");
				flatFile.append("PS.POL_LOC:").append(psaCntrVOs[i].getPolCd()).append("\n");
				flatFile.append("PC.PISS_DSCH_OVS:").append(psaCntrVOs[i].getDchgOvrSzFlg()).append("\n");
				flatFile.append("PC.PISS_DIR_DEL:").append(psaCntrVOs[i].getDirDeFlg()).append("\n");
				flatFile.append("PS.PIS_SEAL_NO:").append(psaCntrVOs[i].getCntrSealNo()).append("\n");
				flatFile.append("PV.2ND_PV_VSL_NM:").append(psaCntrVOs[i].getPsaVslNm()).append("\n");
				flatFile.append("PV.2ND_PV_VOY_DIR:").append(psaCntrVOs[i].getPsaVoyDirCd()).append("\n");
				flatFile.append("}CNTR_INFO").append("\n");
			}
			
			// EDI 전송
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_PSA.IBMMQ.QUEUE"));
			flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
			  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			
			// 전송결과 UPDATE
			dao.modifyPSAImpStsSndInfo(psaImpStsVO);
			
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return flatFile.toString();
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
			for(int i=0; i < psaPortVOs.length; i++) {
				
				psaPortVO = psaPortVOs[i];
				psaPortVO.setUserId(userId);
				
					// ADD
				if (psaPortVO.getIbflag().equals("I")) {
					// Validation Check1
					validCheck1 = dao.searchPSAPortExistChk(psaPortVO.getLocCd(),psaPortVO.getTmlCd());
					
					// 결과가 Null이면 진행
					if (validCheck1==null) {
						// INSERT
						dao.addPSAPortList(psaPortVO);
					}
				}
								
				// MODIFY
				if (psaPortVO.getIbflag().equals("U")) {
					dao.modifyPSAPortList(psaPortVO);
				}

				// DELETE
				if (psaPortVO.getIbflag().equals("D")) {
					dao.removePSAPortList(psaPortVO);
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
		
			vvds = dao.searchPSATsVVDList(portCd, etdDt.replaceAll("-", ""), transTp);
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return vvds;
	}

	/**
	 * PSA와 BKG 데이터(구 NIS 데이터) 간의 Unmatch List를 조회한다.
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
		String vslCd = vvd.substring(0,4);
		String voyCd = vvd.substring(4,8);
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
		
		// ALPS 조회결과 객체
		PsaUnmatchBkgCntrVO[] alpsList = null;
		PsaUnmatchBkgCntrVO psaUnmatchBkgCntrVO = new PsaUnmatchBkgCntrVO();
		PsaNextVO psaNextVO = new PsaNextVO();
		// PSA 조회결과 객체
		PsaUnmatchPsaCntrVO[] psaList = null;
		PsaUnmatchPsaCntrVO psaUnmatchPsaCntrVO = new PsaUnmatchPsaCntrVO();		
		
		try {
			
			// PSA VSL NAME ETD 조회
			NameEtdVO nameEtdVO = dao.searchPSAVslNameEtd(vslCd, voyCd, dirCd, rlyPort);
			
			// Unmatch 정보 조회
			// 1. 컨테이너 리스트 조회
			psaUnmatchCNTRVO.setVvd			(vvd		);
			psaUnmatchCNTRVO.setRlyPort		(rlyPort	);
			psaUnmatchCNTRVO.setTransTpCd	(transTpCd	);
			cntrList = dao.searchUnmatchCNTRList(psaUnmatchCNTRVO);
			// LOOP
			if (cntrList!=null) {
				for(int i=0; i < cntrList.length; i++) {
					// 컨테이너 번호
					cntrNo = cntrList[i].getCntrNo();
					// DG DETAIL 초기화
					dgDetail = "";
					// BkgNo
					bkgNo = "";
					
					// 2. ALPS Unmatch 조회
					psaUnmatchBKGVO = new PsaUnmatchBKGVO();
					psaUnmatchBKGVO.setVvd		(vvd		);
					psaUnmatchBKGVO.setRlyPort	(rlyPort	);
					psaUnmatchBKGVO.setTransTpCd(transTpCd	);
					psaUnmatchBKGVO.setCntrNo	(cntrNo		);
					psaUnmatchBKGVO = dao.searchUnmatchBKGList(psaUnmatchBKGVO);
					if (psaUnmatchBKGVO!=null) {
						bkgNo = psaUnmatchBKGVO.getBkgNo();						
					}
					
					// Import 인 경우 NEXT POD 조회
					if (transTpCd.equals("I")) psaNextVO = dao.searchNextPodVvdForImport(vvd, bkgNo);						
					
					// 3. Special DG 가 있을 경우 
					if (psaUnmatchBKGVO!=null && psaUnmatchBKGVO.getImdgClssCd().trim().equals("1")) {
						dgDetail = dao.searchPSADGDetailInfo(bkgNo, cntrNo);
					}
					
					
					// 4. PSA Unmatch 조회
					bkgCstmsPsaCntrChkVO = new BkgCstmsPsaCntrChkVO();
					bkgCstmsPsaCntrChkVO.setVvd			(vvd		);
					bkgCstmsPsaCntrChkVO.setRlyPort		(rlyPort	);
					bkgCstmsPsaCntrChkVO.setTransTpCd	(transTpCd	);
					bkgCstmsPsaCntrChkVO.setCntrNo		(cntrNo		);
					bkgCstmsPsaCntrChkVO = dao.searchUnmatchPSAList(bkgCstmsPsaCntrChkVO);
					
					// 5. 최종 결과 리스트에 셋팅
					unmatchVO = new PsaImportVO();
					unmatchVO.setBkgNo(bkgNo);
					unmatchVO.setCntrNo(cntrNo);
					if (psaUnmatchBKGVO!=null) {
						unmatchVO.setAlpsCntrTpCd	(psaUnmatchBKGVO.getCntrTpCd()			);
						unmatchVO.setAlpsCntrSzCd	(psaUnmatchBKGVO.getCntrSzCd()			);
						unmatchVO.setAlpsPortCd		(psaUnmatchBKGVO.getPortCd()			);
						unmatchVO.setAlpsSpecial	(psaUnmatchBKGVO.getSpecial() + dgDetail);
						unmatchVO.setAlpsLoad		(psaUnmatchBKGVO.getStwgCd()			);
					}
					if (bkgCstmsPsaCntrChkVO!=null) {
						unmatchVO.setPsaCntrTpCd	(bkgCstmsPsaCntrChkVO.getCntrTpCd()		);
						unmatchVO.setPsaCntrSzCd	(bkgCstmsPsaCntrChkVO.getCntrSzCd()		);
						unmatchVO.setPsaPortCd		(bkgCstmsPsaCntrChkVO.getPortCd()		);
						unmatchVO.setPsaSpecial		(bkgCstmsPsaCntrChkVO.getSpecial()		);
						unmatchVO.setPsaLoad		(bkgCstmsPsaCntrChkVO.getUndDeckTpId()	);
					}
					// 조회 결과 셋팅
					if (psaNextVO!=null) {
						unmatchVO.setNextPod(psaNextVO.getNextPod());
						unmatchVO.setNextVvd(psaNextVO.getNextVvd());
					}
					unmatchVO.setVslNm(nameEtdVO.getVslNm()		);
					unmatchVO.setEtdDt(nameEtdVO.getVpsEtdDt()	);
					unmatchVO.setEtaDt(nameEtdVO.getVpsEtaDt()	);
					
					// List 객체에 추가
					unmatchList.add(unmatchVO);
				}
			}
			
			
			// ALPS 조회
			psaUnmatchBkgCntrVO.setVvd		(vvd		);
			psaUnmatchBkgCntrVO.setRlyPort	(rlyPort	);
			psaUnmatchBkgCntrVO.setTransTpCd(transTpCd	);
			alpsList = dao.searchUnmatchBkgCntrList(psaUnmatchBkgCntrVO);
			if (alpsList!=null) {
				for(int i=0; i < alpsList.length; i++) {
					// Import 인 경우 NEXT POD 조회
					psaNextVO = null;
					if (transTpCd.equals("I")) {
						// BKG NO 재조회
						String newBkgNo = dao.searchBkgNoForNextPodVvd(vvd, alpsList[i].getCntrNo());
						if (newBkgNo!=null) alpsList[i].setBkgNo(newBkgNo);
						psaNextVO = dao.searchNextPodVvdForImport(vvd, newBkgNo);
					}
					if (psaNextVO!=null) {
						alpsList[i].setNextPod(psaNextVO.getNextPod());
						alpsList[i].setNextVvd(psaNextVO.getNextVvd());
					}
				}
			}
			
			// PSA 조회
			psaUnmatchPsaCntrVO.setVvd		(vvd		);
			psaUnmatchPsaCntrVO.setRlyPort	(rlyPort	);
			psaUnmatchPsaCntrVO.setTransTpCd(transTpCd	);
			psaList = dao.searchUnmatchPSACntrList(psaUnmatchPsaCntrVO);
			
			// 결과 객체에 담기
			outVO.setPsaImportVOs			(unmatchList.toArray(new PsaImportVO[0])	);
			outVO.setPsaUnmatchBkgCntrVOs	(alpsList									);
			outVO.setPsaUnmatchPsaCntrVOs	(psaList									);
			
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
			
			for(int i=0; i < contents.length; i++) {
				
				if (contents[i].indexOf("First Carrier") > 10) {
					firstVslNm = contents[i].substring(contents[i].indexOf(":")+2, contents[i].indexOf("/") );
				}
				
				if (contents[i].length() < 143 
				    || contents[i].startsWith("---") 
				    || contents[i].startsWith("Container_No")) continue;
		
				psaJurongIfVO = new PsaJurongIfVO();
				
				psaJurongIfVO.setVvdNm(firstVslNm);
				psaJurongIfVO.setCntrNo(contents[i].substring(0, 12).replaceAll(" ", ""));
				psaJurongIfVO.setPortCd(contents[i].substring(19,24));
				psaJurongIfVO.setCntrTpCd(contents[i].substring(65,67));
				psaJurongIfVO.setCntrSzCd(contents[i].substring(62,64));
				psaJurongIfVO.setUndDeckTpId(contents[i].substring(83,95));
				
				special = contents[i].substring(96,126).trim();
				
				if ("UD".equals(special) || "UDBW".equals(special) 
					|| "UDAB".equals(special) || "UDTS".equals(special)
					|| "UDHG".equals(special) || "OD".equals(special)
					|| "ODTS".equals(special) || "ODET".equals(special)) {
					psaJurongIfVO.setUndDeckTpId(special);
				}else {
					psaJurongIfVO.setSpecial(special);
				}
				
				list.add(psaJurongIfVO);
			}
			
		}catch(Exception ex) {
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
		
		try {
			
			// Vessel Skd Check
			vslSkdValid = dao.searchVslSkdValid(psaImportVO.getVvd());
			if (vslSkdValid==null) {
				throw new EventException(new ErrorHandler("BKG01060", new String[] {}).getMessage());
			}
			
			// DATA 삭제 처리 
			bkgCstmsPsaCntrChkVO.setVvd			(psaImportVO.getVvd()		);
			bkgCstmsPsaCntrChkVO.setRlyPort		(psaImportVO.getRlyPort()	);
			bkgCstmsPsaCntrChkVO.setTransTpCd	(psaImportVO.getTransTpCd()	);
			bkgCstmsPsaCntrChkVO.setUserId		(psaImportVO.getUserId()	);
			dao.removeUnmatchPSAList(bkgCstmsPsaCntrChkVO);
			
			// IMPORT 처리 LOOP
			for(int i=0; i < psaJurongIfVOs.length; i++) {
				// CodeConvLoc 조회
				locCdCheck = dao.searchCodeConvLoc(psaJurongIfVOs[i].getPortCd());
				// 조회결과가 없을경우
				if (locCdCheck==null) {
					// UnLocCd 조회
					unlocCd = dao.searchCodeConvUNLoc(psaJurongIfVOs[i].getPortCd());
					// 조회후 결과가 있을경우 PORT_CD 교체
					if (unlocCd!=null) psaJurongIfVOs[i].setPortCd(unlocCd);
				}
				
				// Unmatch PSA DB INSERT
				bkgCstmsPsaCntrChkVO.setCntrNo		(psaJurongIfVOs[i].getCntrNo()		);
				bkgCstmsPsaCntrChkVO.setVvdNm		(psaJurongIfVOs[i].getVvdNm()		);
				bkgCstmsPsaCntrChkVO.setPortCd		(psaJurongIfVOs[i].getPortCd()		);
				bkgCstmsPsaCntrChkVO.setCntrTpCd	(psaJurongIfVOs[i].getCntrTpCd()	);				
				bkgCstmsPsaCntrChkVO.setCntrSzCd	(psaJurongIfVOs[i].getCntrSzCd()	);
				bkgCstmsPsaCntrChkVO.setUndDeckTpId	(psaJurongIfVOs[i].getUndDeckTpId()	);
				bkgCstmsPsaCntrChkVO.setSpecial		(psaJurongIfVOs[i].getSpecial()		);
				if (bkgCstmsPsaCntrChkVO.getCntrTpCd().length() < 2 ) bkgCstmsPsaCntrChkVO.setCntrTpCd("  ");
				dao.addUnmatchPsaList(bkgCstmsPsaCntrChkVO);
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
	 * PSA EDI I/F 정보 조회
	 * @param PsaBkgIfVO psaBkgIfVO
	 * @return PsaBkgIfVO[]
	 * @throws EventException
	 */
	public PsaBkgIfVO[] searchPSAIFInfo(PsaBkgIfVO psaBkgIfVO) throws EventException {
		
		// 최종 결과 리턴 객체
		PsaBkgIfVO[] outVOs = null;
		// 사용자 이름
		String usrNm = null;
		// 메인 BKG QTY
		String mainBkgQty = null;
		
		try {
			
			usrNm = dao.searchComUser(psaBkgIfVO.getUsrId());
			
			mainBkgQty = dao.searchBkgCntrTpSzQty(psaBkgIfVO.getBkgNo());
			
			outVOs = dao.searchPSAIFInfoLast(psaBkgIfVO.getBkgNo());
			
			// 조회 결과가 없으면 BKG 조회
			if (outVOs==null || outVOs.length < 1) outVOs = dao.searchPSABKGIFInfo(psaBkgIfVO.getBkgNo());
			
			// USER NAME 셋팅
			if (outVOs!=null) {
				for(int i=0; i < outVOs.length; i++) {
					outVOs[i].setUsrNm(usrNm);
					outVOs[i].setMainBkgQty(mainBkgQty);
				}
			}
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return outVOs;
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
		// VVD 변경 여부( Y / N )
		String vvdChgInd = null;
		// 임시 변수
		String bkgNo = null;
		
		try {
			
			// 화면에서 넘어온 건수 LOOP START
			for(int i=0; i < psaBkgVOs.length; i++) {
				
				bkgNo = psaBkgVOs[i].getBkgNo();
				
				// BKG VVD 조회
				newVvd = dao.searchBkgNewVvd(bkgNo);
			
				// MAX SEQ 조회
				pbSeq = dao.searchPsaBkgMaxSeqPls(bkgNo);
				
				// MAX SEQ 가 1 이상인 경우
				if (pbSeq!=null && pbSeq.compareTo("1") > 0 ) {
					// OLD BKG VVD 조회
					oldVvd = dao.searchPsaBkgOldVvd(bkgNo, pbSeq);
					
					// OLD VVD 와 NEW VVD 가 같은 경우
					if (newVvd.equalsIgnoreCase(oldVvd)) {
						vvdChgInd = "N"; 			
						vvd_chg_or_unchg(psaBkgVOs[i], vvdChgInd, false);
					}else {
						// VVD 가 변경된 경우
						vvdChgInd = "Y";
						vvd_chg_or_unchg(psaBkgVOs[i], vvdChgInd, true);
						
						// PSA I/F BKG 코드를 D로 변경
						dao.modifyPsaBkgIFCdD(bkgNo);
						// PSA I/F Cntr 코드를 D로 변경
						dao.modifyPsaBkgCntrIFCdD(bkgNo);
						// PSA I/F RlseOrd 코드를 D로 변경
						dao.modifyPsaBkgRlseOrdIFCd(bkgNo);
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
	private void vvd_chg_or_unchg(PsaBkgVO psaBkgVO, String vvdChgInd, boolean changeType) throws Exception
	{
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
		
		PsaBkgIfVO[] psaBkgIfVOs = null;
		// PSA INFO 조회
		if ( "Y".equals(psaBkgVO.getQtyModifyFlag()) ) {	
			// Booking Qty Data 값
			psaBkgIfVOs = dao.searchPSABKGIFInfo(psaBkgVO.getBkgNo());
		} else {
			// PSA Data 값
			psaBkgIfVOs = dao.searchPSAIFInfo(psaBkgVO.getBkgNo());
			if (psaBkgIfVOs == null) psaBkgIfVOs = dao.searchPSABKGIFInfo(psaBkgVO.getBkgNo()); 			
		}
		
		// PSA BKG 데이터 조회
		BkgDataVO bkgDataVO = dao.searchBkgDataForPsaBkg(psaBkgVO.getBkgNo());
		
		// POL_CD 가 다르면 오류 처리
		if (!"SGSIN".equalsIgnoreCase(bkgDataVO.getPolCd())) 
			throw new EventException(new ErrorHandler("BKG95025", new String[] {bkgDataVO.getPolCd()}).getMessage());
		
		// Block Stowage Code 조회
		String blkStwgCd = dao.searchBlckStwgCd(psaBkgVO.getBkgNo());
		
		// BKG VVD 에서 Vessel 정보 조회
		BkgVvdInfoVO bkgVvdInfoVO = dao.searchBkgVvdInfo(psaBkgVO.getBkgNo(), bkgDataVO.getPolCd());
		
		// POD 정보 조회
		String[] pods = dao.searchBkgVvdPodCd(psaBkgVO.getBkgNo());
		// 조회 결과가 3건 이상인 경우 오류 처리
		if (pods!=null && pods.length > 3)
			throw new EventException(new ErrorHandler("BKG95026", new String[] { String.valueOf(pods.length) }).getMessage());
		
		// Shipper Name 조회
		PsaShprVO psaShprVO = dao.searchShprName(psaBkgVO.getBkgNo());
		
		// SEQ 조회
		String maxSeq = dao.searchPsaBkgMaxSeqPls(psaBkgVO.getBkgNo());
		
		// BKG_STS_CD 가 X 인경우 처리
		if ("X".equalsIgnoreCase(bkgDataVO.getBkgStsCd())) {
			pbSndInd = "D";
		}else {
			String psaUpdate = dao.searchUpdatePsaIFCd(psaBkgVO.getBkgNo());
			if (psaUpdate==null) pbSndInd = "N"; else pbSndInd = psaUpdate;
			// VVD 가 변경된 경우
			if (vvdChgInd!=null && vvdChgInd.equalsIgnoreCase("Y")) pbSndInd = "N";
		}
		
		// BKG INFO 저장
		PsaBkgInfoVO psaBkgInfoVO = new PsaBkgInfoVO();
		psaBkgInfoVO.setBkgNo		(psaBkgVO.getBkgNo()		);
		psaBkgInfoVO.setBkgSeq		(maxSeq						);
		psaBkgInfoVO.setVslCd		(bkgVvdInfoVO.getVslCd()	);
		psaBkgInfoVO.setSkdVoyNo	(bkgVvdInfoVO.getSkdVoyNo()	);
		psaBkgInfoVO.setSkdDirCd	(bkgVvdInfoVO.getSkdDirCd()	);
		psaBkgInfoVO.setPsaIfCd		(pbSndInd					);
		psaBkgInfoVO.setN1stShprNm	(psaShprVO.getShprNm1()		);
		psaBkgInfoVO.setN2ndShprNm	(psaShprVO.getShprNm2()		);
		psaBkgInfoVO.setPodCd		(bkgDataVO.getPodCd()		);
		if (pods!=null && pods.length > 0) psaBkgInfoVO.setN1stPodCd(pods[0]	);
		if (pods!=null && pods.length > 1) psaBkgInfoVO.setN2ndPodCd(pods[1]	);
		if (pods!=null && pods.length > 2) psaBkgInfoVO.setN3rdPodCd(pods[2]	);
		psaBkgInfoVO.setSndUsrId	(psaBkgVO.getSndUsrId()		);
		dao.addPsaBkgInfo(psaBkgInfoVO);
		
		// VSL INFO 조회
		PsaBkgVslVO psaBkgVslVO = null;
//		if (changeType) {
//			psaBkgVslVO = dao.searchPsaBkgVslInfo(psaBkgVO.getBkgNo(), maxSeq);
//		}else {
			psaBkgVslVO = dao.searchPsaBkgVslInfoForUnchg(psaBkgVO.getBkgNo(), maxSeq);
//		}
		
		// 조회값이 없을 경우
		if (psaBkgVslVO==null || psaBkgVslVO.getPvVslNm()==null || psaBkgVslVO.getPvVslNm().length() < 1) 
			throw new EventException(new ErrorHandler("BKG95027", new String[] {}).getMessage());
		
		
		// Quantity 조회
		PsaBkgQtyVO[] psaBkgQtyVOs = dao.searchBkgQtyInfo(psaBkgVO.getBkgNo()); 
		PsaBkgQtyVO psaBkgQtyVO = null;
		int lastInd = -1;
		// Reefer Cargo 조회용 객체
		PsaRfCgoVO psaRfCgoVO = new PsaRfCgoVO();
		PsaRfCgoVO[] psaRfCgoVOs = null;
		// Awkward Cargo 조회용 객체
		PsaAwkCgoVO psaAwkCgoVO = new PsaAwkCgoVO();
		PsaAwkCgoVO[] psaAwkCgoVOs = null;
		
		// 임시 저장용 리스트
		List<PsaBkgQtyTmpVO> psaList = new ArrayList<PsaBkgQtyTmpVO>();
		// 임시 저장용 객체
		PsaBkgQtyTmpVO psaBkgQtyTmpVO = null;
		
		for(int i=0; i < psaBkgQtyVOs.length; i++) {
			psaBkgQtyVO = psaBkgQtyVOs[i];
			
			if (psaBkgQtyVO.getCntrtsCd().substring(0,1).equalsIgnoreCase("R")) {
				// RF CGO INFO 조회
				psaRfCgoVO.setBkgNo		(psaBkgVO.getBkgNo()		);
				psaRfCgoVO.setCntrTpszCd(psaBkgQtyVO.getCntrtsCd()	);
				psaRfCgoVOs = dao.searchRfCgoInfo(psaRfCgoVO);
			}
			
			// Awkward Cargo 조회
			psaAwkCgoVO.setBkgNo		(psaBkgVO.getBkgNo()		);
			psaAwkCgoVO.setCntrTpszCd	(psaBkgQtyVO.getCntrtsCd()	);
			psaAwkCgoVOs = dao.searchAwkCgoInfo(psaAwkCgoVO);
			
			for(int j=0; j < Math.round(Double.parseDouble(psaBkgQtyVO.getQty())); j++) {
				lastInd++;
				psaBkgQtyTmpVO = new PsaBkgQtyTmpVO();
				
				psaBkgQtyTmpVO.setCntrSz	(psaBkgQtyVO.getCntrSz()	);
				psaBkgQtyTmpVO.setCntrHeight(psaBkgQtyVO.getCntrHeight());
				
				if (psaBkgQtyVO.getCntrtsCd().substring(0,1).equalsIgnoreCase("R")) {
					psaBkgQtyTmpVO.setSpeRf("Y");
					if ( j < Math.round(Double.parseDouble(psaBkgQtyVO.getRfQty()))) {
						psaBkgQtyTmpVO.setSpeRd("N");
						if(psaRfCgoVOs != null){						
							for(int k=0; k < psaRfCgoVOs.length; k++) {
								if (Double.parseDouble(psaRfCgoVOs[k].getRfQty()) > 0 ) {
									psaBkgQtyTmpVO.setRfTemp(psaRfCgoVOs[k].getRfTempC());
									psaRfCgoVOs[k].setRfQty(String.valueOf(Double.parseDouble(psaRfCgoVOs[k].getRfQty())-1));
									// RF_HUMID 컬럼 추가
									psaBkgQtyTmpVO.setHumidNo(psaRfCgoVOs[k].getHumidNo());
									break;
								}
							}
						}
					}else {
						psaBkgQtyTmpVO.setSpeRd("Y");
					}
				} else {
					psaBkgQtyTmpVO.setSpeRf("N");
					psaBkgQtyTmpVO.setSpeRd("N");
				}
				
				psaBkgQtyTmpVO.setOhInd("N");
				psaBkgQtyTmpVO.setOwInd("N");
				psaBkgQtyTmpVO.setOlInd("N");
				
				if ( j < Math.round(Double.parseDouble(psaBkgQtyVO.getAkQty()))) {
					if (psaAwkCgoVOs != null) {
						for(int k=0; k < psaAwkCgoVOs.length; k++) {
							if (Double.parseDouble(psaAwkCgoVOs[k].getAkQty())>0) {
								psaBkgQtyTmpVO.setOhInd(psaAwkCgoVOs[k].getAkOh());
								psaBkgQtyTmpVO.setOwInd(psaAwkCgoVOs[k].getAkOw());
								psaBkgQtyTmpVO.setOlInd(psaAwkCgoVOs[k].getAkOl());
								psaAwkCgoVOs[k].setAkQty(String.valueOf(Double.parseDouble(psaAwkCgoVOs[k].getAkQty())-1));
								break;
							}
						}
					}
				}
				
				if ( Double.compare(new Double(j), Double.parseDouble(psaBkgQtyVO.getDgQty())) < 0 ) {
					psaBkgQtyTmpVO.setSpeDg("Y");
				}else {
					psaBkgQtyTmpVO.setSpeDg("N");
				}
				
				for(int k=0; k < psaBkgIfVOs.length; k++) {
//					if (psaBkgQtyVO.getCntrtsCd().substring(0,1).equalsIgnoreCase(psaBkgIfVOs[k].getCntrTpszCd().substring(0,1)) && Double.parseDouble(psaBkgIfVOs[k].getCntrQty())>0) {
					if (psaBkgQtyVO.getCntrtsCd().equalsIgnoreCase(psaBkgIfVOs[k].getCntrTpszCd()) && Double.parseDouble(psaBkgIfVOs[k].getCntrQty())>0 ){
						psaBkgQtyTmpVO.setCntrtsCd(psaBkgIfVOs[k].getCntrTpszCd());
						psaBkgQtyTmpVO.setYdCd(psaBkgIfVOs[k].getYdCd());
						psaBkgIfVOs[k].setCntrQty(String.valueOf(Double.parseDouble(psaBkgIfVOs[k].getCntrQty())-1));
						break;
					}
				}
				
				psaList.add(psaBkgQtyTmpVO);
			}
		}
		
		// PSA Serial 조회용 객체
		PsaSrlNoVO psaSrlNoVO = new PsaSrlNoVO();
		String psaSerialNo = null;
		String psaSubSerial = null;
		// PSA BKG 업데이트용 객체
		PsaCntrCntVO psaCntrCntVO = new PsaCntrCntVO();
		PsaBkgCntrInfoVO psaBkgCntrInfoVO = new PsaBkgCntrInfoVO();
		PsaSubSrlNoVO psaSubSrlNoVO = new PsaSubSrlNoVO();
		PsaRoCntrQtyVO psaRoCntrQtyVO = new PsaRoCntrQtyVO();
		PsaMaxSubSrlNoVO psaMaxSubSrlNoVO = new PsaMaxSubSrlNoVO();
		PsaBkgRlsOrdVO psaBkgRlsOrdVO = new PsaBkgRlsOrdVO();
		
		for(int i=0; i < psaList.size(); i++)
		{

			psaSerialNo = null;
			psaSubSerial = null;
			
			psaBkgQtyTmpVO = psaList.get(i);
			
			// PSA Serial 조회
			psaSrlNoVO.setBkgNo			(psaBkgVO.getBkgNo()			);
			psaSrlNoVO.setBkgSeq		(maxSeq							);
			psaSrlNoVO.setCntrTpszCd	(psaBkgQtyTmpVO.getCntrSz()		);
			psaSrlNoVO.setDcgoFlg		(psaBkgQtyTmpVO.getSpeDg()		);
			psaSrlNoVO.setRcFlg			(psaBkgQtyTmpVO.getSpeRf()		);
			psaSrlNoVO.setRdCgoFlg		(psaBkgQtyTmpVO.getSpeRd()		);
			psaSrlNoVO.setOvrHgtFlg		(psaBkgQtyTmpVO.getOhInd()		);
			psaSrlNoVO.setOvrWdtFlg		(psaBkgQtyTmpVO.getOwInd()		);
			psaSrlNoVO.setOvrLenFlg		(psaBkgQtyTmpVO.getOlInd()		);
			psaSrlNoVO.setRcTemp		(psaBkgQtyTmpVO.getRfTemp()		);
			psaSrlNoVO.setPbcCntrHeight	(psaBkgQtyTmpVO.getCntrHeight()	);
			psaSrlNoVO.setPbcCntrTp		(psaBkgQtyTmpVO.getCntrtsCd()	);
			psaSrlNoVO.setYdCd          (psaBkgQtyTmpVO.getYdCd()		);
			psaSerialNo = dao.searchPsaSerialNo(psaSrlNoVO);
			
			// SERIAL이 조회 된 경우
			if (psaSerialNo != null) {
				// MODIFY BKG CNTR Count
				psaCntrCntVO.setBkgNo		 (psaBkgVO.getBkgNo()			);
				psaCntrCntVO.setBkgSeq		 (maxSeq						);
				psaCntrCntVO.setPsaSerNo	 (psaSerialNo					);
				psaCntrCntVO.setPsaCntrTpszCd(psaBkgQtyTmpVO.getCntrtsCd()	);
				if (changeType) {
					dao.modifyPsaBkgCntrCnt(psaCntrCntVO);
				}else {
					dao.modifyPsaBkgCntrCntForUnchg(psaCntrCntVO);
				}
			} else {
				// SERIAL 조회 실패시 재조회
				psaSerialNo = dao.searchPsaBkgCntrMaxSerialNoPls(psaBkgVO.getBkgNo(), maxSeq);
				// ADD CNTR INFO
				psaBkgCntrInfoVO.setBkgNo			(psaBkgVO.getBkgNo()			);
				psaBkgCntrInfoVO.setBkgSeq			(maxSeq							);
				psaBkgCntrInfoVO.setPsaSerNo		(psaSerialNo					);
				psaBkgCntrInfoVO.setPsaIfCd			(pbSndInd						);
				psaBkgCntrInfoVO.setCntrTpszCd		(psaBkgQtyTmpVO.getCntrSz()		);
				psaBkgCntrInfoVO.setFullMtyCd		(bkgDataVO.getBkgCgoTpCd()		);
				psaBkgCntrInfoVO.setDcgoFlg			(psaBkgQtyTmpVO.getSpeDg()		);
				psaBkgCntrInfoVO.setRcFlg			(psaBkgQtyTmpVO.getSpeRf()		);
				psaBkgCntrInfoVO.setRdCgoFlg		(psaBkgQtyTmpVO.getSpeRd()		);
				psaBkgCntrInfoVO.setOvrHgtFlg		(psaBkgQtyTmpVO.getOhInd()		);
				psaBkgCntrInfoVO.setOvrWdtFlg		(psaBkgQtyTmpVO.getOwInd()		);
				psaBkgCntrInfoVO.setOvrLenFlg		(psaBkgQtyTmpVO.getOlInd()		);
				psaBkgCntrInfoVO.setRcTemp			(psaBkgQtyTmpVO.getRfTemp()		);
				psaBkgCntrInfoVO.setHumidNo			(psaBkgQtyTmpVO.getHumidNo()	);
				psaBkgCntrInfoVO.setSpclCgoDtlFlg	(bkgDataVO.getSpclHideFlg()		);
				psaBkgCntrInfoVO.setPbcCntrHeight	(psaBkgQtyTmpVO.getCntrHeight()	);
				psaBkgCntrInfoVO.setPbcCntrTp		(psaBkgQtyTmpVO.getCntrtsCd()	);
				psaBkgCntrInfoVO.setUsrId        	(psaBkgVO.getSndUsrId()			);
				dao.addPsaBkgCntrInfo(psaBkgCntrInfoVO);
			}
			
			// SUB Serial 조회			
			psaSubSrlNoVO.setBkgNo		(psaBkgVO.getBkgNo()			);
			psaSubSrlNoVO.setBkgSeq		(maxSeq							);
			psaSubSrlNoVO.setPsaSerNo	(psaSerialNo					);
			psaSubSrlNoVO.setYdCd		(psaBkgQtyTmpVO.getYdCd()		);
			psaSubSrlNoVO.setCntrTpszCd	(psaBkgQtyTmpVO.getCntrtsCd()	);
			psaSubSerial =  dao.searchSubPsaSerialNo(psaSubSrlNoVO);
			
			// Sub Serial 이 조회된 경우
			if (psaSubSerial != null) {
				// Modify Qty
				psaRoCntrQtyVO.setBkgNo			(psaBkgVO.getBkgNo()	);
				psaRoCntrQtyVO.setBkgSeq		(maxSeq					);
				psaRoCntrQtyVO.setPsaSerNo		(psaSerialNo			);
				psaRoCntrQtyVO.setSubPsaSerNo	(psaSubSerial			);
				dao.modifyPsaBkgRoCntrQty(psaRoCntrQtyVO);
			}else {
				// 재조회
				psaMaxSubSrlNoVO.setBkgNo	(psaBkgVO.getBkgNo()	);
				psaMaxSubSrlNoVO.setBkgSeq	(maxSeq					);
				psaMaxSubSrlNoVO.setPsaSerNo(psaSerialNo			);
				psaSubSerial =  dao.searchSubPsaMaxSerialNo(psaMaxSubSrlNoVO);
				// ADD RlsOrd
				psaBkgRlsOrdVO.setBkgNo			(psaBkgVO.getBkgNo()			);
				psaBkgRlsOrdVO.setBkgSeq		(maxSeq							);
				psaBkgRlsOrdVO.setPsaSerNo		(psaSerialNo					);
				psaBkgRlsOrdVO.setSubPsaSerNo	(psaSubSerial					);
				psaBkgRlsOrdVO.setPsaIfCd		(pbSndInd						);
				psaBkgRlsOrdVO.setYdCd			(psaBkgQtyTmpVO.getYdCd()		);
				psaBkgRlsOrdVO.setCntrTpszCd	(psaBkgQtyTmpVO.getCntrtsCd()	);
				psaBkgRlsOrdVO.setUsrId			(psaBkgVO.getSndUsrId()			);
				dao.addPsaBkgRlsOrd(psaBkgRlsOrdVO);
			}
		}
		
//		// PSA CNTR Count
//		double psaCntrCnt = 0;
//		long maxPbcNo = 0;
//		long addSeq = 0;
//		long lastSeq = 0;
//		double pbrQtyRest = 6;
//		long pbcNoCntrNew = 0;
//		String pbrQty = null;
//		// UPDATE 용 객체
//		PsaSerNoVO psaSerNoVO = new PsaSerNoVO();
//		PsaRlsOrdSerNoVO psaRlsOrdSerNoVO = new PsaRlsOrdSerNoVO();
//		PsaBkgCntrNewVO psaBkgCntrNewVO = new PsaBkgCntrNewVO();
//		PsaRlsOrdQtyVO psaRlsOrdQtyVO = new PsaRlsOrdQtyVO();
//		PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO = new PsaRlsOrdCntrQtyVO();
//		PsaRlsOrdSubSerNoVO psaRlsOrdSubSerNoVO = new PsaRlsOrdSubSerNoVO();
//		
//		for(int i=1; i < 100; i++) {
//			// PSA CNTR Count  조회 ( 오류사항에 대한 수정 - i 조건을 가지고 조회하여 CNTR Count 값을 가지고 오도록 함. )
////			psaCntrCnt = Double.parseDouble(dao.searchPsaBkgCntrCnt(psaBkgVO.getBkgNo(), maxSeq, psaSerialNo));
//			psaCntrCnt = Double.parseDouble(dao.searchPsaBkgCntrCnt(psaBkgVO.getBkgNo(), maxSeq, i+""));
//			
//			if ( Double.compare(psaCntrCnt, new Double(1)) < 0 ) break;
//			
//			if ( Double.compare(psaCntrCnt, new Double(6)) > 0 ) {
//				psaCntrCntVO.setBkgNo	(psaBkgVO.getBkgNo()	);
//				psaCntrCntVO.setBkgSeq	(maxSeq					);
//				psaCntrCntVO.setPsaSerNo(String.valueOf(i)		);
//				dao.modifyPsaBkgCntrCntOverSix(psaCntrCntVO);
//			}
//			
//			addSeq = (long)((psaCntrCnt - 6) / 6 );
////			if ( (long)((addSeq - 6) % 6) > 0 ) addSeq++;
//			if ( (long)((psaCntrCnt - 6) % 6) > 0 ) addSeq++;
//			
//			// MODIFY CNTR SERIAL
//			psaSerNoVO.setBkgNo		(psaBkgVO.getBkgNo()	);
//			psaSerNoVO.setBkgSeq	(maxSeq					);
//			psaSerNoVO.setAddSeq	(String.valueOf(addSeq)	);
//			psaSerNoVO.setPsaSerNo	(String.valueOf(i)		);
//			dao.modifyPsaBkgCntrSerialNo(psaSerNoVO);
//			
//			// MODIFY RLSORD SERIAL
//			ObjectCloner.build(psaSerNoVO, psaRlsOrdSerNoVO);
//			dao.modifyPsaBkgRlsOrdSerialNo(psaRlsOrdSerNoVO);
//			
//			for(int j=0; j < addSeq; j++) {
//				
//				if (j==addSeq) {
//					pbcNoCntrNew = (long)((psaCntrCnt - 6)%6);
//				}else {
//					pbcNoCntrNew = 6;
//				}
//				
//				// ADD CNTR NEW CNT
//				psaBkgCntrNewVO.setAddVal		(String.valueOf(j)				);
//				psaBkgCntrNewVO.setCntrCntNew	(String.valueOf(pbcNoCntrNew)	);
//				psaBkgCntrNewVO.setBkgNo		(psaBkgVO.getBkgNo()			);
//				psaBkgCntrNewVO.setBkgSeq		(maxSeq							);
//				psaBkgCntrNewVO.setPsaSerNo		(String.valueOf(i)				);
//				dao.addPsaBkgCntrNewCnt(psaBkgCntrNewVO);
//			}
//			
//			lastSeq = i + addSeq;
//			
//			for(int j=0; j < 100; j++) {
//				
//				if ( i > lastSeq ) break;
//				
//				// PSA RLSORD QTY 조회
//				psaRlsOrdQtyVO.setBkgNo			(psaBkgVO.getBkgNo()	);
//				psaRlsOrdQtyVO.setBkgSeq		(maxSeq					);
//				psaRlsOrdQtyVO.setPsaSerNo		(String.valueOf(i)		);
//				psaRlsOrdQtyVO.setSubPsaSerNo	(String.valueOf(j)		);
//				pbrQty = dao.searchPsaBkgRlsOrdQty(psaRlsOrdQtyVO);
//				// 없으면 break;
//				if (pbrQty==null) break;
//				
//				if ( Double.compare(Double.parseDouble(pbrQty), pbrQtyRest) >= 0 ) {
//					// MODIFY RLSORD QTY
//					psaRlsOrdCntrQtyVO.setCntrQty		(String.valueOf(pbrQtyRest)	);
//					psaRlsOrdCntrQtyVO.setBkgNo			(psaBkgVO.getBkgNo()		);
//					psaRlsOrdCntrQtyVO.setBkgSeq		(maxSeq						);
//					psaRlsOrdCntrQtyVO.setPsaSerNo		(String.valueOf(i)			);
//					psaRlsOrdCntrQtyVO.setSubPsaSerNo	(String.valueOf(j)			);
//					dao.modifyPsaBkgRlsOrdCntrQty(psaRlsOrdCntrQtyVO);
//					
//					if ( Double.compare(Double.parseDouble(pbrQty), pbrQtyRest) > 0 ) {
//						// ADD RLSORD QTY
//						psaRlsOrdCntrQtyVO.setCntrQty(String.valueOf(Double.parseDouble(pbrQty) - pbrQtyRest));
//						dao.addPsaBkgRlsOrdCntrQty(psaRlsOrdCntrQtyVO);
//						maxPbcNo = 1;
//					} else {
//						maxPbcNo = 0;
//					}
//					
//					// MODIFY RLSORD SUB Serial
//					psaRlsOrdSubSerNoVO.setAddVal1		(String.valueOf(j));
//					psaRlsOrdSubSerNoVO.setAddVal2		(String.valueOf(maxPbcNo));
//					psaRlsOrdSubSerNoVO.setBkgNo		(psaBkgVO.getBkgNo());
//					psaRlsOrdSubSerNoVO.setBkgSeq		(maxSeq);
//					psaRlsOrdSubSerNoVO.setPsaSerNo		(String.valueOf(i));
//					psaRlsOrdSubSerNoVO.setSubPsaSerNo	(String.valueOf(j));
//					dao.modifyPsaBkgRlsOrdSubSerialNo(psaRlsOrdSubSerNoVO);
//					
//					i++;
//					j = 0;
//					pbrQtyRest =6;
//				}else {
//					pbrQtyRest = pbrQtyRest - Double.parseDouble(pbrQty);
//				}
//			}
//			
//		}
		
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
		psaBkgQtyVOs = dao.searchBkgQtyCntrTpSzQty(psaBkgVO.getBkgNo()); 
		
		for(int i=0; i < psaBkgQtyVOs.length; i++) {
			
			// RlsOrd Cntr 조회
			psaBkgRlsOrdCntrVOs = dao.searchPsaBkgRlsOrdCntrInfo(psaBkgVO.getBkgNo(), maxSeq, psaBkgQtyVOs[i].getCntrtsCd());
			// 조회결과가 없으면 오류리턴
			if (psaBkgRlsOrdCntrVOs==null) throw new EventException(new ErrorHandler("BKG04021", new String[] {}).getMessage()); 
			
			roLoop = psaBkgRlsOrdCntrVOs.length;
			
			// Special Cgo 조회
			cntrSpeCgoVOs = dao.searchCntrSpeCgoInfo(psaBkgVO.getBkgNo(), psaBkgQtyVOs[i].getCntrtsCd());
			if (cntrSpeCgoVOs!=null) {
				cntrLoop = cntrSpeCgoVOs.length;
			} else {
				cntrLoop = 0;
			}
			if (cntrLoop > Integer.parseInt(psaBkgQtyVOs[i].getQty())) cntrLoop = Integer.parseInt(psaBkgQtyVOs[i].getQty());
			
			int[] aCntrCnt = new int[roLoop+1];
			String[][] aCntrNo = new String[roLoop + 1][ roLoop * cntrLoop + 1];
			
			for(int j=0; j < cntrLoop; j++) {
			
				for(k=0; k < roLoop; k++) {
					
					// 루프 탈출 조건 판단 
					if (cntrSpeCgoVOs[j].getSpeDg().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getDcgoFlg()) &&
						cntrSpeCgoVOs[j].getSpeRf().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getRcFlg()) &&
						cntrSpeCgoVOs[j].getSpeRd().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getRdCgoFlg()) &&
						cntrSpeCgoVOs[j].getSpeAk().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getAkFlg()) &&
						(cntrSpeCgoVOs[j].getAkExist().equals("N") || 
								(cntrSpeCgoVOs[j].getOhInd().equals(psaBkgRlsOrdCntrVOs[k].getOvrHgtFlg()) &&
								 cntrSpeCgoVOs[j].getOwInd().equals(psaBkgRlsOrdCntrVOs[k].getOvrWdtFlg()) &&
								 cntrSpeCgoVOs[j].getOlInd().equals(psaBkgRlsOrdCntrVOs[k].getOvrLenFlg())) &&
								 (cntrSpeCgoVOs[j].getRfExist().equals("N") || cntrSpeCgoVOs[j].getRfTemp().equalsIgnoreCase(psaBkgRlsOrdCntrVOs[k].getRcTemp())) &&
								 Double.compare(new Double(aCntrCnt[k]), Double.parseDouble(psaBkgRlsOrdCntrVOs[k].getCntrQty())) < 0 )) break; 
					
				} // END FOR K
				
				if ( k < roLoop ) {
					aCntrCnt[k]++;
					aCntrNo[k][aCntrCnt[k]-1] = cntrSpeCgoVOs[j].getCntrNo();
				}else {
					aCntrCnt[roLoop]++;
					aCntrNo[roLoop][aCntrCnt[roLoop]-1] = cntrSpeCgoVOs[j].getCntrNo();
				}
				
			} // END FOR J
			
			for(k=0; k < roLoop; k++) {
				
				rest = Math.round(Double.parseDouble(psaBkgRlsOrdCntrVOs[k].getCntrQty())) - aCntrCnt[k];
				
				for(l=0; l < rest; l++) {
					
					if (aCntrCnt[roLoop] > 0) {
						aCntrCnt[k]++;
						aCntrNo[k][aCntrCnt[k]-1] = aCntrNo[roLoop][aCntrCnt[roLoop]-1];
						aCntrNo[roLoop][aCntrCnt[roLoop]-1] = null;
						aCntrCnt[roLoop]--;
					}else {
						break;
					}
					
				} // END FOR L
				
				if (aCntrCnt[roLoop] < 1) break;
				
			} // END FOR K
			
			
			for(k=0; k < roLoop; k++) {
				
				if (aCntrCnt[k] < 1) continue;
				
				// CNTR_NO 조회
				cntrNos = dao.searchPsaBkgCntrNo(psaBkgVO.getBkgNo(), maxSeq, psaBkgRlsOrdCntrVOs[k].getPsaSerNo());
				for(l=0; l < 6; l++) {
					if (cntrNos[l]==null || cntrNos[l].length()==0) {
						cntrNos[l] = aCntrNo[k][aCntrCnt[k] -1];
						aCntrCnt[k]--;
						if (aCntrCnt[k] < 1) break;
					}
				} // END FOR L
				
				// MODIFY CNTR NO
				psaCntrNoVO.setN1stCntrNo	(cntrNos[0]								);
				psaCntrNoVO.setN2ndCntrNo	(cntrNos[1]								);
				psaCntrNoVO.setN3rdCntrNo	(cntrNos[2]								);
				psaCntrNoVO.setN4thCntrNo	(cntrNos[3]								);
				psaCntrNoVO.setN5thCntrNo	(cntrNos[4]								);
				psaCntrNoVO.setN6thCntrNo	(cntrNos[5]								);
				psaCntrNoVO.setBkgNo		(psaBkgVO.getBkgNo()					);
				psaCntrNoVO.setBkgSeq		(maxSeq									);
				psaCntrNoVO.setPsaSerNo		(psaBkgRlsOrdCntrVOs[k].getPsaSerNo()	);
				dao.modifyPsaBkgCntrNo(psaCntrNoVO);
				
			} // END FOR K
			
		} // END FOR I
		
		// VSL INFO 조회
//		PsaBkgVslVO psaBkgVslVO = null;
		psaBkgVslVO = null;
//		if (changeType) {
//			psaBkgVslVO = dao.searchPsaBkgVslInfo(psaBkgVO.getBkgNo(), maxSeq);
//		}else {
			psaBkgVslVO = dao.searchPsaBkgVslInfoForUnchg(psaBkgVO.getBkgNo(), maxSeq);
//		}
		
		
		// 조회값이 없을 경우
		if (psaBkgVslVO==null || psaBkgVslVO.getPvVslNm()==null || psaBkgVslVO.getPvVslNm().length() < 1) 
			throw new EventException(new ErrorHandler("BKG95027", new String[] {}).getMessage());
		
		// EDI Header 조회
		//ediHeader = bookingUtil.searchCstmsEdiHeader("SMLM", "PSACBI", "CBINFO");
		//flatFile.append(ediHeader).append("\n");
		
		// FLATFILE 조립
		flatFile.append("PV_VSL_NM:").append(psaBkgVslVO.getPvVslNm()).append("\n");
		flatFile.append("PV_VOY_DIR:").append(psaBkgVslVO.getPvVoyDir()).append("\n");
		flatFile.append("BKG_FI:").append(psaBkgVslVO.getBkgFi()).append("\n");
		flatFile.append("UCR_NO:").append(psaBkgVslVO.getUcrNo()).append("\n");
		flatFile.append("SHPR_NM1:").append(psaBkgVslVO.getShprNm1()).append("\n");
		flatFile.append("SHPR_NM2:").append(psaBkgVslVO.getShprNm2()).append("\n");
		flatFile.append("OP_CD:").append(psaBkgVslVO.getOpCd()).append("\n");
		flatFile.append("SO_CD:").append(psaBkgVslVO.getSoCd()).append("\n");
		
		flatFile.append("BKG_POD:").append(psaBkgVslVO.getBkgPod()).append("\n");
		flatFile.append("BKG_YDCD_POD:").append(psaBkgVslVO.getBkgYdcdPod()).append("\n");
		
		flatFile.append("POD_LOC1:").append(psaBkgVslVO.getPodLoc1()).append("\n");
		flatFile.append("POD_YDCD_LOC1:").append(psaBkgVslVO.getPodYdcdLoc1()).append("\n");
		
		flatFile.append("POD_LOC2:").append(psaBkgVslVO.getPodLoc2()).append("\n");
		flatFile.append("POD_YDCD_LOC2:").append(psaBkgVslVO.getPodYdcdLoc2()).append("\n");
		
		flatFile.append("POD_LOC3:").append(psaBkgVslVO.getPodLoc3()).append("\n");
		flatFile.append("POD_YDCD_LOC3:").append(psaBkgVslVO.getPodYdcdLoc3()).append("\n");
		
		flatFile.append("BKG_DEL:").append(bkgDataVO.getDelCd()).append("\n");
		flatFile.append("BKG_YD_CD_DEL:").append(bkgDataVO.getBkgYdCdDel()).append("\n");
		
		flatFile.append("BLK_STWG:").append(blkStwgCd).append("\n");
		flatFile.append("BKG_LANE:").append(bkgDataVO.getSlanCd()).append("\n");
		flatFile.append("DOUBLE_CALL_LANE_CHECK:").append(bkgDataVO.getDoubleCallLaneCheck()).append("\n");
	
		flatFile.append("BKG_RMK:").append(bkgDataVO.getInterRmk()).append("\n");
	
	//	System.out.println("**************************"+ psaBkgVslVO.getBkgYdcdPod() +";;;;;"+flatFile.toString());   
		
		
		// Container Info 조회
		PsaBkgCntrFlatVO[] psaBkgCntrFlatVOs = null;
		// RlsOrd 조회
		PsaBkgRlsOrdCntrTpszVO[] psaBkgRlsOrdCntrTpszVOs = null;
		if (changeType) {
			psaBkgCntrFlatVOs = dao.searchPsaBkgCntrInfo(psaBkgVO.getBkgNo(), maxSeq);
			psaBkgRlsOrdCntrTpszVOs = dao.searchPsaBkgRlsOrdCntrTpsz(psaBkgVO.getBkgNo(), maxSeq);
		}else {
			psaBkgCntrFlatVOs = dao.searchPsaBkgCntrInfoForUnchg(psaBkgVO.getBkgNo(), maxSeq);
			psaBkgRlsOrdCntrTpszVOs = dao.searchPsaBkgRlsOrdCntrTpszForUnchg(psaBkgVO.getBkgNo(), maxSeq);
		}
		
		
		
		if (psaBkgRlsOrdCntrTpszVOs!=null) {
			roLoop = psaBkgRlsOrdCntrTpszVOs.length;
		}else {
			roLoop = 0;
		}
		
		// FLATFILE 조립
		if (psaBkgCntrFlatVOs!=null) {
			
			cntrLoop = psaBkgCntrFlatVOs.length;
			
			for(int i=0; i < roLoop; i++) {
				
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
				// Reefer Humidity 추가  - 경종윤수석님 요청 ( 2010.08.18 )
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
		psaSndDtVO.setBkgNo	(psaBkgVO.getBkgNo());
		psaSndDtVO.setBkgSeq(maxSeq				);
		dao.modifyPsaBkgSndDt(psaSndDtVO);
		
		// EDI 전송
		ediHeader = bookingUtil.searchCstmsEdiHeader("SMLM", "PSACBI", "CBINFO");
		StringBuffer flatFilePsa = new StringBuffer();
		flatFilePsa.append(ediHeader).append("\n").append(flatFile);
		
		sendFlatFileVO.setFlatFile(flatFilePsa.toString());
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_PSA.IBMMQ.QUEUE"));
		flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
		if (flatFileAckVO.getAckStsCd().equals("E"))
		  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
		
		//2015.11.18 [CHM-201538758] PSA 로 Booking EDI (CBINFO)가 전송될 시, SGSINAO, SGSINAC 에서의 MT Release 를 위해 동일 Booking 정보를 SGSINAO, SGSINAC 로 추가 전송 함.
		String bkgMtyPkupYdCd = dao.searchBkgMtyPkupYdCdForPsa(psaBkgVO.getBkgNo());
		if (bkgMtyPkupYdCd != null && bkgMtyPkupYdCd.length()>0){
			String ediHeaderYd = bookingUtil.searchCstmsEdiHeader("SMLM", bkgMtyPkupYdCd, "CBINFO");
			StringBuffer flatFileYd = new StringBuffer();
			flatFileYd.append(ediHeaderYd).append("\n").append(flatFile);
			
			sendFlatFileVO.setFlatFile(flatFileYd.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_PSA.IBMMQ.QUEUE"));
			flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
			  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
		}
	}

	/**
	 * PSA BKG Yard Code 추가 / 수정 / 삭제 처리 
	 * 
	 * @param PsaYardCdVO[] psaYardCdVOs
	 * @throws EventException
	 */
	public void managePsaYardCode(PsaYardCdVO[] psaYardCdVOs) throws EventException {
		
		// 최종 결과 리턴 객체
		PsaBkgIfVO[] outVOs = null;	
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


			if ( psaYardCdVOs.length > 0 ) {
				outVOs = dao.searchPSAIFInfoLast(psaYardCdVOs[0].getBkgNo());
				
				// BKG Qty 조회
				outVOs = dao.searchPSABKGIFInfo(psaYardCdVOs[0].getBkgNo());
				
				String cntrTpszFlg = "N";
				for( int i=0; i < psaYardCdVOs.length; i++) {
					if (!psaYardCdVOs[i].getIbflag().equals("D")) {
						cntrTpszFlg = "N";
						PsaYardCdVO psaVO = new PsaYardCdVO();
						if ( list.size() == 0 ){
							psaVO.setCntrTpszCd(psaYardCdVOs[i].getCntrTpszCd());
							psaVO.setCntrQty(psaYardCdVOs[i].getCntrQty());
							list.add(psaVO);
						} else {
							for(int j=0;j< list.size(); j++){
	//							if(list.get(j)==null) break;
									if(psaYardCdVOs[i].getCntrTpszCd().equals(list.get(j).getCntrTpszCd())){
										list.get(j).setCntrQty(String.valueOf(Integer.parseInt(list.get(j).getCntrQty())+ Integer.parseInt(psaYardCdVOs[i].getCntrQty())));
										cntrTpszFlg = "Y";
										break;
									}
							}
							if ("N".equals(cntrTpszFlg)){
								psaVO.setCntrTpszCd(psaYardCdVOs[i].getCntrTpszCd());
								psaVO.setCntrQty(psaYardCdVOs[i].getCntrQty());
								list.add(psaVO);
							}
						}
					}
				}
				
				if( outVOs != null){
					
					for(int j=0; j < outVOs.length; j++) {
						bkgQtyFlag = "N";
						for(int i=0; i < list.size(); i++) {
							if ( list.get(i).getCntrTpszCd().equals(outVOs[j].getCntrTpszCd())){
	//							if ( psaYardCdVOs[i].getCntrQty().equals(outVOs[j].getCntrQty())){
								if ( 0 == Double.compare(Double.parseDouble(list.get(i).getCntrQty()), Double.parseDouble(outVOs[j].getCntrQty()))){
									bkgQtyFlag = "Y";
									break;
								}
							} 
						}
						if ( "N".equals(bkgQtyFlag)) {
							throw new EventException(new ErrorHandler("BKG06123").getMessage());
						}
					}
				}
				
			}
			
			for(int i=0; i < psaYardCdVOs.length; i++) {
				bkgQtyFlag = "N";				
				if (psaYardCdVOs[i].getIbflag().equals("I")) {
					if( outVOs != null){
						for(int j=0; j < outVOs.length; j++) {
							if ( psaYardCdVOs[i].getCntrTpszCd().equals(outVOs[j].getCntrTpszCd())){
	//							if ( psaYardCdVOs[i].getCntrQty().equals(outVOs[j].getCntrQty())){
	//							if ( 0 == Double.compare(Double.parseDouble(psaYardCdVOs[i].getCntrQty()), Double.parseDouble(outVOs[j].getCntrQty()))){
									bkgQtyFlag = "Y";
									break;
	//							}
							}
						}
					}
					if ( "N".equals(bkgQtyFlag)) {
						throw new EventException(new ErrorHandler("BKG06123").getMessage());
					}				
					
					// INSERT 처리
					maxSeq = dao.searchPsaMaxBkgSeq(psaYardCdVOs[i].getBkgNo());
					
					// VVD 조회
					psaBkgvvdInfoVO = dao.searchBkgVvdInfoForPsa(psaYardCdVOs[i].getBkgNo());
					
					// BKG INSERT
					psaBkgForYardVO.setUsrId		(psaYardCdVOs[i].getUsrId()		);
					psaBkgForYardVO.setBkgNo		(psaYardCdVOs[i].getBkgNo()		);
					psaBkgForYardVO.setBkgSeq		(maxSeq							);
					if (psaBkgvvdInfoVO!=null) {
						psaBkgForYardVO.setVslCd	(psaBkgvvdInfoVO.getVslCd()		);
						psaBkgForYardVO.setSkdVoyNo	(psaBkgvvdInfoVO.getSkdVoyNo()	);
						psaBkgForYardVO.setSkdDirCd	(psaBkgvvdInfoVO.getSkdDirCd()	);
					}
					dao.addPsaBkgForYardCd(psaBkgForYardVO);
					
					// CNTR INSERT
					psaCntrForYardVO.setUsrId(psaYardCdVOs[i].getUsrId());
					psaCntrForYardVO.setBkgNo(psaYardCdVOs[i].getBkgNo());
					psaCntrForYardVO.setBkgSeq(maxSeq);
					dao.addPsaCntrForYardCd(psaCntrForYardVO);
					
					// RLSORD INSERT
					ObjectCloner.build(psaYardCdVOs[i], psaRlsForYardVO);
					psaRlsForYardVO.setBkgSeq(maxSeq);
					dao.addPsaRlsOrdForYardCd(psaRlsForYardVO);
					
				}else if (psaYardCdVOs[i].getIbflag().equals("U")) {
					if( outVOs != null){
						for(int j=0; j < outVOs.length; j++) {
							if ( psaYardCdVOs[i].getCntrTpszCd().equals(outVOs[j].getCntrTpszCd())){
	//							if ( psaYardCdVOs[i].getCntrQty().equals(outVOs[j].getCntrQty())){
	//							if ( 0 == Double.compare(Double.parseDouble(psaYardCdVOs[i].getCntrQty()), Double.parseDouble(outVOs[j].getCntrQty()))){
									bkgQtyFlag = "Y";
									break;
	//							}
							}
						}
					}
					if ( "N".equals(bkgQtyFlag)) {
						throw new EventException(new ErrorHandler("BKG06123").getMessage());
					}	
					
					// UPDATE 처리
					ObjectCloner.build(psaYardCdVOs[i], psaRlsForYardVO);
					dao.modifyPsaRlsOrdForYardCd(psaRlsForYardVO);
					
				}else if (psaYardCdVOs[i].getIbflag().equals("D")) {
					
					// DELETE 처리
					ObjectCloner.build(psaYardCdVOs[i], psaCntrForYardVO	);
					ObjectCloner.build(psaYardCdVOs[i], psaRlsForYardVO		);
					ObjectCloner.build(psaYardCdVOs[i], psaBkgForYardVO		);
					
					dao.removePsaCntrForYardCd	(psaCntrForYardVO	);
					dao.removePsaRlsOrdForYardCd(psaRlsForYardVO	);
//					dao.removePsaBkgForYardCd	(psaBkgForYardVO	);
//					
				} // END IF 
				
			} // END FOR I

		}catch(EventException evx) {
			throw evx;	
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param PsaImpStsVO[] psaImpStsVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, PsaImpStsVO[] psaImpStsVOs, String pgmNo)
			throws EventException {
		PSAManifestBackEndJob backEndJob = new PSAManifestBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try {
			if (pgmNo.equals("ESM_BKG_0420")) {
				backEndJob.setPsaImpStsVOs(psaImpStsVOs);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "PSA I/F Status.");
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return resultStr;
	}		
	
	/**
	 * EDI 추가 전송을 위한 BKG MTY_PKUP_YD_CD 조회
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchBkgMtyPkupYdCdForPsa(String bkgNo) throws EventException {
		
		String mtyPkupYdCd = null;
		
		try {
			mtyPkupYdCd = dao.searchBkgMtyPkupYdCdForPsa(bkgNo);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return mtyPkupYdCd;
	}
	
//	private double Double(String cntrQty) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	
}
