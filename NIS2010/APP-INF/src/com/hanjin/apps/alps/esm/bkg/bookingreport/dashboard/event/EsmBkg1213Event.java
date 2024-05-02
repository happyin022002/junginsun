/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : ESM_BKG_1213Event.java
 *@FileTitle : Dashboard
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.17
 *@LastModifier : Eunjung Park
 *@LastVersion : 1.0
 * 2013.10.17 Eunjung Park
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportColumnVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1213 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1213HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun jung Park
 * @see ESM_BKG_1213HTMLAction 참조
 * @since J2EE 1.5
 */
public class EsmBkg1213Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	DashboardReportColumnVO reportColumnVO = null;
	/** Table Value Object Multi Data 처리 */
	DashboardReportColumnVO[] reportColumnVOs = null;
	
	/**
	 * getReportColumnVO
	 *  @author Eun jung Park
	 *  @return DashboardReportColumnVO
	 */
	public DashboardReportColumnVO getReportColumnVO() {
		return reportColumnVO;
	}
	/**
	 * setReportColumnVO
	 * @author Eun jung Park
	 *  @param DashboardReportColumnVO reportColumnVO
	 */
	public void setReportColumnVO(DashboardReportColumnVO reportColumnVO) {
		this.reportColumnVO = reportColumnVO;
	}
	/**
	 * getReportColumnVOs
	 *  @author Eun jung Park
	 *  @return DashboardReportColumnVO[]
	 */
	public DashboardReportColumnVO[] getReportColumnVOs() {
		return reportColumnVOs;
	}
	/**
	 * setReportColumnVOs
	 * @author Eun jung Park
	 *  @param DashboardReportColumnVO[] reportColumnVOs
	 */
	public void setReportColumnVOs(DashboardReportColumnVO[] reportColumnVOs) {
		this.reportColumnVOs = reportColumnVOs;
	}
	
	
	
}
