/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CostManageBCImpl.java
*@FileTitle      : CostManageBCImpl
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
* 2014.07.03 PEJ [CHM-201430932] RHQ Office Mapping에 Office 추가시 Sector Office 반영 요청
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.integration.CostManageDBDAO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchAddedNewLaneListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbCoaPfmcListListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbCoaUcPfmcVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneOfficeCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaLaneOfcCostVO;
import com.clt.syscommon.common.table.CsqQtaLaneOfcVO;
import com.clt.syscommon.common.table.CsqQtaNewLaneOfcCostVO;
import com.clt.syscommon.common.table.CsqQtaNewLaneVO;

/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
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
	 * @param CsqQtaNewLaneVO[] csqQtaNewLaneVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAddedNewLane(CsqQtaNewLaneVO[] csqQtaNewLaneVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CsqQtaNewLaneVO> list = new ArrayList<CsqQtaNewLaneVO>();
			
			for ( int i=0; i<csqQtaNewLaneVOS.length; i++ ) {
				csqQtaNewLaneVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaNewLaneVOS[i].setBseYr(conditionVO.getFBseYr());
				csqQtaNewLaneVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				csqQtaNewLaneVOS[i].setCreUsrId(account.getUsr_id());
				csqQtaNewLaneVOS[i].setUpdUsrId(account.getUsr_id());
				list.add(csqQtaNewLaneVOS[i]);
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
	 * ESM_CSQ_0012 : [이벤트]<br>
	 * [New Lane OFfice CMCB]을 [생성] 합니다.<br>
	 * 
	 * @param CsqQtaNewLaneVO[] csqQtaNewLaneVOS
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createNewLaneOfficeCmcb(CsqQtaNewLaneVO[] csqQtaNewLaneVOS, ConditionVO conditionVO, String usrId) throws EventException{
		try {
			List<CsqQtaNewLaneVO> list = new ArrayList<CsqQtaNewLaneVO>();
			String msg = "";
			
			for ( int i=0; i<csqQtaNewLaneVOS.length; i++ ) {
				csqQtaNewLaneVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaNewLaneVOS[i].setBseYr(conditionVO.getFBseYr());
				csqQtaNewLaneVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				csqQtaNewLaneVOS[i].setCreUsrId(usrId);
				csqQtaNewLaneVOS[i].setUpdUsrId(usrId);
				
				if("0".equals(dbDao.searchNewLaneOfficeCmcbCnt(csqQtaNewLaneVOS[i])))
					msg = msg + "," + csqQtaNewLaneVOS[i].getRlaneCd();
				else
					list.add(csqQtaNewLaneVOS[i]);
				
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
	 * @param CsqQtaNewLaneVO csqQtaNewLaneVO
	 * @return List<SearchNewLaneOfficeCmcbListVO>
	 * @throws EventException
	 */
	public List<SearchNewLaneOfficeCmcbListVO> searchNewLaneOfficeCmcbList(ConditionVO conditionVO, CsqQtaNewLaneVO csqQtaNewLaneVO) throws EventException{
		try {
			if(csqQtaNewLaneVO != null){
				conditionVO.setFTrdCd(csqQtaNewLaneVO.getTrdCd());
				conditionVO.setFRlaneCd(csqQtaNewLaneVO.getRlaneCd());
				conditionVO.setFDirCd(csqQtaNewLaneVO.getDirCd());
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
	 * @param CsqQtaNewLaneOfcCostVO[] VOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneOfficeCmcb(CsqQtaNewLaneOfcCostVO[] VOS, SignOnUserAccount account) throws EventException{
		try {
			List<CsqQtaNewLaneOfcCostVO> list = new ArrayList<CsqQtaNewLaneOfcCostVO>();

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
	 * @param CsqQtaLaneOfcVO[] csqQtaLaneOfcVOS
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createRelatedData(CsqQtaLaneOfcVO[] csqQtaLaneOfcVOS, ConditionVO conditionVO,String usrId) throws EventException{
		try{
			List<CsqQtaLaneOfcVO> ofclist = new ArrayList<CsqQtaLaneOfcVO>();
			List<CsqQtaLaneOfcVO> costlist = new ArrayList<CsqQtaLaneOfcVO>();
			List<CsqQtaLaneOfcVO> sectorlist = new ArrayList<CsqQtaLaneOfcVO>();
			List<CsqQtaLaneOfcVO> potnlist = new ArrayList<CsqQtaLaneOfcVO>();
			List<CsqQtaLaneOfcVO> lodrevlist = new ArrayList<CsqQtaLaneOfcVO>();
			String[] ofcFlg = new String[2];
			String[] costFlg = new String[2];
			String[] secterFlg = new String[2];
			String[] potnFlg = new String[2];
			String[] lodRevFlg = new String[2];
			String msg = "";
			
			for ( int i=0; i<csqQtaLaneOfcVOS.length; i++ ) {
				csqQtaLaneOfcVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaLaneOfcVOS[i].setBseYr(conditionVO.getFBseYr());
				csqQtaLaneOfcVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				csqQtaLaneOfcVOS[i].setCreUsrId(usrId);
				csqQtaLaneOfcVOS[i].setUpdUsrId(usrId);
				
				if("Y".equals(csqQtaLaneOfcVOS[i].getBseTpCd())){
					msg = csqQtaLaneOfcVOS[i].getBseYr(); 
				}else{
					msg = csqQtaLaneOfcVOS[i].getBseYr() + "."+csqQtaLaneOfcVOS[i].getBseQtrCd(); 
				}
				log.debug("======================msg:"+msg);
				ofcFlg = dbDao.searchLaneOfficeForAddedOfcCnt(csqQtaLaneOfcVOS[i],"OFC");
				//01.lane-office에 쿼터데이터가 생성되어있는지 확인
				if("N".equals(ofcFlg[0])){
					// 해당 분기/년에 데이터가 생성되어 있지 않음
					throw new EventException(new ErrorHandler("CSQ00005", new String[]{msg}).getMessage());  
				}else{
					//02.lane-office에 해당 오피스정보가 생성되어 있지 않으면 확인
					if("N".equals(ofcFlg[1])){
						ofclist.add(csqQtaLaneOfcVOS[i]);

						costFlg = dbDao.searchLaneOfficeForAddedOfcCnt(csqQtaLaneOfcVOS[i],"COST");
						//03.cost에 쿼터데이터가 생성되어있는지 확인 
						if("Y".equals(costFlg[0])){
							//04.cost에 해당 오피스정보가 생성되어 있는지 확인
							if("N".equals(costFlg[1]))
								costlist.add(csqQtaLaneOfcVOS[i]);
						}
						
						secterFlg = dbDao.searchLaneOfficeForAddedOfcCnt(csqQtaLaneOfcVOS[i],"SECTOR");
						//05.Sector Office Relation for IAS Sector에 쿼터데이터가 생성되어있는지 확인 
						if("Y".equals(secterFlg[0])){
							//06.Sector Office Relation for IAS Sector에 해당 오피스정보가 생성되어 있는지 확인
							if("N".equals(secterFlg[1]))
								sectorlist.add(csqQtaLaneOfcVOS[i]);
						}
						
						potnFlg = dbDao.searchPotnMgmtForAddedOfcCnt(csqQtaLaneOfcVOS[i]);
						if(potnFlg != null){
							//07.Portion 데이터는 존재하면서 Freezing 하기 전 일 경우  CSQ_QTA_POTN_MGMT 까지 데이터 생성
							if( !"0".equals(potnFlg[0]) && "0".equals(potnFlg[1]) ){
								potnlist.add(csqQtaLaneOfcVOS[i]);
							}
						}
						
						lodRevFlg = dbDao.searchLodRevForAddedOfcCnt(csqQtaLaneOfcVOS[i]);
						if(lodRevFlg != null){
							//08.Planning 데이터는 존재하면서 Freezing 하기 전 일 경우  CSQ_SCTR_LOD_REV 까지 데이터 생성
							if( !"0".equals(lodRevFlg[0]) && "0".equals(lodRevFlg[1]) ){
								lodrevlist.add(csqQtaLaneOfcVOS[i]);
							}
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
			
			if ( potnlist.size() > 0 ) 
				dbDao.createPotnMgmtForAddedOfc(potnlist);
			
			if ( lodrevlist.size() > 0 ) 
				dbDao.createLodRevForAddedOfc(lodrevlist);
			
		} catch (EventException ex) {
		   throw ex;		  	
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("CSQ00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0013 : [이벤트]<br>
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
	 * ESM_CSQ_0013 : [이벤트]<br>
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
	 * ESM_CSQ_0013 : [이벤트]<br>
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
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [수정] 합니다.<br>
	 * 
	 * @param CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageBasicCmcb(CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<CsqQtaLaneOfcCostVO> updateVoList = new ArrayList<CsqQtaLaneOfcCostVO>();
			
			for (int i=0; i<csqQtaLaneOfcCostVOs.length; i++ ) {
				csqQtaLaneOfcCostVOs[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaLaneOfcCostVOs[i].setOfcVwCd(conditionVO.getFOfcVwCd());
				csqQtaLaneOfcCostVOs[i].setUpdUsrId(account.getUsr_id());
				
				if (csqQtaLaneOfcCostVOs[i].getIbflag().equals("U")){
					updateVoList.add(csqQtaLaneOfcCostVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateBasicCmcb(updateVoList);
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
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<CsqQtaLaneOfcCostVO>
	 * @exception EventException
	 */
	public List<CsqQtaLaneOfcCostVO> searchBasicCmcbNewLaneCostIfList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbNewLaneCostIfList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [생성] 합니다.<br>
	 * 
	 * @param CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageBasicCmcbNewLaneCostIf(CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<CsqQtaLaneOfcCostVO> insertVoList = new ArrayList<CsqQtaLaneOfcCostVO>();
			
			for (int i=0; i<csqQtaLaneOfcCostVOs.length; i++ ) {
				csqQtaLaneOfcCostVOs[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaLaneOfcCostVOs[i].setBseYr(conditionVO.getFBseYr());
				csqQtaLaneOfcCostVOs[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				csqQtaLaneOfcCostVOs[i].setCreUsrId(account.getUsr_id());
				csqQtaLaneOfcCostVOs[i].setUpdUsrId(account.getUsr_id());
				
				if (csqQtaLaneOfcCostVOs[i].getIbflag().equals("U")){
					insertVoList.add(csqQtaLaneOfcCostVOs[i]);
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
				throw new EventException(new ErrorHandler("CSQ00001").getMessage(), de);
			else
				throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_CSQ_0015 : [이벤트]<br>
	 * [Basic CMCB_COA UC PFMC Retrieve)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbCoaPfmcListListVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbCoaPfmcListListVO> searchBasicCmcbCoaPfmcList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbCoaPfmcList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0209 : Retrieve1<br>
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
	 * ESM_CSQ_0209 : Save1<br>
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
	 * ESM_CSQ_0209 : Creation<br>
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
	 * ESM_CSQ_0209 : Retrieve2<br>
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
	 * ESM_CSQ_0209 : Save2<br>
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
	 * ESM_CSQ_0210 : [Retrieve]<br>
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
	 * ESM_CSQ_0210 : [Retrieve]<br>
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
	 * ESM_CSQ_0210 : Save<br>
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
	 * ESM_CSQ_0210 : Creation<br>
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
	 * ESM_CSQ_0211 : Retrieve<br>
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
	 * ESM_CSQ_0211 : New Lane Cost Apply<br>
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
	 * ESM_CSQ_0212 : Retrieve<br>
	 * [Basic CMCB_COA UC PFMC]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbCoaUcPfmcVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbCoaUcPfmcVO> searchBasicCmcbCoaUcPfmc(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbCoaUcPfmc(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}