/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa017Event.java
*@FileTitle : Inquiry by BKG Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.02 
* 1.0 Creation
* 2009.09.07 박은주   New FrameWork 적용 [0170]
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_COA_0170HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0170Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 화면의 검색조건 관련 VO */
	private SearchConditionVO searchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBkgRmk0170ListVO[] rtnVOs = null;

	public EsmCoa0170Event(){}
	
	public void setSearchConditionVO(SearchConditionVO VO){
		this. searchVO = VO;
	}

	public void setSearchBkgRmk0170ListVOS(SearchBkgRmk0170ListVO[] VOs){
		this. rtnVOs = VOs;
	}

	public SearchBkgRmk0170ListVO[] getSearchBkgRmk0170ListVOS(){
		return rtnVOs;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchVO;
	}

	public String getEventName() {
		return "EsmCoa0170Event";
	}


}