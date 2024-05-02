/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1152Event.java
*@FileTitle : On-Hire Report Summary By Month
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.23
*@LastModifier : NK Jin-Ho
*@LastVersion : 1.0
* 2011.05.23 NK Jin-Ho
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ReportSearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1152 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CGM_1152HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_CGM_1152HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1152Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportSearchConditionVO reportSearchConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportSearchConditionVO[] reportSearchConditionVOs = null;

	public EesCgm1152Event(){}

	public ReportSearchConditionVO getReportSearchConditionVO() {
		return reportSearchConditionVO;
	}

	public void setReportSearchConditionVO(
			ReportSearchConditionVO reportSearchConditionVO) {
		this.reportSearchConditionVO = reportSearchConditionVO;
	}

	public ReportSearchConditionVO[] getReportSearchConditionVOs() {
		return reportSearchConditionVOs;
	}

	public void setReportSearchConditionVOs(
			ReportSearchConditionVO[] reportSearchConditionVOs) {
		this.reportSearchConditionVOs = reportSearchConditionVOs;
	}
	
	

}