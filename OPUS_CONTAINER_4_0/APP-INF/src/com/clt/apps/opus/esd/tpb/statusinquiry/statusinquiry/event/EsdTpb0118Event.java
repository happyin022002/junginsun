/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0118Event.java
*@FileTitle : StatusInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-19
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-09-10 O Wan-Ki 			1.0	최초 생성
* 2009-10-19 Jong-Geon Byeon	1.1 Renewal Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBInvoiceListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0118 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0118HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0118HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0118Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBInvoiceListVO searchTpbInvoiceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBInvoiceListVO[] searchTpbInvoiceListVOs = null;

	public EsdTpb0118Event(){}
	
	public void setSearchTpbInvoiceListVO(SearchTPBInvoiceListVO searchTpbInvoiceListVO){
		this. searchTpbInvoiceListVO = searchTpbInvoiceListVO;
	}

	public void setSearchTpbInvoiceListVOS(SearchTPBInvoiceListVO[] searchTpbInvoiceListVOs){
		if(searchTpbInvoiceListVOs != null){
			SearchTPBInvoiceListVO[] tmpVOs = Arrays.copyOf(searchTpbInvoiceListVOs, searchTpbInvoiceListVOs.length);
			this.searchTpbInvoiceListVOs = tmpVOs;
		}
	}

	public SearchTPBInvoiceListVO getSearchTpbInvoiceListVO(){
		return searchTpbInvoiceListVO;
	}

	public SearchTPBInvoiceListVO[] getSearchTpbInvoiceListVOS(){
		SearchTPBInvoiceListVO[] rtnVOs = null;
		if (this.searchTpbInvoiceListVOs != null) {
			rtnVOs = Arrays.copyOf(searchTpbInvoiceListVOs, searchTpbInvoiceListVOs.length);
		}
		return rtnVOs;
	}

}