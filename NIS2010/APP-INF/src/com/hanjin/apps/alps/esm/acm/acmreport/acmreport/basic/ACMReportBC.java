/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportBC.java
*@FileTitle : ACMReportBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.16 김봉균
* 1.0 Creation
* 
* 2014.06.11 박다은 [CHM-201428456] Comm 모듈의 ACM 발행 CSR Detail 기능 로직 변경
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRInquiryVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CommReportVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.EstimatedPerformanceVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.ReportItemVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailforCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailforCommissionHdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Bong-Gyoon
 * @see Esm_Acm_0034EventResponse 참조
 * @since J2EE 1.6
 */

public interface ACMReportBC {

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String key) throws EventException;

	/**
	 * [ESM_ACM_0034]
	 * CSR Inquiry 목록을 조회<br>
	 *
	 * @param CSRInquiryVO csrInquiryVO
	 * @return List<CSRInquiryVO>
	 * @exception EventException
	 */
	public List<CSRInquiryVO> searchCSRInquiry(CSRInquiryVO csrInquiryVO) throws EventException;

	/**
	 * [ESM_ACM_0034]
	 * CSR Inquiry 목록을 조회(CURR_CD에 따른 Total 값 구하기)<br>
	 *
	 * @param CSRInquiryVO csrInquiryVO
	 * @return List<CSRInquiryVO>
	 * @exception EventException
	 */
	public List<CSRInquiryVO> searchCSRInquiryCurrAMT(CSRInquiryVO csrInquiryVO) throws EventException;

	/**
	 * [ESM_ACM_0111] Retrieve<br>
	 * CSR Detail 목록을 조회<br>
	 *
	 * @param CSRDetailVO csrDetailVO
	 * @return List<CSRDetailVO>
	 * @exception EventException
	 */
	public List<CSRDetailVO> searchCSRDetail(CSRDetailVO csrDetailVO) throws EventException;

	/**
	 * [ESM_ACM_0037], [ESM_ACM_0118]
	 * Customized RPT Form 콤보 그룹명을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<ReportItemVO>
	 * @exception EventException
	 */
	public List<ReportItemVO> getReportGroup(SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0037], [ESM_ACM_0118]
	 * Customized RPT Form 컬럼 Item 목록을 조회
	 *
	 * @param ReportItemVO reportItemVO
	 * @param SignOnUserAccount account
	 * @return List<ReportItemVO>
	 * @exception EventException
	 */
	public List<ReportItemVO> getReportItem(ReportItemVO reportItemVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0037] BackEndJob 시작<br>
	 *
	 * @param CommReportVO commReportVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchCommReport(CommReportVO commReportVO, SignOnUserAccount account);

	/**
	 * [ESM_ACM_0037] BackEndJob 결과
	 * Commission Report 목록을 조회<br>
	 *
	 * @param String key
	 * @return List<CommReportVO>
	 * @exception EventException
	 */
	public List<CommReportVO> resultBackEndJobSearchCommReport(String key) throws EventException;

	/**
	 * [ESM_ACM_0118]
	 * Customized RPT Form 콤보 그룹명과 컬럼 Item 목록을 저장
	 *
	 * @param ReportItemVO reportItemVO
	 * @param ReportItemVO[] reportItemVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageReportItem(ReportItemVO reportItemVO, ReportItemVO[] reportItemVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_9991] Retrieve<br>
	 * Estimated Performance 목록을 조회<br>
	 *
	 * @param EstimatedPerformanceVO estimatedPerformanceVO
	 * @return List<EstimatedPerformanceVO>
	 * @exception EventException
	 */
	public List<EstimatedPerformanceVO> searchEstimatedPerformance(EstimatedPerformanceVO estimatedPerformanceVO) throws EventException;
	
	/**
	 * [ESM_ACM_9991]
	 * Estimated Performance 목록을 저장
	 * 
	 * @param estimatedPerformanceVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageEstimatedPerformance(EstimatedPerformanceVO[] estimatedPerformanceVOs, SignOnUserAccount account) throws EventException;


	/**
	 * [ESM_ACM_0119] CSR Detail 팝업
	 * 
	 * @param csrDetailforCommissionHdrVO
	 * @return
	 * @throws EventException
	 */
	public List<CSRDetailforCommissionHdVO> searchCSRDetailforCommissionHdr(CSRDetailforCommissionHdVO csrDetailforCommissionHdrVO) throws EventException;
	
	/**
	 * [ESM_ACM_0119] CSR Detail 팝업
	 * 
	 * @param csrDetailforCommissionVO
	 * @return
	 * @throws EventException
	 */
	public List<CSRDetailforCommissionVO> searchCSRDetailforCommissionDtrb(CSRDetailforCommissionVO csrDetailforCommissionVO) throws EventException;
}