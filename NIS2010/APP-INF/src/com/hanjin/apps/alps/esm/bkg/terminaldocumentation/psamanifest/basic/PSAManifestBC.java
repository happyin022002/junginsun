/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestBC.java
*@FileTitle : PSAManifestBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AustrailiaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.ImpStsSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgIfVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImportVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaJurongIfVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaYardCdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Inboundblmgt Business Logic Command Interface<br>
 * - NIS2010-Inboundblmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 박상훈
 * @see 
 * @since J2EE 1.6
 */

public interface PSAManifestBC {

	/**
	 * PSA Vessel 정보 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return PsaVvdVO[]
	 * @exception EventException
	 */
	public PsaVvdVO[] searchPSAVslRegist(PsaVvdVO psaVvdVO) throws EventException;
	
	/**
	 * PSA Vessel Name 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPSAVslName(PsaVvdVO psaVvdVO) throws EventException;
	
	/**
	 * PSA Vessel 정보 수정
	 * @param PsaVvdVO[] psaVvdVOs
	 * @exception EventException
	 */
	public void managePSAVVDInfo(PsaVvdVO[] psaVvdVOs) throws EventException;
	
	/**
	 * PSA Vessel Import Schedule
	 * @param String portCd
	 * @param String etbDt1
	 * @param String etbDt2
	 * @return PsaVvdVO[]
	 * @exception EventException
	 */
	public PsaVvdVO[] searchPSAVVD(String portCd, String etbDt1, String etbDt2) throws EventException;
	
	/**
	 * PSA Container Booking I/F History 조회
	 * @param PsaBkgVO psaBkgVO
	 * @return PsaBkgVO[]
	 * @exception EventException
	 */
	public PsaBkgVO[] searchPSACNTRBKGHist(PsaBkgVO psaBkgVO) throws EventException;
	
	/**
	 * PSA Container Booking I/F History Log 조회
	 * @param String bkgNo
	 * @param String psaSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchPSAStatusLog(String bkgNo, String psaSeq) throws EventException;

	/**
	 * EDI전송을 위해 Yard Code를 PSA Port로 Coversion을 위해 PSA Port조회
	 * @param String portCd
	 * @return PsaPortVO[]
	 * @exception EventException
	 */
	public PsaPortVO[] searchPSAPortList(String portCd) throws EventException;
	
	/**
	 * PSA Import Status I/F 조회
	 * @param PsaImpStsVO psaImpStsVO
	 * @return PsaImpStsVO
	 * @exception EventException
	 */
	public PsaImpStsVO searchPSAImpSts(PsaImpStsVO psaImpStsVO) throws EventException;
	
	/**
	 * PSA Import Status I/F 추가/수정/삭제 처리
	 * @param psaImpStsVOs
	 * @exception EventException
	 */
	public void managePSAImpSts(PsaImpStsVO[] psaImpStsVOs) throws EventException;
	
//	/**
//	 * PSA Import Status I/F 추가/수정/삭제 처리
//	 * @param psaImpStsVOs
//	 * @exception EventException
//	 */
//	public void managePSAImpSts(PsaImpStsVO[] psaImpStsVOs, SignOnUserAccount account) throws EventException;

	/**
	 * PSA Import Status Special Cargo의 정보를 조회
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @exception EventException
	 */
	public ImpStsSpclCgoVO searchPSAImpoStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws EventException;
	
	/**
	 * PSA Import Status Special Cargo 정보 추가/수정/삭제 처리
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @exception EventException
	 */
	public void managePSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws EventException;
	
	/**
	 * PSA Import Status EDI 전송
	 * @param PsaImpStsVO psaImpStsVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitPSAImpStsInfo(PsaImpStsVO psaImpStsVO) throws EventException;
	
	/**
	 * PSA Port 정보 수정
	 * @param PsaPortVO[] psaPortVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void managePSAPortList(PsaPortVO[] psaPortVOs,String userId) throws EventException;
	
	/**
	 * PSA TS VVD 목록 조회
	 * @param String portCd
	 * @param String etdDt
	 * @param String transTp
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPSATsVVDList(String portCd, String etdDt, String transTp) throws EventException;

	/**
	 * PSA와 BKG 데이터(구 NIS 데이터) 간의 Unmatch List를 조회한다.
	 * @param PsaUnmatchListVO psaUnmatchListVO
	 * @return PsaUnmatchListVO
	 * @exception EventException
	 */
	public PsaUnmatchListVO searchUnmatchList(PsaUnmatchListVO psaUnmatchListVO) throws EventException;
	
	/**
	 * Jurong I/F 파일 Parsing 처리 
	 * @param String jurongIf
	 * @return PsaJurongIfVO[]
	 * @exception EventException
	 */
	public PsaJurongIfVO[] parseJurongIF(String jurongIf) throws EventException;
	
	/**
	 * PSA Import 데이터 추가
	 * @param PsaImportVO psaImportVO
	 * @exception EventException
	 */
	public void manageUnmatchList(PsaImportVO psaImportVO) throws EventException;
	
	/**
	 * PSA EDI I/F 정보 조회
	 * @param PsaBkgIfVO psaBkgIfVO
	 * @return PsaBkgIfVO[]
	 * @throws EventException
	 */
	public PsaBkgIfVO[] searchPSAIFInfo(PsaBkgIfVO psaBkgIfVO) throws EventException;
	
	/**
	 * PSA BKG EDI I/F 전송
	 * 
	 * @param PsaBkgVO[] psaBkgVOs
	 * @throws EventException
	 */
	public void managePSABKG(PsaBkgVO[] psaBkgVOs) throws EventException;
	
	/**
	 * PSA BKG Yard Code 추가 / 수정 / 삭제 처리 
	 * 
	 * @param PsaYardCdVO[] psaYardCdVOs
	 * @throws EventException
	 */
	public void managePsaYardCode(PsaYardCdVO[] psaYardCdVOs) throws EventException;
	
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
			throws EventException;	
	
	/**
	 * EDI 추가 전송을 위한 BKG MTY_PKUP_YD_CD 조회
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchBkgMtyPkupYdCdForPsa(String bkgNo) throws EventException ;
}
