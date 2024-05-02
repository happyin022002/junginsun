/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1503Event.java
*@FileTitle : EsmBkg1503Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.06.28 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.DepartureTimeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1503에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1503HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1503HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1503Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DepartureTimeVO departureTimeVO = null;


	public EsmBkg1503Event() {}


	public DepartureTimeVO getDepartureTimeVO() {
		return departureTimeVO;
	}

	public void setDepartureTimeVO(DepartureTimeVO departureTimeVO) {
		this.departureTimeVO = departureTimeVO;
	}

}