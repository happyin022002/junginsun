/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : EsmMas0328Event.java
*@FileTitle : General Expense Cost Modification
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-15
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2014-12-15 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.GenExpStndCostVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchAvgHireOwnVslDtrbListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0328 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0328HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0328HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0328Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchAvgHireOwnVslDtrbListVO mSearchAvgHireOwnVslDtrbListVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchAvgHireOwnVslDtrbListVO[] mSearchAvgHireOwnVslDtrbListVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	
	
	/** 단건처리 */
	private GenExpStndCostVO genExpStndCostVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private GenExpStndCostVO[] genExpStndCostVOs = null;


	/** Constructor */
	public EsmMas0328Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0328Event";
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
	public void setSearchAvgHireOwnVslDtrbListVO(SearchAvgHireOwnVslDtrbListVO searchAvgHireOwnVslDtrbListVO){
		this.mSearchAvgHireOwnVslDtrbListVO = searchAvgHireOwnVslDtrbListVO;
	}
	/** ValueObject Getter */
	public SearchAvgHireOwnVslDtrbListVO getSearchAvgHireOwnVslDtrbListVO(){
		return mSearchAvgHireOwnVslDtrbListVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setSearchAvgHireOwnVslDtrbListVOs(SearchAvgHireOwnVslDtrbListVO[] searchAvgHireOwnVslDtrbListVOs){
		mSearchAvgHireOwnVslDtrbListVOs = searchAvgHireOwnVslDtrbListVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public SearchAvgHireOwnVslDtrbListVO[] getSearchAvgHireOwnVslDtrbListVOs(){
		return mSearchAvgHireOwnVslDtrbListVOs;
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
