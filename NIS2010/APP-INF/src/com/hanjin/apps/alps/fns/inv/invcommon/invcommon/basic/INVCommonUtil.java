/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : INVCommonBCImpl.java
*@FileTitle : INVCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.24 김세일
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.05.12 김태균 [CHM-201110564-01] AR Invoice - VVD 조회 기능 개발 요청 - 신규
* 2012.01.03 권   민 [CHM-201115278] Split 01-환율 적용관련 보완 요청(AR INV & ERP AR)
* 2012.03.21 권   민 [CHM-201216481] ONBOARD DATE 적용 개별환율 화주 일괄 업데이트 관련 개발 요청  
=========================================================*/
package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration.INVCommonDBDAO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ChinaDailyExrateInputVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.CodeInputVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.CustExrateInputVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExrateDivisionVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.VVDExrateInputVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.PriRatUtVO;

/**
 * ALPS-INVCommon Business Logic Basic Command implementation<br>
 * - ALPS-INVCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author saeil kim
 * @see INVCommonEventResponse,INVCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
 
public class INVCommonUtil extends BasicCommandSupport {

	// Database Access Object
	private transient INVCommonDBDAO dbDao = null;

	/**
	 * INVCommonBCImpl 객체 생성<br>
	 * INVCommonDBDAO를 생성한다.<br>
	 */
	public INVCommonUtil() {
		dbDao = new INVCommonDBDAO();
	}
	
	/**
	 * INVCommonUtil 객체 생성<br>
	 * INVCommonDBDAO를 생성한다.<br>
	 * @param String dataSource
	 */
	public INVCommonUtil(String dataSource) {
		dbDao = new INVCommonDBDAO(dataSource);
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 *  INVCommon화면에 SCOPE 조회  이벤트 처리<br>
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchServiceScopeList() throws EventException {
		try {
			return dbDao.searchServiceScopeList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * 조회 이벤트 처리<br>
	 * User ID 소속의 A/R Office 관련 정보를 조회한다<br>
	 * 
	 * @param String ofcCd
	 * @param String pageType
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAROfficeList(String ofcCd, String pageType) throws EventException {
		try {
			return dbDao.searchAROfficeList(ofcCd, pageType);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}		

	
	/**
	 * 조회 이벤트 처리<br>
	 *  INVCommon화면에 AR CUSTOMER 조회  이벤트 처리<br>
	 * 
	 * @param String cntryCd
	 * @param String custCd
	 * @param String custRgstNo
	 * @return ARCustomerVO
	 * @exception EventException
	 */
	public ARCustomerVO searchARCustomer(String cntryCd , String custCd, String custRgstNo) throws EventException {
		try {
			return dbDao.searchARCustomer(cntryCd, custCd, custRgstNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00008",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00008",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 currency List에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyCodeList() throws EventException {
		try {
			return dbDao.searchCurrencyCodeList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 경리환율 해당되는 값을 불러온다.<br>
	 * 
	 * @param String fromCurrCd
	 * @param String toCurrCd
	 * @param String effDt
	 * @return String
	 * @exception EventException
	 */
	public String searchAccountRate(String fromCurrCd,String toCurrCd,String effDt) throws EventException {
		try {
			return dbDao.searchAccountRate(fromCurrCd,toCurrCd,effDt);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00001",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00001",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 currency List에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<MdmChargeVO>
	 * @exception EventException
	 */
	public List<MdmChargeVO> searchChargeCodeList() throws EventException {
		try {
			return dbDao.searchChargeCodeList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 currency List에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @return List<MdmChargeVO>
	 * @exception EventException
	 */
	public List<MdmChargeVO> searchChargeCodeList(String ofcCd) throws EventException {
		try {
			return dbDao.searchChargeCodeList(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param VVDCustomerVO exRate
	 * @return ExchangeRateVO
	 * @exception EventException
	 */
	public ExchangeRateVO searchExchangeRate(VVDCustomerVO exRate) throws EventException {
		log.info("INVCommonBC:searchExchangeRate");
//		DBRowSet rowSet = null;
//		List<ExrateDivisionVO> list = new ArrayList<ExrateDivisionVO>();
		ExrateDivisionVO exrateDivisionVo = new ExrateDivisionVO();
		CustExrateInputVO custExrateVo = new CustExrateInputVO();
		VVDExrateInputVO vvdExrateVo = new VVDExrateInputVO();
		ChinaDailyExrateInputVO chinaDailyExrateVo = new ChinaDailyExrateInputVO();
		ExchangeRateVO exchangeRateVo = new ExchangeRateVO();
		
		String invCntryCd = "";
		String invCustCd = "";
		String ofcCd = "";
		String lclCurr = "";
		String curr = "";
		String bnd = "";
		String vsl = ""; 
		String voy = "";
		String dep = "";
		String pol = "";
		String pod = "";
		String saDt = "";
		String bkgNo = "";
		//String blSrcNo = "";
		String svcScp = "";
				
		String divCd1 = "";
		String divCd2 = "";
		String aplyStdt = "";
		String cngIndivCd = "";		
		String exRateDate = "";
		//String portCd = "";
		
		String v_exRate = "0";
		String usdExrateType = "";
		String usdExrateType_temp = "";
		String thirdExrateType = "";
		
		try {
			invCntryCd = exRate.getInvCntryCd();
			invCustCd = exRate.getInvCustCd();
			ofcCd = exRate.getOfcCd();
			lclCurr = exRate.getLclCurr();
			curr = exRate.getCurr();
			bnd = exRate.getBnd();
			vsl = exRate.getVsl(); 
			voy = exRate.getVoy(); 
			dep = exRate.getDep(); 
			pol = exRate.getPol(); 
			pod = exRate.getPod(); 
			if(exRate.getSaDt() != null) {
				saDt = exRate.getSaDt().replace("-", ""); 
			} else {
				saDt = exRate.getSaDt(); 
			}
			
			bkgNo = exRate.getBkgNo();
			//2010-04-27 BkgNo 없을때 blNo로 BkgNo를 구한다.
			if( bkgNo.equals("") && exRate.getBlSrcNo() != null ){
				if(!exRate.getBlSrcNo().equals("")){
					bkgNo= dbDao.searchBkgNoByBlNo(exRate.getBlSrcNo());
				}
			}
			svcScp = exRate.getSvcScp();			
			
			log.info("########## invCntryCd : "+invCntryCd);
			log.info("########## invCustCd : "+invCustCd);
			log.info("########## ofcCd : "+ofcCd);
			log.info("########## lclCurr : "+lclCurr);
			log.info("########## curr : "+curr);
			log.info("########## bnd : "+bnd);
			log.info("########## vsl : "+vsl);
			log.info("########## voy : "+voy);
			log.info("########## dep : "+dep);
			log.info("########## pol : "+pol);
			log.info("########## pod : "+pod);
			log.info("########## saDt : "+saDt);
			log.info("########## bkgNo : "+bkgNo);
			log.info("########## svcScp : "+svcScp);
			
			exrateDivisionVo = dbDao.searchCustomerExrateDivision(invCntryCd, invCustCd); //////////////////////	
			
			log.info("########## exrateDivisionVo : "+exrateDivisionVo);
			
			if (exrateDivisionVo != null) {
				divCd1 = exrateDivisionVo.getDivCd1();  
				divCd2 = exrateDivisionVo.getDivCd2(); 
				aplyStdt = exrateDivisionVo.getAplyStDt();
				cngIndivCd = exrateDivisionVo.getCngIndivCd();
			}		
			
			log.info("########## divCd1 : "+divCd1);
			log.info("########## divCd2 : "+divCd2);
			log.info("########## aplyStdt : "+aplyStdt);
			log.info("########## cngIndivCd : "+cngIndivCd);
			

			if (divCd1.equals(bnd) || divCd1.equals("A")) {
				usdExrateType = "I";
				if (divCd2.equals("3")) {
					thirdExrateType = "I";
				} else {
					thirdExrateType = dbDao.searchSetupOfficeForThirdExrateType(ofcCd);
				}
			} else {				
				usdExrateType_temp = dbDao.searchSetupOfficeForExrateType(ofcCd); ////////////////////////////////
				if(usdExrateType_temp!=null&&!usdExrateType_temp.equals("")) {
					usdExrateType = usdExrateType_temp.substring(0, 1);
					thirdExrateType = usdExrateType_temp.substring(1, 2);
				} 
			}
 
			
//			<(:usd_exrate_type = 'I' AND :curr = 'USD') OR (:third_exrate_type = 'I' AND :curr <> 'USD')>
			
			if ((usdExrateType.equals("I") && curr.equals("USD")) || (thirdExrateType.equals("I") && !curr.equals("USD"))) {
				
//				<:cng_indiv_cd = 'O', 'I' 인 경우 -> 'O'인경우 Sailing Date로 수정 2010-04-26
				if (cngIndivCd.equals("O")) {
					
					exRateDate = dbDao.searchSailingDate( bkgNo );
					log.info("\n########## exRateDate1 : "+exRateDate);
					
					
//				<:cng_indiv_cd = 'B' 인 경우>	
				} else if (cngIndivCd.equals("B")) {
					
					exRateDate = dbDao.searchBLOnDate(bkgNo);	
					log.info("\n########## exRateDate2 : "+exRateDate);
					
//				<:cng_indiv_cd = 'C' 인 경우>	
				} else if (cngIndivCd.equals("C")) {
					
					exRateDate = dbDao.searchCargoReceiveDate(bkgNo);
					log.info("\n########## exRateDate3 : "+exRateDate);
					
					
//				<:cng_indiv_cd = 'N' 인 경우>	
				} else if (cngIndivCd.equals("N")) {
					/*
					portCd = dbDao.searchBKGPortCd(bnd, bkgNo);							
					exRateDate = dbDao.searchSailingArrivalDate(bnd, bkgNo, portCd);
					*/
					exRateDate = saDt;
					log.info("\n########## exRateDate4 : "+exRateDate);
					
				}
				
//				<:ex_rate_date >= :aply_st_dt 인 경우>
				if(!exRateDate.equals("")&&!aplyStdt.equals("")){
					if (Integer.parseInt(exRateDate) >= Integer.parseInt(aplyStdt)) {					
						
						custExrateVo.setInvCntryCd(invCntryCd);
						custExrateVo.setInvCustCd(invCustCd);
						custExrateVo.setBnd(bnd);
						custExrateVo.setCurr(curr);
						custExrateVo.setLclCurr(lclCurr);
						custExrateVo.setOfcCd(ofcCd);
						custExrateVo.setExRateDate(exRateDate);					
						
						v_exRate = dbDao.searchCustomerExrate(custExrateVo);
					
					// 날짜 범위 밖일경우 오피스의 환율 타입으로 세팅 2010-04-21
					} else {
						usdExrateType_temp = dbDao.searchSetupOfficeForExrateType(ofcCd); ////////////////////////////////
						if(usdExrateType_temp!=null&&!usdExrateType_temp.equals("")) {
							usdExrateType = usdExrateType_temp.substring(0, 1);
							thirdExrateType = usdExrateType_temp.substring(1, 2);
							exRateDate = "";
						} 
					}
					log.debug("INVCommonUtil 1 :: v_exRate =" + v_exRate);
				// 환율일자가 없어서 환율을 못구한 경우 환율만  VVD 환율로 대체한다. TYPE은 유지 2010-07-12
				// [CHM-201115278] 요청으로 개별환율이 없을경우 VVD로 환율대체 중지
				// [CHM-201115278] 개별환율이 없으면 환율 Type 은 개별환율로 그대로 유지하고, 환율은 0 으로 한다					
				} else { 
					/*
					vvdExrateVo.setVsl(vsl);
		            vvdExrateVo.setVoy(voy);
		            vvdExrateVo.setDep(dep);
		            vvdExrateVo.setBnd(bnd);
		            vvdExrateVo.setPol(pol);
		            vvdExrateVo.setPod(pod);
		            vvdExrateVo.setLclCurr(lclCurr);
		            vvdExrateVo.setCurr(curr);
		            vvdExrateVo.setSvcScp(svcScp);
		            vvdExrateVo.setOfcCd(ofcCd);				
					
					v_exRate = dbDao.searchVVDExrate(vvdExrateVo);
					*/
					v_exRate	= "0";
					log.debug("INVCommonUtil 2 :: v_exRate =" + v_exRate);
				}
			} 
			
			
//			<(:usd_exrate_type = 'V' AND :curr = 'USD') OR (:third_exrate_type = 'V' AND :curr <> 'USD')>				
			
			if((usdExrateType.equals("V") && curr.equals("USD")) || (thirdExrateType.equals("V") && !curr.equals("USD"))) {
				
				vvdExrateVo.setVsl(vsl);
	            vvdExrateVo.setVoy(voy);
	            vvdExrateVo.setDep(dep);
	            vvdExrateVo.setBnd(bnd);
	            vvdExrateVo.setPol(pol);
	            vvdExrateVo.setPod(pod);
	            vvdExrateVo.setLclCurr(lclCurr);
	            vvdExrateVo.setCurr(curr);
	            vvdExrateVo.setSvcScp(svcScp);
	            vvdExrateVo.setOfcCd(ofcCd);				
				
				v_exRate = dbDao.searchVVDExrate(vvdExrateVo);
				log.debug("INVCommonUtil 3 :: v_exRate =" + v_exRate);
//			<(:usd_exrate_type = 'A' AND :curr = 'USD') OR (:third_exrate_type = 'A' AND :curr <> 'USD')>	
			
			} else if((usdExrateType.equals("A") && curr.equals("USD")) || (thirdExrateType.equals("A") && !curr.equals("USD"))) {
				
				v_exRate = dbDao.searchAccountExrate(bkgNo, curr, lclCurr);	///////////////////////////////////////			
				log.debug("INVCommonUtil 4 :: v_exRate =" + v_exRate);
//			<(:usd_exrate_type = 'F' AND :curr = 'USD') OR (:third_exrate_type = 'F' AND :curr <> 'USD')>	
				
			} else if((usdExrateType.equals("F") && curr.equals("USD")) || (thirdExrateType.equals("F") && !curr.equals("USD"))) {
				
				v_exRate = dbDao.searchFixedExrate(ofcCd);				
				log.debug("INVCommonUtil 5 :: v_exRate =" + v_exRate);
//			<(:usd_exrate_type = 'C' AND :curr = 'USD') OR (:third_exrate_type = 'C' AND :curr <> 'USD')>	
				
			} else if((usdExrateType.equals("C") && curr.equals("USD")) || (thirdExrateType.equals("C") && !curr.equals("USD"))) {
	
				chinaDailyExrateVo.setBnd(bnd);
				chinaDailyExrateVo.setSaDt(saDt);
				chinaDailyExrateVo.setCurr(curr);
				chinaDailyExrateVo.setLclCurr(lclCurr);
				chinaDailyExrateVo.setOfcCd(ofcCd);
				chinaDailyExrateVo.setExrateType("C");
				
				v_exRate = dbDao.searchChinaDailyExrate(chinaDailyExrateVo);				
				exRateDate = saDt;
				log.debug("INVCommonUtil 6 :: v_exRate =" + v_exRate);
				//daily 환율 0이면 경리환율
				// [CHM-201115278] 요청으로 CHINA 환율이 없을 경우 경리환율로 환율대체 중지
				// [CHM-201115278] CHINA환율이 없으면 환율 Type 은 CHINA환율로 그대로 유지하고, 환율은 0 으로 한다
				if(v_exRate.equals("0")||v_exRate.equals("")){
					//v_exRate = dbDao.searchAccountExrate(bkgNo, curr, lclCurr);
					v_exRate = "0";
				}	
			
			} else if((usdExrateType.equals("D") && curr.equals("USD")) || (thirdExrateType.equals("D") && !curr.equals("USD"))) {
	
				chinaDailyExrateVo.setBnd(bnd);
				chinaDailyExrateVo.setSaDt(saDt);
				chinaDailyExrateVo.setCurr(curr);
				chinaDailyExrateVo.setLclCurr(lclCurr);
				chinaDailyExrateVo.setOfcCd(ofcCd);
				chinaDailyExrateVo.setExrateType("D");
				
				//v_exRate = dbDao.searchChinaDailyExrate(chinaDailyExrateVo);				
				//exRateDate = saDt;
				
				// [CHM-201115278] 요청으로 DAILY환율은 ALPS INVOICE 에서는 환율 Type 은 DAILY환율로 하고, 환율은 Sailing Date 기준으로 경리환율로 대체 한다
				// [CHM-201115278] 환율 적용일자 역시 Sailing Date 로 한다.
				// [CHM-201115278] INTERFACE 나 UI 에서 환율 재계산 시에는 DAILY 환율은 Sailing Date 기준으로 경리환율을 구하고
				// [CHM-201115278] 단, ISSUE 시에는 DAILY 환율인 경우는 INV_CUST_AND_DLY_XCH_RT 테이블에서 구한다
				v_exRate = dbDao.searchAccountExrate(bkgNo, curr, lclCurr);
				exRateDate = dbDao.searchSailingDate( bkgNo );
				
				log.debug("INVCommonUtil 7 :: v_exRate =" + v_exRate);
			// [CHM-201115278] 요청으로 환율타입 추가 
			// 환율타입명: Period 환율(P) 
			// 환율적용기준: S/A DATE를 기준으로 당사의 경리환율을 적용한다.
			}else if((usdExrateType.equals("P") && curr.equals("USD")) || (thirdExrateType.equals("P") && !curr.equals("USD"))) {
				v_exRate = dbDao.searchPeriodExrate(saDt, curr, lclCurr);
				exRateDate = saDt;
				log.debug("INVCommonUtil 8 :: v_exRate =" + v_exRate);
			}
			
			// ThirdType 이고 Currency 가  USD 아닐때 환율이 0이면 경리환율
			if(!thirdExrateType.equals("")&& !curr.equals("USD")){
				if(v_exRate.equals("0")||v_exRate.equals("")){
					v_exRate = dbDao.searchAccountExrate(bkgNo, curr, lclCurr); ///////////////
					log.debug("INVCommonUtil 9 :: v_exRate =" + v_exRate);
				}				
			}
			
//			<:lcl_curr = :curr 인 경우>
			if (lclCurr.equals(curr)) {
				v_exRate = "1";
			}
			
			log.debug("########## curr : "+curr);
			log.debug("########## exRate : "+v_exRate);
			log.debug("########## usdExrateType : "+usdExrateType);
			log.debug("########## thirdExrateType : "+thirdExrateType);
			log.debug("########## exRateDate : "+exRateDate);
			log.debug("INVCommonUtil 10 :: v_exRate =" + v_exRate);
			exchangeRateVo.setCurr(curr);
			exchangeRateVo.setExRate(v_exRate);
			exchangeRateVo.setUsdExrateType(usdExrateType);
			exchangeRateVo.setThirdExrateType(thirdExrateType);
			exchangeRateVo.setExRateDate(exRateDate);			
			exchangeRateVo.setCngIndivCd(cngIndivCd);
			return exchangeRateVo;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  INVCommon화면에 S/A Date 조회  이벤트 처리<br>
	 * 
	 * @param String vvd
	 * @param String port
	 * @param String bnd
	 * @return String
	 * @exception EventException
	 */
	public String searchSADate(String vvd, String port, String bnd) throws EventException {
		try {
			return dbDao.searchSADate(vvd, port, bnd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * INVCommon의 event에 대한 vsl_eng_nm 조회 이벤트 처리<br>
	 * @author Jung Hwi Taek
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 */
	public String searchVesslName(String vvd) throws EventException {
		try {
			return dbDao.searchVesslName(vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * 조회 이벤트 처리<br>
	 * Effective Date 조회  이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @param String sailDt
	 * @return String
	 * @exception EventException
	 */
	public String searchEffectiveDate(String ofcCd, String sailDt) throws EventException {
		try {
			return dbDao.searchEffectiveDate(ofcCd,sailDt);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Sailing Date 조회  이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchSailingDate(String bkgNo) throws EventException {
		try {
			return dbDao.searchSailingDate(bkgNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * User 별 프린터명 조회  이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String searchARPrinterName(String ofcCd, String userId) throws EventException {
		try {
			return dbDao.searchARPrinterName(ofcCd,userId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Lane 조회  이벤트 처리<br>
	 * 
	 * @param String lane
	 * @return String
	 * @exception EventException
	 */
	public String searchSvcLaneCode(String lane) throws EventException {
		try {
			return dbDao.searchSvcLaneCode(lane);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 per_tp_cd List에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<PriRatUtVO>
	 * @exception EventException
	 */
	public List<PriRatUtVO> searchPerTpCdList() throws EventException {
		try {
			return dbDao.searchPerTpCdList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Local Time의 Date를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTime(String ofcCd) throws EventException {
		try {
			return dbDao.searchLocalTime(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Code의 Description 처기.<br>
	 * 
	 * @author SUK Joon
	 * @param CodeInputVO codeInputVO
	 * @return CodeInputVO
	 * @exception EventException
	 */
	public CodeInputVO searchCodeInfo(CodeInputVO codeInputVO) throws EventException {
		String gubun = null;
		CodeInputVO returnVO= new CodeInputVO();
		
		MdmChargeVO mdmChargeVO = null;
		MdmCntrTpSzVO mdmCntrTpSzVO = null;
		
		
		try {
			gubun = codeInputVO.getGubun();
			
				if ("MDMCHARGE".equals(gubun)) {
					mdmChargeVO= dbDao.searchMdmCharge(codeInputVO);
					returnVO.setCodeDesc(mdmChargeVO.getChgNm());
				} else if ("MDMCNTRTPSZ".equals(gubun)){
					mdmCntrTpSzVO= dbDao.searchMdmCntrTpSz(codeInputVO);
					returnVO.setCodeDesc(mdmCntrTpSzVO.getCntrTpszDesc());
				}			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
		return returnVO;
	}	
	
	/**
	 * Common Code List 가져오기<br>
	 * 
	 * @author 김태균
	 * @param CodeInputVO codeInputVO
	 * @return List<CodeInputVO>
	 * @exception EventException
	 */
	public List<CodeInputVO> searchCommonCode(CodeInputVO codeInputVO) throws EventException {
		try {
			return dbDao.searchCommonCode(codeInputVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00075",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  cust_cd 와 cust seq 로 on board date customer 인지 조회 이벤트 처리<br>
	 * 
	 * @param String cntryCd
	 * @param String custCd
	 * @return ExrateDivisionVO
	 * @exception EventException
	 */
	public ExrateDivisionVO searchOnBoardDateCustomerByCustRgstNo(String cntryCd , String custCd) throws EventException {
		try {
			return dbDao.searchCustomerExrateDivision(cntryCd, custCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00008",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00008",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다.<br>
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchRhqList() throws EventException{
		try {
			return dbDao.searchRhqList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	
	
	/**
	 * USER_ID별  COM_USER테이블 OFC_CD조회 이벤트 처리<br>
	 * 
	 * @param usrId
	 * @return
	 * @throws EventException
	 */
	public String searchOfcCdByUserId(String usrId) throws EventException{
		try {
			return dbDao.searchOfcCdByUserId(usrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * User Login Office 별  AR_OFC_CD조회 이벤트 처리<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public List<String> searchAROfficeCode(String ofcCd) throws EventException{
		try {
			return dbDao.searchAROfficeCode(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * User Login Office 별  AR_OFC_CD조회 이벤트 처리<br>
	 * 
	 * @param String chgCd
	 * @return
	 * @throws EventException
	 */
	public String searchChargeName(String chgCd) throws EventException{
		try {
			return dbDao.searchChargeName(chgCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * User Login Office 별  AR_HD_QTR_OFC_CD 조회 이벤트 처리<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public List<String> searchRhqByOfcCd(String ofcCd) throws EventException{
		try {
			return dbDao.searchRhqByOfcCd(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Office 별  AR_HD_QTR_OFC_CD 단건 조회 이벤트 처리<br>
	 * 
	 * @param ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchRhqOfcCd(String ofcCd) throws EventException{
		try {
			return dbDao.searchRhqOfcCd(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
}