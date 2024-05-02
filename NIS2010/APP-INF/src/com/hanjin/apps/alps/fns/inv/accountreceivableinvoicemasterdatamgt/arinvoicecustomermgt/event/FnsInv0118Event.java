/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FnsInv0118Event.java
*@FileTitle : Charge Code Set-Up per Customer(For CPR)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 김현화
*@LastVersion : 1.0
* 2011.03.04 김현화
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CprtItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceCorrectionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvCprtTmpltChgVO;

/**
 * FNS_INV_0118 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0118HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM HYUN HWA
 * @see FNS_INV_0118HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0118Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object Multi Data 처리 */
	private InvCprtTmpltChgVO[] invCprtTmpltChgVOs = null;
	
	private TemplateVO templateVO = null;
	
	private String rptItmId = null;
	
	private String rptTmpltNm = null;
	
	private String ofcCd = null;
	
	private String rptAuthId = null;

	public FnsInv0118Event(){}

	public InvCprtTmpltChgVO[] getInvCprtTmpltChgVOs() {
		return invCprtTmpltChgVOs;
	}

	public void setInvCprtTmpltChgVOs(InvCprtTmpltChgVO invCprtTmpltChgVO) {
		this.invCprtTmpltChgVOs = invCprtTmpltChgVOs;
	}
	public TemplateVO getTemplateVO() {
		return templateVO;
	}

	public void setTemplateVO(TemplateVO templateVO){
		this. templateVO = templateVO;
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