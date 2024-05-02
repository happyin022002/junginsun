/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReportInsertEvent.java
*@FileTitle : Report Designer Insert
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-03
*@LastModifier : YongHoo-Kim
*@LastVersion : 1.0
* 2013-05-03 YongHoo-Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.report.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.report.vo.ReportDesignerVO;

/**
 * ReportDesigner 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ReportInsertHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YongHoo-Kim
 * @see  ReportInsertHTMLAction 참조
 * @since J2SE 6.0
 */
public class ReportInsertEvent extends EventSupport {

	private static final long serialVersionUID = -2036660093038857429L;
	private ReportDesignerVO reportdesigner = null;
	/**
	 * ReportPreInsertEvent 객체 생성<br>
	 */
	public ReportInsertEvent() {};
	/**
	 * ReportInsertEvent 객체 생성<br>
	 * @param ReportDesignerVO reportdesigner
	 */
	public ReportInsertEvent(ReportDesignerVO reportdesigner) {
		this.reportdesigner = reportdesigner;
	}
	/**
	 * RD VO객체를 반환한다.<br>
	 * @return ReportDesignerVO
	 */
	public ReportDesignerVO getReportdesigner() {
		return reportdesigner;
	}
	/**
	 * RD VO객체를 set한다.<br>
	 */
	public void setReportdesigner(ReportDesignerVO reportdesigner) {
		this.reportdesigner = reportdesigner;
	}
	
}
