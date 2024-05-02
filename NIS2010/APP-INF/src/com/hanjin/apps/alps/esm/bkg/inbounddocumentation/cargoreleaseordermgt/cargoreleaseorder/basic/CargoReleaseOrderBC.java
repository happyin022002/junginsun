/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderBC.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.09
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.07.09 임진영
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
* 2010.09.06 이지영 [CHM-201005721-01] [ESM-BKG] VVD별 OTS 미수금 수신
* 2011.10.13 김봉균 [CHM-201113640-01] E-DO Free Time관련 기능 추가(KT-NET)
* 2012.02.24 김보배 [CHM-201216327] [BKG] 수입 냉동화물에 대한 자가운송 규제관련(D/O, 자가운송 승인전 팝업요청)
* 2012.08.06 김보배 [CHM-201219299] [BKG] KOREA E-D/O 조회 기능 보완 요청
* 2012.12.03 조정민 [CHM-201221434] [EU Full CNTR RLS화면] 필수값 변경 (P/up date, Rls expiry date)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgPsaEdoAckSchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcBlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBlStatusVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoAsignVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPfmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPrnRmkVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoVtyDtUpdHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DubaiCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdiYardInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoCntrRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRcvrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseReportVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IndiaDoNtcSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoIssueVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorStatusVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.PsaDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.SearchEdoCntrPtyTrspVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcFocVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBlStatusVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCgoRlseVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgDoCntrVO;
import com.hanjin.syscommon.common.table.BkgDoFomVO;
import com.hanjin.syscommon.common.table.BkgDoHisVO;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgDoVO;
import com.hanjin.syscommon.common.table.BkgEdoLogVO;
import com.hanjin.syscommon.common.table.BkgFullCntrRemarkVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgOtsDtlVO;
import com.hanjin.syscommon.common.table.BkgOutstandingVO;
import com.hanjin.syscommon.common.table.BkgPsaEdoRcvLogVO;

/**
 * ALPS-cargoreleaseordermgt Business Logic Command Interface<br>
 * - ALPS-cargoreleaseordermgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lim Jin Young
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface CargoReleaseOrderBC {

	/******************************************************************************************
	    Author :Lim JinYoung Start
	*******************************************************************************************/
	    /**
	     * Cargo Release시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.<br>
	     *
	     * @param usrNm
	     * @param usrRegNo
	     * @return KorDoAttorneyVO[] attorneys
	     * @exception EventException
	     */
	    public List<KorDoAttorneyVO> searchKorDoCustList(String usrNm, String usrRegNo) throws EventException;

	    /**
	     * New Cargo Release Order에서 Update 수정되는 정보를 시간순으로 조회한다.<br>
	     *
	     * @param bkgNo : 선적예약 요청 번호
	     * @return EventResponse EsmBkg0711EventResponse
	     * @exception EventException
	     */
	    public List<DoHisVO> searchDoHistory(String bkgNo) throws EventException;

	    /**
	     * Cargo Release시 한국 지역에 한하여 사업자명(위임자 또는 수임자) 과 그 사업자등록번호를 최초 등록한다.
	     *
	     * @param KorDoAttorneyVO[] attorneys : 위임자, 수임자 목록
	     * @param SignOnUserAccount account : 로그인 사용자 정보
	     * @return int : 데이터 처리 건수
	     * @exception EventException
	     */
	    public int manageKorDoCust(KorDoAttorneyVO[] attorneys, SignOnUserAccount account) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * Cargo Release 시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.<br>
	     *
	     * @param String custType
	     * @param String custNm
	     * @param String custBizNo
	     * @return KorDoAttorneyDtlVO
	     * @exception EventException
	     */
	    public List<KorDoAttorneyDtlVO> searchKorDoAttorneyList(String custType, String custNm, String custBizNo) throws EventException;

	    /**
	     * 멀티 이벤트 처리<br>
	     * Attorney Register Pop-up 화면에 대한 멀티 이벤트 처리<br>
	     *
	     * @param KorDoAttorneyDtlVO[] attorneyDtls
	     * @param SignOnUserAccount account
	     * @return int ; 수정 개수
	     * @exception EventException
	     */
	    public int manageKorDoAttorney(KorDoAttorneyDtlVO[] attorneyDtls, SignOnUserAccount account) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * Attorney Create Pop-up 화면 수임자 위임자 사업자 번호에 대한 중복 여부 조회 이벤트 처리<br>
	     *
	     * @param String fmAttyBizNo
	     * @param String toAttyBizNo
	     * @return EventResponse EsmBkg0999EventResponse
	     * @exception EventException
	     */
	    public String searchKorDoAttorneyDtl(String fmAttyBizNo, String toAttyBizNo) throws EventException;

	    /**
	     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
	     * @param KorDoRlseVO korDoRlse
	     * @exception EventException
	     * @author Lim JinYoung
	     */
	    public void releaseKorDo(KorDoRlseVO korDoRlse) throws EventException;

	    /**
	     * Korea D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
	     * @param String bkgNo  : 선적예약 요청 번호
	     * @param SignOnUserAccount account
	     * @return KorDoMstVO korDoMst
	     * @exception EventException
	     * @author Lim JinYoung
	     */
	    public KorDoMstVO searchKorDo(String bkgNo, SignOnUserAccount account) throws EventException;

	    /**
	     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.
	     * @param KorDoSaveVO korDoSave
	     * @exception EventException
	     * @author Lim JinYoung
	     */
	    public void manageKorDo(KorDoSaveVO korDoSave) throws EventException;

	    /**
	     * D/O No를 Assign 한다.<br>
	     * @param DoAsignVO doAsign
	     * @return String doNo
	     * @exception EventException
	     * @author Lim JinYoung
	     */
	    public String assignDo(DoAsignVO doAsign) throws EventException;

	    /**
	     * D/O를 Cancel 한다.<br>
	     *
	     * @param KorDoCancelVO korDoCancel
	     * @exception EventException
	     * @author Lim JinYoung
	     */
	    public void cancelKorDo(KorDoCancelVO korDoCancel) throws EventException;

	    /**
	     * D/O를 Cancel 한다.<br>
	     *
	     * @param DoCancelVO doCancel
	     * @exception EventException
	     * @author Lim JinYoung
	     */
	    public void cancelDo(DoCancelVO doCancel) throws EventException;

	    /**
	     * Cargo Release Order에서 Event별로 발생 내역 정보에 대한 History를 기록한다.<br>
	     *
	     * @param BkgDoHisVO bkgDoHis
	     * @exception EventException
	     */
	    public void createDoHistory(BkgDoHisVO bkgDoHis) throws EventException;

	    /**
	     * DO 대상 B/L 단위로  HOLD 한다.<br>
	     *
	     * @param doHold
	     * @exception EventException
	     */
	    public void holdDo(DoHoldVO doHold) throws EventException;

	    /**
	     * KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송한다.<br>
	     *
	     * @param EdoEdiTransVO[] edoEdiTrans
	     * @param String callModule
	     * @exception EventException
	     */
	    public void transmitEdiByEdo(EdoEdiTransVO[] edoEdiTrans, String callModule) throws EventException;

	    /**
	     * DEM/DET에서의 E-DO관련 요청에 대하여 전송여부를 체크하고 전송메소드를 호출한다.<br>
	     *
	     * @param EdoEdiTransVO[] edoEdiTrans
	     * @exception EventException
	     */
	    public void transmitEdiByEdoDmt(EdoEdiTransVO[] edoEdiTrans) throws EventException;

	    /**
	     * ESM_BKG_0682 : EDI 수신 <br>
	     * EDO 승인 요청에 대한 처리 후 전송 결과(Ack)정보를 기록한다.<br>
	     *
	     * @param String rqstNo
	     * @param String ackInd
	     * @exception EventException
	     */
	    public void receiptEdoRqstAck(String rqstNo, String ackInd) throws EventException;

	    /**
	     * ESM_BKG_0682 : EDI 수신 <br>
	     * KT-NET으로 부터 수신 받은 정보를 기록한다.<br>
	     *
	     * @param EdoRqstVO edoRqst
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void receiptEdo(EdoRqstVO edoRqst, SignOnUserAccount account) throws EventException;

	    /**
	     * ESM_BKG_0682 : EDI 수신 <br>
	     * EDO 요청에 대해 KT-NET으로 Approval 또는 Reject 전송 후  전송 결과 정보에 대한 Log정보를 기록한다.<br>
	     *
	     * @param BkgEdoLogVO edoLog
	     * @exception EventException
	     */
	    public void receiptEdoLog(BkgEdoLogVO edoLog) throws EventException;

	    /**
	     * ESM_BKG_0682 : EDI 송신 <br>
	     * KL-NET을 통해 자가 운송 요청에 대한 취소 요청을 EDI로 전송 후 관련 데이타를 Cancel 처리한다.<br>
	     *
	     * @param KorDoEdiTransVO korDoEdiTrans
	     * @exception EventException
	     */
	    public void transmitEdiByKorDo(KorDoEdiTransVO korDoEdiTrans) throws EventException;

	    /**
	     *  Japan D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
	     *
	     * @param bkgNo  : 선적예약 요청 번호
	     * @param SignOnUserAccount account
	     * @return EventResponse EsmBkg0682EventResponse
	     * @exception EventException
	     */
	    public JapDoMstVO searchJapDo(String bkgNo, SignOnUserAccount account) throws EventException;

	    /**
	     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.<br>
	     *
	     * @param JapDoSaveVO japDoSave
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void manageJapDo(JapDoSaveVO japDoSave, SignOnUserAccount account) throws EventException;

	    /**
	     * Japan D/O 대상 B/L에 대해 D/O Assign & Issue작업을 수행한다.
	     *
	     * @param japDoIssue
	     * @exception EventException
	     */
	    public void issueJapDo(JapDoIssueVO japDoIssue) throws EventException;

	    /**
	     * ESM_BKG_0326 :  DOR 전송 <br>
	     * @param JapDorEdiTransVO japDorEdiTrans
	     * @exception EventException
	     */
	    public void transmitEdiByJapDor(JapDorEdiTransVO japDorEdiTrans) throws EventException;

	    /**
	     * ESM_BKG_0326 :  DOR 전송 취소<br>
	     * @param JapDorEdiTransVO japDorEdiTrans
	     * @exception EventException
	     */
	    public void transmitEdiByJapDorCancel(JapDorEdiTransVO japDorEdiTrans) throws EventException;

	    /**
	     * Japan Do Id 정보를 Update 한다
	     *
	     * @param JapDorStatusVO japDorStatus
	     * @exception EventException
	     */
	    public void modifyJapDoId(JapDorStatusVO japDorStatus)  throws EventException;

	    /**
	     * VVD별 ERP OutStanding 정보를 EAI I/F로 실시간 제공을 받는다.<br>
	     *
	     * @param BkgOutstandingVO ots
	     * @return String chkFlg
	     * @exception EventException
	     */
	    public String receiveOtsMst(BkgOutstandingVO ots)throws EventException;

	    /**
	     * VVD별 ERP OutStanding 정보를 EAI I/F로 실시간 제공을 받는다.<br>
	     *
	     * @param BkgOtsDtlVO otsDtls
	     * @exception EventException
	     */
	    public void receiveOtsDtl(BkgOtsDtlVO otsDtls)throws EventException;


	    /**
	     * 조회 이벤트 처리<br>
	     * Cargo Release Order의 Office Default From Setup 정보를 조회한다.<br>
	     *
	     * @param String office
	     * @return List<BkgDoFomVO>
	     * @exception EventException
	     */
	    public List<BkgDoFomVO> searchDoForm(String office) throws EventException;

	    /**
	     * 삭제 이벤트 처리<br>
	     * Cargo Release Order의 Office Default From Setup 삭제 처리<br>
	     *
	     * @param String office
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void removeDoForm(String office, SignOnUserAccount account  ) throws EventException;

	    /**
	     * 저장 이벤트 처리<br>
	     * Cargo Release Order의 Office Default From Setup 저장(입력 또는 수정) 처리<br>
	     *
	     * @param e EsmBkg0137Event
	     * @return EventResponse EsmBkg0137EventResponse
	     * @exception EventException
	     */
	    public void setupDoForm(BkgDoFomVO[] bkgDoFomVOs, SignOnUserAccount account  ) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * Cargo Release Order_E-D/O inquiry _Main 화면에 대한 조회 이벤트 처리<br>
	     *
	     * @param EdoSearchVO edoSearch
	     * @return List<EdoRqstsVO>
	     * @exception EventException
	     */
	    public List<EdoRqstsVO> searchEdoRqstList(EdoSearchVO edoSearch) throws EventException;

	    /**
	     * 삭제 이벤트 처리<br>
	     * Cargo Release Order_E-D/O inquiry _Main 삭제 처리<br>
	     *
	     * @param EdoRqstsVO[] edoRqstsVO
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void removeEdoErrData(EdoRqstsVO[] edoRqstsVO, SignOnUserAccount account  ) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * KT-Net으로 들어온 EDI로 들어온 E-DO Application 정보를 조회한다.<br>
	     *
	     * @param String rqstNo
	     * @param String tpCd
	     * @return EdoRqstVO edoRqstVO
	     * @exception EventException
	     */
	    public EdoRqstVO searchEdoByDoRqst(String rqstNo, String tpCd) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * D/O EDI Transmit Log List Inquiry 화면에 대한 조회 이벤트 처리<br>
	     *
	     * @param String rcvToDt
	     * @param String rcvFmDt
	     * @param String blNo
	     * @return List<BkgEdoLogVO>
	     * @exception EventException
	     */
	    public List<BkgEdoLogVO> searchEdoTransLog(String rcvToDt, String rcvFmDt, String blNo) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * KT-Net으로 들어온 EDI로 들어온 In-bond Transportation Application 정보를 조회한다.<br>
	     *
	     * @param String rqstNo
	     * @param String tpCd
	     * @return EdoRqstVO edoRqstVO
	     * @exception EventException
	     */
	    public EdoRqstVO searchEdoByIbdTrspRqst(String rqstNo, String tpCd) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * KT-Net으로 들어온 EDI로 들어온 Merchant Haulage Application 정보를 조회한다.<br>
	     *
	     * @param String rqstNo
	     * @param String tpCd
	     * @return EdoRqstVO edoRqstVO
	     * @exception EventException
	     */
	    public EdoRqstVO searchEdoBySelfTrspRqst(String rqstNo, String tpCd) throws EventException;

	    /**
	     * (주)한진으로 부터 EDI 수신된, 컨테이너별 자가운송 Party(업체정보)를 조회한다.<br>
	     *
	     * @param String rqstNo
	     * @return List<SearchEdoCntrPtyTrspVO>
	     * @exception EventException
	     */
	    public List<SearchEdoCntrPtyTrspVO> searchEdoCntrPtyTrsp(String rqstNo) throws EventException ;

	    /**
	     * 조회 이벤트 처리<br>
	     * EU_Cargo Release Order의 D/O Receiver Setting 및 Send와 Release를 할 수 있는 Pop-up화면을 조회한다.<br>
	     *
	     * @param String doNo
	     * @param String doNoSplit
	     * @return EuDoRcvrVO euDoRcvrVO
	     * @exception EventException
	     */
	    public EuDoRcvrVO searchEuDoRcvrInfo(String doNo, String doNoSplit) throws EventException;


	    /**
	     * 저장 이벤트 처리<br>
	     * EU_Cargo Release Order의 D/O Receiver Setting 저장(입력 또는 수정) 처리<br>
	     *
	     * @param e EsmBkg0937Event
	     * @return EventResponse EsmBkg0937EventResponse
	     * @exception EventException
	     */
	    public void setupEuDoRcvrInfo(BkgDoVO[] bkgDoVO, SignOnUserAccount account  ) throws EventException;

	    /**
	     * 저장 이벤트 처리<br>
	     * EU_Cargo Release Order의 D/O Receiver Setting 저장(입력 또는 수정) 처리<br>
	     *
	     * @param e EsmBkg0937Event
	     * @return EventResponse EsmBkg0937EventResponse
	     * @exception EventException
	     */
	    public void setupEuDoTruckerInfo(BkgDoCntrVO[] bkgDoCntrVOs, SignOnUserAccount account) throws EventException;

	    /**
	     * 메일 전송 이벤트 처리<br>
	     * EU_Cargo Release Order의 D/O Receiver Setting 저장 후 메일 전송 처리<br>
	     *
	     * @param BkgDoVO[] bkgDo
	     * @param SignOnUserAccount account
	     * @return List<BkgNtcHisVO> bkgNtcHisVOs
	     * @exception EventException
	     */
	    public List<BkgNtcHisVO> sendEuDoByEmail(BkgDoVO[] bkgDo, SignOnUserAccount account) throws EventException;

	    /**
	     * Fax 전송 이벤트 처리<br>
	     * EU_Cargo Release Order의 D/O Receiver Setting 저장 후 Fax 전송 처리<br>
	     *
	     * @param BkgDoVO[] bkgDo
	     * @param SignOnUserAccount account
	     * @return List<BkgNtcHisVO> bkgNtcHisVOs
	     * @exception EventException
	     */
	    public List<BkgNtcHisVO> sendEuDoByFax(BkgDoVO[] bkgDo, SignOnUserAccount account) throws EventException;

	    /**
	     * 0938 조회 이벤트 처리<br>
	     * EU D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
	     *
	     * @param String bkgNo
	     * @param SignOnUserAccount account
	     * @return EuDoMstVO euDoMst
	     * @exception EventException
	     */
	    public EuDoMstVO searchEuDo(String bkgNo, SignOnUserAccount account) throws EventException;

	    /**
	     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.<br>
	     *
	     * @param EuDoSaveVO euDoSave
	     * @exception EventException
	     */
	    public void manageEuDo(EuDoSaveVO euDoSave) throws EventException;

	    /**
	     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
	     *
	     * @param EuDoRlseVO euDoRlse
	     * @param DoCntrVO[] doCntr
	     * @exception EventException
	     */
	    public void releaseEuDo(EuDoRlseVO euDoRlse, DoCntrVO[] doCntr) throws EventException;

	    /**
	     * 0938 EU D/O를 Cancel 한다.<br>
	     *
	     * @param DoCancelVO doCancel
	     * @exception EventException
	     * @author An Jineung
	     */
	    public void cancelEuDo(DoCancelVO doCancel) throws EventException;

	    /**
	     * 1035 CY Delivery 인 경우와 CY Unstuffing 인 경우에 따라 D/O Preview에(베트남) Print에 적용할 문구 코드를 조회한다.<br>
	     *
	     * @param String bkgNo
	     * @return BkgDoVO
	     * @exception EventException
	     * @author An Jineung
	     */
	    public BkgDoVO searchVetnamPrnCd(String bkgNo) throws EventException;

	    /**
	     * 저장 이벤트 처리<br>
	     * CY Delivery 인 경우와 CY Unstuffing 인 경우에 따라 D/O Preview에(베트남) Print에 적용할 문구 코드를 저장한다.<br>
	     *
	     * @param e EsmBkg1035Event
	     * @return EventResponse EsmBkg1035EventResponse
	     * @exception EventException
	     */
	    public void setupVetnamPrnCd(String bkgNo, String rlseSeq, String vnCgoDeCd, String usrId) throws EventException;


	    /**
	     * 0128 조회 이벤트 처리<br>
	     * D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
	     *
	     * @param bkgNo
	     * @param SignOnUserAccount account
	     * @return DoMstVO doMst
	     * @exception EventException
	     */
	    public DoMstVO searchGenDo(String bkgNo, SignOnUserAccount account) throws EventException;

	    /**
	     * 0128 D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.<br>
	     *
	     * @param DoSaveVO doSave
	     * @exception EventException
	     */
	    public void manageGenDo(DoSaveVO doSave) throws EventException;

	    /**
	     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
	     *
	     * @param DoRlseVO doRlse
	     * @exception EventException
	     * @author An JinEung
	     */
	    public void releaseGenDo(DoRlseVO doRlse) throws EventException;

	    /**
	     * 0292 조회 이벤트 처리<br>
	     * D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
	     *
	     * @param String bkgNo : 선적예약 요청 번호
	     * @param SignOnUserAccount account
	     * @return EventResponse EsmBkg0292EventResponse
	     * @exception EventException
	     */
	    public DoMstVO searchDo(String bkgNo, SignOnUserAccount account) throws EventException;

	    /**
	     * 0292 Cargo Release Remark 저장 이벤트 처리<br>
	     * D/O No  D/O Print & Receipt Print Preview시 Remark정보를 Setting한다.<br>
	     *
	     * @param BkgDoRefVO bkgDoRef
	     * @exception EventException
	     */
	    public void manageDoHldRmk(BkgDoRefVO bkgDoRef) throws EventException;
	/******************************************************************************************
	    Author :An JinEung End
	*******************************************************************************************/

	/******************************************************************************************
	    Author :Park Mangeon Start
	*******************************************************************************************/

	    /**
	     * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
	     * 인디아 DO에 대한 연락처 정보를 조회한다.<br>
	     * @param String doNo
	     * @param String doNoSplit
	     * @return DoRcvrVO
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public DoRcvrVO searchIdaDoRcvrInfo(String doNo, String doNoSplit) throws EventException;

	    /**
	     * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
	     * 인디아 DO에 대한 연락처 정보를 수정한다.<br>
	     * @param DoRcvrVO doRcvr
	     * @param SignOnUserAccount acount
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public void setupIdaDoRcvrInfo(DoRcvrVO doRcvr, SignOnUserAccount acount) throws EventException;

	    /**
	     * UI-BKG-0694 - Cargo Delivery - DO LIST CHECK REPORT(JAPAN)<br>
	     * Japan Cargo Release Report를 조회한다.<br>
	     * @param JapDoHisSearchVO japDoHisSearch
	     * @return List<JapDoHisListVO>
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public List<JapDoHisListVO> searchJapDoHistory(JapDoHisSearchVO japDoHisSearch) throws EventException;

	    /**
	     * UI-BKG-0131 Cargo Release Order List Check Report<br>
	     * do check list조회를 수행한다.<br>
	     * @param DoCheckListSearchVO checkListSearch
	     * @return DoPfmsVO
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public DoPfmsVO searchDoCheckReport (DoCheckListSearchVO checkListSearch) throws EventException;

	    /**
	     * UI-BKG-0939 India Cargo Release Order list Inquery<br>
	     * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 Weekly별로 조회한다.<br>
	     * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 조회한다.<br>
	     * @param IdaDoRlseSearchVO idaDoRlseSearch
	     * @return IdaDoRlseReportVO
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public IdaDoRlseReportVO searchIdaDoRlseReport (IdaDoRlseSearchVO idaDoRlseSearch) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * India D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
	     * @param String bkgNo  선적예약 요청 번호
	     * @param SignOnUserAccount account
	     * @return IdaDoMstVO
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public IdaDoMstVO searchIdaDo(String bkgNo, SignOnUserAccount account) throws EventException;


	    /**
	     * UI-BKG-0680 India Cargo Releass<br>
	     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.<br>
	     * @param IdaDoSaveVO idaDoSave
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public void manageIdaDo(IdaDoSaveVO idaDoSave) throws EventException;

	    /**
	     * UI-BKG-0680 DO Release 이벤트 처리<br>
	     * India D/O 발행 을 처리한다.<br>
	     * @param IdaDoRlseVO idaDoRlse
	     * @param DoCntrVO[] doCntrs
	     * @param SignOnUserAccount account
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public void releaseIdaDo(IdaDoRlseVO idaDoRlse, DoCntrVO[] doCntrs, SignOnUserAccount account) throws EventException;

	    /**
	     * UI-BKG-0923 Inbound Cargo Release for POD Office_Popup History<br>
	     * 미주 Inboud Cargo Release B/L에 대한 History 조회<br>
	     * @param String blNo
	     * @return List<UsCgoRlseHisVO>
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public List<UsCgoRlseHisVO> searchUsCgoRlseHis(String blNo) throws EventException;

	/******************************************************************************************
	    Author :Park Mangeon End
	*******************************************************************************************/

	/******************************************************************************************
	    Author : Son YunSeuk Start
	*******************************************************************************************/
	    /**
	     * UI-BKG-1018 D/O Cargo Release Remark Setting<br>
	     * @param String doNo
	     * @param SignOnUserAccount account
	     * @return DoPrnRmkVO
	     * @exception EventException
	     * @author Son YunSeuk
	     */
	    public List<DoPrnRmkVO> searchDoPrnRmk(String doNo, SignOnUserAccount account) throws EventException;

	    /**
	     * UI-BKG-1018 D/O Cargo Release Remark Setting<br>
	     * @param DoPrnRmkVO doPrnRmkVO
	     * @param SignOnUserAccount account
	     * @exception EventException
	     * @author Son YunSeuk
	     */
	    public void modifyDoPrnRmk(DoPrnRmkVO doPrnRmkVO, SignOnUserAccount account) throws EventException;

	    /**
	     * UI-BKG-0272 Full CNTR Release Order<br>
	     * @param FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch
	     * @return List<FullCntrRlseOrdVO>
	     * @exception EventException
	     * @author Son YunSeuk
	     */
	    public List<FullCntrRlseOrdVO> searchFullCntrRlseOrderList(FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch ) throws EventException;



	    /**
	     * SendEmail<br>
	     * Full Container Order 화면에서 메일을 발송한다<br>
	     * @param FullCntrRlseOrderMailSendVO[] fullCntrRlseOrderMailSendVOs
	     * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVOs
	     * @param SignOnUserAccount account
	     * @param String diffStr
	     * @exception EventException
	     */
	    public void sendEmailFullCntrRlseOrder(FullCntrRlseOrderMailSendVO[] fullCntrRlseOrderMailSendVOs, FullCntrRlseOrdVO[] fullCntrRlseOrdVOs, SignOnUserAccount account, String diffStr) throws EventException;


	    /**
	     * [0272] : EDI전송
	     * [ESM_BKG_0272]
	     * @param FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs  UI화면에서 사용자가 멀티 셀렉트한 상태일 경우 여러건일 수 있다.
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void transmitEdiFullCntrRlseOrder(FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs, SignOnUserAccount account) throws EventException;


	    /**
	     * 1052 - Remark Save<br>
	     * Remark Pupup화면에서 해당 Remark를 저장한다.<br>
	     * @param BkgFullCntrRemarkVO bkgFullCntrRemarkVO
	     * @param SignOnUserAccount account
	     * @return int updateCount
	     * @exception EventException
	     */
	    public int modifyFullCntrRlseRmk(BkgFullCntrRemarkVO bkgFullCntrRemarkVO, SignOnUserAccount account) throws EventException;

	    /**
	     * Full Continer Release Order History<br>
	     * [ESM_BKG_0273]
	     * @param FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO
	     * @param SignOnUserAccount account
	     * @return List<FullCntrRlseOrderHisVO>
	     * @exception EventException
	     */
	    public List<FullCntrRlseOrderHisVO> searchFullCntrRlseOrderHis(FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO, SignOnUserAccount account) throws EventException;

	    /**
	     * [0130] : Receiver Info 조회<br>
	     * [ESM_BKG_0130]
	     * @param String doNo
	     * @return DoRcvrInfoVO
	     * @exception EventException
	     */
	    public DoRcvrInfoVO searchDoRcvrInfo(String doNo) throws EventException;

	    /**
	     * [0130] : Receiver Info 저장<br>
	     * [ESM_BKG_0130]
	     * @param DoRcvrInfoVO doRcvrInfoVO
	     * @param SignOnUserAccount account
	     * @return int Update Count
	     * @exception EventException
	     */
	    public int setupDoRcvrInfo(DoRcvrInfoVO doRcvrInfoVO, SignOnUserAccount account) throws EventException;
	/******************************************************************************************
	    Author : Son YunSeuk End
	******************************************************************************************/

	    /**
	    * [0909] 미주 Inbound Cargo Release에 대한 List를 Item별로 조회한다.
	    * @param searchvo
	    * @return
	    * @exception EventException
	    */
	    public List<UsCgoRlseListVO> searchUsCgoRlseList(UsCgoRlseSearchVO searchvo) throws EventException;

	    /**
	     * [0909] B/L별 컨테이너 번호를 조회한다.
	     * @param bkgNo
	     * @return
	     * @exception EventException
	     */
	    public List<BkgContainerVO> searchUsCgoRlseFoc(String bkgNo) throws EventException;


	    /**
	     * [0909] hold 상태 수정
	     * @param DoRefVO[] vos
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void manageUsCgoRlseHold(DoRefVO[] vos, SignOnUserAccount account) throws EventException;

	    /**
	     * [0156] COD Application POD 변경시 CgoRlse
	     * @param BkgCgoRlseVO bkgCgoRlseVo
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void manageUsCgoRlseChangePod(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException;

	    /**
	     * [0909] F.O.C 변경 내역 저장
	     * @param BkgCgoRlseVO bkgCgoRlseVo
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void manageUsCgoRlse(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException;

	    /**
	     * VVD별 쪽에서 데이터를 받음.
	     *
	     * @param BkgOutstandingVO ots
	     * @exception Exception
	     */
	    public void searchOtsUsCgo(BkgOutstandingVO ots) throws Exception;

	    /**
	     * [0909]O/B 쪽에서 오는요청을 처리한다.
	     * @param oblRdem
	     * @exception Exception
	     */
	    public void setupFocByObl(OblRdemVO oblRdem) throws Exception;

	    /**
	      * [0909]Freight 쪽에서 오는요청을 처리한다.
	      * @param cstmsClr
	     * @exception Exception
	      */
	    public void setupFocByFreight(FrtCltLstVO frtCltLst) throws Exception;

	    /**
	      * [0909]세관쪽에서 오는요청을 처리한다.
	      * @param cstmsClr
	     * @exception Exception
	      */
	    public void setupFocByCstms(CstmsClrVO cstmsClr) throws Exception;

	    /**
	     * [0909] transmit버튼 저장
	     * F/O/C에 의한 EDI 전송 수행.
	     * @param DoRefVO[] doRefVOs
	     * @param BkgCgoRlseVO[] bkgCgoRlseVOs
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    //public void manageUsCgoRlseTrans(DoRefVO[] doRefVOs, BkgCgoRlseVO[] bkgCgoRlseVOs, SignOnUserAccount account) throws EventException;

	    /**
	      * [0909]ERP I/F를 위한 EAIDAO 호출
	      * @param blNo
	      * @return OtsRcvInfoVO
	      * @exception EventException
	      */
	    public OtsRcvInfoVO searchErpOtsInfo(String blNo) throws EventException;


	    /**
	     *부킹번호에 해당하는 컨테이너 목록을 조회한다.
	     * @param String bkgNo Booking번호
	     * @return String[] Container No List
	     * @exception EventException
	     */
	    public String[] searchDemDetCntrList(String bkgNo) throws EventException;

	    /**
	     * Original Bill of Lading Status
	     * @param String bkgNo
	     * @param SignOnUserAccount account
	     * @return List<UsCgoRlseBlStatusVO>
	     * @throws EventException
	     */
	    public List<UsCgoRlseBlStatusVO> searchUsCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws EventException;


	    /**
	     * [0909]O/B 쪽에서 호출되는 배열을 Cargo Release 를 처리한다.
	     * @param oblRdems
	     * @throws Exception
	     */
	    public void setupFocByOblAutoBdr(OblRdemVO[] oblRdems) throws Exception;

		/**
		 * [0909] Partial 정보가져오기
		 *
		 * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
		 * @return  UsCgoRlseBkbcBlVO
		 * @exception EventException
		 */
		public UsCgoRlseBkbcBlVO searchPrtlBl(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws EventException;

		/**
		 * [0128] 두바이건 요청.<br>
		 *
		 * @param DubaiCstmsVO[] dubaiCstms
		 * @exception EventException
		 */
		public void modifyDubaiCstmsRefNo(DubaiCstmsVO[] dubaiCstms) throws EventException;


	    /**
	     * UI-BKG-0272 Full CNTR Release Order<br> E-mail for TMNL
	     * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVos
	     * @param SignOnUserAccount account
	     * @return FullCntrRlseOrderMailVO
	     * @exception EventException
	     * @author Lee InYoung
	     */
	    public FullCntrRlseOrderMailVO searchFullCntrRlseOrdMailCtntForTmnl(FullCntrRlseOrdVO[] fullCntrRlseOrdVos, SignOnUserAccount account ) throws EventException;

	    /**
	     * UI-BKG-0272 Full CNTR Release Order<br> E-mail for CUST
	     * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVos
	     * @param SignOnUserAccount account
	     * @return FullCntrRlseOrderMailVO
	     * @exception EventException
	     * @author Lee InYoung
	     */
	    public FullCntrRlseOrderMailVO searchFullCntrRlseOrdMailCtntForCust(FullCntrRlseOrdVO[] fullCntrRlseOrdVos, SignOnUserAccount account ) throws EventException;

	    /**
	      * [0668-09] Remark 저장
	      * @param DoRefVO[] doRefVOs
	      * @param SignOnUserAccount account
	      * @exception EventException
	      */
//	    public void manageDoHldRmk(DoRefVO[] doRefVOs, SignOnUserAccount account)
//	            throws EventException;
	    /**
	     * 조회 이벤트 처리<br>
	     * Cargo Release Order_E-D/O inquiry _Main 화면의 자가운송에 대한 조회 이벤트 처리<br>
	     *
	     * @param EdoSearchVO edoSearch
	     * @return List<EdoRqstsVO>
	     * @exception EventException
	     */
	    public List<EdoCntrRqstsVO> searchEdoCntrRqstList(EdoSearchVO edoSearch) throws EventException;

	    /**
	     * IDA D/O Release 내역을 삭제 처리한다.
	     *
	     * @param IdaDoCancelVO idaDoCancelVo
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void cancelIdaDo(IdaDoCancelVO  idaDoCancelVo, SignOnUserAccount account) throws EventException;

	    /**
	     * PSA EDI Transmit 처리
	     *
	     * @param psaDoEdiTransVO
	     * @throws EventException
	     */
	    public void transmitEdiPsaEdo(PsaDoEdiTransVO psaDoEdiTransVO) throws EventException;

	    /**
	     * PSA 터미널 EDI 전송 후 수신 받은 Ack 정보를 조회
	     *
	     * @param BkgPsaEdoAckSchVO bkgPsaEdoAckSchVO
	     * @return List<BkgPsaEdoAckSchVO>
	     * @throws EventException
	     */
	    public List<BkgPsaEdoAckSchVO> searchPsaEdoAckLog(BkgPsaEdoAckSchVO bkgPsaEdoAckSchVO) throws EventException;

	    /**
	     * PSA EDI 전송 후 수신 내용을 저장
	     *
	     * @param bkgPsaEdoRcvLogVO
	     * @throws EventException
	     */
	    public void receiptPsaEdoAck(BkgPsaEdoRcvLogVO bkgPsaEdoRcvLogVO) throws EventException;

	    /**
	     * India Cargo Release조회화면의 COMBO 값 조회 : UI_BKG_0680
	     *
	     * @return List<BkgComboVO>
	     * @exception EventException
	     */
	    public List<BkgComboVO> searchIdaDoDiscTmnlYdList() throws EventException;

	    /**
	     * E-DO 요청 내역이 자가운송의 승인인 경우 냉동 화물 유무를 체크<br>
	     *
	     * @param String bkgNo
	     * @return EdoTransBlInfoVO
	     * @throws EventException
	     */
	    public EdoTransBlInfoVO searchEdoTrasnBlInfo(String bkgNo) throws EventException;

	    /**
	     * BKG_EDO_MST 테이블이 조회 될 때 Review flag 를 업데이트 한다.<br>
	     *
	     * @param String rqstNo
	     * @param String tpCd
	     * @param String usrId
	     * @throws EventException
	     */
	    public void modifyEdoReviewFlag(String rqstNo, String tpCd, String usrId) throws EventException;


	    /**
	     * Pickup Date 및 Release Expire Date 항목 체크
	     * @param FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs
	     * @throws EventException
	     */
	    public void checkEuFullRlseTransmitValid (FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs) throws EventException;

	    /**
	     * KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송한다.<br>
	     *
	     * @param EdoEdiTransVO[] edoEdiTrans
	     * @param String callModule
	     * @exception EventException
	     */
	    public void transmitEdiBySelfTransEdo(EdoEdiTransVO[] edoEdiTrans, String callModule) throws EventException;

	    /**
	     * KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송한다.<br>
	     *
	     * @param EdoEdiTransVO[] edoEdiTrans
	     * @param String callModule
	     * @exception EventException
	     */
	    public void transmitEdiByInbondTransEdo(EdoEdiTransVO[] edoEdiTrans, String callModule) throws EventException;

	    /**
		 * [1167] Canada Cargo Release에 대한 List를 Item별로 조회한다.
		 * @param searchvo
		 * @return
		 * @exception EventException
		 */
		public List<CaCgoRlseListVO> searchCaCgoRlseList(CaCgoRlseSearchVO searchvo) throws EventException;

	    /**
	     * ESM_BKG_1167 FOC 정보를조회한다.
	     * @param bkgNo
	     * @return
	     * @exception EventException
	     */
	    public List<BkgContainerVO> searchCaCgoRlseFoc(String bkgNo) throws EventException;


	    /**
		 * ESM_BKG_1167 Partial 정보가져오기
		 *
		 * @param CaCgoRlseBkbcBlVO caCgoRlseBkbc
		 * @return  CaCgoRlseBkbcBlVO
		 * @exception EventException
		 */
		public CaCgoRlseBkbcBlVO searchCaPrtlBl(CaCgoRlseBkbcBlVO caCgoRlseBkbc) throws EventException;

	    /**
	     * ESM_BKG_1167 BL Status 조회
	     * @param String bkgNo
	     * @param SignOnUserAccount account
	     * @return List<CaCgoRlseBlStatusVO>
	     * @throws EventException
	     */
	    public List<CaCgoRlseBlStatusVO> searchCaCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws EventException;

	    /**
	     * ESM_BKG_1167 F.O.C 변경 내역 저장
	     * @param BkgCgoRlseVO bkgCgoRlseVo
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void manageCaCgoRlse(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException;

	    /**
	     * ESM_BKG_1167 상태 수정
	     * @param DoRefVO[] vos
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void manageCaCgoRlseHold(DoRefVO[] vos, SignOnUserAccount account) throws EventException;

	    /**
	     * release notes 칼럼에 Update 항목이 보여야하는 오피스를 가져온다. ESM_BKG_0272.<br>
	     *
	     * @param String ofcCd
	     * @return String chkFlg
	     * @exception EventException
	     */
	    public String searchOfcFullCntrRlseOrdBracUpdFlg(String ofcCd)throws EventException;

	    /**
		 * 1177   DO validity upto history 조회
		 * @param String bkgNo
		 * @return List<DoVtyDtUpdHisVO>
		 * @exception EventException
		 * @author Kwak youndBeom
		 */
		public List<DoVtyDtUpdHisVO> searchDoVtyUptoDthis(String bkgNo) throws EventException;

	    /**
	     * [0156] COP Application : POD 변경시 조건으로 CR 전송여부 체크
	     *
	     * @param String blNo
	     * @return List<UsCgoRlseListVO>
	     * @exception EventException
	     */
	    public List<UsCgoRlseListVO> searchUsCgoRlseView(String blNo) throws EventException;

	    /**
	     * ESM_BKG_1515 EDI Setup 조회
	     *
	     * @param EdiYardInfoVO searchVo
	     * @return List<EdiYardInfoVO>
	     * @exception EventException
	     */
	    public List<EdiYardInfoVO> searchEdiSetupList(EdiYardInfoVO searchVo) throws EventException;

	    /**
	     * ESM_BKG_1515 EDI Setup 등록
	     *
	     * @param EdiYardInfoVO[] vos
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void manageEdiSetup(EdiYardInfoVO[] vos,SignOnUserAccount account) throws EventException;

	    /**
	     * ESM_BKG_1515 EDI Setup History 조회
	     *
	     * @param EdiYardInfoVO searchVo
	     * @return List<EdiYardInfoVO>
	     * @exception EventException
	     */
	    public List<EdiYardInfoVO> searchEdiSetupHistoryList(EdiYardInfoVO searchVo) throws EventException;


	    /**
	     * 메일 전송 이벤트 처리<br>
	     * India_Cargo Release Order의 D/O Receiver Setting 저장 후 메일 전송 처리<br>
	     *
	     * @param IndiaDoNtcSendVO paramVO
	     * @param SignOnUserAccount account
	     * @return IndiaDoNtcSendVO indiaDoNtcSendVO
	     * @exception EventException
	     */
	    public IndiaDoNtcSendVO sendIndiaDoByEmail(IndiaDoNtcSendVO paramVO, SignOnUserAccount account) throws EventException;

	    /**
	     * [0909] 조회 WEB B/L Printed : Serial Number
	     * @param bkgNo
	     * @return
	     * @exception EventException
	     */
	    public UsCgoRlseListVO searchOblInterSerNoCheckInfo(String bkgNo) throws EventException;

	    /**
	     * [0909] 저장 WEB B/L Printed Checked
	     * @param String bkgNo
	     * @param SignOnUserAccount account
	     * @exception EventException
	     */
	    public void manageOblInterSerNoCheck(String bkgNo, SignOnUserAccount account) throws EventException;

	    /**
	     * 조회 이벤트 처리<br>
	     * Bangladesh D/O 발행 대상 B/L에 대한 정보를 조회한다.<br>
	     * @param String bkgNo  선적예약 요청 번호
	     * @param SignOnUserAccount account
	     * @return IdaDoMstVO
	     * @exception EventException
	     * @author Park Mangeon
	     */
	    public EuDoMstVO searchBdDo(String bkgNo, SignOnUserAccount account) throws EventException;

	    /**
	     * D/O 정보를 저장한다. D/O Assign이 이미 된 경우는 Update이고 Assign이전에는 신규 등록 작업을 수행한다.<br>
	     *
	     * @param EuDoSaveVO euDoSave
	     * @exception EventException
	     */
	    public void manageBdDo(EuDoSaveVO euDoSave) throws EventException;

	    /**
	     * 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
	     *
	     * @param EuDoRlseVO euDoRlse
	     * @param DoCntrVO[] doCntr
	     * @exception EventException
	     */
	    public void releaseBdDo(EuDoRlseVO euDoRlse, DoCntrVO[] doCntr) throws EventException;

	    /**
	     * 0684 EU D/O를 Cancel 한다.<br>
	     *
	     * @param DoCancelVO doCancel
	     * @exception EventException
	     * @author An Jineung
	     */
	    public void cancelBdDo(DoCancelVO doCancel, SignOnUserAccount account) throws EventException;
	    
	    /**
	     * Indonesia(Surabaya) EDI Transmit 처리
	     *
	     * @param psaDoEdiTransVO
	     * @throws EventException
	     */
	    public void transmitEdiIdEdo(IdDoEdiTransVO idDoEdiTransVO) throws EventException;
}
