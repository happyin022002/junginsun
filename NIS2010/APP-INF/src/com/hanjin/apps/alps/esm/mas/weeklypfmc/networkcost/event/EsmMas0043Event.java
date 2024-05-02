/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0043Event.java
*@FileTitle : AVG-hire by Own-VSL (PA)
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-04
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2014-12-04 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AvgHireOwnVslVO;
//import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchChassisCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasOwnVslDlyHirVO;

/**
 * ESM_MAS_0043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0043HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0043Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private AvgHireOwnVslVO avgHireOwnVslVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private AvgHireOwnVslVO[] avgHireOwnVslVOs = null;
	
	
	
	/** 단건처리 */		
	private NetworkCostCommonVO mNetworkCostCommonVO = null;	
	
	/** Multi Data 처리 - Create/Update/Delete */		
	private NetworkCostCommonVO[] mNetworkCostCommonVOs = null;

	
	/** 단건처리 */
	private MasOwnVslDlyHirVO mMasOwnVslDlyHirVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasOwnVslDlyHirVO[] mMasOwnVslDlyHirVOs = null;	

	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmMas0043Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0043Event";
	}
	
	
	/** ValueObject Getter */
	public AvgHireOwnVslVO getAvgHireOwnVslVO() {
		return avgHireOwnVslVO;
	}
	
	/** ValueObject Setter */
	public void setAvgHireOwnVslVO(AvgHireOwnVslVO avgHireOwnVslVO) {
		this.avgHireOwnVslVO = avgHireOwnVslVO;
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	public AvgHireOwnVslVO[] getAvgHireOwnVslVOs() {
		return avgHireOwnVslVOs;
	}
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setAvgHireOwnVslVOs(AvgHireOwnVslVO[] avgHireOwnVslVOs) {
		this.avgHireOwnVslVOs = avgHireOwnVslVOs;
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
	public void setMasOwnVslDlyHirVO(MasOwnVslDlyHirVO masOwnVslDlyHirVO){
		this.mMasOwnVslDlyHirVO = masOwnVslDlyHirVO;
	}
	/** ValueObject Getter */
	public MasOwnVslDlyHirVO getMasOwnVslDlyHirVO(){
		return mMasOwnVslDlyHirVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasOwnVslDlyHirVOs(MasOwnVslDlyHirVO[] masOwnVslDlyHirVOs){
		mMasOwnVslDlyHirVOs = masOwnVslDlyHirVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasOwnVslDlyHirVO[] getMasOwnVslDlyHirVOs(){
		return mMasOwnVslDlyHirVOs;
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
