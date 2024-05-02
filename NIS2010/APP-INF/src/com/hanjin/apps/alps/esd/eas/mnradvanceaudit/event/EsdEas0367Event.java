/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0367Event.java
*@FileTitle : Multiple Repair CNTR by Period
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
 * EsdEas0367Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jeong-Min Park
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0367Event extends EventSupport {

	private static final long serialVersionUID = -4277883361945250162L;

	// PAGING에 사용되는 기준 ROWS ESD_EAS_0367.js의 InitRowInfo 선언부분과 동시 수정 
	public static final int MNR_PAGE_SIZE = 100;
	
	private MnrReportINVO mnrReportINVO = null;

	public MnrReportINVO getMnrReportINVO() {
		return mnrReportINVO;
	}
	
	public void setMnrReportINVO(MnrReportINVO mnrReportINVO) {
		this.mnrReportINVO = mnrReportINVO;
	}}
