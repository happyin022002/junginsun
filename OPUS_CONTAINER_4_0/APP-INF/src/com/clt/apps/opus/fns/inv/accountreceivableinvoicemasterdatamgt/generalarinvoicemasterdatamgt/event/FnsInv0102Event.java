/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0102Event.java
*@FileTitle : Code Conversion for CPR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.28 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;


import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCprtCdConvVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0102HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvCprtCdConvVO invCprtCdConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvCprtCdConvVO[] invCprtCdConvVOs = null;
	
	private String scNo = "";
	
	private String rfaNO = "";
	
	private String codeTy = "";
	
	private String cdTp = "";
	
	private String cd = "";

	public FnsInv0102Event(){}

	public InvCprtCdConvVO getInvCprtCdConvVO() {
		return invCprtCdConvVO;
	}

	public void setInvCprtCdConvVO(InvCprtCdConvVO invCprtCdConvVO) {
		this.invCprtCdConvVO = invCprtCdConvVO;
	}

	public InvCprtCdConvVO[] getInvCprtCdConvVOs() {
		InvCprtCdConvVO[] rtnVOs = null;
		if (this.invCprtCdConvVOs != null) {
			rtnVOs = new InvCprtCdConvVO[invCprtCdConvVOs.length];
			System.arraycopy(invCprtCdConvVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setInvCprtCdConvVOs(InvCprtCdConvVO[] invCprtCdConvVOs) {
		if (invCprtCdConvVOs != null) {
			InvCprtCdConvVO[] tmpVOs = new InvCprtCdConvVO[invCprtCdConvVOs.length];
			System.arraycopy(invCprtCdConvVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invCprtCdConvVOs = tmpVOs;
		}
	}

	public String getScNo() {
		return scNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public String getRfaNO() {
		return rfaNO;
	}

	public void setRfaNO(String rfaNO) {
		this.rfaNO = rfaNO;
	}

	public String getCodeTy() {
		return codeTy;
	}

	public void setCodeTy(String codeTy) {
		this.codeTy = codeTy;
	}

	public String getCdTp() {
		return cdTp;
	}

	public void setCdTp(String cdTp) {
		this.cdTp = cdTp;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}
	
	

}