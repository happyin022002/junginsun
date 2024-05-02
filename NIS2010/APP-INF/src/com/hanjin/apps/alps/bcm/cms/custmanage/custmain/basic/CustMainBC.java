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
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.basic;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.BkgSalesRepVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerContactVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerIntegrationVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreateMdmCustRepVO;
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
	public List<SearchCustomerVO> searchCustomerList(String custCd, String custNm, String ofcCd, int iPage, String include, String cust
													, String zipCd, String custGrpId, String locCd, String steCd,  String srepCd
													, String custLoclLangNm, String custRgstNo
													, String deltFlg) throws EventException;
	
	/**
	 * BCM_CMS_0002 : Retrieve<br>
	 * Coverage Team
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<CustCoverTeamVO >
	 * @exception EventException
	 */
	public List<CustCoverTeamVO > searchCustCoverList(String custCntCd, String custSeq ) throws EventException;
	
	/**
	 * Customer 정보를 EAI로 전송한다. <BR>
	 *  @param String custCntCd
	 * @param String custSeq
	 * @param String usrId
	 * @param String creFlag
	 */
	public void sendCustomerToMdm(String custCntCd, String custSeq, String usrId, String creFlag) throws EventException;
	
	/**
	 * Credit Customer 정보를 EAI로 전송한다. <BR>
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String usrId
	 * @param String creFlag
	 */
	public void sendCreditCustToMdm(String custCntCd, String custSeq, String usrId, String creFlag) throws EventException;
	
	
	/**
	 * multi event process<br>
	 * Customer Address  multi event process(BCM_CMS_0302)<br>
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public CustomerAddressVO[] manageCustAddrCode(CustomerAddressVO[] custAddrVOs,SignOnUserAccount account) throws EventException;
	

	
	/**
    * save MDM Customer data for Customer Code Validation
	 * @param CustomerVO customerVo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean mergeBkgCustCdVal(CustomerVO customerVo)throws EventException;
	
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
	 * BCM_CMS_0302 : manage<br>
	 * Check Sales Rep Code 
	 * @param String custCd
	 * @param String srepCd
	 * @return  String
	 * @exception EventException
	 * 
	 */
	public String checkSalesRepCode(String custCd, String srepCd)throws EventException;
	
	/**
	 * BCM_CMS_0302 : manage<br>
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
	 * Customer Code Creation  multi event process(BCM_CMS_0302)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public CustomerVO manageCustCode(CustomerIntegrationVO custIntgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Code Creation  multi event process(BCM_CMS_0302)<br>
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
	 * Customer Code retrieve.(BCM_CMS_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchCustCode(String custCntCd, String custSeq) throws EventException;
	
	
	/**
	 * Customer Code retrieve.(BCM_CMS_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String usrId
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public void addCustHist(String custCntCd, String custSeq, String usrId) throws EventException;
	
	/**
	 * Customer Address retrieve.(BCM_CMS_0311)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<HistMainVO>
	 * @exception EventException
	 */
	public List<BlHistVO> searchCreditCustHist(String custCd) throws EventException;
	
	/**
	 * Modify/save/delete event process<br>
	 * Credit Customer Auto Invoice (BCM_CMS_0311.do)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @exception EventException
	 */
	public void modifyCreditCustCode(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * India Location State Code retrieve.(BCM_CMS_0302)<br>
	 * 
	 * @param String locCd
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchLocSteCode(String locCd) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Address  multi event process(BCM_CMS_0302)<br>
	 * 
	 * @param CustomerContactVO[] customerContractVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCntcCode(CustomerContactVO[] customerContractVOs, SignOnUserAccount account, String creFlag) throws EventException;
	
	/**
	 * Customer Address retrieve.(BCM_CMS_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String addrTpCd
	 * @return List<CustomerAddressVO>
	 * @exception EventException
	 */
	public List<CustomerAddressVO>  searchCustAddr(String custCntCd, String custSeq, String addrTpCd) throws EventException;
	
	/**
	 * Customer History(BCM_CMS_0302)<br>
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
	 * Customer Register no checking.<br>
	 * 
	 * @param String custRgstNo
	 * @param String rqstNo
	 * @return String
	 * @exception EventException
	 */
	public String checkRgstNo (String custRgstNo, String rqstNo)  throws EventException;
	
	/**
	 * BCM_CMS_0311 : Retrieve<br>
	 * Customer rep 정보를 조회<br><br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustCoverTeamVO >
	 * @exception EventException
	 */
	public List<CreateMdmCustRepVO > searchCreditCustRepList(String custCntCd, String custSeq )throws EventException;
	
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
	 * Customer Name, to look similar to the registered.(BCM_CMS_0304)<br>
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
	
	/**
	 * Credit Customer Code retrieve.(BCM_CCD_0039)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CreditCustomerVO
	 * @exception DAOException
	 */
	public CreditCustomerVO searchCrCustCode(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * multi event process<br>
	 * Credit Customer Code Creation  multi event process(BCM_CCD_0039)<br>
	 * 
	 * @param CreditCustomerVO[] creditCustomerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCrCustCode(CreditCustomerVO creditCustomerVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(BCM_CMS_0302)<br>
	 * Customer Address Max Seq retrieve.<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @param  String addrtpcd
	 * @return int
	 * @exception EventException
	 */
	public int searchMAXCustAddrSeq(String custcntcd, String custseq, String addrtpcd) throws EventException;
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer rep (BCM_CMS_0311.do)<br>
	 * 
	 * @param CreateMdmCustRepVO[] createMdmCustRepVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustRep(CreateMdmCustRepVO[] createMdmCustRepVOs, SignOnUserAccount account) throws EventException;
}
