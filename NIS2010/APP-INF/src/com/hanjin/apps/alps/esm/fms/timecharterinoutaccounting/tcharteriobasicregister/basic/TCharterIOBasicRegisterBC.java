/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterBC.java
*@FileTitle : searchAccountItemList
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.01
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.01 정윤태
* 1.0 Creation
* --------------------------------------------------------------
* History
* 2011.01.19 이준범 [CHM-201108373-01] Revenuse VVD Creation 관련
* 작업내용 : 1) ERP Target VVD 선정 I/F 시 FMS에 임의로 생성된 VVD 삭제
*          2) manageRevenueVvd() 파라미터 추가 String finalizingFlg
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic;

import java.util.Collection;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctCateVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomBsePortVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomEmailAddressVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.ReceiveRevenuePortVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchAccountItemListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchEmailAddressListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinalRevenueVvdListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinanVvdListByChaterSdmsVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchOwnerNameListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenuePortListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdInquiryListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVvdCreationListVO;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - ALPS-Timecharterinoutaccounting에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon-Tae, Jung
 * @see Esm_Fms_0076EventResponse 참조
 * @since J2EE 1.5 
 */

public interface TCharterIOBasicRegisterBC { 
	/**
	 * Account Item 정보를 가져온다<br>
	 * 
	 * @param fletAcctCateCd String
	 * @param acctItmNm String
	 * @return List<SearchAccountItemListVO>
	 * @exception EventException
	 */
	public List<SearchAccountItemListVO> searchAccountItemList(String fletAcctCateCd, String acctItmNm) throws EventException;
	
	/**
	 *  Owner List 정보를 가져온다<br>
	 * 
	 * @return List<CustomOwnerVO>
	 * @exception EventException
	 */
	public List<CustomOwnerVO> searchOwnerList() throws EventException ;

	/**
	 * Owner 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param customOwnerVOs CustomOwnerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOwner(CustomOwnerVO[] customOwnerVOs, String usrId) throws EventException;
	
	/**
	 * Currency Code 가져오기(존재/미존재 판단기준)<br>
	 * 
	 * @param currency String
	 * @return String
	 * @exception EventException
	 */
	public String checkCurrencyCode(String currency) throws EventException;

	/**
	 *  Vendor Code 정보를 가져온다<br>
	 * 
	 * @return List<SearchVendorCustomVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCodeList() throws EventException ;

	/**
	 * Vendor Code를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageVendorCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException;

	/**
	 * Customer Code 정보를 가져온다<br>
	 * 
	 * @return List<SearchVendorCustomVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchCustomerCodeList() throws EventException ;

	/**
	 * Customer Code 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCustomerCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException;
	
	/**
	 * Vendor/Customer 정보를 Popup을 이용하여 가져온다<br>
	 * 
	 * @param String agmtFlag
	 * @param String condFlag
	 * @param String vendorCustomerName
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCustomerList(String agmtFlag, String condFlag, String vendorCustomerName) throws EventException ;

	/**
	 * Owner Name 정보를 Popup을 이용하여 가져온다<br>
	 * 
	 * @return List<SearchOwnerNameListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerNameListVO> searchOwnerNameList() throws EventException ;

	/**
	 *  Vendor/Customer Name 정보를 가져온다<br>
	 * 
	 * @param String condFlag
	 * @param String cdCnt
	 * @param String cdSeq
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCustomerName(String condFlag, String cdCnt, String cdSeq) throws EventException ;
	
	/**
	 * Combo Box에 해당하는 공통 코드 정보를 가져온다<br>
	 * 
	 * @param cdId String[]
	 * @param sortKey int[]
	 * @return List<Collection<CodeInfo>>
	 * @exception EventException
	 */
	public List<Collection<CodeInfo>> getStandardCommonCode(String[] cdId, int[] sortKey) throws EventException ;

	/**
	 * Account Item 상세 정보를 가져온다<br>
	 * 
	 * @return List<CustomAcctItmVO>
	 * @exception EventException
	 */
	public List<CustomAcctItmVO> searchAccountItemDetailList() throws EventException ;

	/**
	 * Account Item정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param customAcctItmVOs CustomAcctItmVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageAccountItemName(CustomAcctItmVO[] customAcctItmVOs, String usrId) throws EventException;

	/**
	 * Item Detail Management에서 Account Code 입력시 해당 코드값을 가져온다<br>
	 * 
	 * @param acctCd String
	 * @return List<CustomAcctItmVO>
	 * @exception EventException
	 */
	public List<CustomAcctItmVO> checkAccountCode(String acctCd) throws EventException ;

	/**
	 * Account Code 를 조회한다<br>
	 * 
	 * @return List<CustomAcctCateVO>
	 * @exception EventException
	 */
	public List<CustomAcctCateVO> searchAccountCateList() throws EventException ;

	/**
	 * Account Code를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param customAcctCateVOs CustomAcctCateVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageAccountCate(CustomAcctCateVO[] customAcctCateVOs, String usrId) throws EventException;

	/**
	 * Revenue VVD Creation 화면에서 Vvd 정보를 가져온다<br>
	 * 
	 * @param revYrmon String
	 * @param slanCd String
	 * @param rlaneCd String
	 * @return List<SearchRevenueVvdListVO>
	 * @exception EventException
	 */
	public List<SearchRevenueVvdListVO> searchRevenueVvdList(String revYrmon, String slanCd, String rlaneCd) throws EventException ;

	/**
	 * Revenue VVD 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param customVvdVOs CustomVvdVO[]
	 * @param usrId String
	 * @param String finalizingFlg
	 * @exception EventException
	 */
	public void manageRevenueVvd(CustomVvdVO[] customVvdVOs, String usrId, String finalizingFlg) throws EventException;

	/**
	 * Revenue VVD Creation 화면에서 revYrmon에 해당하는 Vvd정보를 가져온다<br>
	 * 
	 * @param revYrmon String
	 * @return List<SearchFinalRevenueVvdListVO>
	 * @exception EventException
	 */
	public List<SearchFinalRevenueVvdListVO> searchFinalRevenueVvdList(String revYrmon) throws EventException ;

	/**
	 * Revenue VVD Creation 화면에서 revYrmon에 해당하는 Vvd정보를 가져온다<br>
	 * 
	 * @param revYrmon String
	 * @return List<SearchFinalRevenueVvdListVO>
	 * @exception EventException
	 */
	public List<SearchFinalRevenueVvdListVO> searchProcessRevenueVvdList(String revYrmon) throws EventException ;

	
	/**
	 * Vvd Creation 정보를 가져온다<br>
	 * 
	 * @param revYrmon String
	 * @return List<SearchVvdCreationListVO>
	 * @exception EventException
	 */
	public List<SearchVvdCreationListVO> searchVvdCreationList(String revYrmon) throws EventException ;

	/**
	 * Revenue VVD Inquiry 정보를 가져온다<br>
	 * 
	 * @param revYrmonFrom String
	 * @param revYrmonTo String
	 * @param slanCd String
	 * @param rlaneCd String
	 * @return List<SearchRevenueVvdInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchRevenueVvdInquiryListVO> searchRevenueVvdInquiryList(String revYrmonFrom, String revYrmonTo, String slanCd, String rlaneCd) throws EventException  ;

	/**
	 * 용/대선 선박 관련 Created된 Revenue Port를 조회<br>
	 * 
	 * @param slanCd String
	 * @param rlaneCd String
	 * @return List<SearchRevenuePortListVO>
	 * @exception EventException
	 */
	public List<SearchRevenuePortListVO> searchRevenuePortList(String slanCd, String rLaneCd) throws EventException;
	
	/**
	 * 전체삭제 처리<br>
	 * Revenue Port를 전체 삭제한다<br>
	 * 
	 * @exception EventException
	 */
	public void removeAllRevenuePort() throws EventException;
	
	/**
	 * 전체삭제 처리<br>
	 * Revenue Port를 변경한다<br>
	 * 
	 * @param customBsePortVOs CustomBsePortVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageRevenuePort(CustomBsePortVO[] customBsePortVOs, String usrId) throws EventException;

	/**
	 * Revenue Port 자료를 ERP에서 가지고 온다<br>
	 * 
	 * @return List<ReceiveRevenuePortVO>
	 * @exception EventException
	 */
	public List<ReceiveRevenuePortVO> receiveRevenuePort() throws EventException;

	/**
	 * E-mail Address 자료 조회한다<br>
	 * 
	 * @return List<SearchEmailAddressListVO>
	 * @exception EventException
	 */
	public List<SearchEmailAddressListVO> searchEmailAddressList() throws EventException;
	
	/**
	 * E-Mail Address 자료를 변경한다<br>
	 * 
	 * @param customEmailAddressVOs CustomEmailAddressVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageEmailAddress(CustomEmailAddressVO[] customEmailAddressVOs, String usrId) throws EventException;
	
	/**
	 * SDMS FinanVvdList 가져오기<br>
	 * 
	 * @param vslCd String
	 * @param direction String
	 * @param revYrmon String
	 * @return List<SearchFinanVvdListByChaterSdmsVO>
	 * @exception EventException
	 */
	public List<SearchFinanVvdListByChaterSdmsVO> searchFinanVvdListByChaterSdms(String vslCd, String direction, String revYrmon) throws EventException;
	
}