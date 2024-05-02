/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : PlanningBCImpl.java
*@FileTitle      : Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.21
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.21 CSQ USER
* 1.0 Creation
* 2014.07.28 이혜민 [CHM-201431117] qta set up화면에서 add-creation, add-freezing 로직 추가
* 2014.08.14 이혜민 [CHM-201431421] Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.planning.integration.PlanningDBDAO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqResultVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqSimulationVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaRhqDistributeResultListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaRhqQtaSummaryListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaSetUpHeadOfficeListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaSetupForIsaSecByHoSummaryVO;
import com.clt.apps.opus.esm.csq.planning.statusmanage.integration.StatusManageDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaLodRevVO;
import com.clt.syscommon.common.table.CsqQtaPotnMgmtVO;
import com.clt.syscommon.common.table.CsqSctrLodRevVO;

/**
 * ALPS-Planning Business Logic Command Interface<br>
 * - ALPS-Planning 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see PlanningDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PlanningBCImpl extends BasicCommandSupport implements PlanningBC {
	
	// Database Access Object
	private transient PlanningDBDAO dbDao = null;
	private transient StatusManageDBDAO dbDao2 = null;
	
	/**
	 * PlanningBCImpl 객체 생성<br>
	 * PlanningDBDAO를 생성한다.<br>
	 */
	public PlanningBCImpl() {
		dbDao = new PlanningDBDAO();
		dbDao2 = new StatusManageDBDAO();
	}
	
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaLoadRevListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevListVO> searchQtaLoadRevList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchQtaLoadRevList(conditionVO,account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param CsqQtaLodRevVO[] csqQtaLodRevVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaLoadRev(ConditionVO conditionVO, CsqQtaLodRevVO[] csqQtaLodRevVOS, SignOnUserAccount account) throws EventException{
		try {
			List<CsqQtaLodRevVO> updateVoList = new ArrayList<CsqQtaLodRevVO>();
			
			for ( int i=0; i<csqQtaLodRevVOS .length; i++ ) {    
				csqQtaLodRevVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaLodRevVOS[i].setBseYr(conditionVO.getFBseYr());
				csqQtaLodRevVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				csqQtaLodRevVOS[i].setOfcVwCd(conditionVO.getFOfcVwCd());
				csqQtaLodRevVOS[i].setCreUsrId(account.getUsr_id());
				csqQtaLodRevVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( csqQtaLodRevVOS[i].getIbflag().equals("U")){
					updateVoList.add(csqQtaLodRevVOS[i]);
				}				
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateQtaLoadRev(updateVoList);
			}
			
			dbDao.updateQtaVerStatus(conditionVO,account,"P");
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaLoadRev(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.updateQtaVerStatus(conditionVO,account,"C");
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaSetUpHeadOfficeListVO>
	 * @throws EventException
	 */
	public List<SearchQtaSetUpHeadOfficeListVO> searchQtaSetUpHeadOfficeList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchQtaSetUpHeadOfficeList(conditionVO, account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [수정] 합니다.<br>
	 * 
	 * @param CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaSetUpHeadOffice(CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CsqQtaPotnMgmtVO> updateVoList = new ArrayList<CsqQtaPotnMgmtVO>();
			
			for ( int i=0; i<csqQtaPotnMgmtVOS .length; i++ ) {    
				csqQtaPotnMgmtVOS[i].setBseTpCd(conditionVO.getFBseTpCd()); 
				csqQtaPotnMgmtVOS[i].setQtaStepCd(conditionVO.getFQtaStepCd());
				csqQtaPotnMgmtVOS[i].setRgnOfcCd(account.getOfc_cd()); 
				csqQtaPotnMgmtVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( csqQtaPotnMgmtVOS[i].getIbflag().equals("U")){
					updateVoList.add(csqQtaPotnMgmtVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateQtaSetUpHeadOffice(updateVoList);
			}
			
			dbDao.updateQtaVerStatus(conditionVO, account, "P");
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("CSQ00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaSetUpHeadOffice(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
				dbDao.updateQtaVerStatus(conditionVO,account,"C");
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0022 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ Distribute Result]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaRhqDistributeResultListVO>
	 * @throws EventException
	 */
	public List<SearchQtaRhqDistributeResultListVO> searchQtaRhqDistributeResultList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchQtaRhqDistributeResultList(conditionVO, account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0023 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ QTA Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaRhqQtaSummaryListVO>
	 * @throws EventException
	 */
	public List<SearchQtaRhqQtaSummaryListVO> searchQtaRhqQtaSummaryList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchQtaRhqQtaSummaryList(conditionVO, account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0024 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqListVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqListVO> searchQtaByRhqList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchQtaByRhqList(conditionVO,account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0024 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaByRhq(ConditionVO conditionVO, CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOS, SignOnUserAccount account) throws EventException{
		try {
			List<CsqQtaPotnMgmtVO> updateVoList = new ArrayList<CsqQtaPotnMgmtVO>();
			
			for ( int i=0; i<csqQtaPotnMgmtVOS .length; i++ ) {    
				csqQtaPotnMgmtVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaPotnMgmtVOS[i].setQtaStepCd(conditionVO.getFQtaStepCd());
				csqQtaPotnMgmtVOS[i].setCreUsrId(account.getUsr_id());
				csqQtaPotnMgmtVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( csqQtaPotnMgmtVOS[i].getIbflag().equals("U")){
					updateVoList.add(csqQtaPotnMgmtVOS[i]);
				}				
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateQtaByRhq(updateVoList);
			}			
			dbDao.updateQtaVerStatus(conditionVO,account,"P");
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0024 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaByRhq(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.updateQtaVerStatus(conditionVO,account,"C");
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [CSQ_QTA_STEP_VER]의 특정STS를 [Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @param String sts
	 * @return int
	 * @throws EventException
	 */
	public int searchQtaVerStatusCnt(ConditionVO conditionVO, SignOnUserAccount account, String sts) throws EventException {
		try {
			return dbDao.searchQtaVerStatusCnt(conditionVO,account,sts);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0025 : [이벤트]<br>
	 * [ QTA Set-up by RHQ (O/B Loading)_Office Distribute Result] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqResultVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqResultVO> searchQtaByRhqResult(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchQtaByRhqResult(conditionVO,account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0026 : [이벤트]<br>
	 * [QTA Set-up by RHQ (O/B Loading)_Office QTA Simulation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqSimulationVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqSimulationVO> searchQtaByRhqSimulation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchQtaByRhqSimulation(conditionVO,account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorListVO> searchQtaLoadRevForSectorList(ConditionVO conditionVO) throws EventException{
		try {
			return dbDao.searchQtaLoadRevForSectorList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office] 테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return int
	 * @throws EventException
	 */
	public String searchQtaLoadRevForSectorListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaLoadRevForSectorListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0213 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSector(ConditionVO conditionVO,  SignOnUserAccount account) throws EventException{
		try {
			//Basic data 중 누락된것 조회 (Office View, 노선, Bound, SKD Ver이 다 생성되어있는지)
			dbDao.searchMissingBasicDataList(conditionVO, "N", "N");
			dbDao.createQtaLoadRevForSector(conditionVO, account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0213 : [Freezing]<br>
	 * [확정] 데이터를 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaFreezingForSector(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			//Basic data 중 누락된것 조회 (Office View, 노선, Bound, SKD Ver이 다 생성되어있는지)
			dbDao.searchMissingBasicDataList(conditionVO, "N", "Y");
			
			List<SearchQtaLoadRevForSectorAddListVO> updVoList = new ArrayList<SearchQtaLoadRevForSectorAddListVO>();
			SearchQtaLoadRevForSectorAddListVO saveListVo = new SearchQtaLoadRevForSectorAddListVO();
			
			conditionVO.setFUsrId(account.getUsr_id());
			saveListVo.setBseTpCd(conditionVO.getFBseTpCd()); 
			saveListVo.setBseYr(conditionVO.getFBseYr());
			saveListVo.setBseQtrCd(conditionVO.getFBseQtrCd());
			saveListVo.setUsrId(account.getUsr_id());
			updVoList.add(saveListVo);

			// Target VVD를 입력한다.
			dbDao.insertCfmTgtVvdForFreezing(conditionVO, updVoList);
			// 확정데이터를 생성한다.
			dbDao.createQtaLoadRevForSectorFreezing(conditionVO, account);
			// Over All 데이터를 업데이트한다.(입력)
			dbDao.insertCfmQtaSyncForFreezing(conditionVO, updVoList);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaTransferForSector(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			conditionVO.setFIasSctrFlg("Y");
			dbDao.createTransferCsqSctrPfGrp(conditionVO, account);
			dbDao.createTransferCsqSctrPairMgmt(conditionVO, account);
			dbDao.createTransferCsqSctrLaneOfc(conditionVO, account);
			dbDao.createTransferCsqSctrPairCost(conditionVO, account);
			dbDao.createTransferCsqSctrPerfIf(conditionVO, account);
			dbDao.createTransferCsqSctrLodRev(conditionVO, account);
			dbDao2.createTransferCsqQtaTgtVvd(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0213 : [Save]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [저장] 합니다.<br>
	 * 
	 * @param CsqSctrLodRevVO[] csqSctrLodRevVO
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void updateQtaLoadRevForSector(CsqSctrLodRevVO[] csqSctrLodRevVO, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CsqSctrLodRevVO> updVoList = new ArrayList<CsqSctrLodRevVO>();
			
			for ( int i=0; i<csqSctrLodRevVO .length; i++ ) {    
				csqSctrLodRevVO[i].setBseTpCd(conditionVO.getFBseTpCd()); 
				csqSctrLodRevVO[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( csqSctrLodRevVO[i].getIbflag().equals("U")){
					updVoList.add(csqSctrLodRevVO[i]);
				}
			}
			
			if ( updVoList.size() > 0 ) {
				dbDao.updateQtaLoadRevForSector(updVoList);
			}
			
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("CSQ00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0214 : [Retrieve]<br>
	 *  [QTA Set up for IAS Sector by Head Office_Add Creation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorAddListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorAddListVO> searchQtaLoadRevForSectorAddCreationList(ConditionVO conditionVO) throws EventException {
		try {
			//Add-Creation시 Target VVD Fix를 하는데 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회한다.
    		dbDao.searchDiffPfVerAddTargetVVD(conditionVO);
			return dbDao.searchQtaLoadRevForSectorAddCreationList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0214 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchQtaLoadRevForSectorAddListVO[]  saveListVo 
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSectorAddCreation(ConditionVO conditionVO,  SearchQtaLoadRevForSectorAddListVO[] saveListVo ,SignOnUserAccount account) throws EventException{
		try {
			//Basic data 중 누락된것 조회 (Office View, 노선, Bound, SKD Ver이 다 생성되어있는지)
			dbDao.searchMissingBasicDataList(conditionVO, "Y", "N");
			
			List<SearchQtaLoadRevForSectorAddListVO> updVoList = new ArrayList<SearchQtaLoadRevForSectorAddListVO>();
			
			for ( int i=0; i<saveListVo.length; i++ ) {
				if("0".equals(Integer.toString(i))){
					saveListVo[i].setBseTpCd(conditionVO.getFBseTpCd()); 
					saveListVo[i].setBseYr(conditionVO.getFBseYr());
					saveListVo[i].setBseQtrCd(conditionVO.getFBseQtrCd());
					saveListVo[i].setUsrId(account.getUsr_id());
					saveListVo[i].setFFmWk(conditionVO.getFFmWk());
					saveListVo[i].setFToWk(conditionVO.getFToWk());
					if ( saveListVo[i].getIbflag().equals("U")){
						updVoList.add(saveListVo[i]);
					}
				}else{
					//같은 PF GROUP이 들어왔을경우 한번만 INSERT
					if(!saveListVo[i].getPfGrpCd().equals(saveListVo[i-1].getPfGrpCd())){	
						saveListVo[i].setBseTpCd(conditionVO.getFBseTpCd()); 
						saveListVo[i].setBseYr(conditionVO.getFBseYr());
						saveListVo[i].setBseQtrCd(conditionVO.getFBseQtrCd());
						saveListVo[i].setUsrId(account.getUsr_id());
						saveListVo[i].setFFmWk(conditionVO.getFFmWk());
						saveListVo[i].setFToWk(conditionVO.getFToWk());
						if ( saveListVo[i].getIbflag().equals("U")){
							updVoList.add(saveListVo[i]);
						}
					}	
				}
			}
			
		    if ( !conditionVO.getFCCnt().equals("0") ) { // 확정데이터가 있으면
		    	if ( updVoList.size() > 0 ) {
					// confirm 데이터가 있을 경우 선택한 노선의 PF Group에 대한 대상항차를 Fix 한다.
					dbDao.createQtaLoadRevForSectorAddTargetVVD(conditionVO, updVoList);
					// Target VVD의 BSA Group capa를 설정한다.
					dbDao.updateQtaLoadRevForSectorAddBSAGroup(conditionVO, updVoList);
		    	}
		    }
		    log.debug("=====================updVoList.size:"+updVoList.size());
			if ( updVoList.size() > 0 ) {
				// Load Rev 데이터를 생성한다.
				dbDao.createQtaLoadRevForSectorAddCreation(conditionVO, updVoList);
			}			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * ESM_CSQ_0215 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorAddListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorAddListVO> searchQtaLoadRevForSectorAddFreezingList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaLoadRevForSectorAddFreezingList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing] : [확정데이터]를 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchQtaLoadRevForSectorAddListVO[]  saveListVo 
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSectorAddFreezing(ConditionVO conditionVO,  SearchQtaLoadRevForSectorAddListVO[] saveListVo ,SignOnUserAccount account) throws EventException{
		try {
			//Basic data 중 누락된것 조회 (Office View, 노선, Bound, SKD Ver이 다 생성되어있는지)
			dbDao.searchMissingBasicDataList(conditionVO, "Y", "Y");
			
			List<SearchQtaLoadRevForSectorAddListVO> updVoList = new ArrayList<SearchQtaLoadRevForSectorAddListVO>();
			for ( int i=0; i<saveListVo.length; i++ ) {
				if("0".equals(Integer.toString(i))){
					saveListVo[i].setBseTpCd(conditionVO.getFBseTpCd()); 
					saveListVo[i].setBseYr(conditionVO.getFBseYr());
					saveListVo[i].setBseQtrCd(conditionVO.getFBseQtrCd());
					saveListVo[i].setUsrId(account.getUsr_id());
					saveListVo[i].setFFmWk(conditionVO.getFFmWk());
					saveListVo[i].setFToWk(conditionVO.getFToWk());
					if ( saveListVo[i].getIbflag().equals("U")){
						updVoList.add(saveListVo[i]);
					}
				}else{
					//같은 PF GROUP이 들어왔을경우 한번만 INSERT
					if(!saveListVo[i].getPfGrpCd().equals(saveListVo[i-1].getPfGrpCd())){	
						saveListVo[i].setBseTpCd(conditionVO.getFBseTpCd()); 
						saveListVo[i].setBseYr(conditionVO.getFBseYr());
						saveListVo[i].setBseQtrCd(conditionVO.getFBseQtrCd());
						saveListVo[i].setUsrId(account.getUsr_id());
						saveListVo[i].setFFmWk(conditionVO.getFFmWk());
						saveListVo[i].setFToWk(conditionVO.getFToWk());
						if ( saveListVo[i].getIbflag().equals("U")){
							updVoList.add(saveListVo[i]);
						}
					}	
				}	
			}
			
			// Add Freezing 은 Freezing 이후에 활성화 되기 때문에 항상 확정데이터가 있다.
			if ( !conditionVO.getFCCnt().equals("0") ) { // 확정데이터가 있으면
		    	if ( updVoList.size() > 0 ) {
					// confirm 데이터가 있을 경우 선택한 노선의 대상항차를 삭제 후 다시 입력한다.
					dbDao.removeCfmTgtVvdForAddFreezing(conditionVO, updVoList);
					dbDao.insertCfmTgtVvdForFreezing(conditionVO, updVoList);
					// confirm 데이터를 새로 입력하는 CfmTgtVvd 기준으로 삭제한 후 생성한다.
					dbDao.removeQtaLoadRevForSectorAddFreezing(conditionVO, updVoList);
					dbDao.createQtaLoadRevForSectorAddFreezing(conditionVO, updVoList);
					// Over All 데이터를 업데이트한다.(삭제 후 입력)
					dbDao.removeCfmQtaForFreezing(conditionVO, updVoList);
					dbDao.insertCfmQtaSyncForFreezing(conditionVO, updVoList);
		    	}
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0216 : [Retrieve]<br>
	 * [QTA Set Up for IAS Sector by Head Office_Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaSetupForIsaSecByHoSummaryVO>
	 * @throws EventException
	 */
	public List<SearchQtaSetupForIsaSecByHoSummaryVO> searchQtaSetupForIsaSecByHoSummary(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaSetupForIsaSecByHoSummary(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}