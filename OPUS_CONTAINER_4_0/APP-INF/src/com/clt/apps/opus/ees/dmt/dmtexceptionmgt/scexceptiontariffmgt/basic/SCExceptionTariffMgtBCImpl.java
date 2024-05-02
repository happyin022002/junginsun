/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtBCImpl.java
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration.SCExceptionTariffMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionDeleteVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionGRPVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionParamVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see reference DAO class of EES_DMT_2001EventResponse,SCExceptionTariffMgtBC  
 * @since J2EE 1.6
 */
public class SCExceptionTariffMgtBCImpl extends BasicCommandSupport implements
		SCExceptionTariffMgtBC {

	// Database Access Object
	private transient SCExceptionTariffMgtDBDAO sCDBDao = null;
	private transient DMTCalculationDBDAO calcDBDao = null;

	/**
	 * DualTypeExceptionMgtBCImpl Create object<br>
	 * Create DualTypeExceptionMgtDBDAO.<br>
	 */
	public SCExceptionTariffMgtBCImpl() {
		sCDBDao = new SCExceptionTariffMgtDBDAO();
		calcDBDao = new DMTCalculationDBDAO();
	}
	
	/**
	 * Search S/C Exception Terms Entry . <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCException(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionVO> sCExceptionVOs = null;
		try {
			sCExceptionVOs = sCDBDao.searchSCException(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sCExceptionVOs;
	}
	
	/**
	 * Search Multi Coverage information of S/C Exception Tariff  Group Seq.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionFreeTimeVO>
	 * @exception EventException
	 */
	public List<SCExceptionCoverageVO> searchMultiCoverageBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionCoverageVO> sCExceptionCoverageVOs = null;
		try {
			sCExceptionCoverageVOs = sCDBDao.searchMultiCoverageBySC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sCExceptionCoverageVOs;
	}
	
	/**
	 *  Search Tiered Free Time of S/C Exception Tariff  Group Seq.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionFreeTimeVO>
	 * @exception EventException
	 */
	public List<SCExceptionFreeTimeVO> searchTieredFreeTimeBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionFreeTimeVO> sCExceptionFreeTimeVOs = null;
		try {
			sCExceptionFreeTimeVOs = sCDBDao.searchTieredFreeTimeBySC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sCExceptionFreeTimeVOs;
	}
	
	/**
	 * Search Rate Adjustment information of S/C Exception Tariff  Group Seq.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionRateAdjustVO>
	 * @exception EventException
	 */
	public List<SCExceptionRateAdjustVO> searchRateAdjustmentBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionRateAdjustVO> sCExceptionRateAdjustVOs = null;
		try {
			sCExceptionRateAdjustVOs = sCDBDao.searchRateAdjustmentBySC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sCExceptionRateAdjustVOs;
	}
	
	/**
	 * Search Actual Customer of S/C Exception Tariff  Group Seq.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchCustomerBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionCustomerVO> sCExceptionCustomerVOs = null;
		try {
			sCExceptionCustomerVOs = sCDBDao.searchCustomerBySC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		return sCExceptionCustomerVOs;
	}
	
	/**
	 * Search Commodity of S/C Exception Tariff Group Seq. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<SCExceptionCommodityVO> searchCommodityBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionCommodityVO> sCExceptionCommodityVOs = null;
		try {
			sCExceptionCommodityVOs = sCDBDao.searchCommodityBySC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sCExceptionCommodityVOs;
	}
	
	/**
	 * checking that Rate Adjustment is mandatory. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return String
	 * @exception EventException
	 */	
	public String checkRateAdjustment(SCExceptionParmVO sCExceptionParmVO) throws EventException {

		try {
			/******************************************************************************************
			 *if Tariff Type is CTIC or CTOC, then  Rate Adjustment is selected item  
			 *  case in exist Coverage information of DMT_CALC_TP table
			 *  case in not exist, if exist Bound, EFF/EXP DT, Coverage, CNTR/Cargo Type
			 *  Customer of  DMT_DUL_TP_EXPT table , then be mandatory item .
			 *  else be selected item.
			 *  
			 *  2016.01.08
			 *  parameter		calculationType			dualTypeException		return
			 *  ----------------------------------------------------------------------
			 *  	C				C												O
			 *  	C				D							True				M
			 *  	C				D							False				E
			 *  	C				NULL											E
			 *  ----------------------------------------------------------------------
			 *  	D				C												E
			 *  	D				D												O
			 *  	D				NULL											E
			 *  ----------------------------------------------------------------------
			 ******************************************************************************************/
			String tariff 	= sCExceptionParmVO.getDmdtTrfCd() 	!= null ? sCExceptionParmVO.getDmdtTrfCd() 	: "";
			String cntCd 	= sCExceptionParmVO.getCntCd() 		!= null ? sCExceptionParmVO.getCntCd() 		: "";
			String rgnCd 	= sCExceptionParmVO.getRgnCd() 		!= null ? sCExceptionParmVO.getRgnCd() 		: "";
			String steCd 	= sCExceptionParmVO.getSteCd() 		!= null ? sCExceptionParmVO.getSteCd() 		: "";
			String locCd 	= sCExceptionParmVO.getLocCd() 		!= null ? sCExceptionParmVO.getLocCd() 		: "";
			String effDt 	= sCExceptionParmVO.getEffDt() 		!= null ? sCExceptionParmVO.getEffDt() 		: "";
			String expDt 	= sCExceptionParmVO.getExpDt() 		!= null ? sCExceptionParmVO.getExpDt() 		: "";
			
			//Calculation Type Check
			CalculationTypeParmVO calcVO = new CalculationTypeParmVO();
			calcVO.setIoBndCd(tariff.substring(2, 3));
			calcVO.setDmdtCalcTpCd(tariff.substring(0, 1));
			calcVO.setCntCd(cntCd);
			calcVO.setRgnCd(rgnCd);
			calcVO.setSteCd(steCd);
			calcVO.setLocCd(locCd);
			calcVO.setEffDt(effDt);
			calcVO.setExpDt(expDt);
			
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO calculationTypeParmVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO();
			calculationTypeParmVO.setIoBnd(tariff.substring(2, 3));
			calculationTypeParmVO.setCntCd(cntCd);
			calculationTypeParmVO.setRgnCd(rgnCd);
			calculationTypeParmVO.setStateCd(steCd);
			calculationTypeParmVO.setLocCd(locCd);
			calculationTypeParmVO.setEffDt(effDt);
			
			if (sCDBDao.checkCalcType(calcVO)) {
				return "O";
			} else if(calcDBDao.searchCalculationType(calculationTypeParmVO).equals("")) { // Calculation Type is NULL
				return "E";
			} else if(calcVO.getDmdtCalcTpCd().equalsIgnoreCase("D")){ // DmdtCalcTpCd = D & check error
				return "E";
			}
			
			//Dual Type Check
			DualTypeCustomerVO dualTypVO = new DualTypeCustomerVO();
			dualTypVO.setCustCntCd(			sCExceptionParmVO.getCustCntCd()		);
			dualTypVO.setCustSeq(			sCExceptionParmVO.getCustSeq()			);
			dualTypVO.setCvrgCntCd(			cntCd									);
			dualTypVO.setCvrgRgnSteCd(		rgnCd.length() > 0 ? rgnCd : steCd		);
			dualTypVO.setCvrgLocCd(			locCd									);				
			dualTypVO.setDmdtCtrtExptTpCd(	sCExceptionParmVO.getDmdtCtrtExptTpCd()	);
			dualTypVO.setIoBndCd(			tariff.substring(2, 3)					);
			dualTypVO.setDulExptEffDt(		sCExceptionParmVO.getEffDt()			);
			dualTypVO.setDulExptExpDt(		sCExceptionParmVO.getExpDt()			);
			dualTypVO.setDmdtCntrCgoTpCd(	sCExceptionParmVO.getDmdtCntrCgoTpCd()	);
			
			if (sCDBDao.checkDualTypeCoverage(dualTypVO)) {
				return "M";
			} else {
				return "E";
			}

		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search Version list of Proposal No. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVersionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVersionVO> searchVersionByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionVersionVO> list = null;
		try {
			list = sCDBDao.searchVersionByProposalNo(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Search Actual Customer / Affiliate information of Proposal No. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchCustomerListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionCustomerVO> custList = null;
		List<SCExceptionCustomerVO> custList1 = null;
		List<SCExceptionCustomerVO> custList2 = null;
		
		try {
			boolean isAffiliate;
			boolean dup_check = false;
			
			//Request search Actual Customer
			if ("Y".equals(sCExceptionParmVO.getCustType())) {
				isAffiliate = false;
			}
			//Request search  Affiliate Customer
			else if ("N".equals(sCExceptionParmVO.getCustType())) {
				isAffiliate = true;
			}
			//load page
			else {
				isAffiliate = sCDBDao.checkAffiliateCustomer(sCExceptionParmVO);
			}

			if (isAffiliate)
				custList1 = sCDBDao.searchAffiliateListBySC(sCExceptionParmVO);
			else
				custList1 = sCDBDao.searchCustomerListBySC(sCExceptionParmVO);
			
			custList2 = sCDBDao.searchCustomerListByDMTSC(sCExceptionParmVO);
			
			if(custList2 == null) {
				custList = custList1;
			}else{
				if(custList1 == null){
					custList = new ArrayList<SCExceptionCustomerVO>();
				}else{
					custList = custList1;
				}
				for(int i = 0 ; i < custList2.size() ; i++) {
					dup_check = false;
					SCExceptionCustomerVO dmtCustomerVO = (SCExceptionCustomerVO)custList2.get(i);
					if(custList1 != null) {
						for(int j = 0 ; j < custList1.size() ; j++) {
							SCExceptionCustomerVO customerVO = (SCExceptionCustomerVO)custList1.get(j);
							if(customerVO.getCustCd().equals(customerVO.getCustCd())) {
								dup_check = true;
								break;
							}
						}
					
						if(!dup_check){
							custList.add(dmtCustomerVO);
						}
					}
				}
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return custList;
	}
	
	/**
	 * Search Commodity information of Proposal No.  <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<SCExceptionCommodityVO> searchCommodityListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionCommodityVO> list = null;
		try {
			list = sCDBDao.searchCommodityListBySC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 *  Modify S/C Exception.  <br>
	 * 
	 * @param SCExceptionGRPVO sCExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifySCException(SCExceptionGRPVO sCExceptionGRPVO, SignOnUserAccount account) throws EventException {
		String 	groupSeq 	= "";
		
		try {
			//S/C Exception Tariff Version =============================================================================================
			SCExceptionVersionVO 			sCExceptionVersionVO 		= sCExceptionGRPVO.getSCExceptionVersionVO();
			
			sCExceptionVersionVO.setCreUsrId(account.getUsr_id());
			sCExceptionVersionVO.setCreOfcCd(account.getOfc_cd());
			sCExceptionVersionVO.setUpdUsrId(account.getUsr_id());
			sCExceptionVersionVO.setUpdOfcCd(account.getOfc_cd());			
			//==========================================================================================================================
			
			//S/C Exception Tariff Terms Entry =========================================================================================
			SCExceptionVO					sCExceptionVO				= null;
			List<SCExceptionVO>	 			sCExceptionVOs 				= sCExceptionGRPVO.getSCExceptionVOS();
			
			if (sCExceptionVOs != null) {
				sCExceptionVO = sCExceptionVOs.get(0);
				
				sCExceptionVO.setCreUsrId(account.getUsr_id());
				sCExceptionVO.setCreOfcCd(account.getOfc_cd());

				//Orgin(I) or Dest.(O)
				if ("US".equals(sCExceptionVO.getScExptFmCntCd()) || "CA".equals(sCExceptionVO.getScExptFmCntCd())) {
					sCExceptionVO.setScExptFmSteCd(sCExceptionVO.getScExptFmRgnCd());
					sCExceptionVO.setScExptFmRgnCd("");
				}
				
				//BKG DEL(I) or POR(O)
				if ("US".equals(sCExceptionVO.getFnlDestCntCd()) || "CA".equals(sCExceptionVO.getFnlDestCntCd())) {
					sCExceptionVO.setFnlDestSteCd(sCExceptionVO.getFnlDestRgnCd());
					sCExceptionVO.setFnlDestRgnCd("");
				}

				//FREE TIME is Single 우
				if (sCExceptionVO.getFtTir().equals("S")) {
					if (sCExceptionVO.getFtTotDys() != null && sCExceptionVO.getFtTotDys().length() > 0) {
						sCExceptionVO.setFtAddDys(sCExceptionVO.getFtTotDys());
					}
				} else {
					sCExceptionVO.setFtAddDys("");
				}

				//Search Version information of S/C Exception Tariff .
				if (!sCDBDao.existSCExceptionVersion(sCExceptionVersionVO)) {
					//if it not exist, then Create.
					sCDBDao.addSCExceptionVersion(sCExceptionVersionVO);
				}
				else {
					//if it exist, then update status to 'Temp.Saved'.
					sCDBDao.modifyVersionSTS(sCExceptionVersionVO);
				}
				
				//create temp history into Version Prog
				//if  current status is  'Temp.Saved' then update else create .
				if (sCDBDao.isTempSavedStatusOfLastVersionProg(sCExceptionVersionVO)) {
					sCDBDao.modifyLastVersionProg(sCExceptionVersionVO);
				}
				else {
					sCDBDao.addSCExceptionVersionProg(sCExceptionVersionVO);
				}
				
				if ("I".equals(sCExceptionVO.getIbflag())) {

					
					//Search  Group Seq. information
					groupSeq = sCDBDao.searchSCExceptionGroupSeq(sCExceptionVO);
					if (groupSeq == null) {
						throw new EventException("DMT00003");
					}
					
					//Create  S/C Exception Tariff information
					sCExceptionVO.setScExptGrpSeq(groupSeq);
					sCDBDao.addSCExceptionGroup(sCExceptionVO);
				}
				else if ("U".equals(sCExceptionVO.getIbflag())) {
					sCExceptionVO.setUpdUsrId(account.getUsr_id());
					sCExceptionVO.setUpdOfcCd(account.getOfc_cd());
					
					//Modify S/C Exception Tariff information.	
					sCDBDao.modifySCExceptionGroup(sCExceptionVO);
				}
			}
			//=========================================================================================================================
			
			// Multi Coverage of S/C Exception Tariff  Group Seq. ==============================================================
			List<SCExceptionCoverageVO> 	sCExceptionCoverageVOs 		= sCExceptionGRPVO.getSCExceptionCoverageVOS();
			List<SCExceptionCoverageVO> 	insSCExceptionCoverageVOs 	= new ArrayList<SCExceptionCoverageVO>();
			List<SCExceptionCoverageVO> 	updSCExceptionCoverageVOs 	= new ArrayList<SCExceptionCoverageVO>();
			List<SCExceptionCoverageVO> 	delSCExceptionCoverageVOs 	= new ArrayList<SCExceptionCoverageVO>();
			
			if (sCExceptionCoverageVOs != null) {
				for (int i = 0 ; i < sCExceptionCoverageVOs.size(); i++) {
					
					//Multi Coverage
					if ("US".equals(sCExceptionCoverageVOs.get(i).getCntCd()) || "CA".equals(sCExceptionCoverageVOs.get(i).getCntCd())) {
						sCExceptionCoverageVOs.get(i).setSteCd(sCExceptionCoverageVOs.get(i).getRgnCd());
						sCExceptionCoverageVOs.get(i).setRgnCd("");
					}
					
					//Create
					if (sCExceptionCoverageVOs.get(i).getIbflag().equals("I")) {
						sCExceptionCoverageVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionCoverageVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//Create Group Seq.
						if (sCExceptionCoverageVOs.get(i).getScExptGrpSeq().length() == 0) {
							sCExceptionCoverageVOs.get(i).setScExptGrpSeq(groupSeq);
						}
						
						insSCExceptionCoverageVOs.add(sCExceptionCoverageVOs.get(i));
					}
					//Modify
					else if (sCExceptionCoverageVOs.get(i).getIbflag().equals("U")) {
						sCExceptionCoverageVOs.get(i).setUpdUsrId(account.getUsr_id());
						sCExceptionCoverageVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updSCExceptionCoverageVOs.add(sCExceptionCoverageVOs.get(i));
					}
					//Delete
					else if (sCExceptionCoverageVOs.get(i).getIbflag().equals("D")) {
						delSCExceptionCoverageVOs.add(sCExceptionCoverageVOs.get(i));
					}
				}
			}
			//=========================================================================================================================
			
			//Tiered Free Time of S/C Exception Tariff ============================================================
			List<SCExceptionFreeTimeVO> 	sCExceptionFreeTimeVOs 		= sCExceptionGRPVO.getSCExceptionFreeTimeVOS();
			List<SCExceptionFreeTimeVO> 	insSCExceptionFreeTimeVOs 	= new ArrayList<SCExceptionFreeTimeVO>();
			List<SCExceptionFreeTimeVO> 	updSCExceptionFreeTimeVOs 	= new ArrayList<SCExceptionFreeTimeVO>();
			List<SCExceptionFreeTimeVO> 	delSCExceptionFreeTimeVOs 	= new ArrayList<SCExceptionFreeTimeVO>();
			
			if (sCExceptionFreeTimeVOs != null) {
				for (int i = 0 ; i < sCExceptionFreeTimeVOs.size(); i++) {
					//Create
					if (sCExceptionFreeTimeVOs.get(i).getIbflag().equals("I")) {
						sCExceptionFreeTimeVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionFreeTimeVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						// Create Group Seq.
						if (sCExceptionFreeTimeVOs.get(i).getScExptGrpSeq().length() == 0) {
							sCExceptionFreeTimeVOs.get(i).setScExptGrpSeq(groupSeq);
						}
						
						insSCExceptionFreeTimeVOs.add(sCExceptionFreeTimeVOs.get(i));
					}
					//Modify
					else if (sCExceptionFreeTimeVOs.get(i).getIbflag().equals("U")) {
						sCExceptionFreeTimeVOs.get(i).setUpdUsrId(account.getUsr_id());
						sCExceptionFreeTimeVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updSCExceptionFreeTimeVOs.add(sCExceptionFreeTimeVOs.get(i));
					}
					//Delete
					else if (sCExceptionFreeTimeVOs.get(i).getIbflag().equals("D")) {
						delSCExceptionFreeTimeVOs.add(sCExceptionFreeTimeVOs.get(i));
					}
				}
			}
			//=========================================================================================================================
			
			// Rate Adjustment =============================================================
			List<SCExceptionRateAdjustVO> 	sCExceptionRateAdjustVOs 	= sCExceptionGRPVO.getSCExceptionRateAdjustVOS();
			List<SCExceptionRateAdjustVO> 	insSCExceptionRateAdjustVOs = new ArrayList<SCExceptionRateAdjustVO>();
			List<SCExceptionRateAdjustVO> 	updSCExceptionRateAdjustVOs = new ArrayList<SCExceptionRateAdjustVO>();
			List<SCExceptionRateAdjustVO> 	delSCExceptionRateAdjustVOs = new ArrayList<SCExceptionRateAdjustVO>();
			
			if (sCExceptionRateAdjustVOs != null) {
				for (int i = 0 ; i < sCExceptionRateAdjustVOs.size(); i++) {
					//Create
					if (sCExceptionRateAdjustVOs.get(i).getIbflag().equals("I")) {
						sCExceptionRateAdjustVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionRateAdjustVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//Create Group Seq.
						if (sCExceptionRateAdjustVOs.get(i).getScExptGrpSeq().length() == 0) {
							sCExceptionRateAdjustVOs.get(i).setScExptGrpSeq(groupSeq);
						}
						
						insSCExceptionRateAdjustVOs.add(sCExceptionRateAdjustVOs.get(i));
					}
					//Modify
					else if (sCExceptionRateAdjustVOs.get(i).getIbflag().equals("U")) {
						sCExceptionRateAdjustVOs.get(i).setUpdUsrId(account.getUsr_id());
						sCExceptionRateAdjustVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updSCExceptionRateAdjustVOs.add(sCExceptionRateAdjustVOs.get(i));
					}
					//Delete
					else if (sCExceptionRateAdjustVOs.get(i).getIbflag().equals("D")) {
						delSCExceptionRateAdjustVOs.add(sCExceptionRateAdjustVOs.get(i));
					}
				}
			}
			//=========================================================================================================================
			
			// Actual Customer =============================================================
			List<SCExceptionCustomerVO> 	sCExceptionCustomerVOs 		= sCExceptionGRPVO.getSCExceptionCustomerVOS();
			List<SCExceptionCustomerVO> 	insSCExceptionCustomerVOs 	= new ArrayList<SCExceptionCustomerVO>();
			//List<SCExceptionCustomerVO> 	updSCExceptionCustomerVOs 	= new ArrayList<SCExceptionCustomerVO>();
//			List<SCExceptionCustomerVO> 	delSCExceptionCustomerVOs 	= new ArrayList<SCExceptionCustomerVO>(); //미사용 변수 제거
			SCExceptionParmVO				sCExceptionParmVO			= new SCExceptionParmVO();
			
			if (sCExceptionCustomerVOs != null) {
				for (int i = 0 ; i < sCExceptionCustomerVOs.size(); i++) {
					//Create
					if (sCExceptionCustomerVOs.get(i).getIbflag().equals("I")
							|| sCExceptionCustomerVOs.get(i).getIbflag().equals("U")
							|| sCExceptionCustomerVOs.get(i).getIbflag().equals("R")) {
						sCExceptionCustomerVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionCustomerVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//Create Group Seq.
						if (sCExceptionCustomerVOs.get(i).getScExptGrpSeq().length() == 0) {
							sCExceptionCustomerVOs.get(i).setScExptGrpSeq(groupSeq);
						}
						
						insSCExceptionCustomerVOs.add(sCExceptionCustomerVOs.get(i));
					}
					//Modify
//					else if (sCExceptionCustomerVOs.get(i).getIbflag().equals("U") || sCExceptionCustomerVOs.get(i).getIbflag().equals("R")) {
//						sCExceptionCustomerVOs.get(i).setCreUsrId(account.getUsr_id());
//						sCExceptionCustomerVOs.get(i).setCreOfcCd(account.getOfc_cd());
//						
//						updSCExceptionCustomerVOs.add(sCExceptionCustomerVOs.get(i));
//					}
					//Delete
					//else if (sCExceptionCustomerVOs.get(i).getIbflag().equals("D")) {
					//	delSCExceptionCustomerVOs.add(sCExceptionCustomerVOs.get(i));
					//}
					sCExceptionParmVO.setPropNo(sCExceptionCustomerVOs.get(i).getPropNo());
					sCExceptionParmVO.setScExptVerSeq(sCExceptionCustomerVOs.get(i).getScExptVerSeq());
					sCExceptionParmVO.setScExptGrpSeq(sCExceptionCustomerVOs.get(i).getScExptGrpSeq());
				}
			}
			//=========================================================================================================================
			
			
			// Commodity ===================================================================
			List<SCExceptionCommodityVO> 	sCExceptionCommodityVOs 	= sCExceptionGRPVO.getSCExceptionCommodityVOS();
			List<SCExceptionCommodityVO> 	insSCExceptionCommodityVOs 	= new ArrayList<SCExceptionCommodityVO>();
			//List<SCExceptionCommodityVO> 	updSCExceptionCommodityVOs 	= new ArrayList<SCExceptionCommodityVO>();
//			List<SCExceptionCommodityVO> 	delSCExceptionCommodityVOs 	= new ArrayList<SCExceptionCommodityVO>(); //미사용 변수 제거
			
			if (sCExceptionCommodityVOs != null) {
				for (int i = 0 ; i < sCExceptionCommodityVOs.size(); i++) {
					log.debug("[ibflag]***********["+i+"]"+sCExceptionCommodityVOs.get(i).getIbflag());
					//Create
					if (sCExceptionCommodityVOs.get(i).getIbflag().equals("I")
							||sCExceptionCommodityVOs.get(i).getIbflag().equals("U")
							||sCExceptionCommodityVOs.get(i).getIbflag().equals("R")) {
						sCExceptionCommodityVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionCommodityVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//Create Group Seq.
						if (sCExceptionCommodityVOs.get(i).getScExptGrpSeq().length() == 0) {
							sCExceptionCommodityVOs.get(i).setScExptGrpSeq(groupSeq);
						}
						
						insSCExceptionCommodityVOs.add(sCExceptionCommodityVOs.get(i));
					}
					//Modify
//					else if (sCExceptionCommodityVOs.get(i).getIbflag().equals("U") || sCExceptionCommodityVOs.get(i).getIbflag().equals("R")) {
//						sCExceptionCommodityVOs.get(i).setCreUsrId(account.getUsr_id());
//						sCExceptionCommodityVOs.get(i).setCreOfcCd(account.getOfc_cd());
//						
//						updSCExceptionCommodityVOs.add(sCExceptionCommodityVOs.get(i));
//					}
					//Delete
					//else if (sCExceptionCommodityVOs.get(i).getIbflag().equals("D")) {
					//	delSCExceptionCommodityVOs.add(sCExceptionCommodityVOs.get(i));
					//}
					sCExceptionParmVO.setPropNo(sCExceptionCommodityVOs.get(i).getPropNo());
					sCExceptionParmVO.setScExptVerSeq(sCExceptionCommodityVOs.get(i).getScExptVerSeq());
					sCExceptionParmVO.setScExptGrpSeq(sCExceptionCommodityVOs.get(i).getScExptGrpSeq());					
				}
			}
			//=========================================================================================================================
			
			//1.[preceding Delete Action] *
			//1-1.Multi Coverage
			if (delSCExceptionCoverageVOs.size() > 0) {
				sCDBDao.removeSCExceptionCoverages(delSCExceptionCoverageVOs);
			}
			//1-2.Tiered Free Time
			if (delSCExceptionFreeTimeVOs.size() > 0) {
				sCDBDao.removeSCExceptionFreeTimes(delSCExceptionFreeTimeVOs);
			}
			//1-3.Rate Adjustment
			if (delSCExceptionRateAdjustVOs.size() > 0) {
				sCDBDao.removeSCExceptionRates(delSCExceptionRateAdjustVOs);
			}
			//1-4.Delete all Actual Customer-GRP.
//			if (insSCExceptionCustomerVOs.size() > 0) {
			if (sCExceptionCustomerVOs!=null && sCExceptionCustomerVOs.size() > 0) {			
				log.debug("--------------------------1------------------");
				sCDBDao.removeSCExceptionCustomer(sCExceptionParmVO);
			}
			//1-5.Delete all Commodity-GRP.
//			if (insSCExceptionCommodityVOs.size() > 0) {
			if (sCExceptionCommodityVOs!=null && sCExceptionCommodityVOs.size() > 0) {
				log.debug("--------------------------2------------------");
				sCDBDao.removeSCExceptionCommodity(sCExceptionParmVO);
			}			
			
			
			
			//2.[Insert Action]
			//2-1.Multi Coverage
			if (insSCExceptionCoverageVOs.size() > 0) {
				sCDBDao.addSCExceptionCoverages(insSCExceptionCoverageVOs);
			}
			//2-2.Tiered Free Time
			if (insSCExceptionFreeTimeVOs.size() > 0) {
				sCDBDao.addSCExceptionFreeTimes(insSCExceptionFreeTimeVOs);
			}
			//2-3.Rate Adjustment
			if (insSCExceptionRateAdjustVOs.size() > 0) {
				sCDBDao.addSCExceptionRates(insSCExceptionRateAdjustVOs);
			}
			log.debug("\n\n % SCExceptionTariffMgtBCImpl.modifySCException() VO SIZE \n ####################################################################################### \n"+
					"\n insSCExceptionCustomerVOs.size():" + (insSCExceptionCustomerVOs!=null?insSCExceptionCustomerVOs.size():0) +
					"\n sCExceptionCustomerVOs.size():" + (sCExceptionCustomerVOs!=null?sCExceptionCustomerVOs.size():0) + 
					"\n insSCExceptionCommodityVOs.size():" + (insSCExceptionCommodityVOs!=null?insSCExceptionCommodityVOs.size():0) +
					"\n sCExceptionCommodityVOs.size():" + (sCExceptionCommodityVOs!=null?sCExceptionCommodityVOs.size():0) + 
			"\n ####################################################################################### \n\n");
			//2-4.Actual Customer
			if (insSCExceptionCustomerVOs!=null && insSCExceptionCustomerVOs.size() > 0) {
				log.debug("--------------------------3------------------");
				sCDBDao.addSCExceptionCustomers(insSCExceptionCustomerVOs);
			}
			//2-5.Commodity
			if (insSCExceptionCommodityVOs!=null && insSCExceptionCommodityVOs.size() > 0) {
				log.debug("--------------------------4------------------");
				sCDBDao.addSCExceptionCommodities(insSCExceptionCommodityVOs);
			}
			
			//3.[Update Action]
			//3-1.Group
			if (sCExceptionVO != null && "U".equals(sCExceptionVO.getIbflag())) {
				sCDBDao.modifySCExceptionGroup(sCExceptionVO);
			}
			//3-2.Multi Coverage
			if (updSCExceptionCoverageVOs.size() > 0) {
				sCDBDao.modifySCExceptionCoverages(updSCExceptionCoverageVOs);
			}
			//3-3.Tiered Free Time
			if (updSCExceptionFreeTimeVOs.size() > 0) {
				sCDBDao.modifySCExceptionFreeTimes(updSCExceptionFreeTimeVOs);
			}
			//3-4.Rate Adjustment
			if (updSCExceptionRateAdjustVOs.size() > 0) {
				sCDBDao.modifySCExceptionRates(updSCExceptionRateAdjustVOs);
			}
			//3-5.Actual Customer
//			if (updSCExceptionCustomerVOs.size() > 0) {
//				log.debug("--------------------------5------------------");
//				sCDBDao.addSCExceptionCustomers(updSCExceptionCustomerVOs);
//			}
//			//3-6.Commodity
//			if (updSCExceptionCommodityVOs.size() > 0) {
//				log.debug("--------------------------6------------------");
//				sCDBDao.addSCExceptionCommodities(updSCExceptionCommodityVOs);
//			}
			
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		}	
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		return groupSeq;
	}
	
	/**
	 * Change status of S/C Exception Version to "Delete" <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void removeSCExceptionByVer(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			sCDBDao.removeSCExceptionByVer(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		catch (Exception ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}		
	}
	
	/**
	 * Check Calculation Type is selected Tariff Type. <br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkCalcType(CalculationTypeParmVO calculationTypeParmVO) throws EventException {
		try {
			return sCDBDao.checkCalcType(calculationTypeParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Check Dual Type is selected Tariff Type.  <br>
	 * 
	 * @param DualTypeCustomerVO dualTypeCustomerVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDualTypeCoverage(DualTypeCustomerVO dualTypeCustomerVO) throws EventException {
		try {
			return sCDBDao.checkDualTypeCoverage(dualTypeCustomerVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Comparing Continent of cnt_cd and Continent of  Coverage cnt_cd in inputting  BKG POR(O) or DEL(I)<br>
	 * 
	 * @param SCExceptionVO sCExceptionVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkContinentType(SCExceptionVO sCExceptionVO) throws EventException {
		try {
			return sCDBDao.checkContinentType(sCExceptionVO);
		} catch (DAOException ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  Check S/C ' status is Filed.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkFiledBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.checkFiledBySC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Modify status of S/C Exception Version <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @exception EventException
	 */
	public void modifyVersionSTS(SCExceptionVersionVO sCExceptionVersionVO) throws EventException {
		try {
			
			// in request Filed , if is not 'Accepted' then return 
			if ("File".equals(sCExceptionVersionVO.getCaller())) {
				if (!sCDBDao.isAcceptedVersionSTS(sCExceptionVersionVO)) {
					return;
				}
			}
			
			// change status
			sCDBDao.modifyVersionSTS(sCExceptionVersionVO);
			// make log 
			sCDBDao.addSCExceptionVersionProg(sCExceptionVersionVO);
			
			// if status change to "Live", then  Deleted 이하버전의 Live 상태는 모두 Deleted 상태로 변경한다.
			if ("L".equals(sCExceptionVersionVO.getDmdtExptVerStsCd()) 
					&& 1 < Integer.parseInt(sCExceptionVersionVO.getScExptVerSeq())) {
				sCDBDao.modifyUnderVersionDelSTS(sCExceptionVersionVO);
				//상태를 변경한 로그를 기록한다.
				sCDBDao.addUnderVersionPROG(sCExceptionVersionVO);				
			}
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Search S/C, RFA Exception <br>
	 * 
	 * @param SCRFAExceptionParamVO sCRFAExceptionParamVO
	 * @return List<SCRFAExceptionListVO>
	 * @exception EventException
	 */
	public List<SCRFAExceptionListVO> searchSCRFAExceptionList(SCRFAExceptionParamVO sCRFAExceptionParamVO) throws EventException {
		List<SCRFAExceptionListVO> list = null;

		try {
			if ("SC".equals(sCRFAExceptionParamVO.getType())) {
				if ("OFC".equals(sCRFAExceptionParamVO.getCondTp())) {
					list = sCDBDao.searchSCTariffListByOffice(sCRFAExceptionParamVO);		
				}
				else if ("CVRG".equals(sCRFAExceptionParamVO.getCondTp())) {
					list = sCDBDao.searchSCTariffListByCoverage(sCRFAExceptionParamVO);			
				}
				else if ("DAR".equals(sCRFAExceptionParamVO.getCondTp())) {
					list = sCDBDao.searchSCTariffListByDAR(sCRFAExceptionParamVO);						
				}
			}
			else {
				if ("OFC".equals(sCRFAExceptionParamVO.getCondTp())) {
					list = sCDBDao.searchBeforeBookingListByOffice(sCRFAExceptionParamVO);								
				}
				else if ("CVRG".equals(sCRFAExceptionParamVO.getCondTp())) {
					list = sCDBDao.searchBeforeBookingListByCoverage(sCRFAExceptionParamVO);							
				}
				else if ("DAR".equals(sCRFAExceptionParamVO.getCondTp())) {
					list = sCDBDao.searchBeforeBookingListByDAR(sCRFAExceptionParamVO);							
				}
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Search SC No, Customer Code and Customer Name of Proposal No. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchSCNoCustomerByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.searchSCNoCustomerByProposalNo(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search S/C Duration of Proposal No <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return SCExceptionParmVO
	 * @exception EventException
	 */
	public SCExceptionParmVO searchSCDuration(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.searchSCDuration(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * check authority that S/C Exception Tariff  Accept, Accept Cancel.
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasAcceptAuth(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.hasAcceptAuth(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search Affiliate Customer. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchAffiliateListBySC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.searchAffiliateListBySC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * check that Customer Type is 'Affiliate'.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkAffiliateCustomer(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.checkAffiliateCustomer(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  check that Customer Type is S/C Customer. <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isSCCustomer(String custCntCd, String custSeq) throws EventException {
		try {
			return sCDBDao.isSCCustomer(custCntCd, custSeq);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search S/C Exception of Prop No. <br>
	 * 
	 * @param String propNo
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCExceptionListByPropNo(String propNo) throws EventException {
		try {
			return sCDBDao.searchSCExceptionListByPropNo(propNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Search S/C Exception of Customer Code. <br>
	 * 
	 * @param String custNo
	 * @return List<SCExceptionVO>
	 * @exception EventException
	 */
	public List<SCExceptionVO> searchSCExceptionListByCustomer(String custNo) throws EventException {
		try {
			return sCDBDao.searchSCExceptionListByCustomer(custNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Delete all selected S/C Exception Tariff and that's belongs.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void removeSCException(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			sCDBDao.removeSCExceptionCommodity(			sCExceptionParmVO	);
			sCDBDao.removeSCExceptionCustomer(			sCExceptionParmVO	);
			sCDBDao.removeSCExceptionRateAdjustment(	sCExceptionParmVO	);
			sCDBDao.removeSCExceptionFreeTime(			sCExceptionParmVO	);
			sCDBDao.removeSCExceptionCoverage(			sCExceptionParmVO	);
			sCDBDao.removeSCExceptionTariff(			sCExceptionParmVO	);
			
			//  Search Group information in S/C Exception Tariff Version.
			if (!sCDBDao.existSCException(sCExceptionParmVO)) {
				//not exist , delete  Version Prog information.
				sCDBDao.removeSCExceptionVersionProg(sCExceptionParmVO);
				// not exist , delete  Version information.
				sCDBDao.removeSCExceptionVersion(sCExceptionParmVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * when Update button click, if status of S/C Exception Tariff informatio is "Live" , then Create new version<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByUpdate(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			//1.new version information.
			String 					versionSeq 				= sCDBDao.searchSCExceptionVersionSeq(sCExceptionParmVO.getPropNo());

			//2.Version object for createion
			SCExceptionVersionVO	sCExceptionVersionVO	= new SCExceptionVersionVO();
			
			sCExceptionVersionVO.setPropNo(				sCExceptionParmVO.getPropNo()			);
			sCExceptionVersionVO.setScExptVerSeq(		versionSeq								);
			sCExceptionVersionVO.setCreUsrId(			sCExceptionParmVO.getCreUsrId()			);
			sCExceptionVersionVO.setCreOfcCd(			sCExceptionParmVO.getCreOfcCd()			);
			sCExceptionVersionVO.setDmdtExptVerStsCd(	sCExceptionParmVO.getDmdtExptVerStsCd()	);

			//2-1 set  Version Seq. 
			sCExceptionParmVO.setScExptVerSeq(			versionSeq								);
			
			//3. Create information and status is 'Temp' .
			sCDBDao.addSCExceptionVersion(sCExceptionVersionVO);
			
			//4.Create Version Prog and status is 'Temp' 
			sCDBDao.addSCExceptionVersionProg(sCExceptionVersionVO);
			
			//5. Create  S/C Exception Tariff Group information all old versions.
			sCDBDao.addSCExceptionGroupOfPrevVersion(sCExceptionParmVO);
			
			//6. Create  S/C Exception Tariff Multi Coverage information  all old versions.
			sCDBDao.addSCExceptionCoverageOfPrevVersion(sCExceptionParmVO);
			
			//7. Create  S/C Exception Tariff Free Time information  all old versions.
			sCDBDao.addSCExceptionFreeTimeOfPrevVersion(sCExceptionParmVO);
			
			//8.Create  S/C Exception Tariff Rate Adjustment information  all old versions.
			sCDBDao.addSCExceptionRateAdjustmentOfPrevVersion(sCExceptionParmVO);
			
			//9.Create  S/C Exception Tariff Customer information  all old versions.
			sCDBDao.addSCExceptionCustomerOfPrevVersion(sCExceptionParmVO);
			
			//10.Create S/C Exception Tariff Commodity information  all old versions.
			sCDBDao.addSCExceptionCommodityOfPrevVersion(sCExceptionParmVO);
			
		} catch (DAOException ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}		
	
	/**
	 * Delete currenct information,  Create information of S/C Exception Tariff History selected version.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByHistoryCopy(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			//1. Version object for Creation.
			SCExceptionVersionVO	sCExceptionVersionVO	= new SCExceptionVersionVO();
			SCExceptionDeleteVO		sCExceptionDeleteVO		= null;
			
			sCExceptionVersionVO.setPropNo(				sCExceptionParmVO.getPropNo()			);
			sCExceptionVersionVO.setScExptVerSeq(		sCExceptionParmVO.getScExptVerSeq()		);
			sCExceptionVersionVO.setCreUsrId(			sCExceptionParmVO.getCreUsrId()			);
			sCExceptionVersionVO.setCreOfcCd(			sCExceptionParmVO.getCreOfcCd()			);
			sCExceptionVersionVO.setUpdUsrId(			sCExceptionParmVO.getUpdUsrId()			);
			sCExceptionVersionVO.setUpdOfcCd(			sCExceptionParmVO.getUpdOfcCd()			);
			sCExceptionVersionVO.setDmdtExptVerStsCd(	sCExceptionParmVO.getDmdtExptVerStsCd()	);
			
			//exist current version , then Delete S/C Exception Tariff information.
			if (sCDBDao.existSCException(sCExceptionParmVO)) {
				sCExceptionDeleteVO = new SCExceptionDeleteVO();
				sCExceptionDeleteVO.setDelPropNo(			sCExceptionParmVO.getPropNo()		);
				sCExceptionDeleteVO.setDelScExptVerSeq(		sCExceptionParmVO.getScExptVerSeq()	);
				
				sCDBDao.removeSCExceptionByPropVerNo(sCExceptionDeleteVO);
			}
			
			//2.Modify syatus to 'Temp.Saved' in current version.
			if (!sCDBDao.existSCExceptionVersion(sCExceptionVersionVO)) {
				//not exist,  Create information.
				sCDBDao.addSCExceptionVersion(sCExceptionVersionVO);
			}
			else {
				//update to 'Temp.Saved' .
				sCDBDao.modifyVersionSTS(sCExceptionVersionVO);
			}
			
			//3. information of current version ,  Create Version Prog.'Temp.Saved' .
			if (sCDBDao.isTempSavedStatusOfLastVersionProg(sCExceptionVersionVO)) {
				sCDBDao.modifyLastVersionProg(sCExceptionVersionVO);
			}
			else {
				sCDBDao.addSCExceptionVersionProg(sCExceptionVersionVO);
			}			
			
			//4.Create S/C Exception Tariff Group information all old versions.
			sCDBDao.addSCExceptionGroupOfHistVersion(sCExceptionParmVO);
			
			//5.Create S/C Exception Tariff Multi Coverage information all old versions.
			sCDBDao.addSCExceptionCoverageOfHistVersion(sCExceptionParmVO);
			
			//6.Create S/C Exception Tariff Free Time information all old versions.
			sCDBDao.addSCExceptionFreeTimeOfHistVersion(sCExceptionParmVO);
			
			//7.Create S/C Exception Tariff Rate Adjustment information all old versions.
			sCDBDao.addSCExceptionRateAdjustmentOfHistVersion(sCExceptionParmVO);
			
			//8.Create S/C Exception Tariff Customer information all old versions.
			sCDBDao.addSCExceptionCustomerOfHistVersion(sCExceptionParmVO);
			
			//9.Create S/C Exception Tariff Commodity information all old versions.
			sCDBDao.addSCExceptionCommodityOfHistVersion(sCExceptionParmVO);
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Check Duplication inputted S/C information and created S/C information.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isDuplicateSC(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.isDuplicateSC(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}	
	/**
	 * Search same customer existing in PRI_SP_CTRT_PTY.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isCustomerByPriMn(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.isCustomerByPriMn(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}	
}