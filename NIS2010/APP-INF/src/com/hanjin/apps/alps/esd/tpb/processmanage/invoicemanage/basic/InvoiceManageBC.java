/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageBC.java
*@FileTitle : InvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.common.combo.vo.TpbComboVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0110Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0111Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0112Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 
/**
 * ALPS-InvoiceManage Business Logic Command Interface<br>
 * - ALPS-InvoiceManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sun, CHOI
 * @see Esd_tpb_0105EventResponse 참조 
 * @since J2EE 1.6
 */

public interface InvoiceManageBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBHandlingVO searchTPBHandlingVO
	 * @returnList<SearchTPBHandlingVO>
	 * @exception EventException
	 */
	public List<SearchTPBHandlingVO> searchTPBHandling(SearchTPBHandlingVO searchTPBHandlingVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceSettingVO	searchInvoiceSettingVO
	 * @return List<SearchAdjustmentManageListVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceSettingVO> searchInvoiceSheetSet(SearchInvoiceSettingVO searchInvoiceSettingVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<InvoiceCreationVO>
	 * @exception EventException
	 */
	public List<InvoiceCreationVO> searchInvoiceInfo(InvoiceCreationVO invoiceCreationVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EsdTpb0111Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDetailListForRevision(EsdTpb0111Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDefaultData(SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EsdTpb0112Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceStatus(EsdTpb0112Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchIndiaTaxInfoVO searchIndiaTaxInfoVO
	 * @param account SignOnUserAccount
	 * @return List<SearchIndiaTaxInfoVO>
	 * @exception EventException
	 */
	public List<SearchIndiaTaxInfoVO> searchIndiaTaxInfo(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchIndiaTaxInfoVO searchIndiaTaxInfoVO
	 * @param account SignOnUserAccount
	 * @return List<SearchIndiaTaxInfoVO>
	 * @exception EventException
	 */
	public List<SearchIndiaTaxInfoVO> searchIndiaTaxInfoByEffDate(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param Event e
	 * @return GeneralEventResponse
	 * @exception EventException
	 */ 
	public GeneralEventResponse createERPInterface(InvoiceCreationVO invoiceVo, SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceSettingVO searchInvoiceSettingVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createInvoiceSheetSet(SearchInvoiceSettingVO searchInvoiceSettingVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO[] invoiceCreationVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createInvoice(InvoiceCreationVO[] invoiceCreationVO,GeneralEventResponse eventResponse,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO[] multiInvoiceManageListVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modifyInvoice(InvoiceCreationVO[] multiInvoiceManageListVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse removeInvoice(InvoiceCreationVO invoiceCreationVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String updateInvoiceIssue(SearchInvoiceStatusVO searchInvoiceStatusVO, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchIndiaTaxInfoVO[] searchIndiaTaxInfoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiIndiaTaxInfo(SearchIndiaTaxInfoVO[] searchIndiaTaxInfoVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EsdTpb0110Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceCreation(EsdTpb0110Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO vo
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> createErpData(InvoiceCreationVO vo) throws EventException;
	
	/**
	 * Account Code, Name<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<TpbComboVO> searchAcctCd() throws EventException;
	
	/**
	 * Terminal Name, ATD 조회<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchOutstandingDetailListForInvoiceCreationVO> searchYdNmAtd(InvoiceCreationVO inputVO) throws EventException;

	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, SearchInvoiceStatusVO searchInvoiceStatusVO, String pgmNo)
			throws EventException;	
	

	/**
	 * TPB EDI 전송 위해 FlatFile을 생성한다.
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitTPBEDI(SearchInvoiceStatusVO searchInvoiceStatusVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ROC Rollback 작업 수행
	 * Create New Uncollected Cargo Case Number <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @param String n3ptyNo
	 * @return String
	 * @exception EventException
	 */	
	public String checkRocRollback(String ofcCd, String userId, String n3ptyNo) throws EventException; 
		
}