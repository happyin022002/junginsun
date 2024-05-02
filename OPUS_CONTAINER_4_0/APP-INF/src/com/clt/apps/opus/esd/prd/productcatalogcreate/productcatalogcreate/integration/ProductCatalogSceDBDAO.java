/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ProductCatalogTroDBDAO.java
 *@FileTitle : ProductCatalogCreate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.23
 *@LastModifier : jsy
 *@LastVersion : 1.0
 * 2009.11.23 jsy
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSceGetParamVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ProductCatalogTroDBDAO <br>
 * ProductCatalogCreate system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see ProductCatalogCreateBCImpl 참조
 * @since J2EE 1.6
 */
public class ProductCatalogSceDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8438940558134199376L;

	/**
	 * COP_GET_PARAM.txt
	 * 
	 * @param copNo
	 * @param ioBndCd
	 * @param pcMode
	 * @param doorZn
	 * @param fullRtnCy
	 * @param fullPuCy
	 * @param mtPu
	 * @param mtRtn
	 * @return List<PrdSceGetParamVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdSceGetParamVO> sceGetParam(String copNo, String ioBndCd, String pcMode, String doorZn, String fullRtnCy, String fullPuCy, String mtPu, String mtRtn) throws DAOException {
		List<PrdSceGetParamVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cop_no", copNo);
			param.put("io_bnd_cd", ioBndCd);
			param.put("door_zn", doorZn);
			param.put("full_rtn_cy", fullRtnCy);
			param.put("full_pu_cy", fullPuCy);
			param.put("mt_pu", mtPu);
			param.put("mt_rtn", mtRtn);
			param.put("pc_mode", pcMode);
			log.debug("\n pc_mode:" + pcMode);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogSceDBDAOSceGetParamRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PrdSceGetParamVO.class);
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
	 * COP_GET_PARAM.txt
	 * 
	 * @param copNo
	 * @param ioBndCd
	 * @param pcMode
	 * @param doorZn
	 * @param fullRtnCy
	 * @param fullPuCy
	 * @param mtPu
	 * @param mtRtn
	 * @return List<PrdSceGetParamVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdSceGetParamVO> sceBkgGetParam(String copNo, String ioBndCd, String pcMode, String doorZn, String fullRtnCy, String fullPuCy, String mtPu, String mtRtn) throws DAOException {
		List<PrdSceGetParamVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cop_no", copNo);
			param.put("io_bnd_cd", ioBndCd);
			param.put("door_zn", doorZn);
			param.put("full_rtn_cy", fullRtnCy);
			param.put("full_pu_cy", fullPuCy);
			param.put("mt_pu", mtPu);
			param.put("mt_rtn", mtRtn);
			param.put("pc_mode", pcMode);
			log.debug("\n pc_mode:" + pcMode);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSceBkgGetParamRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PrdSceGetParamVO.class);
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
	 * @param prdSceGetParamVO
	 * @param hdPctlNo
	 * @return int
	 * @throws DAOException
	 */
	public int createSceSoReplaneOcnInlndChange(PrdSceGetParamVO prdSceGetParamVO, String hdPctlNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("cop_no", prdSceGetParamVO.getCopNo());
		param.put("por", prdSceGetParamVO.getPorCd());
		param.put("pol", prdSceGetParamVO.getPolCd());
		param.put("pod", prdSceGetParamVO.getPodCd());
		param.put("del", prdSceGetParamVO.getDelCd());
		param.put("ld_dt", "");
		param.put("rcv_t", prdSceGetParamVO.getRcvTermCd());
		param.put("del_t", prdSceGetParamVO.getDeTermCd());
		param.put("com", "");
		param.put("bkg_ofc", "");
		param.put("sc_ofc", "");
		param.put("cre_usr_id", "SCE");
		param.put("hd_pctl_no", hdPctlNo);
		param.put("pm_f", "");
		param.put("m_pu", prdSceGetParamVO.getMtPu());
		param.put("m_rtn", prdSceGetParamVO.getMtRtn());
		// 구주 지역 tro 처리를 위한 추가 f_pu 및 trans mode setting
		if (prdSceGetParamVO.getEurCheck().equals("Y")) {
			param.put("f_pu", prdSceGetParamVO.getFullPkupYdCd());
			param.put("ob_trsp_mode", prdSceGetParamVO.getObTrspMode());
			param.put("ib_trsp_mode", prdSceGetParamVO.getIbTrspMode());
		} else {
			param.put("f_rt", prdSceGetParamVO.getFullRtnYdCd());
		}
		param.put("por_n", prdSceGetParamVO.getPorNodCd());
		param.put("del_n", prdSceGetParamVO.getDelNodCd());
		param.put("new_pol", prdSceGetParamVO.getNewPol());
		param.put("ocn_str", prdSceGetParamVO.getOcnBound());
		param.put("new_pod", prdSceGetParamVO.getNewPod());
		param.put("skd_date", "");
		param.put("skd_type", "");
		param.put("vvd1", prdSceGetParamVO.getVvd1().length() == 9 ? prdSceGetParamVO.getVvd1() : "");
		param.put("vvd2", prdSceGetParamVO.getVvd2().length() == 9 ? prdSceGetParamVO.getVvd2() : "");
		param.put("vvd3", prdSceGetParamVO.getVvd3().length() == 9 ? prdSceGetParamVO.getVvd3() : "");
		param.put("vvd4", prdSceGetParamVO.getVvd4().length() == 9 ? prdSceGetParamVO.getVvd4() : "");
		param.put("org_loc_cd", prdSceGetParamVO.getOrgLocCd());
		param.put("dest_loc_cd", prdSceGetParamVO.getDestLocCd());
		param.put("ocn_seq", prdSceGetParamVO.getOcnSeq());
		param.put("pol1", "");
		param.put("pod1", "");
		param.put("lane1", "");
		param.put("pol2", "");
		param.put("pod2", "");
		param.put("lane2", "");
		param.put("pol3", "");
		param.put("pod3", "");
		param.put("lane3", "");
		param.put("pol4", "");
		param.put("pod4", "");
		param.put("lane4", "");
		param.put("vvd", prdSceGetParamVO.getTVvd());
		param.put("so_seq", "");
		param.put("pod_n", "");
		param.put("ob_str", prdSceGetParamVO.getOutBound());
		param.put("ib_str", prdSceGetParamVO.getInBound());
		param.put("manualFlg", prdSceGetParamVO.getManualFlag());
		param.put("ioBndCd", prdSceGetParamVO.getIoBndCd());
		// I/O Included Shuttle S/O Flag - #Add 2010.05.27 by sj
		param.put("obInclshtlso_flg", prdSceGetParamVO.getObInclShtlSoFlg());
		param.put("ibInclshtlso_flg", prdSceGetParamVO.getIbInclShtlSoFlg());

		// activation validation 삭제 param 추가
		param.put("skipActVal", prdSceGetParamVO.getSkipActValFlg());

		// BKG 정보 기준으로 변경시 추가 정보 추가
		if (prdSceGetParamVO.getSkipActValFlg().equals("Y")) {
			param.put("pol1", prdSceGetParamVO.getPol1());
			param.put("pod1", prdSceGetParamVO.getPod1());
			param.put("lane1", prdSceGetParamVO.getLane1());
			param.put("pol2", prdSceGetParamVO.getPol2());
			param.put("pod2", prdSceGetParamVO.getPod2());
			param.put("lane2", prdSceGetParamVO.getLane2());
			param.put("pol3", prdSceGetParamVO.getPol3());
			param.put("pod3", prdSceGetParamVO.getPod3());
			param.put("lane3", prdSceGetParamVO.getLane3());
			param.put("pol4", prdSceGetParamVO.getPol4());
			param.put("pod4", prdSceGetParamVO.getPod4());
			param.put("lane4", prdSceGetParamVO.getLane4());
		}

		// double calling 관련 seq
		param.put("n1st_pol_dc_seq", prdSceGetParamVO.getN1PolClptSeq());
		param.put("n1st_pod_dc_seq", prdSceGetParamVO.getN1PodClptSeq());
		param.put("n2nd_pol_dc_seq", prdSceGetParamVO.getN2PolClptSeq());
		param.put("n2nd_pod_dc_seq", prdSceGetParamVO.getN2PodClptSeq());
		param.put("n3rd_pol_dc_seq", prdSceGetParamVO.getN3PolClptSeq());
		param.put("n3rd_pod_dc_seq", prdSceGetParamVO.getN3PodClptSeq());
		param.put("n4th_pol_dc_seq", prdSceGetParamVO.getN4PolClptSeq());
		param.put("n4th_pod_dc_seq", prdSceGetParamVO.getN4PodClptSeq());
		log.debug("\n ProductCatalogCreateDBDAOCreateSceSoReplaneOcnInlndChangeCSQL Param:" + param.toString());
		int result = 0;
		try {
			result = new SQLExecuter().executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateSceSoReplaneOcnInlndChangeCSQL(), param, param);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException((new ErrorHandler("PRD00064")).getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * @param bkgNo
	 * @param outStr
	 * @param inStr
	 * @param ocnStr
	 * @param smtPu
	 * @param smtRtn
	 * @param obTroFlg
	 * @param ibTroFlg
	 * @param porNodCd
	 * @param polNodCd
	 * @param srTerm
	 * @param sdTerm
	 * @param delNodCd
	 * @param fullRtnYdCd
	 * @param fullPkUpYdCd
	 * @param obTrspMode
	 * @param ibTrspMode
	 * @return
	 * @throws DAOException
	 */
	public String searchSameRoutSce(String bkgNo, String outStr, String inStr, String ocnStr, String smtPu, String smtRtn, String obTroFlg, String ibTroFlg, String porNodCd, String polNodCd, String srTerm, String sdTerm, String delNodCd, String fullRtnYdCd, String fullPkUpYdCd, String obTrspMode,
			String ibTrspMode) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String rtnPctlNo = "";
		try {
			param.put("bkg_no", bkgNo);
			param.put("out_str", outStr);
			param.put("in_str", inStr);
			param.put("ocn_str", ocnStr);
			param.put("mt_pu", smtPu);
			param.put("mt_rtn", smtRtn);
			param.put("ob_tro_flg", obTroFlg);
			param.put("ib_tro_flg", ibTroFlg);
			param.put("por_nod_cd", porNodCd);
			param.put("pol_nod_cd", polNodCd);
			param.put("r_term", srTerm);
			param.put("d_term", sdTerm);
			param.put("del_nod_cd", delNodCd);
			param.put("full_rtn_yd_cd", fullRtnYdCd);
			param.put("full_pkup_yd_cd", fullPkUpYdCd);
			param.put("ob_trsp_mode", obTrspMode);
			param.put("ib_trsp_mode", ibTrspMode);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchSameRoutSceRSQL(), param, null);
			if (dbRowset.next()) {
				rtnPctlNo = dbRowset.getString("pctl_no");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnPctlNo;
	}
}
