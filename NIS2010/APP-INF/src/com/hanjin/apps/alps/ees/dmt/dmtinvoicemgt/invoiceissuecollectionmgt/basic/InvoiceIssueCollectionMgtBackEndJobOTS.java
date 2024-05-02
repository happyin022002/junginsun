/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestBackEndJob.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
**@LastVersion : 1.0
* 2009.07.10 김승민
* * 1.0 Creation
* -------------------------------------------------------
* History
* 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
* 2012.10.30 채창호 [CHM-201220810][BKG][CLL/CDL] W/O Flag추가, Transmission MSG변경
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic;

import java.util.List;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Terminaldocumentation Business Logic Command Interface<br>
 * - ALPS-Terminaldocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seung Min
 * @see Esm_bkg_0930EventResponse 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtBackEndJobOTS extends BackEndCommandSupport{

	private static final long serialVersionUID = -3034414164961318353L;
	//private SignOnUserAccount account;

	private String pgmNo = "";
	private SignOnUserAccount account;
	
	private OtsInquiryParmVO otsInquiryParmVO ;

	/**
	 * 화면ID세팅
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}	
	
	/**
	 * 다운로드 할 데이터 세팅 0613화면.
	 * 
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}	

	public OtsInquiryParmVO getOtsInquiryParmVO() {
		return otsInquiryParmVO;
	}

	public void setOtsInquiryParmVO(OtsInquiryParmVO otsInquiryParmVO) {
		this.otsInquiryParmVO = otsInquiryParmVO;
	}

	/**
	 * BackEndCommand Start
	 * @return List<OTSCleanListVO>
	 * @throws Exception
	 */
	public List<OTSCleanListVO> doStart() throws Exception {
		List<OTSCleanListVO> list = null;
		try {

			if (pgmNo.equals("EES_DMT_4017"))
			{
				InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
				list = command.searchOTSCleanList ( otsInquiryParmVO );
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
}
