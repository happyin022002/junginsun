/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrsCommonDBDAO.java
 *@FileTitle : TrsCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.19
 *@LastModifier : 황효근
 *@LastVersion : 1.0
 * 2011.10.19 황효근
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0221Event;
import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.clt.apps.opus.esd.trs.common.trscommon.event.EsdTrs0999Event;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsComboVO;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsCommonComboVO;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;

/**
 * ALPS TrsCommonDBDAO <br>
 * - ALPS-Common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HwangHyoKeun
 * @see TrsCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class TrsCommonDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Rail Vendor Code List를 조회한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRailVndrCd(EsdTrs0999Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		TrsComboVO trsComboVO = event.getTrsComboVO();
		Map<String, String> mapVO = trsComboVO.getColumnValues();

		param.putAll(mapVO);

		String vndrCntCd = trsComboVO.getVndrCntCd();

		List<String> vndr_cnt_cd_list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(vndrCntCd, ",");
		while (st.hasMoreTokens()) {
			vndr_cnt_cd_list.add(st.nextToken());
		}

		velParam.put("vndr_cnt_cd_list", vndr_cnt_cd_list);

		try {
			dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOSearchRailVndrCdRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * Other S/O에서 Commodity Code를 조회한다<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCmdtCd(EsdTrs0999Event event) throws DAOException {
		DBRowSet dRs = null;

		Map<String, Object> param = new HashMap<String, Object>();
		String cmdt_cd = event.getCmdtCd();
		param.put("cmdt_cd", cmdt_cd);

		try {
			dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOSearchCommodityRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * Other S/O에서 Customer Code를 조회한다<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCustCd(EsdTrs0999Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String cust_cd = event.getCustCd();
		param.put("cust_cd", cust_cd);

		try {
			dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOSearchCustomerCodeRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * MDM Container Type/Size Combo List
	 * 
	 * @param event
	 * @return List<MdmCntrTpSzVO>
	 * @throws DAOException
	 */
	public List<MdmCntrTpSzVO> searchMdmCntrTpSz(EsdTrs0023Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCntrTpSzVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			String eq_radio = event.getEqRadio();
			param.put("eq_radio", eq_radio);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			TrsCommonDBDAOsearchMdmCntrTpSzRSQL template = new TrsCommonDBDAOsearchMdmCntrTpSzRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

			list = new ArrayList<MdmCntrTpSzVO>();
			while (dbRowset.next()) {
				MdmCntrTpSzVO vo = new MdmCntrTpSzVO();
				vo.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
				list.add(vo);
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
	 * 공통콤보 목록조회<br>
	 * 
	 * @param String comCode
	 * @return List<TrsCommonComboVO>
	 * @exception DAOException
	 */
	public List<TrsCommonComboVO> searchCombo(String comCode) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsCommonComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("# SEARCH COMMON-CODE : " + comCode);
			if (comCode == null || comCode.length() == 0) {
				// BKG00104 - 필수입력항목
				throw new RuntimeException("BKG00104");
			}

			param.put("cm_code", comCode);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			TrsCommonDBDAOTrsComboRSQL template = new TrsCommonDBDAOTrsComboRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<TrsCommonComboVO>();
			while (dbRowset.next()) {
				TrsCommonComboVO vo = new TrsCommonComboVO();
				vo.setComboCd(dbRowset.getString("intg_cd_id"));
				vo.setVal(dbRowset.getString("intg_cd_val_ctnt"));
				vo.setName(dbRowset.getString("intg_cd_val_dp_desc"));
				vo.setDesc(dbRowset.getString("intg_cd_val_desc"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 공통콤보 목록조회<br>
	 * 
	 * @param event
	 * @return List<TrsCommonComboVO>
	 * @exception DAOException
	 */
	public List<TrsCommonComboVO> searchComboCustCode(EsdTrs0221Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsCommonComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cust_code", event.getCustCode());
			velParam.put("cust_code", event.getCustCode());

			// System.out.println("event.getCustCode() : "+event.getCustCode());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			TrsCommonDBDAOTrsComboCustCodeRSQL template = new TrsCommonDBDAOTrsComboCustCodeRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<TrsCommonComboVO>();
			while (dbRowset.next()) {
				TrsCommonComboVO vo = new TrsCommonComboVO();
				vo.setComboCd(dbRowset.getString("intg_cd_id"));
				vo.setVal(dbRowset.getString("intg_cd_val_ctnt"));
				vo.setName(dbRowset.getString("intg_cd_val_dp_desc"));
				vo.setDesc(dbRowset.getString("intg_cd_val_desc"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 공통콤보 목록조회<br>
	 * 
	 * @param event
	 * @return List<TrsCommonComboVO>
	 * @exception DAOException
	 */
	public List<TrsCommonComboVO> searchComboVendor(EsdTrs0221Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsCommonComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("vendor_code", event.getFmVndrPrmrySeq());
			velParam.put("vendor_code", event.getFmVndrPrmrySeq());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			TrsCommonDBDAOTrsComboVendorCodeRSQL template = new TrsCommonDBDAOTrsComboVendorCodeRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<TrsCommonComboVO>();
			while (dbRowset.next()) {
				TrsCommonComboVO vo = new TrsCommonComboVO();
				vo.setComboCd(dbRowset.getString("intg_cd_id"));
				vo.setVal(dbRowset.getString("intg_cd_val_ctnt"));
				vo.setName(dbRowset.getString("intg_cd_val_dp_desc"));
				vo.setDesc(dbRowset.getString("intg_cd_val_desc"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchChangeWeight(EsdTrs0999Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("wgt_meas_ut_cd", event.getWgtMeasUtCd());
			param.put("cntr_wgt", event.getCntrWgt());
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchChangeWeightRSQL(), param, param);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}
	
	/**
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력<br>
	 *
	 * @param soHisVo TrsSOHistoryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiSoHistory(TrsSOHistoryVO soHisVo) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;

		try {
			log.debug("@@@@@@TrsCommonDBDAO : start");

			Map<String, String> paramVo = soHisVo.getColumnValues();
			param.putAll(paramVo);
			
			log.debug("@@@@@@TrsCommonDBDAO : param.getRoutRplnFlg = "+param.get("rout_rpln_flg"));
			log.debug("@@@@@@TrsCommonDBDAO : soHisVo.getRoutRplnFlg() = "+soHisVo.getRoutRplnFlg());
			
			if (soHisVo.getSrcCd() != null && soHisVo.getSrcCd().equals("USRAIL")) {
				if("IS".equals(soHisVo.getTrspSoEvntCd()) || "IX".equals(soHisVo.getTrspSoEvntCd()) || "ID".equals(soHisVo.getTrspSoEvntCd()) || ("II".equals(soHisVo.getTrspSoEvntCd()) )){
					log.debug("@@@@@@TrsCommonDBDAO : if : IX, ID, II => TrsCommonDBDAOAddRailInvHistoryCSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new TrsCommonDBDAOAddRailInvHistoryCSQL(), param, param);
				} else if( "WI".equals(soHisVo.getTrspSoEvntCd()) || "WC".equals(soHisVo.getTrspSoEvntCd())){
					log.debug("@@@@@@TrsCommonDBDAO : else if : WI, WC => TrsCommonDBDAOAdd404EDIHistoryCSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new TrsCommonDBDAOAdd404EDIHistoryCSQL(), param, param);
				} else {
					log.debug("@@@@@@TrsCommonDBDAO : else => TrsCommonDBDAOAddRailSOHistoryCSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new TrsCommonDBDAOAddRailSOHistoryCSQL(), param, param);
				}
			} else {
				if( "IX".equals(soHisVo.getTrspSoEvntCd()) || "ID".equals(soHisVo.getTrspSoEvntCd()) || ("II".equals(soHisVo.getTrspSoEvntCd()) && "".equals(soHisVo.getTrspSoOfcCtyCd()))){
					log.debug("@@@@@@TrsCommonDBDAO : if : IX, ID, II => TrsCommonDBDAOMultiSOHistory3CSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new TrsCommonDBDAOMultiSOHistory3CSQL(), param, param);
				}else if( "WI".equals(soHisVo.getTrspSoEvntCd()) || "WC".equals(soHisVo.getTrspSoEvntCd())){
					log.debug("@@@@@@TrsCommonDBDAO : else if : WI, WC => TrsCommonDBDAOMultiSOHistory2CSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new TrsCommonDBDAOMultiSOHistory2CSQL(), param, param);
				}else{
					log.debug("@@@@@@TrsCommonDBDAO : else => TrsCommonDBDAOMultiSOHistoryCSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new TrsCommonDBDAOMultiSOHistoryCSQL(), param, param);
				}
				if(insCnt == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}	
			}
			log.debug("insCnt = " + insCnt);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

	}
	
	/**
	 * MDM_PCK_TP 테이블을 조회한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMdmPckTp(EsdTrs0999Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsComboVO trsComboVO = event.getTrsComboVO();
		Map<String, String> mapVO = trsComboVO.getColumnValues();
		param.putAll(mapVO);

		try {
			dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOsearchMdmPckTpRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}
}
