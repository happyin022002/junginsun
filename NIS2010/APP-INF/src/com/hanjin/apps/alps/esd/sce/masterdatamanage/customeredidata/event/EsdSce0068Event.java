/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0068Event.java
*@FileTitle : EsdSce0068
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-31
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2008-03-26 Sanghyun, kim
* 1.0 최초 생성
* 2009-08-31 전병석
* 1.2 버전 커밋
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *   RDTO(Data Transfer Object including DB ResultSet)<br>
 *   EsdSce0068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *   EsdSce0068Event에서 작성<br>
 *   ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim SangHyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0068Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	/**조회를 위한 VO 정의*/
	public EsdSce0068Event(){}
	private SearchCustomTpIdVO schCstTpidVO = null;
	/**
	 * SearchCustomTpIdVO setter 함수
	 * @param schCstTpidVO SearchCustomTpIdVO 
	 * @return 
	 * @throws
	 */		
	public void setSchCstTpidVO (SearchCustomTpIdVO schCstTpidVO){
		this.schCstTpidVO = schCstTpidVO;
	}
	/**
	 * SearchCustomTpIdVO getter 함수
	 * @param 
	 * @return SearchCustomTpIdVO 
	 * @throws
	 */		
	public SearchCustomTpIdVO getSchCstTpidVO(){
		return schCstTpidVO;
	}
	private SearchEDIPerformanceOptionsVO schEpOpts = null;
	/**
	 * SearchEDIPerformanceOptionsVO setter 함수
	 * @param schEpOpts SearchEDIPerformanceOptionsVO 
	 * @return  
	 * @throws
	 */	
	public void setSchEpOpts(SearchEDIPerformanceOptionsVO schEpOpts){
		this.schEpOpts = schEpOpts;
	}
	/**
	 * SearchEDIPerformanceOptionsVO getter 함수
	 * @param 
	 * @return  SearchEDIPerformanceOptionsVO
	 * @throws
	 */	
	public SearchEDIPerformanceOptionsVO getSchEpOpts(){
		return schEpOpts;
	}	

}