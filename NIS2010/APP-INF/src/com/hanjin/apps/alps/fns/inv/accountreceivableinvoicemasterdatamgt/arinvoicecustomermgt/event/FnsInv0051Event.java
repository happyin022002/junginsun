/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0051Event.java
*@FileTitle : Customer Preferable Report -Item Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.28 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CprtItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.TemplateVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvCprtTmpltChgVO;


/**
 * FNS_INV_0051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0051HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0051Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CprtItemVO cprtItemVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CprtItemVO[] cprtItemVOs = null;
	
	private TemplateVO[] templateVOs = null;
	
	private InvCprtTmpltChgVO[] invCprtTmpltChgVOs = null;
	
	private String rptItmId = null;
	
	private String rptTmpltNm = null;
	
	private String ofcCd = null;
	
	private String rptAuthId = null;

	public FnsInv0051Event(){}

	public CprtItemVO getCprtItemVO() {
		return cprtItemVO;
	}

	public void setCprtItemVO(CprtItemVO cprtItemVO) {
		this.cprtItemVO = cprtItemVO;
	}

	public CprtItemVO[] getCprtItemVOs() {
		return cprtItemVOs;
	}

	public void setCprtItemVOs(CprtItemVO[] cprtItemVOs) {
		this.cprtItemVOs = cprtItemVOs;
	}

	public TemplateVO[] getTemplateVOs() {
		return templateVOs;
	}

	public void setTemplateVOs(TemplateVO[] templateVOs) {
		this.templateVOs = templateVOs;
	}


	public InvCprtTmpltChgVO[] getInvCprtTmpltChgVOs() {
		return invCprtTmpltChgVOs;
	}

	public void setInvCprtTmpltChgVOs(InvCprtTmpltChgVO[] invCprtTmpltChgVOs) {
		this.invCprtTmpltChgVOs = invCprtTmpltChgVOs;
	}

	public String getRptItmId() {
		return rptItmId;
	}

	public void setRptItmId(String rptItmId) {
		this.rptItmId = rptItmId;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getRptTmpltNm() {
		return rptTmpltNm;
	}

	public void setRptTmpltNm(String rptTmpltNm) {
		this.rptTmpltNm = rptTmpltNm;
	}

	public String getRptAuthId() {
		return rptAuthId;
	}

	public void setRptAuthId(String rptAuthId) {
		this.rptAuthId = rptAuthId;
	}
	
	

}