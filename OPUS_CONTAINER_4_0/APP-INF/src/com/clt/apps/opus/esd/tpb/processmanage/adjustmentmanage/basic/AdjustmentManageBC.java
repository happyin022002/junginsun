/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AdjustmentManageBC.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteWriteOffRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchROCToOfficeListVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -AdjustmentManage Business Logic Command Interface<br>
 * - -AdjustmentManage business logic interface<br>
 *
 * @author 
 * @see Esd_tpb_0105EventResponse reference
 * @since J2EE 1.6
 */

public interface AdjustmentManageBC {
	/**
	 * <br>
	 * 
	 * @param SearchResponsibleOfficeChangeVO	searchResponsibleOfficeChangeVO
	 * @return List<SearchResponsibleOfficeChangeVO>
	 * @exception EventException
	 */
	public List<SearchResponsibleOfficeChangeVO> searchResponsibleOfficeChange(SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO) throws EventException;	
	/**
	 * <br>
	 * 
	 * @param SearchResponsibleOfficeChangeInquiryVO	searchResponsibleOfficeChangeInquiryVO
	 * @return List<SearchResponsibleOfficeChangeInquiryVO>
	 * @exception EventException
	 */
	public List<SearchResponsibleOfficeChangeInquiryVO> searchResponsibleOfficeChangeInquiry(SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO) throws EventException;	
	/**
	 * <br>
	 * 
	 * @param SearchWriteOffVO	searchWriteOffVO
	 * @return List<SearchWriteOffVO>
	 * @exception EventException
	 */
	public List<SearchWriteOffVO> searchWriteOff(SearchWriteOffVO searchWriteOffVO) throws EventException;	
	/**
	 * <br>
	 * 
	 * @param SearchWriteOffInquiryVO	searchWriteOffInquiryVO
	 * @return List<SearchWriteOffInquiryVO>
	 * @exception EventException
	 */
	public List<SearchWriteOffInquiryVO> searchWriteOffInquiry(SearchWriteOffInquiryVO searchWriteOffInquiryVO) throws EventException;	

	/**
	 * <br>
	 * 
	 * @param SearchROCToOfficeListVO searchROCToOfficeListVO
	 * @return List<SearchROCToOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchROCToOfficeListVO> searchROCToOfficeList(SearchROCToOfficeListVO searchROCToOfficeListVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createResponsibleOfficeChangeRequest(CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createResponsibleOfficeChangeApprove(CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeResponsibleOfficeChangeRequest(DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param CreateWriteOffRequestVO[] createWriteOffRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createWriteOffRequest(CreateWriteOffRequestVO[] createWriteOffRequestVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param CreateWriteOffApproveVO[] createWriteOffApproveVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createWriteOffApprove(CreateWriteOffApproveVO[] createWriteOffApproveVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param DeleteWriteOffRequestVO[] deleteWriteOffRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeWriteOffRequest(DeleteWriteOffRequestVO[] deleteWriteOffRequestVO,SignOnUserAccount account) throws EventException;
}