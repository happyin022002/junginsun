/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0038Event.java
*@FileTitle : EsmCoa0038Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.ESM_COA_0038HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0038HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0038Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	
	/** Constructor */
	public EsmCoa0038Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0038Event";
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
