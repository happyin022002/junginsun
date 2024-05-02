/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbOfficeManageBC.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.02 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListVO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListForInquiryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Tpbmasterdatamanage Business Logic Command Interface<br>
 * - NIS2010-Tpbmasterdatamanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see Esd_tbp_102EventResponse 참조
 * @since J2EE 1.6
 */

public interface OfficeManageBC {
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchOfficeListVO	searchOfficeListVO
	 * @return List<SearchOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchOfficeListVO> searchOfficeList(SearchOfficeListVO searchOfficeListVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchOfficeListVO[] searchOfficeListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchOfficeList(SearchOfficeListVO[] searchOfficeListVO,SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO
	 * @return List<SearchOfficeListForInquiryVO>
	 * @exception EventException
	 */
	public List<SearchOfficeListForInquiryVO> searchOfficeListForInquiry(SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO) throws EventException;
	
}