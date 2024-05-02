/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CostManageBCImpl.java
*@FileTitle      : CostManageBCImpl
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2014.07.03 PEJ [CHM-201430932] RHQ Office Mapping에 Office 추가시 Sector Office 반영 요청
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.CommonVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration.CostManageDBDAO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchAddedNewLaneListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbMasPfmcListListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbMasUcPfmcVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneOfficeCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see CostManageDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CostManageBCImpl extends BasicCommandSupport implements CostManageBC {
	
	// Database Access Object
	private transient CostManageDBDAO dbDao = null;
	
	/**
	 * CostManageBCImpl 객체 생성<br>
	 * CostManageDBDAO를 생성한다.<br>
	 */
	public CostManageBCImpl() {
		dbDao = new CostManageDBDAO();
	}
	
	/**
	 * 추가된 Lane list를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddedNewLaneListVO>
	 * @throws EventException
	 */
	public List<SearchAddedNewLaneListVO> searchAddedNewLaneList(ConditionVO conditionVO) throws EventException{
		try {
			//01.추가된 Lane list를 조회
			List<SearchAddedNewLaneListVO> list = dbDao.searchAddedNewLaneList(conditionVO);
//			String cnt = null;
//			for(int i=0;i<list.size();i++){
//				//02.CMCB데이터가 생성되었는지 확인
//				cnt = dbDao.searchAddedNewLaneListCnt(list.get(i));
//				if("0".equals(cnt))
//					list.get(i).setFlg("Y");
//				else
//					list.get(i).setFlg("N");
//			}
			return list;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 추가된 Lane list에 CMCB정보를 카피할 대상 rlane정보를 저장한다.
	 * 
	 * @param SqmQtaNewLaneVO[] sqmQtaNewLaneVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAddedNewLane(SqmQtaNewLaneVO[] sqmQtaNewLaneVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaNewLaneVO> list = new ArrayList<SqmQtaNewLaneVO>();
			
			for ( int i=0; i<sqmQtaNewLaneVOS.length; i++ ) {
				sqmQtaNewLaneVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaNewLaneVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmQtaNewLaneVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmQtaNewLaneVOS[i].setCreUsrId(account.getUsr_id());
				sqmQtaNewLaneVOS[i].setUpdUsrId(account.getUsr_id());
				list.add(sqmQtaNewLaneVOS[i]);
			}
			
			if ( list.size() > 0 ) {
				dbDao.updateAddedNewLane(list);				
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0010 : [이벤트]<br>
	 * [New Lane OFfice CMCB]을 [생성] 합니다.<br>
	 * 
	 * @param SqmQtaNewLaneVO[] sqmQtaNewLaneVOS
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createNewLaneOfficeCmcb(SqmQtaNewLaneVO[] sqmQtaNewLaneVOS, ConditionVO conditionVO, String usrId) throws EventException{
		try {
			List<SqmQtaNewLaneVO> list = new ArrayList<SqmQtaNewLaneVO>();
			String msg = "";
			
			for ( int i=0; i<sqmQtaNewLaneVOS.length; i++ ) {
				sqmQtaNewLaneVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaNewLaneVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmQtaNewLaneVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmQtaNewLaneVOS[i].setCreUsrId(usrId);
				sqmQtaNewLaneVOS[i].setUpdUsrId(usrId);
				
				if("0".equals(dbDao.searchNewLaneOfficeCmcbCnt(sqmQtaNewLaneVOS[i])))
					msg = msg + "," + sqmQtaNewLaneVOS[i].getRlaneCd();
				else
					list.add(sqmQtaNewLaneVOS[i]);
				
			}
			
			if ( list.size() > 0 ) {
				dbDao.createNewLaneOfficeCmcb(list);				
			}
			
			return msg;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * New Lane - Office의 Cmcb를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmQtaNewLaneVO sqmQtaNewLaneVO
	 * @return List<SearchNewLaneOfficeCmcbListVO>
	 * @throws EventException
	 */
	public List<SearchNewLaneOfficeCmcbListVO> searchNewLaneOfficeCmcbList(ConditionVO conditionVO, SqmQtaNewLaneVO sqmQtaNewLaneVO) throws EventException{
		try {
			if(sqmQtaNewLaneVO != null){
				conditionVO.setFTrdCd(sqmQtaNewLaneVO.getTrdCd());
				conditionVO.setFRlaneCd(sqmQtaNewLaneVO.getRlaneCd());
				conditionVO.setFDirCd(sqmQtaNewLaneVO.getDirCd());
			}
			return dbDao.searchNewLaneOfficeCmcbList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * New Lane - Office의 Cmcb를 업데이트한다.
	 * 
	 * @param SqmQtaNewLaneOfcCostVO[] VOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneOfficeCmcb(SqmQtaNewLaneOfcCostVO[] VOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaNewLaneOfcCostVO> list = new ArrayList<SqmQtaNewLaneOfcCostVO>();

			for ( int i=0; i<VOS.length; i++ ) {
				VOS[i].setCreUsrId(account.getUsr_id());
				VOS[i].setUpdUsrId(account.getUsr_id());
				list.add(VOS[i]);
			}
			
			if ( list.size() > 0 ) {
				dbDao.updateNewLaneOfficeCmcb(list);				
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 추가된 Office에 대해서 Lane-Office정보와 CMCB를 생성한다.
	 * 
	 * @param SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOS
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createRelatedData(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOS, ConditionVO conditionVO,String usrId) throws EventException{
		try{
			List<SqmQtaLaneOfcVO> ofclist = new ArrayList<SqmQtaLaneOfcVO>();
			List<SqmQtaLaneOfcVO> costlist = new ArrayList<SqmQtaLaneOfcVO>();
			List<SqmQtaLaneOfcVO> sectorlist = new ArrayList<SqmQtaLaneOfcVO>();
			String[] ofcFlg = new String[2];
			String[] costFlg = new String[2];
			String[] secterFlg = new String[2];
			String msg = "";
			
			for ( int i=0; i<sqmQtaLaneOfcVOS.length; i++ ) {
				sqmQtaLaneOfcVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaLaneOfcVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmQtaLaneOfcVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmQtaLaneOfcVOS[i].setCreUsrId(usrId);
				sqmQtaLaneOfcVOS[i].setUpdUsrId(usrId);
				
				ofcFlg = dbDao.searchLaneOfficeForAddedOfcCnt(sqmQtaLaneOfcVOS[i],"OFC");
				if("Y".equals(sqmQtaLaneOfcVOS[i].getBseTpCd())){
					msg = sqmQtaLaneOfcVOS[i].getBseYr(); 
				}else{
					msg = sqmQtaLaneOfcVOS[i].getBseYr() + "."+sqmQtaLaneOfcVOS[i].getBseQtrCd(); 
				}
				//01.lane-office에 쿼터데이터가 생성되어있는지 확인
				if("N".equals(ofcFlg[0])){
					// 해당 분기/년에 데이터가 생성되어 있지 않음
					throw new EventException(new ErrorHandler("SQM00005", new String[] {msg}).getMessage());  
				}else{
					//02.lane-office에 해당 오피스정보가 생성되어 있지 않으면 확인
					if("N".equals(ofcFlg[1])){
						ofclist.add(sqmQtaLaneOfcVOS[i]);

						costFlg = dbDao.searchLaneOfficeForAddedOfcCnt(sqmQtaLaneOfcVOS[i],"COST");
						//03.cost에 쿼터데이터가 생성되어있는지 확인 
						if("Y".equals(costFlg[0])){
							//04.cost에 해당 오피스정보가 생성되어 있는지 확인
							if("N".equals(costFlg[1]))
								costlist.add(sqmQtaLaneOfcVOS[i]);
						}
						
						secterFlg = dbDao.searchLaneOfficeForAddedOfcCnt(sqmQtaLaneOfcVOS[i],"SECTOR");
						//03.Sector Office Relation for IAS Sector에 쿼터데이터가 생성되어있는지 확인 
						if("Y".equals(secterFlg[0])){
							//04.Sector Office Relation for IAS Sector에 해당 오피스정보가 생성되어 있는지 확인
							if("N".equals(secterFlg[1]))
								sectorlist.add(sqmQtaLaneOfcVOS[i]);
						}						
					}
				}
			}
			
			if ( ofclist.size() > 0 ) 
				dbDao.createLaneOfficeForAddedOfc(ofclist);
			
			if ( costlist.size() > 0 ) 
				dbDao.createBasicCmcbForAddedOfc(costlist);
			
			if ( sectorlist.size() > 0 ) 
				dbDao.createSectorLaneOfficeForAddedOfc(sectorlist);
			
		} catch (EventException ex) {
		   throw ex;		  	
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbListVO> searchBasicCmcbList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicCmcbListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void createBasicCmcb(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.createBasicCmcb(conditionVO, account.getUsr_id());
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}   
	}
	
	/**
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [수정] 합니다.<br>
	 * 
	 * @param SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageBasicCmcb(SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<SqmQtaLaneOfcCostVO> updateVoList = new ArrayList<SqmQtaLaneOfcCostVO>();
			
			for (int i=0; i<sqmQtaLaneOfcCostVOs.length; i++ ) {
				sqmQtaLaneOfcCostVOs[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaLaneOfcCostVOs[i].setUpdUsrId(account.getUsr_id());
				
				if (sqmQtaLaneOfcCostVOs[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaLaneOfcCostVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateBasicCmcb(updateVoList);
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
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmQtaLaneOfcCostVO>
	 * @exception EventException
	 */
	public List<SqmQtaLaneOfcCostVO> searchBasicCmcbNewLaneCostIfList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbNewLaneCostIfList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [생성] 합니다.<br>
	 * 
	 * @param SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageBasicCmcbNewLaneCostIf(SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<SqmQtaLaneOfcCostVO> insertVoList = new ArrayList<SqmQtaLaneOfcCostVO>();
			
			for (int i=0; i<sqmQtaLaneOfcCostVOs.length; i++ ) {
				sqmQtaLaneOfcCostVOs[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaLaneOfcCostVOs[i].setBseYr(conditionVO.getFBseYr());
				sqmQtaLaneOfcCostVOs[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmQtaLaneOfcCostVOs[i].setCreUsrId(account.getUsr_id());
				sqmQtaLaneOfcCostVOs[i].setUpdUsrId(account.getUsr_id());
				
				if (sqmQtaLaneOfcCostVOs[i].getIbflag().equals("U")){
					insertVoList.add(sqmQtaLaneOfcCostVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				// 신규노선의 단가를 IF
				dbDao.createBasicCmcbNewLaneCostIf(insertVoList);
				// 신규노선의 Trade-Rlane-Bound 별 평균단가를 생성
				dbDao.createBasicCmcbNewLaneAvgCost(insertVoList);
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
	 * ESM_SQM_0013 : [이벤트]<br>
	 * [Basic CMCB_MAS UC PFMC Retrieve)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbMasPfmcListListVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbMasPfmcListListVO> searchBasicCmcbMasPfmcList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbMasPfmcList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0209 : Retrieve1<br>
	 * [New Lane Sector CMCB List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchNewLaneSecCmcbList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchNewLaneSecCmcbList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0209 : Save1<br>
	 * [New Lane Sector CMCB List]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneSecCmcbNewLane(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchNewLaneSecCmcbListVO> updateVoList = new ArrayList<SearchNewLaneSecCmcbListVO>();
			for ( int i=0; i<searchNewLaneSecCmcbListVOS .length; i++ ) {
				searchNewLaneSecCmcbListVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				searchNewLaneSecCmcbListVOS[i].setBseYr(conditionVO.getFBseYr());
				searchNewLaneSecCmcbListVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				searchNewLaneSecCmcbListVOS[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(searchNewLaneSecCmcbListVOS[i]);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateNewLaneSecCmcbNewLane(updateVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0209 : Creation<br>
	 * [New Lane Sector CMCB Pair Cost]을 [생성]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createNewLaneSecCmcbPairCost(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchNewLaneSecCmcbListVO> insertVoList = new ArrayList<SearchNewLaneSecCmcbListVO>();
			for ( int i=0; i<searchNewLaneSecCmcbListVOS .length; i++ ) {
				searchNewLaneSecCmcbListVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				searchNewLaneSecCmcbListVOS[i].setBseYr(conditionVO.getFBseYr());
				searchNewLaneSecCmcbListVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				searchNewLaneSecCmcbListVOS[i].setCreUsrId(account.getUsr_id());
				searchNewLaneSecCmcbListVOS[i].setUpdUsrId(account.getUsr_id());
				insertVoList.add(searchNewLaneSecCmcbListVOS[i]);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.createNewLaneSecCmcbPairCost(insertVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0209 : Retrieve2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchNewLaneSecCmcbPairCost(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchNewLaneSecCmcbPairCost(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0209 : Save2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneSecCmcbPairCost(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchNewLaneSecCmcbListVO> updateVoList = new ArrayList<SearchNewLaneSecCmcbListVO>();
			for ( int i=0; i<searchNewLaneSecCmcbListVOS .length; i++ ) {
				searchNewLaneSecCmcbListVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				searchNewLaneSecCmcbListVOS[i].setBseYr(conditionVO.getFBseYr());
				searchNewLaneSecCmcbListVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				searchNewLaneSecCmcbListVOS[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(searchNewLaneSecCmcbListVOS[i]);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateNewLaneSecCmcbPairCost(updateVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0210 : [Retrieve]<br>
	 * [Basic CMCB for IAS Sector List]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchBasicCmcbForIasSectorList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbForIasSectorList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * ESM_SQM_0210 : [Retrieve]<br>
	 * [Basic CMCB for IAS Sector List]의 [COUNT] 를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicCmcbForIasSectorListCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbForIasSectorListCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SQM_0210 : Save<br>
	 * [Basic CMCB for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBasicCmcbForIasSectorList(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchNewLaneSecCmcbListVO> updateVoList = new ArrayList<SearchNewLaneSecCmcbListVO>();
			for ( int i=0; i<searchNewLaneSecCmcbListVOS .length; i++ ) {
				searchNewLaneSecCmcbListVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				searchNewLaneSecCmcbListVOS[i].setBseYr(conditionVO.getFBseYr());
				searchNewLaneSecCmcbListVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				searchNewLaneSecCmcbListVOS[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(searchNewLaneSecCmcbListVOS[i]);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateBasicCmcbForIasSectorList(updateVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0210 : Creation<br>
	 * [Basic CMCB for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createBasicCmcbForIasSector(ConditionVO conditionVO, String usrId) throws EventException{
		CostManageBackEndJob backEndJob = new CostManageBackEndJob();
		conditionVO.setFUsrId(usrId);
		conditionVO.setFGubun("CmcbSector");
		backEndJob.setConditionVO(conditionVO);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			return backEndJobManager.execute(backEndJob, usrId, "CMCB Creation");	
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0211 : Retrieve<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchBasicCmcbForIasSecNewLaneIf(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbForIasSecNewLaneIf(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0211 : New Lane Cost Apply<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [Apply]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addBasicCmcbForIasSecNewLaneIf(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchNewLaneSecCmcbListVO> insertVoList = new ArrayList<SearchNewLaneSecCmcbListVO>();
			for ( int i=0; i<searchNewLaneSecCmcbListVOS .length; i++ ) {
				searchNewLaneSecCmcbListVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				searchNewLaneSecCmcbListVOS[i].setBseYr(conditionVO.getFBseYr());
				searchNewLaneSecCmcbListVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				searchNewLaneSecCmcbListVOS[i].setCreUsrId(account.getUsr_id());
				searchNewLaneSecCmcbListVOS[i].setUpdUsrId(account.getUsr_id());
				insertVoList.add(searchNewLaneSecCmcbListVOS[i]);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addBasicCmcbForIasSecNewLaneIf(insertVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0212 : Retrieve<br>
	 * [Basic CMCB_MAS UC PFMC]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbMasUcPfmcVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbMasUcPfmcVO> searchBasicCmcbMasUcPfmc(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbMasUcPfmc(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	

	/**
	 * ESM_SQM_0111 : [이벤트]<br>
	 * [Basic CMCB]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return CommonVO
	 * @throws EventException
	 */
	public CommonVO createAddBasicCmcb(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		String pgmNm  = "ESM_SQM_B007";
		String param = "";
		CommonVO commonVO = new CommonVO();		
		StringBuffer params = new StringBuffer();
		
		try {			
			// 실행 전 해당 Batch 모듈이 실행 중인지 확인한다.
			if ( !su.isRunning(pgmNm) ) {	
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
				params.append(conditionVO.getFOfcVwCd());
				params.append("#");
				params.append(conditionVO.getFTrdCd());
				params.append("#");
				params.append(conditionVO.getFRlaneCd());
				params.append("#");
				params.append(conditionVO.getFDirCd());
				params.append("#");
				params.append(conditionVO.getFRhqCd());
				params.append("#");				
				params.append(conditionVO.getFRgnOfcCd());
				params.append("#");
				params.append(account.getUsr_id());

				param = params.toString();
				log.debug("param: "+param);
				su.directExecuteJob(pgmNm, param);
				commonVO.setFBatStsCd("S");    // STARTING 시작(시스템)
			} else {
				commonVO.setFBatStsCd("R");		// RUNNING 수행중
			}
		
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Basic CMCB - Add Creation"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return commonVO;
	}
	
	
	/**
	 * ESM_SQM_0111 : Add Creation<br>
	 * [Basic CMCB]을 [수정]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAddBasicCmcb(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			conditionVO.setFUsrId(account.getUsr_id());
			dbDao.updateAddBasicCmcb(conditionVO);
			dbDao.updateAddCfmQta(conditionVO);		

			log.debug("Basic CMCB-Add Creation");
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
}