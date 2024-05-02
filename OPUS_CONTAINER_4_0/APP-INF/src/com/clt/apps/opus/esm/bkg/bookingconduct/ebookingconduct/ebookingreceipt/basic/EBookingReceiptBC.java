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
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0902Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRevMsgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.CodecoEdiForVgmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstAkVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstDgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl1VO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl2VO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstMndVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstRfVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiRefVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteOfcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteUserIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCmShipmentVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterDgRiderVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterInnerPackageVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherShipVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgVgmWgtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgXterSrchSetVO;

/**
 * OPUS-Ebookingconduct Business Logic Command Interface<br>
 * - OPUS-Ebookingconduct business logic handling.<br>
 *
 * @author Jun Yong Jin
 * @see Esm_bkg_0228EventResponse reference
 * @since J2EE 1.4
 */

public interface EBookingReceiptBC {
	/**
	 * bkg_no, bkg_no_split assign.<br>
	 *
	 * @param rqstNoVo XterRqstNoVO 
	 * @exception EventException
	 */
	public void assignBkgNoToXterRqst(XterRqstNoVO rqstNoVo) throws EventException;
	/**
	 * External Request status change.<br>
	 *
	 * @param XterRqstNoVO[] xterRqstNoVO
	 * @param String newSts
	 * @param String reInstCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeXterRqstStatus(XterRqstNoVO[] xterRqstNoVO,String newSts,String reInstCd,SignOnUserAccount account) throws EventException;
	/**
	 * bkg_xter_rqst upload history.<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void completeUpload(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * external request Ack Edi Flatfile create.<br> 
	 * (send_OPUSBKG_UBIZCOM_ACK)<br>
	 * @param docTpCd
	 * @param hrdCdgId
	 * @param xterRqstNoVO
	 * @return
	 * @throws EventException
	 */
	public String createXterBkgAckEdi(String docTpCd, String hrdCdgId, XterRqstNoVO xterRqstNoVO) throws EventException;
	
	/**
	 * external request reject create.<br>
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
	 * in situation Bkg No auto create, info update in BKG_XTER_RQST_MST<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterBkgNo(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * eBkg Customer Code info update<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterCustCustCd(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * External Request data insert<br>
	 *
	 * @param String rcvMsg
	 * @return XterRqstNoVO
	 * @exception EventException
	 */
	public XterRqstNoVO receiptXterRqst(String rcvMsg) throws EventException;
	/**
	 * retrieve event handling<br>
	 * Find Booking button Click, OPUS Booking info retrieve <br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public ExternalRqstBkgVO searchOpusBkg(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * continent code retrieve.<br>
	 *
	 * @return List&lt;BkgComboVO&gt;
	 * @exception EventException
	 */
	public List<BkgComboVO> searchComboMdmConti() throws EventException;
	/**
	 * retrieve event handling<br>
	 * extenal request의 awkward cargo info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstAkVO
	 * @exception EventException
	 */
	public ExternalRqstAkVO searchXterAk(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * External Request detail info retrieve.<br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public ExternalRqstBkgVO searchXterBkg(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * extenal request container manifest info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCmVO
	 * @exception EventException
	 */
	public ExternalRqstCmVO searchXterCm(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * external request container info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCntrVO
	 * @exception EventException
	 */
	public ExternalRqstCntrVO searchXterCntr(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * external rqst customer info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCustVO
	 * @exception EventException
	 */
	public ExternalRqstCustVO searchXterCust(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * external rqst danger cgo info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstDgVO
	 * @exception EventException
	 */
	public ExternalRqstDgVO searchXterDg(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * extenal request house b/l retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstHbl1VO
	 * @exception EventException
	 */
	public ExternalRqstHbl1VO searchXterHbl1(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * extenal request ams file no retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstHbl2VO
	 * @exception EventException
	 */
	public ExternalRqstHbl2VO searchXterHbl2(XterRqstNoVO xterRqstNoVO) throws EventException;
	/**
	 * external rqst mark & Description info retrieve<br>
	 * BKG_XTER_XPT_LIC_NO, BKG_XTER_AES, BKG_XTER_RQST_MST, BKG_XTER_CNTR retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String usrOfc
	 * @return ExternalRqstMndVO
	 * @exception EventException
	 */
	public ExternalRqstMndVO searchXterMnd(XterRqstNoVO xterRqstNoVO, String usrOfc) throws EventException;
	/**
	 * external rqst awkward cgo info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstRfVO
	 * @exception EventException
	 */
	public ExternalRqstRfVO searchXterRf(XterRqstNoVO xterRqstNoVO) throws EventException;

	/**
	 * External Request List retrieve<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return List<ExternalRqstListVO>
	 * @exception EventException
	 */
	public List<ExternalRqstListVO> searchXterRqstList(ExternalRqstListInputVO xterRqstListInputVO) throws EventException;

	/**
	 * external request search condition retrieve.<br>
	 *
	 * @param String userId
	 * @return List<BkgXterSrchSetVO>
	 * @exception EventException
	 */
	public List<BkgXterSrchSetVO> searchXterSrchSetForList(String userId) throws EventException;

	/**
	 * extenal request tro info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstTroVO
	 * @exception EventException
	 */
	public ExternalRqstTroVO searchXterTro(XterRqstNoVO xterRqstNoVO) throws EventException;

	/**
	 * 
	 * @param errStr
	 * @param flatFileStr
	 * @throws EventException
	 */
	public void sendErrLogMail(String errStr, String flatFileStr) throws EventException;

	/**
	 * eBKG reject info send email.<br>
	 *
	 * @param EsmBkg0902Event event
	 * @exception EventException
	 */
	public void sendXterRqstRejectEmail(EsmBkg0902Event event) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * Po No info retrieve <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return BkgReferenceVO
	 * @exception EventException
	 */
	public BkgReferenceVO searchOpusPoNo(String bkgNo, String cntrNo ) throws EventException;

	/**
	 * external request condition retrieve<br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterInnerPackageVO>
	 * @exception EventException
	 */
	public List<XterInnerPackageVO> searchXterInnerPackage(XterRqstNoVO xterRqstNoVO) throws EventException;

	/**
	 * Container tVvd CgoTpCd retrieve<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return CntrEtcInfoVO
	 * @exception EventException
	 */
	public CntrEtcInfoVO manageCntrEtcInfo(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * B/L ISS retrieve(ESM_BKG_022901)<br>
	 * 
	 * @author 	KimYoungCheal
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	public void searchBlIss(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking No save.<br>
	 *
	 * @param XterRqstNoVO[] xterRqstNoVO
	 * @exception EventException
	 */
	public void changeXterRqstBkgNo(XterRqstNoVO[] xterRqstNoVO) throws EventException;
	
	/**
	 * EBookingReceipt Seanaccs Validation info retrieve<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return XterRqstValidationVO
	 * @exception EventException
	 */
	public XterRqstValidationVO searchXterRqstValidation(ExternalRqstListInputVO xterRqstListInputVO) throws EventException;	

	/**
	 * searchMqXlsGroupList info retrieve.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsGroupList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;

	/**
	 * searchMqXlsMappingList info retrieve.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;
	
	/**
	 * searchMqXlsMappingList info retrieve.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXmlMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;
	
	/**
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO> 
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchOpusDgRiderList(XterRqstNoVO xterRqstNoVO) throws EventException;
	
	/**
	 * @param xterRqstNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchOpusDgRiderCntrList(XterRqstNoVO xterRqstNoVO)  throws EventException;

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
	 * eBkg Customer Name And Addr Over flow info update<br>
	 *
	 * @param XterRqstNoVO rqstNoVO
	 * @param String nmAndAddrOvflwFlg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyNmAndAddrOvflwFlg(XterRqstNoVO rqstNoVO, String nmAndAddrOvflwFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param XterRqstNoVO rqstNoVo
	 * @exception EventException
	 */
	public void createBkgXterQtyByXml(XterRqstNoVO rqstNoVo) throws EventException;

	/**
	 * 
	 * @param rqstNoVo
	 * @param flatFileStr
	 * @return
	 * @throws EventException
	 */
	public String createBkgXterRcvMsg(XterRqstNoVO rqstNoVo, String flatFileStr) throws EventException;
	
	/**
	 * @param String msgSeq
	 * @param String sndrId
	 * @param String rqstNo
	 * @param String rqstSeq
	 * @param String upldFlg
	 * @exception EventException
	 */
	public void modifyBkgXterRcvMsg(String msgSeq, String sndrId, String rqstNo, String rqstSeq, String upldFlg) throws EventException;
	
	/**
	 * @param String rcvFromDt
	 * @param String rcvToDt
	 * @param String UpldCd
	 * @param String RqstNo
	 * @param String msgSeq
	 * @param String msgDesc
	 * @return List<BkgXterRevMsgVO>
	 * @throws EventException
	 */
	public List<BkgXterRevMsgVO> searchBkgXterRcvMsgList(String rcvFromDt, String rcvToDt, String upldCd, String rqstNo, String msgSeq, String msgDesc) throws EventException;
	
	/**
	 * @param BkgXterRevMsgVO bkgXterRevMsgVO
	 * @return BkgXterRevMsgVO
	 * @throws EventException
	 */
	public BkgXterRevMsgVO searchBkgXterRcvMsgView(BkgXterRevMsgVO bkgXterRevMsgVO) throws EventException;

	/**
	 * @param XterRqstNoVO rqstNoVo
	 * @exception EventException
	 */
	public void modifyBkgXterRqstMst(XterRqstNoVO rqstNoVo) throws EventException;

	/**
	 * 
	 * @param unlocCd
	 * @return
	 * @throws EventException
	 */
	public String getUnlocCodeToLocCd(String unlocCd) throws EventException;
	
	/**
	 * 
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws EventException
	 */
	public void ediPegasusBkgXterCntrDelete(String rqstNo, String rqstSeq) throws EventException;
	
	/**
	 * 
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws EventException
	 */
	public void ediPegasusBkgXterTroUpdate(String rqstNo, String rqstSeq) throws EventException;
	
	/**
	 * 
	 * @param xterRqstMstVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyBkgReferenceNo(XterRqstMstVO xterRqstMstVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param senderId
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws EventException
	 */
	public void ediPegasusBkgXterDgCgoUpdate(String senderId, String rqstNo, String rqstSeq) throws EventException;
	
	/**
	 * 
	 * @param rqstNoVo
	 * @throws EventException
	 */
	public void sendXterRqstNotice(XterRqstNoVO rqstNoVo);
	
	/**
	 * @param RerouteOfcVO rerouteOfcVO
	 * @param String usr_id
	 * @return List<RerouteOfcVO>
	 * @throws EventException
	 */
	public List<RerouteOfcVO> searchRerouteOfcCd(RerouteOfcVO rerouteOfcVO, String usr_id) throws EventException;

	/**
	 * 
	 * @param rqstNoVo
	 */
	public void sendRerouteRqstNotice(XterRqstNoVO rqstNoVo);

	/**
	 * office code save.<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param String usr_id
	 * @exception EventException
	 */
	public void changeRerouteRqstOfcCd(XterRqstNoVO rqstNoVo, String usr_id) throws EventException;
	
	/**
	 * @return List<RerouteUserIdVO>
	 * @throws EventException
	 */
	public List<RerouteUserIdVO> searchRerouteUserId() throws EventException;
	
	/**
	 * 
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public List<PoOtherShipVO> searchPoNoByShip(String bkgNo) throws EventException;
	
	/**
	 * 
	 * @param xterRqstNoVO
	 * @return
	 * @throws EventException
	 */
	public List<RejectEdiRefVO> searchXterRefForRejectEdi(XterRqstNoVO xterRqstNoVO) throws EventException;
	
	/**
	 * 
	 * @param xterRqstNoVO
	 * @return
	 * @throws EventException
	 */
	public List<XterCmShipmentVO> searchXterCmShipment(XterRqstNoVO xterRqstNoVO) throws EventException;
	
	/**
	 * VGM update<br>
	 *
	 * @param BkgVgmWgtVO bkgVgmWgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgVgmUpld(BkgVgmWgtVO bkgVgmWgtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VGM update<br>
	 *
	 * @return List<CodecoEdiForVgmVO> list
	 * @exception EventException
	 */
	public List<CodecoEdiForVgmVO> searchCodecoEdiForVgm() throws EventException;
	
	/**
	 * VGM update from CODECO<br>
	 *
	 * @param CodecoEdiForVgmVO codecoEdiForVgmVO
	 * @exception EventException
	 */
	public void manageVgmInfoFmCodeco(CodecoEdiForVgmVO codecoEdiForVgmVO) throws EventException;
	
	/**
	 * 
	 * @param msg
	 * @return
	 * @throws EventException
	 */
	public String[] getReceiptXterRqstEdiMsgType(String msg) throws EventException;
	
	/**
	 * 
	 * @param headers
	 * @param msg
	 * @return
	 * @throws EventException
	 */
	public XterRqstNoVO receiptXterRqstVermas(String[] headers, String msg) throws EventException;
	
	
	/**
	 * VGM update<br>
	 *
	 * @param BkgVgmWgtVO bkgVgmWgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgXterVgmRqstUpld(BkgVgmWgtVO bkgVgmWgtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param senderId
	 * @param rqstNo
	 * @param rqstSeq
	 * @return
	 * @throws EventException
	 */
	public List<XterCntrVO> searchXterCntrVgm(String senderId, String rqstNo, String rqstSeq) throws EventException;
	
	/**
	 * 
	 * @param xterCntrVO
	 * @throws EventException
	 */
	public void manageXterVgm(XterCntrVO xterCntrVO) throws EventException;
	
	/**
	 * 
	 * @param xterCntrVO
	 * @return
	 * @throws EventException
	 */
	public String selectBkgXterVgm(XterCntrVO xterCntrVO) throws EventException;
	
	/**
	 * 
	 * @param headers
	 * @param rqstNoVo
	 * @return
	 * @throws EventException
	 */
	public String createVermasBkgAckEdi(String[] headers, XterRqstNoVO rqstNoVo) throws EventException;
	
	/**
	 * 
	 * @param xterRqstNoVO
	 * @throws EventException
	 */
	public void manageXterVgm(XterRqstNoVO xterRqstNoVO) throws EventException;
	
}
