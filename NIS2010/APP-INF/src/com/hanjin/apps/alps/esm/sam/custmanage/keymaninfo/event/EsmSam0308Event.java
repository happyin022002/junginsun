/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : EsmSam0003Event.java
*@FileTitle : KeyMan Info Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.05.09 이창원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.vo.SamKeyManInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SAM_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEECHAGNWON
 * @see ESM_SAM_0003HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSam0308Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerVO searchCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerVO[] searchCustomerVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamKeyManInfoVO samKeyManInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamKeyManInfoVO[] samKeyManInfoVOs = null;
	
	private String hiddencustNm = null;

	public String getHiddencustNm() {
		return hiddencustNm;
	}

	public void setHiddencustNm(String hiddencustNm) {
		this.hiddencustNm = hiddencustNm;
	}
	
	public EsmSam0308Event(){}
	
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

	public SamKeyManInfoVO getSamKeyManInfoVO() {
		return samKeyManInfoVO;
	}

	public void setSamKeyManInfoVO(SamKeyManInfoVO samKeyManInfoVO) {
		this.samKeyManInfoVO = samKeyManInfoVO;
	}

	public SamKeyManInfoVO[] getSamKeyManInfoVOs() {
		SamKeyManInfoVO[] rtnVOs = null;
		if (this.samKeyManInfoVOs != null) {
			rtnVOs = Arrays.copyOf(samKeyManInfoVOs, samKeyManInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSamKeyManInfoVOs(SamKeyManInfoVO[] samKeyManInfoVOs) {
		if(samKeyManInfoVOs != null){
			SamKeyManInfoVO[] tmpVOs = Arrays.copyOf(samKeyManInfoVOs, samKeyManInfoVOs.length);
			this.samKeyManInfoVOs = tmpVOs;
		}
	}

}