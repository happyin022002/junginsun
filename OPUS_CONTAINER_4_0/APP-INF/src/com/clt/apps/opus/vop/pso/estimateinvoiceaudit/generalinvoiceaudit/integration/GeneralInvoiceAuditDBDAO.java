/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GeneralInvoiceAuditDBDAO.java
 *@FileTitle : Requested MSA
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.ExpressionListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.IoRatioVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.ObjectListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.RoundTruncVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationInvoiceListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffInfoVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffSimByVvdVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TermDueVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.apps.opus.vop.pso.psocommonutil.BizComPsoUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.PsoChargeVO;
import com.clt.syscommon.common.table.PsoChgDtlVO;
import com.clt.syscommon.common.table.PsoYdChgVO;

/**
 * ALPS GeneralInvoiceAuditDBDAO <br>
 * - ALPS-EstimateInvoiceAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jin Ihl
 * @see GeneralInvoiceAuditBCImpl 참조
 * @since J2EE 1.6
 */
public class GeneralInvoiceAuditDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	private String dataSource = "";

	/**
	 * default constructor
	 */
	public GeneralInvoiceAuditDBDAO() {
		this.dataSource = "";
	}

	/**
	 * parameterized constructor
	 * 
	 * @param dataSource
	 */
	public GeneralInvoiceAuditDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 들어온 야드번호 와 야드 시퀀스 번호로 계산 해야 될 Expression List를 Select해온다.
	 * 
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @return List<ExpressionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ExpressionListVO> searchExpression(String ydChgNo, String ydChgVerSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<ExpressionListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ydChgNo != null && ydChgVerSeq != null) {
				param.put("yd_chg_no", ydChgNo);
				param.put("yd_chg_ver_seq", ydChgVerSeq);
				velParam.put("yd_chg_no", ydChgNo);
				velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchExpressionRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExpressionListVO.class);
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
	 * Expression String 문자열에서 []의 distinct한 ObjectList를 가져온다.
	 * 
	 * @param String sysXprDesc
	 * @return List<ObjectListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ObjectListVO> searchObject(String sysXprDesc) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<ObjectListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sysXprDesc != null) {
				param.put("xpr", sysXprDesc);
				velParam.put("xpr", sysXprDesc);
			
				dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchObjectRSQL(sysXprDesc), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, ObjectListVO.class);
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
	 * 실제 Tariff 값을 구하는 식을 select ... from dual 에 싣는다.
	 * 
	 * @param String strXpr
	 * @param String dspXpr
	 * @param String dspXpr2
	 * @return List<CalcTariffResultVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CalcTariffResultVO> executeTariff(String strXpr, String dspXpr, String dspXpr2) throws DAOException {
		
		
		DBRowSet dbRowset = null;
		List<CalcTariffResultVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (strXpr != null && dspXpr != null && dspXpr2 != null) {
				if (strXpr.equals(""))
					strXpr = "'empty'";
				if (dspXpr.equals(""))
					dspXpr = "'empty'";
				if (dspXpr2.equals(""))
					dspXpr2 = "'empty'";

				// >>[2010.05.27:jmh] 작은따옴표로 싸여진 문자열안에 또 작은따옴표가 있을때
				String pattern = "^'(.*)'$";
				Matcher m = null;
				Pattern p = Pattern.compile(pattern);

				m = p.matcher(strXpr.trim());
				while (m.find()) {
					strXpr = "'" + m.group(1).replaceAll("'", "''") + "'";
					// log.error("\n1.strXpr\n" + strXpr);
				}

				m = p.matcher(dspXpr.trim());
				while (m.find()) {
					dspXpr = "'" + m.group(1).replaceAll("'", "''") + "'";
					// log.error("\n2.dspXpr\n" + dspXpr);
				}

				m = p.matcher(dspXpr2.trim());
				while (m.find()) {
					dspXpr2 = "'" + m.group(1).replaceAll("'", "''") + "'";
					// log.error("\n3.dspXpr2\n" + dspXpr2);
				}
				// <<[2010.05.27:jmh]

				velParam.put("strXpr", strXpr);
				velParam.put("dspXpr2", dspXpr2);
				velParam.put("dspXpr", dspXpr);

			}

			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchExecuteTariffRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CalcTariffResultVO.class);

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
	 * Invoice 정보중 Parent 쪽의 데이터를 생성한다.
	 * 
	 * @category VOP_PSO_0018_InsertPsoCharge
	 * @param List<PsoChargeVO> psoChargeVOs
	 * @throws DAOException
	 */
	public void addPsoCharge(List<PsoChargeVO> psoChargeVOs) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int insCnt[] = null;
			if (psoChargeVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralInvoiceAuditDBDAOinsertPsoChargeCSQL(), psoChargeVOs, null);
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
	}

	/**
	 * Invoice정보의 Detail쪽 내용 (Charge Detail)을 생성한다.
	 * 
	 * @category VOP_PSO_0018_InsertPsoChargeDetail
	 * @param List<PsoChgDtlVO> psoChgDtlVOs
	 * @throws DAOException
	 */
	public void addPsoChgDtl(List<PsoChgDtlVO> psoChgDtlVOs) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int insCnt[] = null;
			if (psoChgDtlVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralInvoiceAuditDBDAOinsertPsoChgDtlCSQL(), psoChgDtlVOs, null);
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
	}

	// =====================> 실제 OBJECT의 VALUE를 각각의 SQL을 통해서 가져오는ㄴ 곳.
	/**
	 * Tariff 비용 계산을 위해서 주어진 VVD를 가지고 NRT의 값을 DB에서 Select 한다. //SELECT
	 * NET_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getVslNrt(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetVslNrtRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 주어진 VVD를 가지고 GRT의 값을 DB에서 Select한다. //SELECT
	 * GRS_RGST_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * 
	 * @param String
	 *            vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getVslGrt(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetVslGrtRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 PSO_TARIFF테이블에서 해당 Tariff 의 타입을 구해 온다.
	 * 
	 * @param String tariffNo
	 * @return String
	 * @throws DAOException
	 */
	public String getPsoTrfTpCd(String tariffNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (tariffNo != null) {
			param.put("port_trf_no", tariffNo);
			velParam.put("port_trf_no", tariffNo);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetPsoTrfTpCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 Tariff Detail에서 Rate Amout를 구한다. Range타입의 경우
	 * 
	 * @param String tariffNo
	 * @param String prvObjVal
	 * @param String flag
	 * @return String
	 */
	public String getTrfRtAmt(String tariffNo, String prvObjVal, String flag) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (tariffNo != null) {
			param.put("port_trf_no", tariffNo);
			velParam.put("port_trf_no", tariffNo);
			param.put("obj_val", prvObjVal);
			velParam.put("obj_val", prvObjVal);
			param.put("flag", flag);
			velParam.put("flag", flag);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetTrfRtAmtRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 해당 Tariff가 어떤 ObjectListNumber에 해당하는 구한다.
	 * 
	 * @param String tariffNo
	 * @return String
	 * @throws DAOException
	 */
	public String getObjListNo(String tariffNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (tariffNo != null) {
			param.put("port_trf_no", tariffNo);
			velParam.put("port_trf_no", tariffNo);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetObjListNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 Vessel의 LOA_LEN을 구한다. //SELECT LOA_LEN FROM MDM_VSL_CNTR
	 * WHERE VSL_CD = 'BAHX'
	 * 
	 * @param String
	 *            vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getLoaMeter(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLoaMeterRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/*
	 * CHM-201007037-01
	 */
	/**
	 * SELECT ROUND(LOA_LEN * 3.28, 4) FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * Tariff 비용 계산을 위해 Vessel 의 LOA 를 Meter 단위로 구한다
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getLoaFeet(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLoaFeetRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = 'BAHX' AND SKD_VOY_NO
	 * = '0036' AND SKD_DIR_CD = 'E' Tariff 비용 계산을 위해 해당 VVD 의 Lane Code 를 구한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getLane(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLaneRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT VSL_RGST_CNT_CD FROM mdm_vsl_cntr WHERE VSL_CD = 'HPSH' Tariff 비용
	 * 계산을 위해 해당 VVD 의 Vessel Nationality 를 구한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getNalVsl(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetNalVslRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * SELECT SUZ_NET_TONG_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX' Tariff 비용
	 * 계산을 위해 VVD 의 SCNT 를 구한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getScnt(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetScntRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT SUZ_GT_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX' Tariff 비용 계산을
	 * 위해 VVD 의 SCNT 를 구한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getScgt(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetScgtRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT SHP_IDX_SCRE FROM VSK_VSL_ADD_SPEC WHERE VSL_CD = 'HJRJ' Tariff 비용
	 * 계산을 위해 VVD 의 ESI Score를 구한다
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getESIScore(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetESIScoreRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT BWTHST_BHP_PWR FROM MDM_VSL_CNTR WHERE VSL_CD = 'HDDH' AND
	 * MN_ENG_HOR_PWR_UT_CD = 'HP' Towage 비용 tariff에서 Bow Thrust Power에 사용 TUG
	 * 수량이 달라짐에 따라 해당 신규 Object가 필요하오니 신규 생성 바랍니다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getBowThurustPowerBHP(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBowThurustPowerRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString("HP");
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT BWTHST_BHP_PWR FROM MDM_VSL_CNTR WHERE VSL_CD = 'HDDH' AND
	 * MN_ENG_HOR_PWR_UT_CD = 'KW' Towage 비용 tariff에서 Bow Thrust Power에 사용 TUG
	 * 수량이 달라짐에 따라 해당 신규 Object가 필요하오니 신규 생성 바랍니다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getBowThurustPowerKW(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBowThurustPowerRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString("KW");
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT DWT_WGT FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX' Tariff 비용 계산을 위해
	 * VVD 의 Dead Weight 를 구한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getDeadWeight(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDeadWeightRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT VSL_CD, NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) * NVL(SMR_DRFT_HGT, 0)
	 * AS BLOCK_SIZE FROM MDM_VSL_CNTR WHERE VSL_CD = :VSL_CD Tariff 비용 계산을 위해
	 * VVD 의 Block Size 를 구한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getBlockSize(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBlockSizeRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT CNTR_PNM_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD = :VSL_CD Tariff 비용
	 * 계산을 위해 Allowance TEU 를 구한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getAllwTeu(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetAllwTeuRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND
	 * YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO Tariff 비용
	 * 계산을 위해 Arrival No 를 구하는데 Default 로 구한다.
	 * 
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws DAOException
	 */
	public String getArvNoOfTrk(String ydChgNo, String ydChgVerSeq, String objListNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (ydChgNo != null && ydChgVerSeq != null && objListNo != null) {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("obj_list_no", objListNo);
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("obj_list_no", objListNo);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArvNoOfTrkRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 Departure No. of Tractor 를 구한다. SELECT DFLT_VAL FROM
	 * PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND YD_CHG_VER_SEQ =
	 * :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * 
	 * @category Obj5_DepartureNoofTractor
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws DAOException
	 */
	public String getDprNoOfTrk(String ydChgNo, String ydChgVerSeq, String objListNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (ydChgNo != null && ydChgVerSeq != null && objListNo != null) {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("obj_list_no", objListNo);
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("obj_list_no", objListNo);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDprNoOfTrkRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 Arrival No. of Tug 를 구한다. SELECT T1.ARR_TUG_BOT_KNT FROM
	 * VSK_ACT_PORT_SKD T1, VSK_VSL_PORT_SKD T2 WHERE 1 = 1 AND T1.VSL_CD =
	 * T2.VSL_CD AND T1.SKD_VOY_NO = T2.SKD_VOY_NO AND T1.SKD_DIR_CD =
	 * T2.SKD_DIR_CD AND T1.VPS_PORT_CD = T2.VPS_PORT_CD AND T1.CLPT_IND_SEQ =
	 * T2.CLPT_IND_SEQ AND T1.VSL_CD = 'BAHX' AND T1.SKD_VOY_NO = '0036' AND
	 * T1.SKD_DIR_CD = 'E' AND T2.YD_CD = 'KRINCYP'
	 * 
	 * @category Obj6_ArrivalNoofTug
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getArvNoOfTug(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArvNoOfTugRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 7: //Departure No. of Tug Tariff 비용 계산을 위해 Departure No. of Tug 를 구한다.
	 * SELECT T1.DEP_TUG_BOT_KNT FROM VSK_ACT_PORT_SKD T1, VSK_VSL_PORT_SKD T2
	 * WHERE 1 = 1 AND T1.VSL_CD = T2.VSL_CD AND T1.SKD_VOY_NO = T2.SKD_VOY_NO
	 * AND T1.SKD_DIR_CD = T2.SKD_DIR_CD AND T1.VPS_PORT_CD = T2.VPS_PORT_CD AND
	 * T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ AND T1.VSL_CD = 'BAHX' AND
	 * T1.SKD_VOY_NO = '0036' AND T1.SKD_DIR_CD = 'E' AND T2.YD_CD = 'KRINCYP'
	 * 
	 * @category Obj7_DepartureNoofTug
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getDprNoOfTug(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDprNoOfTugRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 8: //Arrival Tug Power Tariff 비용 계산을 위해 Departure No. of Tug를 구한다. SELECT
	 * DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO AND
	 * YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * 
	 * @category Obj8_ArrivalTugPower
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws DAOException
	 */
	public String getArvTugPwr(String ydChgNo, String ydChgVerSeq, String objListNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (ydChgNo != null && ydChgVerSeq != null && objListNo != null) {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("obj_list_no", objListNo);
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("obj_list_no", objListNo);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArvTugPwrRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 9: //Departure Tug Power Tariff 비용 계산을 위해 Departure Tug Power 를 구한다.
	 * //SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO
	 * AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * 
	 * @category Obj9_DepartureTugPower
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws DAOException
	 */
	public String getDprTugPwr(String ydChgNo, String ydChgVerSeq, String objListNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (ydChgNo != null && ydChgVerSeq != null && objListNo != null) {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("obj_list_no", objListNo);
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("obj_list_no", objListNo);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDprTugPwrRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 10: //Arrival Tug Used Hour Tariff 비용 계산을 위해 Arrival Tug Used Hour 를 구한다.
	 * //SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO = :YD_CHG_NO
	 * AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO = :OBJ_LIST_NO
	 * 
	 * @category Obj10_ArrivalTugUsedHour
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws DAOException
	 */
	public String getArvTugUsedHour(String ydChgNo, String ydChgVerSeq, String objListNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (ydChgNo != null && ydChgVerSeq != null && objListNo != null) {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("obj_list_no", objListNo);
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("obj_list_no", objListNo);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArvTugUsedHourRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 11: //Departure Tug Used Hour Tariff 비용 계산을 위해 Departure Tug Used Hour 를
	 * 구한다. //SELECT DFLT_VAL FROM PSO_YD_CHG_OBJ_LIST WHERE YD_CHG_NO =
	 * :YD_CHG_NO AND YD_CHG_VER_SEQ = :YD_CHG_VER_SEQ AND OBJ_LIST_NO =
	 * :OBJ_LIST_NO
	 * 
	 * @category Obj11_DepartureTugUsedHour
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws DAOException
	 */
	public String getDprTugUsedHour(String ydChgNo, String ydChgVerSeq, String objListNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (ydChgNo != null && ydChgVerSeq != null && objListNo != null) {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("obj_list_no", objListNo);
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("obj_list_no", objListNo);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDprTugUsedHourRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 13: //BeamMeter Tariff 비용 계산을 위해 BeamMeter를 구한다. //SELECT VSL_WDT FROM
	 * MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * 
	 * @category Obj13_BeamMeter
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getBeamMeter(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBeamMeterRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/*
	 * CHM-201007037-01
	 */
	/**
	 * 14: //BeamFeet Tariff 비용 계산을 위해 BeamFeet 를 구한다. //SELECT ROUND(VSL_WDT *
	 * 3.28, 4) FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * 
	 * @category Obj14_BeamFeet
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getBeamFeet(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBeamFeetRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 주어진 vvd로 CallingPortIndicationSeq를 구한다.
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String selectClptIndSeq(String vvd, String ydCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
		}

		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOselectClptIndSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 2: //Arrival Draft Tariff 비용 계산을 위해 Arrival Draft 를 구한다. SELECT
	 * MAX(ARR_AFTDR_HGT) * 3.28 FROM VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B
	 * WHERE A.VSL_CD = B.VSL_CD AND A.SKD_VOY_NO = B.SKD_VOY_NO AND
	 * A.SKD_DIR_CD = B.SKD_DIR_CD AND A.VPS_PORT_CD = B.VPS_PORT_CD AND
	 * A.CLPT_IND_SEQ = B.CLPT_IND_SEQ AND A.VSL_CD = 'CXMH' AND A.SKD_VOY_NO =
	 * '0801' AND A.SKD_DIR_cD = 'E' AND A.YD_CD = 'SGSINKA'
	 * 
	 * @category Obj2_ArrivalDraftFeet
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getArvDrftFeet(String vvd, String ydCd, String clptIndSeq) throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArvDrftFeetRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * case 3: //Departure Draft Tariff 비용 계산을 위해 Departure Draft 를 구한다. SELECT
	 * MAX(DEP_AFTDR_HGT) FROM VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B WHERE
	 * A.VSL_CD = B.VSL_CD AND A.SKD_VOY_NO = B.SKD_VOY_NO AND A.SKD_DIR_CD =
	 * B.SKD_DIR_CD AND A.VPS_PORT_CD = B.VPS_PORT_CD AND A.CLPT_IND_SEQ =
	 * B.CLPT_IND_SEQ AND A.VSL_CD = 'CXMH' AND A.SKD_VOY_NO = '0801' AND
	 * A.SKD_DIR_cD = 'E' AND A.YD_CD = 'SGSINKA'
	 * 
	 * @category Obj3_DepartuerDraftMeter
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getDprDrftMeter(String vvd, String ydCd, String clptIndSeq) throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDprDrftMeterRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 15: //Berthing Hour Tariff 비용 계산을 위해 Berthing Hour 를 구한다. //SELECT
	 * ROUND((VPS_ETD_DT - VPS_ETB_DT) * 24, 2) FROM VSK_VSL_PORT_SKD WHERE
	 * VSL_CD = 'HJMT' AND SKD_VOY_NO = '0130' AND SKD_DIR_CD = 'E' AND YD_CD =
	 * 'CNHKGHT' AND CALL_YD_IND_SEQ = '1'
	 * 
	 * @category Obj15_BerthingHour
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getBerthingHour(String vvd, String ydCd, String clptIndSeq) throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null && clptIndSeq != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBerthingHourRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 16: //Berthing Date Tariff 비용 계산을 위해 Berthing Date 를 구한다. //SELECT
	 * (TRUNC(VPS_ETD_DT)-TRUNC(VPS_ETB_DT)) +1 FROM VSK_VSL_PORT_SKD WHERE
	 * VSL_CD = 'HJMT' AND SKD_VOY_NO = '0130' AND SKD_DIR_CD = 'E' AND YD_CD =
	 * 'CNHKGHT' AND CALL_YD_IND_SEQ = '1'
	 * 
	 * @category Obj166_BerthingDate
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getBerthingDate(String vvd, String ydCd, String clptIndSeq) throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		// setBudgetFlag(isBudget, param, velParam);

		if (vvd != null && ydCd != null && clptIndSeq != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBerthingDateRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 주어진 조건으로 PSO_YD_CHG 의 정보를 조회 한다.
	 * 
	 * @category VOP_PSO_0014_searchPsoYdChg
	 * @param String lgsCostCd
	 * @param String ydCd
	 * @param String vndrSeq
	 * @param String issDt
	 * @return List<PsoYdChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsoYdChgVO> searchPsoYdChg(String lgsCostCd, String ydCd, String vndrSeq, String issDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoYdChgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (lgsCostCd != null && ydCd != null && vndrSeq != null && issDt != null) {
				param.put("lgs_cost_cd", lgsCostCd);
				param.put("yd_cd", ydCd);
				param.put("vndr_seq", vndrSeq);
				param.put("iss_dt", issDt);
				velParam.put("lgs_cost_cd", lgsCostCd);
				velParam.put("yd_cd", ydCd);
				velParam.put("vndr_seq", vndrSeq);
				velParam.put("iss_dt", issDt);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchPsoYdChgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PsoYdChgVO.class);
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
	 * Issue Date 가 변경 될 경우 Effective Date 를 조회한다.
	 * 
	 * @category VOP_PSO_0014_onChangeIssueDate
	 * @param String rcvDt
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchEffDateByIssDate(String rcvDt, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ofcCd != null && rcvDt != null) {
				param.put("ofc_cd", ofcCd);
				param.put("rcv_dt", rcvDt);
				velParam.put("ofc_cd", ofcCd);
				velParam.put("rcv_dt", rcvDt);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchEffDateByIssDateRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else {
				return "";
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
	 * VOP_PSO_0014 : Retrieve Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Retrieve Button Click 시 Invoice 내역을 조회 한다.<br />
	 * 
	 * @category VOP_PSO_0014_RetrieveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<InvAuditDataValidVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvAuditDataValidVO> searchGenInvAudit(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvAuditDataValidVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchGenInvAuditRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvAuditDataValidVO.class);
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
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 해당 내용을 삭제 처리를 한다.<br />
	 * 
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @return int
	 * @throws DAOException
	 */
	public int removeInvChargeDetail(String vndrSeq, String ydCd, String invNo) throws DAOException {
		int delCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			if (vndrSeq != null && ydCd != null && invNo != null) {
				param.put("vndr_seq", vndrSeq);
				param.put("yd_cd", ydCd);
				param.put("inv_no", invNo);
				velParam.put("vndr_seq", vndrSeq);
				velParam.put("yd_cd", ydCd);
				velParam.put("inv_no", invNo);

				delCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralInvoiceAuditDBDAOremoveInvChargeDetailDSQL(), param, velParam);
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
	 * VOP_PSO_0014 : Delete Button Click <br />
	 * Invoice Creation & Audit 화면에서 Delete Button Click 시 처리를 한다.<br />
	 * 
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @return int
	 * @throws DAOException
	 */
	public int removeInvCharge(String vndrSeq, String ydCd, String invNo) throws DAOException {
		int delCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			if (vndrSeq != null && ydCd != null && invNo != null) {
				param.put("vndr_seq", vndrSeq);
				param.put("yd_cd", ydCd);
				param.put("inv_no", invNo);
				velParam.put("vndr_seq", vndrSeq);
				velParam.put("yd_cd", ydCd);
				velParam.put("inv_no", invNo);

				delCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralInvoiceAuditDBDAOremoveInvChargeDSQL(), param, velParam);
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
	 * 해당 PSO_CHAGE 의 데이터 중 AP_PAY_INV.CSR_NO 값이 존재하는 가 확인 Invoice Creation &
	 * Audit 화면에서 Delete Button Click 시 처리를 한다.<br />
	 * 
	 * @category VOP_PSO_0014_DeleteButtonClick
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String invNo
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkApPayInv(String vndrSeq, String ydCd, String invNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		boolean bRet = false;
		try {
			if (vndrSeq != null && ydCd != null && invNo != null) {
				param.put("vndr_seq", vndrSeq);
				param.put("yd_cd", ydCd);
				param.put("inv_no", invNo);
				velParam.put("vndr_seq", vndrSeq);
				velParam.put("yd_cd", ydCd);
				velParam.put("inv_no", invNo);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOcheckApPayInvRSQL(), param, velParam);
			if (dbRowset.next()) {
				int i = dbRowset.getInt(1);
				bRet = i == 0 ? false : true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bRet;
	}

	/**
	 * VOP_PSO_0014 : Grid Account Cd Change <br />
	 * Invoice Creation & Audit 화면의 그리드에서 Account Code 변경 시 처리를 한다.<br />
	 * 
	 * @category VOP_PSO_0014_VvdLevelCheck
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkVvdLevel(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String strRet = "";
		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOcheckVvdLevelRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 저장처리를 한다.<br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param PsoChgDtlVO psoChgDtlVOs
	 * @throws DAOException
	 */
	public void addPsoChargeDetail(PsoChgDtlVO psoChgDtlVOs) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;

		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);

			Map<String, String> mapVO = psoChgDtlVOs.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate) new GeneralInvoiceAuditDBDAOaddPsoChargeDetailCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 해당 VVD 에 대한 PsoPortExpnDivRatio 가 졵재 하는 지 체크한다.
	 * 
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkPsoPortExpnDivRatio(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		boolean bRet = false;
		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOcheckVvdLevelRSQL(), param, velParam);
			if (dbRowset.next()) {
				bRet = dbRowset.getBoolean(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bRet;
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 해다 PORT별 VVD 의 IO
	 * Ration 정보를 조회한다.<br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<IoRatioVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<IoRatioVO> getIoRatio(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IoRatioVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetIoRatioRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IoRatioVO.class);
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
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 해다 PORT별 VVD 의 IO
	 * Ration 정보를 조회한다.<br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<IoRatioVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<IoRatioVO> getIoRatio(InvAuditDataValidVO invAuditDataValidVO, String existYn) throws DAOException {
		DBRowSet dbRowset = null;
		List<IoRatioVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				param.put("exist_yn", existYn);
				
				velParam.putAll(mapVO);
				velParam.put("exist_yn", existYn);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetIoRatioRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IoRatioVO.class);
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
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 Local Amount 를 USD 로
	 * Conversion 한다. <br />
	 * 
	 * @param String amount
	 * @param String currCd
	 * @param String issDt
	 * @param String type
	 * @return String
	 * @throws DAOException
	 */
	public String getUsdAmt(String amount, String currCd, String issDt, String type) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (amount != null && currCd != null && issDt != null) {
				param.put("locl_amt", amount);
				param.put("curr_cd", currCd);
				param.put("iss_dt", issDt);
				param.put("type", type);
				velParam.put("locl_amt", amount);
				velParam.put("curr_cd", currCd);
				velParam.put("iss_dt", issDt);
				velParam.put("type", type);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetUsdAmtRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 Amount 를 In/Out Bound 에
	 * 따라 Round , Trunc 하여 자릿수를 정한다. <br />
	 * 
	 * @param RoundTruncVO rtvo1in
	 * @return RoundTruncVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RoundTruncVO getRoundTruncAmt(RoundTruncVO roundTruncVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RoundTruncVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (roundTruncVO != null) {
				Map<String, String> mapVO = roundTruncVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRoundTruncAmtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RoundTruncVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 해당 Inv의 정보가 PSO_CHARGE
	 * 테이블에 존재하는지 확인한다. <br />
	 * 
	 * @param String ydCd
	 * @param String vndrSeq
	 * @param String invNo
	 * @return List<PsoChargeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsoChargeVO> isExistPsoCharge(String ydCd, String vndrSeq, String invNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoChargeVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invNo != null) {
				param.put("yd_cd", ydCd);
				param.put("vndr_seq", vndrSeq);
				param.put("inv_no", invNo);
				velParam.put("yd_cd", ydCd);
				velParam.put("vndr_seq", vndrSeq);
				velParam.put("inv_no", invNo);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOisExistPsoChargeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PsoChargeVO.class);
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
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 PSO_CHARGE 정보를 갱신한다. <br />
	 * 
	 * @param List<PsoChargeVO> psoChargeVOs
	 * @throws DAOException
	 */
	public void modifyPsoCharge(List<PsoChargeVO> psoChargeVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int updCnt[] = null;
			if (psoChargeVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralInvoiceAuditDBDAOmodifyPsoChargeUSQL(), psoChargeVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
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
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 Payment Term Days 및 Due
	 * Date 를 구한다. <br />
	 * 
	 * @param String vndrSeq
	 * @param String issDt
	 * @return List<TermDueVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TermDueVO> getTermDueDate(String vndrSeq, String issDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<TermDueVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vndrSeq != null && issDt != null) {
				param.put("vndr_seq", vndrSeq);
				param.put("iss_dt", issDt);
				velParam.put("vndr_seq", vndrSeq);
				velParam.put("iss_dt", issDt);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetTermDueDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TermDueVO.class);
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
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 PSO_CHG_DTL 정보를 갱신 한다. <br />
	 * 
	 * @param List<PsoChgDtlVO> psoChgDtlVOs
	 * @throws DAOException
	 */
	public void modifyPsoChargeDetail(List<PsoChgDtlVO> psoChgDtlVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int updCnt[] = null;
			if (psoChgDtlVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralInvoiceAuditDBDAOmodifyPsoChargeDetailUSQL(), psoChgDtlVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
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
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 PSO_CHG_DTL 정보를 삭제 한다. <br />
	 * 
	 * @param List<PsoChgDtlVO> psoChgDtlVOs
	 * @throws DAOException
	 */
	public void removePsoChargeDetail(List<PsoChgDtlVO> psoChgDtlVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int updCnt[] = null;
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (psoChgDtlVOs.size() > 0) {
				velParam.put("ibflag", psoChgDtlVOs.get(0).getIbflag());
				updCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralInvoiceAuditDBDAOremovePsoChargeDetailDSQL(), psoChgDtlVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No" + i + " SQL");
				}
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
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 처리를 한다.<br />
	 * 
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPsoChargeStaus(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		int iCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			iCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralInvoiceAuditDBDAOmodifyPsoChargeStausUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return iCnt;
	}

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV 에 저장 할 정보를
	 * 조회한다. <br />
	 * 
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ApPayInvVO searchApPayInv(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApPayInvVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchApPayInvRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}

	/**
	 * VOP_PSO_0014 : Confirm Button Click <br />
	 * Invoice Creation & Audit 화면의 Confirm Button 클릭 시 AP_PAY_INV_DTL VO 에 저장할
	 * 정보를 조회한다.<br />
	 * 
	 * @category VOP_PSO_0014_ConfirmButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return ApPayInvDtlVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ApPayInvDtlVO[] searchApPayInvDtl(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<ApPayInvDtlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ApPayInvDtlVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		ApPayInvDtlVO[] rtvos = new ApPayInvDtlVO[list.size()];
		for (int i = 0; i < list.size(); i++) {
			rtvos[i] = list.get(i);
		}
		return rtvos;
	}

	/**
	 * case 80://LastPort Tariff 비용 계산을 위해 LastPort 를 구한다. /*"select
	 * SUBSTR(MAX(A.vps_Etd_dt||NVL(A.yd_cd,A.vps_Port_cd||' ')),-7,7) from
	 * vsk_vsl_port_skd A, ( select slan_cd, vsl_cd, vps_port_cd, vps_etd_dt
	 * from vsk_vsl_port_skd where vsl_cd = 'HYST' and skd_voy_no ='1407' and
	 * skd_dir_cd = 'E' and yd_cd = @yd_cd --and vps_port_cd = (YD_CD)--'KRPUS'
	 * ) B where A.vps_etd_dt < B.vps_Etd_dt and A.vsl_cd = B.vsl_cd and
	 * A.slan_cd = B.slan_cd"
	 * 
	 * @category Obj80_LastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getLastPort(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		// GeneralInvoiceAuditDBDAO
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLastPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Next Port Tariff 비용 계산을 위해 Next Port 를 구한다. SELECT SUBSTR (MIN
	 * (a.vps_etd_dt || NVL (a.yd_cd, a.vps_port_cd || ' ')), -7, 7 ) FROM
	 * vsk_vsl_port_skd a, (SELECT slan_cd, vsl_cd, vps_port_cd, vps_etd_dt FROM
	 * vsk_vsl_port_skd WHERE vsl_cd = 'HYST' AND skd_voy_no = '1407' AND
	 * skd_dir_cd = 'E' AND vps_port_cd = 'KRPUS') b WHERE a.vps_etd_dt >
	 * b.vps_etd_dt AND a.vsl_cd = b.vsl_cd AND a.slan_cd = b.slan_cd
	 * 
	 * @category Obj85_NextPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getNextPort(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		// GeneralInvoiceAuditDBDAO
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetNextPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * //sameVvd Tariff 비용 계산을 위해 동일 항차에 동일 Yard 를 Calling 하는지 여부를 구한다.
	 * 
	 * SELECT 'Y' --SUBSTR(MIN(A.vps_Etd_dt||NVL(A.yd_cd,A.vps_Port_cd||'
	 * ')),-7,7) FROM vsk_vsl_port_skd a, vsk_vsl_port_skd b, pso_charge p,
	 * pso_chg_dtl d WHERE a.vsl_cd = b.vsl_cd AND a.skd_voy_no = b.skd_voy_no
	 * AND a.skd_dir_cd = b.skd_dir_cd AND a.vps_port_cd = b.vps_port_cd AND
	 * b.vps_port_cd = 'KRPUS' AND b.clpt_ind_seq = 1 AND a.vps_etd_dt <
	 * b.vps_etd_dt AND p.iss_cty_cd = d.iss_cty_cd AND p.so_seq = d.so_seq AND
	 * a.vsl_cd = d.vsl_cd AND a.skd_voy_no = d.skd_voy_no AND a.skd_dir_cd =
	 * d.skd_dir_cd AND a.yd_cd = p.yd_cd AND a.vsl_cd = 'HYST' AND a.skd_voy_no
	 * = '1407' AND a.skd_dir_cd = 'E' //AND d.lgs_cost_cd = 'PTDUCQ'
	 * 
	 * @category Obj95_sameVvd
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String getSameVvd(String vvd, String ydCd) throws DAOException {
		// GeneralInvoiceAuditDBDAO
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetSameVvdRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/*
	 * CHM-201007037-01
	 */
	/**
	 * * 39:// Ship Unit Tariff 비용 계산을 위해 Ship Unit 를 구한다. // SELECT
	 * round((nvl(LOA_LEN,0)*3.28) * (nvl(VSL_DPTH,0)*3.28) *
	 * (nvl(VSL_WDT,0)*3.28) /10000 , 4) shitunit // FROM MDM_VSL_CNTR // WHERE
	 * VSL_CD = 'HJBH'
	 * 
	 * @category Obj39_ShitUnit
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getShipUnit(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetShipUnitRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/*
	 * CHM-201007037-01
	 */
	/**
	 * 99://ShipUnitOne Tariff 비용 계산을 위해 Ship Unit 를 구한다. // SELECT
	 * round((nvl(LOA_LEN,0)*3.28) * (nvl(VSL_DPTH,0)*3.28) *
	 * (nvl(VSL_WDT,0)*3.28) /10000 , 4) shitunit // FROM MDM_VSL_CNTR // WHERE
	 * VSL_CD = 'HJBH'
	 * 
	 * @category Obj99_ShipUnit1
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getShipUnitOne(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetShipUnitOneRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 100://Summer Draft(F) Tariff 비용 계산을 위해 Summer Draft(F) 를 구한다. // select
	 * NVL(SMR_DRFT_HGT,0 ) * 3.28 // from mdm_vsl_cntr // where vsl_cd = 'COZY'
	 * 
	 * @category Obj100_SmmrDftF
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getSmmrDftF(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetSmmrDftFRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 101://Summer Draft(M) Tariff 비용 계산을 위해 Summer Draft(M) 를 구한다. // select
	 * NVL(SMR_DRFT_HGT,0 ) // from mdm_vsl_cntr // where vsl_cd = 'COZY'
	 * 
	 * @category Obj101_SmmrDftM
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getSmmrDftM(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null) {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetSmmrDftMRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * rlane_cd 정보를 조회한다.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String port
	 * @return String
	 * @throws DAOException
	 */
	public String getRlaneCd(String vslCd, String skdVoyNo, String skdDirCd, String port) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vslCd != null) {
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("port", port);
				velParam.put("vsl_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("port", port);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRlaneCdRSQL(), param, velParam);
			if (dbRowset.next())
				strRet = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * 해당 VVD의 포트가 Turning Port인지 확인한다.
	 * 
	 * @param String hvvd
	 * @param String tmnlCode
	 * @param String clptIndSeq
	 * @return boolean
	 * @throws DAOException
	 * */
	public boolean checkTurningPort(String hvvd, String tmnlCode, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		boolean bRet = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hvvd != null) {
				param.put("vvd", hvvd);
				param.put("yd_cd", tmnlCode);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", hvvd);
				velParam.put("yd_cd", tmnlCode);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOcheckTurningPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				String strRet = dbRowset.getString(1);
				if (strRet.equals("1"))
					bRet = false;
				else
					bRet = true;
			} else {
				bRet = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bRet;
	}

	/**
	 * 114://SDR Tariff 비용 계산을 위해 SDR 를 구한다. //select
	 * NVL(Substr(Max(to_char(cre_dt,'YYYYMMDDHH24MI')||locl_xch_rt),13),1) //
	 * from pso_cnl_tz_fee // where pso_bztp_cd = 5 // and cnl_tz_bztp_cd = 'I'
	 * //우선 외부에서 설정된 SDR이 있는지 확인
	 * 
	 * @category Obj114_SDR
	 * @return String
	 * @throws DAOException
	 */
	public String getSdr() throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";

		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetSdrRSQL(), null, null);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 81:// LOA 1 case 82:// LOA 2 case 83:// LOA 3 Tariff 비용 계산을 위해 LOA 를
	 * 구한다. //SELECT LOA_LEN FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * 
	 * @category Obj8123_LOA
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getLoa(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLoaRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 87://NRT1 Tariff 비용 계산을 위해 NRT 를 구한다. //SELECT NET_RGST_TONG_WGT
	 * FROM MDM_VSL_CNTR WHERE VSL_CD = 'BAHX'
	 * 
	 * @category Obj87_NRT1
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getNrtOne(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetNrtOneRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 94://Monthly Vessel Call Tariff 비용 계산을 위해 동일 월에 Vessel 이 몇번
	 * Calling 횟수를 구한다. // select count(*) // from vsk_vsl_port_skd // where
	 * vsl_cd = 'AMIS' // and vps_port_cd = 'USSAV' --Yard 7자리에서 5자리만 // and
	 * NVL(SKD_CNG_STS_CD,'X') <> 'S' // and vps_etb_dt <= (select
	 * max(vps_etb_dt) from vsk_vsl_port_skd // where vsl_cd = 'AMIS' // and
	 * skd_voy_no = '0977' // and skd_dir_cd = 'E' // and vps_port_cd = 'USSAV'
	 * // ) // and to_char(vps_etb_dt,'YYYYMM') = (select
	 * max(to_char(vps_etb_dt,'YYYYMM')) from vsk_vsl_port_skd // where vsl_cd =
	 * 'AMIS' // and skd_voy_no = '0977' // and skd_dir_cd = 'E' // and
	 * vps_port_cd = 'USSAV' // )
	 * 
	 * @category Obj94_MonthlyVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getMonthlyVesselCall(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetMonthlyVesselCallRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 96://Yearly Vessel Call Tariff 비용 계산을 위해 동일 년도에 Vessel 이 몇번
	 * Calling 횟수를 구한다. // select count(*) // from vsk_vsl_port_skd // where
	 * vsl_cd = 'AMIS' // and vps_port_cd = 'USSAV' --Yard 7자리에서 5자리만 // and
	 * NVL(SKD_CNG_STS_CD,'X') <> 'S' // and vps_etb_dt <= (select
	 * max(vps_etb_dt) from vsk_vsl_port_skd // where vsl_cd = 'AMIS' // and
	 * skd_voy_no = '0977' // and skd_dir_cd = 'E' // and vps_port_cd = 'USSAV'
	 * // ) // and to_char(vps_etb_dt,'YYYY') = (select
	 * max(to_char(vps_etb_dt,'YYYY')) from vsk_vsl_port_skd // where vsl_cd =
	 * 'AMIS' // and skd_voy_no = '0977' // and skd_dir_cd = 'E' // and
	 * vps_port_cd = 'USSAV' // )
	 * 
	 * @category Obj96_YearlyVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getYearlyVesselCall(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetYearlyVesselCallRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 133://Yearly Vessel Call Lane Tariff 비용 계산을 위해 동일 년도에 동일 Lane 이 몇번
	 * Calling 횟수를 구한다. //SELECT NVL(COUNT(*),0) //FROM VSK_VSL_PORT_SKD //WHERE
	 * 1=1 //AND SLAN_CD = (SELECT MAX(SLAN_CD) // FROM VSK_VSL_PORT_SKD //
	 * WHERE 1=1 // AND VSL_CD = 'AMIS' // AND SKD_VOY_NO = '0977' // AND
	 * SKD_DIR_CD = 'E' // ) //AND VPS_PORT_CD = 'USSAV' //AND
	 * NVL(SKD_CNG_STS_CD,'X') <> 'S' //AND VPS_ETB_DT <= (SELECT
	 * MAX(VPS_ETB_DT) // FROM VSK_VSL_PORT_SKD // WHERE 1=1 // AND VSL_CD =
	 * 'AMIS' // AND SKD_VOY_NO = '0977' // AND SKD_DIR_CD = 'E' // AND
	 * VPS_PORT_CD = 'USSAV' // ) //AND TURN_PORT_IND_CD IN ('N','Y') //AND
	 * TO_CHAR(VPS_ETB_DT,'YYYY') = (SELECT MAX(TO_CHAR(VPS_ETB_DT,'YYYY')) //
	 * FROM VSK_VSL_PORT_SKD // WHERE 1=1 // AND VSL_CD = 'AMIS' // AND
	 * SKD_VOY_NO = '0977' // AND SKD_DIR_CD = 'E' // AND VPS_PORT_CD ='USSAV'
	 * // )
	 * 
	 * @category Obj133_YearlyVesselCallLane
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getYearlyVesselCallLane(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetYearlyVesselCallLaneRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 47://Arrival Draft Meter Tariff 비용 계산을 위해 Arrival Draft Meter 를 구한다.
	 * // SELECT MAX(ARR_AFTDR_HGT) * 3.28 // FROM VSK_VSL_PORT_SKD A,
	 * VSK_ACT_PORT_SKD B // WHERE A.VSL_CD = B.VSL_CD // AND A.SKD_VOY_NO =
	 * B.SKD_VOY_NO // AND A.SKD_DIR_CD = B.SKD_DIR_CD // AND A.VPS_PORT_CD =
	 * B.VPS_PORT_CD // AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ // AND A.VSL_CD =
	 * 'CXMH' // AND A.SKD_VOY_NO = '0801' // AND A.SKD_DIR_cD = 'E' // AND
	 * A.YD_CD = 'SGSINKA'
	 * 
	 * @category Obj47_ArrivalDraftMeter
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getArvDrftMeter(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArvDrftMeterRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 48://Arrival Draft 1 Meter Tariff 비용 계산을 위해 Arrival Draft Meter 를
	 * 구한다. // SELECT MAX(ARR_AFTDR_HGT) * 3.28 // FROM VSK_VSL_PORT_SKD A,
	 * VSK_ACT_PORT_SKD B // WHERE A.VSL_CD = B.VSL_CD // AND A.SKD_VOY_NO =
	 * B.SKD_VOY_NO // AND A.SKD_DIR_CD = B.SKD_DIR_CD // AND A.VPS_PORT_CD =
	 * B.VPS_PORT_CD // AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ // AND A.VSL_CD =
	 * 'CXMH' // AND A.SKD_VOY_NO = '0801' // AND A.SKD_DIR_cD = 'E' // AND
	 * A.YD_CD = 'SGSINKA'
	 * 
	 * @category Obj48_ArrivalDraft1Meter
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getArvDrftOneMeter(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArvDrftOneMeterRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 49://Arrival Draft1 Feet Tariff 비용 계산을 위해 Arrival Draft Feet 를 구한다.
	 * SELECT MAX(ARR_AFTDR_HGT) FROM VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B
	 * WHERE A.VSL_CD = B.VSL_CD AND A.SKD_VOY_NO = B.SKD_VOY_NO AND
	 * A.SKD_DIR_CD = B.SKD_DIR_CD AND A.VPS_PORT_CD = B.VPS_PORT_CD AND
	 * A.CLPT_IND_SEQ = B.CLPT_IND_SEQ AND A.VSL_CD = 'CXMH' AND A.SKD_VOY_NO =
	 * '0801' AND A.SKD_DIR_cD = 'E' AND A.YD_CD = 'SGSINKA'
	 * 
	 * @category Obj49_ArrivalDraft1Feet
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getArvDrftOneFeet(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArvDrftOneFeetRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 51: //Arrival POB // select ROUND((BERTH - PILOT_ARR)*24,1) // FROM
	 * TDR_HEADER // where vsl_cd = 'HJBH' // and VOY_NO = '0021' // and DIR_CD=
	 * 'W' // and PORT_CD = 'KRPUS'
	 * 
	 * @category Obj51_ArrPob
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getArrPob(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetArrPobRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 61: //Departure POB // SELECT ROUND((PILOT_DEP - UNBERTH)*24,1) //
	 * FROM TDR_HEADER // where vsl_cd = 'HJBH' // and VOY_NO = '0021' // and
	 * DIR_CD= 'W' // and PORT_CD = 'KRPUS'
	 * 
	 * @category Obj61_DepPob
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getDepPob(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDepPobRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 55://Bound Tariff 비용 계산을 위해 Bound 를 구한다. SELECT NVL(SVC_SCP_BND_CD,
	 * CASE WHEN SUBSTR(:yd_cd, 1, 5)='EGSCA' AND A.SKD_DIR_CD='W' THEN 'N' WHEN
	 * SUBSTR(:yd_cd, 1, 5)='EGSCA' AND A.SKD_DIR_CD='E' THEN 'S' WHEN
	 * SUBSTR(:yd_cd, 1, 5)='PAPCA' AND A.SKD_DIR_CD='W' THEN 'S' WHEN
	 * SUBSTR(:yd_cd, 1, 5)='PAPCA' AND A.SKD_DIR_CD='E' THEN 'N' END) AS
	 * SVC_SCP_BND_CD FROM VSK_VSL_SKD A, MDM_VSL_SVC_LANE_DIR B WHERE 1=1 AND
	 * A.SKD_DIR_CD = B.VSL_SLAN_DIR_CD AND A.VSL_SLAN_CD = B.VSL_SLAN_CD AND
	 * A.VSL_CD = SUBSTR(:vvd, 1, 4) AND A.SKD_VOY_NO = SUBSTR(:vvd, 5, 4) AND
	 * A.SKD_DIR_CD = SUBSTR(:vvd, 9)
	 * 
	 * @category Obj55_Bound
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String getBound(String vvd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBoundRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 56://Bunker Volume Tariff 비용 계산을 위해 Bunker Volume 를 구한다. select
	 * NVL(FOIL_CAPA,0) + NVL(DOIL_CAPA,0) from mdm_vsl_cntr where vsl_cd =
	 * 'HJNA'
	 * 
	 * @category Obj56_BkerVol
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getBkerVol(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBkerVolRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 64://DWT Tariff 비용 계산을 위해 DWT 를 구한다. select NVL(DWT_WGT,0) from
	 * mdm_vsl_cntr where vsl_cd = 'HJNA'
	 * 
	 * @category Obj64_Dwt
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getDwt(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDwtRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 58://Carrier Tariff 비용 계산을 위해 Vessel의 Carrier 를 구한다. select CRR_CD
	 * from mdm_vsl_cntr where VSL_CD = 'CXMH'
	 * 
	 * @category Obj58_Carrier
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getCarrier(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetCarrierRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 26: //Departure Draft Feet Tariff 비용 계산을 위해 Departure Draft Feet 를
	 * 구한다. SELECT MAX(DEP_AFTDR_HGT)*3.28 FROM VSK_VSL_PORT_SKD A,
	 * VSK_ACT_PORT_SKD B WHERE A.VSL_CD = B.VSL_CD AND A.SKD_VOY_NO =
	 * B.SKD_VOY_NO AND A.SKD_DIR_CD = B.SKD_DIR_CD AND A.VPS_PORT_CD =
	 * B.VPS_PORT_CD AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ AND A.VSL_CD = 'CXMH'
	 * AND A.SKD_VOY_NO = '0801' AND A.SKD_DIR_cD = 'E' AND A.YD_CD = 'SGSINKA'
	 * 
	 * @category Obj26_DepartureDraftFeet
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getDprDftFeet(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDprDftFeetRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 27: //Garbage Volume Tariff 비용 계산을 위해 Garbage Volume 를 구한다.
	 * 
	 * @category Obj27_GarbageVol
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getGarbageVol(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetGarbageVolRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 40: //Sludge Volume Tariff 비용 계산을 위해 Sludge Volume 를 구한다.
	 * 
	 * @category Obj40_SludgeVol
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getSludgeVol(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetSludgeVolRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 36: //No. of Crew Tariff 비용 계산을 위해 No. of Crew 를 구한다. // SELECT NVL
	 * (crw_knt, 0) // FROM mdm_vsl_Cntr // WHERE VSL_CD = 'CXMH'
	 * 
	 * @category Obj36_NoOfCrew
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getNoOfCrew(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetNoOfCrewRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * 63://Design Capacity Tariff 비용 계산을 위해 해당 Vessel 의 Design Capacity 를 구한다.
	 * // SELECT CNTR_DZN_CAPA // FROM mdm_vsl_cntr // WHERE VSL_CD = 'CXMH'
	 * 
	 * @category Obj63_DesigCapacity
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getDesignCapacity(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDesignCapacityRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 66://ETB Month Tariff 비용 계산을 위해 해당 ETB 의 월를 구한다. // SELECT
	 * TO_NUMBER (TO_CHAR (VPS_ETB_DT, 'MM'), '00') // FROM VSK_VSL_PORT_SKD //
	 * WHERE VSL_CD = 'BAHX' // AND SKD_VOY_NO = '0036' // AND SKD_DIR_CD = 'E'
	 * // AND YD_CD = 'KRPUSY1'
	 * 
	 * @category Obj66_EtbMonth
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtbMonth(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtbMonthRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 67, 68://ETB Time Tariff 비용 계산을 위해 해당 ETB 의 Time를 구한다. // SELECT TO_CHAR
	 * (VPS_ETB_DT, 'HH24MI') // FROM VSK_VSL_PORT_SKD // WHERE VSL_CD = 'BAHX'
	 * // AND SKD_VOY_NO = '0036' // AND SKD_DIR_CD = 'E' // AND YD_CD =
	 * 'KRPUSY1'
	 * 
	 * @category Obj67_EtbTime
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtbTime(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtbTimeRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 149: ETA Time case 150: ETA1 Time Tariff 비용 계산을 위해 해당 ETA 의 Time를
	 * 구한다.
	 * 
	 * @category Obj149_EtaTime
	 * @category Obj150_Eta1Time
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtaTime(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtaTimeRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/*
	 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
	 */
	/**
	 * case 69://ETD Date Tariff 비용 계산을 위해 해당 ETB 의 요일을 구한다. // SELECT TO_CHAR
	 * (VPS_ETD_DT, 'YYYYMMDD') // FROM VSK_VSL_PORT_SKD // WHERE VSL_CD =
	 * 'BAHX' // AND SKD_VOY_NO = '0036' // AND SKD_DIR_CD = 'E' // AND YD_CD =
	 * 'KRPUSY1'
	 * 
	 * @category Obj69_EtdDate
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtdDate(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtdDateRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 70://ETD Month Tariff 비용 계산을 위해 해당 ETD의 월을 구한다. // SELECT TO_NUMBER
	 * (TO_CHAR (VPS_ETD_DT, 'MM'), '00') // FROM VSK_VSL_PORT_SKD // WHERE
	 * VSL_CD = 'BAHX' // AND SKD_VOY_NO = '0036' // AND SKD_DIR_CD = 'E' // AND
	 * YD_CD = 'KRPUSY1'
	 * 
	 * @category Obj70_EtdMonth
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtdMonth(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtdMonthRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 76:I/B Volume/Blocksize Tariff 비용 계산을 위해 해당 I/B 의 Volume/Blocksize를
	 * 구한다. select ROUND(VOL / (NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) *
	 * NVL(SMR_DRFT_HGT, 0)), 4) FROM ( SELECT V.VSL_CD, NVL(
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0)))+
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) , 0 ) VOL
	 * FROM VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S WHERE V.VSL_CD =
	 * 'HJNA' --:vsl_cd AND V.SKD_VOY_NO = '0071' --:skd_voy_no AND V.SKD_DIR_CD
	 * = 'E' --:skd_dir_cd AND V.YD_CD = 'FRLEHY5' --:port_cd AND V.VSL_CD =
	 * H.VSL_CD AND V.SKD_VOY_NO = H.VOY_NO AND V.SKD_DIR_CD = H.DIR_CD AND
	 * V.VPS_PORT_CD = H.PORT_CD AND V.CLPT_IND_SEQ = H.CALL_IND AND H.VSL_CD =
	 * S.VSL_CD AND H.VOY_NO = S.VOY_NO AND H.DIR_CD = S.DIR_CD AND H.PORT_CD =
	 * S.PORT_CD AND H.CALL_IND = S.CALL_IND AND S.STATUS IN ('DS','DT') GROUP
	 * BY V.VSL_CD ) A, MDM_VSL_CNTR M WHERE A.VSL_CD = M.VSL_CD
	 * 
	 * @category Obj76_IBVolBsz
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getIBVolBsz(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetIBVolBszRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 88:O/B Volume/Blocksize Tariff 비용 계산을 위해 해당 O/B 의 Volume/Blocksize를
	 * 구한다. select ROUND(VOL / (NVL(LOA_LEN, 0) * NVL(VSL_WDT, 0) *
	 * NVL(SMR_DRFT_HGT, 0)), 4) FROM (
	 * 
	 * SELECT V.VSL_CD, NVL( SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0)))+
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'LS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LM',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LM',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LM',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'LS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LM',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LM',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) , 0 ) VOL
	 * FROM VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S WHERE V.VSL_CD =
	 * 'HJNA' --:vsl_cd AND V.SKD_VOY_NO = '0071' --:skd_voy_no AND V.SKD_DIR_CD
	 * = 'E' --:skd_dir_cd AND V.YD_CD = 'FRLEHY5' --:port_cd AND V.VSL_CD =
	 * H.VSL_CD AND V.SKD_VOY_NO = H.VOY_NO AND V.SKD_DIR_CD = H.DIR_CD AND
	 * V.VPS_PORT_CD = H.PORT_CD AND V.CLPT_IND_SEQ = H.CALL_IND AND H.VSL_CD =
	 * S.VSL_CD AND H.VOY_NO = S.VOY_NO AND H.DIR_CD = S.DIR_CD AND H.PORT_CD =
	 * S.PORT_CD AND H.CALL_IND = S.CALL_IND AND S.STATUS IN ('LS','LM') GROUP
	 * BY V.VSL_CD ) A, MDM_VSL_CNTR M WHERE A.VSL_CD = M.VSL_CD
	 * 
	 * @category Obj88_IBVolBsz
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String getOBVolBsz(String vvd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetOBVolBszRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 71://ETD Time Tariff 비용 계산을 위해 해당 ETD의 Time을 구한다. case 72://ETD1
	 * Time // SELECT TO_CHAR (VPS_ETD_DT, 'HH24MI') // FROM VSK_VSL_PORT_SKD //
	 * WHERE VSL_CD = 'BAHX' AND SKD_VOY_NO = '0036' AND SKD_DIR_CD = 'E'
	 * 
	 * @category Obj71_EtdTime
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtdTime(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtdTimeRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 120://DEM/DET Holiday(ETB) 해당 ETB의 Holiday/휴일 여부를 구한다. // SELECT
	 * MAX(NVL(DD,'N')) // FROM // ( // -- 휴일 등록을 한경우 // SELECT 'Y' DD // FROM
	 * DMT_HOLIDAY D, VSK_VSL_PORT_SKD V // WHERE NVL(lOC_CD,VPS_PORT_CD) =
	 * VPS_PORT_CD // AND HOL_YR = SUBSTR(VPS_ETB_DT, 1, 4) // AND CNT_CD =
	 * SUBSTR(VPS_PORT_CD,1,2) // AND STE_CD = NVL((SELECT STE_CD FROM
	 * mdm_location WHERE loc_cd = 'KRPUS' ), STE_CD) // AND HOL_DT =
	 * TRUNC(VPS_ETB_DT) --TO_DATE(SUBSTR(VPS_ETB_DT, 1, 8), 'YYYYMMDD') // AND
	 * VSL_CD = 'HJMT' // AND SKD_VOY_NO = '0146' // AND SKD_DIR_CD = 'E' // AND
	 * VPS_PORT_CD = 'CNNBO' // // UNION ALL // // SELECT CASE WHEN WKND_TP_CD =
	 * 'TF' THEN // DECODE(TO_CHAR(VPS_ETB_DT,'D'),5,'Y',6,'Y','N' ) // WHEN
	 * WKND_TP_CD = 'FS' THEN // DECODE(TO_CHAR(VPS_ETB_DT,'D'),6,'Y',7,'Y','N'
	 * ) // ELSE // DECODE(TO_CHAR(VPS_ETB_DT,'D'),7,'Y',8,'Y','N') // END DD //
	 * FROM DMT_WEEKEND D, VSK_VSL_PORT_SKD V // WHERE D.CNT_CD(+) =
	 * SUBSTR(V.VPS_PORT_CD,1,2) // AND VSL_CD = 'HJMT' // AND SKD_VOY_NO =
	 * '0146' // AND SKD_DIR_CD = 'E' // AND VPS_PORT_CD = 'CNNBO' // // )
	 * 
	 * @category Obj120_EtbMonth
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getDemdetHolidayETB(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDemdetHolidayETBRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 121://DEM/DET Holiday(ETA) 해당 ETA의 Holiday/휴일 여부를 구한다.
	 * 
	 * @category Obj153_DemdetHolidayETA
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getDemdetHolidayETA(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDemdetHolidayETARSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 152://DEM/DET Holiday(ETD) 해당 ETD의 Holiday/휴일 여부를 구한다.
	 * 
	 * @category Obj121_DemdetHolidayETD
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getDemdetHolidayETD(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDemdetHolidayETDRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 122://Ownership 해당 Vessel의 Owner가 자사이면 Y, Charter이면 N을 리턴한다.
	 * SELECT distinct DECODE(VSL_OWN_IND_CD,'O','Y','N') FROM MDM_VSL_CNTR
	 * WHERE VSL_CD = SUBSTR('EMTX0001N',1,4)
	 * 
	 * @category Obj122_Ownership
	 * @param String
	 *            vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getOwnrship(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetOwnrshipRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 123://ETB(H) 해당 ETB의 Hour만 리턴한다. SELECT TO_CHAR(VPS_ETB_DT,
	 * 'HH24') FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO =
	 * '0146' AND SKD_DIR_CD = 'E' AND YD_CD = 'KRPUSHN'
	 * 
	 * @category Obj123_ETD(H)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtbHr(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtbHrRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 124://ETD(H) 해당 ETD의 Hour만 리턴한다. SELECT TO_CHAR(VPS_ETD_DT,
	 * 'HH24') FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT' AND SKD_VOY_NO =
	 * '0146' AND SKD_DIR_CD = 'E' AND YD_CD = 'KRPUSHN'
	 * 
	 * @category Obj124_ETD(H)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtdHr(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtdHrRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Object 의 Value 값이 없는 경우 Regular Value값 을 구한다.
	 * 
	 * @category getRegularValue
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String objListNo
	 * @return String
	 * @throws DAOException
	 */
	public String getRegularValue(String ydChgNo, String ydChgVerSeq, String objListNo) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ydChgNo != null && ydChgVerSeq != null && objListNo != null) {
				param.put("yd_chg_no", ydChgNo);
				param.put("yd_chg_ver_seq", ydChgVerSeq);
				param.put("obj_list_no", objListNo);
				velParam.put("yd_chg_no", ydChgNo);
				velParam.put("yd_chg_ver_seq", ydChgVerSeq);
				velParam.put("obj_list_no", objListNo);

			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRegularValueRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Batch 모듈 추정에서 사용되는 환율 구하기
	 * 
	 * @param String strLocalAmt
	 * @param String currCd
	 * @param String revYrmon
	 * @return String
	 * @throws DAOException
	 */
	public String getUsdAmtBudget(String strLocalAmt, String currCd, String revYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (strLocalAmt != null && currCd != null && revYrmon != null) {
				param.put("locl_amt", strLocalAmt);
				param.put("locl_curr_cd", currCd);
				param.put("bud_scnr_no", revYrmon);
				velParam.put("locl_amt", strLocalAmt);
				velParam.put("locl_curr_cd", currCd);
				velParam.put("bud_scnr_no", revYrmon);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetUsdAmtBudgetRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * IO Ratio를 구하지 못한 경우 RLANE_CD와 RLANE_DIR_CD를 구한다. 2009.11.26. 추가 Logic
	 * 
	 * 2016.08.24 Modify
	 * -clptIndSeq 추가.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getRevLaneDir(String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vslCd != null && skdVoyNo != null && skdDirCd != null && ydCd != null) {
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vslCd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("yd_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRevLaneDirRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 32://Inbound Volume Tariff 비용 계산을 위해 해당 TDR 에서 Inbound Volume을
	 * 구한다. /** SELECT NVL( SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'2',QTY,0),0)))+
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'H',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'2',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'3',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'DT',DECODE(S.CNTR_SIZE,'4',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'H',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'L',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'4',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'2',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'DT',DECODE(S.CNTR_SIZE,'3',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'4',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'H',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'DT',DECODE(S.CNTR_SIZE,'L',QTY,0),0),0)) , 0 ) FROM
	 * VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S WHERE V.VSL_CD = 'HJWS'
	 * --:vsl_cd AND V.SKD_VOY_NO = '0099' --:skd_voy_no AND V.SKD_DIR_CD = 'W'
	 * --:skd_dir_cd AND V.YD_CD = 'USPDXM1' --:port_cd AND V.VSL_CD = H.VSL_CD
	 * AND V.SKD_VOY_NO = H.VOY_NO AND V.SKD_DIR_CD = H.DIR_CD AND V.VPS_PORT_CD
	 * = H.PORT_CD AND V.CLPT_IND_SEQ = H.CALL_IND AND H.VSL_CD = S.VSL_CD AND
	 * H.VOY_NO = S.VOY_NO AND H.DIR_CD = S.DIR_CD AND H.PORT_CD = S.PORT_CD AND
	 * H.CALL_IND = S.CALL_IND AND S.STATUS IN ('DS','DT')
	 * 
	 * @category Obj32_InboundVolume
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getInboundVolume(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetInboundVolumeRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 33://Outbound Volume Tariff 비용 계산을 위해 해당 TDR 에서 ,Outbound Volume을
	 * 구한다. SELECT NVL( SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'2',QTY,0),0)))+
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'LS',DECODE(S.CNTR_SIZE,'3',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'4',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'H',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'LS',DECODE(S.CNTR_SIZE,'L',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'LT',DECODE(S.CNTR_SIZE,'2',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'3',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'LT',DECODE(S.CNTR_SIZE,'4',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'LT',DECODE(S.CNTR_SIZE,'H',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'L',QTY,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'LS',DECODE(S.CNTR_SIZE,'2',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'3',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'4',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'LS',DECODE(S.CNTR_SIZE,'H',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'L',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'2',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'LT',DECODE(S.CNTR_SIZE,'3',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'LT',DECODE(S.CNTR_SIZE,'4',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'H',QTY,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'LT',DECODE(S.CNTR_SIZE,'L',QTY,0),0),0)) , 0 ) FROM
	 * VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S WHERE V.VSL_CD = 'HJWS'
	 * --:vsl_cd AND V.SKD_VOY_NO = '0099' --:skd_voy_no AND V.SKD_DIR_CD = 'W'
	 * --:skd_dir_cd AND V.YD_CD = 'USPDXM1' --:port_cd AND V.VSL_CD = H.VSL_CD
	 * AND V.SKD_VOY_NO = H.VOY_NO AND V.SKD_DIR_CD = H.DIR_CD AND V.VPS_PORT_CD
	 * = H.PORT_CD AND V.CLPT_IND_SEQ = H.CALL_IND AND H.VSL_CD = S.VSL_CD AND
	 * H.VOY_NO = S.VOY_NO AND H.DIR_CD = S.DIR_CD AND H.PORT_CD = S.PORT_CD AND
	 * H.CALL_IND = S.CALL_IND AND S.STATUS IN ('LS','LT')
	 * 
	 * @category Obj33_OutbundVolume
	 * @param vvd
	 * @param ydCd
	 * @param clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getOutboundVolume(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetOutboundVolumeRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 126://Inbound Ton Tariff 비용 계산을 위해 해당 TDR 에서 Inbound Ton(Weight)을
	 * 구한다. SELECT NVL( SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0)))+
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'DT',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'DT',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) , 0 ) FROM
	 * VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S WHERE V.VSL_CD = 'HJWS'
	 * --:vsl_cd AND V.SKD_VOY_NO = '0099' --:skd_voy_no AND V.SKD_DIR_CD = 'W'
	 * --:skd_dir_cd AND V.YD_CD = 'USPDXM1' --:port_cd AND V.VSL_CD = H.VSL_CD
	 * AND V.SKD_VOY_NO = H.VOY_NO AND V.SKD_DIR_CD = H.DIR_CD AND V.VPS_PORT_CD
	 * = H.PORT_CD AND V.CLPT_IND_SEQ = H.CALL_IND AND H.VSL_CD = S.VSL_CD AND
	 * H.VOY_NO = S.VOY_NO AND H.DIR_CD = S.DIR_CD AND H.PORT_CD = S.PORT_CD AND
	 * H.CALL_IND = S.CALL_IND AND S.STATUS IN ('DS','DT')
	 * 
	 * @category Obj126_InboundTon
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getInboundTon(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetInboundTonRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 127://Outbound Ton Tariff 비용 계산을 위해 해당 TDR 에서 ,Outbound Ton(Weight)을
	 * 구한다. SELECT NVL( SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0)))+
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE
	 * (S.STATUS,'LS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',0,DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'LT',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,
	 * DECODE(S.STATUS,'LT',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0))) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE
	 * (S.STATUS,'LS',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE
	 * ,'E',DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'LS',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LS',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'LT',DECODE(S.CNTR_SIZE,'2',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'3',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'LT',DECODE(S.CNTR_SIZE,'4',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,
	 * 'LT',DECODE(S.CNTR_SIZE,'H',WEIGHT,0),0),0)) +
	 * SUM(DECODE(S.CNTR_TYPE,'E',
	 * DECODE(S.STATUS,'LT',DECODE(S.CNTR_SIZE,'L',WEIGHT,0),0),0)) , 0 ) FROM
	 * VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S WHERE V.VSL_CD = 'HJWS'
	 * --:vsl_cd AND V.SKD_VOY_NO = '0099' --:skd_voy_no AND V.SKD_DIR_CD = 'W'
	 * --:skd_dir_cd AND V.YD_CD = 'USPDXM1' --:port_cd AND V.VSL_CD = H.VSL_CD
	 * AND V.SKD_VOY_NO = H.VOY_NO AND V.SKD_DIR_CD = H.DIR_CD AND V.VPS_PORT_CD
	 * = H.PORT_CD AND V.CLPT_IND_SEQ = H.CALL_IND AND H.VSL_CD = S.VSL_CD AND
	 * H.VOY_NO = S.VOY_NO AND H.DIR_CD = S.DIR_CD AND H.PORT_CD = S.PORT_CD AND
	 * H.CALL_IND = S.CALL_IND AND S.STATUS IN ('LS','LT')
	 * 
	 * @category Obj127_OutbundTon
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getOutboundTon(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetOutboundTonRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 130://Cargo Volume Ton Tariff 비용 계산을 위해 해당 TDR 에서 ,In/Outbound
	 * Ton(Weight)을 구한다. SELECT SUM(NVL(WEIGHT,0)) FROM VSK_VSL_PORT_SKD V,
	 * TDR_HEADER H, TDR_SUMMARY S WHERE V.VSL_CD = SUBSTR(@[vvd], 1, 4)
	 * --:vsl_cd AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) --:skd_voy_no AND
	 * V.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1) --:skd_dir_cd AND V.YD_CD = @[yd_cd]
	 * --:port_cd AND V.VSL_CD = H.VSL_CD AND V.SKD_VOY_NO = H.VOY_NO AND
	 * V.SKD_DIR_CD = H.DIR_CD AND V.VPS_PORT_CD = H.PORT_CD AND V.CLPT_IND_SEQ
	 * = H.CALL_IND AND H.VSL_CD = S.VSL_CD AND H.VOY_NO = S.VOY_NO AND H.DIR_CD
	 * = S.DIR_CD AND H.PORT_CD = S.PORT_CD AND H.CALL_IND = S.CALL_IND AND
	 * S.STATUS IN ('DS', 'DT', 'LS','LM','LI')
	 * 
	 * @category Obj127_OutbundTon
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getCargoVolumeTon(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetCargoVolumeTonRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 131://Vessel Volume(FR) Tariff 비용 계산을 위해 해당Vessel Volume을 구한다. 계산 방법
	 * : Round ( LOA(M) * Beam(M) * Round ( SQRT ( LOA(M) * Beam(M) ) *
	 * Constant1 Rate , 1 ) , -1 )
	 *
	 * France에서 사용하는 Tariff에 사용할 Object로 계산식이 복잡하여 Object로 추가. 계산식 중 Constatnt1
	 * Rate는 0.14로 고정하였으며 추후 Rate변경시 SQL내에서 직접 변경해야함.
	 * 
	 * SELECT NVL(ROUND(LOA_LEN*VSL_WDT * ROUND(SQRT(LOA_LEN*VSL_WDT) * 0.14, 1
	 * ), -1),0) FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)
	 * 
	 * @category Obj127_OutbundTon
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getVesselVolumeFr(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetVesselVolumeFrRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 90://Pilot Off Tariff 비용 계산을 위해 Pilot Off를 구한다. SELECT
	 * TO_CHAR(PILOT_DEP,'HH24MI') FROM TDR_HEADER where vsl_cd = 'HJBH' and
	 * VOY_NO = '0021' and DIR_CD= 'W' and PORT_CD = 'KRPUS'
	 * 
	 * @category Obj90_POff
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getPOff(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetPOffRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 91://POB Tariff 비용 계산을 위해 POB를 구한다. select
	 * TO_CHAR(PILOT_ARR,'HH24MI') FROM TDR_HEADER where vsl_cd = 'HJBH' and
	 * VOY_NO = '0021' and DIR_CD= 'W' and PORT_CD = 'KRPUS'
	 * 
	 * @category Obj91_Pob
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getPob(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetPobRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 92://Rehandling Volume Tariff 비용 계산을 위해 POB를 구한다. SELECT count(*)
	 * FROM TDR_CNTR_DETAIL WHERE vsl_cd = 'HJBH' and VOY_NO = '0019' and
	 * DIR_CD= 'W' and PORT_CD = 'CNYIT' and PRECELL IS NOT NULL and STATUS =
	 * 'ST'
	 * 
	 * @category Obj92_RhVol
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getRhVol(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRhVolRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 128://Rehandling Ton Tariff 비용 계산을 위해 Rehandling Ton(Weight)을 구한다.
	 * SELECT sum(WEIGHT) FROM TDR_CNTR_DETAIL WHERE vsl_cd = 'HJBH' and VOY_NO
	 * = '0019' and DIR_CD= 'W' and PORT_CD = 'CNYIT' and PRECELL IS NOT NULL
	 * and STATUS = 'ST'
	 * 
	 * @category Obj128_RhTon
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getRhTon(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRhTonRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 129://ETA Hour Tariff 비용 계산을 위해 ETA Hour(HH24)를 구한다. SELECT
	 * TO_CHAR(VPS_ETA_DT, 'HH24') FROM VSK_VSL_PORT_SKD WHERE VSL_CD = 'HJMT'
	 * AND SKD_VOY_NO = '0146' AND SKD_DIR_CD = 'E' AND YD_CD = 'KRPUSHN'
	 * 
	 * @category Obj129_EtaHour
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtaHour(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtaHourRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 112://Water Volume Tariff 비용 계산을 위해 Water Volume를 구한다. select
	 * NVL(SPL_FRSH_WTR_WGT,0) from vsk_dep_rpt where vsl_cd = 'HJBH' and
	 * SKD_VOY_NO = '0021' and SKD_DIR_CD= 'W' and VPS_PORT_CD = 'KRPUS'
	 * 
	 * @category Obj92_WatVol
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getWatVol(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetWatVolRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 93://Remain Vessel Call Tariff 비용 계산을 위해 해당스케줄에서 남아있는 Vessel Calling
	 * 수를 구한다. // select count(*) // from vsk_vsl_port_skd // where vsl_cd =
	 * 'AMIS' // and vps_port_cd = 'USSAV' --Yard 7자리에서 5자리만 // and
	 * NVL(SKD_CNG_STS_CD,'X') <> 'S' // and vps_etd_dt > (select
	 * max(vps_etd_dt) from vsk_vsl_port_skd // where vsl_cd = 'AMIS' // and
	 * skd_voy_no = '0974' // and skd_dir_cd = 'E' // and vps_port_cd = 'USSAV'
	 * // and nvl(SKD_CNG_STS_CD,' ') <> 'S' // ) // and TURN_PORT_IND_CD IN
	 * ('N','Y')
	 * 
	 * @category Obj93_RemainVesselCall
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getRemainVesselCall(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRemainVesselCallRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 37://Anchoring Hour Tariff 비용 계산을 위해 해당 TDR 에서 Anchoring Hour을 구한다.
	 * // select DECODE(SIGN(VAL),-1, 0, VAL) // from ( // select
	 * MAX(NVL(BFR_BRTH_ANK_OFF_DT - BFR_BRTH_ANK_DRP_DT,0) + NVL(
	 * AFT_UNBRTH_ANK_OFF_DT - AFT_UNBRTH_ANK_DRP_DT,0)) VAL // from
	 * vsk_act_port_skd // where vsl_cd = 'AMIS' // and skd_voy_no = '0974' //
	 * and skd_dir_cd = 'E' // and vps_port_cd = 'USSAV' // )
	 * 
	 * @category Obj37_AnchoringHour
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getAnchoringHour(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetAnchoringHourRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 23://Country of Last Port Tariff 비용 계산을 위해 직전 Calling Port 의
	 * Country을 구한다. // select SUBSTR(MAX(A.vps_Etd_dt||A.vps_port_cd),-5,2) //
	 * from vsk_vsl_port_skd A, ( // select slan_cd, vsl_cd, vps_port_cd,
	 * vps_etd_dt // from vsk_vsl_port_skd // where vsl_cd = 'AMIS' // and
	 * skd_voy_no = '0977' // and skd_dir_cd = 'E' // and vps_port_cd = 'USSAV'
	 * // ) B // where A.vps_etd_dt < B.vps_Etd_dt // and A.vsl_cd = B.vsl_cd //
	 * and A.slan_cd = B.slan_cd
	 * 
	 * @category Obj23_CountryofLastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getCntLastPort(String vvd, String ydCd, String clptIndSeq ) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetCntLastPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 24://Country of Next Port Tariff 비용 계산을 위해 이후 Calling Port 의
	 * Country을 구한다. // select SUBSTR(MIN(A.vps_Etd_dt||A.vps_port_cd),-5,2) //
	 * from vsk_vsl_port_skd A, ( // select slan_cd, vsl_cd, vps_port_cd,
	 * vps_etd_dt // from vsk_vsl_port_skd // where vsl_cd = 'AMIS' // and
	 * skd_voy_no = '0977' // and skd_dir_cd = 'E' // and vps_port_cd = 'USSAV'
	 * // ) B // where A.vps_etd_dt > B.vps_Etd_dt // and A.vsl_cd = B.vsl_cd //
	 * and A.slan_cd = B.slan_cd
	 * 
	 * @category Obj24_CountryofNextPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getCntNextPort(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetCntNextPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 79://last Issued Invoice ETD Tariff 비용 계산을 위해 최근 처리된 Invoice 의 ETD 을
	 * 구한다. // select TO_CHAR(MAX(B.vps_Etd_dt),'YYYYMMDD') // from
	 * vsk_vsl_port_skd A, vsk_vsl_port_skd B, pso_charge C1, pso_chg_dtl C2 //
	 * where A.vps_etd_dt > B.vps_Etd_dt // and A.vsl_cd = B.vsl_cd // and
	 * A.vsl_cd = 'HJMT' // and A.skd_voy_no = '0146' // and A.skd_dir_cd = 'E'
	 * // and A.vps_port_cd = 'CNTAO' // and C1.ISS_CTY_CD = C2.ISS_CTY_CD //
	 * and C1.SO_SEQ = C2.SO_SEQ // and C2.vsl_cd = B.vsl_cd // and
	 * C2.skd_voy_no = B.skd_voy_no // and C2.skd_dir_cd = B.skd_dir_cd // and
	 * C1.yd_cd like A.vps_port_cd||'%' // and C2.lgs_cost_cd = 'PTDUTN' // and
	 * B.vps_Etd_dt > sysdate - 90
	 * 
	 * @category Obj79_lastIssuedInvoiceETD
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @param String lgsCostCd
	 * @return String
	 * @throws DAOException
	 */
	public String getLastInvEtd(String vvd, String ydCd, String clptIndSeq, String lgsCostCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("port_cd", ydCd.substring(0, 5));
				param.put("cnt_cd", ydCd.substring(0, 2));
				param.put("lgs_cost_cd", lgsCostCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("port_cd", ydCd.substring(0, 5));
				velParam.put("cnt_cd", ydCd.substring(0, 2));
				velParam.put("lgs_cost_cd", lgsCostCd);

				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLastInvEtdRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * TBN1~ 관련 항차의 대체 VSL_CD를 구한다.
	 * 
	 * @param String vvd
	 * @param String cntrVslClssCapa
	 * @return String
	 * @throws DAOException
	 */
	public String getRepVslCd(String vvd, String cntrVslClssCapa) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("cntr_vsl_clss_capa", cntrVslClssCapa);
				velParam.put("vvd", vvd);
				velParam.put("cntr_vsl_clss_capa", cntrVslClssCapa);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRepVslCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * 최근 버전의 Tariff를 조회한다.
	 * 
	 * @category VOP_PSO_0038 (jmh)
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<TariffInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TariffInfoVO> getTariff(SimulationConditionVO simulationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> vndrSeq = new ArrayList<String>();
			// NYK Modify 2014.11.06
			String vndrSeqAllFlg = BizComPsoUtil.isExistsParameter(simulationConditionVO.getVndrSeq(), "ALL") ? "Y" : "N";
			vndrSeq = BizComPsoUtil.getSeperationParameterList(simulationConditionVO.getVndrSeq(), ",");
			// ALL,6229,14zxzzz 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
			if (vndrSeq.size() > 0)
				vndrSeqAllFlg = "N";

			List<String> costCd = new ArrayList<String>();
			String costCdAllFlg = BizComPsoUtil.isExistsParameter(simulationConditionVO.getCostCd(), "ALL") ? "Y" : "N";
			costCd = BizComPsoUtil.getSeperationParameterList(simulationConditionVO.getCostCd(), ",");
			// ALL,6229,14zxzzz 식으로 ALL 일경우 해당 costCd를 다 넘기므로 체크 해서 직접 넣어준다.
			if (costCd.size() > 0)
				costCdAllFlg = "N";

			/*
			 * String flg = ""; if("".equals(vndrSeqs[0])){ flg = "ALL"; }else{
			 * flg = "N"; for(int i = 0; i < vndrSeqs.length; i++){
			 * vndrSeq.add(vndrSeqs[i]); } } List<String> costCd = new
			 * ArrayList(); String[] costCds =
			 * simulationConditionVO.getCostCd().split(","); for(int i = 0; i <
			 * costCds.length; i++){ costCd.add(costCds[i]); }
			 */

			if (simulationConditionVO != null) {
				Map<String, String> mapVO = simulationConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("vndr_seq", vndrSeq);
				velParam.put("cost_cd", costCd);
				velParam.put("vndr_seq_all_flg", vndrSeqAllFlg);
				velParam.put("cost_cd_all_flg", costCdAllFlg);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOGetTariffRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TariffInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Tariff에 속한 Formula/Condition를 구성하는 Objects 조회하기
	 * 
	 * @category VOP_PSO_0038 (jmh)
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<SimulationObjectListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SimulationObjectListVO> searchObjectBySimulation(SimulationConditionVO simulationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimulationObjectListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (simulationConditionVO != null) {
				Map<String, String> mapVO = simulationConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchObjectBySimulationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SimulationObjectListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Invoice Detail 조회하기
	 * 
	 * @category VOP_PSO_0038 (jmh)
	 * @param SimulationConditionVO simulationConditionVO
	 * @param SimulationConditionVO simulationConditionVO2
	 * @return List<SimulationInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SimulationInvoiceListVO> searchInvoiceBySimulation(SimulationConditionVO simulationConditionVO, SimulationConditionVO simulationConditionVO2) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimulationInvoiceListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			// List<String> costCd = new ArrayList();
			// String[] costCds = simulationConditionVO.getCostCd().split(",");
			// for(int i = 0; i < costCds.length; i++){
			// costCd.add(costCds[i]);
			// }

			if (simulationConditionVO != null && simulationConditionVO2 != null) {
				Map<String, String> mapVO = simulationConditionVO.getColumnValues();
				param.putAll(mapVO);
				param.put("curr_cd", simulationConditionVO2.getCurrCd());
				param.put("cost_cd", simulationConditionVO2.getCostCd());
				param.put("vndr_seq", simulationConditionVO2.getVndrSeq());
				// currCd = simulationConditionVO2.getCurrCd();
				// Map<String, String> mapVO = simulationConditionVOs
				// .getColumnValues();
				// param.putAll(mapVO);
				// param.put("curr_cd", currCd);
				// velParam.putAll(mapVO);
				// velParam.put("cost_cd", costCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchInvoiceBySimulationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SimulationInvoiceListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Tariff에 해당하는 Service Providers 조회하기
	 * 
	 * @category VOP_PSO_0038 (jmh)
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<SimulationConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SimulationConditionVO> searchProviderBySimulation(SimulationConditionVO simulationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimulationConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> costCd = new ArrayList<String>();
			// NYK Modify 2014.11.06
			costCd = BizComPsoUtil.getSeperationParameterList(simulationConditionVO.getCostCd(), ",");

			/*
			 * String[] costCds = simulationConditionVO.getCostCd().split(",");
			 * for(int i = 0; i < costCds.length; i++){ costCd.add(costCds[i]);
			 * }
			 */
			if (simulationConditionVO != null) {
				Map<String, String> mapVO = simulationConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("cost_cd", costCd);
			}
			// param.put("port_cd", simulationConditionVO.getPortCd());
			// param.put("yard_cd", simulationConditionVO.getYardCd());
			// param.put("cost_cd", simulationConditionVO.getCostCd());
			// param.put("issue_date", simulationConditionVO.getIssueDate());
			//
			// velParam.put("port_cd", simulationConditionVO.getPortCd());
			// velParam.put("yard_cd", simulationConditionVO.getYardCd());
			// velParam.put("cost_cd", simulationConditionVO.getCostCd());
			// velParam.put("issue_date", simulationConditionVO.getIssueDate());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchProviderBySimulationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SimulationConditionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Tariff에서 사용하는 Account 조회하기
	 * 
	 * @category VOP_PSO_0038 (jmh)
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<CostListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CostListVO> searchAccountBySimulation(SimulationConditionVO simulationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CostListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// if(simulationConditionVO != null){
			// Map<String, String> mapVO = simulationConditionVO
			// .getColumnValues();
			// param.putAll(mapVO);
			// velParam.putAll(mapVO);
			// }
			/*param.put("port_cd", simulationConditionVO.getPortCd());
			param.put("yard_cd", simulationConditionVO.getYardCd());
			param.put("issue_date", simulationConditionVO.getIssueDate());
			// System.out.println("@@=>"+simulationConditionVO.getIssueDate());

			// velParam.put("port_cd", simulationConditionVO.getPortCd());
			// velParam.put("yard_cd", simulationConditionVO.getYardCd());
			velParam.put("issue_date", simulationConditionVO.getIssueDate());*/
			
			if (simulationConditionVO != null) {
				Map<String, String> mapVO = simulationConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchAccountBySimulationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CostListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/*
	 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
	 */
	/**
	 * case 65://ETB DATE // SELECT TO_CHAR (VPS_ETB_DT, 'YYYYMMDD') // FROM
	 * VSK_VSL_PORT_SKD // WHERE VSL_CD = 'BAHX' // AND SKD_VOY_NO = '0036' //
	 * AND SKD_DIR_CD = 'E' // AND YD_CD = 'KRPUSY1'
	 * 
	 * @category Obj65_ETBDate
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtbDate(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtbDateRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * 환율변환된 금액을 조회한다.
	 * 
	 * @category VOP_PSO_0014_Calculation
	 * @param String div
	 * @param String amt
	 * @param String dt
	 * @param String currCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchConvertedAmount(String div, String amt, String dt, String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		String convertedAmt = "";
		String exchangeRate = "";
		String[] retArr = new String[2];

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("div", div);
		param.put("amt", amt);
		param.put("dt", dt);
		param.put("curr_cd", currCd);

		velParam.put("div", div);
		velParam.put("amt", amt);
		velParam.put("dt", dt);
		velParam.put("curr_cd", currCd);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchConvertedAmountRSQL(), param, velParam);
			if (dbRowset.next()) {
				convertedAmt = dbRowset.getString(1);
				exchangeRate = dbRowset.getString(2);
				log.debug("\nDAO JMH>> GeneralInvoiceAuditDBDAOSearchConvertedAmountRSQL " + div + " : " + convertedAmt);
				retArr[0] = convertedAmt;
				retArr[1] = exchangeRate;
			} else {
				retArr[0] = "0";
				retArr[1] = "0";
				//2015.01.15 NYK Modify.
				log.debug("searchConvertedAmount Error Message [No rate information].");
				//throw new DAOException(new ErrorHandler("PSO90001", "No rate information").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (DAOException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retArr;
	}

	/**
	 * 환율변환된 금액을 조회한다.
	 * 2016.08.17 Add
	 * Local to Local 환율 계산 추가.
	 * 
	 * @category VOP_PSO_0014_Calculation
	 * @param String div
	 * @param String amt
	 * @param String dt
	 * @param String frCurrCd
	 * @param String toCurrCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchConvertedInvoiceAmount(String div, String amt, String dt, String frCurrCd, String toCurrCd) throws DAOException {
		DBRowSet dbRowset = null;
		String convertedAmt = "";
		String exchangeRate = "";
		String[] retArr = new String[2];

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("div", div);
		param.put("amt", amt);
		param.put("dt", dt);
		param.put("fr_curr_cd", frCurrCd);
		param.put("to_curr_cd", toCurrCd);

		velParam.put("div", div);
		velParam.put("amt", amt);
		velParam.put("dt", dt);
		velParam.put("fr_curr_cd", frCurrCd);
		velParam.put("to_curr_cd", toCurrCd);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchConvertedInvoiceAmountRSQL(), param, velParam);
			if (dbRowset.next()) {
				convertedAmt = dbRowset.getString(1);
				exchangeRate = dbRowset.getString(2);
				log.debug("\nDAO JMH>> GeneralInvoiceAuditDBDAOSearchConvertedInvoiceAmountRSQL " + div + " : " + convertedAmt);
				retArr[0] = convertedAmt;
				retArr[1] = exchangeRate;
			} else {
				retArr[0] = "0";
				retArr[1] = "0";
				//2015.01.15 NYK Modify.
				log.debug("searchConvertedInvoiceAmount Error Message [No rate information].");
				//throw new DAOException(new ErrorHandler("PSO90001", "No rate information").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (DAOException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retArr;
	}

	/**
	 * case 132://Loaded TEU at Last Port Tariff 비용 계산을 위해 해당 RDR 에서 Loaded TEU를
	 * 구한다.
	 * 
	 * @category Obj132_LoadedTeuLastPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getLoadedTeuLastPort(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Estimate의 경우, tier의 값을 조회
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String getTier(String vvd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetTierRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Estimate의 경우, Limit Time 값을 조회
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String getLimitTime(String vvd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLimitTimeRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Vessel Volume 조회
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String getVesselVolumeCi(String vvd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetVesselVolumeCiRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * LOA * Beam 조회
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getLoaBeam(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLoaBeamRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/*
	 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
	 */
	/**
	 * case 136://ETB Day
	 * 
	 * @category Obj136_ETBDay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtbDay(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtbDayRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/*
	 * CHM-201006351-01 신규 Object(136~144) 및 로직 수정(65,69)
	 */
	/**
	 * case 137://ETD Day
	 * 
	 * @category Obj137_ETDDay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtdDay(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtdDayRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 147://DEM/DET Holiday ETB (except day) 해당 VVD/Port의 ETB를 이용하여 휴일인지
	 * 조회한다. // SELECT ''''||MAX(NVL(DD,'N'))||'''' // FROM // ( // -- 휴일 등록을
	 * 한경우 // SELECT 'Y' DD // FROM DMT_HOLIDAY D, VSK_VSL_PORT_SKD V,
	 * MDM_LOCATION L // WHERE D.HOL_YR = TO_CHAR(V.VPS_ETB_DT, 'YYYY') // AND
	 * D.CNT_CD = SUBSTR(V.VPS_PORT_CD,1,2) // AND D.HOL_DT =
	 * TRUNC(V.VPS_ETB_DT) // AND V.VSL_CD = substr('HNHO0243W', 1, 4) // AND
	 * V.SKD_VOY_NO = substr('HNHO0243W', 5, 4) // AND V.SKD_DIR_CD =
	 * substr('HNHO0243W', 9) // AND V.YD_CD = 'KRPUSHN' // AND V.VPS_PORT_CD =
	 * L.LOC_CD // AND D.RGN_CD IN (L.RGN_CD, ' ') // AND D.STE_CD IN (L.STE_CD,
	 * ' ') // AND D.LOC_CD IN (V.VPS_PORT_CD, ' ') //)
	 * 
	 * CHM-201007132-01 2010.12.09 이석준 신규 Object DEM/DET Holiday ETB (except Day) 추가
	 * 
	 * @category Obj147_DemdetHolidayETBExceptDay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchDemdetHolidayETBExceptDay(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);

				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchDemdetHolidayETBExceptDayRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/*
	 * CHM-201007132-01 2010.12.09 이석준 신규 Object DEM/DET Holiday ETD (except
	 * Day) 추가
	 */
	/**
	 * * case 148://DEM/DET Holiday ETD (except day) 해당 VVD/Port의 ETD를 이용하여 휴일인지
	 * 조회한다. // SELECT ''''||MAX(NVL(DD,'N'))||'''' // FROM // ( // -- 휴일 등록을
	 * 한경우 // SELECT 'Y' DD // FROM DMT_HOLIDAY D, VSK_VSL_PORT_SKD V,
	 * MDM_LOCATION L // WHERE D.HOL_YR = TO_CHAR(V.VPS_ETD_DT, 'YYYY') // AND
	 * D.CNT_CD = SUBSTR(V.VPS_PORT_CD,1,2) // AND D.HOL_DT =
	 * TRUNC(V.VPS_ETD_DT) // AND V.VSL_CD = substr('HNHO0243W', 1, 4) // AND
	 * V.SKD_VOY_NO = substr('HNHO0243W', 5, 4) // AND V.SKD_DIR_CD =
	 * substr('HNHO0243W', 9) // AND V.YD_CD = 'KRPUSHN' // AND V.VPS_PORT_CD =
	 * L.LOC_CD // AND D.RGN_CD IN (L.RGN_CD, ' ') // AND D.STE_CD IN (L.STE_CD,
	 * ' ') // AND D.LOC_CD IN (V.VPS_PORT_CD, ' ') //)
	 * 
	 * @category Obj147_DemdetHolidayETDExceptDay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchDemdetHolidayETDExceptDay(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);

				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchDemdetHolidayETDExceptDayRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * * case 153://DEM/DET Holiday ETA (except day) 해당 VVD/Port의 ETA를 이용하여 휴일인지
	 * 조회한다.
	 * 
	 * @category Obj153_DemdetHolidayETAExceptDay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchDemdetHolidayETAExceptDay(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);

				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchDemdetHolidayETAExceptDayRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Subject Favorites : yard 조회
	 * 
	 * @category VOP_PSO_0038
	 * @param String portCd
	 * @param String issueDate
	 * @return List<SearchYardsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchYardsVO> searchYardList(String portCd, String issueDate) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchYardsVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (portCd != null) {
				HashMap hMap = new HashMap<String, String>();
				hMap.put("port_cd", portCd);
				hMap.put("issue_date", issueDate);
				Map<String, String> mapVO = hMap;

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchYardListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchYardsVO.class);
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
	 * Tariff에서 사용하는 Cost 조회하기
	 * 
	 * @category VOP_PSO_0038 (jmh)
	 * @param SimulationConditionVO simulationConditionVO
	 * @return List<CostListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CostListVO> searchCostBySimulation(SimulationConditionVO simulationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CostListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> acctCd = new ArrayList();
			// NYK Modify 2014.11.06
			acctCd = BizComPsoUtil.getSeperationParameterList(simulationConditionVO.getAcctCd(), ",");

			/*
			 * String[] acctCds = simulationConditionVO.getAcctCd().split(",");
			 * for(int i = 0; i < acctCds.length; i++){ acctCd.add(acctCds[i]);
			 * }
			 */

			if (simulationConditionVO != null) {
				Map<String, String> mapVO = simulationConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("acct_cd", acctCd);
			}

			// param.put("port_cd", simulationConditionVO.getPortCd());
			// param.put("yard_cd", simulationConditionVO.getYardCd());
			// param.put("issue_date", simulationConditionVO.getIssueDate());
			// param.put("acct_cd", simulationConditionVO.getAcctCd());
			// velParam.put("port_cd", simulationConditionVO.getPortCd());
			// velParam.put("yard_cd", simulationConditionVO.getYardCd());
			// velParam.put("issue_date", simulationConditionVO.getIssueDate());
			// velParam.put("acct_cd", simulationConditionVO.getAcctCd());
			// System.out.println(param.get("acct_cd"));

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchCostBySimulationRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CostListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 해당 VVD의 Yard를 조회한다.
	 * 
	 * @category VOP_PSO_0039
	 * @param TariffSimByVvdVO tariffSimByVvdVO
	 * @return List<TariffSimByVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TariffSimByVvdVO> searchYardsByVvd(TariffSimByVvdVO tariffSimByVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffSimByVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tariffSimByVvdVO != null) {
				Map<String, String> mapVO = tariffSimByVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchYardsByVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TariffSimByVvdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 해당 vvd, yard의 tariff 조회하기
	 * 
	 * @category VOP_PSO_0039
	 * @param TariffSimByVvdVO tariffSimByVvdVO
	 * @return List<SimulationConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SimulationConditionVO> searchTariffByYards(TariffSimByVvdVO tariffSimByVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimulationConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tariffSimByVvdVO != null) {
				Map<String, String> mapVO = tariffSimByVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchTariffByYardsRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SimulationConditionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 해당 vvd, yard의 Port Type(Turning/Virtual/General) 구분하기
	 * 
	 * @category VOP_PSO_0039
	 * @param TariffSimByVvdVO tariffSimByVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPortType(TariffSimByVvdVO tariffSimByVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		String portType = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tariffSimByVvdVO != null) {
				Map<String, String> mapVO = tariffSimByVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchPortTypeRSQL(), param, velParam);
			if (dbRowset.next()) {
				portType = dbRowset.getString(1);
			} else {
				throw new DAOException(new ErrorHandler("PSO90002", tariffSimByVvdVO.getYdCd()).getMessage());
			}

			return portType;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (DAOException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * vvd의 P/F Duration을 구한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String getDuration(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String duration = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchDurationRSQL(), param, velParam);
			if (dbRowset.next()) {
				duration = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return duration;
	}

	/**
	 * 대상 VVD가 사업계획용인지 Live용인지 조회한다. 사업계획 == 1 / Live == 2
	 * 
	 * @param String vvd
	 * @return String
	 * @exception DAOException
	 */
	public String searchVvdBztpCd(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String srcPsoBztpCd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchVvdBztpCdRSQL(), param, null);
			if (dbRowset.next()) {
				srcPsoBztpCd = dbRowset.getString(1);
			}

			return srcPsoBztpCd;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Tariff 비용 계산을 위해 어떤 Vessel이 특정 포트 접안일 기준, 과거 120일 이내에 Taiwan을 접안 하였는지 조회
	 * 
	 * @category Obj155_PreviousTaiwanPort
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getPreviousTaiwanPort(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
			velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * case 156: Yearly Vessel Call Port 당해년도 특정 port의 모든 선박(feeder 제외)의 calling
	 * count
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getYearlyVesselCallPort(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
			velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
		}

		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOGetYearlyVesselCallPortRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 157: ETA Date
	 * 
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtaDate(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
			velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
		}

		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOGetEtaDateRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * 15: //Berthing Hour(D-A) Tariff 비용 계산을 위해 Berthing Hour(ETD-ETA) 를 구한다.
	 * 
	 * @category Obj15_BerthingHour
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getBerthingHourDA(String vvd, String ydCd, String clptIndSeq) throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null && clptIndSeq != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetBerthingHourDARSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * case 159://ETA Day
	 * 
	 * @category Obj159_ETADay
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtaDay(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtaDayRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 160://ETA Month Tariff 비용 계산을 위해 해당 ETA 의 월를 구한다.
	 * 
	 * @category Obj160_EtaMonth
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getEtaMonth(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetEtaMonthRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 161://InboundTon/VesselVolume(FR) Tariff 비용 계산을 위해 해당 Inbound
	 * Volume(Ton) / VesselVolume(FR)를 구한다.
	 * 
	 * @category Obj161_InboundTon/VesselVolume(FR)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getInboundDivideVessel(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetInboundDivideVesselRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 162://OutboundTon/VesselVolume(FR) Tariff 비용 계산을 위해 해당 Outbound
	 * Volume(Ton) / VesselVolume(FR)를 구한다.
	 * 
	 * @category Obj162_OutboundTon/VesselVolume(FR)
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getOutboundDivideVessel(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetOutboundDivideVesselRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 Master 저장후 Invoice 내역을 조회 한다.<br />
	 * 
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO  invAuditDataValidVO
	 * @return List<InvAuditDataValidVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvAuditDataValidVO> searchGenInvAuditMaster(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvAuditDataValidVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invAuditDataValidVO != null) {
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOsearchGenInvAuditMasterRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvAuditDataValidVO.class);
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
	 * IO Ratio를 구하지 못한 경우 Pendulum RLANE_CD와 RLANE_DIR_CD를 구한다. 
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @param String ioBnd
	 * @return String
	 * @throws DAOException
	 */
	public String getPendulumRevLaneDir(String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String ioBnd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vslCd != null && skdVoyNo != null && skdDirCd != null && ydCd != null) {
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				param.put("io_bnd", ioBnd);
				velParam.put("vslCd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
				velParam.put("io_bnd", ioBnd);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetPendulumRevLaneDirRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	


	/**
	 * PSO_PORT_EXPN_DIV 존재 여부.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getExistPortExpnDiv(String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vslCd != null && skdVoyNo != null && skdDirCd != null && ydCd != null) {
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vslCd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchExistPortExpnDivRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * 1. Outbound VVD가 넘어 올때 IO 가 IN 이면 Inbound VVD 를 찾아서 넣어준다.
	 * 단, Normal VVD 이면서 IO = IN 이면 TURN_PORT_FLG <> 'Y' 이가 아니면 vvd 그대로 사용.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchInboundVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vslCd != null && skdVoyNo != null && skdDirCd != null && ydCd != null) {
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vslCd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOSearchInboundVvdRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString("VVD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * 유저가 입력한 VVD의 Yard가 스킵인지 확인
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkSkipYardInVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean sRet = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vslCd != null){
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				velParam.put("vsl_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralInvoiceAuditDBDAOcheckSkipYardInVvdRSQL(), param, velParam);
			if(dbRowset.next()){
				String strRet = dbRowset.getString(1);
				sRet = strRet.equals("0") ? false : true;
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return sRet;
	}
	
	/**
	 * Obj Reqular Value(Default Value) Search.
	 * 
	 * @category Obj Reqular Value(Default Value)
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param List<String> objNoList
	 * @return Map<String, Object>
	 * @throws DAOException
	 */
	public Map<String, Object> getRegularValueByObjectNoMap(String ydChgNo, String ydChgVerSeq, List<String> objNoList) throws DAOException {
		DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map<String, Object> objReqularValueMap = new HashMap<String, Object>();

		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("obj_list_no", objNoList);
			param.put("obj_list_no2", objNoList);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("obj_list_no", objNoList);
			velParam.put("obj_list_no2", objNoList);
			
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRegularValueByObjectNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				objReqularValueMap.put(dbRowset.getString("OBJ_LIST_NO"), dbRowset.getString("DFLT_VAL"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return objReqularValueMap;
	}
	
	/**
	 * Obj Reqular Value(Default Value) 단건 Search.
	 * 
	 * @category Obj Reqular Value(Default Value)
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param ArrayList<String> objNoList
	 * @return String
	 * @throws DAOException
	 */
	public String getRegularValueByObjNo(String ydChgNo, String ydChgVerSeq, String objListNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String strRet = "";

		try {
			ArrayList<String> objNoList = new ArrayList<String>();
			objNoList.add(objListNo);
			
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("obj_list_no", objNoList);
			param.put("obj_list_no2", objNoList);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("obj_list_no", objNoList);
			velParam.put("obj_list_no2", objNoList);
			
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetRegularValueByObjectNoRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(2);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Expense Pendulum에 등록되지 않고 AR에 등록 되어 있는 Pendulum & Turning = N 인 IN/OUT의 RLANE_CD와 RLANE_DIR_CD를 구한다.
	 * 2016.03.18 Add.
	 * 2016.08.24 Add clptIndSeq.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @param String ioBnd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getNonexistentRevLaneDir(String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String ioBnd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vslCd != null && skdVoyNo != null && skdDirCd != null && ydCd != null) {
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				param.put("io_bnd", ioBnd);
				param.put("clpt_ind_seq", clptIndSeq);
				velParam.put("vslCd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
				velParam.put("io_bnd", ioBnd);
				velParam.put("clpt_ind_seq", clptIndSeq);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetNonexistentRevLaneDirRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Valid VVD를 조회 한다.
	 * 2016.04.06 Add.
	 * 
	 * @category common_ValidVvd
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getValidVvd(String vvd, String ydCd, String clptIndSeq) throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (vvd != null && ydCd != null && clptIndSeq != null) {
			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("clpt_ind_seq", clptIndSeq);
			
			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("clpt_ind_seq", clptIndSeq);
		}
		try {
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetValidVvdRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString(1);
			} else
				return "";
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * case 174://Last Yard
	 * 2016.11.02 Add Object	
	 * 
	 * @category Obj174_LastYard
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getLastYard(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetLastYardRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 175://Current Yard
	 * 2016.11.02 Add Object	
	 * 
	 * @category Obj175_CurrentYard
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getCurrentYard(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetCurrentYardRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 176://Next Yard
	 * 2016.11.02 Add Object	
	 * 
	 * @category Obj176_NextYard
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getNextYard(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetNextYardRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 177://Double Call
	 * 2016.11.02 Add Object	
	 * 
	 * @category Obj177_DoubleCall
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getDoubleCall(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetDoubleCallRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * case 178://Port Seq
	 * 2016.11.02 Add Object	
	 * 
	 * @category Obj178_PortSeq
	 * @param String vvd
	 * @param String ydCd
	 * @param String clptIndSeq
	 * @return String
	 * @throws DAOException
	 */
	public String getPortSeq(String vvd, String ydCd, String clptIndSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vvd != null) {
				param.put("vvd", vvd);
				param.put("yd_cd", ydCd);
				velParam.put("vvd", vvd);
				velParam.put("yd_cd", ydCd);
				param.put("clpt_ind_seq", clptIndSeq);   //2016.04.06 Add
				velParam.put("clpt_ind_seq", clptIndSeq);//2016.04.06 Add
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate) new GeneralInvoiceAuditDBDAOgetPortSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * 유저가 입력한 VVD에 따른 Vendor/Cost_ofc/Cost_cd/YD_CD/CLPt_IND_SEQ가 기존 입력된 Invoice가 있는지 체크
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<String> 
	 * @exception EventException
	 */
	
	public List<String> checkDoublePayInv(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(invAuditDataValidVO != null){
				Map<String, String> mapVO = invAuditDataValidVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new GeneralInvoiceAuditDBDAOcheckDoublePayInvRSQL(), param, velParam);
			while(dbRowset.next()){
				list.add(dbRowset.getString(1));				
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

}