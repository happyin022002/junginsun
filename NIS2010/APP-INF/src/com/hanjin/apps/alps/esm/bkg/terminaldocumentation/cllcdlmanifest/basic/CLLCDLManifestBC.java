/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestBC.java
*@FileTitle : ESM_BKG_0930
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.11.10 민정호 [CHM-201114288] Container Loadign Cross-Check (KOR) 기능 추가 요청
* 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllCdlForODCYVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestEdiTerminalInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDgCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllRfAkCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllSpclCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CntrListForImportDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCrossChkCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllModifyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllRemarkVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceManifestListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.TerminalCllVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.TransmitCRCCFVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.hanjin.syscommon.common.table.BkgCstmsTmlCllDgCgoVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;

/**
 * ALPS-Terminaldocumentation Business Logic Command Interface<br>
 * - ALPS-Terminaldocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seung Min
 * @see Esm_bkg_0930EventResponse 참조
 * @since J2EE 1.6
 */

public interface CLLCDLManifestBC {
	/**
	 * POL 터미널에 전송할 Container Loading List(Korea)의 Summay 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSumDetailVO>
	 * @exception EventException
	 */
	public List<KorCllSumDetailVO> searchKorCllSummary(KorCllCondVO korCllCondVO) throws EventException;
	
	/**
	 * POL 터미널에 전송할 Container Loading List(Korea) 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllDetailVO>
	 * @exception EventException
	 */
	public List<KorCllDetailVO> searchKorCll(KorCllCondVO korCllCondVO) throws EventException;	
	
	/**
	 * POL 터미널에 전송할 Container Loading List(Korea)의 Summay 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return KorCllSpclCgoContainerVO
	 * @exception EventException
	 */
	public KorCllSpclCgoContainerVO searchKorCllSpecialCgo(KorCllCondVO korCllCondVO) throws EventException;
	
	/**
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @param KorCllCdlCondVO	korCllCdlCondVO
	 * @return KorCllCdlDetailContainerVO
	 * @exception EventException
	 */
	public KorCllCdlDetailContainerVO searchKorCllCdl(KorCllCdlCondVO korCllCdlCondVO) throws EventException;	
	
	/**
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @param KorCllCdlCondVO	korCllCdlCondVO
	 * @return List<CLLCDLManifestCllCdlForODCYVO> 
	 * @exception EventException
	 */
	public List<CLLCDLManifestCllCdlForODCYVO> searchCllCdlForODCY(KorCllCdlCondVO korCllCdlCondVO) throws EventException;	
	
	/**
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @return List<MdmCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpSzVO> searchMdmCntrTpSz() throws EventException;	
	
	/**
	 * POL 터미널에 전송할 Container Loading List 정보를 조회한다.<br>
	 * 
	 * @param CllCondVO cllCondVO
	 * @return List<CllDetailVO>
	 * @exception EventException
	 */
	public List<CllDetailVO> searchCll(CllCondVO cllCondVO) throws EventException;
	
	/**
	 * 터미널에 전송할 Container Loading List - Danger Cargo 정보를 조회한다.<br>
	 * 
	 * @param CllSpclCondVO cllSpclCondVO
	 * @return List<CllDgCgoDetailVO>
	 * @exception EventException
	 */
	public List<CllDgCgoDetailVO> searchCllDgCgo(CllSpclCondVO cllSpclCondVO) throws EventException;
	
	/**
	 * 한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Select
	 * @programId ESM_BKG_1056 - search
	 * @param String entryTp
	 * @return List<KorCllSppDetailVO>
	 * @exception EventException
	 * @author Son Yun Seuk
	 */
	public List<KorCllSppDetailVO> searchKorCllSppList(String entryTp) throws EventException;
	
	/**
	 * Container Discharging List EDI 전송을 위한 Terminal Yard Code, EDI Receiver ID, EDI Sender ID를 조회한다.<br>
	 * 
	 * @param String inPortCd
	 * @param String inListType
	 * @return List<CLLCDLManifestEdiTerminalInfoVO>
	 * @exception EventException
	 */
	public List<CLLCDLManifestEdiTerminalInfoVO> searchEdiTerminal(String inPortCd, String inListType) throws EventException;
	
	/**
	 * 터미널에 전송할 Container Loading List - Reefer, Awkward Cargo 정보를 조회한다.<br>
	 * 
	 * @param CllSpclCondVO cllSpclCondVO
	 * @return List<CllRfAkCgoDetailVO>
	 * @exception EventException
	 */
	public List<CllRfAkCgoDetailVO> searchCllRfAkCgo(CllSpclCondVO cllSpclCondVO) throws EventException;
	
	/**
	 * Container Discharging List 정보를 조회한다.<br>
	 * 
	 * @param CdlCondVO cdlCondVO
	 * @return List<CdlDetailVO>
	 * @exception EventException
	 */
	public List<CdlDetailVO> searchCdl(CdlCondVO cdlCondVO) throws EventException;
	
	/**
	 * CLL, CDL 테이블에 저장되어 있는 데이터와 비교할 NIS 데이터를 조회한다.<br>
	 * 
	 * @param CllCdlCheckCondVO cllCdlCheckCondVO
	 * @return List<CllCdlCheckListDetailVO>
	 * @exception EventException
	 */
	public List<CllCdlCheckListDetailVO> searchCllCdlCheckList(CllCdlCheckCondVO cllCdlCheckCondVO) throws EventException;	
		
	/**
	 * Booking 메인에서 Import 전송을 위한 조회<br>
	 * 
	 * @param String bkgNo
	 * @return List<CntrListForImportDetailVO>
	 * @exception EventException
	 */
	public List<CntrListForImportDetailVO> searchCntrListForImport(String bkgNo) throws EventException;	
		
	/**
	 * POL 터미널에 전송할 Container Loading List (Korea) 정보를 수정한다.<br>
	 * 
	 * @param KorCllModifyVO[] korCllModifyVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageKorCll(KorCllModifyVO[] korCllModifyVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * POL 터미널에 전송할 Container Loading List (Korea) 정보를 수정한다.<br>
	 * 
	 * @param BkgCstmsCdConvCtntVO[] bkgCstmsCdConvCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCdConvCtnt(BkgCstmsCdConvCtntVO[] bkgCstmsCdConvCtntVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VVD가 출항전에 Container Loading List를 각 Port의 Terminal에 전송하기 위해, 전송 전 자체 Table에 대상 데이터를 저장한다.<br>
	 * 
	 * @param TerminalCllVO[] terminalCllVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCllForDownload(TerminalCllVO[] terminalCllVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * POL 터미널에 전송할 Container Loading List (Korea) Remark 정보를 수정한다.<br>
	 * 
	 * @param KorCllRemarkVO korCllRemarkVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageKorCllRemark(KorCllRemarkVO korCllRemarkVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * POL 터미널에 전송할 Container Loading List 정보를 수정한다.<br>
	 * 
	 * @param CllDetailVO[] cllDetailVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCll(CllDetailVO[] cllDetailVOs, SignOnUserAccount account) throws EventException;
	

	
	/**
	 * 터미널에 전송할 Container Loading List - Danger Cargo 정보를 수정한다.<br>
	 * 
	 * @param BkgCstmsTmlCllDgCgoVO[] bkgCstmsTmlCllDgCgoVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCllDgCgo(BkgCstmsTmlCllDgCgoVO[] bkgCstmsTmlCllDgCgoVOs, SignOnUserAccount account) throws EventException;
	

	
	/**
	 * 한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Creation, Inquiry
	 * @programId ESM_BKG_1056 - manage(modify, insert)
	 * @param KorCllSppVO[] korCllSppVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 * @author Son Yun Seuk
	 */
	public void manageKorCllSppList(KorCllSppVO[] korCllSppVOs, SignOnUserAccount account) throws EventException;
	

	
	/**
	 * 터미널에 전송할 Container Loading List - Reefer, Awkward Cargo 정보를 수정한다.<br>
	 * 
	 * @param CllRfAkCgoDetailVO[] cllRfAkCgoDetailVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCllRfAkCgo(CllRfAkCgoDetailVO[] cllRfAkCgoDetailVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Container Loading List(Korea) 정보를 POL 터미널에 전송한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @param SignOnUserAccount account
	 * @return String flatFile
	 * @exception EventException
	 */
	public String transmitKorCll(KorCllCondVO korCllCondVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Flatfile 생성을 VVD 별로 할 것인지 BL 별로 할 것인지 구분<br>
	 * 
	 * @param CllCdlTransmitVO[] cllCdlTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitCllCdlGate(CllCdlTransmitVO[] cllCdlTransmitVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Container Loading/Discharging List 정보를 Terminal에 EDI 전송하기 위한 Flatfile을 생성한다.<br>
	 * 
	 * @param CllCdlTransmitVO[] cllCdlTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitCllCdl(CllCdlTransmitVO[] cllCdlTransmitVOs, SignOnUserAccount account) throws EventException;	

	/**
	 * Terminal 에 EDI 전송할 Export Container List 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String polCd
	 * @return List<ExCntrTransmitVO>
	 * @exception EventException
	 */
	public List<ExCntrTransmitVO> searchCntrExportInfo(String bkgNo, String polCd) throws EventException;
	

	/**
	 * Export Container List 정보를 Terminal 에 EDI 전송하기 위한 Flatfile을 생성한다.<br> 
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @param String RcvId
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitCntrExportEdi(ExCntrTransmitCondVO exCntrTransmitCondVO, String RcvId, SignOnUserAccount account) throws EventException;	


	/**
	 * 미주 터미널에 보낼 엑셀 형식의 데이터와 비교할 NIS 데이터를 조회한다.<br>
	 * 
	 * @param CllCdlCheckUsaCondVO cllCdlCheckUsaCondVO
	 * @return List<CllCdlCheckUsaVO>
	 * @exception EventException
	 */
	public List<CllCdlCheckUsaVO> searchCllCdlCheckForUS(CllCdlCheckUsaCondVO cllCdlCheckUsaCondVO) throws EventException;
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException 
	 */
	public String startBackEndJob(SignOnUserAccount account, KorCllCdlCondVO korCllCdlCondVO, String pgmNo)  throws EventException;	
	
	/**
	 * AnType 변경
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void receiveUdevhjsAlpsBkgCllAck(String flatFile, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVO(String object) throws EventException;	
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param CllCdlTransmitVO[] cllCdlTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @exception EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, CllCdlTransmitVO[] cllCdlTransmitVOs, String pgmNo) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param TerminalCllVO[] terminalCllVOs
	 * @param String pgmNo
	 * @return String
	 * @exception EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, TerminalCllVO[] terminalCllVOs, String pgmNo) throws EventException;	
	
	
	/**
	 * EDI 로 전송된 CLL 상의 Booking 데이터와 B/L Data Input Cross-Check 상의 Booking 데이터를 대조하여 Un-match된 항목을 보여준다.<br>
	 * 
	 * @param KorCllCrossChkCondVO korCllCrossChkCondVO
	 * @return List<KorCllCrossChkCondVO>
	 * @exception EventException
	 */
	public List<KorCllCrossChkCondVO> searchKorCllCrossCheck(KorCllCrossChkCondVO korCllCrossChkCondVO) throws EventException;	

	/**
	 *  ESM_BKG_1153 : SEARCH <br>
	 *  VVD 정보 조회<br>
	 *  
	 * @param PreAdviceVO preAdviceVO
	 * @return List<PreAdviceVvdInfoVO>
	 * @exception EventException
	 */
	public List<PreAdviceVvdInfoVO> searchPreAdviceVvdInfo(PreAdviceVO preAdviceVO) throws EventException;	
	
	/**
	 *  ESM_BKG_1153 : SEARCH01 <br>
	 *  VVD 정보 조회<br>
	 *  
	 * @param PreAdviceVO preAdviceVO
	 * @return List<PreAdviceManifestListVO>
	 * @exception EventException
	 */
	public List<PreAdviceManifestListVO> searchPreAdviceManifestList(PreAdviceVO preAdviceVO) throws EventException;
	
	/**
	 * ESM_BKG_B041 : BATCH <br>
	 * 
	 * @param List transmitCRCCFVOs
	 * @return String realFlatFile
	 * @exception EventException
	 */
	public String transmitCRCCF(List<TransmitCRCCFVO> transmitCRCCFVOs) throws EventException;
}