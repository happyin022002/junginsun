/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionBC.java
*@FileTitle : Invoice Split Before Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitCondVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ChangeCustomerInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MDMCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceMgt logic process<br>
 *
 * @author saeil kim
 * @see FNS_INV_0018EventResponse,ARInvoiceCorrectionBC
 * @since J2EE 1.4
 */
public interface ARInvoiceCorrectionBC {

	/**
	 * OTS Summary Code retrieve<br>
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchOTSSummary(String ofcCd) throws EventException;

	/**
	 * FNS_INV_0016 : Item Correction retrieve
	 * @author saeil
	 * @param String ofcCd 
	 * @param String blNo 
	 * @param String invNo
	 * @param String otsSmryCd
	 * @return ARInvoiceCorrectionVO
	 * @exception EventException
	 */
	public ARInvoiceCorrectionVO searchARInvoiceByBL(String ofcCd , String blNo , String invNo, String otsSmryCd) throws EventException;
	
	/**
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094<br>
	 * Due Date retrieve event process<br>
	 * @author saeil
	 * @param DueDateInputVO dueInputVo
	 * @return List <DueDateVO>
	 * @exception EventException
	 * 
	 */
	public List<DueDateVO> searchDueDate(DueDateInputVO dueInputVo) throws EventException;

	/**
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094 <br>
	 * effectiveDt,zoneIoc,RevType retrieve
	 * @author saeil
	 * @param ARCorrectionCkVO arCorrectionCkVO
	 * @return ARCorrectionCkReturnVO
	 * @exception EventException
	 * 
	 */
	public ARCorrectionCkReturnVO checkARCorrection(ARCorrectionCkVO arCorrectionCkVO) throws EventException;
	
	
	/**
	 * Input Container No. check and get type size.<br>
	 * 
	 * @param String cntrNo
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerNo (String cntrNo) throws EventException;
	
	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date screen retrieve event process<br>
	 * 
	 * @author Choi Do Soon
	 * @param ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO
	 * @return List <ARInvoiceCustomerVO>
	 * @exception EventException 
	 */
	public List<ARInvoiceCustomerVO> searchARInvoiceListByDate(ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO) throws EventException;
	
	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date screen Customer retrieve event process<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String custNm
	 * @return List <MDMCustomerVO>
	 * @exception EventException 
	 */
	public List<MDMCustomerVO> searchARCustomerList(String ofcCd, String custNm) throws EventException;
	
	/**
	 * FNS_INV_0094_01 Invoice Customer Change (Single) retrieve event process<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String invNo
	 * @return InvoiceCustomerChangeVO
	 * @exception EventException
	 */
	public InvoiceCustomerChangeVO searchChangeCustomerInvoice(String ofcCd , String invNo) throws EventException;
	
	/**
	 * FNS_INV_0094_01 Invoice Customer Change (Single) RepCustomer check event process<br>
	 * 
	 * @author Choi Do Soon
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return int Cnt
	 * @exception EventException
	 */
	public int checkRepCustomer ( String actCustCntCd, String actCustSeq ) throws EventException;
	
	/**
	 * FNS_INV_0094_02 Invoice Customer Change (Multi) retrieve event process<br>
	 * 
	 * @author Choi Do Soon
	 * @param ChangeCustomerInputVO changeCustomerInputVO
	 * @return InvoiceCustomerChangeVO
	 * @exception EventException
	 */
	public InvoiceCustomerChangeVO searchChangeCustomerInvoiceList(ChangeCustomerInputVO changeCustomerInputVO) throws EventException;
	
	/**
	 * FNS_INV_0018 Invoice Split Before Invoice Issue retrieve event process<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ifNo
	 * @param String splitCnt
	 * @param String ofcCd
	 * @param String issToSplitFlg
	 * @param String invDeltDivCd
	 * @return ARInvoiceSplitVO
	 * @exception EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByIFNo(String ifNo,String splitCnt, String ofcCd, String issToSplitFlg, String invDeltDivCd) throws EventException;
	
	/**
	 * FNS_INV_0033 Invoice Split Before Invoice Issue retrieve event process.<br>
	 * 
	 * @author Choi Do Soon
	 * @param String invNo
	 * @param String splitCnt
	 * @param String ofcCd
	 * @return ARInvoiceSplitVO
	 * @exception EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByInvoiceNo(String invNo,String splitCnt, String ofcCd) throws EventException;
	
	/**
	 * FNS_INV_0028 Invoice's Manual Interface Bkg No, C/A No retrieve.<br>
	 * 
	 * @author Choi Do Soon
	 * @param ManualInputVO manualInputVO
	 * @return List<BkgNoCaNoVO>
	 * @exception EventException
	 */
	public List<BkgNoCaNoVO> searchManualInterface(ManualInputVO manualInputVO) throws EventException;

	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD rates unapplied B/L, validate rates apply<br>
	 * 
	 * @author Choi Do Soon
	 * @param ExrateInputVO exrateInputVO
	 * @return List<ExrateTargetMainVO>
	 * @exception EventException
	 */
	public List<ExrateTargetMainVO> searchInvoiceForExrateList(ExrateInputVO exrateInputVO) throws EventException;

	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD Chg table retrieve<br>
	 * 
	 * @author Choi Do Soon
	 * @param String arIfNo
	 * @return List<ExrateTargetChgVO>
	 * @exception EventException
	 */
	public List<ExrateTargetChgVO> searchInvoiceChgForExrateList(String arIfNo) throws EventException;
	
	/**
  	 * FNS_INV_0017 Customer change target arIFno list BLno retrieve<br>
  	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String ifNo
	 * @return List<InvArMnVO>
	 * @exception EventException
	 */
	public List<InvArMnVO> searchARInvoiceMainList ( String ofcCd, String blNo , String ifNo) throws EventException;
	
	/**
	 * FNS_INV_0027 BL Max IfNo retrieve <br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String invNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxInterfaceForExrate ( String ofcCd , String blNo , String invNo) throws EventException;
	
	
	/**
	 * Rev Type,Rev Src retrieve<br>
	 * 
	 * @param String bkgNo
	 * @param String invCustFlg
	 * @return ARCorrectionCkReturnVO
	 * @exception EventException
	 * 
	 */
	public ARCorrectionCkReturnVO searchRevTypeSrc(String bkgNo, String invCustFlg) throws EventException;
	
	/**
	 * FNS_INV_0027 iFNo Inv No retrieve <br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvoiceNoByIfNo ( String arIfNo ) throws EventException;
	
	
	
	/**
	 * BKG_BOOKING VVD BKGNO <br>
	 * 
	 * @param String vvd
	 * @param String pol
	 * @param String pod
	 * @return String List<ARBkgInterfaceCreationVO>
	 * @exception DAOException
	 */
	public List<ARBkgInterfaceCreationVO> searchBkgNoByVvd ( String vvd, String pol, String pod )  throws EventException;
	
	/**
     * Search general interface table<br>
     * 
     * @param String srcIfDt
     * @param String srcIfSeq
     * @return List<ARInterfaceCreationVO>
     * @exception EventException
     */  
    public List<ARInterfaceCreationVO> searchGeneralARInvoiceInterface(String srcIfDt, String srcIfSeq) throws EventException;
    
    /**
     * Search split customer info<br>
     * 
     * @param String arIfNo
     * @return List<String>
     * @exception EventException
     */  
    public List<String> searchSplitCustInfo(String arIfNo) throws EventException;
    
    /**
	 * Search Sailing date by i/f no<br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchSailDateByIfNo(String arIfNo) throws EventException;
		
	/**
	 * Search Not Issued Count<br>
	 * 
	 * @param String arOfcCd
	 * @param String invNo
	 * @return int
	 * @exception EventException
	 * 
	 */
	public int searchNotIssuedCount( String arOfcCd, String invNo ) throws EventException;

	/**
	 * Search Max Interface No By BL<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String invNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchMaxInterfaceNoByBL( String ofcCd, String blNo, String invNo) throws EventException;
	
	/**
	 * Modify SysClear By IF No<br>
	 * 
	 * @param SysClearVO sysClearVo
	 * @exception EventException
	 */
	public void modifySysClearByIFNo(SysClearVO sysClearVo) throws EventException;
	
	/**
	 * [FNS_INV_0018]
	 * manageSplitARInvoiceByIFNo BackEndJob process
	 * 
	 * @author KIMOKRYE
	 * @param ARInvoiceSplitCondVO arSplitCondVO
	 * @param InvArMnVO[] invArMnVOs
	 * @param InvArChgVO[] invArChgVOs
	 * @param InvArAmtVO[] invArAmtVOs
	 * @param InvArCntrVO[] invArCntrVOs
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String manageSplitARInvoiceByIFNo(ARInvoiceSplitCondVO arSplitCondVO, InvArMnVO[] invArMnVOs, InvArChgVO[] invArChgVOs , InvArAmtVO[] invArAmtVOs,  InvArCntrVO[] invArCntrVOs, String usrId) throws EventException;
	
	/**
	 * return result of  Back End Job.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException;	
	
	/**
	 * Search Invoice No by I/F No<br>
	 * 
	 * @param String ifNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchInvNoByIfNo( String ifNo) throws EventException;
	
	/**
	 * Search Max I/F no by I/F No<br>
	 * 
	 * @param String ifNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchMaxIfNo( String ifNo) throws EventException;
	
	/**
	 * Search issue flag by I/F No<br>
	 * 
	 * @param String ifNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchInvIssFlgByIfNo( String ifNo) throws EventException;
	
	/**
	 * Search Split Count<br>
	 * 
	 * @param String arIfNo
	 * @return int
	 * @exception EventException
	 * 
	 */
	public int searchSplitCountByIfNo( String arIfNo ) throws EventException;
}