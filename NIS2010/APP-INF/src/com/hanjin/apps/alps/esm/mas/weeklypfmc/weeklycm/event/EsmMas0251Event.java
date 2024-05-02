/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : EsmMas0251Event.java
*@FileTitle : EsmMas0251Event
*Open Issues :
*@LastModifyDate : 2017-08-14
*@LastModifier : Dong Ho Kim
*@LastVersion :
*  2017-08-14 Dong Ho Kim
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchUCbyCustomerListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0251 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0251HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong Ho Kim
 * @see ESM_MAS_0251HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0251Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchUCbyCustomerListVO searchUCbyCustomerListVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchUCbyCustomerListVO[] searchUCbyCustomerListVOs = null;
	
	/** 단건처리 */
	/**
	 * 
	 */
	private SearchConditionVO searchConditionVO = null;	


	/** Constructor */
	public EsmMas0251Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0251Event";
	}	
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

    public SearchUCbyCustomerListVO getSearchUCbyCustomerListVO() {
        return searchUCbyCustomerListVO;
    }

    public void setSearchUCbyCustomerListVO(
            SearchUCbyCustomerListVO searchUCbyCustomerListVO) {
        this.searchUCbyCustomerListVO = searchUCbyCustomerListVO;
    }

    public SearchUCbyCustomerListVO[] getSearchUCbyCustomerListVOs() {
        return searchUCbyCustomerListVOs;
    }

    public void setSearchUCbyCustomerListVOs(
            SearchUCbyCustomerListVO[] searchUCbyCustomerListVOs) {
        this.searchUCbyCustomerListVOs = searchUCbyCustomerListVOs;
    }	
			
}
