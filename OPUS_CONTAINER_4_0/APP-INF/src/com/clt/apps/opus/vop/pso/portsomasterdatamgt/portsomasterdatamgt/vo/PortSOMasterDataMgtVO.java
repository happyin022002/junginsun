/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSOMasterDataMgtVO.java
*@FileTitle : PortSOMasterDataMgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.22 박명종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo;

import java.util.List;

import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortSOMasterDataMgtVO {
	private DefaultCostVO[] defaultCostVO = null;
	private DefaultVendorVO[] defaultVendorVO = null;
	private PsoInvOfcYdVO[] psoInvOfcYdVO = null;
	private List<SearchYardsVO> searchYardsVO = null;
	private SignOnUserAccount   account = null;

	public DefaultCostVO[] getDefaultCostVO() {
		return defaultCostVO;
	}
	public void setDefaultCostVO(DefaultCostVO[] defaultcostvo) {
		this.defaultCostVO = defaultcostvo;
	}

	public DefaultVendorVO[] getDefaultVendorVO() {
		return defaultVendorVO;
	}
	public void setDefaultVendorVO(DefaultVendorVO[] defaultvendorvo) {
		this.defaultVendorVO = defaultvendorvo;
	}

	public PsoInvOfcYdVO[] getPsoInvOfcYdVO() {
		return psoInvOfcYdVO;
	}
	public void setPsoInvOfcYdVO(PsoInvOfcYdVO[] psoinvofcydvo) {
		this.psoInvOfcYdVO = psoinvofcydvo;
	}
	/**
	 * @param searchYardsVO the searchYardsVO to set
	 */
	public void setSearchYardsVO(List<SearchYardsVO> searchYardsVO) {
		this.searchYardsVO = searchYardsVO;
	}
	/**
	 * @return the searchYardsVO
	 */
	public List<SearchYardsVO> getSearchYardsVO() {
		return searchYardsVO;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}
}
