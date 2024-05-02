/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_085Event.java
*@FileTitle : US 204 EDI Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-22
*@LastModifier : 조인영
*@LastVersion : 1.0 
* 2012-04-22 조인영
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsEdiUsaRcvrDtlVO;


/**
 * ESD_TRS_085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0085Event extends EventSupport {
	private String vndrSeq = null;
	private String deltFlg = null;
	private String loginOfcCd = null;
	private String loginUsrId = null;

	private TrsEdiUsaRcvrDtlVO trsEdiUsaRcvrDtlVO = null;
	private TrsEdiUsaRcvrDtlVO[] trsEdiUsaRcvrDtlVOs = null;

	
	public String getLogin_ofc_cd() {
		return loginOfcCd;
	}

	public void setLogin_ofc_cd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}

	public String getLogin_usr_id() {
		return loginUsrId;
	}

	public void setLogin_usr_id(String loginUsrId) {
		this.loginUsrId = loginUsrId;
	}

	public EsdTrs0085Event(){}	

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getDeltFlg() {
		return deltFlg;
	}

	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	public TrsEdiUsaRcvrDtlVO getTrsEdiUsaRcvrDtlVO() {
		return trsEdiUsaRcvrDtlVO;
	}

	public void setTrsEdiUsaRcvrDtlVO(
			TrsEdiUsaRcvrDtlVO trsEdiUsaRcvrDtlVO) {
		this.trsEdiUsaRcvrDtlVO = trsEdiUsaRcvrDtlVO;
	}

	public TrsEdiUsaRcvrDtlVO[] getTrsEdiUsaRcvrDtlVOs() {
		return trsEdiUsaRcvrDtlVOs;
	}

	public void setTrsEdiUsaRcvrDtlVOs(
			TrsEdiUsaRcvrDtlVO[] trsEdiUsaRcvrDtlVOs) {
		this.trsEdiUsaRcvrDtlVOs = trsEdiUsaRcvrDtlVOs;
	}

	public void setTrsEdiUsaRcvrDtlVOS(TrsEdiUsaRcvrDtlVO[] trsEdiUsaRcvrDtlVOs){
		this.trsEdiUsaRcvrDtlVOs = trsEdiUsaRcvrDtlVOs;
	}
	
	public String getEventName() {
		return "EsdTrs0085Event";
	}

	public String toString() {
		return "EsdTrs0085Event";
	}
	
}
