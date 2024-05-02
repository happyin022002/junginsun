/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0124Event.java
*@FileTitle : JOInvoiceManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchTPBHandlingListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0124 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0124HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0124HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0124Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBHandlingListVO searchTPBHandlingListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBHandlingListVO[] searchTPBHandlingListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceCreationVO invoiceCreationVO = null;

	/** Table Value Object Multi Data 처리 */
	private InvoiceCreationVO[] invoiceCreationVOs = null;

	public EsdTpb0124Event(){}

	public SearchTPBHandlingListVO getSearchTPBHandlingListVO() {
		return searchTPBHandlingListVO;
	}

	public void setSearchTPBHandlingListVO(
			SearchTPBHandlingListVO searchTPBHandlingListVO) {
		this.searchTPBHandlingListVO = searchTPBHandlingListVO;
	}

	public SearchTPBHandlingListVO[] getSearchTPBHandlingListVOs() {
		SearchTPBHandlingListVO[] rtnVOs = null;
		if (this.searchTPBHandlingListVOs != null) {
			rtnVOs = Arrays.copyOf(searchTPBHandlingListVOs, searchTPBHandlingListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchTPBHandlingListVOs(SearchTPBHandlingListVO[] searchTPBHandlingListVOs){
		if(searchTPBHandlingListVOs != null){
			SearchTPBHandlingListVO[] tmpVOs = Arrays.copyOf(searchTPBHandlingListVOs, searchTPBHandlingListVOs.length);
			this.searchTPBHandlingListVOs = tmpVOs;
		}
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