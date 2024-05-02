/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0215Event.java
*@FileTitle : Add Call Information (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.05 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0215 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0215HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0215HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0215Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** LocationVO 조회 조건 및 단건 처리  */
	private LocationVO locationVO = null;
	
	/** LocationVO 조회 조건 및 단건 처리  */
	private YardVO yardVO = null;
	
	public LocationVO getLocationVO() {
		return locationVO;
	}

	public void setLocationVO(LocationVO locationVO) {
		this.locationVO = locationVO;
	}

	public YardVO getYardVO() {
		return yardVO;
	}

	public void setYardVO(YardVO yardVO) {
		this.yardVO = yardVO;
	}

	public VopVsk0215Event(){}
	
}