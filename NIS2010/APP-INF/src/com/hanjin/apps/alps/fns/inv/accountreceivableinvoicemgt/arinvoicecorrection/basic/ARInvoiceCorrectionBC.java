/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionBC.java
*@FileTitle : Invoice Split Before Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2011.05.02 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceListByVesselMultiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ChangeCustomerInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DirectBillingInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArEuCntVatVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvByVVDVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvIssAtchVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvissAtchInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MDMCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MarkingReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.UnmatchRevenueVesselVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ALPS-Accountreceivableinvoicemgt Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author saeil kim
 * @see Fns_inv_0018EventResponse 참조
 * @since J2EE 1.4
 */

public interface ARInvoiceCorrectionBC {
	
	/**
	 * VVD 별로 Invoice 의 Item 들을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param InvByVVDVO invByVVDVO
	 * @return ARInvoiceListByVesselMultiVO
	 * @exception EventException 
	 */
	public ARInvoiceListByVesselMultiVO searchARInvoiceListByVVD(InvByVVDVO invByVVDVO) throws EventException;
	
	/**
	 * OTS Summary Code 조회<br>
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchOTSSummary(String ofcCd) throws EventException;
	
	
	/**
	 * FNS_INV_0016 : Item Correction 조회
	 * @author saeil
	 * @param String ofcCd 
	 * @param String blNo 
	 * @param String invNo
	 * @param String otsSmryCd
	 * @return ARInvoiceCorrectionVO
	 * @exception EventException
	 */
	public ARInvoiceCorrectionVO searchARInvoiceByBL(String ofcCd , String blNo , String invNo, String otsSmryCd) throws EventException;
	
	
	
	/**
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094<br>
	 * Due Date 조회 이벤트 처리<br>
	 * @author saeil
	 * @param DueDateInputVO dueInputVo
	 * @return List <DueDateVO>
	 * @exception EventException
	 * 
	 */
	public List<DueDateVO> searchDueDate(DueDateInputVO dueInputVo) throws EventException;
	
	/**
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094 <br>
	 * effectiveDt,zoneIoc,RevType 조회
	 * @author saeil
	 * @param ARCorrectionCkVO arCorrectionCkVO
	 * @return ARCorrectionCkReturnVO
	 * @exception EventException
	 * 
	 */
	public ARCorrectionCkReturnVO checkARCorrection(ARCorrectionCkVO arCorrectionCkVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 발송시에 첨부되는 Wording 정보를 조회한다.<br>
	 * option V : VVD/port, C : customer
	 * 
	 * @author JungJin Park
	 * @param InvissAtchInputVO invissAtchInput
	 * @return InvIssAtchVO
	 * @exception EventException 
	 */
	public InvIssAtchVO searchInvoiceWording (InvissAtchInputVO invissAtchInput) throws EventException;

	/**
	 * 등록 이벤트 처리<br>
	 * Invoice 발송시에 첨부되는 Wording 정보를 생성 및 갱신한다.<br>
	 * option V : VVD/port, C : customer
	 * 
	 * @author JungJin Park
	 * @param InvIssAtchVO invWordVo
	 * @param String userId
	 * @param String option
	 * @exception EventException 
	 */
	public void modifyInvoiceWording (InvIssAtchVO invWordVo, String userId, String option) throws EventException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * Invoice 발송시에 첨부되는 Wording 정보를 삭제한다.<br>
	 * option V : VVD/port, C : customer
	 * 
	 * @author JungJin Park
	 * @param InvIssAtchVO invWordVo
	 * @param String option
	 * @exception EventException 
	 */
	public void removeInvoiceWording (InvIssAtchVO invWordVo, String option) throws EventException;
	
	/**
	 * 입력된 Container no가 등록된 장비 존재 여부  확인하고  type size를 가져온다. <br>
	 * 
	 * @param String cntrNo
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerNo (String cntrNo) throws EventException;
	
	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO
	 * @return List <ARInvoiceCustomerVO>
	 * @exception EventException 
	 */
	public List<ARInvoiceCustomerVO> searchARInvoiceListByDate(ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO) throws EventException;
	
	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date 화면 Customer 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String custNm
	 * @param String shprCustCntCd
	 * @param String shprCustSeq
	 * @param String fwdrCustCntCd
	 * @param String fwdrCustSeq
	 * @return List <MDMCustomerVO>
	 * @exception EventException 
	 */
	public List<MDMCustomerVO> searchARCustomerList(String ofcCd, String custNm, String shprCustCntCd, String shprCustSeq, String fwdrCustCntCd, String fwdrCustSeq) throws EventException;
	
	/**
	 * FNS_INV_0094_01 Invoice Customer Change (Single) 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String invNo
	 * @return InvoiceCustomerChangeVO
	 * @exception EventException
	 */
	public InvoiceCustomerChangeVO searchChangeCustomerInvoice(String ofcCd , String invNo) throws EventException;
	
	/**
	 * FNS_INV_0094_01 Invoice Customer Change (Single) RepCustomer 체크 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return int
	 * @exception EventException
	 */
	public int checkRepCustomer ( String actCustCntCd, String actCustSeq ) throws EventException;
	
	/**
	 * FNS_INV_0094_02 Invoice Customer Change (Multi) 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param ChangeCustomerInputVO changeCustomerInputVO
	 * @return InvoiceCustomerChangeVO
	 * @exception EventException
	 */
	public InvoiceCustomerChangeVO searchChangeCustomerInvoiceList(ChangeCustomerInputVO changeCustomerInputVO) throws EventException;
	
	/**
	 * FNS_INV_0043 Invoice Report by Date 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param BillInputVO billInputVO
	 * @return List<DirectBillingInvoiceVO>
	 * @exception EventException
	 */
	public List<DirectBillingInvoiceVO> searchDirectBilling(BillInputVO billInputVO) throws EventException;
	
	/**
	 * FNS_INV_0018 Invoice Split Before Invoice Issue 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ifNo
	 * @param String splitCnt
	 * @param String ofcCd
	 * @return ARInvoiceSplitVO
	 * @exception EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByIFNo(String ifNo,String splitCnt, String ofcCd) throws EventException;
	
	/**
	 * FNS_INV_0033 Invoice Split Before Invoice Issue 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String invNo
	 * @param String splitCnt
	 * @param String ofcCd
	 * @return ARInvoiceSplitVO
	 * @exception EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByInvoiceNo(String invNo,String splitCnt, String ofcCd) throws EventException;
	
	/**
	 * FNS_INV_0028 Invoice 의 Manual Interface 대상 Bkg No, C/A No 를 조회한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param ManualInputVO manualInputVO
	 * @return List<BkgNoCaNoVO>
	 * @exception EventException
	 */
	public List<BkgNoCaNoVO> searchManualInterface(ManualInputVO manualInputVO) throws EventException;
	
	/**
	 * FNS_INV_0079<br>
	 * Booking 과의 Unmatch 난 Revenue VVD 정보들을 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String fromDt
	 * @param String toDt
	 * @param String bkgIfFlg
	 * @return List<UnmatchRevenueVesselVO>
	 * @exception EventException
	 */
	public List<UnmatchRevenueVesselVO> searchUnmatchRevenueVVDListByDate(String fromDt, String toDt, String bkgIfFlg) throws EventException;
	
	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD 환율이 미적용된 B/L 들에 대해 올바른 환율을 적용<br>
	 * 
	 * @author Choi Do Soon
	 * @param ExrateInputVO exrateInputVO
	 * @return List<ExrateTargetMainVO>
	 * @exception EventException
	 */
	public List<ExrateTargetMainVO> searchInvoiceForExrateList(ExrateInputVO exrateInputVO) throws EventException;

	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD Chg 테이블 조회<br>
	 * 
	 * @author Choi Do Soon
	 * @param String arIfNo
	 * @return List<ExrateTargetChgVO>
	 * @exception EventException
	 */
	public List<ExrateTargetChgVO> searchInvoiceChgForExrateList(String arIfNo) throws EventException;
	
	/**
  	 * FNS_INV_0017 Customer 변경대상 arIFno 리스트를 BLno 로 조회<br>
  	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String ifNo
	 * @return List<InvArMnVO>
	 * @exception EventException
	 */
	public List<InvArMnVO> searchARInvoiceMainList ( String ofcCd, String blNo , String ifNo) throws EventException;
	
	/**
	 * FNS_INV_0027 BL 별 Max IfNo 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String invNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxInterfaceForExrate ( String ofcCd , String blNo, String invNo) throws EventException ;
	
	/**
	 * FNS_INV_0079<br>
	 * Unmatch Revenue VVD 정보에 BKG Interface 처리여부를 update 한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String bkgNo
	 * @exception EventException
	 */
	public void modifyBKGInterfaceFlag(String bkgNo) throws EventException;
	
	/**
	 * Rev Type,Rev Src 조회한다<br>
	 * 
	 * @param String bkgNo
	 * @param String invCustFlg
	 * @return ARCorrectionCkReturnVO
	 * @exception EventException
	 * 
	 */
	public ARCorrectionCkReturnVO searchRevTypeSrc(String bkgNo, String invCustFlg) throws EventException ;
	
	/**
	 * FNS_INV_0027 iFNo 로 Inv No 조회 <br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvoiceNoByIfNo ( String arIfNo ) throws EventException ;
	
	/**
	 * FNS_INV_0079 run 실행 <br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @param String usrId
	 * @exception DAOException
	 */
	public void createUnmatchRevenueVVDListByDate(String fromDt, String toDt, String usrId) throws EventException ;
	
	/**
	 * BKG_BOOKING 에서 VVD로 BKGNO 구해옴 <br>
	 * 
	 * @param String vvd
	 * @param String pol
	 * @param String pod
	 * @return String List<ARBkgInterfaceCreationVO>
	 * @exception DAOException
	 */
	public List<ARBkgInterfaceCreationVO> searchBkgNoByVvd ( String vvd, String pol, String pod )  throws EventException ;
	
	/**
	 * 국가별 VAT 요율을 조회<br>
	 * 
	 * @return List<InvArEuCntVatVO>
	 * @exception EventException
	 */		
	public List<InvArEuCntVatVO> searchVatRatioEntryList() throws EventException ;
	
	/**
	 * 국가별 VAT 요율을 등록, 수정, 삭제한다.<br>
	 * 
	 * @param InvArEuCntVatVO[] invArEuCntVatVOs
	 * @param userId
	 * @exception EventException
	 */
	public void manageVatRatioEntry(InvArEuCntVatVO[] invArEuCntVatVOs, String userId) throws EventException ;
	
	
	/**
	 * MDM_COUNTRY에서 EURO Country List를 가져온다.<br>
	 * 
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchEuroCountryList() throws EventException ;
	
	/**
	 * B/L No. 와 Ofc CD로 Reverse Charge 조회<br>
	 * 
	 * @param String blSrcNo
	 * @param String arOfcCd
	 * @return String List<MarkingReverseChargeVO>
	 * @exception DAOException
	 */
	public List<MarkingReverseChargeVO> searchMarkingReverseChargeByIfNo(String blSrcNo, String arOfcCd)  throws EventException ;
	
	
	/**
	 * Customer Correction 시 BL No의 Max If NO인지 체크 이벤트 처리<br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @param String arIfNo
	 * @return int
	 * @exception EventException
	 */
	public int checkMaxIfNo ( String arOfcCd, String blSrcNo, String arIfNo ) throws EventException;
	
	
	/**
	 * Split 시 If No 의 Split 가능여부 체크 이벤트 처리<br>
	 * 
	 * @param String ifNo
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkSplitARInvoiceByIFNo ( String ifNo, String ofcCd ) throws EventException;
	
	
	/**
	 * Invoice Item Correction시 CHG의 금액의 합의 체크 이벤트 처리<br>
	 * 
	 * @param String blNo
	 * @param String ofcCd
	 * @return boolean
	 * @exception EventException
	 */	
	public boolean checkChgAmount (String blNo, String ofcCd) throws EventException;
	
	
	/**
	 * @param blSrcNo
	 * @param bkgNo
	 * @param splitCnt
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByBL(String blSrcNo, String bkgNo, String splitCnt, String ofcCd) throws EventException;

	/**
	 * Max interface no 값을 리턴.
	 * 
	 * @param blSrcNo
	 * @param arOfcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchMaxInterfaceNoByBL(String blSrcNo, String arOfcCd) throws EventException;
	
	/**
	 * DOD 건수 값을 리턴.
	 * 
	 * @param ofcCd
	 * @param invNo
	 * @return String
	 * @throws EventException
	 */
	public String searchDODCount(String ofcCd, String invNo) throws EventException;
	
	/**
	 * 인도지역 Tax Invoice 발행여부 체크<br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @return int
	 * @exception EventException
	 */
	public int checkTaxInvoice ( String arOfcCd, String blSrcNo) throws EventException;
}