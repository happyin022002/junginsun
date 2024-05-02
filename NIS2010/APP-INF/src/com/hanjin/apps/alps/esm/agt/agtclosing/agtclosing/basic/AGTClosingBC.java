/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTClosingBC.java
*@FileTitle : Monthly Target VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.07 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.EstmPerfRptListVO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRInquiryDetailVO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRInquiryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.GlEstmRevVvdVO;

/**
 * ALPS-Agtclosing Business Logic Command Interface<br>
 * - ALPS-Agtclosing에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyung-won Chu
 * @see Esmagt0019EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGTClosingBC {

	/**
	 * ESM_AGT_0019 : [이벤트]<br>
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param GlEstmRevVvdVO	glEstmRevVvdVO
	 * @return List<GlEstmRevVvdVO>
	 * @exception EventException
	 */
	public List<GlEstmRevVvdVO> searchCommTargetVVD(GlEstmRevVvdVO glEstmRevVvdVO) throws EventException;

	/**
	 * ESM_AGT_0032 : [이벤트]<br>
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param GlEstmRevVvdVO	glEstmRevVvdVO
	 * @return List<GlEstmRevVvdVO>
	 * @exception EventException
	 */
	public List<GlEstmRevVvdVO> searchAfterClosingList(GlEstmRevVvdVO glEstmRevVvdVO) throws EventException;
	/**
	 * ESM_AGT_0052 : [이벤트]<br>
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCSRInquiryVO searchCSRInquiryVO
	 * @return List<SearchCSRInquiryVO>
	 * @exception EventException
	 */
	public List<SearchCSRInquiryVO> searchCSRIquiry(SearchCSRInquiryVO searchCSRInquiryVO) throws EventException;
	/**
	 * ESM_AGT_0053 : [이벤트]<br>
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCSRInquiryDetailVO searchCSRInquiryDetailVO
	 * @return List<SearchCSRInquiryDetailVO>
	 * @exception EventException
	 */
	public List<SearchCSRInquiryDetailVO> searchCSRIquiryDetail(SearchCSRInquiryDetailVO searchCSRInquiryDetailVO) throws EventException;
	/**
	 * ESM_AGT_0055 : [Retrieve]<br>
	 * [AGT commission의 추정실적]을 [조회]합니다.<br>
	 * 
	 * @param EstmPerfRptListVO estmPerfRptListVO
	 * @return List<EstmPerfRptListVO>
	 * @exception EventException
	 */
	public List<EstmPerfRptListVO> searchEstmPerfRptByRvvd(EstmPerfRptListVO estmPerfRptListVO) throws EventException;


}