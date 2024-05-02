/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_063Event.java
*@FileTitle : EQ 회송기여도 RPT 조회1
*Open Issues :
*Change history :
*@LastModifyDate : 2007-04-06
*@LastModifier : Ari
*@LastVersion : 1.0
* 2006-11-28 Chilseo_Park
* 1.0 최초 생성
* 2009.09.21 김기식   New FrameWork 적용 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.event;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.MultiDimensionPfmcByOfficeListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_MAS_063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chilseo_Park
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmMas0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 화면의 검색조건 관련 VO */
	private RepoPfmcConditionVO searchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MultiDimensionPfmcByOfficeListVO[] rtnVOs = null;
	
	/**
	 * ESM_MAS_063Event 객체를 생성
	 */
	public EsmMas0063Event(){
		//
	}
	
	public void setRepoPfmcConditionVO(RepoPfmcConditionVO VO){
		this. searchVO = VO;
	}

	public void setMultiDimensionPfmcByOfficeListVOS(MultiDimensionPfmcByOfficeListVO[] VOs){
		this. rtnVOs = VOs;
	}

	public MultiDimensionPfmcByOfficeListVO[] getMultiDimensionPfmcByOfficeListVOS(){
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
		return "EsmMas0063Event";
	}

	/**
	 * toString
	 *
	 */
	public String toString() {
		return "EsmMas0063Event";
	}

}
