/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0T1Event.java
*@FileTitle : VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
* 2015.07.20 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가(0U1,0U2,0V1) 
=========================================================*/
package com.hanjin.bizcommon.approval.event;

import java.util.Arrays;

import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.approval.vo.ApprovalRouteVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStaffVO;
import com.hanjin.bizcommon.authorization.vo.AuthAproStaffVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_0T1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0T1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyung Choon_Roh
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComEns0T1Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1619473780139237972L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApprovalStaffVO approvalStaffVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AuthAproStaffVO authAproStaffVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAuthAproVO searchAuthAproVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApprovalCsrVO approvalCsrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ApprovalRouteVO[] approvalRouteVOs = null;
	private SearchAuthAproVO[] searchAuthAproVOs = null;
	
	public ComEns0T1Event(){}
	
	public void setAuthAproStaffVO(AuthAproStaffVO authAproStaffVO){
		this.authAproStaffVO = authAproStaffVO;
	}
	
	public void setApprovalStaffVO(ApprovalStaffVO approvalStaffVO){
		this.approvalStaffVO = approvalStaffVO;
	}
	
	public void setSearchAuthAproVO(SearchAuthAproVO searchAuthAproVO){
		this.searchAuthAproVO = searchAuthAproVO;
	}

	public void setApprovalRouteVOS(ApprovalRouteVO[] approvalRouteVOs){		
		if(approvalRouteVOs != null){
			ApprovalRouteVO[] tmpVOs = Arrays.copyOf(approvalRouteVOs, approvalRouteVOs.length);
			this.approvalRouteVOs = tmpVOs;
		}
	}
	
	public void setSearchAuthAproVOS(SearchAuthAproVO[] searchAuthAproVOs){		
		if(searchAuthAproVOs != null){
			SearchAuthAproVO[] tmpVOs = Arrays.copyOf(searchAuthAproVOs, searchAuthAproVOs.length);
			this.searchAuthAproVOs = tmpVOs;
		}
	}
	
	public void setApprovalCsrVO(ApprovalCsrVO approvalCsrVO){
		this.approvalCsrVO = approvalCsrVO;
	}

	public ApprovalStaffVO getApprovalStaffVO(){
		return approvalStaffVO;
	}
	
	public AuthAproStaffVO getAuthAproStaffVO(){
		return authAproStaffVO;
	}
	
	public SearchAuthAproVO getSearchAuthAproVO(){
		return searchAuthAproVO;
	}

	public ApprovalRouteVO[] getApprovalRouteVOS(){		
		ApprovalRouteVO[] rtnVOs = null;
		if (this.approvalRouteVOs != null) {
			rtnVOs = Arrays.copyOf(approvalRouteVOs, approvalRouteVOs.length);
		}
		return rtnVOs;
	}
	
	public SearchAuthAproVO[] getSearchAuthAproVOS(){		
		SearchAuthAproVO[] rtnVOs = null;
		if (this.searchAuthAproVOs != null) {
			rtnVOs = Arrays.copyOf(searchAuthAproVOs, searchAuthAproVOs.length);
		}
		return rtnVOs;
	}
	
	public ApprovalCsrVO getApprovalCsrVO(){
		return approvalCsrVO;
	}
}
