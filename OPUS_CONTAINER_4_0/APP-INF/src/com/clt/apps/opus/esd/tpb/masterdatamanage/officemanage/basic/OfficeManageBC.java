/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbOfficeManageBC.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListForInquiryVO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -Tpbmasterdatamanage Business Logic Command Interface<br>
 * - -Tpbmasterdatamanage business logic interface<br>
 *
 * @author 
 * @see Esd_tbp_102EventResponse reference
 * @since J2EE 1.6
 */

public interface OfficeManageBC {
	
	/**
	 * <br>
	 * 
	 * @param SearchOfficeListVO	searchOfficeListVO
	 * @return List<SearchOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchOfficeListVO> searchOfficeList(SearchOfficeListVO searchOfficeListVO) throws EventException;
	
	/**
	 * <br>
	 * 
	 * @param SearchOfficeListVO[] searchOfficeListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchOfficeList(SearchOfficeListVO[] searchOfficeListVO,SignOnUserAccount account) throws EventException;

	/**
	 * <br>
	 * 
	 * @param SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO
	 * @return List<SearchOfficeListForInquiryVO>
	 * @exception EventException
	 */
	public List<SearchOfficeListForInquiryVO> searchOfficeListForInquiry(SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO) throws EventException;
	
}