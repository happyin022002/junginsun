/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationBC.java
*@FileTitle : Other Revenue Invoice Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.23 권 민 [CHM-201114430-01] MRI 생성 관련 CREDIT TERM 로직 보완 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.MRIInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingARVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.RevenueAcctVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.VvdVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ALPS-Accountreceivableinvoicecreation Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicecreation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author saeil kim
 * @see Fns_inv_0022EventResponse 참조
 * @since J2EE 1.4
 */

public interface ManualARCreationBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Miscellaneous Revenue Invoice Entry Rev. Type 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String svrId
	 * @param String rhqCd
	 * @param String ofcCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOfficeRevenueSourceList(String svrId, String rhqCd, String ofcCd) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Miscellaneous Revenue Invoice Entry Rev. Type 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String svrId
	 * @param String ofcCd
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGInvoiceVO>
	 * @exception EventException
	 */
	public List<BKGInvoiceVO> searchBKGMaxInterface(String svrId, String ofcCd, String blNo, String locCd) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Miscellaneous Revenue Invoice Entry Rev. Type 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param MRIInputVO mirInputVo
	 * @return List<BKGInvoiceVO>
	 * @exception EventException
	 */	
	public List<BKGInvoiceVO> searchBKGNewInvoice(MRIInputVO mirInputVo) throws EventException;

	/**
	 * INVCommonDAO의 Local Charge에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String chgCd
	 * @param String ofcCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchLocalChargeExist(String chgCd, String ofcCd) throws EventException;
	 
	/**
	 * 조회 이벤트 처리<br>
	 *  ManualARCreation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String vsl
	 * @param String voy
	 * @param String dep
	 * @param String port
	 * @param String scp
	 * @exception EventException
	 */
	public void checkMiscellaneousAR(String vsl, String voy, String dep, String port, String scp) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Revenue Account(계정) 코드 정보의 리스트를 조회한다.<br>
	 * @param String ofcCd
	 * @param String rhqOfcCd
	 * @return List<RevenueAcctVO>
	 * @exception EventException
	 */
	public List<RevenueAcctVO> searchRevenueAcctCdList(String ofcCd, String rhqOfcCd) throws EventException;

	/**
	 * 데이터 분류/office로 관리되는 결산월의 마감여부를 체크한다<br>
	 * 
	 * @param String ofc
	 * @param String effDt
	 * @param String pgmGubn
	 * @return String
	 * @exception DAOException
	 */
	public String searchClosingStatus (String ofc, String effDt, String pgmGubn) throws EventException;	 
	 
	/**
	 * B/L No 를 채번한다.<br>
	 * 비해운 운임수입 매출채권 생성시 Office 별로 관리하고 있는 B/L No 를 채번하여 구한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	public String searchAutoBLNo (String ofcCd, String userId ) throws EventException;
	 
	/**
	 * 조회 이벤트 처리<br>
	 * 여러건의 비해운 운임수입 매출채권 정보들을 조회한다.<br>
	 * 
	 * @param NonShippingInputVO mthVo
	 * @return List<NonShippingListVO>
	 * @exception EventException
	 */	
	public List<NonShippingListVO> searchNonShippingARList (NonShippingInputVO mthVo ) throws EventException;
	 
	/**
	 * 전표번호를 조회한다.<br>
	 * 입력받은 Office Code 에 대해 Sequence 객체에서 Next 값을 구하여 Slip No 를 구한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSlipNo (String ofcCd) throws EventException;
	 
	/**
	 * 입력한 I/F No 의 비해운 운임수입 매출채권 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ifNo
	 * @return NonShippingARVO
	 * @exception DAOException
	 */
	public NonShippingARVO searchNonShippingARByIFNo (String ifNo) throws EventException;
	 
	/**
	 * 조회 이벤트 처리<br>
	 * 해당 B/L NO로 동일 Office 내 기 생성된 데이터(Max(AR_IF_NO)로 생성된 데이터)의 Customer 정보를 가져온다.<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<ARCustomerVO>
	 * @exception EventException
	 */
	public List<ARCustomerVO> searchBLCustomer (String ofcCd, String blNo) throws EventException ;

	/**
	 * Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String arIfNo
	 * @return ARInvoiceCreationVO
	 * @exception EventException
	 */	
	public ARInvoiceCreationVO searchMiscellaneousARByIFNo (String arIfNo) throws EventException;
	
	/**
	 * INV_AR_MRI_IF_NO table 에서 MRI_MAX_SEQ 조회. <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMRIInterfaceNo(String ofcCd) throws EventException;
	
	/**
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ insert <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addMRIInterfaceNo(String ofcCd, String userId) throws EventException;
	
	/**
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ update <br>
	 * 
	 * @param String ofcCd
	 * @param String mriMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyMRIInterfaceNo(String ofcCd, String mriMaxSeq, String userId) throws EventException;
	
	/**
	 * office 별 Local Time 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTime(String ofcCd) throws EventException;
	
	/**
	 * office 별 block charge 조회 <br>
	 * 
	 * @param String chgCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchBlckChg(String chgCd, String ofcCd) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 존재하는 port인지 체크<br>
	 * 
	 * @param String port
	 * @exception EventException
	 */
	public void checkPort(String port) throws EventException;
	
	/**
	 * VLCSC MIC 일 경우 입력된 IFNo 로 IVA 요율을 가져온다. <br>
	 * 
	 * @param String mstIfNo
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchIvaRateMstIFNo(String mstIfNo, String ofcCd) throws EventException;
	
	
	/**
	 * CMBSC일 경우 입력된 CustCd로 INV_AR_SPND_VAT_RGST_NO테이블에서 SPND_VAT_RGST_NO값을 가져온다. <br>
	 * 
	 * @param String custCntCd 
	 * @param String custSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchSpndVatRgstNo(String custCntCd, String custSeq) throws EventException;
	
	/**
	 * SA Date 에 따른 Due Date 값을 계산하여 가져온다. <br>
	 * 
	 * @param String bnd
	 * @param String saDate
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchDueDate(String bnd, String saDate, String custCntCd, String custSeq, String ofcCd) throws EventException;
	
	/**
	 * VVD변경여부를 판별하기위해 BKG으로부터 VVD정보를 가져온다.<br>
	 * 
	 * @param String blNo
	 * @return VvdVO
	 * @exception EventException
	 */	
	public VvdVO searchVvdByBkgNo (String blNo) throws EventException;
	
	/**
	 * POL_CD, POD_CD 를 이용하여 EU여부를 체크한다. <br>
	 * 
	 * @param String polCd 
	 * @param String podCd
	 * @return String
	 * @exception EventException
	 */
	public String searchEuCheck(String polCd, String podCd) throws EventException;
}