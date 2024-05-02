/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : DashboardBCImpl.java
 *@FileTitle : Dashboard
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.17
 *@LastModifier : Poong-yeon Cho
 *@LastVersion : 1.0
 * 2009.06.01 Poong-yeon Cho
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportColumnVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportFormVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김경섭
 * @see ESM_BKG_0066HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmBkg1212Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	DashboardReportFormVO reportFormVO = null;
	/** Table Value Object Multi Data 처리 */
	DashboardReportFormVO[] reportFormVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	DashboardReportColumnVO reportColumnVO = null;
	/** Table Value Object Multi Data 처리 */
	DashboardReportColumnVO[] reportColumnVOs = null;
	
	
	public DashboardReportColumnVO getReportColumnVO() {
		return reportColumnVO;
	}



	public void setReportColumnVO(DashboardReportColumnVO reportColumnVO) {
		this.reportColumnVO = reportColumnVO;
	}



	public DashboardReportColumnVO[] getReportColumnVOs() {
		return reportColumnVOs;
	}



	public void setReportColumnVOs(DashboardReportColumnVO[] reportColumnVOs) {
		this.reportColumnVOs = reportColumnVOs;
	}



	/**
     * ESM_BKG_0066HTMLAction 객체를 생성
     */
	public EsmBkg1212Event() {
	}

	
	
	public DashboardReportFormVO getReportFormVO() {
		return reportFormVO;
	}



	public void setReportFormVO(DashboardReportFormVO reportFormVO) {
		this.reportFormVO = reportFormVO;
	}



	public DashboardReportFormVO[] getReportFormVOs() {
		return reportFormVOs;
	}


	public void setReportFormVOs(DashboardReportFormVO[] reportFormVOs) {
		this.reportFormVOs = reportFormVOs;
	}



	/**
	 * Event's putValue
	 * @param key
	 * @param value void
	 */
	public void putValue(String key, Object value){
	  
	    if(key==null) return;
	    this.setAttribute(key, value);
	}
}