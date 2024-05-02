/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0125Event.java
*@FileTitle : EsmCoa0125Event
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
import com.hanjin.syscommon.common.table.CoaLaneTsBsaCmmtVO;
import com.hanjin.syscommon.common.table.CoaLaneTsCmmtVO;

/**
 * ESM_COA_0125 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0125HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0125HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0125Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	

	
	/** 단건처리 */
	private CoaLaneTsCmmtVO mCoaLaneTsCmmtVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaLaneTsCmmtVO[] mCoaLaneTsCmmtVOs = null;	
	

	/** 단건처리 */
	private CoaLaneTsBsaCmmtVO coaLaneTsBsaCmmtVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaLaneTsBsaCmmtVO[] coaLaneTsBsaCmmtVOs = null;	


	/** Constructor */
	public EsmCoa0125Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0125Event";
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
	public void setCoaLaneTsCmmtVO(CoaLaneTsCmmtVO coaLaneTsCmmtVO){
		this.mCoaLaneTsCmmtVO = coaLaneTsCmmtVO;
	}
	/** ValueObject Getter */
	public CoaLaneTsCmmtVO getCoaLaneTsCmmtVO(){
		return mCoaLaneTsCmmtVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaLaneTsCmmtVOs(CoaLaneTsCmmtVO[] coaLaneTsCmmtVOs){
		mCoaLaneTsCmmtVOs = coaLaneTsCmmtVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaLaneTsCmmtVO[] getCoaLaneTsCmmtVOs(){
		return mCoaLaneTsCmmtVOs;
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
	 * @return the coaLaneTsBsaCmmtVO
	 */
	public CoaLaneTsBsaCmmtVO getCoaLaneTsBsaCmmtVO() {
		return coaLaneTsBsaCmmtVO;
	}

	/**
	 * @param coaLaneTsBsaCmmtVO the coaLaneTsBsaCmmtVO to set
	 */
	public void setCoaLaneTsBsaCmmtVO(CoaLaneTsBsaCmmtVO coaLaneTsBsaCmmtVO) {
		this.coaLaneTsBsaCmmtVO = coaLaneTsBsaCmmtVO;
	}

	/**
	 * @return the coaLaneTsBsaCmmtVOs
	 */
	public CoaLaneTsBsaCmmtVO[] getCoaLaneTsBsaCmmtVOs() {
		return coaLaneTsBsaCmmtVOs;
	}

	/**
	 * @param coaLaneTsBsaCmmtVOs the coaLaneTsBsaCmmtVOs to set
	 */
	public void setCoaLaneTsBsaCmmtVOs(CoaLaneTsBsaCmmtVO[] coaLaneTsBsaCmmtVOs) {
		this.coaLaneTsBsaCmmtVOs = coaLaneTsBsaCmmtVOs;
	}

	
	
}
