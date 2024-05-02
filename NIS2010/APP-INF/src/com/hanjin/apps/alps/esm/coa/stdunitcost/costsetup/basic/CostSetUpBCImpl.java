/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostSetUpDBDAO.java
*@FileTitle : Manual Cost Set up
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.04 
* 1.0 Creation 
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2012.12.13 송호진 [CHM-201221879] [COA] Manual Cost Set up 화면 로직 수정 
* 2014.06.19 최덕우 [CHM-201430638] [COA] BU Other (계선/대선) 항목의 각 계정별 분리 반영 위한 CSR 
* 2015.04.09 이윤정 [CHM-201534872] MTY Reposition Cost Detail 상 최종 Creation 날짜 표시
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration.CostSetUpDBDAO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.GeneralExpenseVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.MtyRepoTESTRSCostVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.SearchCostSetUpListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.VesselLayupVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaMnlCostStupVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;

/**
 * ALPS-STDUnitCost Business Logic Basic Command implementation<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jeon Yun Joo
 * @see ESM_COA_0012EventResponse,MASBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CostSetUpBCImpl extends BasicCommandSupport implements CostSetUpBC {

	// Database Access Object
	private transient CostSetUpDBDAO dbDao = null;

	/**
	 * MASBCImpl 객체 생성<br>
	 * MASDBDAO를 생성한다.<br>
	 */
	public CostSetUpBCImpl() {
		dbDao = new CostSetUpDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<SearchCostSetUpListVO> searchCostSetUpList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String cost_yrmon = arrSearch[0]+arrSearch[1];
			searchConditionVO.setFCostYrmon(cost_yrmon);                                     

			return dbDao.searchCostSetUpList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<SearchCostSetUpListVO> searchCostStupDef(SearchConditionVO searchConditionVO) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String cost_yrmon = arrSearch[0]+arrSearch[1];
			searchConditionVO.setFCostYrmon(cost_yrmon);                                     

			return dbDao.searchCostStupDef(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<MtyRepoTESTRSCostVO> searchMtyRepoCostCreateDate(SearchConditionVO searchConditionVO) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String cost_yrmon = arrSearch[0]+arrSearch[1];
			searchConditionVO.setFCostYrmon(cost_yrmon);                                     

			return dbDao.searchMtyRepoCostCreateDate(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<SearchCostSetUpListVO> searchCostStupMTAbcList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String cost_yrmon = arrSearch[0]+arrSearch[1];
			searchConditionVO.setFCostYrmon(cost_yrmon);                                     

			return dbDao.searchCostStupMTAbcList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCostSetUpListVO[] searchCostSetUpListVOs
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiOtherCostSetup(SearchCostSetUpListVO[] searchCostSetUpListVOs, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {			
			List<CoaMnlCostStupVO> multiVoList = new ArrayList<CoaMnlCostStupVO>();
			String[] arrSearch = conditionVO.getFYearweek().split("[-]");
			String cost_yrwk = arrSearch[0]+arrSearch[1];

			CoaMnlCostStupVO coaMnlCostStupVO;
			
			for ( int i=0; i<searchCostSetUpListVOs .length; i++ ) {
				
				if ( searchCostSetUpListVOs[i].getIbflag().equals("U")){
				if (!searchCostSetUpListVOs[i].getTpsAmt().equals(searchCostSetUpListVOs[i].getTpsOldAmt())){
					coaMnlCostStupVO = new CoaMnlCostStupVO();
					coaMnlCostStupVO.setRlaneCd(searchCostSetUpListVOs[i].getItmCd());
					coaMnlCostStupVO.setTrdCd("TPS");
					coaMnlCostStupVO.setOtrExpnAmt(searchCostSetUpListVOs[i].getTpsAmt());
					multiVoList.add(coaMnlCostStupVO);
		  	     }
				if (!searchCostSetUpListVOs[i].getAesAmt().equals(searchCostSetUpListVOs[i].getAesOldAmt())){	
					coaMnlCostStupVO = new CoaMnlCostStupVO();
					coaMnlCostStupVO.setRlaneCd(searchCostSetUpListVOs[i].getItmCd());
					coaMnlCostStupVO.setTrdCd("AES");
					coaMnlCostStupVO.setOtrExpnAmt(searchCostSetUpListVOs[i].getAesAmt());
					multiVoList.add(coaMnlCostStupVO);
				}
				
				if (!searchCostSetUpListVOs[i].getTasAmt().equals(searchCostSetUpListVOs[i].getTasOldAmt())){
					coaMnlCostStupVO = new CoaMnlCostStupVO();
					coaMnlCostStupVO.setRlaneCd(searchCostSetUpListVOs[i].getItmCd());
					coaMnlCostStupVO.setTrdCd("TAS");
					coaMnlCostStupVO.setOtrExpnAmt(searchCostSetUpListVOs[i].getTasAmt());
					multiVoList.add(coaMnlCostStupVO);
				}
				if (!searchCostSetUpListVOs[i].getIasAmt().equals(searchCostSetUpListVOs[i].getIasOldAmt())){
					coaMnlCostStupVO = new CoaMnlCostStupVO();
					coaMnlCostStupVO.setRlaneCd(searchCostSetUpListVOs[i].getItmCd());
					coaMnlCostStupVO.setTrdCd("IAS");
					coaMnlCostStupVO.setOtrExpnAmt(searchCostSetUpListVOs[i].getIasAmt());
					multiVoList.add(coaMnlCostStupVO);
				}
				if (!searchCostSetUpListVOs[i].getEmsAmt().equals(searchCostSetUpListVOs[i].getEmsOldAmt())){
					coaMnlCostStupVO = new CoaMnlCostStupVO();
					coaMnlCostStupVO.setRlaneCd(searchCostSetUpListVOs[i].getItmCd());
					coaMnlCostStupVO.setTrdCd("EMS");
					coaMnlCostStupVO.setOtrExpnAmt(searchCostSetUpListVOs[i].getEmsAmt());						
					multiVoList.add(coaMnlCostStupVO);
				}
				if (!searchCostSetUpListVOs[i].getComAmt().equals(searchCostSetUpListVOs[i].getComOldAmt())){
					coaMnlCostStupVO = new CoaMnlCostStupVO();
					coaMnlCostStupVO.setRlaneCd(searchCostSetUpListVOs[i].getItmCd());
					coaMnlCostStupVO.setTrdCd("COM");
					coaMnlCostStupVO.setOtrExpnAmt(searchCostSetUpListVOs[i].getComAmt());
					multiVoList.add(coaMnlCostStupVO);
				}
			}
			}
						
			if ( multiVoList.size() > 0 ) {
				dbDao.multiOtherCostSetup(multiVoList,account,cost_yrwk);
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCostSetUpListVO[] searchCostSetUpListVOs
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMTAbcCostSetup(SearchCostSetUpListVO[] searchCostSetUpListVOs, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {			
			List<CoaMnlCostStupVO> updateVoList = new ArrayList<CoaMnlCostStupVO>();
			String[] arrSearch = conditionVO.getFYearweek().split("[-]");
			String cost_yrmon = arrSearch[0]+arrSearch[1];

			CoaMnlCostStupVO coaMnlCostStupVO = new CoaMnlCostStupVO();
			//General Expense 에 일괄 업데이트
			CoaMnlCostStupVO genExpVO = new CoaMnlCostStupVO();
			
			for ( int i=0; i<searchCostSetUpListVOs .length; i++ ) {	
				if ( searchCostSetUpListVOs[i].getIbflag().equals("U")){
					coaMnlCostStupVO = new CoaMnlCostStupVO();
					coaMnlCostStupVO.setRlaneCd(searchCostSetUpListVOs[i].getItmCd());
					coaMnlCostStupVO.setTrdCd("COM");
					coaMnlCostStupVO.setOtrExpnAmt(searchCostSetUpListVOs[i].getComAmt());
					updateVoList.add(coaMnlCostStupVO);
					
					//General Expense 에 일괄 업데이트
					if(searchCostSetUpListVOs[i].getItmCd().equals("GENTT")) {
						genExpVO.setRlaneCd(searchCostSetUpListVOs[i].getItmCd());
						genExpVO.setCostYrmon(cost_yrmon);
						genExpVO.setOtrExpnAmt(searchCostSetUpListVOs[i].getComAmt());
						genExpVO.setUpdUsrId(account.getUsr_id());
					}				
				}				
			}
						
			if ( updateVoList.size() > 0 ) {
				dbDao.multiMTAbcCostSetup(updateVoList,account,cost_yrmon);
				
				//General Expense 에 일괄 업데이트
				if (genExpVO.getRlaneCd() != null) {
					dbDao.modifyGeneralExpenseAll(genExpVO);
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
	 * 생성 이벤트 처리<br>
	 * Manual Cost Setup를월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createManualCostStupCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

          //1. COA_MNL_COST_STUP테이블에서  TARGET 해당월을 삭제한다.
            dbDao.removeManualCostStupCopy(param);
          //2. COA_MNL_COST_STUP테이블에  SOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
            dbDao.createManualCostStupCopy(param);;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMTAbcCostSetup(SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {			
			String[] arrSearch = conditionVO.getFYearweek().split("[-]");
			String cost_yrweek = arrSearch[0]+arrSearch[1];   
			
			dbDao.createDefExp(cost_yrweek,account);
			dbDao.createVSLMarketRt(cost_yrweek,account);
			dbDao.createVesselCht(cost_yrweek,account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MtyRepoTESTRSCostVO>
	 * @exception EventException
	 */
	public List<MtyRepoTESTRSCostVO> searchMtyRepoCostDtl(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMtyRepoCostDtl(searchConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMtyRepoTESTRSCost(MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MtyRepoTESTRSCostVO> updateVoList = new ArrayList<MtyRepoTESTRSCostVO>();
			for ( int i=0; i<mtyRepoTESTRSCostVOs .length; i++ ) {
				if ( mtyRepoTESTRSCostVOs[i].getIbflag().equals("U")){
					if(mtyRepoTESTRSCostVOs[i].getSelFlg().equals("1")) {
						// tes/trs I/F 된 비용을 COA로 이동
						mtyRepoTESTRSCostVOs[i].setUserId(account.getUsr_id());
						updateVoList.add(mtyRepoTESTRSCostVOs[i]);						
					}
				} 
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCoaUtCostCreSts(updateVoList);
				dbDao.createMtyRepoTESTRSCost(updateVoList);
//				신규 쿼리 생성yj
				dbDao.modifyCoaUtCostCreSts(updateVoList);

			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMtyRepoTESTRSCost(MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MtyRepoTESTRSCostVO> updateVoList = new ArrayList<MtyRepoTESTRSCostVO>();
			List<MtyRepoTESTRSCostVO> locateVoList = new ArrayList<MtyRepoTESTRSCostVO>();
			for ( int i=0; i<mtyRepoTESTRSCostVOs .length; i++ ) {
				if ( mtyRepoTESTRSCostVOs[i].getIbflag().equals("U")){
					if(mtyRepoTESTRSCostVOs[i].getSelFlg().equals("1")) {
						// tes/trs I/F 된 비용을 COA로 이동
						mtyRepoTESTRSCostVOs[i].setUserId(account.getUsr_id());
						locateVoList.add(mtyRepoTESTRSCostVOs[i]);
						
					} else {
						// Row update
						mtyRepoTESTRSCostVOs[i].setUserId(account.getUsr_id());
						updateVoList.add(mtyRepoTESTRSCostVOs[i]);
					}
				} 
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMtyRepositionCost(updateVoList);
			}
			
			if ( locateVoList.size() > 0 ) {
				dbDao.modifyMtInvoiceAmount(locateVoList);
			}
			
			// save후에 월별 MT 비용을 합산하여 저장한다.
			dbDao.modifyTotalMtInvoiceAmount(mtyRepoTESTRSCostVOs[0]);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
		
	/**
	 * BackEndJob을 실행
	 * 
	 * @param SignOnUserAccount account
	 * @param MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs
	 * @param String pgmNo
	 * @return String 
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs, String pgmNo)  throws EventException{

		CostSetUpBackEndJob backEndJob = new CostSetUpBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		
		if(pgmNo.equals("ESM_COA_0022")) {
			backEndJob.setMtyRepoTESTRSCostVOs(mtyRepoTESTRSCostVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "createMtyRepoTESTRSCost BackEndJob");
		}
		return resultStr;
	}
	

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param GeneralExpenseVO generalExpenseVO
	 * @return List<GeneralExpenseVO>
	 * @exception EventException
	 */
	public List<GeneralExpenseVO> searchGeneralExpenseList(GeneralExpenseVO generalExpenseVO) throws EventException {
		try { 
			generalExpenseVO.setCostYrmon(generalExpenseVO.getCostYrmon().replaceAll("-", ""));
			return dbDao.searchGeneralExpenseList(generalExpenseVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * [일반관리비]를 [저장] 합니다.<br>
	 * 
	 * @param GeneralExpenseVO[] generalExpenseVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiGeneralExpense(GeneralExpenseVO[] generalExpenseVOs, SignOnUserAccount account) throws EventException {
		try {
				List<GeneralExpenseVO> mergeVoList = new ArrayList<GeneralExpenseVO>();
				
				for ( int i=0; i<generalExpenseVOs .length; i++ ) {						
					generalExpenseVOs[i].setCreUsrId(account.getUsr_id());				
					generalExpenseVOs[i].setUpdUsrId(account.getUsr_id());
					mergeVoList.add(generalExpenseVOs[i]);				
				}
				
				if ( mergeVoList.size() > 0 ) {
					dbDao.modifyGeneralExpense(mergeVoList);
				}				
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 * Vessel Charter / Lay Up Expense 정보를 조회<br>
	 *
	 * @param VesselLayupVO vesselLayupVO
	 * @return List<VesselLayupVO>
	 * @exception EventException
	 */
	public List<VesselLayupVO> searchVslLayupList(VesselLayupVO vesselLayupVO) throws EventException {
		try {
			return dbDao.searchVslLayupList(vesselLayupVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 * Vessel 데이터 Validate <br>
	 *
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String getVesselChk(String vslCd) throws EventException {
		try {
			return dbDao.getVesselChk(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_COA_0024]<br>
	 *  Vessel Charter / Lay Up Expense 정보를 일괄적으로 저장<br>
	 *
	 * @param VesselLayupVO[] vesselLayupVOs
	 * @param VesselLayupVO vesselLayupVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslLayupList(VesselLayupVO[] vesselLayupVOs, VesselLayupVO vesselLayupVO, SignOnUserAccount account) throws EventException{
		try {
			List<VesselLayupVO> insertVoList = new ArrayList<VesselLayupVO>();
						
			int vslChtrSum = 0;		// Vessel Charter Revenue 합계
			int otherSum = 0;
			int totSum = 0;
			for (int i=0; i<vesselLayupVOs.length; i++ ) {
				if (!vesselLayupVOs[i].getIbflag().equals("D")) {
					if (!vesselLayupVOs[i].getVslCd().equals("TTL")) {			// Total 항목은 저장에서 제외
						vesselLayupVOs[i].setUsrId(account.getUsr_id());  
						if (vesselLayupVOs[i].getStndCostCd().equals("43101011")) {	//Vessel Charter Revenue이면 더한다
							vslChtrSum = vslChtrSum + Integer.parseInt(vesselLayupVOs[i].getTtlAmt());
						} else {
							otherSum = otherSum + Integer.parseInt(vesselLayupVOs[i].getTtlAmt());
						}
		
						insertVoList.add(vesselLayupVOs[i]);
					}
				}
			}
			if (vesselLayupVO.getRlaneCd().equals("CDMCO")) {		//Vessel Charter화면
				totSum = vslChtrSum - otherSum;
			} else if (vesselLayupVO.getRlaneCd().equals("CNTLY")) {	// Lay Up 화면
				totSum = vslChtrSum + otherSum;
			}

			vesselLayupVO.setUsrId(account.getUsr_id());
			
			//COA_MNL_COST_STUP 테이블에 데이터 있는지 확인
			int resCnt = 0;
			resCnt = dbDao.chkCostSetup(vesselLayupVO);

			//COA_MNL_COST_STUP 테이블에 total값 넣기
			if (resCnt > 0) {
				dbDao.updateVslLayupTot(vesselLayupVO, totSum);
			} else {
				dbDao.insertVslLayupTot(vesselLayupVO, totSum);
			}
			
			dbDao.removeVslLayupList(vesselLayupVO);	
			dbDao.addVslLayupList(insertVoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}