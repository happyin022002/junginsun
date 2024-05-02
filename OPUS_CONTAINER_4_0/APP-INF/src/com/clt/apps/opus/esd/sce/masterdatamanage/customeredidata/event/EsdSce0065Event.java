/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0065Event.java
*@FileTitle : EsdSce0065
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-06
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2009-11-06 전병석
* 1.2 버전커밋
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.List;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.UpdateCargoTrackingDataVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdSce0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0065Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	/**조회를 위한 VO 정의*/
	public EsdSce0065Event(){}
	private SearchCargoTrackingDataOptionsVO schCtdOpts = null;
	/**
	 * SearchVesselSkdOptionsVO setter 함수
	 * @param  schVSlVO SearchVesselSkdOptionsVO 
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
	 * SearchCargoTrackingDataOptionsVO setter 함수
	 * @param uCTDVO UpdateCargoTrackingDataVO   
	 * @return 
	 * @throws
	 */ 	
	public void setUCTDVO(UpdateCargoTrackingDataVO uCTDVO){
		this.uCTDVO = uCTDVO;
	}
	/**
	 * SearchCargoTrackingDataOptionsVO getter 함수
	 * @param    
	 * @return SearchCargoTrackingDataOptionsVO
	 * @throws
	 */ 	
	public UpdateCargoTrackingDataVO getUCTDVO(){
		return this.uCTDVO;
	}
	private List<UpdateCargoTrackingDataVO> updateCargoTrackingDataVOs = null;
	/**
	 * List<UpdateCargoTrackingDataVO> setter 함수
	 * @param  updateCargoTrackingDataVOs List<UpdateCargoTrackingDataVO> 
	 * @return 
	 * @throws
	 */ 	
	public void setUCTDVOs(List<UpdateCargoTrackingDataVO> updateCargoTrackingDataVOs){
		this.updateCargoTrackingDataVOs = updateCargoTrackingDataVOs;
	}
	/**
	 * List<UpdateCargoTrackingDataVO> getter 함수
	 * @param 
	 * @return List<UpdateCargoTrackingDataVO>
	 * @throws
	 */ 	
	public List<UpdateCargoTrackingDataVO> getUCTDVOs(){
		return this.updateCargoTrackingDataVOs;
	}

}
