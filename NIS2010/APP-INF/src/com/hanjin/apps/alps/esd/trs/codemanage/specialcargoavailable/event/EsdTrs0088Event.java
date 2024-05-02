/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_088Event.java
*@FileTitle : Special Cargo Available S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-30
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-12-30 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.vo.SpecialCargoAvailableSpListVO;


/**
 * ESD_TRS_085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0088Event extends EventSupport {
	private String vndrCd = null;
	private String combo_svc_provider = "";
	private String loginOfcCd = "";
	private String loginUsrId = "";
	private String so_cre_ofc_cd = "";
	SpecialCargoAvailableSpListVO[] SpecialCargoAvailableSpListVOs = null;
	
	
	public String getCombo_svc_provider() {
		return combo_svc_provider;
	}
	public void setCombo_svc_provider(String combo_svc_provider) {
		this.combo_svc_provider = combo_svc_provider;
	}
	public String getVndrCd() {
		return vndrCd;
	}
	public void setVndrCd(String vndrCd) {
		this.vndrCd = vndrCd;
	}
	public String getLoginOfcCd() {
		return loginOfcCd;
	}
	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}
	public String getLoginUsrId() {
		return loginUsrId;
	}
	public void setLoginUsrId(String loginUsrId) {
		this.loginUsrId = loginUsrId;
	}
	
	public String getSo_cre_ofc_cd() {
		return so_cre_ofc_cd;
	}
	public void setSo_cre_ofc_cd(String so_cre_ofc_cd) {
		this.so_cre_ofc_cd = so_cre_ofc_cd;
	}
	
	public SpecialCargoAvailableSpListVO[] getSpecialCargoAvailableSpListVOs() {
		return SpecialCargoAvailableSpListVOs;
	}
	
	public void setSpecialCargoAvailableSpListVOs(SpecialCargoAvailableSpListVO[] specialCargoAvailableSpListVOs) {
		SpecialCargoAvailableSpListVOs = specialCargoAvailableSpListVOs;
	}
	
}
