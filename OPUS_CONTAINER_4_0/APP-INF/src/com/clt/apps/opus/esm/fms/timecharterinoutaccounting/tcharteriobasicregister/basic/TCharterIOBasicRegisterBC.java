/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterBC.java
*@FileTitle : searchAccountItemList
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic;

import java.util.Collection;
import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctCateVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctItmVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomBsePortVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomEmailAddressVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchAccountItemListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchEmailAddressListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinalRevenueVvdListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinanVvdListByChaterSdmsVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchOwnerNameListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenuePortListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdInquiryListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVvdCreationListVO;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutaccounting Biz Logic Interface<br>
 *
 * @author 
 * @see Esm_Fms_0076EventResponse 
 * @since J2EE 1.5
 */

public interface TCharterIOBasicRegisterBC { 
	/**
	 * Account Item list Pop-up(Retrieving Account Item information)<br>
	 * 
	 * @param fletAcctCateCd String
	 * @return List<SearchAccountItemListVO>
	 * @exception EventException
	 */
	public List<SearchAccountItemListVO> searchAccountItemList(String fletAcctCateCd) throws EventException;
	
	/**
	 * Retrieving FMS Owner <br>
	 * 
	 * @return List<CustomOwnerVO>
	 * @exception EventException
	 */
	public List<CustomOwnerVO> searchOwnerList() throws EventException ;

	/**
	 * Saving FMS Owner<br>
	 * 
	 * @param customOwnerVOs CustomOwnerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOwner(CustomOwnerVO[] customOwnerVOs, String usrId) throws EventException;
	
	/**
	 * Getting Currency Code (Criteria of Existing/Not Existing)<br>
	 * 
	 * @param currency String
	 * @return String
	 * @exception EventException
	 */
	public String checkCurrencyCode(String currency) throws EventException;

	/**
	 * Getting Vendor Code List <br>
	 * 
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCodeList() throws EventException ;

	/**
	 * Saving each Vendor's Owner information<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageVendorCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException;

	/**
	 * Retrieving Owner information of each Customer<br>
	 * 
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchCustomerCodeList() throws EventException ;

	/**
	 * Saving Owner information of each Customer<br>
	 * 
	 * @param searchVendorCustomerVOs SearchVendorCustomerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCustomerCode(SearchVendorCustomerVO[] searchVendorCustomerVOs, String usrId) throws EventException;
	
	/**
	 * Retrieving Vendor/Customer information through Popup window<br>
	 * 
	 * @param String agmtFlag
	 * @param String condFlag
	 * @param String vendorCustomerName
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCustomerList(String agmtFlag, String condFlag, String vendorCustomerName) throws EventException ;

	/**
	 * Retrieving FMS Owner Pop-up<br>
	 * 
	 * @return List<SearchOwnerNameListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerNameListVO> searchOwnerNameList() throws EventException ;

	/**
	 * Retrieving Vendor/Customer Name information<br>
	 * 
	 * @param String condFlag
	 * @param String cdCnt
	 * @param String cdSeq
	 * @return List<SearchVendorCustomerVO>
	 * @exception EventException
	 */
	public List<SearchVendorCustomerVO> searchVendorCustomerName(String condFlag, String cdCnt, String cdSeq) throws EventException ;
	
	/**
	 * Getting Common Code using in Combo Box<br>
	 * 
	 * @param cdId String[]
	 * @param sortKey int[]
	 * @return codeInfoList List<Collection<CodeInfo>>
	 * @exception EventException
	 */
	public List<Collection<CodeInfo>> getStandardCommonCode(String[] cdId, int[] sortKey) throws EventException ;

	/**
	 * Retrieving Item Management<br>
	 * 
	 * @return List<CustomAcctItmVO>
	 * @exception EventException
	 */
	public List<CustomAcctItmVO> searchAccountItemDetailList() throws EventException ;

	/**
	 * Saving Item Management<br>
	 * 
	 * @param customAcctItmVOs CustomAcctItmVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageAccountItemName(CustomAcctItmVO[] customAcctItmVOs, String usrId) throws EventException;

	/**
	 * Getting Account Code information relevant to inserted Account code at Item Detail Management<br>
	 * 
	 * @param customAcctItmVO CustomAcctItmVO
	 * @return List<CustomAcctItmVO>
	 * @exception EventException
	 */
	public List<CustomAcctItmVO> checkAccountCode(CustomAcctItmVO customAcctItmVO) throws EventException ;

	/**
	 *  Retrieving Account Category<br>
	 * 
	 * @return List<CustomAcctCateVO>
	 * @exception EventException
	 */
	public List<CustomAcctCateVO> searchAccountCateList() throws EventException ;

	/**
	 * Saving Account Category<br>
	 * 
	 * @param customAcctCateVOs CustomAcctCateVO[]
	 * @param usrId String
	 * @exception EventException 
	 */
	public void manageAccountCate(CustomAcctCateVO[] customAcctCateVOs, String usrId) throws EventException;

	/**
	 * Getting VVD information on Revenue VVD Creation window<br>
	 * 
	 * @param revYrmon String
	 * @param slanCd String
	 * @param rlaneCd String
	 * @return List<SearchRevenueVvdListVO>
	 * @exception EventException
	 */
	public List<SearchRevenueVvdListVO> searchRevenueVvdList(String revYrmon, String slanCd, String rlaneCd) throws EventException ;

	/**
	 * Generating Revenue VVD <br>
	 * 
	 * @param customVvdVOs CustomVvdVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageRevenueVvd(CustomVvdVO[] customVvdVOs, String usrId) throws EventException;

	/**
	 * Retrieving Final Revenue Vvd List <br>
	 * 
	 * @param revYrmon String
	 * @param slanCe String
	 * @return List<SearchFinalRevenueVvdListVO>
	 * @exception EventException
	 */
	public List<SearchFinalRevenueVvdListVO> searchFinalRevenueVvdList(String revYrmon, String slanCe) throws EventException ;

	/**
	 * Retrieving Revenue VVD Creation information<br>
	 * 
	 * @param revYrmon String
	 * @param slanCd String
	 * @return List<SearchVvdCreationListVO>
	 * @exception EventException
	 */
	public List<SearchVvdCreationListVO> searchVvdCreationList(String revYrmon, String slanCd) throws EventException ;

	/**
	 * Retrieving Revenue Vvd Inquiry List<br>
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
	 * Retrieving created Revenue Port related to Charter/Hire Out Vessel<br>
	 * 
	 * @param slanCd String
	 * @param rLaneCd String
	 * @return List<SearchRevenuePortListVO>
	 * @exception EventException
	 */
	public List<SearchRevenuePortListVO> searchRevenuePortList(String slanCd, String rLaneCd) throws EventException;
	
	/**
	 * Deleting all Revenue Port<br>
	 * 
	 * @exception EventException
	 */
	public void removeAllRevenuePort() throws EventException;
	
	/**
	 * Saving Revenue Port<br>
	 * 
	 * @param customBsePortVOs CustomBsePortVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageRevenuePort(CustomBsePortVO[] customBsePortVOs, String usrId) throws EventException;

	/**
	 * Retrieving E-mail Address<br>
	 * 
	 * @return List<SearchEmailAddressListVO>
	 * @exception EventException
	 */
	public List<SearchEmailAddressListVO> searchEmailAddressList() throws EventException;
	
	/**
	 * Managing E-Mail Address<br>
	 * 
	 * @param customEmailAddressVOs CustomEmailAddressVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageEmailAddress(CustomEmailAddressVO[] customEmailAddressVOs, String usrId) throws EventException;
	
	/**
	 * Getting SDMS FinanVvdList<br>
	 * 
	 * @param vslCd String
	 * @param direction String
	 * @param revYrmon String
	 * @return List<SearchFinanVvdListByChaterSdmsVO>
	 * @exception EventException
	 */
	public List<SearchFinanVvdListByChaterSdmsVO> searchFinanVvdListByChaterSdms(String vslCd, String direction, String revYrmon) throws EventException;
	
}