/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0364Event.java
*@FileTitle : Multiple Repair CNTR by Area
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-04-13 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/ 
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event;

import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrReportINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0364Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jeong-Min Park
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0364Event extends EventSupport {

	private static final long serialVersionUID = -7517140611058851231L;
	
	private MnrReportINVO mnrReportINVO = null;

	public MnrReportINVO getMnrReportINVO() {
		return mnrReportINVO;
	}
	
	public void setMnrReportINVO(MnrReportINVO mnrReportINVO) {
		this.mnrReportINVO = mnrReportINVO;
	}
}
