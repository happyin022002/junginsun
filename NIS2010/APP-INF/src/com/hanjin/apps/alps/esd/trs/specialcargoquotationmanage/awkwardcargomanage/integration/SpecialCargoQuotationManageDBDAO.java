/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAO.java
*@FileTitle : SpecialCargoQuotationManageDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.basic.SpecialCargoQuotationManageBCImpl;
import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.vo.TrsAwkCgoTrfMngVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsAwkCgoTrfHdrVO;
import com.hanjin.syscommon.common.table.TrsAwkCgoTrfTpSzVO;


/**
 * ALPS SpecialCargoQuotationManageDBDAO <br>
 * - ALPS-SpecialCargoQuotationManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 이혜민
 * @see SpecialCargoQuotationManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class SpecialCargoQuotationManageDBDAO
 extends DBDAOSupport {

	/**
	 * AWK Cargo Shuttle Tariff를 조회한다.<br>
	 * 
	 * @param TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TrsAwkCgoTrfMngVO> searchAwkCgoShuttleTrf(TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsAwkCgoTrfMngVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	try{
		if(trsAwkCgoTrfMngVO != null){
			param.put("yd_cd", trsAwkCgoTrfMngVO.getYdCd());
			param.put("lg_ofc_cd", trsAwkCgoTrfMngVO.getLgOfcCd());
			param.put("trsp_awk_cgo_trf_tp_cd", "S");
			param.put("year_month", trsAwkCgoTrfMngVO.getYearMonth());
			param.put("cond_no", trsAwkCgoTrfMngVO.getCondNo());
			velParam.put("yd_cd", trsAwkCgoTrfMngVO.getYdCd());
			velParam.put("lg_ofc_cd", trsAwkCgoTrfMngVO.getLgOfcCd());
			velParam.put("trsp_awk_cgo_trf_tp_cd", "S");
			velParam.put("year_month", trsAwkCgoTrfMngVO.getYearMonth());
			velParam.put("cond_no", trsAwkCgoTrfMngVO.getCondNo());
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsAwkCgoTrfMngVO .class);
			
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
	 * AWK Cargo Shuttle Tariff를 TrsAwkCgoTrfHdrd에 insert 한다.<br>
	 * 
	 * @param List<TrsAwkCgoTrfHdrVO> insUpdHdrList
	 * @exception DAOException
	 */
	public void modifyAwkCgoShuttleTrfHdr(List<TrsAwkCgoTrfHdrVO> insUpdHdrList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(insUpdHdrList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoShuttleTrfHdrCSQL(),insUpdHdrList, null, null);
				for(int i = 0; i < rsCnt.length; i++){
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
	 * AWK Cargo Shuttle Tariff를 TrsAwkCgoTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TrsAwkCgoTrfTpSzVO> insUpdTpszList 
	 * @exception DAOException
	 */
	public void modifyAwkCgoShuttleTrfTpSz(List<TrsAwkCgoTrfTpSzVO> insUpdTpszList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(insUpdTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoShuttleTrfTpSzUSQL(),insUpdTpszList, null, null);
				for(int i = 0; i < rsCnt.length; i++){
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
	 * AWK Cargo Shuttle Tariff를 TrsAwkCgoTrfTpSz에 delete한다<br>
	 * 
	 * @param List<TrsAwkCgoTrfTpSzVO> deleteTpszList
	 * @exception DAOException
	 */
	public void removeAwkCgoShuttleTrfTpSz(List<TrsAwkCgoTrfTpSzVO> deleteTpszList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoShuttleTrfTpSzDSQL(),deleteTpszList, null, null);
				for(int i = 0; i < rsCnt.length; i++){
					if( rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * AWK Cargo Shuttle Tariff를 TrsAwkCgoTrfHdr에 delete한다<br>
	 * 
	 * @param List<TrsAwkCgoTrfHdrVO> deleteHdrList
	 * @exception DAOException
	 */
	public void removeAwkCgoShuttleTrfHdr(List<TrsAwkCgoTrfHdrVO> deleteHdrList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteHdrList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoShuttleTrfHdrDSQL(),deleteHdrList, null, null);
				for(int i = 0; i < rsCnt.length; i++){
					if( rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Port Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param String ydCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkPort(String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(ydCd != null){
				param.put("yd_cd", ydCd);
				velParam.put("yd_cd", ydCd);
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOcheckPortRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnFlag = dbRowset.getString("FLAG");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnFlag;
	}
	
	/**
	 * 해당 Port에 해당하는 Terminal을 조회한다.
	 * 
	 * @param String ydCd
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TrsAwkCgoTrfMngVO> searchTmlCd(String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsAwkCgoTrfMngVO> list = null;
		try{
			if(ydCd != null){
				param.put("yd_cd", ydCd);
				velParam.put("yd_cd", ydCd);
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchTmlCdRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsAwkCgoTrfMngVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		return list;
	}
	
	/**
	 * Currency Code를 조회한다.
	 * 
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TrsAwkCgoTrfMngVO> searchCurrCd() throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsAwkCgoTrfMngVO> list = null;
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchCurrCdRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsAwkCgoTrfMngVO .class);
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		return list;
	}
	
	/**
	 * 최근 Batch가 실행된 Year Month 를 가져온다.
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String setYearMonth() throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = "";
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsetYearMonthRSQL(), null, null );
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = dbRowset.getString("YEAR_MONTH");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}
	
	/**
	 * AWK Cargo Shuttle Tariff History를 조회한다.<br>
	 * 
	 * @param TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TrsAwkCgoTrfMngVO> searchAwkCgoShuttleTrfHis(TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsAwkCgoTrfMngVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	try{
		if(trsAwkCgoTrfMngVO != null){
			param.put("fm_loc_cd", trsAwkCgoTrfMngVO.getFmLocCd());
			param.put("fm_nod_yd_no", JSPUtil.getNull(trsAwkCgoTrfMngVO.getFmNodYdNo()));
			param.put("to_loc_cd", trsAwkCgoTrfMngVO.getToLocCd());
			param.put("to_nod_yd_no", JSPUtil.getNull(trsAwkCgoTrfMngVO.getToNodYdNo()));
			param.put("cond_no", trsAwkCgoTrfMngVO.getCondNo());
			param.put("io_ga_cd", trsAwkCgoTrfMngVO.getIoGaCd());
			param.put("trsp_crr_mod_cd", JSPUtil.getNull(trsAwkCgoTrfMngVO.getTrspCrrModCd()));
			
			velParam.put("fm_loc_cd", trsAwkCgoTrfMngVO.getFmLocCd());
			velParam.put("fm_nod_yd_no", JSPUtil.getNull(trsAwkCgoTrfMngVO.getFmNodYdNo()));
			velParam.put("to_loc_cd", trsAwkCgoTrfMngVO.getToLocCd());
			velParam.put("to_nod_yd_no", JSPUtil.getNull(trsAwkCgoTrfMngVO.getToNodYdNo()));
			velParam.put("cond_no", trsAwkCgoTrfMngVO.getCondNo());
			velParam.put("io_ga_cd", trsAwkCgoTrfMngVO.getIoGaCd());
			velParam.put("trsp_crr_mod_cd", JSPUtil.getNull(trsAwkCgoTrfMngVO.getTrspCrrModCd()));
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchAwkCgoShuttleTrfHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsAwkCgoTrfMngVO .class);
			
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
	 * 해당 월 환율적용하여 local amt를 usd amt로 변환한다.
	 * 
	 * @param TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkUsdConvert(TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		String amt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(trsAwkCgoTrfMngVO != null){
				param.put("select_row", trsAwkCgoTrfMngVO.getSelectRow());
				param.put("select_col", trsAwkCgoTrfMngVO.getSelectCol());
				param.put("lcl_amt", trsAwkCgoTrfMngVO.getLclAmt());
				param.put("curr_cd", trsAwkCgoTrfMngVO.getCurrCd());
				
				velParam.put("select_row", trsAwkCgoTrfMngVO.getSelectRow());
				velParam.put("select_col", trsAwkCgoTrfMngVO.getSelectCol());
				velParam.put("lcl_amt", trsAwkCgoTrfMngVO.getLclAmt());
				velParam.put("curr_cd", trsAwkCgoTrfMngVO.getCurrCd());
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOcheckUsdConvertRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					amt = dbRowset.getString("AMT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return amt;
	}
	
	/**
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 * 
	 * @param String fmYdCd
	 * @param String toYdCd
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkYdCdInputAuth(String fmYdCd, String toYdCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtn = "";
		try{
			if(fmYdCd != null){
				param.put("fm_yd_cd", fmYdCd);
				param.put("to_yd_cd", toYdCd);
				param.put("lg_ofc_cd", ofcCd);
				velParam.put("fm_yd_cd", fmYdCd);
				velParam.put("to_yd_cd", toYdCd);
				velParam.put("lg_ofc_cd", ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOcheckYdCdInputAuthRSQL(), param, velParam );
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = dbRowset.getString("CHK_FLG");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}
	
	/**
	 * Load / Unload Shuttle Extra Cost를 조회한다.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return List<TrsAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TrsAwkCgoTrfMngVO> searchLoadUnloadShuttleExtCost(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsAwkCgoTrfMngVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	try{
		if(awkCgoExtraCostByRouteVO != null){
			param.put("scq_rqst_no", awkCgoExtraCostByRouteVO.getScqRqstNo());
			param.put("scq_ver_no", awkCgoExtraCostByRouteVO.getScqVerNo() );
			param.put("rout_seq", awkCgoExtraCostByRouteVO.getRoutSeq());
			param.put("cost_tp_cd", awkCgoExtraCostByRouteVO.getCostTpCd());
			param.put("tmp_yn", awkCgoExtraCostByRouteVO.getTmpYn());
			velParam.put("scq_rqst_no", awkCgoExtraCostByRouteVO.getScqRqstNo());
			velParam.put("scq_ver_no", awkCgoExtraCostByRouteVO.getScqVerNo() );
			velParam.put("rout_seq", awkCgoExtraCostByRouteVO.getRoutSeq());
			velParam.put("cost_tp_cd", awkCgoExtraCostByRouteVO.getCostTpCd());
			velParam.put("tmp_yn", awkCgoExtraCostByRouteVO.getTmpYn());
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchLoadUnloadShuttleExtCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsAwkCgoTrfMngVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}