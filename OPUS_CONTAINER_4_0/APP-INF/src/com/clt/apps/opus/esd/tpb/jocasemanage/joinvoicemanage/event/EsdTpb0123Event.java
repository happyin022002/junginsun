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
* 2009-10-26 Jong-Geon Byeon	1.1 Renewal Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.clt.framework.support.layer.event.EventSupport;


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
		if(searchInvoiceSheetSetVOs != null){
			SearchInvoiceSheetSetVO[] tmpVOs = Arrays.copyOf(searchInvoiceSheetSetVOs, searchInvoiceSheetSetVOs.length);
			this.searchInvoiceSheetSetVOs = tmpVOs;
		}
	}

	public SearchInvoiceSheetSetVO getSearchInvoiceSheetSetVO(){
		return searchInvoiceSheetSetVO;
	}

	public SearchInvoiceSheetSetVO[] getSearchInvoiceSheetSetVOS(){
		SearchInvoiceSheetSetVO[] rtnVOs = null;
		if (this.searchInvoiceSheetSetVOs != null) {
			rtnVOs = Arrays.copyOf(searchInvoiceSheetSetVOs, searchInvoiceSheetSetVOs.length);
		}
		return rtnVOs;
	}

}