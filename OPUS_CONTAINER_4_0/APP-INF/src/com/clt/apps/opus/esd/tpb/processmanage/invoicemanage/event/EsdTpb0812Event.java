/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0812Event.java
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

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchIndiaTaxInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0812 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0812HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0812HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0812Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchIndiaTaxInfoVO searchIndiaTaxInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchIndiaTaxInfoVO[] searchIndiaTaxInfoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceManageListVO searchInvoiceManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceManageListVO[] searchInvoiceManageListVOs = null;

	public EsdTpb0812Event(){}

	public SearchIndiaTaxInfoVO getSearchIndiaTaxInfoVO() {
		return searchIndiaTaxInfoVO;
	}

	public void setSearchIndiaTaxInfoVO(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO) {
		this.searchIndiaTaxInfoVO = searchIndiaTaxInfoVO;
	}

	public SearchIndiaTaxInfoVO[] getSearchIndiaTaxInfoVOs() {
		SearchIndiaTaxInfoVO[] rtnVOs = null;
		if (this.searchIndiaTaxInfoVOs != null) {
			rtnVOs = Arrays.copyOf(searchIndiaTaxInfoVOs, searchIndiaTaxInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchIndiaTaxInfoVOs(SearchIndiaTaxInfoVO[] searchIndiaTaxInfoVOs){
		if(searchIndiaTaxInfoVOs != null){
			SearchIndiaTaxInfoVO[] tmpVOs = Arrays.copyOf(searchIndiaTaxInfoVOs, searchIndiaTaxInfoVOs.length);
			this.searchIndiaTaxInfoVOs = tmpVOs;
		}
	}
	
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