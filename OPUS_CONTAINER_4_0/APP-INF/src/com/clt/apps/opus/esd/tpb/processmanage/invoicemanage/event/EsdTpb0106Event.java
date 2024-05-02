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
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event;
 
import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.clt.framework.support.layer.event.EventSupport;


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
		if(searchInvoiceManageListVOs != null){
			SearchInvoiceManageListVO[] tmpVOs = Arrays.copyOf(searchInvoiceManageListVOs, searchInvoiceManageListVOs.length);
			this.searchInvoiceManageListVOs = tmpVOs;
		}
	}

	public SearchInvoiceManageListVO getSearchInvoiceManageListVO(){
		return searchInvoiceManageListVO;
	}

	public SearchInvoiceManageListVO[] getSearchInvoiceManageListVOS(){
		SearchInvoiceManageListVO[] rtnVOs = null;
		if (this.searchInvoiceManageListVOs != null) {
			rtnVOs = Arrays.copyOf(searchInvoiceManageListVOs, searchInvoiceManageListVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSearchTPBHandlingVO(SearchTPBHandlingVO searchTPBHandlingVO){
		this. searchTPBHandlingVO = searchTPBHandlingVO;
	}

	public void setSearchTPBHandlingVOS(SearchTPBHandlingVO[] searchTPBHandlingVOs){
		if(searchTPBHandlingVOs != null){
			SearchTPBHandlingVO[] tmpVOs = Arrays.copyOf(searchTPBHandlingVOs, searchTPBHandlingVOs.length);
			this.searchTPBHandlingVOs = tmpVOs;
		}
	}

	public SearchTPBHandlingVO getSearchTPBHandlingVO(){
		return searchTPBHandlingVO;
	}

	public SearchTPBHandlingVO[] getSearchTPBHandlingVOS(){
		SearchTPBHandlingVO[] rtnVOs = null;
		if (this.searchTPBHandlingVOs != null) {
			rtnVOs = Arrays.copyOf(searchTPBHandlingVOs, searchTPBHandlingVOs.length);
		}
		return rtnVOs;
	}

	public InvoiceCreationVO getInvoiceCreationVO() {
		return invoiceCreationVO;
	}

	public void setInvoiceCreationVO(InvoiceCreationVO invoiceCreationVO) {
		this.invoiceCreationVO = invoiceCreationVO;
	}

	public InvoiceCreationVO[] getInvoiceCreationVOs() {
		InvoiceCreationVO[] rtnVOs = null;
		if (this.invoiceCreationVOs != null) {
			rtnVOs = Arrays.copyOf(invoiceCreationVOs, invoiceCreationVOs.length);
		}
		return rtnVOs;
	}

	public void setInvoiceCreationVOs(InvoiceCreationVO[] invoiceCreationVOs){
		if(invoiceCreationVOs != null){
			InvoiceCreationVO[] tmpVOs = Arrays.copyOf(invoiceCreationVOs, invoiceCreationVOs.length);
			this.invoiceCreationVOs = tmpVOs;
		}
	}

}