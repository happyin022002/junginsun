/*=========================================================
 *@FileName : ESD_TRS_0240Event.java
 *@FileTitle :  HJL Handling Fee
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-05-23
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsHjlHndlFeeVO;

/**
 * ESD_TRS_0240 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0240HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.5
 */
public class EsdTrs0240Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String usr_id    = null;
	private String usr_ofc_cd    = null;
	private String ofc_cd    = null;
	private String fm_dt    = null;

	private TrsHjlHndlFeeVO trsHjlHndlFeeVO = null;
	private TrsHjlHndlFeeVO[] trsHjlHndlFeeVOs = null;

	public String getUsr_id() {
		return usr_id;
	}


	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}


	public String getOfc_cd() {
		return ofc_cd;
	}


	public void setOfc_cd(String ofc_cd) {
		this.ofc_cd = ofc_cd;
	}

	public String getUsr_ofc_cd() {
		return usr_ofc_cd;
	}


	public void setUsr_ofc_cd(String usr_ofc_cd) {
		this.usr_ofc_cd = usr_ofc_cd;
	}


	public String getFm_dt() {
		return fm_dt;
	}


	public void setFm_dt(String fm_dt) {
		this.fm_dt = fm_dt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	

	public TrsHjlHndlFeeVO getTrsHjlHndlFeeVO() {
		return trsHjlHndlFeeVO;
	}


	public void setTrsHjlHndlFeeVO(TrsHjlHndlFeeVO trsHjlHndlFeeVO) {
		this.trsHjlHndlFeeVO = trsHjlHndlFeeVO;
	}


	public TrsHjlHndlFeeVO[] getTrsHjlHndlFeeVOs() {
		return trsHjlHndlFeeVOs;
	}


	public void setTrsHjlHndlFeeVOs(TrsHjlHndlFeeVO[] trsHjlHndlFeeVOs) {
		this.trsHjlHndlFeeVOs = trsHjlHndlFeeVOs;
	}


	public EsdTrs0240Event(){}


}