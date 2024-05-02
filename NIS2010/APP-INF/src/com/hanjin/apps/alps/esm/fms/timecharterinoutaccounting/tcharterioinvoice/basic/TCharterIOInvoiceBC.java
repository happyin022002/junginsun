/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceBC.java
*@FileTitle : Charterer's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.13 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic;

import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCharterInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchCalPrepaymentInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchManhourListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOffhireInvoiceVmsVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerAccountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceAutoMatchVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrChgVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffhExpnVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnrAcctSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.InvoiceContainerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchBunkerPriceInterfaceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchChaterInvoiceSdmsListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchInvoiceListByRevenueSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemRegistrationListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireExpensesListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceVmsListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchNewOwnerAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceAutoMatchListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVesselCodeInvoiceInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByCharterVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByOffHireVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FrgnExchangeTransactionVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FrgnExchangeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.OwnerAccountByPaymentSlipVO;


/**
 * ALPS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - ALPS-Timecharterinoutaccounting에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon-Tae, Jung
 * @see Ui_fms_0016EventResponse 참조 
 * @since J2EE 1.5 
 */

public interface TCharterIOInvoiceBC {
	
	/**
	 * Charterer's Account 화면에서 데이타 조회(용선주 비용에 관련된 계정을 조회한다)<br>
	 * 
	 * @param condCharterInvoiceVO CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCharterInvoiceListVO> searchCharterInvoiceList(CondCharterInvoiceVO condCharterInvoiceVO) throws EventException;
	
	/**
	 * Charterer's Account 화면에서 데이타 조회(Currency 별 금액의 합을 가져온다)<br>
	 * 
	 * @param condCharterInvoiceVO CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceSumVO>
	 * @exception EventException
	 */
	public List<SearchCharterInvoiceSumVO> searchCharterInvoiceSum(CondCharterInvoiceVO condCharterInvoiceVO) throws EventException;
	
	/**
	 * fletCtrlNo와 bnkYrmon에 해당하는 항차 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @param revYrmon String
	 * @return List<SearchVvdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchVvdListByCharterVO> searchVvdListByCharter(String fletCtrtNo, String revYrmon) throws EventException;
	
	
	/**
	 * Charterer's Account 화면에서 용선주 비용을 변경한다<br>
	 * 
	 * @param customInvoiceVO CustomInvoiceVO
	 * @param customInvDtlVOs CustomInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCharterInvoice(CustomInvoiceVO customInvoiceVO, CustomInvDtlVO[] customInvDtlVOs, String usrId) throws EventException;
	
	/**
	 * Agreement Creation 화면에서 메일을 발송한다<br>
	 * 
	 * @param customSendEmailVO CustomSendEmailVO
	 * @param keys List<String>
	 * @param csrNo String
	 * @return String
	 * @exception EventException
	 */
	public String sendEmail(CustomSendEmailVO customSendEmailVO, List<String> keys, String csrNo) throws EventException;
	
	/**
	 * TCharterIOInvoice화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condSearchOwnerInvoiceVO CondSearchOwnerInvoiceVO
	 * @return List<SearchOwnerInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerInvoiceListVO> searchOwnerInvoiceList(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO) throws EventException;
	
	/**
	 * TCharterIOInvoice화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param customOwnrAcctSlpVOs CustomOwnrAcctSlpVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void modifyOwnerInvoice(CustomOwnrAcctSlpVO[] customOwnrAcctSlpVOs, String usrid) throws EventException;
	
	/**
	 * TCharterIOInvoice화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condSearchOwnerInvoiceAutoMatchVO CondSearchOwnerInvoiceAutoMatchVO
	 * @return List<SearchOwnerInvoiceAutoMatchListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchList(CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO) throws EventException;
	

	
	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceCheck(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException;
	
	
	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceList(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException;
	
	/**
	 * Off-Hire Expenses 화면에서 SUM 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSum(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException;
	
	/**
	 * CtrtNo와 Duration 에 해당하는 항차 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchVvdListByOffHireVO>
	 * @exception EventException
	 */
	public List<SearchVvdListByOffHireVO> searchVvdListByOffHire(String fletCtrtNo, String effDt, String expDt, String vslCd) throws EventException;

	/**
	 * TCharterIOInvoice화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @exception EventException
	 * @return List<SearchManhourItemListVO>
	 */
	public List<SearchManhourItemListVO> searchManhourItemList() throws EventException;
	
	/**
	 * Off-Hire Expenses 화면에서 Offhire Expenses 정보를 등록 및 변경한다<br>
	 * 
	 * @param customOffInvoiceVO CustomOffInvoiceVO
	 * @param customOffInvDtlVOs CustomOffInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOffhireInvoice(CustomOffInvoiceVO customOffInvoiceVO, CustomOffInvDtlVO[] customOffInvDtlVOs, String usrId) throws EventException;
	
	/**
	 * TCharterIOInvoice화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condSearchManhourListVO CondSearchManhourListVO
	 * @return List<SearchManhourListVO>
	 * @exception EventException
	 */
	public List<SearchManhourListVO> searchManhourList(CondSearchManhourListVO condSearchManhourListVO) throws EventException;
	
	/**
	 * TCharterIOInvoice화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param customManHrChgVOs CustomManHrChgVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageManhourList(CustomManHrChgVO[] customManHrChgVOs, String usrid) throws EventException;
	
	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return List<SearchOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchOffhireInvoiceListVO> searchOffhireInvoiceList(String fletCtrtNo, String invSeq) throws EventException;
	
	/**
	 * Off-Hire Expenses 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListSumVO> searchOffhireInvoiceListSum(String fletCtrtNo, String invSeq) throws EventException;
	
	/**
	 * Offhire Selection 화면에서 데이타 조회(POPUP)<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchOffhireSelectionListVO>
	 * @exception EventException
	 */
	public List<SearchOffhireSelectionListVO> searchOffhireSelectionList(String fletCtrtNo) throws EventException;
	
	/**
	 * Off-Hire Expenses 화면에서 Offhire Expenses 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @exception EventException
	 */
	public void removeOffhireInvoice(String fletCtrtNo, String invSeq) throws EventException;
	
	/**
	 * Manhour Item을 관리하는 항목이고  Item 별 자료를 조회한다<br>
	 * 
	 * @return List<SearchManhourItemRegistrationListVO>
	 * @exception EventException
	 */
	public List<SearchManhourItemRegistrationListVO> searchManhourItemRegistrationList() throws EventException;
	
	/**
	 * Manhour Item을 관리하는 항목이고  Item 별 자료를 저장한다<br>
	 * 
	 * @param customManHrListVOs CustomManHrListVO
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageManhourItemRegistration(CustomManHrListVO[] customManHrListVOs, String usrid) throws EventException;
	
	/**
	 * Offhire Expenses from VMS 화면에서 데이타 조회(POPUP)<br>
	 * 
	 * @param condSearchOffhireInvoiceVmsVO CondSearchOffhireInvoiceVmsVO
	 * @return List<SearchOffhireInvoiceVmsListVO>
	 * @exception EventException
	 */
	public List<SearchOffhireInvoiceVmsListVO> searchOffhireInvoiceVmsList(CondSearchOffhireInvoiceVmsVO condSearchOffhireInvoiceVmsVO) throws EventException;
	
	/**
	 * Offhire Expenses from VMS 화면에서 등록 정보를 변경한다<br>
	 * 
	 * @param customOffhExpnVOs CustomOffhExpnVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void modifyOffhireInvoiceVms(CustomOffhExpnVO[] customOffhExpnVOs, String usrid) throws EventException;
	
	/**
	 * Prepayments 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceList(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException;
	
	/**
	 * Prepayments 화면에서 SUM 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSum(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException;
	
	/**
	 * Prepayments 화면에서 Invoice 정보를 등록한다<br>
	 * 
	 * @param customPreInvoiceVO CustomPreInvoiceVO
	 * @param customPreInvDtlVOs CustomPreInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void creatPrepaymentInvoice(CustomPreInvoiceVO customPreInvoiceVO, CustomPreInvDtlVO[] customPreInvDtlVOs, String usrId) throws EventException;
	
	/**
	 * Prepayments 화면에서 Invoice 정보를 변경/삭제한다<br>
	 * 
	 * @param customPreInvoiceVO CustomPreInvoiceVO
	 * @param customPreInvDtlVOs CustomPreInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void managePrepaymentInvoice(CustomPreInvoiceVO customPreInvoiceVO, CustomPreInvDtlVO[] customPreInvDtlVOs, String usrId) throws EventException;
	
	/**
	 * 사선/용선/대선에 대한 계약정보 조회<br>
	 * Prepayments 화면에서 데이타 조회(Inquiry 선택시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ppayHirNo String
	 * @param invSeq String
	 * @return InvoiceContainerVO
	 * @exception EventException
	 */
	public InvoiceContainerVO searchPrepaymentInvoiceList(String fletCtrtNo, String ppayHirNo, String invSeq) throws EventException;
	
	/**
	 * DELETE 처리-전표가 생성되지 않은 경우에만 해당됨<br>
	 * Prepayments 화면에 대한 DELETE 이벤트 처리<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String 
	 * @exception EventException
	 */
	public void removePrepaymentInvoice(String fletCtrtNo, String invSeq) throws EventException;

	/**
	 * Owner Account Expense 변경 작업이다<br>
	 * 변경된 자료를 변경한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void modifyOwnerAccountExpense(CustomCsulSlpVO[] customCsulSlpVOs, String usrid) throws EventException;
	
	/**
	 * ERP AP에서 Owner’s account 관련 비용을 가지고 와서 생성 및 변경한다<br>
	 * 
	 * @param xmlObject XmlObject
	 * @exception DAOException, Exception
	 */
	public void manageOwnerAccountInterface(XmlObject xmlObject) throws EventException;
	
	/**
	 * 대선 수입 채권 발생 시 기존 생성해놓은 Hire 정보 중 당 월 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param currCd String
	 * @param slpOfcCd String
	 * @return List<SearchInvoiceListByRevenueSlipVO>
	 * @exception DAOException, Exception
	 */
	public List<SearchInvoiceListByRevenueSlipVO> searchPrepaymentListByRevenueSlip(String fletCtrtNo, String currCd, String slpOfcCd) throws EventException;
	
	/**
	 * 대선 전표가 생성되면 정산 테이블에 관련 항목들에 대해서 수정한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifySubletRevenueSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException;
	
	/**
	 * VMS에서 용선선박 용선료를 조회한다<br>
	 * 
	 * @param vslCd String
	 * @param effDt String
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselCodeHireInterface(String vslCd, String effDt) throws EventException;
	
	/**
	 * VMS에서 CDAM 정산 데이터를 조회한다<br>
	 * 
	 * @param vslCd String
	 * @param effDt String
	 * @param expDt String
	 * @return String
	 * @exception EventException
	 */
	public List<SearchVesselCodeInvoiceInterfaceVO> searchVesselCodeInvoiceInterface(String vslCd, String effDt, String expDt) throws EventException;

	/**
	 *  Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip(String fletCtrtNo) throws EventException ;
	

	/**
	 *  Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip2(String fletCtrtNo) throws EventException ;
	
	/**
	 * VMS 에서 실시간으로 Offhire Expense 자료가 수신되면 FMS_OFFH_EXPN 테이블에 입력된다<br>
	 * 
	 * @param xmlObject XmlObject
	 * @exception EventException
	 */
	public void manageOffHireExpenseInterface(XmlObject xmlObject) throws EventException;

	/**
	 * 자발적, 비자발적 오류 처리할 전표에 대한 취소 작업 진행한다<br>
	 * 
	 * @param customInterfaceStatusVO CustomInterfaceStatusVO
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyInterfaceStatusInvoice(CustomInterfaceStatusVO customInterfaceStatusVO, String usrId) throws EventException;
	
	/**
	 * Bunker Price 를 Interface 해 온다<br>
	 * 
	 * @param locCd String
	 * @param fromDt String
	 * @param toDt String
	 * @return List<SearchBunkerPriceInterfaceListVO>
	 * @exception EventException
	 */
	public List<SearchBunkerPriceInterfaceListVO> searchBunkerPriceInterfaceList(String locCd, String fromDt, String toDt) throws EventException;
	
	/**
	  * 품의되지 않은 선급금 대상 자료를 조회한다<br>
	  * 
	  * @param fletCtrtNo String
	  * @param ofcCd String
	  * @param csrCurrCd String
	  * @return List<SearchPrepaymentListByPaymentSlipVO>
	  * @exception EventException
	  */
	public List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException;
	
	/**
	 * 용선/대선 전표가 취소 되면 Invoice 에 전표번호가 Null 로 변경된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelInvoice(String csrNo, String usrId) throws EventException;
	
	/**
	 * 용선 전표가 취소 되면 Account Account 에 전표번호가 Null 로 변경된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelOwnerAccount(String csrNo, String usrId) throws EventException;
	
	/**
	  * 품의되지 않은 Charterer's Account 대상 자료를 조회한다<br>
	  * 
	  * @param fletCtrtNo String
	  * @param ofcCd String
	  * @param csrCurrCd String
	  * @return List<SearchCharterListByPaymentSlipVO>
	  * @exception EventException
	  */
	public List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException;
	
	/**
	 * 기 작성된 Offhire Expenses / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchOffhireListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException;
	
	/**
	 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchOwnerListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException;

	/**
	 * 대선 전표가 승인 되면 Invoice 에 IF NO를 업데이트한다<br>
	 * 
	 * @param searchArSlipDetailListVO List<SearchArSlipDetailListVO>
	 * @exception EventException
	 */
	public void modifySlipApprovalInvoice(List<SearchArSlipDetailListVO> searchArSlipDetailListVO) throws EventException;
	
	/**
	 * Manual 전표 생성 시 Broker 관련 Invoice 계정에 수정한다<br>
	 * 
	 * @param customCsulSlpVOs List<CustomCsulSlpVO>
	 * @exception EventException
	 */
	public void modifyManualSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException;
	
	/**
	 * 전표 생성 완료 후 Invoice 테이블을 업데이트한다<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipInvoices(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException;
	
	/**
	 * 전표 생성 완료 후 Owner's Account 테이블을 업데이트한다<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipOwnerAccounts(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException;
	
	/**
	 * 선주 지불 예정 비용 중 하역 실수로 발생한 비용에 대한 지불 처리 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param fromPayDt String
	 * @param toPayDt String
	 * @param appFlg String
	 * @return List<SearchChaterInvoiceSdmsListVO>
	 * @exception EventException
	 */
	public List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsList(String fletCtrtNo, String fromPayDt, String toPayDt, String appFlg) throws EventException;
	
	/**
	 * SDMS INV No. 가져오기(존재/미존재 판단기준)<br>
	 * 
	 * @param invNo String
	 * @return String
	 * @exception EventException
	 */
	public String checkSdmsInvoiceNo(String invNo) throws EventException;
	
	/**
	 * Hire No. 가져오기(존재/미존재 판단기준)<br>
	 * 
	 * @param fletCtrtNo String 
	 * @param hireNo String
	 * @return String
	 * @exception EventException
	 */
	public String searchHireNo(String fletCtrtNo, String hireNo) throws EventException;


	 /**
	 * 선주 대행 비용을 선주 비용 지불 시 차감하기 위해 기 등록된 미수 계정을 비교하여 조회 하는 작업이다<br>
	 * 조건대로 자료를 조회한다<br>
	 * 
	 * @param condSearchOwnerInvoiceVO CondSearchOwnerInvoiceVO
	 * @return List<SearchOwnerInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerInvoiceListVO> searchGlInquiryOwnerInvoiceList(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO) throws EventException ;
		
	
//##############################################################	
//##############################################################	
	/**
	 * Off-Hire Expenses CNFM 정보를 조회한다<br>
	 * 
	 * @param SearchOffhireExpensesListVO vo
	 * @return List<SearchOffhireExpensesListVO>
	 * @throws EventException
	 */
	public List<SearchOffhireExpensesListVO> searchOffhireCnfmList(SearchOffhireExpensesListVO vo) throws EventException;
	
	
	/**
	 * FMS VNOR ITEM을 수정한다.<br>
	 * 
	 * @param searchOffhireExpensesListVOs SearchOffhireExpensesListVO[]
	 * @param usrId String
	 * @param vnorItmProcCd String
	 * @exception EventException
	 */
	public void modifyVnorItm(SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs, String usrId, String vnorItmProcCd) throws EventException;
	
	
	/**
	 * Off-Hire Expenses 정보를 저장한다.<br>
	 * 
	 * @param searchOffhireExpensesListVOs SearchOffhireExpensesListVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOffhireExpenses(SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs, String usrId) throws EventException;		
	
	/**
	 * Off-Hire Expenses 정보에서 FMS VNOR Seq를 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @param vnorOffhFmDt String
	 * @param vnorOffhToDt String
	 * @param crChkFlg String 
	 * @return int
	 * @exception EventException
	 */
	public int searchVnorSeq(String vslCd, String vnorOffhFmDt, String vnorOffhToDt, String crChkFlg) throws EventException;	
	
	
	/**
	 * Off-Hire Expenses 정보에서 FMS VNOR Itm Seq를 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @param vnorOffhFmDt String
	 * @param vnorOffhToDt String 
	 * @param crChkFlg String
	 * @return int
	 * @exception EventException
	 */
	public int searchVnorItmSeq(String vslCd, String vnorOffhFmDt, String vnorOffhToDt, String crChkFlg) throws EventException;
		
	/**
	 * Off-Hire Expenses 정보에서 FMS VNOR를 저장한다.<br>
	 * 
	 * @param fmsVnorVO FmsVnorVO
	 * @exception EventException
	 */
	public void addFmsVnor(FmsVnorVO fmsVnorVO) throws EventException;	
	
	/**
	 * Off-Hire Expenses 정보에서 FMS VNOR ITEM을 저장한다.<br>
	 * 
	 * @param fmsVnorItmVO FmsVnorItmVO
	 * @exception EventException
	 */
	public void addFmsVnorItm(FmsVnorItmVO fmsVnorItmVO) throws EventException;	
	
	/**
	 * Audit Comment를 수정한다.<br>
	 * 
	 * @param searchOffhireExpensesListVOs SearchOffhireExpensesListVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyAuditComment(SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs, String usrId) throws EventException;
	
	/**
	 * Retrieve 조회<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param CondSearchOwnerAccountVO condSearchOwnerAccountVO
	 * @return List<SearchNewOwnerAccountListVO>
	 * @exception EventException
	 */
	public List<SearchNewOwnerAccountListVO> searchNewOwnerAccountList(CondSearchOwnerAccountVO condSearchOwnerAccountVO) throws EventException;
	
	/**
	 * Save 저장<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param searchNewOwnerAccountListVOs SearchNewOwnerAccountListVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageNewOwnerAccount(SearchNewOwnerAccountListVO[] searchNewOwnerAccountListVOs, String usrId) throws EventException;
	
	/**
	 * VVD 체크<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param strVvd String
	 * @return Boolean
	 * @exception EventException
	 */
	public Boolean checkVvdInFmsCntrct(String strVvd) throws EventException;

	/**
	 * FRGN Exchange Transaction(O/A) 정보를 조회한다<br>
	 * 
	 * @param FrgnExchangeTransactionVO vo
	 * @return List<FrgnExchangeTransactionVO>
	 * @throws EventException
	 */
	
	public List<FrgnExchangeTransactionVO> searchFrgnExchangeTransactionList(FrgnExchangeTransactionVO vo) throws EventException;
	
	/**
	 * FRGN Exchange Transaction(O/A) 정보를 저장한다.<br>
	 * 
	 * @param FrgnExchangeTransactionVO frgnExchangeTransactionVO
	 * @param FrgnExchangeVO[] frgnExchangeVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageFrgmExchangeTransaction(FrgnExchangeTransactionVO frgnExchangeTransactionVO, FrgnExchangeVO[] frgnExchangeVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다(Prepayment, Standard)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @param slpTp String
	 * @return List<OwnerAccountByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<OwnerAccountByPaymentSlipVO> searchOwnerAccountListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd, String slpTp) throws EventException;
	
	/**
	 * GL 대사이후 Settle Date 를 update 한다.<br>
	 * 
	 * @param searchOwnerInvoiceListVO SearchOwnerInvoiceListVO[]
	 * @exception EventException
	 */
	public void modifySettleDate(SearchOwnerInvoiceListVO[] searchOwnerInvoiceListVO) throws EventException;
	
}