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
=========================================================*/
package com.clt.apps.opus.esm.acm.acmreport.acmreport.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.CSRDetailVO;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.CSRInquiryVO;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.CommReportVO;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.ReportItemVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ACMRequest Business Logic Command Interface<br>
 * - OPUS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * [ESM_ACM_0037] BackEndJob 시작<br>
	 *
	 * @param CommReportVO commReportVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchCommReport2(CommReportVO commReportVO, SignOnUserAccount account);

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
	 * [ESM_ACM_0037]
	 * By Container No. 탭 조회
	 * @param commReportVO
	 * @return
	 * @throws EventException
	 */
	public List<CommReportVO> searchReportListByCntrNo(CommReportVO commReportVO) throws EventException;
}