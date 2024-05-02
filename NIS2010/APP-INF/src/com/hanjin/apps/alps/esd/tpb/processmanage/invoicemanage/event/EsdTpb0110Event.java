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
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event;

import java.util.Map;

import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.GetIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOtsGrpInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchThirdPartyInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;



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
		this. searchInvoiceManageListVOs = searchInvoiceManageListVOs;
	}

	public SearchInvoiceManageListVO getSearchInvoiceManageListVO(){
		return searchInvoiceManageListVO;
	}

	public SearchInvoiceManageListVO[] getSearchInvoiceManageListVOS(){
		return searchInvoiceManageListVOs;
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
		return invoiceCreationVOs;
	}

	public void setInvoiceCreationVOs(InvoiceCreationVO[] invoiceCreationVOs) {
		this.invoiceCreationVOs = invoiceCreationVOs;
	}

	public SearchOutstandingDetailListForInvoiceCreationVO[] getSearchOutstandingDetailListForInvoiceCreationVOs() {
		return searchOutstandingDetailListForInvoiceCreationVOs;
	}

	public void setSearchOutstandingDetailListForInvoiceCreationVOs(
			SearchOutstandingDetailListForInvoiceCreationVO[] searchOutstandingDetailListForInvoiceCreationVOs) {
		this.searchOutstandingDetailListForInvoiceCreationVOs = searchOutstandingDetailListForInvoiceCreationVOs;
	}

	public SearchOtsGrpInfoVO[] getSearchOtsGrpInfoVOs() {
		return searchOtsGrpInfoVOs;
	}

	public void setSearchOtsGrpInfoVOs(SearchOtsGrpInfoVO[] searchOtsGrpInfoVOs) {
		this.searchOtsGrpInfoVOs = searchOtsGrpInfoVOs;
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