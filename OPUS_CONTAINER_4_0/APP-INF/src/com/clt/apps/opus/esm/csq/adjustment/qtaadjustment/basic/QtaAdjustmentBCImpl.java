/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaAdjustmentBCImpl.java
*@FileTitle      : QtaAdjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.04.04
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.05.30 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration.QtaAdjustmentDBDAO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.ManageQtaEditIasSectorVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnFigureInquiryListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaAdjustmentForSectorListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaAdjustmentListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqCfmQtaVO;
import com.clt.syscommon.common.table.CsqSctrCfmQtaVO;


/**
 * ALPS-QtaAdjustment Business Logic Command Interface<br>
 * - ALPS-QtaAdjustment 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see QtaAdjustmentDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class QtaAdjustmentBCImpl extends BasicCommandSupport implements QtaAdjustmentBC {
	
	// Database Access Object
	private transient QtaAdjustmentDBDAO dbDao = null;
	
	/**
	 * QtaAdjustmentBCImpl 객체 생성<br>
	 * QtaAdjustmentDBDAO를 생성한다.<br>
	 */
	public QtaAdjustmentBCImpl() {
		dbDao = new QtaAdjustmentDBDAO();
	}
	
	/**
	 * ESM_CSQ_0050 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> searchQtaAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchQtaAdjustmentList(conditionVO, account.getOfc_cd());
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0050 : MULTI 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [생성] 합니다.
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaAdjustment(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<ManageQtaAdjustmentVO> deleteVoList  = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> insertVoList1 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> insertVoList3 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList2 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList3 = new ArrayList<ManageQtaAdjustmentVO>();
			
			for ( int i=0; i<manageQtaAdjustmentVOS .length; i++ ) {
				manageQtaAdjustmentVOS[i].setFBseTpCd(conditionVO.getFBseTpCd());
				manageQtaAdjustmentVOS[i].setFBseYr(conditionVO.getFBseYr());
				manageQtaAdjustmentVOS[i].setFBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaAdjustmentVOS[i].setFQtaTgtCd(conditionVO.getFQtaTgtCd());
				manageQtaAdjustmentVOS[i].setFTrdCd(manageQtaAdjustmentVOS[i].getTrdCd());
				manageQtaAdjustmentVOS[i].setFDirCd(manageQtaAdjustmentVOS[i].getDirCd());
				manageQtaAdjustmentVOS[i].setFClick(conditionVO.getFClick());
				manageQtaAdjustmentVOS[i].setFUsrId(account.getUsr_id());
				manageQtaAdjustmentVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				manageQtaAdjustmentVOS[i].setBseYr(conditionVO.getFBseYr());
				manageQtaAdjustmentVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaAdjustmentVOS[i].setQtaTgtCd(conditionVO.getFQtaTgtCd());
				manageQtaAdjustmentVOS[i].setUsrId(account.getUsr_id());
				
				if ( manageQtaAdjustmentVOS[i].getIbflag().equals("I") ) {
					if ( manageQtaAdjustmentVOS[i].getCopyVvd().isEmpty() ) {
						// 신규 이나 Copy VVD 를 선택 안함
						insertVoList1.add(manageQtaAdjustmentVOS[i]);
					} else {
						insertVoList3.add(manageQtaAdjustmentVOS[i]);
					}
					
				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("D") ) {
					deleteVoList.add(manageQtaAdjustmentVOS[i]);
					
				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("U") ) {
					if ( manageQtaAdjustmentVOS[i].getFlag().equals("C") ||  manageQtaAdjustmentVOS[i].getFlag().equals("B") ) {
						// WEEK, MON, BSA 와 LOD, REV 같이 변경된 경우 - Supply Portion 미적용
						updateVoList2.add(manageQtaAdjustmentVOS[i]);
					} else {
						// WEEK, MON, BSA 만 변경된 경우
						updateVoList3.add(manageQtaAdjustmentVOS[i]);
					}
				}
			}
			
			// 신규 이나 Copy VVD 를 선택 안함
			if ( insertVoList1.size() > 0 ) {
				dbDao.addCfmTgtVvd(insertVoList1);
				dbDao.addCfmQta(insertVoList1);
				dbDao.addCfmTgtVvdAdj(insertVoList1);
			}
			
			// 신규 이면서 Copy VVD 를 선택 - Supply Portion 미적용
			if ( insertVoList3.size() > 0 ) {
				dbDao.copyCfmTgtVvd(insertVoList3);
				dbDao.copyCfmQta(insertVoList3);
				dbDao.addCfmTgtVvdAdj(insertVoList3);
			}
			
			// WEEK, MON, BSA 와 LOD, REV 같이 변경된 경우 - Supply Portion 미적용
			if ( updateVoList2.size() > 0 ) {
				dbDao.updateCfmTgtVvd(updateVoList2);
				dbDao.removeCfmQta(updateVoList2);
				dbDao.addCfmQta(updateVoList2);
				dbDao.addCfmTgtVvdAdj(updateVoList2);
			}
			
			// WEEK, MON, BSA 만 변경된 경우
			if ( updateVoList3.size() > 0 ) {
				dbDao.updateCfmTgtVvd(updateVoList3);
				dbDao.addCfmTgtVvdAdj(updateVoList3);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCfmQta(deleteVoList);
				dbDao.removeCfmTgtVvd(deleteVoList);
				dbDao.addCfmTgtVvdAdj(deleteVoList);
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
	 * ESM_CSQ_0051 : [이벤트]<br>
	 * [Portion Adjustment by Head Office]을 [조회] 합니다.<br>
	 * [Portion Adjustment by RHQ]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchPotnAdjustmentListVO> searchPotnAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchPotnAdjustmentList(conditionVO,account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0051 : [이벤트]<br>
	 * [Portion Adjustment]을 [저장] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePotnAdjustment(ConditionVO conditionVO, SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SearchPotnAdjustmentListVO> updateVoList = new ArrayList<SearchPotnAdjustmentListVO>();
			List<SearchPotnAdjustmentListVO> insertVoList = new ArrayList<SearchPotnAdjustmentListVO>();
			
			for ( int i=0; i<searchPotnAdjustmentListVOS .length; i++ ) {    
				searchPotnAdjustmentListVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				
				if(!"02".equals(conditionVO.getFQtaStepCd())){
					
					if("O".equals(conditionVO.getFObDivCd())){
						if("L".equals(conditionVO.getFOfcVwCd()))
							searchPotnAdjustmentListVOS[i].setQtaStepCd("03"); // Loading O/B
						else
							searchPotnAdjustmentListVOS[i].setQtaStepCd("05"); // Contract O/B
					}else{
						searchPotnAdjustmentListVOS[i].setQtaStepCd("04");// Contract N.O/B
					}
					
				}else{
					searchPotnAdjustmentListVOS[i].setQtaStepCd(conditionVO.getFQtaStepCd());
				}
				
				searchPotnAdjustmentListVOS[i].setOfcVwCd(conditionVO.getFOfcVwCd());
				searchPotnAdjustmentListVOS[i].setCreUsrId(account.getUsr_id());
				searchPotnAdjustmentListVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if (searchPotnAdjustmentListVOS[i].getIbflag().equals("I")){
					insertVoList.add(searchPotnAdjustmentListVOS[i]);
				} else if ( searchPotnAdjustmentListVOS[i].getIbflag().equals("U")){
					updateVoList.add(searchPotnAdjustmentListVOS[i]);
				}				
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addPotnAdjustment(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updatePotnAdjustment(updateVoList);
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
	 * ESM_CSQ_0051 : MULTI02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]를 [RHQ Group Row Add] 합니다
     * [Portion Adjustment by RHQ]를 [RHQ Group Row Add] 합니다	
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPotnAdjustmentListVO>
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public List<SearchPotnAdjustmentListVO> searchRhqGroupRowAdd(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchRhqGroupRowAdd(conditionVO,account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0051 : SEARCH01 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd의 주차를 [조회] 합니다.
	 * [Portion Adjustment by RHQ]에서 vvd의 주차를 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	public String searchApplyWeek(ConditionVO conditionVO, String vvd) throws EventException {
		try {
			return dbDao.searchApplyWeek(conditionVO,vvd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0051 : SEARCH02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd 입력 시 해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchVvdCngTpCd(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchVvdCngTpCd(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_CSQ_0051,ESM_CSQ_0053 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createPotnAdjustment(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removePotnAdjustment(conditionVO, account);
			dbDao.createPotnAdjustment(conditionVO, account);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}   
	}
	
	/**
	 * ESM_CSQ_0055 : Retrieve 이벤트 처리<br>
	 * [Qta Edit]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaEditList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0055 : MULTI 이벤트 처리<br>
	 * [Qta Edit]을을 [저장] 합니다.
	 * 
	 * @param CsqCfmQtaVO[] csqCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEdit(CsqCfmQtaVO[] csqCfmQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<CsqCfmQtaVO> updateVoList = new ArrayList<CsqCfmQtaVO>();
			List<CsqCfmQtaVO> updateStsVoList = new ArrayList<CsqCfmQtaVO>();
			String oldS = "";
			String newS = "";
			
			for ( int i=0; i<csqCfmQtaVOS .length; i++ ) {
				if(csqCfmQtaVOS[i].getOfcVwCd().equals("Loading")){
					csqCfmQtaVOS[i].setOfcVwCd("L");
				} else {
					csqCfmQtaVOS[i].setOfcVwCd("C");
				}
				csqCfmQtaVOS[i].setCreUsrId(account.getUsr_id());
				csqCfmQtaVOS[i].setUpdUsrId(account.getUsr_id()); 
				newS = csqCfmQtaVOS[i].getTrdCd()+csqCfmQtaVOS[i].getRlaneCd()+csqCfmQtaVOS[i].getDirCd()
				+ csqCfmQtaVOS[i].getVslCd()+ csqCfmQtaVOS[i].getSkdVoyNo()+ csqCfmQtaVOS[i].getSkdDirCd() ;
				
				if(!oldS.equals(newS)){
					updateStsVoList.add(csqCfmQtaVOS[i]);
				}
				
				if ( csqCfmQtaVOS[i].getIbflag().equals("U")){
					updateVoList.add(csqCfmQtaVOS[i]);
				}
				oldS = newS;
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateQtaEdit(updateVoList);

			}
			if ( updateStsVoList.size() > 0 ) {
				dbDao.updateCfmQtaStatus(updateStsVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0055 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust]을을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createCmcbAdjust(ConditionVO conditionVO, String usrId) throws EventException{
		try {
			dbDao.createCmcbAdjust(conditionVO, usrId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_CSQ_0052/ESM_CSQ_0054 : Retrieve 이벤트 처리<br>
	 * [Figure Inquiry]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnFigureInquiryListVO>
	 * @throws EventException
	 */
	public List<SearchPotnFigureInquiryListVO> searchPotnFigureInquiryList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			String f_gubun = conditionVO.getFGubun();
			List<SearchPotnFigureInquiryListVO> list = null;

			if(f_gubun.equals("HO")){
				list = dbDao.searchHOPotnFigureInquiryList(conditionVO, account);
			}else if(f_gubun.equals("RHQ")){
				list = dbDao.searchRHQPotnFigureInquiryList(conditionVO, account);
			}
			return list;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0056 : Retrieve 이벤트 처리<br>
	 * [IAS Lane Office List]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchLaneOfficeListVO>
	 * @throws EventException
	 */
	public List<SearchLaneOfficeListVO> searchLaneOfficeList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchLaneOfficeList(conditionVO, account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0056 : Creation 이벤트 처리<br>
	 * [IAS QTA Office Add]을 [생성] 합니다.
	 * 
	 * @param SearchLaneOfficeListVO[] searchLaneOfficeListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaOfficeAdd(SearchLaneOfficeListVO[] searchLaneOfficeListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<SearchLaneOfficeListVO> updateVoList = new ArrayList<SearchLaneOfficeListVO>();
					
			for ( int i=0; i<searchLaneOfficeListVOS .length; i++ ) {    
				searchLaneOfficeListVOS[i].setFUsrId(account.getUsr_id());
				if ( searchLaneOfficeListVOS[i].getIbflag().equals("U") ) {
					updateVoList.add(searchLaneOfficeListVOS[i]);
				}	
			}
			conditionVO.setFUsrId(account.getUsr_id());
			
			if ( updateVoList.size() > 0 ) {
				// Office Add
				dbDao.createQtaOfficeAdd(updateVoList);
				// 추가된 노선의 상태를 'M' 으로 변경
				dbDao.updateCfmQtaStatusLane(conditionVO);
			}	

		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}   
	}	

	/**
	 * ESM_CSQ_0219 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD For Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaAdjustmentForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentForSectorListVO> searchQtaAdjustmentForSectorList(ConditionVO conditionVO) throws EventException{
		try {
			return dbDao.searchQtaAdjustmentForSectorList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0219 : Creation<br>
	 * [QTA Adjustment by VVD For Sector]을 [복사][변경][삭제] 합니다.<br>
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaAdjustmentForSector(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<ManageQtaAdjustmentVO> deleteVoList  = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> insertVoList = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList1 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList2 = new ArrayList<ManageQtaAdjustmentVO>();
			
			for ( int i=0; i<manageQtaAdjustmentVOS .length; i++ ) {
				manageQtaAdjustmentVOS[i].setFBseTpCd(conditionVO.getFBseTpCd());
				manageQtaAdjustmentVOS[i].setFBseYr(conditionVO.getFBseYr());
				manageQtaAdjustmentVOS[i].setFBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaAdjustmentVOS[i].setFTrdCd(conditionVO.getFTrdCd());
				manageQtaAdjustmentVOS[i].setFQtaTgtCd("D");
				
				manageQtaAdjustmentVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				manageQtaAdjustmentVOS[i].setBseYr(conditionVO.getFBseYr());
				manageQtaAdjustmentVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaAdjustmentVOS[i].setQtaTgtCd("D");
				manageQtaAdjustmentVOS[i].setFUsrId(account.getUsr_id());
				manageQtaAdjustmentVOS[i].setUsrId(account.getUsr_id());
				manageQtaAdjustmentVOS[i].setFClick(manageQtaAdjustmentVOS[i].getFClick().equals("1")?"Y":"N");
				
				if ( manageQtaAdjustmentVOS[i].getIbflag().equals("I") ) {// 신규 VVD [ Copy VVD 를 선택]
						insertVoList.add(manageQtaAdjustmentVOS[i]);

				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("U") ) {
					
					// WEEK, MON, BSA 가 변경된 경우 
					if ( manageQtaAdjustmentVOS[i].getVvd().equals(  manageQtaAdjustmentVOS[i].getCoaVvd() )) {
						updateVoList1.add(manageQtaAdjustmentVOS[i]);
					}
					// QTA=0 이 체크되었을 경우
					if ( manageQtaAdjustmentVOS[i].getFClick().equals("Y")) {
						updateVoList2.add(manageQtaAdjustmentVOS[i]);
					} 
					
				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("D") ) { // 삭제 VVD
					deleteVoList.add(manageQtaAdjustmentVOS[i]);
				}
				
			}// End For
			
			// 신규 VVD [ Copy VVD 를 선택]
			if ( insertVoList.size() > 0 ) {
				dbDao.copyCfmTgtVvd(insertVoList);
				dbDao.copyCfmQtaForSector(insertVoList);
				dbDao.insertCfmQtaSync(insertVoList);
				dbDao.addCfmTgtVvdAdj(insertVoList);
			}
			
			// WEEK, MON, BSA 만 변경된 경우
			if ( updateVoList1.size() > 0 ) {
				dbDao.updateCfmTgtVvd(updateVoList1);
				dbDao.addCfmTgtVvdAdj(updateVoList1);
			}
			
			// QTA = 0 이 체크되었을 경우
			if ( updateVoList2.size() > 0 ) {
				dbDao.updateCfmQtaForSectorZero(updateVoList2);
				dbDao.removeCfmQta(updateVoList2);
				dbDao.insertCfmQtaSync(updateVoList2);
			}
			
			// 삭제 VVD
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCfmQta(deleteVoList);
				dbDao.removeCfmQtaForSector(deleteVoList);
				dbDao.removeCfmTgtVvd(deleteVoList);
				dbDao.addCfmTgtVvdAdj(deleteVoList);
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
	 * ESM_CSQ_0220 : Retrieve 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditIasSectorList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaEditIasSectorList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param CsqSctrCfmQtaVO[] csqSctrCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEditIasSector(CsqSctrCfmQtaVO[] csqSctrCfmQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<CsqSctrCfmQtaVO> updateVoList = new ArrayList<CsqSctrCfmQtaVO>();
			String oldS = "";
			String newS = "";
			
			for ( int i=0; i<csqSctrCfmQtaVOS .length; i++ ) {
				if(csqSctrCfmQtaVOS[i].getOfcVwCd().equals("Loading")){
					csqSctrCfmQtaVOS[i].setOfcVwCd("L");
				} else {
					csqSctrCfmQtaVOS[i].setOfcVwCd("C");
				}
				csqSctrCfmQtaVOS[i].setCreUsrId(account.getUsr_id());
				csqSctrCfmQtaVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( csqSctrCfmQtaVOS[i].getIbflag().equals("U")){
					updateVoList.add(csqSctrCfmQtaVOS[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateQtaEditIasSector(updateVoList);
			}
			
			for ( int j=0; j<csqSctrCfmQtaVOS .length; j++ ) {
				csqSctrCfmQtaVOS[j].setCreUsrId(account.getUsr_id());
				csqSctrCfmQtaVOS[j].setUpdUsrId(account.getUsr_id()); 
				
				newS = csqSctrCfmQtaVOS[j].getTrdCd()+csqSctrCfmQtaVOS[j].getRlaneCd()+csqSctrCfmQtaVOS[j].getDirCd()
						+ csqSctrCfmQtaVOS[j].getRhqCd()+ csqSctrCfmQtaVOS[j].getRgnOfcCd()
						+ csqSctrCfmQtaVOS[j].getVslCd()+ csqSctrCfmQtaVOS[j].getSkdVoyNo()+ csqSctrCfmQtaVOS[j].getSkdDirCd() ;
				
				if(!oldS.equals(newS)){
					//CSQ_CFM_QTA Delete (overall report에서 조회되도록)
					dbDao.removeCfmQtaIasSector(csqSctrCfmQtaVOS[j]);
					//CSQ_CFM_QTA Insert (overall report에서 조회되도록)
					dbDao.addCfmQtaIasSector(csqSctrCfmQtaVOS[j]);
				}
				oldS = newS;
			}
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createCmcbAdjustIasSector(ConditionVO conditionVO, String usrId) throws EventException{
		try {
			dbDao.createCmcbAdjustIasSector(conditionVO, usrId);
			//CSQ_CFM_QTA Delete (overall report에서 조회되도록)
			dbDao.removeCfmQtaIasSector2(conditionVO, usrId);
			//CSQ_CFM_QTA Insert (overall report에서 조회되도록)
			dbDao.addCfmQtaIasSector2(conditionVO, usrId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0221 : Retrieve 이벤트 처리<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditPolPodPairAddIasSector(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaEditPolPodPairAddIasSector(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0221 : CREATION<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaEditPolPodPairAddIasSector(ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<ManageQtaEditIasSectorVO> insertVoList = new ArrayList<ManageQtaEditIasSectorVO>();

			//Add-Creation
			for ( int j=0; j<manageQtaEditIasSectorVOS.length; j++ ) {
				manageQtaEditIasSectorVOS[j].setBseTpCd(conditionVO.getFBseTpCd());
				manageQtaEditIasSectorVOS[j].setBseYr(conditionVO.getFBseYr());
				manageQtaEditIasSectorVOS[j].setBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaEditIasSectorVOS[j].setOfcVwCd(conditionVO.getFOfcVwCd());
				manageQtaEditIasSectorVOS[j].setCreUsrId(account.getUsr_id());
				manageQtaEditIasSectorVOS[j].setUpdUsrId(account.getUsr_id());
				insertVoList.add(manageQtaEditIasSectorVOS[j]);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.createQtaEditPolPodPairAddIasSector(insertVoList);
			}
			//CSQ_CFM_QTA Delete (overall report에서 조회되도록)
			dbDao.removeCfmQtaIasSector2(conditionVO, account.getUsr_id());
			//CSQ_CFM_QTA Insert (overall report에서 조회되도록)
			dbDao.addCfmQtaIasSector2(conditionVO, account.getUsr_id());
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_CSQ_0222 : Retrieve 이벤트 처리<br>
	 * [Qta Edit Office Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditOfficeAddIasSector(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaEditOfficeAddIasSector(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0222 : CREATION<br>
	 * [Qta Edit Office Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaEditOfficeAddIasSector(ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<ManageQtaEditIasSectorVO> insertVoList = new ArrayList<ManageQtaEditIasSectorVO>();

			//Add-Creation
			for ( int j=0; j<manageQtaEditIasSectorVOS.length; j++ ) {
				manageQtaEditIasSectorVOS[j].setBseTpCd(conditionVO.getFBseTpCd());
				manageQtaEditIasSectorVOS[j].setBseYr(conditionVO.getFBseYr());
				manageQtaEditIasSectorVOS[j].setBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaEditIasSectorVOS[j].setOfcVwCd(conditionVO.getFOfcVwCd());
				manageQtaEditIasSectorVOS[j].setCreUsrId(account.getUsr_id());
				manageQtaEditIasSectorVOS[j].setUpdUsrId(account.getUsr_id());
				insertVoList.add(manageQtaEditIasSectorVOS[j]);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.createQtaEditOfficeAddIasSector(insertVoList);
			}
			//CSQ_CFM_QTA Delete (overall report에서 조회되도록)
			dbDao.removeCfmQtaIasSector2(conditionVO, account.getUsr_id());
			//CSQ_CFM_QTA Insert (overall report에서 조회되도록)
			dbDao.addCfmQtaIasSector2(conditionVO, account.getUsr_id());
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
}