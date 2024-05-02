/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0038Event.java
*@FileTitle : EsdSce0038Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-12
*@LastModifier : 전병석
*@LastVersion : 1.3
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
* 2009-08-12
* 1.2 버전 커밋
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.event;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.vo.CargoTrackingOptionsVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * EsdSce038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */ 
public class EsdSce0038Event extends EventSupport{
    /*조회용 옵션 VO 정의*/	
	public EsdSce0038Event(){}

	private CargoTrackingOptionsVO ctopt = null;
	/**
	 * CargoTrackingOptionsVO setter 함수
	 * @param ctopt CargoTrackingOptionsVO
	 * @return
	 * @throws
	 */
	public void setCtopt(CargoTrackingOptionsVO ctopt){
		this.ctopt = ctopt;
	}
	/**
	 * @param  CargoTrackingOptionsVO getter 함수
	 * @return CargoTrackingOptionsVO
	 * @throws 
	 */	
	public CargoTrackingOptionsVO getCtopt(){
		return ctopt;
	}
}
