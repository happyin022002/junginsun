/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BudgetPortChargeMgtBCImpl.java
 *@FileTitle : Budget vs Actual
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBC;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.IoRatioVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.RoundTruncVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration.BudgetPortChargeMgtDBDAO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstDtlCondVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstSumByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ContinentVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.CtrlOfficeVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpSumVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstExpnCreVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstPendulumVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstTgtVvdByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ExpnDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumByMonVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.PortChgBudByYearVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.YardChargeVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.apps.opus.vop.pso.psocommonutil.PsoConstants;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PsoBudTgtVvdVO;
import com.clt.syscommon.common.table.PsoTgtVvdVO;
import com.clt.syscommon.common.table.PsoTgtYdExpnVO;
import com.clt.syscommon.common.table.PsoYdChgVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-PortChargeBudget Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see Reference each DAO class of VOP_PSO_0025EventResponse,BudgetPortChargeMgtBC
 * @since J2EE 1.6
 */
public class BudgetPortChargeMgtBCImpl extends BasicCommandSupport implements BudgetPortChargeMgtBC {

	// Database Access Object
	private transient BudgetPortChargeMgtDBDAO dbDao = null;

	/**
	 * Creating object BudgetPortChargeMgtBCImpl <br>
	 * Creating BudgetPortChargeMgtDBDAO<br>
	 */
	public BudgetPortChargeMgtBCImpl() {
		dbDao = new BudgetPortChargeMgtDBDAO();
	}
	
	/**
	 * parameterized constructor
	 * @param dataSource
	 */
	public BudgetPortChargeMgtBCImpl(String dataSource) {
		dbDao = new BudgetPortChargeMgtDBDAO(dataSource);
	}

	/**
	 *  Retrieve Budget vs Actual. <br>
	 * 
	 * @param EstTgtVvdByMonVO   esttgtvvdbymonvo
	 * @return List<EstTgtVvdByMonVO>
	 * @exception EventException
	 */
	public List<EstTgtVvdByMonVO> searchSumRptByPeriodSo(EstTgtVvdByMonVO esttgtvvdbymonvo) throws EventException {
		try {
			StringTokenizer token = new StringTokenizer(esttgtvvdbymonvo.getTermCode());
			int tcount = 0;
			int count = 0;
			
			while( token.hasMoreElements()){
				token.nextToken(",");
				tcount++;
			}
			
			token = new StringTokenizer(esttgtvvdbymonvo.getTermCode());
			StringBuffer buf = new StringBuffer();
			
			if( tcount == 1) {
				buf.append( esttgtvvdbymonvo.getPortCd()).append( esttgtvvdbymonvo.getTermCode());
			} else {
				count = 1;
				while( token.hasMoreElements()){
					if( count == 1 )
						buf.append( esttgtvvdbymonvo.getPortCd()).append(token.nextToken(",")).append("\'").append(",");
					else if( count == tcount )
						buf.append("\'").append( esttgtvvdbymonvo.getPortCd()).append(token.nextToken(","));
					else
						buf.append("\'").append( esttgtvvdbymonvo.getPortCd()).append(token.nextToken(",")).append("\'").append(",");
					count++;
				}
			}
			
			esttgtvvdbymonvo.setTermCode(buf.toString());

			return dbDao.searchSumRptByPeriodSo(esttgtvvdbymonvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget vs Actual"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget vs Actual"}).getUserMessage(),ex);
		}
	}	

	
	/**
	 *  Retrieve Invoice Summary.<br>
	 * 
	 * @param InvSumByMonVO   invSumByMonVO
	 * @return List<InvSumByMonVO>
	 * @exception EventException
	 */
	public List<InvSumByMonVO> searchSumRptByPeriodInv(InvSumByMonVO invSumByMonVO) throws EventException {
		try {
			StringTokenizer token = new StringTokenizer(invSumByMonVO.getTermCode());
			int tcount = 0;
			int count = 0;

			while( token.hasMoreElements()){
				token.nextToken(",");
				tcount++;
			}
			
			token = new StringTokenizer(invSumByMonVO.getTermCode());
			StringBuffer buf = new StringBuffer();
			
			if( tcount == 1) {
				buf.append( invSumByMonVO.getPortCd()).append( invSumByMonVO.getTermCode());
			} else {
				count = 1;
				while( token.hasMoreElements()){
					if( count == 1 )
						buf.append( invSumByMonVO.getPortCd()).append(token.nextToken(",")).append("\'").append(",");
					else if( count == tcount )
						buf.append("\'").append( invSumByMonVO.getPortCd()).append(token.nextToken(","));
					else
						buf.append("\'").append( invSumByMonVO.getPortCd()).append(token.nextToken(",")).append("\'").append(",");
					count++;
				}
			}
			
			invSumByMonVO.setTermCode(buf.toString());
			return dbDao.searchSumRptByPeriodInv(invSumByMonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget vs Actual"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget vs Actual"}).getUserMessage(),ex);
		}
	}
	


    /**
     * Retrieve Invoice Summary BackEndJob
     * 2016.05.19 Add
     * @param InvSumByMonVO invSumByMonVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String searchSumRptByPeriodInvBackEndJob(InvSumByMonVO invSumByMonVO, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
        	BudgetPortChargeMgtBCBackEndJob backEndResult = new BudgetPortChargeMgtBCBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setJobFlg("RETRIEVE");
    		backEndResult.setInvSumByMonVO(invSumByMonVO);
    		backEndResult.setSignOnUserAccount(signOnUserAccount);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "PSO Port Charge Invoice Summary Retrieve!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Port Charge Invoice Summary", "Retrieve"}).getMessage(), ex);
        }
    }
    
    /**
     * Retrieve Common BackEndJob Status
     * 2016.05.19 Add
     * 
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchComBackEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"BackendJob", "Search BackendJob Status"}).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"BackendJob", "Search BackendJob Status"}).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"BackendJob", "Search BackendJob Status"}).getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"BackendJob", "Search BackendJob Status"}).getMessage(), ex);
		}
	} 

	/**
	 * retrieve Expense Plan Per VVD
	 * @category VOP_PSO_0010_RetrieveButtonClick
	 * @param EstExpnCreVO estExpnCreVO
	 * @return List<EstExpnCreVO>
	 */
	public List<EstExpnCreVO> searchEstTgtVvdByMon(EstExpnCreVO estExpnCreVO) throws EventException {
		try {
			return dbDao.searchEstTgtVvdByMon(estExpnCreVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Estimate Expense Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Estimate Expense Creation"}).getUserMessage(),ex);
		}
	}

	/**
	 * Retrieve estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0013_RetrieveButtonClick
	 * @param ErpSumVO erpSumVO
	 * @return List<ErpSumVO>
	 * @exception EventException
	 */
	public List<ErpSumVO> searchErpSum(ErpSumVO erpSumVO) throws EventException {
		try {
			return dbDao.searchErpSum(erpSumVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation"}).getUserMessage(),ex);
		}
	}



	/**
	 * Detail Down Excel estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0013_DetailDownExcelButtonClick
	 * @param ErpSumVO erpSumVO
	 * @return List<ErpDtlVO>
	 * @exception EventException
	 */
	public List<ErpDtlVO> searchErpDtlExcelData(ErpSumVO erpSumVO) throws EventException {
		try {
			return dbDao.searchErpDtlExcelData(erpSumVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation Detail Down Excel"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation Detail Down Excel"}).getUserMessage(),ex);
		}
	}
	


    /**
     * Detail Down Excel BackEndJob
     * 2016.12.19 Add
	 * @category VOP_PSO_0013_DetailExcelBackEndJobRetrieveBtnClick
     * @param ErpSumVO erpSumVo
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String searchErpDtlExcelDataBackEndJob(ErpSumVO erpSumVo, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
        	BudgetPortChargeMgtBCErpExcelBackEndJob backEndResult = new BudgetPortChargeMgtBCErpExcelBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setJobFlg("ERP_DETAIL_EXCEL");
    		backEndResult.setErpSumVO(erpSumVo);
    		backEndResult.setSignOnUserAccount(signOnUserAccount);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "Monthly Estimation Creation Detail Down Excel Back End Job Retrieve!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation Detail Down Excel Back End Job", "Retrieve"}).getMessage(), ex);
        }
    }

	/**
	 * Retrieve a detailed estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 */
	public List<ErpDtlVO> searchErpDtl(ErpDtlVO erpDtlVO) throws EventException {			
		try {
			return dbDao.searchErpDtl(erpDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation (Detail)"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation (Detail)"}).getUserMessage(),ex);
		}
	}

	/**
	 * Retrieve a detailed estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 */
	public List<ContinentVO> searchContinentByErp(ErpDtlVO erpDtlVO) throws EventException {			
		try {
			return dbDao.searchContinentByErp(erpDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation (Detail)"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation (Detail)"}).getUserMessage(),ex);
		}
	}

	/**
	 * Change estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0207_SaveButtonClick
	 * @param ErpDtlVO[] erpDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyErpDtl(ErpDtlVO[] erpDtlVOs, SignOnUserAccount account) throws EventException {			
		
		try {
			List<ErpDtlVO> updateVoList = new ArrayList<ErpDtlVO>();
			List<ErpDtlVO> deleteVoList = new ArrayList<ErpDtlVO>();
			
			for ( int i=0; i<erpDtlVOs.length; i++ ) {
				erpDtlVOs[i].setUpdUsrId(account.getUsr_id());
				if ( "U".equals(erpDtlVOs[i].getIbflag())){
					updateVoList.add(erpDtlVOs[i]);
				} else if("D".equals(erpDtlVOs[i].getIbflag())){
					deleteVoList.add(erpDtlVOs[i]);
				}
			}
			if(null != deleteVoList && deleteVoList.size() > 0){
				dbDao.removeErpDtl(deleteVoList);
			}
			if(null != updateVoList && updateVoList.size() > 0){
				dbDao.modifyErpDtl(updateVoList);
				
				//SYS_SRC_ID = PS2 로 변경된 데이타 Insert 및 Update
				dbDao.mergeErpDtlByAccrual(updateVoList);
			}
		} 
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Monthly Estimation Creation (Detail)"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Monthly Estimation Creation (Detail)"}).getUserMessage(),ex);
		}
	}

	/**
	 * Retrieve business plan by year
	 * @category VOP_PSO_0035_RetrieveButtonClick
	 * @param PortChgBudByYearVO portChgBudByYearVO
	 * @return List<PortChgBudByYearVO>
	 * @exception EventException
	 */
	public List<PortChgBudByYearVO> searchPortChgBudByYear(	PortChgBudByYearVO portChgBudByYearVO) throws EventException {		
		try {
			return dbDao.searchPortChgBudByYear(portChgBudByYearVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation"}).getUserMessage(),ex);
		}
	}

	/**
	 * Create VVD which is object of port expense of this month by VVD standard which is object of monthly income
	 * @category VOP_PSO_0010_ExpenseApplyButtonClick
	 * @param EstExpnCreVO[] estExpnCreVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void createEstTgtVvdByMon(EstExpnCreVO[] estExpnCreVOs, SignOnUserAccount account)throws EventException {
		try {
			//EstExpnCreVO turnEstExpnCreVO = new EstExpnCreVO();
			for ( int i=0; i<estExpnCreVOs.length; i++ ) {
				if ( estExpnCreVOs[i].getIbflag().equals("U")){
					log.debug("\n createEstTgtVvdByMon Normal estExpnCreVOs List data start ===================================="+
							  "\n getTmnlCode     	["+estExpnCreVOs[i].getTmnlCode()+"]"+
							  "\n getVslCd			[" +estExpnCreVOs[i].getVslCd()+"]" +
							  "\n getSkdVoyNoydCd	[" + estExpnCreVOs[i].getSkdVoyNo()+"]" +
							  "\n getSkdDirCd		[" + estExpnCreVOs[i].getSkdDirCd()+"]" +
							  "\n getRevYrmon		[" + estExpnCreVOs[i].getRevYrmon()+"]" +
							  "\n getExeYrmon		[" + estExpnCreVOs[i].getExeYrmon()+"]" +
							  "\n getLane			[" + estExpnCreVOs[i].getLane()+"]" +
							  "\n turnPortFlg   	[" + estExpnCreVOs[i].getTurnPortFlg()+"]"+
							  "\n turnPortIndCd 	[" + estExpnCreVOs[i].getTurnPortIndCd()+"]"+
							  "\n getClptIndSeq 	[" + estExpnCreVOs[i].getClptIndSeq()+"]"+
							  "\n createEstTgtVvdByMon Normal estExpnCreVOs List data e n d====================================");
					
					createEstTgtVvdByMon(estExpnCreVOs[i], account);
				} 
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Expense Creation"}).getMessage(),ex);
		}
	}
	
	private void createEstTgtVvdByMon(EstExpnCreVO estExpnCreVO, SignOnUserAccount account) throws EventException {
		//CalcTariffVO calcTariffVO = new CalcTariffVO();
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();//2-phase commit

		try{
			//TODO 넘어온 VO를 기준으로 Pendulum/General 구분하여 List Object를 만든다.
			//0. 넘어온 slane_cd로 pendulum 여부 판단.
			//1. General :  turnPortFlg = Y 일때 turnPort vvd 존재하므로 사용. N 일때는 없으므로 자기자신만 실행.
			//2. Pendulum 일때는 turnPortFlg = Y turnPort vvd 존재하기 때문에 그대로 사용. N은 새로 구한다.
			
			EstPendulumVO estPendVO = new EstPendulumVO(); 
			estPendVO.setSlanCd	(estExpnCreVO.getLane());
			//estPendVO.setYdCd	(estExpnCreVO.getTmnlCode());
			//estPendVO.setSkdDirCd(estExpnCreVO.getSkdDirCd());
			
			String pendulumFlg = dbDao.getPendulumFlag(estPendVO);
			boolean bTurnFlg  = false;
			
			log.debug("\n createEstTgtVvdByMon pendulumFlg ["+pendulumFlg+"]");
			
			//Turn 존재시 재귀 호출함.
			EstExpnCreVO turnEstExpnCreVO = new EstExpnCreVO();
			if(!StringUtils.isEmpty(estExpnCreVO.getTurnSkdVoyNo()) && !StringUtils.isEmpty(estExpnCreVO.getTurnSkdDirCd()) && !StringUtils.isEmpty(estExpnCreVO.getTurnClptIndSeq())){
				
				PsoTgtVvdVO psoTgtVvdVO = new PsoTgtVvdVO();
				psoTgtVvdVO.setVslCd	(estExpnCreVO.getVslCd());
				psoTgtVvdVO.setSkdVoyNo	(estExpnCreVO.getTurnSkdVoyNo());
				psoTgtVvdVO.setSkdDirCd	(estExpnCreVO.getTurnSkdDirCd());
				
				//revYrmon 를 새로 구하기 위해서 대상을 찾는다.
				PsoTgtVvdVO tgtVvdVO = dbDao.searchPsoTgtVVD(psoTgtVvdVO);
				if(tgtVvdVO != null){						
					ObjectCloner.build(estExpnCreVO, turnEstExpnCreVO);
					if(StringUtils.isNotEmpty(tgtVvdVO.getExpnYrmon())){
						turnEstExpnCreVO.setRevYrmon(tgtVvdVO.getExpnYrmon());
					}
					turnEstExpnCreVO.setSkdVoyNo		(estExpnCreVO.getTurnSkdVoyNo());
					turnEstExpnCreVO.setSkdDirCd		(estExpnCreVO.getTurnSkdDirCd());
					turnEstExpnCreVO.setClptIndSeq		(estExpnCreVO.getTurnClptIndSeq());
					turnEstExpnCreVO.setTurnPortFlg		(estExpnCreVO.getVirTurnPortFlg());
					turnEstExpnCreVO.setTurnPortIndCd	(estExpnCreVO.getVirTurnPortIndCd());
					turnEstExpnCreVO.setHvvd			(estExpnCreVO.getVslCd()+estExpnCreVO.getTurnSkdVoyNo()+estExpnCreVO.getTurnSkdDirCd());
					
					bTurnFlg = true; //아래에서 List에 Add 할때 사용될 flag
					
					log.debug("\n createEstTgtVvdByMon Turn estExpnCreVOs List data start ===================================="+
							  "\n Turn getTmnlCode     	[" + turnEstExpnCreVO.getTmnlCode()+"]"+
							  "\n Turn getVslCd			[" + turnEstExpnCreVO.getVslCd()+"]" +
							  "\n Turn getSkdVoyNoydCd	[" + turnEstExpnCreVO.getSkdVoyNo()+"]" +
							  "\n Turn getSkdDirCd		[" + turnEstExpnCreVO.getSkdDirCd()+"]" +
							  "\n Turn getRevYrmon		[" + turnEstExpnCreVO.getRevYrmon()+"]" +
							  "\n Turn getExeYrmon		[" + turnEstExpnCreVO.getExeYrmon()+"]" +
							  "\n Turn turnPortFlg   	[" + turnEstExpnCreVO.getTurnPortFlg()+"]"+
							  "\n Turn turnPortIndCd 	[" + turnEstExpnCreVO.getTurnPortIndCd()+"]"+
							  "\n Turn getClptIndSeq 	[" + turnEstExpnCreVO.getClptIndSeq()+"]"+
							  "\n createEstTgtVvdByMon Turn estExpnCreVOs List data e n d====================================");
					
				}
			}
			
			log.debug("\n createEstTgtVvdByMon ArrayList Data Setting Check Flag start ===================================="+
					  "\n pendulumFlg   [" + pendulumFlg+"]"+
					  "\n TurnPortFlg	[" + estExpnCreVO.getTurnPortFlg()+"]" +
					  "\n TurnPortIndCd	[" + estExpnCreVO.getTurnPortIndCd()+"]" +
					  "\n bTurnFlg		[" + bTurnFlg+"]" +
					  "\n createEstTgtVvdByMon ArrayList Data Setting Check Flag e n d====================================");
			
			List<EstExpnCreVO> newEstExpnCreVoList = new ArrayList<EstExpnCreVO>();
			if(pendulumFlg.equals("N") || StringUtils.isEmpty(pendulumFlg)){				
				log.debug("\ncreateEstTgtVvdByMon ====> General In ArrayList Data Setting Case.");
				//General Case
				newEstExpnCreVoList.add(estExpnCreVO);
				if(bTurnFlg) newEstExpnCreVoList.add(turnEstExpnCreVO);
			}else{				
				log.debug("\ncreateEstTgtVvdByMon ====> Pendulum In ArrayList Data Setting Case.");
				//Pendulum Case
				if("N".equals(estExpnCreVO.getTurnPortFlg()) && "N".equals(estExpnCreVO.getTurnPortIndCd()) ){
					log.debug("\ncreateEstTgtVvdByMon ====> Pendulum In TurnPortFlg[N] TurnPortIndCd[N] ArrayList Data Setting Case.");
					//pendulum =y && turnportflag = n case : 걸린 pendulum 을 구한다.
					//TODO 새로 구해서 vvd 데이탈ㄹ 넣는다.
					EstPendulumVO estPendulumVO = new EstPendulumVO(); 
					estPendulumVO.setVslCd		(estExpnCreVO.getVslCd());
					estPendulumVO.setSkdVoyNo	(estExpnCreVO.getSkdVoyNo());
					estPendulumVO.setSkdDirCd	(estExpnCreVO.getSkdDirCd());
					estPendulumVO.setYdCd		(estExpnCreVO.getTmnlCode());
					estPendulumVO.setClptIndSeq	(estExpnCreVO.getClptIndSeq());
					estPendulumVO.setExeYrmon	(estExpnCreVO.getExeYrmon());
					
					//n건의 레코드가 조회 된다.(Pendulum Data를 조회 한다.)
					List<EstPendulumVO> pendulumList = dbDao.searchPendulumInfo(estPendulumVO);
					
					for(EstPendulumVO vo : pendulumList){
						EstExpnCreVO tmpEstExpnCreVO = new EstExpnCreVO();
						
						ObjectCloner.build(estExpnCreVO, tmpEstExpnCreVO);
						
						if(StringUtils.isNotEmpty(vo.getRevYrmon())){
							tmpEstExpnCreVO.setRevYrmon(vo.getRevYrmon());
						}
						tmpEstExpnCreVO.setVslCd		(vo.getVslCd());
						tmpEstExpnCreVO.setSkdVoyNo		(vo.getSkdVoyNo());
						tmpEstExpnCreVO.setSkdDirCd		(vo.getSkdDirCd());
						tmpEstExpnCreVO.setHvvd			(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
						//tmpEstExpnCreVO.setClptIndSeq(estExpnCreVO.getTurnClptIndSeq());
						tmpEstExpnCreVO.setTurnPortFlg	(vo.getTurnPortFlg());
						tmpEstExpnCreVO.setTurnPortIndCd(vo.getTurnPortIndCd());
						tmpEstExpnCreVO.setRlaneCd		(vo.getRlaneCd());
						tmpEstExpnCreVO.setIbBnd		(vo.getIbBnd());
						tmpEstExpnCreVO.setPendulumFlag	(pendulumFlg);
						tmpEstExpnCreVO.setOriRevYrmon	(vo.getOriRevYrmon());
						tmpEstExpnCreVO.setClptIndSeq	(vo.getClptIndSeq());
						
						tmpEstExpnCreVO.setRlaneDirCd	(vo.getRlaneDirCd()); //2016.07.28 Add

						log.debug("\n createEstTgtVvdByMon ====> Pendulum In TurnPortFlg[N] TurnPortIndCd[N] ArrayList Data Setting List data start ===================================="+
								  "\n Turn getTmnlCode     	[" + tmpEstExpnCreVO.getTmnlCode()+"]"+
								  "\n Turn getClptIndSeq 	[" + tmpEstExpnCreVO.getClptIndSeq()+"]"+
								  "\n Turn getVslCd			[" + tmpEstExpnCreVO.getVslCd()+"]" +
								  "\n Turn getSkdVoyNoydCd	[" + tmpEstExpnCreVO.getSkdVoyNo()+"]" +
								  "\n Turn getSkdDirCd		[" + tmpEstExpnCreVO.getSkdDirCd()+"]" +
								  "\n Turn getRevYrmon		[" + tmpEstExpnCreVO.getRevYrmon()+"]" +
								  "\n Turn getOriRevYrmon 	[" + tmpEstExpnCreVO.getOriRevYrmon()+"]"+
								  "\n Turn getExeYrmon		[" + tmpEstExpnCreVO.getExeYrmon()+"]" +
								  "\n Turn getRlaneCd		[" + tmpEstExpnCreVO.getRlaneCd()+"]" +
								  "\n Turn getRlaneDirCd	[" + tmpEstExpnCreVO.getRlaneDirCd()+"]" +
								  "\n Turn turnPortFlg   	[" + tmpEstExpnCreVO.getTurnPortFlg()+"]"+
								  "\n Turn turnPortIndCd 	[" + tmpEstExpnCreVO.getTurnPortIndCd()+"]"+
								  "\n createEstTgtVvdByMon ====> Pendulum In TurnPortFlg[N] TurnPortIndCd[N] ArrayList Data Setting data e n d====================================");
						
						newEstExpnCreVoList.add(tmpEstExpnCreVO);
					}					
					
				}else{
					log.debug("\ncreateEstTgtVvdByMon ====> Pendulum In TurnPortFlg[Y] TurnPortIndCd[Y] ArrayList Data Setting Case.");
					//pendulum = Y && turnportflg = Y case
					EstPendulumVO estPendulumVO = new EstPendulumVO(); 
					estPendulumVO.setVslCd		(estExpnCreVO.getVslCd());
					estPendulumVO.setSkdVoyNo	(estExpnCreVO.getSkdVoyNo());
					estPendulumVO.setSkdDirCd	(estExpnCreVO.getSkdDirCd());
					estPendulumVO.setYdCd		(estExpnCreVO.getTmnlCode());
					estPendulumVO.setClptIndSeq	(estExpnCreVO.getClptIndSeq());
					estPendulumVO.setExeYrmon	(estExpnCreVO.getExeYrmon());
					
					//1건의 레코드가 조회 된다.(Pendulum Data를 조회 한다.)
					List<EstPendulumVO> pendulumList = dbDao.searchPendulumInfo(estPendulumVO);
					
					if(pendulumList != null && pendulumList.size() > 0){
						EstPendulumVO vo = (EstPendulumVO)pendulumList.get(0);
						
						if(StringUtils.isNotEmpty(vo.getRevYrmon())){
							estExpnCreVO.setRevYrmon(vo.getRevYrmon());
						}
						estExpnCreVO.setVslCd		(vo.getVslCd());
						estExpnCreVO.setSkdVoyNo	(vo.getSkdVoyNo());
						estExpnCreVO.setSkdDirCd	(vo.getSkdDirCd());
						estExpnCreVO.setHvvd		(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
						//tmpEstExpnCreVO.setClptIndSeq(estExpnCreVO.getTurnClptIndSeq());
						estExpnCreVO.setTurnPortFlg	(vo.getTurnPortFlg());
						estExpnCreVO.setTurnPortIndCd(vo.getTurnPortIndCd());
						estExpnCreVO.setRlaneCd		(vo.getRlaneCd());
						estExpnCreVO.setIbBnd		(vo.getIbBnd());
						estExpnCreVO.setPendulumFlag(pendulumFlg);
						estExpnCreVO.setOriRevYrmon	(vo.getOriRevYrmon());
						estExpnCreVO.setClptIndSeq	(vo.getClptIndSeq());
						
						estExpnCreVO.setRlaneDirCd	(vo.getRlaneDirCd()); //2016.07.28 Add
						

						newEstExpnCreVoList.add(estExpnCreVO);
					}
					
					log.debug("\n createEstTgtVvdByMon ====> Pendulum In Original TurnPortFlg[Y] TurnPortIndCd[Y] ArrayList Data Setting List data start ===================================="+
							  "\n Original getTmnlCode     	[" + estExpnCreVO.getTmnlCode()+"]"+
							  "\n Original getClptIndSeq 	[" + estExpnCreVO.getClptIndSeq()+"]"+
							  "\n Original getVslCd			[" + estExpnCreVO.getVslCd()+"]" +
							  "\n Original getSkdVoyNoydCd	[" + estExpnCreVO.getSkdVoyNo()+"]" +
							  "\n Original getSkdDirCd		[" + estExpnCreVO.getSkdDirCd()+"]" +
							  "\n Original getRevYrmon		[" + estExpnCreVO.getRevYrmon()+"]" +
							  "\n Original getOriRevYrmon 	[" + estExpnCreVO.getOriRevYrmon()+"]"+
							  "\n Original getExeYrmon		[" + estExpnCreVO.getExeYrmon()+"]" +
							  "\n Original getRlaneCd		[" + estExpnCreVO.getRlaneCd()+"]" +
							  "\n Original getRlaneDirCd	[" + estExpnCreVO.getRlaneDirCd()+"]" +
							  "\n Original turnPortFlg   	[" + estExpnCreVO.getTurnPortFlg()+"]"+
							  "\n Original turnPortIndCd 	[" + estExpnCreVO.getTurnPortIndCd()+"]"+
							  "\n createEstTgtVvdByMon ====> Pendulum In Original TurnPortFlg[Y] TurnPortIndCd[Y] ArrayList Data Setting data e n d====================================");
					
					
					if(bTurnFlg){
						EstPendulumVO turnEstPendulumVO = new EstPendulumVO(); 
						turnEstPendulumVO.setVslCd		(turnEstExpnCreVO.getVslCd());
						turnEstPendulumVO.setSkdVoyNo	(turnEstExpnCreVO.getSkdVoyNo());
						turnEstPendulumVO.setSkdDirCd	(turnEstExpnCreVO.getSkdDirCd());
						turnEstPendulumVO.setYdCd		(turnEstExpnCreVO.getTmnlCode());
						turnEstPendulumVO.setClptIndSeq	(turnEstExpnCreVO.getClptIndSeq());
						turnEstPendulumVO.setExeYrmon	(turnEstExpnCreVO.getExeYrmon());
						
						//1건의 레코드가 조회 된다.(Pendulum Data를 조회 한다.)
						List<EstPendulumVO> turnPendulumList = dbDao.searchPendulumInfo(turnEstPendulumVO);
						
						if(turnPendulumList != null && turnPendulumList.size() > 0){
							EstPendulumVO vo = (EstPendulumVO)turnPendulumList.get(0);
							
							if(StringUtils.isNotEmpty(vo.getRevYrmon())){
								turnEstExpnCreVO.setRevYrmon(vo.getRevYrmon());
							}
							turnEstExpnCreVO.setVslCd		(vo.getVslCd());
							turnEstExpnCreVO.setSkdVoyNo	(vo.getSkdVoyNo());
							turnEstExpnCreVO.setSkdDirCd	(vo.getSkdDirCd());
							turnEstExpnCreVO.setHvvd		(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
							//tmpEstExpnCreVO.setClptIndSeq(estExpnCreVO.getTurnClptIndSeq());
							turnEstExpnCreVO.setTurnPortFlg	(vo.getTurnPortFlg());
							turnEstExpnCreVO.setTurnPortIndCd(vo.getTurnPortIndCd());
							turnEstExpnCreVO.setRlaneCd		(vo.getRlaneCd());
							turnEstExpnCreVO.setIbBnd		(vo.getIbBnd());
							turnEstExpnCreVO.setPendulumFlag(pendulumFlg);
							turnEstExpnCreVO.setOriRevYrmon	(vo.getOriRevYrmon());
							turnEstExpnCreVO.setClptIndSeq	(vo.getClptIndSeq());
							
							turnEstExpnCreVO.setRlaneDirCd	(vo.getRlaneDirCd()); //2016.07.28 Add
							

							newEstExpnCreVoList.add(turnEstExpnCreVO);
						}
						
						log.debug("\n createEstTgtVvdByMon ====> Pendulum In Turning TurnPortFlg[Y] TurnPortIndCd[Y] ArrayList Data Setting List data start ===================================="+
								  "\n Turn getTmnlCode     	[" + turnEstExpnCreVO.getTmnlCode()+"]"+
								  "\n Turn getClptIndSeq 	[" + turnEstExpnCreVO.getClptIndSeq()+"]"+
								  "\n Turn getVslCd			[" + turnEstExpnCreVO.getVslCd()+"]" +
								  "\n Turn getSkdVoyNoydCd	[" + turnEstExpnCreVO.getSkdVoyNo()+"]" +
								  "\n Turn getSkdDirCd		[" + turnEstExpnCreVO.getSkdDirCd()+"]" +
								  "\n Turn getRevYrmon		[" + turnEstExpnCreVO.getRevYrmon()+"]" +
								  "\n Turn getOriRevYrmon 	[" + turnEstExpnCreVO.getOriRevYrmon()+"]"+
								  "\n Turn getExeYrmon		[" + turnEstExpnCreVO.getExeYrmon()+"]" +
								  "\n Turn getRlaneCd		[" + turnEstExpnCreVO.getRlaneCd()+"]" +
								  "\n Turn getRlaneDirCd	[" + turnEstExpnCreVO.getRlaneDirCd()+"]" +
								  "\n Turn turnPortFlg   	[" + turnEstExpnCreVO.getTurnPortFlg()+"]"+
								  "\n Turn turnPortIndCd 	[" + turnEstExpnCreVO.getTurnPortIndCd()+"]"+
								  "\n createEstTgtVvdByMon ====> Pendulum In Turning TurnPortFlg[Y] TurnPortIndCd[Y] ArrayList Data Setting data e n d====================================");
						
					}
				}
			}
			
			//위에서 만든 List Loop 로 돌림.
			log.debug("\n createEstTgtVvdByMon List(newEstExpnCreVoList) Size ["+newEstExpnCreVoList.size()+"]");
			int iLoopCnt = 0;
			
			//레코드 존재. 존재 하지 않을시에는 삭제 처리한다.
			if(newEstExpnCreVoList != null && newEstExpnCreVoList.size() > 0){
				//2016.03.31 Delete Data를 List로 저장한다. : REV_YRMON Pendulum 일때는 서로 틀리기 때문에 삭제 로직 변경 필요.
				//2016.03.31 newEstExpnCreVoList 목록 만큼 삭제 로직을 1번만 처리한다.
				List<PsoTgtYdExpnVO> delList = new ArrayList<PsoTgtYdExpnVO>();
				
				for(EstExpnCreVO newEstExpnCreVO : newEstExpnCreVoList){
					PsoTgtYdExpnVO delVo = new PsoTgtYdExpnVO();
					delVo.setPsoBztpCd	("2");
					delVo.setVslCd		(newEstExpnCreVO.getVslCd());
					delVo.setSkdVoyNo	(newEstExpnCreVO.getSkdVoyNo());
					delVo.setSkdDirCd	(newEstExpnCreVO.getSkdDirCd());
					delVo.setYdCd		(newEstExpnCreVO.getTmnlCode());
					delVo.setExeYrmon	(newEstExpnCreVO.getExeYrmon());
					delVo.setRevYrmon	(newEstExpnCreVO.getRevYrmon());
					delVo.setClptIndSeq	(newEstExpnCreVO.getClptIndSeq());
					
					delList.add(delVo);
				}
				
				
				for(EstExpnCreVO newEstExpnCreVO : newEstExpnCreVoList){
					log.debug("\n createEstTgtVvdByMon =========================="+
							  "\n iLoopCnt 		:=["+iLoopCnt+"]"+
				              "\n VVD			:=["+newEstExpnCreVO.getHvvd()+"]"+
				              "\n TerminalCode	:=["+newEstExpnCreVO.getTmnlCode()+"]"+
				              "\n ClptIndSeq	:=["+newEstExpnCreVO.getClptIndSeq()+"]"+
				              "\n exeYrmon		:=["+newEstExpnCreVO.getExeYrmon()+"]"+
				              "\n revYrmon		:=["+newEstExpnCreVO.getRevYrmon()+"]");
					
					
					log.debug("\ncreateEstTgtVvdByMon Pendulum Check Data & Setting Call start.");
					pendulumFlg 			= StringUtils.isEmpty(pendulumFlg) ? "N" : pendulumFlg;
					String pendIbBnd 		= "";
					String pendTurnPortFlg 	= "";
					String pendTurnPortIndCd= "";
					String pendRlaneCd		= "";
					String pendRevYrmon		= "";
					
					if(pendulumFlg.equals("Y")){
						pendIbBnd			= newEstExpnCreVO.getIbBnd();
						pendTurnPortFlg		= newEstExpnCreVO.getTurnPortFlg();
						pendTurnPortIndCd	= newEstExpnCreVO.getTurnPortIndCd();
						pendRlaneCd			= newEstExpnCreVO.getRlaneCd();
						pendRevYrmon		= newEstExpnCreVO.getRevYrmon();
					}
					
					String turnPortFlg 		= newEstExpnCreVO.getTurnPortFlg();
					String turnPortIndCd 	= newEstExpnCreVO.getTurnPortIndCd();
					
					log.debug("\n createEstTgtVvdByMon Pendulum Check data start ===================================="+
							  "\n pendulumFlg     		["+pendulumFlg+"]" +
							  "\n pendIbBnd    			["+pendIbBnd+"]" +
							  "\n pendTurnPortFlg   	["+pendTurnPortFlg+"]" +
							  "\n pendTurnPortIndCd 	["+pendTurnPortIndCd+"]" +
							  "\n pendRlaneCd 			["+pendRlaneCd+"]" +
							  "\n pendRevYrmon 			["+pendRevYrmon+"]" +
							  "\n *turnPortFlg 			["+turnPortFlg+"]" +
							  "\n *turnPortIndCd 		["+turnPortIndCd+"]" +
							  "\n createEstTgtVvdByMon Pendulum Check data e n d====================================");
					
					//2016.03.31 Rev_yrmon가 불 명확하여 Delete 시에 Key 에서 주석처리로 인해 무조건 1번만 삭제처리하도록 로직 변경함.	
					if(iLoopCnt == 0){
						log.debug("\n createEstTgtVvdByMon Delete Case start ====================================");
						for(PsoTgtYdExpnVO deleteVo : delList){						
							log.debug("\n createEstTgtVvdByMon Delete data start ===================================="+
									  "\n getVslCd     		["+deleteVo.getVslCd()+"]" +
									  "\n getSkdVoyNo     	["+deleteVo.getSkdVoyNo()+"]" +
									  "\n getSkdDirCd     	["+deleteVo.getSkdDirCd()+"]" +
									  "\n getYdCd     		["+deleteVo.getYdCd()+"]" +
									  "\n getClptIndSeq		["+deleteVo.getClptIndSeq()+"]" +
									  "\n getExeYrmon     	["+deleteVo.getExeYrmon()+"]" +
									  "\n getRevYrmon     	["+deleteVo.getRevYrmon()+"]" +
									  "\n createEstTgtVvdByMon Delete data e n d====================================");
							
							log.debug("\n createEstTgtVvdByMon Delete deleteTgtYdExpn Call.");
							//Delete deleteTgtYdExpn
							dbDao.deleteTgtYdExpn(deleteVo, PsoConstants.BATCH_DATASOURCE);
							
							log.debug("\n createEstTgtVvdByMon Delete deleteGlEstmIfErp Call.");
							//Delete deleteGlEstmIfErp
							dbDao.deleteGlEstmIfErp(deleteVo);	
						}
						log.debug("\n createEstTgtVvdByMon Delete Case e n d ====================================");
					}
					
					//activity date 
					String actDt = dbDao.getActivityDate(estExpnCreVO.getVslCd(), estExpnCreVO.getSkdVoyNo(), estExpnCreVO.getSkdDirCd(), estExpnCreVO.getTmnlCode(), estExpnCreVO.getClptIndSeq());
					
					//yd charge 구하기
					//[2016.01.22] ETD Date
					String tmpRevYrmon = StringUtils.replaceChars(estExpnCreVO.getRevYrmon(), "-", "");
					
					log.debug("\n createEstTgtVvdByMon Before ETD DT tmpRevYrmon ["+tmpRevYrmon+"] / actDt ["+actDt+"]");
					
					String tmpEtdDt = StringUtils.isEmpty(actDt) ? tmpRevYrmon : actDt;
	
					log.debug("\n createEstTgtVvdByMon After ETD DT ["+tmpEtdDt+"]"); 
					
					List<YardChargeVO> list = dbDao.selectYdChg(estExpnCreVO.getTmnlCode(), tmpEtdDt);
					//List<YardChargeVO> list = dbDao.selectYdChg(estExpnCreVO.getTmnlCode(), estExpnCreVO.getRevYrmon());
	
					log.debug("\n createEstTgtVvdByMon yardChargeVo Loop start ====================================");
					for(YardChargeVO yardChargeVo : list){
						String ydChgNo 		= yardChargeVo.getYdChgNo();
						String ydChgVerSeq 	= yardChargeVo.getYdChgVerSeq();
						String lgsCostCd 	= yardChargeVo.getLgsCostCd();
						String vndrSeq 		= yardChargeVo.getVndrSeq();
						String currCd 		= yardChargeVo.getCurrCd();
						
						
						//Calc parameter Input...
						CalcTariffVO calcTariffVO = new CalcTariffVO();
						
						calcTariffVO.setVvd			(newEstExpnCreVO.getHvvd());//vvd
						calcTariffVO.setYdChgNo		(ydChgNo);
						calcTariffVO.setYdChgVerSeq	(ydChgVerSeq);
						calcTariffVO.setYdCd		(newEstExpnCreVO.getTmnlCode());
						calcTariffVO.setLgsCostCd	(lgsCostCd);
						calcTariffVO.setCurrCd		(currCd);
						
						calcTariffVO.setClptIndSeq	(newEstExpnCreVO.getClptIndSeq()); //2016.04.26 Double calling port Add
	
						calcTariffVO.setEstFlg("Y");
			
						//calcTariffVO.setIoFlag("Estimate");//Estimate InBound/OutBound
						// Turning Port인 경우 OutBound, Virtual Port인 경우 InBound, Normal Port인 경우 Object에 따라 InBound/OutBound 구분
						
						log.debug("\ncreateEstTgtVvdByMon Before IoFlag["+calcTariffVO.getIoFlag()+"] TurnPortFlg["+turnPortFlg+"] TurnPortIndCd["+turnPortIndCd+"]");
						if("N".equals(turnPortFlg) && "N".equals(turnPortIndCd)){
							// Normal Port
							calcTariffVO.setIoFlag("OUT");
						}else{
							// TURN_PORT_IND_CD is D, V, F -> InBound ||  Y, N    -> OutBound
							if("D".equals(turnPortIndCd) || "V".equals(turnPortIndCd) || "F".equals(turnPortIndCd)){
								calcTariffVO.setIoFlag("IN");
							}else{
								calcTariffVO.setIoFlag("OUT");
							}
						}
						
						log.debug("\ncreateEstTgtVvdByMon After IoFlag["+calcTariffVO.getIoFlag()+"] TurnPortFlg["+turnPortFlg+"] TurnPortIndCd["+turnPortIndCd+"]");
						
						//Tariff 계산식에 따른 Amount 계산.
						CalcTariffResultVO calcvo = command.calGeneralInvAudit(calcTariffVO);
						
						// Normal Port
						if("N".equals(turnPortFlg) && "N".equals(turnPortIndCd)){
							
							if(calcvo.existObj(77)){
								float outAmt = Float.parseFloat(calcvo.getTariffAmount());
								String outDisplayFormulaDesc = calcvo.getDisplayFormulaDesc();
								String outRuntimeFormulaDesc = calcvo.getRuntimeFormulaDesc();
								
								calcTariffVO.setIoFlag("IN");
								calcvo = command.calGeneralInvAudit(calcTariffVO);
								float inAmt = Float.parseFloat(calcvo.getTariffAmount());
								String inDisplayFormulaDesc = calcvo.getDisplayFormulaDesc();
								String inRuntimeFormulaDesc = calcvo.getRuntimeFormulaDesc();
								
								// IN/OUT [B], [S], [D] 
								outDisplayFormulaDesc = concatFormula(outDisplayFormulaDesc, inDisplayFormulaDesc, "[B]:");
								outDisplayFormulaDesc = concatFormula(outDisplayFormulaDesc, inDisplayFormulaDesc, "[S]:");
								outDisplayFormulaDesc = concatFormula(outDisplayFormulaDesc, inDisplayFormulaDesc, "[D]:");
								
								outRuntimeFormulaDesc = concatFormula(outRuntimeFormulaDesc, inRuntimeFormulaDesc, "[B]:");
								outRuntimeFormulaDesc = concatFormula(outRuntimeFormulaDesc, inRuntimeFormulaDesc, "[S]:");
								outRuntimeFormulaDesc = concatFormula(outRuntimeFormulaDesc, inRuntimeFormulaDesc, "[D]:");
								
								calcvo.setDisplayFormulaDesc(outDisplayFormulaDesc);
								calcvo.setRuntimeFormulaDesc(outRuntimeFormulaDesc);
								
								// IN/OUT Amount add
								calcvo.setTariffAmount(Float.toString(outAmt + inAmt));
								
								log.debug("\ncreateEstTgtVvdByMon calcvo TariffAmount(OutAmt+InAmt)["+calcvo.getTariffAmount()+"]");
							}
						}
						
						log.debug("\ncreateEstTgtVvdByMon calcvo TariffAmount["+calcvo.getTariffAmount()+"]");
						if(StringUtils.isEmpty(calcvo.getTariffAmount())) continue;
						
						String strLocalAmt 		= "";
						String strUsdAmt 		= "";
						String strDspFomlDesc 	= "";
						String strRtFomlDesc 	= "";
						
						if(calcvo != null){
							strLocalAmt 	= calcvo.getTariffAmount();
							strDspFomlDesc 	= calcvo.getDisplayFormulaDesc();
							strRtFomlDesc 	= calcvo.getRuntimeFormulaDesc();
							
							log.debug("\ncreateEstTgtVvdByMon calcvo TariffAmount USD Amount strLocalAmt ["+strLocalAmt+"] strUsdAmt ["+strUsdAmt+"] currCd["+currCd+"] tmpEtdDt ["+tmpEtdDt+"]  start.");
							
							if (StringUtils.isNotEmpty(strLocalAmt)){// Usd AMT를 구한다.
								//String usdAmt = command.getUsdAmt(strLocalAmt, currCd, newEstExpnCreVO.getRevYrmon(), "1");
								String usdAmt = command.getUsdAmt(strLocalAmt, currCd, tmpEtdDt, "1");
								String usdAmts[] = usdAmt.split("\\|", 2);
								if (usdAmts.length >= 2) {
									if (usdAmts[0].equals("")) {
										strUsdAmt = usdAmts[1];// 계산식으로 구해야 될 부분
									} else {
										strUsdAmt = usdAmts[0];
									}
								}
							}
							log.debug("\ncreateEstTgtVvdByMon calcvo TariffAmount USD Amount strLocalAmt ["+strLocalAmt+"] strUsdAmt ["+strUsdAmt+"] currCd["+currCd+"] tmpEtdDt ["+tmpEtdDt+"]  e n d.");
							
							if (StringUtils.isEmpty(strDspFomlDesc)) 	strDspFomlDesc 	= "";
							if (StringUtils.isEmpty(strRtFomlDesc))		strRtFomlDesc 	= "";
						}//calcvo != null end
						
						
						PsoTgtYdExpnVO insertvo = new PsoTgtYdExpnVO();
						
						insertvo.setPsoBztpCd("2");
						insertvo.setVslCd		(newEstExpnCreVO.getVslCd());
						insertvo.setSkdVoyNo	(newEstExpnCreVO.getSkdVoyNo());
						insertvo.setSkdDirCd	(newEstExpnCreVO.getSkdDirCd());
						insertvo.setYdCd		(newEstExpnCreVO.getTmnlCode());
						insertvo.setLgsCostCd	(lgsCostCd);
						insertvo.setRevYrmon	(newEstExpnCreVO.getRevYrmon());
						//2015.03.11 NYK Add
						insertvo.setExeYrmon	(newEstExpnCreVO.getExeYrmon());
						insertvo.setInvLoclAmt	(strLocalAmt);
						insertvo.setInvUsdAmt	(strUsdAmt);
						insertvo.setLoclCurrCd	(currCd);
						
						insertvo.setYdChgNo		(ydChgNo);
						insertvo.setYdChgVerSeq	(ydChgVerSeq);
						insertvo.setCreUsrId	(account.getUsr_id());
						insertvo.setUpdUsrId	(account.getUsr_id());
						insertvo.setVndrSeq		(vndrSeq);
						insertvo.setActDt		(actDt);
						
						insertvo.setClptIndSeq	(newEstExpnCreVO.getClptIndSeq());	//2016.04.26 Double calling port Add
						
						//2016.07.29 Add : rlane_cd, rlane_dir_cd를 구하는 로직 추가.
						insertvo.setRlaneCd(newEstExpnCreVO.getRlaneCd());
						insertvo.setRlaneDirCd(newEstExpnCreVO.getRlaneDirCd());
						
						insertvo.setYdChgNo(ydChgNo);
						insertvo.setYdChgVerSeq(ydChgVerSeq);
						
						if(StringUtils.isEmpty(insertvo.getRlaneDirCd()) || StringUtils.isEmpty(insertvo.getRlaneCd())){
							//미존재시 다시 구한다.
							//2016.03.29 Add.2016.07.29 Add
							String tmpRlaneCd = dbDao.getRevLaneDir(newEstExpnCreVO.getVslCd(), newEstExpnCreVO.getSkdVoyNo(), newEstExpnCreVO.getSkdDirCd(), newEstExpnCreVO.getTmnlCode(), newEstExpnCreVO.getExeYrmon(), newEstExpnCreVO.getClptIndSeq());
							String aryRevLaneDir[] = tmpRlaneCd.split("\\|", 3);
								
							String tmpNewRlaneCd = StringUtils.isEmpty(newEstExpnCreVO.getRlaneCd()) ? aryRevLaneDir[0] : newEstExpnCreVO.getRlaneCd();
							String tmpNewRlaneDirCd = StringUtils.isEmpty(newEstExpnCreVO.getRlaneDirCd()) ? aryRevLaneDir[1] : newEstExpnCreVO.getRlaneDirCd();
															
							insertvo.setRlaneCd(tmpNewRlaneCd);
							insertvo.setRlaneDirCd(tmpNewRlaneDirCd);
						}
						
						//[2015.06.02] exeYrmon Add.
						/*String strRlaneCd = "";
						if(!pendulumFlg.equals("Y")){
							strRlaneCd = dbDao.getRlaneCd(newEstExpnCreVO.getVslCd(),newEstExpnCreVO.getSkdVoyNo(),newEstExpnCreVO.getSkdDirCd(),newEstExpnCreVO.getTmnlCode().substring(0, 5));
						}else{
							if(StringUtils.isEmpty(pendRlaneCd)){
								//2016.03.29 Add.
								String tmpRlaneCd = dbDao.getRevLaneDir(newEstExpnCreVO.getVslCd(), newEstExpnCreVO.getSkdVoyNo(), newEstExpnCreVO.getSkdDirCd(), newEstExpnCreVO.getTmnlCode().substring(0, 5), newEstExpnCreVO.getExeYrmon(), newEstExpnCreVO.getClptIndSeq());
								String aryRevLaneDir[] = tmpRlaneCd.split("\\|", 3);
								strRlaneCd = aryRevLaneDir[0];							
							}else{						
								strRlaneCd = pendRlaneCd;
							}
						}
						insertvo.setRlaneCd		(strRlaneCd);*/
						
						insertvo.setVndrSeq		(vndrSeq);
						
						//INBOUND/OUTBOUND
						PsoTgtYdExpnVO voIn = new PsoTgtYdExpnVO(); 
						voIn.setPsoBztpCd		("2");
						voIn.setVslCd			(insertvo.getVslCd());
						voIn.setSkdVoyNo		(insertvo.getSkdVoyNo());
						voIn.setSkdDirCd		(insertvo.getSkdDirCd());
						voIn.setYdCd			(insertvo.getYdCd());
						voIn.setLgsCostCd		(insertvo.getLgsCostCd());
						voIn.setRevYrmon		(insertvo.getRevYrmon());
						//2015.03.11 NYK Add
						voIn.setExeYrmon		(insertvo.getExeYrmon());
						voIn.setInvLoclAmt		(strLocalAmt);
						voIn.setInvUsdAmt		(strUsdAmt);
						voIn.setLoclCurrCd		(currCd);
						voIn.setCreUsrId		(account.getUsr_id());
						voIn.setUpdUsrId		(account.getUsr_id());
						voIn.setVndrSeq			(vndrSeq);	//[2010.03.08:jmh]
						
						voIn.setPendulumFlg		(pendulumFlg);			//2015.12.29 Add
						voIn.setTurnPortFlg		(turnPortFlg);			//2015.12.29 Add
						voIn.setTurnPortIndCd	(turnPortIndCd);		//2015.12.29 Add
						
						voIn.setActDt			(tmpEtdDt);				//2016.02.11 Add : 환율을 ETD 로 하기 위해서 넘긴다.

						voIn.setClptIndSeq		(insertvo.getClptIndSeq());	//2016.04.26 Double calling port Add
						voIn.setRlaneCd			(insertvo.getRlaneCd());	//2016.07.29 Add
						voIn.setRlaneDirCd		(insertvo.getRlaneDirCd());	//2016.07.29 Add
						
						String ioConditionChk = "";
						if(calcvo != null){
							if(calcvo.existObj(77) || calcvo.existObj(89)){
								voIn.setIbflag("X");
								ioConditionChk = "X";
							}else{
								voIn.setIbflag("");
								ioConditionChk = "M";
							}
						}
			
						//PsoTgtYdExpnVO[] voOuts = command.getPsoTgtYdExpnVO(voIn);
						log.debug("\n createEstTgtVvdByMon getPsoTgtYdExpnVO Method Call In/Out Flag ["+voIn.getIbflag()+"] : X=Obj77, Obj89 exist, null not exist.");
						PsoTgtYdExpnVO[] voOuts = getPsoTgtYdExpnVO(voIn);
						
						
						if(voOuts!=null){
							log.debug("\n createEstTgtVvdByMon PsoTgtYdExpnVO Pendulum Check data start ===================================="+
									  "\n voOutsLen     	["+voOuts.length+"]" +
									  "\n pendulumFlg     	["+pendulumFlg+"]" +
									  "\n pendTurnPortFlg   ["+pendTurnPortFlg+"]" +
									  "\n pendTurnPortIndCd ["+pendTurnPortIndCd+"]" +
									  "\n pendIbBnd    		["+pendIbBnd+"]" +
									  "\n ioConditionChk    ["+ioConditionChk+"]" +
									  "\n pendRlaneCd    	["+pendRlaneCd+"]" +
									  "\n pendRevYrmon    	["+pendRevYrmon+"]" +
									  "\n *turnPortFlg 		["+turnPortFlg+"]" +
									  "\n *turnPortIndCd 	["+turnPortIndCd+"]" +
									  "\n createEstTgtVvdByMon PsoTgtYdExpnVO Pendulum Check data e n d====================================");
							
							if(voOuts[0]!=null){//OutBound
								log.debug("\n createEstTgtVvdByMon OutBound Case ====================================.");
								PsoTgtYdExpnVO voInsert = voOuts[0];
								voInsert.setXprDesc(strDspFomlDesc);
								voInsert.setFomlDesc(strRtFomlDesc);
								voInsert.setActDt(actDt);
								
								voInsert.setYdChgNo(ydChgNo); //2016.07.29 Add
								voInsert.setYdChgVerSeq(ydChgVerSeq);//2016.07.29 Add
								
								if(pendulumFlg.equals("N")){
									
									dbDao.insertTgtYdExpn(voInsert, PsoConstants.BATCH_DATASOURCE);
								
								//}else if(pendulumFlg.equals("Y") && ("O".equals(pendIbBnd) || "B".equals(pendIbBnd) || (voOuts[1] == null && "F".equals(pendTurnPortIndCd)))) {
								}else if(pendulumFlg.equals("Y") && ("O".equals(pendIbBnd) || "B".equals(pendIbBnd) || voOuts[1] == null) || "F".equals(pendTurnPortIndCd)) {
								//}else if(pendulumFlg.equals("Y")) {
									//2015.12.24 Add Pendulum 일대 금액계산을 다시 한다.
									log.debug("\n createEstTgtVvdByMon OutBound pendulumFlag Y & (ibBnd O/B) || voOuts[1]==null ||turnPortIndCd F Case." );
									// 팬드럼 노선일 경우.
									// 기본 : Out Bound 만 처리.
									// 예외 : ibBnd = 'O' 이지만, 마지막 Port 인 경우 (turnPortIndCd= 'F') Inbound로 처리가 되어야 하지만  예외적으로 OutBound 로직으로 처리한다.
									/*
									float outBndLocalAmt = 0;
									float outBndInvUsdAmt = 0;
									log.debug("\n createEstTgtVvdByMon OutBound pendulumFlag Y ioConditionChk [" + ioConditionChk +"]");
									if ("X".equals(ioConditionChk) && voOuts[1] != null){
										// 금액 부분에 메인 계산 로직에서 1/2로 분할해서 계산 되고 있어 XPR_DESC 값에 맞게 환원해 준다.
										// (local amount) * 2
										outBndLocalAmt = Float.parseFloat(voInsert.getInvLoclAmt()) * 2;
										voInsert.setInvLoclAmt(Float.toString(outBndLocalAmt));
										
										if (voInsert.getInvUsdAmt().length() > 0){
											outBndInvUsdAmt = Float.parseFloat(voInsert.getInvUsdAmt()) * 2;
											voInsert.setInvUsdAmt(Float.toString(outBndInvUsdAmt));
										}
									}
									*/
									//voInsert.setRlaneCd(pendRlaneCd);	//2016.03.29 주석처리함(getPsoTgtYdExpnVO 에서 RlaneCd 를 구함). 
									//voInsert.setRevYrmon(pendRevYrmon);
									dbDao.insertTgtYdExpn(voInsert, PsoConstants.BATCH_DATASOURCE);
								}
								
								
							}
							if(voOuts[1]!=null){//InBound
								log.debug("\n createEstTgtVvdByMon InBound Case ====================================.");
								PsoTgtYdExpnVO voInsert = voOuts[1];
								voInsert.setXprDesc(strDspFomlDesc);
								voInsert.setFomlDesc(strRtFomlDesc);
								voInsert.setActDt(actDt);
								
								voInsert.setYdChgNo(ydChgNo); //2016.07.29 Add
								voInsert.setYdChgVerSeq(ydChgVerSeq);//2016.07.29 Add
								
								if(pendulumFlg.equals("N")){
									
									dbDao.insertTgtYdExpn(voInsert, PsoConstants.BATCH_DATASOURCE);
									
								}else if ("Y".equals(pendulumFlg) && ("I".equals(pendIbBnd) || "B".equals(pendIbBnd))) {
								//}else if ("Y".equals(pendulumFlg)) {
									//2015.12.24 Add Pendulum 일대 금액계산을 다시 한다.
									
									log.debug("\n createEstTgtVvdByMon InBound pendulumFlag Y & (ibBnd I/B) Case.");
									
									/*//팬드럼 노선일 경우.
									float inBndLocalAmt = 0;
									float inBndInvUsdAmt = 0;
									
									if ("X".equals(ioConditionChk)){
										// 금액 부분에 메인 계산 로직에서 1/2로 분할해서 계산 되고 있어 XPR_DESC 값에 맞게 환원해 준다.
										// (local amount) * 2
										inBndLocalAmt = Float.parseFloat(voInsert.getInvLoclAmt()) * 2;
										voInsert.setInvLoclAmt(Float.toString(inBndLocalAmt));
										
										if (voInsert.getInvUsdAmt().length() > 0){
											inBndInvUsdAmt = Float.parseFloat(voInsert.getInvUsdAmt()) * 2;
											voInsert.setInvUsdAmt(Float.toString(inBndInvUsdAmt));
										}
									}*/
									
									//voInsert.setRlaneCd(pendRlaneCd);	//2016.03.29 주석처리함(getPsoTgtYdExpnVO 에서 RlaneCd 를 구함). 
									//voInsert.setRevYrmon(pendRevYrmon);
									dbDao.insertTgtYdExpn(voInsert, PsoConstants.BATCH_DATASOURCE);
								}
							}
						}else{
							log.debug("\n createEstTgtVvdByMon voOuts Null Case ====================================.");
							
							insertvo.setXprDesc(strDspFomlDesc);
							insertvo.setFomlDesc(strRtFomlDesc);
							dbDao.insertTgtYdExpn(insertvo, PsoConstants.BATCH_DATASOURCE);
						}
						
						//초기화.
						
						
					}//for end
					log.debug("\n createEstTgtVvdByMon yardChargeVo Loop e n d ====================================");
					
					PsoTgtYdExpnVO glInsertVo = new PsoTgtYdExpnVO();
					glInsertVo.setPsoBztpCd	("2");
					glInsertVo.setVslCd		(newEstExpnCreVO.getVslCd());
					glInsertVo.setSkdVoyNo	(newEstExpnCreVO.getSkdVoyNo());
					glInsertVo.setSkdDirCd	(newEstExpnCreVO.getSkdDirCd());
					glInsertVo.setYdCd		(newEstExpnCreVO.getTmnlCode());
					glInsertVo.setExeYrmon	(newEstExpnCreVO.getExeYrmon());
					glInsertVo.setRevYrmon	(newEstExpnCreVO.getRevYrmon());
					glInsertVo.setCreDt		(account.getUsr_id());
					glInsertVo.setUpdUsrId	(account.getUsr_id());
					glInsertVo.setCreUsrId	(account.getUsr_id());
					glInsertVo.setClptIndSeq(newEstExpnCreVO.getClptIndSeq()); //2016.04.26 Double calling port Add
					
					log.debug("\n createEstTgtVvdByMon insertGlEstmIfErp start ====================================");
					dbDao.insertGlEstmIfErp(glInsertVo);
					log.debug("\n createEstTgtVvdByMon insertGlEstmIfErp e n d ====================================");
					
					log.debug("\n createEstTgtVvdByMon updateGlEstmIfErp start ====================================");
					dbDao.modifyGlEstmIfErp(glInsertVo);
					log.debug("\n createEstTgtVvdByMon updateGlEstmIfErp e n d ====================================");
					
					iLoopCnt++;
				}
			}else{
				log.debug("\n createEstTgtVvdByMon Not Exists Data Delete Case start ====================================");
				//2016.03.31 Pendulum 경우 존재 하지 않을때는 기존에 등록된 데이타를 삭제 처리한다.
				List<PsoTgtYdExpnVO> delList2 = new ArrayList<PsoTgtYdExpnVO>();
				PsoTgtYdExpnVO delVo2 = new PsoTgtYdExpnVO();
				delVo2.setPsoBztpCd	("2");
				delVo2.setVslCd		(estExpnCreVO.getVslCd());
				delVo2.setSkdVoyNo	(estExpnCreVO.getSkdVoyNo());
				delVo2.setSkdDirCd	(estExpnCreVO.getSkdDirCd());
				delVo2.setYdCd		(estExpnCreVO.getTmnlCode());
				delVo2.setExeYrmon	(estExpnCreVO.getExeYrmon());
				delVo2.setRevYrmon	(estExpnCreVO.getRevYrmon());
				delVo2.setClptIndSeq(estExpnCreVO.getClptIndSeq()); //2016.04.26 Double calling port Add
				
				delList2.add(delVo2);
				
				//TO DO 여기 vo 살펴봐야 함...2016.04.26
				if(bTurnFlg){
					PsoTgtYdExpnVO delTurnVo2 = new PsoTgtYdExpnVO();					
					
					delTurnVo2.setPsoBztpCd	("2");
					delTurnVo2.setVslCd		(turnEstExpnCreVO.getVslCd());
					delTurnVo2.setSkdVoyNo	(turnEstExpnCreVO.getSkdVoyNo());
					delTurnVo2.setSkdDirCd	(turnEstExpnCreVO.getSkdDirCd());
					delTurnVo2.setYdCd		(turnEstExpnCreVO.getTmnlCode());
					delTurnVo2.setExeYrmon	(turnEstExpnCreVO.getExeYrmon());
					delTurnVo2.setRevYrmon	(turnEstExpnCreVO.getRevYrmon());
					delTurnVo2.setClptIndSeq(turnEstExpnCreVO.getClptIndSeq());
					
					delList2.add(delTurnVo2);
				}
				for(PsoTgtYdExpnVO deleteVo : delList2){						
					log.debug("\n createEstTgtVvdByMon Delete data start ===================================="+
							  "\n getVslCd     		["+deleteVo.getVslCd()+"]" +
							  "\n getSkdVoyNo     	["+deleteVo.getSkdVoyNo()+"]" +
							  "\n getSkdDirCd     	["+deleteVo.getSkdDirCd()+"]" +
							  "\n getYdCd     		["+deleteVo.getYdCd()+"]" +
							  "\n getClptIndSeq		["+deleteVo.getClptIndSeq()+"]" +
							  "\n getExeYrmon     	["+deleteVo.getExeYrmon()+"]" +
							  "\n getRevYrmon     	["+deleteVo.getRevYrmon()+"]" +
							  "\n createEstTgtVvdByMon Delete data e n d====================================");
					
					log.debug("\n createEstTgtVvdByMon Not Exists Data Delete deleteTgtYdExpn Call.");
					//Delete deleteTgtYdExpn
					dbDao.deleteTgtYdExpn(deleteVo, PsoConstants.BATCH_DATASOURCE);
					
					log.debug("\n createEstTgtVvdByMon Not Exists Data Delete deleteGlEstmIfErp Call.");
					//Delete deleteGlEstmIfErp
					dbDao.deleteGlEstmIfErp(deleteVo);	
				}
				
				log.debug("\n createEstTgtVvdByMon Not Exists Data Delete Case e n d ====================================");
				
			}
			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Expense Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Expense Creation"}).getMessage(),ex);
		}
	}
	
	/**
	 * SameItem existing check in form1 and form2 
	 * 
	 * @param String form1
	 * @param String form2
	 * @param String sameItem
	 * @return
	 */
	private String concatFormula(String form1, String form2, String sameItem){
		
		String itemDesc = "";
		String itemDesc1 = "";
		String itemDesc2 = "";
		
		String itemDesc1Pre = "";
		String itemDesc1Post = "";
		
		int itemIdx1 = 0;
		int itemIdx2 = 0; 
		

		itemIdx1 = form1.indexOf(sameItem);
		if(itemIdx1>-1){
			itemDesc1Pre = form1.substring(0, itemIdx1);
			if(form1.indexOf("\n", itemIdx1)>-1){
				itemDesc1 = form1.substring(itemIdx1+sameItem.length(), form1.indexOf("\n", itemIdx1)).trim();
				itemDesc1Post = form1.substring(form1.indexOf("\n", itemIdx1));
			}else{
				itemDesc1 = form1.substring(itemIdx1+sameItem.length()).trim();
			}
		}else{
			itemDesc1Pre = form1;
		}
		

		itemIdx2 = form2.indexOf(sameItem);
		
		if(itemIdx2>-1){
			if(form2.indexOf("\n", itemIdx2)>-1){
				itemDesc2 = form2.substring(itemIdx2+sameItem.length(), form2.indexOf("\n", itemIdx2)).trim();
			}else{
				itemDesc2 = form2.substring(itemIdx2+sameItem.length()).trim();
			}
			
		}
		
	
		if(itemDesc1.length()>0 && itemDesc2.length()>0){
			itemDesc = itemDesc1 + " + " + itemDesc2;
		}else{
			itemDesc = itemDesc1 + itemDesc2;
		}
		

		if(itemDesc.length()>0){
			itemDesc = sameItem + itemDesc;
		}
		

		return itemDesc1Pre + itemDesc + itemDesc1Post;
	}


	/**
	 * VopPsoB0003.java Estimate Creation I/O Bound info getting handling
	 * 2016.03.29 REV_LANE 정보를 IN/OUT VO에 구해서 넣도록 로직 추가함.
	 * @param PsoTgtYdExpnVO voIn
	 * @return PsoTgtYdExpnVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unused")
	public PsoTgtYdExpnVO[] getPsoTgtYdExpnVO(PsoTgtYdExpnVO voIn)  throws EventException {
		
		PsoTgtYdExpnVO[] retVo = new PsoTgtYdExpnVO[2];
		
		PsoTgtYdExpnVO voInBnd = null;
		PsoTgtYdExpnVO voOutBnd = null;
		
		String flg = voIn.getIbflag();
		log.debug("\n ========================== getPsoTgtYdExpnVO Param Data Start."
				 	+" \n flg			["+flg+"]"
				 	+" \n pendulumFlag	["+voIn.getPendulumFlg()+"]"
				 	+" \n YdCd 			["+voIn.getYdCd()+"]"
				 	+" \n exeYrmon 		["+voIn.getExeYrmon()+"]"
				 	+" \n revYrmon 		["+voIn.getRevYrmon()+"]"
				 	+" \n ClptIndSeq	["+voIn.getClptIndSeq()+"]"
				 	+" \n rlaneCd	    ["+voIn.getRlaneCd()+"]"
				 	+" \n rlaneDirCd    ["+voIn.getRlaneDirCd()+"]"
				 	+" \n VVD  	    	["+(voIn.getVslCd() + voIn.getSkdVoyNo() + voIn.getSkdDirCd())+"]"
				 	+" \n ========================== getPsoTgtYdExpnVO Param Data E n d.");
		
		if("Y".equals(flg)){ 
			flg = "B";
		}
		
		try {
			//2015.03.20 NYK Canal 구분없이 기존 Port 로 진행하도록 주석처리.
				log.debug("\n========================== getPsoTgtYdExpnVO Case.");
				InvAuditDataValidVO vo = new InvAuditDataValidVO();
				vo.setVslCd		(voIn.getVslCd());
				vo.setSkdVoyNo	(voIn.getSkdVoyNo());
				vo.setSkdDirCd	(voIn.getSkdDirCd());
				vo.setYdCd		(voIn.getYdCd());
				vo.setRevYrmon	(voIn.getRevYrmon());
				//2015.03.11 NYK Add
				vo.setExeYrmon	(voIn.getExeYrmon());
				vo.setClptIndSeq(voIn.getClptIndSeq()); //2016.04.26 Double calling port Add
				

				String tmpEtdDt = voIn.getActDt(); //2016.02.11 Add 환율 계산은 ETD 로 한다.
				
				// Budget / Estimate... 
				if(flg != null){
					if("B".equals(flg)){//Batch Budget
						vo.setOrgFlg("B");
						vo.setBudScnrNo(voIn.getPagerows());
					}else if("M".equals(flg)){//--> Monthly Estimate Batch 
						vo.setOrgFlg("M");
					}else if("X".equals(flg)){//--> Monthly Estimate Batch 
						vo.setOrgFlg("M");
					}else {
						vo.setOrgFlg("E");
					}
				}else{
					vo.setOrgFlg("E");
				}
				
				vo.setRlaneCd(voIn.getRlaneCd());
				
				//2015.12.22 Pendulum 여부를 판단한다.
				//log.debug("\n========================== getPsoTgtYdExpnVO Canal Not In Case getPendulumInfo Call.");
				//String pendFlg = dbDao.getPendulumInfo(vo);
				String pendulumFlg = voIn.getPendulumFlg();
				pendulumFlg = StringUtils.isEmpty(pendulumFlg) ? "N" : pendulumFlg;
				vo.setPendFlg(pendulumFlg);
				log.debug("\n========================== getPsoTgtYdExpnVO Case getPendulumInfo pendulumFlg ["+pendulumFlg+"].");
				
				//2016.07.26 Pendulum IoRation를 구분해서 구한다.
				List<IoRatioVO> rList = null;
				if(pendulumFlg.equals("Y")){
					log.debug("\n========================== getPsoTgtYdExpnVO Case pendulumFlg ["+pendulumFlg+"] >> getIoRatioForPendulum Call start.");
					rList = dbDao.getIoRatioForPendulum(vo);
				}else{
					log.debug("\n========================== getPsoTgtYdExpnVO Case pendulumFlg ["+pendulumFlg+"] >> getIoRatio Call start.");
					rList = dbDao.getIoRatio(vo);
				}
				
				if(rList != null){
					if(rList.size() == 0){//OutBound 100%
						log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [0 Row Record] [ OutBound 100% ].");
						voOutBnd = new PsoTgtYdExpnVO();
						voOutBnd.setPsoBztpCd(voIn.getPsoBztpCd());
						voOutBnd.setVslCd(voIn.getVslCd());
						voOutBnd.setSkdVoyNo(voIn.getSkdVoyNo());
						voOutBnd.setSkdDirCd(voIn.getSkdDirCd());
						voOutBnd.setYdCd(voIn.getYdCd());
						voOutBnd.setLgsCostCd(voIn.getLgsCostCd());
						voOutBnd.setRevYrmon(voIn.getRevYrmon());
						voOutBnd.setInvLoclAmt(voIn.getInvLoclAmt());
						voOutBnd.setInvUsdAmt(voIn.getInvUsdAmt());
						voOutBnd.setIoBndCd("O");
						voOutBnd.setLoclCurrCd(voIn.getLoclCurrCd());
						voOutBnd.setVndrSeq(voIn.getVndrSeq());	
						
						voOutBnd.setClptIndSeq(voIn.getClptIndSeq());//2016.04.26 Double calling port Add
						voOutBnd.setRlaneDirCd(voIn.getRlaneDirCd());//2016.07.29 Add
						voOutBnd.setRlaneCd(voIn.getRlaneCd());//2016.07.29 Add
	
						RoundTruncVO rtvo1in = new RoundTruncVO();
						rtvo1in.setIoBndCd("O");
						rtvo1in.setRatio("100");
						rtvo1in.setCurrCd(voIn.getLoclCurrCd());
						rtvo1in.setLoclAmt(voIn.getInvLoclAmt());
						
						RoundTruncVO rtvo1out = dbDao.getRoundTruncAmt(rtvo1in);
						
						voOutBnd.setInvLoclAmt(rtvo1out.getLoclAmt());
						//<------------------
						String usdAmt = "";
						if(flg != null){
							if(flg.equals("B")){//Batch Budget
								usdAmt = dbDao.getUsdAmtBudget(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
							}else{
								usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt
							}
						}else{
							usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1"); //voIn.getRevYrmon() > tmpEtdDt
						}
						//usdAmt = "|2";
						String usdAmts[] = usdAmt.split("\\|", 2);
						if(usdAmts.length>=2){
							if(usdAmts[0].equals("")){
								voOutBnd.setInvUsdAmt(usdAmts[1]);
							}else{
								voOutBnd.setInvUsdAmt(usdAmts[0]);
							}
						}
						//[2015.06.02] PSO_GET_REV_LANE_FNC('NCNA', '0042', 'E','USNYC') ROWNUM = 1 호출함.
						//String strRlaneCd = dbDao.getRlaneCd( voIn.getVslCd(), voIn.getSkdVoyNo(), voIn.getSkdDirCd(), voIn.getYdCd().substring(0, 5));
	
						//2016.03.29 Add.2016.07.29 Add
						String tmpNewRlaneCd = "";
						String tmpNewRlaneDirCd = "";
						if(StringUtils.isEmpty(voOutBnd.getRlaneCd()) || StringUtils.isEmpty(voOutBnd.getRlaneDirCd())){
							//미존재시 다시 구한다.
							//2016.03.29 Add.2016.07.29 Add
							String tmpRlaneCd = dbDao.getRevLaneDir(voIn.getVslCd(), voIn.getSkdVoyNo(), voIn.getSkdDirCd(), voIn.getYdCd(), voIn.getExeYrmon(), voIn.getClptIndSeq());
							String aryRevLaneDir[] = tmpRlaneCd.split("\\|", 3);
								
							tmpNewRlaneCd = StringUtils.isEmpty(voIn.getRlaneCd()) ? aryRevLaneDir[0] : voIn.getRlaneCd();
							tmpNewRlaneDirCd = StringUtils.isEmpty(voIn.getRlaneDirCd()) ? aryRevLaneDir[1] : voIn.getRlaneDirCd();
															
							voOutBnd.setRlaneCd(tmpNewRlaneCd);
							voOutBnd.setRlaneDirCd(tmpNewRlaneDirCd);
						}
						log.debug("\n [0 Row Record] RLANE_CD     PARAM ["+voIn.getRlaneCd()+"]     NEW ["+tmpNewRlaneCd+"]    LAST ["+voOutBnd.getRlaneCd()+"]."
								 +"\n [0 Row Record] RLANE_DIR_CD PARAM ["+voIn.getRlaneDirCd()+"]  NEW ["+tmpNewRlaneDirCd+"] LAST ["+voOutBnd.getRlaneDirCd()+"].");
					}
					else if(rList.size() == 2){//in out bound 2 record insert 
						log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [2 Row Record] [ in out bound 2 record insert  ].");
						voInBnd = new PsoTgtYdExpnVO();
						voOutBnd = new PsoTgtYdExpnVO();
						IoRatioVO rvo1 = rList.get(0);
						IoRatioVO rvo2 = rList.get(1);
						voOutBnd.setPsoBztpCd(voIn.getPsoBztpCd());
						voOutBnd.setVslCd(rvo1.getVslCd()); 
						voOutBnd.setSkdVoyNo(rvo1.getSkdVoyNo());
						voOutBnd.setSkdDirCd(rvo1.getSkdDirCd());
						
						log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [2 Row Record] rvo1.getRevYrmon()["+rvo1.getRevYrmon()+"] voIn.getRevYrmon() ["+voIn.getRevYrmon()+"].");
						//voOutBnd.setRevYrmon(rvo1.getRevYrmon());  //2016.03.30 원복함.
						String tmpRevYrmon = StringUtils.isEmpty(rvo1.getRevYrmon()) ? voIn.getRevYrmon() : rvo1.getRevYrmon();
						voOutBnd.setRevYrmon(tmpRevYrmon);  //2016.07.29 Add
						//voOutBnd.setRevYrmon(voIn.getRevYrmon()); //2016.03.29 Add Max로 맞추기 위한 값.
						voOutBnd.setYdCd(voIn.getYdCd());
						voOutBnd.setLgsCostCd(voIn.getLgsCostCd());
						voOutBnd.setInvLoclAmt(voIn.getInvLoclAmt());
						voOutBnd.setInvUsdAmt(voIn.getInvUsdAmt());
						voOutBnd.setRlaneCd(rvo1.getRlaneCd());
						voOutBnd.setVndrSeq(voIn.getVndrSeq());	
						
						voOutBnd.setClptIndSeq(voIn.getClptIndSeq());//2016.04.26 Double calling port Add
						voOutBnd.setRlaneDirCd(rvo1.getRlaneDirCd());//2016.07.29 Add
						
						voOutBnd.setIoBndCd("O");
						voOutBnd.setLoclCurrCd(voIn.getLoclCurrCd());
						
						RoundTruncVO rtvo1in = new RoundTruncVO();
						rtvo1in.setIoBndCd("O");
						rtvo1in.setRatio(rvo1.getObRto());
						rtvo1in.setCurrCd(voIn.getLoclCurrCd());
						rtvo1in.setLoclAmt(voIn.getInvLoclAmt());
						
						if(StringUtils.isEmpty(rtvo1in.getRatio())) rtvo1in.setRatio("50");
						
						RoundTruncVO rtvo1out = dbDao.getRoundTruncAmt(rtvo1in);
						
						voOutBnd.setInvLoclAmt(rtvo1out.getLoclAmt());
						//vo1.setUsdAmt("");
						String usdAmt = "";
						if(flg != null){
							if(flg.equals("B")){//Batch Budget
								usdAmt = dbDao.getUsdAmtBudget(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
							}else{
								usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt
							}
						}else{
							usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt
						}
						String usdAmts[] = usdAmt.split("\\|", 2);
						if(usdAmts.length>=2){
							if(usdAmts[0].equals("")){
								voOutBnd.setInvUsdAmt(usdAmts[1]);
							}else{
								voOutBnd.setInvUsdAmt(usdAmts[0]);
							}
						}
						
						//from here InBnd
						voInBnd.setPsoBztpCd(voIn.getPsoBztpCd());
						voInBnd.setVslCd(rvo2.getVslCd());
						voInBnd.setSkdVoyNo(rvo2.getSkdVoyNo());
						voInBnd.setSkdDirCd(rvo2.getSkdDirCd());
						//voInBnd.setRevYrmon(rvo2.getRevYrmon());
						//voInBnd.setRevYrmon(voIn.getRevYrmon()); //2016.03.29 Add Max로 맞추기 위한 값.
						log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [2 Row Record] rvo2.getRevYrmon()["+rvo2.getRevYrmon()+"] voIn.getRevYrmon() ["+voIn.getRevYrmon()+"].");
						String tmpRevYrmon2 = StringUtils.isEmpty(rvo2.getRevYrmon()) ? voIn.getRevYrmon() : rvo2.getRevYrmon();
						voInBnd.setRevYrmon(tmpRevYrmon2);  //2016.07.29 Add
						
						voInBnd.setYdCd(voIn.getYdCd());
						voInBnd.setLgsCostCd(voIn.getLgsCostCd());
						voInBnd.setInvLoclAmt(voIn.getInvLoclAmt());
						voInBnd.setInvUsdAmt(voIn.getInvUsdAmt());
						voInBnd.setRlaneCd(rvo2.getRlaneCd());
						voInBnd.setIoBndCd("I");
						voInBnd.setLoclCurrCd(voIn.getLoclCurrCd());
						voInBnd.setVndrSeq(voIn.getVndrSeq());	
						
						voInBnd.setClptIndSeq(voIn.getClptIndSeq());//2016.04.26 Double calling port Add
						voInBnd.setRlaneDirCd(rvo2.getRlaneDirCd());//2016.07.29 Add
						
						RoundTruncVO rtvo2in = new RoundTruncVO();
						rtvo2in.setIoBndCd("I");
						rtvo2in.setRatio(rvo2.getIbRto());
						rtvo2in.setCurrCd(voIn.getLoclCurrCd());
						rtvo2in.setLoclAmt(voIn.getInvLoclAmt());
	
						if(StringUtils.isEmpty(rtvo2in.getRatio())) rtvo2in.setRatio("50");
						
						RoundTruncVO rtvo2out = dbDao.getRoundTruncAmt(rtvo2in);
						
						voInBnd.setInvLoclAmt(rtvo2out.getLoclAmt());
						//vo1.setUsdAmt("");
						String usdAmt2 = "";
						if(flg != null){
							if(flg.equals("B")){//Batch Budget
								usdAmt2 = dbDao.getUsdAmtBudget(rtvo2out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
							}else{
								usdAmt2 = dbDao.getUsdAmt(rtvo2out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt
							}
						}else{
							usdAmt2 = dbDao.getUsdAmt(rtvo2out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt
						}
						String usdAmts2[] = usdAmt2.split("\\|", 2);
						if(usdAmts2.length>=2){
							if(usdAmts[0].equals("")){
								voInBnd.setInvUsdAmt(usdAmts2[1]);
							}else{
								voInBnd.setInvUsdAmt(usdAmts2[0]);
							}
						}
						log.debug("\n [2 Row Record] RLANE_CD     NEW [N/A]  IN ["+rvo2.getRlaneCd()+"]    OUT ["+rvo1.getRlaneCd()+"]    LAST IN ["+voInBnd.getRlaneCd()+"]    LAST OUT ["+voOutBnd.getRlaneCd()+"]."
								 +"\n [2 Row Record] RLANE_DIR_CD NEW [N/A]  IN ["+rvo2.getRlaneDirCd()+"] OUT ["+rvo1.getRlaneDirCd()+"] LAST IN ["+voInBnd.getRlaneDirCd()+"] LAST OUT ["+voOutBnd.getRlaneDirCd()+"].");
					}//end of else if 
					else{
						log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [1 Row Record] [ OUT BOUND 100% ].");
						IoRatioVO rvo1 = rList.get(0);
						//OUT BOUND 100%
						voOutBnd = new PsoTgtYdExpnVO();
						voOutBnd.setPsoBztpCd(voIn.getPsoBztpCd());
						voOutBnd.setVslCd(rvo1.getVslCd());
						voOutBnd.setSkdVoyNo(rvo1.getSkdVoyNo());
						voOutBnd.setSkdDirCd(rvo1.getSkdDirCd());
						
						//voOutBnd.setRevYrmon(rvo1.getRevYrmon());
						//voOutBnd.setRevYrmon(voIn.getRevYrmon()); //2016.03.29 Add Max로 맞추기 위한 값.
						log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [1 Row Record] rvo2.getRevYrmon()["+rvo1.getRevYrmon()+"] voIn.getRevYrmon() ["+voIn.getRevYrmon()+"].");
						String tmpRevYrmon = StringUtils.isEmpty(rvo1.getRevYrmon()) ? voIn.getRevYrmon() : rvo1.getRevYrmon();
						voOutBnd.setRevYrmon(tmpRevYrmon);  //2016.07.29 Add
						
						voOutBnd.setYdCd(voIn.getYdCd());
						voOutBnd.setLgsCostCd(voIn.getLgsCostCd());
						voOutBnd.setInvLoclAmt(voIn.getInvLoclAmt());
						voOutBnd.setInvUsdAmt(voIn.getInvUsdAmt());
						//voOutBnd.setIoBndCd("O");
						voOutBnd.setLoclCurrCd(voIn.getLoclCurrCd());
						voOutBnd.setVndrSeq(voIn.getVndrSeq());	
						
						voOutBnd.setClptIndSeq(voIn.getClptIndSeq());//2016.04.26 Double calling port Add
						voOutBnd.setRlaneCd(rvo1.getRlaneCd());//2016.07.29 Add
						voOutBnd.setRlaneDirCd(rvo1.getRlaneDirCd());//2016.07.29 Add
	
						RoundTruncVO rtvo1in = new RoundTruncVO();
						
						//flg : 화면에서 넘어오면 - 77,89 일때 X 값으로 넘어옴.
						String pendTurnPortFlg = voIn.getTurnPortFlg();
						String pendTurnPortIndCd = voIn.getTurnPortIndCd();
												
						if(pendulumFlg.equals("N")){
							log.debug("\n=========================="+
						              "\n getPsoTgtYdExpnVO Case getIoRatio [1 Row Record] Normal Ratio start."+
						              "\n Before flg   ["+flg+"]"+
									  "\n Before IbRto ["+rvo1.getIbRto()+"]"+
									  "\n Before ObRto ["+rvo1.getObRto()+"]"+
									  "\n==========================");
							if(!rvo1.getIbRto().equals("0")){//-->2009.12.15 added
								log.debug("\n==========================Inbound getIoRatio In Case==========================");
								voOutBnd.setIoBndCd("I");
								rtvo1in.setIoBndCd("I");							
								if(flg != null){
									if(flg.equals("X") || flg.equals("Y")){
										rtvo1in.setRatio("100");
									}else{
										rtvo1in.setRatio(rvo1.getIbRto());
									}
								}else{
									rtvo1in.setRatio(rvo1.getIbRto());
								}
							}else{
								log.debug("\n==========================Outbound getIoRatio OUt Case==========================");
								voOutBnd.setIoBndCd("O");
								rtvo1in.setIoBndCd("O");							
								if(flg != null){
									if("X".equals(flg) || "Y".equals(flg)){
										rtvo1in.setRatio("100");
									}else{
										rtvo1in.setRatio(rvo1.getObRto());
									}
								}else{
									rtvo1in.setRatio(rvo1.getObRto());
								}
							}
							log.debug("\n=========================="+
									  "\n getPsoTgtYdExpnVO Case getIoRatio [1 Row Record] Normal Ratio e n d."+
						              "\n After flg   	["+flg+"]"+
									  "\n After IoBndCd ["+rtvo1in.getIoBndCd()+"]"+
									  "\n After Ratio 	["+rtvo1in.getRatio()+"]"+
									  "\n==========================");
						}else{
							log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [1 Row Record] Pendulum Ratio start.");
							//Pendulum Lane 일때.
							//SKD Normal port && Pendulum lane 이면 넘어온 금액 그대로 적용 한다.
							if(pendTurnPortFlg.equals("N") && pendTurnPortIndCd.equals("N")){
								
								voOutBnd.setIoBndCd("O");
								rtvo1in.setIoBndCd("O");
								rtvo1in.setRatio("100");
								log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [1 Row Record] Pendulum N/N "+
										"\n pendTurnPortFlg["+pendTurnPortFlg+"] "+
										"\n pendTurnPortIndCd["+pendTurnPortIndCd+"] "+
										"\n Ration["+rtvo1in.getRatio()+"]");
							}else{
								//Normal 조건과 동일하게 처리한다.
								if(!rvo1.getIbRto().equals("0")){//-->2009.12.15 added
									voOutBnd.setIoBndCd("I");
									rtvo1in.setIoBndCd("I");							
									if(flg != null){
										// X ==> IN/OUT 이 있는 Tariff, Y ==> Budget
										if(flg.equals("X") || "Y".equals(flg)){
											rtvo1in.setRatio("100");
										}else{
											rtvo1in.setRatio(rvo1.getIbRto());
										}
									}else{
										rtvo1in.setRatio(rvo1.getIbRto());
									}
									//rtvo1in.setRatio(rvo1.getIbRto());
								}else{
									voOutBnd.setIoBndCd("O");
									rtvo1in.setIoBndCd("O");							
									if(flg != null){
										// X ==> IN/OUT 이 있는 Tariff, Y ==> Budget
										if("X".equals(flg) || "Y".equals(flg)){
											rtvo1in.setRatio("100");
										}else{
											rtvo1in.setRatio(rvo1.getObRto());
										}
									}else{
										rtvo1in.setRatio(rvo1.getObRto());
									}
									//rtvo1in.setRatio(rvo1.getObRto());
								}
								
								if(rtvo1in.getRatio().equals("0")) rtvo1in.setRatio("100");

								log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [1 Row Record] Pendulum N/N not"+
										"\n pendTurnPortFlg["+pendTurnPortFlg+"] "+
										"\n pendTurnPortIndCd["+pendTurnPortIndCd+"] "+
										"\n Ration["+rtvo1in.getRatio()+"]");
							}	
							
							log.debug("\n========================== getPsoTgtYdExpnVO Case getIoRatio [1 Row Record] Pendulum Ratio e n d.");
						}
						rtvo1in.setCurrCd(voIn.getLoclCurrCd());
						rtvo1in.setLoclAmt(voIn.getInvLoclAmt());
						
						RoundTruncVO rtvo1out = dbDao.getRoundTruncAmt(rtvo1in);
						
						voOutBnd.setInvLoclAmt(rtvo1out.getLoclAmt());
						//<------------------
						String usdAmt = "";
						if(flg != null){
							if(flg.equals("B")){//Batch Budget
								usdAmt = dbDao.getUsdAmtBudget(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
							}else{
								usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt
							}
						}else{
							usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt
						}
						//usdAmt = "|2";
						String usdAmts[] = usdAmt.split("\\|", 2);
						if(usdAmts.length>=2){
							if(usdAmts[0].equals("")){
								voOutBnd.setInvUsdAmt(usdAmts[1]);
							}else{
								voOutBnd.setInvUsdAmt(usdAmts[0]);
							}
						}

						String tmpNewRlaneCd = "";
						String tmpNewRlaneDirCd = "";
						//rvo1 IoRatio 에서 Rlane_cd 가 존재 하면 그대로 사용. 없을때만 다시 구한 Rlane Cd를 넣는다.
						if(StringUtils.isEmpty(voOutBnd.getRlaneCd()) || StringUtils.isEmpty(voOutBnd.getRlaneDirCd())){
							//넘어온 Param에 존재 하면 해다 데이타로 셋팅 한다.
							if(!StringUtils.isEmpty(voIn.getRlaneCd()) && StringUtils.isEmpty(voIn.getRlaneDirCd())){
								voOutBnd.setRlaneCd(voIn.getRlaneCd());
								voOutBnd.setRlaneDirCd(voIn.getRlaneDirCd());
							}else{
								//미존재시 다시 구한다.
								//2016.03.29 Add.2016.07.29 Add
								String tmpRlaneCd = dbDao.getRevLaneDir(voIn.getVslCd(), voIn.getSkdVoyNo(), voIn.getSkdDirCd(), voIn.getYdCd(), voIn.getExeYrmon(), voIn.getClptIndSeq());
								String aryRevLaneDir[] = tmpRlaneCd.split("\\|", 3);
									
								tmpNewRlaneCd = StringUtils.isEmpty(voIn.getRlaneCd()) ? aryRevLaneDir[0] : voIn.getRlaneCd();
								tmpNewRlaneDirCd = StringUtils.isEmpty(voIn.getRlaneDirCd()) ? aryRevLaneDir[1] : voIn.getRlaneDirCd();
																
								voOutBnd.setRlaneCd(tmpNewRlaneCd);
								voOutBnd.setRlaneDirCd(tmpNewRlaneDirCd);
								
							}
						}
						log.debug("\n [1 Row Record] RLANE_CD     PARAM ["+voIn.getRlaneCd()+"]     NEW ["+tmpNewRlaneCd+"]    OUT ["+rvo1.getRlaneCd()+"]    LAST ["+voOutBnd.getRlaneCd()+"]."
								 +"\n [1 Row Record] RLANE_DIR_CD PARAM ["+voIn.getRlaneDirCd()+"]  NEW ["+tmpNewRlaneDirCd+"] OUT ["+rvo1.getRlaneDirCd()+"] LAST ["+voOutBnd.getRlaneDirCd()+"].");
											
					}
	//						Logger.debug("IORatio List Size:="+rList.size()+"");
				}//end of if(rList != null) 
				else{//OUT BOUND 100%
					log.debug("\n========================== getPsoTgtYdExpnVO Canal Not In Case getIoRatio Null [ OUT BOUND 100% ].");
					voOutBnd = new PsoTgtYdExpnVO();
					voOutBnd.setPsoBztpCd(voIn.getPsoBztpCd());
					voOutBnd.setVslCd(voIn.getVslCd());
					voOutBnd.setSkdVoyNo(voIn.getSkdVoyNo());
					voOutBnd.setSkdDirCd(voIn.getSkdDirCd());
					voOutBnd.setYdCd(voIn.getYdCd());
					voOutBnd.setLgsCostCd(voIn.getLgsCostCd());
					voOutBnd.setRevYrmon(voIn.getRevYrmon()); //2016.03.29 Add Max로 맞추기 위한 값.
					voOutBnd.setInvLoclAmt(voIn.getInvLoclAmt());
					voOutBnd.setInvUsdAmt(voIn.getInvUsdAmt());
					voOutBnd.setIoBndCd("O");
					voOutBnd.setLoclCurrCd(voIn.getLoclCurrCd());
					voOutBnd.setVndrSeq(voIn.getVndrSeq());	
					
					voOutBnd.setClptIndSeq(voIn.getClptIndSeq());//2016.04.26 Double calling port Add
					voOutBnd.setRlaneCd(voIn.getRlaneCd());//2016.07.29 Add
					voOutBnd.setRlaneDirCd(voIn.getRlaneDirCd());//2016.07.29 Add
					
					RoundTruncVO rtvo1in = new RoundTruncVO();
					rtvo1in.setIoBndCd("O");
					rtvo1in.setRatio("100");
					rtvo1in.setCurrCd(voIn.getLoclCurrCd());
					rtvo1in.setLoclAmt(voIn.getInvLoclAmt());
					
					RoundTruncVO rtvo1out = dbDao.getRoundTruncAmt(rtvo1in);
					
					voOutBnd.setInvLoclAmt(rtvo1out.getLoclAmt());
					//<------------------
					String usdAmt = "";
					if(flg != null){
						if(flg.equals("B"))//Batch Budget
							usdAmt = dbDao.getUsdAmtBudget(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
						else
							usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt
					}
					else
						usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), tmpEtdDt, "1");//voIn.getRevYrmon() > tmpEtdDt

					String usdAmts[] = usdAmt.split("\\|", 2);
					if(usdAmts.length>=2){
						if(usdAmts[0].equals("")){
							voOutBnd.setInvUsdAmt(usdAmts[1]);
						}
						else{
							voOutBnd.setInvUsdAmt(usdAmts[0]);
						}
					}
					//[2015.06.02] PSO_GET_REV_LANE_FNC('NCNA', '0042', 'E','USNYC') ROWNUM = 1 호출함.
					//String strRlaneCd = dbDao.getRlaneCd(voIn.getVslCd(), voIn.getSkdVoyNo(), voIn.getSkdDirCd(), voIn.getYdCd().substring(0, 5));

					//2016.03.29 Add.
					//2016.03.29 Add.2016.07.29 Add
					String tmpNewRlaneCd = "";
					String tmpNewRlaneDirCd = "";
					if(StringUtils.isEmpty(voOutBnd.getRlaneCd()) || StringUtils.isEmpty(voOutBnd.getRlaneDirCd())){
						//미존재시 다시 구한다.
						//2016.03.29 Add.2016.07.29 Add
						String tmpRlaneCd = dbDao.getRevLaneDir(voIn.getVslCd(), voIn.getSkdVoyNo(), voIn.getSkdDirCd(), voIn.getYdCd(), voIn.getExeYrmon(), voIn.getClptIndSeq());
						String aryRevLaneDir[] = tmpRlaneCd.split("\\|", 3);
							
						tmpNewRlaneCd = StringUtils.isEmpty(voIn.getRlaneCd()) ? aryRevLaneDir[0] : voIn.getRlaneCd();
						tmpNewRlaneDirCd = StringUtils.isEmpty(voIn.getRlaneDirCd()) ? aryRevLaneDir[1] : voIn.getRlaneDirCd();
														
						voOutBnd.setRlaneCd(tmpNewRlaneCd);
						voOutBnd.setRlaneDirCd(tmpNewRlaneDirCd);
					}
					log.debug("\n [[no data Record]] RLANE_CD     PARAM ["+voIn.getRlaneCd()+"]     NEW ["+tmpNewRlaneCd+"]    LAST ["+voOutBnd.getRlaneCd()+"]."
							 +"\n [[no data Record]] RLANE_DIR_CD PARAM ["+voIn.getRlaneDirCd()+"]  NEW ["+tmpNewRlaneDirCd+"] LAST ["+voOutBnd.getRlaneDirCd()+"].");
					
				}
			//}//end of else 
			
			if(voOutBnd != null){
				voOutBnd.setCreUsrId(voIn.getCreUsrId());
				voOutBnd.setUpdUsrId(voIn.getUpdUsrId());
				retVo[0] = voOutBnd;
			}else{
				retVo[0] = null;
			}
			if(voInBnd != null){
				voInBnd.setCreUsrId(voIn.getCreUsrId());
				voInBnd.setUpdUsrId(voIn.getUpdUsrId());
				retVo[1] = voInBnd;
			}else{
				retVo[1] = null;
			}
			
			log.debug("\n===========getPsoTgtYdExpnVO e n d==================="+
			          "\nretVo Len ["+retVo.length+"]"+
					  "\n===========getPsoTgtYdExpnVO e n d===================");
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Estimate Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Estimate Creation"}).getUserMessage(),ex);
		}
		return retVo;
	}
	/**
	 * Create Estimate Expense monthly
	 * @category VOP_PSO_0009_estimateCreationButtonClick
	 * @param String yyyymm
	 * @param String lanecd
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createEstExpnByMon(String yyyymm, String lanecd, String userId) throws EventException {
		
		ScheduleUtil su = new ScheduleUtil();
		boolean bIsRunning;
		try {
			bIsRunning = su.isRunning("VOP_PSO_B003");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Creation"}).getUserMessage(),e);
		}
		log.debug("\ncreateEstExpnByMon bIsRunning>> " + bIsRunning);
		if(bIsRunning)
			return "6";
		else{
			//VOP_PSO_B003 no-use-data#2009-06#PSOTEST#FEX
			try {
				su.directExecuteJob("VOP_PSO_B003", "no-use-data"+"#"+yyyymm+"#"+userId+"#"+lanecd+"#1");
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Creation"}).getUserMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Creation"}).getUserMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Creation"}).getUserMessage(),e);
			}
			return "4";
		}
	}

	/**
	 * Create business plan by year
	 * @category VOP_PSO_0008_creationButtonClick
	 * @param String startDt
	 * @param String endDt
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String generateYearBudgetPlan(String startDt, String endDt,  String userId) throws EventException {
		ScheduleUtil su = new ScheduleUtil();

		boolean bIsRunning = false;
		try {
			bIsRunning = su.isRunning("VOP_PSO_B002");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getMessage(),e);
		}
		
		if(bIsRunning)
			return "6";
		else{
			try {
				//VOP_PSO_B002 no-use-data#2010-01#2010-01#PSOTEST#C
				su.directExecuteJob("VOP_PSO_B002","no-use-data"+"#"+startDt+"#"+endDt+"#"+userId+"#"+"C");
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getMessage(),e);
			}
			return "4";
		}
	}

	/**
	 * Retrieve Expense Plan (Pop-Up) by VVD
	 * @category VOP_PSO_0201_windowOpen
	 * @param BudEstDtlCondVO budEstDtlCondVO
	 * @return List<BudEstSumByMonVO>
	 * @exception EventException
	 */
	public List<BudEstSumByMonVO> searchBudEstDtlByMonCost(BudEstDtlCondVO budEstDtlCondVO) throws EventException {
		try {
			return dbDao.searchBudEstDtlByMonCost(budEstDtlCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Expense Plan Per VVD"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Expense Plan Per VVD"}).getUserMessage(),ex);
		}
	}

	/**
	 * Recreate Budget Info by VVD chosen from main list <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param PortChgBudByYearVO[] portChgBudByYearVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	public void createBudget(PortChgBudByYearVO[] portChgBudByYearVOs,SignOnUserAccount account)throws EventException{
		GeneralInvoiceAuditBC generalInvoiceAuditBCImpl = new GeneralInvoiceAuditBCImpl();//2-phase commit
		CalcTariffVO calcTariffVO = new CalcTariffVO();
		for(int i=0; i<portChgBudByYearVOs.length;i++){
			PortChgBudByYearVO vo = portChgBudByYearVOs[i];
			List<PsoYdChgVO> list = null;
			
			//delete first
			PsoTgtYdExpnVO delVO = new PsoTgtYdExpnVO();
			delVO.setPsoBztpCd("1");
			delVO.setVslCd(vo.getVslCd());
			delVO.setSkdVoyNo(vo.getSkdVoyNo());
			delVO.setSkdDirCd(vo.getSkdDirCd());
			delVO.setRevYrmon(vo.getExpnYrmon());
			try {
				dbDao.deleteTgtYdExpn(delVO,"BAT");
			} catch (DAOException ex) {
	 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation : deleteTgtYdExpn"}).getMessage(),ex);
	 		} catch (Exception ex) {
	 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation : deleteTgtYdExpn"}).getMessage(),ex);
	 		}   
			

	        try {
	 			list = dbDao.searchYardChargeByVvd(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), vo.getExpnYrmon());
	 		} catch (DAOException ex) {
	 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation"}).getMessage(),ex);
	 		} catch (Exception ex) {
	 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation"}).getMessage(),ex);
	 		}    
//	 		String prvYdCd = "";
	 		if(list != null){
	 			for(int j=0;j<list.size();j++){
	 				PsoYdChgVO ydChgVO = list.get(j);
	 				String vslCd = vo.getVslCd();
	 				String skdVoyNo = vo.getSkdVoyNo();
	 				String skdDirCd = vo.getSkdDirCd();
	 				String ydChgNo = (String) ydChgVO.getYdChgNo();
					String ydChgVerSeq = (String) ydChgVO.getYdChgVerSeq();
					String ydCd = (String)ydChgVO.getYdCd();
					String lgsCostCd = (String) ydChgVO.getLgsCostCd();
					String currCd = (String) ydChgVO.getCurrCd();
					String cntrVslClssCapa = vo.getVslCls(); 
					String vndrSeq = ydChgVO.getVndrSeq();


					calcTariffVO.setVvd(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());//vvd
					calcTariffVO.setYdChgNo(ydChgNo);
					calcTariffVO.setYdChgVerSeq(ydChgVerSeq);
					calcTariffVO.setYdCd(ydCd);
					calcTariffVO.setLgsCostCd(lgsCostCd);
					calcTariffVO.setCurrCd(currCd);//"USD"); 
					calcTariffVO.setIoFlag("Budget");//InBound/OutBound
					calcTariffVO.setCntrVslClssCapa(cntrVslClssCapa);//TBN# 

//					if("HNSF0701W".equals(calcTariffVO.getVvd())
//							&& "AUBNEY1".equals(ydCd)
//							&& "PTSVTW".equals(lgsCostCd)
//					){
//						int k = 0;
//						k++;
//					}
					
					CalcTariffResultVO  calcvo = generalInvoiceAuditBCImpl.calGeneralInvAudit(calcTariffVO);
					PsoTgtYdExpnVO insertvo = new PsoTgtYdExpnVO();
//					TgtYdExpnVO insertvo = new TgtYdExpnVO();
					//
					
					String strLocalAmt = calcvo.getTariffAmount();
					String strDspFomlDesc = calcvo.getDisplayFormulaDesc();
					String strRtFomlDesc = calcvo.getRuntimeFormulaDesc();
					String strUsdAmt = "";
					
					strLocalAmt = strLocalAmt == null ? "" : strLocalAmt;
					strDspFomlDesc = strDspFomlDesc == null ? "" : strDspFomlDesc;
					strRtFomlDesc = strRtFomlDesc == null ? "" : strRtFomlDesc;
				
					//TODO :
					
					String budScnrNo = getBudScnrNo(vslCd,  skdVoyNo, skdDirCd, vo.getExpnYrmon());
					
					//INBOUND/OUTBOUND
					PsoTgtYdExpnVO voIn = new PsoTgtYdExpnVO(); 
					voIn.setIbflag("B");
					voIn.setPagerows(budScnrNo);
					voIn.setPsoBztpCd("1");
					voIn.setVslCd(vslCd);
					voIn.setSkdVoyNo(skdVoyNo);
					voIn.setSkdDirCd(skdDirCd);
					voIn.setYdCd(ydCd);
					voIn.setLgsCostCd(lgsCostCd);
					voIn.setRevYrmon(vo.getExpnYrmon());
					voIn.setInvLoclAmt(strLocalAmt);
					voIn.setInvUsdAmt(strUsdAmt);
					voIn.setLoclCurrCd(currCd);
					
					PsoTgtYdExpnVO[] voOuts = getPsoTgtYdExpnVO(voIn);
					
					PsoBudTgtVvdVO budVo = new PsoBudTgtVvdVO();
					
					if(voOuts!=null){
						if(voOuts[0]!=null){//OutBound
							budVo.setBudScnrNo(budScnrNo);
							budVo.setVslCd(voOuts[0].getVslCd());
							budVo.setSkdVoyNo(voOuts[0].getSkdVoyNo());
							budVo.setSkdDirCd(voOuts[0].getSkdDirCd());
							budVo.setRlaneCd(voOuts[0].getRlaneCd());
							String strBudYrmon = getBudYrmon(budVo);
							
							if(strBudYrmon==null) strBudYrmon = "";
							
//							Object[] insert_param1 = { "1",
//									voOuts[0].getVslCd(),
//									voOuts[0].getSkdVoyNo(),
//									voOuts[0].getSkdDirCd(), ydCd, lgsCostCd,
//									voOuts[0].getIoBndCd()/* In/Out Bound  */, /* "", *//*
//																		 * to
//																		 * here
//																		 * PK
//																		 */
//									strBudYrmon, currCd,
//									voOuts[0].getInvLoclAmt(),
//									voOuts[0].getInvUsdAmt(), strDspFomlDesc,
//									strRtFomlDesc, ydChgNo, ydChgVerSeq, usrId,
//									usrId, voOuts[0].getRlaneCd(),
//									voOuts[0].getVslCd(),
//									voOuts[0].getSkdVoyNo(),
//									voOuts[0].getSkdDirCd(), ydCd };
//							insertWrapper.update("pso/VopPsoB002", "insert_pso_tgt_yd_expn", insert_param1);
							insertvo.setPsoBztpCd("1");
							insertvo.setVslCd(voOuts[0].getVslCd());
							insertvo.setSkdVoyNo(voOuts[0].getSkdVoyNo());
							insertvo.setSkdDirCd(voOuts[0].getSkdDirCd());
							insertvo.setYdCd(ydCd);
							insertvo.setLgsCostCd(lgsCostCd);
							insertvo.setIoBndCd(voOuts[0].getIoBndCd());
							insertvo.setRevYrmon(strBudYrmon);
							insertvo.setLoclCurrCd(currCd);
							insertvo.setInvLoclAmt(voOuts[0].getInvLoclAmt());
							insertvo.setInvUsdAmt(voOuts[0].getInvUsdAmt());
							insertvo.setXprDesc(strDspFomlDesc);
							insertvo.setFomlDesc(strRtFomlDesc);
							insertvo.setYdChgNo(ydChgNo);
							insertvo.setYdChgVerSeq(ydChgVerSeq);
							insertvo.setCreUsrId(account.getUsr_id());
							insertvo.setUpdUsrId(account.getUsr_id());
							insertvo.setRlaneCd(voOuts[0].getRlaneCd());
							insertvo.setVndrSeq(vndrSeq);
							try {
								//
//								dbDao.deleteTgtYdExpn(insertvo,"BAT");
								dbDao.insertTgtYdExpn(insertvo,"BAT");
							} catch (DAOException ex) {
								throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getMessage(),ex);
					 		} catch (Exception ex) {
					 			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getMessage(),ex);
					 		}    
							
						}
						if(voOuts[1]!=null){//InBound
							budVo.setBudScnrNo(budScnrNo);
							budVo.setVslCd(voOuts[1].getVslCd());
							budVo.setSkdVoyNo(voOuts[1].getSkdVoyNo());
							budVo.setSkdDirCd(voOuts[1].getSkdDirCd());
							budVo.setRlaneCd(voOuts[1].getRlaneCd());
							String strBudYrmon = getBudYrmon(budVo);
							
							if(strBudYrmon==null) strBudYrmon = "";
							
//							Object[] insert_param1 = { "1",
//									voOuts[1].getVslCd(),
//									voOuts[1].getSkdVoyNo(),
//									voOuts[1].getSkdDirCd(), ydCd, lgsCostCd,
//									voOuts[1].getIoBndCd()/* In/Out Bound  */, /* "", *//*
//																		 * to
//																		 * here
//																		 * PK
//																		 */
//									strBudYrmon, currCd,
//									voOuts[1].getInvLoclAmt(),
//									voOuts[1].getInvUsdAmt(), strDspFomlDesc,
//									strRtFomlDesc, ydChgNo, ydChgVerSeq, usrId,
//									usrId, voOuts[1].getRlaneCd(),
//									voOuts[1].getVslCd(),
//									voOuts[1].getSkdVoyNo(),
//									voOuts[1].getSkdDirCd(), ydCd };
//							insertWrapper.update("pso/VopPsoB002", "insert_pso_tgt_yd_expn", insert_param1);
							insertvo.setPsoBztpCd("1");
							insertvo.setVslCd(voOuts[1].getVslCd());
							insertvo.setSkdVoyNo(voOuts[1].getSkdVoyNo());
							insertvo.setSkdDirCd(voOuts[1].getSkdDirCd());
							insertvo.setYdCd(ydCd);
							insertvo.setLgsCostCd(lgsCostCd);
							insertvo.setIoBndCd(voOuts[1].getIoBndCd());
							insertvo.setRevYrmon(strBudYrmon);
							insertvo.setLoclCurrCd(currCd);
							insertvo.setInvLoclAmt(voOuts[1].getInvLoclAmt());
							insertvo.setInvUsdAmt(voOuts[1].getInvUsdAmt());
							insertvo.setXprDesc(strDspFomlDesc);
							insertvo.setFomlDesc(strRtFomlDesc);
							insertvo.setYdChgNo(ydChgNo);
							insertvo.setYdChgVerSeq(ydChgVerSeq);
							insertvo.setCreUsrId(account.getUsr_id());
							insertvo.setUpdUsrId(account.getUsr_id());
							insertvo.setRlaneCd(voOuts[1].getRlaneCd());
							insertvo.setVndrSeq(vndrSeq);
							try {
								
//								dbDao.deleteTgtYdExpn(insertvo,"BAT");
								dbDao.insertTgtYdExpn(insertvo,"BAT");
							} catch (DAOException ex) {
								throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getMessage(),ex);
					 		} catch (Exception ex) {
					 			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getMessage(),ex);
					 		}    
						}
					}
					else{
						if(strLocalAmt == null)
							strLocalAmt = "";
						else{//Usd AMT
							String usdAmt = generalInvoiceAuditBCImpl.getUsdAmt(strLocalAmt, currCd, budScnrNo, "B");
							String usdAmts[] = usdAmt.split("\\|", 2);
							if(usdAmts.length>=2){
								if(usdAmts[0].equals("")){
									strUsdAmt=usdAmts[1];
								}
								else{
									strUsdAmt=usdAmts[0];
								}
							}
						}
						budVo.setBudScnrNo(budScnrNo);
						budVo.setVslCd(vslCd);
						budVo.setSkdVoyNo(skdVoyNo);
						budVo.setSkdDirCd(skdDirCd);
//						budVo.setRlaneCd(rlaneCd);
						String strBudYrmon = getBudYrmon(budVo);
						
						if(strBudYrmon==null) strBudYrmon = "";
//						logger.info("Both bound="+voOuts[0].getIoBndCd());
//						Object[] insert_param1 = { "1", vslCd, skdVoyNo,
//								skdDirCd, ydCd, lgsCostCd,
//								"B"/* In/Out Bound  */, /* "", *//*
//																	 * to here
//																	 * PK
//																	 */
//								strBudYrmon, currCd, strLocalAmt, strUsdAmt,
//								strDspFomlDesc, strRtFomlDesc, ydChgNo,
//								ydChgVerSeq, usrId, usrId, rlaneCd, vslCd,
//								skdVoyNo, skdDirCd, ydCd };
//						insertWrapper.update("pso/VopPsoB002", "insert_pso_tgt_yd_expn", insert_param1);
						insertvo.setPsoBztpCd("1");
						insertvo.setVslCd(vslCd);
						insertvo.setSkdVoyNo(skdVoyNo);
						insertvo.setSkdDirCd(skdDirCd);
						insertvo.setYdCd(ydCd);
						insertvo.setLgsCostCd(lgsCostCd);
						insertvo.setIoBndCd("B");
						insertvo.setRevYrmon(strBudYrmon);
						insertvo.setLoclCurrCd(currCd);
						insertvo.setInvLoclAmt(strLocalAmt);
						insertvo.setInvUsdAmt(strUsdAmt);
						insertvo.setXprDesc(strDspFomlDesc);
						insertvo.setFomlDesc(strRtFomlDesc);
						insertvo.setYdChgNo(ydChgNo);
						insertvo.setYdChgVerSeq(ydChgVerSeq);
						insertvo.setCreUsrId(account.getUsr_id());
						insertvo.setUpdUsrId(account.getUsr_id());
//						insertvo.setRlaneCd(voOuts[1].getRlaneCd());
						insertvo.setVndrSeq(vndrSeq);
						try {
							
//							dbDao.deleteTgtYdExpn(insertvo,"BAT");
							dbDao.insertTgtYdExpn(insertvo,"BAT");
						} catch (DAOException ex) {
							throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getMessage(),ex);
				 		} catch (Exception ex) {
				 			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getMessage(),ex);
				 		}  
					}
					//--> OLD 
//					insertvo.setPsoBztpCd("1");
//					insertvo.setVslCd(vo.getVslCd());
//					insertvo.setSkdVoyNo(vo.getSkdVoyNo());
//					insertvo.setSkdDirCd(vo.getSkdDirCd());
//					insertvo.setYdCd(ydCd);
//					insertvo.setLgsCostCd(lgsCostCd);
//					insertvo.setRevYrmon(vo.getExpnYrmon());
//					insertvo.setInvUsdAmt(calcvo.getTariffAmount());
//					insertvo.setYdChgNo(ydChgNo);
//					insertvo.setYdChgVerSeq(ydChgVerSeq);
//					insertvo.setCreUsrId(account.getUsr_id());
//					insertvo.setUpdUsrId(account.getUsr_id());
//					
//					try {
//						
//						dbDao.deleteTgtYdExpn(insertvo,"BAT");
//						dbDao.insertTgtYdExpn(insertvo,"BAT");
//					} catch (DAOException ex) {
//						throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getUserMessage(),ex);
//			 		} catch (Exception ex) {
//			 			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getUserMessage(),ex);
//			 		}   
					//<<<---------OLD END
	 			}//end of for
	 		}//end of if(list!=null)
		}//end of main for
	}//end of operation

	/**
	 * BudScnrNo
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String budYrmon
	 * @return String 
	 * @throws EventException
	 */
	private String getBudScnrNo(String vslCd, String skdVoyNo, String skdDirCd, String budYrmon) throws EventException {
		try {
 			return dbDao.getBudScnrNo(vslCd, skdVoyNo, skdDirCd, budYrmon);
 		} catch (DAOException ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation:getBudScnrNo"}).getUserMessage(),ex);
 		} catch (Exception ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation:getBudScnrNo"}).getUserMessage(),ex);
 		}    
	}

	/**
	 * Recreate Budget Info by VVD chosen from main list <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String revYrmon
	 * @return List<PsoYdChgVO>
	 * @exception EventException
	 */
	public List<PsoYdChgVO> searchYardChargeByVvd(String vslCd, String skdVoyNo, String skdDirCd, String revYrmon) throws EventException {
		try {
 			return dbDao.searchYardChargeByVvd(vslCd, skdVoyNo, skdDirCd, revYrmon);
 		} catch (DAOException ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation"}).getUserMessage(),ex);
 		} catch (Exception ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation"}).getUserMessage(),ex);
 		}    
	}

	/**
	 * Show Ecpense Detail Info by VVD chosen <br />
	 * @category VOP_PSO_0213_Open
	 * @param ExpnDtlVO expnDtlVO
	 * @return List<ExpnDtlVO> 
	 * @exception EventException
	 */
	public List<ExpnDtlVO> searchExpenseDetail(ExpnDtlVO expnDtlVO) throws EventException {
		try {
			return dbDao.searchExpenseDetail(expnDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Expense Detail"}).getUserMessage(),ex);
 		} catch (Exception ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Expense Detail"}).getUserMessage(),ex);
 		}    
	}

	/**
	 * Create VVD Info which is object of canal navigation in PSO module requested by VSK 
	 * @param String portCd
	 * @param String tgtDate
	 * @param boolean flag
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendToSppTargetVvd(String portCd, String tgtDate, boolean flag, SignOnUserAccount account) throws EventException {
		try {
			String port = portCd.substring(0, 5);
			
			if(flag){
				if(port.equals("PAPAC")){					
					dbDao.addSppTargetVvd(portCd, tgtDate, "6", account);
					dbDao.addSppTargetYdSkd(portCd, tgtDate, "6", account);
				}
			} else{
				dbDao.addSppTargetVvd(portCd, tgtDate, "5", account);
				dbDao.addSppTargetYdSkd(portCd, tgtDate, "5", account);

				if(port.equals("PAPAC")){
					dbDao.addSppTargetVvd(portCd, tgtDate, "6", account);
					dbDao.addSppTargetYdSkd(portCd, tgtDate, "6", account);				
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Target VVD Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Target VVD Creation"}).getUserMessage(),ex);
		}			
	}

	/**
	 * Check whether VVD chosen is Turning Port.
	 * @param String hvvd
	 * @param String tmnlCode
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode) throws EventException {
		try {
			return dbDao.checkTurningPort(hvvd, tmnlCode);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Target VVD Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Target VVD Creation"}).getUserMessage(),ex);
		}	
	}

	/**
	 * Get Bud_Yrmon value in BudgetExpenseCreation Batch module
	 * @param PsoBudTgtVvdVO budVo
	 * @return String 
	 * @throws EventException
	 */
	public String getBudYrmon(PsoBudTgtVvdVO budVo) throws EventException {
		try {
			return dbDao.getBudYrmon(budVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getUserMessage(),ex);
		}	
	}

	/**
	 * Retrieve Invoice Summary Detail
	 * @param InvSumDtlVO invSumDtlVO
	 * @return List<InvSumDtlVO> 
	 * @throws EventException
	 */
	public List<InvSumDtlVO> searchInvSumDtl(InvSumDtlVO invSumDtlVO) throws EventException {
		try {
			return dbDao.searchInvSumDtl(invSumDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Invoice Summary"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Invoice Summary"}).getMessage());
		}	
	}
	

	/**
	 * Create Monthly Estimation Creation info
	 * @category VOP_PSO_0013
	 * @param ErpSumVO erpSumVO
	 * @return String
	 * @throws EventException
	 */
	public String createInterfaceToERP(ErpSumVO erpSumVO) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
		boolean bIsRunning;
		String yyyymm = erpSumVO.getExeYrmon();
		String userId = erpSumVO.getCreUsrId();
		String lanecd = "ALL";
		try {
			bIsRunning = su.isRunning("VOP_PSO_B003");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Monthly Estimation Creation"}).getUserMessage(),e);
		}
		log.debug("\ncreateInterfaceToERP bIsRunning>> " + bIsRunning);
		if(bIsRunning){
			return "6";
		}else{
			try {
				su.directExecuteJob("VOP_PSO_B003", "no-use-data"+"#"+yyyymm+"#"+userId+"#"+lanecd+"#2");
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Monthly Estimation Creation"}).getUserMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Monthly Estimation Creation"}).getUserMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Monthly Estimation Creation"}).getUserMessage(),e);
			}
			return "4";
		}
	}
	
	/**
	 * Retrieve Budget Creation
	 * @category VOP_PSO_0008_Retrieve (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @return List<BudCreVO>
	 * @throws EventException
	 */
	public List<BudCreVO> searchBudCreByMon(String startDt, String endDt) throws EventException {
		try {
			return dbDao.searchBudCreByMon(startDt, endDt);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Creation"}).getMessage(), de);
		}
	}
	
	/**
	 * Retrieve Budget Creation exchange rate 
	 * @category VOP_PSO_0008_Retrieve (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @return List<BudCreVO>
	 * @throws EventException
	 */
	public List<BudCreVO> searchBudCreByCurrency(String startDt, String endDt) throws EventException {
		try {
			return dbDao.searchBudCreByCurrency(startDt, endDt);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Creation"}).getMessage(), de);
		}
	}
	
	/**
	 * Retrieve Estimate Creation
	 * @category VOP_PSO_0009_Retrieve (jmh)
	 * @param String revYrmon
	 * @param String vslSlanCd
	 * @return List<EstCreVO>
	 * @throws EventException
	 */
	public List<EstCreVO> searchEstCreByMon(String revYrmon, String vslSlanCd) throws EventException {
		try {
			return dbDao.searchEstCreByMon(revYrmon, vslSlanCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Estimate Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Estimate Creation"}).getMessage(), de);
		}
	}
	
	/**
	 * Check whether Batch module is in action 
	 * @category VOP_PSO_0009	(jmh)
	 * @param String batchID
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkRunningBatch(String batchID) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		boolean isRunning = false;
		try {
			isRunning = su.isRunning(batchID);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Can't check batch program is running."}).getMessage(), ex);			
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("PSO90005", new String[]{"Can't check batch program is running."}).getMessage(),e);
		}
		
		return isRunning;
	}
	
	/**
	 * Save date of Budget Creation
	 * @category VOP_PSO_0008_SaveButtonClick
	 * @param BudCreVO[] budCreVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBudCre(BudCreVO[] budCreVOs, SignOnUserAccount account) throws EventException {			
		
		try {
			List<BudCreVO> voList = new ArrayList<BudCreVO>();
			if( budCreVOs != null ){
				for ( int i=0; i<budCreVOs.length; i++ ) {
					budCreVOs[i].setCreUsrId(account.getUsr_id());
					voList.add(budCreVOs[i]);
				}
				dbDao.deleteBudCre(voList);
				dbDao.addBudCre(voList);
			}
		} 
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budet Creation"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budet Creation"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * Check running state of VVD unit Tariff Simulation
	 * 
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdExpenseSimulationStatus(SearchPortTariffListVO[] searchPortTariffListVOs) throws EventException {
		
		ScheduleUtil su = new ScheduleUtil();
		boolean bIsRunning = false;
		String batchRunningStatus = "";
		int count = 0;
		
		try {
			bIsRunning = su.isRunning("VOP_PSO_B004");
			
			if(bIsRunning){
				batchRunningStatus = "6";
			}else{
				PsoTgtVvdVO psoTgtVvdVO = null;
				for(SearchPortTariffListVO searchPortTariffListVO : searchPortTariffListVOs){
					psoTgtVvdVO = new PsoTgtVvdVO();
					psoTgtVvdVO.setPsoBztpCd("7");
					 // related VOP_PSO_0039
					psoTgtVvdVO.setVslCd(searchPortTariffListVO.getVslCd());
					psoTgtVvdVO.setSkdVoyNo(searchPortTariffListVO.getSkdVoyNo());
					psoTgtVvdVO.setSkdDirCd(searchPortTariffListVO.getSkdDirCd());
					
					count = dbDao.searchVvdExpenseSimulationStatus(psoTgtVvdVO); 
					if(count>0){
						batchRunningStatus = "6"; 
						break;
					}
				}
			}
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
		}
		return batchRunningStatus;
	}
	
	/**
	 *Put in action VVD unit Tariff Simulation Setup.
	 * 
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String processType
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageVvdExpenseSimulationSetup(SearchPortTariffListVO[] searchPortTariffListVOs, String processType, SignOnUserAccount account) throws EventException {
		List<PsoTgtVvdVO> psoTgtVvdVOs = new ArrayList<PsoTgtVvdVO>();
		PsoTgtVvdVO psoTgtVvdVO = null;
		int count = 0;
		try{
			for(SearchPortTariffListVO searchPortTariffListVO : searchPortTariffListVOs){
				psoTgtVvdVO = new PsoTgtVvdVO();
				psoTgtVvdVO.setPsoBztpCd("7");
				// related VOP_PSO_0039
				psoTgtVvdVO.setVslCd(searchPortTariffListVO.getVslCd());
				psoTgtVvdVO.setSkdVoyNo(searchPortTariffListVO.getSkdVoyNo());
				psoTgtVvdVO.setSkdDirCd(searchPortTariffListVO.getSkdDirCd());
				
				psoTgtVvdVO.setCreUsrId(account.getUsr_id());
				psoTgtVvdVO.setUpdUsrId(account.getUsr_id());
				psoTgtVvdVOs.add(psoTgtVvdVO);
			}
			if("I".equals(processType)){
				count = dbDao.addVvdExpenseSimulationSetup(psoTgtVvdVOs); 
				if(count!=psoTgtVvdVOs.size()){
					throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage());
				}
			}else if("D".equals(processType)){
				if(psoTgtVvdVO != null){
					dbDao.removeVvdExpenseSimulationSetup(psoTgtVvdVO.getPsoBztpCd());
				}
			}
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
		}
		
	}
	
	/**
	 * Put in action VVD unit Tariff Simulation
	 *
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String manageVvdExpenseSimulation(SignOnUserAccount account) throws EventException {
		
		ScheduleUtil su = new ScheduleUtil();
		
		boolean bIsRunning = false;				
		try {
			bIsRunning = su.isRunning("VOP_PSO_B004");
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
		}
		
		if(bIsRunning){
			return "6";
		}else{
			try {
				su.directExecuteJob("VOP_PSO_B004","no-use-data#"+account.getUsr_id());
			} catch (IOException e) {
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
			} catch (InterruptedException e) {
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
			} catch (DAOException e) {
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
			}
			return "4";
		}
	}

	/**
	 * Retrieve a detailed estimated cost to interface ERP estimated performance cost of previous month at the beginning of the month
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 */
	public List<CostListVO> searchAccountCodeByErp(ErpDtlVO erpDtlVO) throws EventException {			
		try {
			return dbDao.searchAccountCodeByErp(erpDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation (Detail) Account Code"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation (Detail) Account Code"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * Retrieving Control Office Code of RHQ
	 * 
	 * @param String rhqCd
	 * @return List<CtrlOfficeVO>
	 * @exception EventException
	 */
	public List<CtrlOfficeVO> searchControlOfficeList(String rhqCd) throws EventException {
		try {
			return dbDao.searchControlOfficeList(rhqCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010").getMessage(), ex);
		}
	}
}