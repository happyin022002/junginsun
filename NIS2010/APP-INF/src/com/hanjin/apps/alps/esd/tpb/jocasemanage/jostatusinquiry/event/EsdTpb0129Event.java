/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0129Event.java
*@FileTitle : JO TPB Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-05
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-09-16 O Wan-Ki 			1.0	최초 생성
* 2009-10-05 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.event;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOInvoiceListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0129 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0129HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0129HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0129Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchJOInvoiceListVO searchJOInvoiceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchJOInvoiceListVO[] searchJOInvoiceListVOs = null;

	public EsdTpb0129Event(){}
	
	public void setSearchJOInvoiceListVO(SearchJOInvoiceListVO searchJOInvoiceListVO){
		this. searchJOInvoiceListVO = searchJOInvoiceListVO;
	}

	public void setSearchJOInvoiceListVOS(SearchJOInvoiceListVO[] searchJOInvoiceListVOs){
		this. searchJOInvoiceListVOs = searchJOInvoiceListVOs;
	}

	public SearchJOInvoiceListVO getSearchJOInvoiceListVO(){
		return searchJOInvoiceListVO;
	}

	public SearchJOInvoiceListVO[] getSearchJOInvoiceListVOS(){
		return searchJOInvoiceListVOs;
	}

}