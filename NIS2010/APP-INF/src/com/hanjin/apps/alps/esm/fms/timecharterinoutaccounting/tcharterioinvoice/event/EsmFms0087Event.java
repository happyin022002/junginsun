/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0087Event.java
*@FileTitle :GL Inquiry of Owner's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 전상화
*@LastVersion : 1.0
* 2009.06.18 전상화
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceAutoMatchVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnrAcctSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  Jean Sang Wha
 * @see ESM_FMS_0087HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchOwnerInvoiceVO[] condSearchOwnerInvoiceVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomOwnrAcctSlpVO customOwnrAcctSlpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomOwnrAcctSlpVO[] customOwnrAcctSlpVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchOwnerInvoiceAutoMatchVO[] condSearchOwnerInvoiceAutoMatchVOs = null;
	
	private SearchOwnerInvoiceListVO[] searchOwnerInvoiceListVOs = null;
	
	/** 검색구분 **/
	private String searchType = null;
	
	public EsmFms0087Event(){}
	
	public void setCondSearchOwnerInvoiceVO(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO){
		this. condSearchOwnerInvoiceVO = condSearchOwnerInvoiceVO;
	}

	public void setCondSearchOwnerInvoiceVOS(CondSearchOwnerInvoiceVO[] condSearchOwnerInvoiceVOs){
		if (condSearchOwnerInvoiceVOs != null) {
			CondSearchOwnerInvoiceVO[] tmpVOs = Arrays.copyOf(condSearchOwnerInvoiceVOs, condSearchOwnerInvoiceVOs.length);
			this.condSearchOwnerInvoiceVOs = tmpVOs;
		}
	}

	public CondSearchOwnerInvoiceVO getCondSearchOwnerInvoiceVO(){
		return condSearchOwnerInvoiceVO;
	}

	public CondSearchOwnerInvoiceVO[] getCondSearchOwnerInvoiceVOS(){
		CondSearchOwnerInvoiceVO[] rtnVOs = null;
		if (this.condSearchOwnerInvoiceVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchOwnerInvoiceVOs, condSearchOwnerInvoiceVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomOwnrAcctSlpVO(CustomOwnrAcctSlpVO customOwnrAcctSlpVO){
		this. customOwnrAcctSlpVO = customOwnrAcctSlpVO;
	}

	public void setCustomOwnrAcctSlpVOS(CustomOwnrAcctSlpVO[] customOwnrAcctSlpVOs){
		if (customOwnrAcctSlpVOs != null) {
			CustomOwnrAcctSlpVO[] tmpVOs = Arrays.copyOf(customOwnrAcctSlpVOs, customOwnrAcctSlpVOs.length);
			this.customOwnrAcctSlpVOs = tmpVOs;
		}
	}

	public CustomOwnrAcctSlpVO getCustomOwnrAcctSlpVO(){
		return customOwnrAcctSlpVO;
	}

	public CustomOwnrAcctSlpVO[] getCustomOwnrAcctSlpVOS(){
		CustomOwnrAcctSlpVO[] rtnVOs = null;
		if (this.customOwnrAcctSlpVOs != null) {
			rtnVOs = Arrays.copyOf(customOwnrAcctSlpVOs, customOwnrAcctSlpVOs.length);
		}
		return rtnVOs;
	}

	public void setCondSearchOwnerInvoiceAutoMatchVO(CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO){
		this. condSearchOwnerInvoiceAutoMatchVO = condSearchOwnerInvoiceAutoMatchVO;
	}

	public void setCondSearchOwnerInvoiceAutoMatchVOS(CondSearchOwnerInvoiceAutoMatchVO[] condSearchOwnerInvoiceAutoMatchVOs){
		if (condSearchOwnerInvoiceAutoMatchVOs != null) {
			CondSearchOwnerInvoiceAutoMatchVO[] tmpVOs = Arrays.copyOf(condSearchOwnerInvoiceAutoMatchVOs, condSearchOwnerInvoiceAutoMatchVOs.length);
			this.condSearchOwnerInvoiceAutoMatchVOs = tmpVOs;
		}
	}
	
	public void setSearchOwnerInvoiceListVOS(SearchOwnerInvoiceListVO[] searchOwnerInvoiceListVOs){
		if (searchOwnerInvoiceListVOs != null) {
			SearchOwnerInvoiceListVO[] tmpVOs = Arrays.copyOf(searchOwnerInvoiceListVOs, searchOwnerInvoiceListVOs.length);
			this.searchOwnerInvoiceListVOs = tmpVOs;
		}
	}

	public CondSearchOwnerInvoiceAutoMatchVO getCondSearchOwnerInvoiceAutoMatchVO(){
		return condSearchOwnerInvoiceAutoMatchVO;
	}

	public CondSearchOwnerInvoiceAutoMatchVO[] getCondSearchOwnerInvoiceAutoMatchVOS(){
		CondSearchOwnerInvoiceAutoMatchVO[] rtnVOs = null;
		if (this.condSearchOwnerInvoiceAutoMatchVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchOwnerInvoiceAutoMatchVOs, condSearchOwnerInvoiceAutoMatchVOs.length);
		}
		return rtnVOs;
	}
	
	public SearchOwnerInvoiceListVO[] getSearchOwnerInvoiceListVOS(){
		SearchOwnerInvoiceListVO[] rtnVOs = null;
		if (this.searchOwnerInvoiceListVOs != null) {
			rtnVOs = Arrays.copyOf(searchOwnerInvoiceListVOs, searchOwnerInvoiceListVOs.length);
		}
		return rtnVOs;
	}
	
	public String getSearchType(){
		return searchType;
	}
	
	public void setSearchType(String searchType){
		this. searchType = searchType;
	}
}