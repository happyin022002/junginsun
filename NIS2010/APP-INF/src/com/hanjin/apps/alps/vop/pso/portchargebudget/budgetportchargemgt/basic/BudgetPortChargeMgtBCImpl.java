/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BudgetPortChargeMgtBCImpl.java
 *@FileTitle : Budget vs Actual
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.20
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation

 * History
 * 2010.08.06 CHM-201005146-01 사업계획및 추정 실적 산출시 Discount 산출 로직 변경
 * 2010.08.31 진마리아 [CHM-201005695-01] Limit Time 및 Tier Object 로직 변경
 * 2010.10.01 진마리아 [CHM-201006264-01] Session User ID 설정로직 변경
 * 2010.10.04 유혁 CHM-201006127-01 운하 통항비 tariff Cost 생성 로직 변경 
 * 2010.10.27 진마리아 CHM-201006714-01 추정결산 로직 보완
 * 2010.11.15 진마리아 CHM-201007130-01 Budget 생성시 RLANE_CD 조회 로직 변경
 * 2011.04.05 진마리아 CHM-201109850-01 사업계획 항비 로직 수정 요청
 * 2011.08.10 진마리아 CHM-201111882-01 [VOP-PSO] COA data I/F
 * 2011.10.28 진마리아 CHM-201114305-01 Split 01-Port tariff I/F data 변경 - COA 요청으로 인한 VVD별 추정은 Expense Ratio를 적용하지 않도록 변경 (예외 없이 100%)
 * 2011.12.19 진마리아 CHM-201114861-01 [VOP-PSO] Port Charge Invoice Summary yard 다중 선택 시 조회 가능하도록 로직 수정
 * 2012.06.08 진마리아 CHM-201218370-01 [PSO] 추정 관련 로직 변경 (팬드럼 노선)
 * 2012.08.20 이혜민 CHM-201219078-01 사업계획 - 시나리오 연도 추가
 * 2015.02.02  [CHM-201533847] PORT내 SKIP여부 처리
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBC;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.IoRatioVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.RoundTruncVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration.BudgetPortChargeMgtDBDAO;
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
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoBudTgtVvdVO;
import com.hanjin.syscommon.common.table.PsoTgtVvdVO;
import com.hanjin.syscommon.common.table.PsoTgtYdExpnVO;
import com.hanjin.syscommon.common.table.PsoYdChgVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffListMasVO; //mas용

/**
 * ALPS-PortChargeBudget Business Logic Basic Command implementation<br>
 * - ALPS-PortChargeBudget에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author myoungjong park
 * @see VOP_PSO_0025EventResponse,BudgetPortChargeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BudgetPortChargeMgtBCImpl extends BasicCommandSupport implements BudgetPortChargeMgtBC {

	// Database Access Object
	private transient BudgetPortChargeMgtDBDAO dbDao = null;

	/**
	 * BudgetPortChargeMgtBCImpl 객체 생성<br>
	 * BudgetPortChargeMgtDBDAO를 생성한다.<br>
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
	 *  Budget vs Actual을 조회한다. <br>
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
	 *  Invoice Summary를 조회한다.<br>
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
				buf.append("\'").append( invSumByMonVO.getPortCd()).append( invSumByMonVO.getTermCode()).append("\'");
			} else {
				count = 1;
				while( token.hasMoreElements()){
					if( count == 1 )
						buf.append("\'").append( invSumByMonVO.getPortCd()).append(token.nextToken(",")).append("\'").append(",");
					else if( count == tcount )
						buf.append("\'").append( invSumByMonVO.getPortCd()).append(token.nextToken(",")).append("\'");
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
	 * Estimate VVD Creation하기 위해 기 생성한 추정 대상월 및 노선별로 조회한다.
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
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 추정비용을 조회한다.
	 * @category VOP_PSO_0013_RetrieveButtonClick
	 * @param ErpSumVO erpSumVO
	 * @return List<ErpSumVO>
	 * @exception EventException
	 */
	public List<ErpSumVO> searchErpSum(ErpSumVO erpSumVO) throws EventException {
		try {
			return dbDao.searchErpSum(erpSumVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Interface to ERP"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Interface to ERP"}).getUserMessage(),ex);
		}
	}

	/**
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 상세한 추정비용을 조회한다.
	 * @category VOP_PSO_0207_OpenNRetrieveBtnClick
	 * @param ErpDtlVO erpDtlVO
	 * @return List<ErpDtlVO>
	 */
	public List<ErpDtlVO> searchErpDtl(ErpDtlVO erpDtlVO) throws EventException {			
		try {
			return dbDao.searchErpDtl(erpDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Interface to ERP (Detail)"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Interface to ERP (Detail)"}).getUserMessage(),ex);
		}
	}

	/**
	 * 월초에 전달의 추정실적비용을 ERP로 인터페이스하기 위해 추정비용을 변경한다.
	 * @category VOP_PSO_0207_SaveButtonClick
	 * @param ErpDtlVO[] erpDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyErpDtl(ErpDtlVO[] erpDtlVOs, SignOnUserAccount account) throws EventException {			
		// TODO Auto-generated method stub
		try {
			List<ErpDtlVO> updateVoList = new ArrayList<ErpDtlVO>();

			for ( int i=0; i<erpDtlVOs.length; i++ ) {
				if ( erpDtlVOs[i].getIbflag().equals("U")){
					erpDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(erpDtlVOs[i]);
				} 
			}
			dbDao.modifyErpDtl(updateVoList);
		} 
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Interface to ERP (Detail)"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Interface to ERP (Detail)"}).getUserMessage(),ex);
		}
	}

	/**
	 * 년도별 사업 계획을 조회한다.
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
	 * 재무 월간 수입 대상 항차 기준으로 해당월의 항비 대상 항차를 생성한다.
	 * @category VOP_PSO_0010_ExpenseApplyButtonClick
	 * @param EstExpnCreVO[] estExpnCreVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void createEstTgtVvdByMon(
			EstExpnCreVO[] estExpnCreVOs, SignOnUserAccount account)
			throws EventException {
		try {
			EstExpnCreVO turnEstExpnCreVO = new EstExpnCreVO();
			for ( int i=0; i<estExpnCreVOs.length; i++ ) {
				if ( estExpnCreVOs[i].getIbflag().equals("U")){
					
					createEstTgtVvdByMon(estExpnCreVOs[i], account);
					
					// Turn Port 정보가 존재하는 경우 그 Turn Port 정보로 다시 생성한다.
					if((estExpnCreVOs[i].getTurnSkdVoyNo()!=null && estExpnCreVOs[i].getTurnSkdVoyNo()!="") &&
							(estExpnCreVOs[i].getTurnSkdDirCd()!=null && estExpnCreVOs[i].getTurnSkdDirCd()!="") &&
							(estExpnCreVOs[i].getTurnClptIndSeq()!=null && estExpnCreVOs[i].getTurnClptIndSeq()!="")){
						
						
						PsoTgtVvdVO psoTgtVvdVO = new PsoTgtVvdVO();
						psoTgtVvdVO.setVslCd(estExpnCreVOs[i].getVslCd());
						psoTgtVvdVO.setSkdVoyNo(estExpnCreVOs[i].getTurnSkdVoyNo());
						psoTgtVvdVO.setSkdDirCd(estExpnCreVOs[i].getTurnSkdDirCd());
						
						if(dbDao.searchPsoTgtVVD(psoTgtVvdVO)!=null){						
							ObjectCloner.build(estExpnCreVOs[i], turnEstExpnCreVO);
							turnEstExpnCreVO.setSkdVoyNo(estExpnCreVOs[i].getTurnSkdVoyNo());
							turnEstExpnCreVO.setSkdDirCd(estExpnCreVOs[i].getTurnSkdDirCd());
							turnEstExpnCreVO.setClptIndSeq(estExpnCreVOs[i].getTurnClptIndSeq());
							turnEstExpnCreVO.setTurnPortFlg(estExpnCreVOs[i].getVirTurnPortFlg());
							turnEstExpnCreVO.setTurnPortIndCd(estExpnCreVOs[i].getVirTurnPortIndCd());
							turnEstExpnCreVO.setHvvd(estExpnCreVOs[i].getVslCd()+estExpnCreVOs[i].getTurnSkdVoyNo()+estExpnCreVOs[i].getTurnSkdDirCd());
							createEstTgtVvdByMon(turnEstExpnCreVO, account);
						}
					}
				} 
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Expense Creation"}).getMessage(),ex);
		}
	}
	
	private void createEstTgtVvdByMon(EstExpnCreVO estExpnCreVO, SignOnUserAccount account) throws EventException {
//		List<EstExpnCreVO> insertVoList = new ArrayList<EstExpnCreVO>();
		CalcTariffVO calcTariffVO = new CalcTariffVO();
		GeneralInvoiceAuditBC command = new GeneralInvoiceAuditBCImpl();//2-phase commit

		try{
//			insertVoList.add(estExpnCreVO);
			log.debug("VVD:="+estExpnCreVO.getHvvd());
			log.debug("TerminalCode:="+estExpnCreVO.getTmnlCode());
			
			//대상 VVD 및 Port로 해당 VVD가 Turning POrt면 처리하지 않음 
	//		if(checkTurningPort(estExpnCreVOs[i].getHvvd(), estExpnCreVOs[i].getTmnlCode()))
	//			continue ; //계산하지 않고 다음 진행 2009.12.24 comment out.
			
			PsoTgtYdExpnVO delvo = new PsoTgtYdExpnVO();
			delvo.setPsoBztpCd("2");
			delvo.setVslCd(estExpnCreVO.getVslCd());
			delvo.setSkdVoyNo(estExpnCreVO.getSkdVoyNo());
			delvo.setSkdDirCd(estExpnCreVO.getSkdDirCd());
			delvo.setYdCd(estExpnCreVO.getTmnlCode());
			delvo.setRevYrmon(estExpnCreVO.getRevYrmon());
			delvo.setCreDt(account.getUsr_id());
			delvo.setUpdUsrId(account.getUsr_id());
			delvo.setCreUsrId(account.getUsr_id());
	
			//Delete먼저 
			dbDao.deleteTgtYdExpn(delvo,"PSO_HJSBAT");
			
			PsoTgtYdExpnVO delvo2 = new PsoTgtYdExpnVO();
			delvo2.setPsoBztpCd("2");
			delvo2.setVslCd(estExpnCreVO.getVslCd());
			delvo2.setSkdVoyNo(estExpnCreVO.getSkdVoyNo());
			delvo2.setSkdDirCd(estExpnCreVO.getSkdDirCd());
			delvo2.setYdCd(estExpnCreVO.getTmnlCode());
			
			dbDao.deleteGlEstmIfErp(delvo2);
			
			List<YardChargeVO> list = dbDao.selectYdChg(estExpnCreVO.getTmnlCode(), estExpnCreVO.getRevYrmon());
			
			for(int j=0;j<list.size();j++){
				YardChargeVO vo = list.get(j);
				String ydChgNo = vo.getYdChgNo();
				String ydChgVerSeq = vo.getYdChgVerSeq();
				String lgsCostCd = vo.getLgsCostCd();
				String vndrSeq = vo.getVndrSeq();
				
				//Calc를 위한 파라미터 Input...
				calcTariffVO.setVvd(estExpnCreVO.getHvvd());//vvd
				calcTariffVO.setYdChgNo(ydChgNo);
				calcTariffVO.setYdChgVerSeq(ydChgVerSeq);
				calcTariffVO.setYdCd(estExpnCreVO.getTmnlCode());
				calcTariffVO.setLgsCostCd(lgsCostCd);
				calcTariffVO.setCurrCd(vo.getCurrCd());
				/*
	    		 * CHM-201005695-01
	    		 * 추정실적의 flg를 설정
	    		 */
				calcTariffVO.setEstFlg("Y");
	
				/*
				 * <<20100806_01>>
				 * Estimate InBound/OutBound구분 관련 변경
				 * 기존 : 구분없이 Estimate로 일괄 처리
				 * 변경 : Turning Port인 경우 OutBound, Virtual Port인 경우 InBound, Normal Port인 경우 Object에 따라 InBound/OutBound 구분
				 */
	//			calcTariffVO.setIoFlag("Estimate");//Estimate InBound/OutBound구분
				// Normal Port인 경우
				if("N".equals(estExpnCreVO.getTurnPortFlg()) && "N".equals(estExpnCreVO.getTurnPortIndCd())){
					calcTariffVO.setIoFlag("OUT");
				}else{
					// TURN_PORT_IND_CD가 
					// D, V, F인 경우 InBound로 계산
					// Y, N인 경우 OutBound로 계산
					if("D".equals(estExpnCreVO.getTurnPortIndCd()) ||
							"V".equals(estExpnCreVO.getTurnPortIndCd()) ||
							"F".equals(estExpnCreVO.getTurnPortIndCd())){
						calcTariffVO.setIoFlag("IN");
					}else{
						calcTariffVO.setIoFlag("OUT");
					}
				}
				
				CalcTariffResultVO calcvo = command.calGeneralInvAudit(calcTariffVO);
	//			logger.info("Tariff Amount:="+calcvo.getTariffAmount());
				
				// Normal Port인 경우
				if("N".equals(estExpnCreVO.getTurnPortFlg()) && "N".equals(estExpnCreVO.getTurnPortIndCd())){
					
					//IN으로 사용된 Object가 있는지 확인한 후, IN으로 다시 계산한다.
					if(calcvo.existObj(77)){
						float outAmt = Float.parseFloat(calcvo.getTariffAmount());
						String outDisplayFormulaDesc = calcvo.getDisplayFormulaDesc();
						String outRuntimeFormulaDesc = calcvo.getRuntimeFormulaDesc();
						
						calcTariffVO.setIoFlag("IN");
						calcvo = command.calGeneralInvAudit(calcTariffVO);
						float inAmt = Float.parseFloat(calcvo.getTariffAmount());
						String inDisplayFormulaDesc = calcvo.getDisplayFormulaDesc();
						String inRuntimeFormulaDesc = calcvo.getRuntimeFormulaDesc();
						
						// IN/OUT [B], [S], [D] 결합
						outDisplayFormulaDesc = concatFormula(outDisplayFormulaDesc, inDisplayFormulaDesc, "[B]:");
						outDisplayFormulaDesc = concatFormula(outDisplayFormulaDesc, inDisplayFormulaDesc, "[S]:");
						outDisplayFormulaDesc = concatFormula(outDisplayFormulaDesc, inDisplayFormulaDesc, "[D]:");
						
						outRuntimeFormulaDesc = concatFormula(outRuntimeFormulaDesc, inRuntimeFormulaDesc, "[B]:");
						outRuntimeFormulaDesc = concatFormula(outRuntimeFormulaDesc, inRuntimeFormulaDesc, "[S]:");
						outRuntimeFormulaDesc = concatFormula(outRuntimeFormulaDesc, inRuntimeFormulaDesc, "[D]:");
						
						calcvo.setDisplayFormulaDesc(outDisplayFormulaDesc);
						calcvo.setRuntimeFormulaDesc(outRuntimeFormulaDesc);
						
						// IN/OUT Amount를 더한다.
						calcvo.setTariffAmount(Float.toString(outAmt + inAmt));
					}
				}
				
				
				if(calcvo.getTariffAmount() == null)
					continue;
				if(calcvo.getTariffAmount().equals(""))
					continue;//계산이 안된넘 처리 필요 없음
				
				String strDspFomlDesc = calcvo.getDisplayFormulaDesc();
				String strRtFomlDesc = calcvo.getRuntimeFormulaDesc();
				
				strDspFomlDesc = strDspFomlDesc == null ? "" : strDspFomlDesc;
				strRtFomlDesc = strRtFomlDesc == null ? "" : strRtFomlDesc;
				
				PsoTgtYdExpnVO insertvo = new PsoTgtYdExpnVO();
				
				
				insertvo.setPsoBztpCd("2");
				insertvo.setVslCd(estExpnCreVO.getVslCd());
				insertvo.setSkdVoyNo(estExpnCreVO.getSkdVoyNo());
				insertvo.setSkdDirCd(estExpnCreVO.getSkdDirCd());
				insertvo.setYdCd(estExpnCreVO.getTmnlCode());
				insertvo.setLgsCostCd(lgsCostCd);
				insertvo.setRevYrmon(estExpnCreVO.getRevYrmon());
	//			insertvo.setInvUsdAmt(calcvo.getTariffAmount());
				insertvo.setYdChgNo(ydChgNo);
				insertvo.setYdChgVerSeq(ydChgVerSeq);
				insertvo.setCreUsrId(account.getUsr_id());
				insertvo.setUpdUsrId(account.getUsr_id());
				insertvo.setLoclCurrCd(vo.getCurrCd());
				insertvo.setVndrSeq(vndrSeq);
	
				String strRlanceCd = dbDao.getRlaneCd(
						 estExpnCreVO.getVslCd()
						,estExpnCreVO.getSkdVoyNo()
						,estExpnCreVO.getSkdDirCd()
						,estExpnCreVO.getTmnlCode().substring(0, 5));
				
				insertvo.setRlaneCd(strRlanceCd);
				insertvo.setVndrSeq(vndrSeq);
				
				//INBOUND/OUTBOUND의 구분에 따라 분기 처리 
				PsoTgtYdExpnVO voIn = new PsoTgtYdExpnVO(); 
				voIn.setPsoBztpCd("2");
				voIn.setVslCd(insertvo.getVslCd());
				voIn.setSkdVoyNo(insertvo.getSkdVoyNo());
				voIn.setSkdDirCd(insertvo.getSkdDirCd());
				voIn.setYdCd(insertvo.getYdCd());
				voIn.setLgsCostCd(insertvo.getLgsCostCd());
				voIn.setRevYrmon(insertvo.getRevYrmon());
				voIn.setInvLoclAmt(calcvo.getTariffAmount());
	//			voIn.setInvUsdAmt(calcvo.getTariffAmount());
				voIn.setLoclCurrCd(vo.getCurrCd());
				voIn.setCreUsrId(account.getUsr_id());
				voIn.setUpdUsrId(account.getUsr_id());
				voIn.setVndrSeq(vndrSeq);	//[2010.03.08:jmh]
//				voIn.setRlaneCd(strRlanceCd);
				
//				if("N".equals(estExpnCreVO.getTurnPortFlg()) && "N".equals(estExpnCreVO.getTurnPortIndCd())){
//					voIn.setIbflag(""); //--> Monthly Estimate Batch 
//				}else{
//					voIn.setIbflag("M"); //--> Monthly Estimate Batch 
//				}
				
				if(calcvo.existObj(77) || calcvo.existObj(89)){
					voIn.setIbflag("X");
				}
	
	//			PsoTgtYdExpnVO[] voOuts = command.getPsoTgtYdExpnVO(voIn);
				PsoTgtYdExpnVO[] voOuts = getPsoTgtYdExpnVO(voIn);
				
			
			
				if(voOuts!=null){
					if(voOuts[0]!=null){//OutBound
						PsoTgtYdExpnVO voInsert = voOuts[0];
						voInsert.setXprDesc(strDspFomlDesc);
						voInsert.setFomlDesc(strRtFomlDesc);
						dbDao.insertTgtYdExpn(voInsert,"PSO_HJSBAT");
					}
					if(voOuts[1]!=null){//InBound
						PsoTgtYdExpnVO voInsert = voOuts[1];
						voInsert.setXprDesc(strDspFomlDesc);
						voInsert.setFomlDesc(strRtFomlDesc);
						dbDao.insertTgtYdExpn(voInsert,"PSO_HJSBAT");
					}
				}
				else{//IO구분이 없으면 
					insertvo.setXprDesc(strDspFomlDesc);
					insertvo.setFomlDesc(strRtFomlDesc);
					dbDao.insertTgtYdExpn(insertvo,"PSO_HJSBAT");
				}
			}// end of for(int j=0;j<list.size();j++)
			
			dbDao.insertGlEstmIfErp(delvo);//YD_CD 레벨로 EXPN 묶어서 INSERT한다.
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Expense Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Expense Creation"}).getMessage(),ex);
		}
	}
	
	/**
	 * form1과 form2에서 sameItem이 동시에 존재하는지 확인하고
	 * form1을 기준으로 최종 결합 내용을 추가한다. 
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
		
		// form1에서 sameItem의 내용 추출
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
		
		// form2에서 sameItem의 내용 추출
		itemIdx2 = form2.indexOf(sameItem);
		
		if(itemIdx2>-1){
			if(form2.indexOf("\n", itemIdx2)>-1){
				itemDesc2 = form2.substring(itemIdx2+sameItem.length(), form2.indexOf("\n", itemIdx2)).trim();
			}else{
				itemDesc2 = form2.substring(itemIdx2+sameItem.length()).trim();
			}
			
		}
		
		// form1, form2에서 결합할 내용이 있으면 '+' 표시를 이용하여 수식을 결합한다.
		if(itemDesc1.length()>0 && itemDesc2.length()>0){
			itemDesc = itemDesc1 + " + " + itemDesc2;
		}else{
			itemDesc = itemDesc1 + itemDesc2;
		}
		
		// 최총 결합 내용이 있으면 앞에 sameItem 표시해 준다. 
		if(itemDesc.length()>0){
			itemDesc = sameItem + itemDesc;
		}
		
		// form1을 기준으로 최종 결합 내용을 추가한다.
		return itemDesc1Pre + itemDesc + itemDesc1Post;
	}

	/*
	 * CHM-201007130-01
	 */
	/**
	 * VopPsoB0003.java Estimate Creation 에서 I/O Bound 정보 획득 처리
	 * @param PsoTgtYdExpnVO voIn
	 * @return PsoTgtYdExpnVO[]
	 * @throws DAOException
	 */
	public PsoTgtYdExpnVO[] getPsoTgtYdExpnVO(PsoTgtYdExpnVO voIn)  throws EventException {
		
		PsoTgtYdExpnVO[] retVo = new PsoTgtYdExpnVO[2];//최대 2개를 설정할수 있음
		
		PsoTgtYdExpnVO voInBnd = null;
		PsoTgtYdExpnVO voOutBnd = null;
		
		String flg = voIn.getIbflag();
		
		// CHM-201109850-01
		if("Y".equals(flg)){ // Budget 타입에서 IN 혹은 OUT으로 전용(100%)되는 경우
			flg = "B";
		}
		
		try {
		if(voIn.getYdCd().indexOf("EGSUZ") != -1 || voIn.getYdCd().indexOf("PAPAC")!=-1){// EGSUZ, PAPAC는 무조건 OUT BOUND 가 100 임
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
			voOutBnd.setVndrSeq(voIn.getVndrSeq());	//[2010.03.08:jmh]
			
			// Batch Budget 인 경우 Pendulum Service에 대해서는 VVD가 복수개의 Revenue Lane으로 구분된다.
			// 운하통항비의 경우 OUT BOUND가 100% 이므로 그 중에 하나의 VVD에 적용되도록 한다.
			if(flg.equals("B")){
				// Pendulum Service인 경우 항비 배분 테이블을 조회하여 Financial VVD를 체크하여야함
				boolean isFinancialVVD = false;
				PsoPortExpnDivVO psoPortExpnDivVO = new PsoPortExpnDivVO();
				psoPortExpnDivVO.setSlanCd(voIn.getRlaneCd().substring(0, 3));
				psoPortExpnDivVO.setSkdDirCd(voIn.getSkdDirCd());
				psoPortExpnDivVO.setLocCd(voIn.getYdCd().substring(0, 5));
				psoPortExpnDivVO.setRlaneCd(voIn.getRlaneCd());
				List<PsoPortExpnDivVO> psoPortExpnDivVOs = dbDao.searchPsoPortExpnDivByLocCd(psoPortExpnDivVO);
				if(psoPortExpnDivVOs!=null && psoPortExpnDivVOs.size()>0){
					for(PsoPortExpnDivVO vo : psoPortExpnDivVOs){
						if(vo.getRlaneCd().equals(voIn.getRlaneCd())){
							isFinancialVVD = true;
							break;
						}
					}
					
					// Pendulum Service 이나 Financial VVD가 아닌 경우 통항비 계산하지 않음
					if(!isFinancialVVD){
						return new PsoTgtYdExpnVO[]{null, null};
					}
				}
			}

			String usdAmt = "";
			if(flg != null){
				if(flg.equals("B"))//Batch Budget이면
					usdAmt = dbDao.getUsdAmtBudget(voIn.getInvLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
				else
					usdAmt = dbDao.getUsdAmt(voIn.getInvLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
			}
			else
				usdAmt = dbDao.getUsdAmt(voIn.getInvLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
//						usdAmt = "|2";
			String usdAmts[] = usdAmt.split("\\|", 2);
			if(usdAmts.length>=2){
				if(usdAmts[0].equals("")){
					voOutBnd.setInvUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
				}
				else{
					voOutBnd.setInvUsdAmt(usdAmts[0]);
				}
			}

			String strRlanceCd = dbDao.getRlaneCd(
					 voIn.getVslCd()
					,voIn.getSkdVoyNo()
					,voIn.getSkdDirCd()
					,voIn.getYdCd().substring(0, 5));
			
			// CHM-201007130-01
			// Batch Budget인 경우
			if("B".equals(flg)){
				strRlanceCd = voIn.getRlaneCd();
			}
			
			voOutBnd.setRlaneCd(strRlanceCd);
			
		}
		else{
			
			InvAuditDataValidVO vo = new InvAuditDataValidVO();
			vo.setVslCd(voIn.getVslCd());
			vo.setSkdVoyNo(voIn.getSkdVoyNo());
			vo.setSkdDirCd(voIn.getSkdDirCd());
			vo.setYdCd(voIn.getYdCd());
			vo.setRevYrmon(voIn.getRevYrmon());
			
			//--> 
			// Budget 이냐 Estimate이냐... 
			//
			if(flg != null){
				if(flg.equals("B")){//Batch Budget이면
					vo.setOrgFlg("B");
					vo.setBudScnrNo(voIn.getPagerows());
				}
				else if(flg.equals("M")){//--> Monthly Estimate Batch 
					vo.setOrgFlg("M");
				}
				else if(flg.equals("X")){//--> Monthly Estimate Batch 
					vo.setOrgFlg("M");
				}
				else
					vo.setOrgFlg("E");
			}
			else
				vo.setOrgFlg("E");
			
			vo.setRlaneCd(voIn.getRlaneCd());//2009.12.16. added
				
			List<IoRatioVO> rList = dbDao.getIoRatio(vo);
			if(rList != null){
				
				if(rList.size() == 0){//OutBound 100%
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
					voOutBnd.setVndrSeq(voIn.getVndrSeq());	//[2010.03.08:jmh]
					
					//----------------> 2009.12.10.
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
						if(flg.equals("B"))//Batch Budget이면
							usdAmt = dbDao.getUsdAmtBudget(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
						else
							usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
					}
					else
						usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
					
//					usdAmt = "|2";
					String usdAmts[] = usdAmt.split("\\|", 2);
					if(usdAmts.length>=2){
						if(usdAmts[0].equals("")){
							voOutBnd.setInvUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
						}
						else{
							voOutBnd.setInvUsdAmt(usdAmts[0]);
						}
					}
					String strRlanceCd = dbDao.getRlaneCd(
							 voIn.getVslCd()
							,voIn.getSkdVoyNo()
							,voIn.getSkdDirCd()
							,voIn.getYdCd().substring(0, 5));
					
					// CHM-201007130-01
					// Batch Budget인 경우
					if("B".equals(flg)){
						strRlanceCd = voIn.getRlaneCd();
					}
					
					voOutBnd.setRlaneCd(strRlanceCd);
				}
				else if(rList.size() == 2){//in out bound 2 record insert 
					voInBnd = new PsoTgtYdExpnVO();
					voOutBnd = new PsoTgtYdExpnVO();
					IoRatioVO rvo1 = rList.get(0);
					IoRatioVO rvo2 = rList.get(1);
					voOutBnd.setPsoBztpCd(voIn.getPsoBztpCd());
					voOutBnd.setVslCd(rvo1.getVslCd()); //Ratio에서 구한 VVD로 설정 
					voOutBnd.setSkdVoyNo(rvo1.getSkdVoyNo());
					voOutBnd.setSkdDirCd(rvo1.getSkdDirCd());
					voOutBnd.setRevYrmon(rvo1.getRevYrmon());
					voOutBnd.setYdCd(voIn.getYdCd());
					voOutBnd.setLgsCostCd(voIn.getLgsCostCd());
					voOutBnd.setInvLoclAmt(voIn.getInvLoclAmt());
					voOutBnd.setInvUsdAmt(voIn.getInvUsdAmt());
					voOutBnd.setRlaneCd(rvo1.getRlaneCd());
					voOutBnd.setVndrSeq(voIn.getVndrSeq());	//[2010.03.08:jmh]
					
					voOutBnd.setIoBndCd("O");
					voOutBnd.setLoclCurrCd(voIn.getLoclCurrCd());
					
					RoundTruncVO rtvo1in = new RoundTruncVO();
					rtvo1in.setIoBndCd("O");
					rtvo1in.setRatio(rvo1.getObRto());
					rtvo1in.setCurrCd(voIn.getLoclCurrCd());
					rtvo1in.setLoclAmt(voIn.getInvLoclAmt());
					
					if(rtvo1in.getRatio().equals("")||rtvo1in.getRatio()==null)
						rtvo1in.setRatio("50");
					RoundTruncVO rtvo1out = dbDao.getRoundTruncAmt(rtvo1in);
					
					voOutBnd.setInvLoclAmt(rtvo1out.getLoclAmt());
//								vo1.setUsdAmt("");//계산식으로 구해야 될 부분
					String usdAmt = "";
					if(flg != null){
						if(flg.equals("B"))//Batch Budget이면
							usdAmt = dbDao.getUsdAmtBudget(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
						else
							usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
					}
					else
						usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
					String usdAmts[] = usdAmt.split("\\|", 2);
					if(usdAmts.length>=2){
						if(usdAmts[0].equals("")){
							voOutBnd.setInvUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
						}
						else{
							voOutBnd.setInvUsdAmt(usdAmts[0]);
						}
					}
					
					//from here InBnd
					if(!rvo2.getIbRto().equals("0")) {
						voInBnd.setPsoBztpCd(voIn.getPsoBztpCd());
						voInBnd.setVslCd(rvo2.getVslCd());//Ratio에서 구한 VVD로 설정 
						voInBnd.setSkdVoyNo(rvo2.getSkdVoyNo());
						voInBnd.setSkdDirCd(rvo2.getSkdDirCd());
						voInBnd.setRevYrmon(rvo2.getRevYrmon());
						voInBnd.setYdCd(voIn.getYdCd());
						voInBnd.setLgsCostCd(voIn.getLgsCostCd());
						voInBnd.setInvLoclAmt(voIn.getInvLoclAmt());
						voInBnd.setInvUsdAmt(voIn.getInvUsdAmt());
						voInBnd.setRlaneCd(rvo2.getRlaneCd());
						voInBnd.setIoBndCd("I");
						voInBnd.setLoclCurrCd(voIn.getLoclCurrCd());
						voInBnd.setVndrSeq(voIn.getVndrSeq());	//[2010.03.08:jmh]
						
						RoundTruncVO rtvo2in = new RoundTruncVO();
						rtvo2in.setIoBndCd("I");
						rtvo2in.setRatio(rvo2.getIbRto());
						rtvo2in.setCurrCd(voIn.getLoclCurrCd());
						rtvo2in.setLoclAmt(voIn.getInvLoclAmt());
	
						RoundTruncVO rtvo2out = dbDao.getRoundTruncAmt(rtvo2in);
						
						voInBnd.setInvLoclAmt(rtvo2out.getLoclAmt());
	//								vo1.setUsdAmt("");//계산식으로 구해야 될 부분
						String usdAmt2 = "";
						if(flg != null){
							if(flg.equals("B"))//Batch Budget이면
								usdAmt2 = dbDao.getUsdAmtBudget(rtvo2out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
							else
								usdAmt2 = dbDao.getUsdAmt(rtvo2out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
						}
						else
							usdAmt2 = dbDao.getUsdAmt(rtvo2out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
						String usdAmts2[] = usdAmt2.split("\\|", 2);
						if(usdAmts2.length>=2){
							if(usdAmts[0].equals("")){
								voInBnd.setInvUsdAmt(usdAmts2[1]);//계산식으로 구해야 될 부분 
							}
							else{
								voInBnd.setInvUsdAmt(usdAmts2[0]);
							}
						}
					}else{
					
						// IB Ratio가 0인 경우에는 O/B 100%로 계산될 수 있도록 Bound 값을 null로 넘김.
						voInBnd = null;
					}
				}//end of else if 
				else{
					IoRatioVO rvo1 = rList.get(0);
					//OUT BOUND 100%로 처리 
					voOutBnd = new PsoTgtYdExpnVO();
					voOutBnd.setPsoBztpCd(voIn.getPsoBztpCd());
					voOutBnd.setVslCd(rvo1.getVslCd());
					voOutBnd.setSkdVoyNo(rvo1.getSkdVoyNo());
					voOutBnd.setSkdDirCd(rvo1.getSkdDirCd());
					voOutBnd.setRevYrmon(rvo1.getRevYrmon());
					voOutBnd.setYdCd(voIn.getYdCd());
					voOutBnd.setLgsCostCd(voIn.getLgsCostCd());
					voOutBnd.setInvLoclAmt(voIn.getInvLoclAmt());
					voOutBnd.setInvUsdAmt(voIn.getInvUsdAmt());
					//voOutBnd.setIoBndCd("O");
					voOutBnd.setLoclCurrCd(voIn.getLoclCurrCd());
					voOutBnd.setVndrSeq(voIn.getVndrSeq());	//[2010.03.08:jmh]
					
					//----------------> 2009.12.10.
					RoundTruncVO rtvo1in = new RoundTruncVO();
					if(!rvo1.getIbRto().equals("0")){//-->2009.12.15 added
						voOutBnd.setIoBndCd("I");
						rtvo1in.setIoBndCd("I");
						
						if(flg != null){
							// CHM-201109850-01
							// Object의 갯수가 1개 이므로 IN으로 전용(100%) 처리
							if(flg.equals("X") || "Y".equals(voIn.getIbflag())){
								rtvo1in.setRatio("100");
							}else{
								rtvo1in.setRatio(rvo1.getIbRto());
							}
						}else
							rtvo1in.setRatio(rvo1.getIbRto());
							
					}
					else{
						voOutBnd.setIoBndCd("O");
						rtvo1in.setIoBndCd("O");
						
						if(flg != null){
							// CHM-201109850-01
							// Object의 갯수가 1개 이므로 OUT으로 전용(100%) 처리
							if(flg.equals("X") || "Y".equals(voIn.getIbflag()))
								rtvo1in.setRatio("100");
							else
								rtvo1in.setRatio(rvo1.getObRto());
						}else
							rtvo1in.setRatio(rvo1.getObRto());
					}
					rtvo1in.setCurrCd(voIn.getLoclCurrCd());
					rtvo1in.setLoclAmt(voIn.getInvLoclAmt());
					
					RoundTruncVO rtvo1out = dbDao.getRoundTruncAmt(rtvo1in);
					
					voOutBnd.setInvLoclAmt(rtvo1out.getLoclAmt());
					//<------------------
					String usdAmt = "";
					if(flg != null){
						if(flg.equals("B"))//Batch Budget이면
							usdAmt = dbDao.getUsdAmtBudget(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
						else
							usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
					}
					else
						usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
//					usdAmt = "|2";
					String usdAmts[] = usdAmt.split("\\|", 2);
					if(usdAmts.length>=2){
						if(usdAmts[0].equals("")){
							voOutBnd.setInvUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
						}
						else{
							voOutBnd.setInvUsdAmt(usdAmts[0]);
						}
					}
					
					String strRlanceCd = dbDao.getRlaneCd(
							 voIn.getVslCd()
							,voIn.getSkdVoyNo()
							,voIn.getSkdDirCd()
							,voIn.getYdCd().substring(0, 5));
					
					// CHM-201007130-01
					// Batch Budget인 경우
					if("B".equals(flg)){
						strRlanceCd = voIn.getRlaneCd();
					}
					
					voOutBnd.setRlaneCd(strRlanceCd);
										
				}
//						Logger.debug("IORatio List Size:="+rList.size()+"");
			}//end of if(rList != null) 
			else{//OUT BOUND 100%로 처리 
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
				voOutBnd.setVndrSeq(voIn.getVndrSeq());	//[2010.03.08:jmh]
				
				//----------------> 2009.12.10.
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
					if(flg.equals("B"))//Batch Budget이면
						usdAmt = dbDao.getUsdAmtBudget(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getPagerows());
					else
						usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
				}
				else
					usdAmt = dbDao.getUsdAmt(rtvo1out.getLoclAmt(), voIn.getLoclCurrCd(), voIn.getRevYrmon(), "3");
//				usdAmt = "|2";
				String usdAmts[] = usdAmt.split("\\|", 2);
				if(usdAmts.length>=2){
					if(usdAmts[0].equals("")){
						voOutBnd.setInvUsdAmt(usdAmts[1]);//계산식으로 구해야 될 부분 
					}
					else{
						voOutBnd.setInvUsdAmt(usdAmts[0]);
					}
				}
				String strRlanceCd = dbDao.getRlaneCd(
						 voIn.getVslCd()
						,voIn.getSkdVoyNo()
						,voIn.getSkdDirCd()
						,voIn.getYdCd().substring(0, 5));
				
				// CHM-201007130-01
				// Batch Budget인 경우
				if("B".equals(flg)){
					strRlanceCd = voIn.getRlaneCd();
				}
				
				voOutBnd.setRlaneCd(strRlanceCd);
			}
		}//end of else 
		
		if(voOutBnd != null){
			voOutBnd.setCreUsrId(voIn.getCreUsrId());
			voOutBnd.setUpdUsrId(voIn.getUpdUsrId());
			retVo[0] = voOutBnd;
		}
		else
			retVo[0] = null;
		if(voInBnd != null){
			voInBnd.setCreUsrId(voIn.getCreUsrId());
			voInBnd.setUpdUsrId(voIn.getUpdUsrId());
			retVo[1] = voInBnd;
		}
		else
			retVo[1] = null;
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Estimate Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Estimate Creation"}).getUserMessage(),ex);
		}
		return retVo;
	}
	/**
	 * 월별 Estimate Expense을 생성한다.
	 * @category VOP_PSO_0009_estimateCreationButtonClick
	 * @param String yyyymm
	 * @param String lanecd
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createEstExpnByMon(String yyyymm, String lanecd, String userId)
			throws EventException {
		// TODO Auto-generated method stub
		// Batch모듈을 직접 실행한다. 
		ScheduleUtil su = new ScheduleUtil();
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다. 
		boolean bIsRunning;
		try {
			bIsRunning = su.isRunning("VOP_PSO_B003");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Estimate Creation"}).getUserMessage(),e);
		}//2009.08.27 005에서 003으로 변경 
		log.error("\nbIsRunning>> " + bIsRunning);
		if(bIsRunning)
			return "6";//진행 중
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
			return "4";//실행 성공
		}
	}

	/**
	 * 년도별 사업 계획을 생성한다.
	 * @category VOP_PSO_0008_creationButtonClick
	 * @param String startDt
	 * @param String endDt
	 * @param String scrNo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String generateYearBudgetPlan(String startDt, String endDt, String scrNo, String userId)
			throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다. 
		boolean bIsRunning = false;
		try {
			bIsRunning = su.isRunning("VOP_PSO_B002");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getMessage(),e);
		}//004에서 002로 대체 2009.08.27 
		
		if(bIsRunning)
			return "6";//진행 중
		else{
			try {
				//VOP_PSO_B002 no-use-data#2010-01#2010-01#PSOTEST#C
				su.directExecuteJob("VOP_PSO_B002","no-use-data"+"#"+startDt+"#"+endDt+"#"+userId+"#"+"C"+"#"+scrNo);
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Creation"}).getMessage(),e);
			}
			return "4";//실행 성공
		}
	}

	/**
	 * VVD별 Expense Plan (Pop-Up) 조회
	 * @category VOP_PSO_0201_windowOpen
	 * @param BudEstDtlCondVO budEstDtlCondVO
	 * @return List<BudEstSumByMonVO>
	 * @exception EventException
	 */
	public List<BudEstSumByMonVO> searchBudEstDtlByMonCost(
			BudEstDtlCondVO budEstDtlCondVO) throws EventException {
		try {
			return dbDao.searchBudEstDtlByMonCost(budEstDtlCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Expense Plan Per VVD"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Expense Plan Per VVD"}).getUserMessage(),ex);
		}
	}

	/**
	 * 메인 리스트에서 선택한 VVD 별 Budget 정보를 재 생성한다. <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param PortChgBudByYearVO[] portChgBudByYearVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBudget(PortChgBudByYearVO[] portChgBudByYearVOs,
					SignOnUserAccount account)throws EventException{
		GeneralInvoiceAuditBC generalInvoiceAuditBCImpl = new GeneralInvoiceAuditBCImpl();//2-phase commit
		CalcTariffVO calcTariffVO = new CalcTariffVO();
		for(int i=0; i<portChgBudByYearVOs.length;i++){
			PortChgBudByYearVO vo = portChgBudByYearVOs[i];
			List<PsoYdChgVO> list = null;
			
			//delete 먼저 
			PsoTgtYdExpnVO delVO = new PsoTgtYdExpnVO();
			delVO.setPsoBztpCd("1");
			delVO.setVslCd(vo.getVslCd());
			delVO.setSkdVoyNo(vo.getSkdVoyNo());
			delVO.setSkdDirCd(vo.getSkdDirCd());
			delVO.setRevYrmon(vo.getExpnYrmon());
			delVO.setBudScnrNo(getBudScnrNo(vo.getVslCd(), vo.getSkdVoyNo(), vo.getSkdDirCd(), vo.getExpnYrmon()));
			try {
				dbDao.deleteTgtYdExpn(delVO,"BAT");
			} catch (DAOException ex) {
	 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation : deleteTgtYdExpn"}).getMessage(),ex);
	 		} catch (Exception ex) {
	 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation : deleteTgtYdExpn"}).getMessage(),ex);
	 		}   
			
			//VVD 및 해당 revYrmon 과 관련된 Yard Charge 정보를 select 한다. 
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
					String cntrVslClssCapa = vo.getVslCls();//화면에서 받은 vsl_cls를 사용 
					String vndrSeq = ydChgVO.getVndrSeq();

					//Calc를 위한 파라미터 Input...
					calcTariffVO.setVvd(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());//vvd
					calcTariffVO.setYdChgNo(ydChgNo);
					calcTariffVO.setYdChgVerSeq(ydChgVerSeq);
					calcTariffVO.setYdCd(ydCd);
					calcTariffVO.setLgsCostCd(lgsCostCd);
					calcTariffVO.setCurrCd(currCd);//"USD"); 2009.12.10 fix
					calcTariffVO.setIoFlag("Budget");//InBound/OutBound구분
					calcTariffVO.setCntrVslClssCapa(cntrVslClssCapa);//TBN# 항차 대응

//					if("HNSF0701W".equals(calcTariffVO.getVvd())
//							&& "AUBNEY1".equals(ydCd)
//							&& "PTSVTW".equals(lgsCostCd)
//					){
//						int k = 0;
//						k++;
//					}//Debug Code Block 2010.01.12 added
					
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
				
					//TODO :구해야될 넘. 
					
					String budScnrNo = getBudScnrNo(vslCd,  skdVoyNo, skdDirCd, vo.getExpnYrmon());
					
					//INBOUND/OUTBOUND의 구분에 따라 분기 처리 
					PsoTgtYdExpnVO voIn = new PsoTgtYdExpnVO(); 
					voIn.setIbflag("B");//이곳에 구분자로 설정 
					voIn.setPagerows(budScnrNo);//임의 필드 설정 
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
//									voOuts[0].getIoBndCd()/* In/Out Bound 구분 */, /* "", *//*
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
							insertvo.setBudScnrNo(budScnrNo);
							try {
								//기존 데이터 삭제 
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
//									voOuts[1].getIoBndCd()/* In/Out Bound 구분 */, /* "", *//*
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
							insertvo.setBudScnrNo(budScnrNo);
							try {
								//기존 데이터 삭제 
//								dbDao.deleteTgtYdExpn(insertvo,"BAT");
								dbDao.insertTgtYdExpn(insertvo,"BAT");
							} catch (DAOException ex) {
								throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getMessage(),ex);
					 		} catch (Exception ex) {
					 			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Budget Expense Creation"}).getMessage(),ex);
					 		}    
						}
					}
					else{//IO구분이 없으면
						if(strLocalAmt == null)
							strLocalAmt = "";
						else{//Usd AMT를 구한다. 
							String usdAmt = generalInvoiceAuditBCImpl.getUsdAmt(strLocalAmt, currCd, budScnrNo, "B");
							String usdAmts[] = usdAmt.split("\\|", 2);
							if(usdAmts.length>=2){
								if(usdAmts[0].equals("")){
									strUsdAmt=usdAmts[1];//계산식으로 구해야 될 부분 
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
//								"B"/* In/Out Bound 구분 */, /* "", *//*
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
						insertvo.setBudScnrNo(budScnrNo);
						try {
							//기존 데이터 삭제 
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
//					//INSERT 권한문제로 잠시 막음. 2009.09.21
//					try {
//						//기존 데이터 삭제 
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
	 * BudScnrNo를 구한다.
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String budYrmon
	 * @return String 
	 * @throws EventException
	 */
	private String getBudScnrNo(String vslCd, String skdVoyNo, String skdDirCd,
			String budYrmon) throws EventException {
		try {
 			return dbDao.getBudScnrNo(vslCd, skdVoyNo, skdDirCd, budYrmon);
 		} catch (DAOException ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation:getBudScnrNo"}).getUserMessage(),ex);
 		} catch (Exception ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation:getBudScnrNo"}).getUserMessage(),ex);
 		}    
	}

	/**
	 * 메인 리스트에서 선택한 VVD 별 Budget 정보를 재 생성한다. <br />
	 * @category VOP_PSO_0035_CreationButtonClick
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String revYrmon
	 * @return List<PsoYdChgVO>
	 * @exception EventException
	 */
	public List<PsoYdChgVO> searchYardChargeByVvd(String vslCd,
			String skdVoyNo, String skdDirCd, String revYrmon)
			throws EventException {
		try {
 			return dbDao.searchYardChargeByVvd(vslCd, skdVoyNo, skdDirCd, revYrmon);
 		} catch (DAOException ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation"}).getUserMessage(),ex);
 		} catch (Exception ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Expense Creation"}).getUserMessage(),ex);
 		}    
	}

	/**
	 * 선택한 VVD 별 Expense Detail 정보를 표시한다. <br />
	 * @category VOP_PSO_0213_Open
	 * @param ExpnDtlVO expnDtlVO
	 * @return List<ExpnDtlVO> 
	 * @exception EventException
	 */
	public List<ExpnDtlVO> searchExpenseDetail(ExpnDtlVO expnDtlVO)
			throws EventException {
		try {
			return dbDao.searchExpenseDetail(expnDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Expense Detail"}).getUserMessage(),ex);
 		} catch (Exception ex) {
 			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Expense Detail"}).getUserMessage(),ex);
 		}    
	}

	/**
	 * PSO 모쥴에 운하 통항 대상 VVD 정보를 VSK 로 부터 요청 받아서 생성한다.
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
					dbDao.modifySppTargetYdSkd(portCd, tgtDate, "6", account);
				}
			} else{
				dbDao.addSppTargetVvd(portCd, tgtDate, "5", account);
				dbDao.addSppTargetYdSkd(portCd, tgtDate, "5", account);
				dbDao.modifySppTargetYdSkd(portCd, tgtDate, "5", account);

				if(port.equals("PAPAC")){
					dbDao.addSppTargetVvd(portCd, tgtDate, "6", account);
					dbDao.addSppTargetYdSkd(portCd, tgtDate, "6", account);			
					dbDao.modifySppTargetYdSkd(portCd, tgtDate, "6", account);	
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Target VVD Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Target VVD Creation"}).getUserMessage(),ex);
		}			
	}

	/**
	 * 해당 VVD가 Turning Port인지 확인한다.
	 * @param String hvvd
	 * @param String tmnlCode
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkTurningPort(String hvvd, String tmnlCode)
			throws EventException {
		try {
			return dbDao.checkTurningPort(hvvd, tmnlCode);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Target VVD Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Target VVD Creation"}).getUserMessage(),ex);
		}	
	}

	/**
	 * BudgetExpenseCreation Batch 모듈에서 Bud_Yrmon 의 값을 구한다.
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
	 * Invoice Summary Detail을 조회한다.
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
	
	/*
	 * CHM-201006714-01 추정결산 로직 보완
	 */
	/**
	 * Interface To ERP 정보를 생성한다.
	 * @category VOP_PSO_0013
	 * @param ErpSumVO erpSumVO
	 * @return String
	 * @throws EventException
	 */
	public String createInterfaceToERP(ErpSumVO erpSumVO) throws EventException{
		// Batch모듈을 직접 실행한다. 
		ScheduleUtil su = new ScheduleUtil();
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다. 
		boolean bIsRunning;
		String yyyymm = "";
		String userId = erpSumVO.getCreUsrId();
		String lanecd = "ALL";
		try {
			bIsRunning = su.isRunning("VOP_PSO_B003");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Interface to ERP"}).getUserMessage(),e);
		}
		log.error("\nbIsRunning>> " + bIsRunning);
		if(bIsRunning){
			return "6";//진행 중
		}else{
			try {
				su.directExecuteJob("VOP_PSO_B003", "no-use-data"+"#"+yyyymm+"#"+userId+"#"+lanecd+"#2");
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Interface to ERP"}).getUserMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Interface to ERP"}).getUserMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Interface to ERP"}).getUserMessage(),e);
			}
			return "4";//실행 성공
		}
	}
	
	/**
	 * VOP_PSO_0008 Budget Creation 조회
	 * @category VOP_PSO_0008_Retrieve (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @param String scrNo
	 * @return List<BudCreVO>
	 * @throws EventException
	 */
	public List<BudCreVO> searchBudCreByMon(String startDt, String endDt, String scrNo) throws EventException {
		try {
			return dbDao.searchBudCreByMon(startDt, endDt, scrNo);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Creation"}).getMessage(), de);
		}
	}
	
	/**
	 * VOP_PSO_0008 Budget Creation 환율조회
	 * @category VOP_PSO_0008_Retrieve (jmh)
	 * @param String startDt
	 * @param String endDt
	 * @param String scrNo
	 * @return List<BudCreVO>
	 * @throws EventException
	 */
	public List<BudCreVO> searchBudCreByCurrency(String startDt, String endDt, String scrNo) throws EventException {
		try {
			return dbDao.searchBudCreByCurrency(startDt, endDt, scrNo);
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Budget Creation"}).getMessage(), de);
		}
	}
	
	/**
	 * VOP_PSO_0009 Estimate Creation 조회
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
	 * Batch 모듈이 실행 중인지 확인한다. 
	 * @category VOP_PSO_0009	(jmh)
	 * @param String batchID
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkRunningBatch(String batchID) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다. 
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
	 * VVD 단위 Tariff Simulation의 실행 상태를 확인한다.
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
		
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다.
		try {
			bIsRunning = su.isRunning("VOP_PSO_B004");
			
			if(bIsRunning){
				batchRunningStatus = "6";//진행 중
			}else{
				PsoTgtVvdVO psoTgtVvdVO = null;
				for(SearchPortTariffListVO searchPortTariffListVO : searchPortTariffListVOs){
					psoTgtVvdVO = new PsoTgtVvdVO();
					psoTgtVvdVO.setPsoBztpCd("7");
					psoTgtVvdVO.setVslCd(searchPortTariffListVO.getVslCd());
					psoTgtVvdVO.setSkdVoyNo(searchPortTariffListVO.getSkdVoyNo());
					psoTgtVvdVO.setSkdDirCd(searchPortTariffListVO.getSkdDirCd());
					count = dbDao.searchVvdExpenseSimulationStatus(psoTgtVvdVO); // 하나의 VVD라도 중복 실행되면 안되므로 진행중으로 처리
					if(count>0){
						batchRunningStatus = "6"; // 진행중
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
	 * VVD 단위 Tariff Simulation Setup을 실행한다.
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
				psoTgtVvdVO.setVslCd(searchPortTariffListVO.getVslCd());
				psoTgtVvdVO.setSkdVoyNo(searchPortTariffListVO.getSkdVoyNo());
				psoTgtVvdVO.setSkdDirCd(searchPortTariffListVO.getSkdDirCd());
				psoTgtVvdVO.setCreUsrId(account.getUsr_id());
				psoTgtVvdVO.setUpdUsrId(account.getUsr_id());
				psoTgtVvdVOs.add(psoTgtVvdVO);
			}
			if("I".equals(processType)){
				count = dbDao.addVvdExpenseSimulationSetup(psoTgtVvdVOs); // 대상항차 입력
				if(count!=psoTgtVvdVOs.size()){
					throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage());
				}
			}else if("D".equals(processType)){
				dbDao.removeVvdExpenseSimulationSetup(psoTgtVvdVO.getPsoBztpCd()); // 해당 PSO_BZTP_CD 값을 가지는 대상항차 모두 삭제  
			}
			else {
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage());
			}
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
		}
		
	}
	
	/**
	 * VVD 단위 Tariff Simulation의 실행 상태를 확인한다. (MAS용)
	 * 
	 * @param SearchPortTariffListMasVO[] searchPortTariffListMasVOs
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdExpenseSimulationStatusMas(SearchPortTariffListMasVO[] searchPortTariffListMasVOs) throws EventException {
		
		ScheduleUtil su = new ScheduleUtil();
		boolean bIsRunning = false;
		String batchRunningStatus = "";
		int count = 0;
		
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다.
		try {
			bIsRunning = su.isRunning("VOP_PSO_B004");
			
			if(bIsRunning){
		    	batchRunningStatus = "6";//진행 중
			}else{
				PsoTgtVvdVO psoTgtVvdVO = null;
				for(SearchPortTariffListMasVO searchPortTariffListMasVO : searchPortTariffListMasVOs){
					psoTgtVvdVO = new PsoTgtVvdVO();
					psoTgtVvdVO.setPsoBztpCd("7");
					psoTgtVvdVO.setVslCd(searchPortTariffListMasVO.getVslCd());
					psoTgtVvdVO.setSkdVoyNo(searchPortTariffListMasVO.getSkdVoyNo());
					psoTgtVvdVO.setSkdDirCd(searchPortTariffListMasVO.getSkdDirCd());
					count = dbDao.searchVvdExpenseSimulationStatus(psoTgtVvdVO); // 하나의 VVD라도 중복 실행되면 안되므로 진행중으로 처리
					if(count>0){
						batchRunningStatus = "6"; // 진행중
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
	 * VVD 단위 Tariff Simulation Setup을 실행한다. (MAS용)
	 * 
	 * @param SearchPortTariffListMasVO[] searchPortTariffListMasVOs
	 * @param String processType
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageVvdExpenseSimulationSetupMas(SearchPortTariffListMasVO[] searchPortTariffListMasVOs, String processType, SignOnUserAccount account) throws EventException {
		List<PsoTgtVvdVO> psoTgtVvdVOs = new ArrayList<PsoTgtVvdVO>();
		PsoTgtVvdVO psoTgtVvdVO = null;
		int count = 0;
		try{
			for(SearchPortTariffListMasVO searchPortTariffListMasVO : searchPortTariffListMasVOs){
				psoTgtVvdVO = new PsoTgtVvdVO();
				psoTgtVvdVO.setPsoBztpCd("7");
				psoTgtVvdVO.setVslCd(searchPortTariffListMasVO.getVslCd());
				psoTgtVvdVO.setSkdVoyNo(searchPortTariffListMasVO.getSkdVoyNo());
				psoTgtVvdVO.setSkdDirCd(searchPortTariffListMasVO.getSkdDirCd());
				psoTgtVvdVO.setCreUsrId(account.getUsr_id());
				psoTgtVvdVO.setUpdUsrId(account.getUsr_id());
				psoTgtVvdVOs.add(psoTgtVvdVO);
			}
			if("I".equals(processType)){
				count = dbDao.addVvdExpenseSimulationSetup(psoTgtVvdVOs); // 대상항차 입력
				if(count!=psoTgtVvdVOs.size()){
					throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage());
				}
			}else if("D".equals(processType)){
				dbDao.removeVvdExpenseSimulationSetup(psoTgtVvdVO.getPsoBztpCd()); // 해당 PSO_BZTP_CD 값을 가지는 대상항차 모두 삭제  
			}
			else{
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage());
			}
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
		}
		
	}
	
	/**
	 * VVD 단위 Tariff Simulation을 실행한다.
	 *
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String manageVvdExpenseSimulation(SignOnUserAccount account) throws EventException {
		
		ScheduleUtil su = new ScheduleUtil();
		//실행 전 해당 Batch 모듈이 실행 중인지 확인한다. 
		boolean bIsRunning = false;				
		try {
			bIsRunning = su.isRunning("VOP_PSO_B004");
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"VVD Expense Simulation"}).getMessage(),e);
		}
		
		if(bIsRunning){
			return "6";//진행 중
		}else{
			try {
				su.directExecuteJob("VOP_PSO_B004","no-use-data#"+account.getUsr_id()+"#N"); // Expense Ratio 적용하지 않음 2011.10.28 CHM-201114305-01
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
			return "4";//실행 성공
		}
	}
}