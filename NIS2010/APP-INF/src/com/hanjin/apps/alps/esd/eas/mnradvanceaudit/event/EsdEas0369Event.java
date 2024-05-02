/*=========================================================
*Copyright(c) 2016 CyberLogitec 
*@FileName : EsdEas0369Event.java
*@FileTitle : Futile Trip Container
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-29
*@LastModifier : Seong-Pill Hong
*@LastVersion : 1.0
* 2016-03-29 Seong-Pill Hong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event;

import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0369Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Seong-Pill Hong
 * @see EventSupport 참조
 * @since J2EE 1.4 
 */
public class EsdEas0369Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private MnrMovementVO mnrMovementVO = null;

	public MnrMovementVO getMnrMovementVO() {
		return mnrMovementVO;
	}

	public void setMnrMovementVO(MnrMovementVO mnrMovementVO) {
		this.mnrMovementVO = mnrMovementVO;
	}
}
