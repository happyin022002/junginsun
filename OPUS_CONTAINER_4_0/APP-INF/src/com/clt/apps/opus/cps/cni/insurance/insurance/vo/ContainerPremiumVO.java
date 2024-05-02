/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerPremiumVO.java
*@FileTitle : ContainerPremiumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.14 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.insurance.insurance.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ContainerPremiumVO {
	
	private SearchPremiumVO searchPremiumVO;             
	private List<SearchPremiumInstallmentListVO> searchPremiumInstallmentListVO;
	 
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public ContainerPremiumVO() {}
	
	public SearchPremiumVO getSearchPremiumVO() {
		return searchPremiumVO;
	}
	
	public void setSearchPremiumVO(SearchPremiumVO searchPremiumVO) {
		this.searchPremiumVO = searchPremiumVO;
	}
	
	public List<SearchPremiumInstallmentListVO> getSearchPremiumInstallmentListVO() {
		return searchPremiumInstallmentListVO;
	}
	
	public void setSearchPremiumInstallmentListVO(List<SearchPremiumInstallmentListVO> searchPremiumInstallmentListVO) {
		this.searchPremiumInstallmentListVO = searchPremiumInstallmentListVO;
	}
	
}
