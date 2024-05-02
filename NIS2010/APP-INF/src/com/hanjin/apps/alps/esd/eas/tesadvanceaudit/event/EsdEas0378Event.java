/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0378Event.java
*@FileTitle : M&R Invoice Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event;

import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0378Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jong-Ock Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0378Event extends EventSupport {

	private static final long serialVersionUID = 2453667971767080933L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesAuditConditionVO tesAuditConditionVO = null;

	public TesAuditConditionVO getTesAuditConditionVO() {
		return tesAuditConditionVO;
	}

	public void setTesAuditConditionVO(TesAuditConditionVO tesAuditConditionVO) {
		this.tesAuditConditionVO = tesAuditConditionVO;
	}
}
