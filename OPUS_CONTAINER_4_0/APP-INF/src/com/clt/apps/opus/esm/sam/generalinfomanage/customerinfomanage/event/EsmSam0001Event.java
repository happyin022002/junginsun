/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0001Event.java
*@FileTitle : Customer List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustCoverTeamVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * ESM_SAM_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONGJINHO
 * @see ESM_SAM_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerVO searchCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerVO[] searchCustomerVOs = null;
	private CustCoverTeamVO[] custCoverTeamVOs = null;
	
	private String creOfcCd = null;

	public String getCreOfcCd() {
		return creOfcCd;
	}

	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	public EsmSam0001Event(){}
	
	public void setSearchCustomerVO(SearchCustomerVO searchCustomerVO){
		this. searchCustomerVO = searchCustomerVO;
	}

	public void setSearchCustomerVOS(SearchCustomerVO[] searchCustomerVOs){
		if(searchCustomerVOs != null){
			SearchCustomerVO[] tmpVOs = Arrays.copyOf(searchCustomerVOs, searchCustomerVOs.length);
			this.searchCustomerVOs = tmpVOs;
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

	public CustCoverTeamVO[] getCustCoverTeamVOs() {
		CustCoverTeamVO[] rtnVOs = null;
		if (this.custCoverTeamVOs != null) {
			rtnVOs = Arrays.copyOf(custCoverTeamVOs, custCoverTeamVOs.length);
		}
		return rtnVOs;
	}

	public void setCustCoverTeamVOs(CustCoverTeamVO[] custCoverTeamVOs) {
		if(custCoverTeamVOs != null){
			CustCoverTeamVO[] tmpVOs = Arrays.copyOf(custCoverTeamVOs, custCoverTeamVOs.length);
			this.custCoverTeamVOs = tmpVOs;
		}
	}
	
	

}