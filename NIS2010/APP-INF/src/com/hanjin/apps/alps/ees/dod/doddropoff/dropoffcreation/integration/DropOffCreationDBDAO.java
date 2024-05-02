/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffCreationDBDAO.java
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.basic.DropOffCreationBCImpl;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.DropOffDiscountDetailVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS DropOffCreationDBDAO <br>
 * - ALPS-DodDropOff system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Son, Jin-Hwan
 * @see DropOffCreationBCImpl 참조
 * @since J2EE 1.6
 */
public class DropOffCreationDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dataSource = "";
	
	/**
	 * DropOffCreationDBDAO 객체 생성<br>
	 * DropOffCreationDBDAO 를 생성한다.<br>
	 */
	public DropOffCreationDBDAO() {	}

	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 대상]을 [조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String drpOffChgSeq
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchDodDrpOffChgVO(String bkgNo, String cntrNo, String drpOffChgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		SearchDodDrpOffChgVO rsVO = new SearchDodDrpOffChgVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no" , bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("drp_off_chg_seq", drpOffChgSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchDodDrpOffChgVORSQL(), param, null);
			if(dbRowset.next()) {
				rsVO.setBkgNo(dbRowset.getString("bkg_no"));
				rsVO.setCntrNo(dbRowset.getString("cntr_no"));
				rsVO.setDrpOffChgSeq(dbRowset.getString("drp_off_chg_seq"));
				rsVO.setInvSrcNo(dbRowset.getString("inv_src_no"));
				rsVO.setArIfNo("");
				rsVO.setDrpOffChgTrfSeq(dbRowset.getString("drp_off_chg_trf_seq"));
				rsVO.setDrpOffChgMnlFlg(dbRowset.getString("drp_off_chg_mnl_flg"));
				rsVO.setDrpOffChgTrfSpclSeq(dbRowset.getString("drp_off_chg_trf_spcl_seq"));
				rsVO.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
				rsVO.setOfcCd(dbRowset.getString("tro_ib_cfm_ofc_cd"));
				rsVO.setTroIbCfmOfcCd(dbRowset.getString("tro_ib_cfm_ofc_cd"));
				rsVO.setTroIbCfmDt(dbRowset.getDate("tro_ib_cfm_dt").toString().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				rsVO.setDelCd(dbRowset.getString("del_cd"));
				rsVO.setCntrRtnYdCd(dbRowset.getString("cntr_rtn_yd_cd"));
				rsVO.setCntrRtnDt(dbRowset.getDate("cntr_rtn_dt").toString().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				rsVO.setCustCntCd(dbRowset.getString("cust_cnt_cd"));
				rsVO.setCustSeq(dbRowset.getString("cust_seq"));
				rsVO.setSpclCustCntCd(dbRowset.getString("spcl_cust_cnt_cd"));
				rsVO.setSpclCustSeq(dbRowset.getString("spcl_cust_seq"));
				rsVO.setCurrCd(dbRowset.getString("curr_cd"));
				rsVO.setGenTrfAmt(dbRowset.getString("gen_trf_amt"));
				rsVO.setSpclTrfAmt(dbRowset.getString("spcl_trf_amt"));
				rsVO.setDcAmt(dbRowset.getString("dc_amt"));
				rsVO.setSvcFeeAmt(dbRowset.getString("svc_fee_amt"));
				rsVO.setTtlAmt(dbRowset.getString("ttl_amt"));
				rsVO.setDcRmk(dbRowset.getString("dc_rmk"));
				rsVO.setDeltFlg(dbRowset.getString("delt_flg"));
				rsVO.setCreUsrId(dbRowset.getString("cre_usr_id"));
				rsVO.setCreDt(dbRowset.getDate("cre_dt").toString().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				rsVO.setUpdUsrId(dbRowset.getString("upd_usr_id"));
				rsVO.setUpdDt(dbRowset.getDate("upd_dt").toString().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				rsVO.setTroIbCxlFlg(dbRowset.getString("tro_ib_cxl_flg"));
				rsVO.setAtchFileLnkId(dbRowset.getString("atch_file_lnk_id"));
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	 
	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 대상목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDodDrpOffChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchDodDrpOffChgVOListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodDrpOffChgVO.class);
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
		 * EES_DOD_0001 : [SEARCH]<br>
		 * [Drop Off Charge 대상목록]을 [조회]합니다.<br>
		 * 
		 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
		 * @return List<SearchDodDrpOffChgVO>
		 * @exception EventException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList2(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchDodDrpOffChgVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchDodDrpOffChgVO != null){
					Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchDodDrpOffChgVOList2RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodDrpOffChgVO.class);
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
	 * EES_DOD_0001 : [SEARCH01]<br>
	 * [Drop Off Charge 면제 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOExptList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDodDrpOffChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchDodDrpOffChgVOExptListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodDrpOffChgVO.class);
			
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
	 * EES_DOD_0001 : [MULTI]<br>
	 * [Drop Off Charge대상]을 [AR로 보내어 Invoice를 생성]합니다.<br>
	 * 
	 * @param searchDodDrpOffChgVO searchDodDrpOffChgVO
	 * @param usrId String 
	 * @exception EventException
	 */
	 public void manageArInvList(SearchDodDrpOffChgVO searchDodDrpOffChgVO, String usrId) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
            param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new DropOffCreationDBDAOSearchDodDrpOffChgVOCSQL(), param, velParam);
			
			if(result== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * EES_DOD_0002 : [SEARCH]<br>
	 * [Drop Off Charge 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDodDrpOffChgVO> searchMnlDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDodDrpOffChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(searchDodDrpOffChgVO.getBkgNo() != null && searchDodDrpOffChgVO.getBkgNo().length() > 0) {
					List<String> bkgNos = new ArrayList<String>();
					String[] arrBkgNo = searchDodDrpOffChgVO.getBkgNo().split(",");
					for(int i = 0; i < arrBkgNo.length; i++) {
						bkgNos.add(arrBkgNo[i]);
					}

					param.put("bkgNos", bkgNos);
					velParam.put("bkgNos", bkgNos);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchMnlDodDrpOffChgVOListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodDrpOffChgVO.class);
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
	 * EES_DOD_0002 : [SEARCH09]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @param String spclCdSeq
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY(String bkgNo, String cntrNo, String cntrRtnYdCd, String spclCdSeq) throws DAOException {
		DBRowSet dbRowset = null;
		SearchDodDrpOffChgVO rsVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("cntr_rtn_yd_cd", cntrRtnYdCd);
			param.put("spcl_cd_seq", spclCdSeq);
			velParam.putAll(param);

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchTariffForRTNCYRSQL(), param, velParam);
			if(dbRowset.next()) {
				rsVO = new SearchDodDrpOffChgVO();
				rsVO.setCurrCd(dbRowset.getString("curr_cd"));
				rsVO.setDrpOffChgTrfSeq(dbRowset.getString("drp_off_chg_trf_seq"));
				rsVO.setGenTrfAmt(dbRowset.getString("gen_trf_amt"));
				rsVO.setDrpOffChgTrfSpclSeq(dbRowset.getString("drp_off_chg_trf_spcl_seq"));
				rsVO.setSpclTrfAmt(dbRowset.getString("spcl_trf_amt"));
			}else{
				rsVO = new SearchDodDrpOffChgVO();
				rsVO.setCurrCd("");
				rsVO.setDrpOffChgTrfSeq("");
				rsVO.setGenTrfAmt("");
				rsVO.setDrpOffChgTrfSpclSeq("");
				rsVO.setSpclTrfAmt("");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}

	/**
	 * EES_DOD_0013 : [SEARCH]<br>
	 * [EES_DOD_0001에서 호출하여 AR INV 보내기전 RTN CY를 변경할 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDodDrpOffChgVO> searchCrrDodDrpOffChgVO(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDodDrpOffChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchCrrDodDrpOffChgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodDrpOffChgVO.class);
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
	 * EES_DOD_0013 : [SEARCH01]<br>
	 * [EES_DOD_0004에서 호출하여 AR INV 보내고 난 후 CY를 변경할 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDodDrpOffChgVO> searchCrrDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDodDrpOffChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchCrrDodDrpOffChgVOListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodDrpOffChgVO.class);
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
	 * EES_DOD_0013 : [SEARCH02]<br>
	 * [Correction AR INV 수행 전에 이전 AR INV 수행 건에 대한 I/F 상태값]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInvErpIfStsCd(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		String rtnVal = "";
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchInvErpIfStsCdRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnVal = dbRowset.getString("INV_ERP_IF_STS_CD");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	 
	/**
	 * EES_DOD_0013 : [SEARCH08]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY1(String bkgNo, String cntrNo, String cntrRtnYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		SearchDodDrpOffChgVO rsVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("cntr_rtn_yd_cd", cntrRtnYdCd);
			velParam.putAll(param);

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchTariffForRTNCY1RSQL(), param, velParam);
			if(dbRowset.next()) {
				rsVO = new SearchDodDrpOffChgVO();
				rsVO.setCurrCd(dbRowset.getString("curr_cd"));
				rsVO.setDrpOffChgTrfSeq(dbRowset.getString("drp_off_chg_trf_seq"));
				rsVO.setGenTrfAmt(dbRowset.getString("gen_trf_amt"));
				rsVO.setDrpOffChgTrfSpclSeq(dbRowset.getString("drp_off_chg_trf_spcl_seq"));
				rsVO.setSpclTrfAmt(dbRowset.getString("spcl_trf_amt"));
			}else{
				rsVO = new SearchDodDrpOffChgVO();
				rsVO.setCurrCd("");
				rsVO.setDrpOffChgTrfSeq("");
				rsVO.setGenTrfAmt("");
				rsVO.setDrpOffChgTrfSpclSeq("");
				rsVO.setSpclTrfAmt("");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
		
	/**
	 * EES_DOD_0013 : [SEARCH09]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY2(String bkgNo, String cntrNo, String cntrRtnYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		SearchDodDrpOffChgVO rsVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("cntr_rtn_yd_cd", cntrRtnYdCd);
			velParam.putAll(param);

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchTariffForRTNCY2RSQL(), param, velParam);
			if(dbRowset.next()) {
				rsVO = new SearchDodDrpOffChgVO();
				rsVO.setCurrCd(dbRowset.getString("curr_cd"));
				rsVO.setDrpOffChgTrfSeq(dbRowset.getString("drp_off_chg_trf_seq"));
				rsVO.setGenTrfAmt(dbRowset.getString("gen_trf_amt"));
				rsVO.setDrpOffChgTrfSpclSeq(dbRowset.getString("drp_off_chg_trf_spcl_seq"));
				rsVO.setSpclTrfAmt(dbRowset.getString("spcl_trf_amt"));
			}else{
				rsVO = new SearchDodDrpOffChgVO();
				rsVO.setCurrCd("");
				rsVO.setDrpOffChgTrfSeq("");
				rsVO.setGenTrfAmt("");
				rsVO.setDrpOffChgTrfSpclSeq("");
				rsVO.setSpclTrfAmt("");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * [AR Interface]에 전달할 내용을 [조회]한다.
	 * 
	 * @param SearchDodDrpOffChgVO searchDodDrpOffChgVO
	 * @return InvArIfMnVO invArIfMnVO
	 * @throws EventException
	 */
	public InvArIfMnVO searchARInterfaceInvoice(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if("Y".equals(searchDodDrpOffChgVO.getDrpOffChgMnlFlg())) { // Manual Invoice Creation에서 가져올때
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchARInvoiceIFMnVOForManualRSQL(), param, velParam);
				
			}else{ // Invoice Creation & Correction에서 가져올때
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchARInvoiceIFMnVORSQL(), param, velParam);
				
			}
			log.error("\n searchARInterfaceInvoice : InvArIfMnVO : rowcount : " + dbRowset.getRowCount());
			if(dbRowset.next()) {
            	invArIfMnVO.setBlSrcNo(dbRowset.getString("bl_no"));
            	invArIfMnVO.setInvSrcNo(dbRowset.getString("inv_src_no"));
            	invArIfMnVO.setBkgNo(dbRowset.getString("bkg_no"));
            	invArIfMnVO.setCustCntCd(dbRowset.getString("cust_cnt_cd"));
            	invArIfMnVO.setCustSeq(dbRowset.getString("cust_seq"));
            	invArIfMnVO.setOfcCd(dbRowset.getString("ofc_cd"));
            	invArIfMnVO.setIfSrcCd(dbRowset.getString("if_src_cd"));
            	invArIfMnVO.setVslCd(dbRowset.getString("vsl_cd"));
            	invArIfMnVO.setSkdVoyNo(dbRowset.getString("skd_voy_no"));
            	invArIfMnVO.setSkdDirCd(dbRowset.getString("skd_dir_cd"));
            	invArIfMnVO.setPolCd(dbRowset.getString("pol_cd"));
            	invArIfMnVO.setPodCd(dbRowset.getString("pod_cd"));
            	invArIfMnVO.setTrnkVslCd(dbRowset.getString("trnk_vsl_cd"));
            	invArIfMnVO.setTrnkSkdVoyNo(dbRowset.getString("trnk_skd_voy_no"));
            	invArIfMnVO.setTrnkSkdDirCd(dbRowset.getString("trnk_skd_dir_cd"));
            	invArIfMnVO.setPorCd(dbRowset.getString("por_cd"));
            	invArIfMnVO.setDelCd(dbRowset.getString("del_cd"));
            	invArIfMnVO.setBkgTeuQty(dbRowset.getString("bkg_teu_qty"));
            	invArIfMnVO.setBkgFeuQty(dbRowset.getString("bkg_feu_qty"));
            	invArIfMnVO.setIoBndCd(dbRowset.getString("io_bnd_cd"));
            	invArIfMnVO.setSlsOfcCd(dbRowset.getString("sls_ofc_cd"));
            	invArIfMnVO.setCreUsrId(dbRowset.getString("cre_usr_id"));
            	invArIfMnVO.setCreDt(dbRowset.getString("cre_dt"));
            	invArIfMnVO.setUpdUsrId(dbRowset.getString("upd_usr_id"));
            	invArIfMnVO.setUpdDt(dbRowset.getString("upd_dt"));
            	invArIfMnVO.setInvRefNo(dbRowset.getString("inv_ref_no"));
            	invArIfMnVO.setInvRmk(dbRowset.getString("inv_rmk"));
            	invArIfMnVO.setDestTrnsSvcModCd(dbRowset.getString("dest_trns_svc_mod_cd"));
            	invArIfMnVO.setCrInvNo(dbRowset.getString("cr_inv_no"));
//            	invArIfMnVO.setGlEffDt("20150831");
			}
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return invArIfMnVO;
	}

	/**
	 * [AR Interface]에 전달할 내용을 [조회]한다.
	 * 
	 * @param SearchDodDrpOffChgVO searchDodDrpOffChgVO
	 * @return List<InvArIfChgVO> invArIfChgVOs
	 * @throws EventException
	 */
	public List<InvArIfChgVO> searchInterfaceCharge(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArIfChgVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchARInvoiceIFChgVORSQL(), param, velParam);
			log.error("\n searchInterfaceCharge : InvArIfChgVO : rowcount : " + dbRowset.getRowCount());
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	
	/**
	 * [AR Interface]에 전달할 내용을 [조회]한다.
	 * 
	 * @param SearchDodDrpOffChgVO searchDodDrpOffChgVO
	 * @return List<InvArIfCntrVO> invArIfCntrVOs
	 * @throws EventException
	 */
	public List<InvArIfCntrVO> searchInterfaceContainer(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArIfCntrVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchARInvoiceIFCntrVORSQL(), param, velParam);
			log.error("\n searchInterfaceContainer : InvArIfCntrVO : rowcount : " + dbRowset.getRowCount());
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfCntrVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	
	/**
	 * [Booking TRO에서 Cancel한 대상을 Drop Off Charge테이블에서 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchDodDrpOffChgVOByBookingTRO(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchDodDrpOffChgVO rsVO = new SearchDodDrpOffChgVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no" , bkgNo);
			param.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchDodDrpOffChgVORSQL(), param, null);
			if(dbRowset.next()) {
				rsVO.setBkgNo(dbRowset.getString("bkg_no"));
				rsVO.setCntrNo(dbRowset.getString("cntr_no"));
				rsVO.setDrpOffChgSeq(dbRowset.getString("drp_off_chg_seq"));
				rsVO.setInvSrcNo(dbRowset.getString("inv_src_no"));
				rsVO.setArIfNo(dbRowset.getString("ar_if_no"));
				rsVO.setDrpOffChgTrfSeq(dbRowset.getString("drp_off_chg_trf_seq"));
				rsVO.setDrpOffChgMnlFlg(dbRowset.getString("drp_off_chg_mnl_flg"));
				rsVO.setDrpOffChgTrfSpclSeq(dbRowset.getString("drp_off_chg_trf_spcl_seq"));
				rsVO.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
				rsVO.setTroIbCfmOfcCd(dbRowset.getString("tro_ib_cfm_ofc_cd"));
				rsVO.setTroIbCfmDt(dbRowset.getDate("tro_ib_cfm_dt").toString().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				rsVO.setDelCd(dbRowset.getString("del_cd"));
				rsVO.setCntrRtnYdCd(dbRowset.getString("cntr_rtn_yd_cd"));
				rsVO.setCntrRtnDt(dbRowset.getDate("cntr_rtn_dt").toString().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				rsVO.setCustCntCd(dbRowset.getString("cust_cnt_cd"));
				rsVO.setCustSeq(dbRowset.getString("cust_seq"));
				rsVO.setSpclCustCntCd(dbRowset.getString("spcl_cust_cnt_cd"));
				rsVO.setSpclCustSeq(dbRowset.getString("spcl_cust_seq"));
				rsVO.setCurrCd(dbRowset.getString("curr_cd"));
				rsVO.setGenTrfAmt(dbRowset.getString("gen_trf_amt"));
				rsVO.setSpclTrfAmt(dbRowset.getString("spcl_trf_amt"));
				rsVO.setDcAmt(dbRowset.getString("dc_amt"));
				rsVO.setSvcFeeAmt(dbRowset.getString("svc_fee_amt"));
				rsVO.setTtlAmt(dbRowset.getString("ttl_amt"));
				rsVO.setDcRmk(dbRowset.getString("dc_rmk"));
				rsVO.setDeltFlg(dbRowset.getString("delt_flg"));
				rsVO.setCreUsrId(dbRowset.getString("cre_usr_id"));
				rsVO.setCreDt(dbRowset.getDate("cre_dt").toString().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				rsVO.setUpdUsrId(dbRowset.getString("upd_usr_id"));
				rsVO.setUpdDt(dbRowset.getDate("upd_dt").toString().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				rsVO.setTroIbCxlFlg(dbRowset.getString("tro_ib_cxl_flg"));
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
    /**
     * [AR Interface No]을 [DOD_DRP_OFF_CHG 테이블에 Update]한다.
     * 
     * @param String arIfNo
	 * @param String invSrcNo
     * @throws EventException
     */
	 public void modifyARInterface(String bkgNo, String cntrNo, String drpOffChgSeq, String arIfNo, String invSrcNo) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("drp_off_chg_seq", drpOffChgSeq);
            param.put("ar_if_no", arIfNo);
            param.put("inv_src_no", invSrcNo);
            
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new DropOffCreationDBDAOModifyARInterfaceUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

    /**
     * [AUTH_APRO_RQST_NO]을 [DOD_DRP_OFF_CHG 테이블에 Update]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @param String authAproRqstNo
     * @throws EventException
     */
	public void modifyARInterfaceAuth(String bkgNo, String cntrNo, String drpOffChgSeq, String authAproRqstNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("drp_off_chg_seq", drpOffChgSeq);
	        param.put("auth_apro_rqst_no", authAproRqstNo);
	        
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new DropOffCreationDBDAOModifyARInterfaceAuthUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

			
    /**
     * [Booking TRO에서 Cancel한 데이터를 DOD_DRP_OFF_CHG 테이블의  TRO_IB_CXL_FLG 컬럼값을 'Y' or 'N'으로 Update]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
	 * @param String flag
     * @throws EventException
     */
	 public void modifyARInterfaceByBookingTRO(String bkgNo, String cntrNo, String drpOffChgSeq, String flag) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("drp_off_chg_seq", drpOffChgSeq);
			param.put("flag", flag);
            
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			log.debug("dataSource : " + dataSource);
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new DropOffCreationDBDAOModifyARInterfaceByBookingTROUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		 
    /**
     * [AR Interface 전송 실패한 대상]을 [DOD_DRP_OFF_CHG 테이블에서 Delete]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @throws DAOException 
     */
	public void deleteDodDrpOffChg(String bkgNo, String cntrNo, String drpOffChgSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

	try{
		param.put("bkg_no", bkgNo);
		param.put("cntr_no", cntrNo);
		param.put("drp_off_chg_seq", drpOffChgSeq);
        
		SQLExecuter sqlExe = new SQLExecuter("");
		int result = 0;
		result = sqlExe.executeUpdate((ISQLTemplate)new DropOffCreationDBDAOSearchDodDrpOffChgVODSQL(), param, null);
		
		if(result == Statement.EXECUTE_FAILED)
			throw new DAOException("Fail to insert SQL");
		
	} catch(SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch(Exception ex) {
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	}

	/**
	 * DOD_DRP_OFF_CHG 테이블의 DRP_OFF_CHG_SEQ 번호 채번<br>
	 * @param String bkgNo
	 * @param String cntrNo 
	 * @return String
	 * @exception DAOException
	 */
	public String searchDrpOffChgSeq(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String drpOffChgSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchDrpOffChgSeqRSQL(), param, velParam);
			if(dbRowset.next()) {						
				drpOffChgSeq = dbRowset.getString("drp_off_chg_seq");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return drpOffChgSeq;
	}
	/**
	 * DOD_DRP_OFF_CHG 테이블의 INV_SRC_NO 번호 채번<br>
	 * @param String ofcCd 
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvSrcNo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String invSrcNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffCreationDBDAOSearchInvSrcNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				invSrcNo = dbRowset.getString("inv_src_no");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invSrcNo;
	}
	
	/**
	 * CSR Approval에서 Link되는 팝업 SQL
	 * 
	 * @param String
	 * @return List<DropOffDiscountDetailVO>
	 * @throws DAOException
	 */
	public List<DropOffDiscountDetailVO> searchDropOffDiscountDetail(String authAproRqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<DropOffDiscountDetailVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("auth_apro_rqst_no", authAproRqstNo);
			velParam.put("auth_apro_rqst_no", authAproRqstNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DropOffCreationDBDAOsearchDropOffDiscountDetailRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DropOffDiscountDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}