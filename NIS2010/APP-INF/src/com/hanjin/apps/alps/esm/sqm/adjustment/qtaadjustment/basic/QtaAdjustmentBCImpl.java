/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaAdjustmentBCImpl.java
*@FileTitle      : QtaAdjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.04.04
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.05.30 SQM USER
* 1.0 Creation
* 2013.10.21 PEJ [CHM-201327263] Figure Inquiry  조회 팝업 추가
*                        searchPotnFigureInquiryList 메소드 추가
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
* 2013.12.27 이혜민 선조치 SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
* 2014.01.06 박은주 [CHM-201428374] QTA Adjustment by VVD 화면내 신규 칼럼 추가 및 Creation 로직 수정
* 2014.01.16 박은주 [선조치] Allocation = QTA Adjustment 의 Apply 시 적용한 VVD 중 Allocation 정보가 반영되지 않은 Office 들에 대해서
*                                     Load = 0, Status = A 로 변경시켜 주는 로직 추가
* 2014.03.25 이혜민 [CHM-201429614-01] KPI Management => SKD Adjustment by VVD 화면 검색조건 로직 수정
* 2014.09.25 이혜민 [CHM-201431935] Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert.
* 2015.01.22 이혜민 [CHM-201533664] Allocation = QTA Apply시 Planned Load 기준 수정
* 2015.02.23 이혜민 [CHM-201534159] Alloc = QTA 화면 내 Alloc Delete 기능 추가
* 2015.02.27 이혜민 [CHM-201533807] Adjust 화면 내 조회 로직 변경 (Week 기준 => Revenue Month 기준)
* 2015.05.15 이혜민 [CHM-201535563] Portion Adjustment 화면 내 Figure Inquiry H/O와 RHQ로 분리
* 2015.05.15 이혜민 [CHM-201535608] Adjustment 화면 3개 Creation전 RHQ별 Portion 존재하고, 
									Office portion이 없는 List 조회.
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.07.22 김용습 [CHM-201537172] [CSR 전환건] QTA Adjustment by VVD 화면 내 신규 기능 추가
* 2015.10.01 김용습 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
* 2015.10.06 김용습 [CHM-201538196] Portion Adjustment by RHQ, Head Office 화면 내 해당 분기 값만 입력 가능토록 Validation 설정
* 2015.10.29 김용습 [CHM-201538492] [CSR 전환건] QTA Adjustment by VVD for IAS Sector 화면 보완 (Adjusting VVD Select, BSA Flag 칼럼 추가)
* 2015.12.09 김용습 [CHM-201539254] VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.
* 2016.01.15 CHM-201639770 VVD Adjustment의 Update Option 추가 CSR
* 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
* 2016.03.23 CHM-201640708 Office별 포션 자동 입력 로직 수정
* 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.05.09 CHM-201641249 Portion Adjustment by RHQ의 시스템 처리 순서를 Update -> Insert 로 변경
* 2016.07.15 CHM-201642546 Allocation = QTA Adjustment 화면 Office Add 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration.QtaAdjustmentDBDAO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaEditIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchAllocQtaListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnFigureInquiryListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaAdjustmentForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.hanjin.apps.alps.esm.sqm.common.SQMUtil;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmAlocQtaVO;
import com.hanjin.syscommon.common.table.SqmCfmQtaVO;
import com.hanjin.syscommon.common.table.SqmSctrCfmQtaVO;


/**
 * ALPS-QtaAdjustment Business Logic Command Interface<br>
 * - ALPS-QtaAdjustment 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
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
	 * ESM_SQM_0031 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> searchQtaAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			String fCondTp = "";
			String fBseYr = conditionVO.getFBseYr();
//			String fCrnBseYr = conditionVO.getFCrntBseYr();
//			String fBseQtrCd = conditionVO.getFBseQtrCd();
//			String fCrntQtaCd = conditionVO.getFCrntQtaCd();
			// 조회 년도가 2013일 경우 SQM_SPCL_TGT_VVD 아닐 경우 SQM_QTA_LANE_OFC 테이블을 탐.
			if(fBseYr.equals("2013")){
				fCondTp = "0";
			}else{
				fCondTp = "1";
			}
			return dbDao.searchQtaAdjustmentList(conditionVO, account.getOfc_cd(), fCondTp);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0031 : SEARCH03 이벤트 처리<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> findVvdFromOtherQuarter(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
//			String fCondTp = "";
//			String fBseYr = conditionVO.getFBseYr();
//			String fCrnBseYr = conditionVO.getFCrntBseYr();
//			String fBseQtrCd = conditionVO.getFBseQtrCd();
//			String fCrntQtaCd = conditionVO.getFCrntQtaCd();
			// 조회 년도가 2013일 경우 SQM_SPCL_TGT_VVD 아닐 경우 SQM_QTA_LANE_OFC 테이블을 탐.
//			if(fBseYr.equals("2013")){
//				fCondTp = "0";
//			}else{
//				fCondTp = "1";
//			}
			return dbDao.findVvdFromOtherQuarter(conditionVO, account.getOfc_cd());
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SQM_0031 : COMMAND02 이벤트 처리<br>
	 * [QTA Adjustment by VVD]와 [Portion adjustment by Head Office]와의 결과 비교
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> comparisonWithHo(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			String fCondTp = "";
			String fBseYr = conditionVO.getFBseYr();
//			String fCrnBseYr = conditionVO.getFCrntBseYr();
//			String fBseQtrCd = conditionVO.getFBseQtrCd();
//			String fCrntQtaCd = conditionVO.getFCrntQtaCd();
			// 조회 년도가 2013일 경우 SQM_SPCL_TGT_VVD 아닐 경우 SQM_QTA_LANE_OFC 테이블을 탐.
			if(fBseYr.equals("2013")){
				fCondTp = "0";
			}else{
				fCondTp = "1";
			}
			
			return dbDao.comparisonWithHo(conditionVO, account.getOfc_cd(), fCondTp);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0031 : COMMAND03 이벤트 처리<br>
	 * [QTA Adjustment by VVD]와 [Portion adjustment by RHQ]와의 결과 비교
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> comparisonWithRhq(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			String fCondTp = "";
			String fBseYr = conditionVO.getFBseYr();
//			String fCrnBseYr = conditionVO.getFCrntBseYr();
//			String fBseQtrCd = conditionVO.getFBseQtrCd();
//			String fCrntQtaCd = conditionVO.getFCrntQtaCd();
			// 조회 년도가 2013일 경우 SQM_SPCL_TGT_VVD 아닐 경우 SQM_QTA_LANE_OFC 테이블을 탐.
			if(fBseYr.equals("2013")){
				fCondTp = "0";
			}else{
				fCondTp = "1";
			}
			
			return dbDao.comparisonWithRhq(conditionVO, account.getOfc_cd(), fCondTp);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0031 : MULTI 이벤트 처리<br>
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
//			List<ManageQtaAdjustmentVO> insertVoList2 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> insertVoList3 = new ArrayList<ManageQtaAdjustmentVO>();
//			List<ManageQtaAdjustmentVO> updateVoList1 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList2 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList3 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList4 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList5 = new ArrayList<ManageQtaAdjustmentVO>();
			
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
//						if ( manageQtaAdjustmentVOS[i].getSplPotn().equals("1") ) {
//							// 신규 이면서 Copy VVD 를 선택 - Supply Portion 적용
//							insertVoList2.add(manageQtaAdjustmentVOS[i]);
//						} else {
							// 신규 이면서 Copy VVD 를 선택 - Supply Portion 미적용
							insertVoList3.add(manageQtaAdjustmentVOS[i]);
//						}
					}
					
				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("D") ) {
					deleteVoList.add(manageQtaAdjustmentVOS[i]);
					
				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("U") ) {
//					if ( manageQtaAdjustmentVOS[i].getSplPotn().equals("1") ) {
//						// BSA 와 LOD, REV 같이 변경된 경우 - Supply Portion 적용
//						updateVoList1.add(manageQtaAdjustmentVOS[i]);
//					} else {
						if ( manageQtaAdjustmentVOS[i].getFlag().equals("C") ||  manageQtaAdjustmentVOS[i].getFlag().equals("B") ) {
							// WEEK, MON, BSA 와 LOD, REV 같이 변경된 경우 - Supply Portion 미적용
							updateVoList2.add(manageQtaAdjustmentVOS[i]);
						} else if( manageQtaAdjustmentVOS[i].getFlag().equals("C2") ){ 
							// Sales YRMON와 LOD, REV 같이 변경된 경우 - Supply Portion 미적용 (SQM_CFM_TGT_VVD_ADJ insert 제외. 히스토리를 남기지 않음.)
							updateVoList4.add(manageQtaAdjustmentVOS[i]);	
						} else if( manageQtaAdjustmentVOS[i].getFlag().equals("Y") ){ 
							// Sales YRMON 만 변경된 경우(SQM_CFM_TGT_VVD_ADJ insert 제외. 히스토리를 남기지 않음.)
							updateVoList5.add(manageQtaAdjustmentVOS[i]);
						} else {
							// WEEK, MON, BSA 만 변경된 경우
							updateVoList3.add(manageQtaAdjustmentVOS[i]);
						}
//					}
				}
			}
			
			// 신규 이나 Copy VVD 를 선택 안함
			if ( insertVoList1.size() > 0 ) {
				dbDao.addCfmTgtVvd(insertVoList1);
				dbDao.addCfmQta(insertVoList1);
				dbDao.addCfmTgtVvdAdj(insertVoList1);
			}
			
//			// 신규 이면서 Copy VVD 를 선택 - Supply Portion 적용
//			if ( insertVoList2.size() > 0 ) {
//				dbDao.copyCfmTgtVvd(insertVoList2);
//				dbDao.copyCfmQta(insertVoList2);
//				dbDao.updateCfmQta(insertVoList2);
//				dbDao.updateCfmTgtVvdSmry(insertVoList2);
//				dbDao.addCfmTgtVvdAdj(insertVoList2);
//			}
			
			// 신규 이면서 Copy VVD 를 선택 - Supply Portion 미적용
			if ( insertVoList3.size() > 0 ) {
				dbDao.copyCfmTgtVvd(insertVoList3);
				dbDao.copyCfmQta(insertVoList3);
				dbDao.addCfmTgtVvdAdj(insertVoList3);
			}
			
//			// BSA 와 LOD, REV 같이 변경된 경우 - Supply Portion 적용
//			if ( updateVoList1.size() > 0 ) {
//				dbDao.updateCfmTgtVvd(updateVoList1);
//				dbDao.updateCfmQta(updateVoList1);
//				dbDao.updateCfmTgtVvdSmry(updateVoList1);
//				dbDao.addCfmTgtVvdAdj(updateVoList1);
//			}
			
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
			
			// Sales YRMON와 LOD, REV 같이 변경된 경우 - Supply Portion 미적용
			if ( updateVoList4.size() > 0 ) {
				dbDao.updateCfmTgtVvd(updateVoList4);
				dbDao.removeCfmQta(updateVoList4);
				dbDao.addCfmQta(updateVoList4);
			}
			
			// Sales YRMON 만 변경된 경우
			if ( updateVoList5.size() > 0 ) {
				dbDao.updateCfmTgtVvd(updateVoList5);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCfmQta(deleteVoList);
				dbDao.removeCfmQtaForSector2(deleteVoList); // SECTOR쪽과 SYNC를 위해 추가, 20163Q데이터부터 적용되게 함
				dbDao.removeCfmTgtVvd(deleteVoList);
				dbDao.addCfmTgtVvdAdj(deleteVoList);
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
	 * ESM_SQM_0031 : MULTI01 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [저장] 합니다.
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void saveSupply(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		
		try {
			List<ManageQtaAdjustmentVO> updateVoList = new ArrayList<ManageQtaAdjustmentVO>();
			
			for ( int i=0; i<manageQtaAdjustmentVOS .length; i++ ) {
			updateVoList.add(manageQtaAdjustmentVOS[i]);
			}
			
			dbDao.saveSupply(updateVoList);

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
	 * ESM_SQM_0031,0032,0033 : Creation 이벤트 처리<br>
	 * Adjustment화면에서 Creation 전 RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOfcZeroPortion(ConditionVO conditionVO) throws EventException {
		try {
			List<String> OfcZeroPortion = dbDao.searchOfcZeroPortion(conditionVO);
			return OfcZeroPortion;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0032 : [이벤트]<br>
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
	 * ESM_SQM_0032 : [이벤트]<br>
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
				
				// !"02" Portion Adjustment by RHQ
				if(!"02".equals(conditionVO.getFQtaStepCd())){
					
					if("O".equals(conditionVO.getFObDivCd())){
						if("L".equals(conditionVO.getFOfcVwCd()))
							searchPotnAdjustmentListVOS[i].setQtaStepCd("03"); // Loading O/B
						else
							searchPotnAdjustmentListVOS[i].setQtaStepCd("05"); // Contract O/B
					}else{
						searchPotnAdjustmentListVOS[i].setQtaStepCd("04");// Contract N.O/B
					}
					
				}else{ // "02" Portion Adjustment by HO
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
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addPotnAdjustment(insertVoList);
//			} // update부터 처리되도록 하기 위해 insert 부분을 update 아래로 넘김
			if ( updateVoList.size() > 0 ) {
				dbDao.updatePotnAdjustment(updateVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addPotnAdjustment(insertVoList);
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
	 * ESM_SQM_0032 : MULTI02 이벤트 처리<br>
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
	 * ESM_SQM_0032 : SEARCH01 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd의 주차를 [조회] 합니다.
	 * [Portion Adjustment by RHQ]에서 vvd의 주차를 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String vvd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchApplyWeek(ConditionVO conditionVO, String vvd) throws EventException {
		try {
			return dbDao.searchApplyWeek(conditionVO,vvd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0032 : SEARCH02 이벤트 처리<br>
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
	 * ESM_SQM_0032 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createPotnAdjustmentByHO(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
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
	 * ESM_SQM_0033 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createPotnAdjustmentByRHQ(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removePotnAdjustment(conditionVO, account);
			dbDao.createPotnAdjustment(conditionVO, account);
			dbDao.removePotnAdjustmentAgain(conditionVO, account); // 아래 create 로직을 한번더 태우기 위해 remove 한번 더 태움
			dbDao.createPotnAdjustmentHo(conditionVO, account); // 이 create 로직까지 태워야 portion adjustment by rhq에서 데이터 수정되었을 때 portion adjustment by ho의 배분까지 계산되어 들어감
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}   
	}
	
	/**
	 * ESM_SQM_0034 : Retrieve 이벤트 처리<br>
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
	 * ESM_SQM_0034 : MULTI 이벤트 처리<br>
	 * [Qta Edit]을을 [저장] 합니다.
	 * 
	 * @param SqmCfmQtaVO[] sqmCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEdit(SqmCfmQtaVO[] sqmCfmQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmCfmQtaVO> updateVoList = new ArrayList<SqmCfmQtaVO>();
			List<SqmCfmQtaVO> updateStsVoList = new ArrayList<SqmCfmQtaVO>();
			String oldS = "";
			String newS = "";
			
			for ( int i=0; i<sqmCfmQtaVOS .length; i++ ) {
				if(sqmCfmQtaVOS[i].getOfcVwCd().equals("LOADING")){
					sqmCfmQtaVOS[i].setOfcVwCd("L");
				} else {
					sqmCfmQtaVOS[i].setOfcVwCd("C");
				}
				sqmCfmQtaVOS[i].setCreUsrId(account.getUsr_id());
				sqmCfmQtaVOS[i].setUpdUsrId(account.getUsr_id()); 
				newS = sqmCfmQtaVOS[i].getTrdCd()+sqmCfmQtaVOS[i].getRlaneCd()+sqmCfmQtaVOS[i].getDirCd()
				+ sqmCfmQtaVOS[i].getVslCd()+ sqmCfmQtaVOS[i].getSkdVoyNo()+ sqmCfmQtaVOS[i].getSkdDirCd() ;
				
				if(!oldS.equals(newS)){
					updateStsVoList.add(sqmCfmQtaVOS[i]);
				}
				
				if ( sqmCfmQtaVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmCfmQtaVOS[i]);
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
	 * ESM_SQM_0034 : MULTI01 이벤트 처리<br>
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
	 * ESM_SQM_0035 : Retrieve 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAllocQtaListVO>
	 * @throws EventException
	 */
	public List<SearchAllocQtaListVO> searchAllocQtaList(ConditionVO conditionVO) throws EventException{
		try {
			return dbDao.searchAllocQtaList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0035 : MULTI 이벤트 처리<br>
	 * [Allocation = QTA Setting]을을 [저장] 합니다.
	 * 
	 * @param SqmAlocQtaVO[] sqmAlocQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAllocQta(SqmAlocQtaVO[] sqmAlocQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmAlocQtaVO> updateVoList = new ArrayList<SqmAlocQtaVO>();
			List<SqmAlocQtaVO> insertVoList = new ArrayList<SqmAlocQtaVO>();
			
			for ( int i=0; i<sqmAlocQtaVOS .length; i++ ) {    
				sqmAlocQtaVOS[i].setCreUsrId(account.getUsr_id());
				sqmAlocQtaVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if(sqmAlocQtaVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmAlocQtaVOS[i]);
				}

				if(sqmAlocQtaVOS[i].getIbflag().equals("I")){
					insertVoList.add(sqmAlocQtaVOS[i]);
				}
			}	
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateAllocQta(updateVoList);
//				dbDao.updateQtaEditForAlloc(updateVoList);
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addAllocQta(insertVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0035 : MULTI01 이벤트 처리<br>
	 * [Allocation = QTA Setting]을을 [confirm] 합니다.
	 * 
	 * @param SqmAlocQtaVO[] sqmAlocQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEditForAlloc(SqmAlocQtaVO[] sqmAlocQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmAlocQtaVO> updateVoList = new ArrayList<SqmAlocQtaVO>();
			List<SqmAlocQtaVO> stsVoList = new ArrayList<SqmAlocQtaVO>();
			
			String pre_vvd = "";
			String cur_vvd = "";
			for ( int i=0; i<sqmAlocQtaVOS .length; i++ ) {    
				sqmAlocQtaVOS[i].setCreUsrId(account.getUsr_id());
				sqmAlocQtaVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if(sqmAlocQtaVOS[i].getIbflag().equals("U")){
					
					updateVoList.add(sqmAlocQtaVOS[i]);
					cur_vvd = sqmAlocQtaVOS[i].getVslCd() + sqmAlocQtaVOS[i].getSkdVoyNo() + sqmAlocQtaVOS[i].getDirCd();
					// 상태변경을 위해서
					if (!pre_vvd.equals(cur_vvd) ) {
						stsVoList.add(sqmAlocQtaVOS[i]);
						pre_vvd = sqmAlocQtaVOS[i].getVslCd() + sqmAlocQtaVOS[i].getSkdVoyNo() + sqmAlocQtaVOS[i].getDirCd();
					}
					
				}
			}	
			
			if ( updateVoList.size() > 0 ) {
				//Apply 당시 SQM_CFM_QTA 테이블의 LOD_QTY를 SQM_ALOC_QTA 테이블의 CFM_LOD_QTY 에 넣음
				dbDao.updateCfmQtaLodToAlocQta(updateVoList);
				// 확정데이터를 업데이트 한다
				dbDao.updateQtaEditForAlloc(updateVoList);
			}	
			// Alloc 정보의 상태를 변경한다
			if (stsVoList.size() > 0 ) {
				// 확정 쿼타에 반영된 Office에 대해서 Alloc 상태를 변경한다.
				dbDao.updateAllocForStaus(stsVoList);
				// Alloc 에서 반영이 안된 Office
				dbDao.updateCfmQtaZeroStatus(stsVoList);
			}
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0035 : MULTI02 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [delete] 합니다.
	 * 
	 * @param SqmAlocQtaVO[] sqmAlocQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void deleteQtaEditForAlloc(SqmAlocQtaVO[] sqmAlocQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmAlocQtaVO> stsVoList = new ArrayList<SqmAlocQtaVO>();
			
			String pre_vvd = "";
			String cur_vvd = "";
			for ( int i=0; i<sqmAlocQtaVOS .length; i++ ) {    
				
				if(sqmAlocQtaVOS[i].getIbflag().equals("U")){
					cur_vvd = sqmAlocQtaVOS[i].getVslCd() + sqmAlocQtaVOS[i].getSkdVoyNo() + sqmAlocQtaVOS[i].getDirCd();
					if (!pre_vvd.equals(cur_vvd) ) {
						stsVoList.add(sqmAlocQtaVOS[i]);
						pre_vvd = sqmAlocQtaVOS[i].getVslCd() + sqmAlocQtaVOS[i].getSkdVoyNo() + sqmAlocQtaVOS[i].getDirCd();
					}
				}
			}	
			// 선택된 VVD를 삭제
			if (stsVoList.size() > 0 ) {
				dbDao.deleteQtaEditForAlloc(stsVoList);
			}
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0035 : MULTI03 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [activate] 합니다.
	 * 
	 * @param SqmAlocQtaVO[] sqmAlocQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void activateData(SqmAlocQtaVO[] sqmAlocQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmAlocQtaVO> updateVoList = new ArrayList<SqmAlocQtaVO>();
			List<SqmAlocQtaVO> stsVoList = new ArrayList<SqmAlocQtaVO>();
			
			String pre_vvd = "";
			String cur_vvd = "";
			for ( int i=0; i<sqmAlocQtaVOS .length; i++ ) {    
				sqmAlocQtaVOS[i].setCreUsrId(account.getUsr_id());
				sqmAlocQtaVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if(sqmAlocQtaVOS[i].getIbflag().equals("U")){
					
					updateVoList.add(sqmAlocQtaVOS[i]);
					cur_vvd = sqmAlocQtaVOS[i].getVslCd() + sqmAlocQtaVOS[i].getSkdVoyNo() + sqmAlocQtaVOS[i].getDirCd();
					// 상태변경을 위해서
					if (!pre_vvd.equals(cur_vvd) ) {
						stsVoList.add(sqmAlocQtaVOS[i]);
						pre_vvd = sqmAlocQtaVOS[i].getVslCd() + sqmAlocQtaVOS[i].getSkdVoyNo() + sqmAlocQtaVOS[i].getDirCd();
					}
					
				}
			}	
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateAppliedFlg(updateVoList);
			}	
			// Alloc 정보의 상태를 변경한다
			if (stsVoList.size() > 0 ) {
				dbDao.createCfmData(updateVoList);
			}
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * SPC ALOC 정보를 I/F.
	 * 
	 * @param String trd_cd
	 * @param String rlane_cd
	 * @param String vvd
	 * @param String usr_id
	 * @throws EventException
	 */
	public void manageSpcAlocIf(String trd_cd, String rlane_cd, String vvd, String usr_id) throws EventException{
		try {
			dbDao.manageSpcAlocIf(trd_cd, rlane_cd, vvd, usr_id);
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
	 * ESM_SQM_0043/ESM_SQM_0044 : Retrieve 이벤트 처리<br>
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
	 * ESM_SQM_0045 : Retrieve 이벤트 처리<br>
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
	 * ESM_SQM_0045 : Creation 이벤트 처리<br>
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
	 * ESM_SQM_0219 : Retrieve 이벤트 처리<br>
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
	 * ESM_SQM_0219 : Creation<br>
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
			List<ManageQtaAdjustmentVO> updateVoList3 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList4 = new ArrayList<ManageQtaAdjustmentVO>();
			List<ManageQtaAdjustmentVO> updateVoList5 = new ArrayList<ManageQtaAdjustmentVO>();
			
			for ( int i=0; i<manageQtaAdjustmentVOS .length; i++ ) {
				manageQtaAdjustmentVOS[i].setFBseTpCd(conditionVO.getFBseTpCd());
				manageQtaAdjustmentVOS[i].setFBseYr(conditionVO.getFBseYr());
				manageQtaAdjustmentVOS[i].setFBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaAdjustmentVOS[i].setFTrdCd("IAS");
				manageQtaAdjustmentVOS[i].setFQtaTgtCd("D");
				
				manageQtaAdjustmentVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				manageQtaAdjustmentVOS[i].setBseYr(conditionVO.getFBseYr());
				manageQtaAdjustmentVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				manageQtaAdjustmentVOS[i].setQtaTgtCd("D");
				manageQtaAdjustmentVOS[i].setFUsrId(account.getUsr_id());
				manageQtaAdjustmentVOS[i].setUsrId(account.getUsr_id());
				manageQtaAdjustmentVOS[i].setFClick(manageQtaAdjustmentVOS[i].getFClick().equals("1")?"Y":"N");
				manageQtaAdjustmentVOS[i].setAdjVvd(manageQtaAdjustmentVOS[i].getAdjVvd().equals("1")?"Y":"N");
				
				if ( manageQtaAdjustmentVOS[i].getIbflag().equals("I") ) {// 신규 VVD [ Copy VVD 를 선택]
						insertVoList.add(manageQtaAdjustmentVOS[i]);

				} else if ( manageQtaAdjustmentVOS[i].getIbflag().equals("U") ) {
					
					// WEEK, MON, BSA, Sales YRMON 가 변경된 경우 
					if ( manageQtaAdjustmentVOS[i].getVvd().equals(  manageQtaAdjustmentVOS[i].getMasVvd() )) {
						
						if( manageQtaAdjustmentVOS[i].getFlag().equals("Y") ){
							//Sales YRMON 만 변경된 경우 (SQM_CFM_TGT_VVD_ADJ insert 제외. 히스토리를 남기지 않음.)
							updateVoList3.add(manageQtaAdjustmentVOS[i]);
							
						} else {
							updateVoList1.add(manageQtaAdjustmentVOS[i]);
						}

						if(!manageQtaAdjustmentVOS[i].getPfGrpCd().equals(manageQtaAdjustmentVOS[i].getMasPfGrpCd()) 
								&& (!SQMUtil.getNvl(manageQtaAdjustmentVOS[i].getMasPfGrpCd(),"").equals(""))){
							//P/F SKD Group 이 변경되는 경우						
							updateVoList5.add(manageQtaAdjustmentVOS[i]);
						}

						
					}
					// QTA=0 이 체크되었을 경우
					if ( manageQtaAdjustmentVOS[i].getFClick().equals("Y")) {
						updateVoList2.add(manageQtaAdjustmentVOS[i]);
					} 
					// Adjusting VVD Select가 체크되었을 경우
					if ( manageQtaAdjustmentVOS[i].getAdjVvd().equals("Y") ) {
						updateVoList4.add(manageQtaAdjustmentVOS[i]);
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
				dbDao.removeCfmQta2(updateVoList2);
				dbDao.insertCfmQtaSync(updateVoList2);
			}
			
			// Sales YRMON 만 변경된 경우
			if ( updateVoList3.size() > 0 ) {
				dbDao.updateCfmTgtVvd(updateVoList3);
			}
			
			// 삭제 VVD
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCfmQta(deleteVoList);
				dbDao.removeCfmQtaForSector(deleteVoList);
				dbDao.removeCfmTgtVvd(deleteVoList);
				dbDao.addCfmTgtVvdAdj(deleteVoList);
			}
			
			// Adjusting VVD Select가 체크되었을 경우
			if ( updateVoList4.size() > 0 ) {
				dbDao.removeCfmQtaForSector(updateVoList4);
				dbDao.copyCfmQtaForSector(updateVoList4);
				dbDao.removeCfmQta2(updateVoList4);
				dbDao.insertCfmQtaSync(updateVoList4);
				dbDao.addCfmTgtVvdAdj(updateVoList4);
			}
			
			// P/F Group에 차이가 발생할 경우
			if ( updateVoList5.size() > 0 ) {
				dbDao.copyCfmQtaForSectorPFGroup(updateVoList5);
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
	 * ESM_SQM_0219 : SAVE<br>
	 * [QTA Adjustment by VVD For Sector]을 [저장]<br>
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void saveSupplyForSector(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<ManageQtaAdjustmentVO> updateVoList = new ArrayList<ManageQtaAdjustmentVO>();
			
			for ( int i=0; i<manageQtaAdjustmentVOS .length; i++ ) {
				updateVoList.add(manageQtaAdjustmentVOS[i]);
			}
			
			dbDao.saveSupply(updateVoList);
			
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
	 * ESM_SQM_0220 : Retrieve 이벤트 처리<br>
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
	 * ESM_SQM_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param SqmSctrCfmQtaVO[] sqmSctrCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEditIasSector(SqmSctrCfmQtaVO[] sqmSctrCfmQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmSctrCfmQtaVO> updateVoList = new ArrayList<SqmSctrCfmQtaVO>();
			String oldS = "";
			String newS = "";
			
			for ( int i=0; i<sqmSctrCfmQtaVOS .length; i++ ) {
				if(sqmSctrCfmQtaVOS[i].getOfcVwCd().equals("Loading")){
					sqmSctrCfmQtaVOS[i].setOfcVwCd("L");
				} else {
					sqmSctrCfmQtaVOS[i].setOfcVwCd("C");
				}
				sqmSctrCfmQtaVOS[i].setCreUsrId(account.getUsr_id());
				sqmSctrCfmQtaVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmSctrCfmQtaVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmSctrCfmQtaVOS[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateQtaEditIasSector(updateVoList);
			}
			
			for ( int j=0; j<sqmSctrCfmQtaVOS .length; j++ ) {
				sqmSctrCfmQtaVOS[j].setCreUsrId(account.getUsr_id());
				sqmSctrCfmQtaVOS[j].setUpdUsrId(account.getUsr_id()); 
				
				newS = sqmSctrCfmQtaVOS[j].getTrdCd()+sqmSctrCfmQtaVOS[j].getRlaneCd()+sqmSctrCfmQtaVOS[j].getDirCd()
						+ sqmSctrCfmQtaVOS[j].getRhqCd()+ sqmSctrCfmQtaVOS[j].getRgnOfcCd()
						+ sqmSctrCfmQtaVOS[j].getVslCd()+ sqmSctrCfmQtaVOS[j].getSkdVoyNo()+ sqmSctrCfmQtaVOS[j].getSkdDirCd() ;
				
				if(!oldS.equals(newS)){
					//SQM_CFM_QTA Delete (overall report에서 조회되도록)
					dbDao.removeCfmQtaIasSector(sqmSctrCfmQtaVOS[j]);
					//SQM_CFM_QTA Insert (overall report에서 조회되도록)
					dbDao.addCfmQtaIasSector(sqmSctrCfmQtaVOS[j]);
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
	 * ESM_SQM_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createCmcbAdjustIasSector(ConditionVO conditionVO, String usrId) throws EventException{
		try {
			dbDao.createCmcbAdjustIasSector(conditionVO, usrId);
			//SQM_CFM_QTA Delete (overall report에서 조회되도록)
			dbDao.removeCfmQtaIasSector2(conditionVO, usrId);
			//SQM_CFM_QTA Insert (overall report에서 조회되도록)
			dbDao.addCfmQtaIasSector2(conditionVO, usrId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0221 : Retrieve 이벤트 처리<br>
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
	 * ESM_SQM_0221 : CREATION<br>
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
			
			//SQM_CFM_QTA Delete (overall report에서 조회되도록)
			//dbDao.removeCfmQtaIasSector2(conditionVO, account.getUsr_id());
			//SQM_CFM_QTA Insert (overall report에서 조회되도록)
			//dbDao.addCfmQtaIasSector2(conditionVO, account.getUsr_id());
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0222 : Retrieve 이벤트 처리<br>
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
	 * ESM_SQM_0222 : CREATION<br>
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
			
			// 1. SQM_SCTR_ADD_TGT_VVD 저장
			dbDao.createQtaEditOfficeAddTargetVVD(conditionVO, insertVoList);
			// 2. Target VVD의 BSA Group capa를 설정한다.
			dbDao.updateQtaEditOfficeTargetVVDBSAGroup(conditionVO, insertVoList);
			// 3. CFM Target VVD 생성
			dbDao.createQtaEditOfficeAddSectorCfmTargetVVD(conditionVO, insertVoList);
			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.createQtaEditOfficeAddIasSector(insertVoList);
			}

			//SQM_CFM_QTA Delete (overall report에서 조회되도록)
			//dbDao.removeCfmQtaIasSector2(conditionVO, account.getUsr_id());
			//SQM_CFM_QTA Insert (overall report에서 조회되도록)
			//dbDao.addCfmQtaIasSector2(conditionVO, account.getUsr_id());
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0224 : Retrieve 이벤트 처리<br>
	 * [RBCCO PFMC = QTA Setting for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchRbccoPfmcQtaSetIasSector(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchRbccoPfmcQtaSetIasSector(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0224 : Apply 이벤트 처리<br>
	 * [RBCCO PFMC = QTA Setting for IAS Sector]을 [Apply] 합니다.
	 * 
	 * @param SearchQtaEditListVO[] searchQtaEditListVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRbccoPfmcQtaSetIasSector(SearchQtaEditListVO[] searchQtaEditListVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SearchQtaEditListVO> updateVoList = new ArrayList<SearchQtaEditListVO>();
			
			for ( int i=0; i<searchQtaEditListVOS .length; i++ ) {
				if(searchQtaEditListVOS[i].getOfcVwCd().equals("Loading")){
					searchQtaEditListVOS[i].setOfcVwCd("L");
				} else {
					searchQtaEditListVOS[i].setOfcVwCd("C");
				}
				searchQtaEditListVOS[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(searchQtaEditListVOS[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.manageRbccoPfmcQtaSetIasSector(updateVoList);
			}
			
		} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	
}