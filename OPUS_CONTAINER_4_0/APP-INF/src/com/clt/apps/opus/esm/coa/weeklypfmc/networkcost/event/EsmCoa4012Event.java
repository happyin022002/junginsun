/*========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName     : EsmCoa4012Event.java
*@FileTitle    : Pendulum Service Setup (PA)
*Open Issues   :
*Change history 
*@LastModifyDate : 
*@LastModifier   :  
*@LastVersion    :  1.0
* 2015.10.01 SJH 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.PndlmSvcVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;

/**
 * ESM_COA_4012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_4012Event에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SJH 
 * @see ESM_COA_4012Event 참조
 * @since J2EE 1.6
 */
public class EsmCoa4012Event extends EventSupport { 
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	/** 단건처리 */
	private CommonCoaRsVO commonCoaRsVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CommonCoaRsVO[] commonCoaRsVOs = null;	
	
	/** Table Value Object Multi Data 처리 */
	private PndlmSvcVO[] pndlmSvcVOs = null;

	/** Constructor */
	public EsmCoa4012Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa4012Event"; 
	}
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}	

	/** ValueObject Setter */
	public void setCommonCoaRsVO(CommonCoaRsVO commonCoaRsVO){
		this.commonCoaRsVO = commonCoaRsVO;  
	}
	/** ValueObject Getter */
	public CommonCoaRsVO getCommonCoaRsVO(){
		return commonCoaRsVO;
	}	
		
	/** ValueObject Array Setter - Create/Update/Delete */			//SJH.20150508.소스품질
	public void setCommonCoaRsVOs(CommonCoaRsVO[] commonCoaRsVOs){
		if(commonCoaRsVOs != null){
			CommonCoaRsVO[] tmpVOs = Arrays.copyOf(commonCoaRsVOs, commonCoaRsVOs.length);
			this.commonCoaRsVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */			//SJH.20150508.소스품질
	public CommonCoaRsVO[] getCommonCoaRsVOs(){
		CommonCoaRsVO[] rtnVOs = null;
		if (this.commonCoaRsVOs != null) {
			rtnVOs = Arrays.copyOf(commonCoaRsVOs, commonCoaRsVOs.length);
		}
		return rtnVOs;
	}	
	
	
	public void setPndlmSvcVOS(PndlmSvcVO[] pndlmSvcVOs){
		if(pndlmSvcVOs != null){
			PndlmSvcVO[] tmpVOs = Arrays.copyOf(pndlmSvcVOs, pndlmSvcVOs.length);
			this.pndlmSvcVOs = tmpVOs;
		}
	}
	
	public PndlmSvcVO[] getPndlmSvcVOS(){
		PndlmSvcVO[] rtnVOs = null;
		if (this.pndlmSvcVOs != null) {
			rtnVOs = Arrays.copyOf(pndlmSvcVOs, pndlmSvcVOs.length);
		}
		return rtnVOs;
	}	
}