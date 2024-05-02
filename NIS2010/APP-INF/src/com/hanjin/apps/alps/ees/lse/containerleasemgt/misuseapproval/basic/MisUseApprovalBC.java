/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseApprovalBC.java
*@FileTitle : Mis Use In & Out Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseContainerInfoVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseInOutInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.SearchParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see Ees_lse_0027EventResponse 참조
 * @since J2EE 1.6
 */

public interface MisUseApprovalBC {

	/**
	 * Miss Use 최대 Request No.를 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchNewMisUseRequestNumberBasic(String ofcCd) throws EventException;

	/**
	 * 입력된 컨테이너 번호에 대한 요청내역 중복여부를 확인합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchMisUseReqContainerExistBasic(String cntrNo) throws EventException;

	/**
	 * 입력된 컨테이너 번호에 대한 기본정보를 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return List<MisUseContainerInfoVO>
	 * @exception EventException
	 */
	public List<MisUseContainerInfoVO> searchMisUseRequestContainerBasic(String cntrNo) throws EventException;

	/**
	 * Miss Use Request 요청내역 및 장비목록을 저장합니다.<br>
	 *
	 * @param MisUseRequestVO misUseRequestVO
	 * @param MisUseReqContainerVO[] misUseReqContainerVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void createMisUseRequestNumberListBasic(MisUseRequestVO misUseRequestVO, MisUseReqContainerVO[] misUseReqContainerVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Miss Use 최대 Approval No.를 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchNewMisUseApprovalNumberBasic(String ofcCd) throws EventException;

	/**
	 * 승인대상 Miss Use Request No. 목록을 조회합니다.<br>
	 *
	 * @return List<MisUseRequestVO>
	 * @exception EventException
	 */
	public List<MisUseRequestVO> searchMisUseRequestNoItemsBasic() throws EventException;

	/**
	 * 선택 Request No.에 대한 요청정보을 조회합니다.<br>
	 *
	 * @param  String rqstNo
	 * @return List<MisUseRequestVO>
	 * @exception EventException
	 */
	public List<MisUseRequestVO> searchMisUseRequestInfoBasic(String rqstNo) throws EventException;

	/**
	 * 선택 Request No.에 대한 장비내역 목록을 조회합니다.<br>
	 *
	 * @param  String rqstNo
	 * @return List<MisUseReqContainerVO>
	 * @exception EventException
	 */
	public List<MisUseReqContainerVO> searchMisUseReqContainerListBasic(String rqstNo) throws EventException;

	/**
	 * Miss Use Approval 승인내역 및 장비목록을 저장합니다.<br>
	 *
	 * @param MisUseRequestVO misUseRequestVO
	 * @param MisUseApprovalVO misUseApprovalVO
	 * @param MisUseReqContainerVO[] misUseReqContainerVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void createMisUseApprovalNumberListBasic(MisUseRequestVO misUseRequestVO,MisUseApprovalVO misUseApprovalVO,MisUseReqContainerVO[] misUseReqContainerVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 자사 및 타사장비의 Miss Use된 장비의 현황을 조회합니다.<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @return List<MisUseInOutInquiryVO>
	 * @exception EventException
	 */
	public List<MisUseInOutInquiryVO> searchMisUseInOutInquiryListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Miss Use Approval 승인장비 목록을 일괄 취소합니다.<br>
	 *
	 * @param MisUseInOutInquiryVO[] misUseInOutInquiryVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void modifyMisUseApprovalCancelListBasic(MisUseInOutInquiryVO[] misUseInOutInquiryVOs, SignOnUserAccount userAccount) throws EventException;
}