/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbCodeManageBC.java
*@FileTitle : TPB Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황건하
*@LastVersion : 1.1
* 2009.08.29 O Wan-Ki 1.0 최초 생성
* 2009.07.02 황건하         1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeInquiryListVO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-TPBMasterDataManage Business Logic Command Interface<br>
 * - NIS2010-TPBMasterDataManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0101EventResponse 참조
 * @since J2EE 1.6
 */

public interface CodeManageBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Tpbcodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchCodeListVO searchTPBCodeListVO
	 * @return List<SearchCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCodeListVO> searchCodeList(SearchCodeListVO searchTPBCodeListVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCodeListVO[] searchCodeListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchCodeList(SearchCodeListVO[] searchCodeListVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCodeInquiryListVO searchCodeInquiryListVO
	 * @return List<SearchCodeInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchCodeInquiryListVO> searchCodeInquiryList(SearchCodeInquiryListVO searchCodeInquiryListVO) throws EventException;
	
}