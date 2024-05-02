/*============================================
*Copyright(c) 2009 CyberLogitec
*@FileName :DODInvoiceMgtBC.java
*@FileTitle : 
*@LastModifyDate : 2013. 9. 11.
*@LastModifier : KIM HYUN HWA
*@LastVersion : 
* 2013. 9. 11. KIM HYUN HWA
* 2016-03-28 [CHM-201640540]한국지역 Drop-Off Charge 시스템 개선 요청
*============================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionParmVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionSumVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvEmailFaxVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceDetailVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODTariffVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DodArIfMnVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasAttentionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.PayerInfoParamVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.PayerInformationVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchBKGCntrListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchDODInvoiceListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * DOD Invoice management Business Logic Command Interface<br>
 * - DOD Invoice management 에 대한 비지니스 로직에 대한 인터페이스<br>
 * @author KIM HYUN HWA
 * @see  Esd_eas_0100EventResponse 참조
 * @since J2EE 1.6
 */
  


public interface DODInvoiceMgtBC {

	/**
	 * BKG Container List를 조회한다.
	 * 
	 * @param inBlNo
	 * @param sessionOfcCd
	 * @return List<SearchBKGCntrListVO>
	 * @throws EventException
	 */
	public List<SearchBKGCntrListVO> searchBKGCntrList(String inBlNo, String sessionOfcCd) throws EventException;

    /**
     * ESD_EAS_0100 Payer정보를 조회한다.
     * 
     * @param inPayerCd
     * @return DODPayrInfoVO
     * @throws EventException
     */
    public DODPayrInfoVO searchPayerInfo(String inPayerCd) throws EventException;
	
    /**
     * ESD_EAS_0100 Payer정보를 조회한다.
     * 
     * @param inPayerCd
     * @param inCustRgstNo
     * @return DODPayrInfoVO
     * @throws EventException
     */
    public DODPayrInfoVO searchPayerInfo(String inPayerCd, String inCustRgstNo) throws EventException; 

	/**
	 * 신규 DOD INV No 생성 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchEasDodInvSeq(String ofcCd) throws EventException;	

	/**
	 * (KOR) DOD Invoice Issue - ISSUE<br>
	 * 
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 * @param DODInvoiceDetailVO[] dodInvoiceDetailVOs
	 * @param String dodInvNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createDODInvoice(DODInvoiceMainVO dodInvoiceMainVO, DODInvoiceDetailVO[] dodInvoiceDetailVOs, String dodInvNo, SignOnUserAccount account) throws EventException;
	
    /**
     * ESD_EAS_0103 Payer정보를 조회한다.
     * 
     * @param PayerInfoParamVO payerInfoParamVO
     * @return PayerInformationVO
     * @throws EventException
     */
    public PayerInformationVO searchPayerInformation ( PayerInfoParamVO payerInfoParamVO) throws EventException;

	
	/**
	 * ESD_EAS_0103 :Payer Name 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
    public List<EasPayrInfoVO> searchPayerName(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * ESD_EAS_0103 :Payer Address 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
    public List<EasPayrInfoVO> searchPayerAddress(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * ESD_EAS_0103 :Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
    public List<EasPayrInfoVO> searchPayerContactPointName(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * ESD_EAS_0103 :Payer Phone No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
	public List<EasPayrInfoVO> searchPayerPhoneNo(PayerInfoParamVO payerInfoParamVO) throws EventException;
	
	/**
	 * ESD_EAS_0103 :Payer Fax No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
	public List<EasPayrInfoVO> searchPayerFaxNo(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * ESD_EAS_0103 :Payer Email 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws EventException
	 */
	public List<EasPayrInfoVO> searchPayerEmail(PayerInfoParamVO payerInfoParamVO) throws EventException;
	
	/**
	 * ESD_EAS_0103 :Payer Info 정보를 저장한다.<br>
	 * 
	 * @param PayerInformationVO payerInformationVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePayerInformation(PayerInformationVO payerInformationVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESD_EAS_0100 :Atttention 정보를 조회한다.
	 * 
	 * @param EasAttentionVO attentionVO
	 * @return List<EasAttentionVO>
	 * @exception EventException
	 */
	public List<EasAttentionVO> searchAttention(EasAttentionVO attentionVO) throws EventException;
	
	/**
	 * ESD_EAS_0102 : 조회<br>
	 * DOD Invoice list를 조회합니다.<br>
	 * 
	 * @param SearchDODInvoiceListInputVO searchDODInvoiceListInputVO
	 * @return List<DODInvoiceListVO>
	 * @exception EventException
	 */
	public List<DODInvoiceListVO> searchDODInvoiceList(SearchDODInvoiceListInputVO searchDODInvoiceListInputVO) throws EventException;
	
	/**
	 * ESD_EAS_0102 : Cancel<br>
	 * DOD Invoice 를 Cancel합니다.<br>
	 * 
	 * @param DODInvoiceListVO[] dODInvoiceListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void cancelDODInvoice(DODInvoiceListVO[] dODInvoiceListVOs, SignOnUserAccount account) throws EventException;

    /**
     * ESD_EAS_0102 [AR Interface]에 전달할 내용을 [조회]한다.
     * @param SignOnUserAccount account
     * @param String invoiceNo
     * @param String bkgNo
     * @return ARInterfaceCreationVO
     * @throws EventException
     */
    public ARInterfaceCreationVO searchARInterfaceInvoice(SignOnUserAccount account, String invoiceNo, String bkgNo) throws EventException;

    /**
     * ESD_EAS_0102 [AR Interface]된 내용을 update한다.
     * @param SignOnUserAccount account
     * @param String arIfNo
     * @param String invoiceNo 
     * @throws EventException
     */
    public void  modifyARInterfaceInfo(SignOnUserAccount account, String arIfNo, String invoiceNo) throws EventException;
    
	/**
	 * Fax, Email 이벤트 처리<br>
	 * 한국지역 Invoice 를 Fax/Email 로 전송한다.<br>
	 * 
	 * @param DODInvEmailFaxVO dODInvEmailFaxVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendKORDodInvoiceByFaxEmail(DODInvEmailFaxVO dODInvEmailFaxVO, SignOnUserAccount account) throws EventException;

	/**
	 *  DOD Collection List<br>
	 *  
	 * @param DODCollectionParmVO dodCollectionParmVO
	 * @return List<DODCollectionVO>
	 * @throws EventException
	 */
	public List<DODCollectionVO> searchDODInvoiceCollectionList(DODCollectionParmVO dodCollectionParmVO)throws EventException;

	/**
	 * DOD Collection List Summary<br>
	 * 
	 * @param DODCollectionParmVO dodCollectionParmVO
	 * @return List<DODCollectionSumVO>
	 * @throws EventException
	 */
	public List<DODCollectionSumVO> searchDODInvoiceCollectionSummary(DODCollectionParmVO dodCollectionParmVO) throws EventException;

	/**
	 * DOD Invoice  Credit Note 생성<br>
	 * 
	 * @param String dodInvNo
	 * @param String newDodInvNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createCreditNoteDODInvoice(String dodInvNo, String newDodInvNo, SignOnUserAccount account) throws EventException;

	/**
	 * @param SignOnUserAccount account
	 * @param String invoice_no
	 * @param String bkg_no
	 * @return DodArIfMnVO
	 * @throws EventException
	 */
	public DodArIfMnVO checkAlreadyArIf(SignOnUserAccount account, String invoice_no,
			String bkg_no)throws EventException;

	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 * @param DODInvoiceDetailVO[] dodInvoiceDetailVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, DODInvoiceMainVO dodInvoiceMainVO, DODInvoiceDetailVO[] dodInvoiceDetailVOs, String pgmNo)
			throws EventException;	
	

	/**
	 * EAS Invoice EDI 전송 위해 FlatFile을 생성한다.
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 * @param DODInvoiceDetailVO[] dodInvoiceDetailVOs
	 * @param SignOnUserAccount account
	 * @param String docName
	 * @param String docFunc
	 * @return String
	 * @throws EventException
	 */
	public String transmitEASEDI(DODInvoiceMainVO dodInvoiceMainVO, DODInvoiceDetailVO[] dodInvoiceDetailVOs, SignOnUserAccount account, String docName, String docFunc) throws EventException;

	
	/**
	 * EAS Invoice Main 정보를  search 한다.
	 * @param dodInvNo
	 * @return DODInvoiceMainVO
	 * @throws EventException
	 */
	public DODInvoiceMainVO searchDodInvoiceMain(String dodInvNo) throws EventException;
	
	/**
	 * EAS Invoice Detail 정보를  search 한다.
	 * @param dodInvNo
	 * @return List<DODInvoiceDetailVO>
	 * @throws EventException
	 */
	public DODInvoiceDetailVO[] searchDodInvoiceDetail(String dodInvNo) throws EventException;	

	/**
	 * Korea DOD Tariff list 를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String polContiCd
	 * @param String effDt 
	 * @return List<DODTariffVO>
	 * @throws EventException
	 */
	public List<DODTariffVO> searchDODTariffList(String ofcCd , String polContiCd, String effDt) throws EventException;	
	
	/**
	 * Korea DOD Tariff Effective Date list를 조회한다.<br>
	 * 
	 * @param String ofc
	 * @param String pol_conti
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchDODTariffEffDtList(String ofc, String pol_conti) throws EventException;
	
	/**
	 * (KOR) DOD Tariff Creation 정보를 등록, 수정, 삭제한다.<br>
	 * 
	 * @author 
	 * @param DODTariffVO[] DODTariffVOs
	 * @exception EventException
	 */
	public void manageDODTariff(DODTariffVO[] DODTariffVOs) throws EventException;
	
	
	/**
	 * (KOR) DOD Tariff Creation 입력된 tpsz_cd의 MDM내 존재여부 확인.<br>
	 * 
	 * @param String cntr_tpsz_cds
	 * @return String
	 * @throws EventException
	 */
	public String verifyDODTariffTpSz(String cntr_tpsz_cds) throws EventException;
	
	/**
	 * (Korea) DOD Tariff Dup Chek 정보를 조회한다.<br>
	 * 
	 * @param DODTariffVO dODTariffVO
	 * @return String
	 * @throws EventException
	 */
	public String searchDODTariffDupCheck(DODTariffVO dODTariffVO) throws EventException;

	
}