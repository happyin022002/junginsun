/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0111Event.java
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

import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0111HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0111Event extends EventSupport {

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
	
	

	public EsdTpb0111Event(){}
	
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

	public InvoiceDetailListForRevisionVO getInvoiceDetailListForRevisionVO() {
		return invoiceDetailListForRevisionVO;
	}

	public void setInvoiceDetailListForRevisionVO(
			InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO) {
		this.invoiceDetailListForRevisionVO = invoiceDetailListForRevisionVO;
	}

	public InvoiceDetailListForRevisionVO[] getInvoiceDetailListForRevisionVOs() {
		return invoiceDetailListForRevisionVOs;
	}

	public void setInvoiceDetailListForRevisionVOs(
			InvoiceDetailListForRevisionVO[] invoiceDetailListForRevisionVOs) {
		this.invoiceDetailListForRevisionVOs = invoiceDetailListForRevisionVOs;
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

	public SearchInvoiceDefaultDataVO getSearchInvoiceDefaultDataVO() {
		return searchInvoiceDefaultDataVO;
	}

	public void setSearchInvoiceDefaultDataVO(
			SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO) {
		this.searchInvoiceDefaultDataVO = searchInvoiceDefaultDataVO;
	}

	public SearchInvoiceDefaultDataVO[] getSearchInvoiceDefaultDataVOs() {
		return searchInvoiceDefaultDataVOs;
	}

	public void setSearchInvoiceDefaultDataVOs(
			SearchInvoiceDefaultDataVO[] searchInvoiceDefaultDataVOs) {
		this.searchInvoiceDefaultDataVOs = searchInvoiceDefaultDataVOs;
	}



}