/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmMas0192Event.java
*@FileTitle : P&L by Lane (After Adjustment)
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-19
*@LastModifier : Young-Heon Lee
*@LastVersion : 1.0
* 2015-05-19 Young-Heon Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.event;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0192 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_MAS_0192HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Young-Heon Lee
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmMas0192Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 화면의 검색조건 관련 VO */
	private RepoPfmcConditionVO searchVO = null;
	
	/**
	 * ESM_MAS_0192Event 객체를 생성
	 */
	public EsmMas0192Event(){
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
		return "EsmMas0192Event";
	}

	/**
	 * toString
	 *
	 */
	public String toString() {
		return "EsmMas0192Event";
	}

}
