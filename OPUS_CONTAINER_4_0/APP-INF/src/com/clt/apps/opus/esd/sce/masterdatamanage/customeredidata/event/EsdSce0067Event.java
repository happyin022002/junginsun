/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0067Event.java
*@FileTitle : EDI STS 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-17
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009-09-17 전병석
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

 
/**
 * COM_ENS_0B2 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0B2HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyunsu, Ryu
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0067Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	/**조회를 위한 VO 정의*/
	public EsdSce0067Event(){}
	private SearchStsListVO schStsLVO = null;
	/**
	 * SearchCargoTrackingDataOptionsVO setter 함수
	 * @param  SearchCargoTrackingDataOptionsVO schCtdOpts
	 * @return SearchCargoTrackingDataOptionsVO
	 * @throws
	 */ 	
	public void setSchStsLVO(SearchStsListVO schStsLVO){
		this.schStsLVO =  schStsLVO;
	}
	/**
	 * SearchStsListVO getter 함수
	 * @param  
	 * @return SearchStsListVO
	 * @throws
	 */ 	
	public SearchStsListVO getSchStsLVO(){
		return schStsLVO;
	}	
	private SearchEDIPerformanceOptionsVO schEpOpts = null;
	/**
	 * SearchEDIPerformanceOptionsVO setter 함수
	 * @param SearchEDIPerformanceOptionsVO schEpOpts
	 * @return 
	 * @throws
	 */	
	public void setSchEpOpts(SearchEDIPerformanceOptionsVO schEpOpts){
		this.schEpOpts = schEpOpts;
	}
	/**
	 * SearchEDIPerformanceOptionsVO getter 함수
	 * @param
	 * @return SearchEDIPerformanceOptionsVO
	 * @throws
	 */	
	public SearchEDIPerformanceOptionsVO getSchEpOpts(){
		return schEpOpts;
	}		
	
}