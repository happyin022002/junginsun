/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : InvoiceManageEdiBackEndJob.java
 *@FileTitle : InvoiceManageEdiBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.19
 *@LastModifier : JS
 *@LastVersion : 1.0
 * 2012.04.19 JS
 * 1.0 Creation
 * 2012.02.02 JS CHM-201323308 [TPB] Invoice Issue Type에 EDI 추가
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic;

import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic.InvoiceManageBC;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;


/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceManageEdiBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -6056305194277894107L;
	private SearchInvoiceStatusVO searchInvoiceStatusVO = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	/**
	 * 다운로드 할 데이터 세팅 0112화면.<br>
	 * 
	 * @param SearchInvoiceStatusVO SearchInvoiceStatusVO
	 */
	public void setTPBEdiTransmitVO(SearchInvoiceStatusVO searchInvoiceStatusVO) {
		this.searchInvoiceStatusVO = searchInvoiceStatusVO;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}



	/**
	 * 화면ID세팅<br>
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * BackEndCommand Start<br>
	 * 
	 * @return Object
	 */
	public String doStart() throws Exception {
		InvoiceManageBC command = null;
	
		if (pgmNo.startsWith("ESD_TPB_0112") ) {
			command = new InvoiceManageBCImpl();
			return command.transmitTPBEDI(searchInvoiceStatusVO, account);
		}
		
		return "Y";
	}
	
	
}
