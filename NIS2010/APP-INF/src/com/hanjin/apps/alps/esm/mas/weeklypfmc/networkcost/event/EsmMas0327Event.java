/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0327Event.java
*@FileTitle : General Expense Pre OP Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-12
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2014-12-12 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.GenExpStndCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasOwnVslDlyHirVO;

/**
 * ESM_MAS_0327 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0327HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0327HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0327Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private GenExpStndCostVO genExpStndCostVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private GenExpStndCostVO[] genExpStndCostVOs = null;
	
	
	
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
	public EsmMas0327Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0327Event";
	}
	
	
	/** ValueObject Getter */
	public GenExpStndCostVO getGenExpStndCostVO() {
		return genExpStndCostVO;
	}
	
	/** ValueObject Setter */
	public void setGenExpStndCostVO(GenExpStndCostVO genExpStndCostVO) {
		this.genExpStndCostVO = genExpStndCostVO;
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	public GenExpStndCostVO[] getGenExpStndCostVOs() {
		return genExpStndCostVOs;
	}
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setGenExpStndCostVOs(GenExpStndCostVO[] genExpStndCostVOs) {
		this.genExpStndCostVOs = genExpStndCostVOs;
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
