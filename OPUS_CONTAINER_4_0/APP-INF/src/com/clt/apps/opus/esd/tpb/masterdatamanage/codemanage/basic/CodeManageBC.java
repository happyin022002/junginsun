/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbCodeManageBC.java
*@FileTitle : TPB Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeInquiryListVO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -TPBMasterDataManage Business Logic Command Interface<br>
 * - -TPBMasterDataManage business logic interface<br>
 *
 * @author 
 * @see ESD_TPB_0101EventResponse reference
 * @since J2EE 1.6
 */

public interface CodeManageBC {
	/**
	 * retrieve event process<br>
	 * Tpbcodemanage screen retrieve event <br>
	 * 
	 * @param SearchCodeListVO searchTPBCodeListVO
	 * @return List<SearchCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCodeListVO> searchCodeList(SearchCodeListVO searchTPBCodeListVO) throws EventException;
	
	/**
	 * <br>
	 * 
	 * @param SearchCodeListVO[] searchCodeListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchCodeList(SearchCodeListVO[] searchCodeListVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * <br>
	 * 
	 * @param SearchCodeInquiryListVO searchCodeInquiryListVO
	 * @return List<SearchCodeInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchCodeInquiryListVO> searchCodeInquiryList(SearchCodeInquiryListVO searchCodeInquiryListVO) throws EventException;
	
}