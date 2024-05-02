/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MTCostBCImpl.java
*@FileTitle : ECC별 MT 표준단가&MT Turntime 생성 
*Open Issues :
*Change history : EQ Repo cost(009) 화면 LCC레벨 추가
*@LastModifyDate : 2009.09.14
*@LastModifier 	: 장영석
*@LastVersion : 1.4
* 2006-11-16 IM OKYOUNG
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration.MTCostDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListPopUpVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO10;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO11;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO12;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO13;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO14;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO2;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO3;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO4;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO5;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO6;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO7;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO8;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO9;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.EqRepoCostVO;		//SJH.20140922.ADD
import com.clt.framework.core.layer.event.Event;							//SJH.20141001.ADD
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.util.ScheduleUtil;




/**
 * OPUS-STDUnitCost Business Logic Basic Command implementation<br>
 * - OPUS-STDUnitCost에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author IM OKYOUNG
 * @see MTCostBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MTCostBCImpl extends BasicCommandSupport implements MTCostBC {

	// Database Access Object
	private transient MTCostDBDAO dbDao = null;

	/**
	 * MTCostBCImpl 객체 생성<br>
	 * MTCostDBDAO를 생성한다.<br>
	 */
	public MTCostBCImpl() {
		dbDao = new MTCostDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet1_MT 조회
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO> searchMTCostList(SearchMTCostListVO searchMTCostListVO
			                                        ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMTCostList(searchMTCostListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet2_MT 조회
	 * @param SearchMTCostListVO2 searchMTCostListVO2
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @return List<SearchMTCostListVO2>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO2> searchMTCostList2(SearchMTCostListVO2 searchMTCostListVO2
			                                          ,SearchMTCostListVO searchMTCostListVO) throws EventException {
		try {
			return dbDao.searchMTCostList2(searchMTCostListVO2, searchMTCostListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet3_MT 조회
	 * @param SearchMTCostListVO3 searchMTCostListVO3
	 * @param SearchMTCostListVO2 searchMTCostListVO2
	 * @return List<SearchMTCostListVO3>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO3> searchMTCostList3(SearchMTCostListVO3 searchMTCostListVO3
			                                          ,SearchMTCostListVO2 searchMTCostListVO2) throws EventException {
		try {
			return dbDao.searchMTCostList3(searchMTCostListVO3, searchMTCostListVO2);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet4_MT 조회
	 * @param SearchMTCostListVO4 searchMTCostListVO4
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO4>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO4> searchMTCostList4(SearchMTCostListVO4 searchMTCostListVO4
			                                          ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMTCostList4(searchMTCostListVO4, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet5_MT 조회
	 * @param SearchMTCostListVO5 searchMTCostListVO5
	 * @param SearchMTCostListVO4 searchMTCostListVO4
	 * @return List<SearchMTCostListVO5>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO5> searchMTCostList5(SearchMTCostListVO5 searchMTCostListVO5
			                                          ,SearchMTCostListVO4 searchMTCostListVO4) throws EventException {
		try {
			return dbDao.searchMTCostList5(searchMTCostListVO5, searchMTCostListVO4);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet6_MT 조회
	 * @param SearchMTCostListVO6 searchMTCostListVO6
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO6>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO6> searchMTCostList6(SearchMTCostListVO6 searchMTCostListVO6
			                                          ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMTCostList6(searchMTCostListVO6, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet7_MT 조회
	 * @param SearchMTCostListVO7 searchMTCostListVO7
	 * @param SearchMTCostListVO6 searchMTCostListVO6
	 * @return List<SearchMTCostListVO7>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO7> searchMTCostList7(SearchMTCostListVO7 searchMTCostListVO7
			                                          ,SearchMTCostListVO6 searchMTCostListVO6) throws EventException {
		try {
			return dbDao.searchMTCostList7(searchMTCostListVO7, searchMTCostListVO6);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet8_FULL 조회
	 * @param SearchMTCostListVO8 searchMTCostListVO8
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO8>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO8> searchMTCostList8(SearchMTCostListVO8 searchMTCostListVO8
			                                          ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMTCostList8(searchMTCostListVO8, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet9_FULL 조회
	 * @param SearchMTCostListVO9 searchMTCostListVO9
	 * @param SearchMTCostListVO8 searchMTCostListVO8
	 * @return List<SearchMTCostListVO9>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO9> searchMTCostList9(SearchMTCostListVO9 searchMTCostListVO9
			                                          ,SearchMTCostListVO8 searchMTCostListVO8) throws EventException {
		try {
			return dbDao.searchMTCostList9(searchMTCostListVO9, searchMTCostListVO8);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet10_FULL 조회 
	 * @param SearchMTCostListVO10 searchMTCostListVO10
	 * @param SearchMTCostListVO9 searchMTCostListVO9
	 * @return List<SearchMTCostListVO10>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO10> searchMTCostList10(SearchMTCostListVO10 searchMTCostListVO10
		                                             	,SearchMTCostListVO9 searchMTCostListVO9) throws EventException {
		try {
			return dbDao.searchMTCostList10(searchMTCostListVO10, searchMTCostListVO9);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet11_FULL 조회 
	 * @param SearchMTCostListVO11 searchMTCostListVO11
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO11>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO11> searchMTCostList11(SearchMTCostListVO11 searchMTCostListVO11
			                                            ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMTCostList11(searchMTCostListVO11, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet12_FULL 조회
	 * @param SearchMTCostListVO12 searchMTCostListVO12
	 * @param SearchMTCostListVO11 searchMTCostListVO11
	 * @return List<SearchMTCostListVO12>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO12> searchMTCostList12(SearchMTCostListVO12 searchMTCostListVO12
			                                            ,SearchMTCostListVO11 searchMTCostListVO11) throws EventException {
		try {
			return dbDao.searchMTCostList12(searchMTCostListVO12, searchMTCostListVO11);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet13_FULL 조회
	 * @param SearchMTCostListVO13 searchMTCostListVO13
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO13>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO13> searchMTCostList13(SearchMTCostListVO13 searchMTCostListVO13
			                                            ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMTCostList13(searchMTCostListVO13, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet14_FULL 조회
	 * @param SearchMTCostListVO14 searchMTCostListVO14
	 * @param SearchMTCostListVO13 searchMTCostListVO13
	 * @return List<SearchMTCostListVO14>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO14> searchMTCostList14(SearchMTCostListVO14 searchMTCostListVO14
			                                            ,SearchMTCostListVO13 searchMTCostListVO13) throws EventException {
		try {
			return dbDao.searchMTCostList14(searchMTCostListVO14, searchMTCostListVO13);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리_팝업<br>
	 * ESM_COA_0010 조회
	 * @param SearchMTCostListPopUpVO searchMTCostListPopUpVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListPopUpVO>
	 * @exception EventException
	 */
	public List<SearchMTCostListPopUpVO> searchMTCostListPopUp(SearchMTCostListPopUpVO searchMTCostListPopUpVO, SearchConditionVO searchConditionVO ) throws EventException {

		try {
			return dbDao.searchMTCostListPopUp(searchMTCostListPopUpVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * 저장 이벤트 처리<br>
	 * M/B Data I/F<br>

	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createMBInfo(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
        String params = "";
		try {
			 
			params = searchConditionVO.getFFmMon()
			+ "#" + searchConditionVO.getFToMon()
			+ "#" + "MB" // Screen에서 실행시킨 배치라는 의미
		 	+ "#" + searchConditionVO.getFCostYrmon();
			
			su.directExecuteJob("ESM_COA_B008",params);
			
		} catch (IOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"M/B Info Creation"}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"M/B Info Creation"}).getMessage(),e);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"M/B Info Creation"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"P/L Summary Creation"}).getMessage(),e);
		}
		return "4";//실행 성공
	}
		
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4003 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @param Event e 
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author SJH.20140922.ADD
	 */
    public CommonCoaRsVO searchEqRepoCostList(SearchConditionVO searchVO, Event e) throws EventException {
        try {
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
			            
			retVo = dbDao.searchEqRepoCostList(searchVO, retVo, e);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4003화면 대한 멀티 이벤트 처리<br>
     * 
     * @param EqRepoCostVO[] eqRepoCostVO
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account 
     * @param Event e 
     * @exception EventException
     * @author SJH.20140923.ADD
     */
    public void multiEqRepoCostInfo(EqRepoCostVO[] eqRepoCostVO, SearchConditionVO searchConditionVO, SignOnUserAccount account, Event e) throws EventException{
		try {
			List<EqRepoCostVO> insertVoList = new ArrayList<EqRepoCostVO>();
			List<EqRepoCostVO> updateVoList = new ArrayList<EqRepoCostVO>();
			List<EqRepoCostVO> deleteVoList = new ArrayList<EqRepoCostVO>();
			
			for ( int i=0; i<eqRepoCostVO .length; i++ ) {				
				if ( eqRepoCostVO[i].getIbflag().equals("I")){
					 eqRepoCostVO[i].setCreUsrId(account.getUsr_id());
					 eqRepoCostVO[i].setUpdUsrId(account.getUsr_id());	
					 insertVoList.add(eqRepoCostVO[i]);
				} else if ( eqRepoCostVO[i].getIbflag().equals("U")){
					eqRepoCostVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqRepoCostVO[i]);
				} else if ( eqRepoCostVO[i].getIbflag().equals("D")){
					eqRepoCostVO[i].setUpdUsrId(account.getUsr_id());	
					deleteVoList.add(eqRepoCostVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {	
				dbDao.addEqRepoCost(insertVoList, e);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEqRepoCost(updateVoList, searchConditionVO, e);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEqRepoCost(deleteVoList, e);
			}
			
			//20141021.EFF_TO_YRMON 일괄 update
			if ((e.getFormCommand().isCommand(FormCommand.MULTI01)) &&
			    (insertVoList.size() > 0 || updateVoList.size() > 0)) {
				dbDao.batchUpEqRepoCost(e);
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