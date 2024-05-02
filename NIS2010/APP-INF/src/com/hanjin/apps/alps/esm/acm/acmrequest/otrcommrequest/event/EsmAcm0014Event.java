/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0014Event.java
*@FileTitle : Commission Agreement Creation_Master
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.event;

import com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.vo.OTRCommRequestVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM YOUNG-OH
 * @see ESM_ACM_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OTRCommRequestVO otrCommRequestVO = null;

	/** Table Value Object Multi Data 처리 */
	private OTRCommRequestVO[] otrCommRequestVOs = null;

	public EsmAcm0014Event() {}

	public OTRCommRequestVO getOTRCommRequestVO() {
		return otrCommRequestVO;
	}

	public void setOTRCommRequestVO(OTRCommRequestVO otrCommRequestVO) {
		this.otrCommRequestVO = otrCommRequestVO;
	}

	public OTRCommRequestVO[] getOTRCommRequestVOs() {
		return otrCommRequestVOs;
	}

	public void setOTRCommRequestVOs(OTRCommRequestVO[] otrCommRequestVOs) {
		this.otrCommRequestVOs = otrCommRequestVOs;
	}


}