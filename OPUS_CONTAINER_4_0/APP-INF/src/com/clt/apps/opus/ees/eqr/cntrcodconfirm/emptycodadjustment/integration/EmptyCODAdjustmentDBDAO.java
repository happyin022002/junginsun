/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EmptyCODAdjustmentDBDAO.java
 *@FileTitle : MTY COD Simulation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.basic.EmptyCODAdjustmentBCImpl;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.BookingContainerListVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueEmptyList01VO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueListOptionVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODPortSumVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPortVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPort01VO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MTYREPOByPeriodOptionVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MTYREPOByPeriodVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MasterContainerListVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.PODListByVVDVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.RevenueMTYListCntrTpSzVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS EmptyCODAdjustmentDBDAO <br>
 * - OPUS-COD Confirm system Business Logic<br>
 * 
 * @author 
 * @see EmptyCODAdjustmentBCImpl 
 * @since J2EE 1.6
 */
public class EmptyCODAdjustmentDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * @param xTempVal String
	 * @return String
	 */
	public String checkStringInteger(String xTempVal) {
		String xVal01 = xTempVal;
		if (xVal01 == null || xVal01.equals("")) {
			xVal01 = "0";
		}
		return xVal01;
	}

	/**
	 * OnhireApprovalDBDAO<br>
	 * @param vvd String
	 * @param lane String
	 * @param bay String
	 * @param version String
	 * @param remark String
	 * @param sh2RC String
	 * @param n1stEtb String
	 * @param flagVLD String
	 * @param account SignOnUserAccount
	 * @param sMnlInpFlg String
	 * @return String
	 * @throws DAOException
	 */
	public String insertMTYREPOPlanVVD(String vvd, String lane, String bay, String version, String remark,
			String sh2RC, String n1stEtb, String flagVLD, SignOnUserAccount account,String sMnlInpFlg) throws DAOException {

		Map<String, Object> param1 = new HashMap<String, Object>();
		Map<String, Object> velParam1 = new HashMap<String, Object>();

		Map<String, Object> param2 = new HashMap<String, Object>();
		Map<String, Object> velParam2 = new HashMap<String, Object>();

		int result = 0;

		try {

			param1.put("vvd", vvd);
			param1.put("cod_cfm_div_cd", "C");
			param1.put("cod_cfm_sts_cd", "C");
			param1.put("slan_cd", lane);
			param1.put("n1st_etb_yrwk", n1stEtb);
			param1.put("bay_pln_port_cd", bay);
			param1.put("sMnlInpFlg" , sMnlInpFlg );
			param1.put("cre_ofc_cd", account.getOfc_cd());
			param1.put("upd_ofc_cd", account.getOfc_cd());
			param1.put("cre_usr_id", account.getUsr_id());
			param1.put("upd_usr_id", account.getUsr_id());

			param2.put("vvd", vvd);
			param2.put("cod_cfm_div_cd", "S");
			param2.put("cod_cfm_sts_cd", "C");
			param2.put("slan_cd", lane);
			param2.put("n1st_etb_yrwk", n1stEtb);
			param2.put("bay_pln_port_cd", bay);
			param2.put("sMnlInpFlg" , sMnlInpFlg );
			param2.put("cre_ofc_cd", account.getOfc_cd());
			param2.put("upd_ofc_cd", account.getOfc_cd());
			param2.put("cre_usr_id", account.getUsr_id());
			param2.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOMTYREPOPlanVVDCSQL(), param1,
					velParam1);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to INSERT VVD C SQL");
			}
			result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOMTYREPOPlanVVDCSQL(), param2,
					velParam2);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to INSERT VVD S SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result + "";
	}

	/**
	 * [MTY COD Confirmation]<br>
	 * 
	 * @param vvd
	 * @param lane
	 * @param bay
	 * @param version
	 * @param remark
	 * @param sh2RC
	 * @param flagVLD
	 * @param emptyCODVVDPortVO
	 * @param account
	 * @return String
	 * @throws DAOException
	 */
	public String insertMTYREPOPlanPORT(String vvd, String lane, String bay, String version, String remark,
			String sh2RC, String flagVLD, EmptyCODVVDPort01VO emptyCODVVDPortVO, SignOnUserAccount account)
			throws DAOException {

		Map<String, Object> param2 = new HashMap<String, Object>();
		Map<String, Object> velParam2 = new HashMap<String, Object>();

		Map<String, Object> param3 = new HashMap<String, Object>();
		Map<String, Object> velParam3 = new HashMap<String, Object>();

		int result = 0;

		try {

			param2.put("vvd", vvd);
			param2.put("cod_cfm_div_cd", "C");
			param2.put("port_cd", emptyCODVVDPortVO.getPodCd());
			param2.put("clpt_ind_seq", emptyCODVVDPortVO.getClptindseq());
			param2.put("lodg_dchg_div_cd", flagVLD);
			param2.put("yd_cd", emptyCODVVDPortVO.getPodCd() + emptyCODVVDPortVO.getYdCd());
			param2.put("etb_dt", emptyCODVVDPortVO.getEtb());
			param2.put("d2_qty", checkStringInteger(emptyCODVVDPortVO.getD2()));
			param2.put("d4_qty", checkStringInteger(emptyCODVVDPortVO.getD4()));
			param2.put("d5_qty", checkStringInteger(emptyCODVVDPortVO.getD5()));
			param2.put("d7_qty", checkStringInteger(emptyCODVVDPortVO.getD7()));
			param2.put("r2_qty", checkStringInteger(emptyCODVVDPortVO.getR2()));
			param2.put("r4_qty", "0");
			param2.put("r5_qty", checkStringInteger(emptyCODVVDPortVO.getR5()));
			param2.put("o2_qty", checkStringInteger(emptyCODVVDPortVO.getO2()));
			param2.put("o4_qty", checkStringInteger(emptyCODVVDPortVO.getO4()));
			param2.put("f2_qty", checkStringInteger(emptyCODVVDPortVO.getF2()));
			param2.put("f4_qty", checkStringInteger(emptyCODVVDPortVO.getF4()));
			param2.put("d8_qty", "0");
			param2.put("d9_qty", "0");
			param2.put("dw_qty", "0");
			param2.put("dx_qty", "0");
			param2.put("a2_qty", checkStringInteger(emptyCODVVDPortVO.getA2()));
			param2.put("a4_qty", checkStringInteger(emptyCODVVDPortVO.getA4()));
			param2.put("p2_qty", "0");
			param2.put("p4_qty", "0");
			param2.put("s2_qty", checkStringInteger(emptyCODVVDPortVO.getS2()));
			param2.put("s4_qty", checkStringInteger(emptyCODVVDPortVO.getS4()));
			param2.put("t2_qty", "0");
			param2.put("t4_qty", "0");
			param2.put("f5_qty", checkStringInteger(emptyCODVVDPortVO.getF5()));
			param2.put("o5_qty", checkStringInteger(emptyCODVVDPortVO.getO5()));
			param2.put("cre_ofc_cd", account.getOfc_cd());
			param2.put("upd_ofc_cd", account.getOfc_cd());
			param2.put("cre_usr_id", account.getUsr_id());
			param2.put("upd_usr_id", account.getUsr_id());
			if (flagVLD.equals("D")) {

				param3.put("vvd", vvd);
				param3.put("cod_cfm_div_cd", "S");
				param3.put("port_cd", emptyCODVVDPortVO.getPodCd());
				param3.put("clpt_ind_seq", emptyCODVVDPortVO.getClptindseq());
				param3.put("lodg_dchg_div_cd", flagVLD);
				param3.put("yd_cd", emptyCODVVDPortVO.getPodCd() + emptyCODVVDPortVO.getYdCd());
				param3.put("etb_dt", emptyCODVVDPortVO.getEtb());
				param3.put("d2_qty", checkStringInteger(emptyCODVVDPortVO.getD2()));
				param3.put("d4_qty", checkStringInteger(emptyCODVVDPortVO.getD4()));
				param3.put("d5_qty", checkStringInteger(emptyCODVVDPortVO.getD5()));
				param3.put("d7_qty", checkStringInteger(emptyCODVVDPortVO.getD7()));
				param3.put("r2_qty", checkStringInteger(emptyCODVVDPortVO.getR2()));
				param3.put("r4_qty", "0");
				param3.put("r5_qty", checkStringInteger(emptyCODVVDPortVO.getR5()));
				param3.put("o2_qty", checkStringInteger(emptyCODVVDPortVO.getO2()));
				param3.put("o4_qty", checkStringInteger(emptyCODVVDPortVO.getO4()));
				param3.put("f2_qty", checkStringInteger(emptyCODVVDPortVO.getF2()));
				param3.put("f4_qty", checkStringInteger(emptyCODVVDPortVO.getF4()));
				param3.put("d8_qty", "0");
				param3.put("d9_qty", "0");
				param3.put("dw_qty", "0");
				param3.put("dx_qty", "0");
				param3.put("a2_qty", checkStringInteger(emptyCODVVDPortVO.getA2()));
				param3.put("a4_qty", checkStringInteger(emptyCODVVDPortVO.getA4()));
				param3.put("p2_qty", "0");
				param3.put("p4_qty", "0");
				param3.put("s2_qty", checkStringInteger(emptyCODVVDPortVO.getS2()));
				param3.put("s4_qty", checkStringInteger(emptyCODVVDPortVO.getS4()));
				param3.put("t2_qty", "0");
				param3.put("t4_qty", "0");
				param3.put("f5_qty", checkStringInteger(emptyCODVVDPortVO.getF5()));
				param3.put("o5_qty", checkStringInteger(emptyCODVVDPortVO.getO5()));
				param3.put("cre_ofc_cd", account.getOfc_cd());
				param3.put("upd_ofc_cd", account.getOfc_cd());
				param3.put("cre_usr_id", account.getUsr_id());
				param3.put("upd_usr_id", account.getUsr_id());

			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOMTYREPOPlanPORTCSQL(), param2,
					velParam2);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to INSERT PORT C SQL");
			}
			if (flagVLD.equals("D")) {
				result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOMTYREPOPlanPORTCSQL(), param3,
						velParam3);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to INSERT PORT S SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result + "";
	}

	/**
	 * [MTY COD Confirmation]<br>
	 * 
	 * @param vvd
	 * @throws DAOException
	 */
	public void removeMTYREPOPlan(String vvd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("vvd", vvd);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOMTYREPOPlanVVDDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to DELETE VVD SQL");
			}
			result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOMTYREPOPlanPORTDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to DELETE PORT SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [MTYCODList]<br>
	 * 
	 * @param week
	 * @param trade
	 * @return List<EmptyCODVVDVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDVO> searchMTYCODList(String week, String trade) throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyCODVVDVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (week != null && trade != null) {
				param.put("week", week);
				param.put("trade", trade);
				velParam.put("trade", trade);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [MTYCODList]<br>
	 * 
	 * @param week String
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchHead(String week) throws DAOException {
		DBRowSet dbRowset = null;
		String[] slist = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (week != null) {
				param.put("week", week);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODMasterVORSQL(), param, velParam);

			if (dbRowset.next()) {
				slist = new String[5];
				slist[0] = dbRowset.getString(1);
				slist[1] = dbRowset.getString(2);
				slist[2] = dbRowset.getString(3);
				slist[3] = dbRowset.getString(4);
				slist[4] = dbRowset.getString(5);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return slist;
	}

	/**
	 * [BayplanPortList]<br>
	 * 
	 * @param emptyCODVVDVO EmptyCODVVDVO
	 * @param week String
	 * @return List<EmptyCODVVDPortVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDPortVO> searchBayplanPortList(EmptyCODVVDVO emptyCODVVDVO, String week) throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyCODVVDPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (emptyCODVVDVO != null) {
				Map<String, String> mapVO = emptyCODVVDVO.getColumnValues();
				param.putAll(mapVO);
				param.put("targetweek", week);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDPortVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDPortVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [SimulationPortList]<br>
	 * 
	 * @param emptyCODVVDVO EmptyCODVVDVO
	 * @param week String
	 * @return List<EmptyCODVVDPortVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDPortVO> searchSimulationPortList(EmptyCODVVDVO emptyCODVVDVO, String week)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyCODVVDPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (emptyCODVVDVO != null) {
				Map<String, String> mapVO = emptyCODVVDVO.getColumnValues();
				param.putAll(mapVO);
				param.put("targetweek", week);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDPortVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [IntraListVVD]<br>
	 * 
	 * @param week String
	 * @return List<EmptyCODVVDVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDVO> searchIntraVVDList(String week) throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyCODVVDVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (week != null) {
				param.put("week", week);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDVO3RSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [IntraList]<br>
	 * 
	 * @param week String
	 * @return List<EmptyCODVVDPortVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDPortVO> searchIntraList(String week) throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyCODVVDPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (week != null) {
				param.put("week", week);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDPortVO3RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDPortVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [PODListByVVD]<br>
	 * 
	 * @param week String
	 * @param vvd String
	 * @return List<PODListByVVDVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PODListByVVDVO> searchPODListByVVD(String week, String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PODListByVVDVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (week != null && vvd != null) {

				param.put("targetweek", week);
				param.put("vvd", vvd);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EmptyCODAdjustmentDBDAOPODListByVVDVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PODListByVVDVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Search Pod List.<br>
	 * 
	 * @param vvd String
	 * @return List<PODListByVVDVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PODListByVVDVO> searchPODListByVVD2(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PODListByVVDVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vvd", vvd);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchPODListByVVDRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PODListByVVDVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [EmptyCODVVD].<br>
	 * 
	 * @param vo List<EmptyCODVVDVO>
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addEmptyCODVVD(List<EmptyCODVVDVO> vo) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (vo.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDVOCSQL(), vo, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [EmptyCODVVDPort].<br>
	 * 
	 * @param vo List<EmptyCODVVDPortVO>
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addEmptyCODVVDPort(List<EmptyCODVVDPortVO> vo) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (vo.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDPortVOCSQL(), vo,
						null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [EmptyCODVVD].<br>
	 * 
	 * @param List<EmptyCODVVDVO> vo
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteEmptyCODVVD(List<EmptyCODVVDVO> vo) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (vo.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDVODSQL(), vo, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * [EmptyCODVVD].<br>
	 * 
	 * @param List<EmptyCODVVDVO> vo
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addEmptyCODVVDRemark(List<EmptyCODVVDVO> vo) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (vo.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVOCSQL(), vo,
						null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [EmptyCODVVDPort] <br>
	 * 
	 * @param List<EmptyCODVVDPortVO> vo
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteEmptyCODVVDPort(List<EmptyCODVVDPortVO> vo) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (vo.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDPortVODSQL(), vo,
						null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * [EmptyCODVVDRemark] <br>
	 * 
	 * @param List<EmptyCODVVDVO> vo
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteEmptyCODVVDRemark(List<EmptyCODVVDVO> vo) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (vo.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVODSQL(), vo,
						null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * [MTYREPOPlanV]<br>
	 * 
	 * @param String vvd
	 * @param String version
	 * @param String codCfmDivCd
	 * @return List<EmptyCODVVDPortVO00>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDPort01VO> searchMTYREPOPlanV(String vvd, String version,String codCfmDivCd) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOPlanV 1039 ");
		DBRowSet dbRowset = null;
		List<EmptyCODVVDPort01VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("lddiv", version);
			param.put("COD_CFM_DIV_CD", codCfmDivCd);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchConfirmed01RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDPort01VO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOPlanV 1039 ");
		return list;
	}

	/**
	 * [MTYREPOPlanL] <br>
	 * 
	 * @param String vvd
	 * @param String version
	 * @param String codCfmDivCd
	 * @return List<EmptyCODVVDPortVO01>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDPort01VO> searchMTYREPOPlanL(String vvd, String version,String codCfmDivCd) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOPlanL 1039 ");
		DBRowSet dbRowset = null;
		List<EmptyCODVVDPort01VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("lddiv", version);
			param.put("COD_CFM_DIV_CD", codCfmDivCd);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchConfirmedRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDPort01VO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOPlanL 1039 ");
		return list;
	}

	/**
	 * [MTYREPOPlanD] <br>
	 * 
	 * @param String vvd
	 * @param String version
	 * @param String codCfmDivCd
	 * @return List<EmptyCODVVDPortVO02>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDPort01VO> searchMTYREPOPlanD(String vvd, String version,String codCfmDivCd) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOPlanD 1039");
		DBRowSet dbRowset = null;
		List<EmptyCODVVDPort01VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("lddiv", version);
			param.put("COD_CFM_DIV_CD", codCfmDivCd);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchConfirmedRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDPort01VO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOPlanD 1039");
		return list;
	}

	/**
	 * [MTYREPOPlan2]<br>
	 * 
	 * @param vvd
	 * @return List<EmptyCODVVDPortVO02>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODVVDPort01VO> searchMTYREPOPlan2(String vvd) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOPlan2 1039 ");
		DBRowSet dbRowset2 = null;
		List<EmptyCODVVDPort01VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);

			dbRowset2 = new SQLExecuter("").executeQuery((ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchBayplanRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset2, EmptyCODVVDPort01VO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOPlan2 1039 ");
		return list;
	}

	/**
	 * MTYREPOPlan2 <br>
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchVVDInformation(String vvd) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchVVDInformation 1039 ");
		DBRowSet dbRowset = null;
		DBRowSet dbRowset2 = null;
		DBRowSet dbRowset3 = null;
		DBRowSet dbRowset4 = null;
		// List<EmptyCODMasterVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String check = "";
		try {
			param.put("vvd", vvd);
			param.put("COD_CFM_DIV_CD", "C");
			dbRowset = new SQLExecuter("").executeQuery( 
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchConfirmedVVDRSQL(), param, velParam);
			if (dbRowset.next()) {
				check = dbRowset.getString(1);
			}

			if (check.equals("")) {
				dbRowset2 = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchBayplanVVDRSQL(), param, velParam);
				if (dbRowset2.next()) {
					check = dbRowset2.getString(1);
				}
				
				if (check.equals("")) {
					param.put("COD_CFM_DIV_CD", "B");
					dbRowset3 = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchConfirmedVVDRSQL(), param, velParam);
					if (dbRowset3.next()) {
						check = dbRowset3.getString(1);
					}
					
					if (check.equals("")) {
						
						dbRowset4 = new SQLExecuter("").executeQuery(
								(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchBlankVVDRSQL(), param, velParam);
						if (dbRowset4.next()) {
							check = dbRowset4.getString(1);
						}
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchVVDInformation 1039 ");
		return check;
	}

	/**
	 * [MTYREPOPlan2]<br>
	 * 
	 * @param vvd
	 * @param port
	 * @param editIbFlag
	 * @return List<EmptyCODPortSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODPortSumVO> searchYardNETBByVVDPort(String vvd, String port, String editIbFlag)
			throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchYardNETBByVVDPort 1039 ");
		DBRowSet dbRowset = null;
		List<EmptyCODPortSumVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vvd", vvd);
			param.put("gPortCd", port);
			param.put("editIbFlag", editIbFlag);
			velParam.put("vvd", vvd);
			velParam.put("gPortCd", port);
			velParam.put("editIbFlag", editIbFlag);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchYardNETBByVVDPortRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODPortSumVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchYardNETBByVVDPort 1039 ");
		return list;
	}

	/**
	 * searchYardNETBByPort <br>
	 * 
	 * @param String vvd
	 * @param String port
	 * @param String editIbFlag
	 * @return List<EmptyCODPortSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EmptyCODPortSumVO> searchYardNETBByPort(String vvd, String port, String editIbFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<EmptyCODPortSumVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vvd", vvd);
			param.put("gPortCd", port);
			param.put("editIbFlag", editIbFlag);
			velParam.put("vvd", vvd);
			velParam.put("gPortCd", port);
			velParam.put("editIbFlag", editIbFlag);
			velParam.put("gubun", "1");

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchYardNETBByPortRSQL(), param, velParam);

			if (!dbRowset.next()) {
				velParam.put("gubun", "2");

				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchYardNETBByPortRSQL(), param, velParam);
			}
			else {
				dbRowset.beforeFirst();
			}

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODPortSumVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * HRDInformation <br>
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchHRDInformation(String vvd) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchVVDInformation 1039 ");
		DBRowSet dbRowset = null;
		// DBRowSet dbRowset2 = null;
		// List<EmptyCODMasterVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String txtHRD = "0   |0   |0   ";
		try {
			param.put("vvd", vvd);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchHRDInformationRSQL(), param, velParam);
			while (dbRowset.next()) {
				txtHRD = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchVVDInformation 1039 ");
		return txtHRD;
	}

	/**
	 * [RevenueMTYList01] <br>
	 * 
	 * @param vvd
	 * @param pod
	 * @return List<DamageRevenueEmptyListVO01>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DamageRevenueEmptyList01VO> searchRevenueMTYList01(String vvd, String pod) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchRevenueMTYList01 1040 ");
		DBRowSet dbRowset = null;
		List<DamageRevenueEmptyList01VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("pod", pod);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchRevenueMTYListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DamageRevenueEmptyList01VO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchRevenueMTYList01 1040 ");
		return list;
	}

	/**
	 * [RevenueMTYList02] <br>
	 * 
	 * @param vvd
	 * @param pod
	 * @return List<DamageRevenueEmptyListVO02>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DamageRevenueEmptyList01VO> searchRevenueMTYList02(String vvd, String pod) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchRevenueMTYList02 1040 ");
		DBRowSet dbRowset = null;
		List<DamageRevenueEmptyList01VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("pod", pod);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchRevenueMTYList01RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DamageRevenueEmptyList01VO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchRevenueMTYList02 1040 ");
		return list;
	}

	/**
	 * [RevenueMTYList03] <br>
	 * 
	 * @param vvd
	 * @param pod
	 * @return List<RevenueMTYListCntrTpSzVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RevenueMTYListCntrTpSzVO> searchRevenueMTYList03(String vvd, String pod) throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchRevenueMTYList03 1040 ");
		DBRowSet dbRowset = null;
		List<RevenueMTYListCntrTpSzVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("pod", pod);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchRevenueMTYList02RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RevenueMTYListCntrTpSzVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchRevenueMTYList03 1040 ");
		return list;
	}

	/**
	 * [DamageHangerMTYList01] <br>
	 * 
	 * @param damageRevenueListOptionVO
	 * @return List<MasterContainerListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MasterContainerListVO> searchDamageHangerMTYList01(DamageRevenueListOptionVO damageRevenueListOptionVO)
			throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchDamageHangerMTYList01 1040 ");
		DBRowSet dbRowset = null;
		List<MasterContainerListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (damageRevenueListOptionVO != null) {
				Map<String, String> mapVO = damageRevenueListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOMasterContainerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MasterContainerListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchDamageHangerMTYList01 1040 ");
		return list;
	}

	/**
	 * [DamageHangerMTYList02] <br>
	 * 
	 * @param damageRevenueListOptionVO
	 * @return List<BookingContainerListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BookingContainerListVO> searchDamageHangerMTYList02(DamageRevenueListOptionVO damageRevenueListOptionVO)
			throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchDamageHangerMTYList02 1040 ");
		DBRowSet dbRowset = null;
		List<BookingContainerListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (damageRevenueListOptionVO != null) {
				Map<String, String> mapVO = damageRevenueListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOBookingContainerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BookingContainerListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchDamageHangerMTYList02 1040 ");
		return list;
	}

	/**
	 * [DamageHangerMTYList03] <br>
	 * 
	 * @param damageRevenueListOptionVO
	 * @return List<RevenueMTYListCntrTpSzVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RevenueMTYListCntrTpSzVO> searchDamageHangerMTYList03(DamageRevenueListOptionVO damageRevenueListOptionVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RevenueMTYListCntrTpSzVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (damageRevenueListOptionVO != null) {
				Map<String, String> mapVO = damageRevenueListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAODamageHangerMTYListCntrTpSzRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RevenueMTYListCntrTpSzVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchDamageHangerMTYList03 1040 끝");
		return list;
	}

	/**
	 * MTY Repo Inquiry by Period <br>
	 * 
	 * @param mTYREPOByPeriodOptionVO
	 * @return List<MTYREPOByPeriodVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MTYREPOByPeriodVO> searchMTYREPOByPeriod(MTYREPOByPeriodOptionVO mTYREPOByPeriodOptionVO)
			throws DAOException {
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOByPeriod 1043 시작");
		DBRowSet dbRowset = null;
		List<MTYREPOByPeriodVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mTYREPOByPeriodOptionVO != null) {
				Map<String, String> mapVO = mTYREPOByPeriodOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOSearchMTYREPOByPeriodRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MTYREPOByPeriodVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("####### EmptyCODAdjustmentDBDAO.searchMTYREPOByPeriod 1043 끝");
		return list;
	}

	/**
	 * [VvdRemark] search<br>
	 * 
	 * @param vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchVvdRemark(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vvd != null) {
				param.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EmptyCODAdjustmentDBDAOsearchVvdRemarkRSQL(), param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmptyCODVVDVO.class);
			while(dbRowset.next()){
				list = dbRowset.getString(1);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [VvdRemark] retrieve<br>
	 * 
	 * @param emptyCODVVDVO
	 * @param userId
	 * @param ofcCd
	 * @throws DAOException
	 */
	public void saveVvdRemark(EmptyCODVVDVO emptyCODVVDVO, String userId, String ofcCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (emptyCODVVDVO != null) {
				Map<String, String> mapVO = emptyCODVVDVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("creusrid", userId);
			param.put("ofccd", ofcCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVOCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to UPDATE VVD SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [VvdRemark] delete<br>
	 * 
	 * @param EmptyCODVVDVO emptyCODVVDVO
	 * @throws DAOException
	 */
	public void deleteVvdRemark(EmptyCODVVDVO emptyCODVVDVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (emptyCODVVDVO != null) {
				Map<String, String> mapVO = emptyCODVVDVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDRemarkVODSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to DELETE REMARK SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [VvdRemark] delete<br>
	 * 
	 * @param String vvd
	 * @throws DAOException
	 */
	public void deleteVvdRemark2(String vvd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vvd != null) {

				param.put("vvd", vvd);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new EmptyCODAdjustmentDBDAOEmptyCODVVDRemark2VODSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to DELETE REMARK SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Retrieve yard code <br>
	 * 
	 * @param yardcode
	 * @return String
	 * @throws DAOException
	 */
	public String searchYardCode(String yardcode) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String check = "OK";
		try {
			param.put("yardcode", yardcode);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EmptyCODAdjustmentDBDAOsearchYardCodeRSQL(),
					param, velParam);
			if (!dbRowset.next()) {
				check = "NO";
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
	/**
	 * Check MnlInpFlg<br>
	 * 
	 * @param vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMnlInpFlgCheck(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String check = "";
		try {
			param.put("vvd", vvd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EmptyCODAdjustmentDBDAOMNLINPFLGCheckRSQL(),
					param, velParam);
			if (dbRowset.next()) {
				check = dbRowset.getString(1);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
	/**
	 * Location check<br>
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public String checkLocation(String locLevel ,String locCD) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String check = "OK";
		try{
			param.put("locLevel", locLevel);
			param.put("locCD", locCD);
			velParam.put("locLevel", locLevel);
			velParam.put("locCD", locCD);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EmptyCODAdjustmentDBDAOCheckLocationRSQL(), param, velParam);
			if(!dbRowset.next()){
				check = "NO";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
}