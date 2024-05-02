/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0110Event.java
*@FileTitle : EsmCoa0110Event
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
import com.hanjin.syscommon.common.table.CoaNtwkCostCreVO;
import com.hanjin.syscommon.common.table.CoaSltChtrInfoVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_COA_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0110HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0110Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkCostCommonVO mNetworkCostCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkCostCommonVO[] mNetworkCostCommonVOs = null;

	
	/** 단건처리 */
	private CoaNtwkCostCreVO mCoaNtwkCostCreVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaNtwkCostCreVO[] mCoaNtwkCostCreVOs = null;	
	
	
	/** 단건처리 */
	private CoaSltChtrInfoVO mCoaSltChtrInfoVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaSltChtrInfoVO[] mCoaSltChtrInfoVOs = null;		

	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	


	/** Constructor */
	public EsmCoa0110Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0110Event";
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
	public void setCoaNtwkCostCreVO(CoaNtwkCostCreVO coaNtwkCostCreVO){
		this.mCoaNtwkCostCreVO = coaNtwkCostCreVO;
	}
	/** ValueObject Getter */
	public CoaNtwkCostCreVO getCoaNtwkCostCreVO(){
		return mCoaNtwkCostCreVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaNtwkCostCreVOs(CoaNtwkCostCreVO[] coaNtwkCostCreVOs){
		mCoaNtwkCostCreVOs = coaNtwkCostCreVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaNtwkCostCreVO[] getCoaNtwkCostCreVOs(){
		return mCoaNtwkCostCreVOs;
	}	

	
	
	/** ValueObject Setter */
	public void setCoaSltChtrInfoVO(CoaSltChtrInfoVO coaSltChtrInfoVO){
		this.mCoaSltChtrInfoVO = coaSltChtrInfoVO;
	}
	/** ValueObject Getter */
	public CoaSltChtrInfoVO getCoaSltChtrInfoVO(){
		return mCoaSltChtrInfoVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaSltChtrInfoVOs(CoaSltChtrInfoVO[] coaSltChtrInfoVOs){
		mCoaSltChtrInfoVOs = coaSltChtrInfoVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaSltChtrInfoVO[] getCoaSltChtrInfoVOs(){
		return mCoaSltChtrInfoVOs;
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
