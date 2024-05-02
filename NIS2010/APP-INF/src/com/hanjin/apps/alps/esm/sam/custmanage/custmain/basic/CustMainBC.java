/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustMainBC.java
*@FileTitle : customer main 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.basic;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.BkgSalesRepVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerContactVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerIntegrationVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.MdmCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Common code Business Logic Command Interface<br>
 * An interface to the business logic for Common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface CustMainBC {
	
	/**
	 * Customer List 조회<br>
	 * @param String custCd 
	 * @param String custNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String include
	 * @param String cust
	 * @param String zipCd
	 * @return List<SearchCustomerVO>
	 * @throws EventException
	 */
	public List<SearchCustomerVO> searchCustomerList(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String zipCd, String custGrpId, String locCd, String steCd,  String srepCd, String deltFlg) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Coverage Team
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<CustCoverTeamVO >
	 * @exception EventException
	 */
	public List<CustCoverTeamVO > searchCustCoverList(String custCntCd, String custSeq ) throws EventException;
	
	/**
	 * Customer 정보를 EAI로 전송한다. <BR>
	 * @param String eaiIfTp
	 * @param String eaiIfMsg
	 * @param CustomerVO customerVo
	 */
	public void sendCustomerToMdm(String custCntCd, String custSeq, String usrId, String creFlag) throws EventException;
	
	
	/**
	 * multi event process<br>
	 * Customer Address  multi event process(ESM_SAM_0302)<br>
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustAddrCode(CustomerAddressVO[] custAddrVOs,SignOnUserAccount account) throws EventException;
	

	
	/**
    * save MDM Customer data for Customer Code Validation
	 * @param List<MdmCustomerVO> mdmCustomerVOs
	 * @return boolean
	 * @exception EventException
	 */
	public boolean mergeBkgCustCdVal(List<MdmCustomerVO> mdmCustomerVOs)throws EventException;
	
	/**
	    * save MDM Customer data for Customer Code Validation
		 * @param List<MdmCustomerVO> mdmCustomerVOs
		 * @return boolean
		 * @exception EventException
		 */
	public boolean mergeMdmCustSezCerti(CustomerVO customerVo)throws EventException;
	
	
	/**
	 * SalesRep info save/modify.<br>
	 * 
	 * @param BkgSalesRepVO[] bkgSalesRepVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesRep(BkgSalesRepVO[] bkgSalesRepVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0302 : manage<br>
	 * Check Sales Rep Code 
	 * @param String custCd
	 * @param String srepCd
	 * @return  String
	 * @exception EventException
	 * 
	 */
	public String checkSalesRepCode(String custCd, String srepCd)throws EventException;
	
	/**
	 * ESM_SAM_0302 : manage<br>
	 * Check Contact point 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return  String
	 * @exception EventException
	 * 
	 */
	public String checkCntcPnt(String custCntCd, String custSeq)throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Code Creation  multi event process(ESM_SAM_0302)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public CustomerVO manageCustCode(CustomerIntegrationVO custIntgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Code Creation  multi event process(ESM_SAM_0302)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public CustomerVO manageGstCustCode(CustomerIntegrationVO custIntgVO, SignOnUserAccount account) throws EventException;

	/**
     * function : return default combo,ibsheet codelist<p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * @throws EventException
     */
	public GeneralEventResponse searchCommonCodeList(GeneralEventResponse eventResponse,String[][] array) throws EventException ;
	
	/**
	 * Customer Code retrieve.(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchCustCode(String custCntCd, String custSeq) throws EventException;
	
	
	/**
	 * Customer Code retrieve.(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String usrId
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public void addCustHist(String custCntCd, String custSeq, String usrId) throws EventException;
	
	/**
	 * India Location State Code retrieve.(ESM_SAM_0302)<br>
	 * 
	 * @param String locCd
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchLocSteCode(String locCd) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Address  multi event process(ESM_SAM_0302)<br>
	 * 
	 * @param CustomerContactVO[] customerContractVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCntcCode(CustomerContactVO[] customerContractVOs, SignOnUserAccount account, String creFlag) throws EventException;
	
	/**
	 * Customer Address retrieve.(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String addrTpCd
	 * @return List<CustomerAddressVO>
	 * @exception EventException
	 */
	public List<CustomerAddressVO>  searchCustAddr(String custCntCd, String custSeq, String addrTpCd) throws EventException;
	
	/**
	 * Customer History(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<BlHistVO>
	 * @exception EventException
	 */
	public List<BlHistVO>  searchCustHist(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * Trade Code checking.<br>
	 * 
	 * @param String trdCd
	 * @return String
	 * @exception EventException
	 */
	public String checkTrdCode (String trdCd) throws EventException;
	
	/**
	 * Country Code checking.<br>
	 * 
	 * @param String cntCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCntCode(String cntCd) throws EventException;
	
	/**
	 * International No checking.<br>
	 * 
	 * @param String intlNo
	 * @return String
	 * @exception EventException
	 */
	public String checkIntlNo(String intlNo) throws EventException;
	
	/**
	 * Location Code checking.<br>
	 * 
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCode(String locCd) throws EventException;
	
	/**
	 * Office Code checking.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkOfcCode(String ofcCd) throws EventException;
	
	/**
	 * Vender Code checking.<br>
	 * 
	 * @param String vndrCd
	 * @return String
	 * @exception EventException
	 */
	public String checkVndrCode(String vndrCd) throws EventException;
	
	/**
	 * Currency Code checking.<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCurrCode(String currCd) throws EventException;
	
	/**
	 * Group Customer Code checking.<br>
	 * 
	 * @param String grpCustCd
	 * @return String
	 * @exception EventException
	 */
	public String checkGrpCustCode(String grpCustCd) throws EventException;
	
	/**
	 * State Code checking.<br>
	 * 
	 * @param String steCd
	 * @param String cntCd
	 * @return String
	 * @exception EventException
	 */
	public String checkStateCode(String steCd, String cntCd) throws EventException;
	
	/**
	 * Customer Code checking.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCustCode(String custCd) throws EventException;
	
	/**
	 * Sales Repository Code checking.<br>
	 * 
	 * @param String slsRepCd
	 * @return String
	 * @exception EventException
	 */
	public String checkSlsRepCode(String slsRepCd) throws EventException;
	
	/**
	 * Customer Code checking.<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustomerVO>
	 * @exception EventException
	 */
	public List<CustomerVO> checkExistCustCode(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * Customer Name, to look similar to the registered.(ESM_SAM_0304)<br>
	 * 
	 * @param String custCntCd
	 * @param String custNm
	 * @param String locCd
	 * @param String custRgstNo
	 * @param String matchRule
	 * @return List<CustomerVO>
	 * @exception DAOException
	 */
	public List<CustomerVO> searchCustomerListByName(String custCntCd, String custNm, String locCd, String custRgstNo, String matchRule) throws EventException;
	

	
}
