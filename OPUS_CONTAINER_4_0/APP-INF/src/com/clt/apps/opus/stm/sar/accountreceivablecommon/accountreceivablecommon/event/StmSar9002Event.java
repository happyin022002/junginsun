/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0013Event.java
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.19 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CreditCustomerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see STM_SAR_9002HTMLAction 참조
 * @since J2EE 1.4
 */

public class StmSar9002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private String frmCustCntCd = null;
	private String frmCustSeq = null;
	private String frmCustRgstNo = null;
	


	public String getFrmCustCntCd() {
		return frmCustCntCd;
	}

	public void setFrmCustCntCd(String frmCustCntCd) {
		this.frmCustCntCd = frmCustCntCd;
	}

	public String getFrmCustSeq() {
		return frmCustSeq;
	}

	public void setFrmCustSeq(String frmCustSeq) {
		this.frmCustSeq = frmCustSeq;
	}

	public String getFrmCustRgstNo() {
		return frmCustRgstNo;
	}

	public void setFrmCustRgstNo(String frmCustRgstNo) {
		this.frmCustRgstNo = frmCustRgstNo;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreditCustomerVO mdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreditCustomerVO[] mdmCustomerVOs = null;

	public StmSar9002Event(){}
	
	public void setMdmCustomerVO(CreditCustomerVO mdmCustomerVO){
		this. mdmCustomerVO = mdmCustomerVO;
	}

	public void setMdmCustomerVOS(CreditCustomerVO[] mdmCustomerVOs){
		if (mdmCustomerVOs != null) {
			CreditCustomerVO[] tmpVOs = new CreditCustomerVO[mdmCustomerVOs.length];
			System.arraycopy(mdmCustomerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCustomerVOs = tmpVOs;
		}
	}

	public CreditCustomerVO getMdmCustomerVO(){
		return mdmCustomerVO;
		
	}

	public CreditCustomerVO[] getMdmCustomerVOS(){
		CreditCustomerVO[] rtnVOs = null;
		if (this.mdmCustomerVOs != null) {
			rtnVOs = new CreditCustomerVO[mdmCustomerVOs.length];
			System.arraycopy(mdmCustomerVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}