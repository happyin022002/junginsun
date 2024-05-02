/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : PlanningBCImpl.java
*@FileTitle      : Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.21
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.21 SQM USER
* 1.0 Creation
* 2014.07.28 이혜민 [CHM-201431117] qta set up화면에서 add-creation, add-freezing 로직 추가
* 2014.08.14 이혜민 [CHM-201431421] Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회
* 2015.09.17 김용습 [CHM-201537764] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Raw Data Export 버튼 신규 생성 
* 2015.09.22 김용습 [CHM-201537819] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Freezing, Add-Freezing 버튼 Validation 추가
* 2015.10.06 김용습 소스품질보완(메소드주석)
* 2015.12.22 김용습 [CHM-201539088] IAS Sector QTA Planning - Freezing 방식으로 전환 (Freezing을 배치방식으로 전환)
* 2016.01.28 최성민 [CHM-201639851] Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
* 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
* 2016.03.21 최성민 [CHM-201640187] Target VVD Fix 관련 로직 수정
* 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.07.04 최성민 [CHM-201642330] SQM 화면 버튼 추가 요청

=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.integration.PlanningDBDAO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqResultVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqSimulationVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaRhqDistributeResultListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaRhqQtaSummaryListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaSetUpHeadOfficeListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaSetupForIsaSecByHoSummaryVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchRbcLaneQtaListVO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration.StatusManageDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaLodRevVO;
import com.hanjin.syscommon.common.table.SqmQtaPotnMgmtVO;
import com.hanjin.syscommon.common.table.SqmQtaRbcVO;
import com.hanjin.syscommon.common.table.SqmSctrLodRevVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-Planning Business Logic Command Interface<br>
 * - ALPS-Planning 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
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
	 * ESM_SQM_0015 : [이벤트]<br>
	 * [RBC Lane QTA Setting]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchRbcLaneQtaListVO>
	 * @throws EventException
	 */
	public List<SearchRbcLaneQtaListVO> searchRbcLaneQtaList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchRbcLaneQtaList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0015 : [이벤트]<br>
	 * [RBC Lane QTA Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchRbcLaneQtaListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchRbcLaneQtaListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0015 : [이벤트]<br>
	 * [RBC Lane QTA Setting]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void createRbcLaneQtaSetting(ConditionVO conditionVO, String usrId) throws EventException{
		try {
			dbDao.createRbcLaneQtaSetting(conditionVO, usrId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0015 : [이벤트]<br>
	 * [RBC Lane QTA Setting]의 [저장] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmQtaRbcVO[] sqmQtaRbcVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRbcLaneQtaSetting(ConditionVO conditionVO, SqmQtaRbcVO[] sqmQtaRbcVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaRbcVO> deleteVoList = new ArrayList<SqmQtaRbcVO>();
			List<SqmQtaRbcVO> updateVoList = new ArrayList<SqmQtaRbcVO>();
			
			for ( int i=0; i<sqmQtaRbcVOS .length; i++ ) {    
				sqmQtaRbcVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaRbcVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmQtaRbcVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmQtaRbcVOS[i].setOfcVwCd(conditionVO.getFOfcVwCd());
				sqmQtaRbcVOS[i].setCreUsrId(account.getUsr_id());
				sqmQtaRbcVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmQtaRbcVOS[i].getIbflag().equals("D")){
					deleteVoList.add(sqmQtaRbcVOS[i]);
				} else if ( sqmQtaRbcVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaRbcVOS[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeRbcLaneQtaSetting(deleteVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateRbcLaneQtaSetting(updateVoList);
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
					throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0014 : [이벤트]<br>
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
	 * ESM_SQM_0014 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmQtaLodRevVO[] sqmQtaLodRevVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaLoadRev(ConditionVO conditionVO, SqmQtaLodRevVO[] sqmQtaLodRevVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaLodRevVO> updateVoList = new ArrayList<SqmQtaLodRevVO>();
			
			for ( int i=0; i<sqmQtaLodRevVOS .length; i++ ) {    
				sqmQtaLodRevVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaLodRevVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmQtaLodRevVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmQtaLodRevVOS[i].setOfcVwCd(conditionVO.getFOfcVwCd());
				sqmQtaLodRevVOS[i].setCreUsrId(account.getUsr_id());
				sqmQtaLodRevVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmQtaLodRevVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaLodRevVOS[i]);
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
	 * ESM_SQM_0014 : [이벤트]<br>
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
	 * ESM_SQM_0016 : [이벤트]<br>
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
	 * ESM_SQM_0016 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [수정] 합니다.<br>
	 * 
	 * @param SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaSetUpHeadOffice(SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaPotnMgmtVO> updateVoList = new ArrayList<SqmQtaPotnMgmtVO>();
			
			for ( int i=0; i<sqmQtaPotnMgmtVOS .length; i++ ) {    
				sqmQtaPotnMgmtVOS[i].setBseTpCd(conditionVO.getFBseTpCd()); 
				sqmQtaPotnMgmtVOS[i].setQtaStepCd(conditionVO.getFQtaStepCd());
				sqmQtaPotnMgmtVOS[i].setRgnOfcCd(account.getOfc_cd()); 
				sqmQtaPotnMgmtVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmQtaPotnMgmtVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaPotnMgmtVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateQtaSetUpHeadOffice(updateVoList);
			}
			
			dbDao.updateQtaVerStatus(conditionVO, account, "P");
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0016 : [이벤트]<br>
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
	 * ESM_SQM_0017 : [이벤트]<br>
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
	 * ESM_SQM_0018 : [이벤트]<br>
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
	 * ESM_SQM_0019 : [이벤트]<br>
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
	 * ESM_SQM_0019 : [이벤트]<br>
	 * [Loading View Figure Copy]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqListVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqListVO> searchLoadingViewFigureList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchLoadingViewFigureList(conditionVO,account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SQM_0019 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaByRhq(ConditionVO conditionVO, SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaPotnMgmtVO> updateVoList = new ArrayList<SqmQtaPotnMgmtVO>();
			
			for ( int i=0; i<sqmQtaPotnMgmtVOS .length; i++ ) {    
				sqmQtaPotnMgmtVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaPotnMgmtVOS[i].setQtaStepCd(conditionVO.getFQtaStepCd());
				sqmQtaPotnMgmtVOS[i].setCreUsrId(account.getUsr_id());
				sqmQtaPotnMgmtVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmQtaPotnMgmtVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaPotnMgmtVOS[i]);
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
	 * ESM_SQM_0019 : [이벤트]<br>
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
	 * ESM_SQM_0014 : [이벤트]<br>
	 * [SQM_QTA_STEP_VER]의 특정STS를 [Count] 합니다.<br>
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
	 * ESM_SQM_0020 : [이벤트]<br>
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
	 * ESM_SQM_0021 : [이벤트]<br>
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
	 * ESM_SQM_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchQtaLoadRevForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorListVO> searchQtaLoadRevForSectorList(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchQtaLoadRevForSectorList(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SQM_0222 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorListVO> searchQtaLoadRevForAddSectorList(ConditionVO conditionVO) throws EventException{
		try {
			return dbDao.searchQtaLoadRevForAddSectorList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0213 : Raw Data Export 이벤트 처리<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchRawDataOfQtaLoadRevForSectorList(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.searchRawDataOfQtaLoadRevForSectorList(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0213 : Freezing 및 Add-Freezing 클릭시 발생<br>
	 * Freezing 및 Add-Freezing 시도시 Load가 0이 아닌데 G.RPB가 0인 데이터를 찾아냄
	 * 
	 * @param ConditionVO conditionVO
	 * @param String freezingFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchProblematicDataInFreezing(ConditionVO conditionVO, String freezingFlg) throws EventException {
		try {
			return dbDao.searchProblematicDataInFreezing(conditionVO, freezingFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0213 : [Retrieve]<br>
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
	 * ESM_SQM_0213 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSector(ConditionVO conditionVO,  SignOnUserAccount account) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
//		String batchRunningStatus = "0";
		String pgmNm  = "ESM_SQM_B006";
		StringBuffer params = new StringBuffer();
		try {
			//Basic data 중 누락된것 조회 (Office View, 노선, Bound, SKD Ver이 다 생성되어있는지)
			dbDao.searchMissingBasicDataList(conditionVO, "N", "N");
			
//			dbDao.createQtaLoadRevForSector(conditionVO, account); //타임아웃으로 인해 배치로 변경
			params.append(conditionVO.getFBseTpCd());
			params.append("#");
			params.append(conditionVO.getFBseYr());
			params.append("#");
			params.append(conditionVO.getFBseQtrCd());
			params.append("#");
			params.append(account.getUsr_id());
			String param = params.toString();
			
			su.directExecuteJob(pgmNm, param);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_SQM_0213 : [Freezing]<br>
	 * [확정] 데이터를 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaFreezingForSector(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
//		String batchRunningStatus = "0";
		String pgmNm  = "ESM_SQM_B005";
		StringBuffer params = new StringBuffer();
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

//			// Target VVD를 입력한다.
//			dbDao.insertCfmTgtVvdForFreezing(conditionVO, updVoList);
//			// 확정데이터를 생성한다.
//			dbDao.createQtaLoadRevForSectorFreezing(conditionVO, account);
//			// Over All 데이터를 업데이트한다.(입력)
//			dbDao.insertCfmQtaSyncForFreezing(conditionVO, updVoList);
			params.append(conditionVO.getFBseTpCd());
			params.append("#");
			params.append(conditionVO.getFBseYr());
			params.append("#");
			params.append(conditionVO.getFBseQtrCd());
			params.append("#");
			params.append(account.getUsr_id());
			String param = params.toString();
			
			su.directExecuteJob(pgmNm, param);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0213 : [1Q Transfer]<br>
	 * [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaTransferForSector(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			conditionVO.setFIasSctrFlg("Y");
			dbDao.createTransferSqmSctrPfGrp(conditionVO, account);
			dbDao.createTransferSqmSctrPairMgmt(conditionVO, account);
			dbDao.createTransferSqmSctrLaneOfc(conditionVO, account);
			dbDao.createTransferSqmSctrPairCost(conditionVO, account);
			dbDao.createTransferSqmSctrPerfIf(conditionVO, account);
			dbDao.createTransferSqmSctrLodRev(conditionVO, account);
//			dbDao2.createTransferSqmQtaTgtVvd(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_SQM_0213 : [Save]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [저장] 합니다.<br>
	 * 
	 * @param SqmSctrLodRevVO[] sqmSctrLodRevVO
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void updateQtaLoadRevForSector(SqmSctrLodRevVO[] sqmSctrLodRevVO, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmSctrLodRevVO> updVoList = new ArrayList<SqmSctrLodRevVO>();
			
			for ( int i=0; i<sqmSctrLodRevVO .length; i++ ) {    
				sqmSctrLodRevVO[i].setBseTpCd(conditionVO.getFBseTpCd()); 
				sqmSctrLodRevVO[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmSctrLodRevVO[i].getIbflag().equals("U")){
					updVoList.add(sqmSctrLodRevVO[i]);
				}
			}
			
			if ( updVoList.size() > 0 ) {
				dbDao.updateQtaLoadRevForSector(updVoList);
			}
			
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	
	/**
	 * ESM_SQM_0222 : [Save]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [저장] 합니다.<br>
	 * 
	 * @param SqmSctrLodRevVO[] sqmSctrLodRevVO
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaLoadRevForAddSector(SqmSctrLodRevVO[] sqmSctrLodRevVO, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmSctrLodRevVO> updVoList = new ArrayList<SqmSctrLodRevVO>();
			
			for ( int i=0; i<sqmSctrLodRevVO .length; i++ ) {  
				sqmSctrLodRevVO[i].setCreUsrId(account.getUsr_id()); 
				sqmSctrLodRevVO[i].setBseYr(conditionVO.getFBseYr());
				sqmSctrLodRevVO[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmSctrLodRevVO[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmSctrLodRevVO[i].setOfcVwCd(conditionVO.getFOfcVwCd().substring(0, 1)); 
				
				if ( sqmSctrLodRevVO[i].getIbflag().equals("U")){
					updVoList.add(sqmSctrLodRevVO[i]);
				}
			}
			
			if ( updVoList.size() > 0 ) {
				dbDao.createQtaLoadRevForAddSector(updVoList);
			}
			
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0214 : [Retrieve]<br>
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
	 * ESM_SQM_0214 : [Creation]<br>
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
	 * ESM_SQM_0215 : [Retrieve]<br>
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
	 * ESM_SQM_0215 : [Creation]<br>
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
	 * ESM_SQM_0216 : [Retrieve]<br>
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