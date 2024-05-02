/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0159Event.java
*@FileTitle : EsmCoa0159Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.CoaLaneTsUtCostVO; 

/**
 * ESM_COA_0159 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0159HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0159HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0159Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	

	
	/** 단건처리 */
	private CoaLaneTsUtCostVO mCoaLaneTsUtCostVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaLaneTsUtCostVO[] mCoaLaneTsUtCostVOs = null;	


	/** Constructor */
	public EsmCoa0159Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0159Event";
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
	public void setCoaLaneTsUtCostVO(CoaLaneTsUtCostVO coaLaneTsUtCostVO){
		this.mCoaLaneTsUtCostVO = coaLaneTsUtCostVO;
	}
	/** ValueObject Getter */
	public CoaLaneTsUtCostVO getCoaLaneTsUtCostVO(){
		return mCoaLaneTsUtCostVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaLaneTsUtCostVOs(CoaLaneTsUtCostVO[] coaLaneTsUtCostVOs){
		mCoaLaneTsUtCostVOs = coaLaneTsUtCostVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaLaneTsUtCostVO[] getCoaLaneTsUtCostVOs(){
		return mCoaLaneTsUtCostVOs;
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
