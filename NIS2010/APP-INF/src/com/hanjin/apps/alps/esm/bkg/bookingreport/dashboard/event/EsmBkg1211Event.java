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

import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportFormVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportSettingVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * ESM_BKG_1211 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1211HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 박은정
 * @see ESM_BKG_1211HTMLAction 참조
 * @since J2EE 1.5
 */
public class EsmBkg1211Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	DashboardReportSettingVO reportSettingVO = null;
	DashboardReportSettingVO[] reportSettingVOs = null;
	
	
	/**
     * EsmBkg1211Event 객체를 생성
     */
	public EsmBkg1211Event() {
	}
	
	
	public DashboardReportSettingVO getReportSettingVO() {
		return reportSettingVO;
	}


	public void setReportSettingVO(DashboardReportSettingVO reportSettingVO) {
		this.reportSettingVO = reportSettingVO;
	}


	public DashboardReportSettingVO[] getReportSettingVOs() {
		return reportSettingVOs;
	}


	public void setReportSettingVOs(DashboardReportSettingVO[] reportSettingVOs) {
		this.reportSettingVOs = reportSettingVOs;
	}


	/**
     * Event's putValue
     * @param String key
     * @param Object value
     */
    public void putValue(String key, Object value){
      
        if(key==null) return;
        this.setAttribute(key, value);
    }
}
