/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdmSys0022Event.java
*@FileTitle : Job Code Request Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.05.24 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.RequestVO;


/**
 * ADM_SYS_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ADM_SYS_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ADM_SYS_0022HTMLAction 참조
 * @since J2EE 1.6
 */

public class AdmSys0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RequestVO requestVO = null;

	public AdmSys0022Event() {}


	public RequestVO getRequestVO() {
		return requestVO;
	}

	public void setRequestVO(RequestVO requestVO) {
		this.requestVO = requestVO;
	}

}