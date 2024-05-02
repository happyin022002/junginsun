/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0127Event.java
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

import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceManageListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSettingVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchJOInvoiceManageListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0127 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0127HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0127HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0127Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceManageListVO searchInvoiceManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceManageListVO[] searchInvoiceManageListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoiceDetailListForRevisionVO[] invoiceDetailListForRevisionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceSettingVO searchInvoiceSettingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceSettingVO[] searchInvoiceSettingVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceCreationVO invoiceCreationVO = null;

	/** Table Value Object Multi Data 처리 */
	private InvoiceCreationVO[] invoiceCreationVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceDefaultDataVO[] searchInvoiceDefaultDataVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInvoiceSheetSetVO searchInvoiceSheetSetVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchJOInvoiceManageListVO searchJOInvoiceManageListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchJOInvoiceManageListVO[] searchJOInvoiceManageListVOs = null;
	
	

	public EsdTpb0127Event(){}

	public SearchInvoiceManageListVO getSearchInvoiceManageListVO() {
		return searchInvoiceManageListVO;
	}

	public void setSearchInvoiceManageListVO(
			SearchInvoiceManageListVO searchInvoiceManageListVO) {
		this.searchInvoiceManageListVO = searchInvoiceManageListVO;
	}

	public SearchInvoiceManageListVO[] getSearchInvoiceManageListVOs() {
		SearchInvoiceManageListVO[] rtnVOs = null;
		if (this.searchInvoiceManageListVOs != null) {
			rtnVOs = Arrays.copyOf(searchInvoiceManageListVOs, searchInvoiceManageListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInvoiceManageListVOs(SearchInvoiceManageListVO[] searchInvoiceManageListVOs){
		if(searchInvoiceManageListVOs != null){
			SearchInvoiceManageListVO[] tmpVOs = Arrays.copyOf(searchInvoiceManageListVOs, searchInvoiceManageListVOs.length);
			this.searchInvoiceManageListVOs = tmpVOs;
		}
	}

	public InvoiceDetailListForRevisionVO getInvoiceDetailListForRevisionVO() {
		return invoiceDetailListForRevisionVO;
	}

	public void setInvoiceDetailListForRevisionVO(
			InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO) {
		this.invoiceDetailListForRevisionVO = invoiceDetailListForRevisionVO;
	}

	public InvoiceDetailListForRevisionVO[] getInvoiceDetailListForRevisionVOs() {
		InvoiceDetailListForRevisionVO[] rtnVOs = null;
		if (this.invoiceDetailListForRevisionVOs != null) {
			rtnVOs = Arrays.copyOf(invoiceDetailListForRevisionVOs, invoiceDetailListForRevisionVOs.length);
		}
		return rtnVOs;
	}

	public void setInvoiceDetailListForRevisionVOs(InvoiceDetailListForRevisionVO[] invoiceDetailListForRevisionVOs){
		if(invoiceDetailListForRevisionVOs != null){
			InvoiceDetailListForRevisionVO[] tmpVOs = Arrays.copyOf(invoiceDetailListForRevisionVOs, invoiceDetailListForRevisionVOs.length);
			this.invoiceDetailListForRevisionVOs = tmpVOs;
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

	public SearchInvoiceDefaultDataVO getSearchInvoiceDefaultDataVO() {
		return searchInvoiceDefaultDataVO;
	}

	public void setSearchInvoiceDefaultDataVO(
			SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO) {
		this.searchInvoiceDefaultDataVO = searchInvoiceDefaultDataVO;
	}

	public SearchInvoiceDefaultDataVO[] getSearchInvoiceDefaultDataVOs() {
		SearchInvoiceDefaultDataVO[] rtnVOs = null;
		if (this.searchInvoiceDefaultDataVOs != null) {
			rtnVOs = Arrays.copyOf(searchInvoiceDefaultDataVOs, searchInvoiceDefaultDataVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInvoiceDefaultDataVOs(SearchInvoiceDefaultDataVO[] searchInvoiceDefaultDataVOs){
		if(searchInvoiceDefaultDataVOs != null){
			SearchInvoiceDefaultDataVO[] tmpVOs = Arrays.copyOf(searchInvoiceDefaultDataVOs, searchInvoiceDefaultDataVOs.length);
			this.searchInvoiceDefaultDataVOs = tmpVOs;
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

	public SearchJOInvoiceManageListVO getSearchJOInvoiceManageListVO() {
		return searchJOInvoiceManageListVO;
	}

	public void setSearchJOInvoiceManageListVO(
			SearchJOInvoiceManageListVO searchJOInvoiceManageListVO) {
		this.searchJOInvoiceManageListVO = searchJOInvoiceManageListVO;
	}

	public SearchJOInvoiceManageListVO[] getSearchJOInvoiceManageListVOs() {
		SearchJOInvoiceManageListVO[] rtnVOs = null;
		if (this.searchJOInvoiceManageListVOs != null) {
			rtnVOs = Arrays.copyOf(searchJOInvoiceManageListVOs, searchJOInvoiceManageListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchJOInvoiceManageListVOs(SearchJOInvoiceManageListVO[] searchJOInvoiceManageListVOs){
		if(searchJOInvoiceManageListVOs != null){
			SearchJOInvoiceManageListVO[] tmpVOs = Arrays.copyOf(searchJOInvoiceManageListVOs, searchJOInvoiceManageListVOs.length);
			this.searchJOInvoiceManageListVOs = tmpVOs;
		}
	}
	


}