/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdTss0291Event.java
*@FileTitle : D/O notification Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 2016-06-03 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.event;
		
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.vo.DoNotificationReportVO;
/**
 * ESD_TRS_0291 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0291HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0291Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String f_sent_fm_dt = null;
	private String f_sent_to_dt = null;
	private String f_ctrl_ofc_cd = null;
	private String f_fm_node = null;
	private String f_to_node = null;
	private String f_latest = null;
	private String f_door = null;
	private String f_trnk_vvd = null;
	private String f_bkg_no = null;
	private String f_cntr_no = null;
	private String f_sc_no = null;
	
	DoNotificationReportVO[] doNotificationReportListVOs = null;
	
	public String getF_sent_fm_dt() {
		return f_sent_fm_dt;
	}
	public void setF_sent_fm_dt(String f_sent_fm_dt) {
		this.f_sent_fm_dt = f_sent_fm_dt;
	}
	public String getF_sent_to_dt() {
		return f_sent_to_dt;
	}
	public void setF_sent_to_dt(String f_sent_to_dt) {
		this.f_sent_to_dt = f_sent_to_dt;
	}
	public String getF_ctrl_ofc_cd() {
		return f_ctrl_ofc_cd;
	}
	public void setF_ctrl_ofc_cd(String f_ctrl_ofc_cd) {
		this.f_ctrl_ofc_cd = f_ctrl_ofc_cd;
	}
	public String getF_fm_node() {
		return f_fm_node;
	}
	public void setF_fm_node(String f_fm_node) {
		this.f_fm_node = f_fm_node;
	}
	public String getF_to_node() {
		return f_to_node;
	}
	public void setF_to_node(String f_to_node) {
		this.f_to_node = f_to_node;
	}
	public String getF_latest() {
		return f_latest;
	}
	public void setF_latest(String f_latest) {
		this.f_latest = f_latest;
	}
	public String getF_door() {
		return f_door;
	}
	public void setF_door(String f_door) {
		this.f_door = f_door;
	}
	public String getF_trnk_vvd() {
		return f_trnk_vvd;
	}
	public void setF_trnk_vvd(String f_trnk_vvd) {
		this.f_trnk_vvd = f_trnk_vvd;
	}
	public String getF_bkg_no() {
		return f_bkg_no;
	}
	public void setF_bkg_no(String f_bkg_no) {
		this.f_bkg_no = f_bkg_no;
	}
	public String getF_cntr_no() {
		return f_cntr_no;
	}
	public void setF_cntr_no(String f_cntr_no) {
		this.f_cntr_no = f_cntr_no;
	}
	public String getF_sc_no() {
		return f_sc_no;
	}
	public void setF_sc_no(String f_sc_no) {
		this.f_sc_no = f_sc_no;
	}
	
	public DoNotificationReportVO[] getdoNotificationReportListVOs() {
		return doNotificationReportListVOs;
	}
	public void setdoNotificationReportListVOs(
			DoNotificationReportVO[] doNotificationReportListVOs) {
		this.doNotificationReportListVOs = doNotificationReportListVOs;
	}
	
}