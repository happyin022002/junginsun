/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossMgtBC.java
*@FileTitle : Total Loss No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.15 김완규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.03.06 신혜정 [CHM-201216409] 3rd Party 탭 [CHNG INV No] 버튼 클릭시, invoice no 업데이트 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportVO;

/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author WanGyu Kim
 * @see Ees_mnr_0195EventResponse 참조
 * @since J2EE 1.4 
 */	
public interface TotalLossMgtBC {
	/**
	 * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchTotalLossWithCLTBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO removeTotalLossBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO removeTotalLossGRPBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossListBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0195] Total Loss No Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossInfoGRPVO totalLossInfoGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossInfoGRPVO
	 * @exception EventException
	 */ 
	public TotalLossInfoGRPVO searchTotalLossInfoByOFCListBasic(TotalLossInfoGRPVO totalLossInfoGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossBasic(TotalLossGRPVO totalLossGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */         
	public TotalLossGRPVO manageTotalLossBasic(TotalLossGRPVO totalLossGRPVO,SignOnUserAccount account) throws EventException;
 
	/** 
	 * [EES_MNR_0105]Total Loss Payment to Lessor Report의 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossLessorReportINVO totalLossLessorReportINVO
	 * @return List<TotalLossLessorReportVO>
	 * @exception EventException
	 */ 
	public List<TotalLossLessorReportVO> searchTotalLossLessorReportListBasic(TotalLossLessorReportINVO totalLossLessorReportINVO) throws EventException;
	
	/** 
	 * [EES_MNR_0096]Total Loss Management의 정보를 수정 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO modifyTotalLossDetailBasic(TotalLossGRPVO totalLossGRPVO,SignOnUserAccount account) throws EventException;

	/** 
	 * [EES_MNR_0098]Total Loss Collection & Inquiry 의 invoice no를 수정 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void modifyTotalLossDetailInvNoBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;	

	/**
	 * [EES_MNR_0095]Total Loss Request 에서 로그인 Office의 지역이 US인지 조회합니다. <br>
	 *
	 * @param String rqstOfcCd
	 * @return int
	 * @exception EventException
	 */
	public int searchOfficeAreaUS(String rqstOfcCd) throws EventException;
	
	/**
	 * [EES_MNR_0262] Write Off Request 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchTotalLossWriteOffRqstListBasic(TotalLossGRPVO totalLossGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0262]Write Off Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO manageWriteOffBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0262]Write Off Request의 정보를 삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO removeWriteOffBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0263] Write Off Approval 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchWriteOffApprovalListBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0263] Write Off Approval Detail 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchWriteOffApprovalDetailBasic(TotalLossGRPVO totalLossGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0263]Write Off Approval의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO manageWriteOffApprovalBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0264] Write Off Approval 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */ 
	public TotalLossGRPVO searchWriteOffApprovalInquiryBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0098]장비가 현재 활성화(A)인지 비활성화(I)인지 확인합니다. <br>
	 *
	 * @param String eq_kind_cd
	 * @param String eq_no
	 * @return List<String>
	 * @exception EventException
	 */ 
	public List<String> searchEqCurrentStatus(String eq_kind_cd, String eq_no) throws EventException;
}
