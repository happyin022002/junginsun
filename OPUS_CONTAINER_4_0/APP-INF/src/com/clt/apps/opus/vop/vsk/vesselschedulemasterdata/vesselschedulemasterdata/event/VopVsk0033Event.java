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
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.framework.support.layer.event.EventSupport;



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
		LocationVO[] rtnVOs = null;
		if (this.locationVOs != null) {
			rtnVOs = Arrays.copyOf(this.locationVOs, this.locationVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param locationVOs the locationVOs to set
	 */
	public void setLocationVOs(LocationVO[] locationVOs) {
		if (locationVOs != null) {
			LocationVO[] tmpVOs = Arrays.copyOf(locationVOs, locationVOs.length);
			this.locationVOs = tmpVOs;
		} // end if
	}

}