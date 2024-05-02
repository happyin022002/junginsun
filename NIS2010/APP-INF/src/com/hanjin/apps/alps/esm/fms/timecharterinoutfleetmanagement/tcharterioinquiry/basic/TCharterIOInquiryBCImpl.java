/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInquiryBCImpl.java
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.26 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic;


import java.util.ArrayList;
import java.util.List;

import weblogic.auddi.util.Logger;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration.TCharterIOInquiryDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountSumListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchRfStatusListVO;

/**
 * NIS2010-TimeCharterInOutFleetManagement Business Logic Basic Command implementation<br>
 * - NIS2010-TimeCharterInOutFleetManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0060EventResponse,TCharterIOInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TCharterIOInquiryBCImpl extends BasicCommandSupport implements TCharterIOInquiryBC {

	// Database Access Object
	private transient TCharterIOInquiryDBDAO dbDao = null;

	/**
	 * TCharterIOInquiryBCImpl 객체 생성<br>
	 * TCharterIOInquiryDBDAO를 생성한다.<br>
	 */
	public TCharterIOInquiryBCImpl() {
		dbDao = new TCharterIOInquiryDBDAO();
	}
	
	/**
	 * 선박 현황을 조회한다<br>
	 * 
	 * @param condSearchFleetStatusVO CondSearchFleetStatusVO
	 * @return List<SearchFleetStatusListVO>
	 * @exception EventException
	 */
	public List<SearchFleetStatusListVO> searchFleetStatusList(CondSearchFleetStatusVO condSearchFleetStatusVO) throws EventException {
		try {
			condSearchFleetStatusVO.setVslSize1(condSearchFleetStatusVO.getVslSize1().replaceAll(",", ""));
			condSearchFleetStatusVO.setVslSize2(condSearchFleetStatusVO.getVslSize2().replaceAll(",", ""));
			return dbDao.searchFleetStatusList(condSearchFleetStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01602",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01602",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 선박 현황을 Currency 별로 Hire 금액을 산출한다<br>
	 * 
	 * @param condSearchFleetStatusSumVO CondSearchFleetStatusSumVO
	 * @return List<SearchFleetStatusSumListVO>
	 * @exception EventException
	 */
	public List<SearchFleetStatusSumListVO> searchFleetStatusSumList(CondSearchFleetStatusSumVO condSearchFleetStatusSumVO) throws EventException {
		try {
			condSearchFleetStatusSumVO.setVslSize1(condSearchFleetStatusSumVO.getVslSize1().replaceAll(",", ""));
			condSearchFleetStatusSumVO.setVslSize2(condSearchFleetStatusSumVO.getVslSize2().replaceAll(",", ""));
			return dbDao.searchFleetStatusSumList(condSearchFleetStatusSumVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01602",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01602",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 선박 용/대선 시작 이후 집행된 정산 요건에 대한 전체 정리 및 회차 별 개별 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountListVO>
	 * @exception EventException
	 */
	public List<SearchStatementOfAccountListVO> searchStatementOfAccountList(String fletCtrtNo, String hirNo) throws EventException {
		try {
			return dbDao.searchStatementOfAccountList(fletCtrtNo, hirNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01601",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01601",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 선박 용/대선 시작 이후 집행된 정산 요건에 대한 전체 정리 및 회차 별 통화별로 합계 금액을 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountSumListVO>
	 * @exception EventException
	 */
	public List<SearchStatementOfAccountSumListVO> searchStatementOfAccountSumList(String fletCtrtNo, String hirNo) throws EventException {
		try {
			return dbDao.searchStatementOfAccountSumList(fletCtrtNo, hirNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01601",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01601",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Capital Budget 자료를 조회한다<br>
	 * 
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchCapitalBudgetListVO>
	 * @exception EventException
	 */
	public List<SearchCapitalBudgetListVO> searchCapitalBudgetList(String effDt, String expDt, String vslCd) throws EventException {
		try {
			effDt = JSPUtil.removeCharacter(effDt,"-");
			expDt = JSPUtil.removeCharacter(expDt,"-");
			
			return dbDao.searchCapitalBudgetList(effDt, expDt, vslCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 통화별 Total 금액 조회한다<br>
	 * 
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchCapitalBudgetSumListVO>
	 * @exception EventException
	 */
	public List<SearchCapitalBudgetSumListVO> searchCapitalBudgetSumList(String effDt, String expDt, String vslCd) throws EventException {
		try {
			effDt = JSPUtil.removeCharacter(effDt,"-");
			expDt = JSPUtil.removeCharacter(expDt,"-");
			
			return dbDao.searchCapitalBudgetSumList(effDt, expDt, vslCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * VVD로 RF 상태를 요약 조회한다.  <br>
	 * 
	 * @param vvd String
	 * @return List<SearchRfStatusListVO>
	 * @exception EventException
	 */
	public List<SearchRfStatusListVO> searchRfStatusInquiryByVvdSummaryList(String vvd) throws EventException {
		List<SearchRfStatusListVO> searchRfStatusListVO  = null; 
		try {
			String port = "";			
			String indicator = "";
			String preplantype = ""; // 이전 Plan Type
			String discharging = "";
			String celltocell = "";
			searchRfStatusListVO  = dbDao.searchRfStatusInquiryByVvdSummaryList(vvd);
			
			for(int i=0; i<searchRfStatusListVO.size(); i++){
				port = searchRfStatusListVO.get(i).getPort();
				indicator = searchRfStatusListVO.get(i).getIndicator();
				preplantype = searchRfStatusListVO.get(i).getPreplantype();
				
				discharging = dbDao.searchRfStatusInquiryByVvdSummaryDischarging(vvd, port, indicator, preplantype);
				celltocell = dbDao.searchRfStatusInquiryByVvdSummaryCellToCell(vvd, port, indicator, preplantype);
				
				if(discharging == null || "".equals(discharging)) discharging = "0";								
				if(celltocell == null || "".equals(celltocell))  celltocell = "0";				
				
				searchRfStatusListVO.get(i).setDischarging(discharging);
				searchRfStatusListVO.get(i).setCelltocell(celltocell);				
			}			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		}
		
		return searchRfStatusListVO;
	}	
	
	/**
	 * VVD로 RF 상태를 상세 조회한다.<br>
	 * 
	 * @param vvd String
	 * @return List<SearchRfStatusListVO>
	 * @exception EventException
	 */
	public List<SearchRfStatusListVO> searchRfStatusInquiryByVvdDetailList(String vvd) throws EventException {
		List<SearchRfStatusListVO> searchRfStatusList = new ArrayList<SearchRfStatusListVO>(); 		
		try { 				
			List<SearchRfStatusListVO> listLoading = null;			// Loading
			List<SearchRfStatusListVO> listDischarging = null;		//	Discharging
			List<SearchRfStatusListVO> listKind = null;					// Cell To Cell 
			
			String[] portCdList = dbDao.searchRfStatusPortCd(vvd);		// Port
			listLoading = dbDao.searchRfStatusInquiryByVvdDetailListLoading(vvd, "");
			searchRfStatusList.addAll(listLoading);			
			
			for(int i=0; i<portCdList.length; i=i+4){
				log.debug("Port - portCdList[i] = "+portCdList[i]);
				log.debug("Indicator - portCdList[i+1] = "+portCdList[i+1]);
				log.debug("Yard - portCdList[i+2] = "+portCdList[i+2]);		
				log.debug("Pre Plan Type - portCdList[i+3] = "+portCdList[i+3]);				
				
				listDischarging = dbDao.searchRfStatusInquiryByVvdDetailListDischarging(vvd, portCdList[i], portCdList[i+1], portCdList[i+2], portCdList[i+3]);
					
				log.debug("listDischarging.size() = "+listDischarging.size());
				
				if(listDischarging.size() > 0){
					searchRfStatusList.addAll(listDischarging);
				}
			}
							
			for(int i=0; i<portCdList.length; i=i+4){				
				log.debug("Port - portCdList[i] = "+portCdList[i]);
				log.debug("Indicator - portCdList[i+1] = "+portCdList[i+1]);
				log.debug("Yard - portCdList[i+2] = "+portCdList[i+2]);				
				log.debug("Pre Plan Type - portCdList[i+3] = "+portCdList[i+3]);				
				
				listKind = dbDao.searchRfStatusInquiryByVvdDetailListKind(vvd, portCdList[i], portCdList[i+1], portCdList[i+2], portCdList[i+3]);
					
				log.debug("listKind.size() = "+listKind.size());				
				if(listKind.size() > 0){
					searchRfStatusList.addAll(listKind);
				}
			}	
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		}
		return searchRfStatusList;
	}			
}