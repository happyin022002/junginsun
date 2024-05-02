/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0123Event.java
*@FileTitle : Vessel Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event;

import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_0123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_COA_0123HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVslInfoListVO searchVslInfoListVO = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	
	
	/** Table Value Object Multi Data 처리 */
	private SearchVslInfoListVO[] searchVslInfoListVOs = null;

	public EsmCoa0123Event(){}
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}			
	
	public void setSearchVslInfoListVO(SearchVslInfoListVO searchVslInfoListVO){
		this. searchVslInfoListVO = searchVslInfoListVO;
	}
	
	public void setSearchVslInfoListVOS(SearchVslInfoListVO[] searchVslInfoListVOs){
		this. searchVslInfoListVOs = searchVslInfoListVOs;
	}

	public SearchVslInfoListVO getSearchVslInfoListVO(){
		return this.searchVslInfoListVO;
	}
	
	public SearchVslInfoListVO[] getSearchVslInfoListVOS(){
		return this.searchVslInfoListVOs;
	}
	public String getEventName() {
		return "EsmCoa0123Event";
	}
}