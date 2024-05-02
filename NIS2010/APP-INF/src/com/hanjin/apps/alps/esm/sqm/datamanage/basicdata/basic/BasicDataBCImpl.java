/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : BasicDataBCImpl.java
*@FileTitle      : BasicData
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2014.01.10 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2014.07.28 이혜민 [CHM-201431109] POL POD Pair for IAS Sector화면 내 Add-creation시 Pair Cost가 생성되어 있으면 Add-creation하는 Pair도 cost 생성.
* 2014.08.14 이혜민 [CHM-201431421] Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회
* 2016.04.20 CHM-201640366 Target VVD Fix 월기준 항차 생성 등 개선 CSR
* 2016.05.11 Sector Office Relation Setting for IAS Sector 화면 및 P/F Skd Group 화면 로직 수정 요청
-P/F Skd Group Management for IAS Sector : Target VVD Fix 에서 대상항차 Fix 할 때부터 P/F Group 도 Planning에서 Freezing 될 때까지는 Add Creation 불가하도록 로직 수정 (Target VVD Fix ~ Planning의 Freezing동안)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration.BasicDataDBDAO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataCreationForSecterListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchAddPolPodPairForSectorVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataCreationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataRelationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchLaneBoundCheckListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchLaneDirectionChangeListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchPfSkdGrpForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchPolPodPairSectorListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchTargerVvdFixListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration.OfficeMappingDBDAO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmDatRltVO;
import com.hanjin.syscommon.common.table.SqmDirConvVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneMgmtVO;
import com.hanjin.syscommon.common.table.SqmQtaTgtVvdVO;
import com.hanjin.syscommon.common.table.SqmSctrPairMgmtVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-BasicData Business Logic Command Interface<br>
 * - ALPS-BasicData 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see BasicDataDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BasicDataBCImpl extends BasicCommandSupport implements BasicDataBC {
	
	// Database Access Object
	private transient BasicDataDBDAO dbDao = null;
	private transient OfficeMappingDBDAO ofcDbDao = null;
	
	/**
	 * BasicDataBCImpl 객체 생성<br>
	 * BasicDataDBDAO를 생성한다.<br>
	 */
	public BasicDataBCImpl() {
		dbDao = new BasicDataDBDAO();
		ofcDbDao = new OfficeMappingDBDAO();
	}
	
	/**
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataRelationVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataRelationListVO> searchBasicDataRelationList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicDataRelationList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [저장, 삭제] 합니다.<br>
	 * 
	 * @param SqmDatRltVO[] sqmDatRltVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageBasicDataRelation(SqmDatRltVO[] sqmDatRltVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<SqmDatRltVO> insertVoList = new ArrayList<SqmDatRltVO>();
			List<SqmDatRltVO> deleteVoList = new ArrayList<SqmDatRltVO>();
			
			for (int i=0; i<sqmDatRltVOs.length; i++ ) {
				sqmDatRltVOs[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmDatRltVOs[i].setBseYr(conditionVO.getFBseYr());
				sqmDatRltVOs[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmDatRltVOs[i].setCreUsrId(account.getUsr_id());
				sqmDatRltVOs[i].setUpdUsrId(account.getUsr_id());
				
				if (sqmDatRltVOs[i].getIbflag().equals("I")){
					insertVoList.add(sqmDatRltVOs[i]);
				} else if (sqmDatRltVOs[i].getIbflag().equals("D")){
					deleteVoList.add(sqmDatRltVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addBasicDataRelation(insertVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeBasicDataRelation(deleteVoList);
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
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void copyBasicDataRelation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.copyBasicDataRelation(conditionVO, account.getUsr_id());
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}   
	}
	
	/**
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicDataRelationListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicDataRelationListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Reverse Sailing 노선들의 Direction 을 조회.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneDirectionChangeListVO>
	 * @throws EventException
	 */
	public List<SearchLaneDirectionChangeListVO> searchLaneDirectionChangeList(ConditionVO conditionVO) throws EventException{
		try {
			return dbDao.searchLaneDirectionChangeList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Reverse Sailing 노선들의 변경된 Direction 을 추가 또는 삭제
	 * 
	 * @param SqmDirConvVO[] sqmDirConvVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageLaneDirectionChange(SqmDirConvVO[] sqmDirConvVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmDirConvVO> insertVoList = new ArrayList<SqmDirConvVO>();
			List<SqmDirConvVO> deleteVoList = new ArrayList<SqmDirConvVO>();
			for ( int i=0; i<sqmDirConvVOS .length; i++ ) {
				sqmDirConvVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmDirConvVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmDirConvVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				if ( sqmDirConvVOS[i].getIbflag().equals("I")){
					sqmDirConvVOS[i].setCreUsrId(account.getUsr_id());
					sqmDirConvVOS[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(sqmDirConvVOS[i]);
				} else if ( sqmDirConvVOS[i].getIbflag().equals("D")){
					deleteVoList.add(sqmDirConvVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addLaneDirectionChange(insertVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLaneDirectionChange(deleteVoList);
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
	 * 최근 이전 분기의 데이터를 복사
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void copyLaneDirectionChange(ConditionVO conditionVO, String usrId) throws EventException{
		try {
			//최근 이전 분기의 데이터를 복사
			dbDao.copyLaneDirectionChange(conditionVO, usrId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Reverse Sailing 노선들의 Direction 조회 리스트를 count
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchLaneDirectionChangeListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchLaneDirectionChangeListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0003 : [이벤트]<br>
	 * [Basic Data Creation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataCreationListVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataCreationListVO> searchBasicDataCreationList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicDataCreationList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD Fix]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchTargerVvdFixList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTargerVvdFixList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD Fix]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String flg
	 * @param String usrId
	 * @exception EventException
	 */
	public void createTargerVvdFix(ConditionVO conditionVO, String flg, String usrId) throws EventException{
		try {
			
			if(("Q".equals(conditionVO.getFBseTpCd()) && "N".equals(flg))){
				//Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회한다.
				dbDao.searchDiffPfVerByMas(conditionVO);
				//PF SKD VER 다른것이 없으면 Target VVD 생성
				dbDao.createTargerVvdFixByMas(conditionVO, usrId);
			}else{
				//Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회한다.
				dbDao.searchDiffPfVerByVbpIf(conditionVO);
				//PF SKD VER 다른것이 없으면 Target VVD 생성
				dbDao.createTargerVvdFixByVbpIf(conditionVO, usrId);
			}	
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0006 : [이벤트]<br>
	 * [Lane List]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchLaneList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchLaneList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD Fix]을 [저장] 합니다.<br>
	 * 
	 * @param SqmQtaTgtVvdVO[] sqmQtaTgtVvdVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTargerVvdFix(SqmQtaTgtVvdVO[] sqmQtaTgtVvdVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaTgtVvdVO> updateVoList = new ArrayList<SqmQtaTgtVvdVO>();
			List<SqmQtaTgtVvdVO> addVoList = new ArrayList<SqmQtaTgtVvdVO>();
			for ( int i=0; i<sqmQtaTgtVvdVOS .length; i++ ) {
				if( conditionVO.getIbflag().equals("U")){
					sqmQtaTgtVvdVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
					sqmQtaTgtVvdVOS[i].setBseYr(conditionVO.getFBseYr());
					sqmQtaTgtVvdVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
					sqmQtaTgtVvdVOS[i].setCreUsrId(account.getUsr_id());
					sqmQtaTgtVvdVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(sqmQtaTgtVvdVOS[i]);
				} else if( conditionVO.getIbflag().equals("I")){
					sqmQtaTgtVvdVOS[i].setBseTpCd(conditionVO.getFBseTpCd()); 
					sqmQtaTgtVvdVOS[i].setBseYr(conditionVO.getFBseYr());
					sqmQtaTgtVvdVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
					sqmQtaTgtVvdVOS[i].setCreUsrId(account.getUsr_id());
					sqmQtaTgtVvdVOS[i].setUpdUsrId(account.getUsr_id());
					addVoList.add(sqmQtaTgtVvdVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateTargerVvdFix(updateVoList);
			}
			if ( addVoList.size() > 0 ) {
				dbDao.insertTargerVvdFix(addVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchTargerVvdFixListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTargerVvdFixListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	

	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD]의 접속 ofc를 확인 합니다.<br>
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchCreationUser(String ofcCd) throws EventException {
		try {
			return dbDao.searchCreationUser(ofcCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SQM_0004 : [이벤트]<br>
	 * [Basic Data Creation]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createSqmPerfIf(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		String batchRunningStatus = "0";
		String pgmNm  = "ESM_SQM_B001";
//		String params = "";
		StringBuffer params = new StringBuffer();
//		String msg    = "";
		StringBuffer msg = new StringBuffer();
		String str    = "";
		
		try {
			
			List<SearchLaneBoundCheckListVO> list = dbDao.searchLaneBoundCheckList(conditionVO);
			
			if ( list.size() > 1 ) {
				for ( int i=0; i < list.size(); i++ ) {
					if ( !list.get(i).getOfcVwCd().equals(str) ) {
						str = list.get(i).getOfcVwCd();
						if(str.equals("C")){
							msg.append("▶ Contract view");
						}else{
							msg.append("▶ Loading view");
						}
						msg.append("\n");
						//msg = msg + (list.get(i).getOfcVwCd().equals("C")?"▶ Contract view":"▶ Loading view") + "\n";
					}
					
					msg.append(list.get(i).getTrdCd());
					msg.append("-");
					msg.append(list.get(i).getRlaneCd());
					msg.append("-");					
					msg.append(list.get(i).getDirCd());
					msg.append("\n");
					
//					msg = msg + list.get(i).getTrdCd()
//					    + "-" + list.get(i).getRlaneCd()
//					    + "-" + list.get(i).getDirCd()
//					    + "\n";
					
				}
				
				throw new EventException(new ErrorHandler("SQM00006", new String[]{msg.toString()}).getMessage());
			} else if ( !"0".equals(ofcDbDao.searchLaneOfficeRelationListCnt(conditionVO)) ) {	// 사전 Data 존재 여부 확인
				
				// 실행 전 해당 Batch 모듈이 실행 중인지 확인한다.
				if ( !su.isRunning(pgmNm) ) {
					
					// 기 생성된 Data 존재 여부 확인  
					if ( dbDao.searchBasicDataCreationListCnt(conditionVO, "N").equals("0") ) {
						params.append(conditionVO.getFFmWk());
						params.append("#");
						params.append(conditionVO.getFToWk());
						params.append("#");
						params.append(conditionVO.getFBseTpCd());
						params.append("#");
						params.append(conditionVO.getFBseYr());
						params.append("#");
						params.append(conditionVO.getFBseQtrCd());
						params.append("#");
						params.append(conditionVO.getFDuration());
						params.append("#");
						params.append(account.getUsr_id());
//						params =       conditionVO.getFFmWk()
//						       + "#" + conditionVO.getFToWk()
//						       + "#" + conditionVO.getFBseTpCd()
//						       + "#" + conditionVO.getFBseYr()
//						       + "#" + conditionVO.getFBseQtrCd()
//						       + "#" + conditionVO.getFDuration()
//						       + "#" + account.getUsr_id();
						String param = params.toString();
						su.directExecuteJob(pgmNm, param);
						batchRunningStatus = "3";		// STARTING 시작(시스템)
					} else {
						batchRunningStatus = "13";		// Data 존재
					}
				}else{
					batchRunningStatus = "1";		// RUNNING 수행중
					throw new EventException(new ErrorHandler("SQM00004", new String[]{}).getMessage());
				}
			} else {
				batchRunningStatus = "14";		// 사전 Data 미 존재
			}
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"SQM PERF IF - Creation"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return batchRunningStatus;
	}
	
	/**
	 * ESM_SQM_0003 : [이벤트]<br>
	 * [Basic Data Creation]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicDataCreationListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicDataCreationListCnt(conditionVO, "Y");
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0038 : [이벤트]<br>
	 * [Lane Master]을 [조회] 합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SqmQtaLaneMgmtVO>
	 * @throws EventException
	 */
	public List<SqmQtaLaneMgmtVO> searchLaneMasterList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchLaneMasterList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0038 : [이벤트]<br>
	 * [Lane Master]을 [저장,삭제] 합니다.<br>
	 * @param SqmQtaLaneMgmtVO[] sqmQtaLaneMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageLaneMaster(SqmQtaLaneMgmtVO[] sqmQtaLaneMgmtVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaLaneMgmtVO> insertVoList = new ArrayList<SqmQtaLaneMgmtVO>();
			List<SqmQtaLaneMgmtVO> deleteVoList = new ArrayList<SqmQtaLaneMgmtVO>();
			List<SqmQtaLaneMgmtVO> updateVoList = new ArrayList<SqmQtaLaneMgmtVO>();
			
			for ( int i=0; i<sqmQtaLaneMgmtVOS .length; i++ ) {        
				sqmQtaLaneMgmtVOS[i].setCreUsrId(account.getUsr_id());
				sqmQtaLaneMgmtVOS[i].setUpdUsrId(account.getUsr_id()); 
				if ( !sqmQtaLaneMgmtVOS[i].getTrdCd().equals("IAS")) {
					sqmQtaLaneMgmtVOS[i].setIasSctrFlg(null);
				}
				if ( sqmQtaLaneMgmtVOS[i].getIbflag().equals("I")){
					insertVoList.add(sqmQtaLaneMgmtVOS[i]);
				} else if ( sqmQtaLaneMgmtVOS[i].getIbflag().equals("D")){
					deleteVoList.add(sqmQtaLaneMgmtVOS[i]);
				} else if ( sqmQtaLaneMgmtVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaLaneMgmtVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addLaneMaster(insertVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLaneMaster(deleteVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateLaneMaster(updateVoList);
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
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD Fix]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String flg
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchTargerVvdFixForCreation(ConditionVO conditionVO, String flg) throws EventException {
		try {
			if(("Q".equals(conditionVO.getFBseTpCd()) && "N".equals(flg)))
				return dbDao.searchTargerVvdFixByMas(conditionVO);
			else
				return dbDao.searchTargerVvdFixByVbpIf(conditionVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPfSkdGrpForSectorListVO>
	 * @exception EventException
	 */
	public List<SearchPfSkdGrpForSectorListVO> searchPfSkdGrpForSectorList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchPfSkdGrpForSectorList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [Data Count]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPfSkdGrpForSectorListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchPfSkdGrpForSectorListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0201 : Add Creation<br>
	 * Add Creation시 유효성 검사
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchValidationAddPfSkdGrpForSector(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchValidationAddPfSkdGrpForSector(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0201 : Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createPfSkdGrpForSector(ConditionVO conditionVO, String usrId) throws EventException{
		BasicDataBackEndJob backEndJob = new BasicDataBackEndJob();
		conditionVO.setFUsrId(usrId);
		conditionVO.setFGubun("PfCreation");
		backEndJob.setConditionVO(conditionVO);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			return backEndJobManager.execute(backEndJob, usrId, "PF Creation");	
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBackEndJobVO(String key) throws EventException {
		DBRowSet rowSet;
		String[] rtnArr = new String[2];
		
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			rtnArr[0] = (String) rowSet.getObject("jb_sts_flg");
			rtnArr[1] = (String) rowSet.getObject("jb_usr_err_msg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
		return rtnArr;
	}
	
	/**
	 * ESM_SQM_0201 : Add-Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [추가생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void createAddPfSkdGrpForSector(ConditionVO conditionVO, String usrId) throws EventException{
		try {
			
			if("Q".equals(conditionVO.getFBseTpCd()))
				dbDao.createAddPfSkdGrpForSectorQta(conditionVO, usrId);
			else
				dbDao.createAddPfSkdGrpForSectorYr(conditionVO, usrId);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @exception EventException
	 */
	public List<SearchPolPodPairSectorListVO> searchPolPodPairSectorList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchPolPodPairSectorList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List]을 [Data Count]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPolPodPairSectorListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchPolPodPairSectorListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List Tab2]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @exception EventException
	 */
	public List<SearchPolPodPairSectorListVO> searchPolPodPairSectorListT2(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchPolPodPairSectorListT2(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0202 : Creation 또는 Retrieve 후<br>
	 * [POL POD Pair for IAS Sector List 중 Main Flag가 하나도 없는 Lane, Bound]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchPolPodPairNMainFlgList(ConditionVO conditionVO) throws EventException {
		try {
			List<String> nMainList =  dbDao.searchPolPodPairNMainFlgList(conditionVO);
			return nMainList;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0202 : Creation<br>
	 * [POL POD Pair for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String 
	 * @exception EventException
	 */
	public String createPolPodPairForSector(ConditionVO conditionVO, String usrId) throws EventException{
		BasicDataBackEndJob backEndJob = new BasicDataBackEndJob();
		conditionVO.setFUsrId(usrId);
		conditionVO.setFGubun("PolPodCreation");
		backEndJob.setConditionVO(conditionVO);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			return backEndJobManager.execute(backEndJob, usrId, "PolPod Creation");	
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0202 : SAVE<br>
	 * [POL POD Pair for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param SqmSctrPairMgmtVO[] sqmSctrPairMgmtVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePolPodPairForSector(SqmSctrPairMgmtVO[] sqmSctrPairMgmtVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmSctrPairMgmtVO> updateVoList = new ArrayList<SqmSctrPairMgmtVO>();
			for ( int i=0; i<sqmSctrPairMgmtVOS .length; i++ ) {
				sqmSctrPairMgmtVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmSctrPairMgmtVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmSctrPairMgmtVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmSctrPairMgmtVOS[i].setCreUsrId(account.getUsr_id());
				sqmSctrPairMgmtVOS[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(sqmSctrPairMgmtVOS[i]);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updatePolPodPairForSector(updateVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0203 : Retrieve<br>
	 * [POL POD Pair for IAS Sector Add List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @exception EventException
	 */
	public List<SearchAddPolPodPairForSectorVO> searchAddPolPodPairForSector(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchAddPolPodPairForSector(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddPolPodPairForSectorVO[] searchAddPolPodPairForSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddPolPodPairForSector(SearchAddPolPodPairForSectorVO[] searchAddPolPodPairForSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchAddPolPodPairForSectorVO> insertVoList = new ArrayList<SearchAddPolPodPairForSectorVO>();
			List<SearchAddPolPodPairForSectorVO> newLaneVoList = new ArrayList<SearchAddPolPodPairForSectorVO>();
			List<SearchAddPolPodPairForSectorVO> pairCostVoList = new ArrayList<SearchAddPolPodPairForSectorVO>();
			//Add-Creation
			for ( int j=0; j<searchAddPolPodPairForSectorVOS.length; j++ ) {
				if("0".equals(Integer.toString(j))){
					searchAddPolPodPairForSectorVOS[j].setBseTpCd(conditionVO.getFBseTpCd());
					searchAddPolPodPairForSectorVOS[j].setBseYr(conditionVO.getFBseYr());
					searchAddPolPodPairForSectorVOS[j].setBseQtrCd(conditionVO.getFBseQtrCd());
					searchAddPolPodPairForSectorVOS[j].setCreUsrId(account.getUsr_id());
					searchAddPolPodPairForSectorVOS[j].setUpdUsrId(account.getUsr_id());
					insertVoList.add(searchAddPolPodPairForSectorVOS[j]);
				}else{
					//같은 PF GROUP이 들어왔을경우 한번만 INSERT
					if(!searchAddPolPodPairForSectorVOS[j].getPfGrpCd().equals(searchAddPolPodPairForSectorVOS[j-1].getPfGrpCd())){
						searchAddPolPodPairForSectorVOS[j].setBseTpCd(conditionVO.getFBseTpCd());
						searchAddPolPodPairForSectorVOS[j].setBseYr(conditionVO.getFBseYr());
						searchAddPolPodPairForSectorVOS[j].setBseQtrCd(conditionVO.getFBseQtrCd());
						searchAddPolPodPairForSectorVOS[j].setCreUsrId(account.getUsr_id());
						searchAddPolPodPairForSectorVOS[j].setUpdUsrId(account.getUsr_id());
						insertVoList.add(searchAddPolPodPairForSectorVOS[j]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				if(conditionVO.getFBseTpCd().equals("Q")){
					dbDao.createAddPolPodPairForSectorQta(insertVoList);
				}else if(conditionVO.getFBseTpCd().equals("Y")){
					dbDao.createAddPolPodPairForSectorYr(insertVoList);
				}
			}
			
			//신규노선일때
			if(searchAddPolPodPairForSectorVOS[0].getNewRlaneFlg().equals("Y")){
				String laneDirCd = dbDao.searchPolPodPairNewLaneDir(conditionVO);
				log.debug("<<<<<<<<laneDirCd"+laneDirCd);
				if("X".equals(laneDirCd)){ //lane_dir_cd 가 null일때 E, W 둘다 생성
					for ( int i=0; i<2; i++ ) {
						SearchAddPolPodPairForSectorVO newLaneVo = new SearchAddPolPodPairForSectorVO();
	
						newLaneVo.setBseTpCd(conditionVO.getFBseTpCd());
						newLaneVo.setBseYr(conditionVO.getFBseYr());
						newLaneVo.setBseQtrCd(conditionVO.getFBseQtrCd());
						newLaneVo.setRlaneCd(searchAddPolPodPairForSectorVOS[0].getRlaneCd());
						newLaneVo.setTrdCd(searchAddPolPodPairForSectorVOS[0].getTrdCd());
						newLaneVo.setSubTrdCd(searchAddPolPodPairForSectorVOS[0].getSubTrdCd());
						if("0".equals(Integer.toString(i))){
							newLaneVo.setDirCd("E");
						}else if ("1".equals(Integer.toString(i))){
							newLaneVo.setDirCd("W");
						}
						newLaneVo.setCreUsrId(account.getUsr_id());
						newLaneVo.setUpdUsrId(account.getUsr_id());
						newLaneVoList.add(newLaneVo);
			
					}
				}else{
					SearchAddPolPodPairForSectorVO newLaneVo = new SearchAddPolPodPairForSectorVO();
					
					newLaneVo.setBseTpCd(conditionVO.getFBseTpCd());
					newLaneVo.setBseYr(conditionVO.getFBseYr());
					newLaneVo.setBseQtrCd(conditionVO.getFBseQtrCd());
					newLaneVo.setRlaneCd(searchAddPolPodPairForSectorVOS[0].getRlaneCd());
					newLaneVo.setTrdCd(searchAddPolPodPairForSectorVOS[0].getTrdCd());
					newLaneVo.setSubTrdCd(searchAddPolPodPairForSectorVOS[0].getSubTrdCd());
					newLaneVo.setDirCd(laneDirCd);
					newLaneVo.setCreUsrId(account.getUsr_id());
					newLaneVo.setUpdUsrId(account.getUsr_id());
					newLaneVoList.add(newLaneVo);
				}
			//신규노선이 아니고 
			}else if(!searchAddPolPodPairForSectorVOS[0].getNewRlaneFlg().equals("Y")){
				String pairCostCnt = dbDao.searchAddCreateLanePairCostCnt(conditionVO);
				//해당 LANE의 PAIR_COST가 생성된 이후일때 추가한 Route로 Cost생성
				if(!"0".equals(pairCostCnt)){ 
					for ( int j=0; j<searchAddPolPodPairForSectorVOS.length; j++ ) {
						searchAddPolPodPairForSectorVOS[j].setBseTpCd(conditionVO.getFBseTpCd());
						searchAddPolPodPairForSectorVOS[j].setBseYr(conditionVO.getFBseYr());
						searchAddPolPodPairForSectorVOS[j].setBseQtrCd(conditionVO.getFBseQtrCd());
						searchAddPolPodPairForSectorVOS[j].setCreUsrId(account.getUsr_id());
						searchAddPolPodPairForSectorVOS[j].setUpdUsrId(account.getUsr_id());
						pairCostVoList.add(searchAddPolPodPairForSectorVOS[j]);
					}	
				}
			}
			
			//신규노선일 경우 SQM_SCTR_NEW_LANE에 Insert (이후에 New Lane & Sector CMCB가서 Cost 생성
			if ( newLaneVoList.size() > 0 ) {
				dbDao.addPolPodPairNewLane(newLaneVoList);
			}
			//신규노선이 아니고 이미 Pair Cost가 생성된 경우 SQM_SCTR_PAIR_COST에 Insert
			if ( pairCostVoList.size() > 0 ) {
				dbDao.createAddBasicCmcbForIasSector(pairCostVoList);
			}
			
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0207 : [이벤트]<br>
	 * [Basic Data Creation for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataCreationForSecterListVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataCreationForSecterListVO> searchBasicDataCreationForSecterList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicDataCreationForSecterList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * ESM_SQM_0207 : [Retrieve]<br>
	 * [Basic Data Creation for IAS Sector]의 [COUNT] 를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String  searchBasicDataCreationForSecterListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicDataCreationForSecterListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}

	/**
	 * ESM_SQM_0208 : [Creation]<br>
	 *  [Basic Data Creation for IAS Sector]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createBasicDataCreationForSecter(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		String batchRunningStatus = "0";
		String pgmNm  = "ESM_SQM_B003";
		StringBuffer params = new StringBuffer();
		StringBuffer msg = new StringBuffer();
		String str    = "";
		
		try {
			// Lane Master 에 Active 된 노선중 Lane-Office Relation Setting 에 Office 가 Active 안된것이 있는지 확인
			List<SearchLaneBoundCheckListVO> list = dbDao.searchLaneBoundCheckList(conditionVO);
			
			if ( list.size() > 1 ) {
				for ( int i=0; i < list.size(); i++ ) {
					if ( !list.get(i).getOfcVwCd().equals(str) ) {
						str = list.get(i).getOfcVwCd();
						if(str.equals("C")){
							msg.append("▶ Contract view");
						}else{
							msg.append("▶ Loading view");
						}
						msg.append("\n");
					}
					msg.append(list.get(i).getTrdCd());
					msg.append("-");
					msg.append(list.get(i).getRlaneCd());
					msg.append("-");					
					msg.append(list.get(i).getDirCd());
					msg.append("\n");
					
				}
				
				throw new EventException(new ErrorHandler("SQM00006", new String[]{msg.toString()}).getMessage());
			} else if ( !"0".equals(ofcDbDao.searchLaneOfficeRelationListCnt(conditionVO))  ) {	// 사전 Data 존재 여부 확인
				// QTA Lane-Office Relation Setting, IAS Sector Office Relation Setting 데이터가 존재하는지 확인
				// 실행 전 해당 Batch 모듈이 실행 중인지 확인한다.
				if ( !su.isRunning(pgmNm) ) {
					
					// 기 생성된 Data 존재 여부 확인  
					if ( dbDao.searchBasicDataCreationForSecterListCnt(conditionVO).equals("0") ) {
						params.append(conditionVO.getFFmWk());
						params.append("#");
						params.append(conditionVO.getFToWk());
						params.append("#");
						params.append(conditionVO.getFBseTpCd());
						params.append("#");
						params.append(conditionVO.getFBseYr());
						params.append("#");
						params.append(conditionVO.getFBseQtrCd());
						params.append("#");
						params.append(conditionVO.getFDuration());
						params.append("#");
						params.append(account.getUsr_id());
						
						String param = params.toString();
						su.directExecuteJob(pgmNm, param);
						batchRunningStatus = "3";		// STARTING 시작(시스템)
					} else {
						batchRunningStatus = "13";		// Data 존재
					}
				}else{
					batchRunningStatus = "1";		// RUNNING 수행중
					throw new EventException(new ErrorHandler("SQM00004", new String[]{}).getMessage());
				}
			} else {
				batchRunningStatus = "14";		// 사전 Data 미 존재
			}
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"SQM SCTR PERF IF - Creation"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return batchRunningStatus;
	}	
}