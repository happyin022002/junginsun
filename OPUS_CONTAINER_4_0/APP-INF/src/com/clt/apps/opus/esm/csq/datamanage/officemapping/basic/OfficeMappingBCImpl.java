/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : OfficeMappingBCImpl.java
*@FileTitle      : OfficeMapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
* 2013.12.10 PEJ   [CHM-201328059] QTA Edit_Office Add 팝업 추가(modifyLaneOfficeRelation)
* 2014.06.12 이혜민 [CHM-201430324] IAS Sector 프로젝트 안정화 및 3분기 판매목표 수립 지원
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2014.07.28 이혜민 [CHM-201431117] Sector Office Relation Set_Add POL POD Pair creation시 CSQ_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.integration.OfficeMappingDBDAO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchLaneOfficeRelationListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchLaneOfficeRelationNewLaneAddListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaLaneOfcVO;
import com.clt.syscommon.common.table.CsqQtaNewLaneVO;
import com.clt.syscommon.common.table.CsqQtaOfcVO;
import com.clt.syscommon.common.table.CsqSctrLaneOfcVO;

/**
 * ALPS-OfficeMapping Business Logic Command Interface<br>
 * - ALPS-OfficeMapping 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
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
	 * @return List<CsqQtaOfcVO>
	 * @throws EventException
	 */
	public List<CsqQtaOfcVO> searchRhqOfcMappingList(ConditionVO conditionVO) throws EventException{
		try {
			return dbDao.searchRhqOfcMappingList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
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
	 * ESM_CSQ_0006 : [이벤트]<br>
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
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [저장] 합니다.<br>
	 * 
	 * @param CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageLaneOfficeRelation(CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<CsqQtaLaneOfcVO> insertVoList  = new ArrayList<CsqQtaLaneOfcVO>();
			List<CsqQtaNewLaneVO> insertVoList2 = new ArrayList<CsqQtaNewLaneVO>();
			List<CsqQtaLaneOfcVO> updateVoList  = new ArrayList<CsqQtaLaneOfcVO>();
			
			String trd_cd   = "";
			String rlane_cd = "";
			String dir_cd   = "";
			
			for (int i=0; i<csqQtaLaneOfcVOs.length; i++ ) {
				csqQtaLaneOfcVOs[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaLaneOfcVOs[i].setCreUsrId(account.getUsr_id());
				csqQtaLaneOfcVOs[i].setUpdUsrId(account.getUsr_id());
				
				if (csqQtaLaneOfcVOs[i].getIbflag().equals("I")){
					insertVoList.add(csqQtaLaneOfcVOs[i]);
					
					if (   !trd_cd.equals(csqQtaLaneOfcVOs[i].getTrdCd())
						|| !rlane_cd.equals(csqQtaLaneOfcVOs[i].getRlaneCd())
						|| !dir_cd.equals(csqQtaLaneOfcVOs[i].getDirCd()) ) {
						
						CsqQtaNewLaneVO csqQtaNewLaneVO = new CsqQtaNewLaneVO();
						
						csqQtaNewLaneVO.setBseTpCd(conditionVO.getFBseTpCd());
						csqQtaNewLaneVO.setBseYr(conditionVO.getFBseYr());
						csqQtaNewLaneVO.setBseQtrCd(conditionVO.getFBseQtrCd());
						csqQtaNewLaneVO.setTrdCd(csqQtaLaneOfcVOs[i].getTrdCd());
						csqQtaNewLaneVO.setRlaneCd(csqQtaLaneOfcVOs[i].getRlaneCd());
						csqQtaNewLaneVO.setDirCd(csqQtaLaneOfcVOs[i].getDirCd());
						csqQtaNewLaneVO.setCreUsrId(account.getUsr_id());
						csqQtaNewLaneVO.setUpdUsrId(account.getUsr_id());
						
						insertVoList2.add(csqQtaNewLaneVO);
					}
					
				} else if (csqQtaLaneOfcVOs[i].getIbflag().equals("U")){
					updateVoList.add(csqQtaLaneOfcVOs[i]);
				}
				
				trd_cd   = csqQtaLaneOfcVOs[i].getTrdCd();
				rlane_cd = csqQtaLaneOfcVOs[i].getRlaneCd();
				dir_cd   = csqQtaLaneOfcVOs[i].getDirCd();
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
				throw new EventException(new ErrorHandler("CSQ00001").getMessage(), de);
			else
				throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_CSQ_0056 : [Creation](adjustment-QTA Edit - IAS Office Add- Creation)<br>
	 * [Lane Office Relation Setting] Office의 상태를 변경한다..<br>
	 * 
	 * @param CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void modifyLaneOfficeRelation(CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CsqQtaLaneOfcVO> updateVoList  = new ArrayList<CsqQtaLaneOfcVO>();
			
			for (int i=0; i<csqQtaLaneOfcVOs.length; i++ ) {
				csqQtaLaneOfcVOs[i].setCreUsrId(account.getUsr_id());
				csqQtaLaneOfcVOs[i].setUpdUsrId(account.getUsr_id());
				if (csqQtaLaneOfcVOs[i].getIbflag().equals("U")){
					updateVoList.add(csqQtaLaneOfcVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateLaneOfficeRelation(updateVoList);
			}
			
		} catch (DAOException de) {
			if (de.getMessage().indexOf("ORA-00001") != -1)
				throw new EventException(new ErrorHandler("CSQ00001").getMessage(), de);
			else
				throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
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
	 * ESM_CSQ_0007 : [이벤트]<br>
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
	 * @param CsqQtaOfcVO[] csqQtaOfcVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRhqOfcMapping(CsqQtaOfcVO[] csqQtaOfcVOS, SignOnUserAccount account) throws EventException{
		try {
			List<CsqQtaOfcVO> insertVoList = new ArrayList<CsqQtaOfcVO>();
			List<CsqQtaOfcVO> deleteVoList = new ArrayList<CsqQtaOfcVO>();
			List<CsqQtaOfcVO> updateVoList = new ArrayList<CsqQtaOfcVO>();
			for ( int i=0; i<csqQtaOfcVOS .length; i++ ) {
				if ( csqQtaOfcVOS[i].getIbflag().equals("I")){
					csqQtaOfcVOS[i].setCreUsrId(account.getUsr_id());
					csqQtaOfcVOS[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(csqQtaOfcVOS[i]);
				} else if ( csqQtaOfcVOS[i].getIbflag().equals("D")){
					csqQtaOfcVOS[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(csqQtaOfcVOS[i]);
				} else if ( csqQtaOfcVOS[i].getIbflag().equals("U")){
					csqQtaOfcVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(csqQtaOfcVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addRhqOfcMapping(insertVoList);
				
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeRhqOfcMapping(deleteVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.reactivateRhqOfcMapping(updateVoList);
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
	 * ESM_CSQ_0204 : Retrieve<br>
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
	 * ESM_CSQ_0204 : Retrieve<br>
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
	 * ESM_CSQ_0204 : Retrieve<br>
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
	 * ESM_CSQ_0204 : Creation<br>
	 * [Sector Office Relation Setting List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createSectorOfcRelationSet(ConditionVO conditionVO, String usrId) throws EventException{
		OfficeMappingBackEndJob backEndJob = new OfficeMappingBackEndJob();
		conditionVO.setFUsrId(usrId);
		conditionVO.setFGubun("SectorOffice");
		backEndJob.setConditionVO(conditionVO);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			return backEndJobManager.execute(backEndJob, usrId, "SectorOffice Creation");	
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0204 : Creation<br>
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
	 * ESM_CSQ_0204 : SAVE<br>
	 * [POL POD Pair for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param CsqSctrLaneOfcVO[] csqSctrLaneOfcVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageSectorOfcRelationSet(CsqSctrLaneOfcVO[] csqSctrLaneOfcVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CsqSctrLaneOfcVO> updateVoList = new ArrayList<CsqSctrLaneOfcVO>();
			for ( int i=0; i<csqSctrLaneOfcVOS .length; i++ ) {
				csqSctrLaneOfcVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqSctrLaneOfcVOS[i].setBseYr(conditionVO.getFBseYr());
				csqSctrLaneOfcVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				csqSctrLaneOfcVOS[i].setCreUsrId(account.getUsr_id());
				csqSctrLaneOfcVOS[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(csqSctrLaneOfcVOS[i]);
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
	 * ESM_CSQ_0205 : Retrieve<br>
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
	 * ESM_CSQ_0205 : Retrieve<br>
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
	 * ESM_CSQ_0205 : CREATION<br>
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
	 * ESM_CSQ_0206 : Retrieve<br>
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
	 * ESM_CSQ_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddSectorOfcRelSetPolPod(SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			//PAIR 추가시 Office view 조건을 삭제 했으므로 creation시 CSQ_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
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
}