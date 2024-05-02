/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageDBDAO.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0 
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
 * histroy
 * 080919 같은 구간 link에 const가 두개 이상 있을때 처리 되도록
 * 081013 미주 IRG상 Route Plan 82/87번을 가진 Local Shuttle 운송에 대하여 Rail Company에 해당 Shuttle 운송계약이
 *        포함되어 있으므로 S/O Candidate 불가처리
 *  20081015 미주 IRG상 Route Plan 82/87번을 가진 Local Shuttle 운송에 대하여 S/O Candidate 항목으로 조회하지 않도록 처리하는 SQL 수정
 *        (UPDATE시 서브쿼리에서 SINGLE ROW가 RETURN 되야 하는데 2개의ROW가 RETURN) *
 *  csr : N200903190040 20090320 mixed term , tro i/o TERM 일때 TERM CHANGE처리
 *  20090421 권한설정
 *  2010.09.27 채창호 [CHM-201006116] : Mixed Term Logic 변경 요청
 *  2012.08.17 정선용 [CHM-201219664] [PRD] Canada 향 D7 CNTR BKG block 을 위한 Hard-coding 설정요청
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PrdProdCtlRoutDtlVO;

/**
 * alps-PRD에 대한 DB 처리를 담당<br> 
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jungsunyoung
 * @see PrdCreateManageDBDAO 참조
 * @since J2EE 1.4
 */
public class PrdCreateManageDBDAO extends DBDAOSupport{

	/**
	 * PrdCreateManageDBDAO's createPrdCtlNoGenCop
	 * @param pcMode
	 * @return
	 * @throws DAOException
	 */
	public String createPrdCtlNoGenCop(String pcMode) throws DAOException{

		DBRowSet dbRowset = null;
		String hdPctlNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("pc_mode", pcMode);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCreateManageDBDAOCreatePrdCtlNoGenCSQL(), param, null);
			if(dbRowset.next()){
				hdPctlNo = dbRowset.getString("hd_pctl_no");
			}

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return hdPctlNo;
	}

	/**
	 * PrdCreateManageDBDAO's searchMixedRterm <br/>
	 * 2009514 mixed term , tro i/o TERM 일때 TERM CHANGE처리
     * @param bkgNo
	 * @param por
	 * @return
	 * @throws DAOException
	 */
	public String searchMixedRterm(String bkgNo ,String por) throws DAOException{
		DBRowSet dbR = null;
		String retValue = "";
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkgNo", bkgNo);
			param.put("por", por);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCreateManageDBDAOSearchMixedRtermRSQL(), param, null);
			if(dbR.next()){
				retValue = dbR.getString("rTerm");
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retValue;
	}

	/**
	 * PrdCreateManageDBDAO's searchMixedDterm <br/>
	 * 2009514 mixed term , tro i/o TERM 일때 TERM CHANGE처리
     * @param bkgNo
	 * @param del
	 * @return
	 * @throws DAOException
	 */
	public String searchMixedDterm(String bkgNo, String del) throws DAOException{
		DBRowSet dbR = null;
		String retValue = "";
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkgNo", bkgNo);
			param.put("del", del);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCreateManageDBDAOSearchMixedDtermRSQL(), param, null);
			if(dbR.next()){
				retValue = dbR.getString("dTerm");
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retValue;
	}

	/**
	 * PrdCreateManageDBDAO's selectPrdMst
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectPrdMst(String hdPctlNo) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCreateManageDBDAOSelectPrdMstRSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}

	/**
	 * PrdCreateManageDBDAO's selectPrdMst
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updateLaneForFrd(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdDtlLaneUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's deletePrdDtlNotSkd
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void deletePrdDtlNotSkd(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAODeletePrdDtlNotSkdDSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's deletePrdDtlByRank
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void deletePrdDtlByRank(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAODeletePrdDtlByRankDSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdCreateManageDBDAO's deletePrdQtyNotPcNo
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void deletePrdQtyNotPcNo(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAODeletePrdQtyNotPcNoDSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdCreateManageDBDAO's deletePrdMstNotPcNo
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void deletePrdMstNotPcNo(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{

			param.put("hd_pctl_no", hdPctlNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAODeletePrdMstNotPcNoDSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdCreateManageDBDAO's updatePrdMstTtlTztm
	 * @param hdPctlNo
	 * @param vvd
	 * @throws DAOException
	 */
	public void updatePrdMstTtlTztm(String hdPctlNo, String vvd) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);
			param.put("t_vvd", vvd);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdMstTtlTztmUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdCreateManageDBDAO's updatePrdDtlObTrspModDterm
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updatePrdDtlObTrspModDterm(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdDtlObTrspModDtermUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdCreateManageDBDAO's updatePrdDtlIbTrspModDterm
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updatePrdDtlIbTrspModDterm(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdDtlIbTrspModDtermUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's updatePrdMstRoutCnst
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updatePrdMstRoutCnst(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdMstRoutCnstUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's updatePrdMstByRoutCnst
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updatePrdMstByRoutCnst(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdMstByRoutCnstUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's updatePrdMstByPodMgmtCnst
	 * @param hdPctlNo
	 * @param bkgNo
	 * @throws DAOException
	 */
	public void updatePrdMstByPodMgmtCnst(String hdPctlNo, String bkgNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);
			param.put("bkg_no", bkgNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdMstByPodMgmtCnstUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PrdCreateManageDBDAO's updatePrdDtlLnkCnst
	 * @param hdPctlNo
	 * @param rdF
	 * @throws DAOException
	 */
	public void updatePrdDtlLnkCnst(String hdPctlNo, String rdF) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);
			param.put("rd_f", rdF);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdCreateManageDBDAO's updatePrdDtlNodCnst
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updatePrdDtlNodCnst(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdDtlNodCnstUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's updatePrdMstCnstFlg
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updatePrdMstCnstFlg(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdMstCnstFlgUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdCreateManageDBDAO's selectPcNoMinMax
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectPcNoMinMax(String hdPctlNo) throws DAOException{
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCreateManageDBDAOSelectPcNoMinMaxRSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * PrdCreateManageDBDAO's createContainerQty
	 * @param newPctlNo
	 * @param tpsz
	 * @param qty
	 * @param tpsz2
	 * @param qty2
	 * @param userId
	 * @throws DAOException
	 */
	public void createContainerQty(String newPctlNo, String tpsz, String qty, String tpsz2, String qty2, String userId) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
//			@[pctl_no], @[cntr_tpsz_cd], @[pctl_qty], @[rev_cntr_tpsz_cd], @[rev_pctl_qty], @[cre_usr_id],@[upd_usr_id]
			param.put("pctl_no", newPctlNo);
			param.put("cntr_tpsz_cd", tpsz);
			log.debug("\n\n ==========createContainerQty qty:" + qty);
			double subConQty = Double.parseDouble(qty.compareTo("") == 0 ? "0" : qty);
			param.put("pctl_qty", subConQty);
			param.put("rev_cntr_tpsz_cd", tpsz2);
			param.put("rev_pctl_qty", Double.parseDouble(qty2));
			param.put("cre_usr_id", userId);
			param.put("upd_usr_id", userId);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOCreateContainerQtyCSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's createActivityGroup
	 * @param hdPctlNo
	 * @param io_bnd_cd
	 * @param usr_id
	 * @throws DAOException
	 */
	public void createActivityGroup(String hdPctlNo, String io_bnd_cd, String usr_id) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);
			param.put("io_bnd_cd", io_bnd_cd);
			param.put("cre_usr_id", usr_id);
			param.put("upd_usr_id", usr_id);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOCreateActivityGroupCSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's updateActivityGroup
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updateActivityGroup(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdateActivityGroupUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdCreateManageDBDAO's updateActivityGroupForLocShuttleSo
	 * @param hdPctlNo
	 * @throws DAOException
	 */
	public void updateActivityGroupForLocShuttleSo(String hdPctlNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdateActivityGroupForLocShuttleSoUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's searchPrdCtlInfoForSpcAloc
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPrdCtlInfoForSpcAloc(String pctlNo) throws DAOException{
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("pctl_no", pctlNo);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCreateDBDAOSearchPrdCtlInfoForSpcAlocRSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * PrdCreateManageDBDAO's updateSpcAloc
	 * @param pctlNo
	 * @param pctl_seq
	 * @param lane
	 * @param org_node
	 * @param dst_node
	 * @param dir_cd
	 * @param vsl_cd
	 * @param voy_no
	 * @param sls_ofc
	 * @param ts_flg
	 * @param cust_cnt_cd
	 * @param cust_seq
	 * @param shpr_cnt_cd
	 * @param shpr_seq
	 * @param org_conti_cd
	 * @param dest_conti_cd
	 * @param r_lane_cd
	 * @return
	 * @throws DAOException
	 */
	public int updateSpcAloc(String pctlNo, String pctl_seq, String lane,
			String org_node, String dst_node, String dir_cd, String vsl_cd,
			String voy_no, String sls_ofc, String ts_flg, String cust_cnt_cd,
			String cust_seq, String shpr_cnt_cd, int shpr_seq,
			String org_conti_cd, String dest_conti_cd, String r_lane_cd) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("pctl_no", pctlNo);
			param.put("pctl_seq", pctl_seq);
			param.put("lane", lane);
			param.put("org_node", org_node);
			param.put("dst_node", dst_node);

			param.put("dir_cd", dir_cd);
			param.put("vsl_cd", vsl_cd);
			param.put("voy_no", voy_no);
			param.put("sls_ofc", sls_ofc);
			param.put("ts_flg", ts_flg);
			param.put("cust_cnt_cd", cust_cnt_cd);
			param.put("cust_seq", cust_seq);
			param.put("shpr_cnt_cd", shpr_cnt_cd);
			param.put("shpr_seq", shpr_seq);


			param.put("r_lane_cd", r_lane_cd);
			param.put("org_conti_cd", org_conti_cd);
			param.put("dest_conti_cd", dest_conti_cd);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateDBDAOUpdateSpaceAlocUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * com.hanjin.apps.alps.esd.prd.common.prdcreate.integration
	 * @param hdPctlNo
	 * @param ioBndCd
	 * @param patternStr
	 * @param usr_id
	 * @param obTroFlg
	 * @param ibTroFlg
	 * @throws DAOException
	 */
	public void createActivityGroupIncludePattern(String hdPctlNo,
			String ioBndCd, String patternStr, String usr_id, String obTroFlg, String ibTroFlg,String idaHlgTpCd,String copNo,String bkgNo) throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);
			param.put("io_bnd_cd", ioBndCd);
			param.put("cre_usr_id", usr_id);
			param.put("pattern_str", patternStr);
			param.put("ob_tro_flg", obTroFlg);
			param.put("ib_tro_flg", ibTroFlg);
			param.put("ida_hlg_tp_cd", idaHlgTpCd);
			param.put("cop_no", copNo);
			param.put("bkg_no", bkgNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOCreateActivityGroupIncludePatternCSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 동적 IRG를 신규로 생성해야 할 경우 배열의 각 열에 새로운 생성할 번호를 조회한다.<br>
	 * @param String hdPctlNo Product Catalog 번호
	 * @return List<PrdProdCtlRoutDtlVO> 배열 0 = New Outbound Seq, 배열 1 = New Inbound Seq
	 * @throws DAOException
	 */
	public List<PrdProdCtlRoutDtlVO> searchAutoIRGSeq(String hdPctlNo) throws DAOException{
		List<PrdProdCtlRoutDtlVO> list= null;
		
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new PrdCreateManageDBDAOSearchAutoIRGSeqRSQL(), param, param, PrdProdCtlRoutDtlVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	

	/**
	 * 동적 IRG값을 Product Catalog에 Update 한다.<br>
	 * @param String hdPctlNo Product Catalog 번호
	 * @param PrdProdCtlRoutDtlVO prdProdCtlRoutDtlVO 
	 * @throws DAOException
	 */
	public void updatePrdDtlByAutoIRG(String hdPctlNo, PrdProdCtlRoutDtlVO prdProdCtlRoutDtlVO) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);
			param.put("io_bnd_cd", prdProdCtlRoutDtlVO.getPctlIoBndCd());
			param.put("rout_seq", prdProdCtlRoutDtlVO.getRoutSeq());
			param.put("rout_org_nod_cd", prdProdCtlRoutDtlVO.getRoutOrgNodCd());
			param.put("rout_dest_nod_cd", prdProdCtlRoutDtlVO.getRoutDestNodCd());
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdDtlByAutoIRGUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PrdCreateManageDBDAO's searchMixedTermNodeValidation <br/>
	 * rcvT/por 혹은 delT/del 을 매개변수로 쿼리를 실행하여 Y or N 값을 리턴
	 * @param term
	 * @param node
	 * @return
	 * @throws DAOException
	 */
	public String searchMixedTermNodeValidation(String term ,String node) throws DAOException{
		DBRowSet dbR = null;
		String retValue = "";
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("term", term);
			param.put("nodCd", node);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new PrdCreateManageDBDAOSearchMixedTermNodeValidationRSQL(), param, null);
			if(dbR.next()){
				retValue = dbR.getString("term");
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retValue;
	}

	/**
	 * @param String hdPctlNo
	 * @throws DAOException
	 */
	public void updatePrdMstCnstException(String hdPctlNo)  throws DAOException{
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new PrdCreateManageDBDAOUpdatePrdMstCnstExceptionUSQL(), param, null);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
}
