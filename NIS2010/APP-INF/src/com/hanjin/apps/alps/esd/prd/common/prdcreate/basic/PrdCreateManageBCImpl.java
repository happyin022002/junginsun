/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PrdCommonManageBCImpl.java
*@FileTitle : PRD 공통관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : jungsunyoung
*@LastVersion : 1.0 
* 2006-10-16 jungsunyoung
* 1.0 최초 생성
* history
* 081013 미주 IRG상 Route Plan 82/87번을 가진 Local Shuttle 운송에 대하여 Rail Company에 해당 Shuttle 운송계약이 
*  포함되어 있으므로 S/O Candidate 불가처리 추가  ,
*  csr : N200903190040 20090320 mixed term , tro i/o TERM 일때 TERM CHANGE처리 
*  2010.09.27 채창호 [CHM-201006116] : Mixed Term Logic 변경 요청
*  2011.06.17 변종건 [CHM-201111585-01] Container Size별 Empty Pick up CY Data에 대한 Hard Coding 요청.
*  2011.07.04 이수진 [CHM-201111709] PRD > Network Constraint 관련 data upload 및 기능개선 요청
* 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
*  2012.08.17 정선용 [CHM-201219664] [PRD] Canada 향 D7 CNTR BKG block 을 위한 Hard-coding 설정요청
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.common.PrdConstants;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.integration.PrdCreateManageDBDAO;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBC;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSubQuantityVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdTroInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PrdProdCtlRoutDtlVO;


/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCommonManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PrdCreateManageBCImpl   extends BasicCommandSupport implements PrdCreateManageBC {

	// Database Access Object
	private transient PrdCreateManageDBDAO dbDao=null;
	private transient ProductCatalogCreateDBDAO dbDaoLog = null;

	/**
	 * PrdCommonManageBCImpl 객체 생성<br>
	 * PrdCommonManageDBDAO를 생성한다.<br>
	 */
	public PrdCreateManageBCImpl(){
		dbDao = new PrdCreateManageDBDAO();
		dbDaoLog = new ProductCatalogCreateDBDAO();
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * PrdCommonManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}



	/**
	 * PrdCreateManageBCImpl's createPrdCtlNoGen (Alps)
	 * @param pcMode
	 * @return
	 * @throws EventException EventResponse
	 */
	public String createPrdCtlNoGen(String pcMode) throws EventException {
		int cnt= 0;
		String hdPctlNo = "";

		try {
			hdPctlNo =dbDao.createPrdCtlNoGenCop(pcMode);
		} catch (DAOException e) {
			log.error("createPrdCtlNoGen err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}
		log.debug("\n do while cnt  "+cnt+" , prdCtlNo:"+hdPctlNo+"prdCtlNo.length():"+hdPctlNo.length() );  // format 'B061205000000001' + XXXX
	
		if(hdPctlNo.length() < 16){
			log.debug("\n prd ctl no 생성 실패 !   prdCtlNo:"+hdPctlNo);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
		}
		
		return hdPctlNo;
	}
	
	/**
	 * @param e
	 * @throws EventException
	 */
	public void createActivityGroup(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdPcCreateVO prdPcCreateVo = event.getPrdPcCreateVO();
		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 
		
		try {
			dbDao.createActivityGroup(prdPcCreateVo.getHdPctlNo(), "A", account.getUsr_id());
		} catch (DAOException e1) {
			log.error("err "+e1.toString(),e1);
			throw new EventException(e1.getMessage());
		}
	}

	/**
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void  dataArrangement(Event e) throws EventException {
		try {
			
			EsdPrd0080Event event = (EsdPrd0080Event)e;
			PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
			PrdPcCreateVO prdPcCreateVo = event.getPrdPcCreateVO();
			//BKG Replan 시에 Ocean 구간 SO 를 확인하여 PC 를 filtering 한다. 07-07-23 sdkang
			//BKG Replan Filtering START
			
			/*
			 * lane 업데이트 
			 * PRD DTL 과 VSK_VSL_SKD의 vvd 가 같고  lane이 다르면 MDM_VSL_SVC_LANE 의 LANE으로 업데이트 
			 */
			updateLaneForFrd( prdPcCreateVo.getHdPctlNo() );
			
			/*
			 * skd 이 널인 데이터 삭제 
			 */
			//deletePrdDtlNotSkd( prdPcCreateVo.getHdPctlNo());
			
			/*
			 * 같은 (ocn rout, o/b, i/b) 를 사용한 라우트중 rank를 메겨 첫번째 것만 남기고 나머지 삭제  
			 */
			//deletePrdDtlByRank( prdPcCreateVo.getHdPctlNo() );
			
			/*
			 * 삭제된 DTL 의 PC를 QTY 에서도 삭제한다.
			 */
			//deletePrdQtyNotPcNo( prdPcCreateVo.getHdPctlNo() );
			
			/*
			 * 삭제된 DTL 의 PC를 MST 에서도 삭제한다.
			 */
			//deletePrdMstNotPcNo( prdPcCreateVo.getHdPctlNo() );
			
			/*
			 * prd mst 테이블의 total transit time을  업데이트한다.
			 * 아래 쿼리는 COA_SLANE_RLANE_CONV_FNC 에서 MULTI ROW 를 리턴할때 확인.
			 * SELECT * FROM          mdm_dtl_rev_lane
			 *	WHERE RLANE_CD  LIKE 'LL1%'
	         *    AND FM_CONTI_CD='E' AND TO_CONTI_CD='F'
			 */
			updatePrdMstTtlTztm ( prdPcCreateVo.getHdPctlNo(), prdCreateParamVO.getTVvd() );
			
			/*
			 * customer preference 관련은 alps 에서 제외
			 * 
			 * updatePrdDtlN1stVndrSeqOb (  )
			 * updatePrdDtlN1stVndrSeqIb (  )
			 */
			
			/*
			 * r_term 이 door 일때 O/B irg 외의 앞부분인 dummy link 의 trsp mod를 pctl_seq = 4 인 link 의 trsp mod를 copy 해준다. 
			 * 해당 logic은 ToBe에서 없어도 될 것으로 판단됨 by 조용인 20090923  
			 * (상기와 같은 경우 PRD 생성부분에서 TD로 하여 Setting함)
			 */
			
			//updatePrdDtlObTrspModDterm( prdPcCreateVo.getHdPctlNo() );
			/*
			 * r_term 이 door 일때 I/B irg    
			 */
			//updatePrdDtlIbTrspModDterm( prdPcCreateVo.getHdPctlNo() );
			
			/*
			 * prd mst에 constraint 정보를 업데이트 
			 */
			updatePrdMstRoutCnst(prdPcCreateVo.getHdPctlNo()); 
			
			/*
			 * prd Mst 에 rout cnst 정보 적용
			 * X : SVC_USE_FLG 가  'N' 일때 
			 * R : SVC_USE_FLG 가  'N' 이 아닐때
			 */
			updatePrdMstByRoutCnst(prdPcCreateVo.getHdPctlNo());
			
			/*
			 * prd Inland POD Management에 의해 정의된 값을 적용
			 * X : SVC_USE_FLG 가  'N' 일때 
			 * R : SVC_USE_FLG 가  'N' 이 아닐때
			 * 단 updatePrdMstByRoutCnst에 의해 X가 설정되어 있을 경우 X를 유지
			 */
			updatePrdMstByPodMgmtCnst(prdPcCreateVo.getHdPctlNo(), prdCreateParamVO.getBkgNo());

			/*
			 * prd Dtl 에 Link Cnst 정보 적용
			 * const 에 등록된 CNTR_TP_CD 와 CNTR_TPSZ_CD가 같은게 있으면 우선 적용  
			 * RD Column에 CHK 되어 있을때는 Error Message에 표시 되지 않은채로 PC 생성되어야 합니다.
			 */
			updatePrdDtlLnkCnst(prdPcCreateVo.getHdPctlNo(), prdCreateParamVO.getRdF()); 
			
			/*
			 * prd Dtl 에 node Cnst 정보 적용
			 */
			updatePrdDtlNodCnst(prdPcCreateVo.getHdPctlNo());
			
			
			/*
			 * 1. POL : ASIA,  POD : US%/CA%, DEL : CA%, Type/Size : D7인 모든 BKG 을 Block
			 * 2. Only CAVAN port/local 허용, 타 CA port 의 경우는(CAVAN등) Port/Local Block (Hard coding 이 필요한 부분)
			 */
		    log.debug("\n PRDCAD7===> "+dbDaoLog.getPrdLogOnOff("ESD_PRD_CAD7"));
			if(dbDaoLog.getPrdLogOnOff("ESD_PRD_CAD7").equalsIgnoreCase("Y")) {
				
				updatePrdMstCnstException(prdPcCreateVo.getHdPctlNo());  
			}
			
			/*
			 * prd Mst 의 cnst_flg 에 업데이트 
			 * X : MST의 CNST_FLG가 X 이거나 DLT의 LINK의 CNST_FLG가 X 이거나 ,DLT의 NODE의 CNST_FLG가 X 일때  
			 * A : MST의 CNST_FLG가 R 일때 (ROUT CNST가 있는데 SVC가 될때) DTL 의 LINK CNST_FLG가 L 이고, DTL의 NODE CNST_FLG가 가 N일때  
			 * O : MST의 CNST_FLG가 R 일때 (ROUT CNST가 있는데 SVC가 될때) DTL 의 LINK CNST_FLG가 L 일때  
			 * P : MST의 CNST_FLG가 R 일때 (ROUT CNST가 있는데 SVC가 될때) DTL 의 DTL의 NODE CNST_FLG 가 N일때
			 * R : MST의 CNST_FLG가 R 일때 (ROUT CNST가 있는데 SVC가 될때)
			 * I : LNK 의 CNST_FLG가 L일때 DTL의 NODE CNST_FLG가  N일때  
			 * L : LNK 의 CNST_FLG가 L일때
			 * N : DTL의 NODE CNST_FLG가  N일때  
			 */
			updatePrdMstCnstFlg(prdPcCreateVo.getHdPctlNo());  
			
			/*
			 * min, max pc no 
			 */
			DBRowSet dbR = selectPcNoMinMax(prdPcCreateVo.getHdPctlNo()); 
		
			if(dbR.next()){
				prdPcCreateVo.setMinPctlNo(dbR.getString("min_pc"));
				prdPcCreateVo.setMaxPctlNo(dbR.getString("max_pc"));
				log.debug("\n min pc:"+prdPcCreateVo.getMinPctlNo());
				log.debug("\n max pc:"+prdPcCreateVo.getMaxPctlNo());
				
				
			} 
//			else {
//				/*
//				* 상세 에러 메세지 처리 
//				*/
//			}
				
		} catch (SQLException e1) {
			log.error("updatePrdMstRoutCnst err "+e1.toString(),e1);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		} catch (EventException ee) {
			throw ee;
		} catch (Exception ex) {
			log.error("updatePrdMstRoutCnst err "+ex.toString(),ex);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
		}
			
		
	}
	
	/**
	 * @param String hdPctlNo
	 * @throws EventException
	 */
	private void updatePrdMstCnstException(String hdPctlNo) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updatePrdMstCnstException(hdPctlNo );
		} catch (DAOException e) {
			log.error("updatePrdMstCnstException err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		
	}

	/**
	 * PrdCreateManageBC's selectPcNoMinMax
	 * @param String hdPctlNo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet selectPcNoMinMax(String hdPctlNo) throws EventException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		try {
			dbR = dbDao.selectPcNoMinMax(hdPctlNo );
			
		} catch (DAOException e) {
			log.error("selectPcNoMinMax err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		return dbR;
	}

	private void updatePrdMstCnstFlg(String hdPctlNo) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updatePrdMstCnstFlg(hdPctlNo );
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		
	}

	private void updatePrdDtlNodCnst(String hdPctlNo) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updatePrdDtlNodCnst(hdPctlNo );
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		
	}

	private void updatePrdDtlLnkCnst(String hdPctlNo, String rdF) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updatePrdDtlLnkCnst(hdPctlNo, rdF);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		
	}

	private void updatePrdMstByRoutCnst(String hdPctlNo) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updatePrdMstByRoutCnst(hdPctlNo);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		
	}

	/**
	 * Inland Route POD Management에 의해 설정되는 PC Master Constraint를 설정
	 * @param hdPctlNo
	 * @param bkgNo
	 * @throws EventException
	 */
	private void updatePrdMstByPodMgmtCnst(String hdPctlNo, String bkgNo) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updatePrdMstByPodMgmtCnst(hdPctlNo, bkgNo);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		
	}

	private void updatePrdMstRoutCnst(String hdPctlNo) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updatePrdMstRoutCnst(hdPctlNo);
		} catch (DAOException e) {
			log.error("updatePrdMstRoutCnst err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		
	}

	/**
	 * 
	 * @param hdPctlNo
	 * @throws EventException
	 * @deprecated 소스 정리하고 있습니다. 사용하신다면 알려주세요 noh
	 */
//	private void updatePrdDtlIbTrspModDterm(String hdPctlNo) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			dbDao.updatePrdDtlIbTrspModDterm(hdPctlNo);
//		} catch (DAOException e) {
//			log.error("updatePrdMstTtlTztm err "+e.toString(),e);
//			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
//			
//		}	
//		
//	}

	 /**
	  *
	  * @param hdPctlNo
	  * @throws EventException
	  * @deprecated 소스 정리하고 있습니다. 사용하신다면 알려주세요 noh
	  */
//	private void updatePrdDtlObTrspModDterm(String hdPctlNo) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			dbDao.updatePrdDtlObTrspModDterm(hdPctlNo);
//		} catch (DAOException e) {
//			log.error("updatePrdMstTtlTztm err "+e.toString(),e);
//			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
//			
//		}	
//		
//	}

	private void updatePrdMstTtlTztm(String hdPctlNo, String tVvd) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updatePrdMstTtlTztm(hdPctlNo, tVvd );
		} catch (DAOException e) {
			log.error("updatePrdMstTtlTztm err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}	
		
	}

	/**
	 * (Alps)
	 * @param hdPctlNo
	 * @throws EventException
	 * @deprecated 소스 정리하고 있습니다. 사용하신다면 알려주세요 noh
	 */
//	private void deletePrdMstNotPcNo(String hdPctlNo)  throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			dbDao.deletePrdMstNotPcNo(hdPctlNo);
//		} catch (DAOException e) {
//			log.error("deletePrdDtlByRank err "+e.toString(),e);
//			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
//			
//		}	
//		
//	}

//	/**
//	 * (Alps)
//	 * @param hdPctlNo
//	 * @throws EventException
//	 * @deprecated 소스 정리하고 있습니다. 사용하신다면 알려주세요 noh
//	 */
//	private void deletePrdQtyNotPcNo(String hdPctlNo) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			dbDao.deletePrdQtyNotPcNo(hdPctlNo);
//		} catch (DAOException e) {
//			log.error("deletePrdDtlByRank err "+e.toString(),e);
//			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
//			
//		}	
//	}

	/**
	 * (Alps)
	 * @param hdPctlNo
	 * @throws EventException
	 * @deprecated 소스 정리하고 있습니다. 사용하신다면 알려주세요 noh
	 */
//	private void deletePrdDtlByRank(String hdPctlNo) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			dbDao.deletePrdDtlByRank(hdPctlNo);
//		} catch (DAOException e) {
//			log.error("deletePrdDtlByRank err "+e.toString(),e);
//			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
//			
//		}	
//	}

	/**
	 * (Alps)
	 * @param hdPctlNo
	 * @throws EventException
	 * @deprecated 소스 정리하고 있습니다. 사용하신다면 알려주세요 noh
	 */
//	private void deletePrdDtlNotSkd(String hdPctlNo) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			dbDao.deletePrdDtlNotSkd(hdPctlNo);
//		} catch (DAOException e) {
//			log.error("deletePrdDtlNotSkd err "+e.toString(),e);
//			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
//			
//		}	
//	}

	/**
	 * (Alps)
	 * @param e
	 * @throws EventException 
	 */
	private void updateLaneForFrd(String hdPctlNo) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.updateLaneForFrd(hdPctlNo);
		} catch (DAOException e) {
			log.error("UpdateLaneForFrd err "+e.toString(),e);
			throw new EventException( (new ErrorHandler("PRD00003")).getMessage() );
			
		}		
		
	}

	/**
	 * PrdCreateManageBCImpl's updateActivityGroup
	 * @param hdPctlNo
	 * @throws EventException
	 *  미주 IRG상 Route Plan 82/87번을 가진 Local Shuttle 운송에 대하여 Rail Company에 해당 Shuttle 운송계약이 
	 *  포함되어 있으므로 S/O Candidate 불가처리 ,081013
	 */
	public void updateActivityGroup(String hdPctlNo) throws EventException {
		
		try {
//			dbDao.updateActivityGroup(hdPctlNo);
			dbDao.updateActivityGroupForLocShuttleSo(hdPctlNo);
			
		} catch (DAOException e1) {
			log.error("err "+e1.toString(),e1);
			throw new EventException(e1.getMessage());
		}
	}
	
	/**
	 * PrdCreateManageBCImpl's createContainerQty
	 * @param e
	 * @throws EventException
	 */
	public void createContainerQty(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdPcCreateVO prdPcCreateVo =event.getPrdPcCreateVO();
		PrdQuantityVO[] prdQuantityVO= event.getPrdQuantityVOs();
		PrdSubQuantityVO[] prdSubQuantityVO= event.getPrdSubQuantityVOs();
		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 
		DBRowSet dbRowset = null;
		try {
			//생성된 pc만큼 qty 를 만들어 준다.(mst 기준)
			dbRowset = dbDao.selectPrdMst(prdPcCreateVo.getHdPctlNo());
			String newPctlNo ="";
			// sub가 들어오면  REV_... 에   Container Type/Size 를  , CNTR_TPSZ_CD/PCTL_QTY 에  Sub Container Type/Size를 넣는다 
			while (dbRowset.next()) {
				newPctlNo = dbRowset.getString(1);
				log.debug("new pc no :["+newPctlNo+"]prdQuantityVO.length:"+prdQuantityVO.length);
				for (int i = 0; i < prdQuantityVO.length; i++) {
					
					log.debug("\n\n qty  i :["+i+"]prdQuantityVO.:"+prdQuantityVO[i].getCTpsz());
				}
				for (int i = 0; i < prdQuantityVO.length; i++) {
					
					if( prdSubQuantityVO != null && prdSubQuantityVO.length > 0){
						
						dbDao.createContainerQty (newPctlNo, prdSubQuantityVO[i].getSTpsz(), prdSubQuantityVO[i].getSQty(), 
													prdQuantityVO[i].getCTpsz(),prdQuantityVO[i].getCQty(), account.getUsr_id());
					} else {
						
						dbDao.createContainerQty (newPctlNo, prdQuantityVO[i].getCTpsz(), prdQuantityVO[i].getCQty(), 
								                    "", "0" ,account.getUsr_id());
					}
				}
				
			}
			
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}    

	/**
	 * PrdCreateManageBCImpl.java's checkMixedRterm
	 * @param bkgNo
	 * @param por
	 * @param rTerm
	 * @return
	 * @throws EventException
	 */
	public String checkMixedRterm(String bkgNo ,String por, String rTerm) throws EventException {
		
		String retValue = "";
		try {
			if(rTerm.equals("M")) {
				retValue = dbDao.searchMixedRterm(bkgNo ,por);
			} else if(rTerm.equals("I")) {
				retValue = "F";
			} else {
				retValue = rTerm;
			}
 		
			
		} catch (DAOException e1) {
			log.error("err "+e1.toString(),e1);
			throw new EventException(e1.getMessage());
		} 
		return retValue;
		
		
	}	
 
	/**
	 * PrdCreateManageBCImpl.java's checkMixedDterm
	 * @param bkgNo
	 * @param del
	 * @param dTerm
	 * @return
	 * @throws EventException
	 */
	public String checkMixedDterm(String bkgNo ,String del, String dTerm) throws EventException {
		
		String retValue = "";
		try {
			if(dTerm.equals("M")) {
				retValue = dbDao.searchMixedDterm(bkgNo ,del);
			} else if(dTerm.equals("O")) {
				retValue = "F";
			} else {
				retValue = dTerm;
			} 
 		
			
		} catch (DAOException e1) {
			log.error("err "+e1.toString(),e1);
			throw new EventException(e1.getMessage());
		} 
		return retValue;
		
		
	}

	@Override
	public String getSkdType(String vvd, String ldDt, String pol1) throws EventException {
		// TODO Auto-generated method stub
		String sSkdType ="";
		String sSkdDate ="";
		
		vvd = JSPUtil.getNull(vvd);
		ldDt = JSPUtil.getNull(ldDt);
		pol1 = JSPUtil.getNull(pol1);

		if( !"".equals(pol1)) {
			if(!"".equals(vvd)) {
				sSkdType = "V";
			} else if(!ldDt.equals("")) {
				sSkdType = "L";
//				sSkdDate = ldDt;
//				log.debug("\n\n laoddate not null");
			} else {
				sSkdType = "V";
			}
		} else if(!"".equals(vvd)) {
			if(!pol1.equals("")){
				//error 
                throw new EventException(new ErrorHandler("PRD00004").getMessage());
			}
			sSkdType = "V";
			log.debug("\n\n vvd not null");
		} else if("".equals(pol1) && "".equals(vvd) ){
			if(!"".equals(ldDt)) {
				sSkdType = "L";
				sSkdDate = ldDt;
				log.debug("\n\n laoddate not null");
			} 
		}
		return sSkdType;
	}

	@Override
	public Event setPrdCreateParam(PrdParameterVO prdParameterVO)
			throws EventException {
		// TODO Auto-generated method stub
		EsdPrd0080Event event = new EsdPrd0080Event();
		PrdMainInfoVO prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
		PrdCreateParamVO prdCreateParamVO = new PrdCreateParamVO();
		
		prdCreateParamVO.setAkF(prdMainInfoVO.getAkF());
		prdCreateParamVO.setBbF(prdMainInfoVO.getBbF());
		prdCreateParamVO.setBkgNo(prdMainInfoVO.getBkgNo());
		prdCreateParamVO.setBkgOfc(prdMainInfoVO.getBkgOfc());
		prdCreateParamVO.setCgoTp(prdMainInfoVO.getCgoTp());
		prdCreateParamVO.setCngn(prdMainInfoVO.getCngn());
		prdCreateParamVO.setCom(prdMainInfoVO.getCom());
		prdCreateParamVO.setCopyCnt(prdMainInfoVO.getCopyCnt());
		prdCreateParamVO.setDel(prdMainInfoVO.getDel());
		prdCreateParamVO.setDelN(prdMainInfoVO.getDelN());
		prdCreateParamVO.setDelT(prdMainInfoVO.getDelT());
		prdCreateParamVO.setDgF(prdMainInfoVO.getDgF());
		prdCreateParamVO.setDrDt(prdMainInfoVO.getDrDt());
		prdCreateParamVO.setFCmd(prdMainInfoVO.getFCmd());
		prdCreateParamVO.setFRt(prdMainInfoVO.getFRt());
		prdCreateParamVO.setHgF(prdMainInfoVO.getHgF());
		prdCreateParamVO.setHitchment(prdMainInfoVO.getHitchment());
		prdCreateParamVO.setImdg(prdMainInfoVO.getImdg());
		prdCreateParamVO.setLane1(prdMainInfoVO.getLane1());
		prdCreateParamVO.setLane2(prdMainInfoVO.getLane2());
		prdCreateParamVO.setLane3(prdMainInfoVO.getLane3());
		prdCreateParamVO.setLane4(prdMainInfoVO.getLane4());
		prdCreateParamVO.setLdDt(prdMainInfoVO.getLdDt());
		prdCreateParamVO.setMPu(prdMainInfoVO.getMPu());
		prdCreateParamVO.setOrgSalOfc(prdMainInfoVO.getOrgSalOfc());
		prdCreateParamVO.setPcMode(prdMainInfoVO.getPcMode());
		log.debug("\n prdMainInfoVO.getPcMode():"+prdMainInfoVO.getPcMode());
		prdCreateParamVO.setFlexHgtFlg(prdMainInfoVO.getFlexHgtFlg()); // Flex Height parameter 등록 20101005 Park Mangeon

		prdCreateParamVO.setPor(prdMainInfoVO.getPor());
		prdCreateParamVO.setPorN(prdMainInfoVO.getPorN());
		prdCreateParamVO.setPmF(prdMainInfoVO.getPmF());
		prdCreateParamVO.setPod(prdMainInfoVO.getPod());
		prdCreateParamVO.setPod1(prdMainInfoVO.getPod1());
		prdCreateParamVO.setPod1N(prdMainInfoVO.getPod1N());
		prdCreateParamVO.setPod2(prdMainInfoVO.getPod2());
		prdCreateParamVO.setPod2N(prdMainInfoVO.getPod2N());
		prdCreateParamVO.setPod3(prdMainInfoVO.getPod3());
		prdCreateParamVO.setPod3N(prdMainInfoVO.getPod3N());
		prdCreateParamVO.setPod4(prdMainInfoVO.getPod4());
		prdCreateParamVO.setPod4N(prdMainInfoVO.getPod4N());
		prdCreateParamVO.setPodN(prdMainInfoVO.getPodN());
		prdCreateParamVO.setPol(prdMainInfoVO.getPol());
		prdCreateParamVO.setPol1(prdMainInfoVO.getPol1());
		prdCreateParamVO.setPol1N(prdMainInfoVO.getPol1N());
		prdCreateParamVO.setPol2(prdMainInfoVO.getPol2());
		prdCreateParamVO.setPol2N(prdMainInfoVO.getPol2N());
		prdCreateParamVO.setPol3(prdMainInfoVO.getPol3());
		prdCreateParamVO.setPol3N(prdMainInfoVO.getPol3N());
		prdCreateParamVO.setPol4(prdMainInfoVO.getPol4());
		prdCreateParamVO.setPol4N(prdMainInfoVO.getPol4N());
		prdCreateParamVO.setPolN(prdMainInfoVO.getPolN());
		prdCreateParamVO.setRcvT(prdMainInfoVO.getRcvT());
		prdCreateParamVO.setRdF(prdMainInfoVO.getRdF());
		prdCreateParamVO.setRepCom(prdMainInfoVO.getRepCom());
		prdCreateParamVO.setRfa(prdMainInfoVO.getRfa());
		prdCreateParamVO.setRfaOfc(prdMainInfoVO.getRfaOfc());
		prdCreateParamVO.setRfF(prdMainInfoVO.getRfF());
		prdCreateParamVO.setSc(prdMainInfoVO.getSc());
		prdCreateParamVO.setScOfc(prdMainInfoVO.getScOfc());
		prdCreateParamVO.setShpr(prdMainInfoVO.getShpr());
		prdCreateParamVO.setSocF(prdMainInfoVO.getSocF());
		prdCreateParamVO.setSubF(prdMainInfoVO.getSubF());
		prdCreateParamVO.setTVvd(prdMainInfoVO.getTVvd());
		prdCreateParamVO.setVvd1(prdMainInfoVO.getVvd1());
		prdCreateParamVO.setVvd2(prdMainInfoVO.getVvd2());
		prdCreateParamVO.setVvd3(prdMainInfoVO.getVvd3());
		prdCreateParamVO.setVvd4(prdMainInfoVO.getVvd4());
		log.debug("\n booking prdMainInfoVO.getTVvd():"+prdMainInfoVO.getTVvd());
		prdCreateParamVO.setWgt(prdMainInfoVO.getWgt());
		prdCreateParamVO.setWgtUn(prdMainInfoVO.getWgtUn());
		
		prdCreateParamVO.setMtPkupDt(prdMainInfoVO.getMtPkupDt());
		log.debug("\n booking prdMainInfoVO.getMtPkupDt():"+prdMainInfoVO.getMtPkupDt());
		prdCreateParamVO.setObTrspMode(prdMainInfoVO.getOrgTrnsMode());
		prdCreateParamVO.setIbTrspMode(prdMainInfoVO.getDestTrnsMode());
		prdCreateParamVO.setIdaHlgTpCd(prdMainInfoVO.getIdaHlgTpCd());
		
 
		//booking qty
		List<PrdQtyInfoVO> prdQtyInfoVoList = prdParameterVO.getPrdQtyInfo();
		PrdQtyInfoVO prdQtyInfoVO = new PrdQtyInfoVO();
		
		//prd qty
		Collection<PrdQuantityVO> models = new ArrayList<PrdQuantityVO>();
		log.debug("\n booking PrdQtyInfoVoList.size():"+prdQtyInfoVoList.size());
		
		double sumBkgQty = 0;
		String sumCTpSz="";
		
		/*
         * CHM-201111585-01 Container Size별 Empty Pick up CY Data에 대한 Hard Coding 요청.
         * Request By Seon-ju BAEK
		 * TODO: hardcoding, hard coding, 하드코딩, 하드 코딩,(문제시 제거를 용이하도록 검색어 추가)
		 * Empty Pickup이 없으면서  por = pol = BRRIO 이면서 D4만 있는 경우
		 */ 
		if ((prdMainInfoVO.getMPu() == null || prdMainInfoVO.getMPu().equals(""))
			&& "BRRIO".equals(prdMainInfoVO.getPor()) && "BRRIO".equals(prdMainInfoVO.getPol())) {
			boolean onlyCntrD4 = true;
			for (int i = 0; i < prdQtyInfoVoList.size(); i++) {
				if(!"D4".equals(prdQtyInfoVoList.get(i).getCTpsz())
			       && !"D5".equals(prdQtyInfoVoList.get(i).getCTpsz())) {
					onlyCntrD4 = false;
					break;
				}
			}
			if (onlyCntrD4) {
				prdCreateParamVO.setMPu("BRRIOY8");
			}
		}
		/*
         * CHM-201111585 Container Size별 Empty Pick up CY Data에 대한 Hard Coding 요청.
         * 끝
		 */
		StringBuffer SbSumCTpSz =new StringBuffer();
		for (int i = 0; i < prdQtyInfoVoList.size(); i++) {
			PrdQuantityVO prdQuantityVO = new PrdQuantityVO();
			log.debug("\n booking prdQtyInfoVO:"+prdQtyInfoVO.toString());
			prdQtyInfoVO = prdQtyInfoVoList.get(i);
			prdQuantityVO.setCTpsz(prdQtyInfoVO.getCTpsz());
			prdQuantityVO.setCQty(prdQtyInfoVO.getCQty());
			
			sumBkgQty = sumBkgQty +  Double.parseDouble( prdQtyInfoVO.getCQty());
			log.debug("\n sumBkgQty :"+sumBkgQty );
			
			models.add(prdQuantityVO);
			log.debug("\n booking prdQuantityVO:"+prdQuantityVO.getCTpsz());
			
			//htmlAction 에도 같은 로직 추가 
			String tpSz = prdQuantityVO.getCTpsz().substring(0, 1);
			SbSumCTpSz.append(sumCTpSz.indexOf(tpSz) > 0 ? "":tpSz);
			//sumCTpSz = sumCTpSz + (sumCTpSz.indexOf(tpSz) > 0 ? "":tpSz);
			//log.debug("\n booking prdQuantityVO sumCTpSz:"+sumCTpSz);
			
			
		}
		sumCTpSz = SbSumCTpSz.toString();
		log.debug("\n booking prdQuantityVO sumCTpSz:"+sumCTpSz);
		prdCreateParamVO.setSumBkgQty(Double.toString(sumBkgQty));
		prdCreateParamVO.setSumCTpSz( sumCTpSz);
		
		
		PrdQuantityVO[] vos = (PrdQuantityVO[])models.toArray(new PrdQuantityVO[models.size()]);
		
		
		
		log.debug("\n prdParameterVO.getPrdMainInfoVO().getPcMode():"+prdParameterVO.getPrdMainInfoVO().getPcMode());
		
		//booking tro 시 
		if (prdParameterVO.getPrdMainInfoVO().getPcMode().equals(PrdConstants.PRD_PC_MOD_O) || 
				prdParameterVO.getPrdMainInfoVO().getPcMode().equals(PrdConstants.PRD_PC_MOD_I)){
			PrdTroInfoVO bkgPrdTroInfoVO = prdParameterVO.getPrdTroInfoVO();
			// PrdCreateParamVO 에 copy
			prdCreateParamVO.setCntrNo(bkgPrdTroInfoVO.getCntrNo());
			prdCreateParamVO.setDorZone(bkgPrdTroInfoVO.getDorZone());
			prdCreateParamVO.setHaulage(bkgPrdTroInfoVO.getHaulage());
			prdCreateParamVO.setTrMode(bkgPrdTroInfoVO.getTrMode());
			prdCreateParamVO.setTroPkupCy(bkgPrdTroInfoVO.getTroPkupCy());
			prdCreateParamVO.setTroRtnCy(bkgPrdTroInfoVO.getTroRtnCy());
			prdCreateParamVO.setTroSeq(bkgPrdTroInfoVO.getTroSeq());
			prdCreateParamVO.setTroSubSeq(bkgPrdTroInfoVO.getTroSubSeq());
			prdCreateParamVO.setReplaneBndCd(prdParameterVO.getPrdMainInfoVO().getPcMode() );
			prdCreateParamVO.setAreaContiCd(bkgPrdTroInfoVO.getAreaContiCd());
		}
		
		//copy 시 param 
//		prdCreateParamVO.setBkgPctlNo(prdMainInfoVO.getWgtUn());
		
		//double calling 관련 seq 셋팅.
		prdCreateParamVO.setN1stPolDcSeq(prdMainInfoVO.getPol1C());
		prdCreateParamVO.setN1stPodDcSeq(prdMainInfoVO.getPod1C());
		prdCreateParamVO.setN2ndPolDcSeq(prdMainInfoVO.getPol2C());
		prdCreateParamVO.setN2ndPodDcSeq(prdMainInfoVO.getPod2C());
		prdCreateParamVO.setN3rdPolDcSeq(prdMainInfoVO.getPol3C());
		prdCreateParamVO.setN3rdPodDcSeq(prdMainInfoVO.getPod3C());
		prdCreateParamVO.setN4thPolDcSeq(prdMainInfoVO.getPol4C());
		prdCreateParamVO.setN4thPodDcSeq(prdMainInfoVO.getPod4C());

		prdCreateParamVO.setOcnSeq(prdMainInfoVO.getOcnSeq());
		
		
		event.setPrdCreateParamVO(prdCreateParamVO);
		event.setPrdQuantityVOs(vos);
		
		
		
//		PrdQuantityVO[] prdQuantityVOs= event.getPrdQuantityVOs();
//		for (int i = 0; i < prdQuantityVOs.length; i++) {
//			
//			log.debug("\n\n qty  i :["+i+"]prdQuantityVO.:"+prdQuantityVOs[i].getCTpsz());
//		}
		log.debug("\n\n prdCreateParamVO prdCreateParamVO.setFCmd:"+prdCreateParamVO.getFCmd()+
				  "\n ------------------------------------------------" +
				  "\n ------------------------------------------------"  );
		return event;
	}

	/**
	 * PrdCreateManageBCImpl.java's createActivityGroupIncludePattern
	 * @param prdPcCreateVo
	 * @param prdPatternVO
	 * @param usr_id
	 * @throws EventException
	 */
	@Override
	public void createActivityGroupIncludePattern(PrdPcCreateVO prdPcCreateVo,
			PrdPatternVO prdPatternVO, String usr_id) throws EventException {
		 
		String ioBndCd="A";
		String patternStr="";
		String hdPctlNo = prdPcCreateVo.getHdPctlNo();
		String obTroFlg = prdPcCreateVo.getObTroFlg();
		String ibTroFlg = prdPcCreateVo.getIbTroFlg();
		String idaHlgTpCd = prdPcCreateVo.getIdaHlgTpCd();
		String copNo = prdPcCreateVo.getCopNo();
		String bkgNo = prdPcCreateVo.getBkgNo();
		
		if( prdPatternVO == null){
			
			patternStr= "";
		} else {
			
			patternStr= prdPatternVO.getObItchgCtnt()+prdPatternVO.getOcnItchgCtnt()+prdPatternVO.getIbItchgCtnt();
			log.debug("\n before patternStr:"+patternStr);
			patternStr = JSPUtil.replace(patternStr, "%%", "%");
			log.debug("\n after patternStr:"+patternStr);
		}
		log.error("\n patternStr:"+patternStr); 
		
		try {
			dbDao.createActivityGroupIncludePattern(hdPctlNo,ioBndCd,patternStr,usr_id,obTroFlg,ibTroFlg,idaHlgTpCd,copNo,bkgNo);
		} catch (DAOException e1) {
			log.error("err "+e1.toString(),e1);
			throw new EventException(e1.getMessage());
		}
	}	
	
	/**
     * Auto IRG가 생성되어야 하는지 검사하고 필요시 생성함<br>
	 * @param hdPctlNo
	 * @param usrId
	 * @param ofcCd
	 * @throws EventException
	 */
	public void manageAutoIRG(String hdPctlNo, String usrId, String ofcCd) throws EventException {
		try {
			List<PrdProdCtlRoutDtlVO> autoIrgSeqs = dbDao.searchAutoIRGSeq(hdPctlNo);
			InlandRouteManageBC inlandRouteManager = new InlandRouteManageBCImpl();
			if ( autoIrgSeqs != null && autoIrgSeqs.size() > 0 ) {
				String creOfcCd = "SELOPB"; // 조직 변경 20140422 / 자동생성 IRG의 경우 SELOPB로 처리(백선주 대리 요청 20100715)
				PrdProdCtlRoutDtlVO autoIrgParamVO = null;
				for (int i =0; i <autoIrgSeqs.size(); i ++) {
					autoIrgParamVO = (PrdProdCtlRoutDtlVO)autoIrgSeqs.get(i);
					inlandRouteManager.createAutoIRG(autoIrgParamVO, usrId, creOfcCd);
					dbDao.updatePrdDtlByAutoIRG(hdPctlNo, autoIrgParamVO);
				}
			}  			
		} catch (DAOException e1) {
			log.error("err "+e1.toString(),e1);
			throw new EventException(e1.getMessage());
		}
	}

	/**
	 * PrdCreateManageBCImpl.java's checkMixedTermYard
	 * @param term
	 * @param node
	 * @return
	 * @throws EventException
	 */
	public String checkMixedTermYard(String term, String node) throws EventException {
		
		String retValue = "";
		try {
			retValue = dbDao.searchMixedTermNodeValidation(term, node);
		} catch (DAOException e1) {
			log.error("err "+e1.toString(),e1);
			throw new EventException(e1.getMessage());
		} 
		return retValue;

	}
}
