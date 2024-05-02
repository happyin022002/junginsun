/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceGroupMgtVO.java
*@FileTitle : Invoice Group을 생성하는 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10. 06.
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009. 8. 21. 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class InvoiceGroupMgtVO extends AbstractValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8645231249451014314L;

	private InvoiceGroupParamVO invoiceGroupParamVO = null;
	
	private List<ConfirmChargeListVO> confirmChargeListVOs = null;
	
	private List<InvoiceIssueVO> invoiceIssueVOs = null;
	
	public InvoiceGroupParamVO getInvoiceGroupParamVO() {
		return invoiceGroupParamVO;
	}

	public List<ConfirmChargeListVO> getConfirmChargeListVOs() {
		return confirmChargeListVOs;
	}
	
	public List<InvoiceIssueVO> getInvoiceIssueVOs() {
		return invoiceIssueVOs;
	}

	public void setInvoiceGroupParamVO(InvoiceGroupParamVO invoiceGroupParamVO) {
		this.invoiceGroupParamVO = invoiceGroupParamVO;
	}

	public void setConfirmChargeListVOs(ConfirmChargeListVO[] confirmChargeList) {
		if(confirmChargeList != null && confirmChargeList.length > 0) {
			confirmChargeListVOs = new ArrayList<ConfirmChargeListVO>();
			for(int i = 0 ; i < confirmChargeList.length ; i++ ) {
				confirmChargeListVOs.add(confirmChargeList[i]);
			}
		}
	}
	
	public void setConfirmChargeList(List<ConfirmChargeListVO> confirmChargeList) {
		this.confirmChargeListVOs = confirmChargeList;
	}
	
	public void setInvoiceIssueListVOs(InvoiceIssueVO[] invoiceissueVOList) {
		if(invoiceissueVOList != null && invoiceissueVOList.length > 0) {
			invoiceIssueVOs = new ArrayList<InvoiceIssueVO>();
			for(int i = 0 ; i < invoiceissueVOList.length ; i++ ) {
				invoiceIssueVOs.add(invoiceissueVOList[i]);
			}
		}
	}
	
	public void setInvoiceIssueList(List<InvoiceIssueVO> invoiceissueVOList) {
		this.invoiceIssueVOs = invoiceissueVOList;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
