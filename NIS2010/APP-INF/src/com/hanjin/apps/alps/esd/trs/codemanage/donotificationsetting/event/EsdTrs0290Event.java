/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdTss0290Event.java
*@FileTitle : D/O notification Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-30
*@LastModifier : geun hwan park
*@LastVersion : 1.0
* 2016-05-30 geun hwan park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.event;
		
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.vo.DoNotificationSettingListVO;
/**
 * ESD_TRS_0290 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0290HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0290Event extends EventSupport {
	private String f_ctrt_tp_cd = null;
	private String f_sc_no = null;	
	private String f_eff_dt = null;
	private String f_dor_nod_cd = null;
	private String f_dor_nod_yd = null;
	private String dest_nod_cd = null;
	private String dest_nod_yd = null;
	private String f_act_flg = null;
	private String sc_no = null;
	DoNotificationSettingListVO[] doNotificationSettingListVOs = null;
	
	public String getF_ctrt_tp_cd() {
		return f_ctrt_tp_cd;
	}
	
	public void setF_ctrt_tp_cd(String f_ctrt_tp_cd) {
		this.f_ctrt_tp_cd = f_ctrt_tp_cd;
	}
	
	public String getF_sc_no() {
		return f_sc_no;
	}
	
	public void setF_sc_no(String f_sc_no) {
		this.f_sc_no = f_sc_no;
	}
	
	public String getF_eff_dt() {
		return f_eff_dt;
	}
	
	public void setF_eff_dt(String f_eff_dt) {
		this.f_eff_dt = f_eff_dt;
	}
	
	public String getF_dor_nod_cd() {
		return f_dor_nod_cd;
	}
	
	public void setF_dor_nod_cd(String f_dor_nod_cd) {
		this.f_dor_nod_cd = f_dor_nod_cd;
	}
	
	public String getF_dor_nod_yd() {
		return f_dor_nod_yd;
	}
	
	public void setF_dor_nod_yd(String f_dor_nod_yd) {
		this.f_dor_nod_yd = f_dor_nod_yd;
	}
	
	public String getDest_nod_cd() {
		return dest_nod_cd;
	}
	
	public void setDest_nod_cd(String dest_nod_cd) {
		this.dest_nod_cd = dest_nod_cd;
	}
	
	public String getDest_nod_yd() {
		return dest_nod_yd;
	}
	
	public void setDest_nod_yd(String dest_nod_yd) {
		this.dest_nod_yd = dest_nod_yd;
	}
	
	public String getF_act_flg() {
		return f_act_flg;
	}
	
	public void setF_act_flg(String f_act_flg) {
		this.f_act_flg = f_act_flg;
	}
	
	public String getSc_no() {
		return sc_no;
	}
	
	public void setSc_no(String sc_no) {
		this.sc_no = sc_no;
	}
	
	public DoNotificationSettingListVO[] getDoNotificationSettingListVOs() {
		return doNotificationSettingListVOs;
	}
	
	public void setDoNotificationSettingListVOs(
			DoNotificationSettingListVO[] doNotificationSettingListVOs) {
		this.doNotificationSettingListVOs = doNotificationSettingListVOs;
	}
	
	
	
}