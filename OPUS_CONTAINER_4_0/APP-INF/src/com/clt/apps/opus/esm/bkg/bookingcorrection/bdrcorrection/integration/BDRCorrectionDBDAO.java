/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAO.java
*@FileTitle : BDR_Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.11 김영출
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.10.29 신자영 [CHM-201006625-01] C/A Exemption 하드코딩 Case추가
* 2010.11.05 신자영 [CHM-201006646-01] C/A Exemption 하드코딩 Case추가건(2)
* 2010.11.16 김영철 [] 메소드 이름은 소문자로 시작한다. (search3thPtyOfcCdCng())
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaChargeVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaCustVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaGeneralVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaListByBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CurCaUsrVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration.PerformanceReportDBDAOCaIssueDateInVOUSQL;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCorrectionVO;


/**
 * OPUS BDRCorrectionDBDAO <br>
 * - OPUS-BookingCorrection system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Youngchul
 * @see BDRCorrectionBCImpl 참조 
 * @since J2EE 1.4
 */
public class BDRCorrectionDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6811962546690172572L;

	/**
	 * 해당 bkg에대해 c/a 중인 user 조회<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return CurCaUsrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CurCaUsrVO searchCurCaUsr(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		CurCaUsrVO curCaUsrVO = null;
		List<CurCaUsrVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter().executeQuery(new BDRCorrectionDBDAOSearchCurCaUsrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CurCaUsrVO.class);
			if (list != null && list.size() > 0) {
				curCaUsrVO = (CurCaUsrVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return curCaUsrVO;
	}
	
    /**
	 * bkg_correction 에 insert 처리한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgCorrectionVO vo
	 * @exception DAOException
	 */
	public void addBkgCorrection(BkgCorrectionVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BDRCorrectionDBDAOAddBkgCorrectionCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
    /**
	 * bkg_correction 에 copy 처리한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyBkgCorrection(BkgBlNoVO vo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			param.put("corr_usr_id", account.getUsr_id());
			param.put("upd_usr_id",  account.getUsr_id());
			
			velParam.putAll(mapVO);
			velParam.put("corr_usr_id", account.getUsr_id());
			velParam.put("upd_usr_id",  account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BDRCorrectionDBDAOCopyBkgCorrectionCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

    /**
	 * bkg_correction 에 delete 처리한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @exception DAOException
	 */
	public void removeBkgCorrection(BkgBlNoVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BDRCorrectionDBDAORemoveBkgCorrectionDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01155").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bkg_Correction 에 넣을 모든 Config Flag 조회<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return BkgCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCorrectionVO searchCngItemFlag(BkgBlNoVO vo) throws DAOException {
		DBRowSet              dbRowset = null;
		List<BkgCorrectionVO> list     = null;
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCngItemFlagRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCorrectionVO.class);

			if (list != null && list.size() > 0) {
				bkgCorrectionVO = (BkgCorrectionVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgCorrectionVO;
	}

	/**
	 * Bkg_Correction 조회<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return BkgCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCorrectionVO searchBkgCorrection(BkgBlNoVO vo) throws DAOException {
		DBRowSet              dbRowset = null;
		List<BkgCorrectionVO> list     = null;
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchBkgCorrectionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCorrectionVO.class);

			if (list != null && list.size() > 0) {
				bkgCorrectionVO = (BkgCorrectionVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgCorrectionVO;
	}

	/**
	 * C/A 관리 항목 중 아래 6개 항목이 변경되었는지 확인한다.<br>
	 * : ROUT_CORR_FLG/RCVDE_TERM_CORR_FLG/TRNK_VSL_CORR_FLG/CMDT_CORR_FLG/MEAS_QTY_CORR_FLG/CHG_TERM_CORR_FLG<br>
	 * @author Lee NamKyung
	 * @param  BkgCorrectionVO vo
	 * @return BkgCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCorrectionVO searchBkgCng(BkgCorrectionVO vo) throws DAOException {
		DBRowSet              dbRowset = null;
		List<BkgCorrectionVO> list     = null;
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchBkgCngRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCorrectionVO.class);

			if (list != null && list.size() > 0) {
				bkgCorrectionVO = (BkgCorrectionVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgCorrectionVO;
	}

	/**
	 * C/A 관리 항목 중 CUST_CORR_FLG 항목이 변경되었는지 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgCorrectionVO vo
	 * @return BkgCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCorrectionVO searchCustCng(BkgCorrectionVO vo) throws DAOException {
		DBRowSet              dbRowset = null;
		List<BkgCorrectionVO> list     = null;
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCustCngRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCorrectionVO.class);

			if (list != null && list.size() > 0) {
				bkgCorrectionVO = (BkgCorrectionVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgCorrectionVO;
	}
	
	/**
	 * C/A 관리 항목 중 RT_CORR_FLG 항목이 변경되었는지 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgCorrectionVO vo
	 * @return BkgCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCorrectionVO searchRateCng(BkgCorrectionVO vo) throws DAOException {
		DBRowSet              dbRowset = null;
		List<BkgCorrectionVO> list     = null;
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchRateCngRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCorrectionVO.class);

			if (list != null && list.size() > 0) {
				bkgCorrectionVO = (BkgCorrectionVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgCorrectionVO;
	}
	
	/**
	 * C/A 관리 항목 중 QTY_CORR_FLG 항목이 변경되었는지 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgCorrectionVO vo
	 * @return BkgCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCorrectionVO searchQtyCng(BkgCorrectionVO vo) throws DAOException {
		DBRowSet              dbRowset = null;
		List<BkgCorrectionVO> list     = null;
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchQtyCngRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCorrectionVO.class);

			if (list != null && list.size() > 0) {
				bkgCorrectionVO = (BkgCorrectionVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgCorrectionVO;
	}
	
	/**
	 * C/A 관리 항목 중 PRPST_VSL_CORR_FLG 항목이 변경되었는지 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgCorrectionVO vo
	 * @return BkgCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCorrectionVO searchVvdCng(BkgCorrectionVO vo) throws DAOException {
		DBRowSet              dbRowset = null;
		List<BkgCorrectionVO> list     = null;
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchVvdCngRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCorrectionVO.class);

			if (list != null && list.size() > 0) {
				bkgCorrectionVO = (BkgCorrectionVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgCorrectionVO;
	}
	
	/**
	 * OFT(ocean Freight Charge)가 변경되었는지 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchOftChn(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchOftChnRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("chn_flg");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}
	
	/**
	 * bkg_chg_rt 의 row 중 frt_term_cd가 변경된 row가 있으면 true를 리턴한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchPayTermCng(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchPayTermChngRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("chn_flg");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}

	/**
	 * 원본 bkg, temp bkg 간 weight, measure 변경 여부를 확인한다.<br>
	 * : bkg_bl_doc, bkg_container, bkg_cntr_mf_desc 테이블에서<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchWgtMeasCng(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchWgtMeasCngRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("wgt_meas_cng");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}
	
	/**
	 * pre vsl 있을 때 t.vvd가 변경되었는지 확인한다.<br>
	 * : bkg_bl_doc, bkg_container, bkg_cntr_mf_desc 테이블에서<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchTrnkCngWhenPreVslExist(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchTrnkCngWhenPreVslExistRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("trnk_cng");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}
	
	/**
	 * Post Vsl 변경되었는지 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchPstVslCng(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchPstVslCngRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("trnk_cng");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}

	/**
	 * vsl skip, phase i/o 의 사유로 post vvd가 변경되었는지 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchVslSkip(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchVslSkipRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("vslskip");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}

	/**
	 * bkg_rate에서 cct payer변경 여부를 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchCltPayerCng(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCltPayerCngRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("PAYER_CNG");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}

	/*=====================================================================================
	* 2010.10.29 신자영 [CHM-201006625-01] searchCneeCdCng operation 추가
	*======================================================================================*/
	/**
	 * BKG_CUSTOMER에서 Cnee code 변경 여부를 확인한다.<br>
	 * @author Shin Jayoung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchCneeCdCng(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCneeCdCngRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("CHN_FLG");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}
	/*=====================================================================================
	* 2010.11.05 신자영 [CHM-201006646-01] search3thPtyOfcCdCng operation추가 작업
	*======================================================================================*/
	/**
	 * BKG_CHG_RT에서 3th Party Office 변경 여부를 확인한다.<br>
	 * @author Shin Jayoung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean search3thPtyOfcCdCng(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearch3thPtyOfcCdCngRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("CHN_FLG");
				if ("Y".equals(strResult)) {
					bResult = true;
					log.debug(bResult);
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}
	
	/**
	 * customer(bkg_customer)나 qty(bkg_quantity)가 변경되고 DIH charge 변경 여부를 확인한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchDihCng(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		boolean      bResult   = false;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchDihCngRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("dih_cng");
				if ("Y".equals(strResult)) {
					bResult = true;
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}
	
	/**
	 * pod, del 을 붙여서 10자리로 return한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return String
	 * @exception DAOException
	 */
	public String searchPodDel(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchPodDelRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("poddel");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strResult;
	}
	
	/**
	 * bkg_chg_rt/bkg_chg_rt_his 추가된 charge code를 조회해서 return한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchAddCharge(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		List<String> list      = new ArrayList<String>();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchAddChargeRSQL(), param, velParam);
			for (int i=0; i<dbRowset.getRowCount(); i++) {
   			    dbRowset.next();
   			    String strTemp = dbRowset.getString("chg_cd_his");
   			    list.add(strTemp);
			}

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * bkg_chg_rt/bkg_chg_rt_his 수정된 charge code를 조회해서 return한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchModifyCharge(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		List<String> list      = new ArrayList<String>();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchModifyChargeRSQL(), param, velParam);
			for (int i=0; i<dbRowset.getRowCount(); i++) {
   			    dbRowset.next();
   			    String strTemp = dbRowset.getString("chg_cd");
   			    list.add(strTemp);
			}

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * bkg_chg_rt/bkg_chg_rt_his 삭제된 charge code를 조회해서 return한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchDelCharge(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		List<String> list      = new ArrayList<String>();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchDelChargeRSQL(), param, velParam);
			for (int i=0; i<dbRowset.getRowCount(); i++) {
   			    dbRowset.next();
   			    String strTemp = dbRowset.getString("chg_cd");
   			    list.add(strTemp);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
    /**
	 * bkg_correction 에 update 처리한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgCorrectionVO vo
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgCorrection(BkgCorrectionVO vo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			param.put("corr_usr_id",  account.getUsr_id());
			param.put("upd_usr_id",   account.getUsr_id());
			
			velParam.putAll(mapVO);
			velParam.put("corr_usr_id",  account.getUsr_id());
			velParam.put("upd_usr_id",   account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BDRCorrectionDBDAOModifyBkgCorrectionUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

    /**
	 * bkg_correction 에 update 처리한다.<br>
	 * @author Lee NamKyung
	 * @param  String caIssReasonCd
	 * @param  String caRemark
	 * @param  BkgBlNoVO vo
	 * @param  String rdnAcptFlg
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyCaRsnRmk(String caIssReasonCd, String caRemark, BkgBlNoVO vo, String rdnAcptFlg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			param.put("ca_rsn_cd",    caIssReasonCd);
			param.put("bkg_corr_rmk", caRemark);
			param.put("rdn_acpt_flg", rdnAcptFlg);
			param.put("upd_usr_id",   account.getUsr_id());
			velParam.putAll(mapVO);
			velParam.put("ca_rsn_cd",    caIssReasonCd);
			velParam.put("bkg_corr_rmk", caRemark);
			velParam.put("rdn_acpt_flg", rdnAcptFlg);
			velParam.put("upd_usr_id",   account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BDRCorrectionDBDAOModifyCaReasonUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CA Resaon/Remark 정보 조회한다.<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return CaRsnRmkVO 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CaRsnRmkVO searchCaRsnRmk(BkgBlNoVO vo) throws DAOException {
		DBRowSet         dbRowset = null;
		List<CaRsnRmkVO> list     = null;
		CaRsnRmkVO caRsnRmkVO = new CaRsnRmkVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCaRsnRmkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaRsnRmkVO.class);

			if (list != null && list.size() > 0) {
				caRsnRmkVO = (CaRsnRmkVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return caRsnRmkVO;
	}

	/**
	 * bkg별 c/a list를 조회한다.(kind 포함)<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return CaBkgInfoVO 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CaBkgInfoVO searchCaBkgInfo(BkgBlNoVO vo) throws DAOException {
		DBRowSet         dbRowset = null;
		List<CaBkgInfoVO> list     = null;
		CaBkgInfoVO caBkgInfoVO = new CaBkgInfoVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCaBkgInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaBkgInfoVO.class);

			if (list != null && list.size() > 0) {
				caBkgInfoVO = (CaBkgInfoVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return caBkgInfoVO;
	}
	
	/**
	 * bkg별 c/a list를 조회한다.(kind 포함)<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return List<CaListByBkgVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CaListByBkgVO> searchCaListByBkg(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaListByBkgVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCaListByBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaListByBkgVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * c/a 건별 일반 정보 변경 이력을 조회한다.<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return List<CaGeneralVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CaGeneralVO> searchCaGeneral(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaGeneralVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCaGeneralRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaGeneralVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * c/a 건벌 charge 정보 변경 이력을 조회한다.<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return List<CaChargeVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CaChargeVO> searchCaCharge(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaChargeVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCaChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaChargeVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * c/a 건벌 customer 정보 변경 이력을 조회한다.<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return List<CaCustVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CaCustVO> searchCaCust(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaCustVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchCaCustRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCustVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * c/a이력이 있는지 없는지 조회한다.<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return String
	 * @exception DAOException
	 */
	public String search1stCaExist(BkgBlNoVO vo) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearch1stCaExistRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				strResult = dbRowset.getString("exist_yn");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strResult;
	}
	 
    /**
     * c/a 완료시 replan할 필요가 있는지 조회한다.<br>
     * @author Ryu Daeyoung
     * @param  BkgBlNoVO bkgBlNoVO
     * @return List<CorrReplanVO>
     * @exception EventException
     */ 
	@SuppressWarnings("unchecked")
	public List<CorrReplanVO> searchCorrReplan(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CorrReplanVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter().executeQuery(new BDRCorrectionDBDAOSearchCorrReplanRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CorrReplanVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;		
	}
	
	/**
	  * 0568 C/A Report Remark를 수정합니다.<br>
	  * 
	  * @param CaIssueDateInVO vo 
	  * @exception  DAOException
	  */
	 public void modifyCaIssueRemark(CaIssueDateInVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
		
		 try{
			 if(vo != null){
					Map<String, String> mapVO = vo.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceReportDBDAOCaIssueDateInVOUSQL(), param,velParam);
				
				if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());

		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
	/**
	 * Last Correction No를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
     * @return BkgBlNoVO
	 * @throws EventException
	 */
	public BkgBlNoVO searchLstCorrNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet     dbRowset  = null;
		String       strResult = "";
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=bkgBlNoVO) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BDRCorrectionDBDAOSearchLstCorrNoRSQL(), param, velParam);
				if (dbRowset.next()) {
					strResult = dbRowset.getString("corr_no");
				}
				
				if ("".equals(strResult)) {
					bkgBlNoVO.setCaNo("");
				} else {
					bkgBlNoVO.setCaNo(strResult);
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgBlNoVO;
	}		 
}
