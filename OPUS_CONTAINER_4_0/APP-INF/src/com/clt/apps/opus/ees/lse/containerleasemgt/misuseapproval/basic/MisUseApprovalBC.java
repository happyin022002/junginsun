/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseApprovalBC.java
*@FileTitle : Mis Use In & Out Request
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseContainerInfoVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseInOutInquiryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.SearchParamVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Containerleasemgt Business Logic Command Interface<br>
 * Containerleasemgt Biz Logic Interface<br>
 *
 * @author 
 * @see Ees_lse_0027EventResponse 
 * @since J2EE 1.6
 */

public interface MisUseApprovalBC {

	/**
	 * Retrieving Max Miss Use Request No.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchNewMisUseRequestNumberBasic(String ofcCd) throws EventException;

	/**
	 * Checking duplication of request List about inserted Container No.<br>
	 *
	 * @param  String cntrNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchMisUseReqContainerExistBasic(String cntrNo) throws EventException;

	/**
	 * Retrieving Basic information of inserted Container No.<br>
	 *
	 * @param  String cntrNo
	 * @param  SignOnUserAccount account
	 * @return List<MisUseContainerInfoVO>
	 * @exception EventException
	 */
	public List<MisUseContainerInfoVO> searchMisUseRequestContainerBasic(String cntrNo,SignOnUserAccount account) throws EventException;

	/**
	 * Saving Miss Use Request List and Equipment List<br>
	 *
	 * @param MisUseRequestVO misUseRequestVO
	 * @param MisUseReqContainerVO[] misUseReqContainerVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void createMisUseRequestNumberListBasic(MisUseRequestVO misUseRequestVO, MisUseReqContainerVO[] misUseReqContainerVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Retrieving Max Miss Use Approval No.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchNewMisUseApprovalNumberBasic(String ofcCd) throws EventException;

	/**
	 * Retrieving List of Miss Use Request No. subject to approval<br>
	 *
	 * @return List<MisUseRequestVO>
	 * @exception EventException
	 */
	public List<MisUseRequestVO> searchMisUseRequestNoItemsBasic() throws EventException;

	/**
	 * Retrieving request information of selected Request No.<br>
	 *
	 * @param  String rqstNo
	 * @return List<MisUseRequestVO>
	 * @exception EventException
	 */
	public List<MisUseRequestVO> searchMisUseRequestInfoBasic(String rqstNo) throws EventException;

	/**
	 * Retrieving Equipment List of selected Request No.<br>
	 *
	 * @param  String rqstNo
	 * @param  SignOnUserAccount account
	 * @return List<MisUseReqContainerVO>
	 * @exception EventException
	 */
	public List<MisUseReqContainerVO> searchMisUseReqContainerListBasic(String rqstNo, SignOnUserAccount account) throws EventException;

	/**
	 * Saving Miss Uss Approval List and Equipment List<br>
	 *
	 * @param MisUseRequestVO misUseRequestVO
	 * @param MisUseApprovalVO misUseApprovalVO
	 * @param MisUseReqContainerVO[] misUseReqContainerVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void createMisUseApprovalNumberListBasic(MisUseRequestVO misUseRequestVO,MisUseApprovalVO misUseApprovalVO,MisUseReqContainerVO[] misUseReqContainerVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Retrieving current state of Miss Used Equipments of Own and Other Company<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @param SignOnUserAccount account
	 * @return List<MisUseInOutInquiryVO>
	 * @exception EventException
	 */
	public List<MisUseInOutInquiryVO> searchMisUseInOutInquiryListBasic(SearchParamVO searchParamVO, SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling all Miss Use Approval Equipment List.<br>
	 *
	 * @param MisUseInOutInquiryVO[] misUseInOutInquiryVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void modifyMisUseApprovalCancelListBasic(MisUseInOutInquiryVO[] misUseInOutInquiryVOs, SignOnUserAccount userAccount) throws EventException;
}