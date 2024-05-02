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
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event;
 
import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.clt.framework.support.layer.event.EventSupport;


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



}