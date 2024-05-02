/*========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName     : EsmCoa4013Event.java
*@FileTitle    : Creation Operation Days 
*Open Issues   :
*Change history 
*@LastModifyDate : 
*@LastModifier   :  
*@LastVersion    :  1.0
* 2015.10.01 SJH 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_COA_4013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_4013Event에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SJH
 * @see ESM_COA_4013Event 참조
 * @since J2EE 1.6 
 */
public class EsmCoa4013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	/** Constructor */
	public EsmCoa4013Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa4013Event"; 
	}
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}