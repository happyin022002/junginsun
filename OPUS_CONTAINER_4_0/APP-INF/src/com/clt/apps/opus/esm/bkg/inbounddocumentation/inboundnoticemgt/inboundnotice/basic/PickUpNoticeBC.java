/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeBC.java
*@FileTitle : Pick up Notice Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupCntrRtnYdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptEmlUpldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoVerifyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcFormCopyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcFormVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcHrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcManualListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisSchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupWdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgPkupCntrRtnYdVO;
import com.clt.syscommon.common.table.BkgPkupNtcPkupNoHisVO;
import com.clt.syscommon.common.table.BkgPkupNtcStupVO;

/**
 *   Inboundblmgt Business Logic Command Interface<br>
 * - Inboundblmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see Esm_bkg_0411EventResponse 참조
 * @since J2EE 1.6
 */
public interface PickUpNoticeBC {
	
	/**
	 * PickUp Notice Form에 대한 기등록된 Office별 Del 목록을 조회한다.<br>
	 * 
	 * @param String ntcSndTpCd Pickup Notice Send Type(A:Auto, M:Manual)
	 * @param String ofcCd Office Code
	 * @return List<BkgComboVO> Pickup Notice DEL Combo List
	 * @exception EventException
	 */
	public List<BkgComboVO> searchPkupNtcFormDelList (String ntcSndTpCd, String ofcCd) throws EventException;
	

	/**
	 * PickUp Notice Form에 대한 Setting 정보를 조회한다.<br>
	 * 
	 * @param String ntcSndTpCd Pickup Notice Send Type(A:Auto, M:Manual)
	 * @param String ofcCd Office Code
	 * @param String delCd DEL Code
	 * @return PkupNtcFormVO Pickup Notice Setting Information
	 * @exception EventException
	 */
	public PkupNtcFormVO searchPkupNtcForm(String ntcSndTpCd, String ofcCd, String delCd) throws EventException;
	
	
	/**
	 * PickUp Notice Form 정보를 수정 혹은 저장한다.<br>
	 * 
	 * @param String ofcCd Office Code
	 * @return PkupNtcFormVO Pickup Notice Setting Information
	 * @exception EventException
	 */
	public PkupNtcFormVO searchPkupNtcFormByManual (String ofcCd) throws EventException;
	

	/**
	 * PickUp Notice Form 정보를 수정 혹은 저장한다.<br>
	 * 
	 * @param BkgPkupNtcStupVO ntcStup Pickup Notice Setup Information
	 * @param PkupWdVO[] wds Pickup Notice Word Information
	 * @param PkupNtcHrVO[] ntcHrs Pickup Notice Hour Information
	 * @param SignOnUserAccount account User Account
	 * @exception EventException
	 */
	public void setupPkupNtcForm (BkgPkupNtcStupVO ntcStup, PkupWdVO[] wds, PkupNtcHrVO[] ntcHrs, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * PickUp Notice Form 정보를 삭제한다.<br>
	 * 
	 * @param String pkupNtcSeq
	 * @exception EventException
	 */
	public void removePkupNtcForm (String pkupNtcSeq) throws EventException;
	
	
	/**
	 * PickUp Notice Form 정보를 수정 혹은 저장한다.<br>
	 * 
	 * @param BkgPkupNtcStupVO ntcStup Pickup Notice Setup Information
	 * @param PkupWdVO[] wds Pickup Notice Word Information
	 * @param SignOnUserAccount account User Account
	 * @exception EventException
	 */
	public void setupPkupNtcFormByManual (BkgPkupNtcStupVO ntcStup, PkupWdVO[] wds, SignOnUserAccount account) throws EventException;

	
	/**
	 * Manually Pickup Notice를 송부할 대상(Container)을 Upload한 후 해당 컨테이너별 상세 정보를 조회한다.<br>
	 * 
	 * @param String[] blNo Pickup Notice Basic Information
	 * @return List<PkupNtcManualListVO>
	 * @exception EventException
	 */
	public List<PkupNtcManualListVO> searchPkupNtcListByManual(String[] blNo) throws EventException;
	
	/**
	 * Manually Upload한 컨테이너별 P/N 대상 데이타를 Setup한다.<br>
	 * 
	 * @param PkupNtcManualListVO[] pkupNtcManualLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupPkupNtcListByManual(PkupNtcManualListVO[] pkupNtcManualLists, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * PickUp Notice를 발송(Success)한 대상 및 미 발송(Fail or 누락)된 대상정보들을 조회한다.<br>
	 * 
	 * @param PkupNtcSearchVO search 검색 조건
	 * @return List<PkupNtcSendListVO>
	 * @exception EventException
	 */
	public List<PkupNtcSendListVO> searchPkupNtcSendList(PkupNtcSearchVO search) throws EventException;
	
	/**
	 * 미 발송(Fail or 누락)된 대상정보들을 조회 후 부가 정보를 수정 후 저장한다.<br>
	 * 
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPkupNtcSendList (PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException;

	/**
	 * 픽업 대상정보들을 사용자 확인을 저장한다.<br>
	 * 
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void verifyPkupNtcSendList (PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException;

	/**
	 * 미 발송(Fail or 누락)된 대상정보들을 Manual로 Pick-up Notice Fax 전송한다.
	 * 
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPkupNtcByFax(PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException;
	
	/**
	 * 미 발송(Fail or 누락)된 대상정보들을 Manual로 Pick-up Notice Email 전송한다.
	 * 
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPkupNtcByEmail(PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException;

	
	/**
	 * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지한다.
	 * 
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void stopPkupNtcSend(PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException;

	/**
	 * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지를 해지한다.
	 * 
	 * @param PkupNtcSendListVO[] pkupNtcSendLists
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void resumePkupNtcSend(PkupNtcSendListVO[] pkupNtcSendLists, SignOnUserAccount account) throws EventException;

	
	/**
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 등록, 수정,삭제한다.<br>
	 * 
	 * @param PkupCntrRtnYdVO pkupCntrRtnYd
	 * @return List<BkgPkupCntrRtnYdVO>
	 * @exception EventException
	 */
	public List<BkgPkupCntrRtnYdVO> searchPkupMtRtnCy(PkupCntrRtnYdVO pkupCntrRtnYd) throws EventException;
	
	/**
	 * Return YARD코드및 Location에 대한 등록 혹은 수정 시 Validation 체크 작업을 수행한다.
	 * 
	 * @param String chkTp
	 * @param String locCd
	 * @exception EventException
	 */
	public void checkPkupMtRtnCy(String chkTp ,String locCd) throws EventException;

	/**
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 등록, 수정,삭제한다.<br>
	 * 
	 * @param BkgPkupCntrRtnYdVO[] bkgPkupCntrRtnYds
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void setupPkupMtRtnCy(BkgPkupCntrRtnYdVO[] bkgPkupCntrRtnYds, SignOnUserAccount account) throws EventException;

	/**
	 * 기 입력된 P/N Notice Form Setup 정보를 Check한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String delCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkPkupNtcFormExist (String ofcCd, String delCd) throws EventException;	
	
	/**
	 * 기 입력된 P/N Notice Form Setup 정보를 Copy한다.<br>
	 * 
	 * @param PkupNtcFormCopyVO pkupNtcFormCopy
	 * @exception EventException
	 */
	public void copyPkupNtcForm (PkupNtcFormCopyVO pkupNtcFormCopy) throws EventException;
	
	/**
     * UI-BKG-0414 Pick-Up Notice History<br>
     * Pick-Up Notice History를 조회한다.
	 *  @author
	 *  @param PkupNtcSentHisSchVO pkupNtcSentHisSch
	 *  @return List<PkupNtcSentHisListVO>
	 *  @exception EventException
	 */
	public List<PkupNtcSentHisListVO>searchPkupNtcSentHistory(PkupNtcSentHisSchVO pkupNtcSentHisSch)throws EventException;
	
	/**
	 * Pick-up No를 수동으로 업로드하기 위해 조회<br>
	 * 
	 * @param PkupNoMnlUpldSearchVO pkupNoMnlUpldSearch
	 * @return List<PkupNoMnlUpldVO>
	 * @exception EventException
	 */
	public List<PkupNoMnlUpldVO> searchPkupNoMnlUpldList(PkupNoMnlUpldSearchVO pkupNoMnlUpldSearch) throws EventException;
	
	/**
	 * 수동으로 입력된 Pick-up No및 부가 정보 저장<br>
	 * 
	 * @param PkupNoMnlUpldVO[] pkupNoMnlUpldVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePkupNoMnlUpldList (PkupNoMnlUpldVO[] pkupNoMnlUpldVOs, SignOnUserAccount account) throws EventException; 

	/**
	 * Pick-up No를 생성/정정/삭제 이력 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ofcCd
	 * @return List<BkgPkupNtcPkupNoHisVO>
	 * @exception EventException
	 */
	public List<BkgPkupNtcPkupNoHisVO> searchPkupNoHisList(String bkgNo, String cntrNo, String ofcCd) throws EventException;

	
	/**
	 * 철도 회사로 부터 받은 e-mail Report를 분석하여 pick up No upload 관련 정보 추출<br>
	 * 
	 * @param PkupNoRptEmlUpldVO	pkupNoRptEmlUpldVO
	 * @return List<PkupNoRptVO>
	 * @exception EventException
	 */
	public List<PkupNoRptVO> searchParsedPkupNoRpt(PkupNoRptEmlUpldVO pkupNoRptEmlUpldVO) throws EventException;

		
	/**
	 * 철송 회사로 부터 e-mail을 받은 pick-up No upload 결과를 검증(Verify) 한다<br>
	 * 
	 * @param PkupNoRptVO[] pkupNoRptVOs
	 * @return PkupNoVerifyVO
	 * @exception EventException
	 */	
	public PkupNoVerifyVO searchPkupNoVerifyRpt(PkupNoRptVO[] pkupNoRptVOs) throws EventException;

	
	/**
	 * 배치 실행 <br>
	 * 
	 * @param String pgmNo
	 * @param String params
	 * @return String
	 * @exception EventException
	 */
	public String executeBatch(String pgmNo, String params) throws EventException;
	
	
	/**
	 * 배치 실행 상태 가져오기 <br>
	 * 
	 * @param String jobId
	 * @param String pgmNo
	 * @return String
	 * @exception EventException
	 */
	public String getBatchStatus(String jobId, String pgmNo) throws EventException;

	
	/**
	 * 배치 실행 여부 확인 <br>
	 * 
	 * @param String pgmNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isRunningBatch(String pgmNo) throws EventException;
	
	
	/**
	 * <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyPkupNoN1stRlseDt (String bkgNo, String cntrNo, String ofcCd) throws EventException;
	
	/**
     * Pickup Notice setting시에 eq office의 country code 가져온다.
     * @param String ofcCd 
     * @return String eqOfcCntCd
     * @exception EventException
     */
    public String searchPkupNtcEqOfcCntCd(String ofcCd) throws EventException;

}