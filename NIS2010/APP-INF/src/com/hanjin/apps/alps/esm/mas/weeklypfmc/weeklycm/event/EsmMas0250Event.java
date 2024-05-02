/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmMas0250Event.java
*@FileTitle : EsmMas0250Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-18
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2014-11-18 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchExceptionListMgmtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0250 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0250HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Je Ryang Yoo
 * @see ESM_MAS_0250HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0250Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchExceptionListMgmtVO searchExceptionListMgmtVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchExceptionListMgmtVO[] searchExceptionListMgmtVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	


	/** Constructor */
	public EsmMas0250Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0250Event";
	}

	
	/** ValueObject Setter */
	public void setSearchExceptionListMgmtVO(SearchExceptionListMgmtVO searchExceptionListMgmtVO){
		this.searchExceptionListMgmtVO = searchExceptionListMgmtVO;
	}
	/** ValueObject Getter */
	public SearchExceptionListMgmtVO getSearchExceptionListMgmtVO(){
		return searchExceptionListMgmtVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setSearchExceptionListMgmtVOs(SearchExceptionListMgmtVO[] searchExceptionListMgmtVOs){
		this.searchExceptionListMgmtVOs = searchExceptionListMgmtVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public SearchExceptionListMgmtVO[] getSearchExceptionListMgmtVOs(){
		return searchExceptionListMgmtVOs;
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
