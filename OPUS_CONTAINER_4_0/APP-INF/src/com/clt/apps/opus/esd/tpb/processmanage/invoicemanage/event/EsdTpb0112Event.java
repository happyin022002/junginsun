/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0112Event.java
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

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0112HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsdTpb0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceStatusVO searchInvoiceStatusVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceStatusVO[] searchInvoiceStatusVOs = null;
	
	
	// Success Flag
	private String successFlag;
	
	// fax_eml_snd_no
	private String faxEmlSndNo; 

	public EsdTpb0112Event(){}
	

	public SearchInvoiceStatusVO getSearchInvoiceStatusVO() {
		return searchInvoiceStatusVO;
	}

	public void setSearchInvoiceStatusVO(SearchInvoiceStatusVO searchInvoiceStatusVO) {
		this.searchInvoiceStatusVO = searchInvoiceStatusVO;
	}

	public SearchInvoiceStatusVO[] getSearchInvoiceStatusVOs() {
		SearchInvoiceStatusVO[] rtnVOs = null;
		if (this.searchInvoiceStatusVOs != null) {
			rtnVOs = Arrays.copyOf(searchInvoiceStatusVOs, searchInvoiceStatusVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInvoiceStatusVOs(SearchInvoiceStatusVO[] searchInvoiceStatusVOs){
		if(searchInvoiceStatusVOs != null){
			SearchInvoiceStatusVO[] tmpVOs = Arrays.copyOf(searchInvoiceStatusVOs, searchInvoiceStatusVOs.length);
			this.searchInvoiceStatusVOs = tmpVOs;
		}
	}

	public String getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

	public String getFax_eml_snd_no() {
		return faxEmlSndNo;
	}

	public void setFax_eml_snd_no(String fax_eml_snd_no) {
		this.faxEmlSndNo = fax_eml_snd_no;
	}


}