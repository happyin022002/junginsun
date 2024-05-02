/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0106Event.java
*@FileTitle : TPBHandling
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.08.18 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event;

import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0106HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceManageListVO searchInvoiceManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceManageListVO[] searchInvoiceManageListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBHandlingVO searchTPBHandlingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBHandlingVO[] searchTPBHandlingVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceCreationVO invoiceCreationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoiceCreationVO[] invoiceCreationVOs = null;
	
	
	public EsdTpb0106Event(){}
	
	public void setSearchInvoiceManageListVO(SearchInvoiceManageListVO searchInvoiceManageListVO){
		this. searchInvoiceManageListVO = searchInvoiceManageListVO;
	}

	public void setSearchInvoiceManageListVOS(SearchInvoiceManageListVO[] searchInvoiceManageListVOs){
		this. searchInvoiceManageListVOs = searchInvoiceManageListVOs;
	}

	public SearchInvoiceManageListVO getSearchInvoiceManageListVO(){
		return searchInvoiceManageListVO;
	}

	public SearchInvoiceManageListVO[] getSearchInvoiceManageListVOS(){
		return searchInvoiceManageListVOs;
	}
	
	public void setSearchTPBHandlingVO(SearchTPBHandlingVO searchTPBHandlingVO){
		this. searchTPBHandlingVO = searchTPBHandlingVO;
	}

	public void setSearchTPBHandlingVOS(SearchTPBHandlingVO[] searchTPBHandlingVOs){
		this. searchTPBHandlingVOs = searchTPBHandlingVOs;
	}

	public SearchTPBHandlingVO getSearchTPBHandlingVO(){
		return searchTPBHandlingVO;
	}

	public SearchTPBHandlingVO[] getSearchTPBHandlingVOS(){
		return searchTPBHandlingVOs;
	}

	public InvoiceCreationVO getInvoiceCreationVO() {
		return invoiceCreationVO;
	}

	public void setInvoiceCreationVO(InvoiceCreationVO invoiceCreationVO) {
		this.invoiceCreationVO = invoiceCreationVO;
	}

	public InvoiceCreationVO[] getInvoiceCreationVOs() {
		return invoiceCreationVOs;
	}

	public void setInvoiceCreationVOs(InvoiceCreationVO[] invoiceCreationVOs) {
		this.invoiceCreationVOs = invoiceCreationVOs;
	}

}