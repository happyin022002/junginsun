/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceExRateMgtBC.java
 *@FileTitle : Ex. Rate Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.MultiCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDPortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateDateHisVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateHistoryVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.DailyExchangeRateTmpVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * AccountReceivableInvoiceMasterDataMgt Business Logic Basic Command implementation<br>
 * 
 * @author saeil kim
 * @see UI_INV-0006EventResponse,ARInvoiceExRateMgtBC each DAO class reference
 * @since J2EE 1.4
 */
public interface ARInvoiceExRateMgtBC {
 
	/**
	 * Each VVD rates retrieve<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return List<VVDExrateVO>
	 * @exception EventException
	 */
	public List<VVDExrateVO> searchVVDExchangeRateList(SearchVVDExRateVO searchVVDexRateVO) throws EventException;

	/**
	 * Daily (each daily )apply rates retrieve<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception EventException
	 */
	public List<CustDailyExRateVO> searchDailyExchangeRateList(SearchExRateVO searchExRateVO) throws EventException;

	/**
	 *  Vietnam, China Daily rates register/modify/delete. each daily rates Bound/each money register/modify/delete<br>
  	 *  ERP AR Interface(EAI : FNS019-0001).<br>
	 * 
	 * @param CustDailyExRateVO[] custDailyExrateVos
	 * @param String userId
	 * @param String dupChk
	 * @exception EventException
	 */
	public void manageCustomerDailyExchangeRate(CustDailyExRateVO[] custDailyExrateVos, String userId, String dupChk) throws EventException;

	
	/**
	 *  Vietnam, China Daily rates register/modify/delete. each daily rates Bound/each money register/modify/delete<br>
  	 *  ERP AR Interface(EAI : FNS019-0001).<br>
	 * 
	 * @param CustDailyExRateVO[] custDailyExrateVos
	 * @param String userId
	 * @param String[] officeArr
	 * @return String
	 * @exception EventException
	 */
	public String manageCustomerDailyExchangeRateMulti(CustDailyExRateVO[] custDailyExrateVos, String userId, String[] officeArr) throws EventException;
	
	/**
	 * Customer ratesregister various Customer same rates apply<br>
  	 * ERP AR Interface(EAI : FNS019-0001)<br>
	 * 
	 * @param MultiCustomerVO[] multiCustomerVos
	 * @param CustDailyExRateVO[] custDailyExRateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageMultiCustomerExRate(MultiCustomerVO[] multiCustomerVos, CustDailyExRateVO[] custDailyExRateVos, String userId) throws EventException;

	/**
	 * rates Type Customer apply rates retrieve<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception EventException
	 */
	public List<CustDailyExRateVO> searchCustomerExchangeRateList(SearchExRateVO searchExRateVO) throws EventException;

	/**
	 * Customer by month register rates check <br>
	 * 
	 * @param String cust_cnt_cd
	 * @param String cust_seq
	 * @param String mon
	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerMonExRate(String cust_cnt_cd, String cust_seq, String mon) throws EventException;

	/**
	 * retrieve condition Port list data<br>
	 * 
	 * @param String svrId
	 * @param String ofc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchPortList(String svrId, String ofc) throws EventException;

	/**
	 * VVD and Flight information reference rates retrieve <br>
   	 * select Bound I/B. O/B.<br>
	 * 
	 * @param SearchVVDPortVO searchByBndVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchPortListByBnd(SearchVVDPortVO searchByBndVo) throws EventException;

	/**
	 * VVD  and Flight information reference rates retrieve<br>
   	 * select Triangle.<br>
	 * 
	 * @param SearchVVDPortVO searchByTriVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchPortListByTri(SearchVVDPortVO searchByTriVo) throws EventException;
	
	/**
	 * VVD  and Flight information reference rates retrieve<br>
   	 * select EUR.<br>
	 * 
	 * @param SearchVVDPortVO searchByTriVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchEURPortList(SearchVVDPortVO searchByTriVo) throws EventException;
	
	/**
	 * EUR in case, Flight information Create VVD, PORT list retrieve<br>
	 * 
	 * @param String vvd_cd
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchEURVVDList(String vvd_cd) throws EventException;

	/**
	 *  rates taget VSL SKD retrieve, each VVD rates Bound/port/service scop/each money register<br>
	 * 
	 * @param List<VVDandPortListVO>  vvdPortListVos
	 * @param List<VVDExrateVO> vvdExRtVos
	 * @param String userId
	 * @exception EventException
	 */
	public void createVVDExchangeRate(List<VVDandPortListVO> vvdPortListVos, List<VVDExrateVO> vvdExRtVos, String userId) throws EventException;

	/**
	 * ratesdelete  AR Invoice(Charge) validate data rates apply retrieve.<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @return String
	 * @exception EventException
	 */
	public String searchARInvoiceExist(ExchangeRateVO exRateVo) throws EventException;

	/**
	 * each VVD rates Bound/port/service scop/each money register/modify/delete<br>
     * ERP AR Interface(EAI : FNS019-0002).<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageVVDExchangeRate(VVDExrateVO[] vvdExrateVos, String userId) throws EventException;

	/**
	 * rates type list retrieve<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return ExRateListVO
	 * @exception EventException
	 */
	public ExRateListVO searchExchangeRateList(SearchVVDExRateVO searchVVDexRateVO) throws EventException;
	
	/**
	 * Currency MDM_ORGANIZATION AR Currency register check<br>
	 * 
	 * @param String ofc
	 * @param String currCd
	 * @return int
	 * @exception EventException
	 */
	public int searchARCurrCd( String ofc, String currCd ) throws EventException;
	
	/**
	 * Vessel Schedule 테이블에서 VVD에 해당하는 PORT를 조회하여 해당 List에 Setting한다.<br>
	 * 
	 * @param String vvd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchPortListbyVVD(String vvd) throws EventException;
	
	/**
	 * Vessel Schedule 의 Lane 으로 Service Scope 을 구해 List에 Setting한다.<br>
	 * 
	 * @param String vvd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSvcScpByLane(String vvd) throws EventException;
	
	/**
	 * INV_VVD_XCH_RT_DT 테이블에 조건에 해당하는 환율기준날짜를 조회한다.<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return List<VVDExrateVO>
	 * @exception EventException
	 */
	public List<VVDExrateVO> searchVVDExRateDateList(SearchVVDExRateVO searchVVDexRateVO) throws EventException;
	
	/**
	 * VVD 환율기준날짜 및 VVD 환율을 입력/수정/삭제한다.<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @param String userId
	 * @param String uiFlag
	 * @return List<VVDExrateVO>
	 * @exception EventException
	 */
	public List<VVDExrateVO> manageVVDExchangeRateDate(VVDExrateVO[] vvdExrateVos, String userId, String uiFlag) throws EventException;
	
	/**
	 * INV_VVD_XCH_RT_DT_HIS 테이블에서 환율기준날짜 History 를 조회한다.<br>
	 * 
	 * @param VVDExrateDateHisVO vvdExrateDateHisVO
	 * @return List<VVDExrateDateHisVO>
	 * @exception EventException
	 */
	public List<VVDExrateDateHisVO> searchVVDExRateDateHistList(VVDExrateDateHisVO vvdExrateDateHisVO) throws EventException;
	
	/**
	 * INV AR CHARGE 테이블에서 해당 환율이 반영된 데이터가 존재하는지 체크한다.<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @return String
	 * @exception EventException
	 */
	public String searchARInvoiceExist2(VVDExrateVO[] vvdExrateVos) throws EventException;
	
	/**
	 * DAILY 환율 (환율타입:V) 이 존재하는지 체크한다.<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @return String
	 * @exception EventException
	 */
	public String searchDailyExRateExist(VVDExrateVO[] vvdExrateVos) throws EventException;
	
	/**
	 * INV_VVD_XCH_RT 테이블의 환율을 조회한다.<br>
	 * 
	 * @param VVDExrateVO vvdExrateVO
	 * @return List<ExchangeRateVO>
	 * @exception DAOException
	 */
	
	public List<ExchangeRateVO> searchVVDExRate(VVDExrateVO vvdExrateVO) throws EventException;
	
	/**
	 * Ex.Rate History retrieve<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<ExRateHistoryVO>
	 * @exception EventException
	 */
	public List<ExRateHistoryVO> searchExRateHistoryList(SearchExRateVO searchExRateVO) throws EventException;	
	
	/**
	 * xch_rt_tp_cd retrieve<br>
	 * 
	 * @param String arOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchXchRtTpCd(String arOfcCd) throws EventException;	
	
	/**
	 * searchDailyExchangeRateTmpList <br>
	 * 
	 * @param String arOfcList
	 * @param String tmpPK
	 * @return List<DailyExchangeRateTmpVO>
	 * @exception EventException
	 */
	public List<DailyExchangeRateTmpVO> searchDailyExchangeRateTmpList(String arOfcList, String tmpPK) throws EventException;	
	
	/**
	 * removeDailyExchangeRateTmpList <br>
	 * 
	 * @param String tmpPK
	 * @exception EventException
	 */
	public void removeDailyExchangeRateTmpList(String tmpPK) throws EventException;		
	
	/**
	 * Check whether VVD exchange rate date exists but VVD rate doesn't exist<br>
	 * 
	 * @param String fmDt
	 * @param String ofcList
	 * @return String
	 * @exception EventException
	 */
	public String search3rdExRateNotExist(String fmDt, String ofcList) throws EventException;

}
