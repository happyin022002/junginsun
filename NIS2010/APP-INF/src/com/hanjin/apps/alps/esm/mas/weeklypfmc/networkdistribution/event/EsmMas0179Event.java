/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmMas0179Event.java
*@FileTitle : TS Allocation2
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.09.17 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;


/**
 * ESM_MAS_0179 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0179HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_MAS_0179HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0179Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmMas0179Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0179Event";
	}

	/** ValueObject Setter */
	public void setNetworkDistributionCommonVO(NetworkDistributionCommonVO networkDistributionCommonVO){
		this.mNetworkDistributionCommonVO = networkDistributionCommonVO;
	}
	/** ValueObject Getter */
	public NetworkDistributionCommonVO getNetworkDistributionCommonVO(){
		return mNetworkDistributionCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setNetworkDistributionCommonVOs(NetworkDistributionCommonVO[] networkDistributionCommonVOs){
		mNetworkDistributionCommonVOs = networkDistributionCommonVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public NetworkDistributionCommonVO[] getNetworkDistributionCommonVOs(){
		return mNetworkDistributionCommonVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}		

}