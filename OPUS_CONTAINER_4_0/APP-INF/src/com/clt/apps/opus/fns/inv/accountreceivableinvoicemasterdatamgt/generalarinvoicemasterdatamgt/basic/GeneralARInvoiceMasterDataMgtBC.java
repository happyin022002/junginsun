/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GeneralARInvoiceMasterDataMgtBC.java
 *@FileTitle : Revenue Lane Inquiry by Order
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic;

import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCprtCdConvVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PrinterbyUserIdVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.InvEdiIntgCdDtlVO;
import com.clt.syscommon.common.table.InvEdiIntgCdVO;
import com.clt.syscommon.common.table.InvRevAcctCdVO;

/**
 * Accountreceivableinvoicemasterdatamgt Business Logic Command Interface<br>
 * -handling AccountReceivableInvoiceMasterDataMgt business logic.<br>
 * 
 * @author saeil kim
 * @see refer Fns_inv_0077EventResponse 
 * @since J2EE 1.4
 */
 
public interface GeneralARInvoiceMasterDataMgtBC {
	
	
	
	/**
	 * retrieve Revenue Account info Interface with ERP. <br>
	 * 
	 * @param String source
	 * @param String revGroup
	 * @param String del
	 * @return List<InvRevAcctCdVO>
	 * @exception EventException
	 */
	public List<InvRevAcctCdVO> searchRevenueAccountList(String source, String revGroup, String del) throws EventException;

	/**
	 * save, correct, delete Revenue Account.<br>
	 * 
	 * @param InvRevAcctCdVO[] invRevAcctCdVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageRevenueAccount(InvRevAcctCdVO[] invRevAcctCdVOs, String userId) throws EventException;

	
	/**
	 * retrieve cut off lane list.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String oldOfc
	 * @param String newOfc
	 * @return List<InvCutOffLaneVO>
	 * @exception EventException
	 */
	public List<InvCutOffLaneVO> searchCutOffLaneListByAROffice(String oldOfc, String newOfc) throws EventException;

	/**
	 * save, correct, delete cut off lane by A/R Office.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCutOffLaneVO[] cutLanVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCutOffLaneByAROffice(InvCutOffLaneVO[] cutLanVOs, String userId) throws EventException;

	/**
	 * validate input lane code.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String lane
	 * @return String
	 * @exception EventException
	 */
	public String searchSvcLane(String lane) throws EventException;

	/**
	 * validate input port Location code.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String port
	 * @return String
	 * @exception EventException
	 */
	public String searchLocation(String port) throws EventException;

	/**
	 * validate input VVD code.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @exception EventException
	 */
	public String searchVVD(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;

	/**
	 * retrieve issue standard by Office.<br>
	 * author Dong Hoon Han
	 * 
	 * @param String ofc
	 * @return InvArStupOfcVO
	 * @exception EventException
	 */
	public InvArStupOfcVO searchIssueStandardByOffice(String ofc) throws EventException;

	/**
	 * save , delete INV_AR_MISC_BLCK_CHG table by Office. <br>
	 * author Dong Hoon Han
	 * 
	 * @param String ofc
	 * @param String chgCd
	 * @param String userId
	 * @exception EventException
	 */
	public void manageMriChgcdByOffice(String ofc, String chgCd, String userId) throws EventException;

	/**
	 * manage issue standard by Office. <br>
	 * author Dong Hoon Han
	 * 
	 * @param InvArStupOfcVO issStnVO
	 * @exception EventException
	 */
	public void manageIssueStandardByOffice(InvArStupOfcVO issStnVO) throws EventException;

	/**
	 * FNS0430001Document XMLparsing. <br>
	 * 
	 * @param XmlObject xmlObject
	 * @return InvRevAcctCdVO[]
	 * @exception EventException
	 */
    public InvRevAcctCdVO[] fns0430001Receive(XmlObject xmlObject) throws EventException;
    
    /**
     * save  Account code Revenue Type from ERP. <br>
     * 
     * @param InvRevAcctCdVO[] invRevAcctCdVOs
     * @exception EventException
     */
	public void createRevenueAccountList(InvRevAcctCdVO[] invRevAcctCdVOs) throws EventException;

			
	/**
	 * FNS_INV_0108<br>
	 * retrieve INVOICE Printer Set up info.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofcCd
	 * @param String usrId
	 * @return List<PrinterbyUserIdVO>
	 * @exception EventException
	 */
	public List<PrinterbyUserIdVO> searchINVPrinterbyUserId(String ofcCd, String usrId) throws EventException;
	
	/**
	 * FNS_INV_0108<br>
	 * save , correct INVOICE Printer Set up info.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofc
	 * @param String userId
	 * @param String printerNm
	 * @exception EventException
	 */
	public void manageINVPrinterName(String ofc, String userId, String printerNm) throws EventException;
	
	
	/**
	 * save , correct INVOICE Printer Set up info.<br>
	 * 
	 * @param String ofcCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAROfficeList(String ofcCd) throws EventException ;
	
	/**
	 * CPR(Customer Preferable Report)에서 사용할 Conversion code를 유형별로 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @param String rfaNO
	 * @param String codeTy
	 * @return List<InvCprtCdConvVO>
	 * @exception EventException
	 */
	public List<InvCprtCdConvVO> searchCodeConversionList(String scNo, String rfaNO, String codeTy) throws EventException;

	/**
	 * S/C No, RFA no로 PRI 시스템에서 Customer를 찾아 온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @param String rfaNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerName(String scNo, String rfaNo) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용할 NYK 사용 code를 Customer 사용 Code로 Conversion하기 위한 code를 등록하는 화면에서 NYK Code 가 유효한 Code 인지를 check한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cdTp
	 * @param String cd
	 * @return String
	 * @exception EventException
	 */
	public String searchCompanyCode(String cdTp, String cd) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용할 conversion code를 수정한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCprtCdConvVO[] invCprtCdConvVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCodeConversion(InvCprtCdConvVO[] invCprtCdConvVOs, String userId) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용할 Conversion code를 유형별로 등록한다. 이미 다른 S/C NO나 RFA NO로 등록된 Conversion code를 신규 S/C NO나 RFA NO로 내용을 Copy 하여 새로 생성해준다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvCprtCdConvVO[] invCprtCdConvVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCodeConversion(InvCprtCdConvVO[] invCprtCdConvVOs, SignOnUserAccount account) throws EventException;

}