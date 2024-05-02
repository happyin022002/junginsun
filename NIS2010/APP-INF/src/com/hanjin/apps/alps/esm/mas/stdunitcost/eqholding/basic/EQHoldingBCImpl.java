/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQHoldingBCImpl.java
*@FileTitle : 실적장비비 표준단가 조회, 생성 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.26 송호진
* 1.0 Creation
* 2010.02.05 임옥영 소스품질검토 결과 반영 (클래스주석)
* 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration.EQHoldingDBDAO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.CntrPdmInvtVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqCntrHldCostVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqDayMgmtVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqHoldingCostVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-STDUnitCost Business Logic Command Interface<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Song Ho Jin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EQHoldingBCImpl extends BasicCommandSupport implements EQHoldingBC {

	// Database Access Object
	private transient EQHoldingDBDAO dbDao = null;

	/**
	 * EQHoldingBCImpl 객체 생성<br>
	 * EQHoldingDBDAO를 생성한다.<br>
	 */
	public EQHoldingBCImpl() {
		dbDao = new EQHoldingDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<EqHoldingCostVO>
	 * @exception EventException
	 */
	public List<EqCntrHldCostVO> searchEQCntrHldCost(SearchConditionVO conditionVO) throws EventException {
		conditionVO.unDataFormat();
		try {
//			return dbDao.searchEQHoldingCost(conditionVO);
			return dbDao.searchEQCntrHldCost(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<EqHoldingCostVO>
	 * @exception EventException
	 */
	public List<EqCntrHldCostVO> searchEQHldCostSum(SearchConditionVO conditionVO) throws EventException {
		conditionVO.unDataFormat();
		try {
			return dbDao.searchEQHldCostSum(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<EqHoldingCostVO>
	 * @exception EventException
	 */
	public List<EqCntrHldCostVO> searchEQHldCostPdm(SearchConditionVO conditionVO) throws EventException {
		conditionVO.unDataFormat();
		try {
			return dbDao.searchEQHldCostPdm(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EqHoldingCostVO[] eqHoldingCostVO
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiEQHoldingCost(EqHoldingCostVO[] eqHoldingCostVO, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {			
			List<EqHoldingCostVO> updateVoList = new ArrayList<EqHoldingCostVO>();
			List<EqHoldingCostVO> deleteVoList = new ArrayList<EqHoldingCostVO>();
			for ( int i=0; i<eqHoldingCostVO .length; i++ ) {
				if ( eqHoldingCostVO[i].getIbflag().equals("U")){
					eqHoldingCostVO[i].setUpdUsrId(account.getUsr_id());
					eqHoldingCostVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
					eqHoldingCostVO[i].setCntrChssDivCd(conditionVO.getFCalcTermCd());
					updateVoList.add(eqHoldingCostVO[i]);
				} else if ( eqHoldingCostVO[i].getIbflag().equals("D")){
					eqHoldingCostVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
					eqHoldingCostVO[i].setCntrChssDivCd(conditionVO.getFCalcTermCd());
					deleteVoList.add(eqHoldingCostVO[i]);
				}
			}
						
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEQHoldingCost(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEQHoldingCost(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * [비즈니스대상]을 [행위] 합니다.<br>
     * 
     * @param EqHoldingCostVO[] eqHoldingCostVO
     * @param SearchConditionVO conditionVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void multiEQHldCostPdm(EqCntrHldCostVO[] eqCntrHldCostVOs, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
        try {           
            List<EqCntrHldCostVO> updateVoList = new ArrayList<EqCntrHldCostVO>();
            for ( int i=0; i<eqCntrHldCostVOs.length; i++ ) {
                if ( eqCntrHldCostVOs[i].getIbflag().equals("U")){
                    eqCntrHldCostVOs[i].setUpdUsrId(account.getUsr_id());
                    eqCntrHldCostVOs[i].setCreUsrId(account.getUsr_id());
                    updateVoList.add(eqCntrHldCostVOs[i]);
                } 
            }
                        
            if ( updateVoList.size() > 0 ) {
                dbDao.multiEQHldCostPdm(updateVoList);
                
                Map<String, String> map = new HashMap<String, String> ();
                map.put("cost_yrmon", updateVoList.get(0).getCostYrmon());
                map.put("cre_usr_id", updateVoList.get(0).getCreUsrId());
                map.put("upd_usr_id", updateVoList.get(0).getUpdUsrId());
                //MAS_CNTR_HLD_COST 가 변경되면 그와 연관된 MAS_EQ_HLD_IF_MGMT 데이터를 재 생성해준다.
                //delete
                dbDao.removeEQHoldingIFMgmt(map);
                //create
                dbDao.addEQHoldingIFMgmt(map);
                
            }
            

        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
	 * 생성 이벤트 처리<br>
	 * EQ Holding Cost를월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createEqHoldingMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

          //1.MAS_HLD_COST테이블에서  TARGET 해당월을 삭제한다.
            dbDao.removeEqHoldingCost(param);
          //2.MAS_HLD_COST테이블에  SOURCE 해당월을 복사해서  TARGET 데이타를 생성한다.
            dbDao.createEqHoldingMonthCopy(param);
          //3. 복사 상태를 단가 관리 table에 insert 한다.
            dbDao.modifyEqHoldingCreationStatus(param);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CntrPdmInvtVO	cntrPdmInvtVO
	 * @return List<CntrPdmInvtVO>
	 * @exception EventException
	 */
	public List<CntrPdmInvtVO> searchCntrPdmInvtList(CntrPdmInvtVO cntrPdmInvtVO) throws EventException {
		cntrPdmInvtVO.unDataFormat();
		String frQtr = cntrPdmInvtVO.getFrQtr();
		String toQtr = cntrPdmInvtVO.getToQtr();
		cntrPdmInvtVO.setFrQtr(frQtr.concat("Q"));
		cntrPdmInvtVO.setToQtr(toQtr.concat("Q"));
		try {
			return dbDao.searchCntrPdmInvtList(cntrPdmInvtVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CntrPdmInvtVO[] cntrPdmInvtVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCntrPdmInvt(CntrPdmInvtVO[] cntrPdmInvtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CntrPdmInvtVO> insertVoList = new ArrayList<CntrPdmInvtVO>();
			List<CntrPdmInvtVO> updateVoList = new ArrayList<CntrPdmInvtVO>();
			List<CntrPdmInvtVO> deleteVoList = new ArrayList<CntrPdmInvtVO>();
			
			for ( int i=0; i<cntrPdmInvtVOs .length; i++ ) {
				cntrPdmInvtVOs[i].unDataFormat();
				cntrPdmInvtVOs[i].setCostYr(cntrPdmInvtVOs[i].getCostYrQtr().substring(0, 4));
				cntrPdmInvtVOs[i].setBseQtrCd(cntrPdmInvtVOs[i].getCostYrQtr().substring(4, 6));
				if (cntrPdmInvtVOs[i].getIbflag().equals("I")) {
					cntrPdmInvtVOs[i].setCreUsrId(account.getUsr_id());
					cntrPdmInvtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(cntrPdmInvtVOs[i]);
				} else if (cntrPdmInvtVOs[i].getIbflag().equals("U")) {
					cntrPdmInvtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cntrPdmInvtVOs[i]);
				} else if (cntrPdmInvtVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(cntrPdmInvtVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addCntrPdmInvt(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrPdmInvt(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCntrPdmInvt(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EqDayMgmtVO eqDayMgmtVO
	 * @return List<EqDayMgmtVO>
	 * @exception EventException
	 */
	public List<EqDayMgmtVO> searchEqDayMgmtList(EqDayMgmtVO eqDayMgmtVO) throws EventException {
//		eqDayMgmtVO.unDataFormat();
		try {			
			String yyyymm = "";
			yyyymm = eqDayMgmtVO.getFCostYrmon().replace("-","");
			
			eqDayMgmtVO.setFCostYrmon(yyyymm);
			return dbDao.searchEqDayMgmtList(eqDayMgmtVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EqDayMgmtVO[] eqDayMgmtVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiEqDayMgmt(EqDayMgmtVO[] eqDayMgmtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<EqDayMgmtVO> insertVoList = new ArrayList<EqDayMgmtVO>();
			List<EqDayMgmtVO> updateVoList = new ArrayList<EqDayMgmtVO>();
			List<EqDayMgmtVO> deleteVoList = new ArrayList<EqDayMgmtVO>();
			
			for ( int i=0; i<eqDayMgmtVOs .length; i++ ) {
				if (eqDayMgmtVOs[i].getIbflag().equals("I")) {
					eqDayMgmtVOs[i].setCreUsrId(account.getUsr_id());
					eqDayMgmtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(eqDayMgmtVOs[i]);
				} else if (eqDayMgmtVOs[i].getIbflag().equals("U")) {
					eqDayMgmtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqDayMgmtVOs[i]);
				} else if (eqDayMgmtVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(eqDayMgmtVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addEqDayMgmt(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEqDayMgmt(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEqDayMgmt(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	   /**
     * [비즈니스대상]을 [행위] 합니다.<br>
     * 
     * @param SearchConditionVO conditionVO
     * @return List<EqHoldingCostVO>
     * @exception EventException
     */
    public List<EqCntrHldCostVO> searchEQHldCostPdmNormal(SearchConditionVO conditionVO) throws EventException {
        conditionVO.unDataFormat();
        try {
            return dbDao.searchEQHldCostPdmNormal(conditionVO);
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
    

    /**
     * [비즈니스대상]을 [행위] 합니다.<br>
     * 
     * @param EqHoldingCostVO[] eqHoldingCostVO
     * @param SearchConditionVO conditionVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void multiEQHldCostPdmNormal(EqCntrHldCostVO[] eqCntrHldCostVOs, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
        try {           
            List<EqCntrHldCostVO> updateVoList = new ArrayList<EqCntrHldCostVO>();
            for ( int i=0; i<eqCntrHldCostVOs.length; i++ ) {
                if ( eqCntrHldCostVOs[i].getIbflag().equals("U")){
                    eqCntrHldCostVOs[i].setUpdUsrId(account.getUsr_id());
                    eqCntrHldCostVOs[i].setCreUsrId(account.getUsr_id());
                    updateVoList.add(eqCntrHldCostVOs[i]);
                } 
            }
                        
            if ( updateVoList.size() > 0 ) {
                dbDao.multiEQHldCostPdmNormal(updateVoList);
                
                Map<String, String> map = new HashMap<String, String> ();
                map.put("cost_yrmon", updateVoList.get(0).getCostYrmon());
                map.put("cre_usr_id", updateVoList.get(0).getCreUsrId());
                map.put("upd_usr_id", updateVoList.get(0).getUpdUsrId());
                //MAS_CNTR_HLD_COST 가 변경되면 그와 연관된 MAS_EQ_HLD_IF_MGMT 데이터를 재 생성해준다.
                //delete
                dbDao.removeEQHoldingIFMgmt(map);
                //create
                dbDao.addEQHoldingIFMgmt(map);
                
            }
            

        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
	
}