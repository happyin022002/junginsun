/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_068Event.java
*@FileTitle : EQ 회송기여도 RPT 조회 3
*Open Issues :
*Change history :
*@LastModifyDate : 2007-04-06
*@LastModifier : Ari
*@LastVersion : 1.0
* 2006-12-08 Chilseo_Park
* 1.0 최초 생성
* 2009.09.21 김기식   New FrameWork 적용
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event;

import com.hanjin.apps.alps.esm.coa.common.event.COAEvent;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchMultiDimension068ListVO;


/**
 * ESM_COA_068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_COA_068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chilseo_Park
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmCoa0068Event extends COAEvent {

private static final long serialVersionUID = 1L;
	
	/** 화면의 검색조건 관련 VO */
	private RepoPfmcConditionVO searchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMultiDimension068ListVO[] rtnVOs = null;
	
	/**
	 * ESM_COA_068Event 객체를 생성
	 */
	public EsmCoa0068Event(){
		//
	}
	
	public void setRepoPfmcConditionVO(RepoPfmcConditionVO VO){
		this. searchVO = VO;
	}

	public void setSearchMultiDimension068ListVOS(SearchMultiDimension068ListVO[] VOs){
		this. rtnVOs = VOs;
	}

	public SearchMultiDimension068ListVO[] getSearchMultiDimension068ListVOS(){
		return rtnVOs;
	}

	public RepoPfmcConditionVO getRepoPfmcConditionVO(){
		return searchVO;
	}

	/**
	 * 클래스 명 리턴
	 *
	 */
	public String getEventName() {
		return "EsmCoa0068Event";
	}

	/**
	 * toString
	 *
	 */
	public String toString() {
		return "EsmCoa0068Event";
	}

}
