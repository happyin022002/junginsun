/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0113Event.java
*@FileTitle : Location Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.29
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.29 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.acm.acmcommon.acmcommon.vo.LocationSelectionVO;


/**
 * ESM_ACM_0113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0113HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0113Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private LocationSelectionVO locationSelectionVO = null;

	public EsmAcm0113Event() {}

	public LocationSelectionVO getLocationSelectionVO() {
		return locationSelectionVO;
	}

	public void setLocationSelectionVO(LocationSelectionVO locationSelectionVO) {
		this.locationSelectionVO = locationSelectionVO;
	}

}
