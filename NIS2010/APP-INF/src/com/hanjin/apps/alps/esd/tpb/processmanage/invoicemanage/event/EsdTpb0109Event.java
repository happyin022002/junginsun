/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0109Event.java
*@FileTitle : InvoiceManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-09-11 O Wan-Ki 			1.0	 최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event;

import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0109HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceSettingVO searchInvoiceSettingVO = null;
	
	public EsdTpb0109Event(){}
	
	public void setSearchInvoiceSettingVO(SearchInvoiceSettingVO searchInvoiceSettingVO){
		this. searchInvoiceSettingVO = searchInvoiceSettingVO;
	}

	public SearchInvoiceSettingVO getSearchInvoiceSettingVO(){
		return searchInvoiceSettingVO;
	}
}