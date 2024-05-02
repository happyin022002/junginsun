/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : INVCommonBCImpl.java
*@FileTitle : INVCommon
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.invcommon.invcommon.integration.INVCommonDBDAO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ARCurrCdVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ChinaDailyExrateInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.CodeInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.CustExrateInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExrateDivisionVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDExrateInputVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.PriRatUtVO;

/**
 * INVCommon Business Logic Basic Command implementation<br>
 * - INVCommon business logic process.<br>
 *
 * @author saeil kim
 * @see INVCommonEventResponse,INVCommonBC each DAO class reference
 * @since J2EE 1.4
 */
 
public class INVCommonUtil extends BasicCommandSupport {

	// Database Access Object
	private transient INVCommonDBDAO dbDao = null;

	/**
	 * INVCommonBCImpl object creation<br>
	 * INVCommonDBDAO creation.<br>
	 */
	public INVCommonUtil() {
		dbDao = new INVCommonDBDAO();
	}
	
	
	/**
	 * retrieve event process<br>
	 *  INVCommonscreen SCOPE retrieve  event process<br>
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
	 * retrieve event process<br>
	 * User ID A/R Office information retrieve<br>
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
	 * retrieve event process<br>
	 *  INVCommonscreen AR CUSTOMER retrieve  event process<br>
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
	 * retrieve event process<br>
	 * INVCommon screen currency List value<br>
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
	 * retrieve event process<br>
	 * INVCommon screen accounting rates value.<br>
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
	 * retrieve event process<br>
	 * INVCommonscreen currency List value.<br>
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
	 * retrieve event process<br>
	 * INVCommonscreen currency List value.<br>
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
	 * retrieve event process<br>
	 * INVCommonscreen Ex.Rage value.<br>
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
		String arCurr = "";
		String altnCd = "";
		String lclFlg = "N";
				
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

			if( bkgNo.equals("") && exRate.getBlSrcNo() != null ){
				if(!exRate.getBlSrcNo().equals("")){
					bkgNo= dbDao.searchBkgNoByBlNo(exRate.getBlSrcNo());
					
					if(bkgNo != null && !("").equals(bkgNo)){
						exRate.setBkgNo(bkgNo);
					}
				}
			}
			svcScp = exRate.getSvcScp();			
			
			//2015.01.09 add search office currency
			ARCurrCdVO arCurrCdVo = dbDao.searchOfficeCurrency(ofcCd);
			
			if(arCurrCdVo != null){
				arCurr = arCurrCdVo.getArCurrCd();
				altnCd = arCurrCdVo.getAltnCurrCd();
			}
			
			if(("LCL").equals(altnCd) && !("USD").equals(arCurr) && ("USD").equals(lclCurr)) lclFlg = "Y";
					
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
			log.info("########## arCurr : "+arCurr);
			log.info("########## altnCd : "+altnCd);
			
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
			
			if ((usdExrateType.equals("I") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("I") && !curr.equals("USD") && !curr.equals(arCurr))) {
				
				if (cngIndivCd.equals("O")) {
					
					exRateDate = dbDao.searchSailingDate( bkgNo );
					log.info("\n########## exRateDate1 : "+exRateDate);
					
					
//				<:cng_indiv_cd = 'B'>	
				} else if (cngIndivCd.equals("B")) {
					
					exRateDate = dbDao.searchBLOnDate(bkgNo);	
					log.info("\n########## exRateDate2 : "+exRateDate);
					
//				<:cng_indiv_cd = 'C'>	
				} else if (cngIndivCd.equals("C")) {
					
					exRateDate = dbDao.searchCargoReceiveDate(bkgNo);
					log.info("\n########## exRateDate3 : "+exRateDate);
					
					
//				<:cng_indiv_cd = 'N'>	
				} else if (cngIndivCd.equals("N")) {
					/*
					portCd = dbDao.searchBKGPortCd(bnd, bkgNo);							
					exRateDate = dbDao.searchSailingArrivalDate(bnd, bkgNo, portCd);
					*/
					exRateDate = saDt;
					log.info("\n########## exRateDate4 : "+exRateDate);
					
				}
				
//				<:ex_rate_date >= :aply_st_dt>
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
						
						if((v_exRate.equals("0")||v_exRate.equals("")) && ("Y").equals(lclFlg)){
							custExrateVo.setLclCurr(arCurr);
							v_exRate = dbDao.searchCustomerUSDExrate(custExrateVo);
						}
					

					} else {
						usdExrateType_temp = dbDao.searchSetupOfficeForExrateType(ofcCd); ////////////////////////////////
						if(usdExrateType_temp!=null&&!usdExrateType_temp.equals("")) {
							usdExrateType = usdExrateType_temp.substring(0, 1);
							thirdExrateType = usdExrateType_temp.substring(1, 2);
							exRateDate = "";
						} 
					}

				} else { 
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
					
					if((v_exRate.equals("0")||v_exRate.equals("")) && ("Y").equals(lclFlg)){
						vvdExrateVo.setLclCurr(arCurr);
						v_exRate = dbDao.searchVVDUSDExrate(vvdExrateVo);
					}
				}
			} 
			
			
//			<(:usd_exrate_type = 'V' AND :curr = 'USD') OR (:third_exrate_type = 'V' AND :curr <> 'USD')>				
			
			if((usdExrateType.equals("V") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("V") && !curr.equals("USD") && !curr.equals(arCurr))) {
				
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
				
				if((v_exRate.equals("0")||v_exRate.equals("")) && ("Y").equals(lclFlg)){
					vvdExrateVo.setLclCurr(arCurr);
					v_exRate = dbDao.searchVVDUSDExrate(vvdExrateVo);
				}
				
//			<(:usd_exrate_type = 'A' AND :curr = 'USD') OR (:third_exrate_type = 'A' AND :curr <> 'USD')>	
			
			} else if((usdExrateType.equals("A") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("A") && !curr.equals("USD") && !curr.equals(arCurr))) {
				
				v_exRate = dbDao.searchAccountExrate(exRate);	///////////////////////////////////////	
				
//			<(:usd_exrate_type = 'F' AND :curr = 'USD') OR (:third_exrate_type = 'F' AND :curr <> 'USD')>	
				
			} else if((usdExrateType.equals("F") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("F") && !curr.equals("USD") && !curr.equals(arCurr))) {
				
				v_exRate = dbDao.searchFixedExrate(ofcCd);				
				
//			<(:usd_exrate_type = 'C' AND :curr = 'USD') OR (:third_exrate_type = 'C' AND :curr <> 'USD')>	
				
			} else if((usdExrateType.equals("C") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("C") && !curr.equals("USD") && !curr.equals(arCurr))) {
	
				chinaDailyExrateVo.setBnd(bnd);
				chinaDailyExrateVo.setSaDt(saDt);
				chinaDailyExrateVo.setCurr(curr);
				chinaDailyExrateVo.setLclCurr(lclCurr);
				chinaDailyExrateVo.setOfcCd(ofcCd);
				chinaDailyExrateVo.setExrateType("C");
				
				v_exRate = dbDao.searchChinaDailyExrate(chinaDailyExrateVo);				
				exRateDate = saDt;
				
				// If daily rates = 0, accounting rates
				if(v_exRate.equals("0")||v_exRate.equals("")){
					v_exRate = dbDao.searchAccountExrate(exRate);
				}	
			
			} else if((usdExrateType.equals("D") && (curr.equals("USD") || curr.equals(arCurr))) || (thirdExrateType.equals("D") && !curr.equals("USD") && !curr.equals(arCurr))) {
	
				chinaDailyExrateVo.setBnd(bnd);
				chinaDailyExrateVo.setSaDt(saDt);
				chinaDailyExrateVo.setCurr(curr);
				chinaDailyExrateVo.setLclCurr(lclCurr);
				chinaDailyExrateVo.setOfcCd(ofcCd);
				chinaDailyExrateVo.setExrateType("D");
				
				v_exRate = dbDao.searchChinaDailyExrate(chinaDailyExrateVo);				
				exRateDate = saDt;
				
				if((v_exRate.equals("0")||v_exRate.equals("")) && ("Y").equals(lclFlg)){
					chinaDailyExrateVo.setLclCurr(arCurr);
					v_exRate = dbDao.searchChinaDailyUSDExrate(chinaDailyExrateVo);
				}
				
				if(v_exRate.equals("0")||v_exRate.equals("")){
					v_exRate = dbDao.searchAccountExrate(exRate);
				}	
			}
			
			if(!thirdExrateType.equals("") && !curr.equals("USD") && !curr.equals(arCurr)){
				if(v_exRate.equals("0")||v_exRate.equals("")){
					v_exRate = dbDao.searchAccountExrate(exRate); ///////////////
				}				
			}
			
//			<:lcl_curr = :curr in case>
			if (lclCurr.equals(curr)) {
				v_exRate = "1";
			}
			
			log.info("########## curr : "+curr);
			log.info("########## exRate : "+v_exRate);
			log.info("########## usdExrateType : "+usdExrateType);
			log.info("########## thirdExrateType : "+thirdExrateType);
			log.info("########## exRateDate : "+exRateDate);
			
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
	 * retrieve event process<br>
	 *  INVCommonscreen S/A Date retrieve  event process<br>
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
	 * INVCommon event vsl_eng_nm retrieve event process<br>
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
	 * retrieve event process<br>
	 * Effective Date retrieve  event process<br>
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
	 * retrieve event process<br>
	 * Sailing Date retrieve  event process<br>
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
	 * Each user printer name retrieve  event process<br>
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
	 * retrieve event process<br>
	 * Lane retrieve  event process<br>
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
	 * retrieve event process<br>
	 * INVCommonscreen per_tp_cd List value.<br>
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
	 * retrieve event process<br>
	 * Local Time Date retrieve.<br>
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
	 * retrieve event process<br>
	 * Code Description.<br>
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
	 * retrieve event process<br>
	 * INVCommon screen 가장 최근의 환율 데이터를 가져온다.<br>
	 * 
	 * @param String fromCurrCd
	 * @param String toCurrCd
	 * @param String arOfcCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchLatestRate(String fromCurrCd,String toCurrCd, String arOfcCd) throws EventException {
		try {
			return dbDao.searchLatestRate(fromCurrCd,toCurrCd, arOfcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00001",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00001",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * VVD로 VSL Eng Name을 가져온다.<br>
	 * 
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 */
	public String searchVslName(String vvd) throws EventException {
		try {
			return dbDao.searchVslName(vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00001",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00001",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * makeInQueryStr <br>
	 * 
	 * @param String listStr
	 * @param String separator
	 * @return String
	 * @exception EventException
	 */
	public String makeInQueryStr(String listStr, String separator) {
		String inStr = "";
		
		String[] arrStr = listStr.split(separator);
		for( int i=0; i < arrStr.length; i++) {
			if(!arrStr[i].trim().equals("") ) { 
				  inStr += "'" + arrStr[i] + "'";
				  if(i < arrStr.length-1) {
					  inStr += ",";
				  }
			  }
		}
		return inStr;
	}
	
	/**
	 * undoMakeInQueryStr <br>
	 * 
	 * @param String listStr
	 * @return String
	 */
	public String undoMakeInQueryStr(String listStr) {
		String undoStr = "";
		if (listStr != null && listStr.length() > 0) { 
			undoStr = listStr.replaceAll("'", "");
			
			if((undoStr.length()-1) == undoStr.lastIndexOf(",")) {
				undoStr = undoStr.substring(0, undoStr.length()-1);
			}
		}
		
		return undoStr;
		
	}	  
	

	/**
	 * LPAD <br>
	 * 
	 * @param String str
	 * @param int size
	 * @param String fStr
	 * @return String
	 */
	public String lPad(String str, int size, String fStr) {
	    byte[] b = str.getBytes();
	    int len = b.length;
	  
	    int tmp = size - len;
	  
	    for (int i=0; i < tmp ; i++){
	         str = fStr.concat(str);   
	    }
	    return str;
	}
	
	/**
	 * RPAD <br>
	 * 
	 * @param String str
	 * @param int size
	 * @param String fStr
	 * @return String
	 */
	public String rPad(String str, int size, String fStr){
	  
	    byte[] b = str.getBytes();
	    int len = b.length;
	  
	    int tmp = size - len;
	  
	    for (int i=0; i < tmp ; i++) {
	        str = str.concat(fStr);  
	    }
	    return str;
	}


	

	
}