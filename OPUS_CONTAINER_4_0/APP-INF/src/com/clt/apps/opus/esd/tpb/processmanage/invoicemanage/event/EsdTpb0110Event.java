/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0110Event.java
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
import java.util.Map;

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.GetIndiaTaxInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchOtsGrpInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchThirdPartyInfoVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * ESD_TPB_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0110HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceManageListVO searchInvoiceManageListVO = null;
	
	private InvoiceCreationVO invoiceCreationVO = null;
	
	private SearchOutstandingDetailListForInvoiceCreationVO searchOutstandingDetailListForInvoiceCreationVO = null;

	private SearchOtsGrpInfoVO searchOtsGrpInfoVO = null;
	
	private GetIndiaTaxInfoVO getIndiaTaxInfoVO = null;
	
	private SearchInvoiceSettingVO searchInvoiceSettingVO = null;
	
	private SearchThirdPartyInfoVO searchThirdPartyInfoVO = null;

	
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceManageListVO[] searchInvoiceManageListVOs = null;
	
	private InvoiceCreationVO[] invoiceCreationVOs = null;
	
	private SearchOutstandingDetailListForInvoiceCreationVO[] searchOutstandingDetailListForInvoiceCreationVOs = null;

	private SearchOtsGrpInfoVO[] searchOtsGrpInfoVOs = null;
	
	private GetIndiaTaxInfoVO[] getIndiaTaxInfoVOs = null;
	
	private SearchInvoiceSettingVO[] searchInvoiceSettingVOs = null;
	
	private SearchThirdPartyInfoVO[] searchThirdPartyInfoVOs = null;
	
	public EsdTpb0110Event(){}
	
	Map<String,String> rowSetOtsGrpInfo = null;
	
	Map<String,String> rowSetIndiaTaxInfo = null;
	
	Map<String,String> gridValue = null;
	
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


	public InvoiceCreationVO getInvoiceCreationVO() {
		return invoiceCreationVO;
	}

	public void setInvoiceCreationVO(InvoiceCreationVO invoiceCreationVO) {
		this.invoiceCreationVO = invoiceCreationVO;
	}

	public SearchOutstandingDetailListForInvoiceCreationVO getSearchOutstandingDetailListForInvoiceCreationVO() {
		return searchOutstandingDetailListForInvoiceCreationVO;
	}

	public void setSearchOutstandingDetailListForInvoiceCreationVO(
			SearchOutstandingDetailListForInvoiceCreationVO searchOutstandingDetailListForInvoiceCreationVO) {
		this.searchOutstandingDetailListForInvoiceCreationVO = searchOutstandingDetailListForInvoiceCreationVO;
	}
	
	public void setSearchOutstandingDetailListForInvoiceCreationVO(
			SearchOutstandingDetailListForInvoiceCreationVO searchOutstandingDetailListForInvoiceCreationVO, String prefix) {
		this.searchOutstandingDetailListForInvoiceCreationVO = searchOutstandingDetailListForInvoiceCreationVO;
	}

	public SearchOtsGrpInfoVO getSearchOtsGrpInfoVO() {
		return searchOtsGrpInfoVO;
	}

	public void setSearchOtsGrpInfoVO(SearchOtsGrpInfoVO searchOtsGrpInfoVO) {
		this.searchOtsGrpInfoVO = searchOtsGrpInfoVO;
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

	public Map<String, String> getRowSetOtsGrpInfo() {
		return rowSetOtsGrpInfo;
	}
	
	public void setRowSetOtsGrpInfo(Map<String, String> rowSetOtsGrpInfo) {
		this.rowSetOtsGrpInfo = rowSetOtsGrpInfo;
	}

	public Map<String, String> getRowSetIndiaTaxInfo() {
		return rowSetIndiaTaxInfo;
	}

	public void setRowSetIndiaTaxInfo(Map<String, String> rowSetIndiaTaxInfo) {
		this.rowSetIndiaTaxInfo = rowSetIndiaTaxInfo;
	}

	public Map<String, String> getGridValue() {
		return gridValue;
	}

	public void setGridValue(Map<String, String> gridValue) {
		this.gridValue = gridValue;
	}
	
	
	

}