/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EBookingReceiptBC.java
 *@FileTitle : e-Booking n SI Process
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.05.21 전용진
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
 * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
 * 2011.03.29 이일민 [] seanaccs처럼 samsung추가
 * 2011.03.31 이일민 [CHM-201109868-01] e-Booking & SI Request pop-up 기능 변경
 * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
 * 2011.08.24 김기종 [CHM-201112495-01] Split Candidate 후보 flag변경(취소)기능 개발요청
 * 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
 * 2012.06.21 조정민 [CHM-201218361] [BKG] [삼성전자] BOKCON 재전송 기능 검토 요청
 * 2013.02.06 이재위 [CHM-201322717-01] IKEA Booking Upload시 Key Data Check 로직 추가요청
 * 2014.08.22 최도순[CHM-201431653] e-BKG cancel request 업로드 시에도 remark란 입력 및 저장 기능 활성화
 * 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterChgRtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterVrfdWgtPtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterVrfdWgtRqstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.EBookingControlMgmtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstAkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBbVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstDgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl1VO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl2VO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstMndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstRfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SearchXterPoMdtItmParmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCustChkPntVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterDgRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterEtcInterfaceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterInnerPackageVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImgStoVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;

/**
 * ALPS-Ebookingconduct Business Logic Command Interface<br>
 * - ALPS-Ebookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jun Yong Jin
 * @see Esm_bkg_0228EventResponse 참조
 * @since J2EE 1.4
 */

public interface EBookingReceiptBC {
	/**
	 * 채번된 bkg_no, bkg_no_split을 assign한다.<br>
	 * booking receipt 자동 전송 대상 업체일 경우 booking receipt를 보낸다.
	 * (ebkg이 아닌 일반 booking에서 보내는 booking receipt와는 flatfile이 다르다)<br>
	 * E-BKG Receipt ACK EDI 전송<br>
	 *
	 * @param rqstNoVo XterRqstNoVO 
	 * @exception EventException
	 */
	public void assignBkgNoToXterRqst(XterRqstNoVO rqstNoVo) throws EventException;
	/**
	 * 필요에 따라 Booking Staff이 External Request의 상태를 조정한다.<br>
	 * 상태 종류는 New, Firm, Reject, Pending이 있다.<br>
	 *
	 * @param XterRqstNoVO[] xterRqstNoVO
	 * @param String newSts
	 * @param String reInstCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeXterRqstStatus(XterRqstNoVO[] xterRqstNoVO,String newSts,String reInstCd,SignOnUserAccount account) throws EventException;
	/**
	 * bkg_xter_rqst에 upload 했다는 기록을 남긴다.<br>
	 * bkg no, confirm date, user, status 변경 등.<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void completeUpload(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * external request에 대해 Ack Edi Flatfile을 만든다.<br> 
	 * (send_NIS2010BKG_UBIZHJS_ACK)<br>
	 *
	 * @param  docTpCd String
	 * @param  xterRqstNoVO XterRqstNoVO
	 * @return String
	 * @exception EventException
	 */
	public String createXterBkgAckEdi(String docTpCd, XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * external request에 대해 reject에 대한 edi를 화주별 format으로 만든다.<br>
	 *
	 * @param String rjctRsnRmk
	 * @param String xterRjctRsnCd
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createXterRqstRejectEdi(String rjctRsnRmk, String xterRjctRsnCd, XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * eBkg을 통해 Bkg No가 생성된 경우 그 정보를 BKG_XTER_RQST_MST에 업데이트함<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterBkgNo(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * eBkg Customer Code를 ALPS Customer 정보를 토대로 업데이트함<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterCustCustCd(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * FlatFile 형태의 External Request를 bkg/doc의 data로 insert한다<br>
	 *
	 * @param  rcvMsg String
	 * @return XterRqstNoVO
	 * @exception EventException
	 */
	public XterRqstNoVO receiptXterRqst(String rcvMsg) throws EventException;
	
	/**
	 * Excel 파일에서 추출한 External Request를 VGM의 data로 insert한다<br>
	 *
	 * @param	List<BkgXterVrfdWgtRqstVO> rqstList
	 * @param	List<BkgXterVrfdWgtPtyVO> ptyList 
	 * @exception EventException
	 */
	public void receiptXterVGMRqstXls(List<BkgXterVrfdWgtRqstVO> rqstList, List<BkgXterVrfdWgtPtyVO> ptyList) throws EventException;
	
	/**
	 * FlatFile 형태의 External Request를 VGM의 data로 insert한다<br>
	 *
	 * @param  rcvMsg String
	 * @exception EventException
	 */
	public void receiptXterVGMRqst(String rcvMsg) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Find Booking 버튼 Click 시 ALPS Booking 정보만 조회 <br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public ExternalRqstBkgVO searchAlpsBkg(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * continent code를 조회한다.<br>
	 *
	 * @return List&lt;BkgComboVO&gt;
	 * @exception EventException
	 */
	public List<BkgComboVO> searchComboMdmConti() throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * extenal request의 awkward cargo 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstAkVO
	 * @exception EventException
	 */
	public ExternalRqstAkVO searchXterAk(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * extenal request의 break bulk cargo 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstAkVO
	 * @exception EventException
	 */
	public ExternalRqstBbVO searchXterBb(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * External Request의 정보를 Booking Data로 Create/Update하기 위해서 해당 External Request의 상세 정보를 조회함.<br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public ExternalRqstBkgVO searchXterBkg(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * extenal request의 container manifest 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCmVO
	 * @exception EventException
	 */
	public ExternalRqstCmVO searchXterCm(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * extenal request의 container 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCntrVO
	 * @exception EventException
	 */
	public ExternalRqstCntrVO searchXterCntr(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 customer 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCustVO
	 * @exception EventException
	 */
	public ExternalRqstCustVO searchXterCust(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 danger cgo 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstDgVO
	 * @exception EventException
	 */
	public ExternalRqstDgVO searchXterDg(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * extenal request의 house b/l들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstHbl1VO
	 * @exception EventException
	 */
	public ExternalRqstHbl1VO searchXterHbl1(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * extenal request의 ams file no들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstHbl2VO
	 * @exception EventException
	 */
	public ExternalRqstHbl2VO searchXterHbl2(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 mark & Description 정보를 조회한다.<br>
	 * BKG_XTER_XPT_LIC_NO, BKG_XTER_AES, BKG_XTER_RQST_MST, BKG_XTER_CNTR에서 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String usrOfc
	 * @return ExternalRqstMndVO
	 * @exception EventException
	 */
	public ExternalRqstMndVO searchXterMnd(XterRqstNoVO xterRqstNoVO, String usrOfc) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstRfVO
	 * @exception EventException
	 */
	public ExternalRqstRfVO searchXterRf(XterRqstNoVO xterRqstNoVO) throws EventException;

	/**
	 * 수신한 External Request List를 조회함<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return List<ExternalRqstListVO>
	 * @exception EventException
	 */
	public List<ExternalRqstListVO> searchXterRqstList(ExternalRqstListInputVO xterRqstListInputVO) throws EventException;

	/**
	 * 해당 사용자의 external request 조회조건을 조회한다.<br>
	 *
	 * @param String userId
	 * @return List<BkgXterSrchSetVO>
	 * @exception EventException
	 */
	public List<BkgXterSrchSetVO> searchXterSrchSetForList(String userId) throws EventException;

	/**
	 * extenal request의 tro 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstTroVO
	 * @exception EventException
	 */
	public ExternalRqstTroVO searchXterTro(XterRqstNoVO xterRqstNoVO) throws EventException;

	/**
	 * ebkg 담당자에게 발생한 err에 대해 g/w mail로 전송한다.<br>
	 *
	 * @param String errStr
	 * @param String flatFileStr
	 * @exception EventException
	 */
	public void sendErrLogMail(String errStr, String flatFileStr) throws EventException;

	/**
	 * e-svc로 발생한 err에 대해 eai로 전송한다.<BR>
	 * @param String eaiIfTp
	 * @param String eaiIfMsg
	 * @param XterRqstNoVO xterRqstNoVO
	 */
	public void sendErrMsgToEsvc(String eaiIfTp, String eaiIfMsg, XterRqstNoVO xterRqstNoVO);

	/**
	 * eBKG reject 내역을 email로 전송한다.<br>
	 *
	 * @param String bkgNo
	 * @param String senderEml
	 * @param String cntcEml
	 * @param String rjctRsnRmk
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendXterRqstRejectEmail(String bkgNo, String senderEml, String cntcEml, String rjctRsnRmk, SignOnUserAccount account) throws EventException;

	/**
	 * eBKG pending 내역을 email로 전송한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String emlSndYn
	 * @param String senderEml
	 * @param String cntcEml
	 * @param String xterRjctRsnCd
	 * @param String pendingRsnRmk
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendXterRqstPendingNotice(XterRqstNoVO xterRqstNoVO, String emlSndYn, String senderEml, String cntcEml, String xterRjctRsnCd, String pendingRsnRmk, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Po No 정보만 조회 <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return BkgReferenceVO
	 * @exception EventException
	 */
	public BkgReferenceVO searchAlpsPoNo(String bkgNo, String cntrNo ) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Po No 정보만 조회 <br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterInnerPackageVO>
	 * @exception EventException
	 */
	public List<XterInnerPackageVO> searchXterInnerPackage(XterRqstNoVO xterRqstNoVO) throws EventException;

	/**
	 * e-Booking Control for Vessel Slot Management 조회(ESM_BKG_1088)<br>
	 *
	 * @param EBookingControlMgmtVO eBookingControlMgmtVO
	 * @return List<EbookingControlMgmtVO>
	 * @exception EventException
	 */
	public List<EBookingControlMgmtVO> searchEBookingControlForVslMgmt(EBookingControlMgmtVO eBookingControlMgmtVO) throws EventException;
	
	/**
	 * e-Booking Control Management 수정(ESM_BKG_1088)<br>
	 * 
	 * @param List<EBookingControlMgmtVO> eBookingControlMgmtVOList
	 * @param String modifyMode
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyEBookingControlMgmt(List<EBookingControlMgmtVO> eBookingControlMgmtVOList, String modifyMode, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Container Etc Info 조회 <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return CntrEtcInfoVO
	 * @exception EventException
	 */
	public CntrEtcInfoVO manageCntrEtcInfo(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * BKG CONTAINER의 VGM WGT 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @param ContainerVO[] containerVOs
	 * @return ContainerVO
	 * @exception EventException
	 */
	public ContainerVO searchBkgCntrVgmWgt(String bkgNo, ContainerVO[] containerVOs) throws EventException;
	
	/**
	 * B/L ISS 조회한다.(ESM_BKG_022901)<br>
	 * 
	 * @author 	KimYoungCheal
	 * @param 	XterRqstNoVO xterRqstNoVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	public void searchBlIss(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 필요에 따라 Booking No를 저장한다.<br>
	 *
	 * @param XterRqstNoVO[] xterRqstNoVO
	 * @exception EventException
	 */
	public void changeXterRqstBkgNo(XterRqstNoVO[] xterRqstNoVO) throws EventException;
	
	/**
	 * ESM_BKG_0228 : 0228에서 Detail 부분 Open시에 Validation 부분
	 * EBookingReceipt의 Seanaccs Validation 정보 조회<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return XterRqstValidationVO
	 * @exception EventException
	 */
	public XterRqstValidationVO searchXterRqstValidation(ExternalRqstListInputVO xterRqstListInputVO) throws EventException;	

	/**
	 * searchMqXlsGroupList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsGroupList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;

	/**
	 * searchMqXlsMappingList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;
	
	/**
	 * searchMqXlsGroupList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsBkgGroupList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;
	
	/**
	 * searchMqXlsMappingList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsBkgMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;

	/**
	 * booking split 관련 상태 수정(ESM_BKG_0099)<br>
	 * 
	 * @param SplitBlInfoVO splitBlInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterBkgNoBySplit(SplitBlInfoVO splitBlInfoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancel Split Candidate (ESM_BKG_0445)<br>
	 * 
	 * @param SplitBlInfoVO splitBlInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterBkgNoBySplitStsCd(SplitBlInfoVO splitBlInfoVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * @param String flatFileStr 
	 * @param String srProcTpCd
	 * @throws EventException
	 */
	public void addBkgSrProcHisPrc(String flatFileStr, String srProcTpCd) throws EventException;
	
	/**
	 * @param String srNo
	 * @param String faxLogRefNo
	 * @param String srProcTpCd
	 * @param String usrId
	 * @throws EventException
	 */
	public void addBkgSrProcHisPrcSql(String srNo, String faxLogRefNo, String srProcTpCd, String usrId)throws EventException;
	
	
	/**
	 * @param String flatFileStr
	 * @throws EventException
	 */
	public void sendSiTransErrMail(String flatFileStr) throws EventException;
	
	/**
	 * 신규 추가된 TP에 대해 BKG 신규 생성 후 BOKCON 발송기능 추가
	 * 
	 * @param XterRqstNoVO rqstVO
	 * @throws EventException
	 */
	public void sendBOKCON(XterRqstNoVO rqstVO) throws EventException;
	
	/**
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<BlRiderVo>
	 * @throws EventException
	 */
	public List<BlRiderVO> searchXterImgSto(XterRqstNoVO xterRqstNoVO) throws EventException;
	
	/**
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BlRiderVO>
	 * @throws EventException
	 */
	public List<BlRiderVO> searchBkgImgSto(BkgBlNoVO bkgBlNoVO) throws EventException;
	/**
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchXterDgRiderList(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchXterDgRiderCntrList(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO> 
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchAlpsDgRiderList(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * @param xterRqstNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchAlpsDgRiderCntrList(XterRqstNoVO xterRqstNoVO)  throws EventException;
	
	/**
	 * VGM Terminal EDI outbound
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rcvId
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createTerminalVERMASEdi(BkgBlNoVO bkgBlNoVO, String rcvId) throws EventException;
	
	/**
	 * VGM Upload 후 결과 ACK 전송을 위한 Flat File 생성
	 * @param XterVgmRqstListVO xterVgmRqstListVO
	 * @param String rcvId
	 * @return 
	 * @throws EventException
	 */
	public void createVGMUploadAckEdi(XterVgmRqstListVO xterVgmRqstListVO, String rcvId) throws EventException;
	
	/**
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createBOKCONEdi(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * PO NO의 path item 조회
	 * @param SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO
	 * @return String
	 * @throws EventException
	 */
	public String searchXterPoMdtItm(SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO) throws EventException;
	
	/**
	 * BL Issue 상태 조회
	 * @param String bkgNo
	 * @return List<HistoryLineVO>
	 * @throws EventException
	 */
	public List<HistoryLineVO> searchBlIssComplete(String bkgNo) throws EventException;
	
	/**
	 * IKEA Customer 인지 여부를 체크한다
	 * @param SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateEdiIkeaCust(SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO) throws EventException;
	
	/**
	 * Container Type Size 여부를 체크한다
	 * @param String cntrTpSz
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrTpSz(String cntrTpSz) throws EventException;	
	
	/**
	 * ALPS b/l Wharfage search
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<KrWhfBlExptInfoVO>
	 * @throws EventException
	 */
	public List<KrWhfBlExptInfoVO> searchKrWhfBlExptInfo(BkgBlNoVO bkgBlNoVO) throws EventException ;
	
	/**
	 * e-SVC b/l Wharfage search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<KrWhfBlExptInfoVO>
	 * @throws EventException
	 */
	public List<KrWhfBlExptInfoVO> searchXterKrWhfBlExptInfo(XterRqstNoVO xterRqstNoVO) throws EventException ; 	
	
	
	/**
	 * Xter Upload Sts Code 조회
	 * @param xterRqstNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchXterBkgSts(XterRqstNoVO xterRqstNoVO) throws EventException;	
	
	/**
	 * Allcoation Popup Firm Notice Send
	 * @param AllocStsVO allocStsVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendXterRqstAllocationNotice(AllocStsVO allocStsVO,BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking pol이 Europe 인지 확인하고 POD 목록을 조회<br>
	 * @param String bkgNo
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchXterCMvalidationEuDeHjsCD(String bkgNo) throws EventException;	
	
	/**
	 * Actual Customer Name 조회<br>
	 * @param String agmtActCntCd
	 * @param String agmtActCustSeq
	 * @param String exCustNm
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchActualCustomerName(String agmtActCntCd, String agmtActCustSeq, String exCustNm  ) throws EventException;
	
	/**
	 * BKG Contract Name 조회<br>
	 * @param String bkgNo
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchBkgContactInfo(String bkgNo  ) throws EventException;
	
	
	/**
	 * e-BKG cancel request 업로드 시에도 remark 저장<br>
	 *
	 * @param String bkgNo
	 * @param String interRmk
	 * @param String xterRmk
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBkgRmk(String bkgNo , String interRmk, String xterRmk, SignOnUserAccount account) throws EventException;

	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public BkgBookingInfoVO searchXterBkgInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 customer 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BlCustomerVO
	 * @exception EventException
	 */
	public BlCustomerVO searchXterCustInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Tro 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return TroVO
	 * @exception EventException
	 */
	public TroVO searchXterTroInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Reefer cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgRfCgoVO[]
	 * @exception EventException
	 */
	public BkgRfCgoVO[] searchXterRfInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 danger cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return DgCgoListVO[]
	 * @exception EventException
	 */
	public DgCgoListVO[] searchXterDgInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 danger cgo Rider 정보를 조회한다.<br>
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgImgStoVO[]
	 * @throws EventException
	 */
	public BkgImgStoVO[] searchXterDgRiderListInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgAwkCgoVO[]
	 * @exception EventException
	 */
	public BkgAwkCgoVO[] searchXterAkInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	
	/**
	 * external request 처리를 위해 external rqst의 Awkward cgo Rider 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgImgStoVO[]
	 * @exception EventException
	 */
	public BkgImgStoVO[] searchXterAkRiderListInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	
	/**
	 * external request 처리를 위해 external rqst의 Break Bulk cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBbCgoVO[]
	 * @exception EventException
	 */
	public BkgBbCgoVO[] searchXterBbInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * MND 중 Booking Request시 접수되는 Import&Export Licence No만 별도 처리하기 위해 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return AlpsXptImpLicListVO[]
	 * @exception EventException
	 */
	public AlpsXptImpLicListVO[] searchAlpsXptImpLicListInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return XterRqstNoVO
	 * @exception EventException
	 */
	public XterRqstNoVO searchXterRqstNoInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBlNoVO
	 * @exception EventException
	 */
	public BkgBlNoVO searchBkgBlNoInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return XterEtcInterfaceVO
	 * @exception EventException
	 */
	public XterEtcInterfaceVO searchXterEtcInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return VslSkdVO[]
	 * @exception EventException
	 */
	public VslSkdVO[] searchVslSkdInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return DocRqstVO
	 * @exception EventException
	 */
	public DocRqstVO searchDocRqstInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BookingSaveValidationVO
	 * @exception EventException
	 */
	public BookingSaveValidationVO searchBookingSaveValidationInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgQuantityVO[]
	 * @exception EventException
	 */
	public BkgQuantityVO[] searchBkgQuantityInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgQtyDtlVO[]
	 * @exception EventException
	 */
	public BkgQtyDtlVO[] searchBkgQtyDtlInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BlCustomerInfoVO
	 * @exception EventException
	 */
	public BlCustomerInfoVO searchBlCustomerInfoInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 BkgTroSpclCgoSeqVO 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgTroSpclCgoSeqVO
	 * @exception EventException
	 */
	public BkgTroSpclCgoSeqVO[] searchXterBkgTroSpclCgoSeqInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 BkgQuantityVO 정보를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return BkgQuantityVO[]
	 * @exception EventException
	 */
	public BkgQuantityVO[] searchBkgQuantityVOInterface(BkgBlNoVO bkgBlNoVO) throws EventException;
	/**
	 * external request 처리를 위해 external rqst의 Reference 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgReferenceVO[]
	 * @exception EventException
	 */
	public BkgReferenceVO[] searchBkgReferenceInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException;	
	/**
	 * external request 처리를 위해 external rqst의 Job Type, BKG Block Flag, Manual Flag 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgWebServiceVO 
	 * @exception EventException
	 */
	public BkgWebServiceVO searchWebServiceProcessType(BkgWebServiceVO bkgWebServiceVO) throws EventException;
	/**
	 * Interface로 Upload된 정보 PreviousStatus Update<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyPreviousBookingRequestStatus(BkgWebServiceVO bkgWebServiceVO, SignOnUserAccount account) throws EventException;
	/**
	 * Interface로 Upload된 정보 Status Update<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyAutoUploadStatus(BkgWebServiceVO bkgWebServiceVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 *  미주지역 Rqst에 대한 Handling Office를 조회한다
	 *  
	 * @param String polCd
	 * @param String cmdtNm
	 * @return String
	 * @throws EventException
	 */
	public String searchUsHandlingOfc(String polCd, String cmdtNm) throws EventException;
	
	/**
	 * BKG Black List 체크
	 * 
	 * @param XterRqstNoVO rqstNoVo
	 * @return String
	 * @throws EventException
	 */
	public String checkBkgBlackList(XterRqstNoVO rqstNoVo) throws EventException ;
	
	/**
	 * Portal Customer 체크
	 * 
	 * @param String xterSndrId
	 * @param String custTpcd
	 * @param String custCd
	 * @return String
	 * @throws EventException
	 */
	public String checkPortalCustomerCd(String xterSndrId, String custTpcd, String custCd) throws EventException ;
	/**
	 * BKG EXEC ENIS LOGS
	 * 
	 * @param String logDesc
	 * @param String applInfo
	 * @param String modName
	 * @throws EventException
	 */
	public void createBkgExecEnisLog(String logDesc, String applInfo, String modName) throws EventException;
	
	/**
	 * e-svc a/k rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchXterAkRiderList(XterRqstNoVO xterRqstNoVO) throws EventException;
	
	/**
	 * alps a/k rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchAlpsAkRiderList(XterRqstNoVO xterRqstNoVO) throws EventException;
	
	/**
	 * 미주 서부임을 확인한다
	 * 
	 * @param String locCd
	 * @return String
	 * @throws EventException
	 */
	public String searchUsWest(String locCd) throws EventException;
	
	/**
	 * eBKG, eSI Upload 화주 Check Point 확인.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return XterCustChkPntVO
	 * @throws EventException
	 */
	public XterCustChkPntVO searchXterCustChkPnt(XterRqstNoVO xterRqstNoVO) throws EventException ;
	
	/**
	 * BKG, eSI Upload 화주 Check Point 확인.<br>
	 * 
	 * @param String bkgNo
	 * @return XterCustChkPntVO
	 * @throws EventException
	 */
	public XterCustChkPntVO searchBkgCustChkPnt(String bkgNo) throws EventException ;
	
	/**
	 * Interface로 Upload된 S/I 정보 PreviousStatus Update<br>
	 *
	 * @param XterRqstNoVO xterRqstNoRstVO
	 * @param SignOnUserAccount account
	 * @throws EventException 
	 */
	public void modifyPreviousSIRequestStatus(XterRqstNoVO xterRqstNoRstVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Job Type, BKG Block Flag, Manual Flag정보를 조회한다.<br>
	 * 
	 * @param XterRqstNoVO xterRqstNoRstVO
	 * @return SIWebServiceVO
	 * @exception EventException
	 */
	public SIWebServiceVO searchWebServiceSIProcessType(XterRqstNoVO xterRqstNoRstVO) throws EventException ;
	
	/**
	 * Interface로 Upload된 정보 Status Update<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @throws EventException 
	 */
	public void modifySIAutoUploadStatus(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgBookingInfoVO
	 * @exception EventException
	 */
	public BkgBookingInfoVO searchXterSIInterface(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BookingSaveValidationVO
	 * @exception EventException
	 */
	public BookingSaveValidationVO searchSISaveValidationInterface(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgQuantityVO[]
	 * @exception EventException
	 */
	public BkgQuantityVO[] searchSIBkgQuantityInterface(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgQtyDtlVO[]
	 * @exception EventException
	 */
	public BkgQtyDtlVO[] searchSIBkgQtyDtlInterface(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Container ETC 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return CntrEtcInfoVO
	 * @exception EventException
	 */
	public CntrEtcInfoVO searchXterSIEtcInfoForCntr(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Container 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return ContainerVO[] 
	 * @exception EventException
	 */
	public ContainerVO[] searchXterSIContainer(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Seal No 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgCntrSealNoVO[] 
	 * @exception EventException
	 */
	public BkgCntrSealNoVO[] searchXterSISealNo(SIWebServiceVO sIWebServiceVO) throws EventException;
	
	/**
	 * external request 처리를 위해 external rqst의 Mnd 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return MndVO
	 * @exception EventException
	 */
	public MndVO searchXterSIMnd(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 XptImpLic 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return AlpsXptImpLicListVO[] 
	 * @exception EventException
	 */
	public AlpsXptImpLicListVO[] searchXterSIXptImpLicList(SIWebServiceVO sIWebServiceVO)  throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Indonesia XptImpLic 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return AlpsXptImpLicListVO[] 
	 * @exception EventException
	 */
	public XptImpLicVO[] searchXterSIIdXptImpLicList(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Container Po No 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgReferenceVO[] 
	 * @exception EventException
	 */
	public BkgReferenceVO[] searchXterSIPoOtherCntr(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 B/L Rider 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BlRiderVO[] 
	 * @exception EventException
	 */
	public  BlRiderVO[] searchXterSIBlRider(SIWebServiceVO sIWebServiceVO) throws EventException;
	
	/**
	 * external request 처리를 위해 external rqst의 BKG Po No 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgReferenceVO[] 
	 * @exception EventException
	 */
	public BkgReferenceVO[] searchXterSIPoOtherNoBkg(SIWebServiceVO sIWebServiceVO) throws EventException ;

	/**
	 * external request 처리를 위해 external rqst의 CM Po No 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgRefDtlVO[] 
	 * @exception EventException
	 */
	public BkgRefDtlVO[] searchXterSIPoOtherCm(SIWebServiceVO sIWebServiceVO) throws EventException;
	
	/**
	 * external request 처리를 위해 external rqst의 CM 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgRefDtlVO[] 
	 * @exception EventException
	 */
	public List<BkgCntrMfDescVO> searchXterSICntrMfDesc(SIWebServiceVO sIWebServiceVO) throws EventException;
	
	/**
	 * CMPB 산출된 Rate 정보 Add<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */			
	public void addSiBkgChgRate(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account)throws EventException ;
	
	/**
	 * VGM 정보 Add<br>
	 *
	 * @param BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */				
	public void addBkgXterVrfdWgtRqst(BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO, SignOnUserAccount account)throws EventException ;
	
	/**
	 * VGM Party 정보 Add<br>
	 *
	 * @param BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */				
	public void addBkgXterVrfdWgtPty(BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO, SignOnUserAccount account)throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Charge 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgRefDtlVO[] 
	 * @exception EventException
	 */
	public  List<BkgXterChgRtVO> searchXterSIChgRt(SIWebServiceVO sIWebServiceVO) throws EventException;
	
	 /**
     * Contract Sale Rep, Loading Rep Email를 조회한다.
     * 
     * @param SIWebServiceVO sIWebServiceVO
     * @return String
     * @throws EventException
     */
    public String searchXterSISrepEml(SIWebServiceVO sIWebServiceVO) throws EventException;
    
    /**
	 * Interface로 Upload된 정보 Audit Flag Update<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws EventException 
	 */
	public int modifySIAuditFlag(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * Interface로 Upload된 정보 Old MK Desc Update<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return int
	 * @throws EventException 
	 */
	public int modifySIOldMkDesc(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * BKG 의 Charge 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return List<BkgChgRateVO>
	 * @exception EventException
	 */
	public  List<BkgChgRateVO> searchBkgChgRt(String bkgNo)  throws EventException ;
	
	/**
	 * external request 처리를 위해 CMPB의 Charge 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return List<BkgXterChgRtVO>
	 * @exception EventException
	 */
	public  List<BkgXterChgRtVO> searchCmpbChgRt(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 Charge 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return List<BkgXterChgRtVO>
	 * @exception EventException
	 */
	public  List<BkgXterChgRtVO> searchXterChgRt(SIWebServiceVO sIWebServiceVO) throws EventException;
	
	/**
	 * Customer의 Rating 변경여부를 조회한다.<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterSIChgModFlg(SIWebServiceVO sIWebServiceVO) throws EventException;
	
	/**
	 * external request 처리를 위해 external rqst의 HBL 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return List<HblDtlInfoVO>
	 * @exception EventException
	 */
	public  List<HblDtlInfoVO> searchXterSIHbl1(SIWebServiceVO sIWebServiceVO) throws EventException ;
	
	/**
	 * external request 처리를 위해 external rqst의 NVOCC의 AMS File No 및 Piece Count를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgUsaCstmsFileNoVO[] 
	 * @exception EventException
	 */
	public BkgUsaCstmsFileNoVO[] searchXterSIHbl2(SIWebServiceVO sIWebServiceVO) throws EventException;
	
	/**
	 * 
	 * @param rqstNo
	 * @param msg
	 * @throws EventException
	 */
	public void sendAutoBkgMail(String rqstNo, String msg) throws EventException;
	
	/**
	 * 
	 * @param msg
	 * @return
	 * @throws EventException
	 */
	public String[] getReceiptXterRqstEdiMsgType(String msg) throws EventException;
	
}