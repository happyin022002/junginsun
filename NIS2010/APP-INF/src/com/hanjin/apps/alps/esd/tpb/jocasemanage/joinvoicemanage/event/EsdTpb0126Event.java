/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0126Event.java
*@FileTitle : JOInvoiceManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.GetIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchJOInvoiceManageListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchOtsGrpInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchThirdPartyInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0126 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0126HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0126HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0126Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchJOInvoiceManageListVO searchJOInvoiceManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchJOInvoiceManageListVO[] searchJOInvoiceManageListVOs = null;
	
	private InvoiceCreationVO invoiceCreationVO = null;
	
	private InvoiceCreationVO[] invoiceCreationVOs = null;
	
	private SearchThirdPartyInfoVO searchThirdPartyInfoVO = null;
	
	private SearchThirdPartyInfoVO[] searchThirdPartyInfoVOs = null;
	
	private SearchOtsGrpInfoVO searchOtsGrpInfoVO = null;
	
	private SearchOtsGrpInfoVO[] searchOtsGrpInfoVOs = null;
	
	private SearchInvoiceSettingVO searchInvoiceSettingVO = null;
	
	private SearchInvoiceSettingVO[] searchInvoiceSettingVOs = null;
	
	private GetIndiaTaxInfoVO getIndiaTaxInfoVO = null;
	
	private GetIndiaTaxInfoVO[] getIndiaTaxInfoVOs = null;
	
	private SearchInvoiceSheetSetVO searchInvoiceSheetSetVO = null;
	
	private SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVOs = null;
	
	
	
	
	
	private SearchOutstandingDetailListForInvoiceCreationVO searchOutstandingDetailListForInvoiceCreationVO = null;
	
	private SearchOutstandingDetailListForInvoiceCreationVO[] searchOutstandingDetailListForInvoiceCreationVOs = null;
	

	public EsdTpb0126Event(){}
	
	public void setSearchJOInvoiceManageListVO(SearchJOInvoiceManageListVO searchJOInvoiceManageListVO){
		this. searchJOInvoiceManageListVO = searchJOInvoiceManageListVO;
	}

	public void setSearchJOInvoiceManageListVOS(SearchJOInvoiceManageListVO[] searchJOInvoiceManageListVOs){
		this. searchJOInvoiceManageListVOs = searchJOInvoiceManageListVOs;
	}

	public SearchJOInvoiceManageListVO getSearchJOInvoiceManageListVO(){
		return searchJOInvoiceManageListVO;
	}

	public SearchJOInvoiceManageListVO[] getSearchJOInvoiceManageListVOS(){
		return searchJOInvoiceManageListVOs;
	}

	public InvoiceCreationVO getInvoiceCreationVO() {
		return invoiceCreationVO;
	}

	public void setInvoiceCreationVO(InvoiceCreationVO invoiceCreationVO) {
		this.invoiceCreationVO = invoiceCreationVO;
	}

	public InvoiceCreationVO[] getInvoiceCreationVOs() {
		return invoiceCreationVOs;
	}

	public void setInvoiceCreationVOs(InvoiceCreationVO[] invoiceCreationVOs) {
		this.invoiceCreationVOs = invoiceCreationVOs;
	}

	public SearchThirdPartyInfoVO getSearchThirdPartyInfoVO() {
		return searchThirdPartyInfoVO;
	}

	public void setSearchThirdPartyInfoVO(
			SearchThirdPartyInfoVO searchThirdPartyInfoVO) {
		this.searchThirdPartyInfoVO = searchThirdPartyInfoVO;
	}

	public SearchThirdPartyInfoVO[] getSearchThirdPartyInfoVOs() {
		return searchThirdPartyInfoVOs;
	}

	public void setSearchThirdPartyInfoVOs(
			SearchThirdPartyInfoVO[] searchThirdPartyInfoVOs) {
		this.searchThirdPartyInfoVOs = searchThirdPartyInfoVOs;
	}

	public SearchOtsGrpInfoVO getSearchOtsGrpInfoVO() {
		return searchOtsGrpInfoVO;
	}

	public void setSearchOtsGrpInfoVO(SearchOtsGrpInfoVO searchOtsGrpInfoVO) {
		this.searchOtsGrpInfoVO = searchOtsGrpInfoVO;
	}

	public SearchOtsGrpInfoVO[] getSearchOtsGrpInfoVOs() {
		return searchOtsGrpInfoVOs;
	}

	public void setSearchOtsGrpInfoVOs(SearchOtsGrpInfoVO[] searchOtsGrpInfoVOs) {
		this.searchOtsGrpInfoVOs = searchOtsGrpInfoVOs;
	}

	public SearchOutstandingDetailListForInvoiceCreationVO getSearchOutstandingDetailListForInvoiceCreationVO() {
		return searchOutstandingDetailListForInvoiceCreationVO;
	}

	public void setSearchOutstandingDetailListForInvoiceCreationVO(
			SearchOutstandingDetailListForInvoiceCreationVO searchOutstandingDetailListForInvoiceCreationVO) {
		this.searchOutstandingDetailListForInvoiceCreationVO = searchOutstandingDetailListForInvoiceCreationVO;
	}

	public SearchOutstandingDetailListForInvoiceCreationVO[] getSearchOutstandingDetailListForInvoiceCreationVOs() {
		return searchOutstandingDetailListForInvoiceCreationVOs;
	}

	public void setSearchOutstandingDetailListForInvoiceCreationVOs(
			SearchOutstandingDetailListForInvoiceCreationVO[] searchOutstandingDetailListForInvoiceCreationVOs) {
		this.searchOutstandingDetailListForInvoiceCreationVOs = searchOutstandingDetailListForInvoiceCreationVOs;
	}

	public SearchInvoiceSettingVO getSearchInvoiceSettingVO() {
		return searchInvoiceSettingVO;
	}

	public void setSearchInvoiceSettingVO(
			SearchInvoiceSettingVO searchInvoiceSettingVO) {
		this.searchInvoiceSettingVO = searchInvoiceSettingVO;
	}

	public SearchInvoiceSettingVO[] getSearchInvoiceSettingVOs() {
		return searchInvoiceSettingVOs;
	}

	public void setSearchInvoiceSettingVOs(
			SearchInvoiceSettingVO[] searchInvoiceSettingVOs) {
		this.searchInvoiceSettingVOs = searchInvoiceSettingVOs;
	}

	public GetIndiaTaxInfoVO getGetIndiaTaxInfoVO() {
		return getIndiaTaxInfoVO;
	}

	public void setGetIndiaTaxInfoVO(GetIndiaTaxInfoVO getIndiaTaxInfoVO) {
		this.getIndiaTaxInfoVO = getIndiaTaxInfoVO;
	}

	public GetIndiaTaxInfoVO[] getGetIndiaTaxInfoVOs() {
		return getIndiaTaxInfoVOs;
	}

	public void setGetIndiaTaxInfoVOs(GetIndiaTaxInfoVO[] getIndiaTaxInfoVOs) {
		this.getIndiaTaxInfoVOs = getIndiaTaxInfoVOs;
	}

	public SearchInvoiceSheetSetVO getSearchInvoiceSheetSetVO() {
		return searchInvoiceSheetSetVO;
	}

	public void setSearchInvoiceSheetSetVO(
			SearchInvoiceSheetSetVO searchInvoiceSheetSetVO) {
		this.searchInvoiceSheetSetVO = searchInvoiceSheetSetVO;
	}

	public SearchInvoiceSheetSetVO[] getSearchInvoiceSheetSetVOs() {
		return searchInvoiceSheetSetVOs;
	}

	public void setSearchInvoiceSheetSetVOs(
			SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVOs) {
		this.searchInvoiceSheetSetVOs = searchInvoiceSheetSetVOs;
	}

}