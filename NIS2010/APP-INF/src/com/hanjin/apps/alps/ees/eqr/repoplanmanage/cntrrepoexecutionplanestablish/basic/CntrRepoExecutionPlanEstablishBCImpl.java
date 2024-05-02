/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishBCImpl.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*-----------------------------------------------------------------------------
*	No.    Ver.		Modifier		Modifier Date		Explanation
*-----------------------------------------------------------------------------
*  1			yongchan shin		2006-11-20			1.0 최초 생성
*				shin yongchan		2008-01-29			CSR No : R200801154869
*				yongchan shin		2008-08-04			CSR No : N200807310009 - Senator S/O Send, S/O Cancle 방식변경 EAT --> WTC
*				shin yongchan							CSR No : N200811110007 - TRS에서 1개씩 S/O 입력되는 것중에 동일 ROUTE로 이동하는 것은 N개로 집합 
																				execute ,중복이 존재하는지 검색, 존재하면 ref id 를 얻어옴 
*  3			yongchan shin		2009-05-06			CSR No : N200905060050 - &repoPlnWeek="+repoPlnWeek+" 항목 추가 (SPLIT BOOKING 대상 조회 WEEK 시작주차 기준 변경) - 계은영 요청  
*  4			Haeng-ji,Lee		2009-05-29			CSR No : N200904300440 - NIS BOOKING VOL과 차이가 나는 경우 Fixed Plan QTY 수정하도록 하기위한 변수선언
*				Haeng-Ji Lee		2009-01-07			CSR No : N200901060030 - Oranization Chart에서 (RCC, LCC, ECC, SCC) 에 대한 갯수를 초기화면에 DISPLAY
*  5			Haeng-ji,Lee		2009-06-08			CSR No : R200906030002 - Fixed Plan Process 보완
*  6			Chang-Ho Chae		2009-06-11			CSR No : N200906040080 - EQR 실행계획 하면 조회기능 변경 요청(Fm ETD, To ETA조건 추가)
*  7			yongchan shin		2009-07-01			CSR No : N200906300060 - BKG CRE, BKG SPLIT CRE 경우 FROM LOC = 'EGAIS' 인 경우 RCC를 무조건 'DEHAM'으로 하드코딩
*														CSR No : R200903270008 - 소스 품질 개선(메소드 파라미터 삭제로 인한 메소드 호출방식 변경)
*	8			Lee Byoung Hun	2010.05.11			CSR No : CHM-201003779 - EES_EQR_0143(EQR All-Weeks' Plan Access Grant) 이벤트 처리 추가
*	9			Lee Byoung Hun	2010.12.03			CSR No : CHM-201007500 - [ERQ & TRS] MX 지역에 대한 EQ control office (S/O office) 지정로직 변경 요청
*-----------------------------------------------------------------------------
*@LastModifyDate : 2009.08.13
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.13 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishEAIDAO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.CheckBkgVolumeTargetVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0081MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0083MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0112ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0113ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0130ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgCntrVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchBeforeCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCntrRepoExecutionPlanEstablishVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrAllWeeksPlanAccessGrantVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOnfHirExePlnByOffHireReturnVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOrganizationVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoExcelVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrListVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanSplitCntrVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchSendHistoryVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyVvdVO;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrEccInterExePlnQtyVO;
import com.hanjin.syscommon.common.table.EqrEccInterExePlnVO;
import com.hanjin.syscommon.common.table.EqrExePlnCntrVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspExePlnQtyVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspExePlnVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspPlnQtyVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspPlnVO;
import com.hanjin.syscommon.common.table.EqrOnfHirExePlnQtyVO;
import com.hanjin.syscommon.common.table.EqrOnfHirExePlnVO;
import com.hanjin.syscommon.common.table.EqrOnfHirPlnQtyVO;
import com.hanjin.syscommon.common.table.EqrOnfHirPlnVO;
import com.hanjin.syscommon.common.table.EqrRepoExeSoIfVO;
import com.hanjin.syscommon.common.table.EqrVslExePlnQtyVO;
import com.hanjin.syscommon.common.table.EqrVslLodgDchgExePlnVO;
import com.hanjin.syscommon.common.table.EqrVslLodgDchgPlnQtyVO;

/**
 * ALPS-RepoPlanManage Business Logic Basic Command implementation<br>
 * - ALPS-RepoPlanManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0059EventResponse,CntrRepoExecutionPlanEstablishBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrRepoExecutionPlanEstablishBCImpl extends BasicCommandSupport implements CntrRepoExecutionPlanEstablishBC {

	// Database Access Object
	private transient CntrRepoExecutionPlanEstablishDBDAO dbDao = null;

	/**
	 * CntrRepoExecutionPlanEstablishBCImpl 객체 생성<br>
	 * CntrRepoExecutionPlanEstablishDBDAO를 생성한다.<br>
	 */
	public CntrRepoExecutionPlanEstablishBCImpl() {
		dbDao = new CntrRepoExecutionPlanEstablishDBDAO();
	}
	/**
	 * [EES_EQR_0059 : ]<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException {
		try {
			return dbDao.searchTrunkVesselAndFeederCntrRepoPlan(eesEqr0059ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * [EES_EQR_0059 : ]<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException {
		try {
			return dbDao.searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(eesEqr0059ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [EES_EQR_0059 : ]<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlanBKGNO(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException {
		try {
			return dbDao.searchTrunkVesselAndFeederCntrRepoPlanBKGNO(eesEqr0059ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0059 : ]<br>
	 * 
	 * @param eesEqr0059multiVOs	EesEqr0059MultiVO[] 
	 * @param account				SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyTrunkVesselAndFeederCntrRepoPlan(EesEqr0059MultiVO[] eesEqr0059multiVOs, SignOnUserAccount account) throws EventException {
		try {
			String repoPlnId = null;
			String refId = "";
			String fmYdCd = null;
			String toYdCd = null;
			String coCd = null;
			String trspModCd = null;
			String mtyBkgNo = null;
			String splitRepoPlnFlg = null;
			String cntrNo = null;
			String tpszNo = null;
			
			List<String> volList			= null;
			List<String> tpszList			= null;
			List<String> flagListArr		= null;
			List<String> unitcostListArr	= null;
			List<String> fromcostListArr	= null;
			List<String> tocostListArr		= null;
			
			String vol = null;    // type size별 vol 수량
			String unitcost = null;
	    	String fromcost = null;
	    	String tocost   = null;
	    	String[] tableCost = null;
	    	String ctnrTpszCd = null;
	    	String flag = null;
	    	String cntrDel = null;
	    	String oldBkgGrpNo = null;

			String usrId				= account.getUsr_id();
			
			if(eesEqr0059multiVOs != null && eesEqr0059multiVOs.length > 0){				
				for ( int i=0; i< eesEqr0059multiVOs.length; i++ ) {					
					repoPlnId		= eesEqr0059multiVOs[i].getRepoPlnId();
					fmYdCd			= eesEqr0059multiVOs[i].getFmYdCd();
					toYdCd			= eesEqr0059multiVOs[i].getToYdCd();
					coCd			= eesEqr0059multiVOs[i].getCoCd();
					trspModCd		= eesEqr0059multiVOs[i].getTrspModCd();
					mtyBkgNo		= eesEqr0059multiVOs[i].getMtyBkgNo();
					splitRepoPlnFlg	= eesEqr0059multiVOs[i].getSplitRepoPlnFlg();
					cntrNo			= eesEqr0059multiVOs[i].getCntrNo();
					tpszNo			= eesEqr0059multiVOs[i].getTpszNo();
					cntrDel			= eesEqr0059multiVOs[i].getCntrDel();
					
					tpszList			= eesEqr0059multiVOs[i].getTpszList();
					volList				= eesEqr0059multiVOs[i].getVolList();
					flagListArr			= eesEqr0059multiVOs[i].getFlagList();
					unitcostListArr		= eesEqr0059multiVOs[i].getUnitcostList();
					fromcostListArr		= eesEqr0059multiVOs[i].getFromcostList();
					tocostListArr		= eesEqr0059multiVOs[i].getTocostList();
					
					oldBkgGrpNo		= eesEqr0059multiVOs[i].getOldBkgGrpNo();
					
					if ( eesEqr0059multiVOs[i].getIbflag().equals("I") ){
						EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
						ObjectCloner.build(eesEqr0059multiVOs[i], eqrVslLodgDchgExePlnVO);
						
						if( splitRepoPlnFlg.equals("Y") && !mtyBkgNo.equals("") || 
							!splitRepoPlnFlg.equals("Y")){
							refId	= dbDao.makeRefIDCntrRepoPlan("EQR_VSL_LODG_DCHG_EXE_PLN", coCd, repoPlnId, fmYdCd, trspModCd);
						}

						// EXE Table[EQR_VSL_LODG_DCHG_EXE_PLN ] Setting..
						
						eqrVslLodgDchgExePlnVO.setRefId(refId);
						eqrVslLodgDchgExePlnVO.setCreUsrId(usrId);
						eqrVslLodgDchgExePlnVO.setUpdUsrId(usrId);
						eqrVslLodgDchgExePlnVO.setOldBkgGrpNo(oldBkgGrpNo);
						
						dbDao.modifyTrunkVesselAndFeederCntrRepoPlan("I",eqrVslLodgDchgExePlnVO);
						
						for ( int j=0; j < tpszList.size(); j++ ) {
							// QTY Table[EQR_VSL_EXE_Pln_QTY ] Setting..
							EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();
							ObjectCloner.build(eqrVslLodgDchgExePlnVO, eqrVslExePlnQtyVO);
							
							ctnrTpszCd	= tpszList.get(j);
							vol			= volList.get(j);
							unitcost	= unitcostListArr.get(j);
							fromcost	= fromcostListArr.get(j);
							tocost		= tocostListArr.get(j);
							flag		= flagListArr.get(j);
							
							// added by shin yongchan - 20080507		    	
					    	// CSR No : N200803140002
					       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
					       	if( unitcost.equals("0") || unitcost.equals("") ){
					       		tableCost = dbDao.searchUnitCost( "E", fmYdCd, toYdCd, trspModCd, ctnrTpszCd ).getResultStrArray();
					       		
					       		fromcost = tableCost[0];
					       		tocost   = tableCost[1];
					       		unitcost = tableCost[2];	
					       	}
					       	// added by shin yongchan - 20080507		    	
					    	// CSR No : N200803140002
					       	String lodgDchgCostAmt = String.valueOf( Integer.parseInt(vol) * Float.parseFloat(unitcost) );
					       	
					       	int ivol = 0;
					       	ivol = Integer.parseInt(vol);
					       	if ( ivol > 0) {
								eqrVslExePlnQtyVO.setCntrTpszCd(ctnrTpszCd);
								eqrVslExePlnQtyVO.setCntrQty(vol);
								eqrVslExePlnQtyVO.setPlnUcAmt(unitcost);
								eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost);
								eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost);
								eqrVslExePlnQtyVO.setLodgDchgCostAmt(lodgDchgCostAmt);
								eqrVslExePlnQtyVO.setCreUsrId(usrId);
								eqrVslExePlnQtyVO.setUpdUsrId(usrId);
								
								dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("I", eqrVslExePlnQtyVO);
					       	}
						}
						
						// EQR_EXE_PLN_CNTR Table Setting..
						if (!splitRepoPlnFlg.equals("Y") && cntrNo != null && !cntrNo.equals("")){
							EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
							ObjectCloner.build(eqrVslLodgDchgExePlnVO, eqrExePlnCntrVO);
							
							eqrExePlnCntrVO.setCntrNo(cntrNo);
							eqrExePlnCntrVO.setCntrTpszCd(tpszNo);
							eqrExePlnCntrVO.setCreUsrId(usrId);
							eqrExePlnCntrVO.setUpdUsrId(usrId);
							eqrExePlnCntrVO.setFmEccCd(eesEqr0059multiVOs[i].getFrlocEcc());
							eqrExePlnCntrVO.setToEccCd(eesEqr0059multiVOs[i].getTolocEcc());							
							
							dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, usrId );
						}
					} else if ( eesEqr0059multiVOs[i].getIbflag().equals("U") ){
						EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
						ObjectCloner.build(eesEqr0059multiVOs[i], eqrVslLodgDchgExePlnVO);
						
						eqrVslLodgDchgExePlnVO.setUpdUsrId(usrId);
						dbDao.modifyTrunkVesselAndFeederCntrRepoPlan("U",eqrVslLodgDchgExePlnVO);
						
						for ( int j=0; j < tpszList.size(); j++ ) {
							// QTY Table[EQR_VSL_EXE_Pln_QTY ] Setting..
							EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();
							ObjectCloner.build(eesEqr0059multiVOs[i], eqrVslExePlnQtyVO);
							
							ctnrTpszCd	= tpszList.get(j);
							flag = flagListArr.get(j);
							vol			= volList.get(j);
							unitcost	= unitcostListArr.get(j);
							fromcost	= fromcostListArr.get(j);
							tocost		= tocostListArr.get(j);
							flag		= flagListArr.get(j);
							
							if(flag.equals("T")) {
								// added by shin yongchan - 20080507		    	
						    	// CSR No : N200803140002
						       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함.
								if( unitcost.equals("0") || unitcost.equals("") ){
						       		tableCost = dbDao.searchUnitCost( "E", fmYdCd, toYdCd, trspModCd, ctnrTpszCd ).getResultStrArray();
						       		
						       		fromcost = tableCost[0];
						       		tocost   = tableCost[1];
						       		unitcost = tableCost[2];	
						       	}
								// added by shin yongchan - 20080507		    	
						    	// CSR No : N200803140002
						       	String lodgDchgCostAmt = String.valueOf( Integer.parseInt(vol) * Float.parseFloat(unitcost) );
						       	
								eqrVslExePlnQtyVO.setCntrTpszCd(ctnrTpszCd);
								eqrVslExePlnQtyVO.setCntrQty(vol);
								eqrVslExePlnQtyVO.setPlnUcAmt(unitcost);
								eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost);
								eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost);
								eqrVslExePlnQtyVO.setLodgDchgCostAmt(lodgDchgCostAmt);
								eqrVslExePlnQtyVO.setCreUsrId(usrId);
								eqrVslExePlnQtyVO.setUpdUsrId(usrId);
								
								dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("M", eqrVslExePlnQtyVO);
							}
						}
						
						// EQR_EXE_PLN_CNTR 테이블 삭제후 새로 입력
						EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
						ObjectCloner.build(eesEqr0059multiVOs[i], eqrExePlnCntrVO);
						eqrExePlnCntrVO.setCntrTpszCd(eesEqr0059multiVOs[i].getTpszNo());
						eqrExePlnCntrVO.setFmEccCd(eesEqr0059multiVOs[i].getFrlocEcc());
						eqrExePlnCntrVO.setToEccCd(eesEqr0059multiVOs[i].getTolocEcc());
						
						if(cntrNo!=null && !cntrNo.equals("")) {
							dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);				         		
							dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, usrId);				         		
						} 
		        		
		        		// EQR_EXE_PLN_CNTR 테이블 삭제 - cntrDel = 'Y' 인 경우
		        		if(cntrDel.equals("Y")) {
		        			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);				         		
						}
					} else if ( eesEqr0059multiVOs[i].getIbflag().equals("D") ){
						EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
						EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();
						EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
						
						ObjectCloner.build(eesEqr0059multiVOs[i], eqrVslLodgDchgExePlnVO);
						ObjectCloner.build(eqrVslLodgDchgExePlnVO, eqrVslExePlnQtyVO);
						ObjectCloner.build(eqrVslLodgDchgExePlnVO, eqrExePlnCntrVO);
						
						// EQR_EXE_PLN_CNTR 테이블 삭제
						if (eqrExePlnCntrVO != null )
							dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);
						
						// EQR_VSL_EXE_PLN_QTY 테이블 삭제
						if (eqrVslExePlnQtyVO != null)
							dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("D", eqrVslExePlnQtyVO);
						
						// EQR_VSL_LODG_DCHG_EXE_PLN 테이블 삭제
						if (eqrVslLodgDchgExePlnVO != null)
							dbDao.modifyTrunkVesselAndFeederCntrRepoPlan("D",eqrVslLodgDchgExePlnVO);
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [EES_EQR_0059 : BKG/DOC Interface - Mty Booking Creation ]<br>
	 * BKG/DOC 생성하기위해 필요한 기본정보를 조회한후 BKG VO 에 셋팅해 주는 작업
	 * DB 를 만나는 CUD 는 없음.
	 * @param commonVO	CommonVO
	 * @param account	SignOnUserAccount 
	 * @return MtyBookingCreateVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public MtyBookingCreateVO createRepoBKG(CommonVO commonVO, SignOnUserAccount account) throws EventException {
		MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		MtyBookingVO mtyBookingVO = new MtyBookingVO();
		MtyVvdVO[] mtyVvdVOs = new MtyVvdVO[1];
		MtyCntrVO mtyCntrVO= null;
		MtyQtyVO mtyQtyVO = null;
		
		Collection<MtyCntrVO> mtyCntrVOs = new ArrayList<MtyCntrVO>();
		Collection<MtyQtyVO> mtyQtyVOs = new ArrayList<MtyQtyVO>();
		
		String targetServer = null;
		String office_code	= null;
		List<String> tpszList= null;
		
		String polClptIndSeq = null;
		String podClptIndSeq = null;
		String repoBkgFlg	= null;
        
        int sum_volum = 0;
		int bkg_div = 0;
		String fm_rcc = null;
		//String fm_ecc = null;
		String company = null;
		String eqRepoPurpCd = null;
		List<String[]> cntrType_list = null;
		String usrId	= account.getUsr_id();
		String vps_port	= null;
        
        String gubun = commonVO.getGubun();
        try {
        	if ( commonVO != null ) {
		        if ( gubun.equals("V") ){		// Vessel , EES_EQR_0059
		        	EesEqr0059MultiVO[] multiVOs = (EesEqr0059MultiVO[]) commonVO.getResultVo();
		        	EesEqr0059MultiVO multiVO = multiVOs[0];
		        	
		        	tpszList		= multiVO.getTpszList();
					
					// targer server information
					fm_rcc			= multiVO.getFrlocRcc();
					company			= multiVO.getCoCd();
					
					 /*
		             * CSR NO : N200906300060
		             * MODIFIED BY SHIN YONGCHAN - 20090701
		             * BKG CRE, BKG SPLIT CRE 경우 FROM LOC = 'EGAIS' 인 경우 RCC를 무조건 'DEHAM'으로 하드코딩
		             */	
					/*
					fm_ecc	= multiVO.getFrlocEcc();
					
					if(fm_ecc.equals("EGAIS")) {
						fm_rcc = "DEHAM";
					}
					*/
					
	
					targetServer = dbDao.searchServerName(fm_rcc, "REPO").getField1();
					office_code = getOfficeCode(fm_rcc);
					
					// hanjin인 경우 targetServer를 변경한다.
		        	if(company.equals("H"))  targetServer = transServerName(targetServer);
		        	
					log.debug("\n==================== createRepoBKG Vessel targetServer : " +targetServer);
					log.debug("\n==================== createRepoBKG Vessel office_code  : " +office_code);
										
					for ( int i=0; i < tpszList.size(); i++ ){
						sum_volum = 0;
						mtyQtyVO = new MtyQtyVO();
						repoBkgFlg = multiVO.getRepobkgFlag();
						if(repoBkgFlg.equals("T")) {	// Repo Booking 대상
							sum_volum += Integer.parseInt( multiVO.getVolList().get(i));
						}
						
						if(sum_volum > 0) {
							mtyQtyVO.setCntrTpszCd(tpszList.get(i));
							mtyQtyVO.setOpCntrQty(Integer.toString(sum_volum));
	
							mtyQtyVOs.add(mtyQtyVO);
						}
					}
					
					repoBkgFlg = multiVO.getRepobkgFlag();
					if(repoBkgFlg.equals("T")) {
						bkg_div++;
					}
					
					commonVO.setConditionVo((EesEqr0059MultiVO) multiVO);
					cntrType_list = dbDao.searchCntrNoTpSz(commonVO).getResultVOList();
					if(cntrType_list != null) {
						// multi cntrNo, cntr tpsz : 멀티로 넘기는 부분 세팅
						for(int k=0; k<cntrType_list.size();k++) {
							mtyCntrVO = new MtyCntrVO();
							mtyCntrVO.setCntrNo(((String[])cntrType_list.get(k))[0]);
							mtyCntrVO.setCntrTpszCd(((String[])cntrType_list.get(k))[1]);
							mtyCntrVOs.add(mtyCntrVO);
						}
					}
									
					/** mtyBookingVO Setting **/
					mtyBookingVO.setCompInd		(multiVO.getCoCd());
					mtyBookingVO.setUsrId		(usrId);
					mtyBookingVO.setBkgCreSvrCd	(targetServer);
					mtyBookingVO.setVslCd		(multiVO.getVslCd());
					mtyBookingVO.setSkdVoyNo	(multiVO.getSkdVoyNo());
					mtyBookingVO.setSkdDirCd	(multiVO.getSkdDirCd());
					mtyBookingVO.setBkgOfcCd	(office_code);
					mtyBookingVO.setPkupYdCd	(multiVO.getFmYdCd());
					mtyBookingVO.setPreRlyPortCd("");
					mtyBookingVO.setPstRlyPortCd("");
					mtyBookingVO.setPolYdCd		(multiVO.getFmYdCd());
	
					mtyBookingVO.setPodYdCd(multiVO.getToYdCd());
					
					//modified : R200710194121 :   EQR에서 booking 시 Purpose 항목 추가
					// ENIS EQR은 D, H, E, S 로 관리 ---> NIS BKG/DOC 에서는 D, H, S 로 관리
					// E, S ===> S 로 변형시킴. 
		        	eqRepoPurpCd = multiVO.getEqRepoPurpCd();
					if(!eqRepoPurpCd.equals("D") && !eqRepoPurpCd.equals("H")) {	// E(Evacution), S(Stock Feeding) 인 경우
						mtyBookingVO.setMtyBkgStsCd("S");
					} else {														// H(Hanger Rack), D(Damage Repair) 인 경우
						mtyBookingVO.setMtyBkgStsCd(eqRepoPurpCd);
					}
					
					mtyBookingVO.setBkgRmk("");
					if(bkg_div==1){
						mtyBookingVO.setMtySplitAvalCd("Z");
					} else {
						mtyBookingVO.setMtySplitAvalCd("C");
					}
					
					/** mtyVvdVO Setting **/
					vps_port = multiVO.getFrlocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo((EesEqr0059MultiVO) multiVO);
					polClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
		
					vps_port = multiVO.getTolocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo((EesEqr0059MultiVO) multiVO);
					podClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
					
					podClptIndSeq = ( podClptIndSeq.equals("") || podClptIndSeq == null ) ? "0" : podClptIndSeq;
					
					mtyVvdVOs[0] = new MtyVvdVO();
					mtyVvdVOs[0].setVslPrePstCd	("T");
					mtyVvdVOs[0].setVslSeq		("0");
					mtyVvdVOs[0].setVslCd		(multiVO.getVslCd());
					mtyVvdVOs[0].setSkdVoyNo		(multiVO.getSkdVoyNo());
					mtyVvdVOs[0].setSkdDirCd		(multiVO.getSkdDirCd());
					mtyVvdVOs[0].setPolYdCd		(multiVO.getFmYdCd());
					mtyVvdVOs[0].setPodYdCd(multiVO.getToYdCd());
					mtyVvdVOs[0].setPolClptIndSeq(polClptIndSeq);
					mtyVvdVOs[0].setPodClptIndSeq(podClptIndSeq);
					
					/** mtyBookingCreate VO Setting **/
					mtyBookingCreateVO.setMtyBookingVO(mtyBookingVO);
					mtyBookingCreateVO.setMtyVvdVOs( mtyVvdVOs );
					mtyBookingCreateVO.setMtyCntrVOs( (MtyCntrVO[]) mtyCntrVOs.toArray(new MtyCntrVO[mtyCntrVOs.size()]) );
					mtyBookingCreateVO.setMtyQtyVOs( (MtyQtyVO[]) mtyQtyVOs.toArray(new MtyQtyVO[mtyQtyVOs.size()]) );
		        	
		        	
		        } else if ( gubun.equals("W") ){
		        	EesEqr0080MultiVO[] multiVOs = (EesEqr0080MultiVO[]) commonVO.getResultVo();
		        	EesEqr0080MultiVO multiVO = multiVOs[0];
		        	
					tpszList		= multiVO.getTpszList();
					
					// targer server information
					fm_rcc			= multiVO.getFrlocRcc();
					company			= multiVO.getCoCd();
					
					 /*
		             * CSR NO : N200906300060
		             * MODIFIED BY SHIN YONGCHAN - 20090701
		             * BKG CRE, BKG SPLIT CRE 경우 FROM LOC = 'EGAIS' 인 경우 RCC를 무조건 'DEHAM'으로 하드코딩
		             */	
					/*
					fm_ecc	= multiVO.getFrlocEcc();

					if(fm_ecc.equals("EGAIS")) {
						fm_rcc = "DEHAM";
					}
					*/
					targetServer = dbDao.searchServerName(fm_rcc, "REPO").getField1();	        	
					office_code = getOfficeCode(fm_rcc);
					
					// hanjin인 경우 targetServer를 변경한다.
		        	if(company.equals("H"))  targetServer = transServerName(targetServer);
					
					log.debug("\n==================== createRepoBKG Water targetServer : " +targetServer);
					log.debug("\n==================== createRepoBKG Water office_code  : " +office_code);
		        	
					for ( int i=0; i < tpszList.size(); i++ ){
						sum_volum = 0;
						mtyQtyVO = new MtyQtyVO();
						repoBkgFlg = multiVO.getRepobkgFlag();
						if(repoBkgFlg.equals("T")) {	// Repo Booking 대상
							sum_volum += Integer.parseInt( multiVO.getVolList().get(i));
						}
						
						if(sum_volum > 0) {
							mtyQtyVO.setCntrTpszCd(tpszList.get(i));
							mtyQtyVO.setOpCntrQty(Integer.toString(sum_volum));	
							mtyQtyVOs.add(mtyQtyVO);							
						}
					}
					
					repoBkgFlg = multiVO.getRepobkgFlag();
					if(repoBkgFlg.equals("T")) {
						bkg_div++;
					}
					
					commonVO.setConditionVo((EesEqr0080MultiVO) multiVO);
					cntrType_list = dbDao.searchCntrNoTpSz(commonVO).getResultVOList();
					if(cntrType_list != null) {
						// multi cntrNo, cntr tpsz : 멀티로 넘기는 부분 세팅
						for(int k=0; k<cntrType_list.size();k++) {
							mtyCntrVO = new MtyCntrVO();
							mtyCntrVO.setCntrNo(((String[])cntrType_list.get(k))[0]);
							mtyCntrVO.setCntrTpszCd(((String[])cntrType_list.get(k))[1]);
							mtyCntrVOs.add(mtyCntrVO);
						}
					}
									
					/** mtyBookingVO Setting **/
					mtyBookingVO.setCompInd		(multiVO.getCoCd());
					mtyBookingVO.setUsrId		(usrId);
					mtyBookingVO.setBkgCreSvrCd	(targetServer);
					if ( multiVO.getVvd().length() >= 9) {
						mtyBookingVO.setVslCd		(multiVO.getVvd().substring(0,4));
						mtyBookingVO.setSkdVoyNo	(multiVO.getVvd().substring(4,8));
						mtyBookingVO.setSkdDirCd	(multiVO.getVvd().substring(8,9));
					}
					
					mtyBookingVO.setBkgOfcCd	(office_code);
					mtyBookingVO.setPkupYdCd	(multiVO.getToYdCd());
					mtyBookingVO.setPreRlyPortCd("");
					mtyBookingVO.setPstRlyPortCd("");
					mtyBookingVO.setPolYdCd		(multiVO.getFmYdCd());
					mtyBookingVO.setPodYdCd(multiVO.getToYdCd());
					
					//modified : R200710194121 :   EQR에서 booking 시 Purpose 항목 추가
					// ENIS EQR은 D, H, E, S 로 관리 ---> NIS BKG/DOC 에서는 D, H, S 로 관리
					// E, S ===> S 로 변형시킴. 
		        	eqRepoPurpCd = multiVO.getEqRepoPurpCd();
					if(!eqRepoPurpCd.equals("D") && !eqRepoPurpCd.equals("H")) {	// E(Evacution), S(Stock Feeding) 인 경우
						mtyBookingVO.setMtyBkgStsCd("S");
					} else {														// H(Hanger Rack), D(Damage Repair) 인 경우
						mtyBookingVO.setMtyBkgStsCd(eqRepoPurpCd);
					}
					
					mtyBookingVO.setBkgRmk("");
					mtyBookingVO.setMtySplitAvalCd("W");
					
					/** mtyVvdVO Setting **/
					vps_port = multiVO.getFrlocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo((EesEqr0080MultiVO) multiVO);
					polClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
		
					vps_port = multiVO.getTolocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo((EesEqr0080MultiVO) multiVO);
					podClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
					
					mtyVvdVOs[0] = new MtyVvdVO();
					mtyVvdVOs[0].setVslPrePstCd	("T");
					mtyVvdVOs[0].setVslSeq		("0");
	
					if ( multiVO.getVvd().length() >= 9) {
						mtyVvdVOs[0].setVslCd	(multiVO.getVvd().substring(0,4));
						mtyVvdVOs[0].setSkdVoyNo	(multiVO.getVvd().substring(4,8));
						mtyVvdVOs[0].setSkdDirCd	(multiVO.getVvd().substring(8,9));
					}
					mtyVvdVOs[0].setPolYdCd		(multiVO.getFmYdCd());
					mtyVvdVOs[0].setPodYdCd(multiVO.getToYdCd());
					mtyVvdVOs[0].setPolClptIndSeq(polClptIndSeq);
					mtyVvdVOs[0].setPodClptIndSeq(podClptIndSeq);
					
					/** mtyBookingCreate VO Setting **/
					mtyBookingCreateVO.setMtyBookingVO(mtyBookingVO);
					mtyBookingCreateVO.setMtyVvdVOs(mtyVvdVOs);
					mtyBookingCreateVO.setMtyCntrVOs( (MtyCntrVO[]) mtyCntrVOs.toArray(new MtyCntrVO[mtyCntrVOs.size()]) );
					mtyBookingCreateVO.setMtyQtyVOs( (MtyQtyVO[]) mtyQtyVOs.toArray(new MtyQtyVO[mtyQtyVOs.size()]) );
		        	
		        }
        	}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
		
		return mtyBookingCreateVO;
	}
	
	/**
	 * [EES_EQR_0059 : BKG/DOC Interface - Mty Booking Split ]<br>
	 * BKG SPLIT 생성을 위해서 BKG/DOC에 넘겨줘야 할 정보를 조회후 VO 에 셋팅
	 * @param multiVO	EesEqr0059MultiVO
	 * @param account	SignOnUserAccount
	 * @return MtyBookingSplitVO
	 * @exception EventException
	 */
	public MtyBookingSplitVO createRepoBKGSplit(EesEqr0059MultiVO multiVO, SignOnUserAccount account) throws EventException {
		MtyBookingSplitVO mtyBookingSplitVO = new MtyBookingSplitVO();
		MtyBookingVO mtyBookingVO = new MtyBookingVO();
		MtyVvdVO[] mtyVvdVOs = new MtyVvdVO[1];
		MtyCntrVO mtyCntrVO= null;
		
		CommonVO commonVO = new CommonVO();				
		Collection<MtyCntrVO> mtyCntrVOs = new ArrayList<MtyCntrVO>();
        
        try {
        	if ( multiVO != null ) {
				String fmYdCd			= multiVO.getFmYdCd();
				String toYdCd			= multiVO.getToYdCd();
				String coCd				= multiVO.getCoCd();
				String oldBkgGrpNo		= multiVO.getOldBkgGrpNo();
				String mtyBkgNo			= multiVO.getMtyBkgNo();
				String cntrNo			= multiVO.getCntrNo();
				String tpszNo			= multiVO.getTpszNo();
				String eqRepoPurpCd 	= multiVO.getEqRepoPurpCd();
				String splitRepoPlnFlg	= multiVO.getSplitRepoPlnFlg();
        		//String fm_ecc			= multiVO.getFrlocEcc();
		    	String ibFlag			= multiVO.getIbflag();
		    	String trspModCd		= multiVO.getTrspModCd();
		    	String usrId			= account.getUsr_id();
		    	
        		String fm_rcc			= null;
				String targetServer = null;
				String office_code	= null;	
        		String refId = null;
        		String vps_port	= null;
        		String polClptIndSeq = null;
        		String podClptIndSeq = null;
				
      		if ( multiVO.getIbflag().equals("I") && splitRepoPlnFlg.equals("Y") ){
	        		commonVO.setGubun("V");
	        		
	        		/*
		             * CSR NO : N200906300060
		             * MODIFIED BY SHIN YONGCHAN - 20090701
		             * BKG CRE, BKG SPLIT CRE 경우 FROM LOC = 'EGAIS' 인 경우 RCC를 무조건 'DEHAM'으로 하드코딩
		             */	
					/*
					if(fm_ecc.equals("EGAIS")) {
						fm_rcc = "DEHAM";
					}
					*/
					// targer server information
					fm_rcc			= multiVO.getFrlocRcc();					
	
					targetServer = dbDao.searchServerName(fm_rcc, "REPO").getField1();
					office_code = getOfficeCode(fm_rcc);
					
					// hanjin인 경우 targetServer를 변경한다.
		        	if(coCd.equals("H"))  targetServer = transServerName(targetServer);

					log.debug("\n==================== createRepoBKGSplit targetServer : " +targetServer);
					log.debug("\n==================== createRepoBKGSplit office_code  : " +office_code);

	        		mtyBookingVO.setCompInd(coCd);
	        		mtyBookingVO.setUsrId(usrId);
	        		mtyBookingVO.setBkgCreSvrCd(targetServer);
	        		mtyBookingVO.setBkgRmk("");
	        		mtyBookingVO.setMtySplitAvalCd("S");
	        		mtyBookingVO.setVslCd(multiVO.getVslCd());
	        		mtyBookingVO.setSkdVoyNo(multiVO.getSkdVoyNo());
	        		mtyBookingVO.setSkdDirCd(multiVO.getSkdDirCd());
	        		mtyBookingVO.setBkgOfcCd(office_code);
	        		mtyBookingVO.setPkupYdCd(fmYdCd);
	        		mtyBookingVO.setPreRlyPortCd("");
	        		mtyBookingVO.setPstRlyPortCd("");
	        		mtyBookingVO.setPolYdCd(fmYdCd);
	        		mtyBookingVO.setPodYdCd(toYdCd);
	        		
	        		//modified : R200710194121 :   EQR에서 booking 시 Purpose 항목 추가
					// ENIS EQR은 D, H, E, S 로 관리 ---> NIS BKG/DOC 에서는 D, H, S 로 관리
					// E, S ===> S 로 변형시킴. 
					if(!eqRepoPurpCd.equals("D") && !eqRepoPurpCd.equals("H")) {	// E(Evacution), S(Stock Feeding) 인 경우
						mtyBookingVO.setMtyBkgStsCd("S");
					} else {														// H(Hanger Rack), D(Damage Repair) 인 경우
						mtyBookingVO.setMtyBkgStsCd(eqRepoPurpCd);
					}
					
					/** mtyVvdVO Setting **/
					vps_port = multiVO.getFrlocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo(multiVO);
					polClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
		
					vps_port = multiVO.getTolocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo(multiVO);
					podClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();				
					
					mtyVvdVOs[0] = new MtyVvdVO();
					mtyVvdVOs[0].setVslPrePstCd("T");
					mtyVvdVOs[0].setVslSeq("0");
					mtyVvdVOs[0].setVslCd(multiVO.getVslCd());
					mtyVvdVOs[0].setSkdVoyNo(multiVO.getSkdVoyNo());
					mtyVvdVOs[0].setSkdDirCd(multiVO.getSkdDirCd());
					mtyVvdVOs[0].setPolYdCd(fmYdCd);
					mtyVvdVOs[0].setPodYdCd(toYdCd);
					mtyVvdVOs[0].setPolClptIndSeq(polClptIndSeq);
					mtyVvdVOs[0].setPodClptIndSeq(podClptIndSeq);
					
					/** mtyCntrVOs Setting **/				
					String[] cntrno_arr    = null;
					String[] tpszno_arr    = null;
					String[] cnmvcd_arr    = null;
					
					cntrno_arr = cntrNo.split(",");
					tpszno_arr = tpszNo.split(",");
					cnmvcd_arr = multiVO.getCntrStatus().split(",");
					
					for(int k=0; k<cntrno_arr.length;k++) {
						mtyCntrVO = new MtyCntrVO();
						mtyCntrVO.setCntrNo(cntrno_arr[k]);
						mtyCntrVO.setCntrTpszCd(tpszno_arr[k]);
						mtyCntrVO.setCnmvStsCd(cnmvcd_arr[k]);					
						mtyCntrVOs.add(mtyCntrVO);
					}
	        	}
	        	
	        	/** mtyBookingSplitVO VO Setting **/
	        	mtyBookingSplitVO.setMtyBookingVO(mtyBookingVO);
	        	mtyBookingSplitVO.setMtyVvdVOs( mtyVvdVOs );
	        	mtyBookingSplitVO.setMtyCntrVOs( (MtyCntrVO[]) mtyCntrVOs.toArray(new MtyCntrVO[mtyCntrVOs.size()]) );
	        	
	        	EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
	        	
	        	// ref_id 를 생성	
	        	refId = dbDao.makeRefIDCntrRepoPlan("EQR_VSL_LODG_DCHG_EXE_PLN", coCd, multiVO.getRepoPlnId(), multiVO.getFmYdCd(), "V");
				ObjectCloner.build(multiVO, eqrVslLodgDchgExePlnVO);

				// EXE Table[EQR_VSL_LODG_DCHG_EXE_PLN ] Setting..
				
				eqrVslLodgDchgExePlnVO.setRefId(refId);
				eqrVslLodgDchgExePlnVO.setCreUsrId(usrId);
				eqrVslLodgDchgExePlnVO.setUpdUsrId(usrId);
				eqrVslLodgDchgExePlnVO.setMtyBkgNo(mtyBkgNo);
				eqrVslLodgDchgExePlnVO.setOldBkgGrpNo(oldBkgGrpNo);
				dbDao.modifyTrunkVesselAndFeederCntrRepoPlan("I",eqrVslLodgDchgExePlnVO);
				
				multiVO.setRefId(refId);
				// QTY Table Insert
				
			    	
				List<String> tpszList			= multiVO.getTpszList();
		    	List<String> volList			= multiVO.getVolList();
		    	List<String> flagListArr		= multiVO.getFlagList();
		    	List<String> unitcostListArr	= multiVO.getUnitcostList();
		    	List<String> fromcostListArr	= multiVO.getFromcostList();
		    	List<String> tocostListArr		= multiVO.getTocostList();	    	
				
		    	String[] tableCost = new String[3];
				String unitcost = null;
		    	String fromcost = null;
		    	String tocost   = null;

				String vol = null;    // type size별 vol 수량
		    	String ctnrTpszCd = null;
		    	String flag = null;
		    	String cntrDel = null;

				for ( int j=0; j < tpszList.size(); j++ ) {
					// QTY Table[EQR_VSL_EXE_Pln_QTY ] Setting..
					EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();			
					ObjectCloner.build(multiVO, eqrVslExePlnQtyVO);
					
					ctnrTpszCd	= tpszList.get(j);
					vol			= volList.get(j);
					unitcost	= unitcostListArr.get(j);
					fromcost	= fromcostListArr.get(j);
					tocost		= tocostListArr.get(j);
					flag		= flagListArr.get(j);
			       	
			       	if ( ibFlag.equals("I") ) {
			       		// added by shin yongchan - 20080507		    	
				    	// CSR No : N200803140002
				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
				       	if( unitcost.equals("0") || unitcost.equals("") ){
				       		tableCost = dbDao.searchUnitCost( "E", fmYdCd, toYdCd, trspModCd, ctnrTpszCd ).getResultStrArray();
				       		
				       		fromcost = tableCost[0];
				       		tocost   = tableCost[1];
				       		unitcost = tableCost[2];	
				       	}
				       	// added by shin yongchan - 20080507		    	
				    	// CSR No : N200803140002
				       	String lodgDchgCostAmt = String.valueOf( Integer.parseInt(vol) * Float.parseFloat(unitcost) );
				       	
				       	int ivol = 0;
				       	ivol = Integer.parseInt(vol);
				       	if ( ivol > 0) {
							eqrVslExePlnQtyVO.setCntrTpszCd(ctnrTpszCd);
							eqrVslExePlnQtyVO.setCntrQty(vol);
							eqrVslExePlnQtyVO.setPlnUcAmt(unitcost);
							eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost);
							eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost);
							eqrVslExePlnQtyVO.setLodgDchgCostAmt(lodgDchgCostAmt);
							eqrVslExePlnQtyVO.setCreUsrId(usrId);
							eqrVslExePlnQtyVO.setUpdUsrId(usrId);
							
							dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("I", eqrVslExePlnQtyVO);
				       	}

			       	} else if ( ibFlag.equals("U") ) {
						if(flag.equals("T")) {
							// added by shin yongchan - 20080507		    	
					    	// CSR No : N200803140002
					       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함.
							if( unitcost.equals("0") || unitcost.equals("") ){
					       		tableCost = dbDao.searchUnitCost( "E", fmYdCd, toYdCd, trspModCd, ctnrTpszCd ).getResultStrArray();
					       		
					       		fromcost = tableCost[0];
					       		tocost   = tableCost[1];
					       		unitcost = tableCost[2];	
					       	}
							// added by shin yongchan - 20080507		    	
					    	// CSR No : N200803140002
					       	String lodgDchgCostAmt = String.valueOf( Integer.parseInt(vol) * Float.parseFloat(unitcost) );
					       	
							eqrVslExePlnQtyVO.setCntrTpszCd(ctnrTpszCd);
							eqrVslExePlnQtyVO.setCntrQty(vol);
							eqrVslExePlnQtyVO.setPlnUcAmt(unitcost);
							eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost);
							eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost);
							eqrVslExePlnQtyVO.setLodgDchgCostAmt(lodgDchgCostAmt);
							eqrVslExePlnQtyVO.setCreUsrId(usrId);
							eqrVslExePlnQtyVO.setUpdUsrId(usrId);
							
							dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("M", eqrVslExePlnQtyVO);
						}
			       	}
				}
				
				if ( ibFlag.equals("I") ) {
					// EQR_EXE_PLN_CNTR Table Setting..
					if (!splitRepoPlnFlg.equals("Y") && cntrNo != null && !cntrNo.equals("")){
						EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
						ObjectCloner.build(multiVO, eqrExePlnCntrVO);
						
						eqrExePlnCntrVO.setCntrNo(cntrNo);
						eqrExePlnCntrVO.setCntrTpszCd(tpszNo);
						eqrExePlnCntrVO.setCreUsrId(usrId);
						eqrExePlnCntrVO.setUpdUsrId(usrId);
						eqrExePlnCntrVO.setFmEccCd(multiVO.getFrlocEcc());
						eqrExePlnCntrVO.setToEccCd(multiVO.getTolocEcc());							
						
						dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, usrId );
					}
				} else if ( ibFlag.equals("U") ){
					// EQR_EXE_PLN_CNTR 테이블 삭제후 새로 입력
					EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
					ObjectCloner.build(multiVO, eqrExePlnCntrVO);
					eqrExePlnCntrVO.setCntrTpszCd(multiVO.getTpszNo());
					eqrExePlnCntrVO.setFmEccCd(multiVO.getFrlocEcc());
					eqrExePlnCntrVO.setToEccCd(multiVO.getTolocEcc());
					
					if(cntrNo!=null && !cntrNo.equals("")) {
						dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);				         		
						dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, usrId);				         		
					} 
	        		
	        		// EQR_EXE_PLN_CNTR 테이블 삭제 - cntrDel = 'Y' 인 경우
	        		if(cntrDel != null && cntrDel.equals("Y")) {
	        			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);				         		
					}
				}
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
		
		return mtyBookingSplitVO;
	}

	/**
	 * [EES_EQR_0059 & EES_EQR_0080 : MTY Booking Creation 후 각 테이블에 Bkg No. 업데이트 해주기. ]<br>
	 * 
	 * @param mtyBkgVO	MtyBkgVO
	 * @param commonVO	CommonVO
	 * @exception EventException
	 */
	public void modifyMtyBkgNo(MtyBkgVO mtyBkgVO, CommonVO commonVO) throws EventException {
		List<Map<String, Object>> updateVoList = new ArrayList<Map<String, Object>>();
		String gubun	= "";
		String usr_id	= "";
		String mtyBkgNo	= "";
		String oldBkgGrpNo = "";
		
		try {
			if( mtyBkgVO != null) {
				gubun		= mtyBkgVO.getGubun();
				mtyBkgNo	= mtyBkgVO.getMtyBkgNo();
				oldBkgGrpNo	= mtyBkgVO.getMtyBkgNo();
				usr_id		= mtyBkgVO.getUsrId();
			}
			if ( gubun.equals("V") ){
				EesEqr0059MultiVO[] multiVOs = (EesEqr0059MultiVO[]) commonVO.getResultVo();
				
				for ( int i=0; i < multiVOs .length; i++ ) {
					multiVOs[i].setMtyBkgNo(mtyBkgNo);
					multiVOs[i].setUpdUsrId(usr_id);
					Map<String, Object> list = new HashMap<String, Object>();
					list.putAll(multiVOs[i].getColumnValues());
					list.put("old_bkg_grp_no", oldBkgGrpNo);
					updateVoList.add(list);
				}
			} else if ( gubun.equals("W") ){
				EesEqr0080MultiVO[] multiVOs = (EesEqr0080MultiVO[]) commonVO.getResultVo();
				
				for ( int i=0; i < multiVOs .length; i++ ) {
					multiVOs[i].setMtyBkgNo(mtyBkgNo);
					multiVOs[i].setUpdUsrId(usr_id);
					Map<String, Object> list = new HashMap<String, Object>();
					list.putAll(multiVOs[i].getColumnValues());
					updateVoList.add(list);
				}
			}

			if ( updateVoList.size() > 0 ) {
				mtyBkgVO = mtyBkgVO == null ? new MtyBkgVO() : mtyBkgVO;
				dbDao.modifyMtyBkgNo(mtyBkgVO, updateVoList);
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * office code 를 결정하는 로직
	 * @param targetServer	String
	 * @return String
	 * @exception EventException
	 */
	public String getOfficeCode(String fm_rcc) throws EventException {
		String ofc_cd = null;
		
		try {
			// modified by shin yongchan 20070312
			/* 				
			if(targetServer.equals("DKR")) 		ofc_cd = "SELHQ"; 
			else if(targetServer.equals("DCH")) ofc_cd = "SHAHQ"; 
			else if(targetServer.equals("DSW")) ofc_cd = "SINHQ"; 
			else if(targetServer.equals("DEU")) ofc_cd = "HAMHQ"; 
			else if(targetServer.equals("DUS")) ofc_cd = "NYCHQ"; 
			*/
			if(fm_rcc.equals("USNYC")) 		ofc_cd = "NYCNA"; 
			else if(fm_rcc.equals("DEHAM")) ofc_cd = "HAMUR"; 
			else if(fm_rcc.equals("SGSIN")) ofc_cd = "SINWA"; 
			else                            ofc_cd = "SHAAS";   // CHSHA,CNHKG,TWTPE,KRSEL,TWTPE,JPTYO

			if(ofc_cd==null || ofc_cd.equals("")) {
				throw new EventException(new ErrorHandler("EQR10031", new String[]{"Office code"}).getMessage());
			}	
			
    		return ofc_cd;

		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * [BKG/DOC Interface : Volume Change ]<br>
	 * BKG/DOC에서 OGR BKG, SPLIT BKG에 대해 컨테이너를 조정후 SAVE 버튼을 누르면 이메소드 호출됨.
	 * EQR에서는 ORG BKG VOLUME, SPLIT BKG VOLUME, FIXED PALN VOLUME CHANGE
	 * @param mtyBkgVO	MtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgVolChange(MtyBkgVO mtyBkgVO) throws EventException {
		DBRowSet targetRs = null;
		List<CheckBkgVolumeTargetVO> list = null;
		List<EqrVslExePlnQtyVO>  eqrVslExePlnQtyVOs = null;
		List<EqrInlndTrspExePlnQtyVO> eqrInlndTrspExePlnQtyVOs = null;
		
		List<MtyBkgCntrVO> mtyBkgCntrVOs = null;
		
		String[] table_name = new String[2];
		String gubun = null;
		int diff_qty = 0;
		int rowCount = 0;
		int cntrQty = 0;
		String cntr_check = "N";
		String cntr_tpsz_cd= null;
		String[] tableCost = null;
		String	fromCost = null;
		String	toCost	= null;
		String	unitCost= null;
		String mty_bkg_no = null; 
		
		try {
			if( mtyBkgVO != null ){
				mty_bkg_no = mtyBkgVO.getMtyBkgNo();
			}
			if( mty_bkg_no != null ){
				// 01. Bkg No.로 Vessel인지 Water인지 Check..
				targetRs = dbDao.checkTarget(mtyBkgVO).getDbRowset();
				int targetCount = targetRs.getRowCount();
				
				while ( targetRs.next() ){
					gubun	= targetRs.getString("GUBUN");
				}
				
				if( targetCount > 1) {
					// COM12114 -- Please check ($s)
					throw new EventException((String)new ErrorHandler("COM12242", "BKG No.("+mty_bkg_no+").").getMessage());
				} else if (targetCount == 1 ) {	// Bkg No.가  Vessel or Water인지 구분되었을 경우 실행..
					mtyBkgVO.setGubun(gubun);
					
					if ( gubun.equals("V") ){
						table_name[0]	= "EQR_VSL_LODG_DCHG_EXE_PLN";
						table_name[1]	= "EQR_VSL_EXE_PLN_QTY";
					} else if ( gubun.equals("W") ){
						table_name[0]	= "EQR_INLND_TRSP_EXE_PLN";
						table_name[1]	= "EQR_INLND_TRSP_EXE_PLN_QTY";
					}
					mtyBkgVO.setTableName(table_name);
					
					// BKG_QUANTITY, EQR_VSL_LODG_DCHG_EXE_PLN 테이블 비교해서 Volume 차이 구하기.
					mtyBkgCntrVOs = dbDao.checkBkgVolumeChange(mtyBkgVO);
					
					for ( int i=0; i < mtyBkgCntrVOs.size(); i ++ ) {
						cntrQty = Integer.parseInt( mtyBkgCntrVOs.get(i).getCntrQty() );
						
						// 02. Bkg No.로 Exe Table에서 해당하는 Target 찾기.
						list = dbDao.checkBkgVolumeTarget(mtyBkgVO, mtyBkgCntrVOs.get(i));
						
						if ( list.size() > 0 ){
							diff_qty = Integer.parseInt(list.get(0).getCntrQty()) - cntrQty;
						} else {
							diff_qty = cntrQty;
						}
				
						rowCount = list.size();
					
						// 해당  Container Type Size가 없는 경우..
						if ( rowCount <= 0 ) {
							list = dbDao.checkBkgVolumeTargetExe(mtyBkgVO, mtyBkgCntrVOs.get(i));
							cntr_check = "Y";
							rowCount = list.size();
						}
						eqrVslExePlnQtyVOs = new ArrayList<EqrVslExePlnQtyVO>();
						eqrInlndTrspExePlnQtyVOs = new ArrayList<EqrInlndTrspExePlnQtyVO>();
						for ( int k=0; k < rowCount; k++ ){
						
							cntr_tpsz_cd = ( cntr_check.equals("Y")) ? mtyBkgCntrVOs.get(i).getCntrTpszCd() : list.get(k).getCntrTpszCd();

							// UNIT COST						
							tableCost = dbDao.searchUnitCost("E", list.get(k).getFmYdCd(), list.get(k).getToYdCd(), list.get(k).getTrspModCd(), cntr_tpsz_cd).getResultStrArray();
							fromCost	= tableCost[0];
							toCost		= tableCost[1];
							unitCost	= tableCost[2];

							if ( gubun.equals("V") ){
								EqrVslExePlnQtyVO vslQtyVO = new EqrVslExePlnQtyVO();
								vslQtyVO.setRepoPlnId(list.get(k).getRepoPlnId());
								vslQtyVO.setPlnYrwk(list.get(k).getPlnYrwk());
								vslQtyVO.setPlnSeq(list.get(k).getPlnSeq());
								vslQtyVO.setRefId(list.get(k).getRefId());
								vslQtyVO.setCntrTpszCd(cntr_tpsz_cd);
								vslQtyVO.setCreUsrId(mtyBkgVO.getUsrId());
								vslQtyVO.setUpdUsrId(mtyBkgVO.getUsrId());
								vslQtyVO.setCntrQty(Integer.toString(cntrQty));
								vslQtyVO.setLodgPortUcAmt(fromCost);
								vslQtyVO.setDchgPortUcAmt(toCost);
								vslQtyVO.setPlnUcAmt(unitCost);
								vslQtyVO.setLodgDchgCostAmt(Float.toString(cntrQty * Float.parseFloat(tableCost[2])));
								eqrVslExePlnQtyVOs.add(vslQtyVO);
							} else if ( gubun.equals("W") ){
								EqrInlndTrspExePlnQtyVO inlndQtyVO = new EqrInlndTrspExePlnQtyVO();
								inlndQtyVO.setRepoPlnId(list.get(k).getRepoPlnId());
								inlndQtyVO.setPlnYrwk(list.get(k).getPlnYrwk());
								inlndQtyVO.setPlnSeq(list.get(k).getPlnSeq());
								inlndQtyVO.setRefId(list.get(k).getRefId());
								inlndQtyVO.setCntrTpszCd(cntr_tpsz_cd);
								inlndQtyVO.setCreUsrId(mtyBkgVO.getUsrId());
								inlndQtyVO.setUpdUsrId(mtyBkgVO.getUsrId());
								inlndQtyVO.setCntrQty(Integer.toString(cntrQty));
								inlndQtyVO.setFmEccUcAmt(fromCost);
								inlndQtyVO.setToEccUcAmt(toCost);
								inlndQtyVO.setPlnUcAmt(unitCost);
								inlndQtyVO.setTrspCostAmt(Float.toString(cntrQty * Float.parseFloat(unitCost)));
								eqrInlndTrspExePlnQtyVOs.add(inlndQtyVO);
							}
							
							if ( list.get(k) != null ){
								// 실행 테이블 수량 수정..
								if ( gubun.equals("V") ){
									dbDao.modifyTrunkVesselAndFeederBkgVolDiff(eqrVslExePlnQtyVOs);
									
//									// Split인 경우
//									if ( mtyBkgVO.getSplitFlg().equals("Y") ){
//										// Fixed Plan 
//										EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
//										ObjectCloner.build(eqrVslExePlnQtyVOs.get(0), eqrVslLodgDchgPlnQtyVO);
//		
//										eqrVslLodgDchgPlnQtyVO.setLodgPortCostAmt(fromCost);
//										eqrVslLodgDchgPlnQtyVO.setDchgPortCostAmt(toCost);
//										eqrVslLodgDchgPlnQtyVO.setPlnUcAmt(unitCost);
//										eqrVslLodgDchgPlnQtyVO.setCntrQty(Integer.toString(diff_qty));
//										
//										modifyFixedPlan(eqrVslLodgDchgPlnQtyVO);
//									}
									// Original MTY BKG인 경우
//									else if (mtyBkgVO.getSplitFlg().equals("N") ){
									if (mtyBkgVO.getSplitFlg() != null ){
										if (mtyBkgVO.getSplitFlg().equals("N")){
											// Plan Table 찾기
											EesEqr0059MultiVO eesEqr0059MultiVO = new EesEqr0059MultiVO();
	//										eesEqr0059MultiVO = mtyBkgVO.getEesEqr0059MultiVO();
											List<EqrVslLodgDchgPlnQtyVO> fixedPlanVOs = null;
											
											eesEqr0059MultiVO.setVslCd(list.get(k).getVslCd());
											eesEqr0059MultiVO.setSkdVoyNo(list.get(k).getSkdVoyNo());
											eesEqr0059MultiVO.setSkdDirCd(list.get(k).getSkdDirCd());
											eesEqr0059MultiVO.setFrlocEcc(list.get(k).getFmYdCd().substring(0, 5));
											eesEqr0059MultiVO.setTolocEcc(list.get(k).getToYdCd().substring(0, 5));
											eesEqr0059MultiVO.setCntrTpszCd(cntr_tpsz_cd);										
	
											fixedPlanVOs = dbDao.searchOrgFixedPlan(eesEqr0059MultiVO);
											
											for(int j=0; j<fixedPlanVOs.size(); j++){										
												EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
												ObjectCloner.build(fixedPlanVOs.get(j), eqrVslLodgDchgPlnQtyVO);
												eqrVslLodgDchgPlnQtyVO.setLodgPortCostAmt(fromCost);
												eqrVslLodgDchgPlnQtyVO.setDchgPortCostAmt(toCost);
												eqrVslLodgDchgPlnQtyVO.setPlnUcAmt(unitCost);
												eqrVslLodgDchgPlnQtyVO.setCreUsrId(mtyBkgVO.getUsrId());
												eqrVslLodgDchgPlnQtyVO.setUpdUsrId(mtyBkgVO.getUsrId());
												eqrVslLodgDchgPlnQtyVO.setCntrQty(Integer.toString(diff_qty));
												
												modifyFixedPlan(eqrVslLodgDchgPlnQtyVO);
											}
										}
									} else {
										throw new EventException((String)new ErrorHandler("SplitFlg is null.").getMessage());
									}
								} else if ( gubun.equals("W") ){
									dbDao.modifyTruckAndRailAndBargeBkgVolDiff(eqrInlndTrspExePlnQtyVOs);
								}
							}
						}
					}					
				}
			} else {
				// Data Not Found.
				throw new EventException((String)new ErrorHandler("EQR10009").getMessage());
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * [BOK/DOC InterFace : Mty Booking Cancel ]<br>
	 * BKG/DOC 화면에서 ORG BKG에 컨테이너가 할당되지 않고, VOLUME > 0 으로 큰 경우만 CALL 가능
	 * 
	 * @param mtyBkgVO	MtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgCancel(MtyBkgVO mtyBkgVO) throws EventException {
		DBRowSet targetRs = null;
		String gubun = null;
		String check = null;
		String[] table_name = new String[1];
		
		int i=0;
		try {
			if( mtyBkgVO.getMtyBkgNo() != null ){
				// Bkg No.로 Vessl인지 Water인지 Check..
				targetRs = dbDao.checkTarget(mtyBkgVO).getDbRowset();
				
				while (targetRs.next() ){
					check		= targetRs.getString("CHK");
					if ( check.equals("Y") ) {
						gubun	= targetRs.getString("GUBUN");
						i++;
					}
				}
				
				if ( i == 0 ){
					throw new EventException((String)new ErrorHandler("There is no BKG No.("+mtyBkgVO.getMtyBkgNo()+").").getMessage());
				}
				
				if( i > 1) {
					throw new EventException("해당 Bkg 정보가 잘못되었습니다.");
				} else {
					mtyBkgVO.setGubun(gubun);
					if ( gubun.equals("V") ){
						table_name[0] = "EQR_VSL_LODG_DCHG_EXE_PLN";
					} else if ( gubun.equals("W") ){
						table_name[0] = "EQR_INLND_TRSP_EXE_PLN";
					}
					
					mtyBkgVO.setTableName(table_name);
					dbDao.modifyBkgCancel(mtyBkgVO);
				}
			} else {
				throw new EventException(new ErrorHandler("COM12200", "MTY BKG No.").getMessage());
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * ServerName 변경
	 * 
	 * @param targetServer	String
	 * @return String	target_server
	 * @exception EventException
	 */
	public String transServerName(String targetServer) throws EventException {
		String target_server = null;
		
		try {
        	if(targetServer.equals("DKR"))      target_server = "KOR";
        	else if(targetServer.equals("DCH")) target_server = "CHN";
        	else if(targetServer.equals("DSW")) target_server = "SWA";
        	else if(targetServer.equals("DUS")) target_server = "USA";
        	else if(targetServer.equals("DEU")) target_server = "EUR";        		

			if(target_server==null || target_server.equals("")) {
				throw new DAOException(new ErrorHandler("EQR10031", "Target server").getMessage());
			}	

    		return target_server;

		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condiVO EesEqr0113ConditionVO
	 * @return List<SearchCntrRepoExecutionPlanEstablishVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoExecutionPlanEstablishVO> searchCntrRepoExecutionPlanEstablish(EesEqr0113ConditionVO condiVO) throws EventException {
	
		try {
			List<SearchCntrRepoExecutionPlanEstablishVO> list =dbDao.searchCntrRepoExecutionPlanEstablish(condiVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrListVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrListVO> searchCntrRepoExecutionPlanCntrList(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchExecutionPlanCntrListVO> list = null;
		try {
			
			list = dbDao.searchCntrRepoExecutionPlanCntrList(conditionVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrInfoVO> searchCntrRepoExecutionPlanCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchExecutionPlanCntrInfoVO> list = null;
		try {
			list =dbDao.searchCntrRepoExecutionPlanCntrInfo(conditionVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 094화면에서 EXCEL FILE 을 UPLOAD하여 CONTAINER 정보 검색<br>
	 * Excel
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoExcelVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchExecutionPlanCntrInfoExcelVO> searchCntrRepoExecutionPlanCntrInfoExcel(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchExecutionPlanCntrInfoExcelVO> list = null;
		try { 
			List cntrNoArr	= Utils.replaceStrToList(conditionVO.getCntrNo()); 
			
			if(cntrNoArr.size() > 0) { // 엑셀업로드 정보가 제대로 들어온 경우, 20100414 - 신용찬
				list = dbDao.searchCntrRepoExecutionPlanCntrInfoExcel(conditionVO);
				return list;

			}else {	// 엑셀업로드 양식 잘못된 경우 조회할 필요없으며, 엑셀양식 재확인 요청
				throw new DAOException(new ErrorHandler("EQR10036").getMessage());
			}	
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return EventResponse EES-EQR-094EventResponse
	 * @exception EventException
	 */
	public List<SearchCheckCntrInfoVO> searchCheckCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchCheckCntrInfoVO> list = null;
		
		try {
			list = dbDao.searchCheckCntrInfo(conditionVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchBeforeCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchBeforeCntrInfoVO> searchBeforeCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchBeforeCntrInfoVO> list = null;
		try {
			list = dbDao.searchBeforeCntrInfo(conditionVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_0801Event 화면에 대한 조회 이벤트 처리<br>
	 * 
	  * @param eesEqr0059ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException {
		
		CommonRsVO commonRsVO = null;
        
		try {
			
			// NIS 와 통합되면서 아래 작업은 NIS 측에서 통제하는것으로 협의됨  
			// CntrRepoExecutionPlanEstablishBC.modifyMtyBkgCancel ,  CntrRepoExecutionPlanEstablishBC.modifyMtyBkgVolChange 참조
			// 09.08.25 By ChungEunHo
			// NIS BOOKING VOL과 차이가 나는지 확인						
			// NIS BOOKING VOL과 차이가 나는 경우 QTY 수정(수정/입력)
			// ------ NIS BOOKING CANCEL 확인			
			// ------ NIS BOOKING cancel 된 경우 
			
			commonRsVO = dbDao.searchTruckAndRailAndBargeCntrRepoPlan(eesEqr0059ConditionVO);
			
			return commonRsVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	} 
	

	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_080 에 대한 추가 이벤트 처리<br>
	 * 컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge (EES_EQR_080) DB에 반영한다.(추가, 수정, 삭제)<br>
      INSERT : - REF_ID 생성
               - EQR_INLND_TRSP_EXE_PLN     입력
               - EQR_EXE_PLN_CNTR 			입력
               
      UPDATE : - EQR_INLND_TRSP_EXE_PLN     VOL 수정 
               - EQR_INLND_TRSP_EXE_PLN     VOL이외의 정보 수정          
               - EQR_EXE_PLN_CNTR 			삭제
               - EQR_EXE_PLN_CNTR 			입력

      DELETE : - EQR_EXE_PLN_CNTR 			삭제         
               - EQR_INLND_TRSP_EXE_PLN     삭제
	 * 
	 * @param conditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0080MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException {
	            
	    String user_id        = account.getUsr_id(); // user id information
	
	    try {
			// INSERT, UPDATE, DELETE 수행
	    	//dbDao.modifyTruckAndRailAndBargeCntrRepoPlan(event, userId, tpszInitial);
	    	if(vos != null && vos.length > 0){

    			String tpszType = conditionVO.getTpsztype();
				String[] tpszArr= tpszType.split(",");
				String[] tpszArrInitial= conditionVO.getTpszInitial().split(",");
	    		String ref_id_new = "";	 // ref_id 변수
	    		String soFlag = conditionVO.getSoFlag();
				                        
	            
	            List<String> volList 	 = null;
	        	int vol          = 0;    // type size별 vol 수량

		    	
	        	List<String> flagList	 = null;
	        	String flag      = "";
	
	        	// VVL 분리
	        	String vsl_cd     = "";
	        	String skd_voy_no = "";
	        	String skd_dir_cd = "";

		    	List<String> unitcostList 	= null;
		    	List<String> fromcostList 	= null;
		    	List<String> tocostList   	= null;
		    	float unitcost = 0;
		    	float fromcost = 0;
		    	float tocost   = 0;

	       		CommonDBDAO commondbDao = new CommonDBDAO(); // new PLN_SEQ 생성을 위해 생성
	       		
		    	// added by shin yongchan - 20080430		    	
		    	// CSR No : N200803140002
		    	String[] tableCost = null;
	    		for(int i = 0 ; i < vos.length ; i++){
	    			EesEqr0080MultiVO vo = (EesEqr0080MultiVO)vos[i];
	    			vol     = 0; 
	            	volList = new ArrayList<String>();
		        	
		        	unitcostList = new ArrayList<String>();
		        	fromcostList = new ArrayList<String>();
		        	tocostList   = new ArrayList<String>();
		        	unitcost     = 0;
		        	fromcost     = 0;
		        	tocost       = 0;
		        	
	            	flagList = new ArrayList<String>(); 
	            	flag     = "";
	            	
	            	tableCost = null;
	
	            	if(vo.getVvd().length() >= 9) {
	            		vsl_cd     = vo.getVvd().substring(0,4);            	
	            		skd_voy_no = vo.getVvd().substring(4,8);
	            		skd_dir_cd = vo.getVvd().substring(8,9);
	            	}
	            	if(vo.getIbflag().equals("I")) {	            		
	                	if(vo.getDiv().equals("Plan")) {  // Plan 입력
	                		// PLAN INSERT 가능한지 확인
	                		EqrInlndTrspPlnVO  checkEqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
	                		checkEqrInlndTrspPlnVO.setRepoPlnId(vo.getRepoPlnId());
	                		checkEqrInlndTrspPlnVO.setPlnYrwk(vo.getPlnYrwk());
	                		checkEqrInlndTrspPlnVO.setTrspModCd(vo.getTrspModCd());
	                		checkEqrInlndTrspPlnVO.setFmEccCd(vo.getFmYdCd());
	                		checkEqrInlndTrspPlnVO.setFmYrwk(vo.getFmEtdDt());
	                		checkEqrInlndTrspPlnVO.setToEccCd(vo.getToYdCd());
	                		checkEqrInlndTrspPlnVO.setToYrwk(vo.getToEtaDt());
	                		
	                		if(dbDao.inlandInsertCheck(checkEqrInlndTrspPlnVO)) {
	                  			String line = Integer.toString(i+1);
	                			String[] errMessage ={line, vo.getRepoPlnId()+","+vo.getPlnYrwk()+","+vo.getPlnSeq()};
	                			throw new DAOException(new ErrorHandler("EQR10025", errMessage).getMessage());
	                		
	                        // PLAN INSERT 대상이 LINK 정보를 가지고 있는지 확인. 
	                		}else if(dbDao.inlandInsertCheck_link(vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd())) {
	                			String[] errMessage ={" ("+vo.getFmYdCd()+"-"+vo.getToYdCd()+")"};
	                			log.debug(errMessage);
	                			throw new DAOException(new ErrorHandler("EQR10033", errMessage).getMessage());
	                			
	                		}else {	
	                			EqrInlndTrspPlnVO eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
    				       		ObjectCloner.build(vo , eqrInlndTrspPlnVO );
    				       		
	                			String plnSeq = commondbDao.getNextPlnSeq("EQR_INLND_TRSP_PLN", vo.getRepoPlnId(), vo.getPlnYrwk()).getResultString(); // pln_seq 생성
	                			eqrInlndTrspPlnVO.setPlnSeq(plnSeq);
	                			eqrInlndTrspPlnVO.setFmEccCd(vo.getFmYdCd());
	                			eqrInlndTrspPlnVO.setToEccCd(vo.getToYdCd());
	                			eqrInlndTrspPlnVO.setFmYrwk(vo.getFmEtdDt()); 
	                			eqrInlndTrspPlnVO.setToYrwk(vo.getToEtaDt());
	                			eqrInlndTrspPlnVO.setPastRepoPlnFlg("N");
    				       		dbDao.insertInlandPlan(eqrInlndTrspPlnVO,user_id); // EQR_INLND_TRSP_PLN 입력
    				       		
	                			for(int m=0; m<tpszArrInitial.length; m++) { // PLAN은 10개 TPSZ  사용
	                				tableCost = dbDao.searchUnitCost("P", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(), tpszArr[m]).getResultStrArray();

	    				       		fromcost = Float.parseFloat(tableCost[0]);
	    				       		tocost   = Float.parseFloat(tableCost[1]);
	    				       		unitcost = Float.parseFloat(tableCost[2]);	
	    				       		EqrInlndTrspPlnQtyVO eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
	    				       		ObjectCloner.build(vo , eqrInlndTrspPlnQtyVO );
	    				       		eqrInlndTrspPlnQtyVO.setPlnSeq(plnSeq);
	    				       		eqrInlndTrspPlnQtyVO.setCntrTpszCd(tpszArr[m]);
	    				       		eqrInlndTrspPlnQtyVO.setPlnUcAmt(String.valueOf(unitcost));
	    				       		eqrInlndTrspPlnQtyVO.setFmEccCostAmt(String.valueOf(fromcost));
	    				       		eqrInlndTrspPlnQtyVO.setToEccCostAmt(String.valueOf(tocost));
	    				       		eqrInlndTrspPlnQtyVO.setCntrQty("0");
	    				       		dbDao.insertInlandPlanQty(eqrInlndTrspPlnQtyVO,user_id); // EQR_INLND_TRSP_PLN_QTY 입력	     				       		
	                			}
	                		}
	                	}else {  // EXE 입력
	                		// ref_id 를 생성	
	                		ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_INLND_TRSP_EXE_PLN", vo.getCoCd(), vo.getRepoPlnId(), vo.getFmYdCd(), vo.getTrspModCd());
	                		
	                		EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
	                		ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
	                		eqrInlndTrspExePlnVO.setRefId(ref_id_new);
	                		eqrInlndTrspExePlnVO.setVslCd(vsl_cd);
	                		eqrInlndTrspExePlnVO.setSkdVoyNo(skd_voy_no);
	                		eqrInlndTrspExePlnVO.setSkdDirCd(skd_dir_cd);
	                		
	                		dbDao.insertInlandExecute(eqrInlndTrspExePlnVO,user_id);  // EQR_INLND_TRSP_EXE_PLN 입력
	                		
	                		for(int m=0; m<tpszArr.length; m++) {
	                			// type size별 volume 정보
	                			volList = vo.getVolList();
	                			vol    = Integer.parseInt((String)volList.get(m));	

	    				    	// type size별 amount 정보 vol * unitcost
	    				       	
	    				       	// type size별 unit cost, from cost, to cost 정보
	    				    	unitcostList = vo.getUnitcostList();
	    				    	fromcostList = vo.getFromcostList();
	    				    	tocostList	 = vo.getTocostList();
	    				       	unitcost    = Float.parseFloat((String)unitcostList.get(m));	
	    				       	fromcost    = Float.parseFloat((String)fromcostList.get(m));	
	    				       	tocost      = Float.parseFloat((String)tocostList.get(m));	
	    				       	
	    				    	// added by shin yongchan - 20080430		    	
	    				    	// CSR No : N200803140002
	    				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
	    				       	if(unitcost==0) {
	    				       		tableCost = dbDao.searchUnitCost("E", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd() , tpszArr[m]).getResultStrArray();

	    				       		fromcost = Float.parseFloat(tableCost[0]);
	    				       		tocost   = Float.parseFloat(tableCost[1]);
	    				       		unitcost = Float.parseFloat(tableCost[2]);	    				       		
 				       		
	    				       	}
	    				       	
	    				       	EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
	    				       	
		                		ObjectCloner.build(vo , eqrInlndTrspExePlnQtyVO );
		                		eqrInlndTrspExePlnQtyVO.setRefId(ref_id_new);
		                		eqrInlndTrspExePlnQtyVO.setCntrTpszCd(tpszArr[m]); 
		                		eqrInlndTrspExePlnQtyVO.setCntrQty(vol+"");
		                		eqrInlndTrspExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
		                		eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
		                		eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
		                		eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
		                		
		                		dbDao.insertInlandExecuteQty(eqrInlndTrspExePlnQtyVO,user_id);  // EQR_INLND_TRSP_EXE_PLN_QTY 입력	 
		                		
	                		}
	                		
	                		// EQR_EXE_PLN_CNTR 테이블 입력
	                		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
	                			
	                			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
	                			
	                			ObjectCloner.build(vo , eqrExePlnCntrVO );
	                			eqrExePlnCntrVO.setRefId(ref_id_new);
	                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
	                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
	                			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
	                			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
	                			
	                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);				         		
	                		} 
	                		
	                	}
	            	}else if(vo.getIbflag().equals("U")) {	   
	            		// -- vol 적용합니다. ----------------------------------  	                    	 
					    for(int m=0; m<tpszArr.length; m++) {				    	
					    	// type size별 volume 정보
					    	volList = vo.getVolList();
					       	vol    = Integer.parseInt((String)volList.get(m));	

					    	// type size별 volume 정보  vol * unitcost
					       	
					       	// flag 정보 (T, F)
					       	flagList = vo.getFlagList();
					       	flag    = (String)flagList.get(m);	// flag
							
    				       	// type size별 unit cost, from cost, to cost 정보
    				    	unitcostList = vo.getUnitcostList();
    				    	fromcostList = vo.getFromcostList();
    				    	tocostList	 = vo.getTocostList();
    				       	unitcost    = Float.parseFloat((String)unitcostList.get(m));	
    				       	fromcost    = Float.parseFloat((String)fromcostList.get(m));	
    				       	tocost      = Float.parseFloat((String)tocostList.get(m));	
    				       	
							if(flag.equals("T")) {
								
	    				    	// added by shin yongchan - 20080430		    	
	    				    	// CSR No : N200803140002
	    				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
	    				       	if(unitcost==0) {
	    				       		tableCost = dbDao.searchUnitCost("E", vo.getFmYdCd(), vo.getToYdCd() , vo.getTrspModCd(), tpszArr[m]).getResultStrArray();
	    				       		
	    				       		fromcost = Float.parseFloat(tableCost[0]);
	    				       		tocost   = Float.parseFloat(tableCost[1]);
	    				       		unitcost = Float.parseFloat(tableCost[2]);

	    				       		//log.debug("\n------------------- in start UPDATE dao ---------- ");
	    				       		//log.debug("\n------------------- in start UPDATE dao ---------- tableCost[0] : " + tableCost[0]);
	    				       		//log.debug("\n------------------- in start UPDATE dao ---------- tableCost[0] : " + tableCost[1]);
	    				       		//log.debug("\n------------------- in start UPDATE dao ---------- tableCost[0] : " + tableCost[2]);
	    				       	}
	    				       	EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
	    				       	ObjectCloner.build(vo , eqrInlndTrspExePlnQtyVO );
	    				       	//eqrInlndTrspExePlnQtyVO.setRefId(ref_id_new);
		                		eqrInlndTrspExePlnQtyVO.setCntrTpszCd(tpszArr[m]); 
		                		eqrInlndTrspExePlnQtyVO.setCntrQty(vol+"");
		                		eqrInlndTrspExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
		                		eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
		                		eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
		                		eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
	    				       	dbDao.mergeInlandExecuteQty(eqrInlndTrspExePlnQtyVO, user_id, soFlag);
							}
							
					    }
					    EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
                		ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
                		//eqrInlndTrspExePlnVO.setRefId(ref_id_new);
                		eqrInlndTrspExePlnVO.setVslCd(vsl_cd);
                		eqrInlndTrspExePlnVO.setSkdVoyNo(skd_voy_no);
                		eqrInlndTrspExePlnVO.setSkdDirCd(skd_dir_cd);
                		if(soFlag.equals("Y") && vo.getSoIssFlg().equals("1")){
                			eqrInlndTrspExePlnVO.setExeIssFlg("Y");
                		}
                		dbDao.updateInlandExecute(eqrInlndTrspExePlnVO,user_id, soFlag);  // EQR_INLND_TRSP_EXE_PLN 수정
                		// EQR_ONF_HIR_EXE_PLN_CNTR 테이블 삭제후 새로 입력
	            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
	            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			//eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
                			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
                			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);			
                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);					         		
	    				}    
	            		// EQR_ONF_HIR_EXE_PLN_CNTR 테이블 삭제
	            		if(vo.getCntrDel().equals("Y")) {
	            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			//eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
                			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
                			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);				         		
	    				}    
	            	}else if(vo.getIbflag().equals("D")) {	   
	            		// EQR_EXE_PLN_CNTR 테이블 삭제
	            		EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			//eqrExePlnCntrVO.setRefId(ref_id_new);
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);	
            			
            			// EQR_ECC_INTER_EXE_PLN_QTY 테이블 삭제
            			EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
				       	ObjectCloner.build(vo , eqrInlndTrspExePlnQtyVO );
            			dbDao.deleteInlandExecuteQty(eqrInlndTrspExePlnQtyVO);

            			// EQR_ECC_INTER_EXE_PLN 테이블 삭제
            			EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
                		ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
            			dbDao.deleteInlandExecute(eqrInlndTrspExePlnVO);
	            	}
	    		}
	    	}
	    	
	    } catch (Exception de) {
	        log.error("err "+de.toString(),de);
	        throw new EventException(de.getMessage());
	    }
	}	

	/**
     * 수정 이벤트 처리<br>
     * EES_EQR_080 에 대한 추가 이벤트 처리<br>
     * 
     * @param conditionVO	EesEqr0059ConditionVO
	 * @param vos			EesEqr0080MultiVO[]
	 * @param account		SignOnUserAccount
     * @exception EventException
     */
    public void soSendTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException {
                
    	DBRowSet dbRowset = null;
    	String user_id = account.getUsr_id(); // user id information
    	
    	// dbDao.modifyTruckAndRailAndBargeCntrRepoPlan 로직 SC 에서 처리함 
    	
    	// EQR_REPO_EXE_SO_IF 입력수정
    	// dbDao.soSendTruckAndRailAndBargeCntrRepoPlan(event, userId);      // EQR_REPO_EXE_SO_IF
    	String tpszType = conditionVO.getTpsztype();
		String[] tpszArr= tpszType.split(",");
        
        List<String> volList 	 = null;
        
    	int vol          = 0;    // type size별 vol 수량

        int seq = 1; 		// EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
        int cntrSeq = 0;  	// EQR_EXE_PLN_CNTR에서 검색된 CNTR_NO의 사용을 통제

        // EQR_EXE_PLN_CNTR 테이블에서 검색된 CNTR_TPSZ_CD, CNTR_NO
        String[] cntrTpsz = null;
        String[] cntrNo   = null;
        ArrayList<String> v1 = null;
        ArrayList<String> v2 = null;
        
    	// VVL 분리
    	String vsl_cd     = null;
    	String skd_voy_no = null;
    	String skd_dir_cd = null;
    	
    	// office code
    	String office_code = null;
        try {        	         
        	        	
			/*
			 * CSR No : N200807310009
			 * added by shin yongchan - 20080731
			 * Senator S/O Send 방식변경 EAT --> WTC
			 * 
			 * Senator 로직 삭제 됨 09.09.07 By ChungEunHo
			 */
        	// ---- START

        	
        	if(vos != null && vos.length > 0){
        		for(int k=0; k< vos.length; k++) {
        			EesEqr0080MultiVO vo = vos[k];
        			if(vo.getSoIssFlg().equals("1")) {
        				// ------------ EQR_REPO_EXE_SO_IF INSERT LOGIC ---------------------
    	            	vol     = 0; 
    	            	volList = new ArrayList<String>();
    	            	cntrSeq = 0; // EQR_EXE_PLN_CNTR에서 검색된 CNTR_NO의 사용을 통제
    	            	seq = 1; 	 // EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
    	            	v1 = new ArrayList<String>();
    	            	v2 = new ArrayList<String>();
    	            	
    	            	if(vo.getVvd().length() >= 9) {
    	            		vsl_cd     = vo.getVvd().substring(0,4);            	
    	            		skd_voy_no = vo.getVvd().substring(4,8);
    	            		skd_dir_cd = vo.getVvd().substring(8,9);
    	            	}   
    	            	office_code = null;
    	            	for(int m=0; m<tpszArr.length; m++) {
    		            	
    	            		// type size별 volume 정보
    	            		volList = vo.getVolList();
    	            		vol    = Integer.parseInt((String)volList.get(m));	
    	            		EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
    	            		ObjectCloner.build(vo , eqrExePlnCntrVO );
    	            		eqrExePlnCntrVO.setCntrTpszCd(tpszArr[m]);
    	            		dbRowset = dbDao.searchInlandContainer(eqrExePlnCntrVO).getDbRowset();
    	            		while(dbRowset.next()){
    	            			v1.add(dbRowset.getString("CNTR_TPSZ_CD"));
    	        	        	v2.add(dbRowset.getString("CNTR_NO"));
    	            		}
    	            		cntrTpsz = new String[v1.size()];
    	        	        cntrNo   = new String[v2.size()];
    	        	        
    	        	        for(int v=0; v < v1.size(); v++) {
    	        	        	cntrTpsz[v] = (String)v1.get(v);
    	        	            cntrNo[v]   = (String)v2.get(v);        	            
    	                	}
    	

    	            		// search office code 
    	            		// type size별로 검색함
    	            		// co_cd = H & type size별 vol>0 만 office code 검색
    	            		// co_cd = S는  office code검색 안함.
    	        	        if( vol > 0) {
    	        	        	if(vo.getTrspModCd().equals("R") && vo.getFrlocRcc().equals("USNYC") && !"MX".equals(vo.getFrlocEcc().substring(0, 2))) { // USNYC, RAIL은 PHXSC로 하드코딩 - 멕시코는 제외
    	        	        		office_code = "PHXSC";
    	        	        	}else {
    	        	        		List<CommonVO> target_key_list = new ArrayList<CommonVO>();
    	        	        		CommonVO joinkey = new CommonVO();
    	        	        		joinkey.setField1("REPO_PLN_ID");
    	        	        		joinkey.setField2("REPO_PLN_ID");
    	        	        		target_key_list.add(joinkey);
    	        	        		joinkey = new CommonVO();
    	        	        		joinkey.setField1("PLN_YRWK");
    	        	        		joinkey.setField2("PLN_YRWK");
    	        	        		target_key_list.add(joinkey);
    	        	        		joinkey = new CommonVO();
    	        	        		joinkey.setField1("PLN_SEQ");
    	        	        		joinkey.setField2("PLN_SEQ");
    	        	        		target_key_list.add(joinkey);
    	        	        		joinkey = new CommonVO();
    	        	        		joinkey.setField1("REF_ID");
    	        	        		joinkey.setField2("REF_ID");
    	        	        		target_key_list.add(joinkey);
    	        	        		
    	        	        		office_code = dbDao.searchOfficeCode("EQR_INLND_TRSP_EXE_PLN","EQR_INLND_TRSP_EXE_PLN_QTY",target_key_list , vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getRefId(),vo.getPlnSeq(), tpszArr[m]).getResultString();
    	        	        	}
    	        	        }else {
    	        	        	office_code = null;
    	        	        }
    	        	        for(int j=0; j<vol; j++) {    // type size별 vol만큼 insert 합니다. 
    	        				
    	        	        	EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
    	        	        	ObjectCloner.build(vo , eqrRepoExeSoIfVO );
    	        	        	eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
    	        	        	eqrRepoExeSoIfVO.setCntrTpszCd(tpszArr[m]);
    	        	        	eqrRepoExeSoIfVO.setSoIfDivCd(vo.getTrspModCd());
    	        	        	eqrRepoExeSoIfVO.setFmDt(vo.getFmEtdDt());
    	        	        	eqrRepoExeSoIfVO.setToDt(vo.getToEtaDt());
    	        	        	eqrRepoExeSoIfVO.setVslCd(vsl_cd);
    	        	        	eqrRepoExeSoIfVO.setSkdVoyNo(skd_voy_no);
    	        	        	eqrRepoExeSoIfVO.setSkdDirCd(skd_dir_cd);
    	        	        	// CNTR NO 입력은 VOL만큼 입력하지만 CNTR이 있으면 넣어준다.
    	        				if(cntrNo.length > 0) {
    	        					if(cntrNo.length > cntrSeq) {
    	        						eqrRepoExeSoIfVO.setCntrNo(cntrNo[cntrSeq++]); // CNTR_NO
    	        					}else{
    	        						eqrRepoExeSoIfVO.setCntrNo("");
    	        					}
    	        				}else{
    	        					eqrRepoExeSoIfVO.setCntrNo("");
    	        				}
    	        				eqrRepoExeSoIfVO.setWoExeFlg("N");
    	        				eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
    	        				eqrRepoExeSoIfVO.setSoRqstDt(vo.getFmEtdDt());
    	        				eqrRepoExeSoIfVO.setWoRqstFlg("Y");
    	        				eqrRepoExeSoIfVO.setTrspSoStsCd("P");
    	        				
    	        				dbDao.createInlandSoData(eqrRepoExeSoIfVO,user_id);
    	        				
    	        	        }    	        	        
    	            	}    	            		
        			}
        		}
        	}
        	// ----- END        	
        	
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	    
    /**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   DELETE : REF_ID 별로 위의 검색요건을 만족하면 삭제 수행 <br>
	           - EQR_REPO_EXE_SO_IF       삭제   ( 해당 REF_ID )<br>		
	           - EQR_EXE_PLN_CNTR         삭제   ( 해당 REF_ID )<br>
	           - EQR_INLND_TRSP_EXE_PLN   삭제   ( 해당 REF_ID )<br>
	 *          
     * @param conditionVO	EesEqr0059ConditionVO
     * @param vos			EesEqr0080MultiVO[]
     * @param account		SignOnUserAccount
     * @exception EventException
     */
    public void soCancelTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException {
    	String user_id = account.getUsr_id(); // user id information
    	String exeFlag = "N";
    	try
		{
    		//dbDao.soCancelTruckAndRailAndBargeCntrRepoPlan(event, userId);  // 순서 매우 중요함. 
    		if(vos != null && vos.length > 0) {
	    		for(int i = 0 ; i < vos.length ; i++ ){
	    			EesEqr0080MultiVO vo = vos[i];
	    			// SO SEND 체크박스 클릭 && SO CANCEL='T' 된것만 삭제 대상에 포함됨.			
	            	if(vo.getSoIssFlg().equals("1") && vo.getSoCancelFlag().equals("T")) {    
	            	
	            		// REF_ID 별로 삭제요건을 만족(Y)하는 경우 3개 테이블 순서대로 삭제
	            		exeFlag = dbDao.soCancelCheckCntrRepoPlan(vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getPlnSeq() , vo.getRefId()).getResultString();
	            		if(exeFlag.equals("Y")) {
	            			
	            			// --- EQR_REPO_EXE_SO_IF  DELETE -------------------------------
	            			EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
	        	        	ObjectCloner.build(vo , eqrRepoExeSoIfVO );
	        	        	
	        	        	dbDao.deleteInlandSoData(eqrRepoExeSoIfVO);

	        	        	
	               	   		// --- EQR_INLND_TRSP_EXE_PLN  SO FLAG 초기화 -------------------- EXE_RQST_DT 는 초기화 하지 않음
	        	        	EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
	        	        	ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
	        	        	dbDao.updateInitInlandExecute(eqrInlndTrspExePlnVO, user_id);
	        	        		               	   		
	               	   		// --- EQR_EXE_PLN_CNTR   DELETE(WATER, BKG NO 존재할때만 사용) -- 
	               	   		if(vo.getTrspModCd().equals("W") && vo.getRepoMtyBkgFlg().equals("1")) {
	               	   			
	               	   			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
	               	   			ObjectCloner.build(vo , eqrExePlnCntrVO );
	               	   			dbDao.deleteInlandCntr(eqrExePlnCntrVO);
	               	   		}
	               	   		
	                	}else {
	                		throw new DAOException(new ErrorHandler("EQR10027").getMessage());
	                	}  
	            	}
	    		}
    		}
    		
    		
		} catch (Exception de) {
	        log.error("err "+de.toString(),de);
	        throw new EventException(de.getMessage());
	    }
    }
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_108 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param conditionVO	EesEqr0108ConditionVO
	 * @param vos			EesEqr0108MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCombineExecution(EesEqr0108ConditionVO conditionVO ,EesEqr0108MultiVO[] vos , SignOnUserAccount account) throws EventException
	{
		String repo_pln_id = conditionVO.getRepoPlanId();   // repo plan id			
		String tab = conditionVO.getTab();                  // 1: vessel, 2: truck
		try
		{
			String user_id = account.getUsr_id();
			String tpszType = conditionVO.getTpsztype();
			String[] tpszArr= tpszType.split(",");
			
			String ref_id_new = "";	 // ref_id 변수
			String combin_ref_id = ""; // EQR_ECC_INTER_EXE_PLN 테이블에 입력되는 VESSEL, INLAND  REF_ID정
            
            List<String> volList 	 = null;
        	int vol          = 0;    // type size별 vol 수량

        	// VVL 분리
        	String vsl_cd     = "";
        	String skd_voy_no = "";
        	String skd_dir_cd = "";

        	String fromInterYard = "";  // ECC INTERNAL FROM YARD
        	String toInterYard   = "";  // ECC INTERNAL TO YARD
        	String fromInterDt   = "";  // ECC INTERNAL FROM DT
        	String toInterDt     = "";  // ECC INTERNAL TO DT
        	
        	String fromYard      = "";  // FROM YARD(VESSEL, TRUCK)
        	String toYard        = "";  // TO YARD(VESSEL, TRUCK)
        	String fromDt        = "";  // FROM DT(VESSEL, TRUCK)
        	String toDt          = "";  // TO DT(VESSEL, TRUCK)

            // AMT, UNIT COST, FROM COST, TO COST 추가  -- ADDED BY SHIN YONGCHAN 20080220
            // CSR NO : N200802190007
        	//List amtList        = null;
	    	List<String> unitcostList 	= null;
	    	List<String> fromcostList 	= null;
	    	List<String> tocostList   	= null;	
			//float amt      = 0;
	    	float unitcost = 0;
	    	float fromcost = 0;
	    	float tocost   = 0;
	    	
	    	// added by shin yongchan - 20080430		    	
	    	// CSR No : N200803140002
	    	String[] tableCost = null;
	    	
	    	for(int k = 0 ; k < vos.length ; k++){
	    		EesEqr0108MultiVO vo = vos[k];
	    		vol     = 0; 
            	volList = new ArrayList<String>();

	        	unitcostList = new ArrayList<String>();
	        	fromcostList = new ArrayList<String>();
	        	tocostList   = new ArrayList<String>();
	        	
	        	unitcost     = 0;
	        	fromcost     = 0;
	        	tocost       = 0;
	        	
	        	tableCost = null;	  
	        	if(vo.getIbflag().equals("I")) {

                	// 작업대상을 결정 (ECC1, ECC2, ECC3를 비교)
                	// ECC가 같으면 ECC INTERNAL
                	// ECC가 다르고 TAB : 1 - VESSEL
                	//             TAB : 2 - TRUCK
                	
                	if(vo.getEcc1().equals(vo.getEcc2())) {
                		fromInterYard = vo.getYdCd1();//yd1[k];
                		toInterYard   = vo.getYdCd2();//yd2[k];
                		fromInterDt   = vo.getDt1().replaceAll("-", "").substring(0,8);
                		toInterDt     = vo.getDt2().replaceAll("-", "").substring(0,8);
                		
                		// VESSEL, TRUCK
                		fromYard      = vo.getYdCd2();
                		toYard        = vo.getYdCd3();
                		fromDt        = vo.getDt2();
                		toDt          = vo.getDt3();
                		
                	}else if(vo.getEcc2().equals(vo.getEcc3())) {
                		fromInterYard = vo.getYdCd2();
                		toInterYard   = vo.getYdCd3();
                		fromInterDt   = vo.getDt2().replaceAll("-", "").substring(0,8);
                		toInterDt     = vo.getDt3().replaceAll("-", "").substring(0,8);
                		
                		//  VESSEL, TRUCK
                		fromYard      = vo.getYdCd1();
                		toYard        = vo.getYdCd2();
                		fromDt        = vo.getDt1();
                		toDt          = vo.getDt2();                	
                	}
 
                	if(vo.getVvd().length() >= 9) {
                		vsl_cd     = vo.getVvd().substring(0,4);            	
                		skd_voy_no = vo.getVvd().substring(4,8);
                		skd_dir_cd = vo.getVvd().substring(8,9);
                	}
                	// ---- VESSEL (START) ---------------------------------------------
                	if(tab.equals("1")) {  		// VESSEL
                   	    // ref_id 를 생성	
                   	    ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_VSL_LODG_DCHG_EXE_PLN", vo.getCoCd(), repo_pln_id, fromYard, "V");
                   	    combin_ref_id = ref_id_new;
                   	    EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
                   	    
                   	    ObjectCloner.build(vo , eqrVslLodgDchgExePlnVO );
                   	    eqrVslLodgDchgExePlnVO.setRepoPlnId(repo_pln_id);
                   	    eqrVslLodgDchgExePlnVO.setRefId(ref_id_new);
                   	    eqrVslLodgDchgExePlnVO.setTrspModCd(vo.getTrspMode());
                   	    eqrVslLodgDchgExePlnVO.setVslLaneCd(vo.getLane());
                   	    eqrVslLodgDchgExePlnVO.setVslCd(vsl_cd);
	                   	eqrVslLodgDchgExePlnVO.setSkdVoyNo(skd_voy_no);
	                   	eqrVslLodgDchgExePlnVO.setSkdDirCd(skd_dir_cd);
	                   	eqrVslLodgDchgExePlnVO.setFmYdCd(fromYard);
	                   	eqrVslLodgDchgExePlnVO.setFmEtdDt(fromDt);
	                   	eqrVslLodgDchgExePlnVO.setToYdCd(toYard);
	                   	eqrVslLodgDchgExePlnVO.setToEtbDt(toDt);
	                   	eqrVslLodgDchgExePlnVO.setSplitRepoPlnFlg("N");
	                   	eqrVslLodgDchgExePlnVO.setPastRepoPlnFlg("N");
	                   	
                   	    dbDao.insertCombineExecutionVessel(eqrVslLodgDchgExePlnVO, user_id); // EQR_VSL_LODG_DCHG_EXE_PLN 입력
                   	    
                   	    for(int m=0; m<tpszArr.length; m++) {
 				    	
	 				    	// type size별 volume 정보
                   	    	volList = vo.getVolList();
	 				       	vol    = Integer.parseInt((String)volList.get(m));		
	 				       
	 				    	//amtList		= vo.getAmtList();
	 				    	unitcostList= vo.getUnitcostList();
	 				    	fromcostList= vo.getFromcostList();
	 				    	tocostList	= vo.getTocostList();
	 				    	//amt         = Float.parseFloat((String)amtList.get(m));	
	 				       	unitcost    = Float.parseFloat((String)unitcostList.get(m));	
	 				       	fromcost    = Float.parseFloat((String)fromcostList.get(m));	
	 				       	tocost      = Float.parseFloat((String)tocostList.get(m));	
	 				       	
	 				    	// added by shin yongchan - 20080506		    	
	 				    	// CSR No : N200803140002
	 				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
	 				       	if(unitcost==0) {
	 				       		tableCost = dbDao.searchUnitCost("E", fromYard, toYard, vo.getTrspMode(), tpszArr[m]).getResultStrArray();
	 				       		
	 				       		fromcost = Float.parseFloat(tableCost[0]);
	 				       		tocost   = Float.parseFloat(tableCost[1]);
	 				       		unitcost = Float.parseFloat(tableCost[2]);	
	 				       	}
                  	    	
	 				       	EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();
	 				       	ObjectCloner.build(vo , eqrVslExePlnQtyVO );
	 				       	eqrVslExePlnQtyVO.setRepoPlnId(repo_pln_id);
	 				       	eqrVslExePlnQtyVO.setRefId(ref_id_new);
	 				       	eqrVslExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
	 				       	eqrVslExePlnQtyVO.setCntrQty(vol+"");
	 				       	eqrVslExePlnQtyVO.setPlnUcAmt(unitcost+"");
	 				       	eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost+"");
	 				       	eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost+"");
	 				       	eqrVslExePlnQtyVO.setLodgDchgCostAmt((vol * unitcost) +"");
	 				       	dbDao.insertCombineExecutionVesselQty(eqrVslExePlnQtyVO, user_id); // EQR_VSL_LODG_DCHG_EXE_PLN_QTY 입력
                   	    }
                   	    // EQR_EXE_PLN_CNTR 테이블 입력
                		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
                			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			eqrExePlnCntrVO.setRepoPlnId(repo_pln_id);
                			eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setTrspModCd(vo.getTrspMode());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getEcc1());
                			eqrExePlnCntrVO.setToEccCd(vo.getEcc3());
                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);			         		
        				}  
                	// ---- TRUCK (START) ---------------------------------------------	
                	}else if(tab.equals("2")) { // TRUCK
                		 ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_INLND_TRSP_EXE_PLN", vo.getCoCd(), repo_pln_id, fromYard, vo.getTrspMode());
                    	 combin_ref_id = ref_id_new;
                    	 
	                	 EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
	                	 ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
	                	 eqrInlndTrspExePlnVO.setRepoPlnId(repo_pln_id);	                	 
	                	 eqrInlndTrspExePlnVO.setRefId(ref_id_new);
	                	 eqrInlndTrspExePlnVO.setTrspModCd(vo.getTrspMode());
	                	 eqrInlndTrspExePlnVO.setVslLaneCd(vo.getLane());
	                	 eqrInlndTrspExePlnVO.setVslCd(vsl_cd);
	                	 eqrInlndTrspExePlnVO.setSkdVoyNo(skd_voy_no);
	                	 eqrInlndTrspExePlnVO.setSkdDirCd(skd_dir_cd);
	                	 eqrInlndTrspExePlnVO.setFmYdCd(fromYard);
	                	 eqrInlndTrspExePlnVO.setFmEtdDt(fromDt);
	                	 eqrInlndTrspExePlnVO.setToYdCd(toYard);
	                	 eqrInlndTrspExePlnVO.setToEtaDt(toDt);
	                	 eqrInlndTrspExePlnVO.setPastRepoPlnFlg("N");  //past repo plan falg --> combined 에 입력되는 것은 모두 'N'
                	     	
	                	 dbDao.insertInlandExecute(eqrInlndTrspExePlnVO,user_id);  // EQR_INLND_TRSP_EXE_PLN 입력 080 화면  modifyTruckAndRailAndBargeCntrRepoPlan 에서 호출되는 메소드 와 동일함
                    	 
                    	 for(int m=0; m<tpszArr.length; m++) {
     				    	
                    		 // type size별 volume 정보
                    		 volList = vo.getVolList();
                    		 vol    = Integer.parseInt((String)volList.get(m));	
                    		 
                    		 //amtList = vo.getAmtList();
                    		 unitcostList = vo.getUnitcostList();
                    		 fromcostList = vo.getFromcostList();
                    		 tocostList	  = vo.getTocostList();
                    		 //amt         = Float.parseFloat((String)amtList.get(m));	
                    		 unitcost    = Float.parseFloat((String)unitcostList.get(m));	
                    		 fromcost    = Float.parseFloat((String)fromcostList.get(m));	
                    		 tocost      = Float.parseFloat((String)tocostList.get(m));	
							
                    		 // added by shin yongchan - 20080506		    	
                    		 // CSR No : N200803140002
                    		 // unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
                    		 if(unitcost==0) {
                    			 tableCost = dbDao.searchUnitCost("E", fromYard, toYard, vo.getTrspMode(), tpszArr[m]).getResultStrArray();
							
                    			 fromcost = Float.parseFloat(tableCost[0]);
                    			 tocost   = Float.parseFloat(tableCost[1]);
                    			 unitcost = Float.parseFloat(tableCost[2]);	    				       		
                    		 }
                    		 EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
                    		 ObjectCloner.build(vo , eqrInlndTrspExePlnQtyVO );
                    		 eqrInlndTrspExePlnQtyVO.setRepoPlnId(repo_pln_id);
                    		 eqrInlndTrspExePlnQtyVO.setRefId(ref_id_new);
                    		 eqrInlndTrspExePlnQtyVO.setCntrTpszCd(tpszArr[m]); 
                    		 eqrInlndTrspExePlnQtyVO.setCntrQty(vol+"");
                    		 eqrInlndTrspExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
                    		 eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
                    		 eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
                    		 eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
	                		
                    		 dbDao.insertInlandExecuteQty(eqrInlndTrspExePlnQtyVO,user_id);  // EQR_INLND_TRSP_EXE_PLN_QTY 입력	
                    		 
                    	 }
                    	// EQR_EXE_PLN_CNTR 테이블 입력
                 		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
                 			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			eqrExePlnCntrVO.setRepoPlnId(repo_pln_id);
                			eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setTrspModCd(vo.getTrspMode());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getEcc1());
                			eqrExePlnCntrVO.setToEccCd(vo.getEcc3());
                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);	
         				}
                	}
                	// ---- ECC INTERNAL (START) ---------------------------------------------
               	    // ref_id 를 생성	           	    	
               	    ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_ECC_INTER_EXE_PLN", vo.getCoCd(), repo_pln_id, fromInterYard, "S");
               	    EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
               	    ObjectCloner.build(vo , eqrEccInterExePlnVO );
               	    eqrEccInterExePlnVO.setRepoPlnId(repo_pln_id);
               	    eqrEccInterExePlnVO.setRefId(ref_id_new);
               	    eqrEccInterExePlnVO.setCmbRefId(combin_ref_id);
               	    // 20070607 운송모드를 추가하게 될 것임.
           	    	// COMBINED EXE에서는 'T'(TRUCK) 로 하드코딩
               	    eqrEccInterExePlnVO.setTrspModCd("T");
               	    
               	    eqrEccInterExePlnVO.setFmYdCd(fromInterYard);
               	    eqrEccInterExePlnVO.setFmEtdDt(fromInterDt);
               	    eqrEccInterExePlnVO.setToYdCd(toInterYard);
               	    eqrEccInterExePlnVO.setToEtaDt(toInterDt);
               	    
               	    
               	    dbDao.insertCombineExecutionInternal(eqrEccInterExePlnVO, user_id); // EQR_ECC_INTER_EXE_PLN 입력
               	    
               	    for(int m=0; m<tpszArr.length; m++) {
				    	
				    	// type size별 volume 정보
               			volList = vo.getVolList();
				       	vol    = Integer.parseInt((String)volList.get(m));	

				    	// added by shin yongchan - 20080506		    	
				    	// CSR No : N200803140002
				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
				       	tableCost = dbDao.searchUnitCost("I", fromInterYard, toInterYard, "T", tpszArr[m]).getResultStrArray();
				       		
				       	unitcost = Float.parseFloat(tableCost[2]);	 
				       	EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
				       	ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
				       	eqrEccInterExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
				       	eqrEccInterExePlnQtyVO.setRepoPlnId(repo_pln_id);
				       	eqrEccInterExePlnQtyVO.setRefId(ref_id_new);
				       	eqrEccInterExePlnQtyVO.setCntrQty(vol+"");
				       	eqrEccInterExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
				       	dbDao.insertCombineExecutionInternalQty(eqrEccInterExePlnQtyVO, user_id); // EQR_ECC_INTER_EXE_PLN_QTY 입력
               	    }
               	    // ADDED BY SHIN YONGCHAN, CONFIRMED BY RYU MUNPIL - 20070827
				    // COMBINED INSERT에서 ECC INTERNAL의 REF_ID에도 CNTR NO를 입력				    
            		// EQR_EXE_PLN_CNTR 테이블 입력
            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setRepoPlnId(repo_pln_id);
            			eqrExePlnCntrVO.setRefId(ref_id_new);
            			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
            			eqrExePlnCntrVO.setTrspModCd(vo.getTrspMode());
            			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			// Add By 이병훈(2010.04.09)
            			eqrExePlnCntrVO.setPlnSeq("0");
            			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);
    				}  				    

                	// ---- ECC INTERNAL (END) ---------------------------------------------
	        	} // ibflag I                   	    
	    	}
	    } catch (Exception de) {
	        log.error("err "+de.toString(),de);
	        throw new EventException(de.getMessage());
	    }
	}
	
	/**
	 * [ EES_EQR_0130 : BKG Split Create - Default, 화면 로딩시 Booking 정보 조회하여 보여주기.]<br>
	 * 
	 * @param String bkg_no
	 * @return List<SearchExecutionPlanBkgNoVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanBkgNoVO> searchCntrRepoExecutionPlanBkgNoInfo(String bkg_no) throws EventException {
		try {
			return dbDao.searchCntrRepoExecutionPlanBkgNoInfo(bkg_no);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ EES_EQR_0130 : BKG Split Create - Container List] <br>
	 * 
	 * @param eesEqr0130ConditionVO EesEqr0130ConditionVO
	 * @return List<SearchExecutionPlanSplitCntrVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanSplitCntrVO> searchCntrRepoExecutionPlanSplitCntrList(EesEqr0130ConditionVO eesEqr0130ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoExecutionPlanSplitCntrList(eesEqr0130ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - Default ] <br>
	 * 
	 * @return List<SearchExecutionPlanBkgNoVO>
	 * @exception EventException
	 */
	public SearchEqrOrganizationVO searchEqrOrganizationChartCount() throws EventException {
		try {
			return dbDao.searchEqrOrganizationChartCount();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - List ] <br>
	 * 
	 * @return List<SearchEqrOrganizationVO>
	 * @exception EventException
	 */
	public List<SearchEqrOrganizationVO> searchEqrOrganizationChart() throws EventException {
		try {
			return dbDao.searchEqrOrganizationChart();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_081Event 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
    public CommonRsVO searchOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException {
	    try{
	    	return dbDao.searchOnHireAndOffHireCntrRepoPlan(eesEqr0059ConditionVO);
	    } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }

    /**
     * 수정 이벤트 처리<br>
     * EES_EQR_081 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0081MultiVO[]
	 * @param account SignOnUserAccount 
     * @exception EventException
     */
	public void modifyOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] vos , SignOnUserAccount account) throws EventException {
		
		String tpszType = eesEqr0059ConditionVO.getTpsztype();
		String[] tpszArrInitial = eesEqr0059ConditionVO.getTpszInitial().split(","); // add plan에만 사용됨. 
		String[] tpszArr= tpszType.split(",");
		String user_id	= account.getUsr_id();
		
		String ref_id_new = "";	 // ref_id 변수
								
		int rowCount = (vos==null) ? 0 : vos.length;                            
        
        List<String> volList 	 = null;
    	int vol          = 0;    // type size별 vol 수량
    	
    	List<String> flagList	 = null;
    	String flag      = "";

        List<String> amtList 	 = null;
    	float amt        = 0;    // type size별 amt 수량
    	
    	List<String> unitcostList 	= null;
    	float unitcost = 0;

    	// added by shin yongchan - 20080507		    	
    	// CSR No : N200803140002
    	String[] tableCost = null;
    	String soFlag = eesEqr0059ConditionVO.getSoFlag();
    	try{
    		CommonDBDAO commondbDao = new CommonDBDAO(); // new PLN_SEQ 생성을 위해 생성
    		
	    	for(int k=0; k<rowCount; k++) {
	    		EesEqr0081MultiVO vo = vos[k];
	    		vol     = 0; 
	        	volList = new ArrayList<String>();
	
	        	amt     = 0; 
	        	amtList = new ArrayList<String>();
	        	
	        	unitcostList = new ArrayList<String>();
	        	unitcost     = 0;
	        	
	        	flagList = new ArrayList<String>(); 
	        	flag     = "";           
	        	
	        	tableCost = null;
	            
	        	// modifyCntrRepoPlanDetail 메소드 변수에 영향을 미침 
				if(vo.getTrspModCd().equals("F")) vo.setTolocEcc("XXXXX");
				else                              vo.setFrlocEcc("XXXXX");
				if(vo.getIbflag().equals("I")) {               	
	            	if(vo.getDiv().equals("Plan")) {  // Plan 입력
	            		if(dbDao.onOffHireInsertCheck(vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getTrspModCd(), vo.getFmYdCd())) {
	            			
	            			// InsertOnOffHirePlan
	            			String plnSeq = commondbDao.getNextPlnSeq("EQR_ONF_HIR_PLN", vo.getRepoPlnId(), vo.getPlnYrwk()).getResultString(); // pln_seq 생성
	            			EqrOnfHirPlnVO eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
	            			ObjectCloner.build(vo , eqrOnfHirPlnVO );
	            			eqrOnfHirPlnVO.setPlnSeq(plnSeq);
	            			eqrOnfHirPlnVO.setOnfHirDivCd(vo.getTrspModCd());
	            			eqrOnfHirPlnVO.setEccCd(vo.getFmYdCd());
	            			eqrOnfHirPlnVO.setCntrLstmCd(vo.getLeaseTerm()); // "XX" 기본값 
	            			dbDao.insertOnOffHirePlan(eqrOnfHirPlnVO, user_id);
	            			
	            			for(int m=0; m<tpszArrInitial.length; m++) {

        				    	// added by shin yongchan - 20080507		    	
        				    	// CSR No : N200803140002
        				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
        				       	tableCost = dbDao.searchUnitCost("P", vo.getFmYdCd(), vo.getToYdCd(),vo.getTrspModCd(), tpszArrInitial[m]).getResultStrArray();
        				       	// tpszArr[m] - > tpszArrInitial[m] 로 변경함 modify by ChungEunHo 09.10.19
        				       	unitcost = Float.parseFloat(tableCost[2]);	
        				       	
        				       	EqrOnfHirPlnQtyVO eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
        				       	ObjectCloner.build(vo , eqrOnfHirPlnQtyVO );
        				       	eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
        				       	eqrOnfHirPlnQtyVO.setCntrQty("0");
        				       	eqrOnfHirPlnQtyVO.setCntrTpszCd(tpszArrInitial[m]);
        				       	eqrOnfHirPlnQtyVO.setPlnUcAmt(unitcost+"");
        				       	dbDao.insertOnOffHirePlanQty(eqrOnfHirPlnQtyVO, user_id);
	            			}
	            		}else {
                			String line = Integer.toString(k+1);
                			String[] errMessage ={line, vo.getPlnYrwk()+","+ vo.getFmYdCd()};
                			throw new DAOException(new ErrorHandler("EQR10025", errMessage).getMessage());
                		}
	            	}else {  // EXECUTE 입력 
	            		ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_ONF_HIR_EXE_PLN", vo.getCoCd(), vo.getRepoPlnId(), vo.getFmYdCd(), vo.getTrspModCd());
	            		EqrOnfHirExePlnVO eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
	            		ObjectCloner.build(vo , eqrOnfHirExePlnVO );
	            		eqrOnfHirExePlnVO.setRefId(ref_id_new);
	            		eqrOnfHirExePlnVO.setOnfHirDivCd(vo.getTrspModCd());
	            		dbDao.insertOnOffHireExecute(eqrOnfHirExePlnVO, user_id);
	            		
	            		for(int m=0; m<tpszArr.length; m++) {
	            			// type size별 volume 정보
	            			volList = vo.getVolList();
				       		vol    = Integer.parseInt((String)volList.get(m));	
				       		
					    	// type size별 amount 정보
				       		amtList = vo.getCostList();
					       	amt   = Float.parseFloat((String)amtList.get(m));					       		

    				       	// type size별 unit cost, from cost, to cost 정보
					       	unitcostList = vo.getUnitcostList();
    				       	unitcost    = Float.parseFloat((String)unitcostList.get(m));	

    				    	// added by shin yongchan - 20080507		    	
    				    	// CSR No : N200803140002
    				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
    				       	if(unitcost==0) {
    				       		tableCost = dbDao.searchUnitCost("E", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(), tpszArr[m]).getResultStrArray();
    				       		
    				       		unitcost = Float.parseFloat(tableCost[2]);	    				       		
 
    				       	}
    				       	
	            			EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
	            			ObjectCloner.build(vo , eqrOnfHirExePlnQtyVO );
	            			eqrOnfHirExePlnQtyVO.setRefId(ref_id_new);
	            			eqrOnfHirExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
	            			eqrOnfHirExePlnQtyVO.setCntrQty(vol+"");
	            			eqrOnfHirExePlnQtyVO.setOnfHirCostAmt((vol * unitcost)+"");
	            			eqrOnfHirExePlnQtyVO.setPlnUcAmt(unitcost+"");
	            			dbDao.insertOnOffHireExecuteQty(eqrOnfHirExePlnQtyVO, user_id);
	            		}
	            		// EQR_EXE_PLN_CNTR 테이블 입력
                		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
                			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setTrspModCd(vo.getTrspModCd());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
                			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);
                							         		
    					}   
	            	}
				}else if(vo.getIbflag().equals("U")) {
					// -- vol 적용합니다. MERGE  EQR_ONF_HIR_EXE_PLN_QTY ----------------------------------  	                    	 
				    for(int m=0; m<tpszArr.length; m++) {				    	
				    	// type size별 volume 정보
				    	volList = vo.getVolList();
				       	vol    = Integer.parseInt((String)volList.get(m));	

				    	// type size별 amount 정보
				       	amtList = vo.getCostList();
				       	amt   = Float.parseFloat((String)amtList.get(m));	
				       	
				       	// flag 정보 (T, F)
				       	flagList = vo.getFlagList();
				       	flag  = (String)flagList.get(m);	// flag
						
						if(flag.equals("T")) {
							
    				    	// added by shin yongchan - 20080507		    	
    				    	// CSR No : N200803140002
    				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
    				       	if(unitcost==0) {
    				       		tableCost = dbDao.searchUnitCost("E", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(), tpszArr[m]).getResultStrArray();    				       		
    				       		unitcost = Float.parseFloat(tableCost[2]);	    		
    				       	}
    				       	
    				       	EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
    				       	ObjectCloner.build(vo , eqrOnfHirExePlnQtyVO );
    				       	eqrOnfHirExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
    				       	eqrOnfHirExePlnQtyVO.setCntrQty(vol+"");
    				       	eqrOnfHirExePlnQtyVO.setOnfHirCostAmtUpdate(amt+"");
    				       	eqrOnfHirExePlnQtyVO.setPlnUcAmt(unitcost+"");
    				       	
    				       	// added by shin yongchan - 20080507		    	
    				    	// CSR No : N200803140002 
    				       	eqrOnfHirExePlnQtyVO.setOnfHirCostAmtInsert((vol * unitcost)+"");
    				       	
    				       	dbDao.mergeOnOffHireExecuteQty(eqrOnfHirExePlnQtyVO , user_id);
    				       	
						}
						
				    }
				    // EQR_ONF_HIR_EXE_PLN 수정
				    EqrOnfHirExePlnVO eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
            		ObjectCloner.build(vo , eqrOnfHirExePlnVO );
            		eqrOnfHirExePlnVO.setOnfHirDivCd(vo.getTrspModCd());
            		//  so_iss_flg, non_so_iss_flg
       	    		if(soFlag.equals("Y")) {  // so send 버튼 클릭시 작동
        	    		// so_iss_flg
       	    			if(vo.getSoIssFlg().equals("1")){
       	    				eqrOnfHirExePlnVO.setSoIssFlg("Y");  // CHECKED
       	    			}
       	    			
       	    			// non_so_iss_flg
       	    			if(vo.getNosoIssFlg().equals("1")){
       	    				eqrOnfHirExePlnVO.setNonSoIssFlg("Y"); // CHECKED
       	    			}
       	    		}
       	    		
       	    		dbDao.updateOnOffHireExecute(eqrOnfHirExePlnVO,user_id , soFlag);
       	    		
       	    		// EQR_ONF_HIR_EXE_PLN_CNTR 테이블 삭제후 새로 입력
            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setTrspModCd("");
            			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
            			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);
            			
            			eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
            			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
            			eqrExePlnCntrVO.setTrspModCd(vo.getTrspModCd());
            			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
            			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
            			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);            						         		
    				}    
            		// EQR_ONF_HIR_EXE_PLN_CNTR 테이블 삭제후 
            		if(vo.getCntrDel().equals("Y")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setTrspModCd("");
            			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
            			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);		         		
    				}  
				}else if(vo.getIbflag().equals("D")) {  // 삭제로직(PK에서 CNTR_TPSZ_CD 는 제외)
            		// EQR_ONF_HIR_EXE_PLN_CNTR 테이블 삭제
					EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
        			ObjectCloner.build(vo , eqrExePlnCntrVO );
        			eqrExePlnCntrVO.setCntrNo("");
        			eqrExePlnCntrVO.setCntrTpszCd("");
        			eqrExePlnCntrVO.setTrspModCd("");
        			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
        			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
        			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);
					

        			// EQR_ONF_HIR_EXE_PLN_QTY 테이블 삭제
        			EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
			       	ObjectCloner.build(vo , eqrOnfHirExePlnQtyVO );
			       	dbDao.deleteOnOffHireExecuteQty(eqrOnfHirExePlnQtyVO);
			       	
					// EQR_ONF_HIR_EXE_PLN 테이블 삭제
        			EqrOnfHirExePlnVO eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
            		ObjectCloner.build(vo , eqrOnfHirExePlnVO );
        			dbDao.deleteOnOffHireExecute(eqrOnfHirExePlnVO);
        			
				}
				
	    	}
    	} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * 수정 이벤트 처리<br>
     * EES_EQR_081 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
     * @param vos					EesEqr0081MultiVO[]
     * @param account				SignOnUserAccount
     * @exception EventException
     */
    public void soSendOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0081MultiVO[] vos, SignOnUserAccount account) throws EventException {
    	DBRowSet dbRowset = null; 
        try {        	   	
			/*
			 * CSR No : N200807310009
			 * added by shin yongchan - 20080804
			 * Senator S/O Send 방식변경 EAT --> WTC
			 * 삭제함 modity By ChungEunHo 09.09.15
			 */

        	String user_id = account.getUsr_id(); // user id information
        	String tpszType = eesEqr0059ConditionVO.getTpsztype();
			String[] tpszArr= tpszType.split(",");

        	// office code
        	String office_code = null;

            int rowCount = (vos==null) ? 0 : vos.length;
            
            List<String> volList 	 = null;
        	int vol          = 0;    // type size별 vol 수량

            int seq = 1; 		// EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
            int cntrSeq = 0;  	// EQR_EXE_PLN_CNTR에서 검색된 CNTR_NO의 사용을 통제

            // EQR_EXE_PLN_CNTR 테이블에서 검색된 CNTR_TPSZ_CD, CNTR_NO
            String[] cntrTpsz = null;
            String[] cntrNo   = null;
            ArrayList<String> v1 = null;
            ArrayList<String> v2 = null;
            
            // so send check된 row만큼   for loop
        	// type size 종류만큼         for loop
        	// type size별 vol 숫자 만큼  for loop            
            for(int k=0; k<rowCount; k++) {
            	EesEqr0081MultiVO vo = vos[k];
            	if(vo.getSoIssFlg().equals("1")) {    
            		vol     = 0; 
                	volList = new ArrayList<String>();
                	cntrSeq = 0; // EQR_EXE_PLN_CNTR에서 검색된 CNTR_NO의 사용을 통제
	            	seq = 1; 	 // EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
	                v1 = new ArrayList<String>();
	                v2 = new ArrayList<String>();

	            	
	            	office_code = null;
	            	for(int m=0; m<tpszArr.length; m++) {
	            		// type size별 volume 정보
	            		volList = vo.getVolList();
                		vol    = Integer.parseInt((String)volList.get(m));
                		EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                		ObjectCloner.build(vo , eqrExePlnCntrVO );
                		eqrExePlnCntrVO.setCntrTpszCd(tpszArr[m]);
                		dbRowset = dbDao.searchOnOffHireContainer(eqrExePlnCntrVO).getDbRowset();
                		while(dbRowset.next()) {        	   
            	        	v1.add(dbRowset.getString("CNTR_TPSZ_CD"));
            	        	v2.add(dbRowset.getString("CNTR_NO"));
            	        }
                		
                		cntrTpsz = new String[v1.size()];
            	        cntrNo   = new String[v2.size()];
            	        
            	        
            	        for(int v=0; v < v1.size(); v++) {
            	        	cntrTpsz[v] = (String)v1.get(v);
            	            cntrNo[v]   = (String)v2.get(v);
                    	}

//	            		// search office code 
//	            		// type size별로 검색함
//	            		// co_cd = H & type size별 vol>0 만 office code 검색
//	            		// co_cd = S는  office code검색 안함.
	        	        if(vo.getCoCd().equals("H") && vol > 0) {
	        	        	List<CommonVO> target_key_list = new ArrayList<CommonVO>();
        	        		CommonVO joinkey = new CommonVO();
        	        		joinkey.setField1("REPO_PLN_ID");
        	        		joinkey.setField2("REPO_PLN_ID");
        	        		target_key_list.add(joinkey);
        	        		joinkey = new CommonVO();
        	        		joinkey.setField1("PLN_YRWK");
        	        		joinkey.setField2("PLN_YRWK");
        	        		target_key_list.add(joinkey);
        	        		joinkey = new CommonVO();
        	        		joinkey.setField1("PLN_SEQ");
        	        		joinkey.setField2("PLN_SEQ");
        	        		target_key_list.add(joinkey);
        	        		joinkey = new CommonVO();
        	        		joinkey.setField1("REF_ID");
        	        		joinkey.setField2("REF_ID");
        	        		target_key_list.add(joinkey);
        	        		
        	        		office_code = dbDao.searchOfficeCode("EQR_ONF_HIR_EXE_PLN","EQR_ONF_HIR_EXE_PLN_QTY",target_key_list , vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getRefId(),vo.getPlnSeq(), tpszArr[m]).getResultString();
       	        	
	        	        }else {
	        	        	office_code = null;
	        	        }
	        	        
	        	        for(int j=0; j<vol; j++) {    // type size별 vol만큼 insert 합니다. 
	        	        	EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
	        	        	ObjectCloner.build(vo , eqrRepoExeSoIfVO );
	        	        	eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
	        	        	eqrRepoExeSoIfVO.setCntrTpszCd(tpszArr[m]);
	        	        	eqrRepoExeSoIfVO.setSoIfDivCd(vo.getTrspModCd());
	        	        	eqrRepoExeSoIfVO.setTrspModCd("T");
	        	        	eqrRepoExeSoIfVO.setFmDt(vo.getFmLocDt());
	        	        	eqrRepoExeSoIfVO.setToDt(vo.getToLocDt());
	        	        	eqrRepoExeSoIfVO.setWoRqstFlg("Y");
	        	        	eqrRepoExeSoIfVO.setTrspSoStsCd("P");
	        	        	// on hire 제외
            				if(!vo.getTrspModCd().equals("O") && cntrNo.length>0) {
            					if(cntrNo.length > cntrSeq) {
            						eqrRepoExeSoIfVO.setCntrNo(cntrNo[cntrSeq++]);
            					}	
            				}     
            				eqrRepoExeSoIfVO.setWoExeFlg("N");
            				eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
            				eqrRepoExeSoIfVO.setSoRqstDt(vo.getFmLocDt());
            				dbDao.createOnOffHireSoData(eqrRepoExeSoIfVO, user_id);            				
	        	        }                		
	            	}
            	}
            }
        	
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	   

	/**
     * 수정 이벤트 처리<br>
     * EES_EQR_081 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
     * @param vos EesEqr0081MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] vos , SignOnUserAccount account) throws EventException {        
         try {   
        	        	
			/*
			 * CSR No : N200807310009
			 * added by shin yongchan - 20080731
			 * Senator S/O Send, S/O Cancel 방식변경 EAT --> WTC
			 * 삭제함 modity By ChungEunHo 09.09.15
			 */

        	String user_id = account.getUsr_id(); // user id information
        	int rowCount = (vos==null) ? 0 : vos.length; 
			//int i3 	= 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
			
			String exeFlag = "N";
			

			for(int k=0; k<rowCount; k++) {
				EesEqr0081MultiVO vo = vos[k];
            	// SO SEND, NO SOSEND 체크박스 클릭 && SO CANCEL='T' 된것만 삭제 대상에 포함됨.            	
            	if((vo.getSoIssFlg().equals("1") || vo.getNosoIssFlg().equals("1")) && vo.getSoCancelFlag().equals("T")) {    
            	
            		// REF_ID 별로 삭제요건을 만족(Y)하는 경우 3개 테이블 순서대로 삭제
            		exeFlag = dbDao.soCancelCheckCntrRepoPlan(vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getPlnSeq() , vo.getRefId()).getResultString();
            		if(exeFlag.equals("Y")) {   
            			EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
            			ObjectCloner.build(vo , eqrRepoExeSoIfVO );
            			dbDao.deleteOnOffHireSoData(eqrRepoExeSoIfVO);
            			
            			EqrOnfHirExePlnVO  eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
            			ObjectCloner.build(vo , eqrOnfHirExePlnVO );
            			dbDao.updateInitOnOffHireExecute(eqrOnfHirExePlnVO, user_id);
            		}else{
            			throw new DAOException(new ErrorHandler("EQR10027").getMessage());
            		}
            	}
			}
        
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	    
    /**
	 * WRSTRS_SOIF 를 통해서 INLAND 데이터를 입력
	 * EQR_INLND_TRSP_PLN, EQR_INLND_TRSP_EXE_PLN, EQR_REPO_EXE_SO_IF 테이블에 데이터 입력
	 * 
	 * @param current_date	String
	 * @param fm_yd_cd		String
	 * @param to_yd_cd		String
	 * @param trsp_mod_cd	String
	 * @param cntr_tpsz_cd	String
	 * @param qty			int
	 * @return ArrayList
     * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList inlandWrsTrsSOIF(String current_date, String fm_yd_cd, String to_yd_cd, String trsp_mod_cd, String cntr_tpsz_cd, int qty) throws EventException {
        //boolean check 		= false;
        String repo_pln_id 	= "";
        String pln_yrwk		= "";
        String fm_week      = "";
        String to_week      = "";
        String etd_date     = "";
        String eta_date     = "";
        String ref_id 		= "";
        String fm_ecc 		= "";
        String to_ecc 		= "";
        String fm_rcc       = ""; // so if 테이블 입력시에 사용됨 
        String tpszInitial  = "";
        String[] max_repo_pln_id = null;
        
        ArrayList soifList = new ArrayList();
        String[] soifArr  = null;
        
        boolean dblink_result = false;
        // added by shin yongchan - 20080513		    	
    	// CSR No : N200803140002
    	float unitcost = 0;
    	float fromcost = 0;
    	float tocost   = 0;    	
    	String[] tableCost = null;
        
        String exe_dup_refid  = "";  // execute 에 중복되는 지역 정보의 ref id
        String exe_dup_plnseq = "";  // execute 에 중복되는 지역 정보의 pln_seq
        int    max_ref_seq    = 1;   // exe_dup_refid의 req seq 최대값 
        String plnSeq = "0";
        DBRowSet rowSet = null;
        
		try {			
			CommonDBDAO commondbDao = new CommonDBDAO();
			
			// repo pln id
			max_repo_pln_id = commondbDao.searchMaxRepoPlanId().getResultStrArray();
			repo_pln_id 	= "REPO"+max_repo_pln_id[0]+"W"+max_repo_pln_id[1];
			pln_yrwk       	= commondbDao.convertDayWeekly(current_date).getResultString();
			fm_week         = pln_yrwk;
			
			etd_date        = current_date;
			
//			log.debug("\n------------------ BEFORE ");
			eta_date        = commondbDao.searchEtaDate(etd_date, fm_yd_cd, to_yd_cd, trsp_mod_cd).getResultString();
//			log.debug("\n------------------ eta_date : " + eta_date);
			if(eta_date.equals("")) eta_date = etd_date;
			
			to_week         = commondbDao.convertDayWeekly(eta_date).getResultString();
						
			fm_ecc          = commondbDao.convertYardToECC(fm_yd_cd, "ECC_CD").getResultString();
			to_ecc          = commondbDao.convertYardToECC(to_yd_cd, "ECC_CD").getResultString();
			fm_rcc          = commondbDao.convertYardToECC(fm_yd_cd, "RCC_CD").getResultString();
			
//			log.debug("\n------------------ current_date: " + current_date);
//			log.debug("\n------------------ etd_date    : " + etd_date);
//			log.debug("\n------------------ eta_date    : " + eta_date);
//			log.debug("\n------------------ fm_yd_cd 	: " + fm_yd_cd);
//			log.debug("\n------------------ to_yd_cd 	: " + to_yd_cd);
//			log.debug("\n------------------ trsp_mod_cd : " + trsp_mod_cd);
//			log.debug("\n------------------ cntr_tpsz_cd: " + cntr_tpsz_cd);
//			log.debug("\n------------------ qty 		: " + qty);			
//			
//			log.debug("\n------------------ repo_pln_id : " + repo_pln_id);
//			log.debug("\n------------------ pln_yrwk    : " + pln_yrwk);
//			log.debug("\n------------------ fm_week     : " + fm_week);
//			log.debug("\n------------------ to_week     : " + to_week);
//			log.debug("\n------------------ ref_id      : " + ref_id);
//			log.debug("\n------------------ fm_ecc      : " + fm_ecc);
//			log.debug("\n------------------ to_ecc      : " + to_ecc);
//			log.debug("\n------------------ fm_rcc      : " + fm_rcc);
			
			// plan
			tpszInitial = commondbDao.getTpszInitial().getResultString();
			
			// CSR NO : R200903270008 
			// insertInlandWrsTrsSOIFPlan 메소드 내부에서 사용하지 않는 파라미터 삭제(cntr_tpsz_cd)로 인한 메소드 호출방식 변경
			dblink_result = true;
			String[] tpszArrInitial= tpszInitial.split(","); // tpsz size 10개 정보
			EqrInlndTrspPlnVO  checkEqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
    		checkEqrInlndTrspPlnVO.setRepoPlnId(repo_pln_id);
    		checkEqrInlndTrspPlnVO.setPlnYrwk(pln_yrwk);
    		checkEqrInlndTrspPlnVO.setTrspModCd(trsp_mod_cd);
    		checkEqrInlndTrspPlnVO.setFmEccCd(fm_ecc);
    		checkEqrInlndTrspPlnVO.setFmYrwk(fm_week);
    		checkEqrInlndTrspPlnVO.setToEccCd(to_ecc);
    		checkEqrInlndTrspPlnVO.setToYrwk(to_week);    
            if(dbDao.inlandInsertCheck_link(fm_ecc, to_ecc, trsp_mod_cd)) { // PLAN INSERT 대상이 LINK 정보를 가지고 있는지 확인. 
//            	String[] errMessage ={" ("+fm_ecc+"-"+to_ecc+")"};
//                log.debug(errMessage);
                dblink_result = false;
                //throw new DAOException(new ErrorHandler("EQR10033", errMessage).getMessage());
                			
            }
            boolean plnDUPCheck = dbDao.inlandInsertCheck(checkEqrInlndTrspPlnVO);
            if(!plnDUPCheck){// 중복이 없어야 입력	
            	plnSeq = commondbDao.getNextPlnSeq("EQR_INLND_TRSP_PLN", repo_pln_id, pln_yrwk).getResultString(); // pln_seq 생성
            	EqrInlndTrspPlnVO eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
	       		eqrInlndTrspPlnVO.setRepoPlnId(repo_pln_id);
	       		eqrInlndTrspPlnVO.setPlnYrwk(pln_yrwk);
	       		eqrInlndTrspPlnVO.setPlnSeq(plnSeq);
	       		eqrInlndTrspPlnVO.setTrspModCd(trsp_mod_cd);
	       		eqrInlndTrspPlnVO.setFmEccCd(fm_ecc);
	       		eqrInlndTrspPlnVO.setFmYrwk(pln_yrwk);
	       		eqrInlndTrspPlnVO.setToEccCd(to_ecc);
	       		eqrInlndTrspPlnVO.setToYrwk(to_week);
	       		eqrInlndTrspPlnVO.setPastRepoPlnFlg("N");
	       		eqrInlndTrspPlnVO.setXterRqstPlnOwnrCd("T"); // TRS에서 입력되었다는 의미
	       		dbDao.insertInlandWrsTrsSOIFPlan(eqrInlndTrspPlnVO,"TRS_SOIF");
                for(int m=0; m<tpszArrInitial.length; m++) { // PLAN은 10개 TPSZ  사용

                	// added by shin yongchan - 20080513		    	
                	// CSR No : N200803140002
		       		tableCost = dbDao.searchUnitCost("P", fm_ecc, to_ecc, trsp_mod_cd, tpszArrInitial[m]).getResultStrArray();

		       		fromcost = Float.parseFloat(tableCost[0]);
		       		tocost   = Float.parseFloat(tableCost[1]);
		       		unitcost = Float.parseFloat(tableCost[2]);	    				       		
		       		
		       		EqrInlndTrspPlnQtyVO eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
		       		eqrInlndTrspPlnQtyVO.setRepoPlnId(repo_pln_id);
		       		eqrInlndTrspPlnQtyVO.setPlnYrwk(pln_yrwk);
		       		eqrInlndTrspPlnQtyVO.setPlnSeq(plnSeq);
		       		eqrInlndTrspPlnQtyVO.setCntrTpszCd(tpszArrInitial[m]);
		       		eqrInlndTrspPlnQtyVO.setCntrQty("0");
		       		eqrInlndTrspPlnQtyVO.setPlnUcAmt(unitcost+"");
		       		eqrInlndTrspPlnQtyVO.setFmEccCostAmt(fromcost+"");
		       		eqrInlndTrspPlnQtyVO.setToEccCostAmt(tocost+"");
		       		dbDao.insertInlandWrsTrsSOIFPlanQty(eqrInlndTrspPlnQtyVO,"TRS_SOIF");
                } 
            }else{
            	plnSeq = dbDao.searchPlnSeqinlandInsertCheck(checkEqrInlndTrspPlnVO);
            }
//			log.debug("\n------------------- dblink_result : " +dblink_result);
			
			if(dblink_result) {
				
				// CSR NO : N200811110007  modified by shin yongchan
				// TRS에서 1개씩 S/O 입력되는 것중에 동일 ROUTE로 이동하는 것은 N개로 집합 
				// execute
				// 중복이 존재하는지 검색
				// 존재하면 ref id 를 얻어옴 
				EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO  = new EqrInlndTrspExePlnVO();
				eqrInlndTrspExePlnVO.setRepoPlnId(repo_pln_id);
				eqrInlndTrspExePlnVO.setPlnYrwk(pln_yrwk);
				eqrInlndTrspExePlnVO.setTrspModCd(trsp_mod_cd);
				eqrInlndTrspExePlnVO.setFmYdCd(fm_yd_cd);
				eqrInlndTrspExePlnVO.setToYdCd(to_yd_cd);
				eqrInlndTrspExePlnVO.setFmEtdDt(etd_date);
				eqrInlndTrspExePlnVO.setToEtaDt(eta_date);
				String[] exeDupArr = dbDao.checkInlandWrsTrsSOIFDuplicate(eqrInlndTrspExePlnVO).getResultStrArray();
				exe_dup_refid = exeDupArr[0];
				exe_dup_plnseq = exeDupArr[1];
//				log.debug("\n ---- exe_dup_refid --------------- : " +exe_dup_refid);
//				log.debug("\n ---- exe_dup_plnseq --------------- : " +exe_dup_plnseq);
				// 중복존재 --> EQR_INLND_TRSP_EXE_PLN 해당 REF ID, TYPE SIZE 의 QTY +1
				//         --> EQR_REPO_EXE_SO_IF     해당 REF ID 의 REF_SEQ + 1
				if(!exe_dup_refid.equals("")) {
//					log.debug("\n ---- DUP --------------- ");

					// ref seq 검색
					max_ref_seq = dbDao.searchInlandWrsTrsSOIFRefSeq(exe_dup_refid);
					
					// execute 수정 혹은 입력(REF ID 지정, CNTR TYPE 중복 --> 수정, CNTR TYPE 중복안됨 --> 입력)
					
					//dbDao.modifyInlandWrsTrsSOIFExecuteQty(repo_pln_id, pln_yrwk, exe_dup_refid, cntr_tpsz_cd, trsp_mod_cd, fm_yd_cd, to_yd_cd, etd_date, eta_date, qty);
					tableCost = dbDao.searchUnitCost("E", fm_yd_cd, to_yd_cd, trsp_mod_cd, cntr_tpsz_cd).getResultStrArray();
		       		
			       	fromcost = Float.parseFloat(tableCost[0]);
			       	tocost   = Float.parseFloat(tableCost[1]);
			       	unitcost = Float.parseFloat(tableCost[2]);	  
			       	
			       	EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
			       	eqrInlndTrspExePlnQtyVO.setRepoPlnId(repo_pln_id);
			       	eqrInlndTrspExePlnQtyVO.setPlnYrwk(pln_yrwk);
			       	eqrInlndTrspExePlnQtyVO.setRefId(exe_dup_refid);
			       	eqrInlndTrspExePlnQtyVO.setPlnSeq(exe_dup_plnseq);
			       	eqrInlndTrspExePlnQtyVO.setCntrTpszCd(cntr_tpsz_cd);
			       	eqrInlndTrspExePlnQtyVO.setCntrQty(qty+"");
			       	eqrInlndTrspExePlnQtyVO.setTrspCostAmt((qty * unitcost)+"");
			       	eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
			       	eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
			       	eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
			       	dbDao.mergeInlandWrsTrsSOIFExecuteQty(eqrInlndTrspExePlnQtyVO , "TRS_SOIF");
					
					// so if 입력(ref id 지정, ref seq = 해당 REF ID의 max ref seq + 1)
			       	String office_code = null;
					//dbDao.insertInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, exe_dup_refid, cntr_tpsz_cd, trsp_mod_cd, fm_yd_cd, to_yd_cd, fm_rcc, etd_date, eta_date, qty, max_ref_seq + 1);
			       	if(trsp_mod_cd.equals("R") && fm_rcc.equals("USNYC") && !"MX".equals(fm_ecc.substring(0, 2))) { // USNYC, RAIL은 PHXSC로 하드코딩 - 멕시코는 제외
		        		office_code = "PHXSC";
		        	}else {
		        		List<CommonVO> target_key_list = new ArrayList<CommonVO>();
    	        		CommonVO joinkey = new CommonVO();
    	        		joinkey.setField1("REPO_PLN_ID");
    	        		joinkey.setField2("REPO_PLN_ID");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_YRWK");
    	        		joinkey.setField2("PLN_YRWK");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_SEQ");
    	        		joinkey.setField2("PLN_SEQ");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("REF_ID");
    	        		joinkey.setField2("REF_ID");
    	        		target_key_list.add(joinkey);
		        		office_code = dbDao.searchOfficeCode("EQR_INLND_TRSP_EXE_PLN", "EQR_INLND_TRSP_EXE_PLN_QTY", target_key_list, repo_pln_id, pln_yrwk, exe_dup_refid,exe_dup_plnseq, cntr_tpsz_cd).getResultString();
		        	}    
		       		int seq = max_ref_seq + 1; 				// EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
			       	for(int j=0; j<qty; j++) {    // qty만큼 insert 합니다.  
			       		EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
				       	eqrRepoExeSoIfVO.setRepoPlnId(repo_pln_id);
				       	eqrRepoExeSoIfVO.setPlnYrwk(pln_yrwk);
				       	eqrRepoExeSoIfVO.setRefId(exe_dup_refid);
				       	eqrRepoExeSoIfVO.setPlnSeq(exe_dup_plnseq);
				       	eqrRepoExeSoIfVO.setCntrTpszCd(cntr_tpsz_cd);
				       	eqrRepoExeSoIfVO.setTrspModCd(trsp_mod_cd);
				       	eqrRepoExeSoIfVO.setSoIfDivCd(trsp_mod_cd);
				       	eqrRepoExeSoIfVO.setFmYdCd(fm_yd_cd);
				       	eqrRepoExeSoIfVO.setToYdCd(to_yd_cd);
				       	eqrRepoExeSoIfVO.setFmDt(etd_date);
				       	eqrRepoExeSoIfVO.setToDt(eta_date);
				       	eqrRepoExeSoIfVO.setWoExeFlg("N");
				       	eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
			       		eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
			       		dbDao.insertInlandWrsTrsSOIF(eqrRepoExeSoIfVO,"TRS_SOIF");
			       	}
			       	
					// soif pk search
					rowSet = dbDao.searchInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, exe_dup_plnseq ,exe_dup_refid);
				
				}else { // 중복존재 하지 않음.
//					log.debug("\n ---- NOT DUP --------------- " );
					
					// 신규 ref id 생성
					ref_id = dbDao.makeRefIDCntrRepoPlan("EQR_INLND_TRSP_EXE_PLN", "H", repo_pln_id, fm_yd_cd, trsp_mod_cd);
					
					// added by shin yongchan - 20080430		    	
			    	// CSR No : N200803140002
			       	// unit cost table에서 unit cost, from cost, to cost를 검색함. 
			       	tableCost = dbDao.searchUnitCost("E", fm_yd_cd, to_yd_cd, trsp_mod_cd, cntr_tpsz_cd).getResultStrArray();
			       		
			       	fromcost = Float.parseFloat(tableCost[0]);
			       	tocost   = Float.parseFloat(tableCost[1]);
			       	unitcost = Float.parseFloat(tableCost[2]);	  
					
					// 신규 execute 생성
			       	eqrInlndTrspExePlnVO  = new EqrInlndTrspExePlnVO();
					eqrInlndTrspExePlnVO.setRepoPlnId(repo_pln_id);
					eqrInlndTrspExePlnVO.setPlnYrwk(pln_yrwk);
					eqrInlndTrspExePlnVO.setPlnSeq(plnSeq);
					eqrInlndTrspExePlnVO.setRefId(ref_id);
					eqrInlndTrspExePlnVO.setTrspModCd(trsp_mod_cd);
					eqrInlndTrspExePlnVO.setFmYdCd(fm_yd_cd);
					eqrInlndTrspExePlnVO.setToYdCd(to_yd_cd);
					eqrInlndTrspExePlnVO.setFmEtdDt(etd_date);
					eqrInlndTrspExePlnVO.setToEtaDt(eta_date);
					eqrInlndTrspExePlnVO.setCoCd("H");
					eqrInlndTrspExePlnVO.setExeIssFlg("Y");
					eqrInlndTrspExePlnVO.setXterRqstPlnOwnrCd("T"); // TRS에서 입력되었다는 의미
					dbDao.insertInlandWrsTrsSOIFExecute(eqrInlndTrspExePlnVO , "TRS_SOIF");
					EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
			       	eqrInlndTrspExePlnQtyVO.setRepoPlnId(repo_pln_id);
			       	eqrInlndTrspExePlnQtyVO.setPlnYrwk(pln_yrwk);
			       	eqrInlndTrspExePlnQtyVO.setRefId(ref_id);
			       	eqrInlndTrspExePlnQtyVO.setPlnSeq(plnSeq);
			       	eqrInlndTrspExePlnQtyVO.setCntrTpszCd(cntr_tpsz_cd);
			       	eqrInlndTrspExePlnQtyVO.setCntrQty(qty+"");
			       	eqrInlndTrspExePlnQtyVO.setTrspCostAmt((qty * unitcost)+"");
			       	eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
			       	eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
			       	eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
			       	dbDao.insertInlandWrsTrsSOIFExecuteQty(eqrInlndTrspExePlnQtyVO , "TRS_SOIF");
					
					// 신규 so if 입력
			       	String office_code = null;
					//dbDao.insertInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, exe_dup_refid, cntr_tpsz_cd, trsp_mod_cd, fm_yd_cd, to_yd_cd, fm_rcc, etd_date, eta_date, qty, max_ref_seq + 1);
			       	if(trsp_mod_cd.equals("R") && fm_rcc.equals("USNYC") && !"MX".equals(fm_ecc.substring(0, 2))) { // USNYC, RAIL은 PHXSC로 하드코딩 - 멕시코는 제외
		        		office_code = "PHXSC";
		        	}else {
		        		List<CommonVO> target_key_list = new ArrayList<CommonVO>();
    	        		CommonVO joinkey = new CommonVO();
    	        		joinkey.setField1("REPO_PLN_ID");
    	        		joinkey.setField2("REPO_PLN_ID");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_YRWK");
    	        		joinkey.setField2("PLN_YRWK");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_SEQ");
    	        		joinkey.setField2("PLN_SEQ");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("REF_ID");
    	        		joinkey.setField2("REF_ID");
    	        		target_key_list.add(joinkey);
		        		office_code = dbDao.searchOfficeCode("EQR_INLND_TRSP_EXE_PLN", "EQR_INLND_TRSP_EXE_PLN_QTY", target_key_list, repo_pln_id, pln_yrwk, ref_id ,plnSeq, cntr_tpsz_cd).getResultString();
		        	}    
		       		int seq = 1; 				// EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
			       	for(int j=0; j<qty; j++) {    // qty만큼 insert 합니다.  
			       		EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
				       	eqrRepoExeSoIfVO.setRepoPlnId(repo_pln_id);
				       	eqrRepoExeSoIfVO.setPlnYrwk(pln_yrwk);
				       	eqrRepoExeSoIfVO.setRefId(ref_id);
				       	eqrRepoExeSoIfVO.setPlnSeq(plnSeq);
				       	eqrRepoExeSoIfVO.setCntrTpszCd(cntr_tpsz_cd);
				       	eqrRepoExeSoIfVO.setTrspModCd(trsp_mod_cd);
				       	eqrRepoExeSoIfVO.setSoIfDivCd(trsp_mod_cd);
				       	eqrRepoExeSoIfVO.setFmYdCd(fm_yd_cd);
				       	eqrRepoExeSoIfVO.setToYdCd(to_yd_cd);
				       	eqrRepoExeSoIfVO.setFmDt(etd_date);
				       	eqrRepoExeSoIfVO.setToDt(eta_date);
				       	eqrRepoExeSoIfVO.setWoExeFlg("N");
				       	eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
			       		eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
			       		dbDao.insertInlandWrsTrsSOIF(eqrRepoExeSoIfVO,"TRS_SOIF");
			       	}			

					// soif pk search
					rowSet = dbDao.searchInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, plnSeq , ref_id );
						
				}
				
				int i =1;
				if (rowSet != null) {

					while (rowSet.next()) {
						soifArr = new String[4];
						for(int j=0; j<rowSet.getMetaData().getColumnCount(); j++) {
							soifArr[j] = rowSet.getString(i++);
						}
						
						i = 1;
						
						soifList.add(soifArr);
					}
				}
				
//				String[] arr = null;
//				log.debug("\n------------------- soifList.size() : " + soifList.size());
//				for(int z=0; z<soifList.size(); z++) {
//					arr = (String[])soifList.get(z);
//					log.debug("\n------------------- arr["+z+"].length() : " + arr.length);
//					for(int zz=0; zz<arr.length; zz++) {
//						log.debug("\n------------------- arr["+zz+"] : " + arr[zz]);
//					}
//				}
				
			}else {
				soifList = null; // db link 부적격 상태를 의미함. 
			}
			
			return soifList;

		} catch (SQLException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}		
	}
	/**
	 * EES_EQR_0131 eMail  Send.<br>
	 * 
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendEmail(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try{
			String  eml_content = " \n" + 		
			 "To   : Person In Charge of Empty Repositioning \n" +
			 "From : " + account.getUsr_nm() + "\n\n\n" + 
			 "We would like to arrange Empty Containers as attachment.  \n"+
			 "Please arrange them by Lane/VVD from loading port to discharging one in time.  \n\n"+				  
			 "Thank you for your cooperation in advance.  \n\n"+				 
			 "B.RGDS  \n";
			String	eml_subject = "Empty Repositioning Plan for Week " + conditionVO.getWeek();
			
			conditionVO.setEmlContent(eml_content);
			conditionVO.setEmlSubject(eml_subject);
			
			CntrRepoExecutionPlanEstablishEAIDAO eaiDao = new CntrRepoExecutionPlanEstablishEAIDAO();
			eaiDao.sendEmail(conditionVO, account);
		}catch(MailerAppException me){
			log.error("err "+me.toString(),me);
			throw new EventException(me.getMessage());
		}catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * EES_EQR_0131 Fax  Send.<br>
	 * 
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendFax(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try{
			String fax_subject = "Empty Repositioning Plan for Week " + conditionVO.getWeek();
			conditionVO.setFaxSubject(fax_subject);
			
			CntrRepoExecutionPlanEstablishEAIDAO eaiDao = new CntrRepoExecutionPlanEstablishEAIDAO();
			eaiDao.sendFax(conditionVO, account);
			
		}catch(FaxSendException fe){
			log.error("err "+fe.toString(),fe);
			throw new EventException(fe.getMessage());
		}catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	/**
	 * EES_EQR_0132 search Send History email / FAX <br>
	 * 
	 * @param target String 
	 * @param job_cd String
	 * @param user_id String
	 * @return List<SearchSendHistoryVO>
	 * @exception EventException
	 */
	public List<SearchSendHistoryVO> searchSenderHistory( String target , String job_cd , String user_id)throws EventException {
		List<SearchSendHistoryVO> list = null;
		try {
			if(target.equals("F")){
				list = dbDao.searchFAXSenderHistory(job_cd, user_id);
			}else{
				list = dbDao.searchMAILSenderHistory(job_cd, user_id);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_083Event 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException {
		try{
			return dbDao.searchShuttleCntrRepoPlan(eesEqr0059ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_083 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param eesEqr0059ConditionVO
	 * @param vos EesEqr0083MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException {
		// so send 버튼 클릭시 'Y값 리턴
		// so flag 'Y'일때만 so_iss_flg 를 수정합니다. 			
		String soFlag = eesEqr0059ConditionVO.getSoFlag(); 
		String user_id = account.getUsr_id();
		try{
			String tpszType = eesEqr0059ConditionVO.getTpsztype();
			String[] tpszArr= tpszType.split(",");
			
			String ref_id_new = "";	 // ref_id 변수
									
			int rowCount = (vos==null) ? 0 : vos.length;                            
            
            List<String> volList 	 = null;
        	int vol          = 0;    // type size별 vol 수량
        	
        	List<String> flagList	 = null;
        	String flag      = "";

	    	// added by shin yongchan - 20080506		    	
	    	// CSR No : N200803140002
        	String[] tableCost = null;
        	float unitcost = 0;
        	        	
            for(int k=0; k<rowCount; k++) {
            	EesEqr0083MultiVO vo = vos[k];
            	vol     = 0; 
            	volList = new ArrayList<String>();
            	
            	flagList = new ArrayList<String>(); 
            	flag     = "";
            	
            	tableCost = null;
            	            					       	          	    	           	    		
                if(vo.getIbflag().equals("I")) {
                	ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_ECC_INTER_EXE_PLN", vo.getCoCd(), vo.getRepoPlnId(),vo.getFmYdCd(), "S");
                	EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
                	ObjectCloner.build(vo , eqrEccInterExePlnVO );
                	eqrEccInterExePlnVO.setRefId(ref_id_new);
                	dbDao.insertShuttleCntrRepoPlan(eqrEccInterExePlnVO, user_id);
                	
                	for(int m=0; m<tpszArr.length; m++) {
                		// type size별 volume 정보				    
				    	volList = vo.getVolList();                    
				       	vol    	= Integer.parseInt((String)volList.get(m));	
				       	
				    	// added by shin yongchan - 20080506		    	
				    	// CSR No : N200803140002
				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
				       	tableCost = dbDao.searchUnitCost("I", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(),  tpszArr[m]).getResultStrArray();				       		
				       	unitcost = Float.parseFloat(tableCost[2]);	
				       	
                		EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
                    	ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
                    	eqrEccInterExePlnQtyVO.setRefId(ref_id_new);
                    	eqrEccInterExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
                    	// added by shin yongchan - 20080506		    	
				    	// CSR No : N200803140002	    
                    	eqrEccInterExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
                    	eqrEccInterExePlnQtyVO.setCntrQty(vol+"");
                    	dbDao.insertShuttleCntrRepoPlanQty(eqrEccInterExePlnQtyVO, user_id); // exe_rqst_dt 최초 입력시 null 로 입력 09.09.24 modify by ChungEunHo
                    	
                	}
                	// EQR_EXE_PLN_CNTR 테이블 입력
            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setPlnSeq("0"); // EQR_ECC_INTER_EXE_PLN  PLN_SEQ 부재로 인한 기본값 셋팅 
            			eqrExePlnCntrVO.setRefId(ref_id_new);
            			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
            			eqrExePlnCntrVO.setTrspModCd(vo.getTrspModCd());
            			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);
            		}
                }else if(vo.getIbflag().equals("U")) {
                	// -- vol 적용합니다. ----------------------------------  	                    	 
				    for(int m=0; m<tpszArr.length; m++) {	
				    	// type size별 volume 정보
				    	
				    	volList = vo.getVolList();						// 현재 row에 해당하는 것만 List에 담기
				       	vol     = Integer.parseInt((String)volList.get(m));	
            	    	
				       	// flag 정보 (T, F)
				       	flagList = vo.getFlagList();         			// 현재 row에 해당하는 것만 List에 담기
				       	flag     = (String)flagList.get(m);				// flag
				       	if(flag.equals("T")) {
				       	// added by shin yongchan - 20080506		    	
    				    	// CSR No : N200803140002
    				       	// unit cost가 존재하지 않는 경우 table에서 unit cost, from cost, to cost를 검색함. 
    				       	tableCost = dbDao.searchUnitCost("I", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(), tpszArr[m]).getResultStrArray();

    				       	unitcost = Float.parseFloat(tableCost[2]);	 
    				       	EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
                        	ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
                        	eqrEccInterExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
                        	// added by shin yongchan - 20080506		    	
    				    	// CSR No : N200803140002	       
                        	eqrEccInterExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
                        	eqrEccInterExePlnQtyVO.setCntrQty(vol+"");
                        	
                        	dbDao.mergeShuttleCntrRepoPlan(eqrEccInterExePlnQtyVO , user_id , soFlag);
				       	}
				    }
				    // -- vol 제외한 나머지 수정값을 적용합니다. ----------------------
				    EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
                	ObjectCloner.build(vo , eqrEccInterExePlnVO );
                	//  so_iss_flg
       	    		if(soFlag.equals("Y")) {  // so send 버튼 클릭시 작동
       	    			if(vo.getSoIssFlg().equals("1")){
       	    				eqrEccInterExePlnVO.setExeIssFlg("Y"); // CHECKED
       	    			}
       	    		}
       	    		dbDao.updateShuttleCntrRepoPlan(eqrEccInterExePlnVO, user_id, soFlag);
       	    		// EQR_EXE_PLN_CNTR 테이블 삭제후 새로 입력
            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setPlnSeq("0"); // EQR_ECC_INTER_EXE_PLN  PLN_SEQ 부재로 인한 기본값 셋팅 
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setTrspModCd("");
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);	
            			
            			eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setPlnSeq("0"); // EQR_ECC_INTER_EXE_PLN  PLN_SEQ 부재로 인한 기본값 셋팅 
            			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
            			eqrExePlnCntrVO.setTrspModCd(vo.getTrspModCd());
            			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);		         		
    				}    
            		// EQR_EXE_PLN_CNTR 테이블 삭제
            		if(vo.getCntrDel().equals("Y")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setPlnSeq("0"); // EQR_ECC_INTER_EXE_PLN  PLN_SEQ 부재로 인한 기본값 셋팅 
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setTrspModCd("");
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);			         		
    				}    
                	
				    
                }else if(vo.getIbflag().equals("D")) {  // 삭제로직(PK에서 CNTR_TPSZ_CD 는 제외)
                	// EQR_EXE_PLN_CNTR 테이블 삭제
                	EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
        			ObjectCloner.build(vo , eqrExePlnCntrVO );
        			eqrExePlnCntrVO.setPlnSeq("0"); // EQR_ECC_INTER_EXE_PLN  PLN_SEQ 부재로 인한 기본값 셋팅 
        			eqrExePlnCntrVO.setCntrTpszCd("");
        			eqrExePlnCntrVO.setTrspModCd("");
        			eqrExePlnCntrVO.setCntrNo("");
        			eqrExePlnCntrVO.setFmEccCd("XXXXX");
        			eqrExePlnCntrVO.setToEccCd("XXXXX");
        			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);	
                	// EQR_ECC_INTER_EXE_PLN_QTY 테이블 삭제
                	EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
                	ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
                	dbDao.deleteShuttleCntrRepoPlanQty(eqrEccInterExePlnQtyVO);
        			// EQR_ECC_INTER_EXE_PLN 테이블 삭제
        			EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
                	ObjectCloner.build(vo , eqrEccInterExePlnVO );
                	dbDao.deleteShuttleCntrRepoPlan(eqrEccInterExePlnVO);
        			
                }
            }
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * 수정 이벤트 처리<br>
     * EES_EQR_083 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO
     * @param vos EesEqr0083MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public void soSendShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException {
                
        String user_id = account.getUsr_id();
        try {        	         
        	String tpszType = eesEqr0059ConditionVO.getTpsztype();
			String[] tpszArr= tpszType.split(",");

        	// office code
        	String office_code = null;

	        int rowCount = (vos==null) ? 0 : vos.length;
	        
	        List volList 	 = null;
	    	int vol          = 0;    // type size별 vol 수량
	
	        //int k 	= 1; 	// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
	        int seq = 1; 		// EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
	        int cntrSeq = 0;  	// EQR_EXE_PLN_CNTR에서 검색된 CNTR_NO의 사용을 통제
	
	        // EQR_EXE_PLN_CNTR 테이블에서 검색된 CNTR_TPSZ_CD, CNTR_NO
	        String[] cntrTpsz = null;
	        String[] cntrNo   = null;
	        //Vector v1 = new Vector();
	        //Vector v2 = new Vector();
	
//	        ArrayList v1 = new ArrayList();
//	        ArrayList v2 = new ArrayList();
            ArrayList v1 = null;
            ArrayList v2 = null;
	        
	    	// so send check된 row만큼   for loop
	    	// type size 종류만큼         for loop
	    	// type size별 vol 숫자 만큼  for loop            
	        for(int k=0; k<rowCount; k++) {
	        	EesEqr0083MultiVO vo = vos[k];
	            if(vo.getSoIssFlg().equals("1")) {                  	
	    	        
	    	        // ------------ EQR_REPO_EXE_SO_IF INSERT LOGIC ---------------------
	            	vol     = 0; 
	            	volList = new ArrayList();
	            	cntrSeq = 0; // EQR_EXE_PLN_CNTR에서 검색된 CNTR_NO의 사용을 통제
	            	seq = 1; 	 // EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
	            	v1 = new ArrayList();
	            	v2 = new ArrayList();
	            	office_code = null;
	            	
	            	for(int m=0; m<tpszArr.length; m++) {
				    	
	            		// type size별 volume 정보
	            		volList = vo.getVolList();					// 현재 row에 해당하는 것만 List에 담기
	            		vol    = Integer.parseInt((String)volList.get(m));	
	            		EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
	            		ObjectCloner.build(vo , eqrExePlnCntrVO );
	            		eqrExePlnCntrVO.setCntrTpszCd(tpszArr[m]);
	            		eqrExePlnCntrVO.setPlnSeq("0"); // 기본값 설정
	            		DBRowSet dbRowset = dbDao.searchEccInternalContainer(eqrExePlnCntrVO).getDbRowset();
	            		while(dbRowset.next()) {        	   
	        	        	v1.add(dbRowset.getString("CNTR_TPSZ_CD"));
	        	        	v2.add(dbRowset.getString("CNTR_NO"));
	        	        }
	            		cntrTpsz = new String[v1.size()];
	        	        cntrNo   = new String[v2.size()];
	        	        
	        	        for(int v=0; v < v1.size(); v++) {
	        	        	//cntrTpsz[v] = (String)v1.elementAt(v);
	        	            //cntrNo[v]   = (String)v2.elementAt(v);
	        	        	cntrTpsz[v] = (String)v1.get(v);
	        	            cntrNo[v]   = (String)v2.get(v);
	                	}
	
	        	        List<CommonVO> target_key_list = new ArrayList<CommonVO>();
    	        		CommonVO joinkey = new CommonVO();
    	        		joinkey.setField1("REPO_PLN_ID");
    	        		joinkey.setField2("REPO_PLN_ID");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_YRWK");
    	        		joinkey.setField2("PLN_YRWK");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("REF_ID");
    	        		joinkey.setField2("REF_ID");
    	        		target_key_list.add(joinkey);
    	        		
	        	        office_code = dbDao.searchOfficeCode("EQR_ECC_INTER_EXE_PLN","EQR_ECC_INTER_EXE_PLN_QTY",target_key_list, vo.getRepoPlnId(), vo.getPlnYrwk() ,vo.getRefId(),"0", tpszArr[m]).getResultString();
	        	        
	        	        for(int j=0; j<vol; j++) {    // type size별 vol만큼 insert 합니다.  
	        	        	EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
	        	        	ObjectCloner.build(vo , eqrRepoExeSoIfVO );
	        	        	eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
	        	        	eqrRepoExeSoIfVO.setCntrTpszCd(tpszArr[m]);
	        	        	eqrRepoExeSoIfVO.setSoIfDivCd("S");
	        	        	eqrRepoExeSoIfVO.setFmDt(vo.getFmEtdDt());
	        	        	eqrRepoExeSoIfVO.setToDt(vo.getToEtaDt());
	        	        	eqrRepoExeSoIfVO.setTrspSoStsCd("P");
	        	        	eqrRepoExeSoIfVO.setWoRqstFlg("Y");
	        	        	if(cntrNo.length > 0) {
	        					if(cntrNo.length > cntrSeq) {
	        						eqrRepoExeSoIfVO.setCntrNo(cntrNo[cntrSeq++]);
	        					}
	        				}
	        	        	eqrRepoExeSoIfVO.setWoExeFlg("N");
	        	        	eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
	        	        	eqrRepoExeSoIfVO.setSoRqstDt(vo.getFmEtdDt());
	        	        	eqrRepoExeSoIfVO.setPlnSeq("0"); // 기본값으로 셋팅
	        	        	dbDao.createEccInternalSoData(eqrRepoExeSoIfVO, user_id);
	        	        }
	            		
	            	}
	            }
	        }
	            		
        	// ----- END                   	
        	  
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	 
    /**
     * 수정 이벤트 처리<br>
     * EES_EQR_083 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO
     * @param vos EesEqr0083MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException {
    	
    	String user_id = account.getUsr_id();
    	try{
    		int rowCount = (vos==null) ? 0 : vos.length;
			
			String exeFlag = "N";

            for(int k=0; k<rowCount; k++) {
            	EesEqr0083MultiVO vo = vos[k];
            	// SO SEND 체크박스 클릭 && SO CANCEL='T' 된것만 삭제 대상에 포함됨.
            	if(vo.getSoIssFlg().equals("1") && vo.getSoCancelFlag().equals("T")) {    
            	
            		// REF_ID 별로 삭제요건을 만족(Y)하는 경우 3개 테이블 순서대로 삭제
            		exeFlag = dbDao.soCancelCheckCntrRepoPlan(vo.getRepoPlnId(), vo.getPlnYrwk() , "0" , vo.getRefId()).getResultString();
            		if(exeFlag.equals("Y")) {   
            			EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
            			ObjectCloner.build(vo , eqrRepoExeSoIfVO );
            			eqrRepoExeSoIfVO.setPlnSeq("0");
            			dbDao.deleteShuttleSoData(eqrRepoExeSoIfVO);

            			EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
            			ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
            			dbDao.deleteShuttleExecuteQty(eqrEccInterExePlnQtyVO,user_id);
            			
            			EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
            			ObjectCloner.build(vo , eqrEccInterExePlnVO );
            			dbDao.deleteShuttleExecute(eqrEccInterExePlnVO,user_id);
            			
            		}else {
                		throw new DAOException(new ErrorHandler("EQR10027").getMessage());
                	} 
            	}
            }
    	} catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
	 * [ EES_EQR_0112 : Forecasted Land Inventory ]<br>
	 * 
	 * @param EesEqr0112ConditionVO eesEqr0112ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLocalForecastedLandInv(EesEqr0112ConditionVO eesEqr0112ConditionVO) throws EventException {
		try {
			return dbDao.searchLocalForecastedLandInv(eesEqr0112ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * [ EES_EQR_0092 : Total ]<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException {
		try {
			return dbDao.searchTotalCntrRepoPlan(eesEqr0059ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * added by ChungEunHo 09.10.15
	 * TRS에서 S/O 생성/수정/삭제시 EQR_REPO_EXE_SO_IF 테이블에 S/O상태 Field를 UPDATE
     * 
	 * @param singleTransportationVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean modifyFromTrsSOIFPlanSoSts( SingleTransportationVO singleTransportationVO) throws EventException {
		try {
			return dbDao.modifyFromTrsSOIFPlanSoSts(singleTransportationVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * added by ChungEunHo 09.10.21
	 * TRS 에서 Off Hire 직반납 시  ONF_HIR_EXE_PLN 및 S/O , CNTR 정보(신규 REF_ID 및 TO_YD_CD ) 수정
	 * 동일 ECC 내에서 TO_YD_CD 정보 수정됨 ( validation 은 TRS 에서 메소드 호출 전에 이루어짐
	 * 필수 입력항목 REPO_PLN_ID , PLN_YRWK , REF_ID , CNTR_TPSZ_CD , oldRefSeqList , TRSP_SO_STS_CD , CHD_TO_YD_CD  , CHD_CNTR_QTY
	 * 
	 * 직반납 데이터 프로세스  

		1. 데이터 INPUT , OUTPUT , 
		    1-1. INPUT
		        1-1-1. 조회 키
		            @[REPO_PLN_ID] ,
		            @[PLN_YRWK] ,
		            @[REF_ID] ,
		            @[CNTR_TPSZ_CD],
		            @[REF_SEQ][] (  REF_SEQ LIST )
		            @[TRSP_SO_STS_CD]
		            
		        1-1-2. 변경 데이터
		            @[CHD_TO_YD_CD] , ( 동일 ECC  validation 은 TRS 에서 확인후 넘겨짐 )
		            @[CHD_CNTR_QTY] ( EQR_ONF_HIR_EXE_PLN_QTY.CNTR_QTY( 기존 데이터)  >= @[CHD_CNTR_QTY] AND  @[CHD_CNTR_QTY] > 0 )
		    1-2. OUTPUT
		        String @[OUTPUTCODE]  : '00' 정상변경됨 , '10' 입력값 오류
		        , String @[NEW_REF_ID]
		        , List<String> @[refSeqList]
		
		2. 데이터 조회 및 파라메타 VAILDATION
		    2-1. EQR_ONF_HIR_EXE_PLN  , EQR_ONF_HIR_EXE_PLN_QTY
		        OLD DATA VO 생성
		    2-2. EQR_REPO_EXE_SO_IF
		        OLD DATA VO 생성 
		        
		    
		    2-3. 조회 데이터 없는 경우
		        @[OUTPUTCODE]  : '20' 조회값에 해당하는 데이터 없음
		    2-4. 조회값에 해당하는 S/O 데이터카운트가 맞지 않음 , 변경할 CNTR NO 갯수와 변경할 VOL 카운트가 맞지 않음
		        @[OUTPUTCODE]  : '40'
		    2-5. EQR_ONF_HIR_EXE_PLN.ONF_HIR_DIV_CD != 'F' 
		        @[OUTPUTCODE]  : '30' OFF Hire 아님    
		    2-6. @[CHD_TO_YD_CD] 동일 ECC 내의 TO_NOD_CD정보인지 확인
		        @[OUTPUTCODE]  : '50' fm_yd_cd , to_yd_cd 동일 ECC 구간 아님
		    
		    2-7. 기존 to_yd_cd 정보로 실행계획 조회
		         2-7-1. 직반납 요청이 있는 경우 해당 실행계획의 REF_ID 및 기본정보를 가져와서 추가하는 형식을 가짐
		         2-7-2. 해당 정보가 없는경우 신규 REF_ID를 생성하고 신규 실행계획을 INSERT 한다. ( EQR_ONF_HIR_EXE_PLN INSERT  )
		
		3. 데이터 연산
		    3-1. 이전하기 전 실행계획 데이터 연산
		        3-1-1. 이전할 실행계획인 전체 이동인 경우
		            EQR_ONF_HIR_EXE_PLN_QTY 테이블 삭제
		            EQR_ONF_HIR_EXE_PLN 테이블 삭제
		        3-1-2. 전체 이동이 아닌경우
		            TPSZ 내 전체 변경인 경우  기존 EQR_ONF_HIR_EXE_PLN_QTY data 삭제
		            이동후 남은 수량으로 update
		    3-2. 이동후 실행계획 데이터 연산
		        3-2-1. 기존 직반납 요청이 있는경우 ( TO_NOD_CD기준 )
		            EQR_ONF_HIR_EXE_PLN_QTY  UPDATE
		        3-2-2. 신규 요청
		            EQR_ONF_HIR_EXE_PLN_QTY INSERT 
		    3-3. 컨테이너 정보 데이터 연산
		        UPDATE EQR_REPO_EXE_SO_IF
		        UPDATE EQR_EXE_PLN_CNTR
	 * @param ModifyFromTrsOffHireReturnVO vo
	 * @param SignOnUserAccount account
	 * @return ModifyFromTrsOffHireReturnVO
	 * @exception EventException
	 */
	public ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturn( ModifyFromTrsOffHireReturnVO vo , SignOnUserAccount account)throws EventException {
		ModifyFromTrsOffHireReturnVO retVO = new ModifyFromTrsOffHireReturnVO();
		try {
			ObjectCloner.build(vo , retVO );
			String newRefId = "";
			String returnCode = "";
			String user_id = "";
//			String chd_cntr_no = "";
			String old_ref_seq = "";
			
			// ETS 에서 넘어온 경우 TRS_ETS 로 고정
			if(account != null && account.getUsr_id() != null){
				user_id = account.getUsr_id();
			}else{
				user_id = "TRS_ETS";
			}
			//String user_id = "TRS_PHXSC"; // TEST 
			String trspSoStsCd = vo.getTrspSoStsCd();
			// 반환할 REF_SEQ
			
			// 2-1 OLD DATA VO 생성
			SearchEqrOnfHirExePlnByOffHireReturnVO oldEqrOnfHirExePlnVO = dbDao.searchEqrOnfHirExePlnByOffHireReturn(vo);
			// 2-1  실제 S/O 카운트 값을 포함함 oldEqrOnfHirExePlnQtyVO.getVolCnt()
			EqrOnfHirExePlnQtyVO oldEqrOnfHirExePlnQtyVO = dbDao.searchEqrOnfHirExePlnQtyByOffHireReturn(vo);
			// 2-2 CNTR NO 로 리스트를 만들지 않고 REF_SEQ 만을 가지고 대상을 선택함
			List<EqrRepoExeSoIfVO> soList = dbDao.searchEqrRepoExeSoIfByOffHireReturn(vo);

			
//			if(!(vo.getCntrNoList().size() > 0 && vo.getOldRefSeqList().size() > 0 &&  vo.getCntrNoList().size() == vo.getOldRefSeqList().size())){
//				soList = null; // CNTR NO 와 Old REF_SEQ 를 같은 쌍의 수로 넘기지 않은 경우 조회값에 해당하는 데이터 없음 으로 상태를 변경한다.
//			}
			
			if(oldEqrOnfHirExePlnVO == null || oldEqrOnfHirExePlnQtyVO == null || soList == null || ( soList != null && soList.size() < 1)){
				returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_20; // 2-3 조회값에 해당하는 데이터 없음
			}else{
				if(Integer.parseInt(vo.getChdCntrQty()) != soList.size() && Integer.parseInt(vo.getChdCntrQty()) != vo.getCntrNoList().size()){
					returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_40; // 2-4 조회값에 해당하는 S/O 데이터카운트가 맞지 않음 , 변경할 CNTR NO 갯수와 변경할 VOL 카운트가 맞지 않음
				}else{
					if(Integer.parseInt(vo.getChdCntrQty()) < 1 || Integer.parseInt(vo.getChdCntrQty()) > Integer.parseInt( oldEqrOnfHirExePlnQtyVO.getCntrQty())){
						returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_10; // 1-2 변경 VOL 허용범위 위반
					}else{						
						if(!oldEqrOnfHirExePlnVO.getOnfHirDivCd().equals("F")){
							returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_30; // 2-5 OFF Hire 아님
						}else{
							
							/*
							 * 동일구간 ECC 인지 검증은 일단 유보 
							 * MODIFIED BY SHIN YONGCHAN
							if(!dbDao.checkIdenticalEcc(oldEqrOnfHirExePlnVO.getFmYdCd(), vo.getChdToYdCd())){
								returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_50; // 2-6 fm_yd_cd , to_yd_cd 동일 ECC 구간 아님
							}else{
							*/	
								// 2-7  기존 to_yd_cd 정보로 실행계획 조회 시작
								boolean dupCheck = false;
								boolean dupQtyCheck = false;
								EqrOnfHirExePlnVO chkEqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
								ObjectCloner.build(oldEqrOnfHirExePlnVO , chkEqrOnfHirExePlnVO );
								chkEqrOnfHirExePlnVO.setToYdCd(vo.getChdToYdCd());
								chkEqrOnfHirExePlnVO.setUpdUsrId(user_id);
								
								
								String[] checkInfo = dbDao.checkDuplicateOnfHirExePlnByOffHireReturn(chkEqrOnfHirExePlnVO );
								int currCntrQty = 0;
								int currRefSeq  = -1;
								String currRefId = "NaN";
								if(checkInfo.length == 2){
									currRefId = checkInfo[0];
									currRefSeq = Integer.parseInt(checkInfo[1]);
								}
								if(currRefId != null && !currRefId.equals("NaN") && !currRefId.equals(vo.getRefId())){ 
									// 주의사항 . 현재 REF_ID 가  이전에 해당 유저로 직반납된 경우 신규로 간주한다. ( !currRefId.equals(vo.getRefId() )
									//           다시 말해 중복 조회한 데이터가 TO_NOD_CD 변경 대상인 경우 신규로 간주한다. 
									dupCheck = true;
								}else{
									currRefSeq = -1;
								}
								// SO_IF.REF_SEQ 에 추가할 default Data 셋팅
				        		if(currRefSeq == -1){
				        			currRefSeq = 1;
				        		}else{
				        			currRefSeq = currRefSeq + 1; 
				        		}
				        		
				        		if(dupCheck){ // 
				        			String[] checkQtyInfo = dbDao.checkDuplicateOnfHirExePlnQtyByOffHireReturn(chkEqrOnfHirExePlnVO , vo.getCntrTpszCd() );
				        			if(checkQtyInfo.length == 2){
				        				currCntrQty = Integer.parseInt(checkQtyInfo[1]);
									}
				        		}
				        		
				        		if(currCntrQty > 0){ // QTY 정보 존재함
				        			dupQtyCheck = true;
				        		}
				        		// 2-7  기존 to_yd_cd 정보로 실행계획 조회 종료
				        		
								String[] tableCost = null;
					        	float unitcost = 0;
					        	// COST 정보 조회
		            			tableCost = dbDao.searchUnitCost("E", oldEqrOnfHirExePlnVO.getFmYdCd(), vo.getChdToYdCd(), oldEqrOnfHirExePlnVO.getOnfHirDivCd(), vo.getCntrTpszCd()).getResultStrArray();
					       		
					       		unitcost = Float.parseFloat(tableCost[2]);	
					       		EqrOnfHirExePlnVO eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
					       		
					        	if(dupCheck){
					        		newRefId = currRefId;
					        		retVO.setNewRefId(newRefId);
					        	}else{
									// 2-7-2 신규 REF_ID 생성
						        	newRefId = dbDao.makeRefIDCntrRepoPlan("EQR_ONF_HIR_EXE_PLN", oldEqrOnfHirExePlnVO.getCoCd(), vo.getRepoPlnId(), oldEqrOnfHirExePlnVO.getFmYdCd(), oldEqrOnfHirExePlnVO.getOnfHirDivCd());
									retVO.setNewRefId(newRefId);
									// INSERT INTO EQR_ONF_HIR_EXE_PLN
									eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
				            		ObjectCloner.build(oldEqrOnfHirExePlnVO , eqrOnfHirExePlnVO );
				            		eqrOnfHirExePlnVO.setRefId(newRefId);
				            		eqrOnfHirExePlnVO.setToYdCd(vo.getChdToYdCd());
		//		            		eqrOnfHirExePlnVO.setToLocDt(vo.getChdToYdDt());
				            		dbDao.insertOnOffHireExecute(eqrOnfHirExePlnVO, user_id);
					        	}
						       	
						       	// Start. Before OffHireReturn UPDATE OR DELETE EQR_ONF_HIR_EXE_PLN_QTY  
					       		
					       		if(Integer.parseInt(vo.getChdCntrQty()) == Integer.parseInt( oldEqrOnfHirExePlnVO.getAllTpszVol())){ // 전체 변경인 경우 이전 실행 계획 삭제
					       			// 3-1-1 DELETE EQR_ONF_HIR_EXE_PLN_QTY
					       			// EQR_ONF_HIR_EXE_PLN_QTY 테이블 삭제
				        			EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyDelVO = new EqrOnfHirExePlnQtyVO();
							       	ObjectCloner.build(oldEqrOnfHirExePlnQtyVO , eqrOnfHirExePlnQtyDelVO );
							       	dbDao.deleteOnOffHireExecuteQty(eqrOnfHirExePlnQtyDelVO);
							       	
									// EQR_ONF_HIR_EXE_PLN 테이블 삭제
				        			eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
				        			ObjectCloner.build(oldEqrOnfHirExePlnVO , eqrOnfHirExePlnVO );
				        			dbDao.deleteOnOffHireExecute(eqrOnfHirExePlnVO);
					       		}else{
					       			// 3-1-2 UPDATE EQR_ONF_HIR_EXE_PLN_QTY
					       			if(Integer.parseInt(vo.getChdCntrQty()) == Integer.parseInt( oldEqrOnfHirExePlnQtyVO.getCntrQty())){ 
					       				// TPSZ 내 전체 변경인 경우  기존 EQR_ONF_HIR_EXE_PLN_QTY data 삭제
					       				dbDao.deleteEqrOnfHirExePlnQtyByCntrTpSz(vo);
					       			}else{
					       				EqrOnfHirExePlnQtyVO oriEqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
					       				ObjectCloner.build(vo , oriEqrOnfHirExePlnQtyVO );
					       				oriEqrOnfHirExePlnQtyVO.setCntrQty((Integer.parseInt( oldEqrOnfHirExePlnQtyVO.getCntrQty()) - Integer.parseInt(vo.getChdCntrQty()))+""); 
					       				if(oldEqrOnfHirExePlnQtyVO.getPlnUcAmt() != null  && !oldEqrOnfHirExePlnQtyVO.getPlnUcAmt().equals("") && Double.parseDouble(oldEqrOnfHirExePlnQtyVO.getPlnUcAmt()) != 0  ){
					       					oriEqrOnfHirExePlnQtyVO.setOnfHirCostAmt((Integer.parseInt(oriEqrOnfHirExePlnQtyVO.getCntrQty()) * Float.parseFloat(oldEqrOnfHirExePlnQtyVO.getPlnUcAmt()))+"");
					       					oriEqrOnfHirExePlnQtyVO.setPlnUcAmt(oldEqrOnfHirExePlnQtyVO.getPlnUcAmt());
					       				}else{
					       					// COST 정보 조회
					       					String[] oritableCost = null;
								        	float oriunitcost = 0;
								        	oritableCost = dbDao.searchUnitCost("E", oldEqrOnfHirExePlnVO.getFmYdCd(), oldEqrOnfHirExePlnVO.getToYdCd(), oldEqrOnfHirExePlnVO.getOnfHirDivCd(), vo.getCntrTpszCd()).getResultStrArray();
								       		
								        	oriunitcost = Float.parseFloat(oritableCost[2]);	
								       		oriEqrOnfHirExePlnQtyVO.setOnfHirCostAmt((Integer.parseInt(oriEqrOnfHirExePlnQtyVO.getCntrQty()) * oriunitcost)+"");
								       		oriEqrOnfHirExePlnQtyVO.setPlnUcAmt(oriunitcost+"");
					       				}
					       				
					       				// 이동후 남은 수량으로 update
					       				dbDao.modifyCntrQtyOfEqrOnfHirExePlnQty(oriEqrOnfHirExePlnQtyVO,user_id);
					       			}
					       		}
						       	// End. Before OffHireReturn UPDATE OR DELETE EQR_ONF_HIR_EXE_PLN_QTY 
					       		if(dupQtyCheck){
					       			// 3-2-1 기존에 존재하는 경우 해당 Row Update
					       			EqrOnfHirExePlnQtyVO oriEqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
				       				ObjectCloner.build(vo , oriEqrOnfHirExePlnQtyVO );
				       				oriEqrOnfHirExePlnQtyVO.setRefId(currRefId);
				       				
				       				oriEqrOnfHirExePlnQtyVO.setCntrQty(( currCntrQty + Integer.parseInt(vo.getChdCntrQty()))+""); 
				       				
			       					oriEqrOnfHirExePlnQtyVO.setOnfHirCostAmt((Integer.parseInt(oriEqrOnfHirExePlnQtyVO.getCntrQty()) * unitcost)+"");
			       					oriEqrOnfHirExePlnQtyVO.setPlnUcAmt(unitcost+"");				       				
				       				
				       				dbDao.modifyCntrQtyOfEqrOnfHirExePlnQty(oriEqrOnfHirExePlnQtyVO,user_id);
					       		}else{
							       	// 3-2-2 INSERT INTO EQR_ONF_HIR_EXE_PLN_QTY
						       		EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
				        			ObjectCloner.build(oldEqrOnfHirExePlnQtyVO , eqrOnfHirExePlnQtyVO );
				        			eqrOnfHirExePlnQtyVO.setRefId(newRefId);
				        			eqrOnfHirExePlnQtyVO.setCntrTpszCd(vo.getCntrTpszCd());
				        			eqrOnfHirExePlnQtyVO.setCntrQty(vo.getChdCntrQty());
				        			eqrOnfHirExePlnQtyVO.setOnfHirCostAmt((Integer.parseInt(vo.getChdCntrQty()) * unitcost)+"");
				        			eqrOnfHirExePlnQtyVO.setPlnUcAmt(unitcost+"");
				        			dbDao.insertOnOffHireExecuteQty(eqrOnfHirExePlnQtyVO, user_id);
					       		}
					       		
					       		// 3-3 컨테이너 정보 업데이트 ( SO_IF )
					       		Iterator<EqrRepoExeSoIfVO> iterator = soList.iterator();
			        			int ref_seq = currRefSeq;
			        			while(iterator.hasNext()){
			        				EqrRepoExeSoIfVO epesiVO = iterator.next();
			        				
			        				if(trspSoStsCd == null || ( trspSoStsCd != null && trspSoStsCd.equals(""))){
										trspSoStsCd = epesiVO.getTrspSoStsCd();
									}
	//		        				epesiVO.setToDt(vo.getChdToYdDt());
			        				epesiVO.setToYdCd(vo.getChdToYdCd());
			        				epesiVO.setTrspSoStsCd(trspSoStsCd);
			        				
			        				// 업데이트 할 CNTR NO
//			        				if(vo.getCntrNoList().size() > 0 && vo.getOldRefSeqList().size() > 0 ){
//			        					for(int i = 0 ; i < vo.getCntrNoList().size();i++ ){
//			        						if(epesiVO.getRefSeq().equals(vo.getOldRefSeqList().get(i))){
//			        							chd_cntr_no = vo.getCntrNoList().get(i);
//			        							old_ref_seq = epesiVO.getRefSeq();
//			        							i = vo.getCntrNoList().size()+1; // loop break
//			        						}
//			        					}
//			        				}
			        				old_ref_seq = epesiVO.getRefSeq();
			        				//epesiVO.setCntrNo(chd_cntr_no);
			        				epesiVO.setRefSeq((ref_seq++)+"");
			        				
			        				// UPDATE EQR_REPO_EXE_SO_IF
			        				dbDao.modifyFromTRSEqrRepoExeSoIf(epesiVO,newRefId,user_id , old_ref_seq);

			        				// ref_seq 반환 
			        				retVO.addRefSeqList(epesiVO.getRefSeq());
				        			
				        			// UPDATE EQR_EXE_PLN_CNTR
			        				vo.setCntrNo(epesiVO.getCntrNo());
			        				dbDao.modifyFromTRSEqrExePlnCntr(vo,newRefId , user_id);
			        			}
			        			
			        			returnCode=Constants.TRS_OFF_HIRE_RETURNCODE_SUCCESS;
			        		/*	
							}
							*/
						}
					}					
				}
			}
			
			retVO.setReturnCode(returnCode);
			return retVO;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Fixed Plan <br>
	 * 
	 * @param eqrVslLodgDchgPlnQtyVO EqrVslLodgDchgPlnQtyVO
	 * @exception 
	 */
	public void modifyFixedPlan(EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO) throws EventException {
		try {
	       	String fixedPlnQty = dbDao.searchFixedPlanQty(eqrVslLodgDchgPlnQtyVO).getResultString();

	       	int diff_qty = Integer.parseInt(fixedPlnQty) - Integer.parseInt(eqrVslLodgDchgPlnQtyVO.getCntrQty());
	       	diff_qty = ( diff_qty < 0 ) ? 0 : diff_qty;
			
			eqrVslLodgDchgPlnQtyVO.setCntrQty(Integer.toString(diff_qty));
			eqrVslLodgDchgPlnQtyVO.setLodgDchgCostAmt(Float.toString(diff_qty * Float.parseFloat(eqrVslLodgDchgPlnQtyVO.getPlnUcAmt())));
			
			dbDao.modifyFixedPlanVolume(eqrVslLodgDchgPlnQtyVO);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EQR All-Weeks' Plan Access Grant 조회 이벤트 처리<br>
	 * 
	 * @return List<SearchEqrAllWeeksPlanAccessGrantVO>
	 * @exception EventException
	 */
	public List<SearchEqrAllWeeksPlanAccessGrantVO> searchEqrAllWeeksPlanAccessGrant() throws EventException {
		try {
			return dbDao.searchEqrAllWeeksPlanAccessGrant();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EQR All-Weeks' Plan Access Grant 수정 이벤트 처리<br>
	 * 
	 * @param eesEqr0143MultiVOs EesEqr0143MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyEqrAllWeeksPlanAccessGrant(EesEqr0143MultiVO[] eesEqr0143MultiVOs, SignOnUserAccount account) throws EventException {
		try {
			List<EesEqr0143MultiVO> updateVoList = new ArrayList<EesEqr0143MultiVO>();
			List<EesEqr0143MultiVO> deleteVoList = new ArrayList<EesEqr0143MultiVO>();
			
			for ( int i=0; i<eesEqr0143MultiVOs .length; i++ ) {
				if ( eesEqr0143MultiVOs[i].getIbflag().equals("U") || eesEqr0143MultiVOs[i].getIbflag().equals("I")){
					eesEqr0143MultiVOs[i].setCreUsrId(account.getUsr_id());
					eesEqr0143MultiVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eesEqr0143MultiVOs[i]);
				} else if (eesEqr0143MultiVOs[i].getIbflag().equals("D")) {
					eesEqr0143MultiVOs[i].setCreUsrId(account.getUsr_id());
					eesEqr0143MultiVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(eesEqr0143MultiVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.mergeEqrAllWeeksPlanAccessGrant(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.deleteEqrAllWeeksPlanAccessGrant(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}