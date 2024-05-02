/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : InvoiceIssueBC.java
 * @FileTitle : (Korea) Terminal GIRO Inquiry
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion : 1.0
 */
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceFaxEmailListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceNumberVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueTargetVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CustomerListForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.INVMainInfoForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceARIssueTempVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.InvArIssVO;

/**
 * AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br />
 * - AccountReceivableInvoiceMgt logic process<br />
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0064EventResponse,InvoiceIssueBC
 * @since J2EE 1.4
 */
public interface InvoiceIssueBC { 
 
	/**
	 * Invoice Remark(s) event retrieve event process<br>
	 * @author Jung Hwi Taek
	 * @param InvArIssVO invArIssVO
	 * @return List<InvArIssVO>
	 * @exception EventException
	 */
	public List<InvArIssVO> searchInvoiceRemark(InvArIssVO invArIssVO) throws EventException;
	
	/**
	 * Invoice Copy count retrieve<br>
	 * 
	 * @param String ofcCd
	 * @return int
	 * @exception EventException
	 */
	public int searchInvoiceCopyCnt(String ofcCd) throws EventException;
	
	/**
	 * Valid Invoice No Return and INV_AR_ISS Re-issue history save.<br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvIssMainVO>
	 * @exception EventException
	 */
	public List<InvIssMainVO> searchPrintInvoice(PrintInvoiceVO prtInvoiceVo) throws EventException;
	
	/**
	 * Fax / E-mail send or Invoice information retrieve<br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvoiceFaxEmailListVO>
	 * @exception EventException
	 */
	public List<InvoiceFaxEmailListVO> searchIssuedGeneralInvoiceList(PrintInvoiceVO prtInvoiceVo) throws EventException;
	
	/**
	 * Invoice information creation<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
    public String createIssueMain(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, String userId) throws EventException;
    
 
	/**
	 * Invoice information creation<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
    public String createReissueMain(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account) throws EventException ;
    
	/**
	 * Invoice data retrieve<br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<IssueTargetVO>
	 * @exception EventException
	 */	
	public List<IssueTargetVO> searchTargetBLForIssue(GeneralInvoiceVO genInvVo) throws EventException;
	
	/**
	 * Europe and Southeast Asia in some areas, China's Invoice publication<br>
	 * 
	 * @param IssueTargetVO issTgtVo
	 * @param GeneralInvoiceVO genInvVo
	 * @param String userId
	 * @return List<IssueTargetVO>
	 * @exception EventException
	 */		
	public List<IssueTargetVO> issueGeneralInvoice(IssueTargetVO issTgtVo, GeneralInvoiceVO genInvVo, String userId) throws EventException;
	
	
	/**
	 * e-mail, FAX send<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @param String ofcCntCd
	 * @exception EventException
	 */	
    public void sendGeneralInvoiceByFaxEmail(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account, String ofcCntCd) throws EventException;
    
    /**
	 * Paper send<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @param String ofcCntCd
	 * @exception EventException
	 */	
    public void sendGeneralInvoiceByPaper(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account, String ofcCntCd) throws EventException;
	
	/**
	 * BackEndJob Invoice publication<br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param CustomerListForIssueVO[] customerListForIssueVOs
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */	
	public String issueGeneralInvoiceBackEndJobKey(GeneralInvoiceVO genInvVo, CustomerListForIssueVO[] customerListForIssueVOs, String userId) throws EventException;
	
	/**
	 * Retrieve for Invoice publication<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobResutIssueGeneralInvoice(String key) throws EventException;

	/**
	 * Invoice not publication target data retrieve. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<String>
	 * @exception EventException
	 */	
	public List<String> searchErrorBLNumberList(GeneralInvoiceVO genInvVo) throws EventException;
		
	/**
	 * Invoice Number <br>
	 * 
	 * @param String ofcCd
	 * @param String bnd
	 * @param String userId
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchInvoiceNumber(String ofcCd, String bnd, String userId) throws EventException;
	
	/**
	 * Invoice Number max_seq change. <br>
	 * 
	 * @param String invPfxCd
	 * @param String invMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvoiceNumber(String invPfxCd, String invMaxSeq, String userId) throws EventException;

	/**
	 * Same INVOICE NO INTERFACE NO retrieve. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param IssueTargetVO issTgtVo
	 * @return List<IssueTargetVO>
	 * @exception DAOException
	 */
	public List<IssueTargetVO> searchInterfaceNumberList(GeneralInvoiceVO genInvVo, IssueTargetVO issTgtVo) throws EventException;
	
	/**
	 * Invoice Detail Table save target Data retrieve. <br>
	 * 
	 * @param String arIfNo
	 * @return List<IssueEachTargetVO>
	 * @exception DAOException
	 */
	public List<IssueEachTargetVO> searchEachTargetForIssue(String arIfNo) throws EventException;
	
	/**
	 * Invoice Detail information creation. <br>
	 * 
	 * @param String invNo
	 * @param IssueEachTargetVO issEachTgtVo
	 * @param String userId
	 * @exception DAOException
	 */
	public void createInvoiceMapping(String invNo, IssueEachTargetVO issEachTgtVo, String userId) throws EventException;
	
	/**
	 * Invoice issue execute. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param GeneralInvoiceVO genInvVo
	 * @param List<INVMainInfoForIssueVO> iNVMainInfoForIssueVOs
	 * @return InvIssVO
	 * @exception DAOException
	 */
	public InvIssVO searchInvoiceMaxSequence(GeneralInvoiceVO genInvVo, List<INVMainInfoForIssueVO> iNVMainInfoForIssueVOs ) throws EventException;
	
	/**
	 * INV_AR_ISS_DTL table INSERT. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void addInvoiceIssueDetail(InvIssVO invIssVO) throws EventException;
	
	/**
	 * ISSUE TEMP table DELETE. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> removeInvoiceIssueFilter(InvIssVO invIssVO) throws EventException;

	/**
	 * Other Revenue Invoice publication <br>
	 * 
	 * @param InvIssMainVO invCreVo
	 * @param List<IssueEachTargetVO> issEachTgtVOs
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @throws EventException
	 */
	public String issueOtherRevInvoice (InvIssMainVO invCreVo, List<IssueEachTargetVO> issEachTgtVOs, String ofcCd, String userId) throws EventException;
	
	/**
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<CustomerListForIssueVO>
	 * @throws EventException
	 */
	public List<CustomerListForIssueVO> searchCustomerListForIssue(GeneralInvoiceVO genInvVo) throws EventException;
	
	/**
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param String blNos
	 * @return String
	 * @throws EventException
	 */
	public String searchBKGInterfaceCount(String blNos) throws EventException;
	
	
	/**
	 * Search Invoice Issue Temp <br>
	 * 
	 * @param String tmpSeq
	 * @return List<InvoiceARIssueTempVO>
	 * @exception EventException
	 */
	public List<InvoiceARIssueTempVO> searchInvoiceIssueTempList(String tmpSeq) throws EventException ;
	
	/**
	 * Remove Invoice Issue Temp<br>
	 * 
	 * @param String tmpSeq
	 * @exception EventException
	 * 
	 */
	public void removeInvoiceIssueTemp(String tmpSeq) throws EventException ;
	
	/**
	 * Manage Invoice Reissue <br>
	 * 
	 * @param List<InvoiceARIssueTempVO> argList
	 * @exception EventException
	 * 
	 */
	public void manageInvoiceReissue(List<InvoiceARIssueTempVO> argList) throws EventException;
	
	/**
	 * create INV_AR_ISS_TMP <br>
	 * 
	 * @param List<InvoiceARIssueTempVO> issTmpVOList
	 * @exception EventException
	 */	
	public void addInvoiceIssueTemp(List<InvoiceARIssueTempVO> issTmpVOList) throws EventException;	
	
	
}