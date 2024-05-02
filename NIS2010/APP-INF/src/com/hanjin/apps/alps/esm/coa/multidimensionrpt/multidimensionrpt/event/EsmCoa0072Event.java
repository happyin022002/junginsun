/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0072Event.java
*@FileTitle : Inquire Weekly Sales Report By Office 3
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-22
*@LastModifier : KimJongBeom
*@LastVersion : 1.0
* 2007-01-22 KimJongBeom
* 1.0 최초 생성
* 2009.10.21 김기식   New FrameWork 적용
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_COA_0072HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chilseo_Park
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmCoa0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 화면의 검색조건 관련 VO */
	private RepoPfmcConditionVO searchVO = null;
	
	/**
	 * ESM_COA_069Event 객체를 생성
	 */
	public EsmCoa0072Event(){
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
		return "EsmCoa0072Event";
	}

	/**
	 * toString
	 *
	 */
	public String toString() {
		return "EsmCoa0072Event";
	}

}
