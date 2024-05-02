/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4106Event.java
*@FileTitle : Invoice Cancel Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.10
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.10 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.CancelInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCommonReturnDataVO;

/**
 * EES_DMT_4106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES_DMT_4106HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4106Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DmtCommonReturnDataVO dmtCommonReturnDataVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DmtCommonReturnDataVO[] dmtCommonReturnDataVOs = null;
	
	private List<DmtCommonReturnDataVO> dmtCommonReturnDataVOList = null;
	
	private CancelInvoiceParamVO cancelInvoiceParamVO = null;
	
	public EesDmt4106Event(){}

	public DmtCommonReturnDataVO getDmtCommonReturnDataVO() {
		return dmtCommonReturnDataVO;
	}

	public DmtCommonReturnDataVO[] getDmtCommonReturnDataVOs() {
		return dmtCommonReturnDataVOs;
	}

	public List<DmtCommonReturnDataVO> getDmtCommonReturnDataVOList() {
		return dmtCommonReturnDataVOList;
	}
	
	public CancelInvoiceParamVO getCancelInvoiceParamVO() {
		return cancelInvoiceParamVO;
	}

	public void setDmtCommonReturnDataVO(DmtCommonReturnDataVO dmtCommonReturnDataVO) {
		this.dmtCommonReturnDataVO = dmtCommonReturnDataVO;
	}

	public void setDmtCommonReturnDataVOs(DmtCommonReturnDataVO[] dmtCommonReturnDataVOs) {
		this.dmtCommonReturnDataVOs = dmtCommonReturnDataVOs;
	}

	public void setDmtCommonReturnDataVOList(List<DmtCommonReturnDataVO> dmtCommonReturnDataVOList) {
		this.dmtCommonReturnDataVOList = dmtCommonReturnDataVOList;
	}
	
	public void setCancelInvoiceParamVO(CancelInvoiceParamVO cancelInvoiceParamVO) {
		this.cancelInvoiceParamVO = cancelInvoiceParamVO;
	}
	

}