/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0939Event.java
*@FileTitle : Authorization W/O Detail 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-21
*@LastModifier : 9014787
*@LastVersion : 1.0 
* 2015-07-21 9014787
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0939 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0939HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9014787
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class EsdTrs0939Event extends EventSupport {

	
	String authAproRqstNo;
	
	
	/**
	 * @return the authAproRqstNo
	 */
	public String getAuthAproRqstNo() {
		return authAproRqstNo;
	}

	/**
	 * @param authAproRqstNo the authAproRqstNo to set
	 */
	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
	}

}
