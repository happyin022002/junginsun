/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0190Event.java
*@FileTitle : Network Cost Exception List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.04.27 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostExceptionListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.StorageCalExcepNodeVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0190 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0190HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0190HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0190Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkCostExceptionListVO networkCostExceptionListVO = null;	
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkCostExceptionListVO[] networkCostExceptionListVOs = null;
	

	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	

	/** Constructor */
	public EsmMas0190Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0190Event";
	}

	/** ValueObject Setter */
	public void setNetworkCostExceptionListVO(NetworkCostExceptionListVO networkCostExceptionListVO){
		this.networkCostExceptionListVO = networkCostExceptionListVO;
	}
	/** ValueObject Getter */
	public NetworkCostExceptionListVO getNetworkCostExceptionListVO(){
		return networkCostExceptionListVO;
	}	
	
	/** ValueObject Array Getter - Create/Update/Delete */	
	public NetworkCostExceptionListVO[] getNetworkCostExceptionListVOs() {
		return networkCostExceptionListVOs;
	}
	
	/** ValueObject Array Setter - Create/Update/Delete */	
	public void setNetworkCostExceptionListVOs(NetworkCostExceptionListVO[] networkCostExceptionListVOs) {
		this.networkCostExceptionListVOs = networkCostExceptionListVOs;
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
