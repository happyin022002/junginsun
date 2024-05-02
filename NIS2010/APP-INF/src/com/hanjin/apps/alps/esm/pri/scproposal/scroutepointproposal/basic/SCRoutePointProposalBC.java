/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRoutePointProposalBC.java
*@FileTitle : S/C Proposal Org/Dst Location Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.21 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.29 김민아 [CHM-201109656-01] Scope별 Partial Accept All 기능 추가 - Ori/Dest Terms의 Quick Accept할 데이터 조회 추가.
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpRoutPntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @see Esm_pri_0003_01EventResponse 참조
 * @since J2EE 1.6
 */

public interface SCRoutePointProposalBC {

    /**
	 * ROUTE TYPE별로 데이터가 존재하는지 체크하기 위하여 조회한다.<br>
	 *  
	 * @param RsltRoutPntLocListVO rsltRoutPntLocListVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationType(RsltRoutPntLocListVO rsltRoutPntLocListVO) throws EventException;
 
	/**
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param RsltRoutPntLocListVO rsltRoutPntLocListVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationList(RsltRoutPntLocListVO rsltRoutPntLocListVO) throws EventException;

	/**
	 * Org/Dst Location 정보를 ACCEPT CANCEL합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Org/Dst Location 정보를 복사합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
//	public void copyProposal(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Org/Dst Location 정보를 ALL ACCEPT CANCEL합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRoutePoint(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Org/Dst Location 정보를 ACCEPT합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Org/Dst Location 정보를 저장합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Org/Dst Location 정보를 ALL ACCEPT 합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRoutePoint(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * Proposal Scope Route Point 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeRoute(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException; 
	
	/**
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryList(PriSpScpRoutPntVO priSpScpRoutPntVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	/**
	 * ROUTE TYPE별로 데이터가 존재하는지 체크하기 위하여 조회한다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryType(PriSpScpRoutPntVO priSpScpRoutPntVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;

	/**
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationInquiryList(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException;
	/**
	 * ROUTE TYPE별로 데이터가 존재하는지 체크하기 위하여 조회한다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO  
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationInquiryType(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException;

	/**
	 * Org/Dst Location 정보를 QUICK ACCEPT ALL 처리합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String quickAcceptAllRoutePoint(PriSpScpRoutPntVO priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

}