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
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.basic.SpecialCargoQuotationManageBCImpl;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesBbCgoCostVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BbCntrListVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.CntrTypzQtyVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoAdonTpSzVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfDtlVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfHdrVO;
import com.hanjin.syscommon.common.table.TesAwkCgoTrfTpSzVO;
import com.hanjin.syscommon.common.table.TesTmlSoBbDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;


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
	 * AWK Cargo Basic Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchAwkCgoBasicTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		if(tesAwkCgoTrfMngVO != null){
			param.put("yd_cd", tesAwkCgoTrfMngVO.getYdCd());
			param.put("lg_ofc_cd", tesAwkCgoTrfMngVO.getLgOfcCd());
			param.put("tml_awk_cgo_trf_tp_cd", tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
			param.put("year_month", tesAwkCgoTrfMngVO.getYearMonth());
			param.put("cond_no", tesAwkCgoTrfMngVO.getCondNo());
			velParam.put("yd_cd", tesAwkCgoTrfMngVO.getYdCd());
			velParam.put("lg_ofc_cd", tesAwkCgoTrfMngVO.getLgOfcCd());
			velParam.put("tml_awk_cgo_trf_tp_cd", tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
			velParam.put("year_month", tesAwkCgoTrfMngVO.getYearMonth());
			velParam.put("cond_no", tesAwkCgoTrfMngVO.getCondNo());
		}
		
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
			
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
	 * AWK Cargo T/S Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchAwkCgoTsTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		if(tesAwkCgoTrfMngVO != null){
			param.put("yd_cd", tesAwkCgoTrfMngVO.getYdCd());
			param.put("lg_ofc_cd", tesAwkCgoTrfMngVO.getLgOfcCd());
			param.put("tml_awk_cgo_trf_tp_cd", tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
			param.put("year_month", tesAwkCgoTrfMngVO.getYearMonth());
			param.put("cond_no", tesAwkCgoTrfMngVO.getCondNo());
			velParam.put("yd_cd", tesAwkCgoTrfMngVO.getYdCd());
			velParam.put("lg_ofc_cd", tesAwkCgoTrfMngVO.getLgOfcCd());
			velParam.put("tml_awk_cgo_trf_tp_cd", tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
			velParam.put("year_month", tesAwkCgoTrfMngVO.getYearMonth());
			velParam.put("cond_no", tesAwkCgoTrfMngVO.getCondNo());
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchAwkCgoTsTrfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
			
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
	 * AWK Cargo Add On	Tariff를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchAwkCgoAddOnTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		if(tesAwkCgoTrfMngVO != null){
			param.put("lg_ofc_cd", tesAwkCgoTrfMngVO.getLgOfcCd());
			param.put("fm_loc_cd", tesAwkCgoTrfMngVO.getFmLocCd());
			param.put("to_loc_cd", tesAwkCgoTrfMngVO.getToLocCd());
			param.put("cond_no", tesAwkCgoTrfMngVO.getCondNoT3());
			velParam.put("lg_ofc_cd", tesAwkCgoTrfMngVO.getLgOfcCd());
			velParam.put("fm_loc_cd", tesAwkCgoTrfMngVO.getFmLocCd());
			velParam.put("to_loc_cd", tesAwkCgoTrfMngVO.getToLocCd());
			velParam.put("cond_no", tesAwkCgoTrfMngVO.getCondNoT3());
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchAwkCgoAddOnTrfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
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
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchTmlCd(String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TesAwkCgoTrfMngVO> list = null;
		
		try{
			if(ydCd != null){
				param.put("yd_cd", ydCd);
				velParam.put("yd_cd", ydCd);
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchTmlCdRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
				
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
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchCurrCd() throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		
		try{
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchCurrCdRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
				
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
	 * Main Yard 존재유무를 확인한다.
	 * 
	 * @param String ydCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkMnYdFlg(String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ydCd != null){
				param.put("yd_cd", ydCd);
				velParam.put("yd_cd", ydCd);
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOcheckMnYdFlgRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = dbRowset.getString("YD_CD");
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
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 * 
	 * @param String YdCd
	 * @param String ofcCd
	 * @return String 
	 * @exception DAOException
	 */
	public String checkYdCdInputAuth(String ydCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtn = "";
		try{
			if(ydCd != null){
				param.put("yd_cd", ydCd);
				param.put("lg_ofc_cd", ofcCd);
				velParam.put("yd_cd", ydCd);
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
	 * Sheet에 입력한 Port+Tml Cd와 로그인 오피스를 비교하여 입력 권한을 체크한다.
	 * 
	 * @param String fmYdCd
	 * @param String toYdCd
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkYdCdInputAuthAddon(String fmYdCd, String toYdCd, String ofcCd) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOcheckYdCdInputAuthAddonRSQL(), param, velParam );
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
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfHdr에 delete한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> deleteHdrList
	 * @exception DAOException
	 */
	public void removeAwkCgoBasicTrfHdr(List<TesAwkCgoTrfHdrVO> deleteHdrList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteHdrList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoBasicTrfHdrDSQL(),deleteHdrList, null, null);
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
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfDtl에 delete 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> deleteDtlList
	 * @exception DAOException
	 */
	public void removeAwkCgoBasicTrfDtl(List<TesAwkCgoTrfDtlVO> deleteDtlList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteDtlList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoBasicTrfDtlDSQL(),deleteDtlList, null, null);
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
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfTpSz에 delete 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> deleteTpszList
	 * @exception DAOException
	 */
	public void removeAwkCgoBasicTrfTpSz(List<TesAwkCgoTrfTpSzVO> deleteTpszList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoBasicTrfTpSzDSQL(),deleteTpszList, null, null);
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
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfHdr에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> InsUpdHdrList
	 * @exception DAOException
	 */
	public void modifyAwkCgoBasicTrfHdr(List<TesAwkCgoTrfHdrVO> InsUpdHdrList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(InsUpdHdrList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoBasicTrfHdrUSQL(),InsUpdHdrList, null, null);
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
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfDtl에 insert한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> InsUpdDtlList
	 * @exception DAOException
	 */
	public void modifyAwkCgoBasicTrfDtl(List<TesAwkCgoTrfDtlVO> InsUpdDtlList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(InsUpdDtlList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoBasicTrfDtlCSQL(),InsUpdDtlList, null, null);
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
	 * AWK Cargo Basic Tariff를 AwkCgoBasicTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> InsUpdTpszList
	 * @exception DAOException
	 */
	public void modifyAwkCgoBasicTrfTpSz(List<TesAwkCgoTrfTpSzVO> InsUpdTpszList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(InsUpdTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoBasicTrfTpSzUSQL(),InsUpdTpszList, null, null);
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
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfHdr에 delete한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> deleteHdrList
	 * @exception DAOException
	 */
	public void removeAwkCgoTsTrfHdr(List<TesAwkCgoTrfHdrVO> deleteHdrList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteHdrList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoTsTrfHdrDSQL(),deleteHdrList, null, null);
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
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfDtl에 delete 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> deleteDtlList
	 * @exception DAOException
	 */
	public void removeAwkCgoTsTrfDtl(List<TesAwkCgoTrfDtlVO> deleteDtlList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteDtlList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoTsTrfDtlDSQL(),deleteDtlList, null, null);
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
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfTpSz에 delete 한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> deleteTpszList
	 * @exception DAOException
	 */
	public void removeAwkCgoTsTrfTpSz(List<TesAwkCgoTrfTpSzVO> deleteTpszList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoTsTrfTpSzDSQL(),deleteTpszList, null, null);
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
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfHdr에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfHdrVO> InsUpdHdrList
	 * @exception DAOException
	 */
	public void modifyAwkCgoTsTrfHdr(List<TesAwkCgoTrfHdrVO> InsUpdHdrList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(InsUpdHdrList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoTsTrfHdrUSQL(),InsUpdHdrList, null, null);
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
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfDtl에 insert한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfDtlVO> InsUpdDtlList
	 * @exception DAOException
	 */
	public void modifyAwkCgoTsTrfDtl(List<TesAwkCgoTrfDtlVO> InsUpdDtlList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(InsUpdDtlList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoTsTrfDtlCSQL(),InsUpdDtlList, null, null);
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
	 * AWK Cargo T/S Tariff를 AwkCgoTsTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoTrfTpSzVO> InsUpdTpszList
	 * @exception DAOException
	 */
	public void modifyAwkCgoTsTrfTpSz(List<TesAwkCgoTrfTpSzVO> InsUpdTpszList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(InsUpdTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoTsTrfTpSzUSQL(),InsUpdTpszList, null, null);
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
	 * AWK Cargo Basic Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchAwkCgoBasicTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{

		if(tesAwkCgoTrfMngVO != null){
			param.put("yd_cd", tesAwkCgoTrfMngVO.getYdCd());
			param.put("tml_awk_ts_cd", tesAwkCgoTrfMngVO.getTmlAwkTsCd());
			param.put("tml_awk_cgo_trf_tp_cd", tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
			param.put("io_bnd_cd", tesAwkCgoTrfMngVO.getIoBndCd());
			param.put("io_ga_cd", tesAwkCgoTrfMngVO.getIoGaCd());
			param.put("cond_no", tesAwkCgoTrfMngVO.getCondNo());
			velParam.put("yd_cd", tesAwkCgoTrfMngVO.getYdCd());
			velParam.put("tml_awk_ts_cd", tesAwkCgoTrfMngVO.getTmlAwkTsCd());
			velParam.put("tml_awk_cgo_trf_tp_cd", tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
			velParam.put("io_bnd_cd", tesAwkCgoTrfMngVO.getIoBndCd());
			velParam.put("io_ga_cd", tesAwkCgoTrfMngVO.getIoGaCd());
			velParam.put("cond_no", tesAwkCgoTrfMngVO.getCondNo());

			
		}
		
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchAwkCgoBasicTrfHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
			
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
	 * AWK Cargo T/S Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchAwkCgoTsTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{

		if(tesAwkCgoTrfMngVO != null){
			param.put("yd_cd", tesAwkCgoTrfMngVO.getYdCd());
			param.put("tml_awk_ts_cd", tesAwkCgoTrfMngVO.getTmlAwkTsCd());
			param.put("tml_awk_cgo_trf_tp_cd", tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
			param.put("io_bnd_cd", tesAwkCgoTrfMngVO.getIoBndCd());
			param.put("io_ga_cd", tesAwkCgoTrfMngVO.getIoGaCd());
			param.put("cond_no", tesAwkCgoTrfMngVO.getCondNo());
			velParam.put("yd_cd", tesAwkCgoTrfMngVO.getYdCd());
			velParam.put("tml_awk_ts_cd", tesAwkCgoTrfMngVO.getTmlAwkTsCd());
			velParam.put("tml_awk_cgo_trf_tp_cd", tesAwkCgoTrfMngVO.getTmlAwkCgoTrfTpCd());
			velParam.put("io_bnd_cd", tesAwkCgoTrfMngVO.getIoBndCd());
			velParam.put("io_ga_cd", tesAwkCgoTrfMngVO.getIoGaCd());
			velParam.put("cond_no", tesAwkCgoTrfMngVO.getCondNo());
			
		}
		
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchAwkCgoTsTrfHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
			
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
	 * AWK Cargo Add-On Tariff History를 조회한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchAwkCgoAddOnTrfHis(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{

		if(tesAwkCgoTrfMngVO != null){
			param.put("fm_loc_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getFmLocCd()));
			param.put("fm_nod_yd_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getFmNodYdNo()));
			param.put("to_loc_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getToLocCd()));
			param.put("to_nod_yd_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getToNodYdNo()));
			param.put("cond_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getCondNo()));
			velParam.put("fm_loc_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getFmLocCd()));
			velParam.put("fm_nod_yd_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getFmNodYdNo()));
			velParam.put("to_loc_cd", JSPUtil.getNull(tesAwkCgoTrfMngVO.getToLocCd()));
			velParam.put("to_nod_yd_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getToNodYdNo()));
			velParam.put("cond_no", JSPUtil.getNull(tesAwkCgoTrfMngVO.getCondNo()));
		}
		
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchAwkCgoAddOnTrfHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
			
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
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfHdr에 insert 한다.<br>
	 * 
	 * @param List<TesAwkCgoAdonHdrVO> insUpdHdrList
	 * @exception DAOException
	 */
	public void modifyAwkCgoAddOnTrfHdr(List<TesAwkCgoAdonHdrVO> insUpdHdrList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(insUpdHdrList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoAddOnTrfHdrCSQL(),insUpdHdrList, null, null);
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
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfTpSz에 insert, update한다.<br>
	 * 
	 * @param List<TesAwkCgoAdonTpSzVO> insUpdTpszList 
	 * @exception DAOException
	 */
	public void modifyAwkCgoAddOnTrfTpSz(List<TesAwkCgoAdonTpSzVO> insUpdTpszList ) throws DAOException {
		int [] rsCnt = null;
		try{
			if(insUpdTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyAwkCgoAddOnTrfTpSzUSQL(),insUpdTpszList, null, null);
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
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfTpSz에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoAdonTpSzVO> deleteTpszList
	 * @exception DAOException
	 */
	public void removeAwkCgoAddOnTrfTpSz(List<TesAwkCgoAdonTpSzVO> deleteTpszList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteTpszList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoAddOnTrfTpSzDSQL(),deleteTpszList, null, null);
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
	 * AWK Cargo Add-On Tariff를 AwkCgoAdonTrfHdr에 delete한다<br>
	 * 
	 * @param List<TesAwkCgoAdonHdrVO> deleteHdrList
	 * @exception DAOException
	 */
	public void removeAwkCgoAddOnTrfHdr(List<TesAwkCgoAdonHdrVO> deleteHdrList) throws DAOException {
		int [] rsCnt = null;
		try{
			if(deleteHdrList.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new SpecialCargoQuotationManageDBDAOremoveAwkCgoAddOnTrfHdrDSQL(),deleteHdrList, null, null);
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
	 * Load / Unload Extra Cost를 조회한다.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchLoadUnloadExtCost(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
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
		
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchLoadUnloadExtCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
			
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
	 * Load / Unload T/S Extra Cost를 조회한다.<br>
	 * 
	 * @param AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO
	 * @return List<TesAwkCgoTrfMngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesAwkCgoTrfMngVO> searchLoadUnloadTsExtCost(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAwkCgoTrfMngVO> list = null;
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
		
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchLoadUnloadTsExtCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
			
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
	 * BB Booking Information을 조회한다.<br>
	 * Cargo Information 을 조회한다. 
	 * 
	 * @param String bkgNo
	 * @return List<BkgBbCgoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgBbCgoVO> searchBbCgoList(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgBbCgoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchBbCgoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBbCgoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
	 * BB Booking Information을 조회한다.<br>
	 * Container Information 을 조회한다. 
	 * 
	 * @param String bkgNo
	 * @return List<BbCntrListVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BbCntrListVO> searchBbCgoCntrList(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BbCntrListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchBbCgoCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BbCntrListVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
	 * BB Booking Information을 조회한다.<br>
	 * Container Type Size 을 조회한다. 
	 * 
	 * @param String bkgNo
	 * @return List<CntrTypzQtyVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<CntrTypzQtyVO> searchCntrTpszQty(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrTypzQtyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchCntrTpszQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrTypzQtyVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
	 * BB Booking Information을 조회한다.<br>
	 * Booking Customer 정보를 조회한다.
	 *
	 * @param 		String bkgNo
	 * @return 		BlCustomerInfoVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BlCustomerInfoVO searchBkgCustomer(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlCustomerInfoVO> list = null;
		BlCustomerInfoVO blCustomerInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchBkgCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCustomerInfoVO .class);
			if(list != null && list.size() > 0){
				blCustomerInfoVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blCustomerInfoVO;
	}
	 
	/**
     * BB Booking Cost Information을 조회한다.<br>
	 * 
	 * @param TesBbCgoCostVO tesBbCgoCostVO
	 * @return List<TesBbCgoCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesBbCgoCostVO> searchBbCargoCostInfo(TesBbCgoCostVO tesBbCgoCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesBbCgoCostVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		if(tesBbCgoCostVO != null){
			param.put("yd_cd", tesBbCgoCostVO.getYdCd());
			param.put("bkg_no", tesBbCgoCostVO.getBkgNo());
			param.put("tml_so_dtl_seq", tesBbCgoCostVO.getTmlSoDtlSeq());
			param.put("tml_so_ofc_cty_cd", tesBbCgoCostVO.getTmlSoOfcCtyCd());
			param.put("tml_so_seq", tesBbCgoCostVO.getTmlSoSeq());
			velParam.put("yd_cd", tesBbCgoCostVO.getYdCd());
			velParam.put("bkg_no", tesBbCgoCostVO.getBkgNo());
			velParam.put("tml_so_dtl_seq", tesBbCgoCostVO.getTmlSoDtlSeq());
			velParam.put("tml_so_ofc_cty_cd", tesBbCgoCostVO.getTmlSoOfcCtyCd());
			velParam.put("tml_so_seq", tesBbCgoCostVO.getTmlSoSeq());
			
		}
		
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchBbCargoCostInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesBbCgoCostVO .class);
			
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
     * BB Booking No을 조회한다.<br>
	 * 
	 * @param TesBbCgoCostVO tesBbCgoCostVO
	 * @return List<TesBbCgoCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesBbCgoCostVO> searchBbBkgNo(TesBbCgoCostVO tesBbCgoCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesBbCgoCostVO> list = null;
		//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try{
		if(tesBbCgoCostVO != null){
			param.put("yd_cd", tesBbCgoCostVO.getYdCd());
			param.put("vvd", tesBbCgoCostVO.getVvd());
			param.put("bkg_no", tesBbCgoCostVO.getBkgNo());
			param.put("io_bnd_cd", tesBbCgoCostVO.getIoBndCd());
			velParam.put("yd_cd", tesBbCgoCostVO.getYdCd());
			velParam.put("vvd", tesBbCgoCostVO.getVvd());
			velParam.put("bkg_no", tesBbCgoCostVO.getBkgNo());
			velParam.put("io_bnd_cd", tesBbCgoCostVO.getIoBndCd());
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchBbBkgNoRSQL(), param, velParam);
		list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesBbCgoCostVO .class);
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
	 * Tml So Dtl Max Seq을 조회한다.<br>
	 * 
	 * @param String tmlSoOfcCtyCd
	 * @param String tmlSoSeq
	 * @return int
	 * @throws DAOException
	 */
	public int searchTesTmlSoDtlMaxSeq(String tmlSoOfcCtyCd, String tmlSoSeq) throws DAOException {
		DBRowSet dbRowset = new DBRowSet();
		int maxSeq = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("tml_so_ofc_cty_cd", tmlSoOfcCtyCd);
            param.put("tml_so_seq", tmlSoSeq);
			velParam.put("tml_so_ofc_cty_cd", tmlSoOfcCtyCd);
			velParam.put("tml_so_seq", tmlSoSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchTesTmlSoDtlMaxSeqRSQL(), param, velParam);
			if(dbRowset!= null && dbRowset.next()){
				maxSeq = dbRowset.getInt("MAX_SEQ");
			}
			
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return maxSeq;
    }
	
	/**
	 * TesTmlSoDtl에 데이터가 있는지 없는지 체크하여 insert 할것인지 update할 것인지 결정한다. <br>
	 * 
	 * @param String tmlSoOfcCtyCd
	 * @param String tmlSoSeq
	 * @param String bkgNo
	 * @param String lgsCostCd
	 * @return String
	 * @throws DAOException
	 */
	public String checkTesTmlSoDtl(String tmlSoOfcCtyCd, String tmlSoSeq, String bkgNo, String lgsCostCd) throws DAOException {
		DBRowSet dbRowset = new DBRowSet();
		String chkTesTmlSoDtl = "";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("tml_so_ofc_cty_cd", tmlSoOfcCtyCd);
            param.put("tml_so_seq", tmlSoSeq);
            param.put("bkg_no", bkgNo);
            param.put("lgs_cost_cd", lgsCostCd);

			velParam.put("tml_so_ofc_cty_cd", tmlSoOfcCtyCd);
			velParam.put("tml_so_seq", tmlSoSeq);
			velParam.put("bkg_no", bkgNo);
			velParam.put("lgs_cost_cd", lgsCostCd);


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOcheckTesTmlSoDtlRSQL(), param, velParam);
			if(dbRowset!= null && dbRowset.next()){
				chkTesTmlSoDtl = dbRowset.getString("FLAG");
			}
			
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chkTesTmlSoDtl;
    }
	
	/**
	 * TesTmlSoDtl에 데이터가 있는지 없는지 체크하여 insert 할것인지 update할 것인지 결정한다. <br>
	 * 
	 * @param String tmlSoOfcCtyCd
	 * @param String tmlSoSeq
	 * @param String bkgNo
	 * @param String lgsCostCd
	 * @return String
	 * @throws DAOException
	 */
	public String[] checkTesTmlSoDtlCostExist(String tmlSoOfcCtyCd, String tmlSoSeq, String bkgNo, String lgsCostCd) throws DAOException {
		DBRowSet dbRowset = new DBRowSet();
		String[] isExist = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	isExist = new String[2];
            param.put("tml_so_ofc_cty_cd", tmlSoOfcCtyCd);
            param.put("tml_so_seq", tmlSoSeq);
            param.put("bkg_no", bkgNo);
            param.put("lgs_cost_cd", lgsCostCd);

			velParam.put("tml_so_ofc_cty_cd", tmlSoOfcCtyCd);
			velParam.put("tml_so_seq", tmlSoSeq);
			velParam.put("bkg_no", bkgNo);
			velParam.put("lgs_cost_cd", lgsCostCd);


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOcheckTesTmlSoDtlCostExistRSQL(), param, velParam);
			if(dbRowset!= null && dbRowset.next()){
				isExist[0] = dbRowset.getString("FLAG");
				isExist[1] = dbRowset.getString("SEQ");
			}

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isExist;
    }
	
	/**
	 * TES_TML_SO_VVD_LIST에 데이터가 있는지 없는지 체크하여 없으면 Header 정보 insert, 있으면 update 한다. <br>
	 * 
	 * @param String tmlSoSeq
	 * @param String tmlSoOfcCtyCd
	 * @param String inBndCd
	 * @param String vvd
	 * @param String atbDt
	 * @param String usrId
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceVVD( String tmlSoSeq, String tmlSoOfcCtyCd, String inBndCd, String vvd, String atbDt, String usrId) throws DAOException {
		int rsCnt = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("tml_so_ofc_cty_cd", tmlSoOfcCtyCd);
            param.put("tml_so_seq", tmlSoSeq);
            param.put("io_bnd_cd", inBndCd);
            param.put("vvd", vvd);
            param.put("atb_dt", atbDt);
            param.put("usr_id", usrId);
			velParam.put("tml_so_ofc_cty_cd", tmlSoOfcCtyCd);
			velParam.put("tml_so_seq", tmlSoSeq);
			velParam.put("io_bnd_cd", inBndCd);
			velParam.put("vvd", vvd);
			velParam.put("atb_dt", atbDt);
			velParam.put("usr_id", usrId);

			rsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmultiTerminalInvoiceVVDCSQL(), param, velParam);
			if( rsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	
	/**
	 * TesTmlSoBbDtl 에 insert, update 한다.<br>
	 * 
	 * @param TesTmlSoBbDtlVO tesTmlSoBbDtlVO
	 * @throws DAOException
	 */
	public void manageTesTmlSoBbDtl(TesTmlSoBbDtlVO tesTmlSoBbDtlVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int rsCnt = 0;
        try {
			Map<String, String> mapVO	= tesTmlSoBbDtlVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			rsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmanageTesTmlSoBbDtlUSQL(), param, velParam);
			if( rsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	
	/**
	 * TesTmlSoDtl 에 insert 한다.<br>
	 * 
	 * @param TesTmlSoDtlVO tesTmlSoDtlVO
	 * @throws DAOException
	 */
	public void addTesTmlSoDtl(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int rsCnt = 0;
        try {	
        	Map<String, String> mapVO	= tesTmlSoDtlVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			rsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialCargoQuotationManageDBDAOaddTesTmlSoDtlCSQL(), param, velParam);
			if( rsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	
	/**
	 * TesTmlSoDtl 에 update 한다.<br>
	 * 
	 * @param TesTmlSoDtlVO tesTmlSoDtlVO
	 * @throws DAOException
	 */
	public void modifyTesTmlSoDtl(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int rsCnt = 0;
        try {
        	Map<String, String> mapVO	= tesTmlSoDtlVO.getColumnValues();
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			rsCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialCargoQuotationManageDBDAOmodifyTesTmlSoDtlUSQL(), param, velParam);
			if( rsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
        	
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	
	/**
	 * AWK Cargo Add On Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception DAOException
	 */
	public String verifyAwkCgoAddOnTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {	
        	Map<String, String> mapVO	= tesAwkCgoTrfMngVO.getColumnValues();
        	
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOverifyAwkCgoAddOnTrfRSQL(), param, velParam );
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = dbRowset.getString("VRFY_RSLT");
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
	 * AWK Cargo Basic Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception DAOException
	 */
	public String verifyAwkCgoBasicTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {	
        	Map<String, String> mapVO	= tesAwkCgoTrfMngVO.getColumnValues();
        	
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOverifyAwkCgoBasicTrfRSQL(), param, velParam );
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = dbRowset.getString("VRFY_RSLT");
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
	 * AWK Cargo T/S Tariff를 Verify한다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception DAOException
	 */
	public String verifyAwkCgoTsTrf(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {	
        	Map<String, String> mapVO	= tesAwkCgoTrfMngVO.getColumnValues();
        	
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOverifyAwkCgoBasicTrfRSQL(), param, velParam );
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = dbRowset.getString("VRFY_RSLT");
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
	 * AWK Cargo Add On Tariff의 local curr를 USD로 바꾼다.<br>
	 * 
	 * @param TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO
	 * @return String
	 * @exception DAOException
	 */
	public TesAwkCgoTrfMngVO searchUSDExchange(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) throws DAOException {
		DBRowSet dbRowset = null;
//		String rtn = null;
		
		List<TesAwkCgoTrfMngVO> list = null;
		TesAwkCgoTrfMngVO retVO = new TesAwkCgoTrfMngVO();
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {	
        	Map<String, String> mapVO	= tesAwkCgoTrfMngVO.getColumnValues();
        	
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoQuotationManageDBDAOsearchUSDExchangeRSQL(), param, velParam );
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesAwkCgoTrfMngVO .class);
			
			if(list != null && list.size() > 0) {
				retVO = list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return retVO;	
	}
}