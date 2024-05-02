/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageBC.java
*@FileTitle : InvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.basic;
  
import java.util.List;

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0110Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0111Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0112Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchIndiaTaxInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
 
/**
 * -InvoiceManage Business Logic Command Interface<br>
 * - -InvoiceManage business logic interface<br>
 *
 * @author 
 * @see Esd_tpb_0105EventResponse reference
 * @since J2EE 1.6
 */

public interface InvoiceManageBC {
	/**
	 * <br>
	 * 
	 * @param SearchTPBHandlingVO searchTPBHandlingVO
	 * @returnList<SearchTPBHandlingVO>
	 * @exception EventException
	 */
	public List<SearchTPBHandlingVO> searchTPBHandling(SearchTPBHandlingVO searchTPBHandlingVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInvoiceSettingVO	searchInvoiceSettingVO
	 * @return List<SearchAdjustmentManageListVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceSettingVO> searchInvoiceSheetSet(SearchInvoiceSettingVO searchInvoiceSettingVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<InvoiceCreationVO>
	 * @exception EventException
	 */
	public List<InvoiceCreationVO> searchInvoiceInfo(InvoiceCreationVO invoiceCreationVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param EsdTpb0111Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDetailListForRevision(EsdTpb0111Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDefaultData(SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param EsdTpb0112Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceStatus(EsdTpb0112Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchIndiaTaxInfoVO searchIndiaTaxInfoVO
	 * @param account SignOnUserAccount
	 * @return List<SearchIndiaTaxInfoVO>
	 * @exception EventException
	 */
	public List<SearchIndiaTaxInfoVO> searchIndiaTaxInfo(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * <br>
	 * 
	 * @param EsdTpb0112Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchCntCdbyOfcCd(EsdTpb0112Event event, GeneralEventResponse eventResponse) throws EventException;
	
	/**
	 * <br>
	 * 
	 * @param SearchIndiaTaxInfoVO searchIndiaTaxInfoVO
	 * @param account SignOnUserAccount
	 * @return List<SearchIndiaTaxInfoVO>
	 * @exception EventException
	 */
	public List<SearchIndiaTaxInfoVO> searchIndiaTaxInfoByEffDate(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO, SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param Event e
	 * @return GeneralEventResponse
	 * @exception EventException
	 */ 
	public GeneralEventResponse createERPInterface(Event e) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInvoiceSettingVO[] searchInvoiceSettingVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createInvoiceSheetSet(SearchInvoiceSettingVO[] searchInvoiceSettingVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param InvoiceCreationVO[] invoiceCreationVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createInvoice(InvoiceCreationVO[] invoiceCreationVO,GeneralEventResponse eventResponse,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param InvoiceCreationVO[] multiInvoiceManageListVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modifyInvoice(InvoiceCreationVO[] multiInvoiceManageListVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * <br>
	 * 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse removeInvoice(InvoiceCreationVO invoiceCreationVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String updateInvoiceIssue(SearchInvoiceStatusVO searchInvoiceStatusVO, SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchIndiaTaxInfoVO[] searchIndiaTaxInfoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiIndiaTaxInfo(SearchIndiaTaxInfoVO[] searchIndiaTaxInfoVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param EsdTpb0110Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceCreation(EsdTpb0110Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * <br>
	 * 
	 * @param InvoiceCreationVO vo
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> createErpData(InvoiceCreationVO vo) throws EventException;
	
	/**
	 * <br>
	 * 
	 * @param SearchTPBHandlingVO[] searchTPBHandlingVOs
	 * @exception EventException
	 */
	public void cancelTPBHandling(SearchTPBHandlingVO[] searchTPBHandlingVOs, SignOnUserAccount account) throws EventException;
	
}