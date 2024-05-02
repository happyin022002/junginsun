/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceBC.java
*@FileTitle : Group & Multi B/L Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.04.29 박준용
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2011.05.02 최도순 [CHM-201108221-01][CSR] 전자선하증권 시범사업 Test 환경 구축
* 2011.10.18 김종호 [CHM-201113664] ALPS EAI 연동 개발- 홈페이지 OBL 출력 시 ALPS에 정보 I/F 기능 추가 (Web0040001)
* 2011.10.20 김종호 [CHM-201113688] ALPS EAI 연동 개발- 홈페이지 BL 발급요청 시 ALPS에 정보 I/F 기능 추가 (Web0050001)
* 2011.12.01 김종호 [CHM-201114841] [BKG] B/L 발급 신청 수정 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgSrchSetVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AgentEmlVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AuthCustVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgBlIssRqstMailSndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService005VO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlAtchVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlCertiRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlStatusVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EBLIssueInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EBLIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.InDblWblInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MultiNtcHisVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.N3ptyBlRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ObDblWblInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchReminderEmailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SrndVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBlIssVO;
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtHisVO;
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssRqstVO;

/**
 * NIS2010-Outboundblmgt Business Logic Command Interface<br>
 * - NIS2010-Outboundblmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Joon Yong Park
 * @see Esm_bkg_0278EventResponse 참조
 * @since J2EE 1.4
 */

public interface BLIssuanceBC {
	
	/**
	 * EsmBkg1074Event 조회 이벤트 처리<br>
	 * Internet O.B/L Print Authorize[UC-BKG-009 B/L 발행 송부]
	 * B/L Issue 화면(UI_BKG-0079-09) 의 Internet Auth 버튼에 연결된 팝업
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<AuthCustVO>
	 * @exception EventException
	 */
	public List<AuthCustVO> searchCustInfo(String bkg_no) throws EventException;
	
	/**
	 * EsmBkg1074Event 조회 이벤트 처리<br>
	 * sendAuthEmail 발행 송부]
	 * B/L Issue 화면(UI_BKG-0079-09) 의 Internet Auth 버튼에 연결된 팝업
	 * @author LEE JIN SEO
	 * @param Mail mail
	 * @exception EventException
	 */
	public void sendAuthEmail(Mail mail)throws EventException;	
	/**
	 * EsmBkg007909Event 조회 이벤트 처리<br>
	 * B/L validateBlIssue 체크 <br>
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @return BlStatusVO
	 * @exception EventException
	 */
	public BlStatusVO validateBlIssue(BlIssInfoVO blIssInfoVO) throws EventException;
	/**
	 * EsmBkg007909Event 조회 이벤트 처리<br>
	 * B/L Issue 정보 조회<br>
	 * B/L Type, Freight 지불 여부 등의 B/L 발행 전 필요사항을 기입
	 * @author LEE JIN SEO
	 * @param BlIssueVO blIssueVO
	 * @return BlIssueVO
	 * @exception EventException
	 */
	public BlIssueVO searchBlIssInfo(BlIssueVO blIssueVO) throws EventException;
	/**
	 * EsmBkg007909Event 저장 이벤트 처리<br>
	 *  B/L Issue  관련 정보를 관리한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void manageBlIssInfo(BlIssInfoVO blIssInfoVO)  throws EventException;
	/**
	 * EsmBkg007909Event 저장 이벤트 처리<br>
	 * B/L Issue  관련 정보를 관리한다<br>
	 * Issue/Internet AUTH/SWB Release/Cancel AUTH
	 * 
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException;	
	/**
	 * EsmBkg0649Event 조회 이벤트 처리<br>
	 * B/L Issue 정보 조회<br>
	 * @author LEE JIN SEO
	 * @param String bl_no
	 * @return ReIssueVO
	 * @exception EventException
	 */
	public ReIssueVO searchBlReIssue(String bl_no) throws EventException;
	
	/**
	 * EsmBkg0649Event 저장 이벤트 처리<br>
	 * B/L Re-Issue  정보를 추가/수정한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param ReIssueVO reIssueVO
	 * @exception EventException
	 */
	public void manageBlReIssue(ReIssueVO reIssueVO) throws EventException;

	/**
	 * EsmBkg0400Event 조회 이벤트 처리<br>
	 * O.B/L Surrender 데이터 조회<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String blNo
	 * @return List<SrndVO>
	 * @exception EventException
	 */
	public List<SrndVO> searchSurrenderInfo(String bkgNo,String blNo) throws EventException;
	/**
	 * EsmBkg0400Event 저장 이벤트 처리<br>
	 * B/L 정보에서 Surrender 관련사항을 업데이트 한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param SrndVO srndvo
	 * @exception EventException
	 */
	public void modifySurrenderInfo(SrndVO srndvo) throws EventException;
	/**
	 * EsmBkg0400Event 삭제 이벤트 처리<br>
	 * B/L 정보에서 Surrender 관련사항을 초기화 한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @exception EventException
	 */
	public void removeSurrenderInfo(String bkgNo) throws EventException;
	/**
	 * EsmBkg00059Event 조회 이벤트 처리<br>
	 * Documentation Requirement(ESM_BKG-0079 의 B/L INFO의 POP-UP)<br>
	 * 화면번호 : Documentation Requirement 데이터를 조회 -- UI_BKG-0059 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String ofc_cd
	 * @return List<DocRqstVO>
	 * @exception EventException
	 */
	public List<DocRqstVO> searchDocRqst(String bkg_no ,String ofc_cd) throws EventException;
	/**
	 * EsmBkg00059Event 저장 이벤트 처리<br>
	 * Documentation Requirement 데이터를 수정한다. -- UI_BKG-0059<br>
	 * 
	 * @author LEE JIN SEO
	 * @param DocRqstVO docrqstvo
	 * @exception EventException
	 */
	public void modifyDocRqst(DocRqstVO docrqstvo) throws EventException;

	
	
	
	
	
	
	
	/**
	 * 조회 이벤트 처리
	 *  MultiCombo 조회 이벤트 처리 ESM_BKG_0278
	 *
	 * @param BkgComboVO bkgComboVO
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO> searchSRouteFromList(BkgComboVO bkgComboVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 *  ESM_BKG_0280화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param GrpBlPrtInVO grpBlPrtInVO
	 * @return GrpBlPrtOutVO
	 * @exception EventException
	 */
	public GrpBlPrtOutVO searchBkgListForGrpBlPr(GrpBlPrtInVO grpBlPrtInVO) throws EventException;

    /**
     * Original B/L 회수 여부와 상세 정보 입력 이벤트 처리<br>
     * @param BlIssVO blIssueVO 
     * @exception EventException
     */
    public void manageOblRcv(BlIssVO blIssueVO) throws EventException;
    
    /**
     * Original B/L 회수 여부와 상세 정보 입력 이벤트 처리<br>
     * @param BkgBlIssVO[] blStatusVOs
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageOblRcvByUsCgo(BkgBlIssVO[] blStatusVOs,SignOnUserAccount account) throws EventException;
    

    /**
     * searchBlListForGroupUpdate
     * 
     * @param GrpBlDtInVO grpBlDtInVO
     * @return GrpBlDtVO
     */
    public GrpBlDtVO searchBlListForGroupUpdate(GrpBlDtInVO grpBlDtInVO) throws EventException;

    /**
     * modifyGroupBlUpdate
     * 
     * @param GrpBlDtListVO grpBlDtListVO
     * @param GrpBlDtInVO grpBlDtInVO
     * @exception EventException
     */
    public void modifyGroupBlUpdate(GrpBlDtListVO grpBlDtListVO, GrpBlDtInVO grpBlDtInVO) throws EventException;
    
	/**
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.<br>
	 * 
	 * @param ObDblWblInVO obDblWblInVO
	 * @return DblWblOutVO
	 * @exception EventException
	 */
	public DblWblOutVO searchBkgListForObDblWbl(ObDblWblInVO obDblWblInVO) throws EventException;
	
	/**
	 * Draft BL 및 Waybill 전송을 위한 Inbound booking list를 조회한다.<br>
	 * 
	 * @param InDblWblInVO inDblWblInVO
	 * @return DblWblOutVO
	 * @exception EventException
	 */
	public DblWblOutVO searchBkgListForIbDblWbl(InDblWblInVO inDblWblInVO) throws EventException;
	
	/**
	 * BKG에 해당하는 Draft B/L 전송시 Chinese Booking Agent Code에 있는 Email 주소 조회한다.<br>
	 * 
	 * @param List<String> bkgNos
	 * @return List<AgentEmlVO>
	 * @exception EventException
	 */
	public List<AgentEmlVO> searchBkgAgentEml(List<String> bkgNos) throws EventException;
	
    /**
     * Booking 별 Fax, Mail의 전송결과를 조회한다.<br>
     * 
     * @param MultiNtcHisVO multiNtcHisVO
     * @return List<MultiNtcHisVO>
     * @exception EventException
     */
    public List<MultiNtcHisVO> searchMultiNtcHis(MultiNtcHisVO multiNtcHisVO) throws EventException;
    
	/**
	 * 조회 이벤트 처리
	 *  Rider 여부판단 ESM_BKG_0927
	 *
	 * @param String bkg_no
	 * @param String hiddenData
	 * @param String rate
	 * @param String cntr
	 * @param String corr_no
	 * @return String
	 * @exception EventException
	 */
	public String searchRiderYn(String bkg_no, String hiddenData, String rate, String cntr, String corr_no) throws EventException;
	
	/**
	 * 조회 이벤트 처리
	 *  HouseB/L 여부판단 ESM_BKG_0927
	 *
	 * @param String bkg_no
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchHouseBlYn(String bkg_no) throws EventException;
	
	/**
	 * EsmBkg0743Event 조회 이벤트 처리<br>
	 * B/L Release 정보 조회<br>
	 * Original B/L Print 기록 여부판단
	 * @author PARK JOON YONG
	 * @param String bkg_no
	 * @param String corr_no
	 * @return String
	 * @exception EventException
	 */
	public String searchOblRlseFlg(String bkg_no, String corr_no) throws EventException;
	
	/**
	 * EsmBkg0927Event 조회 이벤트 처리<br>
	 * B/L Iss 정보 조회<br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception EventException
	 */
	public String searchOblIssFlg(String bkg_no) throws EventException;
	
	/**
	 * EsmBkg0927Event Email 이벤트 처리
	 * Email 전송
	 *
	 * @param DblWblVO[] dblWblVOs
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendDblWblByEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * EsmBkg0927Event Fax 이벤트 처리
	 * Fax 전송
	 *
	 * @param DblWblVO[] dblWblVOs
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendDblWblByFax(DblWblVO[] dblWblVOs, SignOnUserAccount account) throws EventException;

    /**
     * B/L 발행 송부 - Draft B/L 자동발송
     * 
     * @author Jeon Sung-Jin
     * @param String bkgNo
     * @param String blChgFlg
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> createDraftBlEdiAuto(String bkgNo, String blChgFlg, SignOnUserAccount account) throws EventException;
    
    /**
     * B/L 발행 송부 - Draft B/L 발송
     * 
     * @author Park Jun-Yong
     * @param DblEdiInVO dblEdiInVO
     * @param SignOnUserAccount account
     * @return DblEdiVO
     * @exception EventException
     */
    public DblEdiVO createDraftBlEdi(DblEdiInVO dblEdiInVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * 조회 이벤트 처리
	 * B/L no나 BKG no 오류체크 처리 ESM_BKG_0418
	 *
	 * @param String inoutMode
     * @param String vvd
     * @param String port
     * @param String[] bkgBlNos
     * @return String
     * @exception EventException
	 */
	public String validBkgBlNo(String inoutMode, String vvd, String port, String[] bkgBlNos) throws EventException;

	   
    /**
     * B/L no나 BKG no 오류체크
     * 
     * @param CanonEmlVO canonEml
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendCanonEmlBkg(CanonEmlVO canonEml, SignOnUserAccount account) throws EventException;

    /**
     * C/A를 위해 BlIssuanceBC의 책임 table들을 복사한다.<br>
     * : 1. bkg_bl_iss를 복사한다.
     * : 2. copyTypeCd에 따라 'TEMP'나 'BKG'이면 caNo = 'TMP0000001'으로 하고 'HIST'이면 bkgBlNoVO.caNo로 한다.
     * @author    Lee NamKyung
     * @param     BkgBlNoVO bkgBlNoVO
     * @param     String copyTypeCd
     * @exception EventException
     */
    public void createIssCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException; 

    /**
     * C/A를 위해 booking 관련 BlIssuanceBC의 책임table을 삭제한다.
     * 
     * @author      Lee NamKyung
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String copyTypeCd
     * @exception   EventException
     */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * LOCAL ISS 세부정보 수정
	 * 
	 * @param BkgBlIssVO bkgBlIssVO
	 * @throws EventException
	 */
	public void modifyIbDtlBlIss(BkgBlIssVO bkgBlIssVO) throws EventException;
	
	/**
	 * BKG_BL_ISS테이블 OBL_RLSE_FLG 관련 정보를 관리한다.<br>
	 * ESM_BKG_0743	연동 System	
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void modifyOBLRlseFlg(BlIssInfoVO blIssInfoVO)  throws EventException;

	/**
	 * searchVesselNameByBkgNo.<br>
	 * bkgNo로 vessel명을 가져온다.	
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselNameByBkgNo(String bkgNo) throws EventException;

	/**
     * EsmBkg0927Event Email 이벤트 처리
     * Email 전송
     *
     * @param DblWblVO dblWblVO
     * @param String tpId
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblAutoEmail(DblWblVO dblWblVO, String tpId, SignOnUserAccount account) throws EventException;
    
    /**
     * E-B/L Issue 대상을 조회한다.<br>
     * 
     * @param EBLIssueInputVO eBLIssueInputVO
     * @return List<EBLIssueVO>
     * @exception EventException
     */
    public List<EBLIssueVO> searchEBLIssueList (EBLIssueInputVO eBLIssueInputVO) throws EventException ;
    
    
    /**
     * E-B/L Issue
     * @param String bkgNo
     * @param String srStsCd
     * @param String rate
     * @param String hiddenData
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageEBLIssue(String bkgNo, String srStsCd, String rate, String hiddenData, SignOnUserAccount account) throws EventException;
    
    /**
     * E-B/L Re-Issue
     * @param String bkgNo
     * @param String srStsCd
     * @param String rate
     * @param String hiddenData
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageEBLReIssue(String bkgNo, String srStsCd, String rate, String hiddenData, SignOnUserAccount account) throws EventException;
    
    /**
     * E-B/L Reject
     * @param String bkgNo
     * @param String srStsCd
     * @param String remark
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageEBLReject(String bkgNo, String srStsCd, String remark, SignOnUserAccount account) throws EventException;
    
    /**
     *  E-B/L Issue
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageEBLConfirm(String bkgNo, SignOnUserAccount account) throws EventException ;

    /**
     *  E-B/L Issue
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageDelConfirm(String bkgNo, SignOnUserAccount account) throws EventException ;
    
    /**
     *  E-B/L Issue
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageConfirm(String bkgNo, SignOnUserAccount account) throws EventException ;

	/**
	 * Web Service EAI용(WEB_004_0001)<br>
	 * 한진해운 홈페이지에서 OBL 출력시 ALPS에 출력정보 업데이트<br>
	 * 
	 * @param BkgWebService004VO bkgWebService004VO
	 * @exception EventException
	 */
	public void modifyWeb0040001Control(BkgWebService004VO bkgWebService004VO) throws EventException;

	/**
	 * Web Service EAI용(WEB_005_0001)<br>
	 * 한진해운 홈페이지에서 OBL 출력시 ALPS에 출력정보 업데이트<br>
	 * 
	 * @param BkgWebService005VO bkgWebService005VO
	 * @exception EventException
	 */
	public void modifyWeb0050001Control(BkgWebService005VO bkgWebService005VO) throws EventException;
 
	
	/**
     * ESM_BKG_1119
     * Retrieve버튼 클릭시 Data를 조회한다.<br>
     * 
     * @param BlIssRqstVO blIssRqstVO
     * @return List<BlIssRqstVO>
     * @exception EventException
     */
    public List<BlIssRqstVO> searchBlIssRqstList(BlIssRqstVO blIssRqstVO) throws EventException;	
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 명세 화면 설정을 위한 Data를 조회한다.
	 * 
     * @param String xterRqstNo
     * @param String xterRqstSeq
     * @return BlIssRqstVO
     * @exception EventException
	 */
    public BlIssRqstVO searchBlIssRqstInquiry(String xterRqstNo, String xterRqstSeq) throws EventException;    
    
	/**
	 * ESM_BKG_1119
	 * B/L 발급 신청 리스트 화면에서 Delete버튼을 클릭했을 때 delt_flg값을 'Y'으로 Update한다.
	 * 
     * @param BlIssRqstVO[] blIssRqstVOs
     * @param String updUsrId
     * @exception EventException
	 */
    public void modifyBlIssRqstDeltFlg(BlIssRqstVO[] blIssRqstVOs, String updUsrId) throws EventException;   
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 상세 화면에서 Approval버튼을 클릭했을 때 상태코드와 remark를 Update한다.
	 * 
     * @param BlIssRqstVO blIssRqstVO
     * @param String updUsrId
     * @exception EventException
	 */
    public void modifyBlIssRqstApproval(BlIssRqstVO blIssRqstVO, String updUsrId) throws EventException;
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 상세 화면에서 Reject버튼을 클릭했을 때 상태코드와 remark를 Update한다.
	 * 
     * @param BlIssRqstVO blIssRqstVO
     * @param String updUsrId
     * @exception EventException
	 */
    public void modifyBlIssRqstReject(BlIssRqstVO blIssRqstVO, String updUsrId) throws EventException;   
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 상세 화면에서 Approval버튼을 클릭했을 때 상태코드와 remark가 Update 된 뒤 메일을 발송
	 * 
     * @param BkgBlIssRqstMailSndVO bkgBlIssRqstMailSndVO
     * @param SignOnUserAccount account
     * @exception EventException
	 */
    public void sendBlIssRqstByMail(BkgBlIssRqstMailSndVO bkgBlIssRqstMailSndVO, SignOnUserAccount account) throws EventException;
    
    

    /**
	 * EsmBkg0218Event Email 이벤트 처리
	 * Email(S/R) 전송
	 *
	 * @param DblWblVO[] dblWblVOs
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendSrEmail(DblWblVO[] dblWblVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * EsmBkg0218Event Email 이벤트 처리
	 * Email(E/Q) 전송
	 *
	 * @param DblWblVO[] dblWblVOs
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendEqEmail(DblWblVO[] dblWblVOs, SignOnUserAccount account) throws EventException;
	
    /**
     * EsmBkg0726Event 저장 이벤트 처리<br>
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageGrpBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException; 
    
	/**
	 * e-Booking S/I upload 시 BL Ready 정보를 update 한다.
	 * 
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
	 */
    public void modifyBlRdyInfo(BlIssInfoVO blIssInfoVO) throws EventException;
    
    /**
     * 
     * Late SI,AES/CAED Notice를 전송한다.
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public List<BkgNtcHisVO> sendRmdEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
    
    
	/**
	 * Doc cut-off 및 AES/CAED Reminder관련 정보를 조회한다.
	 * 
	 * @param String bkg_no
	 * @return SearchReminderEmailVO
	 * @throws EventException
	 */
	public SearchReminderEmailVO searchReminderEmail(String bkg_no) throws EventException;
	
    

    
    /**
     * @param N3ptyBlRqstVO n3ptyBlRqstVO
     * @return List<N3ptyBlRqstVO>
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public List<N3ptyBlRqstVO> searchN3ptyBlRqst(N3ptyBlRqstVO n3ptyBlRqstVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * 3rd Party Billing & Issue Request데이터를 생성한다.
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void createN3ptyBlRqst(String bkgNo, SignOnUserAccount account) throws EventException;
    
    
    /**
	 * DRAFT Remark를 구한다.
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
    public String searchDraftRemark(String bkgNo) throws EventException;
	
    
	/**
	 * Philips 계약인지 확인
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchPhilipsCheck(String bkgNo) throws EventException;
	
	
	/**
	 * 해당 사용자의 조회조건을 조회한다.<br>
	 * @param String userId
	 * @return List<BkgSrchSetVO>
	 * @throws EventException
	 */
	public List<BkgSrchSetVO> searchSrchSetForList(String userId) throws EventException;
	
	
    /**
     * 3rd Party Billing & Issue Request데이터를 저장한다.
     * @param N3ptyBlRqstVO[] n3ptyBlRqstVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void modifyN3ptyBlRqst(N3ptyBlRqstVO[] n3ptyBlRqstVOs,SignOnUserAccount account) throws EventException;
    
    /**
     * approval과 reject결과를 메일로 전송한다.
     * @param N3ptyBlRqstVO n3ptyBlRqstVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void sendN3ptyBlRqst(N3ptyBlRqstVO n3ptyBlRqstVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * BL Issue note list조회
	 * @param String bkgNo
	 * @return List<BkgMdtItmVO>
	 * @throws EventException
	 */
	public List<BkgMdtItmVO> searchBlIssNote(String bkgNo) throws EventException;
	
	/**
	 * 3rd party request관련 생성된 request당 파일 목록을 조회한다.
	 * @param BlAtchVO blAtchVO
	 * @return List<BlAtchVO>
	 * @throws EventException
	 */
	public List<BlAtchVO> searchBlAtchList(BlAtchVO blAtchVO) throws EventException;
	
	
	/**
	 * 3rd party request관련 생성된 request당 파일 목록을 저장한다.
	 * @param BlAtchVO[] blAtchVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBlAtch(BlAtchVO[] blAtchVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Bl Certi Requset 목록을 조회한다.
	 * @param BlCertiRqstVO blCertiRqstVO
	 * @return List<BlCertiRqstVO>
	 * @throws EventException
	 */
	public List<BlCertiRqstVO> searchBlCertiRqst(BlCertiRqstVO blCertiRqstVO) throws EventException;
	
	
    /**
     * BL certi Status 를 수정(ESM_BKG_9464)
     * @param BlCertiRqstVO blCertiRqstVO
     * @throws EventException
     */
    public void manageBlCertiSts(BlCertiRqstVO blCertiRqstVO) throws EventException;
    
    /** BL Certi Print flag를 업데이트한다.
     * @param BlCertiRqstVO[] blCertiRqstVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageBlCertiPrn(BlCertiRqstVO[] blCertiRqstVOs, SignOnUserAccount account) throws EventException;
    
    
    /**
     * Web OB/L Paper Management를 조회
     * @param BkgCustBlPprMgmtVO blPprMgmtVO
     * @return List<BlPprMgmtVO>
     * @throws EventException
     */
    public List<BkgCustBlPprMgmtVO> searchBlPprMgmt(BkgCustBlPprMgmtVO blPprMgmtVO) throws EventException; 
    
	/**
	 * Web OB/L Paper Management를 저장
	 * @param BkgCustBlPprMgmtVO[] blPprMgmtVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBlPprMgmt(BkgCustBlPprMgmtVO[] blPprMgmtVOs, SignOnUserAccount account) throws EventException;
	
	
    /**
     * Web OB/L Paper Management화면의 정보를 저장시 중복된 값이 있는지 체크한다.
     * @param BkgCustBlPprMgmtVO blPprMgmtVO
     * @return String
     * @throws EventException
     */
    public String checkBlPprMgmt(BkgCustBlPprMgmtVO blPprMgmtVO) throws EventException;
    
    
    /**
     * OBL 용지배부내역 히스토리을 조회한다.(ESM_BKG_9468)
     * @param BkgCustBlPprMgmtHisVO blPprMgmtHisVO
     * @return List<BkgCustBlPprMgmtHisVO>
     * @throws EventException
     */
    public List<BkgCustBlPprMgmtHisVO> searchBlPprMgmtHis(BkgCustBlPprMgmtHisVO blPprMgmtHisVO) throws EventException;

    /**
     * CA Confirm시 Charge 데이터가 달라졌는지 체크한다.
     * @param String bkgNo
     * @return String
     * @throws DAOException
     */
    public String checkDiffChargeData(String bkgNo) throws EventException;
    
    /**
   	 * BL Data Complete update한다.<br>
   	 * @param BlIssInfoVO[] blIssInfoVOs
   	 * @exception DAOException
   	 */
   	public void updateBLComplete(BlIssInfoVO[] blIssInfoVOs) throws EventException;
   	
    /**
     * 이메일 보내기
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public List<BkgNtcHisVO> sendBLByEmailForSamsung (DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
    
    /**
     * 조건과 맞다면 bl issue시에 이메일과 함께 BL PDF파일이 전송(삼성)
     * @param String bkgNo
     * @return String
     * @throws DAOException
     */
    public String checkAutoEmailWithBLForSamsung(String bkgNo) throws EventException;

}