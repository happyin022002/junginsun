/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmCoa4003Event.java
*@FileTitle :  EQ Repo Cost (PA)
*Open Issues :
*Change history : 2014.09.22
*@LastModifyDate : 2014.09.22
*@LastModifier : SJH NEW
*@LastVersion : 1.0
* 2014.09.22 SJH NEW
*Change history :
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.EqRepoCostVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_4003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_4003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_4003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa4003Event extends EventSupport { 
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	/** 단건처리 */
	private CommonCoaRsVO commonCoaRsVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CommonCoaRsVO[] commonCoaRsVOs = null;	
	
	/** Table Value Object Multi Data 처리 */
	private EqRepoCostVO[] eqRepoCostVOs = null;

	/** Constructor */
	public EsmCoa4003Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa4003Event"; 
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
	
	//SJH.20150508.소스품질
	public void setEqRepoCostVOS(EqRepoCostVO[] eqRepoCostVOs){
		if(eqRepoCostVOs != null){
			EqRepoCostVO[] tmpVOs = Arrays.copyOf(eqRepoCostVOs, eqRepoCostVOs.length);
			this.eqRepoCostVOs = tmpVOs;
		}
	}
	//SJH.20150508.소스품질
	public EqRepoCostVO[] getEqRepoCostVOS(){
		EqRepoCostVO[] rtnVOs = null;
		if (this.eqRepoCostVOs != null) {
			rtnVOs = Arrays.copyOf(eqRepoCostVOs, eqRepoCostVOs.length);
		}
		return rtnVOs;
	}	
}