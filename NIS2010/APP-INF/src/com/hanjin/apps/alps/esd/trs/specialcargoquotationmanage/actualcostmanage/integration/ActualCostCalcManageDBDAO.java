/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCostCalcManageDBDAO.java
*@FileTitle : TRS의 Actual 비용 산출
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*2013-04-22
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.basic.ActualCostCalcManageBC;
import com.hanjin.syscommon.common.table.TrsActCostDtlVO;
import com.hanjin.syscommon.common.table.TrsActCostHdrVO;
import com.hanjin.syscommon.common.table.TrsActCostTpSzVO;


/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see ActualCostCalcManageBCImpl 참조
 * @since J2EE 1.4
 */
public class ActualCostCalcManageDBDAO extends DBDAOSupport {
	
	/**
	 * Actual Cost Calc의 SEQ 생성
	 * @return String
	 * @throws DAOException
	 */
	public String createActCostSeq() throws DAOException {	
		log.debug("\n BBB -  ActualCostCalcManageDBDAO.createActCostSeq - ########################################### ");
		
		DBRowSet dbRowset = null;
		String so_seq = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualCostCalcManageDBDAOCreateActCostSeqRSQL(), null, null);
			if (dbRowset != null && dbRowset.next()){
				so_seq = dbRowset.getString("ACT_COST_CALC_HDR_SEQ");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n EEE -  ActualCostCalcManageDBDAO.createActCostSeq - ########################################### ");
		
		return so_seq;
	}
	
	/**
	 * Actual Cost Calc 정보 넣기
	 * @param actCostHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String createActCostCalcHdr(TrsActCostHdrVO actCostHdrVO) throws DAOException{
		log.debug("\n BEGIN - ActualCostCalcManageDBDAO.createActCostCalcHdr - ########################################### ");

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actCostHdrVO!=null){
				param.put("trsp_act_cost_seq", JSPUtil.getNull(actCostHdrVO.getTrspActCostSeq()));
				param.put("exe_sts_cd", JSPUtil.getNull(actCostHdrVO.getExeStsCd()));
				param.put("calc_tp_cd", JSPUtil.getNull(actCostHdrVO.getCalcTpCd()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ActualCostCalcManageDBDAOCreateActCostCalcHdrCSQL(), param, velParam);			
				if (insCnt > 0){
					return "Y";
				} else {
					throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
				}
			} else {
				throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * Actual Cost Calc dtl 정보 넣기
	 * @param actCostDtlVOLst
	 * @throws DAOException
	 */
	public void createActCostCalcDtl(List<TrsActCostDtlVO> actCostDtlVOLst) throws DAOException{
		log.debug("\n BEGIN - ActualCostCalcManageDBDAO.createActCostCalcDtl - ########################################### ");

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int insCnt[] = null;		
		
		try {
			if (actCostDtlVOLst!=null && actCostDtlVOLst.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ActualCostCalcManageDBDAOCreateActCostCalcDtlCSQL(), actCostDtlVOLst, velParam, param);
				for (int i = 0; i < insCnt.length; i++){
					if (insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Actual Cost Calc tpsz 정보 넣기
	 * @param actCostTpSzVOLst
	 * @throws DAOException
	 */
	public void createActCostCalcTpSz(List<TrsActCostTpSzVO> actCostTpSzVOLst) throws DAOException{
		log.debug("\n BEGIN - ActualCostCalcManageDBDAO.createActCostCalcTpSz - ########################################### ");

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int insCnt[] = null;		
		
		try {
			if (actCostTpSzVOLst!=null && actCostTpSzVOLst.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ActualCostCalcManageDBDAOCreateActCostCalcTpSzCSQL(), actCostTpSzVOLst, velParam, param);
				for (int i = 0; i < insCnt.length; i++){
					if (insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Actual Cost Calc관리 table에 Error 처리
	 * @param actCostHdrVO
	 * @throws DAOException
	 */
	public void logActCostCalcErrMsg(TrsActCostHdrVO actCostHdrVO) throws DAOException {
		log.debug("\n BEGIN - ActualCostCalcManageDBDAO.logActCostCalcErrMsg - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (actCostHdrVO!=null){
				param.put("trsp_act_cost_seq", JSPUtil.getNull(actCostHdrVO.getTrspActCostSeq()));
				param.put("err_rmk", JSPUtil.getNull(actCostHdrVO.getErrRmk()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ActualCostCalcManageDBDAOLogActualCostCalcErrMsgUSQL(), param, velParam);			
				if (insCnt <= 0){
					throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n END - ActualCostCalcManageDBDAO.logActCostCalcErrMsg - ########################################### ");
	}
	
	/**
	 * Actual Cost Calc 조회
	 * @param actCostHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getActCostCalc(TrsActCostHdrVO actCostHdrVO) throws DAOException {
		log.debug("\n BBB -  ActualCostCalcManageDBDAO.getActCostCalc - ########################################### ");

		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTrspActCostSeq()!=null && !actCostHdrVO.getTrspActCostSeq().trim().equals("")){
					param.put("act_cost_trf_tp_shuttle", JSPUtil.getNull(ActualCostCalcManageBC.ACT_COST_TRF_TP_SHUTTLE));
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualCostCalcManageDBDAOGetActCostCALCRSQL(), param, velParam);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n EEE -  ActualCostCalcManageDBDAO.getActCostCalc - ########################################### ");
		
		return dbRowset;
	}

	/**
	 * Actual Cost Calc 후 완료 표시하기
	 * @param actCostHdrVO
	 * @throws DAOException
	 */
	public void completeCalcActCost(TrsActCostHdrVO actCostHdrVO) throws DAOException {
		log.debug("\n BEGIN - ActualCostCalcManageDBDAO.completeCalcActCost - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (actCostHdrVO!=null){
				param.put("trsp_act_cost_seq", JSPUtil.getNull(actCostHdrVO.getTrspActCostSeq()));
				int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ActualCostCalcManageDBDAOCompleteActCostCalcUSQL(), param, velParam);			
				if (insCnt <= 0){
					throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n END - ActualCostCalcManageDBDAO.completeCalcActCost - ########################################### ");
	}
}