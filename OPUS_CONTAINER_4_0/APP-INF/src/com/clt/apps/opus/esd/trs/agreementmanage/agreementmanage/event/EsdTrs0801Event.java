/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EsdTrs0801Event.java
 *@FileTitle : TRS AGMT EQ TP RULE Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.21
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsAgmtEqTpRuleVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0801 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0801HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0801Event  extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String frmTrspAgmtRuleTpCd		= null;
	private String frmIntgCdId				= null;
	private String frmIntgCdValCtnt			= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrsAgmtEqTpRuleVO trsAgmtEqTpRuleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TrsAgmtEqTpRuleVO[] trsAgmtEqTpRuleVOs = null;
	
	public TrsAgmtEqTpRuleVO getTrsAgmtEqTpRuleVO() {
		return trsAgmtEqTpRuleVO;
	}

	public void setTrsAgmtEqTpRuleVO(TrsAgmtEqTpRuleVO trsAgmtEqTpRuleVO) {
		this.trsAgmtEqTpRuleVO = trsAgmtEqTpRuleVO;
	}

	public TrsAgmtEqTpRuleVO[] getTrsAgmtEqTpRuleVOs() {
		TrsAgmtEqTpRuleVO[] rtnVOs = null;
		if (this.trsAgmtEqTpRuleVOs != null) {
			rtnVOs = Arrays.copyOf(trsAgmtEqTpRuleVOs, trsAgmtEqTpRuleVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsAgmtEqTpRuleVOs(TrsAgmtEqTpRuleVO[] trsAgmtEqTpRuleVOs) {
		if (trsAgmtEqTpRuleVOs != null) {
			TrsAgmtEqTpRuleVO[] tmpVOs = Arrays.copyOf(trsAgmtEqTpRuleVOs, trsAgmtEqTpRuleVOs.length);
			this.trsAgmtEqTpRuleVOs = tmpVOs;
		} // end if
	}

	public String getFrmTrspAgmtRuleTpCd() {
		return frmTrspAgmtRuleTpCd;
	}

	public void setFrmTrspAgmtRuleTpCd(String frmTrspAgmtRuleTpCd) {
		this.frmTrspAgmtRuleTpCd = frmTrspAgmtRuleTpCd;
	}

	public String getFrmIntgCdId() {
		return frmIntgCdId;
	}

	public void setFrmIntgCdId(String frmIntgCdId) {
		this.frmIntgCdId = frmIntgCdId;
	}

	public String getFrmIntgCdValCtnt() {
		return frmIntgCdValCtnt;
	}

	public void setFrmIntgCdValCtnt(String frmIntgCdValCtnt) {
		this.frmIntgCdValCtnt = frmIntgCdValCtnt;
	}

}