/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : AdjustmentBCImpl.java
*@FileTitle      : Adjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.04.04
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.16 이혜민
* 1.0 Creation
* 2014.01.02 이혜민 [CHM-201328060-01] SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
* 2014.04.04 이혜민 [CHM-201429614-01] KPI Management => SKD Adjustment by VVD 화면 검색조건 로직 수정
* 2014.09.17 이혜민 [CHM-201431755-01] New Lane Add시 Bound 삽입
* 2014.12.12 이혜민 [CHM-201432763] RF SPCL TPSZ Master 화면 신규 생성
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze)
* 2015.11.09 김용습 [CHM-201538494] [CSR 전환건] SKD Adjustment by VVD 화면 보완 (Trade Direction, Adjusting VVD Select, BSA Flag 칼럼 추가)
* 2015.11.24 김용습 [CHM-201538493] [CSR 전환건] Current KPI Report 화면 보완 (조회 조건 Week → Month 변경, Raw Data Export 버튼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration.AdjustmentDBDAO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchCurrentKpiReportVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditNewOfcHisVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchQtaAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchReeferSpclTpSzMgmtVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration.SpclPlanningDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmSpclCfmQtaVO;
import com.hanjin.syscommon.common.table.SqmSpclNewLaneVO;
import com.hanjin.syscommon.common.table.SqmSpclNewOfcVO;

/**
 * ALPS-Adjustment Business Logic Command Interface<br>
 * - ALPS-Adjustment 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see AdjustmentDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AdjustmentBCImpl extends BasicCommandSupport implements AdjustmentBC {

	// Database Access Object
	private transient AdjustmentDBDAO dbDao = null;
	private transient SpclPlanningDBDAO dbDao2 = null;

	/**
	 * AdjustmentBCImpl 객체 생성<br>
	 * AdjustmentDBDAO를 생성한다.<br>
	 */
	public AdjustmentBCImpl() {
		dbDao = new AdjustmentDBDAO();
		dbDao2 = new SpclPlanningDBDAO();
	}

	/**
	 * ESM_SQM_0504 : [SEARCH]<br>
	 * [KPI Creation & Edit]을 [조회]합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiCreationEditVO>
	 * @exception EventException
	 */
	public List<SearchKpiCreationEditVO> searchKpiCreationEdit(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchKpiCreationEdit(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0504 : [SEARCH]<br>
	 * [KPI Creation & Edit]을 [Data Count] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchKpiCreationEditCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchKpiCreationEditCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0504 : [SEARCH01]<br>
	 * [KPI Creation & Edit]화면에서 Creation 후 또는 이미 Yearly 데이터가 있을 경우 1Q 데이터가 있는지 없는지 [확인]합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String search1QTransferDataCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.search1QTransferDataCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0504 : [MULTI]<br>
	 * [KPI Creation & Edit]을 [저장] 합니다.
	 *
	 * @param ConditionVO conditionVO
	 * @param SqmSpclCfmQtaVO[] sqmSpclCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageKpiCreationEdit(ConditionVO conditionVO, SqmSpclCfmQtaVO[] sqmSpclCfmQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmSpclCfmQtaVO> updateVoList = new ArrayList<SqmSpclCfmQtaVO>();

			for ( int i=0; i<sqmSpclCfmQtaVOS .length; i++ ) {
				sqmSpclCfmQtaVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmSpclCfmQtaVOS[i].setSpclTgtCd(conditionVO.getFSpclTgtCd());
				sqmSpclCfmQtaVOS[i].setCreUsrId(account.getUsr_id());
				sqmSpclCfmQtaVOS[i].setUpdUsrId(account.getUsr_id());

				if ( sqmSpclCfmQtaVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmSpclCfmQtaVOS[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateKpiCreationEdit(updateVoList);
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
	 * ESM_SQM_0504 : [MULTI01]<br>
	 * [KPI Creation & Edit]을 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createKpiCreationEdit(ConditionVO conditionVO, String usrId) throws EventException{
		String istCnt = null;
		String spclLodRevCnt = null;
		String spclLaneOfcCostCnt = null;
		String vvdCnt = null;

		try {
			//1)SQM_SPCL_LOD_REV , SQM_SPCL_LANE_OFC_COST 데이터 Count
			spclLodRevCnt = dbDao2.searchKpiInputbyHeadOfficeCnt(conditionVO);
			spclLaneOfcCostCnt = dbDao2.searchBasicCmcbCnt(conditionVO);

			if(spclLodRevCnt.equals("0") || spclLaneOfcCostCnt.equals("0")){
				throw new EventException(new ErrorHandler("SQM00003").getMessage());
			}else{
				conditionVO.setFRlaneCd("");
				// Reefer/Special 각각 creation 하기 때문에 VVD는 처음 생성시에 한번만 생성하기 위해 vvd cnt를 확인한다.
				vvdCnt = dbDao.searchQtaAdjustmentListCnt(conditionVO);
				if(vvdCnt.equals("0")) {
					//1) SQM_QTA_TGT_VVD -> SQM_SPCL_TGT_VVD
					dbDao.createSqmQtaTgtVvd(conditionVO, usrId);
				}
				//2) SQM_SPCL_TGT_VVD -> SQM_SPCL_CFM_QTA
				istCnt = dbDao.createKpiCreationEdit(conditionVO, usrId);
				if(istCnt.equals("0")){
					throw new EventException(new ErrorHandler("SQM00003").getMessage());
				}
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);
			else
				throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return istCnt;
	}

	/**
	 * ESM_SQM_0504 : [MULTI02]<br>
	 * [1Q Data]을 [Transfer] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String create1QTransferData(ConditionVO conditionVO, String usrId) throws EventException{
		String istCnt = null;
		String vvdCnt = null;
		try {
			// Reefer/Special 각각 creation 하기 때문에 VVD는 처음 생성시에 한번만 생성하기 위해 vvd cnt를 확인한다.
			conditionVO.setFBseTpCd("Q");
			conditionVO.setFBseQtrCd("1Q");
			conditionVO.setFRlaneCd("");
			vvdCnt = dbDao.searchQtaAdjustmentListCnt(conditionVO);
			if(vvdCnt.equals("0")) {
				//1) SQM_QTA_TGT_VVD -> SQM_SPCL_TGT_VVD
				dbDao.createSqmQtaTgtVvdTrans(conditionVO, usrId);
			}
			//2) SQM_SPCL_TGT_VVD -> SQM_SPCL_CFM_QTA
			istCnt = dbDao.createKpiCreationEditTrans(conditionVO, usrId);
			if(istCnt.equals("0")){
				throw new EventException(new ErrorHandler("SQM00003").getMessage());
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);
			else
				throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return istCnt;
	}

	/**
	 * ESM_SQM_0505 : [SEARCH]<br>
	 * [KPI Creation & Edit New Lane Add History]을 [조회]합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclNewLaneVO>
	 * @exception EventException
	 */
	public List<SqmSpclNewLaneVO> searchKpiCreationEditNewLaneHis(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchKpiCreationEditNewLaneHis(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0505 : [MULTI]<br>
	 * [KPI Creation & Edit New Lane Add]을 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createKpiCreationEditNewLane(ConditionVO conditionVO, String usrId) throws EventException{
		String istCnt = null;
		try {

			// RF, SPCL 각각 노선을 등록하기 때문에 공통으로 사용하는 VVD가 입력된것이 있는지 확인
			if ( dbDao.searchQtaAdjustmentListCnt(conditionVO).equals("0") ) {		// Data 존재 여부 확인
				//1) MAS_MON_VVD -> SQM_SPCL_TGT_VVD VVD Insert
				dbDao.createKpiCreationEditNewLaneTgtVvd(conditionVO, usrId);
			}
			//2) SQM_SPCL_CFM_QTA -> SQM_SPCL_NEW_LANE에 DATA 생성
			dbDao.createKpiCreationEditNewLaneSpclNewLane(conditionVO, usrId);
			//3) SQM_SPCL_CFM_QTA에 SQM_SPCL_TGT_VVD와 SQM_SPCL_NEW_LANE조인하여 Insert
			istCnt = dbDao.createKpiCreationEditNewLane(conditionVO, usrId);
			if(istCnt.equals("0")){
				throw new EventException(new ErrorHandler("SQM00003").getMessage());
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);
			else
				throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return istCnt;
	}

	/**
	 * ESM_SQM_0505 : [SEARCH01]<br>
	 * [KPI Creation & Edit New Lane Add] 팝업 내 New Lane 입력시 Bound를 [조회]합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchNewLaneAddBound(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchNewLaneAddBound(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0506 : [SEARCH]<br>
	 * [KPI Creation & Edit New Office Add History]을 [조회]합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiCreationEditNewOfcHisVO>
	 * @exception EventException
	 */
	public List<SearchKpiCreationEditNewOfcHisVO> searchKpiCreationEditNewOfcHis(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchKpiCreationEditNewOfcHis(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0506 : [MULTI]<br>
	 * [KPI Creation & Edit New Office]을 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param SqmSpclNewOfcVO[] sqmSpclNewOfcVOS
	 * @param String usrId
	 * @throws EventException
	 */
	public void createKpiCreationEditNewOfc(ConditionVO conditionVO, SqmSpclNewOfcVO[] sqmSpclNewOfcVOS, String usrId) throws EventException{
		try {
			List<SqmSpclNewOfcVO> insertVoList = new ArrayList<SqmSpclNewOfcVO>();
			List<SqmSpclNewOfcVO> updateVoList = new ArrayList<SqmSpclNewOfcVO>();

			for ( int i=0; i<sqmSpclNewOfcVOS .length; i++ ) {
				sqmSpclNewOfcVOS[i].setCreUsrId(usrId);
				sqmSpclNewOfcVOS[i].setUpdUsrId(usrId);
				sqmSpclNewOfcVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmSpclNewOfcVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmSpclNewOfcVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmSpclNewOfcVOS[i].setSpclTgtCd(conditionVO.getFSpclTgtCd());

				if ( sqmSpclNewOfcVOS[i].getIbflag().equals("I")){
					insertVoList.add(sqmSpclNewOfcVOS[i]);
				}
				if ( sqmSpclNewOfcVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmSpclNewOfcVOS[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				//1) SQM_SPCL_NEW_OFC Insert
				dbDao.insertKpiCreationEditNewOfc(insertVoList);
				//2) SQM_SPCL_CFM_QTA Insert
				dbDao.insertKpiCreationEditNewOfcCfmQta(conditionVO, insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				//1) SQM_SPCL_NEW_OFC Update
				dbDao.updateKpiCreationEditNewOfc(updateVoList);
				//2) SQM_SPCL_CFM_QTA Insert
				dbDao.insertKpiCreationEditNewOfcCfmQta(conditionVO, updateVoList);
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
	 * ESM_SQM_0508 : [SEARCH]<br>
	 * [Current KPI Report]을 [조회]합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @return List<SearchCurrentKpiReportVO>
	 * @exception EventException
	 */
	public List<SearchCurrentKpiReportVO> searchCurrentKpiReport(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.searchCurrentKpiReport(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0508 : [SEARCH02]<br>
	 * [Current KPI Report]을 [조회]합니다. (PreviousVersion)<br>
	 *
	 * @param ConditionVO conditionVO
	 * @return List<SearchCurrentKpiReportVO>
	 * @exception EventException
	 */
	public List<SearchCurrentKpiReportVO> searchCurrentKpiReportPreviousVersion(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCurrentKpiReportPreviousVersion(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0507 : Retrieve 이벤트 처리<br>
	 * [SKD Adjustment by VVD]을 [조회] 합니다.
	 *
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> searchQtaAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchQtaAdjustmentListVO> list = new ArrayList<SearchQtaAdjustmentListVO>();
			String fCondTp = "";
			String fBseYr = conditionVO.getFBseYr();
//			String fCrnBseYr = conditionVO.getFCrntBseYr();
//			String fBseQtrCd = conditionVO.getFBseQtrCd();
//			String fCrntQtaCd = conditionVO.getFCrntQtaCd();
			String fRlaneCd = conditionVO.getFRlaneCd();
			conditionVO.setFRlaneCd("");
			if ( !dbDao.searchQtaAdjustmentListCnt(conditionVO).equals("0") ) {		// Data 존재 여부 확인
				conditionVO.setFRlaneCd(fRlaneCd);
				// 조회 년도가 2013일 경우 SQM_SPCL_TGT_VVD 아닐 경우 SQM_QTA_LANE_OFC 테이블을 탐.
				if(fBseYr.equals("2013")){
					fCondTp = "0";
				}else{
					fCondTp = "1";
				}
				list = dbDao.searchQtaAdjustmentList(conditionVO, account.getOfc_cd(), fCondTp);
			}

			return list;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0507 : MULTI 이벤트 처리<br>
	 * [SKD Adjustment by VVD]을 [생성] 합니다.
	 *
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaAdjustment(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<ManageQtaAdjustmentVO> insertVoList = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> deleteVoList = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList2 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList3 = new ArrayList<ManageQtaAdjustmentVO>();

			for ( int i=0; i<manageQtaAdjustmentVOS .length; i++ ) {
				manageQtaAdjustmentVOS[i].setFBseTpCd(conditionVO.getFBseTpCd());
				manageQtaAdjustmentVOS[i].setFBseYr(conditionVO.getFBseYr());
				manageQtaAdjustmentVOS[i].setFBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaAdjustmentVOS[i].setFQtaTgtCd(conditionVO.getFQtaTgtCd());
				manageQtaAdjustmentVOS[i].setFTrdCd(manageQtaAdjustmentVOS[i].getTrdCd());
				manageQtaAdjustmentVOS[i].setFDirCd(manageQtaAdjustmentVOS[i].getDirCd());
				manageQtaAdjustmentVOS[i].setFUsrId(account.getUsr_id());
				manageQtaAdjustmentVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				manageQtaAdjustmentVOS[i].setBseYr(conditionVO.getFBseYr());
				manageQtaAdjustmentVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaAdjustmentVOS[i].setQtaTgtCd(conditionVO.getFQtaTgtCd());
				manageQtaAdjustmentVOS[i].setUsrId(account.getUsr_id());
				manageQtaAdjustmentVOS[i].setAdjVvd(manageQtaAdjustmentVOS[i].getAdjVvd().equals("1")?"Y":"N");

				if ( manageQtaAdjustmentVOS[i].getIbflag().equals("I") ) {
					insertVoList.add(manageQtaAdjustmentVOS[i]);
				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("D") ) {
					deleteVoList.add(manageQtaAdjustmentVOS[i]);
				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("U") ) {
					if (manageQtaAdjustmentVOS[i].getMasFnlBsaCapa().equals("0")) {
						// BSA가 0으로 변경되는 경우
						updateVoList2.add(manageQtaAdjustmentVOS[i]);
					} else if (manageQtaAdjustmentVOS[i].getAdjVvd().equals("Y")){
						updateVoList3.add(manageQtaAdjustmentVOS[i]);
					} else{
						updateVoList.add(manageQtaAdjustmentVOS[i]);
					}
				}
			}
			// 신규
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpclTgtVvd(insertVoList);
				dbDao.addSpclCfmQta(insertVoList);
			}
			// Month, Week, BSA(0은 제외)
			if ( updateVoList.size() > 0 ) {
				dbDao.updateSpclTgtVvd(updateVoList);
			}
			// BSA가 0으로 변경되는 경우
			if ( updateVoList2.size() > 0 ) {
				dbDao.updateSpclTgtVvd(updateVoList2);
				dbDao.updateSpclQtaZero(updateVoList2);
			}
			// 삭제
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpclCfmQta(deleteVoList);
				dbDao.removeSpclTgtVvd(deleteVoList);
			}
			// Adjusting VVD Select 체크하고 Copy VVD 넣을 경우
			if ( updateVoList3.size() > 0 ) {
				//먼저 삭제
				dbDao.removeSpclTgtVvd(updateVoList3);
				dbDao.removeSpclCfmQta(updateVoList3);
				//삽입
				dbDao.addSpclTgtVvd(updateVoList3);
				dbDao.addSpclCfmQta(updateVoList3);
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
	 * ESM_SQM_0509 : [SEARCH]<br>
	 * [Reefer/Special Type/Size Master]을 [조회]합니다.
	 *
	 * @param ConditionVO conditionVO
	 * @return List<SearchReeferSpclTpSzMgmtVO>
	 * @exception EventException
	 */
	public List<SearchReeferSpclTpSzMgmtVO> searchReeferSpclTpSzMgmt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchReeferSpclTpSzMgmt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0509 : [SAVE]<br>
	 * [Reefer/Special Type/Size Master]을 [저장]합니다.
	 * 
	 * @param SearchReeferSpclTpSzMgmtVO[] searchReeferSpclTpSzMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageReeferSpclTpSzMgmt(SearchReeferSpclTpSzMgmtVO[] searchReeferSpclTpSzMgmtVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SearchReeferSpclTpSzMgmtVO> insertVoList = new ArrayList<SearchReeferSpclTpSzMgmtVO>();
			List<SearchReeferSpclTpSzMgmtVO> updateVoList = new ArrayList<SearchReeferSpclTpSzMgmtVO>();
			
			for ( int i=0; i<searchReeferSpclTpSzMgmtVOS .length; i++ ) {        
				searchReeferSpclTpSzMgmtVOS[i].setCreUsrId(account.getUsr_id());
				searchReeferSpclTpSzMgmtVOS[i].setUpdUsrId(account.getUsr_id()); 
				if ( searchReeferSpclTpSzMgmtVOS[i].getIbflag().equals("I")){
					insertVoList.add(searchReeferSpclTpSzMgmtVOS[i]);
				}else if ( searchReeferSpclTpSzMgmtVOS[i].getIbflag().equals("U")){
					updateVoList.add(searchReeferSpclTpSzMgmtVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addReeferSpclTpSzMgmt(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateReeferSpclTpSzMgmt(updateVoList);
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
}