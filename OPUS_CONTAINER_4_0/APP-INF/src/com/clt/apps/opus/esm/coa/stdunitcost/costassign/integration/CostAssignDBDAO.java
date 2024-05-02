/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : CostAssignDBDAO.java
 *@FileTitle : NMS/YMS Common Table Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-06
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-12-06 kimyoungchul
 * 
 =========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.costassign.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.CoaBatchParameterVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.util.WebKeys;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.CoaBkgCostCalcVO;
import com.clt.syscommon.common.table.CoaComCostParaVO;

/**
 * COA에 대한 DB 처리를 담당<br> - COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see CostAssignBCImpl 참조
 * @since J2EE 1.4
 */
public class CostAssignDBDAO extends DBDAOSupport {

	/**
	 * PctlNo 목록을 가져온다.<br>
	 * 
	 * @param String start_pctl_no
	 * @param String end_pctl_no
	 * @return List<CoaComCostParaVO>
	 * @throws DAOException
	 */
	public List<CoaComCostParaVO> searchPctlNoList(String start_pctl_no, String end_pctl_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaComCostParaVO> list = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
log.debug("\nCostAssignDBDAO.searchPctlNoList(String start_pctl_no, String end_pctl_no)");
		try{
			param.put("start_pctl_no", start_pctl_no);
			param.put("end_pctl_no", end_pctl_no);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchPctlNoListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaComCostParaVO.class);
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
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaCostPkgMainPrdAvg(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateCoaCostPkgMainPrdAvg(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPkgMainPrdAvg");
			}
			 new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaCostPkgMainCopAvg(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateCoaCostPkgMainCopAvg(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPkgMainCopAvg");
			}
			new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaCostPkgMainPrdMst(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;	
log.debug("\ncreateCoaCostPkgMainPrdMst(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPkgMainPrdMst");
			}
		     new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaCostPkgMainComTtl(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateCoaCostPkgMainComTtl(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPkgMainComTtl");
			}
			new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * @param errMsg 
	 * @return String
	 * @throws DAOException
	 */
	public String createLog(String errMsg) throws DAOException {		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	
log.debug("\ncreateLog(String errMsg)");
		try{
			if(errMsg != null){
				param.put("err_msg", errMsg);
				velParam.put("methodname", "createLog");
			}
			new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return null;
	}

	/**
	 * @param startPctlNo 
	 * @param endPctlNo 
	 * @throws DAOException
	 */
	public void modifyProductCatalogueMaster(String startPctlNo, String endPctlNo) throws DAOException {		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
log.debug("\nmodifyProductCatalogueMaster(String startPctlNo, String endPctlNo)");
		try {
			velParam.put("start_pctl_no", startPctlNo);		
			velParam.put("end_pctl_no", endPctlNo);	
			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOModifyProductCatalogueMasterUSQL(), null, velParam);
			if(updCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaCostPrcAssignPrd(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;	
log.debug("\ncreateCoaCostPrcAssignPrd(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPrcAssignPrd");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaCostPrcAssignCop(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
log.debug("\ncreateCoaCostPrcAssignCop(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPrcAssignCop");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createTrsAgmtApplyToCoa(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
		log.debug("\ncreateTrsAgmtApplyToCoa(CoaBatchParameterVO vo)");

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createTrsAgmtApplyToCoa");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			//OracleTypes.NUMBER
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createTesCoaRate(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
log.debug("\ncreateTesCoaRate(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createTesCoaRate");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	
	
	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param String cop_no
	 * @param String usr_id
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int createAcmAplyOtrCommToCoa(String cop_no, String usr_id) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		@SuppressWarnings("unused")
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
		log.debug("\ncreateAcmAplyOtrCommToCoa(String cop_no, String usr_id)");

		try{
			if(cop_no != null){				
				param.put("pctl_no", cop_no);
				param.put("usr_id", usr_id);
				velParam.put("methodname", "createAcmAplyOtrCommToCoa");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			//OracleTypes.NUMBER
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	
	
	
	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param String bkg_no
	 * @param String usr_id
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int createAcmAplyCommToCoa(String bkg_no, String usr_id) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		@SuppressWarnings("unused")
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
		log.debug("\ncreateAcmAplyCommToCoa(String bkg_no, String usr_id)");

		try{
			if(bkg_no != null){				
				param.put("bkg_no", bkg_no);
				param.put("usr_id", usr_id);
				velParam.put("methodname", "createAcmAplyCommToCoa");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			//OracleTypes.NUMBER
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);			
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaBkgInfoInst(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;	
log.debug("\ncreateTesCoaRate(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaBkgInfoInst");
			}
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaBkgCostSmry(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;	
		log.debug("\ncreateCoaBkgCostSmry(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaBkgCostSmry");
			}
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
		   log.error("err "+se.toString(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	
	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaBkgExpnDtl(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
		log.debug("\ncreateCoaBkgExpnDtl(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaBkgExpnDtl");
			}
			new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaBkgRevDtl(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
log.debug("\ncreateCoaBkgRevDtl(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaBkgRevDtl");
			}
			returnParam = new SQLExecuter("").executeSP((ISQLTemplate)new CostAssignDBDAOPrcExecAllCSQL(), param, velParam);
			returnValue = 1;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * PctlNo 목록을 가져온다.<br>
	 * 
	 * @param BkgNo
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPctlNoStartEnd(String BkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", BkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchPctlNoStartEndRSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * BzcCostYrmon 을 가져온다.<br>
	 * 
	 * @param bkgNo
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchBzcCostYrmon(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchBzcCostYrmonRSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * PctlNo 목록을 가져온다.<br>
	 * 
	 * @param bkg_no
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchBkgInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkg_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchBkgInfoRSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * PctlNo 목록을 가져온다.<br>
	 * 
	 * @param String bkg_no
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchBkgNoList(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
log.debug("\nCostAssignDBDAO.searchBkgNoList(String bkg_no) bkg_no=" + bkg_no);
		try{
			param.put("bkg_no", bkg_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchBkgNoListRSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * PctlNo 목록을 가져온다.<br>
	 * @param bkg_no 
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCopNoList(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
log.debug("\nCostAssignDBDAO.searchCopNoList(String bkg_no)");
		try{
			param.put("bkg_no", bkg_no);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchCopNoListRSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}


		/**
		 * ReportCd의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * 
		 * @param String coaBatCd
		 * @return List<CoaBkgCostCalcVO>
		 * @throws DAOException
		 */
		public  List<CoaBkgCostCalcVO> searchListAssign(String coaBatCd) throws DAOException {
			
			DBRowSet dbRowset = null;
			List<CoaBkgCostCalcVO> list = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();;
			try{
				velParam.put("f_coa_bat_cd", coaBatCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchListAssignRSQL(), null, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaBkgCostCalcVO.class);
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
	 * @param bkgNo 
	 * @return int
	 * @throws DAOException
	 */
	public int updateBkgIfTrs2CoaSoCancel(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			velParam.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateBkgIfTrs2CoaSoCancelCSQL(), null, velParam);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
		return insCnt;
	}
	
	/**
	 * BKG시스템의 변경사항을 배치작업 수행하기위해 IF
	 * COA_BKG_COM_IF 테이블에 데이터를 MERGE(INSERT/UPDATE)한다.
	 * 
	 * @param  CoaBkgComIfVO model
	 * @return int insCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCoaCommonInterface(CoaBkgComIfVO model) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOModifyCoaCommonInterfaceCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
		return insCnt;		
	}
	/**
	 * BKG시스템의 변경사항을 History 테이블에 관리
	 *  COA_BKG_COM_IF_HIS 테이블에 데이터를 INSERT한다.
	 * 
	 * @param  CoaBkgComIfVO model
	 * @return int insCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int multiCoaBkgComIfHis(CoaBkgComIfVO model) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOMultiCoaBkgComIfHisCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
		return insCnt;		
	}		
	/**
	 * BKG시스템의 변경사항을 일배치작업 수행하기위해 IF
	 * COA_COP_COM_IF_MGMT 테이블에 데이터를 MERGE(INSERT/UPDATE)한다.
	 * 
	 * @param  CoaBkgComIfVO model
	 * @return int insCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int multiCoaCopIfMgmg(CoaBkgComIfVO model) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOMultiCoaCopIfMgmtCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
		return insCnt;		
	}		
			




	/**
	 * 2010.08.03 이윤정 [CHM-201005008-01] BKG cancel 시 CoaBkgExpnDtl 테이블 Cancel Status Update
	 * @param bkgNo 
	 * @return int
	 * @throws DAOException
	 */
	public int updateCoaBkgExpnDtl(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			param.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateCoaBkgExpnDtlUSQL(), param, null);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
		return insCnt;
	}



	/**
	 * 2010.08.03 이윤정 [CHM-201005008-01] BKG cancel 시 CoaBkgExpnDtlWk 테이블 Cancel Status Update
	 * @param bkgNo 
	 * @return int
	 * @throws DAOException
	 */
	public int updateCoaBkgExpnDtlWk(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			param.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateCoaBkgExpnDtlWkUSQL(), param, null);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
		return insCnt;
	}



	/**
	 * 2010.08.03 이윤정 [CHM-201005008-01] BKG cancel 시 CoaRgstBkg 테이블 Cancel Status Update
	 * @param bkgNo 
	 * @return int
	 * @throws DAOException
	 */
	public int updateCoaRgstBkg(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			param.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateCoaRgstBkgUSQL(), param, null);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
		return insCnt;
	}
	
	/**
	 * 2010.08.03 이윤정 [CHM-201005008-01] BKG cancel 시 LeaEstmCostIf 테이블 Cancel Status Update
	 * @param bkgNo 
	 * @return int
	 * @throws DAOException
	 */
	public int updateLeaEstmCostIf(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			param.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateLeaEstmCostIfUSQL(), param, null);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
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
		return insCnt;
	}

}
