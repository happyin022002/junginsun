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
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AgentEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AuthCustVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssueVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlPrintRcvFtpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlRemarkVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlStatusVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EmlBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EmlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.InDblWblInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MailSendVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MultiNtcHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ObDblWblInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlCompleteRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlNtcHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlPrintRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SrndVO;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * OPUS-Outboundblmgt Business Logic Command Interface<br>
 * - OPUS-Interface of Business Logic for Outboundblmgt<br>
 *
 * @author Joon Yong Park
 * @see Esm_bkg_0278EventResponse reference
 * @since J2EE 1.4
 */

public interface BLIssuanceBC {
	
	/**
	 * EsmBkg007909Event retrieve event processing<br>
	 * B/L validateBlIssue check <br>
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String issueType
	 * @return BlStatusVO
	 * @exception EventException
	 */
	public BlStatusVO validateBlIssue(String bkgNo , String issueType) throws EventException;
	/**
	 * EsmBkg007909Event retrieve event processing<br>
	 * B/L Issue info retrieve<br>
	 * fill necessary item before B/L issue(B/L Type, Freight pay or not etc.)
	 * @author LEE JIN SEO
	 * @param BlIssueVO blIssueVO
	 * @return BlIssueVO
	 * @exception EventException
	 */
	public BlIssueVO searchBlIssInfo(BlIssueVO blIssueVO) throws EventException;
	/**
	 * EsmBkg007909Event save event processing<br>
	 * Manage bl issue relation info.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void manageBlIssInfo(BlIssInfoVO blIssInfoVO)  throws EventException;
	/**
	 * EsmBkg007909Event save event processing<br>
	 * Manage bl issue relation info.- HISTORY<br>
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void manageBlIssInfoHistory(BlIssInfoVO blIssInfoVO)  throws EventException;
	/**
	 * EsmBkg007909Event save event processing<br>
	 * Manage bl issue relation info<br>
	 * Issue/Internet AUTH/SWB Release/Cancel AUTH
	 * 
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException;	
	/**
	 * EsmBkg007909Event save event processing<br>
	 * Manage bl issue relation info<br>
	 * Issue/Internet AUTH/SWB Release/Cancel AUTH
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void manageBlIssueFlgHistory(BlIssInfoVO blIssInfoVO) throws EventException;	
	/**
	 * EsmBkg007909Event ftp event processing<br>
	 * VIP FTP Transmit
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BlIssInfoVO blIssInfoVO
	 * @param String[] totalpages
	 * @param SignOnUserAccount account
	 * @param fileDownPath
	 * @exception Exception
	 */
	public void transmitFtp(BkgBlNoVO bkgBlNoVO, BlIssInfoVO blIssInfoVO,String[] totalpages, SignOnUserAccount account, String fileDownPath) throws Exception;	
	/**
	 * EsmBkg0649Event retrieve event processing<br>
	 * B/L searchBlReIssue info retrieve<br>
	 * @author LEE JIN SEO
	 * @param String bl_no
	 * @return ReIssueVO
	 * @exception EventException
	 */
	public ReIssueVO searchBlReIssue(String bl_no) throws EventException;
	
	/**
	 * EsmBkg0649Event save event processing <br>
	 * B/L Re-Issue  info add/modify.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param ReIssueVO reIssueVO
	 * @exception EventException
	 */
	public void manageBlReIssue(ReIssueVO reIssueVO) throws EventException;

	/**
	 * EsmBkg0400Event retrieve event processing<br>
	 * O.B/L Surrender data retrieve<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String blNo
	 * @return List<SrndVO>
	 * @exception EventException
	 */
	public List<SrndVO> searchSurrenderInfo(String bkgNo,String blNo) throws EventException;
	/**
	 * EsmBkg0400Event save event processing<br>
	 * update  Surrender relation item of B/L info<br>
	 * 
	 * @author LEE JIN SEO
	 * @param SrndVO srndvo
	 * @exception EventException
	 */
	public void modifySurrenderInfo(SrndVO srndvo) throws EventException;
	/**
	 * EsmBkg0400Event save event processing<br>
	 * update  Surrender relation item of B/L info<br>
	 * 
	 * @param SrndVO srndvo
	 * @exception EventException
	 */
	public void modifySurrenderInfoHistory(SrndVO srndvo) throws EventException;
	/**
	 * EsmBkg0400Event delete event processing<br>
	 * Initialize  Surrender relation item of B/L info<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @exception EventException
	 */
	public void removeSurrenderInfo(String bkgNo) throws EventException;
	/**
	 * EsmBkg0400Event delete event processing<br>
	 * Initialize  Surrender relation item of B/L info<br>
	 * 
	 * @param String bkgNo
	 * @exception EventException
	 */
	public void removeSurrenderInfoHistory(String bkgNo) throws EventException;
	/**
	 * EsmBkg00059Event retrieve event processing<br>
	 * Documentation Requirement(ESM_BKG-0079 의 B/L INFO의 POP-UP)<br>
	 * ui no : Documentation Requirement data retrieve -- UI_BKG-0059<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String ofc_cd
	 * @return List<DocRqstVO>
	 * @exception EventException
	 */
	public List<DocRqstVO> searchDocRqst(String bkg_no ,String ofc_cd) throws EventException;
	/**
	 * EsmBkg00059Event save event processing<br>
	 * Documentation Requirement data modify. -- UI_BKG-0059<br>
	 * 
	 * @author LEE JIN SEO
	 * @param DocRqstVO docrqstvo
	 * @exception EventException
	 */
	public void modifyDocRqst(DocRqstVO docrqstvo) throws EventException;

	
	
	
	
	
	
	
	/**
	 * retrieve event processing
	 * MultiCombo retrieve event processing ESM_BKG_0278
	 *
	 * @param BkgComboVO bkgComboVO
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO> searchSRouteFromList(BkgComboVO bkgComboVO) throws EventException;

	/**
	 * retrieve event processing<br>
	 * retrieve event processing for ESM_BKG_0280<br>
	 *
	 * @param GrpBlPrtInVO grpBlPrtInVO
	 * @return GrpBlPrtOutVO
	 * @exception EventException
	 */
	public GrpBlPrtOutVO searchBkgListForGrpBlPr(GrpBlPrtInVO grpBlPrtInVO) throws EventException;

    /**
     * Original B/L correct or not and detail info input event processing<br>
     * @param BlIssVO blIssueVO 
     * @exception EventException
     */
    public void manageOblRcv(BlIssVO blIssueVO) throws EventException;
    
    /**
     * [0909] Original Bill of Lading Status modify<br>
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
     * modifyGroupBlUpdateHistory
     * 
     * @param GrpBlDtListVO grpBlDtListVO
     * @param GrpBlDtInVO grpBlDtInVO
     * @exception EventException
     */
    public void modifyGroupBlUpdateHistory(GrpBlDtListVO grpBlDtListVO, GrpBlDtInVO grpBlDtInVO) throws EventException;
    
	/**
	 * Retrieve Outbound booking list  for Draft BL and Waybill sending .<br>
	 * 
	 * @param ObDblWblInVO obDblWblInVO
	 * @return DblWblOutVO
	 * @exception EventException
	 */
	public DblWblOutVO searchBkgListForObDblWbl(ObDblWblInVO obDblWblInVO) throws EventException;
	
	/**
	 * Retrieve Inbound booking list  for Draft BL and Waybill sending.<br>
	 * 
	 * @param InDblWblInVO inDblWblInVO
	 * @return DblWblOutVO
	 * @exception EventException
	 */
	public DblWblOutVO searchBkgListForIbDblWbl(InDblWblInVO inDblWblInVO) throws EventException;
	
	/**
	 * Retrieve Email Address in Chinese Booking Agent Code when applicable to BKG Draft B/L sending.<br>
	 * 
	 * @param List<String> bkgNos
	 * @return List<AgentEmlVO>
	 * @exception EventException
	 */
	public List<AgentEmlVO> searchBkgAgentEml(List<String> bkgNos) throws EventException;
	
    /**
     * retrieve sending result of Fax, Mail each Booking.<br>
     * 
     * @param MultiNtcHisVO multiNtcHisVO
     * @return List<MultiNtcHisVO>
     * @exception EventException
     */
    public List<MultiNtcHisVO> searchMultiNtcHis(MultiNtcHisVO multiNtcHisVO) throws EventException;
    
	/**
	 * retrieve event processing
	 *  check Rider Y or N ESM_BKG_0927
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
	 * retrieve event processing
	 * check HouseB/L Y or N ESM_BKG_0927
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception EventException
	 */
	public String searchHouseBlYn(String bkg_no) throws EventException;
	
	/**
	 * retrieve event processing<br>
	 * check HouseB/L Y or N ESM_BKG_0743
	 * @author PARK JOON YONG
	 * @param String bkg_no
	 * @param String corr_no
	 * @return String
	 * @exception EventException
	 */
	public String searchOblRlseFlg(String bkg_no, String corr_no) throws EventException;
	
	/**
	 * retrieve event processing<br>
	 * OBL_ISS_FLG ESM_BKG_0743<br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception EventException
	 */
	public String searchOblIssFlg(String bkg_no) throws EventException;
	
	/**
	 * EsmBkg0927Event Email event processing
	 * Email send
	 *
	 * @param DblWblVO[] dblWblVOs
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendDblWblByEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * EsmBkg0218Event Email event processing
	 * Email send
	 *
	 * @param DblWblVO[] dblWblVOs
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendDblWblByGroupEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * EsmBkg0218Event Email event processing
	 * Email send
	 *
	 * @param DblWblVO[] dblWblVOs
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendDblWblByGroupEmail2(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * EsmBkg0927Event Fax event processing
	 * Fax send
	 *
	 * @param DblWblVO[] dblWblVOs
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendDblWblByFax(DblWblVO[] dblWblVOs, SignOnUserAccount account) throws EventException;

    /**
     * B/L issue send - Draft B/L auto send
     * 
     * @author Jeon Sung-Jin
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> createDraftBlEdiAuto(String bkgNo, SignOnUserAccount account) throws EventException;
    
    /**
     * B/L issue send - Draft B/L send
     * 
     * @author Park Jun-Yong
     * @param DblEdiInVO dblEdiInVO
     * @param SignOnUserAccount account
     * @return DblEdiVO
     * @exception EventException
     */
    public DblEdiVO createDraftBlEdi(DblEdiInVO dblEdiInVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * retrieve event processing
	 * error check processing for B/L no or BKG no  ESM_BKG_0418
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
     * sendCanonEmlBkg
     * 
     * @param CanonEmlVO canonEml
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendCanonEmlBkg(CanonEmlVO canonEml, SignOnUserAccount account) throws EventException;

    /**
     * copy BlIssuanceBC responsibility tables for C/A..<br>
     * : 1. bkg_bl_iss copy.
     * : 2. according to copyTypeCd , caNo = 'TMP0000001' in case of 'TEMP' or 'BKG' and caNo is bkgBlNoVO.caNo in case of 'HIST' 
     * @author    Lee NamKyung
     * @param     BkgBlNoVO bkgBlNoVO
     * @param     String copyTypeCd
     * @exception EventException
     */
    public void createIssCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException; 

    /**
     * Remove responsibility table of booking relation BlIssuanceBC for C/A.
     * 
     * @author      Lee NamKyung
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String copyTypeCd
     * @exception   EventException
     */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * LOCAL ISS detail info modify
	 * 
	 * @param BkgBlIssVO bkgBlIssVO
	 * @throws EventException
	 */
	public void modifyIbDtlBlIss(BkgBlIssVO bkgBlIssVO) throws EventException;
	
	/**
	 * Manage OBL_RLSE_FLG relation info of BKG_BL_ISS table .<br>
	 * ESM_BKG_0743	interlock System	
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void modifyOBLRlseFlg(BlIssInfoVO blIssInfoVO)  throws EventException;

	/**
	 * searchVesselNameByBkgNo.<br>
	 * get vessel name by bkgNo	
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselNameByBkgNo(String bkgNo) throws EventException;

	/**
     * EsmBkg0095Event Email event processing
     * Email sending
     *
     * @param DblWblVO dblWblVO
     * @param String tpId
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblAutoEmail(DblWblVO dblWblVO, String tpId, SignOnUserAccount account) throws EventException;
    
    /**
	 * EsmBkg1074Event <br>
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<AuthCustVO>
	 * @exception EventException
	 */
	public List<AuthCustVO> searchCustInfo(String bkg_no) throws EventException;
	
	/**
	 * EsmBkg1074Event <br>
	 * @author LEE JIN SEO
	 * @param Mail mail
	 * @exception EventException
	 */
	public void sendAuthEmail(Mail mail)throws EventException;	

	/**
	 * BKG_BL_ISS의 BL_PRF_SHPR_FLG 상태값을 UPDATE한다.(ESM_BKG_0228)<br>
	 * @param 	BlIssInfoVO blIssInfoVO
	 * @exception 	DAOException
	 */
	public void modifyBlIssByBkgNo(BlIssInfoVO blIssInfoVO) throws EventException;
	
	/**
	 * Web Service EAI용(WEB_004_0001)<br>
	 * 
	 * @param BkgWebService004VO bkgWebService004VO
	 * @exception EventException
	 */
	public void modifyWeb0040001Control(BkgWebService004VO bkgWebService004VO) throws EventException;

	/**
	 * Manage WBL_PRN_FLG relation info of BKG_BL_ISS table .<br>
	 * ESM_BKG_0743		
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @param String viaCd
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyWaybillFlg(BlIssInfoVO blIssInfoVO, String viaCd, SignOnUserAccount account)  throws EventException;
    /**
     * EsmBkg007909Event Email event processing
     * Email send
     *
     * @param EmlBkgInfoVO emlBkgInfoVO
     * @param EmlInfoVO emlInfoVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendBlIssueEmails(EmlBkgInfoVO emlBkgInfoVO, EmlInfoVO emlInfoVO, SignOnUserAccount account) throws EventException ;

    /**
	 * Booking data information retrieve for Email.(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNo
	 * @return EmlBkgInfoVO
	 * @exception EventException
	 */
	public EmlBkgInfoVO searchEmlBkgInfo(String bkgNo) throws EventException;

	/**
	 * Check BL Complete Mail is already sent or not(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param SearchBlNtcHisVO searchBlNtcHisVO
	 * @return SearchBlNtcHisVO
	 * @exception EventException
	 */
	public SearchBlNtcHisVO searchBlNtcHis(SearchBlNtcHisVO searchBlNtcHisVO) throws EventException;

	/**
	 * get email receiver address(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param SearchRcvEmlVO searchRcvEmlVO
	 * @return SearchRcvEmlVO
	 * @exception EventException
	 */
	public List<SearchRcvEmlVO> searchRcvEml(SearchRcvEmlVO searchRcvEmlVO) throws EventException;	

	/**
	 * ESM_BKG_0097_09 : E-mail send at save button click <br>
	 *  RDë¥¼ EMAIL sending from Booking list.<br>
	 * 
	 * @author	
	 * @param 	String bkgNo
     * @param SignOnUserAccount account
	 * @exception 	Exception
	 */
	public void sendBlCompleteEmail(String bkgNo, SignOnUserAccount account) throws Exception;

	/**
	 * ESM_BKG_0097_09 : E-mail send at save button click <br>
	 *  RDë¥¼ EMAIL sending from Booking list.<br>
	 * 
	 * @author	
	 * @param 	String bkgNo
     * @param SignOnUserAccount account
	 * @exception 	Exception
	 */
	public void sendOblPrintAuthEmail(String bkgNo, SignOnUserAccount account) throws Exception;

	/**
	 * ESM_BKG_0079_09 : SWB Release button click (copy from ESM_BKG_0095)<br>
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @param 	String fileDownPath
	 * @exception 	Exception
	 */
	public void sendWblReleaseEmail(String bkgNo, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String fileDownPath) throws Exception;

	  /**
     * Invoice BL Send
     * 
     * @author 
     * @param DblEdiInVO dblEdiInVO
     * @param SignOnUserAccount account
     * @return DblEdiVO
     * @exception EventException
     */
    public DblEdiVO createInvoiceBlEdi(DblEdiInVO dblEdiInVO, SignOnUserAccount account) throws EventException;

	/**
	 * get email receiver address(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNO
	 * @return List<SearchBlCompleteRcvEmlVO>
	 * @exception EventException
	 */
	public List<SearchBlCompleteRcvEmlVO> searchBlCompleteRcvEml(String bkgNO) throws EventException;

	/**
	 * get email receiver address(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNO
	 * @param String emlFlg
	 * @return List<SearchBlPrintRcvEmlVO>
	 * @exception EventException
	 */
	public List<SearchBlPrintRcvEmlVO> searchBlPrintRcvEml(String bkgNO, String emlFlg) throws EventException;

	/**
	 * ESM_BKG_1074 : E-mail Template Read
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @param  String templateFile
	 * @return  String[]
	 * @exception 	Exception
	 */
	public String[] searchEmlTemplate(String bkgNo, String templateFile) throws Exception;
	
	/**
	 * BlCaluse 조회
	 * @param BlRemarkVO blRemakVO
	 * @return BlRemarkVO
	 * @throws EventException
	 */
	public BlRemarkVO searchBlClauseInfo(BlRemarkVO blRemakVO) throws EventException;
	
	/**
	 * ESM_BKG_0079_09 : SWB Release button click<br>
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @param 	String fileDownPath
	 * @param	String issType			: 'SWB'->SWB Release button,'BLD'->B/L DATA COMPLETE 
	 * @exception 	Exception
	 */
	public void sendBlRDFtp(String bkgNo, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String fileDownPath, String issType) throws Exception;
	
	/**
	 * ESM_BKG_0079_09 : Receive FTP (VIP)<br>
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @return  List<BlPrintRcvFtpVO>
	 * @exception 	Exception
	 */
	public List<BlPrintRcvFtpVO> searchBlPrintGrpRcvFtp(String bkgNo) throws EventException;
	
    /**
     * Draft BL 전송을 위한 REMARK를 조회한다.<br>
     * 
     * @param String bkgNo
     * @return List<DblWblVO>
     * @exception EventException
     */
    public List<DblWblVO> searchDblRemarkByBkgNo(String bkgNo) throws EventException;
    
    /**
     * ESM_BKG_0278 Group Email event processing -- testing...
     * Email send
     *
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendGroupBLEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
    
    /**
     * ESM_BKG_0726 modify B/L(onboard date, issue date etc) by group<br>
     * @param GrpBlDtVO grpBlDtVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String modifyGroupBlUpdate(GrpBlDtVO grpBlDtVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * ESM_BKG_0726 modify B/L(onboard date, issue date etc) by group 결과를 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchGroupBlUpdateBackEndJobResult(String key) throws EventException;    
	
	/**
	 * Original B/L download
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caYn
	 * @param String[] mrdFiles
	 * @param String[] mrdParams
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createOBL(String bkgNo, String blNo, String caYn, String[] mrdFiles, String[] mrdParams, SignOnUserAccount account) throws EventException;
    
	/**
	 * Original B/L download
	 * @param String fileKey
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String downLoadOBL(String fileKey, SignOnUserAccount account) throws EventException;
	
	/**
 	 * Original B/L download 결과를 BackEndJob 결과확인<br>
 	 * 
 	 * @param String key
 	 * @return String
 	 * @throws EventException
 	 */
	public String searchDownLoadOBLBackEndJobResult(String key) throws EventException;    
	
    /**
     * Original B/L download 할때 insert BKG_INET_BL_PRN_AUTH
     * @param String bkgNo
     * @param String blNo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int createInetBlPrnAuth(String bkgNo, String blNo, SignOnUserAccount account) throws EventException;
    
    /**
     * Original Bill download 할때 insert BKG_INET_BL_PRN_AUTH
     * @param String[] bkgNos
     * @param String mBkgNo
     * @param String mBlNo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int createInetGroupBlPrnAuth(String[] bkgNos, String mBkgNo, String mBlNo, SignOnUserAccount account) throws EventException;
    
    /**
	 * Original Group B/L download
	 * @param String[] bkgNos
	 * @param String[] blNos
	 * @param String caYn
	 * @param String formType
	 * @param String[] mrdFiles
	 * @param String[] mrdParams
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createGBOBL(String[] bkgNos, String[] blNos, String caYn, String formType, String[] mrdFiles, String[] mrdParams, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param bkgNo
	 * @param mailInfo
	 * @param params
	 * @param emailType
	 * @param account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendEmailResultFTP(String bkgNo, MailSendVO mailInfo, String params[], String emailType, SignOnUserAccount account) throws EventException;

}
