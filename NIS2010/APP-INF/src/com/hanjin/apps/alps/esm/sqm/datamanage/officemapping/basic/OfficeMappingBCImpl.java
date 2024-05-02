/*=========================================================
*Copyright(c) 2013 CyberLogitec 
*@FileName       : OfficeMappingBCImpl.java
*@FileTitle      : OfficeMapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2013.12.10 PEJ  [CHM-201328059] QTA Edit_Office Add 팝업 추가(modifyLaneOfficeRelation)
* 2014.06.12 이혜민 [CHM-201430324] IAS Sector 프로젝트 안정화 및 3분기 판매목표 수립 지원
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2014.07.28 이혜민 [CHM-201431117] Sector Office Relation Set_Add POL POD Pair creation시 SQM_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
* 2015.05.12 김용습 [CHM-201535562] [SQM] Sector-Office Relation Setting for IAS Sector - 타임아웃 방지를 위해 데이터를 반으로 나누어 생성되게 함(createSectorOfcRelationSetForEastBoundData와 createSectorOfcRelationSetForWestBoundData)
* 2015.10.27 김용습 [CHM-201537712] [CSR 전환건] "Sector-Office Relation Setting for IAS Sector 화면 내 Creation"의 로직 변경 
* 2015.12.02 김용습 [CHM-201539212] 연간/분기동안 확정 Data에 한번 들어간 Sector Pair는 active 해제할 수 없도록 로직 수정
* 2016.01.13 [CHM-201539389] Lane Office Inactive 불가하도록 비활성화 로직 변경
* 2016.07.04 최성민 [CHM-201642330] SQM 화면 버튼 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration.OfficeMappingDBDAO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchLaneOfficeRelationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchLaneOfficeRelationNewLaneAddListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneVO;
import com.hanjin.syscommon.common.table.SqmQtaOfcVO;
import com.hanjin.syscommon.common.table.SqmSctrLaneOfcVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-OfficeMapping Business Logic Command Interface<br>
 * - ALPS-OfficeMapping 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see OfficeMappingDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OfficeMappingBCImpl extends BasicCommandSupport implements OfficeMappingBC {
	
	// Database Access Object
	private transient OfficeMappingDBDAO dbDao = null;
	
	/**
	 * BasicDataBCImpl 객체 생성<br>
	 * BasicDataDBDAO를 생성한다.<br>
	 */
	public OfficeMappingBCImpl() {
		dbDao = new OfficeMappingDBDAO();
	}
	
	/**
	 * RHQ별 산하의 판매목표 수립 대상인 모든 Office를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmQtaOfcVO>
	 * @throws EventException
	 */
	public List<SqmQtaOfcVO> searchRhqOfcMappingList(ConditionVO conditionVO) throws EventException{
		try {
			return dbDao.searchRhqOfcMappingList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationListVO>
	 * @exception EventException
	 */
	public List<SearchLaneOfficeRelationListVO> searchLaneOfficeRelationList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchLaneOfficeRelationList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting-Loading View Check Copy]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationListVO>
	 * @exception EventException
	 */
	public List<SearchLaneOfficeRelationListVO> searchLoadingViewCheckList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchLoadingViewCheckList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLaneOfficeRelationListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchLaneOfficeRelationListCnt(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]의 [Freezing 데이터] 가 존재하는지 체크합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchQtaReleaseVersion(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaReleaseVersion(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SQM_0204<br>
	 * Active cell을 uncheck하려고 할 때 타는 로직(이미 해당 pair로 확정 데이터가 생성된 것이 있으면 uncheck될 수 없도록 함)
	 * 
	 * @param SqmQtaLaneOfcVO sqmQtaLaneOfcVO
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchConfirmedDataOfLaneOffice(SqmQtaLaneOfcVO sqmQtaLaneOfcVO, ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchConfirmedDataOfLaneOffice(sqmQtaLaneOfcVO, conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [저장] 합니다.<br>
	 * 
	 * @param SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageLaneOfficeRelation(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<SqmQtaLaneOfcVO> insertVoList  = new ArrayList<SqmQtaLaneOfcVO>();
			List<SqmQtaNewLaneVO> insertVoList2 = new ArrayList<SqmQtaNewLaneVO>();
			List<SqmQtaLaneOfcVO> updateVoList  = new ArrayList<SqmQtaLaneOfcVO>();
			
			String trd_cd   = "";
			String rlane_cd = "";
			String dir_cd   = "";
			
			for (int i=0; i<sqmQtaLaneOfcVOs.length; i++ ) {
				sqmQtaLaneOfcVOs[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaLaneOfcVOs[i].setCreUsrId(account.getUsr_id());
				sqmQtaLaneOfcVOs[i].setUpdUsrId(account.getUsr_id());
				
				if (sqmQtaLaneOfcVOs[i].getIbflag().equals("I")){
					insertVoList.add(sqmQtaLaneOfcVOs[i]);
					
					if (   !trd_cd.equals(sqmQtaLaneOfcVOs[i].getTrdCd())
						|| !rlane_cd.equals(sqmQtaLaneOfcVOs[i].getRlaneCd())
						|| !dir_cd.equals(sqmQtaLaneOfcVOs[i].getDirCd()) ) {
						
						SqmQtaNewLaneVO sqmQtaNewLaneVO = new SqmQtaNewLaneVO();
						
						sqmQtaNewLaneVO.setBseTpCd(conditionVO.getFBseTpCd());
						sqmQtaNewLaneVO.setBseYr(conditionVO.getFBseYr());
						sqmQtaNewLaneVO.setBseQtrCd(conditionVO.getFBseQtrCd());
						sqmQtaNewLaneVO.setTrdCd(sqmQtaLaneOfcVOs[i].getTrdCd());
						sqmQtaNewLaneVO.setRlaneCd(sqmQtaLaneOfcVOs[i].getRlaneCd());
						sqmQtaNewLaneVO.setDirCd(sqmQtaLaneOfcVOs[i].getDirCd());
						sqmQtaNewLaneVO.setCreUsrId(account.getUsr_id());
						sqmQtaNewLaneVO.setUpdUsrId(account.getUsr_id());
						
						insertVoList2.add(sqmQtaNewLaneVO);
					}
					
				} else if (sqmQtaLaneOfcVOs[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaLaneOfcVOs[i]);
				}
				
				trd_cd   = sqmQtaLaneOfcVOs[i].getTrdCd();
				rlane_cd = sqmQtaLaneOfcVOs[i].getRlaneCd();
				dir_cd   = sqmQtaLaneOfcVOs[i].getDirCd();
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateLaneOfficeRelation(updateVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addLaneOfficeRelation(insertVoList);
			}
			
			if ( insertVoList2.size() > 0 ) {
				dbDao.addNewLane(insertVoList2);
			}
		} catch (DAOException de) {
			if (de.getMessage().indexOf("ORA-00001") != -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), de);
			else
				throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0045 : [Creation](adjustment-QTA Edit - IAS Office Add- Creation)<br>
	 * [Lane Office Relation Setting] Office의 상태를 변경한다..<br>
	 * 
	 * @param SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void modifyLaneOfficeRelation(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SqmQtaLaneOfcVO> updateVoList  = new ArrayList<SqmQtaLaneOfcVO>();
			
			for (int i=0; i<sqmQtaLaneOfcVOs.length; i++ ) {
				sqmQtaLaneOfcVOs[i].setCreUsrId(account.getUsr_id());
				sqmQtaLaneOfcVOs[i].setUpdUsrId(account.getUsr_id());
				if (sqmQtaLaneOfcVOs[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaLaneOfcVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateLaneOfficeRelation(updateVoList);
			}
			
		} catch (DAOException de) {
			if (de.getMessage().indexOf("ORA-00001") != -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), de);
			else
				throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void createLaneOfficeRelation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.createLaneOfficeRelation(conditionVO, account.getUsr_id());
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0009 : [이벤트]<br>
	 * [RHQ-Office Mapping Data]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationNewLaneAddListVO>
	 * @exception EventException
	 */
	public List<SearchLaneOfficeRelationNewLaneAddListVO> searchLaneOfficeRelationNewLaneAddList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchLaneOfficeRelationNewLaneAddList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * RHQ별 산하의 판매목표 수립 대상인 Office 정보를 저장한다.
	 * 
	 * @param SqmQtaOfcVO[] sqmQtaOfcVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRhqOfcMapping(SqmQtaOfcVO[] sqmQtaOfcVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaOfcVO> insertVoList = new ArrayList<SqmQtaOfcVO>();
			List<SqmQtaOfcVO> deleteVoList = new ArrayList<SqmQtaOfcVO>();
			for ( int i=0; i<sqmQtaOfcVOS .length; i++ ) {
				if ( sqmQtaOfcVOS[i].getIbflag().equals("I")){
					sqmQtaOfcVOS[i].setCreUsrId(account.getUsr_id());
					sqmQtaOfcVOS[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(sqmQtaOfcVOS[i]);
				} else if ( sqmQtaOfcVOS[i].getIbflag().equals("D")){
					sqmQtaOfcVOS[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(sqmQtaOfcVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addRhqOfcMapping(insertVoList);
				
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeRhqOfcMapping(deleteVoList);
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
	 * ESM_SQM_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSectorOfcRelationSetListVO>
	 * @exception EventException
	 */
	public List<SearchSectorOfcRelationSetListVO> searchSectorOfcRelationSetList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSectorOfcRelationSetList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0204<br>
	 * Active cell을 uncheck하려고 할 때 타는 로직(이미 해당 pair로 확정 데이터가 생성된 것이 있으면 uncheck될 수 없도록 함)
	 * 
	 * @param SqmSctrLaneOfcVO sqmSctrLaneOfcVO
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchConfirmedDataOfPair(SqmSctrLaneOfcVO sqmSctrLaneOfcVO, ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchConfirmedDataOfPair(sqmSctrLaneOfcVO, conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List]을 [Data Count]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSectorOfcRelationSetListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSectorOfcRelationSetListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0204 : Retrieve<br>
	 * [Sector Office Relation Setting Tab2]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @exception EventException
	 */
	public List<SearchSectorOfcRelationSetListVO> searchSectorOfcRelationSetListT2(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSectorOfcRelationSetListT2(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0204 : Creation<br>
	 * [Sector Office Relation Setting_Act_flag가 하나도 없는 Lane List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSectorOfcRelationSetNActList(ConditionVO conditionVO) throws EventException {
		try {
			List<String> nActList = dbDao.searchSectorOfcRelationSetNActList(conditionVO);
			return nActList;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0204 : SAVE<br>
	 * [POL POD Pair for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param SqmSctrLaneOfcVO[] sqmSctrLaneOfcVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageSectorOfcRelationSet(SqmSctrLaneOfcVO[] sqmSctrLaneOfcVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmSctrLaneOfcVO> updateVoList = new ArrayList<SqmSctrLaneOfcVO>();
			for ( int i=0; i<sqmSctrLaneOfcVOS .length; i++ ) {
				sqmSctrLaneOfcVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmSctrLaneOfcVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmSctrLaneOfcVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmSctrLaneOfcVOS[i].setCreUsrId(account.getUsr_id());
				sqmSctrLaneOfcVOS[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(sqmSctrLaneOfcVOS[i]);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateSectorOfcRelationSet(updateVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddSectorOfcRelSetVO>
	 * @exception EventException
	 */
	public List<SearchAddSectorOfcRelSetVO> searchAddSectorOfcRelSetPfGrp(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchAddSectorOfcRelSetPfGrp(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List의 Act Cnt]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAddSectorOfcRelSetPfGrpActCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchAddSectorOfcRelSetPfGrpActCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0205 : CREATION<br>
	 * [Sector Office Relation Set_Add Creation List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddSectorOfcRelSetPfGrp(SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchAddSectorOfcRelSetVO> insertVoList = new ArrayList<SearchAddSectorOfcRelSetVO>();
			
			//Add-Creation
			for ( int j=0; j<searchAddSectorOfcRelSetVOS.length; j++ ) {
				if("0".equals(Integer.toString(j))){
					searchAddSectorOfcRelSetVOS[j].setBseTpCd(conditionVO.getFBseTpCd());
					searchAddSectorOfcRelSetVOS[j].setBseYr(conditionVO.getFBseYr());
					searchAddSectorOfcRelSetVOS[j].setBseQtrCd(conditionVO.getFBseQtrCd());
					searchAddSectorOfcRelSetVOS[j].setSubTrdCd(conditionVO.getFSubTrdCd());
					searchAddSectorOfcRelSetVOS[j].setOfcVwCd(conditionVO.getFOfcVwCd());
					searchAddSectorOfcRelSetVOS[j].setCreUsrId(account.getUsr_id());
					searchAddSectorOfcRelSetVOS[j].setUpdUsrId(account.getUsr_id());
					insertVoList.add(searchAddSectorOfcRelSetVOS[j]);
				}else{
					//같은 PF GROUP이 들어왔을경우 한번만 INSERT
					if(!searchAddSectorOfcRelSetVOS[j].getPfGrpCd().equals(searchAddSectorOfcRelSetVOS[j-1].getPfGrpCd())){
						searchAddSectorOfcRelSetVOS[j].setBseTpCd(conditionVO.getFBseTpCd());
						searchAddSectorOfcRelSetVOS[j].setBseYr(conditionVO.getFBseYr());
						searchAddSectorOfcRelSetVOS[j].setBseQtrCd(conditionVO.getFBseQtrCd());
						searchAddSectorOfcRelSetVOS[j].setSubTrdCd(conditionVO.getFSubTrdCd());
						searchAddSectorOfcRelSetVOS[j].setOfcVwCd(conditionVO.getFOfcVwCd());
						searchAddSectorOfcRelSetVOS[j].setCreUsrId(account.getUsr_id());
						searchAddSectorOfcRelSetVOS[j].setUpdUsrId(account.getUsr_id());
						insertVoList.add(searchAddSectorOfcRelSetVOS[j]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.createAddSectorOfcRelSetPfGrp(insertVoList);
			}
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0206 : Retrieve<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddSectorOfcRelSetVO>
	 * @exception EventException
	 */
	public List<SearchAddSectorOfcRelSetVO> searchAddSectorOfcRelSetPolPod(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchAddSectorOfcRelSetPolPod(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddSectorOfcRelSetPolPod(SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			//PAIR 추가시 Office view 조건을 삭제 했으므로 creation시 SQM_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
			dbDao.searchMissingOfficeView(conditionVO);
			
			List<SearchAddSectorOfcRelSetVO> insertVoList = new ArrayList<SearchAddSectorOfcRelSetVO>();
			List<SearchAddSectorOfcRelSetVO> updateVoList = new ArrayList<SearchAddSectorOfcRelSetVO>();

			//Add-Creation
			for ( int j=0; j<searchAddSectorOfcRelSetVOS.length; j++ ) {
				searchAddSectorOfcRelSetVOS[j].setBseTpCd(conditionVO.getFBseTpCd());
				searchAddSectorOfcRelSetVOS[j].setBseYr(conditionVO.getFBseYr());
				searchAddSectorOfcRelSetVOS[j].setBseQtrCd(conditionVO.getFBseQtrCd());
				searchAddSectorOfcRelSetVOS[j].setSubTrdCd(conditionVO.getFSubTrdCd());
				searchAddSectorOfcRelSetVOS[j].setOfcVwCd(conditionVO.getFOfcVwCd());
				searchAddSectorOfcRelSetVOS[j].setCreUsrId(account.getUsr_id());
				searchAddSectorOfcRelSetVOS[j].setUpdUsrId(account.getUsr_id());
				insertVoList.add(searchAddSectorOfcRelSetVOS[j]);
				updateVoList.add(searchAddSectorOfcRelSetVOS[j]);
			}
			//POL-POD PAIR + LANE OFC -> SCTR_LANE_OFC
			if ( insertVoList.size() > 0 ) {
				dbDao.createAddSectorOfcRelSetPolPod(insertVoList);
			}
			//POL-POD PAIR FLAG 'Y'로 UPDATE
			if ( updateVoList.size() > 0 ) {
				dbDao.updateAddSectorOfcRelSetPolPodFlg(updateVoList);
			}
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	
	/**
	 * ESM_SQM_0204 : [이벤트]<br>
	 * [Sector-Office Relation Setting for IAS Sector]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createSectorOfcRelationSet(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		String batchRunningStatus = "0";
		String pgmNm  = "ESM_SQM_B004";
		StringBuffer params = new StringBuffer();
		
		try {
			
			params.append(conditionVO.getFBseTpCd());
			params.append("#");
			params.append(conditionVO.getFBseYr());
			params.append("#");
			params.append(conditionVO.getFBseQtrCd());
			params.append("#");
			params.append(account.getUsr_id());
			String param = params.toString();
			
			su.directExecuteJob(pgmNm, param);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return batchRunningStatus;
	}
}