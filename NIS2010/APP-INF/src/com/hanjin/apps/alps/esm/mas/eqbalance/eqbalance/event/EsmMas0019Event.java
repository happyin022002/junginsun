/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmMas0019Event.java
*@FileTitle : Repo U/C 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 박수훈
*@LastVersion : 1.2
* 2006.11.16 남상욱 최초 생성
* 2009.08.28 박수훈 Alps New Framework 적용[0019]
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0019ListVO;


/**
 * ESM_MAS_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEQBalance0019ListVO searchEQBalance0019ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEQBalance0019ListVO[] searchEQBalance0019ListVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0019Event(){}
	
	public void setSearchEQBalance0019ListVO(SearchEQBalance0019ListVO searchEQBalance0019ListVO){
		this. searchEQBalance0019ListVO = searchEQBalance0019ListVO;
	}

	public void setSearchEQBalance0019ListVOS(SearchEQBalance0019ListVO[] searchEQBalance0019ListVOs){
		this. searchEQBalance0019ListVOs = searchEQBalance0019ListVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public SearchEQBalance0019ListVO getSearchEQBalance0019ListVO(){
		return searchEQBalance0019ListVO;
	}

	public SearchEQBalance0019ListVO[] getSearchEQBalance0019ListVOS(){
		return searchEQBalance0019ListVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}