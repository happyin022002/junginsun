/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeBC.java
*@FileTitle : Arrival Notice Form Setting tab#1
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.04.28 박만건
* 1.0 Creation
* 2012.02.15 박성호 [TOSHIBA] EDI 312 개발요청  (CHM-201115034)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;


import java.util.List;
import java.util.Vector;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcWdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrivalNoticeSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgArrNtcAntfyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IntgCustSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.NoticeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgArrNtcCntrVO;
import com.hanjin.syscommon.common.table.BkgArrNtcDtlVO;
import com.hanjin.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.hanjin.syscommon.common.table.BkgArrNtcWdVO;
import com.hanjin.syscommon.common.table.BkgCustTmpltVO;
import com.hanjin.syscommon.common.table.BkgIbCmdtCntcVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcStupVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcVO;
import com.hanjin.syscommon.common.table.BkgMdmCrCustVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;

/**
 * ALPS-Inboundnoticemgt Business Logic Command Interface<br>
 * - ALPS-Inboundnoticemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Mangeon
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
 
public interface ArrivalNoticeBC {
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
     * Arrival Notice Form을 조회<br>
     * @author Park Mangeon
	 * @param String ofcCd Office코드
	 * @param String pod POD Code
	 * @param String agent  중국 에이전트 코드
	 * @return ArrNtcWdVO
	 * @exception EventException
	 */
	public ArrNtcWdVO searchArrNtcForm(String ofcCd , String pod , String agent) throws EventException;
	/**
     * UI-BKG_0375 Arrival Notice Form Setup<br>
     * Arrival Notice Form Data를 수정한다.<br/>
     * master 및 detail을 동시에 수정한다.<br>
     * @author Park Mangeon
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param BkgArrNtcWdDtlVO[] arrNtcWdDtls
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String setupArrNtcForm(BkgArrNtcWdVO arrNtcWd, BkgArrNtcWdDtlVO[] arrNtcWdDtls, SignOnUserAccount account) throws EventException;

	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * Arriv notice Form을 삭제한다.
	 * @param String ofcCd 오피스 코드
	 * @param String podCd 포트 코드
	 * @param String agentCd 중국 에이전트 코드
	 * @exception EventException
	 */
	public void removeArrNtcForm(String ofcCd, String podCd, String agentCd) throws EventException;

	/**
	 * [240-1]ESM_BKG_0240 Customer Main (MDM) Master 에 대한 조회 이벤트 처리<br>
	 * @param IntgCustSearchVO intgCustSearchVo
	 * @return IbCustCntcVO
	 * @exception EventException
	 */
	public IbCustCntcVO searchIntgCustCntcInfo (IntgCustSearchVO intgCustSearchVo ) throws EventException;

	/**
	 * ESM_BKG_0240 Customer Main Detail 에 대한 조회 이벤트 처리<br>
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String ofcCd
	 * @return List<IbCustCntcVO>
	 * @exception EventException
	 */
	public List<IbCustCntcVO> searchIntgCustCntcInfoByIB  (String custCntCd, String custSeq, String ofcCd) throws EventException;

	/**
	 * [0240] 저장루틴
	 * @param BkgIbCustCntcVO[] custCntc
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIntgCustCntcInfoByIB(BkgIbCustCntcVO[] custCntc, SignOnUserAccount account)
	throws EventException;
	/**
	 *  Integrated Customer Data Management(OB) Detail 조회
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<BkgCustTmpltVO>
	 * @exception EventException
	 */
	public List<BkgCustTmpltVO> searchIntgCustCntcInfoByOB  (String custCntCd, String custSeq) throws EventException;

	/**
	 *  Integrated Customer Data Management(Invoice) Detail 조회
	 * @param String custCntCd
	 * @param String custSeq
	 * @return  List<BkgMdmCrCustVO>
	 * @exception EventException
	 */
	public List<BkgMdmCrCustVO> searchIntgCustCntcInfoByInvoice  (String custCntCd, String custSeq) throws EventException;
	/**
	 *  Integrated Customer Data Management(TRO) Detail 조회
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<BkgTroActCustVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustVO> searchIntgCustCntcInfoByTRO  (String custCntCd, String custSeq) throws EventException;

	/**
	 * Arrival Information [Arrival Date] 조회
	 * [672-1]
	 * @param anSearch
	 * @return
	 * @exception EventException
	 */
	//public List<ArrNtcInfoListVO> searchArrNtcInfoList (ArrNtcSearchVO anSearch ) throws EventException;
	/**
	 * Arrival Information [Arrival Date] Paging조회
	 * [672-1]
	 * @param ArrNtcSearchVO anSearch
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcInfoListVO>
	 * @exception EventException
	 */
	public List<ArrNtcInfoListVO> searchArrNtcInfoList(ArrNtcSearchVO anSearch,SignOnUserAccount account) throws EventException;


	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation 수행을 시키고 Background Job에서 생성한 Key를 반환한다.<br>
     * @author Park Mangeon
	 * @param ArrNtcSearchVO anSearch
	 * @return String backEndJobKey
	 * @exception EventException
	 */
	public String manageArrNtcCodeValidation(ArrNtcSearchVO anSearch) throws EventException;

	/**
	 * [UI-BKG-1054_01] VVD별 POD 목록을 조회합니다.<br>
	 * @param String vvd
	 * @return List<BkgVvdVO>
	 * @exception EventException
	 */
	public List<BkgVvdVO> searchPodListByVVD(String vvd) throws EventException;

	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation 수행 후 결과중 unmatch에 해당하는 정보를 조회한다.<br>
     * @author Park Mangeon
	 * @param ArrNtcSearchVO arrNtcSearch
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO> codeValidations
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchArrNtcUnMatchCustList(ArrNtcSearchVO arrNtcSearch, SignOnUserAccount account) throws EventException;


	/**
     * UI-BKG-1054 Customer Code Validation (정규개발목록 아님)<br>
     * Customer Code Validation 수행 후 결과중 unmatch에 해당하는 정보를 조회한다.<br>
     * 수기작업용<br>
     * @author Park Mangeon
	 * @param ArrNtcSearchVO anSearch
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO>
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchManualValInfo(ArrNtcSearchVO anSearch, SignOnUserAccount account) throws EventException;

	/**
     * UI-BKG-1054 Customer Code Validation <br>
     * Customer Code Validation 수행 후 결과중 match에 해당하는 정보를 조회한다.<br>
     * @author Park Mangeon
	 * @param ArrNtcSearchVO anSearch
	 * @return List<CustCdValidationVO>
	 * @exception EventException
	 */
	public List<CustCdValidationVO> searchArrNtcMatchCustList(ArrNtcSearchVO anSearch) throws EventException;

	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * Arrival Notice Form에 등록된 POD 목록을 조회합니다. <br>
	 * @author Park Mangeon
	 * @param String ofcCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormPodList(String ofcCd) throws EventException;

	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * Arrival Notice Form에 등록된 Agent 목록을 조회합니다.<br>
	 * @author Park Mangeon
	 * @param String ofcCd
	 * @param String podCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormAgentList(String ofcCd,String podCd) throws EventException;

	/**
     * UI-BKG-1054 Customer Code Validation
     * Customer Code Validation한  Unmatch 정보를 update 한다.<br>
     * Arrival Notice master 및 Detail을 생성한다.<br>
     * @author Park Mangeon
	 * @param CustCdEvaluationVO[] custCdEvaluationVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArrNtcUnMatchCust(CustCdEvaluationVO[] custCdEvaluationVos, SignOnUserAccount account) throws EventException;

	/**
     * UI_BKG-1054 Customer Code Validation
     * Customer Code Validation작업으로 Match된 정보를 Unmatch로 변경한다.<br>
     * Arrival Notice master 와 Detail을 삭제한다.<br>
     * Match 정보를 update 한다.<br>
     * @author Park Mangeon
	 * @param CustCdEvaluationVO[] custCdEval
	 * @exception EventException
	 */
	public void cancelArrNtcCustCdVal(CustCdEvaluationVO[] custCdEval) throws EventException;

	/**
	 * BL Copy &amp; Customer Info Update<br>
	 * Arrival Notice Master와 Arrival Notice Detail을 삭제한다.<br>
	 * @author Park Mangeon
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void cancelArrNtcCustCdVal(String bkgNo) throws EventException;


	/**
     * UI-BKG-0941 Customer code Error Report<br>
     * Customer Code Error Report를 조회한다.
	 * @param ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch
	 * @return List<ArrNtcCustCodeErrLstVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustCodeErrListVO> searchArrNtcCustCodeErrReport(ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch) throws EventException;

	/**
     * UI-BKG-0941 Customer code Error Report<br>
     * Customer Code Error Rhq Report를 조회한다.
	 * @param ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch
	 * @return List<ArrNtcCustCodeErrLstVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustCodeErrListVO> searchArrNtcCustCodeErrRhqReport(ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearch) throws EventException;

	/**
     * UI-BKG-0001 Notice Sent History<br>
     * Bkg Notice History를 이용하여 Inbound Arrival Notice 정보를 추출한다.<br>
     * @author Park Mangeon
	 * @param BkgNtcSearchVO bkgNtcSearch
	 * @return List<NoticeVO>
	 * @exception EventException
	 */
	public List<NoticeVO> searchBkgNtcHis (BkgNtcSearchVO bkgNtcSearch) throws EventException;


	/**[0052] MRN & Return yard 정보를 조회한다.
	 * @param vvd
	 * @param podCd
	 * @return List<MrnRtnYdVO>
	 * @exception EventException
	 */
	public List<MrnRtnYdVO> searchArrNtcMrnRtnYd(String vvd, String podCd) throws EventException;
	/**[0052] MRN & Return yard 정보를 저장한다.
	 * @param MrnRtnYdVO[] mrnRtnYdVOS
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception DAOException
	 * @exception EventException
	 */
	public void setupArrNtcMrnRtnYd (MrnRtnYdVO[] mrnRtnYdVOS, SignOnUserAccount account) throws DAOException, Exception;
	/**
	 * [672-02]Arrival Notice 대상 Customer정보를 B/L 단위로 조회한다.
	 * @param ArrNtcSearchVO search
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcCustListVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustListVO> searchArrNtcCustList (ArrNtcSearchVO search, SignOnUserAccount account) throws EventException;
	/**
	 * [672-02]Arrival Notice 대상 Customer정보를 B/L 단위로 저장한다.
	 * @param ArrNtcCustListVO[] arrNtcCustListVOS
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyArrNtcCustList  (ArrNtcCustListVO[] arrNtcCustListVOS,SignOnUserAccount account) throws DAOException, Exception;

	/**[242]  ARRIVAL NOTICE를 받을 수화주별로 상세 정보를 조회한다.
	 * @param String bkgNo
	 * @param String custTpCd
	 * @return List<ArrNtcCustRefVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustRefVO> searchArrNtcCustInfo(String bkgNo,
			String custTpCd) throws EventException;

	/**
     * UI-BKG-0764 Customer Data Management Update History<br>
	 * 인바운드 고객정보 수정 현황을 조회한다.
	 *  @author Park Mangeon
	 *  @param  IbCustCntcHisVO ibCustCntcHis
	 *  @return List<IbCustCntcHisVO> ibCustCntcHis
	 *  @exception EventException
	 */
	public List<IbCustCntcHisVO> searchIntgCustCntcInfoHistory (IbCustCntcHisVO ibCustCntcHis) throws EventException;


	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * 조회
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public BkgArrNtcWdVO searchArrNtcBankAcct(String ofcCd) throws EventException;

	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * 수정
	 * @param BkgArrNtcWdVO arrNtcBankAcct
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public void setupArrNtcBankAcct(BkgArrNtcWdVO bkgArrNtcWdVo, SignOnUserAccount account)throws EventException;


	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * 삭제
	 * @param String ofcCd
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public void removeArrNtcBankAcct(String ofcCd)throws EventException;

	/**
	 * [672-03]추가
	 *  I/B 담당자가 업무적으로 관리하는 개인 화주 리스트를 엑셀 파일로 업로드해서 갱신하는 작업
	 * @param BkgArrNtcDtlVO bkgArrNtcDtlVo
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @exception Exception
	 */
	public void createArrNtcCustListbyUpload(BkgArrNtcDtlVO bkgArrNtcDtlVo, SignOnUserAccount account)
			throws DAOException, Exception;
	/**
	 * [672-03]조회
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @return List<ArrNtcCustUploadListVO>
	 * @exception EventException
	 */
	public List<ArrNtcCustUploadListVO> searchArrNtcCustListForUpload(ArrNtcSearchVO arrNtcSearchVo)
			throws EventException;

	/**
	 * 1020 Group A/N Remark Template<br>
	 * 조회
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public List<BkgArrNtcWdVO> searchArrNtcGrpForm(String ofcCd) throws EventException;


	/**
	 * 1020 Group A/N Remark Template<br>
	 * 추가, 삭제, 수정 - ibflag활용
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public void setupArrNtcGrpForm ( BkgArrNtcWdVO[] arrNtcWd ,SignOnUserAccount account )throws EventException;

	/**
	 * [0381]기 Setting된 A/N 발송 대상 정보 및 기 송부 실행이 완료된 A/N History정보를  검색한다.
	 * @param ArrivalNoticeSearchVO arrivalNoticeSearchVo
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcSendListVO>
	 * @exception EventException
	 */
	public List<ArrNtcSendListVO> searchArrNtcSendList(ArrivalNoticeSearchVO arrivalNoticeSearchVo,SignOnUserAccount account) throws EventException;

	/**
	 * [0381]기 Setting된 A/N 발송 대상 정보 및 기 송부 실행이 완료된 A/N History정보를  EDI를검색한다.
	 * @param ArrivalNoticeSearchVO arrivalNoticeSearchVo
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcSendListVO>
	 * @exception EventException
	 */
	public List<ArrNtcSendListVO> searchArrNtcSendListByEdi(ArrivalNoticeSearchVO arrivalNoticeSearchVo,SignOnUserAccount account) throws EventException;


	/**
	 * 1044 Add Concerned Party Pop-up
	 * 조회
	 * @param String ofcCd
     * @param String custCd
     * @param String custSeq
     * @param String custTpCd
     * @return List<BkgIbCmdtCntcVO>
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public List<BkgIbCmdtCntcVO> searchCustCmdtCntcInfo( String ofcCd , String custCd , String custSeq, String custTpCd ) throws EventException;


	/**
	 * 1044 Add Concerned Party Pop-up
	 * 추가, 삭제, 수정 - ibflag활용
	 * @param BkgIbCmdtCntcVO[] ibCmdtCntcs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author Son YunSeuk
	 */
	public void manageCustCmdtCntcInfo( BkgIbCmdtCntcVO[] ibCmdtCntcs , SignOnUserAccount account ) throws EventException;

	/**
	 * [0381] Fax 전송
	 * @param listVOS
	 * @param account
	 * @return List<BkgNtcHisVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<BkgNtcHisVO> sendArrNtcByFax(ArrNtcSendListVO[] listVOS, SignOnUserAccount account)
			throws DAOException, Exception;

	/**
	 * [0312] EDI 전송
	 * @param list
	 * @param batchFlg
	 * @param account
	 * @return List<BkgNtcHisVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BkgNtcHisVO> sendArrivaNoticeEdi(List<ArrNtcSendListVO> list,String batchFlg, SignOnUserAccount account)
	throws DAOException, Exception;

	/**
	 * [0381] E-Mail 전송
	 * @param arrNtcSendListVos
	 * @param account
	 * @return List<BkgNtcHisVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<BkgNtcHisVO> sendArrNtcByEmail(ArrNtcSendListVO[] arrNtcSendListVos, SignOnUserAccount account)
			throws DAOException, Exception;
	/**
	 * UI_BKG-0672-1
	 * Arrival Notice (Arrival Information) 저장
	 * @param BkgArrNtcVO[] vos
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void setupArrNtcInfoList(ArrNtcInfoListVO[] vos, SignOnUserAccount account)throws EventException;

	/** [0956] 조회
	 * podCd 값에 따른 분기
	 * @param String bkgNo
	 * @return List<BkgArrNtcCntrVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcCntrVO> searchArrNtcHldRmk(String bkgNo) throws EventException;
	/**
	 * [0956] 저장
	 * @param BkgArrNtcCntrVO[] vos
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void setupArrNtcHldRmk(BkgArrNtcCntrVO[] bkgArrNtcCntrVos, SignOnUserAccount account)
			throws EventException;
	/** [0946] 조회
	 * Group A/N Merge Pop-up
	 * @param ArrNtcGrpSendListVO vo
	 * @return List<ArrNtcGrpSendListVO>
	 * @exception EventException
	 */
	public List<ArrNtcGrpSendListVO> searchArrNtcGrpSendList(ArrNtcGrpSendListVO vo) throws EventException;
	/**
	 * [243] AN Setup Screen_Arrival Info. Setup에서 그룹핑된 VVD/POD별 입력되는 문구와 정보를 조회한다.
	 * @param String ofcCd
	 * @param String podCd
	 * @param String formCd
	 * @param String agent
	 * @return List<BkgArrNtcWdDtlVO>
	 * @exception EventException
	 */
	public List<BkgArrNtcWdDtlVO> searchArrNtcFormDtl(String ofcCd, String podCd, String formCd,
			String agent) throws EventException;

	/**
	 * [0946] EMail전송
	 * @param ArrNtcGrpSendVO grpSendVO
	 * @param ArrNtcGrpSendListVO[] arrNtcGrpSendLists
	 * @param SignOnUserAccount account
	 * @param Vector vEmail
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendArrNtcByGrpEml(ArrNtcGrpSendVO grpSendVO
			,ArrNtcGrpSendListVO[] arrNtcGrpSendLists
			, SignOnUserAccount account
			, Vector vEmail)
			throws EventException;
	/**
	 * [0946] fax전송
	 * @param ArrNtcGrpSendVO grpSendVO
	 * @param ArrNtcGrpSendListVO[] arrNtcGrpSendLists
	 * @param SignOnUserAccount account
	 * @param Vector vFaxNo
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendArrNtcByGrpFax(ArrNtcGrpSendVO grpSendVO
			, ArrNtcGrpSendListVO[] arrNtcGrpSendLists
			, SignOnUserAccount account
			, Vector vFaxNo)
			throws EventException;
	/**
	 * MRD ID 를 구하기위함
	 * @param arrNtcMrdSearch
	 * @return ArrNtcMrdVO
	 * @exception DAOException
	 */
	public ArrNtcMrdVO searchArrNtcMrdId(ArrNtcMrdSearchVO arrNtcMrdSearch) throws EventException;

	/**[0946] Preview 를 위함
	 * @param arrNtcGrpSendLists
	 * @param account
	 * @return String
	 * @exception DAOException
	 * @exception EventException
	 */
//	public String searchArrNtcGrpPreview(
//			ArrNtcGrpSendListVO[] arrNtcGrpSendLists, SignOnUserAccount account) throws DAOException,EventException;

	/**
	 * 1099   Integrated Customer Data Update Setup 조회
	 * @param String ofcCd
	 * @return BkgIbCustCntcStupVO
	 * @exception EventException
	 * @author
	 */
	public BkgIbCustCntcStupVO searchIntgCustCntcUpdtStupInfoByOfc(String ofcCd) throws EventException;

	/**
	 * 1099   Integrated Customer Data Update Setup 저장
	 * @param BkgIbCustCntcStupVO bkgIbCustCntcStupVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author
	 */
	public void manageIntgCustCntcUpdtStupInfoByOfc(BkgIbCustCntcStupVO bkgIbCustCntcStupVo, SignOnUserAccount account)throws EventException;



	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param ArrNtcCustListVO[] arrNtcCustListVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ArrNtcCustListVO[] arrNtcCustListVO, String pgmNo)
			throws EventException; 

	/**
	 * [0244] 조회
	 * @param bkgArrNtcAntfyVO
	 * @return List<BkgArrNtcAntfyVO>
	 * @throws EventException
	 */
	public List<BkgArrNtcAntfyVO> seachAlsoNotify(BkgArrNtcAntfyVO bkgArrNtcAntfyVO) throws EventException;


	/**
	 * [0244] 등록,수정,삭제 처리
	 * @param bkgArrNtcAntfyVOs
	 * @param account
	 * @return BkgArrNtcAntfyVO
	 * @throws EventException
	 */
	public BkgArrNtcAntfyVO setupAlsoNotify(BkgArrNtcAntfyVO[] bkgArrNtcAntfyVOs, SignOnUserAccount account) throws EventException;
}