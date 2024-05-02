/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0074Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.14
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2009.07.03 
* 1.0 Creation
*=========================================================
* History         
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI                            
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;

/**
 * ESM_MAS_0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Yun Joo
 * @see ESM_MAS_0074HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;;
	
	public EsmMas0074Event(){}


	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}


	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}