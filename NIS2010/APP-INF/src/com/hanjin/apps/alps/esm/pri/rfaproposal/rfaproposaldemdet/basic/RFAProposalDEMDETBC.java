/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfaProposalDEMDETBC.java
*@FileTitle : RFA Proposal Creation [Amend] (DEM&DET)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptHisListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpDmdtVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;

/**
 * ALPS-Rfaproposal Business Logic Command Interface<br>
 * - ALPS-Rfaproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_2058EventResponse 참조
 * @since J2EE 1.6
 */

public interface RFAProposalDEMDETBC {

	/**
	 * DEM&DET 조회를 실행한다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return List<RsltDmdtExptListVO>
	 * @exception EventException
	 */
	public List<RsltDmdtExptListVO> searchDEMDETExceptionList(PriRpDmdtVO priRpDmdtVO) throws EventException;
	
	/**
	 * DEM&DET 수정을 실행한다.<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDEMDETException(PriRpDmdtVO[] priRpDmdtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * DEM&DET Accept를 실행한다<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptDEMDETException(PriRpDmdtVO[] priRpDmdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * DEM&DET Accept cancel을 실행한다<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelDEMDETException(PriRpDmdtVO[] priRpDmdtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * DEM&DET 을 추가/수정한다.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * DEM&DET 자동 Accept를 실행한다<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDEMDETException(PriRpDmdtVO priRpDmdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * DEM&DET 을 Amend 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
    /**
     * Baisc RFA의 DEM&DET 을 Amend 합니다.<br>
     * 
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void amendProposalBasic(PriRpMnVO priRpMnVO,RsltRoutHdrSmryListVO amdBasicVo,SignOnUserAccount account) throws EventException;
    	
	/**
	 * DEM&DET 조회를 실행한다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return List<RsltDmdtExptHisListVO>
	 * @exception EventException
	 */
	public List<RsltDmdtExptHisListVO> searchDEMDETExceptionHistoryList(PriRpDmdtVO priRpDmdtVO) throws EventException;

    /**
     * RFA Proposal DEM/DET 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDemDet(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
     * PRS 정보를 Copy 하여 RFA Proposal DEM/DET 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO vo 
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyToProposalRqDmdt(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException;
    
}