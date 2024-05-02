/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0106Event.java
*@FileTitle : EsmCoa0106Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_COA_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0106HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0106Event extends EventSupport {

	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	

	/** Constructor */
	public EsmCoa0106Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0106Event";
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

	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}

	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}	
	
	
}
