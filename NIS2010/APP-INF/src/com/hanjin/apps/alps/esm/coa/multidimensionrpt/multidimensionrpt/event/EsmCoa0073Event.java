/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0073Event.java
*@FileTitle : Adjusted cost detail(MT/ABC) 
*Open Issues :
*Change history :
*@LastModifyDate : 2012-09-22
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2012.09.22 이석준
* 1.0 최초 생성
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_COA_0073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chilseo_Park
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmCoa0073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 화면의 검색조건 관련 VO */
	private RepoPfmcConditionVO searchVO = null;
	
	/**
	 * ESM_COA_073Event 객체를 생성
	 */
	public EsmCoa0073Event(){
		//
	}
	
	public void setRepoPfmcConditionVO(RepoPfmcConditionVO VO){
		this. searchVO = VO;
	}
	
	public RepoPfmcConditionVO getRepoPfmcConditionVO(){
		return searchVO;
	}

	/**
	 * 클래스 명 리턴
	 *
	 */
	public String getEventName() {
		return "EsmCoa0073Event";
	}

	/**
	 * toString
	 *
	 */
	public String toString() {
		return "EsmCoa0073Event";
	}

}
