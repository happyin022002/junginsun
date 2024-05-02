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
 * 2015.09.15 김성욱, 소스 보안 품질 작업                                    
 * ========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.MasBatchParameterVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration.NetworkCostDBDAOCreateAvgHireOwnVslDtrbCSQL;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration.NetworkCostDBDAOSearchPortTariffDetailListRSQL;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.util.WebKeys;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MasBkgCostCalcVO;
import com.hanjin.syscommon.common.table.MasComCostParaVO;


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
	 * @return List<MasComCostParaVO>
	 * @throws DAOException
	 */
	public List<MasComCostParaVO> searchPctlNoList(String start_pctl_no, String end_pctl_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<MasComCostParaVO> list = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
log.debug("\nCostAssignDBDAO.searchPctlNoList(String start_pctl_no, String end_pctl_no)");
		try{
			param.put("start_pctl_no", start_pctl_no);
			param.put("end_pctl_no", end_pctl_no);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchPctlNoListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MasComCostParaVO.class);
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainPrdAvg(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateMasCostPkgMainPrdAvg(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainPrdAvg");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainBkgAvg(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateMasCostPkgMainBkgAvg(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainBkgAvg");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainCopAvg(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateMasCostPkgMainCopAvg(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainCopAvg");
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
	 * SPC CMPB 재계산 로직 변경에 따른 신규 추가부분 [CHM-201539244] - 2015.12.10
	 * 
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainCopAvg2(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
		log.debug("\ncreateMasCostPkgMainCopAvg2(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainCopAvg2");
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
			velParam.put("methodname", "createMasCostPkgMainCopAvg");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainPrdCtrt(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateMasCostPkgMainPrdCtrt(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainPrdCtrt");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainCopCtrt(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateMasCostPkgMainCopCtrt(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainCopCtrt");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainPrdMst(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;	
log.debug("\ncreateMasCostPkgMainPrdMst(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainPrdMst");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainPrdMst2(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;	
		log.debug("\ncreateMasCostPkgMainPrdMst2(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainPrdMst2");
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
	 * SPC CMPB 재계산 로직 변경에 따른 신규 추가부분 [CHM-201539244] - 2015.12.10
	 * 
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainPrdMst3(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;	
		log.debug("\ncreateMasCostPkgMainPrdMst3(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainPrdMst3");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPkgMainComTtl(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("\ncreateMasCostPkgMainComTtl(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPkgMainComTtl");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPrcAssignPrd(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;	
log.debug("\ncreateMasCostPrcAssignPrd(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPrcAssignPrd");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPrcAssignCop(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
log.debug("\ncreateMasCostPrcAssignCop(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPrcAssignCop");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPrcPrdAbcStp(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;	
log.debug("createMasCostPrcPrdAbcStp(MasBatchParameterVO vo))");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPrcPrdAbc");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPrcCopAbcStp(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
log.debug("createMasCostPrcCopAbcStp(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPrcCopAbc");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int createTrsAgmtApplyToMas(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		@SuppressWarnings("unused")
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
		log.debug("\ncreateTrsAgmtApplyToMas(MasBatchParameterVO vo)");

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createTrsAgmtApplyToMas");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createTesMasRate(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
log.debug("\ncreateTesMasRate(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createTesMasRate");
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
	 * @param String pctl_no
	 * @param String usr_id
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int createAcmAplyOtrCommToMas(String pctl_no, String usr_id) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		@SuppressWarnings("unused")
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
		log.debug("\ncreateAcmAplyOtrCommToMas(String cop_no, String usr_id)");

		try{
			if(pctl_no != null){				
				param.put("pctl_no", pctl_no);
				param.put("usr_id", usr_id);
				velParam.put("methodname", "createAcmAplyOtrCommToMas");
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
	 * @param String cop_no
	 * @param String usr_id
	 * @param String cost_yrmon
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int createAcmAplyOtrCommToSpc2(String bkg_no, String cop_no, String usr_id, String cost_yrmon) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		@SuppressWarnings("unused")
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
		log.debug("\ncreateAcmAplyOtrCommToSpc(String cop_no, String usr_id, String cost_yrmon)");

		try{
			if(cop_no != null){				
				param.put("bkg_no", bkg_no);	
				param.put("pctl_no", cop_no);
				param.put("usr_id", usr_id);
				param.put("cost_yrmon", cost_yrmon);
				velParam.put("methodname", "createAcmAplyOtrCommToSpc2");
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
	public int createAcmAplyCommToMas(String bkg_no, String usr_id) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		@SuppressWarnings("unused")
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
		log.debug("\ncreateAcmAplyCommToMas(String bkg_no, String usr_id)");

		try{
			if(bkg_no != null){				
				param.put("bkg_no", bkg_no);
				param.put("usr_id", usr_id);
				velParam.put("methodname", "createAcmAplyCommToMas");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasBkgInfoInst(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;	
log.debug("\ncreateTesMasRate(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasBkgInfoInst");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasBkgCostSmry(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;	
		log.debug("\ncreateMasBkgCostSmry(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasBkgCostSmry");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasCostPrcCntrRepo(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
		log.debug("\ncreateMasCostPrcCntrRepo(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasCostPrcCntrRepo");
log.debug("\n\n\n==bkg_no = " + vo.getBkgNo() + ", cost_yrmon = " + vo.getCostYrmon());
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasBkgExpnDtl(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		int returnValue = 0;		
		log.debug("\ncreateMasBkgExpnDtl(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasBkgExpnDtl");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasBkgSvcTrnsPrcInst(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;	
		log.debug("\ncreateMasBkgExpnDtl(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasBkgSvcTrnsPrcInst");
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
	 * @param MasBatchParameterVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int createMasBkgRevDtl(MasBatchParameterVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
log.debug("\ncreateMasBkgRevDtl(MasBatchParameterVO vo)");
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("methodname", "createMasBkgRevDtl");
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
		 * @param String masBatCd
		 * @return List<MasBkgCostCalcVO>
		 * @throws DAOException
		 */
		public  List<MasBkgCostCalcVO> searchListAssign(String masBatCd) throws DAOException {
			
			DBRowSet dbRowset = null;
			List<MasBkgCostCalcVO> list = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();;
			try{
				velParam.put("f_mas_bat_cd", masBatCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchListAssignRSQL(), null, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MasBkgCostCalcVO.class);
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
	public int updateBkgIfTrs2MasSoCancel(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			velParam.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateBkgIfTrs2MasSoCancelCSQL(), null, velParam);
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
	 * @param  MasBkgComIfVO model
	 * @return int insCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyMasCommonInterface(MasBkgComIfVO model) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOModifyMasCommonInterfaceCSQL(), param, param);
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
	 * @param  MasBkgComIfVO model
	 * @return int insCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int multiMasBkgComIfHis(MasBkgComIfVO model) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOMultiMasBkgComIfHisCSQL(), param, param);
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
	 * @param  MasBkgComIfVO model
	 * @return int insCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int multiMasCopIfMgmg(MasBkgComIfVO model) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOMultiMasCopIfMgmtCSQL(), param, param);
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
	public int updateMasBkgExpnDtl(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			param.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateMasBkgExpnDtlUSQL(), param, null);
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
	public int updateMasBkgExpnDtlWk(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			param.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateMasBkgExpnDtlWkUSQL(), param, null);
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
	public int updateMasRgstBkg(String bkgNo) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt = 0;
		
		try {
			param.put("bkg_no", bkgNo);		
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAOUpdateMasRgstBkgUSQL(), param, null);
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
	public int removeMasComCostPara(String start_pctl_no, String end_pctl_no) throws DAOException {
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int delCnt = 0;
		
		try {
			param.put("start_pctl_no", start_pctl_no);	
			param.put("end_pctl_no", end_pctl_no);	
			
			delCnt = new SQLExecuter("DEFAULT").executeUpdate(new CostAssignDBDAORemoveMasComCostParaDSQL(), param, null);
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
	
	/**
	 * MAS - BKG Cost YR 찾기<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgYr(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bkg_no = "";
		try{
			Map<String, String> param = new HashMap<String, String>();
			param.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchBkgYrRSQL(), param, null);
			if (dbRowset.next()){ 
				bkg_no = dbRowset.getString("BKG_YR");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkg_no;
	}

	/**
	 * Cntr Mt Days 을 가져온다.<br>
	 * 
	 * @param startPctlNo
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMtDys(String startPctlNo) throws DAOException {
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("start_pctl_no", startPctlNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchMtDysRSQL(), param, null);
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
	 * ACM 테이블의 BKG 존재 여부를 확인한다.<br>
	 * 
	 * @param bkgNo
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAcmBkg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAssignDBDAOSearchAcmBkgRSQL(), param, null);
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
	 * BKG Rating 이전 Special Compensation 비용 계산
	 * 
	 * @param String bkg_no
	 * @param String usr_id
	 * @return int
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int createAcmAplySpclCommToMas(String bkg_no, String usr_id) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		@SuppressWarnings("unused")
		Map<String, Object> returnParam = new HashMap<String, Object>();//executeSP의 return 값
		int returnValue = 0;		
		log.debug("\ncreateAcmAplySpclCommToMas(String bkg_no, String usr_id)");

		try{
			if(bkg_no != null){				
				param.put("bkg_no", bkg_no);
				param.put("usr_id", usr_id);
				velParam.put("methodname", "createAcmAplySpclCommToMas");
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

}
