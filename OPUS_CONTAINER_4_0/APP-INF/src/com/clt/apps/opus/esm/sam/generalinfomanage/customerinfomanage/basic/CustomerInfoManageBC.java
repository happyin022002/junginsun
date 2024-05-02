/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageBC.java
*@FileTitle : Customer List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.23
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.05.23 이관샨
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustCoverTeamVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.MoreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustHistVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustPreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchKeyManVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerCodeGroupingVO;	// 0010 SHKIM
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustomerGroupCodeVO;		// 0903 SHKIM
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCustAddrVO;

/**
 * ALPS-Generalinfomanage Business Logic Command Interface<br>
 * - ALPS-Generalinfomanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author LEEKUANSIAN
 * @see CustomerInfoManageBC
 * @since J2EE 1.6
 */

public interface CustomerInfoManageBC {
	/**
	 * ESM_SAM_0001 : Retrieve<br>
	 * 
	 * @param SearchCustomerVO 	searchCustomerVO 
	 * @return List<SearchCustomerVO >
	 * @exception EventException
	 */
	public List<SearchCustomerVO > searchCustomerList(SearchCustomerVO  searchCustomerVO ) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Basic Info
	 * @param SearchCustomerVO 	searchCustomerVO 
	 * @return List<SearchCustomerVO >
	 * @exception EventException
	 */
	public List<SearchCustomerVO > searchCustomerInfo(SearchCustomerVO  searchCustomerVO ) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * KeyMan
	 * @param String customerCode 
	 * @return List<SearchKeyManVO >
	 * @exception EventException
	 */
	public List<SearchKeyManVO > searchKeyManList(String customerCode) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Address
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<MdmCustAddrVO >
	 * @exception EventException
	 */
	public List<MdmCustAddrVO > searchAddressList(SearchCustomerVO  searchCustomerVO ) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Preference&Needs
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<SamCustPreInfoVO >
	 * @exception EventException
	 */
	public List<SamCustPreInfoVO > searchCustomerPreferenceInfo(SearchCustomerVO  searchCustomerVO ) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Coverage Team
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<CustCoverTeamVO >
	 * @exception EventException
	 */
	public List<CustCoverTeamVO > searchCustCoverList(SearchCustomerVO  searchCustomerVO ) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Activity
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<SamActivityInfoVO >
	 * @exception EventException
	 */
	public List<SamActivityInfoVO > searchCustActvityList(SearchCustomerVO  searchCustomerVO ) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * More Info
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<MoreInfoVO >
	 * @exception EventException
	 */
	public List<MoreInfoVO > searchMoreInfo(SearchCustomerVO  searchCustomerVO ) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * History
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<SamCustHistVO >
	 * @exception EventException
	 */
	public List<SamCustHistVO > searchCustHistList(SearchCustomerVO  searchCustomerVO ) throws EventException;
	
	/**
	 * ESM_SAM_0010 : Retrieve<br>
	 * History
	 * @param SearchCustomerCodeGroupingVO  searchCustomerCodeGroupingVO
	 * @return List<SearchCustomerCodeGroupingVO>
	 * @exception EventException
	 */
	public List<SearchCustomerCodeGroupingVO> searchCustomerCodeGrouping(SearchCustomerCodeGroupingVO  searchCustomerCodeGroupingVO ) throws EventException;
	
	/**
	 * ESM_SAM_0903 : Retrieve<br>
	 * History
	 * @param CustomerGroupCodeVO  customerGroupCodeVO
	 * @return List<CustomerGroupCodeVO>
	 * @exception EventException
	 */
	public List<CustomerGroupCodeVO> searchCustomerGroupCode(CustomerGroupCodeVO  customerGroupCodeVO ) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * History
	 * @param SearchCustomerVO  searchCustomerVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String checkPermission(SearchCustomerVO  searchCustomerVO , SignOnUserAccount account) throws EventException;
	
//	/**
//	 * ESM_SAM_0002 : Save<br>
//	 * Basic Info
//	 * @param SearchCustomerVO[] searchCustomerVOS, SignOnUserAccount account
//	 * @return void
//	 * @exception EventException
//	 * 
//	 */
//	
//	public void modifyCustomerInfo(SearchCustomerVO[] searchCustomerVOS, SignOnUserAccount account) throws EventException;
//	
//	/**
//	 * ESM_SAM_0002 : Save<br>
//	 * Address
//	 * @param MdmCustAddrVO[] mdmCustAddrVOS, SignOnUserAccount account
//	 * @return void
//	 * @exception EventException
//	 * 
//	 */
//	
//	public void manageCustomerAddressInfo(MdmCustAddrVO[] mdmCustAddrVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Preference&Needs
	 * @param SamCustPreInfoVO[] samCustPreInfoVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	
	public void manageCustomerPreferenceInfo(SamCustPreInfoVO[] samCustPreInfoVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Coverage Team
	 * @param CustCoverTeamVO[] custCoverTeamVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	
	public void manageCustCoverInfo(CustCoverTeamVO[] custCoverTeamVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * More info
	 * @param MoreInfoVO[] moreInfoVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	
	public void manageMoreInfo(MoreInfoVO[] moreInfoVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * History 
	 * @param SamCustHistVO samCustHistVO
	 * @param SignOnUserAccount account
	 * @param List<SearchCustomerVO> oldList
	 * @param List<SearchCustomerVO> newList
	 * @exception EventException
	 * 
	 */
	public void manageCustHistList(SamCustHistVO samCustHistVO, SignOnUserAccount account, List<SearchCustomerVO> oldList, List<SearchCustomerVO> newList) throws EventException;
	/**
	 * ESM_SAM_0004 : Retrive
	 * History 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return void
	 * @exception EventException
	 * 
	 */
	public List<SearchCustomerVO > searchCustomerPFMCGroupDetail(SearchCustomerVO  searchCustomerVO ) throws EventException;
	/**
	 * ESM_SAM_0004 : On_change<br> ESM_SAM_0902(0215 SHKIM ADD)
	 * History 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return void
	 * @exception EventException
	 * 
	 */
	public String searchGroupCustomerName(SearchCustomerVO searchCustomerVO)throws EventException;
	
	/**
	 * BCM_CCD_0035 : manage<br>
	 * Check Sales Rep Code 
	 * @param String custCd
	 * @param String srepCd
	 * @return  String
	 * @exception EventException
	 * 
	 */
	public String checkSalesRepCode(String custCd, String srepCd)throws EventException;

	/**
	 * BCM_CCD_0035 : manage<br>
	 * Manage Sales Rep Info 
	 * @param MdmCustomerVO[] mdmCustomerVOS
	 * @param String checkSalesRepCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	public void manageSalesRepInfo(MdmCustomerVO[] mdmCustomerVOS, String checkSalesRepCd, SignOnUserAccount account)throws EventException;

	/**
	 * ESM_SAM_0011 : Retrieve<br>
	 * Group Code에 해당하는 Customer Detail 정보를 조회합니다.<br>
	 * 
	 * @param CustomerGroupCodeVO customerGroupCodeVO
	 * @return List<CustomerGroupCodeVO>
	 * @exception EventException
	 */	
	public List<CustomerGroupCodeVO> searchCustomerGroupCodeDetail(CustomerGroupCodeVO customerGroupCodeVO)throws EventException;

	/**
	 * ESM_SAM_0001 : Save<br>
	 * Sales Rep Adjustment
	 * @param SearchCustomerVO[] searchCustomerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */	
	public void manageSalesRepAdjustment(SearchCustomerVO[] searchCustomerVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0001 : SAVE<br>
	 * 해당 Customer에 Primary Sales Rep이 있는지 확인.<br><br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return String
	 * @exception EventException
	 */
	public String checkPrmrySalesRep(SearchCustomerVO searchCustomerVO) throws EventException;
}