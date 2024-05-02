/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceInquiryBC.java
*@FileTitle : PerformanceInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchClosingTPBListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchEACIssuanceListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchNonTPBListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -PerformanceInquiry Business Logic Command Interface<br>
 * - -PerformanceInquiry business logic interface<br>
 *
 * @author 
 * @see Esd_tpb_105EventResponse reference
 * @since J2EE 1.6
 */

public interface PerformanceInquiryBC {
	/**
	 * <br>
	 * 
	 * @param SearchClosingTPBListVO searchClosingTPBListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchClosingTPBListVO>
	 * @exception EventException
	 */
	public List<SearchClosingTPBListVO> searchClosingTPBList(SearchClosingTPBListVO searchClosingTPBListVO, SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchNonTPBListVO searchNonTPBListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchNonTPBListVO>
	 * @exception EventException
	 */
	public List<SearchNonTPBListVO> searchNonTPBList(SearchNonTPBListVO searchNonTPBListVO, SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchEACIssuanceListVO searchEACIssuanceListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchEACIssuanceListVO>
	 * @exception EventException
	 */
	public List<SearchEACIssuanceListVO> searchEACIssuanceList(SearchEACIssuanceListVO searchEACIssuanceListVO, SignOnUserAccount account) throws EventException;
}