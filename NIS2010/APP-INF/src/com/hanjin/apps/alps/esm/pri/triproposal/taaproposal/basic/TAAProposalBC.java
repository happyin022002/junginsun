/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalBC.java
*@FileTitle : TAA Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.18 문동규
* 1.0 Creation
=========================================================
* History
* 2011-08-17 송호진 [CHM-2011128680-01][PRI] TAA화면에서 EAI(CMS013_0001)호출을 Confirm 후 Sales Rep. 변경시에도 호출 할수 있도록 변경
* 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriTaaMnVO;
import com.hanjin.syscommon.common.table.PriTriMnVO;

/**
 * ALPS-Triproposal Business Logic Command Interface<br>
 * - ALPS-Triproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @since J2EE 1.6
 */

public interface TAAProposalBC {

    /**
     * TRI Proposal TAA Main 및 TRI List 를 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return RsltTaaListVO
     * @exception EventException
     */
    public RsltTaaListVO searchTRIProposalTAAList (RsltTaaMnVO rsltTaaMnVO) throws EventException;

    /**
     * TRI Proposal TAA Main 의 Amdt Seq Combo Item 을 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchTRIProposalTAAAmdtSeqList (RsltTaaMnVO rsltTaaMnVO) throws EventException;

    /**
     * Customer 정보를 조회합니다.<br>
     * 
     * @param PriSpCtrtPtyVO priSpCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;

    /**
     * TRI Proposal 신규 TAA Proposal Number 를 조회합니다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAAPropNo(String ofcCd) throws EventException;

    /**
     * TRI Proposal 신규 TAA Number 를 조회합니다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAANo(String ofcCd) throws EventException;

    /**
     * TRI Proposal TAA Header 정보를 저장합니다.<br>
     * 
     * @param RsltTaaMnVO[] rsltTaaMnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAHeader (RsltTaaMnVO[] rsltTaaMnVOs, SignOnUserAccount account) throws EventException;

    /**
     * TRI Proposal TAA Main 정보를 저장합니다.<br>
     * 
     * @param RsltTaaMnVO[] rsltTaaMnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAMain (RsltTaaMnVO[] rsltTaaMnVOs, SignOnUserAccount account) throws EventException;

    /**
     * TRI Proposal TAA TRI List 정보를 저장합니다.<br>
     * 
     * @param RsltTaaTriListVO[] rsltTaaTriListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAList (RsltTaaTriListVO[] rsltTaaTriListVOs, SignOnUserAccount account) throws EventException;
    
    /**
     * TRI Proposal TAA 정보를 Confirm 합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;

    /**
     * TRI Proposal TAA 정보를 Confirm Cancel 합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmCancelTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;

    /**
     * TRI Proposal TAA 해당 회차 정보를 Delete 합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;

    /**
     * TRI Proposal TAA 정보를 Amend 합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void amendTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;
    
    /**
     * TRI Inquiry List 를 조회합니다. <br>
     * 
     * @param PriTriMnVO priTriMnVO
     * @return List<RsltTaaMnVO>
     * @exception EventException
     */
    public List<RsltTaaMnVO> searchTRIProposalTAAInquiryList (PriTriMnVO priTriMnVO) throws EventException;

    /**
     * TRI Proposal Select List 를 조회합니다.<br>
     * 
     * @param RsltTaaTriListVO rsltTaaTriListVO
     * @return List<RsltTaaTriListVO>
     * @exception EventException
     */
    public List<RsltTaaTriListVO> searchTRIProposalSelectList(RsltTaaTriListVO rsltTaaTriListVO) throws EventException;

    /**
     * TRI Proposal TAA No List 를 조회합니다. <br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltTaaMnVO>
     * @exception EventException
     */
    public List<RsltTaaMnVO> searchTRIProposalTAANoList(RsltTaaMnVO rsltTaaMnVO) throws EventException;

    /**
     * TRI Proposal TAA 정보를 Booking 에서 사용하는지 체크합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return String[]
     * @exception EventException
     */
    public String[] searchTRIProposalTAACheckUseBkg(RsltTaaMnVO rsltTaaMnVO) throws EventException;

    /**
     * TAA Main 정보를 CRM으로 전송합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String transferTAAMainInfo (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;

    /**
     * TRI Proposal TAA 승인권한을 조회합니다.<br>
     * 
     * @param PriAuthorizationVO priAuthorizationVO
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAAApprovalAuth(PriAuthorizationVO priAuthorizationVO) throws EventException;

    /**
     * TAA 건 Confirm 이후 Sales Rep 정보의 변경 유무를 체크한다.<br>
     *
     * @param PriTaaMnVO priTaaMnVO
     * @return int
     * @exception EventException
     */
    public int searchCheckOfcSrepDiffList(PriTaaMnVO priTaaMnVO)  throws EventException ;
    
    /**
     * TAA confirm 이후 유저에게 G/W 메일 발송한다.<br>
     *
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @return List<PriEmailTargetListVO>
     * @exception EventException
     */
    public List<PriEmailTargetListVO> sendEmail(RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;
    
}