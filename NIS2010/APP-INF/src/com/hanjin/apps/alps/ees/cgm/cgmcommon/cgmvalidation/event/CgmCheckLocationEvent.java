/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CheckLocationEvent.java
*@FileTitle : location check
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.27 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.LocationMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * check_Location 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  check_LocationHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see check_LocationHTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmCheckLocationEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LocationMGTVO locationMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LocationMGTVO[] locationMGTVOs = null;

	public CgmCheckLocationEvent(){}

	/**
	 * @return the locationMGTVO
	 */
	public LocationMGTVO getLocationMGTVO() {
		return locationMGTVO;
	}

	/**
	 * @param locationMGTVO the locationMGTVO to set
	 */
	public void setLocationMGTVO(LocationMGTVO locationMGTVO) {
		this.locationMGTVO = locationMGTVO;
	}

	/**
	 * @return the locationMGTVOs
	 */
	public LocationMGTVO[] getLocationMGTVOs() {
		return locationMGTVOs;
	}

	/**
	 * @param locationMGTVOs the locationMGTVOs to set
	 */
	public void setLocationMGTVOs(LocationMGTVO[] locationMGTVOs) {
		this.locationMGTVOs = locationMGTVOs;
	}
	


}