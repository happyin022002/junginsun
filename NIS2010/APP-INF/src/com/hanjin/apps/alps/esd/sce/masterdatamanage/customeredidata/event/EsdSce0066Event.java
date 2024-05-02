/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0066Event.java
*@FileTitle : EsdSce0066
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-19
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2009-11-06 전병석
* 1.2 버전 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.UpdateCargoTrackingDataVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdSce0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0066Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	/**조회를 위한 VO 정의*/
	public EsdSce0066Event(){}
	private SearchCargoTrackingDataOptionsVO schCtdOpts = null;
	/**
	 * SearchCargoTrackingDataOptionsVO setter 함수
	 * @param  SearchCargoTrackingDataOptionsVO schCtdOpts
	 * @return SearchCargoTrackingDataOptionsVO
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
	 * List<UpdateCargoTrackingDataVO> setter 함수
	 * @param updateCargoTrackingDataVOs List<UpdateCargoTrackingDataVO> 
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
