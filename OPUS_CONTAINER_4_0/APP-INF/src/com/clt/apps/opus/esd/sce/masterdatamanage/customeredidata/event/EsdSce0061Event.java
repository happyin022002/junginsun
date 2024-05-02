/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0061Event.java
*@FileTitle : Cargo Tracking EDI Save/Send _ individual  팝업화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-25
*@LastModifier : Jun Byoung Suk
*@LastVersion : 1.0
* 2009-09-23 Jun Byoung Suk
* 1.0 최초 생성
* 2009-09-25 전병석
* 1.3 버전 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.List;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.UpdateCargoTrackingDataVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdSce0061 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 전병석
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0061Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	/**조회를 위한 VO 정의*/
	public EsdSce0061Event(){}
	private SearchCargoTrackingDataOptionsVO schCtdOpts = null;
	/**
	 * SearchCargoTrackingDataOptionsVO setter 함수
	 * @param  schCtdOpts SearchCargoTrackingDataOptionsVO 
	 * @return 
	 * @throws
	 */  	
	public void setSchCtdOpts(SearchCargoTrackingDataOptionsVO schCtdOpts){
		this.schCtdOpts = schCtdOpts;
	}
	/**
	 * SearchCargoTrackingDataOptionsVO getter 함수
	 * @param  
	 * @return SearchCargoTrackingDataOptionsVO
	 * @throws
	 */  		
	public SearchCargoTrackingDataOptionsVO getSchCtdOpts(){
		return this.schCtdOpts;
	}	
	private UpdateCargoTrackingDataVO uCTDVO = null;
	/**
	 * UpdateCargoTrackingDataVO setter 함수
	 * @param  uCTDVO UpdateCargoTrackingDataVO 
	 * @return 
	 * @throws
	 */ 	
	public void setUCTDVO(UpdateCargoTrackingDataVO uCTDVO){
		this.uCTDVO = uCTDVO;
	}
	/**
	 * UpdateCargoTrackingDataVO getter 함수
	 * @param 
	 * @return UpdateCargoTrackingDataVO
	 * @throws
	 */ 		
	public UpdateCargoTrackingDataVO getUCTDVO(){
		return this.uCTDVO;
	}
	private List<UpdateCargoTrackingDataVO> updateCargoTrackingDataVOs = null;
	/**
	 * List<UpdateCargoTrackingDataVO>  setter 함수
	 * @param updateCargoTrackingDataVOs List<UpdateCargoTrackingDataVO> 
	 * @return UpdateCargoTrackingDataVO
	 * @throws
	 */ 	
	public void setUCTDVOs(List<UpdateCargoTrackingDataVO> updateCargoTrackingDataVOs){
		this.updateCargoTrackingDataVOs = updateCargoTrackingDataVOs;
	}
	/**
	 * List<UpdateCargoTrackingDataVO>  getter 함수
	 * @param  
	 * @return List<UpdateCargoTrackingDataVO>
	 * @throws
	 */ 	
	public List<UpdateCargoTrackingDataVO> getUCTDVOs(){
		return this.updateCargoTrackingDataVOs;
	}
	
	//updateCargoTrackingDataVOs =new ArrayList<UpdateCargoTrackingDataVO>();
}
