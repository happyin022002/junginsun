/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0125Event.java
*@FileTitle : EsmMas0125Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasLaneTsBsaCmmtVO;
import com.hanjin.syscommon.common.table.MasLaneTsCmmtVO;

/**
 * ESM_MAS_0125 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0125HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0125HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0125Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	

	
	/** 단건처리 */
	private MasLaneTsCmmtVO mMasLaneTsCmmtVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasLaneTsCmmtVO[] mMasLaneTsCmmtVOs = null;	
	

	/** 단건처리 */
	private MasLaneTsBsaCmmtVO masLaneTsBsaCmmtVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasLaneTsBsaCmmtVO[] masLaneTsBsaCmmtVOs = null;	


	/** Constructor */
	public EsmMas0125Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0125Event";
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
	public void setMasLaneTsCmmtVO(MasLaneTsCmmtVO masLaneTsCmmtVO){
		this.mMasLaneTsCmmtVO = masLaneTsCmmtVO;
	}
	/** ValueObject Getter */
	public MasLaneTsCmmtVO getMasLaneTsCmmtVO(){
		return mMasLaneTsCmmtVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasLaneTsCmmtVOs(MasLaneTsCmmtVO[] masLaneTsCmmtVOs){
		mMasLaneTsCmmtVOs = masLaneTsCmmtVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasLaneTsCmmtVO[] getMasLaneTsCmmtVOs(){
		return mMasLaneTsCmmtVOs;
	}	
		
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}

	/**
	 * @return the masLaneTsBsaCmmtVO
	 */
	public MasLaneTsBsaCmmtVO getMasLaneTsBsaCmmtVO() {
		return masLaneTsBsaCmmtVO;
	}

	/**
	 * @param masLaneTsBsaCmmtVO the masLaneTsBsaCmmtVO to set
	 */
	public void setMasLaneTsBsaCmmtVO(MasLaneTsBsaCmmtVO masLaneTsBsaCmmtVO) {
		this.masLaneTsBsaCmmtVO = masLaneTsBsaCmmtVO;
	}

	/**
	 * @return the masLaneTsBsaCmmtVOs
	 */
	public MasLaneTsBsaCmmtVO[] getMasLaneTsBsaCmmtVOs() {
		return masLaneTsBsaCmmtVOs;
	}

	/**
	 * @param masLaneTsBsaCmmtVOs the masLaneTsBsaCmmtVOs to set
	 */
	public void setMasLaneTsBsaCmmtVOs(MasLaneTsBsaCmmtVO[] masLaneTsBsaCmmtVOs) {
		this.masLaneTsBsaCmmtVOs = masLaneTsBsaCmmtVOs;
	}

	
	
}
