/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0900Event.java
*@FileTitle : Change Sales Rep
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.CustomsCustomerVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_SAM_0900 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0900HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEECHANGWON
 * @see ESM_SAM_0900HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0900Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CustomsCustomerVO customsCustomerVO = null;

	/** Table Value Object Multi Data 처리 */
	private CustomsCustomerVO[] customsCustomerVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerVO searchCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerVO[] searchCustomerVOs = null;
	
	private BkgSalesRepVO bkgSalesRepVO = null;
	
	private BkgSalesRepVO[] bkgSalesRepVOs = null;
	
	private String key = null;

	public EsmSam0900Event(){}
	
	public void setSearchCustomerVO(SearchCustomerVO searchCustomerVO){
		this. searchCustomerVO = searchCustomerVO;
	}

	public void setSearchCustomerVOS(SearchCustomerVO[] searchCustomerVOs){
		if(searchCustomerVOs != null){
			SearchCustomerVO[] tmpVOs = Arrays.copyOf(searchCustomerVOs, searchCustomerVOs.length);
			this.searchCustomerVOs  = tmpVOs;
		}
	}

	public SearchCustomerVO getSearchCustomerVO(){
		return searchCustomerVO;
	}

	public SearchCustomerVO[] getSearchCustomerVOS(){
		SearchCustomerVO[] rtnVOs = null;
		if (this.searchCustomerVOs != null) {
			rtnVOs = Arrays.copyOf(searchCustomerVOs, searchCustomerVOs.length);
		}
		return rtnVOs;
	}
	
	public void setBkgSalesRepVO(BkgSalesRepVO bkgSalesRepVO){
		this. bkgSalesRepVO = bkgSalesRepVO;
	}

	public void setBkgSalesRepVOS(BkgSalesRepVO[] bkgSalesRepVOs){
		if(bkgSalesRepVOs != null){
			BkgSalesRepVO[] tmpVOs = Arrays.copyOf(bkgSalesRepVOs, bkgSalesRepVOs.length);
			this.bkgSalesRepVOs = tmpVOs;
		}
	}

	public BkgSalesRepVO getBkgSalesRepVO(){
		return bkgSalesRepVO;
	}

	public BkgSalesRepVO[] getBkgSalesRepVOS(){
		BkgSalesRepVO[] rtnVOs = null;
		if (this.bkgSalesRepVOs != null) {
			rtnVOs = Arrays.copyOf(bkgSalesRepVOs, bkgSalesRepVOs.length);
		}
		return rtnVOs;
	}
	
	
	public void setCustomsCustomerVO(CustomsCustomerVO customsCustomerVO){
		this.customsCustomerVO = customsCustomerVO;
	}
	
	public void setSearchCustomerVOS(CustomsCustomerVO[] customsCustomerVO){
		this.customsCustomerVOs = customsCustomerVOs;
	}


	public CustomsCustomerVO getCustomsCustomerVO(){
		return customsCustomerVO;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	

}