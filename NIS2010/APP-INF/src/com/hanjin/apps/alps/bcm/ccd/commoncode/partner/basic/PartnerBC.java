/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : partnerBC.java
*@FileTitle : carrier
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.basic; 
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CarrierVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerIntegrationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerPerformanceVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.SearchSimilarVendorNameVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorClassificationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.MoreInfoVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomsCustomerVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmCustAddrVO;
 
/**
 * Common code Business Logic Command Interface<br>
 * An interface to the business logic for Common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface PartnerBC {

	/**
	 * Carrier Code retrieve.(BCM_CCD_0034)<br>
	 * 
	 * @param String crrCd
	 * @return CarrierVO
	 * @exception EventException
	 */
	public CarrierVO searchCrrCode(String crrCd) throws EventException;
	
	/**
	 * Carrier Code retrieve.(BCM_CCD_0034)<br>
	 * 
	 * @param String rqstNo
	 * @return CarrierVO
	 * @exception EventException
	 */
	public CarrierVO searchCrrRqst(String rqstNo) throws EventException;

	/**
	 * multi event process<br>
	 * Carrier Code Creation  multi event process(BCM_CCD_0034)<br>
	 * 
	 * @param CarrierVO crrVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCrrCode(CarrierVO crrVo,SignOnUserAccount account) throws EventException;
	
	/**
	 * multi event process<br>
	 * Carrier Code Creation  multi event process(BCM_CCD_0034)<br>
	 * 
	 * @param CarrierVO crrVo
	 * @param SignOnUserAccount account
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageCrrRqst(CarrierVO crrVo,SignOnUserAccount account, String rqstNo) throws EventException;
	
	/**
	 * Customer Address retrieve.(BCM_CCD_0036)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String addrTpCd
	 * @return List<CustomerAddressVO>
	 * @exception EventException
	 */
	public List<CustomerAddressVO>  searchCustAddrCode(String custCntCd, String custSeq, String addrTpCd) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Address  multi event process(BCM_CCD_0036)<br>
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustAddrCode(CustomerAddressVO[] custAddrVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Customer Contact Point Code retrieve.(BCM_CCD_0037)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustomerContactVO>
	 * @exception DAOException
	 */
	public List<CustomerContactVO> searchCustCntcCode(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Address  multi event process(BCM_CCD_0037)<br>
	 * 
	 * @param CustomerContactVO[] customerContractVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCntcCode(CustomerContactVO[] customerContractVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Group Customer retrieve.(BCM_CCD_0038)<br>
	 * 
	 * @param String custCd
	 * @return CustomerPerformanceVO
	 * @exception EventException
	 */
	public CustomerPerformanceVO searchCustPerfCode(String custCd) throws EventException;
	/**
	 * Group Customer retrieve.(BCM_CCD_0038)<br>
	 * 
	 * @param String rqstNo
	 * @return CustomerPerformanceVO
	 * @exception EventException
	 */
	public CustomerPerformanceVO searchCustPerfRqst(String rqstNo) throws EventException;
	/**
	 * Group Customer Id retrieve.(BCM_CCD_0038)<br>
	 * 
	 * @return CustomerPerformanceVO
	 * @exception EventException
	 */
	public CustomerPerformanceVO searchCustGrpId() throws EventException;
	
	/**
	 * multi event process<br>
	 * Group Customer Code  multi event process(BCM_CCD_0038)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustPerfCode(CustomerPerformanceVO customerPerformanceVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * multi event process<br>
	 * Group Customer Code  multi event process(BCM_CCD_0038)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustPerfRqst(CustomerPerformanceVO customerPerformanceVO,String rqstNo,SignOnUserAccount account) throws EventException;
	
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
	public void manageCrCustCode(CreditCustomerVO[] creditCustomerVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Customer Code retrieve.(BCM_CCD_0035)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchCustCode(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * Country code is generated query.(BCM_CCD_0035)<br>
	 * 
	 * @param String custCntCd
	 * @return 	String 
	 * @exception DAOException
	 */	
	public String searchCustMaxSeq(String custCntCd) throws EventException ;
	
	/**
	 * multi event process<br>
	 * Customer Code Creation  multi event process(BCM_CCD_0035)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCode(CustomerIntegrationVO custIntgVO, SignOnUserAccount account) throws EventException;
	/**
	 * BCM_CCD_0040 : Retrieve <br>
	 *  Vendor retrieve.<br>
	 * 
	 * @param String vndrCd
	 * @return VendorGroupVO
	 * @exception EventException 
	 */ 
	public VendorGroupVO searchVndrCode(String vndrCd) throws EventException;  
	
	/**
	 * BCM_CCD_0040 : Retrieve <br>
	 *  Vendor retrieve.<br>
	 * 
	 * @param String rqstNo
	 * @return VendorGroupVO
	 * @exception EventException 
	 */ 
	public VendorGroupVO searchVndrRqst(String rqstNo) throws EventException; 
	
	/**
	 * BCM_CCD_0040 : Code Creation<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchVndrMaxSeq() throws EventException;
	
	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor save.<br>
	 * 
	 * @param VendorGroupVO vendorGroupVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVndrCode(VendorGroupVO vendorGroupVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor save.<br>
	 * 
	 * @param VendorGroupVO vendorGroupVO
	 * @param SignOnUserAccount account
	 * @param String max_vndr_seq
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageVndrRqst(VendorGroupVO vendorGroupVO, SignOnUserAccount account, String max_vndr_seq, String rqstNo) throws EventException;
	
	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor save.<br>
	 * 
	 * @param VendorGroupVO vendorGroupVO
	 * @param String rqstNo
	 * @param String ibFlag
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVndrRqst(VendorGroupVO vendorGroupVO, String rqstNo, String ibFlag, SignOnUserAccount account) throws EventException;
	
	/**
	 * BCM_CCD_1040 : Retrieve<br>
	 * Vendor Name, to look similar to the registered<br>
	 * 
	 * @param SearchSimilarVendorNameVO searchSimilarVendorNameVO
	 * @return List<SearchSimilarVendorNameVO>
	 * @exception EventException
	 */
	public List<SearchSimilarVendorNameVO> searchSimilarVendorName(SearchSimilarVendorNameVO searchSimilarVendorNameVO) throws EventException;
	
	
	/**
	 * ESM_SAM_0900 : SAVE <br>
	 * Srep_flg save.<br>
	 * @param CustomsCustomerVO customsCustomerVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageSrepByCust(CustomsCustomerVO customsCustomerVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Basic Info
	 * @param SearchCustomerVO[] searchCustomerVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	
	public void manageCustomerInfo(SearchCustomerVO[] searchCustomerVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Address
	 * @param MdmCustAddrVO[] mdmCustAddrVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	
	public void manageCustomerAddressInfo(MdmCustAddrVO[] mdmCustAddrVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Coverage Team
	 * @param CustCoverTeamVO[] CustCoverTeamVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	
	public void manageCustCoverInfo(CustCoverTeamVO[] CustCoverTeamVOS, SignOnUserAccount account) throws EventException;
	
	
	
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
	 * Customer Name, to look similar to the registered.(BCM_CCD_1035)<br>
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
	 * Group Customer retrieve.(BCM_CCD_1038)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @return List<CustomerPerformanceVO>
	 * @exception EventException
	 */
	public List<CustomerPerformanceVO> searchCustGrpList(CustomerPerformanceVO customerPerformanceVO) throws EventException;
	
	
	/**
	 * Customer Integration Request Info retrieve.(BCM_CCD_2002)<br>
	 * 
	 * @param String rqstNo
	 * @return CustomerIntegrationVO
	 * @exception DAOException
	 */
	public CustomerIntegrationVO searchCustIntgRqst(String rqstNo) throws EventException;
	
	
	/**
	 * Customer Request Info retrieve.(BCM_CCD_0035)<br>
	 * 
	 * @param String rqstNo
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchCustRqst(String rqstNo) throws EventException;
	
	
	/**
	 * Customer Request Info retrieve.(BCM_CCD_2002)<br>
	 * 
	 * @param String rqstNo
	 * @return List<CustomerAddressVO>
	 * @exception DAOException
	 */
	public List<CustomerAddressVO> searchCustAddrRqst(String rqstNo) throws EventException;

	/**
	 * Customer Request Info modify.
	 * 
	 * @param CustomerVO[] customerVOs
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustRqst(CustomerVO[] customerVOs,  String rqstNo, SignOnUserAccount account) throws EventException;

	/**
	 * Customer Request Info modify.
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param String cntCd
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustAddrRqstI(CustomerAddressVO[] custAddrVOs, String cntCd, String rqstNo, SignOnUserAccount account) throws EventException;

	/**
	 * @param CustomerVO[] customerVOs
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCustRqstI(CustomerVO[] customerVOs, String rqstNo,	SignOnUserAccount account) throws EventException ;

	/**
	 * CNTC PNT 
	 * @param CustomerContactVO[] customerContractVOs
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCustCntcPntRqst(CustomerContactVO[] customerContractVOs, String rqstNo, SignOnUserAccount account) throws EventException;

	/**
	 * Customer EAI I/F 의 테이블(MDM_CUSTOMER_IF)의 CUST_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0052)<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchCustIfSeq() throws EventException;

	/**
	 * Vendor EAI I/F 의 테이블(MDM_CUSTOMER_IF)의 VNDR_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0040)<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchVndrIfSeq() throws EventException;

	/**
	 * Customer Contract Request Info retrieve.(BCM_CCD_2002)<br>
	 * 
	 * @param String rqstNo
	 * @return List<CustomerContactVO>
	 * @exception EventException
	 */
	public List<CustomerContactVO> searchCustCntcRqst(String rqstNo) throws EventException;
	
	/**
	 * add/update Vendor's TPB Customer (BCM_CCD_2002)<br>
	 * 
	 * @param VendorGroupVO vendorGroup
	 * @throws EventException
	 */
	public void mergeMdmCustFrmVndr(VendorGroupVO vendorGroup) throws EventException;
	
	/**
	 * add/update Vendor's TPB Customer Address (BCM_CCD_2002)<br>
	 * 
	 * @param VendorVO vendorVO
	 * @throws EventException
	 */
	public void mergeMdmCustAddrFrmVndr(VendorVO vendorVO) throws EventException;
	
	/**
	 * check Legacy Code(SAP ID) (BCM_CCD_0035)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @exception EventException
	 */
	public void isLegacyCodeUnique(CustomerIntegrationVO custIntgVO) throws EventException;
	
	/**
	 * Update Vendor Sakura Interface Data<br>
	 * 
	 * @param VendorVO vendorVO
	 * @throws EventException
	 */
	public void modifySakuraInterfaceData(VendorVO vendorVO) throws EventException;
	
	/**
	 * Retrieve Sakura Interface Target Data<br>
	 * 
	 * @return List<CustomerContactVO>
	 * @exception EventException
	 */
	public List<VendorVO> searchMdaSakuraInterfaceData() throws EventException;
	
	/**
	 * Vendor Sakura Interface Result Save<br>
	 * 
	 * @param List<VendorVO> list
	 * @exception EventException
	 */
	public void modifyVendorInterfaceResultData(List<VendorVO> list)throws EventException;
	
	/**
	 * check Legacy Code(SAP ID) (BCM_CCD_0035)<br>
	 * 
	 * @param VendorVO vendorVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchVendorBankPayData(VendorVO vendorVO) throws EventException;
	
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
	 * Vendor 요청 테이블(MDM_VNDR_RQST)의 REQUEST NO를 가져온다.(BCM_CCD_0040)
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchVndrRqstSeq() throws EventException;
	
	/**
	 * Vendor Request 목록을 가져온다. (BCM_CCD_0053)
	 * 
	 * @param String rqstNo
	 * @param String VendorNm
	 * @param String ofcCd
	 * @param String iPage
	 * @param String deltFlg
	 * @param String rqstFmDt
	 * @param String rqstToDt
	 * @return List<VendorVO>
	 * @throws EventException
	 */
	public List<VendorVO> searchRqstVndr(String rqstNo, String VndrNm, String ofcCd, int iPage, String deltFlg, String rqstFmDt, String rqstToDt) throws EventException;
	
	/**
	 * Vendor Request를 승인한다. (BCM_CCD_0053)
	 * @param VendorVO[] vendorVOS
	 * @throws EventException
	 */
	public void manageRqstVndrApro(VendorVO[] vendorVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * Vendor Request를 거절한다. (BCM_CCD_0053)
	 * 
	 * @param vendorVOS
	 * @param account
	 * @throws EventException
	 */
	public void modifyRqstVndrRjct(VendorVO[] vendorVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * Vendor Creation Request 내역을 저장한다. (BCM_CCD_0040)
	 * @param String rqstNo
	 * @throws EventException
	 */
	public void modifyVndrRqstList(String rqstNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Transfer Vendor Info To EAI 
	 * 
	 * @param vndrSeq
	 * @param usrId
	 * @param cudFlg
	 * @throws EventException
	 */
	public void sendVndrToEai(String vndrSeq, String usrId, String cudFlg) throws EventException;

	/**
	 * Transfer Vendor Contact Point Information To EAI
	 * 
	 * @param String vndrSeq
	 * @param String vndrCntcPntSeq
	 * @param String usrId
	 * @param String cudFlg
	 * @throws EventException
	 */
	public void sendVndrCntcToEai(List<VendorContactVO> vndrCntcVOs, String usrId, String cudFlg) throws EventException;

	/**
	 * Transfer Container Vendor Classification To EAI
	 * 
	 * @param vndrSeq
	 * @param vndrCostCd
	 * @param cntrVndrSvcCd
	 * @param usrId
	 * @param cudFlg
	 * @throws EventException
	 */
	public void sendCntrVndrClssToEai(List<VendorClassificationVO> vndrClssVOs, String usrId, String cudFlg) throws EventException;

	/**
	 * Transfer Container Vendor Classification To EAI
	 * 
	 * @param vndrSeq
	 * @param vndrCostCd
	 * @param cntrVndrSvcCd
	 * @param usrId
	 * @param cudFlg
	 * @throws EventException
	 */
	public List<VendorVO> searchVndrList(VendorVO vndrVO, int iPage) throws EventException;
	
	/**
	 * Register No checking.<br>
	 * 
	 * @param String rgstNo
	 * @return String
	 * @exception EventException
	 */
	public String checkRgstNo(String rgstNo, String vndrSeq) throws EventException;
}
