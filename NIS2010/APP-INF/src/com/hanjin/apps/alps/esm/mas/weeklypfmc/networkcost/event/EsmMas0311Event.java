
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0311Event.java
*@FileTitle : EsmMas0311Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2014.12.10 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchAvgHireOwnVslDtrbListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0311 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0311HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0311HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0311Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchAvgHireOwnVslDtrbListVO mSearchAvgHireOwnVslDtrbListVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchAvgHireOwnVslDtrbListVO[] mSearchAvgHireOwnVslDtrbListVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmMas0311Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0311Event";
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
