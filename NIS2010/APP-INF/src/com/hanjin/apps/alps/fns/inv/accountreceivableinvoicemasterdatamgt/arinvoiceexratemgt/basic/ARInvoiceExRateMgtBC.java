/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceExRateMgtBC.java
 *@FileTitle : Ex. Rate Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.04.24 김세일
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.MultiCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Accountreceivableinvoicemasterdatamgt Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicemasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author saeil kim
 * @see Ui_inv-0006EventResponse 참조
 * @since J2EE 1.4
 */

public interface ARInvoiceExRateMgtBC {
	/**
	 * VVD별 환율을 조회한다.<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return List<VVDExrateVO>
	 * @exception EventException
	 */
	public List<VVDExrateVO> searchVVDExchangeRateList(SearchVVDExRateVO searchVVDexRateVO) throws EventException;

	/**
	 * Daily (일자별 )적용환율을 조회한다.<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception EventException
	 */
	public List<CustDailyExRateVO> searchDailyExchangeRateList(SearchExRateVO searchExRateVO) throws EventException;

	/**
	 *  베트남, 중국 Daily 환율등록/수정/삭제. 일자별 환율을 Bound/화폐별로 등록/수정/삭제한다.<br>
  	 *  ERP AR로 해당내용을 Interface 한다(EAI : FNS019-0001).<br>
	 * 
	 * @param CustDailyExRateVO[] custDailyExrateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCustomerDailyExchangeRate(CustDailyExRateVO[] custDailyExrateVos, String userId) throws EventException;

	/**
	 * Customer 환율등록시 여러Customer에 대해서 동일 환율 반영하도록 함.<br>
  	 * 사용자 confirm에 따라서  ERP AR로 해당내용을 Interface 한다(EAI : FNS019-0001)<br>
	 * 
	 * @param MultiCustomerVO[] multiCustomerVos
	 * @param CustDailyExRateVO[] custDailyExRateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageMultiCustomerExRate( MultiCustomerVO[] MultiCustomerVos, CustDailyExRateVO[] custDailyExRateVos, String userId) throws EventException;

	/**
	 * 환율 Type에 따라서 개별화주(Customer) 적용환율을 조회한다.<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception EventException
	 */
	public List<CustDailyExRateVO> searchCustomerExchangeRateList(SearchExRateVO searchExRateVO) throws EventException;

	/**
	 * Customer에 해당월로 등록된 환율이 있는지 확인한다. <br>
	 * 
	 * @param String cust_cnt_cd
	 * @param String cust_seq
	 * @param String mon
	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerMonExRate(String cust_cnt_cd, String cust_seq, String mon) throws EventException;

	/**
	 * 조회조건에 Port list에 보여주기 위한 데이터<br>
	 * 
	 * @param String svrId
	 * @param String ofc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchPortList(String svrId, String ofc) throws EventException;

	/**
	 * VVD  및 날짜기준운항정보참조하여 환율일괄 입력대상 조회한다. <br>
   	 * Bound를 I/B. O/B를 선택한 경우에 한함.<br>
	 * 
	 * @param SearchVVDPortVO searchByBndVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchPortListByBnd(SearchVVDPortVO searchByBndVo) throws EventException;

	/**
	 * VVD  및 날짜기준운항정보참조하여 환율일괄 입력대상 조회한다.<br>
   	 * Bound를 Triangle로 선택한 경우에 한함.<br>
	 * 
	 * @param SearchVVDPortVO searchByTriVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchPortListByTri(SearchVVDPortVO searchByTriVo) throws EventException;
	
	/**
	 * VVD  및 날짜기준운항정보참조하여 환율일괄 입력대상 조회한다.<br>
   	 * EUR일 경우에 한함.<br>
	 * 
	 * @param SearchVVDPortVO searchByTriVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchEURPortList(SearchVVDPortVO searchByTriVo) throws EventException;
	
	
	/**
	 * EUR일때 운항정보에서 Create 대상 VVD, PORT list를 조회한다.<br>
	 * 
	 * @param String vvd_cd
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchEURVVDList(String vvd_cd) throws EventException ;
	
	
	/**
	 * 조건에 맞는 환율입력대상을 VSL SKD에서 조회해오고 VVD별 환율을 Bound/port/service scop/화폐별로 일괄등록한다.<br>
     * 기 등록된 환율이 있는 경우는  Update 하도록 한다.<br>
	 * 
	 * @param List<VVDandPortListVO>  vvdPortListVos
	 * @param List<VVDExrateVO> vvdExRtVos
	 * @param String userId
	 * @exception EventException
	 */
	public void createVVDExchangeRate(List<VVDandPortListVO> vvdPortListVos, List<VVDExrateVO> vvdExRtVos, String userId) throws EventException;

	/**
	 * 환율삭제시  AR Invoice(Charge부분) 중 유효한 데이터에 대하여 해당 환율에 적용된  것이 있는지를 조회해 온다.<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @return String
	 * @exception EventException
	 */
	public String searchARInvoiceExist(ExchangeRateVO exRateVo) throws EventException;

	/**
	 * VVD별 환율을 Bound/port/service scop/화폐별로 등록/수정/삭제한다.<br>
     * ERP AR로 해당내용을 Interface 한다(EAI : FNS019-0002).<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageVVDExchangeRate(VVDExrateVO[] vvdExrateVos, String userId) throws EventException;
	
	/**
	 * 환율 유형별 list 조회<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return ExRateListVO
	 * @exception EventException
	 */
	public ExRateListVO searchExchangeRateList(SearchVVDExRateVO searchVVDexRateVO) throws EventException;
	
	/**
	 * 해당 Currency 가 MDM_ORGANIZATION에 AR Currency로 등록되어 있는지 체크한다.<br>
	 * 
	 * @param String ofc
	 * @param String currCd
	 * @return int
	 * @exception EventException
	 */
	public int searchARCurrCd( String ofc, String currCd ) throws EventException ;
}