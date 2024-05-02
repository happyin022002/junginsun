/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0033Event.java
*@FileTitle : Port Code Creation  
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.06.04 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;



/**
 * VOP_VSK-0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK-0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK-0033HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LocationVO locationVO = null;
		
	/** Table Value Object Multi Data 처리 */
	private LocationVO[] locationVOs = null;

	public VopVsk0033Event(){}

	/**
	 * @return the locationVO
	 */
	public LocationVO getLocationVO() {
		return locationVO;
	}

	/**
	 * @param locationVO the locationVO to set
	 */
	public void setLocationVO(LocationVO locationVO) {
		this.locationVO = locationVO;
	}

	/**
	 * @return the locationVOs
	 */
	public LocationVO[] getLocationVOs() {
		LocationVO[] rtnVOs =  null;
		if(this.locationVOs != null){
			rtnVOs = new LocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return locationVOs;
	}

	/**
	 * @param locationVOs the locationVOs to set
	 */
	public void setLocationVOs(LocationVO[] locationVOs) {
		if(locationVOs != null){
			LocationVO[] tmpVOs = new LocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.locationVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.locationVOs = locationVOs;
	}

}