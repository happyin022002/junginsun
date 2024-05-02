
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0114Event.java
*@FileTitle : EsmCoa0114Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BSA_0114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_BSA_0114HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0114Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkCostCommonVO mNetworkCostCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkCostCommonVO[] mNetworkCostCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmCoa0114Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0114Event";
	}

	/** ValueObject Setter */
	public void setNetworkCostCommonVO(NetworkCostCommonVO networkCostCommonVO){
		this.mNetworkCostCommonVO = networkCostCommonVO;
	}
	/** ValueObject Getter */
	public NetworkCostCommonVO getNetworkCostCommonVO(){
		return mNetworkCostCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setNetworkCostCommonVOs(NetworkCostCommonVO[] networkCostCommonVOs){
		mNetworkCostCommonVOs = networkCostCommonVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public NetworkCostCommonVO[] getNetworkCostCommonVOs(){
		return mNetworkCostCommonVOs;
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
