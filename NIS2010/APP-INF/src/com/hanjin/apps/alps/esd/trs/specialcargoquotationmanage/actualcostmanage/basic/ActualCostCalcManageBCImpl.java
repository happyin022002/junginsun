/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCostCalcManageBCImpl.java
*@FileTitle : TRS의 Actual 비용 산출
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-04-22 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.basic;


import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.integration.ActualCostCalcManageDBDAO;

import com.hanjin.syscommon.common.table.TrsActCostHdrVO;
import com.hanjin.syscommon.common.table.TrsActCostDtlVO;
import com.hanjin.syscommon.common.table.TrsActCostTpSzVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see ActualCostCalcManageBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ActualCostCalcManageBCImpl extends BasicCommandSupport implements ActualCostCalcManageBC {

	/**
	 * Actual Cost Calc 처리용 DBDAO
	 */
	private transient ActualCostCalcManageDBDAO actCostCalcDbDao = null;
	
	public ActualCostCalcManageBCImpl(){
		this.actCostCalcDbDao = new ActualCostCalcManageDBDAO();
	}

	/**
	 * 초기화
	 * @param eventResponse
	 * @throws EventException
	 */
	public void initCalcActualCOST(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - ActualCostCalcManageBCImpl - initCalcActualCOST ~~~~~ \n");
		
		TrsActCostHdrVO actCostHdrVO = null;
		String actCostHdrSeq = null;
		String retval = null;
		
		try {
			actCostHdrVO = new TrsActCostHdrVO();
			if (actCostHdrVO!=null){
				actCostHdrSeq = getActCostSeq();
				log.error("\n @@@@ actCostHdrSeq : "+JSPUtil.getNull(actCostHdrSeq)+" <<<~~~~~~~~~~~\n");
				if (actCostHdrSeq!=null && !actCostHdrSeq.trim().equals("")){
					actCostHdrVO.setTrspActCostSeq(actCostHdrSeq);
					actCostHdrVO.setExeStsCd("N");
					actCostHdrVO.setCalcTpCd("A");

					/** 저장 및 상태 초기화 **/
					retval = saveActCostCalcHdr(actCostHdrVO);
					log.error("\n @@@@ saveActCostCalcHdr.retval : "+JSPUtil.getNull(retval)+" ~~~~~~~~~~~\n");
					if (!(retval!=null && retval.trim().equals("Y"))){
						throw new Exception("\n ActualCostCalcManageBCImpl - initCalcActualCOST  : SAVING HDR FAILURE!!! \n ");
					}
				}
			}
			eventResponse.setCustomData(ACT_COST_HDR, actCostHdrVO);
			
		} catch(EventException ee){
			if (actCostHdrVO!=null){
				try {
					actCostHdrVO.setErrRmk(ee.getMessage());
					logActCostCalcErrMsg(actCostHdrVO);
				} catch (EventException ec) {
					log.error("\n ActualCostCalcManageBCImpl.initCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw ec;
				} catch (Exception ec) {
					log.error("\n ActualCostCalcManageBCImpl.initCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw new EventException(ee.getMessage());
				}
			}
			throw ee;
		} catch(Exception ex){
			if (actCostHdrVO!=null){
				try {
					actCostHdrVO.setErrRmk(ex.getMessage());
					logActCostCalcErrMsg(actCostHdrVO);
				} catch (EventException ec) {
					log.error("\n ActualCostCalcManageBCImpl.initCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw ec;
				} catch (Exception ec) {
					log.error("\n ActualCostCalcManageBCImpl.initCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw new EventException(ec.getMessage());
				}
			}
			throw new EventException(ex.getMessage());
		}
		log.debug("\n EEEEE - ActualCostCalcManageBCImpl - initCalcActualCOST ~~~~~ \n");
	}
	
	/**
	 * Actual Cost Calc (BASIC & T/S)
	 * @param eventResponse
	 * @throws EventException 
	 */
	public void calcActualCOST(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - ActualCostCalcManageBCImpl - calcActualCOST ~~~~~ \n");
		
		TrsActCostHdrVO actCostHdrVO = eventResponse!=null?(TrsActCostHdrVO)((GeneralEventResponse)eventResponse).getCustomData(ACT_COST_HDR):null;
		DBRowSet rowset = null;
		
		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTrspActCostSeq()!=null && !actCostHdrVO.getTrspActCostSeq().trim().equals("")){
					rowset = getActCostCalc(actCostHdrVO);
					eventResponse.setCustomData(ACT_COST_CALC_RESULT, rowset);
				} else {
					throw new Exception("\n\n ActualCostCalcManageBCImpl - calcActualCOST : TmlActCostSeq NULL EXCEPTION~~~~~~~~~~~~~~~~~~~ \n\n");
				}
			} else {
				throw new Exception("\n\n ActualCostCalcManageBCImpl - calcActualCOST : actCostHdrVO NULL EXCEPTION~~~~~~~~~~~~~~~~~~~ \n\n");
			}
		} catch(EventException ee){
			if (actCostHdrVO!=null){
				try {
					actCostHdrVO.setErrRmk(ee.getMessage());
					logActCostCalcErrMsg(actCostHdrVO);
				} catch (EventException ec) {
					log.error("\n ActualCostCalcManageBCImpl.calcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw ec;
				} catch (Exception ec) {
					log.error("\n ActualCostCalcManageBCImpl.calcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw new EventException(ec.getMessage());
				}
			}
			throw ee;
		} catch(Exception ex){
			if (actCostHdrVO!=null){
				try {
					actCostHdrVO.setErrRmk(ex.getMessage());
					logActCostCalcErrMsg(actCostHdrVO);
				} catch (EventException ec) {
					log.error("\n ActualCostCalcManageBCImpl.calcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw ec;
				} catch (Exception ec) {
					log.error("\n ActualCostCalcManageBCImpl.calcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw new EventException(ec.getMessage());
				}
			}
			throw new EventException(ex.getMessage());
		}
		log.debug("\n EEEEE - ActualCostCalcManageBCImpl - calcActualCOST ~~~~~ \n");
	}
	
	/**
	 * Actual Cost Calc 저장
	 * @param eventResponse
	 * @throws EventException 
	 */
	public void saveCalcActualCOST(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - ActualCostCalcManageBCImpl - saveCalcActualCOST ~~~~~ \n");
		
		TrsActCostHdrVO actCostHdrVO = eventResponse!=null?(TrsActCostHdrVO)((GeneralEventResponse)eventResponse).getCustomData(ACT_COST_HDR):null;
		DBRowSet rowset = eventResponse!=null?(DBRowSet)((GeneralEventResponse)eventResponse).getCustomData(ACT_COST_CALC_RESULT):null;
		TrsActCostDtlVO actCostDtlVO = null;
		TrsActCostTpSzVO actCostTpSzVO = null;
		List<TrsActCostDtlVO> actCostDtlVOLst = null;
		List<TrsActCostTpSzVO> actCostTpSzVOLst = null;		
		
		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTrspActCostSeq()!=null && !actCostHdrVO.getTrspActCostSeq().trim().equals("")){
					if (rowset!=null){
						
						/* DTL */
						actCostDtlVOLst = new ArrayList<TrsActCostDtlVO>();
						actCostTpSzVOLst = new ArrayList<TrsActCostTpSzVO>();
						while (rowset.next()){
							actCostDtlVO = new TrsActCostDtlVO();
							actCostDtlVO.setTrspActCostSeq(JSPUtil.getNull(actCostHdrVO.getTrspActCostSeq()));
							actCostDtlVO.setFmYdCd(JSPUtil.getNull(rowset.getString("FM_YD_CD")));
							actCostDtlVO.setToYdCd(JSPUtil.getNull(rowset.getString("TO_YD_CD")));
							actCostDtlVO.setTrspAwkCgoTrfTpCd(JSPUtil.getNull(rowset.getString("TRSP_AWK_CGO_TRF_TP_CD")));
							actCostDtlVO.setIoGaCd(JSPUtil.getNull(rowset.getString("IO_GA_CD")));
							actCostDtlVO.setTrspCrrModCd(JSPUtil.getNull(rowset.getString("TRSP_CRR_MOD_CD")));
							actCostDtlVOLst.add(actCostDtlVO);
						}
						
						/* TPSZ */
						if (actCostDtlVOLst!=null && actCostDtlVOLst.size()>0){
							/** <중> rowset을 반드시 첨으로 돌려야 제대로 DATA가 나온다. **/
							rowset.beforeFirst();
							while (rowset.next()){
								/* 20ft */
								actCostTpSzVO = new TrsActCostTpSzVO();
								actCostTpSzVO.setCntrSzCd(ACT_COST_CNTR_TP_20FT);
								actCostTpSzVO.setUsdAmt(JSPUtil.getNull(rowset.getString("ACTUAL_2OFT_AMT")));
								actCostTpSzVO.setTrspActCostSeq(JSPUtil.getNull(actCostHdrVO.getTrspActCostSeq()));
								actCostTpSzVO.setFmYdCd(JSPUtil.getNull(rowset.getString("FM_YD_CD")));
								actCostTpSzVO.setToYdCd(JSPUtil.getNull(rowset.getString("TO_YD_CD")));
								actCostTpSzVO.setTrspAwkCgoTrfTpCd(JSPUtil.getNull(rowset.getString("TRSP_AWK_CGO_TRF_TP_CD")));
								actCostTpSzVO.setIoGaCd(JSPUtil.getNull(rowset.getString("IO_GA_CD")));
								actCostTpSzVO.setTrspCrrModCd(JSPUtil.getNull(rowset.getString("TRSP_CRR_MOD_CD")));
								actCostTpSzVOLst.add(actCostTpSzVO);

								/* 40ft */
								actCostTpSzVO = new TrsActCostTpSzVO();
								actCostTpSzVO.setCntrSzCd(ACT_COST_CNTR_TP_40FT);
								actCostTpSzVO.setUsdAmt(JSPUtil.getNull(rowset.getString("ACTUAL_4OFT_AMT")));
								actCostTpSzVO.setTrspActCostSeq(JSPUtil.getNull(actCostHdrVO.getTrspActCostSeq()));
								actCostTpSzVO.setFmYdCd(JSPUtil.getNull(rowset.getString("FM_YD_CD")));
								actCostTpSzVO.setToYdCd(JSPUtil.getNull(rowset.getString("TO_YD_CD")));
								actCostTpSzVO.setTrspAwkCgoTrfTpCd(JSPUtil.getNull(rowset.getString("TRSP_AWK_CGO_TRF_TP_CD")));
								actCostTpSzVO.setIoGaCd(JSPUtil.getNull(rowset.getString("IO_GA_CD")));
								actCostTpSzVO.setTrspCrrModCd(JSPUtil.getNull(rowset.getString("TRSP_CRR_MOD_CD")));
								actCostTpSzVOLst.add(actCostTpSzVO);
							}
						}
						log.debug("\n actCostDtlVOLst.size : "+(actCostDtlVOLst!=null?actCostDtlVOLst.size():0)+" +++++++++++++++++++++++ \n");
						log.debug("\n actCostTpSzVOLst.size : "+(actCostTpSzVOLst!=null?actCostTpSzVOLst.size():0)+" +++++++++++++++++++++++ \n");
						saveActCostCalcDtlTpSz(actCostDtlVOLst, actCostTpSzVOLst);
					
					} else {
						throw new Exception("\n\n ActualCostCalcManageBCImpl - saveCalcActualCOST : rowset NULL~~~~~~~~~~~~~~~~~~~ \n\n");
					}
				} else {
					throw new Exception("\n\n ActualCostCalcManageBCImpl - saveCalcActualCOST : TmlActCostSeq NULL EXCEPTION~~~~~~~~~~~~~~~~~~~ \n\n");
				}
			} else {
				throw new Exception("\n\n ActualCostCalcManageBCImpl - saveCalcActualCOST : actCostHdrVO NULL EXCEPTION~~~~~~~~~~~~~~~~~~~ \n\n");
			}
		} catch(EventException ee){
			if (actCostHdrVO!=null){
				try {
					actCostHdrVO.setErrRmk(ee.getMessage());
					logActCostCalcErrMsg(actCostHdrVO);
				} catch (EventException ec) {
					log.error("\n ActualCostCalcManageBCImpl.saveCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw ec;
				} catch (Exception ec) {
					log.error("\n ActualCostCalcManageBCImpl.saveCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw new EventException(ec.getMessage());
				}
			}
			throw ee;
		} catch(Exception ex){
			if (actCostHdrVO!=null){
				try {
					actCostHdrVO.setErrRmk(ex.getMessage());
					logActCostCalcErrMsg(actCostHdrVO);
				} catch (EventException ec) {
					log.error("\n ActualCostCalcManageBCImpl.saveCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw ec;
				} catch (Exception ec) {
					log.error("\n ActualCostCalcManageBCImpl.saveCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw new EventException(ec.getMessage());
				}
			}
			throw new EventException(ex.getMessage());
		}
		log.debug("\n EEEEE - ActualCostCalcManageBCImpl - saveCalcActualCOST ~~~~~ \n");
	}

	/**
	 * ACT COST CALC후 완료 표시하기
	 * @param eventResponse
	 * @throws EventException
	 */
	public void completeCalcActualCOST(EventResponse eventResponse) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - completeCalcActualCOST~~~~~BBBB \n");
		
		TrsActCostHdrVO actCostHdrVO = eventResponse!=null?(TrsActCostHdrVO)((GeneralEventResponse)eventResponse).getCustomData(ACT_COST_HDR):null;
		
		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTrspActCostSeq()!=null && !actCostHdrVO.getTrspActCostSeq().trim().equals("")){
					completeCalcActualCostSts(actCostHdrVO);
				} else {
					throw new Exception("\n\n ActualCostCalcManageBCImpl - completeCalcActualCOST : TmlActCostSeq NULL EXCEPTION~~~~~~~~~~~~~~~~~~~ \n\n");
				}
			} else {
				throw new Exception("\n\n ActualCostCalcManageBCImpl - completeCalcActualCOST : actCostHdrVO NULL EXCEPTION~~~~~~~~~~~~~~~~~~~ \n\n");
			}
		} catch(EventException ee){
			if (actCostHdrVO!=null){
				try {
					actCostHdrVO.setErrRmk(ee.getMessage());
					logActCostCalcErrMsg(actCostHdrVO);
				} catch (EventException ec) {
					log.error("\n ActualCostCalcManageBCImpl.completeCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw ec;
				} catch (Exception ec) {
					log.error("\n ActualCostCalcManageBCImpl.completeCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw new EventException(ec.getMessage());
				}
			}
			throw ee;
		} catch(Exception ex){
			if (actCostHdrVO!=null){
				try {
					actCostHdrVO.setErrRmk(ex.getMessage());
					logActCostCalcErrMsg(actCostHdrVO);
				} catch (EventException ec) {
					log.error("\n ActualCostCalcManageBCImpl.completeCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw ec;
				} catch (Exception ec) {
					log.error("\n ActualCostCalcManageBCImpl.completeCalcActualCOST - logActCostCalcErrMsg err: " + ec.toString(), ec);
					throw new EventException(ec.getMessage());
				}
			}
			throw new EventException(ex.getMessage());
		}	
		log.debug("\n  ActualCostCalcManageBCImpl - completeCalcActualCOST~~~~~EEEE \n");
	}

	/**
	 * ACT COST CALC후 완료 표시하기
	 * @param actCostHdrVO
	 * @throws EventException
	 */
	public void completeCalcActualCostSts(TrsActCostHdrVO actCostHdrVO) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - completeCalcActualCostSts~~~~~BBBB \n");
		
		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTrspActCostSeq()!=null && !actCostHdrVO.getTrspActCostSeq().trim().equals("")){
					actCostCalcDbDao.completeCalcActCost(actCostHdrVO);	
				} else {
					throw new Exception("\n\n ActualCostCalcManageBCImpl - completeCalcActualCOST : TmlActCostSeq NULL EXCEPTION~~~~~~~~~~~~~~~~~~~ \n\n");
				}
			} else {
				throw new Exception("\n\n ActualCostCalcManageBCImpl - completeCalcActualCOST : actCostHdrVO NULL EXCEPTION~~~~~~~~~~~~~~~~~~~ \n\n");
			}
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  ActualCostCalcManageBCImpl - completeCalcActualCostSts~~~~~EEEE \n");
	}

	
	/**
	 * ACT COST CALS 용 주 sequence 구하기
	 * @return String
	 * @throws EventException
	 */
	public String getActCostSeq() throws EventException {
		log.debug("\n ActualCostCalcManageBCImpl - getActCostSeq~~~~~ \n");

		try {
			return JSPUtil.getNull(actCostCalcDbDao.createActCostSeq());
		} catch(DAOException e){
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * ACT COST CALS T/S 조회
	 * @param actCostHdrVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet getActCostCalc(TrsActCostHdrVO actCostHdrVO) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - getActCostCalc ~~~~~BBBB \n");

		DBRowSet dbRowset = null;
		try {
			dbRowset = actCostCalcDbDao.getActCostCalc(actCostHdrVO);
		} catch(DAOException e){
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
		log.debug("\n  ActualCostCalcManageBCImpl - getActCostCalc ~~~~~EEEE \n");
		return dbRowset;
	}
	
	/**
	 * ACT COST CALS 대상 저장 및 초기화
	 * @param actCostHdrVO
	 * @return String
	 * @throws EventException
	 */
	public String saveActCostCalcHdr(TrsActCostHdrVO actCostHdrVO) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - saveActCostCalcHdr~~~~~BBBB \n");
		
		try {
			return actCostCalcDbDao.createActCostCalcHdr(actCostHdrVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * ACT COST CALS 대상 DTL과 TPSZ 정보 저장
	 * @param actCostDtlVOLst
	 * @param actCostTpSzVOLst
	 * @throws EventException
	 */
	public void saveActCostCalcDtlTpSz(List<TrsActCostDtlVO> actCostDtlVOLst, List<TrsActCostTpSzVO> actCostTpSzVOLst) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - saveActCostCalcDtlTpSz~~~~~BBBB \n");
		
		try {
			actCostCalcDbDao.createActCostCalcDtl(actCostDtlVOLst);
			actCostCalcDbDao.createActCostCalcTpSz(actCostTpSzVOLst);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  ActualCostCalcManageBCImpl - saveActCostCalcDtlTpSz~~~~~EEEE \n");
	}
	
	/**
	 * Actual Cost Calc Error 처리
	 * @param actCostHdrVO
	 * @throws EventException
	 */
	public void logActCostCalcErrMsg(TrsActCostHdrVO actCostHdrVO) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - logActCostCalcErrMsg~~~~~BBBB \n");

		try {
			if (actCostHdrVO!=null && !JSPUtil.getNull(actCostHdrVO.getTrspActCostSeq()).trim().equals("")){
				actCostCalcDbDao.logActCostCalcErrMsg(actCostHdrVO);	
			}
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
		
		log.debug("\n  ActualCostCalcManageBCImpl - logActCostCalcErrMsg~~~~~EEEE \n");
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * ActualCostCalcManageBCImpl 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		actCostCalcDbDao = null;
	}
}