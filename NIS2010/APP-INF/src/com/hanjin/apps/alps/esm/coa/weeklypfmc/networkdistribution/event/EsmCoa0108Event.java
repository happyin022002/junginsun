/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmCoa0108Event.java
*@FileTitle : Allocation Results(Commitment base)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.07
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.01.07 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;


/**
 * ESM_COA_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_COA_0108HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0108Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private NetworkDistributionCommonVO mNetworkDistributionCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkDistributionCommonVO[] mNetworkDistributionCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	

	/** Constructor */
	public EsmCoa0108Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0108Event";
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

	/**
	 * @return the comBakEndJbVO
	 */
	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}

	/**
	 * @param comBakEndJbVO the comBakEndJbVO to set
	 */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}	
	

}