/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ProductCatalogCreateDBDAO.java
 *@FileTitle : ProductCatalogCreate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.common.PrdConstants;
import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCnstRemarkVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdOcnRoutDoubleCallingVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchEurDrRePatternVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPriSetParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSubQuantityVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.ProductCatalogInternalDetailVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.SearchEmptyPuYdVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.SearchPrdFullRouteVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.PrdBkgCopMapVO;
import com.clt.syscommon.common.table.PrdProdCtlMstVO;

/**
 * ProductCatalogCreateDBDAO <br>
 * ProductCatalogCreate system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author sun yong Jung
 * @see ProductCatalogCreateBCImpl 참조
 * @since J2EE 1.6
 */
public class ProductCatalogCreateDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectPrdOcnRout(String hdPctlNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("hd_pctl_no", hdPctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSelectPrdOcnRoutRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param hdPctlNo
	 * @param skd_date
	 * @param skd_type
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdOcnRoutDoubleCallingVO> searchPrdCtlOcnRoutDoubleCalling(String hdPctlNo, String skd_date, String skd_type) throws DAOException {
		List<PrdOcnRoutDoubleCallingVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("hd_pctl_no", hdPctlNo);
			param.put("skd_date", skd_date);
			param.put("skd_type", skd_type);
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchPrdOcnRoutDoubleCallingRSQL(), param, param, PrdOcnRoutDoubleCallingVO.class);
			log.debug("\n\n searchPrdCtlOcnRoutDoubleCalling list size:" + list.size());
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
	 * @param PctlNo
	 * @param mPu
	 * @param mPuDt
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectPrdEmpty(String PctlNo, String mPu, String mPuDt) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", PctlNo);
			param.put("m_pu", mPu);
			param.put("m_pu_dt", mPuDt);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogcreateDBDAOSelectEmptyPuYdRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param PctlNo
	 * @param mPu
	 * @param mPuDt
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List searchPrdEmpty(String PctlNo, String mPu, String mPuDt) throws DAOException {
		List<SearchEmptyPuYdVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", PctlNo);
			param.put("m_pu", mPu);
			param.put("m_pu_dt", mPuDt);
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogcreateDBDAOSelectEmptyPuYdRSQL(), param, null, SearchEmptyPuYdVO.class);
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
	 * @param prdCnstRemarkVO
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCnstRemark(PrdCnstRemarkVO prdCnstRemarkVO) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("prdCtlNo", prdCnstRemarkVO.getPrdCtlNo());
			param.put("trnkLane", prdCnstRemarkVO.getTrnkLane());
			param.put("pol", prdCnstRemarkVO.getPol());
			param.put("pod", prdCnstRemarkVO.getPod());
			param.put("del", prdCnstRemarkVO.getDel());
			param.put("cnst_seq", prdCnstRemarkVO.getCnst_seq());
			param.put("cnstFlg", prdCnstRemarkVO.getCnstFlg());
			param.put("nod_cd", prdCnstRemarkVO.getNod_cd());
			param.put("org_nod_cd", prdCnstRemarkVO.getOrg_nod_cd());
			param.put("dest_nod_cd", prdCnstRemarkVO.getDest_nod_cd());

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;

	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPortCct(String pctlNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchPortCctRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;

	}

	/**
	 * @param pctlNo
	 * @param por
	 * @param from
	 * @param to
	 * @param port
	 * @param cct
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFullRtnYdCct(String pctlNo, String por, String from, String to, String port, String cct) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			param.put("from_time", from);
			param.put("to_time", to);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchFullRtnYdCctRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;

	}

	/**
	 * @param pctlNo
	 * @param por
	 * @param rtnTime
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectPrdFullRtn(String pctlNo, String por, String rtnTime) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			param.put("por", por);
			param.put("rail_cargo_rtn_tm", rtnTime);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSelectFullRtnYdCctRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRouteInfoByPctlNo(String pctlNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectReturnStrToBkg(String pctlNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSelectReturnStrToBkgRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param bkgPctlNo
	 * @param hdPctlNo
	 * @param scOfc
	 * @param rfaOfc
	 * @param usrId
	 * @param copyCnt
	 * @param scNo
	 * @param rfaNo
	 * @throws DAOException
	 */
	public void createBkgCopyPrdMstVvdUnchange(String bkgPctlNo, String hdPctlNo, String scOfc, String rfaOfc, String usrId, int copyCnt, String scNo, String rfaNo) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_pctl_no", bkgPctlNo);
			param.put("hd_pctl_no", hdPctlNo);
			param.put("sc_ofc", scOfc);
			param.put("rfa_ofc", rfaOfc);
			param.put("copy_cnt", copyCnt);
			param.put("cre_usr_id", usrId);
			param.put("sc_no", scNo);
			param.put("rfa_no", rfaNo);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateBkgCopyPrdMstVvdUnchangeCSQL(), param, null);
			log.debug("\n pc create (successFlag:" + successFlag);

			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * @param bkgPctlNo
	 * @param hdPctlNo
	 * @param usrId
	 * @param copyCnt
	 * @throws DAOException
	 */
	public void createBkgCopyPrdDtlVvdUnchange(String bkgPctlNo, String hdPctlNo, String usrId, int copyCnt) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_pctl_no", bkgPctlNo);
			param.put("hd_pctl_no", hdPctlNo);
			param.put("copy_cnt", copyCnt);
			param.put("cre_usr_id", usrId);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateBkgCopyPrdDtlVvdUnchangeCSQL(), param, null);
			log.debug("\n pc create (successFlag:" + successFlag);

			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * @param bkgPctlNo
	 * @param hdPctlNo
	 * @param scOfc
	 * @param rfaOfc
	 * @param usr_id
	 * @param copyCnt
	 * @throws DAOException
	 */
	public void createBkgCopyPrdActGrpDtlVvdUnchange(String bkgPctlNo, String hdPctlNo, String scOfc, String rfaOfc, String usr_id, int copyCnt) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_pctl_no", bkgPctlNo);
			param.put("hd_pctl_no", hdPctlNo);
			param.put("sc_ofc", scOfc);
			param.put("rfa_ofc", rfaOfc);
			param.put("copy_cnt", copyCnt);
			param.put("cre_usr_id", usr_id);
			param.put("upd_usr_id", usr_id);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateBkgCopyPrdActGrpDtlVvdUnchangeCSQL(), param, null);
			log.debug("\n pc create (successFlag:" + successFlag);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * @param bkgNo
	 * @param vvd
	 * @return
	 * @throws DAOException
	 * @deprecated 오픈할 때 관련된 소스 지워주세요.
	 */
	public int updateAssignVvdMaster(String bkgNo, String vvd) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("vvd", vvd);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdateAssignVvdMasterUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param bkgNo
	 * @param vvd
	 * @param port
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public int updateAssignVvdDetail(String bkgNo, String vvd, String port, String userId) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("vvd", vvd);
			param.put("port", port);
			param.put("user_id", userId);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdateAssignVvdDetailUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param hdPctlNo
	 * @param copyCnt
	 * @throws DAOException
	 */
	public void updateBkgCopyVndr(String hdPctlNo, int copyCnt) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("hd_pctl_no", hdPctlNo);
			param.put("copy_cnt", copyCnt);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdateBkgCopyVndrUSQL(), param, null);
			log.debug("\n pc create (successFlag:" + successFlag);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * @param String bkgNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkBkgCopy(String bkgNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOCheckBkgCopyRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param String parentBkgNo
	 * @param String mapgSeq
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean createBkgSplitMapBase(String parentBkgNo, String mapgSeq) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("parent_bkg_no", parentBkgNo);
			param.put("mapg_seq", mapgSeq);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateBkgSplitMapBaseCSQL(), param, param);
			log.debug("\n pc create (successFlag:" + successFlag);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;
	}

	/**
	 * @param PrdMainInfoVO prdMainInfoVO
	 * @param String mapgSeq
	 * @param String cntrLstStr
	 * @param String bkgNoLstStr
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean createBkgSplitMapCntr(PrdMainInfoVO prdMainInfoVO, String mapgSeq, String cntrLstStr, String bkgNoLstStr) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", prdMainInfoVO.getBkgNo());
			param.put("bkg_ofc", prdMainInfoVO.getBkgOfc());
			param.put("mapg_seq", mapgSeq);
			param.put("cntr_lst", cntrLstStr);
			param.put("bkg_no_list", bkgNoLstStr);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateBkgSplitMapCntrCSQL(), param, param);
			log.debug("\n pc create (successFlag:" + successFlag);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;
	}

	/**
	 * @param String parentBkgNo
	 * @param String bkgNo
	 * @param String mapSeq
	 * @param String flexHgtFlg
	 * @param String cntrTpszQty
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBkgSplitQtyCount(String parentBkgNo, String bkgNo, String mapSeq, String flexHgtFlg, String cntrTpszQty) throws DAOException {
		DBRowSet rowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("parent_bkg_no", parentBkgNo);
			param.put("bkg_no", bkgNo);
			param.put("mapg_seq", mapSeq);
			param.put("flex_hgt_flg", flexHgtFlg);
			param.put("cntr_tpsz_qty", cntrTpszQty);
			rowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchBkgSplitQtyCountRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rowset;
	}

	/**
	 * @param String por
	 * @param String pol
	 * @param String pod
	 * @param String del
	 * @param String tVvd
	 * @param String rcvT
	 * @param String delT
	 * @param String bkgNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkReplane(String por, String pol, String pod, String del, String tVvd, String rcvT, String delT, String bkgNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("por", por);
			param.put("pol", pol);
			param.put("pod", pod);
			param.put("del", del);
			param.put("t_vvd", tVvd);
			param.put("rcv_t", rcvT);
			param.put("del_t", delT);
			param.put("bkg_no", bkgNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOcheckReplaneRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPrdCtlgFullRout(String pctlNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param String pctlNo
	 * @return List<SearchPrdFullRouteVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPrdFullRouteVO> searchPrdCtlgFullRoutByPctlNo(String pctlNo) throws DAOException {
		List<SearchPrdFullRouteVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL(), param, null, SearchPrdFullRouteVO.class);
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
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPrdConstraint(String pctlNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchPrdConstraintRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @param valChkcd
	 * @param etcRmk
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public int addValCheck(String pctlNo, String valChkcd, String etcRmk, String userId) throws DAOException {
		int exeFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			param.put("rout_val_chk_cd", valChkcd);
			param.put("etc_rmk", etcRmk);
			param.put("user_id", userId);
			exeFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreatePrdValCheckCSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exeFlag;
	}

	/**
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet getSoSubRout(String bkgNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchSoSubRoutRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * PRS > COA > PRD 호출 용
	 * 
	 * @param prdCreateParamVO
	 * @param prdPcCreateVo
	 * @param usr_id
	 * @return
	 * @throws DAOException
	 */
	public int createProductCatalogIncludeReplanePRS(PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVo, String usr_id) throws DAOException {
		int exeFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("por", prdCreateParamVO.getPor());
			param.put("pol", prdCreateParamVO.getPol());
			param.put("pod", prdCreateParamVO.getPod());
			param.put("del", prdCreateParamVO.getDel());
			param.put("ld_dt", prdCreateParamVO.getLdDt());
			param.put("rcv_t", prdCreateParamVO.getRcvT());
			param.put("del_t", prdCreateParamVO.getDelT());
			param.put("com", prdCreateParamVO.getCom());
			param.put("bkg_ofc", prdCreateParamVO.getBkgOfc());
			param.put("sc_ofc", prdCreateParamVO.getScOfc());
			param.put("cre_usr_id", usr_id);
			param.put("hd_pctl_no", prdPcCreateVo.getHdPctlNo());
			param.put("pm_f", prdCreateParamVO.getPmF());
			param.put("m_pu", prdCreateParamVO.getMPu());
			param.put("f_rt", prdCreateParamVO.getFRt());
			param.put("por_n", prdCreateParamVO.getPorN());
			param.put("del_n", prdCreateParamVO.getDelN());
			param.put("skd_date", prdPcCreateVo.getSkdDate());
			param.put("skd_type", prdPcCreateVo.getSkdType());
			param.put("vvd1", prdCreateParamVO.getVvd1());
			param.put("vvd2", prdCreateParamVO.getVvd2());
			param.put("vvd3", prdCreateParamVO.getVvd3());
			param.put("vvd4", prdCreateParamVO.getVvd4());
			param.put("pol1", prdCreateParamVO.getPol1());
			param.put("pod1", prdCreateParamVO.getPod1());
			param.put("lane1", prdCreateParamVO.getLane1());
			param.put("pol2", prdCreateParamVO.getPol2());
			param.put("pod2", prdCreateParamVO.getPod2());
			param.put("lane2", prdCreateParamVO.getLane2());
			param.put("pol3", prdCreateParamVO.getPol3());
			param.put("pod3", prdCreateParamVO.getPod3());
			param.put("lane3", prdCreateParamVO.getLane3());
			param.put("pol4", prdCreateParamVO.getPol4());
			param.put("pod4", prdCreateParamVO.getPod4());
			param.put("lane4", prdCreateParamVO.getLane4());
			param.put("vvd", prdCreateParamVO.getTVvd());
			param.put("so_seq", "0");
			param.put("cgo_tp", prdCreateParamVO.getCgoTp());
			param.put("ob_trsp_mode", prdCreateParamVO.getObTrspMode());
			param.put("ib_trsp_mode", prdCreateParamVO.getIbTrspMode());
			param.put("ag_seq", "");
			param.put("ib_str", "");
			param.put("ocn_str", "");
			param.put("ob_str", "");
			param.put("pod_n", "");

			exeFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateProductCatalogInCludeReplanePRSCSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exeFlag;

	}

	/**
	 * @param prdCreateParamVo
	 * @param prdPcCreateVo
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public int createProductCatalogInternalTemp(PrdCreateParamVO prdCreateParamVo, PrdPcCreateVO prdPcCreateVo, String userId) throws DAOException {
		int exeFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("por", prdCreateParamVo.getPor());
			param.put("por_n", prdCreateParamVo.getPorN());
			param.put("pol", prdCreateParamVo.getPol());
			param.put("pod", prdCreateParamVo.getPod());
			param.put("pod_n", prdCreateParamVo.getPodN());
			param.put("del", prdCreateParamVo.getDel());
			param.put("del_n", prdCreateParamVo.getDelN());
			param.put("skd_date", prdCreateParamVo.getLdDt());
			param.put("rTerm", prdCreateParamVo.getRcvT());
			param.put("dTerm", prdCreateParamVo.getDelT());
			param.put("com", prdCreateParamVo.getCom());
			param.put("bkgOffCd", prdCreateParamVo.getBkgOfc());
			param.put("sc_ofc", prdCreateParamVo.getScOfc());
			param.put("user_id", userId);
			param.put("prdCtlNo", prdPcCreateVo.getHdPctlNo());
			param.put("pm_f", prdCreateParamVo.getPmF());
			param.put("ag_seq", ""); // COST_ACT_GRP_SEQ
			param.put("update_id", userId);
			param.put("emt_pk_yd", prdCreateParamVo.getMPu());
			param.put("emt_rtn_yd", "");
			param.put("full_rtn_yd", prdCreateParamVo.getFRt());
			param.put("ob_trsp_mode", prdCreateParamVo.getObTrspMode());
			param.put("ib_trsp_mode", prdCreateParamVo.getIbTrspMode());
			param.put("lane1", prdCreateParamVo.getLane1());
			param.put("lane2", prdCreateParamVo.getLane2());
			param.put("lane3", prdCreateParamVo.getLane3());
			param.put("lane4", prdCreateParamVo.getLane4());
			param.put("pol1", prdCreateParamVo.getPol1());
			param.put("pol2", prdCreateParamVo.getPol2());
			param.put("pol3", prdCreateParamVo.getPol3());
			param.put("pol4", prdCreateParamVo.getPol4());
			param.put("pod1", prdCreateParamVo.getPod1());
			param.put("pod2", prdCreateParamVo.getPod2());
			param.put("pod3", prdCreateParamVo.getPod3());
			param.put("pod4", prdCreateParamVo.getPod4());
			param.put("s_date", prdPcCreateVo.getSkdDate());
			param.put("s_type", prdPcCreateVo.getSkdType());
			param.put("vvd", prdCreateParamVo.getTVvd());
			param.put("vvd1", prdCreateParamVo.getVvd1());
			param.put("vvd2", prdCreateParamVo.getVvd2());
			param.put("vvd3", prdCreateParamVo.getVvd3());
			param.put("vvd4", prdCreateParamVo.getVvd4());
			param.put("cgo_tp", prdCreateParamVo.getCgoTp());
			param.put("so_seq", "0");
			exeFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateProductCatalogInternalTempCSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exeFlag;

	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchProductCatalogInternalMst_1(String pctlNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_1RSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param String bkgRcvT
	 * @param String bkgDelT
	 * @param String chgRterm
	 * @param String chgDterm
	 * @param String bkgNo
	 * @param String mapSeq
	 * @param String currentFlag
	 * @param String flxHgtFlg
	 * @param String cntrTpszQty
	 * @param String bkgOfc
	 * @return List<PrdBkgCopMapVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdBkgCopMapVO> getReplanePattern(String bkgRcvT, String bkgDelT, String chgRterm, String chgDterm, String bkgNo, String mapSeq, String currentFlag, String flxHgtFlg, String cntrTpszQty, String bkgOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrdBkgCopMapVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("rcv_t", chgRterm);
			param.put("bkg_rcv_t", bkgRcvT);
			param.put("del_t", chgDterm);
			param.put("bkg_del_t", bkgDelT);
			param.put("bkg_no", bkgNo);
			param.put("mapg_seq", mapSeq);
			param.put("current_flag", currentFlag);
			param.put("flex_hgt_flg", flxHgtFlg);
			param.put("cntr_tpsz_qty", cntrTpszQty);
			param.put("bkg_ofc", bkgOfc);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOGetReplanePatternRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PrdBkgCopMapVO.class);
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
	 * @return
	 * @throws DAOException
	 */
	public String getPrdBkgCopMapSeq() throws DAOException {
		DBRowSet dbR = null;
		String mapSeq = "";
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOGetPrdBkgCopMapSeqRSQL(), param, null);
			if (dbR.next()) {
				mapSeq = dbR.getString("map_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mapSeq;
	}

	/**
	 * @param bkgNo
	 * @param bkgNoList
	 * @throws DAOException
	 */
	public void updatePrdMapInit(String bkgNo, String bkgNoList) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		if (bkgNo.equals("")) {
			throw new DAOException((new ErrorHandler("PRD00071")).getMessage());
		}
		try {
			param.put("bkg_no", bkgNo);
			param.put("bkg_no_list", bkgNoList);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdMapInitUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * @param bkgNo
	 * @param tpsz
	 * @param cop_map_seq
	 * @return
	 * @throws DAOException
	 */
	public double getCntrTypeQty(String bkgNo, String tpsz, String cop_map_seq) throws DAOException {
		DBRowSet dbR = null;
		double qty = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_tpsz_cd", tpsz);
			param.put("cop_map_seq", cop_map_seq);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOGetCntrTypeQtyRSQL(), param, null);
			if (dbR.next()) {
				qty = Double.parseDouble(dbR.getString("qty"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return qty;
	}

	/**
	 * @param String mapSeq
	 * @return List<PrdPatternVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdPatternVO> searchCurrentPatternOrd(String mapSeq) throws DAOException {
		List<PrdPatternVO> list = new ArrayList<PrdPatternVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (mapSeq != null && !"".equals(mapSeq)) {
				param.put("cop_mapg_seq", mapSeq);
				param.put("pctl_no", "");
				param.put("bkg_no", "");
				param.put("cop_no", "");
				list = (List) new SQLExecuter().executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL(), param, param, PrdPatternVO.class);
			}
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
	 * @param pctlNo
	 * @param bkgNo
	 * @param copNo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdPatternVO> searchCurrentPatternOrd(String pctlNo, String bkgNo, String copNo) throws DAOException {
		List<PrdPatternVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			param.put("bkg_no", bkgNo);
			param.put("cop_no", copNo);
			param.put("cop_mapg_seq", "");
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL(), param, param, PrdPatternVO.class);
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
	 * @param event
	 * @param prdCreateParamVO
	 * @param prdPcCreateVo
	 * @param prdPatternVO
	 * @param usr_id
	 * @return
	 * @throws DAOException
	 */
	public int createProductCatalogIncludeReplane(EsdPrd0080Event event, PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVo, PrdPatternVO prdPatternVO, String usr_id) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			PrdQuantityVO[] prdQuantityVO = event.getPrdQuantityVOs();
			PrdSubQuantityVO[] prdSubQuantityVO = event.getPrdSubQuantityVOs();

			param.put("por", prdCreateParamVO.getPor());
			param.put("pol", prdCreateParamVO.getPol());
			param.put("pod", prdCreateParamVO.getPod());
			param.put("del", prdCreateParamVO.getDel());
			param.put("ld_dt", prdCreateParamVO.getLdDt());
			param.put("rcv_t", prdCreateParamVO.getRcvT());
			param.put("del_t", prdCreateParamVO.getDelT());
			param.put("com", prdCreateParamVO.getCom());
			param.put("bkg_ofc", prdCreateParamVO.getBkgOfc());
			param.put("sc_ofc", prdCreateParamVO.getScOfc());
			param.put("cre_usr_id", usr_id);
			param.put("hd_pctl_no", prdPcCreateVo.getHdPctlNo());
			param.put("pm_f", prdCreateParamVO.getPmF());
			param.put("m_pu", prdCreateParamVO.getMPu());
			param.put("f_rt", prdCreateParamVO.getFRt());
			param.put("por_n", prdCreateParamVO.getPorN());
			param.put("del_n", prdCreateParamVO.getDelN());
			param.put("skd_date", prdPcCreateVo.getSkdDate());
			param.put("skd_type", prdPcCreateVo.getSkdType());
			param.put("vvd1", prdCreateParamVO.getVvd1());
			param.put("vvd2", prdCreateParamVO.getVvd2());
			param.put("vvd3", prdCreateParamVO.getVvd3());
			param.put("vvd4", prdCreateParamVO.getVvd4());
			param.put("pol1", prdCreateParamVO.getPol1());
			param.put("pod1", prdCreateParamVO.getPod1());
			param.put("lane1", prdCreateParamVO.getLane1());
			param.put("pol2", prdCreateParamVO.getPol2());
			param.put("pod2", prdCreateParamVO.getPod2());
			param.put("lane2", prdCreateParamVO.getLane2());
			param.put("pol3", prdCreateParamVO.getPol3());
			param.put("pod3", prdCreateParamVO.getPod3());
			param.put("lane3", prdCreateParamVO.getLane3());
			param.put("pol4", prdCreateParamVO.getPol4());
			param.put("pod4", prdCreateParamVO.getPod4());
			param.put("lane4", prdCreateParamVO.getLane4());
			param.put("vvd", prdCreateParamVO.getTVvd());
			param.put("so_seq", "0");
			param.put("cgo_tp", prdCreateParamVO.getCgoTp());
			param.put("ob_trsp_mode", prdCreateParamVO.getObTrspMode());
			param.put("ob_prio_seq", prdCreateParamVO.getObPrioSeq());
			param.put("ib_trsp_mode", prdCreateParamVO.getIbTrspMode());
			param.put("ib_prio_seq", prdCreateParamVO.getIbPrioSeq());
			param.put("pol_n", prdCreateParamVO.getPolN());
			param.put("pod_n", prdCreateParamVO.getPodN());

			if (prdPatternVO != null) {
				param.put("ag_seq", "");
				param.put("ib_str", prdPatternVO.getIbItchgCtnt());
				param.put("ocn_str", prdPatternVO.getOcnItchgCtnt());
				param.put("ob_str", prdPatternVO.getObItchgCtnt());
				if (!prdPatternVO.getPorNodCd().equals("")) {
					param.put("por", prdPatternVO.getPorNodCd().substring(0, 5));
					param.put("por_n", prdPatternVO.getPorNodCd());
				}
				if (!prdPatternVO.getPolNodCd().equals("")) {
					if ("Y".equals(prdCreateParamVO.getIgnoreHitch())) {
						param.put("pol", prdPatternVO.getPolNodCd().substring(0, 5));
						param.put("pol1", "");
					} else {
						param.put("pol", prdPatternVO.getPolNodCd().substring(0, 5));
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
					}
				}
				if (!prdPatternVO.getBkgRcvTermCd().equals("")) {
					if (!prdCreateParamVO.getBkgRcvT().equals("M")) {
						param.put("rcv_t", prdPatternVO.getBkgRcvTermCd());
					}
				}
				if (!prdPatternVO.getBkgDeTermCd().equals("")) {
					if (!prdCreateParamVO.getBkgDelT().equals("M")) {
						param.put("del_t", prdPatternVO.getBkgDeTermCd());
					}
				}

			} else {
				param.put("ag_seq", "");
				param.put("ib_str", "");
				param.put("ocn_str", "");
				param.put("ob_str", "");
			}
			param.put("cgo_tp", prdCreateParamVO.getCgoTp());
			param.put("shpr_cnt_cd", prdCreateParamVO.getShprCntCd());
			param.put("shpr_seq", prdCreateParamVO.getShprSeq());
			param.put("cnee_cnt_cd", prdCreateParamVO.getCneeCntCd());
			param.put("cnee_seq", prdCreateParamVO.getCneeSeq());
			param.put("sc_no", prdCreateParamVO.getSc());
			param.put("rfa_no", prdCreateParamVO.getRfa());
			param.put("dg_spcl_flg", prdCreateParamVO.getDgF());
			param.put("rf_spcl_flg", prdCreateParamVO.getRfF());
			param.put("spcl_awk_cgo_flg", prdCreateParamVO.getAkF());
			param.put("bb_spcl_flg", prdCreateParamVO.getBbF());
			param.put("rd_spcl_flg", prdCreateParamVO.getRdF());
			param.put("hngr_spcl_flg", prdCreateParamVO.getHgF());
			param.put("soc_flg", prdCreateParamVO.getSocF());
			param.put("eq_subst_flg", prdCreateParamVO.getSubF());
			param.put("bkg_wgt", prdCreateParamVO.getWgt());
			param.put("bkg_wgt_ut_cd", prdCreateParamVO.getWgtUn());
			param.put("sls_ofc_cd", prdCreateParamVO.getOrgSalOfc());
			param.put("rfa_ofc_cd", prdCreateParamVO.getRfaOfc());
			param.put("prm_cust_flg", prdCreateParamVO.getPmF());
			param.put("rep_cmdt_cd", prdCreateParamVO.getRepCom());

			// in case of replane
			param.put("dg_clss_cd", prdCreateParamVO.getDgF());

			// in case of double calling
			param.put("n1st_pol_dc_seq", prdCreateParamVO.getN1stPolDcSeq());
			param.put("n1st_pod_dc_seq", prdCreateParamVO.getN1stPodDcSeq());
			param.put("n2nd_pol_dc_seq", prdCreateParamVO.getN2ndPolDcSeq());
			param.put("n2nd_pod_dc_seq", prdCreateParamVO.getN2ndPodDcSeq());
			param.put("n3rd_pol_dc_seq", prdCreateParamVO.getN3rdPolDcSeq());
			param.put("n3rd_pod_dc_seq", prdCreateParamVO.getN3rdPodDcSeq());
			param.put("n4th_pol_dc_seq", prdCreateParamVO.getN4thPolDcSeq());
			param.put("n4th_pod_dc_seq", prdCreateParamVO.getN4thPodDcSeq());

			// in case of CA Issue
			param.put("ocn_seq", prdCreateParamVO.getOcnSeq());

			param.put("pc_mode", prdCreateParamVO.getPcMode());
			param.put("bkg_no", prdCreateParamVO.getBkgNo());
			param.put("more_cnt", prdCreateParamVO.getMoreCnt());

			List<String> arrTpsz = new ArrayList<String>();
			String cgoTpCd = "";
			if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_T)) {
				if (prdCreateParamVO.getCTpsz() != null && prdCreateParamVO.getCTpsz().startsWith("R")) {
					param.put("rf_spcl_flg", "Y");
				} else if (prdCreateParamVO.getCTpsz() != null && (prdCreateParamVO.getCTpsz().startsWith("F") || prdCreateParamVO.getCTpsz().startsWith("O"))) {
					param.put("spcl_awk_cgo_flg", "Y");
				} 
				param.put("c_tpsz", prdCreateParamVO.getCTpsz());
				arrTpsz.add(prdCreateParamVO.getCTpsz());
			} else {
				param.put("c_tpsz", "");
				if (prdQuantityVO != null) {
					for (int i = 0; i < prdQuantityVO.length; i++) {
						if (prdSubQuantityVO != null && prdSubQuantityVO.length > 0) {
							arrTpsz.add(prdSubQuantityVO[i].getSTpsz());
						} else {
							arrTpsz.add(prdQuantityVO[i].getCTpsz());
						}
					}
				}
			}
			cgoTpCd =  JSPUtil.getNull(String.valueOf(param.get("dg_spcl_flg")), "N");
			cgoTpCd += JSPUtil.getNull(String.valueOf(param.get("rf_spcl_flg")), "N");
			cgoTpCd += JSPUtil.getNull(String.valueOf(param.get("spcl_awk_cgo_flg")), "N");
			cgoTpCd += JSPUtil.getNull(String.valueOf(param.get("bb_spcl_flg")), "N");
			if (cgoTpCd.indexOf("Y") > -1) {
				cgoTpCd += "N";
			} else {
				cgoTpCd += "Y";
			}
			param.put("cgo_tp_cd", cgoTpCd);
			param.put("arr_tpsz", arrTpsz);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateProductCatalogInCludeReplaneCSQL(), param, param);
			log.debug("\n pc create successFlag:" + successFlag);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param copPattOrdNo
	 * @param copMapgSeq
	 * @param minPctlNo
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdMapByPcCreate(String copPattOrdNo, String copMapgSeq, String minPctlNo, String bkgNo) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		if (CheckUtilities.isInBlank(minPctlNo)) {
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		} else if (CheckUtilities.isInBlank(copMapgSeq)) {
			throw new DAOException((new ErrorHandler("PRD00072")).getMessage());
		}
		try {
			param.put("cop_patt_ord_no", copPattOrdNo);
			param.put("cop_mapg_seq", copMapgSeq);
			param.put("pctl_no", minPctlNo);
			param.put("bkg_no", bkgNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdMapByPcCreateUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param copPattOrdNo
	 * @param copMapgSeq
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdMapByPcCreateFail(String copPattOrdNo, String copMapgSeq) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		if (CheckUtilities.isInBlank(copMapgSeq)) {
			throw new DAOException((new ErrorHandler("PRD00072")).getMessage());
		}
		try {

			param.put("cop_patt_ord_no", copPattOrdNo);
			param.put("cop_mapg_seq", copMapgSeq);
			param.put("cop_op_tp_cd", "F");
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdMapByPcCreateFailUSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param mapSeq
	 * @param bkgNo
	 * @param mainPatternPctlNo
	 * @param copPattOrdNo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdMapByPcNo(String mapSeq, String bkgNo, String mainPatternPctlNo, String copPattOrdNo) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		if (CheckUtilities.isInBlank(mapSeq)) {
			throw new DAOException((new ErrorHandler("PRD00072")).getMessage());
		}
		try {
			param.put("bkg_no", bkgNo);
			param.put("pctl_no", mainPatternPctlNo);
			param.put("cop_patt_ord_no", copPattOrdNo);
			param.put("cop_mapg_seq", mapSeq);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdMapByPcNoUSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param pctl_no
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List searchProductCatalogInternalDetail(String pctl_no) throws DAOException {
		List list = null;
		Map<String, String> param = new HashMap<String, String>();
		try {
			param.put("pctl_no", pctl_no);

			list = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchProductCatalogInternalDetailRSQL(), param, null, ProductCatalogInternalDetailVO.class);
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
	 * @param viewPctlNo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public List getPrdMst(String viewPctlNo) throws DAOException {
		List list = null;
		Map<String, String> param = new HashMap<String, String>();
		try {
			param.put("pctl_no", viewPctlNo);

			list = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchProductCatalogMstRSQL(), param, null, PrdProdCtlMstVO.class);
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
	 * @param mstVo
	 * @param sumBkgQty
	 * @param sumCTpSz
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getFreeTime(PrdProdCtlMstVO mstVo, String sumBkgQty, String sumCTpSz) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			param.put("i_z_bkg_no", "");
			param.put("i_z_vsl_cd", mstVo.getTrnkVslCd());
			param.put("i_z_voyage_no", mstVo.getTrnkSkdVoyNo());
			param.put("i_z_dir_cd", mstVo.getTrnkSkdDirCd());
			param.put("i_z_por_loc", mstVo.getPorCd());
			param.put("i_z_pol_loc", mstVo.getPolNodCd());
			param.put("i_z_pod_loc", mstVo.getPodCd());
			param.put("i_z_del_loc", mstVo.getDelCd());
			param.put("i_z_cust_cnt_cd", "");
			param.put("i_z_cust_cd", "");
			param.put("i_z_cmdt_cd", mstVo.getCmdtCd());
			param.put("i_z_rep_cmdt_cd", mstVo.getRepCmdtCd());
			param.put("i_dcs_cntr_tp", sumCTpSz);
			param.put("i_brh_sc_no", mstVo.getScNo());
			param.put("i_brh_rfa_no", mstVo.getRfaNo());
			param.put("i_z_bcntr_spe_dg", mstVo.getDgSpclFlg());
			param.put("i_z_bcntr_spe_rf", mstVo.getRfSpclFlg());
			param.put("i_z_bcntr_spe_ak", mstVo.getSpclAwkCgoFlg());
			param.put("i_z_bcntr_spe_rd", mstVo.getRdSpclFlg());
			param.put("i_z_bcntr_spe_bb", mstVo.getBbSpclFlg());
			param.put("i_z_bcntr_soc_ind", mstVo.getSocFlg());
			param.put("i_z_dbc_bkg_qty", sumBkgQty);
			param.put("i_load_due_date", mstVo.getN1stVslLodgDueDt());
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate) new ProductCatalogCreateDBDAOgetPrdProdCtlMstRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultMap;
	}

	/**
	 * @param viewPctlNo
	 * @param freeTm
	 * @param freeDay
	 * @return
	 * @throws DAOException
	 */
	public Map<String, String> getCargoReturnTime(String viewPctlNo) throws DAOException {
		Map<String, String> cargoRtnTmMap = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		try {
			param.put("pctl_no", viewPctlNo);
			DBRowSet dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOGetCargoReturnTimeRSQL(), param, null);
			if (dbR.next()) {
				// cargoRtnTmMap.put("RTN_TIME", dbR.getString("RTN_TIME"));
				cargoRtnTmMap.put("CUT_OFF", dbR.getString("CUT_OFF"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cargoRtnTmMap;
	}

	/**
	 * @param bkgPctlNo
	 * @param hdPctlNo
	 * @param i
	 * @throws DAOException
	 */
	public void createBkgCopyPrdQtyVvdUnchange(String bkgPctlNo, String hdPctlNo, int i) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_pctl_no", bkgPctlNo);
			param.put("hd_pctl_no", hdPctlNo);
			param.put("idx", i);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateBkgCopyPrdQtyVvdUnchangeCSQL(), param, null);
			log.debug("\n pc create (successFlag:" + successFlag);

			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * @param String cntrTpszQty
	 * @param String bkgNo
	 * @param String flexHgtFlg
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkQtyReplan(String cntrTpszQty, String bkgNo, String flexHgtFlg) throws DAOException {
		DBRowSet dbR = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_tpsz_qty", cntrTpszQty);
			param.put("flex_hgt_flg", flexHgtFlg);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOCheckQtyReplanRSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @param mtPkupDt
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkMtPkupDt(String pctlNo, String mtPkupDt) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("pctl_no", pctlNo);
			param.put("mt_pu_dt", mtPkupDt);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOCheckMtPuDtRSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List selectPrdMstByHdPctlNO(String hdPctlNo) throws DAOException {
		List list = null;
		Map<String, String> param = new HashMap();
		try {
			param.put("hd_pctl_no", hdPctlNo);
			DBRowSet dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSelectPrdMstByHdPctlNoRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbR, PrdProdCtlMstVO.class);
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
	 * @param pctlNo
	 * @param mtPuDt
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdDtlByMtPuDtValidate(String pctlNo, String mtPuDt) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		if (CheckUtilities.isInBlank(pctlNo))
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		try {
			param.put("pctl_no", pctlNo);
			param.put("mt_pu_dt", mtPuDt);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdDtlByMtPuDtValidateUSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public int deletePrdQtyByMtPuDtValidate(String pctlNo) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		if (CheckUtilities.isInBlank(pctlNo))
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		try {
			param.put("pctl_no", pctlNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAODeletePrdQtyByMtPuDtValidateDSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public int deletePrdActGrpByMtPuDtValidate(String pctlNo) throws DAOException {
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		if (CheckUtilities.isInBlank(pctlNo))
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());

		try {
			param.put("pctl_no", pctlNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdActGrpByPcNoDSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdMstByMtPuDtValidate(String pctlNo) throws DAOException {
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		if (CheckUtilities.isInBlank(pctlNo))
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		try {
			param.put("pctl_no", pctlNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdMstByMtPuDtCalidateUSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public String searchDirectOcn(String hdPctlNo) throws DAOException {
		String pctlNo = null;
		Map<String, String> param = new HashMap<String, String>();
		try {
			param.put("hd_pctl_no", hdPctlNo);
			DBRowSet dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchDirectOcnRSQL(), param, null);
			if (dbR.next()) {
				pctlNo = dbR.getString("pctl_no");
			} else {
				pctlNo = "FAIL";
			}
			log.debug("\n\n searchDirectOcn pc no:" + pctlNo);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return pctlNo;
	}

	/**
	 * @param pctlNo
	 * @param pseudoVvd
	 * @throws DAOException
	 */
	public void updatePrdDtlByPseudoVvd(String pctlNo, String pseudoVvd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		if (pctlNo.equals("")) {
			throw new DAOException("Pctl No not found!");
		}
		try {
			param.put("pctl_no", pctlNo);
			param.put("pseudo_vvd", pseudoVvd);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdDtlByPseudoVvdUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * @param pctlNo
	 * @param pseudoVvd
	 * @throws DAOException
	 */
	public void updatePrdMstByPseudoVvd(String pctlNo, String pseudoVvd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		if (CheckUtilities.isInBlank(pctlNo)) {
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		}
		try {
			param.put("pctl_no", pctlNo);
			param.put("pseudo_vvd", pseudoVvd);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdMstByPseudoVvdUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * @param pctlNo
	 * @param mtPkupDt
	 * @return
	 * @throws DAOException
	 */
	public int setMtPkupDt(String pctlNo, String mtPkupDt) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pctl_no", pctlNo);
			param.put("mt_pu_dt", mtPkupDt);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOSetMtPuDtUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param prdPatternVO
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdBkgCopMapBySubPatternOrdNo(PrdPatternVO prdPatternVO, String hdPctlNo) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("hd_pctl_no", hdPctlNo);
			param.put("cop_mapg_seq", prdPatternVO.getCopMapgSeq());
			param.put("bkg_no", prdPatternVO.getBkgNo());
			param.put("cop_patt_ord_no", prdPatternVO.getCopPattOrdNo());
			log.debug("\n updatePrdBkgCopMapBySubPatternOrdNo cop_patt_ord_no:" + prdPatternVO.getCopPattOrdNo());
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdBkgCopMapBySubPatternOrdNoUSQL(), param, null);
			log.debug("\n updatePrdBkgCopMapBySubPatternOrdNo successFlag:" + successFlag);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;

	}

	/**
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String chkEurDr(String bkgNo) throws DAOException {
		String eurDrFlg = null;
		Map<String, String> param = new HashMap<String, String>();
		try {
			param.put("bkg_no", bkgNo);
			DBRowSet dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchEurDoorChkRSQL(), param, null);
			if (dbR.next()) {
				eurDrFlg = dbR.getString("EUR_DR_CHK");
			} else {
				eurDrFlg = "N";
			}
			log.debug("\n\n EUR Door Chk:" + eurDrFlg);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eurDrFlg;
	}

	/**
	 * @param bkgNo
	 * @param mapSeq
	 * @throws DAOException
	 */
	public void updatePrdMapReInit(String bkgNo, String mapSeq) throws DAOException {
		Map<String, String> param = new HashMap<String, String>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("mapSeq", mapSeq);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOUpdatePrdMapReInitUSQLUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * @param bkgNo
	 * @param mapSeq
	 * @return List<PrdSearchEurDrRePatternVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdSearchEurDrRePatternVO> getEurDr(String bkgNo, String mapSeq) throws DAOException {
		List<PrdSearchEurDrRePatternVO> list = null;
		Map<String, String> param = new HashMap<String, String>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("mapSeq", mapSeq);
			DBRowSet dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchEurDrRePatternRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbR, PrdSearchEurDrRePatternVO.class);
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
	 * @param obPctlNo
	 * @param ibPctlNo
	 * @param ocnPctlNo
	 * @param newPctlNo
	 * @return
	 * @throws DAOException
	 */
	public int reCreatePrdForEurDoor(String obPctlNo, String ibPctlNo, String ocnPctlNo, String newPctlNo) throws DAOException {
		Map<String, String> param = new HashMap<String, String>();
		int exeFlag = 0;
		try {
			param.put("obPctlNo", obPctlNo);
			param.put("ibPctlNo", ibPctlNo);
			param.put("ocnPctlNo", ocnPctlNo);
			param.put("newPctlNo", newPctlNo);
			exeFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateProductCatalogForEurDrCSQL(), param, null);
			log.debug("\n pc create (successFlag:" + exeFlag);
			if (exeFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exeFlag;
	}

	/**
	 * @param logDesc
	 * @param applInfo
	 * @param usrId
	 * @throws DAOException
	 */
	public void createPrdExecLog(String logDesc, String applInfo, String usrId) throws DAOException {
		Map<String, String> param = new HashMap<String, String>();
		int exeFlag = 0;
		try {
			param.put("mod_name", "PRD id:" + usrId);
			param.put("log_desc", logDesc);
			param.put("appl_info", applInfo.length() > 30 ? applInfo.substring(0, 29) : applInfo);
			exeFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOPrdExecLogCSQL(), param, null);
			log.debug("\n pc create (successFlag:" + exeFlag);
			if (exeFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * PrdBkgCopMapVO 배열을 한번에 Insert함
	 * 
	 * @param List<PrdBkgCopMapVO> prdBkgCopMapVOs 데이터객체 배열
	 * @throws DAOException
	 */
	public void addReplanPatterns(List<PrdBkgCopMapVO> prdBkgCopMapVOs) throws DAOException, Exception {
		try {
			if (prdBkgCopMapVOs.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new ProductCatalogCreateDBDAOAddReplanPatternsCSQL(), prdBkgCopMapVOs, null);
				for (int i = 0; insCnt != null && i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * @param String bkgNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkBkgQty(String bkgNo) throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOCheckBkgQtyRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param PrdMainInfoVO prdMainInfoVO
	 * @param String adjTpszQty D4@1,D5@2 형식의 container size type 및 quantity (조정을 위한 qty만 들어온다)
	 * @param String mapgSeq
	 * @param String bkgNoLstStr
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean createBkgSplitMapAdj(PrdMainInfoVO prdMainInfoVO, String adjTpszQty, String mapgSeq, String bkgNoLstStr) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", prdMainInfoVO.getBkgNo());
			param.put("parent_bkg_no", prdMainInfoVO.getParentBkgNo());
			param.put("bkg_ofc", prdMainInfoVO.getBkgOfc());
			param.put("adj_tpsz_qty", adjTpszQty);
			param.put("flex_hgt_flg", "");
			param.put("mapg_seq", mapgSeq);
			param.put("bkg_no_list", bkgNoLstStr);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateBkgSplitMapAdjCSQL(), param, null);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;

	}

	/**
	 * @param String parentBkgNo
	 * @param String bkgNo
	 * @param String mapgSeq
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean createBkgSplitMapCopAdj(String parentBkgNo, String bkgNo, String mapgSeq) throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("parent_bkg_no", parentBkgNo);
			param.put("mapg_seq", mapgSeq);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOCreateBkgSplitMapCopAdjUSQL(), param, null);
			log.debug("\n pc create (successFlag:" + successFlag);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;

	}

	/**
	 * @param parentBkgNo
	 * @param bkgNoList
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkBeforeBkgSplit(String parentBkgNo, String bkgNoList) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbR = null;
		boolean rtnChk = true;
		try {
			param.put("bkg_no", parentBkgNo);
			param.put("bkg_no_list", bkgNoList);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOCheckBeforeBkgSplitRSQL(), param, null);
			if (dbR.next()) {
				if ("1".equals(dbR.getString("CHK_EXISTS"))) {
					rtnChk = false;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnChk;
	}

	/**
	 * checkEmptyPickUpYardValid
	 * 
	 * @param yard
	 * @return String
	 * @throws DAOException
	 */
	public String checkEmptyPickUpYardValid(String yard) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbR = null;
		String chkYd = "0";
		try {
			param.put("chk_yd", yard);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOCheckEmptyPickUpYardValidRSQL(), param, null);
			if (dbR.next()) {
				chkYd = dbR.getString("CNT");
			}
			return chkYd;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * searchProdOceanRout
	 * 
	 * @param prdCreateParamVO
	 * @return
	 * @throws DAOException
	 */
	public int searchProdOceanRout(PrdCreateParamVO prdCreateParamVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int oceanRouteCount = 0;
		try {
			param.put("por", prdCreateParamVO.getPor());
			param.put("pol", prdCreateParamVO.getPol());
			param.put("pod", prdCreateParamVO.getPod());
			param.put("del", prdCreateParamVO.getDel());
			param.put("lane1", prdCreateParamVO.getLane1());
			param.put("lane2", prdCreateParamVO.getLane2());
			DBRowSet ds = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchProdOceanRoutRSQL(), param, null);
			if (ds.next()) {
				oceanRouteCount = ds.getInt("cnt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return oceanRouteCount;
	}

	/**
	 * checkTpSz
	 * 
	 * @param cntr_tpsz_cd
	 * @return String
	 * @throws DAOException
	 */
	public String checkTpSz(String cntr_tpsz_cd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbR = null;
		String isExistsFlg = "0";
		try {
			param.put("cntr_tpsz_cd", cntr_tpsz_cd);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOCheckTpSzRSQL(), param, null);
			if (dbR.next()) {
				isExistsFlg = dbR.getString("CNT");
			}
			return isExistsFlg;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * modifyPrdProdCtlMstByPRI
	 * 
	 * @param prdPriSetParamVO
	 * @return
	 * @throws DAOException
	 */
	public int modifyPrdProdCtlMstByPRI(PrdPriSetParamVO prdPriSetParamVO) throws DAOException {
		int insCnt = 0;
		try {
			Map<String, String> param = prdPriSetParamVO.getColumnValues();
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new ProductCatalogCreateDBDAOModifyPrdProdCtlMstByPRIUSQL(), param, param);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
			return insCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * searchInlandCutOffTime
	 * 
	 * @param pctl_no
	 * @return
	 */
	public String searchInlandCutOffTime(String pctl_no) {
		String inLandCutOffTime = "";
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("pctl_no", pctl_no);
			DBRowSet ds = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateDBDAOSearchInlandCutOffTimeRSQL(), param, null);
			if (ds != null && ds.next()) {
				inLandCutOffTime = ds.getString("in_land_cct");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return inLandCutOffTime;
	}
}
