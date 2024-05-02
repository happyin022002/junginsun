/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EesMnr0257Event.java
*@FileTitle : Hanger Rack/Bar Using Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.12.20 김상수
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.20 김상수 [CHM-201115062-01] ALPS MNR-Hanger-hanger rack and Bar History에 Report 보턴 추가 및 처리
*                                      - [UI_MNR_0257] Hanger Rack/Bar Using Report 신규 개발
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.HangerRackReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_mnr_0257 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0257HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ees_mnr_0257HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0257Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private HangerRackReportVO hangerRackReportVO = null;

	/** Table Value Object Multi Data 처리 */
	private HangerRackReportVO[] hangerRackReportVOs = null;

	public EesMnr0257Event(){}

	public HangerRackReportVO getHangerRackReportVO() {
		return hangerRackReportVO;
	}

	public void setHangerRackReportVO(HangerRackReportVO hangerRackReportVO) {
		this.hangerRackReportVO = hangerRackReportVO;
	}

	public HangerRackReportVO[] getHangerRackReportVOs() {
		return hangerRackReportVOs;
	}

	public void setHangerRackReportVOs(HangerRackReportVO[] hangerRackReportVOs) {
		this.hangerRackReportVOs = hangerRackReportVOs;
	}

}