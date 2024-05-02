/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0810Event.java
*@FileTitle : InvoiceManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event;
 
import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0810 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0810HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0810HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0810Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceManageListVO searchInvoiceManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceManageListVO[] searchInvoiceManageListVOs = null;

	public EsdTpb0810Event(){}
	
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

}