/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0159Event.java
*@FileTitle : EsmMas0159Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.MasLaneTsUtCostVO; 

/**
 * ESM_MAS_0159 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0159HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0159HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0159Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	

	
	/** 단건처리 */
	private MasLaneTsUtCostVO mMasLaneTsUtCostVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasLaneTsUtCostVO[] mMasLaneTsUtCostVOs = null;	


	/** Constructor */
	public EsmMas0159Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0159Event";
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
	public void setMasLaneTsUtCostVO(MasLaneTsUtCostVO masLaneTsUtCostVO){
		this.mMasLaneTsUtCostVO = masLaneTsUtCostVO;
	}
	/** ValueObject Getter */
	public MasLaneTsUtCostVO getMasLaneTsUtCostVO(){
		return mMasLaneTsUtCostVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasLaneTsUtCostVOs(MasLaneTsUtCostVO[] masLaneTsUtCostVOs){
		mMasLaneTsUtCostVOs = masLaneTsUtCostVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasLaneTsUtCostVO[] getMasLaneTsUtCostVOs(){
		return mMasLaneTsUtCostVOs;
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
