/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceInquiryBC.java
*@FileTitle : PerformanceInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009.07.17 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchClosingTPBListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchEACIssuanceListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchNonTPBListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PerformanceInquiry Business Logic Command Interface<br>
 * - ALPS-PerformanceInquiry에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jong-Geon Byeon
 * @see Esd_tpb_105EventResponse 참조
 * @since J2EE 1.6
 */

public interface PerformanceInquiryBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchClosingTPBListVO searchClosingTPBListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchClosingTPBListVO>
	 * @exception EventException
	 */
	public List<SearchClosingTPBListVO> searchClosingTPBList(SearchClosingTPBListVO searchClosingTPBListVO, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchNonTPBListVO searchNonTPBListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchNonTPBListVO>
	 * @exception EventException
	 */
	public List<SearchNonTPBListVO> searchNonTPBList(SearchNonTPBListVO searchNonTPBListVO, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchEACIssuanceListVO searchEACIssuanceListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchEACIssuanceListVO>
	 * @exception EventException
	 */
	public List<SearchEACIssuanceListVO> searchEACIssuanceList(SearchEACIssuanceListVO searchEACIssuanceListVO, SignOnUserAccount account) throws EventException;
}