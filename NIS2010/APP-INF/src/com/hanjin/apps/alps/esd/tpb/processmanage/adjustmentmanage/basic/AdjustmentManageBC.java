/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AdjustmentManageBC.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeApproveVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeRequestVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffApproveVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffRequestVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.DeleteResponsibleOfficeChangeRequestVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.DeleteWriteOffRequestVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchROCToOfficeListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryReviewVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffReviewVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-AdjustmentManage Business Logic Command Interface<br>
 * - ALPS-AdjustmentManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sun, CHOI
 * @see Esd_tpb_0105EventResponse 참조
 * @since J2EE 1.6
 */

public interface AdjustmentManageBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchResponsibleOfficeChangeVO	searchResponsibleOfficeChangeVO
	 * @return List<SearchResponsibleOfficeChangeVO>
	 * @exception EventException
	 */
	public List<SearchResponsibleOfficeChangeVO> searchResponsibleOfficeChange(SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO) throws EventException;	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchResponsibleOfficeChangeInquiryVO	searchResponsibleOfficeChangeInquiryVO
	 * @return List<SearchResponsibleOfficeChangeInquiryVO>
	 * @exception EventException
	 */
	public List<SearchResponsibleOfficeChangeInquiryVO> searchResponsibleOfficeChangeInquiry(SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO) throws EventException;	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchWriteOffVO	searchWriteOffVO
	 * @return List<SearchWriteOffVO>
	 * @exception EventException
	 */
	public List<SearchWriteOffVO> searchWriteOff(SearchWriteOffVO searchWriteOffVO) throws EventException;	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchWriteOffInquiryVO	searchWriteOffInquiryVO
	 * @return List<SearchWriteOffInquiryVO>
	 * @exception EventException
	 */
	public List<SearchWriteOffInquiryVO> searchWriteOffInquiry(SearchWriteOffInquiryVO searchWriteOffInquiryVO) throws EventException;	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchWriteOffReviewVO searchWriteOffVO
	 * @return List<SearchWriteOffReviewVO>
	 * @exception EventException
	 */
	public List<SearchWriteOffReviewVO> searchWriteOffReview(SearchWriteOffReviewVO searchWriteOffVO) throws EventException;	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchWriteOffInquiryReviewVO searchWriteOffInquiryVO
	 * @return List<SearchWriteOffInquiryReviewVO>
	 * @exception EventException
	 */
	public List<SearchWriteOffInquiryReviewVO> searchWriteOffInquiryReview(SearchWriteOffInquiryReviewVO searchWriteOffInquiryVO) throws EventException;	

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchROCToOfficeListVO searchROCToOfficeListVO
	 * @return List<SearchROCToOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchROCToOfficeListVO> searchROCToOfficeList(SearchROCToOfficeListVO searchROCToOfficeListVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createResponsibleOfficeChangeRequest(CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createResponsibleOfficeChangeApprove(CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeResponsibleOfficeChangeRequest(DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CreateWriteOffRequestVO[] createWriteOffRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createWriteOffRequest(CreateWriteOffRequestVO[] createWriteOffRequestVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CreateWriteOffApproveVO[] createWriteOffApproveVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createWriteOffApprove(CreateWriteOffApproveVO[] createWriteOffApproveVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param DeleteWriteOffRequestVO[] deleteWriteOffRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeWriteOffRequest(DeleteWriteOffRequestVO[] deleteWriteOffRequestVO,SignOnUserAccount account) throws EventException;
}