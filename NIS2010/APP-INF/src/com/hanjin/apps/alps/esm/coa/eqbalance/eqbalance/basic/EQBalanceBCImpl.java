/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EQBalanceBCImpl.java
 *@FileTitle : Repo U/C 
 *Open Issues : 
 *@LastModifyDate : 2009.10.09
 *@LastModifier : 박수훈
 *@LastVersion : 1.13
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성
 * Change history : 2008.02.18 132번 화면 source 삭제 전윤주 
 *                : 2008.09.03 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
 *                             (17번 화면 삭제)
 * 2009.08.28 박수훈  New FrameWork 적용 [0019]
 * 2009.09.07 박수훈  New FrameWork 적용 [0018]
 * 2009.09.21 장영석  New FrameWork 적용 [0016]
 * 2009.10.08 박수훈  New FrameWork 적용 [0161]
 * 2009.10.09 박수훈  New FrameWork 적용 [0136]
*  2010.02.04 임옥영 :품질검토결과 반영
*  2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
*  2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -POR 별 Credit Ratio를 setup 할수 있는 화면추가 (Rule-set)  
 =========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.coa.common.integration.CommonDBDAO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration.EQBalanceDBDAO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance00163ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0016ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0018ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0019ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0136ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0161ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.basic.MultiDimensionRPTBC;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaCntrRepoCrVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoRoutEccVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoRuleVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoShtgInfoVO;

/**
 * ALPS-COA Business Logic Basic Command implementation<br> - ALPS-COA에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sangwook_nam
 * @see MultiDimensionRPTBC 각 DBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class EQBalanceBCImpl extends BasicCommandSupport implements EQBalanceBC {

	// Database Access Object
	private transient EQBalanceDBDAO dbDao = null;

	private transient CommonDBDAO comDao = null;

	/**
	 * MultiDimensionRPTBCImpl 객체 생성<br>
	 * MultiDimensionRPTDBDAO를 생성한다.<br>
	 */
	public EQBalanceBCImpl() {
		dbDao = new EQBalanceDBDAO();
		comDao = new CommonDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchConditionVO>
	 * @exception EventException
	 */
	public List<SearchConditionVO> searchEQBalance00162List(SearchConditionVO searchConditionVO) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<SearchConditionVO> list = null;		

		try {			
			comDao = new CommonDBDAO();
			
			rowSet = comDao.searchLocList("ecc|" + searchConditionVO.getFEccCd2());
			list = (List)RowSetUtil.rowSetToVOs(rowSet, SearchEQBalance00163ListVO.class);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEQBalance00163ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance00163ListVO> searchEQBalance00163List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchEQBalance00163List(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_0016 화면에 대한 멀티 이벤트 처리<br>
	 * @param CoaCntrRepoShtgInfoVO[] coaCntrRepoShtgInfoVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @param String excel_load_yn
	 * @exception EventException
	 */
	
	public void multiEQBalance00163(CoaCntrRepoShtgInfoVO[] coaCntrRepoShtgInfoVO, SearchConditionVO searchConditionVO, SignOnUserAccount account, String excel_load_yn) throws EventException{
		try {
			List<CoaCntrRepoShtgInfoVO> updateVoList = new ArrayList<CoaCntrRepoShtgInfoVO>();
			List<CoaCntrRepoShtgInfoVO> insertVoList = new ArrayList<CoaCntrRepoShtgInfoVO>();
			List<CoaCntrRepoShtgInfoVO> deleteVoList = new ArrayList<CoaCntrRepoShtgInfoVO>();
			if ( excel_load_yn.equals("Y")) {	//엑셀 업로드일 경우 년원에 해당 데이타 삭제후
				searchConditionVO.setFCostYrmon(searchConditionVO.getFCostYrmon().replaceAll("-", ""));
				dbDao.removeCostYrmonCoaCntrRepoShtgInfo(searchConditionVO);	
			}
			
			for ( int i=0; i<coaCntrRepoShtgInfoVO .length; i++ ) {
				  if (coaCntrRepoShtgInfoVO[i].getIbflag().equals("U")){
					coaCntrRepoShtgInfoVO[i].setUpdUsrId(account.getUsr_id());	
					coaCntrRepoShtgInfoVO[i].setCostYrmon(searchConditionVO.getFCostYrmon().replaceAll("-", ""));
					coaCntrRepoShtgInfoVO[i].setCntrTpszCd(searchConditionVO.getFCntrTpszCd());					
					updateVoList.add(coaCntrRepoShtgInfoVO[i]);					
					
				} else if (coaCntrRepoShtgInfoVO[i].getIbflag().equals("I")){
					coaCntrRepoShtgInfoVO[i].setUpdUsrId(account.getUsr_id());	
					coaCntrRepoShtgInfoVO[i].setCostYrmon(searchConditionVO.getFCostYrmon().replaceAll("-", ""));
					coaCntrRepoShtgInfoVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(coaCntrRepoShtgInfoVO[i]);					
				} else if (coaCntrRepoShtgInfoVO[i].getIbflag().equals("D")){
					coaCntrRepoShtgInfoVO[i].setCostYrmon(searchConditionVO.getFCostYrmon().replaceAll("-", ""));
					coaCntrRepoShtgInfoVO[i].setCntrTpszCd(searchConditionVO.getFCntrTpszCd());
					  
					deleteVoList.add(coaCntrRepoShtgInfoVO[i]);					
				}
			}
			 
			if ( updateVoList.size() > 0 ) {
				
				dbDao.modifyEQBalance00163(updateVoList);
			}	
			
			if ( insertVoList.size() > 0 ) {
				
				dbDao.addEQBalance00163(insertVoList);
			}	

			if ( deleteVoList.size() > 0 ) {
				
				dbDao.removeEQBalance00163(deleteVoList);
			}	


		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Set Credit Ratio 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0018 조회
	 * @param SearchEQBalance0018ListVO searchEQBalance0018ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEQBalance0018ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance0018ListVO> searchEQBalance0018List(SearchEQBalance0018ListVO searchEQBalance0018ListVO
			                                                      ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchEQBalance0018List(searchEQBalance0018ListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Set Credit Ratio 팝업 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_COA_0018 수정
	 * @param CoaCntrRepoCrVO[] coaCntrRepoCrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEQBalance0018(CoaCntrRepoCrVO[] coaCntrRepoCrVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaCntrRepoCrVO> updateVoList = new ArrayList<CoaCntrRepoCrVO>();
			for ( int i=0; i<coaCntrRepoCrVO .length; i++ ) {
				if ( coaCntrRepoCrVO[i].getIbflag().equals("U")){
					coaCntrRepoCrVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaCntrRepoCrVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEQBalance0018(updateVoList);
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
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0019 조회
	 * @param SearchEQBalance0019ListVO searchEQBalance0019ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEQBalance0019ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance0019ListVO> searchEQBalance0019List (SearchEQBalance0019ListVO searchEQBalance0019ListVO
			                                                       ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchEQBalance0019List (searchEQBalance0019ListVO, searchConditionVO);
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
	 * From ECC Setting 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0136 화면 조회<br>
	 * @param SearchEQBalance0136ListVO searchEQBalance0136ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEQBalance0136ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance0136ListVO> searchEQBalance0136List(SearchEQBalance0136ListVO searchEQBalance0136ListVO
			                                                      ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchEQBalance0136List(searchEQBalance0136ListVO, searchConditionVO);
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
	 * From ECC Setting 팝업 화면에 대한 수정 이벤트 처리<br>
	 * ESM_COA_0136 화면 수정<br>
	 * @param CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEQBalance0136(CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaCntrRepoRoutEccVO> updateVoList = new ArrayList<CoaCntrRepoRoutEccVO>();
			for ( int i=0; i<coaCntrRepoRoutEccVO .length; i++ ) {
				 if ( coaCntrRepoRoutEccVO[i].getIbflag().equals("U")){
					coaCntrRepoRoutEccVO[i].setCreUsrId(account.getUsr_id());
					coaCntrRepoRoutEccVO[i].setUpdUsrId(account.getUsr_id());
					coaCntrRepoRoutEccVO[i].setCntrTpszCd(searchConditionVO.getFCntrTpszCd());
					updateVoList.add(coaCntrRepoRoutEccVO[i]);
				} 
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEQBalance0136(updateVoList);
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
	 * 조회 이벤트 처리<br>
	 * To ECC Setting 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0161 화면 조회<br>
	 * @param SearchEQBalance0161ListVO searchEQBalance0161ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEQBalance0161ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance0161ListVO> searchEQBalance0161List(SearchEQBalance0161ListVO searchEQBalance0161ListVO
		                                                          ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchEQBalance0161List(searchEQBalance0161ListVO, searchConditionVO);
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
	 * DEL ECC Setting 팝업 화면에 대한 수정 이벤트 처리<br>
	 * ESM_COA_0161 화면 수정<br>
	 * @param CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEQBalance0161(CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaCntrRepoRoutEccVO> updateVoList = new ArrayList<CoaCntrRepoRoutEccVO>();
			for ( int i=0; i<coaCntrRepoRoutEccVO .length; i++ ) {
				 if ( coaCntrRepoRoutEccVO[i].getIbflag().equals("U")){
					coaCntrRepoRoutEccVO[i].setCreUsrId(account.getUsr_id());
					coaCntrRepoRoutEccVO[i].setUpdUsrId(account.getUsr_id());
					coaCntrRepoRoutEccVO[i].setCntrTpszCd(searchConditionVO.getFCntrTpszCd());
					updateVoList.add(coaCntrRepoRoutEccVO[i]);
				} 
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEQBalance0161(updateVoList);
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
	 * ECC_CD 존재유무 체크. <br>
	 * 
	 * @param eccCd
	 * @return String
	 * @exception EventException
	 */
	public String checkEccYn(String eccCd) throws EventException {
		String check = null;
		try {
			check = dbDao.searchEccYn(eccCd);
					
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
}