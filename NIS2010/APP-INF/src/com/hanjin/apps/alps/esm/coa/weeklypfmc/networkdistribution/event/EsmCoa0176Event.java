/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmCoa0176Event.java
*@FileTitle : TS Allocation(SNT)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.02.01 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_0176 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0176HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_COA_0176HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0176Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NetworkDistributionCommonVO networkDistributionCommonVO = null;

	private SearchConditionVO searchConditionVO = null;	
	
	public EsmCoa0176Event(){}
	
	public void setNetworkDistributionCommonVO(NetworkDistributionCommonVO networkDistributionCommonVO){
		this. networkDistributionCommonVO = networkDistributionCommonVO;
	}

	public NetworkDistributionCommonVO getNetworkDistributionCommonVO(){
		return networkDistributionCommonVO;
	}
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
}