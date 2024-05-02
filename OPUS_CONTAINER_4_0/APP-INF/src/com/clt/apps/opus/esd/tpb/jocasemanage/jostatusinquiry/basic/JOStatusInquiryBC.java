/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOStatusInquiryBC.java
*@FileTitle : JOStatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOInvoiceListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailInfoVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchProcessListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * -JOStatusInquiry Business Logic Command Interface<br>
 * - -JOStatusInquiry에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see Esd_tpb_105EventResponse 참조
 * @since J2EE 1.6
 */

public interface JOStatusInquiryBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOTPBDetailInfoVO searchJOTpbDetailInfoVO
	 * @return List<SearchJOTPBDetailInfoVO>
	 * @exception EventException
	 */
	public List<SearchJOTPBDetailInfoVO> searchTPBDetailInfo(SearchJOTPBDetailInfoVO searchJOTpbDetailInfoVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOTPBDetailListVO searchJOTpbDetailListVO
	 * @return List<SearchJOTPBDetailListVO>
	 * @exception EventException
	 */
	public List<SearchJOTPBDetailListVO> searchTPBDetailList(SearchJOTPBDetailListVO searchJOTpbDetailListVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOInvoiceListVO searchJOInvoiceListVO
	 * @return List<SearchJOInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchJOInvoiceListVO> searchInvoiceList(SearchJOInvoiceListVO searchJOInvoiceListVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchProcessListVO searchProcessListVO
	 * @return List<SearchProcessListVO>
	 * @exception EventException
	 */
	public List<SearchProcessListVO> searchProcessList(SearchProcessListVO searchProcessListVO) throws EventException;
}