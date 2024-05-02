/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRISimulationBCImpl.java
*@FileTitle : PRI Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration.PRISimulationDBDAO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtOutVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriCntrSrhCondVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriSimRoutInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.TrfChgVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSimChgRtVO;
import com.clt.syscommon.common.table.PriSimRtVO;

/**
 * PRISimulation Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRISimulation<br>
 *
 * @author SHKIM
 * @see EsmPri6001EventResponse,PRISimulationBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class PRISimulationBCImpl extends BasicCommandSupport implements PRISimulationBC {

	// Database Access Object
	private transient PRISimulationDBDAO dbDao = null;

	/**
	 * TariffRuleBCImpl 객체 생성<br>
	 * TariffRuleDBDAO를 생성한다.<br>
	 */
	public PRISimulationBCImpl() {
		dbDao = new PRISimulationDBDAO();
	}
	
	//[ESM_PRI_6101] START########################################
	/**
	 * ESM_PRI_6101 : Retrieve <br>
	 * get the result for Contract Info of SC
	 * 
	 * @param PriCntrSrhCondVO priCntrSrhCondVO
	 * @return List<PriCntrInfoVO>
	 * @exception EventException
	 */
	public List<PriCntrInfoVO> searchContractInfoList(PriCntrSrhCondVO priCntrSrhCondVO) throws EventException {
		try {
			
			List<PriCntrInfoVO> reObj = null;
			
			//1 : S/C, 2 : RFA, 3 : TAA
		    if(priCntrSrhCondVO.getSContractType().equals("1")){
		    	reObj = dbDao.searchContractInfoListForSC(priCntrSrhCondVO);
		    } else if(priCntrSrhCondVO.getSContractType().equals("2")){
		    	reObj = dbDao.searchContractInfoListForRFA(priCntrSrhCondVO);
		    } else if(priCntrSrhCondVO.getSContractType().equals("3")){
		    	reObj = dbDao.searchContractInfoListForTAA(priCntrSrhCondVO);
		    }

			return reObj;
		
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	//[ESM_PRI_6101] END########################################

	/**
	 * ESM_PRI_6001 : Retrieve <br>
	 * retrieving created product catalog list
	 * 
	 * @param AplyRtInVO paramVO
	 * @return List<PriSimRoutInfoVO>
	 * @exception EventException
	 */
	public List<PriSimRoutInfoVO> searchProductCatalog(AplyRtInVO paramVO) throws EventException {
		try {
			return dbDao.searchProductCatalog(paramVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_6001 : Contract No Change<br>
	 * Checking Contract Type. (SC,RFA,TAA)<br>
	 * 
	 * @param String ctrtNo
	 * @return String
	 * @exception EventException
	 */
	public String checkCtrtType(String ctrtNo) throws EventException {
		try {
			return dbDao.checkCtrtType(ctrtNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_6002 : Retrieve <br>
	 * retrieving created product catalog list
	 * 
	 * @param AplyRtInVO paramVO
	 * @return List<PriSimRoutInfoVO>
	 * @exception EventException
	 */
	public List<PriSimRoutInfoVO> searchCMCost(AplyRtInVO paramVO) throws EventException {
		try {
			return dbDao.searchCMCost(paramVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	//[ESM_PRI_6101] START########################################
	
	/**
	 * ESM_PRI_6102 : Retrieve <br>
	 * get the result for Revenue Detail Info of Selected Container Size,Commodity
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<AplyRtOutVO>
	 * @exception EventException
	 */
	public List<AplyRtOutVO> searchRevenueDetailInfo(AplyRtInVO aplyRtInVO) throws EventException {
		try {
			return dbDao.searchRevenueDetailInfo(aplyRtInVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	

	private List<SearchScOftAutoratingListVO> manageScSimOftAmount(List<SearchScOftAutoratingListVO> list1) throws EventException {
		
		/*** OARB OA ( +, - calculation SKIP!)*/
		/*

		1. Apply the amount if value exists at RT_ARB_FRT_RT_AMT

		2. OA_FNL_FRT_RT_AMT : 200

		3. (1) TYP : * 0.8 ==> 200 * 0.8 = 160
		   (2) RAC : 
		   (3) RAP : + 200 ==> SKIP! = 160
		   (4) RAR : * 1.2 ==> 160 * 1.2 = 192
		   (5) DOR : 
		   (6) RAS (RT_RAS_FRT_RT_AMT)

		*** THR RT ( +, - calculation)

		*** DARB DA ( +, - calculation SKIP!)

		*** FINAL RATE = OARB + THR + DARB
		*/
		
		/* OARB + THR + DARB = FNL AMOUNT in case of TPE
		 */
				
		log.debug("-------------------------------------START-------------------------------------");
		
		for(SearchScOftAutoratingListVO vo : list1){
			
			double oarb_fnl_amt;  // OARB AMT
			double thr_fnl_amt = 0.0d ; // THR AMT
			double darb_fnl_amt ; // DARB AMT
			
			double oi_fnl_frt_rt_amt ; //OI_FNL_FRT_RT_AMT
			double oa_fnl_frt_rt_amt ; // OA AMT
			double rt_fnl_frt_rt_amt ; // RT AMT
			double da_fnl_frt_rt_amt ; // DA AMT
			double di_fnl_frt_rt_amt ; //DI_FNL_FRT_RT_AMT
			
			String opCd;
			
			vo.setChgCd("OFT");
			
			oi_fnl_frt_rt_amt = Double.parseDouble(vo.getOiFnlFrtRtAmt());
			rt_fnl_frt_rt_amt = Double.parseDouble(vo.getRtFnlFrtRtAmt());
			di_fnl_frt_rt_amt = Double.parseDouble(vo.getDiFnlFrtRtAmt());
			
			/* OIH */
			if(oi_fnl_frt_rt_amt != 0){
				if("C".equals(vo.getOaTypBkgConvTpCd())){
					opCd = vo.getOaTypRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oi_fnl_frt_rt_amt = calcArithmetic(oi_fnl_frt_rt_amt, getDouble(vo.getOaTypFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getOaRacBkgConvTpCd())){
					opCd = vo.getOaRacRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oi_fnl_frt_rt_amt = calcArithmetic(oi_fnl_frt_rt_amt, getDouble(vo.getOaRacFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRapBkgConvTpCd())){
					opCd = vo.getRtRapRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oi_fnl_frt_rt_amt = calcArithmetic(oi_fnl_frt_rt_amt, getDouble(vo.getRtRapFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRarBkgConvTpCd())){
					opCd = vo.getRtRarRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oi_fnl_frt_rt_amt = calcArithmetic(oi_fnl_frt_rt_amt, getDouble(vo.getRtRarFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtDorBkgConvTpCd())){
					opCd = vo.getRtDorRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oi_fnl_frt_rt_amt = calcArithmetic(oi_fnl_frt_rt_amt, getDouble(vo.getRtDorFrtRtAmt()), opCd);
					}
				}
			}
			
			//OARB 
			if(getDouble(vo.getRtArbFrtRtAmt()) != 0){
				oarb_fnl_amt = getDouble(vo.getRtArbFrtRtAmt());
				oa_fnl_frt_rt_amt = getDouble(vo.getRtArbFrtRtAmt());
			}else{
				oa_fnl_frt_rt_amt = Double.parseDouble(vo.getOaFnlFrtRtAmt());
				if("C".equals(vo.getOaTypBkgConvTpCd())){
					opCd = vo.getOaTypRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oa_fnl_frt_rt_amt = calcArithmetic(oa_fnl_frt_rt_amt, getDouble(vo.getOaTypFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getOaRacBkgConvTpCd())){
					opCd = vo.getOaRacRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oa_fnl_frt_rt_amt = calcArithmetic(oa_fnl_frt_rt_amt, getDouble(vo.getOaRacFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRapBkgConvTpCd())){
					opCd = vo.getRtRapRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oa_fnl_frt_rt_amt = calcArithmetic(oa_fnl_frt_rt_amt, getDouble(vo.getRtRapFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRarBkgConvTpCd())){
					opCd = vo.getRtRarRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oa_fnl_frt_rt_amt = calcArithmetic(oa_fnl_frt_rt_amt, getDouble(vo.getRtRarFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtDorBkgConvTpCd())){
					opCd = vo.getRtDorRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						oa_fnl_frt_rt_amt = calcArithmetic(oa_fnl_frt_rt_amt, getDouble(vo.getRtDorFrtRtAmt()), opCd);
					}
				}
				oarb_fnl_amt = oa_fnl_frt_rt_amt;
			}
			
			//THR
			if(rt_fnl_frt_rt_amt > 0) {
				if("C".equals(vo.getRtTypBkgConvTpCd())){
					opCd = vo.getRtTypRtOpCd();
					if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
						rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtTypFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRacBkgConvTpCd())){
					opCd = vo.getRtRacRtOpCd();
					if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
						rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtRacFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRapBkgConvTpCd())){
					opCd = vo.getRtRapRtOpCd();
					if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
						rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtRapFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRarBkgConvTpCd())){
					opCd = vo.getRtRarRtOpCd();
					if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
						rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtRarFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtDorBkgConvTpCd())){
					opCd = vo.getRtDorRtOpCd();
					if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
						rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtDorFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRasBkgConvTpCd())){
					opCd = vo.getRtRasRtOpCd();
					if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
						rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtRasFrtRtAmt()), opCd);
					}
				}
				thr_fnl_amt = rt_fnl_frt_rt_amt;
			}
			
			//DARB
			if(getDouble(vo.getRtAddFrtRtAmt()) != 0){
				darb_fnl_amt = getDouble(vo.getRtAddFrtRtAmt());
				da_fnl_frt_rt_amt = getDouble(vo.getRtAddFrtRtAmt());
			}
			else{
				da_fnl_frt_rt_amt = Double.parseDouble(vo.getDaFnlFrtRtAmt());
				if("C".equals(vo.getDaTypBkgConvTpCd())){
					opCd = vo.getDaTypDaOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						da_fnl_frt_rt_amt = calcArithmetic(da_fnl_frt_rt_amt, getDouble(vo.getDaTypFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getDaRacBkgConvTpCd())){
					opCd = vo.getDaTypDaOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						da_fnl_frt_rt_amt = calcArithmetic(da_fnl_frt_rt_amt, getDouble(vo.getDaRacFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRapBkgConvTpCd())){
					opCd = vo.getRtRapRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						da_fnl_frt_rt_amt = calcArithmetic(da_fnl_frt_rt_amt, getDouble(vo.getRtRapFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRarBkgConvTpCd())){
					opCd = vo.getRtRarRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						da_fnl_frt_rt_amt = calcArithmetic(da_fnl_frt_rt_amt, getDouble(vo.getRtRarFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtAddBkgConvTpCd())){
					opCd = vo.getRtAddRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						da_fnl_frt_rt_amt = calcArithmetic(da_fnl_frt_rt_amt, getDouble(vo.getRtAddFrtRtAmt()), opCd);
					}
				}
				darb_fnl_amt = da_fnl_frt_rt_amt;
			}
			
			//DIH
			if(di_fnl_frt_rt_amt != 0){
				if("C".equals(vo.getDaTypBkgConvTpCd())){
					opCd = vo.getDaTypDaOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						di_fnl_frt_rt_amt = calcArithmetic(di_fnl_frt_rt_amt, getDouble(vo.getDaTypFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getDaRacBkgConvTpCd())){
					opCd = vo.getDaRacDaOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						di_fnl_frt_rt_amt = calcArithmetic(di_fnl_frt_rt_amt, getDouble(vo.getDaRacFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtRapBkgConvTpCd())){
					opCd = vo.getRtRapRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						di_fnl_frt_rt_amt = calcArithmetic(di_fnl_frt_rt_amt, getDouble(vo.getDaRapFrtRtAmt()), opCd);
					}
				}
				if("C".equals(vo.getRtAddBkgConvTpCd())){
					opCd = vo.getRtAddRtOpCd();
					if("*".equals(opCd) || "/".equals(opCd)){
						di_fnl_frt_rt_amt = calcArithmetic(di_fnl_frt_rt_amt, getDouble(vo.getRtAddFrtRtAmt()), opCd);
					}
				}
			}
			
			oi_fnl_frt_rt_amt = (double)Math.round(oi_fnl_frt_rt_amt +0.005d);
			oarb_fnl_amt = (double)Math.round(oarb_fnl_amt + 0.005d);
			thr_fnl_amt  = (double)Math.round(thr_fnl_amt +0.005d);
			darb_fnl_amt = (double)Math.round(darb_fnl_amt+0.005d);
			di_fnl_frt_rt_amt = (double)Math.round(di_fnl_frt_rt_amt +0.005d);
			
			//OIH
			vo.setOiCalcFrtRtAmt(String.valueOf(oi_fnl_frt_rt_amt));
			//OARB
			vo.setOaCalcFrtRtAmt(String.valueOf(oarb_fnl_amt));
			//THR
			vo.setRtCalcFrtRtAmt(String.valueOf(thr_fnl_amt));
			//DARB
			vo.setDaCalcFrtRtAmt(String.valueOf(darb_fnl_amt));
			//DIH
			vo.setDiCalcFrtRtAmt(String.valueOf(di_fnl_frt_rt_amt));

			String fnl_frt_rt_amt = String.valueOf(oi_fnl_frt_rt_amt + oarb_fnl_amt+ thr_fnl_amt+darb_fnl_amt+di_fnl_frt_rt_amt);
			log.debug("not conversion amount!"+ fnl_frt_rt_amt);
			/* ToT Amount Set VO  */
			vo.setFnlFrtRtAmt(fnl_frt_rt_amt);
			log.error("S/C~BKG :"+(vo.getBkgNo())+"AMT: "+vo.getFnlFrtRtAmt());
			log.debug("-------------------------------------END-------------------------------------");
		}
		return list1;
	}
	
//	private List<SearchScOftAutoratingListVO> manageScSimSurchargeAmount(List<SearchScOftAutoratingListVO> list1) throws EventException{
//		try {
//			BigDecimal chgAmt ;
//			BigDecimal chkAmt ;
//			for(int i = 0; i<list1.size(); i++){
//				if(!"PC".equals(list1.get(i).getRatUtCd())){
//					String chgUtAmt = JSPUtil.getNullNoTrim(list1.get(i).getChgUtAmt(),"0.0");
//					String rateAsQty = JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0.0");
//					String amt = JSPUtil.getNullNoTrim(list1.get(i).getChgAmt(),"0.0");
//					
//					chkAmt = new BigDecimal(chgUtAmt).multiply(new BigDecimal(rateAsQty));
//					chgAmt = new BigDecimal(amt);
//					if(chkAmt.compareTo(chgAmt) != 0){
//						log.error("chgUtAmt: "+Double.parseDouble(chgUtAmt));
//						log.error("rateAsQty "+Double.parseDouble(rateAsQty));
//						log.error("Surcharge BKG: "+list1.get(i).getBkgNo()+" PER["+list1.get(i).getRatUtCd()+"]"+" Amount["+list1.get(i).getChgAmt()+"]"+" RATE["+list1.get(i).getChgUtAmt()+"]"+" RATEAS["+list1.get(i).getRatAsQty()+"]");	
//					}
//				}
//			}
//			return list1;
//
//		} catch (Exception ex) {
//			throw new EventException(ex.getMessage(),ex);
//		}
//	}

	private Double calcArithmetic(Double amount, Double rate, String opCd) throws EventException{
		try{
			if("+".equals(opCd)){
				return amount + rate;
			}else if("-".equals(opCd)){
				return amount - rate; 
			}else if("*".equals(opCd)){
				return amount * rate; 
			}else if("/".equals(opCd)){
				return amount / rate; 
			}else{
				throw new EventException("Fail to calculate - operation code : "+opCd);
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	private Double getDouble(String param){
		return Double.parseDouble(JSPUtil.getNullNoTrim(param,"0"));
	}
	
	/**
	 * Putting in action BackEndJob to create and retrieve rating result - Verify Rate/Apply Rate<br>
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createApplyRateBackEndJobStart(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException {
		PRISimulationBackEndJob backEndJob = new PRISimulationBackEndJob();
		backEndJob.setAplyRtInVO(aplyRtInVO);
		backEndJob.setAccount(account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_PRI_6001_Aply_Rate");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	


	/**
	 * manageAmount
	 * 
	 * @param List<SearchRfaOftAutoratingListVO> list
	 * @return SearchRfaOftAutoratingListVO
	 * @exception EventException
	 */
	private List<SearchRfaOftAutoratingListVO> manageRfaSimOftAmount(List<SearchRfaOftAutoratingListVO> list) throws EventException{
		
		for(SearchRfaOftAutoratingListVO vo : list){
			
			double rt_fnl_frt_rt_amt;
			String opCd;

			vo.setChgCd("OFT");
			rt_fnl_frt_rt_amt = getDouble(vo.getRtFnlFrtRtAmt());
			if(vo.getRtAppBkgConvTpCd().equals("C")){
				opCd = vo.getRtAppRtOpCd();
				if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
					rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtAppFrtRtAmt()), opCd);
				}
			}
			if(vo.getRtRasBkgConvTpCd().equals("C")){
				opCd = vo.getRtRasRtOpCd();
				if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
					rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtRasFrtRtAmt()), opCd);
				}
			}
			log.debug("!!rt_fnl_frt_rt_amt"+rt_fnl_frt_rt_amt);
			log.debug("!!oi_fnl_frt_amt"+vo.getOiFnlFrtRtAmt());
			log.debug("!!oa_fnl_frt_amt"+vo.getOaFnlFrtRtAmt());
			log.debug("!!da_fnl_frt_amt"+vo.getDaFnlFrtRtAmt());
			log.debug("!!di_fnl_frt_amt"+vo.getDiFnlFrtRtAmt());
			
			
			vo.setFnlFrtRtAmt(Double.toString(getDouble(vo.getOiFnlFrtRtAmt()) + getDouble(vo.getOaFnlFrtRtAmt()) + getDouble(vo.getDaFnlFrtRtAmt()) + getDouble(vo.getDiFnlFrtRtAmt())+ rt_fnl_frt_rt_amt));
			
			vo.setRtCalcFrtRtAmt(Double.toString(Math.round(rt_fnl_frt_rt_amt + 0.005d)));
			vo.setOiCalcFrtRtAmt(Double.toString(Math.round(getDouble(vo.getOiFnlFrtRtAmt()) + 0.005d)));
			vo.setOaCalcFrtRtAmt(Double.toString(Math.round(getDouble(vo.getOaFnlFrtRtAmt()) + 0.005d)));
			vo.setDaCalcFrtRtAmt(Double.toString(Math.round(getDouble(vo.getDaFnlFrtRtAmt()) + 0.005d)));
			vo.setDiCalcFrtRtAmt(Double.toString(Math.round(getDouble(vo.getDiFnlFrtRtAmt()) + 0.005d)));
			vo.setFnlFrtRtAmt(Double.toString(Math.round(getDouble(vo.getFnlFrtRtAmt()) + 0.005d)));
			
			log.debug("!!fnl_frt_rt_amt"+vo.getFnlFrtRtAmt());
		}
		
		return list ;
		
	}

	/**
	 * manageAmount
	 * 
	 * @param List<SearchTaaOftAutoratingListVO> list
	 * @return SearchTaaOftAutoratingListVO
	 * @exception EventException
	 */
	private List<SearchTaaOftAutoratingListVO> manageTaaSimOftAmount(List<SearchTaaOftAutoratingListVO> list) throws EventException{
		
		for(SearchTaaOftAutoratingListVO vo : list){

			double rt_fnl_frt_rt_amt;
			String opCd;
			
			vo.setChgCd("OFT");
    		vo.setPrcGenSpclRtTpCd("S");
    		vo.setPrcCmdtHdrSeq("0");
    		vo.setPrcRoutSeq("0");
    		vo.setPrcRtSeq("0");
    		
			rt_fnl_frt_rt_amt = getDouble(vo.getRtFnlFrtRtAmt());
			
			if("C".equals(vo.getRtTypBkgConvTpCd())){
				opCd = vo.getRtTypRtOpCd();
				if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
					rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtTypFrtRtAmt()), opCd);
				}
			}
			log.debug("fnl_frt_rt_amt"+rt_fnl_frt_rt_amt);
			if("C".equals(vo.getRtRacBkgConvTpCd())){
				opCd = vo.getRtRacRtOpCd();
				if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
					rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtRacFrtRtAmt()), opCd);
				}
			}
			if("C".equals(vo.getRtAppBkgConvTpCd())){
				opCd = vo.getRtAppRtOpCd();
				if("+".equals(opCd) || "-".equals(opCd) || "*".equals(opCd) || "/".equals(opCd)){
					rt_fnl_frt_rt_amt = calcArithmetic(rt_fnl_frt_rt_amt, getDouble(vo.getRtAppFrtRtAmt()), opCd);
				}
			}
			
			vo.setFnlFrtRtAmt(Double.toString(getDouble(vo.getOiFnlFrtRtAmt()) + getDouble(vo.getOaFnlFrtRtAmt()) + getDouble(vo.getDaFnlFrtRtAmt()) + getDouble(vo.getDiFnlFrtRtAmt())+ rt_fnl_frt_rt_amt));
			
			vo.setRtCalcFrtRtAmt(Double.toString(Math.round(rt_fnl_frt_rt_amt + 0.005d)));
			vo.setOiCalcFrtRtAmt(Double.toString(Math.round(getDouble(vo.getOiFnlFrtRtAmt()) + 0.005d)));
			vo.setOaCalcFrtRtAmt(Double.toString(Math.round(getDouble(vo.getOaFnlFrtRtAmt()) + 0.005d)));
			vo.setDaCalcFrtRtAmt(Double.toString(Math.round(getDouble(vo.getDaFnlFrtRtAmt()) + 0.005d)));
			vo.setDiCalcFrtRtAmt(Double.toString(Math.round(getDouble(vo.getDiFnlFrtRtAmt()) + 0.005d)));
			vo.setFnlFrtRtAmt(Double.toString(Math.round(getDouble(vo.getFnlFrtRtAmt()) + 0.005d)));
		}
		
		return list ;
		
	}
	
	/**
	 * ESM_PRI_6001 : Apply Rate <br>
	 * Applying rate with selected route and contract
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @param SignOnUserAccount account
	 * @return List<AplyRtOutVO>
	 * @exception EventException
	 */
	public List<AplyRtOutVO> createApplyRate(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException {
		try {
			
			String ctrtTp = aplyRtInVO.getCtrtTp();//S R T
			
			String pctlNo = aplyRtInVO.getPctlNo();
			String aplyDt = aplyRtInVO.getLdDt().replaceAll("-", "");
			aplyRtInVO.setLdDt(aplyDt);
			
			//delete existed pri_sim_rt and pri_sim_chg_rt
			dbDao.deletePriSimRt(pctlNo);
			dbDao.deletePriSimChgRt(pctlNo);
			
			//1. save parameter before auto-rating
			//dbDao.modifySimRoutMst(aplyRtInVO);

			//2. call OFT autorating and Surcharge
			if("S".equals(ctrtTp)){
				createApplyRateSC(aplyRtInVO, account);
			}else if("R".equals(ctrtTp)){
				createApplyRateRFA(aplyRtInVO, account);
			}else if("T".equals(ctrtTp)){
				createApplyRateTAA(aplyRtInVO, account);
			}else{
				throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage());
			}
			//3. retrieving summarized rate
			// Unmatch
			if ("Y".equals(aplyRtInVO.getUnmatchChk())){
				return searchUnmatchRateByPctlNo(aplyRtInVO);
			}else{
				return dbDao.searchRateByPctlNo(aplyRtInVO);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	private void createApplyRateSC(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException {
		try {
			String pctlNo = aplyRtInVO.getPctlNo();

			List<PriSimRtVO> priSimRtVOs = new ArrayList<PriSimRtVO>();
			List<PriSimChgRtVO> priSimChgRtVOs = new ArrayList<PriSimChgRtVO>();
			
			//2. call OFT rating
			List<SearchScOftAutoratingListVO> oftList = dbDao.searchScSimOftAutoratingList(aplyRtInVO);
			
			oftList = manageScSimOftAmount(oftList);//manageAmount
			
//			//3. save temporarily for calling surcharge auto-rating
//			dbDao.addAutoRtOcnFrtTempBySc(oftList, pctlNo, account.getUsr_id());

			Comparator<SearchScOftAutoratingListVO> comparator = new Comparator<SearchScOftAutoratingListVO>() {
				public int compare(SearchScOftAutoratingListVO vo1, SearchScOftAutoratingListVO vo2) {
					return (vo1.getCntrTpszCd() + vo1.getCmPrcCmdtDefCd() + vo1.getAutoRatFlg()).compareTo(
							vo2.getCntrTpszCd() + vo2.getCmPrcCmdtDefCd() + vo2.getAutoRatFlg());
				}
			};
			
			Collections.sort(oftList, comparator);
			
			Map<String, String> keyMap = new HashMap<String, String>();
			String key="";
			int keySeq=0;
			for(SearchScOftAutoratingListVO oftVO : oftList){
				key=oftVO.getCntrTpszCd()+"|"+oftVO.getCmPrcCmdtDefCd()+"|"+oftVO.getAutoRatFlg();
				if(keyMap.containsKey(key)){
					keySeq=keySeq+1;
				}else{
					keyMap.put(key, key);
					keySeq=0;
				}
				oftVO.setCmdtSeq(Integer.toString(keySeq));
			}
			
			PriSimRtVO tempVO;
			for(SearchScOftAutoratingListVO oftVO : oftList){
				tempVO = new PriSimRtVO();
				tempVO.setPctlNo(pctlNo);
				tempVO.setCntrSzCd(oftVO.getCntrTpszCd());
				tempVO.setCmdtCd(oftVO.getCmPrcCmdtDefCd());
				tempVO.setCmdtSeq(oftVO.getCmdtSeq());
				tempVO.setPrcCtrtTpCd(aplyRtInVO.getCtrtTp());
				tempVO.setCtrtNo(aplyRtInVO.getCtrtNo());
				tempVO.setRtAplyDt(aplyRtInVO.getLdDt());
				tempVO.setRcvTermCd(oftVO.getRcvTermCd());
				tempVO.setDeTermCd(oftVO.getDeTermCd());
				tempVO.setPrcCgoTpCd(oftVO.getPrcCgoTpCd());
				tempVO.setCntrTpCd(oftVO.getCntrTpszCd());
				tempVO.setPrcHngrBarTpCd(oftVO.getPrcHngrBarTpCd());
				tempVO.setCreUsrId(account.getUsr_id());
				tempVO.setAutoRatFlg(oftVO.getAutoRatFlg());
				priSimRtVOs.add(tempVO);
			}
			
			//4. save pri_sim_rt 
			dbDao.addPriSimRt(priSimRtVOs);
			
			//5. call surcharge rating
			List<SearchScOftAutoratingListVO> schgTtlList = new ArrayList<SearchScOftAutoratingListVO>();
			ScOftAutoratingListVO schgInVO;
			for(SearchScOftAutoratingListVO oftVO : oftList){
				
				//패턴에 따라 여러줄로 만들어서 oft temp 에 여러줄을 insert해야함
				manageTmpOFTbyPatt(oftVO, pctlNo, account.getUsr_id());
				
				//5-1. save temporarily for calling surcharge auto-rating
//				dbDao.addAutoRtOcnFrtTempBySc(oftVO, pctlNo, account.getUsr_id());
				
				schgInVO = new ScOftAutoratingListVO();
				schgInVO.setCtrtNo(aplyRtInVO.getCtrtNo());
				schgInVO.setRtAplyDt(aplyRtInVO.getLdDt());
				schgInVO.setsvcScpCd(oftVO.getSvcScpCd());
				schgInVO.setCmdtCd(oftVO.getCmPrcCmdtDefCd());
				schgInVO.setCtrtTpCd(aplyRtInVO.getCtrtTp());
				schgInVO.setPctlNo(pctlNo); 
				schgInVO.setCntrTpsz(oftVO.getCntrTpszCd());
				schgInVO.setAutoRatFlg(oftVO.getAutoRatFlg());
				
				//5-2. call surcharge
				DBRowSet dbRowset = dbDao.searchSimSurchargeAutoratingList(schgInVO);
				@SuppressWarnings({ "unchecked", "rawtypes" })
				List<SearchScOftAutoratingListVO> schgList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
				for(int i=schgList.size()-1; i>=0; i--){
					SearchScOftAutoratingListVO tmp = schgList.get(i);
					tmp.setCntrTpszCd(oftVO.getCntrTpszCd());
					tmp.setCmPrcCmdtDefCd(oftVO.getCmPrcCmdtDefCd());
					tmp.setCgoCateCd(oftVO.getPrcCgoTpCd());
					tmp.setCmdtSeq(oftVO.getCmdtSeq());
					tmp.setAutoRatFlg(oftVO.getAutoRatFlg());
				}
				schgTtlList.addAll(schgList);
				
				//5-3. delete temp data
				dbDao.deleteAutoRtOcnFrtTemp();
			}
			
			//6. save pri_sim_chg_rt
			PriSimChgRtVO chgRtVO;
			
			for(SearchScOftAutoratingListVO targetVO : oftList){
				
				//패턴에 따라 여러줄로 만들어서 insert해야 함
				manageChgOFTbyPatt(targetVO, pctlNo, account.getUsr_id(), priSimChgRtVOs);
				
			}
			for(SearchScOftAutoratingListVO targetVO : schgTtlList){
				chgRtVO = new PriSimChgRtVO();
				chgRtVO.setPctlNo(pctlNo);
				chgRtVO.setCntrSzCd(targetVO.getCntrTpszCd());
				chgRtVO.setCmdtCd(targetVO.getCmPrcCmdtDefCd());
				chgRtVO.setCmdtSeq(targetVO.getCmdtSeq());
				chgRtVO.setFrtTermCd(targetVO.getFrtTermCd());
				chgRtVO.setCgoCateCd(targetVO.getCgoCateCd());
				chgRtVO.setImdgClssCd(targetVO.getImdgClssCd());
				chgRtVO.setChgCd(targetVO.getChgCd());
				chgRtVO.setCurrCd(targetVO.getCurrCd());
				chgRtVO.setRatUtCd(targetVO.getRatUtCd());
				chgRtVO.setChgUtAmt(targetVO.getChgUtAmt());
				chgRtVO.setChgAmt(targetVO.getChgAmt());
				chgRtVO.setRcvTermCd(targetVO.getRcvTermCd());
				chgRtVO.setDeTermCd(targetVO.getDeTermCd());
				chgRtVO.setFrtInclXcldDivCd(targetVO.getFrtInclXcldDivCd());
				chgRtVO.setNoteRtSeq(targetVO.getPrcRtSeq());
				chgRtVO.setPropNo(targetVO.getPropNo());
				chgRtVO.setAmdtSeq(targetVO.getAmdtSeq());
				chgRtVO.setSvcScpCd(targetVO.getSvcScpCd());
				chgRtVO.setGenSpclRtTpCd(targetVO.getPrcGenSpclRtTpCd());
				chgRtVO.setCmdtHdrSeq(targetVO.getPrcCmdtHdrSeq());
				chgRtVO.setRoutSeq(targetVO.getPrcRoutSeq());
				chgRtVO.setCreUsrId(account.getUsr_id());
				chgRtVO.setAutoRatFlg(targetVO.getAutoRatFlg());
//				chgRtVO.setSocFlg(targetVO.getSocFlg());//schg 결과에 soc_flg 안가져오고 있음
				chgRtVO.setRatAsQty(targetVO.getRatAsQty());//schg에는 rat_as_qty
				
				priSimChgRtVOs.add(chgRtVO);
			}
			
			dbDao.addPriSimChgRt(priSimChgRtVOs);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	private void createApplyRateRFA(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException {
		try {
			String pctlNo = aplyRtInVO.getPctlNo();
			
			List<PriSimRtVO> priSimRtVOs = new ArrayList<PriSimRtVO>();
			List<PriSimChgRtVO> priSimChgRtVOs = new ArrayList<PriSimChgRtVO>();
			
			//2. call OFT rating
			List<SearchRfaOftAutoratingListVO> oftList = dbDao.searchRfaSimOftAutoratingList(aplyRtInVO);
			
			oftList = manageRfaSimOftAmount(oftList);//manageAmount
			
//			//3. save temporarily for calling surcharge auto-rating
//			dbDao.addAutoRtOcnFrtTempByRfa(oftList, pctlNo, account.getUsr_id());

			Comparator<SearchRfaOftAutoratingListVO> comparator = new Comparator<SearchRfaOftAutoratingListVO>() {
				public int compare(SearchRfaOftAutoratingListVO vo1, SearchRfaOftAutoratingListVO vo2) {
					return (vo1.getCntrTpszCd() + vo1.getCmPrcCmdtDefCd() + vo1.getAutoRatFlg()).compareTo(
							vo2.getCntrTpszCd() + vo2.getCmPrcCmdtDefCd() + vo2.getAutoRatFlg());
				}
			};
			
			Collections.sort(oftList, comparator);
			
			Map<String, String> keyMap = new HashMap<String, String>();
			String key="";
			int keySeq=0;
			for(SearchRfaOftAutoratingListVO oftVO : oftList){
				key=oftVO.getCntrTpszCd()+"|"+oftVO.getCmPrcCmdtDefCd()+"|"+oftVO.getAutoRatFlg();
				if(keyMap.containsKey(key)){
					keySeq=keySeq+1;
				}else{
					keyMap.put(key, key);
					keySeq=0;
				}
				oftVO.setCmdtSeq(Integer.toString(keySeq));
			}
			
			PriSimRtVO tempVO;
			for(SearchRfaOftAutoratingListVO oftVO : oftList){
				tempVO = new PriSimRtVO();
				tempVO.setPctlNo(pctlNo);
				tempVO.setCntrSzCd(oftVO.getCntrTpszCd());
				tempVO.setCmdtCd(oftVO.getCmPrcCmdtDefCd());
				tempVO.setCmdtSeq(oftVO.getCmdtSeq());
				tempVO.setPrcCtrtTpCd(aplyRtInVO.getCtrtTp());
				tempVO.setCtrtNo(aplyRtInVO.getCtrtNo());
				tempVO.setRtAplyDt(aplyRtInVO.getLdDt());
				tempVO.setRcvTermCd(oftVO.getRcvTermCd());
				tempVO.setDeTermCd(oftVO.getDeTermCd());
				tempVO.setPrcCgoTpCd(oftVO.getPrcCgoTpCd());
				tempVO.setCntrTpCd(oftVO.getCntrTpszCd());
				tempVO.setPrcHngrBarTpCd(oftVO.getPrcHngrBarTpCd());
				tempVO.setCreUsrId(account.getUsr_id());
				tempVO.setAutoRatFlg(oftVO.getAutoRatFlg());
				priSimRtVOs.add(tempVO);
			}
			
			//4. save pri_sim_rt 
			dbDao.addPriSimRt(priSimRtVOs);
			
			//5. call surcharge rating
			List<SearchRfaOftAutoratingListVO> schgTtlList = new ArrayList<SearchRfaOftAutoratingListVO>();
			ScOftAutoratingListVO schgInVO;
			for(SearchRfaOftAutoratingListVO oftVO : oftList){

				//패턴에 따라 여러줄로 만들어서 oft temp 에 여러줄을 insert해야함
				manageTmpOFTbyPatt(oftVO, pctlNo, account.getUsr_id());
				
//				//5-1. save temporarily for calling surcharge auto-rating
//				dbDao.addAutoRtOcnFrtTempByRfa(oftVO, pctlNo, account.getUsr_id());
				
				schgInVO = new ScOftAutoratingListVO();
				schgInVO.setCtrtNo(aplyRtInVO.getCtrtNo());
				schgInVO.setRtAplyDt(aplyRtInVO.getLdDt());
				schgInVO.setsvcScpCd(oftVO.getSvcScpCd());
				schgInVO.setCmdtCd(oftVO.getCmPrcCmdtDefCd());
				schgInVO.setCtrtTpCd(aplyRtInVO.getCtrtTp());
				schgInVO.setPctlNo(pctlNo); 
				schgInVO.setCntrTpsz(oftVO.getCntrTpszCd());
				schgInVO.setAutoRatFlg(oftVO.getAutoRatFlg());
				
				//5-2. call surcharge
				DBRowSet dbRowset = dbDao.searchSimSurchargeAutoratingList(schgInVO);
				@SuppressWarnings({ "unchecked", "rawtypes" })
				List<SearchRfaOftAutoratingListVO> schgList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRfaOftAutoratingListVO.class);
				
				for(int i=schgList.size()-1; i>=0; i--){
					SearchRfaOftAutoratingListVO tmp = schgList.get(i);
					tmp.setCntrTpszCd(oftVO.getCntrTpszCd());
					tmp.setCmPrcCmdtDefCd(oftVO.getCmPrcCmdtDefCd());
					tmp.setCgoCateCd(oftVO.getPrcCgoTpCd());
					tmp.setCmdtSeq(oftVO.getCmdtSeq());
					tmp.setAutoRatFlg(oftVO.getAutoRatFlg());
				}
				schgTtlList.addAll(schgList);
				
				//5-3. delete temp data
				dbDao.deleteAutoRtOcnFrtTemp();
			}
			
			//6. save pri_sim_chg_rt
			PriSimChgRtVO chgRtVO;
			
			for(SearchRfaOftAutoratingListVO targetVO : oftList){
				
				//패턴에 따라 여러줄로 만들어서 insert해야 함
				manageChgOFTbyPatt(targetVO, pctlNo, account.getUsr_id(), priSimChgRtVOs);
				
			}
			for(SearchRfaOftAutoratingListVO targetVO : schgTtlList){
				chgRtVO = new PriSimChgRtVO();
				chgRtVO.setPctlNo(pctlNo);
				chgRtVO.setCntrSzCd(targetVO.getCntrTpszCd());
				chgRtVO.setCmdtCd(targetVO.getCmPrcCmdtDefCd());
				chgRtVO.setCmdtSeq(targetVO.getCmdtSeq());
				chgRtVO.setFrtTermCd(targetVO.getFrtTermCd());
				chgRtVO.setCgoCateCd(targetVO.getCgoCateCd());
				chgRtVO.setImdgClssCd(targetVO.getImdgClssCd());
				chgRtVO.setChgCd(targetVO.getChgCd());
				chgRtVO.setCurrCd(targetVO.getCurrCd());
				chgRtVO.setRatUtCd(targetVO.getRatUtCd());
				chgRtVO.setChgUtAmt(targetVO.getChgUtAmt());
				chgRtVO.setChgAmt(targetVO.getChgAmt());
				chgRtVO.setRcvTermCd(targetVO.getRcvTermCd());
				chgRtVO.setDeTermCd(targetVO.getDeTermCd());
				chgRtVO.setFrtInclXcldDivCd(targetVO.getFrtInclXcldDivCd());
				chgRtVO.setNoteRtSeq(targetVO.getPrcRtSeq());
				chgRtVO.setPropNo(targetVO.getPropNo());
				chgRtVO.setAmdtSeq(targetVO.getAmdtSeq());
				chgRtVO.setSvcScpCd(targetVO.getSvcScpCd());
				chgRtVO.setGenSpclRtTpCd(targetVO.getPrcGenSpclRtTpCd());
				chgRtVO.setCmdtHdrSeq(targetVO.getPrcCmdtHdrSeq());
				chgRtVO.setRoutSeq(targetVO.getPrcRoutSeq());
				chgRtVO.setCreUsrId(account.getUsr_id());
				chgRtVO.setAutoRatFlg(targetVO.getAutoRatFlg());
				chgRtVO.setRatAsQty(targetVO.getRatAsQty());//schg에는 rat_as_qty
				priSimChgRtVOs.add(chgRtVO);
			}
			
			dbDao.addPriSimChgRt(priSimChgRtVOs);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	private void createApplyRateTAA(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException {
		try {
			String pctlNo = aplyRtInVO.getPctlNo();
			
			List<PriSimRtVO> priSimRtVOs = new ArrayList<PriSimRtVO>();
			List<PriSimChgRtVO> priSimChgRtVOs = new ArrayList<PriSimChgRtVO>();
			
			//2. call OFT rating
			List<SearchTaaOftAutoratingListVO> oftList = dbDao.searchTaaSimOftAutoratingList(aplyRtInVO);
			
			oftList = manageTaaSimOftAmount(oftList);//manageAmount
			
//			//3. save temporarily for calling surcharge auto-rating
//			dbDao.addAutoRtOcnFrtTempByTaa(oftList, pctlNo, account.getUsr_id());

			Comparator<SearchTaaOftAutoratingListVO> comparator = new Comparator<SearchTaaOftAutoratingListVO>() {
				public int compare(SearchTaaOftAutoratingListVO vo1, SearchTaaOftAutoratingListVO vo2) {
					return (vo1.getCntrTpszCd() + vo1.getCmPrcCmdtDefCd() + vo1.getAutoRatFlg()).compareTo(
							vo2.getCntrTpszCd() + vo2.getCmPrcCmdtDefCd() + vo2.getAutoRatFlg());
				}
			};
			
			Collections.sort(oftList, comparator);
			
			Map<String, String> keyMap = new HashMap<String, String>();
			String key="";
			int keySeq=0;
			for(SearchTaaOftAutoratingListVO oftVO : oftList){
				key=oftVO.getCntrTpszCd()+"|"+oftVO.getCmPrcCmdtDefCd()+"|"+oftVO.getAutoRatFlg();
				if(keyMap.containsKey(key)){
					keySeq=keySeq+1;
				}else{
					keyMap.put(key, key);
					keySeq=0;
				}
				oftVO.setCmdtSeq(Integer.toString(keySeq));
			}
			
			PriSimRtVO tempVO;
			for(SearchTaaOftAutoratingListVO oftVO : oftList){
				tempVO = new PriSimRtVO();
				tempVO.setPctlNo(pctlNo);
				tempVO.setCntrSzCd(oftVO.getCntrTpszCd());
				//tempVO.setCmdtCd(oftVO.getCmPrcCmdtDefCd());
				tempVO.setCmdtCd(oftVO.getTmCmdtCd());
				tempVO.setCmdtSeq(oftVO.getCmdtSeq());
				tempVO.setPrcCtrtTpCd(aplyRtInVO.getCtrtTp());
				tempVO.setCtrtNo(aplyRtInVO.getCtrtNo());
				tempVO.setRtAplyDt(aplyRtInVO.getLdDt());
				tempVO.setRcvTermCd(oftVO.getRcvTermCd());
				tempVO.setDeTermCd(oftVO.getDeTermCd());
				tempVO.setPrcCgoTpCd(oftVO.getPrcCgoTpCd());
				tempVO.setCntrTpCd(oftVO.getCntrTpszCd());
				tempVO.setPrcHngrBarTpCd(oftVO.getPrcHngrBarTpCd());
				tempVO.setCreUsrId(account.getUsr_id());
				tempVO.setAutoRatFlg(oftVO.getAutoRatFlg());
				priSimRtVOs.add(tempVO);
			}
			
			//4. save pri_sim_rt 
			dbDao.addPriSimRt(priSimRtVOs);
			
			//5. call surcharge rating
			List<SearchTaaOftAutoratingListVO> schgTtlList = new ArrayList<SearchTaaOftAutoratingListVO>();
			ScOftAutoratingListVO schgInVO;
			for(SearchTaaOftAutoratingListVO oftVO : oftList){

				//패턴에 따라 여러줄로 만들어서 oft temp 에 여러줄을 insert해야함
				manageTmpOFTbyPatt(oftVO, pctlNo, account.getUsr_id());
				
//				//5-1. save temporarily for calling surcharge auto-rating
//				dbDao.addAutoRtOcnFrtTempByTaa(oftVO, pctlNo, account.getUsr_id());
				
				schgInVO = new ScOftAutoratingListVO();
				schgInVO.setCtrtNo(aplyRtInVO.getCtrtNo());
				schgInVO.setRtAplyDt(aplyRtInVO.getLdDt());
				schgInVO.setsvcScpCd(oftVO.getSvcScpCd());
				schgInVO.setCmdtCd(oftVO.getCmPrcCmdtDefCd());
				schgInVO.setCtrtTpCd(aplyRtInVO.getCtrtTp());
				schgInVO.setPctlNo(pctlNo); 
				schgInVO.setCntrTpsz(oftVO.getCntrTpszCd());
				schgInVO.setAutoRatFlg(oftVO.getAutoRatFlg());

				//5-2. call surcharge
				DBRowSet dbRowset = dbDao.searchSimSurchargeAutoratingList(schgInVO);
				@SuppressWarnings({ "unchecked", "rawtypes" })
				List<SearchTaaOftAutoratingListVO> schgList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchTaaOftAutoratingListVO.class);
				
				for(int i=schgList.size()-1; i>=0; i--){
					SearchTaaOftAutoratingListVO tmp = schgList.get(i);
					tmp.setCntrTpszCd(oftVO.getCntrTpszCd());
					//tmp.setCmPrcCmdtDefCd(oftVO.getCmPrcCmdtDefCd());
					tmp.setTmCmdtCd(oftVO.getTmCmdtCd());
					tmp.setCgoCateCd(oftVO.getPrcCgoTpCd());
					tmp.setCmdtSeq(oftVO.getCmdtSeq());
					tmp.setAutoRatFlg(oftVO.getAutoRatFlg());
				}
				schgTtlList.addAll(schgList);
				
				//5-3. delete temp data
				dbDao.deleteAutoRtOcnFrtTemp();
			}
			
			//6. save pri_sim_chg_rt
			PriSimChgRtVO chgRtVO;
			
			for(SearchTaaOftAutoratingListVO targetVO : oftList){
				
				//패턴에 따라 여러줄로 만들어서 insert해야 함
				manageChgOFTbyPatt(targetVO, pctlNo, account.getUsr_id(), priSimChgRtVOs);
				
			}
			for(SearchTaaOftAutoratingListVO targetVO : schgTtlList){
				chgRtVO = new PriSimChgRtVO();
				chgRtVO.setPctlNo(pctlNo);
				chgRtVO.setCntrSzCd(targetVO.getCntrTpszCd());//
//				chgRtVO.setCmdtCd(targetVO.getCmPrcCmdtDefCd());//
				chgRtVO.setCmdtCd(targetVO.getTmCmdtCd());
				chgRtVO.setCmdtSeq(targetVO.getCmdtSeq());
				chgRtVO.setFrtTermCd(targetVO.getFrtTermCd());
				chgRtVO.setCgoCateCd(targetVO.getCgoCateCd());//
				chgRtVO.setImdgClssCd(targetVO.getImdgClssCd());
				chgRtVO.setChgCd(targetVO.getChgCd());
				chgRtVO.setCurrCd(targetVO.getCurrCd());
				chgRtVO.setRatUtCd(targetVO.getRatUtCd());
				chgRtVO.setChgUtAmt(targetVO.getChgUtAmt());
				chgRtVO.setChgAmt(targetVO.getChgAmt());//
				chgRtVO.setRcvTermCd(targetVO.getRcvTermCd());
				chgRtVO.setDeTermCd(targetVO.getDeTermCd());
				chgRtVO.setFrtInclXcldDivCd(targetVO.getFrtInclXcldDivCd());
				chgRtVO.setNoteRtSeq(targetVO.getPrcRtSeq());
				chgRtVO.setPropNo(targetVO.getPropNo());
				chgRtVO.setAmdtSeq(targetVO.getAmdtSeq());
				chgRtVO.setSvcScpCd(targetVO.getSvcScpCd());
				chgRtVO.setGenSpclRtTpCd(targetVO.getPrcGenSpclRtTpCd());
				chgRtVO.setCmdtHdrSeq(targetVO.getPrcCmdtHdrSeq());//?
				chgRtVO.setRoutSeq(targetVO.getPrcRoutSeq());
				chgRtVO.setCreUsrId(account.getUsr_id());
				chgRtVO.setAutoRatFlg(targetVO.getAutoRatFlg());
				chgRtVO.setRatAsQty(targetVO.getRatAsQty());//schg에는 rat_as_qty
				priSimChgRtVOs.add(chgRtVO);
			}
			
			dbDao.addPriSimChgRt(priSimChgRtVOs);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_6002 : Tariff Surcharge <br>
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @param SignOnUserAccount account
	 * @return List<TrfChgVO>
	 * @exception EventException
	 */
	public List<TrfChgVO> createTariffSurcharge(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException {
		try {
			String pctlNo = aplyRtInVO.getFPctlNo();
			String aplyDt = aplyRtInVO.getLdDt().replaceAll("-", "");
			aplyRtInVO.setLdDt(aplyDt);
			
			//delete existed pri_sim_rt and pri_sim_chg_rt
			dbDao.deletePriSimRt(pctlNo);
			dbDao.deletePriSimChgRt(pctlNo);
			
			// 
			List<PriSimRtVO> priSimRtVOs = new ArrayList<PriSimRtVO>();
			List<PriSimRtVO> srchPriSimRtVOs= dbDao.searchPriSimRtList(aplyRtInVO);
			PriSimRtVO tempVO; 

			for(PriSimRtVO priSimRtVO : srchPriSimRtVOs) {
				tempVO = new PriSimRtVO();
				tempVO.setPctlNo(priSimRtVO.getPctlNo());
				tempVO.setCntrSzCd(priSimRtVO.getCntrSzCd());
				tempVO.setCmdtCd("X");
				tempVO.setCmdtSeq("0");
				tempVO.setPrcCtrtTpCd(aplyRtInVO.getCtrtTp());
				tempVO.setCtrtNo(aplyRtInVO.getCtrtNo());
				tempVO.setRtAplyDt(aplyRtInVO.getLdDt());
				tempVO.setRcvTermCd(aplyRtInVO.getRcvT());
				tempVO.setDeTermCd(aplyRtInVO.getDelT());
				tempVO.setPrcCgoTpCd(aplyRtInVO.getCgoTpCd());
				tempVO.setCntrTpCd(priSimRtVO.getCntrSzCd());
				tempVO.setPrcHngrBarTpCd("");
				tempVO.setCreUsrId(account.getUsr_id());
				tempVO.setAutoRatFlg("Y");
				priSimRtVOs.add(tempVO);
			}
			// save pri_sim_rt 
			dbDao.addPriSimRt(priSimRtVOs);
			
			List<SearchScOftAutoratingListVO> schgTtlList = new ArrayList<SearchScOftAutoratingListVO>();
			ScOftAutoratingListVO schgInVO;
			for(PriSimRtVO priSimRtVO : srchPriSimRtVOs) {
				schgInVO = new ScOftAutoratingListVO();
				schgInVO.setCtrtNo(aplyRtInVO.getCtrtNo());
				schgInVO.setRtAplyDt(aplyRtInVO.getLdDt());
				schgInVO.setsvcScpCd(priSimRtVO.getSvcScpCd());
				schgInVO.setCmdtCd("X");
				schgInVO.setCtrtTpCd("");
				schgInVO.setPctlNo(priSimRtVO.getPctlNo()); 
				schgInVO.setCntrTpsz(priSimRtVO.getCntrSzCd());
				schgInVO.setAutoRatFlg("Y");
				
				DBRowSet dbRowset = dbDao.searchSimSurchargeAutoratingList(schgInVO);
				List<SearchScOftAutoratingListVO> schgList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchScOftAutoratingListVO.class);
				
				for(int i=schgList.size()-1; i>=0; i--){
					SearchScOftAutoratingListVO tmp = schgList.get(i);
					tmp.setCntrTpszCd(priSimRtVO.getCntrSzCd());
					tmp.setCmPrcCmdtDefCd("");
					tmp.setCgoCateCd(aplyRtInVO.getCgoTpCd());
					tmp.setCmdtSeq("0");
					tmp.setAutoRatFlg("Y");
					tmp.setPctlNo(priSimRtVO.getPctlNo());
					tmp.setSvcScpCd(priSimRtVO.getSvcScpCd());
				}
				schgTtlList.addAll(schgList);
			}
			// save pri_sim_chg_rt
			List<PriSimChgRtVO> priSimChgRtVOs = new ArrayList<PriSimChgRtVO>();
			PriSimChgRtVO chgRtVO;
			for (SearchScOftAutoratingListVO targetVO : schgTtlList) {
				chgRtVO = new PriSimChgRtVO();
				chgRtVO.setPctlNo(targetVO.getPctlNo());
				chgRtVO.setCntrSzCd(targetVO.getCntrTpszCd());
				chgRtVO.setCmdtCd("X");
				chgRtVO.setCmdtSeq(targetVO.getCmdtSeq());
				chgRtVO.setFrtTermCd(targetVO.getFrtTermCd());
				chgRtVO.setCgoCateCd(targetVO.getCgoCateCd());
				chgRtVO.setImdgClssCd(targetVO.getImdgClssCd());
				chgRtVO.setChgCd(targetVO.getChgCd());
				chgRtVO.setCurrCd(targetVO.getCurrCd());
				chgRtVO.setRatUtCd(targetVO.getRatUtCd());
				chgRtVO.setChgUtAmt(targetVO.getChgUtAmt());
				chgRtVO.setChgAmt(targetVO.getChgAmt());
				chgRtVO.setRcvTermCd(targetVO.getRcvTermCd());
				chgRtVO.setDeTermCd(targetVO.getDeTermCd());
				chgRtVO.setFrtInclXcldDivCd(targetVO.getFrtInclXcldDivCd());
				chgRtVO.setNoteRtSeq(targetVO.getPrcRtSeq());
				chgRtVO.setPropNo(targetVO.getPropNo());
				chgRtVO.setAmdtSeq(targetVO.getAmdtSeq());
				chgRtVO.setSvcScpCd(targetVO.getSvcScpCd());
				chgRtVO.setGenSpclRtTpCd(targetVO.getPrcGenSpclRtTpCd());
				chgRtVO.setCmdtHdrSeq(targetVO.getPrcCmdtHdrSeq());
				chgRtVO.setRoutSeq(targetVO.getPrcRoutSeq());
				chgRtVO.setCreUsrId(account.getUsr_id());
				chgRtVO.setAutoRatFlg(targetVO.getAutoRatFlg());
				chgRtVO.setRatAsQty(targetVO.getRatAsQty());
				priSimChgRtVOs.add(chgRtVO);
			}
			
			dbDao.addPriSimChgRt(priSimChgRtVOs);
			
			//retrieving Tariff Surcharge
			return dbDao.searchTariffSurcharge(aplyRtInVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_6002 : Subject To Tariff Surcharge
	 * 
	 * @param aplyRtInVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String createTrfChgBackEndJobStart(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException {
		PRISimulationTrfChgBackEndJob backEndJob = new PRISimulationTrfChgBackEndJob();
		backEndJob.setAplyRtInVO(aplyRtInVO);
		backEndJob.setAccount(account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_PRI_6002_Trf_Chg");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_6002 : searchChgCd <br>
	 * 
	 * @param String pctlNo
	 * @return List<TrfChgVO>
	 * @exception EventException
	 */
	public List<TrfChgVO> searchChgCd(String pctlNo) throws EventException {
		try {
			//retrieving Tariff Surcharge
			return dbDao.searchChgCd(pctlNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * ESM_PRI_6002 : searchSlsOfcCd <br>
	 * 
	 * @param String por
	 * @return List<AplyRtInVO>
	 * @exception EventException
	 */
	public List<AplyRtInVO> searchSlsOfcCd(String por) throws EventException {
		try {
			//retrieving POR's sales office
			return dbDao.searchSlsOfcCd(por);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * ESM_PRI_6001 : searchChgCd <br>
	 * 
	 * @param String pctlNo
	 * @return String
	 * @exception EventException
	 */
	public String searchSvcScp(String pctlNo) throws EventException {
		try {
			//retrieving possible svc scp by pctl no
			return dbDao.searchSvcScp(pctlNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_6001 : searchTrnsMod <br>
	 * 
	 * @param String pctlNo
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchTrnsMod(String pctlNo) throws EventException {
		try {
			//retrieving trans mode by pctl_no
			return dbDao.searchTrnsMod(pctlNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_6001 : unmatch result retrieve <br>
	 * 
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<AplyRtOutVO>
	 * @exception EventException
	 */
	private List<AplyRtOutVO> searchUnmatchRateByPctlNo(AplyRtInVO aplyRtInVO) throws EventException {
		try {
			//1. MATCH+UNMATCH 조회
			List<AplyRtOutVO> orgList = dbDao.searchUnmatchRateByPctlNo(aplyRtInVO);
			List<AplyRtOutVO> matchList = new ArrayList<AplyRtOutVO>();
			List<AplyRtOutVO> unmatchList = new ArrayList<AplyRtOutVO>();
			List<AplyRtOutVO> allList = new ArrayList<AplyRtOutVO>();

			for(AplyRtOutVO vo : orgList){
				if("Y".equals(vo.getAutoRatFlg())){
					matchList.add(vo);
				}else{
					unmatchList.add(vo);
				}
			}
			
			//2. 어떤 항목이 UNMATCH 인지 찾기
			for(AplyRtOutVO unmatchVO : unmatchList){
				AplyRtOutVO cmprVO = findCmprTarget(unmatchVO, matchList); 
				unmatchVO = findUnmatchReason(unmatchVO, cmprVO);
			}
			
			allList.addAll(matchList);
			allList.addAll(unmatchList);
			
			return allList;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	private AplyRtOutVO findCmprTarget(AplyRtOutVO unmatchVO, List<AplyRtOutVO> matchList){
		
		for(AplyRtOutVO matchVO : matchList){
			if(unmatchVO.getCntrSzCd().equals(matchVO.getCntrSzCd()) && unmatchVO.getCmdtCd().equals(matchVO.getCmdtCd())){
				return matchVO;
			}
		}
		for(AplyRtOutVO matchVO : matchList){
			if(!unmatchVO.getCntrSzCd().equals(matchVO.getCntrSzCd()) && unmatchVO.getCmdtCd().equals(matchVO.getCmdtCd())){
				return matchVO;
			}
		}
		for(AplyRtOutVO matchVO : matchList){
			if(unmatchVO.getCntrSzCd().equals(matchVO.getCntrSzCd()) && !unmatchVO.getCmdtCd().equals(matchVO.getCmdtCd())){
				return matchVO;
			}
		}
		return null;
	}
	
	private AplyRtOutVO findUnmatchReason(AplyRtOutVO unmatchVO, AplyRtOutVO cmprVO){
		if(cmprVO==null){
			unmatchVO.setRcvTMtchFlg("N");
			unmatchVO.setDelTMtchFlg("N");
			unmatchVO.setOrgMtchFlg("N");
			unmatchVO.setOrgViaMtchFlg("N");
			unmatchVO.setDestViaMtchFlg("N");
			unmatchVO.setDestMtchFlg("N");
			unmatchVO.setCgoTpCdMtchFlg("N");
			unmatchVO.setCntrTpCdMtchFlg("N");
			unmatchVO.setSocMtchFlg("N");
			unmatchVO.setGohMtchFlg("N");
			unmatchVO.setRemark("NO TARGET TO COMPARE");
			
		}else{
			if(!cmprVO.getRcvTermCd().equals(unmatchVO.getRcvTermCd())){
				unmatchVO.setRcvTMtchFlg("N");
			}
			if(!cmprVO.getDeTermCd().equals(unmatchVO.getDeTermCd())){
				unmatchVO.setDelTMtchFlg("N");
			}
			if(!cmprVO.getOrgInlndHlgAmt().equals(unmatchVO.getOrgInlndHlgAmt())){
				unmatchVO.setOrgMtchFlg("N");
			}
			if(!cmprVO.getOrgArbAmt().equals(unmatchVO.getOrgArbAmt())){
				unmatchVO.setOrgViaMtchFlg("N");
			}
			if(!cmprVO.getDestArbAmt().equals(unmatchVO.getDestArbAmt())){
				unmatchVO.setDestViaMtchFlg("N");
			}
			if(!cmprVO.getDestInlndHlgAmt().equals(unmatchVO.getDestInlndHlgAmt())){
				unmatchVO.setDestMtchFlg("N");
			}
			if(!cmprVO.getCgoTpCd().equals(unmatchVO.getCgoTpCd())){
				unmatchVO.setCgoTpCdMtchFlg("N");
			}
			if(!cmprVO.getCntrTpCd().equals(unmatchVO.getCntrTpCd())){
				unmatchVO.setCntrTpCdMtchFlg("N");
			}
			if(!cmprVO.getSocFlg().equals(unmatchVO.getSocFlg())){
				unmatchVO.setSocMtchFlg("N");
			}
			if(!cmprVO.getGohAmt().equals(unmatchVO.getGohAmt())){
				unmatchVO.setGohMtchFlg("N");
			}
		}
		
		if(!"N".equals(unmatchVO.getRcvTMtchFlg()))		unmatchVO.setRcvTMtchFlg("Y");
		if(!"N".equals(unmatchVO.getDelTMtchFlg()))		unmatchVO.setDelTMtchFlg("Y");
		if(!"N".equals(unmatchVO.getOrgMtchFlg()))		unmatchVO.setOrgMtchFlg("Y");
		if(!"N".equals(unmatchVO.getOrgViaMtchFlg()))	unmatchVO.setOrgViaMtchFlg("Y");
		if(!"N".equals(unmatchVO.getDestViaMtchFlg()))	unmatchVO.setDestViaMtchFlg("Y");
		if(!"N".equals(unmatchVO.getDestMtchFlg()))		unmatchVO.setDestMtchFlg("Y");
		if(!"N".equals(unmatchVO.getCgoTpCdMtchFlg()))	unmatchVO.setCgoTpCdMtchFlg("Y");
		if(!"N".equals(unmatchVO.getCntrTpCdMtchFlg()))	unmatchVO.setCntrTpCdMtchFlg("Y");
		if(!"N".equals(unmatchVO.getSocMtchFlg()))		unmatchVO.setSocMtchFlg("Y");
		if(!"N".equals(unmatchVO.getGohMtchFlg()))		unmatchVO.setGohMtchFlg("Y");
		
		return unmatchVO;
	}
	
	/**
	 * Set parameter for verify rate
	 * @param AplyRtInVO vo
	 * @param String usrID
	 * @exception EventException
	 */
	public void managePriSimPara(AplyRtInVO vo, String usrId) throws EventException {
		try {
			if(vo!=null && !"".equals(vo.getPctlNo())){
				dbDao.deletePriSimPara(vo.getPctlNo());
				dbDao.addPriSimPara(vo, usrId);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Set parameter for verify rate
	 * @param SearchScOftAutoratingListVO oftVO
	 * @param String pctlNo
	 * @param String usrId
	 * @exception EventException
	 */
	private void manageTmpOFTbyPatt(SearchScOftAutoratingListVO oftVO, String pctlNo, String usrId) throws EventException {
		try {
			if(oftVO==null) return;
			
			String patt = oftVO.getRtMtchPattCd().substring(1,5);//SC 는 (1,5) / RFA 는 (0,4)
			SearchScOftAutoratingListVO newVO;

			for(int i=0; i<5; i++){
				newVO = new SearchScOftAutoratingListVO();
				if(i==0){
					newVO.setChgCd("OFT");
					newVO.setCurrCd(oftVO.getCurrCd());
					newVO.setChgUtAmt(oftVO.getRtCalcFrtRtAmt());
					newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getRtFnlFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
				}
				if(i==1){//OIH
					if("1".equals(patt.substring(0,1))){
						newVO.setChgCd("OIH");
						newVO.setCurrCd(oftVO.getOiCurrCd());
						newVO.setChgUtAmt(oftVO.getOiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==2){//OAR
					if("1".equals(patt.substring(1,2))){
						newVO.setChgCd("OAR");
						newVO.setCurrCd(oftVO.getOaCurrCd());
						newVO.setChgUtAmt(oftVO.getOaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==3){//DAR
					if("1".equals(patt.substring(2,3))){
						newVO.setChgCd("DAR");
						newVO.setCurrCd(oftVO.getDaCurrCd());
						newVO.setChgUtAmt(oftVO.getDaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==4){//DIH
					if("1".equals(patt.substring(3,4))){
						newVO.setChgCd("DIH");
						newVO.setCurrCd(oftVO.getDiCurrCd());
						newVO.setChgUtAmt(oftVO.getDiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				newVO.setRatAsQty(oftVO.getOpCntrQty());
				newVO.setRatUtCd(oftVO.getRatUtCd());
				newVO.setRcvTermCd(oftVO.getRcvTermCd());
				newVO.setDeTermCd(oftVO.getDeTermCd());
				newVO.setImdgClssCd(oftVO.getImdgClssCd());
				newVO.setCntrTpszCd(oftVO.getCntrTpszCd());
				newVO.setCtrtCntrTpszCd(oftVO.getCtrtCntrTpszCd());
				newVO.setDryCgoFlg(oftVO.getDryCgoFlg());
				newVO.setAwkCgoFlg(oftVO.getAwkCgoFlg());
				newVO.setDcgoFlg(oftVO.getDcgoFlg());
				newVO.setRcFlg(oftVO.getRcFlg());
				newVO.setBbCgoFlg(oftVO.getBbCgoFlg());
				newVO.setSocFlg(oftVO.getSocFlg());
				newVO.setPrcGenSpclRtTpCd(oftVO.getPrcGenSpclRtTpCd());
				newVO.setPrcCmdtHdrSeq(oftVO.getPrcCmdtHdrSeq());
				newVO.setPrcRoutSeq(oftVO.getPrcRoutSeq());
				newVO.setOpCntrQty(oftVO.getOpCntrQty());
				newVO.setPrcRtSeq(oftVO.getPrcRtSeq());
				newVO.setPorMtchFlg(oftVO.getPorMtchFlg());
				newVO.setDelMtchFlg(oftVO.getDelMtchFlg());
				newVO.setEqSubstCntrTpszCd(oftVO.getEqSubstCntrTpszCd());
				
				dbDao.addAutoRtOcnFrtTempBySc(newVO, pctlNo, usrId);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Set parameter for verify rate
	 * @param SearchScOftAutoratingListVO oftVO
	 * @param String pctlNo
	 * @param String usrId
	 * @param List<PriSimChgRtVO> priSimChgRtVOs
	 * @exception EventException
	 */
	private void manageChgOFTbyPatt(SearchScOftAutoratingListVO oftVO, String pctlNo, String usrId, List<PriSimChgRtVO> priSimChgRtVOs) throws EventException {
		try {
			if(oftVO==null) return;
			
			String patt = oftVO.getRtMtchPattCd().substring(1,5);
			PriSimChgRtVO newVO;

			for(int i=0; i<5; i++){
				newVO = new PriSimChgRtVO();
				if(i==0){
					newVO.setChgCd("OFT");
					newVO.setCurrCd(oftVO.getCurrCd());
					newVO.setChgUtAmt(oftVO.getRtCalcFrtRtAmt());
					newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getRtFnlFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
				}
				if(i==1){//OIH
					if("1".equals(patt.substring(0,1))){
						newVO.setChgCd("OIH");
						newVO.setCurrCd(oftVO.getOiCurrCd());
						newVO.setChgUtAmt(oftVO.getOiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==2){//OAR
					if("1".equals(patt.substring(1,2))){
						newVO.setChgCd("OAR");
						newVO.setCurrCd(oftVO.getOaCurrCd());
						newVO.setChgUtAmt(oftVO.getOaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==3){//DAR
					if("1".equals(patt.substring(2,3))){
						newVO.setChgCd("DAR");
						newVO.setCurrCd(oftVO.getDaCurrCd());
						newVO.setChgUtAmt(oftVO.getDaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==4){//DIH
					if("1".equals(patt.substring(3,4))){
						newVO.setChgCd("DIH");
						newVO.setCurrCd(oftVO.getDiCurrCd());
						newVO.setChgUtAmt(oftVO.getDiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				newVO.setPctlNo(pctlNo);
				newVO.setCntrSzCd(oftVO.getCntrTpszCd());
				newVO.setCmdtCd(oftVO.getCmPrcCmdtDefCd());
				newVO.setCmdtSeq(oftVO.getCmdtSeq());
				newVO.setFrtTermCd("P");
				newVO.setCgoCateCd(oftVO.getCgoCateCd());
				newVO.setImdgClssCd(oftVO.getImdgClssCd());
				newVO.setRatAsQty(oftVO.getOpCntrQty());
				newVO.setRatUtCd(oftVO.getRatUtCd());
				newVO.setRcvTermCd(oftVO.getRcvTermCd());
				newVO.setDeTermCd(oftVO.getDeTermCd());
				newVO.setFrtInclXcldDivCd("N");
				newVO.setNoteRtSeq(oftVO.getPrcRtSeq());
				newVO.setPropNo(oftVO.getPropNo());
				newVO.setAmdtSeq(oftVO.getAmdtSeq());
				newVO.setSvcScpCd(oftVO.getSvcScpCd());
				newVO.setGenSpclRtTpCd(oftVO.getPrcGenSpclRtTpCd());
				newVO.setCmdtHdrSeq(oftVO.getPrcCmdtHdrSeq());
				newVO.setRoutSeq(oftVO.getPrcRoutSeq());
				newVO.setCreUsrId(usrId);
				newVO.setAutoRatFlg(oftVO.getAutoRatFlg());
				newVO.setSocFlg(oftVO.getSocFlg());
				
				priSimChgRtVOs.add(newVO);
				
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Set parameter for verify rate
	 * @param SearchRfaOftAutoratingListVO oftVO
	 * @param String pctlNo
	 * @param String usrId
	 * @exception EventException
	 */
	private void manageTmpOFTbyPatt(SearchRfaOftAutoratingListVO oftVO, String pctlNo, String usrId) throws EventException {
		try {
			if(oftVO==null) return;
			
			String patt = oftVO.getRtMtchPattCd().substring(0,4);//SC 는 (1,5) / RFA 는 (0,4)
			SearchRfaOftAutoratingListVO newVO;

			for(int i=0; i<5; i++){
				newVO = new SearchRfaOftAutoratingListVO();
				if(i==0){
					newVO.setChgCd("OFT");
					newVO.setCurrCd(oftVO.getCurrCd());
					newVO.setChgUtAmt(oftVO.getRtCalcFrtRtAmt());
					newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getRtFnlFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
				}
				if(i==1){//OIH
					if("1".equals(patt.substring(0,1))){
						newVO.setChgCd("OIH");
						newVO.setCurrCd(oftVO.getOiCurrCd());
						newVO.setChgUtAmt(oftVO.getOiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==2){//OAR
					if("1".equals(patt.substring(1,2))){
						newVO.setChgCd("OAR");
						newVO.setCurrCd(oftVO.getOaCurrCd());
						newVO.setChgUtAmt(oftVO.getOaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==3){//DAR
					if("1".equals(patt.substring(2,3))){
						newVO.setChgCd("DAR");
						newVO.setCurrCd(oftVO.getDaCurrCd());
						newVO.setChgUtAmt(oftVO.getDaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==4){//DIH
					if("1".equals(patt.substring(3,4))){
						newVO.setChgCd("DIH");
						newVO.setCurrCd(oftVO.getDiCurrCd());
						newVO.setChgUtAmt(oftVO.getDiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				newVO.setRatAsQty(oftVO.getOpCntrQty());
				newVO.setRatUtCd(oftVO.getRatUtCd());
				newVO.setRcvTermCd(oftVO.getRcvTermCd());
				newVO.setDeTermCd(oftVO.getDeTermCd());
				newVO.setImdgClssCd(oftVO.getImdgClssCd());
				newVO.setCntrTpszCd(oftVO.getCntrTpszCd());
				newVO.setCtrtCntrTpszCd(oftVO.getCtrtCntrTpszCd());
				newVO.setDryCgoFlg(oftVO.getDryCgoFlg());
				newVO.setAwkCgoFlg(oftVO.getAwkCgoFlg());
				newVO.setDcgoFlg(oftVO.getDcgoFlg());
				newVO.setRcFlg(oftVO.getRcFlg());
				newVO.setBbCgoFlg(oftVO.getBbCgoFlg());
				newVO.setSocFlg(oftVO.getSocFlg());
				newVO.setPrcGenSpclRtTpCd(oftVO.getPrcGenSpclRtTpCd());
				newVO.setPrcCmdtHdrSeq(oftVO.getPrcCmdtHdrSeq());
				newVO.setPrcRoutSeq(oftVO.getPrcRoutSeq());
				newVO.setOpCntrQty(oftVO.getOpCntrQty());
				newVO.setPrcRtSeq(oftVO.getPrcRtSeq());
				newVO.setPorMtchFlg(oftVO.getPorMtchFlg());
				newVO.setDelMtchFlg(oftVO.getDelMtchFlg());
				newVO.setEqSubstCntrTpszCd(oftVO.getEqSubstCntrTpszCd());
				
				dbDao.addAutoRtOcnFrtTempByRfa(newVO, pctlNo, usrId);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Set parameter for verify rate
	 * @param SearchRfaOftAutoratingListVO oftVO
	 * @param String pctlNo
	 * @param String usrId
	 * @param List<PriSimChgRtVO> priSimChgRtVOs
	 * @exception EventException
	 */
	private void manageChgOFTbyPatt(SearchRfaOftAutoratingListVO oftVO, String pctlNo, String usrId, List<PriSimChgRtVO> priSimChgRtVOs) throws EventException {
		try {
			if(oftVO==null) return;
			
			String patt = oftVO.getRtMtchPattCd().substring(0,4);
			PriSimChgRtVO newVO;

			for(int i=0; i<5; i++){
				newVO = new PriSimChgRtVO();
				if(i==0){
					newVO.setChgCd("OFT");
					newVO.setCurrCd(oftVO.getCurrCd());
					newVO.setChgUtAmt(oftVO.getRtCalcFrtRtAmt());
					newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getRtFnlFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
				}
				if(i==1){//OIH
					if("1".equals(patt.substring(0,1))){
						newVO.setChgCd("OIH");
						newVO.setCurrCd(oftVO.getOiCurrCd());
						newVO.setChgUtAmt(oftVO.getOiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==2){//OAR
					if("1".equals(patt.substring(1,2))){
						newVO.setChgCd("OAR");
						newVO.setCurrCd(oftVO.getOaCurrCd());
						newVO.setChgUtAmt(oftVO.getOaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==3){//DAR
					if("1".equals(patt.substring(2,3))){
						newVO.setChgCd("DAR");
						newVO.setCurrCd(oftVO.getDaCurrCd());
						newVO.setChgUtAmt(oftVO.getDaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==4){//DIH
					if("1".equals(patt.substring(3,4))){
						newVO.setChgCd("DIH");
						newVO.setCurrCd(oftVO.getDiCurrCd());
						newVO.setChgUtAmt(oftVO.getDiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				newVO.setPctlNo(pctlNo);
				newVO.setCntrSzCd(oftVO.getCntrTpszCd());
				newVO.setCmdtCd(oftVO.getCmPrcCmdtDefCd());
				newVO.setCmdtSeq(oftVO.getCmdtSeq());
				newVO.setFrtTermCd("P");
				newVO.setCgoCateCd(oftVO.getCgoCateCd());
				newVO.setImdgClssCd(oftVO.getImdgClssCd());
				newVO.setRatAsQty(oftVO.getOpCntrQty());
				newVO.setRatUtCd(oftVO.getRatUtCd());
				newVO.setRcvTermCd(oftVO.getRcvTermCd());
				newVO.setDeTermCd(oftVO.getDeTermCd());
				newVO.setFrtInclXcldDivCd("N");
				newVO.setNoteRtSeq(oftVO.getPrcRtSeq());
				newVO.setPropNo(oftVO.getPropNo());
				newVO.setAmdtSeq(oftVO.getAmdtSeq());
				newVO.setSvcScpCd(oftVO.getSvcScpCd());
				newVO.setGenSpclRtTpCd(oftVO.getPrcGenSpclRtTpCd());
				newVO.setCmdtHdrSeq(oftVO.getPrcCmdtHdrSeq());
				newVO.setRoutSeq(oftVO.getPrcRoutSeq());
				newVO.setCreUsrId(usrId);
				newVO.setAutoRatFlg(oftVO.getAutoRatFlg());
				newVO.setSocFlg(oftVO.getSocFlg());
				
				priSimChgRtVOs.add(newVO);
				
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Set parameter for verify rate
	 * @param SearchTaaOftAutoratingListVO oftVO
	 * @param String pctlNo
	 * @param String usrId
	 * @exception EventException
	 */
	private void manageTmpOFTbyPatt(SearchTaaOftAutoratingListVO oftVO, String pctlNo, String usrId) throws EventException {
		try {
			if(oftVO==null) return;
			
			String patt = oftVO.getRtMtchPattCd().substring(0,4);//SC 는 (1,5) / RFA 는 (0,4)
			SearchTaaOftAutoratingListVO newVO;

			for(int i=0; i<5; i++){
				newVO = new SearchTaaOftAutoratingListVO();
				if(i==0){
					newVO.setChgCd("OFT");
					newVO.setCurrCd(oftVO.getCurrCd());
					newVO.setChgUtAmt(oftVO.getRtCalcFrtRtAmt());
					newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getRtFnlFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
				}
				if(i==1){//OIH
					if("1".equals(patt.substring(0,1))){
						newVO.setChgCd("OIH");
						newVO.setCurrCd(oftVO.getOiCurrCd());
						newVO.setChgUtAmt(oftVO.getOiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==2){//OAR
					if("1".equals(patt.substring(1,2))){
						newVO.setChgCd("OAR");
						newVO.setCurrCd(oftVO.getOaCurrCd());
						newVO.setChgUtAmt(oftVO.getOaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==3){//DAR
					if("1".equals(patt.substring(2,3))){
						newVO.setChgCd("DAR");
						newVO.setCurrCd(oftVO.getDaCurrCd());
						newVO.setChgUtAmt(oftVO.getDaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==4){//DIH
					if("1".equals(patt.substring(3,4))){
						newVO.setChgCd("DIH");
						newVO.setCurrCd(oftVO.getDiCurrCd());
						newVO.setChgUtAmt(oftVO.getDiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				newVO.setRatAsQty(oftVO.getOpCntrQty());
				newVO.setRatUtCd(oftVO.getRatUtCd());
				newVO.setRcvTermCd(oftVO.getRcvTermCd());
				newVO.setDeTermCd(oftVO.getDeTermCd());
				newVO.setImdgClssCd(oftVO.getImdgClssCd());
				newVO.setCntrTpszCd(oftVO.getCntrTpszCd());
				newVO.setCtrtCntrTpszCd(oftVO.getCtrtCntrTpszCd());
				newVO.setDryCgoFlg(oftVO.getDryCgoFlg());
				newVO.setAwkCgoFlg(oftVO.getAwkCgoFlg());
				newVO.setDcgoFlg(oftVO.getDcgoFlg());
				newVO.setRcFlg(oftVO.getRcFlg());
				newVO.setBbCgoFlg(oftVO.getBbCgoFlg());
				newVO.setSocFlg(oftVO.getSocFlg());
				newVO.setPrcGenSpclRtTpCd(oftVO.getPrcGenSpclRtTpCd());
				newVO.setPrcCmdtHdrSeq(oftVO.getPrcCmdtHdrSeq());
				newVO.setPrcRoutSeq(oftVO.getPrcRoutSeq());
				newVO.setOpCntrQty(oftVO.getOpCntrQty());
				newVO.setPrcRtSeq(oftVO.getPrcRtSeq());
				newVO.setPorMtchFlg(oftVO.getPorMtchFlg());
				newVO.setDelMtchFlg(oftVO.getDelMtchFlg());
				newVO.setEqSubstCntrTpszCd(oftVO.getEqSubstCntrTpszCd());
				
				dbDao.addAutoRtOcnFrtTempByTaa(newVO, pctlNo, usrId);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Set parameter for verify rate
	 * @param SearchTaaOftAutoratingListVO oftVO
	 * @param String pctlNo
	 * @param String usrId
	 * @param List<PriSimChgRtVO> priSimChgRtVOs
	 * @exception EventException
	 */
	private void manageChgOFTbyPatt(SearchTaaOftAutoratingListVO oftVO, String pctlNo, String usrId, List<PriSimChgRtVO> priSimChgRtVOs) throws EventException {
		try {
			if(oftVO==null) return;
			
			String patt = oftVO.getRtMtchPattCd().substring(0,4);
			PriSimChgRtVO newVO;

			for(int i=0; i<5; i++){
				newVO = new PriSimChgRtVO();
				if(i==0){
					newVO.setChgCd("OFT");
					newVO.setCurrCd(oftVO.getCurrCd());
					newVO.setChgUtAmt(oftVO.getRtCalcFrtRtAmt());
					newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getRtFnlFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
				}
				if(i==1){//OIH
					if("1".equals(patt.substring(0,1))){
						newVO.setChgCd("OIH");
						newVO.setCurrCd(oftVO.getOiCurrCd());
						newVO.setChgUtAmt(oftVO.getOiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==2){//OAR
					if("1".equals(patt.substring(1,2))){
						newVO.setChgCd("OAR");
						newVO.setCurrCd(oftVO.getOaCurrCd());
						newVO.setChgUtAmt(oftVO.getOaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getOaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==3){//DAR
					if("1".equals(patt.substring(2,3))){
						newVO.setChgCd("DAR");
						newVO.setCurrCd(oftVO.getDaCurrCd());
						newVO.setChgUtAmt(oftVO.getDaCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDaCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				if(i==4){//DIH
					if("1".equals(patt.substring(3,4))){
						newVO.setChgCd("DIH");
						newVO.setCurrCd(oftVO.getDiCurrCd());
						newVO.setChgUtAmt(oftVO.getDiCalcFrtRtAmt());
						newVO.setChgAmt(Double.toString(Double.parseDouble(oftVO.getDiCalcFrtRtAmt()) * Double.parseDouble(oftVO.getOpCntrQty())));
					}else{
						continue;
					}
				}
				newVO.setPctlNo(pctlNo);
				newVO.setCntrSzCd(oftVO.getCntrTpszCd());
				newVO.setCmdtCd(oftVO.getTmCmdtCd());
				newVO.setCmdtSeq(oftVO.getCmdtSeq());
				newVO.setFrtTermCd("P");
				newVO.setCgoCateCd(oftVO.getCgoCateCd());
				newVO.setImdgClssCd(oftVO.getImdgClssCd());
				newVO.setRatAsQty(oftVO.getOpCntrQty());
				newVO.setRatUtCd(oftVO.getRatUtCd());
				newVO.setRcvTermCd(oftVO.getRcvTermCd());
				newVO.setDeTermCd(oftVO.getDeTermCd());
				newVO.setFrtInclXcldDivCd("N");
				newVO.setNoteRtSeq(oftVO.getPrcRtSeq());
				newVO.setPropNo(oftVO.getPropNo());
				newVO.setAmdtSeq(oftVO.getAmdtSeq());
				newVO.setSvcScpCd(oftVO.getSvcScpCd());
				newVO.setGenSpclRtTpCd(oftVO.getPrcGenSpclRtTpCd());
				newVO.setCmdtHdrSeq(oftVO.getPrcCmdtHdrSeq());
				newVO.setRoutSeq(oftVO.getPrcRoutSeq());
				newVO.setCreUsrId(usrId);
				newVO.setAutoRatFlg(oftVO.getAutoRatFlg());
				newVO.setSocFlg(oftVO.getSocFlg());
				
				priSimChgRtVOs.add(newVO);
				
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}