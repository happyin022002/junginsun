/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : EsmMas0340Event.java
*@FileTitle : Agreed Network Cost Ratio Table
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0340 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0340HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG, Min Seok
 * @see ESM_MAS_0340HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0340Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NetworkDistributionCommonVO networkDistributionCommonVO = null;

	private SearchConditionVO searchConditionVO = null;	
	
	public EsmMas0340Event(){}
	
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