/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOInvoiceManageBC.java
*@FileTitle : JOInvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0126Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0127Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchTPBHandlingListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -JOInvoiceManagemanage Business Logic Command Interface<br>
 * - -JOInvoiceManagemanage business logic interface<br>
 *
 * @author 
 * @see Esd_tpb_105EventResponse reference
 * @since J2EE 1.6
 */

public interface JOInvoiceManageBC {
	/**
	 * <br>
	 * 
	 * @param SearchTPBHandlingListVO searchTPBHandlingListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBHandlingListVO>
	 * @exception EventException
	 */
	public List<SearchTPBHandlingListVO> searchTPBHandlingList(SearchTPBHandlingListVO searchTPBHandlingListVO, SignOnUserAccount account) throws EventException;
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
	 * @param Event e
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createERPInterface(Event e) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInvoiceSheetSetVO searchInvoiceSheetSetVO
	 * @return List<SearchInvoiceSheetSetVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceSheetSetVO> searchInvoiceSheetSet(SearchInvoiceSheetSetVO searchInvoiceSheetSetVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createInvoiceSheetSet(SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param EsdTpb0126Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceCreation(EsdTpb0126Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * <br>
	 * 
	 * @param InvoiceCreationVO[] multiInvoiceManageListVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createInvoice(InvoiceCreationVO[] multiInvoiceManageListVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param EsdTpb0127Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDetailListForRevision(EsdTpb0127Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO
	 * @param GeneralEventResponse eventResponse
	 * @param SignOnUserAccount account
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDefaultData(SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException;
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
	 * @param InvoiceCreationVO multiInvoiceManageListVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse removeInvoice(InvoiceCreationVO multiInvoiceManageListVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException;
}