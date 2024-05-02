/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0123Event.java
*@FileTitle : JOInvoiceManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-26
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-23 Kim Jin-seung 		1.0  최초 생성
* 2009-10-26 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0123HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceSheetSetVO searchInvoiceSheetSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVOs = null;

	public EsdTpb0123Event(){}
	
	public void setSearchInvoiceSheetSetVO(SearchInvoiceSheetSetVO searchInvoiceSheetSetVO){
		this. searchInvoiceSheetSetVO = searchInvoiceSheetSetVO;
	}

	public void setSearchInvoiceSheetSetVOS(SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVOs){
		this. searchInvoiceSheetSetVOs = searchInvoiceSheetSetVOs;
	}

	public SearchInvoiceSheetSetVO getSearchInvoiceSheetSetVO(){
		return searchInvoiceSheetSetVO;
	}

	public SearchInvoiceSheetSetVO[] getSearchInvoiceSheetSetVOS(){
		return searchInvoiceSheetSetVOs;
	}

}