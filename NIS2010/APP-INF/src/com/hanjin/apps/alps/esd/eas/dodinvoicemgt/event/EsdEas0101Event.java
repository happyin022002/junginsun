/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESD_EAS_0101HTMLAction.java
*@FileTitle : DOD Invoice Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.09.12 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvEmailFaxVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_EAS_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyemin Lee
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdEas0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DODInvEmailFaxVO dODInvEmailFaxVO = null;
	
	public EsdEas0101Event(){}
	
	public DODInvEmailFaxVO getDODInvEmailFaxVO() {
		return dODInvEmailFaxVO;
	}

	public void setDODInvEmailFaxVO(DODInvEmailFaxVO dODInvEmailFaxVO) {
		this.dODInvEmailFaxVO = dODInvEmailFaxVO;
	}

}
