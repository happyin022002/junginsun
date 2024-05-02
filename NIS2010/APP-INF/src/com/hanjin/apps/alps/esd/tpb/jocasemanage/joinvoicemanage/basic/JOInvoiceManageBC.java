/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOInvoiceManageBC.java
*@FileTitle : JOInvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0126Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0127Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchTPBHandlingListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-JOInvoiceManagemanage Business Logic Command Interface<br>
 * - ALPS-JOInvoiceManagemanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see Esd_tpb_105EventResponse 참조
 * @since J2EE 1.6
 */

public interface JOInvoiceManageBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBHandlingListVO searchTPBHandlingListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBHandlingListVO>
	 * @exception EventException
	 */
	public List<SearchTPBHandlingListVO> searchTPBHandlingList(SearchTPBHandlingListVO searchTPBHandlingListVO, SignOnUserAccount account) throws EventException;
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
	 * @param Event e
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createERPInterface(InvoiceCreationVO invoiceVo, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceSheetSetVO searchInvoiceSheetSetVO
	 * @return List<SearchInvoiceSheetSetVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceSheetSetVO> searchInvoiceSheetSet(SearchInvoiceSheetSetVO searchInvoiceSheetSetVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createInvoiceSheetSet(SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EsdTpb0126Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceCreation(EsdTpb0126Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO[] multiInvoiceManageListVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createInvoice(InvoiceCreationVO[] multiInvoiceManageListVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EsdTpb0127Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDetailListForRevision(EsdTpb0127Event event, GeneralEventResponse eventResponse) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO
	 * @param GeneralEventResponse eventResponse
	 * @param SignOnUserAccount account
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDefaultData(SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException;
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
	 * @param InvoiceCreationVO multiInvoiceManageListVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse removeInvoice(InvoiceCreationVO multiInvoiceManageListVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException;
}