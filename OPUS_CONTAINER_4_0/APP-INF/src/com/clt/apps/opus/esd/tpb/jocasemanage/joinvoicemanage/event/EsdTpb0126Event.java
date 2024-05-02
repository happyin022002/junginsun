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
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.GetIndiaTaxInfoVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSettingVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchJOInvoiceManageListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchOtsGrpInfoVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchThirdPartyInfoVO;
import com.clt.framework.support.layer.event.EventSupport;


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
		if(searchJOInvoiceManageListVOs != null){
			SearchJOInvoiceManageListVO[] tmpVOs = Arrays.copyOf(searchJOInvoiceManageListVOs, searchJOInvoiceManageListVOs.length);
			this.searchJOInvoiceManageListVOs = tmpVOs;
		}
	}

	public SearchJOInvoiceManageListVO getSearchJOInvoiceManageListVO(){
		return searchJOInvoiceManageListVO;
	}

	public SearchJOInvoiceManageListVO[] getSearchJOInvoiceManageListVOS(){
		SearchJOInvoiceManageListVO[] rtnVOs = null;
		if (this.searchJOInvoiceManageListVOs != null) {
			rtnVOs = Arrays.copyOf(searchJOInvoiceManageListVOs, searchJOInvoiceManageListVOs.length);
		}
		return rtnVOs;
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

	public SearchThirdPartyInfoVO getSearchThirdPartyInfoVO() {
		return searchThirdPartyInfoVO;
	}

	public void setSearchThirdPartyInfoVO(
			SearchThirdPartyInfoVO searchThirdPartyInfoVO) {
		this.searchThirdPartyInfoVO = searchThirdPartyInfoVO;
	}

	public SearchThirdPartyInfoVO[] getSearchThirdPartyInfoVOs() {
		SearchThirdPartyInfoVO[] rtnVOs = null;
		if (this.searchThirdPartyInfoVOs != null) {
			rtnVOs = Arrays.copyOf(searchThirdPartyInfoVOs, searchThirdPartyInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchThirdPartyInfoVOs(SearchThirdPartyInfoVO[] searchThirdPartyInfoVOs){
		if(searchThirdPartyInfoVOs != null){
			SearchThirdPartyInfoVO[] tmpVOs = Arrays.copyOf(searchThirdPartyInfoVOs, searchThirdPartyInfoVOs.length);
			this.searchThirdPartyInfoVOs = tmpVOs;
		}
	}

	public SearchOtsGrpInfoVO getSearchOtsGrpInfoVO() {
		return searchOtsGrpInfoVO;
	}

	public void setSearchOtsGrpInfoVO(SearchOtsGrpInfoVO searchOtsGrpInfoVO) {
		this.searchOtsGrpInfoVO = searchOtsGrpInfoVO;
	}

	public SearchOtsGrpInfoVO[] getSearchOtsGrpInfoVOs() {
		SearchOtsGrpInfoVO[] rtnVOs = null;
		if (this.searchOtsGrpInfoVOs != null) {
			rtnVOs = Arrays.copyOf(searchOtsGrpInfoVOs, searchOtsGrpInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchOtsGrpInfoVOs(SearchOtsGrpInfoVO[] searchOtsGrpInfoVOs){
		if(searchOtsGrpInfoVOs != null){
			SearchOtsGrpInfoVO[] tmpVOs = Arrays.copyOf(searchOtsGrpInfoVOs, searchOtsGrpInfoVOs.length);
			this.searchOtsGrpInfoVOs = tmpVOs;
		}
	}

	public SearchOutstandingDetailListForInvoiceCreationVO getSearchOutstandingDetailListForInvoiceCreationVO() {
		return searchOutstandingDetailListForInvoiceCreationVO;
	}

	public void setSearchOutstandingDetailListForInvoiceCreationVO(
			SearchOutstandingDetailListForInvoiceCreationVO searchOutstandingDetailListForInvoiceCreationVO) {
		this.searchOutstandingDetailListForInvoiceCreationVO = searchOutstandingDetailListForInvoiceCreationVO;
	}

	public SearchOutstandingDetailListForInvoiceCreationVO[] getSearchOutstandingDetailListForInvoiceCreationVOs() {
		SearchOutstandingDetailListForInvoiceCreationVO[] rtnVOs = null;
		if (this.searchOutstandingDetailListForInvoiceCreationVOs != null) {
			rtnVOs = Arrays.copyOf(searchOutstandingDetailListForInvoiceCreationVOs, searchOutstandingDetailListForInvoiceCreationVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchOutstandingDetailListForInvoiceCreationVOs(SearchOutstandingDetailListForInvoiceCreationVO[] searchOutstandingDetailListForInvoiceCreationVOs){
		if(searchOutstandingDetailListForInvoiceCreationVOs != null){
			SearchOutstandingDetailListForInvoiceCreationVO[] tmpVOs = Arrays.copyOf(searchOutstandingDetailListForInvoiceCreationVOs, searchOutstandingDetailListForInvoiceCreationVOs.length);
			this.searchOutstandingDetailListForInvoiceCreationVOs = tmpVOs;
		}
	}

	public SearchInvoiceSettingVO getSearchInvoiceSettingVO() {
		return searchInvoiceSettingVO;
	}

	public void setSearchInvoiceSettingVO(
			SearchInvoiceSettingVO searchInvoiceSettingVO) {
		this.searchInvoiceSettingVO = searchInvoiceSettingVO;
	}

	public SearchInvoiceSettingVO[] getSearchInvoiceSettingVOs() {
		SearchInvoiceSettingVO[] rtnVOs = null;
		if (this.searchInvoiceSettingVOs != null) {
			rtnVOs = Arrays.copyOf(searchInvoiceSettingVOs, searchInvoiceSettingVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInvoiceSettingVOs(SearchInvoiceSettingVO[] searchInvoiceSettingVOs){
		if(searchInvoiceSettingVOs != null){
			SearchInvoiceSettingVO[] tmpVOs = Arrays.copyOf(searchInvoiceSettingVOs, searchInvoiceSettingVOs.length);
			this.searchInvoiceSettingVOs = tmpVOs;
		}
	}

	public GetIndiaTaxInfoVO getGetIndiaTaxInfoVO() {
		return getIndiaTaxInfoVO;
	}

	public void setGetIndiaTaxInfoVO(GetIndiaTaxInfoVO getIndiaTaxInfoVO) {
		this.getIndiaTaxInfoVO = getIndiaTaxInfoVO;
	}

	public GetIndiaTaxInfoVO[] getGetIndiaTaxInfoVOs() {
		GetIndiaTaxInfoVO[] rtnVOs = null;
		if (this.getIndiaTaxInfoVOs != null) {
			rtnVOs = Arrays.copyOf(getIndiaTaxInfoVOs, getIndiaTaxInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setGetIndiaTaxInfoVOs(GetIndiaTaxInfoVO[] getIndiaTaxInfoVOs){
		if(getIndiaTaxInfoVOs != null){
			GetIndiaTaxInfoVO[] tmpVOs = Arrays.copyOf(getIndiaTaxInfoVOs, getIndiaTaxInfoVOs.length);
			this.getIndiaTaxInfoVOs = tmpVOs;
		}
	}

	public SearchInvoiceSheetSetVO getSearchInvoiceSheetSetVO() {
		return searchInvoiceSheetSetVO;
	}

	public void setSearchInvoiceSheetSetVO(
			SearchInvoiceSheetSetVO searchInvoiceSheetSetVO) {
		this.searchInvoiceSheetSetVO = searchInvoiceSheetSetVO;
	}

	public SearchInvoiceSheetSetVO[] getSearchInvoiceSheetSetVOs() {
		SearchInvoiceSheetSetVO[] rtnVOs = null;
		if (this.searchInvoiceSheetSetVOs != null) {
			rtnVOs = Arrays.copyOf(searchInvoiceSheetSetVOs, searchInvoiceSheetSetVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInvoiceSheetSetVOs(SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVOs){
		if(searchInvoiceSheetSetVOs != null){
			SearchInvoiceSheetSetVO[] tmpVOs = Arrays.copyOf(searchInvoiceSheetSetVOs, searchInvoiceSheetSetVOs.length);
			this.searchInvoiceSheetSetVOs = tmpVOs;
		}
	}

}