/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0110Event.java
*@FileTitle : EsmMas0110Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasNtwkCostCreVO;
import com.hanjin.syscommon.common.table.MasSltChtrInfoVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_MAS_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0110HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0110Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private NetworkCostCommonVO mNetworkCostCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private NetworkCostCommonVO[] mNetworkCostCommonVOs = null;

	
	/** 단건처리 */
	private MasNtwkCostCreVO mMasNtwkCostCreVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasNtwkCostCreVO[] mMasNtwkCostCreVOs = null;	
	
	
	/** 단건처리 */
	private MasSltChtrInfoVO mMasSltChtrInfoVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasSltChtrInfoVO[] mMasSltChtrInfoVOs = null;		

	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	


	/** Constructor */
	public EsmMas0110Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0110Event";
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
	public void setMasNtwkCostCreVO(MasNtwkCostCreVO masNtwkCostCreVO){
		this.mMasNtwkCostCreVO = masNtwkCostCreVO;
	}
	/** ValueObject Getter */
	public MasNtwkCostCreVO getMasNtwkCostCreVO(){
		return mMasNtwkCostCreVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasNtwkCostCreVOs(MasNtwkCostCreVO[] masNtwkCostCreVOs){
		mMasNtwkCostCreVOs = masNtwkCostCreVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasNtwkCostCreVO[] getMasNtwkCostCreVOs(){
		return mMasNtwkCostCreVOs;
	}	

	
	
	/** ValueObject Setter */
	public void setMasSltChtrInfoVO(MasSltChtrInfoVO masSltChtrInfoVO){
		this.mMasSltChtrInfoVO = masSltChtrInfoVO;
	}
	/** ValueObject Getter */
	public MasSltChtrInfoVO getMasSltChtrInfoVO(){
		return mMasSltChtrInfoVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasSltChtrInfoVOs(MasSltChtrInfoVO[] masSltChtrInfoVOs){
		mMasSltChtrInfoVOs = masSltChtrInfoVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasSltChtrInfoVO[] getMasSltChtrInfoVOs(){
		return mMasSltChtrInfoVOs;
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
