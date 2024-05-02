/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReportPreInsertEvent.java
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

/**
 * ReportDesigner 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ReportPreInsertHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YongHoo-Kim
 * @see  ReportPreInsertHTMLAction 참조
 * @since J2SE 6.0
 */
public class ReportPreInsertEvent extends EventSupport {

	private static final long serialVersionUID = -2036660093038857429L;
	/**
	 * ReportPreInsertEvent 객체 생성<br>
	 */
	public ReportPreInsertEvent() {};	
}
