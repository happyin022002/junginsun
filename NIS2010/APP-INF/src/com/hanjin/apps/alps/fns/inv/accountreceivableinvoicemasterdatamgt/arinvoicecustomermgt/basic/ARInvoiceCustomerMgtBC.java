/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceCustomerMgtBC.java
 *@FileTitle : Customer Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 *  --------------------------------------------------------
 * History
 * 2011.09.28 권   민 [CHM-201113617] [INV]SVAT Reg. No for CMBBB SVAT Reg. NO 입력/저장 기능 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic;

import java.util.Collection;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ARInvoiceBadCustomerHistoryVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AgentByVesselPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CprtItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustRepEmlInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerSecurityVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvArScrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvCprtCdConvVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvSubAgnCustCdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchAgentListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchSVATNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SecurityInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ActPayerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AutoInvCustomerVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.InvArSpndVatRgstNoVO;
import com.hanjin.syscommon.common.table.InvCprtTmpltChgVO;

/**
 * ALPS-Accountreceivableinvoicemasterdatamgt Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicemasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author saeil kim
 * @see Fns_inv_0014EventResponse 참조
 * @since J2EE 1.4
 */

public interface ARInvoiceCustomerMgtBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Arinvoicecustomermgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<SearchCustomerVO>
	 * @exception EventException
	 */
	public List<SearchCustomerVO> searchCustomerList(SearchCustomerVO searchCustomerVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerListCnt(SearchCustomerVO searchCustomerVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Customer 테이블 에서 조회조건에 해당하는 기초정보 및 신용정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String country
	 * @param String cust
	 * @param String regNo
	 * @return List<CreditCustomerVO>
	 * @exception EventException
	 */
	public List<CreditCustomerVO> searchCreditCustomer(String country, String cust, String regNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MDM_CUST_REP 테이블 에서 조회조건에 해당하는E-MAIL정보를 가져온다.<br>
	 * 
	 * @author Seungil Baek
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustRepEmlInfoVO>
	 * @exception EventException
	 */
	public List<CustRepEmlInfoVO> searchMdmCustRepEmlInfo(String custCntCd, String custSeq) throws EventException;
	

	/**
	 * 조회 이벤트 처리<br>
	 * Option에 따라 Credit Customer/ Sale Customer 정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String custFlag
	 * @param String usrOfcCd
	 * @param String ofc
	 * @param String custRlseCtrlFlg
	 * @return List<CustomerListVO>
	 * @exception EventException
	 */
	public List<CustomerListVO> searchCustomerListByOffice(String custFlag, String usrOfcCd, String ofc, String custRlseCtrlFlg) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * 소속 AR_HD_QTR_OFC_CD 산하의 모든 office code를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSalesOfcList(String ofc) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * POP UI에사 Customer 정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cntry
	 * @param String custNm
	 * @param String zipNo
	 * @param String chkNm
	 * @param String custRgstNo
	 * @return List<PopCustomerListVO>
	 * @exception EventException
	 */
	public List<PopCustomerListVO> searchPopCustomerList(String cntry, String custNm, String zipNo, String chkNm, String custRgstNo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * FNS_INV_0090
	 * 
	 * @author saeil
	 * @param String rfaNo
	 * @return List<PriCustomerListVO>
	 * @exception EventException
	 */
	public List<PriCustomerListVO> searchRFACustomerList(String rfaNo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * FNS_INV_0091
	 * 
	 * @author saeil
	 * @param String scNo
	 * @return List<PriCustomerListVO>
	 * @exception EventException
	 */
	public List<PriCustomerListVO> searchSCCustomerList(String scNo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * FNS_INV_0080
	 * 
	 * @param String option
	 * @param String arOfc
	 * @param String ofc
	 * @return List<AgentByVesselPortVO>
	 * @exception EventException
	 */
	public List<AgentByVesselPortVO> searchAgentByVesselPortList(String option, String arOfc, String ofc) throws EventException;

	/**
	 * FNS_INV_0081<br>
	 * 북중국 Inbound Collection Agent code list를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @param String arControl
	 * @return List<SearchAgentListVO>
	 * @exception EventException
	 */
	public List<SearchAgentListVO> searchAgentList(String arOfc, String arControl) throws EventException;

	/**
	 * ARInvoiceCustomerMgt화면에 대한 조회 이벤트 처리<br>
	 * FNS_INV_0081 vessel Search
	 * 
	 * @author saeil
	 * @param String vsl
	 * @return List<AgentByVesselPortVO>
	 * @exception EventException
	 */
	//public List<AgentByVesselPortVO> searchAgentByVessel(String vsl) throws EventException;

	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * FNS_INV_0081 vessel delete
	 * 
	 * @author saeil
	 * @param AgentByVesselPortVO[] agentByVesselPortVos
	 * @param String userId
	 * @exception EventException
	 */

	//public void removeAgentByVessel(AgentByVesselPortVO[] agentByVesselPortVos, String userId) throws EventException;

	/**
	 * ARInvoiceCustomerMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * FNS_INV_0082 by Pod,Lane Search
	 * 
	 * @author saeil
	 * @param String pod
	 * @param String lane
	 * @return List<AgentByVesselPortVO>
	 * @exception EventException
	 */
	//public List<AgentByVesselPortVO> searchAgentByPort(String pod, String lane) throws EventException;

//	/**
//	 * 다건의 데이터를 일괄적으로 생성및 수정 한다.<br>
//	 * FNS_INV_0082 pod Insert
//	 * 
//	 * @author saeil
//	 * @param AgentByVesselPortVO[] agtPodVo
//	 * @param String userId
//	 * @exception EventException
//	 */
//	public void manageAgentByPort(AgentByVesselPortVO[] agtPodVo, String userId) throws EventException;

//	/**
//	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
//	 * FNS_INV_0082 vessel delete
//	 * 
//	 * @author saeil
//	 * @param AgentByVesselPortVO[] agentByVesselPortVos
//	 * @param String userId
//	 * @exception EventException
//	 */
//	public void removeAgentByPort(AgentByVesselPortVO[] agentByVesselPortVos, String userId) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용할 Conversion code를 유형별로 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @param String rfaNO
	 * @param String codeTy
	 * @return List<InvCprtCdConvVO>
	 * @exception EventException
	 */
	public List<InvCprtCdConvVO> searchCodeConversionList(String scNo, String rfaNO, String codeTy) throws EventException;

	/**
	 * S/C No, RFA no로 PRI 시스템에서 Customer를 찾아 온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @param String rfaNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerName(String scNo, String rfaNo) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용할 한진해운 사용 code를 Customer 사용 Code로 Conversion하기 위한 code를 등록하는 화면에서 한진해운 Code 가 유효한 Code 인지를 check한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cdTp
	 * @param String cd
	 * @return String
	 * @exception EventException
	 */
	public String searchHJSCode(String cdTp, String cd) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용할 conversion code를 수정한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCprtCdConvVO[] invCprtCdConvVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCodeConversion(InvCprtCdConvVO[] invCprtCdConvVOs, String userId) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용할 Conversion code를 유형별로 등록한다. 이미 다른 S/C NO나 RFA NO로 등록된 Conversion code를 신규 S/C NO나 RFA NO로 내용을 Copy 하여 새로 생성해준다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCprtCdConvVO[] invCprtCdConvVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCodeConversion(InvCprtCdConvVO[] invCprtCdConvVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Customer 기본 신용정보 및 신용담보정보조회 조회한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustomerSecurityVO>
	 * @exception EventException
	 */
	public List<CustomerSecurityVO> searchSecurityList(String custCntCd, String custSeq) throws EventException;

	/**
	 * 시스템에 Customer 신용정보인 담보등록, 수정, 삭제한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param InvArScrVO[] invArScrVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCustomerSecurity(InvArScrVO[] invArScrVOs, String userId) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용. 선택가능한 모든 항목 List 와 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return CPRT_ItemVO
	 * @exception EventException
	 */
	public CprtItemVO searchReportItemList(String userId, String ofc) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용. Template으로 등록된 선택한 항목 List 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String arOfcCd
	 * @return TemplateVO
	 * @exception EventException
	 */
	public TemplateVO searchSelectedItemList(String tmplate,String arOfcCd) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용. 신규입력한 Template 명이 이미 존재하는지를 check한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @return String
	 * @exception EventException
	 */

	public String searchTemplateName(String tmplate) throws EventException;

	/**
	 * Template name으로 선택한 item을 등록,수정, 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param TemplateVO[] tmplateVOs
	 * @param InvCprtTmpltChgVO[] invCprtTmpltChgVOs
	 * @param String userId
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void manageTemplateItem(TemplateVO[] tmplateVOs, InvCprtTmpltChgVO[] invCprtTmpltChgVOs, String userId, String ofcCd) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에 사용하기 위해 등록한 Template을 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void removeTemplate(String tmplate, String ofcCd) throws EventException;

	/**
	 * 입력된 조건으로 Customer별 신용담보정보조회 조회한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param SecurityInputVO securityInputVO
	 * @return List<CustomerSecurityVO>
	 * @exception EventException
	 */
	public List<CustomerSecurityVO> searchCustomerSecurityList(SecurityInputVO securityInputVO) throws EventException;
	
	/**
	 * FNS_INV_0081<br>
	 * 시스템에 북중국 Inbound Collection Agent와 Vessel code, Port(POD)/Lane별로  Match 하여 등록, 수정한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String option
	 * @param AgentByVesselPortVO[] agentByVesselPortVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageAgentByVslPod(String option, AgentByVesselPortVO[] agentByVesselPortVOs, String userId) throws EventException;
	
	/**
	 * FNS_INV_0082<br>
	 * POD 별 관리 북중국 Inbound Collection Agent를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @return List<AgentByVesselPortVO>
	 * @exception EventException
	 */
	public List<AgentByVesselPortVO> searchSubAgentList(String arOfc) throws EventException;
	
	/**
	 * FNS_INV_0082<br>
	 * 미주( USA) 지역 Port 별  Agent 을 Match 하여 등록한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param InvSubAgnCustCdVO[] invSubAgnCustCdVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageSubAgent(InvSubAgnCustCdVO[] invSubAgnCustCdVOs, String userId) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SVAT Reg. NO for CMBBB 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchSVATNoVO searchSVATNoVO
	 * @return List<SearchSVATNoVO>
	 * @exception EventException
	 */
	public List<SearchSVATNoVO> searchSVATNo(SearchSVATNoVO searchSVATNoVO) throws EventException;
	
	/**
	 * FNS_INV_0123<br>
	 * SVAT Reg. NO 입력/저장 function.<br>
	 * 
	 * @author		권 민
	 * @param		InvArSpndVatRgstNoVO invArSpndVatRgstNoVO
	 * @param		String userId
	 * @exception	EventException
	 */
	public void manageSVATNo(InvArSpndVatRgstNoVO invArSpndVatRgstNoVO, String userId) throws EventException ;
	
	/**
	 * 악성화주 리스트 조회<br>
	 * 
	 * @param ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO
	 * @return List<ARInvoiceBadCustomerHistoryVO>
	 * @exception EventException
	 */
	public List<ARInvoiceBadCustomerHistoryVO> searchBadCustomerList(ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO) throws EventException;

	/**
	 * 악성화주 히스토리 리스트 조회<br>
	 * 
	 * @param ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO
	 * @return List<ARInvoiceBadCustomerHistoryVO>
	 * @exception EventException
	 */
	public List<ARInvoiceBadCustomerHistoryVO> searchBadCustomerHistoryList(ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO) throws EventException;


	/**
	 * INV_BAD_CUST_HIS_PROC 호출함.
	 * 
	 * @param Collection models
	 * @param String eai_id
	 * @param String in_kind
	 * @exception	EventException
	 */
	@SuppressWarnings("unchecked")
	public void manageInvBadCustHist(Collection models, String eai_id, String in_kind ) throws EventException;
	
	/**
	 * MDM Actual Payer 리스트 조회<br>
	 * 
	 * @param String arOfcCd
	 * @param String userOfcCd
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return List<ActPayerVO>
	 * @exception EventException
	 */
	public List<ActPayerVO> searchActualPayerList(String arOfcCd, String userOfcCd, String actCustCntCd, String actCustSeq) throws EventException;

	
	/**
	 * MDM Auto Invoice 대상화주 리스트 조회<br>
	 * 
	 * @param String arOfcCd
	 * @param String ioBndCd
	 * @param String userOfcCd
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return List<AutoInvCustomerVO>
	 * @exception EventException
	 */
	public List<AutoInvCustomerVO> searchAutoInvCustomerList(String arOfcCd, String ioBndCd, String userOfcCd, String actCustCntCd,String actCustSeq) throws EventException;


}