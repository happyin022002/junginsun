/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAO.java
*@FileTitle : Budget vs Actual
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 김기원 
*@LastVersion : 1.0
* 2009.06.08 박명종
* 1.0 Creation 
* 
* History
* 2010.10.04 유혁 CHM-201006127-01 운하 통항비 tariff Cost 생성 로직 변경
* 2011.08.10 진마리아 CHM-201111882-01 [VOP-PSO] COA data I/F
* 2012.08.20 이혜민 CHM-201219078-01 사업계획 - 시나리오 연도 추가
* 2015.01.02 김기원 CHM-201433349 Port Charge Invoice Summary report 화면 기능 변경
* 2015.02.02  [CHM-201533847] PORT내 SKIP여부 처리
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.IoRatioVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.RoundTruncVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.BudCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstDtlCondVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstSumByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpSumVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstExpnCreVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstTgtVvdByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ExpnDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumByMonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.PortChgBudByYearVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.YardChargeVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.PsoPortExpnDivVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoBudTgtVvdVO;
import com.hanjin.syscommon.common.table.PsoTgtVvdVO;
import com.hanjin.syscommon.common.table.PsoTgtYdExpnVO;
import com.hanjin.syscommon.common.table.PsoTgtYdSkdVO;
import com.hanjin.syscommon.common.table.PsoYdChgVO;


/**
 * ALPS BudgetPortChargeMgtDBDAO <br>
 * - ALPS-PortChargeBudget system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author myoungjong park
 * @see BudgetPortChargeMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class BudgetPortChargeMgtDBDAO extends DBDAOSupport {

	private String dataSource = "";
	private static final long serialVersionUID = 1L;
	
	/**
	 * defalt constructor
	 */
	public BudgetPortChargeMgtDBDAO() {
		this.dataSource = "";
	}
	
	/**
	 * parameterized constructor
	 * @param dataSource
	 */
	public BudgetPortChargeMgtDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}


	/**
	 * Invoice Summary를 조회한다.<br>
	 * 
	 * @param InvSumByMonVO invSumByMonVO
	 * @return List<InvSumByMonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvSumByMonVO> searchSumRptByPeriodInv(InvSumByMonVO invSumByMonVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvSumByMonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invSumByMonVO != null){
				Map<String, String> mapVO = invSumByMonVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> acctcd = null;
				acctcd = JSPUtil.convertStringToArrayList(JSPUtil.replace(invSumByMonVO.getCombo1(),",","|"));
				
				param.put("acct_cd"             , acctcd);
				param.put("arr_acct_cd"         , invSumByMonVO.getCombo1());
				
				velParam.put("acct_cd"          , acctcd);
				velParam.put("arr_acct_cd"      , invSumByMonVO.getCombo1());
				
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOsearchSumRptByPeriodInvRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvSumByMonVO.class);
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
	 * Budget vs Actual을 조회한다.<br>
	 * 
	 * @param EstTgtVvdByMonVO esttgtvvdbymonvo
	 * @return List<EstTgtVvdByMonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EstTgtVvdByMonVO> searchSumRptByPeriodSo(EstTgtVvdByMonVO esttgtvvdbymonvo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstTgtVvdByMonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(esttgtvvdbymonvo != null){
				String from_date = esttgtvvdbymonvo.getCreDtFr().substring(0,4)+esttgtvvdbymonvo.getCreDtFr().substring(5);
				String to_date = esttgtvvdbymonvo.getCreDtTo().substring(0,4)+esttgtvvdbymonvo.getCreDtTo().substring(5);
				esttgtvvdbymonvo.setCreDtFr( from_date );
				esttgtvvdbymonvo.setCreDtTo( to_date );
				Map<String, String> mapVO = esttgtvvdbymonvo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if( esttgtvvdbymonvo.getGubun().equals("0") )//group : port
					dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOsearchSumRptByPeriodSoRSQL(), param, velParam);
				else{//group : lane
					dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOsearchSumRptByPeriodSoARSQL(), param, velParam);
				}
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstTgtVvdByMonVO.class);
			}
			
		
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
	 * VVD별 Budget / Expense Plan Detail 비용을 조회한다.
	 * @category VOP_PSO_0201_windowOpen
	 * @param acctNo String 
	 * @param laneCd String 
	 * @param creDtFr String 
     * @param creDtTo String 
	 * @return List<BudEstSumByMonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BudEstSumByMonVO> searchBudEstDtlByMonCost(String acctNo, String laneCd, String creDtFr, String creDtTo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BudEstSumByMonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(acctNo != null && laneCd!=null && creDtFr!=null && creDtTo!=null){
				param.put("acct_no", acctNo);
				param.put("lane_cd", laneCd);
				param.put("cre_dt_fr", creDtFr);
				param.put("cre_dt_to", creDtTo);
				velParam.put("acct_no", acctNo);
				velParam.put("lane_cd", laneCd);
				velParam.put("cre_dt_fr", creDtFr);
				velParam.put("cre_dt_to", creDtTo);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL(), velParam, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BudEstSumByMonVO.class);
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
	 * Estimate VVD Creation하기 위해 기 생성한 추정 대상월 및 노선별로 조회한다.
	 * @category VOP_PSO_0010_RetrieveButtonClick 
	 * @param EstExpnCreVO estExpnCreVO
	 * @return List<EstExpnCreVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EstExpnCreVO> searchEstTgtVvdByMon(
			EstExpnCreVO estExpnCreVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<EstExpnCreVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(estExpnCreVO != null){
				
				Map<String, String> mapVO = estExpnCreVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOsearchEstTgtVvdByMonRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstExpnCreVO.class);
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
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 추정비용을 조회한다.
	 * @category VOP_PSO_0013_RetrieveButtonClick
	 * @param ErpSumVO erpSumVO
	 * @return List<ErpSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ErpSumVO> searchErpSum(ErpSumVO erpSumVO) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<ErpSumVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(erpSumVO != null){
				Map<String, String> mapVO = erpSumVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> acctCdList = new ArrayList<String>();
				if (!StringUtils.isEmpty(erpSumVO.getAcctCd())) {
					acctCdList = Arrays.asList(erpSumVO.getAcctCd().split(","));
				}
				velParam.put("acct_cd_list", acctCdList);
			}
			
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOsearchErpSumRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpSumVO.class);
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
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 상세한 추정비용을 조회한다.
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ErpDtlVO> searchErpDtl(ErpDtlVO erpDtlVO) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<ErpDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(erpDtlVO != null){
				Map<String, String> mapVO = erpDtlVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> acctCdList = new ArrayList<String>();
				if (!StringUtils.isEmpty(erpDtlVO.getAcctCd())) {
					acctCdList = Arrays.asList(erpDtlVO.getAcctCd().split(","));
				}
				velParam.put("acct_cd_list", acctCdList);				
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOsearchErpDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpDtlVO.class);
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
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 추정비용을 변경한다.
	 * @category VOP_PSO_0207_SaveButtonClick
	 * @param List<ErpDtlVO> erpDtlVOs
	 * @exception DAOException
	 */
	public void modifyErpDtl(List<ErpDtlVO> erpDtlVOs) throws DAOException {
		// TODO Auto-generated method stub
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int updCnt[] = null;
			if(erpDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOmodifyErpDtlUSQL(), erpDtlVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 년도별 사업 계획을 조회한다.
	 * @category VOP_PSO_0035_RetrieveButtonClick
	 * @param PortChgBudByYearVO portChgBudByYearVO
	 * @return List<PortChgBudByYearVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortChgBudByYearVO> searchPortChgBudByYear(	PortChgBudByYearVO portChgBudByYearVO) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PortChgBudByYearVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portChgBudByYearVO != null){
				Map<String, String> mapVO = portChgBudByYearVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOsearchPortChgBudByYearRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortChgBudByYearVO.class);
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
	 * 주어진 TerminalCode로 YardChare의 정보를 가져온다. 
	 * @param tmnlCode String
	 * @param revYrmon String
	 * @return List<YardChargeVO>
	 * @exception DAOException
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<YardChargeVO> selectYdChg(String tmnlCode, String revYrmon) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<YardChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tmnlCode != null && revYrmon != null){
				param.put("yd_cd", tmnlCode);
				param.put("rev_yrmon", revYrmon);
				velParam.put("yd_cd", tmnlCode);
				velParam.put("rev_yrmon", revYrmon);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOselectYdChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardChargeVO.class);
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
	 * Estimated 비용을 TgtYdExpn테이블에 데이터를 Insert한다.
	 * @param PsoTgtYdExpnVO psoTgtYdExpnVO
	 * @param String ds
	 * @exception DAOException
	 */
	public void insertTgtYdExpn(PsoTgtYdExpnVO psoTgtYdExpnVO, String ds) throws DAOException {
		// TODO Auto-generated method stub
		try {
			SQLExecuter sqlExe = null;
			if(ds.equals(""))
				sqlExe = new SQLExecuter(this.dataSource);
			else 
				sqlExe = new SQLExecuter("PSO_HJSBAT");//Create 권한이 다르므로 Connection 변경
			int insCnt[] = null;
		
			if(psoTgtYdExpnVO != null){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BudgetPortChargeMgtDBDAOinsertTgtYdExpnCSQL(), Arrays.asList(psoTgtYdExpnVO), null );
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Estimated 비용을 TgtYdExpn테이블에서 삭제한다.
	 * @param PsotgtYdExpnVO psoTgtYdExpnVO
	 * @param String ds
	 * @exception DAOException
	 */
	public void deleteTgtYdExpn(PsoTgtYdExpnVO psoTgtYdExpnVO, String ds)  throws DAOException {
		// TODO Auto-generated method stub
		try {
			SQLExecuter sqlExe = null;
			if(ds.equals(""))
				sqlExe = new SQLExecuter(this.dataSource);
			else 
				sqlExe = new SQLExecuter("PSO_HJSBAT");//Create 권한이 다르므로 Connection 변경
			int delCnt[] = null;
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(psoTgtYdExpnVO != null){
				Map<String, String> mapVO = psoTgtYdExpnVO.getColumnValues();
				velParam.putAll(mapVO);

				delCnt = sqlExe.executeBatch((ISQLTemplate)new BudgetPortChargeMgtDBDAOdeleteTgtYdExpnDSQL(), Arrays.asList(psoTgtYdExpnVO), velParam );
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * 기 수집된 추정 데이터를 GlEstmIfErp테이블에서 삭제한다.
	 * @param PsoTgtYdExpnVO psoTgtYdExpnVO
	 * @exception DAOException
	 */
	public void deleteGlEstmIfErp(PsoTgtYdExpnVO psoTgtYdExpnVO)  throws DAOException {
		// TODO Auto-generated method stub
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int delCnt[] = null;
			if(psoTgtYdExpnVO != null){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BudgetPortChargeMgtDBDAOdeleteGlEstmIfErpDSQL(), Arrays.asList(psoTgtYdExpnVO), null );
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * VVD별 Expense Plan Detail 내역을 (Pop-Up) 조회한다.
	 * @category VOP_PSO_0201_windowOpen
	 * @param BudEstDtlCondVO budEstDtlCondVO
	 * @return List<BudEstSumByMonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BudEstSumByMonVO> searchBudEstDtlByMonCost(
			BudEstDtlCondVO budEstDtlCondVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<BudEstSumByMonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(budEstDtlCondVO != null){
				Map<String, String> mapVO = budEstDtlCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BudEstSumByMonVO.class);
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
	 * VOP_PSO_0035 : Creation Button Click <br />
	 * VVD를 가지고 해당 VVD별 특정 revYrmon 와 관련된YardCharge의 정보를 조회한다.  <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String revYrmon
	 * @return List<PsoYdChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoYdChgVO> searchYardChargeByVvd(String vslCd,
			String skdVoyNo, String skdDirCd, String revYrmon)  throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoYdChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslCd != null && skdVoyNo!=null && skdDirCd!=null && revYrmon!=null){
				param.put("vsl_cd", vslCd);		
				param.put("skd_voy_no", skdVoyNo);		
				param.put("skd_dir_cd", skdDirCd);		
				param.put("rev_yrmon", revYrmon);		
				velParam.put("vsl_cd", vslCd);		
				velParam.put("skd_voy_no", skdVoyNo);		
				velParam.put("skd_dir_cd", skdDirCd);		
				velParam.put("rev_yrmon", revYrmon);		
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOsearchYardChargeByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoYdChgVO.class);
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
	 * VOP_PSO_0035 : Creation Button Click <br />
	 * 메인 리스트에서 선택한 VVD 별 Budget 정보를 재 생성한다. <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param PsoTgtYdSkdVO psoTgtYdSkdVO
	 * @exception DAOException
	 */
	public void insertTgtYdSkd(PsoTgtYdSkdVO psoTgtYdSkdVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int insCnt[] = null;
			if(psoTgtYdSkdVO != null){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BudgetPortChargeMgtDBDAOinsertTgtYdSkdCSQL(), Arrays.asList(psoTgtYdSkdVO), null );
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VOP_PSO_0035 : Creation Button Click <br />
	 * 메인 리스트에서 선택한 VVD 별 Budget 정보를 재 생성한다. <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param PsoTgtVvdVO psoTgtVvdVO
	 * @exception DAOException
	 */
	public void insertTgtVvd(PsoTgtVvdVO psoTgtVvdVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int insCnt[] = null;
			if(psoTgtVvdVO != null){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BudgetPortChargeMgtDBDAOinsertTgtVvdCSQL(), Arrays.asList(psoTgtVvdVO), null );
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VOP_PSO_0213 : Open <br />
	 * 선택한 VVD 별 Expense Detail 정보를 표시한다. <br />
	 * @category VOP_PSO_0213_Open
	 * @param expnDtlVO
	 * @return List<ExpnDtlVO>
	 * @exception expnDtlVO
	 */
	@SuppressWarnings("unchecked")
	public List<ExpnDtlVO> searchExpenseDetail(ExpnDtlVO expnDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExpnDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(expnDtlVO != null){
				Map<String, String> mapVO = expnDtlVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExpnDtlVO.class);
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
	 * Rev Lane 를 구한다.
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String port
	 * @return String
	 * @exception DAOException
	 */
	public String getRlaneCd(String vslCd, String skdVoyNo, String skdDirCd,
			String port)  throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslCd != null){
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("port", port);
				velParam.put("vsl_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("port", port);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOgetRlaneCdRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}


	/**
	 * 해당 VVD가 Turning Port인지 확인한다.
	 * @param hvvd
	 * @param tmnlCode
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode)throws DAOException {
		DBRowSet dbRowset = null;
		boolean bRet = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hvvd != null){
				param.put("vvd", hvvd);
				param.put("yd_cd", tmnlCode);
				velParam.put("vvd", hvvd);
				velParam.put("yd_cd", tmnlCode);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOcheckTurningPortRSQL(), param, velParam);
			if(dbRowset.next()){
				String strRet = dbRowset.getString(1);
				if(strRet.equals("1"))
					bRet = false;
				else
					bRet = true;
			}
			else{
				bRet = true;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bRet;
	}


	/**
	 * 추정 데이타를 GlEstmIfErp 테이블에  Insert 한다. 
	 * @param PsoTgtYdExpnVO psoTgtYdExpnVO
	 * @exception DAOException
	 */
	public void insertGlEstmIfErp(PsoTgtYdExpnVO psoTgtYdExpnVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int insCnt[] = null;
			if(psoTgtYdExpnVO != null){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL(), Arrays.asList(psoTgtYdExpnVO), null );
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PSO 모쥴에 운하 통항 대상 VVD 정보를 생성한다.
	 * @param String portCd
	 * @param String tgtDate
	 * @param String bztpCd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addSppTargetVvd(String portCd, String tgtDate, String bztpCd, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("port_cd", portCd);
			param.put("tgt_date", tgtDate);
			param.put("bztp_cd", bztpCd);
			param.put("cre_usr_id", account.getUsr_id());
			
			velParam.put("port_cd", portCd);
			velParam.put("tgt_date", tgtDate);
			velParam.put("bztp_cd", bztpCd);
			velParam.put("cre_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BudgetPortChargeMgtDBDAOAddSppTargetVvdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * PSO 모쥴에 운하 통항 대상 VVD 정보를 생성한다.
	 * @param String portCd
	 * @param String tgtDate
	 * @param String bztpCd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addSppTargetYdSkd(String portCd, String tgtDate, String bztpCd, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("port_cd", portCd);
			param.put("tgt_date", tgtDate);
			param.put("bztp_cd", bztpCd);
			param.put("cre_usr_id", account.getUsr_id());
			
			velParam.put("port_cd", portCd);
			velParam.put("tgt_date", tgtDate);
			velParam.put("bztp_cd", bztpCd);
			velParam.put("cre_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BudgetPortChargeMgtDBDAOAddSppTargetYdSkdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PSO 모쥴에 운하 통항 대상 VVD 정보를 modify한다. 
	 * @param String portCd
	 * @param String tgtDate
	 * @param String bztpCd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifySppTargetYdSkd(String portCd, String tgtDate, String bztpCd, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("port_cd", portCd);
			param.put("tgt_date", tgtDate);
			param.put("bztp_cd", bztpCd);
			param.put("cre_usr_id", account.getUsr_id());
			
			velParam.put("port_cd", portCd);
			velParam.put("tgt_date", tgtDate);
			velParam.put("bztp_cd", bztpCd);
			velParam.put("cre_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BudgetPortChargeMgtDBDAOmodifySppTargetYdSkdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 Local Amount 를 USD 로 Conversion 한다. <br />
	 * @param String amount
	 * @param String currCd
	 * @param String issDt
	 * @param String type
	 * @return String
	 * @exception DAOException
	 */
	public String getUsdAmt(String amount, String currCd, String issDt, String type) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(amount != null && currCd != null && issDt != null){
				param.put("locl_amt", amount);
				param.put("curr_cd", currCd);
				param.put("iss_dt", issDt);
				param.put("type", type);
				velParam.put("locl_amt", amount);
				velParam.put("curr_cd", currCd);
				velParam.put("iss_dt", issDt);
				velParam.put("type", type);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOgetUsdAmtRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	/**
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 해다 PORT별 VVD 의 IO Ration 정보를 조회한다.<br />
	 * @category VOP_PSO_0014_SaveButtonClick
	 * @param InvAuditDataValidVO invAuditDataValidVO
	 * @return List<IoRatioVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IoRatioVO> getIoRatio(InvAuditDataValidVO invAuditDataValidVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IoRatioVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invAuditDataValidVO != null){
				Map<String, String> mapVO = invAuditDataValidVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOgetIoRatioRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IoRatioVO .class);
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
	 * VOP_PSO_0014 : Save Button Click <br/>
	 * Invoice Creation & Audit 화면에서 Save Button Click 시 Amount 를 In/Out Bound 에 따라 Round , Trunc 하여 자릿수를 정한다. <br />
	 * @param RoundTruncVO rtvo1in
	 * @return RoundTruncVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RoundTruncVO getRoundTruncAmt(RoundTruncVO roundTruncVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RoundTruncVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(roundTruncVO != null){
				Map<String, String> mapVO = roundTruncVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOgetRoundTruncAmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RoundTruncVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}


	/**
	 * BudgetExpenseCreation Batch 모듈에서 Bud_Yrmon 의 값을 구한다.
	 * @param PsoBudTgtVvdVO budVo
	 * @return String 
	 * @exception DAOException
	 */
	public String getBudYrmon(PsoBudTgtVvdVO budVo) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(budVo != null){
				Map<String, String> mapVO = budVo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOgetBudYrmonRSQL(), param, velParam);
			if(dbRowset.next()) 
				strRet = dbRowset.getString(1); 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * Tariff 에서 구해진 비용을 USD로 변환한다.
	 * @param invLoclAmt
	 * @param loclCurrCd
	 * @param pagerows
	 * @param string
	 * @return
	 * @exception DAOException
	 */
	public String getUsdAmtBudget(String invLoclAmt, String loclCurrCd,
			String pagerows) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invLoclAmt != null && loclCurrCd != null && pagerows != null){
				param.put("locl_amt", invLoclAmt);
				param.put("locl_curr_cd", loclCurrCd);
				param.put("bud_scnr_no", pagerows);
				velParam.put("locl_amt", invLoclAmt);
				velParam.put("locl_curr_cd", loclCurrCd);
				velParam.put("bud_scnr_no", pagerows);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOgetUsdAmtBudgetRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * Invoice Summary Detail을 조회한다.
	 * @param InvSumDtlVO invSumDtlVO
	 * @return List<InvSumDtlVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvSumDtlVO> searchInvSumDtl(InvSumDtlVO invSumDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvSumDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invSumDtlVO != null){
				Map<String, String> mapVO = invSumDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOSearchInvSumDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvSumDtlVO.class);
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
	 * BudScnrNo를 구한다.
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String budYrmon
	 * @return String 
	 * @exception DAOException
	 */
	public String getBudScnrNo(String vslCd, String skdVoyNo, String skdDirCd,
			String budYrmon) throws DAOException{
		DBRowSet dbRowset = null;
		String strRet = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslCd != null && skdVoyNo != null && skdDirCd != null && budYrmon != null){
				param.put("vls_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("bud_yrmon", budYrmon);
				velParam.put("vls_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("bud_yrmon", budYrmon);
			}
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOgetBudScnrNoRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * GL_ESTM_IF_ERP 데이터를 삭제한다.<br>
	 * @category VOP_PSO_0013_Creation
	 * @exception DAOException
	 */
	public void removeGlEstmIfErpByYrMon() throws DAOException,Exception {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BudgetPortChargeMgtDBDAORemoveGlEstmIfErpByYrMonDSQL(), param, velParam);
			//log.error("\nRESULT>> : " + result);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * GL_ESTM_IF_ERP 데이터를 저장한다.<br>
	 * @category VOP_PSO_0013_Creation 
	 * @param ErpSumVO erpSumVO 
	 * @exception DAOException
	 */
	public void addGlEstmIfErpByCreation(ErpSumVO erpSumVO) throws DAOException,Exception {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("rlane_cd", "");
			param.put("cre_usr_id", erpSumVO.getCreUsrId());

			velParam.put("rlane_cd", "");
			velParam.put("cre_usr_id", erpSumVO.getCreUsrId());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BudgetPortChargeMgtDBDAOAddGlEstmIfErpByCreationCSQL(), param, velParam);
			//log.error("\nRESULT>> : " + result);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Budget Creation 정보를 조회한다.
	 * @category VOP_PSO_0008_RetrieveButtonClick (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @param String scrNo
	 * @return List<BudCreVO> 
	 * @exception DAOException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BudCreVO> searchBudCreByMon(String startDt, String endDt, String scrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BudCreVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("start_dt", startDt);
		param.put("end_dt", endDt);
		param.put("scr_no", scrNo);
		
		velParam.put("start_dt", startDt);
		velParam.put("end_dt", endDt);
		velParam.put("scr_no", scrNo);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOSearchBudCreByMonRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BudCreVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Budget Creation 환율정보를 조회한다.
	 * @category VOP_PSO_0008_RetrieveButtonClick (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @param String scrNo
	 * @return List<BudCreVO> 
	 * @exception DAOException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BudCreVO> searchBudCreByCurrency(String startDt, String endDt, String scrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BudCreVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("start_dt", startDt);
		param.put("end_dt", endDt);
		param.put("scr_no", scrNo);
		
		velParam.put("start_dt", startDt);
		velParam.put("end_dt", endDt);
		velParam.put("scr_no", scrNo);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOSearchBudCreByCurrencyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BudCreVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 기준월에 해당하는 추정 대상 항차를 조회한다.
	 * 
	 * @category VOP_PSO_0009_RetrieveButtonClick (jmh)
	 * @param String revYrmon
	 * @param String vslSlanCd
	 * @return List<EstCreVO> 
	 * @exception DAOException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EstCreVO> searchEstCreByMon(String revYrmon, String vslSlanCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstCreVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("rev_yrmon", revYrmon);
		param.put("vsl_slan_cd", vslSlanCd);

		velParam.put("rev_yrmon", revYrmon);
		velParam.put("vsl_slan_cd", vslSlanCd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstCreVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/*
	 * CHM-201006127-01 Estimate Expense Creation 관련 Turning Port에 대한 로직 보완
	 */
	/**
	 * PSO Target VVD 정보를 조회한다.
	 * @category VOP_PSO_0010_ExpenseApplyClick
	 * @param PsoTgtVvdVO psoTgtVvdVO
	 * @return PsoTgtVvdVO 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsoTgtVvdVO searchPsoTgtVVD(PsoTgtVvdVO psoTgtVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoTgtVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(psoTgtVvdVO != null){
			Map<String, String> mapVO = psoTgtVvdVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOSearchPsoTgtVvdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoTgtVvdVO.class);
			if(list!=null && list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/*
	 * CHM-CHM-201007130-01
	 */
	/**
	 * LOC_CD를 이용하여 항비 배분 정보를 조회한다.
	 * 
	 * @param PsoPortExpnDivVO psoPortExpnDivVO
	 * @return List<PsoPortExpnDivVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoPortExpnDivVO> searchPsoPortExpnDivByLocCd(PsoPortExpnDivVO psoPortExpnDivVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoPortExpnDivVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(psoPortExpnDivVO != null){
			Map<String, String> mapVO = psoPortExpnDivVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOSearchPsoPortExpnDivByLocCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoPortExpnDivVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 주어진 BIZ TYPE CODE을 가지는 VVD 정보가 존재하는지 확인한다.
	 * 
	 * @param PsoTgtVvdVO psoTgtVvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchVvdExpenseSimulationStatus(PsoTgtVvdVO psoTgtVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(psoTgtVvdVO != null){
			Map<String, String> mapVO = psoTgtVvdVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		
		try{
			int count = 0;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BudgetPortChargeMgtDBDAOSearchVvdExpenseSimulationStatusRSQL(), param, velParam);
			if(dbRowset.next()){
				count = dbRowset.getInt(1);
			}
			return count;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD 단위 Tariff Simulation 대상 항차 정보를 등록한다.
	 * 
	 * @param List<PsoTgtVvdVO> psoTgtVvdVOs
	 * @return int
	 * @exception DAOException
	 */
	public int addVvdExpenseSimulationSetup(List<PsoTgtVvdVO> psoTgtVvdVOs) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		try {
			for(PsoTgtVvdVO psoTgtVvdVO : psoTgtVvdVOs){
				param = new HashMap<String, Object>();
				param.put("pso_bztp_cd", psoTgtVvdVO.getPsoBztpCd());
				param.put("vsl_cd", psoTgtVvdVO.getVslCd());
				param.put("skd_voy_no", psoTgtVvdVO.getSkdVoyNo());
				param.put("skd_dir_cd", psoTgtVvdVO.getSkdDirCd());
				param.put("cre_usr_id", psoTgtVvdVO.getCreUsrId());
				param.put("upd_usr_id", psoTgtVvdVO.getCreUsrId());
				params.add(param);
			}
			
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int[] count = sqlExe.executeBatch((ISQLTemplate)new BudgetPortChargeMgtDBDAOAddVvdExpenseSimulationSetupCSQL(), psoTgtVvdVOs, velParam);
			if(count.length != psoTgtVvdVOs.size()){
				throw new DAOException("Fail to Insert SQL");	
			}
			
			return count.length;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * VVD 단위 Tariff Simulation 대상 항차 정보를 삭제한다.
	 * 
	 * @param String psoBztpCd
	 * @exception DAOException
	 */
	public void removeVvdExpenseSimulationSetup(String psoBztpCd) throws DAOException {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			param.put("pso_bztp_cd", psoBztpCd);
			result = sqlExe.executeUpdate((ISQLTemplate)new BudgetPortChargeMgtDBDAORemoveVvdExpenseSimulationSetupDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to Delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
}
