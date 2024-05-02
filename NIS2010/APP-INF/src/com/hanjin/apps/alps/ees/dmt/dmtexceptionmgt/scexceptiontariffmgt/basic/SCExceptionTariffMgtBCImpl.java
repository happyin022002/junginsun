/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtBCImpl.java
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.20 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration.SCExceptionTariffMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionDeleteVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionMasVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionPfmcVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - NIS2010-DMTExceptionMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2001EventResponse,SCExceptionTariffMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCExceptionTariffMgtBCImpl extends BasicCommandSupport implements
		SCExceptionTariffMgtBC {

	// Database Access Object
	private transient SCExceptionTariffMgtDBDAO sCDBDao = null;

	/**
	 * DualTypeExceptionMgtBCImpl 객체 생성<br>
	 * DualTypeExceptionMgtDBDAO를 생성한다.<br>
	 */
	public SCExceptionTariffMgtBCImpl() {
		sCDBDao = new SCExceptionTariffMgtDBDAO();
	}
	
	/**
	 * S/C Exception Terms Entry를 조회 합니다. <br>
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
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Multi Coverage 정보를 조회 합니다.<br>
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
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Tiered Free Time를 조회 합니다.<br>
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
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Rate Adjustment를 조회 합니다.<br>
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
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Actual Customer를 조회 합니다.<br>
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
	 * S/C Exception Tariff 의 Group Seq. 에 해당되는 Commodity를 조회 합니다. <br>
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
	 * Rate Adjustment 가 필수항목인지 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return String
	 * @exception EventException
	 */	
	public String checkRateAdjustment(SCExceptionParmVO sCExceptionParmVO) throws EventException {

		try {
			/******************************************************************************************
			 * Tariff Type 이 CTIC, CTOC 일 경우에 DMT_CALC_TP 테이블에 Coverage 정보에 해당되는 
			 * 데이터가 있을 경우 Rate Adjustment 는 선택항목이 된다.
			 * 항목이 없을 경우 DMT_DUL_TP_EXPT 테이블에 Bound, EFF/EXP DT, Coverage, CNTR/Cargo Type
			 * Customer 에 해당되는 데이터가 있을 경우 필수항목이 된다.
			 * 그렇지 않으면 선택항목이 된다.
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
			
			if (sCDBDao.checkCalcType(calcVO)) {
				return "O";
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
			dualTypVO.setPropNo(			sCExceptionParmVO.getPropNo()			);
			
			if (sCDBDao.checkDualTypeCoverage(dualTypVO)) {
				return "M";
			}
			
			return "E";

		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Proposal No. 에 해당되는 모든 Version 정보를 조회 합니다. <br>
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
	 * Proposal No. 에 해당하는 Actual Customer / Affiliate 정보를 조회 합니다. <br>
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
			
			//Actual Customer 조회 요청시(화면에서 선택시)
			if ("Y".equals(sCExceptionParmVO.getCustType())) {
				isAffiliate = false;
			}
			//Affiliate Customer 조회 요청시(화면에서 선택시)
			else if ("N".equals(sCExceptionParmVO.getCustType())) {
				isAffiliate = true;
			}
			//화면 로드시
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
						
					if(custList1 != null){
						for(int j = 0 ; j < custList1.size() ; j++) {
							SCExceptionCustomerVO customerVO = (SCExceptionCustomerVO)custList1.get(j);
							if(customerVO.getCustCd().equals(customerVO.getCustCd())) {
								dup_check = true;
								break;
							}
						}
					}
					if(!dup_check){
						custList.add(dmtCustomerVO);
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
	 * Proposal No. 에 해당하는 Commodity 정보를 조회 합니다. <br>
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
	 * S/C Exception 을 수정 합니다. <br>
	 * 
	 * @param SCExceptionGRPVO sCExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifySCException(SCExceptionGRPVO sCExceptionGRPVO, SignOnUserAccount account) throws EventException {
		String 	groupSeq 	= null;
		
		try {
			//S/C Exception Tariff Version =============================================================================================
			SCExceptionVersionVO 			sCExceptionVersionVO 		= sCExceptionGRPVO.getSCExceptionVersionVO();
			
			sCExceptionVersionVO.setCreUsrId(account.getUsr_id());
			sCExceptionVersionVO.setCreOfcCd(account.getOfc_cd());
			sCExceptionVersionVO.setUpdUsrId(account.getUsr_id());
			sCExceptionVersionVO.setUpdOfcCd(account.getOfc_cd());			
			
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

				//FREE TIME 이 Single 일 경우
				if (sCExceptionVO.getFtTir().equals("S")) {
					if (sCExceptionVO.getFtTotDys() != null && sCExceptionVO.getFtTotDys().length() > 0) {
						sCExceptionVO.setFtAddDys(sCExceptionVO.getFtTotDys());
					}
				} else {
					sCExceptionVO.setFtAddDys("");
				}

				//S/C Exception Tariff 의 Version 정보가 존재하는지 조회 합니다.
				if (!sCDBDao.existSCExceptionVersion(sCExceptionVersionVO)) {
					//Version 정보가 없으면 생성 합니다.
					sCDBDao.addSCExceptionVersion(sCExceptionVersionVO);
				}
				else {
					//Version 정보가 있다면, 상태를 'Temp.Saved' 으로 Version 의 상태를 갱신한다.
					sCDBDao.modifyVersionSTS(sCExceptionVersionVO);
				}
				
				//Version Prog 테이블에 Temp 상태의 이력을 쌓는다.
				//만일, 현재 버전의 상태가 'Temp.Saved' 일 경우에는 갱신해주고 그렇지 않다면 생성해준다.
				if (sCDBDao.isTempSavedStatusOfLastVersionProg(sCExceptionVersionVO)) {
					sCDBDao.modifyLastVersionProg(sCExceptionVersionVO);
				}
				else {
					sCDBDao.addSCExceptionVersionProg(sCExceptionVersionVO);
				}
				
				if ("I".equals(sCExceptionVO.getIbflag())) {
					//Group Seq. 정보를 조회합니다.
					groupSeq = sCDBDao.searchSCExceptionGroupSeq(sCExceptionVO);
					
					if (groupSeq == null) {
						throw new EventException("DMT00003");
					}
					
					//S/C Exception Tariff 정보를 생성 합니다.
					sCExceptionVO.setScExptGrpSeq(groupSeq);
					sCDBDao.addSCExceptionGroup(sCExceptionVO);
				}
				else if ("U".equals(sCExceptionVO.getIbflag())) {
					sCExceptionVO.setUpdUsrId(account.getUsr_id());
					sCExceptionVO.setUpdOfcCd(account.getOfc_cd());
					
					//S/C Exception Tariff 정보를 수정 합니다.	
					sCDBDao.modifySCExceptionGroup(sCExceptionVO);
				}
			}
			
			//S/C Exception Tariff 의 Group Seq. 에 해당하는 Multi Coverage ==============================================================
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
					
					//생성
					if (sCExceptionCoverageVOs.get(i).getIbflag().equals("I")) {
						sCExceptionCoverageVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionCoverageVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//S/C Exception Tariff Group 이 신규생성되었을 경우 Group Seq.가 없기때문에 추가해준다.
						if (sCExceptionCoverageVOs.get(i).getScExptGrpSeq() == null || "".equals(sCExceptionCoverageVOs.get(i).getScExptGrpSeq())) {
							sCExceptionCoverageVOs.get(i).setScExptGrpSeq(groupSeq);
						}

						insSCExceptionCoverageVOs.add(sCExceptionCoverageVOs.get(i));
					}
					//수정
					else if (sCExceptionCoverageVOs.get(i).getIbflag().equals("U")) {
						sCExceptionCoverageVOs.get(i).setUpdUsrId(account.getUsr_id());
						sCExceptionCoverageVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updSCExceptionCoverageVOs.add(sCExceptionCoverageVOs.get(i));
					}
					//삭제
					else if (sCExceptionCoverageVOs.get(i).getIbflag().equals("D")) {
						delSCExceptionCoverageVOs.add(sCExceptionCoverageVOs.get(i));
					}
				}
			}
			
			//S/C Exception Tariff 의 Group Seq. 에 해당하는 Tiered Free Time ============================================================
			List<SCExceptionFreeTimeVO> 	sCExceptionFreeTimeVOs 		= sCExceptionGRPVO.getSCExceptionFreeTimeVOS();
			List<SCExceptionFreeTimeVO> 	insSCExceptionFreeTimeVOs 	= new ArrayList<SCExceptionFreeTimeVO>();
			List<SCExceptionFreeTimeVO> 	updSCExceptionFreeTimeVOs 	= new ArrayList<SCExceptionFreeTimeVO>();
			List<SCExceptionFreeTimeVO> 	delSCExceptionFreeTimeVOs 	= new ArrayList<SCExceptionFreeTimeVO>();
			
			if (sCExceptionFreeTimeVOs != null) {
				for (int i = 0 ; i < sCExceptionFreeTimeVOs.size(); i++) {
					//생성
					if (sCExceptionFreeTimeVOs.get(i).getIbflag().equals("I")) {
						sCExceptionFreeTimeVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionFreeTimeVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//S/C Exception Tariff Group 이 신규생성되었을 경우 Group Seq.가 없기때문에 추가해준다.
						if (sCExceptionFreeTimeVOs.get(i).getScExptGrpSeq() == null || "".equals(sCExceptionFreeTimeVOs.get(i).getScExptGrpSeq())) {
							sCExceptionFreeTimeVOs.get(i).setScExptGrpSeq(groupSeq);
						}
						
						insSCExceptionFreeTimeVOs.add(sCExceptionFreeTimeVOs.get(i));
					}
					//수정
					else if (sCExceptionFreeTimeVOs.get(i).getIbflag().equals("U")) {
						sCExceptionFreeTimeVOs.get(i).setUpdUsrId(account.getUsr_id());
						sCExceptionFreeTimeVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updSCExceptionFreeTimeVOs.add(sCExceptionFreeTimeVOs.get(i));
					}
					//삭제
					else if (sCExceptionFreeTimeVOs.get(i).getIbflag().equals("D")) {
						delSCExceptionFreeTimeVOs.add(sCExceptionFreeTimeVOs.get(i));
					}
				}
			}
			//=========================================================================================================================
			
			//S/C Exception Tariff 의 Group Seq. 에 해당하는 Rate Adjustment =============================================================
			List<SCExceptionRateAdjustVO> 	sCExceptionRateAdjustVOs 	= sCExceptionGRPVO.getSCExceptionRateAdjustVOS();
			List<SCExceptionRateAdjustVO> 	insSCExceptionRateAdjustVOs = new ArrayList<SCExceptionRateAdjustVO>();
			List<SCExceptionRateAdjustVO> 	updSCExceptionRateAdjustVOs = new ArrayList<SCExceptionRateAdjustVO>();
			List<SCExceptionRateAdjustVO> 	delSCExceptionRateAdjustVOs = new ArrayList<SCExceptionRateAdjustVO>();
			
			if (sCExceptionRateAdjustVOs != null) {
				for (int i = 0 ; i < sCExceptionRateAdjustVOs.size(); i++) {
					//생성
					if (sCExceptionRateAdjustVOs.get(i).getIbflag().equals("I")) {
						sCExceptionRateAdjustVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionRateAdjustVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//S/C Exception Tariff Group 이 신규생성되었을 경우 Group Seq.가 없기때문에 추가해준다.
						if (sCExceptionRateAdjustVOs.get(i).getScExptGrpSeq() == null || "".equals(sCExceptionRateAdjustVOs.get(i).getScExptGrpSeq())) {
							sCExceptionRateAdjustVOs.get(i).setScExptGrpSeq(groupSeq);
						}
												
						insSCExceptionRateAdjustVOs.add(sCExceptionRateAdjustVOs.get(i));
					}
					//수정
					else if (sCExceptionRateAdjustVOs.get(i).getIbflag().equals("U")) {
						sCExceptionRateAdjustVOs.get(i).setUpdUsrId(account.getUsr_id());
						sCExceptionRateAdjustVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updSCExceptionRateAdjustVOs.add(sCExceptionRateAdjustVOs.get(i));
					}
					//삭제
					else if (sCExceptionRateAdjustVOs.get(i).getIbflag().equals("D")) {
						delSCExceptionRateAdjustVOs.add(sCExceptionRateAdjustVOs.get(i));
					}
				}
			}
			//=========================================================================================================================
			
			//S/C Exception Tariff 의 Group Seq. 에 해당하는 Actual Customer =============================================================
			List<SCExceptionCustomerVO> 	sCExceptionCustomerVOs 		= sCExceptionGRPVO.getSCExceptionCustomerVOS();
			List<SCExceptionCustomerVO> 	insSCExceptionCustomerVOs 	= new ArrayList<SCExceptionCustomerVO>();
			SCExceptionParmVO				sCExceptionParmVO			= new SCExceptionParmVO();
			
			if (sCExceptionCustomerVOs != null) {
				for (int i = 0 ; i < sCExceptionCustomerVOs.size(); i++) {
					//생성
					if (sCExceptionCustomerVOs.get(i).getIbflag().equals("I")
							|| sCExceptionCustomerVOs.get(i).getIbflag().equals("U")
							|| sCExceptionCustomerVOs.get(i).getIbflag().equals("R")) {
						sCExceptionCustomerVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionCustomerVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//S/C Exception Tariff Group 이 신규생성되었을 경우 Group Seq.가 없기때문에 추가해준다.
						if (sCExceptionCustomerVOs.get(i).getScExptGrpSeq() == null || "".equals(sCExceptionCustomerVOs.get(i).getScExptGrpSeq())) {
							sCExceptionCustomerVOs.get(i).setScExptGrpSeq(groupSeq);
						}

						insSCExceptionCustomerVOs.add(sCExceptionCustomerVOs.get(i));
					}

					sCExceptionParmVO.setPropNo(sCExceptionCustomerVOs.get(i).getPropNo());
					sCExceptionParmVO.setScExptVerSeq(sCExceptionCustomerVOs.get(i).getScExptVerSeq());
					sCExceptionParmVO.setScExptGrpSeq(sCExceptionCustomerVOs.get(i).getScExptGrpSeq());
				}
			}
			//=========================================================================================================================
			
			//S/C Exception Tariff 의 Group Seq. 에 해당하는 Commodity ===================================================================
			List<SCExceptionCommodityVO> 	sCExceptionCommodityVOs 	= sCExceptionGRPVO.getSCExceptionCommodityVOS();
			List<SCExceptionCommodityVO> 	insSCExceptionCommodityVOs 	= new ArrayList<SCExceptionCommodityVO>();
			
			if (sCExceptionCommodityVOs != null) {
				for (int i = 0 ; i < sCExceptionCommodityVOs.size(); i++) {
					log.debug("[ibflag]***********["+i+"]"+sCExceptionCommodityVOs.get(i).getIbflag());
					//생성
					if (sCExceptionCommodityVOs.get(i).getIbflag().equals("I")
							||sCExceptionCommodityVOs.get(i).getIbflag().equals("U")
							||sCExceptionCommodityVOs.get(i).getIbflag().equals("R")) {
						sCExceptionCommodityVOs.get(i).setCreUsrId(account.getUsr_id());
						sCExceptionCommodityVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//S/C Exception Tariff Group 이 신규생성되었을 경우 Group Seq.가 없기때문에 추가해준다.
						if (sCExceptionCommodityVOs.get(i).getScExptGrpSeq() == null || "".equals(sCExceptionCommodityVOs.get(i).getScExptGrpSeq())) {
							sCExceptionCommodityVOs.get(i).setScExptGrpSeq(groupSeq);
						}
												
						insSCExceptionCommodityVOs.add(sCExceptionCommodityVOs.get(i));
					}

					sCExceptionParmVO.setPropNo(sCExceptionCommodityVOs.get(i).getPropNo());
					sCExceptionParmVO.setScExptVerSeq(sCExceptionCommodityVOs.get(i).getScExptVerSeq());
					sCExceptionParmVO.setScExptGrpSeq(sCExceptionCommodityVOs.get(i).getScExptGrpSeq());					
				}
			}
			//=========================================================================================================================

			//1.[Delete Action] * 반드시 삭제 Action 이 먼저 실행되어야 한다. *
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
			//1-4.Actual Customer-GRP의 전체를 삭제한다.
			if (sCExceptionCustomerVOs!=null && sCExceptionCustomerVOs.size() > 0) {			
				log.debug("--------------------------1------------------");
				/**
				 * 2010-08-10: Customer는 DMT_SC_EXPT_ACT_CUST에서 무조건 PROP_NO/VER_SEQ/GRP_SEQ에 해당하는 DATA를 다 지우고 다시 넣는다.
				 */				
				sCDBDao.removeSCExceptionCustomer(sCExceptionParmVO);
			}
			//1-5.Commodity-GRP의 전체를 삭제한다.
			if (sCExceptionCommodityVOs!=null && sCExceptionCommodityVOs.size() > 0) {
				log.debug("--------------------------2------------------");
				/**
				 * 2010-08-10: Commodity는 DMT_SC_EXPT_CMDT에서 무조건 PROP_NO/VER_SEQ/GRP_SEQ에 해당하는 DATA를 다 지우고 다시 넣는다.
				 */				
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
	 * S/C Exception Version를 삭제상태로 수정 합니다. <br>
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
	 * 선택한 Tariff Type 에 맞는 Calculation Type 이 존재하는지 조회 합니다. <br>
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
	 * 선택한 Tariff Type 에 맞는 Dual Type 이 존재하는지 조회 합니다. <br>
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
	 * BKG POR(O) or DEL(I) 의 입력된 CN 의 Continent 와 Coverage CN 의 Continent 가 동일한지 조회 합니다.<br>
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
	 * S/C 가 Filed Status 인지를 조회 합니다.<br>
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
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param SCExceptionVersionVO sCExceptionVersionVO
	 * @exception EventException
	 */
	public void modifyVersionSTS(SCExceptionVersionVO sCExceptionVersionVO) throws EventException {
		try {
			
			//S/C 에서 Filed 요청일 경우 현재 상태가 'Accepted' 가 아니면 반환한다.
			if ("File".equals(sCExceptionVersionVO.getCaller())) {
				String scExptVerSeq = sCDBDao.searchScExptVerSeq(sCExceptionVersionVO);
				sCExceptionVersionVO.setScExptVerSeq(scExptVerSeq);
				if (!sCDBDao.isAcceptedVersionSTS(sCExceptionVersionVO)) {
					return;
				}
			}
			
			//버전의 상태를 변경한다.
			sCDBDao.modifyVersionSTS(sCExceptionVersionVO);
			//상태를 변경한 로그를 기록한다.
			sCDBDao.addSCExceptionVersionProg(sCExceptionVersionVO);
			
			//만일 상태가 Live 로 변경될 경우, 이하버전의 Live 상태는 모두 Deleted 상태로 변경한다.
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
	 * S/C, RFA Exception를 조회 합니다. <br>
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
	 * Proposal No. 에 해당되는 SC No.와 Customer Code, Customer Name을 조회 합니다. <br>
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
	 * Proposal No 의 S/C Duration 데이터를 조회한다. <br>
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
	 * S/C Exception Tariff 를 Accept, Accept Cancel 할 수 있는 권한이 있는지를 조회한다.
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
	 * Affiliate Customer 를 조회한다. <br>
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
	 * Customer Type 이 'Affiliate' 인지를 조회 합니다.<br>
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
	 * Customer 가 S/C Customer 인지 조회 합니다. <br>
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
	 * Prop No. 에 해당하는 S/C Exception를 조회 합니다. <br>
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
	 * Customer Code 에 해당하는 S/C Exception를 조회 합니다. <br>
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
	 * 선택한 S/C Exception Tariff 와 그 하위항목을 모두 삭제 합니다.<br>
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
			
			//S/C Exception Tariff 의 Version 에 포함된 Group 정보가 존재하는지 조회 합니다.
			if (!sCDBDao.existSCException(sCExceptionParmVO)) {
				//S/C Exception Tariff 의 Group 정보가 모두 삭제되었다면 Version Prog 정보를 모두 삭제 합니다.
				sCDBDao.removeSCExceptionVersionProg(sCExceptionParmVO);
				//S/C Exception Tariff 의 Group 정보가 모두 삭제되었다면 Version 정보를 삭제 합니다.
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
	 * Update 버튼 클릭시 'Live'상태의 S/C Exception Tariff 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByUpdate(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			//1.신규 버전 정보를 조회한다.
			String 					versionSeq 				= sCDBDao.searchSCExceptionVersionSeq(sCExceptionParmVO.getPropNo());

			//2.Version, Version Prog 정보를 생성하기 위한 Version 객체를 생성 합니다.
			SCExceptionVersionVO	sCExceptionVersionVO	= new SCExceptionVersionVO();
			
			sCExceptionVersionVO.setPropNo(				sCExceptionParmVO.getPropNo()			);
			sCExceptionVersionVO.setScExptVerSeq(		versionSeq								);
			sCExceptionVersionVO.setCreUsrId(			sCExceptionParmVO.getCreUsrId()			);
			sCExceptionVersionVO.setCreOfcCd(			sCExceptionParmVO.getCreOfcCd()			);
			sCExceptionVersionVO.setDmdtExptVerStsCd(	sCExceptionParmVO.getDmdtExptVerStsCd()	);

			//2-1.S/C Exception Tariff 에 신규 채번된 Version Seq. 를 설정 합니다.
			sCExceptionParmVO.setScExptVerSeq(			versionSeq								);
			
			//3.신규 버전에 대한 정보를 'Temp' 상태로 Version 에 생성 합니다.
			sCDBDao.addSCExceptionVersion(sCExceptionVersionVO);
			
			//4.신규 버전에 대한 정보를 'Temp' 상태로 Version Prog 에 생성 합니다.
			sCDBDao.addSCExceptionVersionProg(sCExceptionVersionVO);
			
			//5.이전 버전의 모든 S/C Exception Tariff Group 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionGroupOfPrevVersion(sCExceptionParmVO);
			
			//6.이전 버전의 모든 S/C Exception Tariff Multi Coverage 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionCoverageOfPrevVersion(sCExceptionParmVO);
			
			//7.이전 버전의 모든 S/C Exception Tariff Free Time 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionFreeTimeOfPrevVersion(sCExceptionParmVO);
			
			//8.이전 버전의 모든 S/C Exception Tariff Rate Adjustment 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionRateAdjustmentOfPrevVersion(sCExceptionParmVO);
			
			//9.이전 버전의 모든 S/C Exception Tariff Customer 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionCustomerOfPrevVersion(sCExceptionParmVO);
			
			//10.이전 버전의 모든 S/C Exception Tariff Commodity 정보를 신규 버전으로 생성 합니다.
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
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 S/C Exception Tariff History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByHistoryCopy(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			//1.Version, Version Prog 정보를 생성하기 위한 Version 객체를 생성 합니다.
			SCExceptionVersionVO	sCExceptionVersionVO	= new SCExceptionVersionVO();
			SCExceptionDeleteVO		sCExceptionDeleteVO		= null;
			
			sCExceptionVersionVO.setPropNo(				sCExceptionParmVO.getPropNo()			);
			sCExceptionVersionVO.setScExptVerSeq(		sCExceptionParmVO.getScExptVerSeq()		);
			sCExceptionVersionVO.setCreUsrId(			sCExceptionParmVO.getCreUsrId()			);
			sCExceptionVersionVO.setCreOfcCd(			sCExceptionParmVO.getCreOfcCd()			);
			sCExceptionVersionVO.setUpdUsrId(			sCExceptionParmVO.getUpdUsrId()			);
			sCExceptionVersionVO.setUpdOfcCd(			sCExceptionParmVO.getUpdOfcCd()			);
			sCExceptionVersionVO.setDmdtExptVerStsCd(	sCExceptionParmVO.getDmdtExptVerStsCd()	);
			
			//현재 버전의 S/C Exception Tariff 정보가 있다면 삭제 합니다.
			if (sCDBDao.existSCException(sCExceptionParmVO)) {
				sCExceptionDeleteVO = new SCExceptionDeleteVO();
				sCExceptionDeleteVO.setDelPropNo(			sCExceptionParmVO.getPropNo()		);
				sCExceptionDeleteVO.setDelScExptVerSeq(		sCExceptionParmVO.getScExptVerSeq()	);
				
				sCDBDao.removeSCExceptionByPropVerNo(sCExceptionDeleteVO);
			}
			
			//2.현재 버전의 상태를 'Temp.Saved' 로 수정 합니다.
			if (!sCDBDao.existSCExceptionVersion(sCExceptionVersionVO)) {
				//Version 정보가 없으면 생성 합니다.
				sCDBDao.addSCExceptionVersion(sCExceptionVersionVO);
			}
			else {
				//Version 정보가 있다면, 상태를 'Temp.Saved' 으로 Version 의 상태를 갱신한다.
				sCDBDao.modifyVersionSTS(sCExceptionVersionVO);
			}
			
			//3.현재 버전에 대한 정보를 'Temp.Saved' 상태로 Version Prog 에 생성 합니다.
			if (sCDBDao.isTempSavedStatusOfLastVersionProg(sCExceptionVersionVO)) {
				sCDBDao.modifyLastVersionProg(sCExceptionVersionVO);
			}
			else {
				sCDBDao.addSCExceptionVersionProg(sCExceptionVersionVO);
			}			
			
			//4.이전 버전의 모든 S/C Exception Tariff Group 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionGroupOfHistVersion(sCExceptionParmVO);
			
			//5.이전 버전의 모든 S/C Exception Tariff Multi Coverage 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionCoverageOfHistVersion(sCExceptionParmVO);
			
			//6.이전 버전의 모든 S/C Exception Tariff Free Time 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionFreeTimeOfHistVersion(sCExceptionParmVO);
			
			//7.이전 버전의 모든 S/C Exception Tariff Rate Adjustment 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionRateAdjustmentOfHistVersion(sCExceptionParmVO);
			
			//8.이전 버전의 모든 S/C Exception Tariff Customer 정보를 신규 버전으로 생성 합니다.
			sCDBDao.addSCExceptionCustomerOfHistVersion(sCExceptionParmVO);
			
			//9.이전 버전의 모든 S/C Exception Tariff Commodity 정보를 신규 버전으로 생성 합니다.
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
	 * 화면에서 입력한 S/C 정보와 기등록된 S/C 정보중 중복된 데이터가 있는지 조회 합니다.<br>
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
	 * PRI_SP_CTRT_PTY에 동일한 Customer가 존재하는지 조회합니다.<br>
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

	/**
	 * SC Exception PFMC를 조회합니다.<br>
	 * 
	 * @param SCExceptionPfmcVO scExceptionPfmcVO
	 * @return List<SCExceptionPfmcVO>
	 * @exception EventException
	 */
	public List<SCExceptionPfmcVO> searchSCExceptionPFMC(SCExceptionPfmcVO scExceptionPfmcVO) throws EventException {
		try {
			return sCDBDao.searchScExptPfmc(scExceptionPfmcVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}

	/**
	 * SC Exception MAS를 조회합니다.<br>
	 * 
	 * @param SCExceptionMasVO scExceptionMasVO
	 * @return List<SCExceptionMasVO>
	 * @exception EventException
	 */
	public List<SCExceptionMasVO> searchSCExceptionMAS(SCExceptionMasVO scExceptionMasVO) throws EventException {
		try {
			return sCDBDao.searchScExptMas(scExceptionMasVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}

	/**
	 * Proposal No. 에 해당되는 Cust Type Code 을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchSCNoCustTpCdProposalNo(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return sCDBDao.searchSCNoCustTpCdProposalNo(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}