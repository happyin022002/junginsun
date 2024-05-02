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
 * 2008-09-08 전윤주 : CSR No.N200807290002 COA_BKG_EXPN_DTL_PRC  call 하는 부분 추가
 * 1.0 최초 생성
 * 2009.03.26 박은주 : 품질검토결과 수정사항 반영 
 * 2009-02-19 임옥영, 전윤주 : CSR No. N200902160090, N200902160090 
 *                                   TRS SO 대상 삭제시 COA 비용 제거 기능 개발
 * 2009.05.22 전윤주 CSR No. R200905210004 5월 3주차 튜닝 대상 모니터링 결과 Source 반영      
 * 2009.10.12 임옥영 callOther 삭제(사용하지 않는 메소드) 
 * 2010.08.19 이윤정 [CHM-201005008-01] BKG cancel 시 COA에서 AGT 재계산 method 호출 요청
 * 2010.09.28 박은주 OPMS 결함 복구작업 [메소드명 변경]
 *                  createCoaCostPrcCopAbc => createCoaCostPrcCopAbcStp
 *                  createCoaCostPrcPrdAbc => createCoaCostPrcPrdAbcStp
 * 2011.03.17 박은주 BPM에 정보 제공을 위해서 소스 수정(BKG의 비용정보를 제공함)
 * 2011.05.04 박은주 [CHM-201110492-01]BPM POC 작업 종료에 따른 소스 제거 요청
 * 2012.05.21 전윤주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 *                  Cost table 생성 후 coa_com_cost_para 테이블 삭제를 위해 별도로 method 생성
 *                  removeCoaComCostPara 추가
 * 2012.08.03 전윤주 [CHM-201216347] [COA] ACM 프로젝트 연동 변경 작업
 *                 기존 AGT JAVA 소스를 호출하던 부분을 ACM 프로시져 호출로 변경함             
 * 2015.03.05 이윤정 [CHM-201534179] [SPC-BKG 연동 BKG 통제 프로젝트] COST 산출 요청 ( EMU CREDIT + AGENT COMMISSION)        
 * ========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.CoaBatchParameterVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.util.WebKeys;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.CoaBkgComIfVO;
import com.hanjin.syscommon.common.table.CoaBkgCostCalcVO;
import com.hanjin.syscommon.common.table.CoaComCostParaVO;


/**
 * eNIS-COA에 대한 DB 처리를 담당<br> - eNIS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * CHM-201534179 : NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaCostPkgMainBkgAvg(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateCoaCostPkgMainBkgAvg(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPkgMainBkgAvg");
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
	 * @param modName
	 * @param method
	 * @return
	 * @throws DAOException
	 */
	public int callBatchAuditPkg(String modName, String method) throws DAOException {	
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncallBatchAuditPkg(String modName, String method)");
		try{
			param.put("modName", modName);
			velParam.put("method", method);
			velParam.put("methodname", "createCoaCostPkgMainCopAvg");
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
	public int createCoaCostPkgMainPrdCtrt(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateCoaCostPkgMainPrdCtrt(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPkgMainPrdCtrt");
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
	public int createCoaCostPkgMainCopCtrt(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateCoaCostPkgMainCopCtrt(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPkgMainCopCtrt");
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
	 * CHM-201534179 : NMS/YMS 공통 테이블 생성 - Java 버전..
	 * 
	 * @param CoaBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createCoaCostPkgMainPrdMst2(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;	
log.debug("\ncreateCoaCostPkgMainPrdMst2(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPkgMainPrdMst2");
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
	public int createCoaCostPrcPrdAbcStp(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;	
log.debug("createCoaCostPrcPrdAbcStp(CoaBatchParameterVO vo))");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPrcPrdAbc");
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
	public int createCoaCostPrcCopAbcStp(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("createCoaCostPrcCopAbcStp(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPrcCopAbc");
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
	@SuppressWarnings("unchecked")
	public int createTrsAgmtApplyToCoa(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		@SuppressWarnings("unused")
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
	public int createCoaCostPrcCntrRepo(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
		log.debug("\ncreateCoaCostPrcCntrRepo(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaCostPrcCntrRepo");
			}
log.debug("\n\n\n==bkg_no = " + vo.getBkgNo() + ", cost_yrmon = " + vo.getCostYrmon());
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
	public int createCoaBkgSvcTrnsPrcInst(CoaBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;	
		log.debug("\ncreateCoaBkgExpnDtl(CoaBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createCoaBkgSvcTrnsPrcInst");
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
	
	
	/**
	 * COA_COM_COST_PARA 테이블의 data를 삭제한다.
	 * Cost table 생성 시 process 가 끝난 후 coa_com_cost_para data 삭제
	 * 
	 * @param start_pctl_no 
	 * @param end_pctl_no
	 * @return int
	 * @throws DAOException
	 */
	public int removeCoaComCostPara(String start_pctl_no, String end_pctl_no) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int delCnt = 0;
		
		try {
			param.put("start_pctl_no", start_pctl_no);	
			param.put("end_pctl_no", end_pctl_no);	
			
			delCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAORemoveCoaComCostParaDSQL(), param, null);
			if(delCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to delete SQL");
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
		return delCnt;
	}
	
	
	
//	/**
//	 * BPM에 BKG의 비용정보를 제공하기 위해서 조회한다.
//	 * 
//	 * @param bkg_no
//	 * @return
//	 * @throws DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<SearchBpmInfoVO> searchBpmInfo(String bkg_no) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<SearchBpmInfoVO> list = null;
//		Map<String, Object> param = new HashMap<String, Object>();
//		try{
//			param.put("bkg_no", bkg_no);
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchBpmInfoRSQL(), param, null);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBpmInfoVO.class);
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}

}
