/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCostCalcManageBCImpl.java
*@FileTitle : TES의 Actual 비용 산출
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-03-21 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.basic;


import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration.ActualCostCalcManageDBDAO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;

import com.hanjin.syscommon.common.table.TesActCostHdrVO;
import com.hanjin.syscommon.common.table.TesActCostDtlVO;
import com.hanjin.syscommon.common.table.TesActCostTpSzVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonTpSzVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfDtlVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfTpSzVO;

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
		
		TesActCostHdrVO actCostHdrVO = null;
		String actCostHdrSeq = null;
		String retval = null;
		
		try {
			actCostHdrVO = new TesActCostHdrVO();
			if (actCostHdrVO!=null){
				actCostHdrSeq = getActCostSeq();
				log.error("\n @@@@ actCostHdrSeq : "+JSPUtil.getNull(actCostHdrSeq)+" <<<~~~~~~~~~~~\n");
				if (actCostHdrSeq!=null && !actCostHdrSeq.trim().equals("")){
					actCostHdrVO.setTmlActCostSeq(actCostHdrSeq);
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
		
		TesActCostHdrVO actCostHdrVO = eventResponse!=null?(TesActCostHdrVO)((GeneralEventResponse)eventResponse).getCustomData(ACT_COST_HDR):null;
		DBRowSet rowset = null;
		
		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTmlActCostSeq()!=null && !actCostHdrVO.getTmlActCostSeq().trim().equals("")){
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
		
		TesActCostHdrVO actCostHdrVO = eventResponse!=null?(TesActCostHdrVO)((GeneralEventResponse)eventResponse).getCustomData(ACT_COST_HDR):null;
		DBRowSet rowset = eventResponse!=null?(DBRowSet)((GeneralEventResponse)eventResponse).getCustomData(ACT_COST_CALC_RESULT):null;
		TesActCostDtlVO actCostDtlVO = null;
		TesActCostTpSzVO actCostTpSzVO = null;
		List<TesActCostDtlVO> actCostDtlVOLst = null;
		List<TesActCostTpSzVO> actCostTpSzVOLst = null;		
		
		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTmlActCostSeq()!=null && !actCostHdrVO.getTmlActCostSeq().trim().equals("")){
					if (rowset!=null){
						
						/* DTL */
						actCostDtlVOLst = new ArrayList<TesActCostDtlVO>();
						actCostTpSzVOLst = new ArrayList<TesActCostTpSzVO>();
						while (rowset.next()){
							actCostDtlVO = new TesActCostDtlVO();
							actCostDtlVO.setTmlActCostSeq(JSPUtil.getNull(actCostHdrVO.getTmlActCostSeq()));
							actCostDtlVO.setYdCd(JSPUtil.getNull(rowset.getString("YD_CD")));
							actCostDtlVO.setTmlAwkCgoTrfTpCd(JSPUtil.getNull(rowset.getString("TML_AWK_CGO_TRF_TP_CD")));
							actCostDtlVO.setIoBndCd(JSPUtil.getNull(rowset.getString("IO_BND_CD")));
							actCostDtlVO.setIoGaCd(JSPUtil.getNull(rowset.getString("IO_GA_CD")));
							actCostDtlVO.setTmlAwkTsCd(JSPUtil.getNull(rowset.getString("TML_AWK_TS_CD")));
							actCostDtlVOLst.add(actCostDtlVO);
						}
						
						/* TPSZ */
						if (actCostDtlVOLst!=null && actCostDtlVOLst.size()>0){
							/** <중> rowset을 반드시 첨으로 돌려야 제대로 DATA가 나온다. **/
							rowset.beforeFirst();
							while (rowset.next()){
								/* 20ft */
								actCostTpSzVO = new TesActCostTpSzVO();
								actCostTpSzVO.setCntrSzCd(ACT_COST_CNTR_TP_20FT);
								actCostTpSzVO.setUsdAmt(JSPUtil.getNull(rowset.getString("ACTUAL_2OFT_AMT")));
								actCostTpSzVO.setTmlActCostSeq(JSPUtil.getNull(actCostHdrVO.getTmlActCostSeq()));
								actCostTpSzVO.setYdCd(JSPUtil.getNull(rowset.getString("YD_CD")));
								actCostTpSzVO.setTmlAwkCgoTrfTpCd(JSPUtil.getNull(rowset.getString("TML_AWK_CGO_TRF_TP_CD")));
								actCostTpSzVO.setIoBndCd(JSPUtil.getNull(rowset.getString("IO_BND_CD")));
								actCostTpSzVO.setIoGaCd(JSPUtil.getNull(rowset.getString("IO_GA_CD")));
								actCostTpSzVO.setTmlAwkTsCd(JSPUtil.getNull(rowset.getString("TML_AWK_TS_CD")));
								actCostTpSzVOLst.add(actCostTpSzVO);

								/* 40ft */
								actCostTpSzVO = new TesActCostTpSzVO();
								actCostTpSzVO.setCntrSzCd(ACT_COST_CNTR_TP_40FT);
								actCostTpSzVO.setUsdAmt(JSPUtil.getNull(rowset.getString("ACTUAL_4OFT_AMT")));
								actCostTpSzVO.setTmlActCostSeq(JSPUtil.getNull(actCostHdrVO.getTmlActCostSeq()));
								actCostTpSzVO.setYdCd(JSPUtil.getNull(rowset.getString("YD_CD")));
								actCostTpSzVO.setTmlAwkCgoTrfTpCd(JSPUtil.getNull(rowset.getString("TML_AWK_CGO_TRF_TP_CD")));
								actCostTpSzVO.setIoBndCd(JSPUtil.getNull(rowset.getString("IO_BND_CD")));
								actCostTpSzVO.setIoGaCd(JSPUtil.getNull(rowset.getString("IO_GA_CD")));
								actCostTpSzVO.setTmlAwkTsCd(JSPUtil.getNull(rowset.getString("TML_AWK_TS_CD")));
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
		
		TesActCostHdrVO actCostHdrVO = eventResponse!=null?(TesActCostHdrVO)((GeneralEventResponse)eventResponse).getCustomData(ACT_COST_HDR):null;
		
		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTmlActCostSeq()!=null && !actCostHdrVO.getTmlActCostSeq().trim().equals("")){
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
	public void completeCalcActualCostSts(TesActCostHdrVO actCostHdrVO) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - completeCalcActualCostSts~~~~~BBBB \n");
		
		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTmlActCostSeq()!=null && !actCostHdrVO.getTmlActCostSeq().trim().equals("")){
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
	public DBRowSet getActCostCalc(TesActCostHdrVO actCostHdrVO) throws EventException {
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
	public String saveActCostCalcHdr(TesActCostHdrVO actCostHdrVO) throws EventException {
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
	public void saveActCostCalcDtlTpSz(List<TesActCostDtlVO> actCostDtlVOLst, List<TesActCostTpSzVO> actCostTpSzVOLst) throws EventException {
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
	public void logActCostCalcErrMsg(TesActCostHdrVO actCostHdrVO) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - logActCostCalcErrMsg~~~~~BBBB \n");

		try {
			if (actCostHdrVO!=null && !JSPUtil.getNull(actCostHdrVO.getTmlActCostSeq()).trim().equals("")){
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
	 * [BASIC] USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse manageAwkCgoBasicTrfToUpdateUSDAmt() throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<TesAwkCgoTrfMngVO> tesAwkCgoTrfMngVOList = null;
		TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO = null;
		
		List<TesAwkCgoTrfDtlVO> insUpdDtlList = new ArrayList<TesAwkCgoTrfDtlVO>();
		List<TesAwkCgoTrfTpSzVO> insUpdTpszList = new ArrayList<TesAwkCgoTrfTpSzVO>();
		
		String ver_no = null;
		
		try {
			tesAwkCgoTrfMngVOList = searchAwkCgoTrfToUpdateUSDAmt(ACT_COST_TRF_TP_BASIC);
			for (int i=0; tesAwkCgoTrfMngVOList!=null && i<tesAwkCgoTrfMngVOList.size(); i++){
				tesAwkCgoTrfMngVO = tesAwkCgoTrfMngVOList.get(i);
				if (tesAwkCgoTrfMngVO!=null){
					ver_no = getAwkCgoTrfUpdateVerNo(ACT_COST_TRF_TP_BASIC,tesAwkCgoTrfMngVO);
					log.debug("\n ### ver_no: "+JSPUtil.getNull(ver_no)+"------ \n");
					if (ver_no!=null && !ver_no.trim().equals("")){
						
						//dtl VO
						TesAwkCgoTrfDtlVO tesAwkCgoTrfDtlVO = new TesAwkCgoTrfDtlVO();
						tesAwkCgoTrfDtlVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
						tesAwkCgoTrfDtlVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
						tesAwkCgoTrfDtlVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
						tesAwkCgoTrfDtlVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
						tesAwkCgoTrfDtlVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
						tesAwkCgoTrfDtlVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
						tesAwkCgoTrfDtlVO.setTmlAwkTrfVerNo(ver_no);
						tesAwkCgoTrfDtlVO.setTmlActCostSeq(tesAwkCgoTrfMngVO.getTmlActCostSeq());
						tesAwkCgoTrfDtlVO.setAplyRto(tesAwkCgoTrfMngVO.getAplyRto());
						tesAwkCgoTrfDtlVO.setCalcRmk(tesAwkCgoTrfMngVO.getCalcRmk());
						tesAwkCgoTrfDtlVO.setLstUpdUsrId(tesAwkCgoTrfMngVO.getLstUpdUsrId());
						tesAwkCgoTrfDtlVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
						tesAwkCgoTrfDtlVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
						tesAwkCgoTrfDtlVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
						insUpdDtlList.add(tesAwkCgoTrfDtlVO);
						
						//tp_sz VO
						if (tesAwkCgoTrfMngVO.getManLoclAmt20ft()!=null && !tesAwkCgoTrfMngVO.getManLoclAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_MANUAL);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getManLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getManLoclAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getManUsdAmt20ft() );
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getManLoclAmt40ft()!=null && !tesAwkCgoTrfMngVO.getManLoclAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_MANUAL);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getManLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getManLoclAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getManUsdAmt40ft() );
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getAutoUsdAmt20ft()!=null && !tesAwkCgoTrfMngVO.getAutoUsdAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_AUTO);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getAutoUsdAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getAutoUsdAmt40ft()!=null && !tesAwkCgoTrfMngVO.getAutoUsdAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_AUTO);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getAutoUsdAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getTtlLoclAmt20ft()!=null && !tesAwkCgoTrfMngVO.getTtlLoclAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_TTLCOSTMANUAL);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getTtlLoclCurrCd() );
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getTtlLoclAmt20ft() );
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getTtlUsdAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getTtlLoclAmt40ft()!=null && !tesAwkCgoTrfMngVO.getTtlLoclAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_TTLCOSTMANUAL);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getTtlLoclCurrCd() );
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getTtlLoclAmt40ft() );
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getTtlUsdAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getFmlLoclAmt20ft()!=null && !tesAwkCgoTrfMngVO.getFmlLoclAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_FORMULA);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getFmlLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getFmlLoclAmt20ft() );
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getFmlUsdAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getFmlLoclAmt40ft()!=null && !tesAwkCgoTrfMngVO.getFmlLoclAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_FORMULA);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getFmlLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getFmlLoclAmt40ft() );
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getFmlUsdAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getCalcUsdAmt20ft()!=null && !tesAwkCgoTrfMngVO.getCalcUsdAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_CALC);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getCalcUsdAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getCalcUsdAmt40ft()!=null && !tesAwkCgoTrfMngVO.getCalcUsdAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_CALC);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getCalcUsdAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}

						if (tesAwkCgoTrfMngVO.getSumUsdAmt20ft()!=null && !tesAwkCgoTrfMngVO.getSumUsdAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_SUM);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getSumUsdAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getSumUsdAmt40ft()!=null && !tesAwkCgoTrfMngVO.getSumUsdAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_SUM);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getSumUsdAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}						
					} else {
						log.error("\n ## No Version No. found Exception!!!!!! \n");
						throw new EventException("\n ## No Version No. found Exception!!!!!! \n");
					}
				}
			}
			if (insUpdDtlList!=null && insUpdDtlList.size() > 0){
				modifyAwkCgoTrfToUpdateDtlVer(insUpdDtlList);
				if (insUpdTpszList!=null && insUpdTpszList.size() > 0){
					modifyAwkCgoTrfToUpdateTpSzVer(insUpdTpszList);	
				}
			}
		}catch(EventException ex){
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * [T/S] USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse manageAwkCgoTsTrfToUpdateUSDAmt() throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<TesAwkCgoTrfMngVO> tesAwkCgoTrfMngVOList = null;
		TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO = null;
		
		List<TesAwkCgoTrfDtlVO> insUpdDtlList = new ArrayList<TesAwkCgoTrfDtlVO>();
		List<TesAwkCgoTrfTpSzVO> insUpdTpszList = new ArrayList<TesAwkCgoTrfTpSzVO>();
		
		String ver_no = null;
		
		try {
			tesAwkCgoTrfMngVOList = searchAwkCgoTrfToUpdateUSDAmt(ACT_COST_TRF_TP_TS);
			for (int i=0; tesAwkCgoTrfMngVOList!=null && i<tesAwkCgoTrfMngVOList.size(); i++){
				tesAwkCgoTrfMngVO = tesAwkCgoTrfMngVOList.get(i);
				if (tesAwkCgoTrfMngVO!=null){
					ver_no = getAwkCgoTrfUpdateVerNo(ACT_COST_TRF_TP_TS,tesAwkCgoTrfMngVO);
					log.debug("\n ### ver_no: "+JSPUtil.getNull(ver_no)+"------ \n");
					if (ver_no!=null && !ver_no.trim().equals("")){
						
						//dtl VO
						TesAwkCgoTrfDtlVO tesAwkCgoTrfDtlVO = new TesAwkCgoTrfDtlVO();
						tesAwkCgoTrfDtlVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
						tesAwkCgoTrfDtlVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
						tesAwkCgoTrfDtlVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
						tesAwkCgoTrfDtlVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
						tesAwkCgoTrfDtlVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
						tesAwkCgoTrfDtlVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
						tesAwkCgoTrfDtlVO.setTmlAwkTrfVerNo(ver_no);
						tesAwkCgoTrfDtlVO.setTmlActCostSeq(tesAwkCgoTrfMngVO.getTmlActCostSeq());
						tesAwkCgoTrfDtlVO.setAplyRto(tesAwkCgoTrfMngVO.getAplyRto());
						tesAwkCgoTrfDtlVO.setCalcRmk(tesAwkCgoTrfMngVO.getCalcRmk());
						tesAwkCgoTrfDtlVO.setLstUpdUsrId(tesAwkCgoTrfMngVO.getLstUpdUsrId());
						tesAwkCgoTrfDtlVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
						tesAwkCgoTrfDtlVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
						tesAwkCgoTrfDtlVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
						insUpdDtlList.add(tesAwkCgoTrfDtlVO);
						
						//tp_sz VO
						if (tesAwkCgoTrfMngVO.getManLoclAmt20ft()!=null && !tesAwkCgoTrfMngVO.getManLoclAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_MANUAL);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getManLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getManLoclAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getManUsdAmt20ft() );
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getManLoclAmt40ft()!=null && !tesAwkCgoTrfMngVO.getManLoclAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_MANUAL);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getManLoclCurrCd());
							tesAwkCgoTrfTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getManLoclAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getManUsdAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getAutoUsdAmt20ft()!=null && !tesAwkCgoTrfMngVO.getAutoUsdAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_AUTO);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getAutoUsdAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getAutoUsdAmt40ft()!=null && !tesAwkCgoTrfMngVO.getAutoUsdAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_AUTO);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getAutoUsdAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getSumUsdAmt20ft()!=null && !tesAwkCgoTrfMngVO.getSumUsdAmt20ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_SUM);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_20FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getSumUsdAmt20ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
						if (tesAwkCgoTrfMngVO.getSumUsdAmt40ft()!=null && !tesAwkCgoTrfMngVO.getSumUsdAmt40ft().trim().equals("")){
							TesAwkCgoTrfTpSzVO tesAwkCgoTrfTpSzVO = new TesAwkCgoTrfTpSzVO();
							tesAwkCgoTrfTpSzVO.setYdCd(tesAwkCgoTrfMngVO.getYdCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkCgoTrfTpCd(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
							tesAwkCgoTrfTpSzVO.setIoBndCd(tesAwkCgoTrfMngVO.getIoBndCd());
							tesAwkCgoTrfTpSzVO.setIoGaCd(tesAwkCgoTrfMngVO.getIoGaCd());
							tesAwkCgoTrfTpSzVO.setTmlAwkTsCd(tesAwkCgoTrfMngVO.getTmlAwkTsCd());
							tesAwkCgoTrfTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
							tesAwkCgoTrfTpSzVO.setTmlAwkTrfVerNo(ver_no);
							tesAwkCgoTrfTpSzVO.setTmlAwkUcCalcTpCd(AWK_UC_CALC_TP_CD_SUM);
							tesAwkCgoTrfTpSzVO.setCntrTpszCd(ACT_COST_CNTR_TP_40FT);
							tesAwkCgoTrfTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getSumUsdAmt40ft());
							tesAwkCgoTrfTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
							tesAwkCgoTrfTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
							tesAwkCgoTrfTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
							tesAwkCgoTrfTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getUpdUsrId());
							insUpdTpszList.add(tesAwkCgoTrfTpSzVO);
						}
					} else {
						log.error("\n ## No Version No. found Exception!!!!!! \n");
						throw new EventException("\n ## No Version No. found Exception!!!!!! \n");
					}
				}
			}
			if (insUpdDtlList!=null && insUpdDtlList.size() > 0){
				modifyAwkCgoTrfToUpdateDtlVer(insUpdDtlList);
				if (insUpdTpszList!=null && insUpdTpszList.size() > 0){
					modifyAwkCgoTrfToUpdateTpSzVer(insUpdTpszList);	
				}
			}
		}catch(EventException ex){
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	
	/**
	 * [ADD-ON] USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse manageAwkCgoAddOnTrfToUpdateUSDAmt() throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<TesAwkCgoTrfMngVO> tesAwkCgoTrfMngVOList = null;
		TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO = null;
		
		List<TesAwkCgoAdonHdrVO> insUpdHdrList = new ArrayList<TesAwkCgoAdonHdrVO>();
		List<TesAwkCgoAdonTpSzVO> insUpdTpszList = new ArrayList<TesAwkCgoAdonTpSzVO>();
		
		String ver_no = null;
		
		try {
			tesAwkCgoTrfMngVOList = searchAwkCgoTrfToUpdateUSDAmt(ACT_COST_TRF_TP_ADDON);
			for (int i=0; tesAwkCgoTrfMngVOList!=null && i<tesAwkCgoTrfMngVOList.size(); i++){
				tesAwkCgoTrfMngVO = tesAwkCgoTrfMngVOList.get(i);
				if (tesAwkCgoTrfMngVO!=null){
					ver_no = getAwkCgoTrfUpdateVerNo(ACT_COST_TRF_TP_ADDON,tesAwkCgoTrfMngVO);
					log.debug("\n ### ver_no: "+JSPUtil.getNull(ver_no)+"------ \n");
					
					//dtl VO
					TesAwkCgoAdonHdrVO tesAwkCgoAdonHdrVO =  new TesAwkCgoAdonHdrVO();
					tesAwkCgoAdonHdrVO.setFmLocCd(tesAwkCgoTrfMngVO.getFmLocCd());
					tesAwkCgoAdonHdrVO.setFmNodYdNo(tesAwkCgoTrfMngVO.getFmNodYdNo());
					tesAwkCgoAdonHdrVO.setToLocCd(tesAwkCgoTrfMngVO.getToLocCd());
					tesAwkCgoAdonHdrVO.setToNodYdNo(tesAwkCgoTrfMngVO.getToNodYdNo());
					tesAwkCgoAdonHdrVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
					tesAwkCgoAdonHdrVO.setTmlAwkAdonVerNo(ver_no);
					tesAwkCgoAdonHdrVO.setVndrNm(tesAwkCgoTrfMngVO.getVndrNm());
					tesAwkCgoAdonHdrVO.setCalcRmk(tesAwkCgoTrfMngVO.getCalcRmk());
					tesAwkCgoAdonHdrVO.setLstUpdUsrId(tesAwkCgoTrfMngVO.getLstUpdUsrId());
					tesAwkCgoAdonHdrVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
					tesAwkCgoAdonHdrVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
					tesAwkCgoAdonHdrVO.setUpdUsrId(tesAwkCgoTrfMngVO.getLstUpdUsrId());
					insUpdHdrList.add(tesAwkCgoAdonHdrVO);
					
					//tp_sz VO
					if (tesAwkCgoTrfMngVO.getManUsdAmt20ft()!=null && !tesAwkCgoTrfMngVO.getManUsdAmt20ft().trim().equals("")){
						TesAwkCgoAdonTpSzVO tesAwkCgoAdonTpSzVO =  new TesAwkCgoAdonTpSzVO();
						tesAwkCgoAdonTpSzVO.setFmLocCd(tesAwkCgoTrfMngVO.getFmLocCd());
						tesAwkCgoAdonTpSzVO.setFmNodYdNo(tesAwkCgoTrfMngVO.getFmNodYdNo());
						tesAwkCgoAdonTpSzVO.setToLocCd(tesAwkCgoTrfMngVO.getToLocCd());
						tesAwkCgoAdonTpSzVO.setToNodYdNo(tesAwkCgoTrfMngVO.getToNodYdNo());
						tesAwkCgoAdonTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
						tesAwkCgoAdonTpSzVO.setTmlAwkAdonVerNo(ver_no);
						tesAwkCgoAdonTpSzVO.setCntrSzCd(ACT_COST_CNTR_TP_20FT);
						tesAwkCgoAdonTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getManUsdAmt20ft());
						tesAwkCgoAdonTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getLstUpdUsrId());
						tesAwkCgoAdonTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getManLoclCurrCd());
						tesAwkCgoAdonTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getManLoclAmt20ft());
						tesAwkCgoAdonTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
						tesAwkCgoAdonTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
						tesAwkCgoAdonTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
						tesAwkCgoAdonTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getLstUpdUsrId());
						insUpdTpszList.add(tesAwkCgoAdonTpSzVO);
					}
					if (tesAwkCgoTrfMngVO.getManUsdAmt40ft()!=null && !tesAwkCgoTrfMngVO.getManUsdAmt40ft().trim().equals("")){
						TesAwkCgoAdonTpSzVO tesAwkCgoAdonTpSzVO =  new TesAwkCgoAdonTpSzVO();
						tesAwkCgoAdonTpSzVO.setFmLocCd(tesAwkCgoTrfMngVO.getFmLocCd());
						tesAwkCgoAdonTpSzVO.setFmNodYdNo(tesAwkCgoTrfMngVO.getFmNodYdNo());
						tesAwkCgoAdonTpSzVO.setToLocCd(tesAwkCgoTrfMngVO.getToLocCd());
						tesAwkCgoAdonTpSzVO.setToNodYdNo(tesAwkCgoTrfMngVO.getToNodYdNo());
						tesAwkCgoAdonTpSzVO.setCondNo(tesAwkCgoTrfMngVO.getCondNo());
						tesAwkCgoAdonTpSzVO.setTmlAwkAdonVerNo(ver_no);
						tesAwkCgoAdonTpSzVO.setCntrSzCd(ACT_COST_CNTR_TP_40FT);
						tesAwkCgoAdonTpSzVO.setUsdAmt(tesAwkCgoTrfMngVO.getManUsdAmt40ft());
						tesAwkCgoAdonTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getLstUpdUsrId());
						tesAwkCgoAdonTpSzVO.setLoclCurrCd(tesAwkCgoTrfMngVO.getManLoclCurrCd());
						tesAwkCgoAdonTpSzVO.setLoclCurrAmt(tesAwkCgoTrfMngVO.getManLoclAmt40ft());
						tesAwkCgoAdonTpSzVO.setUsdXchDt(tesAwkCgoTrfMngVO.getUsdXchDt());
						tesAwkCgoAdonTpSzVO.setCreUsrId(tesAwkCgoTrfMngVO.getCreUsrId());
						tesAwkCgoAdonTpSzVO.setCreDt(tesAwkCgoTrfMngVO.getCreDt());
						tesAwkCgoAdonTpSzVO.setUpdUsrId(tesAwkCgoTrfMngVO.getLstUpdUsrId());
						insUpdTpszList.add(tesAwkCgoAdonTpSzVO);
					}
				}
			}
			if (insUpdHdrList!=null && insUpdHdrList.size() > 0){
				modifyAwkCgoTrfAddOnToUpdateDtl(insUpdHdrList);
				if (insUpdTpszList!=null && insUpdTpszList.size() > 0){
					modifyAwkCgoTrfAddOnToUpdateTpSz(insUpdTpszList);	
				}
			}
		}catch(EventException ex){
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("rollback err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 
	 * @param tesAwkCgoTrfMngVO
	 * @param awkCgoTrfTp
	 * @return List<TesAwkCgoTrfMngVO>
	 * @throws EventException
	 */
	private List<TesAwkCgoTrfMngVO> searchAwkCgoTrfToUpdateUSDAmt(String awkCgoTrfTp) throws EventException {
		List<TesAwkCgoTrfMngVO> tesAwkCgoTrfMngVOList = null;
		try {
			if (awkCgoTrfTp!=null){
				if (awkCgoTrfTp.trim().equals(ACT_COST_TRF_TP_BASIC) || awkCgoTrfTp.trim().equals(ACT_COST_TRF_TP_TS)){
					tesAwkCgoTrfMngVOList = actCostCalcDbDao.searchAwkCgoTrfToUpdateUSDAmt(awkCgoTrfTp);		
				} else if (awkCgoTrfTp.trim().equals(ACT_COST_TRF_TP_ADDON)){
					tesAwkCgoTrfMngVOList = actCostCalcDbDao.searchAwkCgoTrfAddOnToUpdateUSDAmt();
				}
			}
			return tesAwkCgoTrfMngVOList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상의 version no. 구함
	 * @param awkCgoTrfTp
	 * @param tesAwkCgoTrfMngVO
	 * @return String
	 * @throws EventException
	 */
	public String getAwkCgoTrfUpdateVerNo(String awkCgoTrfTp, TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws EventException {
		String ver_no = null;
		try {
			if (awkCgoTrfTp!=null && tesAwkCgoTrfMngVO!=null){
				ver_no = actCostCalcDbDao.getAwkCgoTrfUpdateVerNo(awkCgoTrfTp,tesAwkCgoTrfMngVO);		
			}
			return ver_no;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 DTL UPDATE 
	 * @param insUpdDtlList
	 * @throws EventException
	 */
	private void modifyAwkCgoTrfToUpdateDtlVer(List<TesAwkCgoTrfDtlVO> insUpdDtlList) throws EventException{
		try {
			actCostCalcDbDao.modifyAwkCgoTrfToUpdateDtlVer(insUpdDtlList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 TPSZ UPDATE
	 * @param insUpdTpszList
	 * @throws EventException
	 */
	private void modifyAwkCgoTrfToUpdateTpSzVer(List<TesAwkCgoTrfTpSzVO> insUpdTpszList) throws EventException{
		try {
			actCostCalcDbDao.modifyAwkCgoTrfToUpdateTpSzVer(insUpdTpszList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 DTL UPDATE
	 * @param insUpdDtlList
	 * @throws EventException
	 */
	private void modifyAwkCgoTrfAddOnToUpdateDtl(List<TesAwkCgoAdonHdrVO> insUpdDtlList) throws EventException{
		try {
			actCostCalcDbDao.modifyAwkCgoTrfAddOnToUpdateDtl(insUpdDtlList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 TPSZ UPDATE
	 * @param insUpdTpszList
	 * @throws EventException
	 */
	private void modifyAwkCgoTrfAddOnToUpdateTpSz(List<TesAwkCgoAdonTpSzVO> insUpdTpszList) throws EventException{
		try {
			actCostCalcDbDao.modifyAwkCgoTrfAddOnToUpdateTpSz(insUpdTpszList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * ActualCostCalcManageBCImpl 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		actCostCalcDbDao = null;
	}
}