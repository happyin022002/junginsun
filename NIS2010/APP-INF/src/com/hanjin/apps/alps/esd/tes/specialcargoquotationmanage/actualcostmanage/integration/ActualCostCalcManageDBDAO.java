/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCostCalcManageDBDAO.java
*@FileTitle : TES의 Actual 비용 산출
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*2013-03-21
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.integration;

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
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.basic.ActualCostCalcManageBC;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.syscommon.common.table.TesActCostDtlVO;
import com.hanjin.syscommon.common.table.TesActCostHdrVO;
import com.hanjin.syscommon.common.table.TesActCostTpSzVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfDtlVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfTpSzVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonTpSzVO;


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
	public String createActCostCalcHdr(TesActCostHdrVO actCostHdrVO) throws DAOException{
		log.debug("\n BEGIN - ActualCostCalcManageDBDAO.createActCostCalcHdr - ########################################### ");

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actCostHdrVO!=null){
				param.put("tml_act_cost_seq", JSPUtil.getNull(actCostHdrVO.getTmlActCostSeq()));
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
	public void createActCostCalcDtl(List<TesActCostDtlVO> actCostDtlVOLst) throws DAOException{
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
	public void createActCostCalcTpSz(List<TesActCostTpSzVO> actCostTpSzVOLst) throws DAOException{
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
	public void logActCostCalcErrMsg(TesActCostHdrVO actCostHdrVO) throws DAOException {
		log.debug("\n BEGIN - ActualCostCalcManageDBDAO.logActCostCalcErrMsg - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (actCostHdrVO!=null){
				param.put("tml_act_cost_seq", JSPUtil.getNull(actCostHdrVO.getTmlActCostSeq()));
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
	public DBRowSet getActCostCalc(TesActCostHdrVO actCostHdrVO) throws DAOException {
		log.debug("\n BBB -  ActualCostCalcManageDBDAO.getActCostCalc - ########################################### ");

		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actCostHdrVO!=null){
				if (actCostHdrVO.getTmlActCostSeq()!=null && !actCostHdrVO.getTmlActCostSeq().trim().equals("")){
					param.put("act_cost_trf_tp_basic", JSPUtil.getNull(ActualCostCalcManageBC.ACT_COST_TRF_TP_BASIC));
					param.put("act_cost_trf_tp_ts", JSPUtil.getNull(ActualCostCalcManageBC.ACT_COST_TRF_TP_TS));
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
	public void completeCalcActCost(TesActCostHdrVO actCostHdrVO) throws DAOException {
		log.debug("\n BEGIN - ActualCostCalcManageDBDAO.completeCalcActCost - ########################################### ");
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (actCostHdrVO!=null){
				param.put("tml_act_cost_seq", JSPUtil.getNull(actCostHdrVO.getTmlActCostSeq()));
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
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상의 version no. 구함
	 * @param awkCgoTrfTp
	 * @param tesAwkCgoTrfMngVO
	 * @return String
	 * @throws DAOException
	 */
	public String getAwkCgoTrfUpdateVerNo(String awkCgoTrfTp, TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		String ver_no = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (awkCgoTrfTp!=null && !awkCgoTrfTp.trim().equals("")){
				param.put("yd_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getYdCd()));
				param.put("tml_awk_cgo_trf_tp_cd", JSPUtil.getNull(awkCgoTrfTp)); //JSPUtil.getNull(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd()));
				param.put("io_bnd_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getIoBndCd()));
				param.put("io_ga_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getIoGaCd()));
				param.put("tml_awk_ts_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getTmlAwkTsCd()));
				param.put("cond_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getCondNo()));
				param.put("fm_loc_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getFmLocCd()));
				param.put("fm_nod_yd_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getFmNodYdNo()));
				param.put("to_loc_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getToLocCd()));
				param.put("to_nod_yd_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getToNodYdNo()));
				velParam.put("tml_awk_cgo_trf_tp_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualCostCalcManageDBDAOGetAwkCgoTrfUpdateVerNoRSQL(), param, velParam);
				if (dbRowset!=null && dbRowset.next()){
					ver_no = dbRowset.getString("VER_NO");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ver_no;
	}
	
	
	/**
	 * [BASIC][T/S] USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	 * @param awkCgoTrfTp
	 * @return List<TesAwkCgoTrfMngVO>
	 * @throws DAOException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoTrfToUpdateUSDAmt(String awkCgoTrfTp) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (awkCgoTrfTp!=null && !awkCgoTrfTp.trim().equals("")){
				param.put("tml_awk_cgo_trf_tp_cd", awkCgoTrfTp);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualCostCalcManageDBDAOSearchAwkCgoTrfToUpdateUSDAmtRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset,TesAwkCgoTrfMngVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ADD-ON] USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	 * @return List<TesAwkCgoTrfMngVO>
	 * @throws DAOException
	 */
	public List<TesAwkCgoTrfMngVO> searchAwkCgoTrfAddOnToUpdateUSDAmt() throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualCostCalcManageDBDAOSearchAwkCgoTrfAddOnToUpdateUSDAmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 DTL UPDATE
	 * @param insUpdDtlList
	 * @throws DAOException
	 */
	public void modifyAwkCgoTrfToUpdateDtlVer(List<TesAwkCgoTrfDtlVO> insUpdDtlList) throws DAOException {
		int [] rsCnt = null;
		try {
			if(insUpdDtlList!=null && insUpdDtlList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ActualCostCalcManageDBDAOModifyAwkCgoTrfToUpdateDtlVerCSQL(),insUpdDtlList, null, null);
				for(int i = 0; rsCnt!=null && i<rsCnt.length; i++){
					if( rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 TPSZ UPDATE
	 * @param insUpdTpszList
	 * @throws DAOException
	 */
	public void modifyAwkCgoTrfToUpdateTpSzVer(List<TesAwkCgoTrfTpSzVO> insUpdTpszList) throws DAOException {
		int [] rsCnt = null;
		try {
			if(insUpdTpszList!=null && insUpdTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ActualCostCalcManageDBDAOModifyAwkCgoTrfToUpdateTpSzVerCSQL(),insUpdTpszList, null, null);
				for(int i = 0; rsCnt!=null && i<rsCnt.length; i++){
					if( rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 DTL UPDATE
	 * @param insUpdDtlList
	 * @throws DAOException
	 */
	public void modifyAwkCgoTrfAddOnToUpdateDtl(List<TesAwkCgoAdonHdrVO> insUpdDtlList) throws DAOException {
		int [] rsCnt = null;
		try {
			if(insUpdDtlList!=null && insUpdDtlList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ActualCostCalcManageDBDAOModifyAwkCgoTrfAddOnToUpdateDtlCSQL(),insUpdDtlList, null, null);
				for(int i = 0; rsCnt!=null && i<rsCnt.length; i++){
					if( rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * USD환율 변경으로 인한 AMT 차이를 감지하여 TPSZ UPDATE
	 * @param insUpdTpszList
	 * @throws DAOException
	 */
	public void modifyAwkCgoTrfAddOnToUpdateTpSz(List<TesAwkCgoAdonTpSzVO> insUpdTpszList) throws DAOException {
		int [] rsCnt = null;
		try {
			if(insUpdTpszList!=null && insUpdTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ActualCostCalcManageDBDAOModifyAwkCgoTrfAddOnToUpdateTpSzUSQL(),insUpdTpszList, null, null);
				for(int i = 0; rsCnt!=null && i<rsCnt.length; i++){
					if( rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}